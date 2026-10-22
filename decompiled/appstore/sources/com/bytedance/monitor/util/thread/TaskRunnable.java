package com.bytedance.monitor.util.thread;

/* JADX INFO: loaded from: classes.dex */
public interface TaskRunnable extends Runnable {
    String getTaskName();

    AsyncTaskType getTaskType();
}
