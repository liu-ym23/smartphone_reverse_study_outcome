package com.android.server.devicestate;

import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DeviceStateManagerService$$ExternalSyntheticLambda4 implements Consumer {
    public final /* synthetic */ OverrideRequestController f$0;

    public /* synthetic */ DeviceStateManagerService$$ExternalSyntheticLambda4(OverrideRequestController r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r2) {
        this.f$0.cancelRequest((OverrideRequest) r2);
    }
}
