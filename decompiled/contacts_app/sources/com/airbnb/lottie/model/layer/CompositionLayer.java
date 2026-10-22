package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CompositionLayer extends BaseLayer {
    private boolean clipToCompositionBounds;
    private Boolean hasMasks;
    private Boolean hasMatte;
    private final Paint layerPaint;
    private final List<BaseLayer> layers;
    private final RectF newClipRect;
    private float progress;
    private final RectF rect;
    private BaseKeyframeAnimation<Float, Float> timeRemapping;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = null;

        static {
            int[] r0 = new int[Layer.MatteType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = r0;
            r0[Layer.MatteType.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[Layer.MatteType.INVERT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public CompositionLayer(LottieDrawable r10, Layer r11, List<Layer> r12, LottieComposition r13) {
        super(r10, r11);
        this.layers = new ArrayList();
        this.rect = new RectF();
        this.newClipRect = new RectF();
        this.layerPaint = new Paint();
        this.clipToCompositionBounds = true;
        AnimatableFloatValue r14 = r11.getTimeRemapping();
        if (r14 == null) goto L5;
        BaseKeyframeAnimation<Float, Float> r15 = r14.createAnimation();
        this.timeRemapping = r15;
        addAnimation(r15);
        this.timeRemapping.addUpdateListener(this);
    L6:
        LongSparseArray r16 = new LongSparseArray(r13.getLayers().size());
        int r2 = r12.size() - 1;
        BaseLayer r3 = null;
    L7:
        int r4 = 0;
        if (r2 < 0) goto L23;
        Layer r5 = r12.get(r2);
        BaseLayer r6 = BaseLayer.forModel(this, r5, r10, r13);
        if (r6 == null) goto L21;
        r16.put(r6.getLayerModel().getId(), r6);
        if (r3 == null) goto L15;
        r3.setMatteLayer(r6);
        r3 = null;
        goto L21
    L15:
        this.layers.add(0, r6);
        int r7 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[r5.getMatteType().ordinal()];
        if (r7 != 1) goto L18;
    L20:
        r3 = r6;
        goto L21
    L18:
        if (r7 == 2) goto L20;
    L21:
        r2 = r2 - 1;
    L23:
        if (r4 >= r16.size()) goto L31;
        BaseLayer r9 = (BaseLayer) r16.get(r16.keyAt(r4));
        if (r9 == null) goto L30;
        BaseLayer r17 = (BaseLayer) r16.get(r9.getLayerModel().getParentId());
        if (r17 == null) goto L30;
        r9.setParentLayer(r17);
    L30:
        r4 = r4 + 1;
        goto L23
    L31:
        return;
    L5:
        this.timeRemapping = null;
        goto L6
    }

    public void setClipToCompositionBounds(boolean r1) {
        this.clipToCompositionBounds = r1;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setOutlineMasksAndMattes(boolean r2) {
        super.setOutlineMasksAndMattes(r2);
        Iterator<BaseLayer> r1 = this.layers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setOutlineMasksAndMattes(r2);
        goto L4
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas r8, Matrix r9, int r10) {
        L.beginSection("CompositionLayer#draw");
        this.newClipRect.set(0.0f, 0.0f, this.layerModel.getPreCompWidth(), this.layerModel.getPreCompHeight());
        r9.mapRect(this.newClipRect);
        if (this.lottieDrawable.isApplyingOpacityToLayersEnabled() == true) goto L5;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
        this.layerPaint.setAlpha(r10);
        Utils.saveLayerCompat(r8, this.newClipRect, this.layerPaint);
    L12:
        if (r1 == false) goto L14;
        r10 = 255;
    L14:
        int r2 = this.layers.size() - 1;
    L15:
        if (r2 < 0) goto L30;
        if (this.clipToCompositionBounds == false) goto L19;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == false) goto L24;
    L26:
        boolean r4 = true;
    L27:
        if (r4 == false) goto L29;
        this.layers.get(r2).draw(r8, r9, r10);
    L29:
        r2 = r2 - 1;
        goto L15
    L24:
        if (this.newClipRect.isEmpty() == true) goto L26;
        r4 = r8.clipRect(this.newClipRect);
        goto L27
    L19:
        if ("__container".equals(this.layerModel.getName()) == false) goto L21;
        r3 = true;
        goto L22
    L30:
        r8.restore();
        L.endSection("CompositionLayer#draw");
        return;
    L11:
        r8.save();
        goto L12
    L5:
        if (this.layers.size() <= 1) goto L8;
        if (r10 == 255) goto L8;
        r1 = true;
        goto L9
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r4, Matrix r5, boolean r6) {
        super.getBounds(r4, r5, r6);
        int r7 = this.layers.size() - 1;
    L3:
        if (r7 < 0) goto L5;
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.layers.get(r7).getBounds(this.rect, this.boundsMatrix, true);
        r4.union(this.rect);
        r7 = r7 - 1;
        goto L3
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setProgress(float r5) {
        L.beginSection("CompositionLayer#setProgress");
        this.progress = r5;
        super.setProgress(r5);
        if (this.timeRemapping == null) goto L6;
        r5 = ((this.timeRemapping.getValue().floatValue() * this.layerModel.getComposition().getFrameRate()) - this.layerModel.getComposition().getStartFrame()) / (this.lottieDrawable.getComposition().getDurationFrames() + 0.01f);
    L6:
        if (this.timeRemapping != null) goto L9;
        r5 = r5 - this.layerModel.getStartProgress();
    L9:
        if (this.layerModel.getTimeStretch() != 0.0f) goto L11;
    L13:
        int r1 = this.layers.size() - 1;
    L14:
        if (r1 < 0) goto L16;
        this.layers.get(r1).setProgress(r5);
        r1 = r1 - 1;
        goto L14
    L16:
        L.endSection("CompositionLayer#setProgress");
        return;
    L11:
        if ("__container".equals(this.layerModel.getName()) == true) goto L13;
        r5 = r5 / this.layerModel.getTimeStretch();
        goto L13
    }

    public float getProgress() {
        return this.progress;
    }

    public boolean hasMasks() {
        if (this.hasMasks != null) goto L21;
        int r0 = this.layers.size() - 1;
    L5:
        if (r0 < 0) goto L19;
        BaseLayer r2 = this.layers.get(r0);
        if ((r2 instanceof ShapeLayer) == false) goto L13;
        if (r2.hasMasksOnThisLayer() == false) goto L18;
        this.hasMasks = true;
        return true;
    L18:
        r0 = r0 - 1;
        goto L5
    L13:
        if ((r2 instanceof CompositionLayer) == false) goto L18;
        if (((CompositionLayer) r2).hasMasks() == false) goto L18;
        this.hasMasks = true;
        return true;
    L19:
        this.hasMasks = false;
    L21:
        return this.hasMasks.booleanValue();
    }

    public boolean hasMatte() {
        if (this.hasMatte != null) goto L17;
        if (hasMatteOnThisLayer() == false) goto L8;
        this.hasMatte = true;
        return true;
    L8:
        int r0 = this.layers.size() - 1;
    L9:
        if (r0 < 0) goto L15;
        if (this.layers.get(r0).hasMatteOnThisLayer() == true) goto L12;
        r0 = r0 - 1;
        goto L9
    L12:
        this.hasMatte = true;
        return true;
    L15:
        this.hasMatte = false;
    L17:
        return this.hasMatte.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void resolveChildKeyPath(KeyPath r3, int r4, List<KeyPath> r5, KeyPath r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.layers.size()) goto L6;
        this.layers.get(r0).resolveKeyPath(r3, r4, r5, r6);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        super.addValueCallback(r2, r3);
        if (r2 != LottieProperty.TIME_REMAP) goto L10;
        if (r3 != null) goto L8;
        BaseKeyframeAnimation<Float, Float> r1 = this.timeRemapping;
        if (r1 == null) goto L11;
        r1.setValueCallback(null);
        return;
    L11:
        return;
    L8:
        ValueCallbackKeyframeAnimation r4 = new ValueCallbackKeyframeAnimation(r3);
        this.timeRemapping = r4;
        r4.addUpdateListener(this);
        addAnimation(this.timeRemapping);
        return;
    }
}
