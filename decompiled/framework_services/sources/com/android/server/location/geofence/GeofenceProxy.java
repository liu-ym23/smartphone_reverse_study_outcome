package com.android.server.location.geofence;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.location.GeofenceHardwareService;
import android.hardware.location.IGeofenceHardware;
import android.location.IGeofenceProvider;
import android.location.IGpsGeofenceHardware;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import com.android.server.servicewatcher.CurrentUserServiceSupplier;
import com.android.server.servicewatcher.ServiceWatcher;

/* JADX INFO: loaded from: classes2.dex */
public final class GeofenceProxy implements ServiceWatcher.ServiceListener<CurrentUserServiceSupplier.BoundServiceInfo> {
    private static final String SERVICE_ACTION = "com.android.location.service.GeofenceProvider";
    private static final String TAG = "GeofenceProxy";
    volatile IGeofenceHardware mGeofenceHardware;
    final IGpsGeofenceHardware mGpsGeofenceHardware;
    final ServiceWatcher mServiceWatcher;

    private class GeofenceProxyServiceConnection implements ServiceConnection {
        final /* synthetic */ GeofenceProxy this$0;

        GeofenceProxyServiceConnection(GeofenceProxy r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            IGeofenceHardware geofenceHardware = IGeofenceHardware.Stub.asInterface(service);
            geofenceHardware.setGpsGeofenceHardware(this.this$0.mGpsGeofenceHardware);     // Catch: RemoteException -> L5
            this.this$0.mGeofenceHardware = geofenceHardware;     // Catch: RemoteException -> L5
            this.this$0.mServiceWatcher.runOnBinder(new GeofenceProxy$GeofenceProxyServiceConnection$$ExternalSyntheticLambda0(this.this$0));     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Log.w(GeofenceProxy.TAG, "unable to initialize geofence hardware", e);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            this.this$0.mGeofenceHardware = null;
            this.this$0.mServiceWatcher.runOnBinder(new GeofenceProxy$GeofenceProxyServiceConnection$$ExternalSyntheticLambda0(this.this$0));
        }
    }

    public /* bridge */ /* synthetic */ void onBind(IBinder r1, ServiceWatcher.BoundServiceInfo r2) throws RemoteException {
        onBind(r1, (CurrentUserServiceSupplier.BoundServiceInfo) r2);
    }

    public static GeofenceProxy createAndBind(Context context, IGpsGeofenceHardware gpsGeofence) {
        GeofenceProxy proxy = new GeofenceProxy(context, gpsGeofence);
        if (proxy.register(context) == false) goto L5;
        return proxy;
    L5:
        return null;
    }

    private GeofenceProxy(Context context, IGpsGeofenceHardware gpsGeofence) {
        gpsGeofence.getClass();
        this.mGpsGeofenceHardware = gpsGeofence;
        this.mServiceWatcher = ServiceWatcher.create(context, TAG, CurrentUserServiceSupplier.createFromConfig(context, SERVICE_ACTION, R.bool.config_enableHapticTextHandle, R.string.config_populationDensityProviderPackageName), this);
        this.mGeofenceHardware = null;
    }

    void updateGeofenceHardware(IBinder binder) throws RemoteException {
        IGeofenceProvider.Stub.asInterface(binder).setGeofenceHardware(this.mGeofenceHardware);
    }

    private boolean register(Context context) {
        boolean resolves = this.mServiceWatcher.checkServiceResolves();
        if (resolves == false) goto L5;
        this.mServiceWatcher.register();
        context.bindServiceAsUser(new Intent(context, GeofenceHardwareService.class), new GeofenceProxyServiceConnection(this), 1, UserHandle.SYSTEM);
    L5:
        return resolves;
    }

    public void onBind(IBinder binder, CurrentUserServiceSupplier.BoundServiceInfo boundServiceInfo) throws RemoteException {
        updateGeofenceHardware(binder);
    }

    public void onUnbind() {
    }
}
