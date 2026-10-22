package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final ShapeKeyframeAnimation shapeAnimation;
    private List<ShapeModifierContent> shapeModifierContents;
    private final CompoundTrimPathContent trimPaths;

    public ShapeContent(LottieDrawable r2, BaseLayer r3, ShapePath r4) {
        this.path = new Path();
        this.trimPaths = new CompoundTrimPathContent();
        this.name = r4.getName();
        this.hidden = r4.isHidden();
        this.lottieDrawable = r2;
        ShapeKeyframeAnimation r5 = r4.getShapePath().createAnimation();
        this.shapeAnimation = r5;
        r3.addAnimation(r5);
        r5.addUpdateListener(this);
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
    public void setContents(List<Content> r6, List<Content> r7) {
        ArrayList r8 = null;
        int r0 = 0;
    L4:
        if (r0 >= r6.size()) goto L16;
        Content r1 = r6.get(r0);
        if ((r1 instanceof TrimPathContent) == false) goto L11;
        TrimPathContent r2 = (TrimPathContent) r1;
        if (r2.getType() != ShapeTrimPath.Type.SIMULTANEOUSLY) goto L11;
        this.trimPaths.addTrimPath(r2);
        r2.addListener(this);
    L15:
        r0 = r0 + 1;
    L11:
        if ((r1 instanceof ShapeModifierContent) == false) goto L15;
        if (r8 != null) goto L14;
        r8 = new ArrayList();
    L14:
        r8.add((ShapeModifierContent) r1);
        goto L15
    L16:
        this.shapeAnimation.setShapeModifiers(r8);
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid == true) goto L5;
        this.path.reset();
        if (this.hidden == false) goto L10;
        this.isPathValid = true;
        return this.path;
    L10:
        Path r0 = this.shapeAnimation.getValue();
        if (r0 == null) goto L13;
        this.path.set(r0);
        this.path.setFillType(Path.FillType.EVEN_ODD);
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    L13:
        return this.path;
    L5:
        return this.path;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }
}
