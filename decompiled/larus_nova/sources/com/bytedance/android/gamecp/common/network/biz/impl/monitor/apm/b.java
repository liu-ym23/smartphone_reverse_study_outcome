package com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f56669a;

    /* JADX WARN: Type inference failed for: r6v2, types: [D, java.lang.Object] */
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
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v13 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // android.os.Handler
    public final void handleMessage(android.os.Message r6) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v13 boolean
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
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L2d
            int r2 = r6.what
            if (r2 != r1) goto L2d
            com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.c r6 = r5.f56669a
            D r2 = r6.f56673d
            com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.c$a<D> r6 = r6.f56671b
            if (r6 == 0) goto L55
            if (r2 == 0) goto L55
            boolean r6 = r6.accept(r2)
            if (r6 == 0) goto L23
            com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.c r6 = r5.f56669a
            r2 = 0
            r6.f56673d = r2
            java.util.concurrent.atomic.AtomicBoolean r6 = r6.f56674e
            r6.compareAndSet(r1, r0)
            goto L55
        L23:
            com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.c r6 = r5.f56669a
            com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.b r0 = r6.f56676g
            long r2 = r6.f56670a
            r0.sendEmptyMessageDelayed(r1, r2)
            goto L55
        L2d:
            int r2 = r6.what
            r3 = 2
            if (r2 != r3) goto L55
            java.lang.Object r6 = r6.obj
            com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.c r2 = r5.f56669a
            com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.c$b<I, D> r3 = r2.f56672c
            D r4 = r2.f56673d
            java.lang.Object r6 = r3.a(r6, r4)
            r2.f56673d = r6
            com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.c r6 = r5.f56669a
            java.util.concurrent.atomic.AtomicBoolean r6 = r6.f56674e
            boolean r6 = r6.compareAndSet(r0, r1)
            if (r6 == 0) goto L55
            com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.c r6 = r5.f56669a
            com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.b r0 = r6.f56676g
            if (r0 == 0) goto L55
            long r2 = r6.f56670a
            r0.sendEmptyMessageDelayed(r1, r2)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.b.handleMessage(android.os.Message):void");
    }

    public b(c r100, Looper r101) {
        this.f56669a = r100;
        super(r101);
    }
}
