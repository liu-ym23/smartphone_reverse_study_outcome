package com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/downloadbutton/i;", "", "", "floatType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "progressTextColor", "f", "progressColor", "e", "immediatelyPlayText", "d", "downloadWhilePlayText", "b", "smallButtonText", ce.f26391f, "bigButtonText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("map_play_big_button_text")
    private final String bigButtonText;

    @SerializedName("download_while_play_title")
    private final String downloadWhilePlayText;

    @SerializedName("float_type")
    private final String floatType;

    @SerializedName("immediately_play_title")
    private final String immediatelyPlayText;

    @SerializedName("progress_color")
    private final String progressColor;

    @SerializedName("progress_text_color")
    private final String progressTextColor;

    @SerializedName("map_play_small_button_text")
    private final String smallButtonText;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L20;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.floatType, r101.floatType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.progressTextColor, r101.progressTextColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.progressColor, r101.progressColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.immediatelyPlayText, r101.immediatelyPlayText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.downloadWhilePlayText, r101.downloadWhilePlayText) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.smallButtonText, r101.smallButtonText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bigButtonText, r101.bigButtonText) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.floatType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.progressTextColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.progressColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.immediatelyPlayText;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.downloadWhilePlayText;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.smallButtonText;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.bigButtonText;
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

    public final String toString() {
        return "GameDownloadUIStyle(floatType=" + this.floatType + ", progressTextColor=" + this.progressTextColor + ", progressColor=" + this.progressColor + ", immediatelyPlayText=" + this.immediatelyPlayText + ", downloadWhilePlayText=" + this.downloadWhilePlayText + ", smallButtonText=" + this.smallButtonText + ", bigButtonText=" + this.bigButtonText + ")";
    }

    public i() {
        this.floatType = null;
        this.progressTextColor = null;
        this.progressColor = null;
        this.immediatelyPlayText = null;
        this.downloadWhilePlayText = null;
        this.smallButtonText = null;
        this.bigButtonText = null;
    }

    public final String a() {
        return this.bigButtonText;
    }

    public final String b() {
        return this.downloadWhilePlayText;
    }

    public final String c() {
        return this.floatType;
    }

    public final String d() {
        return this.immediatelyPlayText;
    }

    public final String e() {
        return this.progressColor;
    }

    public final String f() {
        return this.progressTextColor;
    }

    public final String g() {
        return this.smallButtonText;
    }
}
