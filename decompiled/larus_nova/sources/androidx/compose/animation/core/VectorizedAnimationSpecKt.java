package androidx.compose.animation.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\b\u001aA\u0010\t\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u00022\u0006\u0010\f\u001a\u0002H\u00022\u0006\u0010\r\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u000e\u001a\u0018\u0010\u000f\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a1\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u0001H\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"getDurationMillis", "", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromMillis", "playTimeMillis", "start", "end", "startVelocity", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "clampPlayTime", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "playTime", "createSpringAnimations", "Landroidx/compose/animation/core/Animations;", "visibilityThreshold", "dampingRatio", "", "stiffness", "(Landroidx/compose/animation/core/AnimationVector;FF)Landroidx/compose/animation/core/Animations;", "EmptyIntArray", "", "EmptyFloatArray", "", "EmptyArcSpline", "Landroidx/compose/animation/core/ArcSpline;", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class VectorizedAnimationSpecKt {
    private static final ArcSpline EmptyArcSpline = null;
    private static final float[] EmptyFloatArray = null;
    private static final int[] EmptyIntArray = null;

    static {
        EmptyIntArray = new int[0];
        EmptyFloatArray = new float[0];
        EmptyArcSpline = new ArcSpline(new int[2], new float[2], new float[][]{new float[2], new float[2]});
    }

    public static final /* synthetic */ ArcSpline access$getEmptyArcSpline$p() {
        return EmptyArcSpline;
    }

    public static final /* synthetic */ float[] access$getEmptyFloatArray$p() {
        return EmptyFloatArray;
    }

    public static final /* synthetic */ int[] access$getEmptyIntArray$p() {
        return EmptyIntArray;
    }

    public static final long clampPlayTime(VectorizedDurationBasedAnimationSpec<?> r100, long r101) {
        long r102 = r101 - ((long) r100.getDelayMillis());
        long r103 = r100.getDurationMillis();
        if (r102 >= 0) goto L6;
        r102 = 0;
    L6:
        if (r102 <= r103) goto L9;
        return r103;
    L9:
        return r102;
    }

    public static final /* synthetic */ Animations access$createSpringAnimations(AnimationVector r100, float r101, float r102) {
        return createSpringAnimations(r100, r101, r102);
    }

    private static final <V extends AnimationVector> Animations createSpringAnimations(final V r100, final float r101, final float r102) {
        if (r100 == null) goto L5;
        return new AnonymousClass1(r100, r101, r102);
    L5:
        return new AnonymousClass2(r101, r102);
    }

    public static final <V extends AnimationVector> long getDurationMillis(VectorizedAnimationSpec<V> r100, V r101, V r102, V r103) {
        return r100.getDurationNanos(r101, r102, r103) / 1000000;
    }

    public static final <V extends AnimationVector> V getValueFromMillis(VectorizedAnimationSpec<V> r100, long r101, V r110, V r111, V r112) {
        return (V) r100.getValueFromNanos(r101 * 1000000, r110, r111, r112);
    }
}
