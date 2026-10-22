package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/model/response/v;", "", "", "cartNum", "I", "b", "()I", "d", "(I)V", "", "disableStepper", "Z", "c", "()Z", "setDisableStepper", "(Z)V", "", "maskStyle", "Ljava/lang/Long;", "getMaskStyle", "()Ljava/lang/Long;", "setMaskStyle", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/ec/model/response/j0;", "action", "Lcom/bytedance/android/ec/model/response/j0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/j0;", "setAction", "(Lcom/bytedance/android/ec/model/response/j0;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("action")
    private j0 action;

    @SerializedName("cart_num")
    private int cartNum;

    @SerializedName("disable")
    private boolean disableStepper;

    @SerializedName("mask_style")
    private Long maskStyle;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L14;
        v r101 = (v) r100;
        if (this.cartNum == r101.cartNum) goto L8;
        return false;
    L8:
        if (this.disableStepper == r101.disableStepper) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.maskStyle, r101.maskStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r100 = this.cartNum * 31;
        boolean r101 = this.disableStepper;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        Long r104 = this.maskStyle;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        j0 r108 = this.action;
        if (r108 == null) goto L13;
        r105 = r108.hashCode();
    L13:
        return r107 + r105;
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "ECPromotionCartStepperInfo(cartNum=" + this.cartNum + ", disableStepper=" + this.disableStepper + ", maskStyle=" + this.maskStyle + ", action=" + this.action + ")";
    }

    public v() {
        this.cartNum = 0;
        this.disableStepper = false;
        this.maskStyle = null;
        this.action = null;
    }

    public final j0 a() {
        return this.action;
    }

    public final int b() {
        return this.cartNum;
    }

    public final boolean c() {
        return this.disableStepper;
    }

    public final void d(int r100) {
        this.cartNum = r100;
    }
}
