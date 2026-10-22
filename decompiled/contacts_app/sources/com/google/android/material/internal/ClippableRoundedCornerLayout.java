package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class ClippableRoundedCornerLayout extends FrameLayout {
    private Path path;

    public ClippableRoundedCornerLayout(Context r1) {
        super(r1);
    }

    public ClippableRoundedCornerLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public ClippableRoundedCornerLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r3) {
        if (this.path != null) goto L6;
        super.dispatchDraw(r3);
        return;
    L6:
        int r0 = r3.save();
        r3.clipPath(this.path);
        super.dispatchDraw(r3);
        r3.restoreToCount(r0);
    }

    public void resetClipBoundsAndCornerRadius() {
        this.path = null;
        invalidate();
    }

    public void updateClipBoundsAndCornerRadius(Rect r8, float r9) {
        updateClipBoundsAndCornerRadius(r8.left, r8.top, r8.right, r8.bottom, r9);
    }

    public void updateClipBoundsAndCornerRadius(float r2, float r3, float r4, float r5, float r6) {
        updateClipBoundsAndCornerRadius(new RectF(r2, r3, r4, r5), r6);
    }

    public void updateClipBoundsAndCornerRadius(RectF r3, float r4) {
        if (this.path != null) goto L5;
        this.path = new Path();
    L5:
        this.path.reset();
        this.path.addRoundRect(r3, r4, r4, Path.Direction.CW);
        this.path.close();
        invalidate();
    }
}
