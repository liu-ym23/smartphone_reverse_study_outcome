package com.bytedance.monitor.util.thread.inner;

import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedance.monitor.util.thread.ThreadLogListener;

/* JADX INFO: loaded from: classes.dex */
public interface IAsyncTaskHandler {
    boolean isPending(TaskRunnable r10);

    void post(TaskRunnable r10);

    void postDelayed(TaskRunnable r10, long r11);

    void release();

    void removeTask(TaskRunnable r10);

    void scheduleWithFixedDelay(TaskRunnable r10, long r11, long r12);

    void setThreadLogListener(ThreadLogListener r10);
}
