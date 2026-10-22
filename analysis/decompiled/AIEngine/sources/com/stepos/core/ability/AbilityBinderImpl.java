package com.stepos.core.ability;

import android.content.Context;
import android.os.Binder;
import android.os.SystemClock;
import b7.j;
import b7.k;
import com.stepos.base.model.InferenceConfig;
import com.stepos.base.model.ModelReleaseReason;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.ability.IAIAbility;
import com.stepos.core.ability.deepbinder.InferRecycleGate;
import com.stepos.core.ability.deepbinder.LiveInferRegistry;
import com.stepos.core.ability.executor.IInferenceExecutor;
import com.stepos.core.ability.handler.BinderResultHandler;
import com.stepos.core.ability.handler.InferResult;
import com.stepos.core.ability.session.ChatSessionImpl;
import com.stepos.core.ability.session.ClientState;
import com.stepos.core.ability.session.SessionRegistry;
import com.stepos.core.ability.speech.AsrAbility;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.AsrPcmDumpSink;
import com.stepos.core.ability.speech.AsrRealtimeAbility;
import com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator;
import com.stepos.core.ability.speech.AsrSseAbility;
import com.stepos.core.ability.speech.SpeechAbility;
import com.stepos.core.ability.speech.StreamingCapableAbility;
import com.stepos.core.ability.speech.TtsStreamAbility;
import com.stepos.core.ability.speech.TtsStreamBinderCoordinator;
import com.stepos.core.callback.IBoolCallback;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.callback.IReleaseCallback;
import com.stepos.core.common.cloud.AccountTokenCache;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.DataVolume;
import com.stepos.core.common.telemetry.Hardware;
import com.stepos.core.common.telemetry.LoadCallerContext;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.model.task.PriorityArbiterImpl;
import com.stepos.deepbinder.core.entity.ext.CallerData;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.ThreadContextElementKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityBinderImpl implements IAbilityBinder, InferRecycleGate {
    private static final String ABILITY_ID_ASR_SSE = "stepos-asr-sse";
    private static final long ACQUIRE_FAILURE_MUTE_MS = 5000;
    public static final String ACTION_QUERY_IDLE_STATE = "queryIdleState";
    public static final String ACTION_SET_IDLE_TIMEOUT = "setIdleTimeout";
    private static final long IDLE_DELAY_MS = 20000;
    private static final long IDLE_TIMEOUT_MAX_MS = 600000;
    private static final long IDLE_TIMEOUT_MIN_MS = 3000;
    private final String TAG;
    private final p6.d<?, ?> ability;
    private final String abilityId;
    private final CoroutineScope abilityScope;
    private volatile boolean acquireInProgress;
    private final AtomicInteger activeInferences;
    private final lb.d asrRealtimeCoordinator$delegate;
    private final lb.d asrSsePcmDumpSink$delegate;
    private final int callerPid;
    private final int callerUid;
    private volatile ClientState clientState;
    private final long createdAtMs;
    private final IInferenceExecutor executor;
    private volatile long idleDelayMs;
    private volatile Job idleTransitionJob;
    private final ConcurrentHashMap<String, Job> inferJobs;
    private final ConcurrentHashMap.KeySetView<String, Boolean> inferSlots;
    private volatile boolean isReleased;
    private volatile boolean isSoftReleased;
    private final AtomicReference<Pair<Integer, Long>> lastAcquireFailure;
    private final LiveInferRegistry liveInferRegistry;
    private final ConcurrentHashMap.KeySetView<String, Boolean> localStreamCounted;
    private volatile boolean pendingHardReleaseAfterDrain;
    private volatile boolean pendingRelease;
    private volatile ModelReleaseReason pendingReleaseReason;
    private volatile boolean pendingSoftRelease;
    private volatile boolean pendingSoftReleaseAfterDrain;
    private final ExecutorCoroutineDispatcher singleThreadDispatcher;
    private final String token;
    private final lb.d ttsStreamCoordinator$delegate;
    public static final Companion Companion = new Companion(null);
    private static final lb.d<PriorityArbiterImpl> tierArbiter$delegate = kotlin.b.b(new a9.a(7));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AbilityStub extends IAIAbility.Stub {
        private final AbilityBinderImpl impl;

        public AbilityStub(AbilityBinderImpl impl) {
            kotlin.jvm.internal.g.f(impl, "impl");
            this.impl = impl;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public boolean acquire() {
            return AbilityBinderImpl.handleAcquire$default(this.impl, 0L, 1, null);
        }

        @Override // com.stepos.core.ability.IAIAbility
        public boolean cancel() {
            return this.impl.handleCancel();
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void cancelByUser() {
            this.impl.handleCancelByUser();
        }

        @Override // com.stepos.core.ability.IAIAbility
        public boolean cancelInfer(String inferId) {
            kotlin.jvm.internal.g.f(inferId, "inferId");
            return this.impl.handleCancelInfer(inferId);
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void completeInput(String str) {
            if (str != null) {
                this.impl.handleCompleteInput(str);
            }
        }

        @Override // com.stepos.core.ability.IAIAbility
        public IChatSession createSession() {
            return this.impl.handleCreateSession();
        }

        @Override // com.stepos.core.ability.IAIAbility
        public Content execute(String str, Content content) {
            AbilityBinderImpl abilityBinderImpl = this.impl;
            if (str == null) {
                str = "";
            }
            return abilityBinderImpl.handleExecute(str, content);
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void feedInput(String str, Content content) {
            if (str == null || content == null) {
                return;
            }
            this.impl.handleFeedInput(str, content);
        }

        @Override // com.stepos.core.ability.IAIAbility
        public AbilityInfo getInfo() {
            return this.impl.getInfo();
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void infer(String inferId, Content input, IInferenceCallback iInferenceCallback) throws Throwable {
            kotlin.jvm.internal.g.f(inferId, "inferId");
            kotlin.jvm.internal.g.f(input, "input");
            this.impl.handleInfer(inferId, input, iInferenceCallback);
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void preload(IBoolCallback iBoolCallback) {
            this.impl.handlePreload(iBoolCallback);
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void registerReleaseCallback(IReleaseCallback iReleaseCallback) {
            this.impl.handleRegisterReleaseCallback(iReleaseCallback, Binder.getCallingUid());
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void release() {
            AbilityManager.releaseAbility$default(AbilityManager.INSTANCE, this.impl.getToken(), false, null, 6, null);
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void unregisterReleaseCallback() {
            this.impl.handleUnregisterReleaseCallback(Binder.getCallingUid());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PriorityArbiterImpl getTierArbiter() {
            return (PriorityArbiterImpl) AbilityBinderImpl.tierArbiter$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class HardReleaseAction {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ HardReleaseAction[] $VALUES;
        public static final HardReleaseAction NOW = new HardReleaseAction("NOW", 0);
        public static final HardReleaseAction DEFER_ACQUIRE = new HardReleaseAction("DEFER_ACQUIRE", 1);
        public static final HardReleaseAction DEFER_DRAIN = new HardReleaseAction("DEFER_DRAIN", 2);

        private static final /* synthetic */ HardReleaseAction[] $values() {
            return new HardReleaseAction[]{NOW, DEFER_ACQUIRE, DEFER_DRAIN};
        }

        static {
            HardReleaseAction[] hardReleaseActionArr$values = $values();
            $VALUES = hardReleaseActionArr$values;
            $ENTRIES = kotlin.enums.a.a(hardReleaseActionArr$values);
        }

        private HardReleaseAction(String str, int i10) {
        }

        public static sb.a<HardReleaseAction> getEntries() {
            return $ENTRIES;
        }

        public static HardReleaseAction valueOf(String str) {
            return (HardReleaseAction) Enum.valueOf(HardReleaseAction.class, str);
        }

        public static HardReleaseAction[] values() {
            return (HardReleaseAction[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.AbilityBinderImpl$doSoftRelease$1", f = "AbilityBinderImpl.kt", l = {1274}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.AbilityBinderImpl$doSoftRelease$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return AbilityBinderImpl.this.new AnonymousClass1(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                AbilityBinderImpl abilityBinderImpl = AbilityBinderImpl.this;
                this.label = 1;
                if (abilityBinderImpl.doSoftReleaseBody(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.AbilityBinderImpl", f = "AbilityBinderImpl.kt", l = {1296}, m = "doSoftReleaseBody")
    /* renamed from: com.stepos.core.ability.AbilityBinderImpl$doSoftReleaseBody$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02891 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02891(qb.b<? super C02891> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AbilityBinderImpl.this.doSoftReleaseBody(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.AbilityBinderImpl$handlePreload$1", f = "AbilityBinderImpl.kt", l = {864, 873, 878}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.AbilityBinderImpl$handlePreload$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02901 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ IBoolCallback $callback;
        long J$0;
        long J$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02901(IBoolCallback iBoolCallback, qb.b<? super C02901> bVar) {
            super(2, bVar);
            this.$callback = iBoolCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return AbilityBinderImpl.this.new C02901(this.$callback, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d0, code lost:
        
            if (r15.release(com.stepos.base.model.ModelReleaseReason.f6321b, r14) == r2) goto L43;
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00ae A[Catch: Exception -> 0x0019, TryCatch #0 {Exception -> 0x0019, blocks: (B:7:0x0014, B:44:0x00d3, B:46:0x00e5, B:48:0x00f0, B:50:0x00f4, B:51:0x00f9, B:53:0x011a, B:13:0x0025, B:33:0x00aa, B:35:0x00ae, B:38:0x00bc, B:39:0x00bf, B:16:0x002e, B:22:0x006e, B:24:0x0076, B:26:0x0082, B:29:0x0092, B:30:0x0095, B:41:0x00c2, B:19:0x003e), top: B:63:0x000c }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 335
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityBinderImpl.C02901.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C02901) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.AbilityBinderImpl$onInferTerminal$1", f = "AbilityBinderImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.AbilityBinderImpl$onInferTerminal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02911 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        public C02911(qb.b<? super C02911> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return AbilityBinderImpl.this.new C02911(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            AbilityBinderImpl abilityBinderImpl = AbilityBinderImpl.this;
            abilityBinderImpl.doRelease(abilityBinderImpl.pendingReleaseReason);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C02911) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.AbilityBinderImpl$onInferTerminal$2", f = "AbilityBinderImpl.kt", l = {940}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.AbilityBinderImpl$onInferTerminal$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        public AnonymousClass2(qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return AbilityBinderImpl.this.new AnonymousClass2(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                AbilityBinderImpl abilityBinderImpl = AbilityBinderImpl.this;
                this.label = 1;
                if (abilityBinderImpl.runDeferredSoftRelease(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.AbilityBinderImpl$scheduleIdleTransition$1", f = "AbilityBinderImpl.kt", l = {811}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.AbilityBinderImpl$scheduleIdleTransition$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02921 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        public C02921(qb.b<? super C02921> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return AbilityBinderImpl.this.new C02921(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                long idleDelayMs$ability_release = AbilityBinderImpl.this.getIdleDelayMs$ability_release();
                this.label = 1;
                if (DelayKt.delay(idleDelayMs$ability_release, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            if (AbilityBinderImpl.this.getClientState() == ClientState.ACTIVE && !AbilityBinderImpl.this.isReleased && !AbilityBinderImpl.this.isSoftReleased) {
                AbilityBinderImpl.this.clientState = ClientState.IDLE;
                a0.a.z(com.stepos.core.ota.d.l("IDLE timeout reached: token=", AbilityBinderImpl.this.getIdleDelayMs$ability_release(), AbilityBinderImpl.this.getToken(), " ("), "ms no activity), auto softRelease to free native", LogModule.ABILITY, AbilityBinderImpl.this.TAG);
                AbilityBinderImpl.this.doSoftReleaseFlow();
                AbilityBinderImpl.this.triggerModelRelease();
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C02921) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.AbilityBinderImpl$submitInferAsync$2", f = "AbilityBinderImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.AbilityBinderImpl$submitInferAsync$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02932 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ IInferenceCallback $callback;
        final /* synthetic */ String $inferId;
        final /* synthetic */ Content $input;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02932(String str, Content content, IInferenceCallback iInferenceCallback, qb.b<? super C02932> bVar) {
            super(2, bVar);
            this.$inferId = str;
            this.$input = content;
            this.$callback = iInferenceCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return AbilityBinderImpl.this.new C02932(this.$inferId, this.$input, this.$callback, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            AbilityBinderImpl.this.handleInfer(this.$inferId, this.$input, this.$callback);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C02932) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    public AbilityBinderImpl(String token, p6.d<?, ?> ability, IInferenceExecutor executor, int i10, int i11) {
        kotlin.jvm.internal.g.f(token, "token");
        kotlin.jvm.internal.g.f(ability, "ability");
        kotlin.jvm.internal.g.f(executor, "executor");
        this.token = token;
        this.ability = ability;
        this.executor = executor;
        this.callerPid = i10;
        this.callerUid = i11;
        this.abilityId = ability.getAbilityConfig().f11416a;
        this.createdAtMs = SystemClock.elapsedRealtime();
        this.TAG = "AbilityBinderImpl";
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new android.llama.cpp.a(this, 1));
        kotlin.jvm.internal.g.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        ExecutorCoroutineDispatcher executorCoroutineDispatcherFrom = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        this.singleThreadDispatcher = executorCoroutineDispatcherFrom;
        this.abilityScope = CoroutineScopeKt.CoroutineScope(executorCoroutineDispatcherFrom.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.lastAcquireFailure = new AtomicReference<>(new Pair(0, 0L));
        this.pendingReleaseReason = ModelReleaseReason.f6321b;
        this.activeInferences = new AtomicInteger(0);
        this.localStreamCounted = ConcurrentHashMap.newKeySet();
        this.clientState = ClientState.IDLE;
        this.idleDelayMs = IDLE_DELAY_MS;
        this.inferJobs = new ConcurrentHashMap<>();
        this.inferSlots = ConcurrentHashMap.newKeySet();
        this.liveInferRegistry = new LiveInferRegistry();
        final int i12 = 0;
        this.ttsStreamCoordinator$delegate = kotlin.b.b(new zb.a(this) { // from class: com.stepos.core.ability.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbilityBinderImpl f7216b;

            {
                this.f7216b = this;
            }

            @Override // zb.a
            public final Object invoke() {
                int i13 = i12;
                AbilityBinderImpl abilityBinderImpl = this.f7216b;
                switch (i13) {
                    case 0:
                        return AbilityBinderImpl.ttsStreamCoordinator_delegate$lambda$34(abilityBinderImpl);
                    default:
                        return AbilityBinderImpl.asrRealtimeCoordinator_delegate$lambda$37(abilityBinderImpl);
                }
            }
        });
        this.asrSsePcmDumpSink$delegate = kotlin.b.b(new b6.g(this, 2));
        final int i13 = 1;
        this.asrRealtimeCoordinator$delegate = kotlin.b.b(new zb.a(this) { // from class: com.stepos.core.ability.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbilityBinderImpl f7216b;

            {
                this.f7216b = this;
            }

            @Override // zb.a
            public final Object invoke() {
                int i132 = i13;
                AbilityBinderImpl abilityBinderImpl = this.f7216b;
                switch (i132) {
                    case 0:
                        return AbilityBinderImpl.ttsStreamCoordinator_delegate$lambda$34(abilityBinderImpl);
                    default:
                        return AbilityBinderImpl.asrRealtimeCoordinator_delegate$lambda$37(abilityBinderImpl);
                }
            }
        });
    }

    private final boolean acceptInferSlot(String str) {
        return this.inferSlots.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsrRealtimeBinderCoordinator asrRealtimeCoordinator_delegate$lambda$37(final AbilityBinderImpl abilityBinderImpl) {
        p6.d<?, ?> dVar = abilityBinderImpl.ability;
        StreamingCapableAbility streamingCapableAbility = dVar instanceof StreamingCapableAbility ? (StreamingCapableAbility) dVar : null;
        if (streamingCapableAbility != null) {
            return new AsrRealtimeBinderCoordinator(streamingCapableAbility, abilityBinderImpl.callerUid, new AsrRealtimeBinderCoordinator.Host() { // from class: com.stepos.core.ability.AbilityBinderImpl$asrRealtimeCoordinator$2$1$1
                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void cancelInferJob(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    Job job = (Job) this.this$0.inferJobs.get(inferId);
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, null, 1, null);
                    }
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void decActiveInference() {
                    this.this$0.activeInferences.decrementAndGet();
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void decLocalStreamCountIfCounted(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    this.this$0.decLocalStreamCountIfCounted(inferId);
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void endAicScene(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public boolean forwardCompleteInput(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    try {
                        this.this$0.getAbility().completeInput(inferId);
                        return true;
                    } catch (UnsupportedOperationException unused) {
                        ai.onnxruntime.a.w("forwardCompleteInput: not supported. token=", getToken(), LogModule.ABILITY, this.this$0.TAG);
                        return false;
                    } catch (Exception e10) {
                        AIEngineLogger.e(LogModule.ABILITY, this.this$0.TAG, "forwardCompleteInput error: token=" + getToken(), e10);
                        return false;
                    }
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void forwardFeedInput(String inferId, Content input) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    kotlin.jvm.internal.g.f(input, "input");
                    try {
                        this.this$0.getAbility().onFeedInput(inferId, input);
                    } catch (UnsupportedOperationException unused) {
                        ai.onnxruntime.a.w("forwardFeedInput: not supported. token=", getToken(), LogModule.ABILITY, this.this$0.TAG);
                    } catch (Exception e10) {
                        AIEngineLogger.e(LogModule.ABILITY, this.this$0.TAG, "forwardFeedInput error: token=" + getToken(), e10);
                    }
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public String getAbilityId() {
                    return this.this$0.getAbility().getAbilityConfig().f11416a;
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public CoroutineScope getAbilityScope() {
                    return this.this$0.abilityScope;
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public String getModelId() {
                    k kVar = (k) kotlin.collections.a.v0(this.this$0.getAbility().getAbilityConfig().f11419d);
                    String str = kVar != null ? kVar.f3090a : null;
                    return str == null ? "" : str;
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public String getToken() {
                    return this.this$0.getToken();
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void incActiveInference() {
                    this.this$0.activeInferences.incrementAndGet();
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void incLocalStreamCount(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    this.this$0.incLocalStreamCount(inferId);
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void markActive() {
                    this.this$0.markActive();
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void onInferTerminal(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    this.this$0.liveInferRegistry.onInferTerminal(inferId);
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void putInferJob(String inferId, Job job) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    kotlin.jvm.internal.g.f(job, "job");
                    this.this$0.inferJobs.put(inferId, job);
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void releaseInferSlot(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    this.this$0.releaseInferSlot(inferId);
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void removeInferJob(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    this.this$0.inferJobs.remove(inferId);
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void scheduleIdleTransition() {
                    this.this$0.scheduleIdleTransition();
                }

                @Override // com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.Host
                public void startAicScene(String inferId, boolean z) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsrPcmDumpSink asrSsePcmDumpSink_delegate$lambda$35(AbilityBinderImpl abilityBinderImpl) {
        if (kotlin.jvm.internal.g.b(abilityBinderImpl.abilityId, ABILITY_ID_ASR_SSE)) {
            return new AsrPcmDumpSink(abilityBinderImpl.callerUid);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decLocalStreamCountIfCounted(String str) {
        if (this.localStreamCounted.remove(str)) {
            this.activeInferences.decrementAndGet();
        }
    }

    private final void doHardReleaseFlow(boolean z, ModelReleaseReason modelReleaseReason) {
        HardReleaseAction hardReleaseAction;
        synchronized (this) {
            if (this.isReleased) {
                AIEngineLogger.d(LogModule.ABILITY, this.TAG, "releaseBinder(hard): already released. token=" + this.token);
                return;
            }
            this.isReleased = true;
            if (this.acquireInProgress) {
                this.pendingRelease = true;
                this.pendingReleaseReason = modelReleaseReason;
                AIEngineLogger.w(LogModule.ABILITY, this.TAG, "releaseBinder(hard): acquire in progress, deferring. token=" + this.token);
                hardReleaseAction = HardReleaseAction.DEFER_ACQUIRE;
            } else if (!z || this.liveInferRegistry.isEmpty()) {
                hardReleaseAction = HardReleaseAction.NOW;
            } else {
                this.pendingHardReleaseAfterDrain = true;
                this.pendingReleaseReason = modelReleaseReason;
                AIEngineLogger.w(LogModule.ABILITY, this.TAG, "releaseBinder(hard): in-flight infer(s) present, deferring destroy until drain. token=" + this.token);
                hardReleaseAction = HardReleaseAction.DEFER_DRAIN;
            }
            if (hardReleaseAction == HardReleaseAction.NOW) {
                doRelease(modelReleaseReason);
            }
        }
    }

    public static /* synthetic */ void doHardReleaseFlow$default(AbilityBinderImpl abilityBinderImpl, boolean z, ModelReleaseReason modelReleaseReason, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modelReleaseReason = ModelReleaseReason.f6321b;
        }
        abilityBinderImpl.doHardReleaseFlow(z, modelReleaseReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doRelease(ModelReleaseReason modelReleaseReason) {
        ExecutorCoroutineDispatcher executorCoroutineDispatcher;
        Object objA;
        Object objA2;
        LogModule logModule = LogModule.ABILITY;
        String str = this.TAG;
        String str2 = this.token;
        int i10 = this.callerPid;
        boolean z = this.isSoftReleased;
        StringBuilder sbF = h0.e.f("doRelease(hard) BEGIN: token=", str2, ", callerPid=", i10, ", fromSoftReleased=");
        sbF.append(z);
        sbF.append(", reason=");
        sbF.append(modelReleaseReason);
        AIEngineLogger.i(logModule, str, sbF.toString());
        try {
            try {
                try {
                    AsrRealtimeBinderCoordinator asrRealtimeCoordinator = getAsrRealtimeCoordinator();
                    if (asrRealtimeCoordinator != null) {
                        asrRealtimeCoordinator.releaseClose();
                        n nVar = n.f10413a;
                    }
                } catch (Throwable th) {
                    try {
                        this.singleThreadDispatcher.close();
                    } catch (Exception e10) {
                        ai.onnxruntime.a.w("Failed to close dispatcher: ", e10.getMessage(), LogModule.ABILITY, this.TAG);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    kotlin.c.a(th2);
                } catch (Exception e11) {
                    AIEngineLogger.e(LogModule.ABILITY, this.TAG, "doRelease error: token=" + this.token + ", " + e11.getMessage(), e11);
                    executorCoroutineDispatcher = this.singleThreadDispatcher;
                }
            }
            try {
                AsrPcmDumpSink asrSsePcmDumpSink = getAsrSsePcmDumpSink();
                if (asrSsePcmDumpSink != null) {
                    asrSsePcmDumpSink.closeAll();
                    n nVar2 = n.f10413a;
                }
            } catch (Throwable th3) {
                kotlin.c.a(th3);
            }
            try {
                this.liveInferRegistry.clear();
                n nVar3 = n.f10413a;
            } catch (Throwable th4) {
                kotlin.c.a(th4);
            }
            try {
                drainLocalStreamCounts();
                n nVar4 = n.f10413a;
            } catch (Throwable th5) {
                kotlin.c.a(th5);
            }
            try {
                this.executor.release();
                objA = n.f10413a;
            } catch (Throwable th6) {
                objA = kotlin.c.a(th6);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.ABILITY, this.TAG, "doRelease: executor.release failed, token=" + this.token, thB);
            }
            if (this.isSoftReleased) {
                AIEngineLogger.i(LogModule.ABILITY, this.TAG, "doRelease(hard): skip ability.release (already soft-released). token=" + this.token);
            } else {
                try {
                    BuildersKt__BuildersKt.runBlocking$default(null, new AbilityBinderImpl$doRelease$7$1(this, modelReleaseReason, null), 1, null);
                    objA2 = n.f10413a;
                } catch (Throwable th7) {
                    objA2 = kotlin.c.a(th7);
                }
                Throwable thB2 = Result.b(objA2);
                if (thB2 != null) {
                    AIEngineLogger.e(LogModule.ABILITY, this.TAG, "doRelease: ability.release failed, token=" + this.token, thB2);
                }
            }
            AIEngineLogger.i(LogModule.ABILITY, this.TAG, "✅ Ability released: token=" + this.token);
            executorCoroutineDispatcher = this.singleThreadDispatcher;
            executorCoroutineDispatcher.close();
        } catch (Exception e12) {
            ai.onnxruntime.a.w("Failed to close dispatcher: ", e12.getMessage(), LogModule.ABILITY, this.TAG);
        }
    }

    public static /* synthetic */ void doRelease$default(AbilityBinderImpl abilityBinderImpl, ModelReleaseReason modelReleaseReason, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            modelReleaseReason = ModelReleaseReason.f6321b;
        }
        abilityBinderImpl.doRelease(modelReleaseReason);
    }

    private final void doSoftRelease() {
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doSoftReleaseBody(qb.b<? super lb.n> r9) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityBinderImpl.doSoftReleaseBody(qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doSoftReleaseFlow() {
        synchronized (this) {
            if (this.isReleased) {
                AIEngineLogger.d(LogModule.ABILITY, this.TAG, "releaseBinder(soft): already hard-released, skip. token=" + this.token);
                return;
            }
            if (this.isSoftReleased) {
                AIEngineLogger.d(LogModule.ABILITY, this.TAG, "releaseBinder(soft): already soft-released. token=" + this.token);
                return;
            }
            if (this.acquireInProgress) {
                this.pendingSoftRelease = true;
                AIEngineLogger.w(LogModule.ABILITY, this.TAG, "releaseBinder(soft): acquire in progress, deferring. token=" + this.token);
                return;
            }
            if (this.liveInferRegistry.isEmpty()) {
                this.isSoftReleased = true;
                doSoftRelease();
                return;
            }
            this.pendingSoftReleaseAfterDrain = true;
            AIEngineLogger.w(LogModule.ABILITY, this.TAG, "releaseBinder(soft): binder still has in-flight infer(s), deferring until drain. token=" + this.token);
        }
    }

    private final void drainLocalStreamCounts() {
        Iterator<String> it = this.localStreamCounted.iterator();
        kotlin.jvm.internal.g.e(it, "iterator(...)");
        while (it.hasNext()) {
            String next = it.next();
            kotlin.jvm.internal.g.c(next);
            decLocalStreamCountIfCounted(next);
        }
    }

    private final AsrRealtimeBinderCoordinator getAsrRealtimeCoordinator() {
        return (AsrRealtimeBinderCoordinator) this.asrRealtimeCoordinator$delegate.getValue();
    }

    private final AsrPcmDumpSink getAsrSsePcmDumpSink() {
        return (AsrPcmDumpSink) this.asrSsePcmDumpSink$delegate.getValue();
    }

    private final TtsStreamBinderCoordinator getTtsStreamCoordinator() {
        return (TtsStreamBinderCoordinator) this.ttsStreamCoordinator$delegate.getValue();
    }

    public static /* synthetic */ boolean handleAcquire$default(AbilityBinderImpl abilityBinderImpl, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS;
        }
        return abilityBinderImpl.handleAcquire(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleAcquire$lambda$2(long j10, AbilityBinderImpl abilityBinderImpl, long j11, long j12, Ref$BooleanRef ref$BooleanRef) {
        return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new AbilityBinderImpl$handleAcquire$result$1$1(j10, abilityBinderImpl, j11, j12, ref$BooleanRef, null), 1, null)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataVolume handleInfer$lambda$22$lambda$21$lambda$20$lambda$19(int i10, DataVolume it) {
        kotlin.jvm.internal.g.f(it, "it");
        return DataVolume.copy$default(it, null, null, null, null, null, null, null, Integer.valueOf(i10), null, 383, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleInfer$lambda$26(AtomicBoolean atomicBoolean, AbilityBinderImpl abilityBinderImpl, BinderResultHandler binderResultHandler, String requestId, InferResult result) {
        kotlin.jvm.internal.g.f(requestId, "requestId");
        kotlin.jvm.internal.g.f(result, "result");
        if ((result instanceof InferResult.Complete) || (result instanceof InferResult.Error)) {
            if (!atomicBoolean.compareAndSet(false, true)) {
                return;
            } else {
                abilityBinderImpl.activeInferences.decrementAndGet();
            }
        }
        binderResultHandler.onResult(requestId, result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n handleInfer$lambda$27(AbilityBinderImpl abilityBinderImpl, String str) {
        abilityBinderImpl.inferJobs.remove(str);
        abilityBinderImpl.releaseInferSlot(str);
        abilityBinderImpl.scheduleIdleTransition();
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incLocalStreamCount(String str) {
        if (this.localStreamCounted.add(str)) {
            this.activeInferences.incrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markActive() {
        this.clientState = ClientState.ACTIVE;
        Job job = this.idleTransitionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.idleTransitionJob = null;
    }

    private final PowerPerfTracker newTracker(String str, k kVar, int i10, String str2, boolean z, String str3, long j10, long j11) {
        InferenceConfig inferenceConfig;
        Object objA;
        String strName;
        String str4;
        if (kVar != null) {
            try {
                inferenceConfig = kVar.f3096g;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
        } else {
            inferenceConfig = null;
        }
        String str5 = this.abilityId;
        String str6 = kVar != null ? kVar.f3090a : "";
        String str7 = (inferenceConfig == null || (str4 = inferenceConfig.f6263a) == null) ? "" : str4;
        if (inferenceConfig == null || (strName = Hardware.Companion.fromComputeDevice(inferenceConfig.f6264b).name()) == null) {
            strName = ModelFlowMeta.PLAN_NONE;
        }
        objA = new PowerPerfTracker(str, i10, str2, str5, str6, z, str7, strName, str3, j10, j11);
        return (PowerPerfTracker) (objA instanceof Result.Failure ? null : objA);
    }

    public static /* synthetic */ PowerPerfTracker newTracker$default(AbilityBinderImpl abilityBinderImpl, String str, k kVar, int i10, String str2, boolean z, String str3, long j10, long j11, int i11, Object obj) {
        return abilityBinderImpl.newTracker(str, kVar, i10, str2, z, (i11 & 32) != 0 ? "" : str3, (i11 & 64) != 0 ? SystemClock.elapsedRealtimeNanos() : j10, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? System.currentTimeMillis() : j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[Catch: all -> 0x000f, TryCatch #0 {all -> 0x000f, blocks: (B:3:0x0002, B:5:0x0006, B:15:0x0026, B:17:0x0044, B:26:0x00bc, B:19:0x004c, B:21:0x006e, B:22:0x0077, B:25:0x009c, B:9:0x0012, B:11:0x0019, B:13:0x0020), top: B:33:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e A[Catch: all -> 0x000f, TryCatch #0 {all -> 0x000f, blocks: (B:3:0x0002, B:5:0x0006, B:15:0x0026, B:17:0x0044, B:26:0x00bc, B:19:0x004c, B:21:0x006e, B:22:0x0077, B:25:0x009c, B:9:0x0012, B:11:0x0019, B:13:0x0020), top: B:33:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c A[Catch: all -> 0x000f, TryCatch #0 {all -> 0x000f, blocks: (B:3:0x0002, B:5:0x0006, B:15:0x0026, B:17:0x0044, B:26:0x00bc, B:19:0x004c, B:21:0x006e, B:22:0x0077, B:25:0x009c, B:9:0x0012, B:11:0x0019, B:13:0x0020), top: B:33:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void publishAcquireFailure(java.lang.Throwable r16, long r17, long r19) {
        /*
            r15 = this;
            r0 = r16
            boolean r2 = r0 instanceof com.stepos.core.model.task.InferenceException     // Catch: java.lang.Throwable -> Lf
            if (r2 == 0) goto L12
            r2 = r0
            com.stepos.core.model.task.InferenceException r2 = (com.stepos.core.model.task.InferenceException) r2     // Catch: java.lang.Throwable -> Lf
            int r2 = r2.getErrorCode()     // Catch: java.lang.Throwable -> Lf
        Ld:
            r14 = r2
            goto L26
        Lf:
            r0 = move-exception
            goto Lbf
        L12:
            boolean r2 = r0 instanceof com.stepos.base.model.ModelLoadException     // Catch: java.lang.Throwable -> Lf
            r3 = 110004(0x1adb4, float:1.54148E-40)
            if (r2 == 0) goto L25
            r2 = r0
            com.stepos.base.model.ModelLoadException r2 = (com.stepos.base.model.ModelLoadException) r2     // Catch: java.lang.Throwable -> Lf
            java.lang.Integer r2 = r2.f6319a     // Catch: java.lang.Throwable -> Lf
            if (r2 == 0) goto L25
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> Lf
            goto Ld
        L25:
            r14 = r3
        L26:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> Lf
            java.util.concurrent.atomic.AtomicReference<kotlin.Pair<java.lang.Integer, java.lang.Long>> r4 = r15.lastAcquireFailure     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r4 = r4.get()     // Catch: java.lang.Throwable -> Lf
            kotlin.Pair r4 = (kotlin.Pair) r4     // Catch: java.lang.Throwable -> Lf
            A r5 = r4.f9985a     // Catch: java.lang.Throwable -> Lf
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Throwable -> Lf
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> Lf
            B r4 = r4.f9986b     // Catch: java.lang.Throwable -> Lf
            java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Throwable -> Lf
            long r6 = r4.longValue()     // Catch: java.lang.Throwable -> Lf
            if (r5 != r14) goto L4c
            long r4 = r2 - r6
            r6 = 5000(0x1388, double:2.4703E-320)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto Lbc
        L4c:
            java.util.concurrent.atomic.AtomicReference<kotlin.Pair<java.lang.Integer, java.lang.Long>> r4 = r15.lastAcquireFailure     // Catch: java.lang.Throwable -> Lf
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)     // Catch: java.lang.Throwable -> Lf
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Lf
            kotlin.Pair r3 = new kotlin.Pair     // Catch: java.lang.Throwable -> Lf
            r3.<init>(r5, r2)     // Catch: java.lang.Throwable -> Lf
            r4.set(r3)     // Catch: java.lang.Throwable -> Lf
            p6.d<?, ?> r2 = r15.ability     // Catch: java.lang.Throwable -> Lf
            p6.a r2 = r2.getAbilityConfig()     // Catch: java.lang.Throwable -> Lf
            java.lang.String r3 = r15.token     // Catch: java.lang.Throwable -> Lf
            com.stepos.base.protocol.ProtocolType r4 = com.stepos.base.protocol.ProtocolType.f6378a     // Catch: java.lang.Throwable -> Lf
            b7.k r4 = r2.b()     // Catch: java.lang.Throwable -> Lf
            if (r4 != 0) goto L77
            java.util.List<b7.k> r2 = r2.f11419d     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r2 = kotlin.collections.a.v0(r2)     // Catch: java.lang.Throwable -> Lf
            r4 = r2
            b7.k r4 = (b7.k) r4     // Catch: java.lang.Throwable -> Lf
        L77:
            int r2 = r15.callerUid     // Catch: java.lang.Throwable -> Lf
            com.stepos.core.common.utils.AppUtils r5 = com.stepos.core.common.utils.AppUtils.INSTANCE     // Catch: java.lang.Throwable -> Lf
            java.lang.String r6 = r5.getCallerPackage(r2)     // Catch: java.lang.Throwable -> Lf
            int r7 = r15.callerUid     // Catch: java.lang.Throwable -> Lf
            boolean r5 = r5.isCallerForeground(r7)     // Catch: java.lang.Throwable -> Lf
            r12 = 32
            r13 = 0
            r7 = 0
            r1 = r4
            r4 = r2
            r2 = r3
            r3 = r1
            r1 = r6
            r6 = r5
            r5 = r1
            r1 = r15
            r8 = r17
            r10 = r19
            com.stepos.core.common.telemetry.PowerPerfTracker r2 = newTracker$default(r1, r2, r3, r4, r5, r6, r7, r8, r10, r12, r13)     // Catch: java.lang.Throwable -> Lf
            if (r2 != 0) goto L9c
            goto Lbc
        L9c:
            java.util.concurrent.atomic.AtomicReference r3 = r2.getStatus()     // Catch: java.lang.Throwable -> Lf
            com.stepos.core.common.telemetry.RecordStatus r4 = com.stepos.core.common.telemetry.RecordStatus.FAILED     // Catch: java.lang.Throwable -> Lf
            r3.set(r4)     // Catch: java.lang.Throwable -> Lf
            java.util.concurrent.atomic.AtomicInteger r3 = r2.getErrorCode()     // Catch: java.lang.Throwable -> Lf
            r3.set(r14)     // Catch: java.lang.Throwable -> Lf
            r2.recordFailure(r0)     // Catch: java.lang.Throwable -> Lf
            com.stepos.core.common.telemetry.AiPowerEventBus r0 = com.stepos.core.common.telemetry.AiPowerEventBus.INSTANCE     // Catch: java.lang.Throwable -> Lf
            long r3 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> Lf
            com.stepos.core.common.telemetry.AiPowerPerfRecord r2 = r2.buildRecord(r3)     // Catch: java.lang.Throwable -> Lf
            r0.post(r2)     // Catch: java.lang.Throwable -> Lf
        Lbc:
            lb.n r0 = lb.n.f10413a     // Catch: java.lang.Throwable -> Lf
            goto Lc3
        Lbf:
            kotlin.Result$Failure r0 = kotlin.c.a(r0)
        Lc3:
            java.lang.Throwable r0 = kotlin.Result.b(r0)
            if (r0 == 0) goto Ld6
            com.stepos.core.common.log.LogModule r2 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r1 = r15.TAG
            java.lang.String r0 = r0.getMessage()
            java.lang.String r3 = "publishAcquireFailure failed: "
            ai.onnxruntime.a.w(r3, r0, r2, r1)
        Ld6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityBinderImpl.publishAcquireFailure(java.lang.Throwable, long, long):void");
    }

    public static /* synthetic */ void releaseBinder$default(AbilityBinderImpl abilityBinderImpl, boolean z, boolean z3, ModelReleaseReason modelReleaseReason, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z3 = false;
        }
        if ((i10 & 4) != 0) {
            modelReleaseReason = ModelReleaseReason.f6321b;
        }
        abilityBinderImpl.releaseBinder(z, z3, modelReleaseReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseInferSlot(String str) {
        this.inferSlots.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runDeferredSoftRelease(qb.b<? super n> bVar) {
        boolean z;
        synchronized (this) {
            if (this.isReleased || this.isSoftReleased || this.acquireInProgress) {
                z = false;
            } else {
                z = true;
                this.isSoftReleased = true;
            }
        }
        if (!z) {
            return n.f10413a;
        }
        h0.e.k("runDeferredSoftRelease: binder drained, running deferred soft release. token=", this.token, LogModule.ABILITY, this.TAG);
        Object objDoSoftReleaseBody = doSoftReleaseBody(bVar);
        return objDoSoftReleaseBody == CoroutineSingletons.f10059a ? objDoSoftReleaseBody : n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleIdleTransition() {
        Job job = this.idleTransitionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.idleTransitionJob = BuildersKt__Builders_commonKt.launch$default(this.abilityScope, null, null, new C02921(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread singleThreadDispatcher$lambda$0(AbilityBinderImpl abilityBinderImpl, Runnable runnable) {
        return new Thread(runnable, "AbilityBinder-" + abilityBinderImpl.ability.getAbilityConfig().f11417b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PriorityArbiterImpl tierArbiter_delegate$lambda$57() {
        Context context = l7.a.f10344a;
        if (context == null) {
            context = null;
        }
        if (context != null) {
            return PriorityArbiterImpl.Companion.forContext(context);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerModelRelease() {
        p6.a abilityConfig = this.ability.getAbilityConfig();
        ProtocolType protocolType = ProtocolType.f6378a;
        k kVarB = abilityConfig.b();
        if (kVarB == null) {
            kVarB = (k) kotlin.collections.a.v0(abilityConfig.f11419d);
        }
        if (kVarB != null) {
            AIEngineLogger.d(LogModule.ABILITY, this.TAG, "IDLE -> ability " + kVarB.f3090a + " entered idle state (no model release here; deferred close is driven by handle.close on softRelease)");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TtsStreamBinderCoordinator ttsStreamCoordinator_delegate$lambda$34(final AbilityBinderImpl abilityBinderImpl) {
        p6.d<?, ?> dVar = abilityBinderImpl.ability;
        TtsStreamAbility ttsStreamAbility = dVar instanceof TtsStreamAbility ? (TtsStreamAbility) dVar : null;
        if (ttsStreamAbility != null) {
            return new TtsStreamBinderCoordinator(ttsStreamAbility, new TtsStreamBinderCoordinator.Host() { // from class: com.stepos.core.ability.AbilityBinderImpl$ttsStreamCoordinator$2$1$1
                @Override // com.stepos.core.ability.speech.TtsStreamBinderCoordinator.Host
                public void decLocalStreamCountIfCounted(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    this.this$0.decLocalStreamCountIfCounted(inferId);
                }

                @Override // com.stepos.core.ability.speech.TtsStreamBinderCoordinator.Host
                public void endAicScene(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                }

                @Override // com.stepos.core.ability.speech.TtsStreamBinderCoordinator.Host
                public CoroutineScope getAbilityScope() {
                    return this.this$0.abilityScope;
                }

                @Override // com.stepos.core.ability.speech.TtsStreamBinderCoordinator.Host
                public String getToken() {
                    return this.this$0.getToken();
                }

                @Override // com.stepos.core.ability.speech.TtsStreamBinderCoordinator.Host
                public void incLocalStreamCount(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    this.this$0.incLocalStreamCount(inferId);
                }

                @Override // com.stepos.core.ability.speech.TtsStreamBinderCoordinator.Host
                public void markActive() {
                    this.this$0.markActive();
                }

                @Override // com.stepos.core.ability.speech.TtsStreamBinderCoordinator.Host
                public void putInferJob(String inferId, Job job) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    kotlin.jvm.internal.g.f(job, "job");
                    this.this$0.inferJobs.put(inferId, job);
                }

                @Override // com.stepos.core.ability.speech.TtsStreamBinderCoordinator.Host
                public void removeInferJob(String inferId) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                    this.this$0.inferJobs.remove(inferId);
                }

                @Override // com.stepos.core.ability.speech.TtsStreamBinderCoordinator.Host
                public void scheduleIdleTransition() {
                    this.this$0.scheduleIdleTransition();
                }

                @Override // com.stepos.core.ability.speech.TtsStreamBinderCoordinator.Host
                public void startAicScene(String inferId, boolean z) {
                    kotlin.jvm.internal.g.f(inferId, "inferId");
                }
            });
        }
        return null;
    }

    public final int activeInferCount() {
        return this.activeInferences.get();
    }

    @Override // com.stepos.core.ability.IAbilityBinder
    public IAIAbility createBinder() {
        return new AbilityStub(this);
    }

    public final p6.d<?, ?> getAbility() {
        return this.ability;
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final int getCallerPid() {
        return this.callerPid;
    }

    public final int getCallerUid() {
        return this.callerUid;
    }

    public final ClientState getClientState() {
        return this.clientState;
    }

    public final long getCreatedAtMs() {
        return this.createdAtMs;
    }

    public final long getIdleDelayMs$ability_release() {
        return this.idleDelayMs;
    }

    public final AbilityInfo getInfo() {
        AbilityInfo abilityInfo = new AbilityInfo(null, null, null, null, null, null, false, 0, null, 511, null);
        p6.a abilityConfig = this.ability.getAbilityConfig();
        abilityInfo.setId(abilityConfig.f11416a);
        abilityInfo.setName(abilityConfig.f11417b.f11434a);
        abilityInfo.setDescription(abilityConfig.f11418c);
        return abilityInfo;
    }

    public final String getProperty(String name) {
        Object objA;
        kotlin.jvm.internal.g.f(name, "name");
        try {
            Object objExecute = this.ability.execute("getProperty", name);
            objA = objExecute instanceof String ? (String) objExecute : null;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return (String) (objA instanceof Result.Failure ? null : objA);
    }

    public final String getToken() {
        return this.token;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean handleAcquire(final long j10) throws Throwable {
        String str;
        Pair pair;
        Pair pair2;
        final AbilityBinderImpl abilityBinderImpl = this;
        synchronized (this) {
            if (abilityBinderImpl.isReleased) {
                AIEngineLogger.w(LogModule.ABILITY, abilityBinderImpl.TAG, "handleAcquire: already released, skip. token=" + abilityBinderImpl.token);
                return false;
            }
            abilityBinderImpl.acquireInProgress = true;
            n nVar = n.f10413a;
            LogModule logModule = LogModule.ABILITY;
            String str2 = abilityBinderImpl.TAG;
            String str3 = abilityBinderImpl.token;
            boolean z = abilityBinderImpl.isSoftReleased;
            StringBuilder sbL = com.stepos.core.ota.d.l("handleAcquire: ", j10, str3, ", timeout: ");
            sbL.append("ms, fromSoftReleased=");
            sbL.append(z);
            AIEngineLogger.d(logModule, str2, sbL.toString());
            final long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            try {
                LoadCallerContext loadCallerContext = LoadCallerContext.INSTANCE;
                int i10 = abilityBinderImpl.callerUid;
                str = "handleAcquire: found pendingSoftRelease, executing deferred. token=";
                try {
                    zb.a aVar = new zb.a() { // from class: com.stepos.core.ability.a
                        @Override // zb.a
                        public final Object invoke() {
                            return Boolean.valueOf(AbilityBinderImpl.handleAcquire$lambda$2(j10, abilityBinderImpl, jElapsedRealtimeNanos, jCurrentTimeMillis, ref$BooleanRef));
                        }
                    };
                    abilityBinderImpl = abilityBinderImpl;
                    try {
                        boolean zBooleanValue = ((Boolean) loadCallerContext.runWith(i10, aVar)).booleanValue();
                        synchronized (this) {
                            try {
                                abilityBinderImpl.acquireInProgress = false;
                                boolean z3 = abilityBinderImpl.pendingRelease;
                                boolean z10 = abilityBinderImpl.pendingSoftRelease;
                                abilityBinderImpl.pendingRelease = false;
                                abilityBinderImpl.pendingSoftRelease = false;
                                if (z3) {
                                    AIEngineLogger.w(logModule, abilityBinderImpl.TAG, "handleAcquire: found pendingRelease(hard), executing deferred. token=" + abilityBinderImpl.token);
                                    pair2 = new Pair(Boolean.TRUE, Boolean.FALSE);
                                } else if (z10) {
                                    AIEngineLogger.w(logModule, abilityBinderImpl.TAG, "handleAcquire: found pendingSoftRelease, executing deferred. token=" + abilityBinderImpl.token);
                                    abilityBinderImpl.isSoftReleased = true;
                                    pair2 = new Pair(Boolean.FALSE, Boolean.TRUE);
                                } else {
                                    Boolean bool = Boolean.FALSE;
                                    pair2 = new Pair(bool, bool);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        boolean zBooleanValue2 = ((Boolean) pair2.f9985a).booleanValue();
                        boolean zBooleanValue3 = ((Boolean) pair2.f9986b).booleanValue();
                        if (zBooleanValue2) {
                            abilityBinderImpl.doRelease(abilityBinderImpl.pendingReleaseReason);
                        } else if (zBooleanValue3) {
                            abilityBinderImpl.doSoftRelease();
                        }
                        boolean z11 = true;
                        if (!zBooleanValue) {
                            if (!ref$BooleanRef.f10073a && !zBooleanValue2 && !zBooleanValue3) {
                                Throwable thLoadFailure = abilityBinderImpl.ability.loadFailure();
                                if (thLoadFailure == null) {
                                    String strLoadError = abilityBinderImpl.ability.loadError();
                                    if (strLoadError == null) {
                                        strLoadError = "acquire returned false";
                                    }
                                    thLoadFailure = new IllegalStateException(strLoadError);
                                }
                                abilityBinderImpl.publishAcquireFailure(thLoadFailure, jElapsedRealtimeNanos, jCurrentTimeMillis);
                            }
                            z11 = true;
                        }
                        if (zBooleanValue == z11) {
                            if (!zBooleanValue2 && !zBooleanValue3 && !abilityBinderImpl.isReleased) {
                                synchronized (this) {
                                    if (abilityBinderImpl.isSoftReleased) {
                                        AIEngineLogger.i(logModule, abilityBinderImpl.TAG, "handleAcquire: SOFT_RELEASED → ACTIVE, token=" + abilityBinderImpl.token);
                                        abilityBinderImpl.isSoftReleased = false;
                                    }
                                }
                            }
                            z11 = true;
                        }
                        if (zBooleanValue == z11 && !abilityBinderImpl.isReleased) {
                            p6.d<?, ?> dVar = abilityBinderImpl.ability;
                            if ((dVar instanceof AsrAbility) || (dVar instanceof AsrRealtimeAbility) || (dVar instanceof SpeechAbility) || (dVar instanceof TtsStreamAbility)) {
                                AccountTokenCache.INSTANCE.prewarm(abilityBinderImpl.abilityScope);
                            }
                        }
                        if (abilityBinderImpl.isReleased) {
                            return false;
                        }
                        return zBooleanValue;
                    } catch (Throwable th2) {
                        th = th2;
                        synchronized (this) {
                            try {
                                abilityBinderImpl.acquireInProgress = false;
                                boolean z12 = abilityBinderImpl.pendingRelease;
                                boolean z13 = abilityBinderImpl.pendingSoftRelease;
                                abilityBinderImpl.pendingRelease = false;
                                abilityBinderImpl.pendingSoftRelease = false;
                                if (z12) {
                                    AIEngineLogger.w(LogModule.ABILITY, abilityBinderImpl.TAG, "handleAcquire: found pendingRelease(hard), executing deferred. token=" + abilityBinderImpl.token);
                                    pair = new Pair(Boolean.TRUE, Boolean.FALSE);
                                } else if (z13) {
                                    AIEngineLogger.w(LogModule.ABILITY, abilityBinderImpl.TAG, str + abilityBinderImpl.token);
                                    abilityBinderImpl.isSoftReleased = true;
                                    pair = new Pair(Boolean.FALSE, Boolean.TRUE);
                                } else {
                                    Boolean bool2 = Boolean.FALSE;
                                    pair = new Pair(bool2, bool2);
                                }
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                        boolean zBooleanValue4 = ((Boolean) pair.f9985a).booleanValue();
                        boolean zBooleanValue5 = ((Boolean) pair.f9986b).booleanValue();
                        if (zBooleanValue4) {
                            abilityBinderImpl.doRelease(abilityBinderImpl.pendingReleaseReason);
                        } else if (zBooleanValue5) {
                            abilityBinderImpl.doSoftRelease();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    abilityBinderImpl = abilityBinderImpl;
                }
            } catch (Throwable th5) {
                th = th5;
                str = "handleAcquire: found pendingSoftRelease, executing deferred. token=";
            }
        }
    }

    public final boolean handleCancel() {
        AIEngineLogger.d(LogModule.ABILITY, this.TAG, "handleCancel: " + this.token);
        try {
            return this.ability.cancel();
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.ABILITY, this.TAG, "handleCancel error: " + this.token, e10);
            return false;
        }
    }

    public final void handleCancelByUser() {
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, a0.a.g("cancelByUser: cancelling ", this.inferJobs.size(), " running inferences, token=", this.token));
        Collection<Job> collectionValues = this.inferJobs.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), null, 1, null);
        }
        this.inferJobs.clear();
        this.inferSlots.clear();
        this.liveInferRegistry.clear();
        drainLocalStreamCounts();
        AsrRealtimeBinderCoordinator asrRealtimeCoordinator = getAsrRealtimeCoordinator();
        if (asrRealtimeCoordinator != null) {
            asrRealtimeCoordinator.cancelAll();
        }
        TtsStreamBinderCoordinator ttsStreamCoordinator = getTtsStreamCoordinator();
        if (ttsStreamCoordinator != null) {
            ttsStreamCoordinator.cancelAll();
        }
        AsrPcmDumpSink asrSsePcmDumpSink = getAsrSsePcmDumpSink();
        if (asrSsePcmDumpSink != null) {
            asrSsePcmDumpSink.closeAll();
        }
        this.ability.cancel();
    }

    public final boolean handleCancelInfer(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        TtsStreamBinderCoordinator ttsStreamCoordinator = getTtsStreamCoordinator();
        if (ttsStreamCoordinator != null && ttsStreamCoordinator.tryHandleCancelInfer(inferId)) {
            return true;
        }
        AsrRealtimeBinderCoordinator asrRealtimeCoordinator = getAsrRealtimeCoordinator();
        if (asrRealtimeCoordinator != null && asrRealtimeCoordinator.tryHandleCancelInfer(inferId)) {
            return true;
        }
        p6.d<?, ?> dVar = this.ability;
        AsrSseAbility asrSseAbility = dVar instanceof AsrSseAbility ? (AsrSseAbility) dVar : null;
        if (asrSseAbility != null) {
            asrSseAbility.closeStreamPcmDump(inferId);
        } else {
            AsrPcmDumpSink asrSsePcmDumpSink = getAsrSsePcmDumpSink();
            if (asrSsePcmDumpSink != null) {
                asrSsePcmDumpSink.close(inferId);
            }
        }
        Job jobRemove = this.inferJobs.remove(inferId);
        releaseInferSlot(inferId);
        if (jobRemove == null) {
            AIEngineLogger.w(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("cancelInfer: inferId=", inferId, " not found, token=", this.token));
            return false;
        }
        Job.DefaultImpls.cancel$default(jobRemove, null, 1, null);
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("cancelInfer: cancelled inferId=", inferId, ", token=", this.token));
        return true;
    }

    public final void handleCompleteInput(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        if (this.isReleased) {
            AIEngineLogger.w(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("[DIAG] closeChannel: dropped (binder released), inferId=", inferId, ", token=", this.token));
            return;
        }
        TtsStreamBinderCoordinator ttsStreamCoordinator = getTtsStreamCoordinator();
        if (ttsStreamCoordinator != null && ttsStreamCoordinator.tryHandleCompleteInput(inferId)) {
            AIEngineLogger.d(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("handleCompleteInput: TTS stream finalize, inferId=", inferId, ", token=", this.token));
            return;
        }
        AsrRealtimeBinderCoordinator asrRealtimeCoordinator = getAsrRealtimeCoordinator();
        if (asrRealtimeCoordinator == null || !asrRealtimeCoordinator.tryHandleCompleteInput(inferId)) {
            AIEngineLogger.d(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("handleCompleteInput: inferId=", inferId, ", token=", this.token));
            try {
                this.ability.completeInput(inferId);
            } catch (UnsupportedOperationException unused) {
                ai.onnxruntime.a.w("handleCompleteInput: not supported. token=", this.token, LogModule.ABILITY, this.TAG);
            } catch (Exception e10) {
                AIEngineLogger.e(LogModule.ABILITY, this.TAG, "handleCompleteInput error: token=" + this.token, e10);
            }
        }
    }

    public final IChatSession handleCreateSession() {
        ChatSessionImpl chatSessionImpl = new ChatSessionImpl(this.abilityId, this.callerUid, this.callerPid, new AbilityBinderImpl$handleCreateSession$session$1(this));
        SessionRegistry.INSTANCE.register(chatSessionImpl);
        LogModule logModule = LogModule.ABILITY;
        String str = this.TAG;
        String sessionId = chatSessionImpl.getSessionId();
        String str2 = this.abilityId;
        a0.a.z(ai.onnxruntime.a.s("Created session: ", sessionId, ", abilityId=", str2, ", token="), this.token, logModule, str);
        return chatSessionImpl;
    }

    public final Content handleExecute(String action, Content content) {
        Object objA;
        Object objA2;
        ModelCacheImpl modelCacheImpl;
        String text;
        kotlin.jvm.internal.g.f(action, "action");
        lD0 = null;
        Long lD0 = null;
        if (this.isReleased) {
            AIEngineLogger.w(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("handleExecute: already released. token=", this.token, ", action=", action));
            return null;
        }
        LogModule logModule = LogModule.ABILITY;
        AIEngineLogger.d(logModule, this.TAG, ai.onnxruntime.a.l("handleExecute: action=", action, ", token=", this.token));
        if (action.equals(ACTION_SET_IDLE_TIMEOUT)) {
            TextContent textContent = content instanceof TextContent ? (TextContent) content : null;
            if (textContent != null && (text = textContent.getText()) != null) {
                lD0 = gc.n.d0(text);
            }
            if (lD0 == null) {
                AIEngineLogger.w(logModule, this.TAG, a0.a.h("setIdleTimeout: invalid value, keep idleDelayMs=", this.idleDelayMs, ". token=", this.token));
                return new TextContent(com.stepos.core.ota.d.f(this.idleDelayMs, "idleTimeout="));
            }
            long jB0 = dc.h.b0(lD0.longValue(), 3000L, IDLE_TIMEOUT_MAX_MS);
            if (jB0 != lD0.longValue()) {
                AIEngineLogger.w(logModule, this.TAG, "setIdleTimeout: " + lD0 + " out of [3000,600000], clamped=" + jB0 + ". token=" + this.token);
            }
            this.idleDelayMs = jB0;
            AIEngineLogger.i(logModule, this.TAG, a0.a.h("setIdleTimeout: idleDelayMs=", jB0, ". token=", this.token));
            return new TextContent(com.stepos.core.ota.d.f(jB0, "idleTimeout="));
        }
        if (!action.equals(ACTION_QUERY_IDLE_STATE)) {
            try {
                Object objExecute = this.ability.execute(action, content);
                if (objExecute instanceof Content) {
                    return (Content) objExecute;
                }
            } catch (UnsupportedOperationException unused) {
                AIEngineLogger.w(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("handleExecute: action '", action, "' not supported. token=", this.token));
            } catch (Exception e10) {
                AIEngineLogger.e(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("handleExecute error: token=", this.token, ", action=", action), e10);
            }
            return null;
        }
        try {
            objA = Boolean.valueOf(this.ability.isModelHeld());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Boolean bool = Boolean.FALSE;
        boolean z = objA instanceof Result.Failure;
        Object obj = objA;
        if (z) {
            obj = bool;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        try {
            k kVar = (k) kotlin.collections.a.v0(this.ability.getAbilityConfig().f11419d);
            String str = kVar != null ? kVar.f3090a : null;
            objA2 = Integer.valueOf((str == null || (modelCacheImpl = j.f3087b) == null) ? -1 : modelCacheImpl.getRefCount(str));
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        boolean z3 = objA2 instanceof Result.Failure;
        Object obj2 = objA2;
        if (z3) {
            obj2 = -1;
        }
        int iIntValue = ((Number) obj2).intValue();
        StringBuilder sbO = a0.a.o("idleTimeoutMs=", this.idleDelayMs, ";clientState=", this.clientState.name());
        sbO.append(";modelHeld=");
        sbO.append(zBooleanValue);
        sbO.append(";refCount=");
        sbO.append(iIntValue);
        return new TextContent(sbO.toString());
    }

    public final void handleFeedInput(String inferId, Content input) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        if (this.isReleased) {
            return;
        }
        TtsStreamBinderCoordinator ttsStreamCoordinator = getTtsStreamCoordinator();
        if (ttsStreamCoordinator == null || !ttsStreamCoordinator.tryHandleFeedInput(inferId, input)) {
            AsrRealtimeBinderCoordinator asrRealtimeCoordinator = getAsrRealtimeCoordinator();
            if (asrRealtimeCoordinator == null || !asrRealtimeCoordinator.tryHandleFeedInput(inferId, input)) {
                AsrPcmDumpSink asrSsePcmDumpSink = getAsrSsePcmDumpSink();
                if (asrSsePcmDumpSink != null) {
                    p6.d<?, ?> dVar = this.ability;
                    AsrSseAbility asrSseAbility = dVar instanceof AsrSseAbility ? (AsrSseAbility) dVar : null;
                    if (asrSseAbility != null) {
                        asrSseAbility.bindStreamPcmDump(inferId, asrSsePcmDumpSink);
                    }
                }
                try {
                    this.ability.onFeedInput(inferId, input);
                } catch (UnsupportedOperationException unused) {
                    ai.onnxruntime.a.w("handleFeedInput: not supported. token=", this.token, LogModule.ABILITY, this.TAG);
                } catch (Exception e10) {
                    AIEngineLogger.e(LogModule.ABILITY, this.TAG, "handleFeedInput error: token=" + this.token, e10);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleInfer(java.lang.String r74, com.stepos.core.data.base.Content r75, com.stepos.core.callback.IInferenceCallback r76) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1159
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityBinderImpl.handleInfer(java.lang.String, com.stepos.core.data.base.Content, com.stepos.core.callback.IInferenceCallback):void");
    }

    public final void handlePreload(IBoolCallback iBoolCallback) {
        BuildersKt__Builders_commonKt.launch$default(this.abilityScope, null, null, new C02901(iBoolCallback, null), 3, null);
    }

    public final void handleRegisterReleaseCallback(IReleaseCallback iReleaseCallback, int i10) {
        if (iReleaseCallback == null) {
            AIEngineLogger.i(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.i("registerReleaseCallback(null): token=", i10, this.token, " uid=", "; cleanup relies on linkToDeath"));
        } else {
            d6.c.f8388a.b(iReleaseCallback, i10);
            AIEngineLogger.i(LogModule.ABILITY, this.TAG, com.stepos.core.ota.d.h("registerReleaseCallback: token=", i10, this.token, " uid="));
        }
    }

    public final void handleUnregisterReleaseCallback(int i10) {
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.i("unregisterReleaseCallback: token=", i10, this.token, " uid=", "; cleanup relies on linkToDeath"));
    }

    public final boolean isBusy() {
        return this.activeInferences.get() > 0;
    }

    public final boolean isHardReleased() {
        boolean z;
        synchronized (this) {
            z = this.isReleased;
        }
        return z;
    }

    @Override // com.stepos.core.ability.deepbinder.InferRecycleGate
    public void onInferStart(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        this.liveInferRegistry.onInferStart(inferId);
    }

    @Override // com.stepos.core.ability.deepbinder.InferRecycleGate
    public boolean onInferTerminal(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        boolean zOnInferTerminal = this.liveInferRegistry.onInferTerminal(inferId);
        if (zOnInferTerminal) {
            if (this.pendingHardReleaseAfterDrain) {
                this.pendingHardReleaseAfterDrain = false;
                h0.e.k("onInferTerminal: binder drained, running deferred HARD release. token=", this.token, LogModule.ABILITY, this.TAG);
                BuildersKt__Builders_commonKt.launch$default(this.abilityScope, Dispatchers.getIO(), null, new C02911(null), 2, null);
                return zOnInferTerminal;
            }
            if (this.pendingSoftReleaseAfterDrain) {
                this.pendingSoftReleaseAfterDrain = false;
                BuildersKt__Builders_commonKt.launch$default(this.abilityScope, null, null, new AnonymousClass2(null), 3, null);
            }
        }
        return zOnInferTerminal;
    }

    @Override // com.stepos.core.ability.IAbilityBinder
    public void releaseBinder() {
        releaseBinder$default(this, true, false, null, 4, null);
    }

    public final void submitInferAsync(String inferId, Content input, IInferenceCallback iInferenceCallback, CallerData callerData) {
        kotlin.coroutines.d dVarAsContextElement;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        if (isHardReleased()) {
            AIEngineLogger.w(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("submitInferAsync: binder hard-released before dispatch, error to client. token=", this.token, ", inferId=", inferId));
            if (iInferenceCallback != null) {
                new BinderResultHandler(iInferenceCallback).onResult(inferId, new InferResult.Error(AIEngineError.ALREADY_CLOSED, "binder released before dispatch"));
                return;
            }
            return;
        }
        if (callerData == null || (dVarAsContextElement = ThreadContextElementKt.asContextElement(y9.a.f14176c.a().f14179b, callerData)) == null) {
            dVarAsContextElement = EmptyCoroutineContext.f10057a;
        }
        BuildersKt__Builders_commonKt.launch$default(this.abilityScope, dVarAsContextElement, null, new C02932(inferId, input, iInferenceCallback, null), 2, null);
    }

    public final void releaseBinder(boolean z, boolean z3, ModelReleaseReason reason) {
        kotlin.jvm.internal.g.f(reason, "reason");
        if (z) {
            doHardReleaseFlow(z3, reason);
        } else {
            doSoftReleaseFlow();
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ AbilityBinderImpl(java.lang.String r2, p6.d r3, com.stepos.core.ability.executor.IInferenceExecutor r4, int r5, int r6, int r7, kotlin.jvm.internal.e r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto Lc
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
        Lc:
            r8 = r7 & 4
            if (r8 == 0) goto L15
            com.stepos.core.ability.executor.InferenceExecutor r4 = new com.stepos.core.ability.executor.InferenceExecutor
            r4.<init>(r3)
        L15:
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L1b
            r5 = r0
        L1b:
            r7 = r7 & 16
            if (r7 == 0) goto L26
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L2c
        L26:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L2c:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityBinderImpl.<init>(java.lang.String, p6.d, com.stepos.core.ability.executor.IInferenceExecutor, int, int, int, kotlin.jvm.internal.e):void");
    }
}
