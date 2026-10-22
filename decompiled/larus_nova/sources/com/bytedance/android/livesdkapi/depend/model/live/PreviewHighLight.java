package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PreviewExposeData.PreviewHighLight")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R \u0010 \u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewHighLight;", "", "()V", "enable", "", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "guideIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getGuideIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setGuideIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "guideText", "", "getGuideText", "()Ljava/lang/String;", "setGuideText", "(Ljava/lang/String;)V", "showDuration", "", "getShowDuration", "()Ljava/lang/Long;", "setShowDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "videoId", "getVideoId", "setVideoId", "videoUrl", "getVideoUrl", "setVideoUrl", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewHighLight implements h {

    @SerializedName("enable")
    protected Boolean enable;

    @SerializedName("guide_icon")
    protected ImageModel guideIcon;

    @SerializedName("guide_text")
    protected String guideText;

    @SerializedName("show_duration")
    protected Long showDuration;

    @SerializedName("video_id")
    protected String videoId;

    @SerializedName("video_url")
    protected String videoUrl;

    public PreviewHighLight() {
        this.enable = Boolean.FALSE;
        this.videoUrl = "";
        this.showDuration = 10L;
        this.guideText = "";
        this.videoId = "";
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final ImageModel getGuideIcon() {
        return this.guideIcon;
    }

    public final String getGuideText() {
        return this.guideText;
    }

    public final Long getShowDuration() {
        return this.showDuration;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public PreviewHighLight(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.videoId = am3.h.c(r100);
        goto L3
    L8:
        this.guideIcon = x.a(r100);
        goto L3
    L9:
        this.guideText = am3.h.c(r100);
        goto L3
    L10:
        this.showDuration = Long.valueOf(r100.j());
        goto L3
    L11:
        this.videoUrl = am3.h.c(r100);
        goto L3
    L12:
        this.enable = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.enable != null) goto L17;
        this.enable = Boolean.FALSE;
    L17:
        if (this.videoUrl != null) goto L20;
        this.videoUrl = "";
    L20:
        if (this.showDuration != null) goto L23;
        this.showDuration = 10L;
    L23:
        if (this.guideText != null) goto L26;
        this.guideText = "";
    L26:
        if (this.videoId != null) goto L45;
        this.videoId = "";
        return;
    }

    public final void setEnable(Boolean r100) {
        this.enable = r100;
    }

    public final void setGuideIcon(ImageModel r100) {
        this.guideIcon = r100;
    }

    public final void setGuideText(String r100) {
        this.guideText = r100;
    }

    public final void setShowDuration(Long r100) {
        this.showDuration = r100;
    }

    public final void setVideoId(String r100) {
        this.videoId = r100;
    }

    public final void setVideoUrl(String r100) {
        this.videoUrl = r100;
    }
}
