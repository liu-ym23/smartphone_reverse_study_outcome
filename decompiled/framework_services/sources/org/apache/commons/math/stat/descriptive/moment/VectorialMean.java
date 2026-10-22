package org.apache.commons.math.stat.descriptive.moment;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math.DimensionMismatchException;

/* JADX INFO: loaded from: classes3.dex */
public class VectorialMean implements Serializable {
    private static final long serialVersionUID = 8223009086481006892L;
    private final Mean[] means;

    public VectorialMean(int dimension) {
        this.means = new Mean[dimension];
        int i = 0;
    L3:
        if (i >= dimension) goto L6;
        this.means[i] = new Mean();
        i = i + 1;
        goto L3
    }

    public void increment(double[] v) throws DimensionMismatchException {
        if (v.length != this.means.length) goto L11;
        int i = 0;
    L6:
        if (i >= v.length) goto L9;
        this.means[i].increment(v[i]);
        i = i + 1;
        goto L6
    L9:
        return;
    L11:
        throw new DimensionMismatchException(v.length, this.means.length);
    }

    public double[] getResult() {
        double[] result = new double[this.means.length];
        int i = 0;
    L4:
        if (i >= result.length) goto L7;
        result[i] = this.means[i].getResult();
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    public long getN() {
        if (this.means.length != 0) goto L6;
        return 0;
    L6:
        return this.means[0].getN();
    }

    public int hashCode() {
        int result = (1 * 31) + Arrays.hashCode(this.means);
        return result;
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof VectorialMean) == true) goto L8;
        return false;
    L8:
        VectorialMean other = (VectorialMean) obj;
        if (Arrays.equals(this.means, other.means) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
