package com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository;

import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.livereplay.repository.NetState;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    void onInvalidated();

    void selectFirstCard(ECUIPromotion r100, ExplainPlaybackVideoInfo r101, ECReplayVideo r102, List<ExplainReplaySubTitle> r103);

    void setNetworkState(NetState r100);
}
