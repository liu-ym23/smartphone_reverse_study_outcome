package b5;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import b5.b;
import java.lang.ref.WeakReference;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.widget.ActionBarContextView;

/* loaded from: classes.dex */
public class i extends b implements d.a {

    /* renamed from: e, reason: collision with root package name */
    private Context f11880e;

    /* renamed from: f, reason: collision with root package name */
    private ActionBarContextView f11881f;

    /* renamed from: g, reason: collision with root package name */
    private b.InterfaceC0154b f11882g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<View> f11883h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f11884i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11885j;

    /* renamed from: k, reason: collision with root package name */
    private stepos.support.v7.view.menu.d f11886k;

    public i(Context context, ActionBarContextView actionBarContextView, b.InterfaceC0154b interfaceC0154b, boolean z5) {
        this.f11880e = context;
        this.f11881f = actionBarContextView;
        this.f11882g = interfaceC0154b;
        stepos.support.v7.view.menu.d dVarR = new stepos.support.v7.view.menu.d(actionBarContextView.getContext()).R(1);
        this.f11886k = dVarR;
        dVarR.Q(this);
        this.f11885j = z5;
    }

    @Override // b5.b
    public void a() {
        if (this.f11884i) {
            return;
        }
        this.f11884i = true;
        this.f11881f.sendAccessibilityEvent(32);
        this.f11882g.c(this);
    }

    @Override // stepos.support.v7.view.menu.d.a
    public boolean c(stepos.support.v7.view.menu.d dVar, MenuItem menuItem) {
        return this.f11882g.a(this, menuItem);
    }

    @Override // stepos.support.v7.view.menu.d.a
    public void d(stepos.support.v7.view.menu.d dVar) {
        l();
        this.f11881f.u();
    }

    @Override // b5.b
    public View e() {
        WeakReference<View> weakReference = this.f11883h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // b5.b
    public Menu f() {
        return this.f11886k;
    }

    @Override // b5.b
    public MenuInflater g() {
        return new k(this.f11881f.getContext());
    }

    @Override // b5.b
    public CharSequence h() {
        return this.f11881f.getSubtitle();
    }

    @Override // b5.b
    public CharSequence j() {
        return this.f11881f.getTitle();
    }

    @Override // b5.b
    public void l() {
        this.f11882g.b(this, this.f11886k);
    }

    @Override // b5.b
    public boolean n() {
        return this.f11881f.r();
    }

    @Override // b5.b
    public void p(View view) {
        this.f11881f.setCustomView(view);
        this.f11883h = view != null ? new WeakReference<>(view) : null;
    }

    @Override // b5.b
    public void q(int i5) {
        r(this.f11880e.getString(i5));
    }

    @Override // b5.b
    public void r(CharSequence charSequence) {
        this.f11881f.setSubtitle(charSequence);
    }

    @Override // b5.b
    public void t(int i5) {
        u(this.f11880e.getString(i5));
    }

    @Override // b5.b
    public void u(CharSequence charSequence) {
        this.f11881f.setTitle(charSequence);
    }

    @Override // b5.b
    public void v(boolean z5) {
        super.v(z5);
        this.f11881f.setTitleOptional(z5);
    }
}
