package com.stepos.pps.logpull;

import java.util.function.Supplier;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class LogPullPoller$$ExternalSyntheticLambda1 implements Supplier {
    public final /* synthetic */ LogPullPoller f$0;

    public /* synthetic */ LogPullPoller$$ExternalSyntheticLambda1(LogPullPoller logPullPoller) {
        this.f$0 = logPullPoller;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f$0.getServerUrl();
    }
}
