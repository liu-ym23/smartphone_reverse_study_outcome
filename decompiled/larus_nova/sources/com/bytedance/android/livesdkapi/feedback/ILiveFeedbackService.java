package com.bytedance.android.livesdkapi.feedback;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.feedback.LiveFeedbackService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0016H&J!\u0010\u0017\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0011H&J\b\u0010\u001b\u001a\u00020\u0003H&J\u0017\u0010\u001c\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0005H&¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/feedback/ILiveFeedbackService;", "Lcom/bytedance/android/live/base/IService;", "clearPreviewRoomShowCache", "", "roomId", "", "(Ljava/lang/Long;)V", "clearRoomFeedbackInfo", "createFeedbackView", "Lcom/bytedance/android/livesdkapi/feedback/ILiveFeedbackView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "callback", "Lcom/bytedance/android/livesdkapi/feedback/IFeedbackCallback;", "style", "", "enableFeedbackCardPay", "", "getCacheInnerFeedbackCard", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "getFeedbackShowTime", "getRecentRoomIds", "", "hitPreviewRoomShowCache", "feedbackInt", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "isFeedbackCardCanShowInPreview", "resetFeedbackCardCanShowInPreview", "roomEnableFeedbackView", "(Ljava/lang/Long;)Z", "saveRecentRoomId", "setCacheInnerFeedbackCard", "cacheInnerFeedback", "updateFeedbackShowTime", "time", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveFeedbackService extends IService {
    void clearPreviewRoomShowCache(Long r100);

    void clearRoomFeedbackInfo(Long r100);

    ILiveFeedbackView createFeedbackView(Context r100, IFeedbackCallback r101, int r102);

    boolean enableFeedbackCardPay();

    FeedbackCard getCacheInnerFeedbackCard();

    long getFeedbackShowTime();

    String getRecentRoomIds();

    boolean hitPreviewRoomShowCache(Long r100, Long r101);

    boolean isFeedbackCardCanShowInPreview();

    void resetFeedbackCardCanShowInPreview();

    boolean roomEnableFeedbackView(Long r100);

    void saveRecentRoomId(long r100);

    void setCacheInnerFeedbackCard(FeedbackCard r100);

    void updateFeedbackShowTime(long r100);
}
