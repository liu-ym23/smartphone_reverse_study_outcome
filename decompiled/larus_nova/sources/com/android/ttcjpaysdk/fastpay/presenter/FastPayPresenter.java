package com.android.ttcjpaysdk.fastpay.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayResponseBean;
import com.android.ttcjpaysdk.fastpay.model.FastPayModel;
import com.android.ttcjpaysdk.fastpay.view.FastPayView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\tJ(\u0010\u000b\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/presenter/FastPayPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/fastpay/model/FastPayModel;", "Lcom/android/ttcjpaysdk/fastpay/view/FastPayView;", "()V", "fastPay", "", "params", "", "", "ptcode", "query", "responseBean", "Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayResponseBean;", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FastPayPresenter extends BasePresenter<FastPayModel, FastPayView> {
    public FastPayPresenter() {
    }

    public final void fastPay(Map<String, String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "ptcode");
        FastPayModel r102 = getModel();
        if (r102 == null) goto L6;
        r102.fetchFastPayData(r100, r101, new AnonymousClass1(this), new AnonymousClass2());
        return;
    }

    public final void query(Map<String, String> r100, FastPayResponseBean r101) {
        FastPayModel r102 = getModel();
        if (r102 == null) goto L6;
        r102.fetchTradeQueryData(r100, r101, new C91801(this));
        return;
    }
}
