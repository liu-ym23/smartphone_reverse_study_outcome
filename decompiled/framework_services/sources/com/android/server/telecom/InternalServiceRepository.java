package com.android.server.telecom;

import android.os.Binder;
import com.android.internal.telecom.IDeviceIdleControllerAdapter;
import com.android.internal.telecom.IInternalServiceRetriever;
import com.android.server.DeviceIdleInternal;

/* JADX INFO: loaded from: classes3.dex */
public class InternalServiceRepository extends IInternalServiceRetriever.Stub {
    private final DeviceIdleInternal mDeviceIdleController;
    private final IDeviceIdleControllerAdapter.Stub mDeviceIdleControllerAdapter;

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceIdleController, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceIdleInternal m8456$$Nest$fgetmDeviceIdleController(InternalServiceRepository r0) {
        return r0.mDeviceIdleController;
    }

    public InternalServiceRepository(DeviceIdleInternal deviceIdleController) {
        this.mDeviceIdleControllerAdapter = new AnonymousClass1(this);
        this.mDeviceIdleController = deviceIdleController;
    }

    public IDeviceIdleControllerAdapter getDeviceIdleController() {
        ensureSystemProcess();
        return this.mDeviceIdleControllerAdapter;
    }

    private void ensureSystemProcess() {
        if (Binder.getCallingUid() != 1000) goto L6;
        return;
    L6:
        throw new SecurityException("SYSTEM ONLY API.");
    }
}
