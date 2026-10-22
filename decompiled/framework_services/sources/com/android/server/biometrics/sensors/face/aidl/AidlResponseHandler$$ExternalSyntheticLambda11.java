package com.android.server.biometrics.sensors.face.aidl;

import com.android.server.biometrics.sensors.LockoutConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AidlResponseHandler$$ExternalSyntheticLambda11 implements Consumer {
    public /* synthetic */ AidlResponseHandler$$ExternalSyntheticLambda11() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        ((LockoutConsumer) r1).onLockoutPermanent();
    }
}
