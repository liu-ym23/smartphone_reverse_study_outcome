package com.bytedance.android.ec.core.monitor;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/p;", "", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/String;)V", "version", "getVersion", "platform", "getPlatform", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("platform")
    private final String platform;

    @SerializedName("url")
    private String url;

    @SerializedName("version")
    private final String version;

    public p(String r100) {
        Intrinsics.checkNotNullParameter("", "url");
        Intrinsics.checkNotNullParameter(r100, "version");
        Intrinsics.checkNotNullParameter("android", "platform");
        this.url = "";
        this.version = r100;
        this.platform = "android";
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }
}
