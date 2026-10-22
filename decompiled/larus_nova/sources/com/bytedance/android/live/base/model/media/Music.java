package com.bytedance.android.live.base.model.media;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.FeatureManager;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
public class Music {

    @SerializedName("album")
    String album;

    @SerializedName(FeatureManager.AUDIO_TRACK)
    k audioTrack;

    @SerializedName("author")
    String authorName;

    @SerializedName("cover_hd")
    k converHd;

    @SerializedName("cover_large")
    k coverLarge;

    @SerializedName("cover_medium")
    k coverMedium;

    @SerializedName("cover_thumb")
    k coverThumb;

    @SerializedName("duration")
    int duration;

    @SerializedName("end_time")
    int endTime;

    @SerializedName("extra")
    String extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    long f58845id;

    @SerializedName("is_user_favorite")
    boolean isUserFavorite;

    @SerializedName("id_str")
    String mid;

    @SerializedName("title")
    String musicName;

    @SerializedName("original_titel_tpl")
    String originalTitelTpl;

    @SerializedName("original_user_id")
    long oroginalUserId;

    @SerializedName("play_url")
    UrlModel playUrl;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    String schema;

    @SerializedName("share_description")
    String shareDescription;

    @SerializedName("share_title")
    String shareTitle;

    @SerializedName("share_url")
    String shareUrl;
    String songId;

    @SerializedName("source_platform")
    int source;

    @SerializedName(ILoadStallMonitor.START_TIME)
    int startTime;

    @SerializedName("status")
    int status;

    @SerializedName("video_cnt")
    private long videoCount;

    public Music() {
    }

    public String toString() {
        return "Music{id=" + this.f58845id + ", mid='" + this.mid + "', album='" + this.album + "', musicName='" + this.musicName + "', converHd=" + this.converHd + ", coverLarge=" + this.coverLarge + ", coverMedium=" + this.coverMedium + ", coverThumb=" + this.coverThumb + ", playUrl=" + this.playUrl + ", authorName='" + this.authorName + "', schema='" + this.schema + "', source=" + this.source + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", duration=" + this.duration + ", status=" + this.status + ", extra='" + this.extra + "', shareUrl='" + this.shareUrl + "', shareTitle='" + this.shareTitle + "', shareDescription='" + this.shareDescription + "', oroginalUserId=" + this.oroginalUserId + ", originalTitelTpl='" + this.originalTitelTpl + "', songId='" + this.songId + "'}";
    }
}
