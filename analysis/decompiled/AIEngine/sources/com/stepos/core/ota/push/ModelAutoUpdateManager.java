package com.stepos.core.ota.push;

import android.content.Context;
import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.OtaDispatcher;
import com.stepos.core.ota.d;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.PauseReason;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.domain.TriggerSourcePolicy;
import com.stepos.core.ota.process.OtaProcess;
import com.stepos.core.ota.process.OtaProcessBootstrap;
import com.stepos.core.ota.process.OtaProcessClient;
import com.stepos.core.ota.process.OtaRuntime;
import com.stepos.core.ota.push.OtaPushEligibility;
import com.stepos.core.ota.push.PendingAutoUpdateStore;
import com.stepos.core.ota.push.PrdAutoUpdateGate;
import com.stepos.core.ota.push.PrdForceUpdateGate;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import com.stepos.core.ota.storage.ModelsVersionStore;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import com.stepos.core.ota.storage.SilentInstallFailureStore;
import gc.o;
import h0.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import lb.n;
import mb.l;
import mb.m;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelAutoUpdateManager implements ModelUpdateConditionListener {
    private static final long DEBOUNCE_MS = 10000;
    private static final String TAG = "ModelAutoUpdateManager";
    private static volatile long lastEvalAtMono;
    private static volatile boolean silentBatchActive;
    private static volatile boolean watching;
    public static final ModelAutoUpdateManager INSTANCE = new ModelAutoUpdateManager();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    private static final Mutex runMutex = MutexKt.Mutex$default(false, 1, null);
    private static final AtomicLong unchargedSessionStartMono = new AtomicLong(0);
    private static final AtomicLong unchargedSessionBytes = new AtomicLong(0);
    private static final ConcurrentHashMap<String, Long> lastSeenBytes = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OtaPushEligibility.Skip.values().length];
            try {
                iArr[OtaPushEligibility.Skip.USER_UNINSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OtaPushEligibility.Skip.NOT_INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OtaPushEligibility.Skip.UP_TO_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OtaPushEligibility.Skip.IN_PROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.push.ModelAutoUpdateManager", f = "ModelAutoUpdateManager.kt", l = {220, 221}, m = "execute")
    /* renamed from: com.stepos.core.ota.push.ModelAutoUpdateManager$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ModelAutoUpdateManager.this.execute(null, false, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.push.ModelAutoUpdateManager$pauseIfViolated$1", f = "ModelAutoUpdateManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.push.ModelAutoUpdateManager$pauseIfViolated$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04041 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ String $reason;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04041(String str, b<? super C04041> bVar) {
            super(2, bVar);
            this.$reason = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            C04041 c04041 = new C04041(this.$reason, bVar);
            c04041.L$0 = obj;
            return c04041;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Context contextRequireAppContext;
            String logString;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            String str = this.$reason;
            try {
                contextRequireAppContext = OtaRuntime.INSTANCE.requireAppContext();
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            if (OtaProcess.INSTANCE.isOtaProcess(contextRequireAppContext)) {
                return n.f10413a;
            }
            ModelAutoUpdateManager modelAutoUpdateManager = ModelAutoUpdateManager.INSTANCE;
            PrdAutoUpdateGate.SessionState sessionStateCurrentSilentSession = modelAutoUpdateManager.currentSilentSession();
            PrdAutoUpdateGate prdAutoUpdateGate = PrdAutoUpdateGate.INSTANCE;
            PrdAutoUpdateGate.Result resultEvaluate = prdAutoUpdateGate.evaluate(contextRequireAppContext, sessionStateCurrentSilentSession, false);
            PrdAutoUpdateGate.Result resultEvaluate2 = PendingAutoUpdateStore.INSTANCE.hasNewDownloadPending() ? prdAutoUpdateGate.evaluate(contextRequireAppContext, sessionStateCurrentSilentSession, true) : null;
            if (!resultEvaluate.getAllowed() || (resultEvaluate2 != null && !resultEvaluate2.getAllowed())) {
                LogModule logModule = LogModule.OTA;
                String logString2 = resultEvaluate.toLogString();
                if (resultEvaluate2 == null || (logString = resultEvaluate2.toLogString()) == null) {
                    logString = "-";
                }
                AIEngineLogger.i(logModule, ModelAutoUpdateManager.TAG, "condition violated (" + str + ") update=" + logString2 + " new=" + logString + " → pause silent");
                ModelAutoUpdateManager.cancelAllSilent$default(modelAutoUpdateManager, str, null, 2, null);
            }
            objA = n.f10413a;
            String str2 = this.$reason;
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.OTA, ModelAutoUpdateManager.TAG, "pauseIfViolated failed reason=" + str2, thB);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((C04041) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.push.ModelAutoUpdateManager", f = "ModelAutoUpdateManager.kt", l = {294}, m = "processSilent")
    /* renamed from: com.stepos.core.ota.push.ModelAutoUpdateManager$processSilent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C04051(b<? super C04051> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ModelAutoUpdateManager.this.processSilent(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.push.ModelAutoUpdateManager", f = "ModelAutoUpdateManager.kt", l = {261}, m = "processSilentBatch")
    /* renamed from: com.stepos.core.ota.push.ModelAutoUpdateManager$processSilentBatch$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C04061(b<? super C04061> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ModelAutoUpdateManager.this.processSilentBatch(null, null, false, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.push.ModelAutoUpdateManager$startWatching$1", f = "ModelAutoUpdateManager.kt", l = {564}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.push.ModelAutoUpdateManager$startWatching$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04071 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C04071(b<? super C04071> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            C04071 c04071 = new C04071(bVar);
            c04071.L$0 = obj;
            return c04071;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                StateFlow<Map<String, OtaStateSnapshot>> stateFlowTaskStateFlow = OtaRuntime.INSTANCE.taskStateFlow();
                FlowCollector<? super Map<String, OtaStateSnapshot>> flowCollector = new FlowCollector() { // from class: com.stepos.core.ota.push.ModelAutoUpdateManager.startWatching.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, b bVar) {
                        return emit((Map<String, OtaStateSnapshot>) obj2, (b<? super n>) bVar);
                    }

                    public final Object emit(Map<String, OtaStateSnapshot> map, b<? super n> bVar) {
                        Object objA;
                        if (PendingAutoUpdateStore.INSTANCE.isEmpty()) {
                            return n.f10413a;
                        }
                        try {
                            objA = Boolean.valueOf(AutoUpdateEnv.INSTANCE.isCharging(OtaRuntime.INSTANCE.requireAppContext()));
                        } catch (Throwable th) {
                            objA = kotlin.c.a(th);
                        }
                        Object obj2 = Boolean.FALSE;
                        if (objA instanceof Result.Failure) {
                            objA = obj2;
                        }
                        boolean zBooleanValue = ((Boolean) objA).booleanValue();
                        for (Map.Entry<String, OtaStateSnapshot> entry : map.entrySet()) {
                            String key = entry.getKey();
                            OtaStateSnapshot value = entry.getValue();
                            ModelAutoUpdateManager modelAutoUpdateManager = ModelAutoUpdateManager.INSTANCE;
                            modelAutoUpdateManager.accumulateSilentBytes(key, value.getState(), value.getSources(), zBooleanValue);
                            PendingAutoUpdateStore pendingAutoUpdateStore = PendingAutoUpdateStore.INSTANCE;
                            PendingAutoUpdateStore.Record record = pendingAutoUpdateStore.get(key);
                            if (record != null) {
                                OtaState state = value.getState();
                                if (state instanceof OtaState.Installed) {
                                    OtaState.Installed installed = (OtaState.Installed) state;
                                    if (installed.getVersion() >= record.getVersionCode()) {
                                        AIEngineLogger.i(LogModule.OTA, ModelAutoUpdateManager.TAG, d.h("pending done: installed otaId=", installed.getVersion(), key, " v"));
                                        pendingAutoUpdateStore.remove(key);
                                        ModelAutoUpdateManager.lastSeenBytes.remove(key);
                                        ModelAutoUpdateManager.tryRun$default(modelAutoUpdateManager, "after_install:" + key, false, 2, null);
                                    }
                                }
                            }
                        }
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
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((C04071) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.push.ModelAutoUpdateManager$tryRun$1", f = "ModelAutoUpdateManager.kt", l = {622, 166}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.push.ModelAutoUpdateManager$tryRun$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04081 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ boolean $bypassThrottle;
        final /* synthetic */ String $reason;
        private /* synthetic */ Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04081(String str, boolean z, b<? super C04081> bVar) {
            super(2, bVar);
            this.$reason = str;
            this.$bypassThrottle = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            C04081 c04081 = new C04081(this.$reason, this.$bypassThrottle, bVar);
            c04081.L$0 = obj;
            return c04081;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r7.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L30
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
                kotlin.c.b(r8)     // Catch: java.lang.Throwable -> L15
                goto L5e
            L15:
                r8 = move-exception
                goto L6a
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1f:
                boolean r1 = r7.Z$0
                java.lang.Object r3 = r7.L$1
                kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
                java.lang.Object r5 = r7.L$0
                java.lang.String r5 = (java.lang.String) r5
                kotlin.c.b(r8)     // Catch: java.lang.Throwable -> L2e
                r8 = r3
                goto L4e
            L2e:
                r8 = move-exception
                goto L6e
            L30:
                kotlin.c.b(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
                java.lang.String r5 = r7.$reason
                boolean r1 = r7.$bypassThrottle
                kotlinx.coroutines.sync.Mutex r8 = com.stepos.core.ota.push.ModelAutoUpdateManager.access$getRunMutex$p()     // Catch: java.lang.Throwable -> L2e
                r7.L$0 = r5     // Catch: java.lang.Throwable -> L2e
                r7.L$1 = r8     // Catch: java.lang.Throwable -> L2e
                r7.Z$0 = r1     // Catch: java.lang.Throwable -> L2e
                r7.label = r3     // Catch: java.lang.Throwable -> L2e
                java.lang.Object r3 = r8.lock(r4, r7)     // Catch: java.lang.Throwable -> L2e
                if (r3 != r0) goto L4e
                goto L5c
            L4e:
                com.stepos.core.ota.push.ModelAutoUpdateManager r3 = com.stepos.core.ota.push.ModelAutoUpdateManager.INSTANCE     // Catch: java.lang.Throwable -> L66
                r7.L$0 = r8     // Catch: java.lang.Throwable -> L66
                r7.L$1 = r4     // Catch: java.lang.Throwable -> L66
                r7.label = r2     // Catch: java.lang.Throwable -> L66
                java.lang.Object r1 = com.stepos.core.ota.push.ModelAutoUpdateManager.access$execute(r3, r5, r1, r7)     // Catch: java.lang.Throwable -> L66
                if (r1 != r0) goto L5d
            L5c:
                return r0
            L5d:
                r0 = r8
            L5e:
                lb.n r8 = lb.n.f10413a     // Catch: java.lang.Throwable -> L15
                r0.unlock(r4)     // Catch: java.lang.Throwable -> L2e
                lb.n r8 = lb.n.f10413a     // Catch: java.lang.Throwable -> L2e
                goto L72
            L66:
                r0 = move-exception
                r6 = r0
                r0 = r8
                r8 = r6
            L6a:
                r0.unlock(r4)     // Catch: java.lang.Throwable -> L2e
                throw r8     // Catch: java.lang.Throwable -> L2e
            L6e:
                kotlin.Result$Failure r8 = kotlin.c.a(r8)
            L72:
                java.lang.String r7 = r7.$reason
                java.lang.Throwable r8 = kotlin.Result.b(r8)
                if (r8 == 0) goto L8f
                com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.OTA
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "execute failed reason="
                r1.<init>(r2)
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                java.lang.String r1 = "ModelAutoUpdateManager"
                com.stepos.core.common.log.AIEngineLogger.e(r0, r1, r7, r8)
            L8f:
                lb.n r7 = lb.n.f10413a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.push.ModelAutoUpdateManager.C04081.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((C04081) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private ModelAutoUpdateManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void accumulateSilentBytes(String str, OtaState otaState, Set<? extends TriggerSource> set, boolean z) {
        if (!z && (otaState instanceof OtaState.Downloading) && set.contains(TriggerSource.SILENT)) {
            ConcurrentHashMap<String, Long> concurrentHashMap = lastSeenBytes;
            Long l10 = concurrentHashMap.get(str);
            long jLongValue = l10 != null ? l10.longValue() : 0L;
            long downloadedBytes = ((OtaState.Downloading) otaState).getDownloadedBytes();
            long j10 = downloadedBytes - jLongValue;
            if (j10 < 0) {
                j10 = 0;
            }
            if (j10 > 0) {
                unchargedSessionBytes.addAndGet(j10);
            }
            concurrentHashMap.put(str, Long.valueOf(downloadedBytes));
        }
    }

    private final void batchRefresh(Context context, List<PendingAutoUpdateStore.Record> list) {
        Object objA;
        ArrayList arrayList = new ArrayList(m.Z(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PendingAutoUpdateStore.Record) it.next()).getOtaId());
        }
        List listO0 = kotlin.collections.a.o0(arrayList);
        if (listO0.isEmpty()) {
            return;
        }
        try {
            diag("batchRefresh ids=" + listO0 + " ok=" + RemoteModelsRepository.fetch(context, kotlin.collections.a.z0(listO0, "|", null, null, null, 62), true));
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, "batchRefresh fetch failed ids=" + listO0, thB);
        }
    }

    public static /* synthetic */ void cancelAllSilent$default(ModelAutoUpdateManager modelAutoUpdateManager, String str, PauseReason pauseReason, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pauseReason = PauseReason.NETWORK;
        }
        modelAutoUpdateManager.cancelAllSilent(str, pauseReason);
    }

    private final void diag(String str) {
        e.k("[DIAG] ", str, LogModule.OTA, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dispatch(Context context, PendingAutoUpdateStore.Record record, TriggerSource triggerSource, b<? super Boolean> bVar) {
        OtaProcessBootstrap.INSTANCE.ensureRemoteProcess(context);
        boolean zDownload$default = OtaDispatcher.DefaultImpls.download$default(OtaRuntime.INSTANCE.dispatcher(), record.getOtaId(), triggerSource, null, null, false, 28, null);
        LogModule logModule = LogModule.OTA;
        StringBuilder sbF = e.f("dispatch download otaId=", record.getOtaId(), " v", record.getVersionCode(), " source=");
        sbF.append(triggerSource);
        sbF.append(" ok=");
        sbF.append(zDownload$default);
        sbF.append(" (queued if :ota starting)");
        AIEngineLogger.i(logModule, TAG, sbF.toString());
        StringBuilder sbF2 = e.f("dispatch otaId=", record.getOtaId(), " version=", record.getVersionCode(), " source=");
        sbF2.append(triggerSource);
        sbF2.append(" ok=");
        sbF2.append(zDownload$default);
        diag(sbF2.toString());
        return Boolean.valueOf(zDownload$default);
    }

    private final long elapsedUnchargedMs() {
        long j10 = unchargedSessionStartMono.get();
        if (j10 == 0) {
            return 0L;
        }
        return SystemClock.elapsedRealtime() - j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01d5, code lost:
    
        if (r0.processSilentBatch(r3, r6, r2, r4) == r5) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(java.lang.String r17, boolean r18, qb.b<? super lb.n> r19) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.push.ModelAutoUpdateManager.execute(java.lang.String, boolean, qb.b):java.lang.Object");
    }

    public static /* synthetic */ Object execute$default(ModelAutoUpdateManager modelAutoUpdateManager, String str, boolean z, b bVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return modelAutoUpdateManager.execute(str, z, bVar);
    }

    private final long msSinceLastSilentRequest() {
        long jLastSilentRequestWallMs = PendingAutoUpdateStore.INSTANCE.lastSilentRequestWallMs();
        if (jLastSilentRequestWallMs <= 0) {
            return Long.MAX_VALUE;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jLastSilentRequestWallMs;
        if (jCurrentTimeMillis < 0) {
            return 0L;
        }
        return jCurrentTimeMillis;
    }

    private final void onRemoteConnected() {
        AIEngineLogger.i(LogModule.OTA, TAG, "remote connected → discover + re-dispatch silent updates");
        diag("trigger reason=remote_connected bypassThrottle=true");
        tryRun("remote_connected", true);
    }

    private final void pauseIfViolated(String str) {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C04041(str, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processForce(Context context, PendingAutoUpdateStore.Record record, b<? super n> bVar) {
        if (skipByEligibility(record)) {
            return n.f10413a;
        }
        if (resolveCandidateBytes(record) == null) {
            return n.f10413a;
        }
        PrdForceUpdateGate.Result resultEvaluate = PrdForceUpdateGate.INSTANCE.evaluate(context);
        AIEngineLogger.i(LogModule.OTA, TAG, ai.onnxruntime.a.l("force gate otaId=", record.getOtaId(), " ", resultEvaluate.toLogString()));
        String otaId = record.getOtaId();
        boolean allowed = resultEvaluate.getAllowed();
        String logString = resultEvaluate.toLogString();
        StringBuilder sbM = d.m("force gate otaId=", otaId, " allowed=", " ", allowed);
        sbM.append(logString);
        diag(sbM.toString());
        if (!resultEvaluate.getAllowed()) {
            return n.f10413a;
        }
        Object objDispatch = dispatch(context, record, TriggerSource.PUSH_FORCE, bVar);
        return objDispatch == CoroutineSingletons.f10059a ? objDispatch : n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processSilent(android.content.Context r20, com.stepos.core.ota.push.PendingAutoUpdateStore.Record r21, qb.b<? super lb.n> r22) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.push.ModelAutoUpdateManager.processSilent(android.content.Context, com.stepos.core.ota.push.PendingAutoUpdateStore$Record, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processSilentBatch(android.content.Context r14, java.util.List<com.stepos.core.ota.push.PendingAutoUpdateStore.Record> r15, boolean r16, qb.b<? super lb.n> r17) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.push.ModelAutoUpdateManager.processSilentBatch(android.content.Context, java.util.List, boolean, qb.b):java.lang.Object");
    }

    public static /* synthetic */ Object processSilentBatch$default(ModelAutoUpdateManager modelAutoUpdateManager, Context context, List list, boolean z, b bVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = false;
        }
        return modelAutoUpdateManager.processSilentBatch(context, list, z, bVar);
    }

    private final void resetUnchargedSession(String str) {
        AtomicLong atomicLong = unchargedSessionStartMono;
        if (atomicLong.get() != 0 || unchargedSessionBytes.get() != 0) {
            e.k("reset uncharged session: reason=", str, LogModule.OTA, TAG);
        }
        atomicLong.set(0L);
        unchargedSessionBytes.set(0L);
        lastSeenBytes.clear();
    }

    private final Long resolveCandidateBytes(PendingAutoUpdateStore.Record record) {
        OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(record.getOtaId());
        int versionCode = ModelsVersionStore.INSTANCE.getVersionCode(record.getOtaId());
        if (otaRemoteModel == null) {
            AIEngineLogger.i(LogModule.OTA, TAG, d.h("keep pending: no manifest (fetch failed/empty), retry later otaId=", versionCode, record.getOtaId(), " local=v"));
            diag(d.h("candidate missing manifest otaId=", versionCode, record.getOtaId(), " localVer="));
            return null;
        }
        if (otaRemoteModel.getVersion_code() <= versionCode) {
            LogModule logModule = LogModule.OTA;
            StringBuilder sbF = e.f("drop pending: up-to-date otaId=", record.getOtaId(), " remote=v", otaRemoteModel.getVersion_code(), " local=v");
            sbF.append(versionCode);
            AIEngineLogger.i(logModule, TAG, sbF.toString());
            String otaId = record.getOtaId();
            int version_code = otaRemoteModel.getVersion_code();
            StringBuilder sbF2 = e.f("candidate up-to-date otaId=", otaId, " localVer=", versionCode, " remoteVer=");
            sbF2.append(version_code);
            diag(sbF2.toString());
            PendingAutoUpdateStore.INSTANCE.remove(record.getOtaId());
            return null;
        }
        Long lValueOf = Long.valueOf(otaRemoteModel.getFile_size());
        Long l10 = lValueOf.longValue() > 0 ? lValueOf : null;
        long jLongValue = l10 != null ? l10.longValue() : record.getSizeBytes();
        String otaId2 = record.getOtaId();
        int version_code2 = otaRemoteModel.getVersion_code();
        StringBuilder sbF3 = e.f("candidate ready otaId=", otaId2, " localVer=", versionCode, " remoteVer=");
        sbF3.append(version_code2);
        sbF3.append(" bytes=");
        sbF3.append(jLongValue);
        diag(sbF3.toString());
        return Long.valueOf(jLongValue);
    }

    private final boolean shouldForceCatalogRefresh(String str) {
        return g.b(str, "periodic") || g.b(str, "registrar_start") || g.b(str, "cta_regrant_rescan") || g.b(str, "wifi_validated") || g.b(str, "power_connected") || g.b(str, "remote_connected") || o.k0(str, "push_force", false) || o.k0(str, "push_silent", false);
    }

    private final boolean skipByEligibility(PendingAutoUpdateStore.Record record) {
        OtaState state;
        OtaStateSnapshot otaStateSnapshot = OtaRuntime.INSTANCE.snapshot().get(record.getOtaId());
        if ((otaStateSnapshot != null && TriggerSourcePolicy.INSTANCE.isUserHeld(otaStateSnapshot.getSources(), otaStateSnapshot.getState())) || OtaTaskSnapshotStore.INSTANCE.isUserManaged(record.getOtaId())) {
            LogModule logModule = LogModule.OTA;
            String otaId = record.getOtaId();
            String strC = (otaStateSnapshot == null || (state = otaStateSnapshot.getState()) == null) ? null : i.a(state.getClass()).c();
            boolean z = otaStateSnapshot == null;
            StringBuilder sbS = ai.onnxruntime.a.s("keep pending: user-held otaId=", otaId, " live=", strC, " persistUserManaged=");
            sbS.append(z);
            AIEngineLogger.i(logModule, TAG, sbS.toString());
            diag(ai.onnxruntime.a.k("eligibility keep pending user-held otaId=", record.getOtaId()));
            return true;
        }
        if (SilentInstallFailureStore.INSTANCE.isFailedVersion(record.getOtaId(), record.getVersionCode())) {
            AIEngineLogger.w(LogModule.OTA, TAG, d.h("drop pending: silent install-failed version otaId=", record.getVersionCode(), record.getOtaId(), " v"));
            diag(d.h("eligibility drop install-failed otaId=", record.getVersionCode(), record.getOtaId(), " version="));
            return true;
        }
        OtaPushEligibility.Skip skipCheck = OtaPushEligibility.INSTANCE.check(record.getOtaId(), record.getVersionCode(), record.isNewDownload());
        int i10 = skipCheck == null ? -1 : WhenMappings.$EnumSwitchMapping$0[skipCheck.ordinal()];
        if (i10 == -1) {
            diag(ai.onnxruntime.a.k("eligibility pass otaId=", record.getOtaId()));
            return false;
        }
        if (i10 == 1) {
            AIEngineLogger.w(LogModule.OTA, TAG, "drop pending: user uninstalled otaId=" + record.getOtaId());
            diag(ai.onnxruntime.a.k("eligibility drop user-uninstalled otaId=", record.getOtaId()));
            PendingAutoUpdateStore.INSTANCE.remove(record.getOtaId());
            return true;
        }
        if (i10 == 2) {
            AIEngineLogger.w(LogModule.OTA, TAG, "drop pending: not installed otaId=" + record.getOtaId());
            diag(ai.onnxruntime.a.k("eligibility drop not-installed otaId=", record.getOtaId()));
            PendingAutoUpdateStore.INSTANCE.remove(record.getOtaId());
            return true;
        }
        if (i10 == 3) {
            AIEngineLogger.i(LogModule.OTA, TAG, "drop pending: up-to-date otaId=" + record.getOtaId());
            diag(ai.onnxruntime.a.k("eligibility drop up-to-date otaId=", record.getOtaId()));
            PendingAutoUpdateStore.INSTANCE.remove(record.getOtaId());
            return true;
        }
        if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        AIEngineLogger.i(LogModule.OTA, TAG, "keep pending: in-progress otaId=" + record.getOtaId());
        diag(ai.onnxruntime.a.k("eligibility keep in-progress otaId=", record.getOtaId()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n start$lambda$0() {
        INSTANCE.onRemoteConnected();
        return n.f10413a;
    }

    private final void startWatching() {
        if (watching) {
            return;
        }
        watching = true;
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C04071(null), 3, null);
    }

    public static /* synthetic */ void tryRun$default(ModelAutoUpdateManager modelAutoUpdateManager, String str, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        modelAutoUpdateManager.tryRun(str, z);
    }

    public final void cancelAllSilent(String reason, PauseReason pauseReason) {
        Object objA;
        g.f(reason, "reason");
        g.f(pauseReason, "pauseReason");
        try {
            Set setS0 = l.s0(new TriggerSource[]{TriggerSource.SILENT, TriggerSource.PUSH_FORCE});
            for (Map.Entry<String, OtaStateSnapshot> entry : OtaRuntime.INSTANCE.snapshot().entrySet()) {
                String key = entry.getKey();
                OtaStateSnapshot value = entry.getValue();
                if (value.getState().isActive() && !value.getSources().contains(TriggerSource.USER)) {
                    Set<TriggerSource> sources = value.getSources();
                    if (!(sources instanceof Collection) || !sources.isEmpty()) {
                        Iterator<T> it = sources.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (setS0.contains((TriggerSource) it.next())) {
                                AIEngineLogger.i(LogModule.OTA, TAG, "pause silent task otaId=" + key + " reason=" + reason + " pauseReason=" + pauseReason + " sources=" + value.getSources());
                                OtaRuntime.INSTANCE.dispatcher().pause(key, pauseReason);
                                break;
                            }
                        }
                    }
                }
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "cancelAllSilent failed reason=".concat(reason), thB);
        }
    }

    public final PrdAutoUpdateGate.SessionState currentSilentSession() {
        Object objA;
        try {
            objA = Boolean.valueOf(AutoUpdateEnv.INSTANCE.isCharging(OtaRuntime.INSTANCE.requireAppContext()));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        boolean zBooleanValue = ((Boolean) objA).booleanValue();
        return new PrdAutoUpdateGate.SessionState(0L, zBooleanValue ? 0L : unchargedSessionBytes.get(), zBooleanValue ? 0L : elapsedUnchargedMs());
    }

    public final String dumpState() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("silentBatchActive=" + silentBatchActive);
        sb2.append('\n');
        long jMsSinceLastSilentRequest = INSTANCE.msSinceLastSilentRequest();
        if (jMsSinceLastSilentRequest == Long.MAX_VALUE) {
            str = "never";
        } else {
            str = (jMsSinceLastSilentRequest / 1000) + "s";
        }
        sb2.append("msSinceLastSilentRequest=" + ((Object) str));
        sb2.append('\n');
        long j10 = (long) 1024;
        sb2.append("unchargedSessionBytes=" + ((unchargedSessionBytes.get() / j10) / j10) + "MB");
        sb2.append('\n');
        sb2.append("unchargedSessionStartMono=" + unchargedSessionStartMono.get());
        sb2.append('\n');
        sb2.append("tunables: " + AutoUpdateTunables.INSTANCE.dump());
        sb2.append('\n');
        sb2.append(PendingAutoUpdateStore.INSTANCE.dump());
        return sb2.toString();
    }

    @Override // com.stepos.core.ota.push.ModelUpdateConditionListener
    public void onBatteryChanged(int i10) {
        diag(ai.onnxruntime.providers.a.a(i10, "condition batteryChanged pct="));
        pauseIfViolated(ai.onnxruntime.providers.a.a(i10, "battery_"));
    }

    @Override // com.stepos.core.ota.push.ModelUpdateConditionListener
    public void onNetworkStatusChange(boolean z) {
        diag("condition networkChanged wifiValidated=" + z);
        if (!z) {
            cancelAllSilent$default(this, "wifi_lost", null, 2, null);
            return;
        }
        try {
            OtaProcessClient.INSTANCE.reconcileInterruptedAsync(OtaRuntime.INSTANCE.requireAppContext(), "wifi_validated");
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        resumeSilentPaused("wifi_validated");
        tryRun$default(this, "wifi_validated", false, 2, null);
    }

    public final void onPeriodicWake(String reason) {
        g.f(reason, "reason");
        diag("worker wake reason=".concat(reason));
        tryRun$default(this, reason, false, 2, null);
    }

    @Override // com.stepos.core.ota.push.ModelUpdateConditionListener
    public void onPowerChanged(boolean z) {
        diag("condition powerChanged charging=" + z);
        if (!z) {
            pauseIfViolated("power_disconnected");
        } else {
            resetUnchargedSession("charging");
            tryRun$default(this, "power_connected", false, 2, null);
        }
    }

    @Override // com.stepos.core.ota.push.ModelUpdateConditionListener
    public void onScreenChanged(boolean z) {
        diag("condition screenChanged screenOff=" + z);
        tryRun$default(this, z ? "screen_off" : "screen_on", false, 2, null);
        if (z) {
            try {
                ModelAutoUpdateWorkScheduler.INSTANCE.scheduleOnce(OtaRuntime.INSTANCE.requireAppContext(), "screen_off");
                n nVar = n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
    }

    public final void pauseAllOnServiceDisabled(String reason) {
        Object objA;
        g.f(reason, "reason");
        try {
            for (Map.Entry<String, OtaStateSnapshot> entry : OtaRuntime.INSTANCE.snapshot().entrySet()) {
                String key = entry.getKey();
                OtaStateSnapshot value = entry.getValue();
                if (value.getState().isActive()) {
                    AIEngineLogger.i(LogModule.OTA, TAG, "pause task on service disabled otaId=" + key + " reason=" + reason + " sources=" + value.getSources());
                    OtaRuntime.INSTANCE.dispatcher().pause(key, PauseReason.SERVICE_DISABLED);
                }
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "pauseAllOnServiceDisabled failed reason=".concat(reason), thB);
        }
    }

    public final void resumeSilentPaused(String reason) {
        Object objA;
        g.f(reason, "reason");
        try {
            CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
            if (cTAPermissionManager.isModelOtaAllowed()) {
                boolean zIsWlanAutoUpgradeEnabled = cTAPermissionManager.isWlanAutoUpgradeEnabled();
                Set setS0 = l.s0(new TriggerSource[]{TriggerSource.SILENT, TriggerSource.PUSH_FORCE});
                for (Map.Entry<String, OtaStateSnapshot> entry : OtaRuntime.INSTANCE.snapshot().entrySet()) {
                    String key = entry.getKey();
                    OtaStateSnapshot value = entry.getValue();
                    if ((value.getState() instanceof OtaState.Paused) && !value.getSources().contains(TriggerSource.USER)) {
                        Set<TriggerSource> sources = value.getSources();
                        if (!(sources instanceof Collection) || !sources.isEmpty()) {
                            Iterator<T> it = sources.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                if (setS0.contains((TriggerSource) it.next())) {
                                    PendingAutoUpdateStore.Record record = PendingAutoUpdateStore.INSTANCE.get(key);
                                    boolean z = false;
                                    if (record != null && record.isNewDownload()) {
                                        z = true;
                                    }
                                    if (zIsWlanAutoUpgradeEnabled || z) {
                                        AIEngineLogger.i(LogModule.OTA, TAG, "resume silent task otaId=" + key + " reason=" + reason + " newDownload=" + z + " sources=" + value.getSources());
                                        OtaRuntime.INSTANCE.dispatcher().resume(key, TriggerSource.SILENT);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                AIEngineLogger.i(LogModule.OTA, TAG, "resumeSilentPaused skip: CTA / service off (reason=" + reason + ")");
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "resumeSilentPaused failed reason=".concat(reason), thB);
        }
    }

    public final void start() {
        startWatching();
        diag("start watching silent update pipeline");
        OtaRuntime.INSTANCE.setOnRemoteConnected(new a9.b(23));
    }

    public final void tryRun(String reason, boolean z) {
        g.f(reason, "reason");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && jElapsedRealtime - lastEvalAtMono < 10000) {
            AIEngineLogger.i(LogModule.OTA, TAG, "debounced(<10s), skip: reason=".concat(reason));
            diag("tryRun debounced reason=".concat(reason));
            return;
        }
        diag("tryRun accepted reason=" + reason + " bypassThrottle=" + z);
        lastEvalAtMono = jElapsedRealtime;
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C04081(reason, z, null), 3, null);
    }
}
