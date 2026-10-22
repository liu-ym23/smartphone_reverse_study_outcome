package stepos.support.v7.app;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionMenuView;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class q0 extends c {

    /* renamed from: a, reason: collision with root package name */
    public v1 f12452a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12453b;

    /* renamed from: c, reason: collision with root package name */
    public p0 f12454c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12455d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12456e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f12457f;

    /* renamed from: g, reason: collision with root package name */
    public te.i f12458g;

    /* renamed from: h, reason: collision with root package name */
    public androidx.fragment.app.r f12459h;

    @Override // stepos.support.v7.app.c
    public final boolean a() {
        v1 v1Var = this.f12452a;
        if (!v1Var.o()) {
            return false;
        }
        v1Var.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.c
    public final void b(boolean z10) {
        ArrayList arrayList = this.f12457f;
        if (z10 == this.f12456e) {
            return;
        }
        this.f12456e = z10;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        od.f.j();
    }

    @Override // stepos.support.v7.app.c
    public final int c() {
        return this.f12452a.f12872b;
    }

    @Override // stepos.support.v7.app.c
    public final Context d() {
        return this.f12452a.f12871a.getContext();
    }

    @Override // stepos.support.v7.app.c
    public final boolean e() {
        v1 v1Var = this.f12452a;
        Toolbar toolbar = v1Var.f12871a;
        androidx.fragment.app.r rVar = this.f12459h;
        toolbar.removeCallbacks(rVar);
        Toolbar toolbar2 = v1Var.f12871a;
        WeakHashMap weakHashMap = n3.k0.f8724a;
        toolbar2.postOnAnimation(rVar);
        return true;
    }

    @Override // stepos.support.v7.app.c
    public final void g() {
        this.f12452a.f12871a.removeCallbacks(this.f12459h);
    }

    @Override // stepos.support.v7.app.c
    public final boolean h(int i, KeyEvent keyEvent) {
        Menu menuT = t();
        if (menuT != null) {
            menuT.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
            menuT.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    @Override // stepos.support.v7.app.c
    public final void j(boolean z10) {
        u(4, 4);
    }

    @Override // stepos.support.v7.app.c
    public final void k() {
        u(0, 2);
    }

    @Override // stepos.support.v7.app.c
    public final void l() {
        u(8, 8);
    }

    @Override // stepos.support.v7.app.c
    public final void o(CharSequence charSequence) {
        this.f12452a.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.c
    public final void q(CharSequence charSequence) {
        this.f12452a.setWindowTitle(charSequence);
    }

    public final Menu t() {
        v1 v1Var = this.f12452a;
        if (!this.f12455d) {
            l3.d dVar = new l3.d();
            dVar.f7721f = this;
            VarHandle.storeStoreFence();
            f fVar = new f(3);
            fVar.f12315f = this;
            VarHandle.storeStoreFence();
            Toolbar toolbar = v1Var.f12871a;
            toolbar.R = dVar;
            toolbar.S = fVar;
            ActionMenuView actionMenuView = toolbar.f12681c;
            if (actionMenuView != null) {
                actionMenuView.f12607y = dVar;
                actionMenuView.f12608z = fVar;
            }
            this.f12455d = true;
        }
        return v1Var.f12871a.getMenu();
    }

    public final void u(int i, int i3) {
        v1 v1Var = this.f12452a;
        v1Var.q((i & i3) | ((~i3) & v1Var.f12872b));
    }

    @Override // stepos.support.v7.app.c
    public final void i(boolean z10) {
    }

    @Override // stepos.support.v7.app.c
    public final void m(boolean z10) {
    }

    @Override // stepos.support.v7.app.c
    public final void n(boolean z10) {
    }

    @Override // stepos.support.v7.app.c
    public final void f() {
    }
}
