package com.bytedance.android.shopping.anchorv3.dualstream.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/dualstream/model/DualStreamParams;", "Ljava/io/Serializable;", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DualStreamParams implements Serializable {
    private final String productId;

    /* JADX WARN: Multi-variable type inference failed */
    public DualStreamParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DualStreamParams copy$default(DualStreamParams r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.productId;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.productId;
    }

    public final DualStreamParams copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        return new DualStreamParams(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DualStreamParams) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.productId, ((DualStreamParams) r100).productId) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r100 = this.productId;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "DualStreamParams(productId=" + this.productId + ")";
    }

    public final String getProductId() {
        return this.productId;
    }

    public DualStreamParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        this.productId = r100;
    }

    public /* synthetic */ DualStreamParams(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "0";
    L5:
        this(r100);
    }
}
