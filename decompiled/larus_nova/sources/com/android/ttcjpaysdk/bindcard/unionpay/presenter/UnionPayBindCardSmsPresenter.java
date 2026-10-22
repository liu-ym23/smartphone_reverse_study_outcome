package com.android.ttcjpaysdk.bindcard.unionpay.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayRealNameBean;
import com.android.ttcjpaysdk.bindcard.unionpay.model.UnionPayBindModel;
import com.android.ttcjpaysdk.bindcard.unionpay.view.UnionPayBindContract;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/presenter/UnionPayBindCardSmsPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/model/UnionPayBindModel;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/view/UnionPayBindContract$UnionPaySmsBindCardView;", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "view", "(Lcom/android/ttcjpaysdk/bindcard/unionpay/model/UnionPayBindModel;Lcom/android/ttcjpaysdk/bindcard/unionpay/view/UnionPayBindContract$UnionPaySmsBindCardView;)V", "unionCreateBizOrder", "", "unionSendSignSms", "realNameBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayRealNameBean;", "bankCardId", "", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayBindCardSmsPresenter extends BasePresenter<UnionPayBindModel, UnionPayBindContract.UnionPaySmsBindCardView> {
    public final void unionCreateBizOrder() {
        UnionPayBindModel r100 = getModel();
        if (r100 == null) goto L6;
        r100.unionCreateBizOrder(new AnonymousClass1(this));
        return;
    }

    public UnionPayBindCardSmsPresenter() {
    }

    public UnionPayBindCardSmsPresenter(UnionPayBindModel r100, UnionPayBindContract.UnionPaySmsBindCardView r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r100, r101);
    }

    public final void unionSendSignSms(final CJPayRealNameBean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "bankCardId");
        UnionPayBindModel r102 = getModel();
        if (r102 == null) goto L6;
        r102.sendSMSForUnionPayBindCard(r100, new C91361(this, r100), r101);
        return;
    }
}
