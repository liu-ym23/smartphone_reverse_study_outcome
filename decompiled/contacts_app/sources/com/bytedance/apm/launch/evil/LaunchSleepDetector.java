package com.bytedance.apm.launch.evil;

import android.os.Process;
import com.bytedance.apm.launch.LaunchSceneHelper;
import com.bytedance.apm.thread.ApmHandlerThread;
import com.bytedance.apm.thread.AsyncEventManager;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class LaunchSleepDetector {
    private static final long DETECT_INTERVAL = 10;
    private static final String LAUNCH_SLEEP_DETECTOR = "launch_sleep_detector";
    private static final String NATIVE_POLL_ONCE = "MessageQueue.nativePollOnce";
    private static final String PROC_FILE_PATH = "/proc/%d/task/%d/status";
    private static final String REPORT_TAG = "is_launch_sleep";
    private static long TIMER_TO_STOP_DEFAULT = 0;
    private static boolean alreadyAdd = false;
    private static long currentSleepCost = 0;
    private static String currentSleepStack = null;
    private static volatile boolean isStart = false;
    private static State lastState;
    private static long lastSwitchers;
    private static ExecutorService sSleepDetect;
    private static long totalSleepCost;

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DISK_SLEEP = null;
        public static final State NONE = null;
        public static final State NOT_SLEEP = null;
        public static final State SLEEP = null;

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            State r0 = new State("NONE", 0);
            NONE = r0;
            State r1 = new State("SLEEP", 1);
            SLEEP = r1;
            State r3 = new State("NOT_SLEEP", 2);
            NOT_SLEEP = r3;
            State r5 = new State("DISK_SLEEP", 3);
            DISK_SLEEP = r5;
            $VALUES = new State[]{r0, r1, r3, r5};
        }
    }

    public LaunchSleepDetector() {
    }

    static /* synthetic */ boolean access$000() {
        return isStart;
    }

    static /* synthetic */ State access$100() {
        return lastState;
    }

    static /* synthetic */ State access$102(State r0) {
        lastState = r0;
        return r0;
    }

    static /* synthetic */ long access$200() {
        return lastSwitchers;
    }

    static /* synthetic */ long access$202(long r0) {
        lastSwitchers = r0;
        return r0;
    }

    static /* synthetic */ boolean access$300() {
        return alreadyAdd;
    }

    static /* synthetic */ boolean access$302(boolean r0) {
        alreadyAdd = r0;
        return r0;
    }

    static /* synthetic */ String access$400() {
        return currentSleepStack;
    }

    static /* synthetic */ String access$402(String r0) {
        currentSleepStack = r0;
        return r0;
    }

    static /* synthetic */ long access$500() {
        return currentSleepCost;
    }

    static /* synthetic */ long access$502(long r0) {
        currentSleepCost = r0;
        return r0;
    }

    static /* synthetic */ void access$600(long r0, String r2) {
        reportLongSleepData(r0, r2);
    }

    static /* synthetic */ long access$700() {
        return totalSleepCost;
    }

    static /* synthetic */ long access$702(long r0) {
        totalSleepCost = r0;
        return r0;
    }

    static {
        lastState = State.NONE;
        lastSwitchers = -1;
        currentSleepCost = 0;
        currentSleepStack = "";
        TIMER_TO_STOP_DEFAULT = 8000;
        totalSleepCost = 0;
        sSleepDetect = Executors.newSingleThreadExecutor(new AnonymousClass1());
    }

    public static void startDetect() {
        if (LaunchSceneHelper.getFirstActivityIntent() != null) goto L6;
        return;
    L6:
        if (isStart == false) goto L8;
        return;
    L8:
        isStart = true;
        final String r0 = String.format(Locale.US, PROC_FILE_PATH, new Object[]{Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myPid())});
        sSleepDetect.execute(new AnonymousClass2(r0));
        ApmHandlerThread.getDefaultMainHandler().postDelayed(new AnonymousClass3(), TIMER_TO_STOP_DEFAULT);
    }

    public static void stopDetect() {
        if (isStart == true) goto L5;
        return;
    L5:
        isStart = false;
        lastState = State.NONE;
        lastSwitchers = -1;
        currentSleepCost = 0;
        currentSleepStack = "";
    }

    private static void reportLongSleepData(final long r2, final String r4) {
        AsyncEventManager.getInstance().post(new AnonymousClass4(r2, r4));
    }
}
