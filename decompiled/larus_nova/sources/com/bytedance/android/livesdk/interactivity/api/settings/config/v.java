package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/v;", "", "", "enableNarrowOpt", "Z", "c", "()Z", "setEnableNarrowOpt", "(Z)V", "", "minWidth", "I", "d", "()I", "setMinWidth", "(I)V", "enableDelayLoad", "b", "setEnableDelayLoad", "delayTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDelayTime", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("delay_time")
    private int delayTime;

    @SerializedName("enable_delay_load")
    private boolean enableDelayLoad;

    @SerializedName("enable_opt_for_narrow")
    private boolean enableNarrowOpt;

    @SerializedName("min_width")
    private int minWidth;

    public v() {
        this.minWidth = 360;
        this.delayTime = 200;
    }

    public final int a() {
        return this.delayTime;
    }

    public final boolean b() {
        return this.enableDelayLoad;
    }

    public final boolean c() {
        return this.enableNarrowOpt;
    }

    public final int d() {
        return this.minWidth;
    }
}
