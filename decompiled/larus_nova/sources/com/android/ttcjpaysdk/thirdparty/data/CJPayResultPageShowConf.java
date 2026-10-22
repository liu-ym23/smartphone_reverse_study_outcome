package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayResultPageShowConf implements Serializable, CJPayObject {
    public String bg_image;
    public ShowInfo bottom_guide_info;
    public ArrayList<DiscountBanner> discount_banner;
    public CJPayMiddleBanner middle_banner;
    public int query_result_times;
    public int remain_time;
    public String result_desc;
    public boolean show_bottom_text;
    public int show_style;
    public String success_btn_desc;
    public String success_btn_position;
    public String success_desc;
    public String success_url;
    public int third_remain_time;
    public String tip_image;
    public String withdraw_result_page_desc;

    public static class DiscountBanner implements Serializable, CJPayObject {
        public String banner;
        public String goto_type;
        public String name;
        public int stay_time;
        public String url;

        public DiscountBanner() {
            this.name = "";
            this.banner = "";
            this.url = "";
            this.goto_type = "";
            this.stay_time = 0;
        }
    }

    public static class ShowInfo implements Serializable, CJPayObject {
        public String color;
        public String text;
        public String type;

        public ShowInfo() {
            this.type = "";
            this.text = "";
            this.color = "";
        }
    }

    public CJPayResultPageShowConf() {
        this.remain_time = 0;
        this.third_remain_time = 0;
        this.success_desc = "";
        this.success_url = "";
        this.success_btn_desc = "";
        this.discount_banner = new ArrayList();
        this.query_result_times = 0;
        this.show_style = 0;
        this.middle_banner = new CJPayMiddleBanner();
        this.withdraw_result_page_desc = "";
        this.result_desc = "";
        this.success_btn_position = "";
        this.bg_image = "";
        this.tip_image = "";
        this.show_bottom_text = true;
    }
}
