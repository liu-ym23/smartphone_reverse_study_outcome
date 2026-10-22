package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.integrated.counter.component.config.IDYPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig;
import com.android.ttcjpaysdk.integrated.counter.component.config.PayTypeConfig;
import com.android.ttcjpaysdk.integrated.counter.component.config.std.StdPayTypeConfig;
import com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo;
import com.android.ttcjpaysdk.integrated.counter.outerpay.IntegratedOuterPayRooter;
import com.android.ttcjpaysdk.thirdparty.data.CashDeskShowConf;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class PayComponentBean implements CJPayObject {
    public CashDeskShowConf cashdesk_show_conf;
    public String default_ptcode;
    public IntegratedCounterResponseData.Exts exts;
    public JSONObject fe_metrics;
    public String jh_pass_through;
    public MerchantInfo merchant_info;
    public OrderInfo order_info;
    public String pay_source;
    public ArrayList<TypeItems> pay_type_items;
    public int show_num;
    public ArrayList<String> sorted_ptcodes;
    public String support_asset_standard;
    public String trace_id;
    public TradeInfo trade_info;

    public static class OrderInfo implements CJPayObject {
        public String trade_amount;

        public OrderInfo() {
        }
    }

    public boolean hasDefaultPtCode() {
        return !TextUtils.isEmpty(this.default_ptcode);
    }

    public boolean isAssetStd() {
        return TextUtils.equals("1", this.support_asset_standard);
    }

    public boolean isSignAndPay() {
        return IntegratedOuterPayRooter.INTEGRATED_SIGN_AND_PAY.equals(this.pay_source);
    }

    public PayComponentBean() {
        this.support_asset_standard = "";
        this.default_ptcode = "";
        this.pay_type_items = new ArrayList();
        this.sorted_ptcodes = new ArrayList();
        this.cashdesk_show_conf = new CashDeskShowConf();
        this.trade_info = new TradeInfo();
        this.merchant_info = new MerchantInfo();
        this.fe_metrics = new JSONObject();
        this.exts = new IntegratedCounterResponseData.Exts();
        this.trace_id = "";
        this.jh_pass_through = "";
        this.order_info = new OrderInfo();
    }

    public IPayTypeConfig<? extends IPayType, ? extends IDYPayType, ? extends IPayTypeChangeInfo> buildDefaultPayTypeConfig() {
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PayComponentBean#hasDefaultPtCode", e);
        CJLogger.c("PayComponentBean", "buildDefaultConfig", e);
        return null;
    L3:
        if (isAssetStd() == false) goto L7;
        return new StdPayTypeConfig().buildDefaultConfig(this);
    L7:
        return new PayTypeConfig().buildDefaultConfig(this);
    }
}
