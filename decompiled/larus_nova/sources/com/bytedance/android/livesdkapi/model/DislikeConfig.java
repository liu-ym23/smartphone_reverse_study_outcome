package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\u001f\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001e\u0010\"\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/DislikeConfig;", "", "()V", "disappearTime", "", "getDisappearTime", "()J", "setDisappearTime", "(J)V", "dislikeUnfold", "", "getDislikeUnfold", "()Ljava/lang/Boolean;", "setDislikeUnfold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "entranceStyle", "", "getEntranceStyle", "()I", "setEntranceStyle", "(I)V", "feedbackText", "", "getFeedbackText", "()Ljava/lang/String;", "setFeedbackText", "(Ljava/lang/String;)V", "feedbackUrl", "getFeedbackUrl", "setFeedbackUrl", "skipTimes", "getSkipTimes", "setSkipTimes", "style", "getStyle", "setStyle", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DislikeConfig {

    @SerializedName("disappear_time")
    private long disappearTime;

    @SerializedName("dislike_unfold")
    private Boolean dislikeUnfold;

    @SerializedName("entrance_style")
    private int entranceStyle;

    @SerializedName("feedback_text")
    private String feedbackText;

    @SerializedName("feedback_url")
    private String feedbackUrl;

    @SerializedName("skip_times")
    private int skipTimes;

    @SerializedName("style")
    private int style;

    public DislikeConfig() {
        this.feedbackText = "优化直播推荐";
        this.skipTimes = 3;
        this.disappearTime = 3000;
        this.feedbackUrl = "sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2Fwebcast%2Fmono%2Flynx%2Fdouyin_lynx_community%2Fppe_live_feedback%2Ftemplate%2Fpages%2Fstable_feedback%2Ftemplate.js&fallback_url=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2Fwebcast%2Fmono%2Flynx%2Fdouyin_lynx_community%2Fppe_live_feedback%2Ftemplate%2Fpages%2Fstable_feedback%2Findex.html&hide_nav_bar=1&trans_status_bar=1&web_bg_color=%23ff000000";
        this.dislikeUnfold = Boolean.FALSE;
    }

    public final long getDisappearTime() {
        return this.disappearTime;
    }

    public final Boolean getDislikeUnfold() {
        return this.dislikeUnfold;
    }

    public final int getEntranceStyle() {
        return this.entranceStyle;
    }

    public final String getFeedbackText() {
        return this.feedbackText;
    }

    public final String getFeedbackUrl() {
        return this.feedbackUrl;
    }

    public final int getSkipTimes() {
        return this.skipTimes;
    }

    public final int getStyle() {
        return this.style;
    }

    public final void setDisappearTime(long r100) {
        this.disappearTime = r100;
    }

    public final void setDislikeUnfold(Boolean r100) {
        this.dislikeUnfold = r100;
    }

    public final void setEntranceStyle(int r100) {
        this.entranceStyle = r100;
    }

    public final void setFeedbackText(String r100) {
        this.feedbackText = r100;
    }

    public final void setFeedbackUrl(String r100) {
        this.feedbackUrl = r100;
    }

    public final void setSkipTimes(int r100) {
        this.skipTimes = r100;
    }

    public final void setStyle(int r100) {
        this.style = r100;
    }
}
