package bz0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k implements yy0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f21853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f21854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f21856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f21857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f21858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f21859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f21860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f21861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f21862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f21863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f21864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f21865m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f21866n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Boolean f21867o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f21868p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f21869q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f21870r;

    public k() {
    }

    @Override // yy0.h
    public final void a(int r100) {
        this.f21870r = Integer.valueOf(r100);
    }

    @Override // yy0.h
    public final void b(int r100) {
        if (r100 != 17) goto L5;
        String r101 = "center";
    L9:
        this.f21855c = r101;
        return;
    L5:
        if (r100 == 80) goto L7;
        r101 = "other";
        goto L9
    L7:
        r101 = "bottom";
        goto L9
    }

    @Override // yy0.h
    public final void c(boolean r100) {
        this.f21866n = Boolean.valueOf(r100);
    }

    @Override // yy0.h
    public final void d(int r100) {
        this.f21868p = Integer.valueOf(r100);
    }

    @Override // yy0.h
    public final void e(int r100) {
        this.f21869q = Integer.valueOf(r100);
    }

    @Override // yy0.h
    public final void f(boolean r100) {
        this.f21862j = Boolean.valueOf(r100);
    }

    @Override // yy0.h
    public final void g(boolean r100) {
        this.f21865m = Boolean.valueOf(r100);
    }

    @Override // yy0.h
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f21863k = r100;
    }

    @Override // yy0.h
    public final void i(int r100) {
        this.f21861i = Integer.valueOf(r100);
    }

    @Override // yy0.h
    public final void j(boolean r100) {
        this.f21867o = Boolean.valueOf(r100);
    }

    @Override // yy0.h
    public final void k(int r100) {
        this.f21854b = Integer.valueOf(r100);
    }

    @Override // yy0.h
    public final void l(boolean r100) {
        this.f21860h = Boolean.valueOf(r100);
    }

    @Override // yy0.h
    public final void n(boolean r100) {
        this.f21864l = Boolean.valueOf(r100);
    }

    @Override // yy0.h
    public final void o(int r100) {
        this.f21853a = Integer.valueOf(r100);
    }

    @Override // yy0.h
    public final void m(int r100, int r101, int r102, int r103) {
        this.f21856d = Integer.valueOf(r100);
        this.f21857e = Integer.valueOf(r101);
        this.f21858f = Integer.valueOf(r102);
        this.f21859g = Integer.valueOf(r103);
    }
}
