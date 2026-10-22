package com.bytedance.android.livesdk.feed.squarefeed.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.rank.a;
import com.bytedance.android.live.core.paging.adapter.PagingAdapter;
import com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/adapter/OpenRankAdapter;", "Lcom/bytedance/android/live/core/paging/adapter/SimplePagingAdapter;", "Lcom/bytedance/android/live/base/model/rank/a;", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class OpenRankAdapter extends SimplePagingAdapter<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FeedStyle f124451c;

    public OpenRankAdapter(Map<Integer, ? extends b90.a> r100, FeedStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "factories");
        Intrinsics.checkNotNullParameter(r101, "feedStyle");
        super(new RankItemComparator(), r100);
        this.f124451c = r101;
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

    @Override // com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter, com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final int getNormalViewType(int r100, Object r101) {
        a r102 = (a) r101;
        if (this.f124451c != FeedStyle.SIMPLE_LIST) goto L6;
        return R.layout.ttlive_feed_item_rank;
    L6:
        return invalidateType();
    }
}
