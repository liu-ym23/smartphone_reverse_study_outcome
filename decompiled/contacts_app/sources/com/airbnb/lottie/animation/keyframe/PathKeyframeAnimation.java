package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PathMeasure pathMeasure;
    private PathKeyframe pathMeasureKeyframe;
    private final PointF point;
    private final float[] pos;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe r1, float r2) {
        return getValue(r1, r2);
    }

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> r1) {
        super(r1);
        this.point = new PointF();
        this.pos = new float[2];
        this.pathMeasure = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> r11, float r12) {
        PathKeyframe r0 = (PathKeyframe) r11;
        Path r1 = r0.getPath();
        if (r1 != null) goto L7;
        return r11.startValue;
    L7:
        if (this.valueCallback == null) goto L12;
        PointF r13 = (PointF) this.valueCallback.getValueInternal(r0.startFrame, r0.endFrame.floatValue(), (PointF) r0.startValue, (PointF) r0.endValue, getLinearCurrentKeyframeProgress(), r12, getProgress());
        if (r13 == null) goto L12;
        return r13;
    L12:
        if (this.pathMeasureKeyframe == r0) goto L14;
        this.pathMeasure.setPath(r1, false);
        this.pathMeasureKeyframe = r0;
    L14:
        PathMeasure r14 = this.pathMeasure;
        r14.getPosTan(r12 * r14.getLength(), this.pos, null);
        PointF r15 = this.point;
        float[] r16 = this.pos;
        r15.set(r16[0], r16[1]);
        return this.point;
    }
}
