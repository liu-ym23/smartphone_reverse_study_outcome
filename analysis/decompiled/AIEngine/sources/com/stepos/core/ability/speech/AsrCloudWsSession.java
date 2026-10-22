package com.stepos.core.ability.speech;

import android.os.SystemClock;
import android.os.Trace;
import android.util.Base64;
import com.stepos.base.health.EngineMetrics;
import com.stepos.core.ability.speech.AsrStreamReconnectPolicy;
import com.stepos.core.ability.speech.AsrWsModels;
import com.stepos.core.ability.speech.AsrWsPendingBuffer;
import com.stepos.core.ability.speech.debug.AsrStreamDebugInjector;
import com.stepos.core.common.cloud.AuthHeaderResult;
import com.stepos.core.common.cloud.CloudConfigBootstrap;
import com.stepos.core.common.cloud.CloudCorrelationSource;
import com.stepos.core.common.cloud.CloudErrorUserMessage;
import com.stepos.core.common.cloud.CloudHttpErrorMapper;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.cloud.CloudTransportConfig;
import com.stepos.core.common.cloud.CloudWebSocketClient;
import com.stepos.core.common.cloud.ObservableCloudSession;
import com.stepos.core.common.debug.DebugInjectionGate;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogConfig;
import com.stepos.core.common.log.LogLevel;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.error.AIEngineError;
import i7.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrCloudWsSession implements ObservableCloudSession {
    public static final int BYTES_PER_SAMPLE = 2;
    public static final Companion Companion = new Companion(null);
    public static final int FEED_DIAG_WINDOW_CHUNKS = 16;
    public static final int FLUSH_BATCH_FRAMES = 32;
    public static final long MAX_RECONNECT_FLUSH_AUDIO_MS = 8000;
    public static final long NETWORK_WAKE_SETTLE_MS = 500;
    public static final int PCM_FULL_SCALE = 32767;
    public static final int SAMPLE_RATE_HZ = 16000;
    public static final int SILENCE_CHUNK_MS = 100;
    public static final int SILENCE_TAIL_MARGIN_MS = 400;
    private final String TAG;
    private final MutableSharedFlow<i7.c> _events;
    private final AtomicLong appendIndex;
    private final AtomicBoolean audioPendingResult;
    private final AtomicBoolean awaitingPostCommitCompleted;
    private final String businessTraceId;
    private final CompletableDeferred<lb.n> closeAck;
    private final AtomicBoolean closed;
    private final AsrCloudConfig config;
    private int connectAttempt;
    private volatile long connectStartedAtMs;
    private volatile long connectToOpenMs;
    private volatile CloudSessionCorrelationState correlationState;
    private volatile String currentTraceId;
    private final AsrCumulativeDeltaTracker deltaTracker;
    private final AtomicBoolean endOfTurnEmitted;
    private final Flow<i7.c> events;
    private long feedBytesInWindow;
    private int feedChunkCount;
    private int feedPeakInWindow;
    private final AtomicBoolean finishRequested;
    private final AtomicBoolean finishing;
    private volatile String gatewayTraceId;
    private final AtomicInteger generation;
    private final HandshakeProgress handshake;
    private volatile long headerFetchMs;
    private final zb.l<qb.b<? super AuthHeaderResult>, Object> headerProvider;
    private final AtomicInteger lastClientSeq;
    private volatile Integer lastCloseCode;
    private volatile Integer lastFailureCode;
    private volatile Integer lastFailureHttpCode;
    private long lastLinkParkMs;
    private long lastPartialEndMs;
    private long lastPartialStartMs;
    private long lastReconnectDelayMs;
    private volatile long lastRetryAfterMs;
    private volatile String lastSessionId;
    private final Object lock;
    private final zb.a<lb.n> onAuthFailed;
    private zb.l<? super CloudSessionCorrelationState, lb.n> onCorrelationEstablished;
    private final AsrWsPendingBuffer pending;
    private final boolean plainTranscriptLog;
    private final AtomicBoolean producedResult;
    private volatile AsrStreamReconnectPolicy.RiskBlockedRecovery riskBlockedRecovery;
    private final CoroutineScope scope;
    private final AtomicBoolean segmentInProgress;
    private volatile CloudWebSocketClient.Session session;
    private volatile long sessionCreatedAtMs;
    private volatile long sessionUpdatedAtMs;
    private final AsrStreamTimelineMapper timeline;
    private final AtomicLong totalPcmBytesFed;
    private final CloudTransportConfig transport;
    private volatile long wsOpenedAtMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final boolean mayCollapseBackoff(Integer num, Integer num2, long j10, boolean z) {
            if (num != null && num.intValue() == 1013) {
                return false;
            }
            return (num2 == null || num2.intValue() != 429) && j10 <= 0 && !z;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface FlushStep {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Abandon implements FlushStep {
            public static final Abandon INSTANCE = new Abandon();

            private Abandon() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Abandon);
            }

            public int hashCode() {
                return 2023243556;
            }

            public String toString() {
                return "Abandon";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Batch implements FlushStep {
            private final AsrWsPendingBuffer.DrainResult batch;
            private final CloudWebSocketClient.Session target;

            public Batch(CloudWebSocketClient.Session target, AsrWsPendingBuffer.DrainResult batch) {
                kotlin.jvm.internal.g.f(target, "target");
                kotlin.jvm.internal.g.f(batch, "batch");
                this.target = target;
                this.batch = batch;
            }

            public final AsrWsPendingBuffer.DrainResult getBatch() {
                return this.batch;
            }

            public final CloudWebSocketClient.Session getTarget() {
                return this.target;
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Drained implements FlushStep {
            public static final Drained INSTANCE = new Drained();

            private Drained() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Drained);
            }

            public int hashCode() {
                return 848714054;
            }

            public String toString() {
                return "Drained";
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class HandshakeProgress {
        private final AtomicBoolean gateOpen = new AtomicBoolean(false);
        private final AtomicBoolean readyThisGen = new AtomicBoolean(false);
        private final AtomicBoolean everReady = new AtomicBoolean(false);
        private final AtomicBoolean everOpened = new AtomicBoolean(false);

        public final void beginGeneration() {
            this.readyThisGen.set(false);
        }

        public final void closeGate() {
            this.gateOpen.set(false);
        }

        public final boolean getWasEverOpened() {
            return this.everOpened.get();
        }

        public final boolean getWasEverReady() {
            return this.everReady.get();
        }

        public final boolean getWasReadyThisGeneration() {
            return this.readyThisGen.get();
        }

        public final boolean isGateOpen() {
            return this.gateOpen.get();
        }

        public final void markOpened() {
            this.everOpened.set(true);
        }

        public final void markReady() {
            this.gateOpen.set(true);
            this.readyThisGen.set(true);
            this.everReady.set(true);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudWsSession$armHandshakeWatchdog$1", f = "AsrCloudWsSession.kt", l = {565}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudWsSession$armHandshakeWatchdog$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ int $gen;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i10, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$gen = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = AsrCloudWsSession.this.new AnonymousClass1(this.$gen, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                long wsHandshakeTimeoutMs = AsrCloudWsSession.this.transport.getWatchdog().getWsHandshakeTimeoutMs();
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(wsHandshakeTimeoutMs, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            if (AsrCloudWsSession.this.closed.get() || this.$gen != AsrCloudWsSession.this.generation.get() || AsrCloudWsSession.this.handshake.isGateOpen()) {
                return lb.n.f10413a;
            }
            LogModule logModule = LogModule.ABILITY;
            String str = AsrCloudWsSession.this.TAG;
            long wsHandshakeTimeoutMs2 = AsrCloudWsSession.this.transport.getWatchdog().getWsHandshakeTimeoutMs();
            String str2 = AsrCloudWsSession.this.currentTraceId;
            String str3 = AsrCloudWsSession.this.lastSessionId;
            StringBuilder sbO = a0.a.o("[ASR-Stream] ws handshake timeout (", wsHandshakeTimeoutMs2, "ms), cancel hung connection & recover, x-trace-id=", str2);
            sbO.append(", session_id=");
            sbO.append(str3);
            AIEngineLogger.w(logModule, str, sbO.toString());
            AsrCloudWsSession.this.generation.incrementAndGet();
            try {
                CloudWebSocketClient.Session session = AsrCloudWsSession.this.session;
                if (session != null) {
                    session.cancel();
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            AsrCloudWsSession.recoverOrFail$default(AsrCloudWsSession.this, AIEngineError.CLOUD_NETWORK_UNAVAILABLE, "ws handshake timeout", null, 4, null);
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudWsSession", f = "AsrCloudWsSession.kt", l = {1356, 1357}, m = "awaitLinkRestored")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudWsSession$awaitLinkRestored$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03021 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        public C03021(qb.b<? super C03021> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrCloudWsSession.this.awaitLinkRestored(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudWsSession", f = "AsrCloudWsSession.kt", l = {877}, m = "awaitOpened")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudWsSession$awaitOpened$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03031 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03031(qb.b<? super C03031> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrCloudWsSession.this.awaitOpened(0L, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudWsSession", f = "AsrCloudWsSession.kt", l = {1390, 1396, 1397, 1399}, m = "awaitReconnectBackoff")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudWsSession$awaitReconnectBackoff$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03041 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03041(qb.b<? super C03041> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrCloudWsSession.this.awaitReconnectBackoff(0L, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudWsSession$awaitReconnectBackoff$2", f = "AsrCloudWsSession.kt", l = {1396}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudWsSession$awaitReconnectBackoff$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        int label;

        public AnonymousClass2(qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass2(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CloudNetworkWatcher cloudNetworkWatcher = CloudNetworkWatcher.INSTANCE;
                this.label = 1;
                if (cloudNetworkWatcher.awaitValidated(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudWsSession", f = "AsrCloudWsSession.kt", l = {962}, m = "closeAndAwait")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudWsSession$closeAndAwait$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03051 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03051(qb.b<? super C03051> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrCloudWsSession.this.closeAndAwait(0L, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudWsSession", f = "AsrCloudWsSession.kt", l = {511}, m = "doConnect")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudWsSession$doConnect$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03061 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03061(qb.b<? super C03061> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrCloudWsSession.this.doConnect(0, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudWsSession$launchConnect$1", f = "AsrCloudWsSession.kt", l = {503}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudWsSession$launchConnect$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03071 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ int $gen;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03071(int i10, qb.b<? super C03071> bVar) {
            super(2, bVar);
            this.$gen = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return AsrCloudWsSession.this.new C03071(this.$gen, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                AsrCloudWsSession asrCloudWsSession = AsrCloudWsSession.this;
                int i11 = this.$gen;
                this.label = 1;
                if (asrCloudWsSession.doConnect(i11, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03071) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudWsSession$reconnect$3", f = "AsrCloudWsSession.kt", l = {1316, 1316, 1322}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudWsSession$reconnect$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ long $delayMs;
        final /* synthetic */ Ref$IntRef $gen;
        final /* synthetic */ boolean $linkDown;
        int label;
        final /* synthetic */ AsrCloudWsSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(boolean z, AsrCloudWsSession asrCloudWsSession, long j10, Ref$IntRef ref$IntRef, qb.b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$linkDown = z;
            this.this$0 = asrCloudWsSession;
            this.$delayMs = j10;
            this.$gen = ref$IntRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass3(this.$linkDown, this.this$0, this.$delayMs, this.$gen, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        
            if (r10 == r0) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
        
            if (r10.awaitReconnectBackoff(r4, r9) == r0) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00aa, code lost:
        
            if (r10.doConnect(r1, r9) == r0) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L24
                if (r1 == r4) goto L20
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                kotlin.c.b(r10)
                goto Lad
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1c:
                kotlin.c.b(r10)
                goto L4b
            L20:
                kotlin.c.b(r10)
                goto L37
            L24:
                kotlin.c.b(r10)
                boolean r10 = r9.$linkDown
                if (r10 == 0) goto L3e
                com.stepos.core.ability.speech.AsrCloudWsSession r10 = r9.this$0
                r9.label = r4
                java.lang.Object r10 = com.stepos.core.ability.speech.AsrCloudWsSession.access$awaitLinkRestored(r10, r9)
                if (r10 != r0) goto L37
                goto Lac
            L37:
                java.lang.Number r10 = (java.lang.Number) r10
                long r3 = r10.longValue()
                goto L4d
            L3e:
                com.stepos.core.ability.speech.AsrCloudWsSession r10 = r9.this$0
                long r4 = r9.$delayMs
                r9.label = r3
                java.lang.Object r10 = com.stepos.core.ability.speech.AsrCloudWsSession.access$awaitReconnectBackoff(r10, r4, r9)
                if (r10 != r0) goto L4b
                goto Lac
            L4b:
                long r3 = r9.$delayMs
            L4d:
                com.stepos.core.ability.speech.AsrCloudWsSession r10 = r9.this$0
                java.util.concurrent.atomic.AtomicBoolean r10 = com.stepos.core.ability.speech.AsrCloudWsSession.access$getClosed$p(r10)
                boolean r10 = r10.get()
                if (r10 != 0) goto Lb0
                kotlin.jvm.internal.Ref$IntRef r10 = r9.$gen
                int r10 = r10.f10074a
                com.stepos.core.ability.speech.AsrCloudWsSession r1 = r9.this$0
                java.util.concurrent.atomic.AtomicInteger r1 = com.stepos.core.ability.speech.AsrCloudWsSession.access$getGeneration$p(r1)
                int r1 = r1.get()
                if (r10 == r1) goto L6a
                goto Lb0
            L6a:
                boolean r10 = r9.$linkDown
                if (r10 == 0) goto L73
                com.stepos.core.ability.speech.AsrCloudWsSession r10 = r9.this$0
                com.stepos.core.ability.speech.AsrCloudWsSession.access$recordLinkPark(r10, r3)
            L73:
                com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.ABILITY
                com.stepos.core.ability.speech.AsrCloudWsSession r1 = r9.this$0
                java.lang.String r1 = com.stepos.core.ability.speech.AsrCloudWsSession.access$getTAG$p(r1)
                com.stepos.core.ability.speech.AsrCloudWsSession r5 = r9.this$0
                java.lang.String r5 = com.stepos.core.ability.speech.AsrCloudWsSession.access$getCurrentTraceId$p(r5)
                com.stepos.core.ability.speech.AsrCloudWsSession r6 = r9.this$0
                java.lang.String r6 = com.stepos.core.ability.speech.AsrCloudWsSession.access$getLastSessionId$p(r6)
                java.lang.String r7 = "[ASR-Stream] reconnecting ws (after "
                java.lang.String r8 = "ms), prev x-trace-id="
                java.lang.StringBuilder r3 = a0.a.o(r7, r3, r8, r5)
                java.lang.String r4 = ", prev session_id="
                r3.append(r4)
                r3.append(r6)
                java.lang.String r3 = r3.toString()
                com.stepos.core.common.log.AIEngineLogger.i(r10, r1, r3)
                com.stepos.core.ability.speech.AsrCloudWsSession r10 = r9.this$0
                kotlin.jvm.internal.Ref$IntRef r1 = r9.$gen
                int r1 = r1.f10074a
                r9.label = r2
                java.lang.Object r9 = com.stepos.core.ability.speech.AsrCloudWsSession.access$doConnect(r10, r1, r9)
                if (r9 != r0) goto Lad
            Lac:
                return r0
            Lad:
                lb.n r9 = lb.n.f10413a
                return r9
            Lb0:
                lb.n r9 = lb.n.f10413a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrCloudWsSession.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass3) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsrCloudWsSession(AsrCloudConfig config, zb.l<? super qb.b<? super AuthHeaderResult>, ? extends Object> headerProvider, zb.a<lb.n> onAuthFailed, String str) {
        kotlin.jvm.internal.g.f(config, "config");
        kotlin.jvm.internal.g.f(headerProvider, "headerProvider");
        kotlin.jvm.internal.g.f(onAuthFailed, "onAuthFailed");
        this.config = config;
        this.headerProvider = headerProvider;
        this.onAuthFailed = onAuthFailed;
        this.businessTraceId = str;
        this.TAG = "AsrCloudWsSession";
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        CloudTransportConfig cloudTransportConfig = CloudConfigBootstrap.INSTANCE.get();
        this.transport = cloudTransportConfig;
        this.plainTranscriptLog = AsrTranscriptLog.INSTANCE.isEnabled();
        MutableSharedFlow<i7.c> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, cloudTransportConfig.getBackpressure().getDownstreamBufferSize(), BufferOverflow.DROP_OLDEST);
        this._events = MutableSharedFlow;
        this.events = MutableSharedFlow;
        this.closed = new AtomicBoolean(false);
        this.finishRequested = new AtomicBoolean(false);
        this.handshake = new HandshakeProgress();
        this.finishing = new AtomicBoolean(false);
        this.awaitingPostCommitCompleted = new AtomicBoolean(false);
        this.endOfTurnEmitted = new AtomicBoolean(false);
        this.closeAck = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.segmentInProgress = new AtomicBoolean(false);
        this.audioPendingResult = new AtomicBoolean(false);
        this.producedResult = new AtomicBoolean(false);
        this.deltaTracker = new AsrCumulativeDeltaTracker();
        this.totalPcmBytesFed = new AtomicLong(0L);
        this.appendIndex = new AtomicLong(0L);
        this.lastClientSeq = new AtomicInteger(-1);
        this.timeline = AsrStreamTimelineMapper.Companion.forPcm16kMono();
        this.pending = new AsrWsPendingBuffer(cloudTransportConfig.getBackpressure().getUplinkQueueLimitBytes());
        this.lock = new Object();
        this.lastSessionId = "";
        this.currentTraceId = "";
        this.gatewayTraceId = "";
        this.correlationState = new CloudSessionCorrelationState(null, null, null, null, 0, null, 0L, 0L, 0L, 0L, 1023, null);
        this.generation = new AtomicInteger(0);
        this.headerFetchMs = -1L;
        this.connectToOpenMs = -1L;
        this.lastReconnectDelayMs = -1L;
        this.lastLinkParkMs = -1L;
        this.riskBlockedRecovery = new AsrStreamReconnectPolicy.RiskBlockedRecovery(false, false, 3, null);
    }

    private final void armHandshakeWatchdog(int i10) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(i10, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(500, r0) != r9) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e A[PHI: r4
      0x004e: PHI (r4v1 long) = (r4v2 long), (r4v4 long) binds: [B:18:0x004b, B:15:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0058 -> B:23:0x005b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitLinkRestored(qb.b<? super java.lang.Long> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.stepos.core.ability.speech.AsrCloudWsSession.C03021
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.core.ability.speech.AsrCloudWsSession$awaitLinkRestored$1 r0 = (com.stepos.core.ability.speech.AsrCloudWsSession.C03021) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.AsrCloudWsSession$awaitLinkRestored$1 r0 = new com.stepos.core.ability.speech.AsrCloudWsSession$awaitLinkRestored$1
            r0.<init>(r9)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2c
            long r4 = r0.J$0
            kotlin.c.b(r8)
            goto L5b
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            long r4 = r0.J$0
            kotlin.c.b(r8)
            goto L4e
        L3a:
            kotlin.c.b(r8)
            long r4 = android.os.SystemClock.elapsedRealtimeNanos()
        L41:
            com.stepos.core.ability.speech.CloudNetworkWatcher r8 = com.stepos.core.ability.speech.CloudNetworkWatcher.INSTANCE
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r8 = r8.awaitHasInternet(r0)
            if (r8 != r9) goto L4e
            goto L5a
        L4e:
            r0.J$0 = r4
            r0.label = r2
            r6 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r6, r0)
            if (r8 != r9) goto L5b
        L5a:
            return r9
        L5b:
            com.stepos.core.ability.speech.CloudNetworkWatcher r8 = com.stepos.core.ability.speech.CloudNetworkWatcher.INSTANCE
            boolean r8 = r8.isLinkDown()
            if (r8 != 0) goto L41
            long r8 = android.os.SystemClock.elapsedRealtimeNanos()
            long r8 = r8 - r4
            r0 = 1000000(0xf4240, float:1.401298E-39)
            long r0 = (long) r0
            long r8 = r8 / r0
            java.lang.Long r0 = new java.lang.Long
            r0.<init>(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrCloudWsSession.awaitLinkRestored(qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r1, r4) == r5) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e0, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r0, r4) == r5) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitReconnectBackoff(long r21, qb.b<? super lb.n> r23) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrCloudWsSession.awaitReconnectBackoff(long, qb.b):java.lang.Object");
    }

    private static final long awaitReconnectBackoff$remainingMs(long j10, long j11) {
        long jAwaitReconnectBackoff$waitedMs = j10 - awaitReconnectBackoff$waitedMs(j11);
        if (jAwaitReconnectBackoff$waitedMs < 0) {
            return 0L;
        }
        return jAwaitReconnectBackoff$waitedMs;
    }

    private static final long awaitReconnectBackoff$waitedMs(long j10) {
        return (SystemClock.elapsedRealtimeNanos() - j10) / 1000000;
    }

    private final List<String> buildSilenceFrames() {
        int iStreamVadSilenceMs = (this.config.streamVadSilenceMs() + 499) / 100;
        String strEncodeToString = Base64.encodeToString(new byte[silenceBytesPerChunk()], 2);
        AsrWsModels asrWsModels = AsrWsModels.INSTANCE;
        kotlin.jvm.internal.g.c(strEncodeToString);
        String strBuildAppend = asrWsModels.buildAppend(strEncodeToString);
        ArrayList arrayList = new ArrayList(iStreamVadSilenceMs);
        for (int i10 = 0; i10 < iStreamVadSilenceMs; i10++) {
            arrayList.add(strBuildAppend);
        }
        return arrayList;
    }

    private final long computeBackoffMs(int i10) {
        Integer num;
        CloudTransportConfig.Resilience resilience = this.transport.getResilience();
        Integer num2 = this.lastCloseCode;
        return Math.max(ThreadLocalRandom.current().nextLong(0L, Math.min(resilience.getReconnectCapMs(), (((num2 != null && num2.intValue() == 1013) || ((num = this.lastFailureHttpCode) != null && num.intValue() == 429)) ? resilience.getReconnectRateLimitedBaseMs() : resilience.getReconnectBaseMs()) << dc.h.a0(i10, 0, 30)) + 1), this.lastRetryAfterMs);
    }

    private final void diagFeedEnergy(byte[] bArr) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = i10 + 1;
            if (i12 >= bArr.length) {
                break;
            }
            int i13 = (short) ((bArr[i12] << 8) | (bArr[i10] & 255));
            if (i13 < 0) {
                i13 = -i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
            i10 += 2;
        }
        synchronized (this.lock) {
            try {
                if (i11 > this.feedPeakInWindow) {
                    this.feedPeakInWindow = i11;
                }
                long length = this.feedBytesInWindow + bArr.length;
                this.feedBytesInWindow = length;
                int i14 = this.feedChunkCount + 1;
                this.feedChunkCount = i14;
                if (i14 < 16) {
                    return;
                }
                int i15 = this.feedPeakInWindow;
                int i16 = (i15 * 100) / PCM_FULL_SCALE;
                AIEngineLogger.i(LogModule.ABILITY, this.TAG, "[ASR-Stream] uplink energy: chunks=" + i14 + " bytes=" + length + " peak=" + i15 + " (" + i16 + "%)");
                this.feedChunkCount = 0;
                this.feedPeakInWindow = 0;
                this.feedBytesInWindow = 0L;
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doConnect(int r12, qb.b<? super lb.n> r13) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrCloudWsSession.doConnect(int, qb.b):java.lang.Object");
    }

    private final void emitEndOfTurn() {
        if (this.endOfTurnEmitted.compareAndSet(false, true)) {
            this._events.tryEmit(c.a.f9553a);
        }
    }

    private final void emitFailure(int i10, String str) {
        LogModule logModule = LogModule.ABILITY;
        String str2 = this.TAG;
        String str3 = this.currentTraceId;
        AIEngineLogger.e(logModule, str2, ai.onnxruntime.a.p(h0.e.f("[ASR-Stream] terminal failure: x-trace-id=", str3, ", code=", i10, ", session_id="), this.lastSessionId, ", ", str));
        emitTerminalFailure(i10);
    }

    private final void emitRecoverableNotice(int i10, String str) {
        String strCurrentSegmentText = this.deltaTracker.currentSegmentText();
        this._events.tryEmit(new c.d(str, strCurrentSegmentText, i10, strCurrentSegmentText.length() > 0 ? this.lastPartialStartMs : 0L, strCurrentSegmentText.length() > 0 ? this.lastPartialEndMs : 0L));
    }

    private final void emitTerminalFailure(int i10) {
        int iNormalizeTerminalCode = normalizeTerminalCode(i10);
        this._events.tryEmit(new c.b(iNormalizeTerminalCode, CloudErrorUserMessage.INSTANCE.of(iNormalizeTerminalCode)));
    }

    private final void enqueuePending(String str, int i10) {
        AsrWsPendingBuffer.EnqueueResult enqueueResultEnqueue = this.pending.enqueue(str, i10);
        if (enqueueResultEnqueue.getDroppedFrames() > 0) {
            AtomicLong atomicLong = EngineMetrics.f6226a;
            EngineMetrics.L.addAndGet(enqueueResultEnqueue.getDroppedFrames());
            LogModule logModule = LogModule.ABILITY;
            String str2 = this.TAG;
            long uplinkQueueLimitBytes = this.transport.getBackpressure().getUplinkQueueLimitBytes();
            int droppedFrames = enqueueResultEnqueue.getDroppedFrames();
            long droppedPcmBytes = enqueueResultEnqueue.getDroppedPcmBytes();
            long jPcmBytesQueued = this.pending.pcmBytesQueued();
            int iFrameCount = this.pending.frameCount();
            StringBuilder sbR = ai.onnxruntime.a.r(uplinkQueueLimitBytes, "[ASR-Stream] pending uplink over ", "B, DROP_OLDEST dropped=", droppedFrames);
            a0.a.s(droppedPcmBytes, " pcmBytes=", ", queued=", sbR);
            sbR.append(jPcmBytesQueued);
            sbR.append("B frames=");
            sbR.append(iFrameCount);
            AIEngineLogger.w(logModule, str2, sbR.toString());
        }
    }

    private final void flushPending() {
        long j10;
        int i10;
        long j11;
        int i11;
        FlushStep flushStepNextFlushBatch;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int i12 = this.generation.get();
        long jMaxFlushPcmBytes = maxFlushPcmBytes();
        synchronized (this.lock) {
            if (!this.closed.get() && i12 == this.generation.get()) {
                long jSessionBaseMs = this.timeline.sessionBaseMs();
                AsrWsPendingBuffer.EnqueueResult enqueueResultTrimOldest = this.pending.trimOldest(jMaxFlushPcmBytes);
                this.timeline.onFlushDropped(enqueueResultTrimOldest.getDroppedPcmBytes());
                long jSessionBaseMs2 = this.timeline.sessionBaseMs();
                int iFrameCount = this.pending.frameCount();
                long jPcmBytesQueued = this.pending.pcmBytesQueued();
                lb.n nVar = lb.n.f10413a;
                if (enqueueResultTrimOldest.getDroppedFrames() > 0) {
                    AtomicLong atomicLong = EngineMetrics.f6226a;
                    j10 = jElapsedRealtimeNanos;
                    EngineMetrics.K.addAndGet(enqueueResultTrimOldest.getDroppedFrames());
                    LogModule logModule = LogModule.ABILITY;
                    String str = this.TAG;
                    j11 = jPcmBytesQueued;
                    int droppedFrames = enqueueResultTrimOldest.getDroppedFrames();
                    long droppedPcmBytes = enqueueResultTrimOldest.getDroppedPcmBytes();
                    String str2 = this.lastSessionId;
                    i10 = i12;
                    StringBuilder sbQ = ai.onnxruntime.a.q(jMaxFlushPcmBytes, "[ASR-Stream] flushPending backlog over limit=", "B (≈");
                    sbQ.append((1000 * jMaxFlushPcmBytes) / 32000);
                    sbQ.append("ms audio), DROP_OLDEST dropped=");
                    sbQ.append(droppedFrames);
                    a0.a.s(droppedPcmBytes, " pcmBytes=", ", timeline baseMs ", sbQ);
                    sbQ.append(jSessionBaseMs);
                    a0.a.s(jSessionBaseMs2, "→", ", session_id=", sbQ);
                    a0.a.x(sbQ, str2, logModule, str);
                } else {
                    j10 = jElapsedRealtimeNanos;
                    i10 = i12;
                    j11 = jPcmBytesQueued;
                }
                if (iFrameCount > 0) {
                    LogModule logModule2 = LogModule.ABILITY;
                    String str3 = this.TAG;
                    String str4 = this.lastSessionId;
                    StringBuilder sb2 = new StringBuilder("[ASR-Stream] flushPending start: queued=");
                    sb2.append(iFrameCount);
                    sb2.append(" frame(s) pcmBytes=");
                    sb2.append(j11);
                    a0.a.s((j11 * 1000) / 32000, " (≈", "ms audio), gen=", sb2);
                    i11 = i10;
                    com.stepos.core.ota.d.s(sb2, i11, " limit=", jMaxFlushPcmBytes);
                    sb2.append("B, session_id=");
                    sb2.append(str4);
                    AIEngineLogger.i(logModule2, str3, sb2.toString());
                } else {
                    i11 = i10;
                }
                int i13 = 0;
                long pcmBytes = 0;
                int i14 = 0;
                int i15 = 0;
                while (true) {
                    synchronized (this.lock) {
                        flushStepNextFlushBatch = nextFlushBatch(i11);
                    }
                    if (!(flushStepNextFlushBatch instanceof FlushStep.Batch)) {
                        break;
                    }
                    FlushStep.Batch batch = (FlushStep.Batch) flushStepNextFlushBatch;
                    Iterator<T> it = batch.getBatch().getFrames().iterator();
                    while (it.hasNext()) {
                        i14++;
                        if (sendWithBackpressure(batch.getTarget(), ((AsrWsPendingBuffer.Frame) it.next()).getWire())) {
                            i13++;
                            pcmBytes += r9.getPcmBytes();
                        }
                    }
                    i15++;
                }
                if (!kotlin.jvm.internal.g.b(flushStepNextFlushBatch, FlushStep.Drained.INSTANCE)) {
                    if (!kotlin.jvm.internal.g.b(flushStepNextFlushBatch, FlushStep.Abandon.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    AIEngineLogger.w(LogModule.ABILITY, this.TAG, a0.a.g("[ASR-Stream] flushPending abandoned (stale generation / closed) after ", i13, " frame(s), session_id=", this.lastSessionId));
                }
                if (i14 == 0) {
                    return;
                }
                long jElapsedRealtimeNanos2 = (SystemClock.elapsedRealtimeNanos() - j10) / 1000000;
                AtomicLong atomicLong2 = EngineMetrics.f6226a;
                EngineMetrics.H.incrementAndGet();
                EngineMetrics.I.addAndGet(i13);
                EngineMetrics.J.addAndGet(pcmBytes);
                EngineMetrics.O.l(jElapsedRealtimeNanos2);
                String strA = i13 < i14 ? ai.onnxruntime.providers.a.a(i14 - i13, " DROPPED_BY_BACKPRESSURE=") : "";
                LogModule logModule3 = LogModule.ABILITY;
                String str5 = this.TAG;
                String str6 = this.lastSessionId;
                StringBuilder sbD = h0.e.d(i13, "[ASR-Stream] flushPending: sent ", i14, "/", " queued append frame(s) in order (pcmBytes=");
                sbD.append(pcmBytes);
                sbD.append(" batches=");
                sbD.append(i15);
                a0.a.s(jElapsedRealtimeNanos2, " tookMs=", ")", sbD);
                AIEngineLogger.i(logModule3, str5, ai.onnxruntime.a.p(sbD, strA, ", session_id=", str6));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleServerEvent(String str) {
        zb.l<CloudSessionCorrelationState, lb.n> onCorrelationEstablished;
        try {
            AsrWsModels asrWsModels = AsrWsModels.INSTANCE;
            AsrWsModels.ServerEvent serverEvent = asrWsModels.parseServerEvent(str);
            if (!gc.q.t0(serverEvent.getSessionId())) {
                this.lastSessionId = serverEvent.getSessionId();
            }
            LogModule logModule = LogModule.ABILITY;
            String str2 = this.TAG;
            String str3 = this.currentTraceId;
            String type = serverEvent.getType();
            String sessionId = serverEvent.getSessionId();
            AsrTranscriptLog asrTranscriptLog = AsrTranscriptLog.INSTANCE;
            String strWsEventTextSuffix = asrTranscriptLog.wsEventTextSuffix(serverEvent, this.plainTranscriptLog);
            StringBuilder sbS = ai.onnxruntime.a.s("[ASR-Stream] ws event: x-trace-id=", str3, ", type=", type, ", session_id=");
            sbS.append(sessionId);
            sbS.append(strWsEventTextSuffix);
            AIEngineLogger.i(logModule, str2, sbS.toString());
            if (this.plainTranscriptLog) {
                h0.e.k("[ASR-Stream] ws event raw: ", asrTranscriptLog.formatWsEvent(str, true), logModule, this.TAG);
            } else {
                AIEngineLogger.d(logModule, this.TAG, "[ASR-Stream] ws event raw: " + asrWsModels.formatForDiagLog(str));
            }
            if (serverEvent instanceof AsrWsModels.ServerEvent.SessionReady) {
                AsrWsModels.ServerEvent.SessionReady sessionReady = (AsrWsModels.ServerEvent.SessionReady) serverEvent;
                String type2 = sessionReady.getType();
                long j10 = -1;
                if (kotlin.jvm.internal.g.b(type2, "session.created")) {
                    this.sessionCreatedAtMs = SystemClock.elapsedRealtime();
                    if (this.wsOpenedAtMs > 0) {
                        j10 = this.sessionCreatedAtMs - this.wsOpenedAtMs;
                        if (j10 < 0) {
                            j10 = 0;
                        }
                    }
                    long j11 = j10;
                    if (!gc.q.t0(sessionReady.getSessionId())) {
                        this.correlationState = new CloudSessionCorrelationState(sessionReady.getSessionId(), CloudCorrelationSource.ASR_WS_SESSION_CREATED_ID, this.currentTraceId, this.gatewayTraceId, this.generation.get(), null, this.headerFetchMs, this.connectToOpenMs, j11, 0L, 544, null);
                    }
                } else if (kotlin.jvm.internal.g.b(type2, "session.updated")) {
                    this.sessionUpdatedAtMs = SystemClock.elapsedRealtime();
                    if (this.sessionCreatedAtMs > 0) {
                        long j12 = this.sessionUpdatedAtMs - this.sessionCreatedAtMs;
                        j10 = j12 < 0 ? 0L : j12;
                    }
                    CloudSessionCorrelationState cloudSessionCorrelationState = this.correlationState;
                    this.correlationState = cloudSessionCorrelationState.copy((511 & 1) != 0 ? cloudSessionCorrelationState.cloudCorrelationId : null, (511 & 2) != 0 ? cloudSessionCorrelationState.source : null, (511 & 4) != 0 ? cloudSessionCorrelationState.clientDebugTraceId : null, (511 & 8) != 0 ? cloudSessionCorrelationState.gatewayTraceId : null, (511 & 16) != 0 ? cloudSessionCorrelationState.connectionGeneration : 0, (511 & 32) != 0 ? cloudSessionCorrelationState.asyncTaskId : null, (511 & 64) != 0 ? cloudSessionCorrelationState.headerFetchMs : 0L, (511 & TraceIdKeys.MAX_LENGTH) != 0 ? cloudSessionCorrelationState.connectToOpenMs : 0L, (511 & 256) != 0 ? cloudSessionCorrelationState.openToHandshakeAckMs : 0L, (511 & VadSessionManager.FRAME_BYTES) != 0 ? cloudSessionCorrelationState.handshakeAckToReadyMs : j10);
                    if (!gc.q.t0(this.correlationState.getCloudCorrelationId()) && (onCorrelationEstablished = getOnCorrelationEstablished()) != null) {
                        onCorrelationEstablished.invoke(this.correlationState);
                    }
                }
                this.riskBlockedRecovery = AsrStreamReconnectPolicy.INSTANCE.clearRiskBlockedRecovery();
                flushPending();
                return;
            }
            if (serverEvent instanceof AsrWsModels.ServerEvent.Delta) {
                this.segmentInProgress.set(true);
                AsrWsModels.ServerEvent.Delta delta = (AsrWsModels.ServerEvent.Delta) serverEvent;
                String strNextIncrement = this.deltaTracker.nextIncrement(delta.getText());
                Pair<Long, Long> pairGlobalize = this.timeline.globalize(delta.getStartMs(), delta.getEndMs());
                long jLongValue = pairGlobalize.f9985a.longValue();
                long jLongValue2 = pairGlobalize.f9986b.longValue();
                if (strNextIncrement.length() > 0) {
                    this.lastPartialStartMs = jLongValue;
                    this.lastPartialEndMs = jLongValue2;
                    this.producedResult.set(true);
                }
                this._events.tryEmit(new c.e(strNextIncrement, delta.getText(), delta.getStash(), jLongValue, jLongValue2));
                return;
            }
            if (!(serverEvent instanceof AsrWsModels.ServerEvent.Completed)) {
                if (serverEvent instanceof AsrWsModels.ServerEvent.Failure) {
                    AsrWsModels.ServerEvent.Failure failure = (AsrWsModels.ServerEvent.Failure) serverEvent;
                    recoverOrFail(failure.getCode(), failure.getMessage(), failure.getSessionId());
                    return;
                } else {
                    if (!(serverEvent instanceof AsrWsModels.ServerEvent.Ignored)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (gc.o.e0(((AsrWsModels.ServerEvent.Ignored) serverEvent).getType(), "speech_started", false)) {
                        this.segmentInProgress.set(true);
                        return;
                    }
                    return;
                }
            }
            this.segmentInProgress.set(false);
            this.audioPendingResult.set(false);
            AsrWsModels.ServerEvent.Completed completed = (AsrWsModels.ServerEvent.Completed) serverEvent;
            Pair<Long, Long> pairGlobalize2 = this.timeline.globalize(completed.getStartMs(), completed.getEndMs());
            long jLongValue3 = pairGlobalize2.f9985a.longValue();
            long jLongValue4 = pairGlobalize2.f9986b.longValue();
            if (completed.getText().length() > 0) {
                this.producedResult.set(true);
            }
            this._events.tryEmit(new c.C0091c(completed.getText(), jLongValue3, jLongValue4));
            this.deltaTracker.reset();
            if (this.finishing.get()) {
                this.awaitingPostCommitCompleted.set(false);
                emitEndOfTurn();
            }
        } catch (Exception e10) {
            ai.onnxruntime.a.w("[ASR-Stream] parse ws event failed: ", e10.getMessage(), LogModule.ABILITY, this.TAG);
        }
    }

    private final boolean isLinkCaused(int i10) {
        return i10 == 270001;
    }

    private final boolean isRecoverable(int i10) {
        switch (i10) {
            case AIEngineError.CLOUD_AUTH_FAILED /* 170002 */:
            case AIEngineError.CLOUD_NETWORK_UNAVAILABLE /* 270001 */:
            case AIEngineError.CLOUD_SERVER_ERROR /* 270003 */:
            case AIEngineError.CLOUD_RISK_BLOCKED /* 270007 */:
            case AIEngineError.CLOUD_QUOTA_EXCEEDED /* 270008 */:
                return true;
            default:
                return false;
        }
    }

    private final void launchConnect(int i10) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C03071(i10, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.stepos.core.ability.speech.AsrCloudWsSession$listenerFor$1] */
    private final C03081 listenerFor(final int i10) {
        return new CloudWebSocketClient.Listener() { // from class: com.stepos.core.ability.speech.AsrCloudWsSession.listenerFor.1
            @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Listener
            public void onClosed(int i11, String reason) {
                kotlin.jvm.internal.g.f(reason, "reason");
                if (i10 != this.generation.get()) {
                    return;
                }
                this.handshake.closeGate();
                if (this.closed.get()) {
                    this.closeAck.complete(lb.n.f10413a);
                    return;
                }
                if (!this.finishing.get()) {
                    this.lastCloseCode = Integer.valueOf(i11);
                    this.lastFailureHttpCode = null;
                    this.lastRetryAfterMs = 0L;
                    AsrCloudWsSession.recoverOrFail$default(this, i11 == 1013 ? AIEngineError.CLOUD_QUOTA_EXCEEDED : AIEngineError.CLOUD_NETWORK_UNAVAILABLE, ai.onnxruntime.providers.a.a(i11, "ws closed by server: code="), null, 4, null);
                    return;
                }
                a0.a.z(h0.e.f("[ASR-Stream] ws closed during finishing: x-trace-id=", this.currentTraceId, ", code=", i11, ", session_id="), this.lastSessionId, LogModule.ABILITY, this.TAG);
                this.maybeEmitEndOfTurnOnTransportClose();
            }

            @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Listener
            public void onFailure(Throwable t8, Integer num, Long l10) {
                kotlin.jvm.internal.g.f(t8, "t");
                if (i10 != this.generation.get()) {
                    return;
                }
                this.handshake.closeGate();
                if (this.closed.get()) {
                    this.closeAck.complete(lb.n.f10413a);
                    return;
                }
                if (this.finishing.get()) {
                    LogModule logModule = LogModule.ABILITY;
                    String str = this.TAG;
                    String str2 = this.currentTraceId;
                    String str3 = this.lastSessionId;
                    StringBuilder sb2 = new StringBuilder("[ASR-Stream] ws failure during finishing: x-trace-id=");
                    sb2.append(str2);
                    sb2.append(", httpCode=");
                    sb2.append(num);
                    sb2.append(", session_id=");
                    a0.a.z(sb2, str3, logModule, str);
                    this.maybeEmitEndOfTurnOnTransportClose();
                    return;
                }
                if (CloudHttpErrorMapper.INSTANCE.isAuthFailure(num)) {
                    AIEngineLogger.w(LogModule.ABILITY, this.TAG, "[ASR-Stream] ws " + num + " auth failure (x-trace-id=" + this.currentTraceId + ", session_id=" + this.lastSessionId + "): invalidate token then reconnect");
                    try {
                        this.onAuthFailed.invoke();
                        lb.n nVar = lb.n.f10413a;
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                }
                this.lastCloseCode = null;
                this.lastFailureHttpCode = num;
                this.lastRetryAfterMs = l10 != null ? l10.longValue() : 0L;
                AsrCloudWsSession asrCloudWsSession = this;
                AsrCloudWsSession.recoverOrFail$default(asrCloudWsSession, asrCloudWsSession.transportFailureCode(num), "ws failure httpCode=" + num + ": " + t8.getMessage(), null, 4, null);
            }

            @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Listener
            public void onOpen() {
                if (i10 != this.generation.get()) {
                    return;
                }
                this.handshake.markOpened();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.wsOpenedAtMs = jElapsedRealtime;
                AsrCloudWsSession asrCloudWsSession = this;
                long j10 = 0;
                if (asrCloudWsSession.connectStartedAtMs > 0) {
                    long j11 = jElapsedRealtime - this.connectStartedAtMs;
                    if (j11 >= 0) {
                        j10 = j11;
                    }
                } else {
                    j10 = -1;
                }
                asrCloudWsSession.connectToOpenMs = j10;
                String strBuildSessionUpdate = AsrWsModels.INSTANCE.buildSessionUpdate(this.config);
                h0.e.k("[ASR-Stream][DIAG] session.update=", strBuildSessionUpdate, LogModule.ABILITY, this.TAG);
                CloudWebSocketClient.Session session = this.session;
                if (session != null) {
                    session.sendText(strBuildSessionUpdate);
                }
            }

            @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Listener
            public void onTextMessage(String text) {
                kotlin.jvm.internal.g.f(text, "text");
                if (i10 != this.generation.get()) {
                    return;
                }
                this.handleServerEvent(text);
            }
        };
    }

    private final void logAppend(long j10, i7.a aVar, boolean z) {
        int andSet;
        int i10;
        LogLevel logLevel = LogLevel.DEBUG;
        LogModule logModule = LogModule.ABILITY;
        if (LogConfig.shouldLog(logLevel, logModule)) {
            String strG = z ? ai.onnxruntime.a.g(this.pending.frameCount(), "HELD (ws handshaking, queued=", ")") : ai.onnxruntime.a.k("SENT session_id=", this.lastSessionId);
            String str = this.TAG;
            int i11 = aVar.f9551b;
            int length = aVar.f9550a.length;
            StringBuilder sbR = ai.onnxruntime.a.r(j10, "[ASR-Stream] append#", " clientSeq=", i11);
            sbR.append(" bytes=");
            sbR.append(length);
            sbR.append(" → ");
            sbR.append(strG);
            AIEngineLogger.d(logModule, str, sbR.toString());
        }
        int i12 = aVar.f9551b;
        if (i12 >= 0 && (andSet = this.lastClientSeq.getAndSet(i12)) >= 0 && (i10 = aVar.f9551b) < andSet) {
            String str2 = this.TAG;
            String str3 = this.lastSessionId;
            StringBuilder sbD = h0.e.d(andSet, "[ASR-Stream] append out-of-order: clientSeq went ", i10, " → ", " at append#");
            sbD.append(j10);
            sbD.append(" — uplink PCM reached cloud unordered, session_id=");
            sbD.append(str3);
            AIEngineLogger.w(logModule, str2, sbD.toString());
        }
    }

    private final long maxFlushPcmBytes() {
        long uplinkQueueLimitBytes = this.transport.getBackpressure().getUplinkQueueLimitBytes();
        return !this.handshake.getWasEverReady() ? uplinkQueueLimitBytes : Math.min(256000L, uplinkQueueLimitBytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeEmitEndOfTurnOnTransportClose() {
        if (!isManualCommitMode() || !this.awaitingPostCommitCompleted.get()) {
            emitEndOfTurn();
            return;
        }
        h0.e.k("[ASR-Stream] manual finishing: transport closed before post-commit completed, defer EndOfTurn to grace, session_id=", this.lastSessionId, LogModule.ABILITY, this.TAG);
    }

    private final FlushStep nextFlushBatch(int i10) {
        if (this.closed.get() || i10 != this.generation.get()) {
            return FlushStep.Abandon.INSTANCE;
        }
        CloudWebSocketClient.Session session = this.session;
        if (session == null) {
            return FlushStep.Abandon.INSTANCE;
        }
        AsrWsPendingBuffer.DrainResult drainResultDrainBatch = this.pending.drainBatch(32);
        if (!drainResultDrainBatch.getFrames().isEmpty()) {
            return new FlushStep.Batch(session, drainResultDrainBatch);
        }
        this.handshake.markReady();
        if (this.finishRequested.getAndSet(false) && isManualCommitMode()) {
            this.awaitingPostCommitCompleted.set(true);
            session.sendText(AsrWsModels.INSTANCE.buildCommit());
        }
        return FlushStep.Drained.INSTANCE;
    }

    private final int normalizeTerminalCode(int i10) {
        return (i10 != 270001 || this.handshake.getWasEverOpened()) ? i10 : AIEngineError.CLOUD_NETWORK_ERROR;
    }

    private final void reconnect(long j10, boolean z) {
        long j11;
        long jPcmBytesQueued;
        if (!z) {
            this.lastReconnectDelayMs = j10;
        }
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        synchronized (this.lock) {
            try {
                j11 = this.totalPcmBytesFed.get();
                jPcmBytesQueued = z ? this.pending.pcmBytesQueued() : 0L;
                this.timeline.onReconnect(j11 - jPcmBytesQueued);
                ref$IntRef.f10074a = this.generation.incrementAndGet();
                this.handshake.closeGate();
                this.handshake.beginGeneration();
                this.segmentInProgress.set(false);
                this.audioPendingResult.set(false);
                if (!z) {
                    this.pending.clear();
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        LogModule logModule = LogModule.ABILITY;
        String str = this.TAG;
        StringBuilder sbQ = ai.onnxruntime.a.q(this.timeline.sessionBaseMs(), "[ASR-Stream] reconnect timeline: baseMs=", ", fedBytes=");
        sbQ.append(j11);
        AIEngineLogger.i(logModule, str, a0.a.d(jPcmBytesQueued, ", retainedPending=", "B", sbQ));
        this.deltaTracker.reset();
        CloudWebSocketClient.Session session = this.session;
        if (session != null) {
            try {
                session.cancel();
            } catch (Throwable th2) {
                kotlin.c.a(th2);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass3(z, this, j10, ref$IntRef, null), 3, null);
    }

    public static /* synthetic */ void reconnect$default(AsrCloudWsSession asrCloudWsSession, long j10, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        asrCloudWsSession.reconnect(j10, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordLinkPark(long j10) {
        this.lastLinkParkMs = j10;
        AtomicLong atomicLong = EngineMetrics.f6226a;
        EngineMetrics.P.incrementAndGet();
        EngineMetrics.R.l(j10);
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.h(j10, "[ASR-Stream] link restored after ", "ms parked, reconnecting with attempt budget untouched"));
    }

    private final void recoverOrFail(int i10, String str, String str2) {
        AsrStreamReconnectPolicy asrStreamReconnectPolicy;
        AsrStreamReconnectPolicy.Decision decisionEvaluate;
        long jComputeBackoffMs;
        if (this.closed.get()) {
            return;
        }
        this.lastFailureCode = Integer.valueOf(i10);
        if (this.finishing.get() && this.producedResult.get()) {
            AIEngineLogger.w(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.p(h0.e.f("[ASR-Stream] ws error during finish, downgraded (round already produced text, let grace finalize): x-trace-id=", this.currentTraceId, ", code=", i10, ", session_id="), str2, ", ", str));
            return;
        }
        if (this.finishing.get() || !isRecoverable(i10)) {
            AIEngineLogger.e(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.p(h0.e.f("[ASR-Stream] ws error: x-trace-id=", this.currentTraceId, ", code=", i10, ", session_id="), str2, ", ", str));
            emitTerminalFailure(i10);
            return;
        }
        if (i10 == 270007 && !this.riskBlockedRecovery.getActive()) {
            this.riskBlockedRecovery = AsrStreamReconnectPolicy.INSTANCE.enterRiskBlockedRecovery();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.connectStartedAtMs;
        CloudTransportConfig.Resilience resilience = this.transport.getResilience();
        if (isLinkCaused(i10) && CloudNetworkWatcher.INSTANCE.isLinkDown()) {
            LogModule logModule = LogModule.ABILITY;
            String str3 = this.TAG;
            String str4 = this.currentTraceId;
            int i11 = this.connectAttempt;
            StringBuilder sbF = h0.e.f("[ASR-Stream] link down, parking reconnect until network returns (x-trace-id=", str4, ", code=", i10, ", session_id=");
            com.stepos.core.ota.d.o(i11, str2, "), attempt held at ", " sessionDur=", sbF);
            sbF.append(jElapsedRealtime);
            sbF.append("ms: ");
            sbF.append(str);
            AIEngineLogger.w(logModule, str3, sbF.toString());
            emitRecoverableNotice(i10, str);
            reconnect(0L, true);
            return;
        }
        synchronized (this.lock) {
            asrStreamReconnectPolicy = AsrStreamReconnectPolicy.INSTANCE;
            decisionEvaluate = asrStreamReconnectPolicy.evaluate(i10, this.connectAttempt, jElapsedRealtime, resilience.getReconnectStableSessionMs(), resilience.getReconnectMaxAttempts(), !this.handshake.getWasReadyThisGeneration());
            this.connectAttempt = decisionEvaluate.getNextAttempt();
            lb.n nVar = lb.n.f10413a;
        }
        if (decisionEvaluate.getExhausted()) {
            LogModule logModule2 = LogModule.ABILITY;
            String str5 = this.TAG;
            StringBuilder sbE = h0.e.e("[ASR-Stream] reconnect attempts exhausted (attempt=", decisionEvaluate.getNextAttempt(), "): x-trace-id=", this.currentTraceId, ", code=");
            h0.e.h(i10, ", session_id=", str2, ", ", sbE);
            sbE.append(str);
            AIEngineLogger.e(logModule2, str5, sbE.toString());
            emitTerminalFailure(i10);
            return;
        }
        boolean z = decisionEvaluate.getRiskBlockedExempt() && !this.riskBlockedRecovery.getReconnectFailedOnce();
        if (decisionEvaluate.getRiskBlockedExempt()) {
            Pair<Long, AsrStreamReconnectPolicy.RiskBlockedRecovery> pairPlanRiskBlockedDelay = asrStreamReconnectPolicy.planRiskBlockedDelay(this.riskBlockedRecovery, computeBackoffMs(0));
            jComputeBackoffMs = pairPlanRiskBlockedDelay.f9985a.longValue();
            this.riskBlockedRecovery = pairPlanRiskBlockedDelay.f9986b;
        } else {
            jComputeBackoffMs = computeBackoffMs(decisionEvaluate.getBackoffAttempt());
        }
        String strValueOf = (decisionEvaluate.getRiskBlockedExempt() && z) ? "risk-first" : decisionEvaluate.getRiskBlockedExempt() ? "risk-2s" : String.valueOf(decisionEvaluate.getNextAttempt());
        LogModule logModule3 = LogModule.ABILITY;
        String str6 = this.TAG;
        StringBuilder sbF2 = h0.e.f("[ASR-Stream] recoverable cloud error (x-trace-id=", this.currentTraceId, ", code=", i10, ", session_id=");
        ai.onnxruntime.a.z(sbF2, str2, "), attempt=", strValueOf, " sessionDur=");
        sbF2.append(jElapsedRealtime);
        a0.a.s(jComputeBackoffMs, "ms backoff=", "ms, dropping segment and reconnecting: ", sbF2);
        a0.a.x(sbF2, str, logModule3, str6);
        emitRecoverableNotice(i10, str);
        reconnect$default(this, jComputeBackoffMs, false, 2, null);
    }

    public static /* synthetic */ void recoverOrFail$default(AsrCloudWsSession asrCloudWsSession, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = asrCloudWsSession.lastSessionId;
        }
        asrCloudWsSession.recoverOrFail(i10, str, str2);
    }

    private final boolean sendWithBackpressure(String str) {
        CloudWebSocketClient.Session session = this.session;
        if (session == null) {
            return false;
        }
        return sendWithBackpressure(session, str);
    }

    private final int silenceBytesPerChunk() {
        return 3200;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int transportFailureCode(Integer num) {
        return num == null ? AIEngineError.CLOUD_NETWORK_UNAVAILABLE : CloudHttpErrorMapper.INSTANCE.toErrorCode(num);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitOpened(long r7, qb.b<? super java.lang.Boolean> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.core.ability.speech.AsrCloudWsSession.C03031
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.core.ability.speech.AsrCloudWsSession$awaitOpened$1 r0 = (com.stepos.core.ability.speech.AsrCloudWsSession.C03031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.AsrCloudWsSession$awaitOpened$1 r0 = new com.stepos.core.ability.speech.AsrCloudWsSession$awaitOpened$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            long r6 = r0.J$0
            java.lang.Object r8 = r0.L$0
            com.stepos.core.ability.speech.AsrCloudWsSession r8 = (com.stepos.core.ability.speech.AsrCloudWsSession) r8
            kotlin.c.b(r9)
            goto L59
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.c.b(r9)
            com.stepos.core.ability.speech.AsrCloudWsSession$HandshakeProgress r9 = r6.handshake
            boolean r9 = r9.getWasEverOpened()
            if (r9 == 0) goto L43
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            return r6
        L43:
            java.util.concurrent.atomic.AtomicBoolean r9 = r6.closed
            boolean r9 = r9.get()
            if (r9 != 0) goto L91
            r4 = 0
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 > 0) goto L52
            goto L91
        L52:
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r4 = r4 + r7
            r8 = r6
            r6 = r4
        L59:
            long r4 = android.os.SystemClock.elapsedRealtime()
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L86
            com.stepos.core.ability.speech.AsrCloudWsSession$HandshakeProgress r9 = r8.handshake
            boolean r9 = r9.getWasEverOpened()
            if (r9 == 0) goto L6c
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            return r6
        L6c:
            java.util.concurrent.atomic.AtomicBoolean r9 = r8.closed
            boolean r9 = r9.get()
            if (r9 == 0) goto L77
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        L77:
            r0.L$0 = r8
            r0.J$0 = r6
            r0.label = r3
            r4 = 50
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r9 != r1) goto L59
            return r1
        L86:
            com.stepos.core.ability.speech.AsrCloudWsSession$HandshakeProgress r6 = r8.handshake
            boolean r6 = r6.getWasEverOpened()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L91:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrCloudWsSession.awaitOpened(long, qb.b):java.lang.Object");
    }

    public final Object awaitReconnectBackoffForTest$ability_release(long j10, qb.b<? super lb.n> bVar) {
        Object objAwaitReconnectBackoff = awaitReconnectBackoff(j10, bVar);
        return objAwaitReconnectBackoff == CoroutineSingletons.f10059a ? objAwaitReconnectBackoff : lb.n.f10413a;
    }

    public void cancel() {
        if (this.closed.compareAndSet(false, true)) {
            AsrStreamDebugInjector.INSTANCE.unregister(this);
            String str = this.endOfTurnEmitted.get() ? "release (completed)" : "cancel";
            a0.a.z(ai.onnxruntime.a.s("[ASR-Stream] ", str, ": closing ws, x-trace-id=", this.currentTraceId, ", session_id="), this.lastSessionId, LogModule.ABILITY, this.TAG);
            this.riskBlockedRecovery = AsrStreamReconnectPolicy.INSTANCE.clearRiskBlockedRecovery();
            this.handshake.closeGate();
            synchronized (this.lock) {
                this.pending.clear();
                lb.n nVar = lb.n.f10413a;
            }
            try {
                CloudWebSocketClient.Session session = this.session;
                if (session != null) {
                    session.cancel();
                }
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            this.session = null;
            CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        }
        this.closeAck.complete(lb.n.f10413a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object closeAndAwait(long r11, qb.b<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrCloudWsSession.closeAndAwait(long, qb.b):java.lang.Object");
    }

    @Override // com.stepos.core.common.cloud.ObservableCloudSession
    public CloudSessionCorrelationState correlationState() {
        return this.correlationState;
    }

    public final int eventSubscriberCount$ability_release() {
        return this._events.getSubscriptionCount().getValue().intValue();
    }

    public void finish() {
        if (this.closed.get()) {
            return;
        }
        this.finishing.set(true);
        if (isManualCommitMode()) {
            synchronized (this.lock) {
                if (!this.handshake.isGateOpen()) {
                    this.finishRequested.set(true);
                    return;
                }
                AIEngineLogger.i(LogModule.ABILITY, this.TAG, "[ASR-Stream] finish: manual-commit mode, sending commit and awaiting completed, session_id=" + this.lastSessionId);
                this.awaitingPostCommitCompleted.set(true);
                CloudWebSocketClient.Session session = this.session;
                if (session != null) {
                    session.sendText(AsrWsModels.INSTANCE.buildCommit());
                }
                return;
            }
        }
        if (this.handshake.isGateOpen() && !this.segmentInProgress.get() && !this.audioPendingResult.get()) {
            h0.e.k("[ASR-Stream] finish: no segment in progress, short-circuit finalize (skip grace), session_id=", this.lastSessionId, LogModule.ABILITY, this.TAG);
            emitEndOfTurn();
            return;
        }
        List<String> listBuildSilenceFrames = buildSilenceFrames();
        int iSilenceBytesPerChunk = silenceBytesPerChunk();
        synchronized (this.lock) {
            try {
                if (this.handshake.isGateOpen()) {
                    Iterator<T> it = listBuildSilenceFrames.iterator();
                    while (it.hasNext()) {
                        sendWithBackpressure((String) it.next());
                    }
                    lb.n nVar = lb.n.f10413a;
                    return;
                }
                Iterator<T> it2 = listBuildSilenceFrames.iterator();
                while (it2.hasNext()) {
                    enqueuePending((String) it2.next(), iSilenceBytesPerChunk);
                }
                this.finishRequested.set(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Flow<i7.c> getEvents() {
        return this.events;
    }

    public final long getLastLinkParkMs$ability_release() {
        return this.lastLinkParkMs;
    }

    public final long getLastReconnectDelayMs$ability_release() {
        return this.lastReconnectDelayMs;
    }

    @Override // com.stepos.core.common.cloud.ObservableCloudSession
    public zb.l<CloudSessionCorrelationState, lb.n> getOnCorrelationEstablished() {
        return this.onCorrelationEstablished;
    }

    public final boolean hasEverOpened() {
        return this.handshake.getWasEverOpened();
    }

    public final void injectRecoverableEvent$ability_release(int i10, String detail) {
        kotlin.jvm.internal.g.f(detail, "detail");
        if (!DebugInjectionGate.INSTANCE.isEnabled() || this.closed.get()) {
            return;
        }
        recoverOrFail$default(this, i10, detail.concat(" [INJECTED]"), null, 4, null);
    }

    @Override // com.stepos.core.common.cloud.ObservableCloudSession
    public boolean isConnected() {
        return !this.closed.get() && this.handshake.isGateOpen();
    }

    public final boolean isHandshakeInFlight() {
        return (this.closed.get() || this.handshake.getWasEverOpened()) ? false : true;
    }

    public final boolean isManualCommitMode() {
        return gc.q.t0(this.config.streamVadType());
    }

    public final int noResultTerminalCode() {
        Integer num = this.lastFailureCode;
        return normalizeTerminalCode(num != null ? num.intValue() : AIEngineError.CLOUD_NETWORK_ERROR);
    }

    public final int pendingFrameCountForTest$ability_release() {
        int iFrameCount;
        synchronized (this.lock) {
            iFrameCount = this.pending.frameCount();
        }
        return iFrameCount;
    }

    public final void rebaseDeltaToCommitted(int i10) {
        this.deltaTracker.rebaseToCommitted(i10);
    }

    @Override // com.stepos.core.common.cloud.ObservableCloudSession
    public void setOnCorrelationEstablished(zb.l<? super CloudSessionCorrelationState, lb.n> lVar) {
        this.onCorrelationEstablished = lVar;
    }

    public void start() {
        if (gc.q.t0(this.config.getWsEndpoint())) {
            emitFailure(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED, "ws endpoint not configured");
            return;
        }
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("[ASR-Stream] start: connecting ws, model=", this.config.streamModel(), ", vad=", this.config.streamVadType()));
        AsrStreamDebugInjector.INSTANCE.register(this);
        launchConnect(this.generation.incrementAndGet());
    }

    public void feed(i7.a chunk) {
        kotlin.jvm.internal.g.f(chunk, "chunk");
        if (this.closed.get() || chunk.f9550a.length == 0) {
            return;
        }
        if (DebugInjectionGate.INSTANCE.isEnabled() && AsrStreamDebugInjector.INSTANCE.fireNextFeedIfArmed(this)) {
            return;
        }
        this.totalPcmBytesFed.addAndGet(chunk.f9550a.length);
        this.audioPendingResult.set(true);
        diagFeedEnergy(chunk.f9550a);
        Trace.beginSection("asr_uplink_encode");
        try {
            String strBuildAppend = AsrWsModels.INSTANCE.buildAppend(Base64.encodeToString(chunk.f9550a, 2));
            Trace.endSection();
            long andIncrement = this.appendIndex.getAndIncrement();
            synchronized (this.lock) {
                if (this.handshake.isGateOpen()) {
                    logAppend(andIncrement, chunk, false);
                    sendWithBackpressure(strBuildAppend);
                } else {
                    enqueuePending(strBuildAppend, chunk.f9550a.length);
                    logAppend(andIncrement, chunk, true);
                }
            }
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    private final boolean sendWithBackpressure(CloudWebSocketClient.Session session, String str) {
        if (session.queuedBytes() > this.transport.getBackpressure().getUplinkQueueLimitBytes()) {
            AtomicLong atomicLong = EngineMetrics.f6226a;
            EngineMetrics.M.incrementAndGet();
            AIEngineLogger.w(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.h(session.queuedBytes(), "[ASR-Stream] uplink queue high (", "B), dropping append frame"));
            return false;
        }
        if (session.sendText(str)) {
            return true;
        }
        AtomicLong atomicLong2 = EngineMetrics.f6226a;
        EngineMetrics.M.incrementAndGet();
        AIEngineLogger.w(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.h(session.queuedBytes(), "[ASR-Stream] uplink send rejected (queued=", "B), dropping append frame"));
        return false;
    }

    public static /* synthetic */ void getLastLinkParkMs$ability_release$annotations() {
    }

    public static /* synthetic */ void getLastReconnectDelayMs$ability_release$annotations() {
    }

    public /* synthetic */ AsrCloudWsSession(AsrCloudConfig asrCloudConfig, zb.l lVar, zb.a aVar, String str, int i10, kotlin.jvm.internal.e eVar) {
        this(asrCloudConfig, lVar, (i10 & 4) != 0 ? new a(1) : aVar, (i10 & 8) != 0 ? null : str);
    }
}
