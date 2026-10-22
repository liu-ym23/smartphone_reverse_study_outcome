package com.android.ttcjpaysdk.thirdparty.counter.result.wrapper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.thirdparty.counter.data.CJPayCounterTradeQueryResponseBean;
import com.android.ttcjpaysdk.thirdparty.counter.data.QueryPromotionAfterPayInfo;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BaseCompleteWrapper extends BaseWrapper {
    public boolean isFromOuter;
    protected OnCompleteWrapperListener mOnCompleteWrapperListener;

    public interface OnCompleteWrapperListener {
        void onBackViewClick();

        void onPayStatusButtonClick(String r100);

        void setTimerStatus(int r100);
    }

    public View getPanelView() {
        return null;
    }

    public boolean hasCombine(CJPayCounterTradeQueryResponseBean r100) {
        return false;
    }

    public boolean hasContentList(CJPayCounterTradeQueryResponseBean r100) {
        return false;
    }

    public abstract void initActions();

    public boolean isAddPanelLayer() {
        return false;
    }

    public boolean isLynxComponentAction() {
        return false;
    }

    public boolean isNeedShowPromotionAfterPay() {
        return false;
    }

    public void release() {
    }

    public boolean tryShowPromotionDialog() {
        return false;
    }

    public void updatePromotionAfterPay(QueryPromotionAfterPayInfo r100, String r101, boolean r102, CJPayCounterTradeQueryResponseBean r103) {
    }

    public abstract void updateView(int r100, boolean r101, CJPayCounterTradeQueryResponseBean r102);

    public void setOnCompleteWrapperListener(OnCompleteWrapperListener r100) {
        this.mOnCompleteWrapperListener = r100;
    }

    public BaseCompleteWrapper(View r100, int r101) {
        super(r100);
        this.isFromOuter = false;
        LayoutInflater.from(getContext()).inflate(r101, (ViewGroup) r100);
    }
}
