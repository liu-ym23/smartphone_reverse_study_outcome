package org.apache.commons.math.analysis.polynomials;

import java.util.ArrayList;
import org.apache.commons.math.fraction.BigFraction;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class PolynomialsUtils {
    private static final ArrayList<BigFraction> CHEBYSHEV_COEFFICIENTS = null;
    private static final ArrayList<BigFraction> HERMITE_COEFFICIENTS = null;
    private static final ArrayList<BigFraction> LAGUERRE_COEFFICIENTS = null;
    private static final ArrayList<BigFraction> LEGENDRE_COEFFICIENTS = null;

    private interface RecurrenceCoefficientsGenerator {
        BigFraction[] generate(int r1);
    }

    static {
        CHEBYSHEV_COEFFICIENTS = new ArrayList();
        CHEBYSHEV_COEFFICIENTS.add(BigFraction.ONE);
        CHEBYSHEV_COEFFICIENTS.add(BigFraction.ZERO);
        CHEBYSHEV_COEFFICIENTS.add(BigFraction.ONE);
        HERMITE_COEFFICIENTS = new ArrayList();
        HERMITE_COEFFICIENTS.add(BigFraction.ONE);
        HERMITE_COEFFICIENTS.add(BigFraction.ZERO);
        HERMITE_COEFFICIENTS.add(BigFraction.TWO);
        LAGUERRE_COEFFICIENTS = new ArrayList();
        LAGUERRE_COEFFICIENTS.add(BigFraction.ONE);
        LAGUERRE_COEFFICIENTS.add(BigFraction.ONE);
        LAGUERRE_COEFFICIENTS.add(BigFraction.MINUS_ONE);
        LEGENDRE_COEFFICIENTS = new ArrayList();
        LEGENDRE_COEFFICIENTS.add(BigFraction.ONE);
        LEGENDRE_COEFFICIENTS.add(BigFraction.ZERO);
        LEGENDRE_COEFFICIENTS.add(BigFraction.ONE);
    }

    private PolynomialsUtils() {
    }

    public static PolynomialFunction createChebyshevPolynomial(int degree) {
        return buildPolynomial(degree, CHEBYSHEV_COEFFICIENTS, new AnonymousClass1());
    }

    public static PolynomialFunction createHermitePolynomial(int degree) {
        return buildPolynomial(degree, HERMITE_COEFFICIENTS, new AnonymousClass2());
    }

    public static PolynomialFunction createLaguerrePolynomial(int degree) {
        return buildPolynomial(degree, LAGUERRE_COEFFICIENTS, new AnonymousClass3());
    }

    public static PolynomialFunction createLegendrePolynomial(int degree) {
        return buildPolynomial(degree, LEGENDRE_COEFFICIENTS, new AnonymousClass4());
    }

    private static PolynomialFunction buildPolynomial(int degree, ArrayList<BigFraction> coefficients, RecurrenceCoefficientsGenerator generator) {
        int maxDegree = ((int) FastMath.floor(FastMath.sqrt(coefficients.size() * 2))) - 1;
        monitor-enter(PolynomialsUtils.class);
        if (degree > maxDegree) goto L16;
    L8:
        monitor-exit(PolynomialsUtils.class);     // Catch: Throwable -> L6
        int start = ((degree + 1) * degree) / 2;
        double[] a = new double[degree + 1];
        int i = 0;
    L10:
        if (i > degree) goto L13;
        a[i] = coefficients.get(start + i).doubleValue();
        i = i + 1;
        goto L10
    L13:
        return new PolynomialFunction(a);
    L6:
        th = move-exception;
        throw th;
    L16:
        computeUpToDegree(degree, maxDegree, generator, coefficients);     // Catch: Throwable -> L6
        goto L8
    }

    private static void computeUpToDegree(int degree, int maxDegree, RecurrenceCoefficientsGenerator generator, ArrayList<BigFraction> coefficients) {
        int startK = ((maxDegree - 1) * maxDegree) / 2;
        int k = maxDegree;
    L3:
        if (k >= degree) goto L10;
        int startKm1 = startK;
        startK = startK + k;
        BigFraction[] ai = generator.generate(k);
        BigFraction ck = coefficients.get(startK);
        BigFraction ckm1 = coefficients.get(startKm1);
        coefficients.add(ck.multiply2(ai[0]).subtract2(ckm1.multiply2(ai[2])));
        int i = 1;
    L6:
        if (i >= k) goto L8;
        BigFraction ckPrev = ck;
        ck = coefficients.get(startK + i);
        BigFraction ckm2 = coefficients.get(startKm1 + i);
        coefficients.add(ck.multiply2(ai[0]).add2(ckPrev.multiply2(ai[1])).subtract2(ckm2.multiply2(ai[2])));
        i = i + 1;
        goto L6
    L8:
        BigFraction ckPrev2 = ck;
        BigFraction ck2 = coefficients.get(startK + k);
        coefficients.add(ck2.multiply2(ai[0]).add2(ckPrev2.multiply2(ai[1])));
        coefficients.add(ck2.multiply2(ai[1]));
        k = k + 1;
        goto L3
    }
}
