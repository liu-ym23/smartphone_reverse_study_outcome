package com.android.server.net;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.INetd;
import android.net.INetdUnsolicitedEventListener;
import android.net.INetworkManagementEventObserver;
import android.net.InetAddresses;
import android.net.InterfaceConfiguration;
import android.net.InterfaceConfigurationParcel;
import android.net.IpPrefix;
import android.net.LinkAddress;
import android.net.RouteInfo;
import android.net.util.NetdService;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.INetworkManagementService;
import android.os.PermissionEnforcer;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.android.internal.app.IBatteryStats;
import com.android.internal.net.IOemNetd;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.HexDump;
import com.android.net.module.util.PermissionUtils;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.power.LowPowerStandbyController;
import com.google.android.collect.Maps;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkManagementService extends INetworkManagementService.Stub {
    private static final boolean DBG = false;
    private static final String TAG = "NetworkManagement";
    private HashMap<String, Long> mActiveAlerts;
    private HashMap<String, Long> mActiveQuotas;
    private IBatteryStats mBatteryStats;
    private final Context mContext;
    private final Handler mDaemonHandler;
    private volatile boolean mDataSaverMode;
    private final Dependencies mDeps;
    final SparseBooleanArray mFirewallChainStates;
    private volatile boolean mFirewallEnabled;
    protected INetd mNetdService;
    private final NetdUnsolicitedEventListener mNetdUnsolicitedEventListener;
    private final RemoteCallbackList<INetworkManagementEventObserver> mObservers;
    protected final Object mQuotaLock;
    private final Object mRulesLock;
    private NetworkManagementServiceSmtEx mSmtEx;
    private volatile boolean mStrictEnabled;
    private SparseBooleanArray mUidAllowOnMetered;
    private SparseIntArray mUidCleartextPolicy;
    private final SparseIntArray mUidFirewallBackgroundRules;
    private final SparseIntArray mUidFirewallDozableRules;
    private final SparseIntArray mUidFirewallLowPowerStandbyRules;
    private final SparseIntArray mUidFirewallPowerSaveRules;
    private final SparseIntArray mUidFirewallRestrictedRules;
    private final SparseIntArray mUidFirewallRules;
    private final SparseIntArray mUidFirewallStandbyRules;
    private final SparseIntArray mUidMeteredFirewallAllowRules;
    private final SparseIntArray mUidMeteredFirewallDenyAdminRules;
    private final SparseIntArray mUidMeteredFirewallDenyUserRules;
    private SparseBooleanArray mUidRejectOnMetered;
    private final boolean mUseMeteredFirewallChains;

    static class Dependencies {
        Dependencies() {
        }

        public IBinder getService(String name) {
            return ServiceManager.getService(name);
        }

        public void registerLocalService(NetworkManagementInternal nmi) {
            LocalServices.addService(NetworkManagementInternal.class, nmi);
        }

        public INetd getNetd() {
            return NetdService.get();
        }

        public int getCallingUid() {
            return Binder.getCallingUid();
        }
    }

    private class LocalService extends NetworkManagementInternal {
        final /* synthetic */ NetworkManagementService this$0;

        /* synthetic */ LocalService(NetworkManagementService r1, NetworkManagementServiceIA r2) {
            this(r1);
        }

        private LocalService(NetworkManagementService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.net.NetworkManagementInternal
        public boolean isNetworkRestrictedForUid(int uid) {
            return NetworkManagementService.m5934$$Nest$misNetworkRestrictedInternal(this.this$0, uid);
        }
    }

    private class NetdUnsolicitedEventListener extends INetdUnsolicitedEventListener.Stub {
        final /* synthetic */ NetworkManagementService this$0;

        /* JADX INFO: renamed from: $r8$lambda$--ZhjVYzWf5rB1bQpK2KpOpGMbQ, reason: not valid java name */
        public static /* synthetic */ void m5945$r8$lambda$ZhjVYzWf5rB1bQpK2KpOpGMbQ(NetdUnsolicitedEventListener r0, String r1) {
            r0.lambda$onInterfaceRemoved$6(r1);
        }

        public static /* synthetic */ void $r8$lambda$4UqRDfd7w24bPwXCxaaxEYTP5J0(NetdUnsolicitedEventListener r0, String r1, String r2) {
            r0.lambda$onQuotaLimitReached$1(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$6H1IPP0xbuUOBJ0zARtLg6fMa-E, reason: not valid java name */
        public static /* synthetic */ void m5946$r8$lambda$6H1IPP0xbuUOBJ0zARtLg6fMaE(NetdUnsolicitedEventListener r0, String r1, boolean r2) {
            r0.lambda$onInterfaceLinkStateChanged$8(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$Zj_TRrlRu8DjVi29609vd8jtbow(NetdUnsolicitedEventListener r0, int r1, boolean r2, long r3, int r5) {
            r0.lambda$onInterfaceClassActivityChanged$0(r1, r2, r3, r5);
        }

        public static /* synthetic */ void $r8$lambda$cEZjblgQTbkhVOZAra8yyTiiXlk(NetdUnsolicitedEventListener r0, String r1, LinkAddress r2) {
            r0.lambda$onInterfaceAddressRemoved$4(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$iqW51JeHJZy_bOi_o6JJ3a9MFEY(NetdUnsolicitedEventListener r0, String r1, LinkAddress r2) {
            r0.lambda$onInterfaceAddressUpdated$3(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$jfUEvv6nelVp7IK0ZFRq-iIQNJQ, reason: not valid java name */
        public static /* synthetic */ void m5947$r8$lambda$jfUEvv6nelVp7IK0ZFRqiIQNJQ(NetdUnsolicitedEventListener r0, String r1) {
            r0.lambda$onInterfaceAdded$5(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$jz5dHnJck71UiPt-sbHVxpkagmA, reason: not valid java name */
        public static /* synthetic */ void m5948$r8$lambda$jz5dHnJck71UiPtsbHVxpkagmA(NetdUnsolicitedEventListener r0, String r1, boolean r2) {
            r0.lambda$onInterfaceChanged$7(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$k450O0AvGFGVDrE8Q-YRBpOJme4, reason: not valid java name */
        public static /* synthetic */ void m5949$r8$lambda$k450O0AvGFGVDrE8QYRBpOJme4(NetdUnsolicitedEventListener r0, boolean r1, RouteInfo r2) {
            r0.lambda$onRouteChanged$9(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$tquS_Klr8MMD-WqiICOLMj4wBZg, reason: not valid java name */
        public static /* synthetic */ void m5950$r8$lambda$tquS_Klr8MMDWqiICOLMj4wBZg(NetdUnsolicitedEventListener r0, String r1, long r2, String[] r4) {
            r0.lambda$onInterfaceDnsServerInfo$2(r1, r2, r4);
        }

        /* synthetic */ NetdUnsolicitedEventListener(NetworkManagementService r1, NetworkManagementServiceIA r2) {
            this(r1);
        }

        private NetdUnsolicitedEventListener(NetworkManagementService r1) {
            this.this$0 = r1;
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceClassActivityChanged(final boolean isActive, final int label, long timestamp, final int uid) throws RemoteException {
            if (timestamp > 0) goto L5;
            final long timestampNanos = SystemClock.elapsedRealtimeNanos();
        L6:
            NetworkManagementService.m5933$$Nest$fgetmDaemonHandler(this.this$0).post(new NetworkManagementService$NetdUnsolicitedEventListener$$ExternalSyntheticLambda3(this, label, isActive, timestampNanos, uid));
            return;
        L5:
            timestampNanos = timestamp;
            goto L6
        }

        private /* synthetic */ void lambda$onInterfaceClassActivityChanged$0(int label, boolean isActive, long timestampNanos, int uid) {
            NetworkManagementService.m5938$$Nest$mnotifyInterfaceClassActivity(this.this$0, label, isActive, timestampNanos, uid);
        }

        private /* synthetic */ void lambda$onQuotaLimitReached$1(String alertName, String ifName) {
            NetworkManagementService.m5943$$Nest$mnotifyLimitReached(this.this$0, alertName, ifName);
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onQuotaLimitReached(final String alertName, final String ifName) throws RemoteException {
            NetworkManagementService.m5933$$Nest$fgetmDaemonHandler(this.this$0).post(new NetworkManagementService$NetdUnsolicitedEventListener$$ExternalSyntheticLambda0(this, alertName, ifName));
        }

        private /* synthetic */ void lambda$onInterfaceDnsServerInfo$2(String ifName, long lifetime, String[] servers) {
            NetworkManagementService.m5939$$Nest$mnotifyInterfaceDnsServerInfo(this.this$0, ifName, lifetime, servers);
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceDnsServerInfo(final String ifName, final long lifetime, final String[] servers) throws RemoteException {
            NetworkManagementService.m5933$$Nest$fgetmDaemonHandler(this.this$0).post(new NetworkManagementService$NetdUnsolicitedEventListener$$ExternalSyntheticLambda9(this, ifName, lifetime, servers));
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceAddressUpdated(String addr, final String ifName, int flags, int scope) throws RemoteException {
            final LinkAddress address = new LinkAddress(addr, flags, scope);
            NetworkManagementService.m5933$$Nest$fgetmDaemonHandler(this.this$0).post(new NetworkManagementService$NetdUnsolicitedEventListener$$ExternalSyntheticLambda7(this, ifName, address));
        }

        private /* synthetic */ void lambda$onInterfaceAddressUpdated$3(String ifName, LinkAddress address) {
            NetworkManagementService.m5936$$Nest$mnotifyAddressUpdated(this.this$0, ifName, address);
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceAddressRemoved(String addr, final String ifName, int flags, int scope) throws RemoteException {
            final LinkAddress address = new LinkAddress(addr, flags, scope);
            NetworkManagementService.m5933$$Nest$fgetmDaemonHandler(this.this$0).post(new NetworkManagementService$NetdUnsolicitedEventListener$$ExternalSyntheticLambda6(this, ifName, address));
        }

        private /* synthetic */ void lambda$onInterfaceAddressRemoved$4(String ifName, LinkAddress address) {
            NetworkManagementService.m5935$$Nest$mnotifyAddressRemoved(this.this$0, ifName, address);
        }

        private /* synthetic */ void lambda$onInterfaceAdded$5(String ifName) {
            NetworkManagementService.m5937$$Nest$mnotifyInterfaceAdded(this.this$0, ifName);
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceAdded(final String ifName) throws RemoteException {
            NetworkManagementService.m5933$$Nest$fgetmDaemonHandler(this.this$0).post(new NetworkManagementService$NetdUnsolicitedEventListener$$ExternalSyntheticLambda5(this, ifName));
        }

        private /* synthetic */ void lambda$onInterfaceRemoved$6(String ifName) {
            NetworkManagementService.m5941$$Nest$mnotifyInterfaceRemoved(this.this$0, ifName);
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceRemoved(final String ifName) throws RemoteException {
            NetworkManagementService.m5933$$Nest$fgetmDaemonHandler(this.this$0).post(new NetworkManagementService$NetdUnsolicitedEventListener$$ExternalSyntheticLambda1(this, ifName));
        }

        private /* synthetic */ void lambda$onInterfaceChanged$7(String ifName, boolean up) {
            NetworkManagementService.m5942$$Nest$mnotifyInterfaceStatusChanged(this.this$0, ifName, up);
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceChanged(final String ifName, final boolean up) throws RemoteException {
            NetworkManagementService.m5933$$Nest$fgetmDaemonHandler(this.this$0).post(new NetworkManagementService$NetdUnsolicitedEventListener$$ExternalSyntheticLambda4(this, ifName, up));
        }

        private /* synthetic */ void lambda$onInterfaceLinkStateChanged$8(String ifName, boolean up) {
            NetworkManagementService.m5940$$Nest$mnotifyInterfaceLinkStateChanged(this.this$0, ifName, up);
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceLinkStateChanged(final String ifName, final boolean up) throws RemoteException {
            NetworkManagementService.m5933$$Nest$fgetmDaemonHandler(this.this$0).post(new NetworkManagementService$NetdUnsolicitedEventListener$$ExternalSyntheticLambda2(this, ifName, up));
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onRouteChanged(final boolean updated, String route, String gateway, String ifName) throws RemoteException {
            IpPrefix r1 = new IpPrefix(route);
            if ("".equals(gateway) == false) goto L5;
            InetAddress r2 = null;
        L6:
            final RouteInfo processRoute = new RouteInfo(r1, r2, ifName, 1);
            NetworkManagementService.m5933$$Nest$fgetmDaemonHandler(this.this$0).post(new NetworkManagementService$NetdUnsolicitedEventListener$$ExternalSyntheticLambda8(this, updated, processRoute));
            return;
        L5:
            r2 = InetAddresses.parseNumericAddress(gateway);
            goto L6
        }

        private /* synthetic */ void lambda$onRouteChanged$9(boolean updated, RouteInfo processRoute) {
            NetworkManagementService.m5944$$Nest$mnotifyRouteChange(this.this$0, updated, processRoute);
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onStrictCleartextDetected(int uid, String hex) throws RemoteException {
            ActivityManager.getService().notifyCleartextNetwork(uid, HexDump.hexStringToByteArray(hex));
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public int getInterfaceVersion() {
            return 17;
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public String getInterfaceHash() {
            return "a786da2fe41bda627a8c1e63b99264a415e769c8";
        }
    }

    @FunctionalInterface
    private interface NetworkManagementEventCallback {
        void sendCallback(INetworkManagementEventObserver r1) throws RemoteException;
    }

    public static /* synthetic */ void $r8$lambda$1PP3OT1sadvPew6Y2R2byLVESt0(String r0, boolean r1, INetworkManagementEventObserver r2) {
        lambda$notifyInterfaceStatusChanged$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$27yNfp44myt2FFZw0U_1jqHKX3E(String r0, LinkAddress r1, INetworkManagementEventObserver r2) {
        lambda$notifyAddressUpdated$6(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$D1GxzTWFP6nyfVFLea5BwoaUODo(RouteInfo r0, INetworkManagementEventObserver r1) {
        lambda$notifyRouteChange$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$F0vO9LyGll9GGg3aJEF0faQ74lk(String r0, INetworkManagementEventObserver r1) {
        lambda$notifyInterfaceRemoved$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$IFtj3DXMXtl3A2TSjPFNzE4F6gU(String r0, boolean r1, INetworkManagementEventObserver r2) {
        lambda$notifyInterfaceLinkStateChanged$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$RluWfXnRfnPOz7TP5AWMKTBn3D8(String r0, String r1, INetworkManagementEventObserver r2) {
        lambda$notifyLimitReached$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ZszwXMKMcCa29m6w4HumYmP_Sak(String r0, LinkAddress r1, INetworkManagementEventObserver r2) {
        lambda$notifyAddressRemoved$7(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$cgpS-jgRifY7BNTfBbw-sWsFzNs, reason: not valid java name */
    public static /* synthetic */ void m5930$r8$lambda$cgpSjgRifY7BNTfBbwsWsFzNs(String r0, long r1, String[] r3, INetworkManagementEventObserver r4) {
        lambda$notifyInterfaceDnsServerInfo$8(r0, r1, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$k-uAcrtK2YwJmLI08kowLJcRtuU, reason: not valid java name */
    public static /* synthetic */ void m5931$r8$lambda$kuAcrtK2YwJmLI08kowLJcRtuU(int r0, boolean r1, long r2, int r4, INetworkManagementEventObserver r5) {
        lambda$notifyInterfaceClassActivity$5(r0, r1, r2, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$ktWfr0rrBO3AIob6Jzw4-rtbKHI, reason: not valid java name */
    public static /* synthetic */ void m5932$r8$lambda$ktWfr0rrBO3AIob6Jzw4rtbKHI(RouteInfo r0, INetworkManagementEventObserver r1) {
        lambda$notifyRouteChange$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$pxzyCqAqOv8u__cj08Loj3pseCE(String r0, INetworkManagementEventObserver r1) {
        lambda$notifyInterfaceAdded$2(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDaemonHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5933$$Nest$fgetmDaemonHandler(NetworkManagementService r0) {
        return r0.mDaemonHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$misNetworkRestrictedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5934$$Nest$misNetworkRestrictedInternal(NetworkManagementService r0, int r1) {
        return r0.isNetworkRestrictedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyAddressRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5935$$Nest$mnotifyAddressRemoved(NetworkManagementService r0, String r1, LinkAddress r2) {
        r0.notifyAddressRemoved(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyAddressUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5936$$Nest$mnotifyAddressUpdated(NetworkManagementService r0, String r1, LinkAddress r2) {
        r0.notifyAddressUpdated(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyInterfaceAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5937$$Nest$mnotifyInterfaceAdded(NetworkManagementService r0, String r1) {
        r0.notifyInterfaceAdded(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyInterfaceClassActivity, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5938$$Nest$mnotifyInterfaceClassActivity(NetworkManagementService r0, int r1, boolean r2, long r3, int r5) {
        r0.notifyInterfaceClassActivity(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyInterfaceDnsServerInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5939$$Nest$mnotifyInterfaceDnsServerInfo(NetworkManagementService r0, String r1, long r2, String[] r4) {
        r0.notifyInterfaceDnsServerInfo(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyInterfaceLinkStateChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5940$$Nest$mnotifyInterfaceLinkStateChanged(NetworkManagementService r0, String r1, boolean r2) {
        r0.notifyInterfaceLinkStateChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyInterfaceRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5941$$Nest$mnotifyInterfaceRemoved(NetworkManagementService r0, String r1) {
        r0.notifyInterfaceRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyInterfaceStatusChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5942$$Nest$mnotifyInterfaceStatusChanged(NetworkManagementService r0, String r1, boolean r2) {
        r0.notifyInterfaceStatusChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyLimitReached, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5943$$Nest$mnotifyLimitReached(NetworkManagementService r0, String r1, String r2) {
        r0.notifyLimitReached(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyRouteChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5944$$Nest$mnotifyRouteChange(NetworkManagementService r0, boolean r1, RouteInfo r2) {
        r0.notifyRouteChange(r1, r2);
    }

    static {
        DBG = Log.isLoggable(TAG, 3);
    }

    private NetworkManagementService(Context context, Dependencies deps) {
        super(PermissionEnforcer.fromContext(context));
        this.mObservers = new RemoteCallbackList();
        this.mQuotaLock = new Object();
        this.mRulesLock = new Object();
        this.mActiveQuotas = Maps.newHashMap();
        this.mActiveAlerts = Maps.newHashMap();
        this.mUidRejectOnMetered = new SparseBooleanArray();
        this.mUidAllowOnMetered = new SparseBooleanArray();
        this.mUidCleartextPolicy = new SparseIntArray();
        this.mUidFirewallRules = new SparseIntArray();
        this.mUidFirewallStandbyRules = new SparseIntArray();
        this.mUidFirewallDozableRules = new SparseIntArray();
        this.mUidFirewallPowerSaveRules = new SparseIntArray();
        this.mUidFirewallRestrictedRules = new SparseIntArray();
        this.mUidFirewallLowPowerStandbyRules = new SparseIntArray();
        this.mUidFirewallBackgroundRules = new SparseIntArray();
        this.mUidMeteredFirewallAllowRules = new SparseIntArray();
        this.mUidMeteredFirewallDenyUserRules = new SparseIntArray();
        this.mUidMeteredFirewallDenyAdminRules = new SparseIntArray();
        this.mFirewallChainStates = new SparseBooleanArray();
        this.mContext = context;
        this.mDeps = deps;
        this.mUseMeteredFirewallChains = true;
        if (this.mUseMeteredFirewallChains == false) goto L5;
        this.mFirewallChainStates.put(11, true);
        this.mFirewallChainStates.put(12, true);
    L5:
        this.mDaemonHandler = new Handler(FgThread.get().getLooper());
        NetworkManagementServiceIA r1 = null;
        this.mNetdUnsolicitedEventListener = new NetdUnsolicitedEventListener(this, r1);
        this.mSmtEx = new NetworkManagementServiceSmtEx(this.mContext, this, this.mDaemonHandler);
        this.mDeps.registerLocalService(new LocalService(this, r1));
    }

    static NetworkManagementService create(Context context, Dependencies deps) throws InterruptedException {
        NetworkManagementService service = new NetworkManagementService(context, deps);
        if (DBG == false) goto L6;
        Slog.d(TAG, "Creating NetworkManagementService");
    L6:
        if (DBG == false) goto L8;
        Slog.d(TAG, "Connecting native netd service");
    L8:
        service.connectNativeNetdService();
        if (DBG == false) goto L11;
        Slog.d(TAG, "Connected");
    L11:
        return service;
    }

    public static NetworkManagementService create(Context context) throws InterruptedException {
        return create(context, new Dependencies());
    }

    public void systemReady() {
        if (DBG == false) goto L6;
        long start = System.currentTimeMillis();
        prepareNativeDaemon();
        long delta = System.currentTimeMillis() - start;
        Slog.d(TAG, "Prepared in " + delta + "ms");
        SysOptBridge.getFactory().getNetworkManagementServiceOptEx().init(this.mContext, this);
        return;
    L6:
        prepareNativeDaemon();
        SysOptBridge.getFactory().getNetworkManagementServiceOptEx().init(this.mContext, this);
        this.mSmtEx.prepareOemRules();
    }

    private IBatteryStats getBatteryStats() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mBatteryStats == null) goto L10;
        IBatteryStats r0 = this.mBatteryStats;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r0;
    L10:
        this.mBatteryStats = IBatteryStats.Stub.asInterface(this.mDeps.getService("batterystats"));     // Catch: Throwable -> L8
        IBatteryStats r1 = this.mBatteryStats;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r1;
    }

    public void registerObserver(INetworkManagementEventObserver observer) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        this.mObservers.register(observer);
    }

    public void unregisterObserver(INetworkManagementEventObserver observer) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        this.mObservers.unregister(observer);
    }

    private void invokeForAllObservers(NetworkManagementEventCallback eventCallback) {
        monitor-enter(this);
        int length = this.mObservers.beginBroadcast();     // Catch: Throwable -> L14
        int i = 0;
    L5:
        if (i >= length) goto L17;
        eventCallback.sendCallback((INetworkManagementEventObserver) this.mObservers.getBroadcastItem(i));     // Catch: Throwable -> L8 Throwable -> L10
    L8:
        th = move-exception;
        this.mObservers.finishBroadcast();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L16:
        i = i + 1;     // Catch: Throwable -> L14
        goto L5
    L17:
        this.mObservers.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$notifyInterfaceStatusChanged$0(String iface, boolean up, INetworkManagementEventObserver o) throws RemoteException {
        o.interfaceStatusChanged(iface, up);
    }

    private void notifyInterfaceStatusChanged(final String iface, final boolean up) {
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda2(iface, up));
    }

    private static /* synthetic */ void lambda$notifyInterfaceLinkStateChanged$1(String iface, boolean up, INetworkManagementEventObserver o) throws RemoteException {
        o.interfaceLinkStateChanged(iface, up);
    }

    private void notifyInterfaceLinkStateChanged(final String iface, final boolean up) {
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda4(iface, up));
    }

    private static /* synthetic */ void lambda$notifyInterfaceAdded$2(String iface, INetworkManagementEventObserver o) throws RemoteException {
        o.interfaceAdded(iface);
    }

    private void notifyInterfaceAdded(final String iface) {
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda0(iface));
    }

    private void notifyInterfaceRemoved(final String iface) {
        this.mActiveAlerts.remove(iface);
        this.mActiveQuotas.remove(iface);
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda5(iface));
    }

    private static /* synthetic */ void lambda$notifyInterfaceRemoved$3(String iface, INetworkManagementEventObserver o) throws RemoteException {
        o.interfaceRemoved(iface);
    }

    private static /* synthetic */ void lambda$notifyLimitReached$4(String limitName, String iface, INetworkManagementEventObserver o) throws RemoteException {
        o.limitReached(limitName, iface);
    }

    private void notifyLimitReached(final String limitName, final String iface) {
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda10(limitName, iface));
    }

    private static /* synthetic */ void lambda$notifyInterfaceClassActivity$5(int label, boolean isActive, long tsNanos, int uid, INetworkManagementEventObserver o) throws RemoteException {
        o.interfaceClassDataActivityChanged(label, isActive, tsNanos, uid);
    }

    private void notifyInterfaceClassActivity(final int label, final boolean isActive, final long tsNanos, final int uid) {
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda1(label, isActive, tsNanos, uid));
    }

    private void syncFirewallChainLocked(int chain, String name) {
        Object r0 = this.mRulesLock;
        monitor-enter(r0);
        SparseIntArray uidFirewallRules = getUidFirewallRulesLR(chain);     // Catch: Throwable -> L16
        SparseIntArray rules = uidFirewallRules.clone();     // Catch: Throwable -> L16
        uidFirewallRules.clear();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (rules.size() > 0) goto L9;
        return;
    L9:
        if (DBG == false) goto L11;
        Slog.d(TAG, "Pushing " + rules.size() + " active firewall " + name + "UID rules");
    L11:
        int i = 0;
    L13:
        if (i >= rules.size()) goto L22;
        setFirewallUidRuleLocked(chain, rules.keyAt(i), rules.valueAt(i));
        i = i + 1;
        goto L13
    L22:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void connectNativeNetdService() {
        this.mNetdService = this.mDeps.getNetd();
        this.mNetdService.registerUnsolicitedEventListener(this.mNetdUnsolicitedEventListener);     // Catch: Throwable -> L7
        if (DBG == false) goto L14;
        Slog.d(TAG, "Register unsolicited event listener");     // Catch: Throwable -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to set Netd unsolicited event listener " + e);
    }

    private void prepareNativeDaemon() {
        Object r6 = this.mQuotaLock;
        monitor-enter(r6);
        this.mStrictEnabled = true;     // Catch: Throwable -> L9
        setDataSaverModeEnabled(this.mDataSaverMode);     // Catch: Throwable -> L9
        int size = this.mActiveQuotas.size();     // Catch: Throwable -> L9
        if (size > 0) goto L7;
    L15:
        HashMap<String, Long> activeQuotas = this.mActiveAlerts;     // Catch: Throwable -> L9
        int size2 = activeQuotas.size();     // Catch: Throwable -> L9
        if (size2 <= 0) goto L25;
        if (DBG == false) goto L20;
        Slog.d(TAG, "Pushing " + size2 + " active alert rules");     // Catch: Throwable -> L9
    L20:
        HashMap<String, Long> activeAlerts = this.mActiveAlerts;     // Catch: Throwable -> L9
        this.mActiveAlerts = Maps.newHashMap();     // Catch: Throwable -> L9
        Iterator<Map.Entry<String, Long>> r9 = activeAlerts.entrySet().iterator();     // Catch: Throwable -> L9
    L22:
        if (r9.hasNext() == false) goto L25;
        Map.Entry<String, Long> entry = r9.next();     // Catch: Throwable -> L9
        setInterfaceAlert(entry.getKey(), entry.getValue().longValue());     // Catch: Throwable -> L9
    L25:
        if (this.mUseMeteredFirewallChains == true) goto L56;
        SparseBooleanArray uidRejectOnQuota = null;
        SparseBooleanArray uidAcceptOnQuota = null;
        Object r10 = this.mRulesLock;     // Catch: Throwable -> L9
        monitor-enter(r10);     // Catch: Throwable -> L9
        int size3 = this.mUidRejectOnMetered.size();     // Catch: Throwable -> L33
        if (size3 > 0) goto L31;
    L36:
        int size4 = this.mUidAllowOnMetered.size();     // Catch: Throwable -> L33
        if (size4 > 0) goto L39;
    L42:
        monitor-exit(r10);     // Catch: Throwable -> L33
        if (uidRejectOnQuota == null) goto L48;
        int i = 0;
    L46:
        if (i >= uidRejectOnQuota.size()) goto L48;
        setUidOnMeteredNetworkDenylist(uidRejectOnQuota.keyAt(i), uidRejectOnQuota.valueAt(i));     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
    L48:
        if (uidAcceptOnQuota == null) goto L56;
        int i2 = 0;
    L51:
        if (i2 >= uidAcceptOnQuota.size()) goto L56;
        setUidOnMeteredNetworkAllowlist(uidAcceptOnQuota.keyAt(i2), uidAcceptOnQuota.valueAt(i2));     // Catch: Throwable -> L9
        i2 = i2 + 1;
        goto L51
    L39:
        if (DBG == false) goto L41;
        Slog.d(TAG, "Pushing " + size4 + " UIDs to metered allowlist rules");     // Catch: Throwable -> L33
    L41:
        uidAcceptOnQuota = this.mUidAllowOnMetered;     // Catch: Throwable -> L33
        this.mUidAllowOnMetered = new SparseBooleanArray();     // Catch: Throwable -> L33
        goto L42
    L31:
        if (DBG == false) goto L35;
        Slog.d(TAG, "Pushing " + size3 + " UIDs to metered denylist rules");     // Catch: Throwable -> L33
    L35:
        uidRejectOnQuota = this.mUidRejectOnMetered;     // Catch: Throwable -> L33
        this.mUidRejectOnMetered = new SparseBooleanArray();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L56:
        int size5 = this.mUidCleartextPolicy.size();     // Catch: Throwable -> L9
        if (size5 > 0) goto L59;
    L65:
        setFirewallEnabled(this.mFirewallEnabled);     // Catch: Throwable -> L9
        int r11 = 0;
        syncFirewallChainLocked(0, "");     // Catch: Throwable -> L9
        syncFirewallChainLocked(2, "standby ");     // Catch: Throwable -> L9
        syncFirewallChainLocked(1, "dozable ");     // Catch: Throwable -> L9
        syncFirewallChainLocked(3, "powersave ");     // Catch: Throwable -> L9
        syncFirewallChainLocked(4, "restricted ");     // Catch: Throwable -> L9
        syncFirewallChainLocked(5, "low power standby ");     // Catch: Throwable -> L9
        syncFirewallChainLocked(6, "background");     // Catch: Throwable -> L9
        if (this.mUseMeteredFirewallChains == false) goto L68;
        syncFirewallChainLocked(10, "metered_allow");     // Catch: Throwable -> L9
        syncFirewallChainLocked(11, "metered_deny_user");     // Catch: Throwable -> L9
        syncFirewallChainLocked(12, "metered_deny_admin");     // Catch: Throwable -> L9
    L68:
        int[] chainsToEnable = {2, 1, 3, 4, 5, 6};     // Catch: Throwable -> L9
        int r1 = chainsToEnable.length;     // Catch: Throwable -> L9
    L69:
        if (r11 >= r1) goto L74;
        int chain = chainsToEnable[r11];     // Catch: Throwable -> L9
        if (getFirewallChainState(chain) == false) goto L73;
        setFirewallChainEnabled(chain, true);     // Catch: Throwable -> L9
    L73:
        r11 = r11 + 1;     // Catch: Throwable -> L9
        goto L69
    L74:
        SysOptBridge.getFactory().getNetworkManagementServiceOptEx().updateUidNetworkAccessPreviledge();     // Catch: Throwable -> L9
        monitor-exit(r6);     // Catch: Throwable -> L9
        getBatteryStats().noteNetworkStatsEnabled();     // Catch: RemoteException -> L78
        return;
    L79:
        return;
    L59:
        if (DBG == false) goto L61;
        Slog.d(TAG, "Pushing " + size5 + " active UID cleartext policies");     // Catch: Throwable -> L9
    L61:
        SparseIntArray local = this.mUidCleartextPolicy;     // Catch: Throwable -> L9
        this.mUidCleartextPolicy = new SparseIntArray();     // Catch: Throwable -> L9
        int i3 = 0;
    L63:
        if (i3 >= local.size()) goto L65;
        setUidCleartextNetworkPolicy(local.keyAt(i3), local.valueAt(i3));     // Catch: Throwable -> L9
        i3 = i3 + 1;     // Catch: Throwable -> L9
        goto L63
    L7:
        if (DBG == false) goto L11;
        Slog.d(TAG, "Pushing " + size + " active quota rules");     // Catch: Throwable -> L9
    L11:
        HashMap<String, Long> activeQuotas2 = this.mActiveQuotas;     // Catch: Throwable -> L9
        this.mActiveQuotas = Maps.newHashMap();     // Catch: Throwable -> L9
        Iterator<Map.Entry<String, Long>> r12 = activeQuotas2.entrySet().iterator();     // Catch: Throwable -> L9
    L13:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<String, Long> entry2 = r12.next();     // Catch: Throwable -> L9
        setInterfaceQuota(entry2.getKey(), entry2.getValue().longValue());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$notifyAddressUpdated$6(String iface, LinkAddress address, INetworkManagementEventObserver o) throws RemoteException {
        o.addressUpdated(iface, address);
    }

    private void notifyAddressUpdated(final String iface, final LinkAddress address) {
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda7(iface, address));
    }

    private static /* synthetic */ void lambda$notifyAddressRemoved$7(String iface, LinkAddress address, INetworkManagementEventObserver o) throws RemoteException {
        o.addressRemoved(iface, address);
    }

    private void notifyAddressRemoved(final String iface, final LinkAddress address) {
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda3(iface, address));
    }

    private static /* synthetic */ void lambda$notifyInterfaceDnsServerInfo$8(String iface, long lifetime, String[] addresses, INetworkManagementEventObserver o) throws RemoteException {
        o.interfaceDnsServerInfo(iface, lifetime, addresses);
    }

    private void notifyInterfaceDnsServerInfo(final String iface, final long lifetime, final String[] addresses) {
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda6(iface, lifetime, addresses));
    }

    private void notifyRouteChange(boolean updated, final RouteInfo route) {
        if (updated == false) goto L4;
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda8(route));
        return;
    L4:
        invokeForAllObservers(new NetworkManagementService$$ExternalSyntheticLambda9(route));
    }

    private static /* synthetic */ void lambda$notifyRouteChange$9(RouteInfo route, INetworkManagementEventObserver o) throws RemoteException {
        o.routeUpdated(route);
    }

    private static /* synthetic */ void lambda$notifyRouteChange$10(RouteInfo route, INetworkManagementEventObserver o) throws RemoteException {
        o.routeRemoved(route);
    }

    public String[] listInterfaces() {
        PermissionUtils.enforceNetworkStackPermissionOr(this.mContext, new String[]{"android.permission.CONNECTIVITY_INTERNAL"});
        return this.mNetdService.interfaceGetList();
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private static InterfaceConfigurationParcel toStableParcel(InterfaceConfiguration cfg, String iface) {
        InterfaceConfigurationParcel cfgParcel = new InterfaceConfigurationParcel();
        cfgParcel.ifName = iface;
        String hwAddr = cfg.getHardwareAddress();
        if (TextUtils.isEmpty(hwAddr) == true) goto L5;
        cfgParcel.hwAddr = hwAddr;
    L6:
        cfgParcel.ipv4Addr = cfg.getLinkAddress().getAddress().getHostAddress();
        cfgParcel.prefixLength = cfg.getLinkAddress().getPrefixLength();
        ArrayList<String> flags = new ArrayList();
        Iterator r3 = cfg.getFlags().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        String flag = (String) r3.next();
        flags.add(flag);
        goto L8
    L10:
        cfgParcel.flags = (String[]) flags.toArray(new String[0]);
        return cfgParcel;
    L5:
        cfgParcel.hwAddr = "";
        goto L6
    }

    public static InterfaceConfiguration fromStableParcel(InterfaceConfigurationParcel p) {
        InterfaceConfiguration cfg = new InterfaceConfiguration();
        cfg.setHardwareAddress(p.hwAddr);
        InetAddress addr = InetAddresses.parseNumericAddress(p.ipv4Addr);
        cfg.setLinkAddress(new LinkAddress(addr, p.prefixLength));
        String[] r2 = p.flags;
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        String flag = r2[r4];
        cfg.setFlag(flag);
        r4 = r4 + 1;
        goto L3
    L5:
        return cfg;
    }

    public InterfaceConfiguration getInterfaceConfig(String iface) {
        PermissionUtils.enforceNetworkStackPermissionOr(this.mContext, new String[]{"android.permission.CONNECTIVITY_INTERNAL"});
        InterfaceConfigurationParcel result = this.mNetdService.interfaceGetCfg(iface);     // Catch: Throwable -> L9
        InterfaceConfiguration cfg = fromStableParcel(result);     // Catch: IllegalArgumentException -> L6
        return cfg;
    L6:
        iae = move-exception;
        throw new IllegalStateException("Invalid InterfaceConfigurationParcel", iae);
    L9:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public void setInterfaceConfig(String iface, InterfaceConfiguration cfg) {
        PermissionUtils.enforceNetworkStackPermissionOr(this.mContext, new String[]{"android.permission.CONNECTIVITY_INTERNAL"});
        LinkAddress linkAddr = cfg.getLinkAddress();
        if (linkAddr == null) goto L13;
        if (linkAddr.getAddress() == null) goto L13;
        InterfaceConfigurationParcel cfgParcel = toStableParcel(cfg, iface);
        this.mNetdService.interfaceSetCfg(cfgParcel);     // Catch: Throwable -> L9
        return;
    L9:
        e = move-exception;
        throw new IllegalStateException(e);
    L13:
        throw new IllegalStateException("Null LinkAddress given");
    }

    public void setInterfaceDown(String iface) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        InterfaceConfiguration ifcg = getInterfaceConfig(iface);
        ifcg.setInterfaceDown();
        setInterfaceConfig(iface, ifcg);
    }

    public void setInterfaceUp(String iface) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        InterfaceConfiguration ifcg = getInterfaceConfig(iface);
        ifcg.setInterfaceUp();
        setInterfaceConfig(iface, ifcg);
    }

    public void setInterfaceIpv6PrivacyExtensions(String iface, boolean enable) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        this.mNetdService.interfaceSetIPv6PrivacyExtensions(iface, enable);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public void clearInterfaceAddresses(String iface) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        this.mNetdService.interfaceClearAddrs(iface);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public void enableIpv6(String iface) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        this.mNetdService.interfaceSetEnableIPv6(iface, true);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public void setIPv6AddrGenMode(String iface, int mode) throws ServiceSpecificException {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        this.mNetdService.setIPv6AddrGenMode(iface, mode);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    public void disableIpv6(String iface) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        this.mNetdService.interfaceSetEnableIPv6(iface, false);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public void shutdown() {
        super.shutdown_enforcePermission();
        Slog.i(TAG, "Shutting down");
    }

    public void setInterfaceQuota(String iface, long quotaBytes) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mActiveQuotas.containsKey(iface) == true) goto L15;
        this.mNetdService.bandwidthSetInterfaceQuota(iface, quotaBytes);     // Catch: Throwable -> L9 Throwable -> L11
        this.mActiveQuotas.put(iface, Long.valueOf(quotaBytes));     // Catch: Throwable -> L9 Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        e = move-exception;
        throw new IllegalStateException(e);     // Catch: Throwable -> L9
    L15:
        throw new IllegalStateException("iface " + iface + " already has quota");     // Catch: Throwable -> L9
    }

    public void removeInterfaceQuota(String iface) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mActiveQuotas.containsKey(iface) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mActiveQuotas.remove(iface);     // Catch: Throwable -> L8
        this.mActiveAlerts.remove(iface);     // Catch: Throwable -> L8
        this.mNetdService.bandwidthRemoveInterfaceQuota(iface);     // Catch: Throwable -> L8 Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        e = move-exception;
        throw new IllegalStateException(e);     // Catch: Throwable -> L8
    }

    public void setInterfaceAlert(String iface, long alertBytes) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        if (this.mActiveQuotas.containsKey(iface) == false) goto L21;
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mActiveAlerts.containsKey(iface) == true) goto L17;
        this.mNetdService.bandwidthSetInterfaceAlert(iface, alertBytes);     // Catch: Throwable -> L11 Throwable -> L13
        this.mActiveAlerts.put(iface, Long.valueOf(alertBytes));     // Catch: Throwable -> L11 Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        e = move-exception;
        throw new IllegalStateException(e);     // Catch: Throwable -> L11
    L17:
        throw new IllegalStateException("iface " + iface + " already has alert");     // Catch: Throwable -> L11
    L21:
        throw new IllegalStateException("setting alert requires existing quota on iface");
    }

    public void removeInterfaceAlert(String iface) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mActiveAlerts.containsKey(iface) == true) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mNetdService.bandwidthRemoveInterfaceAlert(iface);     // Catch: Throwable -> L8 Throwable -> L13
        this.mActiveAlerts.remove(iface);     // Catch: Throwable -> L8 Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        e = move-exception;
        throw new IllegalStateException(e);     // Catch: Throwable -> L8
    }

    private void setUidOnMeteredNetworkList(int uid, boolean allowlist, boolean enable) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
        Object r1 = this.mRulesLock;     // Catch: Throwable -> L16
        monitor-enter(r1);     // Catch: Throwable -> L16
        if (allowlist == false) goto L10;
        SparseBooleanArray quotaList = this.mUidAllowOnMetered;     // Catch: Throwable -> L8
    L11:
        boolean oldEnable = quotaList.get(uid, false);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        if (oldEnable != enable) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L18:
        Trace.traceBegin(2097152, "inetd bandwidth");     // Catch: Throwable -> L16
        ConnectivityManager cm = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);     // Catch: Throwable -> L16
        if (allowlist == false) goto L27;
        if (enable == false) goto L26;
        cm.addUidToMeteredNetworkAllowList(uid);     // Catch: Throwable -> L22 RuntimeException -> L24
    L30:
        Object r6 = this.mRulesLock;     // Catch: Throwable -> L22 RuntimeException -> L24
        monitor-enter(r6);     // Catch: Throwable -> L22 RuntimeException -> L24
        if (enable == true) goto L34;
        quotaList.delete(uid);     // Catch: Throwable -> L35
    L38:
        monitor-exit(r6);     // Catch: Throwable -> L35
        Trace.traceEnd(2097152);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L34:
        quotaList.put(uid, true);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22 RuntimeException -> L24
    L26:
        cm.removeUidFromMeteredNetworkAllowList(uid);     // Catch: Throwable -> L22 RuntimeException -> L24
        goto L30
    L27:
        if (enable == false) goto L29;
        cm.addUidToMeteredNetworkDenyList(uid);     // Catch: Throwable -> L22 RuntimeException -> L24
        goto L30
    L29:
        cm.removeUidFromMeteredNetworkDenyList(uid);     // Catch: Throwable -> L22 RuntimeException -> L24
    L24:
        e = move-exception;
        throw new IllegalStateException(e);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Trace.traceEnd(2097152);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L10:
        quotaList = this.mUidRejectOnMetered;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public void setUidOnMeteredNetworkDenylist(int uid, boolean enable) {
        setUidOnMeteredNetworkList(uid, false, enable);
    }

    public void setUidOnMeteredNetworkAllowlist(int uid, boolean enable) {
        setUidOnMeteredNetworkList(uid, true, enable);
    }

    public boolean setDataSaverModeEnabled(boolean enable) {
        super.setDataSaverModeEnabled_enforcePermission();
        if (DBG == false) goto L5;
        Log.d(TAG, "setDataSaverMode: " + enable);
    L5:
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mDataSaverMode != enable) goto L14;
        Log.w(TAG, "setDataSaverMode(): already " + this.mDataSaverMode);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L14:
        Trace.traceBegin(2097152, "setDataSaverModeEnabled");     // Catch: Throwable -> L12
        ((ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class)).setDataSaverEnabled(enable);     // Catch: Throwable -> L25 IllegalStateException -> L27
        this.mDataSaverMode = enable;     // Catch: Throwable -> L25 IllegalStateException -> L27
        if (this.mUseMeteredFirewallChains == false) goto L30;
        Object r1 = this.mRulesLock;     // Catch: Throwable -> L25 IllegalStateException -> L27
        monitor-enter(r1);     // Catch: Throwable -> L25 IllegalStateException -> L27
        this.mFirewallChainStates.put(10, enable);     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25 IllegalStateException -> L27
    L30:
        Trace.traceEnd(2097152);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L27:
        e = move-exception;
        Log.e(TAG, "setDataSaverMode(" + enable + "): failed with exception", e);     // Catch: Throwable -> L25
        Trace.traceEnd(2097152);     // Catch: Throwable -> L12
        return false;
    L25:
        th = move-exception;
        Trace.traceEnd(2097152);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    }

    private void applyUidCleartextNetworkPolicy(int uid, int policy) {
        switch(policy) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        int policyValue = 3;
    L13:
        this.mNetdService.strictUidCleartextPenalty(uid, policyValue);     // Catch: Throwable -> L10
        this.mUidCleartextPolicy.put(uid, policy);     // Catch: Throwable -> L10
        return;
    L10:
        e = move-exception;
        throw new IllegalStateException(e);
    L6:
        policyValue = 2;
        goto L13
    L7:
        policyValue = 1;
        goto L13
    L4:
        throw new IllegalArgumentException("Unknown policy " + policy);
    }

    public void setUidCleartextNetworkPolicy(int uid, int policy) {
        if (this.mDeps.getCallingUid() == uid) goto L5;
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
    L5:
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
        int oldPolicy = this.mUidCleartextPolicy.get(uid, 0);     // Catch: Throwable -> L11
        if (oldPolicy != policy) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        if (this.mStrictEnabled == true) goto L18;
        this.mUidCleartextPolicy.put(uid, policy);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L18:
        if (oldPolicy == 0) goto L21;
        if (policy == 0) goto L21;
        applyUidCleartextNetworkPolicy(uid, 0);     // Catch: Throwable -> L11
    L21:
        applyUidCleartextNetworkPolicy(uid, policy);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean isBandwidthControlEnabled() {
        return true;
    }

    public void setFirewallEnabled(boolean enabled) {
        enforceSystemUid();
        INetd r0 = this.mNetdService;     // Catch: Throwable -> L9
        if (enabled == false) goto L6;
        int r1 = 0;
    L7:
        r0.firewallSetFirewallType(r1);     // Catch: Throwable -> L9
        this.mFirewallEnabled = enabled;     // Catch: Throwable -> L9
        return;
    L6:
        r1 = 1;
    L9:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public boolean isFirewallEnabled() {
        enforceSystemUid();
        return this.mFirewallEnabled;
    }

    public void setFirewallChainEnabled(int chain, boolean enable) {
        enforceSystemUid();
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
        Object r1 = this.mRulesLock;     // Catch: Throwable -> L11
        monitor-enter(r1);     // Catch: Throwable -> L11
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L7:
        if (getFirewallChainState(chain) != enable) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L15:
        setFirewallChainState(chain, enable);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        if (isValidFirewallChainForSetEnabled(chain) == false) goto L27;
        ConnectivityManager cm = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);     // Catch: Throwable -> L11
        cm.setFirewallChainEnabled(chain, enable);     // Catch: Throwable -> L11 RuntimeException -> L23
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L23:
        e = move-exception;
        throw new IllegalStateException(e);     // Catch: Throwable -> L11
    L27:
        throw new IllegalArgumentException("Invalid chain for setFirewallChainEnabled: " + NetworkPolicyLogger.getFirewallChainName(chain));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isValidFirewallChainForSetEnabled(int chain) {
        switch(chain) {
            case 1: goto L4;
            case 2: goto L4;
            case 3: goto L4;
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            default: goto L3;
        };
    L3:
        return false;
    L4:
        return true;
    }

    private int getFirewallType(int chain) {
        switch(chain) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L8;
            default: goto L5;
        };
    L8:
        return 1;
    L9:
        return 0;
    L5:
        if (isFirewallEnabled() == true) goto L7;
        return 1;
    L7:
        return 0;
    }

    public void setFirewallUidRules(int chain, int[] uids, int[] rules) {
        enforceSystemUid();
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
        Object r1 = this.mRulesLock;     // Catch: Throwable -> L26
        monitor-enter(r1);     // Catch: Throwable -> L26
        SparseIntArray uidFirewallRules = getUidFirewallRulesLR(chain);     // Catch: Throwable -> L9
        SparseIntArray newRules = new SparseIntArray();     // Catch: Throwable -> L9
        int index = uids.length - 1;     // Catch: Throwable -> L9
    L7:
        if (index < 0) goto L11;
        int uid = uids[index];     // Catch: Throwable -> L9
        int rule = rules[index];     // Catch: Throwable -> L9
        updateFirewallUidRuleLocked(chain, uid, rule);     // Catch: Throwable -> L9
        newRules.put(uid, rule);     // Catch: Throwable -> L9
        index = index - 1;     // Catch: Throwable -> L9
        goto L7
    L11:
        SparseIntArray rulesToRemove = new SparseIntArray();     // Catch: Throwable -> L9
        int index2 = uidFirewallRules.size() - 1;     // Catch: Throwable -> L9
    L13:
        if (index2 < 0) goto L18;
        int uid2 = uidFirewallRules.keyAt(index2);     // Catch: Throwable -> L9
        if (newRules.indexOfKey(uid2) >= 0) goto L17;
        rulesToRemove.put(uid2, 0);     // Catch: Throwable -> L9
    L17:
        index2 = index2 - 1;     // Catch: Throwable -> L9
        goto L13
    L18:
        int index3 = rulesToRemove.size();     // Catch: Throwable -> L9
        int index4 = index3 - 1;     // Catch: Throwable -> L9
    L19:
        if (index4 < 0) goto L22;
        updateFirewallUidRuleLocked(chain, rulesToRemove.keyAt(index4), 0);     // Catch: Throwable -> L9
        index4 = index4 - 1;     // Catch: Throwable -> L9
        goto L19
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L9
        ConnectivityManager cm = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);     // Catch: Throwable -> L26
        cm.replaceFirewallChain(chain, uids);     // Catch: Throwable -> L26 RuntimeException -> L28
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L26
        return;
    L28:
        e = move-exception;
        Slog.w(TAG, "Error flushing firewall chain " + chain, e);     // Catch: Throwable -> L26
        goto L30
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public void setFirewallUidRule(int chain, int uid, int rule) {
        enforceSystemUid();
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
        setFirewallUidRuleLocked(chain, uid, rule);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void setFirewallUidRuleLocked(int chain, int uid, int rule) {
        if (updateFirewallUidRuleLocked(chain, uid, rule) == false) goto L10;
        ConnectivityManager cm = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        cm.setUidFirewallRule(chain, uid, rule);     // Catch: RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private boolean updateFirewallUidRuleLocked(int chain, int uid, int rule) {
        Object r0 = this.mRulesLock;
        monitor-enter(r0);
        SparseIntArray uidFirewallRules = getUidFirewallRulesLR(chain);     // Catch: Throwable -> L7
        boolean r2 = false;
        int oldUidFirewallRule = uidFirewallRules.get(uid, 0);     // Catch: Throwable -> L7
        if (DBG == false) goto L9;
        Slog.d(TAG, "oldRule = " + oldUidFirewallRule + ", newRule=" + rule + " for uid=" + uid + " on chain " + chain);     // Catch: Throwable -> L7
    L9:
        if (oldUidFirewallRule == rule) goto L11;
        String ruleName = getFirewallRuleName(chain, rule);     // Catch: Throwable -> L7
        String oldRuleName = getFirewallRuleName(chain, oldUidFirewallRule);     // Catch: Throwable -> L7
        if (rule != 0) goto L18;
        uidFirewallRules.delete(uid);     // Catch: Throwable -> L7
    L20:
        if (ruleName.equals(oldRuleName) == true) goto L22;
        r2 = true;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L18:
        uidFirewallRules.put(uid, rule);     // Catch: Throwable -> L7
        goto L20
    L11:
        if (DBG == false) goto L13;
        Slog.d(TAG, "!!!!! Skipping change");     // Catch: Throwable -> L7
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return false;
    L7:
        th = move-exception;
        throw th;
    }

    private String getFirewallRuleName(int chain, int rule) {
        if (getFirewallType(chain) != 0) goto L9;
        if (rule != 1) goto L7;
        return "allow";
    L7:
        return "deny";
    L9:
        if (rule != 2) goto L11;
        return "deny";
    L11:
        return "allow";
    }

    private SparseIntArray getUidFirewallRulesLR(int chain) {
        switch(chain) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("Unknown chain:" + chain);
    L6:
        return this.mUidMeteredFirewallDenyAdminRules;
    L8:
        return this.mUidMeteredFirewallDenyUserRules;
    L10:
        return this.mUidMeteredFirewallAllowRules;
    L12:
        return this.mUidFirewallBackgroundRules;
    L14:
        return this.mUidFirewallLowPowerStandbyRules;
    L16:
        return this.mUidFirewallRestrictedRules;
    L18:
        return this.mUidFirewallPowerSaveRules;
    L20:
        return this.mUidFirewallStandbyRules;
    L22:
        return this.mUidFirewallDozableRules;
    L24:
        return this.mUidFirewallRules;
    }

    private void enforceSystemUid() {
        int uid = this.mDeps.getCallingUid();
        if (uid != 1000) goto L6;
        return;
    L6:
        throw new SecurityException("Only available to AID_SYSTEM");
    }

    private void enforceSystemOrPhoneUid() {
        int uid = this.mDeps.getCallingUid();
        if (uid != 1000) goto L5;
        return;
    L5:
        if (uid != 1001) goto L8;
        return;
    L8:
        throw new SecurityException("Only available to AID_SYSTEM");
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        pw.println("Flags:");
        pw.println("com.android.server.net.use_metered_firewall_chains: " + this.mUseMeteredFirewallChains);
        pw.println();
        Object r0 = this.mQuotaLock;
        monitor-enter(r0);
        pw.print("Active quota ifaces: ");     // Catch: Throwable -> L32
        pw.println(this.mActiveQuotas.toString());     // Catch: Throwable -> L32
        pw.print("Active alert ifaces: ");     // Catch: Throwable -> L32
        pw.println(this.mActiveAlerts.toString());     // Catch: Throwable -> L32
        pw.print("Data saver mode: ");     // Catch: Throwable -> L32
        pw.println(this.mDataSaverMode);     // Catch: Throwable -> L32
        Object r1 = this.mRulesLock;     // Catch: Throwable -> L32
        monitor-enter(r1);     // Catch: Throwable -> L32
        dumpUidRuleOnQuotaLocked(pw, "denied UIDs", this.mUidRejectOnMetered);     // Catch: Throwable -> L34
        dumpUidRuleOnQuotaLocked(pw, "allowed UIDs", this.mUidAllowOnMetered);     // Catch: Throwable -> L34
        monitor-exit(r1);     // Catch: Throwable -> L34
        monitor-exit(r0);     // Catch: Throwable -> L32
        Object r2 = this.mRulesLock;
        monitor-enter(r2);
        dumpUidFirewallRule(pw, "", this.mUidFirewallRules);     // Catch: Throwable -> L29
        pw.print("UID firewall standby chain enabled: ");     // Catch: Throwable -> L29
        pw.println(getFirewallChainState(2));     // Catch: Throwable -> L29
        dumpUidFirewallRule(pw, "standby", this.mUidFirewallStandbyRules);     // Catch: Throwable -> L29
        pw.print("UID firewall dozable chain enabled: ");     // Catch: Throwable -> L29
        pw.println(getFirewallChainState(1));     // Catch: Throwable -> L29
        dumpUidFirewallRule(pw, "dozable", this.mUidFirewallDozableRules);     // Catch: Throwable -> L29
        pw.print("UID firewall powersave chain enabled: ");     // Catch: Throwable -> L29
        pw.println(getFirewallChainState(3));     // Catch: Throwable -> L29
        dumpUidFirewallRule(pw, "powersave", this.mUidFirewallPowerSaveRules);     // Catch: Throwable -> L29
        pw.print("UID firewall restricted mode chain enabled: ");     // Catch: Throwable -> L29
        pw.println(getFirewallChainState(4));     // Catch: Throwable -> L29
        dumpUidFirewallRule(pw, "restricted", this.mUidFirewallRestrictedRules);     // Catch: Throwable -> L29
        pw.print("UID firewall low power standby chain enabled: ");     // Catch: Throwable -> L29
        pw.println(getFirewallChainState(5));     // Catch: Throwable -> L29
        dumpUidFirewallRule(pw, LowPowerStandbyController.DeviceConfigWrapper.NAMESPACE, this.mUidFirewallLowPowerStandbyRules);     // Catch: Throwable -> L29
        pw.print("UID firewall background chain enabled: ");     // Catch: Throwable -> L29
        pw.println(getFirewallChainState(6));     // Catch: Throwable -> L29
        dumpUidFirewallRule(pw, "background", this.mUidFirewallBackgroundRules);     // Catch: Throwable -> L29
        pw.print("UID firewall metered allow chain enabled (Data saver mode): ");     // Catch: Throwable -> L29
        pw.println(getFirewallChainState(10));     // Catch: Throwable -> L29
        dumpUidFirewallRule(pw, "metered_allow", this.mUidMeteredFirewallAllowRules);     // Catch: Throwable -> L29
        pw.print("UID firewall metered deny_user chain enabled (always-on): ");     // Catch: Throwable -> L29
        pw.println(getFirewallChainState(11));     // Catch: Throwable -> L29
        dumpUidFirewallRule(pw, "metered_deny_user", this.mUidMeteredFirewallDenyUserRules);     // Catch: Throwable -> L29
        pw.print("UID firewall metered deny_admin chain enabled (always-on): ");     // Catch: Throwable -> L29
        pw.println(getFirewallChainState(12));     // Catch: Throwable -> L29
        dumpUidFirewallRule(pw, "metered_deny_admin", this.mUidMeteredFirewallDenyAdminRules);     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L29
        pw.print("Firewall enabled: ");
        pw.println(this.mFirewallEnabled);
        pw.print("Netd service status: ");
        if (this.mNetdService != null) goto L44;
        pw.println("disconnected");
        return;
    L44:
        boolean alive = this.mNetdService.isAlive();     // Catch: RemoteException -> L22
        if (alive == false) goto L24;
        String r3 = "alive";
    L25:
        pw.println(r3);     // Catch: RemoteException -> L22
        return;
    L24:
        r3 = "dead";
    L27:
        pw.println(INetd.NEXTHOP_UNREACHABLE);
        return;
    L29:
        th = move-exception;
        throw th;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    private void dumpUidRuleOnQuotaLocked(PrintWriter pw, String name, SparseBooleanArray list) {
        pw.print("UID bandwith control ");
        pw.print(name);
        pw.print(": [");
        int size = list.size();
        int i = 0;
    L3:
        if (i >= size) goto L8;
        pw.print(list.keyAt(i));
        if (i >= (size - 1)) goto L7;
        pw.print(",");
    L7:
        i = i + 1;
        goto L3
    L8:
        pw.println("]");
    }

    private void dumpUidFirewallRule(PrintWriter pw, String name, SparseIntArray rules) {
        pw.print("UID firewall ");
        pw.print(name);
        pw.print(" rule: [");
        int size = rules.size();
        int i = 0;
    L3:
        if (i >= size) goto L8;
        pw.print(rules.keyAt(i));
        pw.print(":");
        pw.print(rules.valueAt(i));
        if (i >= (size - 1)) goto L7;
        pw.print(",");
    L7:
        i = i + 1;
        goto L3
    L8:
        pw.println("]");
    }

    public void allowProtect(int uid) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        this.mNetdService.networkSetProtectAllow(uid);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public void denyProtect(int uid) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        this.mNetdService.networkSetProtectDeny(uid);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public boolean isNetworkRestricted(int uid) {
        super.isNetworkRestricted_enforcePermission();
        return isNetworkRestrictedInternal(uid);
    }

    public void setLinkLayerPreemptionPriority(String iface, int uid, int priorityLevel) {
        enforceSystemOrPhoneUid();
        getOemNetdService().setLinkLayerPreemptionPriority(iface, uid, priorityLevel);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public int getLinkLayerPreemptionPriority(String iface, int uid) {
        enforceSystemOrPhoneUid();
        return getOemNetdService().getLinkLayerPreemptionPriority(iface, uid);
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public void clearLinkLayerPreemptionPriority(String iface) {
        enforceSystemOrPhoneUid();
        getOemNetdService().clearLinkLayerPreemptionPriority(iface);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public void setLinkLayerPreemptionPriorityForProtocol(String iface, int uid, int priorityLevel, String protocol) {
        enforceSystemOrPhoneUid();
        getOemNetdService().setLinkLayerPreemptionPriorityForProtocol(iface, uid, priorityLevel, protocol);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public int getLinkLayerPreemptionPriorityForProtocol(String iface, int uid, String protocol) {
        enforceSystemOrPhoneUid();
        return getOemNetdService().getLinkLayerPreemptionPriorityForProtocol(iface, uid, protocol);
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public void removeLinkLayerPreemptionPriority(String iface, int uid) {
        enforceSystemOrPhoneUid();
        getOemNetdService().removeLinkLayerPreemptionPriority(iface, uid);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private IOemNetd getOemNetdService() throws RemoteException {
        IBinder binder = this.mNetdService.getOemNetd();
        if (binder == null) goto L7;
        return IOemNetd.Stub.asInterface(Binder.allowBlocking(binder));
    L7:
        throw new IllegalStateException("Failed to get IOemNetd binder");
    }

    private boolean isNetworkRestrictedInternal(int uid) {
        Object r0 = this.mRulesLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (getFirewallChainState(2) == false) goto L17;
        if (this.mUidFirewallStandbyRules.get(uid) != 2) goto L17;
        if (DBG == false) goto L14;
        Slog.d(TAG, "Uid " + uid + " restricted because of app standby mode");     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L17:
        if (getFirewallChainState(1) == false) goto L26;
        if (this.mUidFirewallDozableRules.get(uid) == 1) goto L26;
        if (DBG == false) goto L23;
        Slog.d(TAG, "Uid " + uid + " restricted because of device idle mode");     // Catch: Throwable -> L12
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L26:
        if (getFirewallChainState(3) == false) goto L35;
        if (this.mUidFirewallPowerSaveRules.get(uid) == 1) goto L35;
        if (DBG == false) goto L32;
        Slog.d(TAG, "Uid " + uid + " restricted because of power saver mode");     // Catch: Throwable -> L12
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L35:
        if (getFirewallChainState(4) == false) goto L44;
        if (this.mUidFirewallRestrictedRules.get(uid) == 1) goto L44;
        if (DBG == false) goto L41;
        Slog.d(TAG, "Uid " + uid + " restricted because of restricted mode");     // Catch: Throwable -> L12
    L41:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L44:
        if (getFirewallChainState(5) == false) goto L53;
        if (this.mUidFirewallLowPowerStandbyRules.get(uid) == 1) goto L53;
        if (DBG == false) goto L50;
        Slog.d(TAG, "Uid " + uid + " restricted because of low power standby");     // Catch: Throwable -> L12
    L50:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L53:
        if (getFirewallChainState(6) == false) goto L62;
        if (this.mUidFirewallBackgroundRules.get(uid) == 1) goto L62;
        if (DBG == false) goto L59;
        Slog.d(TAG, "Uid " + uid + " restricted because it is in background");     // Catch: Throwable -> L12
    L59:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L62:
        if (this.mUseMeteredFirewallChains == false) goto L91;
        if (getFirewallChainState(11) == false) goto L73;
        if (this.mUidMeteredFirewallDenyUserRules.get(uid) != 2) goto L73;
        if (DBG == false) goto L70;
        Slog.d(TAG, "Uid " + uid + " restricted because of user-restricted metered data in the background");     // Catch: Throwable -> L12
    L70:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L73:
        if (getFirewallChainState(12) == false) goto L82;
        if (this.mUidMeteredFirewallDenyAdminRules.get(uid) != 2) goto L82;
        if (DBG == false) goto L79;
        Slog.d(TAG, "Uid " + uid + " restricted because of admin-restricted metered data in the background");     // Catch: Throwable -> L12
    L79:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L82:
        if (getFirewallChainState(10) == true) goto L84;
    L106:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L84:
        if (this.mUidMeteredFirewallAllowRules.get(uid) == 1) goto L106;
        if (DBG == false) goto L88;
        Slog.d(TAG, "Uid " + uid + " restricted because of data saver mode");     // Catch: Throwable -> L12
    L88:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L91:
        if (this.mUidRejectOnMetered.get(uid) == false) goto L98;
        if (DBG == false) goto L95;
        Slog.d(TAG, "Uid " + uid + " restricted because of no metered data in the background");     // Catch: Throwable -> L12
    L95:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L98:
        if (this.mDataSaverMode == false) goto L106;
        if (this.mUidAllowOnMetered.get(uid) == true) goto L106;
        if (DBG == false) goto L104;
        Slog.d(TAG, "Uid " + uid + " restricted because of data saver mode");     // Catch: Throwable -> L12
    L104:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    }

    private void setFirewallChainState(int chain, boolean state) {
        Object r0 = this.mRulesLock;
        monitor-enter(r0);
        this.mFirewallChainStates.put(chain, state);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean getFirewallChainState(int chain) {
        Object r0 = this.mRulesLock;
        monitor-enter(r0);
        boolean r1 = this.mFirewallChainStates.get(chain);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public NetworkManagementServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }
}
