package com.bytedance.android.gamecp.business.gamedetail.base.model;

import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/i;", "", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "headerImageInfo", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "b", "()Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "setHeaderImageInfo", "(Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;)V", "", "headerBgColor", "Ljava/lang/String;", "getHeaderBgColor", "()Ljava/lang/String;", "setHeaderBgColor", "(Ljava/lang/String;)V", "", "headerBgColorStyle", "Ljava/lang/Integer;", "getHeaderBgColorStyle", "()Ljava/lang/Integer;", "setHeaderBgColorStyle", "(Ljava/lang/Integer;)V", "placeholderImageStrategy", "getPlaceholderImageStrategy", "setPlaceholderImageStrategy", "", "isUseNewHeadImageSize", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "setUseNewHeadImageSize", "(Ljava/lang/Boolean;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f53488a = 0;

    @SerializedName("header_bg_color")
    private String headerBgColor;

    @SerializedName("header_bg_color_style")
    private Integer headerBgColorStyle;

    @SerializedName("header_bg_image")
    private GameImageBundler headerImageInfo;

    @SerializedName("is_new_head_image_size")
    private Boolean isUseNewHeadImageSize;

    @SerializedName("placeholder_image_strategy")
    private Integer placeholderImageStrategy;

    public static final class a {
    }

    static {
    }

    public i() {
        Boolean r100 = Boolean.FALSE;
        this.headerImageInfo = null;
        this.headerBgColor = null;
        this.headerBgColorStyle = 0;
        this.placeholderImageStrategy = 0;
        this.isUseNewHeadImageSize = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L16;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.headerImageInfo, r101.headerImageInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.headerBgColor, r101.headerBgColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.headerBgColorStyle, r101.headerBgColorStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.placeholderImageStrategy, r101.placeholderImageStrategy) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isUseNewHeadImageSize, r101.isUseNewHeadImageSize) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        GameImageBundler r100 = this.headerImageInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.headerBgColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.headerBgColorStyle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.placeholderImageStrategy;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isUseNewHeadImageSize;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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

    public final String toString() {
        return "GameDetailCommonStyleHeaderInfo(headerImageInfo=" + this.headerImageInfo + ", headerBgColor=" + this.headerBgColor + ", headerBgColorStyle=" + this.headerBgColorStyle + ", placeholderImageStrategy=" + this.placeholderImageStrategy + ", isUseNewHeadImageSize=" + this.isUseNewHeadImageSize + ")";
    }

    public final int c() {
        if (this.headerImageInfo == null) goto L6;
        return 4;
    L6:
        Integer r100 = this.headerBgColorStyle;
        if (r100 != null) goto L10;
    L17:
        Integer r101 = this.headerBgColorStyle;
        if (r101 != null) goto L21;
    L28:
        Integer r102 = this.headerBgColorStyle;
        if (r102 != null) goto L32;
    L39:
        return 0;
    L32:
        if (r102.intValue() != 1) goto L39;
        Integer r103 = this.placeholderImageStrategy;
        if (r103 == null) goto L39;
        if (r103.intValue() != 3) goto L39;
        return 3;
    L21:
        if (r101.intValue() != 1) goto L28;
        Integer r104 = this.placeholderImageStrategy;
        if (r104 == null) goto L28;
        if (r104.intValue() != 2) goto L28;
        return 2;
    L10:
        if (r100.intValue() != 0) goto L17;
        Integer r105 = this.placeholderImageStrategy;
        if (r105 == null) goto L17;
        if (r105.intValue() != 1) goto L17;
        return 1;
    }

    public final boolean d() {
        return !TextUtils.isEmpty(this.headerBgColor);
    }

    public final boolean e() {
        if (this.headerImageInfo == null) goto L5;
    L8:
        return true;
    L5:
        if (c() == 3) goto L8;
        return false;
    }

    public final GameImageBundler b() {
        return this.headerImageInfo;
    }

    public final Boolean f() {
        return this.isUseNewHeadImageSize;
    }

    public final int a(int r100) {
        String r101 = this.headerBgColor;
        if (r101 == null) goto L18;
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 != true) goto L18;
        String r103 = com.bytedance.android.gamecp.common.utils.f.b(r101);
        if (UtilsKt.c(r103) == true) goto L19;
        yr.c.b("GameDetailCommonStyleHeaderInfo", "rgbAToArgb error, localHeaderBgColor: ".concat(r101));
        return y0.c(r100);
    L19:
        return Color.parseColor(r103);
    L13:
        yr.c.b("GameDetailCommonStyleHeaderInfo", "rgbAToArgb error, localHeaderBgColor: ".concat(r101));
        return y0.c(r100);
    L7:
        r102 = false;
    L18:
        return y0.c(r100);
    }
}
