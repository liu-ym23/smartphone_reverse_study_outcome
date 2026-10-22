package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/z2;", "", "", "tetrisEnable", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setTetrisEnable", "(Ljava/lang/Boolean;)V", "serviceEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setServiceEnable", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z2 {

    @SerializedName("service_enable")
    private Boolean serviceEnable;

    @SerializedName("tetris_enable")
    private Boolean tetrisEnable;

    public z2() {
        Boolean r100 = Boolean.TRUE;
        this.tetrisEnable = r100;
        this.serviceEnable = r100;
    }

    public final Boolean a() {
        return this.serviceEnable;
    }

    public final Boolean b() {
        return this.tetrisEnable;
    }
}
