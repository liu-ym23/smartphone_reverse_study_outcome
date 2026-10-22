package androidx.appcompat.app;

import K.S;
import K.e0;
import K.z0;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.C0205i;
import androidx.appcompat.widget.C0217o;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.InterfaceC0214m0;
import androidx.appcompat.widget.InterfaceC0216n0;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.g1;
import androidx.appcompat.widget.k1;
import com.baidu.platform.comapi.map.MapController;
import g.AbstractC0560a;
import j.AbstractC0624c;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import k.C0657k;
import k.C0661o;
import k.C0663q;
import k.InterfaceC0659m;

/* loaded from: classes.dex */
public final class F extends q implements InterfaceC0659m, LayoutInflater.Factory2 {

    /* renamed from: k0, reason: collision with root package name */
    public static final q.l f2483k0 = new q.l(0);

    /* renamed from: l0, reason: collision with root package name */
    public static final int[] f2484l0 = {R.attr.windowBackground};

    /* renamed from: m0, reason: collision with root package name */
    public static final boolean f2485m0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: A, reason: collision with root package name */
    public boolean f2486A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f2487B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f2488C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f2489D;

    /* renamed from: E, reason: collision with root package name */
    public E[] f2490E;

    /* renamed from: F, reason: collision with root package name */
    public E f2491F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f2492G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f2493H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f2494I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f2495J;

    /* renamed from: K, reason: collision with root package name */
    public Configuration f2496K;

    /* renamed from: L, reason: collision with root package name */
    public final int f2497L;

    /* renamed from: M, reason: collision with root package name */
    public int f2498M;

    /* renamed from: N, reason: collision with root package name */
    public int f2499N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f2500O;

    /* renamed from: P, reason: collision with root package name */
    public z f2501P;

    /* renamed from: Q, reason: collision with root package name */
    public z f2502Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f2503R;

    /* renamed from: S, reason: collision with root package name */
    public int f2504S;
    public final r T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f2505U;

    /* renamed from: V, reason: collision with root package name */
    public Rect f2506V;

    /* renamed from: W, reason: collision with root package name */
    public Rect f2507W;

    /* renamed from: X, reason: collision with root package name */
    public I f2508X;

    /* renamed from: Y, reason: collision with root package name */
    public OnBackInvokedDispatcher f2509Y;

    /* renamed from: Z, reason: collision with root package name */
    public OnBackInvokedCallback f2510Z;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2511d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f2512e;

    /* renamed from: f, reason: collision with root package name */
    public Window f2513f;

    /* renamed from: g, reason: collision with root package name */
    public y f2514g;

    /* renamed from: h, reason: collision with root package name */
    public N f2515h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f2516i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0214m0 f2517j;

    /* renamed from: k, reason: collision with root package name */
    public s f2518k;

    /* renamed from: l, reason: collision with root package name */
    public s f2519l;

    /* renamed from: m, reason: collision with root package name */
    public AbstractC0624c f2520m;

    /* renamed from: n, reason: collision with root package name */
    public ActionBarContextView f2521n;

    /* renamed from: o, reason: collision with root package name */
    public PopupWindow f2522o;

    /* renamed from: p, reason: collision with root package name */
    public r f2523p;

    /* renamed from: q, reason: collision with root package name */
    public e0 f2524q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f2525r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2526s;

    /* renamed from: t, reason: collision with root package name */
    public ViewGroup f2527t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f2528u;

    /* renamed from: v, reason: collision with root package name */
    public View f2529v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2530w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2531x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2532y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2533z;

