package androidx.compose.animation.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ak\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00022\b\b\u0002\u0010\b\u001a\u0002H\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u0001H\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0001¢\u0006\u0002\u0010\u000e\u001aT\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0002*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00022\b\b\u0002\u0010\b\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0001\u001aB\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0001\u001ai\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00162\u0006\u0010\u0013\u001a\u0002H\u00052\u0006\u0010\u0014\u001a\u0002H\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0001¢\u0006\u0002\u0010\u0017\u001a3\u0010\u0018\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00162\u0006\u0010\b\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0019\"\u001d\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u001a"}, d2 = {"isFinished", "", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/animation/core/AnimationState;)Z", "copy", ExifInterface.GPS_DIRECTION_TRUE, "V", "Landroidx/compose/animation/core/AnimationVector;", "value", "velocityVector", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "velocity", "AnimationState", "initialValue", "initialVelocity", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;JJZ)Landroidx/compose/animation/core/AnimationState;", "createZeroVectorFrom", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimationStateKt {
    public static final boolean isFinished(AnimationState<?, ?> r100) {
        if (r100.getFinishedTimeNanos() == Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T, V extends AnimationVector> V createZeroVectorFrom(TwoWayConverter<T, V> r100, T r101) {
        V r102 = r100.getConvertToVector().invoke(r101);
        r102.reset$animation_core();
        return r102;
    }

    public static final AnimationState<Float, AnimationVector1D> AnimationState(float r110, float r111, long r112, long r113, boolean r114) {
        return new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(r110), AnimationVectorsKt.AnimationVector(r111), r112, r113, r114);
    }

    public static final <T, V extends AnimationVector> AnimationState<T, V> AnimationState(TwoWayConverter<T, V> r110, T r111, T r112, long r113, long r114, boolean r115) {
        return new AnimationState(r110, r111, r110.getConvertToVector().invoke(r112), r113, r114, r115);
    }

    public static final AnimationState<Float, AnimationVector1D> copy(AnimationState<Float, AnimationVector1D> r110, float r111, float r112, long r113, long r114, boolean r115) {
        return new AnimationState(r110.getTypeConverter(), Float.valueOf(r111), AnimationVectorsKt.AnimationVector(r112), r113, r114, r115);
    }

    public static final <T, V extends AnimationVector> AnimationState<T, V> copy(AnimationState<T, V> r110, T r111, V r112, long r113, long r114, boolean r115) {
        return new AnimationState(r110.getTypeConverter(), r111, r112, r113, r114, r115);
    }

    public static /* synthetic */ AnimationState AnimationState$default(float r100, float r101, long r102, long r103, boolean r110, int r111, Object r112) {
        if ((r111 & 2) == 0) goto L5;
        r101 = 0.0f;
    L5:
        long r104 = Long.MIN_VALUE;
        if ((r111 & 4) == 0) goto L8;
        long r105 = Long.MIN_VALUE;
    L10:
        if ((r111 & 8) != 0) goto L14;
        r104 = r103;
    L14:
        if ((r111 & 16) == 0) goto L16;
        boolean r113 = false;
    L18:
        return AnimationState(r100, r101, r105, r104, r113);
    L16:
        r113 = r110;
        goto L18
    L8:
        r105 = r102;
        goto L10
    }

    public static /* synthetic */ AnimationState AnimationState$default(TwoWayConverter r110, Object r111, Object r112, long r113, long r114, boolean r115, int r116, Object r210) {
        if ((r116 & 8) == 0) goto L5;
        long r100 = Long.MIN_VALUE;
    L7:
        if ((r116 & 16) == 0) goto L9;
        long r101 = Long.MIN_VALUE;
    L11:
        if ((r116 & 32) == 0) goto L13;
        boolean r117 = false;
    L15:
        return AnimationState(r110, r111, r112, r100, r101, r117);
    L13:
        r117 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState r100, float r101, float r102, long r103, long r110, boolean r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = ((Number) r100.getValue()).floatValue();
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = ((AnimationVector1D) r100.getVelocityVector()).getValue();
    L8:
        float r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.getLastFrameTimeNanos();
    L11:
        long r104 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.getFinishedTimeNanos();
    L14:
        long r105 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.isRunning();
    L17:
        float r106 = r101;
        return copy(r100, r106, r114, r104, r105, r111);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState r100, Object r101, AnimationVector r102, long r103, long r110, boolean r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.getValue();
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = AnimationVectorsKt.copy(r100.getVelocityVector());
    L8:
        AnimationVector r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.getLastFrameTimeNanos();
    L11:
        long r104 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.getFinishedTimeNanos();
    L14:
        long r105 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.isRunning();
    L17:
        Object r106 = r101;
        return copy(r100, r106, r114, r104, r105, r111);
    }
}
