package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.StockEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f32071a = null;

    static {
        f32071a = new x();
    }

    private x() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, StockEntity.class) == false) goto L111;
        StockEntity r1 = (StockEntity) ZeusTransformUtils.preCheckCast(r2, StockEntity.class, "com.obric.aiagent.plugin");
        int r3 = r1.getName().hashCode() + 0;
        String r0 = r1.getCurrentPrice();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        String r4 = r1.getHighestPrice();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.hashCode();
    L10:
        String r5 = r1.getLowestPrice();
        if (r5 == null) goto L13;
        r3 = (r3 * 31) + r5.hashCode();
    L13:
        String r6 = r1.getTradingVolume();
        if (r6 == null) goto L16;
        r3 = (r3 * 31) + r6.hashCode();
    L16:
        String r7 = r1.getTradingValue();
        if (r7 == null) goto L19;
        r3 = (r3 * 31) + r7.hashCode();
    L19:
        String r8 = r1.getPriceChangeToday();
        if (r8 == null) goto L22;
        r3 = (r3 * 31) + r8.hashCode();
    L22:
        String r9 = r1.getPriceChangePercentageToday();
        if (r9 == null) goto L25;
        r3 = (r3 * 31) + r9.hashCode();
    L25:
        String r10 = r1.getOpeningPriceToday();
        if (r10 == null) goto L28;
        r3 = (r3 * 31) + r10.hashCode();
    L28:
        String r11 = r1.getClosingPriceToday();
        if (r11 == null) goto L31;
        r3 = (r3 * 31) + r11.hashCode();
    L31:
        String r12 = r1.getNetProfitToShareholders();
        if (r12 == null) goto L34;
        r3 = (r3 * 31) + r12.hashCode();
    L34:
        String r13 = r1.getOperatingIncome();
        if (r13 == null) goto L37;
        r3 = (r3 * 31) + r13.hashCode();
    L37:
        String r14 = r1.getBasicEarningsPerShare();
        if (r14 == null) goto L40;
        r3 = (r3 * 31) + r14.hashCode();
    L40:
        String r15 = r1.getNetAssetsPerShare();
        if (r15 == null) goto L43;
        r3 = (r3 * 31) + r15.hashCode();
    L43:
        String r16 = r1.getGrossProfitMargin();
        if (r16 == null) goto L46;
        r3 = (r3 * 31) + r16.hashCode();
    L46:
        String r17 = r1.getNetProfitMargin();
        if (r17 == null) goto L49;
        r3 = (r3 * 31) + r17.hashCode();
    L49:
        String r18 = r1.getReturnOnEquity();
        if (r18 == null) goto L52;
        r3 = (r3 * 31) + r18.hashCode();
    L52:
        String r19 = r1.getDebtToAssetsRatio();
        if (r19 == null) goto L55;
        r3 = (r3 * 31) + r19.hashCode();
    L55:
        String r20 = r1.getGrossProfit();
        if (r20 == null) goto L58;
        r3 = (r3 * 31) + r20.hashCode();
    L58:
        String r21 = r1.getOperatingProfit();
        if (r21 == null) goto L61;
        r3 = (r3 * 31) + r21.hashCode();
    L61:
        String r22 = r1.getProfitAfterTax();
        if (r22 == null) goto L64;
        r3 = (r3 * 31) + r22.hashCode();
    L64:
        String r23 = r1.getTotalCurrentAssets();
        if (r23 == null) goto L67;
        r3 = (r3 * 31) + r23.hashCode();
    L67:
        String r24 = r1.getTotalNonCurrentAssets();
        if (r24 == null) goto L70;
        r3 = (r3 * 31) + r24.hashCode();
    L70:
        String r25 = r1.getTotalAssets();
        if (r25 == null) goto L73;
        r3 = (r3 * 31) + r25.hashCode();
    L73:
        String r26 = r1.getTotalCurrentLiabilities();
        if (r26 == null) goto L76;
        r3 = (r3 * 31) + r26.hashCode();
    L76:
        String r27 = r1.getTotalNonCurrentLiabilities();
        if (r27 == null) goto L79;
        r3 = (r3 * 31) + r27.hashCode();
    L79:
        String r28 = r1.getTotalLiabilities();
        if (r28 == null) goto L82;
        r3 = (r3 * 31) + r28.hashCode();
    L82:
        String r29 = r1.getShareholdersEquity();
        if (r29 == null) goto L85;
        r3 = (r3 * 31) + r29.hashCode();
    L85:
        String r30 = r1.getTotalEquity();
        if (r30 == null) goto L88;
        r3 = (r3 * 31) + r30.hashCode();
    L88:
        String r31 = r1.getNetCashFlowFromOperatingActivities();
        if (r31 == null) goto L91;
        r3 = (r3 * 31) + r31.hashCode();
    L91:
        String r32 = r1.getNetCashFlowFromInvestingActivities();
        if (r32 == null) goto L94;
        r3 = (r3 * 31) + r32.hashCode();
    L94:
        String r33 = r1.getNetCashFlowFromFinancingActivities();
        if (r33 == null) goto L97;
        r3 = (r3 * 31) + r33.hashCode();
    L97:
        String r34 = r1.getNetCash();
        if (r34 == null) goto L100;
        r3 = (r3 * 31) + r34.hashCode();
    L100:
        String r35 = r1.getCashAtEndOfPeriod();
        if (r35 == null) goto L103;
        r3 = (r3 * 31) + r35.hashCode();
    L103:
        String r36 = r1.getMarket();
        if (r36 == null) goto L106;
        r3 = (r3 * 31) + r36.hashCode();
    L106:
        String r37 = r1.getMarketStatus();
        if (r37 != null) goto L109;
        return r3;
    L109:
        return (r3 * 31) + r37.hashCode();
    L111:
        throw new IllegalStateException("Check failed.".toString());
    }
}
