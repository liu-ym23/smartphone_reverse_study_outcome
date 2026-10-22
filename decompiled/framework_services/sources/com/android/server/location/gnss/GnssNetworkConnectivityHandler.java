package com.android.server.location.gnss;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.PreciseCallState;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.internal.location.GpsNetInitiatedHandler;
import com.android.server.FgThread;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class GnssNetworkConnectivityHandler {
    private static final int AGNSS_NET_CAPABILITY_NOT_METERED = 1;
    private static final int AGNSS_NET_CAPABILITY_NOT_ROAMING = 2;
    private static final int AGPS_DATA_CONNECTION_CLOSED = 0;
    private static final int AGPS_DATA_CONNECTION_OPEN = 2;
    private static final int AGPS_DATA_CONNECTION_OPENING = 1;
    public static final int AGPS_TYPE_C2K = 2;
    private static final int AGPS_TYPE_EIMS = 3;
    private static final int AGPS_TYPE_IMS = 4;
    public static final int AGPS_TYPE_SUPL = 1;
    private static final int APN_INVALID = 0;
    private static final int APN_IPV4 = 1;
    private static final int APN_IPV4V6 = 3;
    private static final int APN_IPV6 = 2;
    private static final boolean DEBUG = false;
    private static final int GPS_AGPS_DATA_CONNECTED = 3;
    private static final int GPS_AGPS_DATA_CONN_DONE = 4;
    private static final int GPS_AGPS_DATA_CONN_FAILED = 5;
    private static final int GPS_RELEASE_AGPS_DATA_CONN = 2;
    private static final int GPS_REQUEST_AGPS_DATA_CONN = 1;
    private static final int HASH_MAP_INITIAL_CAPACITY_TO_TRACK_CONNECTED_NETWORKS = 5;
    private static final long SUPL_CONNECTION_TIMEOUT_MILLIS = 0;
    private static final int SUPL_NETWORK_REQUEST_TIMEOUT_MILLIS = 20000;
    static final String TAG = "GnssNetworkConnectivityHandler";
    private static final boolean VERBOSE = false;
    private static final String WAKELOCK_KEY = "GnssNetworkConnectivityHandler";
    private static final long WAKELOCK_TIMEOUT_MILLIS = 60000;
    private InetAddress mAGpsDataConnectionIpAddr;
    private int mAGpsDataConnectionState;
    private int mAGpsType;
    private int mActiveSubId;
    private HashMap<Network, NetworkAttributes> mAvailableNetworkAttributes;
    private final ConnectivityManager mConnMgr;
    private final Context mContext;
    private final GnssNetworkListener mGnssNetworkListener;
    private final Handler mHandler;
    private ConnectivityManager.NetworkCallback mNetworkConnectivityCallback;
    private final GpsNetInitiatedHandler mNiHandler;
    private final SubscriptionManager.OnSubscriptionsChangedListener mOnSubscriptionsChangeListener;
    private HashMap<Integer, SubIdPhoneStateListener> mPhoneStateListeners;
    private final Object mSuplConnectionReleaseOnTimeoutToken;
    private ConnectivityManager.NetworkCallback mSuplConnectivityCallback;
    private final PowerManager.WakeLock mWakeLock;

    interface GnssNetworkListener {
        void onNetworkAvailable();
    }

    private static class NetworkAttributes {
        private String mApn;
        private NetworkCapabilities mCapabilities;
        private int mType;

        /* JADX INFO: renamed from: -$$Nest$fgetmApn, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m5276$$Nest$fgetmApn(NetworkAttributes r0) {
            return r0.mApn;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCapabilities, reason: not valid java name */
        static /* bridge */ /* synthetic */ NetworkCapabilities m5277$$Nest$fgetmCapabilities(NetworkAttributes r0) {
            return r0.mCapabilities;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5278$$Nest$fgetmType(NetworkAttributes r0) {
            return r0.mType;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmApn, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5279$$Nest$fputmApn(NetworkAttributes r0, String r1) {
            r0.mApn = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmCapabilities, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5280$$Nest$fputmCapabilities(NetworkAttributes r0, NetworkCapabilities r1) {
            r0.mCapabilities = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5281$$Nest$fputmType(NetworkAttributes r0, int r1) {
            r0.mType = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$smgetCapabilityFlags, reason: not valid java name */
        static /* bridge */ /* synthetic */ short m5282$$Nest$smgetCapabilityFlags(NetworkCapabilities r0) {
            return getCapabilityFlags(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$smhasCapabilitiesChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5283$$Nest$smhasCapabilitiesChanged(NetworkCapabilities r0, NetworkCapabilities r1) {
            return hasCapabilitiesChanged(r0, r1);
        }

        /* synthetic */ NetworkAttributes(GnssNetworkConnectivityHandlerIA r1) {
            this();
        }

        private NetworkAttributes() {
            this.mType = -1;
        }

        private static boolean hasCapabilitiesChanged(NetworkCapabilities curCapabilities, NetworkCapabilities newCapabilities) {
            if (curCapabilities == null) goto L14;
            if (newCapabilities == null) goto L14;
            if (hasCapabilityChanged(curCapabilities, newCapabilities, 18) == false) goto L9;
            return true;
        L9:
            if (hasCapabilityChanged(curCapabilities, newCapabilities, 11) == true) goto L16;
            return false;
        L16:
            return true;
        L14:
            return true;
        }

        private static boolean hasCapabilityChanged(NetworkCapabilities curCapabilities, NetworkCapabilities newCapabilities, int capability) {
            if (curCapabilities.hasCapability(capability) == newCapabilities.hasCapability(capability)) goto L5;
            return true;
        L5:
            return false;
        }

        private static short getCapabilityFlags(NetworkCapabilities capabilities) {
            short capabilityFlags = 0;
            if (capabilities.hasCapability(18) == false) goto L6;
            capabilityFlags = (short) (0 | 2);
        L6:
            if (capabilities.hasCapability(11) == true) goto L8;
            return capabilityFlags;
        L8:
            return (short) (capabilityFlags | 1);
        }
    }

    private final class SubIdPhoneStateListener extends PhoneStateListener {
        private Integer mSubId;
        final /* synthetic */ GnssNetworkConnectivityHandler this$0;

        SubIdPhoneStateListener(GnssNetworkConnectivityHandler r1, Integer subId) {
            this.this$0 = r1;
            this.mSubId = subId;
        }

        public void onPreciseCallStateChanged(PreciseCallState state) {
            if (1 != state.getForegroundCallState()) goto L5;
        L6:
            GnssNetworkConnectivityHandler.m5269$$Nest$fputmActiveSubId(this.this$0, this.mSubId.intValue());
            if (GnssNetworkConnectivityHandler.m5274$$Nest$sfgetDEBUG() == false) goto L11;
            Log.d("GnssNetworkConnectivityHandler", "mActiveSubId: " + GnssNetworkConnectivityHandler.m5265$$Nest$fgetmActiveSubId(this.this$0));
            return;
        L11:
            return;
        L5:
            if (3 == state.getForegroundCallState()) goto L6;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$5dIygYjXRVuZYIIBu2yCevqh-t4, reason: not valid java name */
    public static /* synthetic */ void m5263$r8$lambda$5dIygYjXRVuZYIIBu2yCevqht4(GnssNetworkConnectivityHandler r0, int r1, byte[] r2) {
        r0.lambda$onReportAGpsStatus$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ORz9bhk3ZgshJUXfSCpe2RQqXbk(GnssNetworkConnectivityHandler r0) {
        r0.lambda$handleRequestSuplConnection$3();
    }

    public static /* synthetic */ void $r8$lambda$UI75ZGR_wWeGCDtuWWZygqNH2WI(GnssNetworkConnectivityHandler r0) {
        r0.lambda$onReportAGpsStatus$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$uaMjsdErTcMigR-QvUtvFZgEPNE, reason: not valid java name */
    public static /* synthetic */ void m5264$r8$lambda$uaMjsdErTcMigRQvUtvFZgEPNE(GnssNetworkConnectivityHandler r0, Runnable r1) {
        r0.lambda$runEventAndReleaseWakeLock$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveSubId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5265$$Nest$fgetmActiveSubId(GnssNetworkConnectivityHandler r0) {
        return r0.mActiveSubId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5266$$Nest$fgetmContext(GnssNetworkConnectivityHandler r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGnssNetworkListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ GnssNetworkListener m5267$$Nest$fgetmGnssNetworkListener(GnssNetworkConnectivityHandler r0) {
        return r0.mGnssNetworkListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPhoneStateListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m5268$$Nest$fgetmPhoneStateListeners(GnssNetworkConnectivityHandler r0) {
        return r0.mPhoneStateListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActiveSubId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5269$$Nest$fputmActiveSubId(GnssNetworkConnectivityHandler r0, int r1) {
        r0.mActiveSubId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPhoneStateListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5270$$Nest$fputmPhoneStateListeners(GnssNetworkConnectivityHandler r0, HashMap r1) {
        r0.mPhoneStateListeners = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleReleaseSuplConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5271$$Nest$mhandleReleaseSuplConnection(GnssNetworkConnectivityHandler r0, int r1) {
        r0.handleReleaseSuplConnection(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleSuplConnectionAvailable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5272$$Nest$mhandleSuplConnectionAvailable(GnssNetworkConnectivityHandler r0, Network r1, LinkProperties r2) {
        r0.handleSuplConnectionAvailable(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUpdateNetworkState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5273$$Nest$mhandleUpdateNetworkState(GnssNetworkConnectivityHandler r0, Network r1, boolean r2, NetworkCapabilities r3) {
        r0.handleUpdateNetworkState(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5274$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetVERBOSE, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5275$$Nest$sfgetVERBOSE() {
        return VERBOSE;
    }

    private native void native_agps_data_conn_closed();

    private native void native_agps_data_conn_failed();

    private native void native_agps_data_conn_open(long r1, String r3, int r4);

    private static native boolean native_is_agps_ril_supported();

    private native void native_update_network_state(boolean r1, int r2, boolean r3, boolean r4, String r5, long r6, short r8);

    static {
        DEBUG = Log.isLoggable("GnssNetworkConnectivityHandler", 3);
        VERBOSE = Log.isLoggable("GnssNetworkConnectivityHandler", 2);
        SUPL_CONNECTION_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    }

    GnssNetworkConnectivityHandler(Context context, GnssNetworkListener gnssNetworkListener, Looper looper, GpsNetInitiatedHandler niHandler) {
        this.mAvailableNetworkAttributes = new HashMap(5);
        this.mActiveSubId = -1;
        this.mSuplConnectionReleaseOnTimeoutToken = new Object();
        this.mOnSubscriptionsChangeListener = new AnonymousClass1(this);
        this.mContext = context;
        this.mGnssNetworkListener = gnssNetworkListener;
        SubscriptionManager subManager = (SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class);
        if (subManager == null) goto L5;
        subManager.addOnSubscriptionsChangedListener(FgThread.getExecutor(), this.mOnSubscriptionsChangeListener);
    L5:
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        this.mWakeLock = powerManager.newWakeLock(1, "GnssNetworkConnectivityHandler");
        this.mHandler = new Handler(looper);
        this.mNiHandler = niHandler;
        this.mConnMgr = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        this.mSuplConnectivityCallback = null;
    }

    void registerNetworkCallbacks() {
        NetworkRequest.Builder networkRequestBuilder = new NetworkRequest.Builder();
        networkRequestBuilder.addCapability(12);
        networkRequestBuilder.addCapability(16);
        networkRequestBuilder.removeCapability(15);
        NetworkRequest networkRequest = networkRequestBuilder.build();
        this.mNetworkConnectivityCallback = createNetworkConnectivityCallback();
        this.mConnMgr.registerNetworkCallback(networkRequest, this.mNetworkConnectivityCallback, this.mHandler);
    }

    void unregisterNetworkCallbacks() {
        this.mConnMgr.unregisterNetworkCallback(this.mNetworkConnectivityCallback);
        this.mNetworkConnectivityCallback = null;
    }

    boolean isDataNetworkConnected() {
        NetworkInfo activeNetworkInfo = this.mConnMgr.getActiveNetworkInfo();
        if (activeNetworkInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (activeNetworkInfo.isConnected() == false) goto L7;
        return true;
    }

    int getActiveSubId() {
        return this.mActiveSubId;
    }

    void onReportAGpsStatus(final int agpsType, int agpsStatus, final byte[] suplIpAddr) {
        if (DEBUG == false) goto L5;
        Log.d("GnssNetworkConnectivityHandler", "AGPS_DATA_CONNECTION: " + agpsDataConnStatusAsString(agpsStatus));
    L5:
        switch(agpsStatus) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L13;
            default: goto L6;
        };
    L6:
        Log.w("GnssNetworkConnectivityHandler", "Received unknown AGPS status: " + agpsStatus);
        return;
    L8:
        runOnHandler(new GnssNetworkConnectivityHandler$$ExternalSyntheticLambda2(this));
        return;
    L9:
        runOnHandler(new GnssNetworkConnectivityHandler$$ExternalSyntheticLambda1(this, agpsType, suplIpAddr));
        return;
    }

    private /* synthetic */ void lambda$onReportAGpsStatus$0(int agpsType, byte[] suplIpAddr) {
        handleRequestSuplConnection(agpsType, suplIpAddr);
    }

    private /* synthetic */ void lambda$onReportAGpsStatus$1() {
        handleReleaseSuplConnection(2);
    }

    private ConnectivityManager.NetworkCallback createNetworkConnectivityCallback() {
        return new AnonymousClass2(this);
    }

    private ConnectivityManager.NetworkCallback createSuplConnectivityCallback() {
        return new AnonymousClass3(this);
    }

    private void runOnHandler(Runnable event) {
        this.mWakeLock.acquire(60000);
        if (this.mHandler.post(runEventAndReleaseWakeLock(event)) == true) goto L6;
        this.mWakeLock.release();
        return;
    }

    private Runnable runEventAndReleaseWakeLock(final Runnable event) {
        return new GnssNetworkConnectivityHandler$$ExternalSyntheticLambda0(this, event);
    }

    private /* synthetic */ void lambda$runEventAndReleaseWakeLock$2(Runnable event) {
        event.run();     // Catch: Throwable -> L5
        this.mWakeLock.release();
        return;
    L5:
        th = move-exception;
        this.mWakeLock.release();
        throw th;
    }

    private void handleUpdateNetworkState(Network network, boolean isConnected, NetworkCapabilities capabilities) {
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        if (telephonyManager == null) goto L10;
        if (isConnected == true) goto L6;
    L8:
        boolean networkAvailable = false;
    L11:
        NetworkAttributes networkAttributes = updateTrackedNetworksState(isConnected, network, capabilities);
        String apn = NetworkAttributes.m5276$$Nest$fgetmApn(networkAttributes);
        int type = NetworkAttributes.m5278$$Nest$fgetmType(networkAttributes);
        NetworkCapabilities capabilities2 = NetworkAttributes.m5277$$Nest$fgetmCapabilities(networkAttributes);
        Log.i("GnssNetworkConnectivityHandler", String.format("updateNetworkState, state=%s, connected=%s, network=%s, capabilityFlags=%d, availableNetworkCount: %d", new Object[]{agpsDataConnStateAsString(), Boolean.valueOf(isConnected), network, Short.valueOf(NetworkAttributes.m5282$$Nest$smgetCapabilityFlags(capabilities2)), Integer.valueOf(this.mAvailableNetworkAttributes.size())}));
        if (native_is_agps_ril_supported() == false) goto L19;
        boolean r3 = true ^ capabilities2.hasTransport(18);
        if (apn == null) goto L16;
        String r5 = apn;
    L17:
        native_update_network_state(isConnected, type, r3, networkAvailable, r5, network.getNetworkHandle(), NetworkAttributes.m5282$$Nest$smgetCapabilityFlags(capabilities2));
        return;
    L16:
        r5 = "";
        goto L17
    L19:
        if (DEBUG == false) goto L23;
        Log.d("GnssNetworkConnectivityHandler", "Skipped network state update because GPS HAL AGPS-RIL is not  supported");
        return;
    L23:
        return;
    L6:
        if (telephonyManager.getDataEnabled() == false) goto L8;
        networkAvailable = true;
        goto L11
    L10:
        networkAvailable = false;
        goto L11
    }

    private NetworkAttributes updateTrackedNetworksState(boolean isConnected, Network network, NetworkCapabilities capabilities) {
        if (isConnected == false) goto L4;
        NetworkAttributes networkAttributes = this.mAvailableNetworkAttributes.get(network);
        if (networkAttributes == null) goto L9;
        NetworkAttributes.m5280$$Nest$fputmCapabilities(networkAttributes, capabilities);
        return networkAttributes;
    L9:
        NetworkAttributes networkAttributes2 = new NetworkAttributes(null);
        NetworkAttributes.m5280$$Nest$fputmCapabilities(networkAttributes2, capabilities);
        NetworkInfo info = this.mConnMgr.getNetworkInfo(network);
        if (info == null) goto L12;
        NetworkAttributes.m5279$$Nest$fputmApn(networkAttributes2, info.getExtraInfo());
        NetworkAttributes.m5281$$Nest$fputmType(networkAttributes2, info.getType());
    L12:
        this.mAvailableNetworkAttributes.put(network, networkAttributes2);
        return networkAttributes2;
    L4:
        return this.mAvailableNetworkAttributes.remove(network);
    }

    private void handleSuplConnectionAvailable(Network network, LinkProperties linkProperties) {
        NetworkInfo info = this.mConnMgr.getNetworkInfo(network);
        String apn = null;
        if (info == null) goto L6;
        apn = info.getExtraInfo();
    L6:
        if (DEBUG == false) goto L9;
        String message = String.format("handleSuplConnectionAvailable: state=%s, suplNetwork=%s, info=%s", new Object[]{agpsDataConnStateAsString(), network, info});
        Log.d("GnssNetworkConnectivityHandler", message);
    L9:
        if (this.mAGpsDataConnectionState != 1) goto L20;
        if (apn != null) goto L13;
        apn = "dummy-apn";
    L13:
        if (this.mAGpsDataConnectionIpAddr == null) goto L15;
        setRouting();
    L15:
        int apnIpType = getLinkIpType(linkProperties);
        if (DEBUG == false) goto L18;
        String message2 = String.format("native_agps_data_conn_open: mAgpsApn=%s, mApnIpType=%s", new Object[]{apn, Integer.valueOf(apnIpType)});
        Log.d("GnssNetworkConnectivityHandler", message2);
    L18:
        native_agps_data_conn_open(network.getNetworkHandle(), apn, apnIpType);
        this.mAGpsDataConnectionState = 2;
        return;
    }

    private void handleRequestSuplConnection(int agpsType, byte[] suplIpAddr) {
        this.mAGpsDataConnectionIpAddr = null;
        this.mAGpsType = agpsType;
        if (suplIpAddr == null) goto L16;
        if (VERBOSE == false) goto L52;
        Log.v("GnssNetworkConnectivityHandler", "Received SUPL IP addr[]: " + Arrays.toString(suplIpAddr));
    L52:
        this.mAGpsDataConnectionIpAddr = InetAddress.getByAddress(suplIpAddr);     // Catch: UnknownHostException -> L11
        if (DEBUG == false) goto L16;
        Log.d("GnssNetworkConnectivityHandler", "IP address converted to: " + this.mAGpsDataConnectionIpAddr);     // Catch: UnknownHostException -> L11
    L11:
        e = move-exception;
        Log.e("GnssNetworkConnectivityHandler", "Bad IP Address: " + Arrays.toString(suplIpAddr), e);
    L16:
        if (DEBUG == false) goto L19;
        String message = String.format("requestSuplConnection, state=%s, agpsType=%s, address=%s", new Object[]{agpsDataConnStateAsString(), agpsTypeAsString(agpsType), this.mAGpsDataConnectionIpAddr});
        Log.d("GnssNetworkConnectivityHandler", message);
    L19:
        if (this.mAGpsDataConnectionState == 0) goto L21;
        return;
    L21:
        this.mAGpsDataConnectionState = 1;
        NetworkRequest.Builder networkRequestBuilder = new NetworkRequest.Builder();
        networkRequestBuilder.addCapability(getNetworkCapability(this.mAGpsType));
        networkRequestBuilder.addTransportType(0);
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        if (telephonyManager == null) goto L32;
        ServiceState state = telephonyManager.getServiceState();
        if (state == null) goto L32;
        if (state.isUsingNonTerrestrialNetwork() == false) goto L32;
        networkRequestBuilder.removeCapability(13);
        networkRequestBuilder.addTransportType(10);     // Catch: IllegalArgumentException -> L30
        networkRequestBuilder.removeCapability(37);     // Catch: IllegalArgumentException -> L30
    L32:
        if (this.mNiHandler.getInEmergency() == true) goto L34;
    L39:
        NetworkRequest networkRequest = networkRequestBuilder.build();
        if (this.mSuplConnectivityCallback == null) goto L42;
        this.mConnMgr.unregisterNetworkCallback(this.mSuplConnectivityCallback);
    L42:
        this.mSuplConnectivityCallback = createSuplConnectivityCallback();
        this.mConnMgr.requestNetwork(networkRequest, this.mSuplConnectivityCallback, this.mHandler, SUPL_NETWORK_REQUEST_TIMEOUT_MILLIS);     // Catch: RuntimeException -> L45
        this.mHandler.removeCallbacksAndMessages(this.mSuplConnectionReleaseOnTimeoutToken);     // Catch: RuntimeException -> L45
        this.mHandler.postDelayed(new GnssNetworkConnectivityHandler$$ExternalSyntheticLambda3(this), this.mSuplConnectionReleaseOnTimeoutToken, SUPL_CONNECTION_TIMEOUT_MILLIS);     // Catch: RuntimeException -> L45
        return;
    L45:
        e = move-exception;
        Log.e("GnssNetworkConnectivityHandler", "Failed to request network.", e);
        this.mSuplConnectivityCallback = null;
        handleReleaseSuplConnection(5);
        return;
    L34:
        if (this.mActiveSubId < 0) goto L39;
        if (DEBUG == false) goto L38;
        Log.d("GnssNetworkConnectivityHandler", "Adding Network Specifier: " + Integer.toString(this.mActiveSubId));
    L38:
        networkRequestBuilder.setNetworkSpecifier(Integer.toString(this.mActiveSubId));
        networkRequestBuilder.removeCapability(13);
        goto L39
    }

    private /* synthetic */ void lambda$handleRequestSuplConnection$3() {
        handleReleaseSuplConnection(2);
    }

    private int getNetworkCapability(int agpsType) {
        switch(agpsType) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L4;
        };
    L5:
        return 4;
    L7:
        return 10;
    L9:
        return 1;
    L4:
        throw new IllegalArgumentException("agpsType: " + agpsType);
    }

    private void handleReleaseSuplConnection(int agpsDataConnStatus) {
        if (DEBUG == false) goto L5;
        String message = String.format("releaseSuplConnection, state=%s, status=%s", new Object[]{agpsDataConnStateAsString(), agpsDataConnStatusAsString(agpsDataConnStatus)});
        Log.d("GnssNetworkConnectivityHandler", message);
    L5:
        this.mHandler.removeCallbacksAndMessages(this.mSuplConnectionReleaseOnTimeoutToken);
        if (this.mAGpsDataConnectionState != 0) goto L8;
        return;
    L8:
        this.mAGpsDataConnectionState = 0;
        if (this.mSuplConnectivityCallback == null) goto L11;
        this.mConnMgr.unregisterNetworkCallback(this.mSuplConnectivityCallback);
        this.mSuplConnectivityCallback = null;
    L11:
        switch(agpsDataConnStatus) {
            case 2: goto L14;
            case 5: goto L13;
            default: goto L12;
        };
    L12:
        Log.e("GnssNetworkConnectivityHandler", "Invalid status to release SUPL connection: " + agpsDataConnStatus);
        return;
    L13:
        native_agps_data_conn_failed();
        return;
    L14:
        native_agps_data_conn_closed();
    }

    private void setRouting() {
        boolean result = this.mConnMgr.requestRouteToHostAddress(3, this.mAGpsDataConnectionIpAddr);
        if (result == true) goto L6;
        Log.e("GnssNetworkConnectivityHandler", "Error requesting route to host: " + this.mAGpsDataConnectionIpAddr);
        return;
    L6:
        if (DEBUG == false) goto L10;
        Log.d("GnssNetworkConnectivityHandler", "Successfully requested route to host: " + this.mAGpsDataConnectionIpAddr);
        return;
    }

    private void ensureInHandlerThread() {
        if (this.mHandler == null) goto L8;
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L8;
        return;
    L8:
        throw new IllegalStateException("This method must run on the Handler thread.");
    }

    private String agpsDataConnStateAsString() {
        switch(this.mAGpsDataConnectionState) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        return "OPEN";
    L8:
        return "OPENING";
    L10:
        return "CLOSED";
    L5:
        return "<Unknown>(" + this.mAGpsDataConnectionState + ")";
    }

    private String agpsDataConnStatusAsString(int agpsDataConnStatus) {
        switch(agpsDataConnStatus) {
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "FAILED";
    L7:
        return "DONE";
    L9:
        return "CONNECTED";
    L11:
        return "RELEASE";
    L13:
        return "REQUEST";
    L4:
        return "<Unknown>(" + agpsDataConnStatus + ")";
    }

    private String agpsTypeAsString(int agpsType) {
        switch(agpsType) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L4;
        };
    L5:
        return "IMS";
    L7:
        return "EIMS";
    L9:
        return "C2K";
    L11:
        return "SUPL";
    L4:
        return "<Unknown>(" + agpsType + ")";
    }

    private int getLinkIpType(LinkProperties linkProperties) {
        ensureInHandlerThread();
        boolean isIPv4 = false;
        boolean isIPv6 = false;
        List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
        Iterator<LinkAddress> r3 = linkAddresses.iterator();
    L4:
        if (r3.hasNext() == false) goto L15;
        LinkAddress linkAddress = r3.next();
        InetAddress inetAddress = linkAddress.getAddress();
        if ((inetAddress instanceof Inet4Address) == false) goto L9;
        isIPv4 = true;
    L12:
        if (DEBUG == false) goto L4;
        Log.d("GnssNetworkConnectivityHandler", "LinkAddress : " + inetAddress.toString());
        goto L4
    L9:
        if ((inetAddress instanceof Inet6Address) == false) goto L12;
        isIPv6 = true;
        goto L12
    L15:
        if (isIPv4 == false) goto L19;
        if (isIPv6 == false) goto L19;
        return 3;
    L19:
        if (isIPv4 == false) goto L22;
        return 1;
    L22:
        if (isIPv6 == false) goto L25;
        return 2;
    L25:
        return 0;
    }

    protected boolean isNativeAgpsRilSupported() {
        return native_is_agps_ril_supported();
    }
}
