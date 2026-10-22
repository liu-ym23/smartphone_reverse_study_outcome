package stepos.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
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
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.core.app.NavUtils;
import androidx.core.view.LayoutInflaterFactory;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import fa.C1449a;
import h2.RunnableC1484b;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.I0;
import u1.C2031a;
import v0.C2054a;
import w0.C2086g;

/* renamed from: stepos.support.v7.app.y, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1975y extends AbstractC1966o implements Va.l, LayoutInflaterFactory {

    /* renamed from: A, reason: collision with root package name */
    public TextView f6346A;

    /* renamed from: B, reason: collision with root package name */
    public View f6347B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f6348C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f6349D;
    public boolean E;

    /* renamed from: F, reason: collision with root package name */
    public C1974x[] f6350F;

    /* renamed from: G, reason: collision with root package name */
    public C1974x f6351G;

    /* renamed from: L, reason: collision with root package name */
    public boolean f6352L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f6353M;

    /* renamed from: N, reason: collision with root package name */
    public int f6354N;

    /* renamed from: O, reason: collision with root package name */
    public final r f6355O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f6356P;

    /* renamed from: Q, reason: collision with root package name */
    public Rect f6357Q;

    /* renamed from: R, reason: collision with root package name */
    public Rect f6358R;

    /* renamed from: S, reason: collision with root package name */
    public B f6359S;

    /* renamed from: T, reason: collision with root package name */
    public final C2031a f6360T;

    /* renamed from: U, reason: collision with root package name */
    public final ViewOnClickListenerC1971u f6361U;

    /* renamed from: q, reason: collision with root package name */
    public stepos.support.v7.widget.H f6362q;

    /* renamed from: r, reason: collision with root package name */
    public C2086g f6363r;

    /* renamed from: s, reason: collision with root package name */
    public A0.b f6364s;

    /* renamed from: t, reason: collision with root package name */
    public Ua.c f6365t;
    public ActionBarContextView u;

    /* renamed from: v, reason: collision with root package name */
    public PopupWindow f6366v;

    /* renamed from: w, reason: collision with root package name */
    public RunnableC1484b f6367w;

    /* renamed from: x, reason: collision with root package name */
    public ViewPropertyAnimatorCompat f6368x;
    public boolean y;

    /* renamed from: z, reason: collision with root package name */
    public ViewGroup f6369z;

    public AbstractC1975y(Context context, Window window, InterfaceC1963l interfaceC1963l) {
        super(context, window, interfaceC1963l);
        this.f6368x = null;
        this.f6355O = new r(this);
        this.f6360T = new C2031a(this);
        this.f6361U = new ViewOnClickListenerC1971u(this, 0);
    }

    public static void o(AbstractC1975y abstractC1975y, int i) {
        C1974x c1974xV = abstractC1975y.v(i);
        if (c1974xV.h != null) {
            Bundle bundle = new Bundle();
            c1974xV.h.s(bundle);
            if (bundle.size() > 0) {
                c1974xV.p = bundle;
            }
            c1974xV.h.v();
            c1974xV.h.clear();
        }
        c1974xV.o = true;
        c1974xV.n = true;
        if ((i == 108 || i == 0) && abstractC1975y.f6362q != null) {
            C1974x c1974xV2 = abstractC1975y.v(0);
            c1974xV2.k = false;
            abstractC1975y.A(c1974xV2, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d0  */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, stepos.support.v7.app.l] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A(stepos.support.v7.app.C1974x r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AbstractC1975y.A(stepos.support.v7.app.x, android.view.KeyEvent):boolean");
    }

    public final void B() {
        if (this.y) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Override // stepos.support.v7.app.AbstractC1964m
    public final void b() {
        m();
        AbstractC1955d abstractC1955d = this.f;
        if (abstractC1955d == null || !abstractC1955d.e()) {
            this.f6354N |= 1;
            if (this.f6353M) {
                return;
            }
            ViewCompat.postOnAnimation(this.b.getDecorView(), this.f6355O);
            this.f6353M = true;
        }
    }

    @Override // stepos.support.v7.app.AbstractC1964m
    public void c(Bundle bundle) {
        int i;
        if ((I0.f6469a == null || I0.b == null) && ((i = I0.c) == 2 || i == 0)) {
            new E2.b().start();
            I0.c = 1;
        }
        Window.Callback callback = this.c;
        if (callback instanceof Activity) {
            if (NavUtils.getParentActivityName((Activity) callback) != null) {
                AbstractC1955d abstractC1955d = this.f;
                if (abstractC1955d == null) {
                    this.f6356P = true;
                } else {
                    abstractC1955d.i(true);
                }
            }
            Window window = this.b;
            window.getDecorView().getSystemUiVisibility();
            window.setDecorFitsSystemWindows(false);
        }
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, stepos.support.v7.app.l] */
    @Override // Va.l
    public final boolean e(Va.n nVar, MenuItem menuItem) {
        C1974x c1974x;
        Window.Callback callback = this.b.getCallback();
        if (callback != null && !this.o) {
            Va.n nVarK = nVar.k();
            C1974x[] c1974xArr = this.f6350F;
            int length = c1974xArr != null ? c1974xArr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    c1974x = c1974xArr[i];
                    if (c1974x != null && c1974x.h == nVarK) {
                        break;
                    }
                    i++;
                } else {
                    c1974x = null;
                    break;
                }
            }
            if (c1974x != null) {
                int i6 = c1974x.f6343a;
                boolean zOnMenuItemSelected = callback.onMenuItemSelected(i6, menuItem);
                return (zOnMenuItemSelected || !(menuItem instanceof Va.i)) ? zOnMenuItemSelected : this.e.onMenuItemSelected(i6, (Va.i) menuItem);
            }
        }
        return false;
    }

    @Override // stepos.support.v7.app.AbstractC1964m
    public final boolean f(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.l && i == 108) {
            return false;
        }
        if (this.h && i == 1) {
            this.h = false;
        }
        if (i == 1) {
            B();
            this.l = true;
            return true;
        }
        if (i == 2) {
            B();
            this.f6348C = true;
            return true;
        }
        if (i == 5) {
            B();
            this.f6349D = true;
            return true;
        }
        if (i == 10) {
            B();
            this.f6317j = true;
            return true;
        }
        if (i == 1001) {
            B();
            this.m = true;
            return true;
        }
        if (i == 108) {
            B();
            this.h = true;
            return true;
        }
        if (i != 109) {
            return this.b.requestFeature(i);
        }
        B();
        this.i = true;
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC1964m
    public final void g(int i) {
        u();
        ViewGroup viewGroup = (ViewGroup) this.f6369z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f6316a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    @Override // stepos.support.v7.app.AbstractC1964m
    public final Ua.c h(Ua.b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        Ua.c cVar = this.f6365t;
        if (cVar != null) {
            cVar.a();
        }
        C1449a c1449a = new C1449a(9, this, bVar);
        m();
        AbstractC1955d abstractC1955d = this.f;
        if (abstractC1955d != null) {
            this.f6365t = abstractC1955d.u(c1449a);
        }
        return this.f6365t;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0166  */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, stepos.support.v7.app.l] */
    @Override // stepos.support.v7.app.AbstractC1964m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final Ua.c i(Ua.b r10) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AbstractC1975y.i(Ua.b):Ua.c");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2  */
    @Override // stepos.support.v7.app.AbstractC1966o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AbstractC1975y.j(android.view.KeyEvent):boolean");
    }

    @Override // Va.l
    public final void k(Va.n nVar) {
        stepos.support.v7.widget.H h = this.f6362q;
        if (h == null || !h.canShowOverflowMenu() || (ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.f6316a)) && !this.f6362q.isOverflowMenuShowPending())) {
            C1974x c1974xV = v(0);
            c1974xV.n = true;
            s(c1974xV, false);
            x(c1974xV, null);
            return;
        }
        Window window = this.b;
        Window.Callback callback = window.getCallback();
        if (this.f6362q.isOverflowMenuShowing()) {
            this.f6362q.hideOverflowMenu();
            if (this.o) {
                return;
            }
            callback.onPanelClosed(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, v(0).h);
            return;
        }
        if (callback == null || this.o) {
            return;
        }
        if (this.f6353M && (1 & this.f6354N) != 0) {
            View decorView = window.getDecorView();
            r rVar = this.f6355O;
            decorView.removeCallbacks(rVar);
            rVar.run();
        }
        C1974x c1974xV2 = v(0);
        Va.n nVar2 = c1974xV2.h;
        if (nVar2 == null || c1974xV2.o || !callback.onPreparePanel(0, c1974xV2.g, nVar2)) {
            return;
        }
        callback.onMenuOpened(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, c1974xV2.h);
        this.f6362q.showOverflowMenu();
    }

    @Override // stepos.support.v7.app.AbstractC1966o
    public final void m() {
        u();
        if (this.h && this.f == null) {
            Window.Callback callback = this.c;
            if (callback instanceof Activity) {
                if (this.m) {
                    this.f = new L((Activity) callback);
                } else {
                    this.f = new e0((Activity) callback, this.i);
                }
            } else if (callback instanceof Dialog) {
                this.f = new e0((Dialog) callback);
            }
            AbstractC1955d abstractC1955d = this.f;
            if (abstractC1955d != null) {
                abstractC1955d.i(this.f6356P);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    @Override // androidx.core.view.LayoutInflaterFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r7, java.lang.String r8, android.content.Context r9, android.util.AttributeSet r10) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AbstractC1975y.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public abstract View p(String str, Context context, AttributeSet attributeSet);

    public final void q(int i, C1974x c1974x, Va.n nVar) {
        if (nVar == null) {
            if (c1974x == null && i >= 0) {
                C1974x[] c1974xArr = this.f6350F;
                if (i < c1974xArr.length) {
                    c1974x = c1974xArr[i];
                }
            }
            if (c1974x != null) {
                nVar = c1974x.h;
            }
        }
        if ((c1974x == null || c1974x.m) && !this.o) {
            this.c.onPanelClosed(i, nVar);
        }
    }

    public final void r(Va.n nVar) {
        if (this.E) {
            return;
        }
        this.E = true;
        this.f6362q.dismissPopups();
        Window.Callback callback = this.b.getCallback();
        if (callback != null && !this.o) {
            callback.onPanelClosed(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, nVar);
        }
        this.E = false;
    }

    public final void s(C1974x c1974x, boolean z10) {
        C1972v c1972v;
        stepos.support.v7.widget.H h;
        if (z10 && c1974x.f6343a == 0 && (h = this.f6362q) != null && h.isOverflowMenuShowing()) {
            r(c1974x.h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f6316a.getSystemService("window");
        if (windowManager != null && c1974x.m && (c1972v = c1974x.e) != null) {
            if (c1972v.getParent() != null) {
                windowManager.removeView(c1974x.e);
            }
            if (z10) {
                q(c1974x.f6343a, c1974x, null);
            }
        }
        c1974x.k = false;
        c1974x.l = false;
        c1974x.m = false;
        c1974x.f = null;
        c1974x.n = true;
        if (this.f6351G == c1974x) {
            this.f6351G = null;
        }
    }

    public final void t() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f6368x;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public final void u() {
        ViewGroup viewGroup;
        if (this.y) {
            return;
        }
        int[] iArr = androidx.appcompat.R.styleable.AppCompatTheme;
        Context context = this.f6316a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            f(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar, false)) {
            f(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            f(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            f(10);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(v7.o.META_DATA_FIELD_NUMBER, false)) {
            f(1001);
        }
        this.k = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        Window window = this.b;
        window.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.l) {
            viewGroup = this.f6317j ? (ViewGroup) layoutInflaterFrom.inflate(com.stepos.ability.R.layout.stepos_abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.stepos.ability.R.layout.stepos_abc_screen_simple, (ViewGroup) null);
            ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new C2054a(this));
        } else if (this.k) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.i = false;
            this.h = false;
        } else if (this.h) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            Context contextThemeWrapper = typedValue.resourceId != 0 ? new ContextThemeWrapper(context, typedValue.resourceId) : context;
            if (this.m) {
                TypedValue typedValue2 = new TypedValue();
                contextThemeWrapper.getTheme().resolveAttribute(com.stepos.ability.R.attr.steposNestedScrollActionBarTheme, typedValue2, true);
                if (typedValue2.resourceId != 0) {
                    contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, typedValue2.resourceId);
                }
                viewGroup = (ViewGroup) LayoutInflater.from(contextThemeWrapper).inflate(com.stepos.ability.R.layout.stepos_nested_scroll_toolbar, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) LayoutInflater.from(contextThemeWrapper).inflate(com.stepos.ability.R.layout.stepos_abc_screen_toolbar_full_screen, (ViewGroup) null);
            }
            stepos.support.v7.widget.H h = (stepos.support.v7.widget.H) viewGroup.findViewById(androidx.appcompat.R.id.decor_content_parent);
            this.f6362q = h;
            h.setWindowCallback(window.getCallback());
            if (this.i) {
                this.f6362q.initFeature(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
            }
            if (this.f6348C) {
                this.f6362q.initFeature(2);
            }
            if (this.f6349D) {
                this.f6362q.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            StringBuilder sb = new StringBuilder("AppCompat does not support the current theme features: { windowActionBar: ");
            sb.append(this.h);
            sb.append(", windowActionBarOverlay: ");
            sb.append(this.i);
            sb.append(", android:windowIsFloating: ");
            sb.append(this.k);
            sb.append(", windowActionModeOverlay: ");
            sb.append(this.f6317j);
            sb.append(", windowNoTitle: ");
            throw new IllegalArgumentException(B7.a.s(sb, this.l, " }"));
        }
        if (this.f6362q == null) {
            this.f6346A = (TextView) viewGroup.findViewById(androidx.appcompat.R.id.title);
        }
        I0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) window.findViewById(R.id.content);
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
        window.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new C1969s(this));
        this.f6369z = viewGroup;
        Window.Callback callback = this.c;
        CharSequence title = callback instanceof Activity ? ((Activity) callback).getTitle() : this.n;
        if (!TextUtils.isEmpty(title)) {
            stepos.support.v7.widget.H h10 = this.f6362q;
            if (h10 != null) {
                h10.setWindowTitle(title);
            } else {
                AbstractC1955d abstractC1955d = this.f;
                if (abstractC1955d != null) {
                    abstractC1955d.s(title);
                } else {
                    TextView textView = this.f6346A;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f6369z.findViewById(R.id.content);
        View decorView = window.getDecorView();
        contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        w(this.f6369z);
        this.y = true;
        C1974x c1974xV = v(0);
        if (!this.o && c1974xV.h == null) {
            this.f6354N |= 4096;
            if (!this.f6353M) {
                ViewCompat.postOnAnimation(window.getDecorView(), this.f6355O);
                this.f6353M = true;
            }
        }
        m();
        if (this.f != null) {
            m();
            this.f.r(this.p);
        }
    }

    public final C1974x v(int i) {
        C1974x[] c1974xArr = this.f6350F;
        if (c1974xArr == null || c1974xArr.length <= i) {
            C1974x[] c1974xArr2 = new C1974x[i + 1];
            if (c1974xArr != null) {
                System.arraycopy(c1974xArr, 0, c1974xArr2, 0, c1974xArr.length);
            }
            this.f6350F = c1974xArr2;
            c1974xArr = c1974xArr2;
        }
        C1974x c1974x = c1974xArr[i];
        if (c1974x != null) {
            return c1974x;
        }
        C1974x c1974x2 = new C1974x();
        c1974x2.f6343a = i;
        c1974x2.n = false;
        c1974xArr[i] = c1974x2;
        return c1974x2;
    }

    public abstract void w(ViewGroup viewGroup);

    public final void x(C1974x c1974x, KeyEvent keyEvent) {
        boolean z10 = c1974x.m;
        int i = c1974x.f6343a;
        if (z10 || this.o) {
            return;
        }
        Context context = this.f6316a;
        if (i == 0) {
            boolean z11 = (context.getResources().getConfiguration().screenLayout & 15) == 4;
            boolean z12 = context.getApplicationInfo().targetSdkVersion >= 11;
            if (z11 && z12) {
                return;
            }
        }
        Window.Callback callback = this.b.getCallback();
        if (callback != null && !callback.onMenuOpened(i, c1974x.h)) {
            s(c1974x, true);
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null && A(c1974x, keyEvent)) {
            C1972v c1972v = c1974x.e;
            int i6 = -2;
            if (c1972v == null || c1974x.n) {
                if (c1972v == null) {
                    Context contextL = l();
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme themeNewTheme = contextL.getResources().newTheme();
                    themeNewTheme.setTo(contextL.getTheme());
                    themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
                    int i10 = typedValue.resourceId;
                    if (i10 != 0) {
                        themeNewTheme.applyStyle(i10, true);
                    }
                    themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.panelMenuListTheme, typedValue, true);
                    int i11 = typedValue.resourceId;
                    if (i11 != 0) {
                        themeNewTheme.applyStyle(i11, true);
                    } else {
                        themeNewTheme.applyStyle(androidx.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
                    }
                    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(contextL, 0);
                    contextThemeWrapper.getTheme().setTo(themeNewTheme);
                    c1974x.f6344j = contextThemeWrapper;
                    TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
                    c1974x.b = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
                    c1974x.d = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
                    typedArrayObtainStyledAttributes.recycle();
                    c1974x.e = new C1972v(this, c1974x.f6344j);
                    c1974x.c = 81;
                } else if (c1974x.n && c1972v.getChildCount() > 0) {
                    c1974x.e.removeAllViews();
                }
                View view = c1974x.g;
                if (view != null) {
                    c1974x.f = view;
                } else {
                    if (c1974x.h == null) {
                        return;
                    }
                    if (this.f6364s == null) {
                        this.f6364s = new A0.b(this, 8);
                    }
                    A0.b bVar = this.f6364s;
                    if (c1974x.i == null) {
                        Va.k kVar = new Va.k(c1974x.f6344j);
                        c1974x.i = kVar;
                        kVar.e = bVar;
                        Va.n nVar = c1974x.h;
                        nVar.b(kVar, nVar.f1442a);
                    }
                    View view2 = (View) c1974x.i.g(c1974x.e);
                    c1974x.f = view2;
                    if (view2 == null) {
                        return;
                    }
                }
                if (c1974x.f == null) {
                    return;
                }
                if (c1974x.g == null && ((Va.j) c1974x.i.e()).getCount() <= 0) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = c1974x.f.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                c1974x.e.setBackgroundResource(c1974x.b);
                ViewParent parent = c1974x.f.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(c1974x.f);
                }
                c1974x.e.addView(c1974x.f, layoutParams);
                if (!c1974x.f.hasFocus()) {
                    c1974x.f.requestFocus();
                }
            } else {
                View view3 = c1974x.g;
                if (view3 != null) {
                    ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                    if (layoutParams2 != null && layoutParams2.width == -1) {
                        i6 = -1;
                    }
                } else {
                    if (c1974x.f == null) {
                        return;
                    }
                    if (view3 == null && ((Va.j) c1974x.i.e()).getCount() <= 0) {
                        return;
                    }
                }
            }
            int i12 = i6;
            c1974x.l = false;
            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i12, -2, 0, 0, 1002, 8519680, -3);
            layoutParams3.gravity = c1974x.c;
            layoutParams3.windowAnimations = c1974x.d;
            windowManager.addView(c1974x.e, layoutParams3);
            c1974x.m = true;
        }
    }

    public final boolean y(C1974x c1974x, int i, KeyEvent keyEvent) {
        Va.n nVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c1974x.k || A(c1974x, keyEvent)) && (nVar = c1974x.h) != null) {
            return nVar.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, stepos.support.v7.app.l] */
    public final void z(C1974x c1974x) {
        Va.n nVar = new Va.n(this.f6316a);
        nVar.d = this.f6360T;
        if (nVar != c1974x.f6345q) {
            c1974x.f6345q = nVar;
        }
        stepos.support.v7.widget.H h = this.f6362q;
        if (h != null) {
            if (this.f6363r == null) {
                this.f6363r = new C2086g(this);
            }
            h.c(c1974x.f6345q, this.f6363r);
        }
        c1974x.f6345q.v();
        if (this.e.onCreateBottomMenu(c1974x.f6345q)) {
            c1974x.f6345q.u();
            return;
        }
        if (c1974x.f6345q != null) {
            c1974x.f6345q = null;
        }
        stepos.support.v7.widget.H h10 = this.f6362q;
        if (h10 != null) {
            h10.c(null, this.f6363r);
        }
    }
}
