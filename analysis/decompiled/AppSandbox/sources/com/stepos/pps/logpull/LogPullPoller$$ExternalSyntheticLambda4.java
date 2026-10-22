package com.stepos.pps.logpull;

import com.stepos.pps.logpull.LogPullManager;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class LogPullPoller$$ExternalSyntheticLambda4 implements LogPullManager.AuthQueueCleaner {
    public final /* synthetic */ LogPullPoller f$0;

    public /* synthetic */ LogPullPoller$$ExternalSyntheticLambda4(LogPullPoller logPullPoller) {
        this.f$0 = logPullPoller;
    }

    @Override // com.stepos.pps.logpull.LogPullManager.AuthQueueCleaner
    public final void purgeAuth(long j) {
        this.f$0.purgeAuthForConfig(j);
    }
}
