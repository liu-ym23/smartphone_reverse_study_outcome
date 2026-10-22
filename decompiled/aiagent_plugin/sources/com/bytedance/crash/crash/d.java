package com.bytedance.crash.crash;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.ad;
import com.bytedance.crash.ah;
import com.bytedance.crash.dumper.a.j;
import com.bytedance.crash.i;
import com.bytedance.crash.monitor.h;
import com.bytedance.crash.o.r;
import com.bytedance.crash.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: JavaCrashHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f7323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f7324e;
    private static volatile boolean f;
    private static final ArrayList<com.bytedance.crash.f.a> g = null;
    private static boolean h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f7325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f7326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f7327c;

    static {
        g = new ArrayList();
    }

    public static void a(boolean r0) {
        f7323d = r0;
    }

    public static void b(boolean r0) {
        f7324e = r0;
    }

    public static void c(boolean r0) {
        f = r0;
    }

    d(a r3) {
        this.f7326b = new AtomicBoolean(false);
        this.f7327c = r3;
        this.f7325a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private boolean a(Thread r18, Throwable r19) {
        boolean r10 = true;
        i.a(true);
        com.bytedance.crash.monitor.a r1 = h.a();
        if (r1 != null) goto L5;
    L11:
        long r12 = System.currentTimeMillis();
        File r14 = this.f7327c.a();
        com.bytedance.crash.o.i.b(r14);
        boolean r6 = a(r12);
        if (r6 == false) goto L14;
        CrashType r2 = CrashType.LAUNCH;
    L15:
        CrashType r15 = r2;
        boolean r16 = a(r19);
        if (h == true) goto L19;
        e.a(r14, r18, r19, r12, r6, r16);
        j.a(r14, r19);
        r.c("NPTH", r19 + " has been detected!");
        r.c("NPTH", "handleException：" + r14);
        this.f7327c.b();
        a(r15, r12);
        this.f7327c.a(r15, r12, f7324e, f);
    L19:
        if ((a(r19, r18) & 1) != 0) goto L22;
        r10 = false;
    L22:
        if (r10 == true) goto L27;
    L24:
        a(r18, r19, r14, r15, r12, r16);
        return r10;
    L27:
        new File(r14, "ignore").createNewFile();     // Catch: Throwable -> L26
        goto L24
    L14:
        r2 = CrashType.JAVA;
        goto L15
    L5:
        if (r1.n().a(r18, r19) == false) goto L11;
        if ((a(r19, r18) & 1) == 0) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r4, Throwable r5) {
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
            this = this;
            monitor-enter(r3)
            r0 = 0
            java.util.concurrent.atomic.AtomicBoolean r1 = r3.f7326b     // Catch: java.lang.Throwable -> L10
            r2 = 1
            boolean r1 = r1.compareAndSet(r0, r2)     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto L14
            boolean r0 = r3.a(r4, r5)     // Catch: java.lang.Throwable -> L10
            goto L14
        L10:
            r1 = move-exception
            com.bytedance.crash.o.r.b(r1)     // Catch: java.lang.Throwable -> L21
        L14:
            if (r0 != 0) goto L1c
            java.lang.Thread$UncaughtExceptionHandler r0 = r3.f7325a     // Catch: java.lang.Throwable -> L21
            r0.uncaughtException(r4, r5)     // Catch: java.lang.Throwable -> L21
            goto L1f
        L1c:
            b(r5, r4)     // Catch: java.lang.Throwable -> L21
        L1f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L21
            return
        L21:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L21
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.crash.crash.d.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }

    private static int a(Throwable r5, Thread r6) {
        int r0 = 0;
        int r1 = 0;
    L3:
        ArrayList<com.bytedance.crash.f.a> r2 = g;
        if (r0 >= r2.size()) goto L9;
        r1 = r1 | ((com.bytedance.crash.f.a) ZeusTransformUtils.preCheckCast(r2.get(r0), com.bytedance.crash.f.a.class, "com.obric.aiagent.plugin")).a(r5, r6);
    L8:
        r0 = r0 + 1;
    L9:
        return r1;
    }

    public static boolean a(Throwable r2) {
        int r0 = 20;
    L3:
        if (r2 == null) goto L20;
        int r1 = r0 - 1;
        if (r0 <= 0) goto L21;
        if (ZeusTransformUtils.instanceOf(r2, OutOfMemoryError.class) == true) goto L8;
        r2 = r2.getCause();     // Catch: Throwable -> L14
        r0 = r1;
        goto L3
    L8:
        return true;
    L12:
        return false;
    L21:
        return false;
    L20:
        return false;
    }

    private static boolean b(Throwable r2) {
    L2:
        if (r2 == null) goto L27;
        if (ZeusTransformUtils.instanceOf(r2, OutOfMemoryError.class) == false) goto L13;
        String r0 = r2.getMessage();     // Catch: Throwable -> L17
        if (r0 == null) goto L13;
        if (r0.contains("allocate") == true) goto L11;
        if (r0.contains("thrown") == false) goto L13;
        return true;
    L11:
        return true;
    L13:
        r2 = r2.getCause();     // Catch: Throwable -> L17
    L15:
        return false;
    L27:
        return false;
    }

    public static boolean a(long r2) {
        if ((r2 - i.f()) <= com.bytedance.crash.config.h.b()) goto L5;
    L9:
        return false;
    L5:
        if (ad.h() == true) goto L7;
    L8:
        return true;
    L7:
        if (ad.i() == 0) goto L9;
        goto L8
    }

    private void a(Thread r14, Throwable r15, File r16, CrashType r17, long r18, boolean r20) {
        String r10 = j.a(r16);
        boolean r11 = b(r15);
        Iterator<com.bytedance.crash.monitor.d> r12 = h.d().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        a((com.bytedance.crash.monitor.d) ZeusTransformUtils.preCheckCast(r12.next(), com.bytedance.crash.monitor.d.class, "com.obric.aiagent.plugin"), r20, r11, r17, r15, r14, r10, r18);
        goto L4
    }

    private void a(com.bytedance.crash.monitor.d r7, boolean r8, boolean r9, CrashType r10, Throwable r11, Thread r12, String r13, long r14) {
        if (r7 != null) goto L4;
        return;
    L4:
        ah r6 = r7.n();
        List<IOOMCallback> r15 = null;
        if (r8 == true) goto L7;
        if (r9 == true) goto L7;
    L9:
        if (r15 == null) goto L16;
        Iterator<IOOMCallback> r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L16;
        ((IOOMCallback) ZeusTransformUtils.preCheckCast(r16.next(), IOOMCallback.class, "com.obric.aiagent.plugin")).onCrash(r10, r11, r12, r14);     // Catch: Throwable -> L25
    L16:
        List<ICrashCallback> r17 = r6.c(r10);
        if (r17 == null) goto L24;
        Iterator<ICrashCallback> r18 = r17.iterator();
    L20:
        if (r18.hasNext() == false) goto L37;
        ((ICrashCallback) ZeusTransformUtils.preCheckCast(r18.next(), ICrashCallback.class, "com.obric.aiagent.plugin")).onCrash(r10, r13, r12);     // Catch: Throwable -> L26
        goto L20
    L37:
        return;
    L24:
        return;
    L7:
        r15 = r6.f();
        goto L9
    }

    public static void a(com.bytedance.crash.f.a r1) {
        g.add(r1);
    }

    private static void b(Throwable r4, Thread r5) {
        int r0 = 0;
    L3:
        ArrayList<com.bytedance.crash.f.a> r1 = g;
        if (r0 >= r1.size()) goto L17;
        ((com.bytedance.crash.f.a) ZeusTransformUtils.preCheckCast(r1.get(r0), com.bytedance.crash.f.a.class, "com.obric.aiagent.plugin")).b(r4, r5);     // Catch: Throwable -> L9
    L7:
        r0 = r0 + 1;
    L8:
        return;
    }

    public static void d(boolean r0) {
        h = r0;
    }

    private void a(CrashType r4, long r5) {
        com.bytedance.crash.monitor.a r3 = h.a();     // Catch: Throwable -> L13
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<t> r6 = r3.n().e(r4).iterator();     // Catch: Throwable -> L13
    L7:
        if (r6.hasNext() == false) goto L21;
        ((t) ZeusTransformUtils.preCheckCast(r6.next(), t.class, "com.obric.aiagent.plugin")).a(r4, r5);     // Catch: Throwable -> L12
        goto L7
    L21:
        return;
    }
}
