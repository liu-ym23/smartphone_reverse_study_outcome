package com.bytedance.android.gamecp.business.gamedetail.component.cloudplaybutton;

import com.amap.api.col.s.ce;
import com.bytedance.android.gamecp.business.gamedetail.base.model.m;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/cloudplaybutton/e;", "", "", "textColor", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "backGroundColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "iconUrl", "d", "immediatelyPlaySubTextColor", "e", "immediatelyPlaySubWbp", "f", "downloadWhilePlayText", "b", "smallButtonText", "getSmallButtonText", "bigButtonText", "getBigButtonText", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/m;", "halfStyle", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/m;", "c", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/m;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("background_color")
    private final String backGroundColor;

    @SerializedName("map_play_big_button_text")
    private final String bigButtonText;

    @SerializedName("download_while_play_title")
    private final String downloadWhilePlayText;

    @SerializedName("half_style")
    private final m halfStyle;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("play_subtitle_text_color")
    private final String immediatelyPlaySubTextColor;

    @SerializedName("play_subtitle_webp")
    private final String immediatelyPlaySubWbp;

    @SerializedName("map_play_small_button_text")
    private final String smallButtonText;

    @SerializedName("text_color")
    private final String textColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L24;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.backGroundColor, r101.backGroundColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.immediatelyPlaySubTextColor, r101.immediatelyPlaySubTextColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.immediatelyPlaySubWbp, r101.immediatelyPlaySubWbp) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.downloadWhilePlayText, r101.downloadWhilePlayText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.smallButtonText, r101.smallButtonText) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bigButtonText, r101.bigButtonText) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.halfStyle, r101.halfStyle) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
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
        String r110 = this.immediatelyPlaySubTextColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.immediatelyPlaySubWbp;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.downloadWhilePlayText;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.smallButtonText;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.bigButtonText;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        m r125 = this.halfStyle;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
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

    public final String toString() {
        return "CloudPlayButtonUIStyle(textColor=" + this.textColor + ", backGroundColor=" + this.backGroundColor + ", iconUrl=" + this.iconUrl + ", immediatelyPlaySubTextColor=" + this.immediatelyPlaySubTextColor + ", immediatelyPlaySubWbp=" + this.immediatelyPlaySubWbp + ", downloadWhilePlayText=" + this.downloadWhilePlayText + ", smallButtonText=" + this.smallButtonText + ", bigButtonText=" + this.bigButtonText + ", halfStyle=" + this.halfStyle + ")";
    }

    public e() {
        m r100 = new m("#FE2C55FF", "#FFEEF1FF");
        this.textColor = null;
        this.backGroundColor = null;
        this.iconUrl = null;
        this.immediatelyPlaySubTextColor = null;
        this.immediatelyPlaySubWbp = null;
        this.downloadWhilePlayText = null;
        this.smallButtonText = null;
        this.bigButtonText = null;
        this.halfStyle = r100;
    }

    public final String a() {
        return this.backGroundColor;
    }

    public final String b() {
        return this.downloadWhilePlayText;
    }

    public final m c() {
        return this.halfStyle;
    }

    public final String d() {
        return this.iconUrl;
    }

    public final String e() {
        return this.immediatelyPlaySubTextColor;
    }

    public final String f() {
        return this.immediatelyPlaySubWbp;
    }

    public final String g() {
        return this.textColor;
    }
}
