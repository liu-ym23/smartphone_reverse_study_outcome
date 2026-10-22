package com.bytedance.monitor.util.thread;

import com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public interface IAsyncTaskManager extends IAsyncTaskHandler {

    public interface ExceptionListener {
        void directReportError(Throwable r1, String r2);
    }

    void directReportError(Throwable r1, String r2);

    ExecutorService getIOExecutor();

    ThreadLogListener getThreadLogListener();

    long getWorkThreadId(AsyncTaskType r1);

    void setExceptionListener(ExceptionListener r1);

    void setIOExecutor(ExecutorService r1);

    void setTaskOverTime(AsyncTaskType r1, int r2);
}
