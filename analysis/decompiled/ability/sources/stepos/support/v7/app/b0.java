package stepos.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import androidx.core.view.ViewCompat;
import h2.RunnableC1484b;
import java.util.ArrayList;
import stepos.support.v7.widget.ActionMenuView;
import stepos.support.v7.widget.G0;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes4.dex */
public final class b0 extends AbstractC1955d {

    /* renamed from: a, reason: collision with root package name */
    public final G0 f6292a;
    public boolean b;
    public final a0 c;
    public boolean d;
    public boolean e;
    public Va.k g;
    public final ArrayList f = new ArrayList();
    public final RunnableC1484b h = new RunnableC1484b(this, 4);

    public b0(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        a5.d dVar = new a5.d(this, 7);
        G0 g02 = new G0(toolbar, false);
        this.f6292a = g02;
        g02.f6467t = new C1973w(this, 4);
        a0 a0Var = new a0(this, callback);
        this.c = a0Var;
        g02.k = a0Var;
        toolbar.setOnMenuItemClickListener(dVar);
        g02.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final boolean a() {
        G0 g02 = this.f6292a;
        if (!g02.hasExpandedActionView()) {
            return false;
        }
        g02.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void b(boolean z10) {
        if (z10 == this.e) {
            return;
        }
        this.e = z10;
        ArrayList arrayList = this.f;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final int c() {
        return this.f6292a.b;
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final Context d() {
        return this.f6292a.f6462a.getContext();
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final boolean e() {
        G0 g02 = this.f6292a;
        Toolbar toolbar = g02.f6462a;
        RunnableC1484b runnableC1484b = this.h;
        toolbar.removeCallbacks(runnableC1484b);
        ViewCompat.postOnAnimation(g02.f6462a, runnableC1484b);
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void f() {
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void g() {
        this.f6292a.f6462a.removeCallbacks(this.h);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final boolean h(int i, KeyEvent keyEvent) {
        Menu menuV = v();
        if (menuV != null) {
            menuV.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
            menuV.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void i(boolean z10) {
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void j(boolean z10) {
        w(4, 4);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void k() {
        w(0, 2);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void l() {
        w(8, 8);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void m(int i) {
        this.f6292a.setNavigationContentDescription(i);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void n(Drawable drawable) {
        this.f6292a.setNavigationIcon(drawable);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void o(boolean z10) {
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void p(boolean z10) {
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void q(CharSequence charSequence) {
        this.f6292a.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void s(CharSequence charSequence) {
        this.f6292a.setWindowTitle(charSequence);
    }

    public final Menu v() {
        boolean z10 = this.d;
        G0 g02 = this.f6292a;
        if (!z10) {
            C4.a aVar = new C4.a(this);
            h2.d dVar = new h2.d(this);
            Toolbar toolbar = g02.f6462a;
            toolbar.f6573R = aVar;
            toolbar.f6574S = dVar;
            ActionMenuView actionMenuView = toolbar.f6579a;
            if (actionMenuView != null) {
                actionMenuView.f = aVar;
                actionMenuView.g = dVar;
            }
            this.d = true;
        }
        return g02.f6462a.getMenu();
    }

    public final void w(int i, int i6) {
        G0 g02 = this.f6292a;
        g02.setDisplayOptions((i & i6) | ((~i6) & g02.b));
    }
}
