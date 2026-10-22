package com.alibaba.android.vlayout.layout;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.alibaba.android.vlayout.LayoutManagerHelper;

/* JADX INFO: loaded from: classes.dex */
public abstract class FixAreaLayoutHelper extends BaseLayoutHelper {
    protected FixAreaAdjuster mAdjuster;
    protected FixViewAnimatorHelper mFixViewAnimatorHelper;

    public interface FixViewAnimatorHelper {
        ViewPropertyAnimator onGetFixViewAppearAnimator(View r10);

        ViewPropertyAnimator onGetFixViewDisappearAnimator(View r10);
    }

    public FixAreaLayoutHelper() {
        this.mAdjuster = FixAreaAdjuster.mDefaultAdjuster;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void adjustLayout(int r10, int r11, LayoutManagerHelper r12) {
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computeMarginEnd(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        return 0;
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computeMarginStart(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        return 0;
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computePaddingEnd(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        return 0;
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computePaddingStart(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        return 0;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public boolean isFixLayout() {
        return true;
    }

    public void setAdjuster(FixAreaAdjuster r10) {
        this.mAdjuster = r10;
    }

    public void setFixViewAnimatorHelper(FixViewAnimatorHelper r10) {
        this.mFixViewAnimatorHelper = r10;
    }
}
