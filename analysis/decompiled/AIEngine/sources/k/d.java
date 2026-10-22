package k;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionMenuPresenter;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends a implements f.a {

    /* renamed from: c, reason: collision with root package name */
    public Context f9779c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContextView f9780d;

    /* renamed from: e, reason: collision with root package name */
    public AppCompatDelegateImpl.c f9781e;
    public WeakReference<View> h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9782j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.appcompat.view.menu.f f9783k;

    @Override // androidx.appcompat.view.menu.f.a
    public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        return this.f9781e.f299a.b(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final void b(androidx.appcompat.view.menu.f fVar) {
        i();
        ActionMenuPresenter actionMenuPresenter = this.f9780d.f740d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.l();
        }
    }

    @Override // k.a
    public final void c() {
        if (this.f9782j) {
            return;
        }
        this.f9782j = true;
        this.f9781e.a(this);
    }

    @Override // k.a
    public final View d() {
        WeakReference<View> weakReference = this.h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // k.a
    public final androidx.appcompat.view.menu.f e() {
        return this.f9783k;
    }

    @Override // k.a
    public final MenuInflater f() {
        return new f(this.f9780d.getContext());
    }

    @Override // k.a
    public final CharSequence g() {
        return this.f9780d.getSubtitle();
    }

    @Override // k.a
    public final CharSequence h() {
        return this.f9780d.getTitle();
    }

    @Override // k.a
    public final void i() {
        this.f9781e.b(this, this.f9783k);
    }

    @Override // k.a
    public final boolean j() {
        return this.f9780d.f570v;
    }

    @Override // k.a
    public final void k(View view) {
        this.f9780d.setCustomView(view);
        this.h = view != null ? new WeakReference<>(view) : null;
    }

    @Override // k.a
    public final void l(int i10) {
        m(this.f9779c.getString(i10));
    }

    @Override // k.a
    public final void m(CharSequence charSequence) {
        this.f9780d.setSubtitle(charSequence);
    }

    @Override // k.a
    public final void n(int i10) {
        o(this.f9779c.getString(i10));
    }

    @Override // k.a
    public final void o(CharSequence charSequence) {
        this.f9780d.setTitle(charSequence);
    }

    @Override // k.a
    public final void p(boolean z) {
        this.f9772b = z;
        this.f9780d.setTitleOptional(z);
    }
}
