package com.bytedance.android.livesdk.end;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/end/EcomWindowRankItem;", "", "productName", "", "productImgs", "", "(Ljava/lang/String;Ljava/util/List;)V", "getProductImgs", "()Ljava/util/List;", "getProductName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EcomWindowRankItem {

    @SerializedName("product_imgs")
    private final List<String> productImgs;

    @SerializedName("product_name")
    private final String productName;

    /* JADX WARN: Multi-variable type inference failed */
    public EcomWindowRankItem() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EcomWindowRankItem copy$default(EcomWindowRankItem r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.productName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.productImgs;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.productName;
    }

    public final List<String> component2() {
        return this.productImgs;
    }

    public final EcomWindowRankItem copy(String r100, List<String> r101) {
        return new EcomWindowRankItem(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EcomWindowRankItem) == false) goto L10;
        EcomWindowRankItem r101 = (EcomWindowRankItem) r100;
        if (Intrinsics.areEqual(this.productName, r101.productName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productImgs, r101.productImgs) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.productName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.productImgs;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "EcomWindowRankItem(productName=" + this.productName + ", productImgs=" + this.productImgs + ")";
    }

    public final List<String> getProductImgs() {
        return this.productImgs;
    }

    public final String getProductName() {
        return this.productName;
    }

    public EcomWindowRankItem(String r100, List<String> r101) {
        this.productName = r100;
        this.productImgs = r101;
    }

    public /* synthetic */ EcomWindowRankItem(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
