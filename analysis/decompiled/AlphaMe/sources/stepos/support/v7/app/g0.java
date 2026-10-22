package stepos.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.stepos.alphame.utils.Property;
import g.AbstractC0560a;
import j.C0622a;
import java.util.ArrayList;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarOverlayLayout;
import stepos.support.v7.widget.FitsWindowsContentLayout;
import stepos.support.v7.widget.InterfaceC0889i;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes2.dex */
public final class g0 extends AbstractC0860e implements InterfaceC0889i {

    /* renamed from: E, reason: collision with root package name */
    public static final boolean f14475E;

    /* renamed from: A, reason: collision with root package name */
    public final e0 f14476A;

    /* renamed from: B, reason: collision with root package name */
    public final e0 f14477B;

    /* renamed from: C, reason: collision with root package name */
    public final f0 f14478C;

    /* renamed from: D, reason: collision with root package name */
    public final int f14479D;

    /* renamed from: a, reason: collision with root package name */
    public Context f14480a;

    /* renamed from: b, reason: collision with root package name */
    public Context f14481b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f14482c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f14483d;

    /* renamed from: e, reason: collision with root package name */
    public stepos.support.v7.widget.D f14484e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f14485f;

    /* renamed from: g, reason: collision with root package name */
    public ActionBarContainer f14486g;

    /* renamed from: h, reason: collision with root package name */
    public final FitsWindowsContentLayout f14487h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14488i;

    /* renamed from: j, reason: collision with root package name */
    public L f14489j;

    /* renamed from: k, reason: collision with root package name */
    public L f14490k;

    /* renamed from: l, reason: collision with root package name */
    public K3.b f14491l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14492m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f14493n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f14494o;

    /* renamed from: p, reason: collision with root package name */
    public int f14495p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14496q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f14497r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f14498s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f14499t;

    /* renamed from: u, reason: collision with root package name */
    public j.m f14500u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f14501v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f14502w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f14503x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f14504y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f14505z;

    static {
        new AccelerateInterpolator();
        new DecelerateInterpolator();
        f14475E = true;
    }

