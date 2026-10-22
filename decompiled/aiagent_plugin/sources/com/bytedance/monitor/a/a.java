package com.bytedance.monitor.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: ActivityThreadUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class f8871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f8872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Object f8873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f8874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Set<Integer> f8875e;
    private static Class f;

    public a() {
    }

    static /* synthetic */ Object a(Object r0) {
        f8873c = r0;
        return r0;
    }

    static /* synthetic */ Class f() {
        return f;
    }

    static {
        HashSet r0 = new HashSet();
        f8875e = r0;
        r0.add(113);
        f8875e.add(114);
        f8875e.add(115);
        f8875e.add(116);
        f8875e.add(121);
        f8875e.add(122);
        f8875e.add(100);
        f8875e.add(159);
        f8875e.add(123);
    }

    public static boolean a(Message r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (f8875e.contains(Integer.valueOf(r2.what)) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static synchronized Class a() {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f8871a == null) goto L16;
    L10:
        Class r1 = f8871a;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r1;
    L16:
        f8871a = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static synchronized Field b() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f8872b != null) goto L7;
        f8872b = b.a(a(), "mH");     // Catch: Throwable -> L10
    L7:
        Field r1 = f8872b;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r1;
    }

    public static synchronized Object c() {
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
            java.lang.Class<com.bytedance.monitor.a.a> r0 = com.bytedance.monitor.a.a.class
            monitor-enter(r0)
            java.lang.Object r1 = com.bytedance.monitor.a.a.f8873c     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            if (r1 != 0) goto L16
            java.lang.Class r1 = a()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            java.lang.String r2 = "currentActivityThread"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            java.lang.Object r1 = com.bytedance.monitor.a.f.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            com.bytedance.monitor.a.a.f8873c = r1     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
        L16:
            java.lang.Object r1 = com.bytedance.monitor.a.a.f8873c     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            monitor-exit(r0)
            return r1
        L1a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L1d:
            r1 = 0
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.monitor.a.a.c():java.lang.Object");
    }

    public static synchronized Object d() {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f8874d == null) goto L16;
    L10:
        Object r1 = f8874d;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r1;
    L16:
        f8874d = b().get(c());     // Catch: IllegalAccessException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static Object e() {
        if (f8873c != null) goto L36;
        monitor-enter(a.class);     // Catch: Exception -> L33
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L33
    L7:
        if (f8873c != null) goto L13;
        if (f != null) goto L11;
        f = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
    L11:
        f8873c = f.a(f, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L30
    L13:
        if (f8873c == null) goto L15;
    L28:
        monitor-exit(a.class);     // Catch: Throwable -> L30
        goto L36
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L28;
        final Object r1 = new Object();     // Catch: Throwable -> L30
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r1));     // Catch: Throwable -> L30
        if (f8873c != null) goto L28;
        monitor-enter(r1);     // Catch: Throwable -> L30
        r1.wait(5000);     // Catch: Throwable -> L22 InterruptedException -> L37
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L22
    L33:
        e = move-exception;
        e.printStackTrace();
    L36:
        return f8873c;
    }
}
