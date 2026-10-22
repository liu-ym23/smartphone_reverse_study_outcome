package org.apache.commons.math.distribution;

/* JADX INFO: loaded from: classes3.dex */
public interface ZipfDistribution extends IntegerDistribution {
    double getExponent();

    int getNumberOfElements();

    @Deprecated
    void setExponent(double r1);

    @Deprecated
    void setNumberOfElements(int r1);
}
