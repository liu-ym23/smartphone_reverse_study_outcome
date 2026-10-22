package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class PlatformApiIDLIpcWrapper implements IPlatformApiIDL {
    boolean log;
    final IPlatformApiIDL origin;

    PlatformApiIDLIpcWrapper(IPlatformApiIDL r3) {
        this((IPlatformApiIDL) ZeusTransformUtils.wrapperContextForParams(r3, IPlatformApiIDL.class, "com.obric.aiagent.plugin"), true);
    }

    PlatformApiIDLIpcWrapper(IPlatformApiIDL r3, boolean r4) {
        this.origin = (IPlatformApiIDL) ZeusTransformUtils.wrapperContextForParams(r3, IPlatformApiIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0160: RETURN (r14 I:boolean) A[SYNTHETIC], block:B:28:? */
    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public boolean moveTaskToDisplay(int r33, int r34, boolean r35) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L18:
        e = e;
        boolean r14 = false;
    L20:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IPlatformApiIDLIPC", "moveTaskToDisplay(" + r33 + ", " + r34 + ", " + r35 + ")", e);     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L22
        long r30 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L22
        long r28 = Math.max(0, r30 - r8) / 1000;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.k.f18677a.a("IPlatformApiIDLIPC", "moveTaskToDisplay(" + r33 + ", " + r34 + ", " + r35 + ") = fail", r4, r28);     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.d.f18654a.a("IPlatformApiIDLIPC", "moveTaskToDisplay", r4, r28, r30);     // Catch: Throwable -> L22
        return r14;
    L17:
        return false;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IPlatformApiIDLIPC", "moveTaskToDisplay(" + r33 + ", " + r34 + ", " + r35 + ")");     // Catch: Throwable -> L17 Exception -> L18
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IPlatformApiIDLIPC", "moveTaskToDisplay(" + r33 + ", " + r34 + ", " + r35 + ")");     // Catch: Throwable -> L17 Exception -> L18
    L9:
        r14 = this.origin.moveTaskToDisplay(r33, r34, r35);     // Catch: Throwable -> L17 Exception -> L18
    L15:
        e = e;
        goto L20
    L11:
        if (this.log == false) goto L13;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IPlatformApiIDLIPC", "moveTaskToDisplay = " + r14);     // Catch: Exception -> L15 Throwable -> L22
    L13:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L22
        long r10 = Math.max(0, r22 - r8) / 1000;     // Catch: Exception -> L15 Throwable -> L22
        com.obric.aiagent.ipc.utils.k.f18677a.a("IPlatformApiIDLIPC", "moveTaskToDisplay(" + r33 + ", " + r34 + ", " + r35 + ") = " + r14, r10);     // Catch: Exception -> L15 Throwable -> L22
        com.obric.aiagent.ipc.utils.d.f18654a.a("IPlatformApiIDLIPC", "moveTaskToDisplay", r10, r22);     // Catch: Exception -> L15 Throwable -> L22
        return r14;
    L28:
        return r14;
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public List<String> getTasksPackages(int r34, boolean r35, boolean r36, int r37) {
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
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.aiagent.assistant.idl.PlatformApiIDLIpcWrapper.getTasksPackages(int, boolean, boolean, int):java.util.List");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
