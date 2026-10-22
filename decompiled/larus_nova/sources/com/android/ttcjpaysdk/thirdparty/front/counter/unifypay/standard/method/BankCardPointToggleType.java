package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.method;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/method/BankCardPointToggleType;", "", "(Ljava/lang/String;I)V", "GUIDE", "SELECTION", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum BankCardPointToggleType extends Enum<BankCardPointToggleType> {
    private static final /* synthetic */ BankCardPointToggleType[] $VALUES = null;
    public static final BankCardPointToggleType GUIDE = null;
    public static final BankCardPointToggleType SELECTION = null;

    private static final /* synthetic */ BankCardPointToggleType[] $values() {
        return new BankCardPointToggleType[]{GUIDE, SELECTION};
    }

    public static BankCardPointToggleType valueOf(String r100) {
        return (BankCardPointToggleType) a.a(BankCardPointToggleType.class, r100);
    }

    public static BankCardPointToggleType[] values() {
        return (BankCardPointToggleType[]) $VALUES.clone();
    }

    static {
        GUIDE = new BankCardPointToggleType("GUIDE", 0);
        SELECTION = new BankCardPointToggleType("SELECTION", 1);
        $VALUES = $values();
    }

    private BankCardPointToggleType(String r100, int r101) {
        super(r100, r101);
    }
}
