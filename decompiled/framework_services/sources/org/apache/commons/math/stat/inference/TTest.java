package org.apache.commons.math.stat.inference;

import org.apache.commons.math.MathException;
import org.apache.commons.math.stat.descriptive.StatisticalSummary;

/* JADX INFO: loaded from: classes3.dex */
public interface TTest {
    double homoscedasticT(StatisticalSummary r1, StatisticalSummary r2) throws IllegalArgumentException;

    double homoscedasticT(double[] r1, double[] r2) throws IllegalArgumentException;

    double homoscedasticTTest(StatisticalSummary r1, StatisticalSummary r2) throws IllegalArgumentException, MathException;

    double homoscedasticTTest(double[] r1, double[] r2) throws IllegalArgumentException, MathException;

    boolean homoscedasticTTest(double[] r1, double[] r2, double r3) throws IllegalArgumentException, MathException;

    double pairedT(double[] r1, double[] r2) throws IllegalArgumentException, MathException;

    double pairedTTest(double[] r1, double[] r2) throws IllegalArgumentException, MathException;

    boolean pairedTTest(double[] r1, double[] r2, double r3) throws IllegalArgumentException, MathException;

    double t(double r1, StatisticalSummary r3) throws IllegalArgumentException;

    double t(double r1, double[] r3) throws IllegalArgumentException;

    double t(StatisticalSummary r1, StatisticalSummary r2) throws IllegalArgumentException;

    double t(double[] r1, double[] r2) throws IllegalArgumentException;

    double tTest(double r1, StatisticalSummary r3) throws IllegalArgumentException, MathException;

    double tTest(double r1, double[] r3) throws IllegalArgumentException, MathException;

    double tTest(StatisticalSummary r1, StatisticalSummary r2) throws IllegalArgumentException, MathException;

    double tTest(double[] r1, double[] r2) throws IllegalArgumentException, MathException;

    boolean tTest(double r1, StatisticalSummary r3, double r4) throws IllegalArgumentException, MathException;

    boolean tTest(double r1, double[] r3, double r4) throws IllegalArgumentException, MathException;

    boolean tTest(StatisticalSummary r1, StatisticalSummary r2, double r3) throws IllegalArgumentException, MathException;

    boolean tTest(double[] r1, double[] r2, double r3) throws IllegalArgumentException, MathException;
}
