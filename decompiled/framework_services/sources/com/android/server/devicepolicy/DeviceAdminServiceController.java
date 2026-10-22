package com.android.server.devicepolicy;

import android.app.admin.DeviceAdminService;
import android.app.admin.IDeviceAdminService;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.util.IndentingPrintWriter;
import android.util.SparseArray;
import com.android.internal.os.BackgroundThread;
import com.android.server.am.PersistentConnection;
import com.android.server.appbinding.AppBindingUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAdminServiceController {
    static final boolean DEBUG = false;
    static final String TAG = "DevicePolicyManager";
    private final SparseArray<Map<String, DevicePolicyServiceConnection>> mConnections;
    private final DevicePolicyConstants mConstants;
    final Context mContext;
    private final Handler mHandler;
    private final DevicePolicyManagerService.Injector mInjector;
    final Object mLock;

    private class DevicePolicyServiceConnection extends PersistentConnection<IDeviceAdminService> {
        @Override // com.android.server.am.PersistentConnection
        protected /* bridge */ /* synthetic */ IDeviceAdminService asInterface(IBinder r1) {
            return asInterface(r1);
        }

        public DevicePolicyServiceConnection(DeviceAdminServiceController r15, int userId, ComponentName componentName) {
            super(DeviceAdminServiceController.TAG, r15.mContext, DeviceAdminServiceController.m3326$$Nest$fgetmHandler(r15), userId, componentName, DeviceAdminServiceController.m3325$$Nest$fgetmConstants(r15).DAS_DIED_SERVICE_RECONNECT_BACKOFF_SEC, DeviceAdminServiceController.m3325$$Nest$fgetmConstants(r15).DAS_DIED_SERVICE_RECONNECT_BACKOFF_INCREASE, DeviceAdminServiceController.m3325$$Nest$fgetmConstants(r15).DAS_DIED_SERVICE_RECONNECT_MAX_BACKOFF_SEC, DeviceAdminServiceController.m3325$$Nest$fgetmConstants(r15).DAS_DIED_SERVICE_STABLE_CONNECTION_THRESHOLD_SEC);
        }

        @Override // com.android.server.am.PersistentConnection
        protected int getBindFlags() {
            return 67108864;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.server.am.PersistentConnection
        protected IDeviceAdminService asInterface(IBinder binder) {
            return IDeviceAdminService.Stub.asInterface(binder);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConstants, reason: not valid java name */
    static /* bridge */ /* synthetic */ DevicePolicyConstants m3325$$Nest$fgetmConstants(DeviceAdminServiceController r0) {
        return r0.mConstants;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3326$$Nest$fgetmHandler(DeviceAdminServiceController r0) {
        return r0.mHandler;
    }

    public DeviceAdminServiceController(DevicePolicyManagerService service, DevicePolicyConstants constants) {
        this.mLock = new Object();
        this.mConnections = new SparseArray();
        this.mInjector = service.mInjector;
        this.mContext = this.mInjector.mContext;
        this.mHandler = new Handler(BackgroundThread.get().getLooper());
        this.mConstants = constants;
    }

    private ServiceInfo findService(String packageName, int userId) {
        return AppBindingUtils.findService(packageName, userId, "android.app.action.DEVICE_ADMIN_SERVICE", "android.permission.BIND_DEVICE_ADMIN", DeviceAdminService.class, this.mInjector.getIPackageManager(), new StringBuilder());
    }

    public void startServiceForAdmin(String packageName, int userId, String actionForLog) {
        long token = this.mInjector.binderClearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L28
        monitor-enter(r2);     // Catch: Throwable -> L28
        ServiceInfo service = findService(packageName, userId);     // Catch: Throwable -> L11
        if (service != null) goto L14;
        disconnectServiceOnUserLocked(packageName, userId, actionForLog);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        this.mInjector.binderRestoreCallingIdentity(token);
        return;
    L14:
        if (this.mConnections.contains(userId) == false) goto L16;
        PersistentConnection<IDeviceAdminService> existing = this.mConnections.get(userId).get(packageName);     // Catch: Throwable -> L11
    L17:
        if (existing == null) goto L19;
        disconnectServiceOnUserLocked(packageName, userId, actionForLog);     // Catch: Throwable -> L11
    L19:
        DevicePolicyServiceConnection conn = new DevicePolicyServiceConnection(this, userId, service.getComponentName());     // Catch: Throwable -> L11
        if (this.mConnections.contains(userId) == true) goto L22;
        this.mConnections.put(userId, new HashMap());     // Catch: Throwable -> L11
    L22:
        this.mConnections.get(userId).put(packageName, conn);     // Catch: Throwable -> L11
        conn.bind();     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        this.mInjector.binderRestoreCallingIdentity(token);
        return;
    L16:
        existing = null;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        this.mInjector.binderRestoreCallingIdentity(token);
        throw th;
    }

    public void stopServiceForAdmin(String packageName, int userId, String actionForLog) {
        long token = this.mInjector.binderClearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        disconnectServiceOnUserLocked(packageName, userId, actionForLog);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        this.mInjector.binderRestoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mInjector.binderRestoreCallingIdentity(token);
        throw th;
    }

    public void stopServicesForUser(int userId, String actionForLog) {
        long token = this.mInjector.binderClearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        disconnectServiceOnUserLocked(userId, actionForLog);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        this.mInjector.binderRestoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mInjector.binderRestoreCallingIdentity(token);
        throw th;
    }

    private void disconnectServiceOnUserLocked(String packageName, int userId, String actionForLog) {
        if (this.mConnections.contains(userId) == false) goto L5;
        DevicePolicyServiceConnection conn = this.mConnections.get(userId).get(packageName);
    L6:
        if (conn == null) goto L11;
        conn.unbind();
        this.mConnections.get(userId).remove(packageName);
        if (this.mConnections.get(userId).isEmpty() == false) goto L12;
        this.mConnections.remove(userId);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        conn = null;
        goto L6
    }

    private void disconnectServiceOnUserLocked(int userId, String actionForLog) {
        if (this.mConnections.contains(userId) == true) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.mConnections.get(userId).keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        String packageName = r0.next();
        DevicePolicyServiceConnection conn = this.mConnections.get(userId).get(packageName);
        conn.unbind();
        goto L7
    L9:
        this.mConnections.remove(userId);
    }

    public void dump(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnections.size() != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        pw.println("Admin Services:");     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        int i = 0;
    L12:
        if (i >= this.mConnections.size()) goto L18;
        int userId = this.mConnections.keyAt(i);     // Catch: Throwable -> L8
        pw.print("User: ");     // Catch: Throwable -> L8
        pw.println(userId);     // Catch: Throwable -> L8
        Iterator<String> r3 = this.mConnections.get(userId).keySet().iterator();     // Catch: Throwable -> L8
    L15:
        if (r3.hasNext() == false) goto L17;
        String packageName = r3.next();     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        pw.print("Package: ");     // Catch: Throwable -> L8
        pw.println(packageName);     // Catch: Throwable -> L8
        DevicePolicyServiceConnection con = this.mConnections.valueAt(i).get(packageName);     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        con.dump("", pw);     // Catch: Throwable -> L8
        pw.decreaseIndent();     // Catch: Throwable -> L8
        pw.decreaseIndent();     // Catch: Throwable -> L8
        goto L15
    L17:
        i = i + 1;     // Catch: Throwable -> L8
        goto L12
    L18:
        pw.decreaseIndent();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }
}
