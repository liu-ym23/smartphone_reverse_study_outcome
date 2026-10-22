package com.bytedance.android.window.shop;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, c> f187761b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f187762c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f187763d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f187764e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f187765f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f187766g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f187767a;

    public static final class a {
        public static c a(int r100) {
            ConcurrentHashMap<Integer, c> r101 = c.f187761b;
            c r102 = r101.get(Integer.valueOf(r100));
            if (r102 != null) goto L6;
            c r103 = new c(r100);
            r101.put(Integer.valueOf(r100), r103);
            return r103;
        L6:
            return r102;
        }
    }

    static {
        f187761b = new ConcurrentHashMap();
        f187762c = a.a(100);
        f187763d = a.a(200);
        f187764e = a.a(300);
        f187765f = a.a(400);
        f187766g = a.a(500);
    }

    public final int getType() {
        return this.f187767a;
    }

    public c(int r100) {
        this.f187767a = r100;
    }
}
