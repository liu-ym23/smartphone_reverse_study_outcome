package org.apache.commons.math.estimation;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface EstimationProblem {
    EstimatedParameter[] getAllParameters();

    WeightedMeasurement[] getMeasurements();

    EstimatedParameter[] getUnboundParameters();
}
