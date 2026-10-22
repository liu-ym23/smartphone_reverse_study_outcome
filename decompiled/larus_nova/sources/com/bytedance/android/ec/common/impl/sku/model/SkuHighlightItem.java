package com.bytedance.android.ec.common.impl.sku.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuHighlightItem;", "Ljava/io/Serializable;", "()V", "endIndex", "", "getEndIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "startIndex", "getStartIndex", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuHighlightItem implements Serializable {

    @SerializedName("end_index")
    private final Integer endIndex;

    @SerializedName("start_index")
    private final Integer startIndex;

    public SkuHighlightItem() {
    }

    public final Integer getEndIndex() {
        return this.endIndex;
    }

    public final Integer getStartIndex() {
        return this.startIndex;
    }
}
