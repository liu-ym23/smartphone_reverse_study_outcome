package com.android.ttcjpaysdk.base.ui.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberOrientationPage$Param$From;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayProtocolGroupContentsBean implements CJPayObject, Serializable {
    public String button_text;
    public String code;
    public String guide_message;
    public String guide_style;
    public String guide_type;
    public boolean is_checked;
    public boolean is_show_button;
    public String msg;
    public boolean need_guide;
    public String protocol_check_box;
    public transient JSONObject protocol_group_names;
    public ArrayList<CJPayCardProtocolBean> protocol_list;
    public int quota;
    public String secure_tip;
    public String status;
    public String style;
    public ArrayList<CJPaySubGuideDesc> sub_guide_desc;
    public String title;

    public ArrayList<CJPayProtocolGroupBean> getProtocolGroupBeanList() {
        ArrayList<CJPayProtocolGroupBean> r100 = new ArrayList();
        JSONObject r101 = this.protocol_group_names;
        if (r101 == null) goto L11;
        Iterator<String> r102 = r101.keys();
    L12:
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayProtocolGroupContentsBean#getProtocolGroupBeanList", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayProtocolGroupContentsBean#getProtocolGroupBeanList", e);
        goto L11
    L6:
        if (r102.hasNext() == false) goto L11;
        CJPayProtocolGroupBean r103 = new CJPayProtocolGroupBean();     // Catch: JSONException -> L9
        String r104 = r102.next();     // Catch: JSONException -> L9
        String r105 = JSONObjectProtectorUtils.getString(this.protocol_group_names, r104);     // Catch: JSONException -> L9
        r103.groupName = r104;     // Catch: JSONException -> L9
        r103.groupDesc = r105;     // Catch: JSONException -> L9
        r100.add(r103);     // Catch: JSONException -> L9
    L11:
        return r100;
    }

    public String getPswdGuideType() {
        if (this.need_guide == true) goto L5;
        return "";
    L5:
        if (InvRouter$InviteMemberOrientationPage$Param$From.UPGRADE.equals(this.guide_type) == false) goto L7;
        return "promote_quota";
    L7:
        return "open";
    }

    public int getPswdQuota() {
        int r100 = this.quota;
        if (r100 > 0) goto L5;
        return 0;
    L5:
        return r100 / 100;
    }

    public boolean isNeedCheckBox() {
        return "1".equals(this.protocol_check_box);
    }

    public boolean isResponseOK() {
        if (TextUtils.equals("MP000000", this.code) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.equals("CD000000", this.code) == true) goto L8;
        return false;
    }

    public CJPayProtocolGroupContentsBean() {
        this.status = "";
        this.code = "";
        this.msg = "";
        this.need_guide = false;
        this.is_checked = false;
        this.guide_message = "";
        this.title = "";
        this.secure_tip = "";
        this.button_text = "";
        this.is_show_button = false;
        this.protocol_list = new ArrayList();
        this.sub_guide_desc = new ArrayList();
        this.style = "";
        this.guide_type = "";
        this.guide_style = "";
        this.protocol_check_box = "1";
    }

    public ArrayList<JSONObject> getProtocolJsonListByGroup(String r100) {
        ArrayList<JSONObject> r101 = new ArrayList();
        ArrayList<CJPayCardProtocolBean> r102 = this.protocol_list;     // Catch: Exception -> L14
        if (r102 != null) goto L6;
    L16:
        return r101;
    L6:
        if (r102.size() <= 0) goto L16;
        int r103 = 0;
    L9:
        if (r103 >= this.protocol_list.size()) goto L16;
        if (r100.equals(((CJPayCardProtocolBean) ListProtector.get(this.protocol_list, r103)).group) == false) goto L13;
        r101.add(CJPayJsonParser.toJsonObject((CJPayCardProtocolBean) ListProtector.get(this.protocol_list, r103)));     // Catch: Exception -> L14
    L13:
        r103 = r103 + 1;
    L14:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayProtocolGroupContentsBean#getProtocolJsonListByGroup", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayProtocolGroupContentsBean#getProtocolJsonListByGroup", e);
        goto L16
    }

    public ArrayList<CJPayCardProtocolBean> getProtocolListByGroup(String r100) {
        ArrayList<CJPayCardProtocolBean> r101 = new ArrayList();
        ArrayList<CJPayCardProtocolBean> r102 = this.protocol_list;
        if (r102 != null) goto L5;
    L13:
        return r101;
    L5:
        if (r102.size() <= 0) goto L13;
        int r103 = 0;
    L8:
        if (r103 >= this.protocol_list.size()) goto L13;
        if (r100.equals(((CJPayCardProtocolBean) ListProtector.get(this.protocol_list, r103)).group) == false) goto L12;
        r101.add((CJPayCardProtocolBean) ListProtector.get(this.protocol_list, r103));
    L12:
        r103 = r103 + 1;
        goto L8
    }
}
