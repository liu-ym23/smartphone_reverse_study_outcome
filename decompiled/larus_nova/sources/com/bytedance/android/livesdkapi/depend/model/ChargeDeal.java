package com.bytedance.android.livesdkapi.depend.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ChargeDeal implements c.a<IChargeDeal>, IChargeDeal, Parcelable {
    public static final Parcelable.Creator<ChargeDeal> CREATOR = null;
    private final transient FlexModelDelegate<IChargeDeal> delegate;
    private transient boolean mChosen;

    @SerializedName("currency_price")
    transient List<CurrencyPrice> mCurrencyPrice;

    @SerializedName("describe")
    String mDescribe;

    @SerializedName("describe_type")
    int mDescribeType;

    @SerializedName("diamond_count")
    int mDiamondCount;

    @SerializedName("diamond_for_create_order")
    String mDiamondSignInfo;

    @SerializedName("discount_price")
    int mDiscountPrice;

    @SerializedName("exchange_price")
    int mExchangePrice;

    @SerializedName("hide_giving_count")
    boolean mHideGivingCount;

    @SerializedName("iap_id")
    String mIapProductId;

    @SerializedName("id")
    long mId;

    @SerializedName("is_customized_diamond")
    boolean mIsCustomizedDiamond;

    @SerializedName("price")
    int mPrice;

    @SerializedName("giving_count")
    int mRewardDiamondCount;
    private transient int totalDiamond;

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class CurrencyPrice extends FlexModelBase<IChargeDeal.ICurrencyPrice> implements IChargeDeal.ICurrencyPrice, Parcelable {
        public static final Parcelable.Creator<CurrencyPrice> CREATOR = null;

        @SerializedName("currency")
        String currency;

        @SerializedName("price")
        String price;

        @SerializedName("price_show_form")
        String priceShowForm;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public CurrencyPrice() {
            super(IChargeDeal.ICurrencyPrice.class);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal.ICurrencyPrice
        public String getCurrency() {
            return this.currency;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal.ICurrencyPrice
        public String getPrice() {
            return this.price;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal.ICurrencyPrice
        public String getPriceShowForm() {
            return this.priceShowForm;
        }

        public CurrencyPrice(Parcel r100) {
            super(IChargeDeal.ICurrencyPrice.class);
            this.currency = r100.readString();
            this.price = r100.readString();
            this.priceShowForm = r100.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.currency);
            r100.writeString(this.price);
            r100.writeString(this.priceShowForm);
        }
    }

    public static class HsSkuDetail implements Parcelable {
        public static final Parcelable.Creator<HsSkuDetail> CREATOR = null;
        private final String description;
        private final String price;
        private final String priceCurrencyCode;
        private final String sku;
        private final String title;
        private final String type;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public HsSkuDetail(Parcel r100) {
            this.sku = r100.readString();
            this.type = r100.readString();
            this.price = r100.readString();
            this.title = r100.readString();
            this.description = r100.readString();
            this.priceCurrencyCode = r100.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.sku);
            r100.writeString(this.type);
            r100.writeString(this.price);
            r100.writeString(this.title);
            r100.writeString(this.description);
            r100.writeString(this.priceCurrencyCode);
        }

        public HsSkuDetail(String r100, String r101, String r102, String r103, String r104, String r105) {
            this.sku = r100;
            this.type = r101;
            this.price = r102;
            this.title = r103;
            this.description = r104;
            this.priceCurrencyCode = r105;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public List<IChargeDeal.ICurrencyPrice> getCurrencyPrice() {
        return KotlinTypeUtilsKt.castElementType(this.mCurrencyPrice);
    }

    public int getRealPrice() {
        int r100 = this.mDiscountPrice;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        return this.mExchangePrice;
    }

    public int getTotalDiamond() {
        int r100 = this.totalDiamond;
        if (r100 == 0) goto L6;
        return r100;
    L6:
        return this.mDiamondCount + this.mRewardDiamondCount;
    }

    public String toString() {
        return "ChargeDeal{mId=" + this.mId + ", mExchangePrice=" + this.mExchangePrice + ", mPrice=" + this.mPrice + ", mDescribe='" + this.mDescribe + "', mDiamondCount=" + this.mDiamondCount + ", mRewardDiamondCount=" + this.mRewardDiamondCount + ", mDiscountPrice=" + this.mDiscountPrice + ", mHideGivingCount=" + this.mHideGivingCount + ", mIsCustomizedDiamond=" + this.mIsCustomizedDiamond + '}';
    }

    public ChargeDeal() {
        this.delegate = new FlexModelDelegate(IChargeDeal.class, this);
        this.mDescribe = "";
    }

    @Override // vh7.c.a
    public FlexModelDelegate<IChargeDeal> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public String getDescribe() {
        return this.mDescribe;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public int getDescribeType() {
        return this.mDescribeType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public int getDiamondCount() {
        return this.mDiamondCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public String getDiamondSignInfo() {
        return this.mDiamondSignInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public int getDiscountPrice() {
        return this.mDiscountPrice;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public int getExchangePrice() {
        return this.mExchangePrice;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public boolean getHideGivingCount() {
        return this.mHideGivingCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public String getIapProductId() {
        return this.mIapProductId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public long getId() {
        return this.mId;
    }

    public boolean getIsCustomizedDiamond() {
        return this.mIsCustomizedDiamond;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public int getPrice() {
        return this.mPrice;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public int getRewardDiamondCount() {
        return this.mRewardDiamondCount;
    }

    public boolean isChosen() {
        return this.mChosen;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IChargeDeal
    public boolean isCustomizedDiamond() {
        return this.mIsCustomizedDiamond;
    }

    public boolean isHideGivingCount() {
        return this.mHideGivingCount;
    }

    public ChargeDeal(Parcel r100) {
        this.delegate = new FlexModelDelegate(IChargeDeal.class, this);
        this.mDescribe = "";
        this.mId = r100.readLong();
        this.mExchangePrice = r100.readInt();
        this.mPrice = r100.readInt();
        this.mDiscountPrice = r100.readInt();
        this.mDescribe = r100.readString();
        this.mDiamondCount = r100.readInt();
        this.mRewardDiamondCount = r100.readInt();
        this.mCurrencyPrice = r100.createTypedArrayList(CurrencyPrice.CREATOR);
        this.totalDiamond = r100.readInt();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.mChosen = r102;
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.mHideGivingCount = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // vh7.c.a, vh7.c
    public <R extends e<IChargeDeal>> R castTo(Class<R> r100) {
        return (R) this.delegate.castTo(r100);
    }

    @Override // vh7.c.a, vh7.c
    public <R extends e<IChargeDeal>> R castToOrNull(Class<R> r100) {
        return (R) this.delegate.castToOrNull(r100);
    }

    public void setChosen(boolean r100) {
        this.mChosen = r100;
    }

    public void setCustomizedDiamond(boolean r100) {
        this.mIsCustomizedDiamond = r100;
    }

    public void setDescribe(String r100) {
        this.mDescribe = r100;
    }

    public void setDiamondCount(int r100) {
        this.mDiamondCount = r100;
    }

    public void setDiscountPrice(int r100) {
        this.mDiscountPrice = r100;
    }

    public void setExchangePrice(int r100) {
        this.mExchangePrice = r100;
    }

    public void setId(long r100) {
        this.mId = r100;
    }

    public void setPrice(int r100) {
        this.mPrice = r100;
    }

    public void setRewardDiamondCount(int r100) {
        this.mRewardDiamondCount = r100;
    }

    public void setTotalDiamond(int r100) {
        this.totalDiamond = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.mId);
        r100.writeInt(this.mExchangePrice);
        r100.writeInt(this.mPrice);
        r100.writeInt(this.mDiscountPrice);
        r100.writeString(this.mDescribe);
        r100.writeInt(this.mDiamondCount);
        r100.writeInt(this.mRewardDiamondCount);
        r100.writeTypedList(this.mCurrencyPrice);
        r100.writeInt(this.totalDiamond);
        r100.writeByte(this.mChosen ? 1 : 0);
        r100.writeByte(this.mHideGivingCount ? 1 : 0);
    }
}
