package com.android.ttcjpaysdk.thirdparty.counter.result.fragment;

import android.os.Bundle;
import android.view.View;
import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseFragment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayMaskFragment extends CJPayBaseFragment {
    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public int getContentViewLayoutId() {
        return R.layout.cj_pay_fragment_mask_layout;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public String getFragmentName() {
        return "结果页蒙层";
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initActions(View r100) {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initData() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initViews(View r100, Bundle r101) {
    }

    public CJPayMaskFragment() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void bindViews(View r100) {
        r100.setOnClickListener(new AnonymousClass1(this));
    }
}
