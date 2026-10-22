package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J-\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010)J-\u0010*\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010)J\u0010\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0018\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\f\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010\u001e\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u001f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u00060"}, d2 = {"Landroidx/compose/animation/core/VectorizedMonoSplineKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "timestamps", "Landroidx/collection/IntList;", "keyframes", "Landroidx/collection/IntObjectMap;", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "", "delayMillis", "periodicBias", "", "<init>", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IIF)V", "getDurationMillis", "()I", "getDelayMillis", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "times", "", "monoSpline", "Landroidx/compose/animation/core/MonoSpline;", "values", "", "[[F", "lastInitialValue", "lastTargetValue", "init", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "getValueFromNanos", "playTimeNanos", "", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getEasing", "index", "getEasedTimeFromIndex", "timeMillis", "findEntryForTimeMillis", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorizedMonoSplineKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final IntObjectMap<Pair<V, Easing>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private MonoSpline monoSpline;
    private final float periodicBias;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private float[][] values;
    private V velocityVector;

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ long getDurationNanos(AnimationVector r100, AnimationVector r101, AnimationVector r102) {
        return VectorizedDurationBasedAnimationSpec.CC.$default$getDurationNanos(this, r100, r101, r102);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ AnimationVector getEndVelocity(AnimationVector r100, AnimationVector r101, AnimationVector r102) {
        return VectorizedAnimationSpec.CC.$default$getEndVelocity(this, r100, r101, r102);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    private final int findEntryForTimeMillis(int r100) {
        int r101 = IntList.binarySearch$default(this.timestamps, r100, 0, 0, 6, null);
        if (r101 < (-1)) goto L5;
        return r101;
    L5:
        return -(r101 + 2);
    }

    private final Easing getEasing(int r100) {
        int r101 = this.timestamps.get(r100);
        Pair<V, Easing> r102 = this.keyframes.get(r101);
        if (r102 == null) goto L7;
        Easing r103 = r102.getSecond();
        if (r103 == null) goto L7;
        return r103;
    L7:
        return EasingKt.getLinearEasing();
    }

    private final float getEasedTimeFromIndex(int r100, int r101) {
        IntList r102 = this.timestamps;
        if (r100 < (r102._size - 1)) goto L7;
        float r103 = r101;
    L6:
        return r103 / 1000;
    L7:
        int r104 = r102.get(r100);
        int r105 = this.timestamps.get(r100 + 1);
        if (r101 != r104) goto L10;
        r103 = r104;
        goto L6
    L10:
        float r106 = r105 - r104;
        return ((r106 * getEasing(r100).transform((r101 - r104) / r106)) + r104) / 1000;
    }

    private final void init(V r110, V r111, V r112) {
        int r100 = 0;
        if (this.valueVector != null) goto L9;
        this.valueVector = (V) AnimationVectorsKt.newInstance(r110);
        this.velocityVector = (V) AnimationVectorsKt.newInstance(r112);
        int r113 = this.timestamps._size;
        float[] r101 = new float[r113];
        int r102 = 0;
    L5:
        if (r102 >= r113) goto L7;
        r101[r102] = this.timestamps.get(r102) / 1000;
        r102 = r102 + 1;
        goto L5
    L7:
        this.times = r101;
    L9:
        if (this.monoSpline != null) goto L11;
    L14:
        boolean r114 = !Intrinsics.areEqual(this.lastInitialValue, r110);
        boolean r103 = !Intrinsics.areEqual(this.lastTargetValue, r111);
        this.lastInitialValue = r110;
        this.lastTargetValue = r111;
        int r104 = r110.getSize$animation_core();
        float[][] r105 = this.values;
        if (r105 != null) goto L36;
        int r115 = this.timestamps._size;
        r105 = new float[r115][];
        int r106 = 0;
    L17:
        if (r106 >= r115) goto L35;
        int r107 = this.timestamps.get(r106);
        Pair<V, Easing> r108 = this.keyframes.get(r107);
        if (r107 != 0) goto L25;
        if (r108 != null) goto L25;
        float[] r109 = new float[r104];
        int r116 = 0;
    L22:
        if (r116 >= r104) goto L34;
        r109[r116] = r110.get$animation_core(r116);
        r116 = r116 + 1;
    L34:
        r105[r106] = r109;
        r106 = r106 + 1;
    L25:
        if (r107 != getDurationMillis()) goto L30;
        if (r108 != null) goto L30;
        r109 = new float[r104];
        int r117 = 0;
    L28:
        if (r117 >= r104) goto L34;
        r109[r117] = r111.get$animation_core(r117);
        r117 = r117 + 1;
    L30:
        Intrinsics.checkNotNull(r108);
        V r118 = r108.getFirst();
        float[] r119 = new float[r104];
        int r120 = 0;
    L31:
        if (r120 >= r104) goto L33;
        r119[r120] = r118.get$animation_core(r120);
        r120 = r120 + 1;
        goto L31
    L33:
        r109 = r119;
        goto L34
    L35:
        this.values = r105;
    L50:
        float[] r121 = this.times;
        if (r121 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("times");
        r121 = null;
    L53:
        this.monoSpline = new MonoSpline(r121, r105, this.periodicBias);
        return;
    L36:
        if (r114 == true) goto L38;
    L43:
        if (r103 == false) goto L50;
        if (this.keyframes.containsKey(getDurationMillis()) == true) goto L50;
        int r122 = IntList.binarySearch$default(this.timestamps, getDurationMillis(), 0, 0, 6, null);
        float[] r123 = new float[r104];
    L47:
        if (r100 >= r104) goto L49;
        r123[r100] = r111.get$animation_core(r100);
        r100 = r100 + 1;
        goto L47
    L49:
        r105[r122] = r123;
        goto L50
    L38:
        if (this.keyframes.containsKey(0) == true) goto L43;
        int r124 = IntList.binarySearch$default(this.timestamps, 0, 0, 0, 6, null);
        float[] r125 = new float[r104];
        int r126 = 0;
    L40:
        if (r126 >= r104) goto L42;
        r125[r126] = r110.get$animation_core(r126);
        r126 = r126 + 1;
        goto L40
    L42:
        r105[r124] = r125;
        goto L43
    L11:
        if (Intrinsics.areEqual(this.lastInitialValue, r110) == false) goto L14;
        if (Intrinsics.areEqual(this.lastTargetValue, r111) == false) goto L14;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long r100, V r101, V r102, V r103) {
        int r104 = (int) VectorizedAnimationSpecKt.clampPlayTime(this, r100 / 1000000);
        Pair<V, Easing> r105 = this.keyframes.get(r104);
        if (r105 == null) goto L7;
        return r105.getFirst();
    L7:
        if (r104 < getDurationMillis()) goto L9;
        return r102;
    L9:
        if (r104 > 0) goto L11;
        return r101;
    L11:
        init(r101, r102, r103);
        int r106 = findEntryForTimeMillis(r104);
        V r107 = this.valueVector;
        Intrinsics.checkNotNull(r107);
        MonoSpline r108 = this.monoSpline;
        Intrinsics.checkNotNull(r108);
        r108.getPos(getEasedTimeFromIndex(r106, r104), r107, r106);
        return r107;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long r100, V r101, V r102, V r103) {
        int r104 = (int) VectorizedAnimationSpecKt.clampPlayTime(this, r100 / 1000000);
        init(r101, r102, r103);
        int r105 = findEntryForTimeMillis(r104);
        V r106 = this.velocityVector;
        Intrinsics.checkNotNull(r106);
        MonoSpline r107 = this.monoSpline;
        Intrinsics.checkNotNull(r107);
        r107.getSlope(getEasedTimeFromIndex(r105, r104), r106, r105);
        return r106;
    }

    public VectorizedMonoSplineKeyframesSpec(IntList r100, IntObjectMap<Pair<V, Easing>> r101, int r102, int r103, float r104) {
        this.timestamps = r100;
        this.keyframes = r101;
        this.durationMillis = r102;
        this.delayMillis = r103;
        this.periodicBias = r104;
    }
}
