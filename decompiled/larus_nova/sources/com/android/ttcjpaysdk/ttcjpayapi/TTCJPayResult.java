package com.android.ttcjpaysdk.ttcjpayapi;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TTCJPayResult implements Parcelable {
    public static final Parcelable.Creator<TTCJPayResult> CREATOR = null;
    public static final int TT_CJ_PAY_ANTI_FRAUD_CANCELED = 116;
    public static final int TT_CJ_PAY_CHECKOUT_COUNTER_TRIGGER_FAILED = 105;
    public static final int TT_CJ_PAY_CREATE_ORDER_FAIL = 5000;
    public static final int TT_CJ_PAY_CREATE_ORDER_SKIP_PAY = 5001;
    public static final int TT_CJ_PAY_H5_CALL_HOST_APP = 114;
    public static final int TT_CJ_PAY_H5_TRIGGER_CALLBACK = 106;
    public static final int TT_CJ_PAY_H5_TRIGGER_FAILED = 107;
    public static final int TT_CJ_PAY_INDEPENDENT_BIND_CARD_LOGIN_FAILURE = 4110;
    public static final int TT_CJ_PAY_INDEPENDENT_BIND_CARD_NETWORK_ERROR = 4199;
    public static final int TT_CJ_PAY_INDEPENDENT_BIND_CARD_OPEN_MODULE_FAILED = 4103;
    public static final int TT_CJ_PAY_INDEPENDENT_BIND_CARD_REQUEST_PARAMS_ILLEGAL = 4111;
    public static final int TT_CJ_PAY_INDEPENDENT_BIND_CARD_RESULT_CANCELED = 4102;
    public static final int TT_CJ_PAY_INDEPENDENT_BIND_CARD_RESULT_FAILED = 4101;
    public static final int TT_CJ_PAY_INDEPENDENT_BIND_CARD_RESULT_SUCCEED = 4100;
    public static final int TT_CJ_PAY_INSUFFICIENT_BALANCE = 113;
    public static final int TT_CJ_PAY_LOGIN_FAILURE = 108;
    public static final int TT_CJ_PAY_NETWORK_ERROR = 109;
    public static final int TT_CJ_PAY_NEW_BANK_CARD_SHARE_SUCCESS = 118;
    public static final int TT_CJ_PAY_PRE_ORDER_EXECUTE = 111;
    public static final int TT_CJ_PAY_PROGRESS_BAR_HIDE = 110;
    public static final int TT_CJ_PAY_REAL_NAME_CONFLICT = 115;
    public static final int TT_CJ_PAY_RECHARGE_INSUFFICIENT = 304;
    public static final int TT_CJ_PAY_RECHARGE_RESULT_CANCELED = 303;
    public static final int TT_CJ_PAY_RECHARGE_RESULT_FAILED = 302;
    public static final int TT_CJ_PAY_RECHARGE_RESULT_PROCESSING = 301;
    public static final int TT_CJ_PAY_RECHARGE_RESULT_SUCCEED = 300;
    public static final int TT_CJ_PAY_RECHARGE_RESULT_UNKNOWN = -1;
    public static final int TT_CJ_PAY_REQUEST_PARAMS_ILLEGAL = 112;
    public static final int TT_CJ_PAY_RESULT_CANCELED = 104;
    public static final int TT_CJ_PAY_RESULT_FAILED = 102;
    public static final int TT_CJ_PAY_RESULT_PROCESSING = 101;
    public static final int TT_CJ_PAY_RESULT_SUCCEED = 0;
    public static final int TT_CJ_PAY_RESULT_TIMEOUT = 103;
    public static final int TT_CJ_PAY_WITHDRAW_RESULT_CANCELED = 203;
    public static final int TT_CJ_PAY_WITHDRAW_RESULT_FAILED = 202;
    public static final int TT_CJ_PAY_WITHDRAW_RESULT_PROCESSING = 201;
    public static final int TT_CJ_PAY_WITHDRAW_RESULT_SUCCEED = 200;
    public static final int TT_CJ_PAY_WITHDRAW_RESULT_UNKNOWN = -1;
    public static final int TT_CJ_PAY_WX_FORE_GROUND = 117;
    public static final int TT_CJ_PAY_WX_NOT_INSTALL = 119;
    private Map<String, String> mCallBackInfo;
    private volatile int mCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public boolean isCancelPayResult() {
        if (104 != this.mCode) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isForground() {
        if (117 != this.mCode) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInsufficientBalancePayResult() {
        if (113 != this.mCode) goto L5;
        return true;
    L5:
        return false;
    }

    public TTCJPayResult() {
        this.mCode = 104;
    }

    public Map<String, String> getCallBackInfo() {
        return this.mCallBackInfo;
    }

    public int getCode() {
        return this.mCode;
    }

    public TTCJPayResult(Parcel r100) {
        this.mCode = 104;
        this.mCode = r100.readInt();
        this.mCallBackInfo = r100.readHashMap(HashMap.class.getClassLoader());
    }

    public void setCallBackInfo(Map<String, String> r100) {
        this.mCallBackInfo = r100;
    }

    public void setCode(int r100) {
        this.mCode = r100;
    }

    public TTCJPayResult(int r100) {
        this.mCode = 104;
        this.mCode = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mCode);
        r100.writeMap(this.mCallBackInfo);
    }
}
