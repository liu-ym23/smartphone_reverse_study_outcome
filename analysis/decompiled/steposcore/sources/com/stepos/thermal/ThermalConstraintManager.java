package com.stepos.thermal;

import android.content.ContextExt;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.stepos.perfdecision.IStepOSPerfDecision;

/* loaded from: classes.dex */
public final class ThermalConstraintManager {
    private static final String TAG = "ThermalConstraintManager";
    private volatile IStepOSPerfDecision mService;

    private static final class Holder {
        private static final ThermalConstraintManager INSTANCE = new ThermalConstraintManager();

        private Holder() {
        }
    }

    public static ThermalConstraintManager get() {
        return Holder.INSTANCE;
    }

    private ThermalConstraintManager() {
    }

    private IStepOSPerfDecision getService() {
        IStepOSPerfDecision service = this.mService;
        if (service != null && service.asBinder().isBinderAlive()) {
            return service;
        }
        IBinder binder = ServiceManager.getService(ContextExt.STEPOS_PERF_DECISION_SERVICE);
        if (binder == null) {
            Log.w(TAG, "stepos_perfdecision service not available");
            this.mService = null;
            return null;
        }
        IStepOSPerfDecision service2 = IStepOSPerfDecision.Stub.asInterface(binder);
        this.mService = service2;
        return service2;
    }

    public int acquireThermalConstraint(String temp, Bundle params) {
        IStepOSPerfDecision service = getService();
        if (service == null) {
            return -1;
        }
        try {
            return service.acquireThermalConstraint(temp, params);
        } catch (RemoteException e) {
            Log.e(TAG, "acquireThermalConstraint", e);
            this.mService = null;
            return -1;
        }
    }

    public int releaseThermalConstraint() {
        IStepOSPerfDecision service = getService();
        if (service == null) {
            return -1;
        }
        try {
            return service.releaseThermalConstraint();
        } catch (RemoteException e) {
            Log.e(TAG, "releaseThermalConstraint", e);
            this.mService = null;
            return -1;
        }
    }
}
