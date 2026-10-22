package com.android.server.location.provider;

import android.location.provider.ProviderRequest;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
interface LocationProviderController {
    void flush(Runnable r1);

    boolean isStarted();

    void sendExtraCommand(int r1, int r2, String r3, Bundle r4);

    AbstractLocationProvider.State setListener(AbstractLocationProvider.Listener r1);

    void setRequest(ProviderRequest r1);

    void start();

    void stop();
}
