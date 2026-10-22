package com.stepos.core.ability.speech;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.datastore.preferences.protobuf.b1;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.stepos.base.strategy.NetworkPolicy;
import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.core.ability.speech.AsrSseStreamLimits;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.AsrSseStreamParamKeys;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.common.util.VadParamKeys;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.error.AIEngineError;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrSseStreamSessionManager {
    private static final int CHANNEL_CAPACITY = 64;
    public static final Companion Companion = new Companion(null);
    private static final long DROP_LOG_WINDOW = 50;
    public static final String ERR_UNSUPPORTED_FORMAT = "stepos-asr-sse streaming requires 16000Hz mono PCM16;";
    public static final String ERR_VAD_UNAVAILABLE = "vad.enabled=true but ten-vad engine is unavailable; retry without vad.enabled and finalize via closeChannel()";
    private static final int FLOW_BUFFER_CAPACITY = 64;
    private static final int MAX_TOMBSTONES = 64;
    private static final long MIC_WARMUP_FLOOR_MS = 250;
    private static final String PCM_DUMP_ROUTE = "SSE";
    public static final String REASON_INPUT_COMPLETE = "input_complete";
    public static final String REASON_MAX_DURATION = "max_duration";
    public static final int SINGLE_SEGMENT_INDEX = 0;
    public static final int TARGET_CHANNEL_COUNT = 1;
    public static final int TARGET_SAMPLE_RATE = 16000;
    private final zb.l<NetworkPolicy, CloudNetworkStatus> networkProbe;
    private final ConcurrentHashMap<String, AsrPcmDumpSink> pcmDumpByInfer;
    private final zb.q<Context, VadRuntimeConfig, qb.b<? super VadPipeline>, Object> pipelineFactory;
    private final CoroutineScope reorderScope;
    private final ConcurrentHashMap<String, Session> sessions;
    private final String tag;
    private final Set<String> terminated;
    private final zb.w<String, byte[], Integer, Integer, Long, Long, Object, String, qb.b<? super Flow<Result<d.q>>>, Object> transcribe;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.AsrSseStreamSessionManager$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements zb.l<NetworkPolicy, CloudNetworkStatus> {
        public AnonymousClass1(Object obj) {
            super(1, obj, CloudNetworkEvaluator.class, "evaluate", "evaluate(Lcom/stepos/base/strategy/NetworkPolicy;)Lcom/stepos/core/ability/speech/CloudNetworkStatus;", 0);
        }

        @Override // zb.l
        public final CloudNetworkStatus invoke(NetworkPolicy p02) {
            kotlin.jvm.internal.g.f(p02, "p0");
            return ((CloudNetworkEvaluator) this.receiver).evaluate(p02);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final String modeLog(Boolean bool) {
            if (kotlin.jvm.internal.g.b(bool, Boolean.TRUE)) {
                return "vad";
            }
            if (kotlin.jvm.internal.g.b(bool, Boolean.FALSE)) {
                return "manual(recv=false)";
            }
            if (bool == null) {
                return "manual";
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Session {
        private volatile boolean aborted;
        private volatile String businessTraceId;
        private final Channel<StreamItem> channel;
        private volatile int channelCount;
        private volatile int clientTotal;
        private final AtomicLong dropped;
        private final AtomicLong fedBytes;
        private final AtomicLong fedFrames;
        private volatile long openedAtMs;
        private final ByteArrayOutputStream pcmSink;
        private volatile Object record;
        private volatile AsrFeedReorderBuffer reorder;
        private volatile int sampleRate;
        private final AtomicBoolean vadAutoStopEnabled;

        public Session() {
            this(null, null, 0, 0, false, null, null, null, null, null, null, 0L, 0, null, 16383, null);
        }

        public final boolean getAborted() {
            return this.aborted;
        }

        public final String getBusinessTraceId() {
            return this.businessTraceId;
        }

        public final Channel<StreamItem> getChannel() {
            return this.channel;
        }

        public final int getChannelCount() {
            return this.channelCount;
        }

        public final int getClientTotal() {
            return this.clientTotal;
        }

        public final AtomicLong getDropped() {
            return this.dropped;
        }

        public final AtomicLong getFedBytes() {
            return this.fedBytes;
        }

        public final AtomicLong getFedFrames() {
            return this.fedFrames;
        }

        public final long getOpenedAtMs() {
            return this.openedAtMs;
        }

        public final ByteArrayOutputStream getPcmSink() {
            return this.pcmSink;
        }

        public final Object getRecord() {
            return this.record;
        }

        public final AsrFeedReorderBuffer getReorder() {
            return this.reorder;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public final AtomicBoolean getVadAutoStopEnabled() {
            return this.vadAutoStopEnabled;
        }

        public final void setAborted(boolean z) {
            this.aborted = z;
        }

        public final void setBusinessTraceId(String str) {
            kotlin.jvm.internal.g.f(str, "<set-?>");
            this.businessTraceId = str;
        }

        public final void setChannelCount(int i10) {
            this.channelCount = i10;
        }

        public final void setClientTotal(int i10) {
            this.clientTotal = i10;
        }

        public final void setOpenedAtMs(long j10) {
            this.openedAtMs = j10;
        }

        public final void setRecord(Object obj) {
            this.record = obj;
        }

        public final void setReorder(AsrFeedReorderBuffer asrFeedReorderBuffer) {
            this.reorder = asrFeedReorderBuffer;
        }

        public final void setSampleRate(int i10) {
            this.sampleRate = i10;
        }

        public Session(Channel<StreamItem> channel, ByteArrayOutputStream pcmSink, int i10, int i11, boolean z, AtomicLong dropped, AtomicBoolean vadAutoStopEnabled, AsrFeedReorderBuffer asrFeedReorderBuffer, Object obj, AtomicLong fedFrames, AtomicLong fedBytes, long j10, int i12, String businessTraceId) {
            kotlin.jvm.internal.g.f(channel, "channel");
            kotlin.jvm.internal.g.f(pcmSink, "pcmSink");
            kotlin.jvm.internal.g.f(dropped, "dropped");
            kotlin.jvm.internal.g.f(vadAutoStopEnabled, "vadAutoStopEnabled");
            kotlin.jvm.internal.g.f(fedFrames, "fedFrames");
            kotlin.jvm.internal.g.f(fedBytes, "fedBytes");
            kotlin.jvm.internal.g.f(businessTraceId, "businessTraceId");
            this.channel = channel;
            this.pcmSink = pcmSink;
            this.sampleRate = i10;
            this.channelCount = i11;
            this.aborted = z;
            this.dropped = dropped;
            this.vadAutoStopEnabled = vadAutoStopEnabled;
            this.reorder = asrFeedReorderBuffer;
            this.record = obj;
            this.fedFrames = fedFrames;
            this.fedBytes = fedBytes;
            this.openedAtMs = j10;
            this.clientTotal = i12;
            this.businessTraceId = businessTraceId;
        }

        public /* synthetic */ Session(Channel channel, ByteArrayOutputStream byteArrayOutputStream, int i10, int i11, boolean z, AtomicLong atomicLong, AtomicBoolean atomicBoolean, AsrFeedReorderBuffer asrFeedReorderBuffer, Object obj, AtomicLong atomicLong2, AtomicLong atomicLong3, long j10, int i12, String str, int i13, kotlin.jvm.internal.e eVar) {
            this((i13 & 1) != 0 ? ChannelKt.Channel$default(64, null, null, 6, null) : channel, (i13 & 2) != 0 ? new ByteArrayOutputStream() : byteArrayOutputStream, (i13 & 4) != 0 ? 0 : i10, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? false : z, (i13 & 32) != 0 ? new AtomicLong(0L) : atomicLong, (i13 & 64) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? null : asrFeedReorderBuffer, (i13 & 256) == 0 ? obj : null, (i13 & VadSessionManager.FRAME_BYTES) != 0 ? new AtomicLong(0L) : atomicLong2, (i13 & 1024) != 0 ? new AtomicLong(0L) : atomicLong3, (i13 & 2048) == 0 ? j10 : 0L, (i13 & 4096) != 0 ? -1 : i12, (i13 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? "" : str);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class StreamItem {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Pcm extends StreamItem {
            private final byte[] bytes;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Pcm(byte[] bytes) {
                super(null);
                kotlin.jvm.internal.g.f(bytes, "bytes");
                this.bytes = bytes;
            }

            public final byte[] getBytes() {
                return this.bytes;
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class VadGate extends StreamItem {
            private final boolean enabled;
            private final Bundle overrides;

            public VadGate(boolean z, Bundle bundle) {
                super(null);
                this.enabled = z;
                this.overrides = bundle;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }

            public final Bundle getOverrides() {
                return this.overrides;
            }
        }

        public /* synthetic */ StreamItem(kotlin.jvm.internal.e eVar) {
            this();
        }

        private StreamItem() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrSseStreamSessionManager$openSession$1", f = "AsrSseStreamSessionManager.kt", l = {ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 251, 254, 517, 310, 316, 517, 329, 338, 517, 413, 491, 497, 517, 505, 517, 509, 514, 517, 517}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrSseStreamSessionManager$openSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03341 extends SuspendLambda implements zb.p<ProducerScope<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ long $audioMaxBytes;
        final /* synthetic */ String $businessTraceId;
        final /* synthetic */ Context $context;
        final /* synthetic */ Bundle $extras;
        final /* synthetic */ String $inferId;
        final /* synthetic */ NetworkPolicy $networkPolicy;
        final /* synthetic */ Object $record;
        final /* synthetic */ int $sampleRateHint;
        final /* synthetic */ p6.j $vadConfigured;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "com.stepos.core.ability.speech.AsrSseStreamSessionManager$openSession$1$6", f = "AsrSseStreamSessionManager.kt", l = {517}, m = "invokeSuspend")
        /* renamed from: com.stepos.core.ability.speech.AsrSseStreamSessionManager$openSession$1$6, reason: invalid class name */
        public static final class AnonymousClass6 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
            final /* synthetic */ String $inferId;
            final /* synthetic */ Ref$ObjectRef<VadPipeline> $pipeline;
            int label;
            final /* synthetic */ AsrSseStreamSessionManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass6(AsrSseStreamSessionManager asrSseStreamSessionManager, String str, Ref$ObjectRef<VadPipeline> ref$ObjectRef, qb.b<? super AnonymousClass6> bVar) {
                super(2, bVar);
                this.this$0 = asrSseStreamSessionManager;
                this.$inferId = str;
                this.$pipeline = ref$ObjectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
                return new AnonymousClass6(this.this$0, this.$inferId, this.$pipeline, bVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                int i10 = this.label;
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    AsrSseStreamSessionManager asrSseStreamSessionManager = this.this$0;
                    String str = this.$inferId;
                    VadPipeline vadPipeline = this.$pipeline.f10076a;
                    this.label = 1;
                    if (asrSseStreamSessionManager.closeSession(str, vadPipeline, this) == coroutineSingletons) {
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
                return ((AnonymousClass6) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03341(String str, Object obj, String str2, int i10, Bundle bundle, long j10, p6.j jVar, Context context, NetworkPolicy networkPolicy, qb.b<? super C03341> bVar) {
            super(2, bVar);
            this.$inferId = str;
            this.$record = obj;
            this.$businessTraceId = str2;
            this.$sampleRateHint = i10;
            this.$extras = bundle;
            this.$audioMaxBytes = j10;
            this.$vadConfigured = jVar;
            this.$context = context;
            this.$networkPolicy = networkPolicy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x018e, code lost:
        
            if (r3.send(r1, r6) == r7) goto L52;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0194  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01c4  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01c6  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
        /* JADX WARN: Type inference failed for: r4v1, types: [T, com.stepos.core.ability.speech.VadRuntimeConfig] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.Object invokeSuspend$applyVadGate(com.stepos.core.ability.speech.AsrSseStreamSessionManager.Session r17, kotlin.jvm.internal.Ref$ObjectRef<com.stepos.core.ability.speech.VadRuntimeConfig> r18, kotlin.jvm.internal.Ref$ObjectRef<com.stepos.core.ability.speech.VadPipeline> r19, com.stepos.core.ability.speech.AsrSseStreamSessionManager r20, android.content.Context r21, java.lang.String r22, kotlinx.coroutines.channels.ProducerScope<? super kotlin.Result<v6.d.q>> r23, p6.j r24, android.os.Bundle r25, long r26, boolean r28, android.os.Bundle r29, qb.b<? super java.lang.Boolean> r30) {
            /*
                Method dump skipped, instructions count: 500
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrSseStreamSessionManager.C03341.invokeSuspend$applyVadGate(com.stepos.core.ability.speech.AsrSseStreamSessionManager$Session, kotlin.jvm.internal.Ref$ObjectRef, kotlin.jvm.internal.Ref$ObjectRef, com.stepos.core.ability.speech.AsrSseStreamSessionManager, android.content.Context, java.lang.String, kotlinx.coroutines.channels.ProducerScope, p6.j, android.os.Bundle, long, boolean, android.os.Bundle, qb.b):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Session invokeSuspend$lambda$0(String str) {
            return new Session(null, null, 0, 0, false, null, null, null, null, null, null, 0L, 0, null, 16383, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Session invokeSuspend$lambda$1(zb.l lVar, Object obj) {
            return (Session) lVar.invoke(obj);
        }

        private static final VadRuntimeConfig invokeSuspend$resolveGateConfig(p6.j jVar, Bundle bundle, long j10, Bundle bundle2) {
            if (bundle2 == null || bundle2.isEmpty()) {
                return VadRuntimeConfig.Companion.resolve(jVar, bundle).withMaxDurationFrom((int) j10);
            }
            Bundle bundle3 = new Bundle();
            if (bundle != null) {
                bundle3.putAll(bundle);
            }
            bundle3.putAll(bundle2);
            return VadRuntimeConfig.Companion.resolve(jVar, bundle3).withMaxDurationFrom((int) j10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03341 c03341 = AsrSseStreamSessionManager.this.new C03341(this.$inferId, this.$record, this.$businessTraceId, this.$sampleRateHint, this.$extras, this.$audioMaxBytes, this.$vadConfigured, this.$context, this.$networkPolicy, bVar);
            c03341.L$0 = obj;
            return c03341;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Result<? extends d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return invoke2((ProducerScope<? super Result<d.q>>) producerScope, bVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 10, insn: 0x00e2: MOVE (r1 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:38:0x00e2 */
        /* JADX WARN: Path cross not found for [B:85:0x027e, B:78:0x0266], limit reached: 458 */
        /* JADX WARN: Removed duplicated region for block: B:102:0x0345  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x036f  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x037d A[Catch: all -> 0x03bf, TRY_LEAVE, TryCatch #20 {all -> 0x03bf, blocks: (B:117:0x03a3, B:107:0x0370, B:108:0x0377, B:110:0x037d, B:114:0x039a, B:104:0x034a), top: B:444:0x034a }] */
        /* JADX WARN: Removed duplicated region for block: B:121:0x03be A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:129:0x03cd  */
        /* JADX WARN: Removed duplicated region for block: B:135:0x03fc  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x046e A[Catch: all -> 0x0495, TRY_LEAVE, TryCatch #31 {all -> 0x0495, blocks: (B:193:0x056f, B:198:0x05a1, B:200:0x05a5, B:202:0x05af, B:148:0x0466, B:150:0x046e, B:170:0x04ea, B:178:0x0503, B:185:0x051b, B:187:0x052c, B:189:0x0534), top: B:464:0x056f }] */
        /* JADX WARN: Removed duplicated region for block: B:157:0x0499  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x04b7  */
        /* JADX WARN: Removed duplicated region for block: B:200:0x05a5 A[Catch: all -> 0x0495, TryCatch #31 {all -> 0x0495, blocks: (B:193:0x056f, B:198:0x05a1, B:200:0x05a5, B:202:0x05af, B:148:0x0466, B:150:0x046e, B:170:0x04ea, B:178:0x0503, B:185:0x051b, B:187:0x052c, B:189:0x0534), top: B:464:0x056f }] */
        /* JADX WARN: Removed duplicated region for block: B:205:0x05c2  */
        /* JADX WARN: Removed duplicated region for block: B:231:0x068f A[Catch: all -> 0x06eb, TRY_LEAVE, TryCatch #10 {all -> 0x06eb, blocks: (B:229:0x0689, B:231:0x068f, B:239:0x06f0, B:243:0x06fa, B:246:0x0702, B:251:0x0718), top: B:432:0x0689 }] */
        /* JADX WARN: Removed duplicated region for block: B:238:0x06ee  */
        /* JADX WARN: Removed duplicated region for block: B:248:0x0708  */
        /* JADX WARN: Removed duplicated region for block: B:285:0x085a  */
        /* JADX WARN: Removed duplicated region for block: B:312:0x096e  */
        /* JADX WARN: Removed duplicated region for block: B:321:0x098f  */
        /* JADX WARN: Removed duplicated region for block: B:345:0x0a84  */
        /* JADX WARN: Removed duplicated region for block: B:346:0x0a86 A[Catch: all -> 0x0aa3, PHI: r1 r10 r12
          0x0a86: PHI (r1v90 kotlin.jvm.internal.Ref$ObjectRef) = (r1v114 kotlin.jvm.internal.Ref$ObjectRef), (r1v115 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:344:0x0a82, B:23:0x0068] A[DONT_GENERATE, DONT_INLINE]
          0x0a86: PHI (r10v64 com.stepos.core.ability.speech.AsrSseStreamSessionManager$openSession$1) = 
          (r10v61 com.stepos.core.ability.speech.AsrSseStreamSessionManager$openSession$1)
          (r10v65 com.stepos.core.ability.speech.AsrSseStreamSessionManager$openSession$1)
         binds: [B:344:0x0a82, B:23:0x0068] A[DONT_GENERATE, DONT_INLINE]
          0x0a86: PHI (r12v72 kotlin.coroutines.intrinsics.CoroutineSingletons) = (r12v69 kotlin.coroutines.intrinsics.CoroutineSingletons), (r12v73 kotlin.coroutines.intrinsics.CoroutineSingletons) binds: [B:344:0x0a82, B:23:0x0068] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {all -> 0x0aa3, blocks: (B:360:0x0adf, B:346:0x0a86, B:343:0x0a5d), top: B:417:0x0012 }] */
        /* JADX WARN: Removed duplicated region for block: B:350:0x0aa2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:364:0x0afb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:435:0x0407 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:454:0x0319 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:462:0x084a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:479:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:483:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:484:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:485:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x02c4  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x02cf  */
        /* JADX WARN: Type inference failed for: r0v201 */
        /* JADX WARN: Type inference failed for: r0v52, types: [T] */
        /* JADX WARN: Type inference failed for: r0v60 */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v101, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v110 */
        /* JADX WARN: Type inference failed for: r1v111 */
        /* JADX WARN: Type inference failed for: r1v112 */
        /* JADX WARN: Type inference failed for: r1v113 */
        /* JADX WARN: Type inference failed for: r1v117 */
        /* JADX WARN: Type inference failed for: r1v118 */
        /* JADX WARN: Type inference failed for: r1v120 */
        /* JADX WARN: Type inference failed for: r1v121 */
        /* JADX WARN: Type inference failed for: r1v122 */
        /* JADX WARN: Type inference failed for: r1v123 */
        /* JADX WARN: Type inference failed for: r1v130 */
        /* JADX WARN: Type inference failed for: r1v131 */
        /* JADX WARN: Type inference failed for: r1v133 */
        /* JADX WARN: Type inference failed for: r1v134 */
        /* JADX WARN: Type inference failed for: r1v136 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v38 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v43 */
        /* JADX WARN: Type inference failed for: r1v47 */
        /* JADX WARN: Type inference failed for: r1v48 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v50, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r1v55 */
        /* JADX WARN: Type inference failed for: r1v56 */
        /* JADX WARN: Type inference failed for: r1v57, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r1v6, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r1v64 */
        /* JADX WARN: Type inference failed for: r1v66 */
        /* JADX WARN: Type inference failed for: r1v67 */
        /* JADX WARN: Type inference failed for: r1v69 */
        /* JADX WARN: Type inference failed for: r1v71 */
        /* JADX WARN: Type inference failed for: r1v73 */
        /* JADX WARN: Type inference failed for: r1v82 */
        /* JADX WARN: Type inference failed for: r1v95 */
        /* JADX WARN: Type inference failed for: r24v0, types: [T, com.stepos.core.ability.speech.VadRuntimeConfig] */
        /* JADX WARN: Type inference failed for: r2v103 */
        /* JADX WARN: Type inference failed for: r2v14, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v32, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r2v71, types: [T] */
        /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r3v48 */
        /* JADX WARN: Type inference failed for: r3v49 */
        /* JADX WARN: Type inference failed for: r3v98 */
        /* JADX WARN: Type inference failed for: r3v99 */
        /* JADX WARN: Type inference failed for: r8v43, types: [T] */
        /* JADX WARN: Type inference failed for: r8v62 */
        /* JADX WARN: Type inference failed for: r8v63 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:157:0x0499 -> B:474:0x03dd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:192:0x0569 -> B:464:0x056f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:195:0x057d -> B:194:0x057b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:197:0x0591 -> B:198:0x05a1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r46) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 3102
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrSseStreamSessionManager.C03341.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Result<d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return ((C03341) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsrSseStreamSessionManager(String tag, zb.q<? super Context, ? super VadRuntimeConfig, ? super qb.b<? super VadPipeline>, ? extends Object> qVar, zb.l<? super NetworkPolicy, ? extends CloudNetworkStatus> networkProbe, zb.w<? super String, ? super byte[], ? super Integer, ? super Integer, ? super Long, ? super Long, Object, ? super String, ? super qb.b<? super Flow<Result<d.q>>>, ? extends Object> transcribe) {
        kotlin.jvm.internal.g.f(tag, "tag");
        kotlin.jvm.internal.g.f(networkProbe, "networkProbe");
        kotlin.jvm.internal.g.f(transcribe, "transcribe");
        this.tag = tag;
        this.pipelineFactory = qVar;
        this.networkProbe = networkProbe;
        this.transcribe = transcribe;
        this.sessions = new ConcurrentHashMap<>();
        this.pcmDumpByInfer = new ConcurrentHashMap<>();
        this.terminated = Collections.newSetFromMap(new LinkedHashMap<String, Boolean>() { // from class: com.stepos.core.ability.speech.AsrSseStreamSessionManager$terminated$1
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
    public final Object closeSession(String str, VadPipeline vadPipeline, qb.b<? super lb.n> bVar) {
        Set<String> terminated = this.terminated;
        kotlin.jvm.internal.g.e(terminated, "terminated");
        synchronized (terminated) {
            this.terminated.add(str);
        }
        Session sessionRemove = this.sessions.remove(str);
        if (sessionRemove != null) {
            AsrFeedReorderBuffer reorder = sessionRemove.getReorder();
            if (reorder != null) {
                int iLostFrameCount = reorder.lostFrameCount();
                if (iLostFrameCount > 0) {
                    AIEngineLogger.w(LogModule.ABILITY, this.tag, "[ASR-SSE-STREAM] reorder lostFrames=" + iLostFrameCount + " inferId=" + str + " (audio had holes)");
                }
                reorder.dispose();
            }
            SendChannel.DefaultImpls.close$default(sessionRemove.getChannel(), null, 1, null);
            try {
                sessionRemove.getPcmSink().close();
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            closePcmDump(str);
        }
        if (vadPipeline == null) {
            return lb.n.f10413a;
        }
        Object objClose = vadPipeline.close(bVar);
        return objClose == CoroutineSingletons.f10059a ? objClose : lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Session completeInput$lambda$8(String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new Session(null, null, 0, 0, false, null, null, null, null, null, null, 0L, 0, null, 16383, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Session completeInput$lambda$9(zb.l lVar, Object obj) {
        return (Session) lVar.invoke(obj);
    }

    private final void dispatchOrderedFeed(String str, Session session, AudioContent audioContent) {
        ContentParams params = audioContent.getParams();
        if (params != null && params.getBoolean(AsrSseStreamParamKeys.VAD_GATE, false)) {
            enqueueItem(str, session, new StreamItem.VadGate(params.getBoolean(AsrSseStreamParamKeys.VAD_ENABLED, false), extractVadTuning(params)));
        } else {
            feedPcmDump(str, audioContent);
            enqueueItem(str, session, new StreamItem.Pcm(audioContent.getAudioBytes()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q doneEvent(String str, long j10, long j11) {
        Bundle bundle = new Bundle();
        bundle.putString("asr.event_type", AsrSseStreamParamKeys.EVENT_DONE);
        bundle.putInt("asr.segment.index", 0);
        bundle.putLong("asr.segment.start_ms", j10);
        bundle.putLong("asr.segment.end_ms", j11);
        lb.n nVar = lb.n.f10413a;
        return new d.q(str, null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long durationMsOf(Session session) {
        Integer numValueOf = Integer.valueOf(session.getSampleRate());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        return ((session.getPcmSink().size() / 2) * 1000) / (numValueOf != null ? numValueOf.intValue() : 16000);
    }

    private final void enqueueItem(String str, Session session, StreamItem streamItem) {
        if (!((streamItem instanceof StreamItem.Pcm) && ((StreamItem.Pcm) streamItem).getBytes().length == 0) && ChannelResult.m159isFailureimpl(session.getChannel().mo149trySendJP2dKIU(streamItem))) {
            long jIncrementAndGet = session.getDropped().incrementAndGet();
            if (jIncrementAndGet == 1 || jIncrementAndGet % DROP_LOG_WINDOW == 0) {
                a0.a.x(com.stepos.core.ota.d.l("[ASR-SSE-STREAM] feed dropped inferId=", jIncrementAndGet, str, " total="), " (consumer lagging or closed)", LogModule.ABILITY, this.tag);
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
            AsrFeedReorderBuffer asrFeedReorderBuffer = new AsrFeedReorderBuffer(this.reorderScope, str, 120L, 200L, 1000L, 16, AsrFeedReorderBuffer.MAX_PENDING_BYTES, new zb.l() { // from class: com.stepos.core.ability.speech.u
                @Override // zb.l
                public final Object invoke(Object obj) {
                    return AsrSseStreamSessionManager.ensureReorder$lambda$19$lambda$17(this.f7341a, str, session, (AudioContent) obj);
                }
            }, new e(session, 1));
            session.setReorder(asrFeedReorderBuffer);
            AIEngineLogger.i(LogModule.ABILITY, this.tag, "[ASR-SSE-STREAM] reorder buffer armed inferId=" + str);
            return asrFeedReorderBuffer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n ensureReorder$lambda$19$lambda$17(AsrSseStreamSessionManager asrSseStreamSessionManager, String str, Session session, AudioContent frame) {
        kotlin.jvm.internal.g.f(frame, "frame");
        asrSseStreamSessionManager.dispatchOrderedFeed(str, session, frame);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n ensureReorder$lambda$19$lambda$18(Session session) {
        SendChannel.DefaultImpls.close$default(session.getChannel(), null, 1, null);
        return lb.n.f10413a;
    }

    private final Bundle extractVadTuning(ContentParams contentParams) {
        Bundle bundle = new Bundle();
        extractVadTuning$putInt(contentParams, bundle, VadParamKeys.SPEECH_START_MS);
        extractVadTuning$putInt(contentParams, bundle, VadParamKeys.SILENCE_DURATION_MS);
        extractVadTuning$putInt(contentParams, bundle, VadParamKeys.LEADING_SILENCE_TIMEOUT_MS);
        extractVadTuning$putInt(contentParams, bundle, VadParamKeys.MAX_DURATION_MS);
        extractVadTuning$putFloat(contentParams, bundle, VadParamKeys.THRESHOLD);
        extractVadTuning$putFloat(contentParams, bundle, VadParamKeys.MIN_SPEECH_RMS);
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    private static final void extractVadTuning$putFloat(ContentParams contentParams, Bundle bundle, String str) {
        if (contentParams.containsKey(str)) {
            float f8 = contentParams.getFloat(str, Float.NaN);
            if (Float.isNaN(f8)) {
                f8 = (float) contentParams.getDouble(str, 0.0d);
            }
            bundle.putFloat(str, f8);
        }
    }

    private static final void extractVadTuning$putInt(ContentParams contentParams, Bundle bundle, String str) {
        if (contentParams.containsKey(str)) {
            bundle.putInt(str, ContentParams.getInt$default(contentParams, str, 0, 2, null));
        }
    }

    private final void feedPcmDump(String str, AudioContent audioContent) {
        AsrPcmDumpSink asrPcmDumpSink;
        if (audioContent.getAudioBytes().length == 0 || (asrPcmDumpSink = this.pcmDumpByInfer.get(str)) == null) {
            return;
        }
        asrPcmDumpSink.feed(str, audioContent, PCM_DUMP_ROUTE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: finalizeNetworkGate-YNEx5aM, reason: not valid java name */
    public final Result<d.q> m59finalizeNetworkGateYNEx5aM(String str, NetworkPolicy networkPolicy) {
        CloudNetworkStatus cloudNetworkStatusA;
        try {
            cloudNetworkStatusA = this.networkProbe.invoke(networkPolicy);
        } catch (Throwable th) {
            cloudNetworkStatusA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(cloudNetworkStatusA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.ABILITY, this.tag, h0.e.c("[ASR-SSE-STREAM] network probe failed inferId=", str, " (", thB.getMessage(), "); proceed anyway"));
            return null;
        }
        CloudNetworkStatus cloudNetworkStatus = (CloudNetworkStatus) cloudNetworkStatusA;
        if (cloudNetworkStatus == CloudNetworkStatus.AVAILABLE) {
            return null;
        }
        AIEngineLogger.w(LogModule.ABILITY, this.tag, "[ASR-SSE-STREAM] abort submit inferId=" + str + " network=" + cloudNetworkStatus + " policy=" + networkPolicy + " (re-checked at finalize; audio discarded)");
        return new Result<>(kotlin.c.a(new OrchestrationRejectedException(AIEngineError.CLOUD_NETWORK_UNAVAILABLE, "network became unavailable during recording (status=" + cloudNetworkStatus + ")")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logRejectedParams(String str, Bundle bundle, boolean z, AsrSseStreamLimits.MaxDuration maxDuration, VadRuntimeConfig vadRuntimeConfig) {
        ListBuilder listBuilderY = b1.y();
        String strRejectionLog = maxDuration.rejectionLog();
        if (strRejectionLog != null) {
            listBuilderY.add(strRejectionLog);
        }
        if (z) {
            String strRejectionLog2 = vadRuntimeConfig.rejectionLog();
            if (strRejectionLog2.length() <= 0) {
                strRejectionLog2 = null;
            }
            if (strRejectionLog2 != null) {
                listBuilderY.add(strRejectionLog2);
            }
        }
        ListBuilder listBuilderI = b1.i(listBuilderY);
        if (listBuilderI.isEmpty()) {
            return;
        }
        ListBuilder listBuilderY2 = b1.y();
        if (bundle != null && bundle.containsKey(AsrSseStreamParamKeys.VAD_ENABLED)) {
            listBuilderY2.add(AsrSseStreamParamKeys.VAD_ENABLED);
        }
        if (maxDuration.getRecv() != null) {
            listBuilderY2.add(AsrSseStreamParamKeys.STREAM_MAX_DURATION_MS);
        }
        if (z) {
            listBuilderY2.addAll(vadRuntimeConfig.getClientKeys());
        }
        ListBuilder listBuilderI2 = b1.i(listBuilderY2);
        LogModule logModule = LogModule.ABILITY;
        String str2 = this.tag;
        String strZ0 = kotlin.collections.a.z0(listBuilderI2, ",", "[", "]", null, 56);
        a0.a.x(ai.onnxruntime.a.s("[ASR-SSE-STREAM] param_rejected inferId=", str, " clientKeys=", strZ0, " "), kotlin.collections.a.z0(listBuilderI, "; ", null, null, null, 62), logModule, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Session onFeedInput$lambda$5(String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new Session(null, null, 0, 0, false, null, null, null, null, null, null, 0L, 0, null, 16383, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Session onFeedInput$lambda$6(zb.l lVar, Object obj) {
        return (Session) lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q speechStartEvent(long j10) {
        Bundle bundle = new Bundle();
        bundle.putString("asr.event_type", AsrSseStreamParamKeys.EVENT_SPEECH_START);
        bundle.putInt("asr.segment.index", 0);
        bundle.putLong("asr.segment.start_ms", j10);
        lb.n nVar = lb.n.f10413a;
        return new d.q("", null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q warningEvent(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("asr.event_type", AsrSseStreamParamKeys.EVENT_WARNING);
        bundle.putString(AsrSseStreamParamKeys.WARNING_CODE, str);
        bundle.putString(AsrSseStreamParamKeys.WARNING_MESSAGE, str2);
        lb.n nVar = lb.n.f10413a;
        return new d.q("", null, bundle, 2);
    }

    public final int activeSessionCount$ability_release() {
        return this.sessions.size();
    }

    public final void bindPcmDump(String inferId, AsrPcmDumpSink sink) {
        boolean zContains;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(sink, "sink");
        Set<String> terminated = this.terminated;
        kotlin.jvm.internal.g.e(terminated, "terminated");
        synchronized (terminated) {
            zContains = this.terminated.contains(inferId);
        }
        if (zContains) {
            return;
        }
        this.pcmDumpByInfer.putIfAbsent(inferId, sink);
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
                try {
                    sessionRemove.getPcmSink().close();
                    lb.n nVar = lb.n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
                kotlin.jvm.internal.g.c(str);
                closePcmDump(str);
            }
        }
        Set<String> setKeySet2 = this.pcmDumpByInfer.keySet();
        kotlin.jvm.internal.g.e(setKeySet2, "<get-keys>(...)");
        for (String str2 : kotlin.collections.a.O0(setKeySet2)) {
            kotlin.jvm.internal.g.c(str2);
            closePcmDump(str2);
        }
    }

    public final void closePcmDump(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        AsrPcmDumpSink asrPcmDumpSinkRemove = this.pcmDumpByInfer.remove(inferId);
        if (asrPcmDumpSinkRemove != null) {
            asrPcmDumpSinkRemove.close(inferId);
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
        Session sessionComputeIfAbsent = this.sessions.computeIfAbsent(inferId, new w(new v(3), 2));
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
        Session sessionComputeIfAbsent = this.sessions.computeIfAbsent(inferId, new w(new v(2), 1));
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
        if (params != null && params.getBoolean(AsrSseStreamParamKeys.FEED_EOF, false)) {
            int i10 = params.getInt(AsrSseStreamParamKeys.FEED_TOTAL, -1);
            session.setClientTotal(i10);
            AsrFeedReorderBuffer reorder = session.getReorder();
            if (reorder != null) {
                reorder.markTotal(i10);
                return;
            }
            return;
        }
        if (params != null && params.getBoolean(AsrSseStreamParamKeys.VAD_GATE, false)) {
            int i11 = params.getInt(AsrSseStreamParamKeys.FEED_SEQ, -1);
            if (i11 >= 0) {
                ensureReorder(inferId, session).offer(i11, audioContent);
                return;
            } else {
                enqueueItem(inferId, session, new StreamItem.VadGate(params.getBoolean(AsrSseStreamParamKeys.VAD_ENABLED, false), extractVadTuning(params)));
                return;
            }
        }
        if (audioContent.getAudioBytes().length == 0) {
            return;
        }
        long jIncrementAndGet = session.getFedFrames().incrementAndGet();
        session.getFedBytes().addAndGet(audioContent.getAudioBytes().length);
        if (jIncrementAndGet == 1) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long openedAtMs = session.getOpenedAtMs();
            LogModule logModule = LogModule.ABILITY;
            String str = this.tag;
            int length = audioContent.getAudioBytes().length;
            int sampleRate = audioContent.getSampleRate();
            int channelCount = audioContent.getChannelCount();
            String strValueOf = openedAtMs > 0 ? String.valueOf(jElapsedRealtime - openedAtMs) : "n/a";
            StringBuilder sbF = h0.e.f("[ASR-SSE-STREAM] first_pcm inferId=", inferId, " bytes=", length, " sr=");
            h0.e.l(sbF, sampleRate, " ch=", channelCount, " sinceOpenMs=");
            a0.a.z(sbF, strValueOf, logModule, str);
        }
        int i12 = params != null ? params.getInt(AsrSseStreamParamKeys.FEED_SEQ, -1) : -1;
        if (i12 >= 0) {
            ensureReorder(inferId, session).offer(i12, audioContent);
        } else {
            feedPcmDump(inferId, audioContent);
            enqueueItem(inferId, session, new StreamItem.Pcm(audioContent.getAudioBytes()));
        }
    }

    public final Flow<Result<d.q>> openSession(Context context, String inferId, Bundle bundle, p6.j jVar, long j10, int i10, Object obj, String businessTraceId, NetworkPolicy networkPolicy) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(businessTraceId, "businessTraceId");
        kotlin.jvm.internal.g.f(networkPolicy, "networkPolicy");
        return FlowKt__ContextKt.buffer$default(FlowKt.flowOn(FlowKt.channelFlow(new C03341(inferId, obj, businessTraceId, i10, bundle, j10, jVar, context, networkPolicy, null)), VadNativeDispatch.INSTANCE.getDispatcher()), 64, null, 2, null);
    }

    public /* synthetic */ AsrSseStreamSessionManager(String str, zb.q qVar, zb.l lVar, zb.w wVar, int i10, kotlin.jvm.internal.e eVar) {
        this(str, (i10 & 2) != 0 ? null : qVar, (i10 & 4) != 0 ? new AnonymousClass1(CloudNetworkEvaluator.INSTANCE) : lVar, wVar);
    }
}
