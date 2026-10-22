package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayTradeVerifyResponse implements Serializable, CJPayObject {
    public String code;
    public String msg;
    public TradeVerifyInfo trade_verify_info;

    public static class TradeVerifyInfo implements Serializable, CJPayObject {
        public String pwd_check_way;

        public TradeVerifyInfo() {
            this.pwd_check_way = "";
        }
    }

    public boolean isSuccess() {
        return TextUtils.equals(this.code, "CD000000");
    }

    public CJPayTradeVerifyResponse() {
        this.code = "";
        this.msg = "";
        this.trade_verify_info = new TradeVerifyInfo();
    }
}
