package com.stepos.backend.mnn;

import b7.k;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.y;
import v6.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MnnLLMModel extends MnnModelBase implements e7.h {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnLLMModel", f = "MnnLLMModel.kt", l = {ErrorCodes.CALLBACK_RECYCLE_ERROR}, m = "doClose")
    /* renamed from: com.stepos.backend.mnn.MnnLLMModel$doClose$1, reason: invalid class name */
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
            return MnnLLMModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnLLMModel$doInferInternal$1", f = "MnnLLMModel.kt", l = {59, 71, 74}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.mnn.MnnLLMModel$doInferInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02211 extends SuspendLambda implements p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MnnLLMModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02211(Object obj, MnnLLMModel mnnLLMModel, qb.b<? super C02211> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = mnnLLMModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C02211 c02211 = new C02211(this.$input, this.this$0, bVar);
            c02211.L$0 = obj;
            return c02211;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
        
            if (r1.emit(r2, r8) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
        
            if (r8 == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00a0, code lost:
        
            if (r1.emit(r4, r8) != r0) goto L29;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r8v0, types: [com.stepos.backend.mnn.MnnLLMModel$doInferInternal$1, qb.b] */
        /* JADX WARN: Type inference failed for: r8v1, types: [com.stepos.backend.mnn.MnnLLMModel$doInferInternal$1, qb.b] */
        /* JADX WARN: Type inference failed for: r8v10 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r8.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2c
                if (r1 == r5) goto L28
                if (r1 == r4) goto L1d
                if (r1 != r3) goto L15
                kotlin.c.b(r9)
                goto La3
            L15:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1d:
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r9)     // Catch: java.lang.Exception -> L26
                goto La3
            L26:
                r9 = move-exception
                goto L74
            L28:
                kotlin.c.b(r9)
                goto L4e
            L2c:
                kotlin.c.b(r9)
                java.lang.Object r9 = r8.L$0
                r1 = r9
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                java.lang.Object r9 = r8.$input
                boolean r9 = r9 instanceof v6.c.g
                if (r9 != 0) goto L51
                java.lang.String r9 = "MnnLLMModel requires Input.Text"
                kotlin.Result$Failure r9 = ai.onnxruntime.a.t(r9)
                kotlin.Result r2 = new kotlin.Result
                r2.<init>(r9)
                r8.label = r5
                java.lang.Object r8 = r1.emit(r2, r8)
                if (r8 != r0) goto L4e
                goto La2
            L4e:
                lb.n r8 = lb.n.f10413a
                return r8
            L51:
                com.stepos.backend.mnn.MnnLLMModel r9 = r8.this$0     // Catch: java.lang.Exception -> L26
                java.lang.String r9 = r9.getTAG()     // Catch: java.lang.Exception -> L26
                java.lang.String r5 = "MNN-LLM inference not implemented yet (requires MNN SDK)"
                android.util.Log.w(r9, r5)     // Catch: java.lang.Exception -> L26
                v6.d$q r9 = new v6.d$q     // Catch: java.lang.Exception -> L26
                java.lang.String r5 = "[MNN-LLM stub output]"
                r6 = 6
                r9.<init>(r5, r2, r2, r6)     // Catch: java.lang.Exception -> L26
                kotlin.Result r5 = new kotlin.Result     // Catch: java.lang.Exception -> L26
                r5.<init>(r9)     // Catch: java.lang.Exception -> L26
                r8.L$0 = r1     // Catch: java.lang.Exception -> L26
                r8.label = r4     // Catch: java.lang.Exception -> L26
                java.lang.Object r8 = r1.emit(r5, r8)     // Catch: java.lang.Exception -> L26
                if (r8 != r0) goto La3
                goto La2
            L74:
                com.stepos.backend.mnn.MnnLLMModel r4 = r8.this$0
                java.lang.String r4 = r4.getTAG()
                java.lang.String r5 = r9.getMessage()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "MNN LLM inference failed: "
                r6.<init>(r7)
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                android.util.Log.e(r4, r5, r9)
                kotlin.Result$Failure r9 = kotlin.c.a(r9)
                kotlin.Result r4 = new kotlin.Result
                r4.<init>(r9)
                r8.L$0 = r2
                r8.label = r3
                java.lang.Object r8 = r1.emit(r4, r8)
                if (r8 != r0) goto La3
            La2:
                return r0
            La3:
                lb.n r8 = lb.n.f10413a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnLLMModel.C02211.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super n> bVar) {
            return ((C02211) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnLLMModel", f = "MnnLLMModel.kt", l = {41}, m = "doInitialize")
    /* renamed from: com.stepos.backend.mnn.MnnLLMModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02221(qb.b<? super C02221> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnLLMModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnLLMModel$processText$2", f = "MnnLLMModel.kt", l = {37, 37}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.mnn.MnnLLMModel$processText$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super v6.d>, qb.b<? super n>, Object> {
        final /* synthetic */ c.g $input;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(c.g gVar, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = MnnLLMModel.this.new AnonymousClass2(this.$input, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
        
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
                goto L4a
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
                com.stepos.backend.mnn.MnnLLMModel r6 = com.stepos.backend.mnn.MnnLLMModel.this
                v6.c$g r4 = r5.$input
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r6.infer(r4, r5)
                if (r6 != r0) goto L37
                goto L49
            L37:
                kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
                com.stepos.backend.mnn.MnnLLMModel$processText$2$1 r3 = new com.stepos.backend.mnn.MnnLLMModel$processText$2$1
                r3.<init>()
                r1 = 0
                r5.L$0 = r1
                r5.label = r2
                java.lang.Object r5 = r6.collect(r3, r5)
                if (r5 != r0) goto L4a
            L49:
                return r0
            L4a:
                lb.n r5 = lb.n.f10413a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnLLMModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super v6.d> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(MnnLLMModel.class), y.M(ProtocolType.f6378a));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MnnLLMModel(k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.backend.mnn.MnnModelBase, com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doClose(qb.b<? super lb.n> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.backend.mnn.MnnLLMModel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.backend.mnn.MnnLLMModel$doClose$1 r0 = (com.stepos.backend.mnn.MnnLLMModel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.mnn.MnnLLMModel$doClose$1 r0 = new com.stepos.backend.mnn.MnnLLMModel$doClose$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            com.stepos.backend.mnn.MnnLLMModel r4 = (com.stepos.backend.mnn.MnnLLMModel) r4
            kotlin.c.b(r5)
            goto L41
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.c.b(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = super.doClose(r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            java.lang.String r5 = r4.getTAG()
            b7.k r4 = r4.getConfig()
            java.lang.String r4 = r4.f3090a
            java.lang.String r0 = "MnnLLMModel closed (stub): "
            a0.a.y(r0, r4, r5)
            lb.n r4 = lb.n.f10413a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnLLMModel.doClose(qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.mnn.MnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flow(new C02211(input, this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.backend.mnn.MnnModelBase, com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r5, b7.k r6, qb.b<? super lb.n> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.backend.mnn.MnnLLMModel.C02221
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.backend.mnn.MnnLLMModel$doInitialize$1 r0 = (com.stepos.backend.mnn.MnnLLMModel.C02221) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.mnn.MnnLLMModel$doInitialize$1 r0 = new com.stepos.backend.mnn.MnnLLMModel$doInitialize$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.L$1
            r6 = r4
            b7.k r6 = (b7.k) r6
            java.lang.Object r4 = r0.L$0
            com.stepos.backend.mnn.MnnLLMModel r4 = (com.stepos.backend.mnn.MnnLLMModel) r4
            kotlin.c.b(r7)
            goto L48
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.c.b(r7)
            r0.L$0 = r4
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r5 = super.doInitialize(r5, r6, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            java.lang.String r4 = r4.getTAG()
            java.lang.String r5 = r6.f3090a
            java.lang.String r6 = "MnnLLMModel initialized (stub): "
            a0.a.y(r6, r5, r4)
            lb.n r4 = lb.n.f10413a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnLLMModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6378a;
    }

    @Override // e7.h
    public Object processText(c.g gVar, Object obj, qb.b<? super Flow<? extends v6.d>> bVar) {
        return FlowKt.flow(new AnonymousClass2(gVar, null));
    }

    @Override // e7.h
    public boolean resetContext() {
        return false;
    }
}
