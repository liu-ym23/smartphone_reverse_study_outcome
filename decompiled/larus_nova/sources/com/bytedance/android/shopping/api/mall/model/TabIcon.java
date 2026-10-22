package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/TabIcon;", "", "width", "", "height", "lightIcon", "", "darkIcon", "selectedLightIcon", "selectedDarkIcon", "selectedToolbarLightColor", "selectedToolbarDarkColor", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDarkIcon", "()Ljava/lang/String;", "getHeight", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLightIcon", "getSelectedDarkIcon", "getSelectedLightIcon", "getSelectedToolbarDarkColor", "getSelectedToolbarLightColor", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/model/TabIcon;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabIcon {

    @SerializedName("dark_icon")
    private final String darkIcon;

    @SerializedName("height")
    private final Long height;

    @SerializedName("light_icon")
    private final String lightIcon;

    @SerializedName("selected_dark_icon")
    private final String selectedDarkIcon;

    @SerializedName("selected_light_icon")
    private final String selectedLightIcon;

    @SerializedName("selected_toolbar_dark_color")
    private final String selectedToolbarDarkColor;

    @SerializedName("selected_toolbar_light_color")
    private final String selectedToolbarLightColor;

    @SerializedName("width")
    private final Long width;

    public TabIcon() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ TabIcon copy$default(TabIcon r100, Long r110, Long r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Long r101 = r100.width;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Long r102 = r100.height;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.lightIcon;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.darkIcon;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.selectedLightIcon;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.selectedDarkIcon;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.selectedToolbarLightColor;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.selectedToolbarDarkColor;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
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

    public final Long component1() {
        return this.width;
    }

    public final Long component2() {
        return this.height;
    }

    public final String component3() {
        return this.lightIcon;
    }

    public final String component4() {
        return this.darkIcon;
    }

    public final String component5() {
        return this.selectedLightIcon;
    }

    public final String component6() {
        return this.selectedDarkIcon;
    }

    public final String component7() {
        return this.selectedToolbarLightColor;
    }

    public final String component8() {
        return this.selectedToolbarDarkColor;
    }

    public final TabIcon copy(Long r110, Long r111, String r112, String r113, String r114, String r115, String r116, String r117) {
        return new TabIcon(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TabIcon) == false) goto L22;
        TabIcon r101 = (TabIcon) r100;
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lightIcon, r101.lightIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.darkIcon, r101.darkIcon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.selectedLightIcon, r101.selectedLightIcon) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.selectedDarkIcon, r101.selectedDarkIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedToolbarLightColor, r101.selectedToolbarLightColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.selectedToolbarDarkColor, r101.selectedToolbarDarkColor) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        Long r100 = this.width;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.height;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lightIcon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.darkIcon;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.selectedLightIcon;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.selectedDarkIcon;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.selectedToolbarLightColor;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.selectedToolbarDarkColor;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
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
        return "TabIcon(width=" + this.width + ", height=" + this.height + ", lightIcon=" + this.lightIcon + ", darkIcon=" + this.darkIcon + ", selectedLightIcon=" + this.selectedLightIcon + ", selectedDarkIcon=" + this.selectedDarkIcon + ", selectedToolbarLightColor=" + this.selectedToolbarLightColor + ", selectedToolbarDarkColor=" + this.selectedToolbarDarkColor + ")";
    }

    public final String getDarkIcon() {
        return this.darkIcon;
    }

    public final Long getHeight() {
        return this.height;
    }

    public final String getLightIcon() {
        return this.lightIcon;
    }

    public final String getSelectedDarkIcon() {
        return this.selectedDarkIcon;
    }

    public final String getSelectedLightIcon() {
        return this.selectedLightIcon;
    }

    public final String getSelectedToolbarDarkColor() {
        return this.selectedToolbarDarkColor;
    }

    public final String getSelectedToolbarLightColor() {
        return this.selectedToolbarLightColor;
    }

    public final Long getWidth() {
        return this.width;
    }

    public TabIcon(Long r100, Long r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        this.width = r100;
        this.height = r101;
        this.lightIcon = r102;
        this.darkIcon = r103;
        this.selectedLightIcon = r104;
        this.selectedDarkIcon = r105;
        this.selectedToolbarLightColor = r106;
        this.selectedToolbarDarkColor = r107;
    }

    public /* synthetic */ TabIcon(Long r110, Long r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Long r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Long r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
