package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010 \u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\"\u0010#\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/config/f71;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "enableV2", "d", "setEnableV2", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "serious_config", FaceService.girlLabel, "f", "()F", "setSerious_config", "(F)V", "critical_config", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCritical_config", "serious_diff_config", com.amap.api.col.s.ce.f26391f, "setSerious_diff_config", "critical_diff_config", "b", "setCritical_diff_config", "recover_time", "e", "setRecover_time", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f71 {

    @SerializedName("critical_config")
    private float critical_config;

    @SerializedName("critical_diff_config")
    private float critical_diff_config;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_v2")
    private boolean enableV2;

    @SerializedName("recover_time")
    private int recover_time;

    @SerializedName("serious_config")
    private float serious_config;

    @SerializedName("serious_diff_config")
    private float serious_diff_config;

    @SerializedName("type")
    private int type;

    public f71() {
        this.type = 1;
        this.serious_config = 30.0f;
        this.critical_config = 20.0f;
        this.serious_diff_config = 10.0f;
        this.critical_diff_config = 20.0f;
        this.recover_time = 300000;
    }

    public final float a() {
        return this.critical_config;
    }

    public final float b() {
        return this.critical_diff_config;
    }

    public final boolean c() {
        return this.enable;
    }

    public final boolean d() {
        return this.enableV2;
    }

    public final int e() {
        return this.recover_time;
    }

    public final float f() {
        return this.serious_config;
    }

    public final float g() {
        return this.serious_diff_config;
    }

    public final int getType() {
        return this.type;
    }
}
