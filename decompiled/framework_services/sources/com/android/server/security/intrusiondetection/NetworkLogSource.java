package com.android.server.security.intrusiondetection;

import android.content.pm.PackageManagerInternal;
import android.net.IIpConnectivityMetrics;
import android.net.INetdEventCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import com.android.server.LocalServices;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkLogSource implements DataSource {
    private static final String TAG = "IntrusionDetectionEvent NetworkLogSource";
    private DataAggregator mDataAggregator;
    private long mId;
    private IIpConnectivityMetrics mIpConnectivityMetrics;
    private final AtomicBoolean mIsNetworkLoggingEnabled;
    private final INetdEventCallback mNetdEventCallback;
    private final PackageManagerInternal mPm;

    /* JADX INFO: renamed from: -$$Nest$fgetmDataAggregator, reason: not valid java name */
    static /* bridge */ /* synthetic */ DataAggregator m8054$$Nest$fgetmDataAggregator(NetworkLogSource r0) {
        return r0.mDataAggregator;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmId, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m8055$$Nest$fgetmId(NetworkLogSource r2) {
        return r2.mId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsNetworkLoggingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m8056$$Nest$fgetmIsNetworkLoggingEnabled(NetworkLogSource r0) {
        return r0.mIsNetworkLoggingEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPm, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m8057$$Nest$fgetmPm(NetworkLogSource r0) {
        return r0.mPm;
    }

    /* JADX INFO: renamed from: -$$Nest$mincrementEventID, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8058$$Nest$mincrementEventID(NetworkLogSource r0) {
        r0.incrementEventID();
    }

    public NetworkLogSource(DataAggregator dataAggregator) throws SecurityException {
        this.mIsNetworkLoggingEnabled = new AtomicBoolean(false);
        this.mNetdEventCallback = new AnonymousClass1(this);
        this.mDataAggregator = dataAggregator;
        this.mPm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mId = 0;
        initIpConnectivityMetrics();
    }

    private void initIpConnectivityMetrics() {
        this.mIpConnectivityMetrics = IIpConnectivityMetrics.Stub.asInterface(ServiceManager.getService("connmetrics"));
    }

    @Override // com.android.server.security.intrusiondetection.DataSource
    public void enable() {
        if (this.mIsNetworkLoggingEnabled.get() == false) goto L16;
        Slog.w(TAG, "Network logging is already enabled");
        return;
    L16:
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to enable network logging; ", e);
        return;
    L7:
        if (this.mIpConnectivityMetrics.addNetdEventCallback(1, this.mNetdEventCallback) == false) goto L11;
        this.mIsNetworkLoggingEnabled.set(true);     // Catch: RemoteException -> L9
    L15:
        return;
    L11:
        Slog.e(TAG, "Failed to enable network logging; invalid callback");     // Catch: RemoteException -> L9
        goto L15
    }

    @Override // com.android.server.security.intrusiondetection.DataSource
    public void disable() {
        if (this.mIsNetworkLoggingEnabled.get() == true) goto L16;
        Slog.w(TAG, "Network logging is already disabled");
        return;
    L16:
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to disable network logging; ", e);
        return;
    L7:
        if (this.mIpConnectivityMetrics.removeNetdEventCallback(1) == true) goto L11;
        this.mIsNetworkLoggingEnabled.set(false);     // Catch: RemoteException -> L9
    L15:
        return;
    L11:
        Slog.e(TAG, "Failed to disable network logging; invalid callback");     // Catch: RemoteException -> L9
        goto L15
    }

    private void incrementEventID() {
        if (this.mId != Long.MAX_VALUE) goto L5;
        Slog.i(TAG, "Reached maximum id value; wrapping around.");
        this.mId = 0;
        return;
    L5:
        this.mId++;
    }
}
