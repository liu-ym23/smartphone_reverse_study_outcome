package stepos.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.stepos.aiengine.R;
import com.stepos.core.data.base.Content;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.WeakHashMap;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.b;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.widget.ActionMenuView;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n0 extends stepos.support.v7.app.a {

    /* renamed from: a, reason: collision with root package name */
    public final stepos.support.v7.widget.e0 f12158a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12159b;

    /* renamed from: c, reason: collision with root package name */
    public final g f12160c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12161d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12162e;

    /* renamed from: g, reason: collision with root package name */
    public stepos.support.v7.view.menu.b f12164g;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<a.d> f12163f = new ArrayList<>();
    public final a h = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            n0 n0Var = n0.this;
            g gVar = n0Var.f12160c;
            Menu menuT = n0Var.t();
            stepos.support.v7.view.menu.c cVar = menuT instanceof stepos.support.v7.view.menu.c ? (stepos.support.v7.view.menu.c) menuT : null;
            if (cVar != null) {
                cVar.v();
            }
            try {
                menuT.clear();
                if (!gVar.f8920a.onCreatePanelMenu(0, menuT) || !gVar.onPreparePanel(0, null, menuT)) {
                    menuT.clear();
                }
                if (cVar != null) {
                    cVar.u();
                }
            } catch (Throwable th) {
                if (cVar != null) {
                    cVar.u();
                }
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Toolbar.f {
        public b() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements a.InterfaceC0141a {
        @Override // stepos.support.v7.app.a.InterfaceC0141a
        public final void a(int i10, e0.d dVar) {
            if (i10 != 0 && i10 != 1) {
                throw new InvalidParameterException();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class d implements g.a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12167a;

        public d() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final void a(stepos.support.v7.view.menu.c cVar, boolean z) {
            if (this.f12167a) {
                return;
            }
            this.f12167a = true;
            n0 n0Var = n0.this;
            n0Var.f12158a.l();
            g gVar = n0Var.f12160c;
            if (gVar != null) {
                gVar.onPanelClosed(Content.Types.TYPE_DOUBLE_ARRAY, cVar);
            }
            this.f12167a = false;
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final boolean b(stepos.support.v7.view.menu.c cVar) {
            g gVar = n0.this.f12160c;
            if (gVar == null) {
                return false;
            }
            gVar.onMenuOpened(Content.Types.TYPE_DOUBLE_ARRAY, cVar);
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class e implements c.a {
        public e() {
        }

        @Override // stepos.support.v7.view.menu.c.a
        public final void a(stepos.support.v7.view.menu.c cVar) {
            n0 n0Var = n0.this;
            g gVar = n0Var.f12160c;
            if (gVar != null) {
                if (n0Var.f12158a.f12757a.m()) {
                    gVar.onPanelClosed(Content.Types.TYPE_DOUBLE_ARRAY, cVar);
                } else if (gVar.onPreparePanel(0, null, cVar)) {
                    gVar.onMenuOpened(Content.Types.TYPE_DOUBLE_ARRAY, cVar);
                }
            }
        }

        @Override // stepos.support.v7.view.menu.c.a
        public final boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class f implements g.a {
        public f() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final void a(stepos.support.v7.view.menu.c cVar, boolean z) {
            g gVar = n0.this.f12160c;
            if (gVar != null) {
                gVar.onPanelClosed(0, cVar);
            }
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final boolean b(stepos.support.v7.view.menu.c cVar) {
            g gVar;
            if (cVar != null || (gVar = n0.this.f12160c) == null) {
                return true;
            }
            gVar.onMenuOpened(0, cVar);
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g extends fe.j {
        public g(Window.Callback callback) {
            super(callback);
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int i10) {
            stepos.support.v7.view.menu.b bVar;
            n0 n0Var = n0.this;
            stepos.support.v7.widget.e0 e0Var = n0Var.f12158a;
            Window.Callback callback = this.f8920a;
            if (i10 == 0) {
                Menu menu = e0Var.f12757a.getMenu();
                if (onPreparePanel(i10, null, menu) && callback.onMenuOpened(i10, menu)) {
                    if (n0Var.f12164g == null && (menu instanceof stepos.support.v7.view.menu.c)) {
                        stepos.support.v7.view.menu.c cVar = (stepos.support.v7.view.menu.c) menu;
                        Context context = e0Var.f12757a.getContext();
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme themeNewTheme = context.getResources().newTheme();
                        themeNewTheme.setTo(context.getTheme());
                        themeNewTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
                        int i11 = typedValue.resourceId;
                        if (i11 != 0) {
                            themeNewTheme.applyStyle(i11, true);
                        }
                        themeNewTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
                        int i12 = typedValue.resourceId;
                        if (i12 != 0) {
                            themeNewTheme.applyStyle(i12, true);
                        } else {
                            themeNewTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
                        }
                        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                        contextThemeWrapper.getTheme().setTo(themeNewTheme);
                        stepos.support.v7.view.menu.b bVar2 = new stepos.support.v7.view.menu.b(contextThemeWrapper);
                        n0Var.f12164g = bVar2;
                        bVar2.f12371e = n0Var.new f();
                        cVar.b(bVar2, cVar.f12374a);
                    }
                    if (menu == null || (bVar = n0Var.f12164g) == null || ((b.a) bVar.h()).getCount() <= 0) {
                        return null;
                    }
                    return (View) n0Var.f12164g.i(e0Var.f12757a);
                }
            }
            return callback.onCreatePanelView(i10);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int i10, View view, Menu menu) {
            boolean zOnPreparePanel = this.f8920a.onPreparePanel(i10, view, menu);
            if (zOnPreparePanel) {
                n0 n0Var = n0.this;
                if (!n0Var.f12159b) {
                    n0Var.f12158a.f12768m = true;
                    n0Var.f12159b = true;
                }
            }
            return zOnPreparePanel;
        }
    }

    public n0(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        stepos.support.v7.widget.e0 e0Var = new stepos.support.v7.widget.e0(toolbar, false);
        this.f12158a = e0Var;
        e0Var.f12775u = new c();
        g gVar = new g(callback);
        this.f12160c = gVar;
        e0Var.f12767l = gVar;
        toolbar.setOnMenuItemClickListener(bVar);
        e0Var.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public final boolean a() {
        stepos.support.v7.widget.e0 e0Var = this.f12158a;
        if (!e0Var.g()) {
            return false;
        }
        e0Var.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.a
    public final void b(boolean z) {
        if (z == this.f12162e) {
            return;
        }
        this.f12162e = z;
        ArrayList<a.d> arrayList = this.f12163f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).a();
        }
    }

    @Override // stepos.support.v7.app.a
    public final int c() {
        return this.f12158a.f12758b;
    }

    @Override // stepos.support.v7.app.a
    public final Context d() {
        return this.f12158a.f12757a.getContext();
    }

    @Override // stepos.support.v7.app.a
    public final boolean e() {
        stepos.support.v7.widget.e0 e0Var = this.f12158a;
        Toolbar toolbar = e0Var.f12757a;
        a aVar = this.h;
        toolbar.removeCallbacks(aVar);
        Toolbar toolbar2 = e0Var.f12757a;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        toolbar2.postOnAnimation(aVar);
        return true;
    }

    @Override // stepos.support.v7.app.a
    public final void g() {
        this.f12158a.f12757a.removeCallbacks(this.h);
    }

    @Override // stepos.support.v7.app.a
    public final boolean h(int i10, KeyEvent keyEvent) {
        Menu menuT = t();
        if (menuT != null) {
            menuT.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
            menuT.performShortcut(i10, keyEvent, 0);
        }
        return true;
    }

    @Override // stepos.support.v7.app.a
    public final void j(boolean z) {
        u(4, 4);
    }

    @Override // stepos.support.v7.app.a
    public final void k() {
        u(0, 2);
    }

    @Override // stepos.support.v7.app.a
    public final void l() {
        u(8, 8);
    }

    @Override // stepos.support.v7.app.a
    public final void o(CharSequence charSequence) {
        this.f12158a.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public final void q(CharSequence charSequence) {
        this.f12158a.setWindowTitle(charSequence);
    }

    public final Menu t() {
        boolean z = this.f12161d;
        stepos.support.v7.widget.e0 e0Var = this.f12158a;
        if (!z) {
            d dVar = new d();
            e eVar = new e();
            Toolbar toolbar = e0Var.f12757a;
            toolbar.Q = dVar;
            toolbar.R = eVar;
            ActionMenuView actionMenuView = toolbar.f12645a;
            if (actionMenuView != null) {
                actionMenuView.f12528x = dVar;
                actionMenuView.f12529y = eVar;
            }
            this.f12161d = true;
        }
        return e0Var.f12757a.getMenu();
    }

    public final void u(int i10, int i11) {
        stepos.support.v7.widget.e0 e0Var = this.f12158a;
        e0Var.h((i10 & i11) | ((~i11) & e0Var.f12758b));
    }

    @Override // stepos.support.v7.app.a
    public final void f() {
    }

    @Override // stepos.support.v7.app.a
    public final void i(boolean z) {
    }

    @Override // stepos.support.v7.app.a
    public final void m(boolean z) {
    }

    @Override // stepos.support.v7.app.a
    public final void n(boolean z) {
    }
}
