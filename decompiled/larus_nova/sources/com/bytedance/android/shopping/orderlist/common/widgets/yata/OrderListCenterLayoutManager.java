package com.bytedance.android.shopping.orderlist.common.widgets.yata;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/yata/OrderListCenterLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListCenterLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f180092a;

    public static final class a extends LinearSmoothScroller {
        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
            return (r102 + ((r103 - r102) / 2)) - (r100 + ((r101 - r100) / 2));
        }
    }

    public OrderListCenterLayoutManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, 1, false);
        this.f180092a = r100;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        a r103 = new a(this.f180092a);
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }
}
