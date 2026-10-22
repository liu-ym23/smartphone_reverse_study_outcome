package com.android.ttcjpaysdk.thirdparty.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupContentsBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayResultGuideInfo;
import com.android.ttcjpaysdk.base.ui.data.ResultPageInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayBioOpenGuide;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeQueryResponseBean;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberOrientationPage$Param$From;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCounterTradeQueryResponseBean extends CJPayTradeQueryResponseBean {
    public CJPayBioOpenGuide bio_open_guide;
    public String common_result_page;
    public ArrayList<ContentInfo> content_list;
    public FeGuideInfo fe_guide_info;
    public CJPayProtocolGroupContentsBean nopwd_guide_info;
    public String nopwd_open_msg;
    public boolean nopwd_open_status;
    public FastPayGuideInfo onekeypay_guide_info;
    public ProcessingGuideBean processing_guide_popup;
    public String recommend_open_msg;
    public boolean recommend_open_status;
    public CJPayResultGuideInfo result_guide_info;
    public ResultPageInfo result_page_info;
    public String return_scheme;
    public String return_url;
    public CJPayTradeInfo trade_info;
    public String user_check_way;

    public static class ContentInfo implements CJPayObject, Serializable {
        public String icon_url;
        public String sub_content;
        public String sub_title;

        public ContentInfo() {
            this.sub_title = "";
            this.sub_content = "";
            this.icon_url = "";
        }
    }

    public boolean isNewPwdFreeAmountUpgradeGuide() {
        return TextUtils.equals(this.result_guide_info.guide_type, InvRouter$InviteMemberOrientationPage$Param$From.UPGRADE);
    }

    public CJPayCounterTradeQueryResponseBean() {
        this.trade_info = new CJPayTradeInfo();
        this.bio_open_guide = new CJPayBioOpenGuide();
        this.nopwd_guide_info = new CJPayProtocolGroupContentsBean();
        this.result_guide_info = new CJPayResultGuideInfo();
        this.nopwd_open_status = false;
        this.nopwd_open_msg = "";
        this.onekeypay_guide_info = new FastPayGuideInfo();
        this.processing_guide_popup = new ProcessingGuideBean();
        this.fe_guide_info = new FeGuideInfo();
        this.recommend_open_status = false;
        this.recommend_open_msg = "";
        this.user_check_way = "";
        this.common_result_page = "";
        this.return_url = "";
        this.return_scheme = "";
    }
}
