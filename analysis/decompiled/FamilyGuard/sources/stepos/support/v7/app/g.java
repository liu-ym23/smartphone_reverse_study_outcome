package stepos.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
abstract class g extends f {

    /* renamed from: b, reason: collision with root package name */
    final Context f20761b;

    /* renamed from: c, reason: collision with root package name */
    final Window f20762c;

    /* renamed from: d, reason: collision with root package name */
    final Window.Callback f20763d;

    /* renamed from: e, reason: collision with root package name */
    final Window.Callback f20764e;

    /* renamed from: f, reason: collision with root package name */
    final e f20765f;

    /* renamed from: g, reason: collision with root package name */
    stepos.support.v7.app.a f20766g;

    /* renamed from: h, reason: collision with root package name */
    MenuInflater f20767h;

    /* renamed from: i, reason: collision with root package name */
    boolean f20768i;

    /* renamed from: j, reason: collision with root package name */
    boolean f20769j;

    /* renamed from: k, reason: collision with root package name */
    boolean f20770k;

    /* renamed from: l, reason: collision with root package name */
    boolean f20771l;

    /* renamed from: m, reason: collision with root package name */
    boolean f20772m;

    /* renamed from: n, reason: collision with root package name */
    boolean f20773n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f20774o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f20775p;

    /* renamed from: q, reason: collision with root package name */
    int f20776q;

    private class b implements androidx.appcompat.app.b {
        private b() {
        }
    }

    class c extends androidx.appcompat.view.i {
        c(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.I(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || g.this.O(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i5, Menu menu) {
            if (i5 != 0 || (menu instanceof stepos.support.v7.view.menu.d)) {
                return super.onCreatePanelMenu(i5, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i5, Menu menu) {
            super.onMenuOpened(i5, menu);
            g.this.P(i5, menu);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i5, Menu menu) {
            super.onPanelClosed(i5, menu);
            g.this.Q(i5, menu);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i5, View view, Menu menu) {
            stepos.support.v7.view.menu.d dVar = menu instanceof stepos.support.v7.view.menu.d ? (stepos.support.v7.view.menu.d) menu : null;
            if (i5 == 0 && dVar == null) {
                return false;
            }
            if (dVar != null) {
                dVar.X(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i5, view, menu);
            if (dVar != null) {
                dVar.X(false);
            }
            return zOnPreparePanel;
        }
    }

    g(Context context, Window window, e eVar) {
        this.f20761b = context;
        this.f20762c = window;
        this.f20765f = eVar;
        Window.Callback callback = window.getCallback();
        this.f20763d = callback;
        if (callback instanceof c) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callbackT = T(callback);
        this.f20764e = callbackT;
        window.setCallback(callbackT);
    }

    @Override // stepos.support.v7.app.f
    public final void D(CharSequence charSequence) {
        this.f20774o = charSequence;
        R(charSequence);
    }

    @Override // stepos.support.v7.app.f
    public void E(int i5) {
        this.f20776q = i5;
    }

    abstract boolean I(KeyEvent keyEvent);

    final Context J() {
        stepos.support.v7.app.a aVarL = l();
        Context contextO = aVarL != null ? aVarL.o() : null;
        return contextO == null ? this.f20761b : contextO;
    }

    final CharSequence K() {
        Window.Callback callback = this.f20763d;
        return callback instanceof Activity ? ((Activity) callback).getTitle() : this.f20774o;
    }

    final Window.Callback L() {
        return this.f20762c.getCallback();
    }

    abstract void M();

    final boolean N() {
        return this.f20775p;
    }

    abstract boolean O(int i5, KeyEvent keyEvent);

    abstract boolean P(int i5, Menu menu);

    abstract void Q(int i5, Menu menu);

    abstract void R(CharSequence charSequence);

    final stepos.support.v7.app.a S() {
        return this.f20766g;
    }

    abstract Window.Callback T(Window.Callback callback);

    @Override // stepos.support.v7.app.f
    public abstract boolean b();

    @Override // stepos.support.v7.app.f
    public final androidx.appcompat.app.b j() {
        return new b();
    }

    @Override // stepos.support.v7.app.f
    public MenuInflater k() {
        if (this.f20767h == null) {
            M();
            stepos.support.v7.app.a aVar = this.f20766g;
            this.f20767h = new b5.k(aVar != null ? aVar.o() : this.f20761b);
        }
        return this.f20767h;
    }

    @Override // stepos.support.v7.app.f
    public stepos.support.v7.app.a l() {
        M();
        return this.f20766g;
    }

    @Override // stepos.support.v7.app.f
    public void r() {
        this.f20775p = true;
    }

    @Override // stepos.support.v7.app.f
    public void u(Bundle bundle) {
    }
}
