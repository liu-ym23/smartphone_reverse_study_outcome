package com.stepos.core.ability.vision;

import android.graphics.Bitmap;
import com.stepos.base.ability.AbilityBase;
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
public final class InteractiveSegmentAbility extends AbilityBase<c.e, d.l> {
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.vision.InteractiveSegmentAbility$doFlowInfer$2", f = "InteractiveSegmentAbility.kt", l = {76, 81, 84, 85, 86, 87, 88}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.vision.InteractiveSegmentAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.l>>, b<? super n>, Object> {
        final /* synthetic */ c.e $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InteractiveSegmentAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(c.e eVar, InteractiveSegmentAbility interactiveSegmentAbility, Object obj, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = eVar;
            this.this$0 = interactiveSegmentAbility;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$input, this.this$0, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.l>> flowCollector, b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.l>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
        
            if (r1.emit(r2, r5) == r0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0090, code lost:
        
            if (r1.emit(r2, r5) == r0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00bb, code lost:
        
            if (r1.emit(r2, r5) == r0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00d8, code lost:
        
            if (r1.emit(r2, r5) == r0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00fa, code lost:
        
            if (r1.emit(r2, r5) == r0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x011e, code lost:
        
            if (r1.emit(r2, r5) == r0) goto L50;
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                Method dump skipped, instructions count: 312
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.InteractiveSegmentAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.l>> flowCollector, b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractiveSegmentAbility(a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.TAG = "InteractiveSegmentAbility";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.l segmentOutputToImageData(d.o oVar) {
        Bitmap bitmap = oVar.f13477a;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i10 = width * height;
        int[] iArr = new int[i10];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i10 * 3];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = iArr[i12];
            bArr[i11] = (byte) ((i13 >> 16) & 255);
            int i14 = i11 + 2;
            bArr[i11 + 1] = (byte) ((i13 >> 8) & 255);
            i11 += 3;
            bArr[i14] = (byte) (i13 & 255);
        }
        return new d.l(bArr, width, height, 1, 16);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(c cVar, Object obj, b bVar) {
        return doFlowInfer((c.e) cVar, obj, (b<? super Flow<Result<d.l>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo18doInfer0E7RQCE(c cVar, Object obj, b bVar) {
        return m90doInfer0E7RQCE((c.e) cVar, obj, (b<? super Result<d.l>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(c cVar, b bVar) {
        return m91doInfergIAlus((c.e) cVar, (b<? super Result<d.l>>) bVar);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return false;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.l defaultOutput() {
        return new d.l(new byte[0], 0, 0, 0, 24);
    }

    public Object doFlowInfer(c.e eVar, Object obj, b<? super Flow<Result<d.l>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(eVar, this, obj, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m90doInfer0E7RQCE(v6.c.e r8, java.lang.Object r9, qb.b<? super kotlin.Result<v6.d.l>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.stepos.core.ability.vision.InteractiveSegmentAbility$doInfer$2
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.core.ability.vision.InteractiveSegmentAbility$doInfer$2 r0 = (com.stepos.core.ability.vision.InteractiveSegmentAbility$doInfer$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.vision.InteractiveSegmentAbility$doInfer$2 r0 = new com.stepos.core.ability.vision.InteractiveSegmentAbility$doInfer$2
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            com.stepos.core.ability.vision.InteractiveSegmentAbility r7 = (com.stepos.core.ability.vision.InteractiveSegmentAbility) r7
            kotlin.c.b(r10)
            goto L9d
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
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
            java.util.List<v6.c> r8 = r8.f13409b
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r8 = r8.iterator()
        L5c:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L6e
            java.lang.Object r2 = r8.next()
            boolean r4 = r2 instanceof v6.c.C0155c
            if (r4 == 0) goto L5c
            r10.add(r2)
            goto L5c
        L6e:
            java.lang.Object r8 = kotlin.collections.a.v0(r10)
            v6.c$c r8 = (v6.c.C0155c) r8
            if (r8 != 0) goto L7d
            java.lang.String r7 = "InteractiveSegment requires an Image in Mixed input"
            kotlin.Result$Failure r7 = ai.onnxruntime.a.t(r7)
            return r7
        L7d:
            e7.e r10 = r7.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r2 = com.stepos.base.protocol.ProtocolType.f6379b
            e7.b r10 = r10.b(r2)
            e7.i r10 = (e7.i) r10
            if (r10 != 0) goto L92
            java.lang.String r7 = "VisionProtocol not available"
            kotlin.Result$Failure r7 = a0.a.r(r7)
            return r7
        L92:
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r10 = r10.processImage(r8, r9, r0)
            if (r10 != r1) goto L9d
            return r1
        L9d:
            v6.d r10 = (v6.d) r10
            boolean r8 = r10 instanceof v6.d.l
            if (r8 == 0) goto La4
            return r10
        La4:
            boolean r8 = r10 instanceof v6.d.o
            if (r8 == 0) goto Laf
            v6.d$o r10 = (v6.d.o) r10
            v6.d$l r7 = r7.segmentOutputToImageData(r10)
            return r7
        Laf:
            boolean r7 = r10 instanceof v6.d.f
            if (r7 == 0) goto Lc1
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            v6.d$f r10 = (v6.d.f) r10
            java.lang.String r8 = r10.f13437a
            r7.<init>(r8)
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
            return r7
        Lc1:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = a0.a.n(r10)
            java.lang.String r9 = "Unexpected output: "
            java.lang.String r8 = ai.onnxruntime.a.k(r9, r8)
            r7.<init>(r8)
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.InteractiveSegmentAbility.m90doInfer0E7RQCE(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m91doInfergIAlus(v6.c.e r5, qb.b<? super kotlin.Result<v6.d.l>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ability.vision.InteractiveSegmentAbility$doInfer$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ability.vision.InteractiveSegmentAbility$doInfer$1 r0 = (com.stepos.core.ability.vision.InteractiveSegmentAbility$doInfer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.vision.InteractiveSegmentAbility$doInfer$1 r0 = new com.stepos.core.ability.vision.InteractiveSegmentAbility$doInfer$1
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
            java.lang.Object r4 = r4.m90doInfer0E7RQCE(r5, r6, r0)
            if (r4 != r1) goto L40
            return r1
        L40:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.InteractiveSegmentAbility.m91doInfergIAlus(v6.c$e, qb.b):java.lang.Object");
    }
}
