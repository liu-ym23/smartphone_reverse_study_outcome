package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/m;", "", "", "textColor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTextColor", "(Ljava/lang/String;)V", "backgroundColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBackgroundColor", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("text_color")
    private String textColor;

    public m() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L10;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.textColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.backgroundColor;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameDetailWidgetCommonStyle(textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public final String a() {
        return this.backgroundColor;
    }

    public final String b() {
        return this.textColor;
    }

    public m(String r100, String r101) {
        this.textColor = r100;
        this.backgroundColor = r101;
    }
}
