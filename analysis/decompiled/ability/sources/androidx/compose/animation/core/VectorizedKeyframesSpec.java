package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B;\b\u0016\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fBE\b\u0000\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u000b\u0010\u0014J'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010%J/\u0010(\u001a\u00028\u00002\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b(\u0010)J/\u0010*\u001a\u00028\u00002\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b*\u0010)R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010+R \u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010,R\u001a\u0010\t\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010-\u001a\u0004\b.\u0010/R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b0\u0010/R\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00101R\u001a\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0013\u0010-R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010;\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010<\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u00109R\u0016\u0010=\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u00107R\u0016\u0010>\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b>\u00107R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010A\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "Landroidx/compose/animation/core/AnimationVector;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "", "", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "keyframes", "durationMillis", "delayMillis", AppAgent.CONSTRUCT, "(Ljava/util/Map;II)V", "Landroidx/collection/IntList;", "timestamps", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "defaultEasing", "Landroidx/compose/animation/core/ArcMode;", "initialArcMode", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IILandroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/e;)V", "initialValue", "targetValue", "initialVelocity", "LC7/r;", "init", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "timeMillis", "", "getEasedTime", "(I)F", "index", "", "asFraction", "getEasedTimeFromIndex", "(IIZ)F", "findEntryForTimeMillis", "(I)I", "", "playTimeNanos", "getValueFromNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "Landroidx/collection/IntList;", "Landroidx/collection/IntObjectMap;", "I", "getDurationMillis", "()I", "getDelayMillis", "Landroidx/compose/animation/core/Easing;", "", "modes", "[I", "", "times", "[F", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "lastInitialValue", "lastTargetValue", "posArray", "slopeArray", "Landroidx/compose/animation/core/ArcSpline;", "arcSpline", "Landroidx/compose/animation/core/ArcSpline;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private ArcSpline arcSpline;
    private final Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final int initialArcMode;
    private final IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private V velocityVector;

    public /* synthetic */ VectorizedKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i, int i6, Easing easing, int i10, e eVar) {
        this(intList, intObjectMap, i, i6, easing, i10);
    }

    private final int findEntryForTimeMillis(int timeMillis) {
        int iBinarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, timeMillis, 0, 0, 6, null);
        return iBinarySearch$default < -1 ? -(iBinarySearch$default + 2) : iBinarySearch$default;
    }

    private final float getEasedTime(int timeMillis) {
        return getEasedTimeFromIndex(findEntryForTimeMillis(timeMillis), timeMillis, false);
    }

    private final float getEasedTimeFromIndex(int index, int timeMillis, boolean asFraction) {
        Easing easing;
        float f;
        IntList intList = this.timestamps;
        if (index >= intList._size - 1) {
            f = timeMillis;
        } else {
            int i = intList.get(index);
            int i6 = this.timestamps.get(index + 1);
            if (timeMillis != i) {
                int i10 = i6 - i;
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(i);
                if (vectorizedKeyframeSpecElementInfo == null || (easing = vectorizedKeyframeSpecElementInfo.getEasing()) == null) {
                    easing = this.defaultEasing;
                }
                float f7 = i10;
                float fTransform = easing.transform((timeMillis - i) / f7);
                return asFraction ? fTransform : ((f7 * fTransform) + i) / 1000;
            }
            f = i;
        }
        return f / 1000;
    }

    private final void init(V initialValue, V targetValue, V initialVelocity) {
        float[] fArr;
        float[] fArr2;
        boolean z10 = this.arcSpline != null;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(initialValue);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(initialVelocity);
            int size = this.timestamps.getSize();
            float[] fArr3 = new float[size];
            for (int i = 0; i < size; i++) {
                fArr3[i] = this.timestamps.get(i) / 1000;
            }
            this.times = fArr3;
            int size2 = this.timestamps.getSize();
            int[] iArr = new int[size2];
            for (int i6 = 0; i6 < size2; i6++) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(this.timestamps.get(i6));
                int iM209getArcMode9TMq4 = vectorizedKeyframeSpecElementInfo != null ? vectorizedKeyframeSpecElementInfo.m209getArcMode9TMq4() : this.initialArcMode;
                if (!ArcMode.m146equalsimpl0(iM209getArcMode9TMq4, ArcMode.INSTANCE.m152getArcLinear9TMq4())) {
                    z10 = true;
                }
                iArr[i6] = iM209getArcMode9TMq4;
            }
            this.modes = iArr;
        }
        if (z10) {
            if (this.arcSpline != null) {
                V v10 = this.lastInitialValue;
                if (v10 == null) {
                    k.n("lastInitialValue");
                    throw null;
                }
                if (v10.equals(initialValue)) {
                    V v11 = this.lastTargetValue;
                    if (v11 == null) {
                        k.n("lastTargetValue");
                        throw null;
                    }
                    if (v11.equals(targetValue)) {
                        return;
                    }
                }
            }
            this.lastInitialValue = initialValue;
            this.lastTargetValue = targetValue;
            int size3 = initialValue.getSize() + (initialValue.getSize() % 2);
            this.posArray = new float[size3];
            this.slopeArray = new float[size3];
            int size4 = this.timestamps.getSize();
            float[][] fArr4 = new float[size4][];
            for (int i10 = 0; i10 < size4; i10++) {
                int i11 = this.timestamps.get(i10);
                if (i11 != 0) {
                    if (i11 != getDurationMillis()) {
                        fArr = new float[size3];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i11);
                        k.c(vectorizedKeyframeSpecElementInfo2);
                        AnimationVector vectorValue = vectorizedKeyframeSpecElementInfo2.getVectorValue();
                        for (int i12 = 0; i12 < size3; i12++) {
                            fArr[i12] = vectorValue.get$animation_core_release(i12);
                        }
                    } else if (this.keyframes.contains(i11)) {
                        fArr = new float[size3];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i11);
                        k.c(vectorizedKeyframeSpecElementInfo3);
                        AnimationVector vectorValue2 = vectorizedKeyframeSpecElementInfo3.getVectorValue();
                        for (int i13 = 0; i13 < size3; i13++) {
                            fArr[i13] = vectorValue2.get$animation_core_release(i13);
                        }
                    } else {
                        fArr2 = new float[size3];
                        for (int i14 = 0; i14 < size3; i14++) {
                            fArr2[i14] = targetValue.get$animation_core_release(i14);
                        }
                    }
                    fArr2 = fArr;
                } else if (this.keyframes.contains(i11)) {
                    fArr = new float[size3];
                    VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo4 = this.keyframes.get(i11);
                    k.c(vectorizedKeyframeSpecElementInfo4);
                    AnimationVector vectorValue3 = vectorizedKeyframeSpecElementInfo4.getVectorValue();
                    for (int i15 = 0; i15 < size3; i15++) {
                        fArr[i15] = vectorValue3.get$animation_core_release(i15);
                    }
                    fArr2 = fArr;
                } else {
                    fArr2 = new float[size3];
                    for (int i16 = 0; i16 < size3; i16++) {
                        fArr2[i16] = initialValue.get$animation_core_release(i16);
                    }
                }
                fArr4[i10] = fArr2;
            }
            int[] iArr2 = this.modes;
            if (iArr2 == null) {
                k.n("modes");
                throw null;
            }
            float[] fArr5 = this.times;
            if (fArr5 == null) {
                k.n("times");
                throw null;
            }
            this.arcSpline = new ArcSpline(iArr2, fArr5, fArr4);
        }
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
        if (this.keyframes.contains(iClampPlayTime)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(iClampPlayTime);
            k.c(vectorizedKeyframeSpecElementInfo);
            return (V) vectorizedKeyframeSpecElementInfo.getVectorValue();
        }
        if (iClampPlayTime >= getDurationMillis()) {
            return targetValue;
        }
        if (iClampPlayTime <= 0) {
            return initialValue;
        }
        init(initialValue, targetValue, initialVelocity);
        int i = 0;
        if (this.arcSpline == null) {
            int iFindEntryForTimeMillis = findEntryForTimeMillis(iClampPlayTime);
            float easedTimeFromIndex = getEasedTimeFromIndex(iFindEntryForTimeMillis, iClampPlayTime, true);
            int i6 = this.timestamps.get(iFindEntryForTimeMillis);
            if (this.keyframes.contains(i6)) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i6);
                k.c(vectorizedKeyframeSpecElementInfo2);
                initialValue = (V) vectorizedKeyframeSpecElementInfo2.getVectorValue();
            }
            int i10 = this.timestamps.get(iFindEntryForTimeMillis + 1);
            if (this.keyframes.contains(i10)) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i10);
                k.c(vectorizedKeyframeSpecElementInfo3);
                targetValue = (V) vectorizedKeyframeSpecElementInfo3.getVectorValue();
            }
            V v10 = this.valueVector;
            if (v10 == null) {
                k.n("valueVector");
                throw null;
            }
            int size = v10.getSize();
            while (i < size) {
                V v11 = this.valueVector;
                if (v11 == null) {
                    k.n("valueVector");
                    throw null;
                }
                v11.set$animation_core_release(i, VectorConvertersKt.lerp(initialValue.get$animation_core_release(i), targetValue.get$animation_core_release(i), easedTimeFromIndex));
                i++;
            }
            V v12 = this.valueVector;
            if (v12 != null) {
                return v12;
            }
            k.n("valueVector");
            throw null;
        }
        float easedTime = getEasedTime(iClampPlayTime);
        ArcSpline arcSpline = this.arcSpline;
        if (arcSpline == null) {
            k.n("arcSpline");
            throw null;
        }
        float[] fArr = this.posArray;
        if (fArr == null) {
            k.n("posArray");
            throw null;
        }
        arcSpline.getPos(easedTime, fArr);
        float[] fArr2 = this.posArray;
        if (fArr2 == null) {
            k.n("posArray");
            throw null;
        }
        int length = fArr2.length;
        while (i < length) {
            V v13 = this.valueVector;
            if (v13 == null) {
                k.n("valueVector");
                throw null;
            }
            float[] fArr3 = this.posArray;
            if (fArr3 == null) {
                k.n("posArray");
                throw null;
            }
            v13.set$animation_core_release(i, fArr3[i]);
            i++;
        }
        V v14 = this.valueVector;
        if (v14 != null) {
            return v14;
        }
        k.n("valueVector");
        throw null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        long jClampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / AnimationKt.MillisToNanos);
        if (jClampPlayTime < 0) {
            return initialVelocity;
        }
        init(initialValue, targetValue, initialVelocity);
        int i = 0;
        if (this.arcSpline == null) {
            AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime - 1, initialValue, targetValue, initialVelocity);
            AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime, initialValue, targetValue, initialVelocity);
            int size = valueFromMillis.getSize();
            while (i < size) {
                V v10 = this.velocityVector;
                if (v10 == null) {
                    k.n("velocityVector");
                    throw null;
                }
                v10.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
                i++;
            }
            V v11 = this.velocityVector;
            if (v11 != null) {
                return v11;
            }
            k.n("velocityVector");
            throw null;
        }
        float easedTime = getEasedTime((int) jClampPlayTime);
        ArcSpline arcSpline = this.arcSpline;
        if (arcSpline == null) {
            k.n("arcSpline");
            throw null;
        }
        float[] fArr = this.slopeArray;
        if (fArr == null) {
            k.n("slopeArray");
            throw null;
        }
        arcSpline.getSlope(easedTime, fArr);
        float[] fArr2 = this.slopeArray;
        if (fArr2 == null) {
            k.n("slopeArray");
            throw null;
        }
        int length = fArr2.length;
        while (i < length) {
            V v12 = this.velocityVector;
            if (v12 == null) {
                k.n("velocityVector");
                throw null;
            }
            float[] fArr3 = this.slopeArray;
            if (fArr3 == null) {
                k.n("slopeArray");
                throw null;
            }
            v12.set$animation_core_release(i, fArr3[i]);
            i++;
        }
        V v13 = this.velocityVector;
        if (v13 != null) {
            return v13;
        }
        k.n("velocityVector");
        throw null;
    }

    private VectorizedKeyframesSpec(IntList intList, IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> intObjectMap, int i, int i6, Easing easing, int i10) {
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i;
        this.delayMillis = i6;
        this.defaultEasing = easing;
        this.initialArcMode = i10;
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i6, int i10, e eVar) {
        this(map, i, (i10 & 4) != 0 ? 0 : i6);
    }

    public VectorizedKeyframesSpec(Map<Integer, ? extends Pair<? extends V, ? extends Easing>> map, int i, int i6) {
        MutableIntList mutableIntList = new MutableIntList(map.size() + 2);
        Iterator<Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            mutableIntList.add(it.next().getKey().intValue());
        }
        if (!map.containsKey(0)) {
            mutableIntList.add(0, 0);
        }
        if (!map.containsKey(Integer.valueOf(i))) {
            mutableIntList.add(i);
        }
        mutableIntList.sort();
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        for (Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            Pair<? extends V, ? extends Easing> value = entry.getValue();
            mutableIntObjectMap.set(iIntValue, new VectorizedKeyframeSpecElementInfo((AnimationVector) value.f4886a, (Easing) value.b, ArcMode.INSTANCE.m152getArcLinear9TMq4(), null));
        }
        this(mutableIntList, mutableIntObjectMap, i, i6, EasingKt.getLinearEasing(), ArcMode.INSTANCE.m152getArcLinear9TMq4(), null);
    }
}
