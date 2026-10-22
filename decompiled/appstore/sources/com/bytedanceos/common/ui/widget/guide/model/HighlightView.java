package com.bytedanceos.common.ui.widget.guide.model;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.bytedanceos.common.ui.widget.guide.util.GuideLogUtil;
import com.bytedanceos.common.ui.widget.guide.util.GuideViewUtils;

/* JADX INFO: loaded from: classes2.dex */
public class HighlightView implements HighLight {
    private View mHole;
    private HighlightOptions options;
    private int padding;
    private RectF rectF;
    private int round;
    private HighLight.Shape shape;

    public HighlightView(View r10, HighLight.Shape r11, int r12, int r13) {
        this.mHole = r10;
        this.shape = r11;
        this.round = r12;
        this.padding = r13;
    }

    private RectF fetchLocation(View r10) {
        RectF r11 = new RectF();
        Rect r12 = GuideViewUtils.getLocationInView(r10, this.mHole);     // Catch: IllegalArgumentException -> L5
        int r13 = r12.left;     // Catch: IllegalArgumentException -> L5
        int r14 = this.padding;     // Catch: IllegalArgumentException -> L5
        r11.left = r13 - r14;     // Catch: IllegalArgumentException -> L5
        r11.top = r12.top - r14;     // Catch: IllegalArgumentException -> L5
        r11.right = r12.right + r14;     // Catch: IllegalArgumentException -> L5
        r11.bottom = r12.bottom + r14;     // Catch: IllegalArgumentException -> L5
    L7:
        return r11;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.bytedanceos.common.ui.widget.guide.model.HighLight
    public HighlightOptions getOptions() {
        return this.options;
    }

    @Override // com.bytedanceos.common.ui.widget.guide.model.HighLight
    public float getRadius() {
        View r10 = this.mHole;
        if (r10 == null) goto L7;
        return Math.max(r10.getWidth() / 2, this.mHole.getHeight() / 2) + this.padding;
    L7:
        throw new IllegalArgumentException("the highlight view is null!");
    }

    @Override // com.bytedanceos.common.ui.widget.guide.model.HighLight
    public RectF getRectF(View r10) {
        if (this.mHole == null) goto L15;
        if (this.rectF != null) goto L7;
        this.rectF = fetchLocation(r10);
    L12:
        GuideLogUtil.i(this.mHole.getClass().getSimpleName() + "'s location:" + this.rectF);
        return this.rectF;
    L7:
        HighlightOptions r11 = this.options;
        if (r11 == null) goto L12;
        if (r11.fetchLocationEveryTime == false) goto L12;
        this.rectF = fetchLocation(r10);
        goto L12
    L15:
        throw new IllegalArgumentException("the highlight view is null!");
    }

    @Override // com.bytedanceos.common.ui.widget.guide.model.HighLight
    public int getRound() {
        return this.round;
    }

    @Override // com.bytedanceos.common.ui.widget.guide.model.HighLight
    public HighLight.Shape getShape() {
        return this.shape;
    }

    public void setOptions(HighlightOptions r10) {
        this.options = r10;
    }
}
