package com.bytedance.dataplatform;

import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: ExperimentManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Map<String, Object> f7941a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static k f7942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile c f7943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Future f7944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f7945e;
    private static volatile boolean f;
    private static volatile boolean g;
    private static Object h;
    private static Map<String, String> i;
    private static Set<String> j;
    private static boolean k;
    private static g l;
    private static boolean m;
    private static final Map<String, String> n = null;

    static /* synthetic */ Map a() {
        return i;
    }

    static /* synthetic */ c b() {
        return f7943c;
    }

    static /* synthetic */ void c() {
        d();
    }

    static {
        f7941a = new ConcurrentHashMap();
        f7945e = false;
        f = false;
        g = false;
        h = new Object();
        i = new ConcurrentHashMap();
        j = new ConcurrentSkipListSet();
        k = false;
        m = false;
        n = new ConcurrentHashMap();
    }

    public static void a(Map<String, String> r6) {
        Iterator r7 = ((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
        boolean r0 = false;
    L4:
        if (r7.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(i.get(r3), CharSequence.class, "com.obric.aiagent.plugin"), r4) == true) goto L4;
        i.put(r3, r4);
        r0 = true;
        goto L4
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        if (f7945e == false) goto L19;
        m.a(new AnonymousClass1());
        return;
    }

    private static void d() {
        if ((f7945e | f) == true) goto L18;
        if (k == false) goto L18;
        Object r0 = h;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L10:
        if ((f7945e | f) == false) goto L29;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        goto L18
    L29:
        h.wait(10000);     // Catch: InterruptedException -> L26 Throwable -> L14
    L18:
        if (f7944d == null) goto L25;
        f7944d.get();     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        throw new RuntimeException(e);
    L25:
        throw new RuntimeException("ExperimentManager has not been init");
    }

    public static String a(String r1) {
        d();
        return f7943c.b(r1);
    }

    public static <T> T a(String r7, Type r8, T r9, boolean r10, boolean r11, boolean r12, boolean r13, com.bytedance.dataplatform.b.a<T> r14) {
        Type r15 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.aiagent.plugin");
        d();
        if (r11 == false) goto L12;
        Map<String, Object> r0 = f7941a;
        if (r0.containsKey(r7) == false) goto L12;
        if (r0.get(r7).getClass() != r15) goto L12;
        if (r12 == true) goto L44;
    L10:
        return (T) a(r7, r0.get(r7), r11, "sticky", r14);
    L44:
        f7943c.a(r7);     // Catch: Exception -> L43
    L12:
        if (r10 == false) goto L14;
        Object r16 = e.a(r7, r15);
        if (r16 == null) goto L20;
        return (T) a(r7, r16, r11, "panel", r14);
    L20:
        if (m == false) goto L25;
        Object r17 = f7943c.a(r7, r15, null, r12, r13);
        if (r17 == null) goto L25;
        return (T) a(r7, r17, r11, "libra", r14);
    L25:
        k r18 = f7942b;
        if (r18 == null) goto L32;
        Object r19 = r18.a(r7, r15, null);
        if (r19 == null) goto L32;
        return (T) a(r7, r19, r11, "setting", r14);
    L32:
        if (m == true) goto L37;
        Object r20 = f7943c.a(r7, r15, null, r12, r13);
        if (r20 == null) goto L37;
        return (T) a(r7, r20, r11, "libra", r14);
    L37:
        Object r21 = f7943c.a(r7, r14, r12);
        if (r21 == null) goto L42;
        return (T) a(r7, r21, r11, "client", r14);
    L42:
        return (T) a(r7, r9, r11, DownloadSettingKeys.BugFix.DEFAULT, r14);
    L14:
        return (T) a(r7, r9, r11, "enable", r14);
    }

    static <T> T a(String r6, T r7, boolean r8, String r9, com.bytedance.dataplatform.b.a<T> r10) {
        if (r8 == false) goto L5;
        if (r7 == null) goto L5;
        f7941a.put(r6, r7);
    L5:
        n.put(r6, r9);
        g r0 = l;
        if (r0 == null) goto L12;
        String r4 = a(r6);
        if (r10 != null) goto L10;
        List<Pair<String, Float>> r11 = null;
    L11:
        r0.a(r6, r7, r9, r4, r11);
        goto L12
    L10:
        r11 = r10.b();
    L12:
        return r7;
    }
}
