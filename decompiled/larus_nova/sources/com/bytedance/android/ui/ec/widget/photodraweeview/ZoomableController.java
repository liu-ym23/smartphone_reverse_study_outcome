package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes14.dex */
public interface ZoomableController {

    public interface Listener {
        void onTransformChanged(Matrix r100);
    }

    int computeHorizontalScrollExtent();

    int computeHorizontalScrollOffset();

    int computeHorizontalScrollRange();

    void computeScroll();

    int computeVerticalScrollExtent();

    int computeVerticalScrollOffset();

    int computeVerticalScrollRange();

    Matrix getActiveTransform();

    float getScaleFactor();

    boolean isEnabled();

    boolean isIdentity();

    boolean onTouchEvent(MotionEvent r100);

    void setEnabled(boolean r100);

    void setImageBounds(RectF r100);

    void setListener(Listener r100);

    void setViewBounds(RectF r100);
}
