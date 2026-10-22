package com.android.server.content;

import android.accounts.Account;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Slog;
import com.android.server.location.StarLocation;
import com.android.server.policy.PhoneWindowManager;
import com.android.server.slice.SliceClientPermissions;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SyncOperation {
    public static final int NO_JOB_ID = -1;
    public static final int REASON_ACCOUNTS_UPDATED = -2;
    public static final int REASON_BACKGROUND_DATA_SETTINGS_CHANGED = -1;
    public static final int REASON_IS_SYNCABLE = -5;
    public static final int REASON_MASTER_SYNC_AUTO = -7;
    private static String[] REASON_NAMES = null;
    public static final int REASON_PERIODIC = -4;
    public static final int REASON_SERVICE_CHANGED = -3;
    public static final int REASON_SYNC_AUTO = -6;
    public static final int REASON_USER_START = -8;
    public static final String TAG = "SyncManager";
    public final boolean allowParallelSyncs;
    public long expectedRuntime;
    public final long flexMillis;
    public final boolean isPeriodic;
    public int jobId;
    public final String key;
    private volatile Bundle mImmutableExtras;
    public final String owningPackage;
    public final int owningUid;
    public final long periodMillis;
    public final int reason;
    int retries;
    boolean scheduleEjAsRegularJob;
    public final int sourcePeriodicId;
    public int syncExemptionFlag;
    public final int syncSource;
    public final SyncStorageEngine.EndPoint target;
    public String wakeLockName;

    static {
        REASON_NAMES = new String[]{"DataSettingsChanged", "AccountsUpdated", "ServiceChanged", "Periodic", "IsSyncable", "AutoSync", "MasterSyncAuto", "UserStart"};
    }

    public SyncOperation(Account account, int userId, int owningUid, String owningPackage, int reason, int source, String provider, Bundle extras, boolean allowParallelSyncs, int syncExemptionFlag) {
        this(new SyncStorageEngine.EndPoint(account, provider, userId), owningUid, owningPackage, reason, source, extras, allowParallelSyncs, syncExemptionFlag);
    }

    private SyncOperation(SyncStorageEngine.EndPoint info, int owningUid, String owningPackage, int reason, int source, Bundle extras, boolean allowParallelSyncs, int syncExemptionFlag) {
        this(info, owningUid, owningPackage, reason, source, extras, allowParallelSyncs, false, -1, 0, 0, syncExemptionFlag);
    }

    public SyncOperation(SyncOperation op, long periodMillis, long flexMillis) {
        this(op.target, op.owningUid, op.owningPackage, op.reason, op.syncSource, op.mImmutableExtras, op.allowParallelSyncs, op.isPeriodic, op.sourcePeriodicId, periodMillis, flexMillis, 0);
    }

    public SyncOperation(SyncStorageEngine.EndPoint info, int owningUid, String owningPackage, int reason, int source, Bundle extras, boolean allowParallelSyncs, boolean isPeriodic, int sourcePeriodicId, long periodMillis, long flexMillis, int syncExemptionFlag) {
        this.target = info;
        this.owningUid = owningUid;
        this.owningPackage = owningPackage;
        this.reason = reason;
        this.syncSource = source;
        this.mImmutableExtras = new Bundle(extras);
        this.allowParallelSyncs = allowParallelSyncs;
        this.isPeriodic = isPeriodic;
        this.sourcePeriodicId = sourcePeriodicId;
        this.periodMillis = periodMillis;
        this.flexMillis = flexMillis;
        this.jobId = -1;
        this.key = toKey();
        this.syncExemptionFlag = syncExemptionFlag;
    }

    public SyncOperation createOneTimeSyncOperation() {
        if (this.isPeriodic == true) goto L6;
        return null;
    L6:
        SyncOperation op = new SyncOperation(this.target, this.owningUid, this.owningPackage, this.reason, this.syncSource, this.mImmutableExtras, this.allowParallelSyncs, false, this.jobId, this.periodMillis, this.flexMillis, 0);
        return op;
    }

    public SyncOperation(SyncOperation other) {
        this.target = other.target;
        this.owningUid = other.owningUid;
        this.owningPackage = other.owningPackage;
        this.reason = other.reason;
        this.syncSource = other.syncSource;
        this.allowParallelSyncs = other.allowParallelSyncs;
        this.mImmutableExtras = other.mImmutableExtras;
        this.wakeLockName = other.wakeLockName();
        this.isPeriodic = other.isPeriodic;
        this.sourcePeriodicId = other.sourcePeriodicId;
        this.periodMillis = other.periodMillis;
        this.flexMillis = other.flexMillis;
        this.key = other.key;
        this.syncExemptionFlag = other.syncExemptionFlag;
    }

    PersistableBundle toJobInfoExtras() {
        PersistableBundle jobInfoExtras = new PersistableBundle();
        PersistableBundle syncExtrasBundle = new PersistableBundle();
        Bundle extras = this.mImmutableExtras;
        Iterator<String> r3 = extras.keySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L30;
        String key = r3.next();
        Object value = extras.get(key);
        if ((value instanceof Account) == true) goto L7;
        if ((value instanceof Long) == true) goto L10;
        if ((value instanceof Integer) == true) goto L13;
        if ((value instanceof Boolean) == true) goto L16;
        if ((value instanceof Float) == true) goto L19;
        if ((value instanceof Double) == true) goto L22;
        if ((value instanceof String) == true) goto L25;
        if (value == null) goto L27;
        Slog.e(TAG, "Unknown extra type.");
        goto L4
    L27:
        syncExtrasBundle.putString(key, null);
        goto L4
    L25:
        syncExtrasBundle.putString(key, (String) value);
        goto L4
    L22:
        syncExtrasBundle.putDouble(key, ((Double) value).doubleValue());
        goto L4
    L19:
        syncExtrasBundle.putDouble(key, ((Float) value).floatValue());
        goto L4
    L16:
        syncExtrasBundle.putBoolean(key, ((Boolean) value).booleanValue());
        goto L4
    L13:
        syncExtrasBundle.putInt(key, ((Integer) value).intValue());
        goto L4
    L10:
        syncExtrasBundle.putLong(key, ((Long) value).longValue());
        goto L4
    L7:
        Account account = (Account) value;
        PersistableBundle accountBundle = new PersistableBundle();
        accountBundle.putString("accountName", account.name);
        accountBundle.putString("accountType", account.type);
        jobInfoExtras.putPersistableBundle("ACCOUNT:" + key, accountBundle);
        goto L4
    L30:
        jobInfoExtras.putPersistableBundle("syncExtras", syncExtrasBundle);
        jobInfoExtras.putBoolean("SyncManagerJob", true);
        jobInfoExtras.putString("provider", this.target.provider);
        jobInfoExtras.putString("accountName", this.target.account.name);
        jobInfoExtras.putString("accountType", this.target.account.type);
        jobInfoExtras.putInt("userId", this.target.userId);
        jobInfoExtras.putInt("owningUid", this.owningUid);
        jobInfoExtras.putString("owningPackage", this.owningPackage);
        jobInfoExtras.putInt(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY, this.reason);
        jobInfoExtras.putInt(StarLocation.KEY_LOCATION_SOURCE, this.syncSource);
        jobInfoExtras.putBoolean("allowParallelSyncs", this.allowParallelSyncs);
        jobInfoExtras.putInt("jobId", this.jobId);
        jobInfoExtras.putBoolean("isPeriodic", this.isPeriodic);
        jobInfoExtras.putInt("sourcePeriodicId", this.sourcePeriodicId);
        jobInfoExtras.putLong("periodMillis", this.periodMillis);
        jobInfoExtras.putLong("flexMillis", this.flexMillis);
        jobInfoExtras.putLong("expectedRuntime", this.expectedRuntime);
        jobInfoExtras.putInt("retries", this.retries);
        jobInfoExtras.putInt("syncExemptionFlag", this.syncExemptionFlag);
        jobInfoExtras.putBoolean("ejDowngradedToRegular", this.scheduleEjAsRegularJob);
        return jobInfoExtras;
    }

    static SyncOperation maybeCreateFromJobExtras(PersistableBundle jobExtras) {
        if (jobExtras != null) goto L6;
        return null;
    L6:
        if (jobExtras.getBoolean("SyncManagerJob", false) == true) goto L8;
        return null;
    L8:
        String r1 = "accountName";
        String accountName = jobExtras.getString("accountName");
        String accountType = jobExtras.getString("accountType");
        String provider = jobExtras.getString("provider");
        int userId = jobExtras.getInt("userId", Integer.MAX_VALUE);
        int owningUid = jobExtras.getInt("owningUid");
        String owningPackage = jobExtras.getString("owningPackage");
        int reason = jobExtras.getInt(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY, Integer.MAX_VALUE);
        int source = jobExtras.getInt(StarLocation.KEY_LOCATION_SOURCE, Integer.MAX_VALUE);
        boolean allowParallelSyncs = jobExtras.getBoolean("allowParallelSyncs", false);
        boolean isPeriodic = jobExtras.getBoolean("isPeriodic", false);
        int initiatedBy = jobExtras.getInt("sourcePeriodicId", -1);
        long periodMillis = jobExtras.getLong("periodMillis");
        long flexMillis = jobExtras.getLong("flexMillis");
        int syncExemptionFlag = jobExtras.getInt("syncExemptionFlag", 0);
        Bundle extras = new Bundle();
        PersistableBundle syncExtras = jobExtras.getPersistableBundle("syncExtras");
        if (syncExtras == null) goto L11;
        extras.putAll(syncExtras);
    L11:
        Iterator<String> r9 = jobExtras.keySet().iterator();
    L13:
        if (r9.hasNext() == false) goto L21;
        String key = r9.next();
        if (key == null) goto L20;
        if (key.startsWith("ACCOUNT:") == false) goto L20;
        String newKey = key.substring(8);
        PersistableBundle accountsBundle = jobExtras.getPersistableBundle(key);
        Account account = new Account(accountsBundle.getString(r1), accountsBundle.getString("accountType"));
        extras.putParcelable(newKey, account);
    L20:
        r9 = r9;
        syncExtras = syncExtras;
        r1 = r1;
        goto L13
    L21:
        Account account2 = new Account(accountName, accountType);
        SyncStorageEngine.EndPoint target = new SyncStorageEngine.EndPoint(account2, provider, userId);
        SyncOperation op = new SyncOperation(target, owningUid, owningPackage, reason, source, extras, allowParallelSyncs, isPeriodic, initiatedBy, periodMillis, flexMillis, syncExemptionFlag);
        op.jobId = jobExtras.getInt("jobId");
        op.expectedRuntime = jobExtras.getLong("expectedRuntime");
        op.retries = jobExtras.getInt("retries");
        op.scheduleEjAsRegularJob = jobExtras.getBoolean("ejDowngradedToRegular");
        return op;
    }

    boolean isConflict(SyncOperation toRun) {
        SyncStorageEngine.EndPoint other = toRun.target;
        if (this.target.account.type.equals(other.account.type) == true) goto L5;
    L13:
        return false;
    L5:
        if (this.target.provider.equals(other.provider) == false) goto L13;
        if (this.target.userId != other.userId) goto L13;
        if (this.allowParallelSyncs == true) goto L11;
    L12:
        return true;
    L11:
        if (this.target.account.name.equals(other.account.name) == false) goto L13;
        goto L12
    }

    boolean isReasonPeriodic() {
        if (this.reason != (-4)) goto L5;
        return true;
    L5:
        return false;
    }

    boolean matchesPeriodicOperation(SyncOperation other) {
        if (this.target.matchesSpec(other.target) == true) goto L5;
    L11:
        return false;
    L5:
        if (SyncManager.syncExtrasEquals(this.mImmutableExtras, other.mImmutableExtras, true) == false) goto L11;
        if (this.periodMillis != other.periodMillis) goto L11;
        if (this.flexMillis != other.flexMillis) goto L11;
        return true;
    }

    boolean isDerivedFromFailedPeriodicSync() {
        if (this.sourcePeriodicId == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    int getJobBias() {
        if (isInitialization() == false) goto L7;
        return 20;
    L7:
        if (isExpedited() == false) goto L10;
        return 10;
    L10:
        return 0;
    }

    private String toKey() {
        Bundle extras = this.mImmutableExtras;
        StringBuilder sb = new StringBuilder();
        sb.append("provider: ");
        sb.append(this.target.provider);
        sb.append(" account {name=" + this.target.account.name + ", user=" + this.target.userId + ", type=" + this.target.account.type + "}");
        sb.append(" isPeriodic: ");
        sb.append(this.isPeriodic);
        sb.append(" period: ");
        sb.append(this.periodMillis);
        sb.append(" flex: ");
        sb.append(this.flexMillis);
        sb.append(" extras: ");
        extrasToStringBuilder(extras, sb);
        return sb.toString();
    }

    public String toString() {
        return dump(null, true, null, false);
    }

    public String toSafeString() {
        return dump(null, true, null, true);
    }

    String dump(PackageManager pm, boolean shorter, SyncAdapterStateFetcher appStates, boolean logSafe) {
        Bundle extras = this.mImmutableExtras;
        StringBuilder sb = new StringBuilder();
        sb.append("JobId=");
        sb.append(this.jobId);
        sb.append(" ");
        if (logSafe == false) goto L5;
        String r3 = "***";
    L6:
        sb.append(r3);
        sb.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        sb.append(this.target.account.type);
        sb.append(" u");
        sb.append(this.target.userId);
        sb.append(" [");
        sb.append(this.target.provider);
        sb.append("] ");
        sb.append(SyncStorageEngine.SOURCES[this.syncSource]);
        if (this.expectedRuntime == 0) goto L10;
        sb.append(" ExpectedIn=");
        SyncManager.formatDurationHMS(sb, this.expectedRuntime - SystemClock.elapsedRealtime());
    L10:
        if (extras.getBoolean("expedited", false) == false) goto L13;
        sb.append(" EXPEDITED");
    L13:
        if (extras.getBoolean("schedule_as_expedited_job", false) == false) goto L18;
        sb.append(" EXPEDITED-JOB");
        if (this.scheduleEjAsRegularJob == false) goto L18;
        sb.append("(scheduled-as-regular)");
    L18:
        switch(this.syncExemptionFlag) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L20;
            default: goto L19;
        };
    L19:
        sb.append(" ExemptionFlag=" + this.syncExemptionFlag);
        goto L23
    L20:
        sb.append(" STANDBY-EXEMPTED(TOP)");
        goto L23
    L21:
        sb.append(" STANDBY-EXEMPTED");
    L23:
        sb.append(" Reason=");
        sb.append(reasonToString(pm, this.reason));
        if (this.isPeriodic == false) goto L27;
        sb.append(" (period=");
        SyncManager.formatDurationHMS(sb, this.periodMillis);
        sb.append(" flex=");
        SyncManager.formatDurationHMS(sb, this.flexMillis);
        sb.append(")");
    L27:
        if (this.retries <= 0) goto L29;
        sb.append(" Retries=");
        sb.append(this.retries);
    L29:
        if (shorter == true) goto L39;
        sb.append(" Owner={");
        UserHandle.formatUid(sb, this.owningUid);
        sb.append(" ");
        sb.append(this.owningPackage);
        if (appStates == null) goto L35;
        sb.append(" [");
        sb.append(appStates.getStandbyBucket(UserHandle.getUserId(this.owningUid), this.owningPackage));
        sb.append("]");
        if (appStates.isAppActive(this.owningUid) == false) goto L35;
        sb.append(" [ACTIVE]");
    L35:
        sb.append("}");
        if (extras.keySet().isEmpty() == true) goto L39;
        sb.append(" ");
        extrasToStringBuilder(extras, sb);
    L39:
        return sb.toString();
    L5:
        r3 = this.target.account.name;
        goto L6
    }

    static String reasonToString(PackageManager pm, int reason) {
        if (reason < 0) goto L18;
        if (pm == null) goto L17;
        String[] packages = pm.getPackagesForUid(reason);
        if (packages != null) goto L8;
    L11:
        String name = pm.getNameForUid(reason);
        if (name == null) goto L15;
        return name;
    L15:
        return String.valueOf(reason);
    L8:
        if (packages.length != 1) goto L11;
        return packages[0];
    L17:
        return String.valueOf(reason);
    L18:
        int index = (-reason) - 1;
        if (index < REASON_NAMES.length) goto L23;
        return String.valueOf(reason);
    L23:
        return REASON_NAMES[index];
    }

    boolean isInitialization() {
        return this.mImmutableExtras.getBoolean("initialize", false);
    }

    boolean isExpedited() {
        return this.mImmutableExtras.getBoolean("expedited", false);
    }

    boolean isUpload() {
        return this.mImmutableExtras.getBoolean("upload", false);
    }

    void enableTwoWaySync() {
        removeExtra("upload");
    }

    boolean hasIgnoreBackoff() {
        return this.mImmutableExtras.getBoolean("ignore_backoff", false);
    }

    void enableBackoff() {
        removeExtra("ignore_backoff");
    }

    boolean hasDoNotRetry() {
        return this.mImmutableExtras.getBoolean("do_not_retry", false);
    }

    boolean isNotAllowedOnMetered() {
        return this.mImmutableExtras.getBoolean("allow_metered", false);
    }

    boolean isManual() {
        return this.mImmutableExtras.getBoolean("force", false);
    }

    boolean isIgnoreSettings() {
        return this.mImmutableExtras.getBoolean("ignore_settings", false);
    }

    boolean hasRequireCharging() {
        return this.mImmutableExtras.getBoolean("require_charging", false);
    }

    boolean isScheduledAsExpeditedJob() {
        return this.mImmutableExtras.getBoolean("schedule_as_expedited_job", false);
    }

    boolean isAppStandbyExempted() {
        if (this.syncExemptionFlag == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean areExtrasEqual(Bundle other, boolean includeSyncSettings) {
        return SyncManager.syncExtrasEquals(this.mImmutableExtras, other, includeSyncSettings);
    }

    static void extrasToStringBuilder(Bundle bundle, StringBuilder sb) {
        if (bundle != null) goto L5;
        sb.append("null");
        return;
    L5:
        sb.append("[");
        Iterator<String> r0 = bundle.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        String key = r0.next();
        sb.append(key);
        sb.append("=");
        sb.append(bundle.get(key));
        sb.append(" ");
        goto L7
    L9:
        sb.append("]");
    }

    private static String extrasToString(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        extrasToStringBuilder(bundle, sb);
        return sb.toString();
    }

    String wakeLockName() {
        if (this.wakeLockName != null) goto L5;
        String r0 = this.target.provider + SliceClientPermissions.SliceAuthority.DELIMITER + this.target.account.type;
        this.wakeLockName = r0;
        return r0;
    L5:
        return this.wakeLockName;
    }

    public Object[] toEventLog(int event) {
        Object[] logArray = {this.target.provider, Integer.valueOf(event), Integer.valueOf(this.syncSource), Integer.valueOf(this.target.account.name.hashCode())};
        return logArray;
    }

    private void removeExtra(String key) {
        Bundle b = this.mImmutableExtras;
        if (b.containsKey(key) == true) goto L5;
        return;
    L5:
        Bundle clone = new Bundle(b);
        clone.remove(key);
        this.mImmutableExtras = clone;
    }

    public Bundle getClonedExtras() {
        return new Bundle(this.mImmutableExtras);
    }

    public String getExtrasAsString() {
        return extrasToString(this.mImmutableExtras);
    }
}
