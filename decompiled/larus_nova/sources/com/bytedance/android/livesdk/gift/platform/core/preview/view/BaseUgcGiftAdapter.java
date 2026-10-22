package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/BaseUgcGiftAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseUgcGiftAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public void A2() {
    }

    public void B2() {
    }

    public abstract void y2(com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.a r100, int r101, String r102);

    public void z2(List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public BaseUgcGiftAdapter() {
    }
}
