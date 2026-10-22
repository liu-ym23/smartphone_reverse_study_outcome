package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.integrated.counter.outerpay.IntegratedOuterPayRooter;
import com.android.ttcjpaysdk.thirdparty.data.CJPayMerchantInfo;
import com.android.ttcjpaysdk.thirdparty.data.CashDeskShowConf;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class IntegratedCounterResponseData implements CJPayObject {
    public CJPayButtonInfo button_info;
    public CashDeskShowConf cashdesk_show_conf;
    public String default_ptcode;
    public DivideButtonInfo divide_button_info;
    public Exts exts;
    public Map<String, String> exts_pb;
    public JSONObject fe_metrics;
    public Map<String, String> fe_metrics_pb;
    public String jh_pass_through;
    public CJPayMerchantInfo merchant_info;
    public String pay_source;
    public ArrayList<TypeItems> paytype_items;
    public int show_num;
    public ArrayList<String> sorted_ptcodes;
    public String support_asset_standard;
    public TradeInfo trade_info;
    public UnifyCashierRenderInfo unify_cashier_render_info;

    public static class DivideButtonInfo implements CJPayObject {
        public DataMap data_map;
        public Map<String, String> data_map_pb;
        public String style_code;

        public static class DataMap implements CJPayObject {
            public String amount_msg;
            public String background_picture_url;
            public String button_action;
            public String button_label;
            public String sub_pay_type_index;

            public DataMap() {
                this.amount_msg = "";
                this.background_picture_url = "";
                this.button_action = "";
                this.button_label = "";
                this.sub_pay_type_index = "";
            }
        }

        public void afterProtoDecode() {
            Map<String, String> r100 = this.data_map_pb;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.get("amount_msg") == null) goto L8;
            DataMap r101 = this.data_map;
            r101.amount_msg = this.data_map_pb.get("amount_msg");
        L8:
            if (this.data_map_pb.get("background_picture_url") == null) goto L11;
            DataMap r102 = this.data_map;
            r102.background_picture_url = this.data_map_pb.get("background_picture_url");
        L11:
            if (this.data_map_pb.get("button_action") == null) goto L14;
            DataMap r103 = this.data_map;
            r103.button_action = this.data_map_pb.get("button_action");
        L14:
            if (this.data_map_pb.get("button_label") == null) goto L17;
            DataMap r104 = this.data_map;
            r104.button_label = this.data_map_pb.get("button_label");
        L17:
            if (this.data_map_pb.get("sub_pay_type_index") == null) goto L19;
            DataMap r105 = this.data_map;
            r105.sub_pay_type_index = this.data_map_pb.get("sub_pay_type_index");
        L19:
            this.data_map_pb = null;
        }

        public DivideButtonInfo() {
            this.data_map = new DataMap();
            this.data_map_pb = null;
            this.style_code = "default";
        }
    }

    public static class Exts implements CJPayObject {
        public String toast;
        public String unify_cashier;

        public Exts() {
            this.toast = "";
            this.unify_cashier = "";
        }
    }

    public void afterProtoDecode() {
        if (this.fe_metrics_pb == null) goto L5;
        this.fe_metrics = new JSONObject(this.fe_metrics_pb);
        this.fe_metrics_pb = null;
    L5:
        Map<String, String> r100 = this.exts_pb;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.containsKey("toast") == false) goto L11;
        Exts r101 = this.exts;
        r101.toast = this.exts_pb.get("toast");
    L11:
        if (this.exts_pb.containsKey("unify_cashier") == false) goto L13;
        Exts r102 = this.exts;
        r102.unify_cashier = this.exts_pb.get("unify_cashier");
    L13:
        this.exts_pb = null;
    }

    public boolean isShowDivideButton() {
        DivideButtonInfo r100 = this.divide_button_info;
        if (r100 == null) goto L10;
        DivideButtonInfo.DataMap r101 = r100.data_map;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r101.button_label) == true) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public boolean isSignAndPay() {
        return IntegratedOuterPayRooter.INTEGRATED_SIGN_AND_PAY.equals(this.pay_source);
    }

    public IntegratedCounterResponseData() {
        this.default_ptcode = "";
        this.paytype_items = new ArrayList();
        this.sorted_ptcodes = new ArrayList();
        this.cashdesk_show_conf = new CashDeskShowConf();
        this.trade_info = new TradeInfo();
        this.merchant_info = new CJPayMerchantInfo();
        this.fe_metrics = new JSONObject();
        this.fe_metrics_pb = null;
        this.unify_cashier_render_info = new UnifyCashierRenderInfo();
        this.button_info = new CJPayButtonInfo();
        this.exts = new Exts();
        this.exts_pb = null;
        this.divide_button_info = new DivideButtonInfo();
        this.support_asset_standard = "";
    }
}
