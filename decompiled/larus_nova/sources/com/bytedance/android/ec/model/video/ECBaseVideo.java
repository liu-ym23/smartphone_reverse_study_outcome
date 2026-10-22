package com.bytedance.android.ec.model.video;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010;\u001a\u0004\u0018\u00010,R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR \u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R \u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R \u0010(\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R \u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R&\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u0010\tR\u001e\u00108\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\"\"\u0004\b:\u0010$¨\u0006<"}, d2 = {"Lcom/bytedance/android/ec/model/video/ECBaseVideo;", "Ljava/io/Serializable;", "()V", "bitRate", "", "Lcom/bytedance/android/ec/model/video/BitRate;", "getBitRate", "()Ljava/util/List;", "setBitRate", "(Ljava/util/List;)V", "cdnUrlExpired", "", "getCdnUrlExpired", "()J", "setCdnUrlExpired", "(J)V", "cover", "Lcom/bytedance/android/ec/model/video/UrlModel;", "getCover", "()Lcom/bytedance/android/ec/model/video/UrlModel;", "setCover", "(Lcom/bytedance/android/ec/model/video/UrlModel;)V", "duration", "getDuration", "setDuration", "h264PlayAddr", "getH264PlayAddr", "setH264PlayAddr", "h265PlayAddr", "getH265PlayAddr", "setH265PlayAddr", "height", "", "getHeight", "()I", "setHeight", "(I)V", "playAddr", "getPlayAddr", "setPlayAddr", "playAddrLowbr", "getPlayAddrLowbr", "setPlayAddrLowbr", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "getRatio", "()Ljava/lang/String;", "setRatio", "(Ljava/lang/String;)V", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "videoThumbs", "Lcom/google/gson/JsonElement;", "getVideoThumbs", "setVideoThumbs", "width", "getWidth", "setWidth", "getVideoId", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public class ECBaseVideo implements Serializable {

    @SerializedName("bit_rate")
    private List<BitRate> bitRate;

    @SerializedName("cdn_url_expired")
    private long cdnUrlExpired;

    @SerializedName("cover")
    private UrlModel cover;

    @SerializedName("duration")
    private long duration;

    @SerializedName("play_addr_h264")
    private UrlModel h264PlayAddr;

    @SerializedName("play_addr_h265")
    private UrlModel h265PlayAddr;

    @SerializedName("height")
    private int height;

    @SerializedName("play_addr")
    private UrlModel playAddr;

    @SerializedName("play_addr_lowbr")
    private UrlModel playAddrLowbr;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    private String ratio;

    @SerializedName("tag")
    private String tags;

    @SerializedName("big_thumbs")
    private List<? extends JsonElement> videoThumbs;

    @SerializedName("width")
    private int width;

    public ECBaseVideo() {
    }

    public final String getVideoId() {
        UrlModel r100 = this.playAddr;
        if (r100 == null) goto L14;
        String r101 = r100.getUri();
        if (r101 == null) goto L14;
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L14;
        UrlModel r103 = this.playAddr;
        if (r103 != null) goto L19;
        return null;
    L19:
        return r103.getUri();
    L9:
        r102 = false;
    L14:
        UrlModel r104 = this.h265PlayAddr;
        if (r104 != null) goto L17;
        return null;
    L17:
        return r104.getUri();
    }

    public final List<BitRate> getBitRate() {
        return this.bitRate;
    }

    public final long getCdnUrlExpired() {
        return this.cdnUrlExpired;
    }

    public final UrlModel getCover() {
        return this.cover;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final UrlModel getH264PlayAddr() {
        return this.h264PlayAddr;
    }

    public final UrlModel getH265PlayAddr() {
        return this.h265PlayAddr;
    }

    public final int getHeight() {
        return this.height;
    }

    public final UrlModel getPlayAddr() {
        return this.playAddr;
    }

    public final UrlModel getPlayAddrLowbr() {
        return this.playAddrLowbr;
    }

    public final String getRatio() {
        return this.ratio;
    }

    public final String getTags() {
        return this.tags;
    }

    public final List<JsonElement> getVideoThumbs() {
        return this.videoThumbs;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setBitRate(List<BitRate> r100) {
        this.bitRate = r100;
    }

    public final void setCdnUrlExpired(long r100) {
        this.cdnUrlExpired = r100;
    }

    public final void setCover(UrlModel r100) {
        this.cover = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setH264PlayAddr(UrlModel r100) {
        this.h264PlayAddr = r100;
    }

    public final void setH265PlayAddr(UrlModel r100) {
        this.h265PlayAddr = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setPlayAddr(UrlModel r100) {
        this.playAddr = r100;
    }

    public final void setPlayAddrLowbr(UrlModel r100) {
        this.playAddrLowbr = r100;
    }

    public final void setRatio(String r100) {
        this.ratio = r100;
    }

    public final void setTags(String r100) {
        this.tags = r100;
    }

    public final void setVideoThumbs(List<? extends JsonElement> r100) {
        this.videoThumbs = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }
}
