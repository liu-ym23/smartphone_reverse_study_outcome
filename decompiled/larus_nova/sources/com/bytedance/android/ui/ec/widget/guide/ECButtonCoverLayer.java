package com.bytedance.android.ui.ec.widget.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes14.dex */
public class ECButtonCoverLayer extends View implements ECFunctionGuideView.FunctionLayer {
    private FrameLayout.LayoutParams mLayerParams;

    @Override // com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView.FunctionLayer
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView.FunctionLayer
    public FrameLayout.LayoutParams getLayerParams() {
        return this.mLayerParams;
    }

    public ECButtonCoverLayer(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public void setData(Rect r100) {
        if (r100 == null) goto L5;
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(r100.right - r100.left, r100.bottom - r100.top);
        this.mLayerParams = r101;
        r101.leftMargin = r100.left;
        r101.topMargin = r100.top;
        return;
    }

    public ECButtonCoverLayer(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public ECButtonCoverLayer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
