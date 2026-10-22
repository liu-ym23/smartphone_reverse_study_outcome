package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/q1;", "", "", "ignoreGuideInterval", "Z", "c", "()Z", "setIgnoreGuideInterval", "(Z)V", "", "commentCount", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setCommentCount", "(J)V", "giftEffectCount", "b", "setGiftEffectCount", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q1 {

    @SerializedName("comment_count")
    private long commentCount;

    @SerializedName("gift_effect_count")
    private long giftEffectCount;

    @SerializedName("ignore_guide_interval")
    private boolean ignoreGuideInterval;

    public q1() {
        this.commentCount = 8;
        this.giftEffectCount = 3;
    }

    public final long a() {
        return this.commentCount;
    }

    public final long b() {
        return this.giftEffectCount;
    }

    public final boolean c() {
        return this.ignoreGuideInterval;
    }
}
