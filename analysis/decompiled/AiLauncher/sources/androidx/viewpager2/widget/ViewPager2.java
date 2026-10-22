package androidx.viewpager2.widget;

import C0.c;
import C0.f;
import android.R;
import android.annotation.SuppressLint;
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
import androidx.core.view.N;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import io.requery.android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: u, reason: collision with root package name */
    public static boolean f15095u = true;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f15096a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f15097b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.viewpager2.widget.b f15098c;

    /* renamed from: d, reason: collision with root package name */
    public int f15099d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15100e;

    /* renamed from: f, reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f15101f;

    /* renamed from: g, reason: collision with root package name */
    public LinearLayoutManager f15102g;

    /* renamed from: h, reason: collision with root package name */
    public int f15103h;

    /* renamed from: i, reason: collision with root package name */
    public Parcelable f15104i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f15105j;

    /* renamed from: k, reason: collision with root package name */
    public PagerSnapHelper f15106k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.viewpager2.widget.f f15107l;

    /* renamed from: m, reason: collision with root package name */
    public androidx.viewpager2.widget.b f15108m;

    /* renamed from: n, reason: collision with root package name */
    public androidx.viewpager2.widget.c f15109n;

    /* renamed from: o, reason: collision with root package name */
    public androidx.viewpager2.widget.e f15110o;

    /* renamed from: p, reason: collision with root package name */
    public RecyclerView.ItemAnimator f15111p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f15112q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f15113r;

    /* renamed from: s, reason: collision with root package name */
    public int f15114s;

    /* renamed from: t, reason: collision with root package name */
    public e f15115t;

    public class a extends g {
        public a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f15100e = true;
            viewPager2.f15107l.l();
        }
    }

    public class b extends i {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int i10) {
            if (i10 == 0) {
                ViewPager2.this.s();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int i10) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f15099d != i10) {
                viewPager2.f15099d = i10;
                viewPager2.f15115t.r();
            }
        }
    }

    public class c extends i {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f15105j.requestFocus(2);
            }
        }
    }

    public class d implements RecyclerView.OnChildAttachStateChangeListener {
        public d() {
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

    public abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int i10) {
            return false;
        }

        public boolean c(int i10, Bundle bundle) {
            return false;
        }

        public boolean d() {
            return false;
        }

        public void e(RecyclerView.Adapter<?> adapter) {
        }

        public void f(RecyclerView.Adapter<?> adapter) {
        }

        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void j(C0.c cVar) {
        }

        public void k(View view, C0.c cVar) {
        }

        public boolean l(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean m(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public void n() {
        }

        public CharSequence o() {
            throw new IllegalStateException("Not implemented.");
        }

        public void p(AccessibilityEvent accessibilityEvent) {
        }

        public void q() {
        }

        public void r() {
        }

        public void s() {
        }

        public void t() {
        }

        public /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }
    }

    public class f extends e {
        public f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i10) {
            return (i10 == 8192 || i10 == 4096) && !ViewPager2.this.h();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(C0.c cVar) {
            if (ViewPager2.this.h()) {
                return;
            }
            cVar.f0(c.a.f1663r);
            cVar.f0(c.a.f1662q);
            cVar.I0(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i10) {
            if (b(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence o() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    public static abstract class g extends RecyclerView.AdapterDataObserver {
        public g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i10, int i11, int i12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11, Object obj) {
            onChanged();
        }
    }

    public class h extends LinearLayoutManager {
        public h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, cVar);
            ViewPager2.this.f15115t.j(cVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, C0.c cVar) {
            ViewPager2.this.f15115t.k(view, cVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i10, Bundle bundle) {
            return ViewPager2.this.f15115t.b(i10) ? ViewPager2.this.f15115t.l(i10) : super.performAccessibilityAction(recycler, state, i10, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return false;
        }
    }

    public static abstract class i {
        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, int i11) {
        }

        public void onPageSelected(int i10) {
        }
    }

    public class j extends e {

        /* renamed from: b, reason: collision with root package name */
        public final C0.f f15123b;

        /* renamed from: c, reason: collision with root package name */
        public final C0.f f15124c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView.AdapterDataObserver f15125d;

        public class a implements C0.f {
            public a() {
            }

            @Override // C0.f
            public boolean a(View view, f.a aVar) {
                j.this.x(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        public class b implements C0.f {
            public b() {
            }

            @Override // C0.f
            public boolean a(View view, f.a aVar) {
                j.this.x(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        public class c extends g {
            public c() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                j.this.y();
            }
        }

        public j() {
            super(ViewPager2.this, null);
            this.f15123b = new a();
            this.f15124c = new b();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i10, Bundle bundle) {
            return i10 == 8192 || i10 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.Adapter<?> adapter) {
            y();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f15125d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f15125d);
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
            recyclerView.setImportantForAccessibility(2);
            this.f15125d = new c();
            if (ViewPager2.this.getImportantForAccessibility() == 0) {
                ViewPager2.this.setImportantForAccessibility(1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            C0.c cVarS0 = C0.c.S0(accessibilityNodeInfo);
            u(cVarS0);
            w(cVarS0);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void k(View view, C0.c cVar) {
            v(view, cVar);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean m(int i10, Bundle bundle) {
            if (!c(i10, bundle)) {
                throw new IllegalStateException();
            }
            x(i10 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void n() {
            y();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            y();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            y();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            y();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void t() {
            y();
        }

        public final void u(C0.c cVar) {
            int itemCount;
            int itemCount2;
            if (ViewPager2.this.getAdapter() != null) {
                itemCount2 = 1;
                if (ViewPager2.this.getOrientation() == 1) {
                    itemCount2 = ViewPager2.this.getAdapter().getItemCount();
                    itemCount = 1;
                } else {
                    itemCount = ViewPager2.this.getAdapter().getItemCount();
                }
            } else {
                itemCount = 0;
                itemCount2 = 0;
            }
            cVar.o0(c.f.b(itemCount2, itemCount, false, 0));
        }

        public final void v(View view, C0.c cVar) {
            cVar.p0(c.g.a(ViewPager2.this.getOrientation() == 1 ? ViewPager2.this.f15102g.getPosition(view) : 0, 1, ViewPager2.this.getOrientation() == 0 ? ViewPager2.this.f15102g.getPosition(view) : 0, 1, false, false));
        }

        public final void w(C0.c cVar) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.h()) {
                return;
            }
            if (ViewPager2.this.f15099d > 0) {
                cVar.a(com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
            }
            if (ViewPager2.this.f15099d < itemCount - 1) {
                cVar.a(4096);
            }
            cVar.I0(true);
        }

        public void x(int i10) {
            if (ViewPager2.this.h()) {
                ViewPager2.this.n(i10, true);
            }
        }

        public void y() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i10 = R.id.accessibilityActionPageLeft;
            N.b0(viewPager2, R.id.accessibilityActionPageLeft);
            N.b0(viewPager2, R.id.accessibilityActionPageRight);
            N.b0(viewPager2, R.id.accessibilityActionPageUp);
            N.b0(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.h()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f15099d < itemCount - 1) {
                    N.d0(viewPager2, new c.a(R.id.accessibilityActionPageDown, null), null, this.f15123b);
                }
                if (ViewPager2.this.f15099d > 0) {
                    N.d0(viewPager2, new c.a(R.id.accessibilityActionPageUp, null), null, this.f15124c);
                    return;
                }
                return;
            }
            boolean zG = ViewPager2.this.g();
            int i11 = zG ? 16908360 : 16908361;
            if (zG) {
                i10 = 16908361;
            }
            if (ViewPager2.this.f15099d < itemCount - 1) {
                N.d0(viewPager2, new c.a(i11, null), null, this.f15123b);
            }
            if (ViewPager2.this.f15099d > 0) {
                N.d0(viewPager2, new c.a(i10, null), null, this.f15124c);
            }
        }
    }

    public interface k {
        void a(View view, float f10);
    }

    public class l extends PagerSnapHelper {
        public l() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.f()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    public class m extends RecyclerView {
        public m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f15115t.d() ? ViewPager2.this.f15115t.o() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f15099d);
            accessibilityEvent.setToIndex(ViewPager2.this.f15099d);
            ViewPager2.this.f15115t.p(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.h() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.h() && super.onTouchEvent(motionEvent);
        }
    }

    public static class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f15132a;

        /* renamed from: b, reason: collision with root package name */
        public final RecyclerView f15133b;

        public n(int i10, RecyclerView recyclerView) {
            this.f15132a = i10;
            this.f15133b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15133b.smoothScrollToPosition(this.f15132a);
        }
    }

    public ViewPager2(Context context) throws IllegalStateException {
        super(context);
        this.f15096a = new Rect();
        this.f15097b = new Rect();
        this.f15098c = new androidx.viewpager2.widget.b(3);
        this.f15100e = false;
        this.f15101f = new a();
        this.f15103h = -1;
        this.f15111p = null;
        this.f15112q = false;
        this.f15113r = true;
        this.f15114s = -1;
        e(context, null);
    }

    public boolean a() {
        return this.f15109n.b();
    }

    public boolean b() {
        return this.f15109n.d();
    }

    public final RecyclerView.OnChildAttachStateChangeListener c() {
        return new d();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.f15105j.canScrollHorizontally(i10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.f15105j.canScrollVertically(i10);
    }

    public boolean d(@SuppressLint({"SupportAnnotationUsage"}) float f10) {
        return this.f15109n.e(f10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).mRecyclerViewId;
            sparseArray.put(this.f15105j.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        l();
    }

    public final void e(Context context, AttributeSet attributeSet) throws IllegalStateException {
        this.f15115t = f15095u ? new j() : new f();
        m mVar = new m(context);
        this.f15105j = mVar;
        mVar.setId(View.generateViewId());
        this.f15105j.setDescendantFocusability(SQLiteDatabase.OPEN_SHAREDCACHE);
        h hVar = new h(context);
        this.f15102g = hVar;
        this.f15105j.setLayoutManager(hVar);
        this.f15105j.setScrollingTouchSlop(1);
        o(context, attributeSet);
        this.f15105j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f15105j.addOnChildAttachStateChangeListener(c());
        androidx.viewpager2.widget.f fVar = new androidx.viewpager2.widget.f(this);
        this.f15107l = fVar;
        this.f15109n = new androidx.viewpager2.widget.c(this, fVar, this.f15105j);
        l lVar = new l();
        this.f15106k = lVar;
        lVar.attachToRecyclerView(this.f15105j);
        this.f15105j.addOnScrollListener(this.f15107l);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.f15108m = bVar;
        this.f15107l.p(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f15108m.a(bVar2);
        this.f15108m.a(cVar);
        this.f15115t.h(this.f15108m, this.f15105j);
        this.f15108m.a(this.f15098c);
        androidx.viewpager2.widget.e eVar = new androidx.viewpager2.widget.e(this.f15102g);
        this.f15110o = eVar;
        this.f15108m.a(eVar);
        RecyclerView recyclerView = this.f15105j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public boolean f() {
        return this.f15109n.f();
    }

    public boolean g() {
        return this.f15102g.getLayoutDirection() == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.f15115t.a() ? this.f15115t.g() : super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f15105j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f15099d;
    }

    public int getItemDecorationCount() {
        return this.f15105j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f15114s;
    }

    public int getOrientation() {
        return this.f15102g.getOrientation() == 1 ? 1 : 0;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f15105j;
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
        return this.f15107l.f();
    }

    public boolean h() {
        return this.f15113r;
    }

    public final void i(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f15101f);
        }
    }

    public void j(i iVar) {
        this.f15098c.a(iVar);
    }

    public void k() {
        if (this.f15110o.a() == null) {
            return;
        }
        double dE = this.f15107l.e();
        int i10 = (int) dE;
        float f10 = (float) (dE - i10);
        this.f15110o.onPageScrolled(i10, f10, Math.round(getPageSize() * f10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l() {
        RecyclerView.Adapter adapter;
        if (this.f15103h == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f15104i;
        if (parcelable != null) {
            if (adapter instanceof androidx.viewpager2.adapter.c) {
                ((androidx.viewpager2.adapter.c) adapter).b(parcelable);
            }
            this.f15104i = null;
        }
        int iMax = Math.max(0, Math.min(this.f15103h, adapter.getItemCount() - 1));
        this.f15099d = iMax;
        this.f15103h = -1;
        this.f15105j.scrollToPosition(iMax);
        this.f15115t.n();
    }

    public void m(int i10, boolean z10) {
        if (f()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        n(i10, z10);
    }

    public void n(int i10, boolean z10) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f15103h != -1) {
                this.f15103h = Math.max(i10, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i10, 0), adapter.getItemCount() - 1);
        if (iMin == this.f15099d && this.f15107l.i()) {
            return;
        }
        int i11 = this.f15099d;
        if (iMin == i11 && z10) {
            return;
        }
        double dE = i11;
        this.f15099d = iMin;
        this.f15115t.r();
        if (!this.f15107l.i()) {
            dE = this.f15107l.e();
        }
        this.f15107l.n(iMin, z10);
        if (!z10) {
            this.f15105j.scrollToPosition(iMin);
            return;
        }
        double d10 = iMin;
        if (Math.abs(d10 - dE) <= 3.0d) {
            this.f15105j.smoothScrollToPosition(iMin);
            return;
        }
        this.f15105j.scrollToPosition(d10 > dE ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.f15105j;
        recyclerView.post(new n(iMin, recyclerView));
    }

    public final void o(Context context, AttributeSet attributeSet) {
        int[] iArr = R$styleable.ViewPager2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        N.g0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(R$styleable.ViewPager2_android_orientation, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f15115t.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f15105j.getMeasuredWidth();
        int measuredHeight = this.f15105j.getMeasuredHeight();
        this.f15096a.left = getPaddingLeft();
        this.f15096a.right = (i12 - i10) - getPaddingRight();
        this.f15096a.top = getPaddingTop();
        this.f15096a.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f15096a, this.f15097b);
        RecyclerView recyclerView = this.f15105j;
        Rect rect = this.f15097b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f15100e) {
            s();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        measureChild(this.f15105j, i10, i11);
        int measuredWidth = this.f15105j.getMeasuredWidth();
        int measuredHeight = this.f15105j.getMeasuredHeight();
        int measuredState = this.f15105j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f15103h = savedState.mCurrentItem;
        this.f15104i = savedState.mAdapterState;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mRecyclerViewId = this.f15105j.getId();
        int i10 = this.f15103h;
        if (i10 == -1) {
            i10 = this.f15099d;
        }
        savedState.mCurrentItem = i10;
        Parcelable parcelable = this.f15104i;
        if (parcelable != null) {
            savedState.mAdapterState = parcelable;
            return savedState;
        }
        Object adapter = this.f15105j.getAdapter();
        if (adapter instanceof androidx.viewpager2.adapter.c) {
            savedState.mAdapterState = ((androidx.viewpager2.adapter.c) adapter).a();
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public void p() {
        View viewFindSnapView = this.f15106k.findSnapView(this.f15102g);
        if (viewFindSnapView == null) {
            return;
        }
        int[] iArrCalculateDistanceToFinalSnap = this.f15106k.calculateDistanceToFinalSnap(this.f15102g, viewFindSnapView);
        int i10 = iArrCalculateDistanceToFinalSnap[0];
        if (i10 == 0 && iArrCalculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f15105j.smoothScrollBy(i10, iArrCalculateDistanceToFinalSnap[1]);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        return this.f15115t.c(i10, bundle) ? this.f15115t.m(i10, bundle) : super.performAccessibilityAction(i10, bundle);
    }

    public final void q(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f15101f);
        }
    }

    public void r(i iVar) {
        this.f15098c.b(iVar);
    }

    public void s() {
        PagerSnapHelper pagerSnapHelper = this.f15106k;
        if (pagerSnapHelper == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewFindSnapView = pagerSnapHelper.findSnapView(this.f15102g);
        if (viewFindSnapView == null) {
            return;
        }
        int position = this.f15102g.getPosition(viewFindSnapView);
        if (position != this.f15099d && getScrollState() == 0) {
            this.f15108m.onPageSelected(position);
        }
        this.f15100e = false;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f15105j.getAdapter();
        this.f15115t.f(adapter2);
        q(adapter2);
        this.f15105j.setAdapter(adapter);
        this.f15099d = 0;
        l();
        this.f15115t.e(adapter);
        i(adapter);
    }

    public void setCurrentItem(int i10) {
        m(i10, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.f15115t.q();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1 && i10 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f15114s = i10;
        this.f15105j.requestLayout();
    }

    public void setOrientation(int i10) {
        this.f15102g.setOrientation(i10);
        this.f15115t.s();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.f15112q) {
                this.f15111p = this.f15105j.getItemAnimator();
                this.f15112q = true;
            }
            this.f15105j.setItemAnimator(null);
        } else if (this.f15112q) {
            this.f15105j.setItemAnimator(this.f15111p);
            this.f15111p = null;
            this.f15112q = false;
        }
        if (kVar == this.f15110o.a()) {
            return;
        }
        this.f15110o.b(kVar);
        k();
    }

    public void setUserInputEnabled(boolean z10) {
        this.f15113r = z10;
        this.f15115t.t();
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        @SuppressLint({"ClassVerificationFailure"})
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readValues(parcel, classLoader);
        }

        private void readValues(Parcel parcel, ClassLoader classLoader) {
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mRecyclerViewId);
            parcel.writeInt(this.mCurrentItem);
            parcel.writeParcelable(this.mAdapterState, i10);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            readValues(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) throws IllegalStateException {
        super(context, attributeSet);
        this.f15096a = new Rect();
        this.f15097b = new Rect();
        this.f15098c = new androidx.viewpager2.widget.b(3);
        this.f15100e = false;
        this.f15101f = new a();
        this.f15103h = -1;
        this.f15111p = null;
        this.f15112q = false;
        this.f15113r = true;
        this.f15114s = -1;
        e(context, attributeSet);
    }
}
