package com.zyql.ai.selector.widget.longimage;

import android.graphics.PointF;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class ImageViewState implements Serializable {
    private final float centerX;
    private final float centerY;
    private final int orientation;
    private final float scale;

    public ImageViewState(float f10, PointF pointF, int i10) {
        this.scale = f10;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i10;
    }

    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }
}
