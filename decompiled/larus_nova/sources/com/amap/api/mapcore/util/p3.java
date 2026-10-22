package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes28.dex */
public class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f27825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f27826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile AssetManager f27827c;

    static {
        f27826b = new PolarisFileWrapper("/system/framework/amap.jar").exists();
    }

    private p3() {
    }

    private static AssetManager a(Context r100) {
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
            if (r7 != 0) goto L4
            r7 = 0
            return r7
        L4:
            boolean r0 = com.amap.api.mapcore.util.p3.f27826b
            if (r0 != 0) goto Ld
            android.content.res.AssetManager r7 = r7.getAssets()
            return r7
        Ld:
            android.content.res.AssetManager r0 = com.amap.api.mapcore.util.p3.f27827c
            if (r0 == 0) goto L14
            android.content.res.AssetManager r7 = com.amap.api.mapcore.util.p3.f27827c
            return r7
        L14:
            java.lang.Class<com.amap.api.mapcore.util.p3> r0 = com.amap.api.mapcore.util.p3.class
            monitor-enter(r0)
            android.content.res.AssetManager r1 = com.amap.api.mapcore.util.p3.f27827c     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L1f
            android.content.res.AssetManager r7 = com.amap.api.mapcore.util.p3.f27827c     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4e
            return r7
        L1f:
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch: java.lang.Throwable -> L4e
            java.lang.Class r1 = r7.getClass()     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = "addAssetPath"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L42
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Throwable -> L42
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch: java.lang.Throwable -> L42
            r1.setAccessible(r3)     // Catch: java.lang.Throwable -> L42
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = "/system/framework/amap.jar"
            r2[r6] = r3     // Catch: java.lang.Throwable -> L42
            r1.invoke(r7, r2)     // Catch: java.lang.Throwable -> L42
            goto L4a
        L42:
            r1 = move-exception
            java.lang.String r2 = "MapAssetsResourceLoader"
            java.lang.String r3 = "addAssetPath"
            com.amap.api.mapcore.util.t6.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L4e
        L4a:
            com.amap.api.mapcore.util.p3.f27827c = r7     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4e
            return r7
        L4e:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4e
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.p3.a(android.content.Context):android.content.res.AssetManager");
    }

    public static void a(String r100) {
        if (r100 != null) goto L4;
    L6:
        f27825a = r100;
        return;
    L4:
        if (r100.endsWith(HTTP.URL_DEFAULT) == true) goto L6;
        f27825a = r100.concat(HTTP.URL_DEFAULT);
    }

    private static void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static String[] a(Context r100, String r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        if (f27825a == null) goto L14;
        PolarisFileWrapper r102 = new PolarisFileWrapper(f27825a + r101);
        if (r102.exists() == true) goto L10;
    L13:
        return null;
    L10:
        if (r102.isDirectory() == false) goto L13;
        return r102.list();
    L14:
        AssetManager r103 = a(r100);
        if (r103 != null) goto L22;
        return null;
    L22:
        return r103.list(r101);
    L19:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    public static Bitmap b(Context r100, String r101) {
        ?? r102 = 0;
        if (r101 != null) goto L28;
        return null;
    L28:
        InputStream r103 = f(r100, r101);     // Catch: Throwable -> L14 IOException -> L16
        if (r103 != null) goto L26;
        a(r103);
        return null;
    L26:
        Bitmap r104 = BitmapFactory.decodeStream(r103);     // Catch: IOException -> L12 Throwable -> L21
        a(r103);
        return r104;
    L12:
        e = e;
    L18:
        e.printStackTrace();     // Catch: Throwable -> L21
        a(r103);
        return null;
    L16:
        e = e;
        r103 = null;
    L14:
        th = th;
    L23:
        a(r102);
        throw th;
    L21:
        th = th;
        r102 = r100;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    public static byte[] c(Context r100, String r101) {
        ?? r102 = 0;
        if (r101 != null) goto L42;
        return null;
    L42:
        InputStream r103 = f(r100, r101);     // Catch: Throwable -> L23 OutOfMemoryError -> L25 IOException -> L30
        if (r103 != null) goto L40;
        a(r103);
        return null;
    L40:
        int r104 = r103.available();     // Catch: OutOfMemoryError -> L19 IOException -> L21 Throwable -> L35
        if (r104 != 0) goto L13;
        a(r103);
        return null;
    L13:
        byte[] r105 = new byte[r104];     // Catch: OutOfMemoryError -> L19 IOException -> L21 Throwable -> L35
        int r106 = 0;
    L14:
        if (r106 >= r104) goto L17;
        r106 = r106 + r103.read(r105, r106, r104 - r106);
        goto L14
    L17:
        a(r103);
        return r105;
    L21:
        e = e;
    L32:
        e.printStackTrace();     // Catch: Throwable -> L35
        a(r103);
        return null;
    L19:
        e = e;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L35
        a(r103);
        return null;
    L30:
        e = e;
        r103 = null;
    L25:
        e = e;
        r103 = null;
    L23:
        th = th;
    L37:
        a(r102);
        throw th;
    L35:
        th = th;
        r102 = r100;
        goto L37
    }

    public static InputStream d(Context r100, String r101) {
        if (r101 != null) goto L10;
        return null;
    L10:
        return f(r100, r101);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String e(Context r100, String r101) {
        BufferedReader r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        InputStream r103 = d(r100, r101);
        if (r103 != null) goto L8;
        return null;
    L8:
        StringBuilder r104 = new StringBuilder();
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r103, "UTF-8"));     // Catch: Throwable -> L18 IOException -> L20
    L29:
        String r106 = r105.readLine();     // Catch: IOException -> L16 Throwable -> L25
        if (r106 == null) goto L13;
        r104.append(r106);     // Catch: IOException -> L16 Throwable -> L25
        r104.append('\n');     // Catch: IOException -> L16 Throwable -> L25
        goto L29
    L13:
        String r107 = r104.toString();     // Catch: IOException -> L16 Throwable -> L25
        a(r105);
        a(r103);
        return r107;
    L16:
        e = e;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L25
        a(r105);
        a(r103);
        return null;
    L25:
        th = th;
        r102 = r105;
    L27:
        a(r102);
        a(r103);
        throw th;
    L20:
        e = e;
        r105 = null;
    L18:
        th = th;
        goto L27
    }

    private static InputStream f(Context r100, String r101) throws IOException {
        if (f27825a != null) goto L5;
        AssetManager r102 = a(r100);
        if (r102 == null) goto L11;
        return r102.open(r101);
    L11:
        throw new IOException("AssetManager not available");
    L5:
        return new PolarisFileInputStreamWrapper(f27825a + r101);
    }

    public static byte[] a(Context r100, String r101, String r102) {
        if (r102 != null) goto L5;
        return null;
    L5:
        int r103 = 0;
        if (f27825a == null) goto L23;
        PolarisFileWrapper r104 = new PolarisFileWrapper(f27825a + r101);
        if (r104.exists() == true) goto L10;
    L22:
        return null;
    L10:
        if (r104.isDirectory() == false) goto L22;
        String[] r105 = r104.list();
        if (r105 == null) goto L22;
        int r106 = r105.length;
    L14:
        if (r103 >= r106) goto L22;
        String r107 = r105[r103];
        if (r107 == null) goto L21;
        if (r107.contains(r102) == false) goto L21;
        return c(r100, r101 + HTTP.URL_DEFAULT + r107);
    L21:
        r103 = r103 + 1;
        goto L14
    L23:
        AssetManager r108 = a(r100);
        if (r108 != null) goto L41;
        return null;
    L41:
        String[] r109 = r108.list(r101);     // Catch: IOException -> L38
        if (r109 != null) goto L29;
        return null;
    L29:
        int r110 = r109.length;     // Catch: IOException -> L38
    L30:
        if (r103 >= r110) goto L40;
        String r111 = r109[r103];     // Catch: IOException -> L38
        if (r111 == null) goto L37;
        if (r111.contains(r102) == false) goto L37;
        return c(r100, r101 + HTTP.URL_DEFAULT + r111);
    L37:
        r103 = r103 + 1;
    L40:
        return null;
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    }
}
