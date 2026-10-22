package com.stepos.backend.qnn;

import android.util.Log;
import com.stepos.base.model.ModelBase;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnASRModel extends ModelBase implements e7.a, e7.h {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "QnnASRModel";
    private volatile GenieConfigResolution atRestConfig;
    private final AtomicBoolean feedPhaseRegistered;
    private volatile long nativeHandle;
    private final AtomicInteger sentenceIndex;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnASRModel$asrInferFlow$1", f = "QnnASRModel.kt", l = {420, 421, 436, 459}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnASRModel$asrInferFlow$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements zb.p<ProducerScope<? super v6.d>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ c.a $input;
        final /* synthetic */ boolean $isFinalChunk;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(c.a aVar, boolean z, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$input = aVar;
            this.$isFinalChunk = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$11(boolean z, ProducerScope producerScope, long j10, QnnASRModel qnnASRModel) {
            Object objA;
            Object objA2;
            if (z) {
                try {
                    QnnNative.nativeClearASRPhaseCallback(j10);
                    objA = lb.n.f10413a;
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    Log.w(QnnASRModel.TAG, "[Phase] ASR clear failed", thB);
                }
            }
            try {
                QnnNative.INSTANCE.releaseInferPermit(qnnASRModel.getConfig().f3090a);
                objA2 = lb.n.f10413a;
            } catch (Throwable th2) {
                objA2 = kotlin.c.a(th2);
            }
            Throwable thB2 = Result.b(objA2);
            if (thB2 != null) {
                a0.a.A("releaseInferPermit failed: ", thB2.getMessage(), QnnASRModel.TAG);
            }
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$5$lambda$4(long j10, byte[] bArr, c.a aVar, boolean z, QnnASRModel$asrInferFlow$1$callback$1 qnnASRModel$asrInferFlow$1$callback$1) {
            return ((Boolean) AiEngineAtrace.section("qnn/call", "asr_stream_generate", new c(j10, bArr, aVar, z, qnnASRModel$asrInferFlow$1$callback$1, 1))).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$5$lambda$4$lambda$3(long j10, byte[] bArr, c.a aVar, boolean z, QnnASRModel$asrInferFlow$1$callback$1 qnnASRModel$asrInferFlow$1$callback$1) {
            return QnnNative.nativeAsrStreamGenerate(j10, bArr, aVar.f13387c, 1, z, qnnASRModel$asrInferFlow$1$callback$1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = QnnASRModel.this.new AnonymousClass1(this.$input, this.$isFinalChunk, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(15:16|17|36|(17:41|87|42|46|(1:49)|50|(1:52)|54|91|55|56|93|57|58|59|(9:62|63|64|70|(0)(0)|74|(0)|(0)(0)|80)|82)|53|54|91|55|56|93|57|58|59|(0)|82) */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0196, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0197, code lost:
        
            r4 = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0199, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x019a, code lost:
        
            r13 = r21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0211, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r8, r18, r28) == r2) goto L82;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:49:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01ab  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x01ae  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01e1  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01f0  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01f3  */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object, java.lang.String, java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r7v7 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instructions count: 543
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnASRModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(ProducerScope<? super v6.d> producerScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass1) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnASRModel", f = "QnnASRModel.kt", l = {159}, m = "doClose")
    /* renamed from: com.stepos.backend.qnn.QnnASRModel$doClose$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02311 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02311(qb.b<? super C02311> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnASRModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnASRModel$doClose$2", f = "QnnASRModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnASRModel$doClose$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.l<qb.b<? super lb.n>, Object> {
        int label;

        public AnonymousClass2(qb.b<? super AnonymousClass2> bVar) {
            super(1, bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$0(QnnASRModel qnnASRModel) {
            QnnNative.nativeAsrRelease(qnnASRModel.nativeHandle);
            return lb.n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return QnnASRModel.this.new AnonymousClass2(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            AiEngineAtrace.section("qnn/release", "asr", new e(QnnASRModel.this, 0));
            return lb.n.f10413a;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnASRModel$doFlowInfer$2", f = "QnnASRModel.kt", l = {152}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnASRModel$doFlowInfer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02322 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends Object>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ QnnASRModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02322(Object obj, QnnASRModel qnnASRModel, qb.b<? super C02322> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = qnnASRModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02322 c02322 = new C02322(this.$input, this.this$0, bVar);
            c02322.L$0 = obj;
            return c02322;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Flow flowSlaTextInferFlow;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                final FlowCollector flowCollector = (FlowCollector) this.L$0;
                Object obj2 = this.$input;
                if (obj2 instanceof c.a) {
                    flowSlaTextInferFlow = this.this$0.asrInferFlow((c.a) obj2, true);
                } else {
                    if (!(obj2 instanceof c.g)) {
                        throw new IllegalArgumentException("Expected Input.Audio or Input.Text");
                    }
                    flowSlaTextInferFlow = this.this$0.slaTextInferFlow((c.g) obj2);
                }
                FlowCollector flowCollector2 = new FlowCollector() { // from class: com.stepos.backend.qnn.QnnASRModel.doFlowInfer.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj3, qb.b bVar) {
                        return emit((v6.d) obj3, (qb.b<? super lb.n>) bVar);
                    }

                    public final Object emit(v6.d dVar, qb.b<? super lb.n> bVar) {
                        FlowCollector<Result<? extends Object>> flowCollector3 = flowCollector;
                        kotlin.jvm.internal.g.d(dVar, "null cannot be cast to non-null type kotlin.Any");
                        Object objEmit = flowCollector3.emit(new Result<>(dVar), bVar);
                        return objEmit == CoroutineSingletons.f10059a ? objEmit : lb.n.f10413a;
                    }
                };
                this.label = 1;
                if (flowSlaTextInferFlow.collect(flowCollector2, this) == coroutineSingletons) {
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
        public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C02322) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnASRModel", f = "QnnASRModel.kt", l = {133, 138}, m = "doInfer")
    /* renamed from: com.stepos.backend.qnn.QnnASRModel$doInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02331 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02331(qb.b<? super C02331> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnASRModel.this.doInfer(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnASRModel", f = "QnnASRModel.kt", l = {91, 113}, m = "doInitialize")
    /* renamed from: com.stepos.backend.qnn.QnnASRModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02341 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02341(qb.b<? super C02341> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnASRModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnASRModel", f = "QnnASRModel.kt", l = {200}, m = "processAudio")
    /* renamed from: com.stepos.backend.qnn.QnnASRModel$processAudio$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02351 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02351(qb.b<? super C02351> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnASRModel.this.processAudio(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnASRModel", f = "QnnASRModel.kt", l = {227}, m = "processText")
    /* renamed from: com.stepos.backend.qnn.QnnASRModel$processText$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02361 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02361(qb.b<? super C02361> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnASRModel.this.processText(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnASRModel$slaTextInferFlow$1", f = "QnnASRModel.kt", l = {518, 519, 533, 549}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnASRModel$slaTextInferFlow$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02371 extends SuspendLambda implements zb.p<ProducerScope<? super v6.d>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ c.g $input;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02371(c.g gVar, qb.b<? super C02371> bVar) {
            super(2, bVar);
            this.$input = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$10(boolean z, ProducerScope producerScope, long j10, QnnASRModel qnnASRModel) {
            Object objA;
            Object objA2;
            if (z) {
                try {
                    QnnNative.nativeClearASRPhaseCallback(j10);
                    objA = lb.n.f10413a;
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    Log.w(QnnASRModel.TAG, "[Phase] ASR clear failed", thB);
                }
            }
            try {
                QnnNative.INSTANCE.releaseInferPermit(qnnASRModel.getConfig().f3090a);
                objA2 = lb.n.f10413a;
            } catch (Throwable th2) {
                objA2 = kotlin.c.a(th2);
            }
            Throwable thB2 = Result.b(objA2);
            if (thB2 != null) {
                a0.a.A("releaseInferPermit failed: ", thB2.getMessage(), QnnASRModel.TAG);
            }
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$4$lambda$3(final long j10, final String str, final QnnASRModel$slaTextInferFlow$1$callback$1 qnnASRModel$slaTextInferFlow$1$callback$1) {
            return ((Boolean) AiEngineAtrace.section("qnn/call", "asr_text_generate", new zb.a() { // from class: com.stepos.backend.qnn.g
                @Override // zb.a
                public final Object invoke() {
                    return Boolean.valueOf(QnnNative.nativeAsrTextGenerate(j10, str, qnnASRModel$slaTextInferFlow$1$callback$1));
                }
            })).booleanValue();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02371 c02371 = QnnASRModel.this.new C02371(this.$input, bVar);
            c02371.L$0 = obj;
            return c02371;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:16|17|34|(10:77|39|43|(1:46)|47|(1:49)|79|51|(9:54|55|56|60|(0)|64|(0)|(0)(0)|70)|72)|50|79|51|(0)|72) */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x014d, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x014e, code lost:
        
            r4 = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x01be, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r7, r18, r25) == r2) goto L72;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0114  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x018f  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x019e  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01a1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instructions count: 452
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnASRModel.C02371.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(ProducerScope<? super v6.d> producerScope, qb.b<? super lb.n> bVar) {
            return ((C02371) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(QnnASRModel.class), mb.l.s0(new ProtocolType[]{ProtocolType.f6380c, ProtocolType.f6378a}));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnASRModel(b7.k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
        this.sentenceIndex = new AtomicInteger(0);
        this.feedPhaseRegistered = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<v6.d> asrInferFlow(c.a aVar, boolean z) {
        return FlowKt.flowOn(FlowKt.buffer(FlowKt.callbackFlow(new AnonymousClass1(aVar, z, null)), 64, BufferOverflow.SUSPEND), Dispatchers.getIO());
    }

    private final void clearFeedPhaseCallback(long j10) {
        Object objA;
        if (this.feedPhaseRegistered.compareAndSet(true, false)) {
            try {
                QnnNative.nativeClearASRPhaseCallback(j10);
                objA = lb.n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                Log.w(TAG, "[Phase] ASR feed clear failed", thB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence doInfer$lambda$0(d.a it) {
        kotlin.jvm.internal.g.f(it, "it");
        return it.f13423a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence doInfer$lambda$1(d.q it) {
        kotlin.jvm.internal.g.f(it, "it");
        return it.f13487a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean feedAudioFrame$lambda$10$lambda$8(long j10, byte[] bArr, c.a aVar, boolean z, QnnASRModel$feedAudioFrame$nativeCb$1 qnnASRModel$feedAudioFrame$nativeCb$1) {
        return QnnNative.nativeAsrFileGenerate(j10, bArr, aVar.f13387c, 1, z, qnnASRModel$feedAudioFrame$nativeCb$1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean feedAudioFrame$lambda$10$lambda$9(long j10, byte[] bArr, c.a aVar, boolean z, QnnASRModel$feedAudioFrame$nativeCb$1 qnnASRModel$feedAudioFrame$nativeCb$1) {
        return QnnNative.nativeAsrStreamGenerate(j10, bArr, aVar.f13387c, 1, z, qnnASRModel$feedAudioFrame$nativeCb$1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] pcmS16leMonoLittleEndianBytes(short[] sArr) {
        byte[] bArr = new byte[sArr.length * 2];
        int i10 = 0;
        for (short s8 : sArr) {
            int i11 = i10 + 1;
            bArr[i10] = (byte) (s8 & 255);
            i10 += 2;
            bArr[i11] = (byte) ((s8 >> 8) & 255);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<v6.d> slaTextInferFlow(c.g gVar) {
        return FlowKt.flowOn(FlowKt.buffer(FlowKt.callbackFlow(new C02371(gVar, null)), 64, BufferOverflow.SUSPEND), Dispatchers.getIO());
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doCleanup(qb.b<? super lb.n> bVar) {
        return lb.n.f10413a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doClose(qb.b<? super lb.n> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stepos.backend.qnn.QnnASRModel.C02311
            if (r0 == 0) goto L14
            r0 = r11
            com.stepos.backend.qnn.QnnASRModel$doClose$1 r0 = (com.stepos.backend.qnn.QnnASRModel.C02311) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.stepos.backend.qnn.QnnASRModel$doClose$1 r0 = new com.stepos.backend.qnn.QnnASRModel$doClose$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r4.label
            r7 = 0
            r8 = 0
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r10 = r4.L$0
            com.stepos.backend.qnn.QnnASRModel r10 = (com.stepos.backend.qnn.QnnASRModel) r10
            kotlin.c.b(r11)
            goto L5b
        L30:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L38:
            kotlin.c.b(r11)
            long r5 = r10.nativeHandle
            int r11 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r11 == 0) goto L64
            long r5 = r10.nativeHandle
            r10.clearFeedPhaseCallback(r5)
            com.stepos.backend.qnn.QnnNative r1 = com.stepos.backend.qnn.QnnNative.INSTANCE
            com.stepos.backend.qnn.QnnASRModel$doClose$2 r3 = new com.stepos.backend.qnn.QnnASRModel$doClose$2
            r3.<init>(r7)
            r4.L$0 = r10
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r11 = com.stepos.backend.qnn.QnnNative.withInferLock$default(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L5b
            return r0
        L5b:
            r10.nativeHandle = r8
            java.lang.String r11 = "QnnASRModel"
            java.lang.String r0 = "ASR released"
            android.util.Log.i(r11, r0)
        L64:
            com.stepos.backend.qnn.GenieConfigResolution r11 = r10.atRestConfig
            if (r11 == 0) goto L6b
            r11.release()
        L6b:
            r10.atRestConfig = r7
            lb.n r10 = lb.n.f10413a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnASRModel.doClose(qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doFlowInfer(Object obj, qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
        return FlowKt.flow(new C02322(obj, this, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (r8 == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
    
        if (r8 == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInfer(java.lang.Object r7, qb.b<java.lang.Object> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.backend.qnn.QnnASRModel.C02331
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.backend.qnn.QnnASRModel$doInfer$1 r0 = (com.stepos.backend.qnn.QnnASRModel.C02331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnASRModel$doInfer$1 r0 = new com.stepos.backend.qnn.QnnASRModel$doInfer$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.c.b(r8)
            goto L8f
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.c.b(r8)
            goto L4d
        L36:
            kotlin.c.b(r8)
            boolean r8 = r7 instanceof v6.c.a
            r2 = 0
            if (r8 == 0) goto L7c
            v6.c$a r7 = (v6.c.a) r7
            kotlinx.coroutines.flow.Flow r6 = r6.asrInferFlow(r7, r4)
            r0.label = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.toList$default(r6, r2, r0, r4, r2)
            if (r8 != r1) goto L4d
            goto L8e
        L4d:
            java.util.List r8 = (java.util.List) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r8.iterator()
        L58:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L6a
            java.lang.Object r7 = r6.next()
            boolean r8 = r7 instanceof v6.d.a
            if (r8 == 0) goto L58
            r0.add(r7)
            goto L58
        L6a:
            b6.e r4 = new b6.e
            r6 = 16
            r4.<init>(r6)
            r5 = 30
            java.lang.String r1 = ""
            r2 = 0
            r3 = 0
            java.lang.String r6 = kotlin.collections.a.z0(r0, r1, r2, r3, r4, r5)
            return r6
        L7c:
            boolean r8 = r7 instanceof v6.c.g
            if (r8 == 0) goto Lbe
            v6.c$g r7 = (v6.c.g) r7
            kotlinx.coroutines.flow.Flow r6 = r6.slaTextInferFlow(r7)
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.toList$default(r6, r2, r0, r4, r2)
            if (r8 != r1) goto L8f
        L8e:
            return r1
        L8f:
            java.util.List r8 = (java.util.List) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r8.iterator()
        L9a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto Lac
            java.lang.Object r7 = r6.next()
            boolean r8 = r7 instanceof v6.d.q
            if (r8 == 0) goto L9a
            r0.add(r7)
            goto L9a
        Lac:
            b6.i r4 = new b6.i
            r6 = 17
            r4.<init>(r6)
            r5 = 30
            java.lang.String r1 = ""
            r2 = 0
            r3 = 0
            java.lang.String r6 = kotlin.collections.a.z0(r0, r1, r2, r3, r4, r5)
            return r6
        Lbe:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Expected Input.Audio or Input.Text"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnASRModel.doInfer(java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r10, b7.k r11, qb.b<? super lb.n> r12) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnASRModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super lb.n> bVar) {
        return lb.n.f10413a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0151  */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.stepos.backend.qnn.QnnASRModel$feedAudioFrame$nativeCb$1] */
    @Override // e7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean feedAudioFrame(v6.c.a r11, final boolean r12, final e7.a.InterfaceC0076a r13, com.stepos.base.protocol.AsrFeedKind r14) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnASRModel.feedAudioFrame(v6.c$a, boolean, e7.a$a, com.stepos.base.protocol.AsrFeedKind):boolean");
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6380c;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    @Override // e7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processAudio(v6.c.a r26, java.lang.Object r27, qb.b<? super kotlinx.coroutines.flow.Flow<? extends v6.d>> r28) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnASRModel.processAudio(v6.c$a, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // e7.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processText(v6.c.g r26, java.lang.Object r27, qb.b<? super kotlinx.coroutines.flow.Flow<? extends v6.d>> r28) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnASRModel.processText(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    @Override // e7.h
    public boolean resetContext() {
        return false;
    }

    public Flow<v6.d> streamAudio(c.a input, boolean z) {
        kotlin.jvm.internal.g.f(input, "input");
        return asrInferFlow(input, z);
    }
}
