package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/z1;", "", "", "limitDay", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "limitTime", "b", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z1 {

    @SerializedName("limit_day")
    private final Integer limitDay;

    @SerializedName("limit_time")
    private final Integer limitTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z1) == false) goto L10;
        z1 r101 = (z1) r100;
        if (Intrinsics.areEqual(this.limitDay, r101.limitDay) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.limitTime, r101.limitTime) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.limitDay;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.limitTime;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameRelatePkgInfoLimitConfig(limitDay=" + this.limitDay + ", limitTime=" + this.limitTime + ")";
    }

    public z1() {
        this.limitDay = null;
        this.limitTime = null;
    }

    public final Integer a() {
        return this.limitDay;
    }

    public final Integer b() {
        return this.limitTime;
    }
}
