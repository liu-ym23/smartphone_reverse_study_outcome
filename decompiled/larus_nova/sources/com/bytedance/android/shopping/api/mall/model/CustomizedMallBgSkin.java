package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\r\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0002\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;", "", "isCustomized", "", "bgSkinStyle", "", "pageBackgroundImage", "", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getBgSkinStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPageBackgroundImage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;", "equals", "other", "hashCode", "isDarkTheme", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomizedMallBgSkin {

    @SerializedName("bg_skin_style")
    private final Integer bgSkinStyle;

    @SerializedName("is_customized")
    private final Boolean isCustomized;

    @SerializedName("page_background_image")
    private final String pageBackgroundImage;

    public CustomizedMallBgSkin() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CustomizedMallBgSkin copy$default(CustomizedMallBgSkin r100, Boolean r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isCustomized;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.bgSkinStyle;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.pageBackgroundImage;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Boolean component1() {
        return this.isCustomized;
    }

    public final Integer component2() {
        return this.bgSkinStyle;
    }

    public final String component3() {
        return this.pageBackgroundImage;
    }

    public final CustomizedMallBgSkin copy(Boolean r100, Integer r101, String r102) {
        return new CustomizedMallBgSkin(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CustomizedMallBgSkin) == false) goto L12;
        CustomizedMallBgSkin r101 = (CustomizedMallBgSkin) r100;
        if (Intrinsics.areEqual(this.isCustomized, r101.isCustomized) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bgSkinStyle, r101.bgSkinStyle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pageBackgroundImage, r101.pageBackgroundImage) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Boolean r100 = this.isCustomized;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.bgSkinStyle;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.pageBackgroundImage;
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
        return "CustomizedMallBgSkin(isCustomized=" + this.isCustomized + ", bgSkinStyle=" + this.bgSkinStyle + ", pageBackgroundImage=" + this.pageBackgroundImage + ")";
    }

    public final Boolean isDarkTheme() {
        Boolean r100 = this.isCustomized;
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == false) goto L16;
        Integer r102 = this.bgSkinStyle;
        if (r102 != null) goto L8;
    L10:
        if (r102 == null) goto L16;
        if (r102.intValue() != 1) goto L16;
        return Boolean.FALSE;
    L8:
        if (r102.intValue() != 2) goto L10;
        return r101;
    L16:
        return null;
    }

    public final Integer getBgSkinStyle() {
        return this.bgSkinStyle;
    }

    public final String getPageBackgroundImage() {
        return this.pageBackgroundImage;
    }

    public final Boolean isCustomized() {
        return this.isCustomized;
    }

    public CustomizedMallBgSkin(Boolean r100, Integer r101, String r102) {
        this.isCustomized = r100;
        this.bgSkinStyle = r101;
        this.pageBackgroundImage = r102;
    }

    public /* synthetic */ CustomizedMallBgSkin(Boolean r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
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
