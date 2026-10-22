package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.RunnableC0209k;
import com.stepos.alphame.R;
import j.C0622a;
import stepos.support.v7.app.C0872q;
import stepos.support.v7.view.menu.ActionMenuItemView;

/* renamed from: stepos.support.v7.widget.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0897q implements L3.w {

    /* renamed from: A, reason: collision with root package name */
    public C0895o f15110A;

    /* renamed from: B, reason: collision with root package name */
    public C0891k f15111B;

    /* renamed from: C, reason: collision with root package name */
    public RunnableC0209k f15112C;

    /* renamed from: D, reason: collision with root package name */
    public C0892l f15113D;

    /* renamed from: F, reason: collision with root package name */
    public boolean f15115F;

    /* renamed from: a, reason: collision with root package name */
    public final Context f15116a;

    /* renamed from: b, reason: collision with root package name */
    public Context f15117b;

    /* renamed from: c, reason: collision with root package name */
    public L3.k f15118c;

    /* renamed from: d, reason: collision with root package name */
    public final LayoutInflater f15119d;

    /* renamed from: e, reason: collision with root package name */
    public L3.v f15120e;

    /* renamed from: h, reason: collision with root package name */
    public L3.y f15123h;

    /* renamed from: i, reason: collision with root package name */
    public C0894n f15124i;

    /* renamed from: j, reason: collision with root package name */
    public TouchDelegate f15125j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f15126k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15127l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15128m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15129n;

    /* renamed from: o, reason: collision with root package name */
    public int f15130o;

    /* renamed from: p, reason: collision with root package name */
    public int f15131p;

    /* renamed from: q, reason: collision with root package name */
    public int f15132q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f15133r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f15134s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f15135t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f15136u;

    /* renamed from: v, reason: collision with root package name */
    public int f15137v;

    /* renamed from: w, reason: collision with root package name */
    public int f15138w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f15139x;

    /* renamed from: z, reason: collision with root package name */
    public View f15141z;

    /* renamed from: f, reason: collision with root package name */
    public final int f15121f = R.layout.stepos_abc_action_menu_layout;

    /* renamed from: g, reason: collision with root package name */
    public int f15122g = R.layout.stepos_action_menu_item_layout;

    /* renamed from: y, reason: collision with root package name */
    public final SparseBooleanArray f15140y = new SparseBooleanArray();

    /* renamed from: E, reason: collision with root package name */
    public final C0872q f15114E = new C0872q(this);

    public C0897q(Context context) {
        this.f15116a = context;
        this.f15119d = LayoutInflater.from(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
    @Override // L3.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.C0897q.a():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v3, types: [L3.x] */
    /* JADX WARN: Type inference failed for: r5v5, types: [L3.x] */
    public final View b(L3.l lVar, View view, ViewGroup viewGroup) {
        ActionMenuItemView actionMenuItemView;
        ActionMenuItemView actionView = lVar.getActionView();
        if (actionView == null || lVar.d()) {
            if (view instanceof L3.x) {
                actionMenuItemView = (L3.x) view;
            } else {
                ?? r5 = (L3.x) this.f15119d.inflate(this.f15122g, viewGroup, false);
                boolean z4 = r5 instanceof View;
                actionMenuItemView = r5;
                if (z4) {
                    actionMenuItemView = r5;
                }
            }
            actionMenuItemView.setIsInSplit(this.f15115F);
            actionMenuItemView.d(lVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f15123h);
            if (this.f15113D == null) {
                this.f15113D = new C0892l(this);
            }
            actionMenuItemView2.setPopupCallback(this.f15113D);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(lVar.f1304C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.o(layoutParams));
        } else if ((layoutParams instanceof C0899t) && (actionView instanceof ActionMenuItemView)) {
            ((C0899t) layoutParams).f15148a = ((ActionMenuItemView) actionView).f14676u;
        }
        return actionView;
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x01ca  */
    @Override // L3.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.C0897q.c():boolean");
    }

    @Override // L3.w
    public final void d(L3.k kVar, boolean z4) {
        j();
        C0891k c0891k = this.f15111B;
        if (c0891k != null) {
            c0891k.b();
        }
        L3.v vVar = this.f15120e;
        if (vVar != null) {
            vVar.d(kVar, z4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View] */
    @Override // L3.w
    public final boolean e(L3.A a4) {
        if (!a4.hasVisibleItems()) {
            return false;
        }
        L3.A a5 = a4;
        while (true) {
            L3.k kVar = a5.f1243w;
            if (kVar == this.f15118c) {
                break;
            }
            a5 = (L3.A) kVar;
        }
        ViewGroup viewGroup = (ViewGroup) this.f15123h;
        C0894n c0894n = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                ?? childAt = viewGroup.getChildAt(i4);
                if ((childAt instanceof L3.x) && ((L3.x) childAt).getItemData() == a5.f1244x) {
                    c0894n = childAt;
                    break;
                }
                i4++;
            }
        }
        if (c0894n == null && (c0894n = this.f15124i) == null) {
            return false;
        }
        a4.f1244x.getClass();
        C0891k c0891k = new C0891k(this, this.f15117b, a4);
        this.f15111B = c0891k;
        c0891k.f1357q = 8388613;
        c0891k.f1359s = 4;
        c0891k.f1349i = c0894n;
        if (!c0891k.j()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
        c0894n.post(new RunnableC0209k(21, this, c0894n));
        this.f15111B.f1350j.f2846z.setOnDismissListener(new androidx.appcompat.widget.S(1, this, c0894n));
        L3.v vVar = this.f15120e;
        if (vVar != null) {
            vVar.g(a4);
        }
        return true;
    }

    @Override // L3.w
    public final /* bridge */ /* synthetic */ boolean f(L3.l lVar) {
        return false;
    }

    @Override // L3.w
    public final void g(Context context, L3.k kVar) {
        this.f15117b = context;
        LayoutInflater.from(context);
        this.f15118c = kVar;
        Resources resources = context.getResources();
        C0622a c0622aC = C0622a.c(context);
        if (!this.f15129n) {
            this.f15128m = true;
        }
        if (!this.f15135t) {
            this.f15130o = c0622aC.d();
        }
        if (!this.f15133r) {
            this.f15132q = c0622aC.e();
        }
        int measuredWidth = this.f15130o;
        if (this.f15128m) {
            if (this.f15124i == null) {
                C0894n c0894n = new C0894n(this, this.f15116a);
                this.f15124i = c0894n;
                if (this.f15127l) {
                    c0894n.setImageDrawable(this.f15126k);
                    this.f15126k = null;
                    this.f15127l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f15124i.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f15124i.getMeasuredWidth();
        } else {
            this.f15124i = null;
        }
        this.f15131p = measuredWidth;
        this.f15137v = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.f15141z = null;
        this.f15138w = (int) (resources.getDisplayMetrics().density * 60.0f);
    }

    @Override // L3.w
    public final /* bridge */ /* synthetic */ boolean h(L3.l lVar) {
        return false;
    }

    public final L3.y i(ViewGroup viewGroup) {
        if (this.f15123h == null) {
            L3.y yVar = (L3.y) this.f15119d.inflate(this.f15121f, viewGroup, false);
            this.f15123h = yVar;
            yVar.e(this.f15118c);
            a();
        }
        L3.y yVar2 = this.f15123h;
        ((ActionMenuView) yVar2).setPresenter(this);
        return yVar2;
    }

    public final boolean j() {
        Object obj;
        RunnableC0209k runnableC0209k = this.f15112C;
        if (runnableC0209k != null && (obj = this.f15123h) != null) {
            ((View) obj).removeCallbacks(runnableC0209k);
            this.f15112C = null;
            return true;
        }
        C0895o c0895o = this.f15110A;
        if (c0895o == null) {
            return false;
        }
        c0895o.b();
        return true;
    }

    public final boolean k() {
        C0895o c0895o = this.f15110A;
        return c0895o != null && c0895o.i();
    }

    public final void l(boolean z4) {
        if (this.f15115F != z4) {
            this.f15115F = z4;
            this.f15122g = z4 ? R.layout.stepos_action_menu_item_split_layout : R.layout.stepos_action_menu_item_layout;
            Object obj = this.f15123h;
            if (obj != null) {
                ((ViewGroup) obj).removeAllViews();
            }
            if (z4) {
                return;
            }
            this.f15129n = false;
            this.f15135t = false;
            this.f15133r = false;
            g(this.f15117b, this.f15118c);
        }
    }

    public final void m() {
        this.f15132q = Integer.MAX_VALUE;
        this.f15133r = true;
    }

    public final void n(int i4) {
        this.f15130o = i4;
        this.f15134s = true;
        this.f15135t = true;
    }

    public final boolean o() {
        L3.k kVar;
        if (!this.f15128m || k() || (kVar = this.f15118c) == null || this.f15123h == null || this.f15112C != null) {
            return false;
        }
        kVar.i();
        if (kVar.f1289i.isEmpty()) {
            return false;
        }
        RunnableC0209k runnableC0209k = new RunnableC0209k(22, this, new C0895o(this, this.f15117b, this.f15118c, this.f15124i));
        this.f15112C = runnableC0209k;
        ((View) this.f15123h).post(runnableC0209k);
        L3.v vVar = this.f15120e;
        if (vVar == null) {
            return true;
        }
        vVar.g(null);
        return true;
    }
}
