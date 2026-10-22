package com.bytedance.frameworks.baselib.network.e;

/* JADX INFO: compiled from: QueryActionInfo.java */
/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8066d;

    a() {
        this.f8063a = false;
        this.f8064b = -1;
        this.f8065c = -1;
        this.f8066d = -1;
    }

    public long a() {
        long r0 = this.f8065c;
        if (r0 < 0) goto L11;
        long r4 = this.f8066d;
        if (r4 >= 0) goto L7;
        return -1;
    L7:
        if (r0 <= r4) goto L10;
        return -1;
    L10:
        return r4 - r0;
    L11:
        return -1;
    }

    public boolean b() {
        return this.f8063a;
    }

    public void a(boolean r1) {
        this.f8063a = r1;
    }

    public int c() {
        return this.f8064b;
    }

    public void a(int r1) {
        this.f8064b = r1;
    }

    public void a(long r1) {
        this.f8065c = r1;
    }

    public void b(long r1) {
        this.f8066d = r1;
    }
}
