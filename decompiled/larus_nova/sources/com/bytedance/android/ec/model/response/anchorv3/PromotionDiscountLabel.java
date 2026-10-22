package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0001CB\u009b\u0001\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b@\u0010AJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J¤\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b!\u0010\"J\t\u0010#\u001a\u00020\u0002HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\u0013\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b.\u0010+R\u001a\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010/\u001a\u0004\b0\u00101R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b2\u0010+R\u001a\u0010\u0018\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00103\u001a\u0004\b4\u00105R\u001a\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b\u0019\u00101R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b6\u0010+R\u001a\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b7\u00101R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b8\u0010+R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010)\u001a\u0004\b9\u0010+R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010)\u001a\u0004\b:\u0010+R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010>\u001a\u0004\b?\u0010\u0013¨\u0006D"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", "Ljava/io/Serializable;", "", "component1", "component2", "", "component3", "component4", "", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component12", "component13", "()Ljava/lang/Integer;", "tag", "tagHeader", "type", "id", "kolUserTag", "isShow", "tagIcon", "uiType", "headerBgColor", "subType", "labelId", "imageIcon", "lineType", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;)Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getTagHeader", "I", "getType", "()I", "getId", "J", "getKolUserTag", "()J", "getTagIcon", "getUiType", "getHeaderBgColor", "getSubType", "getLabelId", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImageIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Ljava/lang/Integer;", "getLineType", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionDiscountLabel implements Serializable {
    public static final a Companion = null;
    public static final int TYPE_COUPON_COMMON = 1;
    public static final int TYPE_COUPON_DISCOUNT_PLATFORM = 3;
    public static final int TYPE_COUPON_DISCOUNT_SHOP = 2;
    public static final int TYPE_IMAGE_TAG = 6;
    public static final int TYPE_MALL_GOLD_COUPON = 5;
    public static final int UI_TYPE_0 = 0;
    public static final int UI_TYPE_1 = 1;
    public static final int UI_TYPE_2 = 2;
    public static final int UI_TYPE_3 = 3;

    @SerializedName("header_bg_color")
    private final String headerBgColor;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f47935id;

    @SerializedName("image")
    private final ECUrlModel imageIcon;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW)
    private final int isShow;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_KOL_USER_TAG)
    private final long kolUserTag;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_LABEL_ID)
    private final String labelId;

    @SerializedName("line_type")
    private final Integer lineType;

    @SerializedName("sub_type")
    private final String subType;

    @SerializedName("tag")
    private String tag;

    @SerializedName("tag_header")
    private final String tagHeader;

    @SerializedName("tag_icon")
    private final String tagIcon;

    @SerializedName("type")
    private final int type;

    @SerializedName("ui_type")
    private final int uiType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionDiscountLabel() {
        this(null, null, 0, null, 0, 0, null, 0, null, null, null, null, null, 8191, null);
    }

    public static /* synthetic */ PromotionDiscountLabel copy$default(PromotionDiscountLabel r110, String r111, String r112, int r113, String r114, long r210, int r211, String r212, int r213, String r214, String r215, String r216, ECUrlModel r217, Integer r218, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.tag;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.tagHeader;
    L11:
        if ((r310 & 4) == 0) goto L13;
        int r102 = r110.type;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r110.f47935id;
    L19:
        if ((r310 & 16) == 0) goto L21;
        long r104 = r110.kolUserTag;
    L23:
        if ((r310 & 32) == 0) goto L25;
        int r105 = r110.isShow;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r106 = r110.tagIcon;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r115 = r110.uiType;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r116 = r110.headerBgColor;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r117 = r110.subType;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r118 = r110.labelId;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        ECUrlModel r119 = r110.imageIcon;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Integer r107 = r110.lineType;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r115, r116, r117, r118, r119, r107);
    L53:
        r107 = r218;
        goto L55
    L49:
        r119 = r217;
        goto L51
    L45:
        r118 = r216;
        goto L47
    L41:
        r117 = r215;
        goto L43
    L37:
        r116 = r214;
        goto L39
    L33:
        r115 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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
        return this.tag;
    }

    public final String component10() {
        return this.subType;
    }

    public final String component11() {
        return this.labelId;
    }

    public final ECUrlModel component12() {
        return this.imageIcon;
    }

    public final Integer component13() {
        return this.lineType;
    }

    public final String component2() {
        return this.tagHeader;
    }

    public final int component3() {
        return this.type;
    }

    public final String component4() {
        return this.f47935id;
    }

    public final long component5() {
        return this.kolUserTag;
    }

    public final int component6() {
        return this.isShow;
    }

    public final String component7() {
        return this.tagIcon;
    }

    public final int component8() {
        return this.uiType;
    }

    public final String component9() {
        return this.headerBgColor;
    }

    public final PromotionDiscountLabel copy(String r110, String r111, int r112, String r210, long r211, int r212, String r213, int r214, String r215, String r216, String r217, ECUrlModel r218, Integer r310) {
        return new PromotionDiscountLabel(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionDiscountLabel) == false) goto L32;
        PromotionDiscountLabel r101 = (PromotionDiscountLabel) r100;
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tagHeader, r101.tagHeader) == true) goto L10;
        return false;
    L10:
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f47935id, r101.f47935id) == true) goto L14;
        return false;
    L14:
        if (this.kolUserTag == r101.kolUserTag) goto L16;
        return false;
    L16:
        if (this.isShow == r101.isShow) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tagIcon, r101.tagIcon) == true) goto L20;
        return false;
    L20:
        if (this.uiType == r101.uiType) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.headerBgColor, r101.headerBgColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.subType, r101.subType) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.labelId, r101.labelId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.imageIcon, r101.imageIcon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lineType, r101.lineType) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        String r100 = this.tag;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.tagHeader;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.type) * 31;
        String r107 = this.f47935id;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.kolUserTag;
        int r111 = (((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.isShow) * 31;
        String r112 = this.tagIcon;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (((r111 + r113) * 31) + this.uiType) * 31;
        String r115 = this.headerBgColor;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.subType;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.labelId;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        ECUrlModel r124 = this.imageIcon;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        Integer r127 = this.lineType;
        if (r127 == null) goto L38;
        r101 = r127.hashCode();
    L38:
        return r126 + r101;
    L33:
        r125 = 0;
        goto L34
    L29:
        r122 = 0;
        goto L30
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
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
        return "PromotionDiscountLabel(tag=" + this.tag + ", tagHeader=" + this.tagHeader + ", type=" + this.type + ", id=" + this.f47935id + ", kolUserTag=" + this.kolUserTag + ", isShow=" + this.isShow + ", tagIcon=" + this.tagIcon + ", uiType=" + this.uiType + ", headerBgColor=" + this.headerBgColor + ", subType=" + this.subType + ", labelId=" + this.labelId + ", imageIcon=" + this.imageIcon + ", lineType=" + this.lineType + ")";
    }

    public final String getHeaderBgColor() {
        return this.headerBgColor;
    }

    public final String getId() {
        return this.f47935id;
    }

    public final ECUrlModel getImageIcon() {
        return this.imageIcon;
    }

    public final long getKolUserTag() {
        return this.kolUserTag;
    }

    public final String getLabelId() {
        return this.labelId;
    }

    public final Integer getLineType() {
        return this.lineType;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getTagHeader() {
        return this.tagHeader;
    }

    public final String getTagIcon() {
        return this.tagIcon;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public final int isShow() {
        return this.isShow;
    }

    public final void setTag(String r100) {
        this.tag = r100;
    }

    public PromotionDiscountLabel(String r100, String r101, int r102, String r103, long r104, int r105, String r106, int r107, String r110, String r111, String r112, ECUrlModel r113, Integer r114) {
        this.tag = r100;
        this.tagHeader = r101;
        this.type = r102;
        this.f47935id = r103;
        this.kolUserTag = r104;
        this.isShow = r105;
        this.tagIcon = r106;
        this.uiType = r107;
        this.headerBgColor = r110;
        this.subType = r111;
        this.labelId = r112;
        this.imageIcon = r113;
        this.lineType = r114;
    }

    public /* synthetic */ PromotionDiscountLabel(String r110, String r111, int r112, String r113, long r210, int r211, String r212, int r213, String r214, String r215, String r216, ECUrlModel r217, Integer r218, int r310, DefaultConstructorMarker r311) {
        String r100 = "";
        if ((r310 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r310 & 4) == 0) goto L13;
        int r103 = 1;
    L15:
        if ((r310 & 8) != 0) goto L19;
        r100 = r113;
    L19:
        if ((r310 & 16) == 0) goto L21;
        long r104 = 0;
    L22:
        int r105 = 0;
        if ((r310 & 32) == 0) goto L25;
        int r106 = 0;
    L26:
        Integer r114 = null;
        if ((r310 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r310 & 128) != 0) goto L35;
        r105 = r213;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        ECUrlModel r118 = null;
    L51:
        if ((r310 & 4096) != 0) goto L54;
        r114 = r218;
    L54:
        this(r101, r102, r103, r100, r104, r106, r107, r105, r115, r116, r117, r118, r114);
        return;
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L26
    L21:
        r104 = r210;
        goto L22
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
