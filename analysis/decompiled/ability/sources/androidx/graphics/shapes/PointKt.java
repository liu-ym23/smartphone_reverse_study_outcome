package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a6\u0010\b\u001a\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\n\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a&\u0010\u000e\u001a\u00020\u000f*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a2\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0016\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u001a\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a*\u0010\u001a\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010!\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001a\u0010$\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0005\u001a\u001a\u0010&\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b'\u0010\u0005\u001a+\u0010(\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a+\u0010+\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010*\u001a'\u0010-\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010\u0019\u001a'\u0010/\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0019\u001a&\u00101\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u00102\u001a\u000203H\u0000ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a\u001f\u00106\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b7\u0010#\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005*\f\b\u0000\u00108\"\u00020\u00022\u00020\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"x", "", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "getX-DnnuFBc", "(J)F", "y", "getY-DnnuFBc", "interpolate", "start", "stop", "fraction", "interpolate-dLqxh1s", "(JJF)J", "clockwise", "", "other", "clockwise-ybeJwSQ", "(JJ)Z", "copy", "copy-5P9i7ZU", "(JFF)J", "div", "operand", "div-so9K2fw", "(JF)J", "dotProduct", "dotProduct-ybeJwSQ", "(JJ)F", "otherX", "otherY", "dotProduct-5P9i7ZU", "(JFF)F", "getDirection", "getDirection-DnnuFBc", "(J)J", "getDistance", "getDistance-DnnuFBc", "getDistanceSquared", "getDistanceSquared-DnnuFBc", "minus", "minus-ybeJwSQ", "(JJ)J", "plus", "plus-ybeJwSQ", "rem", "rem-so9K2fw", "times", "times-so9K2fw", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "transformed-so9K2fw", "(JLandroidx/graphics/shapes/PointTransformer;)J", "unaryMinus", "unaryMinus-DnnuFBc", "Point", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PointKt {
    /* renamed from: clockwise-ybeJwSQ, reason: not valid java name */
    public static final boolean m7128clockwiseybeJwSQ(long j5, long j6) {
        return (m7138getYDnnuFBc(j6) * m7137getXDnnuFBc(j5)) - (m7137getXDnnuFBc(j6) * m7138getYDnnuFBc(j5)) > 0.0f;
    }

    /* renamed from: copy-5P9i7ZU, reason: not valid java name */
    public static final long m7129copy5P9i7ZU(long j5, float f, float f7) {
        return FloatFloatPair.m11constructorimpl(f, f7);
    }

    /* renamed from: copy-5P9i7ZU$default, reason: not valid java name */
    public static /* synthetic */ long m7130copy5P9i7ZU$default(long j5, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j5 >> 32));
        }
        if ((i & 2) != 0) {
            f7 = Float.intBitsToFloat((int) (4294967295L & j5));
        }
        return m7129copy5P9i7ZU(j5, f, f7);
    }

    /* renamed from: div-so9K2fw, reason: not valid java name */
    public static final long m7131divso9K2fw(long j5, float f) {
        return FloatFloatPair.m11constructorimpl(m7137getXDnnuFBc(j5) / f, m7138getYDnnuFBc(j5) / f);
    }

    /* renamed from: dotProduct-5P9i7ZU, reason: not valid java name */
    public static final float m7132dotProduct5P9i7ZU(long j5, float f, float f7) {
        return (m7138getYDnnuFBc(j5) * f7) + (m7137getXDnnuFBc(j5) * f);
    }

    /* renamed from: dotProduct-ybeJwSQ, reason: not valid java name */
    public static final float m7133dotProductybeJwSQ(long j5, long j6) {
        return (m7138getYDnnuFBc(j6) * m7138getYDnnuFBc(j5)) + (m7137getXDnnuFBc(j6) * m7137getXDnnuFBc(j5));
    }

    /* renamed from: getDirection-DnnuFBc, reason: not valid java name */
    public static final long m7134getDirectionDnnuFBc(long j5) {
        float fM7135getDistanceDnnuFBc = m7135getDistanceDnnuFBc(j5);
        if (fM7135getDistanceDnnuFBc > 0.0f) {
            return m7131divso9K2fw(j5, fM7135getDistanceDnnuFBc);
        }
        throw new IllegalArgumentException("Can't get the direction of a 0-length vector");
    }

    /* renamed from: getDistance-DnnuFBc, reason: not valid java name */
    public static final float m7135getDistanceDnnuFBc(long j5) {
        return (float) Math.sqrt((m7138getYDnnuFBc(j5) * m7138getYDnnuFBc(j5)) + (m7137getXDnnuFBc(j5) * m7137getXDnnuFBc(j5)));
    }

    /* renamed from: getDistanceSquared-DnnuFBc, reason: not valid java name */
    public static final float m7136getDistanceSquaredDnnuFBc(long j5) {
        return (m7138getYDnnuFBc(j5) * m7138getYDnnuFBc(j5)) + (m7137getXDnnuFBc(j5) * m7137getXDnnuFBc(j5));
    }

    /* renamed from: getX-DnnuFBc, reason: not valid java name */
    public static final float m7137getXDnnuFBc(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: getY-DnnuFBc, reason: not valid java name */
    public static final float m7138getYDnnuFBc(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: interpolate-dLqxh1s, reason: not valid java name */
    public static final long m7139interpolatedLqxh1s(long j5, long j6, float f) {
        return FloatFloatPair.m11constructorimpl(Utils.interpolate(m7137getXDnnuFBc(j5), m7137getXDnnuFBc(j6), f), Utils.interpolate(m7138getYDnnuFBc(j5), m7138getYDnnuFBc(j6), f));
    }

    /* renamed from: minus-ybeJwSQ, reason: not valid java name */
    public static final long m7140minusybeJwSQ(long j5, long j6) {
        return FloatFloatPair.m11constructorimpl(m7137getXDnnuFBc(j5) - m7137getXDnnuFBc(j6), m7138getYDnnuFBc(j5) - m7138getYDnnuFBc(j6));
    }

    /* renamed from: plus-ybeJwSQ, reason: not valid java name */
    public static final long m7141plusybeJwSQ(long j5, long j6) {
        return FloatFloatPair.m11constructorimpl(m7137getXDnnuFBc(j6) + m7137getXDnnuFBc(j5), m7138getYDnnuFBc(j6) + m7138getYDnnuFBc(j5));
    }

    /* renamed from: rem-so9K2fw, reason: not valid java name */
    public static final long m7142remso9K2fw(long j5, float f) {
        return FloatFloatPair.m11constructorimpl(m7137getXDnnuFBc(j5) % f, m7138getYDnnuFBc(j5) % f);
    }

    /* renamed from: times-so9K2fw, reason: not valid java name */
    public static final long m7143timesso9K2fw(long j5, float f) {
        return FloatFloatPair.m11constructorimpl(m7137getXDnnuFBc(j5) * f, m7138getYDnnuFBc(j5) * f);
    }

    /* renamed from: transformed-so9K2fw, reason: not valid java name */
    public static final long m7144transformedso9K2fw(long j5, PointTransformer f) {
        k.f(f, "f");
        long jMo7146transformXgqJiTY = f.mo7146transformXgqJiTY(m7137getXDnnuFBc(j5), m7138getYDnnuFBc(j5));
        return FloatFloatPair.m11constructorimpl(Float.intBitsToFloat((int) (jMo7146transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (jMo7146transformXgqJiTY & 4294967295L)));
    }

    /* renamed from: unaryMinus-DnnuFBc, reason: not valid java name */
    public static final long m7145unaryMinusDnnuFBc(long j5) {
        return FloatFloatPair.m11constructorimpl(-m7137getXDnnuFBc(j5), -m7138getYDnnuFBc(j5));
    }
}
