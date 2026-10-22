package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import androidx.recyclerview.widget.DiffUtil;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/layer/product/MainFeedDiffer;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bytedance/android/ecom/arch/slice/adapter/b;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainFeedDiffer extends DiffUtil.ItemCallback<com.bytedance.android.ecom.arch.slice.adapter.b> {
    public MainFeedDiffer() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(com.bytedance.android.ecom.arch.slice.adapter.b r100, com.bytedance.android.ecom.arch.slice.adapter.b r101) {
        com.bytedance.android.ecom.arch.slice.adapter.b r102 = r100;
        com.bytedance.android.ecom.arch.slice.adapter.b r103 = r101;
        Intrinsics.checkNotNullParameter(r102, TeaEventTrack.ACTION_DRAMA_PRE);
        Intrinsics.checkNotNullParameter(r103, UGCMonitor.TYPE_POST);
        return r102.areContentsTheSame(r103);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(com.bytedance.android.ecom.arch.slice.adapter.b r100, com.bytedance.android.ecom.arch.slice.adapter.b r101) {
        com.bytedance.android.ecom.arch.slice.adapter.b r102 = r100;
        com.bytedance.android.ecom.arch.slice.adapter.b r103 = r101;
        Intrinsics.checkNotNullParameter(r102, TeaEventTrack.ACTION_DRAMA_PRE);
        Intrinsics.checkNotNullParameter(r103, UGCMonitor.TYPE_POST);
        return r102.areItemsTheSame(r103);
    }
}
