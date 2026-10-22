package com.bytedance.android.live.recharge.platform.core.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/core/config/RechargeConfigKey;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "KEY_CASH_EXCHANGE_REBATE", "KEY_CASH_EXCHANGE_RATE_10F", "KEY_RECHARGE_EMPTY_TEXT", "KEY_RECHARGE_SUPPORT_COMBINED_PAY", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RechargeConfigKey extends Enum<RechargeConfigKey> {
    public static final RechargeConfigKey KEY_CASH_EXCHANGE_RATE_10F = null;
    public static final RechargeConfigKey KEY_CASH_EXCHANGE_REBATE = null;
    public static final RechargeConfigKey KEY_RECHARGE_EMPTY_TEXT = null;
    public static final RechargeConfigKey KEY_RECHARGE_SUPPORT_COMBINED_PAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RechargeConfigKey[] f90229a = null;
    private final String des;

    static {
        RechargeConfigKey r100 = new RechargeConfigKey("KEY_CASH_EXCHANGE_REBATE", 0, "是否支持换钻石返利");
        KEY_CASH_EXCHANGE_REBATE = r100;
        RechargeConfigKey r101 = new RechargeConfigKey("KEY_CASH_EXCHANGE_RATE_10F", 1, "人民币兑换钻石的汇率");
        KEY_CASH_EXCHANGE_RATE_10F = r101;
        RechargeConfigKey r102 = new RechargeConfigKey("KEY_RECHARGE_EMPTY_TEXT", 2, "充值面板空文案");
        KEY_RECHARGE_EMPTY_TEXT = r102;
        RechargeConfigKey r103 = new RechargeConfigKey("KEY_RECHARGE_SUPPORT_COMBINED_PAY", 3, "充值是否支持组合支付");
        KEY_RECHARGE_SUPPORT_COMBINED_PAY = r103;
        f90229a = new RechargeConfigKey[]{r100, r101, r102, r103};
    }

    public static RechargeConfigKey valueOf(String r100) {
        return (RechargeConfigKey) a.a(RechargeConfigKey.class, r100);
    }

    public static RechargeConfigKey[] values() {
        return (RechargeConfigKey[]) f90229a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public RechargeConfigKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.des = r102;
    }
}
