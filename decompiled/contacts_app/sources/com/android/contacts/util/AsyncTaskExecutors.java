package com.android.contacts.util;

import android.os.AsyncTask;
import android.os.Looper;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class AsyncTaskExecutors {
    private static AsyncTaskExecutorFactory mInjectedAsyncTaskExecutorFactory;

    public interface AsyncTaskExecutorFactory {
        AsyncTaskExecutor createAsyncTaskExeuctor();
    }

    private static class SimpleAsyncTaskExecutor implements AsyncTaskExecutor {
        private final Executor mExecutor;

        public SimpleAsyncTaskExecutor(Executor r1) {
            this.mExecutor = r1;
        }

        @Override // com.android.contacts.util.AsyncTaskExecutor
        public <T> AsyncTask<T, ?, ?> submit(Object r2, AsyncTask<T, ?, ?> r3, T... r4) {
            AsyncTaskExecutors.checkCalledFromUiThread();
            return r3.executeOnExecutor(this.mExecutor, r4);
        L5:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("AsyncTaskExecutors", "RejectedExecutionException occured when task execute on SimpleAsyncTaskExecutor.\n" + e);
            return r3.executeOnExecutor(ContactsApplication.getThreadPoolExecutor(), r4);
        }
    }

    static {
    }

    public AsyncTaskExecutors() {
    }

    public static AsyncTaskExecutor createAsyncTaskExecutor() {
        monitor-enter(AsyncTaskExecutors.class);
        AsyncTaskExecutorFactory r1 = mInjectedAsyncTaskExecutorFactory;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        AsyncTaskExecutor r2 = r1.createAsyncTaskExeuctor();     // Catch: Throwable -> L12
        monitor-exit(AsyncTaskExecutors.class);     // Catch: Throwable -> L12
        return r2;
    L9:
        SimpleAsyncTaskExecutor r3 = new SimpleAsyncTaskExecutor(AsyncTask.SERIAL_EXECUTOR);     // Catch: Throwable -> L12
        monitor-exit(AsyncTaskExecutors.class);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    public static AsyncTaskExecutor createThreadPoolExecutor() {
        monitor-enter(AsyncTaskExecutors.class);
        AsyncTaskExecutorFactory r1 = mInjectedAsyncTaskExecutorFactory;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        AsyncTaskExecutor r2 = r1.createAsyncTaskExeuctor();     // Catch: Throwable -> L12
        monitor-exit(AsyncTaskExecutors.class);     // Catch: Throwable -> L12
        return r2;
    L9:
        SimpleAsyncTaskExecutor r3 = new SimpleAsyncTaskExecutor(AsyncTask.THREAD_POOL_EXECUTOR);     // Catch: Throwable -> L12
        monitor-exit(AsyncTaskExecutors.class);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    public static void setFactoryForTest(AsyncTaskExecutorFactory r1) {
        monitor-enter(AsyncTaskExecutors.class);
        mInjectedAsyncTaskExecutorFactory = r1;     // Catch: Throwable -> L7
        monitor-exit(AsyncTaskExecutors.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void checkCalledFromUiThread() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0, "submit method must be called from ui thread, was: " + Thread.currentThread());
        return;
    L5:
        r0 = false;
        goto L6
    }
}
