package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\t\u0010)\u001a\u00020\u0012HÆ\u0003J\t\u0010*\u001a\u00020\u0012HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J§\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012HÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0012HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006:"}, d2 = {"Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "Ljava/io/Serializable;", "type", "", "text", "icon", "Lcom/bytedance/android/ec/model/sku/ImageObject;", "textColor", "bgColor", "JumpUrl", "buttonText", "buttonTextColor", "buttonBorderColor", "buttonIcon", "highLightItems", "", "Lcom/bytedance/android/ec/model/sku/HighLightItem;", "bottomOffset", "", "alignmentType", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/ImageObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/ImageObject;Ljava/util/List;II)V", "getJumpUrl", "()Ljava/lang/String;", "getAlignmentType", "()I", "getBgColor", "getBottomOffset", "getButtonBorderColor", "getButtonIcon", "()Lcom/bytedance/android/ec/model/sku/ImageObject;", "getButtonText", "getButtonTextColor", "getHighLightItems", "()Ljava/util/List;", "getIcon", "getText", "getTextColor", "getType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ButtonTipComponent implements Serializable {

    @SerializedName("jump_url")
    private final String JumpUrl;

    @SerializedName("alignment_type")
    private final int alignmentType;

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("bottom_offset")
    private final int bottomOffset;

    @SerializedName("button_border_color")
    private final String buttonBorderColor;

    @SerializedName("button_icon")
    private final ImageObject buttonIcon;

    @SerializedName("button_text")
    private final String buttonText;

    @SerializedName("button_text_color")
    private final String buttonTextColor;

    @SerializedName("high_light_items")
    private final List<HighLightItem> highLightItems;

    @SerializedName("icon")
    private final ImageObject icon;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("type")
    private final String type;

    public ButtonTipComponent() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, 0, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ButtonTipComponent copy$default(ButtonTipComponent r110, String r111, String r112, ImageObject r113, String r114, String r115, String r210, String r211, String r212, String r213, ImageObject r214, List r215, int r216, int r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.type;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.text;
    L11:
        if ((r218 & 4) == 0) goto L13;
        ImageObject r102 = r110.icon;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.textColor;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r104 = r110.bgColor;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r105 = r110.JumpUrl;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r106 = r110.buttonText;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.buttonTextColor;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.buttonBorderColor;
    L39:
        if ((r218 & 512) == 0) goto L41;
        ImageObject r117 = r110.buttonIcon;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        List r118 = r110.highLightItems;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        int r119 = r110.bottomOffset;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        int r108 = r110.alignmentType;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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
        return this.type;
    }

    public final ImageObject component10() {
        return this.buttonIcon;
    }

    public final List<HighLightItem> component11() {
        return this.highLightItems;
    }

    public final int component12() {
        return this.bottomOffset;
    }

    public final int component13() {
        return this.alignmentType;
    }

    public final String component2() {
        return this.text;
    }

    public final ImageObject component3() {
        return this.icon;
    }

    public final String component4() {
        return this.textColor;
    }

    public final String component5() {
        return this.bgColor;
    }

    public final String component6() {
        return this.JumpUrl;
    }

    public final String component7() {
        return this.buttonText;
    }

    public final String component8() {
        return this.buttonTextColor;
    }

    public final String component9() {
        return this.buttonBorderColor;
    }

    public final ButtonTipComponent copy(String r110, String r111, ImageObject r112, String r113, String r210, String r211, String r212, String r213, String r214, ImageObject r215, List<HighLightItem> r216, int r217, int r218) {
        return new ButtonTipComponent(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ButtonTipComponent) == false) goto L32;
        ButtonTipComponent r101 = (ButtonTipComponent) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.JumpUrl, r101.JumpUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.buttonText, r101.buttonText) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.buttonTextColor, r101.buttonTextColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.buttonBorderColor, r101.buttonBorderColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonIcon, r101.buttonIcon) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.highLightItems, r101.highLightItems) == true) goto L28;
        return false;
    L28:
        if (this.bottomOffset == r101.bottomOffset) goto L30;
        return false;
    L30:
        if (this.alignmentType == r101.alignmentType) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImageObject r107 = this.icon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.textColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.bgColor;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.JumpUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.buttonText;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.buttonTextColor;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.buttonBorderColor;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        ImageObject r128 = this.buttonIcon;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        List<HighLightItem> r131 = this.highLightItems;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return ((((r130 + r101) * 31) + this.bottomOffset) * 31) + this.alignmentType;
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
        return "ButtonTipComponent(type=" + this.type + ", text=" + this.text + ", icon=" + this.icon + ", textColor=" + this.textColor + ", bgColor=" + this.bgColor + ", JumpUrl=" + this.JumpUrl + ", buttonText=" + this.buttonText + ", buttonTextColor=" + this.buttonTextColor + ", buttonBorderColor=" + this.buttonBorderColor + ", buttonIcon=" + this.buttonIcon + ", highLightItems=" + this.highLightItems + ", bottomOffset=" + this.bottomOffset + ", alignmentType=" + this.alignmentType + ")";
    }

    public final int getAlignmentType() {
        return this.alignmentType;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final int getBottomOffset() {
        return this.bottomOffset;
    }

    public final String getButtonBorderColor() {
        return this.buttonBorderColor;
    }

    public final ImageObject getButtonIcon() {
        return this.buttonIcon;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getButtonTextColor() {
        return this.buttonTextColor;
    }

    public final List<HighLightItem> getHighLightItems() {
        return this.highLightItems;
    }

    public final ImageObject getIcon() {
        return this.icon;
    }

    public final String getJumpUrl() {
        return this.JumpUrl;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getType() {
        return this.type;
    }

    public ButtonTipComponent(String r100, String r101, ImageObject r102, String r103, String r104, String r105, String r106, String r107, String r108, ImageObject r110, List<HighLightItem> r111, int r112, int r113) {
        this.type = r100;
        this.text = r101;
        this.icon = r102;
        this.textColor = r103;
        this.bgColor = r104;
        this.JumpUrl = r105;
        this.buttonText = r106;
        this.buttonTextColor = r107;
        this.buttonBorderColor = r108;
        this.buttonIcon = r110;
        this.highLightItems = r111;
        this.bottomOffset = r112;
        this.alignmentType = r113;
    }

    public /* synthetic */ ButtonTipComponent(String r110, String r111, ImageObject r112, String r113, String r114, String r115, String r210, String r211, String r212, ImageObject r213, List r214, int r215, int r216, int r217, DefaultConstructorMarker r218) {
        List r100 = null;
        if ((r217 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r217 & 4) == 0) goto L13;
        ImageObject r103 = null;
    L15:
        if ((r217 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r217 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r217 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r217 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r217 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r217 & 512) == 0) goto L41;
        ImageObject r117 = null;
    L43:
        if ((r217 & 1024) != 0) goto L47;
        r100 = r214;
    L47:
        if ((r217 & 2048) == 0) goto L49;
        int r118 = 8;
    L51:
        if ((r217 & 4096) == 0) goto L53;
        int r109 = 0;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r100, r118, r109);
        return;
    L53:
        r109 = r216;
        goto L54
    L49:
        r118 = r215;
        goto L51
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
