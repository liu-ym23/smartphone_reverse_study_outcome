package com.bytedance.android.shopping.store.slicecard.dto;

import com.bytedance.android.ec.model.video.BitRate;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/dto/ShopPlayVideoDto;", "Ljava/io/Serializable;", "()V", "bitRate", "", "Lcom/bytedance/android/ec/model/video/BitRate;", "getBitRate", "()Ljava/util/List;", "duration", "", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "fragmentId", "getFragmentId", "height", "", "getHeight", "()I", "playUrl", "", "getPlayUrl", "()Ljava/lang/String;", "videoId", "getVideoId", "width", "getWidth", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopPlayVideoDto implements Serializable {

    @SerializedName("bit_rate")
    private final List<BitRate> bitRate;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("fragment_id")
    private final Long fragmentId;

    @SerializedName("height")
    private final int height;

    @SerializedName("play_url")
    private final String playUrl;

    @SerializedName("video_id")
    private final String videoId;

    @SerializedName("width")
    private final int width;

    public ShopPlayVideoDto() {
    }

    public final List<BitRate> getBitRate() {
        return this.bitRate;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Long getFragmentId() {
        return this.fragmentId;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getPlayUrl() {
        return this.playUrl;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final int getWidth() {
        return this.width;
    }
}
