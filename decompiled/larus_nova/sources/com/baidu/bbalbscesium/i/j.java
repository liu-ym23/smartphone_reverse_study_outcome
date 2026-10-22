package com.baidu.bbalbscesium.i;

/* JADX INFO: loaded from: classes39.dex */
class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final boolean f30149b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f30150c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f30151d = 1099511627775L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f30152e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f30153f = 40;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f30154a;

    public j() {
        b r100 = new b(f30153f);
        this.f30154a = r100;
        r100.a(0, f30153f, true);
    }

    public b a() {
        return this.f30154a;
    }

    public void a(b r100, int r101, int r102, int r103) {
        b r104 = this.f30154a.d(r101, r101 + r102);
        if (r103 != 0) goto L5;
        r104.a(r100);
    L12:
        int r105 = 0;
    L13:
        if (r105 >= r102) goto L15;
        this.f30154a.a(r101 + r105, r104.e(r105));
        r105 = r105 + 1;
        goto L13
    L15:
        return;
    L5:
        if (r103 != 2) goto L7;
        r104.b(r100);
        goto L12
    L7:
        if (r103 == 3) goto L9;
        r104.e(r100);
        goto L12
    L9:
        r104.d(r100);
        goto L12
    }

    public byte[] b() {
        return this.f30154a.h();
    }
}
