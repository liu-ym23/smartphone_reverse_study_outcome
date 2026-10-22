package androidx.compose.animation.core;

import androidx.compose.ui.graphics.BezierKt;
import androidx.compose.ui.graphics.IntervalTree;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathIterator;
import androidx.compose.ui.graphics.PathSegment;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/animation/core/PathEasing;", "Landroidx/compose/animation/core/Easing;", "path", "Landroidx/compose/ui/graphics/Path;", "<init>", "(Landroidx/compose/ui/graphics/Path;)V", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "transform", "", "fraction", "initializeEasing", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PathEasing implements Easing {
    public static final int $stable = 0;
    private IntervalTree<PathSegment> intervals;
    private final Path path;

    private final void initializeEasing() {
        float[] r100 = new float[5];
        IntervalTree<PathSegment> r101 = new IntervalTree();
        PathIterator r102 = this.path.iterator(PathIterator.ConicEvaluation.AsQuadratics, 2.0E-4f);
    L3:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L17;
        PathSegment r104 = r102.next();
        if (r104.getType() != PathSegment.Type.Close) goto L9;
        r103 = false;
    L9:
        if (r103 == true) goto L12;
        PreconditionsKt.throwIllegalArgumentException("The path cannot contain a close() command.");
    L12:
        if (r104.getType() == PathSegment.Type.Move) goto L3;
        if (r104.getType() == PathSegment.Type.Done) goto L3;
        long r105 = BezierKt.computeHorizontalBounds$default(r104, r100, 0, 4, null);
        r101.addInterval(Float.intBitsToFloat((int) (r105 >> 32)), Float.intBitsToFloat((int) (r105 & BodyPartID.bodyIdMax)), r104);
        goto L3
    L17:
        if (r101.contains(0.0f) == true) goto L19;
    L21:
        r103 = false;
    L22:
        if (r103 == true) goto L24;
        PreconditionsKt.throwIllegalArgumentException("The easing path must start at 0.0f and end at 1.0f.");
    L24:
        this.intervals = r101;
        return;
    L19:
        if (r101.contains(1.0f) == false) goto L21;
        goto L21
    }

    public PathEasing(Path r100) {
        this.path = r100;
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float r100) {
        if (r100 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r100 < 1.0f) goto L9;
        return 1.0f;
    L9:
        if (this.intervals != null) goto L11;
        initializeEasing();
    L11:
        IntervalTree<PathSegment> r101 = this.intervals;
        if (r101 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("intervals");
        r101 = null;
    L14:
        Object r102 = IntervalTree.findFirstOverlap$default(r101, r100, 0.0f, 2, null).getData();
        if (r102 == null) goto L21;
        PathSegment r103 = (PathSegment) r102;
        float r104 = BezierKt.findFirstRoot(r103, r100);
        if ((!Float.isNaN(r104)) == true) goto L20;
        PreconditionsKt.throwIllegalStateException("The easing path is invalid. Make sure it does not contain NaN/Infinity values.");
    L20:
        return BezierKt.evaluateY(r103, r104);
    L21:
        PreconditionsKt.throwIllegalStateExceptionForNullCheck("The easing path is invalid. Make sure it is continuous on the x axis.");
        throw new KotlinNothingValueException();
    }
}
