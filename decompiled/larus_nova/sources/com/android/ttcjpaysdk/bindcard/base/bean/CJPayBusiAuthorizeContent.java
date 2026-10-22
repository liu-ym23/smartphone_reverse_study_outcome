package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayBusiAuthorizeContent implements CJPayObject, Serializable {
    public CJPayBusinessBriefInfo business_brief_info;
    public String not_agreement_content;
    public String not_agreement_url;
    public ArrayList<String> propose_contents;
    public String propose_desc;
    public String tips_content;

    public CJPayBusiAuthorizeContent() {
        this.propose_desc = "";
        this.not_agreement_url = "";
        this.not_agreement_content = "";
        this.tips_content = "";
        this.propose_contents = new ArrayList();
        this.business_brief_info = new CJPayBusinessBriefInfo();
    }
}
