package com.amap.api.col.s;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes28.dex */
public final class cx extends cs {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static cx f26519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f26520d;

    public static class a extends Handler {
        public a() {
        }

        private a(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        public /* synthetic */ a(Looper r100, byte r101) {
            this(r100);
        }
    }

    private static synchronized cx c() {
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
            java.lang.Class<com.amap.api.col.s.cx> r0 = com.amap.api.col.s.cx.class
            monitor-enter(r0)
            com.amap.api.col.s.cx r1 = com.amap.api.col.s.cx.f26519c     // Catch: java.lang.Throwable -> Lf
            if (r1 != 0) goto L13
            com.amap.api.col.s.cx r1 = new com.amap.api.col.s.cx     // Catch: java.lang.Throwable -> Lf
            r1.<init>()     // Catch: java.lang.Throwable -> Lf
            com.amap.api.col.s.cx.f26519c = r1     // Catch: java.lang.Throwable -> Lf
            goto L13
        Lf:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L24
        L13:
            com.amap.api.col.s.bm$a r1 = com.amap.api.col.s.bm.c()     // Catch: java.lang.Throwable -> L20
            if (r1 != 0) goto L20
            com.amap.api.col.s.bm$a r1 = com.amap.api.col.s.bx.a()     // Catch: java.lang.Throwable -> L20
            com.amap.api.col.s.bm.a(r1)     // Catch: java.lang.Throwable -> L20
        L20:
            com.amap.api.col.s.cx r1 = com.amap.api.col.s.cx.f26519c     // Catch: java.lang.Throwable -> L24
            monitor-exit(r0)
            return r1
        L24:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.cx.c():com.amap.api.col.s.cx");
    }

    private cx() {
    L9:
        th = move-exception;
        cg.c(th, "NetManger", "NetManger1");
        th.printStackTrace();
        return;
    L4:
        if (Looper.myLooper() != null) goto L7;
        this.f26520d = new a(Looper.getMainLooper(), 0);     // Catch: Throwable -> L9
        return;
    L7:
        this.f26520d = new a();     // Catch: Throwable -> L9
    }

    public static cx b() {
        return c();
    }

    public static byte[] d(cy r100) throws bh {
        cz r101 = b(r100, false);     // Catch: Throwable -> L9 bh -> L11
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.f26524a;
    L11:
        e = move-exception;
        throw e;
    L10:
        throw new bh("未知的错误");
    }

    public static byte[] e(cy r100) throws bh {
        cz r101 = b(r100, true);     // Catch: Throwable -> L9 bh -> L11
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.f26524a;
    L11:
        e = move-exception;
        throw e;
    L10:
        throw new bh("未知的错误");
    }

    @Override // com.amap.api.col.s.cs
    public final byte[] b(cy r100) throws bh {
        cz r101 = cs.a(r100, false);     // Catch: Throwable -> L9 bh -> L12
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.f26524a;
    L12:
        e = move-exception;
        throw e;
    L9:
        th = move-exception;
        th.printStackTrace();
        cg.d().b(th, "NetManager", "makeSyncPostRequest");
        throw new bh("未知的错误");
    }

    private static cz b(cy r100, boolean r101) throws bh {
        int r102 = cv.a(r100);
        cz r103 = a(r100, r101, r102);     // Catch: bh -> L5
    L9:
        if (r103 == null) goto L15;
        byte[] r104 = r103.f26524a;
        if (r104 == null) goto L15;
        if (r104.length <= 0) goto L15;
    L21:
        return r103;
    L15:
        if (cv.a(r102) == false) goto L21;
        return a(r100, r101, 3);
    L19:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        if (cv.a(r102) == false) goto L22;
        r103 = null;
        goto L9
    L22:
        throw e;
    }

    private static cz a(cy r100, boolean r101, int r110) throws bh {
        cs.c(r100);     // Catch: Throwable -> L4 bh -> L7
        return new cv(r100, r101).a(r100.h(), r100.n(), r100.o(), r100.j(), r100.f(), r100.e(), r110);
    L7:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw new bh("未知的错误");
    }
}
