package com.android.server.pm;

import android.os.Bundle;
import android.os.Handler;
import android.os.IRemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.ServiceThread;

/* JADX INFO: loaded from: classes2.dex */
public class BackgroundInstallControlCallbackHelper {
    public static final String FLAGGED_PACKAGE_NAME_KEY = "packageName";
    public static final String FLAGGED_USER_ID_KEY = "userId";
    public static final String INSTALL_EVENT_TYPE_KEY = "installEventType";
    private static final String TAG = "BackgroundInstallControlCallbackHelper";
    final RemoteCallbackList<IRemoteCallback> mCallbacks;
    private final Handler mHandler;

    public static /* synthetic */ void $r8$lambda$2RsD_8w_2UMgtKnaOhCpBzwehLs(Bundle r0, IRemoteCallback r1) {
        lambda$notifyAllCallbacks$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$3In9YulTRXM_uChLghN9D4UoYw4(BackgroundInstallControlCallbackHelper r0, Bundle r1) {
        r0.lambda$notifyAllCallbacks$1(r1);
    }

    BackgroundInstallControlCallbackHelper() {
        this.mCallbacks = new RemoteCallbackList();
        ServiceThread r0 = new ServiceThread("BackgroundInstallControlCallbackHelperBg", 10, true);
        r0.start();
        this.mHandler = new Handler(r0.getLooper());
    }

    public void registerBackgroundInstallCallback(IRemoteCallback callback) {
        RemoteCallbackList<IRemoteCallback> r0 = this.mCallbacks;
        monitor-enter(r0);
        this.mCallbacks.register(callback, null);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterBackgroundInstallCallback(IRemoteCallback callback) {
        RemoteCallbackList<IRemoteCallback> r0 = this.mCallbacks;
        monitor-enter(r0);
        this.mCallbacks.unregister(callback);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyAllCallbacks(int userId, String packageName, int installEventType) {
        final Bundle extras = new Bundle();
        extras.putCharSequence("packageName", packageName);
        extras.putInt("userId", userId);
        extras.putInt(INSTALL_EVENT_TYPE_KEY, installEventType);
        RemoteCallbackList<IRemoteCallback> r1 = this.mCallbacks;
        monitor-enter(r1);
        this.mHandler.post(new BackgroundInstallControlCallbackHelper$$ExternalSyntheticLambda0(this, extras));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$notifyAllCallbacks$1(final Bundle extras) {
        this.mCallbacks.broadcast(new BackgroundInstallControlCallbackHelper$$ExternalSyntheticLambda1(extras));
    }

    private static /* synthetic */ void lambda$notifyAllCallbacks$0(Bundle extras, IRemoteCallback callback) {
        callback.sendResult(extras);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "error detected: " + e.getLocalizedMessage(), e);
    }
}
