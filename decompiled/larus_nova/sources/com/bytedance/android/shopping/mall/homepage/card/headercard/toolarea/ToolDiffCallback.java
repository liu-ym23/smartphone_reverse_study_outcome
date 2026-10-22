package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/toolarea/ToolDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "<init>", "()V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolDiffCallback extends DiffUtil.ItemCallback<ToolVO> {
    public ToolDiffCallback() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(ToolVO r100, ToolVO r101) {
        ToolVO r102 = r100;
        ToolVO r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        return Intrinsics.areEqual(r102, r103);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(ToolVO r100, ToolVO r101) {
        ToolVO r102 = r100;
        ToolVO r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        return Intrinsics.areEqual(r102.getComponentId(), r103.getComponentId());
    }
}
