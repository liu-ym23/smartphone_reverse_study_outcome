package com.android.server.connectivity;

import android.R;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.graphics.Bitmap;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.ConnectivityDiagnosticsManager;
import android.net.ConnectivityManager;
import android.net.INetd;
import android.net.INetworkManagementEventObserver;
import android.net.Ikev2VpnProfile;
import android.net.InetAddresses;
import android.net.IpPrefix;
import android.net.IpSecManager;
import android.net.IpSecTransform;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkAgent;
import android.net.NetworkAgentConfig;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkProvider;
import android.net.NetworkRequest;
import android.net.NetworkScore;
import android.net.NetworkSpecifier;
import android.net.RouteInfo;
import android.net.TelephonyNetworkSpecifier;
import android.net.UidRangeParcel;
import android.net.UnderlyingNetworkInfo;
import android.net.Uri;
import android.net.VpnProfileState;
import android.net.VpnTransportInfo;
import android.net.ipsec.ike.ChildSaProposal;
import android.net.ipsec.ike.ChildSessionCallback;
import android.net.ipsec.ike.ChildSessionConfiguration;
import android.net.ipsec.ike.ChildSessionParams;
import android.net.ipsec.ike.IkeSession;
import android.net.ipsec.ike.IkeSessionCallback;
import android.net.ipsec.ike.IkeSessionConfiguration;
import android.net.ipsec.ike.IkeSessionConnectionInfo;
import android.net.ipsec.ike.IkeSessionParams;
import android.net.ipsec.ike.IkeTunnelConnectionParams;
import android.net.ipsec.ike.exceptions.IkeIOException;
import android.net.ipsec.ike.exceptions.IkeNetworkLostException;
import android.net.ipsec.ike.exceptions.IkeNonProtocolException;
import android.net.ipsec.ike.exceptions.IkeProtocolException;
import android.net.ipsec.ike.exceptions.IkeTimeoutException;
import android.net.vcn.VcnTransportInfo;
import android.net.vcn.util.MtuUtils;
import android.net.vcn.util.PersistableBundleUtils;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.INetworkManagementService;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.security.Credentials;
import android.security.KeyStore2;
import android.system.keystore2.KeyDescriptor;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.LocalLog;
import android.util.Log;
import android.util.Range;
import android.util.SparseArray;
import com.android.internal.net.LegacyVpnInfo;
import com.android.internal.net.VpnConfig;
import com.android.internal.net.VpnProfile;
import com.android.net.module.util.BinderUtils;
import com.android.net.module.util.LinkPropertiesUtils;
import com.android.net.module.util.NetdUtils;
import com.android.net.module.util.NetworkStackConstants;
import com.android.server.DeviceIdleInternal;
import com.android.server.ISmtResourceControl;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.alarm.HeartbeatStats;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import libcore.io.IoUtils;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;

/* JADX INFO: loaded from: classes.dex */
public class Vpn {
    private static final String ANDROID_KEYSTORE_PROVIDER = "AndroidKeyStore";
    public static final int AUTOMATIC_KEEPALIVE_DELAY_SECONDS = 30;
    private static final long[] DATA_STALL_RECOVERY_DELAYS_MS = null;
    static final int DEFAULT_LONG_LIVED_TCP_CONNS_EXPENSIVE_TIMEOUT_SEC = 60;
    static final int DEFAULT_UDP_PORT_4500_NAT_TIMEOUT_SEC_INT = 300;
    private static final long[] IKEV2_VPN_RETRY_DELAYS_MS = null;
    private static final long IKE_DELAY_ON_NC_LP_CHANGE_MS = 300;
    private static final int IKE_SESSION_MAX_RETRY_COUNT = 5;
    private static final String LOCKDOWN_ALLOWLIST_SETTING_NAME = "always_on_vpn_lockdown_whitelist";
    private static final boolean LOGD = true;
    private static final int MAX_EVENTS_LOGS = 100;
    private static final int MAX_MOBIKE_RECOVERY_ATTEMPT = 2;
    static final int MAX_VPN_PROFILE_SIZE_BYTES = 131072;
    private static final String NETWORKTYPE = "VPN";
    public static final int PREFERRED_IKE_PROTOCOL_AUTO = 0;
    public static final int PREFERRED_IKE_PROTOCOL_IPV4_UDP = 40;
    public static final int PREFERRED_IKE_PROTOCOL_IPV6_ESP = 61;
    public static final int PREFERRED_IKE_PROTOCOL_IPV6_UDP = 60;
    private static final int PREFERRED_IKE_PROTOCOL_UNKNOWN = -1;
    private static final long RETRY_DELAY_AUTO_BACKOFF = -1;
    private static final int STARTING_TOKEN = -1;
    private static final String TAG = "Vpn";
    static final String VPN_APP_EXCLUDED = "VPNAPPEXCLUDED_";
    public static String VPN_CONFIG = null;
    public static String VPN_CONFIG_EXTRA = null;
    private static final int VPN_DEFAULT_SCORE = 101;
    public static String VPN_DISCONNECT_REASON = null;
    private static final long VPN_LAUNCH_IDLE_ALLOWLIST_DURATION_MS = 60000;
    private static final long VPN_MANAGER_EVENT_ALLOWLIST_DURATION_MS = 30000;
    private static final String VPN_PROVIDER_NAME_BASE = "VpnNetworkProvider:";
    public static String VPN_STATE_CHANGE;
    public static int VPN_STATE_CONNECTING;
    public static int VPN_STATE_DISCONNECTED;
    public static String VPN_STATE_EXTRA_INT;
    public static String VPN_STATE_INTENT;
    public static int VPN_STATE_NONE;
    public static int VPN_STATE_OFF;
    public static int VPN_STATE_ON;
    protected boolean mAlwaysOn;
    private final AppOpsManager mAppOpsManager;
    private final Set<UidRangeParcel> mBlockedUidsAsToldToConnectivity;
    private final SparseArray<CarrierConfigInfo> mCachedCarrierConfigInfoPerSubId;
    private final CarrierConfigManager mCarrierConfigManager;
    protected VpnConfig mConfig;
    private Intent mConfigIntent;
    private Connection mConnection;
    private final ConnectivityDiagnosticsManager mConnectivityDiagnosticsManager;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    final Dependencies mDeps;
    private volatile boolean mEnableNotif;
    private volatile boolean mEnableTeardown;
    private final LocalLog mEventChanges;
    private final Ikev2SessionCreator mIkev2SessionCreator;
    protected String mInterface;
    private boolean mIsPackageTargetingAtLeastQ;
    private int mLegacyState;
    protected boolean mLockdown;
    private List<String> mLockdownAllowlist;
    private final Looper mLooper;
    private final INetd mNetd;
    protected NetworkAgent mNetworkAgent;
    protected NetworkCapabilities mNetworkCapabilities;
    private final NetworkInfo mNetworkInfo;
    private final NetworkProvider mNetworkProvider;
    private INetworkManagementEventObserver mObserver;
    private int mOwnerUID;
    protected String mPackage;
    private PendingIntent mStatusIntent;
    private final SubscriptionManager mSubscriptionManager;
    private final SystemServices mSystemServices;
    private final TelephonyManager mTelephonyManager;
    private final int mUserId;
    private final Context mUserIdContext;
    private final UserManager mUserManager;
    private final VpnProfileStore mVpnProfileStore;
    protected VpnRunner mVpnRunner;
    private Notification.Builder notification;

    /* JADX INFO: renamed from: com.android.server.connectivity.Vpn$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$net$NetworkInfo$DetailedState = null;

        static {
            $SwitchMap$android$net$NetworkInfo$DetailedState = new int[NetworkInfo.DetailedState.values().length];
            $SwitchMap$android$net$NetworkInfo$DetailedState[NetworkInfo.DetailedState.CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L22:
            $SwitchMap$android$net$NetworkInfo$DetailedState[NetworkInfo.DetailedState.DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L18:
            $SwitchMap$android$net$NetworkInfo$DetailedState[NetworkInfo.DetailedState.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L16:
            $SwitchMap$android$net$NetworkInfo$DetailedState[NetworkInfo.DetailedState.CONNECTING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            return;
        }
    }

    private static class CarrierConfigInfo {
        public final int encapType;
        public final int ipVersion;
        public final int keepaliveDelaySec;
        public final String mccMnc;

        CarrierConfigInfo(String mccMnc, int keepaliveDelaySec, int encapType, int ipVersion) {
            this.mccMnc = mccMnc;
            this.keepaliveDelaySec = keepaliveDelaySec;
            this.encapType = encapType;
            this.ipVersion = ipVersion;
        }

        public String toString() {
            return "CarrierConfigInfo(" + this.mccMnc + ") [keepaliveDelaySec=" + this.keepaliveDelaySec + ", encapType=" + this.encapType + ", ipVersion=" + this.ipVersion + "]";
        }
    }

    private class Connection implements ServiceConnection {
        private IBinder mService;

        /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m3126$$Nest$fgetmService(Connection r0) {
            return r0.mService;
        }

        /* synthetic */ Connection(Vpn r1, VpnIA r2) {
            this(r1);
        }

