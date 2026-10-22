package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/model/response/o1;", "", "", "canPostToAweme", "Z", "getCanPostToAweme", "()Z", "setCanPostToAweme", "(Z)V", "", "productName", "Ljava/lang/String;", "getProductName", "()Ljava/lang/String;", "setProductName", "(Ljava/lang/String;)V", "emptyContent", "getEmptyContent", "setEmptyContent", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class o1 {

    @SerializedName("can_post_to_aweme")
    private boolean canPostToAweme;

    @SerializedName("empty_content")
    private boolean emptyContent;

    @SerializedName("product_name")
    private String productName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o1) == false) goto L12;
        o1 r101 = (o1) r100;
        if (this.canPostToAweme == r101.canPostToAweme) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productName, r101.productName) == true) goto L10;
        return false;
    L10:
        if (this.emptyContent == r101.emptyContent) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.canPostToAweme;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.productName;
        if (r104 == null) goto L8;
        int r105 = r104.hashCode();
    L9:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.emptyContent;
        if (r107 == true) goto L14;
        r101 = r107;
    L14:
        return r106 + r101;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "ShowOrderInfo(canPostToAweme=" + this.canPostToAweme + ", productName=" + this.productName + ", emptyContent=" + this.emptyContent + ")";
    }

    public o1() {
        this.canPostToAweme = false;
        this.productName = "";
        this.emptyContent = false;
    }
}
