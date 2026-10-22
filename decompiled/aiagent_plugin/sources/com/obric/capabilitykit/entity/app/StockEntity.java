package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class StockEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;
    private String basicEarningsPerShare;
    private String cashAtEndOfPeriod;
    private String closingPriceToday;
    private String currentPrice;
    private String debtToAssetsRatio;
    private String grossProfit;
    private String grossProfitMargin;
    private String highestPrice;
    private String lowestPrice;
    private String market;
    private String marketStatus;
    private String name;
    private String netAssetsPerShare;
    private String netCash;
    private String netCashFlowFromFinancingActivities;
    private String netCashFlowFromInvestingActivities;
    private String netCashFlowFromOperatingActivities;
    private String netProfitMargin;
    private String netProfitToShareholders;
    private String openingPriceToday;
    private String operatingIncome;
    private String operatingProfit;
    private String priceChangePercentageToday;
    private String priceChangeToday;
    private String profitAfterTax;
    private String returnOnEquity;
    private String shareholdersEquity;
    private String totalAssets;
    private String totalCurrentAssets;
    private String totalCurrentLiabilities;
    private String totalEquity;
    private String totalLiabilities;
    private String totalNonCurrentAssets;
    private String totalNonCurrentLiabilities;
    private String tradingValue;
    private String tradingVolume;

    public static final class CREATOR implements Parcelable.Creator<StockEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StockEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.StockEntity");
            return (StockEntity) ZeusTransformUtils.preCheckCast(r1, StockEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StockEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StockEntity[] newArray(int r1) {
            return new StockEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StockEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public StockEntity(Parcel r9) {
        o.e(r9, "parcel");
        this(EntityExtKt.a(r9), r9.readLong(), r9.readLong(), EntityExtKt.a(r9));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r9);
        int r0 = r9.readInt();
        this.currentPrice = EntityExtKt.a(r9);
        this.highestPrice = EntityExtKt.a(r9);
        this.lowestPrice = EntityExtKt.a(r9);
        this.tradingVolume = EntityExtKt.a(r9);
        this.tradingValue = EntityExtKt.a(r9);
        this.priceChangeToday = EntityExtKt.a(r9);
        this.priceChangePercentageToday = EntityExtKt.a(r9);
        this.openingPriceToday = EntityExtKt.a(r9);
        this.closingPriceToday = EntityExtKt.a(r9);
        this.netProfitToShareholders = EntityExtKt.a(r9);
        this.operatingIncome = EntityExtKt.a(r9);
        this.basicEarningsPerShare = EntityExtKt.a(r9);
        this.netAssetsPerShare = EntityExtKt.a(r9);
        this.grossProfitMargin = EntityExtKt.a(r9);
        this.netProfitMargin = EntityExtKt.a(r9);
        this.returnOnEquity = EntityExtKt.a(r9);
        this.debtToAssetsRatio = EntityExtKt.a(r9);
        this.grossProfit = EntityExtKt.a(r9);
        this.operatingProfit = EntityExtKt.a(r9);
        this.profitAfterTax = EntityExtKt.a(r9);
        this.totalCurrentAssets = EntityExtKt.a(r9);
        this.totalNonCurrentAssets = EntityExtKt.a(r9);
        this.totalAssets = EntityExtKt.a(r9);
        this.totalCurrentLiabilities = EntityExtKt.a(r9);
        this.totalNonCurrentLiabilities = EntityExtKt.a(r9);
        this.totalLiabilities = EntityExtKt.a(r9);
        this.shareholdersEquity = EntityExtKt.a(r9);
        this.totalEquity = EntityExtKt.a(r9);
        this.netCashFlowFromOperatingActivities = EntityExtKt.a(r9);
        this.netCashFlowFromInvestingActivities = EntityExtKt.a(r9);
        this.netCashFlowFromFinancingActivities = EntityExtKt.a(r9);
        this.netCash = EntityExtKt.a(r9);
        this.cashAtEndOfPeriod = EntityExtKt.a(r9);
        this.market = EntityExtKt.a(r9);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r9, 1, r0);
    }

    public StockEntity(String r9, long r10, long r12, String r14) {
        o.e(r9, DbHelper.COL_ID);
        o.e(r14, "name");
        super(r9, r10, r12, 1101);
        this.name = r14;
    }

    public final String getBasicEarningsPerShare() {
        return this.basicEarningsPerShare;
    }

    public final String getCashAtEndOfPeriod() {
        return this.cashAtEndOfPeriod;
    }

    public final String getClosingPriceToday() {
        return this.closingPriceToday;
    }

    public final String getCurrentPrice() {
        return this.currentPrice;
    }

    public final String getDebtToAssetsRatio() {
        return this.debtToAssetsRatio;
    }

    public final String getGrossProfit() {
        return this.grossProfit;
    }

    public final String getGrossProfitMargin() {
        return this.grossProfitMargin;
    }

    public final String getHighestPrice() {
        return this.highestPrice;
    }

    public final String getLowestPrice() {
        return this.lowestPrice;
    }

    public final String getMarket() {
        return this.market;
    }

    public final String getMarketStatus() {
        return this.marketStatus;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNetAssetsPerShare() {
        return this.netAssetsPerShare;
    }

    public final String getNetCash() {
        return this.netCash;
    }

    public final String getNetCashFlowFromFinancingActivities() {
        return this.netCashFlowFromFinancingActivities;
    }

    public final String getNetCashFlowFromInvestingActivities() {
        return this.netCashFlowFromInvestingActivities;
    }

    public final String getNetCashFlowFromOperatingActivities() {
        return this.netCashFlowFromOperatingActivities;
    }

    public final String getNetProfitMargin() {
        return this.netProfitMargin;
    }

    public final String getNetProfitToShareholders() {
        return this.netProfitToShareholders;
    }

    public final String getOpeningPriceToday() {
        return this.openingPriceToday;
    }

    public final String getOperatingIncome() {
        return this.operatingIncome;
    }

    public final String getOperatingProfit() {
        return this.operatingProfit;
    }

    public final String getPriceChangePercentageToday() {
        return this.priceChangePercentageToday;
    }

    public final String getPriceChangeToday() {
        return this.priceChangeToday;
    }

    public final String getProfitAfterTax() {
        return this.profitAfterTax;
    }

    public final String getReturnOnEquity() {
        return this.returnOnEquity;
    }

    public final String getShareholdersEquity() {
        return this.shareholdersEquity;
    }

    public final String getTotalAssets() {
        return this.totalAssets;
    }

    public final String getTotalCurrentAssets() {
        return this.totalCurrentAssets;
    }

    public final String getTotalCurrentLiabilities() {
        return this.totalCurrentLiabilities;
    }

    public final String getTotalEquity() {
        return this.totalEquity;
    }

    public final String getTotalLiabilities() {
        return this.totalLiabilities;
    }

    public final String getTotalNonCurrentAssets() {
        return this.totalNonCurrentAssets;
    }

    public final String getTotalNonCurrentLiabilities() {
        return this.totalNonCurrentLiabilities;
    }

    public final String getTradingValue() {
        return this.tradingValue;
    }

    public final String getTradingVolume() {
        return this.tradingVolume;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        o.e(r2, "parcel");
        if (r4 != 1) goto L6;
        this.marketStatus = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setBasicEarningsPerShare(String r1) {
        this.basicEarningsPerShare = r1;
    }

    public final void setCashAtEndOfPeriod(String r1) {
        this.cashAtEndOfPeriod = r1;
    }

    public final void setClosingPriceToday(String r1) {
        this.closingPriceToday = r1;
    }

    public final void setCurrentPrice(String r1) {
        this.currentPrice = r1;
    }

    public final void setDebtToAssetsRatio(String r1) {
        this.debtToAssetsRatio = r1;
    }

    public final void setGrossProfit(String r1) {
        this.grossProfit = r1;
    }

    public final void setGrossProfitMargin(String r1) {
        this.grossProfitMargin = r1;
    }

    public final void setHighestPrice(String r1) {
        this.highestPrice = r1;
    }

    public final void setLowestPrice(String r1) {
        this.lowestPrice = r1;
    }

    public final void setMarket(String r1) {
        this.market = r1;
    }

    public final void setMarketStatus(String r1) {
        this.marketStatus = r1;
    }

    public final void setName(String r2) {
        o.e(r2, "<set-?>");
        this.name = r2;
    }

    public final void setNetAssetsPerShare(String r1) {
        this.netAssetsPerShare = r1;
    }

    public final void setNetCash(String r1) {
        this.netCash = r1;
    }

    public final void setNetCashFlowFromFinancingActivities(String r1) {
        this.netCashFlowFromFinancingActivities = r1;
    }

    public final void setNetCashFlowFromInvestingActivities(String r1) {
        this.netCashFlowFromInvestingActivities = r1;
    }

    public final void setNetCashFlowFromOperatingActivities(String r1) {
        this.netCashFlowFromOperatingActivities = r1;
    }

    public final void setNetProfitMargin(String r1) {
        this.netProfitMargin = r1;
    }

    public final void setNetProfitToShareholders(String r1) {
        this.netProfitToShareholders = r1;
    }

    public final void setOpeningPriceToday(String r1) {
        this.openingPriceToday = r1;
    }

    public final void setOperatingIncome(String r1) {
        this.operatingIncome = r1;
    }

    public final void setOperatingProfit(String r1) {
        this.operatingProfit = r1;
    }

    public final void setPriceChangePercentageToday(String r1) {
        this.priceChangePercentageToday = r1;
    }

    public final void setPriceChangeToday(String r1) {
        this.priceChangeToday = r1;
    }

    public final void setProfitAfterTax(String r1) {
        this.profitAfterTax = r1;
    }

    public final void setReturnOnEquity(String r1) {
        this.returnOnEquity = r1;
    }

    public final void setShareholdersEquity(String r1) {
        this.shareholdersEquity = r1;
    }

    public final void setTotalAssets(String r1) {
        this.totalAssets = r1;
    }

    public final void setTotalCurrentAssets(String r1) {
        this.totalCurrentAssets = r1;
    }

    public final void setTotalCurrentLiabilities(String r1) {
        this.totalCurrentLiabilities = r1;
    }

    public final void setTotalEquity(String r1) {
        this.totalEquity = r1;
    }

    public final void setTotalLiabilities(String r1) {
        this.totalLiabilities = r1;
    }

    public final void setTotalNonCurrentAssets(String r1) {
        this.totalNonCurrentAssets = r1;
    }

    public final void setTotalNonCurrentLiabilities(String r1) {
        this.totalNonCurrentLiabilities = r1;
    }

    public final void setTradingValue(String r1) {
        this.tradingValue = r1;
    }

    public final void setTradingVolume(String r1) {
        this.tradingVolume = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.name);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(1);
        r1.writeString(this.currentPrice);
        r1.writeString(this.highestPrice);
        r1.writeString(this.lowestPrice);
        r1.writeString(this.tradingVolume);
        r1.writeString(this.tradingValue);
        r1.writeString(this.priceChangeToday);
        r1.writeString(this.priceChangePercentageToday);
        r1.writeString(this.openingPriceToday);
        r1.writeString(this.closingPriceToday);
        r1.writeString(this.netProfitToShareholders);
        r1.writeString(this.operatingIncome);
        r1.writeString(this.basicEarningsPerShare);
        r1.writeString(this.netAssetsPerShare);
        r1.writeString(this.grossProfitMargin);
        r1.writeString(this.netProfitMargin);
        r1.writeString(this.returnOnEquity);
        r1.writeString(this.debtToAssetsRatio);
        r1.writeString(this.grossProfit);
        r1.writeString(this.operatingProfit);
        r1.writeString(this.profitAfterTax);
        r1.writeString(this.totalCurrentAssets);
        r1.writeString(this.totalNonCurrentAssets);
        r1.writeString(this.totalAssets);
        r1.writeString(this.totalCurrentLiabilities);
        r1.writeString(this.totalNonCurrentLiabilities);
        r1.writeString(this.totalLiabilities);
        r1.writeString(this.shareholdersEquity);
        r1.writeString(this.totalEquity);
        r1.writeString(this.netCashFlowFromOperatingActivities);
        r1.writeString(this.netCashFlowFromInvestingActivities);
        r1.writeString(this.netCashFlowFromFinancingActivities);
        r1.writeString(this.netCash);
        r1.writeString(this.cashAtEndOfPeriod);
        r1.writeString(this.market);
        r1.writeValue(this.marketStatus);
    }
}
