package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: loaded from: classes.dex */
public class ImageLayer extends BaseLayer {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Rect dst;
    private BaseKeyframeAnimation<Bitmap, Bitmap> imageAnimation;
    private final LottieImageAsset lottieImageAsset;
    private final Paint paint;
    private final Rect src;

    ImageLayer(LottieDrawable r3, Layer r4) {
        super(r3, r4);
        this.paint = new LPaint(3);
        this.src = new Rect();
        this.dst = new Rect();
        this.lottieImageAsset = r3.getLottieImageAssetForId(r4.getRefId());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas r5, Matrix r6, int r7) {
        Bitmap r0 = getBitmap();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRecycled() == false) goto L7;
        return;
    L7:
        if (this.lottieImageAsset == null) goto L20;
        float r1 = Utils.dpScale();
        this.paint.setAlpha(r7);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> r8 = this.colorFilterAnimation;
        if (r8 == null) goto L12;
        this.paint.setColorFilter(r8.getValue());
    L12:
        r5.save();
        r5.concat(r6);
        this.src.set(0, 0, r0.getWidth(), r0.getHeight());
        if (this.lottieDrawable.getMaintainOriginalImageBounds() == false) goto L15;
        this.dst.set(0, 0, (int) (this.lottieImageAsset.getWidth() * r1), (int) (this.lottieImageAsset.getHeight() * r1));
    L16:
        r5.drawBitmap(r0, this.src, this.dst, this.paint);
        r5.restore();
        return;
    L15:
        this.dst.set(0, 0, (int) (r0.getWidth() * r1), (int) (r0.getHeight() * r1));
        goto L16
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r2, Matrix r3, boolean r4) {
        super.getBounds(r2, r3, r4);
        if (this.lottieImageAsset == null) goto L6;
        float r5 = Utils.dpScale();
        r2.set(0.0f, 0.0f, this.lottieImageAsset.getWidth() * r5, this.lottieImageAsset.getHeight() * r5);
        this.boundsMatrix.mapRect(r2);
        return;
    }

    private Bitmap getBitmap() {
        BaseKeyframeAnimation<Bitmap, Bitmap> r0 = this.imageAnimation;
        if (r0 == null) goto L7;
        Bitmap r1 = r0.getValue();
        if (r1 == null) goto L7;
        return r1;
    L7:
        String r2 = this.layerModel.getRefId();
        Bitmap r3 = this.lottieDrawable.getBitmapForId(r2);
        if (r3 == null) goto L10;
        return r3;
    L10:
        LottieImageAsset r4 = this.lottieImageAsset;
        if (r4 != null) goto L13;
        return null;
    L13:
        return r4.getBitmap();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r3, LottieValueCallback<T> r4) {
        super.addValueCallback(r3, r4);
        if (r3 != LottieProperty.COLOR_FILTER) goto L8;
        if (r4 != null) goto L6;
        this.colorFilterAnimation = null;
        return;
    L6:
        this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(r4);
        return;
    L8:
        if (r3 != LottieProperty.IMAGE) goto L15;
        if (r4 != null) goto L11;
        this.imageAnimation = null;
        return;
    L11:
        this.imageAnimation = new ValueCallbackKeyframeAnimation(r4);
        return;
    }
}
