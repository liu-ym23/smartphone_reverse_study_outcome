package com.stepos.core.ability.vision;

import com.stepos.base.ability.AbilityBase;
import com.stepos.core.data.base.Content;
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
public final class VisionChatAbility extends AbilityBase<c.e, d.q> {
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.vision.VisionChatAbility$doFlowInfer$2", f = "VisionChatAbility.kt", l = {74, 80, 80, Content.Types.TYPE_FLOAT_ARRAY}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.vision.VisionChatAbility$doFlowInfer$2, reason: invalid class name */
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
            AnonymousClass2 anonymousClass2 = VisionChatAbility.this.new AnonymousClass2(this.$input, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
        
            if (r14.emit(r0, r13) == r1) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0158, code lost:
        
            if (r7.emit(r0, r13) != r1) goto L59;
         */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0108  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 385
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.VisionChatAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisionChatAbility(a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.TAG = "VisionChatAbility";
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(c cVar, Object obj, b bVar) {
        return doFlowInfer((c.e) cVar, obj, (b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(c cVar, b bVar) {
        return m94doInfergIAlus((c.e) cVar, (b<? super Result<d.q>>) bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    @Override // com.stepos.base.ability.AbilityBase, p6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(java.lang.String r6, java.lang.Object r7) {
        /*
            r5 = this;
            java.lang.String r0 = "action"
            kotlin.jvm.internal.g.f(r6, r0)
            java.lang.String r0 = "embedBatch"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L6e
            boolean r5 = r7 instanceof com.stepos.core.data.ListContent
            r6 = 0
            if (r5 == 0) goto L15
            com.stepos.core.data.ListContent r7 = (com.stepos.core.data.ListContent) r7
            goto L16
        L15:
            r7 = r6
        L16:
            if (r7 != 0) goto L19
            return r6
        L19:
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            java.util.List r7 = r7.getItems()
            java.util.Iterator r7 = r7.iterator()
        L26:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L6d
            java.lang.Object r0 = r7.next()
            kotlin.Pair r0 = (kotlin.Pair) r0
            A r1 = r0.f9985a
            java.lang.String r1 = (java.lang.String) r1
            B r0 = r0.f9986b
            com.stepos.core.data.base.Content r0 = (com.stepos.core.data.base.Content) r0
            boolean r2 = r0 instanceof com.stepos.core.data.FileContent
            r3 = 2
            r4 = 0
            if (r2 == 0) goto L55
            com.stepos.core.data.FileContent r0 = (com.stepos.core.data.FileContent) r0
            boolean r2 = r0.validate()
            if (r2 == 0) goto L53
            com.stepos.core.ability.util.EmbedSessionImageMock r2 = com.stepos.core.ability.util.EmbedSessionImageMock.INSTANCE
            java.lang.String r0 = r0.getPath()
            float[] r0 = com.stepos.core.ability.util.EmbedSessionImageMock.fromPath$default(r2, r0, r4, r3, r6)
            goto L67
        L53:
            r0 = r6
            goto L67
        L55:
            boolean r2 = r0 instanceof com.stepos.core.data.ImageContent
            if (r2 == 0) goto L53
            com.stepos.core.data.ImageContent r0 = (com.stepos.core.data.ImageContent) r0
            boolean r2 = r0.validate()
            if (r2 == 0) goto L53
            com.stepos.core.ability.util.EmbedSessionImageMock r2 = com.stepos.core.ability.util.EmbedSessionImageMock.INSTANCE
            float[] r0 = com.stepos.core.ability.util.EmbedSessionImageMock.fromImageContent$default(r2, r0, r4, r3, r6)
        L67:
            if (r0 == 0) goto L26
            r5.put(r1, r0)
            goto L26
        L6d:
            return r5
        L6e:
            java.lang.Object r5 = super.execute(r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.VisionChatAbility.execute(java.lang.String, java.lang.Object):java.lang.Object");
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
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
    public java.lang.Object m94doInfergIAlus(v6.c.e r9, qb.b<? super kotlin.Result<v6.d.q>> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "Unexpected output type: "
            boolean r1 = r10 instanceof com.stepos.core.ability.vision.VisionChatAbility$doInfer$1
            if (r1 == 0) goto L15
            r1 = r10
            com.stepos.core.ability.vision.VisionChatAbility$doInfer$1 r1 = (com.stepos.core.ability.vision.VisionChatAbility$doInfer$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.core.ability.vision.VisionChatAbility$doInfer$1 r1 = new com.stepos.core.ability.vision.VisionChatAbility$doInfer$1
            r1.<init>(r8, r10)
        L1a:
            java.lang.Object r10 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L38
            if (r3 != r4) goto L30
            java.lang.Object r8 = r1.L$0
            com.stepos.core.ability.vision.VisionChatAbility r8 = (com.stepos.core.ability.vision.VisionChatAbility) r8
            kotlin.c.b(r10)     // Catch: java.lang.Exception -> L2d
            goto L89
        L2d:
            r9 = move-exception
            goto Lc4
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.c.b(r10)
            com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r3 = r8.TAG
            java.util.List<v6.c> r5 = r9.f13409b
            int r5 = r5.size()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "doInfer: items="
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.stepos.core.common.log.AIEngineLogger.d(r10, r3, r5)
            e7.e r10 = r8.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r3 = com.stepos.base.protocol.ProtocolType.f6382e
            e7.b r10 = r10.b(r3)
            e7.d r10 = (e7.d) r10
            r3 = 0
            if (r10 != 0) goto L7e
            v6.c$g r8 = r9.e()
            if (r8 == 0) goto L6f
            java.lang.String r8 = r8.f13416b
            if (r8 != 0) goto L71
        L6f:
            java.lang.String r8 = ""
        L71:
            v6.d$q r9 = new v6.d$q
            java.lang.String r10 = "[Mock] VisionChat 收到输入："
            java.lang.String r8 = r10.concat(r8)
            r10 = 6
            r9.<init>(r8, r3, r3, r10)
            return r9
        L7e:
            r1.L$0 = r8     // Catch: java.lang.Exception -> L2d
            r1.label = r4     // Catch: java.lang.Exception -> L2d
            java.lang.Object r10 = r10.processMixed(r9, r3, r1)     // Catch: java.lang.Exception -> L2d
            if (r10 != r2) goto L89
            return r2
        L89:
            v6.d r10 = (v6.d) r10     // Catch: java.lang.Exception -> L2d
            boolean r9 = r10 instanceof v6.d.q     // Catch: java.lang.Exception -> L2d
            if (r9 == 0) goto L90
            return r10
        L90:
            boolean r9 = r10 instanceof v6.d.f     // Catch: java.lang.Exception -> L2d
            if (r9 == 0) goto La2
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> L2d
            v6.d$f r10 = (v6.d.f) r10     // Catch: java.lang.Exception -> L2d
            java.lang.String r10 = r10.f13437a     // Catch: java.lang.Exception -> L2d
            r9.<init>(r10)     // Catch: java.lang.Exception -> L2d
            kotlin.Result$Failure r8 = kotlin.c.a(r9)     // Catch: java.lang.Exception -> L2d
            return r8
        La2:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> L2d
            java.lang.Class r10 = r10.getClass()     // Catch: java.lang.Exception -> L2d
            kotlin.jvm.internal.c r10 = kotlin.jvm.internal.i.a(r10)     // Catch: java.lang.Exception -> L2d
            java.lang.String r10 = r10.c()     // Catch: java.lang.Exception -> L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d
            r1.<init>(r0)     // Catch: java.lang.Exception -> L2d
            r1.append(r10)     // Catch: java.lang.Exception -> L2d
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Exception -> L2d
            r9.<init>(r10)     // Catch: java.lang.Exception -> L2d
            kotlin.Result$Failure r8 = kotlin.c.a(r9)     // Catch: java.lang.Exception -> L2d
            return r8
        Lc4:
            com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r8 = r8.TAG
            java.lang.String r0 = "VLM inference failed"
            com.stepos.core.common.log.AIEngineLogger.e(r10, r8, r0, r9)
            kotlin.Result$Failure r8 = kotlin.c.a(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.VisionChatAbility.m94doInfergIAlus(v6.c$e, qb.b):java.lang.Object");
    }
}
