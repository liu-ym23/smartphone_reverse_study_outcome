package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J-\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\rJ-\u0010\u000e\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\rJ%\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "isInfinite", "", "()Z", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface VectorizedAnimationSpec<V extends AnimationVector> {

    /* JADX INFO: renamed from: androidx.compose.animation.core.VectorizedAnimationSpec$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<V extends AnimationVector> {
        public static AnimationVector $default$getEndVelocity(VectorizedAnimationSpec r100, AnimationVector r101, AnimationVector r102, AnimationVector r103) {
            return r100.getVelocityFromNanos(r100.getDurationNanos(r101, r102, r103), r101, r102, r103);
        }

        public static /* synthetic */ AnimationVector access$getEndVelocity$jd(VectorizedAnimationSpec r100, AnimationVector r101, AnimationVector r102, AnimationVector r103) {
            return $default$getEndVelocity(r100, r101, r102, r103);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <V extends AnimationVector> V getEndVelocity(VectorizedAnimationSpec<V> r100, V r101, V r102, V r103) {
            return (V) CC.access$getEndVelocity$jd(r100, r101, r102, r103);
        }
    }

    long getDurationNanos(V r100, V r101, V r102);

    V getEndVelocity(V r100, V r101, V r102);

    V getValueFromNanos(long r100, V r101, V r102, V r103);

    V getVelocityFromNanos(long r100, V r101, V r102, V r103);

    boolean isInfinite();
}
