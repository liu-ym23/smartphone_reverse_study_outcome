package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/nc1;", "", "", "appId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "b", "c", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class nc1 {

    @SerializedName("app_id")
    private String appId;

    @SerializedName("app_version")
    private String appVersion;

    public final String a() {
        return this.appId;
    }

    public final String b() {
        return this.appVersion;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appVersion = r100;
    }

    public nc1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "appVersion");
        this.appId = r100;
        this.appVersion = r101;
    }
}
