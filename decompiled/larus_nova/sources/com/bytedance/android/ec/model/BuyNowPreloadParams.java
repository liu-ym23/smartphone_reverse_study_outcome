package com.bytedance.android.ec.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002Bo\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010'\u001a\u00020(J\t\u0010)\u001a\u00020\u000eHÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000eHÖ\u0001R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u001dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/model/BuyNowPreloadParams;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "isNativeBuyNowSchema", "", "shopCover", "", "shopName", "goodCover", "goodTitleTags", "goodTitle", "price", "", "count", "", "serviceTag", "Lcom/bytedance/android/ec/model/BuyNowServiceTag;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lcom/bytedance/android/ec/model/BuyNowServiceTag;)V", "getCount", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGoodCover", "()Ljava/lang/String;", "setGoodCover", "(Ljava/lang/String;)V", "getGoodTitle", "getGoodTitleTags", "()Z", "getPrice", "()Ljava/lang/Long;", "setPrice", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getServiceTag", "()Lcom/bytedance/android/ec/model/BuyNowServiceTag;", "getShopCover", "getShopName", "asJSONDescription", "Lorg/json/JSONObject;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class BuyNowPreloadParams implements Parcelable, Serializable {
    public static final Parcelable.Creator<BuyNowPreloadParams> CREATOR = null;
    private Integer count;
    private String goodCover;
    private final String goodTitle;
    private final String goodTitleTags;
    private final boolean isNativeBuyNowSchema;
    private Long price;
    private final BuyNowServiceTag serviceTag;
    private final String shopCover;
    private final String shopName;

    public static class a implements Parcelable.Creator<BuyNowPreloadParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BuyNowPreloadParams createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            if (r110.readInt() == 0) goto L5;
            boolean r100 = true;
        L6:
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            if (r110.readInt() == 0) goto L9;
            Long r106 = Long.valueOf(r110.readLong());
        L11:
            if (r110.readInt() == 0) goto L13;
            Integer r111 = Integer.valueOf(r110.readInt());
        L15:
            if (r110.readInt() == 0) goto L17;
            BuyNowServiceTag r112 = BuyNowServiceTag.CREATOR.createFromParcel(r110);
        L19:
            return new BuyNowPreloadParams(r100, r101, r102, r103, r104, r105, r106, r111, r112);
        L17:
            r112 = null;
            goto L19
        L13:
            r111 = null;
            goto L15
        L9:
            r106 = null;
            goto L11
        L5:
            r100 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final BuyNowPreloadParams[] newArray(int r100) {
            return new BuyNowPreloadParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BuyNowPreloadParams() {
        this(false, null, null, null, null, null, null, null, null, 511, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.isNativeBuyNowSchema ? 1 : 0);
        r100.writeString(this.shopCover);
        r100.writeString(this.shopName);
        r100.writeString(this.goodCover);
        r100.writeString(this.goodTitleTags);
        r100.writeString(this.goodTitle);
        Long r102 = this.price;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
    L6:
        Integer r103 = this.count;
        if (r103 == null) goto L9;
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
    L10:
        BuyNowServiceTag r104 = this.serviceTag;
        if (r104 == null) goto L13;
        r100.writeInt(1);
        r104.writeToParcel(r100, 0);
        return;
    L13:
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(0);
        goto L10
    L5:
        r100.writeInt(0);
        goto L6
    }

    public final JSONObject asJSONDescription() {
        JSONObject r100 = new JSONObject();
        r100.put("is_native_buy_now_schema", this.isNativeBuyNowSchema);
        r100.put("shop_cover", this.shopCover);
        r100.put("shop_name", this.shopName);
        r100.put("good_cover", this.goodCover);
        r100.put("good_title_tags", this.goodTitleTags);
        r100.put("good_title", this.goodTitle);
        r100.put("price", this.price);
        r100.put("count", this.count);
        BuyNowServiceTag r101 = this.serviceTag;
        if (r101 == null) goto L5;
        JSONObject r102 = r101.asJSONDescription();
    L6:
        r100.put("service_tag", r102);
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public final Integer getCount() {
        return this.count;
    }

    public final String getGoodCover() {
        return this.goodCover;
    }

    public final String getGoodTitle() {
        return this.goodTitle;
    }

    public final String getGoodTitleTags() {
        return this.goodTitleTags;
    }

    public final Long getPrice() {
        return this.price;
    }

    public final BuyNowServiceTag getServiceTag() {
        return this.serviceTag;
    }

    public final String getShopCover() {
        return this.shopCover;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final boolean isNativeBuyNowSchema() {
        return this.isNativeBuyNowSchema;
    }

    public final void setCount(Integer r100) {
        this.count = r100;
    }

    public final void setGoodCover(String r100) {
        this.goodCover = r100;
    }

    public final void setPrice(Long r100) {
        this.price = r100;
    }

    public BuyNowPreloadParams(boolean r100, String r101, String r102, String r103, String r104, String r105, Long r106, Integer r107, BuyNowServiceTag r108) {
        this.isNativeBuyNowSchema = r100;
        this.shopCover = r101;
        this.shopName = r102;
        this.goodCover = r103;
        this.goodTitleTags = r104;
        this.goodTitle = r105;
        this.price = r106;
        this.count = r107;
        this.serviceTag = r108;
    }

    public /* synthetic */ BuyNowPreloadParams(boolean r110, String r111, String r112, String r113, String r114, String r115, Long r116, Integer r117, BuyNowServiceTag r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = false;
    L6:
        BuyNowServiceTag r101 = null;
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Long r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r101 = r118;
    L38:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r101);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
