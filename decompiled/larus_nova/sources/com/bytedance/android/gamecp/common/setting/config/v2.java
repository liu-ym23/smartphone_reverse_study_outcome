package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/v2;", "", "", "microGamePkgSize", "Ljava/lang/Double;", "b", "()Ljava/lang/Double;", "", "", "microGameList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "microGameGetOriginPkgEnable", "Ljava/lang/Boolean;", "getMicroGameGetOriginPkgEnable", "()Ljava/lang/Boolean;", "", "microGameOriginPkgDelayTime", "Ljava/lang/Integer;", "getMicroGameOriginPkgDelayTime", "()Ljava/lang/Integer;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v2 {

    @SerializedName("micro_game_get_origin_pkg_enable")
    private final Boolean microGameGetOriginPkgEnable;

    @SerializedName("micro_game_list")
    private final List<String> microGameList;

    @SerializedName("micro_game_origin_pkg_delay_time")
    private final Integer microGameOriginPkgDelayTime;

    @SerializedName("micro_game_pkg_size")
    private final Double microGamePkgSize;

    public v2() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v2) == false) goto L14;
        v2 r101 = (v2) r100;
        if (Intrinsics.areEqual(this.microGamePkgSize, r101.microGamePkgSize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.microGameList, r101.microGameList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.microGameGetOriginPkgEnable, r101.microGameGetOriginPkgEnable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.microGameOriginPkgDelayTime, r101.microGameOriginPkgDelayTime) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Double r100 = this.microGamePkgSize;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.microGameList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.microGameGetOriginPkgEnable;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.microGameOriginPkgDelayTime;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MicroGameConfig(microGamePkgSize=" + this.microGamePkgSize + ", microGameList=" + this.microGameList + ", microGameGetOriginPkgEnable=" + this.microGameGetOriginPkgEnable + ", microGameOriginPkgDelayTime=" + this.microGameOriginPkgDelayTime + ")";
    }

    public final List<String> a() {
        return this.microGameList;
    }

    public final Double b() {
        return this.microGamePkgSize;
    }

    public v2(Object r100) {
        Double r101 = Double.valueOf(7.0d);
        ArrayList r102 = new ArrayList();
        Boolean r103 = Boolean.TRUE;
        this.microGamePkgSize = r101;
        this.microGameList = r102;
        this.microGameGetOriginPkgEnable = r103;
        this.microGameOriginPkgDelayTime = 14;
    }
}
