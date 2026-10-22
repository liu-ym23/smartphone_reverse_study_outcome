package stepos.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import h.RunnableC0583a;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.C0814a;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.w0;

/* loaded from: classes2.dex */
public final class c0 extends AbstractC0860e {

    /* renamed from: a, reason: collision with root package name */
    public final w0 f14438a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f14439b;

    /* renamed from: c, reason: collision with root package name */
    public final b0 f14440c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14441d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14442e;

    /* renamed from: g, reason: collision with root package name */
    public L3.h f14444g;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f14443f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final RunnableC0583a f14445h = new RunnableC0583a(29, this);

    public c0(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        a0 a0Var = new a0(this);
        w0 w0Var = new w0(toolbar, false);
        this.f14438a = w0Var;
        w0Var.f15220t = new a0(this);
        b0 b0Var = new b0(this, callback);
        this.f14440c = b0Var;
        w0Var.f15211k = b0Var;
        toolbar.setOnMenuItemClickListener(a0Var);
        w0Var.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final boolean a() {
        w0 w0Var = this.f14438a;
        if (!w0Var.r()) {
            return false;
        }
        w0Var.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void b(boolean z4) {
        if (z4 == this.f14442e) {
            return;
        }
        this.f14442e = z4;
        ArrayList arrayList = this.f14443f;
        if (arrayList.size() <= 0) {
            return;
        }
        B0.g.y(arrayList.get(0));
        throw null;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final int c() {
        return this.f14438a.f15202b;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final Context d() {
        return this.f14438a.f15201a.getContext();
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final boolean f() {
        w0 w0Var = this.f14438a;
        Toolbar toolbar = w0Var.f15201a;
        RunnableC0583a runnableC0583a = this.f14445h;
        toolbar.removeCallbacks(runnableC0583a);
        Toolbar toolbar2 = w0Var.f15201a;
        WeakHashMap weakHashMap = K.S.f939a;
        toolbar2.postOnAnimation(runnableC0583a);
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void g() {
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void h() {
        this.f14438a.f15201a.removeCallbacks(this.f14445h);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final boolean i(int i4, KeyEvent keyEvent) {
        Menu menuW = w();
        if (menuW != null) {
            menuW.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            menuW.performShortcut(i4, keyEvent, 0);
        }
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void j(Drawable drawable) {
        this.f14438a.d(drawable);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void k(boolean z4) {
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void l(boolean z4) {
        int i4 = z4 ? 4 : 0;
        w0 w0Var = this.f14438a;
        w0Var.t((i4 & 4) | (w0Var.f15202b & (-5)));
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void m() {
        w0 w0Var = this.f14438a;
        w0Var.t(w0Var.f15202b & (-3));
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void n() {
        this.f14438a.m();
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void o(boolean z4) {
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void p(boolean z4) {
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void q(int i4) {
        w0 w0Var = this.f14438a;
        w0Var.setTitle(i4 != 0 ? w0Var.f15201a.getContext().getText(i4) : null);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void r(CharSequence charSequence) {
        this.f14438a.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void t(CharSequence charSequence) {
        this.f14438a.setWindowTitle(charSequence);
    }

    public final Menu w() {
        boolean z4 = this.f14441d;
        w0 w0Var = this.f14438a;
        if (!z4) {
            w0Var.H(new C0814a(this), new a0(this, 2));
            this.f14441d = true;
        }
        return w0Var.f15201a.getMenu();
    }
}
