package android.os;

import android.text.TextUtils;
import android.util.Log;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.ArrayDeque;
import java.util.Deque;

/* loaded from: classes.dex */
public class PerfLog implements IPerfLog {
    private static final int MAX_STACK_DEPTH = 8;
    private static final int SMALL_LOG_CHAR_LENGTH = 256;
    private static final String TAG = "perflog";
    private static final int TASK_ACCT_INFO_SIZE = TaskAcctInfo.values().length;
    private static final ThreadLocal<Deque<SyncFrame>> sFrameStack = new ThreadLocal<Deque<SyncFrame>>() { // from class: android.os.PerfLog.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Deque<SyncFrame> initialValue() {
            return new ArrayDeque(4);
        }
    };

    public static native long nGetTaskCpuTime();

    public static native boolean nMarkTaskBegin(long[] jArr);

    public static native boolean nMarkTaskEnd(long[] jArr);

    public static native void nMarkTaskEndReport(String str, long j, long[] jArr);

    static {
        System.loadLibrary("perflog_jni");
    }

    private static class SyncFrame {
        long dispatchTime;
        long finishTime;
        long planTime;
        final long[] taskAcctInfo;

        private SyncFrame() {
            this.taskAcctInfo = new long[PerfLog.TASK_ACCT_INFO_SIZE];
        }
    }

    private static SyncFrame pushFrame() {
        Deque<SyncFrame> stack = sFrameStack.get();
        if (stack.size() >= 8) {
            Log.w(TAG, "SyncFrame stack overflow (depth=" + stack.size() + "), clearing leaked frames on thread " + Thread.currentThread().getName());
            stack.clear();
        }
        SyncFrame frame = new SyncFrame();
        stack.push(frame);
        return frame;
    }

    private static SyncFrame popFrame() {
        Deque<SyncFrame> stack = sFrameStack.get();
        if (stack.isEmpty()) {
            return null;
        }
        return stack.pop();
    }

    private static long getLatencyTime(SyncFrame frame) {
        return frame.dispatchTime - frame.planTime;
    }

    private static long getWallTime(SyncFrame frame) {
        return frame.finishTime - frame.dispatchTime;
    }

    private static long getTotalTime(SyncFrame frame) {
        return frame.finishTime - frame.planTime;
    }

    public void inputSyncBegin() {
        Trace.beginSection("input_sync");
        SyncFrame frame = pushFrame();
        frame.dispatchTime = SystemClock.uptimeMillis();
        nMarkTaskBegin(frame.taskAcctInfo);
    }

    public void inputSyncEnd(InputEvent event) {
        boolean touchKey;
        String action;
        Trace.endSection();
        SyncFrame frame = popFrame();
        if (frame == null) {
            return;
        }
        frame.finishTime = SystemClock.uptimeMillis();
        frame.planTime = event.getEventTime();
        if (getWallTime(frame) >= 350) {
            String keyCode = "";
            if (event instanceof KeyEvent) {
                KeyEvent keyEvent = (KeyEvent) event;
                touchKey = false;
                keyCode = KeyEvent.keyCodeToString(keyEvent.getKeyCode());
                action = KeyEvent.actionToString(keyEvent.getAction());
            } else if (event instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) event;
                touchKey = true;
                action = MotionEvent.actionToString(motionEvent.getAction());
            } else {
                return;
            }
            StringBuilder blockInfo = new StringBuilder(256);
            blockInfo.append("input_receive");
            if (!touchKey) {
                blockInfo.append(" code=" + keyCode);
            }
            blockInfo.append(" action=" + action);
            blockInfo.append(" latencytime=" + getLatencyTime(frame) + "ms");
            markTaskEndReport(blockInfo.toString(), 350L, frame.taskAcctInfo);
        }
    }

    public void looperSyncBegin() {
        Trace.beginSection("looper_sync");
        SyncFrame frame = pushFrame();
        frame.dispatchTime = SystemClock.uptimeMillis();
        nMarkTaskBegin(frame.taskAcctInfo);
    }

    public void looperSyncEnd(Message msg) {
        Trace.endSection();
        SyncFrame frame = popFrame();
        if (frame == null) {
            return;
        }
        frame.finishTime = SystemClock.uptimeMillis();
        if (getWallTime(frame) >= 1000) {
            String targetName = msg.getTarget() == null ? "" : msg.getTarget().getClass().getName();
            String callbackName = msg.getCallback() != null ? msg.getCallback().getClass().getName() : "";
            if (msg.getWhen() == 0) {
                frame.planTime = msg.enqueueTime;
            } else {
                frame.planTime = msg.getWhen();
            }
            StringBuilder blockInfo = new StringBuilder(256);
            blockInfo.append("looper");
            blockInfo.append(" h=" + targetName);
            if (!TextUtils.isEmpty(callbackName)) {
                blockInfo.append(" c=" + callbackName);
            } else {
                blockInfo.append(" w=" + msg.what);
            }
            blockInfo.append(" latencytime=" + getLatencyTime(frame) + "ms");
            markTaskEndReport(blockInfo.toString(), 1000L, frame.taskAcctInfo);
        }
    }

    public void blockSyncBegin() {
        Trace.beginSection("block_sync");
        SyncFrame frame = pushFrame();
        frame.dispatchTime = SystemClock.uptimeMillis();
        nMarkTaskBegin(frame.taskAcctInfo);
    }

    public void blockSyncEnd(String blockInfo, long timeout) {
        Trace.endSection();
        SyncFrame frame = popFrame();
        if (frame == null) {
            return;
        }
        frame.finishTime = SystemClock.uptimeMillis();
        if (getWallTime(frame) >= timeout) {
            markTaskEndReport(blockInfo, timeout, frame.taskAcctInfo);
        }
    }

    public void perfLogd(String blockInfo) {
        Log.d(TAG, blockInfo);
    }

    public long[] markTaskBegin() {
        long[] taskInfo = new long[TASK_ACCT_INFO_SIZE];
        nMarkTaskBegin(taskInfo);
        return taskInfo;
    }

    public long[] markTaskEnd() {
        long[] taskInfo = new long[TASK_ACCT_INFO_SIZE];
        nMarkTaskEnd(taskInfo);
        return taskInfo;
    }

    public void markTaskEndReport(String blockInfo, long timeout, long[] beginInfo) {
        nMarkTaskEndReport(blockInfo, timeout, beginInfo);
    }
}
