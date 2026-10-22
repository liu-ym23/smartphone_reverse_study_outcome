package androidx.compose.animation.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.f;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u001ai\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\n\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u0002H\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001¢\u0006\u0002\u0010\u0010\u001aB\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\u000b\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001\u001ak\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00022\b\b\u0002\u0010\u0014\u001a\u0002H\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u0001H\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001¢\u0006\u0002\u0010\u0016\u001aT\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0002*\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001\u001a3\u0010\u0018\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\u0014\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0019\"\u001d\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u001a"}, d2 = {"isFinished", "", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/animation/core/AnimationState;)Z", "AnimationState", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocity", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;JJZ)Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "copy", "value", "velocityVector", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)Landroidx/compose/animation/core/AnimationState;", "velocity", "createZeroVectorFrom", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimationStateKt {
    public static final AnimationState<Float, AnimationVector1D> AnimationState(float f, float f7, long j5, long j6, boolean z10) {
        return new AnimationState<>(VectorConvertersKt.getVectorConverter(f.f4924a), Float.valueOf(f), AnimationVectorsKt.AnimationVector(f7), j5, j6, z10);
    }

    public static /* synthetic */ AnimationState AnimationState$default(float f, float f7, long j5, long j6, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            f7 = 0.0f;
        }
        if ((i & 4) != 0) {
            j5 = Long.MIN_VALUE;
        }
        if ((i & 8) != 0) {
            j6 = Long.MIN_VALUE;
        }
        if ((i & 16) != 0) {
            z10 = false;
        }
        return AnimationState(f, f7, j5, j6, z10);
    }

    public static final <T, V extends AnimationVector> AnimationState<T, V> copy(AnimationState<T, V> animationState, T t9, V v10, long j5, long j6, boolean z10) {
        return new AnimationState<>(animationState.getTypeConverter(), t9, v10, j5, j6, z10);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, Object obj, AnimationVector animationVector, long j5, long j6, boolean z10, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = animationState.getValue();
        }
        if ((i & 2) != 0) {
            animationVector = AnimationVectorsKt.copy(animationState.getVelocityVector());
        }
        if ((i & 4) != 0) {
            j5 = animationState.getLastFrameTimeNanos();
        }
        if ((i & 8) != 0) {
            j6 = animationState.getFinishedTimeNanos();
        }
        if ((i & 16) != 0) {
            z10 = animationState.getIsRunning();
        }
        boolean z11 = z10;
        long j10 = j6;
        return copy((AnimationState<Object, AnimationVector>) animationState, obj, animationVector, j5, j10, z11);
    }

    public static final <T, V extends AnimationVector> V createZeroVectorFrom(TwoWayConverter<T, V> twoWayConverter, T t9) {
        V v10 = (V) twoWayConverter.getConvertToVector().invoke(t9);
        v10.reset$animation_core_release();
        return v10;
    }

    public static final boolean isFinished(AnimationState<?, ?> animationState) {
        return animationState.getFinishedTimeNanos() != Long.MIN_VALUE;
    }

    public static /* synthetic */ AnimationState AnimationState$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, long j5, long j6, boolean z10, int i, Object obj3) {
        if ((i & 8) != 0) {
            j5 = Long.MIN_VALUE;
        }
        if ((i & 16) != 0) {
            j6 = Long.MIN_VALUE;
        }
        if ((i & 32) != 0) {
            z10 = false;
        }
        return AnimationState(twoWayConverter, obj, obj2, j5, j6, z10);
    }

    public static final AnimationState<Float, AnimationVector1D> copy(AnimationState<Float, AnimationVector1D> animationState, float f, float f7, long j5, long j6, boolean z10) {
        return new AnimationState<>(animationState.getTypeConverter(), Float.valueOf(f), AnimationVectorsKt.AnimationVector(f7), j5, j6, z10);
    }

    public static final <T, V extends AnimationVector> AnimationState<T, V> AnimationState(TwoWayConverter<T, V> twoWayConverter, T t9, T t10, long j5, long j6, boolean z10) {
        return new AnimationState<>(twoWayConverter, t9, (AnimationVector) twoWayConverter.getConvertToVector().invoke(t10), j5, j6, z10);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, float f, float f7, long j5, long j6, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = ((Number) animationState.getValue()).floatValue();
        }
        if ((i & 2) != 0) {
            f7 = ((AnimationVector1D) animationState.getVelocityVector()).getValue();
        }
        if ((i & 4) != 0) {
            j5 = animationState.getLastFrameTimeNanos();
        }
        if ((i & 8) != 0) {
            j6 = animationState.getFinishedTimeNanos();
        }
        if ((i & 16) != 0) {
            z10 = animationState.getIsRunning();
        }
        boolean z11 = z10;
        long j10 = j6;
        return copy((AnimationState<Float, AnimationVector1D>) animationState, f, f7, j5, j10, z11);
    }
}
