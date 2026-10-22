package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: loaded from: classes.dex */
public class StrokeContent extends BaseStrokeContent {
    private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final String name;

    public StrokeContent(LottieDrawable r12, BaseLayer r13, ShapeStroke r14) {
        super(r12, r13, r14.getCapType().toPaintCap(), r14.getJoinType().toPaintJoin(), r14.getMiterLimit(), r14.getOpacity(), r14.getWidth(), r14.getLineDashPattern(), r14.getDashOffset());
        this.layer = r13;
        this.name = r14.getName();
        this.hidden = r14.isHidden();
        BaseKeyframeAnimation<Integer, Integer> r15 = r14.getColor().createAnimation();
        this.colorAnimation = r15;
        r15.addUpdateListener(this);
        r13.addAnimation(r15);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas r3, Matrix r4, int r5) {
        if (this.hidden == false) goto L5;
        return;
    L5:
        this.paint.setColor(((ColorKeyframeAnimation) this.colorAnimation).getIntValue());
        if (this.colorFilterAnimation == null) goto L8;
        this.paint.setColorFilter(this.colorFilterAnimation.getValue());
    L8:
        super.draw(r3, r4, r5);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        super.addValueCallback(r2, r3);
        if (r2 != LottieProperty.STROKE_COLOR) goto L6;
        this.colorAnimation.setValueCallback(r3);
        return;
    L6:
        if (r2 != LottieProperty.COLOR_FILTER) goto L15;
        BaseKeyframeAnimation<ColorFilter, ColorFilter> r4 = this.colorFilterAnimation;
        if (r4 == null) goto L10;
        this.layer.removeAnimation(r4);
    L10:
        if (r3 != null) goto L12;
        this.colorFilterAnimation = null;
        return;
    L12:
        ValueCallbackKeyframeAnimation r5 = new ValueCallbackKeyframeAnimation(r3);
        this.colorFilterAnimation = r5;
        r5.addUpdateListener(this);
        this.layer.addAnimation(this.colorAnimation);
        return;
    }
}
