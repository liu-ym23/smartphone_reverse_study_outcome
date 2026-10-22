package com.stepos.pps.data.stats.utilities;

import java.util.Map;

/* loaded from: classes.dex */
public interface ICollector<T> {
    Map<String, T> getMetrics();

    boolean startCollecting();

    boolean stopCollecting();
}
