package com.bytedance.android.livesdk.feed.live;

import android.view.View;
import android.widget.ViewFlipper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.feed.g;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public class LiveRankViewHolder extends BaseViewHolder<FeedItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewFlipper f124161a;

    public LiveRankViewHolder(View r100) {
        super(r100);
        this.f124161a = (ViewFlipper) r100.findViewById(R.id.headlines_flipper);
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        ((g) r100.getItem()).getClass();
        this.f124161a.stopFlipping();
        this.f124161a.setVisibility(8);
    }
}
