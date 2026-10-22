package com.bytedance.android.ec.sdk.initalizer;

import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.plugin.e;
import com.bytedance.android.ec.sdk.plugin.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class ECSdkInitializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f48141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f48142b;

    public ECSdkInitializer() {
    }

    static {
    }

    public static void a(IECHostService r100, int r101) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
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
            boolean r0 = com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer.f48141a
            if (r0 == 0) goto L5
            return
        L5:
            java.lang.Class<com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer> r0 = com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer.class
            monitor-enter(r0)
            boolean r1 = com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer.f48141a     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto Le
            monitor-exit(r0)
            return
        Le:
            r1 = 0
            boolean r2 = com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer.f48142b     // Catch: java.lang.Throwable -> L30
            if (r2 == 0) goto L17
            com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer.f48142b = r1     // Catch: java.lang.Throwable -> L34
            monitor-exit(r0)
            return
        L17:
            r2 = 1
            com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer.f48142b = r2     // Catch: java.lang.Throwable -> L30
            com.bytedance.android.ec.sdk.initalizer.ECInitLogger r3 = new com.bytedance.android.ec.sdk.initalizer.ECInitLogger     // Catch: java.lang.Throwable -> L30
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L30
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L30
            com.bytedance.android.ec.sdk.initalizer.c.b(r4)     // Catch: java.lang.Throwable -> L30
            com.bytedance.android.ec.sdk.initalizer.b.b(r3)     // Catch: java.lang.Throwable -> L30
            com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer.f48141a = r2     // Catch: java.lang.Throwable -> L30
            com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer.f48142b = r1     // Catch: java.lang.Throwable -> L34
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L34
            monitor-exit(r0)
            return
        L30:
            r4 = move-exception
            com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer.f48142b = r1     // Catch: java.lang.Throwable -> L34
            throw r4     // Catch: java.lang.Throwable -> L34
        L34:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer.a(com.bytedance.android.ec.host.api.service.IECHostService, int):void");
    }

    public static void b(IECHostService r100, final Function1 r101) {
        if (r100 == null) goto L5;
        a(r100, 1);
    L7:
        if (e.a() == false) goto L9;
        int r102 = f.f48154a;
        f.a(null, new ECSdkInitializer$init$1(r101));
        return;
    L9:
        if (r101 == null) goto L13;
        Unit r103 = (Unit) r101.invoke(Boolean.valueOf(f48141a));
        return;
    L13:
        return;
    L5:
        a(null, 2);
        goto L7
    }
}
