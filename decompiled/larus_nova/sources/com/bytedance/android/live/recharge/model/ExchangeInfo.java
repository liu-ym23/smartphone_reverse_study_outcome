package com.bytedance.android.live.recharge.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0014HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J¡\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u0010:\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001b¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/recharge/model/ExchangeInfo;", "", "exchangeBalance", "", "exchangeDiamond", "isFirstExchange", "", "flameTitle", "", "rebateLimit", "giftAmount", "leftAmount", "maxCash", "maxGoldCount", "goldBalance", "hideCombineExchange", "hideCashExchange", "giftPanelType", "disable", "equivalentCashValue", "", "(IIZLjava/lang/String;IIIIIIZZIZJ)V", "getDisable", "()Z", "getEquivalentCashValue", "()J", "getExchangeBalance", "()I", "setExchangeBalance", "(I)V", "getExchangeDiamond", "getFlameTitle", "()Ljava/lang/String;", "getGiftAmount", "getGiftPanelType", "getGoldBalance", "getHideCashExchange", "getHideCombineExchange", "getLeftAmount", "getMaxCash", "getMaxGoldCount", "getRebateLimit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ExchangeInfo {
    private final boolean disable;
    private final long equivalentCashValue;
    private int exchangeBalance;
    private final int exchangeDiamond;
    private final String flameTitle;
    private final int giftAmount;
    private final int giftPanelType;
    private final int goldBalance;
    private final boolean hideCashExchange;
    private final boolean hideCombineExchange;
    private final boolean isFirstExchange;
    private final int leftAmount;
    private final int maxCash;
    private final int maxGoldCount;
    private final int rebateLimit;

    public static /* synthetic */ ExchangeInfo copy$default(ExchangeInfo r110, int r111, int r112, boolean r113, String r210, int r211, int r212, int r213, int r214, int r215, int r216, boolean r217, boolean r218, int r219, boolean r310, long r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        int r100 = r110.exchangeBalance;
    L7:
        if ((r312 & 2) == 0) goto L9;
        int r101 = r110.exchangeDiamond;
    L11:
        if ((r312 & 4) == 0) goto L13;
        boolean r102 = r110.isFirstExchange;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r103 = r110.flameTitle;
    L19:
        if ((r312 & 16) == 0) goto L21;
        int r104 = r110.rebateLimit;
    L23:
        if ((r312 & 32) == 0) goto L25;
        int r105 = r110.giftAmount;
    L27:
        if ((r312 & 64) == 0) goto L29;
        int r106 = r110.leftAmount;
    L31:
        if ((r312 & 128) == 0) goto L33;
        int r107 = r110.maxCash;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r114 = r110.maxGoldCount;
    L39:
        if ((r312 & 512) == 0) goto L41;
        int r115 = r110.goldBalance;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        boolean r116 = r110.hideCombineExchange;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        boolean r117 = r110.hideCashExchange;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        int r118 = r110.giftPanelType;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        boolean r119 = r110.disable;
    L58:
        int r220 = r118;
        boolean r314 = r119;
        if ((r312 & 16384) == 0) goto L61;
        long r120 = r110.equivalentCashValue;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r220, r314, r120);
    L61:
        r120 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L58
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.exchangeBalance;
    }

    public final int component10() {
        return this.goldBalance;
    }

    public final boolean component11() {
        return this.hideCombineExchange;
    }

    public final boolean component12() {
        return this.hideCashExchange;
    }

    public final int component13() {
        return this.giftPanelType;
    }

    public final boolean component14() {
        return this.disable;
    }

    public final long component15() {
        return this.equivalentCashValue;
    }

    public final int component2() {
        return this.exchangeDiamond;
    }

    public final boolean component3() {
        return this.isFirstExchange;
    }

    public final String component4() {
        return this.flameTitle;
    }

    public final int component5() {
        return this.rebateLimit;
    }

    public final int component6() {
        return this.giftAmount;
    }

    public final int component7() {
        return this.leftAmount;
    }

    public final int component8() {
        return this.maxCash;
    }

    public final int component9() {
        return this.maxGoldCount;
    }

    public final ExchangeInfo copy(int r110, int r210, boolean r211, String r212, int r213, int r214, int r215, int r216, int r217, int r218, boolean r219, boolean r310, int r311, boolean r312, long r313) {
        return new ExchangeInfo(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ExchangeInfo) == false) goto L36;
        ExchangeInfo r101 = (ExchangeInfo) r100;
        if (this.exchangeBalance == r101.exchangeBalance) goto L8;
        return false;
    L8:
        if (this.exchangeDiamond == r101.exchangeDiamond) goto L10;
        return false;
    L10:
        if (this.isFirstExchange == r101.isFirstExchange) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.flameTitle, r101.flameTitle) == true) goto L14;
        return false;
    L14:
        if (this.rebateLimit == r101.rebateLimit) goto L16;
        return false;
    L16:
        if (this.giftAmount == r101.giftAmount) goto L18;
        return false;
    L18:
        if (this.leftAmount == r101.leftAmount) goto L20;
        return false;
    L20:
        if (this.maxCash == r101.maxCash) goto L22;
        return false;
    L22:
        if (this.maxGoldCount == r101.maxGoldCount) goto L24;
        return false;
    L24:
        if (this.goldBalance == r101.goldBalance) goto L26;
        return false;
    L26:
        if (this.hideCombineExchange == r101.hideCombineExchange) goto L28;
        return false;
    L28:
        if (this.hideCashExchange == r101.hideCashExchange) goto L30;
        return false;
    L30:
        if (this.giftPanelType == r101.giftPanelType) goto L32;
        return false;
    L32:
        if (this.disable == r101.disable) goto L34;
        return false;
    L34:
        if (this.equivalentCashValue == r101.equivalentCashValue) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        int r100 = ((this.exchangeBalance * 31) + this.exchangeDiamond) * 31;
        boolean r101 = this.isFirstExchange;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        String r105 = this.flameTitle;
        if (r105 == null) goto L8;
        int r106 = r105.hashCode();
    L9:
        int r107 = (((((((((((((r104 + r106) * 31) + this.rebateLimit) * 31) + this.giftAmount) * 31) + this.leftAmount) * 31) + this.maxCash) * 31) + this.maxGoldCount) * 31) + this.goldBalance) * 31;
        boolean r108 = this.hideCombineExchange;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.hideCashExchange;
        ?? r112 = r111;
        if (r111 == false) goto L15;
        r112 = 1;
    L15:
        int r113 = (((r110 + r112) * 31) + this.giftPanelType) * 31;
        boolean r114 = this.disable;
        if (r114 == true) goto L19;
        r102 = r114;
    L19:
        long r115 = this.equivalentCashValue;
        return ((r113 + r102) * 31) + ((int) (r115 ^ (r115 >>> 32)));
    L8:
        r106 = 0;
        goto L9
    }

    public String toString() {
        return "ExchangeInfo(exchangeBalance=" + this.exchangeBalance + ", exchangeDiamond=" + this.exchangeDiamond + ", isFirstExchange=" + this.isFirstExchange + ", flameTitle=" + this.flameTitle + ", rebateLimit=" + this.rebateLimit + ", giftAmount=" + this.giftAmount + ", leftAmount=" + this.leftAmount + ", maxCash=" + this.maxCash + ", maxGoldCount=" + this.maxGoldCount + ", goldBalance=" + this.goldBalance + ", hideCombineExchange=" + this.hideCombineExchange + ", hideCashExchange=" + this.hideCashExchange + ", giftPanelType=" + this.giftPanelType + ", disable=" + this.disable + ", equivalentCashValue=" + this.equivalentCashValue + ")";
    }

    public final boolean getDisable() {
        return this.disable;
    }

    public final long getEquivalentCashValue() {
        return this.equivalentCashValue;
    }

    public final int getExchangeBalance() {
        return this.exchangeBalance;
    }

    public final int getExchangeDiamond() {
        return this.exchangeDiamond;
    }

    public final String getFlameTitle() {
        return this.flameTitle;
    }

    public final int getGiftAmount() {
        return this.giftAmount;
    }

    public final int getGiftPanelType() {
        return this.giftPanelType;
    }

    public final int getGoldBalance() {
        return this.goldBalance;
    }

    public final boolean getHideCashExchange() {
        return this.hideCashExchange;
    }

    public final boolean getHideCombineExchange() {
        return this.hideCombineExchange;
    }

    public final int getLeftAmount() {
        return this.leftAmount;
    }

    public final int getMaxCash() {
        return this.maxCash;
    }

    public final int getMaxGoldCount() {
        return this.maxGoldCount;
    }

    public final int getRebateLimit() {
        return this.rebateLimit;
    }

    public final boolean isFirstExchange() {
        return this.isFirstExchange;
    }

    public final void setExchangeBalance(int r100) {
        this.exchangeBalance = r100;
    }

    public ExchangeInfo(int r100, int r101, boolean r102, String r103, int r104, int r105, int r110, int r111, int r112, int r113, boolean r114, boolean r115, int r116, boolean r117, long r118) {
        this.exchangeBalance = r100;
        this.exchangeDiamond = r101;
        this.isFirstExchange = r102;
        this.flameTitle = r103;
        this.rebateLimit = r104;
        this.giftAmount = r105;
        this.leftAmount = r110;
        this.maxCash = r111;
        this.maxGoldCount = r112;
        this.goldBalance = r113;
        this.hideCombineExchange = r114;
        this.hideCashExchange = r115;
        this.giftPanelType = r116;
        this.disable = r117;
        this.equivalentCashValue = r118;
    }

    public /* synthetic */ ExchangeInfo(int r210, int r211, boolean r212, String r213, int r214, int r215, int r216, int r217, int r218, int r310, boolean r311, boolean r312, int r313, boolean r314, long r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 4) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r316 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r316 & 16) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r316 & 32) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r316 & 64) == 0) goto L21;
        int r110 = 0;
    L23:
        if ((r316 & 128) == 0) goto L25;
        int r111 = 0;
    L27:
        if ((r316 & 256) == 0) goto L29;
        int r112 = 0;
    L31:
        if ((r316 & 512) == 0) goto L33;
        int r113 = 0;
    L35:
        if ((r316 & 1024) == 0) goto L37;
        boolean r114 = false;
    L39:
        if ((r316 & 2048) == 0) goto L41;
        boolean r115 = false;
    L43:
        if ((r316 & 4096) == 0) goto L45;
        int r116 = 0;
    L47:
        if ((r316 & 8192) == 0) goto L49;
        boolean r117 = false;
    L51:
        if ((r316 & 16384) == 0) goto L53;
        long r118 = -1;
    L54:
        this(r210, r211, r100, r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, r117, r118);
        return;
    L53:
        r118 = r315;
        goto L54
    L49:
        r117 = r314;
        goto L51
    L45:
        r116 = r313;
        goto L47
    L41:
        r115 = r312;
        goto L43
    L37:
        r114 = r311;
        goto L39
    L33:
        r113 = r310;
        goto L35
    L29:
        r112 = r218;
        goto L31
    L25:
        r111 = r217;
        goto L27
    L21:
        r110 = r216;
        goto L23
    L17:
        r103 = r215;
        goto L19
    L13:
        r102 = r214;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
