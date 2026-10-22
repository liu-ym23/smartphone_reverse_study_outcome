package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/model/response/y;", "", "", "textSplitterStyle", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "textSplitterColor", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("text_splitter_color")
    private final String textSplitterColor;

    @SerializedName("text_splitter_style")
    private final Long textSplitterStyle;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L10;
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.textSplitterStyle, r101.textSplitterStyle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textSplitterColor, r101.textSplitterColor) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.textSplitterStyle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.textSplitterColor;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECSalePointUIConfig(textSplitterStyle=" + this.textSplitterStyle + ", textSplitterColor=" + this.textSplitterColor + ")";
    }

    public y() {
        this.textSplitterStyle = null;
        this.textSplitterColor = null;
    }

    public final String a() {
        return this.textSplitterColor;
    }

    public final Long b() {
        return this.textSplitterStyle;
    }
}
