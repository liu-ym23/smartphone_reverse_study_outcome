package com.stepos.core.ota.confirmui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.aiengine.flow.ModelFlowStage;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.deepbinder.ICtaResultCallback;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelConfirmFlow {
    private static final String PERF_TAG = "OtaConfirmPerf";
    private static final long STALE_TTL_MS = 300000;
    private static final String TAG = "ModelConfirmFlow";
    private final String algorithmId;
    private Context appContext;
    private final zb.a<lb.n> attachOnConfirm;
    private final ConfirmUiHost confirmHost;
    private ICtaResultCallback ctaCallback;
    private String dedupeKey;
    private final Object dedupeLock;
    private final String displayLabel;
    private final AtomicBoolean downloadingPosted;
    private e6.a flowCallback;
    private final ArrayList<Follower> followers;
    private final ModelConfirmFlow$internalCb$1 internalCb;
    private boolean isResume;
    private boolean isRetry;
    private volatile ModelFlowStage lastStage;
    private volatile ConfirmDecisionBus.SubStage lastSubStage;
    private final Handler main;
    private final Mode mode;
    private String pendingLabel;
    private long pendingSizeBytes;
    private String pendingUpdateInfo;
    private final long perfT0;
    private final String perfTraceId;
    private volatile Phase phase;
    private IDownloadCallback progressCallback;
    private String reqId;
    private boolean resumeConfirm;
    private CoroutineScope scope;
    private final AtomicBoolean sessionBegun;
    private final long startedAtMs;
    private IOtaDeepBinderService svc;
    private final AtomicBoolean terminated;
    private ConfirmUiHost uiHost;
    private final boolean updateConfirmFirst;
    public static final Companion Companion = new Companion(null);
    private static final ConcurrentHashMap<String, ModelConfirmFlow> inFlight = new ConcurrentHashMap<>();
    private static final ModelConfirmFlow$Companion$NO_OP_CALLBACK$1 NO_OP_CALLBACK = new e6.a() { // from class: com.stepos.core.ota.confirmui.ModelConfirmFlow$Companion$NO_OP_CALLBACK$1
        @Override // e6.a
        public void onFailed(int i10, String message) {
            kotlin.jvm.internal.g.f(message, "message");
        }

        @Override // e6.a
        public void onStateChanged(ModelFlowStage stage) {
            kotlin.jvm.internal.g.f(stage, "stage");
        }

        @Override // e6.a
        public void onReady(boolean z) {
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean detachCallback$lambda$4$lambda$3$lambda$2(e6.a aVar, Follower it) {
            kotlin.jvm.internal.g.f(it, "it");
            return it.getFlowCallback() == aVar;
        }

        public final int clearAllCallbacks(String algorithmId) {
            kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
            int i10 = 0;
            for (Map.Entry entry : ModelConfirmFlow.inFlight.entrySet()) {
                String str = (String) entry.getKey();
                ModelConfirmFlow modelConfirmFlow = (ModelConfirmFlow) entry.getValue();
                if (gc.o.k0(str, algorithmId.concat("#"), false)) {
                    synchronized (modelConfirmFlow.dedupeLock) {
                        try {
                            modelConfirmFlow.followers.clear();
                            if (!modelConfirmFlow.terminated.get()) {
                                modelConfirmFlow.phase = Phase.DETACHED;
                            }
                            lb.n nVar = lb.n.f10413a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    modelConfirmFlow.releaseBusinessCallbacks();
                    i10++;
                }
            }
            if (i10 > 0) {
                Log.i(ModelConfirmFlow.TAG, ai.onnxruntime.a.i("[DIAG] clearAllCallbacks ", i10, algorithmId, ": ", " flow(s) unbound"));
            }
            return i10;
        }

        public final boolean detachCallback(String algorithmId, e6.a callback) {
            kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
            kotlin.jvm.internal.g.f(callback, "callback");
            int i10 = 0;
            boolean z = false;
            for (Map.Entry entry : ModelConfirmFlow.inFlight.entrySet()) {
                String str = (String) entry.getKey();
                ModelConfirmFlow modelConfirmFlow = (ModelConfirmFlow) entry.getValue();
                if (gc.o.k0(str, algorithmId.concat("#"), false)) {
                    synchronized (modelConfirmFlow.dedupeLock) {
                        try {
                            if (mb.q.i0(modelConfirmFlow.followers, new l(callback, i10))) {
                                z = true;
                            }
                            if (modelConfirmFlow.ownerCallbackIs(callback)) {
                                modelConfirmFlow.flowCallback = ModelConfirmFlow.NO_OP_CALLBACK;
                                modelConfirmFlow.progressCallback = null;
                                z = true;
                            }
                            if (modelConfirmFlow.followers.isEmpty() && !modelConfirmFlow.terminated.get()) {
                                modelConfirmFlow.phase = Phase.DETACHED;
                            }
                            lb.n nVar = lb.n.f10413a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
            if (z) {
                Log.i(ModelConfirmFlow.TAG, "[DIAG] detachCallback " + algorithmId + ": business callback unbound");
            }
            return z;
        }

        public final void markDetachedFromExternalControl(String algorithmId) {
            kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
            for (Map.Entry entry : ModelConfirmFlow.inFlight.entrySet()) {
                String str = (String) entry.getKey();
                ModelConfirmFlow modelConfirmFlow = (ModelConfirmFlow) entry.getValue();
                if (gc.o.k0(str, algorithmId.concat("#"), false)) {
                    synchronized (modelConfirmFlow.dedupeLock) {
                        try {
                            if (!modelConfirmFlow.terminated.get() && modelConfirmFlow.phase == Phase.RUNNING) {
                                modelConfirmFlow.phase = Phase.DETACHED;
                                modelConfirmFlow.downloadingPosted.set(false);
                                ModelConfirmFlow.inFlight.remove(str, modelConfirmFlow);
                            }
                            lb.n nVar = lb.n.f10413a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Follower {
        private final e6.a flowCallback;
        private final IDownloadCallback progressCallback;

        public Follower(e6.a flowCallback, IDownloadCallback iDownloadCallback) {
            kotlin.jvm.internal.g.f(flowCallback, "flowCallback");
            this.flowCallback = flowCallback;
            this.progressCallback = iDownloadCallback;
        }

        public final e6.a getFlowCallback() {
            return this.flowCallback;
        }

        public final IDownloadCallback getProgressCallback() {
            return this.progressCallback;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Mode {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode DOWNLOAD = new Mode("DOWNLOAD", 0);
        public static final Mode UPDATE = new Mode("UPDATE", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{DOWNLOAD, UPDATE};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = kotlin.enums.a.a(modeArr$values);
        }

        private Mode(String str, int i10) {
        }

        public static sb.a<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Phase {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ Phase[] $VALUES;
        public static final Phase INTERACTIVE = new Phase("INTERACTIVE", 0);
        public static final Phase RUNNING = new Phase("RUNNING", 1);
        public static final Phase DETACHED = new Phase("DETACHED", 2);

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{INTERACTIVE, RUNNING, DETACHED};
        }

        static {
            Phase[] phaseArr$values = $values();
            $VALUES = phaseArr$values;
            $ENTRIES = kotlin.enums.a.a(phaseArr$values);
        }

        private Phase(String str, int i10) {
        }

        public static sb.a<Phase> getEntries() {
            return $ENTRIES;
        }

        public static Phase valueOf(String str) {
            return (Phase) Enum.valueOf(Phase.class, str);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ConfirmDecisionBus.Decision.values().length];
            try {
                iArr[ConfirmDecisionBus.Decision.SCHEDULE_WIFI_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.CONFIRM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.CONFIRM_CELLULAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.ENABLE_WIFI_AUTO_AND_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.ENABLE_WIFI_AUTO_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.CANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.OPEN_SERVICE_SETTINGS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConfirmDecisionBus.SubStage.values().length];
            try {
                iArr2[ConfirmDecisionBus.SubStage.CELLULAR_REMINDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ConfirmDecisionBus.SubStage.WIFI_GUIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.confirmui.ModelConfirmFlow$startInferencePreflight$1", f = "ModelConfirmFlow.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.confirmui.ModelConfirmFlow$startInferencePreflight$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ IOtaDeepBinderService $service;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(IOtaDeepBinderService iOtaDeepBinderService, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$service = iOtaDeepBinderService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return ModelConfirmFlow.this.new AnonymousClass1(this.$service, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            ModelConfirmFlow.this.runPreflight(this.$service);
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode) {
        this(algorithmId, mode, null, 0L, null, null, null, false, 252, null);
        kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
        kotlin.jvm.internal.g.f(mode, "mode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void afterCta(IOtaDeepBinderService iOtaDeepBinderService) {
        Object objA;
        Object objA2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        perf("FETCH_META_START", "modelId=" + this.algorithmId + " mode=" + this.mode);
        try {
            objA = this.mode == Mode.DOWNLOAD ? iOtaDeepBinderService.fetchDownloadMeta(this.algorithmId) : iOtaDeepBinderService.fetchUpdateMeta(this.algorithmId);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            String message = thB.getMessage();
            if (message == null) {
                message = "fetchMeta failed";
            }
            fail(5901, message);
            return;
        }
        Bundle bundle = (Bundle) objA;
        if (!bundle.getBoolean(ModelFlowMeta.KEY_SERVICE_ENABLED, true)) {
            Log.i(TAG, "[DIAG] afterCta " + this.algorithmId + " model service disabled → gate dialog");
            showResourceGateBlocked(ModelFlowMeta.GATE_ERROR_SERVICE_DISABLED);
            return;
        }
        if (bundle.getBoolean(ModelFlowMeta.KEY_CTA_BLOCKED, false)) {
            Log.i(TAG, "[DIAG] afterCta " + this.algorithmId + " fetch blocked by CTA → CTA_DENIED");
            fail(4001, "fetch blocked: CTA not granted");
            return;
        }
        boolean z = bundle.getBoolean(ModelFlowMeta.KEY_FETCH_OK, false);
        boolean z3 = bundle.getBoolean(ModelFlowMeta.KEY_REMOTE_AVAILABLE, false);
        boolean z10 = bundle.getBoolean(ModelFlowMeta.KEY_SERVER_REACHED, false);
        boolean z11 = bundle.getBoolean(ModelFlowMeta.KEY_HAS_UPDATE);
        StringBuilder sbL = com.stepos.core.ota.d.l("modelId=", SystemClock.elapsedRealtime() - jElapsedRealtime, this.algorithmId, " dur=");
        sbL.append("ms fetchOk=");
        sbL.append(z);
        sbL.append(" remoteAvailable=");
        sbL.append(z3);
        sbL.append(" serverReached=");
        sbL.append(z10);
        sbL.append(" hasUpdate=");
        sbL.append(z11);
        perf("FETCH_META_DONE", sbL.toString());
        Log.i(TAG, "[DIAG] afterCta " + this.algorithmId + " mode=" + this.mode + " fetchOk=" + z + " remoteAvailable=" + z3 + " serverReached=" + z10 + " hasUpdate=" + z11);
        int iIntValue = ModelFlowMeta.ENV_ERROR_NO_NETWORK;
        if (!z3 && !z10) {
            fail(ModelFlowMeta.ENV_ERROR_NO_NETWORK, "server unreachable, no cached data");
            return;
        }
        long j10 = bundle.getLong("sizeBytes");
        String string = this.displayLabel;
        if (gc.q.t0(string) && (string = bundle.getString("modelLabel")) == null) {
            string = this.algorithmId;
        }
        String str = string;
        String string2 = bundle.getString("updateInfo");
        if (string2 == null) {
            string2 = "";
        }
        String str2 = string2;
        String string3 = bundle.getString("plan");
        String str3 = string3 == null ? ModelFlowMeta.PLAN_NONE : string3;
        if (!z3) {
            Log.i(TAG, "[DIAG] afterCta " + this.algorithmId + " model not available (server reached, no entry) → MODEL_NOT_AVAILABLE");
            fail(5006, "model not available on server");
            return;
        }
        if (this.mode == Mode.UPDATE && !z11) {
            fail(5003, "already up to date");
            return;
        }
        if (str3.equals(ModelFlowMeta.PLAN_NO_NETWORK) || str3.equals(ModelFlowMeta.PLAN_NONE)) {
            fail(ModelFlowMeta.ENV_ERROR_NO_NETWORK, "no network");
            return;
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        try {
            objA2 = iOtaDeepBinderService.queryPrecheckEnv();
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        if (objA2 instanceof Result.Failure) {
            objA2 = null;
        }
        Bundle bundle2 = (Bundle) objA2;
        String str4 = this.algorithmId;
        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
        Boolean boolValueOf = bundle2 != null ? Boolean.valueOf(bundle2.getBoolean(ModelFlowMeta.KEY_ENV_OK, true)) : null;
        StringBuilder sbL2 = com.stepos.core.ota.d.l("modelId=", jElapsedRealtime3, str4, " dur=");
        sbL2.append("ms envOk=");
        sbL2.append(boolValueOf);
        perf("PRECHECK_DONE", sbL2.toString());
        if (bundle2 == null || bundle2.getBoolean(ModelFlowMeta.KEY_ENV_OK, true)) {
            showConfirm(iOtaDeepBinderService, str3, j10, str, str2);
            return;
        }
        int i10 = bundle2.getInt(ModelFlowMeta.KEY_ENV_ERROR, 0);
        Integer numValueOf = i10 != 0 ? Integer.valueOf(i10) : null;
        if (numValueOf != null) {
            iIntValue = numValueOf.intValue();
        }
        fail(iIntValue, "env precheck failed");
    }

    private final void becomeOwner(Context context, String str, e6.a aVar, IDownloadCallback iDownloadCallback, CoroutineScope coroutineScope) {
        this.flowCallback = aVar;
        this.progressCallback = iDownloadCallback;
        this.scope = coroutineScope;
        ConfirmUiHost trampolineConfirmHost = this.confirmHost;
        if (trampolineConfirmHost == null) {
            Context context2 = this.appContext;
            if (context2 == null) {
                kotlin.jvm.internal.g.l("appContext");
                throw null;
            }
            trampolineConfirmHost = new TrampolineConfirmHost(context2);
        }
        this.uiHost = trampolineConfirmHost;
        this.dedupeKey = str;
        synchronized (this.dedupeLock) {
            this.followers.add(new Follower(aVar, iDownloadCallback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int canceledCodeForCurrentStep() {
        ConfirmDecisionBus.SubStage subStage = this.lastSubStage;
        int i10 = subStage == null ? -1 : WhenMappings.$EnumSwitchMapping$1[subStage.ordinal()];
        if (i10 == -1) {
            return userCanceledCode();
        }
        if (i10 == 1) {
            return 4003;
        }
        if (i10 == 2) {
            return 4005;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void cleanup() {
        Object objA;
        try {
            IOtaDeepBinderService iOtaDeepBinderService = this.svc;
            if (iOtaDeepBinderService != null) {
                iOtaDeepBinderService.unregisterDownloadCallback(this.algorithmId, this.internalCb);
                lb.n nVar = lb.n.f10413a;
            }
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        try {
            n9.b bVar = n9.b.f10675a;
            n9.b.b(this.internalCb);
            objA = lb.n.f10413a;
        } catch (Throwable th2) {
            objA = kotlin.c.a(th2);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w(TAG, "[DIAG] CallbackCache.removeCallback failed " + this.algorithmId, thB);
        }
        if (this.sessionBegun.compareAndSet(true, false)) {
            try {
                IOtaDeepBinderService iOtaDeepBinderService2 = this.svc;
                if (iOtaDeepBinderService2 != null) {
                    iOtaDeepBinderService2.endInteractiveSession(this.algorithmId);
                    lb.n nVar2 = lb.n.f10413a;
                }
            } catch (Throwable th3) {
                kotlin.c.a(th3);
            }
        }
        String str = this.reqId;
        if (str != null) {
            ConfirmDecisionBus.INSTANCE.clear(str);
        }
        this.ctaCallback = null;
    }

    public static final int clearAllCallbacks(String str) {
        return Companion.clearAllCallbacks(str);
    }

    private final List<e6.a> detachAllAndUnregisterKey() {
        ArrayList arrayList;
        String str = this.dedupeKey;
        if (str == null) {
            e6.a aVar = this.flowCallback;
            if (aVar != null) {
                return b1.P(aVar);
            }
            kotlin.jvm.internal.g.l("flowCallback");
            throw null;
        }
        inFlight.remove(str, this);
        synchronized (this.dedupeLock) {
            try {
                ArrayList<Follower> arrayList2 = this.followers;
                arrayList = new ArrayList(mb.m.Z(arrayList2, 10));
                int size = arrayList2.size();
                int i10 = 0;
                while (i10 < size) {
                    Follower follower = arrayList2.get(i10);
                    i10++;
                    arrayList.add(follower.getFlowCallback());
                }
                this.followers.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public static final boolean detachCallback(String str, e6.a aVar) {
        return Companion.detachCallback(str, aVar);
    }

    private final boolean ensureResumable(IOtaDeepBinderService iOtaDeepBinderService) {
        Object objA;
        Object objA2;
        try {
            objA = this.mode == Mode.DOWNLOAD ? iOtaDeepBinderService.queryDownloadMeta(this.algorithmId) : iOtaDeepBinderService.queryUpdateMeta(this.algorithmId);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Bundle bundle = (Bundle) objA;
        if (bundle == null || !bundle.getBoolean(ModelFlowMeta.KEY_ACTIVE)) {
            try {
                objA2 = Integer.valueOf(iOtaDeepBinderService.getDownloadStatus(this.algorithmId));
            } catch (Throwable th2) {
                objA2 = kotlin.c.a(th2);
            }
            Integer num = (Integer) (objA2 instanceof Result.Failure ? null : objA2);
            if ((num == null || num.intValue() != 4) && (num == null || num.intValue() != 3)) {
                if (this.isRetry) {
                    Log.i(TAG, "[DIAG] resume → retry without first confirm " + this.algorithmId + " status=" + num);
                    return true;
                }
                if (this.mode == Mode.DOWNLOAD && bundle != null && bundle.getBoolean(ModelFlowMeta.KEY_INSTALLED)) {
                    Log.i(TAG, "[DIAG] resume → already installed, report ready " + this.algorithmId);
                    ready(bundle.getBoolean(ModelFlowMeta.KEY_CAN_UPDATE));
                    return false;
                }
                Log.i(TAG, "[DIAG] resume rejected " + this.algorithmId + ": no resumable task status=" + num);
                StringBuilder sb2 = new StringBuilder("no resumable task (status=");
                sb2.append(num);
                sb2.append(")");
                fail(5004, sb2.toString());
                return false;
            }
        } else if (!this.isResume) {
            a0.a.y("[DIAG] resume → attach active task ", this.algorithmId, TAG);
            registerInternalCallback();
            postDownloadingOnce();
            return false;
        }
        return true;
    }

    private final void executeDownload(IOtaDeepBinderService iOtaDeepBinderService, boolean z, boolean z3) {
        Object objA;
        Object objA2;
        zb.a<lb.n> aVar = this.attachOnConfirm;
        if (aVar == null) {
            try {
                if (!this.isResume || z) {
                    iOtaDeepBinderService.executeDownload(this.algorithmId, z, z3);
                } else {
                    iOtaDeepBinderService.resumeDownload(this.algorithmId);
                }
                objA = lb.n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                String message = thB.getMessage();
                if (message == null) {
                    message = "executeDownload failed";
                }
                fail(5101, message);
                return;
            }
            return;
        }
        Log.i(TAG, "[DIAG] confirmed active silent task " + this.algorithmId + " → attach as user task, no re-enqueue");
        try {
            aVar.invoke();
            objA2 = lb.n.f10413a;
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        Throwable thB2 = Result.b(objA2);
        if (thB2 != null) {
            Log.w(TAG, "attachOnConfirm failed for " + this.algorithmId, thB2);
        }
        ready(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fail(final int i10, final String str) {
        if (this.terminated.compareAndSet(false, true)) {
            Log.i(TAG, "[DIAG] terminal " + this.algorithmId + " mode=" + this.mode + " result=FAIL code=" + i10);
            cleanup();
            final List<e6.a> listDetachAllAndUnregisterKey = detachAllAndUnregisterKey();
            this.main.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.f
                @Override // java.lang.Runnable
                public final void run() {
                    ModelConfirmFlow.fail$lambda$90(listDetachAllAndUnregisterKey, this, i10, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fail$lambda$90(List list, ModelConfirmFlow modelConfirmFlow, int i10, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((e6.a) it.next()).onFailed(i10, str);
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
        modelConfirmFlow.releaseBusinessCallbacks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forEachProgress(zb.l<? super IDownloadCallback, lb.n> lVar) {
        ArrayList arrayList;
        int i10;
        synchronized (this.dedupeLock) {
            ArrayList<Follower> arrayList2 = this.followers;
            arrayList = new ArrayList();
            int size = arrayList2.size();
            i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Follower follower = arrayList2.get(i11);
                i11++;
                IDownloadCallback progressCallback = follower.getProgressCallback();
                if (progressCallback != null) {
                    arrayList.add(progressCallback);
                }
            }
        }
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            try {
                lVar.invoke((IDownloadCallback) obj);
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
    }

    private final int gateBlockedCode(int i10) {
        return i10 != 5021 ? i10 != 5022 ? ModelFlowMeta.GATE_ERROR_LOW_BATTERY : ModelFlowMeta.GATE_ERROR_SERVICE_DISABLED : ModelFlowMeta.GATE_ERROR_INSUFFICIENT_SPACE;
    }

    private final int gateFlowCode(int i10, ConfirmDecisionBus.Decision decision) {
        return i10 == 5022 ? decision == ConfirmDecisionBus.Decision.OPEN_SERVICE_SETTINGS ? 6003 : 4007 : gateBlockedCode(i10);
    }

    private final void gateThenDownload(IOtaDeepBinderService iOtaDeepBinderService, boolean z, boolean z3) {
        ModelConfirmFlow modelConfirmFlow;
        Job jobLaunch$default;
        long j10 = this.pendingSizeBytes;
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            modelConfirmFlow = this;
            jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new ModelConfirmFlow$gateThenDownload$job$1(modelConfirmFlow, j10, iOtaDeepBinderService, z, z3, null), 2, null);
        } else {
            modelConfirmFlow = this;
            jobLaunch$default = null;
        }
        if (jobLaunch$default == null) {
            modelConfirmFlow.fail(5901, "resource gate scope missing");
        }
    }

    private final boolean isStale() {
        return SystemClock.elapsedRealtime() - this.startedAtMs > 300000;
    }

    public static final void markDetachedFromExternalControl(String str) {
        Companion.markDetachedFromExternalControl(str);
    }

    private final void onDecision(ConfirmDecisionBus.Decision decision) {
        IOtaDeepBinderService iOtaDeepBinderService = this.svc;
        if (iOtaDeepBinderService == null) {
            fail(5901, "OTA service unavailable");
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[decision.ordinal()]) {
            case 1:
                try {
                    iOtaDeepBinderService.recordNoNetworkDownloadDecision(this.algorithmId, true);
                    lb.n nVar = lb.n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
                try {
                    iOtaDeepBinderService.endInteractiveSession(this.algorithmId);
                    lb.n nVar2 = lb.n.f10413a;
                } catch (Throwable th2) {
                    kotlin.c.a(th2);
                }
                fail(6001, "scheduled wifi auto-download");
                return;
            case 2:
                gateThenDownload(iOtaDeepBinderService, false, false);
                return;
            case 3:
                gateThenDownload(iOtaDeepBinderService, true, false);
                return;
            case 4:
                gateThenDownload(iOtaDeepBinderService, false, true);
                return;
            case 5:
                try {
                    iOtaDeepBinderService.setWlanAutoUpgrade(true);
                    lb.n nVar3 = lb.n.f10413a;
                } catch (Throwable th3) {
                    kotlin.c.a(th3);
                }
                try {
                    iOtaDeepBinderService.endInteractiveSession(this.algorithmId);
                    lb.n nVar4 = lb.n.f10413a;
                } catch (Throwable th4) {
                    kotlin.c.a(th4);
                }
                fail(4006, "enable wifi-auto only, not downloading");
                return;
            case 6:
                try {
                    iOtaDeepBinderService.endInteractiveSession(this.algorithmId);
                    lb.n nVar5 = lb.n.f10413a;
                } catch (Throwable th5) {
                    kotlin.c.a(th5);
                }
                fail(canceledCodeForCurrentStep(), "user canceled");
                return;
            case 7:
                try {
                    iOtaDeepBinderService.endInteractiveSession(this.algorithmId);
                    lb.n nVar6 = lb.n.f10413a;
                } catch (Throwable th6) {
                    kotlin.c.a(th6);
                }
                fail(6003, "guided to enhanced service settings");
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void onSubStage(ConfirmDecisionBus.SubStage subStage) {
        this.lastSubStage = subStage;
        int i10 = WhenMappings.$EnumSwitchMapping$1[subStage.ordinal()];
        if (i10 == 1) {
            postStage(this.mode == Mode.DOWNLOAD ? ModelFlowStage.h : ModelFlowStage.f5781k);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            postStage(ModelFlowStage.f5782l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ownerCallbackIs(e6.a aVar) {
        e6.a aVar2 = this.flowCallback;
        if (aVar2 == null) {
            return false;
        }
        if (aVar2 != null) {
            return aVar2 == aVar;
        }
        kotlin.jvm.internal.g.l("flowCallback");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void perf(String str, String str2) {
        if (this.perfTraceId.length() == 0) {
            return;
        }
        Log.i(PERF_TAG, com.stepos.core.ota.d.j(com.stepos.core.ota.d.l("OCPERF tid=", SystemClock.elapsedRealtime() - this.perfT0, this.perfTraceId, " +"), "ms stage=", str, " ", str2));
    }

    public static /* synthetic */ void perf$default(ModelConfirmFlow modelConfirmFlow, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        modelConfirmFlow.perf(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postDownloadingOnce() {
        this.phase = Phase.RUNNING;
        if (this.downloadingPosted.compareAndSet(false, true)) {
            postStage(ModelFlowStage.f5777c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postStage(ModelFlowStage modelFlowStage) {
        Collection collectionP;
        if (this.terminated.get()) {
            return;
        }
        this.lastStage = modelFlowStage;
        synchronized (this.dedupeLock) {
            try {
                ArrayList<Follower> arrayList = this.followers;
                ArrayList arrayList2 = new ArrayList(mb.m.Z(arrayList, 10));
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Follower follower = arrayList.get(i10);
                    i10++;
                    arrayList2.add(follower.getFlowCallback());
                }
                boolean zIsEmpty = arrayList2.isEmpty();
                collectionP = arrayList2;
                if (zIsEmpty) {
                    e6.a aVar = this.flowCallback;
                    if (aVar == null) {
                        kotlin.jvm.internal.g.l("flowCallback");
                        throw null;
                    }
                    collectionP = b1.P(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.main.post(new com.stepos.core.model.manager.i(this, collectionP, modelFlowStage, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postStage$lambda$84(ModelConfirmFlow modelConfirmFlow, List list, ModelFlowStage modelFlowStage) {
        if (modelConfirmFlow.terminated.get()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((e6.a) it.next()).onStateChanged(modelFlowStage);
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
    }

    private final void proceedDownload(IOtaDeepBinderService iOtaDeepBinderService, boolean z, boolean z3) {
        registerInternalCallback();
        postDownloadingOnce();
        executeDownload(iOtaDeepBinderService, z, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void proceedWithNetworkCheck(IOtaDeepBinderService iOtaDeepBinderService, boolean z, boolean z3) {
        Object objA;
        try {
            objA = iOtaDeepBinderService.queryPrecheckEnv();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Bundle bundle = (Bundle) objA;
        if (bundle == null) {
            ai.onnxruntime.a.x("[DIAG] proceedNetwork ", this.algorithmId, " precheckEnv unavailable (fail-closed, block)", TAG);
            fail(5901, "precheck env unavailable");
            return;
        }
        boolean z10 = bundle.getBoolean(ModelFlowMeta.KEY_HAS_NETWORK, false);
        boolean z11 = bundle.getBoolean(ModelFlowMeta.KEY_IS_WIFI, false);
        StringBuilder sbM = com.stepos.core.ota.d.m("[DIAG] proceedNetwork ", this.algorithmId, " hasNet=", " wifi=", z10);
        sbM.append(z11);
        sbM.append(" cellularAllowed=");
        sbM.append(z);
        Log.i(TAG, sbM.toString());
        if (!z10) {
            fail(ModelFlowMeta.ENV_ERROR_NO_NETWORK, "no network at proceed");
            return;
        }
        if (z11 && this.resumeConfirm) {
            showResumeConfirmThenProceed(iOtaDeepBinderService, z3);
            return;
        }
        if (z11) {
            proceedDownload(iOtaDeepBinderService, false, z3);
        } else if (z) {
            proceedDownload(iOtaDeepBinderService, true, z3);
        } else {
            showCellularReminderThenProceed(iOtaDeepBinderService, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ready(final boolean z) {
        if (this.terminated.compareAndSet(false, true)) {
            Log.i(TAG, "[DIAG] terminal " + this.algorithmId + " mode=" + this.mode + " result=READY canUpdate=" + z);
            cleanup();
            final List<e6.a> listDetachAllAndUnregisterKey = detachAllAndUnregisterKey();
            this.main.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.k
                @Override // java.lang.Runnable
                public final void run() {
                    ModelConfirmFlow.ready$lambda$87(listDetachAllAndUnregisterKey, this, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ready$lambda$87(List list, ModelConfirmFlow modelConfirmFlow, boolean z) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((e6.a) it.next()).onReady(z);
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
        modelConfirmFlow.releaseBusinessCallbacks();
    }

    private final void registerInternalCallback() {
        try {
            IOtaDeepBinderService iOtaDeepBinderService = this.svc;
            if (iOtaDeepBinderService != null) {
                iOtaDeepBinderService.registerDownloadCallback(this.algorithmId, this.internalCb);
                lb.n nVar = lb.n.f10413a;
            }
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseBusinessCallbacks() {
        synchronized (this.dedupeLock) {
            try {
                if (this.flowCallback != null) {
                    this.flowCallback = NO_OP_CALLBACK;
                }
                this.progressCallback = null;
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void requestCtaThenContinue(final IOtaDeepBinderService iOtaDeepBinderService) {
        Object objA;
        postStage(ModelFlowStage.f5776b);
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        perf("CTA_REQUEST_START", ai.onnxruntime.a.k("modelId=", this.algorithmId));
        ICtaResultCallback iCtaResultCallback = new ICtaResultCallback() { // from class: com.stepos.core.ota.confirmui.ModelConfirmFlow$requestCtaThenContinue$cb$1
            @Override // com.stepos.core.deepbinder.ICtaResultCallback
            public void onRecycle() {
                ICtaResultCallback.DefaultImpls.onRecycle(this);
            }

            @Override // com.stepos.core.deepbinder.ICtaResultCallback
            public void onResult(boolean z) {
                ModelConfirmFlow modelConfirmFlow = this.this$0;
                StringBuilder sbL = com.stepos.core.ota.d.l("modelId=", SystemClock.elapsedRealtime() - jElapsedRealtime, modelConfirmFlow.algorithmId, " dur=");
                sbL.append("ms granted=");
                sbL.append(z);
                modelConfirmFlow.perf("CTA_RESULT", sbL.toString());
                Log.i("ModelConfirmFlow", "[DIAG] requestCta result " + this.this$0.algorithmId + " granted=" + z);
                CoroutineScope coroutineScope = this.this$0.scope;
                if (coroutineScope != null) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new ModelConfirmFlow$requestCtaThenContinue$cb$1$onResult$1(z, this.this$0, iOtaDeepBinderService, null), 2, null);
                }
            }
        };
        this.ctaCallback = iCtaResultCallback;
        try {
            iOtaDeepBinderService.requestCta(this.algorithmId, iCtaResultCallback);
            objA = lb.n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            String message = thB.getMessage();
            if (message == null) {
                message = "requestCta failed";
            }
            fail(5901, message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resumeAfterCta(com.stepos.core.deepbinder.IOtaDeepBinderService r5, boolean r6) {
        /*
            r4 = this;
            com.stepos.core.ota.confirmui.ModelConfirmFlow$Mode r0 = r4.mode     // Catch: java.lang.Throwable -> Ld
            com.stepos.core.ota.confirmui.ModelConfirmFlow$Mode r1 = com.stepos.core.ota.confirmui.ModelConfirmFlow.Mode.DOWNLOAD     // Catch: java.lang.Throwable -> Ld
            if (r0 != r1) goto Lf
            java.lang.String r0 = r4.algorithmId     // Catch: java.lang.Throwable -> Ld
            android.os.Bundle r0 = r5.queryDownloadMeta(r0)     // Catch: java.lang.Throwable -> Ld
            goto L1a
        Ld:
            r0 = move-exception
            goto L16
        Lf:
            java.lang.String r0 = r4.algorithmId     // Catch: java.lang.Throwable -> Ld
            android.os.Bundle r0 = r5.queryUpdateMeta(r0)     // Catch: java.lang.Throwable -> Ld
            goto L1a
        L16:
            kotlin.Result$Failure r0 = kotlin.c.a(r0)
        L1a:
            boolean r1 = r0 instanceof kotlin.Result.Failure
            if (r1 == 0) goto L1f
            r0 = 0
        L1f:
            android.os.Bundle r0 = (android.os.Bundle) r0
            if (r0 == 0) goto L2a
            java.lang.String r1 = "sizeBytes"
            long r1 = r0.getLong(r1)
            goto L2c
        L2a:
            r1 = 0
        L2c:
            r4.pendingSizeBytes = r1
            java.lang.String r1 = r4.displayLabel
            boolean r2 = gc.q.t0(r1)
            if (r2 == 0) goto L42
            if (r0 == 0) goto L40
            java.lang.String r1 = "modelLabel"
            java.lang.String r1 = r0.getString(r1)
            if (r1 != 0) goto L42
        L40:
            java.lang.String r1 = r4.algorithmId
        L42:
            r4.pendingLabel = r1
            if (r0 == 0) goto L4e
            java.lang.String r1 = "updateInfo"
            java.lang.String r1 = r0.getString(r1)
            if (r1 != 0) goto L50
        L4e:
            java.lang.String r1 = ""
        L50:
            r4.pendingUpdateInfo = r1
            boolean r1 = r4.resumeConfirm
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L66
            if (r0 == 0) goto L61
            java.lang.String r1 = "cellularAllowed"
            boolean r0 = r0.getBoolean(r1, r3)
            goto L62
        L61:
            r0 = r3
        L62:
            if (r0 == 0) goto L66
            r0 = r2
            goto L67
        L66:
            r0 = r3
        L67:
            if (r6 != 0) goto L6d
            if (r0 == 0) goto L6c
            goto L6d
        L6c:
            r2 = r3
        L6d:
            r4.gateThenDownload(r5, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.confirmui.ModelConfirmFlow.resumeAfterCta(com.stepos.core.deepbinder.IOtaDeepBinderService, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runFlow(IOtaDeepBinderService iOtaDeepBinderService) {
        Object objA;
        Object objA2;
        perf("RUNFLOW_ENTER", "modelId=" + this.algorithmId + " mode=" + this.mode);
        Log.i(TAG, "[DIAG] runFlow " + this.algorithmId + " mode=" + this.mode);
        if (iOtaDeepBinderService == null) {
            fail(5901, "OTA service unavailable");
            return;
        }
        this.svc = iOtaDeepBinderService;
        postStage(ModelFlowStage.f5775a);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            objA = this.mode == Mode.DOWNLOAD ? iOtaDeepBinderService.queryDownloadMeta(this.algorithmId) : iOtaDeepBinderService.queryUpdateMeta(this.algorithmId);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            String message = thB.getMessage();
            if (message == null) {
                message = "queryMeta failed";
            }
            fail(5901, message);
            return;
        }
        Bundle bundle = (Bundle) objA;
        StringBuilder sbL = com.stepos.core.ota.d.l("modelId=", SystemClock.elapsedRealtime() - jElapsedRealtime, this.algorithmId, " dur=");
        sbL.append("ms");
        perf("RUNFLOW_QUERYMETA_DONE", sbL.toString());
        if (bundle.getBoolean(ModelFlowMeta.KEY_ACTIVE) && this.attachOnConfirm == null) {
            registerInternalCallback();
            postDownloadingOnce();
            return;
        }
        boolean z = bundle.getBoolean(ModelFlowMeta.KEY_INSTALLED);
        if (this.mode == Mode.DOWNLOAD) {
            if (z) {
                ready(bundle.getBoolean(ModelFlowMeta.KEY_CAN_UPDATE));
                return;
            }
        } else if (!z) {
            fail(5004, "model not installed");
            return;
        }
        try {
            objA2 = Integer.valueOf(iOtaDeepBinderService.getDownloadStatus(this.algorithmId));
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        if (objA2 instanceof Result.Failure) {
            objA2 = null;
        }
        Integer num = (Integer) objA2;
        if (this.mode != Mode.DOWNLOAD || num == null || num.intValue() != 4) {
            requestCtaThenContinue(iOtaDeepBinderService);
            return;
        }
        a0.a.y("[DIAG] runFlow → paused task, switch to resume flow ", this.algorithmId, TAG);
        this.isResume = true;
        this.resumeConfirm = true;
        runResumeGate(iOtaDeepBinderService, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runPreflight(final IOtaDeepBinderService iOtaDeepBinderService) {
        Object objA;
        if (iOtaDeepBinderService == null) {
            fail(5901, "OTA service unavailable");
            return;
        }
        this.svc = iOtaDeepBinderService;
        postStage(ModelFlowStage.f5776b);
        ICtaResultCallback iCtaResultCallback = new ICtaResultCallback() { // from class: com.stepos.core.ota.confirmui.ModelConfirmFlow$runPreflight$cb$1
            @Override // com.stepos.core.deepbinder.ICtaResultCallback
            public void onRecycle() {
                ICtaResultCallback.DefaultImpls.onRecycle(this);
            }

            @Override // com.stepos.core.deepbinder.ICtaResultCallback
            public void onResult(boolean z) {
                CoroutineScope coroutineScope = this.this$0.scope;
                if (coroutineScope != null) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new ModelConfirmFlow$runPreflight$cb$1$onResult$1(z, this.this$0, iOtaDeepBinderService, null), 2, null);
                }
            }
        };
        this.ctaCallback = iCtaResultCallback;
        try {
            iOtaDeepBinderService.requestCta(this.algorithmId, iCtaResultCallback);
            objA = lb.n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            String message = thB.getMessage();
            if (message == null) {
                message = "requestCta failed";
            }
            fail(5901, message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runPreflightAfterCta(IOtaDeepBinderService iOtaDeepBinderService) {
        Object objA;
        Object objA2;
        Object objA3;
        try {
            objA = iOtaDeepBinderService.queryPrecheckEnv();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Bundle bundle = (Bundle) objA;
        if (bundle != null && bundle.getInt(ModelFlowMeta.KEY_ENV_ERROR, 0) == 5022) {
            Log.i(TAG, "[DIAG] preflight " + this.algorithmId + " model service disabled → gate dialog");
            showResourceGateBlocked(ModelFlowMeta.GATE_ERROR_SERVICE_DISABLED);
            return;
        }
        if (bundle != null && bundle.getBoolean(ModelFlowMeta.KEY_HAS_NETWORK, false)) {
            Log.i(TAG, "[DIAG] preflight " + this.algorithmId + " → READY(network)");
            ready(false);
            return;
        }
        try {
            objA2 = iOtaDeepBinderService.queryDownloadMeta(this.algorithmId);
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        Bundle bundle2 = (Bundle) (objA2 instanceof Result.Failure ? null : objA2);
        if (bundle2 != null && bundle2.getBoolean(ModelFlowMeta.KEY_INSTALLED)) {
            Log.i(TAG, "[DIAG] preflight " + this.algorithmId + " → READY(local installed)");
            ready(false);
            return;
        }
        try {
            objA3 = Integer.valueOf(iOtaDeepBinderService.queryNoNetworkPromptState(this.algorithmId));
        } catch (Throwable th3) {
            objA3 = kotlin.c.a(th3);
        }
        Throwable thB = Result.b(objA3);
        if (thB != null) {
            Log.w(TAG, "[DIAG] preflight " + this.algorithmId + " queryNoNetworkPromptState FAILED (回退 PROMPT，可能服务端未更新)", thB);
        }
        if (objA3 instanceof Result.Failure) {
            objA3 = 0;
        }
        int iIntValue = ((Number) objA3).intValue();
        Log.i(TAG, "[DIAG] preflight " + this.algorithmId + " offline+missing state=" + iIntValue);
        if (iIntValue == 1) {
            fail(4002, "user declined recently");
            return;
        }
        if (iIntValue == 2) {
            fail(6001, "wifi auto-download pending");
        } else if (iIntValue != 3) {
            showNoNetworkGuide(iOtaDeepBinderService);
        } else {
            fail(6002, "prompt suppressed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runResumeGate(final IOtaDeepBinderService iOtaDeepBinderService, final boolean z) {
        Object objA;
        if (iOtaDeepBinderService == null) {
            fail(5901, "OTA service unavailable");
            return;
        }
        this.svc = iOtaDeepBinderService;
        postStage(ModelFlowStage.f5775a);
        if (ensureResumable(iOtaDeepBinderService)) {
            ICtaResultCallback iCtaResultCallback = new ICtaResultCallback() { // from class: com.stepos.core.ota.confirmui.ModelConfirmFlow$runResumeGate$cb$1
                @Override // com.stepos.core.deepbinder.ICtaResultCallback
                public void onRecycle() {
                    ICtaResultCallback.DefaultImpls.onRecycle(this);
                }

                @Override // com.stepos.core.deepbinder.ICtaResultCallback
                public void onResult(boolean z3) {
                    Log.i("ModelConfirmFlow", "[DIAG] resume requestCta result " + this.this$0.algorithmId + " granted=" + z3);
                    CoroutineScope coroutineScope = this.this$0.scope;
                    if (coroutineScope != null) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new ModelConfirmFlow$runResumeGate$cb$1$onResult$1(z3, this.this$0, iOtaDeepBinderService, z, null), 2, null);
                    }
                }
            };
            this.ctaCallback = iCtaResultCallback;
            try {
                iOtaDeepBinderService.requestCta(this.algorithmId, iCtaResultCallback);
                objA = lb.n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                String message = thB.getMessage();
                if (message == null) {
                    message = "requestCta failed";
                }
                fail(5901, message);
            }
        }
    }

    private final void showCellularReminderThenProceed(IOtaDeepBinderService iOtaDeepBinderService, boolean z) {
        Mode mode = this.mode;
        Mode mode2 = Mode.DOWNLOAD;
        ConfirmDialogParams confirmDialogParamsResumeCellular = mode == mode2 ? this.resumeConfirm ? ConfirmDialogParams.Companion.resumeCellular(this.pendingLabel) : ConfirmDialogParams.Companion.cellularReminderDownload(this.pendingLabel, this.pendingSizeBytes) : ConfirmDialogParams.Companion.cellularReminderUpdate(this.pendingLabel, this.pendingSizeBytes, this.pendingUpdateInfo);
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new d(this, iOtaDeepBinderService, z, 0), new com.stepos.core.ota.d(1));
        this.reqId = strRegister;
        this.lastSubStage = ConfirmDecisionBus.SubStage.CELLULAR_REMINDER;
        postStage(this.mode == mode2 ? ModelFlowStage.h : ModelFlowStage.f5781k);
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost != null) {
            confirmUiHost.show(new ConfirmUiRequest(strRegister, confirmDialogParamsResumeCellular, this.perfTraceId, this.perfT0, new e(this, 0)));
        } else {
            kotlin.jvm.internal.g.l("uiHost");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCellularReminderThenProceed$lambda$67(ModelConfirmFlow modelConfirmFlow, IOtaDeepBinderService iOtaDeepBinderService, boolean z, ConfirmDecisionBus.Decision d8) {
        kotlin.jvm.internal.g.f(d8, "d");
        if (d8 == ConfirmDecisionBus.Decision.CONFIRM_CELLULAR) {
            modelConfirmFlow.proceedDownload(iOtaDeepBinderService, true, z);
            return;
        }
        try {
            iOtaDeepBinderService.endInteractiveSession(modelConfirmFlow.algorithmId);
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        modelConfirmFlow.fail(4003, "user declined cellular");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showCellularReminderThenProceed$lambda$69(ModelConfirmFlow modelConfirmFlow) {
        modelConfirmFlow.fail(5902, "cannot show cellular reminder");
        return lb.n.f10413a;
    }

    private final void showConfirm(IOtaDeepBinderService iOtaDeepBinderService, String str, long j10, String str2, String str3) {
        Object objA;
        String str4 = this.algorithmId;
        Mode mode = this.mode;
        StringBuilder sb2 = new StringBuilder("[DIAG] showConfirm ");
        sb2.append(str4);
        sb2.append(" mode=");
        sb2.append(mode);
        sb2.append(" plan=");
        ai.onnxruntime.a.y(sb2, str, TAG);
        this.pendingSizeBytes = j10;
        this.pendingLabel = str2;
        this.pendingUpdateInfo = str3;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            iOtaDeepBinderService.beginInteractiveSession(this.algorithmId);
            objA = lb.n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            this.sessionBegun.set(true);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            String message = thB.getMessage();
            if (message == null) {
                message = "beginInteractiveSession failed";
            }
            fail(5901, message);
            return;
        }
        StringBuilder sbL = com.stepos.core.ota.d.l("modelId=", SystemClock.elapsedRealtime() - jElapsedRealtime, this.algorithmId, " dur=");
        sbL.append("ms");
        perf("BEGIN_SESSION_DONE", sbL.toString());
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new bd.j(this), new g(this));
        this.reqId = strRegister;
        postStage(topStageFor(str));
        String str5 = this.algorithmId;
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost == null) {
            kotlin.jvm.internal.g.l("uiHost");
            throw null;
        }
        perf("UIHOST_DISPATCH", ai.onnxruntime.a.l("modelId=", str5, " host=", confirmUiHost.getPerfLabel()));
        ConfirmUiHost confirmUiHost2 = this.uiHost;
        if (confirmUiHost2 == null) {
            kotlin.jvm.internal.g.l("uiHost");
            throw null;
        }
        boolean z = true;
        if (this.mode != Mode.DOWNLOAD) {
            z = false;
        }
        confirmUiHost2.show(new ConfirmUiRequest(strRegister, new ConfirmDialogParams(str, j10, str2, str3, z, this.updateConfirmFirst), this.perfTraceId, this.perfT0, new e(this, 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirm$lambda$33(ModelConfirmFlow modelConfirmFlow, ConfirmDecisionBus.Decision d8) {
        kotlin.jvm.internal.g.f(d8, "d");
        modelConfirmFlow.onDecision(d8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirm$lambda$34(ModelConfirmFlow modelConfirmFlow, ConfirmDecisionBus.SubStage s8) {
        kotlin.jvm.internal.g.f(s8, "s");
        modelConfirmFlow.onSubStage(s8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showConfirm$lambda$35(ModelConfirmFlow modelConfirmFlow) {
        modelConfirmFlow.fail(5902, "cannot show confirm dialog");
        return lb.n.f10413a;
    }

    private final void showNoNetworkGuide(IOtaDeepBinderService iOtaDeepBinderService) {
        String str = this.displayLabel;
        if (gc.q.t0(str)) {
            str = this.pendingLabel;
            if (gc.q.t0(str)) {
                str = this.algorithmId;
            }
        }
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new i(0, this, iOtaDeepBinderService), new com.stepos.core.ota.d(3));
        this.reqId = strRegister;
        postStage(ModelFlowStage.f5779e);
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost != null) {
            confirmUiHost.show(new ConfirmUiRequest(strRegister, ConfirmDialogParams.Companion.noNetworkGuide(str), this.perfTraceId, this.perfT0, new e(this, 3)));
        } else {
            kotlin.jvm.internal.g.l("uiHost");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNoNetworkGuide$lambda$51(ModelConfirmFlow modelConfirmFlow, IOtaDeepBinderService iOtaDeepBinderService, ConfirmDecisionBus.Decision d8) {
        Object objA;
        Object objA2;
        kotlin.jvm.internal.g.f(d8, "d");
        if (WhenMappings.$EnumSwitchMapping$0[d8.ordinal()] == 1) {
            try {
                iOtaDeepBinderService.recordNoNetworkDownloadDecision(modelConfirmFlow.algorithmId, true);
                objA2 = lb.n.f10413a;
            } catch (Throwable th) {
                objA2 = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA2);
            if (thB != null) {
                Log.w(TAG, "[DIAG] recordNoNetworkDownloadDecision(true) FAILED " + modelConfirmFlow.algorithmId + "（服务端可能未更新）", thB);
            }
            modelConfirmFlow.fail(6001, "scheduled wifi auto-download");
            return;
        }
        try {
            iOtaDeepBinderService.recordNoNetworkDownloadDecision(modelConfirmFlow.algorithmId, false);
            objA = lb.n.f10413a;
        } catch (Throwable th2) {
            objA = kotlin.c.a(th2);
        }
        Throwable thB2 = Result.b(objA);
        if (thB2 != null) {
            Log.w(TAG, "[DIAG] recordNoNetworkDownloadDecision(false) FAILED " + modelConfirmFlow.algorithmId + "（服务端可能未更新）", thB2);
        }
        modelConfirmFlow.fail(4002, "user declined offline download");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showNoNetworkGuide$lambda$53(ModelConfirmFlow modelConfirmFlow) {
        modelConfirmFlow.fail(6002, "cannot show no-network guide");
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showResourceGateBlocked(int i10) {
        ConfirmDialogParams confirmDialogParamsLowBattery;
        switch (i10) {
            case ModelFlowMeta.GATE_ERROR_LOW_BATTERY /* 5020 */:
                confirmDialogParamsLowBattery = ConfirmDialogParams.Companion.lowBattery();
                break;
            case ModelFlowMeta.GATE_ERROR_INSUFFICIENT_SPACE /* 5021 */:
                confirmDialogParamsLowBattery = ConfirmDialogParams.Companion.insufficientSpace();
                break;
            case ModelFlowMeta.GATE_ERROR_SERVICE_DISABLED /* 5022 */:
                confirmDialogParamsLowBattery = ConfirmDialogParams.Companion.serviceDisabled();
                break;
            default:
                a0.a.u("[DIAG] showResourceGateBlocked unknown code=", i10, " → fail without dialog ", this.algorithmId, TAG);
                if (i10 == 0) {
                    i10 = 5901;
                }
                fail(i10, "resource gate blocked");
                return;
        }
        ConfirmDialogParams confirmDialogParams = confirmDialogParamsLowBattery;
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new com.google.android.material.sidesheet.f(this, i10), new ai.onnxruntime.a(23));
        this.reqId = strRegister;
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost == null) {
            kotlin.jvm.internal.g.l("uiHost");
            throw null;
        }
        ai.onnxruntime.a.y(h0.e.e("[DIAG] showResourceGateBlocked code=", i10, " → uiHost.show host=", confirmUiHost.getPerfLabel(), " reqId="), strRegister, TAG);
        ConfirmUiHost confirmUiHost2 = this.uiHost;
        if (confirmUiHost2 != null) {
            confirmUiHost2.show(new ConfirmUiRequest(strRegister, confirmDialogParams, this.perfTraceId, this.perfT0, new cb.c(i10, 2, this)));
        } else {
            kotlin.jvm.internal.g.l("uiHost");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showResourceGateBlocked$lambda$70(ModelConfirmFlow modelConfirmFlow, int i10, ConfirmDecisionBus.Decision d8) {
        kotlin.jvm.internal.g.f(d8, "d");
        modelConfirmFlow.fail(modelConfirmFlow.gateFlowCode(i10, d8), "resource gate blocked code=" + i10 + " decision=" + d8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showResourceGateBlocked$lambda$72(ModelConfirmFlow modelConfirmFlow, int i10) {
        modelConfirmFlow.fail(modelConfirmFlow.gateBlockedCode(i10), "cannot show resource gate dialog");
        return lb.n.f10413a;
    }

    private final void showResumeConfirmThenProceed(IOtaDeepBinderService iOtaDeepBinderService, boolean z) {
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new d(this, iOtaDeepBinderService, z, 1), new com.stepos.core.ota.d(4));
        this.reqId = strRegister;
        postStage(ModelFlowStage.f5779e);
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost != null) {
            confirmUiHost.show(new ConfirmUiRequest(strRegister, ConfirmDialogParams.Companion.resumeConfirm(this.pendingLabel), this.perfTraceId, this.perfT0, new e(this, 4)));
        } else {
            kotlin.jvm.internal.g.l("uiHost");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showResumeConfirmThenProceed$lambda$63(ModelConfirmFlow modelConfirmFlow, IOtaDeepBinderService iOtaDeepBinderService, boolean z, ConfirmDecisionBus.Decision d8) {
        kotlin.jvm.internal.g.f(d8, "d");
        if (d8 == ConfirmDecisionBus.Decision.CONFIRM) {
            modelConfirmFlow.proceedDownload(iOtaDeepBinderService, false, z);
            return;
        }
        try {
            iOtaDeepBinderService.endInteractiveSession(modelConfirmFlow.algorithmId);
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        modelConfirmFlow.fail(modelConfirmFlow.userCanceledCode(), "user declined resume");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showResumeConfirmThenProceed$lambda$65(ModelConfirmFlow modelConfirmFlow) {
        modelConfirmFlow.fail(5902, "cannot show resume confirm");
        return lb.n.f10413a;
    }

    private final void showUnavailable(String str) {
        Log.i(TAG, "[DIAG] showUnavailable " + this.algorithmId + " mode=" + this.mode);
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new g(this), new com.stepos.core.ota.d(2));
        this.reqId = strRegister;
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost != null) {
            confirmUiHost.show(new ConfirmUiRequest(strRegister, ConfirmDialogParams.Companion.unavailable(str), this.perfTraceId, this.perfT0, new e(this, 2)));
        } else {
            kotlin.jvm.internal.g.l("uiHost");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUnavailable$lambda$36(ModelConfirmFlow modelConfirmFlow, ConfirmDecisionBus.Decision it) {
        kotlin.jvm.internal.g.f(it, "it");
        modelConfirmFlow.fail(5006, "model not available");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showUnavailable$lambda$38(ModelConfirmFlow modelConfirmFlow) {
        modelConfirmFlow.fail(5006, "model not available");
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelConfirmFlow start$lambda$3(e6.a aVar, IDownloadCallback iDownloadCallback, ModelConfirmFlow modelConfirmFlow, Context context, String str, CoroutineScope coroutineScope, String str2, ModelConfirmFlow modelConfirmFlow2) {
        kotlin.jvm.internal.g.f(str2, "<unused var>");
        if (modelConfirmFlow2 != null && !modelConfirmFlow2.isStale() && modelConfirmFlow2.tryAttach(aVar, iDownloadCallback)) {
            return modelConfirmFlow2;
        }
        modelConfirmFlow.becomeOwner(context, str, aVar, iDownloadCallback, coroutineScope);
        return modelConfirmFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelConfirmFlow start$lambda$4(zb.p pVar, Object obj, Object obj2) {
        return (ModelConfirmFlow) pVar.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n start$lambda$5(ModelConfirmFlow modelConfirmFlow, Throwable th) {
        if (th != null && !modelConfirmFlow.terminated.get()) {
            Log.w(TAG, "[DIAG] runFlow interrupted (" + th + ") before terminal → fail " + modelConfirmFlow.algorithmId);
            StringBuilder sb2 = new StringBuilder("flow interrupted: ");
            sb2.append(th);
            modelConfirmFlow.fail(5901, sb2.toString());
        }
        return lb.n.f10413a;
    }

    public static /* synthetic */ void startResume$default(ModelConfirmFlow modelConfirmFlow, Context context, IOtaDeepBinderService iOtaDeepBinderService, e6.a aVar, IDownloadCallback iDownloadCallback, CoroutineScope coroutineScope, boolean z, boolean z3, boolean z10, int i10, Object obj) {
        if ((i10 & 64) != 0) {
            z3 = false;
        }
        if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
            z10 = false;
        }
        modelConfirmFlow.startResume(context, iOtaDeepBinderService, aVar, iDownloadCallback, coroutineScope, z, z3, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelConfirmFlow startResume$lambda$11(e6.a aVar, IDownloadCallback iDownloadCallback, ModelConfirmFlow modelConfirmFlow, Context context, String str, CoroutineScope coroutineScope, String str2, ModelConfirmFlow modelConfirmFlow2) {
        kotlin.jvm.internal.g.f(str2, "<unused var>");
        if (modelConfirmFlow2 != null && !modelConfirmFlow2.isStale() && modelConfirmFlow2.tryAttach(aVar, iDownloadCallback)) {
            return modelConfirmFlow2;
        }
        modelConfirmFlow.becomeOwner(context, str, aVar, iDownloadCallback, coroutineScope);
        return modelConfirmFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelConfirmFlow startResume$lambda$12(zb.p pVar, Object obj, Object obj2) {
        return (ModelConfirmFlow) pVar.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n startResume$lambda$13(ModelConfirmFlow modelConfirmFlow, Throwable th) {
        if (th != null && !modelConfirmFlow.terminated.get()) {
            Log.w(TAG, "[DIAG] runResumeGate interrupted (" + th + ") before terminal → fail " + modelConfirmFlow.algorithmId);
            StringBuilder sb2 = new StringBuilder("resume flow interrupted: ");
            sb2.append(th);
            modelConfirmFlow.fail(5901, sb2.toString());
        }
        return lb.n.f10413a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r1.equals(com.stepos.core.download.ModelFlowMeta.PLAN_DL_CONFIRM_THEN_CELLULAR) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        return com.stepos.aiengine.flow.ModelFlowStage.f5779e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        if (r1.equals(com.stepos.core.download.ModelFlowMeta.PLAN_UPD_CELLULAR_AUTO_OFF) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004b, code lost:
    
        return com.stepos.aiengine.flow.ModelFlowStage.f5781k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (r1.equals(com.stepos.core.download.ModelFlowMeta.PLAN_DL_CONFIRM_ONLY) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r1.equals(com.stepos.core.download.ModelFlowMeta.PLAN_UPD_CELLULAR_AUTO_ON) == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.aiengine.flow.ModelFlowStage topStageFor(java.lang.String r1) {
        /*
            r0 = this;
            int r0 = r1.hashCode()
            switch(r0) {
                case -633829314: goto L3e;
                case 521900019: goto L32;
                case 660809078: goto L26;
                case 848119483: goto L1a;
                case 1226479888: goto L11;
                case 2007072834: goto L8;
                default: goto L7;
            }
        L7:
            goto L46
        L8:
            java.lang.String r0 = "DL_CONFIRM_ONLY"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2f
            goto L46
        L11:
            java.lang.String r0 = "UPD_CELLULAR_AUTO_ON"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L49
            goto L46
        L1a:
            java.lang.String r0 = "UPD_WIFI_AUTO_ON"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L23
            goto L46
        L23:
            com.stepos.aiengine.flow.ModelFlowStage r0 = com.stepos.aiengine.flow.ModelFlowStage.f5780j
            return r0
        L26:
            java.lang.String r0 = "DL_CONFIRM_THEN_CELLULAR"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2f
            goto L46
        L2f:
            com.stepos.aiengine.flow.ModelFlowStage r0 = com.stepos.aiengine.flow.ModelFlowStage.f5779e
            return r0
        L32:
            java.lang.String r0 = "UPD_WIFI_AUTO_OFF"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L3b
            goto L46
        L3b:
            com.stepos.aiengine.flow.ModelFlowStage r0 = com.stepos.aiengine.flow.ModelFlowStage.f5782l
            return r0
        L3e:
            java.lang.String r0 = "UPD_CELLULAR_AUTO_OFF"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L49
        L46:
            com.stepos.aiengine.flow.ModelFlowStage r0 = com.stepos.aiengine.flow.ModelFlowStage.f5779e
            return r0
        L49:
            com.stepos.aiengine.flow.ModelFlowStage r0 = com.stepos.aiengine.flow.ModelFlowStage.f5781k
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.confirmui.ModelConfirmFlow.topStageFor(java.lang.String):com.stepos.aiengine.flow.ModelFlowStage");
    }

    private final boolean tryAttach(e6.a aVar, IDownloadCallback iDownloadCallback) {
        synchronized (this.dedupeLock) {
            if (!this.terminated.get() && this.phase != Phase.DETACHED) {
                this.followers.add(new Follower(aVar, iDownloadCallback));
                ModelFlowStage modelFlowStage = this.lastStage;
                if (modelFlowStage == null) {
                    return true;
                }
                this.main.post(new com.stepos.core.model.manager.i(this, aVar, modelFlowStage, 1));
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryAttach$lambda$10$lambda$9(ModelConfirmFlow modelConfirmFlow, e6.a aVar, ModelFlowStage modelFlowStage) {
        if (modelConfirmFlow.terminated.get()) {
            return;
        }
        try {
            aVar.onStateChanged(modelFlowStage);
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int userCanceledCode() {
        return this.mode == Mode.DOWNLOAD ? 4002 : 4004;
    }

    public final void start(Context context, IOtaDeepBinderService iOtaDeepBinderService, e6.a callback, IDownloadCallback iDownloadCallback, CoroutineScope scope) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(callback, "callback");
        kotlin.jvm.internal.g.f(scope, "scope");
        this.appContext = context.getApplicationContext();
        String str = this.algorithmId + "#" + this.mode;
        if (inFlight.compute(str, new com.stepos.core.common.log.d(new h(callback, iDownloadCallback, this, context, str, scope, 1), 2)) == this) {
            BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new ModelConfirmFlow$start$job$1(this, iOtaDeepBinderService, null), 2, null).invokeOnCompletion(new l(this, 1));
            return;
        }
        Log.i(TAG, "[DIAG] start " + this.algorithmId + " mode=" + this.mode + " attached to in-flight flow, share result");
    }

    public final void startInferencePreflight(Context context, IOtaDeepBinderService iOtaDeepBinderService, e6.a callback, CoroutineScope scope) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(callback, "callback");
        kotlin.jvm.internal.g.f(scope, "scope");
        this.appContext = context.getApplicationContext();
        this.flowCallback = callback;
        this.scope = scope;
        ConfirmUiHost trampolineConfirmHost = this.confirmHost;
        if (trampolineConfirmHost == null) {
            Context context2 = this.appContext;
            if (context2 == null) {
                kotlin.jvm.internal.g.l("appContext");
                throw null;
            }
            trampolineConfirmHost = new TrampolineConfirmHost(context2);
        }
        this.uiHost = trampolineConfirmHost;
        BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new AnonymousClass1(iOtaDeepBinderService, null), 2, null);
    }

    public final void startResume(Context context, IOtaDeepBinderService iOtaDeepBinderService, e6.a callback, IDownloadCallback iDownloadCallback, CoroutineScope scope, boolean z) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(callback, "callback");
        kotlin.jvm.internal.g.f(scope, "scope");
        startResume$default(this, context, iOtaDeepBinderService, callback, iDownloadCallback, scope, z, false, false, 192, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId) {
        this(algorithmId, mode, perfTraceId, 0L, null, null, null, false, 248, null);
        kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
        kotlin.jvm.internal.g.f(mode, "mode");
        kotlin.jvm.internal.g.f(perfTraceId, "perfTraceId");
    }

    public final void startResume(Context context, IOtaDeepBinderService iOtaDeepBinderService, e6.a callback, IDownloadCallback iDownloadCallback, CoroutineScope scope, boolean z, boolean z3) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(callback, "callback");
        kotlin.jvm.internal.g.f(scope, "scope");
        startResume$default(this, context, iOtaDeepBinderService, callback, iDownloadCallback, scope, z, z3, false, TraceIdKeys.MAX_LENGTH, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId, long j10) {
        this(algorithmId, mode, perfTraceId, j10, null, null, null, false, 240, null);
        kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
        kotlin.jvm.internal.g.f(mode, "mode");
        kotlin.jvm.internal.g.f(perfTraceId, "perfTraceId");
    }

    public final void startResume(Context context, IOtaDeepBinderService iOtaDeepBinderService, e6.a callback, IDownloadCallback iDownloadCallback, CoroutineScope scope, boolean z, boolean z3, boolean z10) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(callback, "callback");
        kotlin.jvm.internal.g.f(scope, "scope");
        this.appContext = context.getApplicationContext();
        this.isResume = !z;
        this.isRetry = z;
        this.resumeConfirm = z10;
        String str = this.algorithmId + "#" + this.mode + "#resume";
        ConcurrentHashMap<String, ModelConfirmFlow> concurrentHashMap = inFlight;
        final h hVar = new h(callback, iDownloadCallback, this, context, str, scope, 0);
        if (concurrentHashMap.compute(str, new BiFunction() { // from class: com.stepos.core.ota.confirmui.j
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ModelConfirmFlow.startResume$lambda$12(hVar, obj, obj2);
            }
        }) == this) {
            BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new ModelConfirmFlow$startResume$job$1(this, iOtaDeepBinderService, z3, null), 2, null).invokeOnCompletion(new androidx.compose.runtime.g(this, 12));
            return;
        }
        Log.i(TAG, "[DIAG] startResume " + this.algorithmId + " mode=" + this.mode + " attached to in-flight resume flow, share result");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId, long j10, String displayLabel) {
        this(algorithmId, mode, perfTraceId, j10, displayLabel, null, null, false, 224, null);
        kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
        kotlin.jvm.internal.g.f(mode, "mode");
        kotlin.jvm.internal.g.f(perfTraceId, "perfTraceId");
        kotlin.jvm.internal.g.f(displayLabel, "displayLabel");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId, long j10, String displayLabel, ConfirmUiHost confirmUiHost) {
        this(algorithmId, mode, perfTraceId, j10, displayLabel, confirmUiHost, null, false, 192, null);
        kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
        kotlin.jvm.internal.g.f(mode, "mode");
        kotlin.jvm.internal.g.f(perfTraceId, "perfTraceId");
        kotlin.jvm.internal.g.f(displayLabel, "displayLabel");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId, long j10, String displayLabel, ConfirmUiHost confirmUiHost, zb.a<lb.n> aVar) {
        this(algorithmId, mode, perfTraceId, j10, displayLabel, confirmUiHost, aVar, false, TraceIdKeys.MAX_LENGTH, null);
        kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
        kotlin.jvm.internal.g.f(mode, "mode");
        kotlin.jvm.internal.g.f(perfTraceId, "perfTraceId");
        kotlin.jvm.internal.g.f(displayLabel, "displayLabel");
    }

    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId, long j10, String displayLabel, ConfirmUiHost confirmUiHost, zb.a<lb.n> aVar, boolean z) {
        kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
        kotlin.jvm.internal.g.f(mode, "mode");
        kotlin.jvm.internal.g.f(perfTraceId, "perfTraceId");
        kotlin.jvm.internal.g.f(displayLabel, "displayLabel");
        this.algorithmId = algorithmId;
        this.mode = mode;
        this.perfTraceId = perfTraceId;
        this.perfT0 = j10;
        this.displayLabel = displayLabel;
        this.confirmHost = confirmUiHost;
        this.attachOnConfirm = aVar;
        this.updateConfirmFirst = z;
        this.main = new Handler(Looper.getMainLooper());
        this.terminated = new AtomicBoolean(false);
        this.downloadingPosted = new AtomicBoolean(false);
        this.sessionBegun = new AtomicBoolean(false);
        this.followers = new ArrayList<>();
        this.dedupeLock = new Object();
        this.startedAtMs = SystemClock.elapsedRealtime();
        this.pendingLabel = "";
        this.pendingUpdateInfo = "";
        this.phase = Phase.INTERACTIVE;
        this.internalCb = new ModelConfirmFlow$internalCb$1(this);
    }

    public /* synthetic */ ModelConfirmFlow(String str, Mode mode, String str2, long j10, String str3, ConfirmUiHost confirmUiHost, zb.a aVar, boolean z, int i10, kotlin.jvm.internal.e eVar) {
        this(str, mode, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? 0L : j10, (i10 & 16) != 0 ? "" : str3, (i10 & 32) != 0 ? null : confirmUiHost, (i10 & 64) != 0 ? null : aVar, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? false : z);
    }
}
