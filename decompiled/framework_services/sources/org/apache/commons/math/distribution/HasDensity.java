package org.apache.commons.math.distribution;

import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface HasDensity<P> {
    double density(P r1) throws MathException;
}
