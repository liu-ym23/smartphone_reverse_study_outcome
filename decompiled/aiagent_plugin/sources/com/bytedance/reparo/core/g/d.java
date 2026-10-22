package com.bytedance.reparo.core.g;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: JavaPatchInfoParser.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String TAG = "JavaPatchInfoParser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Class, com.bytedance.reparo.core.f> f9216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f9217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f9218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Object> f9219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f9220e;
    private boolean f;

    /* JADX INFO: renamed from: com.bytedance.reparo.core.g.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: JavaPatchInfoParser.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: JavaPatchInfoParser.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, com.bytedance.reparo.core.f> f9221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f9222b;

        private a() {
            this.f9221a = new HashMap();
            this.f9222b = new HashSet();
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public void a(Class<?> r1, com.bytedance.reparo.core.f r2) {
            this.f9221a.put(r1, r2);
        }

        public Map<Class<?>, com.bytedance.reparo.core.f> a() {
            return this.f9221a;
        }

        public void a(String r1) {
            this.f9222b.add(r1);
        }

        public Set<String> b() {
            return this.f9222b;
        }
    }

    public d(File r2) {
        this.f9216a = new HashMap();
        this.f9217b = new ArrayList();
        this.f9219d = new ArrayList();
        this.f = false;
        this.f9220e = r2;
    }

    public void a(com.bytedance.reparo.core.h.b r7) {
        r7.a("parse_patch_io");
        if (com.bytedance.reparo.core.a.b.b.d(this.f9220e) == true) goto L15;
        File r1 = new File(this.f9220e, "patch_classes_methods.txt");
        if (com.bytedance.reparo.core.a.b.b.b(r1) == false) goto L13;
        Map<String, Map<String, Set<String>>> r2 = a(r1);     // Catch: IOException -> L9
        Map<String, Map<String, Set<String>>> r3 = a(f());     // Catch: IOException -> L9
        this.f9218c = com.bytedance.reparo.core.a.b.b.h(new File(this.f9220e, "added_classes.txt"));
        r7.b("parse_patch_io");
        r7.a("parse_patch_load");
        a r4 = a(r2, true);
        this.f9216a.putAll(r4.a());
        this.f9217b.addAll(r4.b());
        this.f9219d.addAll(a(r3));
        this.f = true;
        r7.b("parse_patch_load");
        return;
    L9:
        e = move-exception;
        throw new com.bytedance.reparo.core.b.b("loadPatchConfig failed", e, 111);
    L13:
        throw new com.bytedance.reparo.core.b.b("Failed to parse java patch, patch_classes_methods.txt not exist", 107);
    L15:
        throw new com.bytedance.reparo.core.b.b("Failed to parse java patch, java patch root dir is empty", 106);
    }

    private File f() {
        File r0 = new File(this.f9220e, "deoptimize_methods_l.txt");
        File r1 = new File(this.f9220e, "deoptimize_methods_mn.txt");
        File r2 = new File(this.f9220e, "deoptimize_methods_os.txt");
        File r3 = new File(this.f9220e, "deoptimize_methods.txt");
        if (Build.VERSION.SDK_INT > 22) goto L8;
        if (r0.exists() == false) goto L8;
        System.out.println("use deoptimize_methods_l.txt");
    L19:
        if (com.bytedance.reparo.core.a.b.b.b(r0) == false) goto L22;
        return r0;
    L22:
        throw new com.bytedance.reparo.core.b.b("Failed to parse java patch, " + r0.getAbsolutePath() + " not exist", 108);
    L8:
        if (Build.VERSION.SDK_INT > 25) goto L13;
        if (r1.exists() == false) goto L13;
        System.out.println("use deoptimize_methods_mn.txt");
        r0 = r1;
    L13:
        if (Build.VERSION.SDK_INT <= 30) goto L15;
    L17:
        r0 = r3;
        goto L19
    L15:
        if (r2.exists() == false) goto L17;
        System.out.println("use deoptimize_methods_os.txt");
        r0 = r2;
        goto L19
    }

    private List<Object> a(Map<String, Map<String, Set<String>>> r5) {
        Map<String, Map<String, Set<String>>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        Iterator<com.bytedance.reparo.core.f> r4 = a(r6, false).a().values().iterator();
    L4:
        if (r4.hasNext() == false) goto L17;
        com.bytedance.reparo.core.f r7 = (com.bytedance.reparo.core.f) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.reparo.core.f.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L4;
        List<Method> r2 = r7.c();
        if (r2 != null) goto L10;
    L12:
        List<Constructor> r8 = r7.b();
        if (r8 == null) goto L4;
        if (r8.isEmpty() == true) goto L4;
        r0.addAll(r8);
        goto L4
    L10:
        if (r2.isEmpty() == true) goto L12;
        r0.addAll(r2);
        goto L12
    L17:
        return r0;
    }

    private a a(Map<String, Map<String, Set<String>>> r17, boolean r18) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        a r3 = new a(null);
        Iterator r4 = r0.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L57;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r5 = l.b((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"));
        File r6 = new File(this.f9220e, r5 + ".dex");
        if (r6.exists() == true) goto L11;
        if (r18 == false) goto L11;
        throw new com.bytedance.reparo.core.b.b("parsePatchConfig patch dex file: " + r6.getPath() + " does not exist", 109);
    L11:
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r1.getValue(), Map.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L56;
        if (r2.isEmpty() == true) goto L56;
        int r9 = 0;
        Class<?> r8 = Class.forName(r5, false, d.class.getClassLoader());     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48 Throwable -> L50
    L16:
        com.bytedance.reparo.core.f r10 = new com.bytedance.reparo.core.f(r8, r6.getPath());     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        if (r2.containsKey("<clinit>") == false) goto L60;
        Constructor r7 = WandTrick.b().getClinitMethod(r8);     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        if (r7 == null) goto L60;
        r10.a(r7);     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
    L60:
        Method[] r11 = (Method[]) ZeusTransformUtils.preCheckCast(com.bytedance.reparo.core.i.j.a(r8).b(), Method[].class, "com.obric.aiagent.plugin");     // Catch: NoClassDefFoundError -> L44 Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        int r12 = r11.length;     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        int r13 = 0;
    L23:
        if (r13 >= r12) goto L30;
        Method r14 = r11[r13];     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        String r15 = r14.getName();     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        if (r2.containsKey(r15) == false) goto L29;
        if (((Set) ZeusTransformUtils.preCheckCast(r2.get(r15), Set.class, "com.obric.aiagent.plugin")).contains(l.a(r14)) == false) goto L29;
        r10.a(r14);     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
    L29:
        r13 = r13 + 1;     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        goto L23
    L30:
        Constructor<?>[] r16 = r8.getDeclaredConstructors();     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        int r19 = r16.length;     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
    L31:
        if (r9 >= r19) goto L39;
        Constructor<?> r110 = r16[r9];     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        String r111 = r110.getName();     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        if (r2.containsKey(r111) == false) goto L37;
        if (((Set) ZeusTransformUtils.preCheckCast(r2.get(r111), Set.class, "com.obric.aiagent.plugin")).contains(l.a(r110)) == false) goto L37;
        r10.a(r110);     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
    L37:
        r9 = r9 + 1;     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
        goto L31
    L39:
        if (r10.c() != null) goto L43;
        if (r10.b() != null) goto L43;
        com.bytedance.reparo.core.f.a.d("parsePatchConfig ignore class:" + r8.getName());     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
    L43:
        r3.a(r8, r10);     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
    L44:
        e = move-exception;
        com.bytedance.reparo.core.f.a.b("skip patch class " + r8.getName(), e);     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
    L50:
        e = move-exception;
        com.bytedance.reparo.core.f.a.b("skip patch class " + r5, e);     // Catch: Exception -> L46 com.bytedance.reparo.core.b.d -> L48
    L48:
        e = move-exception;
        throw e;
    L46:
        e = move-exception;
        throw new com.bytedance.reparo.core.b.b("parsePatchConfig class: " + r5, e, 110);
    L56:
        r3.a(r6.getAbsolutePath());
        goto L4
    L57:
        return r3;
    }

    private Map<String, Map<String, Set<String>>> a(File r7) {
        HashMap r6 = new HashMap();
        BufferedReader r0 = new BufferedReader(new FileReader(r7));
        String r8 = r0.readLine();
        String r1 = null;
    L4:
        if (TextUtils.isEmpty(r8) == true) goto L27;
        if (r8.startsWith("#") == false) goto L14;
        String r9 = r8.substring(2);
        if (TextUtils.isEmpty(r9) == false) goto L10;
    L12:
        r1 = r9;
    L26:
        r8 = r0.readLine();
        goto L4
    L10:
        if (r6.containsKey(r9) == true) goto L12;
        r6.put(r9, new HashMap());
        goto L12
    L14:
        if (TextUtils.isEmpty(r1) == true) goto L26;
        String r10 = r8.trim();
        int r2 = r10.indexOf(32);
        String r3 = r10.substring(0, r2);
        String r11 = r10.substring(r2 + 1);
        if (TextUtils.isEmpty(r3) == true) goto L26;
        if (TextUtils.isEmpty(r11) == true) goto L26;
        if ("<init>".equals(r3) == false) goto L23;
        r3 = l.b(r1);
    L23:
        if (((Map) ZeusTransformUtils.preCheckCast(r6.get(r1), Map.class, "com.obric.aiagent.plugin")).containsKey(r3) == false) goto L25;
        ((Set) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r6.get(r1), Map.class, "com.obric.aiagent.plugin")).get(r3), Set.class, "com.obric.aiagent.plugin")).add(r11);
        goto L26
    L25:
        HashSet r4 = new HashSet();
        r4.add(r11);
        ((Map) ZeusTransformUtils.preCheckCast(r6.get(r1), Map.class, "com.obric.aiagent.plugin")).put(r3, r4);
        goto L26
    L27:
        r0.close();
        return r6;
    }

    public Map<Class, com.bytedance.reparo.core.f> a() {
        return this.f9216a;
    }

    public List<String> b() {
        return this.f9217b;
    }

    public List<String> c() {
        return this.f9218c;
    }

    public List<Object> d() {
        return this.f9219d;
    }

    public boolean e() {
        return this.f;
    }
}
