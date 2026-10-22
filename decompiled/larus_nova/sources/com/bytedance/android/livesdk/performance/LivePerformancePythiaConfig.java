package com.bytedance.android.livesdk.performance;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class LivePerformancePythiaConfig {

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName("judge_duration")
    public long mJudgeDuration;

    @SerializedName("lintEnable")
    public boolean mLintEnable;

    @SerializedName("recover_duration")
    public long mRecoverDuration;

    @SerializedName("score_level_four")
    public float mScoreLevelFour;

    @SerializedName("score_level_one")
    public float mScoreLevelOne;

    @SerializedName("score_level_three")
    public float mScoreLevelThree;

    @SerializedName("score_level_two")
    public float mScoreLevelTwo;

    public LivePerformancePythiaConfig() {
        this.mEnable = false;
        this.mLintEnable = false;
        this.mJudgeDuration = 30000;
        this.mRecoverDuration = 60000;
        this.mScoreLevelOne = 0.0f;
        this.mScoreLevelTwo = 0.0f;
        this.mScoreLevelThree = 0.0f;
        this.mScoreLevelFour = 0.0f;
    }
}
