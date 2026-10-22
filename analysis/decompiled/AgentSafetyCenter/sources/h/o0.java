package h;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m.c1;
import m.v2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o0 implements m.d {

    /* renamed from: y, reason: collision with root package name */
    public static final AccelerateInterpolator f4860y = new AccelerateInterpolator();

    /* renamed from: z, reason: collision with root package name */
    public static final DecelerateInterpolator f4861z = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public Context f4862a;

    /* renamed from: b, reason: collision with root package name */
    public Context f4863b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f4864c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f4865d;

    /* renamed from: e, reason: collision with root package name */
    public c1 f4866e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f4867f;

    /* renamed from: g, reason: collision with root package name */
    public View f4868g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4869h;
    public n0 i;

    /* renamed from: j, reason: collision with root package name */
    public n0 f4870j;

    /* renamed from: k, reason: collision with root package name */
    public p5.l f4871k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4872l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f4873m;

    /* renamed from: n, reason: collision with root package name */
    public int f4874n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4875o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4876p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4877q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4878r;

    /* renamed from: s, reason: collision with root package name */
    public k.k f4879s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4880t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4881u;

    /* renamed from: v, reason: collision with root package name */
    public m0 f4882v;

    /* renamed from: w, reason: collision with root package name */
    public m0 f4883w;

    /* renamed from: x, reason: collision with root package name */
    public a1.g f4884x;

    public final void a(boolean z10) {
        n3.o0 o0VarI;
        n3.o0 o0VarI2;
        boolean z11 = this.f4877q;
        if (z10) {
            if (!z11) {
                this.f4877q = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4864c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                f(false);
            }
        } else if (z11) {
            this.f4877q = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4864c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            f(false);
        }
        boolean zIsLaidOut = this.f4865d.isLaidOut();
        c1 c1Var = this.f4866e;
        if (!zIsLaidOut) {
            if (z10) {
                ((v2) c1Var).f8097a.setVisibility(4);
                this.f4867f.setVisibility(0);
                return;
            } else {
                ((v2) c1Var).f8097a.setVisibility(0);
                this.f4867f.setVisibility(8);
                return;
            }
        }
        if (z10) {
            o0VarI = ((v2) c1Var).b(4, 100L);
            o0VarI2 = this.f4867f.i(0, 200L);
        } else {
            n3.o0 o0VarB = ((v2) c1Var).b(0, 200L);
            o0VarI = this.f4867f.i(8, 100L);
            o0VarI2 = o0VarB;
        }
        k.k kVar = new k.k();
        ArrayList arrayList = kVar.f6853a;
        arrayList.add(o0VarI);
        View view = (View) o0VarI.f8739a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) o0VarI2.f8739a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(o0VarI2);
        kVar.f();
    }

    public final Context b() {
        if (this.f4863b == null) {
            TypedValue typedValue = new TypedValue();
            this.f4862a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f4863b = new ContextThemeWrapper(this.f4862a, i);
            } else {
                this.f4863b = this.f4862a;
            }
        }
        return this.f4863b;
    }

    public final void c(View view) {
        c1 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.f4864c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(R.id.action_bar);
        if (callbackFindViewById instanceof c1) {
            wrapper = (c1) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.f4866e = wrapper;
        this.f4867f = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.f4865d = actionBarContainer;
        c1 c1Var = this.f4866e;
        if (c1Var == null || this.f4867f == null || actionBarContainer == null) {
            od.f.e(o0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
            return;
        }
        Context context = ((v2) c1Var).f8097a.getContext();
        this.f4862a = context;
        if ((((v2) this.f4866e).f8098b & 4) != 0) {
            this.f4869h = true;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        this.f4866e.getClass();
        e(context.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.f4862a.obtainStyledAttributes(null, g.a.f4098a, R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4864c;
            if (!actionBarOverlayLayout2.f776k) {
                od.f.e("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                return;
            } else {
                this.f4881u = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            }
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f4865d;
            WeakHashMap weakHashMap = n3.k0.f8724a;
            actionBarContainer2.setElevation(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void d(boolean z10) {
        if (this.f4869h) {
            return;
        }
        int i = z10 ? 4 : 0;
        v2 v2Var = (v2) this.f4866e;
        int i3 = v2Var.f8098b;
        this.f4869h = true;
        v2Var.a((i & 4) | (i3 & (-5)));
    }

    public final void e(boolean z10) {
        if (z10) {
            this.f4865d.setTabContainer(null);
            ((v2) this.f4866e).getClass();
        } else {
            ((v2) this.f4866e).getClass();
            this.f4865d.setTabContainer(null);
        }
        this.f4866e.getClass();
        ((v2) this.f4866e).f8097a.setCollapsible(false);
        this.f4864c.setHasNonEmbeddedTabs(false);
    }

    public final void f(boolean z10) {
        a1.g gVar = this.f4884x;
        View view = this.f4868g;
        boolean z11 = this.f4877q || !this.f4876p;
        boolean z12 = this.f4878r;
        if (!z11) {
            if (z12) {
                this.f4878r = false;
                m0 m0Var = this.f4882v;
                k.k kVar = this.f4879s;
                if (kVar != null) {
                    kVar.a();
                }
                if (this.f4874n != 0 || (!this.f4880t && !z10)) {
                    m0Var.d();
                    return;
                }
                this.f4865d.setAlpha(1.0f);
                this.f4865d.setTransitioning(true);
                k.k kVar2 = new k.k();
                float f5 = -this.f4865d.getHeight();
                if (z10) {
                    this.f4865d.getLocationInWindow(new int[]{0, 0});
                    f5 -= r11[1];
                }
                n3.o0 o0VarA = n3.k0.a(this.f4865d);
                o0VarA.h(f5);
                o0VarA.f(gVar);
                kVar2.b(o0VarA);
                if (this.f4875o && view != null) {
                    n3.o0 o0VarA2 = n3.k0.a(view);
                    o0VarA2.h(f5);
                    kVar2.b(o0VarA2);
                }
                kVar2.d(f4860y);
                kVar2.c(250L);
                kVar2.e(m0Var);
                this.f4879s = kVar2;
                kVar2.f();
                return;
            }
            return;
        }
        if (z12) {
            return;
        }
        this.f4878r = true;
        m0 m0Var2 = this.f4883w;
        k.k kVar3 = this.f4879s;
        if (kVar3 != null) {
            kVar3.a();
        }
        this.f4865d.setVisibility(0);
        if (this.f4874n == 0 && (this.f4880t || z10)) {
            this.f4865d.setTranslationY(0.0f);
            float f10 = -this.f4865d.getHeight();
            if (z10) {
                this.f4865d.getLocationInWindow(new int[]{0, 0});
                f10 -= r11[1];
            }
            this.f4865d.setTranslationY(f10);
            k.k kVar4 = new k.k();
            n3.o0 o0VarA3 = n3.k0.a(this.f4865d);
            o0VarA3.h(0.0f);
            o0VarA3.f(gVar);
            kVar4.b(o0VarA3);
            if (this.f4875o && view != null) {
                view.setTranslationY(f10);
                n3.o0 o0VarA4 = n3.k0.a(view);
                o0VarA4.h(0.0f);
                kVar4.b(o0VarA4);
            }
            kVar4.d(f4861z);
            kVar4.c(250L);
            kVar4.e(m0Var2);
            this.f4879s = kVar4;
            kVar4.f();
        } else {
            this.f4865d.setAlpha(1.0f);
            this.f4865d.setTranslationY(0.0f);
            if (this.f4875o && view != null) {
                view.setTranslationY(0.0f);
            }
            m0Var2.d();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f4864c;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = n3.k0.f8724a;
            actionBarOverlayLayout.requestApplyInsets();
        }
    }
}
