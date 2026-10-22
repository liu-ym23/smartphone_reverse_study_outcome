package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadThreadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.service.IDownloadMultiProcService;
import com.ss.android.socialbase.downloader.service.IDownloadNetworkService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.p;
import okhttp3.z;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadComponentManager {
    public static final int NET_LIB_DEFAULT = 0;
    public static final int NET_LIB_HOST = 1;
    public static final int NET_LIB_NO_BACKUP = 2;
    private static final String TAG = "DownloadComponentManager";
    private static volatile ExecutorService apkInstallThreadExecutor;
    private static volatile Context appContext;
    private static volatile ExecutorService chunkDownloadExecutor;
    private static volatile ExecutorService cpuThreadExecutor;
    private static volatile ExecutorService customThreadExecutor;
    private static volatile ExecutorService dbThreadExecutor;
    private static volatile IDownloadDns defaultDownloadDns;
    private static volatile IDownloadHttpService defaultHttpService;
    private static volatile IDownloadCache downloadCache;
    private static final List<IDownloadCacheSyncStatusListener> downloadCacheSyncStatusListeners = null;
    private static final List<IDownloadCompleteHandler> downloadCompleteHandlers = null;
    private static volatile IDownloadDBListener downloadDBListener;
    private static volatile IDownloadDns downloadDns;
    private static volatile AbsDownloadEngine downloadEngine;
    private static InnerEventListener downloadEventListener;
    private static volatile boolean downloadInMultiProcess;
    private static volatile IDownloadInterceptor downloadInterceptor;
    private static volatile IDownloadLaunchHandler downloadLaunchHandler;
    private static volatile IDownloadMemoryInfoListener downloadMemoryInfoListener;
    private static volatile IDownloadMonitorListener downloadMonitorListener;
    private static volatile DownloadReceiver downloadReceiver;
    private static volatile IDownloadServiceHandler downloadServiceHandler;
    private static volatile IDownloadSettings downloadSettings;
    private static volatile IDownloadStatusListener downloadStatusListener;
    private static final List<IDownloadTaskExecuteListener> downloadTaskExecuteListeners = null;
    private static volatile boolean enableLruCache;
    private static volatile ExecutorService fastThreadExecutor;
    private static final int fixedCPUPoolSize = 0;
    private static final int fixedDBPoolSize = 0;
    private static final int fixedIOPoolSize = 0;
    private static final int fixedMIXPoolSize = 0;
    private static volatile ExecutorService globalThrottleDownloadExecutor;
    private static volatile boolean hasInit;
    private static volatile IDownloadHttpService httpService;
    private static boolean httpServiceInit;
    private static volatile ITTNetHandler iTTNetHandler;
    private static volatile IDownloadServiceHandler independentDownloadServiceHandler;
    private static volatile IndependentHolderCreator independentHolderCreator;
    private static volatile ExecutorService ioThreadExecutor;
    private static boolean isReceiverRegistered;
    private static volatile ExecutorService mixApkDownloadExecutor;
    private static volatile ExecutorService mixDefaultDownloadExecutor;
    private static volatile ExecutorService mixFrequentDownloadExecutor;
    private static volatile IMonitorConfig monitorConfig;
    private static boolean needAutoRefreshUnSuccessTask;
    private static volatile INotificationClickCallback notificationClickCallback;
    private static volatile ExecutorService okHttpDispatcherExecutor;
    private static volatile List<ProcessCallback> processCallbacks;
    private static IReserveWifiStatusListener reserveWifiStatusListener;
    private static volatile z sOkHttpClient;
    private static volatile ScheduledExecutorService scheduledExecutor;
    private static volatile ExecutorService segmentThreadExecutor;
    private static volatile ExecutorService singleThreadExecutor;
    private static volatile IDownloadThreadCheckListener threadCheckListener;
    private static int writeBufferSize;

    public interface IndependentHolderCreator {

        public interface OnMainProcessRebindErrorListener {
            void onRebindError();
        }

        ISqlDownloadCache createCache(OnMainProcessRebindErrorListener r1);

        IDownloadProxy createProxy();

        IDownloadServiceHandler createServiceHandler();
    }

    @Deprecated
    public static void setNotAutoRebootService(boolean r0) {
    }

    static /* synthetic */ void access$000(boolean r0) {
        registerIndependentService(r0);
    }

    static /* synthetic */ void access$100() {
        registerDownloadReceiver();
    }

    static {
        processCallbacks = new CopyOnWriteArrayList();
        downloadInMultiProcess = false;
        sOkHttpClient = null;
        downloadCompleteHandlers = new ArrayList();
        isReceiverRegistered = false;
        enableLruCache = false;
        int r1 = Runtime.getRuntime().availableProcessors() + 1;
        fixedCPUPoolSize = r1;
        fixedIOPoolSize = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        fixedMIXPoolSize = r1;
        fixedDBPoolSize = r1;
        writeBufferSize = DownloadConstants.TTNET_DEFAULT_BUFFER_SIZE;
        downloadCacheSyncStatusListeners = new ArrayList();
        downloadTaskExecuteListeners = new ArrayList();
        needAutoRefreshUnSuccessTask = true;
        hasInit = false;
        IDownloadMultiProcService r0 = (IDownloadMultiProcService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadMultiProcService.class), IDownloadMultiProcService.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.registerIndependentServiceCreator();
        return;
    }

    private DownloadComponentManager() {
    }

    public static synchronized void initComponent(DownloaderBuilder r3) {
        monitor-enter(DownloadComponentManager.class);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (hasInit == false) goto L9;
        Logger.globalError(TAG, "initComponent", "Component has init");     // Catch: Throwable -> L33
        monitor-exit(DownloadComponentManager.class);
        return;
    L9:
        boolean r1 = downloadInMultiProcess;     // Catch: Throwable -> L33
        setDownloadBuilder(r3);     // Catch: Throwable -> L33
        setLoggerReport();     // Catch: Throwable -> L33
        if (downloadCache != null) goto L13;
        downloadCache = new DefaultDownloadCache();     // Catch: Throwable -> L33
    L13:
        if (downloadServiceHandler != null) goto L16;
        downloadServiceHandler = new DefaultDownloadServiceHandler();     // Catch: Throwable -> L33
    L16:
        if (independentDownloadServiceHandler != null) goto L21;
        if (independentHolderCreator == null) goto L21;
        independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();     // Catch: Throwable -> L33
    L21:
        if (downloadEngine != null) goto L24;
        downloadEngine = new DefaultDownloadEngine();     // Catch: Throwable -> L33
    L24:
        if (downloadInMultiProcess == false) goto L29;
        if (r1 == true) goto L29;
        if (DownloadHelper.isDownloaderProcess() == true) goto L29;
        boolean r4 = true;
    L30:
        registerAsync(r4);     // Catch: Throwable -> L33
        ensureOPPO();     // Catch: Throwable -> L33
        hasInit = true;     // Catch: Throwable -> L33
        monitor-exit(DownloadComponentManager.class);
        return;
    L29:
        r4 = false;
        goto L30
    }

    public static synchronized void coverComponent(DownloaderBuilder r1) {
        monitor-enter(DownloadComponentManager.class);
        setDownloadBuilder(r1);     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void setDownloadBuilder(DownloaderBuilder r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L7;
        setAppContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L7:
        if (r3.getIdGenerator() == null) goto L10;
        setIdGenerator(r3.getIdGenerator());
    L10:
        if (r3.getNotificationClickCallback() == null) goto L13;
        setNotificationClickCallback(r3.getNotificationClickCallback());
    L13:
        if (r3.getHttpService() == null) goto L16;
        setHttpService(r3.getHttpService());
    L16:
        if (r3.getDownloadLaunchHandler() == null) goto L19;
        setDownloadLaunchHandler(r3.getDownloadLaunchHandler());
    L19:
        if (r3.getCPUThreadExecutor() == null) goto L22;
        setCPUThreadExecutor(r3.getCPUThreadExecutor());
    L22:
        if (r3.getIOThreadExecutor() == null) goto L25;
        setIOThreadExecutor(r3.getIOThreadExecutor());
    L25:
        if (r3.getMixDefaultDownloadExecutor() == null) goto L28;
        setMixDefaultDownloadExecutor(r3.getMixDefaultDownloadExecutor());
    L28:
        if (r3.getMixFrequentDownloadExecutor() == null) goto L31;
        setMixFrequentDownloadExecutor(r3.getMixFrequentDownloadExecutor());
    L31:
        if (r3.getMixApkDownloadExecutor() == null) goto L34;
        setMixApkDownloadExecutor(r3.getMixApkDownloadExecutor());
    L34:
        if (r3.getDBThreadExecutor() == null) goto L37;
        setDBThreadExecutor(r3.getDBThreadExecutor());
    L37:
        if (r3.getChunkThreadExecutor() == null) goto L40;
        setChunkDownloadExecutor(r3.getChunkThreadExecutor());
    L40:
        if (r3.getOkHttpDispatcherExecutor() == null) goto L43;
        setOkHttpDispatcherExecutor(r3.getOkHttpDispatcherExecutor());
    L43:
        if (r3.getCustomThreadExecutor() == null) goto L46;
        setCustomThreadExecutor(r3.getCustomThreadExecutor());
    L46:
        if (r3.getDownloadCompleteHandlers().isEmpty() == true) goto L49;
        setDownloadCompleteHandlers(r3.getDownloadCompleteHandlers());
    L49:
        if (r3.getMonitorConfig() == null) goto L52;
        monitorConfig = r3.getMonitorConfig();
    L52:
        if (r3.getWriteBufferSize() <= 1024) goto L55;
        writeBufferSize = r3.getWriteBufferSize();
    L55:
        if (r3.isDownloadInMultiProcess() == false) goto L58;
        downloadInMultiProcess = true;
    L58:
        if (r3.getTTNetHandler() == null) goto L64;
        iTTNetHandler = r3.getTTNetHandler();
        if (iTTNetHandler.isTTNetEnable() == false) goto L62;
        setHttpService(iTTNetHandler.getTTNetDownloadHttpService());
        goto L64
    L62:
        setHttpService(getDefaultHttpService());
    L64:
        if (r3.getDownloadSetting() == null) goto L67;
        setDownloadSetting(r3.getDownloadSetting());
    L67:
        if (r3.getDownloadDns() == null) goto L70;
        downloadDns = r3.getDownloadDns();
    L70:
        if (r3.getDownloadInterceptor() == null) goto L72;
        setDownloadInterceptor(r3.getDownloadInterceptor());
    L72:
        needAutoRefreshUnSuccessTask(r3.needAutoRefreshUnSuccessTask());
        if (r3.getDownloadMonitorListener() == null) goto L77;
        setDownloadMonitorListener(r3.getDownloadMonitorListener());
        return;
    }

    private static void registerAsync(final boolean r1) {
        submitIOTask(new AnonymousClass1(r1));
    }

    private static void setLoggerReport() {
        JSONObject r2 = getDownloadSetting();     // Catch: Throwable -> L37
        int r3 = r2.optInt(DownloadSettingKeys.DOWNLOADER_ALOG_LEVEL);     // Catch: Throwable -> L37
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "setLoggerReport", "ALogLevel:" + r3);     // Catch: Throwable -> L37
    L6:
        if (r3 > 0) goto L8;
        return;
    L8:
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L37
        JSONArray r5 = r2.optJSONArray(DownloadSettingKeys.DOWNLOADER_ALOG_TASK_SCENE_LIST);     // Catch: Throwable -> L37
        int r6 = 0;
        if (r5 != null) goto L11;
    L19:
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L37
        if (r2.optInt(DownloadSettingKeys.DOWNLOADER_LOGGER_GLOBAL_REPORT) <= 0) goto L22;
        boolean r8 = true;
    L23:
        JSONArray r9 = r2.optJSONArray(DownloadSettingKeys.DOWNLOADER_LOGGER_TASK_REPORT_SCENE_LIST);     // Catch: Throwable -> L37
        if (r9 != null) goto L26;
    L33:
        Logger.setLogReportParams(r3, r8, r7, r4);     // Catch: Throwable -> L37
        if (Logger.alog() == false) goto L48;
        Logger.globalDebug(TAG, "setLoggerReport", "Setting: " + getDownloadSetting());     // Catch: Throwable -> L37
        return;
    L48:
        return;
    L26:
        if (r9.length() <= 0) goto L33;
    L28:
        if (r6 >= r9.length()) goto L33;
        String r10 = r9.optString(r6);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r10) == true) goto L32;
        r7.add(r10);     // Catch: Throwable -> L37
    L32:
        r6 = r6 + 1;     // Catch: Throwable -> L37
        goto L28
    L22:
        r8 = false;
        goto L23
    L11:
        if (r5.length() <= 0) goto L19;
        int r11 = 0;
    L14:
        if (r11 >= r5.length()) goto L19;
        String r12 = r5.optString(r11);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r12) == true) goto L18;
        r4.add(r12);     // Catch: Throwable -> L37
    L18:
        r11 = r11 + 1;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Logger.globalError(TAG, "setLoggerReport", "Error:" + th);
    }

    private static void registerIndependentService(boolean r0) {
        if (r0 == false) goto L5;
        DownloadProxy.get(true).startService();
        return;
    }

    private static synchronized void registerDownloadReceiver() {
        monitor-enter(DownloadComponentManager.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (downloadReceiver != null) goto L8;
        downloadReceiver = new DownloadReceiver();     // Catch: Throwable -> L17
    L8:
        if (isReceiverRegistered == false) goto L20;
        monitor-exit(DownloadComponentManager.class);
        return;
    L20:
        IntentFilter r1 = new IntentFilter();     // Catch: Throwable -> L13
        r1.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_MOUNTED");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_UNMOUNTED");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_REMOVED");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_BAD_REMOVAL");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_EJECT");     // Catch: Throwable -> L13
        ZeusTransformUtils.registerReceiver(appContext, downloadReceiver, r1, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        isReceiverRegistered = true;     // Catch: Throwable -> L13
    L15:
        monitor-exit(DownloadComponentManager.class);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
        goto L15
    }

    public static synchronized void unRegisterDownloadReceiver() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.ss.android.socialbase.downloader.downloader.DownloadComponentManager> r0 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class
            monitor-enter(r0)
            boolean r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isReceiverRegistered     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            com.ss.android.socialbase.downloader.downloader.DownloadReceiver r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadReceiver     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            android.content.Context r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.appContext     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            android.content.Context r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.appContext     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            com.ss.android.socialbase.downloader.downloader.DownloadReceiver r2 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadReceiver     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r3 = "com.obric.aiagent.plugin"
            com.volcengine.zeus.transform.ZeusTransformUtils.unregisterReceiver(r1, r2, r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r1 = 0
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isReceiverRegistered = r1     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            goto L22
        L1c:
            r1 = move-exception
            goto L24
        L1e:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L1c
        L22:
            monitor-exit(r0)
            return
        L24:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.unRegisterDownloadReceiver():void");
    }

    public static synchronized void setDownloadInMultiProcess() {
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (downloadInMultiProcess == false) goto L7;
    L18:
        monitor-exit(DownloadComponentManager.class);
        return;
    L7:
        if (supportMultiProc() == false) goto L18;
        Intent r1 = new Intent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), DownloadHandleService.class);     // Catch: Throwable -> L14
        r1.setAction(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY);     // Catch: Throwable -> L14
        ZeusTransformUtils.startService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (DownloadHelper.isDownloaderProcess() == true) goto L12;
        submitIOTask(new AnonymousClass2());     // Catch: Throwable -> L14
    L12:
        downloadInMultiProcess = true;     // Catch: Throwable -> L14
    L16:
        monitor-exit(DownloadComponentManager.class);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L16
    }

    public static synchronized boolean isDownloadInMultiProcess() {
        monitor-enter(DownloadComponentManager.class);
        boolean r1 = downloadInMultiProcess;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static IDownloadHttpService getHttpService() {
        return httpService;
    }

    public static void addProcessCallback(ProcessCallback r2) {
        ProcessCallback r3 = (ProcessCallback) ZeusTransformUtils.wrapperContextForParams(r2, ProcessCallback.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        processCallbacks.add(r3);
    }

    public static List<ProcessCallback> getProcessCallbacks() {
        return processCallbacks;
    }

    public static void addDownloadCompleteHandler(IDownloadCompleteHandler r2) {
        IDownloadCompleteHandler r3 = (IDownloadCompleteHandler) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCompleteHandler.class, "com.obric.aiagent.plugin");
        List<IDownloadCompleteHandler> r0 = downloadCompleteHandlers;
        monitor-enter(r0);
        if (r3 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r3) == true) goto L11;
        r0.add(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static void removeDownloadCompleteHandler(IDownloadCompleteHandler r2) {
        IDownloadCompleteHandler r3 = (IDownloadCompleteHandler) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCompleteHandler.class, "com.obric.aiagent.plugin");
        List<IDownloadCompleteHandler> r0 = downloadCompleteHandlers;
        monitor-enter(r0);
        if (r3 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r3) == false) goto L11;
        r0.remove(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        IDownloadCacheSyncStatusListener r3 = (IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin");
        List<IDownloadCacheSyncStatusListener> r0 = downloadCacheSyncStatusListeners;
        monitor-enter(r0);
        if (r3 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r3) == true) goto L11;
        r0.add(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        IDownloadCacheSyncStatusListener r3 = (IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin");
        List<IDownloadCacheSyncStatusListener> r0 = downloadCacheSyncStatusListeners;
        monitor-enter(r0);
        if (r3 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r3) == false) goto L11;
        r0.remove(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static void registerDownloadTaskExecuteListener(IDownloadTaskExecuteListener r2) {
        IDownloadTaskExecuteListener r3 = (IDownloadTaskExecuteListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadTaskExecuteListener.class, "com.obric.aiagent.plugin");
        List<IDownloadTaskExecuteListener> r0 = downloadTaskExecuteListeners;
        monitor-enter(r0);
        if (r3 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r3) == true) goto L11;
        r0.add(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static void unRegisterDownloadTaskExecuteListener(IDownloadTaskExecuteListener r2) {
        IDownloadTaskExecuteListener r3 = (IDownloadTaskExecuteListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadTaskExecuteListener.class, "com.obric.aiagent.plugin");
        List<IDownloadTaskExecuteListener> r0 = downloadTaskExecuteListeners;
        monitor-enter(r0);
        if (r3 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r3) == false) goto L11;
        r0.remove(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static void onDownloadCacheSyncCallback(DownloadCacheSyncStatus r5) {
        List<IDownloadCacheSyncStatusListener> r0 = downloadCacheSyncStatusListeners;
        monitor-enter(r0);
        Iterator<IDownloadCacheSyncStatusListener> r1 = r0.iterator();     // Catch: Throwable -> L20
    L6:
        if (r1.hasNext() == false) goto L16;
        IDownloadCacheSyncStatusListener r2 = (IDownloadCacheSyncStatusListener) ZeusTransformUtils.preCheckCast(r1.next(), IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r2 == null) goto L6;
        if (r5 == DownloadCacheSyncStatus.SYNC_START) goto L11;
        if (r5 != DownloadCacheSyncStatus.SYNC_SUCCESS) goto L6;
        r2.onSuccess();     // Catch: Throwable -> L20
        goto L6
    L11:
        r2.onStart();     // Catch: Throwable -> L20
        goto L6
    L16:
        if (r5 != DownloadCacheSyncStatus.SYNC_SUCCESS) goto L18;
        downloadCacheSyncStatusListeners.clear();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void onDownloadTaskStart(DownloadTask r5, int r6) {
        List<IDownloadTaskExecuteListener> r0 = downloadTaskExecuteListeners;
        monitor-enter(r0);
        Iterator<IDownloadTaskExecuteListener> r1 = r0.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        IDownloadTaskExecuteListener r2 = (IDownloadTaskExecuteListener) ZeusTransformUtils.preCheckCast(r1.next(), IDownloadTaskExecuteListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r2 == null) goto L6;
        r2.onStart(r5, r6);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void onDownloadTaskFinish(DownloadTask r5, int r6) {
        List<IDownloadTaskExecuteListener> r0 = downloadTaskExecuteListeners;
        monitor-enter(r0);
        Iterator<IDownloadTaskExecuteListener> r1 = r0.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        IDownloadTaskExecuteListener r2 = (IDownloadTaskExecuteListener) ZeusTransformUtils.preCheckCast(r1.next(), IDownloadTaskExecuteListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r2 == null) goto L6;
        r2.onFinish(r5, r6);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static IDownloadMonitorListener getDownloadMonitorListener() {
        return downloadMonitorListener;
    }

    public static IDownloadHttpService getDefaultHttpService() {
        if (defaultHttpService != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (defaultHttpService != null) goto L9;
        defaultHttpService = new DefaultDownloadHttpService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return defaultHttpService;
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean r3, int r4, String r5, List<HttpHeader> r6) {
        List<HttpHeader> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        return ((IDownloadNetworkService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadNetworkService.class), IDownloadNetworkService.class, "com.obric.aiagent.plugin")).downloadWithConnection(r3, r4, r5, r7);
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean r11, int r12, String r13, String r14, List<HttpHeader> r15, int r16, boolean r17, DownloadInfo r18) {
        List<HttpHeader> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        return ((IDownloadNetworkService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadNetworkService.class), IDownloadNetworkService.class, "com.obric.aiagent.plugin")).downloadWithConnection(r11, r12, r13, r14, r7, r16, r17, r18);
    }

    @Deprecated
    public static IDownloadHeadHttpConnection downloadWithHeadConnection(String r3, List<HttpHeader> r4) {
        List<HttpHeader> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        return ((IDownloadNetworkService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadNetworkService.class), IDownloadNetworkService.class, "com.obric.aiagent.plugin")).downloadWithConnection(true, 0, r3, r5);
    }

    public static synchronized void setDownloadLaunchHandler(IDownloadLaunchHandler r3) {
        monitor-enter(DownloadComponentManager.class);
        IDownloadLaunchHandler r4 = (IDownloadLaunchHandler) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadLaunchHandler.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r4 == null) goto L9;
        downloadLaunchHandler = r4;     // Catch: Throwable -> L11
        if (ZeusTransformUtils.instanceOf(downloadCache, DefaultDownloadCache.class) == false) goto L9;
        ((DefaultDownloadCache) ZeusTransformUtils.preCheckCast(downloadCache, DefaultDownloadCache.class, "com.obric.aiagent.plugin")).resumeUnCompleteTaskMayDelayed();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static void setCPUThreadExecutor(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        cpuThreadExecutor = r3;
        return;
    }

    private static void setIOThreadExecutor(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        ioThreadExecutor = r3;
        return;
    }

    private static void setMixDefaultDownloadExecutor(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        mixDefaultDownloadExecutor = r3;
        return;
    }

    private static void setMixFrequentDownloadExecutor(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        mixFrequentDownloadExecutor = r3;
        return;
    }

    private static void setMixApkDownloadExecutor(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        mixApkDownloadExecutor = r3;
        return;
    }

    private static void setDBThreadExecutor(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        dbThreadExecutor = r3;
        return;
    }

    public static void setChunkDownloadExecutor(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        chunkDownloadExecutor = r3;
        return;
    }

    public static void setOkHttpDispatcherExecutor(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        okHttpDispatcherExecutor = r3;
        return;
    }

    public static void setCustomThreadExecutor(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        customThreadExecutor = r3;
        return;
    }

    public static void setDownloadInterceptor(IDownloadInterceptor r2) {
        IDownloadInterceptor r3 = (IDownloadInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadInterceptor.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        downloadInterceptor = r3;
        return;
    }

    public static void setDownloadThreadCheckListener(IDownloadThreadCheckListener r2) {
        IDownloadThreadCheckListener r3 = (IDownloadThreadCheckListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadThreadCheckListener.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        threadCheckListener = r3;
        return;
    }

    private static void setDownloadCompleteHandlers(List<IDownloadCompleteHandler> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<IDownloadCompleteHandler> r0 = downloadCompleteHandlers;
        if (r0.isEmpty() == false) goto L11;
        monitor-enter(r0);
        r0.addAll(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized IMonitorConfig getMonitorConfig() {
        monitor-enter(DownloadComponentManager.class);
        IMonitorConfig r1 = monitorConfig;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void submitCPUTask(Runnable r2) {
        submitCPUTask((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), false);
    }

    public static void submitIOTask(Runnable r2) {
        submitIOTask((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), false);
    }

    public static void submitCPUTask(Runnable r2, boolean r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
    L9:
        getCPUThreadExecutor().execute(r4);
        return;
    L7:
        if (DownloadUtils.isMainThread() == true) goto L9;
        r4.run();
    }

    public static void submitIOTask(Runnable r2, boolean r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
    L9:
        getIOThreadExecutor().execute(r4);
        return;
    L7:
        if (DownloadUtils.isMainThread() == true) goto L9;
        r4.run();
    }

    public static void submitDBTask(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L6;
        return;
    L6:
        if (DownloadUtils.isMainThread() == true) goto L8;
        r3.run();
        return;
    L8:
        getDBThreadExecutorService().execute(r3);
    }

    public static void submitSingleTask(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        getSingleThreadExecutorService().execute(r3);
    }

    public static Future submitScheduleTask(Runnable r2, long r3, TimeUnit r5) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return getScheduledExecutorService().schedule(r4, r3, r5);
    }

    public static ExecutorService getCPUThreadExecutor() {
        if (cpuThreadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (cpuThreadExecutor != null) goto L18;
        int r4 = fixedCPUPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-cpu-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        cpuThreadExecutor = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return cpuThreadExecutor;
    }

    public static ExecutorService getApkInstallThreadExecutor() {
        if (apkInstallThreadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (apkInstallThreadExecutor == null) goto L9;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
        goto L24
    L9:
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 15;
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(2, 2, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-apk-install", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        apkInstallThreadExecutor = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 60;
    L24:
        return apkInstallThreadExecutor;
    }

    public static ExecutorService getIOThreadExecutor() {
        if (ioThreadExecutor == null) goto L6;
        return ioThreadExecutor;
    L6:
        return getCPUThreadExecutor();
    }

    public static ExecutorService getMixFrequentThreadExecutor() {
        if (mixFrequentDownloadExecutor == null) goto L6;
        return mixFrequentDownloadExecutor;
    L6:
        return getMixDefaultThreadExecutor();
    }

    public static ExecutorService getMixApkThreadExecutor() {
        if (mixApkDownloadExecutor == null) goto L6;
        return mixApkDownloadExecutor;
    L6:
        return getMixDefaultThreadExecutor();
    }

    public static ExecutorService getMixDefaultThreadExecutor() {
        if (mixDefaultDownloadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (mixDefaultDownloadExecutor != null) goto L18;
        int r4 = fixedMIXPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-mix-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        mixDefaultDownloadExecutor = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return mixDefaultDownloadExecutor;
    }

    public static ExecutorService getGlobalThrottleThreadExecutor() {
        if (globalThrottleDownloadExecutor != null) goto L25;
        monitor-enter(DownloadComponentManager.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (globalThrottleDownloadExecutor != null) goto L19;
        int r1 = fixedMIXPoolSize;     // Catch: Throwable -> L21
        int r2 = r1 * 2;     // Catch: Throwable -> L21
        long r3 = 15;
        if (isThrottleThreadPoolOptEnabled() == false) goto L11;
        r3 = 8;
        int r6 = r1;
    L12:
        int r7 = r1 * 2;     // Catch: Throwable -> L21
        ThreadPoolExecutor r4 = new ThreadPoolExecutor(r6, r7, r3, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-global-throttle", true));     // Catch: Throwable -> L21
        if (isThrottleThreadPoolOptEnabled() == true) goto L28;
    L18:
        globalThrottleDownloadExecutor = r4;     // Catch: Throwable -> L21
        goto L19
    L28:
        r4.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    L11:
        r6 = r2;
    L19:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L21
    L25:
        return globalThrottleDownloadExecutor;
    }

    public static ExecutorService getChunkDownloadThreadExecutorService() {
        if (chunkDownloadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (chunkDownloadExecutor != null) goto L18;
        int r4 = fixedIOPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-chunk-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        chunkDownloadExecutor = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return chunkDownloadExecutor;
    }

    public static ExecutorService getSegmentDownloadThreadExecutorService() {
        if (segmentThreadExecutor != null) goto L20;
        monitor-enter(DownloadComponentManager.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (segmentThreadExecutor != null) goto L14;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-segment-fixed", true));     // Catch: Throwable -> L16
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L13:
        segmentThreadExecutor = r1;     // Catch: Throwable -> L16
        goto L14
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L14:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L16
    L20:
        return segmentThreadExecutor;
    }

    static boolean isGlobalThreadPoolOptEnabled() {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_GLOBAL_THREAD_POOL_OPT, 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    static boolean isThrottleThreadPoolOptEnabled() {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_THROTTLE_THREAD_POOL_OPT, 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static ExecutorService getDBThreadExecutorService() {
        if (dbThreadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (dbThreadExecutor != null) goto L18;
        int r4 = fixedDBPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-db-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        dbThreadExecutor = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return dbThreadExecutor;
    }

    public static ExecutorService getSingleThreadExecutorService() {
        if (singleThreadExecutor != null) goto L25;
        monitor-enter(DownloadComponentManager.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (singleThreadExecutor == null) goto L9;
    L19:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L21
        goto L25
    L9:
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r5 = 30;
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(1, 1, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-Single", true));     // Catch: Throwable -> L21
        if (isGlobalThreadPoolOptEnabled() == true) goto L26;
    L18:
        singleThreadExecutor = r1;     // Catch: Throwable -> L21
        goto L19
    L26:
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    L11:
        r5 = 60;
    L25:
        return singleThreadExecutor;
    }

    public static ExecutorService getCustomThreadExecutor() {
        return customThreadExecutor;
    }

    public static z getDownloadClient() {
        if (sOkHttpClient != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sOkHttpClient != null) goto L9;
        sOkHttpClient = createDownloadClientBuilder().E();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return sOkHttpClient;
    }

    public static ScheduledExecutorService getScheduledExecutorService() {
        if (scheduledExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (scheduledExecutor != null) goto L9;
        scheduledExecutor = new ScheduledThreadPoolExecutor(4, new DefaultThreadFactory("DownloadThreadPool-Schedule", true));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return scheduledExecutor;
    }

    public static z.a createDownloadClientBuilder() {
        z.a r0 = new z.a();
        int r1 = DownloadSetting.getGlobalSettings().optInt("connect_timeout", 30000);
        long r2 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.IO_TIMEOUT, 30000);
        r0.a(r1, TimeUnit.MILLISECONDS).b(r2, TimeUnit.MILLISECONDS).c(r2, TimeUnit.MILLISECONDS).a(true).b(true).b(Collections.singletonList(aa.f39695c));
        if (okHttpDispatcherExecutor == null) goto L5;
        r0.a(new p(okHttpDispatcherExecutor));
    L5:
        return r0;
    }

    public static ExecutorService getFastThreadExecutor() {
        if (fastThreadExecutor != null) goto L22;
        monitor-enter(DownloadComponentManager.class);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (fastThreadExecutor != null) goto L16;
        int r1 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.FAST_DOWNLOAD_THREAD_POOL_SIZE_LIMIT);     // Catch: Throwable -> L18
        if (r1 > 0) goto L11;
        r1 = 20;
    L11:
        int r4 = r1;
        if (isGlobalThreadPoolOptEnabled() == false) goto L14;
        long r5 = 15;
    L15:
        fastThreadExecutor = new ThreadPoolExecutor(0, r4, r5, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("DownloadThreadPool-Fast", true));     // Catch: Throwable -> L18
        goto L16
    L14:
        r5 = 60;
    L16:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L18
    L22:
        return fastThreadExecutor;
    }

    public static IDownloadDns getDownloadDns() {
        return downloadDns;
    }

    public static IDownloadDns getDefaultDownloadDns() {
        if (defaultDownloadDns != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (defaultDownloadDns != null) goto L9;
        defaultDownloadDns = new AnonymousClass3();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return defaultDownloadDns;
    }

    public static synchronized IDownloadLaunchHandler getDownloadLaunchHandler() {
        monitor-enter(DownloadComponentManager.class);
        IDownloadLaunchHandler r1 = downloadLaunchHandler;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setHttpService(IDownloadHttpService r2) {
        IDownloadHttpService r3 = (IDownloadHttpService) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadHttpService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        httpService = r3;
    L6:
        if (httpService == null) goto L8;
        boolean r4 = true;
    L9:
        httpServiceInit = r4;
        return;
    L8:
        r4 = false;
        goto L9
    }

    public static IDownloadCache getDownloadCache() {
        if (downloadCache != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (downloadCache != null) goto L9;
        downloadCache = new DefaultDownloadCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return downloadCache;
    }

    public static IDownloadServiceHandler getDownloadServiceHandler() {
        if (downloadServiceHandler != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (downloadServiceHandler != null) goto L9;
        downloadServiceHandler = new DefaultDownloadServiceHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return downloadServiceHandler;
    }

    public static IDownloadServiceHandler getIndependentDownloadServiceHandler() {
        if (independentDownloadServiceHandler != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (independentDownloadServiceHandler != null) goto L9;
        independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return independentDownloadServiceHandler;
    }

    public static List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return downloadCompleteHandlers;
    }

    public static AbsDownloadEngine getDownloadEngine() {
        if (downloadEngine != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (downloadEngine != null) goto L9;
        downloadEngine = new DefaultDownloadEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return downloadEngine;
    }

    private static void setIdGenerator(IDownloadIdGenerator r3) {
        IDownloadIdGenerator r4 = (IDownloadIdGenerator) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadIdGenerator.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        ((IDownloadIdGeneratorService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadIdGeneratorService.class), IDownloadIdGeneratorService.class, "com.obric.aiagent.plugin")).setDownloadIdGenerator(r4);
        return;
    }

    public static void setDownloadMonitorListener(IDownloadMonitorListener r2) {
        IDownloadMonitorListener r3 = (IDownloadMonitorListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMonitorListener.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        downloadMonitorListener = r3;
        return;
    }

    public static JSONObject getDownloadSetting() {
        if (downloadSettings == null) goto L5;
        JSONObject r0 = downloadSettings.get();
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return DownloadConstants.EMPTY_JSON;
    L5:
        r0 = null;
        goto L6
    }

    public static JSONObject getDownloadTNCSetting() {
        JSONObject r0 = getDownloadSetting();
        if (r0.optInt(DownloadSettingKeys.ENABLE_TTNET_TNC_SETTING) > 0) goto L5;
        return r0;
    L5:
        if (iTTNetHandler != null) goto L8;
        return r0;
    L8:
        return iTTNetHandler.mergeTNCConfig(r0);
    }

    public static void ensureOPPO() {
        if (TextUtils.isEmpty(DownloadConstants.LOWER_OPPO) == false) goto L6;
        DownloadConstants.LOWER_OPPO = "oppo";
        DownloadConstants.UPPER_OPPO = DownloadConstants.LOWER_OPPO.toUpperCase();
        return;
    }

    public static void setDownloadSetting(IDownloadSettings r2) {
        downloadSettings = (IDownloadSettings) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadSettings.class, "com.obric.aiagent.plugin");
        DownloadSetting.init();
    }

    private static void needAutoRefreshUnSuccessTask(boolean r0) {
        needAutoRefreshUnSuccessTask = r0;
    }

    public static boolean needAutoRefreshUnSuccessTask() {
        return needAutoRefreshUnSuccessTask;
    }

    public static void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r2) {
        downloadMemoryInfoListener = (IDownloadMemoryInfoListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMemoryInfoListener.class, "com.obric.aiagent.plugin");
    }

    public static IDownloadMemoryInfoListener getDownloadMemoryInfoListener() {
        return downloadMemoryInfoListener;
    }

    public static void setDownloadDBListener(IDownloadDBListener r2) {
        downloadDBListener = (IDownloadDBListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadDBListener.class, "com.obric.aiagent.plugin");
    }

    public static IDownloadDBListener getDownloadDBListener() {
        return downloadDBListener;
    }

    public static IDownloadStatusListener getDownloadStatusListener() {
        return downloadStatusListener;
    }

    public static void setDownloadStatusListener(IDownloadStatusListener r2) {
        downloadStatusListener = (IDownloadStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadStatusListener.class, "com.obric.aiagent.plugin");
    }

    public static void initDownloadCacheImmediately() {
        getDownloadCache().initImmediately();
    }

    public static int getWriteBufferSize() {
        return writeBufferSize;
    }

    public static void setNotificationClickCallback(INotificationClickCallback r2) {
        INotificationClickCallback r3 = (INotificationClickCallback) ZeusTransformUtils.wrapperContextForParams(r2, INotificationClickCallback.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        notificationClickCallback = r3;
        return;
    }

    public static INotificationClickCallback getNotificationClickCallback() {
        return notificationClickCallback;
    }

    public static ITTNetHandler getTTNetHandler() {
        if (iTTNetHandler != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (iTTNetHandler != null) goto L9;
        iTTNetHandler = new ITTNetHandler.DefaultTTNetHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return iTTNetHandler;
    }

    public static IDownloadInterceptor getDownloadInterceptor() {
        return downloadInterceptor;
    }

    public static IDownloadThreadCheckListener getDownloadThreadCheckListener() {
        return threadCheckListener;
    }

    public static synchronized Context getAppContext() {
        monitor-enter(DownloadComponentManager.class);
        Context r1 = appContext;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setAppContext(Context r5) {
        monitor-enter(DownloadComponentManager.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r6 != null) goto L7;
    L11:
        monitor-exit(DownloadComponentManager.class);
        return;
    L7:
        if (appContext != null) goto L11;
        appContext = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        AppStatusManager.getInstance().init(appContext);     // Catch: Throwable -> L13
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "setAppContext", "Context:" + r6);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public static int getDownloadId(DownloadInfo r3) {
        return ((IDownloadIdGeneratorService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadIdGeneratorService.class), IDownloadIdGeneratorService.class, "com.obric.aiagent.plugin")).generate(r3);
    }

    public static int getDownloadId(String r3, String r4) {
        return ((IDownloadIdGeneratorService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadIdGeneratorService.class), IDownloadIdGeneratorService.class, "com.obric.aiagent.plugin")).generate(r3, r4);
    }

    public static synchronized boolean isHttpServiceInit() {
        monitor-enter(DownloadComponentManager.class);
        boolean r1 = httpServiceInit;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static InnerEventListener getEventListener() {
        if (downloadEventListener != null) goto L6;
        downloadEventListener = new AnonymousClass4();
    L6:
        return downloadEventListener;
    }

    public static IReserveWifiStatusListener getReserveWifiStatusListener() {
        return reserveWifiStatusListener;
    }

    public static void setDownloadEventListener(InnerEventListener r2) {
        downloadEventListener = (InnerEventListener) ZeusTransformUtils.wrapperContextForParams(r2, InnerEventListener.class, "com.obric.aiagent.plugin");
    }

    public static void setReserveWifiStatusListener(IReserveWifiStatusListener r2) {
        reserveWifiStatusListener = (IReserveWifiStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IReserveWifiStatusListener.class, "com.obric.aiagent.plugin");
    }

    public static boolean isInit() {
        return hasInit;
    }

    public static void setIndependentServiceCreator(IndependentHolderCreator r3) {
        IndependentHolderCreator r4 = (IndependentHolderCreator) ZeusTransformUtils.wrapperContextForParams(r3, IndependentHolderCreator.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "setIndependentServiceCreator", "Creator: " + r4);
    L5:
        independentHolderCreator = r4;
    }

    public static boolean supportMultiProc() {
        if (independentHolderCreator == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static IndependentHolderCreator getIndependentHolderCreator() {
        return independentHolderCreator;
    }

    public static void updateCurrentDownloadThreadInfo(DownloadTask r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.getDownloadInfo().isFastDownload() == true) goto L15;
        if (r2 == false) goto L8;
        Map<String, DownloadThreadInfo.ThreadExecutorInfo> r3 = r1.getThreadInfo().beforeDownloadThreadExecutors;
    L10:
        if (r3.isEmpty() == true) goto L12;
        return;
    L12:
        r3.put(MonitorConstants.CPU, DownloadThreadInfo.parse(cpuThreadExecutor));
        r3.put(MonitorConstants.IO, DownloadThreadInfo.parse(ioThreadExecutor));
        r3.put(MonitorConstants.MIX_DEFAULT, DownloadThreadInfo.parse(mixDefaultDownloadExecutor));
        r3.put(MonitorConstants.MIX_APK, DownloadThreadInfo.parse(mixApkDownloadExecutor));
        r3.put(MonitorConstants.DB, DownloadThreadInfo.parse(dbThreadExecutor));
        r3.put(MonitorConstants.CHUNK, DownloadThreadInfo.parse(chunkDownloadExecutor));
        r3.put(MonitorConstants.SEGMENT, DownloadThreadInfo.parse(segmentThreadExecutor));
        r3.put(MonitorConstants.OKHTTP, DownloadThreadInfo.parse(okHttpDispatcherExecutor));
        r3.put(MonitorConstants.SCHEDULE, DownloadThreadInfo.parse(scheduledExecutor));
        r3.put(MonitorConstants.SINGLE, DownloadThreadInfo.parse(singleThreadExecutor));
        r3.put(MonitorConstants.CUSTOM, DownloadThreadInfo.parse(customThreadExecutor));
        return;
    L8:
        r3 = r1.getThreadInfo().afterDownloadThreadExecutors;
        goto L10
    }

    public static void enableLruCache() {
        enableLruCache = true;
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "enableLruCache", "Run");
        return;
    }

    public static boolean isEnableLruCache() {
        return enableLruCache;
    }

    public static long clearAllDownloadCache(boolean r12) {
        long r2 = 0;
        IDownloadCache r4 = getDownloadCache();     // Catch: Throwable -> L29
        boolean r5 = r4.ensureDownloadCacheSyncSuccess();     // Catch: Throwable -> L29
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "DownloadCache sync:" + r5);     // Catch: Throwable -> L29
    L6:
        List<DownloadInfo> r6 = r4.getAllDownloadInfo();     // Catch: Throwable -> L29
        if (r6 == null) goto L9;
        AbsDownloadEngine r7 = getDownloadEngine();     // Catch: Throwable -> L29
        Iterator<DownloadInfo> r8 = r6.iterator();     // Catch: Throwable -> L29
        long r9 = 0;
    L38:
        if (r8.hasNext() == false) goto L35;
        DownloadInfo r10 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r8.next(), DownloadInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r7.isDownloading(r10.getId()) == true) goto L38;
        if (DownloadDirUtils.isSavePathSecurity(r10.getSavePath()) == false) goto L38;
        if (r10.getCurBytes() <= 0) goto L24;
        r9 = r9 + r10.getCurBytes();     // Catch: Throwable -> L27
    L24:
        if (r12 == false) goto L38;
        r4.removeDownloadTaskData(r10.getId());     // Catch: Throwable -> L27
        DownloadUtils.clearDownloadFile(r10.getSavePath(), r10.getTempPath(), r10.getName());     // Catch: Throwable -> L27
    L35:
        if (Logger.debug() == false) goto L37;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "ClearSize:" + r9 + " clear:" + r12);
    L37:
        return r9;
    L27:
        th = th;
        r2 = r9;
    L30:
        th.printStackTrace();
        if (Logger.debug() == false) goto L33;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "Error:" + th);
    L33:
        r9 = r2;
        goto L35
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "DownloadInfos is null");     // Catch: Throwable -> L29
    L11:
        return 0;
    L29:
        th = th;
        goto L30
    }
}
