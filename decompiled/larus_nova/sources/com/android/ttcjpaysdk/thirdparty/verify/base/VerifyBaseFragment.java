package com.android.ttcjpaysdk.thirdparty.verify.base;

import android.view.View;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.framework.AnimUtil;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseFragment;

/* JADX INFO: loaded from: classes39.dex */
public abstract class VerifyBaseFragment extends CJPayBaseFragment {
    private int inAnim;
    private boolean isFullScreen;
    private int outAnim;

    public boolean getIsAllowCaptureScreen() {
        return true;
    }

    public void hideLoading() {
    }

    public boolean onBackPressed() {
        return true;
    }

    public void onInterceptOnBackPress() {
    }

    public void onTopBack(boolean r100) {
    }

    public void setFullScreen() {
        this.isFullScreen = true;
    }

    public void showLoading() {
    }

    public boolean whenBackPressedExit() {
        return true;
    }

    public VerifyBaseFragment() {
        this.inAnim = 1;
        this.outAnim = 1;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment, com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public AnimUtil.AnimGroup getAnimGroup() {
        return AnimUtil.AnimGroup.VERIFY;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public int getInAnim() {
        return this.inAnim;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public int getOutAnim() {
        return this.outAnim;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public View hookRootView(View r100) {
        if (this.isFullScreen == false) goto L5;
        int r101 = CJPayBasicUtils.getStatusBarHeight(CJPayHostInfo.applicationContext);
    L6:
        r100.setPadding(0, r101, 0, 0);
        return r100;
    L5:
        r101 = 0;
        goto L6
    }

    public void setInAnim(int r100) {
        this.inAnim = r100;
    }

    public void setOutAnim(int r100) {
        this.outAnim = r100;
    }
}
