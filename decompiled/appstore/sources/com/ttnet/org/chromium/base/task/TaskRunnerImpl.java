package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TaskRunnerImpl implements TaskRunner {

    public interface Natives {
        boolean belongsToCurrentThread(long r10);

        void destroy(long r10);

        long init(int r10, int r11, boolean r12, boolean r13, byte r14, byte[] r15);

        void postDelayedTask(long r10, Runnable r11, long r12);
    }

    public abstract void a();
}
