package com.bytedance.framwork.core.sdklib.a;

import android.app.Application;
import android.content.Context;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.ss.android.common.util.ToolUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: DiskEnvironmentHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f8579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f8580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static File f8581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static File f8582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static File f8583e;

    public static synchronized File b() {
        monitor-enter(a.class);
        File r1 = a();     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized File c() {
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f8581c != null) goto L12;
        File r1 = new File(b(), "persistent");     // Catch: Throwable -> L15
        if (r1.exists() == true) goto L9;
        r1.mkdirs();     // Catch: Throwable -> L15
    L9:
        f8581c = r1;     // Catch: Throwable -> L15
        if (k.d() == false) goto L12;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "prepare PersistentDirectory success. name=" + f8581c);     // Catch: Throwable -> L15
    L12:
        File r2 = f8581c;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r2;
    }

    public static synchronized File d() {
        monitor-enter(a.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (f8579a == null) goto L23;
    L15:
        File r1 = f8579a;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r1;
    L23:
        File r2 = new File(c(), ToolUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).replace(".", "_").replace(":", "-") + ".bin");     // Catch: Exception -> L13 Throwable -> L18
        if (r2.exists() == true) goto L9;
        r2.createNewFile();     // Catch: Exception -> L13 Throwable -> L18
    L9:
        f8579a = r2;     // Catch: Exception -> L13 Throwable -> L18
        if (k.d() == false) goto L15;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "prepare PersistentFile success. fileName=" + f8579a);     // Catch: Exception -> L13 Throwable -> L18
    L13:
        e = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "prepare PersistentFile fail.", e);     // Catch: Throwable -> L18
        goto L15
    }

    public static synchronized File e() {
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f8580b != null) goto L12;
        File r1 = new File(b(), ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH);     // Catch: Throwable -> L15
        if (r1.exists() == true) goto L9;
        r1.mkdirs();     // Catch: Throwable -> L15
    L9:
        f8580b = r1;     // Catch: Throwable -> L15
        if (k.d() == false) goto L12;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "prepare FlushDirectory success. name=" + f8580b);     // Catch: Throwable -> L15
    L12:
        File r2 = f8580b;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r2;
    }

    public static synchronized File f() {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f8582d != null) goto L10;
        File r1 = new File(b(), "log");     // Catch: Throwable -> L13
        if (r1.exists() == true) goto L9;
        r1.mkdirs();     // Catch: Throwable -> L13
    L9:
        f8582d = r1;     // Catch: Throwable -> L13
    L10:
        File r2 = f8582d;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r2;
    }

    public static synchronized File g() {
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
            java.lang.Class<com.bytedance.framwork.core.sdklib.a.a> r0 = com.bytedance.framwork.core.sdklib.a.a.class
            monitor-enter(r0)
            java.io.File r1 = com.bytedance.framwork.core.sdklib.a.a.f8583e     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            if (r1 != 0) goto L28
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            java.io.File r2 = b()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            java.lang.String r3 = "header"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            if (r2 != 0) goto L1b
            r1.mkdirs()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
        L1b:
            com.bytedance.framwork.core.sdklib.a.a.f8583e = r1     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            goto L28
        L1e:
            r1 = move-exception
            goto L2c
        L20:
            r1 = move-exception
            java.lang.String r2 = "APM-SDK"
            java.lang.String r3 = "header"
            com.bytedance.framwork.core.sdklib.a.c.d.a(r2, r3, r1)     // Catch: java.lang.Throwable -> L1e
        L28:
            java.io.File r1 = com.bytedance.framwork.core.sdklib.a.a.f8583e     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r0)
            return r1
        L2c:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.framwork.core.sdklib.a.a.g():java.io.File");
    }

    public static File h() {
        return new File(b(), "file.lock");
    }

    public static File a() {
        if (com.obric.aiagent.apm.impl.f.f16115a != null) goto L8;
        com.obric.aiagent.apm.impl.f.f16115a = new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir().getParentFile(), "apm6");
        if (com.obric.aiagent.apm.impl.f.f16115a.exists() == true) goto L8;
        com.obric.aiagent.apm.impl.f.f16115a.mkdirs();
    L8:
        return com.obric.aiagent.apm.impl.f.f16115a;
    }
}
