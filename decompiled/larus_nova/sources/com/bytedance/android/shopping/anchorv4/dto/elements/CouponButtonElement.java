package com.bytedance.android.shopping.anchorv4.dto.elements;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0012HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010-\u001a\u00020\u000fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0085\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0012HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00067"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/CouponButtonElement;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "prefix", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "tagHeaderIcon", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "suffix", "radius", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", "borderColor", "", "dividerColor", "borderWidth", "", "statusId", "states", "", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/util/List;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getBorderColor", "()Ljava/lang/String;", "getBorderWidth", "()F", "getDividerColor", "getPrefix", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getRadius", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", "getStates", "()Ljava/util/List;", "getStatusId", "getSuffix", "getTagHeaderIcon", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponButtonElement implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("border_width")
    private final float borderWidth;

    @SerializedName("divider_color")
    private final String dividerColor;

    @SerializedName("prefix")
    private final TextWithOneIconElement prefix;

    @SerializedName("radius")
    private final Radius radius;

    @SerializedName("states")
    private final List<CouponButtonElement> states;

    @SerializedName("status_id")
    private final String statusId;

    @SerializedName("suffix")
    private final TextWithOneIconElement suffix;

    @SerializedName("tag_header_icon")
    private final ImageModel tagHeaderIcon;

    public CouponButtonElement() {
        this(null, null, null, null, null, null, null, 0.0f, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CouponButtonElement copy$default(CouponButtonElement r110, Action r111, TextWithOneIconElement r112, ImageModel r113, TextWithOneIconElement r114, Radius r115, String r116, String r117, float r118, String r210, List r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        Action r100 = r110.action;
    L7:
        if ((r212 & 2) == 0) goto L9;
        TextWithOneIconElement r101 = r110.prefix;
    L11:
        if ((r212 & 4) == 0) goto L13;
        ImageModel r102 = r110.tagHeaderIcon;
    L15:
        if ((r212 & 8) == 0) goto L17;
        TextWithOneIconElement r103 = r110.suffix;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Radius r104 = r110.radius;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.borderColor;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.dividerColor;
    L31:
        if ((r212 & 128) == 0) goto L33;
        float r107 = r110.borderWidth;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.statusId;
    L39:
        if ((r212 & 512) == 0) goto L41;
        List r108 = r110.states;
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

    public final Action component1() {
        return this.action;
    }

    public final List<CouponButtonElement> component10() {
        return this.states;
    }

    public final TextWithOneIconElement component2() {
        return this.prefix;
    }

    public final ImageModel component3() {
        return this.tagHeaderIcon;
    }

    public final TextWithOneIconElement component4() {
        return this.suffix;
    }

    public final Radius component5() {
        return this.radius;
    }

    public final String component6() {
        return this.borderColor;
    }

    public final String component7() {
        return this.dividerColor;
    }

    public final float component8() {
        return this.borderWidth;
    }

    public final String component9() {
        return this.statusId;
    }

    public final CouponButtonElement copy(Action r110, TextWithOneIconElement r111, ImageModel r112, TextWithOneIconElement r113, Radius r114, String r115, String r116, float r210, String r211, List<CouponButtonElement> r212) {
        return new CouponButtonElement(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CouponButtonElement) == false) goto L26;
        CouponButtonElement r101 = (CouponButtonElement) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.prefix, r101.prefix) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tagHeaderIcon, r101.tagHeaderIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.suffix, r101.suffix) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dividerColor, r101.dividerColor) == true) goto L20;
        return false;
    L20:
        if (Float.compare(this.borderWidth, r101.borderWidth) == 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        Action r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TextWithOneIconElement r104 = this.prefix;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImageModel r107 = this.tagHeaderIcon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        TextWithOneIconElement r110 = this.suffix;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Radius r113 = this.radius;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.borderColor;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.dividerColor;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (((r118 + r120) * 31) + Float.floatToIntBits(this.borderWidth)) * 31;
        String r122 = this.statusId;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<CouponButtonElement> r125 = this.states;
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
        return "CouponButtonElement(action=" + this.action + ", prefix=" + this.prefix + ", tagHeaderIcon=" + this.tagHeaderIcon + ", suffix=" + this.suffix + ", radius=" + this.radius + ", borderColor=" + this.borderColor + ", dividerColor=" + this.dividerColor + ", borderWidth=" + this.borderWidth + ", statusId=" + this.statusId + ", states=" + this.states + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final String getDividerColor() {
        return this.dividerColor;
    }

    public final TextWithOneIconElement getPrefix() {
        return this.prefix;
    }

    public final Radius getRadius() {
        return this.radius;
    }

    public final List<CouponButtonElement> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final TextWithOneIconElement getSuffix() {
        return this.suffix;
    }

    public final ImageModel getTagHeaderIcon() {
        return this.tagHeaderIcon;
    }

    public CouponButtonElement(Action r100, TextWithOneIconElement r101, ImageModel r102, TextWithOneIconElement r103, Radius r104, String r105, String r106, float r107, String r108, List<CouponButtonElement> r110) {
        this.action = r100;
        this.prefix = r101;
        this.tagHeaderIcon = r102;
        this.suffix = r103;
        this.radius = r104;
        this.borderColor = r105;
        this.dividerColor = r106;
        this.borderWidth = r107;
        this.statusId = r108;
        this.states = r110;
    }

    public /* synthetic */ CouponButtonElement(Action r110, TextWithOneIconElement r111, ImageModel r112, TextWithOneIconElement r113, Radius r114, String r115, String r116, float r117, String r210, List r211, int r212, DefaultConstructorMarker r213) {
        List r100 = null;
        if ((r212 & 1) == 0) goto L5;
        Action r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        TextWithOneIconElement r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        ImageModel r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        TextWithOneIconElement r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Radius r105 = null;
    L22:
        String r106 = "";
        if ((r212 & 32) == 0) goto L25;
        String r107 = "";
    L27:
        if ((r212 & 64) != 0) goto L31;
        r106 = r116;
    L31:
        if ((r212 & 128) == 0) goto L33;
        float r108 = 0.5f;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r107, r106, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L25:
        r107 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L22
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
