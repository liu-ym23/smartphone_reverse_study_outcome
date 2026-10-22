package com.amap.api.mapcore.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class o6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile n6 f27766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f27767b = null;

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            com_amap_api_mapcore_util_o6$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public final void com_amap_api_mapcore_util_o6$a__run$___twin___() {
            monitor-enter(o6.class);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (o6.b() == null) goto L17;
        L10:
            monitor-exit(o6.class);     // Catch: Throwable -> L12
            return;
        L17:
            o6.a(o6.c());     // Catch: Exception -> L8 Throwable -> L12
        L8:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L12
            goto L10
        }

        public a() {
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_mapcore_util_o6$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_mapcore_util_o6$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f27767b = new AtomicBoolean(false);
    }

    public static n6 a() {
        if (f27766a != null) goto L8;
        if (f27767b.compareAndSet(false, true) == false) goto L8;
        ThreadMethodProxy.start(new PthreadThreadV2(new a(), "RI"));
    L8:
        return f27766a;
    }

    public static /* synthetic */ n6 c() {
        n6 r100 = a(Build.MANUFACTURER);
        if ("".equals(r100.a()) == true) goto L5;
        return r100;
    L5:
        Iterator r101 = Arrays.asList(new String[]{n6.f27677f.a(), n6.f27678g.a(), n6.f27679h.a(), n6.f27680i.a(), n6.f27681j.a(), n6.f27682k.a(), n6.f27683l.a(), n6.f27685n.a(), n6.f27686o.a(), n6.f27687p.a(), n6.f27688q.a()}).iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        n6 r102 = a((String) r101.next());
        if ("".equals(r102.a()) == true) goto L7;
        return r102;
    L12:
        return n6.f27689r;
    }

    private o6() {
    }

    public static /* synthetic */ n6 b() {
        return f27766a;
    }

    private static n6 a(String r100) {
        if (r100 == null) goto L110;
        if (r100.length() <= 0) goto L110;
        n6 r101 = n6.f27677f;
        boolean r102 = true;
        if (r100.equalsIgnoreCase(r101.a()) == true) goto L9;
        n6 r103 = n6.f27678g;
        if (r100.equalsIgnoreCase(r103.a()) == false) goto L25;
        String r104 = b("ro.flyme.published");
        String r105 = b("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(r104) == true) goto L19;
    L22:
        String r106 = b("ro.build.display.id");
        a(r103, r106);
        r103.b(r106);
    L23:
        if (r102 == false) goto L108;
        return r103;
    L108:
        return n6.f27689r;
    L19:
        if (TextUtils.isEmpty(r105) == false) goto L22;
        r102 = false;
        goto L23
    L25:
        n6 r107 = n6.f27679h;
        if (r100.equalsIgnoreCase(r107.a()) == false) goto L33;
        String r108 = b(com.alipay.sdk.m.c.a.f25238a);
        if (TextUtils.isEmpty(r108) == true) goto L30;
        a(r107, r108);
        r107.b(r108);
    L31:
        if (r102 == false) goto L108;
        return r107;
    L30:
        r102 = false;
        goto L31
    L33:
        n6 r109 = n6.f27680i;
        if (r100.equalsIgnoreCase(r109.a()) == false) goto L41;
        String r110 = b("ro.build.version.opporom");
        if (TextUtils.isEmpty(r110) == true) goto L38;
        a(r109, r110);
        r109.b(r110);
    L39:
        if (r102 == false) goto L108;
        return r109;
    L38:
        r102 = false;
        goto L39
    L41:
        n6 r111 = n6.f27681j;
        if (r100.equalsIgnoreCase(r111.a()) == false) goto L49;
        String r112 = b("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r112) == true) goto L46;
        a(r111, r112);
        r111.b(r112);
    L47:
        if (r102 == false) goto L108;
        return r111;
    L46:
        r102 = false;
        goto L47
    L49:
        n6 r113 = n6.f27682k;
        if (r100.equalsIgnoreCase(r113.a()) == false) goto L57;
        String r114 = b("ro.smartisan.version");
        if (TextUtils.isEmpty(r114) == true) goto L54;
        a(r113, r114);
        r113.b(r114);
    L55:
        if (r102 == false) goto L108;
        return r113;
    L54:
        r102 = false;
        goto L55
    L57:
        n6 r115 = n6.f27683l;
        if (r100.equalsIgnoreCase(r115.a()) == false) goto L67;
        String r116 = b("ro.build.display.id");
        if (TextUtils.isEmpty(r116) == false) goto L62;
    L64:
        r102 = false;
    L65:
        if (r102 == false) goto L108;
        return r115;
    L62:
        if (r116.matches("amigo([\\d.]+)[a-zA-Z]*") == false) goto L64;
        a(r115, r116);
        r115.b(r116);
        goto L65
    L67:
        n6 r117 = n6.f27684m;
        if (r100.equalsIgnoreCase(r117.a()) == false) goto L75;
        String r118 = b("ro.letv.release.version");
        if (TextUtils.isEmpty(r118) == true) goto L72;
        a(r117, r118);
        r117.b(r118);
    L73:
        if (r102 == false) goto L108;
        return r117;
    L72:
        r102 = false;
        goto L73
    L75:
        n6 r119 = n6.f27685n;
        if (r100.equalsIgnoreCase(r119.a()) == false) goto L83;
        String r120 = b("ro.build.sense.version");
        if (TextUtils.isEmpty(r120) == true) goto L80;
        a(r119, r120);
        r119.b(r120);
    L81:
        if (r102 == false) goto L108;
        return r119;
    L80:
        r102 = false;
        goto L81
    L83:
        n6 r121 = n6.f27686o;
        if (r100.equalsIgnoreCase(r121.a()) == false) goto L91;
        String r122 = b("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(r122) == true) goto L88;
        a(r121, r122);
        r121.b(r122);
    L89:
        if (r102 == false) goto L108;
        return r121;
    L88:
        r102 = false;
        goto L89
    L91:
        n6 r123 = n6.f27687p;
        if (r100.equalsIgnoreCase(r123.a()) == true) goto L94;
        n6 r124 = n6.f27688q;
        if (r100.equalsIgnoreCase(r124.a()) == false) goto L108;
        String r125 = b("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(r125) == true) goto L104;
        a(r124, r125);
        r124.b(r125);
    L105:
        if (r102 == false) goto L108;
        return r124;
    L104:
        r102 = false;
        goto L105
    L94:
        if ("android-google".equals(b("ro.com.google.clientidbase")) == false) goto L96;
        String r126 = b("ro.build.version.release");
        r123.a(Build.VERSION.SDK_INT);
        r123.b(r126);
    L97:
        if (r102 == false) goto L108;
        return r123;
    L96:
        r102 = false;
        goto L97
    L9:
        if (TextUtils.isEmpty(b("ro.miui.ui.version.name")) == true) goto L11;
        String r127 = b("ro.build.version.incremental");
        a(r101, r127);
        r101.b(r127);
    L12:
        if (r102 == false) goto L108;
        return r101;
    L11:
        r102 = false;
    L110:
        return n6.f27689r;
    }

    private static String b(String r100) {
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
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L45
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3d
            java.lang.String r2 = "getprop "
            java.lang.String r3 = r2.concat(r3)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3d
            java.lang.Process r3 = com_amap_api_mapcore_util_o6_java_lang_Runtime_exec(r1, r3)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3d
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3d
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3d
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3d
            r3 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3d
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L34
            r1.close()     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L34
            r1.close()     // Catch: java.io.IOException -> L2f
        L2f:
            r0 = r3
            goto L44
        L31:
            r3 = move-exception
            r0 = r1
            goto L37
        L34:
            goto L3f
        L36:
            r3 = move-exception
        L37:
            if (r0 == 0) goto L3c
            r0.close()     // Catch: java.io.IOException -> L3c
        L3c:
            throw r3
        L3d:
            r1 = r0
        L3f:
            if (r1 == 0) goto L44
            r1.close()     // Catch: java.io.IOException -> L44
        L44:
            return r0
        L45:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o6.b(java.lang.String):java.lang.String");
    }

    public static /* synthetic */ n6 a(n6 r100) {
        f27766a = r100;
        return r100;
    }

    private static void a(n6 r100, String r101) {
        Matcher r102 = PatternProtector.compile("([\\d.]+)[^\\d]*").matcher(r101);
        if (r102.find() == true) goto L10;
        return;
    L10:
        String r103 = r102.group(1);     // Catch: Exception -> L7
        r100.a(r103);     // Catch: Exception -> L7
        r100.a(CastIntegerProtector.parseInt(r103.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[0]));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    private static Process com_amap_api_mapcore_util_o6_java_lang_Runtime_exec(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
