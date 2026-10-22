package Ua;

import Va.l;
import Va.n;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import fa.C1449a;
import java.lang.ref.WeakReference;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.C2005u;

/* loaded from: classes4.dex */
public final class g extends c implements l {
    public Context d;
    public ActionBarContextView e;
    public C1449a f;
    public WeakReference g;
    public boolean h;
    public n i;

    @Override // Ua.c
    public final void a() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.e.sendAccessibilityEvent(32);
        this.f.d((c) this);
    }

    @Override // Ua.c
    public final View b() {
        WeakReference weakReference = this.g;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // Ua.c
    public final n c() {
        return this.i;
    }

    @Override // Ua.c
    public final k d() {
        return new k(this.e.getContext());
    }

    @Override // Va.l
    public final boolean e(n nVar, MenuItem menuItem) {
        return ((b) this.f.b).f(this, menuItem);
    }

    @Override // Ua.c
    public final CharSequence f() {
        return this.e.getSubtitle();
    }

    @Override // Ua.c
    public final CharSequence g() {
        return this.e.getTitle();
    }

    @Override // Ua.c
    public final void h() {
        this.f.b(this, this.i);
    }

    @Override // Ua.c
    public final boolean i() {
        return this.e.u;
    }

    @Override // Ua.c
    public final void j(View view) {
        this.e.setCustomView(view);
        this.g = view != null ? new WeakReference(view) : null;
    }

    @Override // Va.l
    public final void k(n nVar) {
        h();
        C2005u c2005u = this.e.d;
        if (c2005u != null) {
            c2005u.m();
        }
    }

    @Override // Ua.c
    public final void l(int i) {
        m(this.d.getString(i));
    }

    @Override // Ua.c
    public final void m(CharSequence charSequence) {
        this.e.setSubtitle(charSequence);
    }

    @Override // Ua.c
    public final void n(int i) {
        o(this.d.getString(i));
    }

    @Override // Ua.c
    public final void o(CharSequence charSequence) {
        this.e.setTitle(charSequence);
    }

    @Override // Ua.c
    public final void p(boolean z10) {
        this.b = z10;
        this.e.setTitleOptional(z10);
    }
}
