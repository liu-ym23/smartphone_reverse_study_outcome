package com.bytedance.monitor.util.thread;

/* JADX INFO: loaded from: classes2.dex */
public interface TaskRunnable extends Runnable {
    String getTaskName();

    AsyncTaskType getTaskType();
}
