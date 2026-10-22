package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: loaded from: classes.dex */
public class GradientStrokeContent extends BaseStrokeContent {
    private static final int CACHE_STEPS_MS = 32;
    private final RectF boundsRect;
    private final int cacheSteps;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    private ValueCallbackKeyframeAnimation colorCallbackAnimation;
    private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    private final boolean hidden;
    private final LongSparseArray<LinearGradient> linearGradientCache;
    private final String name;
    private final LongSparseArray<RadialGradient> radialGradientCache;
    private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    private final GradientType type;

    public GradientStrokeContent(LottieDrawable r12, BaseLayer r13, GradientStroke r14) {
        super(r12, r13, r14.getCapType().toPaintCap(), r14.getJoinType().toPaintJoin(), r14.getMiterLimit(), r14.getOpacity(), r14.getWidth(), r14.getLineDashPattern(), r14.getDashOffset());
        this.linearGradientCache = new LongSparseArray();
        this.radialGradientCache = new LongSparseArray();
        this.boundsRect = new RectF();
        this.name = r14.getName();
        this.type = r14.getGradientType();
        this.hidden = r14.isHidden();
        this.cacheSteps = (int) (r12.getComposition().getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> r15 = r14.getGradientColor().createAnimation();
        this.colorAnimation = r15;
        r15.addUpdateListener(this);
        r13.addAnimation(r15);
        BaseKeyframeAnimation<PointF, PointF> r16 = r14.getStartPoint().createAnimation();
        this.startPointAnimation = r16;
        r16.addUpdateListener(this);
        r13.addAnimation(r16);
        BaseKeyframeAnimation<PointF, PointF> r17 = r14.getEndPoint().createAnimation();
        this.endPointAnimation = r17;
        r17.addUpdateListener(this);
        r13.addAnimation(r17);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas r3, Matrix r4, int r5) {
        if (this.hidden == false) goto L5;
        return;
    L5:
        getBounds(this.boundsRect, r4, false);
        if (this.type != GradientType.LINEAR) goto L8;
        Shader r0 = getLinearGradient();
    L9:
        r0.setLocalMatrix(r4);
        this.paint.setShader(r0);
        super.draw(r3, r4, r5);
        return;
    L8:
        r0 = getRadialGradient();
        goto L9
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    private LinearGradient getLinearGradient() {
        long r2 = getGradientHash();
        LinearGradient r0 = this.linearGradientCache.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        PointF r1 = this.startPointAnimation.getValue();
        PointF r3 = this.endPointAnimation.getValue();
        GradientColor r4 = this.colorAnimation.getValue();
        LinearGradient r5 = new LinearGradient(r1.x, r1.y, r3.x, r3.y, applyDynamicColorsIfNeeded(r4.getColors()), r4.getPositions(), Shader.TileMode.CLAMP);
        this.linearGradientCache.put(r2, r5);
        return r5;
    }

    private RadialGradient getRadialGradient() {
        long r2 = getGradientHash();
        RadialGradient r0 = this.radialGradientCache.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        PointF r1 = this.startPointAnimation.getValue();
        PointF r3 = this.endPointAnimation.getValue();
        GradientColor r4 = this.colorAnimation.getValue();
        int[] r10 = applyDynamicColorsIfNeeded(r4.getColors());
        float[] r11 = r4.getPositions();
        float r7 = r1.x;
        float r8 = r1.y;
        RadialGradient r5 = new RadialGradient(r7, r8, (float) Math.hypot(r3.x - r7, r3.y - r8), r10, r11, Shader.TileMode.CLAMP);
        this.radialGradientCache.put(r2, r5);
        return r5;
    }

    private int getGradientHash() {
        int r0 = Math.round(this.startPointAnimation.getProgress() * this.cacheSteps);
        int r1 = Math.round(this.endPointAnimation.getProgress() * this.cacheSteps);
        int r3 = Math.round(this.colorAnimation.getProgress() * this.cacheSteps);
        if (r0 == 0) goto L5;
        int r2 = 527 * r0;
    L6:
        if (r1 == 0) goto L8;
        r2 = (r2 * 31) * r1;
    L8:
        if (r3 != 0) goto L10;
        return r2;
    L10:
        return (r2 * 31) * r3;
    L5:
        r2 = 17;
        goto L6
    }

    private int[] applyDynamicColorsIfNeeded(int[] r4) {
        ValueCallbackKeyframeAnimation r3 = this.colorCallbackAnimation;
        if (r3 == null) goto L13;
        Integer[] r5 = (Integer[]) r3.getValue();
        int r2 = 0;
        if (r4.length == r5.length) goto L7;
        r4 = new int[r5.length];
    L11:
        if (r2 >= r5.length) goto L13;
        r4[r2] = r5[r2].intValue();
        r2 = r2 + 1;
    L7:
        if (r2 >= r4.length) goto L13;
        r4[r2] = r5[r2].intValue();
        r2 = r2 + 1;
    L13:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        super.addValueCallback(r2, r3);
        if (r2 == LottieProperty.GRADIENT_COLOR) goto L5;
        return;
    L5:
        if (this.colorCallbackAnimation == null) goto L7;
        this.layer.removeAnimation(this.colorCallbackAnimation);
    L7:
        if (r3 != null) goto L9;
        this.colorCallbackAnimation = null;
        return;
    L9:
        ValueCallbackKeyframeAnimation r4 = new ValueCallbackKeyframeAnimation(r3);
        this.colorCallbackAnimation = r4;
        r4.addUpdateListener(this);
        this.layer.addAnimation(this.colorCallbackAnimation);
    }
}
