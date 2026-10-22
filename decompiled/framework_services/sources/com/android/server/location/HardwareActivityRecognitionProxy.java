package com.android.server.location;

import android.R;
import android.content.Context;
import android.hardware.location.ActivityRecognitionHardware;
import android.hardware.location.IActivityRecognitionHardwareClient;
import android.hardware.location.IActivityRecognitionHardwareWatcher;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.android.server.servicewatcher.CurrentUserServiceSupplier;
import com.android.server.servicewatcher.ServiceWatcher;

/* JADX INFO: loaded from: classes2.dex */
public class HardwareActivityRecognitionProxy implements ServiceWatcher.ServiceListener<CurrentUserServiceSupplier.BoundServiceInfo> {
    private static final String SERVICE_ACTION = "com.android.location.service.ActivityRecognitionProvider";
    private static final String TAG = "ARProxy";
    private final ActivityRecognitionHardware mInstance;
    private final boolean mIsSupported;
    private final ServiceWatcher mServiceWatcher;

    public /* bridge */ /* synthetic */ void onBind(IBinder r1, ServiceWatcher.BoundServiceInfo r2) throws RemoteException {
        onBind(r1, (CurrentUserServiceSupplier.BoundServiceInfo) r2);
    }

    public static HardwareActivityRecognitionProxy createAndRegister(Context context) {
        HardwareActivityRecognitionProxy arProxy = new HardwareActivityRecognitionProxy(context);
        if (arProxy.register() == false) goto L5;
        return arProxy;
    L5:
        return null;
    }

    private HardwareActivityRecognitionProxy(Context context) {
        this.mIsSupported = ActivityRecognitionHardware.isSupported();
        if (this.mIsSupported == false) goto L5;
        this.mInstance = ActivityRecognitionHardware.getInstance(context);
    L6:
        this.mServiceWatcher = ServiceWatcher.create(context, "HardwareActivityRecognitionProxy", CurrentUserServiceSupplier.createFromConfig(context, SERVICE_ACTION, R.bool.config_enableBackSound, R.string.config_defaultContextualSearchEnabled), this);
        return;
    L5:
        this.mInstance = null;
        goto L6
    }

    private boolean register() {
        boolean resolves = this.mServiceWatcher.checkServiceResolves();
        if (resolves == false) goto L5;
        this.mServiceWatcher.register();
    L5:
        return resolves;
    }

    public void onBind(IBinder binder, CurrentUserServiceSupplier.BoundServiceInfo boundServiceInfo) throws RemoteException {
        String descriptor = binder.getInterfaceDescriptor();
        if (IActivityRecognitionHardwareWatcher.class.getCanonicalName().equals(descriptor) == false) goto L9;
        IActivityRecognitionHardwareWatcher watcher = IActivityRecognitionHardwareWatcher.Stub.asInterface(binder);
        if (this.mInstance == null) goto L15;
        watcher.onInstanceChanged(this.mInstance);
        return;
    L15:
        return;
    L9:
        if (IActivityRecognitionHardwareClient.class.getCanonicalName().equals(descriptor) == false) goto L11;
        IActivityRecognitionHardwareClient client = IActivityRecognitionHardwareClient.Stub.asInterface(binder);
        client.onAvailabilityChanged(this.mIsSupported, this.mInstance);
        return;
    L11:
        Log.e(TAG, "Unknown descriptor: " + descriptor);
    }

    public void onUnbind() {
    }
}
