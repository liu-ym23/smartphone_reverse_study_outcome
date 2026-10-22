package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/BasePdpNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "b", "Landroidx/recyclerview/widget/RecyclerView;", "getRvTop", "()Landroidx/recyclerview/widget/RecyclerView;", "setRvTop", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rvTop", "c", "getRvBottom", "setRvBottom", "rvBottom", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BasePdpNestedScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f170134g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f170135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f170136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f170137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f170138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Pair<? extends Object, Integer> f170139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BasePdpNestedScrollView$onScrollChangeListener$1 f170140f;

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return false;
    }

    public final RecyclerView getRvBottom() {
        return this.f170137c;
    }

    public final RecyclerView getRvTop() {
        return this.f170136b;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.anchorv4.widgets.BasePdpNestedScrollView$onScrollChangeListener$1] */
    public BasePdpNestedScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f170140f = new BasePdpNestedScrollView$onScrollChangeListener$1(this);
        c r101 = new c(r100);
        this.f170135a = r101;
        Unit r102 = Unit.INSTANCE;
        addView(r101, -1, -2);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        boolean r101 = super.canScrollVertically(r100);
        if (r100 >= 0) goto L17;
        if (r101 == false) goto L6;
        return r101;
    L6:
        if (this.f170138d == false) goto L19;
        RecyclerView r102 = this.f170137c;
        if (r102 != null) goto L10;
    L11:
        RecyclerView r103 = this.f170136b;
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

    public final void e(RecyclerView r100) {
        if (r100 == null) goto L7;
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 == null) goto L8;
        r100.scrollToPosition(Integer.valueOf(r101.getItemCount() - 1).intValue());
        return;
    L8:
        return;
    }

    public final void setRvBottom(RecyclerView r100) {
        this.f170137c = r100;
    }

    public final void setRvTop(RecyclerView r100) {
        this.f170136b = r100;
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        c r102 = this.f170135a;
        r102.f170182a = Integer.valueOf((View.MeasureSpec.getSize(r101) - getPaddingTop()) - getPaddingBottom());
        super.onMeasure(r100, r101);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r103 != 0) goto L25;
        Pair<? extends Object, Integer> r104 = this.f170139e;
        if (r104 == null) goto L7;
        Object r105 = r104.getFirst();
    L9:
        if ((!Intrinsics.areEqual(r105, r101)) == false) goto L25;
        Pair<? extends Object, Integer> r106 = this.f170139e;
        if (r106 == null) goto L25;
        if (r106.getSecond().intValue() != 2) goto L25;
        Pair<? extends Object, Integer> r107 = this.f170139e;
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
        this.f170139e = null;
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
        Pair<? extends Object, Integer> r105 = this.f170139e;
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
        this.f170138d = true;
        super.onNestedPreScroll(r100, r101, r102, r103, r104);
        this.f170138d = false;
        int r108 = r102 - r103[1];
        if (r108 >= 0) goto L23;
        if (Intrinsics.areEqual(r100, this.f170136b) == true) goto L20;
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
        if (Intrinsics.areEqual(r100, this.f170137c) == true) goto L25;
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
        if (Intrinsics.areEqual(r100, this.f170136b) == false) goto L14;
        if (r107 <= 0) goto L14;
        RecyclerView r108 = this.f170137c;
        if (r108 == null) goto L14;
        if (r108.canScrollVertically(r107) != true) goto L14;
        RecyclerView r109 = this.f170137c;
        if (r109 == null) goto L12;
        r109.scrollBy(0, r107);
    L12:
        r106[1] = r106[1] + r107;
        return;
    L14:
        if (Intrinsics.areEqual(r100, this.f170137c) == false) goto L26;
        if (r107 >= 0) goto L27;
        RecyclerView r110 = this.f170136b;
        if (r110 != null) goto L19;
        return;
    L19:
        if (r110.canScrollVertically(r107) != true) goto L29;
        RecyclerView r111 = this.f170136b;
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
