package com.bytedance.ttnet.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.j;
import com.bytedance.frameworks.baselib.network.http.i.f;
import com.bytedance.retrofit2.ab;
import com.bytedance.retrofit2.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: RetrofitUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String TAG = "RetrofitUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<com.bytedance.retrofit2.d.b> f11533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile List<com.bytedance.retrofit2.d.b> f11534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f<String, ab> f11535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static f<String, ab> f11536d;

    public d() {
    }

    public static String a(List<com.bytedance.retrofit2.b.b> r3, String r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L24;
        Iterator r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L16;
        com.bytedance.retrofit2.b.b r0 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r6.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");
        if (r4.equalsIgnoreCase(r0.a()) == false) goto L11;
        return r0.b();
    L16:
        return "";
    L24:
        return null;
    }

    public static Pair<String, String> a(String r3) {
        String r0 = null;
        if (r3 != null) goto L17;
        return null;
    L17:
        com.bytedance.frameworks.baselib.network.http.f.b r1 = new com.bytedance.frameworks.baselib.network.http.f.b(r3);     // Catch: Throwable -> L10
        String r4 = r1.b();     // Catch: Throwable -> L10
        r0 = r1.a("charset");     // Catch: Throwable -> L8
    L14:
        return new Pair(r4, r0);
    L8:
        th = th;
    L12:
        th.printStackTrace();
    L10:
        th = th;
        r4 = null;
        goto L12
    }

    static {
        f11533a = new CopyOnWriteArrayList();
        ab.a(f11533a);
        f11535c = new f(10);
        f11536d = new f(10);
    }

    public static synchronized void a(com.bytedance.retrofit2.d.b r3) {
        monitor-enter(d.class);
        com.bytedance.retrofit2.d.b r4 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r4 != null) goto L9;
        monitor-exit(d.class);
        return;
    L9:
        if (f11533a.contains(r4) == true) goto L11;
        f11533a.add(r4);     // Catch: Throwable -> L14
        b();     // Catch: Throwable -> L14
    L11:
        e.a(f11535c, r4);     // Catch: Throwable -> L14
        e.a(f11536d, r4);     // Catch: Throwable -> L14
        monitor-exit(d.class);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(com.bytedance.retrofit2.d.b r3) {
        monitor-enter(d.class);
        com.bytedance.retrofit2.d.b r4 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r4 != null) goto L9;
        monitor-exit(d.class);
        return;
    L9:
        if (f11533a.contains(r4) == true) goto L12;
        monitor-exit(d.class);
        return;
    L12:
        f11533a.remove(r4);     // Catch: Throwable -> L15
        b();     // Catch: Throwable -> L15
        e.b(f11535c, r4);     // Catch: Throwable -> L15
        e.b(f11536d, r4);     // Catch: Throwable -> L15
        monitor-exit(d.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized ab b(String r5) {
        monitor-enter(d.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (j.a(r5) == false) goto L9;
        monitor-exit(d.class);
        return null;
    L9:
        ab r1 = (ab) ZeusTransformUtils.preCheckCast(f11535c.a(r5), ab.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        monitor-exit(d.class);
        return r1;
    L13:
        ab r2 = a(r5, null, null, null);     // Catch: Throwable -> L16
        f11535c.a(r5, r2);     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r2;
    }

    public static List<com.bytedance.retrofit2.d.b> c(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        String r0 = d(r2);
        if (TextUtils.isEmpty(r0) == true) goto L10;
        r2 = r0;
    L10:
        ab r3 = e(r2);
        if (r3 == null) goto L18;
        List<com.bytedance.retrofit2.d.b> r4 = r3.c();
        if (r4 == null) goto L16;
        return r4;
    L16:
        return a();
    L18:
        return a();
    L5:
        return a();
    }

    private static String d(String r2) {
        URI r3 = com.bytedance.frameworks.baselib.network.http.i.j.a(r2);     // Catch: Throwable -> L12
        if (r3 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3.getScheme()) == false) goto L7;
        String r0 = "https";
    L8:
        String r4 = r3.getRawAuthority();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r4) == true) goto L18;
        return r0 + "://" + r4 + "/";
    L18:
        return null;
    L7:
        r0 = r3.getScheme();     // Catch: Throwable -> L12
    L12:
        Logger.w(TAG, "url invalid");
        return null;
    }

    private static ab e(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L16;
        f<String, ab> r0 = f11535c;
        if (r0 == null) goto L18;
        ab r1 = (ab) ZeusTransformUtils.preCheckCast(r0.a(r3), ab.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        return r1;
    L11:
        if (r3.endsWith("/") == false) goto L13;
        String r4 = r3.substring(0, r3.length() - 1);
    L15:
        return (ab) ZeusTransformUtils.preCheckCast(f11535c.a(r4), ab.class, "com.obric.aiagent.plugin");
    L13:
        r4 = r3 + "/";
        goto L15
    L18:
        return null;
    L16:
        return null;
    }

    private static List<com.bytedance.retrofit2.d.b> a() {
        List<com.bytedance.retrofit2.d.b> r0 = f11534b;
        if (r0 != null) goto L15;
        monitor-enter(d.class);
        r0 = f11534b;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = c();     // Catch: Throwable -> L11
        f11534b = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return new ArrayList(r0);
    }

    private static void b() {
        f11534b = null;
    }

    private static List<com.bytedance.retrofit2.d.b> c() {
        if (f11533a != null) goto L5;
        int r0 = 0;
    L6:
        ArrayList r1 = new ArrayList(r0 + 2);
        r1.add(new com.bytedance.ttnet.h.c());
        if (r0 <= 0) goto L9;
        r1.addAll(f11533a);
    L9:
        r1.add(new com.bytedance.frameworks.baselib.network.http.g.b());
        return r1;
    L5:
        r0 = f11533a.size();
        goto L6
    }

    public static synchronized ab a(String r3, List<com.bytedance.retrofit2.d.b> r4, i.a r5, com.bytedance.retrofit2.f.a r6) {
        monitor-enter(d.class);
        ab r7 = a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), r5, r6, new AnonymousClass1());     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized ab a(String r3, List<com.bytedance.retrofit2.d.b> r4, i.a r5, com.bytedance.retrofit2.f.a r6, com.bytedance.retrofit2.b.a.InterfaceC0216a r7) {
        monitor-enter(d.class);
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        com.bytedance.retrofit2.b.a.InterfaceC0216a r9 = (com.bytedance.retrofit2.b.a.InterfaceC0216a) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.retrofit2.b.a.InterfaceC0216a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        ArrayList r1 = null;
        if (r5 == null) goto L7;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L13
        r2.add(r5);     // Catch: Throwable -> L13
    L8:
        if (r6 == null) goto L10;
        r1 = new ArrayList();     // Catch: Throwable -> L13
        r1.add(r6);     // Catch: Throwable -> L13
    L10:
        ab r10 = a(r8, r2, r1, r9, r3);     // Catch: Throwable -> L13
        monitor-exit(d.class);
        return r10;
    L7:
        r2 = null;
    L13:
        th = move-exception;
        throw th;
    }

    public static synchronized ab a(List<com.bytedance.retrofit2.d.b> r4, List<i.a> r5, List<com.bytedance.retrofit2.f.a> r6, com.bytedance.retrofit2.b.a.InterfaceC0216a r7, String r8) {
        monitor-enter(d.class);
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        com.bytedance.retrofit2.b.a.InterfaceC0216a r12 = (com.bytedance.retrofit2.b.a.InterfaceC0216a) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.retrofit2.b.a.InterfaceC0216a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r12 != null) goto L7;
        r12 = new AnonymousClass2();     // Catch: Throwable -> L54
    L7:
        ab.a r13 = new ab.a().a(r8).a(r12).a(new com.bytedance.frameworks.baselib.network.http.g.c());     // Catch: Throwable -> L54
        if (r10 != null) goto L11;
        r10 = new ArrayList();     // Catch: Throwable -> L54
    L11:
        if (r10.isEmpty() == false) goto L13;
        r10.add(com.bytedance.frameworks.baselib.network.http.g.a.a.a.a());     // Catch: Throwable -> L54
    L13:
        Iterator r14 = r10.iterator();     // Catch: Throwable -> L54
    L15:
        if (r14.hasNext() == false) goto L17;
        r13.a((i.a) ZeusTransformUtils.preCheckCast(r14.next(), i.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L54
        goto L15
    L17:
        if (r11 != null) goto L19;
    L24:
        LinkedList r15 = new LinkedList();     // Catch: Throwable -> L54
        if (r9 != null) goto L27;
    L39:
        boolean r16 = false;
    L40:
        if (r16 == true) goto L43;
        r15.add(0, new com.bytedance.ttnet.h.c());     // Catch: Throwable -> L54
    L43:
        if (f11533a != null) goto L45;
    L47:
        r15.add(new com.bytedance.frameworks.baselib.network.http.g.b());     // Catch: Throwable -> L54
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L54
    L49:
        if (r17.hasNext() == false) goto L51;
        r13.a((com.bytedance.retrofit2.d.b) ZeusTransformUtils.preCheckCast(r17.next(), com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L54
        goto L49
    L51:
        ab r18 = r13.a();     // Catch: Throwable -> L54
        monitor-exit(d.class);
        return r18;
    L45:
        if (f11533a.size() <= 0) goto L47;
        r15.addAll(f11533a);     // Catch: Throwable -> L54
        goto L47
    L27:
        if (r9.size() <= 0) goto L39;
        Iterator r19 = r9.iterator();     // Catch: Throwable -> L54
        r16 = false;
    L30:
        if (r19.hasNext() == false) goto L40;
        com.bytedance.retrofit2.d.b r1 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.preCheckCast(r19.next(), com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.ttnet.h.c.class) == true) goto L33;
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.frameworks.baselib.network.http.g.b.class) == true) goto L30;
    L38:
        r15.add(r1);     // Catch: Throwable -> L54
        goto L30
    L33:
        if (r16 == true) goto L30;
        r15.add(r1);     // Catch: Throwable -> L54
        r16 = true;
        goto L38
    L19:
        if (r11.isEmpty() == true) goto L24;
        Iterator r20 = r11.iterator();     // Catch: Throwable -> L54
    L22:
        if (r20.hasNext() == false) goto L24;
        r13.a((com.bytedance.retrofit2.f.a) ZeusTransformUtils.preCheckCast(r20.next(), com.bytedance.retrofit2.f.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S a(String r1, Class<S> r2) {
        monitor-enter(d.class);
        S r3 = (S) a(b(r1), r2);
        monitor-exit(d.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S a(ab r1, Class<S> r2) {
        monitor-enter(d.class);
        if (r1 == null) goto L12;
        S r3 = (S) r1.a(r2);
        monitor-exit(d.class);
        return r3;
    L8:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(d.class);
        return null;
    }
}
