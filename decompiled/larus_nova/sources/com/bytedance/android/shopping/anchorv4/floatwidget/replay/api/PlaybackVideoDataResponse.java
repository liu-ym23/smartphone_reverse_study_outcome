package com.bytedance.android.shopping.anchorv4.floatwidget.replay.api;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/api/PlaybackVideoDataResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "cutOffset", "", "getCutOffset", "()Ljava/lang/Long;", "Ljava/lang/Long;", "videoInfo", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/api/PlaybackVideoStruct;", "getVideoInfo", "()Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/api/PlaybackVideoStruct;", "videoInfoV2", "Lcom/bytedance/android/ec/model/response/ECPDPBaseVideo;", "getVideoInfoV2", "()Lcom/bytedance/android/ec/model/response/ECPDPBaseVideo;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlaybackVideoDataResponse extends CommerceBaseResponse {

    @SerializedName("cut_offset")
    private final Long cutOffset;

    @SerializedName("video")
    private final PlaybackVideoStruct videoInfo;

    @SerializedName("video_v2")
    private final ECPDPBaseVideo videoInfoV2;

    public PlaybackVideoDataResponse() {
    }

    public final Long getCutOffset() {
        return this.cutOffset;
    }

    public final PlaybackVideoStruct getVideoInfo() {
        return this.videoInfo;
    }

    public final ECPDPBaseVideo getVideoInfoV2() {
        return this.videoInfoV2;
    }
}
