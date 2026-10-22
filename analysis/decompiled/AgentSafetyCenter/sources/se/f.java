package se;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.q;
import te.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class f extends b implements te.j {

    /* renamed from: h, reason: collision with root package name */
    public Context f12222h;
    public ActionBarContextView i;

    /* renamed from: j, reason: collision with root package name */
    public p5.c f12223j;

    /* renamed from: k, reason: collision with root package name */
    public WeakReference f12224k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12225l;

    /* renamed from: m, reason: collision with root package name */
    public l f12226m;

    @Override // se.b
    public final void a() {
        if (this.f12225l) {
            return;
        }
        this.f12225l = true;
        this.i.sendAccessibilityEvent(32);
        this.f12223j.e(this);
    }

    @Override // se.b
    public final View b() {
        WeakReference weakReference = this.f12224k;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // te.j
    public final boolean c(l lVar, MenuItem menuItem) {
        return ((a) this.f12223j.f9717f).d(this, menuItem);
    }

    @Override // te.j
    public final void d(l lVar) {
        i();
        q qVar = this.i.f12711h;
        if (qVar != null) {
            qVar.o();
        }
    }

    @Override // se.b
    public final l e() {
        return this.f12226m;
    }

    @Override // se.b
    public final j f() {
        return new j(this.i.getContext());
    }

    @Override // se.b
    public final CharSequence g() {
        return this.i.getSubtitle();
    }

    @Override // se.b
    public final CharSequence h() {
        return this.i.getTitle();
    }

    @Override // se.b
    public final void i() {
        this.f12223j.b(this, this.f12226m);
    }

    @Override // se.b
    public final boolean j() {
        return this.i.f12573y;
    }

    @Override // se.b
    public final void k(View view) {
        this.i.setCustomView(view);
        this.f12224k = view != null ? new WeakReference(view) : null;
    }

    @Override // se.b
    public final void l(int i) {
        m(this.f12222h.getString(i));
    }

    @Override // se.b
    public final void m(CharSequence charSequence) {
        this.i.setSubtitle(charSequence);
    }

    @Override // se.b
    public final void n(int i) {
        o(this.f12222h.getString(i));
    }

    @Override // se.b
    public final void o(CharSequence charSequence) {
        this.i.setTitle(charSequence);
    }

    @Override // se.b
    public final void p(boolean z10) {
        this.f12199f = z10;
        this.i.setTitleOptional(z10);
    }
}
