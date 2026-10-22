package com.bytedance.android.livesdkapi.feed;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.feed.open.IOpenLiveListFactory;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/IOpenFeedService;", "Lcom/bytedance/android/live/base/IService;", "getDislikeRepository", "Lcom/bytedance/android/livesdkapi/feed/IDislikeRepository;", "getFeedRepository", "Lcom/bytedance/android/livesdkapi/feed/IOpenFeedRepository;", "getOpenLiveListFactory", "Lcom/bytedance/android/livesdkapi/feed/open/IOpenLiveListFactory;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IOpenFeedService extends IService {
    IDislikeRepository getDislikeRepository();

    IOpenFeedRepository getFeedRepository();

    IOpenLiveListFactory getOpenLiveListFactory();
}
