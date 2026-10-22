package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.ProductInfo")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "Landroid/os/Parcelable;", "", "productId", "Ljava/lang/String;", "title", "imgUrl", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductIntroductionInfo;", "introductionList", "Ljava/util/List;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductLabelInfo;", "labelList", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductPriceInfo;", "price", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductPriceInfo;", "actionText", "", "isShow", "Z", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductJumpSetting;", "jumpSetting", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductJumpSetting;", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductInfo implements Parcelable, h {
    public static final Parcelable.Creator<ProductInfo> CREATOR = null;

    @SerializedName("action_text")
    public String actionText;

    @SerializedName(VideoThumbInfo.KEY_IMG_URL)
    public String imgUrl;

    @SerializedName("introduction_list")
    public List<ProductIntroductionInfo> introductionList;

    @SerializedName("isShow")
    public boolean isShow;

    @SerializedName("jump_setting")
    public ProductJumpSetting jumpSetting;

    @SerializedName("label_list")
    public List<ProductLabelInfo> labelList;

    @SerializedName("price")
    public ProductPriceInfo price;

    @SerializedName("product_id")
    public String productId;

    @SerializedName("title")
    public String title;

    public static class a implements Parcelable.Creator<ProductInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            if (r110.readInt() == 0) goto L7;
            int r103 = r110.readInt();
            ArrayList r104 = new ArrayList(r103);
        L5:
            if (r103 == 0) goto L9;
            r104.add(ProductIntroductionInfo.CREATOR.createFromParcel(r110));
            r103 = r103 - 1;
        L9:
            if (r110.readInt() == 0) goto L13;
            int r105 = r110.readInt();
            ArrayList r106 = new ArrayList(r105);
        L11:
            if (r105 == 0) goto L15;
            r106.add(ProductLabelInfo.CREATOR.createFromParcel(r110));
            r105 = r105 - 1;
        L15:
            if (r110.readInt() == 0) goto L17;
            ProductPriceInfo r107 = ProductPriceInfo.CREATOR.createFromParcel(r110);
        L18:
            String r108 = r110.readString();
            if (r110.readInt() == 0) goto L21;
            boolean r111 = true;
        L23:
            if (r110.readInt() == 0) goto L25;
            ProductJumpSetting r112 = ProductJumpSetting.CREATOR.createFromParcel(r110);
        L27:
            return new ProductInfo(r100, r101, r102, r104, r106, r107, r108, r111, r112);
        L25:
            r112 = null;
            goto L27
        L21:
            r111 = false;
            goto L23
        L17:
            r107 = null;
            goto L18
        L13:
            r106 = null;
            goto L15
        L7:
            r104 = null;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ProductInfo[] newArray(int r100) {
            return new ProductInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductInfo(String r100, String r101, String r102, List<ProductIntroductionInfo> r103, List<ProductLabelInfo> r104, ProductPriceInfo r105, String r106, boolean r107, ProductJumpSetting r108) {
        this.productId = r100;
        this.title = r101;
        this.imgUrl = r102;
        this.introductionList = r103;
        this.labelList = r104;
        this.price = r105;
        this.actionText = r106;
        this.isShow = r107;
        this.jumpSetting = r108;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductInfo) == false) goto L24;
        ProductInfo r101 = (ProductInfo) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.imgUrl, r101.imgUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.introductionList, r101.introductionList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.labelList, r101.labelList) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionText, r101.actionText) == true) goto L20;
        return false;
    L20:
        if (this.isShow == r101.isShow) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.jumpSetting, r101.jumpSetting) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v28 */
    public final int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.imgUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<ProductIntroductionInfo> r110 = this.introductionList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<ProductLabelInfo> r113 = this.labelList;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ProductPriceInfo r116 = this.price;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.actionText;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.isShow;
        ?? r123 = r122;
        if (r122 == false) goto L33;
        r123 = 1;
    L33:
        int r124 = (r121 + r123) * 31;
        ProductJumpSetting r125 = this.jumpSetting;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        return r124 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "ProductInfo(productId=" + this.productId + ", title=" + this.title + ", imgUrl=" + this.imgUrl + ", introductionList=" + this.introductionList + ", labelList=" + this.labelList + ", price=" + this.price + ", actionText=" + this.actionText + ", isShow=" + this.isShow + ", jumpSetting=" + this.jumpSetting + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.productId);
        r100.writeString(this.title);
        r100.writeString(this.imgUrl);
        List<ProductIntroductionInfo> r102 = this.introductionList;
        if (r102 == null) goto L8;
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<ProductIntroductionInfo> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r103.next().writeToParcel(r100, 0);
    L9:
        List<ProductLabelInfo> r104 = this.labelList;
        if (r104 == null) goto L15;
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<ProductLabelInfo> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L16;
        r105.next().writeToParcel(r100, 0);
    L16:
        ProductPriceInfo r106 = this.price;
        if (r106 == null) goto L19;
        r100.writeInt(1);
        r106.writeToParcel(r100, 0);
    L20:
        r100.writeString(this.actionText);
        r100.writeInt(this.isShow ? 1 : 0);
        ProductJumpSetting r107 = this.jumpSetting;
        if (r107 == null) goto L23;
        r100.writeInt(1);
        r107.writeToParcel(r100, 0);
        return;
    L23:
        r100.writeInt(0);
        return;
    L19:
        r100.writeInt(0);
        goto L20
    L15:
        r100.writeInt(0);
        goto L16
    L8:
        r100.writeInt(0);
        goto L9
    }

    public ProductInfo() {
        this.productId = null;
        this.title = null;
        this.imgUrl = null;
        this.introductionList = null;
        this.labelList = null;
        this.price = null;
        this.actionText = null;
        this.isShow = false;
        this.jumpSetting = null;
    }

    public ProductInfo(am3.g r100) {
        this.introductionList = new ArrayList();
        this.labelList = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        switch(r103) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.jumpSetting = new ProductJumpSetting(r100);
        goto L3
    L8:
        this.isShow = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L9:
        this.actionText = am3.h.c(r100);
        goto L3
    L10:
        this.price = new ProductPriceInfo(r100);
        goto L3
    L11:
        List r104 = this.labelList;
        h r105 = new ProductLabelInfo(r100);
    L13:
        r104.add(r105);
        goto L3
    L12:
        r104 = this.introductionList;
        r105 = new ProductIntroductionInfo(r100);
        goto L13
    L14:
        this.imgUrl = am3.h.c(r100);
        goto L3
    L15:
        this.title = am3.h.c(r100);
        goto L3
    L16:
        this.productId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.productId != null) goto L21;
        this.productId = null;
    L21:
        if (this.title != null) goto L24;
        this.title = null;
    L24:
        if (this.imgUrl != null) goto L27;
        this.imgUrl = null;
    L27:
        if (this.introductionList.isEmpty() == false) goto L30;
        this.introductionList = null;
    L30:
        if (this.labelList.isEmpty() == false) goto L33;
        this.labelList = null;
    L33:
        if (this.price != null) goto L36;
        this.price = null;
    L36:
        if (this.actionText != null) goto L39;
        this.actionText = null;
    L39:
        if ((r102 & true) == true) goto L42;
        this.isShow = false;
    L42:
        if (this.jumpSetting != null) goto L66;
        this.jumpSetting = null;
        return;
    }
}
