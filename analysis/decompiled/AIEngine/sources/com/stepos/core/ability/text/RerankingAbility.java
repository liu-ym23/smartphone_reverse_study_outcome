package com.stepos.core.ability.text;

import com.stepos.base.ability.AbilityBase;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.PrimitiveContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.m;
import v6.c;
import v6.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RerankingAbility extends AbilityBase<c.e, d.e> {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_TOKEN_LIMIT = 512;
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.text.RerankingAbility$doFlowInfer$2", f = "RerankingAbility.kt", l = {55, 55}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.text.RerankingAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.e>>, qb.b<? super n>, Object> {
        final /* synthetic */ c.e $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(c.e eVar, Object obj, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = eVar;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = RerankingAbility.this.new AnonymousClass2(this.$input, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.e>> flowCollector, qb.b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.e>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (r1.emit(r3, r6) == r0) goto L15;
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
                if (r1 == 0) goto L24
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r7)
                goto L4e
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L18:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r7)
                kotlin.Result r7 = (kotlin.Result) r7
                java.lang.Object r7 = r7.f9987a
                goto L3d
            L24:
                kotlin.c.b(r7)
                java.lang.Object r7 = r6.L$0
                r1 = r7
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.core.ability.text.RerankingAbility r7 = com.stepos.core.ability.text.RerankingAbility.this
                v6.c$e r4 = r6.$input
                java.lang.Object r5 = r6.$record
                r6.L$0 = r1
                r6.label = r3
                java.lang.Object r7 = r7.m66doInfer0E7RQCE(r4, r5, r6)
                if (r7 != r0) goto L3d
                goto L4d
            L3d:
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r7)
                r7 = 0
                r6.L$0 = r7
                r6.label = r2
                java.lang.Object r6 = r1.emit(r3, r6)
                if (r6 != r0) goto L4e
            L4d:
                return r0
            L4e:
                lb.n r6 = lb.n.f10413a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.RerankingAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.e>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RerankingAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.TAG = "RerankingAbility";
    }

    private final PrimitiveContent<int[]> buildCalculateTokenLengthPrimitive(Object obj) {
        MixedContent mixedContent = obj instanceof MixedContent ? (MixedContent) obj : null;
        if (mixedContent != null) {
            List<Content> contents = mixedContent.getContents();
            ArrayList arrayList = new ArrayList();
            for (Content content : contents) {
                TextContent textContent = content instanceof TextContent ? (TextContent) content : null;
                String text = textContent != null ? textContent.getText() : null;
                if (text != null) {
                    arrayList.add(text);
                }
            }
            if (arrayList.size() >= 2) {
                List listP0 = kotlin.collections.a.p0(1, arrayList);
                int[] iArr = new int[listP0.size() * 3];
                int i10 = 0;
                int i11 = 0;
                for (Object obj2 : listP0) {
                    int i12 = i10 + 1;
                    if (i10 < 0) {
                        m.f0();
                        throw null;
                    }
                    int iEstimateTokenLength = estimateTokenLength((String) obj2);
                    iArr[i11] = i10;
                    int i13 = i11 + 2;
                    iArr[i11 + 1] = iEstimateTokenLength;
                    i11 += 3;
                    iArr[i13] = iEstimateTokenLength > 512 ? 1 : 0;
                    i10 = i12;
                }
                return PrimitiveContent.Companion.ofIntArray(iArr);
            }
        }
        return null;
    }

    private final int estimateTokenLength(String str) {
        return Math.max(1, str.length());
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.e) cVar, obj, (qb.b<? super Flow<Result<d.e>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo18doInfer0E7RQCE(v6.c cVar, Object obj, qb.b bVar) {
        return m66doInfer0E7RQCE((c.e) cVar, obj, (qb.b<? super Result<d.e>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m67doInfergIAlus((c.e) cVar, (qb.b<? super Result<d.e>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public Object execute(String action, Object obj) {
        g.f(action, "action");
        return action.equals("calculateTokenLength") ? buildCalculateTokenLengthPrimitive(obj) : super.execute(action, obj);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return false;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.e defaultOutput() {
        return new d.e("", new float[0]);
    }

    public Object doFlowInfer(c.e eVar, Object obj, qb.b<? super Flow<Result<d.e>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(eVar, obj, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m66doInfer0E7RQCE(v6.c.e r8, java.lang.Object r9, qb.b<? super kotlin.Result<v6.d.e>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.stepos.core.ability.text.RerankingAbility$doInfer$2
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.core.ability.text.RerankingAbility$doInfer$2 r0 = (com.stepos.core.ability.text.RerankingAbility$doInfer$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.text.RerankingAbility$doInfer$2 r0 = new com.stepos.core.ability.text.RerankingAbility$doInfer$2
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r10)
            goto L6b
        L27:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2f:
            kotlin.c.b(r10)
            com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r2 = r7.TAG
            java.util.List<v6.c> r4 = r8.f13409b
            int r4 = r4.size()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "doInfer: items="
            r5.<init>(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.stepos.core.common.log.AIEngineLogger.d(r10, r2, r4)
            e7.e r7 = r7.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r10 = com.stepos.base.protocol.ProtocolType.f6382e
            e7.b r7 = r7.b(r10)
            e7.d r7 = (e7.d) r7
            if (r7 != 0) goto L62
            java.lang.String r7 = "MultimodalProtocol not available"
            kotlin.Result$Failure r7 = a0.a.r(r7)
            return r7
        L62:
            r0.label = r3
            java.lang.Object r10 = r7.processMixed(r8, r9, r0)
            if (r10 != r1) goto L6b
            return r1
        L6b:
            v6.d r10 = (v6.d) r10
            boolean r7 = r10 instanceof v6.d.e
            if (r7 == 0) goto L72
            return r10
        L72:
            boolean r7 = r10 instanceof v6.d.f
            if (r7 == 0) goto L84
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            v6.d$f r10 = (v6.d.f) r10
            java.lang.String r8 = r10.f13437a
            r7.<init>(r8)
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
            return r7
        L84:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = a0.a.n(r10)
            java.lang.String r9 = "Unexpected output: "
            java.lang.String r8 = ai.onnxruntime.a.k(r9, r8)
            r7.<init>(r8)
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.RerankingAbility.m66doInfer0E7RQCE(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m67doInfergIAlus(v6.c.e r5, qb.b<? super kotlin.Result<v6.d.e>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ability.text.RerankingAbility$doInfer$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ability.text.RerankingAbility$doInfer$1 r0 = (com.stepos.core.ability.text.RerankingAbility$doInfer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.text.RerankingAbility$doInfer$1 r0 = new com.stepos.core.ability.text.RerankingAbility$doInfer$1
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
            java.lang.Object r4 = r4.m66doInfer0E7RQCE(r5, r6, r0)
            if (r4 != r1) goto L40
            return r1
        L40:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.RerankingAbility.m67doInfergIAlus(v6.c$e, qb.b):java.lang.Object");
    }
}
