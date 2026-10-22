package com.bytedance.android.shopping.anchorv4.floatwidget.replay.api;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0016\u0010\u0017\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/api/PlaybackVideoStruct;", "Ljava/io/Serializable;", "()V", "awemeId", "", "getAwemeId", "()Ljava/lang/String;", "coverUrl", "getCoverUrl", "duration", "", "getDuration", "()J", "height", "getHeight", "playUrl", "getPlayUrl", "title", "getTitle", "urlKey", "getUrlKey", "videoId", "getVideoId", "width", "getWidth", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlaybackVideoStruct implements Serializable {

    @SerializedName(SimilarProductParam.AWEME_ID)
    private final String awemeId;

    @SerializedName("cover")
    private final String coverUrl;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("height")
    private final long height;

    @SerializedName("play_url")
    private final String playUrl;

    @SerializedName("title")
    private final String title;

    @SerializedName("url_key")
    private final String urlKey;

    @SerializedName("vid")
    private final String videoId;

    @SerializedName("width")
    private final long width;

    public PlaybackVideoStruct() {
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getHeight() {
        return this.height;
    }

    public final String getPlayUrl() {
        return this.playUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrlKey() {
        return this.urlKey;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final long getWidth() {
        return this.width;
    }
}
