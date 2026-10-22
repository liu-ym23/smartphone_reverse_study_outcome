package com.bytedance.android.ec.model.response;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/model/response/k;", "", "", DyPayConstant.KEY_START_TIME, "J", "getStartTime", "()J", "endTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "serverTime", "c", "", "prefix", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "suffix", "d", "textColor", "e", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("prefix")
    private final String prefix;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    @SerializedName("suffix")
    private final String suffix;

    @SerializedName("text_color")
    private final String textColor;

    public k() {
    }

    public final long a() {
        return this.endTime;
    }

    public final String b() {
        return this.prefix;
    }

    public final long c() {
        return this.serverTime;
    }

    public final String d() {
        return this.suffix;
    }

    public final String e() {
        return this.textColor;
    }
}
