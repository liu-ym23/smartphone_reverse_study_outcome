package com.obric.agent.intents.skill.a;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.k;
import d.n;
import d.x;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: BaseIntentActionDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<ActionContextT> {

    /* JADX INFO: renamed from: com.obric.agent.intents.skill.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseIntentActionDispatcher.kt */
    protected static abstract class AbstractC0296a<T> {

        /* JADX INFO: renamed from: com.obric.agent.intents.skill.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BaseIntentActionDispatcher.kt */
        public static final class C0297a extends AbstractC0296a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final IntentResult<Empty> f14875a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0297a.class) == true) goto L8;
                return false;
            L8:
                C0297a r6 = (C0297a) ZeusTransformUtils.preCheckCast(r5, C0297a.class, "com.obric.aiagent.plugin");
                if (o.a(this.f14875a, r6.f14875a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f14875a.hashCode();
            }

            public String toString() {
                return "Failure(result=" + this.f14875a + ')';
            }

            public C0297a(IntentResult<Empty> r2) {
                o.e(r2, "result");
                super(null);
                this.f14875a = r2;
            }

            public final IntentResult<Empty> a() {
                return this.f14875a;
            }
        }

        /* JADX INFO: renamed from: com.obric.agent.intents.skill.a.a$a$b */
        /* JADX INFO: compiled from: BaseIntentActionDispatcher.kt */
        public static final class b<T> extends AbstractC0296a<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final T f14876a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
                if (o.a(this.f14876a, r6.f14876a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                T r0 = this.f14876a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public String toString() {
                return "Success(value=" + this.f14876a + ')';
            }

            public b(T r2) {
                super(null);
                this.f14876a = r2;
            }

            public final T a() {
                return this.f14876a;
            }
        }

        public /* synthetic */ AbstractC0296a(d.h.b.h r1) {
            this();
        }

        private AbstractC0296a() {
        }
    }

    /* JADX INFO: compiled from: BaseIntentActionDispatcher.kt */
    @d.c.b.a.f(b = "BaseIntentActionDispatcher.kt", c = {108}, d = "executeFinalResult", e = "com.obric.agent.intents.skill.common.BaseIntentActionDispatcher")
    static final class b<ActionRequestT> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a<ActionContextT> f14880d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14881e;

        b(a<ActionContextT> r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14880d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f14879c = r7;
            this.f14881e |= Integer.MIN_VALUE;
            return a.a(this.f14880d, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: BaseIntentActionDispatcher.kt */
    @d.c.b.a.f(b = "BaseIntentActionDispatcher.kt", c = {109, 110}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.common.BaseIntentActionDispatcher$executeFinalResult$2$1")
    static final class c extends l implements m<am, d.c.d<? super IntentResult<Empty>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a<ActionContextT> f14883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f14884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ DispatchContext f14885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.intents.skill.a.c<ActionContextT, ActionRequestT> f14886e;
        final /* synthetic */ ActionRequestT f;

        c(a<ActionContextT> r3, f r4, DispatchContext r5, com.obric.agent.intents.skill.a.c<ActionContextT, ActionRequestT> r6, ActionRequestT r7, d.c.d<? super c> r8) {
            com.obric.agent.intents.skill.a.c<ActionContextT, ActionRequestT> r9 = (com.obric.agent.intents.skill.a.c) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.agent.intents.skill.a.c.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14883b = r3;
            this.f14884c = r4;
            this.f14885d = r5;
            this.f14886e = r9;
            this.f = r7;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super IntentResult<Empty>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f14883b, this.f14884c, this.f14885d, this.f14886e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super IntentResult<Empty>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v11 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // d.c.b.a.a
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*  JADX ERROR: Simple mode code generation failed
                jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v11 boolean
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                */
            /*
                r7 = this;
                java.lang.Object r0 = d.c.a.b.a()
                int r1 = r7.f14882a
                r2 = 2
                r3 = 1
                java.lang.String r4 = "com.obric.aiagent.plugin"
                if (r1 == 0) goto L20
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                d.o.a(r8)
                goto L6d
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1c:
                d.o.a(r8)
                goto L3a
            L20:
                d.o.a(r8)
                com.obric.agent.intents.skill.a.a<ActionContextT> r8 = r7.f14883b
                com.obric.agent.intents.skill.a.f r1 = r7.f14884c
                com.obric.capabilitykit.common.DispatchContext r5 = r7.f14885d
                java.lang.Class<d.c.d> r6 = d.c.d.class
                java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, r6, r4)
                d.c.d r6 = (d.c.d) r6
                r7.f14882a = r3
                java.lang.Object r8 = r8.a(r1, r5, r6)
                if (r8 != r0) goto L3a
                return r0
            L3a:
                java.lang.Class<com.obric.agent.intents.skill.a.a$a> r1 = com.obric.agent.intents.skill.a.a.AbstractC0296a.class
                java.lang.Object r8 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, r1, r4)
                com.obric.agent.intents.skill.a.a$a r8 = (com.obric.agent.intents.skill.a.a.AbstractC0296a) r8
                java.lang.Class<com.obric.agent.intents.skill.a.a$a$b> r1 = com.obric.agent.intents.skill.a.a.AbstractC0296a.b.class
                boolean r1 = com.volcengine.zeus.transform.ZeusTransformUtils.instanceOf(r8, r1)
                if (r1 == 0) goto L76
                com.obric.agent.intents.skill.a.c<ActionContextT, ActionRequestT> r1 = r7.f14886e
                java.lang.Class<com.obric.agent.intents.skill.a.a$a$b> r3 = com.obric.agent.intents.skill.a.a.AbstractC0296a.b.class
                java.lang.Object r8 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, r3, r4)
                com.obric.agent.intents.skill.a.a$a$b r8 = (com.obric.agent.intents.skill.a.a.AbstractC0296a.b) r8
                java.lang.Object r8 = r8.a()
                ActionRequestT r3 = r7.f
                com.obric.capabilitykit.common.DispatchContext r5 = r7.f14885d
                java.lang.Class<d.c.d> r6 = d.c.d.class
                java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, r6, r4)
                d.c.d r6 = (d.c.d) r6
                r7.f14882a = r2
                java.lang.Object r8 = r1.a(r8, r3, r5, r6)
                if (r8 != r0) goto L6d
                return r0
            L6d:
                java.lang.Class<com.obric.capabilitykit.common.intent.IntentResult> r7 = com.obric.capabilitykit.common.intent.IntentResult.class
                java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, r7, r4)
                com.obric.capabilitykit.common.intent.IntentResult r7 = (com.obric.capabilitykit.common.intent.IntentResult) r7
                goto L8a
            L76:
                java.lang.Class<com.obric.agent.intents.skill.a.a$a$a> r7 = com.obric.agent.intents.skill.a.a.AbstractC0296a.C0297a.class
                boolean r7 = com.volcengine.zeus.transform.ZeusTransformUtils.instanceOf(r8, r7)
                if (r7 == 0) goto L8b
                java.lang.Class<com.obric.agent.intents.skill.a.a$a$a> r7 = com.obric.agent.intents.skill.a.a.AbstractC0296a.C0297a.class
                java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, r7, r4)
                com.obric.agent.intents.skill.a.a$a$a r7 = (com.obric.agent.intents.skill.a.a.AbstractC0296a.C0297a) r7
                com.obric.capabilitykit.common.intent.IntentResult r7 = r7.a()
            L8a:
                return r7
            L8b:
                d.k r7 = new d.k
                r7.<init>()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.obric.agent.intents.skill.a.a.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public abstract IntentResult<Empty> a(String r1);

    public abstract IntentResult<Empty> a(String r1, Throwable r2);

    public abstract Object a(f r1, DispatchContext r2, d.c.d<? super AbstractC0296a<? extends ActionContextT>> r3);

    public abstract String a();

    public void a(f r1) {
        o.e(r1, Ext.KEY_REQUEST);
    }

    public void a(f r1, IntentResult<Empty> r2) {
        o.e(r1, Ext.KEY_REQUEST);
        o.e(r2, "result");
    }

    public void a(f r1, Throwable r2) {
        o.e(r1, Ext.KEY_REQUEST);
        o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
    }

    public abstract Map<String, com.obric.agent.intents.skill.a.c<ActionContextT, ?>> b();

    public a() {
    }

    public static final /* synthetic */ Object a(a r8, com.obric.agent.intents.skill.a.c r9, f r10, Object r11, DispatchContext r12, d.c.d r13) {
        return r8.a((com.obric.agent.intents.skill.a.c) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.agent.intents.skill.a.c.class, "com.obric.aiagent.plugin"), r10, r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Object b(f r4, DispatchContext r5, d.c.d<? super IntentResult<Empty>> r6) {
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.a.c<ActionContextT, ActionRequestT> r0 = (com.obric.agent.intents.skill.a.c) ZeusTransformUtils.preCheckCast(b().get(r4.b()), com.obric.agent.intents.skill.a.c.class, "com.obric.aiagent.plugin");
        if (r0 != 0) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        r3.a(r4);
        return r3.a(r4.b());
    L7:
        return a(r0, r4, r5, r7);
    }

    private final <ActionRequestT> Object a(com.obric.agent.intents.skill.a.c<ActionContextT, ActionRequestT> r9, f r10, DispatchContext r11, d.c.d<? super IntentResult<Empty>> r12) {
        com.obric.agent.intents.skill.a.c<ActionContextT, ActionRequestT> r3 = (com.obric.agent.intents.skill.a.c) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.agent.intents.skill.a.c.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        g<ActionRequestT> r13 = r3.a(r10);
        if (ZeusTransformUtils.instanceOf(r13, g.b.class) == false) goto L7;
        return a(r3, r10, ((g.b) ZeusTransformUtils.preCheckCast(r13, g.b.class, "com.obric.aiagent.plugin")).a(), r11, r7);
    L7:
        if (ZeusTransformUtils.instanceOf(r13, g.a.class) == false) goto L11;
        a(r10, ((g.a) ZeusTransformUtils.preCheckCast(r13, g.a.class, "com.obric.aiagent.plugin")).a());
        return ((g.a) ZeusTransformUtils.preCheckCast(r13, g.a.class, "com.obric.aiagent.plugin")).a();
    L11:
        throw new k();
    }

    private final <ActionRequestT> Object a(com.obric.agent.intents.skill.a.c<ActionContextT, ActionRequestT> r15, f r16, ActionRequestT r17, DispatchContext r18, d.c.d<? super IntentResult<Empty>> r19) {
        a<ActionContextT> r1 = this;
        com.obric.agent.intents.skill.a.c r8 = (com.obric.agent.intents.skill.a.c) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.agent.intents.skill.a.c.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L7;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        if ((r4.f14881e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f14881e -= Integer.MIN_VALUE;
    L8:
        b r3 = r4;
        Object r5 = r3.f14879c;
        Object r11 = d.c.a.b.a();
        int r6 = r3.f14881e;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        f r7 = (f) ZeusTransformUtils.preCheckCast(r3.f14878b, f.class, "com.obric.aiagent.plugin");
        a<ActionContextT> r9 = (a) ZeusTransformUtils.preCheckCast(r3.f14877a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L14
        f r10 = r7;
        r1 = r9;
    L24:
        Object r0 = n.f((IntentResult) ZeusTransformUtils.preCheckCast(r5, IntentResult.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
    L31:
        Throwable r12 = n.c(r0);
        if (r12 != null) goto L35;
        return r0;
    L35:
        if (IAppContext.Companion.isDebug() == false) goto L37;
        ILogDepend.Companion.e(r1.a(), "intent action failed actionType=" + r10.b(), r12);
    L38:
        r1.a(r10, r12);
        return r1.a(r10.b(), r12);
    L37:
        ILogDepend.Companion.e(r1.a(), "intent action failed");
    L26:
        th = th;
    L30:
        n.a r13 = n.f38560a;
        r0 = n.f(d.o.a(th));
    L14:
        th = th;
        r10 = r7;
        r1 = r9;
        goto L30
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r5);
        n.a r14 = n.f38560a;     // Catch: Throwable -> L28
        a r20 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        d.c.g r21 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        m r22 = (m) ZeusTransformUtils.preCheckCast(new c(r20, r16, r18, r8, r17, null), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        r3.f14877a = r1;     // Catch: Throwable -> L28
        r10 = r16;
        r3.f14878b = r10;     // Catch: Throwable -> L26
        r3.f14881e = 1;     // Catch: Throwable -> L26
        r5 = i.a(r21, r22, r3);     // Catch: Throwable -> L26
        if (r5 != r11) goto L24;
        return r11;
    L28:
        th = th;
        r10 = r16;
    L7:
        r4 = new b(this, r2);
        goto L8
    }
}
