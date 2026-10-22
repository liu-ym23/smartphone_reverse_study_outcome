package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.animation.content.ShapeModifierContent;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
    private List<ShapeModifierContent> shapeModifiers;
    private final Path tempPath;
    private final ShapeData tempShapeData;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Path getValue(Keyframe<ShapeData> r1, float r2) {
        return getValue(r1, r2);
    }

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> r1) {
        super(r1);
        this.tempShapeData = new ShapeData();
        this.tempPath = new Path();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Path getValue(Keyframe<ShapeData> r3, float r4) {
        this.tempShapeData.interpolateBetween(r3.startValue, r3.endValue, r4);
        ShapeData r5 = this.tempShapeData;
        List<ShapeModifierContent> r6 = this.shapeModifiers;
        if (r6 == null) goto L7;
        int r7 = r6.size() - 1;
    L5:
        if (r7 < 0) goto L7;
        r5 = this.shapeModifiers.get(r7).modifyShape(r5);
        r7 = r7 - 1;
    L7:
        MiscUtils.getPathFromData(r5, this.tempPath);
        return this.tempPath;
    }

    public void setShapeModifiers(List<ShapeModifierContent> r1) {
        this.shapeModifiers = r1;
    }
}
