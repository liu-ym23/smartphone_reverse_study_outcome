package com.android.ttcjpaysdk.bdpay.sign.presenter;

import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.bdpay.sign.model.SignModel;
import com.android.ttcjpaysdk.bdpay.sign.view.ISignOnlyView;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/presenter/SignOnlyPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/bdpay/sign/model/SignModel;", "Lcom/android/ttcjpaysdk/bdpay/sign/view/ISignOnlyView;", "()V", "bindBytePayWithoutPwd", "", "appId", "", "merchantId", "bizNo", "querySignInfo", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignOnlyPresenter extends BasePresenter<SignModel, ISignOnlyView> {
    public SignOnlyPresenter() {
    }

    public final void bindBytePayWithoutPwd(String r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "merchantId");
        Intrinsics.checkNotNullParameter(r110, "bizNo");
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "member_biz_order_no", r110);
        KtSafeMethodExtensionKt.safePut(r102, "verify_type", "password");
        KtSafeMethodExtensionKt.safePut(r102, "password", "");
        CJPaySecureRequestParams r111 = new CJPaySecureRequestParams();
        r111.fields.add("password");
        KtSafeMethodExtensionKt.safePut(r102, DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r111.toJson(CJEncryptScene.UNKNOWN));
        SignModel r103 = getModel();
        if (r103 == null) goto L6;
        r103.request("bytepay.member_product.bind_byte_pay_account", r102, r100, r101, new AnonymousClass1(this));
        return;
    }

    public final void querySignInfo(String r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "merchantId");
        Intrinsics.checkNotNullParameter(r110, "bizNo");
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "member_biz_order_no", r110);
        SignModel r103 = getModel();
        if (r103 == null) goto L6;
        r103.request("bytepay.member_product.query_sign_template", r102, r100, r101, new C91071(this));
        return;
    }
}
