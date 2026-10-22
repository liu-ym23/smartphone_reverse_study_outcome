package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.StockEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/StockEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class k0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k0 f11292a = null;

    static {
        f11292a = new k0();
    }

    private k0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(@NotNull AppEntity r10) {
        kotlin.jvm.internal.q.g(r10, "instance");
        if ((r10 instanceof StockEntity) == false) goto L111;
        StockEntity r11 = (StockEntity) r10;
        int r12 = r11.getName().hashCode();
        String r13 = r11.getCurrentPrice();
        if (r13 == null) goto L7;
        r12 = (r12 * 31) + r13.hashCode();
    L7:
        String r14 = r11.getHighestPrice();
        if (r14 == null) goto L10;
        r12 = (r12 * 31) + r14.hashCode();
    L10:
        String r15 = r11.getLowestPrice();
        if (r15 == null) goto L13;
        r12 = (r12 * 31) + r15.hashCode();
    L13:
        String r16 = r11.getTradingVolume();
        if (r16 == null) goto L16;
        r12 = (r12 * 31) + r16.hashCode();
    L16:
        String r17 = r11.getTradingValue();
        if (r17 == null) goto L19;
        r12 = (r12 * 31) + r17.hashCode();
    L19:
        String r18 = r11.getPriceChangeToday();
        if (r18 == null) goto L22;
        r12 = (r12 * 31) + r18.hashCode();
    L22:
        String r19 = r11.getPriceChangePercentageToday();
        if (r19 == null) goto L25;
        r12 = (r12 * 31) + r19.hashCode();
    L25:
        String r20 = r11.getOpeningPriceToday();
        if (r20 == null) goto L28;
        r12 = (r12 * 31) + r20.hashCode();
    L28:
        String r21 = r11.getClosingPriceToday();
        if (r21 == null) goto L31;
        r12 = (r12 * 31) + r21.hashCode();
    L31:
        String r22 = r11.getNetProfitToShareholders();
        if (r22 == null) goto L34;
        r12 = (r12 * 31) + r22.hashCode();
    L34:
        String r23 = r11.getOperatingIncome();
        if (r23 == null) goto L37;
        r12 = (r12 * 31) + r23.hashCode();
    L37:
        String r24 = r11.getBasicEarningsPerShare();
        if (r24 == null) goto L40;
        r12 = (r12 * 31) + r24.hashCode();
    L40:
        String r25 = r11.getNetAssetsPerShare();
        if (r25 == null) goto L43;
        r12 = (r12 * 31) + r25.hashCode();
    L43:
        String r26 = r11.getGrossProfitMargin();
        if (r26 == null) goto L46;
        r12 = (r12 * 31) + r26.hashCode();
    L46:
        String r27 = r11.getNetProfitMargin();
        if (r27 == null) goto L49;
        r12 = (r12 * 31) + r27.hashCode();
    L49:
        String r28 = r11.getReturnOnEquity();
        if (r28 == null) goto L52;
        r12 = (r12 * 31) + r28.hashCode();
    L52:
        String r29 = r11.getDebtToAssetsRatio();
        if (r29 == null) goto L55;
        r12 = (r12 * 31) + r29.hashCode();
    L55:
        String r30 = r11.getGrossProfit();
        if (r30 == null) goto L58;
        r12 = (r12 * 31) + r30.hashCode();
    L58:
        String r31 = r11.getOperatingProfit();
        if (r31 == null) goto L61;
        r12 = (r12 * 31) + r31.hashCode();
    L61:
        String r32 = r11.getProfitAfterTax();
        if (r32 == null) goto L64;
        r12 = (r12 * 31) + r32.hashCode();
    L64:
        String r33 = r11.getTotalCurrentAssets();
        if (r33 == null) goto L67;
        r12 = (r12 * 31) + r33.hashCode();
    L67:
        String r34 = r11.getTotalNonCurrentAssets();
        if (r34 == null) goto L70;
        r12 = (r12 * 31) + r34.hashCode();
    L70:
        String r35 = r11.getTotalAssets();
        if (r35 == null) goto L73;
        r12 = (r12 * 31) + r35.hashCode();
    L73:
        String r36 = r11.getTotalCurrentLiabilities();
        if (r36 == null) goto L76;
        r12 = (r12 * 31) + r36.hashCode();
    L76:
        String r37 = r11.getTotalNonCurrentLiabilities();
        if (r37 == null) goto L79;
        r12 = (r12 * 31) + r37.hashCode();
    L79:
        String r38 = r11.getTotalLiabilities();
        if (r38 == null) goto L82;
        r12 = (r12 * 31) + r38.hashCode();
    L82:
        String r39 = r11.getShareholdersEquity();
        if (r39 == null) goto L85;
        r12 = (r12 * 31) + r39.hashCode();
    L85:
        String r40 = r11.getTotalEquity();
        if (r40 == null) goto L88;
        r12 = (r12 * 31) + r40.hashCode();
    L88:
        String r41 = r11.getNetCashFlowFromOperatingActivities();
        if (r41 == null) goto L91;
        r12 = (r12 * 31) + r41.hashCode();
    L91:
        String r42 = r11.getNetCashFlowFromInvestingActivities();
        if (r42 == null) goto L94;
        r12 = (r12 * 31) + r42.hashCode();
    L94:
        String r43 = r11.getNetCashFlowFromFinancingActivities();
        if (r43 == null) goto L97;
        r12 = (r12 * 31) + r43.hashCode();
    L97:
        String r44 = r11.getNetCash();
        if (r44 == null) goto L100;
        r12 = (r12 * 31) + r44.hashCode();
    L100:
        String r45 = r11.getCashAtEndOfPeriod();
        if (r45 == null) goto L103;
        r12 = (r12 * 31) + r45.hashCode();
    L103:
        String r46 = r11.getMarket();
        if (r46 == null) goto L106;
        r12 = (r12 * 31) + r46.hashCode();
    L106:
        String r47 = r11.getMarketStatus();
        if (r47 != null) goto L109;
        return r12;
    L109:
        return (r12 * 31) + r47.hashCode();
    L111:
        throw new IllegalStateException("Check failed.");
    }
}
