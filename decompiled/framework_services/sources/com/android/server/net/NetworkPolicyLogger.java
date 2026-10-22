package com.android.server.net;

import android.app.ActivityManager;
import android.net.NetworkPolicyManager;
import android.os.PowerExemptionManager;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.RingBuffer;
import com.android.server.am.ProcessList;
import com.android.server.power.LowPowerStandbyController;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkPolicyLogger {
    private static final int EVENT_APP_IDLE_STATE_CHANGED = 8;
    private static final int EVENT_APP_IDLE_WL_CHANGED = 14;
    private static final int EVENT_DEVICE_IDLE_MODE_ENABLED = 7;
    private static final int EVENT_FIREWALL_CHAIN_ENABLED = 12;
    private static final int EVENT_INTERFACES_CHANGED = 18;
    private static final int EVENT_METEREDNESS_CHANGED = 4;
    private static final int EVENT_METERED_ALLOWLIST_CHANGED = 15;
    private static final int EVENT_METERED_DENYLIST_CHANGED = 16;
    private static final int EVENT_NETWORK_BLOCKED = 1;
    private static final int EVENT_PAROLE_STATE_CHANGED = 9;
    private static final int EVENT_POLICIES_CHANGED = 3;
    private static final int EVENT_RESTRICT_BG_CHANGED = 6;
    private static final int EVENT_ROAMING_CHANGED = 17;
    private static final int EVENT_TEMP_POWER_SAVE_WL_CHANGED = 10;
    private static final int EVENT_TYPE_GENERIC = 0;
    private static final int EVENT_UID_FIREWALL_RULE_CHANGED = 11;
    private static final int EVENT_UID_STATE_CHANGED = 2;
    private static final int EVENT_UPDATE_METERED_RESTRICTED_PKGS = 13;
    private static final int EVENT_USER_STATE_REMOVED = 5;
    static final boolean LOGD = false;
    static final boolean LOGV = false;
    private static final int MAX_LOG_SIZE = 0;
    private static final int MAX_NETWORK_BLOCKED_LOG_SIZE = 0;
    static final String TAG = "NetworkPolicy";
    private int mDebugUid;
    private final LogBuffer mEventsBuffer;
    private final Object mLock;
    private final LogBuffer mNetworkBlockedBuffer;
    private final LogBuffer mUidStateChangeBuffer;

    private static final class Data {
        public boolean bfield1;
        public boolean bfield2;
        public int ifield1;
        public int ifield2;
        public int ifield3;
        public int ifield4;
        public long lfield1;
        public String sfield1;
        public long timeStamp;
        public int type;

        /* synthetic */ Data(NetworkPolicyLoggerIA r1) {
            this();
        }

        private Data() {
        }

        public void reset() {
            this.sfield1 = null;
        }
    }

    private static final class LogBuffer extends RingBuffer<Data> {
        private static final Date sDate = null;
        private static final SimpleDateFormat sFormatter = null;

        /* JADX INFO: renamed from: $r8$lambda$-TUy9RKzfUlNRcVYDQQgCGgal-o, reason: not valid java name */
        public static /* synthetic */ Data[] m5972$r8$lambda$TUy9RKzfUlNRcVYDQQgCGgalo(int r0) {
            return lambda$new$0(r0);
        }

        public static /* synthetic */ Data $r8$lambda$kDNlKKkLZ8vfiKJuYgxljbBLzHE() {
            return new Data(null);
        }

        static {
            sFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS");
            sDate = new Date();
        }

        public LogBuffer(int capacity) {
            super(new NetworkPolicyLogger$LogBuffer$$ExternalSyntheticLambda0(), new NetworkPolicyLogger$LogBuffer$$ExternalSyntheticLambda1(), capacity);
        }

        private static /* synthetic */ Data[] lambda$new$0(int x$0) {
            return new Data[x$0];
        }

        public void uidStateChanged(int uid, int procState, long procStateSeq, int capability) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 2;
            data.ifield1 = uid;
            data.ifield2 = procState;
            data.ifield3 = capability;
            data.lfield1 = procStateSeq;
            data.timeStamp = System.currentTimeMillis();
        }

        public void event(String msg) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 0;
            data.sfield1 = msg;
            data.timeStamp = System.currentTimeMillis();
        }

        public void networkBlocked(int uid, int blockedReasons, int allowedReasons, int effectiveBlockedReasons) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 1;
            data.ifield1 = uid;
            data.ifield2 = blockedReasons;
            data.ifield3 = allowedReasons;
            data.ifield4 = effectiveBlockedReasons;
            data.timeStamp = System.currentTimeMillis();
        }

        public void uidPolicyChanged(int uid, int oldPolicy, int newPolicy) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 3;
            data.ifield1 = uid;
            data.ifield2 = oldPolicy;
            data.ifield3 = newPolicy;
            data.timeStamp = System.currentTimeMillis();
        }

        public void meterednessChanged(int netId, boolean newMetered) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 4;
            data.ifield1 = netId;
            data.bfield1 = newMetered;
            data.timeStamp = System.currentTimeMillis();
        }

        public void userRemoved(int userId) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 5;
            data.ifield1 = userId;
            data.timeStamp = System.currentTimeMillis();
        }

        public void restrictBackgroundChanged(boolean oldValue, boolean newValue) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 6;
            data.bfield1 = oldValue;
            data.bfield2 = newValue;
            data.timeStamp = System.currentTimeMillis();
        }

        public void deviceIdleModeEnabled(boolean enabled) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 7;
            data.bfield1 = enabled;
            data.timeStamp = System.currentTimeMillis();
        }

        public void appIdleStateChanged(int uid, boolean idle) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 8;
            data.ifield1 = uid;
            data.bfield1 = idle;
            data.timeStamp = System.currentTimeMillis();
        }

        public void appIdleWlChanged(int uid, boolean isAllowlisted) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 14;
            data.ifield1 = uid;
            data.bfield1 = isAllowlisted;
            data.timeStamp = System.currentTimeMillis();
        }

        public void paroleStateChanged(boolean paroleOn) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 9;
            data.bfield1 = paroleOn;
            data.timeStamp = System.currentTimeMillis();
        }

        public void tempPowerSaveWlChanged(int appId, boolean added, int reasonCode, String reason) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 10;
            data.ifield1 = appId;
            data.ifield2 = reasonCode;
            data.bfield1 = added;
            data.sfield1 = reason;
            data.timeStamp = System.currentTimeMillis();
        }

        public void uidFirewallRuleChanged(int chain, int uid, int rule) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 11;
            data.ifield1 = chain;
            data.ifield2 = uid;
            data.ifield3 = rule;
            data.timeStamp = System.currentTimeMillis();
        }

        public void firewallChainEnabled(int chain, boolean enabled) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 12;
            data.ifield1 = chain;
            data.bfield1 = enabled;
            data.timeStamp = System.currentTimeMillis();
        }

        public void meteredAllowlistChanged(int uid, boolean added) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 15;
            data.ifield1 = uid;
            data.bfield1 = added;
            data.timeStamp = System.currentTimeMillis();
        }

        public void meteredDenylistChanged(int uid, boolean added) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 16;
            data.ifield1 = uid;
            data.bfield1 = added;
            data.timeStamp = System.currentTimeMillis();
        }

        public void roamingChanged(int netId, boolean newRoaming) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 17;
            data.ifield1 = netId;
            data.bfield1 = newRoaming;
            data.timeStamp = System.currentTimeMillis();
        }

        public void interfacesChanged(int netId, String newIfaces) {
            Data data = (Data) getNextSlot();
            if (data != null) goto L5;
            return;
        L5:
            data.reset();
            data.type = 18;
            data.ifield1 = netId;
            data.sfield1 = newIfaces;
            data.timeStamp = System.currentTimeMillis();
        }

        public void reverseDump(IndentingPrintWriter pw) {
            Data[] allData = (Data[]) toArray();
            int i = allData.length - 1;
        L3:
            if (i < 0) goto L10;
            if (allData[i] != null) goto L7;
            pw.println("NULL");
        L8:
            i = i - 1;
            goto L3
        L7:
            pw.print(formatDate(allData[i].timeStamp));
            pw.print(" - ");
            pw.println(getContent(allData[i]));
            goto L8
        }

        public String getContent(Data data) {
            switch(data.type) {
                case 0: goto L41;
                case 1: goto L39;
                case 2: goto L37;
                case 3: goto L35;
                case 4: goto L33;
                case 5: goto L31;
                case 6: goto L29;
                case 7: goto L27;
                case 8: goto L25;
                case 9: goto L23;
                case 10: goto L21;
                case 11: goto L19;
                case 12: goto L17;
                case 13: goto L5;
                case 14: goto L15;
                case 15: goto L13;
                case 16: goto L11;
                case 17: goto L9;
                case 18: goto L7;
                default: goto L5;
            };
        L5:
            return String.valueOf(data.type);
        L7:
            return NetworkPolicyLogger.m5961$$Nest$smgetInterfacesChangedLog(data.ifield1, data.sfield1);
        L9:
            return NetworkPolicyLogger.m5968$$Nest$smgetRoamingChangedLog(data.ifield1, data.bfield1);
        L11:
            return NetworkPolicyLogger.m5963$$Nest$smgetMeteredDenylistChangedLog(data.ifield1, data.bfield1);
        L13:
            return NetworkPolicyLogger.m5962$$Nest$smgetMeteredAllowlistChangedLog(data.ifield1, data.bfield1);
        L15:
            return NetworkPolicyLogger.m5958$$Nest$smgetAppIdleWlChangedLog(data.ifield1, data.bfield1);
        L17:
            return NetworkPolicyLogger.m5960$$Nest$smgetFirewallChainEnabledLog(data.ifield1, data.bfield1);
        L19:
            return NetworkPolicyLogger.m5970$$Nest$smgetUidFirewallRuleChangedLog(data.ifield1, data.ifield2, data.ifield3);
        L21:
            return NetworkPolicyLogger.m5969$$Nest$smgetTempPowerSaveWlChangedLog(data.ifield1, data.bfield1, data.ifield2, data.sfield1);
        L23:
            return NetworkPolicyLogger.m5965$$Nest$smgetParoleStateChanged(data.bfield1);
        L25:
            return NetworkPolicyLogger.m5957$$Nest$smgetAppIdleChangedLog(data.ifield1, data.bfield1);
        L27:
            return NetworkPolicyLogger.m5959$$Nest$smgetDeviceIdleModeEnabled(data.bfield1);
        L29:
            return NetworkPolicyLogger.m5967$$Nest$smgetRestrictBackgroundChangedLog(data.bfield1, data.bfield2);
        L31:
            return NetworkPolicyLogger.m5971$$Nest$smgetUserRemovedLog(data.ifield1);
        L33:
            return NetworkPolicyLogger.m5964$$Nest$smgetMeterednessChangedLog(data.ifield1, data.bfield1);
        L35:
            return NetworkPolicyLogger.m5966$$Nest$smgetPolicyChangedLog(data.ifield1, data.ifield2, data.ifield3);
        L37:
            return data.ifield1 + ":" + ProcessList.makeProcStateString(data.ifield2) + ":" + ActivityManager.getCapabilitiesSummary(data.ifield3) + ":" + data.lfield1;
        L39:
            return data.ifield1 + "-" + NetworkPolicyManagerService.UidBlockedState.toString(data.ifield2, data.ifield3, data.ifield4);
        L41:
            return data.sfield1;
        }

        private String formatDate(long millis) {
            sDate.setTime(millis);
            return sFormatter.format(sDate);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smgetAppIdleChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5957$$Nest$smgetAppIdleChangedLog(int r0, boolean r1) {
        return getAppIdleChangedLog(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetAppIdleWlChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5958$$Nest$smgetAppIdleWlChangedLog(int r0, boolean r1) {
        return getAppIdleWlChangedLog(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetDeviceIdleModeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5959$$Nest$smgetDeviceIdleModeEnabled(boolean r0) {
        return getDeviceIdleModeEnabled(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetFirewallChainEnabledLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5960$$Nest$smgetFirewallChainEnabledLog(int r0, boolean r1) {
        return getFirewallChainEnabledLog(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetInterfacesChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5961$$Nest$smgetInterfacesChangedLog(int r0, String r1) {
        return getInterfacesChangedLog(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetMeteredAllowlistChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5962$$Nest$smgetMeteredAllowlistChangedLog(int r0, boolean r1) {
        return getMeteredAllowlistChangedLog(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetMeteredDenylistChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5963$$Nest$smgetMeteredDenylistChangedLog(int r0, boolean r1) {
        return getMeteredDenylistChangedLog(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetMeterednessChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5964$$Nest$smgetMeterednessChangedLog(int r0, boolean r1) {
        return getMeterednessChangedLog(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetParoleStateChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5965$$Nest$smgetParoleStateChanged(boolean r0) {
        return getParoleStateChanged(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetPolicyChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5966$$Nest$smgetPolicyChangedLog(int r0, int r1, int r2) {
        return getPolicyChangedLog(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetRestrictBackgroundChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5967$$Nest$smgetRestrictBackgroundChangedLog(boolean r0, boolean r1) {
        return getRestrictBackgroundChangedLog(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetRoamingChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5968$$Nest$smgetRoamingChangedLog(int r0, boolean r1) {
        return getRoamingChangedLog(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetTempPowerSaveWlChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5969$$Nest$smgetTempPowerSaveWlChangedLog(int r0, boolean r1, int r2, String r3) {
        return getTempPowerSaveWlChangedLog(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetUidFirewallRuleChangedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5970$$Nest$smgetUidFirewallRuleChangedLog(int r0, int r1, int r2) {
        return getUidFirewallRuleChangedLog(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetUserRemovedLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5971$$Nest$smgetUserRemovedLog(int r0) {
        return getUserRemovedLog(r0);
    }

    public NetworkPolicyLogger() {
        this.mNetworkBlockedBuffer = new LogBuffer(MAX_NETWORK_BLOCKED_LOG_SIZE);
        this.mUidStateChangeBuffer = new LogBuffer(MAX_LOG_SIZE);
        this.mEventsBuffer = new LogBuffer(MAX_LOG_SIZE);
        this.mDebugUid = -1;
        this.mLock = new Object();
    }

    static {
        LOGD = Log.isLoggable(TAG, 3);
        LOGV = Log.isLoggable(TAG, 2);
        int r1 = 400;
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L5;
        int r0 = 100;
    L6:
        MAX_LOG_SIZE = r0;
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L9;
        r1 = 100;
    L9:
        MAX_NETWORK_BLOCKED_LOG_SIZE = r1;
        return;
    L5:
        r0 = 400;
        goto L6
    }

    void networkBlocked(int uid, NetworkPolicyManagerService.UidBlockedState uidBlockedState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (uid == this.mDebugUid) goto L11;
    L16:
        if (uidBlockedState != null) goto L18;
        this.mNetworkBlockedBuffer.networkBlocked(uid, 0, 0, 0);     // Catch: Throwable -> L9
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L18:
        this.mNetworkBlockedBuffer.networkBlocked(uid, uidBlockedState.blockedReasons, uidBlockedState.allowedReasons, uidBlockedState.effectiveBlockedReasons);     // Catch: Throwable -> L9
    L11:
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L9
        r3.append("Blocked state of ");     // Catch: Throwable -> L9
        r3.append(uid);     // Catch: Throwable -> L9
        r3.append(": ");     // Catch: Throwable -> L9
        if (uidBlockedState != null) goto L14;
        Object r4 = 0;     // Catch: Throwable -> L9
    L15:
        r3.append(r4);     // Catch: Throwable -> L9
        Slog.d(TAG, r3.toString());     // Catch: Throwable -> L9
        goto L16
    L14:
        r4 = uidBlockedState.toString();     // Catch: Throwable -> L9
        goto L15
    }

    void uidStateChanged(int uid, int procState, long procStateSeq, int capability) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L19:
        th = th;
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L17
        throw th;
    L5:
        if (LOGV == false) goto L25;
    L11:
        Slog.v(TAG, uid + " state changed to " + ProcessList.makeProcStateString(procState) + ",seq=" + procStateSeq + ",cap=" + ActivityManager.getCapabilitiesSummary(capability));     // Catch: Throwable -> L19
    L12:
        this.mUidStateChangeBuffer.uidStateChanged(uid, procState, procStateSeq, capability);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L25:
        if (uid != this.mDebugUid) goto L12;
    L9:
        th = th;
    L17:
        th = th;
        goto L21
    }

    void event(String msg) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (LOGV == false) goto L9;
        Slog.v(TAG, msg);     // Catch: Throwable -> L7
    L9:
        this.mEventsBuffer.event(msg);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void uidPolicyChanged(int uid, int oldPolicy, int newPolicy) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGV == true) goto L11;
        if (uid == this.mDebugUid) goto L11;
    L12:
        this.mEventsBuffer.uidPolicyChanged(uid, oldPolicy, newPolicy);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.v(TAG, getPolicyChangedLog(uid, oldPolicy, newPolicy));     // Catch: Throwable -> L9
        goto L12
    }

    void meterednessChanged(int netId, boolean newMetered) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (this.mDebugUid != (-1)) goto L11;
    L12:
        this.mEventsBuffer.meterednessChanged(netId, newMetered);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getMeterednessChangedLog(netId, newMetered));     // Catch: Throwable -> L9
        goto L12
    }

    void removingUserState(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (this.mDebugUid != (-1)) goto L11;
    L12:
        this.mEventsBuffer.userRemoved(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getUserRemovedLog(userId));     // Catch: Throwable -> L9
        goto L12
    }

    void restrictBackgroundChanged(boolean oldValue, boolean newValue) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (this.mDebugUid != (-1)) goto L11;
    L12:
        this.mEventsBuffer.restrictBackgroundChanged(oldValue, newValue);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getRestrictBackgroundChangedLog(oldValue, newValue));     // Catch: Throwable -> L9
        goto L12
    }

    void deviceIdleModeEnabled(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (this.mDebugUid != (-1)) goto L11;
    L12:
        this.mEventsBuffer.deviceIdleModeEnabled(enabled);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getDeviceIdleModeEnabled(enabled));     // Catch: Throwable -> L9
        goto L12
    }

    void appIdleStateChanged(int uid, boolean idle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (uid == this.mDebugUid) goto L11;
    L12:
        this.mEventsBuffer.appIdleStateChanged(uid, idle);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getAppIdleChangedLog(uid, idle));     // Catch: Throwable -> L9
        goto L12
    }

    void appIdleWlChanged(int uid, boolean isWhitelisted) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (uid == this.mDebugUid) goto L11;
    L12:
        this.mEventsBuffer.appIdleWlChanged(uid, isWhitelisted);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getAppIdleWlChangedLog(uid, isWhitelisted));     // Catch: Throwable -> L9
        goto L12
    }

    void paroleStateChanged(boolean paroleOn) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (this.mDebugUid != (-1)) goto L11;
    L12:
        this.mEventsBuffer.paroleStateChanged(paroleOn);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getParoleStateChanged(paroleOn));     // Catch: Throwable -> L9
        goto L12
    }

    void tempPowerSaveWlChanged(int appId, boolean added, int reasonCode, String reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGV == true) goto L11;
        if (appId == UserHandle.getAppId(this.mDebugUid)) goto L11;
    L12:
        this.mEventsBuffer.tempPowerSaveWlChanged(appId, added, reasonCode, reason);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.v(TAG, getTempPowerSaveWlChangedLog(appId, added, reasonCode, reason));     // Catch: Throwable -> L9
        goto L12
    }

    void uidFirewallRuleChanged(int chain, int uid, int rule) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGV == true) goto L11;
        if (uid == this.mDebugUid) goto L11;
    L12:
        this.mEventsBuffer.uidFirewallRuleChanged(chain, uid, rule);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.v(TAG, getUidFirewallRuleChangedLog(chain, uid, rule));     // Catch: Throwable -> L9
        goto L12
    }

    void firewallChainEnabled(int chain, boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (this.mDebugUid != (-1)) goto L11;
    L12:
        this.mEventsBuffer.firewallChainEnabled(chain, enabled);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getFirewallChainEnabledLog(chain, enabled));     // Catch: Throwable -> L9
        goto L12
    }

    void firewallRulesChanged(int chain, int[] uids, int[] rules) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String log = "Firewall rules changed for " + getFirewallChainName(chain) + "; uids=" + Arrays.toString(uids) + "; rules=" + Arrays.toString(rules);     // Catch: Throwable -> L9
        if (LOGD == true) goto L11;
        if (this.mDebugUid != (-1)) goto L11;
    L12:
        this.mEventsBuffer.event(log);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, log);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    void meteredRestrictedPkgsChanged(Set<Integer> restrictedUids) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String log = "Metered restricted uids: " + restrictedUids;     // Catch: Throwable -> L9
        if (LOGD == true) goto L11;
        if (this.mDebugUid != (-1)) goto L11;
    L12:
        this.mEventsBuffer.event(log);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, log);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    void meteredAllowlistChanged(int uid, boolean added) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (this.mDebugUid == uid) goto L11;
    L12:
        this.mEventsBuffer.meteredAllowlistChanged(uid, added);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getMeteredAllowlistChangedLog(uid, added));     // Catch: Throwable -> L9
        goto L12
    }

    void meteredDenylistChanged(int uid, boolean added) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (this.mDebugUid == uid) goto L11;
    L12:
        this.mEventsBuffer.meteredDenylistChanged(uid, added);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getMeteredDenylistChangedLog(uid, added));     // Catch: Throwable -> L9
        goto L12
    }

    void roamingChanged(int netId, boolean newRoaming) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (this.mDebugUid != (-1)) goto L11;
    L12:
        this.mEventsBuffer.roamingChanged(netId, newRoaming);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getRoamingChangedLog(netId, newRoaming));     // Catch: Throwable -> L9
        goto L12
    }

    void interfacesChanged(int netId, ArraySet<String> newIfaces) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == true) goto L11;
        if (this.mDebugUid != (-1)) goto L11;
    L12:
        this.mEventsBuffer.interfacesChanged(netId, newIfaces.toString());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, getInterfacesChangedLog(netId, newIfaces.toString()));     // Catch: Throwable -> L9
        goto L12
    }

    void setDebugUid(int uid) {
        this.mDebugUid = uid;
    }

    void dumpLogs(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println();     // Catch: Throwable -> L7
        pw.println("mEventLogs (most recent first):");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        this.mEventsBuffer.reverseDump(pw);     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("mNetworkBlockedLogs (most recent first):");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        this.mNetworkBlockedBuffer.reverseDump(pw);     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("mUidStateChangeLogs (most recent first):");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        this.mUidStateChangeBuffer.reverseDump(pw);     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static String getPolicyChangedLog(int uid, int oldPolicy, int newPolicy) {
        return "Policy for " + uid + " changed from " + NetworkPolicyManager.uidPoliciesToString(oldPolicy) + " to " + NetworkPolicyManager.uidPoliciesToString(newPolicy);
    }

    private static String getMeterednessChangedLog(int netId, boolean newMetered) {
        return "Meteredness of netId=" + netId + " changed to " + newMetered;
    }

    private static String getUserRemovedLog(int userId) {
        return "Remove state for u" + userId;
    }

    private static String getRestrictBackgroundChangedLog(boolean oldValue, boolean newValue) {
        return "Changed restrictBackground: " + oldValue + "->" + newValue;
    }

    private static String getDeviceIdleModeEnabled(boolean enabled) {
        return "DeviceIdleMode enabled: " + enabled;
    }

    private static String getAppIdleChangedLog(int uid, boolean idle) {
        return "App idle state of uid " + uid + ": " + idle;
    }

    private static String getAppIdleWlChangedLog(int uid, boolean isAllowlisted) {
        return "App idle whitelist state of uid " + uid + ": " + isAllowlisted;
    }

    private static String getParoleStateChanged(boolean paroleOn) {
        return "Parole state: " + paroleOn;
    }

    private static String getTempPowerSaveWlChangedLog(int appId, boolean added, int reasonCode, String reason) {
        return "temp-power-save whitelist for " + appId + " changed to: " + added + "; reason=" + PowerExemptionManager.reasonCodeToString(reasonCode) + " <" + reason + ">";
    }

    private static String getUidFirewallRuleChangedLog(int chain, int uid, int rule) {
        return String.format("Firewall rule changed: %d-%s-%s", new Object[]{Integer.valueOf(uid), getFirewallChainName(chain), getFirewallRuleName(rule)});
    }

    private static String getFirewallChainEnabledLog(int chain, boolean enabled) {
        return "Firewall chain " + getFirewallChainName(chain) + " state: " + enabled;
    }

    private static String getMeteredAllowlistChangedLog(int uid, boolean added) {
        return "metered-allowlist for " + uid + " changed to " + added;
    }

    private static String getMeteredDenylistChangedLog(int uid, boolean added) {
        return "metered-denylist for " + uid + " changed to " + added;
    }

    private static String getRoamingChangedLog(int netId, boolean newRoaming) {
        return "Roaming of netId=" + netId + " changed to " + newRoaming;
    }

    private static String getInterfacesChangedLog(int netId, String newIfaces) {
        return "Interfaces of netId=" + netId + " changed to " + newIfaces;
    }

    static String getFirewallChainName(int chain) {
        switch(chain) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L9;
            case 11: goto L7;
            case 12: goto L5;
            default: goto L4;
        };
    L5:
        return "metered_deny_admin";
    L7:
        return "metered_deny_user";
    L9:
        return "metered_allow";
    L11:
        return "background";
    L13:
        return LowPowerStandbyController.DeviceConfigWrapper.NAMESPACE;
    L15:
        return "restricted";
    L17:
        return "powersave";
    L19:
        return "standby";
    L21:
        return "dozable";
    L4:
        return String.valueOf(chain);
    }

    private static String getFirewallRuleName(int rule) {
        switch(rule) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "deny";
    L7:
        return "allow";
    L9:
        return "default";
    L4:
        return String.valueOf(rule);
    }
}
