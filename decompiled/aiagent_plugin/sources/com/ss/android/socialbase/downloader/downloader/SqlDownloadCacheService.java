package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class SqlDownloadCacheService extends PluginService {
    private static final String TAG = "SqlDownloadCacheService";

    static {
    }

    public int onStartCommand(Intent r1, int r2, int r3) {
        return 2;
    }

    public SqlDownloadCacheService() {
    }

    public static void startServiceAndBind(Context r3, ServiceConnection r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        Intent r0 = new Intent(r5, SqlDownloadCacheService.class);     // Catch: Throwable -> L9
        if (r6 == null) goto L7;
        ZeusTransformUtils.bindService(r5, r0, r6, 1, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L7:
        ZeusTransformUtils.startService(r5, r0, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "startServiceAndBind", "Exception:" + th.toString());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        DownloadComponentManager.setAppContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public IBinder onBind(Intent r2) {
        IDownloadCache r1 = DownloadComponentManager.getDownloadCache();
        if (ZeusTransformUtils.instanceOf(r1, DefaultDownloadCache.class) == false) goto L6;
        ISqlDownloadCache r3 = ((DefaultDownloadCache) ZeusTransformUtils.preCheckCast(r1, DefaultDownloadCache.class, "com.obric.aiagent.plugin")).getSqlDownloadCache();
    L10:
        if (ZeusTransformUtils.instanceOf(r3, IBinder.class) == false) goto L14;
        return (IBinder) ZeusTransformUtils.preCheckCast(r3, IBinder.class, "com.obric.aiagent.plugin");
    L14:
        return new Binder();
    L6:
        if (ZeusTransformUtils.instanceOf(r1, ISqlDownloadCache.class) == false) goto L8;
        r3 = (ISqlDownloadCache) ZeusTransformUtils.preCheckCast(r1, ISqlDownloadCache.class, "com.obric.aiagent.plugin");
        goto L10
    L8:
        r3 = null;
        goto L10
    }
}
