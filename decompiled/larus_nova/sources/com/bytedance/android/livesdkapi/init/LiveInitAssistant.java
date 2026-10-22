package com.bytedance.android.livesdkapi.init;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.core.log.ALogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004*\u0001D\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001yB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010P\u001a\u00020QH\u0002J\u000e\u0010R\u001a\u00020Q2\u0006\u0010I\u001a\u00020JJ\b\u0010S\u001a\u00020QH\u0002J\b\u0010T\u001a\u00020\u0006H\u0016J\u000e\u0010U\u001a\u00020Q2\u0006\u0010I\u001a\u00020JJ\u0018\u0010V\u001a\u00020Q2\u0006\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020YH\u0016J\b\u0010Z\u001a\u00020QH\u0016J\u0010\u0010[\u001a\u00020Q2\u0006\u0010W\u001a\u00020\u0004H\u0016J\u0010\u0010\\\u001a\u00020Q2\u0006\u0010]\u001a\u00020\u0004H\u0016J\u0018\u0010^\u001a\u00020Q2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u0004H\u0016J\b\u0010a\u001a\u00020QH\u0016J\b\u0010b\u001a\u00020QH\u0016J\b\u0010c\u001a\u00020QH\u0016J \u0010d\u001a\u00020Q2\u0006\u0010e\u001a\u00020\u00042\u0006\u0010f\u001a\u00020Y2\u0006\u0010g\u001a\u00020,H\u0016J\u0010\u0010h\u001a\u00020Q2\u0006\u0010W\u001a\u00020\u0004H\u0016J\u0010\u0010i\u001a\u00020Q2\u0006\u0010W\u001a\u00020\u0004H\u0016J\u0010\u0010j\u001a\u00020Q2\u0006\u0010W\u001a\u00020\u0004H\u0016J\u000e\u0010k\u001a\u00020Q2\u0006\u0010l\u001a\u00020\u0004J\b\u0010m\u001a\u00020&H\u0016J\u0010\u0010n\u001a\u00020Q2\u0006\u0010o\u001a\u00020 H\u0002J\u0006\u0010p\u001a\u00020QJ*\u0010q\u001a\u00020Q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u00042\u0012\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040vJ \u0010w\u001a\u00020Q2\u0006\u0010m\u001a\u00020&2\u0006\u0010x\u001a\u00020 2\u0006\u0010o\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u00108\u001a\b\u0012\u0004\u0012\u00020\u000409X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bE\u0010FR\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010H\u001a\u0004\bM\u0010N¨\u0006z"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveInitAssistant;", "Lcom/bytedance/android/livesdkapi/init/ILiveInitAssistant;", "()V", "TAG", "", "configSeted", "", "getConfigSeted", "()Z", "setConfigSeted", "(Z)V", "costInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/android/livesdkapi/init/LiveInitCostInfo;", "enablePreInit", "getEnablePreInit", "setEnablePreInit", "infoMap", "initConfigInner", "Lcom/bytedance/android/livesdkapi/init/LiveInitConfigInner;", "getInitConfigInner", "()Lcom/bytedance/android/livesdkapi/init/LiveInitConfigInner;", "setInitConfigInner", "(Lcom/bytedance/android/livesdkapi/init/LiveInitConfigInner;)V", "initExecutor", "Ljava/util/concurrent/Executor;", "getInitExecutor", "()Ljava/util/concurrent/Executor;", "setInitExecutor", "(Ljava/util/concurrent/Executor;)V", "initFinished", "initLoggerConfig", "Lcom/bytedance/android/livesdkapi/init/LiveInitLoggerConfig;", "getInitLoggerConfig", "()Lcom/bytedance/android/livesdkapi/init/LiveInitLoggerConfig;", "setInitLoggerConfig", "(Lcom/bytedance/android/livesdkapi/init/LiveInitLoggerConfig;)V", "initOptimizeConfig", "Lcom/bytedance/android/livesdkapi/init/LiveInitializeSettingConfig;", "getInitOptimizeConfig", "()Lcom/bytedance/android/livesdkapi/init/LiveInitializeSettingConfig;", "setInitOptimizeConfig", "(Lcom/bytedance/android/livesdkapi/init/LiveInitializeSettingConfig;)V", "initThreadSize", "", "getInitThreadSize", "()I", "setInitThreadSize", "(I)V", "isNewUser", "liveSDKFunctionGetter", "Lcom/bytedance/android/livesdkapi/init/LiveInitAssistant$ILiveSDKFunctionGetter;", "getLiveSDKFunctionGetter", "()Lcom/bytedance/android/livesdkapi/init/LiveInitAssistant$ILiveSDKFunctionGetter;", "setLiveSDKFunctionGetter", "(Lcom/bytedance/android/livesdkapi/init/LiveInitAssistant$ILiveSDKFunctionGetter;)V", "newInitThreadList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getNewInitThreadList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setNewInitThreadList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "npeServiceList", "Ljava/util/concurrent/ConcurrentSkipListSet;", "reported", "sceneInfo", "Lcom/bytedance/android/livesdkapi/init/LiveSceneInfo;", "serviceListener", "com/bytedance/android/livesdkapi/init/LiveInitAssistant$serviceListener$2$1", "getServiceListener", "()Lcom/bytedance/android/livesdkapi/init/LiveInitAssistant$serviceListener$2$1;", "serviceListener$delegate", "Lkotlin/Lazy;", "taskController", "Lcom/bytedance/android/livesdkapi/init/ILiveInitTaskController;", "taskListener", "Lcom/bytedance/android/livesdkapi/init/LiveInitTaskScheduleListener;", "getTaskListener", "()Lcom/bytedance/android/livesdkapi/init/LiveInitTaskScheduleListener;", "taskListener$delegate", "calculateTotalDuration", "", "checkWhetherAddTaskListener", "dispose", "isInitFinish", "listenTaskExecute", "markDuration", "name", "duration", "", "markEnablePreInit", "markError", "markGetServiceNpe", "serviceName", "markInfo", "key", "value", "markInitFinished", "markInitStart", "markIsNewUser", "markScene", "scene", "pageType", "position", "markThread", "markTimeEnd", "markTimeStart", "markWaitTask", "taskName", "optimizeConfig", "postReport", "initConfig", "report", "reportError", a.KEY_EXCEPTION, "Ljava/lang/Exception;", "msg", "infos", "", "setInitConfig", "loggerConfig", "ILiveSDKFunctionGetter", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitAssistant implements ILiveInitAssistant {
    public static final LiveInitAssistant INSTANCE = null;
    private static final String TAG = "LiveInitLogger";
    private static volatile boolean configSeted;
    private static final ConcurrentHashMap<String, LiveInitCostInfo> costInfoMap = null;
    private static volatile boolean enablePreInit;
    private static final ConcurrentHashMap<String, String> infoMap = null;
    private static LiveInitConfigInner initConfigInner;
    private static Executor initExecutor;
    private static volatile boolean initFinished;
    private static LiveInitLoggerConfig initLoggerConfig;
    private static LiveInitializeSettingConfig initOptimizeConfig;
    private static int initThreadSize;
    private static boolean isNewUser;
    private static ILiveSDKFunctionGetter liveSDKFunctionGetter;
    private static CopyOnWriteArrayList<String> newInitThreadList;
    private static final ConcurrentSkipListSet<String> npeServiceList = null;
    private static volatile boolean reported;
    private static LiveSceneInfo sceneInfo;
    private static final Lazy serviceListener$delegate = null;
    private static ILiveInitTaskController taskController;
    private static final Lazy taskListener$delegate = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveInitAssistant$ILiveSDKFunctionGetter;", "", "reportErrorToSlardar", "", a.KEY_EXCEPTION, "Ljava/lang/Exception;", "msg", "", "infos", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ILiveSDKFunctionGetter {
        void reportErrorToSlardar(Exception r100, String r101, Map<String, String> r102);
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.init.LiveInitAssistant$markScene$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(LiveInitAssistant r100) {
            super(r100, LiveInitAssistant.class, "sceneInfo", "getSceneInfo()Lcom/bytedance/android/livesdkapi/init/LiveSceneInfo;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return LiveInitAssistant.access$getSceneInfo$p((LiveInitAssistant) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            LiveInitAssistant.access$setSceneInfo$p((LiveInitAssistant) this.receiver, (LiveSceneInfo) r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.init.LiveInitAssistant$postReport$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C102481 extends MutablePropertyReference0Impl {
        public C102481(LiveInitAssistant r100) {
            super(r100, LiveInitAssistant.class, "sceneInfo", "getSceneInfo()Lcom/bytedance/android/livesdkapi/init/LiveSceneInfo;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return LiveInitAssistant.access$getSceneInfo$p((LiveInitAssistant) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            LiveInitAssistant.access$setSceneInfo$p((LiveInitAssistant) this.receiver, (LiveSceneInfo) r100);
        }
    }

    private LiveInitAssistant() {
    }

    private final void dispose() {
        k.f498083c = null;
        ILiveInitTaskController r100 = taskController;
        if (r100 == null) goto L5;
        r100.setInitTaskListener(null);
    L5:
        taskController = null;
        infoMap.clear();
        costInfoMap.clear();
        npeServiceList.clear();
        getTaskListener().dispose();
    }

    private final LiveInitAssistant$serviceListener$2.AnonymousClass1 getServiceListener() {
        return (LiveInitAssistant$serviceListener$2.AnonymousClass1) serviceListener$delegate.getValue();
    }

    private final LiveInitTaskScheduleListener getTaskListener() {
        return (LiveInitTaskScheduleListener) taskListener$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markEnablePreInit() {
        enablePreInit = true;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markInitFinished() {
        initFinished = true;
        report();
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markIsNewUser() {
        isNewUser = true;
    }

    static {
        INSTANCE = new LiveInitAssistant();
        infoMap = new ConcurrentHashMap();
        costInfoMap = new ConcurrentHashMap();
        taskListener$delegate = LazyKt.lazy(LiveInitAssistant$taskListener$2.INSTANCE);
        npeServiceList = new ConcurrentSkipListSet();
        initOptimizeConfig = new LiveInitializeSettingConfig();
        initLoggerConfig = new LiveInitLoggerConfig();
        initConfigInner = new LiveInitConfigInner();
        newInitThreadList = new CopyOnWriteArrayList();
        serviceListener$delegate = LazyKt.lazy(LiveInitAssistant$serviceListener$2.INSTANCE);
    }

    private final void calculateTotalDuration() {
        ConcurrentHashMap<String, LiveInitCostInfo> r100 = costInfoMap;
        LiveInitCostInfo r101 = r100.get("pre_init_duration");
        long r102 = 0;
        if (r101 == null) goto L5;
        long r103 = r101.getDuration();
    L6:
        LiveInitCostInfo r104 = r100.get("init_duration");
        if (r104 == null) goto L9;
        r102 = r104.getDuration();
    L9:
        infoMap.put("init_total_duration", String.valueOf(r103 + r102));
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void report() {
        if (isNewUser == false) goto L6;
        return;
    L6:
        if (initLoggerConfig.getEnableReport() == true) goto L10;
        dispose();
        return;
    L10:
        if (reported == false) goto L13;
        return;
    L13:
        if (initFinished == true) goto L15;
        return;
    L15:
        if (initLoggerConfig.getEnableWaitTaskReport() == true) goto L17;
    L19:
        postReport(initLoggerConfig);
        reported = true;
        return;
    L17:
        if (getTaskListener().getAllTaskFinished() == true) goto L19;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markInitStart() {
        k.f498083c = getServiceListener();
    }

    public final boolean getConfigSeted() {
        return configSeted;
    }

    public final boolean getEnablePreInit() {
        return enablePreInit;
    }

    public final LiveInitConfigInner getInitConfigInner() {
        return initConfigInner;
    }

    public final Executor getInitExecutor() {
        return initExecutor;
    }

    public final LiveInitLoggerConfig getInitLoggerConfig() {
        return initLoggerConfig;
    }

    public final LiveInitializeSettingConfig getInitOptimizeConfig() {
        return initOptimizeConfig;
    }

    public final int getInitThreadSize() {
        return initThreadSize;
    }

    public final ILiveSDKFunctionGetter getLiveSDKFunctionGetter() {
        return liveSDKFunctionGetter;
    }

    public final CopyOnWriteArrayList<String> getNewInitThreadList() {
        return newInitThreadList;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public boolean isInitFinish() {
        return initFinished;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public LiveInitializeSettingConfig optimizeConfig() {
        return initOptimizeConfig;
    }

    public static final /* synthetic */ void access$calculateTotalDuration(LiveInitAssistant r100) {
        r100.calculateTotalDuration();
    }

    public static final /* synthetic */ void access$dispose(LiveInitAssistant r100) {
        r100.dispose();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getCostInfoMap$p(LiveInitAssistant r100) {
        return costInfoMap;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getInfoMap$p(LiveInitAssistant r100) {
        return infoMap;
    }

    public static final /* synthetic */ ConcurrentSkipListSet access$getNpeServiceList$p(LiveInitAssistant r100) {
        return npeServiceList;
    }

    public static final /* synthetic */ LiveSceneInfo access$getSceneInfo$li(LiveInitAssistant r100) {
        return sceneInfo;
    }

    public static final /* synthetic */ LiveSceneInfo access$getSceneInfo$p(LiveInitAssistant r100) {
        LiveSceneInfo r101 = sceneInfo;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sceneInfo");
    L5:
        return r101;
    }

    public static final /* synthetic */ LiveInitTaskScheduleListener access$getTaskListener$p(LiveInitAssistant r100) {
        return r100.getTaskListener();
    }

    private final void postReport(final LiveInitLoggerConfig r100) {
        LiveSceneInfo r101 = sceneInfo;
        if (r101 == null) goto L7;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("sceneInfo");
    L6:
        r101.initEnd();
    L7:
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass2(r100), r100.getReportDelayTime());
    }

    public final void checkWhetherAddTaskListener(ILiveInitTaskController r100) {
        Intrinsics.checkNotNullParameter(r100, "taskController");
        if (initLoggerConfig.getEnableReport() == true) goto L5;
        return;
    L5:
        if (initLoggerConfig.getEnableWaitTaskReport() == false) goto L9;
        listenTaskExecute(r100);
        return;
    }

    public final void listenTaskExecute(ILiveInitTaskController r100) {
        Intrinsics.checkNotNullParameter(r100, "taskController");
        r100.setInitTaskListener(getTaskListener());
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ConcurrentHashMap<String, String> r101 = infoMap;
        r101.put(r100, "true");
        if (initLoggerConfig.getEnableErrorReport() == true) goto L29;
        return;
    L29:
    L26:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (new Random().nextInt(100) >= initLoggerConfig.getErrorSampleRate()) goto L35;
        String r102 = r100 + "_stack";     // Catch: Exception -> L26
        if (initLoggerConfig.getErrorReportToTea() == false) goto L15;
        String r103 = Log.getStackTraceString(new Throwable());     // Catch: Exception -> L26
        int r104 = initLoggerConfig.getStackMaxLength();     // Catch: Exception -> L26
        if (r103 == null) goto L13;
        r101.put(r102, r103.substring(0, r104));     // Catch: Exception -> L26
        goto L15
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L26
    L15:
        if (initLoggerConfig.getErrorReportToSlardar() == false) goto L36;
        ILiveSDKFunctionGetter r105 = liveSDKFunctionGetter;     // Catch: Exception -> L26
        if (r105 == null) goto L37;
        RuntimeException r106 = new RuntimeException("live_init_error_" + r100);     // Catch: Exception -> L26
        String r107 = "live_init_error_" + r100;     // Catch: Exception -> L26
        LinkedHashMap r108 = new LinkedHashMap();     // Catch: Exception -> L26
        Iterator<Map.Entry<String, String>> r109 = r101.entrySet().iterator();     // Catch: Exception -> L26
    L20:
        if (r109.hasNext() == false) goto L24;
        Map.Entry<String, String> r110 = r109.next();     // Catch: Exception -> L26
        if ((!r110.getKey().equals(r102)) == false) goto L20;
        r108.put(r110.getKey(), r110.getValue());     // Catch: Exception -> L26
        goto L20
    L24:
        r105.reportErrorToSlardar(r106, r107, r108);     // Catch: Exception -> L26
        return;
    L37:
        return;
    L36:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markGetServiceNpe(String r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        if (initFinished == false) goto L5;
        return;
    L5:
        npeServiceList.add(r100);
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markThread(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (newInitThreadList.contains(r100) == true) goto L6;
        newInitThreadList.add(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markTimeEnd(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        LiveInitCostInfo r101 = costInfoMap.get(r100);
        if (r101 == null) goto L8;
        r101.setDuration(System.currentTimeMillis() - r101.getStart());
        if (r100.equals("init_duration") == false) goto L9;
        ALogger.i("LiveInitExecutor_", r100 + "  duration  =  " + r101.getDuration());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markTimeStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ConcurrentHashMap<String, LiveInitCostInfo> r101 = costInfoMap;
        LiveInitCostInfo r102 = r101.get(r100);
        if (r102 != null) goto L5;
        r102 = new LiveInitCostInfo();
        r102.setName(r100);
        r101.put(r100, r102);
    L5:
        r102.setStart(System.currentTimeMillis());
    }

    public final void markWaitTask(String r100) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        infoMap.put(r100 + "_locked", "true");
    }

    public final void setConfigSeted(boolean r100) {
        configSeted = r100;
    }

    public final void setEnablePreInit(boolean r100) {
        enablePreInit = r100;
    }

    public final void setInitConfigInner(LiveInitConfigInner r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        initConfigInner = r100;
    }

    public final void setInitExecutor(Executor r100) {
        initExecutor = r100;
    }

    public final void setInitLoggerConfig(LiveInitLoggerConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        initLoggerConfig = r100;
    }

    public final void setInitOptimizeConfig(LiveInitializeSettingConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        initOptimizeConfig = r100;
    }

    public final void setInitThreadSize(int r100) {
        initThreadSize = r100;
    }

    public final void setLiveSDKFunctionGetter(ILiveSDKFunctionGetter r100) {
        liveSDKFunctionGetter = r100;
    }

    public final void setNewInitThreadList(CopyOnWriteArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        newInitThreadList = r100;
    }

    public static final /* synthetic */ void access$setSceneInfo$li(LiveInitAssistant r100, LiveSceneInfo r101) {
        sceneInfo = r101;
    }

    public static final /* synthetic */ void access$setSceneInfo$p(LiveInitAssistant r100, LiveSceneInfo r101) {
        sceneInfo = r101;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markDuration(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ConcurrentHashMap<String, LiveInitCostInfo> r102 = costInfoMap;
        LiveInitCostInfo r103 = r102.get(r100);
        if (r103 == null) goto L5;
        r103.setDuration(r101);
        return;
    L5:
        LiveInitCostInfo r104 = new LiveInitCostInfo(r100);
        r104.setDuration(r101);
        Unit r105 = Unit.INSTANCE;
        r102.put(r100, r104);
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        infoMap.put(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public void markScene(String r100, long r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (initFinished == false) goto L5;
        return;
    L5:
        if (sceneInfo != null) goto L10;
        sceneInfo = new LiveSceneInfo(r100, r101, r102);
        return;
    }

    public final void reportError(Exception r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, a.KEY_EXCEPTION);
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "infos");
        ILiveSDKFunctionGetter r103 = liveSDKFunctionGetter;
        if (r103 == null) goto L6;
        r103.reportErrorToSlardar(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitAssistant
    public synchronized void setInitConfig(LiveInitializeSettingConfig r100, LiveInitLoggerConfig r101, LiveInitConfigInner r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "optimizeConfig");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r101, "loggerConfig");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r102, "initConfig");     // Catch: Throwable -> L11
        if (configSeted == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        configSeted = true;     // Catch: Throwable -> L11
        initLoggerConfig = r101;     // Catch: Throwable -> L11
        initOptimizeConfig = r100;     // Catch: Throwable -> L11
        initConfigInner = r102;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
