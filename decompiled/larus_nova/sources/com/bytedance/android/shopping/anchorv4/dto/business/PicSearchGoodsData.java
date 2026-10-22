package com.bytedance.android.shopping.anchorv4.dto.business;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchGoodsData;", "Ljava/io/Serializable;", "data", "Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchItemData;", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchItemData;)V", "getData", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchItemData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PicSearchGoodsData implements Serializable {

    @SerializedName("data")
    private final PicSearchItemData data;

    /* JADX WARN: Multi-variable type inference failed */
    public PicSearchGoodsData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PicSearchGoodsData copy$default(PicSearchGoodsData r100, PicSearchItemData r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        return r100.copy(r101);
    }

    public final PicSearchItemData component1() {
        return this.data;
    }

    public final PicSearchGoodsData copy(PicSearchItemData r100) {
        return new PicSearchGoodsData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PicSearchGoodsData) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.data, ((PicSearchGoodsData) r100).data) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        PicSearchItemData r100 = this.data;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "PicSearchGoodsData(data=" + this.data + ")";
    }

    public final PicSearchItemData getData() {
        return this.data;
    }

    public PicSearchGoodsData(PicSearchItemData r100) {
        this.data = r100;
    }

    public /* synthetic */ PicSearchGoodsData(PicSearchItemData r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
