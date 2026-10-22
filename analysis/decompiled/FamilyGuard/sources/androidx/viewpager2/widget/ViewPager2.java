package androidx.viewpager2.widget;

import E.c;
import E.f;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.H;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import j0.C0776a;
import k0.InterfaceC0795a;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: u, reason: collision with root package name */
    static boolean f11693u = true;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f11694a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f11695b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.viewpager2.widget.b f11696c;

    /* renamed from: d, reason: collision with root package name */
    int f11697d;

    /* renamed from: e, reason: collision with root package name */
    boolean f11698e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f11699f;

    /* renamed from: g, reason: collision with root package name */
    private LinearLayoutManager f11700g;

    /* renamed from: h, reason: collision with root package name */
    private int f11701h;

    /* renamed from: i, reason: collision with root package name */
    private Parcelable f11702i;

    /* renamed from: j, reason: collision with root package name */
    RecyclerView f11703j;

    /* renamed from: k, reason: collision with root package name */
    private PagerSnapHelper f11704k;

    /* renamed from: l, reason: collision with root package name */
    androidx.viewpager2.widget.e f11705l;

    /* renamed from: m, reason: collision with root package name */
    private androidx.viewpager2.widget.b f11706m;

    /* renamed from: n, reason: collision with root package name */
    private androidx.viewpager2.widget.c f11707n;

    /* renamed from: o, reason: collision with root package name */
    private androidx.viewpager2.widget.d f11708o;

    /* renamed from: p, reason: collision with root package name */
    private RecyclerView.ItemAnimator f11709p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f11710q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f11711r;

    /* renamed from: s, reason: collision with root package name */
    private int f11712s;

    /* renamed from: t, reason: collision with root package name */
    e f11713t;

    class a extends g {
        a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f11698e = true;
            viewPager2.f11705l.j();
        }
    }

    class b extends i {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i5) {
            if (i5 == 0) {
                ViewPager2.this.n();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i5) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f11697d != i5) {
                viewPager2.f11697d = i5;
                viewPager2.f11713t.q();
            }
        }
    }

    class c extends i {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i5) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f11703j.requestFocus(2);
            }
        }
    }

    class d implements RecyclerView.OnChildAttachStateChangeListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
        }
    }

    private abstract class e {
        private e() {
        }

        boolean a() {
            return false;
        }

        boolean b(int i5) {
            return false;
        }

        boolean c(int i5, Bundle bundle) {
            return false;
        }

        boolean d() {
            return false;
        }

        void e(RecyclerView.Adapter<?> adapter) {
        }

        void f(RecyclerView.Adapter<?> adapter) {
        }

        String g() {
            throw new IllegalStateException("Not implemented.");
        }

        void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
        }

        void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void j(E.c cVar) {
        }

        boolean k(int i5) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean l(int i5, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        void m() {
        }

        CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        void o(AccessibilityEvent accessibilityEvent) {
        }

        void p() {
        }

        void q() {
        }

        void r() {
        }

        void s() {
        }

        /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }
    }

    class f extends e {
        f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i5) {
            return (i5 == 8192 || i5 == 4096) && !ViewPager2.this.e();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(E.c cVar) {
            if (ViewPager2.this.e()) {
                return;
            }
            cVar.X(c.a.f1259r);
            cVar.X(c.a.f1258q);
            cVar.w0(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int i5) {
            if (b(i5)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class g extends RecyclerView.AdapterDataObserver {
        private g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i5, int i6) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i5, int i6) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i5, int i6, int i7) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i5, int i6) {
            onChanged();
        }

        /* synthetic */ g(a aVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i5, int i6, Object obj) {
            onChanged();
        }
    }

    private class h extends LinearLayoutManager {
        h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, cVar);
            ViewPager2.this.f11713t.j(cVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i5, Bundle bundle) {
            return ViewPager2.this.f11713t.b(i5) ? ViewPager2.this.f11713t.k(i5) : super.performAccessibilityAction(recycler, state, i5, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z5, boolean z6) {
            return false;
        }
    }

    public static abstract class i {
        public void a(int i5) {
        }

        public void b(int i5, float f5, int i6) {
        }

        public void c(int i5) {
        }
    }

    class j extends e {

        /* renamed from: b, reason: collision with root package name */
        private final E.f f11721b;

        /* renamed from: c, reason: collision with root package name */
        private final E.f f11722c;

        /* renamed from: d, reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f11723d;

        class a implements E.f {
            a() {
            }

            @Override // E.f
            public boolean a(View view, f.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        class b implements E.f {
            b() {
            }

            @Override // E.f
            public boolean a(View view, f.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        class c extends g {
            c() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                j.this.w();
            }
        }

        j() {
            super(ViewPager2.this, null);
            this.f11721b = new a();
            this.f11722c = new b();
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            int itemCount2;
            if (ViewPager2.this.getAdapter() == null) {
                itemCount = 0;
                itemCount2 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                itemCount = ViewPager2.this.getAdapter().getItemCount();
                itemCount2 = 0;
            } else {
                itemCount2 = ViewPager2.this.getAdapter().getItemCount();
                itemCount = 0;
            }
            E.c.E0(accessibilityNodeInfo).f0(c.e.a(itemCount, itemCount2, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.f11697d > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f11697d < itemCount - 1) {
                accessibilityNodeInfo.addAction(RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i5, Bundle bundle) {
            return i5 == 8192 || i5 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.Adapter<?> adapter) {
            w();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f11723d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f11723d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
            H.t0(recyclerView, 2);
            this.f11723d = new c();
            if (H.v(ViewPager2.this) == 0) {
                H.t0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i5, Bundle bundle) {
            if (!c(i5, bundle)) {
                throw new IllegalStateException();
            }
            v(i5 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            w();
        }

        void v(int i5) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i5, true);
            }
        }

        void w() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i5 = R.id.accessibilityActionPageLeft;
            H.d0(viewPager2, R.id.accessibilityActionPageLeft);
            H.d0(viewPager2, R.id.accessibilityActionPageRight);
            H.d0(viewPager2, R.id.accessibilityActionPageUp);
            H.d0(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f11697d < itemCount - 1) {
                    H.f0(viewPager2, new c.a(R.id.accessibilityActionPageDown, null), null, this.f11721b);
                }
                if (ViewPager2.this.f11697d > 0) {
                    H.f0(viewPager2, new c.a(R.id.accessibilityActionPageUp, null), null, this.f11722c);
                    return;
                }
                return;
            }
            boolean zD = ViewPager2.this.d();
            int i6 = zD ? 16908360 : 16908361;
            if (zD) {
                i5 = 16908361;
            }
            if (ViewPager2.this.f11697d < itemCount - 1) {
                H.f0(viewPager2, new c.a(i6, null), null, this.f11721b);
            }
            if (ViewPager2.this.f11697d > 0) {
                H.f0(viewPager2, new c.a(i5, null), null, this.f11722c);
            }
        }
    }

    public interface k {
    }

    private class l extends PagerSnapHelper {
        l() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    private class m extends RecyclerView {
        m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f11713t.d() ? ViewPager2.this.f11713t.n() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f11697d);
            accessibilityEvent.setToIndex(ViewPager2.this.f11697d);
            ViewPager2.this.f11713t.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    private static class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final int f11733a;

        /* renamed from: b, reason: collision with root package name */
        private final RecyclerView f11734b;

        o(int i5, RecyclerView recyclerView) {
            this.f11733a = i5;
            this.f11734b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11734b.smoothScrollToPosition(this.f11733a);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11694a = new Rect();
        this.f11695b = new Rect();
        this.f11696c = new androidx.viewpager2.widget.b(3);
        this.f11698e = false;
        this.f11699f = new a();
        this.f11701h = -1;
        this.f11709p = null;
        this.f11710q = false;
        this.f11711r = true;
        this.f11712s = -1;
        b(context, attributeSet);
    }

    private RecyclerView.OnChildAttachStateChangeListener a() {
        return new d();
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f11713t = f11693u ? new j() : new f();
        m mVar = new m(context);
        this.f11703j = mVar;
        mVar.setId(H.j());
        this.f11703j.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.f11700g = hVar;
        this.f11703j.setLayoutManager(hVar);
        this.f11703j.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f11703j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f11703j.addOnChildAttachStateChangeListener(a());
        androidx.viewpager2.widget.e eVar = new androidx.viewpager2.widget.e(this);
        this.f11705l = eVar;
        this.f11707n = new androidx.viewpager2.widget.c(this, eVar, this.f11703j);
        l lVar = new l();
        this.f11704k = lVar;
        lVar.attachToRecyclerView(this.f11703j);
        this.f11703j.addOnScrollListener(this.f11705l);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.f11706m = bVar;
        this.f11705l.m(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f11706m.d(bVar2);
        this.f11706m.d(cVar);
        this.f11713t.h(this.f11706m, this.f11703j);
        this.f11706m.d(this.f11696c);
        androidx.viewpager2.widget.d dVar = new androidx.viewpager2.widget.d(this.f11700g);
        this.f11708o = dVar;
        this.f11706m.d(dVar);
        RecyclerView recyclerView = this.f11703j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void f(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f11699f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        RecyclerView.Adapter adapter;
        if (this.f11701h == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f11702i;
        if (parcelable != null) {
            if (adapter instanceof InterfaceC0795a) {
                ((InterfaceC0795a) adapter).b(parcelable);
            }
            this.f11702i = null;
        }
        int iMax = Math.max(0, Math.min(this.f11701h, adapter.getItemCount() - 1));
        this.f11697d = iMax;
        this.f11701h = -1;
        this.f11703j.scrollToPosition(iMax);
        this.f11713t.m();
    }

    private void l(Context context, AttributeSet attributeSet) {
        int[] iArr = C0776a.f17629g;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(C0776a.f17630h, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void m(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f11699f);
        }
    }

    public boolean c() {
        return this.f11707n.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i5) {
        return this.f11703j.canScrollHorizontally(i5);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i5) {
        return this.f11703j.canScrollVertically(i5);
    }

    boolean d() {
        return this.f11700g.getLayoutDirection() == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof n) {
            int i5 = ((n) parcelable).f11730a;
            sparseArray.put(this.f11703j.getId(), sparseArray.get(i5));
            sparseArray.remove(i5);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f11711r;
    }

    public void g(i iVar) {
        this.f11696c.d(iVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.f11713t.a() ? this.f11713t.g() : super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f11703j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f11697d;
    }

    public int getItemDecorationCount() {
        return this.f11703j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f11712s;
    }

    public int getOrientation() {
        return this.f11700g.getOrientation();
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f11703j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f11705l.f();
    }

    public void h() {
        this.f11708o.d();
    }

    public void j(int i5, boolean z5) {
        if (c()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        k(i5, z5);
    }

    void k(int i5, boolean z5) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f11701h != -1) {
                this.f11701h = Math.max(i5, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i5, 0), adapter.getItemCount() - 1);
        if (iMin == this.f11697d && this.f11705l.h()) {
            return;
        }
        int i6 = this.f11697d;
        if (iMin == i6 && z5) {
            return;
        }
        double dE = i6;
        this.f11697d = iMin;
        this.f11713t.q();
        if (!this.f11705l.h()) {
            dE = this.f11705l.e();
        }
        this.f11705l.k(iMin, z5);
        if (!z5) {
            this.f11703j.scrollToPosition(iMin);
            return;
        }
        double d6 = iMin;
        if (Math.abs(d6 - dE) <= 3.0d) {
            this.f11703j.smoothScrollToPosition(iMin);
            return;
        }
        this.f11703j.scrollToPosition(d6 > dE ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.f11703j;
        recyclerView.post(new o(iMin, recyclerView));
    }

    void n() {
        PagerSnapHelper pagerSnapHelper = this.f11704k;
        if (pagerSnapHelper == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewFindSnapView = pagerSnapHelper.findSnapView(this.f11700g);
        if (viewFindSnapView == null) {
            return;
        }
        int position = this.f11700g.getPosition(viewFindSnapView);
        if (position != this.f11697d && getScrollState() == 0) {
            this.f11706m.c(position);
        }
        this.f11698e = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f11713t.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int measuredWidth = this.f11703j.getMeasuredWidth();
        int measuredHeight = this.f11703j.getMeasuredHeight();
        this.f11694a.left = getPaddingLeft();
        this.f11694a.right = (i7 - i5) - getPaddingRight();
        this.f11694a.top = getPaddingTop();
        this.f11694a.bottom = (i8 - i6) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f11694a, this.f11695b);
        RecyclerView recyclerView = this.f11703j;
        Rect rect = this.f11695b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f11698e) {
            n();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        measureChild(this.f11703j, i5, i6);
        int measuredWidth = this.f11703j.getMeasuredWidth();
        int measuredHeight = this.f11703j.getMeasuredHeight();
        int measuredState = this.f11703j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i5, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i6, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof n)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        n nVar = (n) parcelable;
        super.onRestoreInstanceState(nVar.getSuperState());
        this.f11701h = nVar.f11731b;
        this.f11702i = nVar.f11732c;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        n nVar = new n(super.onSaveInstanceState());
        nVar.f11730a = this.f11703j.getId();
        int i5 = this.f11701h;
        if (i5 == -1) {
            i5 = this.f11697d;
        }
        nVar.f11731b = i5;
        Parcelable parcelable = this.f11702i;
        if (parcelable != null) {
            nVar.f11732c = parcelable;
            return nVar;
        }
        Object adapter = this.f11703j.getAdapter();
        if (adapter instanceof InterfaceC0795a) {
            nVar.f11732c = ((InterfaceC0795a) adapter).a();
        }
        return nVar;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i5, Bundle bundle) {
        return this.f11713t.c(i5, bundle) ? this.f11713t.l(i5, bundle) : super.performAccessibilityAction(i5, bundle);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f11703j.getAdapter();
        this.f11713t.f(adapter2);
        m(adapter2);
        this.f11703j.setAdapter(adapter);
        this.f11697d = 0;
        i();
        this.f11713t.e(adapter);
        f(adapter);
    }

    public void setCurrentItem(int i5) {
        j(i5, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i5) {
        super.setLayoutDirection(i5);
        this.f11713t.p();
    }

    public void setOffscreenPageLimit(int i5) {
        if (i5 < 1 && i5 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f11712s = i5;
        this.f11703j.requestLayout();
    }

    public void setOrientation(int i5) {
        this.f11700g.setOrientation(i5);
        this.f11713t.r();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.f11710q) {
                this.f11709p = this.f11703j.getItemAnimator();
                this.f11710q = true;
            }
            this.f11703j.setItemAnimator(null);
        } else if (this.f11710q) {
            this.f11703j.setItemAnimator(this.f11709p);
            this.f11709p = null;
            this.f11710q = false;
        }
        this.f11708o.d();
        if (kVar == null) {
            return;
        }
        this.f11708o.e(kVar);
        h();
    }

    public void setUserInputEnabled(boolean z5) {
        this.f11711r = z5;
        this.f11713t.s();
    }

    static class n extends View.BaseSavedState {
        public static final Parcelable.Creator<n> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f11730a;

        /* renamed from: b, reason: collision with root package name */
        int f11731b;

        /* renamed from: c, reason: collision with root package name */
        Parcelable f11732c;

        static class a implements Parcelable.ClassLoaderCreator<n> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new n(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public n[] newArray(int i5) {
                return new n[i5];
            }
        }

        n(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f11730a = parcel.readInt();
            this.f11731b = parcel.readInt();
            this.f11732c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f11730a);
            parcel.writeInt(this.f11731b);
            parcel.writeParcelable(this.f11732c, i5);
        }

        n(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
