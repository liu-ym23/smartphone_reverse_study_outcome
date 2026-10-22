package com.stepos.launcher.assistant.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;
import s.C5424F;

/* loaded from: classes.dex */
public class LooperExecutor extends AbstractExecutorService implements AutoCloseable {
    private final Handler mHandler;

    public LooperExecutor(Looper looper) {
        this.mHandler = new Handler(looper);
    }

    @Override // java.util.concurrent.ExecutorService
    @Deprecated
    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() throws InterruptedException {
        C5424F.a(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (getHandler().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            getHandler().post(runnable);
        }
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public Looper getLooper() {
        return getHandler().getLooper();
    }

    public Thread getThread() {
        return getHandler().getLooper().getThread();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    public void post(Runnable runnable) {
        getHandler().post(runnable);
    }

    public void setThreadPriority(int i10) throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(((HandlerThread) getThread()).getThreadId(), i10);
    }

    @Override // java.util.concurrent.ExecutorService
    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    @Deprecated
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
