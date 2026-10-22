package com.android.server.backup.remote;

import android.app.backup.IBackupCallback;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.android.internal.util.Preconditions;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes.dex */
public class RemoteCall {
    private final RemoteCallable<IBackupCallback> mCallable;
    private final CompletableFuture<RemoteResult> mFuture;
    private final long mTimeoutMs;

    public static /* synthetic */ void $r8$lambda$XfWnqTsPNSo7AX_pDrZDH6qXb0U(RemoteCall r0) {
        r0.timeOut();
    }

    public static RemoteResult execute(RemoteCallable<IBackupCallback> callable, long timeoutMs) throws RemoteException {
        return new RemoteCall(callable, timeoutMs).call();
    }

    public RemoteCall(RemoteCallable<IBackupCallback> callable, long timeoutMs) {
        this(false, callable, timeoutMs);
    }

    public RemoteCall(boolean cancelled, RemoteCallable<IBackupCallback> callable, long timeoutMs) {
        this.mCallable = callable;
        this.mTimeoutMs = timeoutMs;
        this.mFuture = new CompletableFuture();
        if (cancelled == false) goto L6;
        cancel();
        return;
    }

    public RemoteResult call() throws RemoteException {
        Preconditions.checkState(!Looper.getMainLooper().isCurrentThread(), "Can't call call() on main thread");
        if (this.mFuture.isDone() == false) goto L5;
    L18:
        return this.mFuture.get();
    L17:
        return RemoteResult.FAILED_THREAD_INTERRUPTED;
    L15:
        throw new IllegalStateException("Future unexpectedly completed with an exception");
    L5:
        if (this.mTimeoutMs != 0) goto L7;
        timeOut();
        goto L18
    L7:
        Handler.getMain().postDelayed(new RemoteCall$$ExternalSyntheticLambda0(this), this.mTimeoutMs);
        this.mCallable.call(new FutureBackupCallback(this.mFuture));
        goto L18
    }

    public void cancel() {
        this.mFuture.complete(RemoteResult.FAILED_CANCELLED);
    }

    private void timeOut() {
        this.mFuture.complete(RemoteResult.FAILED_TIMED_OUT);
    }
}
