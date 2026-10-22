package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import stepos.support.v7.view.menu.ActionMenuItemView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class q implements te.v {
    public int A;
    public Drawable B;
    public View D;
    public l E;
    public l F;
    public com.stepos.statsrpk.service.d G;
    public m H;
    public final p I;
    public boolean J;

    /* renamed from: c, reason: collision with root package name */
    public final Context f12801c;

    /* renamed from: f, reason: collision with root package name */
    public Context f12802f;

    /* renamed from: g, reason: collision with root package name */
    public te.l f12803g;

    /* renamed from: h, reason: collision with root package name */
    public final LayoutInflater f12804h;
    public te.u i;

    /* renamed from: l, reason: collision with root package name */
    public te.x f12807l;

    /* renamed from: m, reason: collision with root package name */
    public o f12808m;

    /* renamed from: n, reason: collision with root package name */
    public TouchDelegate f12809n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f12810o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12811p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12812q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12813r;

    /* renamed from: s, reason: collision with root package name */
    public int f12814s;

    /* renamed from: t, reason: collision with root package name */
    public int f12815t;

    /* renamed from: u, reason: collision with root package name */
    public int f12816u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12817v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f12818w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12819x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12820y;

    /* renamed from: z, reason: collision with root package name */
    public int f12821z;

    /* renamed from: j, reason: collision with root package name */
    public final int f12805j = R.layout.stepos_abc_action_menu_layout;

    /* renamed from: k, reason: collision with root package name */
    public int f12806k = R.layout.stepos_action_menu_item_layout;
    public final SparseBooleanArray C = new SparseBooleanArray();

    public q(Context context) {
        this.f12801c = context;
        this.f12804h = LayoutInflater.from(context);
        p pVar = new p();
        pVar.f12784c = this;
        VarHandle.storeStoreFence();
        this.I = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x01df  */
    @Override // te.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a() {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.q.a():boolean");
    }

    @Override // te.v
    public final void b(te.l lVar, boolean z10) {
        j();
        l lVar2 = this.F;
        if (lVar2 != null) {
            lVar2.h();
        }
        te.u uVar = this.i;
        if (uVar != null) {
            uVar.b(lVar, z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    @Override // te.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.q.c():void");
    }

    @Override // te.v
    public final boolean d(te.m mVar) {
        return false;
    }

    @Override // te.v
    public final boolean e(te.m mVar) {
        return false;
    }

    @Override // te.v
    public final void f(Context context, te.l lVar) {
        this.f12802f = context;
        LayoutInflater.from(context);
        this.f12803g = lVar;
        Resources resources = context.getResources();
        Context context2 = a4.n.c(context).f190a;
        if (!this.f12813r) {
            this.f12812q = true;
        }
        if (!this.f12819x) {
            this.f12814s = context2.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.f12817v) {
            this.f12816u = context2.getResources().getInteger(R.integer.abc_max_action_buttons);
        }
        int measuredWidth = this.f12814s;
        if (this.f12812q) {
            if (this.f12808m == null) {
                o oVar = new o(this, this.f12801c);
                this.f12808m = oVar;
                if (this.f12811p) {
                    oVar.setImageDrawable(this.f12810o);
                    this.f12810o = null;
                    this.f12811p = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f12808m.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f12808m.getMeasuredWidth();
        } else {
            this.f12808m = null;
        }
        this.f12815t = measuredWidth;
        this.f12821z = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.D = null;
        this.A = (int) (resources.getDisplayMetrics().density * 60.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View] */
    @Override // te.v
    public final boolean g(te.z zVar) {
        if (zVar.hasVisibleItems()) {
            te.z zVar2 = zVar;
            while (true) {
                te.l lVar = zVar2.f13414w;
                if (lVar == this.f12803g) {
                    break;
                }
                zVar2 = (te.z) lVar;
            }
            te.m mVar = zVar2.f13415x;
            ViewGroup viewGroup = (ViewGroup) this.f12807l;
            o oVar = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    ?? childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof te.w) && ((te.w) childAt).getItemData() == mVar) {
                        oVar = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (oVar != null || (oVar = this.f12808m) != null) {
                zVar.f13415x.getClass();
                l lVar2 = new l(this, this.f12802f, zVar);
                this.F = lVar2;
                lVar2.f13411t = 8388613;
                lVar2.f13413v = 4;
                lVar2.f13403l = oVar;
                if (!lVar2.j()) {
                    od.f.e("MenuPopupHelper cannot be used without an anchor");
                    return false;
                }
                com.stepos.statsrpk.service.d dVar = new com.stepos.statsrpk.service.d(14);
                dVar.f2886g = this;
                dVar.f2885f = oVar;
                VarHandle.storeStoreFence();
                oVar.post(dVar);
                j0 j0Var = this.F.f13404m;
                k kVar = new k();
                kVar.f12763c = oVar;
                VarHandle.storeStoreFence();
                j0Var.D.setOnDismissListener(kVar);
                te.u uVar = this.i;
                if (uVar != null) {
                    uVar.e(zVar);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v3, types: [te.w] */
    /* JADX WARN: Type inference failed for: r5v5, types: [te.w] */
    public final View h(te.m mVar, View view, ViewGroup viewGroup) {
        ActionMenuItemView actionMenuItemView;
        ActionMenuItemView actionView = mVar.getActionView();
        if (actionView == null || mVar.d()) {
            if (view instanceof te.w) {
                actionMenuItemView = (te.w) view;
            } else {
                ?? r52 = (te.w) this.f12804h.inflate(this.f12806k, viewGroup, false);
                boolean z10 = r52 instanceof View;
                actionMenuItemView = r52;
                if (z10) {
                    actionMenuItemView = r52;
                }
            }
            actionMenuItemView.setIsInSplit(this.J);
            actionMenuItemView.d(mVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f12807l);
            if (this.H == null) {
                m mVar2 = new m();
                mVar2.f12777a = this;
                VarHandle.storeStoreFence();
                this.H = mVar2;
            }
            actionMenuItemView2.setPopupCallback(this.H);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(mVar.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.l(layoutParams));
            return actionView;
        }
        if ((layoutParams instanceof s) && (actionView instanceof ActionMenuItemView)) {
            ((s) layoutParams).f12827a = ((ActionMenuItemView) actionView).f12540y;
        }
        return actionView;
    }

    public final te.x i(ViewGroup viewGroup) {
        if (this.f12807l == null) {
            te.x xVar = (te.x) this.f12804h.inflate(this.f12805j, viewGroup, false);
            this.f12807l = xVar;
            xVar.b(this.f12803g);
            c();
        }
        te.x xVar2 = this.f12807l;
        ((ActionMenuView) xVar2).setPresenter(this);
        return xVar2;
    }

    public final boolean j() {
        Object obj;
        com.stepos.statsrpk.service.d dVar = this.G;
        if (dVar != null && (obj = this.f12807l) != null) {
            ((View) obj).removeCallbacks(dVar);
            this.G = null;
            return true;
        }
        l lVar = this.E;
        if (lVar == null) {
            return false;
        }
        lVar.h();
        return true;
    }

    public final boolean k() {
        l lVar = this.E;
        return lVar != null && lVar.i();
    }

    public final void l(boolean z10) {
        if (this.J != z10) {
            this.J = z10;
            this.f12806k = z10 ? R.layout.stepos_action_menu_item_split_layout : R.layout.stepos_action_menu_item_layout;
            Object obj = this.f12807l;
            if (obj != null) {
                ((ViewGroup) obj).removeAllViews();
            }
            if (z10) {
                return;
            }
            this.f12813r = false;
            this.f12819x = false;
            this.f12817v = false;
            f(this.f12802f, this.f12803g);
        }
    }

    public final void m() {
        this.f12816u = Reader.READ_DONE;
        this.f12817v = true;
    }

    public final void n(int i) {
        this.f12814s = i;
        this.f12818w = true;
        this.f12819x = true;
    }

    public final boolean o() {
        te.l lVar;
        if (!this.f12812q || k() || (lVar = this.f12803g) == null || this.f12807l == null || this.G != null) {
            return false;
        }
        lVar.i();
        if (lVar.i.isEmpty()) {
            return false;
        }
        l lVar2 = new l(this, this.f12802f, this.f12803g, this.f12808m);
        com.stepos.statsrpk.service.d dVar = new com.stepos.statsrpk.service.d(15);
        dVar.f2886g = this;
        dVar.f2885f = lVar2;
        VarHandle.storeStoreFence();
        this.G = dVar;
        ((View) this.f12807l).post(dVar);
        te.u uVar = this.i;
        if (uVar == null) {
            return true;
        }
        uVar.e(null);
        return true;
    }
}
