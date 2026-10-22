package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010 \u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/config/b21;", "", "", "resolutionStrategyEnabled", "Z", "getResolutionStrategyEnabled", "()Z", "setResolutionStrategyEnabled", "(Z)V", "", "liveResolutionLimit", "I", "getLiveResolutionLimit", "()I", "setLiveResolutionLimit", "(I)V", "replayResolutionLimit", "getReplayResolutionLimit", "setReplayResolutionLimit", "", "xsgOnlyLabelText", "Ljava/lang/String;", "getXsgOnlyLabelText", "()Ljava/lang/String;", "setXsgOnlyLabelText", "(Ljava/lang/String;)V", "xsgGuideLabelText", "getXsgGuideLabelText", "setXsgGuideLabelText", "recommendSubtitle", "getRecommendSubtitle", "setRecommendSubtitle", "otherSubtitle", "getOtherSubtitle", "setOtherSubtitle", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b21 {

    @SerializedName("live_resolution_limit")
    private int liveResolutionLimit;

    @SerializedName("other_subtitle")
    private String otherSubtitle;

    @SerializedName("recommend_subtitle")
    private String recommendSubtitle;

    @SerializedName("replay_resolution_limit")
    private int replayResolutionLimit;

    @SerializedName("enable_resolution_strategy")
    private boolean resolutionStrategyEnabled;

    @SerializedName("xsg_guide_label_text")
    private String xsgGuideLabelText;

    @SerializedName("xsg_only_label_text")
    private String xsgOnlyLabelText;

    public b21() {
        this.resolutionStrategyEnabled = true;
        this.liveResolutionLimit = 8294400;
        this.replayResolutionLimit = 8294400;
        this.xsgOnlyLabelText = "";
        this.xsgGuideLabelText = "享4K";
        this.recommendSubtitle = "";
        this.otherSubtitle = "";
    }
}
