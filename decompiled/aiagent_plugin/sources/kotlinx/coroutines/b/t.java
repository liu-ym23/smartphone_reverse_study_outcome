package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class t {

    /* JADX INFO: compiled from: Share.kt */
    @d.c.b.a.f(b = "Share.kt", c = {210, 214, 215, 221}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ah f39092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h<T> f39093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ w<T> f39094d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ T f39095e;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.t$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: Share.kt */
        @d.c.b.a.f(b = "Share.kt", c = {}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<Integer, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f39096a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ int f39097b;

            AnonymousClass1(d.c.d<? super AnonymousClass1> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(int r3, d.c.d<? super Boolean> r4) {
                d.c.d<?> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(Integer.valueOf(r3), r5), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                AnonymousClass1 r4 = new AnonymousClass1((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                r4.f39097b = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue();
                return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(Integer r3, d.c.d<? super Boolean> r4) {
                return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f39096a != 0) goto L11;
                d.o.a(r2);
                if (this.f39097b <= 0) goto L7;
                boolean r1 = true;
            L9:
                return d.c.b.a.b.a(r1);
            L7:
                r1 = false;
                goto L9
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.b.t$a$2, reason: invalid class name */
        /* JADX INFO: compiled from: Share.kt */
        @d.c.b.a.f(b = "Share.kt", c = {223}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.m<af, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f39098a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f39099b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ h<T> f39100c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ w<T> f39101d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ T f39102e;

            /* JADX INFO: renamed from: kotlinx.coroutines.b.t$a$2$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Share.kt */
            public /* synthetic */ class C1053a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f39103a = null;

                static {
                    int[] r0 = new int[af.values().length];
                    r0[af.f38972a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r0[af.f38973b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r0[af.f38974c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    f39103a = r0;
                }
            }

            AnonymousClass2(h<? extends T> r3, w<T> r4, T r5, d.c.d<? super AnonymousClass2> r6) {
                h<T> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
                w<T> r8 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f39100c = r7;
                this.f39101d = r8;
                this.f39102e = r5;
                super(2, r9);
            }

            public final Object a(af r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass2 r0 = new AnonymousClass2(this.f39100c, this.f39101d, this.f39102e, r7);
                r0.f39099b = r5;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(af r3, d.c.d<? super d.x> r4) {
                return a((af) ZeusTransformUtils.preCheckCast(r3, af.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
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
                jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v6 boolean
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
                */
            @Override // d.c.b.a.a
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*  JADX ERROR: Simple mode code generation failed
                    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v6 boolean
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
                    r5 = this;
                    java.lang.Object r0 = d.c.a.b.a()
                    int r1 = r5.f39098a
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    d.o.a(r6)
                    goto L65
                Lf:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L17:
                    d.o.a(r6)
                    java.lang.Object r6 = r5.f39099b
                    java.lang.Class<kotlinx.coroutines.b.af> r1 = kotlinx.coroutines.b.af.class
                    java.lang.String r3 = "com.obric.aiagent.plugin"
                    java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, r1, r3)
                    kotlinx.coroutines.b.af r6 = (kotlinx.coroutines.b.af) r6
                    int[] r1 = kotlinx.coroutines.b.t.a.AnonymousClass2.C1053a.f39103a
                    int r6 = r6.ordinal()
                    r6 = r1[r6]
                    if (r6 == r2) goto L48
                    r0 = 3
                    if (r6 == r0) goto L34
                    goto L65
                L34:
                    T r6 = r5.f39102e
                    kotlinx.coroutines.internal.al r0 = kotlinx.coroutines.b.ad.f38969a
                    if (r6 != r0) goto L40
                    kotlinx.coroutines.b.w<T> r5 = r5.f39101d
                    r5.b()
                    goto L65
                L40:
                    kotlinx.coroutines.b.w<T> r6 = r5.f39101d
                    T r5 = r5.f39102e
                    r6.a(r5)
                    goto L65
                L48:
                    kotlinx.coroutines.b.h<T> r6 = r5.f39100c
                    kotlinx.coroutines.b.w<T> r1 = r5.f39101d
                    java.lang.Class<kotlinx.coroutines.b.i> r4 = kotlinx.coroutines.b.i.class
                    java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, r4, r3)
                    kotlinx.coroutines.b.i r1 = (kotlinx.coroutines.b.i) r1
                    java.lang.Class<d.c.d> r4 = d.c.d.class
                    java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, r4, r3)
                    d.c.d r3 = (d.c.d) r3
                    r5.f39098a = r2
                    java.lang.Object r5 = r6.collect(r1, r3)
                    if (r5 != r0) goto L65
                    return r0
                L65:
                    d.x r5 = d.x.f38692a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.b.t.a.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        a(ah r3, h<? extends T> r4, w<T> r5, T r6, d.c.d<? super a> r7) {
            ah r8 = (ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.aiagent.plugin");
            h<T> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
            w<T> r10 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39092b = r8;
            this.f39093c = r9;
            this.f39094d = r10;
            this.f39095e = r6;
            super(2, r11);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f39092b, this.f39093c, this.f39094d, this.f39095e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f39091a;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L11;
            if (r1 == 3) goto L12;
            if (r1 == 4) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r9);
        L23:
            h<T> r10 = this.f39093c;
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f39094d, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39091a = 3;
            if (r10.collect((i<? super T>) r2, r3) != r0) goto L30;
            return r0;
        L30:
            return d.x.f38692a;
        L12:
            d.o.a(r9);
            goto L30
        L13:
            d.o.a(r9);
            if (this.f39092b != ah.f38981a.a()) goto L19;
            h<T> r11 = this.f39093c;
            i r4 = (i) ZeusTransformUtils.preCheckCast(this.f39094d, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39091a = 1;
            if (r11.collect((i<? super T>) r4, r5) != r0) goto L30;
            return r0;
        L19:
            if (this.f39092b != ah.f38981a.b()) goto L26;
            h r12 = (h) ZeusTransformUtils.preCheckCast(this.f39094d.a(), h.class, "com.obric.aiagent.plugin");
            d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39091a = 2;
            if (j.b(r12, r6, r7) != r0) goto L23;
            return r0;
        L26:
            h r13 = j.b(this.f39092b.a(this.f39094d.a()));
            d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f39093c, this.f39094d, this.f39095e, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39091a = 4;
            if (j.a(r13, r8, r14) != r0) goto L30;
            return r0;
        }
    }

    private static final <T> ag<T> a(h<? extends T> r8, int r9) {
        h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.aiagent.plugin");
        int r2 = 1;
        if (aq.a() == false) goto L11;
        if (r9 < 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L11;
        throw new AssertionError();
    L6:
        r0 = false;
    L11:
        int r1 = d.l.n.c(r9, kotlinx.coroutines.a.d.f38805b.a()) - r9;
        if (ZeusTransformUtils.instanceOf(r10, kotlinx.coroutines.b.a.e.class) == false) goto L33;
        h<T> r4 = ((kotlinx.coroutines.b.a.e) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.b.a.e.class, "com.obric.aiagent.plugin")).a();
        if (r4 == null) goto L33;
        int r6 = ((kotlinx.coroutines.b.a.e) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.b.a.e.class, "com.obric.aiagent.plugin")).f38883b;
        if (r6 == (-3)) goto L22;
        if (r6 == (-2)) goto L22;
        if (r6 == 0) goto L22;
        r2 = ((kotlinx.coroutines.b.a.e) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.b.a.e.class, "com.obric.aiagent.plugin")).f38883b;
    L31:
        return new ag(r4, r2, ((kotlinx.coroutines.b.a.e) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.b.a.e.class, "com.obric.aiagent.plugin")).f38884c, ((kotlinx.coroutines.b.a.e) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.b.a.e.class, "com.obric.aiagent.plugin")).f38882a);
    L22:
        if (((kotlinx.coroutines.b.a.e) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.b.a.e.class, "com.obric.aiagent.plugin")).f38884c == kotlinx.coroutines.a.a.f38771a) goto L24;
        if (r9 == 0) goto L31;
    L29:
        r2 = 0;
        goto L31
    L24:
        if (((kotlinx.coroutines.b.a.e) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.b.a.e.class, "com.obric.aiagent.plugin")).f38883b == 0) goto L29;
        r2 = r1;
    L33:
        return new ag(r10, r1, kotlinx.coroutines.a.a.f38771a, (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin"));
    }

    private static final <T> ca a(kotlinx.coroutines.am r8, d.c.g r9, h<? extends T> r10, w<T> r11, ah r12, T r13) {
        kotlinx.coroutines.am r14 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        d.c.g r15 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r9, d.c.g.class, "com.obric.aiagent.plugin");
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r10, h.class, "com.obric.aiagent.plugin");
        w r5 = (w) ZeusTransformUtils.wrapperContextForParams(r11, w.class, "com.obric.aiagent.plugin");
        ah r3 = (ah) ZeusTransformUtils.wrapperContextForParams(r12, ah.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r3, ah.f38981a.a()) == false) goto L5;
        kotlinx.coroutines.ao r16 = kotlinx.coroutines.ao.f38851a;
    L7:
        return kotlinx.coroutines.i.a(r14, r15, r16, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r3, r4, r5, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    L5:
        r16 = kotlinx.coroutines.ao.f38854d;
        goto L7
    }

    public static final <T> ak<T> a(h<? extends T> r8, kotlinx.coroutines.am r9, ah r10, T r11) {
        h r12 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r2 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        ah r6 = (ah) ZeusTransformUtils.wrapperContextForParams(r10, ah.class, "com.obric.aiagent.plugin");
        ag r13 = a(r12, 1);
        x r14 = am.a(r11);
        ca r15 = a(r2, r13.f38980d, r13.f38977a, (w) ZeusTransformUtils.preCheckCast(r14, w.class, "com.obric.aiagent.plugin"), r6, r11);
        return (ak) ZeusTransformUtils.preCheckCast(new z((ak) ZeusTransformUtils.preCheckCast(r14, ak.class, "com.obric.aiagent.plugin"), r15), ak.class, "com.obric.aiagent.plugin");
    }

    public static final <T> ab<T> a(w<T> r3) {
        return (ab) ZeusTransformUtils.preCheckCast(new y((ab) ZeusTransformUtils.preCheckCast((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin"), ab.class, "com.obric.aiagent.plugin"), null), ab.class, "com.obric.aiagent.plugin");
    }

    public static final <T> ak<T> a(x<T> r3) {
        return (ak) ZeusTransformUtils.preCheckCast(new z((ak) ZeusTransformUtils.preCheckCast((x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.aiagent.plugin"), ak.class, "com.obric.aiagent.plugin"), null), ak.class, "com.obric.aiagent.plugin");
    }
}
