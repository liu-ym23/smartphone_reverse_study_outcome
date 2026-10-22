package com.android.ttcjpaysdk.bdpay.counter.outer;

import com.android.ttcjpaysdk.bdpay.sign.applog.SetPayOrderLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/CJPaySignAndPayLogUtils;", "", "()V", "WALLET_CASHIER_KEEP_POP_CLICK", "", "getWALLET_CASHIER_KEEP_POP_CLICK", "()Ljava/lang/String;", "WALLET_CASHIER_KEEP_POP_SHOW", "getWALLET_CASHIER_KEEP_POP_SHOW", "WALLET_CASHIER_KEEP_POP_VOUCHER_RESULT", "getWALLET_CASHIER_KEEP_POP_VOUCHER_RESULT", "WALLET_ORDERQUEUE_SETUP_ADDCARD_RESULT", "getWALLET_ORDERQUEUE_SETUP_ADDCARD_RESULT", "WALLET_ORDERQUEUE_SETUP_METHOD_CLICK", "getWALLET_ORDERQUEUE_SETUP_METHOD_CLICK", "WALLET_ORDERQUEUE_SETUP_METHOD_CLOSE", "getWALLET_ORDERQUEUE_SETUP_METHOD_CLOSE", "WALLET_ORDERQUEUE_SETUP_METHOD_SHOW", "getWALLET_ORDERQUEUE_SETUP_METHOD_SHOW", "WALLET_WITHHOLD_OPEN_OPEN_CLICK", "getWALLET_WITHHOLD_OPEN_OPEN_CLICK", "WALLET_WITHHOLD_OPEN_PAGE_IMP", "getWALLET_WITHHOLD_OPEN_PAGE_IMP", "WALLET_WITHHOLD_OPEN_PAGE_PAYMENT_SWITCH_CLICK", "getWALLET_WITHHOLD_OPEN_PAGE_PAYMENT_SWITCH_CLICK", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySignAndPayLogUtils {
    public static final CJPaySignAndPayLogUtils INSTANCE = null;
    private static final String WALLET_CASHIER_KEEP_POP_CLICK = null;
    private static final String WALLET_CASHIER_KEEP_POP_SHOW = null;
    private static final String WALLET_CASHIER_KEEP_POP_VOUCHER_RESULT = null;
    private static final String WALLET_ORDERQUEUE_SETUP_ADDCARD_RESULT = null;
    private static final String WALLET_ORDERQUEUE_SETUP_METHOD_CLICK = null;
    private static final String WALLET_ORDERQUEUE_SETUP_METHOD_CLOSE = null;
    private static final String WALLET_ORDERQUEUE_SETUP_METHOD_SHOW = null;
    private static final String WALLET_WITHHOLD_OPEN_OPEN_CLICK = null;
    private static final String WALLET_WITHHOLD_OPEN_PAGE_IMP = null;
    private static final String WALLET_WITHHOLD_OPEN_PAGE_PAYMENT_SWITCH_CLICK = null;

    private CJPaySignAndPayLogUtils() {
    }

    static {
        INSTANCE = new CJPaySignAndPayLogUtils();
        WALLET_WITHHOLD_OPEN_PAGE_IMP = "wallet_withhold_open_page_imp";
        WALLET_WITHHOLD_OPEN_PAGE_PAYMENT_SWITCH_CLICK = "wallet_withhold_open_page_payment_switch_click";
        WALLET_WITHHOLD_OPEN_OPEN_CLICK = "wallet_withhold_open_open_click";
        WALLET_ORDERQUEUE_SETUP_METHOD_SHOW = SetPayOrderLogger.EVENT_SETUP_METHOD_SHOW;
        WALLET_ORDERQUEUE_SETUP_METHOD_CLICK = SetPayOrderLogger.EVENT_SETUP_METHOD_CLICK;
        WALLET_ORDERQUEUE_SETUP_ADDCARD_RESULT = SetPayOrderLogger.EVENT_SETUP_BIND_CARD_RESULT;
        WALLET_ORDERQUEUE_SETUP_METHOD_CLOSE = SetPayOrderLogger.EVENT_SETUP_CLOSE_CLICK;
        WALLET_CASHIER_KEEP_POP_SHOW = "wallet_cashier_keep_pop_show";
        WALLET_CASHIER_KEEP_POP_CLICK = "wallet_cashier_keep_pop_click";
        WALLET_CASHIER_KEEP_POP_VOUCHER_RESULT = "wallet_cashier_keep_pop_voucher_result";
    }

    public final String getWALLET_CASHIER_KEEP_POP_CLICK() {
        return WALLET_CASHIER_KEEP_POP_CLICK;
    }

    public final String getWALLET_CASHIER_KEEP_POP_SHOW() {
        return WALLET_CASHIER_KEEP_POP_SHOW;
    }

    public final String getWALLET_CASHIER_KEEP_POP_VOUCHER_RESULT() {
        return WALLET_CASHIER_KEEP_POP_VOUCHER_RESULT;
    }

    public final String getWALLET_ORDERQUEUE_SETUP_ADDCARD_RESULT() {
        return WALLET_ORDERQUEUE_SETUP_ADDCARD_RESULT;
    }

    public final String getWALLET_ORDERQUEUE_SETUP_METHOD_CLICK() {
        return WALLET_ORDERQUEUE_SETUP_METHOD_CLICK;
    }

    public final String getWALLET_ORDERQUEUE_SETUP_METHOD_CLOSE() {
        return WALLET_ORDERQUEUE_SETUP_METHOD_CLOSE;
    }

    public final String getWALLET_ORDERQUEUE_SETUP_METHOD_SHOW() {
        return WALLET_ORDERQUEUE_SETUP_METHOD_SHOW;
    }

    public final String getWALLET_WITHHOLD_OPEN_OPEN_CLICK() {
        return WALLET_WITHHOLD_OPEN_OPEN_CLICK;
    }

    public final String getWALLET_WITHHOLD_OPEN_PAGE_IMP() {
        return WALLET_WITHHOLD_OPEN_PAGE_IMP;
    }

    public final String getWALLET_WITHHOLD_OPEN_PAGE_PAYMENT_SWITCH_CLICK() {
        return WALLET_WITHHOLD_OPEN_PAGE_PAYMENT_SWITCH_CLICK;
    }
}
