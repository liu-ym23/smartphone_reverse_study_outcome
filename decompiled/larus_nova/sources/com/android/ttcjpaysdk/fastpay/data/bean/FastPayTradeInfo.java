package com.android.ttcjpaysdk.fastpay.data.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class FastPayTradeInfo implements CJPayObject {
    public long amount;
    public String amount_can_change;
    public long create_time;
    public String currency;
    public String douyin_trade_info;
    public DouyinTradeInfo douyin_trade_info_struct;
    public long expire_time;
    public String ext_uid;
    public String merchant_id;
    public String out_trade_no;
    public long pay_amount;
    public long pay_time;
    public String pay_trade_no;
    public String pay_type;
    public String ptcode;
    public long real_amount;
    public long reduce_amount;
    public String return_url;
    public StateInfo stat_info;
    public String status;
    public long trade_amount;
    public String trade_desc;
    public String trade_name;
    public String trade_no;
    public String trade_status;
    public String trade_status_desc_msg;
    public long trade_time;
    public String trade_type;
    public String uid;

    public static class DirectPayShowConf implements CJPayObject {
        public long remain_time_s;

        public DirectPayShowConf() {
            this.remain_time_s = -1;
        }
    }

    public static class DouyinTradeInfo implements CJPayObject {
        public String half_screen_desc;
        public String pay_type_show_name;
        public long real_amount;
        public long reduce_amount;
        public long remain_time_s;

        public DouyinTradeInfo() {
            this.pay_type_show_name = "";
            this.half_screen_desc = "";
            this.real_amount = 0;
            this.reduce_amount = 0;
            this.remain_time_s = -1;
        }
    }

    public static class StateInfo implements CJPayObject {
        public int scene;

        public StateInfo() {
            this.scene = -1;
        }
    }

    public FastPayTradeInfo() {
        this.create_time = 0;
        this.expire_time = 0;
        this.out_trade_no = "";
        this.return_url = "";
        this.trade_amount = 0;
        this.reduce_amount = 0;
        this.trade_desc = "";
        this.trade_name = "";
        this.trade_no = "";
        this.trade_status = "";
        this.trade_time = 0;
        this.trade_type = "";
        this.pay_amount = 0;
        this.amount_can_change = "";
        this.trade_status_desc_msg = "";
        this.amount = 0;
        this.real_amount = 0;
        this.ext_uid = "";
        this.merchant_id = "";
        this.pay_time = 0;
        this.pay_trade_no = "";
        this.pay_type = "";
        this.ptcode = "";
        this.status = "";
        this.uid = "";
        this.stat_info = new StateInfo();
        this.douyin_trade_info = "";
        this.douyin_trade_info_struct = new DouyinTradeInfo();
    }
}
