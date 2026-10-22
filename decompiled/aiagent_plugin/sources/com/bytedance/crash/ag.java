package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: TagService.java */
/* JADX INFO: loaded from: classes.dex */
public class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static v f7132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f7133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f7134c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile File f7135d;

    static /* synthetic */ void b(Map r2) {
        d((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void e() {
        h();
    }

    static /* synthetic */ String f() {
        return f7133b;
    }

    static /* synthetic */ v g() {
        return f7132a;
    }

    public static void a(v r2) {
        f7132a = (v) ZeusTransformUtils.wrapperContextForParams(r2, v.class, "com.obric.aiagent.plugin");
    }

    public static Map<String, String> a() {
        return f7132a.a(f7133b);
    }

    public static v b() {
        return f7132a;
    }

    private static void h() {
        if (f7133b == null) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        File r1 = new File(i.d(), "custom_tags");
        if (r1.exists() == true) goto L12;
        r1.mkdirs();
    L12:
        if (com.bytedance.crash.o.b.a(r0) == false) goto L14;
        String r2 = InitTaskProcess.MAIN;
    L15:
        File r3 = new File(r1, r2);
        if (r3.exists() == true) goto L18;
        r3.mkdirs();
    L18:
        File r4 = new File(r3, "tag_" + i.f());
        if (r4.exists() == true) goto L21;
        r4.mkdirs();
    L21:
        f7133b = r4.getAbsolutePath();
        return;
    L14:
        r2 = com.bytedance.crash.o.b.c().replaceAll(":", "@");
        goto L15
    }

    public static void a(Map<? extends String, ? extends String> r2, ah r3) {
        Map<? extends String, ? extends String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L15;
        if (r4.isEmpty() == false) goto L7;
    L12:
        return;
    L7:
        if (f7132a == null) goto L9;
        c(r4);     // Catch: Throwable -> L11
        goto L12
    L9:
        r3.a(r4);     // Catch: Throwable -> L11
    L16:
        return;
    }

    public static void a(String r1, String r2, ah r3) {
        if (f7132a == null) goto L5;
        b(r1, r2);
        return;
    L5:
        r3.b(r1, r2);
    }

    public static void a(String r1, ah r2) {
        if (f7132a == null) goto L5;
        b(r1, null);
        return;
    L5:
        r2.b(r1);
    }

    private static void b(final String r1, final String r2) {
        if (f7132a == null) goto L6;
        DefaultWorkThread.post(new AnonymousClass1(r2, r1));
        return;
    }

    private static void c(Map<? extends String, ? extends String> r2) {
        final Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (f7132a == null) goto L6;
        DefaultWorkThread.post(new AnonymousClass2(r3));
        return;
    }

    public static void a(JSONObject r6) {
        final long r1 = r6.optLong("app_start_time");     // Catch: Throwable -> L18
        String r3 = r6.optString("process_name");     // Catch: Throwable -> L18
        JSONObject r7 = r6.optJSONObject("filters");     // Catch: Throwable -> L18
        if (com.bytedance.crash.o.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3) == false) goto L6;
        String r0 = InitTaskProcess.MAIN;
    L7:
        File[] r2 = new File(new File(i.d(), "custom_tags"), r0).listFiles(new AnonymousClass3(r1));     // Catch: Throwable -> L18
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.length < 1) goto L22;
        v r4 = f7132a;     // Catch: Throwable -> L18
        if (r4 == null) goto L23;
        Map<String, String> r5 = r4.a(r2[0].getAbsolutePath());     // Catch: Throwable -> L18
        if (r5 == null) goto L24;
        com.bytedance.crash.o.l.b(r7, r5);     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L6:
        r0 = r3.replaceAll(":", "@");     // Catch: Throwable -> L18
    }

    public static Map<String, String> c() {
        return f7134c;
    }

    static {
        f7134c = new ConcurrentHashMap();
    }

    public static void a(String r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L7;
        a(r1);
        return;
    L7:
        Map<String, String> r0 = f7134c;
        r0.put(r1, r2);
        if (ad.b() == true) goto L10;
        return;
    L10:
        final HashMap r3 = new HashMap(r0);
        DefaultWorkThread.post(new AnonymousClass4(r3));
    }

    public static void a(String r2) {
        Map<String, String> r0 = f7134c;
        if (r0.containsKey(r2) == true) goto L5;
        return;
    L5:
        r0.remove(r2);
        if (ad.b() == true) goto L8;
        return;
    L8:
        final HashMap r3 = new HashMap(r0);
        DefaultWorkThread.post(new AnonymousClass5(r3));
    }

    public static void a(Map<? extends String, ? extends String> r2) {
        Map<? extends String, ? extends String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L6;
        return;
    L6:
        if (ad.b() == true) goto L9;
        f7134c.putAll(r3);
        return;
    L9:
        Map<String, String> r0 = f7134c;
        r0.putAll(r3);
        final HashMap r4 = new HashMap(r0);
        DefaultWorkThread.post(new AnonymousClass6(r4));
    }

    private static void d(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        ObjectOutputStream r0 = null;
        if (f7135d != null) goto L21;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.c(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        if (r1 != null) goto L9;
        com.bytedance.crash.o.k.a(null);
        return;
    L9:
        File r2 = new File(i.d(), "tags");     // Catch: Throwable -> L30
        if (r2.exists() == true) goto L13;
        r2.mkdirs();     // Catch: Throwable -> L30
    L13:
        if (com.bytedance.crash.o.b.a(r1) == false) goto L15;
        String r3 = InitTaskProcess.MAIN;
    L16:
        File r4 = new File(r2, r3);     // Catch: Throwable -> L30
        if (r4.exists() == true) goto L19;
        r4.mkdirs();     // Catch: Throwable -> L30
    L19:
        f7135d = new File(r4, "import_tag_" + ac.c() + ".txt");     // Catch: Throwable -> L30
        goto L21
    L15:
        r3 = com.bytedance.crash.o.b.c().replaceAll(":", "@");     // Catch: Throwable -> L30
    L21:
        if (f7135d != null) goto L24;
        com.bytedance.crash.o.k.a(null);
        return;
    L24:
        ObjectOutputStream r5 = new ObjectOutputStream(new FileOutputStream(f7135d));     // Catch: Throwable -> L30
        r5.writeObject(r7);     // Catch: Throwable -> L27
        com.bytedance.crash.o.k.a(r5);
        return;
    L27:
        r0 = r5;
    L28:
        com.bytedance.crash.o.k.a(r0);
    }

    public static void d() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L5;
        return;
    L5:
        a(new File(i.d(), "custom_tags"));
        a(new File(i.d(), "tags"));
    }

    public static void a(File r7) {
        File[] r8 = r7.listFiles();
        if (r8 != null) goto L5;
        return;
    L5:
        int r0 = r8.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L21;
        File r3 = r8[r2];
        if (r3.isFile() == true) goto L19;
        File[] r4 = r3.listFiles();
        if (r4 == null) goto L20;
        if (r4.length <= 5) goto L27;
        Arrays.sort(r4);
        int r5 = 0;
    L17:
        if (r5 >= (r4.length - 5)) goto L20;
        com.bytedance.crash.o.j.a(r4[r5]);
        r5 = r5 + 1;
        goto L17
    L27:
        return;
    L20:
        r2 = r2 + 1;
        goto L6
    L19:
        com.bytedance.crash.o.j.a(r3);
        goto L20
    }

    public static void a(JSONObject r4, final long r5, String r7) {
        if (com.bytedance.crash.o.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7) == false) goto L5;
        String r8 = InitTaskProcess.MAIN;
    L6:
        File[] r6 = new File(new File(i.d(), "tags"), r8).listFiles(new AnonymousClass7(r5));
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.length < 1) goto L27;
        ObjectInputStream r9 = null;
        ObjectInputStream r10 = new ObjectInputStream(new FileInputStream(r6[0]));     // Catch: Throwable -> L20
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(r10.readObject(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r11 == null) goto L16;
        com.bytedance.crash.o.l.b(r4, r11);     // Catch: Throwable -> L17
    L16:
        com.bytedance.crash.o.k.a(r10);
        return;
    L17:
        r9 = r10;
    L18:
        com.bytedance.crash.o.k.a(r9);
        return;
    L27:
        return;
    L5:
        r8 = r7.replaceAll(":", "@");
        goto L6
    }
}
