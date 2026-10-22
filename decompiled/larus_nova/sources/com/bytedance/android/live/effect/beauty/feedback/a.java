package com.bytedance.android.live.effect.beauty.feedback;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/feedback/a;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "showConditionDuration", "J", "getShowConditionDuration", "()J", "setShowConditionDuration", "(J)V", "hideConditionDuration", "getHideConditionDuration", "setHideConditionDuration", "", "feedbackUrl", "Ljava/lang/String;", "getFeedbackUrl", "()Ljava/lang/String;", "setFeedbackUrl", "(Ljava/lang/String;)V", "enableMockShow", "getEnableMockShow", "setEnableMockShow", "<init>", "()V", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_mock_show")
    private boolean enableMockShow;

    @SerializedName("feedback_url")
    private String feedbackUrl;

    @SerializedName("hide_condition_duration")
    private long hideConditionDuration;

    @SerializedName("show_condition_duration")
    private long showConditionDuration;

    public a() {
        this.showConditionDuration = 10;
        this.hideConditionDuration = 10;
        this.feedbackUrl = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/community_feedback_lynx_douyin/pages/discuss_feedback/template.js";
    }
}