    public g0(Activity activity, boolean z4) {
        new ArrayList();
        this.f14493n = new ArrayList();
        this.f14495p = 0;
        this.f14496q = true;
        this.f14499t = true;
        this.f14504y = true;
        this.f14476A = new e0(this, 2);
        this.f14477B = new e0(this, 3);
        this.f14478C = new f0(this);
        this.f14479D = 288;
        View decorView = activity.getWindow().getDecorView();
        x(decorView);
        if (z4) {
            return;
        }
        this.f14487h = (FitsWindowsContentLayout) decorView.findViewById(R.id.content);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final boolean a() {
        stepos.support.v7.widget.D d4 = this.f14484e;
        if (d4 == null || !d4.r()) {
            return false;
        }
        this.f14484e.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void b(boolean z4) {
        if (z4 == this.f14492m) {
            return;
        }
        this.f14492m = z4;
        ArrayList arrayList = this.f14493n;
        if (arrayList.size() <= 0) {
            return;
        }
        B0.g.y(arrayList.get(0));
        throw null;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final int c() {
        return this.f14484e.w();
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final Context d() {
        if (this.f14481b == null) {
            TypedValue typedValue = new TypedValue();
            this.f14480a.getTheme().resolveAttribute(com.stepos.alphame.R.attr.actionBarWidgetTheme, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                this.f14481b = new ContextThemeWrapper(this.f14480a, i4);
            } else {
                this.f14481b = this.f14480a;
            }
        }
        return this.f14481b;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final stepos.support.v7.widget.D e() {
        return this.f14484e;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void g() {
        y((this.f14504y && C0622a.c(this.f14480a).g()) || this.f14503x);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void j(Drawable drawable) {
        this.f14483d.setPrimaryBackground(drawable);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void k(boolean z4) {
        if (this.f14488i) {
            return;
        }
        l(z4);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void l(boolean z4) {
        int i4 = z4 ? 4 : 0;
        int iW = this.f14484e.w();
        this.f14488i = true;
        this.f14484e.t((i4 & 4) | (iW & (-5)));
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void m() {
        this.f14484e.t(this.f14484e.w() & (-3));
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void n() {
        this.f14484e.m();
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void o(boolean z4) {
        this.f14484e.o(z4);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void p(boolean z4) {
        j.m mVar;
        this.f14501v = z4;
        if (z4 || (mVar = this.f14500u) == null) {
            return;
        }
        mVar.a();
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void q(int i4) {
        r(this.f14480a.getString(i4));
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void r(CharSequence charSequence) {
        this.f14484e.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void s(int i4) {
        this.f14482c.setUiOptions(i4);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void t(CharSequence charSequence) {
        this.f14484e.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final K3.c u(B0.e eVar) {
        L l4 = this.f14489j;
        if (l4 != null) {
            l4.a();
        }
        this.f14482c.setHideOnContentScrollEnabled(false);
        this.f14485f.j();
        L l5 = new L(this, this.f14485f.getContext(), eVar);
        if (!l5.q()) {
            return null;
        }
        l5.i();
        this.f14485f.g(l5);
        w(true, null);
        ActionBarContainer actionBarContainer = this.f14486g;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f14486g.setVisibility(0);
            ActionBarOverlayLayout actionBarOverlayLayout = this.f14482c;
            if (actionBarOverlayLayout != null) {
                WeakHashMap weakHashMap = K.S.f939a;
                K.H.c(actionBarOverlayLayout);
            }
        }
        this.f14485f.sendAccessibilityEvent(32);
        this.f14489j = l5;
        return l5;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final K3.c v(B0.e eVar) {
        L l4 = this.f14489j;
        if (l4 != null) {
            l4.a();
        }
        this.f14482c.setHideOnContentScrollEnabled(false);
        this.f14485f.j();
        L l5 = new L(this, this.f14485f.getContext(), eVar);
        if (!l5.q()) {
            return null;
        }
        l5.i();
        this.f14485f.setSplitView(this.f14486g);
        this.f14485f.h(l5);
        w(true, l5);
        ActionBarContainer actionBarContainer = this.f14486g;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f14486g.setVisibility(0);
            ActionBarOverlayLayout actionBarOverlayLayout = this.f14482c;
            if (actionBarOverlayLayout != null) {
                WeakHashMap weakHashMap = K.S.f939a;
                K.H.c(actionBarOverlayLayout);
            }
        }
        this.f14485f.sendAccessibilityEvent(32);
        this.f14489j = l5;
        return l5;
    }

    public final void w(boolean z4, L l4) {
        boolean z5;
        if (l4 != null) {
            switch (l4.f14292d) {
                case 0:
                    z5 = l4.f14298j;
                    break;
                default:
                    z5 = l4.f14298j;
                    break;
            }
        } else {
            z5 = z4;
        }
        if (z5) {
            if (!this.f14498s) {
                this.f14498s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f14482c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                z(false);
            }
        } else if (this.f14498s) {
            this.f14498s = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f14482c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            z(false);
        }
        (z4 ? this.f14484e.z(4, 100L) : this.f14484e.z(0, 200L)).g();
        this.f14485f.f(z4);
    }

    public final void x(View view) {
        stepos.support.v7.widget.D wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.stepos.alphame.R.id.decor_content_parent);
        this.f14482c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        Object objFindViewById = view.findViewById(com.stepos.alphame.R.id.action_bar);
        if (objFindViewById instanceof stepos.support.v7.widget.D) {
            wrapper = (stepos.support.v7.widget.D) objFindViewById;
        } else {
            if (!(objFindViewById instanceof Toolbar)) {
                StringBuilder sb = new StringBuilder("Can't make a decor toolbar out of ");
                sb.append(objFindViewById);
                throw new IllegalStateException(sb.toString() != null ? objFindViewById.getClass().getSimpleName() : "null");
            }
            wrapper = ((Toolbar) objFindViewById).getWrapper();
        }
        this.f14484e = wrapper;
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.stepos.alphame.R.id.action_bar_container);
        this.f14483d = actionBarContainer;
        this.f14485f = (ActionBarContextView) actionBarContainer.findViewById(com.stepos.alphame.R.id.action_context_bar);
        this.f14486g = (ActionBarContainer) view.findViewById(com.stepos.alphame.R.id.split_action_bar);
        stepos.support.v7.widget.D d4 = this.f14484e;
        if (d4 == null || this.f14485f == null || this.f14483d == null) {
            throw new IllegalStateException(g0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        d4.s(new f0(this));
        this.f14480a = this.f14484e.getContext();
        int iW = this.f14484e.w();
        boolean z4 = true;
        boolean z5 = (iW & 4) != 0;
        if (z5) {
            this.f14488i = true;
        }
        C0622a c0622aC = C0622a.c(this.f14480a);
        o(c0622aC.b() || z5);
        this.f14503x = (iW & 32) != 0;
        y((this.f14504y && c0622aC.g()) || this.f14503x);
        TypedArray typedArrayObtainStyledAttributes = this.f14480a.obtainStyledAttributes(null, AbstractC0560a.f12588a, com.stepos.alphame.R.attr.steposActionBarStyleFullScreen, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f14482c;
            if (!actionBarOverlayLayout2.f14778j) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f14502w = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            float f4 = dimensionPixelSize;
            ActionBarContainer actionBarContainer2 = this.f14483d;
            WeakHashMap weakHashMap = K.S.f939a;
            K.J.s(actionBarContainer2, f4);
            ActionBarContainer actionBarContainer3 = this.f14486g;
            if (actionBarContainer3 != null) {
                K.J.s(actionBarContainer3, f4);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        int height = this.f14483d.getHeight();
        if (!this.f14499t || (height != 0 && this.f14482c.getActionBarHideOffset() >= height)) {
            z4 = false;
        }
        this.f14505z = z4;
    }

    public final void y(boolean z4) {
        this.f14494o = z4;
        if (z4) {
            this.f14483d.setTabContainer(null);
            this.f14484e.v();
        } else {
            this.f14484e.v();
            this.f14483d.setTabContainer(null);
        }
        this.f14484e.getClass();
        if (this.f14494o) {
            this.f14484e.getClass();
        } else {
            this.f14483d.getTabContainer();
        }
        this.f14484e.F(false);
        this.f14482c.setHasNonEmbeddedTabs(false);
    }

    public final void z(boolean z4) {
        boolean z5 = this.f14498s ? true : !this.f14497r;
        int i4 = this.f14479D;
        FitsWindowsContentLayout fitsWindowsContentLayout = this.f14487h;
        f0 f0Var = this.f14478C;
        boolean z6 = f14475E;
        if (!z5) {
            if (this.f14499t) {
                this.f14499t = false;
                j.m mVar = this.f14500u;
                if (mVar != null) {
                    mVar.a();
                }
                int i5 = this.f14495p;
                e0 e0Var = this.f14476A;
                if (i5 != 0 || !z6 || (!this.f14501v && !z4)) {
                    e0Var.c(null);
                    return;
                }
                ActionBarContainer actionBarContainer = this.f14483d;
                WeakHashMap weakHashMap = K.S.f939a;
                actionBarContainer.setAlpha(1.0f);
                this.f14483d.setTransitioning(true);
                j.m mVar2 = new j.m();
                float f4 = -this.f14483d.getHeight();
                if (z4) {
                    this.f14483d.getLocationInWindow(new int[]{0, 0});
                    f4 -= r13[1];
                }
                K.e0 e0VarA = K.S.a(this.f14483d);
                e0VarA.h(f4);
                e0VarA.f(f0Var);
                mVar2.b(e0VarA);
                if (this.f14496q && fitsWindowsContentLayout != null) {
                    K.e0 e0VarA2 = K.S.a(fitsWindowsContentLayout);
                    e0VarA2.h(f4);
                    mVar2.b(e0VarA2);
                }
                ActionBarContainer actionBarContainer2 = this.f14486g;
                if (actionBarContainer2 != null && actionBarContainer2.getVisibility() == 0 && this.f14505z) {
                    this.f14486g.setAlpha(1.0f);
                    K.e0 e0VarA3 = K.S.a(this.f14486g);
                    e0VarA3.h(this.f14486g.getHeight());
                    mVar2.b(e0VarA3);
                }
                mVar2.d(M.a.b(0.29f, 0.5f, 0.16f, 1.0f));
                mVar2.c(i4);
                mVar2.e(e0Var);
                this.f14500u = mVar2;
                mVar2.f();
                return;
            }
            return;
        }
        if (this.f14499t) {
            return;
        }
        this.f14499t = true;
        j.m mVar3 = this.f14500u;
        if (mVar3 != null) {
            mVar3.a();
        }
        this.f14483d.setVisibility(0);
        int i6 = this.f14495p;
        e0 e0Var2 = this.f14477B;
        if (i6 == 0 && z6 && (this.f14501v || z4)) {
            ActionBarContainer actionBarContainer3 = this.f14483d;
            WeakHashMap weakHashMap2 = K.S.f939a;
            actionBarContainer3.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
            float f5 = -this.f14483d.getHeight();
            if (z4) {
                this.f14483d.getLocationInWindow(new int[]{0, 0});
                f5 -= r13[1];
            }
            this.f14483d.setTranslationY(f5);
            j.m mVar4 = new j.m();
            K.e0 e0VarA4 = K.S.a(this.f14483d);
            e0VarA4.h(Property.DEFAULT_FLOAT_VALUE);
            e0VarA4.f(f0Var);
            mVar4.b(e0VarA4);
            if (this.f14496q && fitsWindowsContentLayout != null) {
                fitsWindowsContentLayout.setTranslationY(f5);
                K.e0 e0VarA5 = K.S.a(fitsWindowsContentLayout);
                e0VarA5.h(Property.DEFAULT_FLOAT_VALUE);
                mVar4.b(e0VarA5);
            }
            ActionBarContainer actionBarContainer4 = this.f14486g;
            if (actionBarContainer4 != null && !this.f14505z) {
                actionBarContainer4.setVisibility(0);
                this.f14486g.setTranslationY(r0.getMeasuredHeight());
                K.e0 e0VarA6 = K.S.a(this.f14486g);
                e0VarA6.h(Property.DEFAULT_FLOAT_VALUE);
                mVar4.b(e0VarA6);
            }
            mVar4.d(M.a.b(0.2f, 0.5f, 0.05f, 1.0f));
            mVar4.c(i4);
            mVar4.e(e0Var2);
            this.f14500u = mVar4;
            mVar4.f();
        } else {
            ActionBarContainer actionBarContainer5 = this.f14483d;
            WeakHashMap weakHashMap3 = K.S.f939a;
            actionBarContainer5.setAlpha(1.0f);
            this.f14483d.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
            if (this.f14496q && fitsWindowsContentLayout != null) {
                fitsWindowsContentLayout.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
            }
            ActionBarContainer actionBarContainer6 = this.f14486g;
            if (actionBarContainer6 != null) {
                actionBarContainer6.setAlpha(1.0f);
                this.f14486g.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                this.f14486g.setVisibility(0);
            }
            e0Var2.c(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f14482c;
        if (actionBarOverlayLayout != null) {
            K.H.c(actionBarOverlayLayout);
        }
    }

    public g0(Dialog dialog) {
        new ArrayList();
        this.f14493n = new ArrayList();
        this.f14495p = 0;
        this.f14496q = true;
        this.f14499t = true;
        this.f14504y = true;
        this.f14476A = new e0(this, 2);
        this.f14477B = new e0(this, 3);
        this.f14478C = new f0(this);
        this.f14479D = 288;
        x(dialog.getWindow().getDecorView());
    }
}
