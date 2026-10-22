package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public interface DrawingContent extends Content {
    void draw(Canvas r1, Matrix r2, int r3);

    void getBounds(RectF r1, Matrix r2, boolean r3);
}
