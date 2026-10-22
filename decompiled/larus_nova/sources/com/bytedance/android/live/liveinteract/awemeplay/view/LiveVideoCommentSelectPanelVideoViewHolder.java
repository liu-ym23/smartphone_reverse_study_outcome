package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/view/LiveVideoCommentSelectPanelVideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectPanelVideoViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f71594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f71595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f71596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f71597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f71598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f71599f;

    public LiveVideoCommentSelectPanelVideoViewHolder(View r100, boolean r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f71598e = r101;
        this.f71599f = r102;
        this.f71594a = (HSImageView) r100.findViewById(R.id.item_cover);
        this.f71595b = (ImageView) r100.findViewById(R.id.item_select);
        this.f71596c = (TextView) r100.findViewById(R.id.item_like_count_tv);
        this.f71597d = r100.findViewById(R.id.item_selected_mask);
    }
}
