package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a#\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\u0004\u001a4\u0010\u0011\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0014\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001e\u0010\u0004\u001a1\u0010$\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"H\u0000¢\u0006\u0004\b$\u0010%\u001a)\u0010+\u001a\u00020*2\u0006\u0010'\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020&0(H\u0080\bø\u0001\u0001¢\u0006\u0004\b+\u0010,\"\u0014\u0010-\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b/\u0010.\"\u001e\u00100\u001a\u00060\u0006j\u0002`\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u001a\u00104\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b4\u0010.\u001a\u0004\b5\u00106\"\u001a\u00107\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b8\u00106\"\u0014\u0010:\u001a\u0002098\u0000X\u0080T¢\u0006\u0006\n\u0004\b:\u0010;\u0082\u0002\u000e\n\u0005\b¡\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006<"}, d2 = {"", "x", "y", "distance", "(FF)F", "distanceSquared", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "directionVector", "(FF)J", "angleRadians", "(F)J", "angle", "radius", "center", "radialToCartesian-L6JJ3z0", "(FFJ)J", "radialToCartesian", "rotate90-DnnuFBc", "(J)J", "rotate90", "square", "(F)F", "start", "stop", "fraction", "interpolate", "(FFF)F", "num", "mod", "positiveModulo", "v0", "v1", "tolerance", "Landroidx/graphics/shapes/FindMinimumFunction;", "f", "findMinimum", "(FFFLandroidx/graphics/shapes/FindMinimumFunction;)F", "", "tag", "Lkotlin/Function0;", "messageFactory", "LC7/r;", "debugLog", "(Ljava/lang/String;LS7/a;)V", "DistanceEpsilon", "F", "AngleEpsilon", "Zero", "J", "getZero", "()J", "FloatPi", "getFloatPi", "()F", "TwoPi", "getTwoPi", "", "DEBUG", "Z", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Utils {
    public static final float AngleEpsilon = 1.0E-6f;
    public static final boolean DEBUG = false;
    public static final float DistanceEpsilon = 1.0E-4f;
    private static final long Zero = FloatFloatPair.m11constructorimpl(0.0f, 0.0f);
    private static final float FloatPi = 3.1415927f;
    private static final float TwoPi = 6.2831855f;

    public static final float angle(float f, float f7) {
        float fAtan2 = (float) Math.atan2(f7, f);
        float f9 = TwoPi;
        return (fAtan2 + f9) % f9;
    }

    public static final void debugLog(String tag, S7.a messageFactory) {
        k.f(tag, "tag");
        k.f(messageFactory, "messageFactory");
    }

    public static final long directionVector(float f, float f7) {
        float fDistance = distance(f, f7);
        if (fDistance > 0.0f) {
            return FloatFloatPair.m11constructorimpl(f / fDistance, f7 / fDistance);
        }
        throw new IllegalArgumentException("Required distance greater than zero");
    }

    public static final float distance(float f, float f7) {
        return (float) Math.sqrt((f7 * f7) + (f * f));
    }

    public static final float distanceSquared(float f, float f7) {
        return (f7 * f7) + (f * f);
    }

    public static final float findMinimum(float f, float f7, float f9, FindMinimumFunction f10) {
        k.f(f10, "f");
        while (f7 - f > f9) {
            float f11 = 2;
            float f12 = 3;
            float f13 = ((f11 * f) + f7) / f12;
            float f14 = ((f11 * f7) + f) / f12;
            if (f10.invoke(f13) < f10.invoke(f14)) {
                f7 = f14;
            } else {
                f = f13;
            }
        }
        return (f + f7) / 2;
    }

    public static /* synthetic */ float findMinimum$default(float f, float f7, float f9, FindMinimumFunction findMinimumFunction, int i, Object obj) {
        if ((i & 4) != 0) {
            f9 = 0.001f;
        }
        return findMinimum(f, f7, f9, findMinimumFunction);
    }

    public static final float getFloatPi() {
        return FloatPi;
    }

    public static final float getTwoPi() {
        return TwoPi;
    }

    public static final long getZero() {
        return Zero;
    }

    public static final float interpolate(float f, float f7, float f9) {
        return (f9 * f7) + ((1 - f9) * f);
    }

    public static final float positiveModulo(float f, float f7) {
        return ((f % f7) + f7) % f7;
    }

    /* renamed from: radialToCartesian-L6JJ3z0, reason: not valid java name */
    public static final long m7156radialToCartesianL6JJ3z0(float f, float f7, long j5) {
        return PointKt.m7141plusybeJwSQ(PointKt.m7143timesso9K2fw(directionVector(f7), f), j5);
    }

    /* renamed from: radialToCartesian-L6JJ3z0$default, reason: not valid java name */
    public static /* synthetic */ long m7157radialToCartesianL6JJ3z0$default(float f, float f7, long j5, int i, Object obj) {
        if ((i & 4) != 0) {
            j5 = Zero;
        }
        return m7156radialToCartesianL6JJ3z0(f, f7, j5);
    }

    /* renamed from: rotate90-DnnuFBc, reason: not valid java name */
    public static final long m7158rotate90DnnuFBc(long j5) {
        return FloatFloatPair.m11constructorimpl(-PointKt.m7138getYDnnuFBc(j5), PointKt.m7137getXDnnuFBc(j5));
    }

    public static final float square(float f) {
        return f * f;
    }

    public static final long directionVector(float f) {
        double d = f;
        return FloatFloatPair.m11constructorimpl((float) Math.cos(d), (float) Math.sin(d));
    }
}
