package com.android.server.usb;

import android.os.PowerManagerInternal;
import android.util.Log;
import com.android.server.LocalServices;
import java.time.Instant;

/* JADX INFO: loaded from: classes3.dex */
public class PowerBoostSetter {
    private static final int POWER_BOOST_TIMEOUT_MS = 15000;
    private static final String TAG = "PowerBoostSetter";
    PowerManagerInternal mPowerManagerInternal;
    Instant mPreviousTimeout;

    PowerBoostSetter() {
        this.mPowerManagerInternal = null;
        this.mPreviousTimeout = null;
        this.mPowerManagerInternal = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
    }

    public void boostPower() {
        if (this.mPowerManagerInternal != null) goto L6;
        this.mPowerManagerInternal = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
    L6:
        if (this.mPowerManagerInternal != null) goto L9;
        Log.w(TAG, "PowerManagerInternal null");
        return;
    L9:
        if (this.mPreviousTimeout != null) goto L11;
    L12:
        this.mPreviousTimeout = Instant.now();
        this.mPowerManagerInternal.setPowerBoost(0, 15000);
        return;
    L11:
        if (Instant.now().isAfter(this.mPreviousTimeout.plusMillis(7500)) == true) goto L12;
    }
}
