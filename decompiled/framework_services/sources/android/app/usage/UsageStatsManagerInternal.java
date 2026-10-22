package android.app.usage;

import android.content.ComponentName;
import android.content.LocusId;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.UserHandle;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class UsageStatsManagerInternal {

    public static class AppUsageLimitData {
        private final long mTotalUsageLimit;
        private final long mUsageRemaining;

        public AppUsageLimitData(long totalUsageLimit, long usageRemaining) {
            this.mTotalUsageLimit = totalUsageLimit;
            this.mUsageRemaining = usageRemaining;
        }

        public long getTotalUsageLimit() {
            return this.mTotalUsageLimit;
        }

        public long getUsageRemaining() {
            return this.mUsageRemaining;
        }
    }

    public interface EstimatedLaunchTimeChangedListener {
        void onEstimatedLaunchTimeChanged(int r1, String r2, long r3);
    }

    public interface UsageEventListener {
        void onUsageEvent(int r1, UsageEvents.Event r2);
    }

    public abstract void applyRestoredPayload(int r1, String r2, byte[] r3);

    public abstract int getAppStandbyBucket(String r1, int r2, long r3);

    public abstract AppUsageLimitData getAppUsageLimit(String r1, UserHandle r2);

    public abstract byte[] getBackupPayload(int r1, String r2);

    public abstract long getEstimatedPackageLaunchTime(String r1, int r2);

    public abstract int[] getIdleUidsForUser(int r1);

    public abstract long getTimeSinceLastJobRun(String r1, int r2);

    public abstract boolean isAppIdle(String r1, int r2, int r3);

    public abstract void onActiveAdminAdded(String r1, int r2);

    public abstract void onAdminDataAvailable();

    public abstract void prepareForPossibleShutdown();

    public abstract void prepareShutdown();

    public abstract boolean pruneUninstalledPackagesData(int r1);

    public abstract UsageEvents queryEventsForUser(int r1, long r2, long r4, int r6);

    public abstract List<UsageStats> queryUsageStatsForUser(int r1, int r2, long r3, long r5, boolean r7);

    public abstract void registerLaunchTimeChangedListener(EstimatedLaunchTimeChangedListener r1);

    public abstract void registerListener(UsageEventListener r1);

    public abstract void reportAppJobState(String r1, int r2, int r3, long r4);

    public abstract void reportBroadcastDispatched(int r1, String r2, UserHandle r3, long r4, long r6, int r8);

    public abstract void reportConfigurationChange(Configuration r1, int r2);

    public abstract void reportContentProviderUsage(String r1, String r2, int r3);

    public abstract void reportEvent(ComponentName r1, int r2, int r3, int r4, ComponentName r5);

    public abstract void reportEvent(ComponentName r1, int r2, int r3, int r4, ComponentName r5, String r6);

    public abstract void reportEvent(String r1, int r2, int r3);

    public abstract void reportEventForAllUsers(String r1, int r2);

    public abstract void reportExemptedSyncStart(String r1, int r2);

    public abstract void reportInterruptiveNotification(String r1, String r2, int r3);

    public abstract void reportLocusUpdate(ComponentName r1, int r2, LocusId r3, IBinder r4);

    public abstract void reportNotificationPosted(String r1, UserHandle r2, long r3);

    public abstract void reportNotificationRemoved(String r1, UserHandle r2, long r3);

    public abstract void reportNotificationUpdated(String r1, UserHandle r2, long r3);

    public abstract void reportShortcutUsage(String r1, String r2, int r3);

    public abstract void reportSyncScheduled(String r1, int r2, boolean r3);

    public abstract void reportUserInteractionEvent(String r1, int r2, PersistableBundle r3);

    public abstract void setActiveAdminApps(Set<String> r1, int r2);

    public abstract void setAdminProtectedPackages(Set<String> r1, int r2);

    public abstract void setLastJobRunTime(String r1, int r2, long r3);

    public abstract void unregisterLaunchTimeChangedListener(EstimatedLaunchTimeChangedListener r1);

    public abstract void unregisterListener(UsageEventListener r1);

    public abstract boolean updatePackageMappingsData(int r1);

    public UsageStatsManagerInternal() {
    }
}
