package com.bytedance.android.ec.window.base.repository.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/o;", "", "", "logText", "Ljava/lang/String;", "getLogText", "()Ljava/lang/String;", "type", "getType", "conditionField", "getConditionField", "conditionValue", "getConditionValue", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("condition_field")
    private final String conditionField;

    @SerializedName("condition_value")
    private final String conditionValue;

    @SerializedName("log_text")
    private final String logText;

    @SerializedName("type")
    private final String type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L14;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.logText, r101.logText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.conditionField, r101.conditionField) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conditionValue, r101.conditionValue) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.logText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.type;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.conditionField;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.conditionValue;
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
        return "SortConfig(logText=" + this.logText + ", type=" + this.type + ", conditionField=" + this.conditionField + ", conditionValue=" + this.conditionValue + ")";
    }

    public final String getType() {
        return this.type;
    }
}
