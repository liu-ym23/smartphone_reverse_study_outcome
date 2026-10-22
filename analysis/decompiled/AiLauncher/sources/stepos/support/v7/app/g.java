package stepos.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

/* loaded from: classes5.dex */
public abstract class g extends f {

    /* renamed from: b, reason: collision with root package name */
    public final Context f40497b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f40498c;

    /* renamed from: d, reason: collision with root package name */
    public final Window.Callback f40499d;

    /* renamed from: e, reason: collision with root package name */
    public final Window.Callback f40500e;

    /* renamed from: f, reason: collision with root package name */
    public final e f40501f;

    /* renamed from: g, reason: collision with root package name */
    public stepos.support.v7.app.a f40502g;

    /* renamed from: h, reason: collision with root package name */
    public MenuInflater f40503h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f40504i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f40505j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f40506k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f40507l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f40508m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f40509n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f40510o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f40511p;

    /* renamed from: q, reason: collision with root package name */
    public int f40512q;

    public class b implements androidx.appcompat.app.b {
        public b() {
        }
    }

    public class c extends i.i {
        public c(Window.Callback callback) {
            super(callback);
        }

        @Override // i.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.I(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // i.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || g.this.O(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // i.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof stepos.support.v7.view.menu.c)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // i.i, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            g.this.P(i10, menu);
            return true;
        }

        @Override // i.i, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) {
            super.onPanelClosed(i10, menu);
            g.this.Q(i10, menu);
        }

        @Override // i.i, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            stepos.support.v7.view.menu.c cVar = menu instanceof stepos.support.v7.view.menu.c ? (stepos.support.v7.view.menu.c) menu : null;
            if (i10 == 0 && cVar == null) {
                return false;
            }
            if (cVar != null) {
                cVar.X(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i10, view, menu);
            if (cVar != null) {
                cVar.X(false);
            }
            return zOnPreparePanel;
        }
    }

    public g(Context context, Window window, e eVar) {
        this.f40497b = context;
        this.f40498c = window;
        this.f40501f = eVar;
        Window.Callback callback = window.getCallback();
        this.f40499d = callback;
        if (callback instanceof c) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callbackT = T(callback);
        this.f40500e = callbackT;
        window.setCallback(callbackT);
    }

    @Override // stepos.support.v7.app.f
    public final void D(CharSequence charSequence) {
        this.f40510o = charSequence;
        R(charSequence);
    }

    @Override // stepos.support.v7.app.f
    public void E(int i10) {
        this.f40512q = i10;
    }

    public abstract boolean I(KeyEvent keyEvent);

    public final Context J() {
        stepos.support.v7.app.a aVarL = l();
        Context contextI = aVarL != null ? aVarL.i() : null;
        return contextI == null ? this.f40497b : contextI;
    }

    public final CharSequence K() {
        Window.Callback callback = this.f40499d;
        return callback instanceof Activity ? ((Activity) callback).getTitle() : this.f40510o;
    }

    public final Window.Callback L() {
        return this.f40498c.getCallback();
    }

    public abstract void M();

    public final boolean N() {
        return this.f40511p;
    }

    public abstract boolean O(int i10, KeyEvent keyEvent);

    public abstract boolean P(int i10, Menu menu);

    public abstract void Q(int i10, Menu menu);

    public abstract void R(CharSequence charSequence);

    public final stepos.support.v7.app.a S() {
        return this.f40502g;
    }

    public abstract Window.Callback T(Window.Callback callback);

    @Override // stepos.support.v7.app.f
    public abstract boolean d();

    @Override // stepos.support.v7.app.f
    public final androidx.appcompat.app.b j() {
        return new b();
    }

    @Override // stepos.support.v7.app.f
    public MenuInflater k() {
        if (this.f40503h == null) {
            M();
            stepos.support.v7.app.a aVar = this.f40502g;
            this.f40503h = new Ic.k(aVar != null ? aVar.i() : this.f40497b);
        }
        return this.f40503h;
    }

    @Override // stepos.support.v7.app.f
    public stepos.support.v7.app.a l() {
        M();
        return this.f40502g;
    }

    @Override // stepos.support.v7.app.f
    public void r() {
        this.f40511p = true;
    }

    @Override // stepos.support.v7.app.f
    public void u(Bundle bundle) {
    }
}
