package com.android.server.security.intrusiondetection;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.security.intrusiondetection.IIntrusionDetectionEventTransport;
import android.security.intrusiondetection.IntrusionDetectionEvent;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.infra.AndroidFuture;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class IntrusionDetectionEventTransportConnection implements ServiceConnection {
    private static final long FUTURE_TIMEOUT_MILLIS = 60000;
    private static final String PRODUCTION_BUILD = "user";
    private static final String PROPERTY_BUILD_TYPE = "ro.build.type";
    private static final String PROPERTY_INTRUSION_DETECTION_SERVICE_NAME = "debug.intrusiondetection_package_name";
    private static final String TAG = "IntrusionDetectionEventTransportConnection";
    private final Context mContext;
    private String mIntrusionDetectionEventTransportConfig;
    volatile IIntrusionDetectionEventTransport mService;

    public IntrusionDetectionEventTransportConnection(Context context) {
        this.mContext = context;
    }

    public boolean initialize() {
        Slog.d(TAG, "initialize");
        if (bindService() == true) goto L5;
        return false;
    L5:
        waitForConnection();
        AndroidFuture<Boolean> resultFuture = new AndroidFuture();
        this.mService.initialize(resultFuture);     // Catch: RemoteException -> L14
        Boolean result = (Boolean) getFutureResult(resultFuture);
        if (result != null) goto L10;
    L12:
        unbindService();
        return false;
    L10:
        if (result.booleanValue() != true) goto L12;
        return true;
    L14:
        e = move-exception;
        Slog.e(TAG, "Remote Exception", e);
        unbindService();
        return false;
    }

    private void waitForConnection() {
        monitor-enter(this);
    L17:
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mService != null) goto L12;
        Slog.d(TAG, "waiting for connection to service...");     // Catch: Throwable -> L8
        wait();     // Catch: Throwable -> L8 InterruptedException -> L10
        goto L17
    L12:
        Slog.d(TAG, "connected to service");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    public boolean addData(List<IntrusionDetectionEvent> data) {
        AndroidFuture<Boolean> resultFuture = new AndroidFuture();
        this.mService.addData(data, resultFuture);     // Catch: RemoteException -> L10
        Boolean result = (Boolean) getFutureResult(resultFuture);
        if (result != null) goto L7;
        return false;
    L7:
        if (result.booleanValue() == true) goto L9;
        return false;
    L9:
        return true;
    L10:
        e = move-exception;
        Slog.e(TAG, "Remote Exception", e);
        return false;
    }

    public void release() {
        AndroidFuture<Boolean> resultFuture = new AndroidFuture();
        this.mService.release(resultFuture);     // Catch: Throwable -> L5 RemoteException -> L7
    L4:
        unbindService();
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Remote Exception", e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        unbindService();
        throw th;
    }

    private <T> T getFutureResult(AndroidFuture<T> r4) {
        return (T) r4.get(60000, TimeUnit.MILLISECONDS);
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to get result from transport:", e);
        return null;
    }

    private String getSystemPropertyValue(String propertyName) {
        String commandString = "getprop " + propertyName;
        Process process = Runtime.getRuntime().exec(commandString);     // Catch: IOException -> L5
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));     // Catch: IOException -> L5
        String propertyValue = reader.readLine();     // Catch: IOException -> L5
        reader.close();     // Catch: IOException -> L5
        return propertyValue;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to get system property value:", e);
        return null;
    }

    private boolean bindService() {
        String buildType = getSystemPropertyValue(PROPERTY_BUILD_TYPE);
        this.mIntrusionDetectionEventTransportConfig = this.mContext.getString(R.string.config_satellite_demo_mode_sos_intent_action);
        if (buildType.equals(PRODUCTION_BUILD) == false) goto L5;
    L7:
        Slog.d(TAG, "mIntrusionDetectionEventTransportConfig: " + this.mIntrusionDetectionEventTransportConfig);
        if (TextUtils.isEmpty(this.mIntrusionDetectionEventTransportConfig) == false) goto L11;
        Slog.e(TAG, "Unable to find a valid config for the transport service");
        return false;
    L11:
        ComponentName serviceComponent = ComponentName.unflattenFromString(this.mIntrusionDetectionEventTransportConfig);
        if (serviceComponent != null) goto L27;
        Slog.e(TAG, "Can't get serviceComponent name");
        return false;
    L27:
        ServiceInfo serviceInfo = this.mContext.getPackageManager().getServiceInfo(serviceComponent, 0);     // Catch: PackageManager.NameNotFoundException -> L19
        if ("android.permission.BIND_INTRUSION_DETECTION_EVENT_TRANSPORT_SERVICE".equals(serviceInfo.permission) == true) goto L21;
        Slog.e(TAG, serviceComponent.flattenToShortString() + " is not declared with the permission \"android.permission.BIND_INTRUSION_DETECTION_EVENT_TRANSPORT_SERVICE\"");     // Catch: PackageManager.NameNotFoundException -> L19
        return false;
    L21:
        Intent intent = new Intent().setComponent(serviceComponent);
        boolean result = this.mContext.bindServiceAsUser(intent, this, 1, UserHandle.SYSTEM);
        if (result == true) goto L24;
        unbindService();
    L24:
        return result;
    L25:
        Slog.e(TAG, "Unable to find serviceComponent");
        return false;
    L5:
        if (TextUtils.isEmpty(getSystemPropertyValue(PROPERTY_INTRUSION_DETECTION_SERVICE_NAME)) == true) goto L7;
        this.mIntrusionDetectionEventTransportConfig = getSystemPropertyValue(PROPERTY_INTRUSION_DETECTION_SERVICE_NAME);
        goto L7
    }

    private void unbindService() {
        this.mContext.unbindService(this);
        this.mService = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        monitor-enter(this);
        this.mService = IIntrusionDetectionEventTransport.Stub.asInterface(service);     // Catch: Throwable -> L6
        Slog.d(TAG, "connected to service");     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        monitor-enter(this);
        this.mService = null;     // Catch: Throwable -> L7
        Slog.d(TAG, "disconnected from service");     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
