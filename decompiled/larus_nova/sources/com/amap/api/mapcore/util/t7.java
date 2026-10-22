package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public class t7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private v7 f28013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y7 f28014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f28015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f28016d;

    public interface a {
        void onDownload(byte[] r100, long r101);

        void onException(Throwable r100);

        void onFinish();

        void onStop();
    }

    public void a() {
        v7 r100 = this.f28013a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public t7(y7 r100) {
        this(r100, 0, -1);
    }

    public void a(a r100) {
        v7 r101 = new v7();     // Catch: Throwable -> L8
        this.f28013a = r101;     // Catch: Throwable -> L8
        r101.b(this.f28016d);     // Catch: Throwable -> L8
        this.f28013a.a(this.f28015c);     // Catch: Throwable -> L8
        if (r7.a().c(this.f28014b) == false) goto L6;
        this.f28014b.setDegradeType(y7.b.f28459c);     // Catch: Throwable -> L8
        this.f28013a.a(this.f28014b, r100);     // Catch: Throwable -> L8
        return;
    L6:
        this.f28014b.setDegradeType(y7.b.f28461e);     // Catch: Throwable -> L8
        this.f28013a.a(this.f28014b, r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        r100.onException(th);
    }

    public t7(y7 r100, long r101, long r110) {
        this(r100, r101, r110, false);
    }

    public t7(y7 r100, long r101, long r102, boolean r103) {
        this.f28014b = r100;
        this.f28015c = r101;
        this.f28016d = r102;
        if (r103 == false) goto L5;
        y7.c r104 = y7.c.f28468b;
    L6:
        r100.setHttpProtocol(r104);
        this.f28014b.setDegradeAbility(y7.a.f28456e);
        return;
    L5:
        r104 = y7.c.f28467a;
        goto L6
    }
}
