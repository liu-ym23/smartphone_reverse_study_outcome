package org.apache.commons.math;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface ConvergingAlgorithm {
    double getAbsoluteAccuracy();

    int getIterationCount();

    int getMaximalIterationCount();

    double getRelativeAccuracy();

    void resetAbsoluteAccuracy();

    void resetMaximalIterationCount();

    void resetRelativeAccuracy();

    void setAbsoluteAccuracy(double r1);

    void setMaximalIterationCount(int r1);

    void setRelativeAccuracy(double r1);
}
