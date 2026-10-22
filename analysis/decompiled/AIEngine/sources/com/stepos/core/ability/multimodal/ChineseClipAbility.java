package com.stepos.core.ability.multimodal;

import com.stepos.base.ability.AbilityBase;
import com.stepos.deepbinder.core.exception.ErrorCodes;
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
public final class ChineseClipAbility extends AbilityBase<c.e, d.e> {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ChineseClipAbility";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.multimodal.ChineseClipAbility$doFlowInfer$2", f = "ChineseClipAbility.kt", l = {ErrorCodes.API_VERSION_CODE_TOO_HIGH, ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR, ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.multimodal.ChineseClipAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.e>>, b<? super n>, Object> {
        final /* synthetic */ c.e $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(c.e eVar, Object obj, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = eVar;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass2 anonymousClass2 = ChineseClipAbility.this.new AnonymousClass2(this.$input, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.e>> flowCollector, b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.e>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
        
            if (r1.emit(r2, r6) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        
            if (((kotlinx.coroutines.flow.Flow) r7).collect(r3, r6) != r0) goto L25;
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
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L27
                if (r1 == r4) goto L23
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.c.b(r7)
                goto L78
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1b:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r7)
                goto L65
            L23:
                kotlin.c.b(r7)
                goto L53
            L27:
                kotlin.c.b(r7)
                java.lang.Object r7 = r6.L$0
                r1 = r7
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.core.ability.multimodal.ChineseClipAbility r7 = com.stepos.core.ability.multimodal.ChineseClipAbility.this
                e7.e r7 = com.stepos.core.ability.multimodal.ChineseClipAbility.access$getProtocolManager(r7)
                com.stepos.base.protocol.ProtocolType r5 = com.stepos.base.protocol.ProtocolType.f6382e
                e7.b r7 = r7.b(r5)
                e7.d r7 = (e7.d) r7
                if (r7 != 0) goto L56
                java.lang.String r7 = "MultimodalProtocol not available"
                kotlin.Result$Failure r7 = a0.a.r(r7)
                kotlin.Result r2 = new kotlin.Result
                r2.<init>(r7)
                r6.label = r4
                java.lang.Object r6 = r1.emit(r2, r6)
                if (r6 != r0) goto L53
                goto L77
            L53:
                lb.n r6 = lb.n.f10413a
                return r6
            L56:
                v6.c$e r4 = r6.$input
                java.lang.Object r5 = r6.$record
                r6.L$0 = r1
                r6.label = r3
                java.lang.Object r7 = r7.processMixedStream(r4, r5, r6)
                if (r7 != r0) goto L65
                goto L77
            L65:
                kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
                com.stepos.core.ability.multimodal.ChineseClipAbility$doFlowInfer$2$1 r3 = new com.stepos.core.ability.multimodal.ChineseClipAbility$doFlowInfer$2$1
                r3.<init>()
                r1 = 0
                r6.L$0 = r1
                r6.label = r2
                java.lang.Object r6 = r7.collect(r3, r6)
                if (r6 != r0) goto L78
            L77:
                return r0
            L78:
                lb.n r6 = lb.n.f10413a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.multimodal.ChineseClipAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.e>> flowCollector, b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChineseClipAbility(a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(c cVar, Object obj, b bVar) {
        return doFlowInfer((c.e) cVar, obj, (b<? super Flow<Result<d.e>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo18doInfer0E7RQCE(c cVar, Object obj, b bVar) {
        return m27doInfer0E7RQCE((c.e) cVar, obj, (b<? super Result<d.e>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(c cVar, b bVar) {
        return m28doInfergIAlus((c.e) cVar, (b<? super Result<d.e>>) bVar);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return false;
    }

    public Object doFlowInfer(c.e eVar, Object obj, b<? super Flow<Result<d.e>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(eVar, obj, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m27doInfer0E7RQCE(v6.c.e r6, java.lang.Object r7, qb.b<? super kotlin.Result<v6.d.e>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.core.ability.multimodal.ChineseClipAbility$doInfer$2
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.ability.multimodal.ChineseClipAbility$doInfer$2 r0 = (com.stepos.core.ability.multimodal.ChineseClipAbility$doInfer$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.multimodal.ChineseClipAbility$doInfer$2 r0 = new com.stepos.core.ability.multimodal.ChineseClipAbility$doInfer$2
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r8)
            goto L59
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.c.b(r8)
            com.stepos.core.common.log.LogModule r8 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r2 = "ChineseClipAbility"
            java.lang.String r4 = "doInfer: mixed"
            com.stepos.core.common.log.AIEngineLogger.d(r8, r2, r4)
            e7.e r5 = r5.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r8 = com.stepos.base.protocol.ProtocolType.f6382e
            e7.b r5 = r5.b(r8)
            e7.d r5 = (e7.d) r5
            if (r5 != 0) goto L50
            java.lang.String r5 = "MultimodalProtocol not available"
            kotlin.Result$Failure r5 = a0.a.r(r5)
            return r5
        L50:
            r0.label = r3
            java.lang.Object r8 = r5.processMixed(r6, r7, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            v6.d r8 = (v6.d) r8
            boolean r5 = r8 instanceof v6.d.e
            if (r5 == 0) goto L60
            return r8
        L60:
            boolean r5 = r8 instanceof v6.d.f
            if (r5 == 0) goto L72
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            v6.d$f r8 = (v6.d.f) r8
            java.lang.String r6 = r8.f13437a
            r5.<init>(r6)
            kotlin.Result$Failure r5 = kotlin.c.a(r5)
            return r5
        L72:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = a0.a.n(r8)
            java.lang.String r7 = "Unexpected output: "
            java.lang.String r6 = ai.onnxruntime.a.k(r7, r6)
            r5.<init>(r6)
            kotlin.Result$Failure r5 = kotlin.c.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.multimodal.ChineseClipAbility.m27doInfer0E7RQCE(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m28doInfergIAlus(v6.c.e r5, qb.b<? super kotlin.Result<v6.d.e>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ability.multimodal.ChineseClipAbility$doInfer$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ability.multimodal.ChineseClipAbility$doInfer$1 r0 = (com.stepos.core.ability.multimodal.ChineseClipAbility$doInfer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.multimodal.ChineseClipAbility$doInfer$1 r0 = new com.stepos.core.ability.multimodal.ChineseClipAbility$doInfer$1
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
            java.lang.Object r4 = r4.m27doInfer0E7RQCE(r5, r6, r0)
            if (r4 != r1) goto L40
            return r1
        L40:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.multimodal.ChineseClipAbility.m28doInfergIAlus(v6.c$e, qb.b):java.lang.Object");
    }
}
