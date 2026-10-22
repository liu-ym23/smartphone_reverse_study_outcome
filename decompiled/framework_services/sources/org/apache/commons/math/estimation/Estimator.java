package org.apache.commons.math.estimation;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface Estimator {
    void estimate(EstimationProblem r1) throws EstimationException;

    double[][] getCovariances(EstimationProblem r1) throws EstimationException;

    double getRMS(EstimationProblem r1);

    double[] guessParametersErrors(EstimationProblem r1) throws EstimationException;
}
