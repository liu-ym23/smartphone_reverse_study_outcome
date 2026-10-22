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
public final class PrivacyClassifyAbility extends AbilityBase<c.g, d.p> {
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.text.PrivacyClassifyAbility$doFlowInfer$2", f = "PrivacyClassifyAbility.kt", l = {63, 64, 78}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.text.PrivacyClassifyAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.p>>, qb.b<? super n>, Object> {
        final /* synthetic */ c.g $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PrivacyClassifyAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, PrivacyClassifyAbility privacyClassifyAbility, c.g gVar, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$record = obj;
            this.this$0 = privacyClassifyAbility;
            this.$input = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$record, this.this$0, this.$input, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.p>> flowCollector, qb.b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.p>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00aa, code lost:
        
            if (r12.collect(r7, r11) == r0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00cf, code lost:
        
            if (r1.emit(r3, r11) != r0) goto L48;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0099 A[Catch: Exception -> 0x0039, TRY_LEAVE, TryCatch #0 {Exception -> 0x0039, blocks: (B:16:0x0035, B:40:0x0095, B:42:0x0099), top: B:50:0x0035 }] */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v5 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 213
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.PrivacyClassifyAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.p>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyClassifyAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.TAG = "PrivacyClassifyAbility";
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.g) cVar, obj, (qb.b<? super Flow<Result<d.p>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m65doInfergIAlus((c.g) cVar, (qb.b<? super Result<d.p>>) bVar);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.p defaultOutput() {
        return new d.p(0, false, new float[0], new float[0], 0, "");
    }

    public Object doFlowInfer(c.g gVar, Object obj, qb.b<? super Flow<Result<d.p>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(obj, this, gVar, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a0, code lost:
    
        if (r11.collect(r2, r0) == r1) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b4 A[Catch: Exception -> 0x0033, TRY_LEAVE, TryCatch #1 {Exception -> 0x0033, blocks: (B:13:0x002e, B:38:0x00ad, B:41:0x00b4, B:20:0x0046, B:29:0x008d, B:31:0x0091), top: B:47:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v0, types: [v6.c$g] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.stepos.core.ability.text.PrivacyClassifyAbility] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m65doInfergIAlus(v6.c.g r10, qb.b<? super kotlin.Result<v6.d.p>> r11) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.PrivacyClassifyAbility.m65doInfergIAlus(v6.c$g, qb.b):java.lang.Object");
    }
}
