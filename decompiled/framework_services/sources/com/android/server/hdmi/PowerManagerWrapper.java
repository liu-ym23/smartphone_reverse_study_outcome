package com.android.server.hdmi;

import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes2.dex */
public class PowerManagerWrapper {
    private static final String TAG = "PowerManagerWrapper";
    private final PowerManager mPowerManager;

    public static class DefaultWakeLockWrapper implements WakeLockWrapper {
        private static final String TAG = "DefaultWakeLockWrapper";
        private final PowerManager.WakeLock mWakeLock;

        /* synthetic */ DefaultWakeLockWrapper(PowerManager.WakeLock r1, PowerManagerWrapperIA r2) {
            this(r1);
        }

        private DefaultWakeLockWrapper(PowerManager.WakeLock wakeLock) {
            this.mWakeLock = wakeLock;
        }

        @Override // com.android.server.hdmi.WakeLockWrapper
        public void acquire(long timeout) {
            this.mWakeLock.acquire(timeout);
        }

        @Override // com.android.server.hdmi.WakeLockWrapper
        public void acquire() {
            this.mWakeLock.acquire();
        }

        @Override // com.android.server.hdmi.WakeLockWrapper
        public void release() throws RuntimeException {
            this.mWakeLock.release();
        }

        @Override // com.android.server.hdmi.WakeLockWrapper
        public boolean isHeld() {
            return this.mWakeLock.isHeld();
        }

        @Override // com.android.server.hdmi.WakeLockWrapper
        public void setReferenceCounted(boolean value) {
            this.mWakeLock.setReferenceCounted(value);
        }
    }

    public PowerManagerWrapper(Context context) {
        this.mPowerManager = (PowerManager) context.getSystemService(PowerManager.class);
    }

    boolean isInteractive() {
        return this.mPowerManager.isInteractive();
    }

    void wakeUp(long time, int reason, String details) {
        this.mPowerManager.wakeUp(time, reason, details);
    }

    void goToSleep(long time, int reason, int flags) {
        this.mPowerManager.goToSleep(time, reason, flags);
    }

    WakeLockWrapper newWakeLock(int levelAndFlags, String tag) {
        return new DefaultWakeLockWrapper(this.mPowerManager.newWakeLock(levelAndFlags, tag), null);
    }

    boolean isLowPowerStandbyEnabled() {
        PowerManager.LowPowerStandbyPolicy lowPowerStandbyPolicy = this.mPowerManager.getLowPowerStandbyPolicy();
        return lowPowerStandbyPolicy.getIdentifier().equals("low_energy_use");
    }
}
