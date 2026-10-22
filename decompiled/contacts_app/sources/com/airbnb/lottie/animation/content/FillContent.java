package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private BaseKeyframeAnimation<Float, Float> blurAnimation;
    float blurMaskFilterRadius;
    private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private DropShadowKeyframeAnimation dropShadowAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    private final Paint paint;
    private final Path path;
    private final List<PathContent> paths;

    public FillContent(LottieDrawable r4, BaseLayer r5, ShapeFill r6) {
        Path r0 = new Path();
        this.path = r0;
        this.paint = new LPaint(1);
        this.paths = new ArrayList();
        this.layer = r5;
        this.name = r6.getName();
        this.hidden = r6.isHidden();
        this.lottieDrawable = r4;
        if (r5.getBlurEffect() == null) goto L6;
        BaseKeyframeAnimation<Float, Float> r7 = r5.getBlurEffect().getBlurriness().createAnimation();
        this.blurAnimation = r7;
        r7.addUpdateListener(this);
        r5.addAnimation(this.blurAnimation);
    L6:
        if (r5.getDropShadowEffect() == null) goto L9;
        this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, r5, r5.getDropShadowEffect());
    L9:
        if (r6.getColor() != null) goto L11;
    L15:
        this.colorAnimation = null;
        this.opacityAnimation = null;
        return;
    L11:
        if (r6.getOpacity() == null) goto L15;
        r0.setFillType(r6.getFillType());
        BaseKeyframeAnimation<Integer, Integer> r8 = r6.getColor().createAnimation();
        this.colorAnimation = r8;
        r8.addUpdateListener(this);
        r5.addAnimation(r8);
        BaseKeyframeAnimation<Integer, Integer> r9 = r6.getOpacity().createAnimation();
        this.opacityAnimation = r9;
        r9.addUpdateListener(this);
        r5.addAnimation(r9);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r3, List<Content> r4) {
        int r5 = 0;
    L4:
        if (r5 >= r4.size()) goto L9;
        Content r0 = r4.get(r5);
        if ((r0 instanceof PathContent) == false) goto L8;
        this.paths.add((PathContent) r0);
    L8:
        r5 = r5 + 1;
        goto L4
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas r6, Matrix r7, int r8) {
        if (this.hidden == false) goto L5;
        return;
    L5:
        L.beginSection("FillContent#draw");
        int r1 = ((ColorKeyframeAnimation) this.colorAnimation).getIntValue();
        int r4 = 0;
        this.paint.setColor((MiscUtils.clamp((int) ((((r8 / 255.0f) * this.opacityAnimation.getValue().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (r1 & 16777215));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> r9 = this.colorFilterAnimation;
        if (r9 == null) goto L8;
        this.paint.setColorFilter(r9.getValue());
    L8:
        BaseKeyframeAnimation<Float, Float> r10 = this.blurAnimation;
        if (r10 == null) goto L17;
        float r11 = r10.getValue().floatValue();
        if (r11 != 0.0f) goto L14;
        this.paint.setMaskFilter(null);
    L16:
        this.blurMaskFilterRadius = r11;
        goto L17
    L14:
        if (r11 == this.blurMaskFilterRadius) goto L16;
        this.paint.setMaskFilter(this.layer.getBlurMaskFilter(r11));
    L17:
        DropShadowKeyframeAnimation r12 = this.dropShadowAnimation;
        if (r12 == null) goto L20;
        r12.applyTo(this.paint);
    L20:
        this.path.reset();
    L22:
        if (r4 >= this.paths.size()) goto L24;
        this.path.addPath(this.paths.get(r4).getPath(), r7);
        r4 = r4 + 1;
        goto L22
    L24:
        r6.drawPath(this.path, this.paint);
        L.endSection("FillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r4, Matrix r5, boolean r6) {
        this.path.reset();
        int r0 = 0;
    L4:
        if (r0 >= this.paths.size()) goto L6;
        this.path.addPath(this.paths.get(r0).getPath(), r5);
        r0 = r0 + 1;
        goto L4
    L6:
        this.path.computeBounds(r4, false);
        r4.set(r4.left - 1.0f, r4.top - 1.0f, r4.right + 1.0f, r4.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        MiscUtils.resolveKeyPath(r1, r2, r3, r4, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        if (r2 != LottieProperty.COLOR) goto L6;
        this.colorAnimation.setValueCallback(r3);
        return;
    L6:
        if (r2 != LottieProperty.OPACITY) goto L9;
        this.opacityAnimation.setValueCallback(r3);
        return;
    L9:
        if (r2 != LottieProperty.COLOR_FILTER) goto L17;
        BaseKeyframeAnimation<ColorFilter, ColorFilter> r4 = this.colorFilterAnimation;
        if (r4 == null) goto L13;
        this.layer.removeAnimation(r4);
    L13:
        if (r3 != null) goto L15;
        this.colorFilterAnimation = null;
        return;
    L15:
        ValueCallbackKeyframeAnimation r5 = new ValueCallbackKeyframeAnimation(r3);
        this.colorFilterAnimation = r5;
        r5.addUpdateListener(this);
        this.layer.addAnimation(this.colorFilterAnimation);
        return;
    L17:
        if (r2 != LottieProperty.BLUR_RADIUS) goto L23;
        BaseKeyframeAnimation<Float, Float> r6 = this.blurAnimation;
        if (r6 == null) goto L21;
        r6.setValueCallback(r3);
        return;
    L21:
        ValueCallbackKeyframeAnimation r7 = new ValueCallbackKeyframeAnimation(r3);
        this.blurAnimation = r7;
        r7.addUpdateListener(this);
        this.layer.addAnimation(this.blurAnimation);
        return;
    L23:
        if (r2 != LottieProperty.DROP_SHADOW_COLOR) goto L28;
        DropShadowKeyframeAnimation r0 = this.dropShadowAnimation;
        if (r0 == null) goto L28;
        r0.setColorCallback(r3);
        return;
    L28:
        if (r2 != LottieProperty.DROP_SHADOW_OPACITY) goto L33;
        DropShadowKeyframeAnimation r1 = this.dropShadowAnimation;
        if (r1 == null) goto L33;
        r1.setOpacityCallback(r3);
        return;
    L33:
        if (r2 != LottieProperty.DROP_SHADOW_DIRECTION) goto L38;
        DropShadowKeyframeAnimation r8 = this.dropShadowAnimation;
        if (r8 == null) goto L38;
        r8.setDirectionCallback(r3);
        return;
    L38:
        if (r2 != LottieProperty.DROP_SHADOW_DISTANCE) goto L43;
        DropShadowKeyframeAnimation r9 = this.dropShadowAnimation;
        if (r9 == null) goto L43;
        r9.setDistanceCallback(r3);
        return;
    L43:
        if (r2 != LottieProperty.DROP_SHADOW_RADIUS) goto L58;
        DropShadowKeyframeAnimation r10 = this.dropShadowAnimation;
        if (r10 == null) goto L59;
        r10.setRadiusCallback(r3);
        return;
    L59:
        return;
    }
}
