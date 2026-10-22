package com.android.ttcjpaysdk.bindcard.unionpay.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayRealNameBean;
import com.android.ttcjpaysdk.bindcard.unionpay.model.UnionPayBindModel;
import com.android.ttcjpaysdk.bindcard.unionpay.view.UnionPayBindContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/presenter/UnionPayBindCardPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/model/UnionPayBindModel;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/view/UnionPayBindContract$UnionPayBindCardView;", "()V", "sendSMSForUnionPayBindCard", "", "realNameBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayRealNameBean;", "unionPayBindCard", "params", "Lorg/json/JSONObject;", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayBindCardPresenter extends BasePresenter<UnionPayBindModel, UnionPayBindContract.UnionPayBindCardView> {
    public UnionPayBindCardPresenter() {
    }

    public final void sendSMSForUnionPayBindCard(final CJPayRealNameBean r100) {
        UnionPayBindModel r101 = getModel();
        if (r101 == null) goto L6;
        UnionPayBindModel.sendSMSForUnionPayBindCard$default(r101, r100, new AnonymousClass1(this, r100), null, 4, null);
        return;
    }

    public final void unionPayBindCard(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        UnionPayBindModel r101 = getModel();
        if (r101 == null) goto L6;
        r101.unionPayBindCard(r100, new C91351(this));
        return;
    }
}
