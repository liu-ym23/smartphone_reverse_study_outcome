package org.apache.commons.math.optimization.fitting;

import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class HarmonicCoefficientsGuesser {
    private double a;
    private final WeightedObservedPoint[] observations;
    private double omega;
    private double phi;

    public HarmonicCoefficientsGuesser(WeightedObservedPoint[] observations) {
        this.observations = (WeightedObservedPoint[]) observations.clone();
        this.a = Double.NaN;
        this.omega = Double.NaN;
    }

    public void guess() throws OptimizationException {
        sortObservations();
        guessAOmega();
        guessPhi();
    }

    private void sortObservations() {
        WeightedObservedPoint curr = this.observations[0];
        int j = 1;
    L4:
        if (j >= this.observations.length) goto L18;
        WeightedObservedPoint prec = curr;
        curr = this.observations[j];
        if (curr.getX() >= prec.getX()) goto L16;
        int i = j - 1;
        WeightedObservedPoint mI = this.observations[i];
    L8:
        if (i < 0) goto L15;
        if (curr.getX() >= mI.getX()) goto L15;
        this.observations[i + 1] = mI;
        i = i - 1;
        if (i == 0) goto L8;
        mI = this.observations[i];
    L15:
        this.observations[i + 1] = curr;
        curr = this.observations[j];
    L16:
        j = j + 1;
        goto L4
    }

    private void guessAOmega() throws OptimizationException {
        double sx2 = 0.0d;
        double sy2 = 0.0d;
        double sxy = 0.0d;
        double sxz = 0.0d;
        double syz = 0.0d;
        double currentX = this.observations[0].getX();
        double currentY = this.observations[0].getY();
        double f2Integral = 0.0d;
        double fPrime2Integral = 0.0d;
        int i = 1;
    L4:
        if (i >= this.observations.length) goto L6;
        double previousX = currentX;
        double previousY = currentY;
        currentX = this.observations[i].getX();
        currentY = this.observations[i].getY();
        double dx = currentX - previousX;
        double dy = currentY - previousY;
        double f2StepIntegral = ((((previousY * previousY) + (previousY * currentY)) + (currentY * currentY)) * dx) / 3.0d;
        double fPrime2StepIntegral = (dy * dy) / dx;
        double x = currentX - currentX;
        f2Integral = f2Integral + f2StepIntegral;
        fPrime2Integral = fPrime2Integral + fPrime2StepIntegral;
        sx2 = sx2 + (x * x);
        sy2 = sy2 + (f2Integral * f2Integral);
        sxy = sxy + (x * f2Integral);
        sxz = sxz + (x * fPrime2Integral);
        syz = syz + (f2Integral * fPrime2Integral);
        i = i + 1;
        goto L4
    L6:
        double c1 = (sy2 * sxz) - (sxy * syz);
        double c2 = (sxy * sxz) - (sx2 * syz);
        double c3 = (sx2 * sy2) - (sxy * sxy);
        if ((c1 / c2) < 0.0d) goto L13;
        if ((c2 / c3) < 0.0d) goto L13;
        double sx3 = FastMath.sqrt(c1 / c2);
        this.a = sx3;
        this.omega = FastMath.sqrt(c2 / c3);
        return;
    L13:
        throw new OptimizationException(LocalizedFormats.UNABLE_TO_FIRST_GUESS_HARMONIC_COEFFICIENTS, new Object[0]);
    }

    private void guessPhi() {
        double fcMean = 0.0d;
        double fsMean = 0.0d;
        double currentX = this.observations[0].getX();
        double currentY = this.observations[0].getY();
        int i = 1;
    L4:
        if (i >= this.observations.length) goto L6;
        double previousX = currentX;
        double previousY = currentY;
        currentX = this.observations[i].getX();
        double currentY2 = this.observations[i].getY();
        double currentYPrime = (currentY2 - previousY) / (currentX - previousX);
        double currentY3 = this.omega;
        double omegaX = currentY3 * currentX;
        double cosine = FastMath.cos(omegaX);
        double sine = FastMath.sin(omegaX);
        fcMean = fcMean + (((this.omega * currentY2) * cosine) - (currentYPrime * sine));
        fsMean = fsMean + (((this.omega * currentY2) * sine) + (currentYPrime * cosine));
        i = i + 1;
        currentY = currentY2;
        goto L4
    L6:
        this.phi = FastMath.atan2(-fsMean, fcMean);
    }

    public double getGuessedAmplitude() {
        return this.a;
    }

    public double getGuessedPulsation() {
        return this.omega;
    }

    public double getGuessedPhase() {
        return this.phi;
    }
}
