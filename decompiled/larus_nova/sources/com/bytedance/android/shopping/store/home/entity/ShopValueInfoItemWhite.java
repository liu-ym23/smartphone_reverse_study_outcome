package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\b\u0086\b\u0018\u0000 H2\u00020\u0001:\u0001IB\u0099\u0001\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010¢\u0006\u0004\bF\u0010GJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010HÆ\u0003J¢\u0001\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0002HÖ\u0001J\u0013\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010(R$\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010)\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R$\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010)\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010)\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00104\u001a\u0004\b9\u00106\"\u0004\b:\u00108R$\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010)\u001a\u0004\b;\u0010+\"\u0004\b<\u0010-R$\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010)\u001a\u0004\b=\u0010+\"\u0004\b>\u0010-R$\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010)\u001a\u0004\b?\u0010+\"\u0004\b@\u0010-R2\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006J"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopValueInfoItemWhite;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Integer;", "", "component2", "component3", "component4", "component5", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component6", "component7", "component8", "component9", "component10", "", "component11", "itemType", "valueText", "valueTextColor", SocialConstants.PARAM_APP_DESC, "descTextColor", "descRightIcon", "icon", "url", "showEventName", "clickEventName", "eventParams", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/bytedance/android/shopping/store/home/entity/ShopValueInfoItemWhite;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Integer;", "getItemType", "setItemType", "(Ljava/lang/Integer;)V", "Ljava/lang/String;", "getValueText", "()Ljava/lang/String;", "setValueText", "(Ljava/lang/String;)V", "getValueTextColor", "setValueTextColor", "getDesc", "setDesc", "getDescTextColor", "setDescTextColor", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getDescRightIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setDescRightIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getIcon", "setIcon", "getUrl", "setUrl", "getShowEventName", "setShowEventName", "getClickEventName", "setClickEventName", "Ljava/util/Map;", "getEventParams", "()Ljava/util/Map;", "setEventParams", "(Ljava/util/Map;)V", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopValueInfoItemWhite implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 3;

    @SerializedName("click_event_name")
    private String clickEventName;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("desc_right_icon")
    private ECUrlModel descRightIcon;

    @SerializedName("desc_text_color")
    private String descTextColor;

    @SerializedName("common_event_params")
    private Map<String, String> eventParams;

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private Integer itemType;

    @SerializedName("show_event_name")
    private String showEventName;

    @SerializedName("url")
    private String url;

    @SerializedName("value_text")
    private String valueText;

    @SerializedName("value_text_color")
    private String valueTextColor;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShopValueInfoItemWhite() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShopValueInfoItemWhite copy$default(ShopValueInfoItemWhite r110, Integer r111, String r112, String r113, String r114, String r115, ECUrlModel r116, ECUrlModel r117, String r210, String r211, String r212, Map r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        Integer r100 = r110.itemType;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.valueText;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.valueTextColor;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.desc;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.descTextColor;
    L23:
        if ((r214 & 32) == 0) goto L25;
        ECUrlModel r105 = r110.descRightIcon;
    L27:
        if ((r214 & 64) == 0) goto L29;
        ECUrlModel r106 = r110.icon;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.url;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.showEventName;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.clickEventName;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Map r108 = r110.eventParams;
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
        return this.itemType;
    }

    public final String component10() {
        return this.clickEventName;
    }

    public final Map<String, String> component11() {
        return this.eventParams;
    }

    public final String component2() {
        return this.valueText;
    }

    public final String component3() {
        return this.valueTextColor;
    }

    public final String component4() {
        return this.desc;
    }

    public final String component5() {
        return this.descTextColor;
    }

    public final ECUrlModel component6() {
        return this.descRightIcon;
    }

    public final ECUrlModel component7() {
        return this.icon;
    }

    public final String component8() {
        return this.url;
    }

    public final String component9() {
        return this.showEventName;
    }

    public final ShopValueInfoItemWhite copy(Integer r110, String r111, String r112, String r113, String r114, ECUrlModel r115, ECUrlModel r210, String r211, String r212, String r213, Map<String, String> r214) {
        return new ShopValueInfoItemWhite(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShopValueInfoItemWhite) == false) goto L28;
        ShopValueInfoItemWhite r101 = (ShopValueInfoItemWhite) r100;
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.valueText, r101.valueText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.valueTextColor, r101.valueTextColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.descTextColor, r101.descTextColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.descRightIcon, r101.descRightIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.showEventName, r101.showEventName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clickEventName, r101.clickEventName) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.itemType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.valueText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.valueTextColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.desc;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.descTextColor;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECUrlModel r116 = this.descRightIcon;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        ECUrlModel r119 = this.icon;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.url;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.showEventName;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.clickEventName;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Map<String, String> r131 = this.eventParams;
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
        return "ShopValueInfoItemWhite(itemType=" + this.itemType + ", valueText=" + this.valueText + ", valueTextColor=" + this.valueTextColor + ", desc=" + this.desc + ", descTextColor=" + this.descTextColor + ", descRightIcon=" + this.descRightIcon + ", icon=" + this.icon + ", url=" + this.url + ", showEventName=" + this.showEventName + ", clickEventName=" + this.clickEventName + ", eventParams=" + this.eventParams + ")";
    }

    public final String getClickEventName() {
        return this.clickEventName;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final ECUrlModel getDescRightIcon() {
        return this.descRightIcon;
    }

    public final String getDescTextColor() {
        return this.descTextColor;
    }

    public final Map<String, String> getEventParams() {
        return this.eventParams;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final String getShowEventName() {
        return this.showEventName;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getValueText() {
        return this.valueText;
    }

    public final String getValueTextColor() {
        return this.valueTextColor;
    }

    public final void setClickEventName(String r100) {
        this.clickEventName = r100;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setDescRightIcon(ECUrlModel r100) {
        this.descRightIcon = r100;
    }

    public final void setDescTextColor(String r100) {
        this.descTextColor = r100;
    }

    public final void setEventParams(Map<String, String> r100) {
        this.eventParams = r100;
    }

    public final void setIcon(ECUrlModel r100) {
        this.icon = r100;
    }

    public final void setItemType(Integer r100) {
        this.itemType = r100;
    }

    public final void setShowEventName(String r100) {
        this.showEventName = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setValueText(String r100) {
        this.valueText = r100;
    }

    public final void setValueTextColor(String r100) {
        this.valueTextColor = r100;
    }

    public ShopValueInfoItemWhite(Integer r100, String r101, String r102, String r103, String r104, ECUrlModel r105, ECUrlModel r106, String r107, String r108, String r110, Map<String, String> r111) {
        this.itemType = r100;
        this.valueText = r101;
        this.valueTextColor = r102;
        this.desc = r103;
        this.descTextColor = r104;
        this.descRightIcon = r105;
        this.icon = r106;
        this.url = r107;
        this.showEventName = r108;
        this.clickEventName = r110;
        this.eventParams = r111;
    }

    public /* synthetic */ ShopValueInfoItemWhite(Integer r110, String r111, String r112, String r113, String r114, ECUrlModel r115, ECUrlModel r116, String r210, String r211, String r212, Map r213, int r214, DefaultConstructorMarker r215) {
        Map r100 = null;
        if ((r214 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        ECUrlModel r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        ECUrlModel r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = null;
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
