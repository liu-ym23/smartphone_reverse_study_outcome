package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShapeLayer extends BaseLayer {
    private final CompositionLayer compositionLayer;
    private final ContentGroup contentGroup;

    ShapeLayer(LottieDrawable r3, Layer r4, CompositionLayer r5, LottieComposition r6) {
        super(r3, r4);
        this.compositionLayer = r5;
        ContentGroup r7 = new ContentGroup(r3, this, new ShapeGroup("__container", r4.getShapes(), false), r6);
        this.contentGroup = r7;
        r7.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas r1, Matrix r2, int r3) {
        this.contentGroup.draw(r1, r2, r3);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r1, Matrix r2, boolean r3) {
        super.getBounds(r1, r2, r3);
        this.contentGroup.getBounds(r1, this.boundsMatrix, r3);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public BlurEffect getBlurEffect() {
        BlurEffect r0 = super.getBlurEffect();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.compositionLayer.getBlurEffect();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public DropShadowEffect getDropShadowEffect() {
        DropShadowEffect r0 = super.getDropShadowEffect();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.compositionLayer.getDropShadowEffect();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void resolveChildKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        this.contentGroup.resolveKeyPath(r1, r2, r3, r4);
    }
}
