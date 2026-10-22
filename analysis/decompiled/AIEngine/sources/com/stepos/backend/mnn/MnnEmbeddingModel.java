package com.stepos.backend.mnn;

import b7.k;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
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
public final class MnnEmbeddingModel extends MnnModelBase implements e7.h {
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
    @rb.c(c = "com.stepos.backend.mnn.MnnEmbeddingModel$doInferInternal$1", f = "MnnEmbeddingModel.kt", l = {25, ErrorCodes.GET_PACKAGE_INFO_ERROR}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.mnn.MnnEmbeddingModel$doInferInternal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MnnEmbeddingModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Object obj, MnnEmbeddingModel mnnEmbeddingModel, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = mnnEmbeddingModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, this.this$0, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
        
            if (r7.emit(r2, r6) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
        
            if (r7.emit(r3, r6) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r7)
                goto L6d
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L18:
                kotlin.c.b(r7)
                goto L3d
            L1c:
                kotlin.c.b(r7)
                java.lang.Object r7 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                java.lang.Object r1 = r6.$input
                boolean r1 = r1 instanceof v6.c.g
                if (r1 != 0) goto L40
                java.lang.String r1 = "MnnEmbeddingModel requires Input.Text"
                kotlin.Result$Failure r1 = ai.onnxruntime.a.t(r1)
                kotlin.Result r2 = new kotlin.Result
                r2.<init>(r1)
                r6.label = r3
                java.lang.Object r6 = r7.emit(r2, r6)
                if (r6 != r0) goto L3d
                goto L6c
            L3d:
                lb.n r6 = lb.n.f10413a
                return r6
            L40:
                com.stepos.backend.mnn.MnnEmbeddingModel r1 = r6.this$0
                java.lang.String r1 = r1.getTAG()
                java.lang.String r3 = "MNN Embedding stub — integrate native embedding"
                android.util.Log.w(r1, r3)
                r1 = 8
                float[] r3 = new float[r1]
                r4 = 0
            L50:
                if (r4 >= r1) goto L58
                r5 = 0
                r3[r4] = r5
                int r4 = r4 + 1
                goto L50
            L58:
                v6.d$e r1 = new v6.d$e
                java.lang.String r4 = ""
                r1.<init>(r4, r3)
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r1)
                r6.label = r2
                java.lang.Object r6 = r7.emit(r3, r6)
                if (r6 != r0) goto L6d
            L6c:
                return r0
            L6d:
                lb.n r6 = lb.n.f10413a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnEmbeddingModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnEmbeddingModel$processText$2", f = "MnnEmbeddingModel.kt", l = {20, 20}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.mnn.MnnEmbeddingModel$processText$2, reason: invalid class name */
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
            AnonymousClass2 anonymousClass2 = MnnEmbeddingModel.this.new AnonymousClass2(this.$input, bVar);
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
                com.stepos.backend.mnn.MnnEmbeddingModel r6 = com.stepos.backend.mnn.MnnEmbeddingModel.this
                v6.c$g r4 = r5.$input
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r6.infer(r4, r5)
                if (r6 != r0) goto L37
                goto L49
            L37:
                kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
                com.stepos.backend.mnn.MnnEmbeddingModel$processText$2$1 r3 = new com.stepos.backend.mnn.MnnEmbeddingModel$processText$2$1
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
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnEmbeddingModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super v6.d> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(MnnEmbeddingModel.class), y.M(ProtocolType.f6378a));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MnnEmbeddingModel(k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
    }

    @Override // com.stepos.backend.mnn.MnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flow(new AnonymousClass1(input, this, null));
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
