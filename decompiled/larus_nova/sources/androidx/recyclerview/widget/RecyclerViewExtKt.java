package androidx.recyclerview.widget;

import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"smoothScrollBy", "", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "interpolator", "Landroid/view/animation/Interpolator;", "duration", "withNestedScrolling", "", "ec-biz-store-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class RecyclerViewExtKt {
    public static final void smoothScrollBy(RecyclerView r100, int r101, int r110, Interpolator r111, int r112) {
        smoothScrollBy$default(r100, r101, r110, r111, r112, false, 16, null);
    }

    public static final void smoothScrollBy(RecyclerView r100, int r101, int r102, Interpolator r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "$this$smoothScrollBy");
        RecyclerView.LayoutManager r106 = r100.getLayoutManager();
        if (r106 != null) goto L6;
        return;
    L6:
        if (r100.isLayoutFrozen() == false) goto L8;
        return;
    L8:
        int r107 = 0;
        if (r106.canScrollHorizontally() == true) goto L12;
        r101 = 0;
    L12:
        if (r106.canScrollVertically() == true) goto L14;
        r102 = 0;
    L14:
        if (r101 != 0) goto L17;
        if (r102 != 0) goto L17;
        return;
    L17:
        if (r104 == Integer.MIN_VALUE) goto L21;
        if (r104 > 0) goto L21;
        boolean r108 = false;
    L22:
        if (r108 == false) goto L30;
        if (r105 == false) goto L29;
        if (r101 == 0) goto L26;
        r107 = 1;
    L26:
        if (r102 == 0) goto L28;
        r107 = r107 | 2;
    L28:
        r100.startNestedScroll(r107, 1);
    L29:
        r100.mViewFlinger.smoothScrollBy(r101, r102, r104, r103);
        return;
    L30:
        r100.scrollBy(r101, r102);
        return;
    L21:
        r108 = true;
        goto L22
    }

    public static /* synthetic */ void smoothScrollBy$default(RecyclerView r100, int r101, int r102, Interpolator r103, int r110, boolean r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r104 = false;
    L6:
        smoothScrollBy(r100, r101, r102, r103, r110, r104);
        return;
    L5:
        r104 = r111;
        goto L6
    }
}
