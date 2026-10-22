package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/dh1;", "", "", "minShakeSpeed", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setMinShakeSpeed", "(I)V", "needVibrator", "c", "setNeedVibrator", "minShakeSpeedOnLine", "b", "setMinShakeSpeedOnLine", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class dh1 {

    @SerializedName("min_shake_speed")
    private int minShakeSpeed;

    @SerializedName("min_shake_speed_online")
    private int minShakeSpeedOnLine;

    @SerializedName("need_vibrator")
    private int needVibrator;

    public dh1() {
        this.minShakeSpeed = 700;
        this.needVibrator = 1;
        this.minShakeSpeedOnLine = 700;
    }

    public final int a() {
        return this.minShakeSpeed;
    }

    public final int b() {
        return this.minShakeSpeedOnLine;
    }

    public final int c() {
        return this.needVibrator;
    }
}
