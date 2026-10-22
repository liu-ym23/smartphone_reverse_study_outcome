package by5;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PolarisFileWrapper f21394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PolarisFileWrapper f21395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PolarisFileWrapper f21396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PolarisFileWrapper f21397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static PolarisFileWrapper f21398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static PolarisFileWrapper f21399f;

    public static synchronized File b() {
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
            java.lang.Class<by5.a> r0 = by5.a.class
            monitor-enter(r0)
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r1 = by5.a.f21399f     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            if (r1 != 0) goto L26
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r1 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            java.io.File r2 = f()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            java.lang.String r3 = "header"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            if (r2 != 0) goto L1b
            r1.mkdirs()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
        L1b:
            by5.a.f21399f = r1     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            goto L26
        L1e:
            r1 = move-exception
            goto L2a
        L20:
            r1 = move-exception
            java.lang.String r2 = "header"
            fy5.c.c(r2, r1)     // Catch: java.lang.Throwable -> L1e
        L26:
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r1 = by5.a.f21399f     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r0)
            return r1
        L2a:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: by5.a.b():java.io.File");
    }

    public static synchronized File c() {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f21398e != null) goto L10;
        PolarisFileWrapper r100 = new PolarisFileWrapper(f(), "log");     // Catch: Throwable -> L13
        if (r100.exists() == true) goto L9;
        r100.mkdirs();     // Catch: Throwable -> L13
    L9:
        f21398e = r100;     // Catch: Throwable -> L13
    L10:
        PolarisFileWrapper r101 = f21398e;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r101;
    }

    public static synchronized File f() {
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f21397d != null) goto L9;
        PolarisFileWrapper r100 = new PolarisFileWrapper(n.getContext().getFilesDir(), "apm6_sdk");     // Catch: Throwable -> L12
        f21397d = r100;     // Catch: Throwable -> L12
        if (r100.exists() == true) goto L9;
        f21397d.mkdirs();     // Catch: Throwable -> L12
    L9:
        PolarisFileWrapper r101 = f21397d;     // Catch: Throwable -> L12
        monitor-exit(a.class);
        return r101;
    }

    public static synchronized File a() {
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f21395b != null) goto L12;
        PolarisFileWrapper r100 = new PolarisFileWrapper(f(), "flush");     // Catch: Throwable -> L15
        if (r100.exists() == true) goto L9;
        r100.mkdirs();     // Catch: Throwable -> L15
    L9:
        f21395b = r100;     // Catch: Throwable -> L15
        if (n.f21462e == false) goto L12;
        fy5.c.a("prepare FlushDirectory success. name=" + f21395b);     // Catch: Throwable -> L15
    L12:
        PolarisFileWrapper r101 = f21395b;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r101;
    }

    public static synchronized File d() {
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f21396c != null) goto L12;
        PolarisFileWrapper r100 = new PolarisFileWrapper(f(), "persistent");     // Catch: Throwable -> L15
        if (r100.exists() == true) goto L9;
        r100.mkdirs();     // Catch: Throwable -> L15
    L9:
        f21396c = r100;     // Catch: Throwable -> L15
        if (n.f21462e == false) goto L12;
        fy5.c.a("prepare PersistentDirectory success. name=" + f21396c);     // Catch: Throwable -> L15
    L12:
        PolarisFileWrapper r101 = f21396c;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r101;
    }

    public static synchronized File e() {
        monitor-enter(a.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (f21394a == null) goto L21;
    L15:
        PolarisFileWrapper r100 = f21394a;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r100;
    L21:
        PolarisFileWrapper r101 = new PolarisFileWrapper(d(), ita.k.c(n.getContext()).replace(".", "_").replace(":", "-") + ".bin");     // Catch: Exception -> L13 Throwable -> L18
        if (r101.exists() == true) goto L9;
        r101.createNewFile();     // Catch: Exception -> L13 Throwable -> L18
    L9:
        f21394a = r101;     // Catch: Exception -> L13 Throwable -> L18
        if (n.f21462e == false) goto L15;
        fy5.c.a("prepare PersistentFile success. fileName=" + f21394a);     // Catch: Exception -> L13 Throwable -> L18
    L13:
        e = move-exception;
        fy5.c.c("prepare PersistentFile fail.", e);     // Catch: Throwable -> L18
        goto L15
    }
}
