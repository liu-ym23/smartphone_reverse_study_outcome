package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.view.View;
import android.view.ViewGroup;
import com.obric.autoaction.app.launcherpage.detail.base.f;

/* JADX INFO: compiled from: DetailViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z<T extends com.obric.autoaction.app.launcherpage.detail.base.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f23372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f23373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.detail.base.a f23375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private T f23376e;

    public abstract View a(ViewGroup r1);

    public void a() {
    }

    public abstract T b(com.obric.autoaction.app.launcherpage.detail.base.a r1);

    public void b() {
    }

    public void c() {
    }

    public z() {
    }

    public final void a(int r1) {
        this.f23374c = r1;
    }

    public final int d() {
        return this.f23374c;
    }

    public final View e() {
        View r1 = this.f23372a;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("DetailViewContainer view 尚未创建，请先注册到 manager".toString());
    }

    public final com.obric.autoaction.app.launcherpage.detail.base.a getContext() {
        return this.f23375d;
    }

    public final T f() {
        T r0 = this.f23376e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        d.h.b.o.c("data");
        return null;
    }

    public final void b(ViewGroup r2) {
        d.h.b.o.e(r2, "parent");
        if (this.f23372a != null) goto L6;
        this.f23372a = a(r2);
        return;
    }

    public final void c(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        d.h.b.o.e(r2, "ctx");
        this.f23375d = r2;
        T r3 = (T) b(r2);
        this.f23376e = r3;
        this.f23373b = r3;
        a();
        b();
    }

    public final void d(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        d.h.b.o.e(r2, "ctx");
        this.f23375d = r2;
        T r3 = (T) b(r2);
        if (d.h.b.o.a(r3, this.f23373b) == false) goto L5;
        return;
    L5:
        this.f23373b = r3;
        this.f23376e = r3;
        b();
    }

    public final void g() {
        c();
        this.f23375d = null;
    }

    public final void h() {
        g();
        this.f23372a = null;
    }
}
