package com.stepos.core.ability.speech;

import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.stepos.base.ability.AbilityBase;
import com.stepos.base.model.ModelReleaseReason;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.base.strategy.ExecutionPreference;
import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.core.ability.converter.AsrAudioFileDecoder;
import com.stepos.core.ability.speech.AsrLocalChunkedInferencer;
import com.stepos.core.ability.speech.AsrSseEvent;
import com.stepos.core.ability.telemetry.ModelCallBridge;
import com.stepos.core.common.cloud.AccountLoginState;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.task.AITaskRecord;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import com.stepos.core.ota.process.OtaIdleExitPolicy;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrSseAbility extends AbilityBase<c.a, d.q> {
    private static final String CODEC_PCM_S16LE = "pcm_s16le";
    private static final long DEFAULT_AUDIO_MAX_BYTES = 33554432;
    private static final String EVENT_DELTA = "asr.delta";
    private static final String EVENT_DONE = "asr.done";
    private static final String EVENT_RECOGNIZED = "asr.recognized";
    private static final String EXTRA_EVENT_TYPE = "asr.event_type";
    private static final String EXTRA_SEGMENT_END_MS = "asr.segment.end_ms";
    private static final String EXTRA_SEGMENT_INDEX = "asr.segment.index";
    private static final String EXTRA_SEGMENT_SPEAKER_ID = "asr.segment.speaker_id";
    private static final String EXTRA_SEGMENT_START_MS = "asr.segment.start_ms";
    private static final int MONO = 1;
    private static final int PCM16_BITS = 16;
    private final String TAG;
    private final lb.d cloudSseClient$delegate;
    private final lb.d streamSessions$delegate;
    private final boolean supportsFeedInput;
    public static final Companion Companion = new Companion(null);
    private static final Set<String> CONTAINER_EXTENSIONS = mb.l.s0(new String[]{"wav", "mp3", "ogg", "flac", "m4a", "aac", "amr"});
    private static final String FORMAT_PCM = "pcm";
    private static final Set<String> PCM_EXTENSIONS = mb.l.s0(new String[]{FORMAT_PCM, "raw"});

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AudioMeta {
        private final int bits;
        private final int channel;
        private final long durationMs;
        private final int sampleRate;

        public AudioMeta(long j10, int i10, int i11, int i12) {
            this.durationMs = j10;
            this.sampleRate = i10;
            this.bits = i11;
            this.channel = i12;
        }

        public static /* synthetic */ AudioMeta copy$default(AudioMeta audioMeta, long j10, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                j10 = audioMeta.durationMs;
            }
            long j11 = j10;
            if ((i13 & 2) != 0) {
                i10 = audioMeta.sampleRate;
            }
            int i14 = i10;
            if ((i13 & 4) != 0) {
                i11 = audioMeta.bits;
            }
            int i15 = i11;
            if ((i13 & 8) != 0) {
                i12 = audioMeta.channel;
            }
            return audioMeta.copy(j11, i14, i15, i12);
        }

        public final long component1() {
            return this.durationMs;
        }

        public final int component2() {
            return this.sampleRate;
        }

        public final int component3() {
            return this.bits;
        }

        public final int component4() {
            return this.channel;
        }

        public final AudioMeta copy(long j10, int i10, int i11, int i12) {
            return new AudioMeta(j10, i10, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioMeta)) {
                return false;
            }
            AudioMeta audioMeta = (AudioMeta) obj;
            return this.durationMs == audioMeta.durationMs && this.sampleRate == audioMeta.sampleRate && this.bits == audioMeta.bits && this.channel == audioMeta.channel;
        }

        public final int getBits() {
            return this.bits;
        }

        public final int getChannel() {
            return this.channel;
        }

        public final long getDurationMs() {
            return this.durationMs;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public int hashCode() {
            return Integer.hashCode(this.channel) + ai.onnxruntime.a.d(this.bits, ai.onnxruntime.a.d(this.sampleRate, Long.hashCode(this.durationMs) * 31, 31), 31);
        }

        public String toString() {
            long j10 = this.durationMs;
            int i10 = this.sampleRate;
            int i11 = this.bits;
            int i12 = this.channel;
            StringBuilder sbR = ai.onnxruntime.a.r(j10, "AudioMeta(durationMs=", ", sampleRate=", i10);
            sbR.append(", bits=");
            sbR.append(i11);
            sbR.append(", channel=");
            sbR.append(i12);
            sbR.append(")");
            return sbR.toString();
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
    public static final class EncodedAudio {
        private final byte[] bytes;
        private final String codec;
        private final String formatType;
        private final long rawByteCount;

        public EncodedAudio(byte[] bytes, long j10, String formatType, String str) {
            kotlin.jvm.internal.g.f(bytes, "bytes");
            kotlin.jvm.internal.g.f(formatType, "formatType");
            this.bytes = bytes;
            this.rawByteCount = j10;
            this.formatType = formatType;
            this.codec = str;
        }

        public static /* synthetic */ EncodedAudio copy$default(EncodedAudio encodedAudio, byte[] bArr, long j10, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bArr = encodedAudio.bytes;
            }
            if ((i10 & 2) != 0) {
                j10 = encodedAudio.rawByteCount;
            }
            if ((i10 & 4) != 0) {
                str = encodedAudio.formatType;
            }
            if ((i10 & 8) != 0) {
                str2 = encodedAudio.codec;
            }
            return encodedAudio.copy(bArr, j10, str, str2);
        }

        public final byte[] component1() {
            return this.bytes;
        }

        public final long component2() {
            return this.rawByteCount;
        }

        public final String component3() {
            return this.formatType;
        }

        public final String component4() {
            return this.codec;
        }

        public final EncodedAudio copy(byte[] bytes, long j10, String formatType, String str) {
            kotlin.jvm.internal.g.f(bytes, "bytes");
            kotlin.jvm.internal.g.f(formatType, "formatType");
            return new EncodedAudio(bytes, j10, formatType, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EncodedAudio)) {
                return false;
            }
            EncodedAudio encodedAudio = (EncodedAudio) obj;
            return kotlin.jvm.internal.g.b(this.bytes, encodedAudio.bytes) && this.rawByteCount == encodedAudio.rawByteCount && kotlin.jvm.internal.g.b(this.formatType, encodedAudio.formatType) && kotlin.jvm.internal.g.b(this.codec, encodedAudio.codec);
        }

        public final byte[] getBytes() {
            return this.bytes;
        }

        public final String getCodec() {
            return this.codec;
        }

        public final String getFormatType() {
            return this.formatType;
        }

        public final long getRawByteCount() {
            return this.rawByteCount;
        }

        public int hashCode() {
            int iA = v1.d.a(a0.a.c(Arrays.hashCode(this.bytes) * 31, this.rawByteCount, 31), 31, this.formatType);
            String str = this.codec;
            return iA + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String string = Arrays.toString(this.bytes);
            long j10 = this.rawByteCount;
            String str = this.formatType;
            String str2 = this.codec;
            StringBuilder sbL = com.stepos.core.ota.d.l("EncodedAudio(bytes=", j10, string, ", rawByteCount=");
            ai.onnxruntime.a.z(sbL, ", formatType=", str, ", codec=", str2);
            sbL.append(")");
            return sbL.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.AsrSseAbility$buildOrchestrator$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements zb.a<Boolean> {
        public AnonymousClass1(Object obj) {
            super(0, obj, AccountLoginState.class, "isLoggedIn", "isLoggedIn()Z", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // zb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((AccountLoginState) this.receiver).isLoggedIn());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrSseAbility$doFlowCloudInfer$2", f = "AsrSseAbility.kt", l = {159}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrSseAbility$doFlowCloudInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(kotlin.c.a(new OrchestrationRejectedException(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED, "Cloud ASR-SSE not configured: cloud.enable is false in abilities.json")));
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
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

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrSseAbility$doFlowCloudInfer$3", f = "AsrSseAbility.kt", l = {169}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrSseAbility$doFlowCloudInfer$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ OrchestrationRejectedException $e;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(OrchestrationRejectedException orchestrationRejectedException, qb.b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$e = orchestrationRejectedException;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$e, bVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(kotlin.c.a(this.$e));
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
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

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass3) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrSseAbility$doFlowCloudInfer$5", f = "AsrSseAbility.kt", l = {199}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrSseAbility$doFlowCloudInfer$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass5(qb.b<? super AnonymousClass5> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(bVar);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(kotlin.c.a(new OrchestrationRejectedException(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED, "Cloud ASR-SSE not configured: cloud.enable is false in abilities.json")));
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
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

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass5) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrSseAbility$doFlowCloudInfer$6", f = "AsrSseAbility.kt", l = {229, 247, 271, 283, 335, 373}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrSseAbility$doFlowCloudInfer$6, reason: invalid class name */
    public static final class AnonymousClass6 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $callerPkg;
        final /* synthetic */ int $callerUid;
        final /* synthetic */ p6.a $cfg;
        final /* synthetic */ String $id;
        final /* synthetic */ c.a $input;
        final /* synthetic */ String $sceneType;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(c.a aVar, String str, p6.a aVar2, int i10, String str2, String str3, qb.b<? super AnonymousClass6> bVar) {
            super(2, bVar);
            this.$input = aVar;
            this.$id = str;
            this.$cfg = aVar2;
            this.$callerUid = i10;
            this.$callerPkg = str2;
            this.$sceneType = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$6(String str, CloudSessionCorrelationState cloudSessionCorrelationState) {
            ModelCallBridge.INSTANCE.logEstablished(str, cloudSessionCorrelationState);
            return lb.n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass6 anonymousClass6 = AsrSseAbility.this.new AnonymousClass6(this.$input, this.$id, this.$cfg, this.$callerUid, this.$callerPkg, this.$sceneType, bVar);
            anonymousClass6.L$0 = obj;
            return anonymousClass6;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:105:0x03b7, code lost:
        
            if (r6.emit(r3, r35) == r2) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x03e1, code lost:
        
            if (r12.emit(r3, r35) != r2) goto L113;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00da, code lost:
        
            if (r12.emit(r3, r35) == r2) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0168, code lost:
        
            if (r12.emit(r3, r35) == r2) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x01e8, code lost:
        
            if (r12.emit(r3, r35) == r2) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x035b, code lost:
        
            if (r0.collect(r5, r35) == r2) goto L112;
         */
        /* JADX WARN: Removed duplicated region for block: B:100:0x037a  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x0382  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x036d  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0371  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0374  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) {
            /*
                Method dump skipped, instructions count: 1018
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrSseAbility.AnonymousClass6.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass6) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrSseAbility$doFlowInfer$2", f = "AsrSseAbility.kt", l = {574, 578, 584, 593}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrSseAbility$doFlowInfer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03322 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ c.a $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ AsrSseAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03322(c.a aVar, AsrSseAbility asrSseAbility, Object obj, qb.b<? super C03322> bVar) {
            super(2, bVar);
            this.$input = aVar;
            this.this$0 = asrSseAbility;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03322 c03322 = new C03322(this.$input, this.this$0, this.$record, bVar);
            c03322.L$0 = obj;
            return c03322;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0165, code lost:
        
            if (r4.emit(r0, r14) != r1) goto L55;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v2 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 363
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrSseAbility.C03322.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C03322) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrSseAbility$transcribeStreamPcm$2", f = "AsrSseAbility.kt", l = {444, 493, 533}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrSseAbility$transcribeStreamPcm$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03332 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $businessTraceId;
        final /* synthetic */ int $channelCount;
        final /* synthetic */ String $inferId;
        final /* synthetic */ byte[] $pcm;
        final /* synthetic */ Object $record;
        final /* synthetic */ int $sampleRate;
        final /* synthetic */ long $segmentEndMs;
        final /* synthetic */ long $segmentStartMs;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03332(Object obj, byte[] bArr, int i10, int i11, String str, String str2, long j10, long j11, qb.b<? super C03332> bVar) {
            super(2, bVar);
            this.$record = obj;
            this.$pcm = bArr;
            this.$sampleRate = i10;
            this.$channelCount = i11;
            this.$businessTraceId = str;
            this.$inferId = str2;
            this.$segmentStartMs = j10;
            this.$segmentEndMs = j11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$0(String str, CloudSessionCorrelationState cloudSessionCorrelationState) {
            ModelCallBridge.INSTANCE.logEstablished(str, cloudSessionCorrelationState);
            return lb.n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03332 c03332 = AsrSseAbility.this.new C03332(this.$record, this.$pcm, this.$sampleRate, this.$channelCount, this.$businessTraceId, this.$inferId, this.$segmentStartMs, this.$segmentEndMs, bVar);
            c03332.L$0 = obj;
            return c03332;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x016b, code lost:
        
            if (r0.collect(r8, r34) == r2) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x01c4, code lost:
        
            if (r6.emit(r3, r34) == r2) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x01da, code lost:
        
            if (r15.emit(r3, r34) != r2) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x01dc, code lost:
        
            return r2;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x017e  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0181  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x018f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r35) {
            /*
                Method dump skipped, instructions count: 480
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrSseAbility.C03332.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C03332) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrSseAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        kotlin.jvm.internal.g.f(abilityConfig, "abilityConfig");
        this.TAG = "AsrSseAbility";
        this.cloudSseClient$delegate = kotlin.b.b(new m0(this, 2));
        this.streamSessions$delegate = kotlin.b.b(new e(this, 3));
        this.supportsFeedInput = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsrCloudSseClient cloudSseClient_delegate$lambda$0(AsrSseAbility asrSseAbility) {
        return new AsrCloudSseClient(asrSseAbility.getAbilityConfig().f11423i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EncodedAudio encodeAudio(c.a aVar) throws IOException {
        String strResolveFormatType = resolveFormatType(aVar);
        String str = aVar.f13389e;
        short[] sArr = aVar.f13386b;
        if (str != null && !gc.q.t0(str)) {
            File file = new File(str);
            if (!file.canRead()) {
                throw new IllegalArgumentException(ai.onnxruntime.a.k("Audio file not readable: ", str).toString());
            }
            return new EncodedAudio(wb.d.X(file), r1.length, strResolveFormatType, kotlin.jvm.internal.g.b(strResolveFormatType, FORMAT_PCM) ? CODEC_PCM_S16LE : null);
        }
        if (sArr.length == 0) {
            throw new IllegalStateException("ASR-SSE requires localPath or audio buffer");
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(sArr.length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (short s8 : sArr) {
            byteBufferOrder.putShort(s8);
        }
        byte[] bArrArray = byteBufferOrder.array();
        kotlin.jvm.internal.g.c(bArrArray);
        return new EncodedAudio(bArrArray, bArrArray.length, FORMAT_PCM, CODEC_PCM_S16LE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c.a ensurePcmBuffer(c.a aVar) throws IOException {
        String str = aVar.f13389e;
        if (aVar.f13386b.length != 0) {
            return aVar;
        }
        if (str == null || gc.q.t0(str)) {
            return aVar;
        }
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(str), 268435456);
        try {
            AsrAudioFileDecoder asrAudioFileDecoder = AsrAudioFileDecoder.INSTANCE;
            kotlin.jvm.internal.g.c(parcelFileDescriptorOpen);
            short[] sArrDecodeFromPfd = asrAudioFileDecoder.decodeFromPfd(parcelFileDescriptorOpen);
            parcelFileDescriptorOpen.close();
            return c.a.c(aVar, sArrDecodeFromPfd, null, null, null, null, 510);
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extensionOf(String str) {
        String lowerCase = gc.q.H0(gc.q.H0(str, '/', str), '.', "").toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AsrCloudSseClient getCloudSseClient() {
        return (AsrCloudSseClient) this.cloudSseClient$delegate.getValue();
    }

    private final AsrSseStreamSessionManager getStreamSessions() {
        return (AsrSseStreamSessionManager) this.streamSessions$delegate.getValue();
    }

    private final boolean isStreamingStart(c.a aVar) {
        if (aVar.f13386b.length != 0) {
            return false;
        }
        String str = aVar.f13389e;
        if (str != null && !gc.q.t0(str)) {
            return false;
        }
        String str2 = aVar.f13388d;
        return (str2 == null || gc.q.t0(str2)) && !aVar.d();
    }

    private final AudioMeta pcmMeta(long j10, int i10) {
        return new AudioMeta(AsrAudioFileDecoder.INSTANCE.pcmDurationMs(j10, i10), i10, 16, 1);
    }

    private final AudioMeta probeAudioMeta(c.a aVar, String str, boolean z) {
        long length;
        Object objA;
        String str2 = aVar.f13389e;
        if (!kotlin.jvm.internal.g.b(str, FORMAT_PCM) && str2 != null && !gc.q.t0(str2)) {
            AsrAudioFileDecoder.AudioProbe audioProbeProbeAudioInfo = AsrAudioFileDecoder.INSTANCE.probeAudioInfo(str2, z);
            return new AudioMeta(audioProbeProbeAudioInfo.getDurationMs(), audioProbeProbeAudioInfo.getSampleRate(), audioProbeProbeAudioInfo.getBitsPerSample(), audioProbeProbeAudioInfo.getChannelCount());
        }
        if (str2 == null || gc.q.t0(str2)) {
            length = aVar.f13386b.length;
        } else {
            AsrAudioFileDecoder asrAudioFileDecoder = AsrAudioFileDecoder.INSTANCE;
            try {
                objA = Long.valueOf(new File(str2).length());
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = 0L;
            }
            length = asrAudioFileDecoder.pcmSampleCount(((Number) objA).longValue());
        }
        return pcmMeta(length, aVar.f13387c);
    }

    public static /* synthetic */ AudioMeta probeAudioMeta$default(AsrSseAbility asrSseAbility, c.a aVar, String str, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = asrSseAbility.resolveFormatType(aVar);
        }
        if ((i10 & 4) != 0) {
            z = true;
        }
        return asrSseAbility.probeAudioMeta(aVar, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e7.a requireAudioProtocol() {
        return (e7.a) getProtocolManager().b(ProtocolType.f6380c);
    }

    private final String resolveFormatFromPath(String str) {
        String strExtensionOf = extensionOf(str);
        return CONTAINER_EXTENSIONS.contains(strExtensionOf) ? strExtensionOf : PCM_EXTENSIONS.contains(strExtensionOf) ? FORMAT_PCM : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveFormatType(c.a aVar) {
        String str = aVar.f13389e;
        return (str == null || gc.q.t0(str)) ? FORMAT_PCM : resolveFormatFromPath(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p6.c sseParams() {
        return getAbilityConfig().f11425k.a("sse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q streamDeltaOutput(AsrSseEvent.Delta delta, long j10, long j11) {
        String text = delta.getText();
        Bundle bundle = new Bundle();
        bundle.putString("asr.event_type", "asr.delta");
        bundle.putInt("asr.segment.index", 0);
        bundle.putLong("asr.segment.start_ms", j10);
        bundle.putLong("asr.segment.end_ms", j11);
        lb.n nVar = lb.n.f10413a;
        return new d.q(text, null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q streamDoneOutput(String str, long j10, long j11) {
        Bundle bundle = new Bundle();
        bundle.putString("asr.event_type", "asr.done");
        bundle.putInt("asr.segment.index", 0);
        bundle.putLong("asr.segment.start_ms", j10);
        bundle.putLong("asr.segment.end_ms", j11);
        lb.n nVar = lb.n.f10413a;
        return new d.q(str, null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsrSseStreamSessionManager streamSessions_delegate$lambda$1(AsrSseAbility asrSseAbility) {
        return new AsrSseStreamSessionManager(asrSseAbility.TAG, null, null, new AsrSseAbility$streamSessions$2$1(asrSseAbility, null), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q toDeltaOutput(AsrSseEvent.Delta delta) {
        Bundle bundle = new Bundle();
        bundle.putString("asr.event_type", "asr.delta");
        bundle.putLong("asr.segment.start_ms", delta.getStartTimeMs());
        bundle.putLong("asr.segment.end_ms", delta.getEndTimeMs());
        return new d.q(delta.getText(), null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q toDoneOutput(AsrSseEvent.Done done) {
        Bundle bundle = new Bundle();
        bundle.putString("asr.event_type", "asr.done");
        return new d.q(done.getText(), null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q toRecognizedSegmentOutput(AsrLocalChunkedInferencer.ChunkEvent chunkEvent) {
        Bundle bundle = new Bundle();
        bundle.putString("asr.event_type", "asr.recognized");
        bundle.putInt("asr.segment.index", chunkEvent.getSegmentIndex());
        bundle.putLong("asr.segment.start_ms", chunkEvent.getStartMs());
        bundle.putLong("asr.segment.end_ms", chunkEvent.getEndMs());
        bundle.putString("asr.segment.speaker_id", "");
        return new d.q(chunkEvent.getText(), null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object transcribeStreamPcm(String str, byte[] bArr, int i10, int i11, long j10, long j11, Object obj, String str2, qb.b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new C03332(obj, bArr, i10, i11, str2, str, j10, j11, null));
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public Object acquire(qb.b<? super Boolean> bVar) {
        if (!getAbilityConfig().f11424j) {
            return super.acquire(bVar);
        }
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, "acquire: defer on-device model load (cloud-first, lazy per S4)");
        return Boolean.TRUE;
    }

    public final void bindStreamPcmDump(String inferId, AsrPcmDumpSink sink) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(sink, "sink");
        getStreamSessions().bindPcmDump(inferId, sink);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public h7.d buildOrchestrator() {
        return new AsrOrchestrator(getAbilityConfig().c(), getAbilityConfig().f11424j, new AnonymousClass1(AccountLoginState.INSTANCE));
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public boolean cancel() {
        getStreamSessions().cancelAll();
        return super.cancel();
    }

    public final void closeStreamPcmDump(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        getStreamSessions().closePcmDump(inferId);
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public void completeInput(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        getStreamSessions().completeInput(inferId);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowCloudInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowCloudInfer((c.a) cVar, obj, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.a) cVar, obj, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m57doInfergIAlus((c.a) cVar, (qb.b<? super Result<d.q>>) bVar);
    }

    public final Object ensureLocalReady(qb.b<? super Boolean> bVar) {
        if (requireAudioProtocol() != null) {
            return Boolean.TRUE;
        }
        Context context = l7.a.f10344a;
        if (context != null) {
            return internalPrepare(context, bVar);
        }
        throw new IllegalStateException("ContextHolder must be initialized before use!");
    }

    @Override // com.stepos.base.ability.AbilityBase
    public h7.b getExecutionConstraints(v6.c input) {
        String str;
        kotlin.jvm.internal.g.f(input, "input");
        c.a aVar = input instanceof c.a ? (c.a) input : null;
        if (aVar == null) {
            return h7.b.f9362d;
        }
        h7.b bVar = h7.b.f9362d;
        String str2 = aVar.f13388d;
        return (str2 == null || gc.q.t0(str2) || !(((str = aVar.f13389e) == null || gc.q.t0(str)) && aVar.f13386b.length == 0)) ? h7.b.a(bVar, aVar.f13391g) : h7.b.a(bVar, ExecutionPreference.f6388c);
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public boolean getSupportsFeedInput() {
        return this.supportsFeedInput;
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public void onFeedInput(String inferId, Object input) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        getStreamSessions().onFeedInput(inferId, input);
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public Object release(ModelReleaseReason modelReleaseReason, qb.b<? super lb.n> bVar) {
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, "release: reason=" + modelReleaseReason + ", cancelling all ASR-SSE streaming sessions");
        getStreamSessions().cancelAll();
        Object objRelease = super.release(modelReleaseReason, bVar);
        return objRelease == CoroutineSingletons.f10059a ? objRelease : lb.n.f10413a;
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public long cloudExecutionTimeoutMs(c.a input) {
        kotlin.jvm.internal.g.f(input, "input");
        long j10 = getAbilityConfig().f11423i;
        return !isStreamingStart(input) ? j10 : AsrSseStreamLimits.INSTANCE.executionBudgetMs(input.f13392i, sseParams().f11439a.optLong("audioMaxBytes", DEFAULT_AUDIO_MAX_BYTES), j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.base.ability.AbilityBase
    public d.q defaultOutput() {
        return new d.q("", null, 0 == true ? 1 : 0, 6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object doFlowCloudInfer(c.a aVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        String callerPackage;
        String str = aVar.f13393j;
        if (str.length() == 0) {
            str = "?";
        }
        String str2 = str;
        if (!isStreamingStart(aVar)) {
            LogModule logModule = LogModule.ABILITY;
            String str3 = this.TAG;
            String str4 = aVar.f13389e;
            boolean z = str4 == null || gc.q.t0(str4);
            int length = aVar.f13386b.length;
            boolean z3 = getAbilityConfig().f11424j;
            StringBuilder sbM = com.stepos.core.ota.d.m("[ASR-SSE] inferId=", str2, " stage=ROUTE enter hasLocalPath=", " bufferSamples=", !z);
            sbM.append(length);
            sbM.append(" cloudEnable=");
            sbM.append(z3);
            AIEngineLogger.i(logModule, str3, sbM.toString());
            p6.a abilityConfig = getAbilityConfig();
            if (abilityConfig.f11424j) {
                Pair<Integer, String> pairCallerFromRecord = ModelCallBridge.INSTANCE.callerFromRecord(obj);
                int iIntValue = pairCallerFromRecord.f9985a.intValue();
                String str5 = pairCallerFromRecord.f9986b;
                try {
                    return FlowKt.flow(new AnonymousClass6(aVar, str2, abilityConfig, iIntValue, str5, CloudSceneTypeGuard.require$default(CloudSceneTypeGuard.INSTANCE, abilityConfig, str5, null, 4, null), null));
                } catch (OrchestrationRejectedException e10) {
                    return FlowKt.flow(new AsrSseAbility$doFlowCloudInfer$sceneType$1(e10, null));
                }
            }
            AIEngineLogger.w(logModule, this.TAG, "[ASR-SSE] inferId=" + str2 + " stage=ROUTE reject reason=cloud.enable=false");
            return FlowKt.flow(new AnonymousClass5(null));
        }
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, "[ASR-SSE] inferId=" + str2 + " stage=ROUTE streaming session (openChannel)");
        if (!getAbilityConfig().f11424j) {
            return FlowKt.flow(new AnonymousClass2(null));
        }
        try {
            CloudSceneTypeGuard.require$default(CloudSceneTypeGuard.INSTANCE, getAbilityConfig(), ModelCallBridge.INSTANCE.callerFromRecord(obj).f9986b, null, 4, null);
            getCloudSseClient().warmConnection("asr_sse_open_channel");
            AsrSseStreamSessionManager streamSessions = getStreamSessions();
            String str6 = 0;
            Context context = l7.a.f10344a;
            if (context == null) {
                throw new IllegalStateException("ContextHolder must be initialized before use!");
            }
            Bundle bundle = aVar.f13392i;
            String str7 = aVar.f13385a;
            if (str7 == null) {
                str7 = "";
            }
            String str8 = str7;
            p6.j jVar = getAbilityConfig().f11431q;
            p6.j jVarA = str6;
            if (jVar != null) {
                AITaskRecord aITaskRecord = obj instanceof AITaskRecord ? (AITaskRecord) obj : null;
                if (aITaskRecord != null && (callerPackage = aITaskRecord.getCallerPackage()) != null && !gc.q.t0(callerPackage)) {
                    str6 = callerPackage;
                }
                jVarA = jVar.a(str6);
            }
            return streamSessions.openSession(context, str2, bundle, jVarA, sseParams().f11439a.optLong("audioMaxBytes", DEFAULT_AUDIO_MAX_BYTES), aVar.f13387c, obj, str8, getExecutionConstraints(aVar).f9364b);
        } catch (OrchestrationRejectedException e11) {
            return FlowKt.flow(new AnonymousClass3(e11, null));
        }
    }

    public Object doFlowInfer(c.a aVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new C03322(aVar, this, obj, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m57doInfergIAlus(v6.c.a r11, qb.b<? super kotlin.Result<v6.d.q>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.stepos.core.ability.speech.AsrSseAbility$doInfer$1
            if (r0 == 0) goto L14
            r0 = r12
            com.stepos.core.ability.speech.AsrSseAbility$doInfer$1 r0 = (com.stepos.core.ability.speech.AsrSseAbility$doInfer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            com.stepos.core.ability.speech.AsrSseAbility$doInfer$1 r0 = new com.stepos.core.ability.speech.AsrSseAbility$doInfer$1
            r0.<init>(r10, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r7.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r7.label
            r8 = 6
            r9 = 0
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.c.b(r12)     // Catch: java.lang.Exception -> L7f
            goto L73
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            kotlin.c.b(r12)
            r12 = r2
            e7.a r2 = r10.requireAudioProtocol()     // Catch: java.lang.Exception -> L7f
            if (r2 != 0) goto L49
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch: java.lang.Exception -> L7f
            java.lang.String r11 = "AudioProtocol not bound"
            r10.<init>(r11)     // Catch: java.lang.Exception -> L7f
            kotlin.Result$Failure r10 = kotlin.c.a(r10)     // Catch: java.lang.Exception -> L7f
            return r10
        L49:
            v6.c$a r10 = r10.ensurePcmBuffer(r11)     // Catch: java.lang.Exception -> L7f
            short[] r3 = r10.f13386b     // Catch: java.lang.Exception -> L7f
            int r1 = r3.length     // Catch: java.lang.Exception -> L7f
            if (r1 != 0) goto L5a
            v6.d$q r10 = new v6.d$q     // Catch: java.lang.Exception -> L7f
            java.lang.String r11 = ""
            r10.<init>(r11, r9, r9, r8)     // Catch: java.lang.Exception -> L7f
            return r10
        L5a:
            com.stepos.core.ability.speech.AsrLocalChunkedInferencer r1 = com.stepos.core.ability.speech.AsrLocalChunkedInferencer.INSTANCE     // Catch: java.lang.Exception -> L7f
            int r4 = r10.f13387c     // Catch: java.lang.Exception -> L7f
            java.lang.String r10 = r11.f13393j     // Catch: java.lang.Exception -> L7f
            int r11 = r10.length()     // Catch: java.lang.Exception -> L7f
            if (r11 != 0) goto L68
            java.lang.String r10 = "?"
        L68:
            r5 = r10
            r7.label = r12     // Catch: java.lang.Exception -> L7f
            r6 = 0
            java.lang.Object r12 = r1.infer(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L7f
            if (r12 != r0) goto L73
            return r0
        L73:
            com.stepos.core.ability.speech.AsrLocalChunkedInferencer$InferResult r12 = (com.stepos.core.ability.speech.AsrLocalChunkedInferencer.InferResult) r12     // Catch: java.lang.Exception -> L7f
            v6.d$q r10 = new v6.d$q     // Catch: java.lang.Exception -> L7f
            java.lang.String r11 = r12.getText()     // Catch: java.lang.Exception -> L7f
            r10.<init>(r11, r9, r9, r8)     // Catch: java.lang.Exception -> L7f
            return r10
        L7f:
            r0 = move-exception
            r10 = r0
            kotlin.Result$Failure r10 = kotlin.c.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrSseAbility.m57doInfergIAlus(v6.c$a, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.ability.AbilityBase
    public long localExecutionTimeoutMs(c.a input, long j10) {
        kotlin.jvm.internal.g.f(input, "input");
        long durationMs = probeAudioMeta$default(this, input, null, false, 2, null).getDurationMs();
        return durationMs <= 0 ? j10 : dc.h.b0(durationMs + HysteresisStrategy.DEFAULT_DWELL_MS, j10, OtaIdleExitPolicy.PAUSED_EXIT_MS);
    }
}
