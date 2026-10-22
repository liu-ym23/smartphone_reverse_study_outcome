package com.bytedance.android.livehostapi.business.depend.rerank;

import com.bytedance.android.live.base.model.feed.FeedItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/rerank/ILiveReRankCommonDelegate;", "", "getCustomFeedCount", "", "getHideFeedCount", "getLiveRoomType", "feedItem", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveReRankCommonDelegate {
    int getCustomFeedCount();

    int getHideFeedCount();

    int getLiveRoomType(FeedItem r100);
}
