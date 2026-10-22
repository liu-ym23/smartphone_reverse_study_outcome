package stepos.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.view.H;
import g.C0728a;
import java.util.ArrayList;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.widget.A;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
class t extends stepos.support.v7.app.a {

    /* renamed from: f, reason: collision with root package name */
    private stepos.support.v7.widget.m f21094f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f21095g;

    /* renamed from: h, reason: collision with root package name */
    private Window.Callback f21096h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f21097i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f21098j;

    /* renamed from: l, reason: collision with root package name */
    private stepos.support.v7.view.menu.c f21100l;

    /* renamed from: n, reason: collision with root package name */
    private final Toolbar.g f21102n;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<a.f> f21099k = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f21101m = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.e0();
        }
    }

    class b implements Toolbar.g {
        b() {
        }

        @Override // stepos.support.v7.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            return t.this.f21096h.onMenuItemSelected(0, menuItem);
        }
    }

    class c implements a.c {
        c() {
        }

        @Override // stepos.support.v7.app.a.c
        public void a(int i5, a.InterfaceC0240a interfaceC0240a) {
            t.this.A(i5, interfaceC0240a);
        }
    }

    private final class d implements h.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f21106a;

        private d() {
        }

        @Override // stepos.support.v7.view.menu.h.a
        public void a(stepos.support.v7.view.menu.d dVar, boolean z5) {
            if (this.f21106a) {
                return;
            }
            this.f21106a = true;
            t.this.f21094f.h();
            if (t.this.f21096h != null) {
                t.this.f21096h.onPanelClosed(108, dVar);
            }
            this.f21106a = false;
        }

        @Override // stepos.support.v7.view.menu.h.a
        public boolean b(stepos.support.v7.view.menu.d dVar) {
            if (t.this.f21096h == null) {
                return false;
            }
            t.this.f21096h.onMenuOpened(108, dVar);
            return true;
        }

        /* synthetic */ d(t tVar, a aVar) {
            this();
        }
    }

    private final class e implements d.a {
        private e() {
        }

        @Override // stepos.support.v7.view.menu.d.a
        public boolean c(stepos.support.v7.view.menu.d dVar, MenuItem menuItem) {
            return false;
        }

        @Override // stepos.support.v7.view.menu.d.a
        public void d(stepos.support.v7.view.menu.d dVar) {
            if (t.this.f21096h != null) {
                if (t.this.f21094f.a()) {
                    t.this.f21096h.onPanelClosed(108, dVar);
                } else if (t.this.f21096h.onPreparePanel(0, null, dVar)) {
                    t.this.f21096h.onMenuOpened(108, dVar);
                }
            }
        }

        /* synthetic */ e(t tVar, a aVar) {
            this();
        }
    }

    private final class f implements h.a {
        private f() {
        }

        @Override // stepos.support.v7.view.menu.h.a
        public void a(stepos.support.v7.view.menu.d dVar, boolean z5) {
            if (t.this.f21096h != null) {
                t.this.f21096h.onPanelClosed(0, dVar);
            }
        }

        @Override // stepos.support.v7.view.menu.h.a
        public boolean b(stepos.support.v7.view.menu.d dVar) {
            if (dVar != null || t.this.f21096h == null) {
                return true;
            }
            t.this.f21096h.onMenuOpened(0, dVar);
            return true;
        }

        /* synthetic */ f(t tVar, a aVar) {
            this();
        }
    }

    private class g extends b5.l {
        public g(Window.Callback callback) {
            super(callback);
        }

        @Override // b5.l, android.view.Window.Callback
        public View onCreatePanelView(int i5) {
            if (i5 == 0) {
                Menu menuG = t.this.f21094f.G();
                if (onPreparePanel(i5, null, menuG) && onMenuOpened(i5, menuG)) {
                    return t.this.b0(menuG);
                }
            }
            return super.onCreatePanelView(i5);
        }

        @Override // b5.l, android.view.Window.Callback
        public boolean onPreparePanel(int i5, View view, Menu menu) {
            boolean zOnPreparePanel = super.onPreparePanel(i5, view, menu);
            if (zOnPreparePanel && !t.this.f21095g) {
                t.this.f21094f.b();
                t.this.f21095g = true;
            }
            return zOnPreparePanel;
        }
    }

    public t(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f21102n = bVar;
        A a6 = new A(toolbar, false);
        this.f21094f = a6;
        a6.D(new c());
        g gVar = new g(callback);
        this.f21096h = gVar;
        this.f21094f.setWindowCallback(gVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.f21094f.setWindowTitle(charSequence);
    }

    private void a0(Menu menu) {
        if (this.f21100l == null && (menu instanceof stepos.support.v7.view.menu.d)) {
            stepos.support.v7.view.menu.d dVar = (stepos.support.v7.view.menu.d) menu;
            Context context = this.f21094f.getContext();
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(C0728a.f16824a, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 != 0) {
                themeNewTheme.applyStyle(i5, true);
            }
            themeNewTheme.resolveAttribute(C0728a.f16813J, typedValue, true);
            int i6 = typedValue.resourceId;
            if (i6 != 0) {
                themeNewTheme.applyStyle(i6, true);
            } else {
                themeNewTheme.applyStyle(g.i.f16978c, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(themeNewTheme);
            stepos.support.v7.view.menu.c cVar = new stepos.support.v7.view.menu.c(contextThemeWrapper, X4.h.f6044p);
            this.f21100l = cVar;
            cVar.k(new f(this, null));
            dVar.b(this.f21100l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View b0(Menu menu) {
        stepos.support.v7.view.menu.c cVar;
        a0(menu);
        if (menu == null || (cVar = this.f21100l) == null || cVar.i().getCount() <= 0) {
            return null;
        }
        return (View) this.f21100l.j(this.f21094f.K());
    }

    private Menu c0() {
        if (!this.f21097i) {
            a aVar = null;
            this.f21094f.x(new d(this, aVar), new e(this, aVar));
            this.f21097i = true;
        }
        return this.f21094f.G();
    }

    @Override // stepos.support.v7.app.a
    public void B(View view) {
        C(view, new a.e(-2, -2));
    }

    @Override // stepos.support.v7.app.a
    public void C(View view, a.e eVar) {
        if (view != null) {
            view.setLayoutParams(eVar);
        }
        this.f21094f.O(view);
    }

    @Override // stepos.support.v7.app.a
    public void D(boolean z5) {
    }

    @Override // stepos.support.v7.app.a
    public void E(boolean z5) {
        f0(z5 ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.a
    public void F(boolean z5) {
        f0(z5 ? 64 : 0, 64);
        if (z5) {
            return;
        }
        g();
    }

    @Override // stepos.support.v7.app.a
    public void G(boolean z5) {
        f0(z5 ? 16 : 0, 16);
    }

    @Override // stepos.support.v7.app.a
    public void H(boolean z5) {
        f0(z5 ? 2 : 0, 2);
    }

    @Override // stepos.support.v7.app.a
    public void I(boolean z5) {
        f0(z5 ? 32 : 0, 32);
    }

    @Override // stepos.support.v7.app.a
    public void J(boolean z5) {
        f0(z5 ? 8 : 0, 8);
    }

    @Override // stepos.support.v7.app.a
    public void K(boolean z5) {
    }

    @Override // stepos.support.v7.app.a
    public void L(int i5) {
        if (i5 == 2) {
            throw new IllegalArgumentException("Tabs not supported in this configuration");
        }
        this.f21094f.J(i5);
    }

    @Override // stepos.support.v7.app.a
    public void M(boolean z5) {
    }

    @Override // stepos.support.v7.app.a
    public void N(Drawable drawable) {
    }

    @Override // stepos.support.v7.app.a
    public void O(int i5, float f5, int i6) {
    }

    @Override // stepos.support.v7.app.a
    public void P(int i5) {
        stepos.support.v7.widget.m mVar = this.f21094f;
        mVar.setTitle(i5 != 0 ? mVar.getContext().getText(i5) : null);
    }

    @Override // stepos.support.v7.app.a
    public void Q(CharSequence charSequence) {
        this.f21094f.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public void S(CharSequence charSequence) {
        this.f21094f.setWindowTitle(charSequence);
    }

    public Window.Callback d0() {
        return this.f21096h;
    }

    void e0() {
        Menu menuC0 = c0();
        stepos.support.v7.view.menu.d dVar = menuC0 instanceof stepos.support.v7.view.menu.d ? (stepos.support.v7.view.menu.d) menuC0 : null;
        if (dVar != null) {
            dVar.b0();
        }
        try {
            menuC0.clear();
            if (!this.f21096h.onCreatePanelMenu(0, menuC0) || !this.f21096h.onPreparePanel(0, null, menuC0)) {
                menuC0.clear();
            }
            if (dVar != null) {
                dVar.a0();
            }
        } catch (Throwable th) {
            if (dVar != null) {
                dVar.a0();
            }
            throw th;
        }
    }

    @Override // stepos.support.v7.app.a
    public void f(a.i iVar) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void f0(int i5, int i6) {
        this.f21094f.j((i5 & i6) | ((~i6) & this.f21094f.p()));
    }

    @Override // stepos.support.v7.app.a
    public boolean h() {
        if (!this.f21094f.i()) {
            return false;
        }
        this.f21094f.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.a
    public void k(boolean z5) {
        if (z5 == this.f21098j) {
            return;
        }
        this.f21098j = z5;
        int size = this.f21099k.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f21099k.get(i5).a(z5);
        }
    }

    @Override // stepos.support.v7.app.a
    public View l() {
        return this.f21094f.w();
    }

    @Override // stepos.support.v7.app.a
    public int m() {
        return this.f21094f.p();
    }

    @Override // stepos.support.v7.app.a
    public a.i n(int i5) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // stepos.support.v7.app.a
    public Context o() {
        return this.f21094f.getContext();
    }

    @Override // stepos.support.v7.app.a
    public void q() {
        this.f21094f.n(8);
    }

    @Override // stepos.support.v7.app.a
    public boolean r() {
        this.f21094f.K().removeCallbacks(this.f21101m);
        H.b0(this.f21094f.K(), this.f21101m);
        return true;
    }

    @Override // stepos.support.v7.app.a
    public boolean s() {
        return this.f21094f.A() == 0;
    }

    @Override // stepos.support.v7.app.a
    public a.i t() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // stepos.support.v7.app.a
    public void u(Configuration configuration) {
        super.u(configuration);
    }

    @Override // stepos.support.v7.app.a
    void v() {
        this.f21094f.K().removeCallbacks(this.f21101m);
    }

    @Override // stepos.support.v7.app.a
    public boolean w(int i5, KeyEvent keyEvent) {
        Menu menuC0 = c0();
        if (menuC0 != null) {
            menuC0.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            menuC0.performShortcut(i5, keyEvent, 0);
        }
        return true;
    }

    @Override // stepos.support.v7.app.a
    public void x(a.i iVar) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // stepos.support.v7.app.a
    public void y(Drawable drawable) {
        this.f21094f.g(drawable);
    }
}