    public F(Dialog dialog, InterfaceC0188n interfaceC0188n) {
        Context context = dialog.getContext();
        Window window = dialog.getWindow();
        this.f2524q = null;
        this.f2525r = true;
        this.f2497L = -100;
        this.T = new r(this, 0);
        this.f2512e = context;
        this.f2511d = dialog;
        while (context != null && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (this.f2497L == -100) {
            q.l lVar = f2483k0;
            Integer num = (Integer) lVar.get(this.f2511d.getClass().getName());
            if (num != null) {
                this.f2497L = num.intValue();
                lVar.remove(this.f2511d.getClass().getName());
            }
        }
        if (window != null) {
            c(window);
        }
        androidx.appcompat.widget.A.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(boolean r11) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.F.b(boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.view.Window r8) {
        /*
            r7 = this;
            android.view.Window r0 = r7.f2513f
            java.lang.String r1 = "AppCompat has already installed itself into the Window"
            if (r0 != 0) goto L7a
            android.view.Window$Callback r0 = r8.getCallback()
            boolean r2 = r0 instanceof androidx.appcompat.app.y
            if (r2 != 0) goto L74
            androidx.appcompat.app.y r1 = new androidx.appcompat.app.y
            r1.<init>(r7, r0)
            r7.f2514g = r1
            r8.setCallback(r1)
            int[] r0 = androidx.appcompat.app.F.f2484l0
            android.content.Context r1 = r7.f2512e
            r2 = 0
            android.content.res.TypedArray r0 = r1.obtainStyledAttributes(r2, r0)
            r3 = 0
            boolean r4 = r0.hasValue(r3)
            if (r4 == 0) goto L3f
            int r3 = r0.getResourceId(r3, r3)
            if (r3 == 0) goto L3f
            androidx.appcompat.widget.A r4 = androidx.appcompat.widget.A.a()
            monitor-enter(r4)
            androidx.appcompat.widget.N0 r5 = r4.f2723a     // Catch: java.lang.Throwable -> L3c
            r6 = 1
            android.graphics.drawable.Drawable r1 = r5.f(r1, r3, r6)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r4)
            goto L40
        L3c:
            r7 = move-exception
            monitor-exit(r4)
            throw r7
        L3f:
            r1 = r2
        L40:
            if (r1 == 0) goto L45
            r8.setBackgroundDrawable(r1)
        L45:
            r0.recycle()
            r7.f2513f = r8
            android.window.OnBackInvokedDispatcher r8 = r7.f2509Y
            if (r8 != 0) goto L73
            if (r8 == 0) goto L59
            android.window.OnBackInvokedCallback r0 = r7.f2510Z
            if (r0 == 0) goto L59
            androidx.appcompat.app.x.c(r8, r0)
            r7.f2510Z = r2
        L59:
            java.lang.Object r8 = r7.f2511d
            boolean r0 = r8 instanceof android.app.Activity
            if (r0 == 0) goto L6e
            android.app.Activity r8 = (android.app.Activity) r8
            android.view.Window r0 = r8.getWindow()
            if (r0 == 0) goto L6e
            android.window.OnBackInvokedDispatcher r8 = androidx.appcompat.app.x.a(r8)
            r7.f2509Y = r8
            goto L70
        L6e:
            r7.f2509Y = r2
        L70:
            r7.y()
        L73:
            return
        L74:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r1)
            throw r7
        L7a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.F.c(android.view.Window):void");
    }

    public final void d(int i4, E e4, C0661o c0661o) {
        if (c0661o == null) {
            if (e4 == null && i4 >= 0) {
                E[] eArr = this.f2490E;
                if (i4 < eArr.length) {
                    e4 = eArr[i4];
                }
            }
            if (e4 != null) {
                c0661o = e4.f2474h;
            }
        }
        if ((e4 == null || e4.f2479m) && !this.f2495J) {
            y yVar = this.f2514g;
            Window.Callback callback = this.f2513f.getCallback();
            yVar.getClass();
            try {
                yVar.f2686d = true;
                callback.onPanelClosed(i4, c0661o);
            } finally {
                yVar.f2686d = false;
            }
        }
    }

    public final void e(C0661o c0661o) {
        C0217o c0217o;
        if (this.f2489D) {
            return;
        }
        this.f2489D = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f2517j;
        actionBarOverlayLayout.f();
        ActionMenuView actionMenuView = ((g1) actionBarOverlayLayout.f2763e).f3087a.f2984a;
        if (actionMenuView != null && (c0217o = actionMenuView.f2791t) != null) {
            c0217o.g();
            C0205i c0205i = c0217o.f3145t;
            if (c0205i != null && c0205i.b()) {
                c0205i.f13316j.dismiss();
            }
        }
        Window.Callback callback = this.f2513f.getCallback();
        if (callback != null && !this.f2495J) {
            callback.onPanelClosed(108, c0661o);
        }
        this.f2489D = false;
    }

    public final void f(E e4, boolean z4) {
        C c4;
        InterfaceC0214m0 interfaceC0214m0;
        C0217o c0217o;
        if (z4 && e4.f2467a == 0 && (interfaceC0214m0 = this.f2517j) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0214m0;
            actionBarOverlayLayout.f();
            ActionMenuView actionMenuView = ((g1) actionBarOverlayLayout.f2763e).f3087a.f2984a;
            if (actionMenuView != null && (c0217o = actionMenuView.f2791t) != null && c0217o.i()) {
                e(e4.f2474h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f2512e.getSystemService("window");
        if (windowManager != null && e4.f2479m && (c4 = e4.f2471e) != null) {
            windowManager.removeView(c4);
            if (z4) {
                d(e4.f2467a, e4, null);
            }
        }
        e4.f2477k = false;
        e4.f2478l = false;
        e4.f2479m = false;
        e4.f2472f = null;
        e4.f2480n = true;
        if (this.f2491F == e4) {
            this.f2491F = null;
        }
        if (e4.f2467a == 0) {
            y();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0117, code lost:
    
        if (v(r0, r7) != false) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.F.g(android.view.KeyEvent):boolean");
    }

    public final void h(int i4) {
        E eO = o(i4);
        if (eO.f2474h != null) {
            Bundle bundle = new Bundle();
            eO.f2474h.t(bundle);
            if (bundle.size() > 0) {
                eO.f2482p = bundle;
            }
            eO.f2474h.w();
            eO.f2474h.clear();
        }
        eO.f2481o = true;
        eO.f2480n = true;
        if ((i4 == 108 || i4 == 0) && this.f2517j != null) {
            E eO2 = o(0);
            eO2.f2477k = false;
            v(eO2, null);
        }
    }

    @Override // k.InterfaceC0659m
    public final boolean i(C0661o c0661o, MenuItem menuItem) {
        E e4;
        Window.Callback callback = this.f2513f.getCallback();
        if (callback != null && !this.f2495J) {
            C0661o c0661oK = c0661o.k();
            E[] eArr = this.f2490E;
            int length = eArr != null ? eArr.length : 0;
            int i4 = 0;
            while (true) {
                if (i4 < length) {
                    e4 = eArr[i4];
                    if (e4 != null && e4.f2474h == c0661oK) {
                        break;
                    }
                    i4++;
                } else {
                    e4 = null;
                    break;
                }
            }
            if (e4 != null) {
                return callback.onMenuItemSelected(e4.f2467a, menuItem);
            }
        }
        return false;
    }

    public final void j() {
        ViewGroup viewGroup;
        if (this.f2526s) {
            return;
        }
        int[] iArr = AbstractC0560a.f12597j;
        Context context = this.f2512e;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(121)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        int i4 = 0;
        if (typedArrayObtainStyledAttributes.getBoolean(130, false)) {
            w(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(121, false)) {
            w(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(122, false)) {
            w(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(123, false)) {
            w(10);
        }
        this.f2487B = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        k();
        this.f2513f.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        int i5 = 2;
        if (this.f2488C) {
            viewGroup = this.f2486A ? (ViewGroup) layoutInflaterFrom.inflate(com.stepos.alphame.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.stepos.alphame.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.f2487B) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.stepos.alphame.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.f2533z = false;
            this.f2532y = false;
        } else if (this.f2532y) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.stepos.alphame.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new j.e(context, typedValue.resourceId) : context).inflate(com.stepos.alphame.R.layout.abc_screen_toolbar, (ViewGroup) null);
            InterfaceC0214m0 interfaceC0214m0 = (InterfaceC0214m0) viewGroup.findViewById(com.stepos.alphame.R.id.decor_content_parent);
            this.f2517j = interfaceC0214m0;
            interfaceC0214m0.setWindowCallback(this.f2513f.getCallback());
            if (this.f2533z) {
                ((ActionBarOverlayLayout) this.f2517j).e(109);
            }
            if (this.f2530w) {
                ((ActionBarOverlayLayout) this.f2517j).e(2);
            }
            if (this.f2531x) {
                ((ActionBarOverlayLayout) this.f2517j).e(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f2532y + ", windowActionBarOverlay: " + this.f2533z + ", android:windowIsFloating: " + this.f2487B + ", windowActionModeOverlay: " + this.f2486A + ", windowNoTitle: " + this.f2488C + " }");
        }
        s sVar = new s(this, i4);
        WeakHashMap weakHashMap = S.f939a;
        K.J.u(viewGroup, sVar);
        if (this.f2517j == null) {
            this.f2528u = (TextView) viewGroup.findViewById(com.stepos.alphame.R.id.title);
        }
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, new Object[0]);
        } catch (IllegalAccessException e4) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e4);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e5) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e5);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.stepos.alphame.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f2513f.findViewById(R.id.content);
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
        this.f2513f.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new s(this, i5));
        this.f2527t = viewGroup;
        Object obj = this.f2511d;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f2516i;
        if (!TextUtils.isEmpty(title)) {
            InterfaceC0214m0 interfaceC0214m02 = this.f2517j;
            if (interfaceC0214m02 != null) {
                interfaceC0214m02.setWindowTitle(title);
            } else {
                N n4 = this.f2515h;
                if (n4 != null) {
                    n4.g0(title);
                } else {
                    TextView textView = this.f2528u;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f2527t.findViewById(R.id.content);
        View decorView = this.f2513f.getDecorView();
        contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(128, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(129, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(126)) {
            typedArrayObtainStyledAttributes2.getValue(126, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(127)) {
            typedArrayObtainStyledAttributes2.getValue(127, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(124)) {
            typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(125)) {
            typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.f2526s = true;
        E eO = o(0);
        if (this.f2495J || eO.f2474h != null) {
            return;
        }
        q(108);
    }

    public final void k() {
        if (this.f2513f == null) {
            Object obj = this.f2511d;
            if (obj instanceof Activity) {
                c(((Activity) obj).getWindow());
            }
        }
        if (this.f2513f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final Context l() {
        Context context;
        N nP = p();
        if (nP != null) {
            if (nP.f2560c == null) {
                TypedValue typedValue = new TypedValue();
                nP.f2559b.getTheme().resolveAttribute(com.stepos.alphame.R.attr.actionBarWidgetTheme, typedValue, true);
                int i4 = typedValue.resourceId;
                if (i4 != 0) {
                    nP.f2560c = new ContextThemeWrapper(nP.f2559b, i4);
                } else {
                    nP.f2560c = nP.f2559b;
                }
            }
            context = nP.f2560c;
        } else {
            context = null;
        }
        return context == null ? this.f2512e : context;
    }

    public final B m(Context context) {
        if (this.f2501P == null) {
            if (android.support.v4.media.session.c.f2362e == null) {
                Context applicationContext = context.getApplicationContext();
                android.support.v4.media.session.c.f2362e = new android.support.v4.media.session.c(applicationContext, (LocationManager) applicationContext.getSystemService(MapController.LOCATION_LAYER_TAG));
            }
            this.f2501P = new z(this, android.support.v4.media.session.c.f2362e);
        }
        return this.f2501P;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r6.i() != false) goto L20;
     */
    @Override // k.InterfaceC0659m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(k.C0661o r6) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.F.n(k.o):void");
    }

    public final E o(int i4) {
        E[] eArr = this.f2490E;
        if (eArr == null || eArr.length <= i4) {
            E[] eArr2 = new E[i4 + 1];
            if (eArr != null) {
                System.arraycopy(eArr, 0, eArr2, 0, eArr.length);
            }
            this.f2490E = eArr2;
            eArr = eArr2;
        }
        E e4 = eArr[i4];
        if (e4 != null) {
            return e4;
        }
        E e5 = new E();
        e5.f2467a = i4;
        e5.f2480n = false;
        eArr[i4] = e5;
        return e5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r8, java.lang.String r9, android.content.Context r10, android.util.AttributeSet r11) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.F.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final N p() {
        j();
        if (this.f2532y && this.f2515h == null) {
            Object obj = this.f2511d;
            if (obj instanceof Activity) {
                this.f2515h = new N((Activity) obj, this.f2533z);
            } else if (obj instanceof Dialog) {
                this.f2515h = new N((Dialog) obj);
            }
            N n4 = this.f2515h;
            if (n4 != null) {
                n4.f0(this.f2505U);
            }
        }
        return this.f2515h;
    }

    public final void q(int i4) {
        this.f2504S = (1 << i4) | this.f2504S;
        if (this.f2503R) {
            return;
        }
        View decorView = this.f2513f.getDecorView();
        WeakHashMap weakHashMap = S.f939a;
        decorView.postOnAnimation(this.T);
        this.f2503R = true;
    }

    public final boolean r() {
        InterfaceC0216n0 interfaceC0216n0;
        c1 c1Var;
        boolean z4 = this.f2492G;
        this.f2492G = false;
        E eO = o(0);
        if (eO.f2479m) {
            if (!z4) {
                f(eO, true);
            }
            return true;
        }
        AbstractC0624c abstractC0624c = this.f2520m;
        if (abstractC0624c != null) {
            abstractC0624c.a();
            return true;
        }
        N nP = p();
        if (nP == null || (interfaceC0216n0 = nP.f2563f) == null || (c1Var = ((g1) interfaceC0216n0).f3087a.f2978L) == null || c1Var.f3072b == null) {
            return false;
        }
        c1 c1Var2 = ((g1) interfaceC0216n0).f3087a.f2978L;
        C0663q c0663q = c1Var2 == null ? null : c1Var2.f3072b;
        if (c0663q != null) {
            c0663q.collapseActionView();
        }
        return true;
    }

    public final void s(Bundle bundle) {
        String strI;
        this.f2493H = true;
        b(false);
        k();
        Object obj = this.f2511d;
        if (obj instanceof Activity) {
            try {
                strI = B0.f.I((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strI = null;
            }
            if (strI != null) {
                N n4 = this.f2515h;
                if (n4 == null) {
                    this.f2505U = true;
                } else {
                    n4.f0(true);
                }
            }
            synchronized (q.f2675c) {
                q.a(this);
                q.f2674b.add(new WeakReference(this));
            }
        }
        this.f2496K = new Configuration(this.f2512e.getResources().getConfiguration());
        this.f2494I = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0165, code lost:
    
        if (r3.f13230f.getCount() > 0) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(androidx.appcompat.app.E r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.F.t(androidx.appcompat.app.E, android.view.KeyEvent):void");
    }

    public final boolean u(E e4, int i4, KeyEvent keyEvent) {
        C0661o c0661o;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((e4.f2477k || v(e4, keyEvent)) && (c0661o = e4.f2474h) != null) {
            return c0661o.performShortcut(i4, keyEvent, 1);
        }
        return false;
    }

    public final boolean v(E e4, KeyEvent keyEvent) {
        InterfaceC0214m0 interfaceC0214m0;
        InterfaceC0214m0 interfaceC0214m02;
        Resources.Theme themeNewTheme;
        InterfaceC0214m0 interfaceC0214m03;
        InterfaceC0214m0 interfaceC0214m04;
        if (this.f2495J) {
            return false;
        }
        if (e4.f2477k) {
            return true;
        }
        E e5 = this.f2491F;
        if (e5 != null && e5 != e4) {
            f(e5, false);
        }
        Window.Callback callback = this.f2513f.getCallback();
        int i4 = e4.f2467a;
        if (callback != null) {
            e4.f2473g = callback.onCreatePanelView(i4);
        }
        boolean z4 = i4 == 0 || i4 == 108;
        if (z4 && (interfaceC0214m04 = this.f2517j) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0214m04;
            actionBarOverlayLayout.f();
            ((g1) actionBarOverlayLayout.f2763e).f3098l = true;
        }
        if (e4.f2473g == null) {
            C0661o c0661o = e4.f2474h;
            if (c0661o == null || e4.f2481o) {
                if (c0661o == null) {
                    Context context = this.f2512e;
                    if ((i4 == 0 || i4 == 108) && this.f2517j != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.stepos.alphame.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(com.stepos.alphame.R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(com.stepos.alphame.R.attr.actionBarWidgetTheme, typedValue, true);
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
                            j.e eVar = new j.e(context, 0);
                            eVar.getTheme().setTo(themeNewTheme);
                            context = eVar;
                        }
                    }
                    C0661o c0661o2 = new C0661o(context);
                    c0661o2.f13242e = this;
                    C0661o c0661o3 = e4.f2474h;
                    if (c0661o2 != c0661o3) {
                        if (c0661o3 != null) {
                            c0661o3.r(e4.f2475i);
                        }
                        e4.f2474h = c0661o2;
                        C0657k c0657k = e4.f2475i;
                        if (c0657k != null) {
                            c0661o2.b(c0657k, c0661o2.f13238a);
                        }
                    }
                    if (e4.f2474h == null) {
                        return false;
                    }
                }
                if (z4 && (interfaceC0214m02 = this.f2517j) != null) {
                    if (this.f2518k == null) {
                        this.f2518k = new s(this, 3);
                    }
                    ((ActionBarOverlayLayout) interfaceC0214m02).g(e4.f2474h, this.f2518k);
                }
                e4.f2474h.w();
                if (!callback.onCreatePanelMenu(i4, e4.f2474h)) {
                    C0661o c0661o4 = e4.f2474h;
                    if (c0661o4 != null) {
                        if (c0661o4 != null) {
                            c0661o4.r(e4.f2475i);
                        }
                        e4.f2474h = null;
                    }
                    if (z4 && (interfaceC0214m0 = this.f2517j) != null) {
                        ((ActionBarOverlayLayout) interfaceC0214m0).g(null, this.f2518k);
                    }
                    return false;
                }
                e4.f2481o = false;
            }
            e4.f2474h.w();
            Bundle bundle = e4.f2482p;
            if (bundle != null) {
                e4.f2474h.s(bundle);
                e4.f2482p = null;
            }
            if (!callback.onPreparePanel(0, e4.f2473g, e4.f2474h)) {
                if (z4 && (interfaceC0214m03 = this.f2517j) != null) {
                    ((ActionBarOverlayLayout) interfaceC0214m03).g(null, this.f2518k);
                }
                e4.f2474h.v();
                return false;
            }
            e4.f2474h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            e4.f2474h.v();
        }
        e4.f2477k = true;
        e4.f2478l = false;
        this.f2491F = e4;
        return true;
    }

    public final boolean w(int i4) {
        if (i4 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i4 = 108;
        } else if (i4 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i4 = 109;
        }
        if (this.f2488C && i4 == 108) {
            return false;
        }
        if (this.f2532y && i4 == 1) {
            this.f2532y = false;
        }
        if (i4 == 1) {
            x();
            this.f2488C = true;
            return true;
        }
        if (i4 == 2) {
            x();
            this.f2530w = true;
            return true;
        }
        if (i4 == 5) {
            x();
            this.f2531x = true;
            return true;
        }
        if (i4 == 10) {
            x();
            this.f2486A = true;
            return true;
        }
        if (i4 == 108) {
            x();
            this.f2532y = true;
            return true;
        }
        if (i4 != 109) {
            return this.f2513f.requestFeature(i4);
        }
        x();
        this.f2533z = true;
        return true;
    }

    public final void x() {
        if (this.f2526s) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void y() {
        OnBackInvokedCallback onBackInvokedCallback;
        boolean z4 = false;
        if (this.f2509Y != null && (o(0).f2479m || this.f2520m != null)) {
            z4 = true;
        }
        if (z4 && this.f2510Z == null) {
            this.f2510Z = x.b(this.f2509Y, this);
        } else {
            if (z4 || (onBackInvokedCallback = this.f2510Z) == null) {
                return;
            }
            x.c(this.f2509Y, onBackInvokedCallback);
            this.f2510Z = null;
        }
    }

    public final int z(z0 z0Var, Rect rect) {
        boolean z4;
        boolean z5;
        int iD = z0Var != null ? z0Var.d() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f2521n;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z4 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2521n.getLayoutParams();
            if (this.f2521n.isShown()) {
                if (this.f2506V == null) {
                    this.f2506V = new Rect();
                    this.f2507W = new Rect();
                }
                Rect rect2 = this.f2506V;
                Rect rect3 = this.f2507W;
                if (z0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(z0Var.b(), z0Var.d(), z0Var.c(), z0Var.a());
                }
                k1.a(this.f2527t, rect2, rect3);
                int i4 = rect2.top;
                int i5 = rect2.left;
                int i6 = rect2.right;
                ViewGroup viewGroup = this.f2527t;
                WeakHashMap weakHashMap = S.f939a;
                z0 z0VarA = K.K.a(viewGroup);
                int iB = z0VarA == null ? 0 : z0VarA.b();
                int iC = z0VarA == null ? 0 : z0VarA.c();
                if (marginLayoutParams.topMargin == i4 && marginLayoutParams.leftMargin == i5 && marginLayoutParams.rightMargin == i6) {
                    z5 = false;
                } else {
                    marginLayoutParams.topMargin = i4;
                    marginLayoutParams.leftMargin = i5;
                    marginLayoutParams.rightMargin = i6;
                    z5 = true;
                }
                Context context = this.f2512e;
                if (i4 <= 0 || this.f2529v != null) {
                    View view = this.f2529v;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i7 = marginLayoutParams2.height;
                        int i8 = marginLayoutParams.topMargin;
                        if (i7 != i8 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                            marginLayoutParams2.height = i8;
                            marginLayoutParams2.leftMargin = iB;
                            marginLayoutParams2.rightMargin = iC;
                            this.f2529v.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(context);
                    this.f2529v = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iB;
                    layoutParams.rightMargin = iC;
                    this.f2527t.addView(this.f2529v, -1, layoutParams);
                }
                View view3 = this.f2529v;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    View view4 = this.f2529v;
                    view4.setBackgroundColor((view4.getWindowSystemUiVisibility() & 8192) != 0 ? androidx.core.content.b.a(context, com.stepos.alphame.R.color.abc_decor_view_status_guard_light) : androidx.core.content.b.a(context, com.stepos.alphame.R.color.abc_decor_view_status_guard));
                }
                if (!this.f2486A && z) {
                    iD = 0;
                }
                z4 = z;
                z = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z4 = false;
            } else {
                z4 = false;
                z = false;
            }
            if (z) {
                this.f2521n.setLayoutParams(marginLayoutParams);
            }
        }
        View view5 = this.f2529v;
        if (view5 != null) {
            view5.setVisibility(z4 ? 0 : 8);
        }
        return iD;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
