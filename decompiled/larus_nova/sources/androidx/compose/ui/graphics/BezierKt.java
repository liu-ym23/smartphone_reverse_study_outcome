package androidx.compose.ui.graphics;

import androidx.camera.video.AudioStats;
import androidx.collection.FloatFloatPair;
import androidx.compose.ui.util.MathHelpersKt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u001d\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a \u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a(\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a0\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0004H\u0007\u001a\u0019\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\b\u001a \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002\u001a(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0007\u001a+\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0082\b\u001a2\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0002\u001a(\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002\u001a'\u0010!\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010#\u001a'\u0010$\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0000¢\u0006\u0002\u0010#\u001a?\u0010%\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010(\u001a\u0015\u0010)\u001a\u00020 *\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010)\u001a\u00020 *\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0080\b\u001a\u0011\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0082\b\u001a \u0010-\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002\u001a \u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0000\u001a \u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004H\u0002\u001a0\u00106\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001bH\u0000\u001a0\u00109\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u001bH\u0002\u001a\u0018\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001bH\u0002\u001a \u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a\u0018\u0010A\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0002\u001a0\u0010B\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001bH\u0000\u001a(\u0010D\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0002\u001a \u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u001bH\u0002\u001a\u0018\u0010H\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020\u001bH\u0002\u001a0\u0010J\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001aH\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010S\u001a\u00020\u0004*\u00020\u00078Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010U\"\u0018\u0010V\u001a\u00020\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010U\"\u0019\u0010X\u001a\u00020\u0004*\u00020\u00078Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010U\"\u0018\u0010Z\u001a\u00020\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010U¨\u0006\\"}, d2 = {"Tau", "", "Epsilon", "FloatEpsilon", "", "evaluateX", MonitorConstants.SEGMENT, "Landroidx/compose/ui/graphics/PathSegment;", "t", "evaluateY", "evaluateLine", "p0y", "p1y", "evaluateQuadratic", "p0", "p1", "p2", "evaluateCubic", "p3", "findFirstRoot", "fraction", "findFirstLineRoot", "findFirstQuadraticRoot", "findFirstCubicRoot", "findLineRoot", "", "roots", "", "index", "findQuadraticRoots", "findDerivativeRoots", "horizontal", "", "computeHorizontalBounds", "Landroidx/collection/FloatFloatPair;", "(Landroidx/compose/ui/graphics/PathSegment;[FI)J", "computeVerticalBounds", "computeCubicVerticalBounds", "p2y", "p3y", "(FFFF[FI)J", "closeTo", "b", "clampValidRootInUnitRange", "r", "writeValidRootInUnitRange", "lineWinding", "points", "x", "y", "isQuadraticMonotonic", "y0", "y1", "y2", "quadraticWinding", "tmpQuadratics", "tmpRoots", "monotonicQuadraticWinding", "offset", "quadraticToMonotonicQuadratics", "quadratic", "dst", "splitQuadraticAt", "", "src", "unitDivide", "cubicWinding", "tmpCubics", "monotonicCubicWinding", "cubicToMonotonicCubics", "cubic", "tmpRoot", "findCubicExtremaY", "dstRoots", "splitCubicAt", "srcOffset", "dstOffset", "cubicArea", "x0", "x1", "x2", "x3", "y3", "startX", "getStartX", "(Landroidx/compose/ui/graphics/PathSegment;)F", "endX", "getEndX", "startY", "getStartY", "endY", "getEndY", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BezierKt {
    private static final double Epsilon = 1.0E-7d;
    private static final float FloatEpsilon = 1.05E-6f;
    private static final double Tau = 6.283185307179586d;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[PathSegment.Type.values().length];
            r100[PathSegment.Type.Move.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[PathSegment.Type.Line.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[PathSegment.Type.Quadratic.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[PathSegment.Type.Cubic.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[PathSegment.Type.Conic.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[PathSegment.Type.Close.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[PathSegment.Type.Done.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final float cubicArea(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r110) {
        return ((((((((r110 - r101) * (r102 + r104)) - ((r106 - r100) * (r103 + r105))) + (r103 * (r100 - r104))) - (r102 * (r101 - r105))) + (r110 * (r104 + (r100 / 3.0f)))) - (r106 * (r105 + (r101 / 3.0f)))) * 3.0f) / 20.0f;
    }

    public static final float evaluateCubic(float r100, float r101, float r102) {
        float r103 = (r100 - r101) + 0.33333334f;
        float r104 = r103 * r102;
        return ((((r104 + (r101 - (2.0f * r100))) * r102) + r100) * 3.0f) * r102;
    }

    private static final float evaluateCubic(float r100, float r101, float r102, float r103, float r104) {
        float r105 = (r103 + ((r101 - r102) * 3.0f)) - r100;
        float r106 = ((r102 - (2.0f * r101)) + r100) * 3.0f;
        float r107 = ((r105 * r104) + r106) * r104;
        return ((r107 + ((r101 - r100) * 3.0f)) * r104) + r100;
    }

    private static final float evaluateLine(float r100, float r101, float r102) {
        return ((r101 - r100) * r102) + r100;
    }

    private static final float evaluateQuadratic(float r100, float r101, float r102, float r103) {
        float r104 = (r101 - r100) * 2.0f;
        return (((((r102 - (r101 * 2.0f)) + r100) * r103) + r104) * r103) + r100;
    }

    private static final float unitDivide(float r100, float r101) {
        if (r100 >= 0.0f) goto L5;
        r100 = -r100;
        r101 = -r101;
    L5:
        boolean r102 = true;
        if (r101 != 0.0f) goto L8;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L26:
        return Float.NaN;
    L12:
        if (r100 != 0.0f) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L26;
        if (r100 >= r101) goto L26;
        float r105 = r100 / r101;
        if (r105 == 0.0f) goto L23;
        r102 = false;
    L23:
        if (r102 == false) goto L25;
        return Float.NaN;
    L25:
        return r105;
    L14:
        r104 = false;
        goto L15
    L8:
        r103 = false;
        goto L10
    }

    private static final float clampValidRootInUnitRange(float r100) {
        float r101 = 0.0f;
        if (r100 < 0.0f) goto L7;
        r101 = r100;
    L7:
        if (r101 <= 1.0f) goto L10;
        r101 = 1.0f;
    L10:
        if (Math.abs(r101 - r100) <= FloatEpsilon) goto L13;
        return Float.NaN;
    L13:
        return r101;
    }

    private static final float getEndX(PathSegment r100) {
        float[] r101 = r100.getPoints();
        PathSegment.Type r102 = r100.getType();
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        char r104 = 2;
        if (r103 == 2) goto L13;
        if (r103 == 3) goto L11;
        if (r103 != 4) goto L8;
        r104 = 6;
        goto L13
    L8:
        if (r103 == 5) goto L11;
        r104 = 0;
    L11:
        r104 = 4;
    L13:
        return r101[r104];
    }

    private static final float getEndY(PathSegment r100) {
        float[] r101 = r100.getPoints();
        PathSegment.Type r102 = r100.getType();
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        char r104 = 3;
        if (r103 == 2) goto L13;
        if (r103 != 3) goto L7;
    L11:
        r104 = 5;
        goto L13
    L7:
        if (r103 == 4) goto L10;
        if (r103 == 5) goto L11;
        r104 = 0;
        goto L13
    L10:
        r104 = 7;
    L13:
        return r101[r104];
    }

    private static final float getStartX(PathSegment r100) {
        return r100.getPoints()[0];
    }

    private static final float getStartY(PathSegment r100) {
        return r100.getPoints()[1];
    }

    public static final boolean closeTo(double r100, double r101) {
        if (Math.abs(r100 - r101) >= Epsilon) goto L5;
        return true;
    L5:
        return false;
    }

    private static final float evaluateX(PathSegment r100, float r101) {
        float[] r102 = r100.getPoints();
        PathSegment.Type r103 = r100.getType();
        int r104 = WhenMappings.$EnumSwitchMapping$0[r103.ordinal()];
        if (r104 == 1) goto L14;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 == 4) goto L16;
        return Float.NaN;
    L16:
        return evaluateCubic(r102[0], r102[2], r102[4], r102[6], r101);
    L17:
        return evaluateQuadratic(r102[0], r102[2], r102[4], r101);
    L18:
        return evaluateLine(r102[0], r102[2], r101);
    L14:
        return r102[0];
    }

    public static final float evaluateY(PathSegment r100, float r101) {
        float[] r102 = r100.getPoints();
        PathSegment.Type r103 = r100.getType();
        int r104 = WhenMappings.$EnumSwitchMapping$0[r103.ordinal()];
        if (r104 == 1) goto L15;
        if (r104 == 2) goto L19;
        if (r104 == 3) goto L18;
        if (r104 == 4) goto L17;
        return Float.NaN;
    L17:
        return evaluateCubic(r102[1], r102[3], r102[5], r102[7], r101);
    L18:
        return evaluateQuadratic(r102[1], r102[3], r102[5], r101);
    L19:
        return evaluateLine(r102[1], r102[3], r101);
    L15:
        return r102[1];
    }

    private static final int findCubicExtremaY(float[] r100, float[] r101) {
        float r102 = r100[1];
        float r103 = r100[3];
        float r104 = r100[5];
        return findQuadraticRoots((r100[7] - r102) + ((r103 - r104) * 3.0f), (((r102 - r103) - r103) - r104) * 2.0f, r103 - r102, r101, 0);
    }

    private static final float findFirstLineRoot(float r100, float r101) {
        float r102 = (-r100) / (r101 - r100);
        float r103 = 0.0f;
        if (r102 < 0.0f) goto L7;
        r103 = r102;
    L7:
        if (r103 <= 1.0f) goto L10;
        r103 = 1.0f;
    L10:
        if (Math.abs(r103 - r102) <= FloatEpsilon) goto L13;
        return Float.NaN;
    L13:
        return r103;
    }

    public static final float findFirstRoot(PathSegment r100, float r101) {
        float[] r102 = r100.getPoints();
        PathSegment.Type r103 = r100.getType();
        switch(WhenMappings.$EnumSwitchMapping$0[r103.ordinal()]) {
            case 1: goto L20;
            case 2: goto L8;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L20;
            case 7: goto L20;
            default: goto L5;
        };
    L8:
        float r104 = r102[0] - r101;
        float r105 = r102[2] - r101;
        float r106 = (-r104) / (r105 - r104);
        float r107 = 0.0f;
        if (r106 < 0.0f) goto L13;
        r107 = r106;
    L13:
        if (r107 <= 1.0f) goto L16;
        r107 = 1.0f;
    L16:
        if (Math.abs(r107 - r106) <= FloatEpsilon) goto L19;
        return Float.NaN;
    L19:
        return r107;
    L20:
        return Float.NaN;
    L5:
        throw new NoWhenBranchMatchedException();
    L21:
        return findFirstCubicRoot(r102[0] - r101, r102[2] - r101, r102[4] - r101, r102[6] - r101);
    L22:
        return findFirstQuadraticRoot(r102[0] - r101, r102[2] - r101, r102[4] - r101);
    }

    private static final int quadraticToMonotonicQuadratics(float[] r110, float[] r111) {
        if (r110.length >= 6) goto L6;
        return 0;
    L6:
        if (r111.length >= 6) goto L8;
        return 0;
    L8:
        float r100 = r110[1];
        float r101 = r110[3];
        float r102 = r110[5];
        if (isQuadraticMonotonic(r100, r101, r102) == true) goto L19;
        float r103 = r100 - r101;
        float r104 = unitDivide(r103, (r103 - r101) + r102);
        if (Float.isNaN(r104) == true) goto L15;
        splitQuadraticAt(r110, r111, r104);
        return 1;
    L15:
        if (Math.abs(r103) < Math.abs(r101 - r102)) goto L18;
        r100 = r102;
    L18:
        r101 = r100;
    L19:
        ArraysKt.copyInto(r110, r111, 0, 0, 6);
        r111[3] = r101;
        return 0;
    }

    public static final boolean closeTo(float r100, float r101) {
        if (Math.abs(r100 - r101) >= FloatEpsilon) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ int access$writeValidRootInUnitRange(float r100, float[] r101, int r102) {
        return writeValidRootInUnitRange(r100, r101, r102);
    }

    public static final long computeHorizontalBounds(PathSegment r100, float[] r101, int r102) {
        int r103 = findDerivativeRoots(r100, true, r101, r102);
        int r104 = 0;
        float r105 = Math.min(r100.getPoints()[0], getEndX(r100));
        float r106 = Math.max(r100.getPoints()[0], getEndX(r100));
    L3:
        if (r104 >= r103) goto L6;
        float r107 = evaluateX(r100, r101[r104]);
        r105 = Math.min(r105, r107);
        r106 = Math.max(r106, r107);
        r104 = r104 + 1;
        goto L3
    L6:
        return FloatFloatPair.m5constructorimpl(r105, r106);
    }

    public static final long computeVerticalBounds(PathSegment r100, float[] r101, int r102) {
        int r103 = 0;
        int r104 = findDerivativeRoots(r100, false, r101, r102);
        float r105 = Math.min(r100.getPoints()[1], getEndY(r100));
        float r106 = Math.max(r100.getPoints()[1], getEndY(r100));
    L3:
        if (r103 >= r104) goto L6;
        float r107 = evaluateY(r100, r101[r103]);
        r105 = Math.min(r105, r107);
        r106 = Math.max(r106, r107);
        r103 = r103 + 1;
        goto L3
    L6:
        return FloatFloatPair.m5constructorimpl(r105, r106);
    }

    private static final int cubicToMonotonicCubics(float[] r100, float[] r101, float[] r102) {
        int r103 = findCubicExtremaY(r100, r102);
        int r104 = 0;
        if (r103 == 0) goto L5;
        int r105 = 0;
        float r106 = 0.0f;
    L9:
        if (r104 >= r103) goto L18;
        float r107 = (r102[r104] - r106) / (1.0f - r106);
        if (r107 >= 0.0f) goto L14;
        r107 = 0.0f;
    L14:
        if (r107 <= 1.0f) goto L16;
        r106 = 1.0f;
    L17:
        splitCubicAt(r100, r105, r101, r105, r106);
        r105 = r105 + 6;
        r104 = r104 + 1;
        r100 = r101;
        goto L9
    L16:
        r106 = r107;
    L18:
        return r103;
    L5:
        if (r101.length >= 8) goto L7;
        return 0;
    L7:
        ArraysKt.copyInto(r100, r101, 0, 0, 8);
        goto L18
    }

    private static final float findFirstQuadraticRoot(float r110, float r210, float r211) {
        double r100 = r110;
        double r101 = r210;
        double r102 = r211;
        double r103 = r101 * 2.0d;
        double r111 = (r100 - r103) + r102;
        boolean r112 = true;
        if (r111 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r113 = true;
    L6:
        float r114 = 1.0f;
        float r115 = 0.0f;
        if (r113 == true) goto L35;
        double r104 = -Math.sqrt((r101 * r101) - (r102 * r100));
        double r105 = (-r100) + r101;
        float r106 = (float) ((-(r104 + r105)) / r111);
        if (r106 >= 0.0f) goto L11;
        float r107 = 0.0f;
    L13:
        if (r107 <= 1.0f) goto L16;
        r107 = 1.0f;
    L16:
        if (Math.abs(r107 - r106) <= FloatEpsilon) goto L19;
        r107 = Float.NaN;
    L19:
        if (Float.isNaN(r107) == true) goto L21;
        return r107;
    L21:
        float r108 = (float) ((r104 - r105) / r111);
        if (r108 < 0.0f) goto L26;
        r115 = r108;
    L26:
        if (r115 > 1.0f) goto L30;
        r114 = r115;
    L30:
        if (Math.abs(r114 - r108) <= FloatEpsilon) goto L33;
        return Float.NaN;
    L33:
        return r114;
    L11:
        r107 = r106;
        goto L13
    L35:
        if (r101 == r102) goto L38;
        r112 = false;
    L38:
        if (r112 == true) goto L53;
        float r109 = (float) ((r103 - r102) / (r103 - (r102 * 2.0d)));
        if (r109 < 0.0f) goto L44;
        r115 = r109;
    L44:
        if (r115 > 1.0f) goto L48;
        r114 = r115;
    L48:
        if (Math.abs(r114 - r109) <= FloatEpsilon) goto L51;
        return Float.NaN;
    L51:
        return r114;
    L53:
        return Float.NaN;
    L5:
        r113 = false;
        goto L6
    }

    private static final boolean isQuadraticMonotonic(float r100, float r101, float r102) {
        if ((Math.signum(r100 - r101) + Math.signum(r101 - r102)) != 0.0f) goto L5;
        boolean r103 = true;
    L7:
        return !r103;
    L5:
        r103 = false;
        goto L7
    }

    public static final int lineWinding(float[] r100, float r101, float r110) {
        if (r100.length >= 4) goto L5;
        return 0;
    L5:
        float r102 = r100[0];
        boolean r103 = true;
        float r104 = r100[1];
        float r105 = r100[2];
        float r106 = r100[3];
        float r107 = r106 - r104;
        if (r104 <= r106) goto L8;
        float r108 = r104;
        int r109 = -1;
    L10:
        if (r110 >= r106) goto L12;
        return 0;
    L12:
        if (r110 >= r108) goto L26;
        float r111 = ((r105 - r102) * (r110 - r104)) - (r107 * (r101 - r102));
        if (r111 == 0.0f) goto L18;
        r103 = false;
    L18:
        if (r103 == false) goto L21;
        return 0;
    L21:
        if (((int) Math.signum(r111)) != r109) goto L24;
        return 0;
    L24:
        return r109;
    L26:
        return 0;
    L8:
        r108 = r106;
        r106 = r104;
        r109 = 1;
        goto L10
    }

    private static final void splitQuadraticAt(float[] r110, float[] r111, float r112) {
        if (r110.length >= 6) goto L6;
        return;
    L6:
        if (r111.length >= 10) goto L8;
        return;
    L8:
        float r100 = r110[0];
        float r101 = r110[1];
        float r102 = r110[2];
        float r113 = r110[3];
        float r114 = r110[4];
        float r103 = r110[5];
        float r115 = MathHelpersKt.lerp(r100, r102, r112);
        float r104 = MathHelpersKt.lerp(r101, r113, r112);
        r111[0] = r100;
        r111[1] = r101;
        r111[2] = r115;
        r111[3] = r104;
        float r105 = MathHelpersKt.lerp(r102, r114, r112);
        float r106 = MathHelpersKt.lerp(r113, r103, r112);
        float r107 = MathHelpersKt.lerp(r115, r105, r112);
        float r108 = MathHelpersKt.lerp(r104, r106, r112);
        r111[4] = r107;
        r111[5] = r108;
        r111[6] = r105;
        r111[7] = r106;
        r111[8] = r114;
        r111[9] = r103;
    }

    private static final int writeValidRootInUnitRange(float r100, float[] r101, int r102) {
        float r103 = 0.0f;
        if (r100 < 0.0f) goto L7;
        r103 = r100;
    L7:
        if (r103 <= 1.0f) goto L10;
        r103 = 1.0f;
    L10:
        if (Math.abs(r103 - r100) <= FloatEpsilon) goto L12;
        r103 = Float.NaN;
    L12:
        r101[r102] = r103;
        return !Float.isNaN(r103) ? 1 : 0;
    }

    private static final int findDerivativeRoots(PathSegment r100, boolean r101, float[] r102, int r103) {
        int r104 = !r101 ? 1 : 0;
        float[] r105 = r100.getPoints();
        int r106 = WhenMappings.$EnumSwitchMapping$0[r100.getType().ordinal()];
        if (r106 == 3) goto L7;
        if (r106 == 4) goto L6;
        return 0;
    L6:
        float r107 = r105[r104 + 2];
        float r108 = (r107 - r105[r104 + 0]) * 3.0f;
        float r109 = r105[r104 + 4];
        float r110 = (r109 - r107) * 3.0f;
        float r111 = (r105[r104 + 6] - r109) * 3.0f;
        int r112 = findQuadraticRoots(r108, r110, r111, r102, r103);
        float r113 = (r110 - r108) * 2.0f;
        return access$writeValidRootInUnitRange((-r113) / (((r111 - r110) * 2.0f) - r113), r102, r103 + r112) + r112;
    L7:
        float r114 = 2;
        float r115 = r105[r104 + 2];
        float r116 = (r115 - r105[r104 + 0]) * r114;
        return access$writeValidRootInUnitRange((-r116) / ((r114 * (r105[r104 + 4] - r115)) - r116), r102, r103);
    }

    public static final float findFirstCubicRoot(float r210, float r211, float r212, float r213) {
        double r100 = r210;
        double r101 = ((r100 - (((double) r211) * 2.0d)) + ((double) r212)) * 3.0d;
        double r110 = ((double) (r211 - r210)) * 3.0d;
        double r111 = (((double) (-r210)) + (((double) (r211 - r212)) * 3.0d)) + ((double) r213);
        boolean r102 = true;
        if (Math.abs(r111 - AudioStats.AUDIO_AMPLITUDE_NONE) >= Epsilon) goto L5;
        boolean r112 = true;
    L6:
        float r214 = 1.0f;
        float r215 = 0.0f;
        if (r112 == true) goto L9;
        double r103 = r101 / r111;
        double r113 = r110 / r111;
        double r104 = r100 / r111;
        double r114 = ((r113 * 3.0d) - (r103 * r103)) / 9.0d;
        double r105 = (((((2.0d * r103) * r103) * r103) - ((9.0d * r103) * r113)) + (r104 * 27.0d)) / 54.0d;
        double r115 = (r114 * r114) * r114;
        double r106 = (r105 * r105) + r115;
        double r107 = r103 / 3.0d;
        if (r106 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L105;
        double r108 = Math.sqrt(-r115);
        double r109 = (-r105) / r108;
        if (r109 >= (-1.0d)) goto L64;
        r109 = -1.0d;
    L64:
        if (r109 <= 1.0d) goto L66;
        r109 = 1.0d;
    L66:
        double r116 = Math.acos(r109);
        double r117 = MathHelpersKt.fastCbrt((float) r108) * 2.0f;
        float r118 = (float) ((Math.cos(r116 / 3.0d) * r117) - r107);
        if (r118 >= 0.0f) goto L69;
        float r119 = 0.0f;
    L71:
        if (r119 <= 1.0f) goto L74;
        r119 = 1.0f;
    L74:
        if (Math.abs(r119 - r118) <= FloatEpsilon) goto L77;
        r119 = Float.NaN;
    L77:
        if (Float.isNaN(r119) == true) goto L79;
        return r119;
    L79:
        float r120 = (float) ((Math.cos((Tau + r116) / 3.0d) * r117) - r107);
        if (r120 >= 0.0f) goto L82;
        float r121 = 0.0f;
    L84:
        if (r121 <= 1.0f) goto L87;
        r121 = 1.0f;
    L87:
        if (Math.abs(r121 - r120) <= FloatEpsilon) goto L90;
        r121 = Float.NaN;
    L90:
        if (Float.isNaN(r121) == true) goto L92;
        return r121;
    L92:
        float r122 = (float) ((r117 * Math.cos((r116 + 12.566370614359172d) / 3.0d)) - r107);
        if (r122 < 0.0f) goto L97;
        r215 = r122;
    L97:
        if (r215 > 1.0f) goto L101;
        r214 = r215;
    L101:
        if (Math.abs(r214 - r122) <= FloatEpsilon) goto L104;
        return Float.NaN;
    L104:
        return r214;
    L82:
        r121 = r120;
        goto L84
    L69:
        r119 = r118;
        goto L71
    L105:
        if (r106 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L108;
        r102 = false;
    L108:
        if (r102 == false) goto L135;
        float r123 = -MathHelpersKt.fastCbrt((float) r105);
        float r124 = (float) r107;
        float r125 = (2.0f * r123) - r124;
        if (r125 >= 0.0f) goto L112;
        float r126 = 0.0f;
    L114:
        if (r126 <= 1.0f) goto L117;
        r126 = 1.0f;
    L117:
        if (Math.abs(r126 - r125) <= FloatEpsilon) goto L120;
        r126 = Float.NaN;
    L120:
        if (Float.isNaN(r126) == true) goto L122;
        return r126;
    L122:
        float r127 = (-r123) - r124;
        if (r127 < 0.0f) goto L127;
        r215 = r127;
    L127:
        if (r215 > 1.0f) goto L131;
        r214 = r215;
    L131:
        if (Math.abs(r214 - r127) <= FloatEpsilon) goto L134;
        return Float.NaN;
    L134:
        return r214;
    L112:
        r126 = r125;
        goto L114
    L135:
        double r128 = Math.sqrt(r106);
        float r129 = (float) (((double) (MathHelpersKt.fastCbrt((float) ((-r105) + r128)) - MathHelpersKt.fastCbrt((float) (r105 + r128)))) - r107);
        if (r129 < 0.0f) goto L140;
        r215 = r129;
    L140:
        if (r215 > 1.0f) goto L144;
        r214 = r215;
    L144:
        if (Math.abs(r214 - r129) <= FloatEpsilon) goto L147;
        return Float.NaN;
    L147:
        return r214;
    L9:
        if (Math.abs(r101 - AudioStats.AUDIO_AMPLITUDE_NONE) >= Epsilon) goto L11;
        boolean r130 = true;
    L12:
        if (r130 == true) goto L14;
        double r131 = Math.sqrt((r110 * r110) - ((4.0d * r101) * r100));
        double r132 = r101 * 2.0d;
        float r133 = (float) ((r131 - r110) / r132);
        if (r133 >= 0.0f) goto L35;
        float r134 = 0.0f;
    L37:
        if (r134 <= 1.0f) goto L40;
        r134 = 1.0f;
    L40:
        if (Math.abs(r134 - r133) <= FloatEpsilon) goto L43;
        r134 = Float.NaN;
    L43:
        if (Float.isNaN(r134) == true) goto L45;
        return r134;
    L45:
        float r135 = (float) (((-r110) - r131) / r132);
        if (r135 < 0.0f) goto L50;
        r215 = r135;
    L50:
        if (r215 > 1.0f) goto L54;
        r214 = r215;
    L54:
        if (Math.abs(r214 - r135) <= FloatEpsilon) goto L57;
        return Float.NaN;
    L57:
        return r214;
    L35:
        r134 = r133;
        goto L37
    L14:
        if (Math.abs(r110 - AudioStats.AUDIO_AMPLITUDE_NONE) < Epsilon) goto L17;
        r102 = false;
    L17:
        if (r102 == false) goto L19;
        return Float.NaN;
    L19:
        float r136 = (float) ((-r100) / r110);
        if (r136 < 0.0f) goto L24;
        r215 = r136;
    L24:
        if (r215 > 1.0f) goto L28;
        r214 = r215;
    L28:
        if (Math.abs(r214 - r136) <= FloatEpsilon) goto L31;
        return Float.NaN;
    L31:
        return r214;
    L11:
        r130 = false;
        goto L12
    L5:
        r112 = false;
        goto L6
    }

    private static final int findLineRoot(float r100, float r101, float[] r102, int r103) {
        return access$writeValidRootInUnitRange((-r100) / (r101 - r100), r102, r103);
    }

    private static final int monotonicCubicWinding(float[] r110, int r111, float r112, float r113) {
        int r100 = r111 + 1;
        float r101 = r110[r100];
        int r102 = r111 + 7;
        float r103 = r110[r102];
        boolean r104 = true;
        if (r101 <= r103) goto L5;
        int r105 = -1;
        r103 = r101;
        r101 = r103;
    L7:
        if (r113 >= r101) goto L9;
    L41:
        return 0;
    L9:
        if (r113 >= r103) goto L41;
        float r106 = r110[r111 + 0];
        float r107 = r110[r111 + 2];
        float r108 = r110[r111 + 4];
        float r109 = r110[r111 + 6];
        if (r112 >= Math.min(r106, Math.min(r107, Math.min(r108, r109)))) goto L15;
        return 0;
    L15:
        if (r112 <= Math.max(r106, Math.max(r107, Math.max(r108, r109)))) goto L17;
        return r105;
    L17:
        float r114 = r110[r100];
        float r115 = r110[r111 + 3];
        float r116 = r110[r111 + 5];
        float r117 = r110[r102];
        float r118 = findFirstCubicRoot(r114 - r113, r115 - r113, r116 - r113, r117 - r113);
        if (Float.isNaN(r118) == false) goto L20;
        return 0;
    L20:
        float r119 = evaluateCubic(r106, r107, r108, r109, r118);
        if (Math.abs(r119 - r112) >= FloatEpsilon) goto L23;
        boolean r120 = true;
    L24:
        if (r120 == false) goto L37;
        if (r112 != r109) goto L28;
        boolean r121 = true;
    L29:
        if (r121 == true) goto L31;
    L35:
        return 0;
    L31:
        if (r113 == r117) goto L34;
        r104 = false;
    L34:
        if (r104 == true) goto L37;
    L28:
        r121 = false;
    L37:
        if (r119 < r112) goto L42;
        return 0;
    L42:
        return r105;
    L23:
        r120 = false;
        goto L24
    L5:
        r105 = 1;
        goto L7
    }

    public static /* synthetic */ long computeHorizontalBounds$default(PathSegment r100, float[] r101, int r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        return computeHorizontalBounds(r100, r101, r102);
    }

    public static /* synthetic */ long computeVerticalBounds$default(PathSegment r100, float[] r101, int r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        return computeVerticalBounds(r100, r101, r102);
    }

    public static final int cubicWinding(float[] r100, float r101, float r102, float[] r103, float[] r104) {
        int r105 = cubicToMonotonicCubics(r100, r103, r104);
        int r106 = 0;
        if (r105 < 0) goto L8;
        int r107 = 0;
    L5:
        r106 = r106 + monotonicCubicWinding(r103, (r107 * 3) * 2, r101, r102);
        if (r107 == r105) goto L8;
        r107 = r107 + 1;
    L8:
        return r106;
    }

    private static final int findQuadraticRoots(float r110, float r210, float r211, float[] r212, int r213) {
        double r100 = r110;
        double r101 = r210;
        double r102 = r211;
        double r111 = r101 * 2.0d;
        double r112 = (r100 - r111) + r102;
        boolean r103 = true;
        if (r112 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r113 = true;
    L6:
        if (r113 == true) goto L20;
        double r104 = -Math.sqrt((r101 * r101) - (r102 * r100));
        double r105 = (-r100) + r101;
        int r106 = writeValidRootInUnitRange((float) ((-(r104 + r105)) / r112), r212, r213) + 0;
        int r107 = r106 + writeValidRootInUnitRange((float) ((r104 - r105) / r112), r212, r213 + r106);
        if (r107 <= 1) goto L27;
        float r108 = r212[r213];
        int r109 = r213 + 1;
        float r114 = r212[r109];
        if (r108 <= r114) goto L13;
        r212[r213] = r114;
        r212[r109] = r108;
        goto L27
    L13:
        if (r108 == r114) goto L16;
        r103 = false;
    L16:
        if (r103 == false) goto L27;
        return r107 - 1;
    L27:
        return r107;
    L20:
        if (r101 == r102) goto L23;
        r103 = false;
    L23:
        if (r103 == false) goto L25;
        return 0;
    L25:
        return writeValidRootInUnitRange((float) ((r111 - r102) / (r111 - (r102 * 2.0d))), r212, r213) + 0;
    L5:
        r113 = false;
        goto L6
    }

    private static final int monotonicQuadraticWinding(float[] r110, int r111, float r112, float r113, float[] r114) {
        float r100 = r110[r111 + 1];
        float r101 = r110[r111 + 5];
        boolean r102 = true;
        if (r100 <= r101) goto L5;
        int r103 = -1;
        float r104 = r100;
        float r105 = r101;
    L7:
        if (r113 >= r105) goto L9;
    L36:
        return 0;
    L9:
        if (r113 >= r104) goto L36;
        float r106 = r110[r111 + 3];
        if (findQuadraticRoots$default((r100 - (r106 * 2.0f)) + r101, (r106 - r100) * 2.0f, r100 - r113, r114, 0, 16, null) != 0) goto L14;
        float r107 = r110[(1 - r103) * 2];
    L16:
        if (Math.abs(r107 - r112) >= FloatEpsilon) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L32;
        if (r112 != r110[4]) goto L23;
        boolean r109 = true;
    L24:
        if (r109 == true) goto L26;
    L30:
        return 0;
    L26:
        if (r113 == r101) goto L29;
        r102 = false;
    L29:
        if (r102 == true) goto L32;
    L23:
        r109 = false;
    L32:
        if (r107 < r112) goto L37;
        return 0;
    L37:
        return r103;
    L18:
        r108 = false;
        goto L19
    L14:
        r107 = evaluateQuadratic(r110[0], r110[2], r110[4], r114[0]);
        goto L16
    L5:
        r105 = r100;
        r104 = r101;
        r103 = 1;
        goto L7
    }

    public static final int quadraticWinding(float[] r100, float r101, float r102, float[] r103, float[] r104) {
        if (isQuadraticMonotonic(r100[1], r100[3], r100[5]) == true) goto L5;
        int r105 = quadraticToMonotonicQuadratics(r100, r103);
        int r106 = monotonicQuadraticWinding(r103, 0, r101, r102, r104);
        if (r105 > 0) goto L9;
        return r106;
    L9:
        return r106 + monotonicQuadraticWinding(r103, 4, r101, r102, r104);
    L5:
        return monotonicQuadraticWinding(r100, 0, r101, r102, r104);
    }

    private static final void splitCubicAt(float[] r100, int r101, float[] r102, int r110, float r111) {
        if (r100.length >= (r101 + 8)) goto L6;
        return;
    L6:
        if (r102.length >= (r110 + 14)) goto L9;
        return;
    L9:
        if (r111 < 1.0f) goto L12;
        ArraysKt.copyInto(r100, r102, r110, r101, 8);
        float r112 = r100[r101 + 6];
        float r103 = r100[r101 + 7];
        r102[r110 + 8] = r112;
        r102[r110 + 9] = r103;
        r102[r110 + 10] = r112;
        r102[r110 + 11] = r103;
        r102[r110 + 12] = r112;
        r102[r110 + 13] = r103;
        return;
    L12:
        float r104 = r100[r101 + 0];
        float r105 = r100[r101 + 1];
        r102[r110 + 0] = r104;
        r102[r110 + 1] = r105;
        float r106 = r100[r101 + 2];
        float r107 = r100[r101 + 3];
        float r108 = MathHelpersKt.lerp(r104, r106, r111);
        float r109 = MathHelpersKt.lerp(r105, r107, r111);
        r102[r110 + 2] = r108;
        r102[r110 + 3] = r109;
        float r113 = r100[r101 + 4];
        float r114 = r100[r101 + 5];
        float r115 = MathHelpersKt.lerp(r106, r113, r111);
        float r116 = MathHelpersKt.lerp(r107, r114, r111);
        float r117 = MathHelpersKt.lerp(r108, r115, r111);
        float r118 = MathHelpersKt.lerp(r109, r116, r111);
        r102[r110 + 4] = r117;
        r102[r110 + 5] = r118;
        float r119 = r100[r101 + 6];
        float r120 = r100[r101 + 7];
        float r121 = MathHelpersKt.lerp(r113, r119, r111);
        float r122 = MathHelpersKt.lerp(r114, r120, r111);
        float r123 = MathHelpersKt.lerp(r115, r121, r111);
        float r124 = MathHelpersKt.lerp(r116, r122, r111);
        float r125 = MathHelpersKt.lerp(r117, r123, r111);
        float r126 = MathHelpersKt.lerp(r118, r124, r111);
        r102[r110 + 6] = r125;
        r102[r110 + 7] = r126;
        r102[r110 + 8] = r123;
        r102[r110 + 9] = r124;
        r102[r110 + 10] = r121;
        r102[r110 + 11] = r122;
        r102[r110 + 12] = r119;
        r102[r110 + 13] = r120;
    }

    public static final long computeCubicVerticalBounds(float r100, float r101, float r102, float r103, float[] r104, int r110) {
        float r105 = (r101 - r100) * 3.0f;
        float r106 = (r102 - r101) * 3.0f;
        float r107 = (r103 - r102) * 3.0f;
        int r108 = findQuadraticRoots(r105, r106, r107, r104, r110);
        float r109 = (r106 - r105) * 2.0f;
        float r111 = (r107 - r106) * 2.0f;
        float r112 = (-r109) / (r111 - r109);
        int r113 = r108 + access$writeValidRootInUnitRange(r112, r104, r110 + r108);
        float r114 = Math.min(r100, r103);
        float r115 = Math.max(r100, r103);
        int r116 = 0;
    L3:
        if (r116 >= r113) goto L6;
        float r117 = evaluateCubic(r100, r101, r102, r103, r104[r116]);
        r114 = Math.min(r114, r117);
        r115 = Math.max(r115, r117);
        r116 = r116 + 1;
        goto L3
    L6:
        return FloatFloatPair.m5constructorimpl(r114, r115);
    }

    public static /* synthetic */ int findLineRoot$default(float r100, float r101, float[] r102, int r103, int r104, Object r105) {
        if ((r104 & 8) == 0) goto L6;
        r103 = 0;
    L6:
        return access$writeValidRootInUnitRange((-r100) / (r101 - r100), r102, r103);
    }

    public static /* synthetic */ int findQuadraticRoots$default(float r100, float r101, float r102, float[] r103, int r104, int r105, Object r106) {
        if ((r105 & 16) == 0) goto L6;
        r104 = 0;
    L6:
        return findQuadraticRoots(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ long computeCubicVerticalBounds$default(float r100, float r101, float r102, float r103, float[] r110, int r111, int r112, Object r113) {
        if ((r112 & 32) == 0) goto L5;
        int r104 = 0;
    L7:
        return computeCubicVerticalBounds(r100, r101, r102, r103, r110, r104);
    L5:
        r104 = r111;
        goto L7
    }
}
