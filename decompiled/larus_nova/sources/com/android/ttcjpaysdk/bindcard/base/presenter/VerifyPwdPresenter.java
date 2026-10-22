package com.android.ttcjpaysdk.bindcard.base.presenter;

import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bindcard.base.BindCardBaseContract;
import com.android.ttcjpaysdk.bindcard.base.BindCardBaseModel;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/presenter/VerifyPwdPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/bindcard/base/BindCardBaseModel;", "Lcom/android/ttcjpaysdk/bindcard/base/BindCardBaseContract$VerifyPwdView;", "()V", "verifyPwd", "", "smchId", "", "signOrderNo", "password", "encryptScene", "Lcom/android/ttcjpaysdk/base/encrypt/CJEncryptScene;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyPwdPresenter extends BasePresenter<BindCardBaseModel, BindCardBaseContract.VerifyPwdView> {
    public VerifyPwdPresenter() {
    }

    public final void verifyPwd(String r100, String r101, String r102, CJEncryptScene r103) {
        Intrinsics.checkNotNullParameter(r100, "smchId");
        Intrinsics.checkNotNullParameter(r101, "signOrderNo");
        Intrinsics.checkNotNullParameter(r102, "password");
        Intrinsics.checkNotNullParameter(r103, "encryptScene");
        JSONObject r104 = new JSONObject();
        r104.put(DyVerifyReqConstants.Key.SMCH_ID, r100);     // Catch: JSONException -> L5
        r104.put("sign_order_no", r101);     // Catch: JSONException -> L5
        r104.put("password", r102);     // Catch: JSONException -> L5
        CJPaySecureRequestParams r105 = new CJPaySecureRequestParams();     // Catch: JSONException -> L5
        r105.fields.add("password");     // Catch: JSONException -> L5
        r104.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r105.toJson(r103));     // Catch: JSONException -> L5
    L7:
        BindCardBaseModel r106 = getModel();
        if (r106 == null) goto L13;
        r106.verifyPasswod(r104, new AnonymousClass1(this));
        return;
    L13:
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyPwdPresenter#verifyPwd", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyPwdPresenter#verifyPwd", e);
        goto L7
    }
}
