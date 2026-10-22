package androidx.compose.animation.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aI\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00012\u0006\u0010\b\u001a\u0002H\u0001¢\u0006\u0002\u0010\t\u001a \u0010\u0000\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\n\u001a&\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004\"\u0004\b\u0000\u0010\u00012\b\b\u0003\u0010\f\u001a\u00020\n2\b\b\u0003\u0010\r\u001a\u00020\n\u001a\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004\"\u0004\b\u0000\u0010\u0001*\u00020\u000f¨\u0006\u0010"}, d2 = {"calculateTargetValue", ExifInterface.GPS_DIRECTION_TRUE, "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocity", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "exponentialDecay", "frictionMultiplier", "absVelocityThreshold", "generateDecayAnimationSpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DecayAnimationSpecKt {
    public static final <T> DecayAnimationSpec<T> generateDecayAnimationSpec(FloatDecayAnimationSpec r100) {
        return new DecayAnimationSpecImpl(r100);
    }

    public static final <T> DecayAnimationSpec<T> exponentialDecay(float r100, float r101) {
        return generateDecayAnimationSpec(new FloatExponentialDecaySpec(r100, r101));
    }

    public static final float calculateTargetValue(DecayAnimationSpec<Float> r100, float r101, float r102) {
        return ((AnimationVector1D) r100.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)).getTargetValue(AnimationVectorsKt.AnimationVector(r101), AnimationVectorsKt.AnimationVector(r102))).getValue();
    }

    public static final <T, V extends AnimationVector> T calculateTargetValue(DecayAnimationSpec<T> r100, TwoWayConverter<T, V> r101, T r102, T r103) {
        AnimationVector r104 = r100.vectorize(r101).getTargetValue(r101.getConvertToVector().invoke(r102), r101.getConvertToVector().invoke(r103));
        return (T) r101.getConvertFromVector().invoke(r104);
    }

    public static /* synthetic */ DecayAnimationSpec exponentialDecay$default(float r100, float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 1.0f;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = 0.1f;
    L9:
        return exponentialDecay(r100, r101);
    }
}
