package androidx.appcompat.app;

import K.S;
import K.e0;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.InterfaceC0199f;
import androidx.appcompat.widget.InterfaceC0216n0;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.g1;
import com.stepos.alphame.utils.Property;
import d.C0527a;
import g.AbstractC0560a;
import j.InterfaceC0623b;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class N extends t0.J implements InterfaceC0199f {

    /* renamed from: b, reason: collision with root package name */
    public Context f2559b;

    /* renamed from: c, reason: collision with root package name */
    public Context f2560c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarOverlayLayout f2561d;

    /* renamed from: e, reason: collision with root package name */
    public ActionBarContainer f2562e;

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC0216n0 f2563f;

    /* renamed from: g, reason: collision with root package name */
    public ActionBarContextView f2564g;

    /* renamed from: h, reason: collision with root package name */
    public final View f2565h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2566i;

    /* renamed from: j, reason: collision with root package name */
    public M f2567j;

    /* renamed from: k, reason: collision with root package name */
    public M f2568k;

    /* renamed from: l, reason: collision with root package name */
    public InterfaceC0623b f2569l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2570m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f2571n;

    /* renamed from: o, reason: collision with root package name */
    public int f2572o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2573p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2574q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2575r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2576s;

    /* renamed from: t, reason: collision with root package name */
    public j.m f2577t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2578u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2579v;

    /* renamed from: w, reason: collision with root package name */
    public final L f2580w;

    /* renamed from: x, reason: collision with root package name */
    public final L f2581x;

    /* renamed from: y, reason: collision with root package name */
    public final C0527a f2582y;

    /* renamed from: z, reason: collision with root package name */
    public static final AccelerateInterpolator f2558z = new AccelerateInterpolator();

    /* renamed from: A, reason: collision with root package name */
    public static final DecelerateInterpolator f2557A = new DecelerateInterpolator();

    public N(Activity activity, boolean z4) {
        new ArrayList();
        this.f2571n = new ArrayList();
        this.f2572o = 0;
        this.f2573p = true;
        this.f2576s = true;
        this.f2580w = new L(this, 0);
        this.f2581x = new L(this, 1);
        this.f2582y = new C0527a(2, this);
        View decorView = activity.getWindow().getDecorView();
        e0(decorView);
        if (z4) {
            return;
        }
        this.f2565h = decorView.findViewById(R.id.content);
    }

    public final void d0(boolean z4) {
        e0 e0VarL;
        e0 e0VarL2;
        if (z4) {
            if (!this.f2575r) {
                this.f2575r = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2561d;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                h0(false);
            }
        } else if (this.f2575r) {
            this.f2575r = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2561d;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            h0(false);
        }
        if (!this.f2562e.isLaidOut()) {
            if (z4) {
                ((g1) this.f2563f).f3087a.setVisibility(4);
                this.f2564g.setVisibility(0);
                return;
            } else {
                ((g1) this.f2563f).f3087a.setVisibility(0);
                this.f2564g.setVisibility(8);
                return;
            }
        }
        if (z4) {
            e0VarL = ((g1) this.f2563f).b(4, 100L);
            e0VarL2 = this.f2564g.l(0, 200L);
        } else {
            e0 e0VarB = ((g1) this.f2563f).b(0, 200L);
            e0VarL = this.f2564g.l(8, 100L);
            e0VarL2 = e0VarB;
        }
        j.m mVar = new j.m();
        ArrayList arrayList = mVar.f13110a;
        arrayList.add(e0VarL);
        View view = (View) e0VarL.f959a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) e0VarL2.f959a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(e0VarL2);
        mVar.f();
    }

    public final void e0(View view) {
        InterfaceC0216n0 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.stepos.alphame.R.id.decor_content_parent);
        this.f2561d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(com.stepos.alphame.R.id.action_bar);
        if (callbackFindViewById instanceof InterfaceC0216n0) {
            wrapper = (InterfaceC0216n0) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.f2563f = wrapper;
        this.f2564g = (ActionBarContextView) view.findViewById(com.stepos.alphame.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.stepos.alphame.R.id.action_bar_container);
        this.f2562e = actionBarContainer;
        InterfaceC0216n0 interfaceC0216n0 = this.f2563f;
        if (interfaceC0216n0 == null || this.f2564g == null || actionBarContainer == null) {
            throw new IllegalStateException(N.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((g1) interfaceC0216n0).f3087a.getContext();
        this.f2559b = context;
        if ((((g1) this.f2563f).f3088b & 4) != 0) {
            this.f2566i = true;
        }
        if (context.getApplicationInfo().targetSdkVersion < 14) {
        }
        this.f2563f.getClass();
        if (context.getResources().getBoolean(com.stepos.alphame.R.bool.abc_action_bar_embed_tabs)) {
            this.f2562e.setTabContainer(null);
            ((g1) this.f2563f).getClass();
        } else {
            ((g1) this.f2563f).getClass();
            this.f2562e.setTabContainer(null);
        }
        this.f2563f.getClass();
        ((g1) this.f2563f).f3087a.setCollapsible(false);
        this.f2561d.setHasNonEmbeddedTabs(false);
        TypedArray typedArrayObtainStyledAttributes = this.f2559b.obtainStyledAttributes(null, AbstractC0560a.f12588a, com.stepos.alphame.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2561d;
            if (!actionBarOverlayLayout2.f2765g) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f2579v = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f2562e;
            WeakHashMap weakHashMap = S.f939a;
            K.J.s(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void f0(boolean z4) {
        if (this.f2566i) {
            return;
        }
        int i4 = z4 ? 4 : 0;
        g1 g1Var = (g1) this.f2563f;
        int i5 = g1Var.f3088b;
        this.f2566i = true;
        g1Var.a((i4 & 4) | (i5 & (-5)));
    }

    public final void g0(CharSequence charSequence) {
        g1 g1Var = (g1) this.f2563f;
        if (g1Var.f3093g) {
            return;
        }
        g1Var.f3094h = charSequence;
        if ((g1Var.f3088b & 8) != 0) {
            Toolbar toolbar = g1Var.f3087a;
            toolbar.setTitle(charSequence);
            if (g1Var.f3093g) {
                S.i(toolbar.getRootView(), charSequence);
            }
        }
    }

    public final void h0(boolean z4) {
        boolean z5 = this.f2575r || !this.f2574q;
        C0527a c0527a = this.f2582y;
        View view = this.f2565h;
        if (!z5) {
            if (this.f2576s) {
                this.f2576s = false;
                j.m mVar = this.f2577t;
                if (mVar != null) {
                    mVar.a();
                }
                int i4 = this.f2572o;
                L l4 = this.f2580w;
                if (i4 != 0 || (!this.f2578u && !z4)) {
                    l4.c(null);
                    return;
                }
                this.f2562e.setAlpha(1.0f);
                this.f2562e.setTransitioning(true);
                j.m mVar2 = new j.m();
                float f4 = -this.f2562e.getHeight();
                if (z4) {
                    this.f2562e.getLocationInWindow(new int[]{0, 0});
                    f4 -= r12[1];
                }
                e0 e0VarA = S.a(this.f2562e);
                e0VarA.h(f4);
                e0VarA.f(c0527a);
                mVar2.b(e0VarA);
                if (this.f2573p && view != null) {
                    e0 e0VarA2 = S.a(view);
                    e0VarA2.h(f4);
                    mVar2.b(e0VarA2);
                }
                mVar2.d(f2558z);
                mVar2.c(250L);
                mVar2.e(l4);
                this.f2577t = mVar2;
                mVar2.f();
                return;
            }
            return;
        }
        if (this.f2576s) {
            return;
        }
        this.f2576s = true;
        j.m mVar3 = this.f2577t;
        if (mVar3 != null) {
            mVar3.a();
        }
        this.f2562e.setVisibility(0);
        int i5 = this.f2572o;
        L l5 = this.f2581x;
        if (i5 == 0 && (this.f2578u || z4)) {
            this.f2562e.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
            float f5 = -this.f2562e.getHeight();
            if (z4) {
                this.f2562e.getLocationInWindow(new int[]{0, 0});
                f5 -= r12[1];
            }
            this.f2562e.setTranslationY(f5);
            j.m mVar4 = new j.m();
            e0 e0VarA3 = S.a(this.f2562e);
            e0VarA3.h(Property.DEFAULT_FLOAT_VALUE);
            e0VarA3.f(c0527a);
            mVar4.b(e0VarA3);
            if (this.f2573p && view != null) {
                view.setTranslationY(f5);
                e0 e0VarA4 = S.a(view);
                e0VarA4.h(Property.DEFAULT_FLOAT_VALUE);
                mVar4.b(e0VarA4);
            }
            mVar4.d(f2557A);
            mVar4.c(250L);
            mVar4.e(l5);
            this.f2577t = mVar4;
            mVar4.f();
        } else {
            this.f2562e.setAlpha(1.0f);
            this.f2562e.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
            if (this.f2573p && view != null) {
                view.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
            }
            l5.c(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2561d;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = S.f939a;
            K.H.c(actionBarOverlayLayout);
        }
    }

    public N(Dialog dialog) {
        new ArrayList();
        this.f2571n = new ArrayList();
        this.f2572o = 0;
        this.f2573p = true;
        this.f2576s = true;
        this.f2580w = new L(this, 0);
        this.f2581x = new L(this, 1);
        this.f2582y = new C0527a(2, this);
        e0(dialog.getWindow().getDecorView());
    }
}
