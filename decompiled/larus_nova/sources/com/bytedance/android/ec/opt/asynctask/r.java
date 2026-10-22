package com.bytedance.android.ec.opt.asynctask;

/* JADX INFO: loaded from: classes44.dex */
public final class r implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f48046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f48047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f48049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f48050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.ec.opt.asynctask.a f48051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x f48052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f48053h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.opt.asynctask.i
    public final String name() {
        return "Django";
    }

    @Override // com.bytedance.android.ec.opt.asynctask.i
    public final i parent() {
        return this;
    }

    @Override // com.bytedance.android.ec.opt.asynctask.i
    public final s a() {
        if (this.f48046a == false) goto L6;
        return this.f48050e;
    L6:
        if (this.f48047b == false) goto L9;
        return this.f48051f;
    L9:
        if (this.f48048c == false) goto L12;
        return this.f48052g;
    L12:
        if (this.f48049d == false) goto L16;
        return this.f48053h;
    L16:
        throw new IllegalArgumentException();
    }

    public r() {
        this.f48050e = new u(this);
        this.f48051f = new com.bytedance.android.ec.opt.asynctask.a(this);
        this.f48052g = new x(this);
        this.f48053h = new o(this);
    }
}
