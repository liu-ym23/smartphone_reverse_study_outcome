package com.bytedance.android.livesdk.performance.config;

import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.a;
import java.util.ArrayList;
import kotlin.Metadata;
import tn2.b;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/performance/config/LiveShellTemperatureStrategyConfig;", "", "", "mEnable", "Z", "getMEnable", "()Z", "setMEnable", "(Z)V", "", "mRecoverDuration", "J", "getMRecoverDuration", "()J", "mDuration", "getMDuration", "Ljava/util/ArrayList;", "Ltn2/b;", "mShellTemperatureDegradeList", "Ljava/util/ArrayList;", "getMShellTemperatureDegradeList", "()Ljava/util/ArrayList;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveShellTemperatureStrategyConfig {

    @SerializedName("duration")
    private final long mDuration;

    @SerializedName("enable")
    private boolean mEnable;

    @SerializedName("recover_duration")
    private final long mRecoverDuration;

    @SerializedName("shell_temperature_degrade_list")
    private final ArrayList<b> mShellTemperatureDegradeList;

    public LiveShellTemperatureStrategyConfig() {
        this.mEnable = true;
        this.mRecoverDuration = a.f276323j;
        this.mDuration = 60000;
    }

    public final long getMDuration() {
        return this.mDuration;
    }

    public final boolean getMEnable() {
        return this.mEnable;
    }

    public final long getMRecoverDuration() {
        return this.mRecoverDuration;
    }

    public final ArrayList<b> getMShellTemperatureDegradeList() {
        return this.mShellTemperatureDegradeList;
    }

    public final void setMEnable(boolean r100) {
        this.mEnable = r100;
    }
}
