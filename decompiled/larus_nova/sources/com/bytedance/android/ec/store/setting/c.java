package com.bytedance.android.ec.store.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/store/setting/c;", "", "", "enable", "Z", "b", "()Z", "", "delayTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("delay_time")
    private final long delayTime;

    @SerializedName("enable")
    private final boolean enable;

    public c() {
        this(false, 0);
    }

    public final long a() {
        return this.delayTime;
    }

    public final boolean b() {
        return this.enable;
    }

    public c(boolean r100, long r101) {
        this.enable = r100;
        this.delayTime = r101;
    }
}
