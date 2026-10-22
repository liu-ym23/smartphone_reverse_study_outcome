package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BA\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010!\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b!\u0010\"J/\u0010#\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b#\u0010\"R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R&\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010%R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\f\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b)\u0010(R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010*R\u0016\u0010+\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020.048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010,R\u0018\u00108\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010,¨\u00069"}, d2 = {"Landroidx/compose/animation/core/VectorizedMonoSplineKeyframesSpec;", "Landroidx/compose/animation/core/AnimationVector;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "Landroidx/collection/IntList;", "timestamps", "Landroidx/collection/IntObjectMap;", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "keyframes", "", "durationMillis", "delayMillis", "", "periodicBias", AppAgent.CONSTRUCT, "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IIF)V", "initialValue", "targetValue", "initialVelocity", "LC7/r;", "init", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "index", "getEasing", "(I)Landroidx/compose/animation/core/Easing;", "timeMillis", "getEasedTimeFromIndex", "(II)F", "findEntryForTimeMillis", "(I)I", "", "playTimeNanos", "getValueFromNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "Landroidx/collection/IntList;", "Landroidx/collection/IntObjectMap;", "I", "getDurationMillis", "()I", "getDelayMillis", "F", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "", "times", "[F", "Landroidx/compose/animation/core/MonoSpline;", "monoSpline", "Landroidx/compose/animation/core/MonoSpline;", "", "values", "[[F", "lastInitialValue", "lastTargetValue", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalAnimationSpecApi
/* loaded from: classes.dex */
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

    public VectorizedMonoSplineKeyframesSpec(IntList intList, IntObjectMap<Pair<V, Easing>> intObjectMap, int i, int i6, float f) {
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i;
        this.delayMillis = i6;
        this.periodicBias = f;
    }

    private final int findEntryForTimeMillis(int timeMillis) {
        int iBinarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, timeMillis, 0, 0, 6, null);
        return iBinarySearch$default < -1 ? -(iBinarySearch$default + 2) : iBinarySearch$default;
    }

    private final float getEasedTimeFromIndex(int index, int timeMillis) {
        float fTransform;
        IntList intList = this.timestamps;
        if (index >= intList._size - 1) {
            fTransform = timeMillis;
        } else {
            int i = intList.get(index);
            int i6 = this.timestamps.get(index + 1);
            if (timeMillis == i) {
                fTransform = i;
            } else {
                Easing easing = getEasing(index);
                float f = timeMillis - i;
                float f7 = i6 - i;
                fTransform = (easing.transform(f / f7) * f7) + i;
            }
        }
        return fTransform / 1000;
    }

    private final Easing getEasing(int index) {
        Easing easing;
        Pair<V, Easing> pair = this.keyframes.get(this.timestamps.get(index));
        return (pair == null || (easing = (Easing) pair.b) == null) ? EasingKt.getLinearEasing() : easing;
    }

    private final void init(V initialValue, V targetValue, V initialVelocity) {
        float[] fArr;
        float[] fArr2;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(initialValue);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(initialVelocity);
            int size = this.timestamps.getSize();
            float[] fArr3 = new float[size];
            for (int i = 0; i < size; i++) {
                fArr3[i] = this.timestamps.get(i) / 1000;
            }
            this.times = fArr3;
        }
        if (this.monoSpline != null && k.b(this.lastInitialValue, initialValue) && k.b(this.lastTargetValue, targetValue)) {
            return;
        }
        boolean zB = k.b(this.lastInitialValue, initialValue);
        boolean zB2 = k.b(this.lastTargetValue, targetValue);
        this.lastInitialValue = initialValue;
        this.lastTargetValue = targetValue;
        int size2 = initialValue.getSize();
        if (this.values == null) {
            int size3 = this.timestamps.getSize();
            float[][] fArr4 = new float[size3][];
            for (int i6 = 0; i6 < size3; i6++) {
                int i10 = this.timestamps.get(i6);
                if (i10 != 0) {
                    if (i10 != getDurationMillis()) {
                        fArr = new float[size2];
                        Pair<V, Easing> pair = this.keyframes.get(i10);
                        k.c(pair);
                        AnimationVector animationVector = (AnimationVector) pair.f4886a;
                        for (int i11 = 0; i11 < size2; i11++) {
                            fArr[i11] = animationVector.get$animation_core_release(i11);
                        }
                    } else if (this.keyframes.contains(i10)) {
                        fArr = new float[size2];
                        Pair<V, Easing> pair2 = this.keyframes.get(i10);
                        k.c(pair2);
                        AnimationVector animationVector2 = (AnimationVector) pair2.f4886a;
                        for (int i12 = 0; i12 < size2; i12++) {
                            fArr[i12] = animationVector2.get$animation_core_release(i12);
                        }
                    } else {
                        fArr2 = new float[size2];
                        for (int i13 = 0; i13 < size2; i13++) {
                            fArr2[i13] = targetValue.get$animation_core_release(i13);
                        }
                    }
                    fArr2 = fArr;
                } else if (this.keyframes.contains(i10)) {
                    fArr = new float[size2];
                    Pair<V, Easing> pair3 = this.keyframes.get(i10);
                    k.c(pair3);
                    AnimationVector animationVector3 = (AnimationVector) pair3.f4886a;
                    for (int i14 = 0; i14 < size2; i14++) {
                        fArr[i14] = animationVector3.get$animation_core_release(i14);
                    }
                    fArr2 = fArr;
                } else {
                    fArr2 = new float[size2];
                    for (int i15 = 0; i15 < size2; i15++) {
                        fArr2[i15] = initialValue.get$animation_core_release(i15);
                    }
                }
                fArr4[i6] = fArr2;
            }
            this.values = fArr4;
        } else {
            if (!zB && !this.keyframes.contains(0)) {
                float[][] fArr5 = this.values;
                if (fArr5 == null) {
                    k.n("values");
                    throw null;
                }
                int iBinarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, 0, 0, 0, 6, null);
                float[] fArr6 = new float[size2];
                for (int i16 = 0; i16 < size2; i16++) {
                    fArr6[i16] = initialValue.get$animation_core_release(i16);
                }
                fArr5[iBinarySearch$default] = fArr6;
            }
            if (!zB2 && !this.keyframes.contains(getDurationMillis())) {
                float[][] fArr7 = this.values;
                if (fArr7 == null) {
                    k.n("values");
                    throw null;
                }
                int iBinarySearch$default2 = IntListExtensionKt.binarySearch$default(this.timestamps, getDurationMillis(), 0, 0, 6, null);
                float[] fArr8 = new float[size2];
                for (int i17 = 0; i17 < size2; i17++) {
                    fArr8[i17] = targetValue.get$animation_core_release(i17);
                }
                fArr7[iBinarySearch$default2] = fArr8;
            }
        }
        float[] fArr9 = this.times;
        if (fArr9 == null) {
            k.n("times");
            throw null;
        }
        float[][] fArr10 = this.values;
        if (fArr10 == null) {
            k.n("values");
            throw null;
        }
        this.monoSpline = new MonoSpline(fArr9, fArr10, this.periodicBias);
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        int iClampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / AnimationKt.MillisToNanos);
        if (this.keyframes.containsKey(iClampPlayTime)) {
            Pair<V, Easing> pair = this.keyframes.get(iClampPlayTime);
            k.c(pair);
            return (V) pair.f4886a;
        }
        if (iClampPlayTime >= getDurationMillis()) {
            return targetValue;
        }
        if (iClampPlayTime <= 0) {
            return initialValue;
        }
        init(initialValue, targetValue, initialVelocity);
        int iFindEntryForTimeMillis = findEntryForTimeMillis(iClampPlayTime);
        MonoSpline monoSpline = this.monoSpline;
        if (monoSpline == null) {
            k.n("monoSpline");
            throw null;
        }
        float easedTimeFromIndex = getEasedTimeFromIndex(iFindEntryForTimeMillis, iClampPlayTime);
        V v10 = this.valueVector;
        if (v10 == null) {
            k.n("valueVector");
            throw null;
        }
        monoSpline.getPos(easedTimeFromIndex, v10, iFindEntryForTimeMillis);
        V v11 = this.valueVector;
        if (v11 != null) {
            return v11;
        }
        k.n("valueVector");
        throw null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        int iClampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / AnimationKt.MillisToNanos);
        if (iClampPlayTime < 0) {
            return initialVelocity;
        }
        init(initialValue, targetValue, initialVelocity);
        int iFindEntryForTimeMillis = findEntryForTimeMillis(iClampPlayTime);
        MonoSpline monoSpline = this.monoSpline;
        if (monoSpline == null) {
            k.n("monoSpline");
            throw null;
        }
        float easedTimeFromIndex = getEasedTimeFromIndex(iFindEntryForTimeMillis, iClampPlayTime);
        V v10 = this.velocityVector;
        if (v10 == null) {
            k.n("velocityVector");
            throw null;
        }
        monoSpline.getSlope(easedTimeFromIndex, v10, iFindEntryForTimeMillis);
        V v11 = this.velocityVector;
        if (v11 != null) {
            return v11;
        }
        k.n("velocityVector");
        throw null;
    }
}
