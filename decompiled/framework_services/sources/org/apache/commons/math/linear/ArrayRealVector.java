package org.apache.commons.math.linear;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayRealVector extends AbstractRealVector implements Serializable {
    private static final RealVectorFormat DEFAULT_FORMAT = null;
    private static final long serialVersionUID = -1097961340710804027L;
    protected double[] data;

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector copy() {
        return copy();
    }

    static {
        DEFAULT_FORMAT = RealVectorFormat.getInstance();
    }

    public ArrayRealVector() {
        this.data = new double[0];
    }

    public ArrayRealVector(int size) {
        this.data = new double[size];
    }

    public ArrayRealVector(int size, double preset) {
        this.data = new double[size];
        Arrays.fill(this.data, preset);
    }

    public ArrayRealVector(double[] d) {
        this.data = (double[]) d.clone();
    }

    public ArrayRealVector(double[] d, boolean copyArray) {
        if (copyArray == false) goto L5;
        double[] r0 = (double[]) d.clone();
    L6:
        this.data = r0;
        return;
    L5:
        r0 = d;
        goto L6
    }

    public ArrayRealVector(double[] d, int pos, int size) {
        if (d.length < (pos + size)) goto L7;
        this.data = new double[size];
        System.arraycopy(d, pos, this.data, 0, size);
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POSITION_SIZE_MISMATCH_INPUT_ARRAY, new Object[]{Integer.valueOf(pos), Integer.valueOf(size), Integer.valueOf(d.length)});
    }

    public ArrayRealVector(Double[] d) {
        this.data = new double[d.length];
        int i = 0;
    L4:
        if (i >= d.length) goto L7;
        this.data[i] = d[i].doubleValue();
        i = i + 1;
        goto L4
    }

    public ArrayRealVector(Double[] d, int pos, int size) {
        if (d.length < (pos + size)) goto L11;
        this.data = new double[size];
        int i = pos;
    L6:
        if (i >= (pos + size)) goto L9;
        this.data[i - pos] = d[i].doubleValue();
        i = i + 1;
        goto L6
    L9:
        return;
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POSITION_SIZE_MISMATCH_INPUT_ARRAY, new Object[]{Integer.valueOf(pos), Integer.valueOf(size), Integer.valueOf(d.length)});
    }

    public ArrayRealVector(RealVector v) {
        this.data = new double[v.getDimension()];
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = v.getEntry(i);
        i = i + 1;
        goto L4
    }

    public ArrayRealVector(ArrayRealVector v) {
        this(v, true);
    }

    public ArrayRealVector(ArrayRealVector v, boolean deep) {
        double[] r0 = v.data;
        if (deep == false) goto L5;
        r0 = (double[]) r0.clone();
    L5:
        this.data = r0;
    }

    public ArrayRealVector(ArrayRealVector v1, ArrayRealVector v2) {
        this.data = new double[v1.data.length + v2.data.length];
        System.arraycopy(v1.data, 0, this.data, 0, v1.data.length);
        System.arraycopy(v2.data, 0, this.data, v1.data.length, v2.data.length);
    }

    public ArrayRealVector(ArrayRealVector v1, RealVector v2) {
        int l1 = v1.data.length;
        int l2 = v2.getDimension();
        this.data = new double[l1 + l2];
        System.arraycopy(v1.data, 0, this.data, 0, l1);
        int i = 0;
    L3:
        if (i >= l2) goto L6;
        this.data[l1 + i] = v2.getEntry(i);
        i = i + 1;
        goto L3
    }

    public ArrayRealVector(RealVector v1, ArrayRealVector v2) {
        int l1 = v1.getDimension();
        int l2 = v2.data.length;
        this.data = new double[l1 + l2];
        int i = 0;
    L3:
        if (i >= l1) goto L5;
        this.data[i] = v1.getEntry(i);
        i = i + 1;
        goto L3
    L5:
        System.arraycopy(v2.data, 0, this.data, l1, l2);
    }

    public ArrayRealVector(ArrayRealVector v1, double[] v2) {
        int l1 = v1.getDimension();
        int l2 = v2.length;
        this.data = new double[l1 + l2];
        System.arraycopy(v1.data, 0, this.data, 0, l1);
        System.arraycopy(v2, 0, this.data, l1, l2);
    }

    public ArrayRealVector(double[] v1, ArrayRealVector v2) {
        int l1 = v1.length;
        int l2 = v2.getDimension();
        this.data = new double[l1 + l2];
        System.arraycopy(v1, 0, this.data, 0, l1);
        System.arraycopy(v2.data, 0, this.data, l1, l2);
    }

    public ArrayRealVector(double[] v1, double[] v2) {
        int l1 = v1.length;
        int l2 = v2.length;
        this.data = new double[l1 + l2];
        System.arraycopy(v1, 0, this.data, 0, l1);
        System.arraycopy(v2, 0, this.data, l1, l2);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public AbstractRealVector copy() {
        return new ArrayRealVector(this, true);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector add(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == true) goto L5;
        checkVectorDimensions(v);
        double[] out = (double[]) this.data.clone();
        Iterator<RealVector.Entry> it = v.sparseIterator();
    L8:
        if (it.hasNext() == false) goto L13;
        RealVector.Entry e = it.next();
        if (e == null) goto L13;
        int r2 = e.getIndex();
        out[r2] = out[r2] + e.getValue();
    L13:
        return new ArrayRealVector(out, false);
    L5:
        return add((ArrayRealVector) v);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector add(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double[] out = (double[]) this.data.clone();
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        out[i] = out[i] + v[i];
        i = i + 1;
        goto L4
    L7:
        return new ArrayRealVector(out, false);
    }

    public ArrayRealVector add(ArrayRealVector v) throws IllegalArgumentException {
        return (ArrayRealVector) add(v.data);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector subtract(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == true) goto L5;
        checkVectorDimensions(v);
        double[] out = (double[]) this.data.clone();
        Iterator<RealVector.Entry> it = v.sparseIterator();
    L8:
        if (it.hasNext() == false) goto L13;
        RealVector.Entry e = it.next();
        if (e == null) goto L13;
        int r2 = e.getIndex();
        out[r2] = out[r2] - e.getValue();
    L13:
        return new ArrayRealVector(out, false);
    L5:
        return subtract((ArrayRealVector) v);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector subtract(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double[] out = (double[]) this.data.clone();
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        out[i] = out[i] - v[i];
        i = i + 1;
        goto L4
    L7:
        return new ArrayRealVector(out, false);
    }

    public ArrayRealVector subtract(ArrayRealVector v) throws IllegalArgumentException {
        return (ArrayRealVector) subtract(v.data);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapAddToSelf(double d) {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = this.data[i] + d;
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapSubtractToSelf(double d) {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = this.data[i] - d;
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapMultiplyToSelf(double d) {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = this.data[i] * d;
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapDivideToSelf(double d) {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = this.data[i] / d;
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapPowToSelf(double d) {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.pow(this.data[i], d);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapExpToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.exp(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapExpm1ToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.expm1(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapLogToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.log(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapLog10ToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.log10(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapLog1pToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.log1p(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapCoshToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.cosh(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapSinhToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.sinh(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapTanhToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.tanh(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapCosToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.cos(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapSinToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.sin(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapTanToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.tan(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapAcosToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.acos(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapAsinToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.asin(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapAtanToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.atan(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapInvToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = 1.0d / this.data[i];
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapAbsToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.abs(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapSqrtToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.sqrt(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapCbrtToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.cbrt(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapCeilToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.ceil(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapFloorToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.floor(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapRintToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.rint(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapSignumToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.signum(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector mapUlpToSelf() {
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        this.data[i] = FastMath.ulp(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector ebeMultiply(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == true) goto L5;
        checkVectorDimensions(v);
        double[] out = (double[]) this.data.clone();
        int i = 0;
    L8:
        if (i >= this.data.length) goto L11;
        out[i] = out[i] * v.getEntry(i);
        i = i + 1;
        goto L8
    L11:
        return new ArrayRealVector(out, false);
    L5:
        return ebeMultiply((ArrayRealVector) v);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector ebeMultiply(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double[] out = (double[]) this.data.clone();
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        out[i] = out[i] * v[i];
        i = i + 1;
        goto L4
    L7:
        return new ArrayRealVector(out, false);
    }

    public ArrayRealVector ebeMultiply(ArrayRealVector v) throws IllegalArgumentException {
        return (ArrayRealVector) ebeMultiply(v.data);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector ebeDivide(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == true) goto L5;
        checkVectorDimensions(v);
        double[] out = (double[]) this.data.clone();
        int i = 0;
    L8:
        if (i >= this.data.length) goto L11;
        out[i] = out[i] / v.getEntry(i);
        i = i + 1;
        goto L8
    L11:
        return new ArrayRealVector(out, false);
    L5:
        return ebeDivide((ArrayRealVector) v);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector ebeDivide(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double[] out = (double[]) this.data.clone();
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        out[i] = out[i] / v[i];
        i = i + 1;
        goto L4
    L7:
        return new ArrayRealVector(out, false);
    }

    public ArrayRealVector ebeDivide(ArrayRealVector v) throws IllegalArgumentException {
        return (ArrayRealVector) ebeDivide(v.data);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double[] getData() {
        return (double[]) this.data.clone();
    }

    public double[] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double dotProduct(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == true) goto L5;
        checkVectorDimensions(v);
        double dot = 0.0d;
        Iterator<RealVector.Entry> it = v.sparseIterator();
    L8:
        if (it.hasNext() == false) goto L12;
        RealVector.Entry e = it.next();
        if (e == null) goto L12;
        dot = dot + (this.data[e.getIndex()] * e.getValue());
    L12:
        return dot;
    L5:
        return dotProduct((ArrayRealVector) v);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double dotProduct(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double dot = 0.0d;
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        dot = dot + (this.data[i] * v[i]);
        i = i + 1;
        goto L4
    L7:
        return dot;
    }

    public double dotProduct(ArrayRealVector v) throws IllegalArgumentException {
        return dotProduct(v.data);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getNorm() {
        double sum = 0.0d;
        double[] r2 = this.data;
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L6;
        double a = r2[r4];
        sum = sum + (a * a);
        r4 = r4 + 1;
        goto L3
    L6:
        return FastMath.sqrt(sum);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getL1Norm() {
        double sum = 0.0d;
        double[] r2 = this.data;
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        double a = r2[r4];
        sum = sum + FastMath.abs(a);
        r4 = r4 + 1;
        goto L3
    L5:
        return sum;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getLInfNorm() {
        double max = 0.0d;
        double[] r2 = this.data;
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        double a = r2[r4];
        max = FastMath.max(max, FastMath.abs(a));
        r4 = r4 + 1;
        goto L3
    L5:
        return max;
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getDistance(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == true) goto L5;
        checkVectorDimensions(v);
        double sum = 0.0d;
        int i = 0;
    L8:
        if (i >= this.data.length) goto L11;
        double delta = this.data[i] - v.getEntry(i);
        sum = sum + (delta * delta);
        i = i + 1;
        goto L8
    L11:
        return FastMath.sqrt(sum);
    L5:
        return getDistance((ArrayRealVector) v);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getDistance(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double sum = 0.0d;
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        double delta = this.data[i] - v[i];
        sum = sum + (delta * delta);
        i = i + 1;
        goto L4
    L7:
        return FastMath.sqrt(sum);
    }

    public double getDistance(ArrayRealVector v) throws IllegalArgumentException {
        return getDistance(v.data);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getL1Distance(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == true) goto L5;
        checkVectorDimensions(v);
        double sum = 0.0d;
        int i = 0;
    L8:
        if (i >= this.data.length) goto L11;
        double delta = this.data[i] - v.getEntry(i);
        sum = sum + FastMath.abs(delta);
        i = i + 1;
        goto L8
    L11:
        return sum;
    L5:
        return getL1Distance((ArrayRealVector) v);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getL1Distance(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double sum = 0.0d;
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        double delta = this.data[i] - v[i];
        sum = sum + FastMath.abs(delta);
        i = i + 1;
        goto L4
    L7:
        return sum;
    }

    public double getL1Distance(ArrayRealVector v) throws IllegalArgumentException {
        return getL1Distance(v.data);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getLInfDistance(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == true) goto L5;
        checkVectorDimensions(v);
        double max = 0.0d;
        int i = 0;
    L8:
        if (i >= this.data.length) goto L11;
        double delta = this.data[i] - v.getEntry(i);
        max = FastMath.max(max, FastMath.abs(delta));
        i = i + 1;
        goto L8
    L11:
        return max;
    L5:
        return getLInfDistance((ArrayRealVector) v);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double getLInfDistance(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        double max = 0.0d;
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        double delta = this.data[i] - v[i];
        max = FastMath.max(max, FastMath.abs(delta));
        i = i + 1;
        goto L4
    L7:
        return max;
    }

    public double getLInfDistance(ArrayRealVector v) throws IllegalArgumentException {
        return getLInfDistance(v.data);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector unitVector() throws ArithmeticException {
        double norm = getNorm();
        if (norm == 0.0d) goto L7;
        return mapDivide(norm);
    L7:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public void unitize() throws ArithmeticException {
        double norm = getNorm();
        if (norm == 0.0d) goto L7;
        mapDivideToSelf(norm);
        return;
    L7:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector projection(RealVector v) {
        return v.mapMultiply(dotProduct(v) / v.dotProduct(v));
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealVector projection(double[] v) {
        return projection(new ArrayRealVector(v, false));
    }

    public ArrayRealVector projection(ArrayRealVector v) {
        return (ArrayRealVector) v.mapMultiply(dotProduct(v) / v.dotProduct(v));
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealMatrix outerProduct(RealVector v) throws IllegalArgumentException {
        if ((v instanceof ArrayRealVector) == true) goto L5;
        checkVectorDimensions(v);
        int m = this.data.length;
        RealMatrix out = MatrixUtils.createRealMatrix(m, m);
        int i = 0;
    L8:
        if (i >= this.data.length) goto L15;
        int j = 0;
    L11:
        if (j >= this.data.length) goto L13;
        out.setEntry(i, j, this.data[i] * v.getEntry(j));
        j = j + 1;
        goto L11
    L13:
        i = i + 1;
        goto L8
    L15:
        return out;
    L5:
        return outerProduct((ArrayRealVector) v);
    }

    public RealMatrix outerProduct(ArrayRealVector v) throws IllegalArgumentException {
        return outerProduct(v.data);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public RealMatrix outerProduct(double[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        int m = this.data.length;
        RealMatrix out = MatrixUtils.createRealMatrix(m, m);
        int i = 0;
    L4:
        if (i >= this.data.length) goto L11;
        int j = 0;
    L7:
        if (j >= this.data.length) goto L9;
        out.setEntry(i, j, this.data[i] * v[j]);
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    L11:
        return out;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public double getEntry(int index) throws MatrixIndexException {
        return this.data[index];
    }

    @Override // org.apache.commons.math.linear.RealVector
    public int getDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector append(RealVector v) {
        return new ArrayRealVector(this, (ArrayRealVector) v);
    L6:
        return new ArrayRealVector(this, v);
    }

    public ArrayRealVector append(ArrayRealVector v) {
        return new ArrayRealVector(this, v);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector append(double in) {
        double[] out = new double[this.data.length + 1];
        System.arraycopy(this.data, 0, out, 0, this.data.length);
        out[this.data.length] = in;
        return new ArrayRealVector(out, false);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector append(double[] in) {
        return new ArrayRealVector(this, in);
    }

    @Override // org.apache.commons.math.linear.RealVector
    public RealVector getSubVector(int index, int n) {
        ArrayRealVector out = new ArrayRealVector(n);
        System.arraycopy(this.data, index, out.data, 0, n);     // Catch: IndexOutOfBoundsException -> L5
    L7:
        return out;
    L6:
        checkIndex(index);
        checkIndex((index + n) - 1);
        goto L7
    }

    @Override // org.apache.commons.math.linear.RealVector
    public void setEntry(int index, double value) {
        this.data[index] = value;     // Catch: IndexOutOfBoundsException -> L4
        return;
    L5:
        checkIndex(index);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public void setSubVector(int index, RealVector v) {
        set(index, (ArrayRealVector) v);     // Catch: IndexOutOfBoundsException -> L4 ClassCastException -> L6
    L19:
        return;
    L7:
        int i = index;
    L8:
        if (i >= (v.getDimension() + index)) goto L20;
        this.data[i] = v.getEntry(i - index);     // Catch: IndexOutOfBoundsException -> L4
        i = i + 1;
        goto L8
    L20:
        return;
    L13:
        checkIndex(index);
        checkIndex((v.getDimension() + index) - 1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public void setSubVector(int index, double[] v) {
        System.arraycopy(v, 0, this.data, index, v.length);     // Catch: IndexOutOfBoundsException -> L4
        return;
    L5:
        checkIndex(index);
        checkIndex((v.length + index) - 1);
    }

    public void set(int index, ArrayRealVector v) throws MatrixIndexException {
        setSubVector(index, v.data);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public void set(double value) {
        Arrays.fill(this.data, value);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector, org.apache.commons.math.linear.RealVector
    public double[] toArray() {
        return (double[]) this.data.clone();
    }

    public String toString() {
        return DEFAULT_FORMAT.format(this);
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector
    protected void checkVectorDimensions(RealVector v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
    }

    @Override // org.apache.commons.math.linear.AbstractRealVector
    protected void checkVectorDimensions(int n) throws IllegalArgumentException {
        if (this.data.length != n) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(this.data.length), Integer.valueOf(n)});
    }

    @Override // org.apache.commons.math.linear.RealVector
    public boolean isNaN() {
        double[] r0 = this.data;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        double v = r0[r3];
        if (Double.isNaN(v) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // org.apache.commons.math.linear.RealVector
    public boolean isInfinite() {
        if (isNaN() == false) goto L5;
        return false;
    L5:
        double[] r0 = this.data;
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        double v = r0[r3];
        if (Double.isInfinite(v) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L8;
    L26:
        return false;
    L8:
        if ((other instanceof RealVector) == false) goto L26;
        RealVector rhs = (RealVector) other;
        if (this.data.length == rhs.getDimension()) goto L14;
        return false;
    L14:
        if (rhs.isNaN() == true) goto L16;
        int i = 0;
    L19:
        if (i >= this.data.length) goto L25;
        if (this.data[i] != rhs.getEntry(i)) goto L22;
        i = i + 1;
        goto L19
    L22:
        return false;
    L25:
        return true;
    L16:
        return isNaN();
    }

    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 9;
    L7:
        return MathUtils.hash(this.data);
    }
}
