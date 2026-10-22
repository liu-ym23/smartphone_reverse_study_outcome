package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPreProcessCode;", "", "status", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "FAILED_BUT_KEEP", "FAILED_TO_EXPAND", "CANCEL", "SUCCESS_AND_PAY", "SUCCESS_AND_VERIFY", "SUCCESS_AND_ONLY_PAY", "SUCCESS_AND_RELOAD_TO_EXPAND", "SUCCESS_AND_RELOAD_BUT_KEEP", "RELOAD_AND_NOT_SILENT", "FAILED_AND_RELOAD_TO_EXPAND", "SHOW_LOADING", "HIDE_LOADING", "CLOSE_CASHIER", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJUnifyPreProcessCode extends Enum<CJUnifyPreProcessCode> {
    private static final /* synthetic */ CJUnifyPreProcessCode[] $VALUES = null;
    public static final CJUnifyPreProcessCode CANCEL = null;
    public static final CJUnifyPreProcessCode CLOSE_CASHIER = null;
    public static final CJUnifyPreProcessCode FAILED_AND_RELOAD_TO_EXPAND = null;
    public static final CJUnifyPreProcessCode FAILED_BUT_KEEP = null;
    public static final CJUnifyPreProcessCode FAILED_TO_EXPAND = null;
    public static final CJUnifyPreProcessCode HIDE_LOADING = null;
    public static final CJUnifyPreProcessCode RELOAD_AND_NOT_SILENT = null;
    public static final CJUnifyPreProcessCode SHOW_LOADING = null;
    public static final CJUnifyPreProcessCode SUCCESS_AND_ONLY_PAY = null;
    public static final CJUnifyPreProcessCode SUCCESS_AND_PAY = null;
    public static final CJUnifyPreProcessCode SUCCESS_AND_RELOAD_BUT_KEEP = null;
    public static final CJUnifyPreProcessCode SUCCESS_AND_RELOAD_TO_EXPAND = null;
    public static final CJUnifyPreProcessCode SUCCESS_AND_VERIFY = null;
    private final String status;

    private static final /* synthetic */ CJUnifyPreProcessCode[] $values() {
        return new CJUnifyPreProcessCode[]{FAILED_BUT_KEEP, FAILED_TO_EXPAND, CANCEL, SUCCESS_AND_PAY, SUCCESS_AND_VERIFY, SUCCESS_AND_ONLY_PAY, SUCCESS_AND_RELOAD_TO_EXPAND, SUCCESS_AND_RELOAD_BUT_KEEP, RELOAD_AND_NOT_SILENT, FAILED_AND_RELOAD_TO_EXPAND, SHOW_LOADING, HIDE_LOADING, CLOSE_CASHIER};
    }

    public static CJUnifyPreProcessCode valueOf(String r100) {
        return (CJUnifyPreProcessCode) a.a(CJUnifyPreProcessCode.class, r100);
    }

    public static CJUnifyPreProcessCode[] values() {
        return (CJUnifyPreProcessCode[]) $VALUES.clone();
    }

    static {
        FAILED_BUT_KEEP = new CJUnifyPreProcessCode("FAILED_BUT_KEEP", 0, "failed_but_keep");
        FAILED_TO_EXPAND = new CJUnifyPreProcessCode("FAILED_TO_EXPAND", 1, "failed_to_expand");
        CANCEL = new CJUnifyPreProcessCode("CANCEL", 2, "cancel");
        SUCCESS_AND_PAY = new CJUnifyPreProcessCode("SUCCESS_AND_PAY", 3, "success_and_pay");
        SUCCESS_AND_VERIFY = new CJUnifyPreProcessCode("SUCCESS_AND_VERIFY", 4, "success_and_verify");
        SUCCESS_AND_ONLY_PAY = new CJUnifyPreProcessCode("SUCCESS_AND_ONLY_PAY", 5, "success_and_only_pay");
        SUCCESS_AND_RELOAD_TO_EXPAND = new CJUnifyPreProcessCode("SUCCESS_AND_RELOAD_TO_EXPAND", 6, "success_and_reload_to_expand");
        SUCCESS_AND_RELOAD_BUT_KEEP = new CJUnifyPreProcessCode("SUCCESS_AND_RELOAD_BUT_KEEP", 7, "success_and_reload_but_keep");
        RELOAD_AND_NOT_SILENT = new CJUnifyPreProcessCode("RELOAD_AND_NOT_SILENT", 8, "reload_and_not_silent");
        FAILED_AND_RELOAD_TO_EXPAND = new CJUnifyPreProcessCode("FAILED_AND_RELOAD_TO_EXPAND", 9, "failed_and_reload_to_expand");
        SHOW_LOADING = new CJUnifyPreProcessCode("SHOW_LOADING", 10, "loading");
        HIDE_LOADING = new CJUnifyPreProcessCode("HIDE_LOADING", 11, "hide_loading");
        CLOSE_CASHIER = new CJUnifyPreProcessCode("CLOSE_CASHIER", 12, "close_cashier");
        $VALUES = $values();
    }

    public final String getStatus() {
        return this.status;
    }

    private CJUnifyPreProcessCode(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
