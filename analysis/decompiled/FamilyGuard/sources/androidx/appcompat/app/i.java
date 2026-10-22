package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0441k;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.G;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.h0;
import androidx.core.content.res.h;
import androidx.core.view.C0465j;
import androidx.core.view.C0466k;
import androidx.core.view.H;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.S;
import androidx.core.view.U;
import androidx.core.view.Y;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.InterfaceC0539t;
import androidx.recyclerview.widget.RecyclerView;
import g.C0728a;
import h.C0744a;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class i extends androidx.appcompat.app.g implements e.a, LayoutInflater.Factory2 {

    /* renamed from: m0, reason: collision with root package name */
    private static final q.i<String, Integer> f7541m0 = new q.i<>();

    /* renamed from: n0, reason: collision with root package name */
    private static final boolean f7542n0 = false;

    /* renamed from: o0, reason: collision with root package name */
    private static final int[] f7543o0 = {R.attr.windowBackground};

    /* renamed from: p0, reason: collision with root package name */
    private static final boolean f7544p0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: A, reason: collision with root package name */
    private boolean f7545A;

    /* renamed from: B, reason: collision with root package name */
    ViewGroup f7546B;

    /* renamed from: C, reason: collision with root package name */
    private TextView f7547C;

    /* renamed from: D, reason: collision with root package name */
    private View f7548D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f7549E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f7550F;

    /* renamed from: G, reason: collision with root package name */
    boolean f7551G;

    /* renamed from: H, reason: collision with root package name */
    boolean f7552H;

    /* renamed from: I, reason: collision with root package name */
    boolean f7553I;

    /* renamed from: J, reason: collision with root package name */
    boolean f7554J;

    /* renamed from: K, reason: collision with root package name */
    boolean f7555K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f7556L;

    /* renamed from: M, reason: collision with root package name */
    private q[] f7557M;

    /* renamed from: Q, reason: collision with root package name */
    private q f7558Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f7559R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f7560S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f7561T;

    /* renamed from: U, reason: collision with root package name */
    boolean f7562U;

    /* renamed from: V, reason: collision with root package name */
    private Configuration f7563V;

    /* renamed from: W, reason: collision with root package name */
    private int f7564W;

    /* renamed from: X, reason: collision with root package name */
    private int f7565X;

    /* renamed from: Y, reason: collision with root package name */
    private int f7566Y;

    /* renamed from: Z, reason: collision with root package name */
    private boolean f7567Z;

    /* renamed from: a0, reason: collision with root package name */
    private n f7568a0;

    /* renamed from: b0, reason: collision with root package name */
    private n f7569b0;

    /* renamed from: c0, reason: collision with root package name */
    boolean f7570c0;

    /* renamed from: d0, reason: collision with root package name */
    int f7571d0;

    /* renamed from: e0, reason: collision with root package name */
    private final Runnable f7572e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f7573f0;

    /* renamed from: g0, reason: collision with root package name */
    private Rect f7574g0;

    /* renamed from: h0, reason: collision with root package name */
    private Rect f7575h0;

    /* renamed from: i0, reason: collision with root package name */
    private androidx.appcompat.app.m f7576i0;

    /* renamed from: j, reason: collision with root package name */
    final Object f7577j;

    /* renamed from: j0, reason: collision with root package name */
    private androidx.appcompat.app.o f7578j0;

    /* renamed from: k, reason: collision with root package name */
    final Context f7579k;

    /* renamed from: k0, reason: collision with root package name */
    private OnBackInvokedDispatcher f7580k0;

    /* renamed from: l, reason: collision with root package name */
    Window f7581l;

    /* renamed from: l0, reason: collision with root package name */
    private OnBackInvokedCallback f7582l0;

    /* renamed from: m, reason: collision with root package name */
    private l f7583m;

    /* renamed from: n, reason: collision with root package name */
    final androidx.appcompat.app.e f7584n;

    /* renamed from: o, reason: collision with root package name */
    androidx.appcompat.app.a f7585o;

    /* renamed from: p, reason: collision with root package name */
    MenuInflater f7586p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f7587q;

    /* renamed from: r, reason: collision with root package name */
    private G f7588r;

    /* renamed from: s, reason: collision with root package name */
    private f f7589s;

    /* renamed from: t, reason: collision with root package name */
    private r f7590t;

    /* renamed from: u, reason: collision with root package name */
    androidx.appcompat.view.b f7591u;

    /* renamed from: v, reason: collision with root package name */
    ActionBarContextView f7592v;

    /* renamed from: w, reason: collision with root package name */
    PopupWindow f7593w;

    /* renamed from: x, reason: collision with root package name */
    Runnable f7594x;

    /* renamed from: y, reason: collision with root package name */
    S f7595y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f7596z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            if ((iVar.f7571d0 & 1) != 0) {
                iVar.e0(0);
            }
            i iVar2 = i.this;
            if ((iVar2.f7571d0 & RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT) != 0) {
                iVar2.e0(108);
            }
            i iVar3 = i.this;
            iVar3.f7570c0 = false;
            iVar3.f7571d0 = 0;
        }
    }

    class b implements InterfaceC0479y {
        b() {
        }

        @Override // androidx.core.view.InterfaceC0479y
        public Y a(View view, Y y5) {
            int iK = y5.k();
            int iB1 = i.this.b1(y5, null);
            if (iK != iB1) {
                y5 = y5.o(y5.i(), iB1, y5.j(), y5.h());
            }
            return H.W(view, y5);
        }
    }

    class c implements ContentFrameLayout.a {
        c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            i.this.c0();
        }
    }

    class d implements Runnable {

        class a extends U {
            a() {
            }

            @Override // androidx.core.view.U, androidx.core.view.T
            public void d(View view) {
                i.this.f7592v.setAlpha(1.0f);
                i.this.f7595y.j(null);
                i.this.f7595y = null;
            }

            @Override // androidx.core.view.U, androidx.core.view.T
            public void e(View view) {
                i.this.f7592v.setVisibility(0);
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            iVar.f7593w.showAtLocation(iVar.f7592v, 55, 0, 0);
            i.this.f0();
            if (!i.this.Q0()) {
                i.this.f7592v.setAlpha(1.0f);
                i.this.f7592v.setVisibility(0);
            } else {
                i.this.f7592v.setAlpha(0.0f);
                i iVar2 = i.this;
                iVar2.f7595y = H.d(iVar2.f7592v).b(1.0f);
                i.this.f7595y.j(new a());
            }
        }
    }

    class e extends U {
        e() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            i.this.f7592v.setAlpha(1.0f);
            i.this.f7595y.j(null);
            i.this.f7595y = null;
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void e(View view) {
            i.this.f7592v.setVisibility(0);
            if (i.this.f7592v.getParent() instanceof View) {
                H.g0((View) i.this.f7592v.getParent());
            }
        }
    }

    private final class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void d(androidx.appcompat.view.menu.e eVar, boolean z5) {
            i.this.V(eVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean e(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackR0 = i.this.r0();
            if (callbackR0 == null) {
                return true;
            }
            callbackR0.onMenuOpened(108, eVar);
            return true;
        }
    }

    class g implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private b.a f7604a;

        class a extends U {
            a() {
            }

            @Override // androidx.core.view.U, androidx.core.view.T
            public void d(View view) {
                i.this.f7592v.setVisibility(8);
                i iVar = i.this;
                PopupWindow popupWindow = iVar.f7593w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (iVar.f7592v.getParent() instanceof View) {
                    H.g0((View) i.this.f7592v.getParent());
                }
                i.this.f7592v.k();
                i.this.f7595y.j(null);
                i iVar2 = i.this;
                iVar2.f7595y = null;
                H.g0(iVar2.f7546B);
            }
        }

        public g(b.a aVar) {
            this.f7604a = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public void a(androidx.appcompat.view.b bVar) {
            this.f7604a.a(bVar);
            i iVar = i.this;
            if (iVar.f7593w != null) {
                iVar.f7581l.getDecorView().removeCallbacks(i.this.f7594x);
            }
            i iVar2 = i.this;
            if (iVar2.f7592v != null) {
                iVar2.f0();
                i iVar3 = i.this;
                iVar3.f7595y = H.d(iVar3.f7592v).b(0.0f);
                i.this.f7595y.j(new a());
            }
            i iVar4 = i.this;
            androidx.appcompat.app.e eVar = iVar4.f7584n;
            if (eVar != null) {
                eVar.b(iVar4.f7591u);
            }
            i iVar5 = i.this;
            iVar5.f7591u = null;
            H.g0(iVar5.f7546B);
            i.this.Z0();
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f7604a.b(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(androidx.appcompat.view.b bVar, Menu menu) {
            H.g0(i.this.f7546B);
            return this.f7604a.c(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f7604a.d(bVar, menuItem);
        }
    }

    static class h {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* renamed from: androidx.appcompat.app.i$i, reason: collision with other inner class name */
    static class C0105i {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        static androidx.core.os.d b(Configuration configuration) {
            return androidx.core.os.d.b(configuration.getLocales().toLanguageTags());
        }

        public static void c(androidx.core.os.d dVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(dVar.e()));
        }

        static void d(Configuration configuration, androidx.core.os.d dVar) {
            configuration.setLocales(LocaleList.forLanguageTags(dVar.e()));
        }
    }

    static class j {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i5 = configuration.colorMode & 3;
            int i6 = configuration2.colorMode;
            if (i5 != (i6 & 3)) {
                configuration3.colorMode |= i6 & 3;
            }
            int i7 = configuration.colorMode & 12;
            int i8 = configuration2.colorMode;
            if (i7 != (i8 & 12)) {
                configuration3.colorMode |= i8 & 12;
            }
        }
    }

    static class k {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, final i iVar) {
            Objects.requireNonNull(iVar);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.j
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    iVar.z0();
                }
            };
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    class l extends androidx.appcompat.view.i {

        /* renamed from: b, reason: collision with root package name */
        private boolean f7607b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f7608c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7609d;

        l(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f7608c = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f7608c = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f7607b = true;
                callback.onContentChanged();
            } finally {
                this.f7607b = false;
            }
        }

        public void d(Window.Callback callback, int i5, Menu menu) {
            try {
                this.f7609d = true;
                callback.onPanelClosed(i5, menu);
            } finally {
                this.f7609d = false;
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f7608c ? a().dispatchKeyEvent(keyEvent) : i.this.d0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || i.this.C0(keyEvent.getKeyCode(), keyEvent);
        }

        final ActionMode e(ActionMode.Callback callback) {
            f.a aVar = new f.a(i.this.f7579k, callback);
            androidx.appcompat.view.b bVarT0 = i.this.T0(aVar);
            if (bVarT0 != null) {
                return aVar.e(bVarT0);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f7607b) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i5, Menu menu) {
            if (i5 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i5, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i5) {
            return super.onCreatePanelView(i5);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i5, Menu menu) {
            super.onMenuOpened(i5, menu);
            i.this.F0(i5);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i5, Menu menu) {
            if (this.f7609d) {
                a().onPanelClosed(i5, menu);
            } else {
                super.onPanelClosed(i5, menu);
                i.this.G0(i5);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i5, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i5 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.b0(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i5, view, menu);
            if (eVar != null) {
                eVar.b0(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i5) {
            androidx.appcompat.view.menu.e eVar;
            q qVarP0 = i.this.p0(0, true);
            if (qVarP0 == null || (eVar = qVarP0.f7628j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i5);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i5);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i5) {
            return (i.this.x0() && i5 == 0) ? e(callback) : super.onWindowStartingActionMode(callback, i5);
        }
    }

    private class m extends n {

        /* renamed from: c, reason: collision with root package name */
        private final PowerManager f7611c;

        m(Context context) {
            super();
            this.f7611c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.i.n
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.i.n
        public int c() {
            return h.a(this.f7611c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.i.n
        public void d() {
            i.this.P();
        }
    }

    abstract class n {

        /* renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f7613a;

        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                n.this.d();
            }
        }

        n() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f7613a;
            if (broadcastReceiver != null) {
                try {
                    i.this.f7579k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f7613a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f7613a == null) {
                this.f7613a = new a();
            }
            i.this.f7579k.registerReceiver(this.f7613a, intentFilterB);
        }
    }

    private class o extends n {

        /* renamed from: c, reason: collision with root package name */
        private final androidx.appcompat.app.q f7616c;

        o(androidx.appcompat.app.q qVar) {
            super();
            this.f7616c = qVar;
        }

        @Override // androidx.appcompat.app.i.n
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.i.n
        public int c() {
            return this.f7616c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.i.n
        public void d() {
            i.this.P();
        }
    }

    private class p extends ContentFrameLayout {
        public p(Context context) {
            super(context);
        }

        private boolean a(int i5, int i6) {
            return i5 < -5 || i6 < -5 || i5 > getWidth() + 5 || i6 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return i.this.d0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            i.this.X(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i5) {
            setBackgroundDrawable(C0744a.b(getContext(), i5));
        }
    }

    protected static final class q {

        /* renamed from: a, reason: collision with root package name */
        int f7619a;

        /* renamed from: b, reason: collision with root package name */
        int f7620b;

        /* renamed from: c, reason: collision with root package name */
        int f7621c;

        /* renamed from: d, reason: collision with root package name */
        int f7622d;

        /* renamed from: e, reason: collision with root package name */
        int f7623e;

        /* renamed from: f, reason: collision with root package name */
        int f7624f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f7625g;

        /* renamed from: h, reason: collision with root package name */
        View f7626h;

        /* renamed from: i, reason: collision with root package name */
        View f7627i;

        /* renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.e f7628j;

        /* renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.c f7629k;

        /* renamed from: l, reason: collision with root package name */
        Context f7630l;

        /* renamed from: m, reason: collision with root package name */
        boolean f7631m;

        /* renamed from: n, reason: collision with root package name */
        boolean f7632n;

        /* renamed from: o, reason: collision with root package name */
        boolean f7633o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f7634p;

        /* renamed from: q, reason: collision with root package name */
        boolean f7635q = false;

        /* renamed from: r, reason: collision with root package name */
        boolean f7636r;

        /* renamed from: s, reason: collision with root package name */
        Bundle f7637s;

        q(int i5) {
            this.f7619a = i5;
        }

        androidx.appcompat.view.menu.k a(j.a aVar) {
            if (this.f7628j == null) {
                return null;
            }
            if (this.f7629k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f7630l, g.g.f16954j);
                this.f7629k = cVar;
                cVar.g(aVar);
                this.f7628j.b(this.f7629k);
            }
            return this.f7629k.h(this.f7625g);
        }

        public boolean b() {
            if (this.f7626h == null) {
                return false;
            }
            return this.f7627i != null || this.f7629k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f7628j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.P(this.f7629k);
            }
            this.f7628j = eVar;
            if (eVar == null || (cVar = this.f7629k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        void d(Context context) {
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
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f7630l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(g.j.f17215y0);
            this.f7620b = typedArrayObtainStyledAttributes.getResourceId(g.j.f16988B0, 0);
            this.f7624f = typedArrayObtainStyledAttributes.getResourceId(g.j.f16983A0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final class r implements j.a {
        r() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void d(androidx.appcompat.view.menu.e eVar, boolean z5) {
            androidx.appcompat.view.menu.e eVarD = eVar.D();
            boolean z6 = eVarD != eVar;
            i iVar = i.this;
            if (z6) {
                eVar = eVarD;
            }
            q qVarI0 = iVar.i0(eVar);
            if (qVarI0 != null) {
                if (!z6) {
                    i.this.Y(qVarI0, z5);
                } else {
                    i.this.U(qVarI0.f7619a, qVarI0, eVarD);
                    i.this.Y(qVarI0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean e(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackR0;
            if (eVar != eVar.D()) {
                return true;
            }
            i iVar = i.this;
            if (!iVar.f7551G || (callbackR0 = iVar.r0()) == null || i.this.f7562U) {
                return true;
            }
            callbackR0.onMenuOpened(108, eVar);
            return true;
        }
    }

    i(Activity activity, androidx.appcompat.app.e eVar) {
        this(activity, null, eVar, activity);
    }

    private boolean B0(int i5, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        q qVarP0 = p0(i5, true);
        if (qVarP0.f7633o) {
            return false;
        }
        return L0(qVarP0, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean E0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.b r0 = r4.f7591u
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.i$q r2 = r4.p0(r5, r0)
            if (r5 != 0) goto L43
            androidx.appcompat.widget.G r5 = r4.f7588r
            if (r5 == 0) goto L43
            boolean r5 = r5.c()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.f7579k
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            androidx.appcompat.widget.G r5 = r4.f7588r
            boolean r5 = r5.a()
            if (r5 != 0) goto L3c
            boolean r5 = r4.f7562U
            if (r5 != 0) goto L62
            boolean r5 = r4.L0(r2, r6)
            if (r5 == 0) goto L62
            androidx.appcompat.widget.G r5 = r4.f7588r
            boolean r0 = r5.f()
            goto L68
        L3c:
            androidx.appcompat.widget.G r5 = r4.f7588r
            boolean r0 = r5.e()
            goto L68
        L43:
            boolean r5 = r2.f7633o
            if (r5 != 0) goto L64
            boolean r3 = r2.f7632n
            if (r3 == 0) goto L4c
            goto L64
        L4c:
            boolean r5 = r2.f7631m
            if (r5 == 0) goto L62
            boolean r5 = r2.f7636r
            if (r5 == 0) goto L5b
            r2.f7631m = r1
            boolean r5 = r4.L0(r2, r6)
            goto L5c
        L5b:
            r5 = r0
        L5c:
            if (r5 == 0) goto L62
            r4.I0(r2, r6)
            goto L68
        L62:
            r0 = r1
            goto L68
        L64:
            r4.Y(r2, r0)
            r0 = r5
        L68:
            if (r0 == 0) goto L85
            android.content.Context r4 = r4.f7579k
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r5 = "audio"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L7e
            r4.playSoundEffect(r1)
            return r0
        L7e:
            java.lang.String r4 = "AppCompatDelegate"
            java.lang.String r5 = "Couldn't get audio manager"
            android.util.Log.w(r4, r5)
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.i.E0(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void I0(androidx.appcompat.app.i.q r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.i.I0(androidx.appcompat.app.i$q, android.view.KeyEvent):void");
    }

    private boolean K0(q qVar, int i5, KeyEvent keyEvent, int i6) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((qVar.f7631m || L0(qVar, keyEvent)) && (eVar = qVar.f7628j) != null) {
            zPerformShortcut = eVar.performShortcut(i5, keyEvent, i6);
        }
        if (zPerformShortcut && (i6 & 1) == 0 && this.f7588r == null) {
            Y(qVar, true);
        }
        return zPerformShortcut;
    }

    private boolean L0(q qVar, KeyEvent keyEvent) {
        G g5;
        G g6;
        G g7;
        if (this.f7562U) {
            return false;
        }
        if (qVar.f7631m) {
            return true;
        }
        q qVar2 = this.f7558Q;
        if (qVar2 != null && qVar2 != qVar) {
            Y(qVar2, false);
        }
        Window.Callback callbackR0 = r0();
        if (callbackR0 != null) {
            qVar.f7627i = callbackR0.onCreatePanelView(qVar.f7619a);
        }
        int i5 = qVar.f7619a;
        boolean z5 = i5 == 0 || i5 == 108;
        if (z5 && (g7 = this.f7588r) != null) {
            g7.b();
        }
        if (qVar.f7627i == null) {
            if (z5) {
                J0();
            }
            androidx.appcompat.view.menu.e eVar = qVar.f7628j;
            if (eVar == null || qVar.f7636r) {
                if (eVar == null && (!v0(qVar) || qVar.f7628j == null)) {
                    return false;
                }
                if (z5 && this.f7588r != null) {
                    if (this.f7589s == null) {
                        this.f7589s = new f();
                    }
                    this.f7588r.g(qVar.f7628j, this.f7589s);
                }
                qVar.f7628j.e0();
                if (!callbackR0.onCreatePanelMenu(qVar.f7619a, qVar.f7628j)) {
                    qVar.c(null);
                    if (z5 && (g5 = this.f7588r) != null) {
                        g5.g(null, this.f7589s);
                    }
                    return false;
                }
                qVar.f7636r = false;
            }
            qVar.f7628j.e0();
            Bundle bundle = qVar.f7637s;
            if (bundle != null) {
                qVar.f7628j.Q(bundle);
                qVar.f7637s = null;
            }
            if (!callbackR0.onPreparePanel(0, qVar.f7627i, qVar.f7628j)) {
                if (z5 && (g6 = this.f7588r) != null) {
                    g6.g(null, this.f7589s);
                }
                qVar.f7628j.d0();
                return false;
            }
            boolean z6 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            qVar.f7634p = z6;
            qVar.f7628j.setQwertyMode(z6);
            qVar.f7628j.d0();
        }
        qVar.f7631m = true;
        qVar.f7632n = false;
        this.f7558Q = qVar;
        return true;
    }

    private void M0(boolean z5) {
        G g5 = this.f7588r;
        if (g5 == null || !g5.c() || (ViewConfiguration.get(this.f7579k).hasPermanentMenuKey() && !this.f7588r.d())) {
            q qVarP0 = p0(0, true);
            qVarP0.f7635q = true;
            Y(qVarP0, false);
            I0(qVarP0, null);
            return;
        }
        Window.Callback callbackR0 = r0();
        if (this.f7588r.a() && z5) {
            this.f7588r.e();
            if (this.f7562U) {
                return;
            }
            callbackR0.onPanelClosed(108, p0(0, true).f7628j);
            return;
        }
        if (callbackR0 == null || this.f7562U) {
            return;
        }
        if (this.f7570c0 && (this.f7571d0 & 1) != 0) {
            this.f7581l.getDecorView().removeCallbacks(this.f7572e0);
            this.f7572e0.run();
        }
        q qVarP02 = p0(0, true);
        androidx.appcompat.view.menu.e eVar = qVarP02.f7628j;
        if (eVar == null || qVarP02.f7636r || !callbackR0.onPreparePanel(0, qVarP02.f7627i, eVar)) {
            return;
        }
        callbackR0.onMenuOpened(108, qVarP02.f7628j);
        this.f7588r.f();
    }

    private boolean N(boolean z5) {
        return O(z5, true);
    }

    private int N0(int i5) {
        if (i5 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i5 != 9) {
            return i5;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean O(boolean z5, boolean z6) throws PackageManager.NameNotFoundException {
        if (this.f7562U) {
            return false;
        }
        int iT = T();
        boolean zY0 = Y0(y0(this.f7579k, iT), null, z5);
        if (iT == 0) {
            n0(this.f7579k).e();
        } else {
            n nVar = this.f7568a0;
            if (nVar != null) {
                nVar.a();
            }
        }
        if (iT == 3) {
            m0(this.f7579k).e();
            return zY0;
        }
        n nVar2 = this.f7569b0;
        if (nVar2 != null) {
            nVar2.a();
        }
        return zY0;
    }

    private void Q() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f7546B.findViewById(R.id.content);
        View decorView = this.f7581l.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f7579k.obtainStyledAttributes(g.j.f17215y0);
        typedArrayObtainStyledAttributes.getValue(g.j.f17031K0, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(g.j.f17035L0, contentFrameLayout.getMinWidthMinor());
        int i5 = g.j.f17023I0;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedWidthMajor());
        }
        int i6 = g.j.f17027J0;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            typedArrayObtainStyledAttributes.getValue(i6, contentFrameLayout.getFixedWidthMinor());
        }
        int i7 = g.j.f17013G0;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            typedArrayObtainStyledAttributes.getValue(i7, contentFrameLayout.getFixedHeightMajor());
        }
        int i8 = g.j.f17018H0;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            typedArrayObtainStyledAttributes.getValue(i8, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void R(Window window) {
        if (this.f7581l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof l) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        l lVar = new l(callback);
        this.f7583m = lVar;
        window.setCallback(lVar);
        a0 a0VarU = a0.u(this.f7579k, null, f7543o0);
        Drawable drawableH = a0VarU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        a0VarU.x();
        this.f7581l = window;
        if (this.f7580k0 == null) {
            I(null);
        }
    }

    private boolean R0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f7581l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int T() {
        int i5 = this.f7564W;
        return i5 != -100 ? i5 : androidx.appcompat.app.g.m();
    }

    private void V0() {
        if (this.f7545A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void W() {
        n nVar = this.f7568a0;
        if (nVar != null) {
            nVar.a();
        }
        n nVar2 = this.f7569b0;
        if (nVar2 != null) {
            nVar2.a();
        }
    }

    private androidx.appcompat.app.d W0() {
        for (Context baseContext = this.f7579k; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof androidx.appcompat.app.d) {
                return (androidx.appcompat.app.d) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void X0(Configuration configuration) {
        Activity activity = (Activity) this.f7577j;
        if (activity instanceof InterfaceC0539t) {
            if (((InterfaceC0539t) activity).getLifecycle().b().d(AbstractC0533m.b.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.f7561T || this.f7562U) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean Y0(int r10, androidx.core.os.d r11, boolean r12) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r9 = this;
            android.content.Context r1 = r9.f7579k
            r4 = 0
            r5 = 0
            r0 = r9
            r2 = r10
            r3 = r11
            android.content.res.Configuration r9 = r0.Z(r1, r2, r3, r4, r5)
            android.content.Context r10 = r0.f7579k
            int r10 = r0.l0(r10)
            android.content.res.Configuration r11 = r0.f7563V
            if (r11 != 0) goto L1f
            android.content.Context r11 = r0.f7579k
            android.content.res.Resources r11 = r11.getResources()
            android.content.res.Configuration r11 = r11.getConfiguration()
        L1f:
            int r1 = r11.uiMode
            r1 = r1 & 48
            int r4 = r9.uiMode
            r4 = r4 & 48
            androidx.core.os.d r11 = r0.o0(r11)
            r5 = 0
            if (r3 != 0) goto L30
            r6 = r5
            goto L34
        L30:
            androidx.core.os.d r6 = r0.o0(r9)
        L34:
            r7 = 0
            if (r1 == r4) goto L3a
            r1 = 512(0x200, float:7.17E-43)
            goto L3b
        L3a:
            r1 = r7
        L3b:
            if (r6 == 0) goto L45
            boolean r11 = r11.equals(r6)
            if (r11 != 0) goto L45
            r1 = r1 | 8196(0x2004, float:1.1485E-41)
        L45:
            int r11 = ~r10
            r11 = r11 & r1
            r8 = 1
            if (r11 == 0) goto L86
            if (r12 == 0) goto L86
            boolean r11 = r0.f7560S
            if (r11 == 0) goto L86
            boolean r11 = androidx.appcompat.app.i.f7544p0
            if (r11 != 0) goto L58
            boolean r11 = r0.f7561T
            if (r11 == 0) goto L86
        L58:
            java.lang.Object r11 = r0.f7577j
            boolean r12 = r11 instanceof android.app.Activity
            if (r12 == 0) goto L86
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L86
            r11 = r1 & 8192(0x2000, float:1.148E-41)
            if (r11 == 0) goto L7d
            java.lang.Object r11 = r0.f7577j
            android.app.Activity r11 = (android.app.Activity) r11
            android.view.Window r11 = r11.getWindow()
            android.view.View r11 = r11.getDecorView()
            int r9 = r9.getLayoutDirection()
            r11.setLayoutDirection(r9)
        L7d:
            java.lang.Object r9 = r0.f7577j
            android.app.Activity r9 = (android.app.Activity) r9
            androidx.core.app.a.p(r9)
            r9 = r8
            goto L87
        L86:
            r9 = r7
        L87:
            if (r9 != 0) goto L94
            if (r1 == 0) goto L94
            r9 = r1 & r10
            if (r9 != r1) goto L90
            r7 = r8
        L90:
            r0.a1(r4, r6, r7, r5)
            goto L95
        L94:
            r8 = r9
        L95:
            if (r8 == 0) goto Lb1
            java.lang.Object r9 = r0.f7577j
            boolean r10 = r9 instanceof androidx.appcompat.app.d
            if (r10 == 0) goto Lb1
            r10 = r1 & 512(0x200, float:7.17E-43)
            if (r10 == 0) goto La6
            androidx.appcompat.app.d r9 = (androidx.appcompat.app.d) r9
            r9.y(r2)
        La6:
            r9 = r1 & 4
            if (r9 == 0) goto Lb1
            java.lang.Object r9 = r0.f7577j
            androidx.appcompat.app.d r9 = (androidx.appcompat.app.d) r9
            r9.x(r3)
        Lb1:
            if (r6 == 0) goto Lc4
            android.content.Context r9 = r0.f7579k
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            androidx.core.os.d r9 = r0.o0(r9)
            r0.P0(r9)
        Lc4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.i.Y0(int, androidx.core.os.d, boolean):boolean");
    }

    private Configuration Z(Context context, int i5, androidx.core.os.d dVar, Configuration configuration, boolean z5) {
        int i6 = i5 != 1 ? i5 != 2 ? z5 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i6 | (configuration2.uiMode & (-49));
        if (dVar != null) {
            O0(configuration2, dVar);
        }
        return configuration2;
    }

    private ViewGroup a0() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f7579k.obtainStyledAttributes(g.j.f17215y0);
        int i5 = g.j.f16998D0;
        if (!typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.f17039M0, false)) {
            E(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i5, false)) {
            E(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.f17003E0, false)) {
            E(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.f17008F0, false)) {
            E(10);
        }
        this.f7554J = typedArrayObtainStyledAttributes.getBoolean(g.j.f17220z0, false);
        typedArrayObtainStyledAttributes.recycle();
        h0();
        this.f7581l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f7579k);
        if (this.f7555K) {
            viewGroup = this.f7553I ? (ViewGroup) layoutInflaterFrom.inflate(g.g.f16959o, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(g.g.f16958n, (ViewGroup) null);
        } else if (this.f7554J) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(g.g.f16950f, (ViewGroup) null);
            this.f7552H = false;
            this.f7551G = false;
        } else if (this.f7551G) {
            TypedValue typedValue = new TypedValue();
            this.f7579k.getTheme().resolveAttribute(C0728a.f16830g, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.f7579k, typedValue.resourceId) : this.f7579k).inflate(g.g.f16960p, (ViewGroup) null);
            G g5 = (G) viewGroup.findViewById(g.f.f16934p);
            this.f7588r = g5;
            g5.setWindowCallback(r0());
            if (this.f7552H) {
                this.f7588r.h(109);
            }
            if (this.f7549E) {
                this.f7588r.h(2);
            }
            if (this.f7550F) {
                this.f7588r.h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f7551G + ", windowActionBarOverlay: " + this.f7552H + ", android:windowIsFloating: " + this.f7554J + ", windowActionModeOverlay: " + this.f7553I + ", windowNoTitle: " + this.f7555K + " }");
        }
        H.w0(viewGroup, new b());
        if (this.f7588r == null) {
            this.f7547C = (TextView) viewGroup.findViewById(g.f.f16915C);
        }
        h0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(g.f.f16920b);
        ViewGroup viewGroup2 = (ViewGroup) this.f7581l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f7581l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c());
        return viewGroup;
    }

    private void a1(int i5, androidx.core.os.d dVar, boolean z5, Configuration configuration) {
        Resources resources = this.f7579k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i5 | (resources.getConfiguration().uiMode & (-49));
        if (dVar != null) {
            O0(configuration2, dVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i6 = this.f7565X;
        if (i6 != 0) {
            this.f7579k.setTheme(i6);
            this.f7579k.getTheme().applyStyle(this.f7565X, true);
        }
        if (z5 && (this.f7577j instanceof Activity)) {
            X0(configuration2);
        }
    }

    private void c1(View view) {
        view.setBackgroundColor((H.K(view) & 8192) != 0 ? androidx.core.content.a.c(this.f7579k, g.c.f16852b) : androidx.core.content.a.c(this.f7579k, g.c.f16851a));
    }

    private void g0() {
        if (this.f7545A) {
            return;
        }
        this.f7546B = a0();
        CharSequence charSequenceQ0 = q0();
        if (!TextUtils.isEmpty(charSequenceQ0)) {
            G g5 = this.f7588r;
            if (g5 != null) {
                g5.setWindowTitle(charSequenceQ0);
            } else if (J0() != null) {
                J0().s(charSequenceQ0);
            } else {
                TextView textView = this.f7547C;
                if (textView != null) {
                    textView.setText(charSequenceQ0);
                }
            }
        }
        Q();
        H0(this.f7546B);
        this.f7545A = true;
        q qVarP0 = p0(0, false);
        if (this.f7562U) {
            return;
        }
        if (qVarP0 == null || qVarP0.f7628j == null) {
            w0(108);
        }
    }

    private void h0() {
        if (this.f7581l == null) {
            Object obj = this.f7577j;
            if (obj instanceof Activity) {
                R(((Activity) obj).getWindow());
            }
        }
        if (this.f7581l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration j0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f5 = configuration.fontScale;
            float f6 = configuration2.fontScale;
            if (f5 != f6) {
                configuration3.fontScale = f6;
            }
            int i5 = configuration.mcc;
            int i6 = configuration2.mcc;
            if (i5 != i6) {
                configuration3.mcc = i6;
            }
            int i7 = configuration.mnc;
            int i8 = configuration2.mnc;
            if (i7 != i8) {
                configuration3.mnc = i8;
            }
            C0105i.a(configuration, configuration2, configuration3);
            int i9 = configuration.touchscreen;
            int i10 = configuration2.touchscreen;
            if (i9 != i10) {
                configuration3.touchscreen = i10;
            }
            int i11 = configuration.keyboard;
            int i12 = configuration2.keyboard;
            if (i11 != i12) {
                configuration3.keyboard = i12;
            }
            int i13 = configuration.keyboardHidden;
            int i14 = configuration2.keyboardHidden;
            if (i13 != i14) {
                configuration3.keyboardHidden = i14;
            }
            int i15 = configuration.navigation;
            int i16 = configuration2.navigation;
            if (i15 != i16) {
                configuration3.navigation = i16;
            }
            int i17 = configuration.navigationHidden;
            int i18 = configuration2.navigationHidden;
            if (i17 != i18) {
                configuration3.navigationHidden = i18;
            }
            int i19 = configuration.orientation;
            int i20 = configuration2.orientation;
            if (i19 != i20) {
                configuration3.orientation = i20;
            }
            int i21 = configuration.screenLayout & 15;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 15)) {
                configuration3.screenLayout |= i22 & 15;
            }
            int i23 = configuration.screenLayout & 192;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 192)) {
                configuration3.screenLayout |= i24 & 192;
            }
            int i25 = configuration.screenLayout & 48;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 48)) {
                configuration3.screenLayout |= i26 & 48;
            }
            int i27 = configuration.screenLayout & 768;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 768)) {
                configuration3.screenLayout |= i28 & 768;
            }
            j.a(configuration, configuration2, configuration3);
            int i29 = configuration.uiMode & 15;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 15)) {
                configuration3.uiMode |= i30 & 15;
            }
            int i31 = configuration.uiMode & 48;
            int i32 = configuration2.uiMode;
            if (i31 != (i32 & 48)) {
                configuration3.uiMode |= i32 & 48;
            }
            int i33 = configuration.screenWidthDp;
            int i34 = configuration2.screenWidthDp;
            if (i33 != i34) {
                configuration3.screenWidthDp = i34;
            }
            int i35 = configuration.screenHeightDp;
            int i36 = configuration2.screenHeightDp;
            if (i35 != i36) {
                configuration3.screenHeightDp = i36;
            }
            int i37 = configuration.smallestScreenWidthDp;
            int i38 = configuration2.smallestScreenWidthDp;
            if (i37 != i38) {
                configuration3.smallestScreenWidthDp = i38;
            }
            int i39 = configuration.densityDpi;
            int i40 = configuration2.densityDpi;
            if (i39 != i40) {
                configuration3.densityDpi = i40;
            }
        }
        return configuration3;
    }

    private int l0(Context context) throws PackageManager.NameNotFoundException {
        if (!this.f7567Z && (this.f7577j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f7577j.getClass()), 269221888);
                if (activityInfo != null) {
                    this.f7566Y = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e6) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e6);
                this.f7566Y = 0;
            }
        }
        this.f7567Z = true;
        return this.f7566Y;
    }

    private n m0(Context context) {
        if (this.f7569b0 == null) {
            this.f7569b0 = new m(context);
        }
        return this.f7569b0;
    }

    private n n0(Context context) {
        if (this.f7568a0 == null) {
            this.f7568a0 = new o(androidx.appcompat.app.q.a(context));
        }
        return this.f7568a0;
    }

    private void s0() {
        g0();
        if (this.f7551G && this.f7585o == null) {
            Object obj = this.f7577j;
            if (obj instanceof Activity) {
                this.f7585o = new androidx.appcompat.app.r((Activity) this.f7577j, this.f7552H);
            } else if (obj instanceof Dialog) {
                this.f7585o = new androidx.appcompat.app.r((Dialog) this.f7577j);
            }
            androidx.appcompat.app.a aVar = this.f7585o;
            if (aVar != null) {
                aVar.q(this.f7573f0);
            }
        }
    }

    private boolean t0(q qVar) {
        View view = qVar.f7627i;
        if (view != null) {
            qVar.f7626h = view;
            return true;
        }
        if (qVar.f7628j == null) {
            return false;
        }
        if (this.f7590t == null) {
            this.f7590t = new r();
        }
        View view2 = (View) qVar.a(this.f7590t);
        qVar.f7626h = view2;
        return view2 != null;
    }

    private boolean u0(q qVar) {
        qVar.d(k0());
        qVar.f7625g = new p(qVar.f7630l);
        qVar.f7621c = 81;
        return true;
    }

    private boolean v0(q qVar) {
        Resources.Theme themeNewTheme;
        Context context = this.f7579k;
        int i5 = qVar.f7619a;
        if ((i5 == 0 || i5 == 108) && this.f7588r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(C0728a.f16830g, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(C0728a.f16831h, typedValue, true);
            } else {
                theme.resolveAttribute(C0728a.f16831h, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.S(this);
        qVar.c(eVar);
        return true;
    }

    private void w0(int i5) {
        this.f7571d0 = (1 << i5) | this.f7571d0;
        if (this.f7570c0) {
            return;
        }
        H.b0(this.f7581l.getDecorView(), this.f7572e0);
        this.f7570c0 = true;
    }

    @Override // androidx.appcompat.app.g
    public void A() throws PackageManager.NameNotFoundException {
        O(true, false);
    }

    boolean A0(int i5, KeyEvent keyEvent) {
        if (i5 == 4) {
            this.f7559R = (keyEvent.getFlags() & 128) != 0;
        } else if (i5 == 82) {
            B0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.g
    public void B() {
        androidx.appcompat.app.a aVarQ = q();
        if (aVarQ != null) {
            aVarQ.r(false);
        }
    }

    boolean C0(int i5, KeyEvent keyEvent) {
        androidx.appcompat.app.a aVarQ = q();
        if (aVarQ != null && aVarQ.n(i5, keyEvent)) {
            return true;
        }
        q qVar = this.f7558Q;
        if (qVar != null && K0(qVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            q qVar2 = this.f7558Q;
            if (qVar2 != null) {
                qVar2.f7632n = true;
            }
            return true;
        }
        if (this.f7558Q == null) {
            q qVarP0 = p0(0, true);
            L0(qVarP0, keyEvent);
            boolean zK0 = K0(qVarP0, keyEvent.getKeyCode(), keyEvent, 1);
            qVarP0.f7631m = false;
            if (zK0) {
                return true;
            }
        }
        return false;
    }

    boolean D0(int i5, KeyEvent keyEvent) {
        if (i5 != 4) {
            if (i5 == 82) {
                E0(0, keyEvent);
                return true;
            }
        } else if (z0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.g
    public boolean E(int i5) {
        int iN0 = N0(i5);
        if (this.f7555K && iN0 == 108) {
            return false;
        }
        if (this.f7551G && iN0 == 1) {
            this.f7551G = false;
        }
        if (iN0 == 1) {
            V0();
            this.f7555K = true;
            return true;
        }
        if (iN0 == 2) {
            V0();
            this.f7549E = true;
            return true;
        }
        if (iN0 == 5) {
            V0();
            this.f7550F = true;
            return true;
        }
        if (iN0 == 10) {
            V0();
            this.f7553I = true;
            return true;
        }
        if (iN0 == 108) {
            V0();
            this.f7551G = true;
            return true;
        }
        if (iN0 != 109) {
            return this.f7581l.requestFeature(iN0);
        }
        V0();
        this.f7552H = true;
        return true;
    }

    @Override // androidx.appcompat.app.g
    public void F(int i5) {
        g0();
        ViewGroup viewGroup = (ViewGroup) this.f7546B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f7579k).inflate(i5, viewGroup);
        this.f7583m.c(this.f7581l.getCallback());
    }

    void F0(int i5) {
        androidx.appcompat.app.a aVarQ;
        if (i5 != 108 || (aVarQ = q()) == null) {
            return;
        }
        aVarQ.h(true);
    }

    @Override // androidx.appcompat.app.g
    public void G(View view) {
        g0();
        ViewGroup viewGroup = (ViewGroup) this.f7546B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f7583m.c(this.f7581l.getCallback());
    }

    void G0(int i5) {
        if (i5 == 108) {
            androidx.appcompat.app.a aVarQ = q();
            if (aVarQ != null) {
                aVarQ.h(false);
                return;
            }
            return;
        }
        if (i5 == 0) {
            q qVarP0 = p0(i5, true);
            if (qVarP0.f7633o) {
                Y(qVarP0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.g
    public void H(View view, ViewGroup.LayoutParams layoutParams) {
        g0();
        ViewGroup viewGroup = (ViewGroup) this.f7546B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f7583m.c(this.f7581l.getCallback());
    }

    void H0(ViewGroup viewGroup) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // androidx.appcompat.app.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void I(android.window.OnBackInvokedDispatcher r3) {
        /*
            r2 = this;
            super.I(r3)
            android.window.OnBackInvokedDispatcher r0 = r2.f7580k0
            if (r0 == 0) goto L11
            android.window.OnBackInvokedCallback r1 = r2.f7582l0
            if (r1 == 0) goto L11
            androidx.appcompat.app.i.k.c(r0, r1)
            r0 = 0
            r2.f7582l0 = r0
        L11:
            if (r3 != 0) goto L2c
            java.lang.Object r0 = r2.f7577j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L2c
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L2c
            java.lang.Object r3 = r2.f7577j
            android.app.Activity r3 = (android.app.Activity) r3
            android.window.OnBackInvokedDispatcher r3 = androidx.appcompat.app.i.k.a(r3)
            r2.f7580k0 = r3
            goto L2e
        L2c:
            r2.f7580k0 = r3
        L2e:
            r2.Z0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.i.I(android.window.OnBackInvokedDispatcher):void");
    }

    @Override // androidx.appcompat.app.g
    public void J(int i5) {
        this.f7565X = i5;
    }

    final androidx.appcompat.app.a J0() {
        return this.f7585o;
    }

    @Override // androidx.appcompat.app.g
    public final void K(CharSequence charSequence) {
        this.f7587q = charSequence;
        G g5 = this.f7588r;
        if (g5 != null) {
            g5.setWindowTitle(charSequence);
            return;
        }
        if (J0() != null) {
            J0().s(charSequence);
            return;
        }
        TextView textView = this.f7547C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    void O0(Configuration configuration, androidx.core.os.d dVar) {
        C0105i.d(configuration, dVar);
    }

    public boolean P() {
        return N(true);
    }

    void P0(androidx.core.os.d dVar) {
        C0105i.c(dVar);
    }

    final boolean Q0() {
        ViewGroup viewGroup;
        return this.f7545A && (viewGroup = this.f7546B) != null && viewGroup.isLaidOut();
    }

    androidx.core.os.d S(Context context) {
        return null;
    }

    boolean S0() {
        if (this.f7580k0 == null) {
            return false;
        }
        q qVarP0 = p0(0, false);
        return (qVarP0 != null && qVarP0.f7633o) || this.f7591u != null;
    }

    public androidx.appcompat.view.b T0(b.a aVar) {
        androidx.appcompat.app.e eVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar = this.f7591u;
        if (bVar != null) {
            bVar.c();
        }
        g gVar = new g(aVar);
        androidx.appcompat.app.a aVarQ = q();
        if (aVarQ != null) {
            androidx.appcompat.view.b bVarT = aVarQ.t(gVar);
            this.f7591u = bVarT;
            if (bVarT != null && (eVar = this.f7584n) != null) {
                eVar.a(bVarT);
            }
        }
        if (this.f7591u == null) {
            this.f7591u = U0(gVar);
        }
        Z0();
        return this.f7591u;
    }

    void U(int i5, q qVar, Menu menu) {
        if (menu == null) {
            if (qVar == null && i5 >= 0) {
                q[] qVarArr = this.f7557M;
                if (i5 < qVarArr.length) {
                    qVar = qVarArr[i5];
                }
            }
            if (qVar != null) {
                menu = qVar.f7628j;
            }
        }
        if ((qVar == null || qVar.f7633o) && !this.f7562U) {
            this.f7583m.d(this.f7581l.getCallback(), i5, menu);
        }
    }

    androidx.appcompat.view.b U0(b.a aVar) {
        androidx.appcompat.view.b bVarF;
        Context dVar;
        androidx.appcompat.app.e eVar;
        f0();
        androidx.appcompat.view.b bVar = this.f7591u;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof g)) {
            aVar = new g(aVar);
        }
        androidx.appcompat.app.e eVar2 = this.f7584n;
        if (eVar2 == null || this.f7562U) {
            bVarF = null;
        } else {
            try {
                bVarF = eVar2.f(aVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (bVarF != null) {
            this.f7591u = bVarF;
        } else {
            if (this.f7592v == null) {
                if (this.f7554J) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f7579k.getTheme();
                    theme.resolveAttribute(C0728a.f16830g, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f7579k.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new androidx.appcompat.view.d(this.f7579k, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f7579k;
                    }
                    this.f7592v = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, C0728a.f16834k);
                    this.f7593w = popupWindow;
                    androidx.core.widget.g.b(popupWindow, 2);
                    this.f7593w.setContentView(this.f7592v);
                    this.f7593w.setWidth(-1);
                    dVar.getTheme().resolveAttribute(C0728a.f16825b, typedValue, true);
                    this.f7592v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.f7593w.setHeight(-2);
                    this.f7594x = new d();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f7546B.findViewById(g.f.f16926h);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(k0()));
                        this.f7592v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f7592v != null) {
                f0();
                this.f7592v.k();
                androidx.appcompat.view.e eVar3 = new androidx.appcompat.view.e(this.f7592v.getContext(), this.f7592v, aVar, this.f7593w == null);
                if (aVar.b(eVar3, eVar3.e())) {
                    eVar3.k();
                    this.f7592v.h(eVar3);
                    this.f7591u = eVar3;
                    if (Q0()) {
                        this.f7592v.setAlpha(0.0f);
                        S sB = H.d(this.f7592v).b(1.0f);
                        this.f7595y = sB;
                        sB.j(new e());
                    } else {
                        this.f7592v.setAlpha(1.0f);
                        this.f7592v.setVisibility(0);
                        if (this.f7592v.getParent() instanceof View) {
                            H.g0((View) this.f7592v.getParent());
                        }
                    }
                    if (this.f7593w != null) {
                        this.f7581l.getDecorView().post(this.f7594x);
                    }
                } else {
                    this.f7591u = null;
                }
            }
        }
        androidx.appcompat.view.b bVar2 = this.f7591u;
        if (bVar2 != null && (eVar = this.f7584n) != null) {
            eVar.a(bVar2);
        }
        Z0();
        return this.f7591u;
    }

    void V(androidx.appcompat.view.menu.e eVar) {
        if (this.f7556L) {
            return;
        }
        this.f7556L = true;
        this.f7588r.i();
        Window.Callback callbackR0 = r0();
        if (callbackR0 != null && !this.f7562U) {
            callbackR0.onPanelClosed(108, eVar);
        }
        this.f7556L = false;
    }

    void X(int i5) {
        Y(p0(i5, true), true);
    }

    void Y(q qVar, boolean z5) {
        ViewGroup viewGroup;
        G g5;
        if (z5 && qVar.f7619a == 0 && (g5 = this.f7588r) != null && g5.a()) {
            V(qVar.f7628j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f7579k.getSystemService("window");
        if (windowManager != null && qVar.f7633o && (viewGroup = qVar.f7625g) != null) {
            windowManager.removeView(viewGroup);
            if (z5) {
                U(qVar.f7619a, qVar, null);
            }
        }
        qVar.f7631m = false;
        qVar.f7632n = false;
        qVar.f7633o = false;
        qVar.f7626h = null;
        qVar.f7635q = true;
        if (this.f7558Q == qVar) {
            this.f7558Q = null;
        }
        if (qVar.f7619a == 0) {
            Z0();
        }
    }

    void Z0() {
        OnBackInvokedCallback onBackInvokedCallback;
        boolean zS0 = S0();
        if (zS0 && this.f7582l0 == null) {
            this.f7582l0 = k.b(this.f7580k0, this);
        } else {
            if (zS0 || (onBackInvokedCallback = this.f7582l0) == null) {
                return;
            }
            k.c(this.f7580k0, onBackInvokedCallback);
            this.f7582l0 = null;
        }
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        q qVarI0;
        Window.Callback callbackR0 = r0();
        if (callbackR0 == null || this.f7562U || (qVarI0 = i0(eVar.D())) == null) {
            return false;
        }
        return callbackR0.onMenuItemSelected(qVarI0.f7619a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        M0(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View b0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z5;
        if (this.f7576i0 == null) {
            TypedArray typedArrayObtainStyledAttributes = this.f7579k.obtainStyledAttributes(g.j.f17215y0);
            String string = typedArrayObtainStyledAttributes.getString(g.j.f16993C0);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.f7576i0 = new androidx.appcompat.app.m();
            } else {
                try {
                    this.f7576i0 = (androidx.appcompat.app.m) this.f7579k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f7576i0 = new androidx.appcompat.app.m();
                }
            }
        }
        boolean z6 = f7542n0;
        boolean zR0 = false;
        if (z6) {
            if (this.f7578j0 == null) {
                this.f7578j0 = new androidx.appcompat.app.o();
            }
            if (this.f7578j0.a(attributeSet)) {
                z5 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zR0 = R0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zR0 = true;
                }
                z5 = zR0;
            }
        } else {
            z5 = zR0;
        }
        return this.f7576i0.r(view, str, context, attributeSet, z5, z6, true, g0.c());
    }

    final int b1(Y y5, Rect rect) {
        boolean z5;
        boolean z6;
        int iK = y5 != null ? y5.k() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f7592v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z5 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f7592v.getLayoutParams();
            if (this.f7592v.isShown()) {
                if (this.f7574g0 == null) {
                    this.f7574g0 = new Rect();
                    this.f7575h0 = new Rect();
                }
                Rect rect2 = this.f7574g0;
                Rect rect3 = this.f7575h0;
                if (y5 == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(y5.i(), y5.k(), y5.j(), y5.h());
                }
                h0.a(this.f7546B, rect2, rect3);
                int i5 = rect2.top;
                int i6 = rect2.left;
                int i7 = rect2.right;
                Y yD = H.D(this.f7546B);
                int i8 = yD == null ? 0 : yD.i();
                int iJ = yD == null ? 0 : yD.j();
                if (marginLayoutParams.topMargin == i5 && marginLayoutParams.leftMargin == i6 && marginLayoutParams.rightMargin == i7) {
                    z6 = false;
                } else {
                    marginLayoutParams.topMargin = i5;
                    marginLayoutParams.leftMargin = i6;
                    marginLayoutParams.rightMargin = i7;
                    z6 = true;
                }
                if (i5 <= 0 || this.f7548D != null) {
                    View view = this.f7548D;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i9 = marginLayoutParams2.height;
                        int i10 = marginLayoutParams.topMargin;
                        if (i9 != i10 || marginLayoutParams2.leftMargin != i8 || marginLayoutParams2.rightMargin != iJ) {
                            marginLayoutParams2.height = i10;
                            marginLayoutParams2.leftMargin = i8;
                            marginLayoutParams2.rightMargin = iJ;
                            this.f7548D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f7579k);
                    this.f7548D = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i8;
                    layoutParams.rightMargin = iJ;
                    this.f7546B.addView(this.f7548D, -1, layoutParams);
                }
                View view3 = this.f7548D;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    c1(this.f7548D);
                }
                if (!this.f7553I && z) {
                    iK = 0;
                }
                z5 = z;
                z = z6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z5 = false;
            } else {
                z5 = false;
                z = false;
            }
            if (z) {
                this.f7592v.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f7548D;
        if (view4 != null) {
            view4.setVisibility(z5 ? 0 : 8);
        }
        return iK;
    }

    void c0() {
        androidx.appcompat.view.menu.e eVar;
        G g5 = this.f7588r;
        if (g5 != null) {
            g5.i();
        }
        if (this.f7593w != null) {
            this.f7581l.getDecorView().removeCallbacks(this.f7594x);
            if (this.f7593w.isShowing()) {
                try {
                    this.f7593w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f7593w = null;
        }
        f0();
        q qVarP0 = p0(0, false);
        if (qVarP0 == null || (eVar = qVarP0.f7628j) == null) {
            return;
        }
        eVar.close();
    }

    boolean d0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f7577j;
        if (((obj instanceof C0465j.a) || (obj instanceof androidx.appcompat.app.l)) && (decorView = this.f7581l.getDecorView()) != null && C0465j.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f7583m.b(this.f7581l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? A0(keyCode, keyEvent) : D0(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.app.g
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        g0();
        ((ViewGroup) this.f7546B.findViewById(R.id.content)).addView(view, layoutParams);
        this.f7583m.c(this.f7581l.getCallback());
    }

    void e0(int i5) {
        q qVarP0;
        q qVarP02 = p0(i5, true);
        if (qVarP02.f7628j != null) {
            Bundle bundle = new Bundle();
            qVarP02.f7628j.R(bundle);
            if (bundle.size() > 0) {
                qVarP02.f7637s = bundle;
            }
            qVarP02.f7628j.e0();
            qVarP02.f7628j.clear();
        }
        qVarP02.f7636r = true;
        qVarP02.f7635q = true;
        if ((i5 != 108 && i5 != 0) || this.f7588r == null || (qVarP0 = p0(0, false)) == null) {
            return;
        }
        qVarP0.f7631m = false;
        L0(qVarP0, null);
    }

    void f0() {
        S s5 = this.f7595y;
        if (s5 != null) {
            s5.c();
        }
    }

    @Override // androidx.appcompat.app.g
    public Context g(Context context) {
        i iVar;
        Context context2;
        this.f7560S = true;
        int iY0 = y0(context, T());
        if (androidx.appcompat.app.g.t(context)) {
            androidx.appcompat.app.g.M(context);
        }
        androidx.core.os.d dVarS = S(context);
        if (context instanceof ContextThemeWrapper) {
            iVar = this;
            context2 = context;
            try {
                ((ContextThemeWrapper) context2).applyOverrideConfiguration(iVar.Z(context2, iY0, dVarS, null, false));
                return context2;
            } catch (IllegalStateException unused) {
            }
        } else {
            iVar = this;
            context2 = context;
        }
        if (context2 instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context2).a(iVar.Z(context2, iY0, dVarS, null, false));
                return context2;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f7544p0) {
            return super.g(context2);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context2.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context2.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationZ = iVar.Z(context2, iY0, dVarS, !configuration2.equals(configuration3) ? j0(configuration2, configuration3) : null, true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context2, g.i.f16979d);
        dVar.a(configurationZ);
        try {
            if (context2.getTheme() != null) {
                h.f.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.g(dVar);
    }

    q i0(Menu menu) {
        q[] qVarArr = this.f7557M;
        int length = qVarArr != null ? qVarArr.length : 0;
        for (int i5 = 0; i5 < length; i5++) {
            q qVar = qVarArr[i5];
            if (qVar != null && qVar.f7628j == menu) {
                return qVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.g
    public <T extends View> T j(int i5) {
        g0();
        return (T) this.f7581l.findViewById(i5);
    }

    final Context k0() {
        androidx.appcompat.app.a aVarQ = q();
        Context contextJ = aVarQ != null ? aVarQ.j() : null;
        return contextJ == null ? this.f7579k : contextJ;
    }

    @Override // androidx.appcompat.app.g
    public Context l() {
        return this.f7579k;
    }

    @Override // androidx.appcompat.app.g
    public int n() {
        return this.f7564W;
    }

    androidx.core.os.d o0(Configuration configuration) {
        return C0105i.b(configuration);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return b0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.g
    public MenuInflater p() {
        if (this.f7586p == null) {
            s0();
            androidx.appcompat.app.a aVar = this.f7585o;
            this.f7586p = new androidx.appcompat.view.g(aVar != null ? aVar.j() : this.f7579k);
        }
        return this.f7586p;
    }

    protected q p0(int i5, boolean z5) {
        q[] qVarArr = this.f7557M;
        if (qVarArr == null || qVarArr.length <= i5) {
            q[] qVarArr2 = new q[i5 + 1];
            if (qVarArr != null) {
                System.arraycopy(qVarArr, 0, qVarArr2, 0, qVarArr.length);
            }
            this.f7557M = qVarArr2;
            qVarArr = qVarArr2;
        }
        q qVar = qVarArr[i5];
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q(i5);
        qVarArr[i5] = qVar2;
        return qVar2;
    }

    @Override // androidx.appcompat.app.g
    public androidx.appcompat.app.a q() {
        s0();
        return this.f7585o;
    }

    final CharSequence q0() {
        Object obj = this.f7577j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f7587q;
    }

    @Override // androidx.appcompat.app.g
    public void r() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f7579k);
        if (layoutInflaterFrom.getFactory() == null) {
            C0466k.a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof i) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    final Window.Callback r0() {
        return this.f7581l.getCallback();
    }

    @Override // androidx.appcompat.app.g
    public void s() {
        if (J0() == null || q().k()) {
            return;
        }
        w0(0);
    }

    @Override // androidx.appcompat.app.g
    public void u(Configuration configuration) throws PackageManager.NameNotFoundException {
        androidx.appcompat.app.a aVarQ;
        if (this.f7551G && this.f7545A && (aVarQ = q()) != null) {
            aVarQ.l(configuration);
        }
        C0441k.b().g(this.f7579k);
        this.f7563V = new Configuration(this.f7579k.getResources().getConfiguration());
        O(false, false);
    }

    @Override // androidx.appcompat.app.g
    public void v(Bundle bundle) {
        String strC;
        this.f7560S = true;
        N(false);
        h0();
        Object obj = this.f7577j;
        if (obj instanceof Activity) {
            try {
                strC = androidx.core.app.h.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                androidx.appcompat.app.a aVarJ0 = J0();
                if (aVarJ0 == null) {
                    this.f7573f0 = true;
                } else {
                    aVarJ0.q(true);
                }
            }
            androidx.appcompat.app.g.d(this);
        }
        this.f7563V = new Configuration(this.f7579k.getResources().getConfiguration());
        this.f7561T = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    @Override // androidx.appcompat.app.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f7577j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.g.C(r3)
        L9:
            boolean r0 = r3.f7570c0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f7581l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f7572e0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.f7562U = r0
            int r0 = r3.f7564W
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f7577j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            q.i<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.i.f7541m0
            java.lang.Object r1 = r3.f7577j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f7564W
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            q.i<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.i.f7541m0
            java.lang.Object r1 = r3.f7577j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.a r0 = r3.f7585o
            if (r0 == 0) goto L5b
            r0.m()
        L5b:
            r3.W()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.i.w():void");
    }

    @Override // androidx.appcompat.app.g
    public void x(Bundle bundle) {
        g0();
    }

    public boolean x0() {
        return this.f7596z;
    }

    @Override // androidx.appcompat.app.g
    public void y() {
        androidx.appcompat.app.a aVarQ = q();
        if (aVarQ != null) {
            aVarQ.r(true);
        }
    }

    int y0(Context context, int i5) {
        if (i5 == -100) {
            return -1;
        }
        if (i5 != -1) {
            if (i5 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return n0(context).c();
            }
            if (i5 != 1 && i5 != 2) {
                if (i5 == 3) {
                    return m0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i5;
    }

    @Override // androidx.appcompat.app.g
    public void z(Bundle bundle) {
    }

    boolean z0() {
        boolean z5 = this.f7559R;
        this.f7559R = false;
        q qVarP0 = p0(0, false);
        if (qVarP0 != null && qVarP0.f7633o) {
            if (!z5) {
                Y(qVarP0, true);
            }
            return true;
        }
        androidx.appcompat.view.b bVar = this.f7591u;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a aVarQ = q();
        return aVarQ != null && aVarQ.g();
    }

    i(Dialog dialog, androidx.appcompat.app.e eVar) {
        this(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private i(Context context, Window window, androidx.appcompat.app.e eVar, Object obj) {
        q.i<String, Integer> iVar;
        Integer num;
        androidx.appcompat.app.d dVarW0;
        this.f7595y = null;
        this.f7596z = true;
        this.f7564W = -100;
        this.f7572e0 = new a();
        this.f7579k = context;
        this.f7584n = eVar;
        this.f7577j = obj;
        if (this.f7564W == -100 && (obj instanceof Dialog) && (dVarW0 = W0()) != null) {
            this.f7564W = dVarW0.t().n();
        }
        if (this.f7564W == -100 && (num = (iVar = f7541m0).get(obj.getClass().getName())) != null) {
            this.f7564W = num.intValue();
            iVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            R(window);
        }
        C0441k.h();
    }
}
