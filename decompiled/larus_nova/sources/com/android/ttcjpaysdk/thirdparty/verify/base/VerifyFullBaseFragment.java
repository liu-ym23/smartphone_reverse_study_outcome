package com.android.ttcjpaysdk.thirdparty.verify.base;

import android.view.View;
import com.android.ttcjpaysdk.thirdparty.view.CJPaySwipeBackLayout;

/* JADX INFO: loaded from: classes39.dex */
public abstract class VerifyFullBaseFragment extends VerifyBaseFragment {
    private OnSwipeFinishListener mOnSwipeFinishListener;
    private CJPaySwipeBackLayout mSwipeBackLayout;

    public interface OnSwipeFinishListener {
        void swipeFinish();

        void swipeStart();
    }

    public VerifyFullBaseFragment() {
    }

    public static /* synthetic */ OnSwipeFinishListener access$000(VerifyFullBaseFragment r100) {
        return r100.mOnSwipeFinishListener;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.verify.base.VerifyBaseFragment, com.android.ttcjpaysdk.base.framework.BaseFragment
    public View hookRootView(View r100) {
        setFullScreen();
        View r101 = super.hookRootView(r100);
        if (getActivity() != null) goto L5;
        return r101;
    L5:
        CJPaySwipeBackLayout r102 = new CJPaySwipeBackLayout(getActivity());
        this.mSwipeBackLayout = r102;
        r102.setOnSwipeFinishListener(new AnonymousClass1(this));
        this.mSwipeBackLayout.addView(r101);
        this.mSwipeBackLayout.setModel(2);
        return this.mSwipeBackLayout;
    }

    public void setEnableSwipe(boolean r100) {
        CJPaySwipeBackLayout r101 = this.mSwipeBackLayout;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        r101.setModel(2);
        return;
    L7:
        r101.setModel(-1);
    }

    public void setOnSwipeFinishListener(OnSwipeFinishListener r100) {
        this.mOnSwipeFinishListener = r100;
    }
}
