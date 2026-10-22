package com.bytedance.android.livesdkapi.depend.live;

import com.bytedance.android.livesdkapi.model.LiveOptRecommendHintConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/ILiveOptRecommendHintService;", "", "canShowOptRecommendTip", "", "getConfig", "Lcom/bytedance/android/livesdkapi/model/LiveOptRecommendHintConfig;", "markOptRecommendTipShow", "", "recordSkipRoom", "roomId", "", "updateOptRecommendUsedDate", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveOptRecommendHintService {
    boolean canShowOptRecommendTip();

    LiveOptRecommendHintConfig getConfig();

    void markOptRecommendTipShow();

    void recordSkipRoom(long r100);

    void updateOptRecommendUsedDate();
}
