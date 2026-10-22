package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/r;", "", "", "text", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "backgroundColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "textColor", "c", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    public r() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L12;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.backgroundColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.textColor;
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

    public final String toString() {
        return "TextAdditionalModel(text=" + this.text + ", backgroundColor=" + this.backgroundColor + ", textColor=" + this.textColor + ")";
    }

    public final String a() {
        return this.backgroundColor;
    }

    public final String b() {
        return this.text;
    }

    public final String c() {
        return this.textColor;
    }

    public r(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.text = r100;
        this.backgroundColor = null;
        this.textColor = null;
    }
}
