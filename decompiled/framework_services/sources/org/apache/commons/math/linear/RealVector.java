package org.apache.commons.math.linear;

import java.util.Iterator;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.UnivariateRealFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface RealVector {

    public static abstract class Entry {
        private int index;

        public abstract double getValue();

        public abstract void setValue(double r1);

        public Entry() {
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    RealVector add(RealVector r1);

    RealVector add(double[] r1);

    RealVector append(double r1);

    RealVector append(RealVector r1);

    RealVector append(double[] r1);

    RealVector copy();

    double dotProduct(RealVector r1);

    double dotProduct(double[] r1);

    RealVector ebeDivide(RealVector r1);

    RealVector ebeDivide(double[] r1);

    RealVector ebeMultiply(RealVector r1);

    RealVector ebeMultiply(double[] r1);

    double[] getData();

    int getDimension();

    double getDistance(RealVector r1);

    double getDistance(double[] r1);

    double getEntry(int r1);

    double getL1Distance(RealVector r1);

    double getL1Distance(double[] r1);

    double getL1Norm();

    double getLInfDistance(RealVector r1);

    double getLInfDistance(double[] r1);

    double getLInfNorm();

    double getNorm();

    RealVector getSubVector(int r1, int r2);

    boolean isInfinite();

    boolean isNaN();

    Iterator<Entry> iterator();

    RealVector map(UnivariateRealFunction r1) throws FunctionEvaluationException;

    @Deprecated
    RealVector mapAbs();

    @Deprecated
    RealVector mapAbsToSelf();

    @Deprecated
    RealVector mapAcos();

    @Deprecated
    RealVector mapAcosToSelf();

    RealVector mapAdd(double r1);

    RealVector mapAddToSelf(double r1);

    @Deprecated
    RealVector mapAsin();

    @Deprecated
    RealVector mapAsinToSelf();

    @Deprecated
    RealVector mapAtan();

    @Deprecated
    RealVector mapAtanToSelf();

    @Deprecated
    RealVector mapCbrt();

    @Deprecated
    RealVector mapCbrtToSelf();

    @Deprecated
    RealVector mapCeil();

    @Deprecated
    RealVector mapCeilToSelf();

    @Deprecated
    RealVector mapCos();

    @Deprecated
    RealVector mapCosToSelf();

    @Deprecated
    RealVector mapCosh();

    @Deprecated
    RealVector mapCoshToSelf();

    RealVector mapDivide(double r1);

    RealVector mapDivideToSelf(double r1);

    @Deprecated
    RealVector mapExp();

    @Deprecated
    RealVector mapExpToSelf();

    @Deprecated
    RealVector mapExpm1();

    @Deprecated
    RealVector mapExpm1ToSelf();

    @Deprecated
    RealVector mapFloor();

    @Deprecated
    RealVector mapFloorToSelf();

    @Deprecated
    RealVector mapInv();

    @Deprecated
    RealVector mapInvToSelf();

    @Deprecated
    RealVector mapLog();

    @Deprecated
    RealVector mapLog10();

    @Deprecated
    RealVector mapLog10ToSelf();

    @Deprecated
    RealVector mapLog1p();

    @Deprecated
    RealVector mapLog1pToSelf();

    @Deprecated
    RealVector mapLogToSelf();

    RealVector mapMultiply(double r1);

    RealVector mapMultiplyToSelf(double r1);

    @Deprecated
    RealVector mapPow(double r1);

    @Deprecated
    RealVector mapPowToSelf(double r1);

    @Deprecated
    RealVector mapRint();

    @Deprecated
    RealVector mapRintToSelf();

    @Deprecated
    RealVector mapSignum();

    @Deprecated
    RealVector mapSignumToSelf();

    @Deprecated
    RealVector mapSin();

    @Deprecated
    RealVector mapSinToSelf();

    @Deprecated
    RealVector mapSinh();

    @Deprecated
    RealVector mapSinhToSelf();

    @Deprecated
    RealVector mapSqrt();

    @Deprecated
    RealVector mapSqrtToSelf();

    RealVector mapSubtract(double r1);

    RealVector mapSubtractToSelf(double r1);

    @Deprecated
    RealVector mapTan();

    @Deprecated
    RealVector mapTanToSelf();

    @Deprecated
    RealVector mapTanh();

    @Deprecated
    RealVector mapTanhToSelf();

    RealVector mapToSelf(UnivariateRealFunction r1) throws FunctionEvaluationException;

    @Deprecated
    RealVector mapUlp();

    @Deprecated
    RealVector mapUlpToSelf();

    RealMatrix outerProduct(RealVector r1);

    RealMatrix outerProduct(double[] r1);

    RealVector projection(RealVector r1);

    RealVector projection(double[] r1);

    void set(double r1);

    void setEntry(int r1, double r2);

    void setSubVector(int r1, RealVector r2);

    void setSubVector(int r1, double[] r2);

    Iterator<Entry> sparseIterator();

    RealVector subtract(RealVector r1);

    RealVector subtract(double[] r1);

    double[] toArray();

    RealVector unitVector();

    void unitize();
}
