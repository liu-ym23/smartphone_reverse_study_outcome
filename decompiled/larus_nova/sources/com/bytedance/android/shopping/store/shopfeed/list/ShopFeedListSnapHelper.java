package com.bytedance.android.shopping.store.shopfeed.list;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedListSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "Landroid/content/Context;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFeedListSnapHelper extends PagerSnapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f186201a;

    public final Context getContext() {
        return this.f186201a;
    }

    public ShopFeedListSnapHelper(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f186201a = r100;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        int[] r102 = new int[2];
        if (r100.canScrollHorizontally() == false) goto L5;
        OrientationHelper r103 = OrientationHelper.createHorizontalHelper(r100);
        r102[0] = r103.getDecoratedStart(r101) - r103.getStartAfterPadding();
    L7:
        if (r100.canScrollVertically() == false) goto L9;
        OrientationHelper r104 = OrientationHelper.createVerticalHelper(r100);
        r102[1] = r104.getDecoratedStart(r101) - r104.getStartAfterPadding();
    L10:
        return r102;
    L9:
        r102[1] = 0;
        goto L10
    L5:
        r102[0] = 0;
        goto L7
    }
}
