package androidx.compose.ui.graphics;

import androidx.annotation.FloatRange;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.PathIterator;
import androidx.compose.ui.graphics.PathSegment;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/PathHitTester;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/graphics/Path;", SingleFileBundle.KEY_PATH, "", "tolerance", "LC7/r;", "updatePath", "(Landroidx/compose/ui/graphics/Path;F)V", "Landroidx/compose/ui/geometry/Offset;", "position", "", "contains-k-4lQ0M", "(J)Z", "contains", "Landroidx/compose/ui/graphics/Path;", "F", "Landroidx/compose/ui/geometry/Rect;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "", "curves", "[F", "roots", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PathHitTester {
    private Path path = PathHitTesterKt.EmptyPath;
    private float tolerance = 0.5f;
    private Rect bounds = Rect.INSTANCE.getZero();
    private final IntervalTree<PathSegment> intervals = new IntervalTree<>();
    private final float[] curves = new float[20];
    private final float[] roots = new float[2];

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void updatePath$default(PathHitTester pathHitTester, Path path, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        pathHitTester.updatePath(path, f);
    }

    /* renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m4434containsk4lQ0M(long position) {
        int i;
        int iLineWinding;
        if (!this.path.isEmpty() && this.bounds.m3921containsk4lQ0M(position)) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (position >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (position & 4294967295L));
            float[] fArr = this.curves;
            float[] fArr2 = this.roots;
            IntervalTree<PathSegment> intervalTree = this.intervals;
            IntervalTree<PathSegment>.Node node = intervalTree.root;
            if (node != intervalTree.terminator) {
                ArrayList<IntervalTree<PathSegment>.Node> arrayList = intervalTree.stack;
                arrayList.add(node);
                i = 0;
                while (arrayList.size() > 0) {
                    IntervalTree<PathSegment>.Node nodeRemove = arrayList.remove(arrayList.size() - 1);
                    if (nodeRemove.overlaps(fIntBitsToFloat2, fIntBitsToFloat2)) {
                        PathSegment data = nodeRemove.getData();
                        k.c(data);
                        PathSegment pathSegment = data;
                        float[] points = pathSegment.getPoints();
                        int i6 = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
                        if (i6 == 1) {
                            iLineWinding = BezierKt.lineWinding(points, fIntBitsToFloat, fIntBitsToFloat2);
                        } else if (i6 == 2) {
                            iLineWinding = BezierKt.quadraticWinding(points, fIntBitsToFloat, fIntBitsToFloat2, fArr, fArr2);
                        } else if (i6 == 3) {
                            iLineWinding = BezierKt.cubicWinding(points, fIntBitsToFloat, fIntBitsToFloat2, fArr, fArr2);
                        }
                        i += iLineWinding;
                    }
                    if (nodeRemove.getLeft() != intervalTree.terminator && nodeRemove.getLeft().getMax() >= fIntBitsToFloat2) {
                        arrayList.add(nodeRemove.getLeft());
                    }
                    if (nodeRemove.getRight() != intervalTree.terminator && nodeRemove.getRight().getMin() <= fIntBitsToFloat2) {
                        arrayList.add(nodeRemove.getRight());
                    }
                }
                arrayList.clear();
            } else {
                i = 0;
            }
            if (PathFillType.m4428equalsimpl0(this.path.mo4028getFillTypeRgk1Os(), PathFillType.INSTANCE.m4432getEvenOddRgk1Os())) {
                i &= 1;
            }
            if (i != 0) {
                return true;
            }
        }
        return false;
    }

    public final void updatePath(Path path, @FloatRange(from = 0.0d) float tolerance) {
        this.path = path;
        this.tolerance = tolerance;
        this.bounds = path.getBounds();
        this.intervals.clear();
        PathIterator it = path.iterator(PathIterator.ConicEvaluation.AsQuadratics, tolerance);
        while (it.hasNext()) {
            PathSegment next = it.next();
            int i = WhenMappings.$EnumSwitchMapping$0[next.getType().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                long jComputeVerticalBounds$default = BezierKt.computeVerticalBounds$default(next, this.curves, 0, 4, null);
                this.intervals.addInterval(Float.intBitsToFloat((int) (jComputeVerticalBounds$default >> 32)), Float.intBitsToFloat((int) (jComputeVerticalBounds$default & 4294967295L)), next);
            } else if (i == 4) {
                return;
            }
        }
    }
}
