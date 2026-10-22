package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.VoucherInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class QuickPay implements CJPayObject {
    public ArrayList<Card> cards;
    public ArrayList<Card> discount_banks;
    public String discount_bind_card_msg;
    public String enable_bind_card;
    public String enable_bind_card_msg;
    public String icon_url;
    public boolean is_hide_cards;
    public String mark;
    public String msg;
    public PromotionInfo promotion_info;
    public String status;
    public String sub_title;
    public String title;

    public static class PromotionInfo implements CJPayObject {
        public String card_banner;
        public String card_banner_button_flag;
        public String card_banner_button_label;
        public String card_label;
        public String channel_promotion_flag;
        public VoucherInfo plat_voucher_info;
        public String switch_bank_card_id;
        public VoucherInfo voucher_info;

        public PromotionInfo() {
            this.channel_promotion_flag = "";
            this.card_banner_button_label = "";
            this.card_banner_button_flag = "";
            this.switch_bank_card_id = "";
            this.card_label = "";
            this.card_banner = "";
            this.voucher_info = new VoucherInfo();
            this.plat_voucher_info = new VoucherInfo();
        }
    }

    public QuickPay() {
        this.cards = new ArrayList();
        this.discount_banks = new ArrayList();
        this.msg = "";
        this.status = "";
        this.mark = "";
        this.enable_bind_card = "";
        this.title = "";
        this.sub_title = "";
        this.icon_url = "";
        this.is_hide_cards = false;
        this.promotion_info = new PromotionInfo();
    }
}
