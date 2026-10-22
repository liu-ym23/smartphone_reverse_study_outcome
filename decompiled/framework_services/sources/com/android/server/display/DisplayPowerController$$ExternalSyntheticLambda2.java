package com.android.server.display;

import android.os.SystemClock;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DisplayPowerController$$ExternalSyntheticLambda2 implements ScreenOffBrightnessSensorController.Clock {
    public /* synthetic */ DisplayPowerController$$ExternalSyntheticLambda2() {
    }

    @Override // com.android.server.display.ScreenOffBrightnessSensorController.Clock
    public final long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }
}
