package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000f¨\u0006&"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/u;", "", "", "createTime", "J", "getCreateTime", "()J", "setCreateTime", "(J)V", "", "createReason", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setCreateReason", "(Ljava/lang/String;)V", "publicKey", "b", "setPublicKey", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "getModel", "setModel", "brand", "getBrand", "setBrand", "", com.heytap.mcssdk.constant.b.C, "I", "getSdkVersion", "()I", "setSdkVersion", "(I)V", "displayOsVersion", "getDisplayOsVersion", "setDisplayOsVersion", "deviceId", "getDeviceId", "setDeviceId", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class u {

    @SerializedName("brand")
    private String brand;

    @SerializedName("create_reason")
    private String createReason;

    @SerializedName("create_time")
    private long createTime;

    @SerializedName("device_id")
    private String deviceId;

    @SerializedName("display_os_version")
    private String displayOsVersion;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private String model;

    @SerializedName("pub_key")
    private String publicKey;

    @SerializedName("sdk_version")
    private int sdkVersion;

    public u() {
        this(0, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L30:
        return true;
    L5:
        if ((r100 instanceof u) == false) goto L29;
        u r101 = (u) r100;
        if (this.createTime != r101.createTime) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L29;
        if (Intrinsics.areEqual(this.createReason, r101.createReason) == false) goto L29;
        if (Intrinsics.areEqual(this.publicKey, r101.publicKey) == false) goto L29;
        if (Intrinsics.areEqual(this.model, r101.model) == false) goto L29;
        if (Intrinsics.areEqual(this.brand, r101.brand) == false) goto L29;
        if (this.sdkVersion != r101.sdkVersion) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == false) goto L29;
        if (Intrinsics.areEqual(this.displayOsVersion, r101.displayOsVersion) == false) goto L29;
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == false) goto L29;
    L22:
        r103 = false;
        goto L23
    L9:
        r102 = false;
    L29:
        return false;
    }

    public final int hashCode() {
        long r100 = this.createTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.createReason;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.publicKey;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.model;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.brand;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (((r111 + r113) * 31) + this.sdkVersion) * 31;
        String r115 = this.displayOsVersion;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.deviceId;
        if (r118 == null) goto L26;
        r103 = r118.hashCode();
    L26:
        return r117 + r103;
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "KeyCreateLogEntry(createTime=" + this.createTime + ", createReason=" + this.createReason + ", publicKey=" + this.publicKey + ", model=" + this.model + ", brand=" + this.brand + ", sdkVersion=" + this.sdkVersion + ", displayOsVersion=" + this.displayOsVersion + ", deviceId=" + this.deviceId + ")";
    }

    public final String a() {
        return this.createReason;
    }

    public final String b() {
        return this.publicKey;
    }

    public /* synthetic */ u(long r110, String r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r110 = 0;
    L5:
        long r100 = r110;
        if ((r113 & 2) == 0) goto L8;
        String r101 = "";
    L10:
        if ((r113 & 4) == 0) goto L12;
        String r102 = "";
    L14:
        if ((r113 & 8) == 0) goto L16;
        String r103 = "";
    L18:
        if ((r113 & 16) == 0) goto L20;
        String r104 = "";
    L22:
        if ((r113 & 64) == 0) goto L24;
        String r105 = "";
    L26:
        if ((r113 & 128) == 0) goto L28;
        String r106 = "";
    L29:
        this(r100, r101, r102, r103, r104, 0, r105, r106);
        return;
    L28:
        r106 = null;
        goto L29
    L24:
        r105 = null;
        goto L26
    L20:
        r104 = null;
        goto L22
    L16:
        r103 = null;
        goto L18
    L12:
        r102 = r112;
        goto L14
    L8:
        r101 = r111;
        goto L10
    }

    public u(long r100, String r101, String r102, String r103, String r104, int r105, String r106, String r107) {
        this.createTime = r100;
        this.createReason = r101;
        this.publicKey = r102;
        this.model = r103;
        this.brand = r104;
        this.sdkVersion = r105;
        this.displayOsVersion = r106;
        this.deviceId = r107;
    }
}
