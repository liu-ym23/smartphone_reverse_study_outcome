package com.bytedance.android.shopping.deepfeed.ui;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductOverScrollPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductOverScrollPagerSnapHelper extends PagerSnapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f173723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f173724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f173725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f173726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f173727e;

    public DeepFeedProductOverScrollPagerSnapHelper() {
        Resources r100 = Resources.getSystem();
        this.f173724b = MathKt.roundToInt(TypedValue.applyDimension(1, 35, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
    }

    public final void a(RecyclerView.LayoutManager r100) {
        View r101 = r100.findViewByPosition(r100.getItemCount() - 2);
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r100.getWidth() - r100.getDecoratedLeft(r101)) > this.f173724b) goto L7;
        return;
    L7:
        if (this.f173727e == true) goto L14;
        this.f173727e = true;
        e r102 = this.f173723a;
        if (r102 == null) goto L15;
        r102.g();
        return;
    L15:
        return;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final View findSnapView(RecyclerView.LayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        if (this.f173725c == false) goto L5;
    L9:
        a(r100);
        if (this.f173727e == true) goto L12;
        int r101 = r100.getItemCount() - 2;
        View r102 = super.findSnapView(r100);
        if (r102 != null) goto L18;
        return null;
    L18:
        if (r100.getPosition(r102) == r101) goto L20;
        return r102;
    L20:
        return r100.findViewByPosition(r101 - 1);
    L12:
        return r100.findViewByPosition(r100.getItemCount() - 1);
    L5:
        if (this.f173726d == true) goto L9;
        return super.findSnapView(r100);
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final int findTargetSnapPosition(RecyclerView.LayoutManager r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        if (this.f173725c == false) goto L5;
    L9:
        a(r100);
        if (this.f173727e == true) goto L12;
        int r103 = super.findTargetSnapPosition(r100, r101, r102);
        if (r103 == (r100.getItemCount() - 2)) goto L16;
        return r103;
    L16:
        return r103 - 1;
    L12:
        return r100.getItemCount() - 1;
    L5:
        if (this.f173726d == true) goto L9;
        return super.findTargetSnapPosition(r100, r101, r102);
    }
}
