package androidx.compose.ui.graphics;

import D7.q;
import androidx.annotation.RestrictTo;
import androidx.collection.FloatFloatPair;
import androidx.compose.ui.graphics.PathSegment;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b'\u001a\u001f\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a7\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\n\u001a\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0005\u001a \u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0082\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\n\u001a/\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0018\u0010\u000f\u001a2\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0082\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a9\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a/\u0010#\u001a\u00020\u001b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b#\u0010$\u001a)\u0010&\u001a\u00020%2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b&\u0010'\u001a)\u0010(\u001a\u00020%2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b(\u0010'\u001aA\u0010+\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010/\u001a\u00020!*\u00020-2\u0006\u0010.\u001a\u00020-H\u0080\b¢\u0006\u0004\b/\u00100\u001a\u001c\u0010/\u001a\u00020!*\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b/\u00101\u001a\u0018\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0002H\u0082\b¢\u0006\u0004\b3\u00104\u001a'\u00105\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b5\u00106\u001a'\u0010:\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0002H\u0000¢\u0006\u0004\b:\u0010;\u001a'\u0010?\u001a\u00020!2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u0002H\u0002¢\u0006\u0004\b?\u0010@\u001a7\u0010C\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u0019H\u0000¢\u0006\u0004\bC\u0010D\u001a7\u0010F\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0019H\u0002¢\u0006\u0004\bF\u0010G\u001a\u001f\u0010J\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0019H\u0002¢\u0006\u0004\bJ\u0010K\u001a'\u0010N\u001a\u00020M2\u0006\u0010L\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\bN\u0010O\u001a\u001f\u0010P\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0002H\u0002¢\u0006\u0004\bP\u0010\u0016\u001a7\u0010R\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u0019H\u0000¢\u0006\u0004\bR\u0010D\u001a/\u0010S\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0002H\u0002¢\u0006\u0004\bS\u0010T\u001a'\u0010W\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u0019H\u0002¢\u0006\u0004\bW\u0010X\u001a\u001f\u0010Z\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020\u0019H\u0002¢\u0006\u0004\bZ\u0010K\u001a7\u0010]\u001a\u00020M2\u0006\u0010L\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b]\u0010^\u001aO\u0010d\u001a\u00020\u00022\u0006\u0010_\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00022\u0006\u0010`\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010b\u001a\u00020\u00022\u0006\u0010c\u001a\u00020\u0002H\u0000¢\u0006\u0004\bd\u0010e\"\u0014\u0010f\u001a\u00020-8\u0002X\u0082T¢\u0006\u0006\n\u0004\bf\u0010g\"\u0014\u0010h\u001a\u00020-8\u0002X\u0082T¢\u0006\u0006\n\u0004\bh\u0010g\"\u0014\u0010i\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bi\u0010j\"\u0019\u0010m\u001a\u00020\u0002*\u00020\u00008Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010l\"\u0018\u0010o\u001a\u00020\u0002*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010l\"\u0019\u0010q\u001a\u00020\u0002*\u00020\u00008Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u0010l\"\u0018\u0010s\u001a\u00020\u0002*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\br\u0010l¨\u0006t"}, d2 = {"Landroidx/compose/ui/graphics/PathSegment;", "segment", "", "t", "evaluateX", "(Landroidx/compose/ui/graphics/PathSegment;F)F", "evaluateY", "p0y", "p1y", "evaluateLine", "(FFF)F", "p0", "p1", "p2", "evaluateQuadratic", "(FFFF)F", "p3", "evaluateCubic", "(FFFFF)F", "fraction", "findFirstRoot", "findFirstLineRoot", "(FF)F", "findFirstQuadraticRoot", "findFirstCubicRoot", "", "roots", "", "index", "findLineRoot", "(FF[FI)I", "findQuadraticRoots", "(FFF[FI)I", "", "horizontal", "findDerivativeRoots", "(Landroidx/compose/ui/graphics/PathSegment;Z[FI)I", "Landroidx/collection/FloatFloatPair;", "computeHorizontalBounds", "(Landroidx/compose/ui/graphics/PathSegment;[FI)J", "computeVerticalBounds", "p2y", "p3y", "computeCubicVerticalBounds", "(FFFF[FI)J", "", "b", "closeTo", "(DD)Z", "(FF)Z", "r", "clampValidRootInUnitRange", "(F)F", "writeValidRootInUnitRange", "(F[FI)I", "points", "x", "y", "lineWinding", "([FFF)I", "y0", "y1", "y2", "isQuadraticMonotonic", "(FFF)Z", "tmpQuadratics", "tmpRoots", "quadraticWinding", "([FFF[F[F)I", TypedValues.CycleType.S_WAVE_OFFSET, "monotonicQuadraticWinding", "([FIFF[F)I", "quadratic", "dst", "quadraticToMonotonicQuadratics", "([F[F)I", "src", "LC7/r;", "splitQuadraticAt", "([F[FF)V", "unitDivide", "tmpCubics", "cubicWinding", "monotonicCubicWinding", "([FIFF)I", "cubic", "tmpRoot", "cubicToMonotonicCubics", "([F[F[F)I", "dstRoots", "findCubicExtremaY", "srcOffset", "dstOffset", "splitCubicAt", "([FI[FIF)V", "x0", "x1", "x2", "x3", "y3", "cubicArea", "(FFFFFFFF)F", "Tau", "D", "Epsilon", "FloatEpsilon", "F", "getStartX", "(Landroidx/compose/ui/graphics/PathSegment;)F", "startX", "getEndX", "endX", "getStartY", "startY", "getEndY", "endY", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BezierKt {
    private static final double Epsilon = 1.0E-7d;
    private static final float FloatEpsilon = 1.05E-6f;
    private static final double Tau = 6.283185307179586d;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PathSegment.Type.Conic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PathSegment.Type.Close.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final float clampValidRootInUnitRange(float f) {
        float f7 = f >= 0.0f ? f : 0.0f;
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        if (Math.abs(f7 - f) > FloatEpsilon) {
            return Float.NaN;
        }
        return f7;
    }

    public static final boolean closeTo(double d, double d6) {
        return Math.abs(d - d6) < Epsilon;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final long computeCubicVerticalBounds(float f, float f7, float f9, float f10, float[] fArr, int i) {
        float f11 = (f7 - f) * 3.0f;
        float f12 = (f9 - f7) * 3.0f;
        float f13 = (f10 - f9) * 3.0f;
        int iFindQuadraticRoots = findQuadraticRoots(f11, f12, f13, fArr, i);
        float f14 = (f12 - f11) * 2.0f;
        int iWriteValidRootInUnitRange = writeValidRootInUnitRange((-f14) / (((f13 - f12) * 2.0f) - f14), fArr, i + iFindQuadraticRoots) + iFindQuadraticRoots;
        float fMin = Math.min(f, f10);
        float fMax = Math.max(f, f10);
        for (int i6 = 0; i6 < iWriteValidRootInUnitRange; i6++) {
            float fEvaluateCubic = evaluateCubic(f, f7, f9, f10, fArr[i6]);
            fMin = Math.min(fMin, fEvaluateCubic);
            fMax = Math.max(fMax, fEvaluateCubic);
        }
        return FloatFloatPair.m11constructorimpl(fMin, fMax);
    }

    public static /* synthetic */ long computeCubicVerticalBounds$default(float f, float f7, float f9, float f10, float[] fArr, int i, int i6, Object obj) {
        if ((i6 & 32) != 0) {
            i = 0;
        }
        return computeCubicVerticalBounds(f, f7, f9, f10, fArr, i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final long computeHorizontalBounds(PathSegment pathSegment, float[] fArr, int i) {
        int iFindDerivativeRoots = findDerivativeRoots(pathSegment, true, fArr, i);
        float fMin = Math.min(pathSegment.getPoints()[0], getEndX(pathSegment));
        float fMax = Math.max(pathSegment.getPoints()[0], getEndX(pathSegment));
        for (int i6 = 0; i6 < iFindDerivativeRoots; i6++) {
            float fEvaluateX = evaluateX(pathSegment, fArr[i6]);
            fMin = Math.min(fMin, fEvaluateX);
            fMax = Math.max(fMax, fEvaluateX);
        }
        return FloatFloatPair.m11constructorimpl(fMin, fMax);
    }

    public static /* synthetic */ long computeHorizontalBounds$default(PathSegment pathSegment, float[] fArr, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = 0;
        }
        return computeHorizontalBounds(pathSegment, fArr, i);
    }

    public static final long computeVerticalBounds(PathSegment pathSegment, float[] fArr, int i) {
        int iFindDerivativeRoots = findDerivativeRoots(pathSegment, false, fArr, i);
        float fMin = Math.min(pathSegment.getPoints()[1], getEndY(pathSegment));
        float fMax = Math.max(pathSegment.getPoints()[1], getEndY(pathSegment));
        for (int i6 = 0; i6 < iFindDerivativeRoots; i6++) {
            float fEvaluateY = evaluateY(pathSegment, fArr[i6]);
            fMin = Math.min(fMin, fEvaluateY);
            fMax = Math.max(fMax, fEvaluateY);
        }
        return FloatFloatPair.m11constructorimpl(fMin, fMax);
    }

    public static /* synthetic */ long computeVerticalBounds$default(PathSegment pathSegment, float[] fArr, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = 0;
        }
        return computeVerticalBounds(pathSegment, fArr, i);
    }

    public static final float cubicArea(float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14) {
        return ((((((f / 3.0f) + f11) * f14) + (B7.a.b(f, f11, f10, ((f9 + f11) * (f14 - f7)) - ((f10 + f12) * (f13 - f))) - ((f7 - f12) * f9))) - (((f7 / 3.0f) + f12) * f13)) * 3.0f) / 20.0f;
    }

    private static final int cubicToMonotonicCubics(float[] fArr, float[] fArr2, float[] fArr3) {
        int iFindCubicExtremaY = findCubicExtremaY(fArr, fArr3);
        int i = 0;
        if (iFindCubicExtremaY == 0) {
            if (fArr2.length < 8) {
                return 0;
            }
            q.V(fArr, 0, fArr2, 0, 8);
            return iFindCubicExtremaY;
        }
        int i6 = 0;
        float f = 0.0f;
        while (i < iFindCubicExtremaY) {
            float f7 = (fArr3[i] - f) / (1.0f - f);
            if (f7 < 0.0f) {
                f7 = 0.0f;
            }
            f = f7 > 1.0f ? 1.0f : f7;
            splitCubicAt(fArr, i6, fArr2, i6, f);
            i6 += 6;
            i++;
            fArr = fArr2;
        }
        return iFindCubicExtremaY;
    }

    public static final int cubicWinding(float[] fArr, float f, float f7, float[] fArr2, float[] fArr3) {
        int iCubicToMonotonicCubics = cubicToMonotonicCubics(fArr, fArr2, fArr3);
        int iMonotonicCubicWinding = 0;
        if (iCubicToMonotonicCubics >= 0) {
            int i = 0;
            while (true) {
                iMonotonicCubicWinding += monotonicCubicWinding(fArr2, i * 6, f, f7);
                if (i == iCubicToMonotonicCubics) {
                    break;
                }
                i++;
            }
        }
        return iMonotonicCubicWinding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final float evaluateCubic(float f, float f7, float f9) {
        return ((((((f - f7) + 0.33333334f) * f9) + (f7 - (2.0f * f))) * f9) + f) * 3.0f * f9;
    }

    private static final float evaluateLine(float f, float f7, float f9) {
        return B7.a.b(f7, f, f9, f);
    }

    private static final float evaluateQuadratic(float f, float f7, float f9, float f10) {
        return (((((f9 - (f7 * 2.0f)) + f) * f10) + ((f7 - f) * 2.0f)) * f10) + f;
    }

    private static final float evaluateX(PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        int i = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
        if (i == 1) {
            return points[0];
        }
        if (i == 2) {
            return evaluateLine(points[0], points[2], f);
        }
        if (i == 3) {
            return evaluateQuadratic(points[0], points[2], points[4], f);
        }
        if (i != 4) {
            return Float.NaN;
        }
        return evaluateCubic(points[0], points[2], points[4], points[6], f);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final float evaluateY(PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        int i = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
        if (i == 1) {
            return points[1];
        }
        if (i == 2) {
            return evaluateLine(points[1], points[3], f);
        }
        if (i == 3) {
            return evaluateQuadratic(points[1], points[3], points[5], f);
        }
        if (i != 4) {
            return Float.NaN;
        }
        return evaluateCubic(points[1], points[3], points[5], points[7], f);
    }

    private static final int findCubicExtremaY(float[] fArr, float[] fArr2) {
        float f = fArr[1];
        float f7 = fArr[3];
        float f9 = fArr[5];
        return findQuadraticRoots(B7.a.b(f7, f9, 3.0f, fArr[7] - f), (((f - f7) - f7) - f9) * 2.0f, f7 - f, fArr2, 0);
    }

    private static final int findDerivativeRoots(PathSegment pathSegment, boolean z10, float[] fArr, int i) {
        int i6 = !z10 ? 1 : 0;
        float[] points = pathSegment.getPoints();
        int i10 = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
        if (i10 == 3) {
            float f = 2;
            float f7 = points[i6 + 2];
            float f9 = (f7 - points[i6]) * f;
            return writeValidRootInUnitRange((-f9) / (((points[i6 + 4] - f7) * f) - f9), fArr, i);
        }
        if (i10 != 4) {
            return 0;
        }
        float f10 = points[i6 + 2];
        float f11 = (f10 - points[i6]) * 3.0f;
        float f12 = points[i6 + 4];
        float f13 = (f12 - f10) * 3.0f;
        float f14 = (points[i6 + 6] - f12) * 3.0f;
        int iFindQuadraticRoots = findQuadraticRoots(f11, f13, f14, fArr, i);
        float f15 = (f13 - f11) * 2.0f;
        return writeValidRootInUnitRange((-f15) / (((f14 - f13) * 2.0f) - f15), fArr, i + iFindQuadraticRoots) + iFindQuadraticRoots;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final float findFirstCubicRoot(float f, float f7, float f9, float f10) {
        float f11;
        float f12;
        double d = f;
        double d6 = ((d - (f7 * 2.0d)) + f9) * 3.0d;
        double d10 = (f7 - f) * 3.0d;
        double d11 = ((f7 - f9) * 3.0d) + (-f) + f10;
        if (Math.abs(d11 - 0.0d) < Epsilon) {
            if (Math.abs(d6 - 0.0d) < Epsilon) {
                if (Math.abs(d10 - 0.0d) < Epsilon) {
                    return Float.NaN;
                }
                float f13 = (float) ((-d) / d10);
                f11 = f13 >= 0.0f ? f13 : 0.0f;
                f12 = f11 <= 1.0f ? f11 : 1.0f;
                if (Math.abs(f12 - f13) > FloatEpsilon) {
                    return Float.NaN;
                }
                return f12;
            }
            double dSqrt = Math.sqrt((d10 * d10) - ((4.0d * d6) * d));
            double d12 = d6 * 2.0d;
            float f14 = (float) ((dSqrt - d10) / d12);
            float f15 = f14 < 0.0f ? 0.0f : f14;
            if (f15 > 1.0f) {
                f15 = 1.0f;
            }
            if (Math.abs(f15 - f14) > FloatEpsilon) {
                f15 = Float.NaN;
            }
            if (!Float.isNaN(f15)) {
                return f15;
            }
            float f16 = (float) (((-d10) - dSqrt) / d12);
            f11 = f16 >= 0.0f ? f16 : 0.0f;
            f12 = f11 <= 1.0f ? f11 : 1.0f;
            if (Math.abs(f12 - f16) > FloatEpsilon) {
                return Float.NaN;
            }
            return f12;
        }
        double d13 = d6 / d11;
        double d14 = d10 / d11;
        double d15 = d / d11;
        double d16 = ((d14 * 3.0d) - (d13 * d13)) / 9.0d;
        double d17 = ((d15 * 27.0d) + ((((2.0d * d13) * d13) * d13) - ((9.0d * d13) * d14))) / 54.0d;
        double d18 = d16 * d16 * d16;
        double d19 = (d17 * d17) + d18;
        double d20 = d13 / 3.0d;
        if (d19 >= 0.0d) {
            if (d19 != 0.0d) {
                double dSqrt2 = Math.sqrt(d19);
                float fFastCbrt = (float) ((MathHelpersKt.fastCbrt((float) ((-d17) + dSqrt2)) - MathHelpersKt.fastCbrt((float) (d17 + dSqrt2))) - d20);
                f11 = fFastCbrt >= 0.0f ? fFastCbrt : 0.0f;
                f12 = f11 <= 1.0f ? f11 : 1.0f;
                if (Math.abs(f12 - fFastCbrt) > FloatEpsilon) {
                    return Float.NaN;
                }
                return f12;
            }
            float f17 = -MathHelpersKt.fastCbrt((float) d17);
            float f18 = (float) d20;
            float f19 = (2.0f * f17) - f18;
            float f20 = f19 < 0.0f ? 0.0f : f19;
            if (f20 > 1.0f) {
                f20 = 1.0f;
            }
            if (Math.abs(f20 - f19) > FloatEpsilon) {
                f20 = Float.NaN;
            }
            if (!Float.isNaN(f20)) {
                return f20;
            }
            float f21 = (-f17) - f18;
            f11 = f21 >= 0.0f ? f21 : 0.0f;
            f12 = f11 <= 1.0f ? f11 : 1.0f;
            if (Math.abs(f12 - f21) > FloatEpsilon) {
                return Float.NaN;
            }
            return f12;
        }
        double dSqrt3 = Math.sqrt(-d18);
        double d21 = (-d17) / dSqrt3;
        if (d21 < -1.0d) {
            d21 = -1.0d;
        }
        if (d21 > 1.0d) {
            d21 = 1.0d;
        }
        double dAcos = Math.acos(d21);
        double dFastCbrt = MathHelpersKt.fastCbrt((float) dSqrt3) * 2.0f;
        float fCos = (float) ((Math.cos(dAcos / 3.0d) * dFastCbrt) - d20);
        float f22 = fCos < 0.0f ? 0.0f : fCos;
        if (f22 > 1.0f) {
            f22 = 1.0f;
        }
        if (Math.abs(f22 - fCos) > FloatEpsilon) {
            f22 = Float.NaN;
        }
        if (!Float.isNaN(f22)) {
            return f22;
        }
        float fCos2 = (float) ((Math.cos((Tau + dAcos) / 3.0d) * dFastCbrt) - d20);
        float f23 = fCos2 < 0.0f ? 0.0f : fCos2;
        if (f23 > 1.0f) {
            f23 = 1.0f;
        }
        if (Math.abs(f23 - fCos2) > FloatEpsilon) {
            f23 = Float.NaN;
        }
        if (!Float.isNaN(f23)) {
            return f23;
        }
        float fCos3 = (float) ((Math.cos((dAcos + 12.566370614359172d) / 3.0d) * dFastCbrt) - d20);
        f11 = fCos3 >= 0.0f ? fCos3 : 0.0f;
        f12 = f11 <= 1.0f ? f11 : 1.0f;
        if (Math.abs(f12 - fCos3) > FloatEpsilon) {
            return Float.NaN;
        }
        return f12;
    }

    private static final float findFirstLineRoot(float f, float f7) {
        float f9 = (-f) / (f7 - f);
        float f10 = f9 >= 0.0f ? f9 : 0.0f;
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        if (Math.abs(f10 - f9) > FloatEpsilon) {
            return Float.NaN;
        }
        return f10;
    }

    private static final float findFirstQuadraticRoot(float f, float f7, float f9) {
        float f10;
        float f11;
        double d = f;
        double d6 = f7;
        double d10 = f9;
        double d11 = d6 * 2.0d;
        double d12 = (d - d11) + d10;
        if (d12 == 0.0d) {
            if (d6 == d10) {
                return Float.NaN;
            }
            float f12 = (float) ((d11 - d10) / (d11 - (d10 * 2.0d)));
            f10 = f12 >= 0.0f ? f12 : 0.0f;
            f11 = f10 <= 1.0f ? f10 : 1.0f;
            if (Math.abs(f11 - f12) > FloatEpsilon) {
                return Float.NaN;
            }
            return f11;
        }
        double d13 = -Math.sqrt((d6 * d6) - (d10 * d));
        double d14 = (-d) + d6;
        float f13 = (float) ((-(d13 + d14)) / d12);
        float f14 = f13 < 0.0f ? 0.0f : f13;
        if (f14 > 1.0f) {
            f14 = 1.0f;
        }
        if (Math.abs(f14 - f13) > FloatEpsilon) {
            f14 = Float.NaN;
        }
        if (!Float.isNaN(f14)) {
            return f14;
        }
        float f15 = (float) ((d13 - d14) / d12);
        f10 = f15 >= 0.0f ? f15 : 0.0f;
        f11 = f10 <= 1.0f ? f10 : 1.0f;
        if (Math.abs(f11 - f15) > FloatEpsilon) {
            return Float.NaN;
        }
        return f11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final float findFirstRoot(PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
                return Float.NaN;
            case 2:
                float f7 = points[0] - f;
                float f9 = (-f7) / ((points[2] - f) - f7);
                float f10 = f9 >= 0.0f ? f9 : 0.0f;
                if (f10 > 1.0f) {
                    f10 = 1.0f;
                }
                if (Math.abs(f10 - f9) > FloatEpsilon) {
                    return Float.NaN;
                }
                return f10;
            case 3:
                return findFirstQuadraticRoot(points[0] - f, points[2] - f, points[4] - f);
            case 4:
                return findFirstCubicRoot(points[0] - f, points[2] - f, points[4] - f, points[6] - f);
            case 5:
            case 6:
            case 7:
                return Float.NaN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final int findLineRoot(float f, float f7, float[] fArr, int i) {
        return writeValidRootInUnitRange((-f) / (f7 - f), fArr, i);
    }

    public static /* synthetic */ int findLineRoot$default(float f, float f7, float[] fArr, int i, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            i = 0;
        }
        return writeValidRootInUnitRange((-f) / (f7 - f), fArr, i);
    }

    private static final int findQuadraticRoots(float f, float f7, float f9, float[] fArr, int i) {
        double d = f;
        double d6 = f7;
        double d10 = f9;
        double d11 = d6 * 2.0d;
        double d12 = (d - d11) + d10;
        if (d12 == 0.0d) {
            if (d6 == d10) {
                return 0;
            }
            return writeValidRootInUnitRange((float) ((d11 - d10) / (d11 - (d10 * 2.0d))), fArr, i);
        }
        double d13 = -Math.sqrt((d6 * d6) - (d10 * d));
        double d14 = (-d) + d6;
        int iWriteValidRootInUnitRange = writeValidRootInUnitRange((float) ((-(d13 + d14)) / d12), fArr, i);
        int iWriteValidRootInUnitRange2 = iWriteValidRootInUnitRange + writeValidRootInUnitRange((float) ((d13 - d14) / d12), fArr, i + iWriteValidRootInUnitRange);
        if (iWriteValidRootInUnitRange2 <= 1) {
            return iWriteValidRootInUnitRange2;
        }
        float f10 = fArr[i];
        int i6 = i + 1;
        float f11 = fArr[i6];
        if (f10 <= f11) {
            return f10 == f11 ? iWriteValidRootInUnitRange2 - 1 : iWriteValidRootInUnitRange2;
        }
        fArr[i] = f11;
        fArr[i6] = f10;
        return iWriteValidRootInUnitRange2;
    }

    public static /* synthetic */ int findQuadraticRoots$default(float f, float f7, float f9, float[] fArr, int i, int i6, Object obj) {
        if ((i6 & 16) != 0) {
            i = 0;
        }
        return findQuadraticRoots(f, f7, f9, fArr, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float getEndX(androidx.compose.ui.graphics.PathSegment r3) {
        /*
            float[] r0 = r3.getPoints()
            androidx.compose.ui.graphics.PathSegment$Type r3 = r3.getType()
            int[] r1 = androidx.compose.ui.graphics.BezierKt.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r1[r3]
            r1 = 2
            if (r3 == r1) goto L21
            r1 = 3
            r2 = 4
            if (r3 == r1) goto L1e
            if (r3 == r2) goto L20
            r1 = 5
            if (r3 == r1) goto L1e
            r1 = 0
            goto L21
        L1e:
            r1 = r2
            goto L21
        L20:
            r1 = 6
        L21:
            r3 = r0[r1]
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.BezierKt.getEndX(androidx.compose.ui.graphics.PathSegment):float");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float getEndY(androidx.compose.ui.graphics.PathSegment r3) {
        /*
            float[] r0 = r3.getPoints()
            androidx.compose.ui.graphics.PathSegment$Type r3 = r3.getType()
            int[] r1 = androidx.compose.ui.graphics.BezierKt.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r1[r3]
            r1 = 2
            r2 = 3
            if (r3 == r1) goto L21
            r1 = 5
            if (r3 == r2) goto L1e
            r2 = 4
            if (r3 == r2) goto L20
            if (r3 == r1) goto L1e
            r2 = 0
            goto L21
        L1e:
            r2 = r1
            goto L21
        L20:
            r2 = 7
        L21:
            r3 = r0[r2]
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.BezierKt.getEndY(androidx.compose.ui.graphics.PathSegment):float");
    }

    private static final float getStartX(PathSegment pathSegment) {
        return pathSegment.getPoints()[0];
    }

    private static final float getStartY(PathSegment pathSegment) {
        return pathSegment.getPoints()[1];
    }

    private static final boolean isQuadraticMonotonic(float f, float f7, float f9) {
        return !(Math.signum(f7 - f9) + Math.signum(f - f7) == 0.0f);
    }

    public static final int lineWinding(float[] fArr, float f, float f7) {
        int i;
        float f9;
        if (fArr.length < 4) {
            return 0;
        }
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float f13 = fArr[3];
        float f14 = f13 - f11;
        if (f11 > f13) {
            i = -1;
            f9 = f11;
        } else {
            i = 1;
            f9 = f13;
            f13 = f11;
        }
        if (f7 < f13 || f7 >= f9) {
            return 0;
        }
        float f15 = ((f7 - f11) * (f12 - f10)) - ((f - f10) * f14);
        if (f15 == 0.0f || ((int) Math.signum(f15)) == i) {
            return 0;
        }
        return i;
    }

    private static final int monotonicCubicWinding(float[] fArr, int i, float f, float f7) {
        int i6;
        int i10 = i + 1;
        float f9 = fArr[i10];
        int i11 = i + 7;
        float f10 = fArr[i11];
        if (f9 > f10) {
            i6 = -1;
            f10 = f9;
            f9 = f10;
        } else {
            i6 = 1;
        }
        if (f7 >= f9 && f7 < f10) {
            float f11 = fArr[i];
            float f12 = fArr[i + 2];
            float f13 = fArr[i + 4];
            float f14 = fArr[i + 6];
            if (f < Math.min(f11, Math.min(f12, Math.min(f13, f14)))) {
                return 0;
            }
            if (f <= Math.max(f11, Math.max(f12, Math.max(f13, f14)))) {
                float f15 = fArr[i10];
                float f16 = fArr[i + 3];
                float f17 = fArr[i + 5];
                float f18 = fArr[i11];
                float fFindFirstCubicRoot = findFirstCubicRoot(f15 - f7, f16 - f7, f17 - f7, f18 - f7);
                if (Float.isNaN(fFindFirstCubicRoot)) {
                    return 0;
                }
                float fEvaluateCubic = evaluateCubic(f11, f12, f13, f14, fFindFirstCubicRoot);
                if ((Math.abs(fEvaluateCubic - f) >= FloatEpsilon || (f == f14 && f7 == f18)) && fEvaluateCubic < f) {
                }
            }
            return i6;
        }
        return 0;
    }

    private static final int monotonicQuadraticWinding(float[] fArr, int i, float f, float f7, float[] fArr2) {
        int i6;
        float f9;
        float f10;
        float f11 = fArr[i + 1];
        float f12 = fArr[i + 5];
        if (f11 > f12) {
            i6 = -1;
            f10 = f11;
            f9 = f12;
        } else {
            i6 = 1;
            f9 = f11;
            f10 = f12;
        }
        if (f7 >= f9 && f7 < f10) {
            float f13 = fArr[i + 3];
            float fEvaluateQuadratic = findQuadraticRoots$default((f11 - (f13 * 2.0f)) + f12, (f13 - f11) * 2.0f, f11 - f7, fArr2, 0, 16, null) == 0 ? fArr[(1 - i6) * 2] : evaluateQuadratic(fArr[0], fArr[2], fArr[4], fArr2[0]);
            if ((Math.abs(fEvaluateQuadratic - f) >= FloatEpsilon || (f == fArr[4] && f7 == f12)) && fEvaluateQuadratic < f) {
                return i6;
            }
        }
        return 0;
    }

    private static final int quadraticToMonotonicQuadratics(float[] fArr, float[] fArr2) {
        if (fArr.length < 6 || fArr2.length < 6) {
            return 0;
        }
        float f = fArr[1];
        float f7 = fArr[3];
        float f9 = fArr[5];
        if (!isQuadraticMonotonic(f, f7, f9)) {
            float f10 = f - f7;
            float fUnitDivide = unitDivide(f10, (f10 - f7) + f9);
            if (!Float.isNaN(fUnitDivide)) {
                splitQuadraticAt(fArr, fArr2, fUnitDivide);
                return 1;
            }
            if (Math.abs(f10) >= Math.abs(f7 - f9)) {
                f = f9;
            }
            f7 = f;
        }
        q.V(fArr, 0, fArr2, 0, 6);
        fArr2[3] = f7;
        return 0;
    }

    public static final int quadraticWinding(float[] fArr, float f, float f7, float[] fArr2, float[] fArr3) {
        if (isQuadraticMonotonic(fArr[1], fArr[3], fArr[5])) {
            return monotonicQuadraticWinding(fArr, 0, f, f7, fArr3);
        }
        int iQuadraticToMonotonicQuadratics = quadraticToMonotonicQuadratics(fArr, fArr2);
        int iMonotonicQuadraticWinding = monotonicQuadraticWinding(fArr2, 0, f, f7, fArr3);
        return iQuadraticToMonotonicQuadratics > 0 ? iMonotonicQuadraticWinding + monotonicQuadraticWinding(fArr2, 4, f, f7, fArr3) : iMonotonicQuadraticWinding;
    }

    private static final void splitCubicAt(float[] fArr, int i, float[] fArr2, int i6, float f) {
        if (fArr.length >= i + 8 && fArr2.length >= i6 + 14) {
            if (f >= 1.0f) {
                q.V(fArr, i6, fArr2, i, 8);
                float f7 = fArr[i + 6];
                float f9 = fArr[i + 7];
                fArr2[i6 + 8] = f7;
                fArr2[i6 + 9] = f9;
                fArr2[i6 + 10] = f7;
                fArr2[i6 + 11] = f9;
                fArr2[i6 + 12] = f7;
                fArr2[i6 + 13] = f9;
                return;
            }
            float f10 = fArr[i];
            float f11 = fArr[i + 1];
            fArr2[i6] = f10;
            fArr2[i6 + 1] = f11;
            float f12 = fArr[i + 2];
            float f13 = fArr[i + 3];
            float fLerp = MathHelpersKt.lerp(f10, f12, f);
            float fLerp2 = MathHelpersKt.lerp(f11, f13, f);
            fArr2[i6 + 2] = fLerp;
            fArr2[i6 + 3] = fLerp2;
            float f14 = fArr[i + 4];
            float f15 = fArr[i + 5];
            float fLerp3 = MathHelpersKt.lerp(f12, f14, f);
            float fLerp4 = MathHelpersKt.lerp(f13, f15, f);
            float fLerp5 = MathHelpersKt.lerp(fLerp, fLerp3, f);
            float fLerp6 = MathHelpersKt.lerp(fLerp2, fLerp4, f);
            fArr2[i6 + 4] = fLerp5;
            fArr2[i6 + 5] = fLerp6;
            float f16 = fArr[i + 6];
            float f17 = fArr[i + 7];
            float fLerp7 = MathHelpersKt.lerp(f14, f16, f);
            float fLerp8 = MathHelpersKt.lerp(f15, f17, f);
            float fLerp9 = MathHelpersKt.lerp(fLerp3, fLerp7, f);
            float fLerp10 = MathHelpersKt.lerp(fLerp4, fLerp8, f);
            float fLerp11 = MathHelpersKt.lerp(fLerp5, fLerp9, f);
            float fLerp12 = MathHelpersKt.lerp(fLerp6, fLerp10, f);
            fArr2[i6 + 6] = fLerp11;
            fArr2[i6 + 7] = fLerp12;
            fArr2[i6 + 8] = fLerp9;
            fArr2[i6 + 9] = fLerp10;
            fArr2[i6 + 10] = fLerp7;
            fArr2[i6 + 11] = fLerp8;
            fArr2[i6 + 12] = f16;
            fArr2[i6 + 13] = f17;
        }
    }

    private static final void splitQuadraticAt(float[] fArr, float[] fArr2, float f) {
        if (fArr.length >= 6 && fArr2.length >= 10) {
            float f7 = fArr[0];
            float f9 = fArr[1];
            float f10 = fArr[2];
            float f11 = fArr[3];
            float f12 = fArr[4];
            float f13 = fArr[5];
            float fLerp = MathHelpersKt.lerp(f7, f10, f);
            float fLerp2 = MathHelpersKt.lerp(f9, f11, f);
            fArr2[0] = f7;
            fArr2[1] = f9;
            fArr2[2] = fLerp;
            fArr2[3] = fLerp2;
            float fLerp3 = MathHelpersKt.lerp(f10, f12, f);
            float fLerp4 = MathHelpersKt.lerp(f11, f13, f);
            float fLerp5 = MathHelpersKt.lerp(fLerp, fLerp3, f);
            float fLerp6 = MathHelpersKt.lerp(fLerp2, fLerp4, f);
            fArr2[4] = fLerp5;
            fArr2[5] = fLerp6;
            fArr2[6] = fLerp3;
            fArr2[7] = fLerp4;
            fArr2[8] = f12;
            fArr2[9] = f13;
        }
    }

    private static final float unitDivide(float f, float f7) {
        if (f < 0.0f) {
            f = -f;
            f7 = -f7;
        }
        if (f7 == 0.0f || f == 0.0f || f >= f7) {
            return Float.NaN;
        }
        float f9 = f / f7;
        if (f9 == 0.0f) {
            return Float.NaN;
        }
        return f9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int writeValidRootInUnitRange(float f, float[] fArr, int i) {
        float f7 = f >= 0.0f ? f : 0.0f;
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        if (Math.abs(f7 - f) > FloatEpsilon) {
            f7 = Float.NaN;
        }
        fArr[i] = f7;
        return !Float.isNaN(f7) ? 1 : 0;
    }

    public static final boolean closeTo(float f, float f7) {
        return Math.abs(f - f7) < FloatEpsilon;
    }

    private static final float evaluateCubic(float f, float f7, float f9, float f10, float f11) {
        float f12 = (((f7 - f9) * 3.0f) + f10) - f;
        return (((((f12 * f11) + (((f9 - (2.0f * f7)) + f) * 3.0f)) * f11) + ((f7 - f) * 3.0f)) * f11) + f;
    }
}
