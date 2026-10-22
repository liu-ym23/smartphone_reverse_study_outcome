package com.stepos.core.ability.text;

import com.stepos.base.ability.AbilityBase;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import v6.c;
import v6.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EmbeddingAbility extends AbilityBase<c.g, d.e> {
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.text.EmbeddingAbility$doFlowInfer$2", f = "EmbeddingAbility.kt", l = {71, 72, 85}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.text.EmbeddingAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.e>>, qb.b<? super n>, Object> {
        final /* synthetic */ c.g $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(c.g gVar, Object obj, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = gVar;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = EmbeddingAbility.this.new AnonymousClass2(this.$input, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.e>> flowCollector, qb.b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.e>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
        
            if (r10.collect(r4, r9) == r0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00aa, code lost:
        
            if (r1.emit(r3, r9) != r0) goto L32;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x007b A[Catch: Exception -> 0x0025, TRY_LEAVE, TryCatch #0 {Exception -> 0x0025, blocks: (B:11:0x0020, B:16:0x002b, B:24:0x0077, B:26:0x007b, B:19:0x0058, B:21:0x0068), top: B:34:0x0007 }] */
        /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.flow.FlowCollector] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2f
                if (r1 == r4) goto L27
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                kotlin.c.b(r10)
                goto Lad
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1c:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r10)     // Catch: java.lang.Exception -> L25
                goto Lad
            L25:
                r10 = move-exception
                goto L8b
            L27:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r10)     // Catch: java.lang.Exception -> L25
                goto L77
            L2f:
                kotlin.c.b(r10)
                java.lang.Object r10 = r9.L$0
                r1 = r10
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.ABILITY
                com.stepos.core.ability.text.EmbeddingAbility r5 = com.stepos.core.ability.text.EmbeddingAbility.this
                java.lang.String r5 = com.stepos.core.ability.text.EmbeddingAbility.access$getTAG$p(r5)
                v6.c$g r6 = r9.$input
                java.lang.String r6 = r6.f13416b
                int r6 = r6.length()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r8 = "doFlowInfer: text_len="
                r7.<init>(r8)
                r7.append(r6)
                java.lang.String r6 = r7.toString()
                com.stepos.core.common.log.AIEngineLogger.d(r10, r5, r6)
                com.stepos.core.ability.text.EmbeddingAbility r10 = com.stepos.core.ability.text.EmbeddingAbility.this     // Catch: java.lang.Exception -> L25
                e7.e r10 = com.stepos.core.ability.text.EmbeddingAbility.access$getProtocolManager(r10)     // Catch: java.lang.Exception -> L25
                com.stepos.base.protocol.ProtocolType r5 = com.stepos.base.protocol.ProtocolType.f6378a     // Catch: java.lang.Exception -> L25
                e7.b r10 = r10.b(r5)     // Catch: java.lang.Exception -> L25
                e7.h r10 = (e7.h) r10     // Catch: java.lang.Exception -> L25
                if (r10 == 0) goto Lad
                v6.c$g r5 = r9.$input     // Catch: java.lang.Exception -> L25
                java.lang.Object r6 = r9.$record     // Catch: java.lang.Exception -> L25
                r9.L$0 = r1     // Catch: java.lang.Exception -> L25
                r9.label = r4     // Catch: java.lang.Exception -> L25
                java.lang.Object r10 = r10.processText(r5, r6, r9)     // Catch: java.lang.Exception -> L25
                if (r10 != r0) goto L77
                goto Lac
            L77:
                kotlinx.coroutines.flow.Flow r10 = (kotlinx.coroutines.flow.Flow) r10     // Catch: java.lang.Exception -> L25
                if (r10 == 0) goto Lad
                com.stepos.core.ability.text.EmbeddingAbility$doFlowInfer$2$1 r4 = new com.stepos.core.ability.text.EmbeddingAbility$doFlowInfer$2$1     // Catch: java.lang.Exception -> L25
                r4.<init>()     // Catch: java.lang.Exception -> L25
                r9.L$0 = r1     // Catch: java.lang.Exception -> L25
                r9.label = r3     // Catch: java.lang.Exception -> L25
                java.lang.Object r9 = r10.collect(r4, r9)     // Catch: java.lang.Exception -> L25
                if (r9 != r0) goto Lad
                goto Lac
            L8b:
                com.stepos.core.common.log.LogModule r3 = com.stepos.core.common.log.LogModule.ABILITY
                com.stepos.core.ability.text.EmbeddingAbility r4 = com.stepos.core.ability.text.EmbeddingAbility.this
                java.lang.String r4 = com.stepos.core.ability.text.EmbeddingAbility.access$getTAG$p(r4)
                java.lang.String r5 = "doFlowInfer failed"
                com.stepos.core.common.log.AIEngineLogger.e(r3, r4, r5, r10)
                kotlin.Result$Failure r10 = kotlin.c.a(r10)
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r10)
                r10 = 0
                r9.L$0 = r10
                r9.label = r2
                java.lang.Object r9 = r1.emit(r3, r9)
                if (r9 != r0) goto Lad
            Lac:
                return r0
            Lad:
                lb.n r9 = lb.n.f10413a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.EmbeddingAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.e>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddingAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.TAG = "EmbeddingAbility";
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.g) cVar, obj, (qb.b<? super Flow<Result<d.e>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo18doInfer0E7RQCE(v6.c cVar, Object obj, qb.b bVar) {
        return m63doInfer0E7RQCE((c.g) cVar, obj, (qb.b<? super Result<d.e>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m64doInfergIAlus((c.g) cVar, (qb.b<? super Result<d.e>>) bVar);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return false;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.e defaultOutput() {
        return new d.e("", new float[0]);
    }

    public Object doFlowInfer(c.g gVar, Object obj, qb.b<? super Flow<Result<d.e>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(gVar, obj, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009f, code lost:
    
        if (r12.collect(r11, r0) == r1) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b3 A[Catch: Exception -> 0x0033, TRY_LEAVE, TryCatch #1 {Exception -> 0x0033, blocks: (B:13:0x002e, B:38:0x00ac, B:41:0x00b3, B:20:0x0046, B:29:0x008c, B:31:0x0090), top: B:47:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v0, types: [v6.c$g] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.stepos.core.ability.text.EmbeddingAbility] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* renamed from: doInfer-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m63doInfer0E7RQCE(v6.c.g r10, java.lang.Object r11, qb.b<? super kotlin.Result<v6.d.e>> r12) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.EmbeddingAbility.m63doInfer0E7RQCE(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m64doInfergIAlus(v6.c.g r5, qb.b<? super kotlin.Result<v6.d.e>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ability.text.EmbeddingAbility$doInfer$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ability.text.EmbeddingAbility$doInfer$1 r0 = (com.stepos.core.ability.text.EmbeddingAbility$doInfer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.text.EmbeddingAbility$doInfer$1 r0 = new com.stepos.core.ability.text.EmbeddingAbility$doInfer$1
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
            java.lang.Object r4 = r4.m63doInfer0E7RQCE(r5, r6, r0)
            if (r4 != r1) goto L40
            return r1
        L40:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.EmbeddingAbility.m64doInfergIAlus(v6.c$g, qb.b):java.lang.Object");
    }
}
