package com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/downloadbutton/h;", "", "", "packageSizeSwitch", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "supportPlatform", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "unsupportedDownloadButtonText", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "mapId", "getMapId", "mapName", "getMapName", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("map_id")
    private final String mapId;

    @SerializedName("map_name")
    private final String mapName;

    @SerializedName("package_size_switch")
    private final Boolean packageSizeSwitch;

    @SerializedName("support_platforms")
    private final Long supportPlatform;

    @SerializedName("unsupported_download_btn_text")
    private final String unsupportedDownloadButtonText;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L16;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.packageSizeSwitch, r101.packageSizeSwitch) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.supportPlatform, r101.supportPlatform) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.unsupportedDownloadButtonText, r101.unsupportedDownloadButtonText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mapId, r101.mapId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.mapName, r101.mapName) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.packageSizeSwitch;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.supportPlatform;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.unsupportedDownloadButtonText;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mapId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.mapName;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "GameDownloadInfo(packageSizeSwitch=" + this.packageSizeSwitch + ", supportPlatform=" + this.supportPlatform + ", unsupportedDownloadButtonText=" + this.unsupportedDownloadButtonText + ", mapId=" + this.mapId + ", mapName=" + this.mapName + ")";
    }

    public h() {
        this.packageSizeSwitch = null;
        this.supportPlatform = 0L;
        this.unsupportedDownloadButtonText = null;
        this.mapId = "";
        this.mapName = "";
    }

    public final Boolean a() {
        return this.packageSizeSwitch;
    }

    public final Long b() {
        return this.supportPlatform;
    }

    public final String c() {
        return this.unsupportedDownloadButtonText;
    }
}
