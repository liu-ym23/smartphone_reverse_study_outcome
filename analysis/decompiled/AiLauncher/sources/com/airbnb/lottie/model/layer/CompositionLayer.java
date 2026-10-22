package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.collection.j;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.OffscreenLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class CompositionLayer extends BaseLayer {
    private boolean clipToCompositionBounds;
    private DropShadowKeyframeAnimation dropShadowAnimation;
    private Boolean hasMasks;
    private Boolean hasMatte;
    private final RectF layerBounds;
    private final List<BaseLayer> layers;
    private final RectF newClipRect;
    private final OffscreenLayer offscreenLayer;
    private final OffscreenLayer.ComposeOp offscreenOp;
    private float progress;
    private final RectF rect;
    private BaseKeyframeAnimation<Float, Float> timeRemapping;

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        int i10;
        BaseLayer baseLayer;
        super(lottieDrawable, layer);
        this.layers = new ArrayList();
        this.rect = new RectF();
        this.newClipRect = new RectF();
        this.layerBounds = new RectF();
        this.offscreenLayer = new OffscreenLayer();
        this.offscreenOp = new OffscreenLayer.ComposeOp();
        this.clipToCompositionBounds = true;
        AnimatableFloatValue timeRemapping = layer.getTimeRemapping();
        if (timeRemapping != null) {
            FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation = timeRemapping.createAnimation();
            this.timeRemapping = floatKeyframeAnimationCreateAnimation;
            addAnimation(floatKeyframeAnimationCreateAnimation);
            this.timeRemapping.addUpdateListener(this);
        } else {
            this.timeRemapping = null;
        }
        j jVar = new j(lottieComposition.getLayers().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer baseLayerForModel = BaseLayer.forModel(this, layer2, lottieDrawable, lottieComposition);
            if (baseLayerForModel != null) {
                jVar.n(baseLayerForModel.getLayerModel().getId(), baseLayerForModel);
                if (baseLayer2 != null) {
                    baseLayer2.setMatteLayer(baseLayerForModel);
                    baseLayer2 = null;
                } else {
                    this.layers.add(0, baseLayerForModel);
                    int i11 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[layer2.getMatteType().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        baseLayer2 = baseLayerForModel;
                    }
                }
            }
            size--;
        }
        for (i10 = 0; i10 < jVar.r(); i10++) {
            BaseLayer baseLayer3 = (BaseLayer) jVar.h(jVar.k(i10));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) jVar.h(baseLayer3.getLayerModel().getParentId())) != null) {
                baseLayer3.setParentLayer(baseLayer);
            }
        }
        if (getDropShadowEffect() != null) {
            this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, this, getDropShadowEffect());
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t10, LottieValueCallback<T> lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        super.addValueCallback(t10, lottieValueCallback);
        if (t10 == LottieProperty.TIME_REMAP) {
            if (lottieValueCallback == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.timeRemapping;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.setValueCallback(null);
                    return;
                }
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.timeRemapping = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.timeRemapping);
            return;
        }
        if (t10 == LottieProperty.DROP_SHADOW_COLOR && (dropShadowKeyframeAnimation5 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation5.setColorCallback(lottieValueCallback);
            return;
        }
        if (t10 == LottieProperty.DROP_SHADOW_OPACITY && (dropShadowKeyframeAnimation4 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation4.setOpacityCallback(lottieValueCallback);
            return;
        }
        if (t10 == LottieProperty.DROP_SHADOW_DIRECTION && (dropShadowKeyframeAnimation3 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation3.setDirectionCallback(lottieValueCallback);
            return;
        }
        if (t10 == LottieProperty.DROP_SHADOW_DISTANCE && (dropShadowKeyframeAnimation2 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation2.setDistanceCallback(lottieValueCallback);
        } else {
            if (t10 != LottieProperty.DROP_SHADOW_RADIUS || (dropShadowKeyframeAnimation = this.dropShadowAnimation) == null) {
                return;
            }
            dropShadowKeyframeAnimation.setRadiusCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i10, DropShadow dropShadow) {
        Canvas canvasStart;
        if (L.isTraceEnabled()) {
            L.beginSection("CompositionLayer#draw");
        }
        boolean z10 = false;
        boolean z11 = (dropShadow == null && this.dropShadowAnimation == null) ? false : true;
        if ((this.lottieDrawable.isApplyingOpacityToLayersEnabled() && this.layers.size() > 1 && i10 != 255) || (z11 && this.lottieDrawable.isApplyingShadowToLayersEnabled())) {
            z10 = true;
        }
        int i11 = z10 ? 255 : i10;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.dropShadowAnimation;
        if (dropShadowKeyframeAnimation != null) {
            dropShadow = dropShadowKeyframeAnimation.evaluate(matrix, i11);
        }
        if (this.clipToCompositionBounds || !"__container".equals(this.layerModel.getName())) {
            this.newClipRect.set(0.0f, 0.0f, this.layerModel.getPreCompWidth(), this.layerModel.getPreCompHeight());
            matrix.mapRect(this.newClipRect);
        } else {
            this.newClipRect.setEmpty();
            Iterator<BaseLayer> it = this.layers.iterator();
            while (it.hasNext()) {
                it.next().getBounds(this.layerBounds, matrix, true);
                this.newClipRect.union(this.layerBounds);
            }
        }
        if (z10) {
            this.offscreenOp.reset();
            OffscreenLayer.ComposeOp composeOp = this.offscreenOp;
            composeOp.alpha = i10;
            if (dropShadow != null) {
                dropShadow.applyTo(composeOp);
                dropShadow = null;
            }
            canvasStart = this.offscreenLayer.start(canvas, this.newClipRect, this.offscreenOp);
        } else {
            canvasStart = canvas;
        }
        canvas.save();
        if (canvas.clipRect(this.newClipRect)) {
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                this.layers.get(size).draw(canvasStart, matrix, i11, dropShadow);
            }
        }
        if (z10) {
            this.offscreenLayer.finish();
        }
        canvas.restore();
        if (L.isTraceEnabled()) {
            L.endSection("CompositionLayer#draw");
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        super.getBounds(rectF, matrix, z10);
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.layers.get(size).getBounds(this.rect, this.boundsMatrix, true);
            rectF.union(this.rect);
        }
    }

    public float getProgress() {
        return this.progress;
    }

    public boolean hasMasks() {
        if (this.hasMasks == null) {
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                BaseLayer baseLayer = this.layers.get(size);
                if (baseLayer instanceof ShapeLayer) {
                    if (baseLayer.hasMasksOnThisLayer()) {
                        this.hasMasks = Boolean.TRUE;
                        return true;
                    }
                } else if ((baseLayer instanceof CompositionLayer) && ((CompositionLayer) baseLayer).hasMasks()) {
                    this.hasMasks = Boolean.TRUE;
                    return true;
                }
            }
            this.hasMasks = Boolean.FALSE;
        }
        return this.hasMasks.booleanValue();
    }

    public boolean hasMatte() {
        if (this.hasMatte == null) {
            if (hasMatteOnThisLayer()) {
                this.hasMatte = Boolean.TRUE;
                return true;
            }
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                if (this.layers.get(size).hasMatteOnThisLayer()) {
                    this.hasMatte = Boolean.TRUE;
                    return true;
                }
            }
            this.hasMatte = Boolean.FALSE;
        }
        return this.hasMatte.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void resolveChildKeyPath(KeyPath keyPath, int i10, List<KeyPath> list, KeyPath keyPath2) {
        for (int i11 = 0; i11 < this.layers.size(); i11++) {
            this.layers.get(i11).resolveKeyPath(keyPath, i10, list, keyPath2);
        }
    }

    public void setClipToCompositionBounds(boolean z10) {
        this.clipToCompositionBounds = z10;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setOutlineMasksAndMattes(boolean z10) {
        super.setOutlineMasksAndMattes(z10);
        Iterator<BaseLayer> it = this.layers.iterator();
        while (it.hasNext()) {
            it.next().setOutlineMasksAndMattes(z10);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setProgress(float f10) {
        if (L.isTraceEnabled()) {
            L.beginSection("CompositionLayer#setProgress");
        }
        this.progress = f10;
        super.setProgress(f10);
        if (this.timeRemapping != null) {
            f10 = ((this.timeRemapping.getValue().floatValue() * this.layerModel.getComposition().getFrameRate()) - this.layerModel.getComposition().getStartFrame()) / (this.lottieDrawable.getComposition().getDurationFrames() + 0.01f);
        }
        if (this.timeRemapping == null) {
            f10 -= this.layerModel.getStartProgress();
        }
        if (this.layerModel.getTimeStretch() != 0.0f && !"__container".equals(this.layerModel.getName())) {
            f10 /= this.layerModel.getTimeStretch();
        }
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.layers.get(size).setProgress(f10);
        }
        if (L.isTraceEnabled()) {
            L.endSection("CompositionLayer#setProgress");
        }
    }
}
