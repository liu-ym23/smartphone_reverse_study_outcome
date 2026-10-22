package com.bytedance.android.shopping.feed.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0003JQ\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR6\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/DetailCombinePropertiesComponent;", "Ljava/io/Serializable;", "jumpUrl", "", "skus", "", "Lcom/bytedance/android/shopping/feed/repository/dto/DetailCombinePropertiesSkusStruct;", "products", "Ljava/util/HashMap;", "Lcom/bytedance/android/shopping/feed/repository/dto/ProductFormatGroup;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/HashMap;)V", "getJumpUrl", "()Ljava/lang/String;", "getProducts", "()Ljava/util/HashMap;", "getSkus", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DetailCombinePropertiesComponent implements Serializable {

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("product_formats")
    private final HashMap<String, ProductFormatGroup> products;

    @SerializedName("skus")
    private final List<DetailCombinePropertiesSkusStruct> skus;

    public DetailCombinePropertiesComponent() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DetailCombinePropertiesComponent copy$default(DetailCombinePropertiesComponent r100, String r101, List r102, HashMap r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.jumpUrl;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.skus;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.products;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.jumpUrl;
    }

    public final List<DetailCombinePropertiesSkusStruct> component2() {
        return this.skus;
    }

    public final HashMap<String, ProductFormatGroup> component3() {
        return this.products;
    }

    public final DetailCombinePropertiesComponent copy(String r100, List<DetailCombinePropertiesSkusStruct> r101, HashMap<String, ProductFormatGroup> r102) {
        return new DetailCombinePropertiesComponent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DetailCombinePropertiesComponent) == false) goto L12;
        DetailCombinePropertiesComponent r101 = (DetailCombinePropertiesComponent) r100;
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.skus, r101.skus) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.products, r101.products) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.jumpUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<DetailCombinePropertiesSkusStruct> r104 = this.skus;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, ProductFormatGroup> r107 = this.products;
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

    public String toString() {
        return "DetailCombinePropertiesComponent(jumpUrl=" + this.jumpUrl + ", skus=" + this.skus + ", products=" + this.products + ")";
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final HashMap<String, ProductFormatGroup> getProducts() {
        return this.products;
    }

    public final List<DetailCombinePropertiesSkusStruct> getSkus() {
        return this.skus;
    }

    public DetailCombinePropertiesComponent(String r100, List<DetailCombinePropertiesSkusStruct> r101, HashMap<String, ProductFormatGroup> r102) {
        this.jumpUrl = r100;
        this.skus = r101;
        this.products = r102;
    }

    public /* synthetic */ DetailCombinePropertiesComponent(String r100, List r101, HashMap r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
