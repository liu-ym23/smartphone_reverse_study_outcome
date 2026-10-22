package com.bytedance.android.gamecp.business.gamedetail.component.minigamebar;

import com.bytedance.android.gamecp.business.gamedetail.base.model.m;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/minigamebar/b;", "", "", "textColor", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "backGroundColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "iconUrl", "c", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/m;", "halfStyle", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/m;", "b", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/m;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("background_color")
    private final String backGroundColor;

    @SerializedName("half_style")
    private final m halfStyle;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("text_color")
    private final String textColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.backGroundColor, r101.backGroundColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.halfStyle, r101.halfStyle) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.textColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.backGroundColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.iconUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        m r110 = this.halfStyle;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "LaunchBtnStyle(textColor=" + this.textColor + ", backGroundColor=" + this.backGroundColor + ", iconUrl=" + this.iconUrl + ", halfStyle=" + this.halfStyle + ")";
    }

    public b() {
        this.textColor = null;
        this.backGroundColor = null;
        this.iconUrl = null;
        this.halfStyle = null;
    }

    public final String a() {
        return this.backGroundColor;
    }

    public final m b() {
        return this.halfStyle;
    }

    public final String c() {
        return this.iconUrl;
    }

    public final String d() {
        return this.textColor;
    }
}
