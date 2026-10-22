package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayResultGuideInfo implements CJPayObject, Serializable {
    public String after_open_desc;
    public String bio_type;
    public String bubble_text;
    public String cancel_btn_desc;
    public String cancel_btn_location;
    public String confirm_btn_desc;
    public FingerInfo finger_info;
    public String guide_message;
    public String guide_show_style;
    public String guide_type;
    public String header_desc;
    public String header_pic_url;
    public boolean is_button_flick;
    public String jump_lynx_url;
    public String pic_url;
    public transient JSONObject protocol_group_names;
    public ArrayList<CJPayCardProtocolBean> protocol_list;
    public int quota;
    public String sub_title;
    public String sub_title_color;
    public String sub_title_icon_url;
    public String title;
    public String voucher_amount;
    public String voucher_display_text;

    public int getPswdQuota() {
        int r100 = this.quota;
        if (r100 > 0) goto L5;
        return 0;
    L5:
        return r100 / 100;
    }

    public CJPayResultGuideInfo() {
        this.guide_type = "";
        this.header_desc = "";
        this.title = "";
        this.sub_title = "";
        this.sub_title_icon_url = "";
        this.sub_title_color = "";
        this.confirm_btn_desc = "";
        this.is_button_flick = false;
        this.cancel_btn_desc = "";
        this.cancel_btn_location = "";
        this.protocol_list = new ArrayList();
        this.guide_message = "";
        this.pic_url = "";
        this.voucher_amount = "";
        this.voucher_display_text = "";
        this.bio_type = "";
        this.after_open_desc = "";
        this.guide_show_style = "";
        this.header_pic_url = "";
        this.bubble_text = "";
        this.finger_info = new FingerInfo();
        this.jump_lynx_url = "";
    }
}
