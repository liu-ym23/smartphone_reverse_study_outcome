package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/model/response/r1;", "", "", "optionCode", "Ljava/lang/String;", "getOptionCode", "()Ljava/lang/String;", "optionDesc", "getOptionDesc", "Lcom/bytedance/android/ec/model/response/j;", "subOptionConfig", "Lcom/bytedance/android/ec/model/response/j;", "getSubOptionConfig", "()Lcom/bytedance/android/ec/model/response/j;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class r1 {

    @SerializedName("option_code")
    private final String optionCode;

    @SerializedName("option_desc")
    private final String optionDesc;

    @SerializedName("sub_option_config")
    private final j subOptionConfig;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r1) == false) goto L12;
        r1 r101 = (r1) r100;
        if (Intrinsics.areEqual(this.optionCode, r101.optionCode) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.optionDesc, r101.optionDesc) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.subOptionConfig, r101.subOptionConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.optionCode;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.optionDesc;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        j r107 = this.subOptionConfig;
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
        return "SurveyV2Option(optionCode=" + this.optionCode + ", optionDesc=" + this.optionDesc + ", subOptionConfig=" + this.subOptionConfig + ")";
    }

    public r1() {
        this.optionCode = null;
        this.optionDesc = null;
        this.subOptionConfig = null;
    }
}
