package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/y;", "", "", "protocol", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class y {

    @SerializedName("name")
    private final String name;

    @SerializedName("protocol")
    private final String protocol;

    public y() {
        this.protocol = "";
        this.name = "";
    }

    public final String a() {
        return this.name;
    }

    public final String b() {
        return this.protocol;
    }
}
