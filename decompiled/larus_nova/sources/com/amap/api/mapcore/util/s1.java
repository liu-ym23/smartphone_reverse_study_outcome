package com.amap.api.mapcore.util;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class s1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile s1 f27943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b7 f27944c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27945a;

    private boolean a() {
        if (f27944c != null) goto L11;
        Context r100 = this.f27945a;
        b7 r101 = new b7(r100, r1.a());     // Catch: Throwable -> L7
    L9:
        f27944c = r101;
    L7:
        th = move-exception;
        t6.a(th, "OfflineDB", "getDB");
        th.printStackTrace();
        r101 = null;
    L11:
        if (f27944c != null) goto L14;
        return false;
    L14:
        return true;
    }

    public ArrayList<n1> b() {
        ArrayList<n1> r100 = new ArrayList();
        if (a() == true) goto L5;
        return r100;
    L5:
        Iterator r101 = ((ArrayList) f27944c.b("", n1.class)).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r100.add((n1) r101.next());
        goto L7
    L9:
        return r100;
    }

    private s1(Context r100) {
        this.f27945a = r100;
        f27944c = a(r100);
    }

    public synchronized void a(n1 r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (a() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        f27944c.a(q1.a(r100.f27877c), q1.class);     // Catch: Throwable -> L10
        f27944c.a(p1.a(r100.f27877c), p1.class);     // Catch: Throwable -> L10
        f27944c.a(o1.a(r100.f27877c), o1.class);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public synchronized void b(n1 r100) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (a() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        String r101 = q1.a(r100.f27877c);     // Catch: Throwable -> L20
        f27944c.a(r100, r101);     // Catch: Throwable -> L20
        String r102 = r100.f();     // Catch: Throwable -> L20
        String r103 = r100.f27877c;     // Catch: Throwable -> L20
        if (r102 != null) goto L10;
    L18:
        monitor-exit(this);
        return;
    L10:
        if (r102.length() <= 0) goto L18;
        String r104 = p1.a(r103);     // Catch: Throwable -> L20
        if (((ArrayList) f27944c.b(r104, p1.class)).size() <= 0) goto L14;
        f27944c.a(r104, p1.class);     // Catch: Throwable -> L20
    L14:
        String[] r105 = r102.split(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L20
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L20
        int r107 = r105.length;     // Catch: Throwable -> L20
        int r108 = 0;
    L15:
        if (r108 >= r107) goto L17;
        r106.add(new p1(r103, r105[r108]));     // Catch: Throwable -> L20
        r108 = r108 + 1;     // Catch: Throwable -> L20
        goto L15
    L17:
        f27944c.a(r106);     // Catch: Throwable -> L20
        goto L18
    }

    public synchronized n1 c(String r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (a() == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        String r101 = q1.a(r100);     // Catch: Throwable -> L15
        ArrayList r102 = (ArrayList) f27944c.b(r101, n1.class);     // Catch: Throwable -> L15
        if (r102.size() <= 0) goto L13;
        n1 r103 = (n1) ListProtector.get(r102, 0);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r103;
    L13:
        monitor-exit(this);
        return null;
    }

    public synchronized String d(String r100) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        String r101 = null;
        if (a() == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        String r102 = q1.a(r100);     // Catch: Throwable -> L13
        ArrayList r103 = (ArrayList) f27944c.b(r102, q1.class);     // Catch: Throwable -> L13
        if (r103.size() <= 0) goto L11;
        r101 = ((q1) ListProtector.get(r103, 0)).f27879e;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r101;
    }

    public synchronized void a(String r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (a() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        f27944c.a(q1.a(r100), q1.class);     // Catch: Throwable -> L10
        f27944c.a(p1.a(r100), p1.class);     // Catch: Throwable -> L10
        f27944c.a(o1.a(r100), o1.class);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public synchronized List<String> b(String r100) {
        monitor-enter(this);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L16
        if (a() == true) goto L7;
        monitor-exit(this);
        return r101;
    L7:
        String r102 = p1.a(r100);     // Catch: Throwable -> L16
        List r103 = f27944c.b(r102, p1.class);     // Catch: Throwable -> L16
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L16
        ArrayList r105 = (ArrayList) r103;     // Catch: Throwable -> L16
        if (r105.size() <= 0) goto L13;
        Iterator r106 = r105.iterator();     // Catch: Throwable -> L16
    L11:
        if (r106.hasNext() == false) goto L13;
        r104.add(((p1) r106.next()).a());     // Catch: Throwable -> L16
    L13:
        r101.addAll(r104);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r101;
    L16:
        th = move-exception;
        throw th;
    }

    private b7 a(Context r100) {
        return new b7(r100, r1.a());
    L4:
        th = move-exception;
        t6.a(th, "OfflineDB", "getDB");
        th.printStackTrace();
        return null;
    }

    public static s1 b(Context r100) {
        if (f27943b != null) goto L15;
        monitor-enter(s1.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f27943b != null) goto L9;
        f27943b = new s1(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(s1.class);     // Catch: Throwable -> L11
    L15:
        return f27943b;
    }

    public void a(String r110, int r111, long r112, long r113, long r210) {
        if (a() == true) goto L5;
        return;
    L5:
        long[] r100 = {r113, 0, 0, 0, 0};
        long[] r101 = {r210, 0, 0, 0, 0};
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (a() == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        f27944c.a(new o1(r110, r112, r111, r100[0], r101[0]), o1.a(r110));     // Catch: Throwable -> L14
        monitor-exit(this);
    }
}
