package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/config/g61;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "hrtt_factor", "D", "b", "()D", "setHrtt_factor", "(D)V", "live_speed_check", "c", "setLive_speed_check", "", "poor_basis", "I", "d", "()I", "setPoor_basis", "(I)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g61 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("hrtt_factor")
    private double hrtt_factor;

    @SerializedName("live_speed_check")
    private boolean live_speed_check;

    @SerializedName("poor_basis")
    private int poor_basis;

    public g61() {
        this.hrtt_factor = 0.8d;
        this.live_speed_check = true;
        this.poor_basis = 1;
    }

    public final boolean a() {
        return this.enable;
    }

    public final double b() {
        return this.hrtt_factor;
    }

    public final boolean c() {
        return this.live_speed_check;
    }

    public final int d() {
        return this.poor_basis;
    }
}
