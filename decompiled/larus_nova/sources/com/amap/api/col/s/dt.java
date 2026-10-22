package com.amap.api.col.s;

/* JADX INFO: loaded from: classes28.dex */
public abstract class dt {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    dt f26596c;

    public abstract boolean a();

    public int b() {
        dt r100 = this.f26596c;
        if (r100 == null) goto L5;
        int r101 = r100.b();
    L7:
        return Math.min(Integer.MAX_VALUE, r101);
    L5:
        r101 = Integer.MAX_VALUE;
        goto L7
    }

    public final boolean c() {
        dt r100 = this.f26596c;
        if (r100 == null) goto L5;
        boolean r101 = r100.c();
    L6:
        if (r101 == true) goto L10;
        return false;
    L10:
        return a();
    L5:
        r101 = true;
        goto L6
    }

    public dt() {
    }

    public dt(dt r100) {
        this.f26596c = r100;
    }

    public void a(int r100) {
        dt r101 = this.f26596c;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public void a(boolean r100) {
        dt r101 = this.f26596c;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
