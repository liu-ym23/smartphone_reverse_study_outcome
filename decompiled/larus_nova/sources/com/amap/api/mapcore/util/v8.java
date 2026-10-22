package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public abstract class v8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    v8 f28253a;

    public abstract boolean c();

    public int a() {
        v8 r100 = this.f28253a;
        if (r100 == null) goto L5;
        int r101 = r100.a();
    L7:
        return Math.min(Integer.MAX_VALUE, r101);
    L5:
        r101 = Integer.MAX_VALUE;
        goto L7
    }

    public boolean b() {
        v8 r100 = this.f28253a;
        if (r100 == null) goto L5;
        boolean r101 = r100.b();
    L6:
        if (r101 == true) goto L10;
        return false;
    L10:
        return c();
    L5:
        r101 = true;
        goto L6
    }

    public v8() {
    }

    public v8(v8 r100) {
        this.f28253a = r100;
    }

    public void a(int r100) {
        v8 r101 = this.f28253a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public void a(boolean r100) {
        v8 r101 = this.f28253a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
