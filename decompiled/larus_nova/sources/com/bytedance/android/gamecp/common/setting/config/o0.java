package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/o0;", "", "", "osVerson", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "minOSVersion", "d", "hmOSVersion", "c", "romName", "f", "romVersion", ce.f26391f, "brandName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "deviceModel", "b", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o0 {

    @SerializedName("brand")
    private final String brandName;

    @SerializedName("device_model")
    private final String deviceModel;

    @SerializedName("hm_os_version")
    private final String hmOSVersion;

    @SerializedName("min_os_version")
    private final String minOSVersion;

    @SerializedName("os_version")
    private final String osVerson;

    @SerializedName("rom_name")
    private final String romName;

    @SerializedName("rom_version")
    private final String romVersion;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o0) == false) goto L20;
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.osVerson, r101.osVerson) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.minOSVersion, r101.minOSVersion) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.hmOSVersion, r101.hmOSVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.romName, r101.romName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.romVersion, r101.romVersion) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.brandName, r101.brandName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.deviceModel, r101.deviceModel) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.osVerson;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.minOSVersion;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.hmOSVersion;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.romName;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.romVersion;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.brandName;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.deviceModel;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "CustomInstallDeviceConfig(osVerson=" + this.osVerson + ", minOSVersion=" + this.minOSVersion + ", hmOSVersion=" + this.hmOSVersion + ", romName=" + this.romName + ", romVersion=" + this.romVersion + ", brandName=" + this.brandName + ", deviceModel=" + this.deviceModel + ")";
    }

    public o0() {
        this.osVerson = "";
        this.minOSVersion = "";
        this.hmOSVersion = "";
        this.romName = "";
        this.romVersion = "";
        this.brandName = "";
        this.deviceModel = "";
    }

    public final String a() {
        return this.brandName;
    }

    public final String b() {
        return this.deviceModel;
    }

    public final String c() {
        return this.hmOSVersion;
    }

    public final String d() {
        return this.minOSVersion;
    }

    public final String e() {
        return this.osVerson;
    }

    public final String f() {
        return this.romName;
    }

    public final String g() {
        return this.romVersion;
    }
}
