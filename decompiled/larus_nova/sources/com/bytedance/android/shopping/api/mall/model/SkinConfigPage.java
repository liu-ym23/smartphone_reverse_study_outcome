package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigPage;", "", "bgUrl", "", "bgUrlFold", "bgColor", "bgGradientConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "getBgGradientConfig", "getBgUrl", "getBgUrlFold", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkinConfigPage {

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("bg_gradient_config")
    private final String bgGradientConfig;

    @SerializedName("bg_url")
    private final String bgUrl;

    @SerializedName("bg_url_fold")
    private final String bgUrlFold;

    public SkinConfigPage() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SkinConfigPage copy$default(SkinConfigPage r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.bgUrl;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.bgUrlFold;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.bgColor;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bgGradientConfig;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.bgUrl;
    }

    public final String component2() {
        return this.bgUrlFold;
    }

    public final String component3() {
        return this.bgColor;
    }

    public final String component4() {
        return this.bgGradientConfig;
    }

    public final SkinConfigPage copy(String r100, String r101, String r102, String r103) {
        return new SkinConfigPage(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkinConfigPage) == false) goto L14;
        SkinConfigPage r101 = (SkinConfigPage) r100;
        if (Intrinsics.areEqual(this.bgUrl, r101.bgUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bgUrlFold, r101.bgUrlFold) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgGradientConfig, r101.bgGradientConfig) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.bgUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.bgUrlFold;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bgColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bgGradientConfig;
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

    public String toString() {
        return "SkinConfigPage(bgUrl=" + this.bgUrl + ", bgUrlFold=" + this.bgUrlFold + ", bgColor=" + this.bgColor + ", bgGradientConfig=" + this.bgGradientConfig + ")";
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

    public final String getBgUrlFold() {
        return this.bgUrlFold;
    }

    public SkinConfigPage(String r100, String r101, String r102, String r103) {
        this.bgUrl = r100;
        this.bgUrlFold = r101;
        this.bgColor = r102;
        this.bgGradientConfig = r103;
    }

    public /* synthetic */ SkinConfigPage(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
