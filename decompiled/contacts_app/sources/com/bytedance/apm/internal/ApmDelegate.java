package com.bytedance.apm.internal;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.ApmProgressListener;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.alog.AlogActiveUploadManager;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.alog.IALogActiveUploadCallback;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.apm.alog.net.AlogUploadService;
import com.bytedance.apm.battery.BatteryWidget;
import com.bytedance.apm.block.BlockDetector;
import com.bytedance.apm.block.trace.FrameTracer;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.config.ApmInitConfig;
import com.bytedance.apm.config.ApmReportConfig;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.constant.CommonConsts;
import com.bytedance.apm.constant.ReportUrl;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.BaseDataPipeline;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.doctor.DoctorConstants;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.launch.evil.LaunchEvilMethodManager;
import com.bytedance.apm.listener.IApmStartListener;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.observer.LogObserver;
import com.bytedance.apm.perf.PerfConfigManager;
import com.bytedance.apm.perf.StorageCollector;
import com.bytedance.apm.perf.ThreadCollector;
import com.bytedance.apm.perf.memory.DetectActivityLeakTask;
import com.bytedance.apm.perf.traffic.TrafficCollector;
import com.bytedance.apm.report.FileUploadServiceImpl;
import com.bytedance.apm.sampler.DefaultSampler;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.ApmHandlerThread;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.ITraceListener;
import com.bytedance.apm.trace.PageTimeMonitor;
import com.bytedance.apm.trace.TraceConfig;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.bytedance.apm.util.AppUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.apm.util.StackUtils;
import com.bytedance.apm6.Apm6;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.consumer.slardar.LogReporter;
import com.bytedance.apm6.consumer.slardar.send.LogReportController;
import com.bytedance.apm6.disk.DiskCollector;
import com.bytedance.apm6.hub.Apm;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.crash.NpthApi;
import com.bytedance.frameworks.baselib.log.SlardarLogConstants;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.monitor.collector.Util;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.perf.monitor.EvilMethodTracer;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.bytedance.services.apm.api.IWidget;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import com.bytedance.services.apm.api.WidgetParams;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApmDelegate implements IConfigListener {
    private static boolean sEvilMethodTraceEnable;
    private static long sEvilThresholdMs;
    private static boolean sLimitEvilMethodDepth;
    boolean isBlockInited;
    private ApmInitConfig mApmInitConfig;
    private ApmStartConfig mApmStartConfig;
    private IApmStartListener mApmStartListener;
    private volatile boolean mConfigReady;
    private List<String> mDefaultCongfigUrlsCompat;
    private List<String> mDefaultLogReportUrlsCompat;
    private boolean mEnableActiveUploadAlog;
    private IEncrypt mEncrypt;
    private List<String> mExceptionLogReportUrlsCompat;
    private volatile boolean mInited;
    private boolean mIsMainProcess;
    private SlardarConfigManagerImpl mSlardarConfigManager;
    private volatile boolean mStarted;
    private TraceConfig mTraceConfig;
    private ITraceListener mTraceListener;
    private Set<IWidget> mWidgetSet;

    private static class Holder {
        private static final ApmDelegate sInstance = null;

        private Holder() {
        }

        static /* synthetic */ ApmDelegate access$000() {
            return sInstance;
        }

        static {
            sInstance = new ApmDelegate(null);
        }
    }

    private void initEvilMethodTraceInject() {
    }

    private void initMethodTrace(Application r1) {
    }

    @Deprecated
    public void clearBufferLog() {
    }

    @Deprecated
    public void clearBufferLogSync() {
    }

    @Deprecated
    public void clearLegacyLog(long r1) {
    }

    @Deprecated
    public void clearLegacyLogSync(long r1) {
    }

    public void setReportConfig(ApmReportConfig r1) {
    }

    /* synthetic */ ApmDelegate(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ SlardarConfigManagerImpl access$200(ApmDelegate r0) {
        return r0.mSlardarConfigManager;
    }

    static /* synthetic */ boolean access$300(ApmDelegate r0) {
        return r0.mIsMainProcess;
    }

    static /* synthetic */ ApmInitConfig access$400(ApmDelegate r0) {
        return r0.mApmInitConfig;
    }

    static /* synthetic */ void access$500(ApmDelegate r0) {
        r0.startInternalSafely();
    }

    static /* synthetic */ void access$600(ApmDelegate r0, ApmStartConfig r1) {
        r0.restartInternal(r1);
    }

    static /* synthetic */ ApmStartConfig access$700(ApmDelegate r0) {
        return r0.mApmStartConfig;
    }

    static /* synthetic */ Set access$800(ApmDelegate r0) {
        return r0.mWidgetSet;
    }

    private ApmDelegate() {
        this.isBlockInited = false;
        this.mEnableActiveUploadAlog = true;
    }

    public static ApmDelegate getInstance() {
        return Holder.access$000();
    }

    @Deprecated
    public void setTraceConfig(TraceConfig r1) {
        if (r1 == null) goto L5;
        this.mTraceConfig = r1;
        return;
    }

    @Deprecated
    public void setTraceListener(ITraceListener r1) {
        this.mTraceListener = r1;
    }

    public void init(Context r4) {
        ApmInitConfig.Builder r0 = ApmInitConfig.builder();
        r0.pageTraceListener(this.mTraceListener);
        TraceConfig r1 = this.mTraceConfig;
        if (r1 == null) goto L5;
        r0.viewIdMonitorPageSwitch(r1.isPageAnnotationTraceTimeSwitchOn());
        r0.maxValidPageLoadTimeMs(this.mTraceConfig.getMaxWaitViewShowTimeMs());
        r0.reportEvilMethodSwitch(this.mTraceConfig.isDropFrameReportEvilMethodSwitch());
        r0.evilMethodThresholdMs(this.mTraceConfig.getEvilMethodThresholdMs());
    L5:
        init(r4, r0.build());
    }

    public void init(final Context r8, final ApmInitConfig r9) {
        if (this.mInited == true) goto L38;
        long r0 = System.nanoTime();
        this.mInited = true;
        ApmContext.getStartId();
        ApmContext.setInitTimeStamp(System.currentTimeMillis());
        ApmContext.setInitUpTimestamp(System.currentTimeMillis() - SystemClock.uptimeMillis());
        this.mApmInitConfig = r9;
        NetUtils.setUrlConnectionInterceptor(r9.getHttpUrlConnectionInterceptor());
        ITraceListener r3 = this.mTraceListener;
        if (r3 == null) goto L7;
        this.mApmInitConfig.setTraceListener(r3);
    L7:
        TraceConfig r4 = this.mTraceConfig;
        if (r4 == null) goto L10;
        this.mApmInitConfig.setViewIdmonitorPageSwitch(r4.isPageAnnotationTraceTimeSwitchOn());
        this.mApmInitConfig.setMaxValidPageLoadTimeMs(this.mTraceConfig.getMaxWaitViewShowTimeMs());
        this.mApmInitConfig.setReportEvilMethodSwitch(this.mTraceConfig.isDropFrameReportEvilMethodSwitch());
        this.mApmInitConfig.setEvilMethodThresholdMs(this.mTraceConfig.getEvilMethodThresholdMs());
    L10:
        BaseDataPipeline.setCacheBufferMaxSize(r9.getCacheBufferCount());
        BaseDataPipeline.setReportFullException(r9.isReportCacheException());
        CommonEventDeliverer.setReportFullException(r9.isReportCacheException());
        Application r5 = AppUtils.getApplication(r8);
        ApmContext.setContext(r5);
        ActivityLifeObserver.init(r5);
        ApmContext.setInitCostTimeStep2(System.nanoTime() - r0);
        registerServiceWhenStart();
        printDataEventInDebugMode();
        ApmContext.setInitCostTimeStep3(System.nanoTime() - r0);
        ApmProgressListener r6 = ApmContext.getProgressListener();
        if (r6 == null) goto L13;
        r6.afterRegisterService();
    L13:
        ApmContext.setCurrentProcessName(r9.getProcessName());
        this.mIsMainProcess = ApmContext.isMainProcess();
        final Runnable r7 = Apm6.init(r8);
        ApmContext.setInitCostTimeStep4(System.nanoTime() - r0);
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r9, r8, r7));
        ApmContext.setInitCostTimeStep5(System.nanoTime() - r0);
        if (this.mIsMainProcess == false) goto L27;
        DetectActivityLeakTask.init(r5, this.mApmInitConfig.getActivityLeakDetectConfig());
        if (r9.isViewIdmonitorPageSwitch() == false) goto L18;
        new PageTimeMonitor().init(r9.getMaxValidPageLoadTimeMs(), true);
    L18:
        AutoPageTraceHelper.setMaxValidTimeMs(r9.getMaxValidPageLoadTimeMs());
        AutoLaunchTraceHelper.setMaxValidTimeMs(r9.getMaxValidLaunchTimeMs());
        initMethodTrace(r5);
        sLimitEvilMethodDepth = r9.isLimitEvilMethodDepth();
        sEvilThresholdMs = r9.getEvilMethodThresholdMs();
        sEvilMethodTraceEnable = r9.isReportEvilMethodSwitch();
        FrameTracer.setsNeedMonitorActivity(r9.isActivityFps());
        boolean r10 = r9.isFullFpsTracer();
        boolean r11 = r9.isDisableFpsTracer();
        MainThreadMonitor.getMonitor().init();
        MainThreadMonitor.getMonitor().setFpsLifeCycleChange(r9.isChangeFpsLifeCyclesTracer());
        MainThreadMonitor.getMonitor().setEnableFpsAllocOpt(r9.isEnableCpuAllocOpt());
        MainThreadMonitor.getMonitor().setEnableLooperOpt(r9.isEnableLooperOpt());
        Util.enableLooperOpt = this.mApmInitConfig.isEnableLooperDeepOpt();
        if (r10 == false) goto L25;
        if (r11 == true) goto L25;
        final FrameTracer r12 = new FrameTracer();
        RealFpsTracer.setFrameTracer(r12);
        EvilMethodTracer.setBlockListener(new AnonymousClass2(this, r12));
        if (this.mApmInitConfig.isEnableLooperOpt() == true) goto L24;
        MainThreadMonitor.getMonitor().addObserver(r12);
    L24:
        MainThreadMonitor.getMonitor().setFrameObserver(r12);
    L25:
        initEvilMethodTraceInject();
        LaunchEvilMethodManager.registerEvilMethodConfig();
        LaunchAnalysisContext.getInstance().setConfig(r9.getLaunchConfig());
        ApmContext.setInitCostTime(System.nanoTime() - r0);
        ApmContext.setDeviceInfoOnPerfDataEnabled(r9.isDeviceInfoOnPerfDataEnabled());
        ApmContext.setSupportMultiFrameRate(r9.supportMultiFrameRate());
    L27:
        if (ApmContext.isDebugMode() == false) goto L34;
        DoctorManager r13 = DoctorManager.getInstance();
        if (this.mIsMainProcess == false) goto L31;
        String r14 = DoctorConstants.APM_INIT;
    L32:
        r13.onEvent(r14, r9.toString());
        goto L34
    L31:
        r14 = DoctorConstants.APM_INIT_OTHER_PROCESS;
    L34:
        if (ApmAlogHelper.getInnerLogger() == null) goto L36;
        ApmAlogHelper.getInnerLogger().i(SlardarLogConstants.TAG_ALOG, "apm_init");
    L36:
        ApmContext.setIsInitFinish(true);
        ApmContext.setInitCostTimeStepFinish(System.nanoTime() - r0);
        return;
    }

    private static void initTraceEvilMethod() {
        EvilMethodTracer.setEvilThresholdMs(sEvilThresholdMs);
        EvilMethodTracer.setIsEvilMethodTraceEnable(sEvilMethodTraceEnable);
        EvilMethodTracer.isMethodTraced = true;
        MainThreadMonitor.getMonitor().init();
        MethodCollector.getInstance().onStart();
        new EvilMethodTracer(sLimitEvilMethodDepth).startTrace();
        PerfMonitorManager.getInstance().setEvilMethodEnable(true);
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public void start(ApmStartConfig r4) {
        if (ApmAlogHelper.getInnerLogger() == null) goto L6;
        ApmAlogHelper.getInnerLogger().i(SlardarLogConstants.TAG_ALOG, "start");     // Catch: Exception -> L17
    L6:
        if (this.mInited == false) goto L16;
        if (r4 == null) goto L14;
        if (this.mStarted == false) goto L11;
        return;
    L11:
        AsyncEventManager.getInstance().resumeTimer();
        this.mStarted = true;
        this.mApmStartConfig = r4;
        AsyncEventManager.getInstance().post(new AnonymousClass3(this));
        return;
    L14:
        throw new IllegalArgumentException("startConfig must not be allowed");
    L16:
        throw new IllegalArgumentException("You must call Apm.getInstance().init() on Application.onCreate from version 5.x.x, pls call init() before start().");
    }

    public void stop() {
        AsyncEventManager.getInstance().stopTimer();
        this.mStarted = false;
    }

    public ApmStartConfig.Builder newStartConfigBuilder() {
        if (this.mStarted == true) goto L7;
        Logger.e("ERROR", new String[]{"apm sdk only can get startconfigBuilder after start finished"});
        return ApmStartConfig.builder();
    L7:
        return ApmStartConfig.builder(this.mApmStartConfig);
    }

    public void restart(final ApmStartConfig r3) {
        AsyncEventManager.getInstance().post(new AnonymousClass4(this, r3));
    }

    private void startInternalSafely() {
        long r0 = System.nanoTime();     // Catch: Throwable -> L6
        com.bytedance.apm6.foundation.context.ApmContext.setNtpTimeService(this.mApmStartConfig.getNtpTimeService());     // Catch: Throwable -> L6
        startInternal();     // Catch: Throwable -> L6
        if (this.mIsMainProcess == false) goto L20;
        ApmContext.setStartCostTime(System.nanoTime() - r0);     // Catch: Throwable -> L6
        reportInnerCost();     // Catch: Throwable -> L6
        return;
    L20:
        return;
    L6:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L11;
        th.printStackTrace();
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_START_ERROR, StackUtils.getStack(th));
    L11:
        if (ApmAlogHelper.getInnerLogger() == null) goto L16;
        ApmAlogHelper.getInnerLogger().i(SlardarLogConstants.TAG_ALOG, "APM_START_ERROR:" + StackUtils.getStack(th));
    L16:
        AsyncEventManager.getInstance().stopTimer();     // Catch: Throwable -> L15
        return;
    }

    private void startInternal() {
        SpManager.getInstance();
        ApmContext.setStartTimeStamp(System.currentTimeMillis());
        ApmContext.setQueryParams(this.mApmStartConfig.getQueryParams());
        Monitor.registerInterceptor(this.mApmStartConfig.getInterceptor());
        compatV4();
        SamplerHelper.setSampler(new DefaultSampler());
        MonitorCoreExceptionManager.getInstance().setExceptionCallback(new AnonymousClass5(this));
        ApmContext.setHeaderInfo(this.mApmStartConfig.getHeader());
        ApmContext.setDynamicParams(this.mApmStartConfig.getDynamicParams());
        ApmContext.setHttpService(this.mApmStartConfig.getHttpService());
        ApmContext.setSlardarConfigUrls(this.mApmStartConfig.getSlardarConfigUrls());
        ApmContext.setAlogFilesDir(this.mApmStartConfig.getAlogFilesDir());
        this.mEncrypt = this.mApmStartConfig.getEncryptor();
        this.mWidgetSet = this.mApmStartConfig.getWidgets();
        initPerfMonitor();
        LogObserver.getInstance().addLogObserver(this.mApmStartConfig.getApmLogListener());
        CommonDataPipeline.getInstance().init();
        NetDataPipeline.getInstance().init();
        NetDataPipeline.getInstance().setNetMonitorWithDisconnected(this.mApmStartConfig.getNetMonitorWithDisconnected());
        AlogActiveUploadManager.init(ApmContext.getContext(), this.mApmInitConfig.getAlogUploadStrategy());
        initByTraceExtendParams();
        long r0 = this.mApmStartConfig.getDelayRequestSeconds();
        Runnable r2 = new AnonymousClass6(this);
        if (r0 > 0) goto L5;
        AsyncEventManager.getInstance().post(r2);
    L7:
        if (ApmContext.isDebugMode() == false) goto L10;
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, "delayRequestSeconds:" + r0);
    L10:
        if (this.mIsMainProcess == false) goto L12;
        checkWhetherFirstInstall();
    L12:
        initAllPlugins(ApmContext.getContext());
        WidgetParams r1 = new WidgetParams();
        r1.setReportDomain(this.mApmStartConfig.getDefaultLogReportUrls());
        notifyPluginsParams(r1);
        startAllPlugins();
        AsyncEventManager.getInstance().injectExecutor(this.mApmStartConfig.getExecutor());
        injectReportUrl(this.mApmStartConfig);
        IApmStartListener r3 = this.mApmStartConfig.getApmStartListener();
        this.mApmStartListener = r3;
        if (r3 == null) goto L15;
        r3.onStartComplete();
    L15:
        AutoLaunchTraceHelper.reportStats();
        ServiceManager.registerService(IHttpService.class, new AnonymousClass7(this));
        if (ApmContext.isDebugMode() == false) goto L23;
        DoctorManager r4 = DoctorManager.getInstance();
        if (this.mIsMainProcess == false) goto L20;
        String r5 = DoctorConstants.APM_START;
    L21:
        r4.onEvent(r5, this.mApmStartConfig.toString());
        goto L23
    L20:
        r5 = DoctorConstants.APM_START_OTHER_PROCESS;
    L23:
        if (ApmAlogHelper.getInnerLogger() == null) goto L26;
        ApmAlogHelper.getInnerLogger().i(SlardarLogConstants.TAG_ALOG, DoctorConstants.APM_START);
        return;
    L26:
        return;
    L5:
        AsyncEventManager.getInstance().postDelay(r2, 1000 * r0);
        goto L7
    }

    private static void initByTraceExtendParams() {
        String r0 = NpthApi.getByTraceID();     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r0) == true) goto L11;
        ApmContext.getHeaderInner().put("bytrace_id", r0);     // Catch: Throwable -> L6
        ApmContext.getHeaderInner().put("pid", String.valueOf(Process.myPid()));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private void injectReportUrl(ApmStartConfig r7) {
        List<String> r6 = r7.getDefaultLogReportUrls();
        if (ListUtils.isEmpty(r6) == true) goto L15;
        int r0 = 0;
        String r1 = new URL(r6.get(0)).getHost();     // Catch: MalformedURLException -> L19
        FileUploadServiceImpl.setUploadHost(r1);     // Catch: MalformedURLException -> L19
        FileUploadServiceImpl.setMappingFileUploadHost(r1);     // Catch: MalformedURLException -> L19
        AlogUploadService.setUploadHost(r1);     // Catch: MalformedURLException -> L19
    L6:
        ArrayList r2 = new ArrayList(2);
        int r3 = r6.size();
    L7:
        if (r0 >= r3) goto L14;
        String r4 = new URL(r6.get(r0)).getHost();     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r4) == true) goto L13;
        if (r4.indexOf(46) <= 0) goto L13;
        r2.add("https://" + r4 + "/monitor/collect/batch/");     // Catch: Exception -> L20
    L13:
        r0 = r0 + 1;
        goto L7
    L14:
        LogReportController.getInstance().setDefaultReportUrlList(r2);
    L15:
        LogReportController.getInstance().setTraceReportUrlList(ReportUrl.REPORT_TRACING_URL_LIST);
        LogReportController.getInstance().setDefaultExceptionUrlList(ReportUrl.EXCEPTION_UPLOAD_URL_LIST);
        LogReportController.getInstance().setDefaultExceptionUrlList(r7.getExceptionLogReportUrls());
        List<String> r8 = r7.getTraceReportUrls();
        if (ListUtils.isEmpty(r8) == true) goto L29;
        LogReportController.getInstance().setTraceReportUrlList(r8);
        return;
    }

    private void restartInternal(ApmStartConfig r5) {
        this.mApmStartConfig = r5;
        ApmContext.setQueryParams(r5.getQueryParams());
        ApmContext.setHeaderInfo(r5.getHeader());
        ApmContext.setDynamicParams(r5.getDynamicParams());
        ApmContext.setHttpService(r5.getHttpService());
        this.mEncrypt = r5.getEncryptor();
        if (this.mIsMainProcess == false) goto L6;
        this.mSlardarConfigManager.forceUpdateFromRemote(new AnonymousClass8(this), r5.getSlardarConfigUrls());
    L10:
        NetDataPipeline.getInstance().setNetMonitorWithDisconnected(r5.getNetMonitorWithDisconnected());
        LogReporter.getInstance().restart();
        injectReportUrl(this.mApmStartConfig);
        AsyncEventManager.getInstance().injectExecutor(r5.getExecutor());
        return;
    L6:
        if (r5.isEnableMultiProcessRequestSetting() == false) goto L10;
        SlardarConfigManagerImpl r0 = this.mSlardarConfigManager;
        if (r0 == null) goto L10;
        r0.initParams(r5.isEnableMultiProcessRequestSetting(), new AnonymousClass9(this), r5.getSlardarConfigUrls());
        goto L10
    }

    private void initPerfMonitor() {
        MemoryCollector.getInstance().initGCInfo();
        if (this.mIsMainProcess == false) goto L5;
        StorageCollector r0 = new StorageCollector();
        r0.setStorageCheckListener(this.mApmStartConfig.getStorageCheckListener());
        r0.init();
    L5:
        TrafficCollector.setCallback(this.mApmStartConfig.getTrafficCallback());
        DiskCollector.getInstance().setDiskCheckListener(this.mApmStartConfig.getStorageCheckListener());
        MemoryCollector.getInstance().registerReachTopListener(this.mApmStartConfig.getMemoryReachTopListener());
        if (this.mApmStartConfig.isWithBlockDetect() == true) goto L8;
        return;
    L8:
        if (this.mApmStartConfig.isEnableBlockOnlySampled() == true) goto L12;
        initBlockMonitor();
        return;
    }

    private void initBlockMonitor() {
        if (this.isBlockInited == false) goto L5;
        return;
    L5:
        this.isBlockInited = true;
        ApmHandlerThread.getDefaultMainHandler().post(new AnonymousClass10(this));
        BlockDetector r0 = new BlockDetector();
        r0.setBlockThresholdMs(this.mApmStartConfig.getBlockThresholdMs());
        r0.setWithSeriousBlockDetect(this.mApmStartConfig.isWithSeriousBlockDetect());
        r0.setIgnoreInvalidStack(this.mApmStartConfig.isIgnoreInvalidStack());
        r0.setBlockListener(this.mApmStartConfig.getBlockListener());
        r0.init();
        if (ActivityLifeObserver.getInstance().isForeground() == false) goto L8;
        r0.start();
    L8:
        r0.setSliverEnable(this.mApmInitConfig.isEnableSliverDump());
    }

    private void compatV4() {
        if (ListUtils.isEmpty(this.mApmStartConfig.getSlardarConfigUrls()) == false) goto L8;
        if (ListUtils.isEmpty(this.mDefaultCongfigUrlsCompat) == true) goto L8;
        this.mApmStartConfig.setSlardarConfigUrlsCompat(this.mDefaultCongfigUrlsCompat);
    L8:
        if (ListUtils.isEmpty(this.mApmStartConfig.getDefaultLogReportUrls()) == false) goto L13;
        if (ListUtils.isEmpty(this.mDefaultLogReportUrlsCompat) == true) goto L13;
        this.mApmStartConfig.setDefaultLogReportUrlsCompat(this.mDefaultLogReportUrlsCompat);
    L13:
        if (ListUtils.isEmpty(this.mApmStartConfig.getExceptionLogReportUrls()) == true) goto L15;
        return;
    L15:
        if (ListUtils.isEmpty(this.mExceptionLogReportUrlsCompat) == true) goto L19;
        this.mApmStartConfig.setExceptionLogReportUrlsCompat(this.mExceptionLogReportUrlsCompat);
        return;
    }

    private void checkWhetherFirstInstall() {
        String r2 = SpManager.getInstance().getString("update_version_code");
        String r1 = ApmContext.getHeaderInner().optString("update_version_code");
        if (TextUtils.equals(r2, r1) == true) goto L5;
        ApmContext.setLaunchMode(1);
        SpManager.getInstance().saveAsync("update_version_code", r1);
        return;
    L5:
        ApmContext.setLaunchMode(2);
    }

    private void initAllPlugins(Context r2) {
        Set<IWidget> r1 = this.mWidgetSet;
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator<IWidget> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        r3.next().init(r2);     // Catch: Throwable -> L12
        goto L7
    }

    public void notifyPluginsParams(WidgetParams r2) {
        Set<IWidget> r1 = this.mWidgetSet;
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator<IWidget> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        r3.next().notifyParams(r2);     // Catch: Throwable -> L12
        goto L7
    }

    public void startAllPlugins() {
        Set<IWidget> r1 = this.mWidgetSet;
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator<IWidget> r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        r2.next().start();     // Catch: Throwable -> L12
        goto L7
    }

    public void stopAllPlugins() {
        if (this.mWidgetSet != null) goto L5;
        return;
    L5:
        AsyncEventManager.getInstance().post(new AnonymousClass11(this));
    }

    public void destroyAllPlugins() {
        if (this.mWidgetSet != null) goto L5;
        return;
    L5:
        AsyncEventManager.getInstance().post(new AnonymousClass12(this));
    }

    private void registerServiceWhenStart() {
        SlardarConfigManagerImpl r0 = new SlardarConfigManagerImpl();
        this.mSlardarConfigManager = r0;
        r0.registerConfigListener(this);
        ServiceManager.registerService(IConfigManager.class, this.mSlardarConfigManager);
        ServiceManager.registerService(IApmAgent.class, new AnonymousClass13(this));
        ServiceManager.registerService(ILaunchTrace.class, new AnonymousClass14(this));
        ServiceManager.registerService(IZstdCompress.class, new AnonymousClass15(this));
        ServiceManager.registerService(IZstdDict.class, new AnonymousClass16(this));
    }

    public ApmInitConfig getApmInitConfig() {
        ApmInitConfig r0 = this.mApmInitConfig;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ApmInitConfig.builder().build();
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r2, boolean r3) {
        JSONObject r4 = r2.optJSONObject("general");
        if (r4 == null) goto L5;
        this.mEnableActiveUploadAlog = r4.optBoolean(SlardarSettingsConsts.ENABLE_ACTIVE_UPLOAD_ALOG, true);
        return;
    L5:
        this.mEnableActiveUploadAlog = true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        boolean r0 = true;
        this.mConfigReady = true;
        IApmStartListener r1 = this.mApmStartListener;
        if (r1 == null) goto L5;
        r1.onReady();
    L5:
        JSONObject r2 = this.mSlardarConfigManager.getConfig();
        if (this.mIsMainProcess == false) goto L14;
        new ThreadCollector().init();
        if (JsonUtils.optInt(r2, "performance_modules", "traffic", "enable_collect") != 1) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        TrafficCollector.getInstance().init();
        goto L14
    L10:
        r3 = false;
    L14:
        if (this.mApmStartConfig.isWithBatteryDetect() == false) goto L40;
        if (JsonUtils.optInt(r2, "performance_modules", "battery", "enable_upload") != 1) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L21;
        BatteryWidget.initBatteryEnergy();
    L21:
        if (r4 == false) goto L23;
    L24:
        BatteryWidget.initBatteryCollector(this.mApmStartConfig.isBatteryLocalRecordEnable());
    L26:
        if (JsonUtils.optInt(r2, "performance_modules", "battery", SlardarSettingsConsts.PER_POWER_MONITOR_ENABLE) != 1) goto L28;
        boolean r5 = true;
    L29:
        if (r5 == false) goto L32;
        BatteryWidget.initPower();
    L32:
        if (JsonUtils.optInt(r2, "performance_modules", "battery", SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_ENABLE_UPLOAD) == 1) goto L35;
        r0 = false;
    L35:
        if (r0 == false) goto L37;
    L38:
        BatteryWidget.initBatteryTemperature(this.mApmStartConfig.isTemperatureLocalRecordEnable());
        goto L40
    L37:
        if (this.mApmStartConfig.isTemperatureLocalRecordEnable() == false) goto L40;
    L28:
        r5 = false;
        goto L29
    L23:
        if (this.mApmStartConfig.isBatteryLocalRecordEnable() == false) goto L26;
    L18:
        r4 = false;
    L40:
        if (this.mApmStartConfig.isEnableBlockOnlySampled() == true) goto L42;
        return;
    L42:
        if (PerfConfigManager.getInstance().getPerfSecondStageSwitch("block_monitor") == false) goto L46;
        initBlockMonitor();
        return;
    }

    public boolean isConfigReady() {
        return this.mConfigReady;
    }

    public boolean getLogTypeSwitch(String r2) {
        if (this.mConfigReady == false) goto L9;
        SlardarConfigManagerImpl r1 = this.mSlardarConfigManager;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getLogTypeSwitch(r2);
    L9:
        return false;
    }

    public boolean getServiceNameSwitch(String r2) {
        if (this.mConfigReady == false) goto L9;
        SlardarConfigManagerImpl r1 = this.mSlardarConfigManager;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getServiceSwitch(r2);
    L9:
        return false;
    }

    public boolean getMetricsTypeSwitch(String r2) {
        if (this.mConfigReady == false) goto L9;
        SlardarConfigManagerImpl r1 = this.mSlardarConfigManager;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getMetricTypeSwitch(r2);
    L9:
        return false;
    }

    public IEncrypt getEncrypt() {
        return this.mEncrypt;
    }

    public void activeUploadAlog(final String r13, final long r14, final long r16, final String r18, final IALogActiveUploadObserver r19, final IALogActiveUploadCallback r20) {
        if (this.mEnableActiveUploadAlog == false) goto L5;
        AsyncEventManager.getInstance().submitTask(new AnonymousClass17(this, r13, r14, r16, r18, r19, r20));
        return;
    L5:
        if (r20 == null) goto L9;
        r20.onCallback(false, AlogMonitor.getResult(false, 9, null, null));
        return;
    }

    public void stopWithReport() {
        AsyncEventManager.getInstance().post(new AnonymousClass18(this));
        AsyncEventManager.getInstance().stopTimer();
        Apm.pause();
    }

    public void restart() {
        AsyncEventManager.getInstance().resumeTimer();
        AsyncEventManager.getInstance().post(new AnonymousClass19(this));
        Apm.resume();
    }

    public void pause() {
        AsyncEventManager.getInstance().post(new AnonymousClass20(this));
        AsyncEventManager.getInstance().stopTimer();
    }

    public void resume() {
        AsyncEventManager.getInstance().resumeTimer();
        AsyncEventManager.getInstance().post(new AnonymousClass21(this));
    }

    public void setConfigUrlCompat(List<String> r2) {
        if (this.mStarted == false) goto L6;
        return;
    L6:
        if (ListUtils.isEmpty(r2) == false) goto L8;
        return;
    L8:
        this.mDefaultCongfigUrlsCompat = r2;
    }

    public void setDefaultLogReportUrlsCompat(List<String> r2) {
        if (this.mStarted == false) goto L6;
        return;
    L6:
        if (ListUtils.isEmpty(r2) == false) goto L8;
        return;
    L8:
        this.mDefaultLogReportUrlsCompat = r2;
    }

    public void setExceptionLogReportUrlsCompat(List<String> r2) {
        if (this.mStarted == false) goto L6;
        return;
    L6:
        if (ListUtils.isEmpty(r2) == false) goto L8;
        return;
    L8:
        this.mExceptionLogReportUrlsCompat = r2;
    }

    private void reportInnerCost() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("init", ApmContext.getInitCostTime());     // Catch: JSONException -> L4
        r0.put(CommonConsts.APM_INNER_EVENT_COST_INIT_INCLUDING_APM6, ApmContext.getInitCostTimeIncludingApm6());     // Catch: JSONException -> L4
        r0.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP2, ApmContext.getInitCostTimeStep2());     // Catch: JSONException -> L4
        r0.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP3, ApmContext.getInitCostTimeStep3());     // Catch: JSONException -> L4
        r0.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP4, ApmContext.getInitCostTimeStep4());     // Catch: JSONException -> L4
        r0.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP5, ApmContext.getInitCostTimeStep5());     // Catch: JSONException -> L4
        r0.put("start", ApmContext.getStartCostTime());     // Catch: JSONException -> L4
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L4
        r1.put("is_main_process", this.mIsMainProcess);     // Catch: JSONException -> L4
        ApmAgent.monitorEvent("apm_cost", r1, r0, null);     // Catch: JSONException -> L4
        return;
    }

    private static void printDataEventInDebugMode() {
        if (ApmContext.isDebugMode() == true) goto L5;
        return;
    L5:
        DoctorManager.getInstance().registerApmListener(new AnonymousClass22());
    }
}
