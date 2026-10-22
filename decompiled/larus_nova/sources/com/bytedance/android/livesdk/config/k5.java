package com.bytedance.android.livesdk.config;

import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/k5;", "", "", "enable", "Z", "getEnable", "()Z", "", "priority", "I", "getPriority", "()I", "", "rom", "Ljava/lang/String;", "getRom", "()Ljava/lang/String;", "romVersion", "getRomVersion", "buildVersion", "getBuildVersion", CommonConstant.KEY_DISPLAY_NAME, "getDisplayName", "layerName", "getLayerName", "layerFlag", "getLayerFlag", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k5 {

    @SerializedName("build_version")
    private final int buildVersion;

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("layer_flag")
    private final int layerFlag;

    @SerializedName("layer_name")
    private final String layerName;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("rom")
    private final String rom;

    @SerializedName("rom_version")
    private final String romVersion;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k5) == false) goto L22;
        k5 r101 = (k5) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.priority == r101.priority) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rom, r101.rom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.romVersion, r101.romVersion) == true) goto L14;
        return false;
    L14:
        if (this.buildVersion == r101.buildVersion) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.layerName, r101.layerName) == true) goto L20;
        return false;
    L20:
        if (this.layerFlag == r101.layerFlag) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.priority) * 31;
        String r103 = this.rom;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.romVersion;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (((r106 + r108) * 31) + this.buildVersion) * 31;
        String r110 = this.displayName;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.layerName;
        if (r113 == null) goto L21;
        r104 = r113.hashCode();
    L21:
        return ((r112 + r104) * 31) + this.layerFlag;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public k5() {
        Intrinsics.checkNotNullParameter("", "rom");
        Intrinsics.checkNotNullParameter("", "romVersion");
        Intrinsics.checkNotNullParameter("", CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter("", "layerName");
        this.enable = false;
        this.priority = 0;
        this.rom = "";
        this.romVersion = "";
        this.buildVersion = -1;
        this.displayName = "";
        this.layerName = "";
        this.layerFlag = -1;
    }

    public final String toString() {
        return "FilterRomConfig(enable=" + this.enable + ", rom='" + this.rom + "', romVersion='" + this.romVersion + "', buildVersion=" + this.buildVersion + ", displayName='" + this.displayName + "', layerName='" + this.layerName + "', layerFlag=" + this.layerFlag + ')';
    }
}
