package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPayProcessState;", "", "state", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getState", "()Ljava/lang/String;", "TRADE_CONFIRM_START", "TRADE_CONFIRM_END", "TRADE_QUERY_START", "TRADE_QUERY_END", "DOUBLE_CHECK_START", "DOUBLE_CHECK_SUCCESS", "DOUBLE_CHECK_FAILED", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJUnifyPayProcessState extends Enum<CJUnifyPayProcessState> {
    private static final /* synthetic */ CJUnifyPayProcessState[] $VALUES = null;
    public static final CJUnifyPayProcessState DOUBLE_CHECK_FAILED = null;
    public static final CJUnifyPayProcessState DOUBLE_CHECK_START = null;
    public static final CJUnifyPayProcessState DOUBLE_CHECK_SUCCESS = null;
    public static final CJUnifyPayProcessState TRADE_CONFIRM_END = null;
    public static final CJUnifyPayProcessState TRADE_CONFIRM_START = null;
    public static final CJUnifyPayProcessState TRADE_QUERY_END = null;
    public static final CJUnifyPayProcessState TRADE_QUERY_START = null;
    private final String state;

    private static final /* synthetic */ CJUnifyPayProcessState[] $values() {
        return new CJUnifyPayProcessState[]{TRADE_CONFIRM_START, TRADE_CONFIRM_END, TRADE_QUERY_START, TRADE_QUERY_END, DOUBLE_CHECK_START, DOUBLE_CHECK_SUCCESS, DOUBLE_CHECK_FAILED};
    }

    public static CJUnifyPayProcessState valueOf(String r100) {
        return (CJUnifyPayProcessState) a.a(CJUnifyPayProcessState.class, r100);
    }

    public static CJUnifyPayProcessState[] values() {
        return (CJUnifyPayProcessState[]) $VALUES.clone();
    }

    static {
        TRADE_CONFIRM_START = new CJUnifyPayProcessState("TRADE_CONFIRM_START", 0, "trade_confirm_start");
        TRADE_CONFIRM_END = new CJUnifyPayProcessState("TRADE_CONFIRM_END", 1, "trade_confirm_end");
        TRADE_QUERY_START = new CJUnifyPayProcessState("TRADE_QUERY_START", 2, "trade_query_start");
        TRADE_QUERY_END = new CJUnifyPayProcessState("TRADE_QUERY_END", 3, "trade_query_end");
        DOUBLE_CHECK_START = new CJUnifyPayProcessState("DOUBLE_CHECK_START", 4, "double_check_start");
        DOUBLE_CHECK_SUCCESS = new CJUnifyPayProcessState("DOUBLE_CHECK_SUCCESS", 5, "double_check_success");
        DOUBLE_CHECK_FAILED = new CJUnifyPayProcessState("DOUBLE_CHECK_FAILED", 6, "double_check_failed");
        $VALUES = $values();
    }

    public final String getState() {
        return this.state;
    }

    private CJUnifyPayProcessState(String r100, int r101, String r102) {
        super(r100, r101);
        this.state = r102;
    }
}
