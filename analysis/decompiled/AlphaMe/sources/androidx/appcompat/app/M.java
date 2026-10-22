package androidx.appcompat.app;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0217o;
import j.AbstractC0624c;
import j.InterfaceC0623b;
import java.lang.ref.WeakReference;
import k.C0661o;
import k.InterfaceC0659m;

/* loaded from: classes.dex */
public final class M extends AbstractC0624c implements InterfaceC0659m {

    /* renamed from: c, reason: collision with root package name */
    public final Context f2552c;

    /* renamed from: d, reason: collision with root package name */
    public final C0661o f2553d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0623b f2554e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f2555f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ N f2556g;

    public M(N n4, Context context, u uVar) {
        this.f2556g = n4;
        this.f2552c = context;
        this.f2554e = uVar;
        C0661o c0661o = new C0661o(context);
        c0661o.f13249l = 1;
        this.f2553d = c0661o;
        c0661o.f13242e = this;
    }

    @Override // j.AbstractC0624c
    public final void a() {
        N n4 = this.f2556g;
        if (n4.f2567j != this) {
            return;
        }
        if (n4.f2574q) {
            n4.f2568k = this;
            n4.f2569l = this.f2554e;
        } else {
            this.f2554e.f(this);
        }
        this.f2554e = null;
        n4.d0(false);
        ActionBarContextView actionBarContextView = n4.f2564g;
        if (actionBarContextView.f2744k == null) {
            actionBarContextView.e();
        }
        n4.f2561d.setHideOnContentScrollEnabled(n4.f2579v);
        n4.f2567j = null;
    }

    @Override // j.AbstractC0624c
    public final View b() {
        WeakReference weakReference = this.f2555f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // j.AbstractC0624c
    public final Menu c() {
        return this.f2553d;
    }

    @Override // j.AbstractC0624c
    public final MenuInflater d() {
        return new j.k(this.f2552c);
    }

    @Override // j.AbstractC0624c
    public final CharSequence e() {
        return this.f2556g.f2564g.getSubtitle();
    }

    @Override // j.AbstractC0624c
    public final CharSequence f() {
        return this.f2556g.f2564g.getTitle();
    }

    @Override // j.AbstractC0624c
    public final void g() {
        if (this.f2556g.f2567j != this) {
            return;
        }
        C0661o c0661o = this.f2553d;
        c0661o.w();
        try {
            this.f2554e.g(this, c0661o);
        } finally {
            c0661o.v();
        }
    }

    @Override // j.AbstractC0624c
    public final boolean h() {
        return this.f2556g.f2564g.f2752s;
    }

    @Override // k.InterfaceC0659m
    public final boolean i(C0661o c0661o, MenuItem menuItem) {
        InterfaceC0623b interfaceC0623b = this.f2554e;
        if (interfaceC0623b != null) {
            return interfaceC0623b.a(this, menuItem);
        }
        return false;
    }

    @Override // j.AbstractC0624c
    public final void j(View view) {
        this.f2556g.f2564g.setCustomView(view);
        this.f2555f = new WeakReference(view);
    }

    @Override // j.AbstractC0624c
    public final void k(int i4) {
        l(this.f2556g.f2559b.getResources().getString(i4));
    }

    @Override // j.AbstractC0624c
    public final void l(CharSequence charSequence) {
        this.f2556g.f2564g.setSubtitle(charSequence);
    }

    @Override // j.AbstractC0624c
    public final void m(int i4) {
        o(this.f2556g.f2559b.getResources().getString(i4));
    }

    @Override // k.InterfaceC0659m
    public final void n(C0661o c0661o) {
        if (this.f2554e == null) {
            return;
        }
        g();
        C0217o c0217o = this.f2556g.f2564g.f2737d;
        if (c0217o != null) {
            c0217o.l();
        }
    }

    @Override // j.AbstractC0624c
    public final void o(CharSequence charSequence) {
        this.f2556g.f2564g.setTitle(charSequence);
    }

    @Override // j.AbstractC0624c
    public final void p(boolean z4) {
        this.f13048b = z4;
        this.f2556g.f2564g.setTitleOptional(z4);
    }
}
