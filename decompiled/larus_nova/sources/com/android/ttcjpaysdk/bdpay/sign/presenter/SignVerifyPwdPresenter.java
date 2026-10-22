package com.android.ttcjpaysdk.bdpay.sign.presenter;

import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.bdpay.sign.model.SignModel;
import com.android.ttcjpaysdk.bdpay.sign.view.ISignVerifyPwdView;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/presenter/SignVerifyPwdPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/bdpay/sign/model/SignModel;", "Lcom/android/ttcjpaysdk/bdpay/sign/view/ISignVerifyPwdView;", "()V", "bindBytePayAccount", "", "appId", "", "merchantId", "bizNo", "password", "verifyType", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignVerifyPwdPresenter extends BasePresenter<SignModel, ISignVerifyPwdView> {
    public SignVerifyPwdPresenter() {
    }

    public final void bindBytePayAccount(String r100, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r110, "merchantId");
        Intrinsics.checkNotNullParameter(r111, "bizNo");
        Intrinsics.checkNotNullParameter(r112, "password");
        Intrinsics.checkNotNullParameter(r113, "verifyType");
        JSONObject r101 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r101, "member_biz_order_no", r111);
        KtSafeMethodExtensionKt.safePut(r101, "verify_type", r113);
        KtSafeMethodExtensionKt.safePut(r101, "password", r112);
        CJPaySecureRequestParams r114 = new CJPaySecureRequestParams();
        r114.fields.add("password");
        KtSafeMethodExtensionKt.safePut(r101, DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r114.toJson(CJEncryptScene.UNKNOWN));
        SignModel r102 = getModel();
        if (r102 == null) goto L6;
        r102.request("bytepay.member_product.bind_byte_pay_account", r101, r100, r110, new AnonymousClass1(this));
        return;
    }

    public static /* synthetic */ void bindBytePayAccount$default(SignVerifyPwdPresenter r100, String r101, String r102, String r103, String r110, String r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = "password";
    L5:
        r100.bindBytePayAccount(r101, r102, r103, r110, r111);
    }
}
