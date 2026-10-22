package com.android.server.ondeviceintelligence.callbacks;

import android.app.ondeviceintelligence.IDownloadCallback;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.RemoteException;
import com.android.internal.infra.AndroidFuture;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class ListenableDownloadCallback extends IDownloadCallback.Stub implements Runnable {
    private final IDownloadCallback callback;
    private final AndroidFuture future;
    private final Handler handler;
    private final long idleTimeoutMs;

    public ListenableDownloadCallback(IDownloadCallback callback, Handler handler, AndroidFuture future, long idleTimeoutMs) {
        this.callback = callback;
        this.handler = handler;
        this.future = future;
        this.idleTimeoutMs = idleTimeoutMs;
        handler.postDelayed(this, idleTimeoutMs);
    }

    public void onDownloadStarted(long bytesToDownload) throws RemoteException {
        this.callback.onDownloadStarted(bytesToDownload);
        this.handler.removeCallbacks(this);
        this.handler.postDelayed(this, this.idleTimeoutMs);
    }

    public void onDownloadProgress(long bytesDownloaded) throws RemoteException {
        this.callback.onDownloadProgress(bytesDownloaded);
        this.handler.removeCallbacks(this);
        this.handler.postDelayed(this, this.idleTimeoutMs);
    }

    public void onDownloadFailed(int failureStatus, String errorMessage, PersistableBundle errorParams) throws RemoteException {
        this.callback.onDownloadFailed(failureStatus, errorMessage, errorParams);
        this.handler.removeCallbacks(this);
        this.future.completeExceptionally(new TimeoutException());
    }

    public void onDownloadCompleted(PersistableBundle downloadParams) throws RemoteException {
        this.callback.onDownloadCompleted(downloadParams);
        this.handler.removeCallbacks(this);
        this.future.complete(null);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.future.completeExceptionally(new TimeoutException());
    }
}
