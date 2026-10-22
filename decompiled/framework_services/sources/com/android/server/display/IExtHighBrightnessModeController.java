package com.android.server.display;

import android.os.IBinder;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtHighBrightnessModeController extends IExtBase {
    boolean isHdrLayerPresentExit(boolean r1);

    void onBrightnessChanged(float r1, float r2, int r3);

    void onHdrInfoChanged(IBinder r1, int r2, int r3, int r4, int r5, float r6);

    void recalculateTimeAllowance(boolean r1, boolean r2, long r3, long r5, long r7);

    void setAutoBrightnessEnabled(int r1);

    void setHdrLayerPresentExit(boolean r1);

    void updateLowPower(boolean r1);
}
