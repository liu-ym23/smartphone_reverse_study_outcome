package androidx.compose.animation.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\t*\u00020\n*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u00022\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0002\u0010\f\u001aE\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0\u000e\"\b\b\u0000\u0010\t*\u00020\n*\b\u0012\u0004\u0012\u0002H\t0\u000f2\u0006\u0010\u0010\u001a\u0002H\t2\u0006\u0010\u0011\u001a\u0002H\t2\u0006\u0010\u0012\u001a\u0002H\tH\u0007¢\u0006\u0002\u0010\u0013\u001aa\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u000e\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\t*\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\b0\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u00182\u0006\u0010\u0010\u001a\u0002H\b2\u0006\u0010\u0011\u001a\u0002H\b2\u0006\u0010\u0012\u001a\u0002H\b¢\u0006\u0002\u0010\u0019\u001a,\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u0015\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u001c2\b\b\u0002\u0010\u0012\u001a\u00020\u001c\" \u0010\u0000\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"durationMillis", "", "Landroidx/compose/animation/core/Animation;", "getDurationMillis", "(Landroidx/compose/animation/core/Animation;)J", "MillisToNanos", "SecondsToMillis", "getVelocityFromNanos", ExifInterface.GPS_DIRECTION_TRUE, "V", "Landroidx/compose/animation/core/AnimationVector;", "playTimeNanos", "(Landroidx/compose/animation/core/Animation;J)Ljava/lang/Object;", "createAnimation", "Landroidx/compose/animation/core/TargetBasedAnimation;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/TargetBasedAnimation;", "TargetBasedAnimation", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/animation/core/TargetBasedAnimation;", "DecayAnimation", "Landroidx/compose/animation/core/DecayAnimation;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimationKt {
    public static final long MillisToNanos = 1000000;
    public static final long SecondsToMillis = 1000;

    public static /* synthetic */ AnimationVector a(AnimationVector r100) {
        return createAnimation$lambda$0(r100);
    }

    public static /* synthetic */ AnimationVector b(AnimationVector r100) {
        return createAnimation$lambda$1(r100);
    }

    private static final AnimationVector createAnimation$lambda$0(AnimationVector r100) {
        return r100;
    }

    private static final AnimationVector createAnimation$lambda$1(AnimationVector r100) {
        return r100;
    }

    public static final long getDurationMillis(Animation<?, ?> r100) {
        return r100.getDurationNanos() / 1000000;
    }

    public static final <T, V extends AnimationVector> T getVelocityFromNanos(Animation<T, V> r100, long r101) {
        return (T) r100.getTypeConverter().getConvertFromVector().invoke(r100.getVelocityVectorFromNanos(r101));
    }

    public static final DecayAnimation<Float, AnimationVector1D> DecayAnimation(FloatDecayAnimationSpec r100, float r101, float r102) {
        return new DecayAnimation(DecayAnimationSpecKt.generateDecayAnimationSpec(r100), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(r101), AnimationVectorsKt.AnimationVector(r102));
    }

    public static final <V extends AnimationVector> TargetBasedAnimation<V, V> createAnimation(VectorizedAnimationSpec<V> r100, V r101, V r110, V r111) {
        return new TargetBasedAnimation(r100, VectorConvertersKt.TwoWayConverter(new c(), new d()), r101, r110, r111);
    }

    public static /* synthetic */ DecayAnimation DecayAnimation$default(FloatDecayAnimationSpec r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = 0.0f;
    L6:
        return DecayAnimation(r100, r101, r102);
    }

    public static final <T, V extends AnimationVector> TargetBasedAnimation<T, V> TargetBasedAnimation(AnimationSpec<T> r100, TwoWayConverter<T, V> r101, T r102, T r110, T r111) {
        return new TargetBasedAnimation(r100, r101, r102, r110, r101.getConvertToVector().invoke(r111));
    }
}
