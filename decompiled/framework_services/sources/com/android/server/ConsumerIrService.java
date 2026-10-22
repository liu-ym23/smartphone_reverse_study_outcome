package com.android.server;

import android.content.Context;
import android.hardware.IConsumerIrService;
import android.hardware.ir.ConsumerIrFreqRange;
import android.hardware.ir.IConsumerIr;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import com.android.server.utils.LazyJniRegistrar;

/* JADX INFO: loaded from: classes.dex */
public class ConsumerIrService extends IConsumerIrService.Stub {
    private static final int MAX_XMIT_TIME = 2000000;
    private static final String TAG = "ConsumerIrService";
    private IConsumerIr mAidlService;
    private final Context mContext;
    private final Object mHalLock;
    private final boolean mHasNativeHal;
    private final PowerManager.WakeLock mWakeLock;

    private static native boolean getHidlHalService();

    private static native int[] halGetCarrierFrequencies();

    private static native int halTransmit(int r0, int[] r1);

    static {
        LazyJniRegistrar.registerConsumerIrService();
    }

    ConsumerIrService(Context context) {
        this.mHalLock = new Object();
        this.mAidlService = null;
        this.mContext = context;
        PowerManager pm = (PowerManager) context.getSystemService("power");
        this.mWakeLock = pm.newWakeLock(1, TAG);
        this.mWakeLock.setReferenceCounted(true);
        this.mHasNativeHal = getHalService();
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.consumerir") == false) goto L10;
        if (this.mHasNativeHal == false) goto L8;
        return;
    L8:
        throw new RuntimeException("FEATURE_CONSUMER_IR present, but no IR HAL loaded!");
    L10:
        if (this.mHasNativeHal == true) goto L13;
        return;
    L13:
        throw new RuntimeException("IR HAL present, but FEATURE_CONSUMER_IR is not set!");
    }

    public boolean hasIrEmitter() {
        return this.mHasNativeHal;
    }

    private boolean getHalService() {
        String fqName = IConsumerIr.DESCRIPTOR + "/default";
        this.mAidlService = IConsumerIr.Stub.asInterface(ServiceManager.waitForDeclaredService(fqName));
        if (this.mAidlService == null) goto L7;
        return true;
    L7:
        return getHidlHalService();
    }

    private void throwIfNoIrEmitter() {
        if (this.mHasNativeHal == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("IR emitter not available");
    }

    public void transmit(String packageName, int carrierFrequency, int[] pattern) {
        super.transmit_enforcePermission();
        long totalXmitTime = 0;
        int r2 = pattern.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        int slice = pattern[r3];
        if (slice <= 0) goto L8;
        totalXmitTime = totalXmitTime + ((long) slice);
        r3 = r3 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("Non-positive IR slice");
    L10:
        if (totalXmitTime > 2000000) goto L29;
        throwIfNoIrEmitter();
        Object r4 = this.mHalLock;
        monitor-enter(r4);
    L17:
        th = move-exception;
        throw th;
    L14:
        if (this.mAidlService != null) goto L32;
        int err = halTransmit(carrierFrequency, pattern);     // Catch: Throwable -> L17
        if (err >= 0) goto L24;
        Slog.e(TAG, "Error transmitting: " + err);     // Catch: Throwable -> L17
    L24:
        monitor-exit(r4);     // Catch: Throwable -> L17
        return;
    L32:
        this.mAidlService.transmit(carrierFrequency, pattern);     // Catch: Throwable -> L17 RemoteException -> L19
    L20:
        Slog.e(TAG, "Error transmitting frequency: " + carrierFrequency);     // Catch: Throwable -> L17
        goto L24
    L29:
        throw new IllegalArgumentException("IR pattern too long");
    }

    public int[] getCarrierFrequencies() {
        super.getCarrierFrequencies_enforcePermission();
        throwIfNoIrEmitter();
        Object r0 = this.mHalLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAidlService != null) goto L30;
        int[] r1 = halGetCarrierFrequencies();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L30:
        ConsumerIrFreqRange[] output = this.mAidlService.getCarrierFreqs();     // Catch: Throwable -> L9 RemoteException -> L11
        if (output.length > 0) goto L13;
        Slog.e(TAG, "Error getting carrier frequencies.");     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        int[] result = new int[output.length * 2];     // Catch: Throwable -> L9 RemoteException -> L11
        int i = 0;
    L14:
        if (i >= output.length) goto L19;
        result[i * 2] = output[i].minHz;     // Catch: Throwable -> L9 RemoteException -> L11
        result[(i * 2) + 1] = output[i].maxHz;     // Catch: Throwable -> L9 RemoteException -> L11
        i = i + 1;
        goto L14
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return result;
    L23:
        return null;
    }
}
