package com.bytedance.android.live.wallet.monitor;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/wallet/monitor/WalletMonitorEvent;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "", "statusCode", "I", "getStatusCode", "()I", "Lcom/bytedance/android/live/wallet/monitor/WalletMonitorService;", "service", "Lcom/bytedance/android/live/wallet/monitor/WalletMonitorService;", "getService", "()Lcom/bytedance/android/live/wallet/monitor/WalletMonitorService;", "CREAT_ORDER_START", "CHARGE_ORDER", "WALLET_ORDER_RESULT_SUCCESS", "WALLET_ORDER_RESULT_FAIL", "WALLET_ORDER_RESULT_DATA_NULL", "WALLET_ORDER_CHECKOUT", "WALLET_PAY_CLICK", "WALLET_PAY_CASH_SHOW", "WALLET_PAY_PARAMS_ILLEGAL", "WALLET_PAY_COUNTER_TRIGGER_FAILED", "WALLET_PAY_RESULT_SUCCEED", "WALLET_PAY_RESULT_PROCESSING", "WALLET_PAY_RESULT_FAILED", "WALLET_PAY_RESULT_TIMEOUT", "WALLET_PAY_NETWORK_ERROR", "WALLET_PAY_RESULT_CANCELED", "WALLET_PAY_INSUFFICIENT_BALANCE", "WALLET_PAY_LOGIN_FAILURE", "WALLET_PAY_RESULT_OTHER", "WALLET_QUERY_ORDER_PAY_SUCCESS", "WALLET_QUERY_ORDER_PAY_FAILED", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WalletMonitorEvent extends Enum<WalletMonitorEvent> {
    public static final WalletMonitorEvent CHARGE_ORDER = null;
    public static final WalletMonitorEvent CREAT_ORDER_START = null;
    public static final WalletMonitorEvent WALLET_ORDER_CHECKOUT = null;
    public static final WalletMonitorEvent WALLET_ORDER_RESULT_DATA_NULL = null;
    public static final WalletMonitorEvent WALLET_ORDER_RESULT_FAIL = null;
    public static final WalletMonitorEvent WALLET_ORDER_RESULT_SUCCESS = null;
    public static final WalletMonitorEvent WALLET_PAY_CASH_SHOW = null;
    public static final WalletMonitorEvent WALLET_PAY_CLICK = null;
    public static final WalletMonitorEvent WALLET_PAY_COUNTER_TRIGGER_FAILED = null;
    public static final WalletMonitorEvent WALLET_PAY_INSUFFICIENT_BALANCE = null;
    public static final WalletMonitorEvent WALLET_PAY_LOGIN_FAILURE = null;
    public static final WalletMonitorEvent WALLET_PAY_NETWORK_ERROR = null;
    public static final WalletMonitorEvent WALLET_PAY_PARAMS_ILLEGAL = null;
    public static final WalletMonitorEvent WALLET_PAY_RESULT_CANCELED = null;
    public static final WalletMonitorEvent WALLET_PAY_RESULT_FAILED = null;
    public static final WalletMonitorEvent WALLET_PAY_RESULT_OTHER = null;
    public static final WalletMonitorEvent WALLET_PAY_RESULT_PROCESSING = null;
    public static final WalletMonitorEvent WALLET_PAY_RESULT_SUCCEED = null;
    public static final WalletMonitorEvent WALLET_PAY_RESULT_TIMEOUT = null;
    public static final WalletMonitorEvent WALLET_QUERY_ORDER_PAY_FAILED = null;
    public static final WalletMonitorEvent WALLET_QUERY_ORDER_PAY_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WalletMonitorEvent[] f102687a = null;
    private final String eventName;
    private final WalletMonitorService service;
    private final int statusCode;

    public static WalletMonitorEvent valueOf(String r100) {
        return (WalletMonitorEvent) a.a(WalletMonitorEvent.class, r100);
    }

    public static WalletMonitorEvent[] values() {
        return (WalletMonitorEvent[]) f102687a.clone();
    }

    static {
        WalletMonitorEvent r100 = new WalletMonitorEvent("CREAT_ORDER_START", 0, "", 10010, WalletMonitorService.WALLET_START_ORDER);
        CREAT_ORDER_START = r100;
        WalletMonitorEvent r101 = new WalletMonitorEvent("CHARGE_ORDER", 1, "", 10020, WalletMonitorService.CHARGE_ORDER);
        CHARGE_ORDER = r101;
        WalletMonitorEvent r102 = new WalletMonitorEvent("WALLET_ORDER_RESULT_SUCCESS", 2, "success", 10030, WalletMonitorService.WALLET_ORDER_SUCCESS);
        WALLET_ORDER_RESULT_SUCCESS = r102;
        WalletMonitorService r110 = WalletMonitorService.WALLET_ORDER_DATA_FAIL;
        WalletMonitorEvent r103 = new WalletMonitorEvent("WALLET_ORDER_RESULT_FAIL", 3, "fail", 10040, r110);
        WALLET_ORDER_RESULT_FAIL = r103;
        WalletMonitorEvent r104 = new WalletMonitorEvent("WALLET_ORDER_RESULT_DATA_NULL", 4, "data_null", 10050, r110);
        WALLET_ORDER_RESULT_DATA_NULL = r104;
        WalletMonitorEvent r105 = new WalletMonitorEvent("WALLET_ORDER_CHECKOUT", 5, "", 10050, WalletMonitorService.ORDER_CHECKOUT);
        WALLET_ORDER_CHECKOUT = r105;
        WalletMonitorService r111 = WalletMonitorService.WALLET_CJ_ON_CALLEVENT;
        WalletMonitorEvent r106 = new WalletMonitorEvent("WALLET_PAY_CLICK", 6, "wallet_cashier_confirm_click", 10060, r111);
        WALLET_PAY_CLICK = r106;
        WalletMonitorEvent r107 = new WalletMonitorEvent("WALLET_PAY_CASH_SHOW", 7, "wallet_checkout_counter_show", 10070, r111);
        WALLET_PAY_CASH_SHOW = r107;
        WalletMonitorService r108 = WalletMonitorService.WALLET_CJ_ON_PAY_CALLBACK;
        WalletMonitorEvent r109 = new WalletMonitorEvent("WALLET_PAY_PARAMS_ILLEGAL", 8, "wallet_pay_params_illegal", 10080, r108);
        WALLET_PAY_PARAMS_ILLEGAL = r109;
        WalletMonitorEvent r112 = new WalletMonitorEvent("WALLET_PAY_COUNTER_TRIGGER_FAILED", 9, "wallet_pay_trgger_failed", 10090, r108);
        WALLET_PAY_COUNTER_TRIGGER_FAILED = r112;
        WalletMonitorEvent r113 = new WalletMonitorEvent("WALLET_PAY_RESULT_SUCCEED", 10, "wallet_pay_result_succeed", 10100, r108);
        WALLET_PAY_RESULT_SUCCEED = r113;
        WalletMonitorEvent r114 = new WalletMonitorEvent("WALLET_PAY_RESULT_PROCESSING", 11, "wallet_pay_result_processing", 10110, r108);
        WALLET_PAY_RESULT_PROCESSING = r114;
        WalletMonitorEvent r115 = new WalletMonitorEvent("WALLET_PAY_RESULT_FAILED", 12, "wallet_pay_result_failed", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_LOUDNESS_STRATEGY_3_LOUDNESS_LOOKAHEAD_WINDOW, r108);
        WALLET_PAY_RESULT_FAILED = r115;
        WalletMonitorEvent r116 = new WalletMonitorEvent("WALLET_PAY_RESULT_TIMEOUT", 13, "wallet_pay_result_timeout", 10130, r108);
        WALLET_PAY_RESULT_TIMEOUT = r116;
        WalletMonitorEvent r117 = new WalletMonitorEvent("WALLET_PAY_NETWORK_ERROR", 14, "wallet_pay_network_error", 10140, r108);
        WALLET_PAY_NETWORK_ERROR = r117;
        WalletMonitorEvent r118 = new WalletMonitorEvent("WALLET_PAY_RESULT_CANCELED", 15, "wallet_pay_result_canceled", 10150, r108);
        WALLET_PAY_RESULT_CANCELED = r118;
        WalletMonitorEvent r119 = new WalletMonitorEvent("WALLET_PAY_INSUFFICIENT_BALANCE", 16, "wallet_pay_insufficient_balance", 10160, r108);
        WALLET_PAY_INSUFFICIENT_BALANCE = r119;
        WalletMonitorEvent r120 = new WalletMonitorEvent("WALLET_PAY_LOGIN_FAILURE", 17, "wallet_pay_login_failure", 10170, r108);
        WALLET_PAY_LOGIN_FAILURE = r120;
        WalletMonitorEvent r121 = new WalletMonitorEvent("WALLET_PAY_RESULT_OTHER", 18, "wallet_pay_result_other", 10180, r108);
        WALLET_PAY_RESULT_OTHER = r121;
        WalletMonitorService r122 = WalletMonitorService.WALLET_CHECK_ORDER_SUCCESS;
        WalletMonitorEvent r123 = new WalletMonitorEvent("WALLET_QUERY_ORDER_PAY_SUCCESS", 19, "query_order_pay_success", 10190, r122);
        WALLET_QUERY_ORDER_PAY_SUCCESS = r123;
        WalletMonitorEvent r124 = new WalletMonitorEvent("WALLET_QUERY_ORDER_PAY_FAILED", 20, "query_order_pay_failed", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_OUTLET_DB_LIST_STR, r122);
        WALLET_QUERY_ORDER_PAY_FAILED = r124;
        f102687a = new WalletMonitorEvent[]{r100, r101, r102, r103, r104, r105, r106, r107, r109, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r123, r124};
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final WalletMonitorService getService() {
        return this.service;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public WalletMonitorEvent(String r100, int r101, String r102, int r103, WalletMonitorService r104) {
        super(r100, r101);
        this.eventName = r102;
        this.statusCode = r103;
        this.service = r104;
    }
}
