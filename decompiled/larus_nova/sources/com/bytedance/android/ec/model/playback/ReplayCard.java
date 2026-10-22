package com.bytedance.android.ec.model.playback;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/model/playback/ReplayCard;", "Ljava/io/Serializable;", "()V", "promotion", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "getPromotion", "()Lcom/bytedance/android/ec/model/response/ECPromotion;", "subTitle", "", "Lcom/bytedance/android/ec/model/playback/ExplainReplaySubTitle;", "getSubTitle", "()Ljava/util/List;", "videoInfo", "Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;", "getVideoInfo", "()Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;", "videoMbr", "Lcom/bytedance/android/ec/model/playback/ECReplayVideo;", "getVideoMbr", "()Lcom/bytedance/android/ec/model/playback/ECReplayVideo;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ReplayCard implements Serializable {

    @SerializedName("promotion")
    private final ECPromotion promotion;

    @SerializedName("subtitles")
    private final List<ExplainReplaySubTitle> subTitle;

    @SerializedName("video")
    private final ExplainPlaybackVideoInfo videoInfo;

    @SerializedName("video_mbr")
    private final ECReplayVideo videoMbr;

    public ReplayCard() {
    }

    public final ECPromotion getPromotion() {
        return this.promotion;
    }

    public final List<ExplainReplaySubTitle> getSubTitle() {
        return this.subTitle;
    }

    public final ExplainPlaybackVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public final ECReplayVideo getVideoMbr() {
        return this.videoMbr;
    }
}
