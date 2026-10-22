package androidx.navigation;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k.a f3890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3896g;

    public l() {
        this.f3890a = new k.a();
        this.f3893d = -1;
    }

    public final void a(Function1 r10) {
        kotlin.jvm.internal.q.g(r10, "animBuilder");
        a r11 = new a();
        r10.invoke(r11);
        this.f3890a.b(r11.a()).c(r11.b()).e(r11.c()).f(r11.d());
    }

    public final k b() {
        k.a r10 = this.f3890a;
        r10.d(this.f3891b);
        r10.j(this.f3892c);
        String r11 = this.f3894e;
        if (r11 == null) goto L5;
        r10.h(r11, this.f3895f, this.f3896g);
    L7:
        return r10.a();
    L5:
        r10.g(this.f3893d, this.f3895f, this.f3896g);
        goto L7
    }

    public final void c(int r10, Function1 r11) {
        kotlin.jvm.internal.q.g(r11, "popUpToBuilder");
        e(r10);
        f(null);
        q r12 = new q();
        r11.invoke(r12);
        this.f3895f = r12.a();
        this.f3896g = r12.b();
    }

    public final void d(boolean r10) {
        this.f3891b = r10;
    }

    public final void e(int r10) {
        this.f3893d = r10;
        this.f3895f = false;
    }

    public final void f(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (kotlin.text.o.r(r10) == true) goto L7;
        this.f3894e = r10;
        this.f3895f = false;
        return;
    L7:
        throw new IllegalArgumentException("Cannot pop up to an empty route");
    }
}
