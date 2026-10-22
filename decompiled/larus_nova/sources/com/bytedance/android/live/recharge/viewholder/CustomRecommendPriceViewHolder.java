package com.bytedance.android.live.recharge.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/recharge/viewholder/CustomRecommendPriceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomRecommendPriceViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f90564a;

    public CustomRecommendPriceViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f90564a = (TextView) r100.findViewById(R.id.tip_text);
    }
}
