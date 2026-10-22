package i;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import i.AbstractC4156b;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends AbstractC4156b implements e.a {

    /* renamed from: c, reason: collision with root package name */
    public Context f32996c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContextView f32997d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC4156b.a f32998e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<View> f32999f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f33000g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f33001h;

    /* renamed from: i, reason: collision with root package name */
    public androidx.appcompat.view.menu.e f33002i;

    public e(Context context, ActionBarContextView actionBarContextView, AbstractC4156b.a aVar, boolean z10) {
        this.f32996c = context;
        this.f32997d = actionBarContextView;
        this.f32998e = aVar;
        androidx.appcompat.view.menu.e eVarX = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).X(1);
        this.f33002i = eVarX;
        eVarX.W(this);
        this.f33001h = z10;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f32998e.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f32997d.l();
    }

    @Override // i.AbstractC4156b
    public void c() {
        if (this.f33000g) {
            return;
        }
        this.f33000g = true;
        this.f32998e.b(this);
    }

    @Override // i.AbstractC4156b
    public View d() {
        WeakReference<View> weakReference = this.f32999f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // i.AbstractC4156b
    public Menu e() {
        return this.f33002i;
    }

    @Override // i.AbstractC4156b
    public MenuInflater f() {
        return new g(this.f32997d.getContext());
    }

    @Override // i.AbstractC4156b
    public CharSequence g() {
        return this.f32997d.getSubtitle();
    }

    @Override // i.AbstractC4156b
    public CharSequence i() {
        return this.f32997d.getTitle();
    }

    @Override // i.AbstractC4156b
    public void k() {
        this.f32998e.c(this, this.f33002i);
    }

    @Override // i.AbstractC4156b
    public boolean l() {
        return this.f32997d.j();
    }

    @Override // i.AbstractC4156b
    public void m(View view) {
        this.f32997d.setCustomView(view);
        this.f32999f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // i.AbstractC4156b
    public void n(int i10) {
        o(this.f32996c.getString(i10));
    }

    @Override // i.AbstractC4156b
    public void o(CharSequence charSequence) {
        this.f32997d.setSubtitle(charSequence);
    }

    @Override // i.AbstractC4156b
    public void q(int i10) {
        r(this.f32996c.getString(i10));
    }

    @Override // i.AbstractC4156b
    public void r(CharSequence charSequence) {
        this.f32997d.setTitle(charSequence);
    }

    @Override // i.AbstractC4156b
    public void s(boolean z10) {
        super.s(z10);
        this.f32997d.setTitleOptional(z10);
    }
}
