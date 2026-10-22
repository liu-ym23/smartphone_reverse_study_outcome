package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayFaceVerifyInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class CJPaySmsTokenBean extends CJPayBindCardBaseBean {
    public CJPayButtonInfo button_info;
    public ArrayList<CJPayCardProtocolBean> card_protocol_list;
    public CJPayFaceVerifyInfo face_verify_info;
    public String mobile_mask;
    public String sms_token;
    public String verify_text_msg;

    public CJPaySmsTokenBean() {
        this.sms_token = "";
        this.button_info = new CJPayButtonInfo();
        this.verify_text_msg = "";
        this.mobile_mask = "";
        this.face_verify_info = new CJPayFaceVerifyInfo();
        this.card_protocol_list = new ArrayList();
    }
}
