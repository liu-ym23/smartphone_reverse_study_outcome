package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultDownloadServiceHandler extends AbsDownloadServiceHandler {
    private static final String TAG = "DefaultDownloadServiceHandler";

    static {
    }

    public DefaultDownloadServiceHandler() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(Context r3, ServiceConnection r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.aiagent.plugin");
        ZeusTransformUtils.startService(r5, new Intent(r5, DownloadService.class), "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        startFakeService();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startFakeService() {
        onStartCommandOnMainThread();
        ExecutorService r0 = DownloadComponentManager.getCPUThreadExecutor();
        if (r0 == null) goto L6;
        r0.execute(new AnonymousClass1(this));
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(Context r3, ServiceConnection r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.aiagent.plugin");
        ZeusTransformUtils.stopService(r5, new Intent(r5, DownloadService.class), "com.obric.aiagent.plugin");
        this.isServiceAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
        this.isServiceAlive = true;
        this.isInvokeStartService.set(false);
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "onStartCommandOnMainThread", "Run");
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(Intent r1, int r2, int r3) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "onStartCommand", "Run");
    L5:
        resumePendingTask();
    }
}
