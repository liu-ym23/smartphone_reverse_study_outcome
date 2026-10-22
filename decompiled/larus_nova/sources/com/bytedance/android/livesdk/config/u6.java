package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/u6;", "", "", "propIntroduceCardEnable", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "duration", "Ljava/lang/Integer;", "getDuration", "()Ljava/lang/Integer;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u6 {

    @SerializedName("duration")
    private final Integer duration;

    @SerializedName("enable")
    private final int propIntroduceCardEnable;

    public u6() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u6) == false) goto L10;
        u6 r101 = (u6) r100;
        if (this.propIntroduceCardEnable == r101.propIntroduceCardEnable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.propIntroduceCardEnable * 31;
        Integer r101 = this.duration;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "GamePromotePropConfig(propIntroduceCardEnable=" + this.propIntroduceCardEnable + ", duration=" + this.duration + ")";
    }

    public final int a() {
        return this.propIntroduceCardEnable;
    }

    public u6(int r100) {
        this.propIntroduceCardEnable = 0;
        this.duration = null;
    }
}
