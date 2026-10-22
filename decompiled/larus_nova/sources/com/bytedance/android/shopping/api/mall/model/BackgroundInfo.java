package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/BackgroundInfo;", "", "bgColor", "", "bgUrl", "baseBgColor", "headerBgUrl", "bgGradientConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseBgColor", "()Ljava/lang/String;", "getBgColor", "getBgGradientConfig", "getBgUrl", "getHeaderBgUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackgroundInfo {

    @SerializedName("base_bg_color")
    private final String baseBgColor;

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("bg_gradient_config")
    private final String bgGradientConfig;

    @SerializedName("bg_url")
    private final String bgUrl;

    @SerializedName("header_bg_url")
    private final String headerBgUrl;

    public BackgroundInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BackgroundInfo copy$default(BackgroundInfo r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.bgColor;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.bgUrl;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.baseBgColor;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.headerBgUrl;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.bgGradientConfig;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.bgColor;
    }

    public final String component2() {
        return this.bgUrl;
    }

    public final String component3() {
        return this.baseBgColor;
    }

    public final String component4() {
        return this.headerBgUrl;
    }

    public final String component5() {
        return this.bgGradientConfig;
    }

    public final BackgroundInfo copy(String r100, String r101, String r110, String r111, String r112) {
        return new BackgroundInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BackgroundInfo) == false) goto L16;
        BackgroundInfo r101 = (BackgroundInfo) r100;
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bgUrl, r101.bgUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.baseBgColor, r101.baseBgColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.headerBgUrl, r101.headerBgUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bgGradientConfig, r101.bgGradientConfig) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.bgColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.bgUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.baseBgColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.headerBgUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.bgGradientConfig;
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

    public String toString() {
        return "BackgroundInfo(bgColor=" + this.bgColor + ", bgUrl=" + this.bgUrl + ", baseBgColor=" + this.baseBgColor + ", headerBgUrl=" + this.headerBgUrl + ", bgGradientConfig=" + this.bgGradientConfig + ")";
    }

    public final String getBaseBgColor() {
        return this.baseBgColor;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getBgGradientConfig() {
        return this.bgGradientConfig;
    }

    public final String getBgUrl() {
        return this.bgUrl;
    }

    public final String getHeaderBgUrl() {
        return this.headerBgUrl;
    }

    public BackgroundInfo(String r100, String r101, String r102, String r103, String r104) {
        this.bgColor = r100;
        this.bgUrl = r101;
        this.baseBgColor = r102;
        this.headerBgUrl = r103;
        this.bgGradientConfig = r104;
    }

    public /* synthetic */ BackgroundInfo(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
