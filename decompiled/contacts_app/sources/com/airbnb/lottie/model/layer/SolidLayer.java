package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: loaded from: classes.dex */
public class SolidLayer extends BaseLayer {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Layer layerModel;
    private final Paint paint;
    private final Path path;
    private final float[] points;
    private final RectF rect;

    SolidLayer(LottieDrawable r2, Layer r3) {
        super(r2, r3);
        this.rect = new RectF();
        LPaint r4 = new LPaint();
        this.paint = r4;
        this.points = new float[8];
        this.path = new Path();
        this.layerModel = r3;
        r4.setAlpha(0);
        r4.setStyle(Paint.Style.FILL);
        r4.setColor(r3.getSolidColor());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas r10, Matrix r11, int r12) {
        int r0 = Color.alpha(this.layerModel.getSolidColor());
        if (r0 != 0) goto L6;
        return;
    L6:
        if (this.transform.getOpacity() != null) goto L8;
        int r1 = 100;
    L9:
        int r13 = (int) (((r12 / 255.0f) * (((r0 / 255.0f) * r1) / 100.0f)) * 255.0f);
        this.paint.setAlpha(r13);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> r2 = this.colorFilterAnimation;
        if (r2 == null) goto L12;
        this.paint.setColorFilter(r2.getValue());
    L12:
        if (r13 <= 0) goto L15;
        float[] r14 = this.points;
        r14[0] = 0.0f;
        r14[1] = 0.0f;
        r14[2] = this.layerModel.getSolidWidth();
        float[] r15 = this.points;
        r15[3] = 0.0f;
        r15[4] = this.layerModel.getSolidWidth();
        this.points[5] = this.layerModel.getSolidHeight();
        float[] r16 = this.points;
        r16[6] = 0.0f;
        r16[7] = this.layerModel.getSolidHeight();
        r11.mapPoints(this.points);
        this.path.reset();
        Path r17 = this.path;
        float[] r18 = this.points;
        r17.moveTo(r18[0], r18[1]);
        Path r19 = this.path;
        float[] r110 = this.points;
        r19.lineTo(r110[2], r110[3]);
        Path r111 = this.path;
        float[] r112 = this.points;
        r111.lineTo(r112[4], r112[5]);
        Path r113 = this.path;
        float[] r114 = this.points;
        r113.lineTo(r114[6], r114[7]);
        Path r115 = this.path;
        float[] r116 = this.points;
        r115.lineTo(r116[0], r116[1]);
        this.path.close();
        r10.drawPath(this.path, this.paint);
        return;
    L15:
        return;
    L8:
        r1 = this.transform.getOpacity().getValue().intValue();
        goto L9
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r3, Matrix r4, boolean r5) {
        super.getBounds(r3, r4, r5);
        this.rect.set(0.0f, 0.0f, this.layerModel.getSolidWidth(), this.layerModel.getSolidHeight());
        this.boundsMatrix.mapRect(this.rect);
        r3.set(this.rect);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        super.addValueCallback(r2, r3);
        if (r2 != LottieProperty.COLOR_FILTER) goto L8;
        if (r3 != null) goto L6;
        this.colorFilterAnimation = null;
        return;
    L6:
        this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(r3);
        return;
    }
}
