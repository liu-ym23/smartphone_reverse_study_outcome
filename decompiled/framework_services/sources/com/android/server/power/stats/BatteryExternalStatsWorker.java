package com.android.server.power.stats;

import android.app.usage.NetworkStatsManager;
import android.bluetooth.BluetoothActivityEnergyInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.power.stats.EnergyConsumer;
import android.hardware.power.stats.EnergyConsumerResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SynchronousResultReceiver;
import android.os.SystemClock;
import android.os.connectivity.WifiActivityEnergyInfo;
import android.power.PowerStatsInternal;
import android.telephony.ModemActivityInfo;
import android.telephony.TelephonyManager;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseLongArray;
import com.android.server.LocalServices;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.job.controllers.JobStatus;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryExternalStatsWorker implements BatteryStatsImpl.ExternalStatsSync {
    private static final boolean DEBUG = false;
    private static final long EXTERNAL_STATS_SYNC_TIMEOUT_MILLIS = 2000;
    private static final long MAX_WIFI_STATS_SAMPLE_ERROR_MILLIS = 750;
    private static final int SYNC_BATTERY_LEVEL_CHANGE = 3;
    private static final int SYNC_PROCESS_STATE_CHANGE = 4;
    private static final int SYNC_UPDATE = 1;
    private static final int SYNC_USER_REMOVAL = 5;
    private static final int SYNC_WAKELOCK_CHANGE = 2;
    private static final String TAG = "BatteryExternalStatsWorker";
    public static final int UID_FINAL_REMOVAL_AFTER_USER_REMOVAL_DELAY_MILLIS = 10000;
    public static final int UID_QUICK_REMOVAL_AFTER_USER_REMOVAL_DELAY_MILLIS = 2000;
    private String mCurrentReason;
    private EnergyConsumerSnapshot mEnergyConsumerSnapshot;
    private SparseArray<int[]> mEnergyConsumerTypeToIdMap;
    private final Handler mHandler;
    final Injector mInjector;
    private long mLastCollectionTimeStamp;
    private WifiActivityEnergyInfo mLastWifiInfo;
    private boolean mOnBattery;
    private boolean mOnBatteryScreenOff;
    private int[] mPerDisplayScreenStates;
    private PowerStatsInternal mPowerStatsInternal;
    private int mScreenState;
    private final BatteryStatsImpl mStats;
    private final Runnable mSyncTask;
    private TelephonyManager mTelephony;
    private int mUpdateFlags;
    private boolean mUseLatestStates;
    private WifiManager mWifiManager;
    private final Object mWorkerLock;
    private final Runnable mWriteTask;

    public static class Injector {
        private final Context mContext;

        Injector(Context context) {
            this.mContext = context;
        }

        public <T> T getSystemService(Class<T> r2) {
            return (T) this.mContext.getSystemService(r2);
        }

        public <T> T getLocalService(Class<T> r2) {
            return (T) LocalServices.getService(r2);
        }
    }

    public static /* synthetic */ void $r8$lambda$09au3fz9zJxz1a0C4NtyPAvX438(BatteryExternalStatsWorker r0) {
        r0.lambda$scheduleCpuSyncDueToWakelockChange$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$0Qt5-WUKKSnrPDZAFOdvVci2W08, reason: not valid java name */
    public static /* synthetic */ void m7689$r8$lambda$0Qt5WUKKSnrPDZAFOdvVci2W08(BatteryExternalStatsWorker r0, int r1) {
        r0.lambda$scheduleCleanupDueToRemovedUser$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$C4q7eJQP9Ur2raY6hyEazsDUoLs(BatteryExternalStatsWorker r0, int r1) {
        r0.lambda$scheduleSyncDueToProcessStateChange$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$HU6SYqtwtE9YRIx-15RXxWLIshE, reason: not valid java name */
    public static /* synthetic */ void m7690$r8$lambda$HU6SYqtwtE9YRIx15RXxWLIshE(BatteryExternalStatsWorker r0, int r1) {
        r0.lambda$scheduleCleanupDueToRemovedUser$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$qkuzv3tC2WN77bJINOBCjoiDeio(SynchronousResultReceiver r0, WifiActivityEnergyInfo r1) {
        lambda$updateExternalStatsLocked$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$wchZeRT4nlzYK6ffE_ns17IfYeI(BatteryExternalStatsWorker r0) {
        r0.lambda$scheduleCpuSyncDueToWakelockChange$1();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentReason, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7691$$Nest$fgetmCurrentReason(BatteryExternalStatsWorker r0) {
        return r0.mCurrentReason;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOnBattery, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7692$$Nest$fgetmOnBattery(BatteryExternalStatsWorker r0) {
        return r0.mOnBattery;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOnBatteryScreenOff, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7693$$Nest$fgetmOnBatteryScreenOff(BatteryExternalStatsWorker r0) {
        return r0.mOnBatteryScreenOff;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPerDisplayScreenStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m7694$$Nest$fgetmPerDisplayScreenStates(BatteryExternalStatsWorker r0) {
        return r0.mPerDisplayScreenStates;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScreenState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7695$$Nest$fgetmScreenState(BatteryExternalStatsWorker r0) {
        return r0.mScreenState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryStatsImpl m7696$$Nest$fgetmStats(BatteryExternalStatsWorker r0) {
        return r0.mStats;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUpdateFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7697$$Nest$fgetmUpdateFlags(BatteryExternalStatsWorker r0) {
        return r0.mUpdateFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUseLatestStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7698$$Nest$fgetmUseLatestStates(BatteryExternalStatsWorker r0) {
        return r0.mUseLatestStates;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWorkerLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7699$$Nest$fgetmWorkerLock(BatteryExternalStatsWorker r0) {
        return r0.mWorkerLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentReason, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7700$$Nest$fputmCurrentReason(BatteryExternalStatsWorker r0, String r1) {
        r0.mCurrentReason = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastCollectionTimeStamp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7701$$Nest$fputmLastCollectionTimeStamp(BatteryExternalStatsWorker r0, long r1) {
        r0.mLastCollectionTimeStamp = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUpdateFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7702$$Nest$fputmUpdateFlags(BatteryExternalStatsWorker r0, int r1) {
        r0.mUpdateFlags = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUseLatestStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7703$$Nest$fputmUseLatestStates(BatteryExternalStatsWorker r0, boolean r1) {
        r0.mUseLatestStates = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelSyncDueToBatteryLevelChangeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7704$$Nest$mcancelSyncDueToBatteryLevelChangeLocked(BatteryExternalStatsWorker r0) {
        r0.cancelSyncDueToBatteryLevelChangeLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateExternalStatsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7705$$Nest$mupdateExternalStatsLocked(BatteryExternalStatsWorker r0, String r1, int r2, boolean r3, boolean r4, int r5, int[] r6, boolean r7) {
        r0.updateExternalStatsLocked(r1, r2, r3, r4, r5, r6, r7);
    }

    public BatteryExternalStatsWorker(Context context, BatteryStatsImpl stats, Handler handler) {
        this(new Injector(context), stats, handler);
    }

    BatteryExternalStatsWorker(Injector injector, BatteryStatsImpl stats, Handler handler) {
        this.mUpdateFlags = 0;
        this.mCurrentReason = null;
        this.mUseLatestStates = true;
        this.mWorkerLock = new Object();
        this.mWifiManager = null;
        this.mTelephony = null;
        this.mPowerStatsInternal = null;
        this.mLastWifiInfo = null;
        this.mEnergyConsumerTypeToIdMap = null;
        this.mEnergyConsumerSnapshot = null;
        this.mSyncTask = new AnonymousClass1(this);
        this.mWriteTask = new AnonymousClass2(this);
        this.mInjector = injector;
        this.mStats = stats;
        this.mHandler = handler;
    }

    public void systemServicesReady() {
        WifiManager wm = (WifiManager) this.mInjector.getSystemService(WifiManager.class);
        TelephonyManager tm = (TelephonyManager) this.mInjector.getSystemService(TelephonyManager.class);
        PowerStatsInternal psi = (PowerStatsInternal) this.mInjector.getLocalService(PowerStatsInternal.class);
        BatteryStatsImpl r3 = this.mStats;
        monitor-enter(r3);
        int voltageMv = this.mStats.getBatteryVoltageMvLocked();     // Catch: Throwable -> L36
        monitor-exit(r3);     // Catch: Throwable -> L36
        Object r5 = this.mWorkerLock;
        monitor-enter(r5);
        this.mWifiManager = wm;     // Catch: Throwable -> L15
        this.mTelephony = tm;     // Catch: Throwable -> L15
        this.mPowerStatsInternal = psi;     // Catch: Throwable -> L15
        boolean[] supportedStdBuckets = null;
        String[] customBucketNames = null;
        if (this.mPowerStatsInternal == null) goto L25;
        SparseArray<EnergyConsumer> idToConsumer = populateEnergyConsumerSubsystemMapsLocked();     // Catch: Throwable -> L15
        if (idToConsumer == null) goto L25;
        this.mEnergyConsumerSnapshot = new EnergyConsumerSnapshot(idToConsumer);     // Catch: Throwable -> L15
        EnergyConsumerResult[] initialEcrs = getEnergyConsumptionData().get(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L15 ExecutionException -> L17 Throwable -> L19
        this.mEnergyConsumerSnapshot.updateAndGetDelta(initialEcrs, voltageMv);     // Catch: Throwable -> L15 ExecutionException -> L17 Throwable -> L19
    L24:
        customBucketNames = this.mEnergyConsumerSnapshot.getOtherOrdinalNames();     // Catch: Throwable -> L15
        supportedStdBuckets = getSupportedEnergyBuckets(idToConsumer);     // Catch: Throwable -> L15
        goto L25
    L19:
        e = move-exception;
        Slog.w(TAG, "timeout or interrupt reading initial getEnergyConsumedAsync: " + e);     // Catch: Throwable -> L15
    L17:
        e = move-exception;
        Slog.wtf(TAG, "exception reading initial getEnergyConsumedAsync: " + e.getCause());     // Catch: Throwable -> L15
    L25:
        BatteryStatsImpl r7 = this.mStats;     // Catch: Throwable -> L15
        monitor-enter(r7);     // Catch: Throwable -> L15
        this.mStats.initEnergyConsumerStatsLocked(supportedStdBuckets, customBucketNames);     // Catch: Throwable -> L31
        this.mPerDisplayScreenStates = new int[this.mStats.getDisplayCount()];     // Catch: Throwable -> L31
        monitor-exit(r7);     // Catch: Throwable -> L31
        monitor-exit(r5);     // Catch: Throwable -> L15
        return;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L36:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.power.stats.BatteryStatsImpl.ExternalStatsSync
    public synchronized void scheduleSync(String reason, int flags) {
        monitor-enter(this);
        scheduleSyncLocked(reason, flags);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.power.stats.BatteryStatsImpl.ExternalStatsSync
    public synchronized void scheduleCpuSyncDueToRemovedUid(int uid) {
        monitor-enter(this);
        scheduleSyncLocked("remove-uid", 1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.power.stats.BatteryStatsImpl.ExternalStatsSync
    public void scheduleSyncDueToScreenStateChange(int flags, boolean onBattery, boolean onBatteryScreenOff, int screenState, int[] perDisplayScreenStates) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mHandler.hasMessages(1) == false) goto L10;
        if ((this.mUpdateFlags & 1) == 0) goto L10;
    L11:
        this.mScreenState = screenState;     // Catch: Throwable -> L8
        this.mPerDisplayScreenStates = perDisplayScreenStates;     // Catch: Throwable -> L8
        scheduleSyncLocked("screen-state", flags);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.mOnBattery = onBattery;     // Catch: Throwable -> L8
        this.mOnBatteryScreenOff = onBatteryScreenOff;     // Catch: Throwable -> L8
        this.mUseLatestStates = false;     // Catch: Throwable -> L8
        goto L11
    }

    @Override // com.android.server.power.stats.BatteryStatsImpl.ExternalStatsSync
    public void scheduleCpuSyncDueToWakelockChange(long delayMillis) {
        monitor-enter(this);
        scheduleDelayedSyncLocked(2, new BatteryExternalStatsWorker$$ExternalSyntheticLambda0(this), delayMillis);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$scheduleCpuSyncDueToWakelockChange$1() {
        scheduleSync("wakelock-change", 1);
        scheduleRunnable(new BatteryExternalStatsWorker$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$scheduleCpuSyncDueToWakelockChange$0() {
        this.mStats.postBatteryNeedsCpuUpdateMsg();
    }

    @Override // com.android.server.power.stats.BatteryStatsImpl.ExternalStatsSync
    public void cancelCpuSyncDueToWakelockChange() {
        this.mHandler.removeMessages(2);
    }

    private void cancelSyncDueToBatteryLevelChangeLocked() {
        this.mHandler.removeMessages(3);
    }

    @Override // com.android.server.power.stats.BatteryStatsImpl.ExternalStatsSync
    public void scheduleSyncDueToProcessStateChange(final int flags, long delayMillis) {
        monitor-enter(this);
        scheduleDelayedSyncLocked(4, new BatteryExternalStatsWorker$$ExternalSyntheticLambda2(this, flags), delayMillis);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$scheduleSyncDueToProcessStateChange$2(int flags) {
        scheduleSync("procstate-change", flags);
    }

    public void cancelSyncDueToProcessStateChange() {
        this.mHandler.removeMessages(4);
    }

    @Override // com.android.server.power.stats.BatteryStatsImpl.ExternalStatsSync
    public void scheduleCleanupDueToRemovedUser(final int userId) {
        this.mHandler.postDelayed(new BatteryExternalStatsWorker$$ExternalSyntheticLambda4(this, userId), 5, 2000);
        this.mHandler.postDelayed(new BatteryExternalStatsWorker$$ExternalSyntheticLambda5(this, userId), 5, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    private /* synthetic */ void lambda$scheduleCleanupDueToRemovedUser$3(int userId) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.clearRemovedUserUidsLocked(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$scheduleCleanupDueToRemovedUser$4(int userId) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.clearRemovedUserUidsLocked(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void scheduleDelayedSyncLocked(int what, Runnable syncRunnable, long delayMillis) {
        if (this.mHandler.hasMessages(what) == true) goto L5;
    L8:
        this.mHandler.postDelayed(syncRunnable, what, delayMillis);
        return;
    L5:
        if (delayMillis != 0) goto L7;
        this.mHandler.removeMessages(what);
        goto L8
    }

    public synchronized void scheduleWrite() {
        monitor-enter(this);
        scheduleSyncLocked("write", 127);     // Catch: Throwable -> L6
        this.mHandler.post(this.mWriteTask);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void scheduleRunnable(Runnable runnable) {
        monitor-enter(this);
        this.mHandler.post(runnable);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void shutdown() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(4);
        this.mHandler.removeMessages(5);
    }

    private void scheduleSyncLocked(String reason, int flags) {
        if (this.mHandler.hasMessages(1) == true) goto L5;
        this.mUpdateFlags = flags;
        this.mCurrentReason = reason;
        this.mHandler.postDelayed(this.mSyncTask, 1, 0);
    L5:
        this.mUpdateFlags |= flags;
    }

    public long getLastCollectionTimeStamp() {
        monitor-enter(this);
        long r0 = this.mLastCollectionTimeStamp;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private void updateExternalStatsLocked(String reason, int updateFlags, boolean onBattery, boolean onBatteryScreenOff, int screenState, int[] displayScreenStates, boolean useLatestStates) {
        SynchronousResultReceiver bluetoothReceiver = null;
        CompletableFuture<ModemActivityInfo> modemFuture = CompletableFuture.completedFuture(null);
        boolean railUpdated = false;
        CompletableFuture<EnergyConsumerResult[]> futureECRs = getEnergyConsumersLocked(updateFlags);
        if ((updateFlags & 2) != 0) goto L5;
        final SynchronousResultReceiver tempWifiReceiver = null;
    L20:
        if ((updateFlags & 8) == 0) goto L28;
        PowerStatsCollector collector = this.mStats.getPowerStatsCollector(2);
        if (collector.isEnabled() == false) goto L24;
        collector.schedule();
        goto L28
    L24:
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter == null) goto L28;
        final SynchronousResultReceiver resultReceiver = new SynchronousResultReceiver("bluetooth");
        adapter.requestControllerActivityEnergyInfo(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new AnonymousClass4(this, resultReceiver));
        bluetoothReceiver = resultReceiver;
    L28:
        if ((updateFlags & 4) == 0) goto L45;
        PowerStatsCollector collector2 = this.mStats.getPowerStatsCollector(8);
        if (collector2.isEnabled() == false) goto L33;
        collector2.schedule();
    L35:
        if (railUpdated == true) goto L45;
        BatteryStatsImpl r9 = this.mStats;
        monitor-enter(r9);
        this.mStats.updateRailStatsLocked();     // Catch: Throwable -> L41
        monitor-exit(r9);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    L33:
        if (this.mTelephony == null) goto L35;
        final CompletableFuture<ModemActivityInfo> temp = new CompletableFuture();
        this.mTelephony.requestModemActivityInfo(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new AnonymousClass5(this, temp));
        modemFuture = temp;
    L45:
        if ((updateFlags & 16) == 0) goto L47;
        this.mStats.fillLowPowerStats();
    L47:
        WifiActivityEnergyInfo wifiInfo = (WifiActivityEnergyInfo) awaitControllerInfo(tempWifiReceiver);
        BluetoothActivityEnergyInfo bluetoothInfo = awaitControllerInfo(bluetoothReceiver);
        ModemActivityInfo modemInfo = modemFuture.get(2000, TimeUnit.MILLISECONDS);     // Catch: ExecutionException -> L50 Throwable -> L52
        ModemActivityInfo modemInfo2 = modemInfo;
    L58:
        if (this.mEnergyConsumerSnapshot == null) goto L77;
        if (futureECRs == null) goto L77;
        BatteryStatsImpl r10 = this.mStats;
        monitor-enter(r10);
        int voltageMv = this.mStats.getBatteryVoltageMvLocked();     // Catch: Throwable -> L74
        monitor-exit(r10);     // Catch: Throwable -> L74
        EnergyConsumerResult[] ecrs = futureECRs.get(2000, TimeUnit.MILLISECONDS);     // Catch: ExecutionException -> L67 Throwable -> L69
    L73:
        EnergyConsumerSnapshot.EnergyConsumerDeltaData energyConsumerDeltas = this.mEnergyConsumerSnapshot.updateAndGetDelta(ecrs, voltageMv);
    L78:
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptime = SystemClock.uptimeMillis();
        long elapsedRealtimeUs = elapsedRealtime * 1000;
        long r27 = uptime * 1000;
        BatteryStatsImpl r11 = this.mStats;
        monitor-enter(r11);
        this.mStats.recordHistoryEventLocked(elapsedRealtime, uptime, 14, reason, 0);     // Catch: Throwable -> L196
        long elapsedRealtime2 = elapsedRealtime;
        if ((updateFlags & 1) == 0) goto L103;
        if (useLatestStates == true) goto L206;
        boolean onBattery2 = onBattery;
        boolean onBatteryScreenOff2 = onBatteryScreenOff;
    L93:
        if (energyConsumerDeltas != null) goto L230;
        long[] cpuClusterChargeUC = null;
    L220:
        this.mStats.updateCpuTimeLocked(onBattery2, onBatteryScreenOff2, cpuClusterChargeUC);     // Catch: Throwable -> L99
        boolean onBattery3 = onBattery2;
    L105:
        if ((updateFlags & 127) != 127) goto L110;
        this.mStats.updateKernelWakelocksLocked(elapsedRealtimeUs);     // Catch: Throwable -> L107
        this.mStats.updateKernelMemoryBandwidthLocked(elapsedRealtimeUs);     // Catch: Throwable -> L107
    L107:
        th = th;
        BatteryStatsImpl r5 = r11;
    L236:
        monitor-exit(r5);     // Catch: Throwable -> L200
        throw th;
    L200:
        th = th;
    L110:
        if ((updateFlags & 16) == 0) goto L112;
        this.mStats.updateRpmStatsLocked(elapsedRealtimeUs);     // Catch: Throwable -> L107
    L112:
        long mobileRadioChargeUC = -1;
        if (energyConsumerDeltas != null) goto L204;
        boolean onBattery4 = onBattery3;
    L138:
        if (energyConsumerDeltas != null) goto L210;
    L153:
        long elapsedRealtime3 = elapsedRealtime2;
    L154:
        if (bluetoothInfo != null) goto L216;
        r5 = r11;
    L208:
        monitor-exit(r5);     // Catch: Throwable -> L194
        if (wifiInfo != null) goto L181;
    L187:
        if (modemInfo2 == null) goto L193;
        if (energyConsumerDeltas == 0) goto L191;
        mobileRadioChargeUC = energyConsumerDeltas.mobileRadioChargeUC;
    L191:
        NetworkStatsManager networkStatsManager = (NetworkStatsManager) this.mInjector.getSystemService(NetworkStatsManager.class);
        this.mStats.noteModemControllerActivity(modemInfo2, mobileRadioChargeUC, elapsedRealtime3, uptime, networkStatsManager);
        return;
    L193:
        return;
    L181:
        if (wifiInfo.isValid() == false) goto L186;
        if (energyConsumerDeltas == 0) goto L184;
        long wifiChargeUC = energyConsumerDeltas.wifiChargeUC;
    L185:
        NetworkStatsManager networkStatsManager2 = (NetworkStatsManager) this.mInjector.getSystemService(NetworkStatsManager.class);
        long elapsedRealtime4 = elapsedRealtime3;
        this.mStats.updateWifiState(extractDeltaLocked(wifiInfo), wifiChargeUC, elapsedRealtime4, uptime, networkStatsManager2);
        elapsedRealtime3 = elapsedRealtime4;
        uptime = uptime;
        goto L187
    L184:
        wifiChargeUC = -1;
        goto L185
    L186:
        Slog.w(TAG, "wifi info is invalid: " + wifiInfo);
    L194:
        th = th;
        goto L236
    L216:
        if (bluetoothInfo.isValid() == false) goto L170;
        if (energyConsumerDeltas == null) goto L160;
        long btChargeUC = energyConsumerDeltas.bluetoothChargeUC;     // Catch: Throwable -> L148
    L238:
        r5 = r11;
        this.mStats.updateBluetoothStateLocked(bluetoothInfo, btChargeUC, elapsedRealtime3, uptime);     // Catch: Throwable -> L166
    L166:
        th = th;
    L168:
        th = th;
        r5 = r11;
    L148:
        th = th;
        r5 = r11;
        goto L236
    L160:
        btChargeUC = -1;
        goto L238
    L170:
        r5 = r11;
        Slog.w(TAG, "bluetooth info is invalid: " + bluetoothInfo);     // Catch: Throwable -> L173
    L173:
        th = th;
    L175:
        th = th;
        r5 = r11;
        goto L236
    L210:
    L150:
        th = th;
        r5 = r11;
        goto L236
    L140:
        if (energyConsumerDeltas.otherTotalChargeUC == null) goto L153;
        int ord = 0;
    L143:
        if (ord >= energyConsumerDeltas.otherTotalChargeUC.length) goto L152;
        long totalEnergy = energyConsumerDeltas.otherTotalChargeUC[ord];     // Catch: Throwable -> L150
        SparseLongArray uidEnergies = energyConsumerDeltas.otherUidChargesUC[ord];     // Catch: Throwable -> L150
        long elapsedRealtime5 = elapsedRealtime2;
        this.mStats.updateCustomEnergyConsumerStatsLocked(ord, totalEnergy, uidEnergies);     // Catch: Throwable -> L148
        ord = ord + 1;
        elapsedRealtime2 = elapsedRealtime5;
        goto L143
    L152:
        elapsedRealtime3 = elapsedRealtime2;
        goto L154
    L204:
        long[] displayChargeUC = energyConsumerDeltas.displayChargeUC;     // Catch: Throwable -> L135
        if (displayChargeUC == null) goto L125;
    L122:
        th = th;
        r5 = r11;
        goto L236
    L117:
        if (displayChargeUC.length <= 0) goto L125;
        this.mStats.updateDisplayEnergyConsumerStatsLocked(displayChargeUC, displayScreenStates, elapsedRealtime2);     // Catch: Throwable -> L107
    L125:
        onBattery4 = onBattery3;
        long gnssChargeUC = energyConsumerDeltas.gnssChargeUC;     // Catch: Throwable -> L129
        if (gnssChargeUC == (-1)) goto L131;
        this.mStats.updateGnssEnergyConsumerStatsLocked(gnssChargeUC, elapsedRealtime2);     // Catch: Throwable -> L129
    L131:
        long gnssChargeUC2 = energyConsumerDeltas.cameraChargeUC;     // Catch: Throwable -> L129
        if (gnssChargeUC2 == (-1)) goto L138;
        this.mStats.updateCameraEnergyConsumerStatsLocked(gnssChargeUC2, elapsedRealtime2);     // Catch: Throwable -> L129
    L129:
        th = th;
        r5 = r11;
    L135:
        th = th;
        r5 = r11;
    L99:
        th = th;
        r5 = r11;
        goto L236
    L230:
        cpuClusterChargeUC = energyConsumerDeltas.cpuClusterChargeUC;     // Catch: Throwable -> L101
    L101:
        th = th;
        r5 = r11;
        goto L236
    L206:
        onBattery2 = this.mStats.isOnBatteryLocked();     // Catch: Throwable -> L90
        onBatteryScreenOff2 = this.mStats.isOnBatteryScreenOffLocked();     // Catch: Throwable -> L88
    L88:
        th = th;
        r5 = r11;
    L90:
        th = th;
        r5 = r11;
        goto L236
    L103:
        onBattery3 = onBattery;
    L196:
        th = th;
        r5 = r11;
        goto L236
    L69:
        e = move-exception;
        Slog.w(TAG, "timeout or interrupt reading getEnergyConsumedAsync: " + e);
        ecrs = null;
    L67:
        e = move-exception;
        Slog.wtf(TAG, "exception reading getEnergyConsumedAsync: " + e.getCause());
        ecrs = null;
    L74:
        th = move-exception;
        throw th;
    L77:
        energyConsumerDeltas = null;
        goto L78
    L52:
        e = move-exception;
        Slog.w(TAG, "timeout or interrupt reading modem stats: " + e);
    L56:
        modemInfo2 = null;
    L50:
        e = move-exception;
        Slog.w(TAG, "exception reading modem stats: " + e.getCause());
        goto L56
    L5:
        if (this.mWifiManager != null) goto L7;
    L9:
        tempWifiReceiver = null;
    L10:
        BatteryStatsImpl r8 = this.mStats;
        monitor-enter(r8);
        this.mStats.updateRailStatsLocked();     // Catch: Throwable -> L15
        monitor-exit(r8);     // Catch: Throwable -> L15
        railUpdated = true;
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.mWifiManager.isEnhancedPowerReportingSupported() == false) goto L9;
        tempWifiReceiver = new SynchronousResultReceiver("wifi");
        this.mWifiManager.getWifiActivityEnergyInfoAsync(new AnonymousClass3(this), new BatteryExternalStatsWorker$$ExternalSyntheticLambda3(tempWifiReceiver));
        goto L10
    }

    private static /* synthetic */ void lambda$updateExternalStatsLocked$5(SynchronousResultReceiver tempWifiReceiver, WifiActivityEnergyInfo info) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("controller_activity", info);
        tempWifiReceiver.send(0, bundle);
    }

    private static <T extends Parcelable> T awaitControllerInfo(SynchronousResultReceiver r4) {
        if (r4 != null) goto L16;
        return null;
    L16:
        SynchronousResultReceiver.Result r1 = r4.awaitResult(2000);     // Catch: TimeoutException -> L11
        if (r1.bundle == null) goto L15;
        r1.bundle.setDefusable(true);     // Catch: TimeoutException -> L11
        T r2 = (T) r1.bundle.getParcelable("controller_activity");
        if (r2 == null) goto L15;
        return r2;
    L15:
        return null;
    L14:
        Slog.w(TAG, "timeout reading " + r4.getName() + " stats");
        goto L15
    }

    public WifiActivityEnergyInfo extractDeltaLocked(WifiActivityEnergyInfo latest) {
        if (this.mLastWifiInfo != null) goto L5;
        this.mLastWifiInfo = latest;
    L5:
        long timePeriodMs = latest.getTimeSinceBootMillis() - this.mLastWifiInfo.getTimeSinceBootMillis();
        long lastScanMs = this.mLastWifiInfo.getControllerScanDurationMillis();
        long lastIdleMs = this.mLastWifiInfo.getControllerIdleDurationMillis();
        long lastTxMs = this.mLastWifiInfo.getControllerTxDurationMillis();
        long lastRxMs = this.mLastWifiInfo.getControllerRxDurationMillis();
        long lastEnergy = this.mLastWifiInfo.getControllerEnergyUsedMicroJoules();
        long deltaTimeSinceBootMillis = latest.getTimeSinceBootMillis();
        int deltaStackState = latest.getStackState();
        long txTimeMs = latest.getControllerTxDurationMillis() - lastTxMs;
        long rxTimeMs = latest.getControllerRxDurationMillis() - lastRxMs;
        long idleTimeMs = latest.getControllerIdleDurationMillis() - lastIdleMs;
        long scanTimeMs = latest.getControllerScanDurationMillis() - lastScanMs;
        if (txTimeMs < 0) goto L16;
        if (rxTimeMs < 0) goto L16;
        if (scanTimeMs < 0) goto L16;
        if (idleTimeMs < 0) goto L16;
        long deltaControllerTxDurationMillis = txTimeMs;
        long deltaControllerRxDurationMillis = rxTimeMs;
        long deltaControllerScanDurationMillis = scanTimeMs;
        long deltaControllerIdleDurationMillis = idleTimeMs;
        long lastScanMs2 = latest.getControllerEnergyUsedMicroJoules() - lastEnergy;
        long deltaControllerEnergyUsedMicroJoules = Math.max(0, lastScanMs2);
        boolean wasReset = false;
        long deltaControllerEnergyUsedMicroJoules2 = deltaControllerEnergyUsedMicroJoules;
    L21:
        this.mLastWifiInfo = latest;
        WifiActivityEnergyInfo delta = new WifiActivityEnergyInfo(deltaTimeSinceBootMillis, deltaStackState, deltaControllerTxDurationMillis, deltaControllerRxDurationMillis, deltaControllerScanDurationMillis, deltaControllerIdleDurationMillis, deltaControllerEnergyUsedMicroJoules2);
        if (wasReset == false) goto L24;
        Slog.v(TAG, "WiFi energy data was reset, new WiFi energy data is " + delta);
    L24:
        return delta;
    L16:
        long totalOnTimeMs = (latest.getControllerTxDurationMillis() + latest.getControllerRxDurationMillis()) + latest.getControllerIdleDurationMillis();
        if (totalOnTimeMs > (timePeriodMs + MAX_WIFI_STATS_SAMPLE_ERROR_MILLIS)) goto L19;
        long deltaControllerEnergyUsedMicroJoules3 = latest.getControllerEnergyUsedMicroJoules();
        long deltaControllerRxDurationMillis2 = latest.getControllerRxDurationMillis();
        long deltaControllerTxDurationMillis2 = latest.getControllerTxDurationMillis();
        long deltaControllerIdleDurationMillis2 = latest.getControllerIdleDurationMillis();
        deltaControllerRxDurationMillis = deltaControllerRxDurationMillis2;
        deltaControllerTxDurationMillis = deltaControllerTxDurationMillis2;
        deltaControllerIdleDurationMillis = deltaControllerIdleDurationMillis2;
        deltaControllerScanDurationMillis = latest.getControllerScanDurationMillis();
    L20:
        deltaControllerEnergyUsedMicroJoules2 = deltaControllerEnergyUsedMicroJoules3;
        wasReset = true;
        goto L21
    L19:
        deltaControllerEnergyUsedMicroJoules3 = 0;
        deltaControllerRxDurationMillis = 0;
        deltaControllerTxDurationMillis = 0;
        deltaControllerIdleDurationMillis = 0;
        deltaControllerScanDurationMillis = 0;
        goto L20
    }

    private static boolean[] getSupportedEnergyBuckets(SparseArray<EnergyConsumer> idToConsumer) {
        if (idToConsumer != null) goto L5;
        return null;
    L5:
        boolean[] buckets = new boolean[10];
        int size = idToConsumer.size();
        int idx = 0;
    L6:
        if (idx >= size) goto L19;
        EnergyConsumer consumer = idToConsumer.valueAt(idx);
        switch(consumer.type) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L17;
        };
    L10:
        buckets[8] = true;
        goto L17
    L11:
        buckets[4] = true;
        goto L17
    L12:
        buckets[7] = true;
        buckets[9] = true;
        goto L17
    L13:
        buckets[6] = true;
        goto L17
    L14:
        buckets[0] = true;
        buckets[1] = true;
        buckets[2] = true;
        goto L17
    L15:
        buckets[3] = true;
        goto L17
    L16:
        buckets[5] = true;
    L17:
        idx = idx + 1;
        goto L6
    L19:
        return buckets;
    }

    private CompletableFuture<EnergyConsumerResult[]> getEnergyConsumptionData() {
        return getEnergyConsumptionData(new int[0]);
    }

    private CompletableFuture<EnergyConsumerResult[]> getEnergyConsumptionData(int[] consumerIds) {
        return this.mPowerStatsInternal.getEnergyConsumedAsync(consumerIds);
    }

    public CompletableFuture<EnergyConsumerResult[]> getEnergyConsumersLocked(int flags) {
        if (this.mEnergyConsumerSnapshot != null) goto L5;
    L34:
        return null;
    L5:
        if (this.mPowerStatsInternal == null) goto L34;
        if (flags == 127) goto L10;
        IntArray energyConsumerIds = new IntArray();
        if ((flags & 8) == 0) goto L15;
        addEnergyConsumerIdLocked(energyConsumerIds, 1);
    L15:
        if ((flags & 1) == 0) goto L18;
        addEnergyConsumerIdLocked(energyConsumerIds, 2);
    L18:
        if ((flags & 32) == 0) goto L21;
        addEnergyConsumerIdLocked(energyConsumerIds, 3);
    L21:
        if ((flags & 4) == 0) goto L24;
        addEnergyConsumerIdLocked(energyConsumerIds, 5);
    L24:
        if ((flags & 2) == 0) goto L27;
        addEnergyConsumerIdLocked(energyConsumerIds, 6);
    L27:
        if ((flags & 64) == 0) goto L30;
        addEnergyConsumerIdLocked(energyConsumerIds, 7);
    L30:
        if (energyConsumerIds.size() != 0) goto L33;
        return null;
    L33:
        return getEnergyConsumptionData(energyConsumerIds.toArray());
    L10:
        return getEnergyConsumptionData();
    }

    private void addEnergyConsumerIdLocked(IntArray energyConsumerIds, int type) {
        int[] consumerIds = this.mEnergyConsumerTypeToIdMap.get(type);
        if (consumerIds != null) goto L5;
        return;
    L5:
        energyConsumerIds.addAll(consumerIds);
    }

    private SparseArray<EnergyConsumer> populateEnergyConsumerSubsystemMapsLocked() {
        if (this.mPowerStatsInternal != null) goto L5;
        return null;
    L5:
        EnergyConsumer[] energyConsumers = this.mPowerStatsInternal.getEnergyConsumerInfo();
        if (energyConsumers != null) goto L8;
    L28:
        return null;
    L8:
        if (energyConsumers.length == 0) goto L28;
        SparseArray<EnergyConsumer> idToConsumer = new SparseArray(energyConsumers.length);
        SparseArray<IntArray> tempTypeToId = new SparseArray();
        int r3 = energyConsumers.length;
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L23;
        EnergyConsumer consumer = energyConsumers[r4];
        if (consumer.ordinal != 0) goto L15;
    L18:
        idToConsumer.put(consumer.id, consumer);
        IntArray ids = tempTypeToId.get(consumer.type);
        if (ids != null) goto L21;
        ids = new IntArray();
        tempTypeToId.put(consumer.type, ids);
    L21:
        ids.add(consumer.id);
    L22:
        r4 = r4 + 1;
        goto L11
    L15:
        switch(consumer.type) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L18;
            case 3: goto L18;
            default: goto L16;
        };
    L16:
        Slog.w(TAG, "EnergyConsumer '" + consumer.name + "' has unexpected ordinal " + consumer.ordinal + " for type " + consumer.type);
        goto L22
    L23:
        this.mEnergyConsumerTypeToIdMap = new SparseArray(tempTypeToId.size());
        int size = tempTypeToId.size();
        int i = 0;
    L24:
        if (i >= size) goto L27;
        int consumerType = tempTypeToId.keyAt(i);
        int[] consumerIds = tempTypeToId.valueAt(i).toArray();
        this.mEnergyConsumerTypeToIdMap.put(consumerType, consumerIds);
        i = i + 1;
        goto L24
    L27:
        return idToConsumer;
    }
}
