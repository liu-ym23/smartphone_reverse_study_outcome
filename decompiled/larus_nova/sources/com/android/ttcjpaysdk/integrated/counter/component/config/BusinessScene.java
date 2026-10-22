package com.android.ttcjpaysdk.integrated.counter.component.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/BusinessScene;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "BALANCE", "INCOME", "BANK_CARD", "NEW_BANK_CARD", "SHARE_PAY", "COMBINE_PAY", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum BusinessScene extends Enum<BusinessScene> {
    private static final /* synthetic */ BusinessScene[] $VALUES = null;
    public static final BusinessScene BALANCE = null;
    public static final BusinessScene BANK_CARD = null;
    public static final BusinessScene COMBINE_PAY = null;
    public static final Companion Companion = null;
    public static final BusinessScene INCOME = null;
    public static final BusinessScene NEW_BANK_CARD = null;
    public static final BusinessScene SHARE_PAY = null;
    private final String scene;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/BusinessScene$Companion;", "", "()V", "fromSubPayType", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/BusinessScene;", "subPayType", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final BusinessScene fromSubPayType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "subPayType");
            if (Intrinsics.areEqual(r100, DYPayType.BALANCE.getType()) == false) goto L6;
            return BusinessScene.BALANCE;
        L6:
            if (Intrinsics.areEqual(r100, DYPayType.INCOME.getType()) == false) goto L9;
            return BusinessScene.INCOME;
        L9:
            if (Intrinsics.areEqual(r100, DYPayType.BANK_CARD.getType()) == false) goto L12;
            return BusinessScene.BANK_CARD;
        L12:
            if (Intrinsics.areEqual(r100, DYPayType.NEW_BANK_CARD.getType()) == false) goto L15;
            return BusinessScene.NEW_BANK_CARD;
        L15:
            if (Intrinsics.areEqual(r100, DYPayType.SHARE_PAY.getType()) == true) goto L23;
            return null;
        L23:
            return BusinessScene.SHARE_PAY;
        }
    }

    private static final /* synthetic */ BusinessScene[] $values() {
        return new BusinessScene[]{BALANCE, INCOME, BANK_CARD, NEW_BANK_CARD, SHARE_PAY, COMBINE_PAY};
    }

    public static BusinessScene valueOf(String r100) {
        return (BusinessScene) a.a(BusinessScene.class, r100);
    }

    public static BusinessScene[] values() {
        return (BusinessScene[]) $VALUES.clone();
    }

    static {
        BALANCE = new BusinessScene("BALANCE", 0, "Pre_Pay_Balance");
        INCOME = new BusinessScene("INCOME", 1, "Pre_Pay_Income");
        BANK_CARD = new BusinessScene("BANK_CARD", 2, "Pre_Pay_BankCard");
        NEW_BANK_CARD = new BusinessScene("NEW_BANK_CARD", 3, "Pre_Pay_NewCard");
        SHARE_PAY = new BusinessScene("SHARE_PAY", 4, "Pre_Pay_SharePay");
        COMBINE_PAY = new BusinessScene("COMBINE_PAY", 5, "Pre_Pay_Combine");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getScene() {
        return this.scene;
    }

    private BusinessScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
