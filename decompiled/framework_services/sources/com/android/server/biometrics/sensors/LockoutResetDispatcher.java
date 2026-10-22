package com.android.server.biometrics.sensors;

import android.content.Context;
import android.hardware.biometrics.IBiometricServiceLockoutResetCallback;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.RemoteException;
import android.util.Slog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class LockoutResetDispatcher implements IBinder.DeathRecipient {
    private static final String TAG = "LockoutResetTracker";
    final ConcurrentLinkedQueue<ClientCallback> mClientCallbacks;
    private final Context mContext;

    private static class ClientCallback {
        private static final long WAKELOCK_TIMEOUT_MS = 2000;
        private final IBiometricServiceLockoutResetCallback mCallback;
        private final String mOpPackageName;
        private final PowerManager.WakeLock mWakeLock;

        /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBiometricServiceLockoutResetCallback m2628$$Nest$fgetmCallback(ClientCallback r0) {
            return r0.mCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOpPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m2629$$Nest$fgetmOpPackageName(ClientCallback r0) {
            return r0.mOpPackageName;
        }

        /* JADX INFO: renamed from: -$$Nest$mreleaseWakelock, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2630$$Nest$mreleaseWakelock(ClientCallback r0) {
            r0.releaseWakelock();
        }

        ClientCallback(Context context, IBiometricServiceLockoutResetCallback callback, String opPackageName) {
            PowerManager pm = (PowerManager) context.getSystemService(PowerManager.class);
            this.mOpPackageName = opPackageName;
            this.mCallback = callback;
            this.mWakeLock = pm.newWakeLock(1, "LockoutResetMonitor:SendLockoutReset");
        }

        void sendLockoutReset(int sensorId) {
            if (this.mCallback == null) goto L11;
            this.mWakeLock.acquire(2000);     // Catch: RemoteException -> L6
            this.mCallback.onLockoutReset(sensorId, new AnonymousClass1(this));     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            Slog.w(LockoutResetDispatcher.TAG, "Failed to invoke onLockoutReset: ", e);
            releaseWakelock();
            return;
        }

        private void releaseWakelock() {
            if (this.mWakeLock.isHeld() == false) goto L6;
            this.mWakeLock.release();
            return;
        }
    }

    public LockoutResetDispatcher(Context context) {
        this.mClientCallbacks = new ConcurrentLinkedQueue();
        this.mContext = context;
    }

    public void addCallback(IBiometricServiceLockoutResetCallback callback, String opPackageName) {
        if (callback != null) goto L6;
        Slog.w(TAG, "Callback from : " + opPackageName + " is null");
        return;
    L6:
        this.mClientCallbacks.add(new ClientCallback(this.mContext, callback, opPackageName));
        callback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to link to death", e);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied(IBinder who) {
        Slog.e(TAG, "Callback binder died: " + who);
        Iterator<ClientCallback> iterator = this.mClientCallbacks.iterator();
    L4:
        if (iterator.hasNext() == false) goto L9;
        ClientCallback callback = iterator.next();
        if (ClientCallback.m2628$$Nest$fgetmCallback(callback).asBinder().equals(who) == false) goto L4;
        Slog.e(TAG, "Removing dead callback for: " + ClientCallback.m2629$$Nest$fgetmOpPackageName(callback));
        ClientCallback.m2630$$Nest$mreleaseWakelock(callback);
        iterator.remove();
        goto L4
    }

    public void notifyLockoutResetCallbacks(int sensorId) {
        Iterator<ClientCallback> r0 = this.mClientCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ClientCallback callback = r0.next();
        callback.sendLockoutReset(sensorId);
        goto L4
    }
}
