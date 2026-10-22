package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.ResultPageInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class TradeQueryBean implements CJPayObject {
    public String code;
    public CJPayTradeQueryData data;
    public String err_msg;
    public String err_type;
    public String err_type_cnt;
    public String process;

    public static class BytePayResultInfo implements CJPayObject, Serializable {
        public BioOpenGuide bio_open_guide;

        public BytePayResultInfo() {
            this.bio_open_guide = new BioOpenGuide();
        }
    }

    public static class CJPayTradeQueryData implements CJPayObject, Serializable {
        public BytePayResultInfo byte_pay_result_info;
        public String common_result_info;
        public ArrayList<PayInfo> payment_desc_infos;
        public ResultPageInfo result_page_info;
        public String return_scheme;
        public String return_url;
        public TradeInfo trade_info;

        public CJPayTradeQueryData() {
            this.trade_info = new TradeInfo();
            this.payment_desc_infos = new ArrayList();
            this.byte_pay_result_info = new BytePayResultInfo();
            this.return_url = "";
            this.return_scheme = "";
            this.common_result_info = "";
        }
    }

    public static class PayInfo implements CJPayObject, Serializable {
        public String color_type;
        public String desc;
        public String icon;
        public String name;
        public String type_mark;

        public PayInfo() {
        }
    }

    public TradeQueryBean() {
        this.code = "";
        this.err_type = "";
        this.err_msg = "";
        this.err_type_cnt = "";
        this.process = "";
        this.data = new CJPayTradeQueryData();
    }
}
