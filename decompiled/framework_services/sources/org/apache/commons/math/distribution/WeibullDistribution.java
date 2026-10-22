package org.apache.commons.math.distribution;

/* JADX INFO: loaded from: classes3.dex */
public interface WeibullDistribution extends ContinuousDistribution {
    double getScale();

    double getShape();

    @Deprecated
    void setScale(double r1);

    @Deprecated
    void setShape(double r1);
}
