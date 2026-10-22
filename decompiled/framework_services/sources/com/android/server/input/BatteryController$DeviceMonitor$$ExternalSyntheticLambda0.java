package com.android.server.input;

import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class BatteryController$DeviceMonitor$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ BatteryController.DeviceMonitor f$0;

    public /* synthetic */ BatteryController$DeviceMonitor$$ExternalSyntheticLambda0(BatteryController.DeviceMonitor r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r4) {
        this.f$0.updateBatteryStateFromNative(((Long) r4).longValue());
    }
}
