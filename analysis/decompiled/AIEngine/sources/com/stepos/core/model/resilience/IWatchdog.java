package com.stepos.core.model.resilience;

import lb.n;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IWatchdog {
    void cancel(String str);

    void cancelAll();

    void watch(String str, long j10, a<n> aVar);

    int watchingCount();
}
