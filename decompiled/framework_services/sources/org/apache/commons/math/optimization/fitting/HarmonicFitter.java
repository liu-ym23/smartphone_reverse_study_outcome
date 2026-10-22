package org.apache.commons.math.optimization.fitting;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class HarmonicFitter {
    private final CurveFitter fitter;
    private double[] parameters;

    /* JADX INFO: renamed from: org.apache.commons.math.optimization.fitting.HarmonicFitter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ParametricHarmonicFunction implements ParametricRealFunction {
        private ParametricHarmonicFunction() {
        }

        /* synthetic */ ParametricHarmonicFunction(AnonymousClass1 x0) {
            this();
        }

        @Override // org.apache.commons.math.optimization.fitting.ParametricRealFunction
        public double value(double x, double[] parameters) {
            double a = parameters[0];
            double omega = parameters[1];
            double phi = parameters[2];
            return FastMath.cos((omega * x) + phi) * a;
        }

        @Override // org.apache.commons.math.optimization.fitting.ParametricRealFunction
        public double[] gradient(double x, double[] parameters) {
            double a = parameters[0];
            double omega = parameters[1];
            double phi = parameters[2];
            double alpha = (omega * x) + phi;
            double cosAlpha = FastMath.cos(alpha);
            double sinAlpha = FastMath.sin(alpha);
            return new double[]{cosAlpha, ((-a) * x) * sinAlpha, (-a) * sinAlpha};
        }
    }

    public HarmonicFitter(DifferentiableMultivariateVectorialOptimizer optimizer) {
        this.fitter = new CurveFitter(optimizer);
        this.parameters = null;
    }

    public HarmonicFitter(DifferentiableMultivariateVectorialOptimizer optimizer, double[] initialGuess) {
        this.fitter = new CurveFitter(optimizer);
        this.parameters = (double[]) initialGuess.clone();
    }

    public void addObservedPoint(double weight, double x, double y) {
        this.fitter.addObservedPoint(weight, x, y);
    }

    public HarmonicFunction fit() throws OptimizationException {
        if (this.parameters != null) goto L14;
        WeightedObservedPoint[] observations = this.fitter.getObservations();
        if (observations.length < 4) goto L8;
        HarmonicCoefficientsGuesser guesser = new HarmonicCoefficientsGuesser(observations);
        guesser.guess();
        this.parameters = new double[]{guesser.getGuessedAmplitude(), guesser.getGuessedPulsation(), guesser.getGuessedPhase()};
        goto L14
    L8:
        throw new OptimizationException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, new Object[]{Integer.valueOf(observations.length), 4});
    L14:
        double[] fitted = this.fitter.fit(new ParametricHarmonicFunction(null), this.parameters);     // Catch: FunctionEvaluationException -> L11
        return new HarmonicFunction(fitted[0], fitted[1], fitted[2]);
    L11:
        fee = move-exception;
        throw new RuntimeException(fee);
    }
}
