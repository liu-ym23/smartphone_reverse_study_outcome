package com.stepos.core.ota.monitor;

import android.content.Context;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.settings.AiEngineSystemSettings;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.OtaDispatcher;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.ConfirmDialogParams;
import com.stepos.core.ota.confirmui.ConfirmUiHost;
import com.stepos.core.ota.confirmui.ConfirmUiRequest;
import com.stepos.core.ota.confirmui.OtaConfirmTrampolineActivity;
import com.stepos.core.ota.confirmui.i;
import com.stepos.core.ota.d;
import com.stepos.core.ota.deepbinder.DownloadResourceGate;
import com.stepos.core.ota.deepbinder.f;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor;
import com.stepos.core.ota.process.OtaProcess;
import com.stepos.core.ota.process.OtaRuntime;
import com.stepos.core.ota.push.AutoUpdateEnv;
import h0.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import lb.n;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ActiveDownloadConditionMonitor {
    private static final long SETTLE_MS = 1200;
    private static final String TAG = "ActiveDlCondMonitor";
    private static volatile Context appCtx;
    private static volatile p<? super String, ? super ConditionKind, n> conditionBreakNotifier;
    private static volatile l<? super ConditionKind, n> conditionBreakNotifyCanceller;
    private static volatile boolean conditionGatePrompted;
    private static volatile boolean listening;
    private static ConnectivityManager.NetworkCallback netCallback;
    private static volatile boolean noNetworkToasted;
    private static volatile ConfirmUiHost onPageConfirmHost;
    private static volatile l<? super String, ReminderMeta> reminderMetaProvider;
    private static volatile Job settleJob;
    private static volatile boolean started;
    private static ContentObserver switchObserver;
    public static final ActiveDownloadConditionMonitor INSTANCE = new ActiveDownloadConditionMonitor();
    private static volatile zb.a<Boolean> managerForeground = new a9.b(21);
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    private static final ConcurrentHashMap.KeySetView<String, Boolean> downloadingFg = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> inFlightFg = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> prompting = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> resolvingMeta = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> cellularApproved = ConcurrentHashMap.newKeySet();
    private static volatile NetKind lastNet = NetKind.OTHER;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ConditionKind {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ ConditionKind[] $VALUES;
        public static final ConditionKind WIFI_TO_CELLULAR = new ConditionKind("WIFI_TO_CELLULAR", 0);
        public static final ConditionKind LOW_BATTERY = new ConditionKind("LOW_BATTERY", 1);
        public static final ConditionKind LOW_STORAGE = new ConditionKind("LOW_STORAGE", 2);
        public static final ConditionKind NO_NETWORK = new ConditionKind(ModelFlowMeta.PLAN_NO_NETWORK, 3);

        private static final /* synthetic */ ConditionKind[] $values() {
            return new ConditionKind[]{WIFI_TO_CELLULAR, LOW_BATTERY, LOW_STORAGE, NO_NETWORK};
        }

        static {
            ConditionKind[] conditionKindArr$values = $values();
            $VALUES = conditionKindArr$values;
            $ENTRIES = kotlin.enums.a.a(conditionKindArr$values);
        }

        private ConditionKind(String str, int i10) {
        }

        public static sb.a<ConditionKind> getEntries() {
            return $ENTRIES;
        }

        public static ConditionKind valueOf(String str) {
            return (ConditionKind) Enum.valueOf(ConditionKind.class, str);
        }

        public static ConditionKind[] values() {
            return (ConditionKind[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NetKind {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ NetKind[] $VALUES;
        public static final NetKind NONE = new NetKind(ModelFlowMeta.PLAN_NONE, 0);
        public static final NetKind WIFI = new NetKind("WIFI", 1);
        public static final NetKind CELLULAR = new NetKind("CELLULAR", 2);
        public static final NetKind OTHER = new NetKind("OTHER", 3);

        private static final /* synthetic */ NetKind[] $values() {
            return new NetKind[]{NONE, WIFI, CELLULAR, OTHER};
        }

        static {
            NetKind[] netKindArr$values = $values();
            $VALUES = netKindArr$values;
            $ENTRIES = kotlin.enums.a.a(netKindArr$values);
        }

        private NetKind(String str, int i10) {
        }

        public static sb.a<NetKind> getEntries() {
            return $ENTRIES;
        }

        public static NetKind valueOf(String str) {
            return (NetKind) Enum.valueOf(NetKind.class, str);
        }

        public static NetKind[] values() {
            return (NetKind[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ReminderMeta {
        private final String label;
        private final long sizeBytes;
        private final String updateInfo;

        public ReminderMeta(String label, long j10, String updateInfo) {
            g.f(label, "label");
            g.f(updateInfo, "updateInfo");
            this.label = label;
            this.sizeBytes = j10;
            this.updateInfo = updateInfo;
        }

        public static /* synthetic */ ReminderMeta copy$default(ReminderMeta reminderMeta, String str, long j10, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = reminderMeta.label;
            }
            if ((i10 & 2) != 0) {
                j10 = reminderMeta.sizeBytes;
            }
            if ((i10 & 4) != 0) {
                str2 = reminderMeta.updateInfo;
            }
            return reminderMeta.copy(str, j10, str2);
        }

        public final String component1() {
            return this.label;
        }

        public final long component2() {
            return this.sizeBytes;
        }

        public final String component3() {
            return this.updateInfo;
        }

        public final ReminderMeta copy(String label, long j10, String updateInfo) {
            g.f(label, "label");
            g.f(updateInfo, "updateInfo");
            return new ReminderMeta(label, j10, updateInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReminderMeta)) {
                return false;
            }
            ReminderMeta reminderMeta = (ReminderMeta) obj;
            return g.b(this.label, reminderMeta.label) && this.sizeBytes == reminderMeta.sizeBytes && g.b(this.updateInfo, reminderMeta.updateInfo);
        }

        public final String getLabel() {
            return this.label;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public final String getUpdateInfo() {
            return this.updateInfo;
        }

        public int hashCode() {
            return this.updateInfo.hashCode() + a0.a.c(this.label.hashCode() * 31, this.sizeBytes, 31);
        }

        public String toString() {
            String str = this.label;
            long j10 = this.sizeBytes;
            return ai.onnxruntime.a.p(d.l("ReminderMeta(label=", j10, str, ", sizeBytes="), ", updateInfo=", this.updateInfo, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[NetKind.values().length];
            try {
                iArr[NetKind.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetKind.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetKind.CELLULAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NetKind.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DownloadResourceGate.Verdict.values().length];
            try {
                iArr2[DownloadResourceGate.Verdict.INSUFFICIENT_SPACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[DownloadResourceGate.Verdict.LOW_BATTERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor$promptCellularOnPage$1", f = "ActiveDownloadConditionMonitor.kt", l = {348}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor$promptCellularOnPage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ String $otaId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$otaId = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n invokeSuspend$lambda$1(String str, CoroutineScope coroutineScope, ConfirmDecisionBus.Decision decision) {
            String str2;
            if (decision == ConfirmDecisionBus.Decision.CONFIRM_CELLULAR) {
                ActiveDownloadConditionMonitor.cellularApproved.add(str);
                ActiveDownloadConditionMonitor.INSTANCE.cancelNotify(ConditionKind.WIFI_TO_CELLULAR);
                try {
                    str2 = str;
                    try {
                        OtaDispatcher.DefaultImpls.download$default(OtaRuntime.INSTANCE.dispatcher(), str2, TriggerSource.USER, null, null, true, 12, null);
                    } catch (Throwable th) {
                        th = th;
                        kotlin.c.a(th);
                        e.k("wifi→cellular: continue on cellular otaId=", str2, LogModule.OTA, ActiveDownloadConditionMonitor.TAG);
                        return n.f10413a;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str;
                }
                e.k("wifi→cellular: continue on cellular otaId=", str2, LogModule.OTA, ActiveDownloadConditionMonitor.TAG);
            } else {
                e.k("wifi→cellular: canceled, stay paused otaId=", str, LogModule.OTA, ActiveDownloadConditionMonitor.TAG);
            }
            return n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$otaId, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final CoroutineScope coroutineScope;
            String label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                CoroutineDispatcher io = Dispatchers.getIO();
                ActiveDownloadConditionMonitor$promptCellularOnPage$1$meta$1 activeDownloadConditionMonitor$promptCellularOnPage$1$meta$1 = new ActiveDownloadConditionMonitor$promptCellularOnPage$1$meta$1(this.$otaId, null);
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object objWithContext = BuildersKt.withContext(io, activeDownloadConditionMonitor$promptCellularOnPage$1$meta$1, this);
                if (objWithContext == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope = coroutineScope2;
                obj = objWithContext;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                kotlin.c.b(obj);
            }
            Pair pair = (Pair) obj;
            ActiveDownloadConditionMonitor.resolvingMeta.remove(this.$otaId);
            int iIntValue = ((Number) pair.f9985a).intValue();
            ReminderMeta reminderMeta = (ReminderMeta) pair.f9986b;
            String str = iIntValue > 0 ? ModelFlowMeta.PLAN_UPD_WIFI_TO_CELLULAR : ModelFlowMeta.PLAN_DL_WIFI_TO_CELLULAR;
            ActiveDownloadConditionMonitor activeDownloadConditionMonitor = ActiveDownloadConditionMonitor.INSTANCE;
            String str2 = this.$otaId;
            long sizeBytes = reminderMeta != null ? reminderMeta.getSizeBytes() : 0L;
            if (reminderMeta == null || (label = reminderMeta.getLabel()) == null) {
                label = this.$otaId;
            }
            String str3 = label;
            String updateInfo = reminderMeta != null ? reminderMeta.getUpdateInfo() : null;
            if (updateInfo == null) {
                updateInfo = "";
            }
            final String str4 = this.$otaId;
            activeDownloadConditionMonitor.showConfirm(str2, str, sizeBytes, str3, updateInfo, new l() { // from class: com.stepos.core.ota.monitor.b
                @Override // zb.l
                public final Object invoke(Object obj2) {
                    return ActiveDownloadConditionMonitor.AnonymousClass1.invokeSuspend$lambda$1(str4, coroutineScope, (ConfirmDecisionBus.Decision) obj2);
                }
            });
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor$scheduleSettle$1", f = "ActiveDownloadConditionMonitor.kt", l = {233}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor$scheduleSettle$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04011 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        public C04011(qb.b<? super C04011> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04011(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                this.label = 1;
                if (DelayKt.delay(ActiveDownloadConditionMonitor.SETTLE_MS, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            ActiveDownloadConditionMonitor.INSTANCE.settleNetwork();
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04011) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor$start$1", f = "ActiveDownloadConditionMonitor.kt", l = {147}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04021 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        public C04021(qb.b<? super C04021> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04021(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                StateFlow<Map<String, OtaStateSnapshot>> stateFlowTaskStateFlow = OtaRuntime.INSTANCE.taskStateFlow();
                FlowCollector<? super Map<String, OtaStateSnapshot>> flowCollector = new FlowCollector() { // from class: com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor.start.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, qb.b bVar) {
                        return emit((Map<String, OtaStateSnapshot>) obj2, (qb.b<? super n>) bVar);
                    }

                    public final Object emit(Map<String, OtaStateSnapshot> map, qb.b<? super n> bVar) {
                        ActiveDownloadConditionMonitor activeDownloadConditionMonitor = ActiveDownloadConditionMonitor.INSTANCE;
                        activeDownloadConditionMonitor.recomputeSets(map);
                        if (ActiveDownloadConditionMonitor.inFlightFg.isEmpty()) {
                            activeDownloadConditionMonitor.stopListeners();
                        } else {
                            activeDownloadConditionMonitor.startListeners();
                        }
                        activeDownloadConditionMonitor.onConditionTick();
                        activeDownloadConditionMonitor.syncNetworkNotifications();
                        return n.f10413a;
                    }
                };
                this.label = 1;
                if (stateFlowTaskStateFlow.collect(flowCollector, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04021) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private ActiveDownloadConditionMonitor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelNotify(ConditionKind conditionKind) {
        l<? super ConditionKind, n> lVar = conditionBreakNotifyCanceller;
        if (lVar == null) {
            return;
        }
        try {
            lVar.invoke(conditionKind);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    private final NetKind classify(NetworkCapabilities networkCapabilities) {
        return !networkCapabilities.hasCapability(12) ? NetKind.NONE : networkCapabilities.hasTransport(1) ? NetKind.WIFI : networkCapabilities.hasTransport(0) ? NetKind.CELLULAR : NetKind.OTHER;
    }

    private final NetKind currentNet() {
        Context context = appCtx;
        if (context == null) {
            return NetKind.OTHER;
        }
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return NetKind.OTHER;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return NetKind.NONE;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        return networkCapabilities == null ? NetKind.NONE : classify(networkCapabilities);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchTrampoline(Context context, String str, String str2, String str3, long j10, String str4, String str5) {
        Object objA;
        try {
            context.startActivity(OtaConfirmTrampolineActivity.Companion.newIntent(context, str, str2, j10, str4, str5, (448 & 64) != 0 ? "" : null, (448 & TraceIdKeys.MAX_LENGTH) != 0 ? 0L : 0L, (448 & 256) != 0 ? false : false));
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            prompting.remove(str3);
            ConfirmDecisionBus.INSTANCE.clear(str);
            AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("startActivity(trampoline) failed otaId=", str3), thB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean managerForeground$lambda$0() {
        return false;
    }

    private final boolean notifyIfOffPage(String str, ConditionKind conditionKind) {
        p<? super String, ? super ConditionKind, n> pVar = conditionBreakNotifier;
        if (managerForeground.invoke().booleanValue() || pVar == null) {
            return false;
        }
        try {
            pVar.invoke(str, conditionKind);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        AIEngineLogger.i(LogModule.OTA, TAG, "condition break → notify (not on manager page) otaId=" + str + " kind=" + conditionKind);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void onConditionTick() {
        Context context;
        Pair pair;
        ConcurrentHashMap.KeySetView<String, Boolean> downloadingFg2 = downloadingFg;
        if (downloadingFg2.isEmpty() || (context = appCtx) == null) {
            return;
        }
        AutoUpdateEnv autoUpdateEnv = AutoUpdateEnv.INSTANCE;
        DownloadResourceGate.Verdict verdictEvaluate = DownloadResourceGate.INSTANCE.evaluate(autoUpdateEnv.freeBytes(context), 0L, autoUpdateEnv.batteryPct(context), autoUpdateEnv.isCharging(context));
        if (verdictEvaluate == DownloadResourceGate.Verdict.OK) {
            conditionGatePrompted = false;
            return;
        }
        int i10 = WhenMappings.$EnumSwitchMapping$1[verdictEvaluate.ordinal()];
        if (i10 == 1) {
            pair = new Pair(ModelFlowMeta.PLAN_GATE_INSUFFICIENT_SPACE, ConditionKind.LOW_STORAGE);
        } else if (i10 != 2) {
            return;
        } else {
            pair = new Pair(ModelFlowMeta.PLAN_GATE_LOW_BATTERY, ConditionKind.LOW_BATTERY);
        }
        String str = (String) pair.f9985a;
        ConditionKind conditionKind = (ConditionKind) pair.f9986b;
        g.e(downloadingFg2, "downloadingFg");
        List<String> listO0 = kotlin.collections.a.O0(downloadingFg2);
        for (String str2 : listO0) {
            ActiveDownloadConditionMonitor activeDownloadConditionMonitor = INSTANCE;
            g.c(str2);
            activeDownloadConditionMonitor.pause(str2);
        }
        if (conditionGatePrompted) {
            return;
        }
        conditionGatePrompted = true;
        String str3 = (String) kotlin.collections.a.v0(listO0);
        if (str3 == null) {
            return;
        }
        pauseAndBlock(str3, str, conditionKind);
    }

    private final void onNoNetwork() {
        ConcurrentHashMap.KeySetView<String, Boolean> inFlightFg2 = inFlightFg;
        if (inFlightFg2.isEmpty()) {
            return;
        }
        g.e(inFlightFg2, "inFlightFg");
        List<String> listO0 = kotlin.collections.a.O0(inFlightFg2);
        for (String str : listO0) {
            ActiveDownloadConditionMonitor activeDownloadConditionMonitor = INSTANCE;
            g.c(str);
            activeDownloadConditionMonitor.pause(str);
        }
        Object objT0 = kotlin.collections.a.t0(listO0);
        g.e(objT0, "first(...)");
        if (notifyIfOffPage((String) objT0, ConditionKind.NO_NETWORK)) {
            AIEngineLogger.i(LogModule.OTA, TAG, "no network → notify (not on manager page), inFlight=" + listO0.size());
            return;
        }
        if (noNetworkToasted) {
            return;
        }
        noNetworkToasted = true;
        Context context = appCtx;
        if (context != null) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new ActiveDownloadConditionMonitor$onNoNetwork$2$1(context, null), 3, null);
        }
        AIEngineLogger.i(LogModule.OTA, TAG, "no network → pause + toast, inFlight=" + listO0.size());
    }

    private final void onSwitchChanged() {
        Context context = appCtx;
        if (context == null) {
            return;
        }
        ConcurrentHashMap.KeySetView<String, Boolean> inFlightFg2 = inFlightFg;
        if (inFlightFg2.isEmpty()) {
            return;
        }
        AiEngineSystemSettings aiEngineSystemSettings = AiEngineSystemSettings.INSTANCE;
        if (aiEngineSystemSettings.isCtaAgreed(context, true) && aiEngineSystemSettings.isModelServiceEnabled(context, true)) {
            return;
        }
        g.e(inFlightFg2, "inFlightFg");
        List<String> listO0 = kotlin.collections.a.O0(inFlightFg2);
        for (String str : listO0) {
            ActiveDownloadConditionMonitor activeDownloadConditionMonitor = INSTANCE;
            g.c(str);
            activeDownloadConditionMonitor.pause(str);
        }
        AIEngineLogger.i(LogModule.OTA, TAG, "CTA/service switch off → pause in-flight foreground downloads, count=" + listO0.size());
    }

    private final void onWifiToCellular() {
        ConcurrentHashMap.KeySetView<String, Boolean> inFlightFg2 = inFlightFg;
        if (inFlightFg2.isEmpty()) {
            return;
        }
        g.e(inFlightFg2, "inFlightFg");
        ArrayList arrayList = new ArrayList();
        for (Object obj : inFlightFg2) {
            if (!cellularApproved.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj2 = arrayList.get(i11);
            i11++;
            String str = (String) obj2;
            ActiveDownloadConditionMonitor activeDownloadConditionMonitor = INSTANCE;
            g.c(str);
            activeDownloadConditionMonitor.pause(str);
        }
        Object objT0 = kotlin.collections.a.t0(arrayList);
        g.e(objT0, "first(...)");
        if (notifyIfOffPage((String) objT0, ConditionKind.WIFI_TO_CELLULAR)) {
            AIEngineLogger.i(LogModule.OTA, TAG, "wifi→cellular → single aggregated notify, inFlight=" + arrayList.size());
            return;
        }
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj3 = arrayList.get(i10);
            i10++;
            String str2 = (String) obj3;
            if (!prompting.contains(str2)) {
                ActiveDownloadConditionMonitor activeDownloadConditionMonitor2 = INSTANCE;
                g.c(str2);
                activeDownloadConditionMonitor2.promptCellularOnPage(str2);
            }
        }
    }

    private final void pause(String str) {
        Object objA;
        try {
            objA = Boolean.valueOf(OtaDispatcher.DefaultImpls.pause$default(OtaRuntime.INSTANCE.dispatcher(), str, null, 2, null));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("pause failed otaId=", str), thB);
        }
    }

    private final void pauseAndBlock(String str, String str2, ConditionKind conditionKind) {
        pause(str);
        if (notifyIfOffPage(str, conditionKind)) {
            return;
        }
        showConfirm$default(this, str, str2, 0L, null, null, new f(1, str, str2), 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n pauseAndBlock$lambda$17(String str, String str2, ConfirmDecisionBus.Decision it) {
        g.f(it, "it");
        AIEngineLogger.i(LogModule.OTA, TAG, ai.onnxruntime.a.l("condition block dismissed, stay paused otaId=", str, " plan=", str2));
        return n.f10413a;
    }

    private final void promptCellularOnPage(String str) {
        if (resolvingMeta.add(str)) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(str, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recomputeSets(Map<String, OtaStateSnapshot> map) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (Map.Entry<String, OtaStateSnapshot> entry : map.entrySet()) {
            String key = entry.getKey();
            OtaStateSnapshot value = entry.getValue();
            if (ActiveDownloadConditionMonitorKt.decideConditionInFlight(value.isForeground(), value.getState())) {
                hashSet2.add(key);
                if (value.getState() instanceof OtaState.Downloading) {
                    hashSet.add(key);
                }
            }
        }
        ConcurrentHashMap.KeySetView<String, Boolean> keySetView = downloadingFg;
        keySetView.clear();
        keySetView.addAll(hashSet);
        ConcurrentHashMap.KeySetView<String, Boolean> keySetView2 = inFlightFg;
        keySetView2.clear();
        keySetView2.addAll(hashSet2);
        prompting.retainAll(hashSet2);
        resolvingMeta.retainAll(hashSet2);
        cellularApproved.retainAll(hashSet2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleSettle() {
        Job job = settleJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        settleJob = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C04011(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void settleNetwork() {
        NetKind netKindCurrentNet = currentNet();
        NetKind netKind = lastNet;
        lastNet = netKindCurrentNet;
        NetKind netKind2 = NetKind.NONE;
        if (netKindCurrentNet != netKind2) {
            noNetworkToasted = false;
        }
        if (netKindCurrentNet == netKind2) {
            onNoNetwork();
        } else if (netKind == NetKind.WIFI && netKindCurrentNet == NetKind.CELLULAR) {
            onWifiToCellular();
        }
        onConditionTick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showConfirm(final String str, final String str2, final long j10, final String str3, final String str4, l<? super ConfirmDecisionBus.Decision, n> lVar) {
        final Context context = appCtx;
        if (context != null && prompting.add(str)) {
            final String strRegister = ConfirmDecisionBus.INSTANCE.register(new i(1, str, lVar), new d(5));
            ConfirmUiHost confirmUiHost = onPageConfirmHost;
            if (confirmUiHost == null) {
                launchTrampoline(context, strRegister, str2, str, j10, str3, str4);
                return;
            }
            confirmUiHost.show(new ConfirmUiRequest(strRegister, new ConfirmDialogParams(str2, j10, str3, str4, false, false, 48, null), "", 0L, new zb.a() { // from class: com.stepos.core.ota.monitor.a
                @Override // zb.a
                public final Object invoke() {
                    return ActiveDownloadConditionMonitor.showConfirm$lambda$25(context, strRegister, str2, str, j10, str3, str4);
                }
            }));
        }
    }

    public static /* synthetic */ void showConfirm$default(ActiveDownloadConditionMonitor activeDownloadConditionMonitor, String str, String str2, long j10, String str3, String str4, l lVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 0;
        }
        activeDownloadConditionMonitor.showConfirm(str, str2, j10, (i10 & 8) != 0 ? str : str3, (i10 & 16) != 0 ? "" : str4, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirm$lambda$23(String str, l lVar, ConfirmDecisionBus.Decision d8) {
        g.f(d8, "d");
        prompting.remove(str);
        try {
            lVar.invoke(d8);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n showConfirm$lambda$25(Context context, String str, String str2, String str3, long j10, String str4, String str5) {
        INSTANCE.launchTrampoline(context, str, str2, str3, j10, str4, str5);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void startListeners() {
        Object objA;
        if (listening) {
            return;
        }
        Context context = appCtx;
        if (context == null) {
            return;
        }
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return;
        }
        lastNet = currentNet();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor$startListeners$cb$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities caps) {
                g.f(network, "network");
                g.f(caps, "caps");
                ActiveDownloadConditionMonitor.INSTANCE.scheduleSettle();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                g.f(network, "network");
                ActiveDownloadConditionMonitor.INSTANCE.scheduleSettle();
            }
        };
        try {
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            netCallback = networkCallback;
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, "registerDefaultNetworkCallback failed", thB);
        }
        switchObserver = AiEngineSystemSettings.INSTANCE.registerSwitchObserver(context, new a9.b(20));
        listening = true;
        AIEngineLogger.i(LogModule.OTA, TAG, "listeners on (in-flight foreground download)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n startListeners$lambda$5() {
        INSTANCE.onSwitchChanged();
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void stopListeners() {
        try {
            if (listening) {
                Context context = appCtx;
                Object systemService = context != null ? context.getSystemService("connectivity") : null;
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                ConnectivityManager.NetworkCallback networkCallback = netCallback;
                if (networkCallback != null && connectivityManager != null) {
                    try {
                        connectivityManager.unregisterNetworkCallback(networkCallback);
                        n nVar = n.f10413a;
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                }
                netCallback = null;
                ContentObserver contentObserver = switchObserver;
                if (contentObserver != null && context != null) {
                    AiEngineSystemSettings.INSTANCE.unregisterSwitchObserver(context, contentObserver);
                }
                switchObserver = null;
                Job job = settleJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                settleJob = null;
                listening = false;
                noNetworkToasted = false;
                conditionGatePrompted = false;
                AIEngineLogger.i(LogModule.OTA, TAG, "listeners off (no in-flight foreground download)");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncNetworkNotifications() {
        if (downloadingFg.isEmpty()) {
            return;
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[currentNet().ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                cancelNotify(ConditionKind.NO_NETWORK);
                cancelNotify(ConditionKind.WIFI_TO_CELLULAR);
            } else {
                if (i10 != 3 && i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                cancelNotify(ConditionKind.NO_NETWORK);
            }
        }
    }

    public final p<String, ConditionKind, n> getConditionBreakNotifier() {
        return conditionBreakNotifier;
    }

    public final l<ConditionKind, n> getConditionBreakNotifyCanceller() {
        return conditionBreakNotifyCanceller;
    }

    public final zb.a<Boolean> getManagerForeground() {
        return managerForeground;
    }

    public final ConfirmUiHost getOnPageConfirmHost() {
        return onPageConfirmHost;
    }

    public final l<String, ReminderMeta> getReminderMetaProvider() {
        return reminderMetaProvider;
    }

    public final void setConditionBreakNotifier(p<? super String, ? super ConditionKind, n> pVar) {
        conditionBreakNotifier = pVar;
    }

    public final void setConditionBreakNotifyCanceller(l<? super ConditionKind, n> lVar) {
        conditionBreakNotifyCanceller = lVar;
    }

    public final void setManagerForeground(zb.a<Boolean> aVar) {
        g.f(aVar, "<set-?>");
        managerForeground = aVar;
    }

    public final void setOnPageConfirmHost(ConfirmUiHost confirmUiHost) {
        onPageConfirmHost = confirmUiHost;
    }

    public final void setReminderMetaProvider(l<? super String, ReminderMeta> lVar) {
        reminderMetaProvider = lVar;
    }

    public final void start(Context context) {
        g.f(context, "context");
        if (OtaProcess.INSTANCE.isOtaProcess(context) || started) {
            return;
        }
        started = true;
        appCtx = context.getApplicationContext();
        lastNet = currentNet();
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C04021(null), 3, null);
        AIEngineLogger.i(LogModule.OTA, TAG, "ActiveDownloadConditionMonitor started");
    }
}
