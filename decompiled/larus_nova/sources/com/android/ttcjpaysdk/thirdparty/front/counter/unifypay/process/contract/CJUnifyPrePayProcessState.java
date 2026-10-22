package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract;

import com.android.ttcjpaysdk.superpay.SuperPayAgainActivity;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPrePayProcessState;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "BIND_CARD", "ADD_PWD", SuperPayAgainActivity.PAY_CHANNEL_CREDIT_PAY, "DIRECT_BANK", "INCOME_PAY", "BANK_RESIGN", "ACTIVE_AND_PAY", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJUnifyPrePayProcessState extends Enum<CJUnifyPrePayProcessState> {
    private static final /* synthetic */ CJUnifyPrePayProcessState[] $VALUES = null;
    public static final CJUnifyPrePayProcessState ACTIVE_AND_PAY = null;
    public static final CJUnifyPrePayProcessState ADD_PWD = null;
    public static final CJUnifyPrePayProcessState BANK_RESIGN = null;
    public static final CJUnifyPrePayProcessState BIND_CARD = null;
    public static final CJUnifyPrePayProcessState CREDIT_PAY = null;
    public static final CJUnifyPrePayProcessState DIRECT_BANK = null;
    public static final CJUnifyPrePayProcessState INCOME_PAY = null;
    private final String type;

    private static final /* synthetic */ CJUnifyPrePayProcessState[] $values() {
        return new CJUnifyPrePayProcessState[]{BIND_CARD, ADD_PWD, CREDIT_PAY, DIRECT_BANK, INCOME_PAY, BANK_RESIGN, ACTIVE_AND_PAY};
    }

    public static CJUnifyPrePayProcessState valueOf(String r100) {
        return (CJUnifyPrePayProcessState) a.a(CJUnifyPrePayProcessState.class, r100);
    }

    public static CJUnifyPrePayProcessState[] values() {
        return (CJUnifyPrePayProcessState[]) $VALUES.clone();
    }

    static {
        BIND_CARD = new CJUnifyPrePayProcessState("BIND_CARD", 0, "bind_card");
        ADD_PWD = new CJUnifyPrePayProcessState("ADD_PWD", 1, "add_pwd");
        CREDIT_PAY = new CJUnifyPrePayProcessState(SuperPayAgainActivity.PAY_CHANNEL_CREDIT_PAY, 2, "credit_pay");
        DIRECT_BANK = new CJUnifyPrePayProcessState("DIRECT_BANK", 3, "direct_bank");
        INCOME_PAY = new CJUnifyPrePayProcessState("INCOME_PAY", 4, "income_pay");
        BANK_RESIGN = new CJUnifyPrePayProcessState("BANK_RESIGN", 5, "bank_resign");
        ACTIVE_AND_PAY = new CJUnifyPrePayProcessState("ACTIVE_AND_PAY", 6, "active_and_pay");
        $VALUES = $values();
    }

    public final String getType() {
        return this.type;
    }

    private CJUnifyPrePayProcessState(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
