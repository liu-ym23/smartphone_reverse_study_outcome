package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/p51;", "", "", "schema", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "url", "b", "d", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class p51 {

    @SerializedName("schema")
    private String schema;

    @SerializedName("url")
    private String url;

    public final void c() {
        Intrinsics.checkNotNullParameter("sslocal://webcast_lynxview?enable_latch=1&hybrid_type=lynx&url=", "<set-?>");
        this.schema = "sslocal://webcast_lynxview?enable_latch=1&hybrid_type=lynx&url=";
    }

    public p51() {
        this.schema = "";
        this.url = "";
    }

    public final String a() {
        return this.schema;
    }

    public final String b() {
        return this.url;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }
}
