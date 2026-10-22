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
public final class MnnSuperResolutionModel extends MnnModelBase implements e7.i {
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
    @rb.c(c = "com.stepos.backend.mnn.MnnSuperResolutionModel$doInferInternal$1", f = "MnnSuperResolutionModel.kt", l = {20, ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.mnn.MnnSuperResolutionModel$doInferInternal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MnnSuperResolutionModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Object obj, MnnSuperResolutionModel mnnSuperResolutionModel, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = mnnSuperResolutionModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, this.this$0, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
        
            if (r11.emit(r2, r10) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
        
            if (r11.emit(r1, r10) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r11)
                goto L78
            L10:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L18:
                kotlin.c.b(r11)
                goto L3d
            L1c:
                kotlin.c.b(r11)
                java.lang.Object r11 = r10.L$0
                kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                java.lang.Object r1 = r10.$input
                boolean r1 = r1 instanceof v6.c.C0155c
                if (r1 != 0) goto L40
                java.lang.String r1 = "MnnSuperResolutionModel requires Input.Image"
                kotlin.Result$Failure r1 = ai.onnxruntime.a.t(r1)
                kotlin.Result r2 = new kotlin.Result
                r2.<init>(r1)
                r10.label = r3
                java.lang.Object r10 = r11.emit(r2, r10)
                if (r10 != r0) goto L3d
                goto L77
            L3d:
                lb.n r10 = lb.n.f10413a
                return r10
            L40:
                com.stepos.backend.mnn.MnnSuperResolutionModel r1 = r10.this$0
                java.lang.String r1 = r1.getTAG()
                java.lang.String r3 = "MNN SuperResolution stub — integrate .mnn sr model"
                android.util.Log.w(r1, r3)
                v6.d$l r4 = new v6.d$l
                r1 = 0
                byte[] r5 = new byte[r1]
                java.lang.Object r1 = r10.$input
                v6.c$c r1 = (v6.c.C0155c) r1
                android.graphics.Bitmap r1 = r1.f13396b
                int r6 = r1.getWidth()
                java.lang.Object r1 = r10.$input
                v6.c$c r1 = (v6.c.C0155c) r1
                android.graphics.Bitmap r1 = r1.f13396b
                int r7 = r1.getHeight()
                r8 = 0
                r9 = 24
                r4.<init>(r5, r6, r7, r8, r9)
                kotlin.Result r1 = new kotlin.Result
                r1.<init>(r4)
                r10.label = r2
                java.lang.Object r10 = r11.emit(r1, r10)
                if (r10 != r0) goto L78
            L77:
                return r0
            L78:
                lb.n r10 = lb.n.f10413a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnSuperResolutionModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(MnnSuperResolutionModel.class), y.M(ProtocolType.f6379b));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MnnSuperResolutionModel(k config) {
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
        return ProtocolType.f6379b;
    }

    @Override // e7.i
    public Object processImage(c.C0155c c0155c, Object obj, qb.b<? super v6.d> bVar) {
        return collectFirstOutput(c0155c, bVar);
    }
}
