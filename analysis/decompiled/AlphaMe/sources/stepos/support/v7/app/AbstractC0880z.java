package stepos.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.ViewOnClickListenerC0177c;
import androidx.appcompat.widget.ContentFrameLayout;
import com.stepos.alphame.R;
import g.AbstractC0560a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import k3.C0687b;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.y0;

/* renamed from: stepos.support.v7.app.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0880z extends AbstractC0870o implements L3.i {

    /* renamed from: A, reason: collision with root package name */
    public TextView f14612A;

    /* renamed from: B, reason: collision with root package name */
    public View f14613B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f14614C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f14615D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f14616E;

    /* renamed from: F, reason: collision with root package name */
    public C0879y[] f14617F;

    /* renamed from: G, reason: collision with root package name */
    public C0879y f14618G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f14619H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f14620I;

    /* renamed from: J, reason: collision with root package name */
    public int f14621J;

    /* renamed from: K, reason: collision with root package name */
    public final RunnableC0876v f14622K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f14623L;

    /* renamed from: M, reason: collision with root package name */
    public Rect f14624M;

    /* renamed from: N, reason: collision with root package name */
    public Rect f14625N;

    /* renamed from: O, reason: collision with root package name */
    public final C0877w f14626O;

    /* renamed from: P, reason: collision with root package name */
    public final ViewOnClickListenerC0177c f14627P;

    /* renamed from: q, reason: collision with root package name */
    public stepos.support.v7.widget.C f14628q;

    /* renamed from: r, reason: collision with root package name */
    public C0877w f14629r;

    /* renamed from: s, reason: collision with root package name */
    public C0877w f14630s;

    /* renamed from: t, reason: collision with root package name */
    public K3.c f14631t;

    /* renamed from: u, reason: collision with root package name */
    public ActionBarContextView f14632u;

    /* renamed from: v, reason: collision with root package name */
    public PopupWindow f14633v;

    /* renamed from: w, reason: collision with root package name */
    public RunnableC0876v f14634w;

    /* renamed from: x, reason: collision with root package name */
    public K.e0 f14635x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f14636y;

    /* renamed from: z, reason: collision with root package name */
    public ViewGroup f14637z;

    public AbstractC0880z(Context context, Window window, InterfaceC0867l interfaceC0867l) {
        super(context, window, interfaceC0867l);
        this.f14635x = null;
        int i4 = 0;
        this.f14622K = new RunnableC0876v(this, i4);
        this.f14626O = new C0877w(this, i4);
        this.f14627P = new ViewOnClickListenerC0177c(4, this);
    }

    public static void n(AbstractC0880z abstractC0880z, int i4) {
        C0879y c0879yU = abstractC0880z.u(i4);
        if (c0879yU.f14602h != null) {
            Bundle bundle = new Bundle();
            c0879yU.f14602h.s(bundle);
            if (bundle.size() > 0) {
                c0879yU.f14610p = bundle;
            }
            c0879yU.f14602h.v();
            c0879yU.f14602h.clear();
        }
        c0879yU.f14609o = true;
        c0879yU.f14608n = true;
        if ((i4 == 108 || i4 == 0) && abstractC0880z.f14628q != null) {
            C0879y c0879yU2 = abstractC0880z.u(0);
            c0879yU2.f14605k = false;
            abstractC0880z.A(c0879yU2, null);
        }
    }

    public static int o(AbstractC0880z abstractC0880z, int i4) {
        boolean z4;
        boolean z5;
        ActionBarContextView actionBarContextView = abstractC0880z.f14632u;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z4 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) abstractC0880z.f14632u.getLayoutParams();
            if (abstractC0880z.f14632u.isShown()) {
                if (abstractC0880z.f14624M == null) {
                    abstractC0880z.f14624M = new Rect();
                    abstractC0880z.f14625N = new Rect();
                }
                Rect rect = abstractC0880z.f14624M;
                Rect rect2 = abstractC0880z.f14625N;
                rect.set(0, i4, 0, 0);
                ViewGroup viewGroup = abstractC0880z.f14637z;
                Method method = y0.f15251a;
                if (method != null) {
                    try {
                        ((Boolean) method.invoke(viewGroup, rect, rect2)).booleanValue();
                    } catch (Exception e4) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e4);
                    }
                }
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i4 : 0)) {
                    marginLayoutParams.topMargin = i4;
                    View view = abstractC0880z.f14613B;
                    if (view == null) {
                        Context context = abstractC0880z.f14509a;
                        View view2 = new View(context);
                        abstractC0880z.f14613B = view2;
                        view2.setBackgroundColor(context.getResources().getColor(R.color.stepos_background_light));
                        abstractC0880z.f14637z.addView(abstractC0880z.f14613B, -1, new ViewGroup.LayoutParams(-1, i4));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i4) {
                            layoutParams.height = i4;
                            abstractC0880z.f14613B.setLayoutParams(layoutParams);
                        }
                    }
                    z5 = true;
                } else {
                    z5 = false;
                }
                z = abstractC0880z.f14613B != null;
                if (!abstractC0880z.f14518j && z) {
                    i4 = 0;
                }
                boolean z6 = z;
                z = z5;
                z4 = z6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z4 = false;
            } else {
                z4 = false;
                z = false;
            }
            if (z) {
                abstractC0880z.f14632u.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = abstractC0880z.f14613B;
        if (view3 != null) {
            view3.setVisibility(z4 ? 0 : 8);
        }
        return i4;
    }

    public final boolean A(C0879y c0879y, KeyEvent keyEvent) {
        stepos.support.v7.widget.C c4;
        stepos.support.v7.widget.C c5;
        Resources.Theme themeNewTheme;
        int deviceId;
        stepos.support.v7.widget.C c6;
        stepos.support.v7.widget.C c7;
        int i4 = 0;
        if (this.f14523o) {
            return false;
        }
        if (c0879y.f14605k) {
            return true;
        }
        C0879y c0879y2 = this.f14618G;
        if (c0879y2 != null && c0879y2 != c0879y) {
            r(c0879y2, false);
        }
        Window.Callback callback = this.f14510b.getCallback();
        int i5 = c0879y.f14595a;
        if (callback != null) {
            c0879y.f14601g = callback.onCreatePanelView(i5);
        }
        boolean z4 = i5 == 0 || i5 == 108;
        if (z4 && (c7 = this.f14628q) != null) {
            c7.c();
        }
        if (c0879y.f14601g == null && (!z4 || !(this.f14514f instanceof c0))) {
            L3.k kVar = c0879y.f14602h;
            if (kVar == null || c0879y.f14609o) {
                if (kVar == null) {
                    Context context = this.f14509a;
                    if ((i5 == 0 || i5 == 108) && this.f14628q != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
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
                    L3.k kVar2 = new L3.k(context);
                    kVar2.f1284d = this;
                    L3.k kVar3 = c0879y.f14602h;
                    if (kVar2 != kVar3) {
                        if (kVar3 != null) {
                            kVar3.q(c0879y.f14603i);
                        }
                        c0879y.f14602h = kVar2;
                        L3.h hVar = c0879y.f14603i;
                        if (hVar != null) {
                            kVar2.b(hVar, kVar2.f1281a);
                        }
                    }
                    if (c0879y.f14602h == null) {
                        return false;
                    }
                }
                if (z4 && (c5 = this.f14628q) != null) {
                    if (this.f14629r == null) {
                        this.f14629r = new C0877w(this, 4, i4);
                    }
                    c5.a(c0879y.f14602h, this.f14629r);
                }
                c0879y.f14602h.v();
                if (!callback.onCreatePanelMenu(i5, c0879y.f14602h)) {
                    L3.k kVar4 = c0879y.f14602h;
                    if (kVar4 != null) {
                        if (kVar4 != null) {
                            kVar4.q(c0879y.f14603i);
                        }
                        c0879y.f14602h = null;
                    }
                    if (z4 && (c4 = this.f14628q) != null) {
                        c4.a(null, this.f14629r);
                    }
                    return false;
                }
                c0879y.f14609o = false;
            }
            InterfaceC0867l interfaceC0867l = this.f14513e;
            if (interfaceC0867l != null) {
                interfaceC0867l.onOptionsMenuCreated(c0879y.f14602h);
            }
            c0879y.f14602h.v();
            Bundle bundle = c0879y.f14610p;
            if (bundle != null) {
                c0879y.f14602h.r(bundle);
                c0879y.f14610p = null;
            }
            if (!callback.onPreparePanel(0, c0879y.f14601g, c0879y.f14602h)) {
                if (z4 && (c6 = this.f14628q) != null) {
                    c6.a(null, this.f14629r);
                }
                c0879y.f14602h.u();
                return false;
            }
            if (keyEvent != null) {
                try {
                    deviceId = keyEvent.getDeviceId();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } else {
                deviceId = -1;
            }
            c0879y.f14602h.setQwertyMode(KeyCharacterMap.load(deviceId).getKeyboardType() != 1);
            c0879y.f14602h.u();
            z(c0879y);
        }
        c0879y.f14605k = true;
        c0879y.f14606l = false;
        this.f14618G = c0879y;
        return true;
    }

    public final void B() {
        if (this.f14636y) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Override // L3.i
    public final boolean b(L3.k kVar, MenuItem menuItem) {
        C0879y c0879y;
        Window.Callback callback = this.f14510b.getCallback();
        if (callback != null && !this.f14523o) {
            L3.k kVarK = kVar.k();
            C0879y[] c0879yArr = this.f14617F;
            int length = c0879yArr != null ? c0879yArr.length : 0;
            int i4 = 0;
            while (true) {
                if (i4 < length) {
                    c0879y = c0879yArr[i4];
                    if (c0879y != null && c0879y.f14602h == kVarK) {
                        break;
                    }
                    i4++;
                } else {
                    c0879y = null;
                    break;
                }
            }
            if (c0879y != null) {
                int i5 = c0879y.f14595a;
                boolean zOnMenuItemSelected = callback.onMenuItemSelected(i5, menuItem);
                return (zOnMenuItemSelected || !(menuItem instanceof L3.g)) ? zOnMenuItemSelected : this.f14513e.onMenuItemSelected(i5, (L3.g) menuItem);
            }
        }
        return false;
    }

    @Override // L3.i
    public final void c(L3.k kVar) {
        stepos.support.v7.widget.C c4 = this.f14628q;
        if (c4 == null || !c4.h() || (ViewConfiguration.get(this.f14509a).hasPermanentMenuKey() && !this.f14628q.e())) {
            C0879y c0879yU = u(0);
            c0879yU.f14608n = true;
            r(c0879yU, false);
            x(c0879yU, null);
            return;
        }
        Window window = this.f14510b;
        Window.Callback callback = window.getCallback();
        if (this.f14628q.b()) {
            this.f14628q.f();
            if (this.f14523o) {
                return;
            }
            callback.onPanelClosed(108, u(0).f14602h);
            return;
        }
        if (callback == null || this.f14523o) {
            return;
        }
        if (this.f14620I && (1 & this.f14621J) != 0) {
            View decorView = window.getDecorView();
            RunnableC0876v runnableC0876v = this.f14622K;
            decorView.removeCallbacks(runnableC0876v);
            runnableC0876v.run();
        }
        C0879y c0879yU2 = u(0);
        L3.k kVar2 = c0879yU2.f14602h;
        if (kVar2 == null || c0879yU2.f14609o || !callback.onPreparePanel(0, c0879yU2.f14601g, kVar2)) {
            return;
        }
        callback.onMenuOpened(108, c0879yU2.f14602h);
        this.f14628q.g();
    }

    @Override // stepos.support.v7.app.AbstractC0868m
    public final void d() {
        l();
        AbstractC0860e abstractC0860e = this.f14514f;
        if (abstractC0860e == null || !abstractC0860e.f()) {
            v(0);
        }
    }

    @Override // stepos.support.v7.app.AbstractC0868m
    public void e(Bundle bundle) {
        int i4;
        if ((y0.f15251a == null || y0.f15252b == null) && ((i4 = y0.f15253c) == 2 || i4 == 0)) {
            new C0687b().start();
            y0.f15253c = 1;
        }
        Window.Callback callback = this.f14511c;
        if (callback instanceof Activity) {
            if (B0.f.I((Activity) callback) != null) {
                AbstractC0860e abstractC0860e = this.f14514f;
                if (abstractC0860e == null) {
                    this.f14623L = true;
                } else {
                    abstractC0860e.k(true);
                }
            }
            Window window = this.f14510b;
            window.getDecorView().getSystemUiVisibility();
            window.setDecorFitsSystemWindows(false);
        }
    }

    @Override // stepos.support.v7.app.AbstractC0868m
    public final boolean g(int i4) {
        if (i4 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i4 = 108;
        } else if (i4 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i4 = 109;
        }
        if (this.f14520l && i4 == 108) {
            return false;
        }
        if (this.f14516h && i4 == 1) {
            this.f14516h = false;
        }
        if (i4 == 1) {
            B();
            this.f14520l = true;
            return true;
        }
        if (i4 == 2) {
            B();
            this.f14614C = true;
            return true;
        }
        if (i4 == 5) {
            B();
            this.f14615D = true;
            return true;
        }
        if (i4 == 10) {
            B();
            this.f14518j = true;
            return true;
        }
        if (i4 == 1001) {
            B();
            this.f14521m = true;
            return true;
        }
        if (i4 == 108) {
            B();
            this.f14516h = true;
            return true;
        }
        if (i4 != 109) {
            return this.f14510b.requestFeature(i4);
        }
        B();
        this.f14517i = true;
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC0868m
    public final void h(int i4) {
        t();
        ViewGroup viewGroup = (ViewGroup) this.f14637z.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f14509a).inflate(i4, viewGroup);
        this.f14511c.onContentChanged();
    }

    @Override // stepos.support.v7.app.AbstractC0868m
    public final K3.c i(K3.b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        K3.c cVar = this.f14631t;
        if (cVar != null) {
            cVar.a();
        }
        B0.e eVar = new B0.e(this, bVar, 11);
        l();
        AbstractC0860e abstractC0860e = this.f14514f;
        if (abstractC0860e != null) {
            this.f14631t = abstractC0860e.v(eVar);
        }
        return this.f14631t;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    @Override // stepos.support.v7.app.AbstractC0868m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final K3.c j(K3.b r10) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AbstractC0880z.j(K3.b):K3.c");
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    @Override // stepos.support.v7.app.AbstractC0870o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AbstractC0880z.k(android.view.KeyEvent):boolean");
    }

    @Override // stepos.support.v7.app.AbstractC0870o
    public final void l() {
        t();
        if (this.f14516h && this.f14514f == null) {
            Window.Callback callback = this.f14511c;
            if (callback instanceof Activity) {
                if (this.f14521m) {
                    this.f14514f = new M((Activity) callback);
                } else {
                    this.f14514f = new g0((Activity) callback, this.f14517i);
                }
            } else if (callback instanceof Dialog) {
                this.f14514f = new g0((Dialog) callback);
            }
            AbstractC0860e abstractC0860e = this.f14514f;
            if (abstractC0860e != null) {
                abstractC0860e.k(this.f14623L);
            }
        }
    }

    public final void p(int i4, C0879y c0879y, L3.k kVar) {
        if (kVar == null) {
            if (c0879y == null && i4 >= 0) {
                C0879y[] c0879yArr = this.f14617F;
                if (i4 < c0879yArr.length) {
                    c0879y = c0879yArr[i4];
                }
            }
            if (c0879y != null) {
                kVar = c0879y.f14602h;
            }
        }
        if ((c0879y == null || c0879y.f14607m) && !this.f14523o) {
            this.f14511c.onPanelClosed(i4, kVar);
        }
    }

    public final void q(L3.k kVar) {
        if (this.f14616E) {
            return;
        }
        this.f14616E = true;
        this.f14628q.l();
        Window.Callback callback = this.f14510b.getCallback();
        if (callback != null && !this.f14523o) {
            callback.onPanelClosed(108, kVar);
        }
        this.f14616E = false;
    }

    public final void r(C0879y c0879y, boolean z4) {
        androidx.appcompat.app.C c4;
        stepos.support.v7.widget.C c5;
        if (z4 && c0879y.f14595a == 0 && (c5 = this.f14628q) != null && c5.b()) {
            q(c0879y.f14602h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f14509a.getSystemService("window");
        if (windowManager != null && c0879y.f14607m && (c4 = c0879y.f14599e) != null) {
            if (c4.getParent() != null) {
                windowManager.removeView(c0879y.f14599e);
            }
            if (z4) {
                p(c0879y.f14595a, c0879y, null);
            }
        }
        c0879y.f14605k = false;
        c0879y.f14606l = false;
        c0879y.f14607m = false;
        c0879y.f14600f = null;
        c0879y.f14608n = true;
        if (this.f14618G == c0879y) {
            this.f14618G = null;
        }
    }

    public final void s() {
        K.e0 e0Var = this.f14635x;
        if (e0Var != null) {
            e0Var.b();
        }
    }

    public final void t() {
        ViewGroup viewGroup;
        if (this.f14636y) {
            return;
        }
        int[] iArr = AbstractC0560a.f12597j;
        Context context = this.f14509a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(121)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        int i4 = 1;
        if (typedArrayObtainStyledAttributes.getBoolean(130, false)) {
            g(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(121, false)) {
            g(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(122, false)) {
            g(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(123, false)) {
            g(10);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(103, false)) {
            g(1001);
        }
        this.f14519k = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        Window window = this.f14510b;
        window.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.f14520l) {
            viewGroup = this.f14518j ? (ViewGroup) layoutInflaterFrom.inflate(R.layout.stepos_abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(R.layout.stepos_abc_screen_simple, (ViewGroup) null);
            C0877w c0877w = new C0877w(this, i4);
            WeakHashMap weakHashMap = K.S.f939a;
            K.J.u(viewGroup, c0877w);
        } else if (this.f14519k) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.f14517i = false;
            this.f14516h = false;
        } else if (this.f14516h) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Context eVar = typedValue.resourceId != 0 ? new j.e(context, typedValue.resourceId) : context;
            if (this.f14521m) {
                TypedValue typedValue2 = new TypedValue();
                eVar.getTheme().resolveAttribute(R.attr.steposNestedScrollActionBarTheme, typedValue2, true);
                if (typedValue2.resourceId != 0) {
                    eVar = new j.e(eVar, typedValue2.resourceId);
                }
                viewGroup = (ViewGroup) LayoutInflater.from(eVar).inflate(R.layout.stepos_nested_scroll_toolbar, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) LayoutInflater.from(eVar).inflate(R.layout.stepos_abc_screen_toolbar_full_screen, (ViewGroup) null);
            }
            stepos.support.v7.widget.C c4 = (stepos.support.v7.widget.C) viewGroup.findViewById(R.id.decor_content_parent);
            this.f14628q = c4;
            c4.setWindowCallback(window.getCallback());
            if (this.f14517i) {
                this.f14628q.k(109);
            }
            if (this.f14614C) {
                this.f14628q.k(2);
            }
            if (this.f14615D) {
                this.f14628q.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f14516h + ", windowActionBarOverlay: " + this.f14517i + ", android:windowIsFloating: " + this.f14519k + ", windowActionModeOverlay: " + this.f14518j + ", windowNoTitle: " + this.f14520l + " }");
        }
        if (this.f14628q == null) {
            this.f14612A = (TextView) viewGroup.findViewById(R.id.title);
        }
        y0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) window.findViewById(android.R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(android.R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                viewGroup2.setForeground(null);
            }
        }
        window.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new C0877w(this, 3));
        this.f14637z = viewGroup;
        Window.Callback callback = this.f14511c;
        CharSequence title = callback instanceof Activity ? ((Activity) callback).getTitle() : this.f14522n;
        if (!TextUtils.isEmpty(title)) {
            stepos.support.v7.widget.C c5 = this.f14628q;
            if (c5 != null) {
                c5.setWindowTitle(title);
            } else {
                AbstractC0860e abstractC0860e = this.f14514f;
                if (abstractC0860e != null) {
                    abstractC0860e.t(title);
                } else {
                    TextView textView = this.f14612A;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f14637z.findViewById(android.R.id.content);
        View decorView = window.getDecorView();
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
        w(this.f14637z);
        this.f14636y = true;
        C0879y c0879yU = u(0);
        if (!this.f14523o && c0879yU.f14602h == null) {
            v(108);
        }
        l();
        if (this.f14514f != null) {
            l();
            this.f14514f.s(this.f14524p);
        }
    }

    public final C0879y u(int i4) {
        C0879y[] c0879yArr = this.f14617F;
        if (c0879yArr == null || c0879yArr.length <= i4) {
            C0879y[] c0879yArr2 = new C0879y[i4 + 1];
            if (c0879yArr != null) {
                System.arraycopy(c0879yArr, 0, c0879yArr2, 0, c0879yArr.length);
            }
            this.f14617F = c0879yArr2;
            c0879yArr = c0879yArr2;
        }
        C0879y c0879y = c0879yArr[i4];
        if (c0879y != null) {
            return c0879y;
        }
        C0879y c0879y2 = new C0879y();
        c0879y2.f14595a = i4;
        c0879y2.f14608n = false;
        c0879yArr[i4] = c0879y2;
        return c0879y2;
    }

    public final void v(int i4) {
        this.f14621J = (1 << i4) | this.f14621J;
        if (this.f14620I) {
            return;
        }
        View decorView = this.f14510b.getDecorView();
        WeakHashMap weakHashMap = K.S.f939a;
        decorView.postOnAnimation(this.f14622K);
        this.f14620I = true;
    }

    public abstract void w(ViewGroup viewGroup);

    public final void x(C0879y c0879y, KeyEvent keyEvent) {
        if (c0879y.f14607m || this.f14523o) {
            return;
        }
        int i4 = c0879y.f14595a;
        int i5 = 0;
        Context context = this.f14509a;
        if (i4 == 0) {
            boolean z4 = (context.getResources().getConfiguration().screenLayout & 15) == 4;
            boolean z5 = context.getApplicationInfo().targetSdkVersion >= 11;
            if (z4 && z5) {
                return;
            }
        }
        Window.Callback callback = this.f14510b.getCallback();
        if (callback != null && !callback.onMenuOpened(i4, c0879y.f14602h)) {
            r(c0879y, true);
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null && A(c0879y, keyEvent)) {
            androidx.appcompat.app.C c4 = c0879y.f14599e;
            int i6 = -2;
            if (c4 == null || c0879y.f14608n) {
                if (c4 == null) {
                    l();
                    AbstractC0860e abstractC0860e = this.f14514f;
                    Context contextD = abstractC0860e != null ? abstractC0860e.d() : null;
                    if (contextD != null) {
                        context = contextD;
                    }
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(context.getTheme());
                    themeNewTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
                    int i7 = typedValue.resourceId;
                    if (i7 != 0) {
                        themeNewTheme.applyStyle(i7, true);
                    }
                    themeNewTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
                    int i8 = typedValue.resourceId;
                    if (i8 != 0) {
                        themeNewTheme.applyStyle(i8, true);
                    } else {
                        themeNewTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
                    }
                    j.e eVar = new j.e(context, 0);
                    eVar.getTheme().setTo(themeNewTheme);
                    c0879y.f14604j = eVar;
                    TypedArray typedArrayObtainStyledAttributes = eVar.obtainStyledAttributes(AbstractC0560a.f12597j);
                    c0879y.f14596b = typedArrayObtainStyledAttributes.getResourceId(86, 0);
                    c0879y.f14598d = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                    typedArrayObtainStyledAttributes.recycle();
                    c0879y.f14599e = new androidx.appcompat.app.C(this, c0879y.f14604j, 1);
                    c0879y.f14597c = 81;
                } else if (c0879y.f14608n && c4.getChildCount() > 0) {
                    c0879y.f14599e.removeAllViews();
                }
                View view = c0879y.f14601g;
                if (view != null) {
                    c0879y.f14600f = view;
                } else {
                    if (c0879y.f14602h == null) {
                        return;
                    }
                    if (this.f14630s == null) {
                        this.f14630s = new C0877w(this, 5, i5);
                    }
                    C0877w c0877w = this.f14630s;
                    if (c0879y.f14603i == null) {
                        L3.h hVar = new L3.h(c0879y.f14604j);
                        c0879y.f14603i = hVar;
                        hVar.f1278e = c0877w;
                        L3.k kVar = c0879y.f14602h;
                        kVar.b(hVar, kVar.f1281a);
                    }
                    View view2 = (View) c0879y.f14603i.i(c0879y.f14599e);
                    c0879y.f14600f = view2;
                    if (view2 == null) {
                        return;
                    }
                }
                if (c0879y.f14600f == null) {
                    return;
                }
                if (c0879y.f14601g == null && c0879y.f14603i.b().getCount() <= 0) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = c0879y.f14600f.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                c0879y.f14599e.setBackgroundResource(c0879y.f14596b);
                ViewParent parent = c0879y.f14600f.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(c0879y.f14600f);
                }
                c0879y.f14599e.addView(c0879y.f14600f, layoutParams);
                if (!c0879y.f14600f.hasFocus()) {
                    c0879y.f14600f.requestFocus();
                }
            } else {
                View view3 = c0879y.f14601g;
                if (view3 != null) {
                    ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                    if (layoutParams2 != null && layoutParams2.width == -1) {
                        i6 = -1;
                    }
                } else {
                    if (c0879y.f14600f == null) {
                        return;
                    }
                    if (view3 == null && c0879y.f14603i.b().getCount() <= 0) {
                        return;
                    }
                }
            }
            int i9 = i6;
            c0879y.f14606l = false;
            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i9, -2, 0, 0, 1002, 8519680, -3);
            layoutParams3.gravity = c0879y.f14597c;
            layoutParams3.windowAnimations = c0879y.f14598d;
            windowManager.addView(c0879y.f14599e, layoutParams3);
            c0879y.f14607m = true;
        }
    }

    public final boolean y(C0879y c0879y, int i4, KeyEvent keyEvent) {
        L3.k kVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c0879y.f14605k || A(c0879y, keyEvent)) && (kVar = c0879y.f14602h) != null) {
            return kVar.performShortcut(i4, keyEvent, 1);
        }
        return false;
    }

    public final void z(C0879y c0879y) {
        L3.k kVar = new L3.k(this.f14509a);
        kVar.f1284d = this.f14626O;
        if (kVar != c0879y.f14611q) {
            c0879y.f14611q = kVar;
        }
        stepos.support.v7.widget.C c4 = this.f14628q;
        if (c4 != null) {
            if (this.f14629r == null) {
                this.f14629r = new C0877w(this, 4, 0);
            }
            c4.m(c0879y.f14611q, this.f14629r);
        }
        c0879y.f14611q.v();
        if (this.f14513e.onCreateBottomMenu(c0879y.f14611q)) {
            c0879y.f14611q.u();
            return;
        }
        if (c0879y.f14611q != null) {
            c0879y.f14611q = null;
        }
        stepos.support.v7.widget.C c5 = this.f14628q;
        if (c5 != null) {
            c5.m(null, this.f14629r);
        }
    }
}
