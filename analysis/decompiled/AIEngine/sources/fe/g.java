package fe;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import stepos.support.v7.app.AppCompatDelegateImplV7;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionMenuPresenter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends b implements c.a {

    /* renamed from: d, reason: collision with root package name */
    public Context f8877d;

    /* renamed from: e, reason: collision with root package name */
    public ActionBarContextView f8878e;

    /* renamed from: f, reason: collision with root package name */
    public AppCompatDelegateImplV7.e f8879f;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference<View> f8880g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public stepos.support.v7.view.menu.c f8881i;

    @Override // stepos.support.v7.view.menu.c.a
    public final void a(stepos.support.v7.view.menu.c cVar) {
        i();
        ActionMenuPresenter actionMenuPresenter = this.f8878e.f12689d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.o();
        }
    }

    @Override // stepos.support.v7.view.menu.c.a
    public final boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
        return this.f8879f.f12018a.a(this, menuItem);
    }

    @Override // fe.b
    public final void c() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.f8878e.sendAccessibilityEvent(32);
        this.f8879f.b(this);
    }

    @Override // fe.b
    public final View d() {
        WeakReference<View> weakReference = this.f8880g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // fe.b
    public final stepos.support.v7.view.menu.c e() {
        return this.f8881i;
    }

    @Override // fe.b
    public final i f() {
        return new i(this.f8878e.getContext());
    }

    @Override // fe.b
    public final CharSequence g() {
        return this.f8878e.getSubtitle();
    }

    @Override // fe.b
    public final CharSequence h() {
        return this.f8878e.getTitle();
    }

    @Override // fe.b
    public final void i() {
        this.f8879f.c(this, this.f8881i);
    }

    @Override // fe.b
    public final boolean j() {
        return this.f8878e.f12455x;
    }

    @Override // fe.b
    public final void k(View view) {
        this.f8878e.setCustomView(view);
        this.f8880g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // fe.b
    public final void l(int i10) {
        m(this.f8877d.getString(i10));
    }

    @Override // fe.b
    public final void m(CharSequence charSequence) {
        this.f8878e.setSubtitle(charSequence);
    }

    @Override // fe.b
    public final void n(int i10) {
        o(this.f8877d.getString(i10));
    }

    @Override // fe.b
    public final void o(CharSequence charSequence) {
        this.f8878e.setTitle(charSequence);
    }

    @Override // fe.b
    public final void p(boolean z) {
        this.f8852b = z;
        this.f8878e.setTitleOptional(z);
    }
}
