package com.android.server.timedetector;

import com.android.server.timezonedetector.StateChangeListener;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class TimeDetectorStrategyImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ StateChangeListener f$0;

    public /* synthetic */ TimeDetectorStrategyImpl$$ExternalSyntheticLambda0(StateChangeListener r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.onChange();
    }
}
