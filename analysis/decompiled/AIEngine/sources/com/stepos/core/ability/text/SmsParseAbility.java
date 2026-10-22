package com.stepos.core.ability.text;

import com.stepos.base.ability.AbilityBase;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.deepbinder.core.exception.ErrorCodes;
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
public final class SmsParseAbility extends AbilityBase<c.e, d.q> {
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.text.SmsParseAbility$doFlowInfer$2", f = "SmsParseAbility.kt", l = {ErrorCodes.SERVICE_RECYCLE_ERROR, 56, 59, 59, 91}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.text.SmsParseAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super n>, Object> {
        final /* synthetic */ c.e $input;
        final /* synthetic */ Object $record;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ SmsParseAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(c.e eVar, SmsParseAbility smsParseAbility, Object obj, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = eVar;
            this.this$0 = smsParseAbility;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$input, this.this$0, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:74:0x0179, code lost:
        
            if (r2 == r3) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x01db, code lost:
        
            if (r4.emit(r2, r16) == r3) goto L83;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0165 A[Catch: Exception -> 0x0038, CancellationException -> 0x017c, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x017c, blocks: (B:71:0x0161, B:73:0x0165), top: B:89:0x0161 }] */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v27, types: [kotlin.jvm.internal.Ref$IntRef] */
        /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.jvm.internal.Ref$IntRef] */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r4v12, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r4v17 */
        /* JADX WARN: Type inference failed for: r4v18 */
        /* JADX WARN: Type inference failed for: r4v19 */
        /* JADX WARN: Type inference failed for: r4v20 */
        /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r6v10, types: [com.stepos.core.ability.text.SmsParseAbility$doFlowInfer$2$1, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1, types: [long] */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v12 */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v14, types: [long] */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v19 */
        /* JADX WARN: Type inference failed for: r7v20 */
        /* JADX WARN: Type inference failed for: r7v22 */
        /* JADX WARN: Type inference failed for: r7v4, types: [long] */
        /* JADX WARN: Type inference failed for: r7v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 522
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.SmsParseAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsParseAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.TAG = "SmsParseAbility";
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.e) cVar, obj, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m72doInfergIAlus((c.e) cVar, (qb.b<? super Result<d.q>>) bVar);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.q defaultOutput() {
        return new d.q("ni hao default", null, null, 6);
    }

    public Object doFlowInfer(c.e eVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(eVar, this, obj, null));
    }

    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    public Object m72doInfergIAlus(c.e eVar, qb.b<? super Result<d.q>> bVar) {
        AIEngineLogger.d(LogModule.ABILITY, this.TAG, "doInfer: items=" + eVar.f13409b.size());
        return new d.q("ni hao", null, null, 6);
    }
}
