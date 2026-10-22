package k;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends a implements l.j {

    /* renamed from: g, reason: collision with root package name */
    public Context f6805g;

    /* renamed from: h, reason: collision with root package name */
    public ActionBarContextView f6806h;
    public p5.l i;

    /* renamed from: j, reason: collision with root package name */
    public WeakReference f6807j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6808k;

    /* renamed from: l, reason: collision with root package name */
    public l.l f6809l;

    @Override // k.a
    public final void a() {
        if (this.f6808k) {
            return;
        }
        this.f6808k = true;
        this.i.n(this);
    }

    @Override // k.a
    public final View b() {
        WeakReference weakReference = this.f6807j;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // k.a
    public final l.l c() {
        return this.f6809l;
    }

    @Override // k.a
    public final MenuInflater d() {
        return new i(this.f6806h.getContext());
    }

    @Override // k.a
    public final CharSequence e() {
        return this.f6806h.getSubtitle();
    }

    @Override // l.j
    public final void f(l.l lVar) {
        h();
        m.k kVar = this.f6806h.f755h;
        if (kVar != null) {
            kVar.l();
        }
    }

    @Override // k.a
    public final CharSequence g() {
        return this.f6806h.getTitle();
    }

    @Override // k.a
    public final void h() {
        this.i.p(this, this.f6809l);
    }

    @Override // k.a
    public final boolean i() {
        return this.f6806h.f769w;
    }

    @Override // l.j
    public final boolean j(l.l lVar, MenuItem menuItem) {
        return ((e) this.i.f9738c).g(this, menuItem);
    }

    @Override // k.a
    public final void k(View view) {
        this.f6806h.setCustomView(view);
        this.f6807j = view != null ? new WeakReference(view) : null;
    }

    @Override // k.a
    public final void l(int i) {
        m(this.f6805g.getString(i));
    }

    @Override // k.a
    public final void m(CharSequence charSequence) {
        this.f6806h.setSubtitle(charSequence);
    }

    @Override // k.a
    public final void n(int i) {
        o(this.f6805g.getString(i));
    }

    @Override // k.a
    public final void o(CharSequence charSequence) {
        this.f6806h.setTitle(charSequence);
    }

    @Override // k.a
    public final void p(boolean z10) {
        this.f6798f = z10;
        this.f6806h.setTitleOptional(z10);
    }
}