        private Connection(Vpn r1) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            this.mService = service;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            this.mService = null;
        }
    }

    public static class Dependencies {
        public Dependencies() {
        }

        public boolean isCallerSystem() {
            if (Binder.getCallingUid() != 1000) goto L5;
            return true;
        L5:
            return false;
        }

        public DeviceIdleInternal getDeviceIdleInternal() {
            return (DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class);
        }

        public PendingIntent getIntentForStatusPanel(Context context) {
            return VpnConfig.getIntentForStatusPanel(context);
        }

        public ParcelFileDescriptor adoptFd(Vpn vpn, int mtu) {
            return ParcelFileDescriptor.adoptFd(jniCreate(vpn, mtu));
        }

        public int jniCreate(Vpn vpn, int mtu) {
            return Vpn.m3108$$Nest$mjniCreate(vpn, mtu);
        }

        public String jniGetName(Vpn vpn, int fd) {
            return Vpn.m3109$$Nest$mjniGetName(vpn, fd);
        }

        public int jniSetAddresses(Vpn vpn, String interfaze, String addresses) {
            return Vpn.m3110$$Nest$mjniSetAddresses(vpn, interfaze, addresses);
        }

        public void setBlocking(FileDescriptor fd, boolean blocking) {
            IoUtils.setBlocking(fd, blocking);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalStateException("Cannot set tunnel's fd as blocking=" + blocking, e);
        }

        public long getNextRetryDelayMs(int retryCount) {
            if (retryCount < Vpn.m3118$$Nest$sfgetIKEV2_VPN_RETRY_DELAYS_MS().length) goto L7;
            return Vpn.m3118$$Nest$sfgetIKEV2_VPN_RETRY_DELAYS_MS()[Vpn.m3118$$Nest$sfgetIKEV2_VPN_RETRY_DELAYS_MS().length - 1];
        L7:
            return Vpn.m3118$$Nest$sfgetIKEV2_VPN_RETRY_DELAYS_MS()[retryCount];
        }

        public ScheduledThreadPoolExecutor newScheduledThreadPoolExecutor() {
            return new ScheduledThreadPoolExecutor(1);
        }

        public NetworkAgent newNetworkAgent(Context context, Looper looper, String logTag, NetworkCapabilities nc, LinkProperties lp, NetworkScore score, NetworkAgentConfig config, NetworkProvider provider, ValidationStatusCallback callback) {
            return new VpnNetworkAgentWrapper(context, looper, logTag, nc, lp, score, config, provider, callback);
        }

        public long getValidationFailRecoveryMs(int count) {
            if (count < Vpn.m3117$$Nest$sfgetDATA_STALL_RECOVERY_DELAYS_MS().length) goto L7;
            return Vpn.m3117$$Nest$sfgetDATA_STALL_RECOVERY_DELAYS_MS()[Vpn.m3117$$Nest$sfgetDATA_STALL_RECOVERY_DELAYS_MS().length - 1];
        L7:
            return Vpn.m3117$$Nest$sfgetDATA_STALL_RECOVERY_DELAYS_MS()[count];
        }

        public int getJavaNetworkInterfaceMtu(String iface, int defaultValue) throws SocketException {
            if (iface != null) goto L4;
            return defaultValue;
        L4:
            NetworkInterface networkInterface = NetworkInterface.getByName(iface);
            if (networkInterface != null) goto L8;
            return defaultValue;
        L8:
            return networkInterface.getMTU();
        }

        public int calculateVpnMtu(List<ChildSaProposal> childProposals, int maxMtu, int underlyingMtu, boolean isIpv4) {
            return MtuUtils.getMtu(childProposals, maxMtu, underlyingMtu, isIpv4);
        }

        public void verifyCallingUidAndPackage(Context context, String packageName, int userId) {
            int callingUid = Binder.getCallingUid();
            if (Vpn.m3122$$Nest$smgetAppUid(context, packageName, userId) != callingUid) goto L6;
            return;
        L6:
            throw new SecurityException(packageName + " does not belong to uid " + callingUid);
        }
    }

    public static class IkeSessionWrapper {
        private final IkeSession mImpl;

        public IkeSessionWrapper(IkeSession session) {
            this.mImpl = session;
        }

        public void setNetwork(Network network, int ipVersion, int encapType, int keepaliveDelaySeconds) {
            this.mImpl.setNetwork(network, ipVersion, encapType, keepaliveDelaySeconds);
        }

        public void setUnderpinnedNetwork(Network underpinnedNetwork) {
            this.mImpl.setUnderpinnedNetwork(underpinnedNetwork);
        }

        public void kill() {
            this.mImpl.kill();
        }
    }

    class IkeV2VpnRunner extends VpnRunner implements IkeV2VpnRunnerCallback {
        private static final long NETWORK_LOST_TIMEOUT_MS = 5000;
        private static final String TAG = "IkeV2VpnRunner";
        private Network mActiveNetwork;
        private CarrierConfigManager.CarrierConfigChangeListener mCarrierConfigChangeListener;
        private int mCurrentToken;
        private final ScheduledThreadPoolExecutor mExecutor;
        private IkeSessionConnectionInfo mIkeConnectionInfo;
        private final IpSecManager mIpSecManager;
        private boolean mIsRunning;
        private boolean mMobikeEnabled;
        private final ConnectivityManager.NetworkCallback mNetworkCallback;
        private final Ikev2VpnProfile mProfile;
        private int mRetryCount;
        private ScheduledFuture<?> mScheduledHandleDataStallFuture;
        private ScheduledFuture<?> mScheduledHandleNetworkLostFuture;
        private ScheduledFuture<?> mScheduledHandleRetryIkeSessionFuture;
        private IkeSessionWrapper mSession;
        private final String mSessionKey;
        private IpSecManager.IpSecTunnelInterface mTunnelIface;
        private LinkProperties mUnderlyingLinkProperties;
        private NetworkCapabilities mUnderlyingNetworkCapabilities;
        int mValidationFailRetryCount;
        final /* synthetic */ Vpn this$0;

        public static /* synthetic */ void $r8$lambda$Euak8MHU4Bz6Z3I7uVD0qO8Qdc4(IkeV2VpnRunner r0, int r1, Network r2) {
            r0.lambda$onDefaultNetworkLost$5(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$LGGlfVDEDVU9_W19D9sYlbQ_5JQ(IkeV2VpnRunner r0) {
            r0.lambda$onValidationStatus$2();
        }

        /* JADX INFO: renamed from: $r8$lambda$S-ctvZC1_MvZLKR5QgOK0bNZNW4, reason: not valid java name */
        public static /* synthetic */ void m3127$r8$lambda$SctvZC1_MvZLKR5QgOK0bNZNW4(IkeV2VpnRunner r0) {
            r0.lambda$onValidationStatus$4();
        }

        public static /* synthetic */ void $r8$lambda$dboPwn1sn1Puw6Pt_gTPmOuf1Cg(Runnable r0, ThreadPoolExecutor r1) {
            lambda$new$0(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$hmX2dAqgq5PBx11oqMyybl5FJWs(IkeV2VpnRunner r0) {
            r0.lambda$scheduleStartIkeSession$1();
        }

        /* JADX INFO: renamed from: $r8$lambda$krCDDI3izS-4tQH0Bsj2bPiRWUI, reason: not valid java name */
        public static /* synthetic */ void m3128$r8$lambda$krCDDI3izS4tQH0Bsj2bPiRWUI(IkeV2VpnRunner r0) {
            r0.lambda$exitVpnRunner$6();
        }

        public static /* synthetic */ void $r8$lambda$rgfjfJWtALtNPxDyFfFlPOdICcA(IkeV2VpnRunner r0) {
            r0.lambda$onValidationStatus$3();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmActiveNetwork, reason: not valid java name */
        static /* bridge */ /* synthetic */ Network m3129$$Nest$fgetmActiveNetwork(IkeV2VpnRunner r0) {
            return r0.mActiveNetwork;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCurrentToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m3130$$Nest$fgetmCurrentToken(IkeV2VpnRunner r0) {
            return r0.mCurrentToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmMobikeEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3131$$Nest$fgetmMobikeEnabled(IkeV2VpnRunner r0) {
            return r0.mMobikeEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProfile, reason: not valid java name */
        static /* bridge */ /* synthetic */ Ikev2VpnProfile m3132$$Nest$fgetmProfile(IkeV2VpnRunner r0) {
            return r0.mProfile;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmScheduledHandleDataStallFuture, reason: not valid java name */
        static /* bridge */ /* synthetic */ ScheduledFuture m3133$$Nest$fgetmScheduledHandleDataStallFuture(IkeV2VpnRunner r0) {
            return r0.mScheduledHandleDataStallFuture;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ IkeSessionWrapper m3134$$Nest$fgetmSession(IkeV2VpnRunner r0) {
            return r0.mSession;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSessionKey, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m3135$$Nest$fgetmSessionKey(IkeV2VpnRunner r0) {
            return r0.mSessionKey;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetOrGuessKeepaliveDelaySeconds, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m3136$$Nest$mgetOrGuessKeepaliveDelaySeconds(IkeV2VpnRunner r0) {
            return r0.getOrGuessKeepaliveDelaySeconds();
        }

        IkeV2VpnRunner(Vpn this$0, Ikev2VpnProfile profile, ScheduledThreadPoolExecutor executor) {
            this.this$0 = this$0;
            super(this$0, TAG);
            this.mIsRunning = true;
            this.mCurrentToken = -1;
            this.mMobikeEnabled = false;
            this.mValidationFailRetryCount = 0;
            this.mRetryCount = 0;
            this.mCarrierConfigChangeListener = new AnonymousClass1(this);
            this.mProfile = profile;
            this.mExecutor = executor;
            this.mIpSecManager = (IpSecManager) Vpn.m3092$$Nest$fgetmContext(this$0).getSystemService(INetd.IPSEC_INTERFACE_PREFIX);
            this.mNetworkCallback = new VpnIkev2Utils.Ikev2VpnNetworkCallback(TAG, this, this.mExecutor);
            this.mSessionKey = UUID.randomUUID().toString();
            Log.d(TAG, "Generate session key = " + this.mSessionKey);
            this.mExecutor.setRemoveOnCancelPolicy(true);
            this.mExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.mExecutor.setRejectedExecutionHandler(new Vpn$IkeV2VpnRunner$$ExternalSyntheticLambda3());
            Vpn.m3115$$Nest$msetVpnNetworkPreference(this$0, this.mSessionKey, this$0.createUserAndRestrictedProfilesRanges(Vpn.m3099$$Nest$fgetmUserId(this$0), this$0.mConfig.allowedApplications, this$0.mConfig.disallowedApplications));
            if (Vpn.m3089$$Nest$fgetmCarrierConfigManager(this$0) == null) goto L6;
            Vpn.m3089$$Nest$fgetmCarrierConfigManager(this$0).registerCarrierConfigChangeListener(this.mExecutor, this.mCarrierConfigChangeListener);
            return;
        }

        private static /* synthetic */ void lambda$new$0(Runnable r, ThreadPoolExecutor exe) {
            Log.d(TAG, "Runnable " + r + " rejected by the mExecutor");
        }

        @Override // com.android.server.connectivity.Vpn.VpnRunner, java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.mProfile.isRestrictedToTestNetworks() == false) goto L5;
            NetworkRequest req = new NetworkRequest.Builder().clearCapabilities().addTransportType(7).addCapability(15).build();
            Vpn.m3091$$Nest$fgetmConnectivityManager(this.this$0).requestNetwork(req, this.mNetworkCallback);
            return;
        L5:
            Vpn.m3091$$Nest$fgetmConnectivityManager(this.this$0).registerSystemDefaultNetworkCallback(this.mNetworkCallback, new Handler(Vpn.m3095$$Nest$fgetmLooper(this.this$0)));
        }

        private boolean isActiveNetwork(Network network) {
            if (Objects.equals(this.mActiveNetwork, network) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mIsRunning == false) goto L7;
            return true;
        }

        private boolean isActiveToken(int token) {
            if (this.mCurrentToken == token) goto L5;
        L7:
            return false;
        L5:
            if (this.mIsRunning == false) goto L7;
            return true;
        }

        @Override // com.android.server.connectivity.Vpn.IkeV2VpnRunnerCallback
        public void onIkeOpened(int token, IkeSessionConfiguration ikeConfiguration) {
            if (isActiveToken(token) == true) goto L6;
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKEEvent-" + this.mSessionKey + "] onIkeOpened obsolete token=" + token);
            StringBuilder r0 = new StringBuilder();
            r0.append("onIkeOpened called for obsolete token ");
            r0.append(token);
            Log.d(TAG, r0.toString());
            return;
        L6:
            this.mMobikeEnabled = ikeConfiguration.isIkeExtensionEnabled(2);
            IkeSessionConnectionInfo info = ikeConfiguration.getIkeSessionConnectionInfo();
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKEEvent-" + this.mSessionKey + "] onIkeOpened token=" + token + ", localAddr=" + info.getLocalAddress() + ", network=" + info.getNetwork() + ", mobikeEnabled= " + this.mMobikeEnabled);
            onIkeConnectionInfoChanged(token, info);
        }

        @Override // com.android.server.connectivity.Vpn.IkeV2VpnRunnerCallback
        public void onIkeConnectionInfoChanged(int token, IkeSessionConnectionInfo ikeConnectionInfo) {
            if (isActiveToken(token) == true) goto L6;
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKEEvent-" + this.mSessionKey + "] onIkeConnectionInfoChanged obsolete token=" + token);
            StringBuilder r0 = new StringBuilder();
            r0.append("onIkeConnectionInfoChanged called for obsolete token ");
            r0.append(token);
            Log.d(TAG, r0.toString());
            return;
        L6:
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKEEvent-" + this.mSessionKey + "] onIkeConnectionInfoChanged token=" + token + ", localAddr=" + ikeConnectionInfo.getLocalAddress() + ", network=" + ikeConnectionInfo.getNetwork());
            this.mIkeConnectionInfo = ikeConnectionInfo;
        }

        @Override // com.android.server.connectivity.Vpn.IkeV2VpnRunnerCallback
        public void onChildOpened(int token, ChildSessionConfiguration childConfig) {
            if (isActiveToken(token) == true) goto L6;
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKEEvent-" + this.mSessionKey + "] onChildOpened obsolete token=" + token);
            StringBuilder r1 = new StringBuilder();
            r1.append("onChildOpened called for obsolete token ");
            r1.append(token);
            Log.d(TAG, r1.toString());
            return;
        L6:
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKEEvent-" + this.mSessionKey + "] onChildOpened token=" + token + ", addr=" + TextUtils.join(", ", childConfig.getInternalAddresses()) + " dns=" + TextUtils.join(", ", childConfig.getInternalDnsServers()));
            String interfaceName = this.mTunnelIface.getInterfaceName();     // Catch: Exception -> L13
            List<LinkAddress> internalAddresses = childConfig.getInternalAddresses();     // Catch: Exception -> L13
            ArrayList r2 = new ArrayList();     // Catch: Exception -> L13
            int vpnMtu = calculateVpnMtu();     // Catch: Exception -> L13
            if (Vpn.m3124$$Nest$smisIPv6Only(internalAddresses) == true) goto L10;
        L15:
            Collection<RouteInfo> newRoutes = VpnIkev2Utils.getRoutesFromTrafficSelectors(childConfig.getOutboundTrafficSelectors());     // Catch: Exception -> L13
            Iterator<LinkAddress> r5 = internalAddresses.iterator();     // Catch: Exception -> L13
        L17:
            if (r5.hasNext() == false) goto L19;
            LinkAddress address = r5.next();     // Catch: Exception -> L13
            this.mTunnelIface.addAddress(address.getAddress(), address.getPrefixLength());     // Catch: Exception -> L13
            goto L17
        L19:
            Iterator r6 = childConfig.getInternalDnsServers().iterator();     // Catch: Exception -> L13
        L21:
            if (r6.hasNext() == false) goto L23;
            InetAddress addr = (InetAddress) r6.next();     // Catch: Exception -> L13
            r2.add(addr.getHostAddress());     // Catch: Exception -> L13
            goto L21
        L23:
            Network network = this.mIkeConnectionInfo.getNetwork();     // Catch: Exception -> L13
            Vpn r7 = this.this$0;     // Catch: Exception -> L13
            monitor-enter(r7);     // Catch: Exception -> L13
        L29:
            th = move-exception;
            throw th;     // Catch: Exception -> L13
        L26:
            if (this.this$0.mVpnRunner == this) goto L31;
            monitor-exit(r7);     // Catch: Throwable -> L29
            return;
        L31:
            this.this$0.mInterface = interfaceName;     // Catch: Throwable -> L29
            this.this$0.mConfig.mtu = vpnMtu;     // Catch: Throwable -> L29
            this.this$0.mConfig.interfaze = this.this$0.mInterface;     // Catch: Throwable -> L29
            this.this$0.mConfig.addresses.clear();     // Catch: Throwable -> L29
            this.this$0.mConfig.addresses.addAll(internalAddresses);     // Catch: Throwable -> L29
            this.this$0.mConfig.routes.clear();     // Catch: Throwable -> L29
            this.this$0.mConfig.routes.addAll(newRoutes);     // Catch: Throwable -> L29
            if (this.this$0.mConfig.dnsServers != null) goto L34;
            this.this$0.mConfig.dnsServers = new ArrayList();     // Catch: Throwable -> L29
        L34:
            this.this$0.mConfig.dnsServers.clear();     // Catch: Throwable -> L29
            this.this$0.mConfig.dnsServers.addAll(r2);     // Catch: Throwable -> L29
            this.this$0.mConfig.underlyingNetworks = new Network[]{network};     // Catch: Throwable -> L29
            NetworkAgent networkAgent = this.this$0.mNetworkAgent;     // Catch: Throwable -> L29
            if (networkAgent == null) goto L37;
            LinkProperties lp = Vpn.m3111$$Nest$mmakeLinkProperties(this.this$0);     // Catch: Throwable -> L29
            monitor-exit(r7);     // Catch: Throwable -> L29
            Vpn.m3120$$Nest$smdoSendLinkProperties(networkAgent, lp);     // Catch: Exception -> L13
            this.mRetryCount = 0;     // Catch: Exception -> L13
            return;
        L37:
            if (Vpn.m3106$$Nest$misSettingsVpnLocked(this.this$0) == false) goto L39;
            Vpn.m3113$$Nest$mprepareStatusIntent(this.this$0);     // Catch: Throwable -> L29
        L39:
            Vpn.m3100$$Nest$magentConnect(this.this$0, new Vpn$IkeV2VpnRunner$$ExternalSyntheticLambda4(this));     // Catch: Throwable -> L29
            monitor-exit(r7);     // Catch: Throwable -> L29
            return;
        L10:
            if (vpnMtu >= 1280) goto L15;
            onSessionLost(token, new IkeIOException(new IOException("No valid addresses for MTU < 1280")));     // Catch: Exception -> L13
            return;
        L13:
            e = move-exception;
            Log.d(TAG, "Error in ChildOpened for token " + token, e);
            onSessionLost(token, e);
        }

        @Override // com.android.server.connectivity.Vpn.IkeV2VpnRunnerCallback
        public void onChildTransformCreated(int token, IpSecTransform transform, int direction) {
            if (isActiveToken(token) == true) goto L6;
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKEEvent-" + this.mSessionKey + "] onChildTransformCreated obsolete token=" + token);
            StringBuilder r0 = new StringBuilder();
            r0.append("ChildTransformCreated for obsolete token ");
            r0.append(token);
            Log.d(TAG, r0.toString());
            return;
        L6:
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKEEvent-" + this.mSessionKey + "] onChildTransformCreated token=" + token + ", direction=" + direction + ", transform=" + transform);
            this.mTunnelIface.setUnderlyingNetwork(this.mIkeConnectionInfo.getNetwork());     // Catch: Throwable -> L9
            this.mIpSecManager.applyTunnelModeTransform(this.mTunnelIface, direction, transform);     // Catch: Throwable -> L9
            return;
        L9:
            e = move-exception;
            Log.d(TAG, "Transform application failed for token " + token, e);
            onSessionLost(token, e);
        }

        @Override // com.android.server.connectivity.Vpn.IkeV2VpnRunnerCallback
        public void onChildMigrated(int token, IpSecTransform inTransform, IpSecTransform outTransform) {
            if (isActiveToken(token) == true) goto L6;
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKEEvent-" + this.mSessionKey + "] onChildMigrated obsolete token=" + token);
            StringBuilder r1 = new StringBuilder();
            r1.append("onChildMigrated for obsolete token ");
            r1.append(token);
            Log.d(TAG, r1.toString());
            return;
        L6:
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKEEvent-" + this.mSessionKey + "] onChildMigrated token=" + token + ", in=" + inTransform + ", out=" + outTransform);
            Network network = this.mIkeConnectionInfo.getNetwork();
            Vpn r2 = this.this$0;     // Catch: Throwable -> L33
            monitor-enter(r2);     // Catch: Throwable -> L33
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L33 Throwable -> L33
        L10:
            if (this.this$0.mVpnRunner == this) goto L15;
            monitor-exit(r2);     // Catch: Throwable -> L13
            return;
        L15:
            LinkProperties oldLp = Vpn.m3111$$Nest$mmakeLinkProperties(this.this$0);     // Catch: Throwable -> L13
            this.this$0.mConfig.underlyingNetworks = new Network[]{network};     // Catch: Throwable -> L13
            this.this$0.mConfig.mtu = calculateVpnMtu();     // Catch: Throwable -> L13
            LinkProperties newLp = Vpn.m3111$$Nest$mmakeLinkProperties(this.this$0);     // Catch: Throwable -> L13
            if (newLp.getLinkAddresses().isEmpty() == false) goto L20;
            onSessionLost(token, new IkeIOException(new IOException("No valid addresses for MTU < 1280")));     // Catch: Throwable -> L13
            monitor-exit(r2);     // Catch: Throwable -> L13
            return;
        L20:
            Set<LinkAddress> removedAddrs = new HashSet(oldLp.getLinkAddresses());     // Catch: Throwable -> L13
            removedAddrs.removeAll(newLp.getLinkAddresses());     // Catch: Throwable -> L13
            if (removedAddrs.isEmpty() == true) goto L28;
            Vpn.m3116$$Nest$mstartNewNetworkAgent(this.this$0, this.this$0.mNetworkAgent, "MTU too low for IPv6; restarting network agent");     // Catch: Throwable -> L13
            Iterator<LinkAddress> r7 = removedAddrs.iterator();     // Catch: Throwable -> L13
        L24:
            if (r7.hasNext() == false) goto L30;
            LinkAddress removed = r7.next();     // Catch: Throwable -> L13
            this.mTunnelIface.removeAddress(removed.getAddress(), removed.getPrefixLength());     // Catch: Throwable -> L13
        L30:
            monitor-exit(r2);     // Catch: Throwable -> L13
            this.mTunnelIface.setUnderlyingNetwork(network);     // Catch: Throwable -> L33 Throwable -> L33
            this.mIpSecManager.applyTunnelModeTransform(this.mTunnelIface, 0, inTransform);     // Catch: Throwable -> L33 Throwable -> L33
            this.mIpSecManager.applyTunnelModeTransform(this.mTunnelIface, 1, outTransform);     // Catch: Throwable -> L33 Throwable -> L33
            return;
        L28:
            if (newLp.equals(oldLp) == true) goto L30;
            Vpn.m3120$$Nest$smdoSendLinkProperties(this.this$0.mNetworkAgent, newLp);     // Catch: Throwable -> L13
        L33:
            e = move-exception;
            Log.d(TAG, "Transform application failed for token " + token, e);
            onSessionLost(token, e);
        }

        @Override // com.android.server.connectivity.Vpn.IkeV2VpnRunnerCallback
        public void onDefaultNetworkChanged(Network network) {
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[UnderlyingNW] Default network changed to " + network);
            Log.d(TAG, "onDefaultNetworkChanged: " + network);
            cancelRetryNewIkeSessionFuture();
            cancelHandleNetworkLostTimeout();
            if (this.mIsRunning == true) goto L6;
            Log.d(TAG, "onDefaultNetworkChanged after exit");
            return;
        L6:
            this.mActiveNetwork = network;
            this.mUnderlyingLinkProperties = null;
            this.mUnderlyingNetworkCapabilities = null;
            this.mRetryCount = 0;
        }

        private IkeSessionParams getIkeSessionParams(Network underlyingNetwork) {
            IkeTunnelConnectionParams ikeTunConnParams = this.mProfile.getIkeTunnelConnectionParams();
            if (ikeTunConnParams == null) goto L5;
            IkeSessionParams.Builder builder = new IkeSessionParams.Builder(ikeTunConnParams.getIkeSessionParams()).setNetwork(underlyingNetwork);
        L7:
            if (this.mProfile.isAutomaticNattKeepaliveTimerEnabled() == false) goto L10;
            builder.setNattKeepAliveDelaySeconds(guessNattKeepaliveTimerForNetwork());
        L10:
            if (this.mProfile.isAutomaticIpVersionSelectionEnabled() == false) goto L13;
            builder.setIpVersion(guessEspIpVersionForNetwork());
            builder.setEncapType(guessEspEncapTypeForNetwork());
        L13:
            return builder.build();
        L5:
            builder = VpnIkev2Utils.makeIkeSessionParamsBuilder(Vpn.m3092$$Nest$fgetmContext(this.this$0), this.mProfile, underlyingNetwork);
            goto L7
        }

        private ChildSessionParams getChildSessionParams() {
            IkeTunnelConnectionParams ikeTunConnParams = this.mProfile.getIkeTunnelConnectionParams();
            if (ikeTunConnParams == null) goto L7;
            return ikeTunConnParams.getTunnelModeChildSessionParams();
        L7:
            return VpnIkev2Utils.buildChildSessionParams(this.mProfile.getAllowedAlgorithms());
        }

        private int calculateVpnMtu() {
            Network underlyingNetwork = this.mIkeConnectionInfo.getNetwork();
            LinkProperties lp = Vpn.m3091$$Nest$fgetmConnectivityManager(this.this$0).getLinkProperties(underlyingNetwork);
            if (underlyingNetwork == null) goto L16;
            if (lp == null) goto L16;
            int underlyingMtu = lp.getMtu();
            if (underlyingMtu != 0) goto L14;
            underlyingMtu = this.this$0.mDeps.getJavaNetworkInterfaceMtu(lp.getInterfaceName(), this.mProfile.getMaxMtu());     // Catch: SocketException -> L10
        L10:
            e = move-exception;
            Log.d(TAG, "Got a SocketException when getting MTU from kernel: " + e);
            return this.mProfile.getMaxMtu();
        L14:
            return this.this$0.mDeps.calculateVpnMtu(getChildSessionParams().getSaProposals(), this.mProfile.getMaxMtu(), underlyingMtu, this.mIkeConnectionInfo.getLocalAddress() instanceof Inet4Address);
        L16:
            return this.mProfile.getMaxMtu();
        }

        private void startOrMigrateIkeSession(Network underlyingNetwork) {
            Vpn r0 = this.this$0;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mVpnRunner == this) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            Vpn.m3115$$Nest$msetVpnNetworkPreference(this.this$0, this.mSessionKey, this.this$0.createUserAndRestrictedProfilesRanges(Vpn.m3099$$Nest$fgetmUserId(this.this$0), this.this$0.mConfig.allowedApplications, this.this$0.mConfig.disallowedApplications));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            if (underlyingNetwork != null) goto L15;
            Log.d(TAG, "There is no active network for starting an IKE session");
            return;
        L15:
            List<Network> networks = Collections.singletonList(underlyingNetwork);
            if (networks.equals(this.this$0.mNetworkCapabilities.getUnderlyingNetworks()) == true) goto L21;
            Vpn r1 = this.this$0;
            r1.mNetworkCapabilities = new NetworkCapabilities.Builder(this.this$0.mNetworkCapabilities).setUnderlyingNetworks(networks).build();
            if (this.this$0.mNetworkAgent == null) goto L21;
            Vpn.m3103$$Nest$mdoSetUnderlyingNetworks(this.this$0, this.this$0.mNetworkAgent, networks);
        L21:
            if (maybeMigrateIkeSessionAndUpdateVpnTransportInfo(underlyingNetwork) == false) goto L23;
            return;
        L23:
            startIkeSession(underlyingNetwork);
        }

        private int guessEspIpVersionForNetwork() {
            int ipVersion = 0;
            if ((this.mUnderlyingNetworkCapabilities.getTransportInfo() instanceof VcnTransportInfo) == false) goto L6;
            Log.d(TAG, "Running over VCN, esp IP version is auto");
            return 0;
        L6:
            CarrierConfigInfo carrierconfig = getCarrierConfigForUnderlyingNetwork();
            if (carrierconfig == null) goto L10;
            ipVersion = carrierconfig.ipVersion;
        L10:
            if (carrierconfig == null) goto L12;
            Log.d(TAG, "Get customized IP version (" + ipVersion + ") on SIM (mccmnc=" + carrierconfig.mccMnc + ")");
        L12:
            return ipVersion;
        }

        private int guessEspEncapTypeForNetwork() {
            int encapType = 0;
            if ((this.mUnderlyingNetworkCapabilities.getTransportInfo() instanceof VcnTransportInfo) == false) goto L6;
            Log.d(TAG, "Running over VCN, encap type is auto");
            return 0;
        L6:
            CarrierConfigInfo carrierconfig = getCarrierConfigForUnderlyingNetwork();
            if (carrierconfig == null) goto L10;
            encapType = carrierconfig.encapType;
        L10:
            if (carrierconfig == null) goto L12;
            Log.d(TAG, "Get customized encap type (" + encapType + ") on SIM (mccmnc=" + carrierconfig.mccMnc + ")");
        L12:
            return encapType;
        }

        private int guessNattKeepaliveTimerForNetwork() {
            VcnTransportInfo r0 = this.mUnderlyingNetworkCapabilities.getTransportInfo();
            if ((r0 instanceof VcnTransportInfo) == false) goto L7;
            int nattKeepaliveSec = r0.getMinUdpPort4500NatTimeoutSeconds();
            Log.d(TAG, "Running over VCN, keepalive timer : " + nattKeepaliveSec + "s");
            if ((-1) == nattKeepaliveSec) goto L7;
            return nattKeepaliveSec;
        L7:
            CarrierConfigInfo carrierconfig = getCarrierConfigForUnderlyingNetwork();
            if (carrierconfig == null) goto L10;
            int nattKeepaliveSec2 = carrierconfig.keepaliveDelaySec;
        L11:
            if (carrierconfig == null) goto L13;
            Log.d(TAG, "Get customized keepalive (" + nattKeepaliveSec2 + "s) on SIM (mccmnc=" + carrierconfig.mccMnc + ")");
        L13:
            return nattKeepaliveSec2;
        L10:
            nattKeepaliveSec2 = 30;
            goto L11
        }

        private CarrierConfigInfo getCarrierConfigForUnderlyingNetwork() {
            if (Vpn.m3089$$Nest$fgetmCarrierConfigManager(this.this$0) != null) goto L5;
            return null;
        L5:
            int subId = Vpn.m3123$$Nest$smgetCellSubIdForNetworkCapabilities(this.mUnderlyingNetworkCapabilities);
            if (subId != (-1)) goto L9;
            Log.d(TAG, "Underlying network is not a cellular network");
            return null;
        L9:
            Vpn r3 = this.this$0;
            monitor-enter(r3);
        L16:
            th = move-exception;
            throw th;
        L12:
            if (Vpn.m3088$$Nest$fgetmCachedCarrierConfigInfoPerSubId(this.this$0).contains(subId) == false) goto L18;
            Log.d(TAG, "Get cached config");     // Catch: Throwable -> L16
            CarrierConfigInfo r1 = (CarrierConfigInfo) Vpn.m3088$$Nest$fgetmCachedCarrierConfigInfoPerSubId(this.this$0).get(subId);     // Catch: Throwable -> L16
            monitor-exit(r3);     // Catch: Throwable -> L16
            return r1;
        L18:
            monitor-exit(r3);     // Catch: Throwable -> L16
            TelephonyManager perSubTm = Vpn.m3098$$Nest$fgetmTelephonyManager(this.this$0).createForSubscriptionId(subId);
            if (perSubTm.getSimApplicationState() == 10) goto L23;
            Log.d(TAG, "SIM card is not ready on sub " + subId);
            return null;
        L23:
            PersistableBundle carrierConfig = Vpn.m3089$$Nest$fgetmCarrierConfigManager(this.this$0).getConfigForSubId(subId);
            if (CarrierConfigManager.isConfigForIdentifiedCarrier(carrierConfig) == true) goto L26;
            return null;
        L26:
            int natKeepalive = carrierConfig.getInt("min_udp_port_4500_nat_timeout_sec_int");
            int preferredIpProtocol = carrierConfig.getInt("preferred_ike_protocol_int", -1);
            String mccMnc = perSubTm.getSimOperator(subId);
            CarrierConfigInfo info = buildCarrierConfigInfo(mccMnc, natKeepalive, preferredIpProtocol);
            Vpn r8 = this.this$0;
            monitor-enter(r8);
            Vpn.m3088$$Nest$fgetmCachedCarrierConfigInfoPerSubId(this.this$0).put(subId, info);     // Catch: Throwable -> L31
            monitor-exit(r8);     // Catch: Throwable -> L31
            return info;
        L31:
            th = move-exception;
            throw th;
        }

        private CarrierConfigInfo buildCarrierConfigInfo(String mccMnc, int natKeepalive, int preferredIpPortocol) {
            switch(preferredIpPortocol) {
                case 0: goto L7;
                case 40: goto L6;
                case 60: goto L5;
                case 61: goto L4;
                default: goto L3;
            };
        L3:
            int ipVersion = 4;
            int encapType = 17;
        L9:
            return new CarrierConfigInfo(mccMnc, natKeepalive, encapType, ipVersion);
        L4:
            ipVersion = 6;
            encapType = -1;
            goto L9
        L5:
            ipVersion = 6;
            encapType = 17;
            goto L9
        L6:
            ipVersion = 4;
            encapType = 17;
            goto L9
        L7:
            ipVersion = 0;
            encapType = 0;
            goto L9
        }

        private int getOrGuessKeepaliveDelaySeconds() {
            if (this.mProfile.isAutomaticNattKeepaliveTimerEnabled() == false) goto L7;
            return guessNattKeepaliveTimerForNetwork();
        L7:
            if (this.mProfile.getIkeTunnelConnectionParams() != null) goto L9;
            return 300;
        L9:
            return this.mProfile.getIkeTunnelConnectionParams().getIkeSessionParams().getNattKeepAliveDelaySeconds();
        }

        boolean maybeMigrateIkeSessionAndUpdateVpnTransportInfo(Network underlyingNetwork) {
            int keepaliveDelaySec = getOrGuessKeepaliveDelaySeconds();
            boolean migrated = maybeMigrateIkeSession(underlyingNetwork, keepaliveDelaySec);
            if (migrated == false) goto L5;
            updateVpnTransportInfoAndNetCap(keepaliveDelaySec);
        L5:
            return migrated;
        }

        public void updateVpnTransportInfoAndNetCap(int keepaliveDelaySec) {
            Vpn r0 = this.this$0;
            monitor-enter(r0);
            int r2 = this.this$0.getActiveVpnType();     // Catch: Throwable -> L9
            String r3 = this.this$0.mConfig.session;     // Catch: Throwable -> L9
            if (this.this$0.mConfig.allowBypass == true) goto L7;
        L11:
            boolean r4 = false;
        L12:
            VpnTransportInfo info = new VpnTransportInfo(r2, r3, r4, Vpn.m3119$$Nest$smareLongLivedTcpConnectionsExpensive(keepaliveDelaySec));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            boolean ncUpdateRequired = !info.equals(this.this$0.mNetworkCapabilities.getTransportInfo());
            if (ncUpdateRequired == false) goto L22;
            this.this$0.mNetworkCapabilities = new NetworkCapabilities.Builder(this.this$0.mNetworkCapabilities).setTransportInfo(info).build();
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[VPNRunner] Update agent caps " + this.this$0.mNetworkCapabilities);
            Vpn.m3121$$Nest$smdoSendNetworkCapabilities(this.this$0.mNetworkAgent, this.this$0.mNetworkCapabilities);
            return;
        L22:
            return;
        L7:
            if (this.this$0.mLockdown == true) goto L11;
            r4 = true;
        L9:
            th = move-exception;
            throw th;
        }

        private boolean maybeMigrateIkeSession(Network underlyingNetwork, int keepaliveDelaySeconds) {
            if (this.mSession != null) goto L5;
            return false;
        L5:
            if (this.mMobikeEnabled == false) goto L18;
            Log.d(TAG, "Migrate IKE Session with token " + this.mCurrentToken + " to network " + underlyingNetwork);
            if (this.mProfile.isAutomaticIpVersionSelectionEnabled() == false) goto L11;
            int ipVersion = guessEspIpVersionForNetwork();
            int encapType = guessEspEncapTypeForNetwork();
        L14:
            this.mSession.setNetwork(underlyingNetwork, ipVersion, encapType, keepaliveDelaySeconds);
            return true;
        L11:
            if (this.mProfile.getIkeTunnelConnectionParams() == null) goto L13;
            ipVersion = this.mProfile.getIkeTunnelConnectionParams().getIkeSessionParams().getIpVersion();
            encapType = this.mProfile.getIkeTunnelConnectionParams().getIkeSessionParams().getEncapType();
            goto L14
        L13:
            ipVersion = 0;
            encapType = 0;
            goto L14
        L18:
            return false;
        }

        private void startIkeSession(Network underlyingNetwork) {
            Log.d(TAG, "Start new IKE session on network " + underlyingNetwork);
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[IKE] Start IKE session over " + underlyingNetwork);
            Vpn r1 = this.this$0;     // Catch: Exception -> L15
            monitor-enter(r1);     // Catch: Exception -> L15
        L9:
            th = move-exception;
            throw th;     // Catch: Exception -> L15
        L6:
            if (this.this$0.mVpnRunner == this) goto L11;
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L11:
            this.this$0.mInterface = null;     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            resetIkeState();     // Catch: Exception -> L15
            InetAddress address = InetAddress.getLocalHost();     // Catch: Exception -> L15
            this.mTunnelIface = this.mIpSecManager.createIpSecTunnelInterface(address, address, underlyingNetwork);     // Catch: Exception -> L15
            NetdUtils.setInterfaceUp(Vpn.m3096$$Nest$fgetmNetd(this.this$0), this.mTunnelIface.getInterfaceName());     // Catch: Exception -> L15
            int token = this.mCurrentToken + 1;     // Catch: Exception -> L15
            this.mCurrentToken = token;     // Catch: Exception -> L15
            this.mSession = Vpn.m3094$$Nest$fgetmIkev2SessionCreator(this.this$0).createIkeSession(Vpn.m3092$$Nest$fgetmContext(this.this$0), getIkeSessionParams(underlyingNetwork), getChildSessionParams(), this.mExecutor, new VpnIkev2Utils.IkeSessionCallbackImpl(TAG, this, token), new VpnIkev2Utils.ChildSessionCallbackImpl(TAG, this, token));     // Catch: Exception -> L15
            Log.d(TAG, "IKE session started for token " + token);     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            Log.i(TAG, "Setup failed for token " + this.mCurrentToken + ". Aborting", e);
            onSessionLost(this.mCurrentToken, e);
        }

        private void scheduleStartIkeSession(long delayMs) {
            if (this.mScheduledHandleRetryIkeSessionFuture == null) goto L7;
            Log.d(TAG, "There is a pending retrying task, skip the new retrying task");
            return;
        L7:
            if ((-1) == delayMs) goto L9;
            long retryDelayMs = delayMs;
        L10:
            Log.d(TAG, "Retry new IKE session after " + retryDelayMs + " milliseconds.");
            this.mScheduledHandleRetryIkeSessionFuture = this.mExecutor.schedule(new Vpn$IkeV2VpnRunner$$ExternalSyntheticLambda7(this), retryDelayMs, TimeUnit.MILLISECONDS);
            return;
        L9:
            Dependencies r0 = this.this$0.mDeps;
            int r2 = this.mRetryCount;
            this.mRetryCount = r2 + 1;
            retryDelayMs = r0.getNextRetryDelayMs(r2);
            goto L10
        }

        private /* synthetic */ void lambda$scheduleStartIkeSession$1() {
            startOrMigrateIkeSession(this.mActiveNetwork);
            this.mScheduledHandleRetryIkeSessionFuture = null;
        }

        private boolean significantCapsChange(NetworkCapabilities left, NetworkCapabilities right) {
            if (left != right) goto L5;
            return false;
        L5:
            if (left == null) goto L21;
            if (right == null) goto L21;
            if (Arrays.equals(left.getTransportTypes(), right.getTransportTypes()) == false) goto L21;
            if (Arrays.equals(left.getCapabilities(), right.getCapabilities()) == false) goto L21;
            if (Arrays.equals(left.getEnterpriseIds(), right.getEnterpriseIds()) == false) goto L21;
            if (Objects.equals(left.getTransportInfo(), right.getTransportInfo()) == false) goto L21;
            if (Objects.equals(left.getAllowedUids(), right.getAllowedUids()) == false) goto L21;
            if (Objects.equals(left.getUnderlyingNetworks(), right.getUnderlyingNetworks()) == false) goto L21;
            if (Objects.equals(left.getNetworkSpecifier(), right.getNetworkSpecifier()) == false) goto L21;
            return false;
        L21:
            return true;
        }

        @Override // com.android.server.connectivity.Vpn.IkeV2VpnRunnerCallback
        public void onDefaultNetworkCapabilitiesChanged(NetworkCapabilities nc) {
            if (significantCapsChange(this.mUnderlyingNetworkCapabilities, nc) == false) goto L5;
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[UnderlyingNW] Cap changed from " + this.mUnderlyingNetworkCapabilities + " to " + nc);
        L5:
            NetworkCapabilities oldNc = this.mUnderlyingNetworkCapabilities;
            this.mUnderlyingNetworkCapabilities = nc;
            if (oldNc != null) goto L8;
        L9:
            scheduleStartIkeSession(Vpn.IKE_DELAY_ON_NC_LP_CHANGE_MS);
            return;
        L8:
            if (nc.getSubscriptionIds().equals(oldNc.getSubscriptionIds()) == false) goto L9;
        }

        @Override // com.android.server.connectivity.Vpn.IkeV2VpnRunnerCallback
        public void onDefaultNetworkLinkPropertiesChanged(LinkProperties lp) {
            LinkProperties oldLp = this.mUnderlyingLinkProperties;
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[UnderlyingNW] Lp changed from " + oldLp + " to " + lp);
            this.mUnderlyingLinkProperties = lp;
            if (oldLp != null) goto L5;
        L6:
            scheduleStartIkeSession(Vpn.IKE_DELAY_ON_NC_LP_CHANGE_MS);
            return;
        L5:
            if (LinkPropertiesUtils.isIdenticalAllLinkAddresses(oldLp, lp) == false) goto L6;
        }

        public void onValidationStatus(int status) {
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[Validation] validation status " + status);
            if (status != 1) goto L6;
            this.mExecutor.execute(new Vpn$IkeV2VpnRunner$$ExternalSyntheticLambda0(this));
            return;
        L6:
            if (this.mScheduledHandleDataStallFuture == null) goto L9;
            return;
        L9:
            if (this.mValidationFailRetryCount != 0) goto L12;
            Vpn.m3091$$Nest$fgetmConnectivityManager(this.this$0).reportNetworkConnectivity(this.mActiveNetwork, false);
        L12:
            if (this.mValidationFailRetryCount >= 2) goto L15;
            Log.d(TAG, "Validation failed");
            ScheduledThreadPoolExecutor r0 = this.mExecutor;
            Runnable r1 = new Vpn$IkeV2VpnRunner$$ExternalSyntheticLambda1(this);
            Dependencies r2 = this.this$0.mDeps;
            int r3 = this.mValidationFailRetryCount;
            this.mValidationFailRetryCount = r3 + 1;
            r0.schedule(r1, r2.getValidationFailRecoveryMs(r3), TimeUnit.MILLISECONDS);
            return;
        L15:
            ScheduledThreadPoolExecutor r4 = this.mExecutor;
            Runnable r5 = new Vpn$IkeV2VpnRunner$$ExternalSyntheticLambda2(this);
            Dependencies r6 = this.this$0.mDeps;
            int r7 = this.mValidationFailRetryCount;
            this.mValidationFailRetryCount = r7 + 1;
            this.mScheduledHandleDataStallFuture = r4.schedule(r5, r6.getValidationFailRecoveryMs(r7), TimeUnit.MILLISECONDS);
        }

        private /* synthetic */ void lambda$onValidationStatus$2() {
            this.mValidationFailRetryCount = 0;
            if (this.mScheduledHandleDataStallFuture == null) goto L6;
            Log.d(TAG, "Recovered from stall. Cancel pending reset action.");
            this.mScheduledHandleDataStallFuture.cancel(false);
            this.mScheduledHandleDataStallFuture = null;
            return;
        }

        private /* synthetic */ void lambda$onValidationStatus$3() {
            maybeMigrateIkeSessionAndUpdateVpnTransportInfo(this.mActiveNetwork);
        }

        private /* synthetic */ void lambda$onValidationStatus$4() {
            if (this.mValidationFailRetryCount <= 0) goto L5;
            Log.d(TAG, "Reset session to recover stalled network");
            startIkeSession(this.mActiveNetwork);
        L5:
            this.mScheduledHandleDataStallFuture = null;
        }

        @Override // com.android.server.connectivity.Vpn.IkeV2VpnRunnerCallback
        public void onDefaultNetworkLost(final Network network) {
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[UnderlyingNW] Network lost " + network);
            cancelRetryNewIkeSessionFuture();
            if (isActiveNetwork(network) == true) goto L6;
            Log.d(TAG, "onDefaultNetworkLost called for obsolete network " + network);
            return;
        L6:
            this.mActiveNetwork = null;
            this.mUnderlyingNetworkCapabilities = null;
            this.mUnderlyingLinkProperties = null;
            if (this.mScheduledHandleNetworkLostFuture == null) goto L10;
            IllegalStateException exception = new IllegalStateException("Found a pending mScheduledHandleNetworkLostFuture");
            Log.i(TAG, "Unexpected error in onDefaultNetworkLost. Tear down session", exception);
            handleSessionLost(exception, network);
            return;
        L10:
            Log.d(TAG, "Schedule a delay handleSessionLost for losing network " + network + " on session with token " + this.mCurrentToken);
            final int token = this.mCurrentToken;
            this.mScheduledHandleNetworkLostFuture = this.mExecutor.schedule(new Vpn$IkeV2VpnRunner$$ExternalSyntheticLambda6(this, token, network), NETWORK_LOST_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        }

        private /* synthetic */ void lambda$onDefaultNetworkLost$5(int token, Network network) {
            if (isActiveToken(token) == false) goto L17;
            handleSessionLost(new IkeNetworkLostException(network), network);
            Vpn r0 = this.this$0;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L7:
            if (this.this$0.mVpnRunner == this) goto L12;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L12:
            this.this$0.updateState(NetworkInfo.DetailedState.DISCONNECTED, "Network lost");     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
        L18:
            this.mScheduledHandleNetworkLostFuture = null;
            return;
        L17:
            Log.d(TAG, "Scheduled handleSessionLost fired for obsolete token " + token);
            goto L18
        }

        private void cancelHandleNetworkLostTimeout() {
            if (this.mScheduledHandleNetworkLostFuture == null) goto L6;
            Log.d(TAG, "Cancel the task for handling network lost timeout");
            this.mScheduledHandleNetworkLostFuture.cancel(false);
            this.mScheduledHandleNetworkLostFuture = null;
            return;
        }

        private void cancelRetryNewIkeSessionFuture() {
            if (this.mScheduledHandleRetryIkeSessionFuture == null) goto L6;
            Log.d(TAG, "Cancel the task for handling new ike session timeout");
            this.mScheduledHandleRetryIkeSessionFuture.cancel(false);
            this.mScheduledHandleRetryIkeSessionFuture = null;
            return;
        }

        private void markFailedAndDisconnect(Exception exception) {
            Vpn r0 = this.this$0;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mVpnRunner == this) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.this$0.updateState(NetworkInfo.DetailedState.FAILED, exception.getMessage());     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            Vpn.m3102$$Nest$mclearVpnNetworkPreference(this.this$0, this.mSessionKey);
            disconnectVpnRunner();
        }

        @Override // com.android.server.connectivity.Vpn.IkeV2VpnRunnerCallback
        public void onSessionLost(int token, Exception exception) {
            LocalLog r0 = Vpn.m3093$$Nest$fgetmEventChanges(this.this$0);
            StringBuilder r1 = new StringBuilder();
            r1.append("[IKE] Session lost on network ");
            r1.append(this.mActiveNetwork);
            if (exception != null) goto L5;
            String r2 = "";
        L6:
            r1.append(r2);
            r0.log(r1.toString());
            Log.d(TAG, "onSessionLost() called for token " + token);
            if (isActiveToken(token) == true) goto L10;
            Log.d(TAG, "onSessionLost() called for obsolete token " + token);
            return;
        L10:
            handleSessionLost(exception, this.mActiveNetwork);
            return;
        L5:
            r2 = " reason " + exception.getMessage();
            goto L6
        }

        private void handleSessionLost(Exception exception, Network network) {
            cancelHandleNetworkLostTimeout();
            if ((exception instanceof IllegalArgumentException) == false) goto L7;
            markFailedAndDisconnect(exception);
            return;
        L7:
            if ((exception instanceof IkeProtocolException) == false) goto L14;
            IkeProtocolException ikeException = (IkeProtocolException) exception;
            int errorCode = ikeException.getErrorType();
            switch(ikeException.getErrorType()) {
                case 14: goto L11;
                case 17: goto L11;
                case 24: goto L11;
                case 34: goto L11;
                case 37: goto L11;
                case 38: goto L11;
                default: goto L10;
            };
        L10:
            int errorClass = 2;
        L12:
            String category = "android.net.category.EVENT_IKE_ERROR";
            int errorClass2 = errorClass;
            int errorCode2 = errorCode;
        L31:
            Vpn r3 = this.this$0;
            monitor-enter(r3);
        L37:
            th = move-exception;
            throw th;
        L34:
            if (this.this$0.mVpnRunner == this) goto L39;
            monitor-exit(r3);     // Catch: Throwable -> L37
            return;
        L39:
            if (category != null) goto L41;
        L43:
            monitor-exit(r3);     // Catch: Throwable -> L37
            if (errorClass2 != 1) goto L47;
        L77:
            Log.d(TAG, "Start ike session failed. Retry count: " + this.mRetryCount + " ErrorClass: " + errorClass2 + " ErrorCode: " + errorCode2);
            markFailedAndDisconnect(exception);
            return;
        L47:
            if (this.mRetryCount >= 5) goto L77;
            scheduleStartIkeSession(-1);
            Log.d(TAG, "Resetting state for token: " + this.mCurrentToken);
            Vpn r4 = this.this$0;
            monitor-enter(r4);
        L55:
            th = move-exception;
            throw th;
        L52:
            if (this.this$0.mVpnRunner == this) goto L57;
            monitor-exit(r4);     // Catch: Throwable -> L55
            return;
        L57:
            this.this$0.mInterface = null;     // Catch: Throwable -> L55
            if (this.this$0.mConfig == null) goto L68;
            this.this$0.mConfig.interfaze = null;     // Catch: Throwable -> L55
            if (this.this$0.mConfig.routes == null) goto L68;
            List<RouteInfo> oldRoutes = new ArrayList(this.this$0.mConfig.routes);     // Catch: Throwable -> L55
            this.this$0.mConfig.routes.clear();     // Catch: Throwable -> L55
            Iterator<RouteInfo> r6 = oldRoutes.iterator();     // Catch: Throwable -> L55
        L63:
            if (r6.hasNext() == false) goto L66;
            RouteInfo route = r6.next();     // Catch: Throwable -> L55
            this.this$0.mConfig.routes.add(new RouteInfo(route.getDestination(), null, null, 7));     // Catch: Throwable -> L55
            goto L63
        L66:
            if (this.this$0.mNetworkAgent == null) goto L68;
            Vpn.m3120$$Nest$smdoSendLinkProperties(this.this$0.mNetworkAgent, Vpn.m3111$$Nest$mmakeLinkProperties(this.this$0));     // Catch: Throwable -> L55
        L68:
            monitor-exit(r4);     // Catch: Throwable -> L55
            resetIkeState();
            if (errorCode2 != 2) goto L72;
            return;
        L72:
            if (this.this$0.mDeps.getNextRetryDelayMs(this.mRetryCount - 1) <= NETWORK_LOST_TIMEOUT_MS) goto L85;
            Vpn.m3102$$Nest$mclearVpnNetworkPreference(this.this$0, this.mSessionKey);
            return;
        L85:
            return;
        L41:
            if (Vpn.m3125$$Nest$smisVpnApp(this.this$0.mPackage) == false) goto L43;
            Vpn.m3114$$Nest$msendEventToVpnManagerApp(this.this$0, category, errorClass2, errorCode2, this.this$0.getPackage(), this.mSessionKey, Vpn.m3112$$Nest$mmakeVpnProfileStateLocked(this.this$0), this.mActiveNetwork, Vpn.m3105$$Nest$mgetRedactedNetworkCapabilities(this.this$0, this.mUnderlyingNetworkCapabilities), Vpn.m3104$$Nest$mgetRedactedLinkProperties(this.this$0, this.mUnderlyingLinkProperties));     // Catch: Throwable -> L37
            goto L43
        L11:
            errorClass = 1;
            goto L12
        L14:
            if ((exception instanceof IkeNetworkLostException) == false) goto L17;
            category = "android.net.category.EVENT_NETWORK_ERROR";
            errorClass2 = 2;
            errorCode2 = 2;
            goto L31
        L17:
            if ((exception instanceof IkeNonProtocolException) == true) goto L19;
            if (exception == null) goto L30;
            Log.wtf(TAG, "onSessionLost: exception = " + exception);
        L30:
            category = null;
            errorClass2 = -1;
            errorCode2 = -1;
            goto L31
        L19:
            if ((exception.getCause() instanceof UnknownHostException) == false) goto L22;
            category = "android.net.category.EVENT_NETWORK_ERROR";
            errorClass2 = 2;
            errorCode2 = 0;
            goto L31
        L22:
            if ((exception.getCause() instanceof IkeTimeoutException) == false) goto L25;
            category = "android.net.category.EVENT_NETWORK_ERROR";
            errorClass2 = 2;
            errorCode2 = 1;
            goto L31
        L25:
            if ((exception.getCause() instanceof IOException) == false) goto L27;
            category = "android.net.category.EVENT_NETWORK_ERROR";
            errorClass2 = 2;
            errorCode2 = 3;
            goto L31
        L27:
            category = "android.net.category.EVENT_NETWORK_ERROR";
            errorClass2 = 2;
            errorCode2 = -1;
            goto L31
        }

        private void resetIkeState() {
            if (this.mTunnelIface == null) goto L6;
            this.mTunnelIface.close();
            this.mTunnelIface = null;
        L6:
            if (this.mSession == null) goto L8;
            this.mSession.kill();
            this.mSession = null;
        L8:
            this.mIkeConnectionInfo = null;
            this.mMobikeEnabled = false;
        }

        private void disconnectVpnRunner() {
            Vpn.m3093$$Nest$fgetmEventChanges(this.this$0).log("[VPNRunner] Disconnect runner, underlying net " + this.mActiveNetwork);
            this.mActiveNetwork = null;
            this.mUnderlyingNetworkCapabilities = null;
            this.mUnderlyingLinkProperties = null;
            this.mIsRunning = false;
            resetIkeState();
            if (Vpn.m3089$$Nest$fgetmCarrierConfigManager(this.this$0) == null) goto L5;
            Vpn.m3089$$Nest$fgetmCarrierConfigManager(this.this$0).unregisterCarrierConfigChangeListener(this.mCarrierConfigChangeListener);
        L5:
            Vpn.m3091$$Nest$fgetmConnectivityManager(this.this$0).unregisterNetworkCallback(this.mNetworkCallback);
            this.mExecutor.shutdown();
        }

        @Override // com.android.server.connectivity.Vpn.VpnRunner
        public void exitVpnRunner() {
            Vpn.m3102$$Nest$mclearVpnNetworkPreference(this.this$0, this.mSessionKey);
            this.mExecutor.execute(new Vpn$IkeV2VpnRunner$$ExternalSyntheticLambda5(this));     // Catch: RejectedExecutionException -> L5
            return;
        }

        private /* synthetic */ void lambda$exitVpnRunner$6() {
            disconnectVpnRunner();
        }
    }

    interface IkeV2VpnRunnerCallback {
        void onChildMigrated(int r1, IpSecTransform r2, IpSecTransform r3);

        void onChildOpened(int r1, ChildSessionConfiguration r2);

        void onChildTransformCreated(int r1, IpSecTransform r2, int r3);

        void onDefaultNetworkCapabilitiesChanged(NetworkCapabilities r1);

        void onDefaultNetworkChanged(Network r1);

        void onDefaultNetworkLinkPropertiesChanged(LinkProperties r1);

        void onDefaultNetworkLost(Network r1);

        void onIkeConnectionInfoChanged(int r1, IkeSessionConnectionInfo r2);

        void onIkeOpened(int r1, IkeSessionConfiguration r2);

        void onSessionLost(int r1, Exception r2);
    }

    public static class Ikev2SessionCreator {
        public Ikev2SessionCreator() {
        }

        public IkeSessionWrapper createIkeSession(Context context, IkeSessionParams ikeSessionParams, ChildSessionParams firstChildSessionParams, Executor userCbExecutor, IkeSessionCallback ikeSessionCallback, ChildSessionCallback firstChildSessionCallback) {
            return new IkeSessionWrapper(new IkeSession(context, ikeSessionParams, firstChildSessionParams, userCbExecutor, ikeSessionCallback, firstChildSessionCallback));
        }
    }

    public static class SystemServices {
        private final Context mContext;

        public SystemServices(Context context) {
            this.mContext = context;
        }

        public PendingIntent pendingIntentGetActivityAsUser(Intent intent, int flags, UserHandle user) {
            return PendingIntent.getActivity(this.mContext.createContextAsUser(user, 0), 0, intent, flags);
        }

        public void settingsSecurePutStringForUser(String key, String value, int userId) {
            Settings.Secure.putString(getContentResolverAsUser(userId), key, value);
        }

        public void settingsSecurePutIntForUser(String key, int value, int userId) {
            Settings.Secure.putInt(getContentResolverAsUser(userId), key, value);
        }

        public String settingsSecureGetStringForUser(String key, int userId) {
            return Settings.Secure.getString(getContentResolverAsUser(userId), key);
        }

        public int settingsSecureGetIntForUser(String key, int def, int userId) {
            return Settings.Secure.getInt(getContentResolverAsUser(userId), key, def);
        }

        private ContentResolver getContentResolverAsUser(int userId) {
            return this.mContext.createContextAsUser(UserHandle.of(userId), 0).getContentResolver();
        }
    }

    interface ValidationStatusCallback {
        void onValidationStatus(int r1);
    }

    public static class VpnNetworkAgentWrapper extends NetworkAgent {
        private final ValidationStatusCallback mCallback;

        public VpnNetworkAgentWrapper(Context context, Looper looper, String logTag, NetworkCapabilities nc, LinkProperties lp, NetworkScore score, NetworkAgentConfig config, NetworkProvider provider, ValidationStatusCallback callback) {
            super(context, looper, logTag, nc, lp, score, config, provider);
            this.mCallback = callback;
        }

        public void doSendLinkProperties(LinkProperties lp) {
            sendLinkProperties(lp);
        }

        public void doSendNetworkCapabilities(NetworkCapabilities nc) {
            sendNetworkCapabilities(nc);
        }

        public void doSetUnderlyingNetworks(List<Network> networks) {
            setUnderlyingNetworks(networks);
        }

        public void onNetworkUnwanted() {
        }

        public void onValidationStatus(int status, Uri redirectUri) {
            if (this.mCallback == null) goto L6;
            this.mCallback.onValidationStatus(status);
            return;
        }
    }

    abstract class VpnRunner extends Thread {
        final /* synthetic */ Vpn this$0;

        protected abstract void exitVpnRunner();

        @Override // java.lang.Thread, java.lang.Runnable
        public abstract void run();

        protected VpnRunner(Vpn this$0, String name) {
            this.this$0 = this$0;
            super(name);
        }

        protected final void exit() {
            Vpn r0 = this.this$0;
            monitor-enter(r0);
            exitVpnRunner();     // Catch: Throwable -> L7
            Vpn.m3101$$Nest$mcleanupVpnStateLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ void $r8$lambda$73ewkCB2I8FM2sfP7wLNLasIr6E(Vpn r0, String r1) {
        r0.lambda$clearVpnNetworkPreference$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ccw-M06Kt_L5iOLfmFoAk0C9rzg, reason: not valid java name */
    public static /* synthetic */ void m3086$r8$lambda$CcwM06Kt_L5iOLfmFoAk0C9rzg(Vpn r0, String r1, Set r2) {
        r0.lambda$setVpnNetworkPreference$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsManager m3087$$Nest$fgetmAppOpsManager(Vpn r0) {
        return r0.mAppOpsManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCachedCarrierConfigInfoPerSubId, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3088$$Nest$fgetmCachedCarrierConfigInfoPerSubId(Vpn r0) {
        return r0.mCachedCarrierConfigInfoPerSubId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCarrierConfigManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ CarrierConfigManager m3089$$Nest$fgetmCarrierConfigManager(Vpn r0) {
        return r0.mCarrierConfigManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ Connection m3090$$Nest$fgetmConnection(Vpn r0) {
        return r0.mConnection;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectivityManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConnectivityManager m3091$$Nest$fgetmConnectivityManager(Vpn r0) {
        return r0.mConnectivityManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3092$$Nest$fgetmContext(Vpn r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEventChanges, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalLog m3093$$Nest$fgetmEventChanges(Vpn r0) {
        return r0.mEventChanges;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIkev2SessionCreator, reason: not valid java name */
    static /* bridge */ /* synthetic */ Ikev2SessionCreator m3094$$Nest$fgetmIkev2SessionCreator(Vpn r0) {
        return r0.mIkev2SessionCreator;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLooper, reason: not valid java name */
    static /* bridge */ /* synthetic */ Looper m3095$$Nest$fgetmLooper(Vpn r0) {
        return r0.mLooper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetd, reason: not valid java name */
    static /* bridge */ /* synthetic */ INetd m3096$$Nest$fgetmNetd(Vpn r0) {
        return r0.mNetd;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOwnerUID, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3097$$Nest$fgetmOwnerUID(Vpn r0) {
        return r0.mOwnerUID;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ TelephonyManager m3098$$Nest$fgetmTelephonyManager(Vpn r0) {
        return r0.mTelephonyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3099$$Nest$fgetmUserId(Vpn r0) {
        return r0.mUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$magentConnect, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3100$$Nest$magentConnect(Vpn r0, ValidationStatusCallback r1) {
        r0.agentConnect(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcleanupVpnStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3101$$Nest$mcleanupVpnStateLocked(Vpn r0) {
        r0.cleanupVpnStateLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mclearVpnNetworkPreference, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3102$$Nest$mclearVpnNetworkPreference(Vpn r0, String r1) {
        r0.clearVpnNetworkPreference(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdoSetUnderlyingNetworks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3103$$Nest$mdoSetUnderlyingNetworks(Vpn r0, NetworkAgent r1, List r2) {
        r0.doSetUnderlyingNetworks(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRedactedLinkProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ LinkProperties m3104$$Nest$mgetRedactedLinkProperties(Vpn r0, LinkProperties r1) {
        return r0.getRedactedLinkProperties(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRedactedNetworkCapabilities, reason: not valid java name */
    static /* bridge */ /* synthetic */ NetworkCapabilities m3105$$Nest$mgetRedactedNetworkCapabilities(Vpn r0, NetworkCapabilities r1) {
        return r0.getRedactedNetworkCapabilities(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misSettingsVpnLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3106$$Nest$misSettingsVpnLocked(Vpn r0) {
        return r0.isSettingsVpnLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mjniCheck, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3107$$Nest$mjniCheck(Vpn r0, String r1) {
        return r0.jniCheck(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mjniCreate, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3108$$Nest$mjniCreate(Vpn r0, int r1) {
        return r0.jniCreate(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mjniGetName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3109$$Nest$mjniGetName(Vpn r0, int r1) {
        return r0.jniGetName(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mjniSetAddresses, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3110$$Nest$mjniSetAddresses(Vpn r0, String r1, String r2) {
        return r0.jniSetAddresses(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mmakeLinkProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ LinkProperties m3111$$Nest$mmakeLinkProperties(Vpn r0) {
        return r0.makeLinkProperties();
    }

    /* JADX INFO: renamed from: -$$Nest$mmakeVpnProfileStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ VpnProfileState m3112$$Nest$mmakeVpnProfileStateLocked(Vpn r0) {
        return r0.makeVpnProfileStateLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mprepareStatusIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3113$$Nest$mprepareStatusIntent(Vpn r0) {
        r0.prepareStatusIntent();
    }

    /* JADX INFO: renamed from: -$$Nest$msendEventToVpnManagerApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3114$$Nest$msendEventToVpnManagerApp(Vpn r0, String r1, int r2, int r3, String r4, String r5, VpnProfileState r6, Network r7, NetworkCapabilities r8, LinkProperties r9) {
        return r0.sendEventToVpnManagerApp(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: -$$Nest$msetVpnNetworkPreference, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3115$$Nest$msetVpnNetworkPreference(Vpn r0, String r1, Set r2) {
        r0.setVpnNetworkPreference(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartNewNetworkAgent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3116$$Nest$mstartNewNetworkAgent(Vpn r0, NetworkAgent r1, String r2) {
        r0.startNewNetworkAgent(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDATA_STALL_RECOVERY_DELAYS_MS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long[] m3117$$Nest$sfgetDATA_STALL_RECOVERY_DELAYS_MS() {
        return DATA_STALL_RECOVERY_DELAYS_MS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetIKEV2_VPN_RETRY_DELAYS_MS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long[] m3118$$Nest$sfgetIKEV2_VPN_RETRY_DELAYS_MS() {
        return IKEV2_VPN_RETRY_DELAYS_MS;
    }

    /* JADX INFO: renamed from: -$$Nest$smareLongLivedTcpConnectionsExpensive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3119$$Nest$smareLongLivedTcpConnectionsExpensive(int r0) {
        return areLongLivedTcpConnectionsExpensive(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smdoSendLinkProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3120$$Nest$smdoSendLinkProperties(NetworkAgent r0, LinkProperties r1) {
        doSendLinkProperties(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smdoSendNetworkCapabilities, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3121$$Nest$smdoSendNetworkCapabilities(NetworkAgent r0, NetworkCapabilities r1) {
        doSendNetworkCapabilities(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetAppUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3122$$Nest$smgetAppUid(Context r0, String r1, int r2) {
        return getAppUid(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetCellSubIdForNetworkCapabilities, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3123$$Nest$smgetCellSubIdForNetworkCapabilities(NetworkCapabilities r0) {
        return getCellSubIdForNetworkCapabilities(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisIPv6Only, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3124$$Nest$smisIPv6Only(List r0) {
        return isIPv6Only(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisVpnApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3125$$Nest$smisVpnApp(String r0) {
        return isVpnApp(r0);
    }

    private native boolean jniAddAddress(String r1, String r2, int r3);

    private native int jniCheck(String r1);

    private native int jniCreate(int r1);

    private native boolean jniDelAddress(String r1, String r2, int r3);

    private native String jniGetName(int r1);

    private native void jniReset(String r1);

    private native int jniSetAddresses(String r1, String r2);

    static {
        VPN_STATE_CHANGE = "com.android.server.connectivity.VPN_STATE_CHANGE";
        VPN_STATE_EXTRA_INT = "state";
        VPN_STATE_INTENT = "intent";
        VPN_DISCONNECT_REASON = "disconnect_reason";
        VPN_STATE_NONE = -1;
        VPN_STATE_OFF = 0;
        VPN_STATE_ON = 1;
        VPN_STATE_CONNECTING = 2;
        VPN_STATE_DISCONNECTED = 3;
        VPN_CONFIG = "com.android.server.connectivity.VPN_CONFIG";
        VPN_CONFIG_EXTRA = "config";
        IKEV2_VPN_RETRY_DELAYS_MS = new long[]{1000, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME, 5000, 30000, 60000, 300000, HeartbeatStats.MAX_NAT_TIME_MS};
        DATA_STALL_RECOVERY_DELAYS_MS = new long[]{1000, 5000, 30000, 60000, 120000, 240000, 480000, 960000};
    }

    VpnProfileStore getVpnProfileStore() {
        return this.mVpnProfileStore;
    }

    public Vpn(Looper looper, Context context, INetworkManagementService netService, INetd netd, int userId, VpnProfileStore vpnProfileStore) {
        this(looper, context, new Dependencies(), netService, netd, userId, vpnProfileStore, new SystemServices(context), new Ikev2SessionCreator());
    }

    public Vpn(Looper looper, Context context, Dependencies deps, INetworkManagementService netService, INetd netd, int userId, VpnProfileStore vpnProfileStore) {
        this(looper, context, deps, netService, netd, userId, vpnProfileStore, new SystemServices(context), new Ikev2SessionCreator());
    }

    protected Vpn(Looper looper, Context context, Dependencies deps, INetworkManagementService netService, INetd netd, int userId, VpnProfileStore vpnProfileStore, SystemServices systemServices, Ikev2SessionCreator ikev2SessionCreator) {
        this.mEnableNotif = true;
        this.mEnableTeardown = true;
        this.mEventChanges = new LocalLog(100);
        this.mCachedCarrierConfigInfoPerSubId = new SparseArray();
        this.mAlwaysOn = false;
        this.mLockdown = false;
        this.mLockdownAllowlist = Collections.emptyList();
        this.mBlockedUidsAsToldToConnectivity = new ArraySet();
        this.mObserver = new AnonymousClass1(this);
        this.mVpnProfileStore = vpnProfileStore;
        this.mContext = context;
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mUserIdContext = context.createContextAsUser(UserHandle.of(userId), 0);
        this.mConnectivityDiagnosticsManager = (ConnectivityDiagnosticsManager) this.mContext.getSystemService(ConnectivityDiagnosticsManager.class);
        this.mCarrierConfigManager = (CarrierConfigManager) this.mContext.getSystemService(CarrierConfigManager.class);
        this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        this.mSubscriptionManager = (SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class);
        this.mDeps = deps;
        this.mNetd = netd;
        this.mUserId = userId;
        this.mLooper = looper;
        this.mSystemServices = systemServices;
        this.mIkev2SessionCreator = ikev2SessionCreator;
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        this.mPackage = "[Legacy VPN]";
        this.mOwnerUID = getAppUid(this.mContext, this.mPackage, this.mUserId);
        this.mIsPackageTargetingAtLeastQ = doesPackageTargetAtLeastQ(this.mPackage);
        netService.registerObserver(this.mObserver);     // Catch: RemoteException -> L5
    L7:
        this.mNetworkProvider = new NetworkProvider(context, looper, VPN_PROVIDER_NAME_BASE + this.mUserId);
        this.mConnectivityManager.registerNetworkProvider(this.mNetworkProvider);
        this.mLegacyState = 0;
        this.mNetworkInfo = new NetworkInfo(17, 0, NETWORKTYPE, "");
        this.mNetworkCapabilities = new NetworkCapabilities.Builder().addTransportType(4).removeCapability(15).addCapability(28).setTransportInfo(new VpnTransportInfo(-1, null, false, false)).build();
        loadAlwaysOnPackage();
        return;
    L5:
        e = move-exception;
        Log.wtf(TAG, "Problem registering observer", e);
        goto L7
    }

    public void setEnableTeardown(boolean enableTeardown) {
        this.mEnableTeardown = enableTeardown;
    }

    public boolean getEnableTeardown() {
        return this.mEnableTeardown;
    }

    protected void updateState(NetworkInfo.DetailedState detailedState, String reason) {
        Log.d(TAG, "setting state=" + detailedState + ", reason=" + reason);
        this.mLegacyState = LegacyVpnInfo.stateFromNetworkInfo(detailedState);
        this.mNetworkInfo.setDetailedState(detailedState, reason, null);
        switch(AnonymousClass2.$SwitchMap$android$net$NetworkInfo$DetailedState[detailedState.ordinal()]) {
            case 1: goto L16;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("Illegal state argument " + detailedState);
    L7:
        if (this.mNetworkAgent != null) goto L10;
    L24:
        updateAlwaysOnNotification(detailedState);
        return;
    L10:
        throw new IllegalStateException("VPN can only go to CONNECTING state when the agent is null.");
    L12:
        if (this.mNetworkAgent == null) goto L14;
        this.mNetworkAgent.unregister();
        this.mNetworkAgent = null;
    L14:
        SysOptBridge.getFactory().getAppRecordManagerService().updateVpnPackage(null);
        SysOptBridge.getFactory().getSmartScenes().updateVpnPackage(null);
        goto L24
    L16:
        if (this.mNetworkAgent == null) goto L19;
        this.mNetworkAgent.markConnected();
    L19:
        if (this.mConfig == null) goto L22;
        SysOptBridge.getFactory().getAppRecordManagerService().updateVpnPackage(this.mConfig.user);
    L22:
        if (this.mConfig == null) goto L24;
        SysOptBridge.getFactory().getSmartScenes().updateVpnPackage(this.mConfig.user);
        goto L24
    }

    private void resetNetworkCapabilities() {
        this.mNetworkCapabilities = new NetworkCapabilities.Builder(this.mNetworkCapabilities).setUids(null).setTransportInfo(new VpnTransportInfo(-1, null, false, false)).build();
    }

    public synchronized void setLockdown(boolean lockdown) {
        monitor-enter(this);
        enforceControlPermissionOrInternalCaller();     // Catch: Throwable -> L7
        setVpnForcedLocked(lockdown);     // Catch: Throwable -> L7
        this.mLockdown = lockdown;     // Catch: Throwable -> L7
        if (this.mAlwaysOn == false) goto L9;
        saveAlwaysOnPackage();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized String getPackage() {
        monitor-enter(this);
        String r0 = this.mPackage;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean getLockdown() {
        monitor-enter(this);
        boolean r0 = this.mLockdown;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean getAlwaysOn() {
        monitor-enter(this);
        boolean r0 = this.mAlwaysOn;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean isAlwaysOnPackageSupported(String packageName) {
        enforceSettingsPermission();
        if (packageName != null) goto L5;
        return false;
    L5:
        long oldId = Binder.clearCallingIdentity();
        if (getVpnProfilePrivileged(packageName) == null) goto L11;
        Binder.restoreCallingIdentity(oldId);
        return true;
    L11:
        Binder.restoreCallingIdentity(oldId);
        PackageManager pm = this.mContext.getPackageManager();
        ApplicationInfo appInfo = null;
        appInfo = pm.getApplicationInfoAsUser(packageName, 0, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L14
    L16:
        if (appInfo != null) goto L18;
    L36:
        return false;
    L18:
        if (appInfo.targetSdkVersion < 24) goto L36;
        Intent intent = new Intent("android.net.VpnService");
        intent.setPackage(packageName);
        List<ResolveInfo> services = pm.queryIntentServicesAsUser(intent, 128, this.mUserId);
        if (services != null) goto L23;
    L35:
        return false;
    L23:
        if (services.size() == 0) goto L35;
        Iterator<ResolveInfo> r8 = services.iterator();
    L27:
        if (r8.hasNext() == false) goto L34;
        ResolveInfo rInfo = r8.next();
        Bundle metaData = rInfo.serviceInfo.metaData;
        if (metaData == null) goto L27;
        if (metaData.getBoolean("android.net.VpnService.SUPPORTS_ALWAYS_ON", true) == true) goto L27;
        return false;
    L34:
        return true;
    L15:
        Log.w(TAG, "Can't find \"" + packageName + "\" when checking always-on support");
    L37:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    }

    private Intent buildVpnManagerEventIntent(String category, int errorClass, int errorCode, String packageName, String sessionKey, VpnProfileState profileState, Network underlyingNetwork, NetworkCapabilities nc, LinkProperties lp) {
        Log.d(TAG, "buildVpnManagerEventIntent: sessionKey = " + sessionKey);
        Intent intent = new Intent("android.net.action.VPN_MANAGER_EVENT");
        intent.setPackage(packageName);
        intent.addCategory(category);
        intent.putExtra("android.net.extra.VPN_PROFILE_STATE", profileState);
        intent.putExtra("android.net.extra.SESSION_KEY", sessionKey);
        intent.putExtra("android.net.extra.UNDERLYING_NETWORK", underlyingNetwork);
        intent.putExtra("android.net.extra.UNDERLYING_NETWORK_CAPABILITIES", nc);
        intent.putExtra("android.net.extra.UNDERLYING_LINK_PROPERTIES", lp);
        intent.putExtra("android.net.extra.TIMESTAMP_MILLIS", System.currentTimeMillis());
        if ("android.net.category.EVENT_DEACTIVATED_BY_USER".equals(category) == true) goto L5;
    L6:
        intent.putExtra("android.net.extra.ERROR_CLASS", errorClass);
        intent.putExtra("android.net.extra.ERROR_CODE", errorCode);
    L7:
        return intent;
    L5:
        if ("android.net.category.EVENT_ALWAYS_ON_STATE_CHANGED".equals(category) == true) goto L7;
        goto L6
    }

    private boolean sendEventToVpnManagerApp(String category, int errorClass, int errorCode, String packageName, String sessionKey, VpnProfileState profileState, Network underlyingNetwork, NetworkCapabilities nc, LinkProperties lp) {
        this.mEventChanges.log("[VMEvent] Event class=" + getVpnManagerEventClassName(errorClass) + ", err=" + getVpnManagerEventErrorName(errorCode) + " for " + packageName + " on session " + sessionKey);
        Intent intent = buildVpnManagerEventIntent(category, errorClass, errorCode, packageName, sessionKey, profileState, underlyingNetwork, nc, lp);
        return sendEventToVpnManagerApp(intent, packageName);
    }

    private boolean sendEventToVpnManagerApp(Intent intent, String packageName) {
        long token = Binder.clearCallingIdentity();
        DeviceIdleInternal idleController = this.mDeps.getDeviceIdleInternal();     // Catch: Throwable -> L18
        idleController.addPowerSaveTempWhitelistApp(Process.myUid(), packageName, 30000, this.mUserId, false, 309, "VpnManager event");     // Catch: Throwable -> L12
        boolean r14 = false;
        if (this.mUserIdContext.startService(intent) == null) goto L10;
        r14 = true;
    L10:
        Binder.restoreCallingIdentity(token);
        return r14;
    L14:
        e = move-exception;
        Log.e(TAG, "Service of VpnManager app " + intent + " failed to start", e);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(token);
        return false;
    L12:
        th = move-exception;
        RuntimeException r15 = th;
    L20:
        Binder.restoreCallingIdentity(token);
        throw r15;
    L18:
        e = move-exception;
        r15 = e;
        goto L20
    }

    private static boolean isVpnApp(String packageName) {
        if (packageName != null) goto L4;
    L6:
        return false;
    L4:
        if ("[Legacy VPN]".equals(packageName) == true) goto L6;
        return true;
    }

    public synchronized boolean setAlwaysOnPackage(String packageName, boolean lockdown, List<String> lockdownAllowlist) {
        monitor-enter(this);
        enforceControlPermissionOrInternalCaller();     // Catch: Throwable -> L16
        String oldPackage = this.mPackage;     // Catch: Throwable -> L16
        if (Objects.equals(packageName, oldPackage) == true) goto L7;
        boolean r2 = true;
    L8:
        boolean isPackageChanged = r2;
        if (isVpnApp(oldPackage) == false) goto L19;
        if (this.mAlwaysOn == false) goto L19;
        if (lockdown != this.mLockdown) goto L15;
        if (isPackageChanged == false) goto L19;
    L15:
        boolean r3 = true;
    L20:
        boolean shouldNotifyOldPkg = r3;
        if (isVpnApp(packageName) == false) goto L24;
        if (isPackageChanged == false) goto L24;
        boolean r4 = true;
    L25:
        boolean shouldNotifyNewPkg = r4;
        if (setAlwaysOnPackageInternal(packageName, lockdown, lockdownAllowlist) == true) goto L29;
        monitor-exit(this);
        return false;
    L29:
        saveAlwaysOnPackage();     // Catch: Throwable -> L16
        if (shouldNotifyOldPkg == false) goto L37;
        if (isPackageChanged == false) goto L34;
        VpnProfileState r7 = makeDisconnectedVpnProfileState();     // Catch: Throwable -> L16
    L35:
        sendEventToVpnManagerApp("android.net.category.EVENT_ALWAYS_ON_STATE_CHANGED", -1, -1, oldPackage, null, r7, null, null, null);     // Catch: Throwable -> L16
        goto L37
    L34:
        r7 = makeVpnProfileStateLocked();     // Catch: Throwable -> L16
    L37:
        if (shouldNotifyNewPkg == false) goto L39;
        sendEventToVpnManagerApp("android.net.category.EVENT_ALWAYS_ON_STATE_CHANGED", -1, -1, packageName, getSessionKeyLocked(), makeVpnProfileStateLocked(), null, null, null);     // Catch: Throwable -> L16
    L39:
        monitor-exit(this);
        return true;
    L24:
        r4 = false;
    L19:
        r3 = false;
        goto L20
    L7:
        r2 = false;
    L16:
        th = move-exception;
        throw th;
    }

    private boolean setAlwaysOnPackageInternal(String packageName, boolean lockdown, List<String> lockdownAllowlist) {
        boolean r2 = false;
        if ("[Legacy VPN]".equals(packageName) == false) goto L6;
        Log.w(TAG, "Not setting legacy VPN \"" + packageName + "\" as always-on.");
        return false;
    L6:
        if (lockdownAllowlist == null) goto L16;
        Iterator<String> r0 = lockdownAllowlist.iterator();
    L9:
        if (r0.hasNext() == false) goto L16;
        String pkg = r0.next();
        if (pkg.contains(",") == false) goto L9;
        Log.w(TAG, "Not setting always-on vpn, invalid allowed package: " + pkg);
        return false;
    L16:
        if (packageName == null) goto L30;
        long oldId = Binder.clearCallingIdentity();
        VpnProfile profile = getVpnProfilePrivileged(packageName);     // Catch: Throwable -> L27
        Binder.restoreCallingIdentity(oldId);
        if (profile != null) goto L22;
        int grantType = 1;
    L24:
        if (setPackageAuthorization(packageName, grantType) == true) goto L26;
        return false;
    L26:
        this.mAlwaysOn = true;
    L31:
        boolean oldLockdownState = this.mLockdown;
        if (this.mAlwaysOn == false) goto L35;
        if (lockdown == false) goto L35;
        r2 = true;
    L35:
        this.mLockdown = r2;
        if (this.mLockdown == false) goto L39;
        if (lockdownAllowlist == null) goto L39;
        List<String> r3 = Collections.unmodifiableList(new ArrayList(lockdownAllowlist));
    L40:
        this.mLockdownAllowlist = r3;
        this.mEventChanges.log("[LockdownAlwaysOn] Mode changed: lockdown=" + this.mLockdown + " alwaysOn=" + this.mAlwaysOn + " calling from " + Binder.getCallingUid());
        if (isCurrentPreparedPackage(packageName) == false) goto L47;
        updateAlwaysOnNotification(this.mNetworkInfo.getDetailedState());
        setVpnForcedLocked(this.mLockdown);
        if (this.mNetworkAgent != null) goto L45;
    L48:
        return true;
    L45:
        if (oldLockdownState == this.mLockdown) goto L48;
        startNewNetworkAgent(this.mNetworkAgent, "Lockdown mode changed");
        goto L48
    L47:
        prepareInternal(packageName);
    L39:
        r3 = Collections.emptyList();
        goto L40
    L22:
        grantType = 2;
    L27:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    L30:
        packageName = "[Legacy VPN]";
        this.mAlwaysOn = false;
        goto L31
    }

    private static boolean isNullOrLegacyVpn(String packageName) {
        if (packageName != null) goto L4;
    L7:
        return true;
    L4:
        if ("[Legacy VPN]".equals(packageName) == true) goto L7;
        return false;
    }

    public synchronized String getAlwaysOnPackage() {
        monitor-enter(this);
        enforceControlPermissionOrInternalCaller();     // Catch: Throwable -> L7
        if (this.mAlwaysOn == false) goto L9;
        String r0 = this.mPackage;     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r0;
    L9:
        r0 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized List<String> getLockdownAllowlist() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mLockdown == false) goto L9;
        List<String> r0 = this.mLockdownAllowlist;     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r0;
    L9:
        r0 = null;
        goto L10
    }

    private void saveAlwaysOnPackage() {
        long token = Binder.clearCallingIdentity();
        this.mSystemServices.settingsSecurePutStringForUser("always_on_vpn_app", getAlwaysOnPackage(), this.mUserId);     // Catch: Throwable -> L8
        SystemServices r2 = this.mSystemServices;     // Catch: Throwable -> L8
        if (this.mAlwaysOn == true) goto L6;
    L10:
        int r4 = 0;
    L11:
        r2.settingsSecurePutIntForUser("always_on_vpn_lockdown", r4, this.mUserId);     // Catch: Throwable -> L8
        this.mSystemServices.settingsSecurePutStringForUser(LOCKDOWN_ALLOWLIST_SETTING_NAME, String.join(",", this.mLockdownAllowlist), this.mUserId);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        if (this.mLockdown == false) goto L10;
        r4 = 1;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void loadAlwaysOnPackage() {
        long token = Binder.clearCallingIdentity();
        String alwaysOnPackage = this.mSystemServices.settingsSecureGetStringForUser("always_on_vpn_app", this.mUserId);     // Catch: Throwable -> L9
        boolean alwaysOnLockdown = false;
        if (this.mSystemServices.settingsSecureGetIntForUser("always_on_vpn_lockdown", 0, this.mUserId) == 0) goto L6;
        alwaysOnLockdown = true;
    L6:
        String allowlistString = this.mSystemServices.settingsSecureGetStringForUser(LOCKDOWN_ALLOWLIST_SETTING_NAME, this.mUserId);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(allowlistString) == false) goto L11;
        List<String> allowedPackages = Collections.emptyList();     // Catch: Throwable -> L9
    L12:
        setAlwaysOnPackageInternal(alwaysOnPackage, alwaysOnLockdown, allowedPackages);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        allowedPackages = Arrays.asList(allowlistString.split(","));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean startAlwaysOnVpn() {
        monitor-enter(this);
        String alwaysOnPackage = getAlwaysOnPackage();     // Catch: Throwable -> L7
        boolean r0 = true;
        if (alwaysOnPackage != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L7
        return true;
    L10:
        if (isAlwaysOnPackageSupported(alwaysOnPackage) == true) goto L17;
        if (this.mContext.getPackageManager().isSafeMode() == true) goto L14;
        setAlwaysOnPackage(null, false, null);     // Catch: Throwable -> L7
    L14:
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L17:
        if (getNetworkInfo().isConnected() == false) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L7
        return true;
    L20:
        monitor-exit(this);     // Catch: Throwable -> L7
        long oldId = Binder.clearCallingIdentity();
        VpnProfile profile = getVpnProfilePrivileged(alwaysOnPackage);     // Catch: Throwable -> L27 Exception -> L29
        if (profile == null) goto L31;
        startVpnProfilePrivileged(profile, alwaysOnPackage);     // Catch: Throwable -> L27 Exception -> L29
        Binder.restoreCallingIdentity(oldId);
        return true;
    L31:
        DeviceIdleInternal idleController = this.mDeps.getDeviceIdleInternal();     // Catch: Throwable -> L27 Exception -> L29
        idleController.addPowerSaveTempWhitelistApp(Process.myUid(), alwaysOnPackage, 60000, this.mUserId, false, 309, "vpn");     // Catch: Throwable -> L27 Exception -> L29
        Intent serviceIntent = new Intent("android.net.VpnService");     // Catch: Throwable -> L27 Exception -> L29
        serviceIntent.setPackage(alwaysOnPackage);     // Catch: Throwable -> L27 Exception -> L29
        if (this.mUserIdContext.startService(serviceIntent) != null) goto L36;
        r0 = false;
    L36:
        Binder.restoreCallingIdentity(oldId);
        return r0;
    L38:
        e = move-exception;
        Log.e(TAG, "VpnService " + serviceIntent + " failed to start", e);     // Catch: Throwable -> L27 Exception -> L29
        Binder.restoreCallingIdentity(oldId);
        return false;
    L29:
        e = move-exception;
        Log.e(TAG, "Error starting always-on VPN", e);     // Catch: Throwable -> L27
        Binder.restoreCallingIdentity(oldId);
        return false;
    L27:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean prepare(String oldPackage, String newPackage, int vpnType) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.CONTROL_VPN") == 0) goto L12;
        if (oldPackage == null) goto L9;
        verifyCallingUidAndPackage(oldPackage);     // Catch: Throwable -> L7
    L9:
        if (newPackage == null) goto L12;
        verifyCallingUidAndPackage(newPackage);     // Catch: Throwable -> L7
    L12:
        if (oldPackage != null) goto L14;
    L37:
        if (newPackage != null) goto L39;
    L52:
        monitor-exit(this);
        return true;
    L39:
        if (newPackage.equals("[Legacy VPN]") == false) goto L41;
    L43:
        enforceControlPermissionOrInternalCaller();     // Catch: Throwable -> L7
        if (this.mAlwaysOn == true) goto L46;
    L49:
        prepareInternal(newPackage);     // Catch: Throwable -> L7
        monitor-exit(this);
        return true;
    L46:
        if (isCurrentPreparedPackage(newPackage) == true) goto L49;
        monitor-exit(this);
        return false;
    L41:
        if (isCurrentPreparedPackage(newPackage) == false) goto L43;
    L14:
        if (this.mAlwaysOn == false) goto L20;
        if (isCurrentPreparedPackage(oldPackage) == true) goto L20;
        monitor-exit(this);
        return false;
    L20:
        if (isCurrentPreparedPackage(oldPackage) == true) goto L31;
        if (oldPackage.equals("[Legacy VPN]") == false) goto L24;
    L28:
        monitor-exit(this);
        return false;
    L24:
        if (isVpnPreConsented(this.mContext, oldPackage, vpnType) == false) goto L28;
        prepareInternal(oldPackage);     // Catch: Throwable -> L7
        monitor-exit(this);
        return true;
    L31:
        if (oldPackage.equals("[Legacy VPN]") == true) goto L37;
        if (isVpnPreConsented(this.mContext, oldPackage, vpnType) == true) goto L37;
        prepareInternal("[Legacy VPN]");     // Catch: Throwable -> L7
        monitor-exit(this);
        return false;
    }

    private boolean isCurrentPreparedPackage(String packageName) {
        if (getAppUid(this.mContext, packageName, this.mUserId) == this.mOwnerUID) goto L5;
    L7:
        return false;
    L5:
        if (this.mPackage.equals(packageName) == false) goto L7;
        return true;
    }

    private void prepareInternal(String newPackage) {
        long token = Binder.clearCallingIdentity();
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L4:
        if (this.mInterface == null) goto L9;
        this.mStatusIntent = null;     // Catch: Throwable -> L6
        agentDisconnect();     // Catch: Throwable -> L6
        jniReset(this.mInterface);     // Catch: Throwable -> L6
        this.mInterface = null;     // Catch: Throwable -> L6
        resetNetworkCapabilities();     // Catch: Throwable -> L6
    L9:
        if (this.mConnection == null) goto L15;
        Connection.m3126$$Nest$fgetmService(this.mConnection).transact(AudioFormat.SUB_MASK, Parcel.obtain(), null, 1);     // Catch: Throwable -> L6 Exception -> L12
    L13:
        this.mAppOpsManager.finishOp("android:establish_vpn_service", this.mOwnerUID, this.mPackage, null);     // Catch: Throwable -> L6
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L6
        cleanupVpnStateLocked();     // Catch: Throwable -> L6
    L31:
        this.mNetd.networkSetProtectDeny(this.mOwnerUID);     // Catch: Throwable -> L6 Exception -> L19
    L21:
        Log.i(TAG, "Switched from " + this.mPackage + " to " + newPackage);     // Catch: Throwable -> L6
        this.mPackage = newPackage;     // Catch: Throwable -> L6
        this.mOwnerUID = getAppUid(this.mContext, newPackage, this.mUserId);     // Catch: Throwable -> L6
        this.mIsPackageTargetingAtLeastQ = doesPackageTargetAtLeastQ(newPackage);     // Catch: Throwable -> L6
        this.mNetd.networkSetProtectAllow(this.mOwnerUID);     // Catch: Throwable -> L6 Exception -> L24
    L26:
        this.mConfig = null;     // Catch: Throwable -> L6
        updateState(NetworkInfo.DetailedState.DISCONNECTED, "prepare");     // Catch: Throwable -> L6
        setVpnForcedLocked(this.mLockdown);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L24:
        e = move-exception;
        Log.wtf(TAG, "Failed to allow UID " + this.mOwnerUID + " to call protect() " + e);     // Catch: Throwable -> L6
        goto L26
    L19:
        e = move-exception;
        Log.wtf(TAG, "Failed to disallow UID " + this.mOwnerUID + " to call protect() " + e);     // Catch: Throwable -> L6
        goto L21
    L15:
        if (this.mVpnRunner == null) goto L31;
        stopVpnRunnerAndNotifyAppLocked();     // Catch: Throwable -> L6
        goto L31
    }

    public boolean setPackageAuthorization(String packageName, int vpnType) {
        enforceControlPermissionOrInternalCaller();
        int uid = getAppUid(this.mContext, packageName, this.mUserId);
        if (uid != (-1)) goto L5;
    L38:
        return false;
    L5:
        if ("[Legacy VPN]".equals(packageName) == true) goto L38;
        long token = Binder.clearCallingIdentity();
        switch(vpnType) {
            case -1: goto L20;
            case 0: goto L9;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L16;
            default: goto L9;
        };
    L9:
        Log.wtf(TAG, "Unrecognized VPN type while granting authorization");     // Catch: Throwable -> L12 Exception -> L14
        Binder.restoreCallingIdentity(token);
        return false;
    L16:
        Binder.restoreCallingIdentity(token);
        return false;
    L18:
        String[] toChange = {"android:activate_platform_vpn"};     // Catch: Throwable -> L12 Exception -> L14
    L21:
        int r6 = toChange.length;     // Catch: Throwable -> L12 Exception -> L14
        int r8 = 0;
    L22:
        int r9 = 1;
        if (r8 >= r6) goto L30;
        String appOpStr = toChange[r8];     // Catch: Throwable -> L12 Exception -> L14
        AppOpsManager r11 = this.mAppOpsManager;     // Catch: Throwable -> L12 Exception -> L14
        if (vpnType == (-1)) goto L28;
        r9 = 0;
    L28:
        r11.setMode(appOpStr, uid, packageName, r9);     // Catch: Throwable -> L12 Exception -> L14
        r8 = r8 + 1;
        goto L22
    L30:
        Binder.restoreCallingIdentity(token);
        return true;
    L19:
        toChange = new String[]{"android:activate_vpn"};     // Catch: Throwable -> L12 Exception -> L14
        goto L21
    L20:
        toChange = new String[]{"android:activate_vpn", "android:activate_platform_vpn"};     // Catch: Throwable -> L12 Exception -> L14
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L14:
        e = move-exception;
        Log.wtf(TAG, "Failed to set app ops for package " + packageName + ", uid " + uid, e);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(token);
        return false;
    }

    private static boolean isVpnPreConsented(Context context, String packageName, int vpnType) {
        switch(vpnType) {
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L3;
        };
    L3:
        return false;
    L6:
        return "[Legacy VPN]".equals(packageName);
    L8:
        return isVpnProfilePreConsented(context, packageName);
    L10:
        return isVpnServicePreConsented(context, packageName);
    }

    private static boolean doesPackageHaveAppop(Context context, String packageName, String appOpStr) {
        AppOpsManager appOps = (AppOpsManager) context.getSystemService("appops");
        if (appOps.noteOpNoThrow(appOpStr, Binder.getCallingUid(), packageName, null, null) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isVpnServicePreConsented(Context context, String packageName) {
        return doesPackageHaveAppop(context, packageName, "android:activate_vpn");
    }

    private static boolean isVpnProfilePreConsented(Context context, String packageName) {
        if (doesPackageHaveAppop(context, packageName, "android:activate_platform_vpn") == false) goto L5;
    L8:
        return true;
    L5:
        if (isVpnServicePreConsented(context, packageName) == true) goto L8;
        return false;
    }

    private static int getAppUid(Context context, String app, int userId) {
        if ("[Legacy VPN]".equals(app) == true) goto L5;
        PackageManager pm = context.getPackageManager();
        long token = Binder.clearCallingIdentity();
        int r3 = pm.getPackageUidAsUser(app, userId);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L13
        Binder.restoreCallingIdentity(token);
        return r3;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L14:
        Binder.restoreCallingIdentity(token);
        return -1;
    L5:
        return Process.myUid();
    }

    private boolean doesPackageTargetAtLeastQ(String packageName) {
        if ("[Legacy VPN]".equals(packageName) == false) goto L5;
        return true;
    L5:
        PackageManager pm = this.mContext.getPackageManager();
        ApplicationInfo appInfo = pm.getApplicationInfoAsUser(packageName, 0, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L12
        if (appInfo.targetSdkVersion < 29) goto L11;
        return true;
    L11:
        return false;
    L13:
        Log.w(TAG, "Can't find \"" + packageName + "\"");
        return false;
    }

    public NetworkInfo getNetworkInfo() {
        return this.mNetworkInfo;
    }

    public synchronized Network getNetwork() {
        monitor-enter(this);
        NetworkAgent agent = this.mNetworkAgent;     // Catch: Throwable -> L14
        if (agent != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Network network = agent.getNetwork();     // Catch: Throwable -> L14
        if (network != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        monitor-exit(this);
        return network;
    L14:
        th = move-exception;
        throw th;
    }

    private LinkProperties makeLinkProperties() {
        if (isIkev2VpnRunner() == true) goto L5;
    L7:
        boolean disableIPV6 = false;
    L8:
        boolean allowIPv4 = this.mConfig.allowIPv4;
        boolean allowIPv6 = this.mConfig.allowIPv6;
        LinkProperties lp = new LinkProperties();
        lp.setInterfaceName(this.mInterface);
        if (this.mConfig.addresses == null) goto L20;
        Iterator r6 = this.mConfig.addresses.iterator();
    L12:
        if (r6.hasNext() == false) goto L20;
        LinkAddress address = (LinkAddress) r6.next();
        if (disableIPV6 == false) goto L18;
        if (address.isIpv6() == true) goto L12;
    L18:
        lp.addLinkAddress(address);
        allowIPv4 = allowIPv4 | (address.getAddress() instanceof Inet4Address);
        allowIPv6 = allowIPv6 | (address.getAddress() instanceof Inet6Address);
    L20:
        if (this.mConfig.routes == null) goto L34;
        Iterator r7 = this.mConfig.routes.iterator();
    L23:
        if (r7.hasNext() == false) goto L34;
        RouteInfo route = (RouteInfo) r7.next();
        InetAddress address2 = route.getDestination().getAddress();
        if (disableIPV6 == false) goto L29;
        if ((address2 instanceof Inet6Address) == true) goto L23;
    L29:
        lp.addRoute(route);
        if (route.getType() != 1) goto L23;
        allowIPv4 = allowIPv4 | (address2 instanceof Inet4Address);
        allowIPv6 = allowIPv6 | (address2 instanceof Inet6Address);
    L34:
        if (this.mConfig.dnsServers == null) goto L44;
        Iterator r1 = this.mConfig.dnsServers.iterator();
    L37:
        if (r1.hasNext() == false) goto L44;
        String dnsServer = (String) r1.next();
        InetAddress address3 = InetAddresses.parseNumericAddress(dnsServer);
        if (disableIPV6 == false) goto L43;
        if ((address3 instanceof Inet6Address) == true) goto L37;
    L43:
        lp.addDnsServer(address3);
        allowIPv4 = allowIPv4 | (address3 instanceof Inet4Address);
        allowIPv6 = allowIPv6 | (address3 instanceof Inet6Address);
    L44:
        lp.setHttpProxy(this.mConfig.proxyInfo);
        if (allowIPv4 == true) goto L47;
        lp.addRoute(new RouteInfo(new IpPrefix(NetworkStackConstants.IPV4_ADDR_ANY, 0), null, null, 7));
    L47:
        if (allowIPv6 == false) goto L49;
        if (disableIPV6 == true) goto L49;
    L50:
        StringBuilder buffer = new StringBuilder();
        if (this.mConfig.searchDomains == null) goto L56;
        Iterator r2 = this.mConfig.searchDomains.iterator();
    L54:
        if (r2.hasNext() == false) goto L56;
        String domain = (String) r2.next();
        buffer.append(domain);
        buffer.append(' ');
    L56:
        lp.setDomains(buffer.toString().trim());
        if (this.mConfig.mtu <= 0) goto L59;
        lp.setMtu(this.mConfig.mtu);
    L59:
        return lp;
    L49:
        lp.addRoute(new RouteInfo(new IpPrefix(NetworkStackConstants.IPV6_ADDR_ANY, 0), null, null, 7));
        goto L50
    L5:
        if (this.mConfig.mtu >= 1280) goto L7;
        disableIPV6 = true;
        goto L8
    }

    private boolean updateLinkPropertiesInPlaceIfPossible(NetworkAgent agent, VpnConfig oldConfig) {
        if (oldConfig.allowBypass == this.mConfig.allowBypass) goto L7;
        Log.i(TAG, "Handover not possible due to changes to allowBypass");
        return false;
    L7:
        if (Objects.equals(oldConfig.allowedApplications, this.mConfig.allowedApplications) == true) goto L9;
    L13:
        Log.i(TAG, "Handover not possible due to changes to allowed/denied apps");
        return false;
    L9:
        if (Objects.equals(oldConfig.disallowedApplications, this.mConfig.disallowedApplications) == false) goto L13;
        agent.sendLinkProperties(makeLinkProperties());
        return true;
    }

    private void agentConnect() {
        agentConnect(null);
    }

    private void agentConnect(ValidationStatusCallback validationCallback) {
        LinkProperties lp = makeLinkProperties();
        NetworkCapabilities.Builder capsBuilder = new NetworkCapabilities.Builder(this.mNetworkCapabilities);
        capsBuilder.addCapability(12);
        this.mLegacyState = 2;
        updateState(NetworkInfo.DetailedState.CONNECTING, "agentConnect");
        if (this.mConfig.allowBypass == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean bypassable = r0;
        NetworkAgentConfig networkAgentConfig = new NetworkAgentConfig.Builder().setLegacyType(17).setLegacyTypeName(NETWORKTYPE).setBypassableVpn(bypassable).setVpnRequiresValidation(this.mConfig.requiresInternetValidation).setLocalRoutesExcludedForVpn(this.mConfig.excludeLocalRoutes).setLegacyExtraInfo("VPN:" + this.mPackage).build();
        capsBuilder.setOwnerUid(this.mOwnerUID);
        capsBuilder.setAdministratorUids(new int[]{this.mOwnerUID});
        capsBuilder.setUids(createUserAndRestrictedProfilesRanges(this.mUserId, this.mConfig.allowedApplications, this.mConfig.disallowedApplications));
        boolean expensive = areLongLivedTcpConnectionsExpensive(this.mVpnRunner);
        capsBuilder.setTransportInfo(new VpnTransportInfo(getActiveVpnType(), this.mConfig.session, bypassable, expensive));
        if (this.mIsPackageTargetingAtLeastQ == true) goto L11;
    L13:
        capsBuilder.addCapability(11);
    L15:
        if (this.mConfig.underlyingNetworks == null) goto L17;
        List r1 = Arrays.asList(this.mConfig.underlyingNetworks);
    L18:
        capsBuilder.setUnderlyingNetworks(r1);
        this.mNetworkCapabilities = capsBuilder.build();
        logUnderlyNetworkChanges(this.mNetworkCapabilities.getUnderlyingNetworks());
        this.mNetworkAgent = this.mDeps.newNetworkAgent(this.mContext, this.mLooper, NETWORKTYPE, this.mNetworkCapabilities, lp, new NetworkScore.Builder().setLegacyInt(101).build(), networkAgentConfig, this.mNetworkProvider, validationCallback);
        long token = Binder.clearCallingIdentity();
        this.mNetworkAgent.register();     // Catch: Throwable -> L26 Exception -> L28
        Binder.restoreCallingIdentity(token);
        updateState(NetworkInfo.DetailedState.CONNECTED, "agentConnect");
        if (isIkev2VpnRunner() == false) goto L36;
        IkeSessionWrapper session = IkeV2VpnRunner.m3134$$Nest$fgetmSession((IkeV2VpnRunner) this.mVpnRunner);
        if (session == null) goto L37;
        session.setUnderpinnedNetwork(this.mNetworkAgent.getNetwork());
        return;
    L37:
        return;
    L36:
        return;
    L28:
        e = move-exception;
        this.mNetworkAgent = null;     // Catch: Throwable -> L26
        throw e;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L17:
        r1 = null;
        goto L18
    L11:
        if (this.mConfig.isMetered == false) goto L13;
        capsBuilder.removeCapability(11);
        goto L15
    L5:
        if (this.mLockdown == true) goto L7;
        r0 = true;
        goto L8
    }

    private static boolean areLongLivedTcpConnectionsExpensive(VpnRunner runner) {
        if ((runner instanceof IkeV2VpnRunner) == true) goto L6;
        return false;
    L6:
        int delay = IkeV2VpnRunner.m3136$$Nest$mgetOrGuessKeepaliveDelaySeconds((IkeV2VpnRunner) runner);
        return areLongLivedTcpConnectionsExpensive(delay);
    }

    private static boolean areLongLivedTcpConnectionsExpensive(int keepaliveDelaySec) {
        if (keepaliveDelaySec >= 60) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean canHaveRestrictedProfile(int userId) {
        long token = Binder.clearCallingIdentity();
        Context userContext = this.mContext.createContextAsUser(UserHandle.of(userId), 0);     // Catch: Throwable -> L6
        boolean r3 = ((UserManager) userContext.getSystemService(UserManager.class)).canHaveRestrictedProfile();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void logUnderlyNetworkChanges(List<Network> networks) {
        LocalLog r0 = this.mEventChanges;
        StringBuilder r1 = new StringBuilder();
        r1.append("[UnderlyingNW] Switch to ");
        if (networks == null) goto L5;
        String r2 = TextUtils.join(", ", networks);
    L6:
        r1.append(r2);
        r0.log(r1.toString());
        return;
    L5:
        r2 = "null";
        goto L6
    }

    private void agentDisconnect(NetworkAgent networkAgent) {
        if (networkAgent == null) goto L5;
        networkAgent.unregister();
        return;
    }

    private void agentDisconnect() {
        updateState(NetworkInfo.DetailedState.DISCONNECTED, "agentDisconnect");
    }

    private void startNewNetworkAgent(NetworkAgent oldNetworkAgent, String reason) {
        this.mNetworkAgent = null;
        updateState(NetworkInfo.DetailedState.CONNECTING, reason);
        agentConnect();
        agentDisconnect(oldNetworkAgent);
    }

    public synchronized ParcelFileDescriptor establish(VpnConfig config) {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L6:
        if (Binder.getCallingUid() == this.mOwnerUID) goto L10;
        monitor-exit(this);
        return null;
    L10:
        if (isVpnServicePreConsented(this.mContext, this.mPackage) == true) goto L13;
        monitor-exit(this);
        return null;
    L13:
        Intent intent = new Intent("android.net.VpnService");     // Catch: Throwable -> L27
        intent.setClassName(this.mPackage, config.user);     // Catch: Throwable -> L27
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L27
        enforceNotRestrictedUser();     // Catch: Throwable -> L77
        PackageManager packageManager = this.mUserIdContext.getPackageManager();     // Catch: Throwable -> L77
        if (packageManager == null) goto L82;
        ResolveInfo info = packageManager.resolveService(intent, 0);     // Catch: Throwable -> L77
        if (info == null) goto L80;
        if ("android.permission.BIND_VPN_SERVICE".equals(info.serviceInfo.permission) == false) goto L74;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L27
        VpnConfig oldConfig = this.mConfig;     // Catch: Throwable -> L27
        String oldInterface = this.mInterface;     // Catch: Throwable -> L27
        Connection oldConnection = this.mConnection;     // Catch: Throwable -> L27
        NetworkAgent oldNetworkAgent = this.mNetworkAgent;     // Catch: Throwable -> L27
        Set<Range<Integer>> oldUsers = this.mNetworkCapabilities.getUids();     // Catch: Throwable -> L27
        ParcelFileDescriptor tun = this.mDeps.adoptFd(this, config.mtu);     // Catch: Throwable -> L27
        String interfaze = this.mDeps.jniGetName(this, tun.getFd());     // Catch: Throwable -> L27 RuntimeException -> L62
        StringBuilder builder = new StringBuilder();     // Catch: Throwable -> L27 RuntimeException -> L62
        Iterator r14 = config.addresses.iterator();     // Catch: Throwable -> L27 RuntimeException -> L62
    L24:
        if (r14.hasNext() == false) goto L87;
        LinkAddress address = (LinkAddress) r14.next();     // Catch: Throwable -> L27 RuntimeException -> L29
        builder.append(" ");     // Catch: Throwable -> L27 RuntimeException -> L29
        builder.append(address);     // Catch: Throwable -> L27 RuntimeException -> L29
    L29:
        e = e;
    L67:
        IoUtils.closeQuietly(tun);     // Catch: Throwable -> L27
        if (oldNetworkAgent == this.mNetworkAgent) goto L70;
        agentDisconnect();     // Catch: Throwable -> L27
    L70:
        this.mConfig = oldConfig;     // Catch: Throwable -> L27
        this.mConnection = oldConnection;     // Catch: Throwable -> L27
        this.mNetworkCapabilities = new NetworkCapabilities.Builder(this.mNetworkCapabilities).setUids(oldUsers).build();     // Catch: Throwable -> L27
        this.mNetworkAgent = oldNetworkAgent;     // Catch: Throwable -> L27
        this.mInterface = oldInterface;     // Catch: Throwable -> L27
        throw e;     // Catch: Throwable -> L27
    L87:
        if (this.mDeps.jniSetAddresses(this, interfaze, builder.toString()) < 1) goto L65;
        Connection connection = new Connection(this, null);     // Catch: Throwable -> L27 RuntimeException -> L62
        if (this.mContext.bindServiceAsUser(intent, connection, AudioFormat.AAC_MAIN, new UserHandle(this.mUserId)) == false) goto L61;
        this.mConnection = connection;     // Catch: Throwable -> L27 RuntimeException -> L44
        this.mInterface = interfaze;     // Catch: Throwable -> L27 RuntimeException -> L44
        config.user = this.mPackage;     // Catch: Throwable -> L27 RuntimeException -> L44
        config.interfaze = this.mInterface;     // Catch: Throwable -> L27 RuntimeException -> L44
        config.startTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L27 RuntimeException -> L44
        this.mConfig = config;     // Catch: Throwable -> L27 RuntimeException -> L44
        if (oldConfig != null) goto L40;
    L46:
        startNewNetworkAgent(oldNetworkAgent, "establish");     // Catch: Throwable -> L27 RuntimeException -> L44
    L47:
        if (oldConnection == null) goto L49;
        this.mContext.unbindService(oldConnection);     // Catch: Throwable -> L27 RuntimeException -> L44
    L49:
        if (oldInterface != null) goto L51;
    L53:
        this.mDeps.setBlocking(tun.getFileDescriptor(), config.blocking);     // Catch: Throwable -> L27 RuntimeException -> L44
        if (oldNetworkAgent == this.mNetworkAgent) goto L57;
        this.mAppOpsManager.startOp("android:establish_vpn_service", this.mOwnerUID, this.mPackage, null, null);     // Catch: Throwable -> L27 RuntimeException -> L44
    L57:
        Log.i(TAG, "Established by " + config.user + " on " + this.mInterface);     // Catch: Throwable -> L27
        monitor-exit(this);
        return tun;
    L51:
        if (oldInterface.equals(interfaze) == true) goto L53;
        jniReset(oldInterface);     // Catch: Throwable -> L27 RuntimeException -> L44
        goto L53
    L40:
        if (updateLinkPropertiesInPlaceIfPossible(this.mNetworkAgent, oldConfig) == false) goto L46;
        if (Arrays.equals(oldConfig.underlyingNetworks, config.underlyingNetworks) == true) goto L47;
        setUnderlyingNetworks(config.underlyingNetworks);     // Catch: Throwable -> L27 RuntimeException -> L44
        goto L47
    L61:
        throw new IllegalStateException("Cannot bind " + config.user);     // Catch: Throwable -> L27 RuntimeException -> L44
    L65:
        throw new IllegalArgumentException("At least one address must be specified");     // Catch: Throwable -> L27 RuntimeException -> L44
    L44:
        e = e;
    L62:
        e = e;
        goto L67
    L74:
        throw new SecurityException(config.user + " does not require android.permission.BIND_VPN_SERVICE");     // Catch: Throwable -> L75
    L80:
        throw new SecurityException("Cannot find " + config.user);     // Catch: Throwable -> L75
    L82:
        throw new IllegalStateException("Cannot get PackageManager.");     // Catch: Throwable -> L75
    L75:
        th = th;
    L83:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L77:
        th = th;
        goto L83
    }

    private boolean isRunningLocked() {
        if (this.mNetworkAgent != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mInterface == null) goto L7;
        return true;
    }

    protected boolean isCallerEstablishedOwnerLocked() {
        if (isRunningLocked() == true) goto L5;
    L7:
        return false;
    L5:
        if (Binder.getCallingUid() != this.mOwnerUID) goto L7;
        return true;
    }

    private SortedSet<Integer> getAppsUids(List<String> packageNames, int userId) {
        SortedSet<Integer> uids = new TreeSet();
        Iterator<String> r1 = packageNames.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String app = r1.next();
        int uid = getAppUid(this.mContext, app, userId);
        if (uid == (-1)) goto L9;
        uids.add(Integer.valueOf(uid));
    L9:
        if (Process.isApplicationUid(uid) == false) goto L4;
        uids.add(Integer.valueOf(Process.toSdkSandboxUid(uid)));
        goto L4
    L12:
        return uids;
    }

    Set<Range<Integer>> createUserAndRestrictedProfilesRanges(int userId, List<String> allowedApplications, List<String> disallowedApplications) {
        Set<Range<Integer>> ranges = new ArraySet();
        addUserToRanges(ranges, userId, allowedApplications, disallowedApplications);
        if (canHaveRestrictedProfile(userId) == false) goto L18;
        long token = Binder.clearCallingIdentity();
        List<UserInfo> users = this.mUserManager.getAliveUsers();     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        Iterator<UserInfo> r4 = users.iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        UserInfo user = r4.next();
        if (user.isRestricted() == false) goto L8;
        if (user.restrictedProfileParentId != userId) goto L8;
        addUserToRanges(ranges, user.id, allowedApplications, disallowedApplications);
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        return ranges;
    }

    void addUserToRanges(Set<Range<Integer>> ranges, int userId, List<String> allowedApplications, List<String> disallowedApplications) {
        if (allowedApplications == null) goto L16;
        int start = -1;
        int stop = -1;
        Iterator<Integer> r2 = getAppsUids(allowedApplications, userId).iterator();
    L5:
        if (r2.hasNext() == false) goto L13;
        int uid = r2.next().intValue();
        if (start != (-1)) goto L10;
        start = uid;
    L12:
        stop = uid;
        goto L5
    L10:
        if (uid == (stop + 1)) goto L12;
        ranges.add(new Range(Integer.valueOf(start), Integer.valueOf(stop)));
        start = uid;
        goto L12
    L13:
        if (start == (-1)) goto L42;
        ranges.add(new Range(Integer.valueOf(start), Integer.valueOf(stop)));
        return;
    L42:
        return;
    L16:
        if (disallowedApplications == null) goto L29;
        Range<Integer> userRange = createUidRangeForUser(userId);
        int start2 = ((Integer) userRange.getLower()).intValue();
        Iterator<Integer> r3 = getAppsUids(disallowedApplications, userId).iterator();
    L19:
        if (r3.hasNext() == false) goto L26;
        int uid2 = r3.next().intValue();
        if (uid2 == start2) goto L22;
        ranges.add(new Range(Integer.valueOf(start2), Integer.valueOf(uid2 - 1)));
        start2 = uid2 + 1;
        goto L19
    L22:
        start2 = start2 + 1;
        goto L19
    L26:
        if (start2 > ((Integer) userRange.getUpper()).intValue()) goto L44;
        ranges.add(new Range(Integer.valueOf(start2), (Integer) userRange.getUpper()));
        return;
    L44:
        return;
    L29:
        ranges.add(createUidRangeForUser(userId));
    }

    private static List<Range<Integer>> uidRangesForUser(int userId, Set<Range<Integer>> existingRanges) {
        Range<Integer> userRange = createUidRangeForUser(userId);
        List<Range<Integer>> ranges = new ArrayList();
        Iterator<Range<Integer>> r2 = existingRanges.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Range<Integer> range = r2.next();
        if (userRange.contains(range) == false) goto L4;
        ranges.add(range);
        goto L4
    L9:
        return ranges;
    }

    public void onUserAdded(int userId) {
        UserInfo user = this.mUserManager.getUserInfo(userId);
        if (user != null) goto L7;
        Log.e(TAG, "Can not retrieve UserInfo for userId=" + userId);
        return;
    L7:
        if (user.isRestricted() == true) goto L9;
        return;
    L9:
        if (user.restrictedProfileParentId != this.mUserId) goto L32;
        monitor-enter(this);
        Set existingRanges = this.mNetworkCapabilities.getUids();     // Catch: Throwable -> L15
        if (existingRanges != null) goto L30;
    L22:
        setVpnForcedLocked(this.mLockdown);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L30:
        addUserToRanges(existingRanges, userId, this.mConfig.allowedApplications, this.mConfig.disallowedApplications);     // Catch: Throwable -> L15 Exception -> L17
        this.mNetworkCapabilities = new NetworkCapabilities.Builder(this.mNetworkCapabilities).setUids(existingRanges).build();     // Catch: Throwable -> L15 Exception -> L17
    L20:
        if (this.mNetworkAgent == null) goto L22;
        doSendNetworkCapabilities(this.mNetworkAgent, this.mNetworkCapabilities);     // Catch: Throwable -> L15
    L17:
        e = move-exception;
        Log.wtf(TAG, "Failed to add restricted user to owner", e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public void onUserRemoved(int userId) {
        UserInfo user = this.mUserManager.getUserInfo(userId);
        if (user != null) goto L7;
        Log.e(TAG, "Can not retrieve UserInfo for userId=" + userId);
        return;
    L7:
        if (user.isRestricted() == true) goto L9;
        return;
    L9:
        if (user.restrictedProfileParentId != this.mUserId) goto L32;
        monitor-enter(this);
        Set<Range<Integer>> existingRanges = this.mNetworkCapabilities.getUids();     // Catch: Throwable -> L15
        if (existingRanges != null) goto L28;
    L22:
        setVpnForcedLocked(this.mLockdown);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L28:
        List<Range<Integer>> removedRanges = uidRangesForUser(userId, existingRanges);     // Catch: Throwable -> L15 Exception -> L17
        existingRanges.removeAll(removedRanges);     // Catch: Throwable -> L15 Exception -> L17
        this.mNetworkCapabilities = new NetworkCapabilities.Builder(this.mNetworkCapabilities).setUids(existingRanges).build();     // Catch: Throwable -> L15 Exception -> L17
    L20:
        if (this.mNetworkAgent == null) goto L22;
        doSendNetworkCapabilities(this.mNetworkAgent, this.mNetworkCapabilities);     // Catch: Throwable -> L15
    L17:
        e = move-exception;
        Log.wtf(TAG, "Failed to remove restricted user to owner", e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void onUserStopped() {
        monitor-enter(this);
        setVpnForcedLocked(false);     // Catch: Throwable -> L7
        this.mAlwaysOn = false;     // Catch: Throwable -> L7
        agentDisconnect();     // Catch: Throwable -> L7
        this.mConnectivityManager.unregisterNetworkProvider(this.mNetworkProvider);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void setVpnForcedLocked(boolean enforce) {
        if (isNullOrLegacyVpn(this.mPackage) == false) goto L5;
        List<String> exemptedPackages = null;
    L6:
        Set<UidRangeParcel> rangesToRemove = new ArraySet(this.mBlockedUidsAsToldToConnectivity);
        if (enforce == false) goto L21;
        Set<Range<Integer>> restrictedProfilesRanges = createUserAndRestrictedProfilesRanges(this.mUserId, null, exemptedPackages);
        Set<UidRangeParcel> rangesThatShouldBeBlocked = new ArraySet();
        Iterator<Range<Integer>> r5 = restrictedProfilesRanges.iterator();
    L10:
        if (r5.hasNext() == false) goto L20;
        Range<Integer> range = r5.next();
        if (((Integer) range.getLower()).intValue() != 0) goto L17;
        if (((Integer) range.getUpper()).intValue() == 0) goto L17;
        rangesThatShouldBeBlocked.add(new UidRangeParcel(1, ((Integer) range.getUpper()).intValue()));
    L17:
        if (((Integer) range.getLower()).intValue() == 0) goto L10;
        rangesThatShouldBeBlocked.add(new UidRangeParcel(((Integer) range.getLower()).intValue(), ((Integer) range.getUpper()).intValue()));
        goto L10
    L20:
        rangesToRemove.removeAll(rangesThatShouldBeBlocked);
        Set<UidRangeParcel> rangesToAdd = rangesThatShouldBeBlocked;
        rangesToAdd.removeAll(this.mBlockedUidsAsToldToConnectivity);
    L22:
        setAllowOnlyVpnForUids(false, rangesToRemove);
        setAllowOnlyVpnForUids(true, rangesToAdd);
        return;
    L21:
        rangesToAdd = Collections.emptySet();
        goto L22
    L5:
        exemptedPackages = new ArrayList(this.mLockdownAllowlist);
        exemptedPackages.add(this.mPackage);
        goto L6
    }

    private boolean setAllowOnlyVpnForUids(boolean enforce, Collection<UidRangeParcel> ranges) {
        if (ranges.size() != 0) goto L5;
        return true;
    L5:
        ArrayList<Range<Integer>> integerRanges = new ArrayList(ranges.size());
        Iterator<UidRangeParcel> r2 = ranges.iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        UidRangeParcel uidRange = r2.next();
        integerRanges.add(new Range(Integer.valueOf(uidRange.start), Integer.valueOf(uidRange.stop)));
        goto L7
    L17:
        this.mConnectivityManager.setRequireVpnForUids(enforce, integerRanges);     // Catch: RuntimeException -> L14
        if (enforce == false) goto L12;
        this.mBlockedUidsAsToldToConnectivity.addAll(ranges);
    L13:
        return true;
    L12:
        this.mBlockedUidsAsToldToConnectivity.removeAll(ranges);
    L14:
        e = move-exception;
        Log.e(TAG, "Updating blocked=" + enforce + " for UIDs " + Arrays.toString(ranges.toArray()) + " failed", e);
        return false;
    }

    public synchronized VpnConfig getVpnConfig() {
        monitor-enter(this);
        enforceControlPermission();     // Catch: Throwable -> L11
        if (this.mConfig != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        VpnConfig r0 = new VpnConfig(this.mConfig);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized void interfaceStatusChanged(String iface, boolean up) {
        monitor-enter(this);
        this.mObserver.interfaceStatusChanged(iface, up);     // Catch: Throwable -> L5 RemoteException -> L7
    L5:
        th = move-exception;
        throw th;
    L11:
        monitor-exit(this);
    }

    private void cleanupVpnStateLocked() {
        this.mStatusIntent = null;
        resetNetworkCapabilities();
        this.mConfig = null;
        this.mInterface = null;
        this.mVpnRunner = null;
        this.mConnection = null;
        agentDisconnect();
    }

    private void enforceControlPermission() {
        this.mContext.enforceCallingPermission("android.permission.CONTROL_VPN", "Unauthorized Caller");
    }

    private void enforceControlPermissionOrInternalCaller() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.CONTROL_VPN", "Unauthorized Caller");
    }

    private void enforceSettingsPermission() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.NETWORK_SETTINGS", "Unauthorized Caller");
    }

    private void showNotification(String label, Bitmap icon, int user) {
        PendingIntent contentIntent = null;
        if (this.mConfig != null) goto L5;
        return;
    L5:
        long token = Binder.clearCallingIdentity();
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L7:
        if (this.mConfigIntent == null) goto L11;
        this.mContext.removeStickyBroadcast(this.mConfigIntent);     // Catch: Throwable -> L9
    L11:
        this.mConfigIntent = new Intent(VPN_CONFIG);     // Catch: Throwable -> L9
        this.mConfigIntent.putExtra(VPN_CONFIG_EXTRA, this.mConfig);     // Catch: Throwable -> L9
        this.mContext.sendStickyBroadcast(this.mConfigIntent);     // Catch: Throwable -> L9
        SystemProperties.set("sys.net.connectedVPN", this.mConfig.session);     // Catch: Throwable -> L9
        if (this.mEnableNotif == true) goto L15;
        Binder.restoreCallingIdentity(token);
        return;
    L15:
        NotificationManager nm = (NotificationManager) this.mContext.getSystemService("notification");     // Catch: Throwable -> L9
        if (nm == null) goto L25;
        if (label != null) goto L19;
        String title = this.mContext.getString(17042357);     // Catch: Throwable -> L9
    L21:
        if (this.mConfig.session != null) goto L23;
        String text = this.mContext.getString(17042355);     // Catch: Throwable -> L9
    L24:
        contentIntent = VpnConfig.getIntentForStatusPanel(this.mContext);     // Catch: Throwable -> L9
        this.notification = new Notification.Builder(this.mContext, NETWORKTYPE);     // Catch: Throwable -> L9
        this.notification.setSmallIcon(17305537);     // Catch: Throwable -> L9
        this.notification.setLargeIcon(icon);     // Catch: Throwable -> L9
        this.notification.setContentTitle(title);     // Catch: Throwable -> L9
        this.notification.setContentText(text);     // Catch: Throwable -> L9
        this.notification.setContentIntent(contentIntent);     // Catch: Throwable -> L9
        this.notification.setDefaults(0);     // Catch: Throwable -> L9
        this.notification.setOngoing(true);     // Catch: Throwable -> L9
        nm.notify(17305537, this.notification.build());     // Catch: Throwable -> L9
        goto L25
    L23:
        text = this.mContext.getString(17042356, new Object[]{this.mConfig.session});     // Catch: Throwable -> L9
        goto L24
    L19:
        title = this.mContext.getString(17042358, new Object[]{label});     // Catch: Throwable -> L9
    L25:
        Binder.restoreCallingIdentity(token);
        Intent intent = new Intent(VPN_STATE_CHANGE);
        intent.putExtra(VPN_STATE_EXTRA_INT, VPN_STATE_ON);
        if (contentIntent == null) goto L28;
        intent.putExtra(VPN_STATE_INTENT, contentIntent);
    L28:
        this.mContext.sendBroadcast(intent);
    }

    private void hideNotification(int user, int reason) {
        this.mConfig = null;
        SystemProperties.set("sys.net.connectedVPN", "");
        long token = Binder.clearCallingIdentity();
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L4:
        if (this.mConfigIntent == null) goto L9;
        this.mContext.removeStickyBroadcast(this.mConfigIntent);     // Catch: Throwable -> L6
        this.mConfigIntent = null;     // Catch: Throwable -> L6
    L9:
        if (this.notification == null) goto L12;
        this.notification = null;     // Catch: Throwable -> L6
    L12:
        if (this.mEnableNotif == true) goto L15;
        Binder.restoreCallingIdentity(token);
        return;
    L15:
        this.mStatusIntent = null;     // Catch: Throwable -> L6
        NotificationManager nm = (NotificationManager) this.mContext.getSystemService("notification");     // Catch: Throwable -> L6
        if (nm == null) goto L18;
        nm.cancelAsUser(null, 17305537, new UserHandle(user));     // Catch: Throwable -> L6
    L18:
        Binder.restoreCallingIdentity(token);
        Intent intent = new Intent(VPN_STATE_CHANGE);
        intent.putExtra(VPN_STATE_EXTRA_INT, VPN_STATE_OFF);
        intent.putExtra(VPN_DISCONNECT_REASON, reason);
        this.mContext.sendBroadcast(intent);
    }

    private void prepareStatusIntent() {
        long token = Binder.clearCallingIdentity();
        this.mStatusIntent = this.mDeps.getIntentForStatusPanel(this.mContext);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public synchronized boolean addAddress(String address, int prefixLength) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isCallerEstablishedOwnerLocked() == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean success = jniAddAddress(this.mInterface, address, prefixLength);     // Catch: Throwable -> L11
        doSendLinkProperties(this.mNetworkAgent, makeLinkProperties());     // Catch: Throwable -> L11
        monitor-exit(this);
        return success;
    }

    public synchronized boolean removeAddress(String address, int prefixLength) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isCallerEstablishedOwnerLocked() == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean success = jniDelAddress(this.mInterface, address, prefixLength);     // Catch: Throwable -> L11
        doSendLinkProperties(this.mNetworkAgent, makeLinkProperties());     // Catch: Throwable -> L11
        monitor-exit(this);
        return success;
    }

    public synchronized boolean setUnderlyingNetworks(Network[] networks) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isCallerEstablishedOwnerLocked() == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        VpnConfig r0 = this.mConfig;     // Catch: Throwable -> L11
        List<Network> r1 = null;
        if (networks == null) goto L13;
        Network[] r2 = (Network[]) Arrays.copyOf(networks, networks.length);     // Catch: Throwable -> L11
    L14:
        r0.underlyingNetworks = r2;     // Catch: Throwable -> L11
        NetworkAgent r3 = this.mNetworkAgent;     // Catch: Throwable -> L11
        if (this.mConfig.underlyingNetworks == null) goto L18;
        r1 = Arrays.asList(this.mConfig.underlyingNetworks);     // Catch: Throwable -> L11
    L18:
        doSetUnderlyingNetworks(r3, r1);     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L13:
        r2 = null;
        goto L14
    }

    public synchronized UnderlyingNetworkInfo getUnderlyingNetworkInfo() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isRunningLocked() == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        UnderlyingNetworkInfo r0 = new UnderlyingNetworkInfo(this.mOwnerUID, this.mInterface, new ArrayList());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    }

    public synchronized boolean appliesToUid(int uid) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (isRunningLocked() == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        Set<Range<Integer>> uids = this.mNetworkCapabilities.getUids();     // Catch: Throwable -> L21
        if (uids != null) goto L13;
        monitor-exit(this);
        return true;
    L13:
        Iterator<Range<Integer>> r3 = uids.iterator();     // Catch: Throwable -> L21
    L15:
        if (r3.hasNext() == false) goto L23;
        Range<Integer> range = r3.next();     // Catch: Throwable -> L21
        if (range.contains(Integer.valueOf(uid)) == false) goto L15;
        monitor-exit(this);
        return true;
    L23:
        monitor-exit(this);
        return false;
    }

    public synchronized int getActiveVpnType() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.mNetworkInfo.isConnectedOrConnecting() == true) goto L9;
        monitor-exit(this);
        return -1;
    L9:
        if (this.mVpnRunner != null) goto L13;
        monitor-exit(this);
        return 1;
    L13:
        if (isIkev2VpnRunner() == false) goto L16;
        int r0 = 2;
    L17:
        monitor-exit(this);
        return r0;
    L16:
        r0 = 3;
        goto L17
    }

    private void updateAlwaysOnNotification(NetworkInfo.DetailedState networkState) {
        if (this.mAlwaysOn == true) goto L5;
    L7:
        boolean visible = false;
    L8:
        UserHandle user = UserHandle.of(this.mUserId);
        long token = Binder.clearCallingIdentity();
        NotificationManager notificationManager = (NotificationManager) this.mUserIdContext.getSystemService(NotificationManager.class);     // Catch: Throwable -> L15
        if (visible == true) goto L17;
        notificationManager.cancel(TAG, 17);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        return;
    L17:
        Intent intent = new Intent();     // Catch: Throwable -> L15
        intent.setComponent(ComponentName.unflattenFromString(this.mContext.getString(R.string.config_defaultTranslationService)));     // Catch: Throwable -> L15
        intent.putExtra("lockdown", this.mLockdown);     // Catch: Throwable -> L15
        intent.addFlags(268435456);     // Catch: Throwable -> L15
        PendingIntent configIntent = this.mSystemServices.pendingIntentGetActivityAsUser(intent, AudioFormat.DTS_HD, user);     // Catch: Throwable -> L15
        Notification.Builder builder = new Notification.Builder(this.mContext, NETWORKTYPE).setSmallIcon(17305537).setContentTitle(this.mContext.getString(17042353)).setContentText(this.mContext.getString(17042350)).setContentIntent(configIntent).setCategory("sys").setVisibility(1).setOngoing(true).setColor(this.mContext.getColor(R.color.system_notification_accent_color));     // Catch: Throwable -> L15
        notificationManager.notify(TAG, 17, builder.build());     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        return;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L5:
        if (networkState == NetworkInfo.DetailedState.CONNECTED) goto L7;
        visible = true;
        goto L8
    }

    private void enforceNotRestrictedUser() {
        long token = Binder.clearCallingIdentity();
        UserInfo user = this.mUserManager.getUserInfo(this.mUserId);     // Catch: Throwable -> L9
        if (user.isRestricted() == true) goto L8;
        Binder.restoreCallingIdentity(token);
        return;
    L8:
        throw new SecurityException("Restricted users cannot configure VPNs");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void startLegacyVpn(VpnProfile profile) {
        enforceControlPermission();
        long token = Binder.clearCallingIdentity();
        startLegacyVpnPrivileged(profile);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private String makeKeystoreEngineGrantString(String alias) {
        if (alias != null) goto L5;
        return null;
    L5:
        KeyStore2 keystore2 = KeyStore2.getInstance();
        KeyDescriptor key = new KeyDescriptor();
        key.domain = 0;
        key.nspace = -1;
        key.alias = alias;
        key.blob = null;
        return KeyStore2.makeKeystoreEngineGrantString(keystore2.grant(key, 1016, 260).nspace);
    L9:
        e = move-exception;
        Log.e(TAG, "Failed to get grant for keystore key.", e);
        throw new IllegalStateException("Failed to get grant for keystore key.", e);
    }

    private String getCaCertificateFromKeystoreAsPem(KeyStore keystore, String alias) throws KeyStoreException, IOException, CertificateEncodingException {
        if (keystore.isCertificateEntry(alias) == false) goto L9;
        Certificate cert = keystore.getCertificate(alias);
        if (cert != null) goto L8;
        return null;
    L8:
        return new String(Credentials.convertToPem(new Certificate[]{cert}), StandardCharsets.UTF_8);
    L9:
        Certificate[] certs = keystore.getCertificateChain(alias);
        if (certs != null) goto L12;
    L16:
        return null;
    L12:
        if (certs.length <= 1) goto L16;
        return new String(Credentials.convertToPem((Certificate[]) Arrays.copyOfRange(certs, 1, certs.length)), StandardCharsets.UTF_8);
    }

    public void startLegacyVpnPrivileged(VpnProfile profileToStart) {
        VpnProfile profile = profileToStart.clone();
        UserInfo user = this.mUserManager.getUserInfo(this.mUserId);
        if (user.isRestricted() == true) goto L46;
        if (this.mUserManager.hasUserRestriction("no_config_vpn", new UserHandle(this.mUserId)) == true) goto L46;
        String privateKey = "";
        String userCert = "";
        String caCert = "";
        String serverCert = "";
        KeyStore keystore = KeyStore.getInstance("AndroidKeyStore");     // Catch: Throwable -> L14
        String r7 = null;
        keystore.load(null);     // Catch: Throwable -> L14
        if (profile.ipsecUserCert.isEmpty() == true) goto L17;
        privateKey = profile.ipsecUserCert;     // Catch: Throwable -> L14
        Certificate cert = keystore.getCertificate(profile.ipsecUserCert);     // Catch: Throwable -> L14
        if (cert != null) goto L12;
        String r11 = null;
    L13:
        userCert = r11;
        goto L17
    L12:
        r11 = new String(Credentials.convertToPem(new Certificate[]{cert}), StandardCharsets.UTF_8);     // Catch: Throwable -> L14
    L17:
        if (profile.ipsecCaCert.isEmpty() == true) goto L20;
        caCert = getCaCertificateFromKeystoreAsPem(keystore, profile.ipsecCaCert);     // Catch: Throwable -> L14
    L20:
        if (profile.ipsecServerCert.isEmpty() == true) goto L27;
        Certificate cert2 = keystore.getCertificate(profile.ipsecServerCert);     // Catch: Throwable -> L14
        if (cert2 == null) goto L25;
        r7 = new String(Credentials.convertToPem(new Certificate[]{cert2}), StandardCharsets.UTF_8);     // Catch: Throwable -> L14
    L25:
        serverCert = r7;
    L27:
        if (userCert == null) goto L42;
        if (caCert == null) goto L42;
        if (serverCert == null) goto L42;
        switch(profile.type) {
            case 6: goto L39;
            case 7: goto L37;
            case 8: goto L36;
            case 9: goto L34;
            default: goto L33;
        };
    L34:
        startVpnProfilePrivileged(profile, "[Legacy VPN]");
        return;
    L36:
        profile.ipsecSecret = "KEYSTORE_ALIAS:" + privateKey;
        profile.ipsecUserCert = userCert;
        goto L39
    L37:
        profile.ipsecSecret = Ikev2VpnProfile.encodeForIpsecSecret(profile.ipsecSecret.getBytes());
        profile.setAllowedAlgorithms(Ikev2VpnProfile.DEFAULT_ALGORITHMS);
        startVpnProfilePrivileged(profile, "[Legacy VPN]");
        return;
    L39:
        profile.ipsecCaCert = caCert;
        profile.setAllowedAlgorithms(Ikev2VpnProfile.DEFAULT_ALGORITHMS);
        startVpnProfilePrivileged(profile, "[Legacy VPN]");
        return;
    L33:
        throw new UnsupportedOperationException("Legacy VPN is deprecated");
    L42:
        throw new IllegalStateException("Cannot load credentials");
    L14:
        e = move-exception;
        throw new IllegalStateException("Failed to load credentials from AndroidKeyStore", e);
    L46:
        throw new SecurityException("Restricted users cannot establish VPNs");
    }

    private boolean isSettingsVpnLocked() {
        if (this.mVpnRunner != null) goto L5;
    L7:
        return false;
    L5:
        if ("[Legacy VPN]".equals(this.mPackage) == false) goto L7;
        return true;
    }

    public synchronized void stopVpnRunnerPrivileged() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isSettingsVpnLocked() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mVpnRunner.exit();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public synchronized LegacyVpnInfo getLegacyVpnInfo() {
        monitor-enter(this);
        enforceControlPermission();     // Catch: Throwable -> L6
        LegacyVpnInfo r0 = getLegacyVpnInfoPrivileged();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized LegacyVpnInfo getLegacyVpnInfoPrivileged() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (isSettingsVpnLocked() == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        LegacyVpnInfo info = new LegacyVpnInfo();     // Catch: Throwable -> L12
        info.key = this.mConfig.user;     // Catch: Throwable -> L12
        info.state = this.mLegacyState;     // Catch: Throwable -> L12
        if (this.mNetworkInfo.isConnected() == false) goto L14;
        info.intent = this.mStatusIntent;     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return info;
    }

    public synchronized VpnConfig getLegacyVpnConfig() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (isSettingsVpnLocked() == false) goto L10;
        VpnConfig r0 = this.mConfig;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L10:
        monitor-exit(this);
        return null;
    }

    private synchronized NetworkCapabilities getRedactedNetworkCapabilities(NetworkCapabilities nc) {
        monitor-enter(this);
        if (nc != null) goto L13;
        monitor-exit(this);
        return null;
    L13:
        NetworkCapabilities r0 = this.mConnectivityManager.getRedactedNetworkCapabilitiesForPackage(nc, this.mOwnerUID, this.mPackage);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized LinkProperties getRedactedLinkProperties(LinkProperties lp) {
        monitor-enter(this);
        if (lp != null) goto L13;
        monitor-exit(this);
        return null;
    L13:
        LinkProperties r0 = this.mConnectivityManager.getRedactedLinkPropertiesForPackage(lp, this.mOwnerUID, this.mPackage);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    private static boolean isIPv6Only(List<LinkAddress> linkAddresses) {
        boolean hasIPV6 = false;
        boolean hasIPV4 = false;
        Iterator<LinkAddress> r2 = linkAddresses.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        LinkAddress address = r2.next();
        hasIPV6 = hasIPV6 | address.isIpv6();
        hasIPV4 = hasIPV4 | address.isIpv4();
        goto L4
    L6:
        if (hasIPV6 == false) goto L9;
        if (hasIPV4 == true) goto L9;
        return true;
    L9:
        return false;
    }

    private void setVpnNetworkPreference(final String session, final Set<Range<Integer>> ranges) {
        BinderUtils.withCleanCallingIdentity(new Vpn$$ExternalSyntheticLambda0(this, session, ranges));
    }

    private /* synthetic */ void lambda$setVpnNetworkPreference$0(String session, Set ranges) throws RuntimeException {
        this.mConnectivityManager.setVpnDefaultForUids(session, ranges);
    }

    private void clearVpnNetworkPreference(final String session) {
        BinderUtils.withCleanCallingIdentity(new Vpn$$ExternalSyntheticLambda1(this, session));
    }

    private /* synthetic */ void lambda$clearVpnNetworkPreference$1(String session) throws RuntimeException {
        this.mConnectivityManager.setVpnDefaultForUids(session, Collections.EMPTY_LIST);
    }

    private void verifyCallingUidAndPackage(String packageName) {
        this.mDeps.verifyCallingUidAndPackage(this.mContext, packageName, this.mUserId);
    }

    String getProfileNameForPackage(String packageName) {
        return "PLATFORM_VPN_" + this.mUserId + "_" + packageName;
    }

    void validateRequiredFeatures(VpnProfile profile) {
        switch(profile.type) {
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return;
    L6:
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.ipsec_tunnels") == false) goto L9;
        return;
    L9:
        throw new UnsupportedOperationException("Ikev2VpnProfile(s) requires PackageManager.FEATURE_IPSEC_TUNNELS");
    }

    public synchronized boolean provisionVpnProfile(String packageName, VpnProfile profile) {
        monitor-enter(this);
        packageName.getClass();     // Catch: Throwable -> L6
        profile.getClass();     // Catch: Throwable -> L6
        verifyCallingUidAndPackage(packageName);     // Catch: Throwable -> L6
        enforceNotRestrictedUser();     // Catch: Throwable -> L6
        validateRequiredFeatures(profile);     // Catch: Throwable -> L6
        if (profile.isRestrictedToTestNetworks == false) goto L8;
        this.mContext.enforceCallingPermission("android.permission.MANAGE_TEST_NETWORKS", "Test-mode profiles require the MANAGE_TEST_NETWORKS permission");     // Catch: Throwable -> L6
    L8:
        byte[] encodedProfile = profile.encode();     // Catch: Throwable -> L6
        if (encodedProfile.length > 131072) goto L19;
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L6
        getVpnProfileStore().put(getProfileNameForPackage(packageName), encodedProfile);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L6
        boolean r3 = isVpnProfilePreConsented(this.mContext, packageName);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L19:
        throw new IllegalArgumentException("Profile too big");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private boolean isCurrentIkev2VpnLocked(String packageName) {
        if (isCurrentPreparedPackage(packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (isIkev2VpnRunner() == false) goto L7;
        return true;
    }

    public synchronized void deleteVpnProfile(String packageName) {
        monitor-enter(this);
        packageName.getClass();     // Catch: Throwable -> L16
        verifyCallingUidAndPackage(packageName);     // Catch: Throwable -> L16
        enforceNotRestrictedUser();     // Catch: Throwable -> L16
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L16
    L18:
        th = th;
    L19:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L5:
        if (isCurrentIkev2VpnLocked(packageName) == true) goto L27;
    L12:
        getVpnProfileStore().remove(getProfileNameForPackage(packageName));     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L27:
    L9:
        th = th;
        goto L19
    L7:
        if (this.mAlwaysOn == false) goto L11;
        setAlwaysOnPackage(null, false, null);     // Catch: Throwable -> L9
    L26:
        goto L12
    L11:
        prepareInternal("[Legacy VPN]");     // Catch: Throwable -> L9
    L16:
        th = move-exception;
        throw th;
    }

    VpnProfile getVpnProfilePrivileged(String packageName) {
        if (this.mDeps.isCallerSystem() == true) goto L6;
        Log.wtf(TAG, "getVpnProfilePrivileged called as non-System UID ");
        return null;
    L6:
        byte[] encoded = getVpnProfileStore().get(getProfileNameForPackage(packageName));
        if (encoded != null) goto L10;
        return null;
    L10:
        return VpnProfile.decode("", encoded);
    }

    private boolean isIkev2VpnRunner() {
        return this.mVpnRunner instanceof IkeV2VpnRunner;
    }

    private String getSessionKeyLocked() {
        boolean isIkev2VpnRunner = isIkev2VpnRunner();
        if (isIkev2VpnRunner == false) goto L5;
        String sessionKey = IkeV2VpnRunner.m3135$$Nest$fgetmSessionKey((IkeV2VpnRunner) this.mVpnRunner);
    L6:
        Log.d(TAG, "getSessionKeyLocked: isIkev2VpnRunner = " + isIkev2VpnRunner + ", sessionKey = " + sessionKey);
        return sessionKey;
    L5:
        sessionKey = null;
        goto L6
    }

    public synchronized String startVpnProfile(String packageName) {
        monitor-enter(this);
        packageName.getClass();     // Catch: Throwable -> L14
        enforceNotRestrictedUser();     // Catch: Throwable -> L14
        if (prepare(packageName, null, 2) == false) goto L27;
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
        VpnProfile profile = getVpnProfilePrivileged(packageName);     // Catch: Throwable -> L20
        if (profile == null) goto L23;
        startVpnProfilePrivileged(profile, packageName);     // Catch: Throwable -> L20
        if (isIkev2VpnRunner() == false) goto L19;
        String r3 = getSessionKeyLocked();     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r3;
    L16:
        th = th;
    L24:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L19:
        throw new IllegalStateException("mVpnRunner shouldn't be null and should also be an instance of Ikev2VpnRunner");     // Catch: Throwable -> L20
    L23:
        throw new IllegalArgumentException("No profile found for " + packageName);     // Catch: Throwable -> L20
    L20:
        th = th;
        goto L24
    L27:
        throw new SecurityException("User consent not granted for package " + packageName);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private synchronized void startVpnProfilePrivileged(VpnProfile profile, String packageName) {
        monitor-enter(this);
        prepareInternal(packageName);     // Catch: Throwable -> L8
        updateState(NetworkInfo.DetailedState.CONNECTING, "startPlatformVpn");     // Catch: Throwable -> L8
        VpnConfig config = new VpnConfig();     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        if ("[Legacy VPN]".equals(packageName) == false) goto L12;
        config.legacy = true;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        config.session = profile.name;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        config.user = profile.key;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        config.isMetered = true;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
    L13:
        config.startTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        config.proxyInfo = profile.proxy;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        config.requiresInternetValidation = profile.requiresInternetValidation;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        config.excludeLocalRoutes = profile.excludeLocalRoutes;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        config.allowBypass = profile.isBypassable;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        config.disallowedApplications = getAppExclusionList(this.mPackage);     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        this.mConfig = config;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        switch(profile.type) {
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L16;
            default: goto L15;
        };     // Catch: Throwable -> L8 GeneralSecurityException -> L10
    L15:
        this.mConfig = null;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        updateState(NetworkInfo.DetailedState.FAILED, "Invalid platform VPN type");     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        Log.d(TAG, "Unknown VPN profile type: " + profile.type);     // Catch: Throwable -> L8 GeneralSecurityException -> L10
    L18:
        if ("[Legacy VPN]".equals(packageName) == true) goto L21;
        this.mAppOpsManager.startOp("android:establish_vpn_manager", this.mOwnerUID, this.mPackage, null, null);     // Catch: Throwable -> L8 GeneralSecurityException -> L10
    L21:
        monitor-exit(this);
        return;
    L16:
        this.mVpnRunner = new IkeV2VpnRunner(this, Ikev2VpnProfile.fromVpnProfile(profile), this.mDeps.newScheduledThreadPoolExecutor());     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        this.mVpnRunner.start();     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        goto L18
    L12:
        config.user = packageName;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
        config.isMetered = profile.isMetered;     // Catch: Throwable -> L8 GeneralSecurityException -> L10
    L10:
        e = move-exception;
        this.mConfig = null;     // Catch: Throwable -> L8
        updateState(NetworkInfo.DetailedState.FAILED, "VPN startup failed");     // Catch: Throwable -> L8
        throw new IllegalArgumentException("VPN startup failed", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void stopVpnRunnerAndNotifyAppLocked() {
        int ownerUid = this.mOwnerUID;
        Intent intent = null;
        if (isVpnApp(this.mPackage) == false) goto L5;
        Vpn r3 = this;
        intent = r3.buildVpnManagerEventIntent("android.net.category.EVENT_DEACTIVATED_BY_USER", -1, -1, this.mPackage, getSessionKeyLocked(), makeVpnProfileStateLocked(), null, null, null);
    L6:
        r3.mVpnRunner.exit();
        if (intent != null) goto L9;
        return;
    L9:
        if (isVpnApp(r3.mPackage) == false) goto L13;
        notifyVpnManagerVpnStopped(r3.mPackage, ownerUid, intent);
        return;
    L13:
        return;
    L5:
        r3 = this;
        goto L6
    }

    public synchronized void stopVpnProfile(String packageName) {
        monitor-enter(this);
        packageName.getClass();     // Catch: Throwable -> L7
        enforceNotRestrictedUser();     // Catch: Throwable -> L7
        if (isCurrentIkev2VpnLocked(packageName) == false) goto L9;
        stopVpnRunnerAndNotifyAppLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized void notifyVpnManagerVpnStopped(String packageName, int ownerUID, Intent intent) {
        monitor-enter(this);
        this.mAppOpsManager.finishOp("android:establish_vpn_manager", ownerUID, packageName, null);     // Catch: Throwable -> L6
        this.mEventChanges.log("[VMEvent] " + packageName + " stopped");     // Catch: Throwable -> L6
        sendEventToVpnManagerApp(intent, packageName);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean storeAppExclusionList(String packageName, List<String> excludedApps) {
        PersistableBundle bundle = PersistableBundleUtils.fromList(excludedApps, PersistableBundleUtils.STRING_SERIALIZER);     // Catch: IOException -> L10
        byte[] data = PersistableBundleUtils.toDiskStableBytes(bundle);     // Catch: IOException -> L10
        long oldId = Binder.clearCallingIdentity();
        getVpnProfileStore().put(getVpnAppExcludedForPackage(packageName), data);     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(oldId);
        return true;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    L10:
        e = move-exception;
        Log.e(TAG, "problem writing into stream", e);
        return false;
    }

    String getVpnAppExcludedForPackage(String packageName) {
        return VPN_APP_EXCLUDED + this.mUserId + "_" + packageName;
    }

    public synchronized boolean setAppExclusionList(String packageName, List<String> excludedApps) {
        monitor-enter(this);
        enforceNotRestrictedUser();     // Catch: Throwable -> L12
        if (storeAppExclusionList(packageName, excludedApps) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        updateAppExclusionList(excludedApps);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void refreshPlatformVpnAppExclusionList() {
        monitor-enter(this);
        updateAppExclusionList(getAppExclusionList(this.mPackage));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void updateAppExclusionList(List<String> excludedApps) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mNetworkAgent != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (isIkev2VpnRunner() == false) goto L11;
        VpnConfig r0 = this.mConfig;     // Catch: Throwable -> L9
        r0.disallowedApplications = List.copyOf(excludedApps);     // Catch: Throwable -> L9
        this.mNetworkCapabilities = new NetworkCapabilities.Builder(this.mNetworkCapabilities).setUids(createUserAndRestrictedProfilesRanges(this.mUserId, null, excludedApps)).build();     // Catch: Throwable -> L9
        setVpnNetworkPreference(getSessionKeyLocked(), createUserAndRestrictedProfilesRanges(this.mUserId, this.mConfig.allowedApplications, this.mConfig.disallowedApplications));     // Catch: Throwable -> L9
        doSendNetworkCapabilities(this.mNetworkAgent, this.mNetworkCapabilities);     // Catch: Throwable -> L9
        goto L11
    }

    /* JADX WARN: Not initialized variable reg: 0, insn: 0x004a: INVOKE (r0 I:long A[D('oldId' long)]) STATIC call: android.os.Binder.restoreCallingIdentity(long):void A[Catch: all -> 0x0026, MD:(long):void (c), TRY_ENTER] (LINE:4711), block:B:28:0x004a */
    public synchronized List<String> getAppExclusionList(String packageName) {
        monitor-enter(this);
        long oldId = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        byte[] bytes = getVpnProfileStore().get(getVpnAppExcludedForPackage(packageName));     // Catch: Throwable -> L15 IOException -> L17
        if (bytes != null) goto L7;
    L19:
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L15 IOException -> L17
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r3;
    L7:
        if (bytes.length == 0) goto L19;
        PersistableBundle bundle = PersistableBundleUtils.fromDiskStableBytes(bytes);     // Catch: Throwable -> L15 IOException -> L17
        List<String> r4 = PersistableBundleUtils.toList(bundle, PersistableBundleUtils.STRING_DESERIALIZER);     // Catch: Throwable -> L15 IOException -> L17
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r4;
    L17:
        e = move-exception;
        Log.e(TAG, "problem reading from stream", e);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L13
        return new ArrayList();
    L13:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    }

    private int getStateFromLegacyState(int legacyState) {
        switch(legacyState) {
            case 0: goto L12;
            case 1: goto L4;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L4;
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        Log.wtf(TAG, "Unhandled state " + legacyState + ", treat it as STATE_DISCONNECTED");
        return 0;
    L6:
        return 3;
    L8:
        return 2;
    L10:
        return 1;
    L12:
        return 0;
    }

    private VpnProfileState makeVpnProfileStateLocked() {
        int r1 = getStateFromLegacyState(this.mLegacyState);
        if (isIkev2VpnRunner() == false) goto L5;
        String r2 = getSessionKeyLocked();
    L7:
        return new VpnProfileState(r1, r2, this.mAlwaysOn, this.mLockdown);
    L5:
        r2 = null;
        goto L7
    }

    private VpnProfileState makeDisconnectedVpnProfileState() {
        return new VpnProfileState(0, null, false, false);
    }

    public synchronized VpnProfileState getProvisionedVpnProfileState(String packageName) {
        monitor-enter(this);
        packageName.getClass();     // Catch: Throwable -> L7
        enforceNotRestrictedUser();     // Catch: Throwable -> L7
        if (isCurrentIkev2VpnLocked(packageName) == false) goto L9;
        VpnProfileState r0 = makeVpnProfileStateLocked();     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r0;
    L9:
        r0 = null;
    L7:
        th = move-exception;
        throw th;
    }

    private static void doSendLinkProperties(NetworkAgent agent, LinkProperties lp) {
        if ((agent instanceof VpnNetworkAgentWrapper) == false) goto L5;
        ((VpnNetworkAgentWrapper) agent).doSendLinkProperties(lp);
        return;
    L5:
        agent.sendLinkProperties(lp);
    }

    private static void doSendNetworkCapabilities(NetworkAgent agent, NetworkCapabilities nc) {
        if ((agent instanceof VpnNetworkAgentWrapper) == false) goto L5;
        ((VpnNetworkAgentWrapper) agent).doSendNetworkCapabilities(nc);
        return;
    L5:
        agent.sendNetworkCapabilities(nc);
    }

    private void doSetUnderlyingNetworks(NetworkAgent agent, List<Network> networks) {
        logUnderlyNetworkChanges(networks);
        if ((agent instanceof VpnNetworkAgentWrapper) == false) goto L5;
        ((VpnNetworkAgentWrapper) agent).doSetUnderlyingNetworks(networks);
        return;
    L5:
        agent.setUnderlyingNetworks(networks);
    }

    static Range<Integer> createUidRangeForUser(int userId) {
        return new Range(Integer.valueOf(userId * BZip2Constants.BASEBLOCKSIZE), Integer.valueOf(((userId + 1) * BZip2Constants.BASEBLOCKSIZE) - 1));
    }

    private String getVpnManagerEventClassName(int code) {
        switch(code) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN_CLASS";
    L5:
        return "ERROR_CLASS_RECOVERABLE";
    L7:
        return "ERROR_CLASS_NOT_RECOVERABLE";
    }

    private String getVpnManagerEventErrorName(int code) {
        switch(code) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN_ERROR";
    L5:
        return "ERROR_CODE_NETWORK_IO";
    L7:
        return "ERROR_CODE_NETWORK_LOST";
    L9:
        return "ERROR_CODE_NETWORK_PROTOCOL_TIMEOUT";
    L11:
        return "ERROR_CODE_NETWORK_UNKNOWN_HOST";
    }

    public void dump(IndentingPrintWriter pw) {
        monitor-enter(this);
        pw.println("Active package name: " + this.mPackage);     // Catch: Throwable -> L8
        pw.println("Active vpn type: " + getActiveVpnType());     // Catch: Throwable -> L8
        pw.println("NetworkCapabilities: " + this.mNetworkCapabilities);     // Catch: Throwable -> L8
        if (isIkev2VpnRunner() == false) goto L14;
        IkeV2VpnRunner runner = (IkeV2VpnRunner) this.mVpnRunner;     // Catch: Throwable -> L8
        pw.println("SessionKey: " + IkeV2VpnRunner.m3135$$Nest$fgetmSessionKey(runner));     // Catch: Throwable -> L8
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L8
        r1.append("MOBIKE ");     // Catch: Throwable -> L8
        if (IkeV2VpnRunner.m3131$$Nest$fgetmMobikeEnabled(runner) == false) goto L10;
        String r2 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L11:
        r1.append(r2);     // Catch: Throwable -> L8
        pw.println(r1.toString());     // Catch: Throwable -> L8
        pw.println("Profile: " + IkeV2VpnRunner.m3132$$Nest$fgetmProfile(runner));     // Catch: Throwable -> L8
        pw.println("Token: " + IkeV2VpnRunner.m3130$$Nest$fgetmCurrentToken(runner));     // Catch: Throwable -> L8
        pw.println("Validation failed retry count:" + runner.mValidationFailRetryCount);     // Catch: Throwable -> L8
        if (IkeV2VpnRunner.m3133$$Nest$fgetmScheduledHandleDataStallFuture(runner) == null) goto L14;
        pw.println("Reset session scheduled");     // Catch: Throwable -> L8
        goto L14
    L10:
        r2 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
    L14:
        pw.println();     // Catch: Throwable -> L8
        pw.println("mCachedCarrierConfigInfoPerSubId=" + this.mCachedCarrierConfigInfoPerSubId);     // Catch: Throwable -> L8
        pw.println("mEventChanges (most recent first):");     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        this.mEventChanges.reverseDump(pw);     // Catch: Throwable -> L8
        pw.decreaseIndent();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static int getCellSubIdForNetworkCapabilities(NetworkCapabilities nc) {
        if (nc != null) goto L6;
        return -1;
    L6:
        if (nc.hasTransport(0) == true) goto L8;
        return -1;
    L8:
        NetworkSpecifier specifier = nc.getNetworkSpecifier();
        if ((specifier instanceof TelephonyNetworkSpecifier) == true) goto L11;
        return -1;
    L11:
        return ((TelephonyNetworkSpecifier) specifier).getSubscriptionId();
    }
}
