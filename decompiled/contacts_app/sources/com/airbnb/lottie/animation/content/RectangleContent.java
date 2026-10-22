package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {
    private final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final RectF rect;
    private BaseKeyframeAnimation<Float, Float> roundedCornersAnimation;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private final CompoundTrimPathContent trimPaths;

    public RectangleContent(LottieDrawable r2, BaseLayer r3, RectangleShape r4) {
        this.path = new Path();
        this.rect = new RectF();
        this.trimPaths = new CompoundTrimPathContent();
        this.roundedCornersAnimation = null;
        this.name = r4.getName();
        this.hidden = r4.isHidden();
        this.lottieDrawable = r2;
        BaseKeyframeAnimation<PointF, PointF> r5 = r4.getPosition().createAnimation();
        this.positionAnimation = r5;
        BaseKeyframeAnimation<PointF, PointF> r0 = r4.getSize().createAnimation();
        this.sizeAnimation = r0;
        BaseKeyframeAnimation<Float, Float> r6 = r4.getCornerRadius().createAnimation();
        this.cornerRadiusAnimation = r6;
        r3.addAnimation(r5);
        r3.addAnimation(r0);
        r3.addAnimation(r6);
        r5.addUpdateListener(this);
        r0.addUpdateListener(this);
        r6.addUpdateListener(this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
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
    public void setContents(List<Content> r5, List<Content> r6) {
        int r7 = 0;
    L4:
        if (r7 >= r5.size()) goto L14;
        Content r0 = r5.get(r7);
        if ((r0 instanceof TrimPathContent) == false) goto L11;
        TrimPathContent r1 = (TrimPathContent) r0;
        if (r1.getType() != ShapeTrimPath.Type.SIMULTANEOUSLY) goto L11;
        this.trimPaths.addTrimPath(r1);
        r1.addListener(this);
    L13:
        r7 = r7 + 1;
    L11:
        if ((r0 instanceof RoundedCornersContent) == false) goto L13;
        this.roundedCornersAnimation = ((RoundedCornersContent) r0).getRoundedCorners();
        goto L13
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid == true) goto L5;
        this.path.reset();
        if (this.hidden == false) goto L10;
        this.isPathValid = true;
        return this.path;
    L10:
        PointF r0 = this.sizeAnimation.getValue();
        float r2 = r0.x / 2.0f;
        float r1 = r0.y / 2.0f;
        BaseKeyframeAnimation<?, Float> r4 = this.cornerRadiusAnimation;
        if (r4 != null) goto L13;
        float r5 = 0.0f;
    L15:
        if (r5 != 0.0f) goto L19;
        BaseKeyframeAnimation<Float, Float> r6 = this.roundedCornersAnimation;
        if (r6 == null) goto L19;
        r5 = Math.min(r6.getValue().floatValue(), Math.min(r2, r1));
    L19:
        float r7 = Math.min(r2, r1);
        if (r5 <= r7) goto L22;
        r5 = r7;
    L22:
        PointF r8 = this.positionAnimation.getValue();
        this.path.moveTo(r8.x + r2, (r8.y - r1) + r5);
        this.path.lineTo(r8.x + r2, (r8.y + r1) - r5);
        if (r5 <= 0.0f) goto L25;
        float r12 = r5 * 2.0f;
        this.rect.set((r8.x + r2) - r12, (r8.y + r1) - r12, r8.x + r2, r8.y + r1);
        this.path.arcTo(this.rect, 0.0f, 90.0f, false);
    L25:
        this.path.lineTo((r8.x - r2) + r5, r8.y + r1);
        if (r5 <= 0.0f) goto L28;
        float r13 = r5 * 2.0f;
        this.rect.set(r8.x - r2, (r8.y + r1) - r13, (r8.x - r2) + r13, r8.y + r1);
        this.path.arcTo(this.rect, 90.0f, 90.0f, false);
    L28:
        this.path.lineTo(r8.x - r2, (r8.y - r1) + r5);
        if (r5 <= 0.0f) goto L31;
        float r14 = r5 * 2.0f;
        this.rect.set(r8.x - r2, r8.y - r1, (r8.x - r2) + r14, (r8.y - r1) + r14);
        this.path.arcTo(this.rect, 180.0f, 90.0f, false);
    L31:
        this.path.lineTo((r8.x + r2) - r5, r8.y - r1);
        if (r5 <= 0.0f) goto L34;
        float r9 = r5 * 2.0f;
        this.rect.set((r8.x + r2) - r9, r8.y - r1, r8.x + r2, (r8.y - r1) + r9);
        this.path.arcTo(this.rect, 270.0f, 90.0f, false);
    L34:
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    L13:
        r5 = ((FloatKeyframeAnimation) r4).getFloatValue();
        goto L15
    L5:
        return this.path;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        MiscUtils.resolveKeyPath(r1, r2, r3, r4, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        if (r2 != LottieProperty.RECTANGLE_SIZE) goto L6;
        this.sizeAnimation.setValueCallback(r3);
        return;
    L6:
        if (r2 != LottieProperty.POSITION) goto L9;
        this.positionAnimation.setValueCallback(r3);
        return;
    L9:
        if (r2 != LottieProperty.CORNER_RADIUS) goto L14;
        this.cornerRadiusAnimation.setValueCallback(r3);
        return;
    }
}
