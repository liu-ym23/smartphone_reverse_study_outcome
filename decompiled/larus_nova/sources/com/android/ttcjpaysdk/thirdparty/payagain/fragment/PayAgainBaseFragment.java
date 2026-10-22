package com.android.ttcjpaysdk.thirdparty.payagain.fragment;

import com.android.ttcjpaysdk.base.framework.AnimUtil;
import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/fragment/PayAgainBaseFragment;", "Lcom/android/ttcjpaysdk/thirdparty/base/CJPayBaseFragment;", "()V", "getAnimGroup", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$AnimGroup;", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PayAgainBaseFragment extends CJPayBaseFragment {
    public PayAgainBaseFragment() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment, com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public AnimUtil.AnimGroup getAnimGroup() {
        return AnimUtil.AnimGroup.PAY_AGAIN;
    }
}
