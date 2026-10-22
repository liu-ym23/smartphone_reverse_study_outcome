package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
class p {
    private static final String TAG = "TypefaceCompatBaseImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Long, androidx.core.content.b.e.c> f1236a;

    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    private interface a<T> {
        boolean a(T r1);

        int b(T r1);
    }

    p() {
        this.f1236a = new ConcurrentHashMap();
    }

    private static <T> T a(T[] r2, int r3, a<T> r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) != 0) goto L5;
        int r0 = 400;
    L7:
        if ((r3 & 2) == 0) goto L9;
        boolean r6 = true;
    L11:
        return (T) a(r2, r0, r6, r5);
    L9:
        r6 = false;
        goto L11
    L5:
        r0 = 700;
        goto L7
    }

    private static <T> T a(T[] r8, int r9, boolean r10, a<T> r11) {
        a r12 = (a) ZeusTransformUtils.wrapperContextForParams(r11, a.class, "com.obric.aiagent.plugin");
        int r0 = r8.length;
        T r2 = null;
        int r3 = Integer.MAX_VALUE;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L13;
        T r5 = r8[r4];
        int r6 = Math.abs(r12.b(r5) - r9) * 2;
        if (r12.a(r5) != r10) goto L7;
        int r7 = 0;
    L8:
        int r13 = r6 + r7;
        if (r2 == null) goto L11;
        if (r3 > r13) goto L11;
    L12:
        r4 = r4 + 1;
    L11:
        r2 = r5;
        r3 = r13;
        goto L12
    L7:
        r7 = 1;
        goto L8
    L13:
        return r2;
    }

    private static long b(Typeface r6) {
        if (r6 != null) goto L13;
        return 0;
    L13:
        Field r4 = Typeface.class.getDeclaredField("native_instance");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        r4.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        return ((Number) ZeusTransformUtils.preCheckCast(r4.get(r6), Number.class, "com.obric.aiagent.plugin")).longValue();
    L7:
        e = move-exception;
        c(TAG, "Could not retrieve font from family.", e);
        return 0;
    L10:
        e = move-exception;
        c(TAG, "Could not retrieve font from family.", e);
        return 0;
    }

    public FontsContractCompat.b a(FontsContractCompat.b[] r2, int r3) {
        return (FontsContractCompat.b) ZeusTransformUtils.preCheckCast(a(r2, r3, new AnonymousClass1(this)), FontsContractCompat.b.class, "com.obric.aiagent.plugin");
    }

    public Typeface a(Context r2, InputStream r3) {
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
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            java.lang.String r0 = "com.obric.aiagent.plugin"
            java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.wrapperContextForParams(r2, r1, r0)
            android.content.Context r1 = (android.content.Context) r1
            java.io.File r1 = androidx.core.graphics.q.a(r1)
            r2 = 0
            if (r1 != 0) goto L12
            return r2
        L12:
            boolean r3 = androidx.core.graphics.q.a(r1, r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            if (r3 != 0) goto L1c
            r1.delete()
            return r2
        L1c:
            java.lang.String r3 = r1.getPath()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            android.graphics.Typeface r2 = android.graphics.Typeface.createFromFile(r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            r1.delete()
            return r2
        L28:
            r2 = move-exception
            r1.delete()
            throw r2
        L2d:
            r1.delete()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.p.a(android.content.Context, java.io.InputStream):android.graphics.Typeface");
    }

    public Typeface a(Context r3, CancellationSignal r4, FontsContractCompat.b[] r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        InputStream r0 = null;
        if (r5.length >= 1) goto L21;
        return null;
    L21:
        InputStream r8 = r7.getContentResolver().openInputStream(a(r5, r6).a());     // Catch: Throwable -> L12 IOException -> L15
        Typeface r2 = a(r7, r8);     // Catch: Throwable -> L10 IOException -> L18
        q.a(r8);
        return r2;
    L10:
        th = th;
        r0 = r8;
    L13:
        q.a(r0);
        throw th;
    L16:
        q.a(r8);
        return null;
    L15:
        r8 = null;
    L12:
        th = th;
        goto L13
    }

    private androidx.core.content.b.e.d a(androidx.core.content.b.e.c r2, int r3) {
        return (androidx.core.content.b.e.d) ZeusTransformUtils.preCheckCast(a(r2.a(), r3, new AnonymousClass2(this)), androidx.core.content.b.e.d.class, "com.obric.aiagent.plugin");
    }

    public Typeface a(Context r7, androidx.core.content.b.e.c r8, Resources r9, int r10) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        androidx.core.content.b.e.d r11 = a(r8, r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        Typeface r12 = j.a(r0, r9, r11.f(), r11.a(), 0, r10);
        a(r12, r8);
        return r12;
    }

    public Typeface a(Context r1, Resources r2, int r3, String r4, int r5) {
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
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            java.lang.String r4 = "com.obric.aiagent.plugin"
            java.lang.Object r0 = com.volcengine.zeus.transform.ZeusTransformUtils.wrapperContextForParams(r1, r0, r4)
            android.content.Context r0 = (android.content.Context) r0
            java.io.File r0 = androidx.core.graphics.q.a(r0)
            r1 = 0
            if (r0 != 0) goto L12
            return r1
        L12:
            boolean r2 = androidx.core.graphics.q.a(r0, r2, r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            if (r2 != 0) goto L1c
            r0.delete()
            return r1
        L1c:
            java.lang.String r2 = r0.getPath()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            android.graphics.Typeface r1 = android.graphics.Typeface.createFromFile(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2d
            r0.delete()
            return r1
        L28:
            r1 = move-exception
            r0.delete()
            throw r1
        L2d:
            r0.delete()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.p.a(android.content.Context, android.content.res.Resources, int, java.lang.String, int):android.graphics.Typeface");
    }

    androidx.core.content.b.e.c a(Typeface r5) {
        long r0 = b(r5);
        if (r0 != 0) goto L7;
        return null;
    L7:
        return (androidx.core.content.b.e.c) ZeusTransformUtils.preCheckCast(this.f1236a.get(Long.valueOf(r0)), androidx.core.content.b.e.c.class, "com.obric.aiagent.plugin");
    }

    private void a(Typeface r5, androidx.core.content.b.e.c r6) {
        long r0 = b(r5);
        if (r0 == 0) goto L6;
        this.f1236a.put(Long.valueOf(r0), r6);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
