package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.volcengine.zeus.service.PluginService;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadService extends PluginService {
    private static final String TAG = "DownloadService";
    protected IDownloadServiceHandler downloadServiceHandler;

    static {
    }

    public DownloadService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        DownloadComponentManager.setAppContext(this);
        IDownloadServiceHandler r0 = DownloadComponentManager.getDownloadServiceHandler();
        this.downloadServiceHandler = r0;
        r0.setDownloadService(new WeakReference(this));
    }

    public IBinder onBind(Intent r4) {
        if (Logger.debug() == false) goto L9;
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder().append("DownloadServiceHandler != null:");
        if (this.downloadServiceHandler == null) goto L7;
        boolean r2 = true;
    L8:
        Logger.globalDebug(r0, "onBind", r1.append(r2).toString());
        goto L9
    L7:
        r2 = false;
    L9:
        IDownloadServiceHandler r3 = this.downloadServiceHandler;
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.onBind(r4);
    }

    public int onStartCommand(final Intent r4, final int r5, final int r6) {
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "onStartCommand", "Run");
    L16:
        IDownloadServiceHandler r0 = this.downloadServiceHandler;     // Catch: Throwable -> L9
        if (r0 == null) goto L11;
        r0.onStartCommandOnMainThread();     // Catch: Throwable -> L9
    L11:
        ExecutorService r1 = DownloadComponentManager.getCPUThreadExecutor();
        if (r1 == null) goto L18;
        r1.execute(new AnonymousClass1(this, r4, r5, r6));
        return 2;
    L18:
        return 2;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "onDestroy", "Run");
    L5:
        IDownloadServiceHandler r0 = this.downloadServiceHandler;
        if (r0 == null) goto L8;
        r0.onDestroy();
        this.downloadServiceHandler = null;
    L8:
        super/*android.app.Service*/.onDestroy();
    }
}
