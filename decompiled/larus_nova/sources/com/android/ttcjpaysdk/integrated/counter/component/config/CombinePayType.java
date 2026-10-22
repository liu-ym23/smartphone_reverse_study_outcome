package com.android.ttcjpaysdk.integrated.counter.component.config;

import com.android.ttcjpaysdk.thirdparty.data.CJPayCounterConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B#\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/CombinePayType;", "", "primary", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/DYPayType;", "secondary", "combineType", "", "(Ljava/lang/String;ILcom/android/ttcjpaysdk/integrated/counter/component/config/DYPayType;Lcom/android/ttcjpaysdk/integrated/counter/component/config/DYPayType;Ljava/lang/String;)V", "getCombineType", "()Ljava/lang/String;", "getPrimary", "()Lcom/android/ttcjpaysdk/integrated/counter/component/config/DYPayType;", "getSecondary", "BANK_CARD_WITH_BALANCE", "NEW_BANK_CARD_WITH_BALANCE", "BANK_CARD_WITH_INCOME", "NEW_BANK_CARD_WITH_INCOME", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CombinePayType extends Enum<CombinePayType> {
    private static final /* synthetic */ CombinePayType[] $VALUES = null;
    public static final CombinePayType BANK_CARD_WITH_BALANCE = null;
    public static final CombinePayType BANK_CARD_WITH_INCOME = null;
    public static final Companion Companion = null;
    public static final CombinePayType NEW_BANK_CARD_WITH_BALANCE = null;
    public static final CombinePayType NEW_BANK_CARD_WITH_INCOME = null;
    private final String combineType;
    private final DYPayType primary;
    private final DYPayType secondary;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/CombinePayType$Companion;", "", "()V", "map2CombinePayType", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/CombinePayType;", "primary", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/DYPayType;", "secondary", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CombinePayType map2CombinePayType(DYPayType r100, DYPayType r101) {
            DYPayType r102 = DYPayType.BANK_CARD;
            if (r100 == r102) goto L5;
        L7:
            DYPayType r103 = DYPayType.NEW_BANK_CARD;
            if (r100 == r103) goto L10;
        L12:
            if (r100 == r102) goto L14;
        L16:
            if (r100 == r103) goto L18;
        L20:
            return null;
        L18:
            if (r101 != DYPayType.INCOME) goto L20;
            return CombinePayType.NEW_BANK_CARD_WITH_INCOME;
        L14:
            if (r101 != DYPayType.INCOME) goto L16;
            return CombinePayType.BANK_CARD_WITH_INCOME;
        L10:
            if (r101 != DYPayType.BALANCE) goto L12;
            return CombinePayType.NEW_BANK_CARD_WITH_BALANCE;
        L5:
            if (r101 != DYPayType.BALANCE) goto L7;
            return CombinePayType.BANK_CARD_WITH_BALANCE;
        }
    }

    private static final /* synthetic */ CombinePayType[] $values() {
        return new CombinePayType[]{BANK_CARD_WITH_BALANCE, NEW_BANK_CARD_WITH_BALANCE, BANK_CARD_WITH_INCOME, NEW_BANK_CARD_WITH_INCOME};
    }

    public static CombinePayType valueOf(String r100) {
        return (CombinePayType) a.a(CombinePayType.class, r100);
    }

    public static CombinePayType[] values() {
        return (CombinePayType[]) $VALUES.clone();
    }

    static {
        DYPayType r110 = DYPayType.BANK_CARD;
        DYPayType r111 = DYPayType.BALANCE;
        BANK_CARD_WITH_BALANCE = new CombinePayType("BANK_CARD_WITH_BALANCE", 0, r110, r111, "3");
        DYPayType r100 = DYPayType.NEW_BANK_CARD;
        NEW_BANK_CARD_WITH_BALANCE = new CombinePayType("NEW_BANK_CARD_WITH_BALANCE", 1, r100, r111, "3");
        DYPayType r101 = DYPayType.INCOME;
        BANK_CARD_WITH_INCOME = new CombinePayType("BANK_CARD_WITH_INCOME", 2, r110, r101, CJPayCounterConstant.CJ_PAY_KEY_COMBINE_TYPE_INCOME_BANK_CARD);
        NEW_BANK_CARD_WITH_INCOME = new CombinePayType("NEW_BANK_CARD_WITH_INCOME", 3, r100, r101, CJPayCounterConstant.CJ_PAY_KEY_COMBINE_TYPE_INCOME_BANK_CARD);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getCombineType() {
        return this.combineType;
    }

    public final DYPayType getPrimary() {
        return this.primary;
    }

    public final DYPayType getSecondary() {
        return this.secondary;
    }

    private CombinePayType(String r100, int r101, DYPayType r102, DYPayType r103, String r104) {
        super(r100, r101);
        this.primary = r102;
        this.secondary = r103;
        this.combineType = r104;
    }
}
