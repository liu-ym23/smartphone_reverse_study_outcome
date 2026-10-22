package com.bytedance.android.ec.model.playback;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006 "}, d2 = {"Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;", "Ljava/io/Serializable;", "", "videoId", "Ljava/lang/String;", "getVideoId", "()Ljava/lang/String;", "coverUrl", "getCoverUrl", "playUrl", "getPlayUrl", "", "duration", "J", "getDuration", "()J", "width", "getWidth", "height", "getHeight", "title", "getTitle", "awemeId", "getAwemeId", "urlKey", "getUrlKey", "fragmentId", "getFragmentId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlaybackVideoInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName(SimilarProductParam.AWEME_ID)
    private final String awemeId;

    @SerializedName("cover")
    private final String coverUrl;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("fragment_id")
    private final String fragmentId;

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

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ExplainPlaybackVideoInfo() {
        this.videoId = "";
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

    public final String getFragmentId() {
        return this.fragmentId;
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
