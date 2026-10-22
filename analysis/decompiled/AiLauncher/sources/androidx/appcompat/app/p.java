package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.A;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Y;
import androidx.core.view.N;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class p extends androidx.appcompat.app.a {

    /* renamed from: a, reason: collision with root package name */
    public final A f8453a;

    /* renamed from: b, reason: collision with root package name */
    public final Window.Callback f8454b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatDelegateImpl.g f8455c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8456d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8457e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8458f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<a.b> f8459g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f8460h = new a();

    /* renamed from: i, reason: collision with root package name */
    public final Toolbar.h f8461i;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.y();
        }
    }

    public class b implements Toolbar.h {
        public b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.h
        public boolean onMenuItemClick(MenuItem menuItem) {
            return p.this.f8454b.onMenuItemSelected(0, menuItem);
        }
    }

    public final class c implements i.a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f8464a;

        public c() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z10) {
            if (this.f8464a) {
                return;
            }
            this.f8464a = true;
            p.this.f8453a.p();
            p.this.f8454b.onPanelClosed(108, eVar);
            this.f8464a = false;
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            p.this.f8454b.onMenuOpened(108, eVar);
            return true;
        }
    }

    public final class d implements e.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (p.this.f8453a.d()) {
                p.this.f8454b.onPanelClosed(108, eVar);
            } else if (p.this.f8454b.onPreparePanel(0, null, eVar)) {
                p.this.f8454b.onMenuOpened(108, eVar);
            }
        }
    }

    public class e implements AppCompatDelegateImpl.g {
        public e() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public boolean a(int i10) {
            if (i10 != 0) {
                return false;
            }
            p pVar = p.this;
            if (pVar.f8456d) {
                return false;
            }
            pVar.f8453a.e();
            p.this.f8456d = true;
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public View onCreatePanelView(int i10) {
            if (i10 == 0) {
                return new View(p.this.f8453a.getContext());
            }
            return null;
        }
    }

    public p(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f8461i = bVar;
        B0.h.f(toolbar);
        Y y10 = new Y(toolbar, false);
        this.f8453a = y10;
        this.f8454b = (Window.Callback) B0.h.f(callback);
        y10.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        y10.setWindowTitle(charSequence);
        this.f8455c = new e();
    }

    @Override // androidx.appcompat.app.a
    public boolean f() {
        return this.f8453a.b();
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        if (!this.f8453a.g()) {
            return false;
        }
        this.f8453a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void h(boolean z10) {
        if (z10 == this.f8458f) {
            return;
        }
        this.f8458f = z10;
        int size = this.f8459g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f8459g.get(i10).a(z10);
        }
    }

    @Override // androidx.appcompat.app.a
    public int i() {
        return this.f8453a.s();
    }

    @Override // androidx.appcompat.app.a
    public Context j() {
        return this.f8453a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public void k() {
        this.f8453a.w(8);
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.f8453a.l().removeCallbacks(this.f8460h);
        N.Z(this.f8453a.l(), this.f8460h);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // androidx.appcompat.app.a
    public void n() {
        this.f8453a.l().removeCallbacks(this.f8460h);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i10, KeyEvent keyEvent) {
        Menu menuX = x();
        if (menuX == null) {
            return false;
        }
        menuX.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuX.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.f8453a.c();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z10) {
        z(z10 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z10) {
        z(z10 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.f8453a.setWindowTitle(charSequence);
    }

    public final Menu x() {
        if (!this.f8457e) {
            this.f8453a.v(new c(), new d());
            this.f8457e = true;
        }
        return this.f8453a.i();
    }

    public void y() {
        Menu menuX = x();
        androidx.appcompat.view.menu.e eVar = menuX instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menuX : null;
        if (eVar != null) {
            eVar.i0();
        }
        try {
            menuX.clear();
            if (!this.f8454b.onCreatePanelMenu(0, menuX) || !this.f8454b.onPreparePanel(0, null, menuX)) {
                menuX.clear();
            }
            if (eVar != null) {
                eVar.h0();
            }
        } catch (Throwable th) {
            if (eVar != null) {
                eVar.h0();
            }
            throw th;
        }
    }

    public void z(int i10, int i11) {
        this.f8453a.h((i10 & i11) | ((~i11) & this.f8453a.s()));
    }
}
