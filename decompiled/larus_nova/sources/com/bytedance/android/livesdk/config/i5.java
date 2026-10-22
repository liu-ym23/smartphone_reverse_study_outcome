package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000f¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/config/i5;", "", "", "enable", "Z", "d", "()Z", "setEnable", "(Z)V", "", "checkInterval", "J", "c", "()J", "setCheckInterval", "(J)V", "", "useAiMode", "I", "f", "()I", "setUseAiMode", "(I)V", "aiCheckInterval", "b", "setAiCheckInterval", "aiBottomMode", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAiBottomMode", "useOnlineLogicEnable", com.amap.api.col.s.ce.f26391f, "setUseOnlineLogicEnable", "refreshInterval", "e", "setRefreshInterval", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i5 {

    @SerializedName("ai_bottom_mode")
    private int aiBottomMode;

    @SerializedName("check_interval_for_ai")
    private long aiCheckInterval;

    @SerializedName("check_interval")
    private long checkInterval;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("refresh_interval")
    private long refreshInterval;

    @SerializedName("use_ai_mode")
    private int useAiMode;

    @SerializedName("use_online_logic_enable")
    private boolean useOnlineLogicEnable;

    public i5() {
    }

    public final int a() {
        return this.aiBottomMode;
    }

    public final long b() {
        return this.aiCheckInterval;
    }

    public final long c() {
        return this.checkInterval;
    }

    public final boolean d() {
        return this.enable;
    }

    public final long e() {
        return this.refreshInterval;
    }

    public final int f() {
        return this.useAiMode;
    }

    public final boolean g() {
        return this.useOnlineLogicEnable;
    }
}
