package androidx.graphics.shapes;

import H4.o;
import androidx.collection.FloatFloatPair;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b \b\u0002\u0018\u00002\u00020\u0001B7\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJf\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0015\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0016\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019JJ\u0010\u001f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u001b\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u001c\u001a\u00060\u0002j\u0002`\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000bH\u0007¢\u0006\u0004\b#\u0010$R!\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010'R!\u0010\u0005\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b(\u0010'R!\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b)\u0010'R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b+\u0010,R!\u0010\u001c\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001c\u0010%\u001a\u0004\b-\u0010'R!\u0010.\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b/\u0010'R\u0017\u00100\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00104\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R\u0017\u00106\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00103R\u0017\u00108\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\u0017\u0010:\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b:\u00101\u001a\u0004\b;\u00103R,\u0010<\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b<\u0010%\u001a\u0004\b=\u0010'\"\u0004\b>\u0010?R\u0011\u0010A\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b@\u00103\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/graphics/shapes/RoundedCorner;", "", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "p0", "p1", "p2", "Landroidx/graphics/shapes/CornerRounding;", "rounding", AppAgent.CONSTRUCT, "(JJJLandroidx/graphics/shapes/CornerRounding;Lkotlin/jvm/internal/e;)V", "", "allowedCut", "calculateActualSmoothingValue", "(F)F", "actualRoundCut", "actualSmoothingValues", "corner", "sideStart", "circleSegmentIntersection", "otherCircleSegmentIntersection", "circleCenter", "actualR", "Landroidx/graphics/shapes/Cubic;", "computeFlankingCurve-oAJzIJU", "(FFJJJJJF)Landroidx/graphics/shapes/Cubic;", "computeFlankingCurve", "d0", "d1", "lineIntersection-CBFvKDc", "(JJJJ)Landroidx/collection/FloatFloatPair;", "lineIntersection", "allowedCut0", "allowedCut1", "", "getCubics", "(FF)Ljava/util/List;", "J", "getP0-1ufDz9w", "()J", "getP1-1ufDz9w", "getP2-1ufDz9w", "Landroidx/graphics/shapes/CornerRounding;", "getRounding", "()Landroidx/graphics/shapes/CornerRounding;", "getD1-1ufDz9w", "d2", "getD2-1ufDz9w", "cornerRadius", "F", "getCornerRadius", "()F", "smoothing", "getSmoothing", "cosAngle", "getCosAngle", "sinAngle", "getSinAngle", "expectedRoundCut", "getExpectedRoundCut", "center", "getCenter-1ufDz9w", "setCenter-DnnuFBc", "(J)V", "getExpectedCut", "expectedCut", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;
    private final long d1;
    private final long d2;
    private final float expectedRoundCut;
    private final long p0;
    private final long p1;
    private final long p2;
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    public /* synthetic */ RoundedCorner(long j5, long j6, long j10, CornerRounding cornerRounding, e eVar) {
        this(j5, j6, j10, cornerRounding);
    }

    private final float calculateActualSmoothingValue(float allowedCut) {
        if (allowedCut > getExpectedCut()) {
            return this.smoothing;
        }
        float f = this.expectedRoundCut;
        if (allowedCut <= f) {
            return 0.0f;
        }
        return ((allowedCut - f) * this.smoothing) / (getExpectedCut() - this.expectedRoundCut);
    }

    /* renamed from: computeFlankingCurve-oAJzIJU, reason: not valid java name */
    private final Cubic m7147computeFlankingCurveoAJzIJU(float actualRoundCut, float actualSmoothingValues, long corner, long sideStart, long circleSegmentIntersection, long otherCircleSegmentIntersection, long circleCenter, float actualR) {
        long jM7134getDirectionDnnuFBc = PointKt.m7134getDirectionDnnuFBc(PointKt.m7140minusybeJwSQ(sideStart, corner));
        long jM7141plusybeJwSQ = PointKt.m7141plusybeJwSQ(corner, PointKt.m7143timesso9K2fw(PointKt.m7143timesso9K2fw(jM7134getDirectionDnnuFBc, actualRoundCut), 1 + actualSmoothingValues));
        long packedValue = circleSegmentIntersection;
        long jM7139interpolatedLqxh1s = PointKt.m7139interpolatedLqxh1s(packedValue, PointKt.m7131divso9K2fw(PointKt.m7141plusybeJwSQ(circleSegmentIntersection, otherCircleSegmentIntersection), 2.0f), actualSmoothingValues);
        long jM7141plusybeJwSQ2 = PointKt.m7141plusybeJwSQ(circleCenter, PointKt.m7143timesso9K2fw(Utils.directionVector(PointKt.m7137getXDnnuFBc(jM7139interpolatedLqxh1s) - PointKt.m7137getXDnnuFBc(circleCenter), PointKt.m7138getYDnnuFBc(jM7139interpolatedLqxh1s) - PointKt.m7138getYDnnuFBc(circleCenter)), actualR));
        FloatFloatPair floatFloatPairM7148lineIntersectionCBFvKDc = m7148lineIntersectionCBFvKDc(sideStart, jM7134getDirectionDnnuFBc, jM7141plusybeJwSQ2, Utils.m7158rotate90DnnuFBc(PointKt.m7140minusybeJwSQ(jM7141plusybeJwSQ2, circleCenter)));
        if (floatFloatPairM7148lineIntersectionCBFvKDc != null) {
            packedValue = floatFloatPairM7148lineIntersectionCBFvKDc.getPackedValue();
        }
        return new Cubic(jM7141plusybeJwSQ, PointKt.m7131divso9K2fw(PointKt.m7141plusybeJwSQ(jM7141plusybeJwSQ, PointKt.m7143timesso9K2fw(packedValue, 2.0f)), 3.0f), packedValue, jM7141plusybeJwSQ2, null);
    }

    public static /* synthetic */ List getCubics$default(RoundedCorner roundedCorner, float f, float f7, int i, Object obj) {
        if ((i & 2) != 0) {
            f7 = f;
        }
        return roundedCorner.getCubics(f, f7);
    }

    /* renamed from: lineIntersection-CBFvKDc, reason: not valid java name */
    private final FloatFloatPair m7148lineIntersectionCBFvKDc(long p02, long d02, long p1, long d12) {
        long jM7158rotate90DnnuFBc = Utils.m7158rotate90DnnuFBc(d12);
        float fM7133dotProductybeJwSQ = PointKt.m7133dotProductybeJwSQ(d02, jM7158rotate90DnnuFBc);
        if (Math.abs(fM7133dotProductybeJwSQ) < 1.0E-4f) {
            return null;
        }
        float fM7133dotProductybeJwSQ2 = PointKt.m7133dotProductybeJwSQ(PointKt.m7140minusybeJwSQ(p1, p02), jM7158rotate90DnnuFBc);
        if (Math.abs(fM7133dotProductybeJwSQ) < Math.abs(fM7133dotProductybeJwSQ2) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m8boximpl(PointKt.m7141plusybeJwSQ(p02, PointKt.m7143timesso9K2fw(d02, fM7133dotProductybeJwSQ2 / fM7133dotProductybeJwSQ)));
    }

    /* renamed from: getCenter-1ufDz9w, reason: not valid java name and from getter */
    public final long getCenter() {
        return this.center;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCosAngle() {
        return this.cosAngle;
    }

    public final List<Cubic> getCubics(float f) {
        return getCubics$default(this, f, 0.0f, 2, null);
    }

    /* renamed from: getD1-1ufDz9w, reason: not valid java name and from getter */
    public final long getD1() {
        return this.d1;
    }

    /* renamed from: getD2-1ufDz9w, reason: not valid java name and from getter */
    public final long getD2() {
        return this.d2;
    }

    public final float getExpectedCut() {
        return (1 + this.smoothing) * this.expectedRoundCut;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    /* renamed from: getP0-1ufDz9w, reason: not valid java name and from getter */
    public final long getP0() {
        return this.p0;
    }

    /* renamed from: getP1-1ufDz9w, reason: not valid java name and from getter */
    public final long getP1() {
        return this.p1;
    }

    /* renamed from: getP2-1ufDz9w, reason: not valid java name and from getter */
    public final long getP2() {
        return this.p2;
    }

    public final CornerRounding getRounding() {
        return this.rounding;
    }

    public final float getSinAngle() {
        return this.sinAngle;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* renamed from: setCenter-DnnuFBc, reason: not valid java name */
    public final void m7155setCenterDnnuFBc(long j5) {
        this.center = j5;
    }

    private RoundedCorner(long j5, long j6, long j10, CornerRounding cornerRounding) {
        this.p0 = j5;
        this.p1 = j6;
        this.p2 = j10;
        this.rounding = cornerRounding;
        long jM7134getDirectionDnnuFBc = PointKt.m7134getDirectionDnnuFBc(PointKt.m7140minusybeJwSQ(j5, j6));
        this.d1 = jM7134getDirectionDnnuFBc;
        long jM7134getDirectionDnnuFBc2 = PointKt.m7134getDirectionDnnuFBc(PointKt.m7140minusybeJwSQ(j10, j6));
        this.d2 = jM7134getDirectionDnnuFBc2;
        float radius = cornerRounding != null ? cornerRounding.getRadius() : 0.0f;
        this.cornerRadius = radius;
        this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : 0.0f;
        float fM7133dotProductybeJwSQ = PointKt.m7133dotProductybeJwSQ(jM7134getDirectionDnnuFBc, jM7134getDirectionDnnuFBc2);
        this.cosAngle = fM7133dotProductybeJwSQ;
        float f = 1;
        float fSqrt = (float) Math.sqrt(f - Utils.square(fM7133dotProductybeJwSQ));
        this.sinAngle = fSqrt;
        this.expectedRoundCut = ((double) fSqrt) > 0.001d ? ((fM7133dotProductybeJwSQ + f) * radius) / fSqrt : 0.0f;
        this.center = FloatFloatPair.m11constructorimpl(0.0f, 0.0f);
    }

    public final List<Cubic> getCubics(float allowedCut0, float allowedCut1) {
        float fMin = Math.min(allowedCut0, allowedCut1);
        float f = this.expectedRoundCut;
        if (f < 1.0E-4f || fMin < 1.0E-4f || this.cornerRadius < 1.0E-4f) {
            long j5 = this.p1;
            this.center = j5;
            return o.M(Cubic.INSTANCE.straightLine(PointKt.m7137getXDnnuFBc(j5), PointKt.m7138getYDnnuFBc(this.p1), PointKt.m7137getXDnnuFBc(this.p1), PointKt.m7138getYDnnuFBc(this.p1)));
        }
        float fMin2 = Math.min(fMin, f);
        float fCalculateActualSmoothingValue = calculateActualSmoothingValue(allowedCut0);
        float fCalculateActualSmoothingValue2 = calculateActualSmoothingValue(allowedCut1);
        float f7 = (this.cornerRadius * fMin2) / this.expectedRoundCut;
        this.center = PointKt.m7141plusybeJwSQ(this.p1, PointKt.m7143timesso9K2fw(PointKt.m7134getDirectionDnnuFBc(PointKt.m7131divso9K2fw(PointKt.m7141plusybeJwSQ(this.d1, this.d2), 2.0f)), (float) Math.sqrt(Utils.square(fMin2) + Utils.square(f7))));
        long jM7141plusybeJwSQ = PointKt.m7141plusybeJwSQ(this.p1, PointKt.m7143timesso9K2fw(this.d1, fMin2));
        long jM7141plusybeJwSQ2 = PointKt.m7141plusybeJwSQ(this.p1, PointKt.m7143timesso9K2fw(this.d2, fMin2));
        Cubic cubicM7147computeFlankingCurveoAJzIJU = m7147computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue, this.p1, this.p0, jM7141plusybeJwSQ, jM7141plusybeJwSQ2, this.center, f7);
        Cubic cubicReverse = m7147computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue2, this.p1, this.p2, jM7141plusybeJwSQ2, jM7141plusybeJwSQ, this.center, f7).reverse();
        return o.N(cubicM7147computeFlankingCurveoAJzIJU, Cubic.INSTANCE.circularArc(PointKt.m7137getXDnnuFBc(this.center), PointKt.m7138getYDnnuFBc(this.center), cubicM7147computeFlankingCurveoAJzIJU.getAnchor1X(), cubicM7147computeFlankingCurveoAJzIJU.getAnchor1Y(), cubicReverse.getAnchor0X(), cubicReverse.getAnchor0Y()), cubicReverse);
    }

    public /* synthetic */ RoundedCorner(long j5, long j6, long j10, CornerRounding cornerRounding, int i, e eVar) {
        this(j5, j6, j10, (i & 8) != 0 ? null : cornerRounding, null);
    }
}
