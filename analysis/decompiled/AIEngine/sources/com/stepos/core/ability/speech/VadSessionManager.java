package com.stepos.core.ability.speech;

import android.content.Context;
import android.os.Bundle;
import com.stepos.core.ability.speech.VadLevelAggregator;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.VadParamKeys;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadSessionManager {
    private static final int CHANNEL_CAPACITY = 64;
    public static final Companion Companion = new Companion(null);
    private static final long DROP_LOG_WINDOW = 50;
    public static final String ERR_ENGINE_UNAVAILABLE = "ten-vad engine unavailable";
    public static final String ERR_UNSUPPORTED_FORMAT = "stepos-vad requires 16000Hz mono PCM16;";
    private static final int FLOW_BUFFER_CAPACITY = 64;
    public static final int FRAME_BYTES = 512;
    public static final int FRAME_SAMPLES = 256;
    private static final int MAX_TOMBSTONES = 64;
    private static final String MODEL_ID = "ten-vad-session";
    public static final int TARGET_CHANNEL_COUNT = 1;
    public static final int TARGET_SAMPLE_RATE = 16000;
    private final zb.p<Context, qb.b<? super b7.a>, Object> engineFactory;
    private final CoroutineScope reorderScope;
    private final ConcurrentHashMap<String, Session> sessions;
    private final String tag;
    private final Set<String> terminated;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Session {
        private volatile boolean aborted;
        private final Channel<byte[]> channel;
        private volatile int channelCount;
        private final AtomicLong dropped;
        private volatile AsrFeedReorderBuffer reorder;
        private volatile int sampleRate;

        public Session() {
            this(null, 0, 0, false, null, null, 63, null);
        }

        public final boolean getAborted() {
            return this.aborted;
        }

        public final Channel<byte[]> getChannel() {
            return this.channel;
        }

        public final int getChannelCount() {
            return this.channelCount;
        }

        public final AtomicLong getDropped() {
            return this.dropped;
        }

        public final AsrFeedReorderBuffer getReorder() {
            return this.reorder;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public final void setAborted(boolean z) {
            this.aborted = z;
        }

        public final void setChannelCount(int i10) {
            this.channelCount = i10;
        }

        public final void setReorder(AsrFeedReorderBuffer asrFeedReorderBuffer) {
            this.reorder = asrFeedReorderBuffer;
        }

        public final void setSampleRate(int i10) {
            this.sampleRate = i10;
        }

        public Session(Channel<byte[]> channel, int i10, int i11, boolean z, AtomicLong dropped, AsrFeedReorderBuffer asrFeedReorderBuffer) {
            kotlin.jvm.internal.g.f(channel, "channel");
            kotlin.jvm.internal.g.f(dropped, "dropped");
            this.channel = channel;
            this.sampleRate = i10;
            this.channelCount = i11;
            this.aborted = z;
            this.dropped = dropped;
            this.reorder = asrFeedReorderBuffer;
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
            	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        public /* synthetic */ Session(kotlinx.coroutines.channels.Channel r4, int r5, int r6, boolean r7, java.util.concurrent.atomic.AtomicLong r8, com.stepos.core.ability.speech.AsrFeedReorderBuffer r9, int r10, kotlin.jvm.internal.e r11) {
            /*
                r3 = this;
                r11 = r10 & 1
                r0 = 0
                if (r11 == 0) goto Lc
                r4 = 64
                r11 = 6
                kotlinx.coroutines.channels.Channel r4 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r4, r0, r0, r11, r0)
            Lc:
                r11 = r10 & 2
                r1 = 0
                if (r11 == 0) goto L12
                r5 = r1
            L12:
                r11 = r10 & 4
                if (r11 == 0) goto L17
                r6 = r1
            L17:
                r11 = r10 & 8
                if (r11 == 0) goto L1c
                r7 = r1
            L1c:
                r11 = r10 & 16
                if (r11 == 0) goto L27
                java.util.concurrent.atomic.AtomicLong r8 = new java.util.concurrent.atomic.AtomicLong
                r1 = 0
                r8.<init>(r1)
            L27:
                r10 = r10 & 32
                if (r10 == 0) goto L33
                r11 = r0
                r9 = r7
                r10 = r8
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                goto L3a
            L33:
                r11 = r9
                r10 = r8
                r8 = r6
                r9 = r7
                r6 = r4
                r7 = r5
                r5 = r3
            L3a:
                r5.<init>(r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadSessionManager.Session.<init>(kotlinx.coroutines.channels.Channel, int, int, boolean, java.util.concurrent.atomic.AtomicLong, com.stepos.core.ability.speech.AsrFeedReorderBuffer, int, kotlin.jvm.internal.e):void");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadSessionManager", f = "VadSessionManager.kt", l = {459}, m = "closeSession")
    /* renamed from: com.stepos.core.ability.speech.VadSessionManager$closeSession$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return VadSessionManager.this.closeSession(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadSessionManager", f = "VadSessionManager.kt", l = {481}, m = "createEngine")
    /* renamed from: com.stepos.core.ability.speech.VadSessionManager$createEngine$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03641 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03641(qb.b<? super C03641> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VadSessionManager.this.createEngine(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadSessionManager", f = "VadSessionManager.kt", l = {527}, m = "inferProbability")
    /* renamed from: com.stepos.core.ability.speech.VadSessionManager$inferProbability$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03651 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C03651(qb.b<? super C03651> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VadSessionManager.this.inferProbability(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadSessionManager$openSession$1", f = "VadSessionManager.kt", l = {192, 206, 206, 208, 336, 239, 253, 257, 336, 330, 336, 336}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.VadSessionManager$openSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03661 extends SuspendLambda implements zb.p<ProducerScope<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ int $channelCountHint;
        final /* synthetic */ VadRuntimeConfig $config;
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $feedOrdered;
        final /* synthetic */ String $inferId;
        final /* synthetic */ int $sampleRateHint;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "com.stepos.core.ability.speech.VadSessionManager$openSession$1$1", f = "VadSessionManager.kt", l = {268, 299, 308}, m = "invokeSuspend")
        /* renamed from: com.stepos.core.ability.speech.VadSessionManager$openSession$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00561 extends SuspendLambda implements zb.p<short[], qb.b<? super lb.n>, Object> {
            final /* synthetic */ ProducerScope<Result<d.q>> $$this$channelFlow;
            final /* synthetic */ VadLevelAggregator $aggregator;
            final /* synthetic */ Ref$LongRef $consumedSamples;
            final /* synthetic */ VadEndpointDetector $detector;
            final /* synthetic */ Ref$BooleanRef $ended;
            final /* synthetic */ b7.a $engine;
            final /* synthetic */ VadAdaptiveSpeechGate $gate;
            final /* synthetic */ Ref$LongRef $inferFrames;
            final /* synthetic */ String $inferId;
            final /* synthetic */ Ref$LongRef $inferNsMax;
            final /* synthetic */ Ref$LongRef $inferNsSum;
            final /* synthetic */ Ref$LongRef $levelDropped;
            final /* synthetic */ Method $processMethod;
            final /* synthetic */ Session $session;
            long J$0;
            long J$1;
            /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            final /* synthetic */ VadSessionManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00561(Ref$BooleanRef ref$BooleanRef, Ref$LongRef ref$LongRef, ProducerScope<? super Result<d.q>> producerScope, VadAdaptiveSpeechGate vadAdaptiveSpeechGate, VadLevelAggregator vadLevelAggregator, VadEndpointDetector vadEndpointDetector, VadSessionManager vadSessionManager, String str, Ref$LongRef ref$LongRef2, Session session, Ref$LongRef ref$LongRef3, Ref$LongRef ref$LongRef4, Ref$LongRef ref$LongRef5, b7.a aVar, Method method, qb.b<? super C00561> bVar) {
                super(2, bVar);
                this.$ended = ref$BooleanRef;
                this.$consumedSamples = ref$LongRef;
                this.$$this$channelFlow = producerScope;
                this.$gate = vadAdaptiveSpeechGate;
                this.$aggregator = vadLevelAggregator;
                this.$detector = vadEndpointDetector;
                this.this$0 = vadSessionManager;
                this.$inferId = str;
                this.$levelDropped = ref$LongRef2;
                this.$session = session;
                this.$inferNsSum = ref$LongRef3;
                this.$inferNsMax = ref$LongRef4;
                this.$inferFrames = ref$LongRef5;
                this.$engine = aVar;
                this.$processMethod = method;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
                C00561 c00561 = new C00561(this.$ended, this.$consumedSamples, this.$$this$channelFlow, this.$gate, this.$aggregator, this.$detector, this.this$0, this.$inferId, this.$levelDropped, this.$session, this.$inferNsSum, this.$inferNsMax, this.$inferFrames, this.$engine, this.$processMethod, bVar);
                c00561.L$0 = obj;
                return c00561;
            }

            /* JADX WARN: Code restructure failed: missing block: B:37:0x0162, code lost:
            
                if (r2.send(r5, r0) == r1) goto L18;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r28) {
                /*
                    Method dump skipped, instructions count: 522
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadSessionManager.C03661.C00561.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // zb.p
            public final Object invoke(short[] sArr, qb.b<? super lb.n> bVar) {
                return ((C00561) create(sArr, bVar)).invokeSuspend(lb.n.f10413a);
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "com.stepos.core.ability.speech.VadSessionManager$openSession$1$3", f = "VadSessionManager.kt", l = {336}, m = "invokeSuspend")
        /* renamed from: com.stepos.core.ability.speech.VadSessionManager$openSession$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
            final /* synthetic */ String $inferId;
            final /* synthetic */ Ref$ObjectRef<b7.a> $model;
            int label;
            final /* synthetic */ VadSessionManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(VadSessionManager vadSessionManager, String str, Ref$ObjectRef<b7.a> ref$ObjectRef, qb.b<? super AnonymousClass3> bVar) {
                super(2, bVar);
                this.this$0 = vadSessionManager;
                this.$inferId = str;
                this.$model = ref$ObjectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
                return new AnonymousClass3(this.this$0, this.$inferId, this.$model, bVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                int i10 = this.label;
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    VadSessionManager vadSessionManager = this.this$0;
                    String str = this.$inferId;
                    b7.a aVar = this.$model.f10076a;
                    this.label = 1;
                    if (vadSessionManager.closeSession(str, aVar, this) == coroutineSingletons) {
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
                return ((AnonymousClass3) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03661(String str, int i10, int i11, boolean z, VadRuntimeConfig vadRuntimeConfig, Context context, qb.b<? super C03661> bVar) {
            super(2, bVar);
            this.$inferId = str;
            this.$sampleRateHint = i10;
            this.$channelCountHint = i11;
            this.$feedOrdered = z;
            this.$config = vadRuntimeConfig;
            this.$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Session invokeSuspend$lambda$0(String str) {
            return new Session(null, 0, 0, false, null, null, 63, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Session invokeSuspend$lambda$1(zb.l lVar, Object obj) {
            return (Session) lVar.invoke(obj);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03661 c03661 = VadSessionManager.this.new C03661(this.$inferId, this.$sampleRateHint, this.$channelCountHint, this.$feedOrdered, this.$config, this.$context, bVar);
            c03661.L$0 = obj;
            return c03661;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Result<? extends d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return invoke2((ProducerScope<? super Result<d.q>>) producerScope, bVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:106:0x03c7  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x03f4  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x03f5  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x03f8 A[Catch: all -> 0x02b0, TryCatch #5 {all -> 0x02b0, blocks: (B:107:0x03e3, B:108:0x03e5, B:113:0x03f8, B:115:0x03ff, B:120:0x0412, B:87:0x02f5, B:82:0x02d0, B:84:0x02d4, B:92:0x0311, B:94:0x033e, B:96:0x034b, B:71:0x02ab, B:79:0x02bc), top: B:189:0x02ab }] */
        /* JADX WARN: Removed duplicated region for block: B:114:0x03fd  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x040e  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x040f  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x0412 A[Catch: all -> 0x02b0, TRY_LEAVE, TryCatch #5 {all -> 0x02b0, blocks: (B:107:0x03e3, B:108:0x03e5, B:113:0x03f8, B:115:0x03ff, B:120:0x0412, B:87:0x02f5, B:82:0x02d0, B:84:0x02d4, B:92:0x0311, B:94:0x033e, B:96:0x034b, B:71:0x02ab, B:79:0x02bc), top: B:189:0x02ab }] */
        /* JADX WARN: Removed duplicated region for block: B:122:0x0419  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x04a2  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x04a7  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x0538  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x053a  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x0575 A[Catch: all -> 0x0546, TRY_LEAVE, TryCatch #0 {all -> 0x0546, blocks: (B:170:0x0639, B:156:0x056f, B:158:0x0575, B:163:0x05ae, B:165:0x05b4, B:167:0x05c3, B:142:0x04bb), top: B:183:0x04bb }] */
        /* JADX WARN: Removed duplicated region for block: B:163:0x05ae A[Catch: all -> 0x0546, TRY_ENTER, TryCatch #0 {all -> 0x0546, blocks: (B:170:0x0639, B:156:0x056f, B:158:0x0575, B:163:0x05ae, B:165:0x05b4, B:167:0x05c3, B:142:0x04bb), top: B:183:0x04bb }] */
        /* JADX WARN: Removed duplicated region for block: B:198:0x0294 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:211:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:213:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:214:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x02af  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x02b7  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x02cf  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x02d0 A[Catch: all -> 0x02b0, PHI: r0 r2 r3 r4 r5
          0x02d0: PHI (r0v23 com.stepos.core.ability.speech.VadSessionManager$Session) = 
          (r0v15 com.stepos.core.ability.speech.VadSessionManager$Session)
          (r0v30 com.stepos.core.ability.speech.VadSessionManager$Session)
         binds: [B:80:0x02cd, B:37:0x013a] A[DONT_GENERATE, DONT_INLINE]
          0x02d0: PHI (r2v19 kotlinx.coroutines.channels.ProducerScope) = (r2v14 kotlinx.coroutines.channels.ProducerScope), (r2v20 kotlinx.coroutines.channels.ProducerScope) binds: [B:80:0x02cd, B:37:0x013a] A[DONT_GENERATE, DONT_INLINE]
          0x02d0: PHI (r3v18 kotlin.jvm.internal.Ref$ObjectRef) = (r3v13 kotlin.jvm.internal.Ref$ObjectRef), (r3v20 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:80:0x02cd, B:37:0x013a] A[DONT_GENERATE, DONT_INLINE]
          0x02d0: PHI (r4v27 kotlin.coroutines.intrinsics.CoroutineSingletons) = (r4v21 kotlin.coroutines.intrinsics.CoroutineSingletons), (r4v30 kotlin.coroutines.intrinsics.CoroutineSingletons) binds: [B:80:0x02cd, B:37:0x013a] A[DONT_GENERATE, DONT_INLINE]
          0x02d0: PHI (r5v21 java.lang.Object) = (r5v14 java.lang.Object), (r5v26 java.lang.Object) binds: [B:80:0x02cd, B:37:0x013a] A[DONT_GENERATE, DONT_INLINE], TryCatch #5 {all -> 0x02b0, blocks: (B:107:0x03e3, B:108:0x03e5, B:113:0x03f8, B:115:0x03ff, B:120:0x0412, B:87:0x02f5, B:82:0x02d0, B:84:0x02d4, B:92:0x0311, B:94:0x033e, B:96:0x034b, B:71:0x02ab, B:79:0x02bc), top: B:189:0x02ab }] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x02d4 A[Catch: all -> 0x02b0, TryCatch #5 {all -> 0x02b0, blocks: (B:107:0x03e3, B:108:0x03e5, B:113:0x03f8, B:115:0x03ff, B:120:0x0412, B:87:0x02f5, B:82:0x02d0, B:84:0x02d4, B:92:0x0311, B:94:0x033e, B:96:0x034b, B:71:0x02ab, B:79:0x02bc), top: B:189:0x02ab }] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0310 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x033e A[Catch: all -> 0x02b0, TryCatch #5 {all -> 0x02b0, blocks: (B:107:0x03e3, B:108:0x03e5, B:113:0x03f8, B:115:0x03ff, B:120:0x0412, B:87:0x02f5, B:82:0x02d0, B:84:0x02d4, B:92:0x0311, B:94:0x033e, B:96:0x034b, B:71:0x02ab, B:79:0x02bc), top: B:189:0x02ab }] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x034a  */
        /* JADX WARN: Type inference failed for: r5v19, types: [T, b7.a] */
        /* JADX WARN: Type inference failed for: r5v57 */
        /* JADX WARN: Type inference failed for: r5v58 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:133:0x048f -> B:134:0x049e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1738
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadSessionManager.C03661.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Result<d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return ((C03661) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VadSessionManager(String tag, zb.p<? super Context, ? super qb.b<? super b7.a>, ? extends Object> pVar) {
        kotlin.jvm.internal.g.f(tag, "tag");
        this.tag = tag;
        this.engineFactory = pVar;
        this.sessions = new ConcurrentHashMap<>();
        this.terminated = Collections.newSetFromMap(new LinkedHashMap<String, Boolean>() { // from class: com.stepos.core.ability.speech.VadSessionManager$terminated$1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            public /* bridge */ boolean containsValue(Boolean bool) {
                return super.containsValue((Object) bool);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, Boolean>> entrySet() {
                return getEntries();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Boolean get(Object obj) {
                if (obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public /* bridge */ Set<Map.Entry<String, Boolean>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            public final /* bridge */ Boolean getOrDefault(Object obj, Boolean bool) {
                return !(obj instanceof String) ? bool : getOrDefault((String) obj, bool);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<Boolean> getValues() {
                return super.values();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Boolean remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Boolean> entry) {
                return size() > 64;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<Boolean> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof Boolean) {
                    return containsValue((Boolean) obj);
                }
                return false;
            }

            public /* bridge */ Boolean get(String str) {
                return (Boolean) super.get((Object) str);
            }

            public /* bridge */ Boolean getOrDefault(String str, Boolean bool) {
                return (Boolean) super.getOrDefault((Object) str, (String) bool);
            }

            public /* bridge */ Boolean remove(String str) {
                return (Boolean) super.remove((Object) str);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Boolean) obj2);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if ((obj instanceof String) && (obj2 instanceof Boolean)) {
                    return remove((String) obj, (Boolean) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, Boolean bool) {
                return super.remove((Object) str, (Object) bool);
            }
        });
        this.reorderScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(VadNativeDispatch.INSTANCE.getDispatcher()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object closeSession(java.lang.String r10, b7.a r11, qb.b<? super lb.n> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.stepos.core.ability.speech.VadSessionManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.core.ability.speech.VadSessionManager$closeSession$1 r0 = (com.stepos.core.ability.speech.VadSessionManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.VadSessionManager$closeSession$1 r0 = new com.stepos.core.ability.speech.VadSessionManager$closeSession$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r9 = r0.L$0
            com.stepos.core.ability.speech.VadSessionManager r9 = (com.stepos.core.ability.speech.VadSessionManager) r9
            kotlin.c.b(r12)     // Catch: java.lang.Throwable -> L2f
            kotlin.Result r12 = (kotlin.Result) r12     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r10 = r12.f9987a     // Catch: java.lang.Throwable -> L2f
            goto L9a
        L2f:
            r10 = move-exception
            goto La0
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            kotlin.c.b(r12)
            java.util.Set<java.lang.String> r12 = r9.terminated
            java.lang.String r2 = "terminated"
            kotlin.jvm.internal.g.e(r12, r2)
            monitor-enter(r12)
            java.util.Set<java.lang.String> r2 = r9.terminated     // Catch: java.lang.Throwable -> Lba
            r2.add(r10)     // Catch: java.lang.Throwable -> Lba
            monitor-exit(r12)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.core.ability.speech.VadSessionManager$Session> r12 = r9.sessions
            java.lang.Object r12 = r12.remove(r10)
            com.stepos.core.ability.speech.VadSessionManager$Session r12 = (com.stepos.core.ability.speech.VadSessionManager.Session) r12
            if (r12 == 0) goto L8d
            com.stepos.core.ability.speech.AsrFeedReorderBuffer r2 = r12.getReorder()
            if (r2 == 0) goto L85
            int r4 = r2.lostFrameCount()
            if (r4 <= 0) goto L82
            com.stepos.core.common.log.LogModule r5 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r6 = r9.tag
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "[VAD] reorder lostFrames="
            r7.<init>(r8)
            r7.append(r4)
            java.lang.String r4 = " inferId="
            r7.append(r4)
            r7.append(r10)
            java.lang.String r10 = " (gap skipped, audio had holes)"
            r7.append(r10)
            java.lang.String r10 = r7.toString()
            com.stepos.core.common.log.AIEngineLogger.w(r5, r6, r10)
        L82:
            r2.dispose()
        L85:
            kotlinx.coroutines.channels.Channel r10 = r12.getChannel()
            r12 = 0
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r10, r12, r3, r12)
        L8d:
            if (r11 == 0) goto Lb7
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L2f
            r0.label = r3     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r10 = r11.mo9closeIoAF18A(r0)     // Catch: java.lang.Throwable -> L2f
            if (r10 != r1) goto L9a
            return r1
        L9a:
            kotlin.Result r11 = new kotlin.Result     // Catch: java.lang.Throwable -> L2f
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L2f
            goto La4
        La0:
            kotlin.Result$Failure r11 = kotlin.c.a(r10)
        La4:
            java.lang.Throwable r10 = kotlin.Result.b(r11)
            if (r10 == 0) goto Lb7
            com.stepos.core.common.log.LogModule r11 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r9 = r9.tag
            java.lang.String r10 = r10.getMessage()
            java.lang.String r12 = "[VAD] close engine failed: "
            ai.onnxruntime.a.w(r12, r10, r11, r9)
        Lb7:
            lb.n r9 = lb.n.f10413a
            return r9
        Lba:
            r9 = move-exception
            monitor-exit(r12)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadSessionManager.closeSession(java.lang.String, b7.a, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Session completeInput$lambda$10(zb.l lVar, Object obj) {
        return (Session) lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Session completeInput$lambda$9(String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new Session(null, 0, 0, false, null, null, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createEngine(android.content.Context r24, qb.b<? super b7.a> r25) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadSessionManager.createEngine(android.content.Context, qb.b):java.lang.Object");
    }

    private final void enqueuePcm(String str, Session session, byte[] bArr) {
        if (bArr.length != 0 && ChannelResult.m159isFailureimpl(session.getChannel().mo149trySendJP2dKIU(bArr))) {
            long jIncrementAndGet = session.getDropped().incrementAndGet();
            if (jIncrementAndGet == 1 || jIncrementAndGet % DROP_LOG_WINDOW == 0) {
                a0.a.x(com.stepos.core.ota.d.l("[VAD] feed dropped inferId=", jIncrementAndGet, str, " total="), " (consumer lagging or session closed)", LogModule.ABILITY, this.tag);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AsrFeedReorderBuffer ensureReorder(final String str, final Session session) {
        AsrFeedReorderBuffer reorder = session.getReorder();
        if (reorder != null) {
            return reorder;
        }
        synchronized (session) {
            AsrFeedReorderBuffer reorder2 = session.getReorder();
            if (reorder2 != null) {
                return reorder2;
            }
            AsrFeedReorderBuffer asrFeedReorderBuffer = new AsrFeedReorderBuffer(this.reorderScope, str, 120L, 200L, 1000L, 16, AsrFeedReorderBuffer.MAX_PENDING_BYTES, new zb.l() { // from class: com.stepos.core.ability.speech.l0
                @Override // zb.l
                public final Object invoke(Object obj) {
                    return VadSessionManager.ensureReorder$lambda$4$lambda$2(this.f7310a, str, session, (AudioContent) obj);
                }
            }, new m0(session, 0));
            session.setReorder(asrFeedReorderBuffer);
            AIEngineLogger.i(LogModule.ABILITY, this.tag, "[VAD] reorder buffer armed inferId=" + str);
            return asrFeedReorderBuffer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n ensureReorder$lambda$4$lambda$2(VadSessionManager vadSessionManager, String str, Session session, AudioContent frame) {
        kotlin.jvm.internal.g.f(frame, "frame");
        vadSessionManager.enqueuePcm(str, session, frame.getAudioBytes());
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n ensureReorder$lambda$4$lambda$3(Session session) {
        SendChannel.DefaultImpls.close$default(session.getChannel(), null, 1, null);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object inferProbability(b7.a r6, java.lang.reflect.Method r7, short[] r8, qb.b<? super java.lang.Float> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.core.ability.speech.VadSessionManager.C03651
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.core.ability.speech.VadSessionManager$inferProbability$1 r0 = (com.stepos.core.ability.speech.VadSessionManager.C03651) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.VadSessionManager$inferProbability$1 r0 = new com.stepos.core.ability.speech.VadSessionManager$inferProbability$1
            r0.<init>(r9)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            r4 = 0
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.c.b(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.f9987a
            goto L77
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.c.b(r5)
            if (r7 == 0) goto L6e
            java.lang.Object[] r5 = new java.lang.Object[]{r8}     // Catch: java.lang.Throwable -> L43
            java.lang.Object r5 = r7.invoke(r6, r5)     // Catch: java.lang.Throwable -> L43
            goto L48
        L43:
            r5 = move-exception
            kotlin.Result$Failure r5 = kotlin.c.a(r5)
        L48:
            boolean r6 = r5 instanceof kotlin.Result.Failure
            if (r6 == 0) goto L4d
            r5 = r4
        L4d:
            boolean r6 = r5 instanceof kotlin.Pair
            if (r6 == 0) goto L54
            kotlin.Pair r5 = (kotlin.Pair) r5
            goto L55
        L54:
            r5 = r4
        L55:
            if (r5 == 0) goto L5a
            A r5 = r5.f9985a
            goto L5b
        L5a:
            r5 = r4
        L5b:
            boolean r6 = r5 instanceof java.lang.Float
            if (r6 == 0) goto L62
            r4 = r5
            java.lang.Float r4 = (java.lang.Float) r4
        L62:
            if (r4 == 0) goto L68
            float r3 = r4.floatValue()
        L68:
            java.lang.Float r5 = new java.lang.Float
            r5.<init>(r3)
            return r5
        L6e:
            r0.label = r2
            java.lang.Object r5 = r6.mo10infer0E7RQCE(r8, r4, r0)
            if (r5 != r9) goto L77
            return r9
        L77:
            boolean r6 = r5 instanceof kotlin.Result.Failure
            if (r6 == 0) goto L7c
            r5 = r4
        L7c:
            if (r5 != 0) goto L84
            java.lang.Float r5 = new java.lang.Float
            r5.<init>(r3)
            return r5
        L84:
            boolean r6 = r5 instanceof kotlin.Pair
            if (r6 == 0) goto L8b
            kotlin.Pair r5 = (kotlin.Pair) r5
            goto L8c
        L8b:
            r5 = r4
        L8c:
            if (r5 == 0) goto L91
            A r5 = r5.f9985a
            goto L92
        L91:
            r5 = r4
        L92:
            boolean r6 = r5 instanceof java.lang.Float
            if (r6 == 0) goto L99
            r4 = r5
            java.lang.Float r4 = (java.lang.Float) r4
        L99:
            if (r4 == 0) goto L9f
            float r3 = r4.floatValue()
        L9f:
            java.lang.Float r5 = new java.lang.Float
            r5.<init>(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadSessionManager.inferProbability(b7.a, java.lang.reflect.Method, short[], qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String inferStats(long j10, long j11, long j12) {
        if (j12 <= 0) {
            return "inferFrames=0";
        }
        long j13 = 1000;
        StringBuilder sbQ = ai.onnxruntime.a.q(j12, "inferFrames=", " inferAvg=");
        sbQ.append((j10 / j12) / j13);
        return a0.a.d(j11 / j13, "us inferMax=", "us", sbQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q levelEvent(VadLevelAggregator.Level level, long j10) {
        Bundle bundle = new Bundle();
        bundle.putString(VadParamKeys.EVENT_TYPE, VadParamKeys.EVENT_AUDIO_LEVEL);
        bundle.putLong(VadParamKeys.ELAPSED_MS, j10);
        bundle.putFloat(VadParamKeys.RMS, level.getRms());
        bundle.putFloat(VadParamKeys.PEAK, level.getPeak());
        bundle.putFloat(VadParamKeys.PROBABILITY, level.getProbability());
        lb.n nVar = lb.n.f10413a;
        return new d.q("", null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Session onFeedInput$lambda$6(String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new Session(null, 0, 0, false, null, null, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Session onFeedInput$lambda$7(zb.l lVar, Object obj) {
        return (Session) lVar.invoke(obj);
    }

    private final String outboundReason(String str) {
        return kotlin.jvm.internal.g.b(str, VadEndpointDetector.REASON_CLIENT_COMPLETE) ? "silence" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method resolveProcessMethod(b7.a aVar) {
        Object objA;
        try {
            objA = aVar.getClass().getMethod("process", short[].class);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (Result.b(objA) != null) {
            AIEngineLogger.w(LogModule.ABILITY, this.tag, "[VAD] process(ShortArray) not found on " + aVar.getClass().getSimpleName() + "; falling back to IModel.infer — per-frame cost will include ModelBase memory probes");
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (Method) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q speechEndEvent(long j10, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(VadParamKeys.EVENT_TYPE, VadParamKeys.EVENT_SPEECH_END);
        bundle.putLong(VadParamKeys.ELAPSED_MS, j10);
        bundle.putString(VadParamKeys.END_REASON, outboundReason(str));
        lb.n nVar = lb.n.f10413a;
        return new d.q("", null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q speechStartEvent(long j10) {
        Bundle bundle = new Bundle();
        bundle.putString(VadParamKeys.EVENT_TYPE, VadParamKeys.EVENT_SPEECH_START);
        bundle.putLong(VadParamKeys.ELAPSED_MS, j10);
        lb.n nVar = lb.n.f10413a;
        return new d.q("", null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q warningEvent(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(VadParamKeys.EVENT_TYPE, VadParamKeys.EVENT_WARNING);
        bundle.putString(VadParamKeys.WARNING_CODE, str);
        bundle.putString(VadParamKeys.WARNING_MESSAGE, str2);
        lb.n nVar = lb.n.f10413a;
        return new d.q("", null, bundle, 2);
    }

    public final int activeSessionCount$ability_release() {
        return this.sessions.size();
    }

    public final void cancelAll() {
        Set<String> setKeySet = this.sessions.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        for (String str : kotlin.collections.a.O0(setKeySet)) {
            Set<String> terminated = this.terminated;
            kotlin.jvm.internal.g.e(terminated, "terminated");
            synchronized (terminated) {
                this.terminated.add(str);
            }
            Session sessionRemove = this.sessions.remove(str);
            if (sessionRemove != null) {
                sessionRemove.setAborted(true);
                AsrFeedReorderBuffer reorder = sessionRemove.getReorder();
                if (reorder != null) {
                    reorder.dispose();
                }
                SendChannel.DefaultImpls.close$default(sessionRemove.getChannel(), null, 1, null);
            }
        }
    }

    public final void completeInput(String inferId) {
        boolean zContains;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        Set<String> terminated = this.terminated;
        kotlin.jvm.internal.g.e(terminated, "terminated");
        synchronized (terminated) {
            zContains = this.terminated.contains(inferId);
        }
        if (zContains) {
            return;
        }
        Session sessionComputeIfAbsent = this.sessions.computeIfAbsent(inferId, new o0(new n0(3), 2));
        kotlin.jvm.internal.g.e(sessionComputeIfAbsent, "computeIfAbsent(...)");
        Session session = sessionComputeIfAbsent;
        AsrFeedReorderBuffer reorder = session.getReorder();
        if (reorder != null) {
            reorder.markCompleted();
        } else {
            SendChannel.DefaultImpls.close$default(session.getChannel(), null, 1, null);
        }
    }

    public final void onFeedInput(String inferId, Object input) {
        boolean zContains;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        AudioContent audioContent = input instanceof AudioContent ? (AudioContent) input : null;
        if (audioContent == null) {
            return;
        }
        Set<String> terminated = this.terminated;
        kotlin.jvm.internal.g.e(terminated, "terminated");
        synchronized (terminated) {
            zContains = this.terminated.contains(inferId);
        }
        if (zContains) {
            return;
        }
        Session sessionComputeIfAbsent = this.sessions.computeIfAbsent(inferId, new o0(new n0(4), 3));
        kotlin.jvm.internal.g.e(sessionComputeIfAbsent, "computeIfAbsent(...)");
        Session session = sessionComputeIfAbsent;
        if (audioContent.getAudioBytes().length != 0) {
            if (audioContent.getSampleRate() > 0) {
                session.setSampleRate(audioContent.getSampleRate());
            }
            if (audioContent.getChannelCount() > 0) {
                session.setChannelCount(audioContent.getChannelCount());
            }
        }
        ContentParams params = audioContent.getParams();
        if (params != null && params.getBoolean(VadParamKeys.FEED_EOF, false)) {
            int i10 = params.getInt(VadParamKeys.FEED_TOTAL, -1);
            AsrFeedReorderBuffer reorder = session.getReorder();
            if (reorder != null) {
                reorder.markTotal(i10);
                return;
            } else {
                AIEngineLogger.d(LogModule.ABILITY, this.tag, "[VAD] eof without reorder buffer, inferId=".concat(inferId));
                return;
            }
        }
        if (audioContent.getAudioBytes().length == 0) {
            return;
        }
        int i11 = params != null ? params.getInt(VadParamKeys.FEED_SEQ, -1) : -1;
        if (i11 >= 0) {
            ensureReorder(inferId, session).offer(i11, audioContent);
        } else {
            enqueuePcm(inferId, session, audioContent.getAudioBytes());
        }
    }

    public final Flow<Result<d.q>> openSession(Context context, String inferId, VadRuntimeConfig config, int i10, int i11, boolean z) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(config, "config");
        return FlowKt__ContextKt.buffer$default(FlowKt.flowOn(FlowKt.channelFlow(new C03661(inferId, i10, i11, z, config, context, null)), VadNativeDispatch.INSTANCE.getDispatcher()), 64, null, 2, null);
    }

    public /* synthetic */ VadSessionManager(String str, zb.p pVar, int i10, kotlin.jvm.internal.e eVar) {
        this(str, (i10 & 2) != 0 ? null : pVar);
    }
}
