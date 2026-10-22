package com.android.server.accessibility;

import android.R;
import android.content.res.Resources;
import android.hardware.fingerprint.IFingerprintClientActiveCallback;
import android.hardware.fingerprint.IFingerprintService;
import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Slog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintGestureDispatcher extends IFingerprintClientActiveCallback.Stub implements Handler.Callback {
    private static final String LOG_TAG = "FingerprintGestureDispatcher";
    private static final int MSG_REGISTER = 1;
    private static final int MSG_UNREGISTER = 2;
    private final List<FingerprintGestureClient> mCapturingClients;
    private final IFingerprintService mFingerprintService;
    private final Handler mHandler;
    private final boolean mHardwareSupportsGestures;
    private final Object mLock;
    private boolean mRegisteredReadOnlyExceptInHandler;

    public interface FingerprintGestureClient {
        boolean isCapturingFingerprintGestures();

        void onFingerprintGesture(int r1);

        void onFingerprintGestureDetectionActiveChanged(boolean r1);
    }

    public FingerprintGestureDispatcher(IFingerprintService fingerprintService, Resources resources, Object lock) {
        this.mCapturingClients = new ArrayList(0);
        this.mFingerprintService = fingerprintService;
        this.mHardwareSupportsGestures = resources.getBoolean(R.bool.config_forceSystemPackagesQueryable);
        this.mLock = lock;
        this.mHandler = new Handler(this);
    }

    public FingerprintGestureDispatcher(IFingerprintService fingerprintService, Resources resources, Object lock, Handler handler) {
        this.mCapturingClients = new ArrayList(0);
        this.mFingerprintService = fingerprintService;
        this.mHardwareSupportsGestures = resources.getBoolean(R.bool.config_forceSystemPackagesQueryable);
        this.mLock = lock;
        this.mHandler = handler;
    }

    public void updateClientList(List<? extends FingerprintGestureClient> clientList) {
        if (this.mHardwareSupportsGestures == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCapturingClients.clear();     // Catch: Throwable -> L13
        int i = 0;
    L9:
        if (i >= clientList.size()) goto L17;
        FingerprintGestureClient client = clientList.get(i);     // Catch: Throwable -> L13
        if (client.isCapturingFingerprintGestures() == false) goto L15;
        this.mCapturingClients.add(client);     // Catch: Throwable -> L13
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L9
    L17:
        if (this.mCapturingClients.isEmpty() == false) goto L22;
        if (this.mRegisteredReadOnlyExceptInHandler == false) goto L24;
        this.mHandler.obtainMessage(2).sendToTarget();     // Catch: Throwable -> L13
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L22:
        if (this.mRegisteredReadOnlyExceptInHandler == true) goto L24;
        this.mHandler.obtainMessage(1).sendToTarget();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void onClientActiveChanged(boolean nonGestureFingerprintClientActive) {
        if (this.mHardwareSupportsGestures == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L22:
    L15:
        th = move-exception;
        throw th;
    L9:
        if (i >= this.mCapturingClients.size()) goto L18;
        FingerprintGestureClient r2 = this.mCapturingClients.get(i);     // Catch: Throwable -> L15
        if (nonGestureFingerprintClientActive == true) goto L13;
        boolean r3 = true;
    L14:
        r2.onFingerprintGestureDetectionActiveChanged(r3);     // Catch: Throwable -> L15
        i = i + 1;     // Catch: Throwable -> L15
        goto L22
    L13:
        r3 = false;
        goto L14
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    public boolean isFingerprintGestureDetectionAvailable() {
        if (this.mHardwareSupportsGestures == true) goto L5;
        return false;
    L5:
        long identity = Binder.clearCallingIdentity();
        boolean r0 = !this.mFingerprintService.isClientActive();
        Binder.restoreCallingIdentity(identity);
        return r0;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L15:
        Binder.restoreCallingIdentity(identity);
        return false;
    }

    public boolean onFingerprintGesture(int fingerprintKeyCode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCapturingClients.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        switch(fingerprintKeyCode) {
            case 280: goto L16;
            case 281: goto L15;
            case 282: goto L14;
            case 283: goto L13;
            default: goto L11;
        };     // Catch: Throwable -> L8
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L13:
        int idForFingerprintGestureManager = 1;
    L17:
        List<FingerprintGestureClient> clientList = new ArrayList(this.mCapturingClients);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        int i = 0;
    L21:
        if (i >= clientList.size()) goto L23;
        clientList.get(i).onFingerprintGesture(idForFingerprintGestureManager);
        i = i + 1;
        goto L21
    L23:
        return true;
    L14:
        idForFingerprintGestureManager = 2;
        goto L17
    L15:
        idForFingerprintGestureManager = 8;
        goto L17
    L16:
        idForFingerprintGestureManager = 4;
        goto L17
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) goto L16;
        long identity = Binder.clearCallingIdentity();
        this.mFingerprintService.addClientActiveCallback(this);     // Catch: Throwable -> L7 RemoteException -> L9
        this.mRegisteredReadOnlyExceptInHandler = true;     // Catch: Throwable -> L7 RemoteException -> L9
    L6:
        Binder.restoreCallingIdentity(identity);
        return false;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L10:
        Slog.e(LOG_TAG, "Failed to register for fingerprint activity callbacks");     // Catch: Throwable -> L7
        goto L6
    L16:
        if (message.what != 2) goto L29;
        long identity2 = Binder.clearCallingIdentity();
        this.mFingerprintService.removeClientActiveCallback(this);     // Catch: Throwable -> L20 RemoteException -> L22
    L19:
        Binder.restoreCallingIdentity(identity2);
        this.mRegisteredReadOnlyExceptInHandler = false;
        return true;
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(identity2);
        throw th;
    L23:
        Slog.e(LOG_TAG, "Failed to unregister for fingerprint activity callbacks");     // Catch: Throwable -> L20
        goto L19
    L29:
        Slog.e(LOG_TAG, "Unknown message: " + message.what);
        return false;
    }
}
