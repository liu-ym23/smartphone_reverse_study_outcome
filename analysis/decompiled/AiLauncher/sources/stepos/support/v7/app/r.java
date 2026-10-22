package stepos.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.core.view.N;
import java.util.ArrayList;
import stepos.support.v7.app.a;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.w;

/* loaded from: classes5.dex */
public class r extends stepos.support.v7.app.a {

    /* renamed from: d, reason: collision with root package name */
    public stepos.support.v7.widget.k f40750d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f40751e;

    /* renamed from: f, reason: collision with root package name */
    public Window.Callback f40752f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f40753g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f40754h;

    /* renamed from: j, reason: collision with root package name */
    public stepos.support.v7.view.menu.b f40756j;

    /* renamed from: l, reason: collision with root package name */
    public final Toolbar.g f40758l;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<a.e> f40755i = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f40757k = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.I();
        }
    }

    public class b implements Toolbar.g {
        public b() {
        }

        @Override // stepos.support.v7.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            return r.this.f40752f.onMenuItemSelected(0, menuItem);
        }
    }

    public class c implements a.b {
        public c() {
        }

        @Override // stepos.support.v7.app.a.b
        public void a(int i10, a.InterfaceC0522a interfaceC0522a) {
            r.this.n(i10, interfaceC0522a);
        }
    }

    public final class d implements g.a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f40762a;

        public d() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public void a(stepos.support.v7.view.menu.c cVar, boolean z10) {
            if (this.f40762a) {
                return;
            }
            this.f40762a = true;
            r.this.f40750d.p();
            if (r.this.f40752f != null) {
                r.this.f40752f.onPanelClosed(108, cVar);
            }
            this.f40762a = false;
        }

        @Override // stepos.support.v7.view.menu.g.a
        public boolean b(stepos.support.v7.view.menu.c cVar) {
            if (r.this.f40752f == null) {
                return false;
            }
            r.this.f40752f.onMenuOpened(108, cVar);
            return true;
        }

        public /* synthetic */ d(r rVar, a aVar) {
            this();
        }
    }

    public final class e implements c.a {
        public e() {
        }

        @Override // stepos.support.v7.view.menu.c.a
        public void a(stepos.support.v7.view.menu.c cVar) {
            if (r.this.f40752f != null) {
                if (r.this.f40750d.d()) {
                    r.this.f40752f.onPanelClosed(108, cVar);
                } else if (r.this.f40752f.onPreparePanel(0, null, cVar)) {
                    r.this.f40752f.onMenuOpened(108, cVar);
                }
            }
        }

        @Override // stepos.support.v7.view.menu.c.a
        public boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
            return false;
        }

        public /* synthetic */ e(r rVar, a aVar) {
            this();
        }
    }

    public final class f implements g.a {
        public f() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public void a(stepos.support.v7.view.menu.c cVar, boolean z10) {
            if (r.this.f40752f != null) {
                r.this.f40752f.onPanelClosed(0, cVar);
            }
        }

        @Override // stepos.support.v7.view.menu.g.a
        public boolean b(stepos.support.v7.view.menu.c cVar) {
            if (cVar != null || r.this.f40752f == null) {
                return true;
            }
            r.this.f40752f.onMenuOpened(0, cVar);
            return true;
        }

        public /* synthetic */ f(r rVar, a aVar) {
            this();
        }
    }

    public class g extends Ic.l {
        public g(Window.Callback callback) {
            super(callback);
        }

        @Override // Ic.l, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            if (i10 == 0) {
                Menu menuI = r.this.f40750d.i();
                if (onPreparePanel(i10, null, menuI) && onMenuOpened(i10, menuI)) {
                    return r.this.F(menuI);
                }
            }
            return super.onCreatePanelView(i10);
        }

        @Override // Ic.l, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            boolean zOnPreparePanel = super.onPreparePanel(i10, view, menu);
            if (zOnPreparePanel && !r.this.f40751e) {
                r.this.f40750d.e();
                r.this.f40751e = true;
            }
            return zOnPreparePanel;
        }
    }

    public r(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f40758l = bVar;
        w wVar = new w(toolbar, false);
        this.f40750d = wVar;
        wVar.x(new c());
        g gVar = new g(callback);
        this.f40752f = gVar;
        this.f40750d.setWindowCallback(gVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.f40750d.setWindowTitle(charSequence);
    }

    public final void E(Menu menu) {
        if (this.f40756j == null && (menu instanceof stepos.support.v7.view.menu.c)) {
            stepos.support.v7.view.menu.c cVar = (stepos.support.v7.view.menu.c) menu;
            Context context = this.f40750d.getContext();
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                themeNewTheme.applyStyle(i10, true);
            }
            themeNewTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                themeNewTheme.applyStyle(i11, true);
            } else {
                themeNewTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(themeNewTheme);
            stepos.support.v7.view.menu.b bVar = new stepos.support.v7.view.menu.b(contextThemeWrapper, R$layout.stepos_list_menu_item_layout);
            this.f40756j = bVar;
            bVar.k(new f(this, null));
            cVar.b(this.f40756j);
        }
    }

    public final View F(Menu menu) {
        stepos.support.v7.view.menu.b bVar;
        E(menu);
        if (menu == null || (bVar = this.f40756j) == null || bVar.i().getCount() <= 0) {
            return null;
        }
        return (View) this.f40756j.j(this.f40750d.l());
    }

    public final Menu G() {
        if (!this.f40753g) {
            a aVar = null;
            this.f40750d.u(new d(this, aVar), new e(this, aVar));
            this.f40753g = true;
        }
        return this.f40750d.i();
    }

    public Window.Callback H() {
        return this.f40752f;
    }

    public void I() {
        Menu menuG = G();
        stepos.support.v7.view.menu.c cVar = menuG instanceof stepos.support.v7.view.menu.c ? (stepos.support.v7.view.menu.c) menuG : null;
        if (cVar != null) {
            cVar.b0();
        }
        try {
            menuG.clear();
            if (!this.f40752f.onCreatePanelMenu(0, menuG) || !this.f40752f.onPreparePanel(0, null, menuG)) {
                menuG.clear();
            }
            if (cVar != null) {
                cVar.a0();
            }
        } catch (Throwable th) {
            if (cVar != null) {
                cVar.a0();
            }
            throw th;
        }
    }

    public void J(int i10, int i11) {
        this.f40750d.h((i10 & i11) | ((~i11) & this.f40750d.s()));
    }

    @Override // stepos.support.v7.app.a
    public boolean f() {
        if (!this.f40750d.g()) {
            return false;
        }
        this.f40750d.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.a
    public void g(boolean z10) {
        if (z10 == this.f40754h) {
            return;
        }
        this.f40754h = z10;
        int size = this.f40755i.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f40755i.get(i10).a(z10);
        }
    }

    @Override // stepos.support.v7.app.a
    public int h() {
        return this.f40750d.s();
    }

    @Override // stepos.support.v7.app.a
    public Context i() {
        return this.f40750d.getContext();
    }

    @Override // stepos.support.v7.app.a
    public boolean j() {
        this.f40750d.l().removeCallbacks(this.f40757k);
        N.Z(this.f40750d.l(), this.f40757k);
        return true;
    }

    @Override // stepos.support.v7.app.a
    public void k(Configuration configuration) {
        super.k(configuration);
    }

    @Override // stepos.support.v7.app.a
    public void l() {
        this.f40750d.l().removeCallbacks(this.f40757k);
    }

    @Override // stepos.support.v7.app.a
    public boolean m(int i10, KeyEvent keyEvent) {
        Menu menuG = G();
        if (menuG != null) {
            menuG.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            menuG.performShortcut(i10, keyEvent, 0);
        }
        return true;
    }

    @Override // stepos.support.v7.app.a
    public void o(boolean z10) {
    }

    @Override // stepos.support.v7.app.a
    public void p(boolean z10) {
        J(z10 ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.a
    public void q(boolean z10) {
        J(z10 ? 2 : 0, 2);
    }

    @Override // stepos.support.v7.app.a
    public void r(boolean z10) {
        J(z10 ? 8 : 0, 8);
    }

    @Override // stepos.support.v7.app.a
    public void s(boolean z10) {
    }

    @Override // stepos.support.v7.app.a
    public void t(boolean z10) {
    }

    @Override // stepos.support.v7.app.a
    public void u(CharSequence charSequence) {
        this.f40750d.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public void w(CharSequence charSequence) {
        this.f40750d.setWindowTitle(charSequence);
    }
}
