package com.bytedance.android.livesdk.feed.squarefeed.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b90.a;
import com.bytedance.android.live.core.paging.adapter.PagingAdapter;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/adapter/OpenFeedAdapter;", "Lcom/bytedance/android/livesdk/feed/squarefeed/adapter/BaseOpenFeedAdapter;", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class OpenFeedAdapter extends BaseOpenFeedAdapter {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FeedStyle f124450q;

    @Override // com.bytedance.android.livesdk.feed.squarefeed.adapter.BaseOpenFeedAdapter
    public final int D2(int r100) {
        if (r100 == 1) goto L6;
        return invalidateType();
    L6:
        if (this.f124450q != FeedStyle.SIMPLE_LIST) goto L9;
        return R.layout.ttlive_item_feed_live_simple;
    L9:
        return invalidateType();
    }

    public OpenFeedAdapter(Map<Integer, ? extends a> r100, FeedStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "factories");
        Intrinsics.checkNotNullParameter(r101, "feedStyle");
        super(r100);
        this.f124450q = r101;
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new PagingAdapter.EndViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_custom_rv_loading_end, r100, false));
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final RecyclerView.ViewHolder createLoadingViewHolder(ViewGroup r100, int r101) {
        return super.createLoadingViewHolder(r100, r101);
    }
}
