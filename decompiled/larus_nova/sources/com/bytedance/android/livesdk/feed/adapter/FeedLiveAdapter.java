package com.bytedance.android.livesdk.feed.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.paging.adapter.PagingAdapter;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.h;
import com.larus.nova.R;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class FeedLiveAdapter extends BaseFeedAdapter {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final h f123608p;

    @Override // com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter
    public final int E2(int r100) {
        if (r100 == 1) goto L26;
        if (r100 != 3) goto L7;
        return R.layout.ttlive_item_feed_ad;
    L7:
        if (r100 != 6) goto L9;
        return R.layout.ttlive_view_feed_live_banner;
    L9:
        if (r100 == 10000001) goto L19;
        switch(r100) {
            case 1001: goto L31;
            case 1002: goto L17;
            case 1003: goto L15;
            case 1004: goto L13;
            default: goto L12;
        };
    L13:
        return R.layout.ttlive_item_follow_feed;
    L15:
        return R.layout.ttlive_view_feed_live_tab;
    L17:
        return R.layout.ttlive_view_feed_live_rank;
    L31:
        return R.layout.ttlive_view_feed_live_banner;
    L12:
        return invalidateType();
    L19:
        return R.layout.ttlive_feed_drawer_history_item_layout;
    L26:
        if (this.f123608p.Ay() == true) goto L28;
        return R.layout.ttlive_item_feed_live_large;
    L28:
        return this.f123608p.wY();
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r100, int r101) {
        return new PagingAdapter.EndViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_custom_rv_loading_end, r100, false));
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final RecyclerView.ViewHolder createLoadingViewHolder(ViewGroup r100, int r101) {
        return super.createLoadingViewHolder(r100, r101);
    }

    public FeedLiveAdapter(Map<Integer, b90.a> r100, f r101, h r102) {
        super(r100, r101);
        this.f123608p = r102;
    }
}
