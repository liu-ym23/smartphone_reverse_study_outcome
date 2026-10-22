package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/u0;", "", "Lcom/bytedance/android/window/shop/repository/dto/t0;", "latestDTO", "Lcom/bytedance/android/window/shop/repository/dto/t0;", "b", "()Lcom/bytedance/android/window/shop/repository/dto/t0;", "", "Lcom/bytedance/android/window/shop/repository/dto/m0;", "productList", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "fold", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    @SerializedName("is_fold")
    private final Boolean fold;

    @SerializedName("latest_info")
    private final t0 latestDTO;

    @SerializedName("product_list")
    private final List<m0> productList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u0) == false) goto L12;
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.latestDTO, r101.latestDTO) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productList, r101.productList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fold, r101.fold) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        t0 r100 = this.latestDTO;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<m0> r104 = this.productList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.fold;
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
        return "WindowLiveHotLatestProductListDTO(latestDTO=" + this.latestDTO + ", productList=" + this.productList + ", fold=" + this.fold + ")";
    }

    public u0() {
        this.latestDTO = null;
        this.productList = null;
        this.fold = null;
    }

    public final Boolean a() {
        return this.fold;
    }

    public final t0 b() {
        return this.latestDTO;
    }

    public final List<m0> c() {
        return this.productList;
    }
}
