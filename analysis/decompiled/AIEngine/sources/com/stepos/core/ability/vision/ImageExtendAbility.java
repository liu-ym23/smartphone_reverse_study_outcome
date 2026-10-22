package com.stepos.core.ability.vision;

import com.stepos.base.ability.AbilityBase;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import p6.a;
import qb.b;
import v6.c;
import v6.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ImageExtendAbility extends AbilityBase<c.C0155c, d.l> {
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.vision.ImageExtendAbility$doFlowInfer$2", f = "ImageExtendAbility.kt", l = {ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR, ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR, ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR, ErrorCodes.SERVICE_RECYCLE_ERROR, ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.vision.ImageExtendAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.l>>, b<? super n>, Object> {
        final /* synthetic */ c.C0155c $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(c.C0155c c0155c, Object obj, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = c0155c;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass2 anonymousClass2 = ImageExtendAbility.this.new AnonymousClass2(this.$input, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.l>> flowCollector, b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.l>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
        
            if (r1.emit(r2, r12) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
        
            if (r1.emit(r2, r12) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00c5, code lost:
        
            if (r1.emit(r2, r12) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00e8, code lost:
        
            if (r1.emit(r3, r12) == r0) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 238
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.ImageExtendAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.l>> flowCollector, b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageExtendAbility(a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.TAG = "ImageExtendAbility";
    }

    private final d.l mockOutput(int i10, int i11) {
        return new d.l(new byte[i10 * i11 * 4], i10, i11, 2, 16);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(c cVar, Object obj, b bVar) {
        return doFlowInfer((c.C0155c) cVar, obj, (b<? super Flow<Result<d.l>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo18doInfer0E7RQCE(c cVar, Object obj, b bVar) {
        return m84doInfer0E7RQCE((c.C0155c) cVar, obj, (b<? super Result<d.l>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(c cVar, b bVar) {
        return m85doInfergIAlus((c.C0155c) cVar, (b<? super Result<d.l>>) bVar);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return false;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.l defaultOutput() {
        return new d.l(new byte[4], 1, 1, 2, 16);
    }

    public Object doFlowInfer(c.C0155c c0155c, Object obj, b<? super Flow<Result<d.l>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(c0155c, obj, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m84doInfer0E7RQCE(v6.c.C0155c r9, java.lang.Object r10, qb.b<? super kotlin.Result<v6.d.l>> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.stepos.core.ability.vision.ImageExtendAbility$doInfer$2
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.core.ability.vision.ImageExtendAbility$doInfer$2 r0 = (com.stepos.core.ability.vision.ImageExtendAbility$doInfer$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.vision.ImageExtendAbility$doInfer$2 r0 = new com.stepos.core.ability.vision.ImageExtendAbility$doInfer$2
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r11)
            goto L6b
        L27:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2f:
            kotlin.c.b(r11)
            com.stepos.core.common.log.LogModule r11 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r2 = r8.TAG
            android.graphics.Bitmap r4 = r9.f13396b
            int r4 = r4.getWidth()
            android.graphics.Bitmap r5 = r9.f13396b
            int r5 = r5.getHeight()
            java.lang.String r6 = "doInfer: image="
            java.lang.String r7 = "x"
            java.lang.String r4 = a0.a.f(r6, r4, r5, r7)
            com.stepos.core.common.log.AIEngineLogger.d(r11, r2, r4)
            e7.e r8 = r8.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r11 = com.stepos.base.protocol.ProtocolType.f6379b
            e7.b r8 = r8.b(r11)
            e7.i r8 = (e7.i) r8
            if (r8 != 0) goto L62
            java.lang.String r8 = "VisionProtocol not available"
            kotlin.Result$Failure r8 = a0.a.r(r8)
            return r8
        L62:
            r0.label = r3
            java.lang.Object r11 = r8.processImage(r9, r10, r0)
            if (r11 != r1) goto L6b
            return r1
        L6b:
            v6.d r11 = (v6.d) r11
            boolean r8 = r11 instanceof v6.d.l
            if (r8 == 0) goto L72
            return r11
        L72:
            boolean r8 = r11 instanceof v6.d.f
            if (r8 == 0) goto L84
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            v6.d$f r11 = (v6.d.f) r11
            java.lang.String r9 = r11.f13437a
            r8.<init>(r9)
            kotlin.Result$Failure r8 = kotlin.c.a(r8)
            return r8
        L84:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = a0.a.n(r11)
            java.lang.String r10 = "Unexpected output: "
            java.lang.String r9 = ai.onnxruntime.a.k(r10, r9)
            r8.<init>(r9)
            kotlin.Result$Failure r8 = kotlin.c.a(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.ImageExtendAbility.m84doInfer0E7RQCE(v6.c$c, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m85doInfergIAlus(v6.c.C0155c r5, qb.b<? super kotlin.Result<v6.d.l>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ability.vision.ImageExtendAbility$doInfer$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ability.vision.ImageExtendAbility$doInfer$1 r0 = (com.stepos.core.ability.vision.ImageExtendAbility$doInfer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.vision.ImageExtendAbility$doInfer$1 r0 = new com.stepos.core.ability.vision.ImageExtendAbility$doInfer$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.f9987a
            return r4
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.c.b(r6)
            r0.label = r3
            r6 = 0
            java.lang.Object r4 = r4.m84doInfer0E7RQCE(r5, r6, r0)
            if (r4 != r1) goto L40
            return r1
        L40:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.ImageExtendAbility.m85doInfergIAlus(v6.c$c, qb.b):java.lang.Object");
    }
}
