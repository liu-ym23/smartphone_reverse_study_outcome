package androidx.compose.animation.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J(\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/FloatAnimationSpec;", "Landroidx/compose/animation/core/AnimationSpec;", "", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "getVelocityFromNanos", "getEndVelocity", "getDurationNanos", "vectorize", "Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FloatAnimationSpec extends AnimationSpec<Float> {

    /* JADX INFO: renamed from: androidx.compose.animation.core.FloatAnimationSpec$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$vectorize, reason: collision with other method in class */
        public static VectorizedFloatAnimationSpec m155$default$vectorize(FloatAnimationSpec r100, TwoWayConverter r101) {
            return new VectorizedFloatAnimationSpec(r100);
        }

        public static /* synthetic */ VectorizedFloatAnimationSpec access$vectorize$jd(FloatAnimationSpec r100, TwoWayConverter r101) {
            return m155$default$vectorize(r100, r101);
        }

        public static /* bridge */ /* synthetic */ VectorizedAnimationSpec $default$vectorize(FloatAnimationSpec r100, TwoWayConverter r101) {
            return r100.vectorize(r101);
        }

        public static float $default$getEndVelocity(FloatAnimationSpec r100, float r101, float r102, float r103) {
            return r100.getVelocityFromNanos(r100.getDurationNanos(r101, r102, r103), r101, r102, r103);
        }

        public static /* synthetic */ float access$getEndVelocity$jd(FloatAnimationSpec r100, float r101, float r102, float r103) {
            return $default$getEndVelocity(r100, r101, r102, r103);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(FloatAnimationSpec r100, TwoWayConverter<Float, V> r101) {
            return CC.access$vectorize$jd(r100, r101);
        }

        public static float getEndVelocity(FloatAnimationSpec r100, float r101, float r102, float r103) {
            return CC.access$getEndVelocity$jd(r100, r101, r102, r103);
        }
    }

    long getDurationNanos(float r100, float r101, float r102);

    float getEndVelocity(float r100, float r101, float r102);

    float getValueFromNanos(long r100, float r101, float r102, float r103);

    float getVelocityFromNanos(long r100, float r101, float r102, float r103);

    @Override // androidx.compose.animation.core.AnimationSpec
    /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter r100);

    @Override // androidx.compose.animation.core.AnimationSpec
    <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(TwoWayConverter<Float, V> r100);
}
