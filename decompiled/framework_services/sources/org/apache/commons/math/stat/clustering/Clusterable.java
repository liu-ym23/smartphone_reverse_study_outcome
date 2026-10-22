package org.apache.commons.math.stat.clustering;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface Clusterable<T> {
    T centroidOf(Collection<T> r1);

    double distanceFrom(T r1);
}
