package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.VoucherInfo;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class SubPayTypeSumInfo implements CJPayObject {
    public HomePageBanner byte_pay_banner;
    public Map<String, String> bytepay_voucher_msg_map;
    public ArrayList<Integer> card_style_index_list;
    public boolean has_voucher;
    public HomePageBanner home_page_banner;
    public HomePageFloatingBanner home_page_floating_banner;
    public String home_page_guide_action;
    public String home_page_guide_text;
    public boolean home_page_red_dot;
    public String home_page_show_style;
    public HomePageVoucher home_page_voucher;
    public String price_zone_show_style;
    public int show_num;
    public ArrayList<SubPayTypeInfo> sub_pay_type_info_list;
    public String sub_pay_type_page_subtitle;
    public boolean use_sub_pay_list_voucher_msg;
    public VoucherInfo voucher_info;
    public ArrayList<String> voucher_msg_list;
    public ZoneSplitInfo zone_split_info;

    public static class HomePageBanner implements CJPayObject {
        public String banner_text;
        public String btn_action;
        public String btn_text;
        public int sub_pay_type_index;
        public String theme_color;

        public boolean isSelectSubPayType() {
            return TextUtils.equals(this.btn_action, "select_paytype");
        }

        public boolean isSubPayTypeIndex() {
            if (this.sub_pay_type_index == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public HomePageBanner() {
            this.banner_text = "";
            this.btn_text = "";
            this.btn_action = "";
            this.theme_color = "";
            this.sub_pay_type_index = -1;
        }
    }

    public static class HomePageFloatingBanner implements CJPayObject {
        public String banner_text;
        public String btn_action;
        public String btn_text;
        public String icon_url;
        public String sub_pay_type_index;
        public String theme_color;
        public String voucher_text;

        public HomePageFloatingBanner() {
            this.banner_text = "";
            this.voucher_text = "";
            this.btn_text = "";
            this.btn_action = "";
            this.sub_pay_type_index = "";
            this.icon_url = "";
            this.theme_color = "";
        }
    }

    public static class HomePageVoucher implements CJPayObject {
        public String more_discount_voucher_text;
        public boolean show_more_discount;
        public String voucher_text;

        public HomePageVoucher() {
            this.show_more_discount = false;
            this.voucher_text = "";
            this.more_discount_voucher_text = "";
        }
    }

    public static class ZoneSplitInfo implements CJPayObject {
        public String combine_zone_title;
        public SubPayTypeInfo other_card_info;
        public int zone_index;
        public String zone_title;

        public ZoneSplitInfo() {
            this.zone_title = "";
            this.combine_zone_title = "";
            this.other_card_info = new SubPayTypeInfo();
        }
    }

    public boolean isCardShowType() {
        return TextUtils.equals(this.home_page_show_style, BrowserDependency.UrlClickType.CARD);
    }

    public boolean isOuterPay() {
        return TextUtils.equals(this.home_page_show_style, "standard");
    }

    public SubPayTypeSumInfo() {
        this.voucher_msg_list = new ArrayList();
        this.voucher_info = new VoucherInfo();
        this.sub_pay_type_info_list = new ArrayList();
        this.home_page_show_style = "";
        this.home_page_guide_text = "";
        this.home_page_guide_action = "more";
        this.home_page_red_dot = false;
        this.home_page_banner = new HomePageBanner();
        this.byte_pay_banner = new HomePageBanner();
        this.home_page_floating_banner = new HomePageFloatingBanner();
        this.sub_pay_type_page_subtitle = "";
        this.bytepay_voucher_msg_map = new HashMap();
        this.card_style_index_list = new ArrayList();
        this.has_voucher = false;
        this.price_zone_show_style = "";
        this.home_page_voucher = new HomePageVoucher();
    }
}
