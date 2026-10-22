package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class GameGuessPredictorConfig {

    @SerializedName("activity_banner_duration")
    public int activityBannerDuration;

    @SerializedName("anchor_leave_schema")
    public String anchorLeaveSchema;

    @SerializedName("anchor_predictor_list_schema")
    public String anchorPredictorListSchema;

    @SerializedName("anchor_schema")
    public String anchorSchema;

    @SerializedName("audience_interaction_schema")
    public String audienceInteractionSchema;

    @SerializedName("audience_schema")
    public String audienceSchema;

    @SerializedName("enable")
    public int enable;

    @SerializedName("predictor_duration")
    public int predictorDuration;

    public GameGuessPredictorConfig() {
        this.enable = 0;
        this.predictorDuration = 10;
        this.activityBannerDuration = 5;
    }
}
