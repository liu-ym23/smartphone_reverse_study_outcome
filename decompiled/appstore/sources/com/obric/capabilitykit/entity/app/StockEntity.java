package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\bq\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0081\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\"\u0010y\u001a\u00020z2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010{\u001a\u0004\u0018\u00010|2\u0006\u0010}\u001a\u00020~H\u0016J\u0019\u0010\u007f\u001a\u00020z2\u0006\u0010\u0002\u001a\u00020\u00032\u0007\u0010\u0080\u0001\u001a\u00020~H\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001c\u0010 \u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001c\u0010#\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001c\u0010&\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\u001c\u0010)\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\u001c\u0010,\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\u001c\u00101\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0010R\u001c\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\u001c\u0010:\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000e\"\u0004\b<\u0010\u0010R\u001c\u0010=\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000e\"\u0004\b?\u0010\u0010R\u001c\u0010@\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R\u001c\u0010C\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010\u0010R\u001c\u0010F\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u000e\"\u0004\bH\u0010\u0010R\u001c\u0010I\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u000e\"\u0004\bK\u0010\u0010R\u001c\u0010L\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u000e\"\u0004\bN\u0010\u0010R\u001c\u0010O\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u000e\"\u0004\bQ\u0010\u0010R\u001c\u0010R\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u000e\"\u0004\bT\u0010\u0010R\u001c\u0010U\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000e\"\u0004\bW\u0010\u0010R\u001c\u0010X\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u000e\"\u0004\bZ\u0010\u0010R\u001c\u0010[\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000e\"\u0004\b]\u0010\u0010R\u001c\u0010^\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u000e\"\u0004\b`\u0010\u0010R\u001c\u0010a\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u000e\"\u0004\bc\u0010\u0010R\u001c\u0010d\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u000e\"\u0004\bf\u0010\u0010R\u001c\u0010g\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u000e\"\u0004\bi\u0010\u0010R\u001c\u0010j\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u000e\"\u0004\bl\u0010\u0010R\u001c\u0010m\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u000e\"\u0004\bo\u0010\u0010R\u001c\u0010p\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u000e\"\u0004\br\u0010\u0010R\u001c\u0010s\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u000e\"\u0004\bu\u0010\u0010R\u001c\u0010v\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u000e\"\u0004\bx\u0010\u0010¨\u0006\u0082\u0001"}, d2 = {"Lcom/obric/capabilitykit/entity/app/StockEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "(Ljava/lang/String;JJLjava/lang/String;)V", "basicEarningsPerShare", "getBasicEarningsPerShare", "()Ljava/lang/String;", "setBasicEarningsPerShare", "(Ljava/lang/String;)V", "cashAtEndOfPeriod", "getCashAtEndOfPeriod", "setCashAtEndOfPeriod", "closingPriceToday", "getClosingPriceToday", "setClosingPriceToday", "currentPrice", "getCurrentPrice", "setCurrentPrice", "debtToAssetsRatio", "getDebtToAssetsRatio", "setDebtToAssetsRatio", "grossProfit", "getGrossProfit", "setGrossProfit", "grossProfitMargin", "getGrossProfitMargin", "setGrossProfitMargin", "highestPrice", "getHighestPrice", "setHighestPrice", "lowestPrice", "getLowestPrice", "setLowestPrice", "market", "getMarket", "setMarket", "marketStatus", "getMarketStatus", "setMarketStatus", "getName", "setName", "netAssetsPerShare", "getNetAssetsPerShare", "setNetAssetsPerShare", "netCash", "getNetCash", "setNetCash", "netCashFlowFromFinancingActivities", "getNetCashFlowFromFinancingActivities", "setNetCashFlowFromFinancingActivities", "netCashFlowFromInvestingActivities", "getNetCashFlowFromInvestingActivities", "setNetCashFlowFromInvestingActivities", "netCashFlowFromOperatingActivities", "getNetCashFlowFromOperatingActivities", "setNetCashFlowFromOperatingActivities", "netProfitMargin", "getNetProfitMargin", "setNetProfitMargin", "netProfitToShareholders", "getNetProfitToShareholders", "setNetProfitToShareholders", "openingPriceToday", "getOpeningPriceToday", "setOpeningPriceToday", "operatingIncome", "getOperatingIncome", "setOperatingIncome", "operatingProfit", "getOperatingProfit", "setOperatingProfit", "priceChangePercentageToday", "getPriceChangePercentageToday", "setPriceChangePercentageToday", "priceChangeToday", "getPriceChangeToday", "setPriceChangeToday", "profitAfterTax", "getProfitAfterTax", "setProfitAfterTax", "returnOnEquity", "getReturnOnEquity", "setReturnOnEquity", "shareholdersEquity", "getShareholdersEquity", "setShareholdersEquity", "totalAssets", "getTotalAssets", "setTotalAssets", "totalCurrentAssets", "getTotalCurrentAssets", "setTotalCurrentAssets", "totalCurrentLiabilities", "getTotalCurrentLiabilities", "setTotalCurrentLiabilities", "totalEquity", "getTotalEquity", "setTotalEquity", "totalLiabilities", "getTotalLiabilities", "setTotalLiabilities", "totalNonCurrentAssets", "getTotalNonCurrentAssets", "setTotalNonCurrentAssets", "totalNonCurrentLiabilities", "getTotalNonCurrentLiabilities", "setTotalNonCurrentLiabilities", "tradingValue", "getTradingValue", "setTradingValue", "tradingVolume", "getTradingVolume", "setTradingVolume", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StockEntity extends AppEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;

    @Nullable
    private String basicEarningsPerShare;

    @Nullable
    private String cashAtEndOfPeriod;

    @Nullable
    private String closingPriceToday;

    @Nullable
    private String currentPrice;

    @Nullable
    private String debtToAssetsRatio;

    @Nullable
    private String grossProfit;

    @Nullable
    private String grossProfitMargin;

    @Nullable
    private String highestPrice;

    @Nullable
    private String lowestPrice;

    @Nullable
    private String market;

    @Nullable
    private String marketStatus;

    @NotNull
    private String name;

    @Nullable
    private String netAssetsPerShare;

    @Nullable
    private String netCash;

    @Nullable
    private String netCashFlowFromFinancingActivities;

    @Nullable
    private String netCashFlowFromInvestingActivities;

    @Nullable
    private String netCashFlowFromOperatingActivities;

    @Nullable
    private String netProfitMargin;

    @Nullable
    private String netProfitToShareholders;

    @Nullable
    private String openingPriceToday;

    @Nullable
    private String operatingIncome;

    @Nullable
    private String operatingProfit;

    @Nullable
    private String priceChangePercentageToday;

    @Nullable
    private String priceChangeToday;

    @Nullable
    private String profitAfterTax;

    @Nullable
    private String returnOnEquity;

    @Nullable
    private String shareholdersEquity;

    @Nullable
    private String totalAssets;

    @Nullable
    private String totalCurrentAssets;

    @Nullable
    private String totalCurrentLiabilities;

    @Nullable
    private String totalEquity;

    @Nullable
    private String totalLiabilities;

    @Nullable
    private String totalNonCurrentAssets;

    @Nullable
    private String totalNonCurrentLiabilities;

    @Nullable
    private String tradingValue;

    @Nullable
    private String tradingVolume;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/StockEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/StockEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/StockEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<StockEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public StockEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.StockEntity");
            return (StockEntity) r11;
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public StockEntity[] newArray(int r10) {
            return new StockEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StockEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StockEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public StockEntity(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        this(EntityExtKt.f(r10), r10.readLong(), r10.readLong(), EntityExtKt.f(r10));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        int r11 = r10.readInt();
        this.currentPrice = EntityExtKt.f(r10);
        this.highestPrice = EntityExtKt.f(r10);
        this.lowestPrice = EntityExtKt.f(r10);
        this.tradingVolume = EntityExtKt.f(r10);
        this.tradingValue = EntityExtKt.f(r10);
        this.priceChangeToday = EntityExtKt.f(r10);
        this.priceChangePercentageToday = EntityExtKt.f(r10);
        this.openingPriceToday = EntityExtKt.f(r10);
        this.closingPriceToday = EntityExtKt.f(r10);
        this.netProfitToShareholders = EntityExtKt.f(r10);
        this.operatingIncome = EntityExtKt.f(r10);
        this.basicEarningsPerShare = EntityExtKt.f(r10);
        this.netAssetsPerShare = EntityExtKt.f(r10);
        this.grossProfitMargin = EntityExtKt.f(r10);
        this.netProfitMargin = EntityExtKt.f(r10);
        this.returnOnEquity = EntityExtKt.f(r10);
        this.debtToAssetsRatio = EntityExtKt.f(r10);
        this.grossProfit = EntityExtKt.f(r10);
        this.operatingProfit = EntityExtKt.f(r10);
        this.profitAfterTax = EntityExtKt.f(r10);
        this.totalCurrentAssets = EntityExtKt.f(r10);
        this.totalNonCurrentAssets = EntityExtKt.f(r10);
        this.totalAssets = EntityExtKt.f(r10);
        this.totalCurrentLiabilities = EntityExtKt.f(r10);
        this.totalNonCurrentLiabilities = EntityExtKt.f(r10);
        this.totalLiabilities = EntityExtKt.f(r10);
        this.shareholdersEquity = EntityExtKt.f(r10);
        this.totalEquity = EntityExtKt.f(r10);
        this.netCashFlowFromOperatingActivities = EntityExtKt.f(r10);
        this.netCashFlowFromInvestingActivities = EntityExtKt.f(r10);
        this.netCashFlowFromFinancingActivities = EntityExtKt.f(r10);
        this.netCash = EntityExtKt.f(r10);
        this.cashAtEndOfPeriod = EntityExtKt.f(r10);
        this.market = EntityExtKt.f(r10);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 1, r11);
    }

    @Nullable
    public final String getBasicEarningsPerShare() {
        return this.basicEarningsPerShare;
    }

    @Nullable
    public final String getCashAtEndOfPeriod() {
        return this.cashAtEndOfPeriod;
    }

    @Nullable
    public final String getClosingPriceToday() {
        return this.closingPriceToday;
    }

    @Nullable
    public final String getCurrentPrice() {
        return this.currentPrice;
    }

    @Nullable
    public final String getDebtToAssetsRatio() {
        return this.debtToAssetsRatio;
    }

    @Nullable
    public final String getGrossProfit() {
        return this.grossProfit;
    }

    @Nullable
    public final String getGrossProfitMargin() {
        return this.grossProfitMargin;
    }

    @Nullable
    public final String getHighestPrice() {
        return this.highestPrice;
    }

    @Nullable
    public final String getLowestPrice() {
        return this.lowestPrice;
    }

    @Nullable
    public final String getMarket() {
        return this.market;
    }

    @Nullable
    public final String getMarketStatus() {
        return this.marketStatus;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNetAssetsPerShare() {
        return this.netAssetsPerShare;
    }

    @Nullable
    public final String getNetCash() {
        return this.netCash;
    }

    @Nullable
    public final String getNetCashFlowFromFinancingActivities() {
        return this.netCashFlowFromFinancingActivities;
    }

    @Nullable
    public final String getNetCashFlowFromInvestingActivities() {
        return this.netCashFlowFromInvestingActivities;
    }

    @Nullable
    public final String getNetCashFlowFromOperatingActivities() {
        return this.netCashFlowFromOperatingActivities;
    }

    @Nullable
    public final String getNetProfitMargin() {
        return this.netProfitMargin;
    }

    @Nullable
    public final String getNetProfitToShareholders() {
        return this.netProfitToShareholders;
    }

    @Nullable
    public final String getOpeningPriceToday() {
        return this.openingPriceToday;
    }

    @Nullable
    public final String getOperatingIncome() {
        return this.operatingIncome;
    }

    @Nullable
    public final String getOperatingProfit() {
        return this.operatingProfit;
    }

    @Nullable
    public final String getPriceChangePercentageToday() {
        return this.priceChangePercentageToday;
    }

    @Nullable
    public final String getPriceChangeToday() {
        return this.priceChangeToday;
    }

    @Nullable
    public final String getProfitAfterTax() {
        return this.profitAfterTax;
    }

    @Nullable
    public final String getReturnOnEquity() {
        return this.returnOnEquity;
    }

    @Nullable
    public final String getShareholdersEquity() {
        return this.shareholdersEquity;
    }

    @Nullable
    public final String getTotalAssets() {
        return this.totalAssets;
    }

    @Nullable
    public final String getTotalCurrentAssets() {
        return this.totalCurrentAssets;
    }

    @Nullable
    public final String getTotalCurrentLiabilities() {
        return this.totalCurrentLiabilities;
    }

    @Nullable
    public final String getTotalEquity() {
        return this.totalEquity;
    }

    @Nullable
    public final String getTotalLiabilities() {
        return this.totalLiabilities;
    }

    @Nullable
    public final String getTotalNonCurrentAssets() {
        return this.totalNonCurrentAssets;
    }

    @Nullable
    public final String getTotalNonCurrentLiabilities() {
        return this.totalNonCurrentLiabilities;
    }

    @Nullable
    public final String getTradingValue() {
        return this.tradingValue;
    }

    @Nullable
    public final String getTradingVolume() {
        return this.tradingVolume;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        if (r12 != 1) goto L6;
        this.marketStatus = (String) r10.readValue(r11);
        return;
    }

    public final void setBasicEarningsPerShare(@Nullable String r10) {
        this.basicEarningsPerShare = r10;
    }

    public final void setCashAtEndOfPeriod(@Nullable String r10) {
        this.cashAtEndOfPeriod = r10;
    }

    public final void setClosingPriceToday(@Nullable String r10) {
        this.closingPriceToday = r10;
    }

    public final void setCurrentPrice(@Nullable String r10) {
        this.currentPrice = r10;
    }

    public final void setDebtToAssetsRatio(@Nullable String r10) {
        this.debtToAssetsRatio = r10;
    }

    public final void setGrossProfit(@Nullable String r10) {
        this.grossProfit = r10;
    }

    public final void setGrossProfitMargin(@Nullable String r10) {
        this.grossProfitMargin = r10;
    }

    public final void setHighestPrice(@Nullable String r10) {
        this.highestPrice = r10;
    }

    public final void setLowestPrice(@Nullable String r10) {
        this.lowestPrice = r10;
    }

    public final void setMarket(@Nullable String r10) {
        this.market = r10;
    }

    public final void setMarketStatus(@Nullable String r10) {
        this.marketStatus = r10;
    }

    public final void setName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.name = r10;
    }

    public final void setNetAssetsPerShare(@Nullable String r10) {
        this.netAssetsPerShare = r10;
    }

    public final void setNetCash(@Nullable String r10) {
        this.netCash = r10;
    }

    public final void setNetCashFlowFromFinancingActivities(@Nullable String r10) {
        this.netCashFlowFromFinancingActivities = r10;
    }

    public final void setNetCashFlowFromInvestingActivities(@Nullable String r10) {
        this.netCashFlowFromInvestingActivities = r10;
    }

    public final void setNetCashFlowFromOperatingActivities(@Nullable String r10) {
        this.netCashFlowFromOperatingActivities = r10;
    }

    public final void setNetProfitMargin(@Nullable String r10) {
        this.netProfitMargin = r10;
    }

    public final void setNetProfitToShareholders(@Nullable String r10) {
        this.netProfitToShareholders = r10;
    }

    public final void setOpeningPriceToday(@Nullable String r10) {
        this.openingPriceToday = r10;
    }

    public final void setOperatingIncome(@Nullable String r10) {
        this.operatingIncome = r10;
    }

    public final void setOperatingProfit(@Nullable String r10) {
        this.operatingProfit = r10;
    }

    public final void setPriceChangePercentageToday(@Nullable String r10) {
        this.priceChangePercentageToday = r10;
    }

    public final void setPriceChangeToday(@Nullable String r10) {
        this.priceChangeToday = r10;
    }

    public final void setProfitAfterTax(@Nullable String r10) {
        this.profitAfterTax = r10;
    }

    public final void setReturnOnEquity(@Nullable String r10) {
        this.returnOnEquity = r10;
    }

    public final void setShareholdersEquity(@Nullable String r10) {
        this.shareholdersEquity = r10;
    }

    public final void setTotalAssets(@Nullable String r10) {
        this.totalAssets = r10;
    }

    public final void setTotalCurrentAssets(@Nullable String r10) {
        this.totalCurrentAssets = r10;
    }

    public final void setTotalCurrentLiabilities(@Nullable String r10) {
        this.totalCurrentLiabilities = r10;
    }

    public final void setTotalEquity(@Nullable String r10) {
        this.totalEquity = r10;
    }

    public final void setTotalLiabilities(@Nullable String r10) {
        this.totalLiabilities = r10;
    }

    public final void setTotalNonCurrentAssets(@Nullable String r10) {
        this.totalNonCurrentAssets = r10;
    }

    public final void setTotalNonCurrentLiabilities(@Nullable String r10) {
        this.totalNonCurrentLiabilities = r10;
    }

    public final void setTradingValue(@Nullable String r10) {
        this.tradingValue = r10;
    }

    public final void setTradingVolume(@Nullable String r10) {
        this.tradingVolume = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.name);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(1);
        r10.writeString(this.currentPrice);
        r10.writeString(this.highestPrice);
        r10.writeString(this.lowestPrice);
        r10.writeString(this.tradingVolume);
        r10.writeString(this.tradingValue);
        r10.writeString(this.priceChangeToday);
        r10.writeString(this.priceChangePercentageToday);
        r10.writeString(this.openingPriceToday);
        r10.writeString(this.closingPriceToday);
        r10.writeString(this.netProfitToShareholders);
        r10.writeString(this.operatingIncome);
        r10.writeString(this.basicEarningsPerShare);
        r10.writeString(this.netAssetsPerShare);
        r10.writeString(this.grossProfitMargin);
        r10.writeString(this.netProfitMargin);
        r10.writeString(this.returnOnEquity);
        r10.writeString(this.debtToAssetsRatio);
        r10.writeString(this.grossProfit);
        r10.writeString(this.operatingProfit);
        r10.writeString(this.profitAfterTax);
        r10.writeString(this.totalCurrentAssets);
        r10.writeString(this.totalNonCurrentAssets);
        r10.writeString(this.totalAssets);
        r10.writeString(this.totalCurrentLiabilities);
        r10.writeString(this.totalNonCurrentLiabilities);
        r10.writeString(this.totalLiabilities);
        r10.writeString(this.shareholdersEquity);
        r10.writeString(this.totalEquity);
        r10.writeString(this.netCashFlowFromOperatingActivities);
        r10.writeString(this.netCashFlowFromInvestingActivities);
        r10.writeString(this.netCashFlowFromFinancingActivities);
        r10.writeString(this.netCash);
        r10.writeString(this.cashAtEndOfPeriod);
        r10.writeString(this.market);
        r10.writeValue(this.marketStatus);
    }

    public StockEntity(@NotNull String r10, long r11, long r12, @NotNull String r14) {
        q.g(r10, "id");
        q.g(r14, "name");
        super(r10, r11, r12, EntityType.STOCK);
        this.name = r14;
    }
}
