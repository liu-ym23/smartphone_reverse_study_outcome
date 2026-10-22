package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/w81;", "", "", "enable", "Z", "d", "()Z", "setEnable", "(Z)V", "commonParamsOpt", "getCommonParamsOpt", "setCommonParamsOpt", "", "commonParamsTimeLimitOpt", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setCommonParamsTimeLimitOpt", "(J)V", "cookieHandlerOpt", "b", "setCookieHandlerOpt", "cookieHeadersOpt", "c", "setCookieHeadersOpt", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w81 {

    @SerializedName("common_params_opt")
    private boolean commonParamsOpt;

    @SerializedName("common_params_time_limit_opt")
    private long commonParamsTimeLimitOpt;

    @SerializedName("cookie_handler_opt")
    private boolean cookieHandlerOpt;

    @SerializedName("cookie_headers_opt")
    private boolean cookieHeadersOpt;

    @SerializedName("enable")
    private boolean enable;

    public w81() {
        this.commonParamsTimeLimitOpt = 1000;
    }

    public final long a() {
        return this.commonParamsTimeLimitOpt;
    }

    public final boolean b() {
        return this.cookieHandlerOpt;
    }

    public final boolean c() {
        return this.cookieHeadersOpt;
    }

    public final boolean d() {
        return this.enable;
    }
}
