package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/PreVerifyResultAction;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHECK_BY_SERVER", "BACK_TO_CASHIER_HOME", "DEGRADE_CASHIER_UI", "CHANGE_PAY_METHOD", "LOGIN_INVALID", "REFRESH", "CANCELABLE_PAY", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum PreVerifyResultAction extends Enum<PreVerifyResultAction> {
    private static final /* synthetic */ PreVerifyResultAction[] $VALUES = null;
    public static final PreVerifyResultAction BACK_TO_CASHIER_HOME = null;
    public static final PreVerifyResultAction CANCELABLE_PAY = null;
    public static final PreVerifyResultAction CHANGE_PAY_METHOD = null;
    public static final PreVerifyResultAction CHECK_BY_SERVER = null;
    public static final PreVerifyResultAction DEGRADE_CASHIER_UI = null;
    public static final PreVerifyResultAction LOGIN_INVALID = null;
    public static final PreVerifyResultAction REFRESH = null;
    private final String value;

    private static final /* synthetic */ PreVerifyResultAction[] $values() {
        return new PreVerifyResultAction[]{CHECK_BY_SERVER, BACK_TO_CASHIER_HOME, DEGRADE_CASHIER_UI, CHANGE_PAY_METHOD, LOGIN_INVALID, REFRESH, CANCELABLE_PAY};
    }

    public static PreVerifyResultAction valueOf(String r100) {
        return (PreVerifyResultAction) a.a(PreVerifyResultAction.class, r100);
    }

    public static PreVerifyResultAction[] values() {
        return (PreVerifyResultAction[]) $VALUES.clone();
    }

    static {
        CHECK_BY_SERVER = new PreVerifyResultAction("CHECK_BY_SERVER", 0, "checkByServer");
        BACK_TO_CASHIER_HOME = new PreVerifyResultAction("BACK_TO_CASHIER_HOME", 1, "backToCashierHome");
        DEGRADE_CASHIER_UI = new PreVerifyResultAction("DEGRADE_CASHIER_UI", 2, "degradeCashierUi");
        CHANGE_PAY_METHOD = new PreVerifyResultAction("CHANGE_PAY_METHOD", 3, "changePayMethod");
        LOGIN_INVALID = new PreVerifyResultAction("LOGIN_INVALID", 4, "loginInvalid");
        REFRESH = new PreVerifyResultAction("REFRESH", 5, "refresh");
        CANCELABLE_PAY = new PreVerifyResultAction("CANCELABLE_PAY", 6, "cancelablePay");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private PreVerifyResultAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
