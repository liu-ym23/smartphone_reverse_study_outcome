package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/q2;", "", "", "degradeEnable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "superResolutionEnable", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q2 {

    @SerializedName("degrade_enable")
    private final boolean degradeEnable;

    @SerializedName("super_resolution_enable")
    private final boolean superResolutionEnable;

    public q2() {
        this(0);
    }

    public final boolean a() {
        return this.degradeEnable;
    }

    public final boolean b() {
        return this.superResolutionEnable;
    }

    public q2(int r100) {
        this.degradeEnable = false;
        this.superResolutionEnable = false;
    }
}
