package com.android.ttcjpaysdk.integrated.counter.component.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/DYPayType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "BALANCE", "INCOME", "BANK_CARD", "NEW_BANK_CARD", "SHARE_PAY", "COMBINE_PAY", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum DYPayType extends Enum<DYPayType> {
    private static final /* synthetic */ DYPayType[] $VALUES = null;
    public static final DYPayType BALANCE = null;
    public static final DYPayType BANK_CARD = null;
    public static final DYPayType COMBINE_PAY = null;
    public static final Companion Companion = null;
    public static final DYPayType INCOME = null;
    public static final DYPayType NEW_BANK_CARD = null;
    public static final DYPayType SHARE_PAY = null;
    private final String type;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/DYPayType$Companion;", "", "()V", "map2DYPayType", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/DYPayType;", "type", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final DYPayType map2DYPayType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            DYPayType[] r101 = DYPayType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            DYPayType r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getType(), r100) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ DYPayType[] $values() {
        return new DYPayType[]{BALANCE, INCOME, BANK_CARD, NEW_BANK_CARD, SHARE_PAY, COMBINE_PAY};
    }

    public static DYPayType valueOf(String r100) {
        return (DYPayType) a.a(DYPayType.class, r100);
    }

    public static DYPayType[] values() {
        return (DYPayType[]) $VALUES.clone();
    }

    static {
        BALANCE = new DYPayType("BALANCE", 0, "balance");
        INCOME = new DYPayType("INCOME", 1, "income");
        BANK_CARD = new DYPayType("BANK_CARD", 2, "bank_card");
        NEW_BANK_CARD = new DYPayType("NEW_BANK_CARD", 3, "new_bank_card");
        SHARE_PAY = new DYPayType("SHARE_PAY", 4, "share_pay");
        COMBINE_PAY = new DYPayType("COMBINE_PAY", 5, "combine_pay");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getType() {
        return this.type;
    }

    private DYPayType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
