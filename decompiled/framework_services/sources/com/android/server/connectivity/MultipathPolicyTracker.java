package com.android.server.connectivity;

import android.R;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkIdentity;
import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkRequest;
import android.net.NetworkSpecifier;
import android.net.NetworkTemplate;
import android.net.TelephonyNetworkSpecifier;
import android.net.Uri;
import android.os.BestClock;
import android.os.Handler;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DebugUtils;
import android.util.Log;
import android.util.Range;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.LocalServices;
import com.android.server.net.NetworkPolicyManagerInternal;
import java.time.Clock;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class MultipathPolicyTracker {
    private static final boolean DBG = false;
    private static final long MIN_THRESHOLD_BYTES = 2097152;
    private static final int OPQUOTA_USER_SETTING_DIVIDER = 20;
    private static String TAG;
    private ConnectivityManager mCM;
    private final Clock mClock;
    private final ConfigChangeReceiver mConfigChangeReceiver;
    private final Context mContext;
    private final Dependencies mDeps;
    private final Handler mHandler;
    private ConnectivityManager.NetworkCallback mMobileNetworkCallback;
    private final ConcurrentHashMap<Network, MultipathTracker> mMultipathTrackers;
    private NetworkPolicyManager mNPM;
    private NetworkPolicyManager.Listener mPolicyListener;
    private final ContentResolver mResolver;
    final ContentObserver mSettingsObserver;
    private NetworkStatsManager mStatsManager;
    private final Context mUserAllContext;

    /* JADX INFO: renamed from: com.android.server.connectivity.MultipathPolicyTracker$2, reason: invalid class name */
    class AnonymousClass2 extends NetworkPolicyManager.Listener {
        final /* synthetic */ MultipathPolicyTracker this$0;

        public static /* synthetic */ void $r8$lambda$DHrfOYDrWbb_U_OnZeW9KAD_ew4(AnonymousClass2 r0) {
            r0.lambda$onMeteredIfacesChanged$0();
        }

        AnonymousClass2(MultipathPolicyTracker this$0) {
            this.this$0 = this$0;
        }

        private /* synthetic */ void lambda$onMeteredIfacesChanged$0() {
            MultipathPolicyTracker.m3065$$Nest$mupdateAllMultipathBudgets(this.this$0);
        }

        public void onMeteredIfacesChanged(String[] meteredIfaces) {
            MultipathPolicyTracker.m3061$$Nest$fgetmHandler(this.this$0).post(new MultipathPolicyTracker$2$$ExternalSyntheticLambda0(this));
        }
    }

    private final class ConfigChangeReceiver extends BroadcastReceiver {
        final /* synthetic */ MultipathPolicyTracker this$0;

        /* synthetic */ ConfigChangeReceiver(MultipathPolicyTracker r1, MultipathPolicyTrackerIA r2) {
            this(r1);
        }

        private ConfigChangeReceiver(MultipathPolicyTracker r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MultipathPolicyTracker.m3065$$Nest$mupdateAllMultipathBudgets(this.this$0);
        }
    }

    public static class Dependencies {
        public Dependencies() {
        }

        public Clock getClock() {
            return new BestClock(ZoneOffset.UTC, new Clock[]{SystemClock.currentNetworkTimeClock(), Clock.systemUTC()});
        }
    }

    class MultipathTracker {
        private volatile long mMultipathBudget;
        private NetworkCapabilities mNetworkCapabilities;
        private final NetworkTemplate mNetworkTemplate;
        private long mQuota;
        private final NetworkStatsManager mStatsManager;
        private final int mSubId;
        private final NetworkStatsManager.UsageCallback mUsageCallback;
        private boolean mUsageCallbackRegistered;
        final Network network;
        final String subscriberId;
        final /* synthetic */ MultipathPolicyTracker this$0;

        /* JADX INFO: renamed from: $r8$lambda$Z3u6Eeyof-_vXJwSsbLHUC0zYhg, reason: not valid java name */
        public static /* synthetic */ void m3069$r8$lambda$Z3u6Eeyof_vXJwSsbLHUC0zYhg(MultipathTracker r0, Runnable r1) {
            r0.lambda$setMultipathBudget$0(r1);
        }

        public MultipathTracker(final MultipathPolicyTracker this$0, final Network network, NetworkCapabilities nc) {
            this.this$0 = this$0;
            this.mUsageCallbackRegistered = false;
            this.network = network;
            this.mNetworkCapabilities = new NetworkCapabilities(nc);
            NetworkSpecifier specifier = nc.getNetworkSpecifier();
            if ((specifier instanceof TelephonyNetworkSpecifier) == false) goto L19;
            this.mSubId = ((TelephonyNetworkSpecifier) specifier).getSubscriptionId();
            TelephonyManager tele = (TelephonyManager) MultipathPolicyTracker.m3060$$Nest$fgetmContext(this$0).getSystemService(TelephonyManager.class);
            if (tele == null) goto L17;
            TelephonyManager tele2 = tele.createForSubscriptionId(this.mSubId);
            if (tele2 == null) goto L15;
            this.subscriberId = tele2.getSubscriberId();
            if (this.subscriberId == null) goto L13;
            this.mNetworkTemplate = new NetworkTemplate.Builder(1).setSubscriberIds(Set.of(this.subscriberId)).setMeteredness(1).setDefaultNetworkStatus(0).build();
            this.mUsageCallback = new AnonymousClass1(this, this$0, network);
            this.mStatsManager = (NetworkStatsManager) MultipathPolicyTracker.m3060$$Nest$fgetmContext(this$0).getSystemService(NetworkStatsManager.class);
            this.mStatsManager.setPollOnOpen(false);
            updateMultipathBudget();
            return;
        L13:
            throw new IllegalStateException("Null subscriber Id for subId " + this.mSubId);
        L15:
            throw new IllegalStateException(String.format("Can't get TelephonyManager for subId %d", new Object[]{Integer.valueOf(this.mSubId)}));
        L17:
            throw new IllegalStateException(String.format("Missing TelephonyManager", new Object[0]));
        L19:
            throw new IllegalStateException(String.format("Can't get subId from mobile network %s (%s)", new Object[]{network, nc}));
        }

        public void setNetworkCapabilities(NetworkCapabilities nc) {
            this.mNetworkCapabilities = new NetworkCapabilities(nc);
        }

        private long getDailyNonDefaultDataUsage() {
            ZonedDateTime end = ZonedDateTime.ofInstant(MultipathPolicyTracker.m3059$$Nest$fgetmClock(this.this$0).instant(), ZoneId.systemDefault());
            ZonedDateTime start = end.truncatedTo(ChronoUnit.DAYS);
            long bytes = getNetworkTotalBytes(start.toInstant().toEpochMilli(), end.toInstant().toEpochMilli());
            return bytes;
        }

        private long getNetworkTotalBytes(long start, long end) {
            NetworkStats.Bucket ret = this.mStatsManager.querySummaryForDevice(this.mNetworkTemplate, start, end);     // Catch: RuntimeException -> L7
            return ret.getRxBytes() + ret.getTxBytes();
        L7:
            e = move-exception;
            RuntimeException e = e;
        L11:
            Log.w(MultipathPolicyTracker.m3066$$Nest$sfgetTAG(), "Failed to get data usage: " + e);
            return -1;
        L9:
            e = move-exception;
            e = e;
            goto L11
        }

        private NetworkIdentity getTemplateMatchingNetworkIdentity(NetworkCapabilities nc) {
            return new NetworkIdentity.Builder().setType(0).setSubscriberId(this.subscriberId).setRoaming(!nc.hasCapability(18)).setMetered(!nc.hasCapability(11)).setSubId(this.mSubId).build();
        }

        private long getRemainingDailyBudget(long limitBytes, Range<ZonedDateTime> cycle) {
            long start = ((ZonedDateTime) cycle.getLower()).toInstant().toEpochMilli();
            long end = ((ZonedDateTime) cycle.getUpper()).toInstant().toEpochMilli();
            long totalBytes = getNetworkTotalBytes(start, end);
            long remainingBytes = 0;
            if (totalBytes == (-1)) goto L6;
            remainingBytes = Math.max(0, limitBytes - totalBytes);
        L6:
            long remainingDays = (((end - MultipathPolicyTracker.m3059$$Nest$fgetmClock(this.this$0).millis()) - 1) / TimeUnit.DAYS.toMillis(1)) + 1;
            return remainingBytes / Math.max(1, remainingDays);
        }

        private long getUserPolicyOpportunisticQuotaBytes() {
            long minQuota = Long.MAX_VALUE;
            NetworkIdentity identity = getTemplateMatchingNetworkIdentity(this.mNetworkCapabilities);
            NetworkPolicy[] policies = MultipathPolicyTracker.m3063$$Nest$fgetmNPM(this.this$0).getNetworkPolicies();
            int r5 = policies.length;
            int r6 = 0;
        L4:
            if (r6 >= r5) goto L20;
            NetworkPolicy policy = policies[r6];
            if (policy.hasCycle() == false) goto L18;
            if (policy.template.matches(identity) == false) goto L18;
            long cycleStart = ((ZonedDateTime) ((Range) policy.cycleIterator().next()).getLower()).toInstant().toEpochMilli();
            long activeWarning = MultipathPolicyTracker.m3068$$Nest$smgetActiveWarning(policy, cycleStart);
            if (activeWarning != (-1)) goto L12;
            long policyBytes = MultipathPolicyTracker.m3067$$Nest$smgetActiveLimit(policy, cycleStart);
        L14:
            if (policyBytes == (-1)) goto L18;
            if (policyBytes == (-1)) goto L18;
            long policyBudget = getRemainingDailyBudget(policyBytes, (Range) policy.cycleIterator().next());
            minQuota = Math.min(minQuota, policyBudget);
            goto L18
        L12:
            policyBytes = activeWarning;
        L18:
            r6 = r6 + 1;
            goto L4
        L20:
            if (minQuota != Long.MAX_VALUE) goto L23;
            return -1;
        L23:
            return minQuota / 20;
        }

        void updateMultipathBudget() {
            long quota = ((NetworkPolicyManagerInternal) LocalServices.getService(NetworkPolicyManagerInternal.class)).getSubscriptionOpportunisticQuota(this.network, 2);
            if (quota != (-1)) goto L6;
            quota = getUserPolicyOpportunisticQuotaBytes();
        L6:
            if (quota != (-1)) goto L9;
            quota = MultipathPolicyTracker.m3064$$Nest$mgetDefaultDailyMultipathQuotaBytes(this.this$0);
        L9:
            if (haveMultipathBudget() == true) goto L11;
        L13:
            this.mQuota = quota;
            long usage = getDailyNonDefaultDataUsage();
            long budget = 0;
            if (usage == (-1)) goto L18;
            budget = Math.max(0, quota - usage);
        L18:
            if (budget <= MultipathPolicyTracker.MIN_THRESHOLD_BYTES) goto L20;
            setMultipathBudget(budget);
            return;
        L20:
            clearMultipathBudget();
            return;
        L11:
            if (quota != this.mQuota) goto L13;
        }

        public int getMultipathPreference() {
            if (haveMultipathBudget() == false) goto L6;
            return 3;
        L6:
            return 0;
        }

        public long getQuota() {
            return this.mQuota;
        }

        public long getMultipathBudget() {
            return this.mMultipathBudget;
        }

        private boolean haveMultipathBudget() {
            if (this.mMultipathBudget <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        private void setMultipathBudget(long budget) {
            maybeUnregisterUsageCallback();
            this.mStatsManager.registerUsageCallback(this.mNetworkTemplate, budget, new MultipathPolicyTracker$MultipathTracker$$ExternalSyntheticLambda0(this), this.mUsageCallback);
            this.mUsageCallbackRegistered = true;
            this.mMultipathBudget = budget;
        }

        private /* synthetic */ void lambda$setMultipathBudget$0(Runnable command) {
            MultipathPolicyTracker.m3061$$Nest$fgetmHandler(this.this$0).post(command);
        }

        private void maybeUnregisterUsageCallback() {
            if (this.mUsageCallbackRegistered == true) goto L5;
            return;
        L5:
            this.mStatsManager.unregisterUsageCallback(this.mUsageCallback);
            this.mUsageCallbackRegistered = false;
        }

        private void clearMultipathBudget() {
            maybeUnregisterUsageCallback();
            this.mMultipathBudget = 0;
        }

        void shutdown() {
            clearMultipathBudget();
        }
    }

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ MultipathPolicyTracker this$0;

        public SettingsObserver(MultipathPolicyTracker r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            Log.wtf(MultipathPolicyTracker.m3066$$Nest$sfgetTAG(), "Should never be reached.");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (Settings.Global.getUriFor("network_default_daily_multipath_quota_bytes").equals(uri) == true) goto L5;
            Log.wtf(MultipathPolicyTracker.m3066$$Nest$sfgetTAG(), "Unexpected settings observation: " + uri);
        L5:
            MultipathPolicyTracker.m3065$$Nest$mupdateAllMultipathBudgets(this.this$0);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Clock m3059$$Nest$fgetmClock(MultipathPolicyTracker r0) {
        return r0.mClock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3060$$Nest$fgetmContext(MultipathPolicyTracker r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3061$$Nest$fgetmHandler(MultipathPolicyTracker r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMultipathTrackers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConcurrentHashMap m3062$$Nest$fgetmMultipathTrackers(MultipathPolicyTracker r0) {
        return r0.mMultipathTrackers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNPM, reason: not valid java name */
    static /* bridge */ /* synthetic */ NetworkPolicyManager m3063$$Nest$fgetmNPM(MultipathPolicyTracker r0) {
        return r0.mNPM;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDefaultDailyMultipathQuotaBytes, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m3064$$Nest$mgetDefaultDailyMultipathQuotaBytes(MultipathPolicyTracker r2) {
        return r2.getDefaultDailyMultipathQuotaBytes();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAllMultipathBudgets, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3065$$Nest$mupdateAllMultipathBudgets(MultipathPolicyTracker r0) {
        r0.updateAllMultipathBudgets();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3066$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetActiveLimit, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m3067$$Nest$smgetActiveLimit(NetworkPolicy r0, long r1) {
        return getActiveLimit(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetActiveWarning, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m3068$$Nest$smgetActiveWarning(NetworkPolicy r0, long r1) {
        return getActiveWarning(r0, r1);
    }

    static {
        TAG = MultipathPolicyTracker.class.getSimpleName();
    }

    public MultipathPolicyTracker(Context ctx, Handler handler) {
        this(ctx, handler, new Dependencies());
    }

    public MultipathPolicyTracker(Context ctx, Handler handler, Dependencies deps) {
        this.mMultipathTrackers = new ConcurrentHashMap();
        this.mContext = ctx;
        this.mUserAllContext = ctx.createContextAsUser(UserHandle.ALL, 0);
        this.mHandler = handler;
        this.mClock = deps.getClock();
        this.mDeps = deps;
        this.mResolver = this.mContext.getContentResolver();
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mConfigChangeReceiver = new ConfigChangeReceiver(this, null);
    }

    public void start() {
        this.mCM = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        this.mNPM = (NetworkPolicyManager) this.mContext.getSystemService(NetworkPolicyManager.class);
        this.mStatsManager = (NetworkStatsManager) this.mContext.getSystemService(NetworkStatsManager.class);
        registerTrackMobileCallback();
        registerNetworkPolicyListener();
        Uri defaultSettingUri = Settings.Global.getUriFor("network_default_daily_multipath_quota_bytes");
        this.mResolver.registerContentObserver(defaultSettingUri, false, this.mSettingsObserver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        this.mUserAllContext.registerReceiver(this.mConfigChangeReceiver, intentFilter, null, this.mHandler);
    }

    public void shutdown() {
        maybeUnregisterTrackMobileCallback();
        unregisterNetworkPolicyListener();
        Iterator<MultipathTracker> r0 = this.mMultipathTrackers.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MultipathTracker t = r0.next();
        t.shutdown();
        goto L4
    L6:
        this.mMultipathTrackers.clear();
        this.mResolver.unregisterContentObserver(this.mSettingsObserver);
        this.mUserAllContext.unregisterReceiver(this.mConfigChangeReceiver);
    }

    public Integer getMultipathPreference(Network network) {
        if (network != null) goto L5;
        return null;
    L5:
        MultipathTracker t = this.mMultipathTrackers.get(network);
        if (t != null) goto L8;
        return null;
    L8:
        return Integer.valueOf(t.getMultipathPreference());
    }

    private static long getActiveWarning(NetworkPolicy policy, long cycleStart) {
        if (policy.lastWarningSnooze < cycleStart) goto L7;
        return -1;
    L7:
        return policy.warningBytes;
    }

    private static long getActiveLimit(NetworkPolicy policy, long cycleStart) {
        if (policy.lastLimitSnooze < cycleStart) goto L7;
        return -1;
    L7:
        return policy.limitBytes;
    }

    private long getDefaultDailyMultipathQuotaBytes() {
        String setting = Settings.Global.getString(this.mContext.getContentResolver(), "network_default_daily_multipath_quota_bytes");
        if (setting == null) goto L8;
        return Long.parseLong(setting);
    L8:
        return this.mContext.getResources().getInteger(R.integer.config_notificationsBatteryLedOff);
    }

    private void registerTrackMobileCallback() {
        NetworkRequest request = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        this.mMobileNetworkCallback = new AnonymousClass1(this);
        this.mCM.registerNetworkCallback(request, this.mMobileNetworkCallback, this.mHandler);
    }

    private void updateAllMultipathBudgets() {
        Iterator<MultipathTracker> r0 = this.mMultipathTrackers.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MultipathTracker t = r0.next();
        t.updateMultipathBudget();
        goto L4
    }

    private void maybeUnregisterTrackMobileCallback() {
        if (this.mMobileNetworkCallback == null) goto L5;
        this.mCM.unregisterNetworkCallback(this.mMobileNetworkCallback);
    L5:
        this.mMobileNetworkCallback = null;
    }

    private void registerNetworkPolicyListener() {
        this.mPolicyListener = new AnonymousClass2(this);
        this.mNPM.registerListener(this.mPolicyListener);
    }

    private void unregisterNetworkPolicyListener() {
        this.mNPM.unregisterListener(this.mPolicyListener);
    }

    public void dump(IndentingPrintWriter pw) {
        pw.println("MultipathPolicyTracker:");
        pw.increaseIndent();
        Iterator<MultipathTracker> r0 = this.mMultipathTrackers.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MultipathTracker t = r0.next();
        pw.println(String.format("Network %s: quota %d, budget %d. Preference: %s", new Object[]{t.network, Long.valueOf(t.getQuota()), Long.valueOf(t.getMultipathBudget()), DebugUtils.flagsToString(ConnectivityManager.class, "MULTIPATH_PREFERENCE_", t.getMultipathPreference())}));
        goto L4
    L6:
        pw.decreaseIndent();
    }
}
