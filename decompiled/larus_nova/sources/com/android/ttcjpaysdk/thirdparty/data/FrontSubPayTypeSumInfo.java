package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class FrontSubPayTypeSumInfo implements CJPayObject, Serializable {
    public FreqSuggestStyleInfo freq_suggest_style_info;
    public HomePageBanner home_page_banner;
    public String home_page_guide_text;
    public String home_page_show_style;
    public int show_num;
    public ArrayList<FrontSubPayTypeInfo> sub_pay_type_info_list;
    public String sub_pay_type_page_subtitle;
    public CJPayVoucherInfo voucher_info;
    public ArrayList<String> voucher_msg_list;
    public ZoneSplitInfo zone_split_info;

    public static class HomePageBanner implements CJPayObject, Serializable {
        public String banner_text;
        public String btn_action;
        public String btn_text;
        public String theme_color;

        public HomePageBanner() {
            this.banner_text = "";
            this.btn_text = "";
            this.btn_action = "";
            this.theme_color = "";
        }
    }

    public static class ZoneSplitInfo implements CJPayObject, Serializable {
        public FrontSubPayTypeInfo other_card_info;
        public int zone_index;
        public String zone_title;

        public ZoneSplitInfo() {
            this.zone_title = "";
            this.other_card_info = new FrontSubPayTypeInfo();
        }
    }

    public boolean isFreqSuggest() {
        return "freq_suggest".equals(this.home_page_show_style);
    }

    public FrontSubPayTypeSumInfo() {
        this.voucher_msg_list = new ArrayList();
        this.voucher_info = new CJPayVoucherInfo();
        this.sub_pay_type_info_list = new ArrayList();
        this.home_page_show_style = "";
        this.home_page_guide_text = "";
        this.home_page_banner = new HomePageBanner();
        this.sub_pay_type_page_subtitle = "";
        this.freq_suggest_style_info = new FreqSuggestStyleInfo();
    }
}
