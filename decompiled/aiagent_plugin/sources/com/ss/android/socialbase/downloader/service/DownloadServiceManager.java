package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.downloader.IDownloadServiceLoader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadServiceManager {
    private static final String DOWNLOAD_SERVICE_LOADER = "com.ss.android.socialbase.downloader.service.DownloadServiceLoader";
    private static final ConcurrentHashMap<Class, Object> SERVICES = null;
    private static final String TAG = "DownloadServiceManager";
    private static String defaultLoadMsg;
    private static volatile boolean isLoadService;

    public DownloadServiceManager() {
    }

    static {
        SERVICES = new ConcurrentHashMap();
        defaultLoadMsg = null;
        isLoadService = false;
    }

    private static void loadDefaultService(String r4) {
        monitor-enter(DownloadServiceManager.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isLoadService == false) goto L9;
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L16
        return;
    L9:
        if (runLoad(r4) == false) goto L13;
        isLoadService = true;     // Catch: Throwable -> L16
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L16
        return;
    L13:
        registerService(IDownloadMonitorHelperService.class, new IDownloadMonitorHelperService.DefaultDownloadMonitorHelperService());     // Catch: Throwable -> L16
        registerService(IDownloadIdGeneratorService.class, new IDownloadIdGeneratorService.DefaultDownloadIdGeneratorService());     // Catch: Throwable -> L16
        registerService(IDownloadComponentManagerService.class, new IDownloadComponentManagerService.DefaultDownloadComponentManagerService());     // Catch: Throwable -> L16
        registerService(IDownloadProcessDispatcherService.class, new IDownloadProcessDispatcherService.DefaultDownloadProcessDispatcherService());     // Catch: Throwable -> L16
        registerService(IDownloadNetTrafficManagerService.class, new IDownloadNetTrafficManagerService.DefaultDownloadNetTrafficManagerService());     // Catch: Throwable -> L16
        registerService(IDownloadNotificationManagerService.class, new IDownloadNotificationManagerService.DefaultDownloadNotificationManagerService());     // Catch: Throwable -> L16
        registerService(IDownloadNetworkService.class, new IDownloadNetworkService.DefaultDownloadNetworkService());     // Catch: Throwable -> L16
        registerService(IDownloadRetrySchedulerService.class, new IDownloadRetrySchedulerService.DefaultDownloadRetrySchedulerService());     // Catch: Throwable -> L16
        registerService(IDownloadMultiProcService.class, new IDownloadMultiProcService.DefaultDownloadMultiProcService());     // Catch: Throwable -> L16
        registerService(IDownloadGlobalThrottleService.class, new IDownloadGlobalThrottleService.DefaultDownloadGlobalThrottleService());     // Catch: Throwable -> L16
        Logger.globalError(TAG, "loadDefaultService", "Run");     // Catch: Throwable -> L16
        isLoadService = true;     // Catch: Throwable -> L16
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L16
    }

    public static void setServiceLoaded() {
        isLoadService = true;
    }

    public static boolean runLoad(String r6) {
        Class r3 = ZeusTransformUtils.forName(r6, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        r3.getMethod("load", new Class[0]).invoke(r3.newInstance(), new Object[0]);     // Catch: Throwable -> L8
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "runLoad", "Run load :" + r6 + " success");     // Catch: Throwable -> L8
        return true;
    L13:
        return true;
    L8:
        th = move-exception;
        defaultLoadMsg = th.toString();
        Logger.globalError(TAG, "runLoad", "Run load :" + r6 + "fail, " + th.toString());
        th.printStackTrace();
        return false;
    }

    public static void loadService(IDownloadServiceLoader r2) {
        IDownloadServiceLoader r3 = (IDownloadServiceLoader) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadServiceLoader.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L10;
        r3.load();
        String r0 = defaultLoadMsg;
        if (r0 != null) goto L7;
        boolean r1 = true;
    L8:
        r3.defaultLoadCallback(r1, r0);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public static <T> void registerService(Class<T> r1, T r2) {
        SERVICES.put(r1, r2);
    }

    public static <T> T getService(Class<T> r1) {
        if (isLoadService == true) goto L6;
        loadDefaultService(DOWNLOAD_SERVICE_LOADER);
    L6:
        return (T) SERVICES.get(r1);
    }
}
