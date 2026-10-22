package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/n2;", "", "", "predictEnable", "Z", "c", "()Z", "", "predictCount", "I", "b", "()I", "useFeatureCenter", "e", "needDelayTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "repeatPeriod", "d", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n2 {

    @SerializedName("need_delay_time")
    private final int needDelayTime;

    @SerializedName("predict_count")
    private final int predictCount;

    @SerializedName("send_predict_enable")
    private final boolean predictEnable;

    @SerializedName("repeat_period")
    private final int repeatPeriod;

    @SerializedName("ues_feature_center")
    private final boolean useFeatureCenter;

    public n2() {
        this.predictCount = 20;
        this.needDelayTime = 5;
        this.repeatPeriod = 60;
    }

    public final int a() {
        return this.needDelayTime;
    }

    public final int b() {
        return this.predictCount;
    }

    public final boolean c() {
        return this.predictEnable;
    }

    public final int d() {
        return this.repeatPeriod;
    }

    public final boolean e() {
        return this.useFeatureCenter;
    }
}
