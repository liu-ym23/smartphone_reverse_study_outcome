package com.android.server.power.stats;

import android.os.ConditionVariable;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class BatteryStatsImpl$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ ConditionVariable f$0;

    public /* synthetic */ BatteryStatsImpl$$ExternalSyntheticLambda8(ConditionVariable r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.open();
    }
}
