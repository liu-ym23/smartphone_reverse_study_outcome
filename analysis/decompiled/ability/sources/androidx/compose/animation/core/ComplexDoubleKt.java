package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0000\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n¨\u0006\r"}, d2 = {"complexQuadraticFormula", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "a", "", "b", "c", "complexSqrt", "num", "minus", "other", "plus", "times", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComplexDoubleKt {
    public static final Pair<ComplexDouble, ComplexDouble> complexQuadraticFormula(double d, double d6, double d10) {
        double d11 = (d6 * d6) - ((4.0d * d) * d10);
        double d12 = 1.0d / (d * 2.0d);
        double d13 = -d6;
        ComplexDouble complexDoubleComplexSqrt = complexSqrt(d11);
        complexDoubleComplexSqrt._real += d13;
        complexDoubleComplexSqrt._real *= d12;
        complexDoubleComplexSqrt._imaginary *= d12;
        ComplexDouble complexDoubleComplexSqrt2 = complexSqrt(d11);
        double d14 = -1;
        complexDoubleComplexSqrt2._real *= d14;
        complexDoubleComplexSqrt2._imaginary *= d14;
        complexDoubleComplexSqrt2._real += d13;
        complexDoubleComplexSqrt2._real *= d12;
        complexDoubleComplexSqrt2._imaginary *= d12;
        return new Pair<>(complexDoubleComplexSqrt, complexDoubleComplexSqrt2);
    }

    public static final ComplexDouble complexSqrt(double d) {
        return d < 0.0d ? new ComplexDouble(0.0d, Math.sqrt(Math.abs(d))) : new ComplexDouble(Math.sqrt(d), 0.0d);
    }

    public static final ComplexDouble minus(double d, ComplexDouble complexDouble) {
        double d6 = -1;
        complexDouble._real *= d6;
        complexDouble._imaginary *= d6;
        complexDouble._real += d;
        return complexDouble;
    }

    public static final ComplexDouble plus(double d, ComplexDouble complexDouble) {
        complexDouble._real += d;
        return complexDouble;
    }

    public static final ComplexDouble times(double d, ComplexDouble complexDouble) {
        complexDouble._real *= d;
        complexDouble._imaginary *= d;
        return complexDouble;
    }
}
