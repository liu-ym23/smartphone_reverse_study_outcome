package com.bytedance.android.shopping.sku.common.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/data/GlobalVO;", "Ljava/io/Serializable;", "skuInfoMap", "", "", "Lcom/bytedance/android/shopping/sku/common/data/Sku;", "(Ljava/util/Map;)V", "getSkuInfoMap", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GlobalVO implements Serializable {

    @SerializedName("sku_info_map")
    private final Map<String, Sku> skuInfoMap;

    /* JADX WARN: Multi-variable type inference failed */
    public GlobalVO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Map<String, Sku> getSkuInfoMap() {
        return this.skuInfoMap;
    }

    public GlobalVO(Map<String, Sku> r100) {
        Intrinsics.checkNotNullParameter(r100, "skuInfoMap");
        this.skuInfoMap = r100;
    }

    public /* synthetic */ GlobalVO(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = MapsKt.emptyMap();
    L5:
        this(r100);
    }
}
