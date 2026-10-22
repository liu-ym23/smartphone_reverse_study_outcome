package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.ProductPriceInfo")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductPriceInfo;", "Landroid/os/Parcelable;", "", "originalPrice", "Ljava/lang/String;", "currentPrice", "currentPrefix", "currentSuffix", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductPriceInfo implements Parcelable, h {
    public static final Parcelable.Creator<ProductPriceInfo> CREATOR = null;

    @SerializedName("current_prefix")
    public String currentPrefix;

    @SerializedName("current_price")
    public String currentPrice;

    @SerializedName("current_suffix")
    public String currentSuffix;

    @SerializedName(BdpAppEventConstant.PARAMS_ORIGINAL_PRICE)
    public String originalPrice;

    public static class a implements Parcelable.Creator<ProductPriceInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductPriceInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new ProductPriceInfo(r100.readString(), r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ProductPriceInfo[] newArray(int r100) {
            return new ProductPriceInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductPriceInfo(String r100, String r101, String r102, String r103) {
        this.originalPrice = r100;
        this.currentPrice = r101;
        this.currentPrefix = r102;
        this.currentSuffix = r103;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductPriceInfo) == false) goto L14;
        ProductPriceInfo r101 = (ProductPriceInfo) r100;
        if (Intrinsics.areEqual(this.originalPrice, r101.originalPrice) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.currentPrice, r101.currentPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.currentPrefix, r101.currentPrefix) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentSuffix, r101.currentSuffix) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.originalPrice;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.currentPrice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.currentPrefix;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.currentSuffix;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductPriceInfo(originalPrice=" + this.originalPrice + ", currentPrice=" + this.currentPrice + ", currentPrefix=" + this.currentPrefix + ", currentSuffix=" + this.currentSuffix + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.originalPrice);
        r100.writeString(this.currentPrice);
        r100.writeString(this.currentPrefix);
        r100.writeString(this.currentSuffix);
    }

    public ProductPriceInfo() {
        this.originalPrice = null;
        this.currentPrice = null;
        this.currentPrefix = null;
        this.currentSuffix = null;
    }

    public ProductPriceInfo(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.originalPrice = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.currentPrice = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.currentPrefix = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.currentSuffix = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.originalPrice != null) goto L22;
        this.originalPrice = null;
    L22:
        if (this.currentPrice != null) goto L25;
        this.currentPrice = null;
    L25:
        if (this.currentPrefix != null) goto L28;
        this.currentPrefix = null;
    L28:
        if (this.currentSuffix != null) goto L46;
        this.currentSuffix = null;
        return;
    }
}
