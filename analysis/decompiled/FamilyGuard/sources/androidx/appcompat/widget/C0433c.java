package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.AbstractC0457b;
import g.C0728a;
import java.util.ArrayList;
import l.InterfaceC0820e;

/* renamed from: androidx.appcompat.widget.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0433c extends androidx.appcompat.view.menu.a implements AbstractC0457b.a {

    /* renamed from: A, reason: collision with root package name */
    RunnableC0108c f8483A;

    /* renamed from: B, reason: collision with root package name */
    private b f8484B;

    /* renamed from: C, reason: collision with root package name */
    final f f8485C;

    /* renamed from: D, reason: collision with root package name */
    int f8486D;

    /* renamed from: k, reason: collision with root package name */
    d f8487k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f8488l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8489m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8490n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f8491o;

    /* renamed from: p, reason: collision with root package name */
    private int f8492p;

    /* renamed from: q, reason: collision with root package name */
    private int f8493q;

    /* renamed from: r, reason: collision with root package name */
    private int f8494r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8495s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8496t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f8497u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f8498v;

    /* renamed from: w, reason: collision with root package name */
    private int f8499w;

    /* renamed from: x, reason: collision with root package name */
    private final SparseBooleanArray f8500x;

    /* renamed from: y, reason: collision with root package name */
    e f8501y;

    /* renamed from: z, reason: collision with root package name */
    a f8502z;

    /* renamed from: androidx.appcompat.widget.c$a */
    private class a extends androidx.appcompat.view.menu.i {
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false, C0728a.f16837n);
            if (!((androidx.appcompat.view.menu.g) mVar.getItem()).l()) {
                View view2 = C0433c.this.f8487k;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.a) C0433c.this).f7819i : view2);
            }
            j(C0433c.this.f8485C);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            C0433c c0433c = C0433c.this;
            c0433c.f8502z = null;
            c0433c.f8486D = 0;
            super.e();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$b */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public InterfaceC0820e a() {
            a aVar = C0433c.this.f8502z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    private class RunnableC0108c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private e f8505a;

        public RunnableC0108c(e eVar) {
            this.f8505a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.a) C0433c.this).f7813c != null) {
                ((androidx.appcompat.view.menu.a) C0433c.this).f7813c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.a) C0433c.this).f7819i;
            if (view != null && view.getWindowToken() != null && this.f8505a.m()) {
                C0433c.this.f8501y = this.f8505a;
            }
            C0433c.this.f8483A = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$d */
    private class d extends r implements ActionMenuView.a {

        /* renamed from: androidx.appcompat.widget.c$d$a */
        class a extends L {

            /* renamed from: j, reason: collision with root package name */
            final /* synthetic */ C0433c f8508j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, C0433c c0433c) {
                super(view);
                this.f8508j = c0433c;
            }

            @Override // androidx.appcompat.widget.L
            public InterfaceC0820e b() {
                e eVar = C0433c.this.f8501y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.L
            public boolean c() {
                C0433c.this.K();
                return true;
            }

            @Override // androidx.appcompat.widget.L
            public boolean d() {
                C0433c c0433c = C0433c.this;
                if (c0433c.f8483A != null) {
                    return false;
                }
                c0433c.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, C0728a.f16836m);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            f0.a(this, getContentDescription());
            setOnTouchListener(new a(this, C0433c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0433c.this.K();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i5, int i6, int i7, int i8) {
            boolean frame = super.setFrame(i5, i6, i7, i8);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$e */
    private class e extends androidx.appcompat.view.menu.i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z5) {
            super(context, eVar, view, z5, C0728a.f16837n);
            h(8388613);
            j(C0433c.this.f8485C);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            if (((androidx.appcompat.view.menu.a) C0433c.this).f7813c != null) {
                ((androidx.appcompat.view.menu.a) C0433c.this).f7813c.close();
            }
            C0433c.this.f8501y = null;
            super.e();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$f */
    private class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void d(androidx.appcompat.view.menu.e eVar, boolean z5) {
            if (eVar instanceof androidx.appcompat.view.menu.m) {
                eVar.D().e(false);
            }
            j.a aVarM = C0433c.this.m();
            if (aVarM != null) {
                aVarM.d(eVar, z5);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean e(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ((androidx.appcompat.view.menu.a) C0433c.this).f7813c) {
                return false;
            }
            C0433c.this.f8486D = ((androidx.appcompat.view.menu.m) eVar).getItem().getItemId();
            j.a aVarM = C0433c.this.m();
            if (aVarM != null) {
                return aVarM.e(eVar);
            }
            return false;
        }
    }

    public C0433c(Context context) {
        super(context, g.g.f16947c, g.g.f16946b);
        this.f8500x = new SparseBooleanArray();
        this.f8485C = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f7819i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.f8487k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f8489m) {
            return this.f8488l;
        }
        return null;
    }

    public boolean B() {
        Object obj;
        RunnableC0108c runnableC0108c = this.f8483A;
        if (runnableC0108c != null && (obj = this.f7819i) != null) {
            ((View) obj).removeCallbacks(runnableC0108c);
            this.f8483A = null;
            return true;
        }
        e eVar = this.f8501y;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean C() {
        a aVar = this.f8502z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.f8483A != null || E();
    }

    public boolean E() {
        e eVar = this.f8501y;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.f8495s) {
            this.f8494r = androidx.appcompat.view.a.b(this.f7812b).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f7813c;
        if (eVar != null) {
            eVar.L(true);
        }
    }

    public void G(boolean z5) {
        this.f8498v = z5;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f7819i = actionMenuView;
        actionMenuView.e(this.f7813c);
    }

    public void I(Drawable drawable) {
        d dVar = this.f8487k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f8489m = true;
            this.f8488l = drawable;
        }
    }

    public void J(boolean z5) {
        this.f8490n = z5;
        this.f8491o = true;
    }

    public boolean K() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f8490n || E() || (eVar = this.f7813c) == null || this.f7819i == null || this.f8483A != null || eVar.z().isEmpty()) {
            return false;
        }
        RunnableC0108c runnableC0108c = new RunnableC0108c(new e(this.f7812b, this.f7813c, this.f8487k, true));
        this.f8483A = runnableC0108c;
        ((View) this.f7819i).post(runnableC0108c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void b(boolean z5) {
        super.b(z5);
        ((View) this.f7819i).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f7813c;
        boolean z6 = false;
        if (eVar != null) {
            ArrayList<androidx.appcompat.view.menu.g> arrayListS = eVar.s();
            int size = arrayListS.size();
            for (int i5 = 0; i5 < size; i5++) {
                AbstractC0457b abstractC0457bB = arrayListS.get(i5).b();
                if (abstractC0457bB != null) {
                    abstractC0457bB.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f7813c;
        ArrayList<androidx.appcompat.view.menu.g> arrayListZ = eVar2 != null ? eVar2.z() : null;
        if (this.f8490n && arrayListZ != null) {
            int size2 = arrayListZ.size();
            if (size2 == 1) {
                z6 = !arrayListZ.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z6 = true;
            }
        }
        if (z6) {
            if (this.f8487k == null) {
                this.f8487k = new d(this.f7811a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f8487k.getParent();
            if (viewGroup != this.f7819i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f8487k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f7819i;
                actionMenuView.addView(this.f8487k, actionMenuView.F());
            }
        } else {
            d dVar = this.f8487k;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.f7819i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f8487k);
                }
            }
        }
        ((ActionMenuView) this.f7819i).setOverflowReserved(this.f8490n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        ArrayList<androidx.appcompat.view.menu.g> arrayListE;
        int size;
        int i5;
        int iL;
        boolean z5;
        int i6;
        C0433c c0433c = this;
        androidx.appcompat.view.menu.e eVar = c0433c.f7813c;
        View view = null;
        ?? r32 = 0;
        if (eVar != null) {
            arrayListE = eVar.E();
            size = arrayListE.size();
        } else {
            arrayListE = null;
            size = 0;
        }
        int i7 = c0433c.f8494r;
        int i8 = c0433c.f8493q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c0433c.f7819i;
        boolean z6 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            androidx.appcompat.view.menu.g gVar = arrayListE.get(i11);
            if (gVar.o()) {
                i9++;
            } else if (gVar.n()) {
                i10++;
            } else {
                z6 = true;
            }
            if (c0433c.f8498v && gVar.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (c0433c.f8490n && (z6 || i10 + i9 > i7)) {
            i7--;
        }
        int i12 = i7 - i9;
        SparseBooleanArray sparseBooleanArray = c0433c.f8500x;
        sparseBooleanArray.clear();
        if (c0433c.f8496t) {
            int i13 = c0433c.f8499w;
            iL = i8 / i13;
            i5 = i13 + ((i8 % i13) / iL);
        } else {
            i5 = 0;
            iL = 0;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < size) {
            androidx.appcompat.view.menu.g gVar2 = arrayListE.get(i14);
            if (gVar2.o()) {
                View viewN = c0433c.n(gVar2, view, viewGroup);
                if (c0433c.f8496t) {
                    iL -= ActionMenuView.L(viewN, i5, iL, iMakeMeasureSpec, r32);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i8 -= measuredWidth;
                if (i15 == 0) {
                    i15 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                z5 = r32;
                i6 = size;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z7 = sparseBooleanArray.get(groupId2);
                boolean z8 = (i12 > 0 || z7) && i8 > 0 && (!c0433c.f8496t || iL > 0);
                boolean z9 = z8;
                i6 = size;
                if (z8) {
                    View viewN2 = c0433c.n(gVar2, null, viewGroup);
                    if (c0433c.f8496t) {
                        int iL2 = ActionMenuView.L(viewN2, i5, iL, iMakeMeasureSpec, 0);
                        iL -= iL2;
                        if (iL2 == 0) {
                            z9 = false;
                        }
                    } else {
                        viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z10 = z9;
                    int measuredWidth2 = viewN2.getMeasuredWidth();
                    i8 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    z8 = z10 & (!c0433c.f8496t ? i8 + i15 <= 0 : i8 < 0);
                }
                if (z8 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z7) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i16 = 0; i16 < i14; i16++) {
                        androidx.appcompat.view.menu.g gVar3 = arrayListE.get(i16);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i12++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z8) {
                    i12--;
                }
                gVar2.u(z8);
                z5 = false;
            } else {
                z5 = r32;
                i6 = size;
                gVar2.u(z5);
            }
            i14++;
            r32 = z5;
            size = i6;
            view = null;
            c0433c = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void d(androidx.appcompat.view.menu.e eVar, boolean z5) {
        y();
        super.d(eVar, z5);
    }

    @Override // androidx.appcompat.view.menu.a
    public void h(androidx.appcompat.view.menu.g gVar, k.a aVar) {
        aVar.f(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f7819i);
        if (this.f8484B == null) {
            this.f8484B = new b();
        }
        actionMenuItemView.setPopupCallback(this.f8484B);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void i(Context context, androidx.appcompat.view.menu.e eVar) {
        super.i(context, eVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(context);
        if (!this.f8491o) {
            this.f8490n = aVarB.h();
        }
        if (!this.f8497u) {
            this.f8492p = aVarB.c();
        }
        if (!this.f8495s) {
            this.f8494r = aVarB.d();
        }
        int measuredWidth = this.f8492p;
        if (this.f8490n) {
            if (this.f8487k == null) {
                d dVar = new d(this.f7811a);
                this.f8487k = dVar;
                if (this.f8489m) {
                    dVar.setImageDrawable(this.f8488l);
                    this.f8488l = null;
                    this.f8489m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f8487k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f8487k.getMeasuredWidth();
        } else {
            this.f8487k = null;
        }
        this.f8493q = measuredWidth;
        this.f8499w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean j(androidx.appcompat.view.menu.m mVar) {
        boolean z5 = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.m mVar2 = mVar;
        while (mVar2.f0() != this.f7813c) {
            mVar2 = (androidx.appcompat.view.menu.m) mVar2.f0();
        }
        View viewZ = z(mVar2.getItem());
        if (viewZ == null) {
            return false;
        }
        this.f8486D = mVar.getItem().getItemId();
        int size = mVar.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                break;
            }
            MenuItem item = mVar.getItem(i5);
            if (item.isVisible() && item.getIcon() != null) {
                z5 = true;
                break;
            }
            i5++;
        }
        a aVar = new a(this.f7812b, mVar, viewZ);
        this.f8502z = aVar;
        aVar.g(z5);
        this.f8502z.k();
        super.j(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean l(ViewGroup viewGroup, int i5) {
        if (viewGroup.getChildAt(i5) == this.f8487k) {
            return false;
        }
        return super.l(viewGroup, i5);
    }

    @Override // androidx.appcompat.view.menu.a
    public View n(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.n(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.k o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.k kVar = this.f7819i;
        androidx.appcompat.view.menu.k kVarO = super.o(viewGroup);
        if (kVar != kVarO) {
            ((ActionMenuView) kVarO).setPresenter(this);
        }
        return kVarO;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean q(int i5, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }

    public boolean y() {
        return C() | B();
    }
}
