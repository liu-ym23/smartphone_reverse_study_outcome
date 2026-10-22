package com.bytedance.android.ec.window.base.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/r;", "", "", "cartDisable", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "clickToast", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "extraParam", "c", "isShow", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("cart_disable")
    private final Boolean cartDisable;

    @SerializedName("click_toast")
    private final String clickToast;

    @SerializedName("extra_param")
    private final String extraParam;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW)
    private final Boolean isShow;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L14;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.cartDisable, r101.cartDisable) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.clickToast, r101.clickToast) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extraParam, r101.extraParam) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isShow, r101.isShow) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.cartDisable;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.clickToast;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.extraParam;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isShow;
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
        return "WindowCartCtrlDTO(cartDisable=" + this.cartDisable + ", clickToast=" + this.clickToast + ", extraParam=" + this.extraParam + ", isShow=" + this.isShow + ")";
    }

    public r() {
        this.cartDisable = null;
        this.clickToast = null;
        this.extraParam = null;
        this.isShow = null;
    }

    public final Boolean a() {
        return this.cartDisable;
    }

    public final String b() {
        return this.clickToast;
    }

    public final String c() {
        return this.extraParam;
    }

    public final Boolean d() {
        return this.isShow;
    }
}
