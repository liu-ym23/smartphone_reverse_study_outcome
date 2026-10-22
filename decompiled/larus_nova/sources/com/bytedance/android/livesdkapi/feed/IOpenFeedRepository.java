package com.bytedance.android.livesdkapi.feed;

import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/IOpenFeedRepository;", "", "config", "", "enterParams", "Lcom/bytedance/android/livesdkapi/feed/EnterParams;", "feedType", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "channelName", "", "detach", "getLogger", "Lcom/bytedance/android/livesdkapi/feed/IOpenFeedLogger;", "requestFeed", "isRefresh", "", "count", "", "loadingCallback", "Lcom/bytedance/android/livesdkapi/feed/FeedLoadingCallback;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IOpenFeedRepository {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void requestFeed$default(IOpenFeedRepository r100, boolean r101, int r102, FeedLoadingCallback r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 2) == 0) goto L6;
            r102 = 0;
        L6:
            r100.requestFeed(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestFeed");
        }
    }

    void config(EnterParams r100, FeedType r101);

    void config(EnterParams r100, FeedType r101, String r102);

    void detach();

    IOpenFeedLogger getLogger();

    void requestFeed(boolean r100, int r101, FeedLoadingCallback r102);
}
