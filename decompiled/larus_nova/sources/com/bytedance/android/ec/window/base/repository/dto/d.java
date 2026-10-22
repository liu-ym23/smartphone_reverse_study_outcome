package com.bytedance.android.ec.window.base.repository.dto;

import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagListDTO;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/d;", "", "", "selectParams", "Ljava/lang/String;", "getSelectParams", "()Ljava/lang/String;", "", "isSelect", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setSelect", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/ec/window/base/repository/vo/ECWindowTagListDTO;", "selectButton", "Lcom/bytedance/android/ec/window/base/repository/vo/ECWindowTagListDTO;", "getSelectButton", "()Lcom/bytedance/android/ec/window/base/repository/vo/ECWindowTagListDTO;", "unSelectButton", "getUnSelectButton", "", "generalData", "Ljava/util/Map;", "getGeneralData", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("general_data")
    private final Map<String, Object> generalData;

    @SerializedName("is_select")
    private Boolean isSelect;

    @SerializedName("selected_button")
    private final ECWindowTagListDTO selectButton;

    @SerializedName("select_params")
    private final String selectParams;

    @SerializedName("normal_button")
    private final ECWindowTagListDTO unSelectButton;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.selectParams, r101.selectParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.isSelect, r101.isSelect) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.selectButton, r101.selectButton) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.unSelectButton, r101.unSelectButton) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.generalData, r101.generalData) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.selectParams;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isSelect;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECWindowTagListDTO r107 = this.selectButton;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECWindowTagListDTO r110 = this.unSelectButton;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.generalData;
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
        return "ECSelectButton(selectParams=" + this.selectParams + ", isSelect=" + this.isSelect + ", selectButton=" + this.selectButton + ", unSelectButton=" + this.unSelectButton + ", generalData=" + this.generalData + ")";
    }

    public d() {
        this.selectParams = null;
        this.isSelect = null;
        this.selectButton = null;
        this.unSelectButton = null;
        this.generalData = null;
    }
}
