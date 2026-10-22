package com.android.server.net;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.net.VpnConfig;
import com.android.internal.net.VpnProfile;
import com.android.server.connectivity.Vpn;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LockdownVpnTracker {
    public static final String ACTION_LOCKDOWN_RESET = "com.android.server.action.LOCKDOWN_RESET";
    private static final String TAG = "LockdownVpnTracker";
    private String mAcceptedEgressIface;
    private final ConnectivityManager mCm;
    private final PendingIntent mConfigIntent;
    private final Context mContext;
    private final NetworkCallback mDefaultNetworkCallback;
    private final Handler mHandler;
    private final NotificationManager mNotificationManager;
    private final VpnProfile mProfile;
    private final PendingIntent mResetIntent;
    private final Object mStateLock;
    private final Vpn mVpn;
    private final VpnNetworkCallback mVpnNetworkCallback;

    private class NetworkCallback extends ConnectivityManager.NetworkCallback {
        private LinkProperties mLinkProperties;
        private Network mNetwork;
        final /* synthetic */ LockdownVpnTracker this$0;

        /* synthetic */ NetworkCallback(LockdownVpnTracker r1, LockdownVpnTrackerIA r2) {
            this(r1);
        }

        private NetworkCallback(LockdownVpnTracker r1) {
            this.this$0 = r1;
            this.mNetwork = null;
            this.mLinkProperties = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties lp) {
            boolean networkChanged = false;
            if (network.equals(this.mNetwork) == true) goto L5;
            this.mNetwork = network;
            networkChanged = true;
        L5:
            this.mLinkProperties = lp;
            if (networkChanged == false) goto L15;
            Object r1 = LockdownVpnTracker.m5928$$Nest$fgetmStateLock(this.this$0);
            monitor-enter(r1);
            LockdownVpnTracker.m5929$$Nest$mhandleStateChangedLocked(this.this$0);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.mNetwork = null;
            this.mLinkProperties = null;
            Object r0 = LockdownVpnTracker.m5928$$Nest$fgetmStateLock(this.this$0);
            monitor-enter(r0);
            LockdownVpnTracker.m5929$$Nest$mhandleStateChangedLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public Network getNetwork() {
            return this.mNetwork;
        }

        public LinkProperties getLinkProperties() {
            return this.mLinkProperties;
        }
    }

    private class VpnNetworkCallback extends NetworkCallback {
        final /* synthetic */ LockdownVpnTracker this$0;

        /* synthetic */ VpnNetworkCallback(LockdownVpnTracker r1, LockdownVpnTrackerIA r2) {
            this(r1);
        }

        private VpnNetworkCallback(LockdownVpnTracker r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Object r0 = LockdownVpnTracker.m5928$$Nest$fgetmStateLock(this.this$0);
            monitor-enter(r0);
            LockdownVpnTracker.m5929$$Nest$mhandleStateChangedLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.net.LockdownVpnTracker.NetworkCallback, android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            onAvailable(network);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStateLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5928$$Nest$fgetmStateLock(LockdownVpnTracker r0) {
        return r0.mStateLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleStateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5929$$Nest$mhandleStateChangedLocked(LockdownVpnTracker r0) {
        r0.handleStateChangedLocked();
    }

    public LockdownVpnTracker(Context context, Handler handler, Vpn vpn, VpnProfile profile) {
        this.mStateLock = new Object();
        LockdownVpnTrackerIA r1 = null;
        this.mDefaultNetworkCallback = new NetworkCallback(this, r1);
        this.mVpnNetworkCallback = new VpnNetworkCallback(this, r1);
        context.getClass();
        this.mContext = context;
        this.mCm = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        handler.getClass();
        this.mHandler = handler;
        vpn.getClass();
        this.mVpn = vpn;
        profile.getClass();
        this.mProfile = profile;
        this.mNotificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        Intent configIntent = new Intent("android.settings.VPN_SETTINGS");
        this.mConfigIntent = PendingIntent.getActivity(this.mContext, 0, configIntent, 67108864);
        Intent resetIntent = new Intent(ACTION_LOCKDOWN_RESET);
        resetIntent.addFlags(1073741824);
        this.mResetIntent = PendingIntent.getBroadcast(this.mContext, 0, resetIntent, 67108864);
    }

    private void handleStateChangedLocked() {
        Network network = this.mDefaultNetworkCallback.getNetwork();
        LinkProperties egressProp = this.mDefaultNetworkCallback.getLinkProperties();
        NetworkInfo vpnInfo = this.mVpn.getNetworkInfo();
        VpnConfig vpnConfig = this.mVpn.getLegacyVpnConfig();
        boolean egressChanged = false;
        if (network != null) goto L5;
        boolean egressDisconnected = true;
    L7:
        if (egressProp != null) goto L9;
    L10:
        egressChanged = true;
    L12:
        if (egressProp != null) goto L14;
        String egressIface = null;
    L15:
        Log.d(TAG, "handleStateChanged: egress=" + this.mAcceptedEgressIface + "->" + egressIface);
        if (egressDisconnected == true) goto L18;
        if (egressChanged == true) goto L18;
    L19:
        if (egressDisconnected == false) goto L23;
        hideNotification();
        return;
    L23:
        if (vpnInfo.isConnectedOrConnecting() == true) goto L34;
        if (this.mProfile.isValidLockdownProfile() == true) goto L28;
        Log.e(TAG, "Invalid VPN profile; requires IP-based server and DNS");
        showNotification(17042354, 17305538);
        return;
    L28:
        Log.d(TAG, "Active network connected; starting VPN");
        showNotification(17042352, 17305538);
        this.mAcceptedEgressIface = egressIface;
        this.mVpn.startLegacyVpnPrivileged(this.mProfile);     // Catch: IllegalStateException -> L31
        return;
    L31:
        e = move-exception;
        this.mAcceptedEgressIface = null;
        Log.e(TAG, "Failed to start VPN", e);
        showNotification(17042354, 17305538);
        return;
    L34:
        if (vpnInfo.isConnected() == false) goto L40;
        if (vpnConfig == null) goto L41;
        String iface = vpnConfig.interfaze;
        List<LinkAddress> sourceAddrs = vpnConfig.addresses;
        Log.d(TAG, "VPN connected using iface=" + iface + ", sourceAddr=" + sourceAddrs.toString());
        showNotification(17042351, 17305537);
        return;
    L41:
        return;
    L40:
        return;
    L18:
        this.mAcceptedEgressIface = null;
        this.mVpn.stopVpnRunnerPrivileged();
        goto L19
    L14:
        egressIface = egressProp.getInterfaceName();
        goto L15
    L9:
        if (TextUtils.equals(this.mAcceptedEgressIface, egressProp.getInterfaceName()) == true) goto L12;
    L5:
        egressDisconnected = false;
        goto L7
    }

    public void init() {
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        initLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void initLocked() {
        Log.d(TAG, "initLocked()");
        this.mVpn.setEnableTeardown(false);
        this.mVpn.setLockdown(true);
        this.mCm.setLegacyLockdownVpnEnabled(true);
        handleStateChangedLocked();
        this.mCm.registerSystemDefaultNetworkCallback(this.mDefaultNetworkCallback, this.mHandler);
        NetworkRequest vpnRequest = new NetworkRequest.Builder().clearCapabilities().addTransportType(4).build();
        this.mCm.registerNetworkCallback(vpnRequest, this.mVpnNetworkCallback, this.mHandler);
    }

    public void shutdown() {
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        shutdownLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void shutdownLocked() {
        Log.d(TAG, "shutdownLocked()");
        this.mAcceptedEgressIface = null;
        this.mVpn.stopVpnRunnerPrivileged();
        this.mVpn.setLockdown(false);
        this.mCm.setLegacyLockdownVpnEnabled(false);
        hideNotification();
        this.mVpn.setEnableTeardown(true);
        this.mCm.unregisterNetworkCallback(this.mDefaultNetworkCallback);
        this.mCm.unregisterNetworkCallback(this.mVpnNetworkCallback);
    }

    public void reset() {
        Log.d(TAG, "reset()");
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        shutdownLocked();     // Catch: Throwable -> L7
        initLocked();     // Catch: Throwable -> L7
        handleStateChangedLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void showNotification(int titleRes, int iconRes) {
        Notification.Builder builder = new Notification.Builder(this.mContext, "VPN").setWhen(0).setSmallIcon(iconRes).setContentTitle(this.mContext.getString(titleRes)).setContentText(this.mContext.getString(17042350)).setContentIntent(this.mConfigIntent).setOngoing(true).addAction(R.drawable.pointer_nodrop, this.mContext.getString(R.string.status_bar_camera), this.mResetIntent).setColor(this.mContext.getColor(R.color.system_notification_accent_color));
        this.mNotificationManager.notify(null, 20, builder.build());
    }

    private void hideNotification() {
        this.mNotificationManager.cancel(null, 20);
    }
}
