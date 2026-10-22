package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/p91;", "", "", "enableHighScoreLimit", "D", "getEnableHighScoreLimit", "()D", "setEnableHighScoreLimit", "(D)V", "enableLowScoreLimit", "getEnableLowScoreLimit", "setEnableLowScoreLimit", "", "hideEcomAllAnimation", "Z", "getHideEcomAllAnimation", "()Z", "setHideEcomAllAnimation", "(Z)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p91 {

    @SerializedName("enable_high_score_limit")
    private double enableHighScoreLimit;

    @SerializedName("enable_low_score_limit")
    private double enableLowScoreLimit;

    @SerializedName("hide_ecom_all_animation")
    private boolean hideEcomAllAnimation;

    public p91() {
        this.enableHighScoreLimit = 6.0d;
    }
}
