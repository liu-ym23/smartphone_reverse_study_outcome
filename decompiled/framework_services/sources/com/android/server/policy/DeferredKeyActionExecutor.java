package com.android.server.policy;

import android.util.SparseArray;
import android.view.KeyEvent;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class DeferredKeyActionExecutor {
    private static final boolean DEBUG = false;
    private static final String TAG = "DeferredKeyAction";
    private final SparseArray<TimedActionsBuffer> mBuffers;

    private static class TimedActionsBuffer {
        private final List<Runnable> mActions;
        private final long mDownTime;
        private boolean mExecutable;
        private final int mKeyCode;

        TimedActionsBuffer(int keyCode, long downTime) {
            this.mActions = new ArrayList();
            this.mKeyCode = keyCode;
            this.mDownTime = downTime;
        }

        long getDownTime() {
            return this.mDownTime;
        }

        void addAction(Runnable action) {
            if (this.mExecutable == false) goto L6;
            action.run();
            return;
        L6:
            this.mActions.add(action);
        }

        void setExecutable() {
            this.mExecutable = true;
            Iterator<Runnable> r0 = this.mActions.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Runnable action = r0.next();
            action.run();
            goto L4
        L6:
            this.mActions.clear();
        }

        void clear() {
            this.mActions.clear();
        }

        void dump(String prefix, PrintWriter pw) {
            if (this.mExecutable == false) goto L5;
            pw.println(prefix + "  " + KeyEvent.keyCodeToString(this.mKeyCode) + ": executable");
            return;
        L5:
            pw.println(prefix + "  " + KeyEvent.keyCodeToString(this.mKeyCode) + ": " + this.mActions.size() + " actions queued");
        }
    }

    DeferredKeyActionExecutor() {
        this.mBuffers = new SparseArray();
    }

    public void queueKeyAction(int keyCode, long downTime, Runnable action) {
        getActionsBufferWithLazyCleanUp(keyCode, downTime).addAction(action);
    }

    public void setActionsExecutable(int keyCode, long downTime) {
        getActionsBufferWithLazyCleanUp(keyCode, downTime).setExecutable();
    }

    public void cancelQueuedAction(int keyCode) {
        TimedActionsBuffer actionsBuffer = this.mBuffers.get(keyCode);
        if (actionsBuffer == null) goto L6;
        actionsBuffer.clear();
        return;
    }

    private TimedActionsBuffer getActionsBufferWithLazyCleanUp(int keyCode, long downTime) {
        TimedActionsBuffer buffer = this.mBuffers.get(keyCode);
        if (buffer != null) goto L5;
    L6:
        TimedActionsBuffer buffer2 = new TimedActionsBuffer(keyCode, downTime);
        this.mBuffers.put(keyCode, buffer2);
        return buffer2;
    L5:
        if (buffer.getDownTime() != downTime) goto L6;
        return buffer;
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.println(prefix + "Deferred key action executor:");
        if (this.mBuffers.size() != 0) goto L6;
        pw.println(prefix + "  empty");
        return;
    L6:
        int i = 0;
    L8:
        if (i >= this.mBuffers.size()) goto L11;
        this.mBuffers.valueAt(i).dump(prefix, pw);
        i = i + 1;
        goto L8
    }
}
