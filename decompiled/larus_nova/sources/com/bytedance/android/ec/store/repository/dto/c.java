package com.bytedance.android.ec.store.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/c;", "", "", "selectParams", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "buttonName", "getButtonName", "selectButtonName", "getSelectButtonName", "", "isSelect", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "f", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "selectButton", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "b", "()Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "unSelectButton", "d", "", "selectType", "Ljava/lang/Integer;", "getSelectType", "()Ljava/lang/Integer;", "", "generalData", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "buttonIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getButtonIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("button_icon")
    private final ECUrlModel buttonIcon;

    @SerializedName("button_name")
    private final String buttonName;

    @SerializedName("general_data")
    private final Map<String, Object> generalData;

    @SerializedName("is_select")
    private Boolean isSelect;

    @SerializedName("selected_button")
    private final ECTagListDTO selectButton;

    @SerializedName("select_button_name")
    private final String selectButtonName;

    @SerializedName("select_params")
    private final String selectParams;

    @SerializedName(PickerReporterConstants.KEY.TYPE)
    private final Integer selectType;

    @SerializedName("normal_button")
    private final ECTagListDTO unSelectButton;

    public c() {
        this.selectParams = null;
        this.buttonName = null;
        this.selectButtonName = null;
        this.isSelect = null;
        this.selectButton = null;
        this.unSelectButton = null;
        this.selectType = 0;
        this.generalData = null;
        this.buttonIcon = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L24;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.selectParams, r101.selectParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.buttonName, r101.buttonName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.selectButtonName, r101.selectButtonName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isSelect, r101.isSelect) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.selectButton, r101.selectButton) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.unSelectButton, r101.unSelectButton) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectType, r101.selectType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.generalData, r101.generalData) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.buttonIcon, r101.buttonIcon) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.selectParams;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.buttonName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.selectButtonName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isSelect;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECTagListDTO r113 = this.selectButton;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECTagListDTO r116 = this.unSelectButton;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.selectType;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, Object> r122 = this.generalData;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        ECUrlModel r125 = this.buttonIcon;
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
        return "ECSelectButton(selectParams=" + this.selectParams + ", buttonName=" + this.buttonName + ", selectButtonName=" + this.selectButtonName + ", isSelect=" + this.isSelect + ", selectButton=" + this.selectButton + ", unSelectButton=" + this.unSelectButton + ", selectType=" + this.selectType + ", generalData=" + this.generalData + ", buttonIcon=" + this.buttonIcon + ")";
    }

    public final Map<String, Object> a() {
        return this.generalData;
    }

    public final ECTagListDTO b() {
        return this.selectButton;
    }

    public final String c() {
        return this.selectParams;
    }

    public final ECTagListDTO d() {
        return this.unSelectButton;
    }

    public final Boolean e() {
        return this.isSelect;
    }

    public final void f(Boolean r100) {
        this.isSelect = r100;
    }
}
