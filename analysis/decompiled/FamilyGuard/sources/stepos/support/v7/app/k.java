package stepos.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
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
import androidx.appcompat.widget.C0441k;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.core.view.H;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.L;
import androidx.core.view.S;
import androidx.core.view.U;
import androidx.core.view.Y;
import androidx.recyclerview.widget.RecyclerView;
import b5.b;
import g.C0728a;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.C;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
class k extends stepos.support.v7.app.g implements d.a {

    /* renamed from: A, reason: collision with root package name */
    private ViewGroup f20788A;

    /* renamed from: B, reason: collision with root package name */
    private TextView f20789B;

    /* renamed from: C, reason: collision with root package name */
    private View f20790C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f20791D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f20792E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f20793F;

    /* renamed from: G, reason: collision with root package name */
    private C0244k[] f20794G;

    /* renamed from: H, reason: collision with root package name */
    private C0244k f20795H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f20796I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f20797J;

    /* renamed from: K, reason: collision with root package name */
    private int f20798K;

    /* renamed from: L, reason: collision with root package name */
    private final Runnable f20799L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f20800M;

    /* renamed from: Q, reason: collision with root package name */
    private Rect f20801Q;

    /* renamed from: R, reason: collision with root package name */
    private Rect f20802R;

    /* renamed from: S, reason: collision with root package name */
    private final d.a f20803S;

    /* renamed from: T, reason: collision with root package name */
    private View.OnClickListener f20804T;

    /* renamed from: r, reason: collision with root package name */
    private stepos.support.v7.widget.l f20805r;

    /* renamed from: s, reason: collision with root package name */
    private h f20806s;

    /* renamed from: t, reason: collision with root package name */
    private l f20807t;

    /* renamed from: u, reason: collision with root package name */
    b5.b f20808u;

    /* renamed from: v, reason: collision with root package name */
    ActionBarContextView f20809v;

    /* renamed from: w, reason: collision with root package name */
    PopupWindow f20810w;

    /* renamed from: x, reason: collision with root package name */
    Runnable f20811x;

