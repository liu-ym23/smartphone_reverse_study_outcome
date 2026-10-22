package org.apache.commons.math.distribution;

/* JADX INFO: loaded from: classes3.dex */
public interface CauchyDistribution extends ContinuousDistribution {
    double getMedian();

    double getScale();

    @Deprecated
    void setMedian(double r1);

    @Deprecated
    void setScale(double r1);
}
