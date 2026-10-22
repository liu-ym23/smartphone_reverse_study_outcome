package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor, GradientColor> {
    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ List getKeyframes() {
        return super.getKeyframes();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ boolean isStatic() {
        return super.isStatic();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableGradientColorValue(List<Keyframe<GradientColor>> r1) {
        super(ensureInterpolatableKeyframes(r1));
    }

    private static List<Keyframe<GradientColor>> ensureInterpolatableKeyframes(List<Keyframe<GradientColor>> r2) {
        int r0 = 0;
    L4:
        if (r0 >= r2.size()) goto L6;
        r2.set(r0, ensureInterpolatableKeyframe(r2.get(r0)));
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }

    private static Keyframe<GradientColor> ensureInterpolatableKeyframe(Keyframe<GradientColor> r4) {
        GradientColor r0 = r4.startValue;
        GradientColor r1 = r4.endValue;
        if (r0 == null) goto L10;
        if (r1 != null) goto L6;
        return r4;
    L6:
        if (r0.getPositions().length == r1.getPositions().length) goto L12;
        float[] r2 = mergePositions(r0.getPositions(), r1.getPositions());
        return r4.copyWith(r0.copyWithPositions(r2), r1.copyWithPositions(r2));
    L12:
        return r4;
    L10:
        return r4;
    }

    static float[] mergePositions(float[] r6, float[] r7) {
        int r0 = r6.length + r7.length;
        float[] r1 = new float[r0];
        System.arraycopy(r6, 0, r1, 0, r6.length);
        System.arraycopy(r7, 0, r1, r6.length, r7.length);
        Arrays.sort(r1);
        float r8 = Float.NaN;
        int r9 = 0;
        int r2 = 0;
    L3:
        if (r9 >= r0) goto L9;
        float r4 = r1[r9];
        if (r4 == r8) goto L7;
        r1[r2] = r4;
        r2 = r2 + 1;
        r8 = r1[r9];
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return Arrays.copyOfRange(r1, 0, r2);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation() {
        return new GradientColorKeyframeAnimation(this.keyframes);
    }
}
