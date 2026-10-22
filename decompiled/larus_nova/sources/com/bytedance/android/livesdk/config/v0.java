package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/v0;", "", "", "isUseNative", "Z", "b", "()Z", "isUseLynx", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v0 {

    @SerializedName("use_lynx")
    private final boolean isUseLynx;

    @SerializedName("use_native")
    private final boolean isUseNative;

    public v0() {
    }

    public final boolean a() {
        return this.isUseLynx;
    }

    public final boolean b() {
        return this.isUseNative;
    }
}
