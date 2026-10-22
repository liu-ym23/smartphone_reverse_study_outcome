package com.bytedance.android.shopping.sku.common.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/data/Sku;", "Ljava/io/Serializable;", "canSelect", "", "skuStatus", "", "(ZLjava/lang/String;)V", "getCanSelect", "()Z", "getSkuStatus", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Sku implements Serializable {

    @SerializedName("can_select")
    private final boolean canSelect;

    @SerializedName("sku_status")
    private final String skuStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public Sku() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public final boolean getCanSelect() {
        return this.canSelect;
    }

    public final String getSkuStatus() {
        return this.skuStatus;
    }

    public Sku(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "skuStatus");
        this.canSelect = r100;
        this.skuStatus = r101;
    }

    public /* synthetic */ Sku(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "0";
    L8:
        this(r100, r101);
    }
}
