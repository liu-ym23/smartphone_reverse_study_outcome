package com.stepos.core.ability.speech;

import android.os.SystemClock;
import com.stepos.core.ability.speech.TtsWsModels;
import com.stepos.core.common.cloud.AuthHeaderResult;
import com.stepos.core.common.cloud.CloudCorrelationSource;
import com.stepos.core.common.cloud.CloudErrorUserMessage;
import com.stepos.core.common.cloud.CloudHttpErrorMapper;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.cloud.CloudWebSocketClient;
import com.stepos.core.common.cloud.ObservableCloudSession;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.error.AIEngineError;
import i7.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsCloudWsSession implements ObservableCloudSession {
    public static final long AUDIO_DONE_AFTER_INPUT_CLOSED_MS = 90000;
    public static final long AUDIO_DONE_AFTER_WS_FAILURE_MS = 3000;
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_DOWNSTREAM_BUFFER_CAPACITY = 64;
    public static final long DOWNLINK_GAP_WARN_MS = 800;
    public static final long FINISH_DRAIN_POLL_MS = 200;
    public static final int PACING_CAP_LOG_EVERY = 10;
    public static final long UPLINK_IDLE_PROXY_CLOSE_WARN_MS = 18000;
    public static final long UPLINK_IDLE_WARN_DOWNLINK_ACTIVE_MS = 2000;
    public static final long UPLINK_QUEUE_WARN_BYTES = 16384;
    private final String TAG;
    private Job audioCompleteFallbackJob;
    private final AtomicBoolean audioEndMarkerSeen;
    private final String businessTraceId;
    private final AtomicBoolean closed;
    private final TtsUplinkCommitGate commitGate;
    private final boolean commitGateEnabled;
    private final Object commitLock;
    private volatile Job commitTimeoutJob;
    private final Object commitTimerLock;
    private final TtsCloudConfig config;
    private volatile Map<String, String> connectHeaders;
    private volatile long connectStartedAtMs;
    private volatile long connectToOpenMs;
    private volatile long connectionDoneAtMs;
    private volatile CloudSessionCorrelationState correlationState;
    private volatile String currentTraceId;
    private final AtomicInteger downlinkStallCount;
    private final Object emitChainLock;
    private Job emitChainTail;
    private final Channel<i7.d> eventChannel;
    private final Flow<i7.d> events;
    private volatile boolean finishDrainEngaged;
    private Job finishDrainJob;
    private volatile long finishDrainStartedAtMs;
    private final AtomicBoolean finishRequested;
    private volatile boolean finishScheduled;
    private final AtomicBoolean finishTerminatorInjected;
    private volatile long firstAudioAtMs;
    private volatile String gatewayTraceId;
    private volatile long headerFetchMs;
    private final zb.l<qb.b<? super AuthHeaderResult>, Object> headerProvider;
    private final AtomicBoolean inputClosedEmitted;
    private volatile long lastDownlinkAtMs;
    private volatile boolean lastUplinkEndedSentence;
    private volatile boolean lastUplinkHadUnclosedParen;
    private volatile long lastUplinkSendAtMs;
    private final TtsCloudWsSession$listener$1 listener;
    private final Object lock;
    private final zb.a<lb.n> onAuthFailed;
    private final zb.l<String, lb.n> onClientText;
    private zb.l<? super CloudSessionCorrelationState, lb.n> onCorrelationEstablished;
    private TtsTextOutboundQueue outboundQueue;
    private final AtomicInteger pacingCapReleaseCount;
    private final TtsUplinkParenBuffer parenBuffer;
    private final Object parenLock;
    private volatile Job parenTimeoutJob;
    private final Object parenTimerLock;
    private final List<String> pending;
    private final AtomicBoolean ready;
    private final AtomicBoolean realAudioDoneReceived;
    private final AtomicLong receivedAudioBytes;
    private final CoroutineScope scope;
    private final AtomicLong sentTextChars;
    private final TtsSentencePipelineGate sentencePipeline;
    private volatile CloudWebSocketClient.Session session;
    private final AtomicBoolean sessionFinishedEmitted;
    private volatile String sessionId;
    private final Object uplinkChainLock;
    private volatile Job uplinkChainTail;
    private final AtomicBoolean uplinkIdleWarned;
    private final AtomicInteger uplinkShapeInFlight;
    private volatile boolean urgentAudioFallbackScheduled;
    private volatile long wsOpenedAtMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$2, reason: invalid class name */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements zb.l<String, lb.n> {
        public AnonymousClass2(Object obj) {
            super(1, obj, TtsCloudWsSession.class, "sendWireFrame", "sendWireFrame(Ljava/lang/String;)V", 0);
        }

        @Override // zb.l
        public /* bridge */ /* synthetic */ lb.n invoke(String str) {
            invoke2(str);
            return lb.n.f10413a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p02) {
            kotlin.jvm.internal.g.f(p02, "p0");
            ((TtsCloudWsSession) this.receiver).sendWireFrame(p02);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$3, reason: invalid class name */
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements zb.a<lb.n> {
        public AnonymousClass3(Object obj) {
            super(0, obj, TtsCloudWsSession.class, "emitInputClosed", "emitInputClosed()V", 0);
        }

        @Override // zb.a
        public /* bridge */ /* synthetic */ lb.n invoke() {
            invoke2();
            return lb.n.f10413a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((TtsCloudWsSession) this.receiver).emitInputClosed();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession", f = "TtsCloudWsSession.kt", l = {772, 784}, m = "awaitUplinkPacing")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$awaitUplinkPacing$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TtsCloudWsSession.this.awaitUplinkPacing(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession", f = "TtsCloudWsSession.kt", l = {251}, m = "connect")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$connect$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03391 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03391(qb.b<? super C03391> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TtsCloudWsSession.this.connect(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession", f = "TtsCloudWsSession.kt", l = {550, 562}, m = "dispatchUplinkText")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$dispatchUplinkText$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03401 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03401(qb.b<? super C03401> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TtsCloudWsSession.this.dispatchUplinkText(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession", f = "TtsCloudWsSession.kt", l = {727, 729}, m = "emitShaped")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$emitShaped$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03411 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C03411(qb.b<? super C03411> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TtsCloudWsSession.this.emitShaped(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession", f = "TtsCloudWsSession.kt", l = {585}, m = "emitShapedAndReport")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$emitShapedAndReport$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03421(qb.b<? super C03421> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TtsCloudWsSession.this.emitShapedAndReport(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession$enqueueInbound$1", f = "TtsCloudWsSession.kt", l = {539}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$enqueueInbound$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03431 extends SuspendLambda implements zb.l<qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03431(String str, qb.b<? super C03431> bVar) {
            super(1, bVar);
            this.$text = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return TtsCloudWsSession.this.new C03431(this.$text, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String strTakeEmittable;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                if (TtsCloudWsSession.this.config.uplinkParenAware()) {
                    Object obj2 = TtsCloudWsSession.this.parenLock;
                    TtsCloudWsSession ttsCloudWsSession = TtsCloudWsSession.this;
                    String str = this.$text;
                    synchronized (obj2) {
                        ttsCloudWsSession.parenBuffer.append(str);
                        strTakeEmittable = ttsCloudWsSession.parenBuffer.takeEmittable();
                    }
                } else {
                    strTakeEmittable = this.$text;
                }
                TtsCloudWsSession.this.armOrCancelParenTimeout();
                if (strTakeEmittable.length() > 0) {
                    TtsCloudWsSession ttsCloudWsSession2 = TtsCloudWsSession.this;
                    this.label = 1;
                    if (ttsCloudWsSession2.dispatchUplinkText(strTakeEmittable, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((C03431) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession$flushCommitGateHeld$1", f = "TtsCloudWsSession.kt", l = {601}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$flushCommitGateHeld$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03441 extends SuspendLambda implements zb.l<qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $reason;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03441(String str, qb.b<? super C03441> bVar) {
            super(1, bVar);
            this.$reason = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return TtsCloudWsSession.this.new C03441(this.$reason, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String strTakeAll;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                Object obj2 = TtsCloudWsSession.this.commitLock;
                TtsCloudWsSession ttsCloudWsSession = TtsCloudWsSession.this;
                synchronized (obj2) {
                    strTakeAll = ttsCloudWsSession.commitGate.takeAll();
                }
                if (strTakeAll.length() > 0) {
                    LogModule logModule = LogModule.ABILITY;
                    String str = TtsCloudWsSession.this.TAG;
                    String str2 = this.$reason;
                    int length = strTakeAll.length();
                    a0.a.z(h0.e.f("[TTS-Stream] commit gate flush (", str2, "): len=", length, ", x-trace-id="), TtsCloudWsSession.this.currentTraceId, logModule, str);
                    TtsCloudWsSession ttsCloudWsSession2 = TtsCloudWsSession.this;
                    this.label = 1;
                    if (ttsCloudWsSession2.emitShapedAndReport(strTakeAll, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((C03441) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession$flushParenHeld$1", f = "TtsCloudWsSession.kt", l = {676}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$flushParenHeld$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03451 extends SuspendLambda implements zb.l<qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $reason;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03451(String str, qb.b<? super C03451> bVar) {
            super(1, bVar);
            this.$reason = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return TtsCloudWsSession.this.new C03451(this.$reason, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String strTakeAll;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                Object obj2 = TtsCloudWsSession.this.parenLock;
                TtsCloudWsSession ttsCloudWsSession = TtsCloudWsSession.this;
                synchronized (obj2) {
                    strTakeAll = ttsCloudWsSession.parenBuffer.takeAll();
                }
                if (strTakeAll.length() > 0) {
                    LogModule logModule = LogModule.ABILITY;
                    String str = TtsCloudWsSession.this.TAG;
                    String str2 = this.$reason;
                    int length = strTakeAll.length();
                    a0.a.x(h0.e.f("[TTS-Stream] paren gate flush (", str2, "): release unclosed inline instruction, len=", length, ", x-trace-id="), TtsCloudWsSession.this.currentTraceId, logModule, str);
                    TtsCloudWsSession ttsCloudWsSession2 = TtsCloudWsSession.this;
                    this.label = 1;
                    if (ttsCloudWsSession2.dispatchUplinkText(strTakeAll, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((C03451) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession$scheduleAudioCompleteFallback$1", f = "TtsCloudWsSession.kt", l = {1114, 1143}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$scheduleAudioCompleteFallback$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03461 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $reason;
        final /* synthetic */ boolean $urgent;
        int I$0;
        long J$0;
        long J$1;
        long J$2;
        long J$3;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TtsCloudWsSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03461(boolean z, TtsCloudWsSession ttsCloudWsSession, String str, qb.b<? super C03461> bVar) {
            super(2, bVar);
            this.$urgent = z;
            this.this$0 = ttsCloudWsSession;
            this.$reason = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03461 c03461 = new C03461(this.$urgent, this.this$0, this.$reason, bVar);
            c03461.L$0 = obj;
            return c03461;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x00c3, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(r12, r32) == r1) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x010c, code lost:
        
            if ((r32.this$0.wsOpenedAtMs > r20 ? r8 - r32.this$0.wsOpenedAtMs : r20) < r10) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0144, code lost:
        
            if ((r32.this$0.lastUplinkSendAtMs > r20 ? r8 - r32.this$0.lastUplinkSendAtMs : r18) >= r12) goto L55;
         */
        /* JADX WARN: Path cross not found for [B:45:0x010f, B:38:0x00f3], limit reached: 98 */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0151  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00c3 -> B:27:0x00c7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r33) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 675
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsCloudWsSession.C03461.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03461) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession$scheduleFinish$1", f = "TtsCloudWsSession.kt", l = {910}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$scheduleFinish$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03471 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        int label;

        public C03471(qb.b<? super C03471> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return TtsCloudWsSession.this.new C03471(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                this.label = 1;
                if (DelayKt.delay(200L, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            TtsCloudWsSession.maybeBeginFinishDrain$default(TtsCloudWsSession.this, false, 1, null);
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03471) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession$scheduleFinishDrainCheck$1", f = "TtsCloudWsSession.kt", l = {950}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$scheduleFinishDrainCheck$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03481 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ long $delayMs;
        int label;
        final /* synthetic */ TtsCloudWsSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03481(long j10, TtsCloudWsSession ttsCloudWsSession, qb.b<? super C03481> bVar) {
            super(2, bVar);
            this.$delayMs = j10;
            this.this$0 = ttsCloudWsSession;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new C03481(this.$delayMs, this.this$0, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                long j10 = this.$delayMs;
                if (j10 < 0) {
                    j10 = 0;
                }
                this.label = 1;
                if (DelayKt.delay(j10, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            this.this$0.finishDrainTick();
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03481) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession$start$1", f = "TtsCloudWsSession.kt", l = {244}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudWsSession$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03491 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        int label;

        public C03491(qb.b<? super C03491> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return TtsCloudWsSession.this.new C03491(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                TtsCloudWsSession ttsCloudWsSession = TtsCloudWsSession.this;
                this.label = 1;
                if (ttsCloudWsSession.connect(this) == coroutineSingletons) {
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
            return ((C03491) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.stepos.core.ability.speech.TtsCloudWsSession$listener$1] */
    public TtsCloudWsSession(TtsCloudConfig config, zb.l<? super qb.b<? super AuthHeaderResult>, ? extends Object> headerProvider, zb.a<lb.n> onAuthFailed, int i10, String str, zb.l<? super String, lb.n> lVar) {
        kotlin.jvm.internal.g.f(config, "config");
        kotlin.jvm.internal.g.f(headerProvider, "headerProvider");
        kotlin.jvm.internal.g.f(onAuthFailed, "onAuthFailed");
        this.config = config;
        this.headerProvider = headerProvider;
        this.onAuthFailed = onAuthFailed;
        this.businessTraceId = str;
        this.onClientText = lVar;
        this.TAG = "TtsCloudWsSession";
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        int i11 = i10;
        Channel<i7.d> channelChannel$default = ChannelKt.Channel$default(i11 < 1 ? 1 : i11, BufferOverflow.SUSPEND, null, 4, null);
        this.eventChannel = channelChannel$default;
        this.events = FlowKt.receiveAsFlow(channelChannel$default);
        this.emitChainLock = new Object();
        this.ready = new AtomicBoolean(false);
        this.closed = new AtomicBoolean(false);
        this.finishRequested = new AtomicBoolean(false);
        this.inputClosedEmitted = new AtomicBoolean(false);
        this.sessionFinishedEmitted = new AtomicBoolean(false);
        this.realAudioDoneReceived = new AtomicBoolean(false);
        this.audioEndMarkerSeen = new AtomicBoolean(false);
        this.currentTraceId = "";
        this.gatewayTraceId = "";
        this.correlationState = new CloudSessionCorrelationState(null, null, null, null, 0, null, 0L, 0L, 0L, 0L, 1023, null);
        this.headerFetchMs = -1L;
        this.connectToOpenMs = -1L;
        this.connectHeaders = kotlin.collections.b.d0();
        this.pending = new ArrayList();
        this.lock = new Object();
        this.uplinkChainLock = new Object();
        this.uplinkShapeInFlight = new AtomicInteger(0);
        this.parenBuffer = new TtsUplinkParenBuffer();
        this.parenLock = new Object();
        this.parenTimerLock = new Object();
        this.commitGateEnabled = config.uplinkCommitMinChars() > 0 && !config.uplinkSentencePipeline();
        this.commitGate = new TtsUplinkCommitGate();
        this.commitLock = new Object();
        this.commitTimerLock = new Object();
        this.sentTextChars = new AtomicLong(0L);
        this.finishTerminatorInjected = new AtomicBoolean(false);
        this.receivedAudioBytes = new AtomicLong(0L);
        this.downlinkStallCount = new AtomicInteger(0);
        this.uplinkIdleWarned = new AtomicBoolean(false);
        this.pacingCapReleaseCount = new AtomicInteger(0);
        this.sentencePipeline = new TtsSentencePipelineGate(config.uplinkSentencePacingTimeoutMs(), 200L, null, 4, null);
        this.outboundQueue = new TtsTextOutboundQueue(new AnonymousClass2(this), new AnonymousClass3(this));
        this.listener = new CloudWebSocketClient.Listener() { // from class: com.stepos.core.ability.speech.TtsCloudWsSession$listener$1
            @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Listener
            public void onClosed(int i12, String reason) {
                kotlin.jvm.internal.g.f(reason, "reason");
                this.this$0.ready.set(false);
                if (this.this$0.sessionFinishedEmitted.get()) {
                    AIEngineLogger.d(LogModule.ABILITY, this.this$0.TAG, com.stepos.core.ota.d.h("[TTS-Stream] ws closed after audio.done: x-trace-id=", i12, this.this$0.currentTraceId, ", code="));
                    return;
                }
                if (!this.this$0.finishRequested.get()) {
                    if (this.this$0.closed.get()) {
                        return;
                    }
                    AIEngineLogger.w(LogModule.ABILITY, this.this$0.TAG, ai.onnxruntime.a.p(h0.e.f("[TTS-Stream] ws closed: x-trace-id=", this.this$0.currentTraceId, ", code=", i12, ", reason="), reason, ", [NET] ", this.this$0.netDiag()));
                    int i13 = i12 == 1013 ? AIEngineError.CLOUD_QUOTA_EXCEEDED : AIEngineError.CLOUD_NETWORK_UNAVAILABLE;
                    this.this$0.emitFailed(i13, "ws closed: " + i12);
                    return;
                }
                a0.a.z(h0.e.f("[TTS-Stream] ws closed during finishing: x-trace-id=", this.this$0.currentTraceId, ", code=", i12, ", [NET] "), this.this$0.netDiag(), LogModule.ABILITY, this.this$0.TAG);
                this.this$0.finalizeInputDuringFinishTransportLoss("ws closed during finish code=" + i12);
                this.this$0.scheduleAudioCompleteFallback("ws closed code=" + i12, true);
            }

            @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Listener
            public void onFailure(Throwable t8, Integer num, Long l10) {
                kotlin.jvm.internal.g.f(t8, "t");
                this.this$0.ready.set(false);
                if (CloudHttpErrorMapper.INSTANCE.isAuthFailure(num)) {
                    try {
                        this.this$0.onAuthFailed.invoke();
                        lb.n nVar = lb.n.f10413a;
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                }
                if (this.this$0.sessionFinishedEmitted.get()) {
                    LogModule logModule = LogModule.ABILITY;
                    String str2 = this.this$0.TAG;
                    String str3 = this.this$0.currentTraceId;
                    String message = t8.getMessage();
                    StringBuilder sb2 = new StringBuilder("[TTS-Stream] ws failure after audio.done (ignored): x-trace-id=");
                    sb2.append(str3);
                    sb2.append(", httpCode=");
                    sb2.append(num);
                    sb2.append(", ");
                    a0.a.z(sb2, message, logModule, str2);
                    return;
                }
                if (this.this$0.finishRequested.get()) {
                    LogModule logModule2 = LogModule.ABILITY;
                    String str4 = this.this$0.TAG;
                    String str5 = this.this$0.currentTraceId;
                    String message2 = t8.getMessage();
                    String strNetDiag = this.this$0.netDiag();
                    StringBuilder sb3 = new StringBuilder("[TTS-Stream] ws failure during finishing: x-trace-id=");
                    sb3.append(str5);
                    sb3.append(", httpCode=");
                    sb3.append(num);
                    sb3.append(", ");
                    AIEngineLogger.i(logModule2, str4, ai.onnxruntime.a.p(sb3, message2, ", [NET] ", strNetDiag));
                    this.this$0.finalizeInputDuringFinishTransportLoss("ws failure during finish");
                    this.this$0.scheduleAudioCompleteFallback("ws failure: " + t8.getMessage(), true);
                    return;
                }
                LogModule logModule3 = LogModule.ABILITY;
                String str6 = this.this$0.TAG;
                String str7 = this.this$0.currentTraceId;
                String message3 = t8.getMessage();
                String strNetDiag2 = this.this$0.netDiag();
                StringBuilder sb4 = new StringBuilder("[TTS-Stream] ws failure: x-trace-id=");
                sb4.append(str7);
                sb4.append(", httpCode=");
                sb4.append(num);
                sb4.append(", ");
                AIEngineLogger.e(logModule3, str6, ai.onnxruntime.a.p(sb4, message3, ", [NET] ", strNetDiag2));
                TtsCloudWsSession ttsCloudWsSession = this.this$0;
                int errorCode = num == null ? AIEngineError.CLOUD_NETWORK_UNAVAILABLE : CloudHttpErrorMapper.INSTANCE.toErrorCode(num);
                ttsCloudWsSession.emitFailed(errorCode, "ws failure http=" + num + ": " + t8.getMessage());
            }

            @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Listener
            public void onOpen() {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.this$0.wsOpenedAtMs = jElapsedRealtime;
                TtsCloudWsSession ttsCloudWsSession = this.this$0;
                long j10 = 0;
                if (ttsCloudWsSession.connectStartedAtMs > 0) {
                    long j11 = jElapsedRealtime - this.this$0.connectStartedAtMs;
                    if (j11 >= 0) {
                        j10 = j11;
                    }
                } else {
                    j10 = -1;
                }
                ttsCloudWsSession.connectToOpenMs = j10;
            }

            @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Listener
            public void onTextMessage(String text) {
                kotlin.jvm.internal.g.f(text, "text");
                this.this$0.handleServerEvent(text);
            }
        };
    }

    private final void armCommitTimeout() {
        long jUplinkCommitHoldTimeoutMs = this.config.uplinkCommitHoldTimeoutMs();
        synchronized (this.commitTimerLock) {
            try {
                Job job = this.commitTimeoutJob;
                if (job == null || !job.isActive()) {
                    this.commitTimeoutJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new TtsCloudWsSession$armCommitTimeout$1$1(jUplinkCommitHoldTimeoutMs, this, null), 3, null);
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void armOrCancelParenTimeout() {
        boolean zHasBuffered;
        synchronized (this.parenLock) {
            zHasBuffered = this.parenBuffer.hasBuffered();
        }
        long jUplinkParenTimeoutMs = this.config.uplinkParenTimeoutMs();
        if (!zHasBuffered || jUplinkParenTimeoutMs <= 0) {
            cancelParenTimeout();
            return;
        }
        synchronized (this.parenTimerLock) {
            try {
                Job job = this.parenTimeoutJob;
                if (job == null || !job.isActive()) {
                    this.parenTimeoutJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new TtsCloudWsSession$armOrCancelParenTimeout$1$1(jUplinkParenTimeoutMs, this, null), 3, null);
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitSentencePipelineBefore(int i10, qb.b<? super lb.n> bVar) {
        if (!this.config.uplinkSentencePipeline()) {
            return lb.n.f10413a;
        }
        Object objAwaitBeforeSentence = this.sentencePipeline.awaitBeforeSentence(i10, new m0(this, 3), new g(this, 1), bVar);
        return objAwaitBeforeSentence == CoroutineSingletons.f10059a ? objAwaitBeforeSentence : lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean awaitSentencePipelineBefore$lambda$23(TtsCloudWsSession ttsCloudWsSession) {
        return ttsCloudWsSession.closed.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n awaitSentencePipelineBefore$lambda$24(TtsCloudWsSession ttsCloudWsSession, int i10) {
        LogModule logModule = LogModule.ABILITY;
        String str = ttsCloudWsSession.TAG;
        long jUplinkSentencePacingTimeoutMs = ttsCloudWsSession.config.uplinkSentencePacingTimeoutMs();
        String str2 = ttsCloudWsSession.currentTraceId;
        StringBuilder sbR = ai.onnxruntime.a.r(jUplinkSentencePacingTimeoutMs, "[TTS-Stream] sentence pipeline credit timeout (", "ms), forcing credit for sentence=", i10);
        sbR.append(", x-trace-id=");
        sbR.append(str2);
        AIEngineLogger.w(logModule, str, sbR.toString());
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r14, r0) == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitUplinkPacing(qb.b<? super lb.n> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.stepos.core.ability.speech.TtsCloudWsSession.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r15
            com.stepos.core.ability.speech.TtsCloudWsSession$awaitUplinkPacing$1 r0 = (com.stepos.core.ability.speech.TtsCloudWsSession.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.TtsCloudWsSession$awaitUplinkPacing$1 r0 = new com.stepos.core.ability.speech.TtsCloudWsSession$awaitUplinkPacing$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            long r4 = r0.J$2
            long r6 = r0.J$1
            long r8 = r0.J$0
            java.lang.Object r14 = r0.L$0
            com.stepos.core.ability.speech.TtsCloudWsSession r14 = (com.stepos.core.ability.speech.TtsCloudWsSession) r14
            kotlin.c.b(r15)
            goto L76
        L34:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L3c:
            kotlin.c.b(r15)
            goto L60
        L40:
            kotlin.c.b(r15)
            com.stepos.core.ability.speech.TtsCloudConfig r15 = r14.config
            boolean r15 = r15.uplinkAdaptivePacing()
            if (r15 != 0) goto L63
            com.stepos.core.ability.speech.TtsCloudConfig r14 = r14.config
            long r14 = r14.uplinkWireMinIntervalMs()
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 <= 0) goto L60
            r0.label = r4
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r14, r0)
            if (r14 != r1) goto L60
            goto Laa
        L60:
            lb.n r14 = lb.n.f10413a
            return r14
        L63:
            com.stepos.core.ability.speech.TtsCloudConfig r15 = r14.config
            long r4 = r15.uplinkMaxBacklogMs()
            com.stepos.core.ability.speech.TtsCloudConfig r15 = r14.config
            long r6 = r15.uplinkPacingMaxWaitMs()
            long r8 = android.os.SystemClock.elapsedRealtime()
            r12 = r8
            r8 = r4
            r4 = r12
        L76:
            java.util.concurrent.atomic.AtomicBoolean r15 = r14.closed
            boolean r15 = r15.get()
            if (r15 != 0) goto Lab
            long r10 = r14.estUplinkBacklogMs()
            int r15 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r15 > 0) goto L89
            lb.n r14 = lb.n.f10413a
            return r14
        L89:
            long r10 = android.os.SystemClock.elapsedRealtime()
            long r10 = r10 - r4
            int r15 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r15 < 0) goto L98
            r14.onPacingReleasedByCap(r6, r8)
            lb.n r14 = lb.n.f10413a
            return r14
        L98:
            r0.L$0 = r14
            r0.J$0 = r8
            r0.J$1 = r6
            r0.J$2 = r4
            r0.label = r3
            r10 = 200(0xc8, double:9.9E-322)
            java.lang.Object r15 = kotlinx.coroutines.DelayKt.delay(r10, r0)
            if (r15 != r1) goto L76
        Laa:
            return r1
        Lab:
            lb.n r14 = lb.n.f10413a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsCloudWsSession.awaitUplinkPacing(qb.b):java.lang.Object");
    }

    private final void cancelAudioCompleteFallback() {
        Job job = this.audioCompleteFallbackJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.audioCompleteFallbackJob = null;
        this.urgentAudioFallbackScheduled = false;
    }

    private final void cancelCommitTimeout() {
        synchronized (this.commitTimerLock) {
            try {
                Job job = this.commitTimeoutJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                this.commitTimeoutJob = null;
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void cancelFinishDrain() {
        this.finishDrainEngaged = false;
        this.finishDrainStartedAtMs = 0L;
        Job job = this.finishDrainJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.finishDrainJob = null;
    }

    private final void cancelParenTimeout() {
        synchronized (this.parenTimerLock) {
            try {
                Job job = this.parenTimeoutJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                this.parenTimeoutJob = null;
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object connect(qb.b<? super lb.n> r13) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsCloudWsSession.connect(qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (emitShapedAndReport(r8, r0) == r1) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object dispatchUplinkText(java.lang.String r8, qb.b<? super lb.n> r9) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsCloudWsSession.dispatchUplinkText(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitAudioComplete() {
        if (this.sessionFinishedEmitted.compareAndSet(false, true)) {
            cancelAudioCompleteFallback();
            boolean z = this.realAudioDoneReceived.get();
            boolean z3 = !z;
            LogModule logModule = LogModule.ABILITY;
            String str = this.TAG;
            String strNetDiag = netDiag();
            String str2 = this.currentTraceId;
            StringBuilder sb2 = new StringBuilder("[TTS-Stream][NET-DOWN] session summary truncated=");
            sb2.append(z3);
            sb2.append(": ");
            sb2.append(strNetDiag);
            sb2.append(", x-trace-id=");
            a0.a.z(sb2, str2, logModule, str);
            if (!z) {
                ai.onnxruntime.a.w("[TTS-Stream] audio truncated: completed without server audio.done (ws closed/failed before finish), x-trace-id=", this.currentTraceId, logModule, this.TAG);
            }
            emitEvent(new d.a(z3));
            releaseTransportQuietly();
        }
    }

    private final void emitEvent(i7.d dVar) {
        if (this.closed.get()) {
            return;
        }
        synchronized (this.emitChainLock) {
            this.emitChainTail = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new TtsCloudWsSession$emitEvent$1$1(this.emitChainTail, this, dVar, null), 3, null);
            lb.n nVar = lb.n.f10413a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitFailed(int i10, String str) {
        if (this.sessionFinishedEmitted.compareAndSet(false, true)) {
            cancelAudioCompleteFallback();
            AIEngineLogger.e(LogModule.ABILITY, this.TAG, a0.a.g("[TTS-Stream] terminal failure: code=", i10, ", ", str));
            emitEvent(new d.c(i10, CloudErrorUserMessage.INSTANCE.of(i10)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitInputClosed() {
        if (this.inputClosedEmitted.compareAndSet(false, true)) {
            if (!this.urgentAudioFallbackScheduled) {
                cancelAudioCompleteFallback();
                scheduleAudioCompleteFallback$default(this, "input closed", false, 2, null);
            }
            emitEvent(d.C0092d.f9574a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [int] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [int] */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0110 -> B:58:0x013a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x012b -> B:57:0x0133). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emitShaped(java.lang.String r17, qb.b<? super lb.n> r18) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsCloudWsSession.emitShaped(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emitShapedAndReport(java.lang.String r5, qb.b<? super lb.n> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ability.speech.TtsCloudWsSession.C03421
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ability.speech.TtsCloudWsSession$emitShapedAndReport$1 r0 = (com.stepos.core.ability.speech.TtsCloudWsSession.C03421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.TtsCloudWsSession$emitShapedAndReport$1 r0 = new com.stepos.core.ability.speech.TtsCloudWsSession$emitShapedAndReport$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.L$1
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r0.L$0
            com.stepos.core.ability.speech.TtsCloudWsSession r4 = (com.stepos.core.ability.speech.TtsCloudWsSession) r4
            kotlin.c.b(r6)
            goto L48
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.c.b(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.emitShaped(r5, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            zb.l<java.lang.String, lb.n> r4 = r4.onClientText
            if (r4 == 0) goto L56
            r4.invoke(r5)     // Catch: java.lang.Throwable -> L52
            lb.n r4 = lb.n.f10413a     // Catch: java.lang.Throwable -> L52
            goto L56
        L52:
            r4 = move-exception
            kotlin.c.a(r4)
        L56:
            lb.n r4 = lb.n.f10413a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsCloudWsSession.emitShapedAndReport(java.lang.String, qb.b):java.lang.Object");
    }

    private final void emitTextDoneIfNeeded(String str) {
        if (this.closed.get() || this.inputClosedEmitted.get() || !this.finishRequested.get() || hasUplinkPending()) {
            return;
        }
        cancelFinishDrain();
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("[TTS-Stream] text.done (", str, "): x-trace-id=", this.currentTraceId));
        TtsTextOutboundQueue ttsTextOutboundQueue = this.outboundQueue;
        if (ttsTextOutboundQueue != null) {
            ttsTextOutboundQueue.scheduleTextDone();
        } else {
            kotlin.jvm.internal.g.l("outboundQueue");
            throw null;
        }
    }

    private final void enqueueInbound(String str) {
        if (str.length() == 0) {
            return;
        }
        runOnUplinkChain(new C03431(str, null));
    }

    private final long estUplinkBacklogMs() {
        Double dValueOf = Double.valueOf(this.config.speed());
        if (dValueOf.doubleValue() <= 0.0d) {
            dValueOf = null;
        }
        long jUplinkEstMsPerChar = (long) (this.sentTextChars.get() * (this.config.uplinkEstMsPerChar() / (dValueOf != null ? dValueOf.doubleValue() : 1.0d)));
        Integer numValueOf = Integer.valueOf(this.config.sampleRate());
        Integer num = numValueOf.intValue() > 0 ? numValueOf : null;
        int iIntValue = ((num != null ? num.intValue() : 24000) * 2) / 1000;
        return jUplinkEstMsPerChar - (iIntValue > 0 ? this.receivedAudioBytes.get() / iIntValue : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finalizeInputDuringFinishTransportLoss(String str) {
        emitTextDoneIfNeeded(str);
        if (this.inputClosedEmitted.get() || !this.finishRequested.get()) {
            return;
        }
        AIEngineLogger.w(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("[TTS-Stream] InputClosed without wire text.done (", str, "): x-trace-id=", this.currentTraceId));
        emitInputClosed();
    }

    private final long finishDrainGraceMs() {
        if (this.config.finishTextDoneImmediately()) {
            return 0L;
        }
        return this.config.finishDrainMinMs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishDrainTick() {
        if (!this.closed.get() && !this.inputClosedEmitted.get() && this.finishRequested.get() && this.finishScheduled) {
            if (hasUplinkPending()) {
                scheduleFinishDrainCheck(200L);
                return;
            }
            long jFinishDrainGraceMs = finishDrainGraceMs();
            if (!this.finishDrainEngaged) {
                this.finishDrainEngaged = true;
                this.finishDrainStartedAtMs = SystemClock.elapsedRealtime();
                AIEngineLogger.i(LogModule.ABILITY, this.TAG, a0.a.h("[TTS-Stream] finish drain started: min=", jFinishDrainGraceMs, "ms, x-trace-id=", this.currentTraceId));
                scheduleFinishDrainCheck(jFinishDrainGraceMs);
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.finishDrainStartedAtMs;
            if (jElapsedRealtime >= jFinishDrainGraceMs) {
                AIEngineLogger.i(LogModule.ABILITY, this.TAG, a0.a.h("[TTS-Stream] finish grace elapsed (", jElapsedRealtime, "ms), sending text.done: x-trace-id=", this.currentTraceId));
                emitTextDoneIfNeeded("uplink drained");
            } else {
                long j10 = jFinishDrainGraceMs - jElapsedRealtime;
                scheduleFinishDrainCheck(j10 >= 200 ? j10 : 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushCommitGateHeld(String str) {
        if (this.commitGateEnabled) {
            cancelCommitTimeout();
            runOnUplinkChain(new C03441(str, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushParenHeld(String str) {
        cancelParenTimeout();
        runOnUplinkChain(new C03451(str, null));
    }

    private final void flushPendingText() {
        synchronized (this.lock) {
            if (this.pending.isEmpty()) {
                return;
            }
            List listO0 = kotlin.collections.a.O0(this.pending);
            this.pending.clear();
            Iterator it = listO0.iterator();
            while (it.hasNext()) {
                enqueueInbound((String) it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleServerEvent(String str) {
        TtsWsModels ttsWsModels = TtsWsModels.INSTANCE;
        Pair<String, String> pairEventTypeAndSession = ttsWsModels.eventTypeAndSession(str);
        String str2 = pairEventTypeAndSession.f9985a;
        String str3 = pairEventTypeAndSession.f9986b;
        if (!gc.q.t0(str3)) {
            this.sessionId = str3;
        }
        LogModule logModule = LogModule.ABILITY;
        a0.a.z(ai.onnxruntime.a.s("[TTS-Stream] ws event: x-trace-id=", this.currentTraceId, ", type=", str2, ", session_id="), str3, logModule, this.TAG);
        String forDiagLog = ttsWsModels.formatForDiagLog(str);
        AIEngineLogger.d(logModule, this.TAG, "[TTS-Stream] ws event raw: " + forDiagLog);
        TtsWsModels.ServerEvent serverEvent = ttsWsModels.parseServerEvent(str, this.config.sampleRate());
        if (serverEvent instanceof TtsWsModels.ServerEvent.ConnectionDone) {
            onConnectionDone(((TtsWsModels.ServerEvent.ConnectionDone) serverEvent).getSessionId());
            return;
        }
        if (kotlin.jvm.internal.g.b(serverEvent, TtsWsModels.ServerEvent.SessionReady.INSTANCE)) {
            onSessionReady();
            return;
        }
        if (serverEvent instanceof TtsWsModels.ServerEvent.AudioDelta) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.firstAudioAtMs == 0) {
                this.firstAudioAtMs = jElapsedRealtime;
            }
            long j10 = this.lastDownlinkAtMs > 0 ? jElapsedRealtime - this.lastDownlinkAtMs : 0L;
            this.lastDownlinkAtMs = jElapsedRealtime;
            TtsWsModels.ServerEvent.AudioDelta audioDelta = (TtsWsModels.ServerEvent.AudioDelta) serverEvent;
            if (audioDelta.getFinished()) {
                this.audioEndMarkerSeen.set(true);
            }
            this.receivedAudioBytes.addAndGet(audioDelta.getPcm().length);
            if (j10 > 800) {
                this.downlinkStallCount.incrementAndGet();
                String str4 = this.TAG;
                String strNetDiag = netDiag();
                String str5 = this.currentTraceId;
                StringBuilder sbO = a0.a.o("[TTS-Stream][NET-DOWN] downlink stall gap=", j10, "ms (weak downlink?): ", strNetDiag);
                sbO.append(", x-trace-id=");
                sbO.append(str5);
                AIEngineLogger.w(logModule, str4, sbO.toString());
            }
            if (this.config.uplinkSentencePipeline()) {
                this.sentencePipeline.onServerAudioDelta();
            }
            emitEvent(new d.b(audioDelta.getPcm(), audioDelta.getSampleRate()));
            return;
        }
        if (kotlin.jvm.internal.g.b(serverEvent, TtsWsModels.ServerEvent.SentenceEnd.INSTANCE)) {
            if (this.config.uplinkSentencePipeline()) {
                this.sentencePipeline.onServerSentenceEnd();
                return;
            }
            return;
        }
        if (kotlin.jvm.internal.g.b(serverEvent, TtsWsModels.ServerEvent.AudioComplete.INSTANCE)) {
            this.audioEndMarkerSeen.set(true);
            this.realAudioDoneReceived.set(true);
            cancelFinishDrain();
            cancelAudioCompleteFallback();
            emitTextDoneIfNeeded("audio complete");
            emitAudioComplete();
            return;
        }
        if (!kotlin.jvm.internal.g.b(serverEvent, TtsWsModels.ServerEvent.AudioPaused.INSTANCE)) {
            if (serverEvent instanceof TtsWsModels.ServerEvent.Error) {
                TtsWsModels.ServerEvent.Error error = (TtsWsModels.ServerEvent.Error) serverEvent;
                emitFailed(error.getCode(), error.getMessage());
                return;
            } else {
                if (!kotlin.jvm.internal.g.b(serverEvent, TtsWsModels.ServerEvent.Ignored.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                return;
            }
        }
        if (this.audioEndMarkerSeen.get() || this.realAudioDoneReceived.get()) {
            this.realAudioDoneReceived.set(true);
            cancelFinishDrain();
            cancelAudioCompleteFallback();
            emitTextDoneIfNeeded("audio paused after end marker");
            emitAudioComplete();
            return;
        }
        if (!this.config.isConversationMode()) {
            ai.onnxruntime.a.w("[TTS-Stream] audio.paused ignored (transient pause, no end marker yet); awaiting audio.done / ws close, x-trace-id=", this.currentTraceId, logModule, this.TAG);
            return;
        }
        if (this.config.uplinkSentencePipeline()) {
            this.sentencePipeline.onServerDrained();
        }
        AIEngineLogger.d(logModule, this.TAG, "[TTS-Stream] audio.paused (conversation): cloud drained already-sent text, sentencePipeline=" + this.config.uplinkSentencePipeline() + ", inFlight=" + this.uplinkShapeInFlight.get() + ", x-trace-id=" + this.currentTraceId);
    }

    private final boolean hasUplinkPending() {
        boolean zHasBuffered;
        if (this.uplinkShapeInFlight.get() > 0) {
            return true;
        }
        TtsTextOutboundQueue ttsTextOutboundQueue = this.outboundQueue;
        if (ttsTextOutboundQueue == null) {
            kotlin.jvm.internal.g.l("outboundQueue");
            throw null;
        }
        if (ttsTextOutboundQueue.hasPendingWork()) {
            return true;
        }
        if (!this.commitGateEnabled) {
            return false;
        }
        synchronized (this.commitLock) {
            zHasBuffered = this.commitGate.hasBuffered();
        }
        return zHasBuffered;
    }

    private final void maybeBeginFinishDrain(boolean z) {
        if (this.finishRequested.get() && this.finishScheduled && !this.inputClosedEmitted.get()) {
            if (this.finishDrainEngaged && z) {
                reanchorFinishDrain();
            } else {
                finishDrainTick();
            }
        }
    }

    public static /* synthetic */ void maybeBeginFinishDrain$default(TtsCloudWsSession ttsCloudWsSession, boolean z, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z = false;
        }
        ttsCloudWsSession.maybeBeginFinishDrain(z);
    }

    private final void maybeInjectFinishTerminator() {
        if (this.config.uplinkTerminateOnFinish() && this.sentTextChars.get() > 0 && !this.lastUplinkEndedSentence && !this.lastUplinkHadUnclosedParen && this.finishTerminatorInjected.compareAndSet(false, true)) {
            String strUplinkFinishTerminator = this.config.uplinkFinishTerminator();
            if (strUplinkFinishTerminator.length() == 0) {
                return;
            }
            TtsTextOutboundQueue ttsTextOutboundQueue = this.outboundQueue;
            if (ttsTextOutboundQueue == null) {
                kotlin.jvm.internal.g.l("outboundQueue");
                throw null;
            }
            ttsTextOutboundQueue.enqueueDelta(strUplinkFinishTerminator);
            this.sentTextChars.addAndGet(strUplinkFinishTerminator.length());
            this.lastUplinkEndedSentence = true;
            AIEngineLogger.i(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("[TTS-Stream] finish terminator injected ('", strUplinkFinishTerminator, "') to force cloud to synthesize trailing fragment, x-trace-id=", this.currentTraceId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String netDiag() {
        long j10;
        double d8;
        Object objA;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = this.lastUplinkSendAtMs > 0 ? jElapsedRealtime - this.lastUplinkSendAtMs : -1L;
        long j12 = this.lastDownlinkAtMs > 0 ? jElapsedRealtime - this.lastDownlinkAtMs : -1L;
        long j13 = this.wsOpenedAtMs > 0 ? jElapsedRealtime - this.wsOpenedAtMs : -1L;
        int iSampleRate = this.config.sampleRate();
        Integer numValueOf = Integer.valueOf(iSampleRate);
        if (iSampleRate <= 0) {
            numValueOf = null;
        }
        int iIntValue = ((numValueOf != null ? numValueOf.intValue() : 24000) * 2) / 1000;
        long j14 = iIntValue > 0 ? this.receivedAudioBytes.get() / iIntValue : 0L;
        long j15 = this.firstAudioAtMs > 0 ? jElapsedRealtime - this.firstAudioAtMs : 0L;
        if (j15 > 0) {
            j10 = 0;
            d8 = j14 / j15;
        } else {
            j10 = 0;
            d8 = -1.0d;
        }
        try {
            CloudWebSocketClient.Session session = this.session;
            objA = Long.valueOf(session != null ? session.queuedBytes() : j10);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object objValueOf = Long.valueOf(j10);
        if (objA instanceof Result.Failure) {
            objA = objValueOf;
        }
        long jLongValue = ((Number) objA).longValue();
        String str = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d8)}, 1));
        int i10 = this.downlinkStallCount.get();
        StringBuilder sbQ = ai.onnxruntime.a.q(j11, "idleSend=", "ms idleRecv=");
        sbQ.append(j12);
        a0.a.s(j13, "ms connAge=", "ms recvAudio=", sbQ);
        sbQ.append(j14);
        a0.a.s(j15, "ms/wall=", "ms rtf=", sbQ);
        com.stepos.core.ota.d.p(jLongValue, str, " uplinkQueued=", sbQ);
        sbQ.append("B stalls=");
        sbQ.append(i10);
        return sbQ.toString();
    }

    private final int netParenDepth(String str) {
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '(') {
                i10++;
            } else if (cCharAt == ')' && i10 > 0) {
                i10--;
            }
        }
        return i10;
    }

    private final void onConnectionDone(String str) {
        this.sessionId = str;
        TtsTextOutboundQueue ttsTextOutboundQueue = this.outboundQueue;
        if (ttsTextOutboundQueue == null) {
            kotlin.jvm.internal.g.l("outboundQueue");
            throw null;
        }
        ttsTextOutboundQueue.bindSession(str);
        this.connectionDoneAtMs = SystemClock.elapsedRealtime();
        long j10 = 0;
        if (this.wsOpenedAtMs > 0) {
            long j11 = this.connectionDoneAtMs - this.wsOpenedAtMs;
            if (j11 >= 0) {
                j10 = j11;
            }
        } else {
            j10 = -1;
        }
        this.correlationState = new CloudSessionCorrelationState(str, CloudCorrelationSource.TTS_WS_CONNECTION_SESSION_ID, this.currentTraceId, this.gatewayTraceId, 0, null, this.headerFetchMs, this.connectToOpenMs, j10, 0L, 560, null);
        sendWireFrame(TtsWsModels.INSTANCE.buildTtsCreate(this.config, str));
    }

    private final void onPacingReleasedByCap(long j10, long j11) {
        int iIncrementAndGet = this.pacingCapReleaseCount.incrementAndGet();
        if (iIncrementAndGet == 1 || iIncrementAndGet % 10 == 0) {
            LogModule logModule = LogModule.ABILITY;
            String str = this.TAG;
            long jEstUplinkBacklogMs = estUplinkBacklogMs();
            String strNetDiag = netDiag();
            String str2 = this.currentTraceId;
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "[TTS-Stream][NET-UP] pacing released by cap (", "ms), not by backlog (est=");
            sbQ.append(jEstUplinkBacklogMs);
            a0.a.s(j11, "ms > max=", "ms), count=", sbQ);
            h0.e.h(iIncrementAndGet, ": pacing has degenerated into a fixed-interval timer; uplink may outrun downlink and go silent long enough for the proxy to close with 1001. ", strNetDiag, ", x-trace-id=", sbQ);
            a0.a.x(sbQ, str2, logModule, str);
        }
    }

    private final void onSessionReady() {
        zb.l<CloudSessionCorrelationState, lb.n> onCorrelationEstablished;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = 0;
        if (this.connectionDoneAtMs > 0) {
            long j11 = jElapsedRealtime - this.connectionDoneAtMs;
            if (j11 >= 0) {
                j10 = j11;
            }
        } else {
            j10 = -1;
        }
        long j12 = j10;
        CloudSessionCorrelationState cloudSessionCorrelationState = this.correlationState;
        this.correlationState = cloudSessionCorrelationState.copy((511 & 1) != 0 ? cloudSessionCorrelationState.cloudCorrelationId : null, (511 & 2) != 0 ? cloudSessionCorrelationState.source : null, (511 & 4) != 0 ? cloudSessionCorrelationState.clientDebugTraceId : null, (511 & 8) != 0 ? cloudSessionCorrelationState.gatewayTraceId : null, (511 & 16) != 0 ? cloudSessionCorrelationState.connectionGeneration : 0, (511 & 32) != 0 ? cloudSessionCorrelationState.asyncTaskId : null, (511 & 64) != 0 ? cloudSessionCorrelationState.headerFetchMs : 0L, (511 & TraceIdKeys.MAX_LENGTH) != 0 ? cloudSessionCorrelationState.connectToOpenMs : 0L, (511 & 256) != 0 ? cloudSessionCorrelationState.openToHandshakeAckMs : 0L, (511 & VadSessionManager.FRAME_BYTES) != 0 ? cloudSessionCorrelationState.handshakeAckToReadyMs : j12);
        if (!gc.q.t0(this.correlationState.getCloudCorrelationId()) && (onCorrelationEstablished = getOnCorrelationEstablished()) != null) {
            onCorrelationEstablished.invoke(this.correlationState);
        }
        synchronized (this.lock) {
            this.ready.set(true);
            lb.n nVar = lb.n.f10413a;
        }
        flushPendingText();
        emitEvent(d.e.f9575a);
        if (this.finishRequested.get()) {
            scheduleFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUplinkFeedComplete() {
        boolean zHasBuffered;
        if (this.finishRequested.get() && this.finishScheduled) {
            if (this.commitGateEnabled) {
                synchronized (this.commitLock) {
                    zHasBuffered = this.commitGate.hasBuffered();
                }
                if (zHasBuffered) {
                    flushCommitGateHeld("finish drain");
                    return;
                }
            }
            tryInjectFinishTerminator();
            maybeBeginFinishDrain(true);
        }
    }

    private final void reanchorFinishDrain() {
        if (!this.finishDrainEngaged || this.inputClosedEmitted.get()) {
            return;
        }
        this.finishDrainStartedAtMs = SystemClock.elapsedRealtime();
        long jFinishDrainGraceMs = finishDrainGraceMs();
        AIEngineLogger.d(LogModule.ABILITY, this.TAG, a0.a.h("[TTS-Stream] finish drain re-anchored after uplink completion: min=", jFinishDrainGraceMs, "ms, x-trace-id=", this.currentTraceId));
        scheduleFinishDrainCheck(jFinishDrainGraceMs);
    }

    private final void releaseTransportQuietly() {
        this.ready.set(false);
        try {
            CloudWebSocketClient.Session session = this.session;
            if (session != null) {
                CloudWebSocketClient.Session.DefaultImpls.close$default(session, 0, null, 3, null);
                lb.n nVar = lb.n.f10413a;
            }
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    private final void runOnUplinkChain(zb.l<? super qb.b<? super lb.n>, ? extends Object> lVar) {
        this.uplinkShapeInFlight.incrementAndGet();
        synchronized (this.uplinkChainLock) {
            this.uplinkChainTail = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new TtsCloudWsSession$runOnUplinkChain$1$1(this.uplinkChainTail, this, lVar, null), 3, null);
            lb.n nVar = lb.n.f10413a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleAudioCompleteFallback(String str, boolean z) {
        if (this.sessionFinishedEmitted.get()) {
            return;
        }
        Job job = this.audioCompleteFallbackJob;
        if (job != null && job.isActive()) {
            if (!z) {
                return;
            } else {
                cancelAudioCompleteFallback();
            }
        }
        if (z) {
            this.urgentAudioFallbackScheduled = true;
        }
        this.audioCompleteFallbackJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C03461(z, this, str, null), 3, null);
    }

    public static /* synthetic */ void scheduleAudioCompleteFallback$default(TtsCloudWsSession ttsCloudWsSession, String str, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        ttsCloudWsSession.scheduleAudioCompleteFallback(str, z);
    }

    private final void scheduleFinish() {
        flushParenHeld("finish");
        flushCommitGateHeld("finish");
        this.finishScheduled = true;
        tryInjectFinishTerminator();
        scheduleAudioCompleteFallback$default(this, "finish scheduled", false, 2, null);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C03471(null), 3, null);
    }

    private final void scheduleFinishDrainCheck(long j10) {
        if (this.closed.get()) {
            return;
        }
        Job job = this.finishDrainJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.finishDrainJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C03481(j10, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void sendWireFrame(java.lang.String r10) {
        /*
            r9 = this;
            com.stepos.core.ability.speech.TtsWsModels r0 = com.stepos.core.ability.speech.TtsWsModels.INSTANCE
            java.lang.String r1 = r0.wireEventType(r10)
            java.util.concurrent.atomic.AtomicBoolean r2 = r9.ready
            boolean r2 = r2.get()
            if (r2 != 0) goto L33
            java.lang.String r2 = "tts.create"
            boolean r2 = kotlin.jvm.internal.g.b(r1, r2)
            if (r2 != 0) goto L33
            com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r0 = r9.TAG
            java.lang.String r2 = r9.currentTraceId
            java.lang.String r3 = "[TTS-Stream] drop ws frame ("
            java.lang.String r4 = "): transport not ready, x-trace-id="
            java.lang.String r2 = ai.onnxruntime.a.l(r3, r1, r4, r2)
            com.stepos.core.common.log.AIEngineLogger.w(r10, r0, r2)
            java.lang.String r10 = "tts.text.done"
            boolean r10 = kotlin.jvm.internal.g.b(r1, r10)
            if (r10 == 0) goto Ldf
            r9.emitInputClosed()
            return
        L33:
            java.lang.String r2 = r9.sessionId
            java.lang.String r3 = ", "
            if (r2 == 0) goto L4b
            boolean r4 = gc.q.t0(r2)
            if (r4 != 0) goto L40
            goto L41
        L40:
            r2 = 0
        L41:
            if (r2 == 0) goto L4b
            java.lang.String r4 = "session_id="
            java.lang.String r2 = a0.a.k(r4, r2, r3)
            if (r2 != 0) goto L4d
        L4b:
            java.lang.String r2 = ""
        L4d:
            com.stepos.core.common.log.LogModule r4 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r5 = r9.TAG
            com.stepos.core.common.cloud.CloudRequestHeaderLog r6 = com.stepos.core.common.cloud.CloudRequestHeaderLog.INSTANCE
            java.util.Map<java.lang.String, java.lang.String> r7 = r9.connectHeaders
            java.lang.String r6 = r6.format(r7)
            java.lang.String r7 = "[TTS-Stream][DIAG] request-headers (ws-send/"
            java.lang.String r8 = "): "
            java.lang.String r2 = h0.e.c(r7, r1, r8, r2, r6)
            com.stepos.core.common.log.AIEngineLogger.i(r4, r5, r2)
            java.lang.String r2 = r9.TAG
            java.lang.String r0 = r0.formatForDiagLog(r10)
            java.lang.String r5 = "[TTS-Stream][DIAG] → "
            h0.e.k(r5, r0, r4, r2)
            com.stepos.core.common.cloud.CloudWebSocketClient$Session r0 = r9.session
            if (r0 == 0) goto L76
            r0.sendText(r10)
        L76:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r9.lastUplinkSendAtMs = r4
            r4 = 0
            com.stepos.core.common.cloud.CloudWebSocketClient$Session r10 = r9.session     // Catch: java.lang.Throwable -> L87
            if (r10 == 0) goto L89
            long r6 = r10.queuedBytes()     // Catch: java.lang.Throwable -> L87
            goto L8a
        L87:
            r10 = move-exception
            goto L8f
        L89:
            r6 = r4
        L8a:
            java.lang.Long r10 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L87
            goto L93
        L8f:
            kotlin.Result$Failure r10 = kotlin.c.a(r10)
        L93:
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            boolean r2 = r10 instanceof kotlin.Result.Failure
            if (r2 == 0) goto L9c
            r10 = r0
        L9c:
            java.lang.Number r10 = (java.lang.Number) r10
            long r4 = r10.longValue()
            r6 = 16384(0x4000, double:8.095E-320)
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            java.lang.String r0 = ", x-trace-id="
            if (r10 <= 0) goto Lc4
            com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r2 = r9.TAG
            java.lang.String r6 = r9.netDiag()
            java.lang.String r9 = r9.currentTraceId
            java.lang.String r7 = "[TTS-Stream][NET-UP] uplink backpressure (weak uplink?): queuedBytes="
            java.lang.String r8 = " after "
            java.lang.StringBuilder r1 = a0.a.o(r7, r4, r8, r1)
            java.lang.String r9 = com.stepos.core.ota.d.j(r1, r3, r6, r0, r9)
            com.stepos.core.common.log.AIEngineLogger.w(r10, r2, r9)
            goto Ldf
        Lc4:
            com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r2 = r9.TAG
            java.lang.String r9 = r9.currentTraceId
            java.lang.String r3 = "[TTS-Stream][NET-UP] ws-send "
            java.lang.String r6 = " queuedBytes="
            java.lang.StringBuilder r1 = com.stepos.core.ota.d.l(r3, r4, r1, r6)
            r1.append(r0)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.stepos.core.common.log.AIEngineLogger.d(r10, r2, r9)
        Ldf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsCloudWsSession.sendWireFrame(java.lang.String):void");
    }

    private final void tryInjectFinishTerminator() {
        if (this.uplinkShapeInFlight.get() > 0) {
            return;
        }
        maybeInjectFinishTerminator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void warnIfUplinkIdleNearProxyClose(long j10, long j11) {
        if (this.lastUplinkSendAtMs > 0 && j11 < 2000) {
            long j12 = j10 - this.lastUplinkSendAtMs;
            if (j12 >= UPLINK_IDLE_PROXY_CLOSE_WARN_MS && this.uplinkIdleWarned.compareAndSet(false, true)) {
                LogModule logModule = LogModule.ABILITY;
                String str = this.TAG;
                String strNetDiag = netDiag();
                String str2 = this.currentTraceId;
                StringBuilder sbQ = ai.onnxruntime.a.q(j12, "[TTS-Stream][NET-UP] uplink idle ", "ms while downlink still streaming (");
                ai.onnxruntime.a.u(j11, "ms since last audio): proxy may close with 1001 and truncate the tail; consider raising uplink.pacing_max_wait_ms / lowering max_backlog_ms. ", strNetDiag, sbQ);
                sbQ.append(", x-trace-id=");
                sbQ.append(str2);
                AIEngineLogger.w(logModule, str, sbQ.toString());
            }
        }
    }

    public void cancel() {
        if (this.closed.compareAndSet(false, true)) {
            cancelAudioCompleteFallback();
            cancelFinishDrain();
            cancelParenTimeout();
            cancelCommitTimeout();
            this.finishScheduled = false;
            synchronized (this.commitLock) {
                this.commitGate.takeAll();
            }
            this.sentencePipeline.reset();
            TtsTextOutboundQueue ttsTextOutboundQueue = this.outboundQueue;
            if (ttsTextOutboundQueue == null) {
                kotlin.jvm.internal.g.l("outboundQueue");
                throw null;
            }
            ttsTextOutboundQueue.reset();
            try {
                CloudWebSocketClient.Session session = this.session;
                if (session != null) {
                    session.cancel();
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            SendChannel.DefaultImpls.close$default(this.eventChannel, null, 1, null);
            CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        }
    }

    @Override // com.stepos.core.common.cloud.ObservableCloudSession
    public CloudSessionCorrelationState correlationState() {
        return this.correlationState;
    }

    public void finish() {
        if (this.finishRequested.compareAndSet(false, true) && this.ready.get()) {
            scheduleFinish();
        }
    }

    public Flow<i7.d> getEvents() {
        return this.events;
    }

    @Override // com.stepos.core.common.cloud.ObservableCloudSession
    public zb.l<CloudSessionCorrelationState, lb.n> getOnCorrelationEstablished() {
        return this.onCorrelationEstablished;
    }

    @Override // com.stepos.core.common.cloud.ObservableCloudSession
    public boolean isConnected() {
        return this.session != null && this.ready.get();
    }

    @Override // com.stepos.core.common.cloud.ObservableCloudSession
    public void setOnCorrelationEstablished(zb.l<? super CloudSessionCorrelationState, lb.n> lVar) {
        this.onCorrelationEstablished = lVar;
    }

    public void start() {
        if (gc.q.t0(this.config.getWsEndpoint())) {
            emitFailed(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED, "ws endpoint not configured");
        } else {
            AIEngineLogger.i(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("[TTS-Stream] start: connecting ws, model=", this.config.model(), ", voice=", this.config.voice()));
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C03491(null), 3, null);
        }
    }

    public void feed(i7.b chunk) {
        kotlin.jvm.internal.g.f(chunk, "chunk");
        if (this.closed.get() || chunk.f9552a.length() == 0) {
            return;
        }
        synchronized (this.lock) {
            if (!this.ready.get()) {
                this.pending.add(chunk.f9552a);
            } else {
                lb.n nVar = lb.n.f10413a;
                enqueueInbound(chunk.f9552a);
            }
        }
    }

    public /* synthetic */ TtsCloudWsSession(TtsCloudConfig ttsCloudConfig, zb.l lVar, zb.a aVar, int i10, String str, zb.l lVar2, int i11, kotlin.jvm.internal.e eVar) {
        this(ttsCloudConfig, lVar, (i11 & 4) != 0 ? new a(4) : aVar, (i11 & 8) != 0 ? 64 : i10, (i11 & 16) != 0 ? null : str, (i11 & 32) != 0 ? null : lVar2);
    }
}
