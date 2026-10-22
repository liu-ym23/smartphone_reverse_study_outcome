package com.bytedance.android.livesdkapi.depend.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00015R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\nR\u001a\u0010\u001a\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\nR\u001a\u0010\u001d\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\nR\u001a\u0010\"\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\u001f\u0010 R*\u0010)\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0006\u001a\u0004\b&\u0010'R\u001a\u0010*\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b*\u0010 R\u001c\u0010.\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0006\u001a\u0004\b,\u0010\u0012R\u001c\u00101\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0006\u001a\u0004\b/\u0010\u0012R\u001a\u00104\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b2\u0010\n¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;", "Lvh7/c;", "", "getId", "()J", "getId$annotations", "()V", "id", "", "getExchangePrice", "()I", "getExchangePrice$annotations", "exchangePrice", "getPrice", "getPrice$annotations", "price", "", "getDescribe", "()Ljava/lang/String;", "getDescribe$annotations", "describe", "getDiamondCount", "getDiamondCount$annotations", "diamondCount", "getRewardDiamondCount", "getRewardDiamondCount$annotations", "rewardDiamondCount", "getDiscountPrice", "getDiscountPrice$annotations", "discountPrice", "", "getHideGivingCount", "()Z", "getHideGivingCount$annotations", "hideGivingCount", "", "Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal$ICurrencyPrice;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getCurrencyPrice", "()Ljava/util/List;", "getCurrencyPrice$annotations", "currencyPrice", "isCustomizedDiamond", "isCustomizedDiamond$annotations", "getDiamondSignInfo", "getDiamondSignInfo$annotations", "diamondSignInfo", "getIapProductId", "getIapProductId$annotations", "iapProductId", "getDescribeType", "getDescribeType$annotations", "describeType", "ICurrencyPrice", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IChargeDeal extends c<IChargeDeal> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "currency_price")
        public static /* synthetic */ void getCurrencyPrice$annotations() {
        }

        @FieldName(name = "describe")
        public static /* synthetic */ void getDescribe$annotations() {
        }

        @FieldName(name = "describe_type")
        public static /* synthetic */ void getDescribeType$annotations() {
        }

        @FieldName(name = "diamond_count")
        public static /* synthetic */ void getDiamondCount$annotations() {
        }

        @FieldName(name = "diamond_for_create_order")
        public static /* synthetic */ void getDiamondSignInfo$annotations() {
        }

        @FieldName(name = "discount_price")
        public static /* synthetic */ void getDiscountPrice$annotations() {
        }

        @FieldName(name = "exchange_price")
        public static /* synthetic */ void getExchangePrice$annotations() {
        }

        @FieldName(name = "hide_giving_count")
        public static /* synthetic */ void getHideGivingCount$annotations() {
        }

        @FieldName(name = "iap_id")
        public static /* synthetic */ void getIapProductId$annotations() {
        }

        @FieldName(name = "id")
        public static /* synthetic */ void getId$annotations() {
        }

        @FieldName(name = "price")
        public static /* synthetic */ void getPrice$annotations() {
        }

        @FieldName(name = "giving_count")
        public static /* synthetic */ void getRewardDiamondCount$annotations() {
        }

        @FieldName(name = "is_customized_diamond")
        public static /* synthetic */ void isCustomizedDiamond$annotations() {
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal$ICurrencyPrice;", "Lvh7/c;", "", "getCurrency", "()Ljava/lang/String;", "getCurrency$annotations", "()V", "currency", "getPrice", "getPrice$annotations", "price", "getPriceShowForm", "getPriceShowForm$annotations", "priceShowForm", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface ICurrencyPrice extends c<ICurrencyPrice> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class DefaultImpls {
            @FieldName(name = "currency")
            public static /* synthetic */ void getCurrency$annotations() {
            }

            @FieldName(name = "price")
            public static /* synthetic */ void getPrice$annotations() {
            }

            @FieldName(name = "price_show_form")
            public static /* synthetic */ void getPriceShowForm$annotations() {
            }
        }

        @Override // vh7.c
        /* synthetic */ e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ e castToOrNull(Class r100);

        @FieldName(name = "currency")
        String getCurrency();

        @FieldName(name = "price")
        String getPrice();

        @FieldName(name = "price_show_form")
        String getPriceShowForm();
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "currency_price")
    List<ICurrencyPrice> getCurrencyPrice();

    @FieldName(name = "describe")
    String getDescribe();

    @FieldName(name = "describe_type")
    int getDescribeType();

    @FieldName(name = "diamond_count")
    int getDiamondCount();

    @FieldName(name = "diamond_for_create_order")
    String getDiamondSignInfo();

    @FieldName(name = "discount_price")
    int getDiscountPrice();

    @FieldName(name = "exchange_price")
    int getExchangePrice();

    @FieldName(name = "hide_giving_count")
    boolean getHideGivingCount();

    @FieldName(name = "iap_id")
    String getIapProductId();

    @FieldName(name = "id")
    long getId();

    @FieldName(name = "price")
    int getPrice();

    @FieldName(name = "giving_count")
    int getRewardDiamondCount();

    @FieldName(name = "is_customized_diamond")
    boolean isCustomizedDiamond();
}
