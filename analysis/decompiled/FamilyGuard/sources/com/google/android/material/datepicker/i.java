package com.google.android.material.datepicker;

import E.c;
import a1.C0411d;
import a1.C0413f;
import a1.C0414g;
import a1.C0415h;
import a1.C0416i;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.C0456a;
import androidx.core.view.H;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class i<S> extends t<S> {

    /* renamed from: v0, reason: collision with root package name */
    static final Object f12680v0 = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: w0, reason: collision with root package name */
    static final Object f12681w0 = "NAVIGATION_PREV_TAG";

    /* renamed from: x0, reason: collision with root package name */
    static final Object f12682x0 = "NAVIGATION_NEXT_TAG";

    /* renamed from: y0, reason: collision with root package name */
    static final Object f12683y0 = "SELECTOR_TOGGLE_TAG";

    /* renamed from: g0, reason: collision with root package name */
    private int f12684g0;

    /* renamed from: h0, reason: collision with root package name */
    private com.google.android.material.datepicker.d<S> f12685h0;

    /* renamed from: i0, reason: collision with root package name */
    private com.google.android.material.datepicker.a f12686i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.google.android.material.datepicker.g f12687j0;

    /* renamed from: k0, reason: collision with root package name */
    private p f12688k0;

    /* renamed from: l0, reason: collision with root package name */
    private l f12689l0;

    /* renamed from: m0, reason: collision with root package name */
    private com.google.android.material.datepicker.c f12690m0;

    /* renamed from: n0, reason: collision with root package name */
    private RecyclerView f12691n0;

    /* renamed from: o0, reason: collision with root package name */
    private RecyclerView f12692o0;

    /* renamed from: p0, reason: collision with root package name */
    private View f12693p0;

    /* renamed from: q0, reason: collision with root package name */
    private View f12694q0;

    /* renamed from: r0, reason: collision with root package name */
    private View f12695r0;

    /* renamed from: s0, reason: collision with root package name */
    private View f12696s0;

    /* renamed from: t0, reason: collision with root package name */
    private MaterialButton f12697t0;

    /* renamed from: u0, reason: collision with root package name */
    private AccessibilityManager f12698u0;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f12699a;

        a(r rVar) {
            this.f12699a = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.r2(this.f12699a.k(i.this.n2().findLastVisibleItemPosition() - 1));
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12701a;

        b(int i5) {
            this.f12701a = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f12692o0.smoothScrollToPosition(this.f12701a);
        }
    }

    class c extends C0456a {
        c() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.f0(null);
        }
    }

    class d extends u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12704a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, int i5, boolean z5, int i6) {
            super(context, i5, z5);
            this.f12704a = i6;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            if (this.f12704a == 0) {
                iArr[0] = i.this.f12692o0.getWidth();
                iArr[1] = i.this.f12692o0.getWidth();
            } else {
                iArr[0] = i.this.f12692o0.getHeight();
                iArr[1] = i.this.f12692o0.getHeight();
            }
        }
    }

    class e implements m {
        e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.i.m
        public void a(long j5) {
            if (i.this.f12686i0.F().r(j5)) {
                i.this.f12685h0.C(j5);
                Iterator<s<S>> it = i.this.f12791f0.iterator();
                while (it.hasNext()) {
                    it.next().a(i.this.f12685h0.w());
                }
                i.this.f12692o0.getAdapter().notifyDataSetChanged();
                if (i.this.f12691n0 != null) {
                    i.this.f12691n0.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    class f extends C0456a {
        f() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.w0(false);
        }
    }

    class g extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private final Calendar f12708a = w.i();

        /* renamed from: b, reason: collision with root package name */
        private final Calendar f12709b = w.i();

        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if ((recyclerView.getAdapter() instanceof x) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                x xVar = (x) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (D.d<Long, Long> dVar : i.this.f12685h0.e()) {
                    Long l5 = dVar.f999a;
                    if (l5 != null && dVar.f1000b != null) {
                        this.f12708a.setTimeInMillis(l5.longValue());
                        this.f12709b.setTimeInMillis(dVar.f1000b.longValue());
                        int iL = xVar.l(this.f12708a.get(1));
                        int iL2 = xVar.l(this.f12709b.get(1));
                        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iL);
                        View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iL2);
                        int spanCount = iL / gridLayoutManager.getSpanCount();
                        int spanCount2 = iL2 / gridLayoutManager.getSpanCount();
                        int i5 = spanCount;
                        while (i5 <= spanCount2) {
                            if (gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i5) != null) {
                                canvas.drawRect((i5 != spanCount || viewFindViewByPosition == null) ? 0 : viewFindViewByPosition.getLeft() + (viewFindViewByPosition.getWidth() / 2), r9.getTop() + i.this.f12690m0.f12670d.c(), (i5 != spanCount2 || viewFindViewByPosition2 == null) ? recyclerView.getWidth() : viewFindViewByPosition2.getLeft() + (viewFindViewByPosition2.getWidth() / 2), r9.getBottom() - i.this.f12690m0.f12670d.b(), i.this.f12690m0.f12674h);
                            }
                            i5++;
                        }
                    }
                }
            }
        }
    }

    class h extends C0456a {
        h() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.b(new c.a(16, i.this.f12696s0.getVisibility() == 0 ? i.this.W(C0416i.f6905u) : i.this.W(C0416i.f6903s)));
        }
    }

    /* renamed from: com.google.android.material.datepicker.i$i, reason: collision with other inner class name */
    class C0165i extends RecyclerView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f12712a;

        C0165i(r rVar) {
            this.f12712a = rVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            int iFindFirstVisibleItemPosition = i5 < 0 ? i.this.n2().findFirstVisibleItemPosition() : i.this.n2().findLastVisibleItemPosition();
            p pVarK = this.f12712a.k(iFindFirstVisibleItemPosition);
            i.this.f12688k0 = pVarK;
            i.this.f12697t0.setText(this.f12712a.l(iFindFirstVisibleItemPosition));
            i.this.v2(this.f12712a.n(pVarK));
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.u2();
        }
    }

    class k implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f12715a;

        k(r rVar) {
            this.f12715a = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.r2(this.f12715a.k(i.this.n2().findFirstVisibleItemPosition() + 1));
        }
    }

    enum l {
        DAY,
        YEAR
    }

    interface m {
        void a(long j5);
    }

    private void f2(View view, r rVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(C0413f.f6855r);
        this.f12697t0 = materialButton;
        materialButton.setTag(f12683y0);
        H.k0(this.f12697t0, new h());
        View viewFindViewById = view.findViewById(C0413f.f6857t);
        this.f12693p0 = viewFindViewById;
        viewFindViewById.setTag(f12681w0);
        View viewFindViewById2 = view.findViewById(C0413f.f6856s);
        this.f12694q0 = viewFindViewById2;
        viewFindViewById2.setTag(f12682x0);
        this.f12695r0 = view.findViewById(C0413f.f6818A);
        this.f12696s0 = view.findViewById(C0413f.f6859v);
        s2(l.DAY);
        this.f12697t0.setText(this.f12688k0.M());
        this.f12692o0.addOnScrollListener(new C0165i(rVar));
        this.f12697t0.setOnClickListener(new j());
        this.f12694q0.setOnClickListener(new k(rVar));
        this.f12693p0.setOnClickListener(new a(rVar));
        v2(rVar.n(this.f12688k0));
    }

    private RecyclerView.ItemDecoration g2() {
        return new g();
    }

    static int l2(Context context) {
        return context.getResources().getDimensionPixelSize(C0411d.f6763R);
    }

    private static int m2(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C0411d.f6770Y) + resources.getDimensionPixelOffset(C0411d.f6771Z) + resources.getDimensionPixelOffset(C0411d.f6769X);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C0411d.f6765T);
        int i5 = q.f12774g;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(C0411d.f6763R) * i5) + ((i5 - 1) * resources.getDimensionPixelOffset(C0411d.f6768W)) + resources.getDimensionPixelOffset(C0411d.f6761P);
    }

    public static <T> i<T> o2(com.google.android.material.datepicker.d<T> dVar, int i5, com.google.android.material.datepicker.a aVar, com.google.android.material.datepicker.g gVar) {
        i<T> iVar = new i<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i5);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", gVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.J());
        iVar.G1(bundle);
        return iVar;
    }

    private void p2(int i5) {
        this.f12692o0.post(new b(i5));
    }

    private void t2() {
        H.k0(this.f12692o0, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v2(int i5) {
        this.f12694q0.setEnabled(i5 + 1 < this.f12692o0.getAdapter().getItemCount());
        this.f12693p0.setEnabled(i5 - 1 >= 0);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f12684g0);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f12685h0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f12686i0);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f12687j0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f12688k0);
    }

    @Override // com.google.android.material.datepicker.t
    public boolean U1(s<S> sVar) {
        return super.U1(sVar);
    }

    com.google.android.material.datepicker.a h2() {
        return this.f12686i0;
    }

    com.google.android.material.datepicker.c i2() {
        return this.f12690m0;
    }

    p j2() {
        return this.f12688k0;
    }

    public com.google.android.material.datepicker.d<S> k2() {
        return this.f12685h0;
    }

    LinearLayoutManager n2() {
        return (LinearLayoutManager) this.f12692o0.getLayoutManager();
    }

    void q2() {
        MaterialButton materialButton = this.f12697t0;
        if (materialButton != null) {
            materialButton.sendAccessibilityEvent(8);
        }
    }

    void r2(p pVar) {
        r rVar = (r) this.f12692o0.getAdapter();
        int iN = rVar.n(pVar);
        AccessibilityManager accessibilityManager = this.f12698u0;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int iN2 = iN - rVar.n(this.f12688k0);
            boolean z5 = Math.abs(iN2) > 3;
            boolean z6 = iN2 > 0;
            this.f12688k0 = pVar;
            if (z5 && z6) {
                this.f12692o0.scrollToPosition(iN - 3);
                p2(iN);
            } else if (z5) {
                this.f12692o0.scrollToPosition(iN + 3);
                p2(iN);
            } else {
                p2(iN);
            }
        } else {
            this.f12688k0 = pVar;
            this.f12692o0.scrollToPosition(iN);
        }
        v2(iN);
    }

    void s2(l lVar) {
        this.f12689l0 = lVar;
        if (lVar == l.YEAR) {
            this.f12691n0.getLayoutManager().scrollToPosition(((x) this.f12691n0.getAdapter()).l(this.f12688k0.f12769c));
            this.f12695r0.setVisibility(0);
            this.f12696s0.setVisibility(8);
            this.f12693p0.setVisibility(8);
            this.f12694q0.setVisibility(8);
            return;
        }
        if (lVar == l.DAY) {
            this.f12695r0.setVisibility(8);
            this.f12696s0.setVisibility(0);
            this.f12693p0.setVisibility(0);
            this.f12694q0.setVisibility(0);
            r2(this.f12688k0);
        }
    }

    void u2() {
        l lVar = this.f12689l0;
        l lVar2 = l.YEAR;
        if (lVar == lVar2) {
            s2(l.DAY);
            this.f12692o0.announceForAccessibility(W(C0416i.f6906v));
        } else if (lVar == l.DAY) {
            s2(lVar2);
            this.f12691n0.announceForAccessibility(W(C0416i.f6907w));
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        if (bundle == null) {
            bundle = u();
        }
        this.f12684g0 = bundle.getInt("THEME_RES_ID_KEY");
        this.f12685h0 = (com.google.android.material.datepicker.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f12686i0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f12687j0 = (com.google.android.material.datepicker.g) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f12688k0 = (p) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        int i5;
        int i6;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(w(), this.f12684g0);
        this.f12690m0 = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.f12698u0 = (AccessibilityManager) A1().getSystemService("accessibility");
        p pVarK = this.f12686i0.K();
        if (com.google.android.material.datepicker.m.v2(contextThemeWrapper)) {
            i5 = C0415h.f6881o;
            i6 = 1;
        } else {
            i5 = C0415h.f6879m;
            i6 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i5, viewGroup, false);
        viewInflate.setMinimumHeight(m2(A1()));
        GridView gridView = (GridView) viewInflate.findViewById(C0413f.f6860w);
        H.k0(gridView, new c());
        int iH = this.f12686i0.H();
        gridView.setAdapter((ListAdapter) (iH > 0 ? new com.google.android.material.datepicker.h(iH) : new com.google.android.material.datepicker.h()));
        gridView.setNumColumns(pVarK.f12770d);
        gridView.setEnabled(false);
        this.f12692o0 = (RecyclerView) viewInflate.findViewById(C0413f.f6863z);
        this.f12692o0.setLayoutManager(new d(w(), i6, false, i6));
        this.f12692o0.setTag(f12680v0);
        r rVar = new r(contextThemeWrapper, this.f12685h0, this.f12686i0, this.f12687j0, new e());
        this.f12692o0.setAdapter(rVar);
        int integer = contextThemeWrapper.getResources().getInteger(C0414g.f6866c);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C0413f.f6818A);
        this.f12691n0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f12691n0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f12691n0.setAdapter(new x(this));
            this.f12691n0.addItemDecoration(g2());
        }
        if (viewInflate.findViewById(C0413f.f6855r) != null) {
            f2(viewInflate, rVar);
        }
        if (!com.google.android.material.datepicker.m.v2(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.f12692o0);
        }
        this.f12692o0.scrollToPosition(rVar.n(this.f12688k0));
        t2();
        return viewInflate;
    }
}
