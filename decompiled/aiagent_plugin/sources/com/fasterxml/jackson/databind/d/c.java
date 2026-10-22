package com.fasterxml.jackson.databind.d;

import com.fasterxml.jackson.databind.aa;
import com.fasterxml.jackson.databind.b.q;
import com.fasterxml.jackson.databind.g;
import com.fasterxml.jackson.databind.j.b.k;
import com.fasterxml.jackson.databind.j.s;
import com.fasterxml.jackson.databind.l;
import com.fasterxml.jackson.databind.l.h;
import com.fasterxml.jackson.databind.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: OptionalHandlerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f12565b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class<?> f12566c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f12567d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, String> f12568e;
    private final Map<String, Object> f;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0007
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:143)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    static {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
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
            r0 = 0
            java.lang.Class<org.w3c.dom.Node> r1 = org.w3c.dom.Node.class
            java.lang.Class<org.w3c.dom.Document> r2 = org.w3c.dom.Document.class
            goto L8
        L6:
            r1 = r0
        L7:
            r2 = r0
        L8:
            com.fasterxml.jackson.databind.d.c.f12565b = r1
            com.fasterxml.jackson.databind.d.c.f12566c = r2
            com.fasterxml.jackson.databind.d.a r0 = com.fasterxml.jackson.databind.d.a.a()     // Catch: java.lang.Throwable -> L10
        L10:
            com.fasterxml.jackson.databind.d.c.f12567d = r0
            com.fasterxml.jackson.databind.d.c r0 = new com.fasterxml.jackson.databind.d.c
            r0.<init>()
            com.fasterxml.jackson.databind.d.c.f12564a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.d.c.<clinit>():void");
    }

    public c() {
        HashMap r0 = new HashMap();
        this.f12568e = r0;
        r0.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        r0.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap r1 = new HashMap();
        this.f = r1;
        r1.put("java.sql.Timestamp", k.f12901a);
        r1.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        r1.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        r1.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        r1.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    public p<?> a(aa r6, com.fasterxml.jackson.databind.k r7, com.fasterxml.jackson.databind.c r8) {
        Class<?> r0 = r7.e();
        if (a(r0, f12565b) == true) goto L5;
        a r1 = f12567d;
        if (r1 == null) goto L11;
        p<?> r2 = r1.b(r0);
        if (r2 == null) goto L11;
        return r2;
    L11:
        String r3 = r0.getName();
        Object r4 = this.f.get(r3);
        if (r4 == null) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, p.class) == false) goto L18;
        return (p) ZeusTransformUtils.preCheckCast(r4, p.class, "com.obric.aiagent.plugin");
    L18:
        return (p) ZeusTransformUtils.preCheckCast(a((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), r7), p.class, "com.obric.aiagent.plugin");
    L20:
        if (r3.startsWith("javax.xml.") == false) goto L22;
    L25:
        Object r5 = a("com.fasterxml.jackson.databind.ext.CoreXMLSerializers", r7);
        if (r5 != null) goto L29;
        return null;
    L29:
        return ((s) ZeusTransformUtils.preCheckCast(r5, s.class, "com.obric.aiagent.plugin")).a(r6, r7, r8);
    L22:
        if (a(r0, "javax.xml.") == true) goto L25;
        return null;
    L5:
        return (p) ZeusTransformUtils.preCheckCast(a("com.fasterxml.jackson.databind.ext.DOMSerializer", r7), p.class, "com.obric.aiagent.plugin");
    }

    public l<?> a(com.fasterxml.jackson.databind.k r6, g r7, com.fasterxml.jackson.databind.c r8) {
        Class<?> r0 = r6.e();
        a r1 = f12567d;
        if (r1 == null) goto L8;
        l<?> r2 = r1.a(r0);
        if (r2 == null) goto L8;
        return r2;
    L8:
        if (a(r0, f12565b) == false) goto L12;
        return (l) ZeusTransformUtils.preCheckCast(a("com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer", r6), l.class, "com.obric.aiagent.plugin");
    L12:
        if (a(r0, f12566c) == true) goto L14;
        String r3 = r0.getName();
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.f12568e.get(r3), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L20;
        return (l) ZeusTransformUtils.preCheckCast(a(r4, r6), l.class, "com.obric.aiagent.plugin");
    L20:
        if (r3.startsWith("javax.xml.") == false) goto L22;
    L25:
        Object r5 = a("com.fasterxml.jackson.databind.ext.CoreXMLDeserializers", r6);
        if (r5 != null) goto L29;
        return null;
    L29:
        return ((q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.aiagent.plugin")).a(r6, r7, r8);
    L22:
        if (a(r0, "javax.xml.") == true) goto L25;
        return null;
    L14:
        return (l) ZeusTransformUtils.preCheckCast(a("com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer", r6), l.class, "com.obric.aiagent.plugin");
    }

    private boolean a(Class<?> r1, Class<?> r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (r2.isAssignableFrom(r1) == false) goto L6;
        return true;
    }

    private Object a(String r4, com.fasterxml.jackson.databind.k r5) {
        return a(ZeusTransformUtils.forName(r4, "com.obric.aiagent.plugin"), r5);
    L4:
        th = move-exception;
        throw new IllegalStateException("Failed to find class `" + r4 + "` for handling values of type " + h.b(r5) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
    }

    private Object a(Class<?> r4, com.fasterxml.jackson.databind.k r5) {
        return h.b(r4, false);
    L5:
        th = move-exception;
        throw new IllegalStateException("Failed to create instance of `" + r4.getName() + "` for handling values of type " + h.b(r5) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
    }

    private boolean a(Class<?> r2, String r3) {
        Class<? super Object> r1 = r2.getSuperclass();
    L4:
        if (r1 == null) goto L13;
        if (r1 == Object.class) goto L7;
        if (r1.getName().startsWith(r3) == true) goto L10;
        r1 = r1.getSuperclass();
        goto L4
    L10:
        return true;
    L7:
        return false;
    L13:
        return false;
    }
}
