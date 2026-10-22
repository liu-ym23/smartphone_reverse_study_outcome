package com.android.server.net.watchlist;

import android.content.Context;
import android.net.IIpConnectivityMetrics;
import android.net.INetdEventCallback;
import android.os.Binder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.provider.Settings;
import android.util.Slog;
import com.android.internal.net.INetworkWatchlistManager;
import com.android.internal.util.DumpUtils;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkWatchlistService extends INetworkWatchlistManager.Stub {
    static final boolean DEBUG = false;
    private static final int MAX_NUM_OF_WATCHLIST_DIGESTS = 10000;
    private static final String TAG = null;
    private final boolean WATCHLIST_HANDLERTHREAD_ENABLE;
    private final WatchlistConfig mConfig;
    private final Context mContext;
    private ServiceThread mHandlerThread;
    IIpConnectivityMetrics mIpConnectivityMetrics;
    private volatile boolean mIsLoggingEnabled;
    private final Object mLoggingSwitchLock;
    private final INetdEventCallback mNetdEventCallback;
    WatchlistLoggingHandler mNetworkWatchlistHandler;

    public static class Lifecycle extends SystemService {
        private NetworkWatchlistService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            if (Settings.Global.getInt(getContext().getContentResolver(), "network_watchlist_enabled", 1) != 0) goto L6;
            Slog.i(NetworkWatchlistService.m6036$$Nest$sfgetTAG(), "Network Watchlist service is disabled");
            return;
        L6:
            this.mService = new NetworkWatchlistService(getContext());
            publishBinderService("network_watchlist", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase == 550) goto L5;
            return;
        L5:
            if (Settings.Global.getInt(getContext().getContentResolver(), "network_watchlist_enabled", 1) != 0) goto L13;
            Slog.i(NetworkWatchlistService.m6036$$Nest$sfgetTAG(), "Network Watchlist service is disabled");
            return;
        L13:
            NetworkWatchlistService.m6034$$Nest$minit(this.mService);     // Catch: RemoteException -> L10
            NetworkWatchlistService.m6035$$Nest$minitIpConnectivityMetrics(this.mService);     // Catch: RemoteException -> L10
            this.mService.startWatchlistLogging();     // Catch: RemoteException -> L10
        L11:
            ReportWatchlistJobService.schedule(getContext());
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsLoggingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6033$$Nest$fgetmIsLoggingEnabled(NetworkWatchlistService r0) {
        return r0.mIsLoggingEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$minit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6034$$Nest$minit(NetworkWatchlistService r0) {
        r0.init();
    }

    /* JADX INFO: renamed from: -$$Nest$minitIpConnectivityMetrics, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6035$$Nest$minitIpConnectivityMetrics(NetworkWatchlistService r0) {
        r0.initIpConnectivityMetrics();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6036$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = NetworkWatchlistService.class.getSimpleName();
    }

    public NetworkWatchlistService(Context context) {
        this.mIsLoggingEnabled = false;
        this.mLoggingSwitchLock = new Object();
        this.WATCHLIST_HANDLERTHREAD_ENABLE = false;
        this.mNetdEventCallback = new AnonymousClass1(this);
        this.mContext = context;
        this.mConfig = WatchlistConfig.getInstance();
    }

    NetworkWatchlistService(Context context, ServiceThread handlerThread, WatchlistLoggingHandler handler, IIpConnectivityMetrics ipConnectivityMetrics) {
        this.mIsLoggingEnabled = false;
        this.mLoggingSwitchLock = new Object();
        this.WATCHLIST_HANDLERTHREAD_ENABLE = false;
        this.mNetdEventCallback = new AnonymousClass1(this);
        this.mContext = context;
        this.mConfig = WatchlistConfig.getInstance();
    }

    private void init() {
        this.mConfig.removeTestModeConfig();
    }

    private void initIpConnectivityMetrics() {
        this.mIpConnectivityMetrics = IIpConnectivityMetrics.Stub.asInterface(ServiceManager.getService("connmetrics"));
    }

    private boolean isCallerShell() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 2000) goto L7;
        if (callingUid == 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        if (isCallerShell() == true) goto L6;
        Slog.w(TAG, "Only shell is allowed to call network watchlist shell commands");
        return;
    L6:
        new NetworkWatchlistShellCommand(this, this.mContext).exec(this, in, out, err, args, callback, resultReceiver);
    }

    protected boolean startWatchlistLoggingImpl() throws RemoteException {
        Object r0 = this.mLoggingSwitchLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsLoggingEnabled == false) goto L27;
        Slog.w(TAG, "Watchlist logging is already running");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L27:
        if (this.mIpConnectivityMetrics.addNetdEventCallback(2, this.mNetdEventCallback) == false) goto L19;
        this.mIsLoggingEnabled = true;     // Catch: Throwable -> L9 RemoteException -> L17
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
        goto L23
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L23:
        return false;
    }

    public boolean startWatchlistLogging() throws RemoteException {
        enforceWatchlistLoggingPermission();
        return startWatchlistLoggingImpl();
    }

    protected boolean stopWatchlistLoggingImpl() {
        Object r0 = this.mLoggingSwitchLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsLoggingEnabled == true) goto L12;
        Slog.w(TAG, "Watchlist logging is not running");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L12:
        this.mIsLoggingEnabled = false;     // Catch: Throwable -> L10
        boolean r1 = this.mIpConnectivityMetrics.removeNetdEventCallback(2);     // Catch: Throwable -> L10 RemoteException -> L16
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L18:
        return false;
    }

    public boolean stopWatchlistLogging() throws RemoteException {
        enforceWatchlistLoggingPermission();
        return stopWatchlistLoggingImpl();
    }

    public byte[] getWatchlistConfigHash() {
        return this.mConfig.getWatchlistConfigHash();
    }

    private void enforceWatchlistLoggingPermission() {
        int uid = Binder.getCallingUid();
        if (uid != 1000) goto L6;
        return;
    L6:
        throw new SecurityException(String.format("Uid %d has no permission to change watchlist setting.", new Object[]{Integer.valueOf(uid)}));
    }

    public void reloadWatchlist() throws RemoteException {
        enforceWatchlistLoggingPermission();
        Slog.i(TAG, "Reloading watchlist");
        this.mConfig.reloadConfig();
    }

    public void reportWatchlistIfNecessary() {
        if (this.mNetworkWatchlistHandler == null) goto L6;
        this.mNetworkWatchlistHandler.reportWatchlistIfNecessary();
        return;
    }

    public boolean forceReportWatchlistForTest(long lastReportTime) {
        if (this.mConfig.isConfigSecure() == false) goto L7;
        return false;
    L7:
        if (this.mNetworkWatchlistHandler == null) goto L11;
        this.mNetworkWatchlistHandler.forceReportWatchlistForTest(lastReportTime);
        return true;
    L11:
        return true;
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        this.mConfig.dump(fd, pw, args);
    }
}
