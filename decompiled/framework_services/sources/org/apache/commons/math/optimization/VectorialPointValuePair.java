package org.apache.commons.math.optimization;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class VectorialPointValuePair implements Serializable {
    private static final long serialVersionUID = 1003888396256744753L;
    private final double[] point;
    private final double[] value;

    public VectorialPointValuePair(double[] point, double[] value) {
        double[] r0 = null;
        if (point != null) goto L5;
        double[] r1 = null;
    L6:
        this.point = r1;
        if (value == null) goto L10;
        r0 = (double[]) value.clone();
    L10:
        this.value = r0;
        return;
    L5:
        r1 = (double[]) point.clone();
        goto L6
    }

    public VectorialPointValuePair(double[] point, double[] value, boolean copyArray) {
        double[] r0 = null;
        if (copyArray == false) goto L7;
        if (point != null) goto L6;
        double[] r1 = null;
    L8:
        this.point = r1;
        if (copyArray == false) goto L13;
        if (value == null) goto L14;
        r0 = (double[]) value.clone();
    L14:
        this.value = r0;
        return;
    L13:
        r0 = value;
        goto L14
    L6:
        r1 = (double[]) point.clone();
        goto L8
    L7:
        r1 = point;
        goto L8
    }

    public double[] getPoint() {
        if (this.point != null) goto L6;
        return null;
    L6:
        return (double[]) this.point.clone();
    }

    public double[] getPointRef() {
        return this.point;
    }

    public double[] getValue() {
        if (this.value != null) goto L6;
        return null;
    L6:
        return (double[]) this.value.clone();
    }

    public double[] getValueRef() {
        return this.value;
    }
}
