package Ic;

import Ic.b;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.widget.ActionBarContextView;

/* loaded from: classes5.dex */
public class i extends b implements c.a {

    /* renamed from: e, reason: collision with root package name */
    public Context f3477e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f3478f;

    /* renamed from: g, reason: collision with root package name */
    public b.InterfaceC0060b f3479g;

    /* renamed from: h, reason: collision with root package name */
    public WeakReference<View> f3480h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3481i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3482j;

    /* renamed from: k, reason: collision with root package name */
    public stepos.support.v7.view.menu.c f3483k;

    public i(Context context, ActionBarContextView actionBarContextView, b.InterfaceC0060b interfaceC0060b, boolean z10) {
        this.f3477e = context;
        this.f3478f = actionBarContextView;
        this.f3479g = interfaceC0060b;
        stepos.support.v7.view.menu.c cVarR = new stepos.support.v7.view.menu.c(actionBarContextView.getContext()).R(1);
        this.f3483k = cVarR;
        cVarR.Q(this);
        this.f3482j = z10;
    }

    @Override // stepos.support.v7.view.menu.c.a
    public void a(stepos.support.v7.view.menu.c cVar) {
        l();
        this.f3478f.u();
    }

    @Override // stepos.support.v7.view.menu.c.a
    public boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
        return this.f3479g.c(this, menuItem);
    }

    @Override // Ic.b
    public void c() {
        if (this.f3481i) {
            return;
        }
        this.f3481i = true;
        this.f3478f.sendAccessibilityEvent(32);
        this.f3479g.a(this);
    }

    @Override // Ic.b
    public View e() {
        WeakReference<View> weakReference = this.f3480h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // Ic.b
    public Menu f() {
        return this.f3483k;
    }

    @Override // Ic.b
    public MenuInflater g() {
        return new k(this.f3478f.getContext());
    }

    @Override // Ic.b
    public CharSequence h() {
        return this.f3478f.getSubtitle();
    }

    @Override // Ic.b
    public CharSequence j() {
        return this.f3478f.getTitle();
    }

    @Override // Ic.b
    public void l() {
        this.f3479g.b(this, this.f3483k);
    }

    @Override // Ic.b
    public boolean n() {
        return this.f3478f.r();
    }

    @Override // Ic.b
    public void p(View view) {
        this.f3478f.setCustomView(view);
        this.f3480h = view != null ? new WeakReference<>(view) : null;
    }

    @Override // Ic.b
    public void q(int i10) {
        r(this.f3477e.getString(i10));
    }

    @Override // Ic.b
    public void r(CharSequence charSequence) {
        this.f3478f.setSubtitle(charSequence);
    }

    @Override // Ic.b
    public void t(int i10) {
        u(this.f3477e.getString(i10));
    }

    @Override // Ic.b
    public void u(CharSequence charSequence) {
        this.f3478f.setTitle(charSequence);
    }

    @Override // Ic.b
    public void v(boolean z10) {
        super.v(z10);
        this.f3478f.setTitleOptional(z10);
    }
}
