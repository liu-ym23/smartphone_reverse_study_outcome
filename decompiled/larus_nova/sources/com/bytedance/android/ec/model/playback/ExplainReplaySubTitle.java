package com.bytedance.android.ec.model.playback;

import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/model/playback/ExplainReplaySubTitle;", "Ljava/io/Serializable;", "()V", SubInfo.KEY_FORMAT, "", "getFormat", "()Ljava/lang/String;", "id", "", "getId", "()J", UserInfo.LANGUAGECODE, "getLanguageCode", "languageId", "getLanguageId", "url", "getUrl", "urlExpire", "getUrlExpire", "videoSubTitleId", "", "getVideoSubTitleId", "()I", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ExplainReplaySubTitle implements Serializable {

    @SerializedName(SubInfo.KEY_FORMAT)
    private final String format;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f47892id;

    @SerializedName("language_code")
    private final String languageCode;

    @SerializedName(SubInfo.KEY_LANGUAGE_ID)
    private final String languageId;

    @SerializedName("url")
    private final String url;

    @SerializedName("url_expire")
    private final long urlExpire;

    @SerializedName("video_subtitle_id")
    private final int videoSubTitleId;

    public ExplainReplaySubTitle() {
    }

    public final String getFormat() {
        return this.format;
    }

    public final long getId() {
        return this.f47892id;
    }

    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final String getLanguageId() {
        return this.languageId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getUrlExpire() {
        return this.urlExpire;
    }

    public final int getVideoSubTitleId() {
        return this.videoSubTitleId;
    }
}
