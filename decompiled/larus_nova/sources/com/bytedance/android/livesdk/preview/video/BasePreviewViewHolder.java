package com.bytedance.android.livesdk.preview.video;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/preview/video/BasePreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePreviewViewHolder extends RecyclerView.ViewHolder {
    public abstract void T3(LinkPlayerInfo r100);

    public BasePreviewViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }
}
