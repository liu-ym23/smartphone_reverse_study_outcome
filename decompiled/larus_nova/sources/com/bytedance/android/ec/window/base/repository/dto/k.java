package com.bytedance.android.ec.window.base.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/k;", "", "", "height", "Ljava/lang/Long;", "getHeight", "()Ljava/lang/Long;", "", "isDefaultSelect", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "", "componentType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "componentID", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dataID", "c", "text", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("component_id")
    private final String componentID;

    @SerializedName("component_type")
    private final String componentType;

    @SerializedName("data_id")
    private final String dataID;

    @SerializedName("height")
    private final Long height;

    @SerializedName("is_default_select")
    private final Boolean isDefaultSelect;

    @SerializedName("text")
    private final String text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L18;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.isDefaultSelect, r101.isDefaultSelect) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.componentType, r101.componentType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.componentID, r101.componentID) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.dataID, r101.dataID) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.height;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isDefaultSelect;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.componentType;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.componentID;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.dataID;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.text;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "Render(height=" + this.height + ", isDefaultSelect=" + this.isDefaultSelect + ", componentType=" + this.componentType + ", componentID=" + this.componentID + ", dataID=" + this.dataID + ", text=" + this.text + ")";
    }

    public final String a() {
        return this.componentID;
    }

    public final String b() {
        return this.componentType;
    }

    public final String c() {
        return this.dataID;
    }

    public final String d() {
        return this.text;
    }

    public final Boolean e() {
        return this.isDefaultSelect;
    }
}
