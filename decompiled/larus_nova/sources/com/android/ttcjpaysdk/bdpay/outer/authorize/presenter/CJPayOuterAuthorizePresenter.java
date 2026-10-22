package com.android.ttcjpaysdk.bdpay.outer.authorize.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.bdpay.outer.authorize.model.CJPayOuterAuthorizeModel;
import com.android.ttcjpaysdk.bdpay.outer.authorize.view.CJPayOuterAuthorizeView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u001a\u0010\n\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/outer/authorize/presenter/CJPayOuterAuthorizePresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/bdpay/outer/authorize/model/CJPayOuterAuthorizeModel;", "Lcom/android/ttcjpaysdk/bdpay/outer/authorize/view/CJPayOuterAuthorizeView;", "()V", "bindBytePay", "", "params", "", "", "fetchAuthProtocol", "bdpay-outer-authorize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOuterAuthorizePresenter extends BasePresenter<CJPayOuterAuthorizeModel, CJPayOuterAuthorizeView> {
    public CJPayOuterAuthorizePresenter() {
    }

    public final void bindBytePay(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        CJPayOuterAuthorizeModel r101 = getModel();
        if (r101 == null) goto L6;
        r101.bindBytePay(r100, new AnonymousClass1(this));
        return;
    }

    public final void fetchAuthProtocol(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        CJPayOuterAuthorizeModel r101 = getModel();
        if (r101 == null) goto L6;
        r101.fetchAuthProtocol(r100, new C90811(this));
        return;
    }
}
