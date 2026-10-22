package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.window.base.SyncType;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/z0;", "", "", "title", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "products", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "Lcom/bytedance/android/ec/window/base/SyncType;", "syncType", "Lcom/bytedance/android/ec/window/base/SyncType;", "b", "()Lcom/bytedance/android/ec/window/base/SyncType;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z0 {

    @SerializedName("products")
    private final List<WindowV2ProductItemDTO> products;

    @SerializedName("type")
    private final SyncType syncType;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z0) == false) goto L12;
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.products, r101.products) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.syncType, r101.syncType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<WindowV2ProductItemDTO> r104 = this.products;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        SyncType r107 = this.syncType;
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
        return "WindowProductSyncDTO(title=" + this.title + ", products=" + this.products + ", syncType=" + this.syncType + ")";
    }

    public z0() {
        this.title = null;
        this.products = null;
        this.syncType = null;
    }

    public final List<WindowV2ProductItemDTO> a() {
        return this.products;
    }

    public final SyncType b() {
        return this.syncType;
    }

    public final String c() {
        return this.title;
    }
}
