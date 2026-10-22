package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jn\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\tHÖ\u0001J\t\u0010,\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;", "", "iconUrl", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTaIconUrl;", "hasForceInsert", "", "wysiwygItems", "", "wysiwygPosition", "", "wysiwygSceneId", "wysiwygBlockName", "feedType", "feedId", "(Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTaIconUrl;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getFeedId", "()Ljava/lang/String;", "getFeedType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasForceInsert", "()Ljava/lang/Boolean;", "setHasForceInsert", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getIconUrl", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTaIconUrl;", "getWysiwygBlockName", "getWysiwygItems", "getWysiwygPosition", "getWysiwygSceneId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTaIconUrl;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallCategoryTabGuideIcon {

    @SerializedName("feed_id")
    private final String feedId;

    @SerializedName("feed_type")
    private final Integer feedType;

    @SerializedName("has_force_insert")
    private Boolean hasForceInsert;

    @SerializedName("icon_url")
    private final MallCategoryTaIconUrl iconUrl;

    @SerializedName("wysiwyg_block_name")
    private final String wysiwygBlockName;

    @SerializedName("wysiwyg_items")
    private final String wysiwygItems;

    @SerializedName("wysiwyg_position")
    private final Integer wysiwygPosition;

    @SerializedName("wysiwyg_scene_id")
    private final String wysiwygSceneId;

    public MallCategoryTabGuideIcon() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ MallCategoryTabGuideIcon copy$default(MallCategoryTabGuideIcon r100, MallCategoryTaIconUrl r110, Boolean r111, String r112, Integer r113, String r114, String r115, Integer r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        MallCategoryTaIconUrl r101 = r100.iconUrl;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Boolean r102 = r100.hasForceInsert;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.wysiwygItems;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r104 = r100.wysiwygPosition;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.wysiwygSceneId;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.wysiwygBlockName;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Integer r107 = r100.feedType;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.feedId;
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

    public final MallCategoryTaIconUrl component1() {
        return this.iconUrl;
    }

    public final Boolean component2() {
        return this.hasForceInsert;
    }

    public final String component3() {
        return this.wysiwygItems;
    }

    public final Integer component4() {
        return this.wysiwygPosition;
    }

    public final String component5() {
        return this.wysiwygSceneId;
    }

    public final String component6() {
        return this.wysiwygBlockName;
    }

    public final Integer component7() {
        return this.feedType;
    }

    public final String component8() {
        return this.feedId;
    }

    public final MallCategoryTabGuideIcon copy(MallCategoryTaIconUrl r110, Boolean r111, String r112, Integer r113, String r114, String r115, Integer r116, String r117) {
        return new MallCategoryTabGuideIcon(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MallCategoryTabGuideIcon) == false) goto L22;
        MallCategoryTabGuideIcon r101 = (MallCategoryTabGuideIcon) r100;
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hasForceInsert, r101.hasForceInsert) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.wysiwygItems, r101.wysiwygItems) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.wysiwygPosition, r101.wysiwygPosition) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.wysiwygSceneId, r101.wysiwygSceneId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.wysiwygBlockName, r101.wysiwygBlockName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.feedType, r101.feedType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.feedId, r101.feedId) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        MallCategoryTaIconUrl r100 = this.iconUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.hasForceInsert;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.wysiwygItems;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.wysiwygPosition;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.wysiwygSceneId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.wysiwygBlockName;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.feedType;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.feedId;
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
        return "MallCategoryTabGuideIcon(iconUrl=" + this.iconUrl + ", hasForceInsert=" + this.hasForceInsert + ", wysiwygItems=" + this.wysiwygItems + ", wysiwygPosition=" + this.wysiwygPosition + ", wysiwygSceneId=" + this.wysiwygSceneId + ", wysiwygBlockName=" + this.wysiwygBlockName + ", feedType=" + this.feedType + ", feedId=" + this.feedId + ")";
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final Integer getFeedType() {
        return this.feedType;
    }

    public final Boolean getHasForceInsert() {
        return this.hasForceInsert;
    }

    public final MallCategoryTaIconUrl getIconUrl() {
        return this.iconUrl;
    }

    public final String getWysiwygBlockName() {
        return this.wysiwygBlockName;
    }

    public final String getWysiwygItems() {
        return this.wysiwygItems;
    }

    public final Integer getWysiwygPosition() {
        return this.wysiwygPosition;
    }

    public final String getWysiwygSceneId() {
        return this.wysiwygSceneId;
    }

    public final void setHasForceInsert(Boolean r100) {
        this.hasForceInsert = r100;
    }

    public MallCategoryTabGuideIcon(MallCategoryTaIconUrl r100, Boolean r101, String r102, Integer r103, String r104, String r105, Integer r106, String r107) {
        this.iconUrl = r100;
        this.hasForceInsert = r101;
        this.wysiwygItems = r102;
        this.wysiwygPosition = r103;
        this.wysiwygSceneId = r104;
        this.wysiwygBlockName = r105;
        this.feedType = r106;
        this.feedId = r107;
    }

    public /* synthetic */ MallCategoryTabGuideIcon(MallCategoryTaIconUrl r110, Boolean r111, String r112, Integer r113, String r114, String r115, Integer r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        MallCategoryTaIconUrl r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Boolean r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Integer r107 = null;
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
