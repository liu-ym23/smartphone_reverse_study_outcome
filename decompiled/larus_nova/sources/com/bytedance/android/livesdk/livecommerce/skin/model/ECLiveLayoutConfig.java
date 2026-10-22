package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveLayoutConfig;", "Ljava/io/Serializable;", "topMargin", "", "bottomMargin", "leftMargin", "rightMargin", "topPadding", "bottomPadding", "leftPadding", "rightPadding", "width", "height", "widthSelfAdapt", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getBottomMargin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBottomPadding", "getHeight", "getLeftMargin", "getLeftPadding", "getRightMargin", "getRightPadding", "getTopMargin", "getTopPadding", "getWidth", "getWidthSelfAdapt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveLayoutConfig;", "equals", "other", "", "hashCode", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveLayoutConfig implements Serializable {

    @SerializedName("bottom_margin")
    private final Integer bottomMargin;

    @SerializedName("bottom_padding")
    private final Integer bottomPadding;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("left_margin")
    private final Integer leftMargin;

    @SerializedName("left_padding")
    private final Integer leftPadding;

    @SerializedName("right_margin")
    private final Integer rightMargin;

    @SerializedName("right_padding")
    private final Integer rightPadding;

    @SerializedName("top_margin")
    private final Integer topMargin;

    @SerializedName("top_padding")
    private final Integer topPadding;

    @SerializedName("width")
    private final Integer width;

    @SerializedName("width_self_adapt")
    private final Boolean widthSelfAdapt;

    public ECLiveLayoutConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ ECLiveLayoutConfig copy$default(ECLiveLayoutConfig r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Integer r116, Integer r117, Integer r210, Integer r211, Integer r212, Boolean r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        Integer r100 = r110.topMargin;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Integer r101 = r110.bottomMargin;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r102 = r110.leftMargin;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Integer r103 = r110.rightMargin;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Integer r104 = r110.topPadding;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Integer r105 = r110.bottomPadding;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Integer r106 = r110.leftPadding;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Integer r107 = r110.rightPadding;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Integer r118 = r110.width;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Integer r119 = r110.height;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Boolean r108 = r110.widthSelfAdapt;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final Integer component1() {
        return this.topMargin;
    }

    public final Integer component10() {
        return this.height;
    }

    public final Boolean component11() {
        return this.widthSelfAdapt;
    }

    public final Integer component2() {
        return this.bottomMargin;
    }

    public final Integer component3() {
        return this.leftMargin;
    }

    public final Integer component4() {
        return this.rightMargin;
    }

    public final Integer component5() {
        return this.topPadding;
    }

    public final Integer component6() {
        return this.bottomPadding;
    }

    public final Integer component7() {
        return this.leftPadding;
    }

    public final Integer component8() {
        return this.rightPadding;
    }

    public final Integer component9() {
        return this.width;
    }

    public final ECLiveLayoutConfig copy(Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Integer r210, Integer r211, Integer r212, Integer r213, Boolean r214) {
        return new ECLiveLayoutConfig(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECLiveLayoutConfig) == false) goto L28;
        ECLiveLayoutConfig r101 = (ECLiveLayoutConfig) r100;
        if (Intrinsics.areEqual(this.topMargin, r101.topMargin) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bottomMargin, r101.bottomMargin) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftMargin, r101.leftMargin) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightMargin, r101.rightMargin) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.topPadding, r101.topPadding) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bottomPadding, r101.bottomPadding) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.leftPadding, r101.leftPadding) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.rightPadding, r101.rightPadding) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.widthSelfAdapt, r101.widthSelfAdapt) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.topMargin;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.bottomMargin;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.leftMargin;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.rightMargin;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.topPadding;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.bottomPadding;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.leftPadding;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.rightPadding;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.width;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.height;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.widthSelfAdapt;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
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
        return "ECLiveLayoutConfig(topMargin=" + this.topMargin + ", bottomMargin=" + this.bottomMargin + ", leftMargin=" + this.leftMargin + ", rightMargin=" + this.rightMargin + ", topPadding=" + this.topPadding + ", bottomPadding=" + this.bottomPadding + ", leftPadding=" + this.leftPadding + ", rightPadding=" + this.rightPadding + ", width=" + this.width + ", height=" + this.height + ", widthSelfAdapt=" + this.widthSelfAdapt + ")";
    }

    public final Integer getBottomMargin() {
        return this.bottomMargin;
    }

    public final Integer getBottomPadding() {
        return this.bottomPadding;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getLeftMargin() {
        return this.leftMargin;
    }

    public final Integer getLeftPadding() {
        return this.leftPadding;
    }

    public final Integer getRightMargin() {
        return this.rightMargin;
    }

    public final Integer getRightPadding() {
        return this.rightPadding;
    }

    public final Integer getTopMargin() {
        return this.topMargin;
    }

    public final Integer getTopPadding() {
        return this.topPadding;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Boolean getWidthSelfAdapt() {
        return this.widthSelfAdapt;
    }

    public ECLiveLayoutConfig(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r106, Integer r107, Integer r108, Integer r110, Boolean r111) {
        this.topMargin = r100;
        this.bottomMargin = r101;
        this.leftMargin = r102;
        this.rightMargin = r103;
        this.topPadding = r104;
        this.bottomPadding = r105;
        this.leftPadding = r106;
        this.rightPadding = r107;
        this.width = r108;
        this.height = r110;
        this.widthSelfAdapt = r111;
    }

    public /* synthetic */ ECLiveLayoutConfig(Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Integer r116, Integer r210, Integer r211, Integer r212, Boolean r213, int r214, DefaultConstructorMarker r215) {
        Boolean r100 = null;
        if ((r214 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Integer r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Integer r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