    /* renamed from: y, reason: collision with root package name */
    S f20812y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f20813z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((k.this.f20798K & 1) != 0) {
                k.this.o0(0);
            }
            if ((k.this.f20798K & RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT) != 0) {
                k.this.o0(108);
            }
            k.this.f20797J = false;
            k.this.f20798K = 0;
        }
    }

    class b implements d.a {
        b() {
        }

        @Override // stepos.support.v7.view.menu.d.a
        public boolean c(stepos.support.v7.view.menu.d dVar, MenuItem menuItem) {
            return k.this.z0(dVar, menuItem);
        }

        @Override // stepos.support.v7.view.menu.d.a
        public void d(stepos.support.v7.view.menu.d dVar) {
        }
    }

    class c implements InterfaceC0479y {
        c() {
        }

        @Override // androidx.core.view.InterfaceC0479y
        public Y a(View view, Y y5) {
            int iK = y5.k();
            int iN0 = k.this.N0(iK);
            if (iK != iN0) {
                y5 = y5.o(y5.i(), iN0, y5.j(), y5.h());
            }
            return H.W(view, y5);
        }
    }

    class d implements ContentFrameLayout.a {
        d() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            k.this.n0();
        }
    }

    class e implements Runnable {

        class a extends U {
            a() {
            }

            @Override // androidx.core.view.U, androidx.core.view.T
            public void d(View view) {
                H.n0(k.this.f20809v, 1.0f);
                k.this.f20812y.j(null);
                k.this.f20812y = null;
            }

            @Override // androidx.core.view.U, androidx.core.view.T
            public void e(View view) {
                k.this.f20809v.setVisibility(0);
            }
        }

        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = k.this;
            kVar.f20810w.showAtLocation(kVar.f20809v, 55, 0, 0);
            k.this.p0();
            H.n0(k.this.f20809v, 0.0f);
            k kVar2 = k.this;
            kVar2.f20812y = H.d(kVar2.f20809v).b(1.0f);
            k.this.f20812y.j(new a());
        }
    }

    class f extends U {
        f() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            H.n0(k.this.f20809v, 1.0f);
            k.this.f20812y.j(null);
            k.this.f20812y = null;
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void e(View view) {
            k.this.f20809v.setVisibility(0);
            k.this.f20809v.sendAccessibilityEvent(32);
            if (k.this.f20809v.getParent() != null) {
                H.g0((View) k.this.f20809v.getParent());
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar = k.this;
            if (kVar.f20765f == null || kVar.N()) {
                return;
            }
            k.this.f20765f.onBackTopTouch();
        }
    }

    private final class h implements h.a {
        private h() {
        }

        @Override // stepos.support.v7.view.menu.h.a
        public void a(stepos.support.v7.view.menu.d dVar, boolean z5) {
            k.this.j0(dVar);
        }

        @Override // stepos.support.v7.view.menu.h.a
        public boolean b(stepos.support.v7.view.menu.d dVar) {
            Window.Callback callbackL = k.this.L();
            if (callbackL == null) {
                return true;
            }
            callbackL.onMenuOpened(108, dVar);
            return true;
        }

        /* synthetic */ h(k kVar, a aVar) {
            this();
        }
    }

    class i implements b.InterfaceC0154b {

        /* renamed from: a, reason: collision with root package name */
        private b.InterfaceC0154b f20823a;

        class a extends U {
            a() {
            }

            @Override // androidx.core.view.U, androidx.core.view.T
            public void d(View view) {
                k.this.f20809v.setVisibility(8);
                k kVar = k.this;
                PopupWindow popupWindow = kVar.f20810w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (kVar.f20809v.getParent() instanceof View) {
                    H.g0((View) k.this.f20809v.getParent());
                }
                k.this.f20809v.removeAllViews();
                k.this.f20812y.j(null);
                k.this.f20812y = null;
            }
        }

        public i(b.InterfaceC0154b interfaceC0154b) {
            this.f20823a = interfaceC0154b;
        }

        @Override // b5.b.InterfaceC0154b
        public boolean a(b5.b bVar, MenuItem menuItem) {
            return this.f20823a.a(bVar, menuItem);
        }

        @Override // b5.b.InterfaceC0154b
        public boolean b(b5.b bVar, Menu menu) {
            return this.f20823a.b(bVar, menu);
        }

        @Override // b5.b.InterfaceC0154b
        public void c(b5.b bVar) {
            this.f20823a.c(bVar);
            k kVar = k.this;
            if (kVar.f20810w != null) {
                kVar.f20762c.getDecorView().removeCallbacks(k.this.f20811x);
            }
            k kVar2 = k.this;
            if (kVar2.f20809v != null) {
                kVar2.p0();
                k kVar3 = k.this;
                kVar3.f20812y = H.d(kVar3.f20809v).b(0.0f);
                k.this.f20812y.j(new a());
            }
            k kVar4 = k.this;
            stepos.support.v7.app.e eVar = kVar4.f20765f;
            if (eVar != null) {
                eVar.onSupportActionModeFinished(kVar4.f20808u);
            }
            k.this.f20808u = null;
        }

        @Override // b5.b.InterfaceC0154b
        public boolean d(b5.b bVar, Menu menu) {
            return this.f20823a.d(bVar, menu);
        }
    }

    private class j extends ContentFrameLayout {
        public j(Context context) {
            super(context);
        }

        private boolean a(int i5, int i6) {
            return i5 < -5 || i6 < -5 || i5 > getWidth() + 5 || i6 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return k.this.I(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            k.this.k0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i5) {
            setBackgroundDrawable(C0441k.b().c(getContext(), i5));
        }
    }

    /* renamed from: stepos.support.v7.app.k$k, reason: collision with other inner class name */
    private static final class C0244k {

        /* renamed from: a, reason: collision with root package name */
        int f20827a;

        /* renamed from: b, reason: collision with root package name */
        int f20828b;

        /* renamed from: c, reason: collision with root package name */
        int f20829c;

        /* renamed from: d, reason: collision with root package name */
        int f20830d;

        /* renamed from: e, reason: collision with root package name */
        int f20831e;

        /* renamed from: f, reason: collision with root package name */
        int f20832f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f20833g;

        /* renamed from: h, reason: collision with root package name */
        View f20834h;

        /* renamed from: i, reason: collision with root package name */
        View f20835i;

        /* renamed from: j, reason: collision with root package name */
        stepos.support.v7.view.menu.d f20836j;

        /* renamed from: k, reason: collision with root package name */
        stepos.support.v7.view.menu.c f20837k;

        /* renamed from: l, reason: collision with root package name */
        Context f20838l;

        /* renamed from: m, reason: collision with root package name */
        boolean f20839m;

        /* renamed from: n, reason: collision with root package name */
        boolean f20840n;

        /* renamed from: o, reason: collision with root package name */
        boolean f20841o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f20842p;

        /* renamed from: q, reason: collision with root package name */
        boolean f20843q = false;

        /* renamed from: r, reason: collision with root package name */
        boolean f20844r;

        /* renamed from: s, reason: collision with root package name */
        Bundle f20845s;

        /* renamed from: t, reason: collision with root package name */
        private stepos.support.v7.view.menu.d f20846t;

        C0244k(int i5) {
            this.f20827a = i5;
        }

        stepos.support.v7.view.menu.i b(h.a aVar) {
            if (this.f20836j == null) {
                return null;
            }
            if (this.f20837k == null) {
                stepos.support.v7.view.menu.c cVar = new stepos.support.v7.view.menu.c(this.f20838l, X4.h.f6044p);
                this.f20837k = cVar;
                cVar.k(aVar);
                this.f20836j.b(this.f20837k);
            }
            return this.f20837k.j(this.f20833g);
        }

        public boolean c() {
            if (this.f20834h == null) {
                return false;
            }
            return this.f20835i != null || this.f20837k.i().getCount() > 0;
        }

        void d(stepos.support.v7.view.menu.d dVar) {
            if (dVar == this.f20846t) {
                return;
            }
            this.f20846t = dVar;
        }

        void e(stepos.support.v7.view.menu.d dVar) {
            stepos.support.v7.view.menu.c cVar;
            stepos.support.v7.view.menu.d dVar2 = this.f20836j;
            if (dVar == dVar2) {
                return;
            }
            if (dVar2 != null) {
                dVar2.N(this.f20837k);
            }
            this.f20836j = dVar;
            if (dVar == null || (cVar = this.f20837k) == null) {
                return;
            }
            dVar.b(cVar);
        }

        void f(Context context) {
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
            this.f20838l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(g.j.f17215y0);
            this.f20828b = typedArrayObtainStyledAttributes.getResourceId(g.j.f16988B0, 0);
            this.f20832f = typedArrayObtainStyledAttributes.getResourceId(g.j.f16983A0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final class l implements h.a {
        private l() {
        }

        @Override // stepos.support.v7.view.menu.h.a
        public void a(stepos.support.v7.view.menu.d dVar, boolean z5) {
            stepos.support.v7.view.menu.d dVarD = dVar.D();
            boolean z6 = dVarD != dVar;
            k kVar = k.this;
            if (z6) {
                dVar = dVarD;
            }
            C0244k c0244kR0 = kVar.r0(dVar);
            if (c0244kR0 != null) {
                if (!z6) {
                    k.this.l0(c0244kR0, z5);
                } else {
                    k.this.i0(c0244kR0.f20827a, c0244kR0, dVarD);
                    k.this.l0(c0244kR0, true);
                }
            }
        }

        @Override // stepos.support.v7.view.menu.h.a
        public boolean b(stepos.support.v7.view.menu.d dVar) {
            Window.Callback callbackL;
            if (dVar != null) {
                return true;
            }
            k kVar = k.this;
            if (!kVar.f20768i || (callbackL = kVar.L()) == null || k.this.N()) {
                return true;
            }
            callbackL.onMenuOpened(108, dVar);
            return true;
        }

        /* synthetic */ l(k kVar, a aVar) {
            this();
        }
    }

    k(Context context, Window window, stepos.support.v7.app.e eVar) {
        super(context, window, eVar);
        this.f20812y = null;
        this.f20799L = new a();
        this.f20803S = new b();
        this.f20804T = new g();
    }

    private boolean B0(int i5, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        C0244k c0244kS0 = s0(i5, true);
        if (c0244kS0.f20841o) {
            return false;
        }
        return I0(c0244kS0, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean D0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            b5.b r0 = r4.f20808u
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            stepos.support.v7.app.k$k r2 = r4.s0(r5, r0)
            if (r5 != 0) goto L45
            stepos.support.v7.widget.l r5 = r4.f20805r
            if (r5 == 0) goto L45
            boolean r5 = r5.c()
            if (r5 == 0) goto L45
            android.content.Context r5 = r4.f20761b
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = androidx.core.view.L.j(r5)
            if (r5 != 0) goto L45
            stepos.support.v7.widget.l r5 = r4.f20805r
            boolean r5 = r5.a()
            if (r5 != 0) goto L3e
            boolean r5 = r4.N()
            if (r5 != 0) goto L64
            boolean r5 = r4.I0(r2, r6)
            if (r5 == 0) goto L64
            stepos.support.v7.widget.l r5 = r4.f20805r
            boolean r0 = r5.f()
            goto L6a
        L3e:
            stepos.support.v7.widget.l r5 = r4.f20805r
            boolean r0 = r5.e()
            goto L6a
        L45:
            boolean r5 = r2.f20841o
            if (r5 != 0) goto L66
            boolean r3 = r2.f20840n
            if (r3 == 0) goto L4e
            goto L66
        L4e:
            boolean r5 = r2.f20839m
            if (r5 == 0) goto L64
            boolean r5 = r2.f20844r
            if (r5 == 0) goto L5d
            r2.f20839m = r1
            boolean r5 = r4.I0(r2, r6)
            goto L5e
        L5d:
            r5 = r0
        L5e:
            if (r5 == 0) goto L64
            r4.F0(r2, r6)
            goto L6a
        L64:
            r0 = r1
            goto L6a
        L66:
            r4.l0(r2, r0)
            r0 = r5
        L6a:
            if (r0 == 0) goto L83
            android.content.Context r4 = r4.f20761b
            java.lang.String r5 = "audio"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L7c
            r4.playSoundEffect(r1)
            return r0
        L7c:
            java.lang.String r4 = "AppCompatDelegate"
            java.lang.String r5 = "Couldn't get audio manager"
            android.util.Log.w(r4, r5)
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.k.D0(int, android.view.KeyEvent):boolean");
    }

    private void F0(C0244k c0244k, KeyEvent keyEvent) {
        if (c0244k.f20841o || N()) {
            return;
        }
        if (c0244k.f20827a == 0) {
            Context context = this.f20761b;
            boolean z5 = (context.getResources().getConfiguration().screenLayout & 15) == 4;
            boolean z6 = context.getApplicationInfo().targetSdkVersion >= 11;
            if (z5 && z6) {
                return;
            }
        }
        Window.Callback callbackL = L();
        if (callbackL != null && !callbackL.onMenuOpened(c0244k.f20827a, c0244k.f20836j)) {
            l0(c0244k, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f20761b.getSystemService("window");
        if (windowManager != null && I0(c0244k, keyEvent)) {
            ViewGroup viewGroup = c0244k.f20833g;
            int i5 = -2;
            if (viewGroup == null || c0244k.f20843q) {
                if (viewGroup == null) {
                    if (!v0(c0244k) || c0244k.f20833g == null) {
                        return;
                    }
                } else if (c0244k.f20843q && viewGroup.getChildCount() > 0) {
                    c0244k.f20833g.removeAllViews();
                }
                if (!u0(c0244k) || !c0244k.c()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = c0244k.f20834h.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                c0244k.f20833g.setBackgroundResource(c0244k.f20828b);
                ViewParent parent = c0244k.f20834h.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(c0244k.f20834h);
                }
                c0244k.f20833g.addView(c0244k.f20834h, layoutParams);
                if (!c0244k.f20834h.hasFocus()) {
                    c0244k.f20834h.requestFocus();
                }
            } else {
                View view = c0244k.f20835i;
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    if (layoutParams2 != null && layoutParams2.width == -1) {
                        i5 = -1;
                    }
                } else if (!c0244k.c()) {
                    return;
                }
            }
            int i6 = i5;
            c0244k.f20840n = false;
            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i6, -2, c0244k.f20830d, c0244k.f20831e, 1002, 8519680, -3);
            layoutParams3.gravity = c0244k.f20829c;
            layoutParams3.windowAnimations = c0244k.f20832f;
            windowManager.addView(c0244k.f20833g, layoutParams3);
            c0244k.f20841o = true;
        }
    }

    private boolean G0(C0244k c0244k, int i5, KeyEvent keyEvent, int i6) {
        stepos.support.v7.view.menu.d dVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c0244k.f20839m || I0(c0244k, keyEvent)) && (dVar = c0244k.f20836j) != null) {
            zPerformShortcut = dVar.performShortcut(i5, keyEvent, i6);
        }
        if (zPerformShortcut && (i6 & 1) == 0 && this.f20805r == null) {
            l0(c0244k, true);
        }
        return zPerformShortcut;
    }

    private void H0(C0244k c0244k) {
        if (t0(c0244k)) {
            a aVar = null;
            if (this.f20805r != null) {
                if (this.f20806s == null) {
                    this.f20806s = new h(this, aVar);
                }
                this.f20805r.t(c0244k.f20846t, this.f20806s);
            }
            c0244k.f20846t.b0();
            if (this.f20765f.onCreateBottomMenu(c0244k.f20846t)) {
                c0244k.f20846t.a0();
                return;
            }
            c0244k.d(null);
            stepos.support.v7.widget.l lVar = this.f20805r;
            if (lVar != null) {
                lVar.t(null, this.f20806s);
            }
        }
    }

    private boolean I0(C0244k c0244k, KeyEvent keyEvent) {
        stepos.support.v7.widget.l lVar;
        int deviceId;
        stepos.support.v7.widget.l lVar2;
        stepos.support.v7.widget.l lVar3;
        if (N()) {
            return false;
        }
        if (c0244k.f20839m) {
            return true;
        }
        C0244k c0244k2 = this.f20795H;
        if (c0244k2 != null && c0244k2 != c0244k) {
            l0(c0244k2, false);
        }
        Window.Callback callbackL = L();
        if (callbackL != null) {
            c0244k.f20835i = callbackL.onCreatePanelView(c0244k.f20827a);
        }
        int i5 = c0244k.f20827a;
        boolean z5 = i5 == 0 || i5 == 108;
        if (z5 && (lVar3 = this.f20805r) != null) {
            lVar3.b();
        }
        if (c0244k.f20835i == null && (!z5 || !(S() instanceof t))) {
            stepos.support.v7.view.menu.d dVar = c0244k.f20836j;
            a aVar = null;
            if (dVar == null || c0244k.f20844r) {
                if (dVar == null && (!w0(c0244k) || c0244k.f20836j == null)) {
                    return false;
                }
                if (z5 && this.f20805r != null) {
                    if (this.f20806s == null) {
                        this.f20806s = new h(this, aVar);
                    }
                    this.f20805r.r(c0244k.f20836j, this.f20806s);
                }
                c0244k.f20836j.b0();
                if (!callbackL.onCreatePanelMenu(c0244k.f20827a, c0244k.f20836j)) {
                    c0244k.e(null);
                    if (z5 && (lVar = this.f20805r) != null) {
                        lVar.r(null, this.f20806s);
                    }
                    return false;
                }
                c0244k.f20844r = false;
            }
            stepos.support.v7.app.e eVar = this.f20765f;
            if (eVar != null) {
                eVar.onOptionsMenuCreated(c0244k.f20836j);
            }
            c0244k.f20836j.b0();
            Bundle bundle = c0244k.f20845s;
            if (bundle != null) {
                c0244k.f20836j.O(bundle);
                c0244k.f20845s = null;
            }
            if (!callbackL.onPreparePanel(0, c0244k.f20835i, c0244k.f20836j)) {
                if (z5 && (lVar2 = this.f20805r) != null) {
                    lVar2.r(null, this.f20806s);
                }
                c0244k.f20836j.a0();
                return false;
            }
            if (keyEvent != null) {
                try {
                    deviceId = keyEvent.getDeviceId();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            } else {
                deviceId = -1;
            }
            boolean z6 = KeyCharacterMap.load(deviceId).getKeyboardType() != 1;
            c0244k.f20842p = z6;
            c0244k.f20836j.setQwertyMode(z6);
            c0244k.f20836j.a0();
            H0(c0244k);
        }
        c0244k.f20839m = true;
        c0244k.f20840n = false;
        this.f20795H = c0244k;
        return true;
    }

    private void J0(stepos.support.v7.view.menu.d dVar, boolean z5) {
        stepos.support.v7.widget.l lVar = this.f20805r;
        if (lVar == null || !lVar.c() || (L.j(ViewConfiguration.get(this.f20761b)) && !this.f20805r.d())) {
            C0244k c0244kS0 = s0(0, true);
            c0244kS0.f20843q = true;
            l0(c0244kS0, false);
            F0(c0244kS0, null);
            return;
        }
        Window.Callback callbackL = L();
        if (this.f20805r.a() && z5) {
            this.f20805r.e();
            if (N()) {
                return;
            }
            callbackL.onPanelClosed(108, s0(0, true).f20836j);
            return;
        }
        if (callbackL == null || N()) {
            return;
        }
        if (this.f20797J && (this.f20798K & 1) != 0) {
            this.f20762c.getDecorView().removeCallbacks(this.f20799L);
            this.f20799L.run();
        }
        C0244k c0244kS02 = s0(0, true);
        stepos.support.v7.view.menu.d dVar2 = c0244kS02.f20836j;
        if (dVar2 == null || c0244kS02.f20844r || !callbackL.onPreparePanel(0, c0244kS02.f20835i, dVar2)) {
            return;
        }
        callbackL.onMenuOpened(108, c0244kS02.f20836j);
        this.f20805r.f();
    }

    private int K0(int i5) {
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

    private void M0() {
        if (this.f20813z) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int N0(int i5) {
        boolean z5;
        boolean z6;
        ActionBarContextView actionBarContextView = this.f20809v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z5 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f20809v.getLayoutParams();
            if (this.f20809v.isShown()) {
                if (this.f20801Q == null) {
                    this.f20801Q = new Rect();
                    this.f20802R = new Rect();
                }
                Rect rect = this.f20801Q;
                Rect rect2 = this.f20802R;
                rect.set(0, i5, 0, 0);
                C.i(this.f20788A, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i5 : 0)) {
                    marginLayoutParams.topMargin = i5;
                    View view = this.f20790C;
                    if (view == null) {
                        View view2 = new View(this.f20761b);
                        this.f20790C = view2;
                        view2.setBackgroundColor(this.f20761b.getResources().getColor(H1.e.f2098t));
                        this.f20788A.addView(this.f20790C, -1, new ViewGroup.LayoutParams(-1, i5));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i5) {
                            layoutParams.height = i5;
                            this.f20790C.setLayoutParams(layoutParams);
                        }
                    }
                    z6 = true;
                } else {
                    z6 = false;
                }
                z = this.f20790C != null;
                if (!this.f20770k && z) {
                    i5 = 0;
                }
                boolean z7 = z;
                z = z6;
                z5 = z7;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z5 = false;
            } else {
                z5 = false;
                z = false;
            }
            if (z) {
                this.f20809v.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.f20790C;
        if (view3 != null) {
            view3.setVisibility(z5 ? 0 : 8);
        }
        return i5;
    }

    private void h0() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f20788A.findViewById(R.id.content);
        View decorView = this.f20762c.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f20761b.obtainStyledAttributes(g.j.f17215y0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(int i5, C0244k c0244k, Menu menu) {
        if (menu == null) {
            if (c0244k == null && i5 >= 0) {
                C0244k[] c0244kArr = this.f20794G;
                if (i5 < c0244kArr.length) {
                    c0244k = c0244kArr[i5];
                }
            }
            if (c0244k != null) {
                menu = c0244k.f20836j;
            }
        }
        if ((c0244k == null || c0244k.f20841o) && !N()) {
            this.f20763d.onPanelClosed(i5, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(stepos.support.v7.view.menu.d dVar) {
        if (this.f20793F) {
            return;
        }
        this.f20793F = true;
        this.f20805r.i();
        Window.Callback callbackL = L();
        if (callbackL != null && !N()) {
            callbackL.onPanelClosed(108, dVar);
        }
        this.f20793F = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(int i5) {
        l0(s0(i5, true), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(C0244k c0244k, boolean z5) {
        ViewGroup viewGroup;
        stepos.support.v7.widget.l lVar;
        if (z5 && c0244k.f20827a == 0 && (lVar = this.f20805r) != null && lVar.a()) {
            j0(c0244k.f20836j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f20761b.getSystemService("window");
        if (windowManager != null && c0244k.f20841o && (viewGroup = c0244k.f20833g) != null) {
            if (viewGroup.getParent() != null) {
                windowManager.removeView(c0244k.f20833g);
            }
            if (z5) {
                i0(c0244k.f20827a, c0244k, null);
            }
        }
        c0244k.f20839m = false;
        c0244k.f20840n = false;
        c0244k.f20841o = false;
        c0244k.f20834h = null;
        c0244k.f20843q = true;
        if (this.f20795H == c0244k) {
            this.f20795H = null;
        }
    }

    private ViewGroup m0() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f20761b.obtainStyledAttributes(g.j.f17215y0);
        int i5 = g.j.f16998D0;
        if (!typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.f17039M0, false)) {
            w(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i5, false)) {
            w(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.f17003E0, false)) {
            w(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.f17008F0, false)) {
            w(10);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(X4.l.f6137K, false)) {
            w(1001);
        }
        this.f20771l = typedArrayObtainStyledAttributes.getBoolean(g.j.f17220z0, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f20762c.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f20761b);
        if (this.f20772m) {
            viewGroup = this.f20770k ? (ViewGroup) layoutInflaterFrom.inflate(X4.h.f6034f, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(X4.h.f6033e, (ViewGroup) null);
            H.w0(viewGroup, new c());
        } else if (this.f20771l) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(g.g.f16950f, (ViewGroup) null);
            this.f20769j = false;
            this.f20768i = false;
        } else if (this.f20768i) {
            TypedValue typedValue = new TypedValue();
            this.f20761b.getTheme().resolveAttribute(C0728a.f16830g, typedValue, true);
            Context dVar = typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.f20761b, typedValue.resourceId) : this.f20761b;
            if (this.f20773n) {
                TypedValue typedValue2 = new TypedValue();
                dVar.getTheme().resolveAttribute(X4.a.f5846v, typedValue2, true);
                if (typedValue2.resourceId != 0) {
                    dVar = new androidx.appcompat.view.d(dVar, typedValue2.resourceId);
                }
                viewGroup = (ViewGroup) LayoutInflater.from(dVar).inflate(X4.h.f6045q, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) LayoutInflater.from(dVar).inflate(N1.a.c() ? X4.h.f6036h : X4.h.f6035g, (ViewGroup) null);
            }
            stepos.support.v7.widget.l lVar = (stepos.support.v7.widget.l) viewGroup.findViewById(g.f.f16934p);
            this.f20805r = lVar;
            lVar.setWindowCallback(L());
            if (this.f20769j) {
                this.f20805r.h(109);
            }
            if (this.f20791D) {
                this.f20805r.h(2);
            }
            if (this.f20792E) {
                this.f20805r.h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f20768i + ", windowActionBarOverlay: " + this.f20769j + ", android:windowIsFloating: " + this.f20771l + ", windowActionModeOverlay: " + this.f20770k + ", windowNoTitle: " + this.f20772m + " }");
        }
        if (this.f20805r == null) {
            this.f20789B = (TextView) viewGroup.findViewById(g.f.f16915C);
        }
        C.n(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(g.f.f16920b);
        ViewGroup viewGroup2 = (ViewGroup) this.f20762c.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                viewGroup2.setForeground(null);
            }
        }
        this.f20762c.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new d());
        return viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        stepos.support.v7.view.menu.d dVar;
        stepos.support.v7.widget.l lVar = this.f20805r;
        if (lVar != null) {
            lVar.i();
        }
        if (this.f20810w != null) {
            this.f20762c.getDecorView().removeCallbacks(this.f20811x);
            if (this.f20810w.isShowing()) {
                try {
                    this.f20810w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f20810w = null;
        }
        p0();
        C0244k c0244kS0 = s0(0, false);
        if (c0244kS0 == null || (dVar = c0244kS0.f20836j) == null) {
            return;
        }
        dVar.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(int i5) {
        C0244k c0244kS0;
        C0244k c0244kS02 = s0(i5, true);
        if (c0244kS02.f20836j != null) {
            Bundle bundle = new Bundle();
            c0244kS02.f20836j.P(bundle);
            if (bundle.size() > 0) {
                c0244kS02.f20845s = bundle;
            }
            c0244kS02.f20836j.b0();
            c0244kS02.f20836j.clear();
        }
        c0244kS02.f20844r = true;
        c0244kS02.f20843q = true;
        if ((i5 != 108 && i5 != 0) || this.f20805r == null || (c0244kS0 = s0(0, false)) == null) {
            return;
        }
        c0244kS0.f20839m = false;
        I0(c0244kS0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        S s5 = this.f20812y;
        if (s5 != null) {
            s5.c();
        }
    }

    private void q0() {
        if (this.f20813z) {
            return;
        }
        this.f20788A = m0();
        CharSequence charSequenceK = K();
        if (!TextUtils.isEmpty(charSequenceK)) {
            R(charSequenceK);
        }
        h0();
        E0(this.f20788A);
        this.f20813z = true;
        C0244k c0244kS0 = s0(0, false);
        if (!N() && (c0244kS0 == null || c0244kS0.f20836j == null)) {
            x0(108);
        }
        if (l() != null) {
            l().R(this.f20776q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0244k r0(Menu menu) {
        C0244k[] c0244kArr = this.f20794G;
        int length = c0244kArr != null ? c0244kArr.length : 0;
        for (int i5 = 0; i5 < length; i5++) {
            C0244k c0244k = c0244kArr[i5];
            if (c0244k != null && c0244k.f20836j == menu) {
                return c0244k;
            }
        }
        return null;
    }

    private C0244k s0(int i5, boolean z5) {
        C0244k[] c0244kArr = this.f20794G;
        if (c0244kArr == null || c0244kArr.length <= i5) {
            C0244k[] c0244kArr2 = new C0244k[i5 + 1];
            if (c0244kArr != null) {
                System.arraycopy(c0244kArr, 0, c0244kArr2, 0, c0244kArr.length);
            }
            this.f20794G = c0244kArr2;
            c0244kArr = c0244kArr2;
        }
        C0244k c0244k = c0244kArr[i5];
        if (c0244k != null) {
            return c0244k;
        }
        C0244k c0244k2 = new C0244k(i5);
        c0244kArr[i5] = c0244k2;
        return c0244k2;
    }

    private boolean t0(C0244k c0244k) {
        stepos.support.v7.view.menu.d dVar = new stepos.support.v7.view.menu.d(this.f20761b);
        dVar.Q(this.f20803S);
        c0244k.d(dVar);
        return true;
    }

    private boolean u0(C0244k c0244k) {
        View view = c0244k.f20835i;
        if (view != null) {
            c0244k.f20834h = view;
            return true;
        }
        if (c0244k.f20836j == null) {
            return false;
        }
        if (this.f20807t == null) {
            this.f20807t = new l(this, null);
        }
        View view2 = (View) c0244k.b(this.f20807t);
        c0244k.f20834h = view2;
        return view2 != null;
    }

    private boolean v0(C0244k c0244k) {
        c0244k.f(J());
        c0244k.f20833g = new j(c0244k.f20838l);
        c0244k.f20829c = 81;
        return true;
    }

    private boolean w0(C0244k c0244k) {
        Resources.Theme themeNewTheme;
        Context context = this.f20761b;
        int i5 = c0244k.f20827a;
        if ((i5 == 0 || i5 == 108) && this.f20805r != null) {
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
        stepos.support.v7.view.menu.d dVar2 = new stepos.support.v7.view.menu.d(context);
        dVar2.Q(this);
        c0244k.e(dVar2);
        return true;
    }

    private void x0(int i5) {
        this.f20798K = (1 << i5) | this.f20798K;
        if (this.f20797J) {
            return;
        }
        H.b0(this.f20762c.getDecorView(), this.f20799L);
        this.f20797J = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z0(stepos.support.v7.view.menu.d dVar, MenuItem menuItem) {
        if (this.f20765f == null || N() || !(menuItem instanceof c5.f)) {
            return false;
        }
        return this.f20765f.onBottomItemSelected((c5.f) menuItem);
    }

    @Override // stepos.support.v7.app.f
    public void A(View view) {
        q0();
        ViewGroup viewGroup = (ViewGroup) this.f20788A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f20763d.onContentChanged();
    }

    boolean A0(int i5, KeyEvent keyEvent) {
        if (i5 == 4) {
            this.f20796I = (keyEvent.getFlags() & 128) != 0;
        } else if (i5 == 82) {
            B0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // stepos.support.v7.app.f
    public void B(View view, ViewGroup.LayoutParams layoutParams) {
        q0();
        ViewGroup viewGroup = (ViewGroup) this.f20788A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f20763d.onContentChanged();
    }

    @Override // stepos.support.v7.app.f
    public void C(Toolbar toolbar) {
        if (this.f20763d instanceof Activity) {
            stepos.support.v7.app.a aVarL = l();
            if (aVarL instanceof v) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f20767h = null;
            if (aVarL != null) {
                aVarL.v();
            }
            if (toolbar != null) {
                t tVar = new t(toolbar, ((Activity) this.f20761b).getTitle(), this.f20764e);
                this.f20766g = tVar;
                this.f20762c.setCallback(tVar.d0());
            } else {
                this.f20766g = null;
                this.f20762c.setCallback(this.f20764e);
            }
            o();
        }
    }

    boolean C0(int i5, KeyEvent keyEvent) {
        if (i5 == 4) {
            boolean z5 = this.f20796I;
            this.f20796I = false;
            C0244k c0244kS0 = s0(0, false);
            if (c0244kS0 != null && c0244kS0.f20841o) {
                if (!z5) {
                    l0(c0244kS0, true);
                }
                return true;
            }
            if (y0()) {
                return true;
            }
        } else if (i5 == 82) {
            D0(0, keyEvent);
            return true;
        }
        return false;
    }

    void E0(ViewGroup viewGroup) {
    }

    @Override // stepos.support.v7.app.f
    public void F() {
        stepos.support.v7.widget.l lVar = this.f20805r;
        if (lVar != null) {
            lVar.s();
        }
    }

    @Override // stepos.support.v7.app.f
    public b5.b G(b.InterfaceC0154b interfaceC0154b) {
        if (interfaceC0154b == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        b5.b bVar = this.f20808u;
        if (bVar != null) {
            bVar.a();
        }
        i iVar = new i(interfaceC0154b);
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null) {
            this.f20808u = aVarL.U(iVar);
        }
        return this.f20808u;
    }

    @Override // stepos.support.v7.app.f
    public b5.b H(b.InterfaceC0154b interfaceC0154b) {
        stepos.support.v7.app.e eVar;
        if (interfaceC0154b == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        b5.b bVar = this.f20808u;
        if (bVar != null) {
            bVar.a();
        }
        i iVar = new i(interfaceC0154b);
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null) {
            b5.b bVarT = aVarL.T(iVar);
            this.f20808u = bVarT;
            if (bVarT != null && (eVar = this.f20765f) != null) {
                eVar.onSupportActionModeStarted(bVarT);
            }
        }
        if (this.f20808u == null) {
            this.f20808u = L0(iVar);
        }
        return this.f20808u;
    }

    @Override // stepos.support.v7.app.g
    boolean I(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.f20763d.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? A0(keyCode, keyEvent) : C0(keyCode, keyEvent);
    }

    b5.b L0(b.InterfaceC0154b interfaceC0154b) {
        b5.b bVarOnWindowStartingSupportActionMode;
        Context dVar;
        stepos.support.v7.app.e eVar;
        p0();
        b5.b bVar = this.f20808u;
        if (bVar != null) {
            bVar.a();
        }
        i iVar = new i(interfaceC0154b);
        if (this.f20765f == null || N()) {
            bVarOnWindowStartingSupportActionMode = null;
        } else {
            try {
                bVarOnWindowStartingSupportActionMode = this.f20765f.onWindowStartingSupportActionMode(iVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (bVarOnWindowStartingSupportActionMode != null) {
            this.f20808u = bVarOnWindowStartingSupportActionMode;
        } else {
            if (this.f20809v == null) {
                if (this.f20771l) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f20761b.getTheme();
                    theme.resolveAttribute(C0728a.f16830g, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f20761b.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new androidx.appcompat.view.d(this.f20761b, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f20761b;
                    }
                    this.f20809v = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, C0728a.f16834k);
                    this.f20810w = popupWindow;
                    androidx.core.widget.g.b(popupWindow, 2);
                    this.f20810w.setContentView(this.f20809v);
                    this.f20810w.setWidth(-1);
                    dVar.getTheme().resolveAttribute(N1.a.c() ? X4.a.f5831g : C0728a.f16825b, typedValue, true);
                    this.f20809v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.f20810w.setHeight(-2);
                    this.f20811x = new e();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f20788A.findViewById(g.f.f16926h);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(J()));
                        this.f20809v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f20809v != null) {
                p0();
                this.f20809v.s();
                b5.i iVar2 = new b5.i(this.f20809v.getContext(), this.f20809v, iVar, this.f20810w == null);
                if (interfaceC0154b.d(iVar2, iVar2.f())) {
                    iVar2.l();
                    this.f20809v.n(iVar2);
                    this.f20808u = iVar2;
                    H.n0(this.f20809v, 0.0f);
                    S sB = H.d(this.f20809v).b(1.0f);
                    this.f20812y = sB;
                    sB.j(new f());
                    if (this.f20810w != null) {
                        this.f20762c.getDecorView().post(this.f20811x);
                    }
                } else {
                    this.f20808u = null;
                }
            }
        }
        b5.b bVar2 = this.f20808u;
        if (bVar2 != null && (eVar = this.f20765f) != null) {
            eVar.onSupportActionModeStarted(bVar2);
        }
        return this.f20808u;
    }

    @Override // stepos.support.v7.app.g
    public void M() {
        q0();
        if (this.f20768i && this.f20766g == null) {
            Window.Callback callback = this.f20763d;
            if (callback instanceof Activity) {
                if (this.f20773n) {
                    this.f20766g = new q((Activity) this.f20763d);
                } else {
                    this.f20766g = new v((Activity) this.f20763d, this.f20769j);
                }
            } else if (callback instanceof Dialog) {
                this.f20766g = new v((Dialog) this.f20763d);
            }
            stepos.support.v7.app.a aVar = this.f20766g;
            if (aVar != null) {
                aVar.D(this.f20800M);
            }
        }
    }

    @Override // stepos.support.v7.app.g
    boolean O(int i5, KeyEvent keyEvent) {
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null && aVarL.w(i5, keyEvent)) {
            return true;
        }
        C0244k c0244k = this.f20795H;
        if (c0244k != null && G0(c0244k, keyEvent.getKeyCode(), keyEvent, 1)) {
            C0244k c0244k2 = this.f20795H;
            if (c0244k2 != null) {
                c0244k2.f20840n = true;
            }
            return true;
        }
        if (this.f20795H != null) {
            return false;
        }
        C0244k c0244kS0 = s0(0, true);
        I0(c0244kS0, keyEvent);
        boolean zG0 = G0(c0244kS0, keyEvent.getKeyCode(), keyEvent, 1);
        c0244kS0.f20839m = false;
        return zG0;
    }

    @Override // stepos.support.v7.app.g
    boolean P(int i5, Menu menu) {
        if (i5 != 108) {
            return false;
        }
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null) {
            aVarL.k(true);
        }
        return true;
    }

    @Override // stepos.support.v7.app.g
    void Q(int i5, Menu menu) {
        if (i5 == 108) {
            stepos.support.v7.app.a aVarL = l();
            if (aVarL != null) {
                aVarL.k(false);
                return;
            }
            return;
        }
        if (i5 == 0) {
            C0244k c0244kS0 = s0(i5, true);
            if (c0244kS0.f20841o) {
                l0(c0244kS0, false);
            }
        }
    }

    @Override // stepos.support.v7.app.g
    void R(CharSequence charSequence) {
        stepos.support.v7.widget.l lVar = this.f20805r;
        if (lVar != null) {
            lVar.setWindowTitle(charSequence);
            return;
        }
        if (S() != null) {
            S().S(charSequence);
            return;
        }
        TextView textView = this.f20789B;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // stepos.support.v7.app.f
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        q0();
        ((ViewGroup) this.f20788A.findViewById(R.id.content)).addView(view, layoutParams);
        this.f20763d.onContentChanged();
    }

    @Override // stepos.support.v7.view.menu.d.a
    public boolean c(stepos.support.v7.view.menu.d dVar, MenuItem menuItem) {
        C0244k c0244kR0;
        Window.Callback callbackL = L();
        if (callbackL == null || N() || (c0244kR0 = r0(dVar.D())) == null) {
            return false;
        }
        boolean zOnMenuItemSelected = callbackL.onMenuItemSelected(c0244kR0.f20827a, menuItem);
        return (zOnMenuItemSelected || !(menuItem instanceof c5.f)) ? zOnMenuItemSelected : this.f20765f.onMenuItemSelected(c0244kR0.f20827a, (c5.f) menuItem);
    }

    @Override // stepos.support.v7.view.menu.d.a
    public void d(stepos.support.v7.view.menu.d dVar) {
        J0(dVar, true);
    }

    @Override // stepos.support.v7.app.f
    public <T extends View> T h(int i5) {
        q0();
        return (T) this.f20762c.findViewById(i5);
    }

    @Override // stepos.support.v7.app.f
    public void m() {
        stepos.support.v7.widget.l lVar = this.f20805r;
        if (lVar != null) {
            lVar.u();
        }
    }

    @Override // stepos.support.v7.app.f
    public void n() {
    }

    @Override // stepos.support.v7.app.f
    public void o() {
        stepos.support.v7.app.a aVarL = l();
        if (aVarL == null || !aVarL.r()) {
            x0(0);
        }
    }

    @Override // stepos.support.v7.app.f
    public void p(Configuration configuration) {
        stepos.support.v7.app.a aVarL;
        if (this.f20768i && this.f20813z && (aVarL = l()) != null) {
            aVarL.u(configuration);
        }
        b();
    }

    @Override // stepos.support.v7.app.f
    public void q(Bundle bundle) {
        C.l();
        Window.Callback callback = this.f20763d;
        if (callback instanceof Activity) {
            if (androidx.core.app.h.c((Activity) callback) != null) {
                stepos.support.v7.app.a aVarS = S();
                if (aVarS == null) {
                    this.f20800M = true;
                } else {
                    aVarS.D(true);
                }
            }
            this.f20762c.getDecorView().getSystemUiVisibility();
            this.f20762c.setDecorFitsSystemWindows(false);
        }
    }

    @Override // stepos.support.v7.app.g, stepos.support.v7.app.f
    public void r() {
        super.r();
        stepos.support.v7.app.a aVar = this.f20766g;
        if (aVar != null) {
            aVar.v();
        }
    }

    @Override // stepos.support.v7.app.f
    public void s(Bundle bundle) {
        q0();
    }

    @Override // stepos.support.v7.app.f
    public void t() {
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null) {
            aVarL.M(true);
        }
    }

    @Override // stepos.support.v7.app.f
    public void v() {
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null) {
            aVarL.M(false);
        }
    }

    @Override // stepos.support.v7.app.f
    public boolean w(int i5) {
        int iK0 = K0(i5);
        if (this.f20772m && iK0 == 108) {
            return false;
        }
        if (this.f20768i && iK0 == 1) {
            this.f20768i = false;
        }
        if (iK0 == 1) {
            M0();
            this.f20772m = true;
            return true;
        }
        if (iK0 == 2) {
            M0();
            this.f20791D = true;
            return true;
        }
        if (iK0 == 5) {
            M0();
            this.f20792E = true;
            return true;
        }
        if (iK0 == 10) {
            M0();
            this.f20770k = true;
            return true;
        }
        if (iK0 == 1001) {
            M0();
            this.f20773n = true;
            return true;
        }
        if (iK0 == 108) {
            M0();
            this.f20768i = true;
            return true;
        }
        if (iK0 != 109) {
            return this.f20762c.requestFeature(iK0);
        }
        M0();
        this.f20769j = true;
        return true;
    }

    @Override // stepos.support.v7.app.f
    public void x(Drawable drawable) {
        stepos.support.v7.widget.l lVar = this.f20805r;
        if (lVar != null) {
            lVar.setBackTopBackground(drawable);
        }
    }

    @Override // stepos.support.v7.app.f
    public void y(boolean z5) {
        stepos.support.v7.widget.l lVar = this.f20805r;
        if (lVar != null) {
            lVar.setBackTopEnable(z5);
            this.f20805r.setBackTopClickCallback(z5 ? this.f20804T : null);
        }
    }

    boolean y0() {
        b5.b bVar = this.f20808u;
        if (bVar == null) {
            stepos.support.v7.app.a aVarL = l();
            return aVarL != null && aVarL.h();
        }
        b.a aVarB = bVar.b();
        if (aVarB == null || !aVarB.a()) {
            return false;
        }
        this.f20808u.a();
        return true;
    }

    @Override // stepos.support.v7.app.f
    public void z(int i5) {
        q0();
        ViewGroup viewGroup = (ViewGroup) this.f20788A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f20761b).inflate(i5, viewGroup);
        this.f20763d.onContentChanged();
    }
}
