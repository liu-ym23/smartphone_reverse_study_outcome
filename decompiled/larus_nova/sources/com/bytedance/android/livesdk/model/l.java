package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/model/l;", "", "", "isTurnon", "Z", "()Z", "setTurnon", "(Z)V", "enableAutoMatch", "getEnableAutoMatch", "setEnableAutoMatch", "enableRecommend", "getEnableRecommend", "setEnableRecommend", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("enable_automatch")
    private boolean enableAutoMatch;

    @SerializedName("enable_recommend")
    private boolean enableRecommend;

    @SerializedName("is_turn_on")
    private boolean isTurnon;

    public l() {
        this.enableAutoMatch = true;
        this.enableRecommend = true;
    }
}
