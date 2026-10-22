package com.android.ttcjpaysdk.thirdparty.counter.result.wrapper;

import android.view.View;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.thirdparty.counter.data.CJPayCounterTradeQueryResponseBean;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes39.dex */
public class CompleteDialogWrapper extends BaseCompleteWrapper {
    private LinearLayout mLoadingDialogRootView;

    @Override // com.android.ttcjpaysdk.thirdparty.counter.result.wrapper.BaseCompleteWrapper
    public void initActions() {
    }

    public CompleteDialogWrapper(View r100, int r101) {
        super(r100, r101);
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.cj_pay_view_payment_complete_dialog_root_view);
        this.mLoadingDialogRootView = r102;
        r102.setVisibility(0);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.counter.result.wrapper.BaseCompleteWrapper
    public void updateView(int r100, boolean r101, CJPayCounterTradeQueryResponseBean r102) {
        this.mLoadingDialogRootView.setVisibility(8);
    }
}
