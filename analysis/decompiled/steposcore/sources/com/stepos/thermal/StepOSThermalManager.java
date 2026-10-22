package com.stepos.thermal;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import vendor.stepos.hardware.thermal.IThermalCallback;
import vendor.stepos.hardware.thermal.IThermalService;
import vendor.stepos.hardware.thermal.ThermalSample;

/* loaded from: classes.dex */
public final class StepOSThermalManager {
    private static final String SERVICE_NAME = "vendor.stepos.hardware.thermal.IThermalService/default";
    private static final String TAG = "StepOSThermalManager";
    public static final String ZONE_SHELL_BACK = "shell_temp_back";
    public static final String ZONE_SHELL_FRAME = "shell_temp_frame";
    public static final String ZONE_SHELL_FRONT = "shell_temp_front";
    private final Map<OnThermalChangedListener, IThermalCallback> mListenerStubs;
    private IThermalService mService;
    private final Object mServiceLock;

    public interface OnThermalChangedListener {
        void onThermalChanged(String str, int i);
    }

    private static final class Holder {
        private static final StepOSThermalManager INSTANCE = new StepOSThermalManager();

        private Holder() {
        }
    }

    public static StepOSThermalManager get() {
        return Holder.INSTANCE;
    }

    private StepOSThermalManager() {
        this.mServiceLock = new Object();
        this.mListenerStubs = new HashMap();
    }

    public int getTemperature(String zoneName) {
        IThermalService svc = ensureService();
        if (svc == null || zoneName == null) {
            return -1;
        }
        try {
            return svc.getTemperature(zoneName);
        } catch (RemoteException e) {
            Log.w(TAG, "getTemperature(" + zoneName + ") binder error", e);
            invalidateService();
            return -1;
        }
    }

    public int getMaxTemperature() {
        IThermalService svc = ensureService();
        if (svc == null) {
            return -1;
        }
        try {
            return svc.getMaxTemperature();
        } catch (RemoteException e) {
            Log.w(TAG, "getMaxTemperature binder error", e);
            invalidateService();
            return -1;
        }
    }

    public Map<String, Integer> getAllTemperatures() {
        ThermalSample[] arr;
        Map<String, Integer> result = new LinkedHashMap<>();
        IThermalService svc = ensureService();
        if (svc == null) {
            return result;
        }
        try {
            arr = svc.getAllTemperatures();
        } catch (RemoteException e) {
            Log.w(TAG, "getAllTemperatures binder error", e);
            invalidateService();
        }
        if (arr == null) {
            return result;
        }
        for (ThermalSample s : arr) {
            if (s != null && s.zoneName != null) {
                result.put(s.zoneName, Integer.valueOf(s.temperatureMilliC));
            }
        }
        return result;
    }

    public boolean registerListener(final OnThermalChangedListener listener) {
        IThermalService svc;
        if (listener == null || (svc = ensureService()) == null) {
            return false;
        }
        synchronized (this.mListenerStubs) {
            if (this.mListenerStubs.containsKey(listener)) {
                Log.w(TAG, "registerListener: already registered, ignore");
                return false;
            }
            IThermalCallback.Stub stub = new IThermalCallback.Stub(this) { // from class: com.stepos.thermal.StepOSThermalManager.1
                @Override // vendor.stepos.hardware.thermal.IThermalCallback
                public void onThermalChanged(ThermalSample sample) {
                    if (sample == null) {
                        return;
                    }
                    try {
                        listener.onThermalChanged(sample.zoneName, sample.temperatureMilliC);
                    } catch (Throwable t) {
                        Log.e(StepOSThermalManager.TAG, "listener.onThermalChanged threw", t);
                    }
                }

                @Override // vendor.stepos.hardware.thermal.IThermalCallback
                public int getInterfaceVersion() {
                    return 1;
                }

                @Override // vendor.stepos.hardware.thermal.IThermalCallback
                public String getInterfaceHash() {
                    return "0c400c5f92d740b539cc820939fb9bb6fd9477e6";
                }
            };
            stub.markVintfStability();
            try {
                svc.registerCallback(stub);
                this.mListenerStubs.put(listener, stub);
                return true;
            } catch (RemoteException e) {
                Log.w(TAG, "registerCallback binder error", e);
                invalidateService();
                return false;
            }
        }
    }

    public boolean unregisterListener(OnThermalChangedListener listener) {
        IThermalCallback stub;
        if (listener == null) {
            return false;
        }
        synchronized (this.mListenerStubs) {
            stub = this.mListenerStubs.remove(listener);
        }
        if (stub == null) {
            return false;
        }
        IThermalService svc = ensureService();
        if (svc == null) {
            return true;
        }
        try {
            svc.unregisterCallback(stub);
            return true;
        } catch (RemoteException e) {
            Log.w(TAG, "unregisterCallback binder error", e);
            invalidateService();
            return false;
        }
    }

    private IThermalService ensureService() {
        IThermalService svc = this.mService;
        if (svc != null) {
            return svc;
        }
        synchronized (this.mServiceLock) {
            if (this.mService != null) {
                return this.mService;
            }
            try {
                IBinder binder = ServiceManager.waitForService(SERVICE_NAME);
                if (binder == null) {
                    Log.w(TAG, "thermal HAL not available");
                    return null;
                }
                this.mService = IThermalService.Stub.asInterface(binder);
                return this.mService;
            } catch (Throwable t) {
                Log.e(TAG, "ensureService failed", t);
                return null;
            }
        }
    }

    private void invalidateService() {
        synchronized (this.mServiceLock) {
            this.mService = null;
        }
    }
}
