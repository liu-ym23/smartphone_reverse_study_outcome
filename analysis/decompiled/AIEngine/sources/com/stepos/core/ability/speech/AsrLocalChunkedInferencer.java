package com.stepos.core.ability.speech;

import com.stepos.base.protocol.AsrFeedKind;
import com.stepos.core.common.telemetry.TrackerContext;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import e7.a;
import java.util.List;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrLocalChunkedInferencer {
    public static final AsrLocalChunkedInferencer INSTANCE = new AsrLocalChunkedInferencer();
    private static final String TAG = "AsrLocalChunkedInferencer";
    private static final long TOKEN_LIMIT_BISECT_MIN_MS = 2000;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ChunkEvent {
        private final long endMs;
        private final boolean isRecognized;
        private final int segmentIndex;
        private final long startMs;
        private final String text;

        public ChunkEvent(String text, long j10, long j11, int i10, boolean z) {
            kotlin.jvm.internal.g.f(text, "text");
            this.text = text;
            this.startMs = j10;
            this.endMs = j11;
            this.segmentIndex = i10;
            this.isRecognized = z;
        }

        public static /* synthetic */ ChunkEvent copy$default(ChunkEvent chunkEvent, String str, long j10, long j11, int i10, boolean z, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = chunkEvent.text;
            }
            if ((i11 & 2) != 0) {
                j10 = chunkEvent.startMs;
            }
            if ((i11 & 4) != 0) {
                j11 = chunkEvent.endMs;
            }
            if ((i11 & 8) != 0) {
                i10 = chunkEvent.segmentIndex;
            }
            if ((i11 & 16) != 0) {
                z = chunkEvent.isRecognized;
            }
            long j12 = j11;
            return chunkEvent.copy(str, j10, j12, i10, z);
        }

        public final String component1() {
            return this.text;
        }

        public final long component2() {
            return this.startMs;
        }

        public final long component3() {
            return this.endMs;
        }

        public final int component4() {
            return this.segmentIndex;
        }

        public final boolean component5() {
            return this.isRecognized;
        }

        public final ChunkEvent copy(String text, long j10, long j11, int i10, boolean z) {
            kotlin.jvm.internal.g.f(text, "text");
            return new ChunkEvent(text, j10, j11, i10, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChunkEvent)) {
                return false;
            }
            ChunkEvent chunkEvent = (ChunkEvent) obj;
            return kotlin.jvm.internal.g.b(this.text, chunkEvent.text) && this.startMs == chunkEvent.startMs && this.endMs == chunkEvent.endMs && this.segmentIndex == chunkEvent.segmentIndex && this.isRecognized == chunkEvent.isRecognized;
        }

        public final long getEndMs() {
            return this.endMs;
        }

        public final int getSegmentIndex() {
            return this.segmentIndex;
        }

        public final long getStartMs() {
            return this.startMs;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isRecognized) + ai.onnxruntime.a.d(this.segmentIndex, a0.a.c(a0.a.c(this.text.hashCode() * 31, this.startMs, 31), this.endMs, 31), 31);
        }

        public final boolean isRecognized() {
            return this.isRecognized;
        }

        public String toString() {
            String str = this.text;
            long j10 = this.startMs;
            long j11 = this.endMs;
            int i10 = this.segmentIndex;
            boolean z = this.isRecognized;
            StringBuilder sbL = com.stepos.core.ota.d.l("ChunkEvent(text=", j10, str, ", startMs=");
            a0.a.s(j11, ", endMs=", ", segmentIndex=", sbL);
            sbL.append(i10);
            sbL.append(", isRecognized=");
            sbL.append(z);
            sbL.append(")");
            return sbL.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class InferResult {
        private final long lastEndMs;
        private final String text;

        public InferResult(String text, long j10) {
            kotlin.jvm.internal.g.f(text, "text");
            this.text = text;
            this.lastEndMs = j10;
        }

        public static /* synthetic */ InferResult copy$default(InferResult inferResult, String str, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inferResult.text;
            }
            if ((i10 & 2) != 0) {
                j10 = inferResult.lastEndMs;
            }
            return inferResult.copy(str, j10);
        }

        public final String component1() {
            return this.text;
        }

        public final long component2() {
            return this.lastEndMs;
        }

        public final InferResult copy(String text, long j10) {
            kotlin.jvm.internal.g.f(text, "text");
            return new InferResult(text, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InferResult)) {
                return false;
            }
            InferResult inferResult = (InferResult) obj;
            return kotlin.jvm.internal.g.b(this.text, inferResult.text) && this.lastEndMs == inferResult.lastEndMs;
        }

        public final long getLastEndMs() {
            return this.lastEndMs;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return Long.hashCode(this.lastEndMs) + (this.text.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sbL = com.stepos.core.ota.d.l("InferResult(text=", this.lastEndMs, this.text, ", lastEndMs=");
            sbL.append(")");
            return sbL.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrLocalChunkedInferencer", f = "AsrLocalChunkedInferencer.kt", l = {258, 258}, m = "collectProcessAudio")
    /* renamed from: com.stepos.core.ability.speech.AsrLocalChunkedInferencer$collectProcessAudio$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrLocalChunkedInferencer.this.collectProcessAudio(null, null, 0, 0, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrLocalChunkedInferencer", f = "AsrLocalChunkedInferencer.kt", l = {222}, m = "feedSegmentOnce")
    /* renamed from: com.stepos.core.ability.speech.AsrLocalChunkedInferencer$feedSegmentOnce$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03111 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C03111(qb.b<? super C03111> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrLocalChunkedInferencer.this.feedSegmentOnce(null, null, 0, 0, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrLocalChunkedInferencer", f = "AsrLocalChunkedInferencer.kt", l = {153, 177, 178}, m = "feedSegmentWithBisect")
    /* renamed from: com.stepos.core.ability.speech.AsrLocalChunkedInferencer$feedSegmentWithBisect$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03121 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C03121(qb.b<? super C03121> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrLocalChunkedInferencer.this.feedSegmentWithBisect(null, null, 0, 0, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrLocalChunkedInferencer$infer$2", f = "AsrLocalChunkedInferencer.kt", l = {ErrorCodes.SERVICE_RECYCLE_ERROR}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrLocalChunkedInferencer$infer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03132 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super InferResult>, Object> {
        final /* synthetic */ String $inferId;
        final /* synthetic */ short[] $pcm;
        final /* synthetic */ e7.a $protocol;
        final /* synthetic */ Object $record;
        final /* synthetic */ int $sampleRate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03132(e7.a aVar, short[] sArr, int i10, String str, Object obj, qb.b<? super C03132> bVar) {
            super(2, bVar);
            this.$protocol = aVar;
            this.$pcm = sArr;
            this.$sampleRate = i10;
            this.$inferId = str;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new C03132(this.$protocol, this.$pcm, this.$sampleRate, this.$inferId, this.$record, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                return obj;
            }
            kotlin.c.b(obj);
            AsrLocalChunkedInferencer asrLocalChunkedInferencer = AsrLocalChunkedInferencer.INSTANCE;
            e7.a aVar = this.$protocol;
            short[] sArr = this.$pcm;
            int i11 = this.$sampleRate;
            String str = this.$inferId;
            Object obj2 = this.$record;
            this.label = 1;
            Object objInferOnNativeThread = asrLocalChunkedInferencer.inferOnNativeThread(aVar, sArr, i11, str, obj2, this);
            return objInferOnNativeThread == coroutineSingletons ? coroutineSingletons : objInferOnNativeThread;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super InferResult> bVar) {
            return ((C03132) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrLocalChunkedInferencer", f = "AsrLocalChunkedInferencer.kt", l = {79}, m = "inferOnNativeThread")
    /* renamed from: com.stepos.core.ability.speech.AsrLocalChunkedInferencer$inferOnNativeThread$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03141(qb.b<? super C03141> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrLocalChunkedInferencer.this.inferOnNativeThread(null, null, 0, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrLocalChunkedInferencer$inferOnNativeThreadFlow$1", f = "AsrLocalChunkedInferencer.kt", l = {116, 116, 129, 129}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrLocalChunkedInferencer$inferOnNativeThreadFlow$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03161 extends SuspendLambda implements zb.p<FlowCollector<? super ChunkEvent>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $inferId;
        final /* synthetic */ short[] $pcm;
        final /* synthetic */ e7.a $protocol;
        final /* synthetic */ Object $record;
        final /* synthetic */ int $sampleRate;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03161(short[] sArr, String str, int i10, e7.a aVar, Object obj, qb.b<? super C03161> bVar) {
            super(2, bVar);
            this.$pcm = sArr;
            this.$inferId = str;
            this.$sampleRate = i10;
            this.$protocol = aVar;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03161 c03161 = new C03161(this.$pcm, this.$inferId, this.$sampleRate, this.$protocol, this.$record, bVar);
            c03161.L$0 = obj;
            return c03161;
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x023b, code lost:
        
            if (r8.emit(r9, r6) == r7) goto L31;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0243  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x02ef  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x023b -> B:39:0x023e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instructions count: 773
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalChunkedInferencer.C03161.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super ChunkEvent> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C03161) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    private AsrLocalChunkedInferencer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collectProcessAudio(e7.a r18, short[] r19, int r20, int r21, java.lang.Object r22, qb.b<? super java.util.List<com.stepos.core.ability.speech.AsrLocalChunkedInferencer.ChunkEvent>> r23) {
        /*
            r17 = this;
            r0 = r23
            boolean r1 = r0 instanceof com.stepos.core.ability.speech.AsrLocalChunkedInferencer.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r0
            com.stepos.core.ability.speech.AsrLocalChunkedInferencer$collectProcessAudio$1 r1 = (com.stepos.core.ability.speech.AsrLocalChunkedInferencer.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1c
        L15:
            com.stepos.core.ability.speech.AsrLocalChunkedInferencer$collectProcessAudio$1 r1 = new com.stepos.core.ability.speech.AsrLocalChunkedInferencer$collectProcessAudio$1
            r2 = r17
            r1.<init>(r0)
        L1c:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L50
            if (r3 == r5) goto L3a
            if (r3 != r4) goto L32
            java.lang.Object r1 = r1.L$0
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            kotlin.c.b(r0)
            return r1
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            int r3 = r1.I$0
            java.lang.Object r5 = r1.L$3
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref$LongRef) r5
            java.lang.Object r6 = r1.L$2
            java.util.HashMap r6 = (java.util.HashMap) r6
            java.lang.Object r7 = r1.L$1
            java.util.HashMap r7 = (java.util.HashMap) r7
            java.lang.Object r8 = r1.L$0
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            kotlin.c.b(r0)
            goto L93
        L50:
            kotlin.c.b(r0)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            v6.c$a r9 = new v6.c$a
            r14 = 0
            r15 = 508(0x1fc, float:7.12E-43)
            r12 = 0
            r13 = 0
            r10 = r19
            r11 = r20
            r9.<init>(r10, r11, r12, r13, r14, r15)
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            kotlin.jvm.internal.Ref$LongRef r0 = new kotlin.jvm.internal.Ref$LongRef
            r0.<init>()
            r1.L$0 = r8
            r1.L$1 = r7
            r1.L$2 = r6
            r1.L$3 = r0
            r3 = r21
            r1.I$0 = r3
            r1.label = r5
            r5 = r18
            r10 = r22
            java.lang.Object r5 = r5.processAudio(r9, r10, r1)
            if (r5 != r2) goto L8e
            goto Lb9
        L8e:
            r16 = r5
            r5 = r0
            r0 = r16
        L93:
            kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
            com.stepos.core.ability.speech.AsrLocalChunkedInferencer$collectProcessAudio$2 r9 = new com.stepos.core.ability.speech.AsrLocalChunkedInferencer$collectProcessAudio$2
            r22 = r3
            r20 = r5
            r19 = r6
            r18 = r7
            r21 = r8
            r17 = r9
            r17.<init>()
            r3 = r17
            r1.L$0 = r8
            r5 = 0
            r1.L$1 = r5
            r1.L$2 = r5
            r1.L$3 = r5
            r1.label = r4
            java.lang.Object r0 = r0.collect(r3, r1)
            if (r0 != r2) goto Lba
        Lb9:
            return r2
        Lba:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalChunkedInferencer.collectProcessAudio(e7.a, short[], int, int, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object feedSegment(e7.a aVar, AsrFileSegment asrFileSegment, int i10, int i11, String str, Object obj, qb.b<? super List<ChunkEvent>> bVar) {
        return feedSegmentWithBisect(aVar, asrFileSegment, i10, i11, str, obj, bVar);
    }

    public static /* synthetic */ Object feedSegment$default(AsrLocalChunkedInferencer asrLocalChunkedInferencer, e7.a aVar, AsrFileSegment asrFileSegment, int i10, int i11, String str, Object obj, qb.b bVar, int i12, Object obj2) {
        if ((i12 & 16) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i12 & 32) != 0) {
            obj = null;
        }
        return asrLocalChunkedInferencer.feedSegment(aVar, asrFileSegment, i10, i11, str2, obj, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object feedSegmentOnce(e7.a r27, final com.stepos.core.ability.speech.AsrFileSegment r28, int r29, final int r30, java.lang.Object r31, qb.b<? super java.util.List<com.stepos.core.ability.speech.AsrLocalChunkedInferencer.ChunkEvent>> r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalChunkedInferencer.feedSegmentOnce(e7.a, com.stepos.core.ability.speech.AsrFileSegment, int, int, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean feedSegmentOnce$lambda$2(Object obj, e7.a aVar, c.a aVar2, AsrLocalChunkedInferencer$feedSegmentOnce$callback$1 asrLocalChunkedInferencer$feedSegmentOnce$callback$1) {
        TrackerContext.Key key = TrackerContext.Key;
        Object obj2 = key.getThreadLocal().get();
        key.getThreadLocal().set(obj);
        try {
            boolean zFeedAudioFrame = aVar.feedAudioFrame(aVar2, true, asrLocalChunkedInferencer$feedSegmentOnce$callback$1, AsrFeedKind.f6376b);
            ThreadLocal<Object> threadLocal = key.getThreadLocal();
            if (obj2 == null) {
                threadLocal.remove();
                return zFeedAudioFrame;
            }
            threadLocal.set(obj2);
            return zFeedAudioFrame;
        } catch (Throwable th) {
            ThreadLocal<Object> threadLocal2 = key.getThreadLocal();
            if (obj2 == null) {
                threadLocal2.remove();
            } else {
                threadLocal2.set(obj2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object feedSegmentWithBisect(e7.a r21, com.stepos.core.ability.speech.AsrFileSegment r22, int r23, int r24, java.lang.String r25, java.lang.Object r26, qb.b<? super java.util.List<com.stepos.core.ability.speech.AsrLocalChunkedInferencer.ChunkEvent>> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalChunkedInferencer.feedSegmentWithBisect(e7.a, com.stepos.core.ability.speech.AsrFileSegment, int, int, java.lang.String, java.lang.Object, qb.b):java.lang.Object");
    }

    public static /* synthetic */ Object infer$default(AsrLocalChunkedInferencer asrLocalChunkedInferencer, e7.a aVar, short[] sArr, int i10, String str, Object obj, qb.b bVar, int i11, Object obj2) {
        if ((i11 & 8) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i11 & 16) != 0) {
            obj = null;
        }
        return asrLocalChunkedInferencer.infer(aVar, sArr, i10, str2, obj, bVar);
    }

    public static /* synthetic */ Flow inferFlow$default(AsrLocalChunkedInferencer asrLocalChunkedInferencer, e7.a aVar, short[] sArr, int i10, String str, Object obj, int i11, Object obj2) {
        if ((i11 & 8) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i11 & 16) != 0) {
            obj = null;
        }
        return asrLocalChunkedInferencer.inferFlow(aVar, sArr, i10, str2, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object inferOnNativeThread(e7.a r15, short[] r16, int r17, java.lang.String r18, java.lang.Object r19, qb.b<? super com.stepos.core.ability.speech.AsrLocalChunkedInferencer.InferResult> r20) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalChunkedInferencer.inferOnNativeThread(e7.a, short[], int, java.lang.String, java.lang.Object, qb.b):java.lang.Object");
    }

    private final Flow<ChunkEvent> inferOnNativeThreadFlow(e7.a aVar, short[] sArr, int i10, String str, Object obj) {
        return FlowKt.flow(new C03161(sArr, str, i10, aVar, obj, null));
    }

    private final boolean isTokenLimitError(Throwable th) {
        String message = th.getMessage();
        return message != null && gc.q.l0(message, "token limit", true);
    }

    private final boolean supportsFeedAudioFrame(e7.a aVar) {
        try {
            return !kotlin.jvm.internal.g.b(aVar.getClass().getMethod("feedAudioFrame", c.a.class, Boolean.TYPE, a.InterfaceC0076a.class, AsrFeedKind.class).getDeclaringClass(), e7.a.class);
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean useChunkedFeed(e7.a aVar, List<AsrFileSegment> list) {
        return list.size() > 1 && supportsFeedAudioFrame(aVar);
    }

    public final Object infer(e7.a aVar, short[] sArr, int i10, String str, Object obj, qb.b<? super InferResult> bVar) {
        return BuildersKt.withContext(AsrNativeDispatch.INSTANCE.getDispatcher(), new C03132(aVar, sArr, i10, str, obj, null), bVar);
    }

    public final Flow<ChunkEvent> inferFlow(e7.a protocol, short[] pcm, int i10, String inferId, Object obj) {
        kotlin.jvm.internal.g.f(protocol, "protocol");
        kotlin.jvm.internal.g.f(pcm, "pcm");
        kotlin.jvm.internal.g.f(inferId, "inferId");
        return FlowKt.flowOn(inferOnNativeThreadFlow(protocol, pcm, i10, inferId, obj), AsrNativeDispatch.INSTANCE.getDispatcher());
    }
}
