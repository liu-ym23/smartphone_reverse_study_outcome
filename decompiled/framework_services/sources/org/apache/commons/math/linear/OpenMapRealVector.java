package org.apache.commons.math.linear;

import java.io.Serializable;
import java.util.Iterator;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.OpenIntToDoubleHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class OpenMapRealVector extends AbstractRealVector implements SparseRealVector, Serializable {
    public static final double DEFAULT_ZERO_TOLERANCE = 1.0E-12d;
    private static final long serialVersionUID = 8772222695580707260L;
    private final OpenIntToDoubleHashMap entries;
    private final double epsilon;
    private final int virtualSize;

    protected class OpenMapEntry extends RealVector.Entry {
        private final OpenIntToDoubleHashMap.Iterator iter;
        final /* synthetic */ OpenMapRealVector this$0;

        protected OpenMapEntry(OpenMapRealVector this$0, OpenIntToDoubleHashMap.Iterator iter) {
            this.this$0 = this$0;
            this.iter = iter;
        }

        @Override // org.apache.commons.math.linear.RealVector.Entry
        public double getValue() {
            return this.iter.value();
        }

        @Override // org.apache.commons.math.linear.RealVector.Entry
        public void setValue(double value) {
            OpenMapRealVector.access$000(this.this$0).put(this.iter.key(), value);
        }

        @Override // org.apache.commons.math.linear.RealVector.Entry
        public int getIndex() {
            return this.iter.key();
        }
    }

    protected class OpenMapSparseIterator implements Iterator<RealVector.Entry> {
        private final RealVector.Entry current;
        private final OpenIntToDoubleHashMap.Iterator iter;
        final /* synthetic */ OpenMapRealVector this$0;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ RealVector.Entry next() {
            return next2();
        }

        protected OpenMapSparseIterator(OpenMapRealVector this$0) {
            this.this$0 = this$0;
            this.iter = OpenMapRealVector.access$000(this$0).iterator();
            this.current = new OpenMapEntry(this$0, this.iter);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public RealVector.Entry next2() {
            this.iter.advance();
            return this.current;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    static /* synthetic */ OpenIntToDoubleHashMap access$000(OpenMapRealVector x0) {
        return x0.entries;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector append(double r1) {
        return append(r1);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector append(RealVector r1) {
        return append(r1);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector append(double[] r1) {
        return append(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ AbstractRealVector copy() {
        return copy();
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector copy() {
        return copy();
    }

    @Override // org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector ebeDivide(RealVector r1) {
        return ebeDivide(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector ebeDivide(double[] r1) throws IllegalArgumentException {
        return ebeDivide(r1);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector ebeMultiply(RealVector r1) {
        return ebeMultiply(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector ebeMultiply(double[] r1) throws IllegalArgumentException {
        return ebeMultiply(r1);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector getSubVector(int r1, int r2) {
        return getSubVector(r1, r2);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector mapAdd(double r1) {
        return mapAdd(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector mapAddToSelf(double r1) {
        return mapAddToSelf(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector projection(double[] r1) throws IllegalArgumentException {
        return projection(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector subtract(RealVector r1) throws IllegalArgumentException {
        return subtract(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector subtract(double[] r1) throws IllegalArgumentException {
        return subtract(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector unitVector() {
        return unitVector();
    }

    public OpenMapRealVector() {
        this(0, 1.0E-12d);
    }

    public OpenMapRealVector(int dimension) {
        this(dimension, 1.0E-12d);
    }

    public OpenMapRealVector(int dimension, double epsilon) {
        this.virtualSize = dimension;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = epsilon;
    }

    protected OpenMapRealVector(OpenMapRealVector v, int resize) {
        this.virtualSize = v.getDimension() + resize;
        this.entries = new OpenIntToDoubleHashMap(v.entries);
        this.epsilon = v.epsilon;
    }

    public OpenMapRealVector(int dimension, int expectedSize) {
        this(dimension, expectedSize, 1.0E-12d);
    }

    public OpenMapRealVector(int dimension, int expectedSize, double epsilon) {
        this.virtualSize = dimension;
        this.entries = new OpenIntToDoubleHashMap(expectedSize, 0.0d);
        this.epsilon = epsilon;
    }

    public OpenMapRealVector(double[] values) {
        this(values, 1.0E-12d);
    }

    public OpenMapRealVector(double[] values, double epsilon) {
        this.virtualSize = values.length;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = epsilon;
        int key = 0;
    L4:
        if (key >= values.length) goto L10;
        double value = values[key];
        if (isDefaultValue(value) == true) goto L8;
        this.entries.put(key, value);
    L8:
        key = key + 1;
        goto L4
    }

    public OpenMapRealVector(Double[] values) {
        this(values, 1.0E-12d);
    }

    public OpenMapRealVector(Double[] values, double epsilon) {
        this.virtualSize = values.length;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = epsilon;
        int key = 0;
    L4:
        if (key >= values.length) goto L10;
        double value = values[key].doubleValue();
        if (isDefaultValue(value) == true) goto L8;
        this.entries.put(key, value);
    L8:
        key = key + 1;
        goto L4
    }

    public OpenMapRealVector(OpenMapRealVector v) {
        this.virtualSize = v.getDimension();
        this.entries = new OpenIntToDoubleHashMap(v.getEntries());
        this.epsilon = v.epsilon;
    }

    public OpenMapRealVector(RealVector v) {
        this.virtualSize = v.getDimension();
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = 1.0E-12d;
        int key = 0;
    L4:
        if (key >= this.virtualSize) goto L10;
        double value = v.getEntry(key);
        if (isDefaultValue(value) == true) goto L8;
        this.entries.put(key, value);
    L8:
        key = key + 1;
        goto L4
    }

    private OpenIntToDoubleHashMap getEntries() {
        return this.entries;
    }

    protected boolean isDefaultValue(double value) {
        if (FastMath.abs(value) >= this.epsilon) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector add(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        if ((v instanceof OpenMapRealVector) == false) goto L7;
        return add((OpenMapRealVector) v);
    L7:
        return super.add(v);
    }

    public OpenMapRealVector add(OpenMapRealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        if (this.entries.size() <= v.entries.size()) goto L5;
        boolean copyThis = true;
    L6:
        if (copyThis == false) goto L8;
        OpenMapRealVector res = copy();
    L9:
        if (copyThis == false) goto L12;
        OpenIntToDoubleHashMap r2 = v.entries;
    L11:
        OpenIntToDoubleHashMap.Iterator iter = r2.iterator();
        if (copyThis == false) goto L15;
        OpenIntToDoubleHashMap randomAccess = this.entries;
    L17:
        if (iter.hasNext() == false) goto L23;
        iter.advance();
        int key = iter.key();
        if (randomAccess.containsKey(key) == true) goto L20;
        res.setEntry(key, iter.value());
        goto L17
    L20:
        res.setEntry(key, randomAccess.get(key) + iter.value());
        goto L17
    L23:
        return res;
    L15:
        randomAccess = v.entries;
        goto L17
    L12:
        r2 = this.entries;
        goto L11
    L8:
        res = v.copy();
        goto L9
    L5:
        copyThis = false;
        goto L6
    }

    public OpenMapRealVector append(OpenMapRealVector v) {
        OpenMapRealVector res = new OpenMapRealVector(this, v.getDimension());
        OpenIntToDoubleHashMap.Iterator iter = v.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res.setEntry(iter.key() + this.virtualSize, iter.value());
        goto L4
    L6:
        return res;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public OpenMapRealVector append(RealVector v) {
        if ((v instanceof OpenMapRealVector) == false) goto L7;
        return append((OpenMapRealVector) v);
    L7:
        return append(v.getData());
    }

    @Override // org.apache.commons.math.linear.RealVector
    public OpenMapRealVector append(double d) {
        OpenMapRealVector res = new OpenMapRealVector(this, 1);
        res.setEntry(this.virtualSize, d);
        return res;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public OpenMapRealVector append(double[] a) {
        OpenMapRealVector res = new OpenMapRealVector(this, a.length);
        int i = 0;
    L4:
        if (i >= a.length) goto L7;
        res.setEntry(this.virtualSize + i, a[i]);
        i = i + 1;
        goto L4
    L7:
        return res;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public OpenMapRealVector copy() {
        return new OpenMapRealVector(this);
    }

    public double dotProduct(OpenMapRealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        if (this.entries.size() >= v.entries.size()) goto L5;
        boolean thisIsSmaller = true;
    L6:
        if (thisIsSmaller == false) goto L9;
        OpenIntToDoubleHashMap r1 = this.entries;
    L8:
        OpenIntToDoubleHashMap.Iterator iter = r1.iterator();
        if (thisIsSmaller == false) goto L12;
        OpenIntToDoubleHashMap larger = v.entries;
    L13:
        double d = 0.0d;
    L15:
        if (iter.hasNext() == false) goto L17;
        iter.advance();
        d = d + (iter.value() * larger.get(iter.key()));
        goto L15
    L17:
        return d;
    L12:
        larger = this.entries;
        goto L13
    L9:
        r1 = v.entries;
        goto L8
    L5:
        thisIsSmaller = false;
        goto L6
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double dotProduct(RealVector v) throws IllegalArgumentException {
        if ((v instanceof OpenMapRealVector) == false) goto L7;
        return dotProduct((OpenMapRealVector) v);
    L7:
        return super.dotProduct(v);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public OpenMapRealVector ebeDivide(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        OpenMapRealVector res = new OpenMapRealVector(this);
        OpenIntToDoubleHashMap.Iterator iter = res.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res.setEntry(iter.key(), iter.value() / v.getEntry(iter.key()));
        goto L4
    L6:
        return res;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public OpenMapRealVector ebeDivide(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        OpenMapRealVector res = new OpenMapRealVector(this);
        OpenIntToDoubleHashMap.Iterator iter = res.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res.setEntry(iter.key(), iter.value() / v[iter.key()]);
        goto L4
    L6:
        return res;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public OpenMapRealVector ebeMultiply(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        OpenMapRealVector res = new OpenMapRealVector(this);
        OpenIntToDoubleHashMap.Iterator iter = res.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res.setEntry(iter.key(), iter.value() * v.getEntry(iter.key()));
        goto L4
    L6:
        return res;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public OpenMapRealVector ebeMultiply(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        OpenMapRealVector res = new OpenMapRealVector(this);
        OpenIntToDoubleHashMap.Iterator iter = res.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res.setEntry(iter.key(), iter.value() * v[iter.key()]);
        goto L4
    L6:
        return res;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public OpenMapRealVector getSubVector(int index, int n) throws MatrixIndexException {
        checkIndex(index);
        checkIndex((index + n) - 1);
        OpenMapRealVector res = new OpenMapRealVector(n);
        int end = index + n;
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L10;
        iter.advance();
        int key = iter.key();
        if (key < index) goto L4;
        if (key >= end) goto L4;
        res.setEntry(key - index, iter.value());
        goto L4
    L10:
        return res;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double[] getData() {
        double[] res = new double[this.virtualSize];
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res[iter.key()] = iter.value();
        goto L4
    L6:
        return res;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public int getDimension() {
        return this.virtualSize;
    }

    public double getDistance(OpenMapRealVector v) throws IllegalArgumentException {
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
        double res = 0.0d;
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        int key = iter.key();
        double delta = iter.value() - v.getEntry(key);
        res = res + (delta * delta);
        goto L4
    L6:
        OpenIntToDoubleHashMap.Iterator iter2 = v.getEntries().iterator();
    L8:
        if (iter2.hasNext() == false) goto L14;
        iter2.advance();
        int key2 = iter2.key();
        if (this.entries.containsKey(key2) == true) goto L8;
        double value = iter2.value();
        res = res + (value * value);
        goto L8
    L14:
        return FastMath.sqrt(res);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getDistance(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        if ((v instanceof OpenMapRealVector) == false) goto L7;
        return getDistance((OpenMapRealVector) v);
    L7:
        return getDistance(v.getData());
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getDistance(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double res = 0.0d;
        int i = 0;
    L4:
        if (i >= v.length) goto L7;
        double delta = this.entries.get(i) - v[i];
        res = res + (delta * delta);
        i = i + 1;
        goto L4
    L7:
        return FastMath.sqrt(res);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getEntry(int index) throws MatrixIndexException {
        checkIndex(index);
        return this.entries.get(index);
    }

    public double getL1Distance(OpenMapRealVector v) {
        double max = 0.0d;
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        double delta = FastMath.abs(iter.value() - v.getEntry(iter.key()));
        max = max + delta;
        goto L4
    L6:
        OpenIntToDoubleHashMap.Iterator iter2 = v.getEntries().iterator();
    L8:
        if (iter2.hasNext() == false) goto L13;
        iter2.advance();
        int key = iter2.key();
        if (this.entries.containsKey(key) == true) goto L8;
        double delta2 = FastMath.abs(iter2.value());
        max = max + FastMath.abs(delta2);
        goto L8
    L13:
        return max;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getL1Distance(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        if ((v instanceof OpenMapRealVector) == false) goto L7;
        return getL1Distance((OpenMapRealVector) v);
    L7:
        return getL1Distance(v.getData());
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getL1Distance(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double max = 0.0d;
        int i = 0;
    L4:
        if (i >= v.length) goto L7;
        double delta = FastMath.abs(getEntry(i) - v[i]);
        max = max + delta;
        i = i + 1;
        goto L4
    L7:
        return max;
    }

    private double getLInfDistance(OpenMapRealVector v) {
        double max = 0.0d;
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L9;
        iter.advance();
        double delta = FastMath.abs(iter.value() - v.getEntry(iter.key()));
        if (delta <= max) goto L4;
        max = delta;
        goto L4
    L9:
        OpenIntToDoubleHashMap.Iterator iter2 = v.getEntries().iterator();
    L11:
        if (iter2.hasNext() == false) goto L18;
        iter2.advance();
        int key = iter2.key();
        if (this.entries.containsKey(key) == true) goto L11;
        if (iter2.value() <= max) goto L11;
        max = iter2.value();
        goto L11
    L18:
        return max;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getLInfDistance(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        if ((v instanceof OpenMapRealVector) == false) goto L7;
        return getLInfDistance((OpenMapRealVector) v);
    L7:
        return getLInfDistance(v.getData());
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getLInfDistance(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double max = 0.0d;
        int i = 0;
    L4:
        if (i >= v.length) goto L10;
        double delta = FastMath.abs(getEntry(i) - v[i]);
        if (delta <= max) goto L8;
        max = delta;
    L8:
        i = i + 1;
        goto L4
    L10:
        return max;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public boolean isInfinite() {
        boolean infiniteFound = false;
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L13;
        iter.advance();
        double value = iter.value();
        if (Double.isNaN(value) == true) goto L7;
        if (Double.isInfinite(value) == false) goto L4;
        infiniteFound = true;
        goto L4
    L7:
        return false;
    L13:
        return infiniteFound;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public boolean isNaN() {
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L9;
        iter.advance();
        if (Double.isNaN(iter.value()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public OpenMapRealVector mapAdd(double d) {
        return copy().mapAddToSelf(d);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public OpenMapRealVector mapAddToSelf(double d) {
        int i = 0;
    L4:
        if (i >= this.virtualSize) goto L7;
        setEntry(i, getEntry(i) + d);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealMatrix outerProduct(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        RealMatrix res = new OpenMapRealMatrix(this.virtualSize, this.virtualSize);
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L10;
        iter.advance();
        int row = iter.key();
        double value = iter.value();
        int col = 0;
    L7:
        if (col >= this.virtualSize) goto L4;
        res.setEntry(row, col, v[col] * value);
        col = col + 1;
        goto L7
    L10:
        return res;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector projection(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        return v.mapMultiply(dotProduct(v) / v.dotProduct(v));
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public OpenMapRealVector projection(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        return (OpenMapRealVector) projection(new OpenMapRealVector(v));
    }

    @Override // org.apache.commons.math.linear.RealVector
    public void setEntry(int index, double value) throws MatrixIndexException {
        checkIndex(index);
        if (isDefaultValue(value) == true) goto L6;
        this.entries.put(index, value);
        return;
    L6:
        if (this.entries.containsKey(index) == false) goto L10;
        this.entries.remove(index);
        return;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public void setSubVector(int index, RealVector v) throws MatrixIndexException {
        checkIndex(index);
        checkIndex((v.getDimension() + index) - 1);
        setSubVector(index, v.getData());
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
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

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public void set(double value) {
        int i = 0;
    L4:
        if (i >= this.virtualSize) goto L7;
        setEntry(i, value);
        i = i + 1;
        goto L4
    }

    public OpenMapRealVector subtract(OpenMapRealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        OpenMapRealVector res = copy();
        OpenIntToDoubleHashMap.Iterator iter = v.getEntries().iterator();
    L4:
        if (iter.hasNext() == false) goto L10;
        iter.advance();
        int key = iter.key();
        if (this.entries.containsKey(key) == true) goto L7;
        res.setEntry(key, -iter.value());
        goto L4
    L7:
        res.setEntry(key, this.entries.get(key) - iter.value());
        goto L4
    L10:
        return res;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public OpenMapRealVector subtract(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        if ((v instanceof OpenMapRealVector) == false) goto L7;
        return subtract((OpenMapRealVector) v);
    L7:
        return subtract(v.getData());
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public OpenMapRealVector subtract(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        OpenMapRealVector res = new OpenMapRealVector(this);
        int i = 0;
    L4:
        if (i >= v.length) goto L11;
        if (this.entries.containsKey(i) == false) goto L8;
        res.setEntry(i, this.entries.get(i) - v[i]);
    L9:
        i = i + 1;
        goto L4
    L8:
        res.setEntry(i, -v[i]);
        goto L9
    L11:
        return res;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public OpenMapRealVector unitVector() {
        OpenMapRealVector res = copy();
        res.unitize();
        return res;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public void unitize() {
        double norm = getNorm();
        if (isDefaultValue(norm) == true) goto L10;
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
    L6:
        if (iter.hasNext() == false) goto L8;
        iter.advance();
        this.entries.put(iter.key(), iter.value() / norm);
        goto L6
    L8:
        return;
    L10:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double[] toArray() {
        return getData();
    }

    public int hashCode() {
        long temp = Double.doubleToLongBits(this.epsilon);
        int result = (1 * 31) + ((int) ((temp >>> 32) ^ temp));
        int result2 = (result * 31) + this.virtualSize;
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        long temp2 = Double.doubleToLongBits(iter.value());
        result2 = (result2 * 31) + ((int) ((temp2 >> 32) ^ temp2));
        goto L4
    L6:
        return result2;
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof OpenMapRealVector) == true) goto L8;
        return false;
    L8:
        OpenMapRealVector other = (OpenMapRealVector) obj;
        if (this.virtualSize == other.virtualSize) goto L12;
        return false;
    L12:
        if (Double.doubleToLongBits(this.epsilon) == Double.doubleToLongBits(other.epsilon)) goto L14;
        return false;
    L14:
        OpenIntToDoubleHashMap.Iterator iter = this.entries.iterator();
    L16:
        if (iter.hasNext() == false) goto L21;
        iter.advance();
        double test = other.getEntry(iter.key());
        if (Double.doubleToLongBits(test) == Double.doubleToLongBits(iter.value())) goto L16;
        return false;
    L21:
        OpenIntToDoubleHashMap.Iterator iter2 = other.getEntries().iterator();
    L23:
        if (iter2.hasNext() == false) goto L28;
        iter2.advance();
        double test2 = iter2.value();
        if (Double.doubleToLongBits(test2) == Double.doubleToLongBits(getEntry(iter2.key()))) goto L23;
        return false;
    L28:
        return true;
    }

    @Deprecated
    public double getSparcity() {
        return getSparsity();
    }

    public double getSparsity() {
        return ((double) this.entries.size()) / ((double) getDimension());
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public Iterator<RealVector.Entry> sparseIterator() {
        return new OpenMapSparseIterator(this);
    }
}
