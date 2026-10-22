package com.android.ttcjpaysdk.thirdparty.front.counter.directbank.presenter;

import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.thirdparty.front.counter.directbank.model.DirectBankModel;
import com.android.ttcjpaysdk.thirdparty.front.counter.directbank.view.DirectBankView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004JB\u0010\u0005\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/directbank/presenter/CJPayDirectBankPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/directbank/model/DirectBankModel;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/directbank/view/DirectBankView;", "()V", "tradeQueryByVerifyFace", "", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "merchantId", "appId", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDirectBankPresenter extends BasePresenter<DirectBankModel, DirectBankView> {
    public CJPayDirectBankPresenter() {
    }

    public final void tradeQueryByVerifyFace(HashMap<String, Object> r100, String r101, String r110, CJPayHostInfo r111) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "merchantId");
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r111, "hostInfo");
        DirectBankModel r102 = getModel();
        if (r102 == null) goto L6;
        r102.tradeQueryByVerifyFace(r100, r101, r110, r111, new AnonymousClass1(this));
        return;
    }
}
