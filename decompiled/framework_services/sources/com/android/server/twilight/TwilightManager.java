package com.android.server.twilight;

import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
public interface TwilightManager {
    TwilightState getLastTwilightState();

    void registerListener(TwilightListener r1, Handler r2);

    void unregisterListener(TwilightListener r1);
}
