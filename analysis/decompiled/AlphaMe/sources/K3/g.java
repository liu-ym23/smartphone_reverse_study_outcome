package K3;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.C0897q;

/* loaded from: classes2.dex */
public final class g extends c implements L3.i {

    /* renamed from: d, reason: collision with root package name */
    public Context f1084d;

    /* renamed from: e, reason: collision with root package name */
    public ActionBarContextView f1085e;

    /* renamed from: f, reason: collision with root package name */
    public b f1086f;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference f1087g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1088h;

    /* renamed from: i, reason: collision with root package name */
    public L3.k f1089i;

    @Override // K3.c
    public final void a() {
        if (this.f1088h) {
            return;
        }
        this.f1088h = true;
        this.f1085e.sendAccessibilityEvent(32);
        this.f1086f.e(this);
    }

    @Override // L3.i
    public final boolean b(L3.k kVar, MenuItem menuItem) {
        return this.f1086f.d(this, menuItem);
    }

    @Override // L3.i
    public final void c(L3.k kVar) {
        i();
        C0897q c0897q = this.f1085e.f15055d;
        if (c0897q != null) {
            c0897q.o();
        }
    }

    @Override // K3.c
    public final View d() {
        WeakReference weakReference = this.f1087g;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // K3.c
    public final Menu e() {
        return this.f1089i;
    }

    @Override // K3.c
    public final MenuInflater f() {
        return new k(this.f1085e.getContext());
    }

    @Override // K3.c
    public final CharSequence g() {
        return this.f1085e.getSubtitle();
    }

    @Override // K3.c
    public final CharSequence h() {
        return this.f1085e.getTitle();
    }

    @Override // K3.c
    public final void i() {
        this.f1086f.h(this, this.f1089i);
    }

    @Override // K3.c
    public final boolean j() {
        return this.f1085e.f14723u;
    }

    @Override // K3.c
    public final void k(View view) {
        this.f1085e.setCustomView(view);
        this.f1087g = view != null ? new WeakReference(view) : null;
    }

    @Override // K3.c
    public final void l(int i4) {
        m(this.f1084d.getString(i4));
    }

    @Override // K3.c
    public final void m(CharSequence charSequence) {
        this.f1085e.setSubtitle(charSequence);
    }

    @Override // K3.c
    public final void n(int i4) {
        o(this.f1084d.getString(i4));
    }

    @Override // K3.c
    public final void o(CharSequence charSequence) {
        this.f1085e.setTitle(charSequence);
    }

    @Override // K3.c
    public final void p(boolean z4) {
        this.f1050b = z4;
        this.f1085e.setTitleOptional(z4);
    }
}
