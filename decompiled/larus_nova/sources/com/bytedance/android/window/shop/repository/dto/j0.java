package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/j0;", "", "", "height", "Ljava/lang/Double;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Double;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    @SerializedName("height")
    private final Double height;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.height, ((j0) r100).height) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Double r100 = this.height;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "WindowHeaderMarginDTO(height=" + this.height + ")";
    }

    public final Double a() {
        return this.height;
    }
}
