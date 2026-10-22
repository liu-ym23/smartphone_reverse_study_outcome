package org.apache.commons.math.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;

/* JADX INFO: loaded from: classes3.dex */
public class BigReal implements FieldElement<BigReal>, Comparable<BigReal>, Serializable {
    public static final BigReal ONE = null;
    public static final BigReal ZERO = null;
    private static final long serialVersionUID = 4984534880991310382L;
    private final BigDecimal d;
    private RoundingMode roundingMode;
    private int scale;

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ BigReal add(BigReal r1) {
        return add2(r1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BigReal r1) {
        return compareTo2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ BigReal divide(BigReal r1) throws ArithmeticException {
        return divide2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ BigReal multiply(BigReal r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ BigReal subtract(BigReal r1) {
        return subtract2(r1);
    }

    static {
        ZERO = new BigReal(BigDecimal.ZERO);
        ONE = new BigReal(BigDecimal.ONE);
    }

    public BigReal(BigDecimal val) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = val;
    }

    public BigReal(BigInteger val) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(val);
    }

    public BigReal(BigInteger unscaledVal, int scale) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(unscaledVal, scale);
    }

    public BigReal(BigInteger unscaledVal, int scale, MathContext mc) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(unscaledVal, scale, mc);
    }

    public BigReal(BigInteger val, MathContext mc) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(val, mc);
    }

    public BigReal(char[] in) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(in);
    }

    public BigReal(char[] in, int offset, int len) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(in, offset, len);
    }

    public BigReal(char[] in, int offset, int len, MathContext mc) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(in, offset, len, mc);
    }

    public BigReal(char[] in, MathContext mc) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(in, mc);
    }

    public BigReal(double val) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(val);
    }

    public BigReal(double val, MathContext mc) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(val, mc);
    }

    public BigReal(int val) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(val);
    }

    public BigReal(int val, MathContext mc) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(val, mc);
    }

    public BigReal(long val) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(val);
    }

    public BigReal(long val, MathContext mc) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(val, mc);
    }

    public BigReal(String val) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(val);
    }

    public BigReal(String val, MathContext mc) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(val, mc);
    }

    public RoundingMode getRoundingMode() {
        return this.roundingMode;
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        this.roundingMode = roundingMode;
    }

    public int getScale() {
        return this.scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public BigReal add2(BigReal a) {
        return new BigReal(this.d.add(a.d));
    }

    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public BigReal subtract2(BigReal a) {
        return new BigReal(this.d.subtract(a.d));
    }

    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public BigReal divide2(BigReal a) throws ArithmeticException {
        return new BigReal(this.d.divide(a.d, this.scale, this.roundingMode));
    }

    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public BigReal multiply2(BigReal a) {
        return new BigReal(this.d.multiply(a.d));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BigReal a) {
        return this.d.compareTo(a.d);
    }

    public double doubleValue() {
        return this.d.doubleValue();
    }

    public BigDecimal bigDecimalValue() {
        return this.d;
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if ((other instanceof BigReal) == true) goto L8;
        return false;
    L8:
        return this.d.equals(((BigReal) other).d);
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // org.apache.commons.math.FieldElement
    public Field<BigReal> getField() {
        return BigRealField.getInstance();
    }
}
