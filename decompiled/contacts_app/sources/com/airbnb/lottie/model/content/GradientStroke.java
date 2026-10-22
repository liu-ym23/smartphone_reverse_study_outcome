package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GradientStroke implements ContentModel {
    private final ShapeStroke.LineCapType capType;
    private final AnimatableFloatValue dashOffset;
    private final AnimatablePointValue endPoint;
    private final AnimatableGradientColorValue gradientColor;
    private final GradientType gradientType;
    private final boolean hidden;
    private final ShapeStroke.LineJoinType joinType;
    private final List<AnimatableFloatValue> lineDashPattern;
    private final float miterLimit;
    private final String name;
    private final AnimatableIntegerValue opacity;
    private final AnimatablePointValue startPoint;
    private final AnimatableFloatValue width;

    public GradientStroke(String r1, GradientType r2, AnimatableGradientColorValue r3, AnimatableIntegerValue r4, AnimatablePointValue r5, AnimatablePointValue r6, AnimatableFloatValue r7, ShapeStroke.LineCapType r8, ShapeStroke.LineJoinType r9, float r10, List<AnimatableFloatValue> r11, AnimatableFloatValue r12, boolean r13) {
        this.name = r1;
        this.gradientType = r2;
        this.gradientColor = r3;
        this.opacity = r4;
        this.startPoint = r5;
        this.endPoint = r6;
        this.width = r7;
        this.capType = r8;
        this.joinType = r9;
        this.miterLimit = r10;
        this.lineDashPattern = r11;
        this.dashOffset = r12;
        this.hidden = r13;
    }

    public String getName() {
        return this.name;
    }

    public GradientType getGradientType() {
        return this.gradientType;
    }

    public AnimatableGradientColorValue getGradientColor() {
        return this.gradientColor;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public AnimatablePointValue getStartPoint() {
        return this.startPoint;
    }

    public AnimatablePointValue getEndPoint() {
        return this.endPoint;
    }

    public AnimatableFloatValue getWidth() {
        return this.width;
    }

    public ShapeStroke.LineCapType getCapType() {
        return this.capType;
    }

    public ShapeStroke.LineJoinType getJoinType() {
        return this.joinType;
    }

    public List<AnimatableFloatValue> getLineDashPattern() {
        return this.lineDashPattern;
    }

    public AnimatableFloatValue getDashOffset() {
        return this.dashOffset;
    }

    public float getMiterLimit() {
        return this.miterLimit;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable r1, LottieComposition r2, BaseLayer r3) {
        return new GradientStrokeContent(r1, r3, this);
    }
}
