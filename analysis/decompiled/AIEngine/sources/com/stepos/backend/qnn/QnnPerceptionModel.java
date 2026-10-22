package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.data.base.Content;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnPerceptionModel extends QnnModelBase implements e7.d {
    public static final Companion Companion = new Companion(null);
    private static final ExecutorCoroutineDispatcher perceptionNativeDispatcher;
    private GenieConfigResolution atRestConfig;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnPerceptionModel", f = "QnnPerceptionModel.kt", l = {Content.Types.TYPE_DOUBLE}, m = "doClose")
    /* renamed from: com.stepos.backend.qnn.QnnPerceptionModel$doClose$1, reason: invalid class name */
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
            return QnnPerceptionModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnPerceptionModel$doInferInternal$1", f = "QnnPerceptionModel.kt", l = {179, 197}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnPerceptionModel$doInferInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02601 extends SuspendLambda implements zb.p<ProducerScope<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ QnnPerceptionModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02601(Object obj, QnnPerceptionModel qnnPerceptionModel, qb.b<? super C02601> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = qnnPerceptionModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$0(QnnPerceptionModel qnnPerceptionModel) {
            Log.d(qnnPerceptionModel.getTAG(), "Perception stream flow closed");
            return lb.n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02601 c02601 = new C02601(this.$input, this.this$0, bVar);
            c02601.L$0 = obj;
            return c02601;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Result<? extends d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return invoke2((ProducerScope<? super Result<d.q>>) producerScope, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x014d, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r1, r2, r22) != r10) goto L39;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 365
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnPerceptionModel.C02601.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Result<d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return ((C02601) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnPerceptionModel", f = "QnnPerceptionModel.kt", l = {77, 88}, m = "doInitialize")
    /* renamed from: com.stepos.backend.qnn.QnnPerceptionModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02611 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02611(qb.b<? super C02611> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnPerceptionModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnPerceptionModel", f = "QnnPerceptionModel.kt", l = {284, 284}, m = "processMixed")
    /* renamed from: com.stepos.backend.qnn.QnnPerceptionModel$processMixed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02621 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C02621(qb.b<? super C02621> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnPerceptionModel.this.processMixed(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnPerceptionModel$processMixedStream$2", f = "QnnPerceptionModel.kt", l = {261, 261}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnPerceptionModel$processMixedStream$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02632 extends SuspendLambda implements zb.p<FlowCollector<? super v6.d>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ c.e $input;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02632(c.e eVar, qb.b<? super C02632> bVar) {
            super(2, bVar);
            this.$input = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02632 c02632 = QnnPerceptionModel.this.new C02632(this.$input, bVar);
            c02632.L$0 = obj;
            return c02632;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
        
            if (((kotlinx.coroutines.flow.Flow) r6).collect(r3, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r6)
                goto L4c
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L18:
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r6)
                goto L37
            L20:
                kotlin.c.b(r6)
                java.lang.Object r6 = r5.L$0
                r1 = r6
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.backend.qnn.QnnPerceptionModel r6 = com.stepos.backend.qnn.QnnPerceptionModel.this
                v6.c$e r4 = r5.$input
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r6.infer(r4, r5)
                if (r6 != r0) goto L37
                goto L4b
            L37:
                kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
                com.stepos.backend.qnn.QnnPerceptionModel$processMixedStream$2$1 r3 = new com.stepos.backend.qnn.QnnPerceptionModel$processMixedStream$2$1
                com.stepos.backend.qnn.QnnPerceptionModel r4 = com.stepos.backend.qnn.QnnPerceptionModel.this
                r3.<init>()
                r1 = 0
                r5.L$0 = r1
                r5.label = r2
                java.lang.Object r5 = r6.collect(r3, r5)
                if (r5 != r0) goto L4c
            L4b:
                return r0
            L4c:
                lb.n r5 = lb.n.f10413a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnPerceptionModel.C02632.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super v6.d> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C02632) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new com.stepos.aicgroup.d(2));
        kotlin.jvm.internal.g.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        perceptionNativeDispatcher = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnPerceptionModel(b7.k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
    }

    private final byte[] encodeBitmapToPng(Bitmap bitmap) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Exception e10) {
            Log.e(getTAG(), "encodeBitmapToPng failed: " + e10.getMessage(), e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logPerf(String str, long j10, long j11, long j12, int i10) {
        long j13 = 1000000;
        long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - j10) / j13;
        if (j11 == 0 || i10 == 0) {
            ai.onnxruntime.a.y(com.stepos.core.ota.d.l("Perception perf [", jElapsedRealtimeNanos, str, "]: tokens=0, e2e="), "ms (no tokens)", getTAG());
            return;
        }
        long j14 = (j11 - j10) / j13;
        if (i10 <= 1 || j12 <= j11) {
            String tag = getTAG();
            StringBuilder sbF = h0.e.f("Perception perf [", str, "]: tokens=", i10, ", TTFT(user)=");
            sbF.append(j14);
            Log.i(tag, a0.a.d(jElapsedRealtimeNanos, "ms, e2e=", "ms (single-token, decode_tps n/a)", sbF));
            return;
        }
        long j15 = j12 - j11;
        long j16 = j15 / j13;
        double d8 = ((i10 - 1) * 1.0E9d) / j15;
        String tag2 = getTAG();
        String str2 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d8)}, 1));
        StringBuilder sbF2 = h0.e.f("Perception perf [", str, "] (native-bench-aligned): tokens=", i10, ", TTFT(user)=");
        sbF2.append(j14);
        a0.a.s(j16, "ms, decode=", "ms, decode_tps(user)=", sbF2);
        com.stepos.core.ota.d.p(jElapsedRealtimeNanos, str2, " tok/s, e2e=", sbF2);
        ai.onnxruntime.a.y(sbF2, "ms", tag2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread perceptionNativeDispatcher$lambda$7(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "QnnPerception-native", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba A[PHI: r13
      0x00ba: PHI (r13v12 java.lang.String) = (r13v3 java.lang.String), (r13v15 java.lang.String) binds: [B:46:0x00cc, B:39:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.backend.qnn.QnnPerceptionModel.ResolvedPerceptionInputs resolvePerceptionInputs(v6.c.e r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnPerceptionModel.resolvePerceptionInputs(v6.c$e):com.stepos.backend.qnn.QnnPerceptionModel$ResolvedPerceptionInputs");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doClose(qb.b<? super lb.n> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.backend.qnn.QnnPerceptionModel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.backend.qnn.QnnPerceptionModel$doClose$1 r0 = (com.stepos.backend.qnn.QnnPerceptionModel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnPerceptionModel$doClose$1 r0 = new com.stepos.backend.qnn.QnnPerceptionModel$doClose$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.stepos.backend.qnn.QnnPerceptionModel r4 = (com.stepos.backend.qnn.QnnPerceptionModel) r4
            kotlin.c.b(r5)     // Catch: java.lang.Exception -> L2b
            goto L4e
        L2b:
            r5 = move-exception
            goto L62
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.c.b(r5)
            java.lang.String r5 = r4.getTAG()
            java.lang.String r2 = "doClose: releasing Perception engine"
            android.util.Log.d(r5, r2)
            com.stepos.backend.qnn.PerceptionNative r5 = com.stepos.backend.qnn.PerceptionNative.INSTANCE     // Catch: java.lang.Exception -> L2b
            r0.L$0 = r4     // Catch: java.lang.Exception -> L2b
            r0.label = r3     // Catch: java.lang.Exception -> L2b
            java.lang.Object r5 = r5.release(r0)     // Catch: java.lang.Exception -> L2b
            if (r5 != r1) goto L4e
            return r1
        L4e:
            com.stepos.backend.qnn.GenieConfigResolution r5 = r4.atRestConfig     // Catch: java.lang.Exception -> L2b
            if (r5 == 0) goto L55
            r5.release()     // Catch: java.lang.Exception -> L2b
        L55:
            r5 = 0
            r4.atRestConfig = r5     // Catch: java.lang.Exception -> L2b
            java.lang.String r5 = r4.getTAG()     // Catch: java.lang.Exception -> L2b
            java.lang.String r0 = "✅ Perception model released"
            android.util.Log.i(r5, r0)     // Catch: java.lang.Exception -> L2b
            goto L7b
        L62:
            java.lang.String r4 = r4.getTAG()
            java.lang.String r0 = r5.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to release Perception model: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.e(r4, r0, r5)
        L7b:
            lb.n r4 = lb.n.f10413a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnPerceptionModel.doClose(qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flowOn(FlowKt__ContextKt.buffer$default(FlowKt.callbackFlow(new C02601(input, this, null)), 1024, null, 2, null), perceptionNativeDispatcher);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r7, b7.k r8, qb.b<? super lb.n> r9) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnPerceptionModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase, com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super lb.n> bVar) {
        Log.d(getTAG(), "Perception warmup skipped (requires image input)");
        return lb.n.f10413a;
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6382e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // e7.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processMixed(v6.c.e r10, java.lang.Object r11, qb.b<? super v6.d> r12) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnPerceptionModel.processMixed(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }

    @Override // e7.d
    public Object processMixedStream(c.e eVar, Object obj, qb.b<? super Flow<? extends v6.d>> bVar) {
        Log.d(getTAG(), "processMixedStream: items=" + eVar.f13409b.size());
        return FlowKt.flow(new C02632(eVar, null));
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ResolvedPerceptionInputs {
        private final byte[][] imageBytes;
        private final int maxTokens;
        private final String prompt;
        private final String systemPrompt;
        private final float temperature;
        private final int topK;
        private final float topP;

        public ResolvedPerceptionInputs(String str, String prompt, byte[][] imageBytes, int i10, float f8, int i11, float f9) {
            kotlin.jvm.internal.g.f(prompt, "prompt");
            kotlin.jvm.internal.g.f(imageBytes, "imageBytes");
            this.systemPrompt = str;
            this.prompt = prompt;
            this.imageBytes = imageBytes;
            this.maxTokens = i10;
            this.temperature = f8;
            this.topK = i11;
            this.topP = f9;
        }

        public static /* synthetic */ ResolvedPerceptionInputs copy$default(ResolvedPerceptionInputs resolvedPerceptionInputs, String str, String str2, byte[][] bArr, int i10, float f8, int i11, float f9, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = resolvedPerceptionInputs.systemPrompt;
            }
            if ((i12 & 2) != 0) {
                str2 = resolvedPerceptionInputs.prompt;
            }
            if ((i12 & 4) != 0) {
                bArr = resolvedPerceptionInputs.imageBytes;
            }
            if ((i12 & 8) != 0) {
                i10 = resolvedPerceptionInputs.maxTokens;
            }
            if ((i12 & 16) != 0) {
                f8 = resolvedPerceptionInputs.temperature;
            }
            if ((i12 & 32) != 0) {
                i11 = resolvedPerceptionInputs.topK;
            }
            if ((i12 & 64) != 0) {
                f9 = resolvedPerceptionInputs.topP;
            }
            int i13 = i11;
            float f10 = f9;
            float f11 = f8;
            byte[][] bArr2 = bArr;
            return resolvedPerceptionInputs.copy(str, str2, bArr2, i10, f11, i13, f10);
        }

        public final String component1() {
            return this.systemPrompt;
        }

        public final String component2() {
            return this.prompt;
        }

        public final byte[][] component3() {
            return this.imageBytes;
        }

        public final int component4() {
            return this.maxTokens;
        }

        public final float component5() {
            return this.temperature;
        }

        public final int component6() {
            return this.topK;
        }

        public final float component7() {
            return this.topP;
        }

        public final ResolvedPerceptionInputs copy(String str, String prompt, byte[][] imageBytes, int i10, float f8, int i11, float f9) {
            kotlin.jvm.internal.g.f(prompt, "prompt");
            kotlin.jvm.internal.g.f(imageBytes, "imageBytes");
            return new ResolvedPerceptionInputs(str, prompt, imageBytes, i10, f8, i11, f9);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResolvedPerceptionInputs)) {
                return false;
            }
            ResolvedPerceptionInputs resolvedPerceptionInputs = (ResolvedPerceptionInputs) obj;
            return kotlin.jvm.internal.g.b(this.systemPrompt, resolvedPerceptionInputs.systemPrompt) && kotlin.jvm.internal.g.b(this.prompt, resolvedPerceptionInputs.prompt) && kotlin.jvm.internal.g.b(this.imageBytes, resolvedPerceptionInputs.imageBytes) && this.maxTokens == resolvedPerceptionInputs.maxTokens && Float.compare(this.temperature, resolvedPerceptionInputs.temperature) == 0 && this.topK == resolvedPerceptionInputs.topK && Float.compare(this.topP, resolvedPerceptionInputs.topP) == 0;
        }

        public final byte[][] getImageBytes() {
            return this.imageBytes;
        }

        public final int getMaxTokens() {
            return this.maxTokens;
        }

        public final String getPrompt() {
            return this.prompt;
        }

        public final String getSystemPrompt() {
            return this.systemPrompt;
        }

        public final float getTemperature() {
            return this.temperature;
        }

        public final int getTopK() {
            return this.topK;
        }

        public final float getTopP() {
            return this.topP;
        }

        public int hashCode() {
            String str = this.systemPrompt;
            return Float.hashCode(this.topP) + ai.onnxruntime.a.d(this.topK, a0.a.a(this.temperature, ai.onnxruntime.a.d(this.maxTokens, (Arrays.hashCode(this.imageBytes) + v1.d.a((str == null ? 0 : str.hashCode()) * 31, 31, this.prompt)) * 31, 31), 31), 31);
        }

        public String toString() {
            String str = this.systemPrompt;
            String str2 = this.prompt;
            String string = Arrays.toString(this.imageBytes);
            int i10 = this.maxTokens;
            float f8 = this.temperature;
            int i11 = this.topK;
            float f9 = this.topP;
            StringBuilder sbS = ai.onnxruntime.a.s("ResolvedPerceptionInputs(systemPrompt=", str, ", prompt=", str2, ", imageBytes=");
            com.stepos.core.ota.d.o(i10, string, ", maxTokens=", ", temperature=", sbS);
            sbS.append(f8);
            sbS.append(", topK=");
            sbS.append(i11);
            sbS.append(", topP=");
            sbS.append(f9);
            sbS.append(")");
            return sbS.toString();
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
            	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        public /* synthetic */ ResolvedPerceptionInputs(java.lang.String r2, java.lang.String r3, byte[][] r4, int r5, float r6, int r7, float r8, int r9, kotlin.jvm.internal.e r10) {
            /*
                r1 = this;
                r10 = r9 & 1
                if (r10 == 0) goto L5
                r2 = 0
            L5:
                r10 = r9 & 16
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
                if (r10 == 0) goto Lc
                r6 = r0
            Lc:
                r10 = r9 & 32
                if (r10 == 0) goto L11
                r7 = -1
            L11:
                r9 = r9 & 64
                if (r9 == 0) goto L1e
                r10 = r0
                r8 = r6
                r9 = r7
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r3 = r1
                goto L26
            L1e:
                r10 = r8
                r9 = r7
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
            L26:
                r3.<init>(r4, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnPerceptionModel.ResolvedPerceptionInputs.<init>(java.lang.String, java.lang.String, byte[][], int, float, int, float, int, kotlin.jvm.internal.e):void");
        }
    }
}
