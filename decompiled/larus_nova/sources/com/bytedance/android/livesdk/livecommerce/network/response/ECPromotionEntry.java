package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi2.y;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bE\u0010FJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÒ\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b%\u0010&J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\t\u0010(\u001a\u00020\u0002HÖ\u0001J\u0013\u0010+\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b2\u00101R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b3\u0010.R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b4\u00101R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u00107R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010:R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b;\u00101R(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010<\u001a\u0004\b=\u0010>R(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b?\u0010>R\u001c\u0010!\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010@\u001a\u0004\bA\u0010\u0013R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010@\u001a\u0004\bB\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010/\u001a\u0004\bC\u00101R\u001c\u0010$\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010/\u001a\u0004\bD\u00101¨\u0006G"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionEntry;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "component5", "Lxi2/y;", "component6", "", "component7", "component8", "", "component9", "component10", "", "component11", "()Ljava/lang/Boolean;", "component12", "component13", "component14", "type", "title", "icon", "iconRadius", "url", "iconSize", "subEntries", "trackName", "trackParams", "businessParams", "showSmallWindow", "showDisclaimer", "color", "schemaParamsType", "copy", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lxi2/y;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionEntry;", "toString", "hashCode", "", "other", "equals", "I", "getType", "()I", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "getIcon", "getIconRadius", "getUrl", "Lxi2/y;", "getIconSize", "()Lxi2/y;", "Ljava/util/List;", "getSubEntries", "()Ljava/util/List;", "getTrackName", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "getBusinessParams", "Ljava/lang/Boolean;", "getShowSmallWindow", "getShowDisclaimer", "getColor", "getSchemaParamsType", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lxi2/y;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionEntry implements Serializable {

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_BUSINESS_PARAMS)
    private final Map<String, String> businessParams;

    @SerializedName("color")
    private final String color;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("icon_radius")
    private final int iconRadius;

    @SerializedName("icon_size")
    private final y iconSize;

    @SerializedName("schema_params_type")
    private final String schemaParamsType;

    @SerializedName("show_disclaimer")
    private final Boolean showDisclaimer;

    @SerializedName("show_small_window")
    private final Boolean showSmallWindow;

    @SerializedName("sub_entries")
    private final List<ECPromotionEntry> subEntries;

    @SerializedName("title")
    private final String title;

    @SerializedName("track_name")
    private final String trackName;

    @SerializedName("track_params")
    private final Map<String, String> trackParams;

    @SerializedName("type")
    private final int type;

    @SerializedName("url")
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECPromotionEntry copy$default(ECPromotionEntry r110, int r111, String r112, String r113, int r114, String r210, y r211, List r212, String r213, Map r214, Map r215, Boolean r216, Boolean r217, String r218, String r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        int r100 = r110.type;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.icon;
    L15:
        if ((r310 & 8) == 0) goto L17;
        int r103 = r110.iconRadius;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.url;
    L23:
        if ((r310 & 32) == 0) goto L25;
        y r105 = r110.iconSize;
    L27:
        if ((r310 & 64) == 0) goto L29;
        List r106 = r110.subEntries;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r107 = r110.trackName;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Map r115 = r110.trackParams;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Map r116 = r110.businessParams;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Boolean r117 = r110.showSmallWindow;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Boolean r118 = r110.showDisclaimer;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r119 = r110.color;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        String r108 = r110.schemaParamsType;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
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
    L33:
        r107 = r213;
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

    public final int component1() {
        return this.type;
    }

    public final Map<String, String> component10() {
        return this.businessParams;
    }

    public final Boolean component11() {
        return this.showSmallWindow;
    }

    public final Boolean component12() {
        return this.showDisclaimer;
    }

    public final String component13() {
        return this.color;
    }

    public final String component14() {
        return this.schemaParamsType;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.icon;
    }

    public final int component4() {
        return this.iconRadius;
    }

    public final String component5() {
        return this.url;
    }

    public final y component6() {
        return this.iconSize;
    }

    public final List<ECPromotionEntry> component7() {
        return this.subEntries;
    }

    public final String component8() {
        return this.trackName;
    }

    public final Map<String, String> component9() {
        return this.trackParams;
    }

    public final ECPromotionEntry copy(int r110, String r111, String r112, int r210, String r211, y r212, List<ECPromotionEntry> r213, String r214, Map<String, String> r215, Map<String, String> r216, Boolean r217, Boolean r218, String r219, String r310) {
        return new ECPromotionEntry(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPromotionEntry) == false) goto L34;
        ECPromotionEntry r101 = (ECPromotionEntry) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (this.iconRadius == r101.iconRadius) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.iconSize, r101.iconSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subEntries, r101.subEntries) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.trackName, r101.trackName) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.businessParams, r101.businessParams) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.showSmallWindow, r101.showSmallWindow) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.showDisclaimer, r101.showDisclaimer) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.schemaParamsType, r101.schemaParamsType) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        String r101 = this.title;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.icon;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + this.iconRadius) * 31;
        String r108 = this.url;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        y r111 = this.iconSize;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        List<ECPromotionEntry> r114 = this.subEntries;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.trackName;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        Map<String, String> r120 = this.trackParams;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        Map<String, String> r123 = this.businessParams;
        if (r123 == null) goto L33;
        int r124 = r123.hashCode();
    L34:
        int r125 = (r122 + r124) * 31;
        Boolean r126 = this.showSmallWindow;
        if (r126 == null) goto L37;
        int r127 = r126.hashCode();
    L38:
        int r128 = (r125 + r127) * 31;
        Boolean r129 = this.showDisclaimer;
        if (r129 == null) goto L41;
        int r130 = r129.hashCode();
    L42:
        int r131 = (r128 + r130) * 31;
        String r132 = this.color;
        if (r132 == null) goto L45;
        int r133 = r132.hashCode();
    L46:
        int r134 = (r131 + r133) * 31;
        String r135 = this.schemaParamsType;
        if (r135 == null) goto L50;
        r102 = r135.hashCode();
    L50:
        return r134 + r102;
    L45:
        r133 = 0;
        goto L46
    L41:
        r130 = 0;
        goto L42
    L37:
        r127 = 0;
        goto L38
    L33:
        r124 = 0;
        goto L34
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "ECPromotionEntry(type=" + this.type + ", title=" + this.title + ", icon=" + this.icon + ", iconRadius=" + this.iconRadius + ", url=" + this.url + ", iconSize=" + this.iconSize + ", subEntries=" + this.subEntries + ", trackName=" + this.trackName + ", trackParams=" + this.trackParams + ", businessParams=" + this.businessParams + ", showSmallWindow=" + this.showSmallWindow + ", showDisclaimer=" + this.showDisclaimer + ", color=" + this.color + ", schemaParamsType=" + this.schemaParamsType + ")";
    }

    public final Map<String, String> getBusinessParams() {
        return this.businessParams;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getIconRadius() {
        return this.iconRadius;
    }

    public final y getIconSize() {
        return this.iconSize;
    }

    public final String getSchemaParamsType() {
        return this.schemaParamsType;
    }

    public final Boolean getShowDisclaimer() {
        return this.showDisclaimer;
    }

    public final Boolean getShowSmallWindow() {
        return this.showSmallWindow;
    }

    public final List<ECPromotionEntry> getSubEntries() {
        return this.subEntries;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTrackName() {
        return this.trackName;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public ECPromotionEntry(int r100, String r101, String r102, int r103, String r104, y r105, List<ECPromotionEntry> r106, String r107, Map<String, String> r108, Map<String, String> r110, Boolean r111, Boolean r112, String r113, String r114) {
        this.type = r100;
        this.title = r101;
        this.icon = r102;
        this.iconRadius = r103;
        this.url = r104;
        this.iconSize = r105;
        this.subEntries = r106;
        this.trackName = r107;
        this.trackParams = r108;
        this.businessParams = r110;
        this.showSmallWindow = r111;
        this.showDisclaimer = r112;
        this.color = r113;
        this.schemaParamsType = r114;
    }

    public /* synthetic */ ECPromotionEntry(int r110, String r111, String r112, int r113, String r114, y r210, List r211, String r212, Map r213, Map r214, Boolean r215, Boolean r216, String r217, String r218, int r219, DefaultConstructorMarker r310) {
        String r100 = null;
        if ((r219 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r219 & 4) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r219 & 8) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r219 & 16) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r219 & 32) == 0) goto L21;
        y r105 = null;
    L23:
        if ((r219 & 64) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r219 & 128) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r219 & 256) == 0) goto L33;
        Map r108 = null;
    L35:
        if ((r219 & 512) == 0) goto L37;
        Map r115 = null;
    L39:
        if ((r219 & 1024) == 0) goto L41;
        Boolean r116 = null;
    L43:
        if ((r219 & 2048) == 0) goto L45;
        Boolean r117 = null;
    L47:
        if ((r219 & 4096) == 0) goto L49;
        String r118 = null;
    L51:
        if ((r219 & 8192) != 0) goto L54;
        r100 = r218;
    L54:
        this(r110, r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r118, r100);
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
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
