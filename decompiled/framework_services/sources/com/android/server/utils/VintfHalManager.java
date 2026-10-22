package com.android.server.utils;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import java.util.function.Function;
import vendor.bd.hardware.display.colormanager.IDisplayHal;
import vendor.bd.hardware.touchhal.ITouchHal;
import vendor.bytedance.hardware.health.IChargingCtrl;
import vendor.bytedance.thermalextservice.IThermalExtService;

/* JADX INFO: loaded from: classes3.dex */
public class VintfHalManager {
    private static final VintfHalCache<IChargingCtrl> CHARGE_HAL = null;
    private static final VintfHalCache<IDisplayHal> DISPLAY_HAL = null;
    private static final String TAG = "VintfHalManager";
    private static final VintfHalCache<IThermalExtService> THERMAL_EXT_HAL = null;
    private static final VintfHalCache<ITouchHal> TOUCH_HAL = null;

    private static class VintfHalCache<T> implements IBinder.DeathRecipient {
        private final Function<IBinder, T> mBinderToInterface;
        private T mInstance;
        private final Object mLock;
        private final String mServiceName;

        VintfHalCache(String serviceName, Function<IBinder, T> binderToInterface) {
            this.mLock = new Object();
            this.mServiceName = serviceName;
            this.mBinderToInterface = binderToInterface;
        }

        T get() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mInstance != null) goto L18;
            IBinder binder = Binder.allowBlocking(ServiceManager.waitForDeclaredService(this.mServiceName));     // Catch: Throwable -> L11
            if (binder != null) goto L23;
            Slog.e(VintfHalManager.TAG, "Service not found: " + this.mServiceName);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return null;
        L23:
            binder.linkToDeath(this, 0);     // Catch: Throwable -> L11 RemoteException -> L16
            this.mInstance = this.mBinderToInterface.apply(binder);     // Catch: Throwable -> L11 RemoteException -> L16
            Slog.i(VintfHalManager.TAG, "Successfully connected to " + this.mServiceName);     // Catch: Throwable -> L11 RemoteException -> L16
        L16:
            e = move-exception;
            Slog.e(VintfHalManager.TAG, "Failed to linkToDeath for " + this.mServiceName, e);     // Catch: Throwable -> L11
            this.mInstance = null;     // Catch: Throwable -> L11
        L18:
            T r1 = this.mInstance;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.w(VintfHalManager.TAG, "Service died: " + this.mServiceName);
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mInstance = null;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public VintfHalManager() {
    }

    public static ITouchHal getTouchHal() {
        return TOUCH_HAL.get();
    }

    static {
        TOUCH_HAL = new VintfHalCache(ITouchHal.DESCRIPTOR + "/default", new VintfHalManager$$ExternalSyntheticLambda0());
        CHARGE_HAL = new VintfHalCache(IChargingCtrl.DESCRIPTOR + "/default", new VintfHalManager$$ExternalSyntheticLambda1());
        DISPLAY_HAL = new VintfHalCache(IDisplayHal.DESCRIPTOR + "/default", new VintfHalManager$$ExternalSyntheticLambda2());
        THERMAL_EXT_HAL = new VintfHalCache(IThermalExtService.DESCRIPTOR + "/default", new VintfHalManager$$ExternalSyntheticLambda3());
    }

    public static IChargingCtrl getChargeHal() {
        return CHARGE_HAL.get();
    }

    public static IDisplayHal getDisplayHal() {
        return DISPLAY_HAL.get();
    }

    public static IThermalExtService getThermalExtHal() {
        return THERMAL_EXT_HAL.get();
    }
}
