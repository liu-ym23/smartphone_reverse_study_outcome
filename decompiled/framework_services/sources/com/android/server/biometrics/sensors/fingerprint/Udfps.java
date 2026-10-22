package com.android.server.biometrics.sensors.fingerprint;

import android.hardware.biometrics.fingerprint.PointerContext;

/* JADX INFO: loaded from: classes.dex */
public interface Udfps {
    boolean isPointerDown();

    void onPointerDown(PointerContext r1);

    void onPointerUp(PointerContext r1);

    void onUdfpsUiEvent(int r1);

    void setIgnoreDisplayTouches(boolean r1);
}
