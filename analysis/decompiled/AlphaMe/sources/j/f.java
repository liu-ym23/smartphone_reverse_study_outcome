package j;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0217o;
import java.lang.ref.WeakReference;
import k.C0661o;
import k.InterfaceC0659m;

/* loaded from: classes.dex */
public final class f extends AbstractC0624c implements InterfaceC0659m {

    /* renamed from: c, reason: collision with root package name */
    public Context f13053c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContextView f13054d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0623b f13055e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f13056f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13057g;

    /* renamed from: h, reason: collision with root package name */
    public C0661o f13058h;

    @Override // j.AbstractC0624c
    public final void a() {
        if (this.f13057g) {
            return;
        }
        this.f13057g = true;
        this.f13055e.f(this);
    }

    @Override // j.AbstractC0624c
    public final View b() {
        WeakReference weakReference = this.f13056f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // j.AbstractC0624c
    public final Menu c() {
        return this.f13058h;
    }

    @Override // j.AbstractC0624c
    public final MenuInflater d() {
        return new k(this.f13054d.getContext());
    }

    @Override // j.AbstractC0624c
    public final CharSequence e() {
        return this.f13054d.getSubtitle();
    }

    @Override // j.AbstractC0624c
    public final CharSequence f() {
        return this.f13054d.getTitle();
    }

    @Override // j.AbstractC0624c
    public final void g() {
        this.f13055e.g(this, this.f13058h);
    }

    @Override // j.AbstractC0624c
    public final boolean h() {
        return this.f13054d.f2752s;
    }

    @Override // k.InterfaceC0659m
    public final boolean i(C0661o c0661o, MenuItem menuItem) {
        return this.f13055e.a(this, menuItem);
    }

    @Override // j.AbstractC0624c
    public final void j(View view) {
        this.f13054d.setCustomView(view);
        this.f13056f = view != null ? new WeakReference(view) : null;
    }

    @Override // j.AbstractC0624c
    public final void k(int i4) {
        l(this.f13053c.getString(i4));
    }

    @Override // j.AbstractC0624c
    public final void l(CharSequence charSequence) {
        this.f13054d.setSubtitle(charSequence);
    }

    @Override // j.AbstractC0624c
    public final void m(int i4) {
        o(this.f13053c.getString(i4));
    }

    @Override // k.InterfaceC0659m
    public final void n(C0661o c0661o) {
        g();
        C0217o c0217o = this.f13054d.f2737d;
        if (c0217o != null) {
            c0217o.l();
        }
    }

    @Override // j.AbstractC0624c
    public final void o(CharSequence charSequence) {
        this.f13054d.setTitle(charSequence);
    }

    @Override // j.AbstractC0624c
    public final void p(boolean z4) {
        this.f13048b = z4;
        this.f13054d.setTitleOptional(z4);
    }
}
