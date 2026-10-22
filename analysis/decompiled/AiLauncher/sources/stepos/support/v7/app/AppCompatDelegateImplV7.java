package stepos.support.v7.app;

import Ic.b;
import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.C1295h;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.core.view.A;
import androidx.core.view.N;
import androidx.core.view.O;
import androidx.core.view.U;
import androidx.core.view.W;
import androidx.core.view.a0;
import com.stepos.common.R$color;
import java.lang.reflect.InvocationTargetException;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.y;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class AppCompatDelegateImplV7 extends stepos.support.v7.app.g implements c.a {

    /* renamed from: A, reason: collision with root package name */
    public ViewGroup f40191A;

    /* renamed from: B, reason: collision with root package name */
    public TextView f40192B;

    /* renamed from: C, reason: collision with root package name */
    public View f40193C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f40194D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f40195E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f40196F;

    /* renamed from: G, reason: collision with root package name */
    public PanelFeatureState[] f40197G;

    /* renamed from: H, reason: collision with root package name */
    public PanelFeatureState f40198H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f40199I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f40200J;

    /* renamed from: K, reason: collision with root package name */
    public int f40201K;

    /* renamed from: L, reason: collision with root package name */
    public final Runnable f40202L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f40203M;

    /* renamed from: N, reason: collision with root package name */
    public Rect f40204N;

    /* renamed from: O, reason: collision with root package name */
    public Rect f40205O;

    /* renamed from: P, reason: collision with root package name */
    public final c.a f40206P;

    /* renamed from: Q, reason: collision with root package name */
    public View.OnClickListener f40207Q;

    /* renamed from: r, reason: collision with root package name */
    public stepos.support.v7.widget.j f40208r;

    /* renamed from: s, reason: collision with root package name */
    public h f40209s;

    /* renamed from: t, reason: collision with root package name */
    public k f40210t;

    /* renamed from: u, reason: collision with root package name */
    public Ic.b f40211u;

    /* renamed from: v, reason: collision with root package name */
    public ActionBarContextView f40212v;

    /* renamed from: w, reason: collision with root package name */
    public PopupWindow f40213w;

    /* renamed from: x, reason: collision with root package name */
    public Runnable f40214x;

    /* renamed from: y, reason: collision with root package name */
    public U f40215y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f40216z;

    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        public int f40217a;

        /* renamed from: b, reason: collision with root package name */
        public int f40218b;

        /* renamed from: c, reason: collision with root package name */
        public int f40219c;

        /* renamed from: d, reason: collision with root package name */
        public int f40220d;

        /* renamed from: e, reason: collision with root package name */
        public int f40221e;

        /* renamed from: f, reason: collision with root package name */
        public int f40222f;

        /* renamed from: g, reason: collision with root package name */
        public ViewGroup f40223g;

        /* renamed from: h, reason: collision with root package name */
        public View f40224h;

        /* renamed from: i, reason: collision with root package name */
        public View f40225i;

        /* renamed from: j, reason: collision with root package name */
        public stepos.support.v7.view.menu.c f40226j;

        /* renamed from: k, reason: collision with root package name */
        public stepos.support.v7.view.menu.b f40227k;

        /* renamed from: l, reason: collision with root package name */
        public Context f40228l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f40229m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f40230n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f40231o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f40232p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f40233q = false;

        /* renamed from: r, reason: collision with root package name */
        public boolean f40234r;

        /* renamed from: s, reason: collision with root package name */
        public Bundle f40235s;

        /* renamed from: t, reason: collision with root package name */
        public stepos.support.v7.view.menu.c f40236t;

        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = x0.j.a(new a());
            int featureId;
            boolean isOpen;
            Bundle menuState;

            public class a implements x0.k<SavedState> {
                @Override // x0.k
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.readFromParcel(parcel, classLoader);
                }

                @Override // x0.k
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            private SavedState() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.featureId = parcel.readInt();
                boolean z10 = parcel.readInt() == 1;
                savedState.isOpen = z10;
                if (z10) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }

            public /* synthetic */ SavedState(a aVar) {
                this();
            }
        }

        public PanelFeatureState(int i10) {
            this.f40217a = i10;
        }

        public stepos.support.v7.view.menu.h b(g.a aVar) {
            if (this.f40226j == null) {
                return null;
            }
            if (this.f40227k == null) {
                stepos.support.v7.view.menu.b bVar = new stepos.support.v7.view.menu.b(this.f40228l, R$layout.stepos_list_menu_item_layout);
                this.f40227k = bVar;
                bVar.k(aVar);
                this.f40226j.b(this.f40227k);
            }
            return this.f40227k.j(this.f40223g);
        }

        public boolean c() {
            if (this.f40224h == null) {
                return false;
            }
            return this.f40225i != null || this.f40227k.i().getCount() > 0;
        }

        public void d(stepos.support.v7.view.menu.c cVar) {
            if (cVar == this.f40236t) {
                return;
            }
            this.f40236t = cVar;
        }

        public void e(stepos.support.v7.view.menu.c cVar) {
            stepos.support.v7.view.menu.b bVar;
            stepos.support.v7.view.menu.c cVar2 = this.f40226j;
            if (cVar == cVar2) {
                return;
            }
            if (cVar2 != null) {
                cVar2.N(this.f40227k);
            }
            this.f40226j = cVar;
            if (cVar == null || (bVar = this.f40227k) == null) {
                return;
            }
            cVar.b(bVar);
        }

        public void f(Context context) {
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
            i.d dVar = new i.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f40228l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f40218b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f40222f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((AppCompatDelegateImplV7.this.f40201K & 1) != 0) {
                AppCompatDelegateImplV7.this.o0(0);
            }
            if ((AppCompatDelegateImplV7.this.f40201K & 4096) != 0) {
                AppCompatDelegateImplV7.this.o0(108);
            }
            AppCompatDelegateImplV7.this.f40200J = false;
            AppCompatDelegateImplV7.this.f40201K = 0;
        }
    }

    public class b implements c.a {
        public b() {
        }

        @Override // stepos.support.v7.view.menu.c.a
        public void a(stepos.support.v7.view.menu.c cVar) {
        }

        @Override // stepos.support.v7.view.menu.c.a
        public boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
            return AppCompatDelegateImplV7.this.z0(cVar, menuItem);
        }
    }

    public class c implements A {
        public c() {
        }

        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            int iM = a0Var.m();
            int iN0 = AppCompatDelegateImplV7.this.N0(iM);
            if (iM != iN0) {
                a0Var = a0Var.s(a0Var.k(), iN0, a0Var.l(), a0Var.j());
            }
            return N.U(view, a0Var);
        }
    }

    public class d implements ContentFrameLayout.a {
        public d() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImplV7.this.n0();
        }
    }

    public class e implements Runnable {

        public class a extends W {
            public a() {
            }

            @Override // androidx.core.view.W, androidx.core.view.V
            public void d(View view) {
                N.l0(AppCompatDelegateImplV7.this.f40212v, 1.0f);
                AppCompatDelegateImplV7.this.f40215y.h(null);
                AppCompatDelegateImplV7.this.f40215y = null;
            }

            @Override // androidx.core.view.W, androidx.core.view.V
            public void e(View view) {
                AppCompatDelegateImplV7.this.f40212v.setVisibility(0);
            }
        }

        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            appCompatDelegateImplV7.f40213w.showAtLocation(appCompatDelegateImplV7.f40212v, 55, 0, 0);
            AppCompatDelegateImplV7.this.p0();
            N.l0(AppCompatDelegateImplV7.this.f40212v, 0.0f);
            AppCompatDelegateImplV7 appCompatDelegateImplV72 = AppCompatDelegateImplV7.this;
            appCompatDelegateImplV72.f40215y = N.d(appCompatDelegateImplV72.f40212v).b(1.0f);
            AppCompatDelegateImplV7.this.f40215y.h(new a());
        }
    }

    public class f extends W {
        public f() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            N.l0(AppCompatDelegateImplV7.this.f40212v, 1.0f);
            AppCompatDelegateImplV7.this.f40215y.h(null);
            AppCompatDelegateImplV7.this.f40215y = null;
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void e(View view) {
            AppCompatDelegateImplV7.this.f40212v.setVisibility(0);
            AppCompatDelegateImplV7.this.f40212v.sendAccessibilityEvent(32);
            if (AppCompatDelegateImplV7.this.f40212v.getParent() != null) {
                N.e0((View) AppCompatDelegateImplV7.this.f40212v.getParent());
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (appCompatDelegateImplV7.f40501f == null || appCompatDelegateImplV7.N()) {
                return;
            }
            AppCompatDelegateImplV7.this.f40501f.onBackTopTouch();
        }
    }

    public final class h implements g.a {
        public h() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public void a(stepos.support.v7.view.menu.c cVar, boolean z10) {
            AppCompatDelegateImplV7.this.j0(cVar);
        }

        @Override // stepos.support.v7.view.menu.g.a
        public boolean b(stepos.support.v7.view.menu.c cVar) {
            Window.Callback callbackL = AppCompatDelegateImplV7.this.L();
            if (callbackL == null) {
                return true;
            }
            callbackL.onMenuOpened(108, cVar);
            return true;
        }

        public /* synthetic */ h(AppCompatDelegateImplV7 appCompatDelegateImplV7, a aVar) {
            this();
        }
    }

    public class i implements b.InterfaceC0060b {

        /* renamed from: a, reason: collision with root package name */
        public b.InterfaceC0060b f40246a;

        public class a extends W {
            public a() {
            }

            @Override // androidx.core.view.W, androidx.core.view.V
            public void d(View view) {
                AppCompatDelegateImplV7.this.f40212v.setVisibility(8);
                AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
                PopupWindow popupWindow = appCompatDelegateImplV7.f40213w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImplV7.f40212v.getParent() instanceof View) {
                    N.e0((View) AppCompatDelegateImplV7.this.f40212v.getParent());
                }
                AppCompatDelegateImplV7.this.f40212v.removeAllViews();
                AppCompatDelegateImplV7.this.f40215y.h(null);
                AppCompatDelegateImplV7.this.f40215y = null;
            }
        }

        public i(b.InterfaceC0060b interfaceC0060b) {
            this.f40246a = interfaceC0060b;
        }

        @Override // Ic.b.InterfaceC0060b
        public void a(Ic.b bVar) {
            this.f40246a.a(bVar);
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (appCompatDelegateImplV7.f40213w != null) {
                appCompatDelegateImplV7.f40498c.getDecorView().removeCallbacks(AppCompatDelegateImplV7.this.f40214x);
            }
            AppCompatDelegateImplV7 appCompatDelegateImplV72 = AppCompatDelegateImplV7.this;
            if (appCompatDelegateImplV72.f40212v != null) {
                appCompatDelegateImplV72.p0();
                AppCompatDelegateImplV7 appCompatDelegateImplV73 = AppCompatDelegateImplV7.this;
                appCompatDelegateImplV73.f40215y = N.d(appCompatDelegateImplV73.f40212v).b(0.0f);
                AppCompatDelegateImplV7.this.f40215y.h(new a());
            }
            AppCompatDelegateImplV7 appCompatDelegateImplV74 = AppCompatDelegateImplV7.this;
            stepos.support.v7.app.e eVar = appCompatDelegateImplV74.f40501f;
            if (eVar != null) {
                eVar.onSupportActionModeFinished(appCompatDelegateImplV74.f40211u);
            }
            AppCompatDelegateImplV7.this.f40211u = null;
        }

        @Override // Ic.b.InterfaceC0060b
        public boolean b(Ic.b bVar, Menu menu) {
            return this.f40246a.b(bVar, menu);
        }

        @Override // Ic.b.InterfaceC0060b
        public boolean c(Ic.b bVar, MenuItem menuItem) {
            return this.f40246a.c(bVar, menuItem);
        }

        @Override // Ic.b.InterfaceC0060b
        public boolean d(Ic.b bVar, Menu menu) {
            return this.f40246a.d(bVar, menu);
        }
    }

    public class j extends ContentFrameLayout {
        public j(Context context) {
            super(context);
        }

        private boolean a(int i10, int i11) {
            return i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV7.this.I(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImplV7.this.k0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(C1295h.b().c(getContext(), i10));
        }
    }

    public final class k implements g.a {
        public k() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public void a(stepos.support.v7.view.menu.c cVar, boolean z10) {
            stepos.support.v7.view.menu.c cVarD = cVar.D();
            boolean z11 = cVarD != cVar;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (z11) {
                cVar = cVarD;
            }
            PanelFeatureState panelFeatureStateR0 = appCompatDelegateImplV7.r0(cVar);
            if (panelFeatureStateR0 != null) {
                if (!z11) {
                    AppCompatDelegateImplV7.this.l0(panelFeatureStateR0, z10);
                } else {
                    AppCompatDelegateImplV7.this.i0(panelFeatureStateR0.f40217a, panelFeatureStateR0, cVarD);
                    AppCompatDelegateImplV7.this.l0(panelFeatureStateR0, true);
                }
            }
        }

        @Override // stepos.support.v7.view.menu.g.a
        public boolean b(stepos.support.v7.view.menu.c cVar) {
            Window.Callback callbackL;
            if (cVar != null) {
                return true;
            }
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (!appCompatDelegateImplV7.f40504i || (callbackL = appCompatDelegateImplV7.L()) == null || AppCompatDelegateImplV7.this.N()) {
                return true;
            }
            callbackL.onMenuOpened(108, cVar);
            return true;
        }

        public /* synthetic */ k(AppCompatDelegateImplV7 appCompatDelegateImplV7, a aVar) {
            this();
        }
    }

    public AppCompatDelegateImplV7(Context context, Window window, stepos.support.v7.app.e eVar) {
        super(context, window, eVar);
        this.f40215y = null;
        this.f40202L = new a();
        this.f40206P = new b();
        this.f40207Q = new g();
    }

    @Override // stepos.support.v7.app.f
    public void A(View view) {
        q0();
        ViewGroup viewGroup = (ViewGroup) this.f40191A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f40499d.onContentChanged();
    }

    public boolean A0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            this.f40199I = (keyEvent.getFlags() & 128) != 0;
        } else if (i10 == 82) {
            B0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // stepos.support.v7.app.f
    public void B(View view, ViewGroup.LayoutParams layoutParams) {
        q0();
        ViewGroup viewGroup = (ViewGroup) this.f40191A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f40499d.onContentChanged();
    }

    public final boolean B0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateS0 = s0(i10, true);
        if (panelFeatureStateS0.f40231o) {
            return false;
        }
        return I0(panelFeatureStateS0, keyEvent);
    }

    @Override // stepos.support.v7.app.f
    public void C(Toolbar toolbar) {
        if (this.f40499d instanceof Activity) {
            stepos.support.v7.app.a aVarL = l();
            if (aVarL instanceof t) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f40503h = null;
            if (aVarL != null) {
                aVarL.l();
            }
            if (toolbar != null) {
                r rVar = new r(toolbar, ((Activity) this.f40497b).getTitle(), this.f40500e);
                this.f40502g = rVar;
                this.f40498c.setCallback(rVar.H());
            } else {
                this.f40502g = null;
                this.f40498c.setCallback(this.f40500e);
            }
            o();
        }
    }

    public boolean C0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            boolean z10 = this.f40199I;
            this.f40199I = false;
            PanelFeatureState panelFeatureStateS0 = s0(0, false);
            if (panelFeatureStateS0 != null && panelFeatureStateS0.f40231o) {
                if (!z10) {
                    l0(panelFeatureStateS0, true);
                }
                return true;
            }
            if (y0()) {
                return true;
            }
        } else if (i10 == 82) {
            D0(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean D0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            Ic.b r0 = r4.f40211u
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            stepos.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState r2 = r4.s0(r5, r0)
            if (r5 != 0) goto L45
            stepos.support.v7.widget.j r5 = r4.f40208r
            if (r5 == 0) goto L45
            boolean r5 = r5.a()
            if (r5 == 0) goto L45
            android.content.Context r5 = r4.f40497b
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = androidx.core.view.O.e(r5)
            if (r5 != 0) goto L45
            stepos.support.v7.widget.j r5 = r4.f40208r
            boolean r5 = r5.d()
            if (r5 != 0) goto L3e
            boolean r5 = r4.N()
            if (r5 != 0) goto L64
            boolean r5 = r4.I0(r2, r6)
            if (r5 == 0) goto L64
            stepos.support.v7.widget.j r5 = r4.f40208r
            boolean r0 = r5.c()
            goto L6a
        L3e:
            stepos.support.v7.widget.j r5 = r4.f40208r
            boolean r0 = r5.b()
            goto L6a
        L45:
            boolean r5 = r2.f40231o
            if (r5 != 0) goto L66
            boolean r3 = r2.f40230n
            if (r3 == 0) goto L4e
            goto L66
        L4e:
            boolean r5 = r2.f40229m
            if (r5 == 0) goto L64
            boolean r5 = r2.f40234r
            if (r5 == 0) goto L5d
            r2.f40229m = r1
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
            android.content.Context r4 = r4.f40497b
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AppCompatDelegateImplV7.D0(int, android.view.KeyEvent):boolean");
    }

    public void E0(ViewGroup viewGroup) {
    }

    @Override // stepos.support.v7.app.f
    public void F() {
        stepos.support.v7.widget.j jVar = this.f40208r;
        if (jVar != null) {
            jVar.s();
        }
    }

    public final void F0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (panelFeatureState.f40231o || N()) {
            return;
        }
        if (panelFeatureState.f40217a == 0) {
            Context context = this.f40497b;
            boolean z10 = (context.getResources().getConfiguration().screenLayout & 15) == 4;
            boolean z11 = context.getApplicationInfo().targetSdkVersion >= 11;
            if (z10 && z11) {
                return;
            }
        }
        Window.Callback callbackL = L();
        if (callbackL != null && !callbackL.onMenuOpened(panelFeatureState.f40217a, panelFeatureState.f40226j)) {
            l0(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f40497b.getSystemService("window");
        if (windowManager != null && I0(panelFeatureState, keyEvent)) {
            ViewGroup viewGroup = panelFeatureState.f40223g;
            int i10 = -2;
            if (viewGroup == null || panelFeatureState.f40233q) {
                if (viewGroup == null) {
                    if (!v0(panelFeatureState) || panelFeatureState.f40223g == null) {
                        return;
                    }
                } else if (panelFeatureState.f40233q && viewGroup.getChildCount() > 0) {
                    panelFeatureState.f40223g.removeAllViews();
                }
                if (!u0(panelFeatureState) || !panelFeatureState.c()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = panelFeatureState.f40224h.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.f40223g.setBackgroundResource(panelFeatureState.f40218b);
                ViewParent parent = panelFeatureState.f40224h.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(panelFeatureState.f40224h);
                }
                panelFeatureState.f40223g.addView(panelFeatureState.f40224h, layoutParams);
                if (!panelFeatureState.f40224h.hasFocus()) {
                    panelFeatureState.f40224h.requestFocus();
                }
            } else {
                View view = panelFeatureState.f40225i;
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    if (layoutParams2 != null && layoutParams2.width == -1) {
                        i10 = -1;
                    }
                } else if (!panelFeatureState.c()) {
                    return;
                }
            }
            int i11 = i10;
            panelFeatureState.f40230n = false;
            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i11, -2, panelFeatureState.f40220d, panelFeatureState.f40221e, 1002, 8519680, -3);
            layoutParams3.gravity = panelFeatureState.f40219c;
            layoutParams3.windowAnimations = panelFeatureState.f40222f;
            windowManager.addView(panelFeatureState.f40223g, layoutParams3);
            panelFeatureState.f40231o = true;
        }
    }

    @Override // stepos.support.v7.app.f
    public Ic.b G(b.InterfaceC0060b interfaceC0060b) {
        if (interfaceC0060b == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        Ic.b bVar = this.f40211u;
        if (bVar != null) {
            bVar.c();
        }
        i iVar = new i(interfaceC0060b);
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null) {
            this.f40211u = aVarL.y(iVar);
        }
        return this.f40211u;
    }

    public final boolean G0(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent, int i11) {
        stepos.support.v7.view.menu.c cVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f40229m || I0(panelFeatureState, keyEvent)) && (cVar = panelFeatureState.f40226j) != null) {
            zPerformShortcut = cVar.performShortcut(i10, keyEvent, i11);
        }
        if (zPerformShortcut && (i11 & 1) == 0 && this.f40208r == null) {
            l0(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    @Override // stepos.support.v7.app.f
    public Ic.b H(b.InterfaceC0060b interfaceC0060b) {
        stepos.support.v7.app.e eVar;
        if (interfaceC0060b == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        Ic.b bVar = this.f40211u;
        if (bVar != null) {
            bVar.c();
        }
        i iVar = new i(interfaceC0060b);
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null) {
            Ic.b bVarX = aVarL.x(iVar);
            this.f40211u = bVarX;
            if (bVarX != null && (eVar = this.f40501f) != null) {
                eVar.onSupportActionModeStarted(bVarX);
            }
        }
        if (this.f40211u == null) {
            this.f40211u = L0(iVar);
        }
        return this.f40211u;
    }

    public final void H0(PanelFeatureState panelFeatureState) {
        if (t0(panelFeatureState)) {
            a aVar = null;
            if (this.f40208r != null) {
                if (this.f40209s == null) {
                    this.f40209s = new h(this, aVar);
                }
                this.f40208r.t(panelFeatureState.f40236t, this.f40209s);
            }
            panelFeatureState.f40236t.b0();
            if (this.f40501f.onCreateBottomMenu(panelFeatureState.f40236t)) {
                panelFeatureState.f40236t.a0();
                return;
            }
            panelFeatureState.d(null);
            stepos.support.v7.widget.j jVar = this.f40208r;
            if (jVar != null) {
                jVar.t(null, this.f40209s);
            }
        }
    }

    @Override // stepos.support.v7.app.g
    public boolean I(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.f40499d.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? A0(keyCode, keyEvent) : C0(keyCode, keyEvent);
    }

    public final boolean I0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        stepos.support.v7.widget.j jVar;
        int deviceId;
        stepos.support.v7.widget.j jVar2;
        stepos.support.v7.widget.j jVar3;
        if (N()) {
            return false;
        }
        if (panelFeatureState.f40229m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.f40198H;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            l0(panelFeatureState2, false);
        }
        Window.Callback callbackL = L();
        if (callbackL != null) {
            panelFeatureState.f40225i = callbackL.onCreatePanelView(panelFeatureState.f40217a);
        }
        int i10 = panelFeatureState.f40217a;
        boolean z10 = i10 == 0 || i10 == 108;
        if (z10 && (jVar3 = this.f40208r) != null) {
            jVar3.e();
        }
        if (panelFeatureState.f40225i == null && (!z10 || !(S() instanceof r))) {
            stepos.support.v7.view.menu.c cVar = panelFeatureState.f40226j;
            a aVar = null;
            if (cVar == null || panelFeatureState.f40234r) {
                if (cVar == null && (!w0(panelFeatureState) || panelFeatureState.f40226j == null)) {
                    return false;
                }
                if (z10 && this.f40208r != null) {
                    if (this.f40209s == null) {
                        this.f40209s = new h(this, aVar);
                    }
                    this.f40208r.q(panelFeatureState.f40226j, this.f40209s);
                }
                panelFeatureState.f40226j.b0();
                if (!callbackL.onCreatePanelMenu(panelFeatureState.f40217a, panelFeatureState.f40226j)) {
                    panelFeatureState.e(null);
                    if (z10 && (jVar = this.f40208r) != null) {
                        jVar.q(null, this.f40209s);
                    }
                    return false;
                }
                panelFeatureState.f40234r = false;
            }
            stepos.support.v7.app.e eVar = this.f40501f;
            if (eVar != null) {
                eVar.onOptionsMenuCreated(panelFeatureState.f40226j);
            }
            panelFeatureState.f40226j.b0();
            Bundle bundle = panelFeatureState.f40235s;
            if (bundle != null) {
                panelFeatureState.f40226j.O(bundle);
                panelFeatureState.f40235s = null;
            }
            if (!callbackL.onPreparePanel(0, panelFeatureState.f40225i, panelFeatureState.f40226j)) {
                if (z10 && (jVar2 = this.f40208r) != null) {
                    jVar2.q(null, this.f40209s);
                }
                panelFeatureState.f40226j.a0();
                return false;
            }
            if (keyEvent != null) {
                try {
                    deviceId = keyEvent.getDeviceId();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } else {
                deviceId = -1;
            }
            boolean z11 = KeyCharacterMap.load(deviceId).getKeyboardType() != 1;
            panelFeatureState.f40232p = z11;
            panelFeatureState.f40226j.setQwertyMode(z11);
            panelFeatureState.f40226j.a0();
            H0(panelFeatureState);
        }
        panelFeatureState.f40229m = true;
        panelFeatureState.f40230n = false;
        this.f40198H = panelFeatureState;
        return true;
    }

    public final void J0(stepos.support.v7.view.menu.c cVar, boolean z10) {
        stepos.support.v7.widget.j jVar = this.f40208r;
        if (jVar == null || !jVar.a() || (O.e(ViewConfiguration.get(this.f40497b)) && !this.f40208r.f())) {
            PanelFeatureState panelFeatureStateS0 = s0(0, true);
            panelFeatureStateS0.f40233q = true;
            l0(panelFeatureStateS0, false);
            F0(panelFeatureStateS0, null);
            return;
        }
        Window.Callback callbackL = L();
        if (this.f40208r.d() && z10) {
            this.f40208r.b();
            if (N()) {
                return;
            }
            callbackL.onPanelClosed(108, s0(0, true).f40226j);
            return;
        }
        if (callbackL == null || N()) {
            return;
        }
        if (this.f40200J && (this.f40201K & 1) != 0) {
            this.f40498c.getDecorView().removeCallbacks(this.f40202L);
            this.f40202L.run();
        }
        PanelFeatureState panelFeatureStateS02 = s0(0, true);
        stepos.support.v7.view.menu.c cVar2 = panelFeatureStateS02.f40226j;
        if (cVar2 == null || panelFeatureStateS02.f40234r || !callbackL.onPreparePanel(0, panelFeatureStateS02.f40225i, cVar2)) {
            return;
        }
        callbackL.onMenuOpened(108, panelFeatureStateS02.f40226j);
        this.f40208r.c();
    }

    public final int K0(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i10 != 9) {
            return i10;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    public Ic.b L0(b.InterfaceC0060b interfaceC0060b) {
        Ic.b bVarOnWindowStartingSupportActionMode;
        Context dVar;
        stepos.support.v7.app.e eVar;
        p0();
        Ic.b bVar = this.f40211u;
        if (bVar != null) {
            bVar.c();
        }
        i iVar = new i(interfaceC0060b);
        if (this.f40501f == null || N()) {
            bVarOnWindowStartingSupportActionMode = null;
        } else {
            try {
                bVarOnWindowStartingSupportActionMode = this.f40501f.onWindowStartingSupportActionMode(iVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (bVarOnWindowStartingSupportActionMode != null) {
            this.f40211u = bVarOnWindowStartingSupportActionMode;
        } else {
            if (this.f40212v == null) {
                if (this.f40507l) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f40497b.getTheme();
                    theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f40497b.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new i.d(this.f40497b, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f40497b;
                    }
                    this.f40212v = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, R$attr.actionModePopupWindowStyle);
                    this.f40213w = popupWindow;
                    androidx.core.widget.g.b(popupWindow, 2);
                    this.f40213w.setContentView(this.f40212v);
                    this.f40213w.setWidth(-1);
                    dVar.getTheme().resolveAttribute(O6.c.c() ? stepos.support.v7.appcompat.R$attr.steposActionBarSizeFullScreen : R$attr.actionBarSize, typedValue, true);
                    this.f40212v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.f40213w.setHeight(-2);
                    this.f40214x = new e();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f40191A.findViewById(R$id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(J()));
                        this.f40212v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f40212v != null) {
                p0();
                this.f40212v.s();
                Ic.i iVar2 = new Ic.i(this.f40212v.getContext(), this.f40212v, iVar, this.f40213w == null);
                if (interfaceC0060b.d(iVar2, iVar2.f())) {
                    iVar2.l();
                    this.f40212v.n(iVar2);
                    this.f40211u = iVar2;
                    N.l0(this.f40212v, 0.0f);
                    U uB = N.d(this.f40212v).b(1.0f);
                    this.f40215y = uB;
                    uB.h(new f());
                    if (this.f40213w != null) {
                        this.f40498c.getDecorView().post(this.f40214x);
                    }
                } else {
                    this.f40211u = null;
                }
            }
        }
        Ic.b bVar2 = this.f40211u;
        if (bVar2 != null && (eVar = this.f40501f) != null) {
            eVar.onSupportActionModeStarted(bVar2);
        }
        return this.f40211u;
    }

    @Override // stepos.support.v7.app.g
    public void M() {
        q0();
        if (this.f40504i && this.f40502g == null) {
            Window.Callback callback = this.f40499d;
            if (callback instanceof Activity) {
                if (this.f40509n) {
                    this.f40502g = new p((Activity) this.f40499d);
                } else {
                    this.f40502g = new t((Activity) this.f40499d, this.f40505j);
                }
            } else if (callback instanceof Dialog) {
                this.f40502g = new t((Dialog) this.f40499d);
            }
            stepos.support.v7.app.a aVar = this.f40502g;
            if (aVar != null) {
                aVar.o(this.f40203M);
            }
        }
    }

    public final void M0() {
        if (this.f40216z) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int N0(int i10) {
        boolean z10;
        boolean z11;
        ActionBarContextView actionBarContextView = this.f40212v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f40212v.getLayoutParams();
            if (this.f40212v.isShown()) {
                if (this.f40204N == null) {
                    this.f40204N = new Rect();
                    this.f40205O = new Rect();
                }
                Rect rect = this.f40204N;
                Rect rect2 = this.f40205O;
                rect.set(0, i10, 0, 0);
                y.i(this.f40191A, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i10 : 0)) {
                    marginLayoutParams.topMargin = i10;
                    View view = this.f40193C;
                    if (view == null) {
                        View view2 = new View(this.f40497b);
                        this.f40193C = view2;
                        view2.setBackgroundColor(this.f40497b.getResources().getColor(R$color.stepos_background_light));
                        this.f40191A.addView(this.f40193C, -1, new ViewGroup.LayoutParams(-1, i10));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i10) {
                            layoutParams.height = i10;
                            this.f40193C.setLayoutParams(layoutParams);
                        }
                    }
                    z11 = true;
                } else {
                    z11 = false;
                }
                z = this.f40193C != null;
                if (!this.f40506k && z) {
                    i10 = 0;
                }
                boolean z12 = z;
                z = z11;
                z10 = z12;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z = false;
            }
            if (z) {
                this.f40212v.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.f40193C;
        if (view3 != null) {
            view3.setVisibility(z10 ? 0 : 8);
        }
        return i10;
    }

    @Override // stepos.support.v7.app.g
    public boolean O(int i10, KeyEvent keyEvent) {
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null && aVarL.m(i10, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.f40198H;
        if (panelFeatureState != null && G0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.f40198H;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f40230n = true;
            }
            return true;
        }
        if (this.f40198H != null) {
            return false;
        }
        PanelFeatureState panelFeatureStateS0 = s0(0, true);
        I0(panelFeatureStateS0, keyEvent);
        boolean zG0 = G0(panelFeatureStateS0, keyEvent.getKeyCode(), keyEvent, 1);
        panelFeatureStateS0.f40229m = false;
        return zG0;
    }

    @Override // stepos.support.v7.app.g
    public boolean P(int i10, Menu menu) {
        if (i10 != 108) {
            return false;
        }
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null) {
            aVarL.g(true);
        }
        return true;
    }

    @Override // stepos.support.v7.app.g
    public void Q(int i10, Menu menu) {
        if (i10 == 108) {
            stepos.support.v7.app.a aVarL = l();
            if (aVarL != null) {
                aVarL.g(false);
                return;
            }
            return;
        }
        if (i10 == 0) {
            PanelFeatureState panelFeatureStateS0 = s0(i10, true);
            if (panelFeatureStateS0.f40231o) {
                l0(panelFeatureStateS0, false);
            }
        }
    }

    @Override // stepos.support.v7.app.g
    public void R(CharSequence charSequence) {
        stepos.support.v7.widget.j jVar = this.f40208r;
        if (jVar != null) {
            jVar.setWindowTitle(charSequence);
            return;
        }
        if (S() != null) {
            S().w(charSequence);
            return;
        }
        TextView textView = this.f40192B;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // stepos.support.v7.view.menu.c.a
    public void a(stepos.support.v7.view.menu.c cVar) {
        J0(cVar, true);
    }

    @Override // stepos.support.v7.view.menu.c.a
    public boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
        PanelFeatureState panelFeatureStateR0;
        Window.Callback callbackL = L();
        if (callbackL == null || N() || (panelFeatureStateR0 = r0(cVar.D())) == null) {
            return false;
        }
        boolean zOnMenuItemSelected = callbackL.onMenuItemSelected(panelFeatureStateR0.f40217a, menuItem);
        return (zOnMenuItemSelected || !(menuItem instanceof Jc.g)) ? zOnMenuItemSelected : this.f40501f.onMenuItemSelected(panelFeatureStateR0.f40217a, (Jc.g) menuItem);
    }

    @Override // stepos.support.v7.app.f
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        q0();
        ((ViewGroup) this.f40191A.findViewById(R.id.content)).addView(view, layoutParams);
        this.f40499d.onContentChanged();
    }

    @Override // stepos.support.v7.app.f
    public <T extends View> T h(int i10) {
        q0();
        return (T) this.f40498c.findViewById(i10);
    }

    public final void h0() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f40191A.findViewById(R.id.content);
        View decorView = this.f40498c.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f40497b.obtainStyledAttributes(R$styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i10 = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = R$styleable.AppCompatTheme_windowFixedWidthMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            typedArrayObtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = R$styleable.AppCompatTheme_windowFixedHeightMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            typedArrayObtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = R$styleable.AppCompatTheme_windowFixedHeightMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            typedArrayObtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final void i0(int i10, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.f40197G;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f40226j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f40231o) && !N()) {
            this.f40499d.onPanelClosed(i10, menu);
        }
    }

    public final void j0(stepos.support.v7.view.menu.c cVar) {
        if (this.f40196F) {
            return;
        }
        this.f40196F = true;
        this.f40208r.r();
        Window.Callback callbackL = L();
        if (callbackL != null && !N()) {
            callbackL.onPanelClosed(108, cVar);
        }
        this.f40196F = false;
    }

    public final void k0(int i10) {
        l0(s0(i10, true), true);
    }

    public final void l0(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        stepos.support.v7.widget.j jVar;
        if (z10 && panelFeatureState.f40217a == 0 && (jVar = this.f40208r) != null && jVar.d()) {
            j0(panelFeatureState.f40226j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f40497b.getSystemService("window");
        if (windowManager != null && panelFeatureState.f40231o && (viewGroup = panelFeatureState.f40223g) != null) {
            if (viewGroup.getParent() != null) {
                windowManager.removeView(panelFeatureState.f40223g);
            }
            if (z10) {
                i0(panelFeatureState.f40217a, panelFeatureState, null);
            }
        }
        panelFeatureState.f40229m = false;
        panelFeatureState.f40230n = false;
        panelFeatureState.f40231o = false;
        panelFeatureState.f40224h = null;
        panelFeatureState.f40233q = true;
        if (this.f40198H == panelFeatureState) {
            this.f40198H = null;
        }
    }

    @Override // stepos.support.v7.app.f
    public void m() {
        stepos.support.v7.widget.j jVar = this.f40208r;
        if (jVar != null) {
            jVar.u();
        }
    }

    public final ViewGroup m0() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f40497b.obtainStyledAttributes(R$styleable.AppCompatTheme);
        int i10 = R$styleable.AppCompatTheme_windowActionBar;
        if (!typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            w(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i10, false)) {
            w(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            w(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            w(10);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(stepos.support.v7.appcompat.R$styleable.AppCompatTheme_steposNestedScrollActionBar, false)) {
            w(1001);
        }
        this.f40507l = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f40498c.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f40497b);
        if (this.f40508m) {
            viewGroup = this.f40506k ? (ViewGroup) layoutInflaterFrom.inflate(R$layout.stepos_abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(R$layout.stepos_abc_screen_simple, (ViewGroup) null);
            N.u0(viewGroup, new c());
        } else if (this.f40507l) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.f40505j = false;
            this.f40504i = false;
        } else if (this.f40504i) {
            TypedValue typedValue = new TypedValue();
            this.f40497b.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            Context dVar = typedValue.resourceId != 0 ? new i.d(this.f40497b, typedValue.resourceId) : this.f40497b;
            if (this.f40509n) {
                TypedValue typedValue2 = new TypedValue();
                dVar.getTheme().resolveAttribute(stepos.support.v7.appcompat.R$attr.steposNestedScrollActionBarTheme, typedValue2, true);
                if (typedValue2.resourceId != 0) {
                    dVar = new i.d(dVar, typedValue2.resourceId);
                }
                viewGroup = (ViewGroup) LayoutInflater.from(dVar).inflate(R$layout.stepos_nested_scroll_toolbar, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) LayoutInflater.from(dVar).inflate(O6.c.c() ? R$layout.stepos_abc_screen_toolbar_full_screen : R$layout.stepos_abc_screen_toolbar, (ViewGroup) null);
            }
            stepos.support.v7.widget.j jVar = (stepos.support.v7.widget.j) viewGroup.findViewById(R$id.decor_content_parent);
            this.f40208r = jVar;
            jVar.setWindowCallback(L());
            if (this.f40505j) {
                this.f40208r.g(109);
            }
            if (this.f40194D) {
                this.f40208r.g(2);
            }
            if (this.f40195E) {
                this.f40208r.g(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f40504i + ", windowActionBarOverlay: " + this.f40505j + ", android:windowIsFloating: " + this.f40507l + ", windowActionModeOverlay: " + this.f40506k + ", windowNoTitle: " + this.f40508m + " }");
        }
        if (this.f40208r == null) {
            this.f40192B = (TextView) viewGroup.findViewById(R$id.title);
        }
        y.n(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f40498c.findViewById(R.id.content);
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
        this.f40498c.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new d());
        return viewGroup;
    }

    @Override // stepos.support.v7.app.f
    public void n() {
    }

    public final void n0() {
        stepos.support.v7.view.menu.c cVar;
        stepos.support.v7.widget.j jVar = this.f40208r;
        if (jVar != null) {
            jVar.r();
        }
        if (this.f40213w != null) {
            this.f40498c.getDecorView().removeCallbacks(this.f40214x);
            if (this.f40213w.isShowing()) {
                try {
                    this.f40213w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f40213w = null;
        }
        p0();
        PanelFeatureState panelFeatureStateS0 = s0(0, false);
        if (panelFeatureStateS0 == null || (cVar = panelFeatureStateS0.f40226j) == null) {
            return;
        }
        cVar.close();
    }

    @Override // stepos.support.v7.app.f
    public void o() {
        stepos.support.v7.app.a aVarL = l();
        if (aVarL == null || !aVarL.j()) {
            x0(0);
        }
    }

    public final void o0(int i10) {
        PanelFeatureState panelFeatureStateS0;
        PanelFeatureState panelFeatureStateS02 = s0(i10, true);
        if (panelFeatureStateS02.f40226j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateS02.f40226j.P(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateS02.f40235s = bundle;
            }
            panelFeatureStateS02.f40226j.b0();
            panelFeatureStateS02.f40226j.clear();
        }
        panelFeatureStateS02.f40234r = true;
        panelFeatureStateS02.f40233q = true;
        if ((i10 != 108 && i10 != 0) || this.f40208r == null || (panelFeatureStateS0 = s0(0, false)) == null) {
            return;
        }
        panelFeatureStateS0.f40229m = false;
        I0(panelFeatureStateS0, null);
    }

    @Override // stepos.support.v7.app.f
    public void p(Configuration configuration) {
        stepos.support.v7.app.a aVarL;
        if (this.f40504i && this.f40216z && (aVarL = l()) != null) {
            aVarL.k(configuration);
        }
        d();
    }

    public final void p0() {
        U u10 = this.f40215y;
        if (u10 != null) {
            u10.c();
        }
    }

    @Override // stepos.support.v7.app.f
    public void q(Bundle bundle) {
        y.l();
        Window.Callback callback = this.f40499d;
        if (callback instanceof Activity) {
            if (androidx.core.app.h.c((Activity) callback) != null) {
                stepos.support.v7.app.a aVarS = S();
                if (aVarS == null) {
                    this.f40203M = true;
                } else {
                    aVarS.o(true);
                }
            }
            this.f40498c.getDecorView().getSystemUiVisibility();
            this.f40498c.setDecorFitsSystemWindows(false);
        }
    }

    public final void q0() {
        if (this.f40216z) {
            return;
        }
        this.f40191A = m0();
        CharSequence charSequenceK = K();
        if (!TextUtils.isEmpty(charSequenceK)) {
            R(charSequenceK);
        }
        h0();
        E0(this.f40191A);
        this.f40216z = true;
        PanelFeatureState panelFeatureStateS0 = s0(0, false);
        if (!N() && (panelFeatureStateS0 == null || panelFeatureStateS0.f40226j == null)) {
            x0(108);
        }
        if (l() != null) {
            l().v(this.f40512q);
        }
    }

    @Override // stepos.support.v7.app.g, stepos.support.v7.app.f
    public void r() {
        super.r();
        stepos.support.v7.app.a aVar = this.f40502g;
        if (aVar != null) {
            aVar.l();
        }
    }

    public final PanelFeatureState r0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f40197G;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i10 = 0; i10 < length; i10++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
            if (panelFeatureState != null && panelFeatureState.f40226j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // stepos.support.v7.app.f
    public void s(Bundle bundle) {
        q0();
    }

    public final PanelFeatureState s0(int i10, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.f40197G;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i10 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f40197G = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i10);
        panelFeatureStateArr[i10] = panelFeatureState2;
        return panelFeatureState2;
    }

    @Override // stepos.support.v7.app.f
    public void t() {
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null) {
            aVarL.t(true);
        }
    }

    public final boolean t0(PanelFeatureState panelFeatureState) {
        stepos.support.v7.view.menu.c cVar = new stepos.support.v7.view.menu.c(this.f40497b);
        cVar.Q(this.f40206P);
        panelFeatureState.d(cVar);
        return true;
    }

    public final boolean u0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f40225i;
        if (view != null) {
            panelFeatureState.f40224h = view;
            return true;
        }
        if (panelFeatureState.f40226j == null) {
            return false;
        }
        if (this.f40210t == null) {
            this.f40210t = new k(this, null);
        }
        View view2 = (View) panelFeatureState.b(this.f40210t);
        panelFeatureState.f40224h = view2;
        return view2 != null;
    }

    @Override // stepos.support.v7.app.f
    public void v() {
        stepos.support.v7.app.a aVarL = l();
        if (aVarL != null) {
            aVarL.t(false);
        }
    }

    public final boolean v0(PanelFeatureState panelFeatureState) {
        panelFeatureState.f(J());
        panelFeatureState.f40223g = new j(panelFeatureState.f40228l);
        panelFeatureState.f40219c = 81;
        return true;
    }

    @Override // stepos.support.v7.app.f
    public boolean w(int i10) {
        int iK0 = K0(i10);
        if (this.f40508m && iK0 == 108) {
            return false;
        }
        if (this.f40504i && iK0 == 1) {
            this.f40504i = false;
        }
        if (iK0 == 1) {
            M0();
            this.f40508m = true;
            return true;
        }
        if (iK0 == 2) {
            M0();
            this.f40194D = true;
            return true;
        }
        if (iK0 == 5) {
            M0();
            this.f40195E = true;
            return true;
        }
        if (iK0 == 10) {
            M0();
            this.f40506k = true;
            return true;
        }
        if (iK0 == 1001) {
            M0();
            this.f40509n = true;
            return true;
        }
        if (iK0 == 108) {
            M0();
            this.f40504i = true;
            return true;
        }
        if (iK0 != 109) {
            return this.f40498c.requestFeature(iK0);
        }
        M0();
        this.f40505j = true;
        return true;
    }

    public final boolean w0(PanelFeatureState panelFeatureState) {
        Resources.Theme themeNewTheme;
        Context context = this.f40497b;
        int i10 = panelFeatureState.f40217a;
        if ((i10 == 0 || i10 == 108) && this.f40208r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
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
                i.d dVar = new i.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        stepos.support.v7.view.menu.c cVar = new stepos.support.v7.view.menu.c(context);
        cVar.Q(this);
        panelFeatureState.e(cVar);
        return true;
    }

    @Override // stepos.support.v7.app.f
    public void x(Drawable drawable) {
        stepos.support.v7.widget.j jVar = this.f40208r;
        if (jVar != null) {
            jVar.setBackTopBackground(drawable);
        }
    }

    public final void x0(int i10) {
        this.f40201K = (1 << i10) | this.f40201K;
        if (this.f40200J) {
            return;
        }
        N.Z(this.f40498c.getDecorView(), this.f40202L);
        this.f40200J = true;
    }

    @Override // stepos.support.v7.app.f
    public void y(boolean z10) {
        stepos.support.v7.widget.j jVar = this.f40208r;
        if (jVar != null) {
            jVar.setBackTopEnable(z10);
            this.f40208r.setBackTopClickCallback(z10 ? this.f40207Q : null);
        }
    }

    public boolean y0() {
        Ic.b bVar = this.f40211u;
        if (bVar == null) {
            stepos.support.v7.app.a aVarL = l();
            return aVarL != null && aVarL.f();
        }
        b.a aVarD = bVar.d();
        if (aVarD == null || !aVarD.onBackPressed()) {
            return false;
        }
        this.f40211u.c();
        return true;
    }

    @Override // stepos.support.v7.app.f
    public void z(int i10) {
        q0();
        ViewGroup viewGroup = (ViewGroup) this.f40191A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f40497b).inflate(i10, viewGroup);
        this.f40499d.onContentChanged();
    }

    public final boolean z0(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
        if (this.f40501f == null || N() || !(menuItem instanceof Jc.g)) {
            return false;
        }
        return this.f40501f.onBottomItemSelected((Jc.g) menuItem);
    }
}
