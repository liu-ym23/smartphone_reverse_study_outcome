package com.bytedance.android.ec.store.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/store/setting/e;", "", "", "delayTime", "J", "b", "()J", "resumeDelayTime", "c", "collapseShopInfoDuration", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("collapse_shop_info_duration")
    private final long collapseShopInfoDuration;

    @SerializedName("delay_time")
    private final long delayTime;

    @SerializedName("resume_delay_time")
    private final long resumeDelayTime;

    public e() {
        this(0, 0, 0);
    }

    public final long a() {
        return this.collapseShopInfoDuration;
    }

    public final long b() {
        return this.delayTime;
    }

    public final long c() {
        return this.resumeDelayTime;
    }

    public e(long r100, long r101, long r102) {
        this.delayTime = r100;
        this.resumeDelayTime = r101;
        this.collapseShopInfoDuration = r102;
    }
}
