package h;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 extends k.a implements l.j {

    /* renamed from: g, reason: collision with root package name */
    public Context f4856g;

    /* renamed from: h, reason: collision with root package name */
    public l.l f4857h;
    public p5.l i;

    /* renamed from: j, reason: collision with root package name */
    public WeakReference f4858j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ o0 f4859k;

    @Override // k.a
    public final void a() {
        o0 o0Var = this.f4859k;
        if (o0Var.i != this) {
            return;
        }
        if (o0Var.f4876p) {
            o0Var.f4870j = this;
            o0Var.f4871k = this.i;
        } else {
            this.i.n(this);
        }
        this.i = null;
        o0Var.a(false);
        ActionBarContextView actionBarContextView = o0Var.f4867f;
        if (actionBarContextView.f761o == null) {
            actionBarContextView.e();
        }
        o0Var.f4864c.setHideOnContentScrollEnabled(o0Var.f4881u);
        o0Var.i = null;
    }

    @Override // k.a
    public final View b() {
        WeakReference weakReference = this.f4858j;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // k.a
    public final l.l c() {
        return this.f4857h;
    }

    @Override // k.a
    public final MenuInflater d() {
        return new k.i(this.f4856g);
    }

    @Override // k.a
    public final CharSequence e() {
        return this.f4859k.f4867f.getSubtitle();
    }

    @Override // l.j
    public final void f(l.l lVar) {
        if (this.i == null) {
            return;
        }
        h();
        m.k kVar = this.f4859k.f4867f.f755h;
        if (kVar != null) {
            kVar.l();
        }
    }

    @Override // k.a
    public final CharSequence g() {
        return this.f4859k.f4867f.getTitle();
    }

    @Override // k.a
    public final void h() {
        l.l lVar = this.f4857h;
        if (this.f4859k.i != this) {
            return;
        }
        lVar.w();
        try {
            this.i.p(this, lVar);
        } finally {
            lVar.v();
        }
    }

    @Override // k.a
    public final boolean i() {
        return this.f4859k.f4867f.f769w;
    }

    @Override // l.j
    public final boolean j(l.l lVar, MenuItem menuItem) {
        p5.l lVar2 = this.i;
        if (lVar2 != null) {
            return ((k.e) lVar2.f9738c).g(this, menuItem);
        }
        return false;
    }

    @Override // k.a
    public final void k(View view) {
        this.f4859k.f4867f.setCustomView(view);
        this.f4858j = new WeakReference(view);
    }

    @Override // k.a
    public final void l(int i) {
        m(this.f4859k.f4862a.getResources().getString(i));
    }

    @Override // k.a
    public final void m(CharSequence charSequence) {
        this.f4859k.f4867f.setSubtitle(charSequence);
    }

    @Override // k.a
    public final void n(int i) {
        o(this.f4859k.f4862a.getResources().getString(i));
    }

    @Override // k.a
    public final void o(CharSequence charSequence) {
        this.f4859k.f4867f.setTitle(charSequence);
    }

    @Override // k.a
    public final void p(boolean z10) {
        this.f6798f = z10;
        this.f4859k.f4867f.setTitleOptional(z10);
    }
}
