package com.android.server.location.settings;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsStore$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ CountDownLatch f$0;

    public /* synthetic */ SettingsStore$$ExternalSyntheticLambda0(CountDownLatch r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.countDown();
    }
}
