package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupContentsBean;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayBusiAuthorizeInfo implements CJPayObject, Serializable {
    public String authType;
    public CJPayAuthInfo busi_auth_info;
    public CJPayBusiAuthorizeContent busi_authorize_content;
    public String conflict_action_url;
    public int hasPass;
    public int isOneStep;
    public boolean is_authed;
    public boolean is_conflict;
    public boolean is_need_authorize;
    public int needIdentify;
    public CJPayProtocolGroupContentsBean protocol_group_contents;
    public int showOneStep;
    public String uidMobileMask;

    public CJPayBusiAuthorizeInfo() {
        this.is_need_authorize = false;
        this.is_authed = false;
        this.is_conflict = false;
        this.conflict_action_url = "";
        this.busi_auth_info = new CJPayAuthInfo();
        this.busi_authorize_content = new CJPayBusiAuthorizeContent();
        this.protocol_group_contents = new CJPayProtocolGroupContentsBean();
        this.uidMobileMask = "";
        this.needIdentify = 1;
        this.hasPass = 0;
        this.showOneStep = 1;
        this.isOneStep = 0;
        this.authType = "";
    }
}
