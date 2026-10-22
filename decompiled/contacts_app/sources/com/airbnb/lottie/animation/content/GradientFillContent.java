package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final int CACHE_STEPS_MS = 32;
    private BaseKeyframeAnimation<Float, Float> blurAnimation;
    float blurMaskFilterRadius;
    private final RectF boundsRect;
    private final int cacheSteps;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    private ValueCallbackKeyframeAnimation colorCallbackAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private DropShadowKeyframeAnimation dropShadowAnimation;
    private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LongSparseArray<LinearGradient> linearGradientCache;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    private final Paint paint;
    private final Path path;
    private final List<PathContent> paths;
    private final LongSparseArray<RadialGradient> radialGradientCache;
    private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    private final GradientType type;

    public GradientFillContent(LottieDrawable r4, LottieComposition r5, BaseLayer r6, GradientFill r7) {
        this.linearGradientCache = new LongSparseArray();
        this.radialGradientCache = new LongSparseArray();
        Path r0 = new Path();
        this.path = r0;
        this.paint = new LPaint(1);
        this.boundsRect = new RectF();
        this.paths = new ArrayList();
        this.blurMaskFilterRadius = 0.0f;
        this.layer = r6;
        this.name = r7.getName();
        this.hidden = r7.isHidden();
        this.lottieDrawable = r4;
        this.type = r7.getGradientType();
        r0.setFillType(r7.getFillType());
        this.cacheSteps = (int) (r5.getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> r8 = r7.getGradientColor().createAnimation();
        this.colorAnimation = r8;
        r8.addUpdateListener(this);
        r6.addAnimation(r8);
        BaseKeyframeAnimation<Integer, Integer> r9 = r7.getOpacity().createAnimation();
        this.opacityAnimation = r9;
        r9.addUpdateListener(this);
        r6.addAnimation(r9);
        BaseKeyframeAnimation<PointF, PointF> r10 = r7.getStartPoint().createAnimation();
        this.startPointAnimation = r10;
        r10.addUpdateListener(this);
        r6.addAnimation(r10);
        BaseKeyframeAnimation<PointF, PointF> r11 = r7.getEndPoint().createAnimation();
        this.endPointAnimation = r11;
        r11.addUpdateListener(this);
        r6.addAnimation(r11);
        if (r6.getBlurEffect() == null) goto L6;
        BaseKeyframeAnimation<Float, Float> r12 = r6.getBlurEffect().getBlurriness().createAnimation();
        this.blurAnimation = r12;
        r12.addUpdateListener(this);
        r6.addAnimation(this.blurAnimation);
    L6:
        if (r6.getDropShadowEffect() == null) goto L9;
        this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, r6, r6.getDropShadowEffect());
        return;
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

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas r6, Matrix r7, int r8) {
        if (this.hidden == false) goto L5;
        return;
    L5:
        L.beginSection("GradientFillContent#draw");
        this.path.reset();
        int r2 = 0;
    L7:
        if (r2 >= this.paths.size()) goto L9;
        this.path.addPath(this.paths.get(r2).getPath(), r7);
        r2 = r2 + 1;
        goto L7
    L9:
        this.path.computeBounds(this.boundsRect, false);
        if (this.type != GradientType.LINEAR) goto L12;
        Shader r3 = getLinearGradient();
    L13:
        r3.setLocalMatrix(r7);
        this.paint.setShader(r3);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> r9 = this.colorFilterAnimation;
        if (r9 == null) goto L16;
        this.paint.setColorFilter(r9.getValue());
    L16:
        BaseKeyframeAnimation<Float, Float> r10 = this.blurAnimation;
        if (r10 == null) goto L25;
        float r11 = r10.getValue().floatValue();
        if (r11 != 0.0f) goto L22;
        this.paint.setMaskFilter(null);
    L24:
        this.blurMaskFilterRadius = r11;
        goto L25
    L22:
        if (r11 == this.blurMaskFilterRadius) goto L24;
        this.paint.setMaskFilter(new BlurMaskFilter(r11, BlurMaskFilter.Blur.NORMAL));
    L25:
        DropShadowKeyframeAnimation r12 = this.dropShadowAnimation;
        if (r12 == null) goto L28;
        r12.applyTo(this.paint);
    L28:
        this.paint.setAlpha(MiscUtils.clamp((int) ((((r8 / 255.0f) * this.opacityAnimation.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        r6.drawPath(this.path, this.paint);
        L.endSection("GradientFillContent#draw");
        return;
    L12:
        r3 = getRadialGradient();
        goto L13
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
        float r5 = (float) Math.hypot(r3.x - r7, r3.y - r8);
        if (r5 > 0.0f) goto L8;
        r5 = 0.001f;
    L8:
        RadialGradient r6 = new RadialGradient(r7, r8, r5, r10, r11, Shader.TileMode.CLAMP);
        this.radialGradientCache.put(r2, r6);
        return r6;
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

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        MiscUtils.resolveKeyPath(r1, r2, r3, r4, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r3, LottieValueCallback<T> r4) {
        if (r3 != LottieProperty.OPACITY) goto L6;
        this.opacityAnimation.setValueCallback(r4);
        return;
    L6:
        if (r3 != LottieProperty.COLOR_FILTER) goto L14;
        BaseKeyframeAnimation<ColorFilter, ColorFilter> r5 = this.colorFilterAnimation;
        if (r5 == null) goto L10;
        this.layer.removeAnimation(r5);
    L10:
        if (r4 != null) goto L12;
        this.colorFilterAnimation = null;
        return;
    L12:
        ValueCallbackKeyframeAnimation r6 = new ValueCallbackKeyframeAnimation(r4);
        this.colorFilterAnimation = r6;
        r6.addUpdateListener(this);
        this.layer.addAnimation(this.colorFilterAnimation);
        return;
    L14:
        if (r3 != LottieProperty.GRADIENT_COLOR) goto L22;
        ValueCallbackKeyframeAnimation r7 = this.colorCallbackAnimation;
        if (r7 == null) goto L18;
        this.layer.removeAnimation(r7);
    L18:
        if (r4 != null) goto L20;
        this.colorCallbackAnimation = null;
        return;
    L20:
        this.linearGradientCache.clear();
        this.radialGradientCache.clear();
        ValueCallbackKeyframeAnimation r8 = new ValueCallbackKeyframeAnimation(r4);
        this.colorCallbackAnimation = r8;
        r8.addUpdateListener(this);
        this.layer.addAnimation(this.colorCallbackAnimation);
        return;
    L22:
        if (r3 != LottieProperty.BLUR_RADIUS) goto L28;
        BaseKeyframeAnimation<Float, Float> r9 = this.blurAnimation;
        if (r9 == null) goto L26;
        r9.setValueCallback(r4);
        return;
    L26:
        ValueCallbackKeyframeAnimation r10 = new ValueCallbackKeyframeAnimation(r4);
        this.blurAnimation = r10;
        r10.addUpdateListener(this);
        this.layer.addAnimation(this.blurAnimation);
        return;
    L28:
        if (r3 != LottieProperty.DROP_SHADOW_COLOR) goto L33;
        DropShadowKeyframeAnimation r0 = this.dropShadowAnimation;
        if (r0 == null) goto L33;
        r0.setColorCallback(r4);
        return;
    L33:
        if (r3 != LottieProperty.DROP_SHADOW_OPACITY) goto L38;
        DropShadowKeyframeAnimation r1 = this.dropShadowAnimation;
        if (r1 == null) goto L38;
        r1.setOpacityCallback(r4);
        return;
    L38:
        if (r3 != LottieProperty.DROP_SHADOW_DIRECTION) goto L43;
        DropShadowKeyframeAnimation r2 = this.dropShadowAnimation;
        if (r2 == null) goto L43;
        r2.setDirectionCallback(r4);
        return;
    L43:
        if (r3 != LottieProperty.DROP_SHADOW_DISTANCE) goto L48;
        DropShadowKeyframeAnimation r11 = this.dropShadowAnimation;
        if (r11 == null) goto L48;
        r11.setDistanceCallback(r4);
        return;
    L48:
        if (r3 != LottieProperty.DROP_SHADOW_RADIUS) goto L64;
        DropShadowKeyframeAnimation r12 = this.dropShadowAnimation;
        if (r12 == null) goto L65;
        r12.setRadiusCallback(r4);
        return;
    L65:
        return;
    }
}
