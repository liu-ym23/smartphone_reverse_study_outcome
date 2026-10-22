package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe r1, float r2) {
        return getValue(r1, r2);
    }

    public TextKeyframeAnimation(List<Keyframe<DocumentData>> r1) {
        super(r1);
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
    DocumentData getValue(Keyframe<DocumentData> r10, float r11) {
        if (this.valueCallback == null) goto L15;
        LottieValueCallback<A> r1 = this.valueCallback;
        float r2 = r10.startFrame;
        if (r10.endFrame != null) goto L7;
        float r0 = Float.MAX_VALUE;
    L8:
        float r3 = r0;
        DocumentData r4 = r10.startValue;
        if (r10.endValue != null) goto L11;
        DocumentData r12 = r10.startValue;
    L13:
        return (DocumentData) r1.getValueInternal(r2, r3, r4, r12, r11, getInterpolatedCurrentKeyframeProgress(), getProgress());
    L11:
        r12 = r10.endValue;
        goto L13
    L7:
        r0 = r10.endFrame.floatValue();
        goto L8
    L15:
        if (r11 != 1.0f) goto L22;
        if (r10.endValue == null) goto L22;
        return r10.endValue;
    L22:
        return r10.startValue;
    }

    public void setStringValueCallback(final LottieValueCallback<String> r4) {
        final LottieFrameInfo r0 = new LottieFrameInfo();
        final DocumentData r1 = new DocumentData();
        super.setValueCallback(new AnonymousClass1(this, r0, r4, r1));
    }
}
