package com.stepos.core.ability.vision;

import com.stepos.base.ability.AbilityBase;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
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
public final class ImageCaptionAbility extends AbilityBase<c.C0155c, d.r> {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ImageCaptionAbility";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.vision.ImageCaptionAbility$doFlowInfer$2", f = "ImageCaptionAbility.kt", l = {56, 61, 62, 63, 64}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.vision.ImageCaptionAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.r>>, b<? super n>, Object> {
        final /* synthetic */ c.C0155c $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ImageCaptionAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(c.C0155c c0155c, Object obj, ImageCaptionAbility imageCaptionAbility, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = c0155c;
            this.$record = obj;
            this.this$0 = imageCaptionAbility;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$input, this.$record, this.this$0, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.r>> flowCollector, b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.r>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0090, code lost:
        
            if (r1.emit(r2, r13) == r0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b9, code lost:
        
            if (r1.emit(r2, r13) == r0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00da, code lost:
        
            if (r1.emit(r2, r13) == r0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00fd, code lost:
        
            if (r1.emit(r3, r13) == r0) goto L41;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.ImageCaptionAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.r>> flowCollector, b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCaptionAbility(a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(c cVar, Object obj, b bVar) {
        return doFlowInfer((c.C0155c) cVar, obj, (b<? super Flow<Result<d.r>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo18doInfer0E7RQCE(c cVar, Object obj, b bVar) {
        return m82doInfer0E7RQCE((c.C0155c) cVar, obj, (b<? super Result<d.r>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(c cVar, b bVar) {
        return m83doInfergIAlus((c.C0155c) cVar, (b<? super Result<d.r>>) bVar);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return false;
    }

    public Object doFlowInfer(c.C0155c c0155c, Object obj, b<? super Flow<Result<d.r>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(c0155c, obj, this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m82doInfer0E7RQCE(v6.c.C0155c r8, java.lang.Object r9, qb.b<? super kotlin.Result<v6.d.r>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.stepos.core.ability.vision.ImageCaptionAbility$doInfer$2
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.core.ability.vision.ImageCaptionAbility$doInfer$2 r0 = (com.stepos.core.ability.vision.ImageCaptionAbility$doInfer$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.vision.ImageCaptionAbility$doInfer$2 r0 = new com.stepos.core.ability.vision.ImageCaptionAbility$doInfer$2
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r10)
            goto L73
        L27:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2f:
            kotlin.c.b(r10)
            com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.ABILITY
            android.graphics.Bitmap r2 = r8.f13396b
            int r2 = r2.getWidth()
            android.graphics.Bitmap r4 = r8.f13396b
            int r4 = r4.getHeight()
            java.lang.String r5 = "doInfer: bitmap="
            java.lang.String r6 = "x"
            java.lang.String r2 = a0.a.f(r5, r2, r4, r6)
            java.lang.String r4 = "ImageCaptionAbility"
            com.stepos.core.common.log.AIEngineLogger.d(r10, r4, r2)
            e7.e r7 = r7.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r2 = com.stepos.base.protocol.ProtocolType.f6379b
            e7.b r7 = r7.b(r2)
            e7.i r7 = (e7.i) r7
            if (r7 != 0) goto L6a
            java.lang.String r7 = "VisionProtocol not available"
            com.stepos.core.common.log.AIEngineLogger.e(r10, r4, r7)
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r7)
            kotlin.Result$Failure r7 = kotlin.c.a(r8)
            return r7
        L6a:
            r0.label = r3
            java.lang.Object r10 = r7.processImage(r8, r9, r0)
            if (r10 != r1) goto L73
            return r1
        L73:
            v6.d r10 = (v6.d) r10
            boolean r7 = r10 instanceof v6.d.r
            if (r7 == 0) goto L7a
            return r10
        L7a:
            boolean r7 = r10 instanceof v6.d.f
            if (r7 == 0) goto L8c
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            v6.d$f r10 = (v6.d.f) r10
            java.lang.String r8 = r10.f13437a
            r7.<init>(r8)
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
            return r7
        L8c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = a0.a.n(r10)
            java.lang.String r9 = "Unexpected output type: "
            java.lang.String r8 = ai.onnxruntime.a.k(r9, r8)
            r7.<init>(r8)
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.ImageCaptionAbility.m82doInfer0E7RQCE(v6.c$c, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m83doInfergIAlus(v6.c.C0155c r5, qb.b<? super kotlin.Result<v6.d.r>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ability.vision.ImageCaptionAbility$doInfer$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ability.vision.ImageCaptionAbility$doInfer$1 r0 = (com.stepos.core.ability.vision.ImageCaptionAbility$doInfer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.vision.ImageCaptionAbility$doInfer$1 r0 = new com.stepos.core.ability.vision.ImageCaptionAbility$doInfer$1
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
            java.lang.Object r4 = r4.m82doInfer0E7RQCE(r5, r6, r0)
            if (r4 != r1) goto L40
            return r1
        L40:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.ImageCaptionAbility.m83doInfergIAlus(v6.c$c, qb.b):java.lang.Object");
    }
}
