package org.apache.commons.math.linear;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.BinaryFunction;
import org.apache.commons.math.analysis.ComposableFunction;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.MathUnsupportedOperationException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRealVector implements RealVector {

    protected class EntryImpl extends RealVector.Entry {
        final /* synthetic */ AbstractRealVector this$0;

        public EntryImpl(AbstractRealVector this$0) {
            this.this$0 = this$0;
            setIndex(0);
        }

        @Override // org.apache.commons.math.linear.RealVector.Entry
        public double getValue() {
            return this.this$0.getEntry(getIndex());
        }

        @Override // org.apache.commons.math.linear.RealVector.Entry
        public void setValue(double newValue) {
            this.this$0.setEntry(getIndex(), newValue);
        }
    }

    protected class SparseEntryIterator implements Iterator<RealVector.Entry> {
        private EntryImpl current;
        private final int dim;
        private EntryImpl next;
        final /* synthetic */ AbstractRealVector this$0;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ RealVector.Entry next() {
            return next2();
        }

        protected SparseEntryIterator(AbstractRealVector this$0) {
            this.this$0 = this$0;
            this.dim = this$0.getDimension();
            this.current = new EntryImpl(this$0);
            this.next = new EntryImpl(this$0);
            if (this.next.getValue() != 0.0d) goto L6;
            advance(this.next);
            return;
        }

        protected void advance(EntryImpl e) {
            if (e != null) goto L4;
            return;
        L4:
            e.setIndex(e.getIndex() + 1);
            if (e.getIndex() >= this.dim) goto L9;
            if (e.getValue() == 0.0d) goto L4;
        L9:
            if (e.getIndex() < this.dim) goto L15;
            e.setIndex(-1);
            return;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next.getIndex() < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public RealVector.Entry next2() {
            int index = this.next.getIndex();
            if (index < 0) goto L7;
            this.current.setIndex(index);
            advance(this.next);
            return this.current;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new MathUnsupportedOperationException(new Object[0]);
        }
    }

    @Override // org.apache.commons.math.linear.RealVector
    public abstract AbstractRealVector copy();

    public AbstractRealVector() {
    }

    @Override // org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector copy() {
        return copy();
    }

    protected void checkVectorDimensions(RealVector v) {
        checkVectorDimensions(v.getDimension());
    }

    protected void checkVectorDimensions(int n) throws DimensionMismatchException {
        int d = getDimension();
        if (d != n) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(d, n);
    }

    protected void checkIndex(int index) throws MatrixIndexException {
        if (index < 0) goto L7;
        if (index >= getDimension()) goto L7;
        return;
    L7:
        throw new MatrixIndexException(LocalizedFormats.INDEX_OUT_OF_RANGE, new Object[]{Integer.valueOf(index), 0, Integer.valueOf(getDimension() - 1)});
    }

    @Override // org.apache.commons.math.linear.RealVector
    public void setSubVector(int index, RealVector v) throws MatrixIndexException {
        checkIndex(index);
        checkIndex((v.getDimension() + index) - 1);
        setSubVector(index, v.getData());
    }

    @Override // org.apache.commons.math.linear.RealVector
    public void setSubVector(int index, double[] v) throws MatrixIndexException {
        checkIndex(index);
        checkIndex((v.length + index) - 1);
        int i = 0;
    L4:
        if (i >= v.length) goto L7;
        setEntry(i + index, v[i]);
        i = i + 1;
        goto L4
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector add(double[] v) throws IllegalArgumentException {
        double[] result = (double[]) v.clone();
        Iterator<RealVector.Entry> it = sparseIterator();
    L4:
        if (it.hasNext() == false) goto L9;
        RealVector.Entry e = it.next();
        if (e == null) goto L9;
        int r2 = e.getIndex();
        result[r2] = result[r2] + e.getValue();
    L9:
        return new ArrayRealVector(result, false);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector add(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == false) goto L6;
        double[] values = ((ArrayRealVector) v).getDataRef();
        return add(values);
    L6:
        RealVector result = v.copy();
        Iterator<RealVector.Entry> it = sparseIterator();
    L8:
        if (it.hasNext() == false) goto L12;
        RealVector.Entry e = it.next();
        if (e == null) goto L12;
        int index = e.getIndex();
        result.setEntry(index, e.getValue() + result.getEntry(index));
    L12:
        return result;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector subtract(double[] v) throws IllegalArgumentException {
        double[] result = (double[]) v.clone();
        Iterator<RealVector.Entry> it = sparseIterator();
    L4:
        if (it.hasNext() == false) goto L9;
        RealVector.Entry e = it.next();
        if (e == null) goto L9;
        int index = e.getIndex();
        result[index] = e.getValue() - result[index];
    L9:
        return new ArrayRealVector(result, false);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector subtract(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == false) goto L6;
        double[] values = ((ArrayRealVector) v).getDataRef();
        return add(values);
    L6:
        RealVector result = v.copy();
        Iterator<RealVector.Entry> it = sparseIterator();
    L8:
        if (it.hasNext() == false) goto L12;
        RealVector.Entry e = it.next();
        if (e == null) goto L12;
        int index = e.getIndex();
        v.setEntry(index, e.getValue() - result.getEntry(index));
    L12:
        return result;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapAdd(double d) {
        return copy().mapAddToSelf(d);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapAddToSelf(double d) {
        if (d != 0.0d) goto L10;
        return this;
    L10:
        return mapToSelf(BinaryFunction.ADD.fix1stArgument(d));
    L6:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double dotProduct(double[] v) throws IllegalArgumentException {
        return dotProduct(new ArrayRealVector(v, false));
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double dotProduct(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v);
        double d = 0.0d;
        Iterator<RealVector.Entry> it = sparseIterator();
    L4:
        if (it.hasNext() == false) goto L8;
        RealVector.Entry e = it.next();
        if (e == null) goto L8;
        d = d + (e.getValue() * v.getEntry(e.getIndex()));
    L8:
        return d;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector ebeDivide(double[] v) throws IllegalArgumentException {
        return ebeDivide(new ArrayRealVector(v, false));
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector ebeMultiply(double[] v) throws IllegalArgumentException {
        return ebeMultiply(new ArrayRealVector(v, false));
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getDistance(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v);
        double d = 0.0d;
        Iterator<RealVector.Entry> it = iterator();
    L4:
        if (it.hasNext() == false) goto L9;
        RealVector.Entry e = it.next();
        if (e == null) goto L9;
        double diff = e.getValue() - v.getEntry(e.getIndex());
        d = d + (diff * diff);
    L9:
        return FastMath.sqrt(d);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getNorm() {
        double sum = 0.0d;
        Iterator<RealVector.Entry> it = sparseIterator();
    L4:
        if (it.hasNext() == false) goto L9;
        RealVector.Entry e = it.next();
        if (e == null) goto L9;
        double value = e.getValue();
        sum = sum + (value * value);
    L9:
        return FastMath.sqrt(sum);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getL1Norm() {
        double norm = 0.0d;
        Iterator<RealVector.Entry> it = sparseIterator();
    L4:
        if (it.hasNext() == false) goto L8;
        RealVector.Entry e = it.next();
        if (e == null) goto L8;
        norm = norm + FastMath.abs(e.getValue());
    L8:
        return norm;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getLInfNorm() {
        double norm = 0.0d;
        Iterator<RealVector.Entry> it = sparseIterator();
    L4:
        if (it.hasNext() == false) goto L8;
        RealVector.Entry e = it.next();
        if (e == null) goto L8;
        norm = FastMath.max(norm, FastMath.abs(e.getValue()));
    L8:
        return norm;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getDistance(double[] v) throws IllegalArgumentException {
        return getDistance(new ArrayRealVector(v, false));
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getL1Distance(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v);
        double d = 0.0d;
        Iterator<RealVector.Entry> it = iterator();
    L4:
        if (it.hasNext() == false) goto L8;
        RealVector.Entry e = it.next();
        if (e == null) goto L8;
        d = d + FastMath.abs(e.getValue() - v.getEntry(e.getIndex()));
    L8:
        return d;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getL1Distance(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double d = 0.0d;
        Iterator<RealVector.Entry> it = iterator();
    L4:
        if (it.hasNext() == false) goto L8;
        RealVector.Entry e = it.next();
        if (e == null) goto L8;
        d = d + FastMath.abs(e.getValue() - v[e.getIndex()]);
    L8:
        return d;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getLInfDistance(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v);
        double d = 0.0d;
        Iterator<RealVector.Entry> it = iterator();
    L4:
        if (it.hasNext() == false) goto L8;
        RealVector.Entry e = it.next();
        if (e == null) goto L8;
        d = FastMath.max(FastMath.abs(e.getValue() - v.getEntry(e.getIndex())), d);
    L8:
        return d;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getLInfDistance(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double d = 0.0d;
        Iterator<RealVector.Entry> it = iterator();
    L4:
        if (it.hasNext() == false) goto L8;
        RealVector.Entry e = it.next();
        if (e == null) goto L8;
        d = FastMath.max(FastMath.abs(e.getValue() - v[e.getIndex()]), d);
    L8:
        return d;
    }

    public int getMinIndex() {
        int minIndex = -1;
        double minValue = Double.POSITIVE_INFINITY;
        Iterator<RealVector.Entry> iterator = iterator();
    L4:
        if (iterator.hasNext() == false) goto L9;
        RealVector.Entry entry = iterator.next();
        if (entry.getValue() > minValue) goto L4;
        minIndex = entry.getIndex();
        minValue = entry.getValue();
        goto L4
    L9:
        return minIndex;
    }

    public double getMinValue() {
        int minIndex = getMinIndex();
        if (minIndex >= 0) goto L6;
        return Double.NaN;
    L6:
        return getEntry(minIndex);
    }

    public int getMaxIndex() {
        int maxIndex = -1;
        double maxValue = Double.NEGATIVE_INFINITY;
        Iterator<RealVector.Entry> iterator = iterator();
    L4:
        if (iterator.hasNext() == false) goto L9;
        RealVector.Entry entry = iterator.next();
        if (entry.getValue() < maxValue) goto L4;
        maxIndex = entry.getIndex();
        maxValue = entry.getValue();
        goto L4
    L9:
        return maxIndex;
    }

    public double getMaxValue() {
        int maxIndex = getMaxIndex();
        if (maxIndex >= 0) goto L6;
        return Double.NaN;
    L6:
        return getEntry(maxIndex);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapAbs() {
        return copy().mapAbsToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapAbsToSelf() {
        return mapToSelf(ComposableFunction.ABS);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapAcos() {
        return copy().mapAcosToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapAcosToSelf() {
        return mapToSelf(ComposableFunction.ACOS);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapAsin() {
        return copy().mapAsinToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapAsinToSelf() {
        return mapToSelf(ComposableFunction.ASIN);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapAtan() {
        return copy().mapAtanToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapAtanToSelf() {
        return mapToSelf(ComposableFunction.ATAN);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapCbrt() {
        return copy().mapCbrtToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapCbrtToSelf() {
        return mapToSelf(ComposableFunction.CBRT);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapCeil() {
        return copy().mapCeilToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapCeilToSelf() {
        return mapToSelf(ComposableFunction.CEIL);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapCos() {
        return copy().mapCosToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapCosToSelf() {
        return mapToSelf(ComposableFunction.COS);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapCosh() {
        return copy().mapCoshToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapCoshToSelf() {
        return mapToSelf(ComposableFunction.COSH);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapDivide(double d) {
        return copy().mapDivideToSelf(d);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapDivideToSelf(double d) {
        return mapToSelf(BinaryFunction.DIVIDE.fix2ndArgument(d));
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapExp() {
        return copy().mapExpToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapExpToSelf() {
        return mapToSelf(ComposableFunction.EXP);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapExpm1() {
        return copy().mapExpm1ToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapExpm1ToSelf() {
        return mapToSelf(ComposableFunction.EXPM1);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapFloor() {
        return copy().mapFloorToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapFloorToSelf() {
        return mapToSelf(ComposableFunction.FLOOR);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapInv() {
        return copy().mapInvToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapInvToSelf() {
        return mapToSelf(ComposableFunction.INVERT);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapLog() {
        return copy().mapLogToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapLogToSelf() {
        return mapToSelf(ComposableFunction.LOG);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapLog10() {
        return copy().mapLog10ToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapLog10ToSelf() {
        return mapToSelf(ComposableFunction.LOG10);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapLog1p() {
        return copy().mapLog1pToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapLog1pToSelf() {
        return mapToSelf(ComposableFunction.LOG1P);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapMultiply(double d) {
        return copy().mapMultiplyToSelf(d);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapMultiplyToSelf(double d) {
        return mapToSelf(BinaryFunction.MULTIPLY.fix1stArgument(d));
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapPow(double d) {
        return copy().mapPowToSelf(d);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapPowToSelf(double d) {
        return mapToSelf(BinaryFunction.POW.fix2ndArgument(d));
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapRint() {
        return copy().mapRintToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapRintToSelf() {
        return mapToSelf(ComposableFunction.RINT);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapSignum() {
        return copy().mapSignumToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapSignumToSelf() {
        return mapToSelf(ComposableFunction.SIGNUM);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapSin() {
        return copy().mapSinToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapSinToSelf() {
        return mapToSelf(ComposableFunction.SIN);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapSinh() {
        return copy().mapSinhToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapSinhToSelf() {
        return mapToSelf(ComposableFunction.SINH);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapSqrt() {
        return copy().mapSqrtToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapSqrtToSelf() {
        return mapToSelf(ComposableFunction.SQRT);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapSubtract(double d) {
        return copy().mapSubtractToSelf(d);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapSubtractToSelf(double d) {
        return mapAddToSelf(-d);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapTan() {
        return copy().mapTanToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapTanToSelf() {
        return mapToSelf(ComposableFunction.TAN);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapTanh() {
        return copy().mapTanhToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapTanhToSelf() {
        return mapToSelf(ComposableFunction.TANH);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapUlp() {
        return copy().mapUlpToSelf();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapUlpToSelf() {
        return mapToSelf(ComposableFunction.ULP);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealMatrix outerProduct(RealVector v) throws IllegalArgumentException {
        if ((v instanceof SparseRealVector) == false) goto L5;
    L8:
        RealMatrix product = new OpenMapRealMatrix(getDimension(), v.getDimension());
    L9:
        Iterator<RealVector.Entry> thisIt = sparseIterator();
    L11:
        if (thisIt.hasNext() == false) goto L21;
        RealVector.Entry thisE = thisIt.next();
        if (thisE == null) goto L21;
        Iterator<RealVector.Entry> otherIt = v.sparseIterator();
    L16:
        if (otherIt.hasNext() == false) goto L11;
        RealVector.Entry otherE = otherIt.next();
        if (otherE == null) goto L11;
        product.setEntry(thisE.getIndex(), otherE.getIndex(), thisE.getValue() * otherE.getValue());
    L21:
        return product;
    L5:
        if ((this instanceof SparseRealVector) == true) goto L8;
        product = new Array2DRowRealMatrix(getDimension(), v.getDimension());
        goto L9
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealMatrix outerProduct(double[] v) throws IllegalArgumentException {
        return outerProduct(new ArrayRealVector(v, false));
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector projection(double[] v) throws IllegalArgumentException {
        return projection(new ArrayRealVector(v, false));
    }

    @Override // org.apache.commons.math.linear.RealVector
    public void set(double value) {
        Iterator<RealVector.Entry> it = iterator();
    L4:
        if (it.hasNext() == false) goto L8;
        RealVector.Entry e = it.next();
        if (e == null) goto L11;
        e.setValue(value);
        goto L4
    L11:
        return;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double[] toArray() {
        int dim = getDimension();
        double[] values = new double[dim];
        int i = 0;
    L3:
        if (i >= dim) goto L6;
        values[i] = getEntry(i);
        i = i + 1;
        goto L3
    L6:
        return values;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double[] getData() {
        return toArray();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector unitVector() {
        RealVector copy = copy();
        copy.unitize();
        return copy;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public void unitize() {
        mapDivideToSelf(getNorm());
    }

    @Override // org.apache.commons.math.linear.RealVector
    public Iterator<RealVector.Entry> sparseIterator() {
        return new SparseEntryIterator(this);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public Iterator<RealVector.Entry> iterator() {
        final int dim = getDimension();
        return new AnonymousClass1(this, dim);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector map(UnivariateRealFunction function) throws FunctionEvaluationException {
        return copy().mapToSelf(function);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector mapToSelf(UnivariateRealFunction function) throws FunctionEvaluationException {
        if (function.value(0.0d) != 0.0d) goto L5;
        Iterator<RealVector.Entry> it = sparseIterator();
    L7:
        if (it.hasNext() == false) goto L11;
        RealVector.Entry e = it.next();
        if (e == null) goto L11;
        e.setValue(function.value(e.getValue()));
    L11:
        return this;
    L5:
        it = iterator();
        goto L7
    }
}
