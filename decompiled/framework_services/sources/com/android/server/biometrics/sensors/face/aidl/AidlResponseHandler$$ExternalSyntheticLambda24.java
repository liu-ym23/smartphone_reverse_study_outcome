package com.android.server.biometrics.sensors.face.aidl;

import com.android.server.biometrics.sensors.BiometricScheduler;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AidlResponseHandler$$ExternalSyntheticLambda24 implements Runnable {
    public final /* synthetic */ BiometricScheduler f$0;

    public /* synthetic */ AidlResponseHandler$$ExternalSyntheticLambda24(BiometricScheduler r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.onUserStopped();
    }
}
