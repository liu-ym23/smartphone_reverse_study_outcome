package com.amap.api.col.s;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes28.dex */
class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f26013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f26014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f26015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedHashMap<ad.b, Object> f26016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f26017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LinkedHashMap<ad.b, Object> f26018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f26019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<String> f26020i;

    private void a() {
        long r100 = System.currentTimeMillis();
        if (((r100 - this.f26015d) / 1000) <= this.f26013b) goto L6;
        this.f26016e.clear();
        this.f26015d = r100;
        return;
    }

    public ae(String... r100) {
        this.f26012a = true;
        this.f26013b = 86400;
        this.f26014c = 10;
        this.f26015d = 0;
        this.f26016e = new LinkedHashMap();
        this.f26017f = new Object();
        this.f26018g = new LinkedHashMap();
        this.f26019h = new Object();
        this.f26020i = new ArrayList();
        a(r100);
    }

    public final ad.c a(ad.b r100) {
        if (this.f26012a == false) goto L39;
        if (r100 == null) goto L39;
        if (b(r100) == true) goto L9;
        return null;
    L9:
        a();
        Object r101 = this.f26017f;
        monitor-enter(r101);
    L36:
        th = move-exception;
        throw th;
    L12:
        if (a(this.f26016e, r100) == false) goto L16;
        ad.c r102 = new ad.c(b(this.f26016e, r100), true);     // Catch: Throwable -> L36
        monitor-exit(r101);     // Catch: Throwable -> L36
        return r102;
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L36
        Object r103 = this.f26019h;
        monitor-enter(r103);
    L33:
        th = move-exception;
        throw th;
    L20:
        if (a(this.f26018g, r100) == true) goto L22;
        this.f26018g.put(r100, null);     // Catch: Throwable -> L33
    L30:
        monitor-exit(r103);     // Catch: Throwable -> L33
        return new ad.c(b(this.f26016e, r100), false);
    L22:
        if (a(this.f26016e, r100) == true) goto L30;
        if (a(this.f26018g, r100) == false) goto L30;
        this.f26019h.wait(1000);     // Catch: InterruptedException -> L27 Throwable -> L33
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
    L39:
        return null;
    }

    public final boolean b(ad.b r100) {
        if (r100 != null) goto L5;
    L16:
        return false;
    L5:
        if (r100.f26008a == null) goto L16;
        Iterator<String> r101 = this.f26020i.iterator();
    L9:
        if (r101.hasNext() == false) goto L16;
        String r102 = r101.next();
        if (r102 == null) goto L9;
        if (r100.f26008a.contains(r102) == false) goto L9;
        return true;
    }

    private void a(String... r100) {
        this.f26015d = System.currentTimeMillis();
        this.f26016e.clear();
        this.f26020i.clear();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        String r103 = r100[r102];
        if (r103 == null) goto L7;
        this.f26020i.add(r103);
    L7:
        r102 = r102 + 1;
        goto L3
    }

    public void a(ad.a r100) {
        if (r100 == null) goto L5;
        this.f26012a = r100.a();
        this.f26013b = r100.b();
        this.f26014c = r100.c();
        return;
    }

    public final void a(ad.b r100, Object r101) {
        if (this.f26012a == false) goto L36;
        if (r100 != null) goto L7;
        return;
    L7:
        if (b(r100) == true) goto L9;
        return;
    L9:
        Object r102 = this.f26017f;
        monitor-enter(r102);
        int r103 = this.f26016e.size();     // Catch: Throwable -> L33
        if (r103 > 0) goto L14;
    L23:
        a();     // Catch: Throwable -> L33
        this.f26016e.put(r100, r101);     // Catch: Throwable -> L33
        monitor-exit(r102);     // Catch: Throwable -> L33
        Object r104 = this.f26019h;
        monitor-enter(r104);
        c(this.f26018g, r100);     // Catch: Throwable -> L30
        this.f26019h.notify();     // Catch: Throwable -> L30
        monitor-exit(r104);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L14:
        if (r103 < this.f26014c) goto L23;
        Iterator<ad.b> r105 = this.f26016e.keySet().iterator();     // Catch: Throwable -> L33
    L17:
        if (r105.hasNext() == false) goto L21;
        ad.b r106 = r105.next();     // Catch: Throwable -> L33
        if (r106 == null) goto L17;
    L22:
        c(this.f26016e, r106);     // Catch: Throwable -> L33
        goto L23
    L21:
        r106 = null;
    L33:
        th = move-exception;
        throw th;
    }

    public Object b(LinkedHashMap<ad.b, Object> r100, ad.b r101) {
        if (r100 == null) goto L6;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r100.get(r101);
    L6:
        return null;
    }

    public Object c(LinkedHashMap<ad.b, Object> r100, ad.b r101) {
        if (r100 == null) goto L6;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r100.remove(r101);
    L6:
        return null;
    }

    public boolean a(LinkedHashMap<ad.b, Object> r100, ad.b r101) {
        if (r100 == null) goto L6;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r100.containsKey(r101);
    L6:
        return false;
    }
}
