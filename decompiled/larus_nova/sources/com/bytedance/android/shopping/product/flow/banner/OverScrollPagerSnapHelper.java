package com.bytedance.android.shopping.product.flow.banner;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yg3.e;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OverScrollPagerSnapHelper extends PagerSnapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f182344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f182345b;

    public OverScrollPagerSnapHelper() {
        Resources r100 = Resources.getSystem();
        this.f182345b = MathKt.roundToInt(TypedValue.applyDimension(1, 60, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
    }

    public final void a(RecyclerView.LayoutManager r100) {
        View r101 = r100.findViewByPosition(r100.getItemCount() - 1);
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r100.getWidth() - r100.getDecoratedLeft(r101)) <= this.f182345b) goto L11;
        e r102 = this.f182344a;
        if (r102 == null) goto L12;
        r102.g();
        return;
    L12:
        return;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final View findSnapView(RecyclerView.LayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        a(r100);
        int r101 = r100.getItemCount() - 1;
        View r102 = super.findSnapView(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r100.getPosition(r102) == r101) goto L9;
        return r102;
    L9:
        return r100.findViewByPosition(r101 - 1);
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final int findTargetSnapPosition(RecyclerView.LayoutManager r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        a(r100);
        int r103 = super.findTargetSnapPosition(r100, r101, r102);
        if (r103 == (r100.getItemCount() - 1)) goto L5;
        return r103;
    L5:
        return r103 - 1;
    }
}
