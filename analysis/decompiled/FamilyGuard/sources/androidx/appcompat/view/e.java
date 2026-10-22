package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements e.a {

    /* renamed from: c, reason: collision with root package name */
    private Context f7715c;

    /* renamed from: d, reason: collision with root package name */
    private ActionBarContextView f7716d;

    /* renamed from: e, reason: collision with root package name */
    private b.a f7717e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<View> f7718f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7719g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7720h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.appcompat.view.menu.e f7721i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z5) {
        this.f7715c = context;
        this.f7716d = actionBarContextView;
        this.f7717e = aVar;
        androidx.appcompat.view.menu.e eVarT = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).T(1);
        this.f7721i = eVarT;
        eVarT.S(this);
        this.f7720h = z5;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f7717e.d(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f7716d.l();
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f7719g) {
            return;
        }
        this.f7719g = true;
        this.f7717e.a(this);
    }

    @Override // androidx.appcompat.view.b
    public View d() {
        WeakReference<View> weakReference = this.f7718f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public Menu e() {
        return this.f7721i;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater f() {
        return new g(this.f7716d.getContext());
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f7716d.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence i() {
        return this.f7716d.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public void k() {
        this.f7717e.c(this, this.f7721i);
    }

    @Override // androidx.appcompat.view.b
    public boolean l() {
        return this.f7716d.j();
    }

    @Override // androidx.appcompat.view.b
    public void m(View view) {
        this.f7716d.setCustomView(view);
        this.f7718f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void n(int i5) {
        o(this.f7715c.getString(i5));
    }

    @Override // androidx.appcompat.view.b
    public void o(CharSequence charSequence) {
        this.f7716d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void q(int i5) {
        r(this.f7715c.getString(i5));
    }

    @Override // androidx.appcompat.view.b
    public void r(CharSequence charSequence) {
        this.f7716d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void s(boolean z5) {
        super.s(z5);
        this.f7716d.setTitleOptional(z5);
    }
}
