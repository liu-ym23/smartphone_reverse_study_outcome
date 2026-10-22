package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001:\u0006,-./01Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jk\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle;", "", "pageStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigPage;", "subTabStyle", "", "", "searchStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SearchStyle;", "toolListStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$ToolListStyle;", "secKillChannelStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SecKillChannelStyle;", "dailyFloorChannelStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$DailyFloorChannelStyle;", "cycleActivityStyle", "(Lcom/bytedance/android/shopping/api/mall/model/SkinConfigPage;Ljava/util/Map;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SearchStyle;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$ToolListStyle;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SecKillChannelStyle;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$DailyFloorChannelStyle;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$DailyFloorChannelStyle;)V", "getCycleActivityStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$DailyFloorChannelStyle;", "getDailyFloorChannelStyle", "getPageStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigPage;", "getSearchStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SearchStyle;", "getSecKillChannelStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SecKillChannelStyle;", "getSubTabStyle", "()Ljava/util/Map;", "getToolListStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$ToolListStyle;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "BadgeStyle", "CycleActivityStyle", "DailyFloorChannelStyle", "SearchStyle", "SecKillChannelStyle", "ToolListStyle", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkinConfigStyle {

    @SerializedName("cycle_activity_style")
    private final DailyFloorChannelStyle cycleActivityStyle;

    @SerializedName("daily_floor_channel_style")
    private final DailyFloorChannelStyle dailyFloorChannelStyle;

    @SerializedName("page_style")
    private final SkinConfigPage pageStyle;

    @SerializedName("search_style")
    private final SearchStyle searchStyle;

    @SerializedName("sec_kill_channel_style")
    private final SecKillChannelStyle secKillChannelStyle;

    @SerializedName("sub_tab_style")
    private final Map<String, Object> subTabStyle;

    @SerializedName("tool_list_style")
    private final ToolListStyle toolListStyle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$BadgeStyle;", "", "borderColor", "", "textColor", "bgColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "getBorderColor", "getTextColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BadgeStyle {

        @SerializedName("bg_color")
        private final String bgColor;

        @SerializedName("border_color")
        private final String borderColor;

        @SerializedName("text_color")
        private final String textColor;

        public BadgeStyle() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ BadgeStyle copy$default(BadgeStyle r100, String r101, String r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.borderColor;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.textColor;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.bgColor;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.borderColor;
        }

        public final String component2() {
            return this.textColor;
        }

        public final String component3() {
            return this.bgColor;
        }

        public final BadgeStyle copy(String r100, String r101, String r102) {
            return new BadgeStyle(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof BadgeStyle) == false) goto L12;
            BadgeStyle r101 = (BadgeStyle) r100;
            if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.borderColor;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.textColor;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.bgColor;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "BadgeStyle(borderColor=" + this.borderColor + ", textColor=" + this.textColor + ", bgColor=" + this.bgColor + ")";
        }

        public final String getBgColor() {
            return this.bgColor;
        }

        public final String getBorderColor() {
            return this.borderColor;
        }

        public final String getTextColor() {
            return this.textColor;
        }

        public BadgeStyle(String r100, String r101, String r102) {
            this.borderColor = r100;
            this.textColor = r101;
            this.bgColor = r102;
        }

        public /* synthetic */ BadgeStyle(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$CycleActivityStyle;", "", "bgUrl", "", "(Ljava/lang/String;)V", "getBgUrl", "()Ljava/lang/String;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CycleActivityStyle {

        @SerializedName("bg_url")
        private final String bgUrl;

        /* JADX WARN: Multi-variable type inference failed */
        public CycleActivityStyle() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final String getBgUrl() {
            return this.bgUrl;
        }

        public CycleActivityStyle(String r100) {
            this.bgUrl = r100;
        }

        public /* synthetic */ CycleActivityStyle(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$DailyFloorChannelStyle;", "", "bgUrl", "", "(Ljava/lang/String;)V", "getBgUrl", "()Ljava/lang/String;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DailyFloorChannelStyle {

        @SerializedName("bg_url")
        private final String bgUrl;

        /* JADX WARN: Multi-variable type inference failed */
        public DailyFloorChannelStyle() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final String getBgUrl() {
            return this.bgUrl;
        }

        public DailyFloorChannelStyle(String r100) {
            this.bgUrl = r100;
        }

        public /* synthetic */ DailyFloorChannelStyle(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SearchStyle;", "", "badgeStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$BadgeStyle;", "(Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$BadgeStyle;)V", "getBadgeStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$BadgeStyle;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SearchStyle {

        @SerializedName("badge_style")
        private final BadgeStyle badgeStyle;

        /* JADX WARN: Multi-variable type inference failed */
        public SearchStyle() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SearchStyle copy$default(SearchStyle r100, BadgeStyle r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.badgeStyle;
        L6:
            return r100.copy(r101);
        }

        public final BadgeStyle component1() {
            return this.badgeStyle;
        }

        public final SearchStyle copy(BadgeStyle r100) {
            return new SearchStyle(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof SearchStyle) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.badgeStyle, ((SearchStyle) r100).badgeStyle) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            BadgeStyle r100 = this.badgeStyle;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "SearchStyle(badgeStyle=" + this.badgeStyle + ")";
        }

        public final BadgeStyle getBadgeStyle() {
            return this.badgeStyle;
        }

        public SearchStyle(BadgeStyle r100) {
            this.badgeStyle = r100;
        }

        public /* synthetic */ SearchStyle(BadgeStyle r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SecKillChannelStyle;", "", "bgUrl", "", "(Ljava/lang/String;)V", "getBgUrl", "()Ljava/lang/String;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SecKillChannelStyle {

        @SerializedName("bg_url")
        private final String bgUrl;

        /* JADX WARN: Multi-variable type inference failed */
        public SecKillChannelStyle() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final String getBgUrl() {
            return this.bgUrl;
        }

        public SecKillChannelStyle(String r100) {
            this.bgUrl = r100;
        }

        public /* synthetic */ SecKillChannelStyle(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$ToolListStyle;", "", "bg_color", "", "(Ljava/lang/String;)V", "getBg_color", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolListStyle {

        @SerializedName("bg_color")
        private final String bg_color;

        /* JADX WARN: Multi-variable type inference failed */
        public ToolListStyle() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ToolListStyle copy$default(ToolListStyle r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.bg_color;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.bg_color;
        }

        public final ToolListStyle copy(String r100) {
            return new ToolListStyle(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ToolListStyle) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.bg_color, ((ToolListStyle) r100).bg_color) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.bg_color;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "ToolListStyle(bg_color=" + this.bg_color + ")";
        }

        public final String getBg_color() {
            return this.bg_color;
        }

        public ToolListStyle(String r100) {
            this.bg_color = r100;
        }

        public /* synthetic */ ToolListStyle(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    public SkinConfigStyle() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkinConfigStyle copy$default(SkinConfigStyle r100, SkinConfigPage r101, Map r102, SearchStyle r103, ToolListStyle r104, SecKillChannelStyle r110, DailyFloorChannelStyle r111, DailyFloorChannelStyle r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.pageStyle;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.subTabStyle;
    L8:
        Map r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.searchStyle;
    L11:
        SearchStyle r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.toolListStyle;
    L14:
        ToolListStyle r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.secKillChannelStyle;
    L17:
        SecKillChannelStyle r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.dailyFloorChannelStyle;
    L20:
        DailyFloorChannelStyle r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.cycleActivityStyle;
    L23:
        SkinConfigPage r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final SkinConfigPage component1() {
        return this.pageStyle;
    }

    public final Map<String, Object> component2() {
        return this.subTabStyle;
    }

    public final SearchStyle component3() {
        return this.searchStyle;
    }

    public final ToolListStyle component4() {
        return this.toolListStyle;
    }

    public final SecKillChannelStyle component5() {
        return this.secKillChannelStyle;
    }

    public final DailyFloorChannelStyle component6() {
        return this.dailyFloorChannelStyle;
    }

    public final DailyFloorChannelStyle component7() {
        return this.cycleActivityStyle;
    }

    public final SkinConfigStyle copy(SkinConfigPage r110, Map<String, ? extends Object> r111, SearchStyle r112, ToolListStyle r113, SecKillChannelStyle r114, DailyFloorChannelStyle r115, DailyFloorChannelStyle r116) {
        return new SkinConfigStyle(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkinConfigStyle) == false) goto L20;
        SkinConfigStyle r101 = (SkinConfigStyle) r100;
        if (Intrinsics.areEqual(this.pageStyle, r101.pageStyle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subTabStyle, r101.subTabStyle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.searchStyle, r101.searchStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toolListStyle, r101.toolListStyle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.secKillChannelStyle, r101.secKillChannelStyle) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.dailyFloorChannelStyle, r101.dailyFloorChannelStyle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cycleActivityStyle, r101.cycleActivityStyle) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        SkinConfigPage r100 = this.pageStyle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.subTabStyle;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        SearchStyle r107 = this.searchStyle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ToolListStyle r110 = this.toolListStyle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        SecKillChannelStyle r113 = this.secKillChannelStyle;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        DailyFloorChannelStyle r116 = this.dailyFloorChannelStyle;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        DailyFloorChannelStyle r119 = this.cycleActivityStyle;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "SkinConfigStyle(pageStyle=" + this.pageStyle + ", subTabStyle=" + this.subTabStyle + ", searchStyle=" + this.searchStyle + ", toolListStyle=" + this.toolListStyle + ", secKillChannelStyle=" + this.secKillChannelStyle + ", dailyFloorChannelStyle=" + this.dailyFloorChannelStyle + ", cycleActivityStyle=" + this.cycleActivityStyle + ")";
    }

    public final DailyFloorChannelStyle getCycleActivityStyle() {
        return this.cycleActivityStyle;
    }

    public final DailyFloorChannelStyle getDailyFloorChannelStyle() {
        return this.dailyFloorChannelStyle;
    }

    public final SkinConfigPage getPageStyle() {
        return this.pageStyle;
    }

    public final SearchStyle getSearchStyle() {
        return this.searchStyle;
    }

    public final SecKillChannelStyle getSecKillChannelStyle() {
        return this.secKillChannelStyle;
    }

    public final Map<String, Object> getSubTabStyle() {
        return this.subTabStyle;
    }

    public final ToolListStyle getToolListStyle() {
        return this.toolListStyle;
    }

    public SkinConfigStyle(SkinConfigPage r100, Map<String, ? extends Object> r101, SearchStyle r102, ToolListStyle r103, SecKillChannelStyle r104, DailyFloorChannelStyle r105, DailyFloorChannelStyle r106) {
        this.pageStyle = r100;
        this.subTabStyle = r101;
        this.searchStyle = r102;
        this.toolListStyle = r103;
        this.secKillChannelStyle = r104;
        this.dailyFloorChannelStyle = r105;
        this.cycleActivityStyle = r106;
    }

    public /* synthetic */ SkinConfigStyle(SkinConfigPage r100, Map r101, SearchStyle r102, ToolListStyle r110, SecKillChannelStyle r111, DailyFloorChannelStyle r112, DailyFloorChannelStyle r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        SkinConfigPage r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Map r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        SearchStyle r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        ToolListStyle r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        SecKillChannelStyle r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        DailyFloorChannelStyle r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        DailyFloorChannelStyle r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
