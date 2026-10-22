package com.android.server.job.controllers;

import android.net.ConnectivityManager;
import android.net.INetworkPolicyListener;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkPolicyManager;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.telephony.CellSignalStrength;
import android.telephony.SignalStrength;
import android.telephony.TelephonyCallback;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Pools;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.LocalServices;
import com.android.server.am.ProcessList;
import com.android.server.job.Flags;
import com.android.server.job.JobSchedulerService;
import com.android.server.net.NetworkPolicyManagerInternal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class ConnectivityController extends RestrictingController implements ConnectivityManager.OnNetworkActiveListener {
    private static final boolean DEBUG = false;
    private static final int MAX_NETWORK_CALLBACKS = 125;
    private static final long MIN_ADJUST_CALLBACK_INTERVAL_MS = 1000;
    private static final long MIN_STATS_UPDATE_INTERVAL_MS = 30000;
    private static final int MSG_ADJUST_CALLBACKS = 0;
    private static final int MSG_DATA_SAVER_TOGGLED = 2;
    private static final int MSG_PROCESS_ACTIVE_NETWORK = 4;
    private static final int MSG_UID_POLICIES_CHANGED = 3;
    private static final int MSG_UPDATE_ALL_TRACKED_JOBS = 1;
    private static final String TAG = "JobScheduler.Connectivity";
    static final int TRANSPORT_AFFINITY_AVOID = 2;
    static final int TRANSPORT_AFFINITY_PREFER = 1;
    static final int TRANSPORT_AFFINITY_UNDEFINED = 0;
    private static final int UNBYPASSABLE_BG_BLOCKED_REASONS = -65;
    private static final int UNBYPASSABLE_EJ_BLOCKED_REASONS = -72;
    private static final int UNBYPASSABLE_FOREGROUND_BLOCKED_REASONS = -196680;
    private static final int UNBYPASSABLE_UI_BLOCKED_REASONS = -196680;
    public static final long UNKNOWN_TIME = -1;
    static final SparseIntArray sNetworkTransportAffinities = null;
    private final ArrayMap<Network, CachedNetworkMetadata> mAvailableNetworks;
    private final SparseBooleanArray mBackgroundMeteredAllowed;
    private final CcConfig mCcConfig;
    private final ConnectivityManager mConnManager;
    private final SparseArray<UidDefaultNetworkCallback> mCurrentDefaultNetworkCallbacks;
    private final ConnectivityManager.NetworkCallback mDefaultNetworkCallback;
    private final Pools.Pool<UidDefaultNetworkCallback> mDefaultNetworkCallbackPool;
    private final FlexibilityController mFlexibilityController;
    private final Handler mHandler;
    private long mLastAllJobUpdateTimeElapsed;
    private long mLastCallbackAdjustmentTimeElapsed;
    private final INetworkPolicyListener mNetPolicyListener;
    private final NetworkPolicyManager mNetPolicyManager;
    private final NetworkPolicyManagerInternal mNetPolicyManagerInternal;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;
    private final SparseArray<ArraySet<JobStatus>> mRequestedWhitelistJobs;
    private final SparseArray<CellSignalStrengthCallback> mSignalStrengths;
    private final List<UidStats> mSortedStats;
    private Network mSystemDefaultNetwork;
    private final SparseArray<ArraySet<JobStatus>> mTrackedJobs;
    private final SparseArray<UidStats> mUidStats;
    private final Comparator<UidStats> mUidStatsComparator;

    private static class CachedNetworkMetadata {
        public long capabilitiesFirstAcquiredTimeElapsed;
        public long defaultNetworkActivationLastCheckTimeElapsed;
        public long defaultNetworkActivationLastConfirmedTimeElapsed;
        public NetworkCapabilities networkCapabilities;
        public boolean satisfiesTransportAffinities;

        /* synthetic */ CachedNetworkMetadata(ConnectivityControllerIA r1) {
            this();
        }

        private CachedNetworkMetadata() {
        }

        public String toString() {
            return "CNM{" + this.networkCapabilities.toString() + ", satisfiesTransportAffinities=" + this.satisfiesTransportAffinities + ", capabilitiesFirstAcquiredTimeElapsed=" + this.capabilitiesFirstAcquiredTimeElapsed + ", defaultNetworkActivationLastCheckTimeElapsed=" + this.defaultNetworkActivationLastCheckTimeElapsed + ", defaultNetworkActivationLastConfirmedTimeElapsed=" + this.defaultNetworkActivationLastConfirmedTimeElapsed + "}";
        }
    }

    class CcConfig {
        private static final String CC_CONFIG_PREFIX = "conn_";
        private static final boolean DEFAULT_AVOID_UNDEFINED_TRANSPORT_AFFINITY = false;
        private static final long DEFAULT_NETWORK_ACTIVATION_EXPIRATION_MS = 10000;
        private static final long DEFAULT_NETWORK_ACTIVATION_MAX_WAIT_TIME_MS = 1860000;
        static final String KEY_AVOID_UNDEFINED_TRANSPORT_AFFINITY = "conn_avoid_undefined_transport_affinity";
        private static final String KEY_NETWORK_ACTIVATION_EXPIRATION_MS = "conn_network_activation_expiration_ms";
        private static final String KEY_NETWORK_ACTIVATION_MAX_WAIT_TIME_MS = "conn_network_activation_max_wait_time_ms";
        public boolean AVOID_UNDEFINED_TRANSPORT_AFFINITY;
        public long NETWORK_ACTIVATION_EXPIRATION_MS;
        public long NETWORK_ACTIVATION_MAX_WAIT_TIME_MS;
        private boolean mFlexIsEnabled;
        private boolean mShouldReprocessNetworkCapabilities;

        /* JADX INFO: renamed from: -$$Nest$fgetmFlexIsEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4924$$Nest$fgetmFlexIsEnabled(CcConfig r0) {
            return r0.mFlexIsEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShouldReprocessNetworkCapabilities, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4925$$Nest$fgetmShouldReprocessNetworkCapabilities(CcConfig r0) {
            return r0.mShouldReprocessNetworkCapabilities;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmFlexIsEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4926$$Nest$fputmFlexIsEnabled(CcConfig r0, boolean r1) {
            r0.mFlexIsEnabled = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmShouldReprocessNetworkCapabilities, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4927$$Nest$fputmShouldReprocessNetworkCapabilities(CcConfig r0, boolean r1) {
            r0.mShouldReprocessNetworkCapabilities = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4928$$Nest$mdump(CcConfig r0, IndentingPrintWriter r1) {
            r0.dump(r1);
        }

        CcConfig(ConnectivityController this$0) {
            this.mFlexIsEnabled = false;
            this.mShouldReprocessNetworkCapabilities = false;
            this.AVOID_UNDEFINED_TRANSPORT_AFFINITY = false;
            this.NETWORK_ACTIVATION_EXPIRATION_MS = 10000;
            this.NETWORK_ACTIVATION_MAX_WAIT_TIME_MS = DEFAULT_NETWORK_ACTIVATION_MAX_WAIT_TIME_MS;
        }

        public void processConstantLocked(DeviceConfig.Properties properties, String key) {
            switch(key.hashCode()) {
                case -1221182095: goto L12;
                case 524268654: goto L9;
                case 1011552586: goto L6;
                default: goto L14;
            };
        L14:
            byte r0 = -1;
        L15:
            switch(r0) {
                case 0: goto L23;
                case 1: goto L20;
                case 2: goto L17;
                default: goto L32;
            };
        L17:
            long maxWaitMs = properties.getLong(key, DEFAULT_NETWORK_ACTIVATION_MAX_WAIT_TIME_MS);
            if (this.NETWORK_ACTIVATION_MAX_WAIT_TIME_MS == maxWaitMs) goto L27;
            this.NETWORK_ACTIVATION_MAX_WAIT_TIME_MS = maxWaitMs;
            this.mShouldReprocessNetworkCapabilities = true;
            return;
        L27:
            return;
        L20:
            long gracePeriodMs = properties.getLong(key, 10000);
            if (this.NETWORK_ACTIVATION_EXPIRATION_MS == gracePeriodMs) goto L29;
            this.NETWORK_ACTIVATION_EXPIRATION_MS = gracePeriodMs;
            return;
        L29:
            return;
        L23:
            boolean avoid = properties.getBoolean(key, false);
            if (this.AVOID_UNDEFINED_TRANSPORT_AFFINITY == avoid) goto L31;
            this.AVOID_UNDEFINED_TRANSPORT_AFFINITY = avoid;
            this.mShouldReprocessNetworkCapabilities = true;
            return;
        L31:
            return;
        L32:
            return;
        L6:
            if (key.equals(KEY_AVOID_UNDEFINED_TRANSPORT_AFFINITY) == false) goto L14;
            r0 = 0;
            goto L15
        L9:
            if (key.equals(KEY_NETWORK_ACTIVATION_MAX_WAIT_TIME_MS) == false) goto L14;
            r0 = 2;
            goto L15
        L12:
            if (key.equals(KEY_NETWORK_ACTIVATION_EXPIRATION_MS) == false) goto L14;
            r0 = 1;
            goto L15
        }

        private void dump(IndentingPrintWriter pw) {
            pw.println();
            pw.print(ConnectivityController.class.getSimpleName());
            pw.println(":");
            pw.increaseIndent();
            pw.print(KEY_AVOID_UNDEFINED_TRANSPORT_AFFINITY, Boolean.valueOf(this.AVOID_UNDEFINED_TRANSPORT_AFFINITY)).println();
            pw.print(KEY_NETWORK_ACTIVATION_EXPIRATION_MS, Long.valueOf(this.NETWORK_ACTIVATION_EXPIRATION_MS)).println();
            pw.print(KEY_NETWORK_ACTIVATION_MAX_WAIT_TIME_MS, Long.valueOf(this.NETWORK_ACTIVATION_MAX_WAIT_TIME_MS)).println();
            pw.decreaseIndent();
        }
    }

    private class CcHandler extends Handler {
        final /* synthetic */ ConnectivityController this$0;

        CcHandler(ConnectivityController r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            boolean newAllowed = false;
            switch(msg.what) {
                case 0: goto L55;
                case 1: goto L44;
                case 2: goto L36;
                case 3: goto L22;
                case 4: goto L7;
                default: goto L59;
            };     // Catch: Throwable -> L20
        L7:
            removeMessages(4);     // Catch: Throwable -> L20
            Object r1 = this.this$0.mLock;     // Catch: Throwable -> L20
            monitor-enter(r1);     // Catch: Throwable -> L20
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L10:
            if (ConnectivityController.m4915$$Nest$fgetmSystemDefaultNetwork(this.this$0) != null) goto L16;
            monitor-exit(r1);     // Catch: Throwable -> L13
        L66:
        L16:
            monitor-exit(r1);     // Catch: Throwable -> L13
            goto L66
        L22:
            int uid = msg.arg1;     // Catch: Throwable -> L20
            if (msg.arg2 == 3) goto L25;
            newAllowed = true;
        L25:
            Object r4 = this.this$0.mLock;     // Catch: Throwable -> L20
            monitor-enter(r4);     // Catch: Throwable -> L20
            boolean oldAllowed = ConnectivityController.m4909$$Nest$fgetmBackgroundMeteredAllowed(this.this$0).get(uid);     // Catch: Throwable -> L30
            if (oldAllowed == newAllowed) goto L32;
            ConnectivityController.m4909$$Nest$fgetmBackgroundMeteredAllowed(this.this$0).put(uid, newAllowed);     // Catch: Throwable -> L30
            ConnectivityController.m4921$$Nest$mupdateTrackedJobsLocked(this.this$0, uid, null);     // Catch: Throwable -> L30
        L32:
            monitor-exit(r4);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L36:
            removeMessages(2);     // Catch: Throwable -> L20
            Object r2 = this.this$0.mLock;     // Catch: Throwable -> L20
            monitor-enter(r2);     // Catch: Throwable -> L20
            ConnectivityController.m4909$$Nest$fgetmBackgroundMeteredAllowed(this.this$0).clear();     // Catch: Throwable -> L41
            ConnectivityController.m4921$$Nest$mupdateTrackedJobsLocked(this.this$0, -1, null);     // Catch: Throwable -> L41
            monitor-exit(r2);     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L44:
            Object r3 = this.this$0.mLock;     // Catch: Throwable -> L20
            monitor-enter(r3);     // Catch: Throwable -> L20
        L52:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L47:
            if (msg.arg1 != 1) goto L49;
            newAllowed = true;
        L49:
            ConnectivityController.m4920$$Nest$mupdateAllTrackedJobsLocked(this.this$0, newAllowed);     // Catch: Throwable -> L52
            monitor-exit(r3);     // Catch: Throwable -> L52
        L55:
            Object r5 = this.this$0.mLock;     // Catch: Throwable -> L20
            monitor-enter(r5);     // Catch: Throwable -> L20
            ConnectivityController.m4917$$Nest$mmaybeAdjustRegisteredCallbacksLocked(this.this$0);     // Catch: Throwable -> L61
            monitor-exit(r5);     // Catch: Throwable -> L61
        L61:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L59:
            monitor-exit(r0);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        }
    }

    private class CellSignalStrengthCallback extends TelephonyCallback implements TelephonyCallback.SignalStrengthsListener {
        public int signalStrength;
        final /* synthetic */ ConnectivityController this$0;

        /* synthetic */ CellSignalStrengthCallback(ConnectivityController r1, ConnectivityControllerIA r2) {
            this(r1);
        }

        private CellSignalStrengthCallback(ConnectivityController r1) {
            this.this$0 = r1;
            this.signalStrength = 4;
        }

        @Override // android.telephony.TelephonyCallback.SignalStrengthsListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int newSignalStrength = signalStrength.getLevel();     // Catch: Throwable -> L10
            if (ConnectivityController.m4923$$Nest$sfgetDEBUG() == false) goto L13;
            Slog.d(ConnectivityController.TAG, "Signal strength changing from " + this.signalStrength + " to " + newSignalStrength);     // Catch: Throwable -> L10
            Iterator<CellSignalStrength> r2 = signalStrength.getCellSignalStrengths().iterator();     // Catch: Throwable -> L10
        L8:
            if (r2.hasNext() == false) goto L13;
            CellSignalStrength css = r2.next();     // Catch: Throwable -> L10
            Slog.d(ConnectivityController.TAG, "CSS: " + css.getLevel() + " " + css);     // Catch: Throwable -> L10
        L13:
            if (this.signalStrength != newSignalStrength) goto L16;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L16:
            this.signalStrength = newSignalStrength;     // Catch: Throwable -> L10
            ConnectivityController.m4912$$Nest$fgetmHandler(this.this$0).obtainMessage(1, 1, 0).sendToTarget();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    private class UidDefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        private int mBlockedReasons;
        private Network mDefaultNetwork;
        private int mUid;
        final /* synthetic */ ConnectivityController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmBlockedReasons, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4929$$Nest$fgetmBlockedReasons(UidDefaultNetworkCallback r0) {
            return r0.mBlockedReasons;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDefaultNetwork, reason: not valid java name */
        static /* bridge */ /* synthetic */ Network m4930$$Nest$fgetmDefaultNetwork(UidDefaultNetworkCallback r0) {
            return r0.mDefaultNetwork;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmDefaultNetwork, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4931$$Nest$fputmDefaultNetwork(UidDefaultNetworkCallback r0, Network r1) {
            r0.mDefaultNetwork = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mclear, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4932$$Nest$mclear(UidDefaultNetworkCallback r0) {
            r0.clear();
        }

        /* JADX INFO: renamed from: -$$Nest$mdumpLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4933$$Nest$mdumpLocked(UidDefaultNetworkCallback r0, IndentingPrintWriter r1) {
            r0.dumpLocked(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4934$$Nest$msetUid(UidDefaultNetworkCallback r0, int r1) {
            r0.setUid(r1);
        }

        /* synthetic */ UidDefaultNetworkCallback(ConnectivityController r1, ConnectivityControllerIA r2) {
            this(r1);
        }

        private UidDefaultNetworkCallback(ConnectivityController r1) {
            this.this$0 = r1;
        }

        private void setUid(int uid) {
            this.mUid = uid;
            this.mDefaultNetwork = null;
        }

        private void clear() {
            this.mDefaultNetwork = null;
            this.mUid = ProcessList.INVALID_ADJ;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (ConnectivityController.m4923$$Nest$sfgetDEBUG() == false) goto L6;
            Slog.v(ConnectivityController.TAG, "default-onAvailable(" + this.mUid + "): " + network);
            return;
        }

        public void onBlockedStatusChanged(Network network, int blockedReasons) {
            if (ConnectivityController.m4923$$Nest$sfgetDEBUG() == false) goto L6;
            Slog.v(ConnectivityController.TAG, "default-onBlockedStatusChanged(" + this.mUid + "): " + network + " -> " + blockedReasons);
        L6:
            if (this.mUid != (-10000)) goto L8;
            return;
        L8:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.mDefaultNetwork = network;     // Catch: Throwable -> L13
            this.mBlockedReasons = blockedReasons;     // Catch: Throwable -> L13
            ConnectivityController.m4921$$Nest$mupdateTrackedJobsLocked(this.this$0, this.mUid, network);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (ConnectivityController.m4923$$Nest$sfgetDEBUG() == false) goto L6;
            Slog.v(ConnectivityController.TAG, "default-onLost(" + this.mUid + "): " + network);
        L6:
            if (this.mUid != (-10000)) goto L8;
            return;
        L8:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L11:
            if (Objects.equals(this.mDefaultNetwork, network) == false) goto L15;
            this.mDefaultNetwork = null;     // Catch: Throwable -> L13
            ConnectivityController.m4921$$Nest$mupdateTrackedJobsLocked(this.this$0, this.mUid, network);     // Catch: Throwable -> L13
            ConnectivityController.m4919$$Nest$mpostAdjustCallbacks(this.this$0, 1000);     // Catch: Throwable -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L13
        }

        private void dumpLocked(IndentingPrintWriter pw) {
            pw.print("UID: ");
            pw.print(this.mUid);
            pw.print("; ");
            if (this.mDefaultNetwork != null) goto L5;
            pw.print("No network");
        L6:
            pw.println();
            return;
        L5:
            pw.print("Network: ");
            pw.print(this.mDefaultNetwork);
            pw.print(" (blocked=");
            pw.print(NetworkPolicyManager.blockedReasonsToString(this.mBlockedReasons));
            pw.print(")");
            goto L6
        }
    }

    private static class UidStats {
        public int baseBias;
        public long earliestEJEnqueueTime;
        public long earliestEnqueueTime;
        public long earliestUIJEnqueueTime;
        public long lastUpdatedElapsed;
        public int numEJs;
        public int numReadyWithConnectivity;
        public int numRegular;
        public int numRequestedNetworkAvailable;
        public int numUIJs;
        public final ArraySet<JobStatus> runningJobs;
        public final int uid;

        /* JADX INFO: renamed from: -$$Nest$mdumpLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4935$$Nest$mdumpLocked(UidStats r0, IndentingPrintWriter r1, long r2) {
            r0.dumpLocked(r1, r2);
        }

        /* synthetic */ UidStats(int r1, ConnectivityControllerIA r2) {
            this(r1);
        }

        private UidStats(int uid) {
            this.runningJobs = new ArraySet();
            this.uid = uid;
        }

        private void dumpLocked(IndentingPrintWriter pw, long nowElapsed) {
            pw.print("UidStats{");
            pw.print("uid", Integer.valueOf(this.uid));
            pw.print("pri", Integer.valueOf(this.baseBias));
            pw.print("#run", Integer.valueOf(this.runningJobs.size()));
            pw.print("#readyWithConn", Integer.valueOf(this.numReadyWithConnectivity));
            pw.print("#netAvail", Integer.valueOf(this.numRequestedNetworkAvailable));
            pw.print("#EJs", Integer.valueOf(this.numEJs));
            pw.print("#reg", Integer.valueOf(this.numRegular));
            pw.print("earliestEnqueue", Long.valueOf(this.earliestEnqueueTime));
            pw.print("earliestEJEnqueue", Long.valueOf(this.earliestEJEnqueueTime));
            pw.print("earliestUIJEnqueue", Long.valueOf(this.earliestUIJEnqueueTime));
            pw.print("updated=");
            TimeUtils.formatDuration(this.lastUpdatedElapsed - nowElapsed, pw);
            pw.println("}");
        }
    }

    public static /* synthetic */ void $r8$lambda$MqfC7AxNiM37KdNO4Z5A70P8tKE(ConnectivityController r0) {
        r0.lambda$onConstantsUpdatedLocked$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAvailableNetworks, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m4908$$Nest$fgetmAvailableNetworks(ConnectivityController r0) {
        return r0.mAvailableNetworks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackgroundMeteredAllowed, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m4909$$Nest$fgetmBackgroundMeteredAllowed(ConnectivityController r0) {
        return r0.mBackgroundMeteredAllowed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentDefaultNetworkCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4910$$Nest$fgetmCurrentDefaultNetworkCallbacks(ConnectivityController r0) {
        return r0.mCurrentDefaultNetworkCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlexibilityController, reason: not valid java name */
    static /* bridge */ /* synthetic */ FlexibilityController m4911$$Nest$fgetmFlexibilityController(ConnectivityController r0) {
        return r0.mFlexibilityController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m4912$$Nest$fgetmHandler(ConnectivityController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetPolicyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ NetworkPolicyManager m4913$$Nest$fgetmNetPolicyManager(ConnectivityController r0) {
        return r0.mNetPolicyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSignalStrengths, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4914$$Nest$fgetmSignalStrengths(ConnectivityController r0) {
        return r0.mSignalStrengths;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemDefaultNetwork, reason: not valid java name */
    static /* bridge */ /* synthetic */ Network m4915$$Nest$fgetmSystemDefaultNetwork(ConnectivityController r0) {
        return r0.mSystemDefaultNetwork;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSystemDefaultNetwork, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4916$$Nest$fputmSystemDefaultNetwork(ConnectivityController r0, Network r1) {
        r0.mSystemDefaultNetwork = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeAdjustRegisteredCallbacksLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4917$$Nest$mmaybeAdjustRegisteredCallbacksLocked(ConnectivityController r0) {
        r0.maybeAdjustRegisteredCallbacksLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mpostAdjustCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4918$$Nest$mpostAdjustCallbacks(ConnectivityController r0) {
        r0.postAdjustCallbacks();
    }

    /* JADX INFO: renamed from: -$$Nest$mpostAdjustCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4919$$Nest$mpostAdjustCallbacks(ConnectivityController r0, long r1) {
        r0.postAdjustCallbacks(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAllTrackedJobsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4920$$Nest$mupdateAllTrackedJobsLocked(ConnectivityController r0, boolean r1) {
        r0.updateAllTrackedJobsLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateTrackedJobsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4921$$Nest$mupdateTrackedJobsLocked(ConnectivityController r0, int r1, Network r2) {
        r0.updateTrackedJobsLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateTransportAffinitySatisfaction, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4922$$Nest$mupdateTransportAffinitySatisfaction(ConnectivityController r0, CachedNetworkMetadata r1) {
        return r0.updateTransportAffinitySatisfaction(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4923$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        if (JobSchedulerService.DEBUG == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        DEBUG = r0;
        sNetworkTransportAffinities = new SparseIntArray();
        sNetworkTransportAffinities.put(0, 2);
        sNetworkTransportAffinities.put(3, 1);
        sNetworkTransportAffinities.put(10, 2);
        sNetworkTransportAffinities.put(1, 1);
        return;
    L5:
        if (Log.isLoggable(TAG, 3) == true) goto L8;
        r0 = false;
        goto L9
    }

    public ConnectivityController(JobSchedulerService service, FlexibilityController flexibilityController) {
        super(service);
        this.mTrackedJobs = new SparseArray();
        this.mRequestedWhitelistJobs = new SparseArray();
        this.mAvailableNetworks = new ArrayMap();
        this.mCurrentDefaultNetworkCallbacks = new SparseArray();
        this.mUidStatsComparator = new AnonymousClass1(this);
        this.mUidStats = new SparseArray();
        this.mDefaultNetworkCallbackPool = new Pools.SimplePool(125);
        this.mSortedStats = new ArrayList();
        this.mBackgroundMeteredAllowed = new SparseBooleanArray();
        this.mSignalStrengths = new SparseArray();
        this.mNetworkCallback = new AnonymousClass2(this);
        this.mDefaultNetworkCallback = new AnonymousClass3(this);
        this.mNetPolicyListener = new AnonymousClass4(this);
        this.mHandler = new CcHandler(this, AppSchedulingModuleThread.get().getLooper());
        this.mCcConfig = new CcConfig(this);
        this.mConnManager = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        this.mNetPolicyManager = (NetworkPolicyManager) this.mContext.getSystemService(NetworkPolicyManager.class);
        this.mNetPolicyManagerInternal = (NetworkPolicyManagerInternal) LocalServices.getService(NetworkPolicyManagerInternal.class);
        this.mFlexibilityController = flexibilityController;
        NetworkRequest request = new NetworkRequest.Builder().clearCapabilities().build();
        this.mConnManager.registerNetworkCallback(request, this.mNetworkCallback);
        this.mNetPolicyManager.registerListener(this.mNetPolicyListener);
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch") == false) goto L6;
        sNetworkTransportAffinities.clear();
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void startTrackingLocked() {
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus jobStatus, JobStatus lastJob) {
        if (jobStatus.hasConnectivityConstraint() == false) goto L12;
        UidStats uidStats = getUidStats(jobStatus.getSourceUid(), jobStatus.getSourcePackageName(), false);
        if (wouldBeReadyWithConstraintLocked(jobStatus, 268435456) == false) goto L7;
        uidStats.numReadyWithConnectivity++;
    L7:
        ArraySet<JobStatus> jobs = this.mTrackedJobs.get(jobStatus.getSourceUid());
        if (jobs != null) goto L10;
        jobs = new ArraySet();
        this.mTrackedJobs.put(jobStatus.getSourceUid(), jobs);
    L10:
        jobs.add(jobStatus);
        jobStatus.setTrackingController(2);
        updateConstraintsSatisfied(jobStatus);
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void prepareForExecutionLocked(JobStatus jobStatus) {
        if (jobStatus.hasConnectivityConstraint() == false) goto L6;
        UidStats uidStats = getUidStats(jobStatus.getSourceUid(), jobStatus.getSourcePackageName(), true);
        uidStats.runningJobs.add(jobStatus);
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void unprepareFromExecutionLocked(JobStatus jobStatus) {
        if (jobStatus.hasConnectivityConstraint() == false) goto L6;
        UidStats uidStats = getUidStats(jobStatus.getSourceUid(), jobStatus.getSourcePackageName(), true);
        uidStats.runningJobs.remove(jobStatus);
        postAdjustCallbacks();
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus jobStatus, JobStatus incomingJob) {
        if (jobStatus.clearTrackingController(2) == false) goto L9;
        ArraySet<JobStatus> jobs = this.mTrackedJobs.get(jobStatus.getSourceUid());
        if (jobs == null) goto L7;
        jobs.remove(jobStatus);
    L7:
        UidStats uidStats = getUidStats(jobStatus.getSourceUid(), jobStatus.getSourcePackageName(), true);
        uidStats.numReadyWithConnectivity--;
        uidStats.runningJobs.remove(jobStatus);
        maybeRevokeStandbyExceptionLocked(jobStatus);
        postAdjustCallbacks();
        return;
    }

    @Override // com.android.server.job.controllers.RestrictingController
    public void startTrackingRestrictedJobLocked(JobStatus jobStatus) {
        if (jobStatus.hasConnectivityConstraint() == false) goto L6;
        updateConstraintsSatisfied(jobStatus);
        return;
    }

    @Override // com.android.server.job.controllers.RestrictingController
    public void stopTrackingRestrictedJobLocked(JobStatus jobStatus) {
        if (jobStatus.hasConnectivityConstraint() == false) goto L6;
        updateConstraintsSatisfied(jobStatus);
        return;
    }

    private UidStats getUidStats(int uid, String packageName, boolean shouldExist) {
        UidStats us = this.mUidStats.get(uid);
        if (us != null) goto L8;
        if (shouldExist == false) goto L6;
        Slog.wtfStack(TAG, "UidStats was null after job for " + packageName + " was registered");
    L6:
        UidStats us2 = new UidStats(uid, null);
        this.mUidStats.append(uid, us2);
        return us2;
    L8:
        return us;
    }

    public boolean isNetworkAvailable(JobStatus job) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L27:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mAvailableNetworks.size()) goto L22;
        Network network = this.mAvailableNetworks.keyAt(i);     // Catch: Throwable -> L14
        CachedNetworkMetadata metadata = this.mAvailableNetworks.valueAt(i);     // Catch: Throwable -> L14
        if (metadata != null) goto L10;
        NetworkCapabilities capabilities = null;
    L11:
        boolean satisfied = isSatisfied(job, network, capabilities, this.mConstants);     // Catch: Throwable -> L14
        if (DEBUG == false) goto L16;
        Slog.v(TAG, "isNetworkAvailable(" + job + ") with network " + network + " and capabilities " + capabilities + ". Satisfied=" + satisfied);     // Catch: Throwable -> L14
    L16:
        if (satisfied == true) goto L17;
        i = i + 1;     // Catch: Throwable -> L14
        goto L27
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L10:
        capabilities = metadata.networkCapabilities;     // Catch: Throwable -> L14
        goto L11
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    }

    void requestStandbyExceptionLocked(JobStatus job) {
        int uid = job.getSourceUid();
        boolean isExceptionRequested = isStandbyExceptionRequestedLocked(uid);
        ArraySet<JobStatus> jobs = this.mRequestedWhitelistJobs.get(uid);
        if (jobs != null) goto L6;
        jobs = new ArraySet();
        this.mRequestedWhitelistJobs.put(uid, jobs);
    L6:
        if (jobs.add(job) == false) goto L15;
        if (isExceptionRequested == true) goto L15;
        if (DEBUG == false) goto L12;
        Slog.i(TAG, "Requesting standby exception for UID: " + uid);
    L12:
        this.mNetPolicyManagerInternal.setAppIdleWhitelist(uid, true);
        return;
    L15:
        if (DEBUG == false) goto L18;
        Slog.i(TAG, "requestStandbyExceptionLocked found exception already requested.");
        return;
    }

    boolean isStandbyExceptionRequestedLocked(int uid) {
        ArraySet<JobStatus> r0 = this.mRequestedWhitelistJobs.get(uid);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.size() <= 0) goto L7;
        return true;
    }

    @Override // com.android.server.job.controllers.StateController
    public void evaluateStateLocked(JobStatus jobStatus) {
        if (jobStatus.hasConnectivityConstraint() == true) goto L5;
        return;
    L5:
        UidStats uidStats = getUidStats(jobStatus.getSourceUid(), jobStatus.getSourcePackageName(), true);
        if (jobStatus.shouldTreatAsExpeditedJob() == true) goto L23;
        if (jobStatus.shouldTreatAsUserInitiatedJob() == true) goto L23;
        if (jobStatus.isRequestedExpeditedJob() == false) goto L15;
        if (jobStatus.shouldTreatAsExpeditedJob() == true) goto L15;
    L20:
        if (jobStatus.isConstraintSatisfied(268435456) == false) goto L26;
        updateConstraintsSatisfied(jobStatus);
    L26:
        if (wouldBeReadyWithConstraintLocked(jobStatus, 268435456) == false) goto L34;
        if (isNetworkAvailable(jobStatus) == false) goto L34;
        if (DEBUG == false) goto L32;
        Slog.i(TAG, "evaluateStateLocked finds job " + jobStatus + " would be ready.");
    L32:
        uidStats.numReadyWithConnectivity++;
        requestStandbyExceptionLocked(jobStatus);
        return;
    L34:
        if (DEBUG == false) goto L36;
        Slog.i(TAG, "evaluateStateLocked finds job " + jobStatus + " would not be ready.");
    L36:
        maybeRevokeStandbyExceptionLocked(jobStatus);
        return;
    L15:
        if (jobStatus.getJob().isUserInitiated() == false) goto L26;
        if (jobStatus.shouldTreatAsUserInitiatedJob() == true) goto L26;
    L23:
        if (jobStatus.isConstraintSatisfied(268435456) == true) goto L26;
        updateConstraintsSatisfied(jobStatus);
        goto L26
    }

    @Override // com.android.server.job.controllers.StateController
    public void reevaluateStateLocked(int uid) {
        ArraySet<JobStatus> jobs = this.mTrackedJobs.get(uid);
        if (jobs != null) goto L5;
        return;
    L5:
        int i = jobs.size() - 1;
    L6:
        if (i < 0) goto L9;
        evaluateStateLocked(jobs.valueAt(i));
        i = i - 1;
        goto L6
    }

    void maybeRevokeStandbyExceptionLocked(JobStatus job) {
        int uid = job.getSourceUid();
        if (isStandbyExceptionRequestedLocked(uid) == true) goto L5;
        return;
    L5:
        ArraySet<JobStatus> jobs = this.mRequestedWhitelistJobs.get(uid);
        if (jobs != null) goto L10;
        Slog.wtf(TAG, "maybeRevokeStandbyExceptionLocked found null jobs array even though a standby exception has been requested.");
        return;
    L10:
        if (jobs.remove(job) == false) goto L17;
        if (jobs.size() > 0) goto L17;
        revokeStandbyExceptionLocked(uid);
        return;
    L17:
        if (DEBUG == false) goto L20;
        Slog.i(TAG, "maybeRevokeStandbyExceptionLocked not revoking because there are still " + jobs.size() + " jobs left.");
        return;
    }

    private void revokeStandbyExceptionLocked(int uid) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "Revoking standby exception for UID: " + uid);
    L5:
        this.mNetPolicyManagerInternal.setAppIdleWhitelist(uid, false);
        this.mRequestedWhitelistJobs.remove(uid);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onAppRemovedLocked(String pkgName, int uid) {
        if (this.mService.getPackagesForUidLocked(uid) != null) goto L6;
        this.mTrackedJobs.delete(uid);
        this.mBackgroundMeteredAllowed.delete(uid);
        UidStats uidStats = (UidStats) this.mUidStats.removeReturnOld(uid);
        unregisterDefaultNetworkCallbackLocked(uid, JobSchedulerService.sElapsedRealtimeClock.millis());
        this.mSortedStats.remove(uidStats);
        registerPendingUidCallbacksLocked();
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUserRemovedLocked(int userId) {
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        int u = this.mUidStats.size() - 1;
    L3:
        if (u < 0) goto L8;
        UidStats uidStats = this.mUidStats.valueAt(u);
        if (UserHandle.getUserId(uidStats.uid) != userId) goto L7;
        unregisterDefaultNetworkCallbackLocked(uidStats.uid, nowElapsed);
        this.mSortedStats.remove(uidStats);
        this.mUidStats.removeAt(u);
    L7:
        u = u - 1;
        goto L3
    L8:
        int u2 = this.mBackgroundMeteredAllowed.size() - 1;
    L9:
        if (u2 < 0) goto L14;
        int uid = this.mBackgroundMeteredAllowed.keyAt(u2);
        if (UserHandle.getUserId(uid) != userId) goto L13;
        this.mBackgroundMeteredAllowed.removeAt(u2);
    L13:
        u2 = u2 - 1;
        goto L9
    L14:
        postAdjustCallbacks();
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUidBiasChangedLocked(int uid, int prevBias, int newBias) {
        UidStats uidStats = this.mUidStats.get(uid);
        if (uidStats != null) goto L5;
        return;
    L5:
        if (uidStats.baseBias == newBias) goto L9;
        uidStats.baseBias = newBias;
        postAdjustCallbacks();
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onBatteryStateChangedLocked() {
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // com.android.server.job.controllers.StateController
    public void prepareForUpdatedConstantsLocked() {
        CcConfig.m4927$$Nest$fputmShouldReprocessNetworkCapabilities(this.mCcConfig, false);
        CcConfig.m4926$$Nest$fputmFlexIsEnabled(this.mCcConfig, this.mFlexibilityController.isEnabled());
    }

    @Override // com.android.server.job.controllers.StateController
    public void processConstantLocked(DeviceConfig.Properties properties, String key) {
        this.mCcConfig.processConstantLocked(properties, key);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onConstantsUpdatedLocked() {
        if (CcConfig.m4925$$Nest$fgetmShouldReprocessNetworkCapabilities(this.mCcConfig) == false) goto L5;
    L6:
        AppSchedulingModuleThread.getHandler().post(new ConnectivityController$$ExternalSyntheticLambda0(this));
        return;
    L5:
        if (this.mFlexibilityController.isEnabled() != CcConfig.m4924$$Nest$fgetmFlexIsEnabled(this.mCcConfig)) goto L6;
    }

    private /* synthetic */ void lambda$onConstantsUpdatedLocked$0() {
        boolean flexAffinitiesChanged = false;
        boolean flexAffinitiesSatisfied = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
        int i = 0;
    L24:
    L15:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mAvailableNetworks.size()) goto L18;
        CachedNetworkMetadata metadata = this.mAvailableNetworks.valueAt(i);     // Catch: Throwable -> L15
        if (metadata != null) goto L11;
    L14:
        i = i + 1;     // Catch: Throwable -> L15
        goto L24
    L11:
        if (updateTransportAffinitySatisfaction(metadata) == false) goto L13;
        flexAffinitiesChanged = true;
    L13:
        flexAffinitiesSatisfied = flexAffinitiesSatisfied | metadata.satisfiesTransportAffinities;     // Catch: Throwable -> L15
        goto L14
    L18:
        if (flexAffinitiesChanged == false) goto L20;
        this.mFlexibilityController.setConstraintSatisfied(268435456, flexAffinitiesSatisfied, JobSchedulerService.sElapsedRealtimeClock.millis());     // Catch: Throwable -> L15
        updateAllTrackedJobsLocked(false);     // Catch: Throwable -> L15
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L15
    }

    private boolean isUsable(NetworkCapabilities capabilities) {
        if (capabilities != null) goto L4;
    L6:
        return false;
    L4:
        if (capabilities.hasCapability(21) == false) goto L6;
        return true;
    }

    private boolean isInsane(JobStatus jobStatus, Network network, NetworkCapabilities capabilities, JobSchedulerService.Constants constants) {
        long maxJobExecutionTimeMs = this.mService.getMaxJobExecutionTimeMs(jobStatus);
        long minimumChunkBytes = jobStatus.getMinimumNetworkChunkBytes();
        if (minimumChunkBytes == (-1)) goto L20;
        long bandwidthDown = capabilities.getLinkDownstreamBandwidthKbps();
        if (bandwidthDown <= 0) goto L11;
        long estimatedMillis = calculateTransferTimeMs(minimumChunkBytes, bandwidthDown);
        if (estimatedMillis <= maxJobExecutionTimeMs) goto L11;
        Slog.w(TAG, "Minimum chunk " + minimumChunkBytes + " bytes over " + bandwidthDown + " kbps network would take " + estimatedMillis + "ms and job has " + maxJobExecutionTimeMs + "ms to run; that's insane!");
        return true;
    L11:
        long bandwidthUp = capabilities.getLinkUpstreamBandwidthKbps();
        if (bandwidthUp <= 0) goto L18;
        long estimatedMillis2 = calculateTransferTimeMs(minimumChunkBytes, bandwidthUp);
        if (estimatedMillis2 <= maxJobExecutionTimeMs) goto L18;
        Slog.w(TAG, "Minimum chunk " + minimumChunkBytes + " bytes over " + bandwidthUp + " kbps network would take " + estimatedMillis2 + "ms and job has " + maxJobExecutionTimeMs + "ms to run; that's insane!");
        return true;
    L18:
        return false;
    L20:
        if (capabilities.hasCapability(11) == false) goto L25;
        if (this.mService.isBatteryCharging() == false) goto L25;
        return false;
    L25:
        if (jobStatus.mSourcePkgIsSystem == false) goto L28;
        Slog.i(TAG, jobStatus.sourcePackageName + " not check streamBandwidthKbps");
        return false;
    L28:
        long downloadBytes = jobStatus.getEstimatedNetworkDownloadBytes();
        if (downloadBytes == (-1)) goto L38;
        long bandwidth = capabilities.getLinkDownstreamBandwidthKbps();
        if (bandwidth <= 0) goto L38;
        long estimatedMillis3 = calculateTransferTimeMs(downloadBytes, bandwidth);
        if (estimatedMillis3 <= maxJobExecutionTimeMs) goto L38;
        Slog.w(TAG, "Estimated " + downloadBytes + " download bytes over " + bandwidth + " kbps network would take " + estimatedMillis3 + "ms and job has " + maxJobExecutionTimeMs + "ms to run; that's insane!");
        return true;
    L38:
        long uploadBytes = jobStatus.getEstimatedNetworkUploadBytes();
        if (uploadBytes == (-1)) goto L48;
        long bandwidth2 = capabilities.getLinkUpstreamBandwidthKbps();
        if (bandwidth2 <= 0) goto L48;
        long estimatedMillis4 = calculateTransferTimeMs(uploadBytes, bandwidth2);
        if (estimatedMillis4 <= maxJobExecutionTimeMs) goto L48;
        Slog.w(TAG, "Estimated " + uploadBytes + " upload bytes over " + bandwidth2 + " kbps network would take " + estimatedMillis4 + "ms and job has " + maxJobExecutionTimeMs + "ms to run; that's insane!");
        return true;
    L48:
        return false;
    }

    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v6 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchDebugInfoByOffset(DebugInfoApplyVisitor.java:107)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:83)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r16v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v1 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r16v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v1 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r16v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v2 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v6 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v7 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v8 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v2 ??, new type: android.util.SparseBooleanArray
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v3 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v1 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    private boolean isMeteredAllowed(com.android.server.job.controllers.JobStatus r18, android.net.NetworkCapabilities r19) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x010f: MOVE (r3v8 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16v2 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) A[DECLARE_VAR] in method: com.android.server.job.controllers.ConnectivityController.isMeteredAllowed(com.android.server.job.controllers.JobStatus, android.net.NetworkCapabilities):boolean, file: classes2.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.job.controllers.ConnectivityController.isMeteredAllowed(com.android.server.job.controllers.JobStatus, android.net.NetworkCapabilities):boolean");
    }

    public long getEstimatedTransferTimeMs(JobStatus jobStatus) {
        long downloadBytes = jobStatus.getEstimatedNetworkDownloadBytes();
        long uploadBytes = jobStatus.getEstimatedNetworkUploadBytes();
        if (downloadBytes != (-1)) goto L8;
        if (uploadBytes != (-1)) goto L8;
        return -1;
    L8:
        if (jobStatus.network != null) goto L10;
        return -1;
    L10:
        NetworkCapabilities capabilities = getNetworkCapabilities(jobStatus.network);
        if (capabilities != null) goto L13;
        return -1;
    L13:
        long estimatedDownloadTimeMs = calculateTransferTimeMs(downloadBytes, capabilities.getLinkDownstreamBandwidthKbps());
        long estimatedUploadTimeMs = calculateTransferTimeMs(uploadBytes, capabilities.getLinkUpstreamBandwidthKbps());
        if (estimatedDownloadTimeMs != (-1)) goto L17;
        return estimatedUploadTimeMs;
    L17:
        if (estimatedUploadTimeMs != (-1)) goto L20;
        return estimatedDownloadTimeMs;
    L20:
        return estimatedDownloadTimeMs + estimatedUploadTimeMs;
    }

    static long calculateTransferTimeMs(long transferBytes, long bandwidthKbps) {
        if (transferBytes != (-1)) goto L5;
    L9:
        return -1;
    L5:
        if (bandwidthKbps <= 0) goto L9;
        return (transferBytes * 1000) / ((1000 * bandwidthKbps) / 8);
    }

    private static boolean isCongestionDelayed(JobStatus jobStatus, Network network, NetworkCapabilities capabilities, JobSchedulerService.Constants constants) {
        if (capabilities.hasCapability(20) == false) goto L5;
        return false;
    L5:
        if (jobStatus.getFractionRunTime() >= constants.CONN_CONGESTION_DELAY_FRAC) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isStrongEnough(JobStatus jobStatus, NetworkCapabilities capabilities, JobSchedulerService.Constants constants) {
        int priority = jobStatus.getEffectivePriority();
        if (priority < 400) goto L6;
        return true;
    L6:
        if (constants.CONN_USE_CELL_SIGNAL_STRENGTH == true) goto L9;
        return true;
    L9:
        if (capabilities.hasTransport(0) == true) goto L12;
        return true;
    L12:
        if (capabilities.hasTransport(4) == false) goto L14;
        return true;
    L14:
        int signalStrength = 0;
        Set<Integer> subscriptionIds = capabilities.getSubscriptionIds();
        Iterator<Integer> r5 = subscriptionIds.iterator();
    L16:
        if (r5.hasNext() == false) goto L23;
        int subId = r5.next().intValue();
        CellSignalStrengthCallback callback = this.mSignalStrengths.get(subId);
        if (callback != null) goto L19;
        Slog.wtf(TAG, "Subscription ID " + subId + " doesn't have a registered callback");
        goto L16
    L19:
        signalStrength = Math.max(signalStrength, callback.signalStrength);
        goto L16
    L23:
        if (DEBUG == false) goto L25;
        Slog.d(TAG, "Cell signal strength for job=" + signalStrength);
    L25:
        if (signalStrength > 1) goto L41;
        if (priority <= 300) goto L29;
        return true;
    L29:
        if (priority >= 300) goto L32;
        return false;
    L32:
        if (this.mService.isBatteryCharging() == false) goto L36;
        if (this.mService.isBatteryNotLow() == false) goto L36;
        return true;
    L36:
        if (jobStatus.getFractionRunTime() <= constants.CONN_PREFETCH_RELAX_FRAC) goto L39;
        return true;
    L39:
        return false;
    L41:
        if (signalStrength <= 2) goto L43;
        return true;
    L43:
        if (priority < 200) goto L46;
        return true;
    L46:
        if (this.mService.isBatteryCharging() == true) goto L48;
    L50:
        UidStats uidStats = getUidStats(jobStatus.getSourceUid(), jobStatus.getSourcePackageName(), true);
        return uidStats.runningJobs.contains(jobStatus);
    L48:
        if (this.mService.isBatteryNotLow() == false) goto L50;
        return true;
    }

    private static NetworkCapabilities.Builder copyCapabilities(NetworkRequest request) {
        NetworkCapabilities.Builder builder = new NetworkCapabilities.Builder();
        int[] r1 = request.getTransportTypes();
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        int transport = r1[r4];
        builder.addTransportType(transport);
        r4 = r4 + 1;
        goto L3
    L5:
        int[] r5 = request.getCapabilities();
        int r6 = r5.length;
    L6:
        if (r3 >= r6) goto L8;
        int capability = r5[r3];
        builder.addCapability(capability);
        r3 = r3 + 1;
        goto L6
    L8:
        return builder;
    }

    private static boolean isStrictSatisfied(JobStatus jobStatus, Network network, NetworkCapabilities capabilities, JobSchedulerService.Constants constants) {
        if (jobStatus.getEffectiveStandbyBucket() != 5) goto L9;
        if (jobStatus.isConstraintSatisfied(16777216) == true) goto L9;
        NetworkCapabilities.Builder builder = copyCapabilities(jobStatus.getJob().getRequiredNetwork());
        builder.addCapability(11);
        return builder.build().satisfiedByNetworkCapabilities(capabilities);
    L9:
        return jobStatus.getJob().getRequiredNetwork().canBeSatisfiedBy(capabilities);
    }

    private boolean isRelaxedSatisfied(JobStatus jobStatus, Network network, NetworkCapabilities capabilities, JobSchedulerService.Constants constants) {
        if (jobStatus.getJob().isPrefetch() == false) goto L33;
        if (jobStatus.getStandbyBucket() == 5) goto L33;
        long estDownloadBytes = jobStatus.getEstimatedNetworkDownloadBytes();
        long r5 = 0;
        if (estDownloadBytes > 0) goto L11;
        return false;
    L11:
        if (this.mService.isBatteryCharging() == false) goto L31;
        if (this.mService.isBatteryNotLow() == false) goto L31;
        NetworkCapabilities.Builder builder = copyCapabilities(jobStatus.getJob().getRequiredNetwork());
        builder.removeCapability(11);
        if (builder.build().satisfiedByNetworkCapabilities(capabilities) == false) goto L29;
        if (jobStatus.getFractionRunTime() <= constants.CONN_PREFETCH_RELAX_FRAC) goto L29;
        long opportunisticQuotaBytes = this.mNetPolicyManagerInternal.getSubscriptionOpportunisticQuota(network, 1);
        long estUploadBytes = jobStatus.getEstimatedNetworkUploadBytes();
        if (estUploadBytes == (-1)) goto L23;
        r5 = estUploadBytes;
    L23:
        long estimatedBytes = r5 + estDownloadBytes;
        if (opportunisticQuotaBytes >= estimatedBytes) goto L26;
        return false;
    L26:
        return true;
    L29:
        return false;
    L31:
        return false;
    L33:
        return false;
    }

    boolean isSatisfied(JobStatus jobStatus, Network network, NetworkCapabilities capabilities, JobSchedulerService.Constants constants) {
        if (network == null) goto L28;
        if (capabilities == null) goto L28;
        if (isUsable(capabilities) == true) goto L10;
        return false;
    L10:
        if (isInsane(jobStatus, network, capabilities, constants) == false) goto L13;
        return false;
    L13:
        if (isMeteredAllowed(jobStatus, capabilities) == true) goto L16;
        return false;
    L16:
        if (isCongestionDelayed(jobStatus, network, capabilities, constants) == false) goto L19;
        return false;
    L19:
        if (isStrongEnough(jobStatus, capabilities, constants) == true) goto L22;
        return false;
    L22:
        if (isStrictSatisfied(jobStatus, network, capabilities, constants) == false) goto L25;
        return true;
    L25:
        if (isRelaxedSatisfied(jobStatus, network, capabilities, constants) == false) goto L27;
        return true;
    L27:
        return false;
    L28:
        return false;
    }

    private boolean updateTransportAffinitySatisfaction(CachedNetworkMetadata cachedNetworkMetadata) {
        boolean satisfiesAffinities = satisfiesTransportAffinities(cachedNetworkMetadata.networkCapabilities);
        if (cachedNetworkMetadata.satisfiesTransportAffinities == satisfiesAffinities) goto L6;
        cachedNetworkMetadata.satisfiesTransportAffinities = satisfiesAffinities;
        return true;
    L6:
        return false;
    }

    private boolean satisfiesTransportAffinities(NetworkCapabilities capabilities) {
        if (this.mFlexibilityController.isEnabled() == true) goto L6;
        return true;
    L6:
        if (capabilities != null) goto L10;
        Slog.wtf(TAG, "Network constraint satisfied with null capabilities");
        return !this.mCcConfig.AVOID_UNDEFINED_TRANSPORT_AFFINITY;
    L10:
        if (sNetworkTransportAffinities.size() == 0) goto L12;
        int[] transports = capabilities.getTransportTypes();
        if (transports.length == 0) goto L16;
        int r3 = transports.length;
        int r5 = 0;
    L18:
        if (r5 >= r3) goto L30;
        int t = transports[r5];
        int affinity = sNetworkTransportAffinities.get(t, 0);
        if (DEBUG == false) goto L22;
        Slog.d(TAG, "satisfiesTransportAffinities transport=" + t + " aff=" + affinity);
    L22:
        switch(affinity) {
            case 0: goto L27;
            case 1: goto L29;
            case 2: goto L24;
            default: goto L29;
        };
    L27:
        if (this.mCcConfig.AVOID_UNDEFINED_TRANSPORT_AFFINITY == false) goto L29;
        return false;
    L24:
        return false;
    L29:
        r5 = r5 + 1;
        goto L18
    L30:
        return true;
    L16:
        return !this.mCcConfig.AVOID_UNDEFINED_TRANSPORT_AFFINITY;
    L12:
        return !this.mCcConfig.AVOID_UNDEFINED_TRANSPORT_AFFINITY;
    }

    private void maybeRegisterDefaultNetworkCallbackLocked(JobStatus jobStatus) {
        int sourceUid = jobStatus.getSourceUid();
        if (this.mCurrentDefaultNetworkCallbacks.contains(sourceUid) == false) goto L5;
        return;
    L5:
        UidStats uidStats = getUidStats(jobStatus.getSourceUid(), jobStatus.getSourcePackageName(), true);
        if (this.mSortedStats.contains(uidStats) == true) goto L9;
        this.mSortedStats.add(uidStats);
    L9:
        if (this.mCurrentDefaultNetworkCallbacks.size() < 125) goto L12;
        postAdjustCallbacks();
        return;
    L12:
        registerPendingUidCallbacksLocked();
    }

    private void registerPendingUidCallbacksLocked() {
        int numCallbacks = this.mCurrentDefaultNetworkCallbacks.size();
        int numPending = this.mSortedStats.size();
        if (numPending >= numCallbacks) goto L5;
        Slog.wtf(TAG, "There are more registered callbacks than sorted UIDs: " + numCallbacks + " vs " + numPending);
    L5:
        int i = numCallbacks;
    L6:
        if (i >= numPending) goto L13;
        if (i >= 125) goto L18;
        UidStats uidStats = this.mSortedStats.get(i);
        UidDefaultNetworkCallback callback = (UidDefaultNetworkCallback) this.mDefaultNetworkCallbackPool.acquire();
        if (callback != null) goto L12;
        callback = new UidDefaultNetworkCallback(this, null);
    L12:
        UidDefaultNetworkCallback.m4934$$Nest$msetUid(callback, uidStats.uid);
        this.mCurrentDefaultNetworkCallbacks.append(uidStats.uid, callback);
        this.mConnManager.registerDefaultNetworkCallbackForUid(uidStats.uid, callback, this.mHandler);
        i = i + 1;
        goto L6
    L18:
        return;
    }

    private void postAdjustCallbacks() {
        postAdjustCallbacks(0);
    }

    private void postAdjustCallbacks(long delayMs) {
        this.mHandler.sendEmptyMessageDelayed(0, delayMs);
    }

    private void maybeAdjustRegisteredCallbacksLocked() {
        this.mHandler.removeMessages(0);
        int count = this.mUidStats.size();
        if (count != this.mCurrentDefaultNetworkCallbacks.size()) goto L5;
        return;
    L5:
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if ((nowElapsed - this.mLastCallbackAdjustmentTimeElapsed) >= 1000) goto L9;
        postAdjustCallbacks(1000);
        return;
    L9:
        this.mLastCallbackAdjustmentTimeElapsed = nowElapsed;
        this.mSortedStats.clear();
        int u = 0;
    L11:
        if (u >= this.mUidStats.size()) goto L51;
        UidStats us = this.mUidStats.valueAt(u);
        ArraySet<JobStatus> jobs = this.mTrackedJobs.get(us.uid);
        if (jobs != null) goto L15;
    L49:
        unregisterDefaultNetworkCallbackLocked(us.uid, nowElapsed);
    L50:
        u = u + 1;
        goto L11
    L15:
        if (jobs.size() == 0) goto L49;
        if ((us.lastUpdatedElapsed + 30000) >= nowElapsed) goto L48;
        us.earliestEnqueueTime = Long.MAX_VALUE;
        us.earliestEJEnqueueTime = Long.MAX_VALUE;
        us.earliestUIJEnqueueTime = Long.MAX_VALUE;
        us.numReadyWithConnectivity = 0;
        us.numRequestedNetworkAvailable = 0;
        us.numRegular = 0;
        us.numEJs = 0;
        us.numUIJs = 0;
        int j = 0;
    L21:
        if (j >= jobs.size()) goto L47;
        JobStatus job = jobs.valueAt(j);
        if (wouldBeReadyWithConstraintLocked(job, 268435456) == false) goto L37;
        us.numReadyWithConnectivity++;
        if (isNetworkAvailable(job) == false) goto L27;
        us.numRequestedNetworkAvailable++;
    L27:
        us.earliestEnqueueTime = Math.min(us.earliestEnqueueTime, job.enqueueTime);
        if (job.shouldTreatAsExpeditedJob() == false) goto L30;
    L35:
        us.earliestEJEnqueueTime = Math.min(us.earliestEJEnqueueTime, job.enqueueTime);
        goto L37
    L30:
        if (job.startedAsExpeditedJob == true) goto L35;
        if (job.shouldTreatAsUserInitiatedJob() == false) goto L37;
        us.earliestUIJEnqueueTime = Math.min(us.earliestUIJEnqueueTime, job.enqueueTime);
    L37:
        if (job.shouldTreatAsExpeditedJob() == false) goto L39;
    L45:
        us.numEJs++;
    L46:
        j = j + 1;
        goto L21
    L39:
        if (job.startedAsExpeditedJob == true) goto L45;
        if (job.shouldTreatAsUserInitiatedJob() == false) goto L44;
        us.numUIJs++;
        goto L46
    L44:
        us.numRegular++;
        goto L46
    L47:
        us.lastUpdatedElapsed = nowElapsed;
    L48:
        this.mSortedStats.add(us);
        goto L50
    L51:
        this.mSortedStats.sort(this.mUidStatsComparator);
        ArraySet<JobStatus> changedJobs = new ArraySet();
        int i = this.mSortedStats.size() - 1;
    L52:
        if (i < 0) goto L65;
        UidStats us2 = this.mSortedStats.get(i);
        if (i < 125) goto L59;
        if (unregisterDefaultNetworkCallbackLocked(us2.uid, nowElapsed) == false) goto L64;
        changedJobs.addAll(this.mTrackedJobs.get(us2.uid));
    L64:
        i = i - 1;
        goto L52
    L59:
        if (this.mCurrentDefaultNetworkCallbacks.get(us2.uid) != null) goto L64;
        UidDefaultNetworkCallback defaultNetworkCallback = (UidDefaultNetworkCallback) this.mDefaultNetworkCallbackPool.acquire();
        if (defaultNetworkCallback != null) goto L63;
        defaultNetworkCallback = new UidDefaultNetworkCallback(this, null);
    L63:
        UidDefaultNetworkCallback.m4934$$Nest$msetUid(defaultNetworkCallback, us2.uid);
        this.mCurrentDefaultNetworkCallbacks.append(us2.uid, defaultNetworkCallback);
        this.mConnManager.registerDefaultNetworkCallbackForUid(us2.uid, defaultNetworkCallback, this.mHandler);
        goto L64
    L65:
        int i2 = changedJobs.size();
        if (i2 <= 0) goto L81;
        this.mStateChangedListener.onControllerStateChanged(changedJobs);
        return;
    }

    private boolean unregisterDefaultNetworkCallbackLocked(int uid, long nowElapsed) {
        UidDefaultNetworkCallback defaultNetworkCallback = this.mCurrentDefaultNetworkCallbacks.get(uid);
        if (defaultNetworkCallback != null) goto L6;
        return false;
    L6:
        this.mCurrentDefaultNetworkCallbacks.remove(uid);
        this.mConnManager.unregisterNetworkCallback(defaultNetworkCallback);
        this.mDefaultNetworkCallbackPool.release(defaultNetworkCallback);
        UidDefaultNetworkCallback.m4932$$Nest$mclear(defaultNetworkCallback);
        boolean changed = false;
        ArraySet<JobStatus> jobs = this.mTrackedJobs.get(uid);
        if (jobs == null) goto L13;
        int j = jobs.size() - 1;
    L9:
        if (j < 0) goto L13;
        long nowElapsed2 = nowElapsed;
        changed = changed | updateConstraintsSatisfied(jobs.valueAt(j), nowElapsed2, null, null);
        j = j - 1;
        nowElapsed = nowElapsed2;
    L13:
        return changed;
    }

    public NetworkCapabilities getNetworkCapabilities(Network network) {
        CachedNetworkMetadata metadata = getNetworkMetadata(network);
        if (metadata != null) goto L6;
        return null;
    L6:
        return metadata.networkCapabilities;
    }

    private CachedNetworkMetadata getNetworkMetadata(Network network) {
        if (network != null) goto L5;
        return null;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        CachedNetworkMetadata r1 = this.mAvailableNetworks.get(network);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    private Network getNetworkLocked(JobStatus jobStatus) {
        UidDefaultNetworkCallback defaultNetworkCallback = this.mCurrentDefaultNetworkCallbacks.get(jobStatus.getSourceUid());
        if (defaultNetworkCallback != null) goto L5;
        return null;
    L5:
        UidStats uidStats = this.mUidStats.get(jobStatus.getSourceUid());
        if (uidStats.baseBias >= 30) goto L30;
        if ((jobStatus.getFlags() & 1) != 0) goto L30;
        if (jobStatus.shouldTreatAsUserInitiatedJob() == false) goto L17;
        if (DEBUG == false) goto L15;
        Slog.d(TAG, "Using UI bypass for " + jobStatus.getSourceUid());
    L15:
        int unbypassableBlockedReasons = -196680;
    L34:
        if ((UidDefaultNetworkCallback.m4929$$Nest$fgetmBlockedReasons(defaultNetworkCallback) & unbypassableBlockedReasons) == 0) goto L37;
        return null;
    L37:
        return UidDefaultNetworkCallback.m4930$$Nest$fgetmDefaultNetwork(defaultNetworkCallback);
    L17:
        if (jobStatus.shouldTreatAsExpeditedJob() == true) goto L26;
        if (jobStatus.startedAsExpeditedJob == true) goto L26;
        if (DEBUG == false) goto L24;
        Slog.d(TAG, "Using BG bypass for " + jobStatus.getSourceUid());
    L24:
        unbypassableBlockedReasons = UNBYPASSABLE_BG_BLOCKED_REASONS;
    L26:
        if (DEBUG == false) goto L28;
        Slog.d(TAG, "Using EJ bypass for " + jobStatus.getSourceUid());
    L28:
        unbypassableBlockedReasons = UNBYPASSABLE_EJ_BLOCKED_REASONS;
    L30:
        if (DEBUG == false) goto L32;
        Slog.d(TAG, "Using FG bypass for " + jobStatus.getSourceUid());
    L32:
        unbypassableBlockedReasons = -196680;
        goto L34
    }

    private boolean updateConstraintsSatisfied(JobStatus jobStatus) {
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        UidDefaultNetworkCallback defaultNetworkCallback = this.mCurrentDefaultNetworkCallbacks.get(jobStatus.getSourceUid());
        if (defaultNetworkCallback != null) goto L6;
        maybeRegisterDefaultNetworkCallbackLocked(jobStatus);
        return updateConstraintsSatisfied(jobStatus, nowElapsed, null, null);
    L6:
        Network network = getNetworkLocked(jobStatus);
        CachedNetworkMetadata networkMetadata = getNetworkMetadata(network);
        return updateConstraintsSatisfied(jobStatus, nowElapsed, network, networkMetadata);
    }

    private boolean updateConstraintsSatisfied(JobStatus jobStatus, long nowElapsed, Network network, CachedNetworkMetadata networkMetadata) {
        if (networkMetadata != null) goto L4;
        NetworkCapabilities capabilities = null;
    L5:
        boolean satisfied = isSatisfied(jobStatus, network, capabilities, this.mConstants);
        boolean r2 = false;
        if (satisfied == false) goto L8;
    L17:
        boolean changed = jobStatus.setConnectivityConstraintSatisfied(nowElapsed, satisfied);
        if (satisfied == false) goto L23;
        if (networkMetadata == null) goto L23;
        if (networkMetadata.satisfiesTransportAffinities == false) goto L23;
        r2 = true;
    L23:
        jobStatus.setTransportAffinitiesSatisfied(r2);
        if (jobStatus.canApplyTransportAffinities() == false) goto L26;
        jobStatus.setFlexibilityConstraintSatisfied(nowElapsed, this.mFlexibilityController.isFlexibilitySatisfiedLocked(jobStatus));
    L26:
        if (changed == true) goto L33;
        if (satisfied == false) goto L33;
        if (jobStatus.network == null) goto L33;
        if (this.mService.isCurrentlyRunningLocked(jobStatus) == false) goto L33;
        this.mStateChangedListener.onNetworkChanged(jobStatus, network);
    L33:
        jobStatus.network = network;
        if (DEBUG == false) goto L40;
        StringBuilder r3 = new StringBuilder();
        r3.append("Connectivity ");
        if (changed == false) goto L38;
        String r5 = "CHANGED";
    L39:
        r3.append(r5);
        r3.append(" for ");
        r3.append(jobStatus);
        r3.append(": usable=");
        r3.append(isUsable(capabilities));
        r3.append(" satisfied=");
        r3.append(satisfied);
        Slog.i(TAG, r3.toString());
        goto L40
    L38:
        r5 = "unchanged";
    L40:
        return changed;
    L8:
        if (jobStatus.network == null) goto L17;
        if (this.mService.isCurrentlyRunningLocked(jobStatus) == false) goto L17;
        if (isSatisfied(jobStatus, jobStatus.network, getNetworkCapabilities(jobStatus.network), this.mConstants) == false) goto L17;
        if (DEBUG == false) goto L16;
        Slog.i(TAG, "Not reassigning network from " + jobStatus.network + " to " + network + " for running job " + jobStatus);
    L16:
        return false;
    L4:
        capabilities = networkMetadata.networkCapabilities;
        goto L5
    }

    private void updateAllTrackedJobsLocked(boolean allowThrottle) {
        if (allowThrottle == false) goto L8;
        long throttleTimeLeftMs = (this.mLastAllJobUpdateTimeElapsed + this.mConstants.CONN_UPDATE_ALL_JOBS_MIN_INTERVAL_MS) - JobSchedulerService.sElapsedRealtimeClock.millis();
        if (throttleTimeLeftMs <= 0) goto L8;
        Message msg = this.mHandler.obtainMessage(1, 1, 0);
        this.mHandler.sendMessageDelayed(msg, throttleTimeLeftMs);
        return;
    L8:
        this.mHandler.removeMessages(1);
        updateTrackedJobsLocked(-1, null);
        this.mLastAllJobUpdateTimeElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
    }

    private void updateTrackedJobsLocked(int filterUid, Network filterNetwork) {
        if (filterUid != (-1)) goto L12;
        ArraySet<JobStatus> changedJobs = new ArraySet();
        int i = this.mTrackedJobs.size() - 1;
    L5:
        if (i < 0) goto L15;
        if (updateTrackedJobsLocked(this.mTrackedJobs.valueAt(i), filterNetwork) == false) goto L9;
        changedJobs.addAll(this.mTrackedJobs.valueAt(i));
    L9:
        i = i - 1;
    L15:
        if (changedJobs != null) goto L17;
        return;
    L17:
        if (changedJobs.size() <= 0) goto L24;
        this.mStateChangedListener.onControllerStateChanged(changedJobs);
        return;
    L24:
        return;
    L12:
        if (updateTrackedJobsLocked(this.mTrackedJobs.get(filterUid), filterNetwork) == false) goto L14;
        changedJobs = this.mTrackedJobs.get(filterUid);
        goto L15
    L14:
        changedJobs = null;
        goto L15
    }

    private boolean updateTrackedJobsLocked(ArraySet<JobStatus> jobs, Network filterNetwork) {
        if (jobs != null) goto L5;
    L27:
        return false;
    L5:
        if (jobs.size() == 0) goto L27;
        UidDefaultNetworkCallback defaultNetworkCallback = this.mCurrentDefaultNetworkCallbacks.get(jobs.valueAt(0).getSourceUid());
        if (defaultNetworkCallback != null) goto L10;
        return false;
    L10:
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        boolean changed = false;
        int i = jobs.size() - 1;
    L11:
        if (i < 0) goto L26;
        JobStatus js = jobs.valueAt(i);
        Network net = getNetworkLocked(js);
        if (filterNetwork != null) goto L15;
    L18:
        boolean r3 = true;
    L19:
        boolean match = r3;
        if (match == false) goto L22;
    L23:
        changed = changed | updateConstraintsSatisfied(js, nowElapsed, net, getNetworkMetadata(net));
    L24:
        i = i - 1;
        goto L11
    L22:
        if (Objects.equals(js.network, net) == true) goto L24;
    L15:
        if (Objects.equals(filterNetwork, net) == true) goto L18;
        r3 = false;
        goto L19
    L26:
        return changed;
    }

    public boolean isNetworkInStateForJobRunLocked(JobStatus jobStatus) {
        if (jobStatus.network != null) goto L7;
        return false;
    L7:
        if (jobStatus.shouldTreatAsExpeditedJob() == false) goto L9;
        return true;
    L9:
        if (jobStatus.shouldTreatAsUserInitiatedJob() == false) goto L11;
        return true;
    L11:
        if (this.mService.getUidProcState(jobStatus.getSourceUid()) > 5) goto L14;
        return true;
    L14:
        return isNetworkInStateForJobRunLocked(jobStatus.network);
    }

    boolean isNetworkInStateForJobRunLocked(Network network) {
        return true;
    }

    @Override // android.net.ConnectivityManager.OnNetworkActiveListener
    public void onNetworkActive() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSystemDefaultNetwork != null) goto L11;
        Slog.wtf(TAG, "System default network is unknown but active");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        CachedNetworkMetadata cachedNetworkMetadata = this.mAvailableNetworks.get(this.mSystemDefaultNetwork);     // Catch: Throwable -> L9
        if (cachedNetworkMetadata != null) goto L16;
        Slog.wtf(TAG, "System default network capabilities are unknown but active");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        long r2 = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L9
        cachedNetworkMetadata.defaultNetworkActivationLastCheckTimeElapsed = r2;     // Catch: Throwable -> L9
        cachedNetworkMetadata.defaultNetworkActivationLastConfirmedTimeElapsed = r2;     // Catch: Throwable -> L9
        this.mHandler.sendEmptyMessage(4);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    CcConfig getCcConfig() {
        return this.mCcConfig;
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpConstants(IndentingPrintWriter pw) {
        CcConfig.m4928$$Nest$mdump(this.mCcConfig, pw);
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        pw.println("Aconfig flags:");
        pw.increaseIndent();
        pw.print(Flags.FLAG_RELAX_PREFETCH_CONNECTIVITY_CONSTRAINT_ONLY_ON_CHARGER, true);
        pw.println();
        pw.decreaseIndent();
        pw.println();
        if (this.mRequestedWhitelistJobs.size() <= 0) goto L10;
        pw.print("Requested standby exceptions:");
        int i = 0;
    L6:
        if (i >= this.mRequestedWhitelistJobs.size()) goto L8;
        pw.print(" ");
        pw.print(this.mRequestedWhitelistJobs.keyAt(i));
        pw.print(" (");
        pw.print(this.mRequestedWhitelistJobs.valueAt(i).size());
        pw.print(" jobs)");
        i = i + 1;
        goto L6
    L8:
        pw.println();
    L10:
        if (this.mAvailableNetworks.size() <= 0) goto L16;
        pw.println("Available networks:");
        pw.increaseIndent();
        int i2 = 0;
    L13:
        if (i2 >= this.mAvailableNetworks.size()) goto L15;
        pw.print(this.mAvailableNetworks.keyAt(i2));
        pw.print(": ");
        pw.println(this.mAvailableNetworks.valueAt(i2));
        i2 = i2 + 1;
        goto L13
    L15:
        pw.decreaseIndent();
    L17:
        pw.println();
        if (this.mSignalStrengths.size() <= 0) goto L24;
        pw.println("Subscription ID signal strengths:");
        pw.increaseIndent();
        int i3 = 0;
    L21:
        if (i3 >= this.mSignalStrengths.size()) goto L23;
        pw.print(this.mSignalStrengths.keyAt(i3));
        pw.print(": ");
        pw.println(this.mSignalStrengths.valueAt(i3).signalStrength);
        i3 = i3 + 1;
        goto L21
    L23:
        pw.decreaseIndent();
    L25:
        pw.println();
        if (this.mBackgroundMeteredAllowed.size() <= 0) goto L28;
        pw.print("Background metered allowed: ");
        pw.println(this.mBackgroundMeteredAllowed);
        pw.println();
    L28:
        pw.println("Current default network callbacks:");
        pw.increaseIndent();
        int i4 = 0;
    L30:
        if (i4 >= this.mCurrentDefaultNetworkCallbacks.size()) goto L32;
        UidDefaultNetworkCallback.m4933$$Nest$mdumpLocked(this.mCurrentDefaultNetworkCallbacks.valueAt(i4), pw);
        i4 = i4 + 1;
        goto L30
    L32:
        pw.decreaseIndent();
        pw.println();
        pw.println("UID Pecking Order:");
        pw.increaseIndent();
        int i5 = 0;
    L34:
        if (i5 >= this.mSortedStats.size()) goto L36;
        pw.print(i5);
        pw.print(": ");
        UidStats.m4935$$Nest$mdumpLocked(this.mSortedStats.get(i5), pw, nowElapsed);
        i5 = i5 + 1;
        goto L34
    L36:
        pw.decreaseIndent();
        pw.println();
        int i6 = 0;
    L38:
        if (i6 >= this.mTrackedJobs.size()) goto L49;
        ArraySet<JobStatus> jobs = this.mTrackedJobs.valueAt(i6);
        int j = 0;
    L41:
        if (j >= jobs.size()) goto L47;
        JobStatus js = jobs.valueAt(j);
        if (predicate.test(js) == false) goto L46;
        pw.print("#");
        js.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, js.getSourceUid());
        pw.print(": ");
        pw.print(js.getJob().getRequiredNetwork());
        pw.println();
    L46:
        j = j + 1;
        goto L41
    L47:
        i6 = i6 + 1;
        goto L38
    L49:
        return;
    L24:
        pw.println("No cached signal strengths");
        goto L25
    L16:
        pw.println("No available networks");
        goto L17
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
        long token = proto.start(fieldId);
        long mToken = proto.start(1146756268035L);
        int i = 0;
    L4:
        if (i >= this.mRequestedWhitelistJobs.size()) goto L6;
        proto.write(2220498092035L, this.mRequestedWhitelistJobs.keyAt(i));
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= this.mTrackedJobs.size()) goto L18;
        ArraySet<JobStatus> jobs = this.mTrackedJobs.valueAt(i2);
        int j = 0;
    L11:
        if (j >= jobs.size()) goto L17;
        JobStatus js = jobs.valueAt(j);
        if (predicate.test(js) == false) goto L16;
        long jsToken = proto.start(2246267895810L);
        js.writeToShortProto(proto, 1146756268033L);
        proto.write(1120986464258L, js.getSourceUid());
        proto.end(jsToken);
    L16:
        j = j + 1;
        goto L11
    L17:
        i2 = i2 + 1;
        goto L8
    L18:
        proto.end(mToken);
        proto.end(token);
    }
}
