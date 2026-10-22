package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes4.dex */
public interface TaskExecutor {
    boolean canRunTaskImmediately(e r10);

    SequencedTaskRunner createSequencedTaskRunner(e r10);

    SingleThreadTaskRunner createSingleThreadTaskRunner(e r10);

    TaskRunner createTaskRunner(e r10);

    void postDelayedTask(e r10, Runnable r11, long r12);
}
