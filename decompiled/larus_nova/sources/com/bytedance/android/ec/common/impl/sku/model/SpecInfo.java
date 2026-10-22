package com.bytedance.android.ec.common.impl.sku.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00100\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0086\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00068"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfo;", "Ljava/io/Serializable;", "name", "", "specType", "", "specItems", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfoItem;", "sizeComponent", "Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "hideSpec", "", "defaultSelect", "showBigPic", "showSmallPic", "extraAttribute", "Lcom/bytedance/android/ec/common/impl/sku/model/ExtraAttribute;", "specMode", "(Ljava/lang/String;ILjava/util/List;Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/ec/common/impl/sku/model/ExtraAttribute;Ljava/lang/Integer;)V", "getDefaultSelect", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExtraAttribute", "()Lcom/bytedance/android/ec/common/impl/sku/model/ExtraAttribute;", "getHideSpec", "getName", "()Ljava/lang/String;", "getShowBigPic", "getShowSmallPic", "getSizeComponent", "()Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "getSpecItems", "()Ljava/util/List;", "getSpecMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSpecType", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/util/List;Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/ec/common/impl/sku/model/ExtraAttribute;Ljava/lang/Integer;)Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfo;", "equals", "other", "", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecInfo implements Serializable {

    @SerializedName("default_select")
    private final Boolean defaultSelect;

    @SerializedName("extra_attribute")
    private final ExtraAttribute extraAttribute;

    @SerializedName("hide_spec")
    private final Boolean hideSpec;

    @SerializedName("name")
    private final String name;

    @SerializedName("show_big_pic")
    private final Boolean showBigPic;

    @SerializedName("show_small_pic")
    private final Boolean showSmallPic;

    @SerializedName("size_component")
    private final SpecChartStruct sizeComponent;

    @SerializedName("spec_items")
    private final List<SpecInfoItem> specItems;

    @SerializedName("spec_mode")
    private final Integer specMode;

    @SerializedName("spec_type")
    private final int specType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpecInfo copy$default(SpecInfo r110, String r111, int r112, List r113, SpecChartStruct r114, Boolean r115, Boolean r116, Boolean r117, Boolean r118, ExtraAttribute r210, Integer r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.name;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.specType;
    L11:
        if ((r212 & 4) == 0) goto L13;
        List r102 = r110.specItems;
    L15:
        if ((r212 & 8) == 0) goto L17;
        SpecChartStruct r103 = r110.sizeComponent;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Boolean r104 = r110.hideSpec;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Boolean r105 = r110.defaultSelect;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Boolean r106 = r110.showBigPic;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Boolean r107 = r110.showSmallPic;
    L35:
        if ((r212 & 256) == 0) goto L37;
        ExtraAttribute r119 = r110.extraAttribute;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Integer r108 = r110.specMode;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final Integer component10() {
        return this.specMode;
    }

    public final int component2() {
        return this.specType;
    }

    public final List<SpecInfoItem> component3() {
        return this.specItems;
    }

    public final SpecChartStruct component4() {
        return this.sizeComponent;
    }

    public final Boolean component5() {
        return this.hideSpec;
    }

    public final Boolean component6() {
        return this.defaultSelect;
    }

    public final Boolean component7() {
        return this.showBigPic;
    }

    public final Boolean component8() {
        return this.showSmallPic;
    }

    public final ExtraAttribute component9() {
        return this.extraAttribute;
    }

    public final SpecInfo copy(String r110, int r111, List<SpecInfoItem> r112, SpecChartStruct r113, Boolean r114, Boolean r115, Boolean r116, Boolean r210, ExtraAttribute r211, Integer r212) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r112, "specItems");
        return new SpecInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SpecInfo) == false) goto L26;
        SpecInfo r101 = (SpecInfo) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (this.specType == r101.specType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.specItems, r101.specItems) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sizeComponent, r101.sizeComponent) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hideSpec, r101.hideSpec) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.defaultSelect, r101.defaultSelect) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showBigPic, r101.showBigPic) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.showSmallPic, r101.showSmallPic) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.extraAttribute, r101.extraAttribute) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.specMode, r101.specMode) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.specType) * 31;
        List<SpecInfoItem> r104 = this.specItems;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        SpecChartStruct r107 = this.sizeComponent;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.hideSpec;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.defaultSelect;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.showBigPic;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.showSmallPic;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ExtraAttribute r122 = this.extraAttribute;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.specMode;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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

    public String toString() {
        return "SpecInfo(name=" + this.name + ", specType=" + this.specType + ", specItems=" + this.specItems + ", sizeComponent=" + this.sizeComponent + ", hideSpec=" + this.hideSpec + ", defaultSelect=" + this.defaultSelect + ", showBigPic=" + this.showBigPic + ", showSmallPic=" + this.showSmallPic + ", extraAttribute=" + this.extraAttribute + ", specMode=" + this.specMode + ")";
    }

    public final Boolean getDefaultSelect() {
        return this.defaultSelect;
    }

    public final ExtraAttribute getExtraAttribute() {
        return this.extraAttribute;
    }

    public final Boolean getHideSpec() {
        return this.hideSpec;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getShowBigPic() {
        return this.showBigPic;
    }

    public final Boolean getShowSmallPic() {
        return this.showSmallPic;
    }

    public final SpecChartStruct getSizeComponent() {
        return this.sizeComponent;
    }

    public final List<SpecInfoItem> getSpecItems() {
        return this.specItems;
    }

    public final Integer getSpecMode() {
        return this.specMode;
    }

    public final int getSpecType() {
        return this.specType;
    }

    public SpecInfo(String r100, int r101, List<SpecInfoItem> r102, SpecChartStruct r103, Boolean r104, Boolean r105, Boolean r106, Boolean r107, ExtraAttribute r110, Integer r111) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "specItems");
        this.name = r100;
        this.specType = r101;
        this.specItems = r102;
        this.sizeComponent = r103;
        this.hideSpec = r104;
        this.defaultSelect = r105;
        this.showBigPic = r106;
        this.showSmallPic = r107;
        this.extraAttribute = r110;
        this.specMode = r111;
    }

    public /* synthetic */ SpecInfo(String r110, int r111, List r112, SpecChartStruct r113, Boolean r114, Boolean r210, Boolean r211, Boolean r212, ExtraAttribute r213, Integer r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 8) == 0) goto L5;
        SpecChartStruct r100 = null;
    L7:
        if ((r215 & 16) == 0) goto L9;
        Boolean r101 = null;
    L11:
        if ((r215 & 32) == 0) goto L13;
        Boolean r102 = null;
    L15:
        if ((r215 & 64) == 0) goto L17;
        Boolean r115 = Boolean.FALSE;
    L19:
        if ((r215 & 128) == 0) goto L21;
        Boolean r116 = Boolean.FALSE;
    L23:
        if ((r215 & 256) == 0) goto L25;
        ExtraAttribute r117 = null;
    L27:
        if ((r215 & 512) == 0) goto L29;
        Integer r118 = 2;
    L30:
        this(r110, r111, r112, r100, r101, r102, r115, r116, r117, r118);
        return;
    L29:
        r118 = r214;
        goto L30
    L25:
        r117 = r213;
        goto L27
    L21:
        r116 = r212;
        goto L23
    L17:
        r115 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
