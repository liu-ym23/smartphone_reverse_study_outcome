package com.android.server.devicepolicy;

import android.app.admin.NetworkEvent;
import android.content.pm.PackageManagerInternal;
import android.net.IIpConnectivityMetrics;
import android.net.INetdEventCallback;
import android.os.RemoteException;
import android.util.Log;
import android.util.Slog;
import com.android.server.ServiceThread;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class NetworkLogger {
    private static final String TAG = null;
    private final DevicePolicyManagerService mDpm;
    private ServiceThread mHandlerThread;
    private IIpConnectivityMetrics mIpConnectivityMetrics;
    private final AtomicBoolean mIsLoggingEnabled;
    private final INetdEventCallback mNetdEventCallback;
    private NetworkLoggingHandler mNetworkLoggingHandler;
    private final PackageManagerInternal mPm;
    private final int mTargetUserId;

    /* JADX INFO: renamed from: -$$Nest$fgetmIsLoggingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m3502$$Nest$fgetmIsLoggingEnabled(NetworkLogger r0) {
        return r0.mIsLoggingEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkLoggingHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ NetworkLoggingHandler m3503$$Nest$fgetmNetworkLoggingHandler(NetworkLogger r0) {
        return r0.mNetworkLoggingHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPm, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m3504$$Nest$fgetmPm(NetworkLogger r0) {
        return r0.mPm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTargetUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3505$$Nest$fgetmTargetUserId(NetworkLogger r0) {
        return r0.mTargetUserId;
    }

    static {
        TAG = NetworkLogger.class.getSimpleName();
    }

    NetworkLogger(DevicePolicyManagerService dpm, PackageManagerInternal pm, int targetUserId) {
        this.mIsLoggingEnabled = new AtomicBoolean(false);
        this.mNetdEventCallback = new AnonymousClass1(this);
        this.mDpm = dpm;
        this.mPm = pm;
        this.mTargetUserId = targetUserId;
    }

    private boolean checkIpConnectivityMetricsService() {
        if (this.mIpConnectivityMetrics == null) goto L5;
        return true;
    L5:
        IIpConnectivityMetrics service = this.mDpm.mInjector.getIIpConnectivityMetrics();
        if (service != null) goto L9;
        return false;
    L9:
        this.mIpConnectivityMetrics = service;
        return true;
    }

    boolean startNetworkLogging() {
        Log.d(TAG, "Starting network logging.");
        if (checkIpConnectivityMetricsService() == true) goto L15;
        Slog.wtf(TAG, "Failed to register callback with IIpConnectivityMetrics.");
        return false;
    L15:
    L10:
        re = move-exception;
        Slog.wtf(TAG, "Failed to make remote calls to register the callback", re);
        return false;
    L7:
        if (this.mIpConnectivityMetrics.addNetdEventCallback(1, this.mNetdEventCallback) == false) goto L12;
        this.mHandlerThread = new ServiceThread(TAG, 10, false);     // Catch: RemoteException -> L10
        this.mHandlerThread.start();     // Catch: RemoteException -> L10
        this.mNetworkLoggingHandler = new NetworkLoggingHandler(this.mHandlerThread.getLooper(), this.mDpm, this.mTargetUserId);     // Catch: RemoteException -> L10
        this.mNetworkLoggingHandler.scheduleBatchFinalization();     // Catch: RemoteException -> L10
        this.mIsLoggingEnabled.set(true);     // Catch: RemoteException -> L10
        return true;
    L12:
        return false;
    }

    boolean stopNetworkLogging() {
        Log.d(TAG, "Stopping network logging");
        this.mIsLoggingEnabled.set(false);
        discardLogs();
    L10:
        th = move-exception;
        if (this.mHandlerThread == null) goto L28;
        this.mHandlerThread.quitSafely();
    L28:
        throw th;
    L12:
        re = move-exception;
        Slog.wtf(TAG, "Failed to make remote calls to unregister the callback", re);     // Catch: Throwable -> L10
        if (this.mHandlerThread == null) goto L24;
        this.mHandlerThread.quitSafely();
    L24:
        return true;
    L4:
        if (checkIpConnectivityMetricsService() == true) goto L14;
        Slog.wtf(TAG, "Failed to unregister callback with IIpConnectivityMetrics.");     // Catch: Throwable -> L10 RemoteException -> L12
        if (this.mHandlerThread == null) goto L9;
        this.mHandlerThread.quitSafely();
    L9:
        return true;
    L14:
        boolean r0 = this.mIpConnectivityMetrics.removeNetdEventCallback(1);     // Catch: Throwable -> L10 RemoteException -> L12
        if (this.mHandlerThread == null) goto L18;
        this.mHandlerThread.quitSafely();
    L18:
        return r0;
    }

    void pause() {
        if (this.mNetworkLoggingHandler == null) goto L6;
        this.mNetworkLoggingHandler.pause();
        return;
    }

    void resume() {
        if (this.mNetworkLoggingHandler == null) goto L6;
        this.mNetworkLoggingHandler.resume();
        return;
    }

    void discardLogs() {
        if (this.mNetworkLoggingHandler == null) goto L6;
        this.mNetworkLoggingHandler.discardLogs();
        return;
    }

    List<NetworkEvent> retrieveLogs(long batchToken) {
        return this.mNetworkLoggingHandler.retrieveFullLogBatch(batchToken);
    }

    long forceBatchFinalization() {
        return this.mNetworkLoggingHandler.forceBatchFinalization();
    }
}
