package com.bytedance.android.livehostapi.business.depend.rerank;

import com.bytedance.android.live.base.model.feed.FeedItem;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&J8\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/rerank/IReRankWebcastRoomFragmentPanel;", "", "getCurIndex", "", "getEnterSource", "", "getFeedItems", "", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "getRoomTags", "Lorg/json/JSONArray;", "roomId", "", "replaceFeedItems", "", "beginIndex", "newFeedItems", "removeFeedItems", "callback", "Lcom/bytedance/android/livehostapi/business/depend/rerank/IReRankWebcastRoomFragmentPanel$Callback;", "Callback", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IReRankWebcastRoomFragmentPanel {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/rerank/IReRankWebcastRoomFragmentPanel$Callback;", "", "onDeduplication", "", "itemIds", "", "onFail", "msg", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "currentItemList", "", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback {

        /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.rerank.IReRankWebcastRoomFragmentPanel$Callback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void onFail$default(Callback r100, String r101, Exception r102, int r103, Object r104) {
                if (r104 != null) goto L12;
                if ((r103 & 1) == 0) goto L7;
                r101 = null;
            L7:
                if ((r103 & 2) == 0) goto L9;
                r102 = null;
            L9:
                r100.onFail(r101, r102);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFail");
            }
        }

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static /* synthetic */ void onFail$default(Callback r100, String r101, Exception r102, int r103, Object r104) {
                CC.onFail$default(r100, r101, r102, r103, r104);
            }
        }

        void onDeduplication(String r100);

        void onFail(String r100, Exception r101);

        void onSuccess(List<? extends FeedItem> r100);
    }

    int getCurIndex();

    String getEnterSource();

    List<FeedItem> getFeedItems();

    JSONArray getRoomTags(long r100);

    void replaceFeedItems(int r100, List<? extends FeedItem> r101, List<? extends FeedItem> r102, Callback r103);
}
