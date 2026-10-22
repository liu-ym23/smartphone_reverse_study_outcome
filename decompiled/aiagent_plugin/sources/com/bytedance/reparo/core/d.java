package com.bytedance.reparo.core;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: MethodWand.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends WandTrick {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<ClassLoader> f9162a;

    public d() {
        this.f9162a = new ArrayList();
    }

    private h a(Map<Class, f> r18) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        ArrayList r3 = new ArrayList();
        Iterator r2 = r1.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r2.next(), f.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L4;
        String r5 = r4.a();
        if (TextUtils.isEmpty(r5) == true) goto L4;
        r3.add(r5);
        goto L4
    L10:
        ClassLoader r6 = WandTrick.class.getClassLoader();
        final ArrayList r7 = new ArrayList();
        int r8 = 0;
        File r9 = new File((String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.aiagent.plugin")).getParentFile();
        r9.listFiles(new AnonymousClass1(this, r7));
        int r10 = r3.size() / 99;
        if ((r3.size() % 99) == 0) goto L14;
        r10 = r10 + 1;
    L14:
        if (r7.size() == r10) goto L36;
        int r11 = 0;
    L16:
        if (r11 >= r10) goto L36;
        int r12 = r11 * 99;
        int r13 = r11 + 1;
        int r14 = Math.min(r13 * 99, r3.size());     // Catch: Exception -> L29
        File r15 = new File(r9, "tmp" + r11);     // Catch: Exception -> L29
        if (r15.exists() == true) goto L21;
        r15.mkdirs();     // Catch: Exception -> L29
    L21:
        int r16 = r8;
    L22:
        if (r12 >= r14) goto L24;
        com.bytedance.reparo.core.a.b.b.a(new File((String) ZeusTransformUtils.preCheckCast(r3.get(r12), String.class, "com.obric.aiagent.plugin")), new File(r15, a(r16)));     // Catch: Exception -> L29
        r12 = r12 + 1;     // Catch: Exception -> L29
        r16 = r16 + 1;     // Catch: Exception -> L29
        r3 = r3;
        goto L22
    L24:
        ArrayList r17 = r3;
        File r19 = new File(r9, "patch" + r11 + ".zip");     // Catch: Exception -> L29
        r7.add(r19);     // Catch: Exception -> L29
        ZipOutputStream r20 = new ZipOutputStream(new FileOutputStream(r19));     // Catch: Exception -> L29
        File[] r21 = r15.listFiles();     // Catch: Exception -> L29
        int r22 = r21.length;     // Catch: Exception -> L29
        int r23 = 0;
    L25:
        if (r23 >= r22) goto L27;
        File r110 = r21[r23];     // Catch: Exception -> L29
        r20.putNextEntry(new ZipEntry(r110.getName()));     // Catch: Exception -> L29
        FileInputStream r111 = new FileInputStream(r110);     // Catch: Exception -> L29
        com.bytedance.reparo.core.a.b.c.a(r111, r20);     // Catch: Exception -> L29
        com.bytedance.reparo.core.a.b.c.a(r111);     // Catch: Exception -> L29
        r23 = r23 + 1;     // Catch: Exception -> L29
        goto L25
    L27:
        com.bytedance.reparo.core.a.b.c.a(r20);     // Catch: Exception -> L29
        com.bytedance.reparo.core.a.b.b.delete(r15);     // Catch: Exception -> L29
        r11 = r13;
        r3 = r17;
        r8 = 0;
    L29:
        e = move-exception;
        com.bytedance.reparo.core.f.a.d("make patch.zip failed");
        e.printStackTrace();
        Iterator r0 = r7.iterator();
    L32:
        if (r0.hasNext() == false) goto L34;
        com.bytedance.reparo.core.a.b.b.delete((File) ZeusTransformUtils.preCheckCast(r0.next(), File.class, "com.obric.aiagent.plugin"));
        goto L32
    L34:
        return null;
    L36:
        StringBuilder r24 = new StringBuilder(((File) ZeusTransformUtils.preCheckCast(r7.get(0), File.class, "com.obric.aiagent.plugin")).getAbsolutePath());
        int r25 = 1;
    L38:
        if (r25 >= r7.size()) goto L40;
        r24.append(":");
        r24.append(((File) ZeusTransformUtils.preCheckCast(r7.get(r25), File.class, "com.obric.aiagent.plugin")).getAbsolutePath());
        r25 = r25 + 1;
        goto L38
    L40:
        h r26 = new h(r24.toString(), null, this.f9138b.getApplicationInfo().nativeLibraryDir, r6);
        Object r27 = com.bytedance.reparo.core.i.j.a(r26, "pathList").get(r6);
        IOException[] r28 = (IOException[]) ZeusTransformUtils.preCheckCast((IOException[]) ZeusTransformUtils.preCheckCast(com.bytedance.reparo.core.i.j.a(r27, "dexElementsSuppressedExceptions").get(r27), IOException[].class, "com.obric.aiagent.plugin"), IOException[].class, "com.obric.aiagent.plugin");
        if (r28 != null) goto L43;
    L46:
        this.f9162a.add(r26);
        return r26;
    L43:
        if (r28.length <= 0) goto L46;
        com.bytedance.reparo.core.f.a.d("create patchClassLoader failed");
        return null;
    }

    @Override // com.bytedance.reparo.core.WandTrick
    public WandTrick.a a(Application r11, boolean r12, Map<Class, f> r13, List<String> r14, List<String> r15, List<Object> r16, com.bytedance.reparo.core.h.b r17, com.bytedance.reparo.core.h.d r18) {
        Application r2 = (Application) ZeusTransformUtils.wrapperContextForParams(r11, Application.class, "com.obric.aiagent.plugin");
        Map<Class, f> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
    L13:
        com.bytedance.reparo.core.f.a.d("device not supported");
        return WandTrick.a.o;
    L5:
        if (l.b() == true) goto L13;
        r17.a("createPatchClassLoader");
        h r7 = a(r3);
        r17.b("createPatchClassLoader");
        if (r7 != null) goto L12;
        return WandTrick.a.o;
    L12:
        return a(r2, r12, r3, r4, r5, r6, r7, r17, r18);
    }

    private String a(int r2) {
        if (r2 != 0) goto L6;
        return "classes.dex";
    L6:
        return "classes" + (r2 + 1) + ".dex";
    }

    private WandTrick.a a(Application r22, final boolean r23, Map<Class, f> r24, List<String> r25, List<String> r26, List<Object> r27, h r28, final com.bytedance.reparo.core.h.b r29, final com.bytedance.reparo.core.h.d r30) {
        String r2 = "com.obric.aiagent.plugin";
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r22, Application.class, "com.obric.aiagent.plugin");
        final Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.aiagent.plugin");
        Set r1 = r8.keySet();
        c r4 = new c();
        HashMap r5 = new HashMap();
        r29.a("loadPatchClasses");
        Iterator r12 = r1.iterator();
    L4:
        if (r12.hasNext() == false) goto L28;
        Class r13 = (Class) ZeusTransformUtils.preCheckCast(r12.next(), Class.class, "com.obric.aiagent.plugin");
        a.a(r13, false);
        a.c(r13);
        a.d(r13);
        a.e(r13);
        a.a(r13);
        Class<?> r15 = r28.a(r13.getName());
        if (r15 == null) goto L26;
        if (r13 == null) goto L26;
        a.a(r15, true);
        a.c(r15);
        a.d(r15);
        a.e(r15);
        r4.a(r15);
        r5.put(r13, r15);
        ArrayList r14 = new ArrayList(Arrays.asList((Object[]) ZeusTransformUtils.preCheckCast(com.bytedance.reparo.core.i.j.a(r13).a(), Object[].class, "com.obric.aiagent.plugin")));
        ArrayList<Method> r16 = a(r15);
        if (r14.size() != r16.size()) goto L24;
        if (com.bytedance.reparo.core.i.j.b(r15).length != com.bytedance.reparo.core.i.j.b(r13).length) goto L24;
        LinkedHashMap r11 = new LinkedHashMap();
        int r17 = 0;
    L14:
        if (r17 >= r14.size()) goto L16;
        Method r18 = (Method) ZeusTransformUtils.preCheckCast(r14.get(r17), Method.class, "com.obric.aiagent.plugin");
        r11.put(r18.getName() + l.a(r18), r18);
        r17 = r17 + 1;
        r14 = r14;
        r3 = r3;
        goto L14
    L16:
        List r210 = r3;
        int r19 = 0;
    L18:
        if (r19 >= r16.size()) goto L27;
        Method r7 = (Method) ZeusTransformUtils.preCheckCast(r16.get(r19), Method.class, "com.obric.aiagent.plugin");
        if (r11.containsKey(r7.getName() + l.a(r7)) == false) goto L23;
        r19 = r19 + 1;
        goto L18
    L23:
        throw new Exception("Structure changed in: " + r15.getName());
    L27:
        r12 = r12;
        r10 = r10;
        r3 = r210;
        r9 = r9;
        r6 = r6;
    L24:
        com.bytedance.reparo.core.f.a.d("structure changed in " + r15 + ", abort.");
        throw new Exception("Structure changed in: " + r15.getName());
    L26:
        r210 = r3;
        goto L27
    L28:
        final List r211 = r3;
        final Application r110 = r6;
        final List r111 = r9;
        final List r212 = r10;
        r4.a();
        String[] r20 = new String[r5.size()];
        Iterator r21 = r5.values().iterator();
        int r31 = 0;
    L30:
        if (r21.hasNext() == false) goto L32;
        r20[r31] = ((Class) ZeusTransformUtils.preCheckCast(r21.next(), Class.class, "com.obric.aiagent.plugin")).getName();
        r31 = r31 + 1;
        goto L30
    L32:
        WandTrick.removeClassesFromClassLinker(r20, r28);
        r29.b("loadPatchClasses");
        r29.a("preparePatchMethods");
        final ArrayList r32 = new ArrayList();
        final ArrayList r33 = new ArrayList();
        final ArrayList r112 = new ArrayList();
        Iterator r34 = r1.iterator();
    L34:
        if (r34.hasNext() == false) goto L96;
        Class r35 = (Class) ZeusTransformUtils.preCheckCast(r34.next(), Class.class, r2);
        Class<?> r36 = (Class) ZeusTransformUtils.preCheckCast(r5.get(r35), Class.class, r2);
        if (r36 == null) goto L94;
        if (r35 == null) goto L94;
        a.a(r36, r35.getClassLoader());
        f r37 = (f) ZeusTransformUtils.preCheckCast(r8.get(r35), f.class, r2);
        if (r37 == null) goto L41;
        List<Method> r113 = r37.c();
        List<Constructor> r38 = r37.b();
    L42:
        if (r113 != null) goto L44;
    L46:
        Method[] r114 = null;
    L47:
        if (r38 != null) goto L49;
    L51:
        Constructor[] r115 = null;
    L52:
        if (r114 != null) goto L57;
        if (r115 != null) goto L57;
        throw new Exception("Unspecified target in class: " + r35.getSimpleName());
    L57:
        r112.add(r36);
        if (r114 == null) goto L78;
        int r39 = 0;
    L61:
        if (r39 >= r114.length) goto L78;
        Method r116 = r114[r39];
        Iterator r213 = r34;
        Method[] r40 = (Method[]) ZeusTransformUtils.preCheckCast(com.bytedance.reparo.core.i.j.a(r36).a(), Method[].class, r2);
        int r117 = r40.length;
        String r118 = r2;
        int r41 = 0;
    L63:
        if (r41 >= r117) goto L73;
        Method r119 = r40[r41];
        Method[] r214 = r40;
        if (r119.getDeclaringClass() != r36) goto L71;
        HashMap r215 = r5;
        if (r119.getName().equals(r116.getName()) == false) goto L72;
        if (l.a(r119).equals(l.a(r116)) == false) goto L72;
        Method r42 = r119;
    L74:
        if (r42 == null) goto L77;
        r32.add(r116);
        r33.add(r42);
        r39 = r39 + 1;
        r34 = r213;
        r2 = r118;
        r5 = r215;
        goto L61
    L77:
        throw new NoSuchMethodException(r116.getName() + " " + Arrays.toString(r116.getParameterTypes()));
    L72:
        r41 = r41 + 1;
        r40 = r214;
        r5 = r215;
        goto L63
    L71:
        r215 = r5;
        goto L72
    L73:
        r215 = r5;
        r42 = null;
    L78:
        Iterator r216 = r34;
        String r120 = r2;
        HashMap r217 = r5;
        if (r115 == null) goto L95;
        int r43 = 0;
    L82:
        if (r43 >= r115.length) goto L95;
        Constructor r44 = r115[r43];
        Constructor<?>[] r45 = r36.getDeclaredConstructors();
        int r46 = r45.length;
        int r121 = 0;
    L84:
        if (r121 >= r46) goto L89;
        Constructor<?> r122 = r45[r121];
        Constructor<?>[] r218 = r45;
        if (l.a(r44).equals(l.a(r122)) == true) goto L90;
        r121 = r121 + 1;
        r45 = r218;
    L90:
        if (r122 == null) goto L93;
        r32.add(r44);
        PatchConstructorHelper.collectConstructorClass(r44);
        r33.add(r122);
        r43 = r43 + 1;
        goto L82
    L93:
        throw new NoSuchMethodException(r44.getName() + " " + Arrays.toString(r44.getParameterTypes()));
    L89:
        r122 = null;
    L95:
        r34 = r216;
        r2 = r120;
        r5 = r217;
        goto L34
    L49:
        if (r38.isEmpty() == true) goto L51;
        r115 = new Constructor[r38.size()];
        r38.toArray(r115);
        goto L52
    L44:
        if (r113.isEmpty() == true) goto L46;
        r114 = new Method[r113.size()];
        r113.toArray(r114);
        goto L47
    L41:
        r38 = null;
        r113 = null;
    L94:
        r216 = r34;
        r120 = r2;
        r217 = r5;
        goto L95
    L96:
        r29.b("preparePatchMethods");
        return new AnonymousClass2(this, r30, r211, r32, r33, r110, r23, r8, r111, r212, r29, r112);
    }
}
