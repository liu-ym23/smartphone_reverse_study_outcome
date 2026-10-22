package org.apache.commons.math.stat.inference;

import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
public interface ChiSquareTest {
    double chiSquare(double[] r1, long[] r2) throws IllegalArgumentException;

    double chiSquare(long[][] r1) throws IllegalArgumentException;

    double chiSquareTest(double[] r1, long[] r2) throws IllegalArgumentException, MathException;

    double chiSquareTest(long[][] r1) throws IllegalArgumentException, MathException;

    boolean chiSquareTest(double[] r1, long[] r2, double r3) throws IllegalArgumentException, MathException;

    boolean chiSquareTest(long[][] r1, double r2) throws IllegalArgumentException, MathException;
}
