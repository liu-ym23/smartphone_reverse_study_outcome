package com.bytedance.android.ec.store.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/store/setting/b;", "", "", "timeOut", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "", "appVersion", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "lynxVersion", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("app_version_key")
    private final Integer appVersion;

    @SerializedName("lynx_version_key")
    private final Integer lynxVersion;

    @SerializedName("time_out_key")
    private final Long timeOut;

    public b() {
        this.timeOut = null;
        this.appVersion = null;
        this.lynxVersion = null;
    }

    public final Integer a() {
        return this.appVersion;
    }

    public final Integer b() {
        return this.lynxVersion;
    }

    public final Long c() {
        return this.timeOut;
    }
}
