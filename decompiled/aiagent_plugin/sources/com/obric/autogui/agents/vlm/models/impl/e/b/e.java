package com.obric.autogui.agents.vlm.models.impl.e.b;

import android.content.Context;
import com.obric.autogui.agents.scripted.api.IJSScriptService;
import com.obric.autogui.agents.scripted.impl.w;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.Map;

/* JADX INFO: compiled from: ScriptStepOrchestrator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "Script-Orchestrator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.e.e.b f27821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.e.a.d f27822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.e.a.b f27823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.e.c.e f27824e;
    private final com.obric.autogui.agents.vlm.models.impl.e.c.a f;
    private final com.obric.autogui.agents.vlm.models.impl.e.f.c g;
    private final com.obric.autogui.agents.vlm.models.impl.e.f.b h;

    /* JADX INFO: compiled from: ScriptStepOrchestrator.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScriptStepOrchestrator.kt */
    @d.c.b.a.f(b = "ScriptStepOrchestrator.kt", c = {ApWakeEvent.OTHER_END, 200, 223, 248}, d = "execute", e = "com.obric.autogui.agents.vlm.models.impl.script.orchestrator.ScriptStepOrchestrator")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27827c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27828d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27829e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        long k;
        long l;
        int m;
        /* synthetic */ Object n;
        final /* synthetic */ e o;
        int p;

        b(e r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.o = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.n = r7;
            this.p |= Integer.MIN_VALUE;
            return this.o.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScriptStepOrchestrator.kt */
    @d.c.b.a.f(b = "ScriptStepOrchestrator.kt", c = {223}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.script.orchestrator.ScriptStepOrchestrator$execute$execResult$1$1")
    static final class c extends l implements m<com.obric.autogui.operator.b, d.c.d<? super com.obric.autogui.operator.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f27832c;

        c(d r3, d.c.d<? super c> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27832c = r5;
            super(2, r6);
        }

        public final Object a(com.obric.autogui.operator.b r3, d.c.d<? super com.obric.autogui.operator.c> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f27832c, r5);
            r0.f27831b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.operator.b r3, d.c.d<? super com.obric.autogui.operator.c> r4) {
            return a((com.obric.autogui.operator.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.operator.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27830a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.autogui.operator.b r7 = (com.obric.autogui.operator.b) ZeusTransformUtils.preCheckCast(this.f27831b, com.obric.autogui.operator.b.class, "com.obric.aiagent.plugin");
            d r2 = this.f27832c;
            d.c.d<? super com.obric.autogui.operator.c> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27830a = 1;
            r6 = r2.a(r7, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    static {
        f27820a = new a(null);
    }

    public static /* synthetic */ com.obric.autogui.agents.vlm.models.impl.l lambda$JAiTBI8fyJ5EpAUphWk1ShhcRBg(d r0) {
        return b(r0);
    }

    public e(com.obric.autogui.agents.vlm.models.impl.e.e.b r3, com.obric.autogui.agents.vlm.models.impl.e.a.d r4, com.obric.autogui.agents.vlm.models.impl.e.a.b r5, com.obric.autogui.agents.vlm.models.impl.e.c.e r6, com.obric.autogui.agents.vlm.models.impl.e.c.a r7, com.obric.autogui.agents.vlm.models.impl.e.f.c r8, com.obric.autogui.agents.vlm.models.impl.e.f.b r9) {
        com.obric.autogui.agents.vlm.models.impl.e.e.b r10 = (com.obric.autogui.agents.vlm.models.impl.e.e.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.agents.vlm.models.impl.e.e.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.e.a.d r11 = (com.obric.autogui.agents.vlm.models.impl.e.a.d) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.agents.vlm.models.impl.e.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.e.a.b r12 = (com.obric.autogui.agents.vlm.models.impl.e.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.agents.vlm.models.impl.e.a.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.e.c.e r13 = (com.obric.autogui.agents.vlm.models.impl.e.c.e) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.autogui.agents.vlm.models.impl.e.c.e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.e.c.a r14 = (com.obric.autogui.agents.vlm.models.impl.e.c.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autogui.agents.vlm.models.impl.e.c.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.e.f.c r15 = (com.obric.autogui.agents.vlm.models.impl.e.f.c) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.autogui.agents.vlm.models.impl.e.f.c.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.e.f.b r16 = (com.obric.autogui.agents.vlm.models.impl.e.f.b) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.autogui.agents.vlm.models.impl.e.f.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "scriptSource");
        d.h.b.o.e(r11, "operationPlanner");
        d.h.b.o.e(r12, "operationExecutor");
        d.h.b.o.e(r13, "securityPolicy");
        d.h.b.o.e(r14, "loopGuard");
        d.h.b.o.e(r15, "performanceReporter");
        d.h.b.o.e(r16, "failureRecorder");
        this.f27821b = r10;
        this.f27822c = r11;
        this.f27823d = r12;
        this.f27824e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:463:0x0e3d -> B:1115:0x0e50). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 69981. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object a(com.obric.autogui.session.a r51, java.lang.String r52, com.google.gson.JsonObject r53, com.obric.autogui.agents.vlm.models.impl.e.b.d r54, d.c.d<? super com.obric.autogui.operator.g> r55) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r1v0 ?? I:??[OBJECT, ARRAY]) = (r50v0 'this' com.obric.autogui.agents.vlm.models.impl.e.b.e A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] in method: com.obric.autogui.agents.vlm.models.impl.e.b.e.a(com.obric.autogui.session.a, java.lang.String, com.google.gson.JsonObject, com.obric.autogui.agents.vlm.models.impl.e.b.d, d.c.d<? super com.obric.autogui.operator.g>):java.lang.Object, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 6998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.autogui.agents.vlm.models.impl.e.b.e.a(com.obric.autogui.session.a, java.lang.String, com.google.gson.JsonObject, com.obric.autogui.agents.vlm.models.impl.e.b.d, d.c.d):java.lang.Object");
    }

    private static final com.obric.autogui.agents.vlm.models.impl.l b(d r2) {
        return ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")).d();
    }

    private final void a(d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        IJSScriptService r0 = (IJSScriptService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJSScriptService.class), IJSScriptService.class, "com.obric.aiagent.plugin");     // Catch: LinkageError -> L7 Exception -> L9
        if (r0 == null) goto L14;
        r0.requestResourceRecoveryOnScriptStartFailed((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: LinkageError -> L7 Exception -> L9
    L16:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "request resource recovery failed: " + e.getMessage());
        return;
    L7:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "request resource recovery unavailable: " + e.getMessage());
    }

    private final void a(com.obric.autogui.session.a r4, d r5, com.obric.autogui.agents.vlm.models.impl.e.f.d r6) {
        com.obric.autogui.agents.vlm.models.impl.l r3 = ((d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin")).d();
        int r7 = r4.s();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3.W(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L5;
        String r8 = r4.b() + ':' + r3.W();
    L8:
        com.obric.autogui.agents.scripted.b.b r9 = new com.obric.autogui.agents.scripted.b.b(com.obric.autogui.agents.scripted.c.a.f26915a.a("script_step_memory_snapshot", r8, 0), null, 2, null);
        r9.a();
        r6.a(r9);
        return;
    L5:
        if (r7 <= 0) goto L7;
        r8 = r4.b() + ':' + r7;
        goto L8
    L7:
        r8 = null;
        goto L8
    }

    private final void a(com.obric.autogui.session.a r4, com.obric.autogui.agents.vlm.models.impl.e.f.d r5) {
        if (com.obric.autogui.agents.scripted.c.b.f26918a.g() == true) goto L5;
        return;
    L5:
        Map<String, Object> r3 = r4.l().getInternalExtras();
        Object r0 = r3.get("ao_script_version_snapshot");
        if (ZeusTransformUtils.instanceOf(r0, w.a.class) == false) goto L8;
        w.a r1 = (w.a) ZeusTransformUtils.preCheckCast(r0, w.a.class, "com.obric.aiagent.plugin");
    L9:
        if (r1 == null) goto L12;
        Integer r2 = r1.a();
        if (r2 == null) goto L12;
    L13:
        if (r1 == null) goto L16;
        Integer r6 = r1.b();
        if (r6 == null) goto L16;
    L17:
        w.a r7 = new w.a(r2, r6);
        if (r2 != null) goto L20;
        if (r6 != null) goto L20;
    L21:
        r5.a(r7);
        return;
    L20:
        r3.put("ao_script_version_snapshot", r7);
    L16:
        r6 = w.f27103a.a("com.obric.script_engine");
    L12:
        r2 = w.f27103a.a("com.obric.ability.script");
        goto L13
    L8:
        r1 = null;
        goto L9
    }
}
