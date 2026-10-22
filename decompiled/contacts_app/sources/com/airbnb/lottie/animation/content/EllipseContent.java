package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float ELLIPSE_CONTROL_POINT_PERCENTAGE = 0.55228f;
    private final CircleShape circleShape;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private final CompoundTrimPathContent trimPaths;

    public EllipseContent(LottieDrawable r2, BaseLayer r3, CircleShape r4) {
        this.path = new Path();
        this.trimPaths = new CompoundTrimPathContent();
        this.name = r4.getName();
        this.lottieDrawable = r2;
        BaseKeyframeAnimation<PointF, PointF> r5 = r4.getSize().createAnimation();
        this.sizeAnimation = r5;
        BaseKeyframeAnimation<PointF, PointF> r0 = r4.getPosition().createAnimation();
        this.positionAnimation = r0;
        this.circleShape = r4;
        r3.addAnimation(r5);
        r3.addAnimation(r0);
        r5.addUpdateListener(this);
        r0.addUpdateListener(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r4, List<Content> r5) {
        int r6 = 0;
    L4:
        if (r6 >= r4.size()) goto L11;
        Content r0 = r4.get(r6);
        if ((r0 instanceof TrimPathContent) == false) goto L10;
        TrimPathContent r1 = (TrimPathContent) r0;
        if (r1.getType() != ShapeTrimPath.Type.SIMULTANEOUSLY) goto L10;
        this.trimPaths.addTrimPath(r1);
        r1.addListener(this);
    L10:
        r6 = r6 + 1;
        goto L4
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid == true) goto L5;
        this.path.reset();
        if (this.circleShape.isHidden() == false) goto L10;
        this.isPathValid = true;
        return this.path;
    L10:
        PointF r1 = this.sizeAnimation.getValue();
        float r3 = r1.x / 2.0f;
        float r2 = r1.y / 2.0f;
        float r12 = r3 * ELLIPSE_CONTROL_POINT_PERCENTAGE;
        float r4 = ELLIPSE_CONTROL_POINT_PERCENTAGE * r2;
        this.path.reset();
        if (this.circleShape.isReversed() == false) goto L13;
        float r11 = -r2;
        this.path.moveTo(0.0f, r11);
        float r8 = 0.0f - r12;
        float r6 = -r3;
        float r21 = 0.0f - r4;
        this.path.cubicTo(r8, r11, r6, r21, r6, 0.0f);
        float r5 = r4 + 0.0f;
        this.path.cubicTo(r6, r5, r8, r2, 0.0f, r2);
        float r13 = r12 + 0.0f;
        this.path.cubicTo(r13, r2, r3, r5, r3, 0.0f);
        this.path.cubicTo(r3, r21, r13, r11, 0.0f, r11);
    L14:
        PointF r7 = this.positionAnimation.getValue();
        this.path.offset(r7.x, r7.y);
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    L13:
        float r15 = -r2;
        this.path.moveTo(0.0f, r15);
        float r14 = r12 + 0.0f;
        float r16 = 0.0f - r4;
        this.path.cubicTo(r14, r15, r3, r16, r3, 0.0f);
        float r9 = r4 + 0.0f;
        this.path.cubicTo(r3, r9, r14, r2, 0.0f, r2);
        float r17 = 0.0f - r12;
        float r10 = -r3;
        this.path.cubicTo(r17, r2, r10, r9, r10, 0.0f);
        this.path.cubicTo(r10, r16, r17, r15, 0.0f, r15);
        goto L14
    L5:
        return this.path;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        MiscUtils.resolveKeyPath(r1, r2, r3, r4, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        if (r2 != LottieProperty.ELLIPSE_SIZE) goto L6;
        this.sizeAnimation.setValueCallback(r3);
        return;
    L6:
        if (r2 != LottieProperty.POSITION) goto L10;
        this.positionAnimation.setValueCallback(r3);
        return;
    }
}
