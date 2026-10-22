package com.bytedance.android.ui.ec.widget.guide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes14.dex */
public class ECFunctionGuideView extends FrameLayout {

    public interface FunctionLayer {
        FrameLayout.LayoutParams getLayerParams();

        View getView();
    }

    public ECFunctionGuideView(Context r100) {
        super(r100);
    }

    public ECFunctionGuideView addFunctionLayer(FunctionLayer r100) {
        if (r100 == null) goto L7;
        View r101 = r100.getView();
        FrameLayout.LayoutParams r102 = r100.getLayerParams();
        if (r101 == null) goto L7;
        if (r102 == null) goto L7;
        addView(r101, r102);
    L7:
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = super.dispatchTouchEvent(r100);
        if (r100 == null) goto L11;
        int r102 = r100.getAction() & 255;
        if (r102 != 0) goto L9;
        if (r101 == true) goto L9;
        setVisibility(8);
    L9:
        if (r102 != 1) goto L11;
        setVisibility(8);
    L11:
        return r101;
    }

    public ECFunctionGuideView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public ECFunctionGuideView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
