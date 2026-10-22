package com.bytedance.monitor.util.thread;

import com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public interface IAsyncTaskManager extends IAsyncTaskHandler {

    public interface ExceptionListener {
        void directReportError(Throwable r10, String r11);
    }

    void directReportError(Throwable r10, String r11);

    ExecutorService getIOExecutor();

    ThreadLogListener getThreadLogListener();

    long getWorkThreadId(AsyncTaskType r10);

    void setExceptionListener(ExceptionListener r10);

    void setIOExecutor(ExecutorService r10);

    void setTaskOverTime(AsyncTaskType r10, int r11);
}
