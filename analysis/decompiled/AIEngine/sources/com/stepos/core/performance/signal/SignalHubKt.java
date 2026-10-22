package com.stepos.core.performance.signal;

import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SignalHubKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final IPerformanceDataProvider tryLoadAicpuset() {
        Object objA;
        try {
            Object objNewInstance = Class.forName("com.stepos.cpuset.AicpusetDataProvider").getDeclaredConstructor(null).newInstance(null);
            g.d(objNewInstance, "null cannot be cast to non-null type com.stepos.core.performance.signal.IPerformanceDataProvider");
            objA = (IPerformanceDataProvider) objNewInstance;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        return (IPerformanceDataProvider) (objA instanceof Result.Failure ? null : objA);
    }
}
