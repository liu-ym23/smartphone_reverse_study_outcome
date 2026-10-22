package org.apache.commons.math.stat.inference;

import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
public interface UnknownDistributionChiSquareTest extends ChiSquareTest {
    double chiSquareDataSetsComparison(long[] r1, long[] r2) throws IllegalArgumentException;

    double chiSquareTestDataSetsComparison(long[] r1, long[] r2) throws IllegalArgumentException, MathException;

    boolean chiSquareTestDataSetsComparison(long[] r1, long[] r2, double r3) throws IllegalArgumentException, MathException;
}
