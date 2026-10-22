package com.bytedance.android.live.wallet.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/wallet/monitor/WalletMonitorService;", "", "", "serviceName", "Ljava/lang/String;", "getServiceName", "()Ljava/lang/String;", "WALLET_START_ORDER", "CHARGE_PAY_SEQUENCE_ALL", "CHARGE_ORDER", "WALLET_ORDER_SUCCESS", "WALLET_ORDER_DATA_FAIL", "WALLET_CHECK_ORDER_SUCCESS", "WALLET_CHECK_ORDER_FAIL", "ORDER_CHECKOUT", "WALLET_CJ_ON_CALLEVENT", "WALLET_CJ_ON_PAY_CALLBACK", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WalletMonitorService extends Enum<WalletMonitorService> {
    public static final WalletMonitorService CHARGE_ORDER = null;
    public static final WalletMonitorService CHARGE_PAY_SEQUENCE_ALL = null;
    public static final WalletMonitorService ORDER_CHECKOUT = null;
    public static final WalletMonitorService WALLET_CHECK_ORDER_FAIL = null;
    public static final WalletMonitorService WALLET_CHECK_ORDER_SUCCESS = null;
    public static final WalletMonitorService WALLET_CJ_ON_CALLEVENT = null;
    public static final WalletMonitorService WALLET_CJ_ON_PAY_CALLBACK = null;
    public static final WalletMonitorService WALLET_ORDER_DATA_FAIL = null;
    public static final WalletMonitorService WALLET_ORDER_SUCCESS = null;
    public static final WalletMonitorService WALLET_START_ORDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WalletMonitorService[] f102688a = null;
    private final String serviceName;

    public static WalletMonitorService valueOf(String r100) {
        return (WalletMonitorService) a.a(WalletMonitorService.class, r100);
    }

    public static WalletMonitorService[] values() {
        return (WalletMonitorService[]) f102688a.clone();
    }

    static {
        WalletMonitorService r100 = new WalletMonitorService("WALLET_START_ORDER", 0, "ttlive_wallet_start_order");
        WALLET_START_ORDER = r100;
        WalletMonitorService r101 = new WalletMonitorService("CHARGE_PAY_SEQUENCE_ALL", 1, "ttlive_charge_pay_sequence_all");
        CHARGE_PAY_SEQUENCE_ALL = r101;
        WalletMonitorService r102 = new WalletMonitorService("CHARGE_ORDER", 2, "ttlive_charge_order_all");
        CHARGE_ORDER = r102;
        WalletMonitorService r103 = new WalletMonitorService("WALLET_ORDER_SUCCESS", 3, "ttlive_wallet_order_data_success");
        WALLET_ORDER_SUCCESS = r103;
        WalletMonitorService r104 = new WalletMonitorService("WALLET_ORDER_DATA_FAIL", 4, "ttlive_wallet_order_data_fail");
        WALLET_ORDER_DATA_FAIL = r104;
        WalletMonitorService r105 = new WalletMonitorService("WALLET_CHECK_ORDER_SUCCESS", 5, "ttlive_wallet_check_order_success");
        WALLET_CHECK_ORDER_SUCCESS = r105;
        WalletMonitorService r106 = new WalletMonitorService("WALLET_CHECK_ORDER_FAIL", 6, "ttlive_wallet_check_order_fail");
        WALLET_CHECK_ORDER_FAIL = r106;
        WalletMonitorService r107 = new WalletMonitorService("ORDER_CHECKOUT", 7, "ttlive_wallet_order_to_checkout");
        ORDER_CHECKOUT = r107;
        WalletMonitorService r108 = new WalletMonitorService("WALLET_CJ_ON_CALLEVENT", 8, "ttlive_wallet_cj_on_callevent");
        WALLET_CJ_ON_CALLEVENT = r108;
        WalletMonitorService r109 = new WalletMonitorService("WALLET_CJ_ON_PAY_CALLBACK", 9, "ttlive_wallet_cj_on_pay_callback");
        WALLET_CJ_ON_PAY_CALLBACK = r109;
        f102688a = new WalletMonitorService[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public WalletMonitorService(String r100, int r101, String r102) {
        super(r100, r101);
        this.serviceName = r102;
    }
}
