package com.android.server.net;

import android.net.Network;
import android.telephony.SubscriptionPlan;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NetworkPolicyManagerInternal {
    public static final int QUOTA_TYPE_JOBS = 1;
    public static final int QUOTA_TYPE_MULTIPATH = 2;

    public abstract long getSubscriptionOpportunisticQuota(Network r1, int r2);

    public abstract SubscriptionPlan getSubscriptionPlan(Network r1);

    public abstract void onAdminDataAvailable();

    public abstract void onTempPowerSaveWhitelistChange(int r1, boolean r2, int r3, String r4);

    public abstract void resetUserState(int r1);

    public abstract void setAppIdleWhitelist(int r1, boolean r2);

    public abstract void setLowPowerStandbyActive(boolean r1);

    public abstract void setLowPowerStandbyAllowlist(int[] r1);

    public abstract void setMeteredRestrictedPackages(Set<String> r1, int r2);

    public abstract void setMeteredRestrictedPackagesAsync(Set<String> r1, int r2);

    public NetworkPolicyManagerInternal() {
    }

    public static int updateBlockedReasonsWithProcState(int blockedReasons, int procState) {
        int allowedReasons = NetworkPolicyManagerService.UidBlockedState.getAllowedReasonsForProcState(procState);
        return NetworkPolicyManagerService.UidBlockedState.getEffectiveBlockedReasons(blockedReasons, allowedReasons);
    }
}
