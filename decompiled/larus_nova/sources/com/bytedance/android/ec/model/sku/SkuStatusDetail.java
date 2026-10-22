package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u0010J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;", "Ljava/io/Serializable;", "skuStatus", "", SocialConstants.PARAM_APP_DESC, "", "descBgColor", "fontColor", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getDescBgColor", "getFontColor", "getSkuStatus", "()I", "canAppointNoStock", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "medicineRx", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuStatusDetail implements Serializable {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("desc_bg_color")
    private final String descBgColor;

    @SerializedName("font_color")
    private final String fontColor;

    @SerializedName("sku_status")
    private final int skuStatus;

    public SkuStatusDetail() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ SkuStatusDetail copy$default(SkuStatusDetail r100, int r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.skuStatus;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.desc;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.descBgColor;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.fontColor;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.skuStatus;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.descBgColor;
    }

    public final String component4() {
        return this.fontColor;
    }

    public final SkuStatusDetail copy(int r100, String r101, String r102, String r103) {
        return new SkuStatusDetail(r100, r101, r102, r103);
    }

    public int hashCode() {
        int r100 = this.skuStatus * 31;
        String r101 = this.desc;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.descBgColor;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.fontColor;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "SkuStatusDetail(skuStatus=" + this.skuStatus + ", desc=" + this.desc + ", descBgColor=" + this.descBgColor + ", fontColor=" + this.fontColor + ")";
    }

    public final boolean canAppointNoStock() {
        if (this.skuStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean medicineRx() {
        if (this.skuStatus != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDescBgColor() {
        return this.descBgColor;
    }

    public final String getFontColor() {
        return this.fontColor;
    }

    public final int getSkuStatus() {
        return this.skuStatus;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof SkuStatusDetail) == true) goto L5;
        Object r101 = null;
    L6:
        SkuStatusDetail r102 = (SkuStatusDetail) r101;
        if (r102 == null) goto L16;
        if (this.skuStatus == r102.skuStatus) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.desc, r102.desc) == false) goto L13;
        return true;
    L16:
        return Intrinsics.areEqual(r100, this);
    L5:
        r101 = r100;
        goto L6
    }

    public SkuStatusDetail(int r100, String r101, String r102, String r103) {
        this.skuStatus = r100;
        this.desc = r101;
        this.descBgColor = r102;
        this.fontColor = r103;
    }

    public /* synthetic */ SkuStatusDetail(int r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
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
