package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/graphics/PathHitTester;", "", "<init>", "()V", "path", "Landroidx/compose/ui/graphics/Path;", "tolerance", "", "bounds", "Landroidx/compose/ui/geometry/Rect;", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "curves", "", "roots", "updatePath", "", "contains", "", "position", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PathHitTester {
    private Rect bounds;
    private final float[] curves;
    private final IntervalTree<PathSegment> intervals;
    private Path path;
    private final float[] roots;
    private float tolerance;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[PathSegment.Type.values().length];
            r100[PathSegment.Type.Line.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PathSegment.Type.Quadratic.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PathSegment.Type.Cubic.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PathSegment.Type.Done.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public PathHitTester() {
        this.path = PathHitTesterKt.access$getEmptyPath$p();
        this.tolerance = 0.5f;
        this.bounds = Rect.Companion.getZero();
        this.intervals = new IntervalTree();
        this.curves = new float[20];
        this.roots = new float[2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m5132containsk4lQ0M(long r110) {
        if (this.path.isEmpty() == false) goto L5;
    L42:
        return false;
    L5:
        if (this.bounds.m4608containsk4lQ0M(r110) == false) goto L42;
        float r100 = Float.intBitsToFloat((int) (r110 >> 32));
        float r111 = Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax));
        float[] r112 = this.curves;
        float[] r101 = this.roots;
        IntervalTree<PathSegment> r102 = this.intervals;
        IntervalTree<PathSegment>.Node r103 = r102.root;
        if (r103 == r102.terminator) goto L36;
        ArrayList<IntervalTree<PathSegment>.Node> r104 = r102.stack;
        r104.add(r103);
        int r105 = 0;
    L11:
        if (r104.size() <= 0) goto L35;
        IntervalTree.Node r106 = (IntervalTree.Node) ListProtector.remove(r104, r104.size() - 1);
        if (r106.overlaps(r111, r111) == false) goto L26;
        T r107 = r106.getData();
        Intrinsics.checkNotNull(r107);
        PathSegment r108 = (PathSegment) r107;
        float[] r109 = r108.getPoints();
        PathSegment.Type r113 = r108.getType();
        int r114 = WhenMappings.$EnumSwitchMapping$0[r113.ordinal()];
        if (r114 != 1) goto L17;
        int r115 = BezierKt.lineWinding(r109, r100, r111);
    L24:
        r105 = r105 + r115;
        goto L26
    L17:
        if (r114 != 2) goto L19;
        r115 = BezierKt.quadraticWinding(r109, r100, r111, r112, r101);
        goto L24
    L19:
        if (r114 != 3) goto L26;
        r115 = BezierKt.cubicWinding(r109, r100, r111, r112, r101);
    L26:
        if (r106.getLeft() == r102.terminator) goto L31;
        if (r106.getLeft().getMax() < r111) goto L31;
        r104.add(r106.getLeft());
    L31:
        if (r106.getRight() == r102.terminator) goto L11;
        if (r106.getRight().getMin() > r111) goto L11;
        r104.add(r106.getRight());
        goto L11
    L35:
        r104.clear();
    L38:
        if (PathFillType.m5126equalsimpl0(this.path.mo4716getFillTypeRgk1Os(), PathFillType.Companion.m5130getEvenOddRgk1Os()) == false) goto L40;
        r105 = r105 & 1;
    L40:
        if (r105 == 0) goto L42;
        return true;
    L36:
        r105 = 0;
        goto L38
    }

    public final void updatePath(Path r100, float r101) {
        this.path = r100;
        this.tolerance = r101;
        this.bounds = r100.getBounds();
        this.intervals.clear();
        PathIterator r102 = r100.iterator(PathIterator.ConicEvaluation.AsQuadratics, r101);
    L4:
        if (r102.hasNext() == false) goto L14;
        PathSegment r103 = r102.next();
        PathSegment.Type r104 = r103.getType();
        int r105 = WhenMappings.$EnumSwitchMapping$0[r104.ordinal()];
        if (r105 == 1) goto L13;
        if (r105 == 2) goto L13;
        if (r105 == 3) goto L13;
        if (r105 != 4) goto L4;
        return;
    L13:
        long r106 = BezierKt.computeVerticalBounds$default(r103, this.curves, 0, 4, null);
        float r107 = Float.intBitsToFloat((int) (r106 >> 32));
        float r108 = Float.intBitsToFloat((int) (r106 & BodyPartID.bodyIdMax));
        this.intervals.addInterval(r107, r108, r103);
        goto L4
    }

    public static /* synthetic */ void updatePath$default(PathHitTester r100, Path r101, float r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0.5f;
    L5:
        r100.updatePath(r101, r102);
    }
}
