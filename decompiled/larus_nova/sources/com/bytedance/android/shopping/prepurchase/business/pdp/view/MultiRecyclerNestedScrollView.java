package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/MultiRecyclerNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "getMainFeedDefaultVisibleHeight", "Lkotlin/Function1;", "", "listener", "setOnScrollDistanceChangeListener", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "getCoverAreaHeight", "()Lkotlin/jvm/functions/Function0;", "setCoverAreaHeight", "(Lkotlin/jvm/functions/Function0;)V", "coverAreaHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiRecyclerNestedScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f182245n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f182246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f182247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f182248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f182249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Pair<? extends Object, Integer> f182250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Integer> f182251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f182252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f182253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f182254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MultiRecyclerNestedScrollView$topViewScrollChangeListener$1 f182255j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f182256k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super Integer, Unit> f182257l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MultiRecyclerNestedScrollView$bottomViewScrollChangeListener$1 f182258m;

    public static final class a implements NestedScrollView.OnScrollChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiRecyclerNestedScrollView f182259a;

        public a(MultiRecyclerNestedScrollView r100) {
            this.f182259a = r100;
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public final void onScrollChange(NestedScrollView r100, int r101, int r102, int r103, int r104) {
            MultiRecyclerNestedScrollView r105 = this.f182259a;
            r105.f182252g = r102;
            MultiRecyclerNestedScrollView.f(r105);
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f182261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MultiRecyclerNestedScrollView f182262b;

        public c(RecyclerView r100, MultiRecyclerNestedScrollView r101) {
            this.f182261a = r100;
            this.f182262b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            if (this.f182261a.getHeight() <= 0) goto L10;
            this.f182261a.removeOnLayoutChangeListener(this);
            MultiRecyclerNestedScrollView r109 = this.f182262b;
            r109.smoothScrollTo(0, MultiRecyclerNestedScrollView.e(r109));
            RecyclerView r110 = this.f182262b.f182247b;
            if (r110 != null) goto L7;
            return;
        L7:
            if (r110.canScrollVertically(1) != true) goto L12;
            MultiRecyclerNestedScrollView r111 = this.f182262b;
            r111.j(r111.f182247b);
            return;
        L12:
            return;
        }
    }

    static {
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return false;
    }

    private final int getMainFeedDefaultVisibleHeight() {
        RecyclerView r100 = this.f182247b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.getHeight();
    L6:
        Function0<Integer> r103 = this.f182251f;
        if (r103 == null) goto L12;
        Integer r104 = r103.invoke();
        if (r104 == null) goto L12;
        r101 = r104.intValue();
    L12:
        return r102 - r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean h() {
        RecyclerView r100 = this.f182247b;
        if (r100 != null) goto L5;
    L6:
        RecyclerView r101 = this.f182247b;
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if (r101.canScrollVertically(-1) != true) goto L11;
        return true;
    L5:
        if (r100.canScrollVertically(1) != true) goto L6;
        return true;
    }

    public final void k() {
        RecyclerView r100 = this.f182247b;
        if (r100 == null) goto L5;
        r100.stopScroll();
    L5:
        RecyclerView r101 = this.f182248c;
        if (r101 == null) goto L8;
        r101.stopScroll();
    L8:
        j(this.f182247b);
        RecyclerView r102 = this.f182248c;
        if (r102 == null) goto L12;
        r102.scrollToPosition(0);
    L12:
        if (Intrinsics.areEqual(r102, this.f182247b) == false) goto L15;
        this.f182253h = 0;
    L15:
        if (Intrinsics.areEqual(r102, this.f182248c) == false) goto L17;
        this.f182254i = 0;
    L17:
        RecyclerView r103 = this.f182248c;
        if (r103 != null) goto L20;
        return;
    L20:
        if (r103.getHeight() <= 0) goto L22;
        scrollTo(0, getMainFeedDefaultVisibleHeight());
        return;
    L22:
        r103.addOnLayoutChangeListener(new c(r103, this));
    }

    public final boolean i() {
        if (getScrollY() >= getMainFeedDefaultVisibleHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Function0<Integer> getCoverAreaHeight() {
        return this.f182251f;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.prepurchase.business.pdp.view.MultiRecyclerNestedScrollView$topViewScrollChangeListener$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.shopping.prepurchase.business.pdp.view.MultiRecyclerNestedScrollView$bottomViewScrollChangeListener$1] */
    public MultiRecyclerNestedScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f182255j = new MultiRecyclerNestedScrollView$topViewScrollChangeListener$1(this);
        this.f182256k = new int[2];
        this.f182258m = new MultiRecyclerNestedScrollView$bottomViewScrollChangeListener$1(this);
        m r101 = new m(r100);
        this.f182246a = r101;
        Unit r102 = Unit.INSTANCE;
        addView(r101, -1, -2);
        setOnScrollChangeListener(new a(this));
    }

    public static final /* synthetic */ int e(MultiRecyclerNestedScrollView r100) {
        return r100.getMainFeedDefaultVisibleHeight();
    }

    public static final void f(MultiRecyclerNestedScrollView r100) {
        RecyclerView r101 = r100.f182247b;
        RecyclerView.LayoutManager r102 = null;
        if (r101 == null) goto L5;
        RecyclerView.LayoutManager r103 = r101.getLayoutManager();
    L7:
        if ((r103 instanceof StaggeredGridLayoutManager) == false) goto L10;
        r102 = r103;
    L10:
        StaggeredGridLayoutManager r104 = (StaggeredGridLayoutManager) r102;
        Intrinsics.checkNotNull(r104);
        int r105 = r104.findFirstVisibleItemPositions(r100.f182256k)[0];
        if (r105 == 0) goto L13;
    L19:
        int r106 = (r100.f182252g + r100.f182253h) + r100.f182254i;
        Function1<? super Integer, Unit> r107 = r100.f182257l;
        if (r107 == null) goto L23;
        Unit r108 = r107.invoke(Integer.valueOf(r106));
        return;
    L23:
        return;
    L13:
        if (r100.h() == true) goto L15;
        r100.f182253h = 0;
    L18:
        r100.f182254i = 0;
        goto L19
    L15:
        View r109 = r104.findViewByPosition(r105);
        if (r109 == null) goto L18;
        r100.f182253h = Math.abs(r109.getTop());
        goto L18
    L5:
        r103 = null;
        goto L7
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        boolean r101 = super.canScrollVertically(r100);
        if (r100 >= 0) goto L17;
        if (r101 == false) goto L6;
        return r101;
    L6:
        if (this.f182249d == false) goto L19;
        RecyclerView r102 = this.f182248c;
        if (r102 != null) goto L10;
    L11:
        RecyclerView r103 = this.f182247b;
        if (r103 != null) goto L14;
        return r101;
    L14:
        if (r103.canScrollVertically(r100) != true) goto L21;
    L15:
        return true;
    L21:
        return r101;
    L10:
        if (r102.canScrollVertically(r100) == true) goto L15;
    L19:
        return r101;
    L17:
        return r101;
    }

    public final void j(RecyclerView r100) {
        if (r100 == null) goto L16;
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 == null) goto L17;
        r100.scrollToPosition(Integer.valueOf(r101.getItemCount() - 1).intValue());
        if (r100.canScrollVertically(-1) == false) goto L8;
        int r102 = 100000;
    L10:
        if (Intrinsics.areEqual(r100, this.f182248c) == false) goto L13;
        this.f182254i = r102;
    L13:
        if (Intrinsics.areEqual(r100, this.f182247b) == false) goto L18;
        this.f182253h = r102;
        return;
    L18:
        return;
    L8:
        r102 = 0;
        goto L10
    L17:
        return;
    }

    public final void setCoverAreaHeight(Function0<Integer> r100) {
        this.f182251f = r100;
    }

    public final void setOnScrollDistanceChangeListener(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f182257l = r100;
    }

    public final void l(int r100, int r101) {
        int r102 = 0;
        scrollTo(0, 0);
        RecyclerView r103 = this.f182247b;
        RecyclerView.LayoutManager r104 = null;
        if (r103 == null) goto L5;
        RecyclerView.LayoutManager r105 = r103.getLayoutManager();
    L7:
        if ((r105 instanceof StaggeredGridLayoutManager) == false) goto L10;
        r104 = r105;
    L10:
        StaggeredGridLayoutManager r106 = (StaggeredGridLayoutManager) r104;
        if (r106 == null) goto L13;
        r106.scrollToPositionWithOffset(r100, r101);
    L13:
        RecyclerView r107 = this.f182248c;
        if (r107 == null) goto L17;
        r107.scrollToPosition(0);
    L17:
        if (Intrinsics.areEqual(r107, this.f182247b) == false) goto L20;
        this.f182253h = 0;
    L20:
        if (Intrinsics.areEqual(r107, this.f182248c) == false) goto L22;
        this.f182254i = 0;
    L22:
        if (r100 == 0) goto L25;
        r102 = 100000;
    L25:
        this.f182253h = r102;
        return;
    L5:
        r105 = null;
        goto L7
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        this.f182246a.setChildMaxHeight(Integer.valueOf((View.MeasureSpec.getSize(r101) - getPaddingTop()) - getPaddingBottom()));
        super.onMeasure(r100, r101);
    }

    public static final void g(MultiRecyclerNestedScrollView r100, View r101, int r102) {
        Pair<? extends Object, Integer> r103 = r100.f182250e;
        if (r103 == null) goto L5;
        Object r104 = r103.getFirst();
    L6:
        Pair<? extends Object, Integer> r105 = r100.f182250e;
        if (r105 == null) goto L9;
        Integer r106 = r105.getSecond();
    L11:
        if (r102 == 0) goto L27;
        if (r102 != 1) goto L14;
        if (r106 != null) goto L24;
    L25:
        r100.f182250e = new Pair(r101, Integer.valueOf(r102));
        return;
    L24:
        if (r106.intValue() != 1) goto L25;
        return;
    L14:
        if (r102 == 2) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(r104, r101) == false) goto L19;
    L20:
        r100.f182250e = new Pair(r101, Integer.valueOf(r102));
        return;
    L19:
        if (r100.f182250e == null) goto L20;
        return;
    L27:
        if ((!Intrinsics.areEqual(r104, r101)) == true) goto L36;
        r100.f182250e = null;
        return;
    L36:
        return;
    L9:
        r106 = null;
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r103 != 0) goto L25;
        Pair<? extends Object, Integer> r104 = this.f182250e;
        if (r104 == null) goto L7;
        Object r105 = r104.getFirst();
    L9:
        if ((!Intrinsics.areEqual(r105, r101)) == false) goto L25;
        Pair<? extends Object, Integer> r106 = this.f182250e;
        if (r106 == null) goto L25;
        if (r106.getSecond().intValue() != 2) goto L25;
        Pair<? extends Object, Integer> r107 = this.f182250e;
        if (r107 == null) goto L17;
        Object r108 = r107.getFirst();
    L19:
        if ((r108 instanceof RecyclerView) == true) goto L21;
        r108 = null;
    L21:
        RecyclerView r109 = (RecyclerView) r108;
        if (r109 == null) goto L24;
        r109.stopScroll();
    L24:
        this.f182250e = null;
        goto L25
    L17:
        r108 = null;
        goto L19
    L7:
        r105 = null;
    L25:
        super.onNestedScrollAccepted(r100, r101, r102, r103);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        Pair<? extends Object, Integer> r105 = this.f182250e;
        if (r105 == null) goto L5;
        Object r106 = r105.getFirst();
    L7:
        if ((!Intrinsics.areEqual(r106, r100)) == false) goto L15;
        r103[1] = r102;
        if ((r100 instanceof RecyclerView) == true) goto L11;
        r100 = null;
    L11:
        RecyclerView r107 = (RecyclerView) r100;
        if (r107 == null) goto L28;
        r107.stopScroll();
        return;
    L28:
        return;
    L15:
        this.f182249d = true;
        super.onNestedPreScroll(r100, r101, r102, r103, r104);
        this.f182249d = false;
        int r108 = r102 - r103[1];
        if (r108 >= 0) goto L23;
        if (Intrinsics.areEqual(r100, this.f182247b) == true) goto L20;
        return;
    L20:
        if (canScrollVertically(-1) == false) goto L30;
        int r109 = getScrollY();
        scrollBy(0, r108);
        r103[1] = r103[1] + (getScrollY() - r109);
        return;
    L30:
        return;
    L23:
        if (Intrinsics.areEqual(r100, this.f182248c) == true) goto L25;
        return;
    L25:
        if (canScrollVertically(1) == false) goto L33;
        int r110 = getScrollY();
        scrollBy(0, r108);
        r103[1] = r103[1] + (getScrollY() - r110);
        return;
    L33:
        return;
    L5:
        r106 = null;
        goto L7
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r106, "consumed");
        super.onNestedScroll(r100, r101, r102, r103, r104, r105, r106);
        int r107 = r104 - r106[1];
        if (Intrinsics.areEqual(r100, this.f182247b) == false) goto L14;
        if (r107 <= 0) goto L14;
        RecyclerView r108 = this.f182248c;
        if (r108 == null) goto L14;
        if (r108.canScrollVertically(r107) != true) goto L14;
        RecyclerView r109 = this.f182248c;
        if (r109 == null) goto L12;
        r109.scrollBy(0, r107);
    L12:
        r106[1] = r106[1] + r107;
        return;
    L14:
        if (Intrinsics.areEqual(r100, this.f182248c) == false) goto L26;
        if (r107 >= 0) goto L27;
        RecyclerView r110 = this.f182247b;
        if (r110 != null) goto L19;
        return;
    L19:
        if (r110.canScrollVertically(r107) != true) goto L29;
        RecyclerView r111 = this.f182247b;
        if (r111 == null) goto L23;
        r111.scrollBy(0, r107);
    L23:
        r106[1] = r106[1] + r107;
        return;
    L29:
        return;
    L27:
        return;
    }
}
