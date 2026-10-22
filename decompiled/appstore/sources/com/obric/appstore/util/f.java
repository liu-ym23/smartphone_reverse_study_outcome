package com.obric.appstore.util;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f11074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f11075c;

    public f(long r10) {
        this.f11073a = r10;
        this.f11075c = new e(this);
    }

    public static /* synthetic */ void a(f r10) {
        c(r10);
    }

    public static final void c(f r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f11074b = null;
    }

    public final Object b() {
        return this.f11074b;
    }

    public final void d(Object r10) {
        this.f11074b = r10;
        k r11 = k.f11081a;
        r11.d().removeCallbacks(this.f11075c);
        r11.d().postDelayed(this.f11075c, this.f11073a);
    }
}
