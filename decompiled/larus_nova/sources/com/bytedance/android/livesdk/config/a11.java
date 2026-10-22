package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/a11;", "", "", "enable", "Z", "b", "()Z", "", "aoKey", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "timeOut", "J", "d", "()J", "enableTimeOut", "c", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a11 {

    @SerializedName("ao_key")
    private final String aoKey;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_time_out")
    private final boolean enableTimeOut;

    @SerializedName("time_out")
    private final long timeOut;

    public a11() {
        this.aoKey = "ao";
        this.timeOut = 10;
        this.enableTimeOut = true;
    }

    public final String a() {
        return this.aoKey;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.enableTimeOut;
    }

    public final long d() {
        return this.timeOut;
    }
}
