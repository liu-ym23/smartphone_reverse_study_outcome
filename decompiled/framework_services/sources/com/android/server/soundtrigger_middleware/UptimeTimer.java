package com.android.server.soundtrigger_middleware;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes3.dex */
class UptimeTimer {
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;

    interface Task {
        void cancel();
    }

    private static class TaskImpl implements Task {
        private final Handler mHandler;
        private final Object mToken;

        public TaskImpl(Handler handler, Object token) {
            this.mHandler = handler;
            this.mToken = token;
        }

        @Override // com.android.server.soundtrigger_middleware.UptimeTimer.Task
        public void cancel() {
            this.mHandler.removeCallbacksAndMessages(this.mToken);
        }
    }

    UptimeTimer(String threadName) {
        this.mHandlerThread = new HandlerThread(threadName);
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    Task createTask(Runnable runnable, long uptimeMs) {
        Object token = new Object();
        TaskImpl task = new TaskImpl(this.mHandler, token);
        this.mHandler.postDelayed(runnable, token, uptimeMs);
        return task;
    }

    void quit() {
        this.mHandlerThread.quitSafely();
    }
}
