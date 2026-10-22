package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PointF point;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe r1, float r2) {
        return getValue(r1, r2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    protected /* bridge */ /* synthetic */ Object getValue(Keyframe r1, float r2, float r3, float r4) {
        return getValue(r1, r2, r3, r4);
    }

    public PointKeyframeAnimation(List<Keyframe<PointF>> r1) {
        super(r1);
        this.point = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> r1, float r2) {
        return getValue(r1, r2, r2, r2);
    }

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
    protected PointF getValue(Keyframe<PointF> r11, float r12, float r13, float r14) {
        if (r11.startValue == null) goto L14;
        if (r11.endValue == null) goto L14;
        PointF r0 = r11.startValue;
        PointF r9 = r11.endValue;
        if (this.valueCallback == null) goto L11;
        PointF r15 = (PointF) this.valueCallback.getValueInternal(r11.startFrame, r11.endFrame.floatValue(), r0, r9, r12, getLinearCurrentKeyframeProgress(), getProgress());
        if (r15 == null) goto L11;
        return r15;
    L11:
        this.point.set(r0.x + (r13 * (r9.x - r0.x)), r0.y + (r14 * (r9.y - r0.y)));
        return this.point;
    L14:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
