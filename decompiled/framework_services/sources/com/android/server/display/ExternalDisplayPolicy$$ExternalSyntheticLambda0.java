package com.android.server.display;

import com.android.server.display.notifications.DisplayNotificationManager;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ExternalDisplayPolicy$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DisplayNotificationManager f$0;

    public /* synthetic */ ExternalDisplayPolicy$$ExternalSyntheticLambda0(DisplayNotificationManager r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.onHighTemperatureExternalDisplayNotAllowed();
    }
}
