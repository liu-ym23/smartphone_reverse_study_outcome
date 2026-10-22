package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/model/j;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "audienceGuideText", "Ljava/lang/String;", "getAudienceGuideText", "()Ljava/lang/String;", "setAudienceGuideText", "(Ljava/lang/String;)V", "anchorGuideText", "getAnchorGuideText", "setAnchorGuideText", "guideSchema", "getGuideSchema", "setGuideSchema", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("anchor_guide_text")
    private String anchorGuideText;

    @SerializedName("audience_guide_text")
    private String audienceGuideText;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("guide_schema")
    private String guideSchema;

    public j() {
        this.enable = true;
        this.audienceGuideText = "送礼达到在线观众音浪TOP10可获得新权益，查看新玩法";
        this.anchorGuideText = "成为在线观众音浪TOP10可获得新权益，查看新玩法";
        this.guideSchema = "";
    }
}
