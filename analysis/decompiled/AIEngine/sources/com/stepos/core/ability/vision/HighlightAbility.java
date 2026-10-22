package com.stepos.core.ability.vision;

import com.stepos.base.ability.AbilityBase;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import gc.q;
import java.io.File;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.m;
import p6.a;
import qb.b;
import v6.c;
import v6.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class HighlightAbility extends AbilityBase<c.e, d.q> {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_HIGHLIGHT_USER_PROMPT = "请根据视频内容，提取高光时刻并简要说明。";
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class HighlightMixedInputs {
        private final String prompt;
        private final String videoAbsolutePath;

        public HighlightMixedInputs(String videoAbsolutePath, String prompt) {
            g.f(videoAbsolutePath, "videoAbsolutePath");
            g.f(prompt, "prompt");
            this.videoAbsolutePath = videoAbsolutePath;
            this.prompt = prompt;
        }

        public static /* synthetic */ HighlightMixedInputs copy$default(HighlightMixedInputs highlightMixedInputs, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = highlightMixedInputs.videoAbsolutePath;
            }
            if ((i10 & 2) != 0) {
                str2 = highlightMixedInputs.prompt;
            }
            return highlightMixedInputs.copy(str, str2);
        }

        public final String component1() {
            return this.videoAbsolutePath;
        }

        public final String component2() {
            return this.prompt;
        }

        public final HighlightMixedInputs copy(String videoAbsolutePath, String prompt) {
            g.f(videoAbsolutePath, "videoAbsolutePath");
            g.f(prompt, "prompt");
            return new HighlightMixedInputs(videoAbsolutePath, prompt);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HighlightMixedInputs)) {
                return false;
            }
            HighlightMixedInputs highlightMixedInputs = (HighlightMixedInputs) obj;
            return g.b(this.videoAbsolutePath, highlightMixedInputs.videoAbsolutePath) && g.b(this.prompt, highlightMixedInputs.prompt);
        }

        public final String getPrompt() {
            return this.prompt;
        }

        public final String getVideoAbsolutePath() {
            return this.videoAbsolutePath;
        }

        public int hashCode() {
            return this.prompt.hashCode() + (this.videoAbsolutePath.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("HighlightMixedInputs(videoAbsolutePath=", this.videoAbsolutePath, ", prompt=", this.prompt, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.vision.HighlightAbility$doFlowInfer$2", f = "HighlightAbility.kt", l = {125, 138, 146, 146, 162}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.vision.HighlightAbility$doFlowInfer$2, reason: invalid class name */
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
            AnonymousClass2 anonymousClass2 = HighlightAbility.this.new AnonymousClass2(this.$input, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00ce, code lost:
        
            if (r3.emit(r4, r16) == r2) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0151, code lost:
        
            if (r8.emit(r3, r16) == r2) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0169, code lost:
        
            if (r3.emit(r4, r16) != r2) goto L56;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v2, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 367
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.HighlightAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HighlightAbility(a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.TAG = "HighlightAbility";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c.e effectiveHighlightMixed(c.e eVar, String str) {
        c.h hVarF = eVar.f();
        g.c(hVarF);
        c.g gVar = new c.g(str, null, 6);
        String path = hVarF.f13419b;
        long j10 = hVarF.f13420c;
        int i10 = hVarF.f13421d;
        String id2 = hVarF.f13422e;
        g.f(path, "path");
        g.f(id2, "id");
        c.e eVar2 = new c.e(m.b0(gVar, new c.h(j10, path, id2, i10)), eVar.f13410c, eVar.f13411d);
        LogModule logModule = LogModule.ABILITY;
        String str2 = this.TAG;
        int length = str.length();
        boolean z = eVar2.f13411d != null;
        StringBuilder sbF = h0.e.f("effectiveMixed: Text+Video → protocol; videoPath=", path, ", promptLen=", length, ", extras=");
        sbF.append(z);
        AIEngineLogger.d(logModule, str2, sbF.toString());
        return eVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HighlightMixedInputs parseHighlightMixed(c.e eVar) {
        String str;
        c.h hVarF = eVar.f();
        if (hVarF == null) {
            throw new IllegalArgumentException("Highlight 需要 Input.Video（本地视频文件路径）");
        }
        String string = q.L0(hVarF.f13419b).toString();
        if (string.length() == 0) {
            throw new IllegalArgumentException("Highlight 需要非空的本地视频路径");
        }
        if (!new File(string).canRead()) {
            throw new IllegalArgumentException(ai.onnxruntime.a.k("Highlight 视频文件不可读或不存在：", string));
        }
        c.g gVarE = eVar.e();
        String string2 = (gVarE == null || (str = gVarE.f13416b) == null) ? null : q.L0(str).toString();
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() <= 0) {
            string2 = DEFAULT_HIGHLIGHT_USER_PROMPT;
        }
        return new HighlightMixedInputs(string, string2);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(c cVar, Object obj, b bVar) {
        return doFlowInfer((c.e) cVar, obj, (b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(c cVar, b bVar) {
        return m81doInfergIAlus((c.e) cVar, (b<? super Result<d.q>>) bVar);
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
    public java.lang.Object m81doInfergIAlus(v6.c.e r11, qb.b<? super kotlin.Result<v6.d.q>> r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Unexpected output: "
            boolean r1 = r12 instanceof com.stepos.core.ability.vision.HighlightAbility$doInfer$1
            if (r1 == 0) goto L15
            r1 = r12
            com.stepos.core.ability.vision.HighlightAbility$doInfer$1 r1 = (com.stepos.core.ability.vision.HighlightAbility$doInfer$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.core.ability.vision.HighlightAbility$doInfer$1 r1 = new com.stepos.core.ability.vision.HighlightAbility$doInfer$1
            r1.<init>(r10, r12)
        L1a:
            java.lang.Object r12 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L38
            if (r3 != r4) goto L30
            java.lang.Object r10 = r1.L$0
            com.stepos.core.ability.vision.HighlightAbility r10 = (com.stepos.core.ability.vision.HighlightAbility) r10
            kotlin.c.b(r12)     // Catch: java.lang.Exception -> L2d
            goto L93
        L2d:
            r11 = move-exception
            goto Lce
        L30:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L38:
            kotlin.c.b(r12)
            com.stepos.core.ability.vision.HighlightAbility$HighlightMixedInputs r12 = r10.parseHighlightMixed(r11)     // Catch: java.lang.IllegalArgumentException -> Ldc
            java.lang.String r3 = r12.getPrompt()
            v6.c$e r11 = r10.effectiveHighlightMixed(r11, r3)
            com.stepos.core.common.log.LogModule r3 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r5 = r10.TAG
            java.lang.String r6 = r12.getVideoAbsolutePath()
            java.lang.String r7 = r12.getPrompt()
            int r7 = r7.length()
            java.lang.String r8 = "doInfer: video="
            java.lang.String r9 = ", promptLen="
            java.lang.String r6 = com.stepos.core.ota.d.h(r8, r7, r6, r9)
            com.stepos.core.common.log.AIEngineLogger.d(r3, r5, r6)
            e7.e r3 = r10.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r5 = com.stepos.base.protocol.ProtocolType.f6382e
            e7.b r3 = r3.b(r5)
            e7.d r3 = (e7.d) r3
            r5 = 0
            if (r3 != 0) goto L88
            v6.d$q r10 = new v6.d$q
            java.lang.String r11 = r12.getVideoAbsolutePath()
            java.lang.String r12 = r12.getPrompt()
            java.lang.String r0 = "[Mock] Highlight video="
            java.lang.String r1 = " text="
            java.lang.String r11 = ai.onnxruntime.a.l(r0, r11, r1, r12)
            r12 = 6
            r10.<init>(r11, r5, r5, r12)
            return r10
        L88:
            r1.L$0 = r10     // Catch: java.lang.Exception -> L2d
            r1.label = r4     // Catch: java.lang.Exception -> L2d
            java.lang.Object r12 = r3.processMixed(r11, r5, r1)     // Catch: java.lang.Exception -> L2d
            if (r12 != r2) goto L93
            return r2
        L93:
            v6.d r12 = (v6.d) r12     // Catch: java.lang.Exception -> L2d
            boolean r11 = r12 instanceof v6.d.q     // Catch: java.lang.Exception -> L2d
            if (r11 == 0) goto L9a
            return r12
        L9a:
            boolean r11 = r12 instanceof v6.d.f     // Catch: java.lang.Exception -> L2d
            if (r11 == 0) goto Lac
            java.lang.RuntimeException r11 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> L2d
            v6.d$f r12 = (v6.d.f) r12     // Catch: java.lang.Exception -> L2d
            java.lang.String r12 = r12.f13437a     // Catch: java.lang.Exception -> L2d
            r11.<init>(r12)     // Catch: java.lang.Exception -> L2d
            kotlin.Result$Failure r10 = kotlin.c.a(r11)     // Catch: java.lang.Exception -> L2d
            return r10
        Lac:
            java.lang.RuntimeException r11 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> L2d
            java.lang.Class r12 = r12.getClass()     // Catch: java.lang.Exception -> L2d
            kotlin.jvm.internal.c r12 = kotlin.jvm.internal.i.a(r12)     // Catch: java.lang.Exception -> L2d
            java.lang.String r12 = r12.c()     // Catch: java.lang.Exception -> L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d
            r1.<init>(r0)     // Catch: java.lang.Exception -> L2d
            r1.append(r12)     // Catch: java.lang.Exception -> L2d
            java.lang.String r12 = r1.toString()     // Catch: java.lang.Exception -> L2d
            r11.<init>(r12)     // Catch: java.lang.Exception -> L2d
            kotlin.Result$Failure r10 = kotlin.c.a(r11)     // Catch: java.lang.Exception -> L2d
            return r10
        Lce:
            com.stepos.core.common.log.LogModule r12 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r10 = r10.TAG
            java.lang.String r0 = "Highlight inference failed"
            com.stepos.core.common.log.AIEngineLogger.e(r12, r10, r0, r11)
            kotlin.Result$Failure r10 = kotlin.c.a(r11)
            return r10
        Ldc:
            r10 = move-exception
            kotlin.Result$Failure r10 = kotlin.c.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.vision.HighlightAbility.m81doInfergIAlus(v6.c$e, qb.b):java.lang.Object");
    }
}
