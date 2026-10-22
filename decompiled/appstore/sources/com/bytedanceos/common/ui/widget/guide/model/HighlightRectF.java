package com.bytedanceos.common.ui.widget.guide.model;

import android.graphics.RectF;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class HighlightRectF implements HighLight {
    private HighlightOptions options;
    private RectF rectF;
    private int round;
    private HighLight.Shape shape;

    public HighlightRectF(@NonNull RectF r10, @NonNull HighLight.Shape r11, int r12) {
        this.rectF = r10;
        this.shape = r11;
        this.round = r12;
    }

    @Override // com.bytedanceos.common.ui.widget.guide.model.HighLight
    public HighlightOptions getOptions() {
        return this.options;
    }

    @Override // com.bytedanceos.common.ui.widget.guide.model.HighLight
    public float getRadius() {
        return Math.min(this.rectF.width() / 2.0f, this.rectF.height() / 2.0f);
    }

    @Override // com.bytedanceos.common.ui.widget.guide.model.HighLight
    public RectF getRectF(View r10) {
        return this.rectF;
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
