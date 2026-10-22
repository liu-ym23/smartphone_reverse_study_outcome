package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "isInfinite", "", "()Z", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface VectorizedFiniteAnimationSpec<V extends AnimationVector> extends VectorizedAnimationSpec<V> {

    /* JADX INFO: renamed from: androidx.compose.animation.core.VectorizedFiniteAnimationSpec$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<V extends AnimationVector> {
        public static boolean $default$isInfinite(VectorizedFiniteAnimationSpec r100) {
            return false;
        }

        public static /* synthetic */ boolean access$isInfinite$jd(VectorizedFiniteAnimationSpec r100) {
            return $default$isInfinite(r100);
        }

        public static /* synthetic */ AnimationVector access$getEndVelocity$jd(VectorizedFiniteAnimationSpec r100, AnimationVector r101, AnimationVector r102, AnimationVector r103) {
            return VectorizedAnimationSpec.CC.$default$getEndVelocity(r100, r101, r102, r103);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <V extends AnimationVector> boolean isInfinite(VectorizedFiniteAnimationSpec<V> r100) {
            return CC.access$isInfinite$jd(r100);
        }

        public static <V extends AnimationVector> V getEndVelocity(VectorizedFiniteAnimationSpec<V> r100, V r101, V r102, V r103) {
            return (V) CC.access$getEndVelocity$jd(r100, r101, r102, r103);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    boolean isInfinite();
}
