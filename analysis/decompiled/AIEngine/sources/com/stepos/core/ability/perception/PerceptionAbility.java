package com.stepos.core.ability.perception;

import android.util.Log;
import com.stepos.base.ability.AbilityBase;
import h7.e;
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
public final class PerceptionAbility extends AbilityBase<c.e, d.q> {
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.perception.PerceptionAbility$doFlowInfer$2", f = "PerceptionAbility.kt", l = {68, 73, 73, 96}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.perception.PerceptionAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.q>>, b<? super n>, Object> {
        final /* synthetic */ c.e $input;
        final /* synthetic */ Object $record;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(c.e eVar, Object obj, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = eVar;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass2 anonymousClass2 = PerceptionAbility.this.new AnonymousClass2(this.$input, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
        
            if (r14.emit(r2, r13) == r1) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0158, code lost:
        
            if (r6.emit(r0, r13) != r1) goto L54;
         */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00f6  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 389
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.perception.PerceptionAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PerceptionAbility(a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.TAG = "PerceptionAbility";
    }

    @Override // com.stepos.base.ability.AbilityBase
    public h7.d buildOrchestrator() {
        return new h7.d() { // from class: com.stepos.core.ability.perception.PerceptionAbility.buildOrchestrator.1
            @Override // h7.d
            public <T> Object makeDecision(T t8, String str, h7.b bVar, b<? super e> bVar2) {
                return new e.c(null, 3);
            }
        };
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doCloudInfer-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo17doCloudInfer0E7RQCE(c cVar, Object obj, b bVar) {
        return m29doCloudInfer0E7RQCE((c.e) cVar, obj, (b<? super Result<d.q>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowCloudInfer(c cVar, Object obj, b bVar) {
        return doFlowCloudInfer((c.e) cVar, obj, (b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(c cVar, Object obj, b bVar) {
        return doFlowInfer((c.e) cVar, obj, (b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(c cVar, b bVar) {
        return m30doInfergIAlus((c.e) cVar, (b<? super Result<d.q>>) bVar);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    /* renamed from: doCloudInfer-0E7RQCE, reason: not valid java name */
    public Object m29doCloudInfer0E7RQCE(c.e eVar, Object obj, b<? super Result<d.q>> bVar) {
        Log.d(this.TAG, "doCloudInfer: not implemented");
        return kotlin.c.a(new RuntimeException("Cloud inference not supported for Perception"));
    }

    public Object doFlowCloudInfer(c.e eVar, Object obj, b<? super Flow<Result<d.q>>> bVar) {
        Log.d(this.TAG, "doFlowCloudInfer: not implemented, falling back to local");
        return doFlowInfer(eVar, obj, bVar);
    }

    public Object doFlowInfer(c.e eVar, Object obj, b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(eVar, obj, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m30doInfergIAlus(v6.c.e r8, qb.b<? super kotlin.Result<v6.d.q>> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Unexpected output type: "
            boolean r1 = r9 instanceof com.stepos.core.ability.perception.PerceptionAbility$doInfer$1
            if (r1 == 0) goto L15
            r1 = r9
            com.stepos.core.ability.perception.PerceptionAbility$doInfer$1 r1 = (com.stepos.core.ability.perception.PerceptionAbility$doInfer$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.core.ability.perception.PerceptionAbility$doInfer$1 r1 = new com.stepos.core.ability.perception.PerceptionAbility$doInfer$1
            r1.<init>(r7, r9)
        L1a:
            java.lang.Object r9 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L38
            if (r3 != r4) goto L30
            java.lang.Object r7 = r1.L$0
            com.stepos.core.ability.perception.PerceptionAbility r7 = (com.stepos.core.ability.perception.PerceptionAbility) r7
            kotlin.c.b(r9)     // Catch: java.lang.Exception -> L2d
            goto L7a
        L2d:
            r8 = move-exception
            goto Lb5
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.c.b(r9)
            java.lang.String r9 = r7.TAG
            java.util.List<v6.c> r3 = r8.f13409b
            int r3 = r3.size()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "doInfer: items="
            r5.<init>(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.util.Log.d(r9, r3)
            e7.e r9 = r7.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r3 = com.stepos.base.protocol.ProtocolType.f6382e
            e7.b r9 = r9.b(r3)
            e7.d r9 = (e7.d) r9
            if (r9 != 0) goto L6e
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r8 = "MultimodalProtocol not initialized"
            r7.<init>(r8)
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
            return r7
        L6e:
            r1.L$0 = r7     // Catch: java.lang.Exception -> L2d
            r1.label = r4     // Catch: java.lang.Exception -> L2d
            r3 = 0
            java.lang.Object r9 = r9.processMixed(r8, r3, r1)     // Catch: java.lang.Exception -> L2d
            if (r9 != r2) goto L7a
            return r2
        L7a:
            v6.d r9 = (v6.d) r9     // Catch: java.lang.Exception -> L2d
            boolean r8 = r9 instanceof v6.d.q     // Catch: java.lang.Exception -> L2d
            if (r8 == 0) goto L81
            return r9
        L81:
            boolean r8 = r9 instanceof v6.d.f     // Catch: java.lang.Exception -> L2d
            if (r8 == 0) goto L93
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> L2d
            v6.d$f r9 = (v6.d.f) r9     // Catch: java.lang.Exception -> L2d
            java.lang.String r9 = r9.f13437a     // Catch: java.lang.Exception -> L2d
            r8.<init>(r9)     // Catch: java.lang.Exception -> L2d
            kotlin.Result$Failure r7 = kotlin.c.a(r8)     // Catch: java.lang.Exception -> L2d
            return r7
        L93:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> L2d
            java.lang.Class r9 = r9.getClass()     // Catch: java.lang.Exception -> L2d
            kotlin.jvm.internal.c r9 = kotlin.jvm.internal.i.a(r9)     // Catch: java.lang.Exception -> L2d
            java.lang.String r9 = r9.c()     // Catch: java.lang.Exception -> L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d
            r1.<init>(r0)     // Catch: java.lang.Exception -> L2d
            r1.append(r9)     // Catch: java.lang.Exception -> L2d
            java.lang.String r9 = r1.toString()     // Catch: java.lang.Exception -> L2d
            r8.<init>(r9)     // Catch: java.lang.Exception -> L2d
            kotlin.Result$Failure r7 = kotlin.c.a(r8)     // Catch: java.lang.Exception -> L2d
            return r7
        Lb5:
            java.lang.String r7 = r7.TAG
            java.lang.String r9 = "Perception inference failed"
            android.util.Log.e(r7, r9, r8)
            kotlin.Result$Failure r7 = kotlin.c.a(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.perception.PerceptionAbility.m30doInfergIAlus(v6.c$e, qb.b):java.lang.Object");
    }
}
