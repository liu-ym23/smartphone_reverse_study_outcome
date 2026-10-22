package com.bytedance.android.shopping.anchorv3.auction;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/RecordDiffer;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lj53/a;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordDiffer extends DiffUtil.ItemCallback<j53.a> {
    public RecordDiffer() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(j53.a r100, j53.a r101) {
        j53.a r102 = r100;
        j53.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "p0");
        Intrinsics.checkNotNullParameter(r103, "p1");
        return Intrinsics.areEqual(r102, r103);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(j53.a r100, j53.a r101) {
        j53.a r102 = r100;
        j53.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "p0");
        Intrinsics.checkNotNullParameter(r103, "p1");
        return Intrinsics.areEqual(r102, r103);
    }
}
