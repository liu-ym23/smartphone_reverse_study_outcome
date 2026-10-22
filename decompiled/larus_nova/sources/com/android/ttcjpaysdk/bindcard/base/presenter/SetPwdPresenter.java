package com.android.ttcjpaysdk.bindcard.base.presenter;

import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bindcard.base.BindCardBaseContract;
import com.android.ttcjpaysdk.bindcard.base.BindCardBaseModel;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/presenter/SetPwdPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/bindcard/base/BindCardBaseModel;", "Lcom/android/ttcjpaysdk/bindcard/base/BindCardBaseContract$SetPwdView;", "()V", "setPassword", "", DyVerifyReqConstants.Key.SMCH_ID, "", "sign_order_no", "password", "password_confirm", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetPwdPresenter extends BasePresenter<BindCardBaseModel, BindCardBaseContract.SetPwdView> {
    public SetPwdPresenter() {
    }

    public final void setPassword(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put(DyVerifyReqConstants.Key.SMCH_ID, r100);     // Catch: JSONException -> L17
        r104.put("sign_order_no", r101);     // Catch: JSONException -> L17
        r104.put("password", r102);     // Catch: JSONException -> L17
        r104.put("password_confirm", r103);     // Catch: JSONException -> L17
        CJPaySecureRequestParams r105 = new CJPaySecureRequestParams();     // Catch: JSONException -> L17
        r105.fields.add("password");     // Catch: JSONException -> L17
        boolean r106 = false;
        if (r103 != null) goto L6;
        Boolean r107 = null;
    L11:
        if (r107 == null) goto L13;
        r106 = r107.booleanValue();     // Catch: JSONException -> L17
    L13:
        if (r106 == false) goto L15;
        r105.fields.add("password_confirm");     // Catch: JSONException -> L17
    L15:
        r104.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r105.toJson(CJEncryptScene.UNKNOWN));     // Catch: JSONException -> L17
    L19:
        BindCardBaseModel r108 = getModel();
        if (r108 == null) goto L25;
        r108.setPassword(r104, new AnonymousClass1(this));
        return;
    L25:
        return;
    L6:
        if (r103.length() <= 0) goto L8;
        boolean r109 = true;
    L9:
        r107 = Boolean.valueOf(r109);     // Catch: JSONException -> L17
        goto L11
    L8:
        r109 = false;
    L17:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SetPwdPresenter#setPassword", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SetPwdPresenter#setPassword", e);
        goto L19
    }
}
