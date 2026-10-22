package com.android.ttcjpaysdk.thirdparty.data;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayGetVerifyInfoResponseBean implements CJPayObject {
    public String code;
    public CJPayFaceVerifyInfo face_verify_info;
    public String jump_url;
    public String msg;
    public String std_verify_tag;
    public String verify_id;
    public String verify_token;
    public String verify_type;

    public void fillFaceVerifyInfo() {
        CJPayFaceVerifyInfo r100 = this.face_verify_info;
        r100.std_verify_tag = this.std_verify_tag;
        r100.verify_id = this.verify_id;
        r100.verify_token = this.verify_token;
        r100.show_style = "1";
    }

    public CJPayGetVerifyInfoResponseBean() {
        this.code = "";
        this.msg = "";
        this.verify_type = "";
        this.jump_url = "";
        this.face_verify_info = new CJPayFaceVerifyInfo();
        this.std_verify_tag = "";
        this.verify_id = "";
        this.verify_token = "";
    }

    public void logActiveFaceInvoke(CJPayFaceVerifyInfo r100, String r101, String r102, String r103) {
    L43:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayGetVerifyInfoResponseBean#logActiveFaceInvoke", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayGetVerifyInfoResponseBean#logActiveFaceInvoke", th);
        return;
    L3:
        String r104 = "";
        if (CJPayCallBackCenter.getInstance() != null) goto L6;
    L8:
        String r105 = CJPayCallBackCenter.getInstance().getTraceId();     // Catch: Throwable -> L43
    L9:
        JSONObject r106 = CJPayParamsUtils.getCommonLogParams(r101, r102);     // Catch: Throwable -> L43
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        r106.put(b.B0, r103);     // Catch: Throwable -> L43
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        r106.put(BindCardPayConfirmConstants.Key.TRACE_ID, r105);     // Catch: Throwable -> L43
        if (r100 != null) goto L18;
    L17:
        String r107 = "";
    L21:
        r106.put("std_verify_tag", r107);     // Catch: Throwable -> L43
        if (r100 != null) goto L24;
    L23:
        String r108 = "";
    L27:
        r106.put("verify_id", r108);     // Catch: Throwable -> L43
        if (r100 == null) goto L34;
        String r109 = r100.verify_token;     // Catch: Throwable -> L43
        if (r109 == null) goto L34;
        r104 = r109;
    L34:
        r106.put("verify_token", r104);     // Catch: Throwable -> L43
        String r110 = "0";
        if (r100 != null) goto L39;
    L41:
        r106.put("is_invoke_std_face", r110);     // Catch: Throwable -> L43
        CJPayCallBackCenter.getInstance().onEvent("wallet_active_face_invoke", new JSONObject[]{r106});     // Catch: Throwable -> L43
        return;
    L39:
        if (r100.hitStdForFace() == false) goto L41;
        r110 = "1";
        goto L41
    L24:
        r108 = r100.verify_id;     // Catch: Throwable -> L43
        if (r108 != null) goto L27;
    L18:
        r107 = r100.std_verify_tag;     // Catch: Throwable -> L43
        if (r107 != null) goto L21;
    L6:
        if (CJPayCallBackCenter.getInstance().getTrackInfo() == null) goto L8;
        r105 = CJPayCallBackCenter.getInstance().getTrackInfo().optString(BindCardPayConfirmConstants.Key.TRACE_ID, "");     // Catch: Throwable -> L43
        goto L9
    }
}
