package org.apache.commons.math.optimization;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class RealPointValuePair implements Serializable {
    private static final long serialVersionUID = 1003888396256744753L;
    private final double[] point;
    private final double value;

    public RealPointValuePair(double[] point, double value) {
        if (point != null) goto L5;
        double[] r0 = null;
    L6:
        this.point = r0;
        this.value = value;
        return;
    L5:
        r0 = (double[]) point.clone();
        goto L6
    }

    public RealPointValuePair(double[] point, double value, boolean copyArray) {
        if (copyArray == false) goto L7;
        if (point != null) goto L6;
        double[] r0 = null;
    L8:
        this.point = r0;
        this.value = value;
        return;
    L6:
        r0 = (double[]) point.clone();
        goto L8
    L7:
        r0 = point;
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

    public double getValue() {
        return this.value;
    }
}
