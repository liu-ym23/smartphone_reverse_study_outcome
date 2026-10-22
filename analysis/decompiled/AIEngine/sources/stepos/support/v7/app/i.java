package stepos.support.v7.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import stepos.support.v7.app.AppCompatDelegateImplV7;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class i extends h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12125a;

    /* renamed from: b, reason: collision with root package name */
    public final Window f12126b;

    /* renamed from: c, reason: collision with root package name */
    public final Window.Callback f12127c;

    /* renamed from: d, reason: collision with root package name */
    public final Window.Callback f12128d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f12129e;

    /* renamed from: f, reason: collision with root package name */
    public stepos.support.v7.app.a f12130f;

    /* renamed from: g, reason: collision with root package name */
    public fe.i f12131g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12132i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12133j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12134k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12135l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12136m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f12137n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12138o;

    /* renamed from: p, reason: collision with root package name */
    public int f12139p;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements androidx.appcompat.app.b {
    }

    public i(Context context, Window window, g gVar) {
        this.f12125a = context;
        this.f12126b = window;
        this.f12129e = gVar;
        Window.Callback callback = window.getCallback();
        this.f12127c = callback;
        if (callback instanceof b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callbackM = m(callback);
        this.f12128d = callbackM;
        window.setCallback(callbackM);
    }

    public abstract boolean k(KeyEvent keyEvent);

    public abstract void l();

    public abstract Window.Callback m(Window.Callback callback);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends k.h {
        public b(Window.Callback callback) {
            super(callback);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return i.this.k(keyEvent) || this.f9831a.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0050 A[RETURN] */
        @Override // android.view.Window.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r5) {
            /*
                r4 = this;
                android.view.Window$Callback r0 = r4.f9831a
                boolean r0 = r0.dispatchKeyShortcutEvent(r5)
                r1 = 1
                if (r0 != 0) goto L51
                int r0 = r5.getKeyCode()
                stepos.support.v7.app.i r4 = stepos.support.v7.app.i.this
                stepos.support.v7.app.AppCompatDelegateImplV7 r4 = (stepos.support.v7.app.AppCompatDelegateImplV7) r4
                r4.l()
                stepos.support.v7.app.a r2 = r4.f12130f
                r3 = 0
                if (r2 == 0) goto L20
                boolean r0 = r2.h(r0, r5)
                if (r0 == 0) goto L20
                goto L34
            L20:
                stepos.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState r0 = r4.G
                if (r0 == 0) goto L36
                int r2 = r5.getKeyCode()
                boolean r0 = r4.x(r0, r2, r5)
                if (r0 == 0) goto L36
                stepos.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState r4 = r4.G
                if (r4 == 0) goto L34
                r4.f12008l = r1
            L34:
                r4 = r1
                goto L4d
            L36:
                stepos.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState r0 = r4.G
                if (r0 != 0) goto L4c
                stepos.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState r0 = r4.t(r3)
                r4.z(r0, r5)
                int r2 = r5.getKeyCode()
                boolean r4 = r4.x(r0, r2, r5)
                r0.f12007k = r3
                goto L4d
            L4c:
                r4 = r3
            L4d:
                if (r4 == 0) goto L50
                goto L51
            L50:
                return r3
            L51:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.i.b.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        @Override // k.h, android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof stepos.support.v7.view.menu.c)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // k.h, android.view.Window.Callback
        public final boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) i.this;
            if (i10 == 108) {
                appCompatDelegateImplV7.l();
                stepos.support.v7.app.a aVar = appCompatDelegateImplV7.f12130f;
                if (aVar != null) {
                    aVar.b(true);
                }
            }
            return true;
        }

        @Override // k.h, android.view.Window.Callback
        public final void onPanelClosed(int i10, Menu menu) {
            super.onPanelClosed(i10, menu);
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) i.this;
            if (i10 == 108) {
                appCompatDelegateImplV7.l();
                stepos.support.v7.app.a aVar = appCompatDelegateImplV7.f12130f;
                if (aVar != null) {
                    aVar.b(false);
                    return;
                }
                return;
            }
            if (i10 == 0) {
                AppCompatDelegateImplV7.PanelFeatureState panelFeatureStateT = appCompatDelegateImplV7.t(i10);
                if (panelFeatureStateT.f12009m) {
                    appCompatDelegateImplV7.q(panelFeatureStateT, false);
                }
            }
        }

        @Override // k.h, android.view.Window.Callback
        public final boolean onPreparePanel(int i10, View view, Menu menu) {
            stepos.support.v7.view.menu.c cVar = menu instanceof stepos.support.v7.view.menu.c ? (stepos.support.v7.view.menu.c) menu : null;
            if (i10 == 0 && cVar == null) {
                return false;
            }
            if (cVar != null) {
                cVar.f12393y = true;
            }
            boolean zOnPreparePanel = super.onPreparePanel(i10, view, menu);
            if (cVar != null) {
                cVar.f12393y = false;
            }
            return zOnPreparePanel;
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
        }
    }
}
