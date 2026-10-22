package com.android.ttcjpaysdk.verify.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.verify.contract.DyVerifySmsView;
import com.android.ttcjpaysdk.verify.data.DyVerifyToken;
import com.android.ttcjpaysdk.verify.model.DyVerifyModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/presenter/DyVerifySmsPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/verify/model/DyVerifyModel;", "Lcom/android/ttcjpaysdk/verify/contract/DyVerifySmsView;", "()V", "sendSmsCode", "", "verifyToken", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyToken;", "verifySms", "sms", "", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifySmsPresenter extends BasePresenter<DyVerifyModel, DyVerifySmsView> {
    public DyVerifySmsPresenter() {
    }

    public final void sendSmsCode(DyVerifyToken r100) {
        DyVerifyModel r101 = getModel();
        if (r101 == null) goto L6;
        r101.sendSmsCode(r100, new AnonymousClass1(this));
        return;
    }

    public final void verifySms(String r100, DyVerifyToken r101) {
        DyVerifyModel r102 = getModel();
        if (r102 == null) goto L6;
        r102.verifySmsCode(r100, r101, new C97421(this));
        return;
    }
}
