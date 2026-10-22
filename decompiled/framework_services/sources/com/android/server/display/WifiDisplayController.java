package com.android.server.display;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.hardware.display.WifiDisplay;
import android.hardware.display.WifiDisplaySessionInfo;
import android.media.RemoteDisplay;
import android.net.NetworkInfo;
import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pWfdInfo;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Slog;
import android.view.Surface;
import com.android.internal.util.DumpUtils;
import com.android.server.display.utils.DebugUtils;
import com.android.server.job.controllers.JobStatus;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class WifiDisplayController implements DumpUtils.Dump {
    private static final int CONNECTION_TIMEOUT_SECONDS = 30;
    private static final int CONNECT_MAX_RETRIES = 3;
    private static final int CONNECT_RETRY_DELAY_MILLIS = 500;
    private static final boolean DEBUG = false;
    private static final boolean DEBUGV = false;
    private static final int DEFAULT_CONTROL_PORT = 7236;
    private static final int DISCOVER_PEERS_INTERVAL_MILLIS = 10000;
    private static final int MAX_THROUGHPUT = 50;
    private static final int RTSP_TIMEOUT_SECONDS = 30;
    private static final int RTSP_TIMEOUT_SECONDS_CERT_MODE = 120;
    private static final String TAG = "WifiDisplayController";
    private WifiDisplay mAdvertisedDisplay;
    private int mAdvertisedDisplayFlags;
    private int mAdvertisedDisplayHeight;
    private Surface mAdvertisedDisplaySurface;
    private int mAdvertisedDisplayWidth;
    private final ArrayList<WifiP2pDevice> mAvailableWifiDisplayPeers;
    private WifiP2pDevice mCancelingDevice;
    private WifiP2pDevice mConnectedDevice;
    private WifiP2pGroup mConnectedDeviceGroupInfo;
    private WifiP2pDevice mConnectingDevice;
    private int mConnectionRetriesLeft;
    private final Runnable mConnectionTimeout;
    private final Context mContext;
    private WifiP2pDevice mDesiredDevice;
    private WifiP2pDevice mDisconnectingDevice;
    private final Runnable mDiscoverPeers;
    private boolean mDiscoverPeersInProgress;
    private Object mExtRemoteDisplay;
    private final Handler mHandler;
    private final Listener mListener;
    private NetworkInfo mNetworkInfo;
    private RemoteDisplay mRemoteDisplay;
    private boolean mRemoteDisplayConnected;
    private String mRemoteDisplayInterface;
    private final Runnable mRtspTimeout;
    private boolean mScanRequested;
    private WifiP2pDevice mThisDevice;
    private boolean mWfdEnabled;
    private boolean mWfdEnabling;
    private boolean mWifiDisplayCertMode;
    private boolean mWifiDisplayOnSetting;
    private int mWifiDisplayWpsConfig;
    private WifiP2pManager.Channel mWifiP2pChannel;
    private boolean mWifiP2pEnabled;
    private WifiP2pManager mWifiP2pManager;
    private final BroadcastReceiver mWifiP2pReceiver;

    public interface Listener {
        void onDisplayChanged(WifiDisplay r1);

        void onDisplayConnected(WifiDisplay r1, Surface r2, int r3, int r4, int r5);

        void onDisplayConnecting(WifiDisplay r1);

        void onDisplayConnectionFailed();

        void onDisplayDisconnected();

        void onDisplaySessionInfo(WifiDisplaySessionInfo r1);

        void onFeatureStateChanged(int r1);

        void onScanFinished();

        void onScanResults(WifiDisplay[] r1);

        void onScanStarted();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAvailableWifiDisplayPeers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m3927$$Nest$fgetmAvailableWifiDisplayPeers(WifiDisplayController r0) {
        return r0.mAvailableWifiDisplayPeers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCancelingDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiP2pDevice m3928$$Nest$fgetmCancelingDevice(WifiDisplayController r0) {
        return r0.mCancelingDevice;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectedDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiP2pDevice m3929$$Nest$fgetmConnectedDevice(WifiDisplayController r0) {
        return r0.mConnectedDevice;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectedDeviceGroupInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiP2pGroup m3930$$Nest$fgetmConnectedDeviceGroupInfo(WifiDisplayController r0) {
        return r0.mConnectedDeviceGroupInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectingDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiP2pDevice m3931$$Nest$fgetmConnectingDevice(WifiDisplayController r0) {
        return r0.mConnectingDevice;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectionRetriesLeft, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3932$$Nest$fgetmConnectionRetriesLeft(WifiDisplayController r0) {
        return r0.mConnectionRetriesLeft;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectionTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m3933$$Nest$fgetmConnectionTimeout(WifiDisplayController r0) {
        return r0.mConnectionTimeout;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDesiredDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiP2pDevice m3934$$Nest$fgetmDesiredDevice(WifiDisplayController r0) {
        return r0.mDesiredDevice;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisconnectingDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiP2pDevice m3935$$Nest$fgetmDisconnectingDevice(WifiDisplayController r0) {
        return r0.mDisconnectingDevice;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDiscoverPeersInProgress, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3936$$Nest$fgetmDiscoverPeersInProgress(WifiDisplayController r0) {
        return r0.mDiscoverPeersInProgress;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExtRemoteDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m3937$$Nest$fgetmExtRemoteDisplay(WifiDisplayController r0) {
        return r0.mExtRemoteDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3938$$Nest$fgetmHandler(WifiDisplayController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ Listener m3939$$Nest$fgetmListener(WifiDisplayController r0) {
        return r0.mListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ NetworkInfo m3940$$Nest$fgetmNetworkInfo(WifiDisplayController r0) {
        return r0.mNetworkInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteDisplay m3941$$Nest$fgetmRemoteDisplay(WifiDisplayController r0) {
        return r0.mRemoteDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteDisplayConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3942$$Nest$fgetmRemoteDisplayConnected(WifiDisplayController r0) {
        return r0.mRemoteDisplayConnected;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRtspTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m3943$$Nest$fgetmRtspTimeout(WifiDisplayController r0) {
        return r0.mRtspTimeout;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThisDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiP2pDevice m3944$$Nest$fgetmThisDevice(WifiDisplayController r0) {
        return r0.mThisDevice;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWfdEnabling, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3945$$Nest$fgetmWfdEnabling(WifiDisplayController r0) {
        return r0.mWfdEnabling;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiDisplayCertMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3946$$Nest$fgetmWifiDisplayCertMode(WifiDisplayController r0) {
        return r0.mWifiDisplayCertMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiP2pChannel, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiP2pManager.Channel m3947$$Nest$fgetmWifiP2pChannel(WifiDisplayController r0) {
        return r0.mWifiP2pChannel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiP2pManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiP2pManager m3948$$Nest$fgetmWifiP2pManager(WifiDisplayController r0) {
        return r0.mWifiP2pManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCancelingDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3949$$Nest$fputmCancelingDevice(WifiDisplayController r0, WifiP2pDevice r1) {
        r0.mCancelingDevice = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmConnectedDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3950$$Nest$fputmConnectedDevice(WifiDisplayController r0, WifiP2pDevice r1) {
        r0.mConnectedDevice = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmConnectedDeviceGroupInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3951$$Nest$fputmConnectedDeviceGroupInfo(WifiDisplayController r0, WifiP2pGroup r1) {
        r0.mConnectedDeviceGroupInfo = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmConnectingDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3952$$Nest$fputmConnectingDevice(WifiDisplayController r0, WifiP2pDevice r1) {
        r0.mConnectingDevice = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmConnectionRetriesLeft, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3953$$Nest$fputmConnectionRetriesLeft(WifiDisplayController r0, int r1) {
        r0.mConnectionRetriesLeft = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDesiredDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3954$$Nest$fputmDesiredDevice(WifiDisplayController r0, WifiP2pDevice r1) {
        r0.mDesiredDevice = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisconnectingDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3955$$Nest$fputmDisconnectingDevice(WifiDisplayController r0, WifiP2pDevice r1) {
        r0.mDisconnectingDevice = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRemoteDisplayConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3956$$Nest$fputmRemoteDisplayConnected(WifiDisplayController r0, boolean r1) {
        r0.mRemoteDisplayConnected = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmThisDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3957$$Nest$fputmThisDevice(WifiDisplayController r0, WifiP2pDevice r1) {
        r0.mThisDevice = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWfdEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3958$$Nest$fputmWfdEnabled(WifiDisplayController r0, boolean r1) {
        r0.mWfdEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWfdEnabling, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3959$$Nest$fputmWfdEnabling(WifiDisplayController r0, boolean r1) {
        r0.mWfdEnabling = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$madvertiseDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3960$$Nest$madvertiseDisplay(WifiDisplayController r0, WifiDisplay r1, Surface r2, int r3, int r4, int r5) {
        r0.advertiseDisplay(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mdisconnect, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3961$$Nest$mdisconnect(WifiDisplayController r0) {
        r0.disconnect();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSessionInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiDisplaySessionInfo m3962$$Nest$mgetSessionInfo(WifiDisplayController r0, WifiP2pGroup r1, int r2) {
        return r0.getSessionInfo(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleConnectionChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3963$$Nest$mhandleConnectionChanged(WifiDisplayController r0, NetworkInfo r1) {
        r0.handleConnectionChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleConnectionFailure, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3964$$Nest$mhandleConnectionFailure(WifiDisplayController r0, boolean r1) {
        r0.handleConnectionFailure(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePeersChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3965$$Nest$mhandlePeersChanged(WifiDisplayController r0) {
        r0.handlePeersChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleScanResults, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3966$$Nest$mhandleScanResults(WifiDisplayController r0) {
        r0.handleScanResults();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleStateChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3967$$Nest$mhandleStateChanged(WifiDisplayController r0, boolean r1) {
        r0.handleStateChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportFeatureState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3968$$Nest$mreportFeatureState(WifiDisplayController r0) {
        r0.reportFeatureState();
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestPeers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3969$$Nest$mrequestPeers(WifiDisplayController r0) {
        r0.requestPeers();
    }

    /* JADX INFO: renamed from: -$$Nest$mretryConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3970$$Nest$mretryConnection(WifiDisplayController r0) {
        r0.retryConnection();
    }

    /* JADX INFO: renamed from: -$$Nest$mtryDiscoverPeers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3971$$Nest$mtryDiscoverPeers(WifiDisplayController r0) {
        r0.tryDiscoverPeers();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3972$$Nest$mupdateConnection(WifiDisplayController r0) {
        r0.updateConnection();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateScanState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3973$$Nest$mupdateScanState(WifiDisplayController r0) {
        r0.updateScanState();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3974$$Nest$mupdateSettings(WifiDisplayController r0) {
        r0.updateSettings();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3975$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$smcontains, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3976$$Nest$smcontains(WifiP2pGroup r0, WifiP2pDevice r1) {
        return contains(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smcreateWifiDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiDisplay m3977$$Nest$smcreateWifiDisplay(WifiP2pDevice r0) {
        return createWifiDisplay(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smdescribeWifiP2pDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3978$$Nest$smdescribeWifiP2pDevice(WifiP2pDevice r0) {
        return describeWifiP2pDevice(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smdescribeWifiP2pGroup, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3979$$Nest$smdescribeWifiP2pGroup(WifiP2pGroup r0) {
        return describeWifiP2pGroup(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisWifiDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3980$$Nest$smisWifiDisplay(WifiP2pDevice r0) {
        return isWifiDisplay(r0);
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
        DEBUGV = SystemProperties.getBoolean("persist.vendor.debug.wfdcdbgv", false);
    }

    public WifiDisplayController(Context context, Handler handler, Listener listener) {
        this.mAvailableWifiDisplayPeers = new ArrayList();
        this.mWifiDisplayWpsConfig = 4;
        this.mDiscoverPeers = new AnonymousClass17(this);
        this.mConnectionTimeout = new AnonymousClass18(this);
        this.mRtspTimeout = new AnonymousClass19(this);
        this.mWifiP2pReceiver = new AnonymousClass23(this);
        this.mContext = context;
        this.mHandler = handler;
        this.mListener = listener;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.p2p.PEERS_CHANGED");
        intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
        context.registerReceiver(this.mWifiP2pReceiver, intentFilter, null, this.mHandler);
        final Handler r2 = this.mHandler;
        ContentObserver settingsObserver = new AnonymousClass1(this, r2);
        ContentResolver resolver = this.mContext.getContentResolver();
        resolver.registerContentObserver(Settings.Global.getUriFor("wifi_display_on"), false, settingsObserver);
        resolver.registerContentObserver(Settings.Global.getUriFor("wifi_display_certification_on"), false, settingsObserver);
        resolver.registerContentObserver(Settings.Global.getUriFor("wifi_display_wps_config"), false, settingsObserver);
        updateSettings();
    }

    private void retrieveWifiP2pManagerAndChannel() {
        if (this.mWifiP2pManager != null) goto L6;
        this.mWifiP2pManager = (WifiP2pManager) this.mContext.getSystemService("wifip2p");
    L6:
        if (this.mWifiP2pChannel == null) goto L8;
        return;
    L8:
        if (this.mWifiP2pManager == null) goto L12;
        this.mWifiP2pChannel = this.mWifiP2pManager.initialize(this.mContext, this.mHandler.getLooper(), null);
        return;
    }

    private void updateSettings() {
        ContentResolver resolver = this.mContext.getContentResolver();
        boolean r2 = false;
        if (Settings.Global.getInt(resolver, "wifi_display_on", 0) == 0) goto L5;
        boolean r1 = true;
    L6:
        this.mWifiDisplayOnSetting = r1;
        if (Settings.Global.getInt(resolver, "wifi_display_certification_on", 0) == 0) goto L9;
        r2 = true;
    L9:
        this.mWifiDisplayCertMode = r2;
        this.mWifiDisplayWpsConfig = 4;
        if (this.mWifiDisplayCertMode == false) goto L12;
        this.mWifiDisplayWpsConfig = Settings.Global.getInt(resolver, "wifi_display_wps_config", 4);
    L12:
        updateWfdEnableState();
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println("mWifiDisplayOnSetting=" + this.mWifiDisplayOnSetting);
        pw.println("mWifiP2pEnabled=" + this.mWifiP2pEnabled);
        pw.println("mWfdEnabled=" + this.mWfdEnabled);
        pw.println("mWfdEnabling=" + this.mWfdEnabling);
        pw.println("mNetworkInfo=" + this.mNetworkInfo);
        pw.println("mScanRequested=" + this.mScanRequested);
        pw.println("mDiscoverPeersInProgress=" + this.mDiscoverPeersInProgress);
        pw.println("mDesiredDevice=" + describeWifiP2pDevice(this.mDesiredDevice));
        pw.println("mConnectingDisplay=" + describeWifiP2pDevice(this.mConnectingDevice));
        pw.println("mDisconnectingDisplay=" + describeWifiP2pDevice(this.mDisconnectingDevice));
        pw.println("mCancelingDisplay=" + describeWifiP2pDevice(this.mCancelingDevice));
        pw.println("mConnectedDevice=" + describeWifiP2pDevice(this.mConnectedDevice));
        pw.println("mConnectionRetriesLeft=" + this.mConnectionRetriesLeft);
        pw.println("mRemoteDisplay=" + this.mRemoteDisplay);
        pw.println("mRemoteDisplayInterface=" + this.mRemoteDisplayInterface);
        pw.println("mRemoteDisplayConnected=" + this.mRemoteDisplayConnected);
        pw.println("mAdvertisedDisplay=" + this.mAdvertisedDisplay);
        pw.println("mAdvertisedDisplaySurface=" + this.mAdvertisedDisplaySurface);
        pw.println("mAdvertisedDisplayWidth=" + this.mAdvertisedDisplayWidth);
        pw.println("mAdvertisedDisplayHeight=" + this.mAdvertisedDisplayHeight);
        pw.println("mAdvertisedDisplayFlags=" + this.mAdvertisedDisplayFlags);
        pw.println("mAvailableWifiDisplayPeers: size=" + this.mAvailableWifiDisplayPeers.size());
        Iterator<WifiP2pDevice> r0 = this.mAvailableWifiDisplayPeers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WifiP2pDevice device = r0.next();
        pw.println("  " + describeWifiP2pDevice(device));
        goto L4
    }

    private void dump() {
        Slog.d(TAG, "mWifiDisplayOnSetting=" + this.mWifiDisplayOnSetting);
        Slog.d(TAG, "mWifiP2pEnabled=" + this.mWifiP2pEnabled);
        Slog.d(TAG, "mWfdEnabled=" + this.mWfdEnabled);
        Slog.d(TAG, "mWfdEnabling=" + this.mWfdEnabling);
        Slog.d(TAG, "mNetworkInfo=" + this.mNetworkInfo);
        Slog.d(TAG, "mScanRequested=" + this.mScanRequested);
        Slog.d(TAG, "mDiscoverPeersInProgress=" + this.mDiscoverPeersInProgress);
        Slog.d(TAG, "mDesiredDevice=" + describeWifiP2pDevice(this.mDesiredDevice));
        Slog.d(TAG, "mConnectingDisplay=" + describeWifiP2pDevice(this.mConnectingDevice));
        Slog.d(TAG, "mDisconnectingDisplay=" + describeWifiP2pDevice(this.mDisconnectingDevice));
        Slog.d(TAG, "mCancelingDisplay=" + describeWifiP2pDevice(this.mCancelingDevice));
        Slog.d(TAG, "mConnectedDevice=" + describeWifiP2pDevice(this.mConnectedDevice));
        Slog.d(TAG, "mConnectionRetriesLeft=" + this.mConnectionRetriesLeft);
        Slog.d(TAG, "mRemoteDisplay=" + this.mRemoteDisplay);
        Slog.d(TAG, "mRemoteDisplayInterface=" + this.mRemoteDisplayInterface);
        Slog.d(TAG, "mRemoteDisplayConnected=" + this.mRemoteDisplayConnected);
        Slog.d(TAG, "mAdvertisedDisplay=" + this.mAdvertisedDisplay);
        Slog.d(TAG, "mAdvertisedDisplaySurface=" + this.mAdvertisedDisplaySurface);
        Slog.d(TAG, "mAdvertisedDisplayWidth=" + this.mAdvertisedDisplayWidth);
        Slog.d(TAG, "mAdvertisedDisplayHeight=" + this.mAdvertisedDisplayHeight);
        Slog.d(TAG, "mAdvertisedDisplayFlags=" + this.mAdvertisedDisplayFlags);
        Slog.d(TAG, "mAvailableWifiDisplayPeers: size=" + this.mAvailableWifiDisplayPeers.size());
        Iterator<WifiP2pDevice> r0 = this.mAvailableWifiDisplayPeers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WifiP2pDevice device = r0.next();
        Slog.d(TAG, "  " + describeWifiP2pDevice(device));
        goto L4
    }

    public void requestStartScan() {
        if (this.mScanRequested == true) goto L6;
        this.mScanRequested = true;
        updateScanState();
        return;
    }

    public void requestStopScan() {
        if (this.mScanRequested == false) goto L6;
        this.mScanRequested = false;
        updateScanState();
        return;
    }

    public void requestConnect(String address) {
        Iterator<WifiP2pDevice> r0 = this.mAvailableWifiDisplayPeers.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        WifiP2pDevice device = r0.next();
        if (device.deviceAddress.equals(address) == false) goto L4;
        connect(device);
        goto L4
    }

    public void requestPause() {
        if (this.mRemoteDisplay == null) goto L6;
        this.mRemoteDisplay.pause();
        return;
    }

    public void requestResume() {
        if (this.mRemoteDisplay == null) goto L6;
        this.mRemoteDisplay.resume();
        return;
    }

    public void requestDisconnect() {
        disconnect();
    }

    private void updateWfdEnableState() {
        WifiP2pWfdInfo wfdInfo = new WifiP2pWfdInfo();
        int WFDR2Info = SystemProperties.getInt("persist.vendor.setWFDInfo.R2", 0);
        Slog.i(TAG, "WFDR2info is: " + WFDR2Info);
        if (this.mWifiDisplayOnSetting == false) goto L17;
        if (this.mWifiP2pEnabled == false) goto L17;
        if (this.mWfdEnabled == false) goto L9;
        return;
    L9:
        if (this.mWfdEnabling == true) goto L24;
        this.mWfdEnabling = true;
        wfdInfo.setEnabled(true);
        wfdInfo.setDeviceType(0);
        wfdInfo.setSessionAvailable(true);
        wfdInfo.setControlPort(DEFAULT_CONTROL_PORT);
        wfdInfo.setMaxThroughput(50);
        if (WFDR2Info != 2) goto L13;
    L14:
        wfdInfo.setR2DeviceType(0);
    L15:
        this.mWifiP2pManager.setWfdInfo(this.mWifiP2pChannel, wfdInfo, new AnonymousClass2(this));
        return;
    L13:
        if (WFDR2Info != 3) goto L15;
    L24:
        return;
    L17:
        if (this.mWfdEnabled == false) goto L19;
    L20:
        wfdInfo.setEnabled(false);
        this.mWifiP2pManager.setWfdInfo(this.mWifiP2pChannel, wfdInfo, new AnonymousClass3(this));
    L21:
        this.mWfdEnabling = false;
        this.mWfdEnabled = false;
        reportFeatureState();
        updateScanState();
        disconnect();
        return;
    L19:
        if (this.mWfdEnabling == false) goto L21;
        goto L20
    }

    private void reportFeatureState() {
        final int featureState = computeFeatureState();
        this.mHandler.post(new AnonymousClass4(this, featureState));
    }

    private int computeFeatureState() {
        if (this.mWifiP2pEnabled == true) goto L7;
        return 1;
    L7:
        if (this.mWifiDisplayOnSetting == false) goto L9;
        return 3;
    L9:
        return 2;
    }

    private void updateScanState() {
        if (this.mScanRequested == false) goto L16;
        if (this.mWfdEnabled == false) goto L16;
        if (this.mDesiredDevice != null) goto L16;
        if (this.mConnectedDevice != null) goto L16;
        if (this.mDisconnectingDevice != null) goto L16;
        if (this.mDiscoverPeersInProgress == true) goto L23;
        Slog.i(TAG, "Starting Wifi display scan.");
        this.mDiscoverPeersInProgress = true;
        handleScanStarted();
        tryDiscoverPeers();
        return;
    L23:
        return;
    L16:
        if (this.mDiscoverPeersInProgress == false) goto L25;
        this.mHandler.removeCallbacks(this.mDiscoverPeers);
        if (this.mDesiredDevice != null) goto L20;
    L21:
        Slog.i(TAG, "Stopping Wifi display scan.");
        this.mDiscoverPeersInProgress = false;
        stopPeerDiscovery();
        handleScanFinished();
        return;
    L20:
        if (this.mDesiredDevice == this.mConnectedDevice) goto L21;
        return;
    }

    private void tryDiscoverPeers() {
        this.mWifiP2pManager.discoverPeers(this.mWifiP2pChannel, new AnonymousClass5(this));
        this.mHandler.postDelayed(this.mDiscoverPeers, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    private void stopPeerDiscovery() {
        this.mWifiP2pManager.stopPeerDiscovery(this.mWifiP2pChannel, new AnonymousClass6(this));
    }

    private void requestPeers() {
        this.mWifiP2pManager.requestPeers(this.mWifiP2pChannel, new AnonymousClass7(this));
    }

    private void handleScanStarted() {
        this.mHandler.post(new AnonymousClass8(this));
    }

    private void handleScanResults() {
        int count = this.mAvailableWifiDisplayPeers.size();
        final WifiDisplay[] displays = (WifiDisplay[]) WifiDisplay.CREATOR.newArray(count);
        int i = 0;
    L3:
        if (i >= count) goto L5;
        WifiP2pDevice device = this.mAvailableWifiDisplayPeers.get(i);
        displays[i] = createWifiDisplay(device);
        updateDesiredDevice(device);
        i = i + 1;
        goto L3
    L5:
        this.mHandler.post(new AnonymousClass9(this, displays));
    }

    private void handleScanFinished() {
        this.mHandler.post(new AnonymousClass10(this));
    }

    private void updateDesiredDevice(WifiP2pDevice device) {
        String address = device.deviceAddress;
        if (this.mDesiredDevice != null) goto L5;
        return;
    L5:
        if (this.mDesiredDevice.deviceAddress.equals(address) == true) goto L7;
        return;
    L7:
        if (DEBUG == false) goto L9;
        Slog.d(TAG, "updateDesiredDevice: new information " + describeWifiP2pDevice(device));
    L9:
        this.mDesiredDevice.update(device);
        if (this.mAdvertisedDisplay != null) goto L12;
        return;
    L12:
        if (this.mAdvertisedDisplay.getDeviceAddress().equals(address) == false) goto L18;
        readvertiseDisplay(createWifiDisplay(this.mDesiredDevice));
        return;
    }

    private void connect(WifiP2pDevice device) {
        if (this.mDesiredDevice == null) goto L11;
        if (this.mDesiredDevice.deviceAddress.equals(device.deviceAddress) == true) goto L11;
        if (DEBUG == false) goto L30;
        Slog.d(TAG, "connect: nothing to do, already connecting to " + describeWifiP2pDevice(device));
        return;
    L30:
        return;
    L11:
        if (this.mConnectedDevice == null) goto L21;
        if (this.mConnectedDevice.deviceAddress.equals(device.deviceAddress) == true) goto L21;
        if (this.mDesiredDevice != null) goto L21;
        if (DEBUG == false) goto L31;
        Slog.d(TAG, "connect: nothing to do, already connected to " + describeWifiP2pDevice(device) + " and not part way through connecting to a different device.");
        return;
    L31:
        return;
    L21:
        if (this.mWfdEnabled == true) goto L25;
        Slog.i(TAG, "Ignoring request to connect to Wifi display because the  feature is currently disabled: " + device.deviceName);
        return;
    L25:
        if (handlePreExistingConnection(device) == false) goto L28;
        Slog.i(TAG, "already handle the preexisting p2p connection status");
        return;
    L28:
        this.mDesiredDevice = device;
        this.mConnectionRetriesLeft = 3;
        updateConnection();
    }

    private void disconnect() {
        this.mDesiredDevice = null;
        updateConnection();
    }

    private void retryConnection() {
        this.mDesiredDevice = new WifiP2pDevice(this.mDesiredDevice);
        updateConnection();
    }

    private void updateConnection() {
        if (DEBUGV == false) goto L11;
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        int i = 2;
    L6:
        if (i >= st.length) goto L10;
        if (i >= 5) goto L10;
        Slog.i(TAG, st[i].toString());
        i = i + 1;
    L10:
        dump();
    L11:
        updateScanState();
        if (this.mRemoteDisplay != null) goto L16;
        if (this.mExtRemoteDisplay != null) goto L16;
    L18:
        if (this.mRemoteDisplayInterface == null) goto L29;
        if (this.mConnectedDevice != null) goto L29;
    L21:
        Slog.i(TAG, "Stopped listening for RTSP connection on " + this.mRemoteDisplayInterface);
        if (this.mRemoteDisplay == null) goto L25;
        this.mRemoteDisplay.dispose();
    L27:
        this.mExtRemoteDisplay = null;
        this.mRemoteDisplay = null;
        this.mRemoteDisplayInterface = null;
        this.mHandler.removeCallbacks(this.mRtspTimeout);
        this.mWifiP2pManager.setMiracastMode(0);
        unadvertiseDisplay();
        goto L29
    L25:
        if (this.mExtRemoteDisplay == null) goto L27;
        ExtendedRemoteDisplayHelper.dispose(this.mExtRemoteDisplay);
    L29:
        if (this.mRemoteDisplayConnected == false) goto L31;
        return;
    L31:
        if (this.mDisconnectingDevice == null) goto L34;
        return;
    L34:
        if (this.mConnectedDevice != null) goto L36;
    L39:
        WifiP2pDevice oldDevice = this.mCancelingDevice;
        if (oldDevice == null) goto L43;
        return;
    L43:
        if (this.mConnectingDevice != null) goto L45;
    L48:
        WifiP2pDevice oldDevice2 = this.mDesiredDevice;
        if (oldDevice2 == null) goto L51;
        final WifiP2pDevice oldDevice3 = this.mDesiredDevice;
        RemoteDisplay.Listener listener = new AnonymousClass13(this, oldDevice3);
        int WFDR2Info = SystemProperties.getInt("persist.vendor.setWFDInfo.R2", 0);
        Slog.i(TAG, "WFDR2info is: " + WFDR2Info);
        if (WFDR2Info != 2) goto L58;
    L59:
        WifiP2pWfdInfo wfdInfo = this.mThisDevice.getWfdInfo();
        wfdInfo.setR2DeviceType(0);
        this.mWifiP2pManager.setWfdInfo(this.mWifiP2pChannel, wfdInfo, new AnonymousClass14(this));
    L61:
        if (this.mConnectedDevice != null) goto L82;
        if (this.mConnectingDevice != null) goto L82;
        Slog.i(TAG, "Connecting to Wifi display: " + this.mDesiredDevice.deviceName);
        this.mConnectingDevice = this.mDesiredDevice;
        WifiP2pConfig config = new WifiP2pConfig();
        WpsInfo wps = new WpsInfo();
        if (this.mWifiDisplayWpsConfig == 4) goto L68;
        wps.setup = this.mWifiDisplayWpsConfig;
    L74:
        config.wps = wps;
        config.deviceAddress = this.mConnectingDevice.deviceAddress;
        int WFDGoIntent = SystemProperties.getInt("persist.vendor.sys.debug.wfd.gointent", -1);
        config.groupOwnerIntent = WFDGoIntent;
        Slog.i(TAG, "WFD P2P GO Intent value: " + config.groupOwnerIntent);
        WifiDisplay display = createWifiDisplay(this.mConnectingDevice);
        advertiseDisplay(display, null, 0, 0, 0);
        if (ExtendedRemoteDisplayHelper.isAvailable() == true) goto L77;
    L79:
        final WifiP2pDevice newDevice = this.mDesiredDevice;
        this.mWifiP2pManager.connect(this.mWifiP2pChannel, config, new AnonymousClass15(this, newDevice));
        return;
    L77:
        if (this.mExtRemoteDisplay != null) goto L79;
        int port = getPortNumber(this.mDesiredDevice);
        String iface = "255.255.255.255:" + port;
        this.mRemoteDisplayInterface = iface;
        Slog.i(TAG, "Listening for RTSP connection on " + iface + " from Wifi display: " + this.mDesiredDevice.deviceName);
        this.mExtRemoteDisplay = ExtendedRemoteDisplayHelper.listen(iface, listener, this.mHandler, this.mContext);
        goto L79
    L68:
        if (this.mConnectingDevice.wpsPbcSupported() == false) goto L71;
        wps.setup = 0;
        goto L74
    L71:
        if (this.mConnectingDevice.wpsDisplaySupported() == false) goto L73;
        wps.setup = 2;
        goto L74
    L73:
        wps.setup = 1;
    L82:
        if (this.mConnectedDevice != null) goto L84;
        return;
    L84:
        if (this.mRemoteDisplay != null) goto L102;
        Inet4Address addr = getInterfaceAddress(this.mConnectedDeviceGroupInfo);
        if (addr != null) goto L89;
        Slog.i(TAG, "Failed to get local interface address for communicating with Wifi display: " + this.mConnectedDevice.deviceName);
        handleConnectionFailure(false);
        return;
    L89:
        this.mWifiP2pManager.setMiracastMode(1);
        int port2 = getPortNumber(this.mConnectedDevice);
        String iface2 = addr.getHostAddress() + ":" + port2;
        this.mRemoteDisplayInterface = iface2;
        if (ExtendedRemoteDisplayHelper.isAvailable() == true) goto L93;
        Slog.i(TAG, "Listening for RTSP connection on " + iface2 + " from Wifi display: " + this.mConnectedDevice.deviceName);
        this.mRemoteDisplay = RemoteDisplay.listen(iface2, listener, this.mHandler, this.mContext.getOpPackageName());
    L93:
        if (this.mWifiDisplayCertMode == false) goto L95;
        int rtspTimeout = 120;
    L96:
        this.mHandler.postDelayed(this.mRtspTimeout, rtspTimeout * 1000);
        return;
    L95:
        rtspTimeout = 30;
        goto L96
    L102:
        return;
    L58:
        if (WFDR2Info != 3) goto L61;
    L51:
        if (this.mWifiDisplayCertMode == false) goto L53;
        this.mListener.onDisplaySessionInfo(getSessionInfo(this.mConnectedDeviceGroupInfo, 0));
    L53:
        unadvertiseDisplay();
        return;
    L45:
        if (this.mConnectingDevice == this.mDesiredDevice) goto L48;
        Slog.i(TAG, "Canceling connection to Wifi display: " + this.mConnectingDevice.deviceName);
        this.mCancelingDevice = this.mConnectingDevice;
        this.mConnectingDevice = null;
        unadvertiseDisplay();
        this.mHandler.removeCallbacks(this.mConnectionTimeout);
        final WifiP2pDevice oldDevice4 = this.mCancelingDevice;
        this.mWifiP2pManager.cancelConnect(this.mWifiP2pChannel, new AnonymousClass12(this, oldDevice4));
        return;
    L36:
        if (this.mConnectedDevice == this.mDesiredDevice) goto L39;
        Slog.i(TAG, "Disconnecting from Wifi display: " + this.mConnectedDevice.deviceName);
        this.mDisconnectingDevice = this.mConnectedDevice;
        this.mConnectedDevice = null;
        this.mConnectedDeviceGroupInfo = null;
        unadvertiseDisplay();
        final WifiP2pDevice oldDevice5 = this.mDisconnectingDevice;
        this.mWifiP2pManager.removeGroup(this.mWifiP2pChannel, new AnonymousClass11(this, oldDevice5));
        return;
    L16:
        if (this.mConnectedDevice != this.mDesiredDevice) goto L21;
        goto L21
    }

    private WifiDisplaySessionInfo getSessionInfo(WifiP2pGroup info, int session) {
        if (info == null) goto L16;
        if (info.getOwner() == null) goto L18;
        Inet4Address addr = getInterfaceAddress(info);
        boolean r2 = !info.getOwner().deviceAddress.equals(this.mThisDevice.deviceAddress);
        String r4 = info.getOwner().deviceAddress + " " + info.getNetworkName();
        String r5 = info.getPassphrase();
        if (addr == null) goto L10;
        String r3 = addr.getHostAddress();
    L11:
        WifiDisplaySessionInfo sessionInfo = new WifiDisplaySessionInfo(r2, session, r4, r5, r3);
        if (DEBUG == false) goto L14;
        Slog.d(TAG, sessionInfo.toString());
    L14:
        return sessionInfo;
    L10:
        r3 = "";
        goto L11
    L18:
        return null;
    L16:
        return null;
    }

    private void handleStateChanged(boolean enabled) {
        this.mWifiP2pEnabled = enabled;
        if (enabled == false) goto L5;
        retrieveWifiP2pManagerAndChannel();
    L5:
        updateWfdEnableState();
    }

    private void handlePeersChanged() {
        requestPeers();
    }

    private static boolean contains(WifiP2pGroup group, WifiP2pDevice device) {
        if (group.getOwner().equals(device) == false) goto L5;
    L8:
        return true;
    L5:
        if (group.getClientList().contains(device) == true) goto L8;
        return false;
    }

    private void handleConnectionChanged(NetworkInfo networkInfo) {
        this.mNetworkInfo = networkInfo;
        if (this.mWfdEnabled == false) goto L12;
        if (networkInfo.isConnected() == false) goto L12;
        if (this.mDesiredDevice == null) goto L9;
    L10:
        this.mWifiP2pManager.requestGroupInfo(this.mWifiP2pChannel, new AnonymousClass16(this));
        return;
    L9:
        if (this.mWifiDisplayCertMode == true) goto L10;
        return;
    L12:
        if (networkInfo.isConnectedOrConnecting() == true) goto L28;
        this.mConnectedDeviceGroupInfo = null;
        if (this.mConnectingDevice == null) goto L16;
    L17:
        disconnect();
    L19:
        if (this.mDesiredDevice == null) goto L23;
        Slog.i(TAG, "reconnect new device: " + this.mDesiredDevice.deviceName);
        updateConnection();
        return;
    L23:
        if (this.mWfdEnabled == false) goto L29;
        requestPeers();
        return;
    L29:
        return;
    L16:
        if (this.mConnectedDevice == null) goto L19;
    }

    private void handleConnectionFailure(boolean timeoutOccurred) {
        Slog.i(TAG, "Wifi display connection failed!");
        if (this.mDesiredDevice != null) goto L5;
        return;
    L5:
        if (this.mConnectionRetriesLeft <= 0) goto L11;
        final WifiP2pDevice oldDevice = this.mDesiredDevice;
        Handler r1 = this.mHandler;
        Runnable r2 = new AnonymousClass20(this, oldDevice);
        if (timeoutOccurred == false) goto L9;
        long r3 = 0;
    L10:
        r1.postDelayed(r2, r3);
        return;
    L9:
        r3 = 500;
        goto L10
    L11:
        disconnect();
    }

    private void advertiseDisplay(final WifiDisplay display, final Surface surface, final int width, final int height, final int flags) {
        if (Objects.equals(this.mAdvertisedDisplay, display) == true) goto L5;
    L14:
        final WifiDisplay oldDisplay = this.mAdvertisedDisplay;
        final Surface oldSurface = this.mAdvertisedDisplaySurface;
        this.mAdvertisedDisplay = display;
        this.mAdvertisedDisplaySurface = surface;
        this.mAdvertisedDisplayWidth = width;
        this.mAdvertisedDisplayHeight = height;
        this.mAdvertisedDisplayFlags = flags;
        this.mHandler.post(new AnonymousClass21(this, oldSurface, surface, oldDisplay, display, width, height, flags));
        return;
    L5:
        if (this.mAdvertisedDisplaySurface != surface) goto L14;
        if (this.mAdvertisedDisplayWidth != width) goto L14;
        if (this.mAdvertisedDisplayHeight != height) goto L14;
        if (this.mAdvertisedDisplayFlags != flags) goto L14;
    }

    private void unadvertiseDisplay() {
        advertiseDisplay(null, null, 0, 0, 0);
    }

    private void readvertiseDisplay(WifiDisplay display) {
        advertiseDisplay(display, this.mAdvertisedDisplaySurface, this.mAdvertisedDisplayWidth, this.mAdvertisedDisplayHeight, this.mAdvertisedDisplayFlags);
    }

    private boolean handlePreExistingConnection(final WifiP2pDevice device) {
        if (this.mNetworkInfo != null) goto L5;
        return false;
    L5:
        if (this.mNetworkInfo.isConnected() == true) goto L7;
        return false;
    L7:
        if (this.mWifiDisplayCertMode == true) goto L14;
        Slog.i(TAG, "handle the preexisting p2p connection status");
        this.mWifiP2pManager.requestGroupInfo(this.mWifiP2pChannel, new AnonymousClass22(this, device));
        this.mDesiredDevice = device;
        this.mConnectionRetriesLeft = 3;
        return true;
    L14:
        return false;
    }

    private static Inet4Address getInterfaceAddress(WifiP2pGroup info) {
        NetworkInterface iface = NetworkInterface.getByName(info.getInterface());     // Catch: SocketException -> L14
        Enumeration<InetAddress> addrs = iface.getInetAddresses();
    L6:
        if (addrs.hasMoreElements() == false) goto L12;
        InetAddress addr = addrs.nextElement();
        if ((addr instanceof Inet4Address) == false) goto L6;
        return (Inet4Address) addr;
    L12:
        Slog.w(TAG, "Could not obtain address of network interface " + info.getInterface() + " because it had no IPv4 addresses.");
        return null;
    L14:
        ex = move-exception;
        Slog.w(TAG, "Could not obtain address of network interface " + info.getInterface(), ex);
        return null;
    }

    private static int getPortNumber(WifiP2pDevice device) {
        if (device.deviceName.startsWith("DIRECT-") == true) goto L5;
        return DEFAULT_CONTROL_PORT;
    L5:
        if (device.deviceName.endsWith("Broadcom") == false) goto L10;
        return 8554;
    L10:
        return DEFAULT_CONTROL_PORT;
    }

    private static boolean isWifiDisplay(WifiP2pDevice device) {
        WifiP2pWfdInfo wfdInfo = device.getWfdInfo();
        if (wfdInfo != null) goto L5;
    L9:
        return false;
    L5:
        if (wfdInfo.isEnabled() == false) goto L9;
        if (isPrimarySinkDeviceType(wfdInfo.getDeviceType()) == false) goto L9;
        return true;
    }

    private static boolean isPrimarySinkDeviceType(int deviceType) {
        if (deviceType != 1) goto L5;
        return true;
    L5:
        if (deviceType == 3) goto L10;
        return false;
    L10:
        return true;
    }

    private static String describeWifiP2pDevice(WifiP2pDevice device) {
        if (device != null) goto L6;
        return "null";
    L6:
        return device.toString().replace('\n', ',');
    }

    private static String describeWifiP2pGroup(WifiP2pGroup group) {
        if (group != null) goto L6;
        return "null";
    L6:
        return group.toString().replace('\n', ',');
    }

    private static WifiDisplay createWifiDisplay(WifiP2pDevice device) {
        WifiP2pWfdInfo wfdInfo = device.getWfdInfo();
        if (wfdInfo != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean isSessionAvailable = r1;
        return new WifiDisplay(device.deviceAddress, device.deviceName, null, true, isSessionAvailable, false);
    L5:
        if (wfdInfo.isSessionAvailable() == false) goto L7;
        r1 = true;
        goto L8
    }
}
