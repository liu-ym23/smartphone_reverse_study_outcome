package com.android.ttcjpaysdk.verify.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.verify.contract.DyVerifyMvpView;
import com.android.ttcjpaysdk.verify.data.DyVerifyToken;
import com.android.ttcjpaysdk.verify.model.DyVerifyModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/verify/presenter/DyVerifyPwdPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/verify/model/DyVerifyModel;", "Lcom/android/ttcjpaysdk/verify/contract/DyVerifyMvpView;", "()V", "verifyPassword", "", "password", "", "verifyToken", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyToken;", "isDegradeInvoke", "", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyPwdPresenter extends BasePresenter<DyVerifyModel, DyVerifyMvpView> {
    public DyVerifyPwdPresenter() {
    }

    public final void verifyPassword(String r100, DyVerifyToken r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "password");
        DyVerifyModel r103 = getModel();
        if (r103 == null) goto L6;
        r103.verifyPassword(r100, r101, new AnonymousClass1(this), r102);
        return;
    }

    public static /* synthetic */ void verifyPassword$default(DyVerifyPwdPresenter r100, String r101, DyVerifyToken r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.verifyPassword(r101, r102, r103);
    }
}
