package com.android.server.power.stats;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppRecordManager;
import android.app.InfoData;
import android.app.usage.NetworkStatsManager;
import android.bluetooth.BluetoothActivityEnergyInfo;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.UidTraffic;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkStats;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.BatteryConsumer;
import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.Binder;
import android.os.BluetoothBatteryStats;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.IBatteryPropertiesRegistrar;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.WakeLockStats;
import android.os.WorkSource;
import android.os.connectivity.CellularBatteryStats;
import android.os.connectivity.GpsBatteryStats;
import android.os.connectivity.WifiActivityEnergyInfo;
import android.os.connectivity.WifiBatteryStats;
import android.power.PowerStatsInternal;
import android.provider.Settings;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.ModemActivityInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.IndentingPrintWriter;
import android.util.KeyValueListParser;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.LongSparseLongArray;
import android.util.MutableInt;
import android.util.Printer;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseDoubleArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import android.util.Xml;
import android.view.Display;
import com.android.internal.logging.EventLogTags;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.BatteryStatsHistory;
import com.android.internal.os.BatteryStatsHistoryIterator;
import com.android.internal.os.BinderCallsStats;
import com.android.internal.os.BinderTransactionNameResolver;
import com.android.internal.os.Clock;
import com.android.internal.os.CpuScalingPolicies;
import com.android.internal.os.KernelCpuSpeedReader;
import com.android.internal.os.KernelCpuUidTimeReader;
import com.android.internal.os.KernelMemoryBandwidthStats;
import com.android.internal.os.KernelSingleUidTimeReader;
import com.android.internal.os.LongArrayMultiStateCounter;
import com.android.internal.os.LongMultiStateCounter;
import com.android.internal.os.MonotonicClock;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.PowerStats;
import com.android.internal.os.RailStats;
import com.android.internal.os.RpmStats;
import com.android.internal.power.EnergyConsumerStats;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.ProcessList;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.autofill.HintsHelper;
import com.android.server.location.LocationLogsRecorder;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.power.feature.PowerManagerFlags;
import com.android.server.power.stats.format.MobileRadioPowerStatsLayout;
import com.android.server.power.teardown.swteardown.EventTeardownResult;
import com.android.server.scene.SceneUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import libcore.util.EmptyArray;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryStatsImpl extends BatteryStats {
    public static final int BATTERY_PLUGGED_NONE = 0;
    private static final int CELL_SIGNAL_STRENGTH_LEVEL_COUNT = 0;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_BINDER_STATS = false;
    public static final boolean DEBUG_ENERGY = false;
    private static final boolean DEBUG_ENERGY_CPU = false;
    private static final boolean DEBUG_MEMORY = false;
    static final long DELAY_UPDATE_WAKELOCKS = 60000;
    private static final String HISTORY_DIR = "battery-history";
    static final int MAX_DAILY_ITEMS = 10;
    static final int MAX_LEVEL_STEPS = 200;
    private static final int MAX_WAKELOCKS_PER_UID = 0;
    private static final double MILLISECONDS_IN_HOUR = 3600000.0d;
    private static final long MILLISECONDS_IN_YEAR = 31536000000L;
    private static final long MIN_BATTERY_SESSION_DURATION_MILLIS = 60000;
    protected static final long MOBILE_RADIO_POWER_STATE_UPDATE_FREQ_MS = 600000;
    private static final int MODEM_TX_POWER_LEVEL_COUNT = 0;
    static final int MSG_REPORT_CHARGING = 3;
    static final int MSG_REPORT_CPU_UPDATE_NEEDED = 1;
    static final int MSG_REPORT_POWER_CHANGE = 2;
    static final int MSG_REPORT_RESET_STATS = 4;
    private static final int NR_FREQUENCY_COUNT = 5;
    private static final int NUM_BT_TX_LEVELS = 1;
    private static final int NUM_WIFI_TX_LEVELS = 1;
    public static final int PER_UID_MODEM_POWER_MODEL_MOBILE_RADIO_ACTIVE_TIME = 1;
    public static final int PER_UID_MODEM_POWER_MODEL_MODEM_ACTIVITY_INFO_RX_TX = 2;
    private static final int PROC_STATE_TIME_COUNTER_STATE_COUNT = 8;
    public static final int RESET_REASON_ADB_COMMAND = 2;
    public static final int RESET_REASON_CORRUPT_FILE = 1;
    public static final int RESET_REASON_ENERGY_CONSUMER_BUCKETS_CHANGE = 4;
    public static final int RESET_REASON_FULL_CHARGE = 3;
    public static final int RESET_REASON_PLUGGED_IN_FOR_LONG_DURATION = 5;
    private static final long RPM_STATS_UPDATE_FREQ_MS = 1000;
    private static final int[] SUPPORTED_PER_PROCESS_STATE_STANDARD_ENERGY_BUCKETS = null;
    private static final String TAG = "BatteryStatsImpl";
    private static final int USB_DATA_CONNECTED = 2;
    private static final int USB_DATA_DISCONNECTED = 1;
    private static final int USB_DATA_UNKNOWN = 0;
    public static final int VERSION = 0;
    public static final int WAKE_LOCK_WEIGHT = 50;
    private static final BatteryStats.LongCounter ZERO_LONG_COUNTER = null;
    private static final BatteryStats.LongCounter[] ZERO_LONG_COUNTER_ARRAY = null;
    private boolean mAccumulateBatteryUsageStats;
    private final BatteryStats.HistoryEventTracker mActiveEvents;
    int mActiveRat;
    private AlarmManager mAlarmManager;
    int mAudioOnNesting;
    StopwatchTimer mAudioOnTimer;
    private final ArrayList<StopwatchTimer> mAudioTurnedOnTimers;
    private int mBatteryChargeUah;
    private int mBatteryHealth;
    private final BatteryHistoryDirectory mBatteryHistoryDirectory;
    private int mBatteryLevel;
    private int mBatteryPlugType;
    private boolean mBatteryPluggedIn;
    private long mBatteryPluggedInRealTimeMs;
    protected final BatteryStatsConfig mBatteryStatsConfig;
    private int mBatteryStatus;
    private int mBatteryTemperature;
    private long mBatteryTimeToFullSeconds;
    private BatteryUsageStatsProvider mBatteryUsageStatsProvider;
    private int mBatteryVoltageMv;
    private LongSamplingCounterArray mBinderThreadCpuTimesUs;
    ControllerActivityCounterImpl mBluetoothActivity;
    BluetoothPowerCalculator mBluetoothPowerCalculator;
    private final BluetoothPowerStatsCollector mBluetoothPowerStatsCollector;
    int mBluetoothScanNesting;
    private final ArrayList<StopwatchTimer> mBluetoothScanOnTimers;
    StopwatchTimer mBluetoothScanTimer;
    private BatteryCallback mCallback;
    int mCameraOnNesting;
    StopwatchTimer mCameraOnTimer;
    private final CameraPowerStatsCollector mCameraPowerStatsCollector;
    private final ArrayList<StopwatchTimer> mCameraTurnedOnTimers;
    final BatteryStats.LevelStepTracker mChargeStepTracker;
    boolean mCharging;
    public final AtomicFile mCheckinFile;
    protected Clock mClock;
    protected final Constants mConstants;
    private int[] mCpuPowerBracketMap;
    CpuPowerCalculator mCpuPowerCalculator;
    private final CpuPowerStatsCollector mCpuPowerStatsCollector;
    protected CpuScalingPolicies mCpuScalingPolicies;
    private long mCpuTimeReadsTrackingStartTimeMs;
    protected KernelCpuUidTimeReader.KernelCpuUidActiveTimeReader mCpuUidActiveTimeReader;
    protected KernelCpuUidTimeReader.KernelCpuUidClusterTimeReader mCpuUidClusterTimeReader;
    protected KernelCpuUidTimeReader.KernelCpuUidFreqTimeReader mCpuUidFreqTimeReader;
    protected KernelCpuUidTimeReader.KernelCpuUidUserSysTimeReader mCpuUidUserSysTimeReader;
    int mCurStepMode;
    private final CustomEnergyConsumerPowerStatsCollector mCustomEnergyConsumerPowerStatsCollector;
    final BatteryStats.LevelStepTracker mDailyChargeStepTracker;
    final BatteryStats.LevelStepTracker mDailyDischargeStepTracker;
    public final AtomicFile mDailyFile;
    final ArrayList<BatteryStats.DailyItem> mDailyItems;
    ArrayList<BatteryStats.PackageChange> mDailyPackageChanges;
    long mDailyStartTimeMs;
    private final Runnable mDeferSetCharging;
    int mDeviceIdleMode;
    StopwatchTimer mDeviceIdleModeFullTimer;
    StopwatchTimer mDeviceIdleModeLightTimer;
    boolean mDeviceIdling;
    StopwatchTimer mDeviceIdlingTimer;
    boolean mDeviceLightIdling;
    StopwatchTimer mDeviceLightIdlingTimer;
    int mDischargeAmountScreenDoze;
    int mDischargeAmountScreenDozeSinceCharge;
    int mDischargeAmountScreenOff;
    int mDischargeAmountScreenOffSinceCharge;
    int mDischargeAmountScreenOn;
    int mDischargeAmountScreenOnSinceCharge;
    private LongSamplingCounter mDischargeCounter;
    int mDischargeCurrentLevel;
    private LongSamplingCounter mDischargeDeepDozeCounter;
    private LongSamplingCounter mDischargeLightDozeCounter;
    int mDischargePlugLevel;
    private LongSamplingCounter mDischargeScreenDozeCounter;
    int mDischargeScreenDozeUnplugLevel;
    private LongSamplingCounter mDischargeScreenOffCounter;
    int mDischargeScreenOffUnplugLevel;
    int mDischargeScreenOnUnplugLevel;
    final BatteryStats.LevelStepTracker mDischargeStepTracker;
    int mDischargeUnplugLevel;
    private int mDisplayMismatchWtfCount;
    private final ArrayList<StopwatchTimer> mDrawTimers;
    String mEndPlatformVersion;
    public final EnergyStatsRetriever mEnergyConsumerRetriever;
    protected EnergyConsumerStats.Config mEnergyConsumerStatsConfig;
    private int mEstimatedBatteryCapacityMah;
    private ExternalStatsSync mExternalSync;
    int mFlashlightOnNesting;
    StopwatchTimer mFlashlightOnTimer;
    private final ArrayList<StopwatchTimer> mFlashlightTurnedOnTimers;
    WakelockStatsFrameworkEvents mFrameworkEvents;
    private final FrameworkStatsLogger mFrameworkStatsLogger;
    private final ArrayList<StopwatchTimer> mFullTimers;
    private final ArrayList<StopwatchTimer> mFullWifiLockTimers;
    protected EnergyConsumerStats mGlobalEnergyConsumerStats;
    boolean mGlobalWifiRunning;
    StopwatchTimer mGlobalWifiRunningTimer;
    private final GnssPowerStatsCollector mGnssPowerStatsCollector;
    int mGpsNesting;
    int mGpsSignalQualityBin;
    final StopwatchTimer[] mGpsSignalQualityTimer;
    public Handler mHandler;
    boolean mHasBluetoothReporting;
    boolean mHasModemReporting;
    boolean mHasWifiReporting;
    private boolean mHaveBatteryLevel;
    int mHighDischargeAmountSinceCharge;
    private final BatteryStatsHistory mHistory;
    boolean mIgnoreNextExternalStats;
    int mInitStepMode;
    boolean mInteractive;
    StopwatchTimer mInteractiveTimer;
    protected KernelCpuSpeedReader[] mKernelCpuSpeedReaders;
    private KernelMemoryBandwidthStats mKernelMemoryBandwidthStats;
    private final LongSparseArray<SamplingTimer> mKernelMemoryStats;
    protected KernelSingleUidTimeReader mKernelSingleUidTimeReader;
    protected KernelWakelockReader mKernelWakelockReader;
    private final HashMap<String, SamplingTimer> mKernelWakelockStats;
    private final BluetoothActivityInfoCache mLastBluetoothActivityInfo;
    int mLastChargeStepLevel;
    int mLastDischargeStepLevel;
    long mLastIdleTimeStartMs;
    private int mLastLearnedBatteryCapacityUah;
    private ModemActivityInfo mLastModemActivityInfo;
    private NetworkStats mLastModemNetworkStats;
    protected ArrayList<StopwatchTimer> mLastPartialTimers;
    private long mLastRpmStatsUpdateTimeMs;
    long mLastWakeupElapsedTimeMs;
    String mLastWakeupReason;
    long mLastWakeupUptimeMs;
    private NetworkStats mLastWifiNetworkStats;
    long mLastWriteTimeMs;
    private final AlarmManager.OnAlarmListener mLongPlugInAlarmHandler;
    long mLongestFullIdleTimeMs;
    long mLongestLightIdleTimeMs;
    int mLowDischargeAmountSinceCharge;
    int mMaxChargeStepLevel;
    private int mMaxLearnedBatteryCapacityUah;
    int mMinDischargeStepLevel;
    private int mMinLearnedBatteryCapacityUah;
    LongSamplingCounter mMobileRadioActiveAdjustedTime;
    StopwatchTimer mMobileRadioActivePerAppTimer;
    long mMobileRadioActiveStartTimeMs;
    StopwatchTimer mMobileRadioActiveTimer;
    LongSamplingCounter mMobileRadioActiveUnknownCount;
    LongSamplingCounter mMobileRadioActiveUnknownTime;
    MobileRadioPowerCalculator mMobileRadioPowerCalculator;
    int mMobileRadioPowerState;
    private final MobileRadioPowerStatsCollector mMobileRadioPowerStatsCollector;
    int mModStepMode;
    ControllerActivityCounterImpl mModemActivity;
    private String[] mModemIfaces;
    private final Object mModemNetworkLock;
    private final MonotonicClock mMonotonicClock;
    long mMonotonicEndTime;
    long mMonotonicStartTime;
    private boolean mMoveWscLoggingToNotifierEnabled;
    final LongSamplingCounter[] mNetworkByteActivityCounters;
    final LongSamplingCounter[] mNetworkPacketActivityCounters;
    long mNextMaxDailyDeadlineMs;
    long mNextMinDailyDeadlineMs;
    boolean mNoAutoReset;
    StopwatchTimer mNrNsaTimer;
    int mNrState;
    private int mNumAllUidCpuTimeReads;
    private int mNumConnectivityChange;
    private long mNumSingleUidCpuTimeReads;
    private int mNumUidsRemoved;
    boolean mOnBattery;
    protected boolean mOnBatteryInternal;
    protected final TimeBase mOnBatteryScreenOffTimeBase;
    protected final TimeBase mOnBatteryTimeBase;
    protected ArrayList<StopwatchTimer> mPartialTimers;
    protected Queue<UidToRemove> mPendingRemovedUids;
    DisplayBatteryStats[] mPerDisplayBatteryStats;
    public boolean mPerProcStateCpuTimesAvailable;
    RadioAccessTechnologyBatteryStats[] mPerRatBatteryStats;
    int mPhoneDataConnectionType;
    final StopwatchTimer[] mPhoneDataConnectionsTimer;
    boolean mPhoneOn;
    StopwatchTimer mPhoneOnTimer;
    private int mPhoneServiceState;
    private int mPhoneServiceStateRaw;
    StopwatchTimer mPhoneSignalScanningTimer;
    int mPhoneSignalStrengthBin;
    int mPhoneSignalStrengthBinRaw;
    final StopwatchTimer[] mPhoneSignalStrengthsTimer;
    private int mPhoneSimStateRaw;
    private final PlatformIdleStateCallback mPlatformIdleStateCallback;
    PowerManagerFlags mPowerManagerFlags;
    private final PowerProfile mPowerProfile;
    boolean mPowerSaveModeEnabled;
    StopwatchTimer mPowerSaveModeEnabledTimer;
    private final SparseBooleanArray mPowerStatsCollectorEnabled;
    private final PowerStatsCollectorInjector mPowerStatsCollectorInjector;
    private PowerStatsStore mPowerStatsStore;
    protected final PowerStatsUidResolver mPowerStatsUidResolver;
    boolean mPretendScreenOff;
    long mRealtimeStartUs;
    long mRealtimeUs;
    public boolean mRecordAllHistory;
    private boolean mResetBatteryHistoryOnNewSession;
    private final HashMap<String, SamplingTimer> mRpmStats;
    private boolean mSaveBatteryUsageStatsOnReset;
    int mScreenBrightnessBin;
    final StopwatchTimer[] mScreenBrightnessTimer;
    StopwatchTimer mScreenDozeTimer;
    private final HashMap<String, SamplingTimer> mScreenOffRpmStats;
    StopwatchTimer mScreenOnTimer;
    private final ScreenPowerStatsCollector mScreenPowerStatsCollector;
    protected int mScreenState;
    private ScreenPowerStatsCollector.ScreenUsageTimeRetriever mScreenUsageTimeRetriever;
    private final SparseArray<ArrayList<StopwatchTimer>> mSensorTimers;
    private boolean mShuttingDown;
    long mStartClockTimeMs;
    int mStartCount;
    String mStartPlatformVersion;
    private final AtomicFile mStatsFile;
    private final BatteryHistoryStepDetailsProvider mStepDetailsProvider;
    private boolean mSystemReady;
    protected SystemServerCpuThreadReader mSystemServerCpuThreadReader;
    long mTempTotalCpuSystemTimeUs;
    long mTempTotalCpuUserTimeUs;
    private long[] mTmpCpuTimeInFreq;
    private RailStats mTmpRailStats;
    private RpmStats mTmpRpmStats;
    private final KernelWakelockStats mTmpWakelockStats;
    final SparseArray<Uid> mUidStats;
    long mUptimeStartUs;
    long mUptimeUs;
    int mUsbDataState;
    protected UserInfoProvider mUserInfoProvider;
    int mVideoOnNesting;
    StopwatchTimer mVideoOnTimer;
    private final ArrayList<StopwatchTimer> mVideoTurnedOnTimers;
    long[][] mWakeLockAllocationsUs;
    boolean mWakeLockImportant;
    int mWakeLockNesting;
    private final WakelockPowerStatsCollector.WakelockDurationRetriever mWakelockDurationRetriever;
    private final WakelockPowerStatsCollector mWakelockPowerStatsCollector;
    private final HashMap<String, SamplingTimer> mWakeupReasonStats;
    StopwatchTimer mWifiActiveTimer;
    ControllerActivityCounterImpl mWifiActivity;
    private final SparseArray<ArrayList<StopwatchTimer>> mWifiBatchedScanTimers;
    private int mWifiFullLockNesting;
    private String[] mWifiIfaces;
    private int mWifiMulticastNesting;
    private final ArrayList<StopwatchTimer> mWifiMulticastTimers;
    StopwatchTimer mWifiMulticastWakelockTimer;
    private final Object mWifiNetworkLock;
    boolean mWifiOn;
    StopwatchTimer mWifiOnTimer;
    WifiPowerCalculator mWifiPowerCalculator;
    private final WifiPowerStatsCollector mWifiPowerStatsCollector;
    int mWifiRadioPowerState;
    private final ArrayList<StopwatchTimer> mWifiRunningTimers;
    int mWifiScanNesting;
    private final ArrayList<StopwatchTimer> mWifiScanTimers;
    int mWifiSignalStrengthBin;
    final StopwatchTimer[] mWifiSignalStrengthsTimer;
    int mWifiState;
    final StopwatchTimer[] mWifiStateTimer;
    private final WifiPowerStatsCollector.WifiStatsRetriever mWifiStatsRetriever;
    int mWifiSupplState;
    final StopwatchTimer[] mWifiSupplStateTimer;
    private final ArrayList<StopwatchTimer> mWindowTimers;
    private final Runnable mWriteAsyncRunnable;
    private final ReentrantLock mWriteLock;

    public static class BatchTimer extends Timer {
        boolean mInDischarge;
        long mLastAddedDurationUs;
        long mLastAddedTimeUs;
        final Uid mUid;

        BatchTimer(Clock clock, Uid uid, int type, TimeBase timeBase, Parcel in) {
            super(clock, type, timeBase, in);
            this.mUid = uid;
            this.mLastAddedTimeUs = in.readLong();
            this.mLastAddedDurationUs = in.readLong();
            this.mInDischarge = timeBase.isRunning();
        }

        BatchTimer(Clock clock, Uid uid, int type, TimeBase timeBase) {
            super(clock, type, timeBase);
            this.mUid = uid;
            this.mInDischarge = timeBase.isRunning();
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        public void writeToParcel(Parcel out, long elapsedRealtimeUs) {
            super.writeToParcel(out, elapsedRealtimeUs);
            out.writeLong(this.mLastAddedTimeUs);
            out.writeLong(this.mLastAddedDurationUs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            recomputeLastDuration(elapsedRealtimeUs, false);
            this.mInDischarge = false;
            super.onTimeStopped(elapsedRealtimeUs, baseUptimeUs, baseRealtimeUs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            recomputeLastDuration(elapsedRealtimeUs, false);
            this.mInDischarge = true;
            if (this.mLastAddedTimeUs != elapsedRealtimeUs) goto L5;
            this.mTotalTimeUs += this.mLastAddedDurationUs;
        L5:
            super.onTimeStarted(elapsedRealtimeUs, baseUptimeUs, baseRealtimeUs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        public void logState(Printer pw, String prefix) {
            super.logState(pw, prefix);
            pw.println(prefix + "mLastAddedTime=" + this.mLastAddedTimeUs + " mLastAddedDuration=" + this.mLastAddedDurationUs);
        }

        private long computeOverage(long curTimeUs) {
            if (this.mLastAddedTimeUs > 0) goto L5;
            return 0;
        L5:
            return this.mLastAddedDurationUs - curTimeUs;
        }

        private void recomputeLastDuration(long curTimeUs, boolean abort) {
            long overage = computeOverage(curTimeUs);
            if (overage > 0) goto L5;
            return;
        L5:
            if (this.mInDischarge == false) goto L7;
            this.mTotalTimeUs -= overage;
        L7:
            if (abort == false) goto L9;
            this.mLastAddedTimeUs = 0;
            return;
        L9:
            this.mLastAddedTimeUs = curTimeUs;
            this.mLastAddedDurationUs -= overage;
        }

        public void addDuration(long durationMs, long elapsedRealtimeMs) {
            long nowUs = elapsedRealtimeMs * 1000;
            recomputeLastDuration(nowUs, true);
            this.mLastAddedTimeUs = nowUs;
            this.mLastAddedDurationUs = 1000 * durationMs;
            if (this.mInDischarge == false) goto L6;
            this.mTotalTimeUs += this.mLastAddedDurationUs;
            this.mCount++;
            return;
        }

        public void abortLastDuration(long elapsedRealtimeMs) {
            long nowUs = 1000 * elapsedRealtimeMs;
            recomputeLastDuration(nowUs, true);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        protected int computeCurrentCountLocked() {
            return this.mCount;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        protected long computeRunTimeLocked(long curBatteryRealtimeUs, long elapsedRealtimeUs) {
            long overage = computeOverage(elapsedRealtimeUs);
            if (overage <= 0) goto L7;
            this.mTotalTimeUs = overage;
            return overage;
        L7:
            return this.mTotalTimeUs;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            recomputeLastDuration(elapsedRealtimeUs, true);
            if (this.mLastAddedTimeUs != elapsedRealtimeUs) goto L5;
            boolean stillActive = true;
        L6:
            if (stillActive == true) goto L9;
            if (detachIfReset == false) goto L9;
            boolean r3 = true;
        L10:
            super.reset(r3, elapsedRealtimeUs);
            if (stillActive == true) goto L14;
            return true;
        L14:
            return false;
        L9:
            r3 = false;
            goto L10
        L5:
            stillActive = false;
            goto L6
        }
    }

    public interface BatteryCallback {
        void batteryNeedsCpuUpdate();

        void batteryPowerChanged(boolean r1);

        void batterySendBroadcast(Intent r1);

        void batteryStatsReset();
    }

    public static class BatteryStatsConfig {
        static final int RESET_ON_UNPLUG_AFTER_SIGNIFICANT_CHARGE_FLAG = 2;
        static final int RESET_ON_UNPLUG_HIGH_BATTERY_LEVEL_FLAG = 1;
        private final Long mDefaultPowerStatsThrottlePeriod;
        private final int mFlags;
        private final int mMaxHistorySizeBytes;
        private final Map<String, Long> mPowerStatsThrottlePeriods;

        public static class Builder {
            private static final int DEFAULT_MAX_HISTORY_SIZE = 4194304;
            private static final long DEFAULT_POWER_STATS_THROTTLE_PERIOD = 0;
            private static final long DEFAULT_POWER_STATS_THROTTLE_PERIOD_CPU = 0;
            private long mDefaultPowerStatsThrottlePeriod;
            private int mMaxHistorySizeBytes;
            private final Map<String, Long> mPowerStatsThrottlePeriods;
            private boolean mResetOnUnplugAfterSignificantCharge;
            private boolean mResetOnUnplugHighBatteryLevel;

            /* JADX INFO: renamed from: -$$Nest$fgetmDefaultPowerStatsThrottlePeriod, reason: not valid java name */
            static /* bridge */ /* synthetic */ long m7766$$Nest$fgetmDefaultPowerStatsThrottlePeriod(Builder r2) {
                return r2.mDefaultPowerStatsThrottlePeriod;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmMaxHistorySizeBytes, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m7767$$Nest$fgetmMaxHistorySizeBytes(Builder r0) {
                return r0.mMaxHistorySizeBytes;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmPowerStatsThrottlePeriods, reason: not valid java name */
            static /* bridge */ /* synthetic */ Map m7768$$Nest$fgetmPowerStatsThrottlePeriods(Builder r0) {
                return r0.mPowerStatsThrottlePeriods;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmResetOnUnplugAfterSignificantCharge, reason: not valid java name */
            static /* bridge */ /* synthetic */ boolean m7769$$Nest$fgetmResetOnUnplugAfterSignificantCharge(Builder r0) {
                return r0.mResetOnUnplugAfterSignificantCharge;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmResetOnUnplugHighBatteryLevel, reason: not valid java name */
            static /* bridge */ /* synthetic */ boolean m7770$$Nest$fgetmResetOnUnplugHighBatteryLevel(Builder r0) {
                return r0.mResetOnUnplugHighBatteryLevel;
            }

            static {
                DEFAULT_POWER_STATS_THROTTLE_PERIOD = TimeUnit.HOURS.toMillis(1);
                DEFAULT_POWER_STATS_THROTTLE_PERIOD_CPU = TimeUnit.MINUTES.toMillis(1);
            }

            public Builder() {
                this.mDefaultPowerStatsThrottlePeriod = DEFAULT_POWER_STATS_THROTTLE_PERIOD;
                this.mPowerStatsThrottlePeriods = new HashMap();
                this.mMaxHistorySizeBytes = 4194304;
                this.mResetOnUnplugHighBatteryLevel = true;
                this.mResetOnUnplugAfterSignificantCharge = true;
                setPowerStatsThrottlePeriodMillis(BatteryConsumer.powerComponentIdToString(1), DEFAULT_POWER_STATS_THROTTLE_PERIOD_CPU);
            }

            public BatteryStatsConfig build() {
                return new BatteryStatsConfig(this, null);
            }

            public Builder setResetOnUnplugHighBatteryLevel(boolean reset) {
                this.mResetOnUnplugHighBatteryLevel = reset;
                return this;
            }

            public Builder setResetOnUnplugAfterSignificantCharge(boolean reset) {
                this.mResetOnUnplugAfterSignificantCharge = reset;
                return this;
            }

            public Builder setPowerStatsThrottlePeriodMillis(String powerComponentName, long periodMs) {
                this.mPowerStatsThrottlePeriods.put(powerComponentName, Long.valueOf(periodMs));
                return this;
            }

            public Builder setDefaultPowerStatsThrottlePeriodMillis(long periodMs) {
                this.mDefaultPowerStatsThrottlePeriod = periodMs;
                return this;
            }

            public Builder setMaxHistorySizeBytes(int maxHistorySizeBytes) {
                this.mMaxHistorySizeBytes = maxHistorySizeBytes;
                return this;
            }
        }

        /* synthetic */ BatteryStatsConfig(Builder r1, BatteryStatsImplIA r2) {
            this(r1);
        }

        private BatteryStatsConfig(Builder builder) {
            int flags = 0;
            if (Builder.m7770$$Nest$fgetmResetOnUnplugHighBatteryLevel(builder) == false) goto L6;
            flags = 0 | 1;
        L6:
            if (Builder.m7769$$Nest$fgetmResetOnUnplugAfterSignificantCharge(builder) == false) goto L8;
            flags = flags | 2;
        L8:
            this.mFlags = flags;
            this.mDefaultPowerStatsThrottlePeriod = Long.valueOf(Builder.m7766$$Nest$fgetmDefaultPowerStatsThrottlePeriod(builder));
            this.mPowerStatsThrottlePeriods = Builder.m7768$$Nest$fgetmPowerStatsThrottlePeriods(builder);
            this.mMaxHistorySizeBytes = Builder.m7767$$Nest$fgetmMaxHistorySizeBytes(builder);
        }

        public boolean shouldResetOnUnplugHighBatteryLevel() {
            if ((this.mFlags & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean shouldResetOnUnplugAfterSignificantCharge() {
            if ((this.mFlags & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public long getPowerStatsThrottlePeriod(String powerComponentName) {
            return this.mPowerStatsThrottlePeriods.getOrDefault(powerComponentName, this.mDefaultPowerStatsThrottlePeriod).longValue();
        }

        public int getMaxHistorySizeBytes() {
            return this.mMaxHistorySizeBytes;
        }
    }

    static class BatteryStatsSession {
        private final BatteryStatsImpl mBatteryStats;
        private final long mBatteryTimeRemainingMs;
        private final long mChargeTimeRemainingMs;
        private final String[] mCustomEnergyConsumerNames;
        private final long mEstimatedBatteryCapacityMah;
        private final BatteryStatsHistory mHistory;
        private final long mMonotonicStartTime;
        private final long mStartClockTime;

        BatteryStatsSession(BatteryStatsHistory history, long monotonicStartTime, long startClockTime, long batteryTimeRemainingMs, long chargeTimeRemainingMs, long estimatedBatteryCapacityMah, String[] customEnergyConsumerNames, BatteryStatsImpl batteryStats) {
            this.mHistory = history;
            this.mMonotonicStartTime = monotonicStartTime;
            this.mStartClockTime = startClockTime;
            this.mEstimatedBatteryCapacityMah = estimatedBatteryCapacityMah;
            this.mBatteryTimeRemainingMs = batteryTimeRemainingMs;
            this.mChargeTimeRemainingMs = chargeTimeRemainingMs;
            this.mCustomEnergyConsumerNames = customEnergyConsumerNames;
            this.mBatteryStats = batteryStats;
        }

        BatteryStatsHistory getHistory() {
            return this.mHistory;
        }

        long getMonotonicStartTime() {
            return this.mMonotonicStartTime;
        }

        long getStartClockTime() {
            return this.mStartClockTime;
        }

        long getBatteryTimeRemainingMs() {
            return this.mBatteryTimeRemainingMs;
        }

        long getChargeTimeRemainingMs() {
            return this.mChargeTimeRemainingMs;
        }

        double getEstimatedBatteryCapacity() {
            return this.mEstimatedBatteryCapacityMah;
        }

        String[] getCustomEnergyConsumerNames() {
            return this.mCustomEnergyConsumerNames;
        }

        @Deprecated
        public BatteryStatsImpl getBatteryStats() {
            return this.mBatteryStats;
        }
    }

    protected static class BinderCallStats {
        public Class<? extends Binder> binderClass;
        public long callCount;
        public String methodName;
        public long recordedCallCount;
        public long recordedCpuTimeMicros;
        public int transactionCode;

        protected BinderCallStats() {
        }

        public int hashCode() {
            return (this.binderClass.hashCode() * 31) + this.transactionCode;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof BinderCallStats) == true) goto L5;
            return false;
        L5:
            BinderCallStats bcsk = (BinderCallStats) obj;
            if (this.binderClass.equals(bcsk.binderClass) == true) goto L8;
            return false;
        L8:
            if (this.transactionCode != bcsk.transactionCode) goto L12;
            return true;
        L12:
            return false;
        }

        public String getClassName() {
            return this.binderClass.getName();
        }

        public String getMethodName() {
            return this.methodName;
        }

        public void ensureMethodName(BinderTransactionNameResolver resolver) {
            if (this.methodName != null) goto L6;
            this.methodName = resolver.getMethodName(this.binderClass, this.transactionCode);
            return;
        }

        public String toString() {
            return "BinderCallStats{" + this.binderClass + " transaction=" + this.transactionCode + " callCount=" + this.callCount + " recordedCallCount=" + this.recordedCallCount + " recorderCpuTimeMicros=" + this.recordedCpuTimeMicros + "}";
        }
    }

    private final class BluetoothActivityInfoCache {
        long energy;
        long idleTimeMs;
        long rxTimeMs;
        long txTimeMs;
        SparseLongArray uidRxBytes;
        SparseLongArray uidTxBytes;

        /* synthetic */ BluetoothActivityInfoCache(BatteryStatsImpl r1, BatteryStatsImplIA r2) {
            this(r1);
        }

        private BluetoothActivityInfoCache(BatteryStatsImpl r1) {
            this.uidRxBytes = new SparseLongArray();
            this.uidTxBytes = new SparseLongArray();
        }

        void set(BluetoothActivityEnergyInfo info) {
            this.idleTimeMs = info.getControllerIdleTimeMillis();
            this.rxTimeMs = info.getControllerRxTimeMillis();
            this.txTimeMs = info.getControllerTxTimeMillis();
            this.energy = info.getControllerEnergyUsed();
            if (info.getUidTraffic().isEmpty() == true) goto L8;
            Iterator r0 = info.getUidTraffic().iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            UidTraffic traffic = (UidTraffic) r0.next();
            this.uidRxBytes.put(traffic.getUid(), traffic.getRxBytes());
            this.uidTxBytes.put(traffic.getUid(), traffic.getTxBytes());
            goto L6
        L10:
            return;
        }

        void reset() {
            this.idleTimeMs = 0;
            this.rxTimeMs = 0;
            this.txTimeMs = 0;
            this.energy = 0;
            this.uidRxBytes.clear();
            this.uidTxBytes.clear();
        }
    }

    private class BluetoothStatsRetrieverImpl implements BluetoothPowerStatsCollector.BluetoothStatsRetriever {
        private final BluetoothManager mBluetoothManager;
        final /* synthetic */ BatteryStatsImpl this$0;

        BluetoothStatsRetrieverImpl(BatteryStatsImpl r1, BluetoothManager bluetoothManager) {
            this.this$0 = r1;
            this.mBluetoothManager = bluetoothManager;
        }

        @Override // com.android.server.power.stats.BluetoothPowerStatsCollector.BluetoothStatsRetriever
        public void retrieveBluetoothScanTimes(BluetoothPowerStatsCollector.BluetoothStatsRetriever.Callback callback) {
            BatteryStatsImpl r0 = this.this$0;
            monitor-enter(r0);
            BatteryStatsImpl.m7743$$Nest$mretrieveBluetoothScanTimesLocked(this.this$0, callback);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.power.stats.BluetoothPowerStatsCollector.BluetoothStatsRetriever
        public boolean requestControllerActivityEnergyInfo(Executor executor, BluetoothAdapter.OnBluetoothActivityEnergyInfoCallback callback) {
            if (this.mBluetoothManager != null) goto L5;
            return false;
        L5:
            BluetoothAdapter adapter = this.mBluetoothManager.getAdapter();
            if (adapter != null) goto L8;
            return false;
        L8:
            adapter.requestControllerActivityEnergyInfo(executor, callback);
            return true;
        }
    }

    public final class Constants extends ContentObserver {
        private static final int DEFAULT_BATTERY_CHARGED_DELAY_MS = 900000;
        private static final int DEFAULT_BATTERY_CHARGING_ENFORCE_LEVEL = 90;
        private static final long DEFAULT_BATTERY_LEVEL_COLLECTION_DELAY_MS = 300000;
        private static final long DEFAULT_EXTERNAL_STATS_COLLECTION_RATE_LIMIT_MS = 600000;
        private static final long DEFAULT_KERNEL_UID_READERS_THROTTLE_TIME = 1000;
        private static final int DEFAULT_MAX_HISTORY_BUFFER_KB = 128;
        private static final int DEFAULT_MAX_HISTORY_BUFFER_LOW_RAM_DEVICE_KB = 64;
        private static final int DEFAULT_PER_UID_MODEM_MODEL = 2;
        private static final boolean DEFAULT_PHONE_ON_EXTERNAL_STATS_COLLECTION = true;
        private static final long DEFAULT_PROC_STATE_CHANGE_COLLECTION_DELAY_MS = 60000;
        private static final int DEFAULT_RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS = 47;
        private static final boolean DEFAULT_TRACK_CPU_ACTIVE_CLUSTER_TIME = true;
        private static final long DEFAULT_UID_REMOVE_DELAY_MS = 300000;
        public static final String KEY_BATTERY_CHARGED_DELAY_MS = "battery_charged_delay_ms";
        public static final String KEY_BATTERY_CHARGING_ENFORCE_LEVEL = "battery_charging_enforce_level";
        public static final String KEY_BATTERY_LEVEL_COLLECTION_DELAY_MS = "battery_level_collection_delay_ms";
        public static final String KEY_EXTERNAL_STATS_COLLECTION_RATE_LIMIT_MS = "external_stats_collection_rate_limit_ms";
        public static final String KEY_KERNEL_UID_READERS_THROTTLE_TIME = "kernel_uid_readers_throttle_time";
        public static final String KEY_MAX_HISTORY_BUFFER_KB = "max_history_buffer_kb";
        public static final String KEY_MAX_HISTORY_SIZE = "max_history_size";
        public static final String KEY_PER_UID_MODEM_POWER_MODEL = "per_uid_modem_power_model";
        public static final String KEY_PHONE_ON_EXTERNAL_STATS_COLLECTION = "phone_on_external_stats_collection";
        public static final String KEY_PROC_STATE_CHANGE_COLLECTION_DELAY_MS = "procstate_change_collection_delay_ms";
        public static final String KEY_RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS = "reset_while_plugged_in_minimum_duration_hours";
        public static final String KEY_TRACK_CPU_ACTIVE_CLUSTER_TIME = "track_cpu_active_cluster_time";
        public static final String KEY_UID_REMOVE_DELAY_MS = "uid_remove_delay_ms";
        public static final String PER_UID_MODEM_POWER_MODEL_MOBILE_RADIO_ACTIVE_TIME_NAME = "mobile_radio_active_time";
        public static final String PER_UID_MODEM_POWER_MODEL_MODEM_ACTIVITY_INFO_RX_TX_NAME = "modem_activity_info_rx_tx";
        public int BATTERY_CHARGED_DELAY_MS;
        public int BATTERY_CHARGING_ENFORCE_LEVEL;
        public long BATTERY_LEVEL_COLLECTION_DELAY_MS;
        public long EXTERNAL_STATS_COLLECTION_RATE_LIMIT_MS;
        public long KERNEL_UID_READERS_THROTTLE_TIME;
        public int MAX_HISTORY_BUFFER;
        public int MAX_HISTORY_SIZE;
        public int PER_UID_MODEM_MODEL;
        public boolean PHONE_ON_EXTERNAL_STATS_COLLECTION;
        public long PROC_STATE_CHANGE_COLLECTION_DELAY_MS;
        public int RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS;
        public boolean TRACK_CPU_ACTIVE_CLUSTER_TIME;
        public long UID_REMOVE_DELAY_MS;
        private final KeyValueListParser mParser;
        private ContentResolver mResolver;
        final /* synthetic */ BatteryStatsImpl this$0;

        public String getPerUidModemModelName(int model) {
            switch(model) {
                case 1: goto L7;
                case 2: goto L5;
                default: goto L3;
            };
        L3:
            Slog.w(BatteryStatsImpl.TAG, "Unexpected per uid modem model (" + model + ")");
            return "unknown_" + model;
        L5:
            return PER_UID_MODEM_POWER_MODEL_MODEM_ACTIVITY_INFO_RX_TX_NAME;
        L7:
            return PER_UID_MODEM_POWER_MODEL_MOBILE_RADIO_ACTIVE_TIME_NAME;
        }

        public int getPerUidModemModel(String name) {
            switch(name.hashCode()) {
                case -615381273: goto L9;
                case 426026949: goto L6;
                default: goto L11;
            };
        L11:
            byte r0 = -1;
        L13:
            switch(r0) {
                case 0: goto L17;
                case 1: goto L16;
                default: goto L14;
            };
        L14:
            Slog.w(BatteryStatsImpl.TAG, "Unexpected per uid modem model name (" + name + ")");
            return 2;
        L16:
            return 2;
        L17:
            return 1;
        L6:
            if (name.equals(PER_UID_MODEM_POWER_MODEL_MOBILE_RADIO_ACTIVE_TIME_NAME) == false) goto L11;
            r0 = 0;
            goto L13
        L9:
            if (name.equals(PER_UID_MODEM_POWER_MODEL_MODEM_ACTIVITY_INFO_RX_TX_NAME) == false) goto L11;
            r0 = 1;
            goto L13
        }

        public Constants(BatteryStatsImpl this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
            this.TRACK_CPU_ACTIVE_CLUSTER_TIME = true;
            this.UID_REMOVE_DELAY_MS = 300000;
            this.EXTERNAL_STATS_COLLECTION_RATE_LIMIT_MS = 600000;
            this.BATTERY_LEVEL_COLLECTION_DELAY_MS = 300000;
            this.PROC_STATE_CHANGE_COLLECTION_DELAY_MS = 60000;
            this.BATTERY_CHARGED_DELAY_MS = DEFAULT_BATTERY_CHARGED_DELAY_MS;
            this.BATTERY_CHARGING_ENFORCE_LEVEL = 90;
            this.PER_UID_MODEM_MODEL = 2;
            this.PHONE_ON_EXTERNAL_STATS_COLLECTION = true;
            this.RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS = 47;
            this.mParser = new KeyValueListParser(',');
            if (BatteryStatsImpl.access$000() == false) goto L5;
            this.MAX_HISTORY_BUFFER = 65536;
        L6:
            this.MAX_HISTORY_SIZE = this$0.mBatteryStatsConfig.getMaxHistorySizeBytes();
            return;
        L5:
            this.MAX_HISTORY_BUFFER = 131072;
            goto L6
        }

        public void startObserving(ContentResolver resolver) {
            this.mResolver = resolver;
            this.mResolver.registerContentObserver(Settings.Global.getUriFor("battery_stats_constants"), false, this);
            this.mResolver.registerContentObserver(Settings.Global.getUriFor("battery_charging_state_update_delay"), false, this);
            this.mResolver.registerContentObserver(Settings.Global.getUriFor("battery_charging_state_enforce_level"), false, this);
            updateConstants();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (uri.equals(Settings.Global.getUriFor("battery_charging_state_update_delay")) == false) goto L13;
            BatteryStatsImpl r0 = this.this$0;
            monitor-enter(r0);
            updateBatteryChargedDelayMsLocked();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L13:
            if (uri.equals(Settings.Global.getUriFor("battery_charging_state_enforce_level")) == false) goto L22;
            BatteryStatsImpl r1 = this.this$0;
            monitor-enter(r1);
            updateBatteryChargingEnforceLevelLocked();     // Catch: Throwable -> L19
            monitor-exit(r1);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        L22:
            updateConstants();
        }

        private void updateConstants() {
            BatteryStatsImpl r0 = this.this$0;
            monitor-enter(r0);
            this.mParser.setString(Settings.Global.getString(this.mResolver, "battery_stats_constants"));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
        L10:
            this.TRACK_CPU_ACTIVE_CLUSTER_TIME = this.mParser.getBoolean(KEY_TRACK_CPU_ACTIVE_CLUSTER_TIME, true);     // Catch: Throwable -> L6
            updateKernelUidReadersThrottleTime(this.KERNEL_UID_READERS_THROTTLE_TIME, this.mParser.getLong(KEY_KERNEL_UID_READERS_THROTTLE_TIME, 1000));     // Catch: Throwable -> L6
            updateUidRemoveDelay(this.mParser.getLong(KEY_UID_REMOVE_DELAY_MS, 300000));     // Catch: Throwable -> L6
            this.EXTERNAL_STATS_COLLECTION_RATE_LIMIT_MS = this.mParser.getLong(KEY_EXTERNAL_STATS_COLLECTION_RATE_LIMIT_MS, 600000);     // Catch: Throwable -> L6
            this.BATTERY_LEVEL_COLLECTION_DELAY_MS = this.mParser.getLong(KEY_BATTERY_LEVEL_COLLECTION_DELAY_MS, 300000);     // Catch: Throwable -> L6
            this.PROC_STATE_CHANGE_COLLECTION_DELAY_MS = this.mParser.getLong(KEY_PROC_STATE_CHANGE_COLLECTION_DELAY_MS, 60000);     // Catch: Throwable -> L6
            KeyValueListParser r1 = this.mParser;     // Catch: Throwable -> L6
            if (BatteryStatsImpl.access$100() == false) goto L13;
            int r4 = 64;
        L14:
            this.MAX_HISTORY_BUFFER = r1.getInt(KEY_MAX_HISTORY_BUFFER_KB, r4) * 1024;     // Catch: Throwable -> L6
            int maxHistorySize = this.mParser.getInt(KEY_MAX_HISTORY_SIZE, -1);     // Catch: Throwable -> L6
            if (maxHistorySize != (-1)) goto L19;
            int maxHistoryFiles = this.mParser.getInt("max_history_files", -1);     // Catch: Throwable -> L6
            if (maxHistoryFiles == (-1)) goto L19;
            maxHistorySize = maxHistoryFiles * this.MAX_HISTORY_BUFFER;     // Catch: Throwable -> L6
        L19:
            if (maxHistorySize != (-1)) goto L21;
            maxHistorySize = this.this$0.mBatteryStatsConfig.getMaxHistorySizeBytes();     // Catch: Throwable -> L6
        L21:
            this.MAX_HISTORY_SIZE = maxHistorySize;     // Catch: Throwable -> L6
            String perUidModemModel = this.mParser.getString(KEY_PER_UID_MODEM_POWER_MODEL, "");     // Catch: Throwable -> L6
            this.PER_UID_MODEM_MODEL = getPerUidModemModel(perUidModemModel);     // Catch: Throwable -> L6
            this.PHONE_ON_EXTERNAL_STATS_COLLECTION = this.mParser.getBoolean(KEY_PHONE_ON_EXTERNAL_STATS_COLLECTION, true);     // Catch: Throwable -> L6
            this.RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS = this.mParser.getInt(KEY_RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS, 47);     // Catch: Throwable -> L6
            updateBatteryChargedDelayMsLocked();     // Catch: Throwable -> L6
            updateBatteryChargingEnforceLevelLocked();     // Catch: Throwable -> L6
            onChange();     // Catch: Throwable -> L6
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L13:
            r4 = 128;
            goto L14
        L6:
            th = move-exception;
            throw th;
        L8:
            e = move-exception;
            Slog.e(BatteryStatsImpl.TAG, "Bad batterystats settings", e);     // Catch: Throwable -> L6
            goto L10
        }

        public void onChange() {
            if (BatteryStatsImpl.m7712$$Nest$fgetmBatteryHistoryDirectory(this.this$0) == null) goto L5;
            BatteryStatsImpl.m7712$$Nest$fgetmBatteryHistoryDirectory(this.this$0).setMaxHistorySize(this.MAX_HISTORY_SIZE);
        L5:
            BatteryStatsImpl.m7724$$Nest$fgetmHistory(this.this$0).setMaxHistoryBufferSize(this.MAX_HISTORY_BUFFER);
        }

        private void updateBatteryChargedDelayMsLocked() {
            int delay = Settings.Global.getInt(this.mResolver, "battery_charging_state_update_delay", -1);
            if (delay < 0) goto L5;
            int r1 = delay;
        L6:
            this.BATTERY_CHARGED_DELAY_MS = r1;
            if (this.this$0.mHandler.hasCallbacks(BatteryStatsImpl.m7717$$Nest$fgetmDeferSetCharging(this.this$0)) == false) goto L10;
            this.this$0.mHandler.removeCallbacks(BatteryStatsImpl.m7717$$Nest$fgetmDeferSetCharging(this.this$0));
            this.this$0.mHandler.postDelayed(BatteryStatsImpl.m7717$$Nest$fgetmDeferSetCharging(this.this$0), this.BATTERY_CHARGED_DELAY_MS);
            return;
        L10:
            return;
        L5:
            r1 = this.mParser.getInt(KEY_BATTERY_CHARGED_DELAY_MS, DEFAULT_BATTERY_CHARGED_DELAY_MS);
            goto L6
        }

        private void updateBatteryChargingEnforceLevelLocked() {
            int lastChargingEnforceLevel = this.BATTERY_CHARGING_ENFORCE_LEVEL;
            int level = Settings.Global.getInt(this.mResolver, "battery_charging_state_enforce_level", -1);
            if (level < 0) goto L5;
            int r2 = level;
        L6:
            this.BATTERY_CHARGING_ENFORCE_LEVEL = r2;
            if (this.BATTERY_CHARGING_ENFORCE_LEVEL <= this.this$0.mLastChargeStepLevel) goto L9;
            return;
        L9:
            if (this.this$0.mLastChargeStepLevel >= lastChargingEnforceLevel) goto L13;
            this.this$0.setChargingLocked(true);
            return;
        L13:
            return;
        L5:
            r2 = this.mParser.getInt(KEY_BATTERY_CHARGING_ENFORCE_LEVEL, 90);
            goto L6
        }

        private void updateKernelUidReadersThrottleTime(long oldTimeMs, long newTimeMs) {
            this.KERNEL_UID_READERS_THROTTLE_TIME = newTimeMs;
            if (oldTimeMs == newTimeMs) goto L6;
            this.this$0.mCpuUidUserSysTimeReader.setThrottle(this.KERNEL_UID_READERS_THROTTLE_TIME);
            this.this$0.mCpuUidFreqTimeReader.setThrottle(this.KERNEL_UID_READERS_THROTTLE_TIME);
            this.this$0.mCpuUidActiveTimeReader.setThrottle(this.KERNEL_UID_READERS_THROTTLE_TIME);
            this.this$0.mCpuUidClusterTimeReader.setThrottle(this.KERNEL_UID_READERS_THROTTLE_TIME);
            return;
        }

        private void updateUidRemoveDelay(long newTimeMs) {
            this.UID_REMOVE_DELAY_MS = newTimeMs;
            this.this$0.clearPendingRemovedUidsLocked();
        }

        public void dumpLocked(PrintWriter pw) {
            pw.print(KEY_TRACK_CPU_ACTIVE_CLUSTER_TIME);
            pw.print("=");
            pw.println(this.TRACK_CPU_ACTIVE_CLUSTER_TIME);
            pw.print(KEY_KERNEL_UID_READERS_THROTTLE_TIME);
            pw.print("=");
            pw.println(this.KERNEL_UID_READERS_THROTTLE_TIME);
            pw.print(KEY_EXTERNAL_STATS_COLLECTION_RATE_LIMIT_MS);
            pw.print("=");
            pw.println(this.EXTERNAL_STATS_COLLECTION_RATE_LIMIT_MS);
            pw.print(KEY_BATTERY_LEVEL_COLLECTION_DELAY_MS);
            pw.print("=");
            pw.println(this.BATTERY_LEVEL_COLLECTION_DELAY_MS);
            pw.print(KEY_PROC_STATE_CHANGE_COLLECTION_DELAY_MS);
            pw.print("=");
            pw.println(this.PROC_STATE_CHANGE_COLLECTION_DELAY_MS);
            pw.print(KEY_MAX_HISTORY_SIZE);
            pw.print("=");
            pw.println(this.MAX_HISTORY_SIZE);
            pw.print(KEY_MAX_HISTORY_BUFFER_KB);
            pw.print("=");
            pw.println(this.MAX_HISTORY_BUFFER / 1024);
            pw.print(KEY_BATTERY_CHARGED_DELAY_MS);
            pw.print("=");
            pw.println(this.BATTERY_CHARGED_DELAY_MS);
            pw.print(KEY_BATTERY_CHARGING_ENFORCE_LEVEL);
            pw.print("=");
            pw.println(this.BATTERY_CHARGING_ENFORCE_LEVEL);
            pw.print(KEY_PER_UID_MODEM_POWER_MODEL);
            pw.print("=");
            pw.println(getPerUidModemModelName(this.PER_UID_MODEM_MODEL));
            pw.print(KEY_PHONE_ON_EXTERNAL_STATS_COLLECTION);
            pw.print("=");
            pw.println(this.PHONE_ON_EXTERNAL_STATS_COLLECTION);
            pw.print(KEY_RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS);
            pw.print("=");
            pw.println(this.RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS);
        }
    }

    public static class ControllerActivityCounterImpl extends BatteryStats.ControllerActivityCounter implements Parcelable {
        private final Clock mClock;
        private TimeMultiStateCounter mIdleTimeMillis;
        private final LongSamplingCounter mMonitoredRailChargeConsumedMaMs;
        private int mNumTxStates;
        private final LongSamplingCounter mPowerDrainMaMs;
        private int mProcessState;
        private TimeMultiStateCounter mRxTimeMillis;
        private final LongSamplingCounter mScanTimeMillis;
        private final LongSamplingCounter mSleepTimeMillis;
        private final TimeBase mTimeBase;
        private TimeMultiStateCounter[] mTxTimeMillis;

        /* JADX INFO: renamed from: -$$Nest$mgetOrCreateIdleTimeCounter, reason: not valid java name */
        static /* bridge */ /* synthetic */ TimeMultiStateCounter m7771$$Nest$mgetOrCreateIdleTimeCounter(ControllerActivityCounterImpl r0) {
            return r0.getOrCreateIdleTimeCounter();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetOrCreateRxTimeCounter, reason: not valid java name */
        static /* bridge */ /* synthetic */ TimeMultiStateCounter m7772$$Nest$mgetOrCreateRxTimeCounter(ControllerActivityCounterImpl r0) {
            return r0.getOrCreateRxTimeCounter();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetOrCreateTxTimeCounters, reason: not valid java name */
        static /* bridge */ /* synthetic */ TimeMultiStateCounter[] m7773$$Nest$mgetOrCreateTxTimeCounters(ControllerActivityCounterImpl r0) {
            return r0.getOrCreateTxTimeCounters();
        }

        /* JADX INFO: renamed from: -$$Nest$msetState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7774$$Nest$msetState(ControllerActivityCounterImpl r0, int r1, long r2) {
            r0.setState(r1, r2);
        }

        public /* bridge */ /* synthetic */ BatteryStats.LongCounter getMonitoredRailChargeConsumedMaMs() {
            return m7775getMonitoredRailChargeConsumedMaMs();
        }

        public /* bridge */ /* synthetic */ BatteryStats.LongCounter getPowerCounter() {
            return m7776getPowerCounter();
        }

        public /* bridge */ /* synthetic */ BatteryStats.LongCounter getScanTimeCounter() {
            return m7777getScanTimeCounter();
        }

        public /* bridge */ /* synthetic */ BatteryStats.LongCounter getSleepTimeCounter() {
            return m7778getSleepTimeCounter();
        }

        public ControllerActivityCounterImpl(Clock clock, TimeBase timeBase, int numTxStates) {
            this.mClock = clock;
            this.mTimeBase = timeBase;
            this.mNumTxStates = numTxStates;
            this.mScanTimeMillis = new LongSamplingCounter(timeBase);
            this.mSleepTimeMillis = new LongSamplingCounter(timeBase);
            this.mPowerDrainMaMs = new LongSamplingCounter(timeBase);
            this.mMonitoredRailChargeConsumedMaMs = new LongSamplingCounter(timeBase);
        }

        public void readSummaryFromParcel(Parcel in) {
            this.mIdleTimeMillis = readTimeMultiStateCounter(in, this.mTimeBase);
            this.mScanTimeMillis.readSummaryFromParcelLocked(in);
            this.mSleepTimeMillis.readSummaryFromParcelLocked(in);
            this.mRxTimeMillis = readTimeMultiStateCounter(in, this.mTimeBase);
            this.mTxTimeMillis = readTimeMultiStateCounters(in, this.mTimeBase, this.mNumTxStates);
            this.mPowerDrainMaMs.readSummaryFromParcelLocked(in);
            this.mMonitoredRailChargeConsumedMaMs.readSummaryFromParcelLocked(in);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void writeSummaryToParcel(Parcel dest) {
            writeTimeMultiStateCounter(dest, this.mIdleTimeMillis);
            this.mScanTimeMillis.writeSummaryFromParcelLocked(dest);
            this.mSleepTimeMillis.writeSummaryFromParcelLocked(dest);
            writeTimeMultiStateCounter(dest, this.mRxTimeMillis);
            writeTimeMultiStateCounters(dest, this.mTxTimeMillis);
            this.mPowerDrainMaMs.writeSummaryFromParcelLocked(dest);
            this.mMonitoredRailChargeConsumedMaMs.writeSummaryFromParcelLocked(dest);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            writeTimeMultiStateCounter(dest, this.mIdleTimeMillis);
            this.mScanTimeMillis.writeToParcel(dest);
            this.mSleepTimeMillis.writeToParcel(dest);
            writeTimeMultiStateCounter(dest, this.mRxTimeMillis);
            writeTimeMultiStateCounters(dest, this.mTxTimeMillis);
            this.mPowerDrainMaMs.writeToParcel(dest);
            this.mMonitoredRailChargeConsumedMaMs.writeToParcel(dest);
        }

        private TimeMultiStateCounter readTimeMultiStateCounter(Parcel in, TimeBase timeBase) {
            if (in.readBoolean() == true) goto L5;
            return null;
        L5:
            return TimeMultiStateCounter.m7795$$Nest$smreadFromParcel(in, timeBase, 5, this.mClock.elapsedRealtime());
        }

        private void writeTimeMultiStateCounter(Parcel dest, TimeMultiStateCounter counter) {
            if (counter == null) goto L4;
            dest.writeBoolean(true);
            TimeMultiStateCounter.m7794$$Nest$mwriteToParcel(counter, dest);
            return;
        L4:
            dest.writeBoolean(false);
        }

        private TimeMultiStateCounter[] readTimeMultiStateCounters(Parcel in, TimeBase timeBase, int expectedNumCounters) {
            if (in.readBoolean() == false) goto L18;
            int numCounters = in.readInt();
            if (numCounters != expectedNumCounters) goto L7;
            boolean valid = true;
        L8:
            TimeMultiStateCounter[] counters = new TimeMultiStateCounter[numCounters];
            int i = 0;
        L9:
            if (i >= numCounters) goto L16;
            TimeMultiStateCounter counter = TimeMultiStateCounter.m7795$$Nest$smreadFromParcel(in, timeBase, 5, this.mClock.elapsedRealtime());
            if (counter == null) goto L13;
            counters[i] = counter;
        L14:
            i = i + 1;
            goto L9
        L13:
            valid = false;
            goto L14
        L16:
            if (valid == false) goto L23;
            return counters;
        L23:
            return null;
        L7:
            valid = false;
            goto L8
        L18:
            return null;
        }

        private void writeTimeMultiStateCounters(Parcel dest, TimeMultiStateCounter[] counters) {
            int r0 = 0;
            if (counters == null) goto L8;
            dest.writeBoolean(true);
            dest.writeInt(counters.length);
            int r1 = counters.length;
        L6:
            if (r0 >= r1) goto L11;
            TimeMultiStateCounter counter = counters[r0];
            TimeMultiStateCounter.m7794$$Nest$mwriteToParcel(counter, dest);
            r0 = r0 + 1;
            goto L6
        L11:
            return;
        L8:
            dest.writeBoolean(false);
        }

        public void reset(boolean detachIfReset, long elapsedRealtimeUs) {
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mIdleTimeMillis, detachIfReset, elapsedRealtimeUs);
            this.mScanTimeMillis.reset(detachIfReset, elapsedRealtimeUs);
            this.mSleepTimeMillis.reset(detachIfReset, elapsedRealtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mRxTimeMillis, detachIfReset, elapsedRealtimeUs);
            BatteryStatsImpl.m7757$$Nest$smresetIfNotNull(this.mTxTimeMillis, detachIfReset, elapsedRealtimeUs);
            this.mPowerDrainMaMs.reset(detachIfReset, elapsedRealtimeUs);
            this.mMonitoredRailChargeConsumedMaMs.reset(detachIfReset, elapsedRealtimeUs);
        }

        public void detach() {
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mIdleTimeMillis);
            this.mScanTimeMillis.detach();
            this.mSleepTimeMillis.detach();
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mRxTimeMillis);
            BatteryStatsImpl.m7752$$Nest$smdetachIfNotNull(this.mTxTimeMillis);
            this.mPowerDrainMaMs.detach();
            this.mMonitoredRailChargeConsumedMaMs.detach();
        }

        public BatteryStats.LongCounter getIdleTimeCounter() {
            if (this.mIdleTimeMillis != null) goto L7;
            return BatteryStatsImpl.m7748$$Nest$sfgetZERO_LONG_COUNTER();
        L7:
            return this.mIdleTimeMillis;
        }

        private TimeMultiStateCounter getOrCreateIdleTimeCounter() {
            if (this.mIdleTimeMillis != null) goto L6;
            this.mIdleTimeMillis = createTimeMultiStateCounter();
        L6:
            return this.mIdleTimeMillis;
        }

        /* JADX INFO: renamed from: getScanTimeCounter, reason: collision with other method in class */
        public LongSamplingCounter m7777getScanTimeCounter() {
            return this.mScanTimeMillis;
        }

        /* JADX INFO: renamed from: getSleepTimeCounter, reason: collision with other method in class */
        public LongSamplingCounter m7778getSleepTimeCounter() {
            return this.mSleepTimeMillis;
        }

        public BatteryStats.LongCounter getRxTimeCounter() {
            if (this.mRxTimeMillis != null) goto L7;
            return BatteryStatsImpl.m7748$$Nest$sfgetZERO_LONG_COUNTER();
        L7:
            return this.mRxTimeMillis;
        }

        private TimeMultiStateCounter getOrCreateRxTimeCounter() {
            if (this.mRxTimeMillis != null) goto L6;
            this.mRxTimeMillis = createTimeMultiStateCounter();
        L6:
            return this.mRxTimeMillis;
        }

        public BatteryStats.LongCounter[] getTxTimeCounters() {
            if (this.mTxTimeMillis != null) goto L7;
            return BatteryStatsImpl.m7749$$Nest$sfgetZERO_LONG_COUNTER_ARRAY();
        L7:
            return this.mTxTimeMillis;
        }

        private TimeMultiStateCounter[] getOrCreateTxTimeCounters() {
            if (this.mTxTimeMillis != null) goto L9;
            this.mTxTimeMillis = new TimeMultiStateCounter[this.mNumTxStates];
            int i = 0;
        L6:
            if (i >= this.mNumTxStates) goto L9;
            this.mTxTimeMillis[i] = createTimeMultiStateCounter();
            i = i + 1;
        L9:
            return this.mTxTimeMillis;
        }

        private TimeMultiStateCounter createTimeMultiStateCounter() {
            long timestampMs = this.mClock.elapsedRealtime();
            TimeMultiStateCounter counter = new TimeMultiStateCounter(this.mTimeBase, 5, timestampMs, null);
            TimeMultiStateCounter.m7792$$Nest$msetState(counter, BatteryStats.mapUidProcessStateToBatteryConsumerProcessState(this.mProcessState), timestampMs);
            TimeMultiStateCounter.m7793$$Nest$mupdate(counter, 0, timestampMs);
            return counter;
        }

        /* JADX INFO: renamed from: getPowerCounter, reason: collision with other method in class */
        public LongSamplingCounter m7776getPowerCounter() {
            return this.mPowerDrainMaMs;
        }

        /* JADX INFO: renamed from: getMonitoredRailChargeConsumedMaMs, reason: collision with other method in class */
        public LongSamplingCounter m7775getMonitoredRailChargeConsumedMaMs() {
            return this.mMonitoredRailChargeConsumedMaMs;
        }

        private void setState(int processState, long elapsedTimeMs) {
            this.mProcessState = processState;
            if (this.mIdleTimeMillis == null) goto L6;
            TimeMultiStateCounter.m7792$$Nest$msetState(this.mIdleTimeMillis, processState, elapsedTimeMs);
        L6:
            if (this.mRxTimeMillis == null) goto L9;
            TimeMultiStateCounter.m7792$$Nest$msetState(this.mRxTimeMillis, processState, elapsedTimeMs);
        L9:
            if (this.mTxTimeMillis == null) goto L14;
            int i = 0;
        L12:
            if (i >= this.mTxTimeMillis.length) goto L16;
            TimeMultiStateCounter.m7792$$Nest$msetState(this.mTxTimeMillis[i], processState, elapsedTimeMs);
            i = i + 1;
            goto L12
        L16:
            return;
        }
    }

    public static class Counter extends BatteryStats.Counter implements TimeBaseObs {
        final AtomicInteger mCount;
        final TimeBase mTimeBase;

        public Counter(TimeBase timeBase, Parcel in) {
            this.mCount = new AtomicInteger();
            this.mTimeBase = timeBase;
            this.mCount.set(in.readInt());
            timeBase.add(this);
        }

        public Counter(TimeBase timeBase) {
            this.mCount = new AtomicInteger();
            this.mTimeBase = timeBase;
            timeBase.add(this);
        }

        public void writeToParcel(Parcel out) {
            out.writeInt(this.mCount.get());
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
        }

        public int getCountLocked(int which) {
            return this.mCount.get();
        }

        public void logState(Printer pw, String prefix) {
            pw.println(prefix + "mCount=" + this.mCount.get());
        }

        public void stepAtomic() {
            if (this.mTimeBase.isRunning() == false) goto L6;
            this.mCount.incrementAndGet();
            return;
        }

        void addAtomic(int delta) {
            if (this.mTimeBase.isRunning() == false) goto L6;
            this.mCount.addAndGet(delta);
            return;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            this.mCount.set(0);
            if (detachIfReset == false) goto L7;
            detach();
            return true;
        L7:
            return true;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void detach() {
            this.mTimeBase.remove(this);
        }

        public void writeSummaryFromParcelLocked(Parcel out) {
            out.writeInt(this.mCount.get());
        }

        public void readSummaryFromParcelLocked(Parcel in) {
            this.mCount.set(in.readInt());
        }
    }

    public static class CpuDeltaPowerAccumulator {
        private Uid mCachedUid;
        private final CpuPowerCalculator mCalculator;
        private double[] mUidClusterCache;
        public final ArrayMap<Uid, double[]> perUidCpuClusterChargesMah;
        public final double[] totalClusterChargesMah;

        CpuDeltaPowerAccumulator(CpuPowerCalculator calculator, int nClusters) {
            this.mCachedUid = null;
            this.mUidClusterCache = null;
            this.mCalculator = calculator;
            this.totalClusterChargesMah = new double[nClusters];
            this.perUidCpuClusterChargesMah = new ArrayMap();
        }

        public void addCpuClusterDurationsMs(Uid uid, long[] durationsMs) {
            double[] uidChargesMah = getOrCreateUidCpuClusterCharges(uid);
            int cluster = 0;
        L4:
            if (cluster >= durationsMs.length) goto L7;
            double estimatedDeltaMah = this.mCalculator.calculatePerCpuClusterPowerMah(cluster, durationsMs[cluster]);
            uidChargesMah[cluster] = uidChargesMah[cluster] + estimatedDeltaMah;
            double[] r4 = this.totalClusterChargesMah;
            r4[cluster] = r4[cluster] + estimatedDeltaMah;
            cluster = cluster + 1;
            goto L4
        }

        public void addCpuClusterSpeedDurationsMs(Uid uid, int cluster, int speed, long durationsMs) {
            double[] uidChargesMah = getOrCreateUidCpuClusterCharges(uid);
            double estimatedDeltaMah = this.mCalculator.calculatePerCpuFreqPowerMah(cluster, speed, durationsMs);
            uidChargesMah[cluster] = uidChargesMah[cluster] + estimatedDeltaMah;
            double[] r3 = this.totalClusterChargesMah;
            r3[cluster] = r3[cluster] + estimatedDeltaMah;
        }

        private double[] getOrCreateUidCpuClusterCharges(Uid uid) {
            if (uid == this.mCachedUid) goto L5;
            double[] uidChargesMah = this.perUidCpuClusterChargesMah.get(uid);
            if (uidChargesMah != null) goto L9;
            uidChargesMah = new double[this.totalClusterChargesMah.length];
            this.perUidCpuClusterChargesMah.put(uid, uidChargesMah);
        L9:
            this.mCachedUid = uid;
            this.mUidClusterCache = uidChargesMah;
            return uidChargesMah;
        L5:
            return this.mUidClusterCache;
        }
    }

    private static class DisplayBatteryStats {
        public int screenBrightnessBin;
        public StopwatchTimer[] screenBrightnessTimers;
        public StopwatchTimer screenDozeTimer;
        public StopwatchTimer screenOnTimer;
        public int screenState;
        public int screenStateAtLastEnergyMeasurement;

        DisplayBatteryStats(Clock clock, TimeBase timeBase) {
            this.screenState = 0;
            this.screenBrightnessBin = -1;
            this.screenBrightnessTimers = new StopwatchTimer[5];
            this.screenStateAtLastEnergyMeasurement = 0;
            this.screenOnTimer = new StopwatchTimer(clock, null, -1, null, timeBase);
            this.screenDozeTimer = new StopwatchTimer(clock, null, -1, null, timeBase);
            int i = 0;
        L3:
            if (i >= 5) goto L6;
            this.screenBrightnessTimers[i] = new StopwatchTimer(clock, null, (-100) - i, null, timeBase);
            i = i + 1;
            goto L3
        }

        public void reset(long elapsedRealtimeUs) {
            this.screenOnTimer.reset(false, elapsedRealtimeUs);
            this.screenDozeTimer.reset(false, elapsedRealtimeUs);
            int i = 0;
        L4:
            if (i >= 5) goto L7;
            this.screenBrightnessTimers[i].reset(false, elapsedRealtimeUs);
            i = i + 1;
            goto L4
        }

        public void writeSummaryToParcel(Parcel out, long elapsedRealtimeUs) {
            this.screenOnTimer.writeSummaryFromParcelLocked(out, elapsedRealtimeUs);
            this.screenDozeTimer.writeSummaryFromParcelLocked(out, elapsedRealtimeUs);
            int i = 0;
        L4:
            if (i >= 5) goto L7;
            this.screenBrightnessTimers[i].writeSummaryFromParcelLocked(out, elapsedRealtimeUs);
            i = i + 1;
            goto L4
        }

        public void readSummaryFromParcel(Parcel in) {
            this.screenOnTimer.readSummaryFromParcelLocked(in);
            this.screenDozeTimer.readSummaryFromParcelLocked(in);
            int i = 0;
        L4:
            if (i >= 5) goto L7;
            this.screenBrightnessTimers[i].readSummaryFromParcelLocked(in);
            i = i + 1;
            goto L4
        }
    }

    public static class DualTimer extends DurationTimer {
        private final DurationTimer mSubTimer;

        public /* bridge */ /* synthetic */ BatteryStats.Timer getSubTimer() {
            return m7779getSubTimer();
        }

        public DualTimer(Clock clock, Uid uid, int type, ArrayList<StopwatchTimer> timerPool, TimeBase timeBase, TimeBase subTimeBase, Parcel in) {
            super(clock, uid, type, timerPool, timeBase, in);
            this.mSubTimer = new DurationTimer(clock, uid, type, null, subTimeBase, in);
        }

        public DualTimer(Clock clock, Uid uid, int type, ArrayList<StopwatchTimer> timerPool, TimeBase timeBase, TimeBase subTimeBase) {
            super(clock, uid, type, timerPool, timeBase);
            this.mSubTimer = new DurationTimer(clock, uid, type, null, subTimeBase);
        }

        /* JADX INFO: renamed from: getSubTimer, reason: collision with other method in class */
        public DurationTimer m7779getSubTimer() {
            return this.mSubTimer;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.DurationTimer, com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer
        public void startRunningLocked(long elapsedRealtimeMs) {
            super.startRunningLocked(elapsedRealtimeMs);
            this.mSubTimer.startRunningLocked(elapsedRealtimeMs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.DurationTimer, com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer
        public void stopRunningLocked(long elapsedRealtimeMs) {
            super.stopRunningLocked(elapsedRealtimeMs);
            this.mSubTimer.stopRunningLocked(elapsedRealtimeMs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer
        public void stopAllRunningLocked(long elapsedRealtimeMs) {
            super.stopAllRunningLocked(elapsedRealtimeMs);
            this.mSubTimer.stopAllRunningLocked(elapsedRealtimeMs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.DurationTimer, com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer, com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            boolean active = false | (!this.mSubTimer.reset(false, elapsedRealtimeUs));
            return !(active | (!super.reset(detachIfReset, elapsedRealtimeUs)));
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer, com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void detach() {
            this.mSubTimer.detach();
            super.detach();
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.DurationTimer, com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer, com.android.server.power.stats.BatteryStatsImpl.Timer
        public void writeToParcel(Parcel out, long elapsedRealtimeUs) {
            super.writeToParcel(out, elapsedRealtimeUs);
            this.mSubTimer.writeToParcel(out, elapsedRealtimeUs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.DurationTimer, com.android.server.power.stats.BatteryStatsImpl.Timer
        public void writeSummaryFromParcelLocked(Parcel out, long elapsedRealtimeUs) {
            super.writeSummaryFromParcelLocked(out, elapsedRealtimeUs);
            this.mSubTimer.writeSummaryFromParcelLocked(out, elapsedRealtimeUs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.DurationTimer, com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer, com.android.server.power.stats.BatteryStatsImpl.Timer
        public void readSummaryFromParcelLocked(Parcel in) {
            super.readSummaryFromParcelLocked(in);
            this.mSubTimer.readSummaryFromParcelLocked(in);
        }
    }

    public static class DurationTimer extends StopwatchTimer {
        long mCurrentDurationMs;
        long mMaxDurationMs;
        long mStartTimeMs;
        long mTotalDurationMs;

        public DurationTimer(Clock clock, Uid uid, int type, ArrayList<StopwatchTimer> timerPool, TimeBase timeBase, Parcel in) {
            super(clock, uid, type, timerPool, timeBase, in);
            this.mStartTimeMs = -1;
            this.mMaxDurationMs = in.readLong();
            this.mTotalDurationMs = in.readLong();
            this.mCurrentDurationMs = in.readLong();
        }

        public DurationTimer(Clock clock, Uid uid, int type, ArrayList<StopwatchTimer> timerPool, TimeBase timeBase) {
            super(clock, uid, type, timerPool, timeBase);
            this.mStartTimeMs = -1;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer, com.android.server.power.stats.BatteryStatsImpl.Timer
        public void writeToParcel(Parcel out, long elapsedRealtimeUs) {
            super.writeToParcel(out, elapsedRealtimeUs);
            out.writeLong(getMaxDurationMsLocked(elapsedRealtimeUs / 1000));
            out.writeLong(this.mTotalDurationMs);
            out.writeLong(getCurrentDurationMsLocked(elapsedRealtimeUs / 1000));
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        public void writeSummaryFromParcelLocked(Parcel out, long elapsedRealtimeUs) {
            super.writeSummaryFromParcelLocked(out, elapsedRealtimeUs);
            out.writeLong(getMaxDurationMsLocked(elapsedRealtimeUs / 1000));
            out.writeLong(getTotalDurationMsLocked(elapsedRealtimeUs / 1000));
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer, com.android.server.power.stats.BatteryStatsImpl.Timer
        public void readSummaryFromParcelLocked(Parcel in) {
            super.readSummaryFromParcelLocked(in);
            this.mMaxDurationMs = in.readLong();
            this.mTotalDurationMs = in.readLong();
            this.mStartTimeMs = -1;
            this.mCurrentDurationMs = 0;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            super.onTimeStarted(elapsedRealtimeUs, baseUptimeUs, baseRealtimeUs);
            if (this.mNesting <= 0) goto L6;
            this.mStartTimeMs = baseRealtimeUs / 1000;
            return;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer, com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            super.onTimeStopped(elapsedRealtimeUs, baseUptimeUs, baseRealtimeUs);
            if (this.mNesting <= 0) goto L5;
            this.mCurrentDurationMs += (baseRealtimeUs / 1000) - this.mStartTimeMs;
        L5:
            this.mStartTimeMs = -1;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer, com.android.server.power.stats.BatteryStatsImpl.Timer
        public void logState(Printer pw, String prefix) {
            super.logState(pw, prefix);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer
        public void startRunningLocked(long elapsedRealtimeMs) {
            super.startRunningLocked(elapsedRealtimeMs);
            if (this.mNesting == 1) goto L5;
            return;
        L5:
            if (this.mTimeBase.isRunning() == false) goto L9;
            this.mStartTimeMs = this.mTimeBase.getRealtime(elapsedRealtimeMs * 1000) / 1000;
            return;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer
        public void stopRunningLocked(long elapsedRealtimeMs) {
            if (this.mNesting != 1) goto L8;
            long durationMs = getCurrentDurationMsLocked(elapsedRealtimeMs);
            this.mTotalDurationMs += durationMs;
            if (durationMs <= this.mMaxDurationMs) goto L7;
            this.mMaxDurationMs = durationMs;
        L7:
            this.mStartTimeMs = -1;
            this.mCurrentDurationMs = 0;
        L8:
            super.stopRunningLocked(elapsedRealtimeMs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer, com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            boolean result = super.reset(detachIfReset, elapsedRealtimeUs);
            this.mMaxDurationMs = 0;
            this.mTotalDurationMs = 0;
            this.mCurrentDurationMs = 0;
            if (this.mNesting <= 0) goto L5;
            this.mStartTimeMs = this.mTimeBase.getRealtime(elapsedRealtimeUs) / 1000;
        L6:
            return result;
        L5:
            this.mStartTimeMs = -1;
            goto L6
        }

        public long getMaxDurationMsLocked(long elapsedRealtimeMs) {
            if (this.mNesting <= 0) goto L8;
            long durationMs = getCurrentDurationMsLocked(elapsedRealtimeMs);
            if (durationMs <= this.mMaxDurationMs) goto L8;
            return durationMs;
        L8:
            return this.mMaxDurationMs;
        }

        public long getCurrentDurationMsLocked(long elapsedRealtimeMs) {
            long durationMs = this.mCurrentDurationMs;
            if (this.mNesting > 0) goto L5;
            return durationMs;
        L5:
            if (this.mTimeBase.isRunning() == true) goto L7;
            return durationMs;
        L7:
            return durationMs + ((this.mTimeBase.getRealtime(elapsedRealtimeMs * 1000) / 1000) - this.mStartTimeMs);
        }

        public long getTotalDurationMsLocked(long elapsedRealtimeMs) {
            return this.mTotalDurationMs + getCurrentDurationMsLocked(elapsedRealtimeMs);
        }
    }

    public interface EnergyStatsRetriever {
        void fillRailDataStats(RailStats r1);
    }

    public interface ExternalStatsSync {
        public static final int RESET = 128;
        public static final int UPDATE_ALL = 127;
        public static final int UPDATE_BT = 8;
        public static final int UPDATE_CAMERA = 64;
        public static final int UPDATE_CPU = 1;
        public static final int UPDATE_DISPLAY = 32;
        public static final int UPDATE_ON_PROC_STATE_CHANGE = 14;
        public static final int UPDATE_ON_RESET = 255;
        public static final int UPDATE_RADIO = 4;
        public static final int UPDATE_RPM = 16;
        public static final int UPDATE_WIFI = 2;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ExternalUpdateFlag {
        }

        void cancelCpuSyncDueToWakelockChange();

        void scheduleCleanupDueToRemovedUser(int r1);

        void scheduleCpuSyncDueToRemovedUid(int r1);

        void scheduleCpuSyncDueToWakelockChange(long r1);

        void scheduleSync(String r1, int r2);

        void scheduleSyncDueToProcessStateChange(int r1, long r2);

        void scheduleSyncDueToScreenStateChange(int r1, boolean r2, boolean r3, int r4, int[] r5);
    }

    public static class FrameworkStatsLogger {
        public FrameworkStatsLogger() {
        }

        public void uidProcessStateChanged(int uid, int state) {
            FrameworkStatsLog.write(27, uid, ActivityManager.processStateAmToProto(state));
        }

        public void wakelockStateChanged(int uid, WorkSource.WorkChain wc, String name, int procState, boolean acquired, int powerManagerWakeLockLevel) {
            if (acquired == false) goto L4;
            int r0 = 1;
        L5:
            int event = r0;
            if (wc == null) goto L8;
            FrameworkStatsLog.write(10, wc.getUids(), wc.getTags(), powerManagerWakeLockLevel, name, event, procState);
            return;
        L8:
            FrameworkStatsLog.write_non_chained(10, uid, null, powerManagerWakeLockLevel, name, event, procState);
            return;
        L4:
            r0 = 0;
            goto L5
        }

        public void kernelWakeupReported(long deltaUptimeUs, String lastWakeupReason, long lastWakeupElapsedTimeMs) {
            FrameworkStatsLog.write(36, lastWakeupReason, deltaUptimeUs, lastWakeupElapsedTimeMs);
        }

        public void gpsScanStateChanged(int uid, WorkSource.WorkChain workChain, boolean stateOn) {
            if (stateOn == false) goto L4;
            int event = 1;
        L6:
            if (workChain == null) goto L8;
            FrameworkStatsLog.write(6, workChain.getUids(), workChain.getTags(), event);
            return;
        L8:
            FrameworkStatsLog.write_non_chained(6, uid, null, event);
            return;
        L4:
            event = 0;
            goto L6
        }

        public void batterySaverModeChanged(boolean enabled) {
            if (enabled == false) goto L4;
            int r0 = 1;
        L5:
            FrameworkStatsLog.write(20, r0);
            return;
        L4:
            r0 = 0;
            goto L5
        }

        public void deviceIdlingModeStateChanged(int mode) {
            FrameworkStatsLog.write(22, mode);
        }

        public void deviceIdleModeStateChanged(int mode) {
            FrameworkStatsLog.write(21, mode);
        }

        public void chargingStateChanged(int status) {
            FrameworkStatsLog.write(31, status);
        }

        public void pluggedStateChanged(int plugType) {
            FrameworkStatsLog.write(32, plugType);
        }

        public void batteryLevelChanged(int level) {
            FrameworkStatsLog.write(30, level);
        }

        public void phoneServiceStateChanged(int state, int simState, int strengthBin) {
            FrameworkStatsLog.write(94, state, simState, strengthBin);
        }

        public void phoneSignalStrengthChanged(int strengthBin) {
            FrameworkStatsLog.write(40, strengthBin);
        }

        public void writeCommitSysConfigFile(String fileName, long durationMs) {
            EventLogTags.writeCommitSysConfigFile(fileName, durationMs);
        }
    }

    public static class LongSamplingCounter extends BatteryStats.LongCounter implements TimeBaseObs {
        private long mCount;
        final TimeBase mTimeBase;

        public LongSamplingCounter(TimeBase timeBase, Parcel in) {
            this.mTimeBase = timeBase;
            this.mCount = in.readLong();
            timeBase.add(this);
        }

        public LongSamplingCounter(TimeBase timeBase) {
            this.mTimeBase = timeBase;
            timeBase.add(this);
        }

        public void writeToParcel(Parcel out) {
            out.writeLong(this.mCount);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
        }

        public long getCountLocked(int which) {
            return this.mCount;
        }

        public long getCountForProcessState(int procState) {
            if (procState == (-1)) goto L5;
            return 0;
        L5:
            return getCountLocked(0);
        }

        public void logState(Printer pw, String prefix) {
            pw.println(prefix + "mCount=" + this.mCount);
        }

        public void addCountLocked(long count) {
            addCountLocked(count, this.mTimeBase.isRunning());
        }

        public void addCountLocked(long count, boolean isRunning) {
            if (isRunning == false) goto L5;
            this.mCount += count;
            return;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            this.mCount = 0;
            if (detachIfReset == false) goto L7;
            detach();
            return true;
        L7:
            return true;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void detach() {
            this.mTimeBase.remove(this);
        }

        public void writeSummaryFromParcelLocked(Parcel out) {
            out.writeLong(this.mCount);
        }

        public void readSummaryFromParcelLocked(Parcel in) {
            this.mCount = in.readLong();
        }
    }

    public static class LongSamplingCounterArray extends BatteryStats.LongCounterArray implements TimeBaseObs {
        public long[] mCounts;
        final TimeBase mTimeBase;

        /* JADX INFO: renamed from: -$$Nest$mreadSummaryFromParcelLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7780$$Nest$mreadSummaryFromParcelLocked(LongSamplingCounterArray r0, Parcel r1) {
            r0.readSummaryFromParcelLocked(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mwriteSummaryToParcelLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7781$$Nest$mwriteSummaryToParcelLocked(LongSamplingCounterArray r0, Parcel r1) {
            r0.writeSummaryToParcelLocked(r1);
        }

        private LongSamplingCounterArray(TimeBase timeBase, Parcel in) {
            this.mTimeBase = timeBase;
            this.mCounts = in.createLongArray();
            timeBase.add(this);
        }

        public LongSamplingCounterArray(TimeBase timeBase) {
            this.mTimeBase = timeBase;
            timeBase.add(this);
        }

        private void writeToParcel(Parcel out) {
            out.writeLongArray(this.mCounts);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long elapsedRealTimeUs, long baseUptimeUs, long baseRealtimeUs) {
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
        }

        public long[] getCountsLocked(int which) {
            if (this.mCounts != null) goto L6;
            return null;
        L6:
            return Arrays.copyOf(this.mCounts, this.mCounts.length);
        }

        public void logState(Printer pw, String prefix) {
            pw.println(prefix + "mCounts=" + Arrays.toString(this.mCounts));
        }

        public void addCountLocked(long[] counts) {
            addCountLocked(counts, this.mTimeBase.isRunning());
        }

        public void addCountLocked(long[] counts, boolean isRunning) {
            if (counts != null) goto L4;
            return;
        L4:
            if (isRunning == true) goto L6;
            return;
        L6:
            if (this.mCounts != null) goto L8;
            this.mCounts = new long[counts.length];
        L8:
            int i = 0;
        L10:
            if (i >= counts.length) goto L14;
            long[] r1 = this.mCounts;
            r1[i] = r1[i] + counts[i];
            i = i + 1;
            goto L10
        }

        public int getSize() {
            if (this.mCounts != null) goto L6;
            return 0;
        L6:
            return this.mCounts.length;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            if (this.mCounts == null) goto L5;
            Arrays.fill(this.mCounts, 0);
        L5:
            if (detachIfReset == false) goto L9;
            detach();
            return true;
        L9:
            return true;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void detach() {
            this.mTimeBase.remove(this);
        }

        private void writeSummaryToParcelLocked(Parcel out) {
            out.writeLongArray(this.mCounts);
        }

        private void readSummaryFromParcelLocked(Parcel in) {
            this.mCounts = in.createLongArray();
        }

        public static void writeToParcel(Parcel out, LongSamplingCounterArray counterArray) {
            if (counterArray == null) goto L4;
            out.writeInt(1);
            counterArray.writeToParcel(out);
            return;
        L4:
            out.writeInt(0);
        }

        public static LongSamplingCounterArray readFromParcel(Parcel in, TimeBase timeBase) {
            if (in.readInt() != 0) goto L5;
            return null;
        L5:
            return new LongSamplingCounterArray(timeBase, in);
        }

        public static void writeSummaryToParcelLocked(Parcel out, LongSamplingCounterArray counterArray) {
            if (counterArray == null) goto L4;
            out.writeInt(1);
            counterArray.writeSummaryToParcelLocked(out);
            return;
        L4:
            out.writeInt(0);
        }

        public static LongSamplingCounterArray readSummaryFromParcelLocked(Parcel in, TimeBase timeBase) {
            if (in.readInt() == 0) goto L6;
            LongSamplingCounterArray counterArray = new LongSamplingCounterArray(timeBase);
            counterArray.readSummaryFromParcelLocked(in);
            return counterArray;
        L6:
            return null;
        }
    }

    final class MyHandler extends Handler {
        final /* synthetic */ BatteryStatsImpl this$0;

        public MyHandler(BatteryStatsImpl this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            BatteryCallback cb = BatteryStatsImpl.m7715$$Nest$fgetmCallback(this.this$0);
            if (cb != null) goto L6;
            return;
        L6:
            switch(msg.what) {
                case 1: goto L27;
                case 2: goto L23;
                case 3: goto L9;
                case 4: goto L8;
                default: goto L34;
            };
        L8:
            cb.batteryStatsReset();
            return;
        L9:
            BatteryStatsImpl r1 = this.this$0;
            monitor-enter(r1);
        L14:
            th = move-exception;
            throw th;
        L12:
            if (this.this$0.mCharging == false) goto L16;
            String action = "android.os.action.CHARGING";
        L18:
            monitor-exit(r1);     // Catch: Throwable -> L14
            Intent intent = new Intent(action);
            intent.addFlags(67108864);
            cb.batterySendBroadcast(intent);
            return;
        L16:
            action = "android.os.action.DISCHARGING";
            goto L18
        L27:
            cb.batteryNeedsCpuUpdate();
            return;
        L34:
            return;
        L23:
            if (msg.arg1 == 0) goto L25;
            boolean r2 = true;
        L26:
            cb.batteryPowerChanged(r2);
            return;
        L25:
            r2 = false;
            goto L26
        }
    }

    public abstract class OverflowArrayMap<T> {
        private static final String OVERFLOW_NAME = "*overflow*";
        ArrayMap<String, MutableInt> mActiveOverflow;
        T mCurOverflow;
        long mLastCleanupTimeMs;
        long mLastClearTimeMs;
        long mLastOverflowFinishTimeMs;
        long mLastOverflowTimeMs;
        final ArrayMap<String, T> mMap;
        final int mUid;

        public abstract T instantiateObject();

        public OverflowArrayMap(BatteryStatsImpl this$0, int uid) {
            this.mMap = new ArrayMap();
            this.mUid = uid;
        }

        public ArrayMap<String, T> getMap() {
            return this.mMap;
        }

        public void clear() {
            this.mLastClearTimeMs = SystemClock.elapsedRealtime();
            this.mMap.clear();
            this.mCurOverflow = null;
            this.mActiveOverflow = null;
        }

        public void add(String name, T obj) {
            if (name != null) goto L4;
            name = "";
        L4:
            this.mMap.put(name, obj);
            if ("*overflow*".equals(name) == false) goto L8;
            this.mCurOverflow = obj;
            return;
        }

        public void cleanup(long elapsedRealtimeMs) {
            this.mLastCleanupTimeMs = elapsedRealtimeMs;
            if (this.mActiveOverflow == null) goto L8;
            if (this.mActiveOverflow.size() != 0) goto L8;
            this.mActiveOverflow = null;
        L8:
            if (this.mActiveOverflow != null) goto L14;
            if (this.mMap.containsKey("*overflow*") == false) goto L12;
            Slog.wtf(BatteryStatsImpl.TAG, "Cleaning up with no active overflow, but have overflow entry " + this.mMap.get("*overflow*"));
            this.mMap.remove("*overflow*");
        L12:
            this.mCurOverflow = null;
            return;
        L14:
            if (this.mCurOverflow != null) goto L16;
        L17:
            Slog.wtf(BatteryStatsImpl.TAG, "Cleaning up with active overflow, but no overflow entry: cur=" + this.mCurOverflow + " map=" + this.mMap.get("*overflow*"));
            return;
        L16:
            if (this.mMap.containsKey("*overflow*") == false) goto L17;
        }

        public T startObject(String name, long elapsedRealtimeMs) {
            if (name != null) goto L4;
            name = "";
        L4:
            T obj = this.mMap.get(name);
            if (obj == null) goto L8;
            return obj;
        L8:
            if (this.mActiveOverflow == null) goto L16;
            MutableInt over = this.mActiveOverflow.get(name);
            if (over == null) goto L16;
            T obj2 = this.mCurOverflow;
            if (obj2 != null) goto L14;
            Slog.wtf(BatteryStatsImpl.TAG, "Have active overflow " + name + " but null overflow");
            T r4 = instantiateObject();
            this.mCurOverflow = r4;
            obj2 = r4;
            this.mMap.put("*overflow*", obj2);
        L14:
            over.value++;
            return obj2;
        L16:
            int N = this.mMap.size();
            if (N < BatteryStatsImpl.m7746$$Nest$sfgetMAX_WAKELOCKS_PER_UID()) goto L26;
            T obj3 = this.mCurOverflow;
            if (obj3 != null) goto L22;
            T r5 = instantiateObject();
            this.mCurOverflow = r5;
            obj3 = r5;
            this.mMap.put("*overflow*", obj3);
        L22:
            if (this.mActiveOverflow != null) goto L24;
            this.mActiveOverflow = new ArrayMap();
        L24:
            this.mActiveOverflow.put(name, new MutableInt(1));
            this.mLastOverflowTimeMs = elapsedRealtimeMs;
            return obj3;
        L26:
            T obj4 = instantiateObject();
            this.mMap.put(name, obj4);
            return obj4;
        }

        public T stopObject(String name, long elapsedRealtimeMs) {
            if (name != null) goto L4;
            name = "";
        L4:
            T obj = this.mMap.get(name);
            if (obj == null) goto L8;
            return obj;
        L8:
            if (this.mActiveOverflow == null) goto L17;
            MutableInt over = this.mActiveOverflow.get(name);
            if (over == null) goto L17;
            T obj2 = this.mCurOverflow;
            if (obj2 == null) goto L17;
            over.value--;
            if (over.value > 0) goto L16;
            this.mActiveOverflow.remove(name);
            this.mLastOverflowFinishTimeMs = elapsedRealtimeMs;
        L16:
            return obj2;
        L17:
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to find object for ");
            sb.append(name);
            sb.append(" in uid ");
            sb.append(this.mUid);
            sb.append(" mapsize=");
            sb.append(this.mMap.size());
            sb.append(" activeoverflow=");
            sb.append(this.mActiveOverflow);
            sb.append(" curoverflow=");
            sb.append(this.mCurOverflow);
            if (this.mLastOverflowTimeMs == 0) goto L21;
            sb.append(" lastOverflowTime=");
            TimeUtils.formatDuration(this.mLastOverflowTimeMs - elapsedRealtimeMs, sb);
        L21:
            if (this.mLastOverflowFinishTimeMs == 0) goto L24;
            sb.append(" lastOverflowFinishTime=");
            TimeUtils.formatDuration(this.mLastOverflowFinishTimeMs - elapsedRealtimeMs, sb);
        L24:
            if (this.mLastClearTimeMs == 0) goto L27;
            sb.append(" lastClearTime=");
            TimeUtils.formatDuration(this.mLastClearTimeMs - elapsedRealtimeMs, sb);
        L27:
            if (this.mLastCleanupTimeMs == 0) goto L29;
            sb.append(" lastCleanupTime=");
            TimeUtils.formatDuration(this.mLastCleanupTimeMs - elapsedRealtimeMs, sb);
        L29:
            Slog.wtf(BatteryStatsImpl.TAG, sb.toString());
            return null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PerUidModemPowerModel {
    }

    public interface PlatformIdleStateCallback {
        void fillLowPowerStats(RpmStats r1);
    }

    private class PowerStatsCollectorInjector implements CpuPowerStatsCollector.Injector, ScreenPowerStatsCollector.Injector, MobileRadioPowerStatsCollector.Injector, WifiPowerStatsCollector.Injector, BluetoothPowerStatsCollector.Injector, EnergyConsumerPowerStatsCollector.Injector, WakelockPowerStatsCollector.Injector {
        private BluetoothPowerStatsCollector.BluetoothStatsRetriever mBluetoothStatsRetriever;
        private PowerStatsCollector.ConsumedEnergyRetriever mConsumedEnergyRetriever;
        private NetworkStatsManager mNetworkStatsManager;
        private PackageManager mPackageManager;
        private TelephonyManager mTelephonyManager;
        private WifiManager mWifiManager;
        final /* synthetic */ BatteryStatsImpl this$0;

        /* JADX INFO: renamed from: $r8$lambda$2EszRR8VBok57-Qh47O5zT15Piw, reason: not valid java name */
        public static /* synthetic */ int m7782$r8$lambda$2EszRR8VBok57Qh47O5zT15Piw(PowerStatsCollectorInjector r0) {
            return r0.lambda$setContext$0();
        }

        public static /* synthetic */ NetworkStats $r8$lambda$8SRteE7R2F8hKhioGWdLMmHOCxw(PowerStatsCollectorInjector r0) {
            return r0.lambda$getMobileNetworkStatsSupplier$1();
        }

        /* JADX INFO: renamed from: $r8$lambda$TYqbxANU7wNwk6ywAtDe-hMJ_4A, reason: not valid java name */
        public static /* synthetic */ NetworkStats m7783$r8$lambda$TYqbxANU7wNwk6ywAtDehMJ_4A(PowerStatsCollectorInjector r0) {
            return r0.lambda$getWifiNetworkStatsSupplier$2();
        }

        /* JADX INFO: renamed from: $r8$lambda$cOk1GC9PBp1jZcqUs-QSf9uXlJQ, reason: not valid java name */
        public static /* synthetic */ long m7784$r8$lambda$cOk1GC9PBp1jZcqUsQSf9uXlJQ(PowerStatsCollectorInjector r2) {
            return r2.lambda$getPhoneSignalScanDurationSupplier$4();
        }

        /* JADX INFO: renamed from: $r8$lambda$hqstqQU_C-5-K6D1zcs7KX6J0YE, reason: not valid java name */
        public static /* synthetic */ long m7785$r8$lambda$hqstqQU_C5K6D1zcs7KX6J0YE(PowerStatsCollectorInjector r2) {
            return r2.lambda$getCallDurationSupplier$3();
        }

        /* synthetic */ PowerStatsCollectorInjector(BatteryStatsImpl r1, BatteryStatsImplIA r2) {
            this(r1);
        }

        private PowerStatsCollectorInjector(BatteryStatsImpl r1) {
            this.this$0 = r1;
        }

        void setContext(Context context) {
            this.mPackageManager = context.getPackageManager();
            this.mConsumedEnergyRetriever = new PowerStatsCollector.ConsumedEnergyRetrieverImpl((PowerStatsInternal) LocalServices.getService(PowerStatsInternal.class), new BatteryStatsImpl$PowerStatsCollectorInjector$$ExternalSyntheticLambda2(this));
            this.mNetworkStatsManager = (NetworkStatsManager) context.getSystemService(NetworkStatsManager.class);
            this.mTelephonyManager = (TelephonyManager) context.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
            this.mWifiManager = (WifiManager) context.getSystemService("wifi");
            this.mBluetoothStatsRetriever = new BluetoothStatsRetrieverImpl(this.this$0, (BluetoothManager) context.getSystemService(BluetoothManager.class));
        }

        private /* synthetic */ int lambda$setContext$0() {
            return BatteryStatsImpl.m7713$$Nest$fgetmBatteryVoltageMv(this.this$0);
        }

        @Override // com.android.server.power.stats.CpuPowerStatsCollector.Injector, com.android.server.power.stats.ScreenPowerStatsCollector.Injector, com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector, com.android.server.power.stats.WifiPowerStatsCollector.Injector, com.android.server.power.stats.BluetoothPowerStatsCollector.Injector, com.android.server.power.stats.EnergyConsumerPowerStatsCollector.Injector, com.android.server.power.stats.WakelockPowerStatsCollector.Injector
        public Handler getHandler() {
            return this.this$0.mHandler;
        }

        @Override // com.android.server.power.stats.CpuPowerStatsCollector.Injector, com.android.server.power.stats.ScreenPowerStatsCollector.Injector, com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector, com.android.server.power.stats.WifiPowerStatsCollector.Injector, com.android.server.power.stats.BluetoothPowerStatsCollector.Injector, com.android.server.power.stats.EnergyConsumerPowerStatsCollector.Injector, com.android.server.power.stats.WakelockPowerStatsCollector.Injector
        public Clock getClock() {
            return this.this$0.mClock;
        }

        @Override // com.android.server.power.stats.CpuPowerStatsCollector.Injector, com.android.server.power.stats.ScreenPowerStatsCollector.Injector, com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector, com.android.server.power.stats.WifiPowerStatsCollector.Injector, com.android.server.power.stats.BluetoothPowerStatsCollector.Injector, com.android.server.power.stats.EnergyConsumerPowerStatsCollector.Injector, com.android.server.power.stats.WakelockPowerStatsCollector.Injector
        public long getPowerStatsCollectionThrottlePeriod(String powerComponentName) {
            return this.this$0.mBatteryStatsConfig.getPowerStatsThrottlePeriod(powerComponentName);
        }

        @Override // com.android.server.power.stats.CpuPowerStatsCollector.Injector, com.android.server.power.stats.ScreenPowerStatsCollector.Injector, com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector, com.android.server.power.stats.WifiPowerStatsCollector.Injector, com.android.server.power.stats.BluetoothPowerStatsCollector.Injector, com.android.server.power.stats.EnergyConsumerPowerStatsCollector.Injector, com.android.server.power.stats.WakelockPowerStatsCollector.Injector
        public PowerStatsUidResolver getUidResolver() {
            return this.this$0.mPowerStatsUidResolver;
        }

        @Override // com.android.server.power.stats.CpuPowerStatsCollector.Injector
        public CpuScalingPolicies getCpuScalingPolicies() {
            return this.this$0.mCpuScalingPolicies;
        }

        @Override // com.android.server.power.stats.CpuPowerStatsCollector.Injector
        public PowerProfile getPowerProfile() {
            return BatteryStatsImpl.m7725$$Nest$fgetmPowerProfile(this.this$0);
        }

        @Override // com.android.server.power.stats.CpuPowerStatsCollector.Injector
        public CpuPowerStatsCollector.KernelCpuStatsReader getKernelCpuStatsReader() {
            return new CpuPowerStatsCollector.KernelCpuStatsReader();
        }

        @Override // com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector, com.android.server.power.stats.WifiPowerStatsCollector.Injector, com.android.server.power.stats.BluetoothPowerStatsCollector.Injector
        public PackageManager getPackageManager() {
            return this.mPackageManager;
        }

        @Override // com.android.server.power.stats.CpuPowerStatsCollector.Injector, com.android.server.power.stats.ScreenPowerStatsCollector.Injector, com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector, com.android.server.power.stats.WifiPowerStatsCollector.Injector, com.android.server.power.stats.BluetoothPowerStatsCollector.Injector, com.android.server.power.stats.EnergyConsumerPowerStatsCollector.Injector
        public PowerStatsCollector.ConsumedEnergyRetriever getConsumedEnergyRetriever() {
            return this.mConsumedEnergyRetriever;
        }

        @Override // com.android.server.power.stats.ScreenPowerStatsCollector.Injector
        public ScreenPowerStatsCollector.ScreenUsageTimeRetriever getScreenUsageTimeRetriever() {
            return BatteryStatsImpl.m7727$$Nest$fgetmScreenUsageTimeRetriever(this.this$0);
        }

        @Override // com.android.server.power.stats.ScreenPowerStatsCollector.Injector
        public int getDisplayCount() {
            return this.this$0.getDisplayCount();
        }

        private /* synthetic */ NetworkStats lambda$getMobileNetworkStatsSupplier$1() {
            return this.this$0.readMobileNetworkStatsLocked(this.mNetworkStatsManager);
        }

        @Override // com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector
        public Supplier<NetworkStats> getMobileNetworkStatsSupplier() {
            return new BatteryStatsImpl$PowerStatsCollectorInjector$$ExternalSyntheticLambda0(this);
        }

        private /* synthetic */ NetworkStats lambda$getWifiNetworkStatsSupplier$2() {
            return this.this$0.readWifiNetworkStatsLocked(this.mNetworkStatsManager);
        }

        @Override // com.android.server.power.stats.WifiPowerStatsCollector.Injector
        public Supplier<NetworkStats> getWifiNetworkStatsSupplier() {
            return new BatteryStatsImpl$PowerStatsCollectorInjector$$ExternalSyntheticLambda1(this);
        }

        @Override // com.android.server.power.stats.WifiPowerStatsCollector.Injector
        public WifiPowerStatsCollector.WifiStatsRetriever getWifiStatsRetriever() {
            return BatteryStatsImpl.m7736$$Nest$fgetmWifiStatsRetriever(this.this$0);
        }

        @Override // com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector
        public TelephonyManager getTelephonyManager() {
            return this.mTelephonyManager;
        }

        @Override // com.android.server.power.stats.WifiPowerStatsCollector.Injector
        public WifiManager getWifiManager() {
            return this.mWifiManager;
        }

        @Override // com.android.server.power.stats.BluetoothPowerStatsCollector.Injector
        public BluetoothPowerStatsCollector.BluetoothStatsRetriever getBluetoothStatsRetriever() {
            return this.mBluetoothStatsRetriever;
        }

        private /* synthetic */ long lambda$getCallDurationSupplier$3() {
            return this.this$0.mPhoneOnTimer.getTotalTimeLocked(this.this$0.mClock.elapsedRealtime() * 1000, 0) / 1000;
        }

        @Override // com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector
        public LongSupplier getCallDurationSupplier() {
            return new BatteryStatsImpl$PowerStatsCollectorInjector$$ExternalSyntheticLambda4(this);
        }

        private /* synthetic */ long lambda$getPhoneSignalScanDurationSupplier$4() {
            return this.this$0.mPhoneSignalScanningTimer.getTotalTimeLocked(this.this$0.mClock.elapsedRealtime() * 1000, 0) / 1000;
        }

        @Override // com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector
        public LongSupplier getPhoneSignalScanDurationSupplier() {
            return new BatteryStatsImpl$PowerStatsCollectorInjector$$ExternalSyntheticLambda3(this);
        }

        @Override // com.android.server.power.stats.WakelockPowerStatsCollector.Injector
        public WakelockPowerStatsCollector.WakelockDurationRetriever getWakelockDurationRetriever() {
            return BatteryStatsImpl.m7731$$Nest$fgetmWakelockDurationRetriever(this.this$0);
        }

        @Override // com.android.server.power.stats.MobileRadioPowerStatsCollector.Injector, com.android.server.power.stats.WifiPowerStatsCollector.Injector
        public NetworkStats networkStatsDelta(NetworkStats stats, NetworkStats oldStats) {
            return this.this$0.networkStatsDelta(stats, oldStats);
        }
    }

    private static class RadioAccessTechnologyBatteryStats {
        private boolean mActive;
        private int mFrequencyRange;
        private LongSamplingCounter[] mPerFrequencyRxDurationMs;
        private LongSamplingCounter[][] mPerStateTxDurationMs;
        private int mSignalStrength;
        public final StopwatchTimer[][] perStateTimers;

        /* JADX INFO: renamed from: -$$Nest$mgetRxDurationCounter, reason: not valid java name */
        static /* bridge */ /* synthetic */ LongSamplingCounter m7786$$Nest$mgetRxDurationCounter(RadioAccessTechnologyBatteryStats r0, int r1, boolean r2) {
            return r0.getRxDurationCounter(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetTxDurationCounter, reason: not valid java name */
        static /* bridge */ /* synthetic */ LongSamplingCounter m7787$$Nest$mgetTxDurationCounter(RadioAccessTechnologyBatteryStats r0, int r1, int r2, boolean r3) {
            return r0.getTxDurationCounter(r1, r2, r3);
        }

        RadioAccessTechnologyBatteryStats(int freqCount, Clock clock, TimeBase timeBase) {
            this.mActive = false;
            this.mFrequencyRange = 0;
            this.mSignalStrength = 0;
            this.mPerStateTxDurationMs = null;
            this.mPerFrequencyRxDurationMs = null;
            this.perStateTimers = (StopwatchTimer[][]) Array.newInstance(StopwatchTimer.class, new int[]{freqCount, 5});
            int i = 0;
        L3:
            if (i >= freqCount) goto L9;
            int j = 0;
        L5:
            if (j >= 5) goto L7;
            this.perStateTimers[i][j] = new StopwatchTimer(clock, null, -1, null, timeBase);
            j = j + 1;
            goto L5
        L7:
            i = i + 1;
            goto L3
        }

        public void noteActive(boolean active, long elapsedRealtimeMs) {
            if (this.mActive != active) goto L5;
            return;
        L5:
            this.mActive = active;
            if (this.mActive == false) goto L8;
            this.perStateTimers[this.mFrequencyRange][this.mSignalStrength].startRunningLocked(elapsedRealtimeMs);
            return;
        L8:
            this.perStateTimers[this.mFrequencyRange][this.mSignalStrength].stopRunningLocked(elapsedRealtimeMs);
        }

        public void noteFrequencyRange(int frequencyRange, long elapsedRealtimeMs) {
            if (this.mFrequencyRange != frequencyRange) goto L6;
            return;
        L6:
            if (this.mActive == true) goto L9;
            this.mFrequencyRange = frequencyRange;
            return;
        L9:
            this.perStateTimers[this.mFrequencyRange][this.mSignalStrength].stopRunningLocked(elapsedRealtimeMs);
            this.perStateTimers[frequencyRange][this.mSignalStrength].startRunningLocked(elapsedRealtimeMs);
            this.mFrequencyRange = frequencyRange;
        }

        public void noteSignalStrength(int signalStrength, long elapsedRealtimeMs) {
            if (this.mSignalStrength != signalStrength) goto L6;
            return;
        L6:
            if (this.mActive == true) goto L9;
            this.mSignalStrength = signalStrength;
            return;
        L9:
            this.perStateTimers[this.mFrequencyRange][this.mSignalStrength].stopRunningLocked(elapsedRealtimeMs);
            this.perStateTimers[this.mFrequencyRange][signalStrength].startRunningLocked(elapsedRealtimeMs);
            this.mSignalStrength = signalStrength;
        }

        public long getTimeSinceMark(int frequencyRange, int signalStrength, long elapsedRealtimeMs) {
            return this.perStateTimers[frequencyRange][signalStrength].getTimeSinceMarkLocked(elapsedRealtimeMs * 1000) / 1000;
        }

        public void setMark(long elapsedRealtimeMs) {
            int size = this.perStateTimers.length;
            int i = 0;
        L3:
            if (i >= size) goto L10;
            int j = 0;
        L6:
            if (j >= 5) goto L8;
            this.perStateTimers[i][j].setMark(elapsedRealtimeMs);
            j = j + 1;
            goto L6
        L8:
            i = i + 1;
            goto L3
        }

        public int getFrequencyRangeCount() {
            return this.perStateTimers.length;
        }

        public void incrementTxDuration(int frequencyRange, int signalStrength, long durationMs) {
            getTxDurationCounter(frequencyRange, signalStrength, true).addCountLocked(durationMs);
        }

        public void incrementRxDuration(int frequencyRange, long durationMs) {
            getRxDurationCounter(frequencyRange, true).addCountLocked(durationMs);
        }

        public void reset(long elapsedRealtimeUs) {
            int size = this.perStateTimers.length;
            int i = 0;
        L3:
            if (i >= size) goto L18;
            int j = 0;
        L6:
            if (j >= 5) goto L13;
            this.perStateTimers[i][j].reset(false, elapsedRealtimeUs);
            if (this.mPerStateTxDurationMs == null) goto L11;
            this.mPerStateTxDurationMs[i][j].reset(false, elapsedRealtimeUs);
        L11:
            j = j + 1;
            goto L6
        L13:
            if (this.mPerFrequencyRxDurationMs == null) goto L16;
            this.mPerFrequencyRxDurationMs[i].reset(false, elapsedRealtimeUs);
        L16:
            i = i + 1;
            goto L3
        }

        public void writeSummaryToParcel(Parcel out, long elapsedRealtimeUs) {
            int freqCount = this.perStateTimers.length;
            out.writeInt(freqCount);
            out.writeInt(5);
            int i = 0;
        L3:
            if (i >= freqCount) goto L9;
            int j = 0;
        L5:
            if (j >= 5) goto L7;
            this.perStateTimers[i][j].writeSummaryFromParcelLocked(out, elapsedRealtimeUs);
            j = j + 1;
            goto L5
        L7:
            i = i + 1;
            goto L3
        L9:
            if (this.mPerStateTxDurationMs != null) goto L11;
            out.writeInt(0);
        L18:
            if (this.mPerFrequencyRxDurationMs != null) goto L20;
            out.writeInt(0);
            return;
        L20:
            out.writeInt(1);
            int i2 = 0;
        L21:
            if (i2 >= freqCount) goto L29;
            this.mPerFrequencyRxDurationMs[i2].writeSummaryFromParcelLocked(out);
            i2 = i2 + 1;
            goto L21
        L29:
            return;
        L11:
            out.writeInt(1);
            int i3 = 0;
        L12:
            if (i3 >= freqCount) goto L18;
            int j2 = 0;
        L14:
            if (j2 >= 5) goto L16;
            this.mPerStateTxDurationMs[i3][j2].writeSummaryFromParcelLocked(out);
            j2 = j2 + 1;
            goto L14
        L16:
            i3 = i3 + 1;
            goto L12
        }

        public void readSummaryFromParcel(Parcel in) {
            int oldFreqCount = in.readInt();
            int oldSignalStrengthCount = in.readInt();
            int currFreqCount = this.perStateTimers.length;
            int freq = 0;
        L4:
            if (freq >= oldFreqCount) goto L14;
            int strength = 0;
        L6:
            if (strength >= oldSignalStrengthCount) goto L13;
            if (freq >= currFreqCount) goto L11;
            if (strength >= 5) goto L11;
            this.perStateTimers[freq][strength].readSummaryFromParcelLocked(in);
        L12:
            strength = strength + 1;
        L11:
            StopwatchTimer temp = new StopwatchTimer(null, null, -1, null, new TimeBase());
            temp.readSummaryFromParcelLocked(in);
            goto L12
        L13:
            freq = freq + 1;
            goto L4
        L14:
            int freq2 = in.readInt();
            if (freq2 != 1) goto L25;
            int freq3 = 0;
        L17:
            if (freq3 >= oldFreqCount) goto L25;
            int strength2 = 0;
        L19:
            if (strength2 >= oldSignalStrengthCount) goto L24;
            if (freq3 >= currFreqCount) goto L22;
            if (strength2 >= 5) goto L22;
        L23:
            getTxDurationCounter(freq3, strength2, true).readSummaryFromParcelLocked(in);
            strength2 = strength2 + 1;
        L22:
            StopwatchTimer temp2 = new StopwatchTimer(null, null, -1, null, new TimeBase());
            temp2.readSummaryFromParcelLocked(in);
            goto L23
        L24:
            freq3 = freq3 + 1;
        L25:
            int freq4 = in.readInt();
            if (freq4 != 1) goto L33;
            int freq5 = 0;
        L28:
            if (freq5 >= oldFreqCount) goto L45;
            if (freq5 < currFreqCount) goto L31;
            StopwatchTimer temp3 = new StopwatchTimer(null, null, -1, null, new TimeBase());
            temp3.readSummaryFromParcelLocked(in);
        L32:
            freq5 = freq5 + 1;
            goto L28
        L31:
            getRxDurationCounter(freq5, true).readSummaryFromParcelLocked(in);
            goto L32
        L45:
            return;
        }

        private LongSamplingCounter getTxDurationCounter(int frequencyRange, int signalStrength, boolean make) {
            if (this.mPerStateTxDurationMs != null) goto L13;
            if (make == true) goto L6;
            return null;
        L6:
            int freqCount = getFrequencyRangeCount();
            int signalStrengthCount = this.perStateTimers[0].length;
            TimeBase timeBase = this.perStateTimers[0][0].mTimeBase;
            this.mPerStateTxDurationMs = (LongSamplingCounter[][]) Array.newInstance(LongSamplingCounter.class, new int[]{freqCount, signalStrengthCount});
            int freq = 0;
        L7:
            if (freq >= freqCount) goto L13;
            int strength = 0;
        L9:
            if (strength >= signalStrengthCount) goto L11;
            this.mPerStateTxDurationMs[freq][strength] = new LongSamplingCounter(timeBase);
            strength = strength + 1;
            goto L9
        L11:
            freq = freq + 1;
        L13:
            if (frequencyRange >= 0) goto L15;
        L25:
            Slog.w(BatteryStatsImpl.TAG, "Unexpected frequency range (" + frequencyRange + ") requested in getTxDurationCounter");
            return null;
        L15:
            if (frequencyRange >= getFrequencyRangeCount()) goto L25;
            if (signalStrength >= 0) goto L19;
        L23:
            Slog.w(BatteryStatsImpl.TAG, "Unexpected signal strength (" + signalStrength + ") requested in getTxDurationCounter");
            return null;
        L19:
            if (signalStrength >= this.perStateTimers[0].length) goto L23;
            return this.mPerStateTxDurationMs[frequencyRange][signalStrength];
        }

        private LongSamplingCounter getRxDurationCounter(int frequencyRange, boolean make) {
            if (this.mPerFrequencyRxDurationMs != null) goto L9;
            if (make == true) goto L6;
            return null;
        L6:
            int freqCount = getFrequencyRangeCount();
            TimeBase timeBase = this.perStateTimers[0][0].mTimeBase;
            this.mPerFrequencyRxDurationMs = new LongSamplingCounter[freqCount];
            int freq = 0;
        L7:
            if (freq >= freqCount) goto L9;
            this.mPerFrequencyRxDurationMs[freq] = new LongSamplingCounter(timeBase);
            freq = freq + 1;
        L9:
            if (frequencyRange >= 0) goto L11;
        L15:
            Slog.w(BatteryStatsImpl.TAG, "Unexpected frequency range (" + frequencyRange + ") requested in getRxDurationCounter");
            return null;
        L11:
            if (frequencyRange >= getFrequencyRangeCount()) goto L15;
            return this.mPerFrequencyRxDurationMs[frequencyRange];
        }
    }

    private static class RxTxConsumption {
        public final double rxConsumptionMah;
        public final long rxDurationMs;
        public final double txConsumptionMah;
        public final long txDurationMs;
        public final double txToTotalRatio;

        RxTxConsumption(double rxMah, long rxMs, double txMah, long txMs) {
            this.rxConsumptionMah = rxMah;
            this.rxDurationMs = rxMs;
            this.txConsumptionMah = txMah;
            this.txDurationMs = txMs;
            long activeDurationMs = this.txDurationMs + this.rxDurationMs;
            if (activeDurationMs != 0) goto L5;
            this.txToTotalRatio = 0.0d;
            return;
        L5:
            this.txToTotalRatio = this.txDurationMs / activeDurationMs;
        }
    }

    public static class SamplingTimer extends Timer {
        int mBaseReportedCount;
        long mBaseReportedTotalTimeUs;
        int mCurrentReportedCount;
        long mCurrentReportedTotalTimeUs;
        boolean mTimeBaseRunning;
        boolean mTrackingReportedValues;
        int mUpdateVersion;

        public SamplingTimer(Clock clock, TimeBase timeBase, Parcel in) {
            boolean r0 = false;
            super(clock, 0, timeBase, in);
            this.mCurrentReportedCount = in.readInt();
            this.mBaseReportedCount = in.readInt();
            this.mCurrentReportedTotalTimeUs = in.readLong();
            this.mBaseReportedTotalTimeUs = in.readLong();
            if (in.readInt() != 1) goto L5;
            r0 = true;
        L5:
            this.mTrackingReportedValues = r0;
            this.mTimeBaseRunning = timeBase.isRunning();
        }

        public SamplingTimer(Clock clock, TimeBase timeBase) {
            super(clock, 0, timeBase);
            this.mTrackingReportedValues = false;
            this.mTimeBaseRunning = timeBase.isRunning();
        }

        public void endSample() {
            endSample(this.mClock.elapsedRealtime() * 1000);
        }

        public void endSample(long elapsedRealtimeUs) {
            this.mTotalTimeUs = computeRunTimeLocked(0, elapsedRealtimeUs);
            this.mCount = computeCurrentCountLocked();
            this.mCurrentReportedTotalTimeUs = 0;
            this.mBaseReportedTotalTimeUs = 0;
            this.mCurrentReportedCount = 0;
            this.mBaseReportedCount = 0;
            this.mTrackingReportedValues = false;
        }

        public void setUpdateVersion(int version) {
            this.mUpdateVersion = version;
        }

        public int getUpdateVersion() {
            return this.mUpdateVersion;
        }

        public void update(long totalTimeUs, int count, long elapsedRealtimeUs) {
            update(totalTimeUs, 0, count, elapsedRealtimeUs);
        }

        public void update(long totalTimeUs, long activeTimeUs, int count, long elapsedRealtimeUs) {
            if (this.mTimeBaseRunning == true) goto L5;
        L11:
            this.mTrackingReportedValues = true;
            if (totalTimeUs >= this.mCurrentReportedTotalTimeUs) goto L14;
        L15:
            endSample(elapsedRealtimeUs);
        L16:
            this.mCurrentReportedTotalTimeUs = totalTimeUs;
            this.mCurrentReportedCount = count;
            return;
        L14:
            if (count >= this.mCurrentReportedCount) goto L16;
        L5:
            if (this.mTrackingReportedValues == true) goto L11;
            this.mBaseReportedTotalTimeUs = totalTimeUs - activeTimeUs;
            if (activeTimeUs != 0) goto L9;
            int r0 = count;
        L10:
            this.mBaseReportedCount = r0;
            goto L11
        L9:
            r0 = count - 1;
            goto L10
        }

        public void add(long deltaTimeUs, int deltaCount) {
            add(deltaTimeUs, deltaCount, this.mClock.elapsedRealtime() * 1000);
        }

        public void add(long deltaTimeUs, int deltaCount, long elapsedRealtimeUs) {
            update(this.mCurrentReportedTotalTimeUs + deltaTimeUs, this.mCurrentReportedCount + deltaCount, elapsedRealtimeUs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            super.onTimeStarted(elapsedRealtimeUs, baseUptimeUs, baseRealtimeUs);
            if (this.mTrackingReportedValues == false) goto L5;
            this.mBaseReportedTotalTimeUs = this.mCurrentReportedTotalTimeUs;
            this.mBaseReportedCount = this.mCurrentReportedCount;
        L5:
            this.mTimeBaseRunning = true;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            super.onTimeStopped(elapsedRealtimeUs, baseUptimeUs, baseRealtimeUs);
            this.mTimeBaseRunning = false;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        public void logState(Printer pw, String prefix) {
            super.logState(pw, prefix);
            pw.println(prefix + "mCurrentReportedCount=" + this.mCurrentReportedCount + " mBaseReportedCount=" + this.mBaseReportedCount + " mCurrentReportedTotalTime=" + this.mCurrentReportedTotalTimeUs + " mBaseReportedTotalTimeUs=" + this.mBaseReportedTotalTimeUs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        protected long computeRunTimeLocked(long curBatteryRealtime, long elapsedRealtimeUs) {
            long r0 = this.mTotalTimeUs;
            if (this.mTimeBaseRunning == true) goto L5;
        L7:
            long r2 = 0;
        L9:
            return r0 + r2;
        L5:
            if (this.mTrackingReportedValues == false) goto L7;
            r2 = this.mCurrentReportedTotalTimeUs - this.mBaseReportedTotalTimeUs;
            goto L9
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        protected int computeCurrentCountLocked() {
            int r0 = this.mCount;
            if (this.mTimeBaseRunning == true) goto L5;
        L7:
            int r1 = 0;
        L9:
            return r0 + r1;
        L5:
            if (this.mTrackingReportedValues == false) goto L7;
            r1 = this.mCurrentReportedCount - this.mBaseReportedCount;
            goto L9
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        public void writeToParcel(Parcel r3, long r4) {
            super.writeToParcel(r3, r4);
            r3.writeInt(this.mCurrentReportedCount);
            r3.writeInt(this.mBaseReportedCount);
            r3.writeLong(this.mCurrentReportedTotalTimeUs);
            r3.writeLong(this.mBaseReportedTotalTimeUs);
            r3.writeInt(this.mTrackingReportedValues ? 1 : 0);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            super.reset(detachIfReset, elapsedRealtimeUs);
            this.mTrackingReportedValues = false;
            this.mBaseReportedTotalTimeUs = 0;
            this.mBaseReportedCount = 0;
            return true;
        }
    }

    public static class StopwatchTimer extends Timer {
        long mAcquireTimeUs;
        public boolean mInList;
        int mNesting;
        long mTimeoutUs;
        final ArrayList<StopwatchTimer> mTimerPool;
        final Uid mUid;
        long mUpdateTimeUs;

        public StopwatchTimer(Clock clock, Uid uid, int type, ArrayList<StopwatchTimer> timerPool, TimeBase timeBase, Parcel in) {
            super(clock, type, timeBase, in);
            this.mAcquireTimeUs = -1;
            this.mUid = uid;
            this.mTimerPool = timerPool;
            this.mUpdateTimeUs = in.readLong();
        }

        public StopwatchTimer(Clock clock, Uid uid, int type, ArrayList<StopwatchTimer> timerPool, TimeBase timeBase) {
            super(clock, type, timeBase);
            this.mAcquireTimeUs = -1;
            this.mUid = uid;
            this.mTimerPool = timerPool;
        }

        public void setTimeout(long timeoutUs) {
            this.mTimeoutUs = timeoutUs;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        public void writeToParcel(Parcel out, long elapsedRealtimeUs) {
            super.writeToParcel(out, elapsedRealtimeUs);
            out.writeLong(this.mUpdateTimeUs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            if (this.mNesting <= 0) goto L6;
            super.onTimeStopped(elapsedRealtimeUs, baseUptimeUs, baseRealtimeUs);
            this.mUpdateTimeUs = baseRealtimeUs;
            return;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        public void logState(Printer pw, String prefix) {
            super.logState(pw, prefix);
            pw.println(prefix + "mNesting=" + this.mNesting + " mUpdateTime=" + this.mUpdateTimeUs + " mAcquireTime=" + this.mAcquireTimeUs);
        }

        public void startRunningLocked(long elapsedRealtimeMs) {
            int r0 = this.mNesting;
            this.mNesting = r0 + 1;
            if (r0 != 0) goto L12;
            long batteryRealtimeUs = this.mTimeBase.getRealtime(1000 * elapsedRealtimeMs);
            this.mUpdateTimeUs = batteryRealtimeUs;
            if (this.mTimerPool == null) goto L8;
            refreshTimersLocked(batteryRealtimeUs, this.mTimerPool, null);
            this.mTimerPool.add(this);
        L8:
            if (this.mTimeBase.isRunning() == false) goto L10;
            this.mCount++;
            this.mAcquireTimeUs = this.mTotalTimeUs;
            return;
        L10:
            this.mAcquireTimeUs = -1;
            return;
        }

        public boolean isRunningLocked() {
            if (this.mNesting <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void stopRunningLocked(long elapsedRealtimeMs) {
            if (this.mNesting != 0) goto L5;
            return;
        L5:
            int r0 = this.mNesting - 1;
            this.mNesting = r0;
            if (r0 != 0) goto L17;
            long batteryRealtimeUs = this.mTimeBase.getRealtime(elapsedRealtimeMs * 1000);
            if (this.mTimerPool == null) goto L10;
            refreshTimersLocked(batteryRealtimeUs, this.mTimerPool, null);
            this.mTimerPool.remove(this);
        L12:
            if (this.mAcquireTimeUs >= 0) goto L14;
            return;
        L14:
            if (this.mTotalTimeUs != this.mAcquireTimeUs) goto L19;
            this.mCount--;
            return;
        L19:
            return;
        L10:
            this.mNesting = 1;
            this.mTotalTimeUs = computeRunTimeLocked(batteryRealtimeUs, 1000 * elapsedRealtimeMs);
            this.mNesting = 0;
            goto L12
        }

        public void stopAllRunningLocked(long elapsedRealtimeMs) {
            if (this.mNesting <= 0) goto L6;
            this.mNesting = 1;
            stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        private static long refreshTimersLocked(long batteryRealtimeUs, ArrayList<StopwatchTimer> pool, StopwatchTimer self) {
            long selfTimeUs = 0;
            int N = pool.size();
            int i = N - 1;
        L3:
            if (i < 0) goto L12;
            StopwatchTimer t = pool.get(i);
            long heldTimeUs = batteryRealtimeUs - t.mUpdateTimeUs;
            if (heldTimeUs <= 0) goto L10;
            long myTimeUs = heldTimeUs / ((long) N);
            if (t != self) goto L9;
            selfTimeUs = myTimeUs;
        L9:
            t.mTotalTimeUs += myTimeUs;
        L10:
            t.mUpdateTimeUs = batteryRealtimeUs;
            i = i - 1;
            goto L3
        L12:
            return selfTimeUs;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        protected long computeRunTimeLocked(long curBatteryRealtimeUs, long elapsedRealtimeUs) {
            long r2 = 0;
            if (this.mTimeoutUs > 0) goto L5;
        L7:
            long r0 = this.mTotalTimeUs;
            if (this.mNesting <= 0) goto L18;
            long r3 = curBatteryRealtimeUs - this.mUpdateTimeUs;
            if (this.mTimerPool != null) goto L12;
        L14:
            int r4 = 1;
        L15:
            r2 = r3 / ((long) r4);
            goto L18
        L12:
            if (this.mTimerPool.size() <= 0) goto L14;
            r4 = this.mTimerPool.size();
        L18:
            return r0 + r2;
        L5:
            if (curBatteryRealtimeUs <= (this.mUpdateTimeUs + this.mTimeoutUs)) goto L7;
            curBatteryRealtimeUs = this.mUpdateTimeUs + this.mTimeoutUs;
            goto L7
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        protected int computeCurrentCountLocked() {
            return this.mCount;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            boolean r1 = false;
            if (this.mNesting > 0) goto L5;
            boolean canDetach = true;
        L6:
            if (canDetach == false) goto L9;
            if (detachIfReset == false) goto L9;
            r1 = true;
        L9:
            super.reset(r1, elapsedRealtimeUs);
            if (this.mNesting <= 0) goto L12;
            this.mUpdateTimeUs = this.mTimeBase.getRealtime(elapsedRealtimeUs);
        L12:
            this.mAcquireTimeUs = -1;
            return canDetach;
        L5:
            canDetach = false;
            goto L6
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer, com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void detach() {
            super.detach();
            if (this.mTimerPool == null) goto L6;
            this.mTimerPool.remove(this);
            return;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.Timer
        public void readSummaryFromParcelLocked(Parcel in) {
            super.readSummaryFromParcelLocked(in);
            this.mNesting = 0;
        }

        public void setMark(long elapsedRealtimeMs) {
            long batteryRealtimeUs = this.mTimeBase.getRealtime(1000 * elapsedRealtimeMs);
            if (this.mNesting > 0) goto L5;
        L8:
            this.mTimeBeforeMarkUs = this.mTotalTimeUs;
            return;
        L5:
            if (this.mTimerPool == null) goto L7;
            refreshTimersLocked(batteryRealtimeUs, this.mTimerPool, this);
            goto L8
        L7:
            this.mTotalTimeUs += batteryRealtimeUs - this.mUpdateTimeUs;
            this.mUpdateTimeUs = batteryRealtimeUs;
            goto L8
        }
    }

    public static class TimeBase {
        private Object mLock;
        protected final Collection<TimeBaseObs> mObservers;
        protected long mPastRealtimeUs;
        protected long mPastUptimeUs;
        protected long mRealtimeStartUs;
        protected long mRealtimeUs;
        protected boolean mRunning;
        protected long mUnpluggedRealtimeUs;
        protected long mUnpluggedUptimeUs;
        protected long mUptimeStartUs;
        protected long mUptimeUs;

        public void dump(PrintWriter pw, String prefix) {
            StringBuilder sb = new StringBuilder(128);
            pw.print(prefix);
            pw.print("mRunning=");
            pw.println(this.mRunning);
            sb.setLength(0);
            sb.append(prefix);
            sb.append("mUptime=");
            BatteryStats.formatTimeMs(sb, this.mUptimeUs / 1000);
            pw.println(sb.toString());
            sb.setLength(0);
            sb.append(prefix);
            sb.append("mRealtime=");
            BatteryStats.formatTimeMs(sb, this.mRealtimeUs / 1000);
            pw.println(sb.toString());
            sb.setLength(0);
            sb.append(prefix);
            sb.append("mPastUptime=");
            BatteryStats.formatTimeMs(sb, this.mPastUptimeUs / 1000);
            sb.append("mUptimeStart=");
            BatteryStats.formatTimeMs(sb, this.mUptimeStartUs / 1000);
            sb.append("mUnpluggedUptime=");
            BatteryStats.formatTimeMs(sb, this.mUnpluggedUptimeUs / 1000);
            pw.println(sb.toString());
            sb.setLength(0);
            sb.append(prefix);
            sb.append("mPastRealtime=");
            BatteryStats.formatTimeMs(sb, this.mPastRealtimeUs / 1000);
            sb.append("mRealtimeStart=");
            BatteryStats.formatTimeMs(sb, this.mRealtimeStartUs / 1000);
            sb.append("mUnpluggedRealtime=");
            BatteryStats.formatTimeMs(sb, this.mUnpluggedRealtimeUs / 1000);
            pw.println(sb.toString());
        }

        public TimeBase(boolean isLongList) {
            this.mLock = new Object();
            if (isLongList == false) goto L5;
            Collection<TimeBaseObs> r0 = new HashSet();
        L6:
            this.mObservers = r0;
            return;
        L5:
            r0 = new ArrayList();
            goto L6
        }

        public TimeBase() {
            this(false);
        }

        public void add(TimeBaseObs observer) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mObservers.add(observer);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void remove(TimeBaseObs observer) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mObservers.remove(observer);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean hasObserver(TimeBaseObs observer) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            boolean r1 = this.mObservers.contains(observer);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void init(long uptimeUs, long elapsedRealtimeUs) {
            this.mRealtimeUs = 0;
            this.mUptimeUs = 0;
            this.mPastUptimeUs = 0;
            this.mPastRealtimeUs = 0;
            this.mUptimeStartUs = uptimeUs;
            this.mRealtimeStartUs = elapsedRealtimeUs;
            this.mUnpluggedUptimeUs = getUptime(this.mUptimeStartUs);
            this.mUnpluggedRealtimeUs = getRealtime(this.mRealtimeStartUs);
        }

        public void reset(long uptimeUs, long elapsedRealtimeUs) {
            if (this.mRunning == true) goto L5;
            this.mPastUptimeUs = 0;
            this.mPastRealtimeUs = 0;
            return;
        L5:
            this.mUptimeStartUs = uptimeUs;
            this.mRealtimeStartUs = elapsedRealtimeUs;
            this.mUnpluggedUptimeUs = getUptime(uptimeUs);
            this.mUnpluggedRealtimeUs = getRealtime(elapsedRealtimeUs);
        }

        public long computeUptime(long curTimeUs, int which) {
            return this.mUptimeUs + getUptime(curTimeUs);
        }

        public long computeRealtime(long curTimeUs, int which) {
            return this.mRealtimeUs + getRealtime(curTimeUs);
        }

        public long getUptime(long curTimeUs) {
            long time = this.mPastUptimeUs;
            if (this.mRunning == true) goto L5;
            return time;
        L5:
            return time + (curTimeUs - this.mUptimeStartUs);
        }

        public long getRealtime(long curTimeUs) {
            long time = this.mPastRealtimeUs;
            if (this.mRunning == true) goto L5;
            return time;
        L5:
            return time + (curTimeUs - this.mRealtimeStartUs);
        }

        public long getUptimeStart() {
            return this.mUptimeStartUs;
        }

        public long getRealtimeStart() {
            return this.mRealtimeStartUs;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public boolean setRunning(boolean running, long uptimeUs, long elapsedRealtimeUs) {
            if (this.mRunning == running) goto L33;
            this.mRunning = running;
            if (running == false) goto L19;
            this.mUptimeStartUs = uptimeUs;
            this.mRealtimeStartUs = elapsedRealtimeUs;
            long batteryUptimeUs = getUptime(uptimeUs);
            this.mUnpluggedUptimeUs = batteryUptimeUs;
            long batteryRealtimeUs = getRealtime(elapsedRealtimeUs);
            this.mUnpluggedRealtimeUs = batteryRealtimeUs;
            Object r7 = this.mLock;
            monitor-enter(r7);
            Iterator<TimeBaseObs> iter = this.mObservers.iterator();     // Catch: Throwable -> L12
        L10:
            if (iter.hasNext() == false) goto L15;
            iter.next().onTimeStarted(elapsedRealtimeUs, batteryUptimeUs, batteryRealtimeUs);     // Catch: Throwable -> L12
            goto L10
        L15:
            monitor-exit(r7);     // Catch: Throwable -> L12
            return true;
        L12:
            th = move-exception;
            throw th;
        L19:
            long batteryUptimeUs2 = this.mPastUptimeUs;
            this.mPastUptimeUs = batteryUptimeUs2 + (uptimeUs - this.mUptimeStartUs);
            this.mPastRealtimeUs += elapsedRealtimeUs - this.mRealtimeStartUs;
            long batteryUptimeUs3 = getUptime(uptimeUs);
            long batteryRealtimeUs2 = getRealtime(elapsedRealtimeUs);
            Object r8 = this.mLock;
            monitor-enter(r8);
            Iterator<TimeBaseObs> iter2 = this.mObservers.iterator();     // Catch: Throwable -> L25
        L23:
            if (iter2.hasNext() == false) goto L28;
            iter2.next().onTimeStopped(elapsedRealtimeUs, batteryUptimeUs3, batteryRealtimeUs2);     // Catch: Throwable -> L25
            goto L23
        L28:
            monitor-exit(r8);     // Catch: Throwable -> L25
            return true;
        L25:
            th = move-exception;
            throw th;
        L33:
            return false;
        }

        public void readSummaryFromParcel(Parcel in) {
            this.mUptimeUs = in.readLong();
            this.mRealtimeUs = in.readLong();
        }

        public void writeSummaryToParcel(Parcel out, long uptimeUs, long elapsedRealtimeUs) {
            out.writeLong(computeUptime(uptimeUs, 0));
            out.writeLong(computeRealtime(elapsedRealtimeUs, 0));
        }

        public void readFromParcel(Parcel in) {
            this.mRunning = false;
            this.mUptimeUs = in.readLong();
            this.mPastUptimeUs = in.readLong();
            this.mUptimeStartUs = in.readLong();
            this.mRealtimeUs = in.readLong();
            this.mPastRealtimeUs = in.readLong();
            this.mRealtimeStartUs = in.readLong();
            this.mUnpluggedUptimeUs = in.readLong();
            this.mUnpluggedRealtimeUs = in.readLong();
        }

        public void writeToParcel(Parcel out, long uptimeUs, long elapsedRealtimeUs) {
            long runningUptime = getUptime(uptimeUs);
            long runningRealtime = getRealtime(elapsedRealtimeUs);
            out.writeLong(this.mUptimeUs);
            out.writeLong(runningUptime);
            out.writeLong(this.mUptimeStartUs);
            out.writeLong(this.mRealtimeUs);
            out.writeLong(runningRealtime);
            out.writeLong(this.mRealtimeStartUs);
            out.writeLong(this.mUnpluggedUptimeUs);
            out.writeLong(this.mUnpluggedRealtimeUs);
        }
    }

    public interface TimeBaseObs {
        void detach();

        void onTimeStarted(long r1, long r3, long r5);

        void onTimeStopped(long r1, long r3, long r5);

        boolean reset(boolean r1, long r2);

        default boolean reset(boolean detachIfReset) {
            return reset(detachIfReset, SystemClock.elapsedRealtime() * 1000);
        }
    }

    private static class TimeInFreqMultiStateCounter implements TimeBaseObs {
        private final LongArrayMultiStateCounter mCounter;
        private final TimeBase mTimeBase;

        /* JADX INFO: renamed from: -$$Nest$msetState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7788$$Nest$msetState(TimeInFreqMultiStateCounter r0, int r1, long r2) {
            r0.setState(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mwriteToParcel, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7789$$Nest$mwriteToParcel(TimeInFreqMultiStateCounter r0, Parcel r1) {
            r0.writeToParcel(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$smreadFromParcel, reason: not valid java name */
        static /* bridge */ /* synthetic */ TimeInFreqMultiStateCounter m7790$$Nest$smreadFromParcel(Parcel r0, TimeBase r1, int r2, int r3, long r4) {
            return readFromParcel(r0, r1, r2, r3, r4);
        }

        /* synthetic */ TimeInFreqMultiStateCounter(TimeBase r1, int r2, int r3, long r4, BatteryStatsImplIA r6) {
            this(r1, r2, r3, r4);
        }

        private TimeInFreqMultiStateCounter(TimeBase timeBase, int stateCount, int cpuFreqCount, long timestampMs) {
            this(timeBase, new LongArrayMultiStateCounter(stateCount, cpuFreqCount), timestampMs);
        }

        private TimeInFreqMultiStateCounter(TimeBase timeBase, LongArrayMultiStateCounter counter, long timestampMs) {
            this.mTimeBase = timeBase;
            this.mCounter = counter;
            this.mCounter.setEnabled(this.mTimeBase.isRunning(), timestampMs);
            timeBase.add(this);
        }

        private void writeToParcel(Parcel out) {
            this.mCounter.writeToParcel(out, 0);
        }

        private static TimeInFreqMultiStateCounter readFromParcel(Parcel in, TimeBase timeBase, int stateCount, int cpuFreqCount, long timestampMs) {
            LongArrayMultiStateCounter counter = (LongArrayMultiStateCounter) LongArrayMultiStateCounter.CREATOR.createFromParcel(in);
            if (counter.getStateCount() == stateCount) goto L5;
            return null;
        L5:
            if (counter.getArrayLength() == cpuFreqCount) goto L8;
            return null;
        L8:
            return new TimeInFreqMultiStateCounter(timeBase, counter, timestampMs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            this.mCounter.setEnabled(true, elapsedRealtimeUs / 1000);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            this.mCounter.setEnabled(false, elapsedRealtimeUs / 1000);
        }

        public LongArrayMultiStateCounter getCounter() {
            return this.mCounter;
        }

        public int getStateCount() {
            return this.mCounter.getStateCount();
        }

        public void setTrackingEnabled(boolean enabled, long timestampMs) {
            LongArrayMultiStateCounter r0 = this.mCounter;
            if (enabled == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.setEnabled(r1, timestampMs);
            return;
        L5:
            if (this.mTimeBase.isRunning() == false) goto L7;
            r1 = true;
            goto L8
        }

        private void setState(int uidRunningState, long elapsedRealtimeMs) {
            this.mCounter.setState(uidRunningState, elapsedRealtimeMs);
        }

        public boolean getCountsLocked(long[] counts, int procState) {
            if (counts.length == this.mCounter.getArrayLength()) goto L7;
            return false;
        L7:
            return this.mCounter.getCounts(counts, procState);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            this.mCounter.reset();
            if (detachIfReset == false) goto L7;
            detach();
            return true;
        L7:
            return true;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void detach() {
            this.mTimeBase.remove(this);
        }
    }

    private static class TimeMultiStateCounter extends BatteryStats.LongCounter implements TimeBaseObs {
        private final LongMultiStateCounter mCounter;
        private final TimeBase mTimeBase;

        /* JADX INFO: renamed from: -$$Nest$mincrement, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7791$$Nest$mincrement(TimeMultiStateCounter r0, long r1, long r3) {
            r0.increment(r1, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$msetState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7792$$Nest$msetState(TimeMultiStateCounter r0, int r1, long r2) {
            r0.setState(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdate, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7793$$Nest$mupdate(TimeMultiStateCounter r0, long r1, long r3) {
            return r0.update(r1, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mwriteToParcel, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7794$$Nest$mwriteToParcel(TimeMultiStateCounter r0, Parcel r1) {
            r0.writeToParcel(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$smreadFromParcel, reason: not valid java name */
        static /* bridge */ /* synthetic */ TimeMultiStateCounter m7795$$Nest$smreadFromParcel(Parcel r0, TimeBase r1, int r2, long r3) {
            return readFromParcel(r0, r1, r2, r3);
        }

        /* synthetic */ TimeMultiStateCounter(TimeBase r1, int r2, long r3, BatteryStatsImplIA r5) {
            this(r1, r2, r3);
        }

        private TimeMultiStateCounter(TimeBase timeBase, int stateCount, long timestampMs) {
            this(timeBase, new LongMultiStateCounter(stateCount), timestampMs);
        }

        private TimeMultiStateCounter(TimeBase timeBase, LongMultiStateCounter counter, long timestampMs) {
            this.mTimeBase = timeBase;
            this.mCounter = counter;
            this.mCounter.setEnabled(this.mTimeBase.isRunning(), timestampMs);
            timeBase.add(this);
        }

        private static TimeMultiStateCounter readFromParcel(Parcel in, TimeBase timeBase, int stateCount, long timestampMs) {
            LongMultiStateCounter counter = (LongMultiStateCounter) LongMultiStateCounter.CREATOR.createFromParcel(in);
            if (counter.getStateCount() == stateCount) goto L7;
            return null;
        L7:
            return new TimeMultiStateCounter(timeBase, counter, timestampMs);
        }

        private void writeToParcel(Parcel out) {
            this.mCounter.writeToParcel(out, 0);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            this.mCounter.setEnabled(true, elapsedRealtimeUs / 1000);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            this.mCounter.setEnabled(false, elapsedRealtimeUs / 1000);
        }

        public int getStateCount() {
            return this.mCounter.getStateCount();
        }

        private void setState(int processState, long elapsedRealtimeMs) {
            this.mCounter.setState(processState, elapsedRealtimeMs);
        }

        private long update(long value, long timestampMs) {
            return this.mCounter.updateValue(value, timestampMs);
        }

        private void increment(long increment, long timestampMs) {
            this.mCounter.incrementValue(increment, timestampMs);
        }

        public long getCountForProcessState(int procState) {
            return this.mCounter.getCount(procState);
        }

        public long getTotalCountLocked() {
            return this.mCounter.getTotalCount();
        }

        public long getCountLocked(int statsType) {
            return getTotalCountLocked();
        }

        public void logState(Printer pw, String prefix) {
            pw.println(prefix + "mCounter=" + this.mCounter);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            this.mCounter.reset();
            if (detachIfReset == false) goto L7;
            detach();
            return true;
        L7:
            return true;
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public void detach() {
            this.mTimeBase.remove(this);
        }
    }

    public static abstract class Timer extends BatteryStats.Timer implements TimeBaseObs {
        protected final Clock mClock;
        protected int mCount;
        protected final TimeBase mTimeBase;
        protected long mTimeBeforeMarkUs;
        protected long mTotalTimeUs;
        protected final int mType;

        protected abstract int computeCurrentCountLocked();

        protected abstract long computeRunTimeLocked(long r1, long r3);

        public Timer(Clock clock, int type, TimeBase timeBase, Parcel in) {
            this.mClock = clock;
            this.mType = type;
            this.mTimeBase = timeBase;
            this.mCount = in.readInt();
            this.mTotalTimeUs = in.readLong();
            this.mTimeBeforeMarkUs = in.readLong();
            timeBase.add(this);
        }

        public Timer(Clock clock, int type, TimeBase timeBase) {
            this.mClock = clock;
            this.mType = type;
            this.mTimeBase = timeBase;
            timeBase.add(this);
        }

        public void writeToParcel(Parcel out, long elapsedRealtimeUs) {
            out.writeInt(computeCurrentCountLocked());
            out.writeLong(computeRunTimeLocked(this.mTimeBase.getRealtime(elapsedRealtimeUs), elapsedRealtimeUs));
            out.writeLong(this.mTimeBeforeMarkUs);
        }

        @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
        public boolean reset(boolean detachIfReset) {
            return reset(detachIfReset, this.mClock.elapsedRealtime() * 1000);
        }

        public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
            this.mTimeBeforeMarkUs = 0;
            this.mTotalTimeUs = 0;
            this.mCount = 0;
            if (detachIfReset == false) goto L7;
            detach();
            return true;
        L7:
            return true;
        }

        public void detach() {
            this.mTimeBase.remove(this);
        }

        public void onTimeStarted(long elapsedRealtimeUs, long timeBaseUptimeUs, long baseRealtimeUs) {
        }

        public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            this.mTotalTimeUs = computeRunTimeLocked(baseRealtimeUs, elapsedRealtimeUs);
            this.mCount = computeCurrentCountLocked();
        }

        public static void writeTimerToParcel(Parcel out, Timer timer, long elapsedRealtimeUs) {
            if (timer != null) goto L5;
            out.writeInt(0);
            return;
        L5:
            out.writeInt(1);
            timer.writeToParcel(out, elapsedRealtimeUs);
        }

        public long getTotalTimeLocked(long elapsedRealtimeUs, int which) {
            return computeRunTimeLocked(this.mTimeBase.getRealtime(elapsedRealtimeUs), elapsedRealtimeUs);
        }

        public int getCountLocked(int which) {
            return computeCurrentCountLocked();
        }

        public long getTimeSinceMarkLocked(long elapsedRealtimeUs) {
            long val = computeRunTimeLocked(this.mTimeBase.getRealtime(elapsedRealtimeUs), elapsedRealtimeUs);
            return val - this.mTimeBeforeMarkUs;
        }

        public void logState(Printer pw, String prefix) {
            pw.println(prefix + "mCount=" + this.mCount);
            pw.println(prefix + "mTotalTime=" + this.mTotalTimeUs);
        }

        public void writeSummaryFromParcelLocked(Parcel out, long elapsedRealtimeUs) {
            long runTimeUs = computeRunTimeLocked(this.mTimeBase.getRealtime(elapsedRealtimeUs), elapsedRealtimeUs);
            out.writeLong(runTimeUs);
            out.writeInt(computeCurrentCountLocked());
        }

        public void readSummaryFromParcelLocked(Parcel in) {
            this.mTotalTimeUs = in.readLong();
            this.mCount = in.readInt();
            this.mTimeBeforeMarkUs = this.mTotalTimeUs;
        }
    }

    public static class Uid extends BatteryStats.Uid {
        static final int NO_BATCHED_SCAN_STARTED = -1;
        private static BinderCallStats sTempBinderCallStats;
        DualTimer mAggregatedPartialWakelockTimer;
        DualTimer mAudioTurnedOnTimer;
        private IBatteryStatsImplSmtEx.IUidSmtEx mBatteryStatsImplUidSmtEx;
        private long mBinderCallCount;
        private final ArraySet<BinderCallStats> mBinderCallStats;
        private ControllerActivityCounterImpl mBluetoothControllerActivity;
        Counter mBluetoothScanResultBgCounter;
        Counter mBluetoothScanResultCounter;
        DualTimer mBluetoothScanTimer;
        DualTimer mBluetoothUnoptimizedScanTimer;
        protected BatteryStatsImpl mBsi;
        DualTimer mCameraTurnedOnTimer;
        SparseArray<ChildUid> mChildUids;
        TimeMultiStateCounter mCpuActiveTimeMs;
        LongSamplingCounter[][] mCpuClusterSpeedTimesUs;
        LongSamplingCounterArray mCpuClusterTimesMs;
        LongSamplingCounterArray mCpuFreqTimeMs;
        long mCurStepSystemTimeMs;
        long mCurStepUserTimeMs;
        StopwatchTimer mFlashlightTurnedOnTimer;
        StopwatchTimer mForegroundActivityTimer;
        StopwatchTimer mForegroundServiceTimer;
        boolean mFullWifiLockOut;
        StopwatchTimer mFullWifiLockTimer;
        boolean mInForegroundService;
        final ArrayMap<String, SparseIntArray> mJobCompletions;
        final OverflowArrayMap<DualTimer> mJobStats;
        Counter mJobsDeferredCount;
        Counter mJobsDeferredEventCount;
        final Counter[] mJobsFreshnessBuckets;
        LongSamplingCounter mJobsFreshnessTimeMs;
        long mLastStepSystemTimeMs;
        long mLastStepUserTimeMs;
        LongSamplingCounter mMobileRadioActiveCount;
        TimeMultiStateCounter mMobileRadioActiveTime;
        private LongSamplingCounter mMobileRadioApWakeupCount;
        private ControllerActivityCounterImpl mModemControllerActivity;
        LongSamplingCounter[] mNetworkByteActivityCounters;
        LongSamplingCounter[] mNetworkPacketActivityCounters;
        public final TimeBase mOnBatteryBackgroundTimeBase;
        public final TimeBase mOnBatteryScreenOffBackgroundTimeBase;
        final ArrayMap<String, Pkg> mPackageStats;
        final SparseArray<BatteryStats.Uid.Pid> mPids;
        TimeInFreqMultiStateCounter mProcStateScreenOffTimeMs;
        TimeInFreqMultiStateCounter mProcStateTimeMs;
        int mProcessState;
        StopwatchTimer[] mProcessStateTimer;
        final ArrayMap<String, Proc> mProcessStats;
        private double mProportionalSystemServiceUsage;
        LongSamplingCounterArray mScreenOffCpuFreqTimeMs;
        final SparseArray<Sensor> mSensorStats;
        final OverflowArrayMap<DualTimer> mSyncStats;
        LongSamplingCounter mSystemCpuTime;
        private long mSystemServiceTimeUs;
        final int mUid;
        private EnergyConsumerStats mUidEnergyConsumerStats;
        Counter[] mUserActivityCounters;
        LongSamplingCounter mUserCpuTime;
        BatchTimer mVibratorOnTimer;
        DualTimer mVideoTurnedOnTimer;
        final OverflowArrayMap<Wakelock> mWakelockStats;
        int mWifiBatchedScanBinStarted;
        StopwatchTimer[] mWifiBatchedScanTimer;
        private ControllerActivityCounterImpl mWifiControllerActivity;
        StopwatchTimer mWifiMulticastTimer;
        int mWifiMulticastWakelockCount;
        private LongSamplingCounter mWifiRadioApWakeupCount;
        boolean mWifiRunning;
        StopwatchTimer mWifiRunningTimer;
        boolean mWifiScanStarted;
        DualTimer mWifiScanTimer;

        private class ChildUid {
            public final TimeMultiStateCounter cpuActiveCounter;
            public final LongArrayMultiStateCounter cpuTimeInFreqCounter;

            ChildUid(Uid r8) {
                long timestampMs = r8.mBsi.mClock.elapsedRealtime();
                this.cpuActiveCounter = new TimeMultiStateCounter(r8.mBsi.mOnBatteryTimeBase, 1, timestampMs, null);
                TimeMultiStateCounter.m7792$$Nest$msetState(this.cpuActiveCounter, 0, timestampMs);
                if (BatteryStatsImpl.m7745$$Nest$mtrackPerProcStateCpuTimes(r8.mBsi) == false) goto L5;
                int cpuFreqCount = r8.mBsi.mCpuScalingPolicies.getScalingStepCount();
                this.cpuTimeInFreqCounter = new LongArrayMultiStateCounter(1, cpuFreqCount);
                this.cpuTimeInFreqCounter.updateValues(new long[cpuFreqCount], timestampMs);
                return;
            L5:
                this.cpuTimeInFreqCounter = null;
            }
        }

        public static class Pkg extends BatteryStats.Uid.Pkg implements TimeBaseObs {
            protected BatteryStatsImpl mBsi;
            final ArrayMap<String, Serv> mServiceStats;
            ArrayMap<String, Counter> mWakeupAlarms;

            public static class Serv extends BatteryStats.Uid.Pkg.Serv implements TimeBaseObs {
                protected BatteryStatsImpl mBsi;
                protected boolean mLaunched;
                protected long mLaunchedSinceMs;
                protected long mLaunchedTimeMs;
                protected int mLaunches;
                protected Pkg mPkg;
                protected boolean mRunning;
                protected long mRunningSinceMs;
                protected long mStartTimeMs;
                protected int mStarts;

                public Serv(BatteryStatsImpl bsi) {
                    this.mBsi = bsi;
                    this.mBsi.mOnBatteryTimeBase.add(this);
                }

                @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
                public void onTimeStarted(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
                }

                @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
                public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
                }

                @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
                public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
                    if (detachIfReset == false) goto L6;
                    detach();
                    return true;
                L6:
                    return true;
                }

                @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
                public void detach() {
                    this.mBsi.mOnBatteryTimeBase.remove(this);
                }

                public void readFromParcelLocked(Parcel in) {
                    this.mStartTimeMs = in.readLong();
                    this.mRunningSinceMs = in.readLong();
                    boolean r1 = false;
                    if (in.readInt() == 0) goto L5;
                    boolean r0 = true;
                L6:
                    this.mRunning = r0;
                    this.mStarts = in.readInt();
                    this.mLaunchedTimeMs = in.readLong();
                    this.mLaunchedSinceMs = in.readLong();
                    if (in.readInt() == 0) goto L9;
                    r1 = true;
                L9:
                    this.mLaunched = r1;
                    this.mLaunches = in.readInt();
                    return;
                L5:
                    r0 = false;
                    goto L6
                }

                public void writeToParcelLocked(Parcel r3) {
                    r3.writeLong(this.mStartTimeMs);
                    r3.writeLong(this.mRunningSinceMs);
                    r3.writeInt(this.mRunning ? 1 : 0);
                    r3.writeInt(this.mStarts);
                    r3.writeLong(this.mLaunchedTimeMs);
                    r3.writeLong(this.mLaunchedSinceMs);
                    r3.writeInt(this.mLaunched ? 1 : 0);
                    r3.writeInt(this.mLaunches);
                }

                public long getLaunchTimeToNowLocked(long batteryUptimeMs) {
                    if (this.mLaunched == true) goto L7;
                    return this.mLaunchedTimeMs;
                L7:
                    return (this.mLaunchedTimeMs + batteryUptimeMs) - this.mLaunchedSinceMs;
                }

                public long getStartTimeToNowLocked(long batteryUptimeMs) {
                    if (this.mRunning == true) goto L7;
                    return this.mStartTimeMs;
                L7:
                    return (this.mStartTimeMs + batteryUptimeMs) - this.mRunningSinceMs;
                }

                public void startLaunchedLocked() {
                    startLaunchedLocked(this.mBsi.mClock.uptimeMillis());
                }

                public void startLaunchedLocked(long uptimeMs) {
                    if (this.mLaunched == true) goto L6;
                    this.mLaunches++;
                    this.mLaunchedSinceMs = this.mBsi.getBatteryUptimeLocked(uptimeMs) / 1000;
                    this.mLaunched = true;
                    return;
                }

                public void stopLaunchedLocked() {
                    stopLaunchedLocked(this.mBsi.mClock.uptimeMillis());
                }

                public void stopLaunchedLocked(long uptimeMs) {
                    if (this.mLaunched == false) goto L10;
                    long timeMs = (this.mBsi.getBatteryUptimeLocked(uptimeMs) / 1000) - this.mLaunchedSinceMs;
                    if (timeMs <= 0) goto L7;
                    this.mLaunchedTimeMs += timeMs;
                L8:
                    this.mLaunched = false;
                    return;
                L7:
                    this.mLaunches--;
                    goto L8
                }

                public void startRunningLocked() {
                    startRunningLocked(this.mBsi.mClock.uptimeMillis());
                }

                public void startRunningLocked(long uptimeMs) {
                    if (this.mRunning == true) goto L6;
                    this.mStarts++;
                    this.mRunningSinceMs = this.mBsi.getBatteryUptimeLocked(uptimeMs) / 1000;
                    this.mRunning = true;
                    return;
                }

                public void stopRunningLocked() {
                    stopRunningLocked(this.mBsi.mClock.uptimeMillis());
                }

                public void stopRunningLocked(long uptimeMs) {
                    if (this.mRunning == false) goto L10;
                    long timeMs = (this.mBsi.getBatteryUptimeLocked(uptimeMs) / 1000) - this.mRunningSinceMs;
                    if (timeMs <= 0) goto L7;
                    this.mStartTimeMs += timeMs;
                L8:
                    this.mRunning = false;
                    return;
                L7:
                    this.mStarts--;
                    goto L8
                }

                public BatteryStatsImpl getBatteryStats() {
                    return this.mBsi;
                }

                public int getLaunches(int which) {
                    return this.mLaunches;
                }

                public long getStartTime(long now, int which) {
                    return getStartTimeToNowLocked(now);
                }

                public int getStarts(int which) {
                    return this.mStarts;
                }
            }

            public Pkg(BatteryStatsImpl bsi) {
                this.mWakeupAlarms = new ArrayMap();
                this.mServiceStats = new ArrayMap();
                this.mBsi = bsi;
                this.mBsi.mOnBatteryScreenOffTimeBase.add(this);
            }

            @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
            public void onTimeStarted(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            }

            @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
            public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            }

            @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
            public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
                if (detachIfReset == false) goto L6;
                detach();
                return true;
            L6:
                return true;
            }

            @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
            public void detach() {
                this.mBsi.mOnBatteryScreenOffTimeBase.remove(this);
                int j = this.mWakeupAlarms.size() - 1;
            L3:
                if (j < 0) goto L5;
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mWakeupAlarms.valueAt(j));
                j = j - 1;
                goto L3
            L5:
                int j2 = this.mServiceStats.size() - 1;
            L6:
                if (j2 < 0) goto L9;
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mServiceStats.valueAt(j2));
                j2 = j2 - 1;
                goto L6
            }

            void readFromParcelLocked(Parcel in) {
                int numWA = in.readInt();
                this.mWakeupAlarms.clear();
                int i = 0;
            L3:
                if (i >= numWA) goto L5;
                String tag = in.readString();
                this.mWakeupAlarms.put(tag, new Counter(this.mBsi.mOnBatteryScreenOffTimeBase, in));
                i = i + 1;
                goto L3
            L5:
                int numServs = in.readInt();
                this.mServiceStats.clear();
                int m = 0;
            L6:
                if (m >= numServs) goto L9;
                String serviceName = in.readString();
                Serv serv = new Serv(this.mBsi);
                this.mServiceStats.put(serviceName, serv);
                serv.readFromParcelLocked(in);
                m = m + 1;
                goto L6
            }

            void writeToParcelLocked(Parcel out) {
                int numWA = this.mWakeupAlarms.size();
                out.writeInt(numWA);
                int i = 0;
            L3:
                if (i >= numWA) goto L5;
                out.writeString(this.mWakeupAlarms.keyAt(i));
                this.mWakeupAlarms.valueAt(i).writeToParcel(out);
                i = i + 1;
                goto L3
            L5:
                int NS = this.mServiceStats.size();
                out.writeInt(NS);
                int i2 = 0;
            L6:
                if (i2 >= NS) goto L9;
                out.writeString(this.mServiceStats.keyAt(i2));
                Serv serv = this.mServiceStats.valueAt(i2);
                serv.writeToParcelLocked(out);
                i2 = i2 + 1;
                goto L6
            }

            public ArrayMap<String, ? extends BatteryStats.Counter> getWakeupAlarmStats() {
                return this.mWakeupAlarms;
            }

            public void noteWakeupAlarmLocked(String tag) {
                Counter c = this.mWakeupAlarms.get(tag);
                if (c != null) goto L5;
                c = new Counter(this.mBsi.mOnBatteryScreenOffTimeBase);
                this.mWakeupAlarms.put(tag, c);
            L5:
                c.stepAtomic();
            }

            public ArrayMap<String, ? extends BatteryStats.Uid.Pkg.Serv> getServiceStats() {
                return this.mServiceStats;
            }

            final Serv newServiceStatsLocked() {
                return new Serv(this.mBsi);
            }
        }

        public static class Proc extends BatteryStats.Uid.Proc implements TimeBaseObs {
            boolean mActive;
            protected BatteryStatsImpl mBsi;
            ArrayList<BatteryStats.Uid.Proc.ExcessivePower> mExcessivePower;
            long mForegroundTimeMs;
            final String mName;
            int mNumAnrs;
            int mNumCrashes;
            int mStarts;
            long mSystemTimeMs;
            long mUserTimeMs;

            public Proc(BatteryStatsImpl bsi, String name) {
                this.mActive = true;
                this.mBsi = bsi;
                this.mName = name;
                this.mBsi.mOnBatteryTimeBase.add(this);
            }

            @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
            public void onTimeStarted(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            }

            @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
            public void onTimeStopped(long elapsedRealtimeUs, long baseUptimeUs, long baseRealtimeUs) {
            }

            @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
            public boolean reset(boolean detachIfReset, long elapsedRealtimeUs) {
                if (detachIfReset == false) goto L6;
                detach();
                return true;
            L6:
                return true;
            }

            @Override // com.android.server.power.stats.BatteryStatsImpl.TimeBaseObs
            public void detach() {
                this.mActive = false;
                this.mBsi.mOnBatteryTimeBase.remove(this);
            }

            public int countExcessivePowers() {
                if (this.mExcessivePower != null) goto L7;
                return 0;
            L7:
                return this.mExcessivePower.size();
            }

            public BatteryStats.Uid.Proc.ExcessivePower getExcessivePower(int i) {
                if (this.mExcessivePower != null) goto L5;
                return null;
            L5:
                return this.mExcessivePower.get(i);
            }

            public void addExcessiveCpu(long overTimeMs, long usedTimeMs) {
                if (this.mExcessivePower != null) goto L5;
                this.mExcessivePower = new ArrayList();
            L5:
                BatteryStats.Uid.Proc.ExcessivePower ew = new BatteryStats.Uid.Proc.ExcessivePower();
                ew.type = 2;
                ew.overTime = overTimeMs;
                ew.usedTime = usedTimeMs;
                this.mExcessivePower.add(ew);
            }

            void writeExcessivePowerToParcelLocked(Parcel out) {
                if (this.mExcessivePower != null) goto L6;
                out.writeInt(0);
                return;
            L6:
                int N = this.mExcessivePower.size();
                out.writeInt(N);
                int i = 0;
            L7:
                if (i >= N) goto L10;
                BatteryStats.Uid.Proc.ExcessivePower ew = this.mExcessivePower.get(i);
                out.writeInt(ew.type);
                out.writeLong(ew.overTime);
                out.writeLong(ew.usedTime);
                i = i + 1;
                goto L7
            }

            void readExcessivePowerFromParcelLocked(Parcel in) {
                int N = in.readInt();
                if (N != 0) goto L7;
                this.mExcessivePower = null;
                return;
            L7:
                if (N > 10000) goto L14;
                this.mExcessivePower = new ArrayList();
                int i = 0;
            L9:
                if (i >= N) goto L12;
                BatteryStats.Uid.Proc.ExcessivePower ew = new BatteryStats.Uid.Proc.ExcessivePower();
                ew.type = in.readInt();
                ew.overTime = in.readLong();
                ew.usedTime = in.readLong();
                this.mExcessivePower.add(ew);
                i = i + 1;
                goto L9
            L12:
                return;
            L14:
                throw new ParcelFormatException("File corrupt: too many excessive power entries " + N);
            }

            void writeToParcelLocked(Parcel out) {
                out.writeLong(this.mUserTimeMs);
                out.writeLong(this.mSystemTimeMs);
                out.writeLong(this.mForegroundTimeMs);
                out.writeInt(this.mStarts);
                out.writeInt(this.mNumCrashes);
                out.writeInt(this.mNumAnrs);
                writeExcessivePowerToParcelLocked(out);
            }

            void readFromParcelLocked(Parcel in) {
                this.mUserTimeMs = in.readLong();
                this.mSystemTimeMs = in.readLong();
                this.mForegroundTimeMs = in.readLong();
                this.mStarts = in.readInt();
                this.mNumCrashes = in.readInt();
                this.mNumAnrs = in.readInt();
                readExcessivePowerFromParcelLocked(in);
            }

            public void addCpuTimeLocked(int utimeMs, int stimeMs) {
                addCpuTimeLocked(utimeMs, stimeMs, this.mBsi.mOnBatteryTimeBase.isRunning());
            }

            public void addCpuTimeLocked(int utimeMs, int stimeMs, boolean isRunning) {
                if (isRunning == false) goto L5;
                this.mUserTimeMs += (long) utimeMs;
                this.mSystemTimeMs += (long) stimeMs;
                return;
            }

            public void addForegroundTimeLocked(long ttimeMs) {
                this.mForegroundTimeMs += ttimeMs;
            }

            public void incStartsLocked() {
                this.mStarts++;
            }

            public void incNumCrashesLocked() {
                this.mNumCrashes++;
            }

            public void incNumAnrsLocked() {
                this.mNumAnrs++;
            }

            public boolean isActive() {
                return this.mActive;
            }

            public long getUserTime(int which) {
                return this.mUserTimeMs;
            }

            public long getSystemTime(int which) {
                return this.mSystemTimeMs;
            }

            public long getForegroundTime(int which) {
                return this.mForegroundTimeMs;
            }

            public int getStarts(int which) {
                return this.mStarts;
            }

            public int getNumCrashes(int which) {
                return this.mNumCrashes;
            }

            public int getNumAnrs(int which) {
                return this.mNumAnrs;
            }
        }

        public static class Sensor extends BatteryStats.Uid.Sensor {
            protected BatteryStatsImpl mBsi;
            final int mHandle;
            DualTimer mTimer;
            protected Uid mUid;

            public /* bridge */ /* synthetic */ BatteryStats.Timer getSensorBackgroundTime() {
                return m7835getSensorBackgroundTime();
            }

            public /* bridge */ /* synthetic */ BatteryStats.Timer getSensorTime() {
                return m7836getSensorTime();
            }

            public Sensor(BatteryStatsImpl bsi, Uid uid, int handle) {
                this.mBsi = bsi;
                this.mUid = uid;
                this.mHandle = handle;
            }

            private DualTimer readTimersFromParcel(TimeBase timeBase, TimeBase bgTimeBase, Parcel in) {
                if (in.readInt() != 0) goto L6;
                return null;
            L6:
                ArrayList<StopwatchTimer> pool = (ArrayList) BatteryStatsImpl.m7728$$Nest$fgetmSensorTimers(this.mBsi).get(this.mHandle);
                if (pool != null) goto L9;
                ArrayList<StopwatchTimer> pool2 = new ArrayList();
                BatteryStatsImpl.m7728$$Nest$fgetmSensorTimers(this.mBsi).put(this.mHandle, pool2);
                ArrayList<StopwatchTimer> pool3 = pool2;
            L11:
                return new DualTimer(this.mBsi.mClock, this.mUid, 0, pool3, timeBase, bgTimeBase, in);
            L9:
                pool3 = pool;
                goto L11
            }

            boolean reset(long elapsedRealtimeUs) {
                if (this.mTimer.reset(true, elapsedRealtimeUs) == false) goto L6;
                this.mTimer = null;
                return true;
            L6:
                return false;
            }

            void readFromParcelLocked(TimeBase timeBase, TimeBase bgTimeBase, Parcel in) {
                this.mTimer = readTimersFromParcel(timeBase, bgTimeBase, in);
            }

            void writeToParcelLocked(Parcel out, long elapsedRealtimeUs) {
                Timer.writeTimerToParcel(out, this.mTimer, elapsedRealtimeUs);
            }

            /* JADX INFO: renamed from: getSensorTime, reason: collision with other method in class */
            public Timer m7836getSensorTime() {
                return this.mTimer;
            }

            /* JADX INFO: renamed from: getSensorBackgroundTime, reason: collision with other method in class */
            public Timer m7835getSensorBackgroundTime() {
                if (this.mTimer != null) goto L7;
                return null;
            L7:
                return this.mTimer.m7779getSubTimer();
            }

            public int getHandle() {
                return this.mHandle;
            }

            public void detachFromTimeBase() {
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mTimer);
            }
        }

        public static class Wakelock extends BatteryStats.Uid.Wakelock {
            protected BatteryStatsImpl mBsi;
            StopwatchTimer mTimerDraw;
            StopwatchTimer mTimerFull;
            DualTimer mTimerPartial;
            StopwatchTimer mTimerWindow;
            protected Uid mUid;

            public /* bridge */ /* synthetic */ BatteryStats.Timer getWakeTime(int r1) {
                return m7837getWakeTime(r1);
            }

            public Wakelock(BatteryStatsImpl bsi, Uid uid) {
                this.mBsi = bsi;
                this.mUid = uid;
            }

            private StopwatchTimer readStopwatchTimerFromParcel(int type, ArrayList<StopwatchTimer> pool, TimeBase timeBase, Parcel in) {
                if (in.readInt() != 0) goto L7;
                return null;
            L7:
                return new StopwatchTimer(this.mBsi.mClock, this.mUid, type, pool, timeBase, in);
            }

            private DualTimer readDualTimerFromParcel(int type, ArrayList<StopwatchTimer> pool, TimeBase timeBase, TimeBase bgTimeBase, Parcel in) {
                if (in.readInt() != 0) goto L7;
                return null;
            L7:
                return new DualTimer(this.mBsi.mClock, this.mUid, type, pool, timeBase, bgTimeBase, in);
            }

            boolean reset(long elapsedRealtimeUs) {
                boolean wlactive = (((false | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mTimerFull, false, elapsedRealtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mTimerPartial, false, elapsedRealtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mTimerWindow, false, elapsedRealtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mTimerDraw, false, elapsedRealtimeUs));
                if (wlactive == true) goto L6;
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mTimerFull);
                this.mTimerFull = null;
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mTimerPartial);
                this.mTimerPartial = null;
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mTimerWindow);
                this.mTimerWindow = null;
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mTimerDraw);
                this.mTimerDraw = null;
            L6:
                return !wlactive;
            }

            void readFromParcelLocked(TimeBase timeBase, TimeBase screenOffTimeBase, TimeBase screenOffBgTimeBase, Parcel in) {
                this.mTimerPartial = readDualTimerFromParcel(0, this.mBsi.mPartialTimers, screenOffTimeBase, screenOffBgTimeBase, in);
                this.mTimerFull = readStopwatchTimerFromParcel(1, BatteryStatsImpl.m7722$$Nest$fgetmFullTimers(this.mBsi), timeBase, in);
                this.mTimerWindow = readStopwatchTimerFromParcel(2, BatteryStatsImpl.m7737$$Nest$fgetmWindowTimers(this.mBsi), timeBase, in);
                this.mTimerDraw = readStopwatchTimerFromParcel(18, BatteryStatsImpl.m7718$$Nest$fgetmDrawTimers(this.mBsi), timeBase, in);
            }

            void writeToParcelLocked(Parcel out, long elapsedRealtimeUs) {
                Timer.writeTimerToParcel(out, this.mTimerPartial, elapsedRealtimeUs);
                Timer.writeTimerToParcel(out, this.mTimerFull, elapsedRealtimeUs);
                Timer.writeTimerToParcel(out, this.mTimerWindow, elapsedRealtimeUs);
                Timer.writeTimerToParcel(out, this.mTimerDraw, elapsedRealtimeUs);
            }

            /* JADX INFO: renamed from: getWakeTime, reason: collision with other method in class */
            public Timer m7837getWakeTime(int type) {
                switch(type) {
                    case 0: goto L12;
                    case 1: goto L10;
                    case 2: goto L8;
                    case 18: goto L6;
                    default: goto L4;
                };
            L4:
                throw new IllegalArgumentException("type = " + type);
            L6:
                return this.mTimerDraw;
            L8:
                return this.mTimerWindow;
            L10:
                return this.mTimerFull;
            L12:
                return this.mTimerPartial;
            }

            public void detachFromTimeBase() {
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mTimerPartial);
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mTimerFull);
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mTimerWindow);
                BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mTimerDraw);
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmBinderCallCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7796$$Nest$fgetmBinderCallCount(Uid r2) {
            return r2.mBinderCallCount;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmBinderCallStats, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArraySet m7797$$Nest$fgetmBinderCallStats(Uid r0) {
            return r0.mBinderCallStats;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmMobileRadioApWakeupCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ LongSamplingCounter m7798$$Nest$fgetmMobileRadioApWakeupCount(Uid r0) {
            return r0.mMobileRadioApWakeupCount;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSystemServiceTimeUs, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7799$$Nest$fgetmSystemServiceTimeUs(Uid r2) {
            return r2.mSystemServiceTimeUs;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUidEnergyConsumerStats, reason: not valid java name */
        static /* bridge */ /* synthetic */ EnergyConsumerStats m7800$$Nest$fgetmUidEnergyConsumerStats(Uid r0) {
            return r0.mUidEnergyConsumerStats;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWifiRadioApWakeupCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ LongSamplingCounter m7801$$Nest$fgetmWifiRadioApWakeupCount(Uid r0) {
            return r0.mWifiRadioApWakeupCount;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmMobileRadioApWakeupCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7802$$Nest$fputmMobileRadioApWakeupCount(Uid r0, LongSamplingCounter r1) {
            r0.mMobileRadioApWakeupCount = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmProportionalSystemServiceUsage, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7803$$Nest$fputmProportionalSystemServiceUsage(Uid r0, double r1) {
            r0.mProportionalSystemServiceUsage = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmSystemServiceTimeUs, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7804$$Nest$fputmSystemServiceTimeUs(Uid r0, long r1) {
            r0.mSystemServiceTimeUs = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmUidEnergyConsumerStats, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7805$$Nest$fputmUidEnergyConsumerStats(Uid r0, EnergyConsumerStats r1) {
            r0.mUidEnergyConsumerStats = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmWifiRadioApWakeupCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7806$$Nest$fputmWifiRadioApWakeupCount(Uid r0, LongSamplingCounter r1) {
            r0.mWifiRadioApWakeupCount = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$maddChargeToCustomBucketLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7807$$Nest$maddChargeToCustomBucketLocked(Uid r0, long r1, int r3) {
            r0.addChargeToCustomBucketLocked(r1, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$maddChargeToStandardBucketLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7808$$Nest$maddChargeToStandardBucketLocked(Uid r0, long r1, int r3, long r4) {
            r0.addChargeToStandardBucketLocked(r1, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetCpuActiveTimeCounter, reason: not valid java name */
        static /* bridge */ /* synthetic */ TimeMultiStateCounter m7809$$Nest$mgetCpuActiveTimeCounter(Uid r0) {
            return r0.getCpuActiveTimeCounter();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetProcStateScreenOffTimeCounter, reason: not valid java name */
        static /* bridge */ /* synthetic */ TimeInFreqMultiStateCounter m7810$$Nest$mgetProcStateScreenOffTimeCounter(Uid r0, long r1) {
            return r0.getProcStateScreenOffTimeCounter(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetProcStateTimeCounter, reason: not valid java name */
        static /* bridge */ /* synthetic */ TimeInFreqMultiStateCounter m7811$$Nest$mgetProcStateTimeCounter(Uid r0, long r1) {
            return r0.getProcStateTimeCounter(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mmarkCameraTimeUs, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7812$$Nest$mmarkCameraTimeUs(Uid r0, long r1) {
            return r0.markCameraTimeUs(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mmarkGnssTimeUs, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7813$$Nest$mmarkGnssTimeUs(Uid r0, long r1) {
            return r0.markGnssTimeUs(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mmarkProcessForegroundTimeUs, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7814$$Nest$mmarkProcessForegroundTimeUs(Uid r0, long r1, boolean r3) {
            return r0.markProcessForegroundTimeUs(r1, r3);
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getAggregatedPartialWakelockTimer() {
            return m7815getAggregatedPartialWakelockTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getAudioTurnedOnTimer() {
            return m7816getAudioTurnedOnTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.ControllerActivityCounter getBluetoothControllerActivity() {
            return m7817getBluetoothControllerActivity();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getBluetoothScanBackgroundTimer() {
            return m7818getBluetoothScanBackgroundTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Counter getBluetoothScanResultBgCounter() {
            return m7819getBluetoothScanResultBgCounter();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Counter getBluetoothScanResultCounter() {
            return m7820getBluetoothScanResultCounter();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getBluetoothScanTimer() {
            return m7821getBluetoothScanTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getBluetoothUnoptimizedScanBackgroundTimer() {
            return m7822getBluetoothUnoptimizedScanBackgroundTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getBluetoothUnoptimizedScanTimer() {
            return m7823getBluetoothUnoptimizedScanTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getCameraTurnedOnTimer() {
            return m7824getCameraTurnedOnTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getFlashlightTurnedOnTimer() {
            return m7825getFlashlightTurnedOnTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getForegroundActivityTimer() {
            return m7826getForegroundActivityTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getForegroundServiceTimer() {
            return m7827getForegroundServiceTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getMulticastWakelockStats() {
            return m7828getMulticastWakelockStats();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getProcessStateTimer(int r1) {
            return m7829getProcessStateTimer(r1);
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getVibratorOnTimer() {
            return m7830getVibratorOnTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getVideoTurnedOnTimer() {
            return m7831getVideoTurnedOnTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.ControllerActivityCounter getWifiControllerActivity() {
            return m7832getWifiControllerActivity();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getWifiScanBackgroundTimer() {
            return m7833getWifiScanBackgroundTimer();
        }

        public /* bridge */ /* synthetic */ BatteryStats.Timer getWifiScanTimer() {
            return m7834getWifiScanTimer();
        }

        public Uid(BatteryStatsImpl bsi, final int uid, long elapsedRealtimeMs, long uptimeMs) {
            this.mWifiBatchedScanBinStarted = -1;
            this.mProcessState = 7;
            this.mInForegroundService = false;
            this.mJobCompletions = new ArrayMap();
            this.mSensorStats = new SparseArray();
            this.mProcessStats = new ArrayMap();
            this.mPackageStats = new ArrayMap();
            this.mPids = new SparseArray();
            this.mBinderCallStats = new ArraySet();
            this.mBatteryStatsImplUidSmtEx = SysOptBridge.getFactory().getBatteryStatsUidSmtEx(this);
            this.mBsi = bsi;
            this.mUid = uid;
            this.mOnBatteryBackgroundTimeBase = new TimeBase(false);
            this.mOnBatteryBackgroundTimeBase.init(uptimeMs * 1000, elapsedRealtimeMs * 1000);
            this.mOnBatteryScreenOffBackgroundTimeBase = new TimeBase(false);
            this.mOnBatteryScreenOffBackgroundTimeBase.init(uptimeMs * 1000, 1000 * elapsedRealtimeMs);
            this.mUserCpuTime = new LongSamplingCounter(this.mBsi.mOnBatteryTimeBase);
            this.mSystemCpuTime = new LongSamplingCounter(this.mBsi.mOnBatteryTimeBase);
            this.mCpuClusterTimesMs = new LongSamplingCounterArray(this.mBsi.mOnBatteryTimeBase);
            final BatteryStatsImpl r1 = this.mBsi;
            r1.getClass();
            this.mWakelockStats = new AnonymousClass1(this, r1, uid);
            final BatteryStatsImpl r2 = this.mBsi;
            r2.getClass();
            this.mSyncStats = new AnonymousClass2(this, r2, uid);
            final BatteryStatsImpl r3 = this.mBsi;
            r3.getClass();
            this.mJobStats = new AnonymousClass3(this, r3, uid);
            this.mWifiRunningTimer = new StopwatchTimer(this.mBsi.mClock, this, 4, BatteryStatsImpl.m7734$$Nest$fgetmWifiRunningTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase);
            this.mFullWifiLockTimer = new StopwatchTimer(this.mBsi.mClock, this, 5, BatteryStatsImpl.m7723$$Nest$fgetmFullWifiLockTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase);
            this.mWifiScanTimer = new DualTimer(this.mBsi.mClock, this, 6, BatteryStatsImpl.m7735$$Nest$fgetmWifiScanTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase, this.mOnBatteryBackgroundTimeBase);
            this.mWifiBatchedScanTimer = new StopwatchTimer[5];
            this.mWifiMulticastTimer = new StopwatchTimer(this.mBsi.mClock, this, 7, BatteryStatsImpl.m7733$$Nest$fgetmWifiMulticastTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase);
            this.mProcessStateTimer = new StopwatchTimer[7];
            this.mJobsDeferredEventCount = new Counter(this.mBsi.mOnBatteryTimeBase);
            this.mJobsDeferredCount = new Counter(this.mBsi.mOnBatteryTimeBase);
            this.mJobsFreshnessTimeMs = new LongSamplingCounter(this.mBsi.mOnBatteryTimeBase);
            this.mJobsFreshnessBuckets = new Counter[BatteryStats.JOB_FRESHNESS_BUCKETS.length];
        }

        public void setProcessStateForTest(int procState, long elapsedTimeMs) {
            this.mProcessState = procState;
            TimeInFreqMultiStateCounter.m7788$$Nest$msetState(getProcStateTimeCounter(elapsedTimeMs), procState, elapsedTimeMs);
            TimeInFreqMultiStateCounter.m7788$$Nest$msetState(getProcStateScreenOffTimeCounter(elapsedTimeMs), procState, elapsedTimeMs);
            int batteryConsumerProcessState = BatteryStats.mapUidProcessStateToBatteryConsumerProcessState(procState);
            TimeMultiStateCounter.m7792$$Nest$msetState(getCpuActiveTimeCounter(), batteryConsumerProcessState, elapsedTimeMs);
            TimeMultiStateCounter.m7792$$Nest$msetState(getMobileRadioActiveTimeCounter(), batteryConsumerProcessState, elapsedTimeMs);
            ControllerActivityCounterImpl wifiControllerActivity = m7832getWifiControllerActivity();
            if (wifiControllerActivity == null) goto L5;
            ControllerActivityCounterImpl.m7774$$Nest$msetState(wifiControllerActivity, batteryConsumerProcessState, elapsedTimeMs);
        L5:
            ControllerActivityCounterImpl bluetoothControllerActivity = m7817getBluetoothControllerActivity();
            if (bluetoothControllerActivity == null) goto L8;
            ControllerActivityCounterImpl.m7774$$Nest$msetState(bluetoothControllerActivity, batteryConsumerProcessState, elapsedTimeMs);
        L8:
            EnergyConsumerStats energyStats = getOrCreateEnergyConsumerStatsIfSupportedLocked();
            if (energyStats == null) goto L12;
            energyStats.setState(batteryConsumerProcessState, elapsedTimeMs);
            return;
        }

        public long[] getCpuFreqTimes(int which) {
            return nullIfAllZeros(this.mCpuFreqTimeMs, which);
        }

        public long[] getScreenOffCpuFreqTimes(int which) {
            return nullIfAllZeros(this.mScreenOffCpuFreqTimeMs, which);
        }

        private TimeMultiStateCounter getCpuActiveTimeCounter() {
            if (this.mCpuActiveTimeMs != null) goto L6;
            long timestampMs = this.mBsi.mClock.elapsedRealtime();
            this.mCpuActiveTimeMs = new TimeMultiStateCounter(this.mBsi.mOnBatteryTimeBase, 5, timestampMs, null);
            TimeMultiStateCounter.m7792$$Nest$msetState(this.mCpuActiveTimeMs, BatteryStats.mapUidProcessStateToBatteryConsumerProcessState(this.mProcessState), timestampMs);
        L6:
            return this.mCpuActiveTimeMs;
        }

        public long getCpuActiveTime() {
            if (this.mCpuActiveTimeMs != null) goto L6;
            return 0;
        L6:
            long activeTime = 0;
            int procState = 0;
        L8:
            if (procState >= 5) goto L11;
            activeTime = activeTime + this.mCpuActiveTimeMs.getCountForProcessState(procState);
            procState = procState + 1;
            goto L8
        L11:
            return activeTime;
        }

        public long getCpuActiveTime(int procState) {
            if (this.mCpuActiveTimeMs == null) goto L10;
            if (procState >= 0) goto L6;
            return 0;
        L6:
            if (procState < 5) goto L9;
            return 0;
        L9:
            return this.mCpuActiveTimeMs.getCountForProcessState(procState);
        L10:
            return 0;
        }

        public long[] getCpuClusterTimes() {
            return nullIfAllZeros(this.mCpuClusterTimesMs, 0);
        }

        public boolean getCpuFreqTimes(long[] timesInFreqMs, int procState) {
            if (procState >= 0) goto L5;
        L16:
            return false;
        L5:
            if (procState >= 7) goto L16;
            if (this.mProcStateTimeMs != null) goto L11;
            return false;
        L11:
            if (this.mBsi.mPerProcStateCpuTimesAvailable == true) goto L15;
            this.mProcStateTimeMs = null;
            return false;
        L15:
            return this.mProcStateTimeMs.getCountsLocked(timesInFreqMs, procState);
        }

        public boolean getScreenOffCpuFreqTimes(long[] timesInFreqMs, int procState) {
            if (procState >= 0) goto L5;
        L16:
            return false;
        L5:
            if (procState >= 7) goto L16;
            if (this.mProcStateScreenOffTimeMs != null) goto L11;
            return false;
        L11:
            if (this.mBsi.mPerProcStateCpuTimesAvailable == true) goto L15;
            this.mProcStateScreenOffTimeMs = null;
            return false;
        L15:
            return this.mProcStateScreenOffTimeMs.getCountsLocked(timesInFreqMs, procState);
        }

        public long getBinderCallCount() {
            return this.mBinderCallCount;
        }

        public ArraySet<BinderCallStats> getBinderCallStats() {
            return this.mBinderCallStats;
        }

        public double getProportionalSystemServiceUsage() {
            return this.mProportionalSystemServiceUsage;
        }

        public void addIsolatedUid(int isolatedUid) {
            if (this.mChildUids != null) goto L6;
            this.mChildUids = new SparseArray();
        L8:
            this.mChildUids.put(isolatedUid, new ChildUid(this));
            return;
        L6:
            if (this.mChildUids.indexOfKey(isolatedUid) < 0) goto L8;
        }

        public void removeIsolatedUid(int isolatedUid) {
            if (this.mChildUids != null) goto L5;
            int idx = -1;
        L6:
            if (idx >= 0) goto L8;
            return;
        L8:
            this.mChildUids.remove(idx);
            return;
        L5:
            idx = this.mChildUids.indexOfKey(isolatedUid);
            goto L6
        }

        ChildUid getChildUid(int childUid) {
            if (this.mChildUids != null) goto L6;
            return null;
        L6:
            return this.mChildUids.get(childUid);
        }

        private long[] nullIfAllZeros(LongSamplingCounterArray cpuTimesMs, int which) {
            if (cpuTimesMs != null) goto L5;
            return null;
        L5:
            long[] counts = cpuTimesMs.getCountsLocked(which);
            if (counts != null) goto L8;
            return null;
        L8:
            int i = counts.length - 1;
        L9:
            if (i < 0) goto L15;
            if (counts[i] != 0) goto L12;
            i = i - 1;
            goto L9
        L12:
            return counts;
        L15:
            return null;
        }

        private void ensureMultiStateCounters(long timestampMs) {
            if (BatteryStatsImpl.m7726$$Nest$fgetmPowerStatsCollectorEnabled(this.mBsi).get(1) == true) goto L12;
            if (this.mProcStateTimeMs != null) goto L8;
            int r4 = 8;
            this.mProcStateTimeMs = new TimeInFreqMultiStateCounter(this.mBsi.mOnBatteryTimeBase, r4, this.mBsi.mCpuScalingPolicies.getScalingStepCount(), timestampMs, null);
        L8:
            if (this.mProcStateScreenOffTimeMs != null) goto L13;
            int r11 = 8;
            this.mProcStateScreenOffTimeMs = new TimeInFreqMultiStateCounter(this.mBsi.mOnBatteryScreenOffTimeBase, r11, this.mBsi.mCpuScalingPolicies.getScalingStepCount(), timestampMs, null);
            return;
        L13:
            return;
        L12:
            throw new IllegalStateException("Multi-state counters used in streamlined mode");
        }

        private TimeInFreqMultiStateCounter getProcStateTimeCounter(long timestampMs) {
            ensureMultiStateCounters(timestampMs);
            return this.mProcStateTimeMs;
        }

        private TimeInFreqMultiStateCounter getProcStateScreenOffTimeCounter(long timestampMs) {
            ensureMultiStateCounters(timestampMs);
            return this.mProcStateScreenOffTimeMs;
        }

        /* JADX INFO: renamed from: getAggregatedPartialWakelockTimer, reason: collision with other method in class */
        public Timer m7815getAggregatedPartialWakelockTimer() {
            return this.mAggregatedPartialWakelockTimer;
        }

        public ArrayMap<String, ? extends BatteryStats.Uid.Wakelock> getWakelockStats() {
            return this.mWakelockStats.getMap();
        }

        /* JADX INFO: renamed from: getMulticastWakelockStats, reason: collision with other method in class */
        public Timer m7828getMulticastWakelockStats() {
            return this.mWifiMulticastTimer;
        }

        public ArrayMap<String, ? extends BatteryStats.Timer> getSyncStats() {
            return this.mSyncStats.getMap();
        }

        public ArrayMap<String, ? extends BatteryStats.Timer> getJobStats() {
            return this.mJobStats.getMap();
        }

        public ArrayMap<String, SparseIntArray> getJobCompletionStats() {
            return this.mJobCompletions;
        }

        public SparseArray<? extends BatteryStats.Uid.Sensor> getSensorStats() {
            return this.mSensorStats;
        }

        public ArrayMap<String, ? extends BatteryStats.Uid.Proc> getProcessStats() {
            return this.mProcessStats;
        }

        public ArrayMap<String, ? extends BatteryStats.Uid.Pkg> getPackageStats() {
            return this.mPackageStats;
        }

        public int getUid() {
            return this.mUid;
        }

        public void noteWifiRunningLocked(long elapsedRealtimeMs) {
            if (this.mWifiRunning == true) goto L10;
            this.mWifiRunning = true;
            if (this.mWifiRunningTimer != null) goto L7;
            Uid r3 = this;
            r3.mWifiRunningTimer = new StopwatchTimer(this.mBsi.mClock, r3, 4, BatteryStatsImpl.m7734$$Nest$fgetmWifiRunningTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase);
        L8:
            r3.mWifiRunningTimer.startRunningLocked(elapsedRealtimeMs);
            return;
        L7:
            r3 = this;
            goto L8
        }

        public void noteWifiStoppedLocked(long elapsedRealtimeMs) {
            if (this.mWifiRunning == false) goto L6;
            this.mWifiRunning = false;
            this.mWifiRunningTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteFullWifiLockAcquiredLocked(long elapsedRealtimeMs) {
            if (this.mFullWifiLockOut == true) goto L10;
            this.mFullWifiLockOut = true;
            if (this.mFullWifiLockTimer != null) goto L7;
            Uid r3 = this;
            r3.mFullWifiLockTimer = new StopwatchTimer(this.mBsi.mClock, r3, 5, BatteryStatsImpl.m7723$$Nest$fgetmFullWifiLockTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase);
        L8:
            r3.mFullWifiLockTimer.startRunningLocked(elapsedRealtimeMs);
            return;
        L7:
            r3 = this;
            goto L8
        }

        public void noteFullWifiLockReleasedLocked(long elapsedRealtimeMs) {
            if (this.mFullWifiLockOut == false) goto L6;
            this.mFullWifiLockOut = false;
            this.mFullWifiLockTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteWifiScanStartedLocked(long elapsedRealtimeMs) {
            if (this.mWifiScanStarted == true) goto L10;
            this.mWifiScanStarted = true;
            if (this.mWifiScanTimer != null) goto L7;
            Uid r3 = this;
            r3.mWifiScanTimer = new DualTimer(this.mBsi.mClock, r3, 6, BatteryStatsImpl.m7735$$Nest$fgetmWifiScanTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase, this.mOnBatteryBackgroundTimeBase);
        L8:
            r3.mWifiScanTimer.startRunningLocked(elapsedRealtimeMs);
            return;
        L7:
            r3 = this;
            goto L8
        }

        public void noteWifiScanStoppedLocked(long elapsedRealtimeMs) {
            if (this.mWifiScanStarted == false) goto L6;
            this.mWifiScanStarted = false;
            this.mWifiScanTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteWifiBatchedScanStartedLocked(int csph, long elapsedRealtimeMs) {
            int bin = 0;
        L4:
            if (csph <= 8) goto L9;
            if (bin >= 4) goto L9;
            csph = csph >> 3;
            bin = bin + 1;
        L9:
            if (this.mWifiBatchedScanBinStarted != bin) goto L12;
            return;
        L12:
            if (this.mWifiBatchedScanBinStarted == (-1)) goto L14;
            this.mWifiBatchedScanTimer[this.mWifiBatchedScanBinStarted].stopRunningLocked(elapsedRealtimeMs);
        L14:
            this.mWifiBatchedScanBinStarted = bin;
            if (this.mWifiBatchedScanTimer[bin] != null) goto L17;
            makeWifiBatchedScanBin(bin, null);
        L17:
            this.mWifiBatchedScanTimer[bin].startRunningLocked(elapsedRealtimeMs);
        }

        public void noteWifiBatchedScanStoppedLocked(long elapsedRealtimeMs) {
            if (this.mWifiBatchedScanBinStarted == (-1)) goto L6;
            this.mWifiBatchedScanTimer[this.mWifiBatchedScanBinStarted].stopRunningLocked(elapsedRealtimeMs);
            this.mWifiBatchedScanBinStarted = -1;
            return;
        }

        public void noteWifiMulticastEnabledLocked(long elapsedRealtimeMs) {
            if (this.mWifiMulticastWakelockCount == 0) goto L5;
            Uid r3 = this;
        L10:
            r3.mWifiMulticastWakelockCount++;
            return;
        L5:
            if (this.mWifiMulticastTimer != null) goto L7;
            r3 = this;
            r3.mWifiMulticastTimer = new StopwatchTimer(this.mBsi.mClock, r3, 7, BatteryStatsImpl.m7733$$Nest$fgetmWifiMulticastTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase);
        L8:
            r3.mWifiMulticastTimer.startRunningLocked(elapsedRealtimeMs);
            goto L10
        L7:
            r3 = this;
            goto L8
        }

        public void noteWifiMulticastDisabledLocked(long elapsedRealtimeMs) {
            if (this.mWifiMulticastWakelockCount != 0) goto L5;
            return;
        L5:
            this.mWifiMulticastWakelockCount--;
            if (this.mWifiMulticastWakelockCount != 0) goto L9;
            this.mWifiMulticastTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        /* JADX INFO: renamed from: getWifiControllerActivity, reason: collision with other method in class */
        public ControllerActivityCounterImpl m7832getWifiControllerActivity() {
            return this.mWifiControllerActivity;
        }

        /* JADX INFO: renamed from: getBluetoothControllerActivity, reason: collision with other method in class */
        public ControllerActivityCounterImpl m7817getBluetoothControllerActivity() {
            return this.mBluetoothControllerActivity;
        }

        public BatteryStats.ControllerActivityCounter getModemControllerActivity() {
            return this.mModemControllerActivity;
        }

        public ControllerActivityCounterImpl getOrCreateWifiControllerActivityLocked() {
            if (this.mWifiControllerActivity != null) goto L6;
            this.mWifiControllerActivity = new ControllerActivityCounterImpl(this.mBsi.mClock, this.mBsi.mOnBatteryTimeBase, 1);
        L6:
            return this.mWifiControllerActivity;
        }

        public ControllerActivityCounterImpl getOrCreateBluetoothControllerActivityLocked() {
            if (this.mBluetoothControllerActivity != null) goto L6;
            this.mBluetoothControllerActivity = new ControllerActivityCounterImpl(this.mBsi.mClock, this.mBsi.mOnBatteryTimeBase, 1);
        L6:
            return this.mBluetoothControllerActivity;
        }

        public ControllerActivityCounterImpl getOrCreateModemControllerActivityLocked() {
            if (this.mModemControllerActivity != null) goto L6;
            this.mModemControllerActivity = new ControllerActivityCounterImpl(this.mBsi.mClock, this.mBsi.mOnBatteryTimeBase, BatteryStatsImpl.m7747$$Nest$sfgetMODEM_TX_POWER_LEVEL_COUNT());
        L6:
            return this.mModemControllerActivity;
        }

        private EnergyConsumerStats getOrCreateEnergyConsumerStatsLocked() {
            if (this.mUidEnergyConsumerStats != null) goto L6;
            this.mUidEnergyConsumerStats = new EnergyConsumerStats(this.mBsi.mEnergyConsumerStatsConfig);
        L6:
            return this.mUidEnergyConsumerStats;
        }

        private EnergyConsumerStats getOrCreateEnergyConsumerStatsIfSupportedLocked() {
            if (this.mUidEnergyConsumerStats != null) goto L8;
            if (this.mBsi.mEnergyConsumerStatsConfig == null) goto L8;
            this.mUidEnergyConsumerStats = new EnergyConsumerStats(this.mBsi.mEnergyConsumerStatsConfig);
        L8:
            return this.mUidEnergyConsumerStats;
        }

        private void addChargeToStandardBucketLocked(long chargeDeltaUC, int powerBucket, long timestampMs) {
            EnergyConsumerStats energyConsumerStats = getOrCreateEnergyConsumerStatsLocked();
            energyConsumerStats.updateStandardBucket(powerBucket, chargeDeltaUC, timestampMs);
        }

        private void addChargeToCustomBucketLocked(long chargeDeltaUC, int powerBucket) {
            getOrCreateEnergyConsumerStatsLocked().updateCustomBucket(powerBucket, chargeDeltaUC, this.mBsi.mClock.elapsedRealtime());
        }

        public long getEnergyConsumptionUC(int bucket) {
            if (this.mBsi.mGlobalEnergyConsumerStats != null) goto L5;
            return -1;
        L5:
            if (this.mBsi.mGlobalEnergyConsumerStats.isStandardBucketSupported(bucket) == true) goto L8;
            return -1;
        L8:
            if (this.mUidEnergyConsumerStats != null) goto L12;
            return 0;
        L12:
            return this.mUidEnergyConsumerStats.getAccumulatedStandardBucketCharge(bucket);
        }

        public long getEnergyConsumptionUC(int bucket, int processState) {
            if (this.mBsi.mGlobalEnergyConsumerStats != null) goto L5;
            return -1;
        L5:
            if (this.mBsi.mGlobalEnergyConsumerStats.isStandardBucketSupported(bucket) == true) goto L8;
            return -1;
        L8:
            if (this.mUidEnergyConsumerStats != null) goto L12;
            return 0;
        L12:
            return this.mUidEnergyConsumerStats.getAccumulatedStandardBucketCharge(bucket, processState);
        }

        public long[] getCustomEnergyConsumerBatteryConsumptionUC() {
            if (this.mBsi.mGlobalEnergyConsumerStats != null) goto L7;
            return null;
        L7:
            if (this.mUidEnergyConsumerStats != null) goto L11;
            return new long[this.mBsi.mGlobalEnergyConsumerStats.getNumberCustomPowerBuckets()];
        L11:
            return this.mUidEnergyConsumerStats.getAccumulatedCustomBucketCharges();
        }

        public long getBluetoothEnergyConsumptionUC() {
            return getEnergyConsumptionUC(5);
        }

        public long getBluetoothEnergyConsumptionUC(int processState) {
            return getEnergyConsumptionUC(5, processState);
        }

        public long getCpuEnergyConsumptionUC() {
            return getEnergyConsumptionUC(3);
        }

        public long getCpuEnergyConsumptionUC(int processState) {
            return getEnergyConsumptionUC(3, processState);
        }

        public long getGnssEnergyConsumptionUC() {
            return getEnergyConsumptionUC(6);
        }

        public long getMobileRadioEnergyConsumptionUC() {
            return getEnergyConsumptionUC(7);
        }

        public long getMobileRadioEnergyConsumptionUC(int processState) {
            return getEnergyConsumptionUC(7, processState);
        }

        public long getScreenOnEnergyConsumptionUC() {
            return getEnergyConsumptionUC(0);
        }

        public long getWifiEnergyConsumptionUC() {
            return getEnergyConsumptionUC(4);
        }

        public long getWifiEnergyConsumptionUC(int processState) {
            return getEnergyConsumptionUC(4, processState);
        }

        public long getCameraEnergyConsumptionUC() {
            return getEnergyConsumptionUC(8);
        }

        private long markProcessForegroundTimeUs(long elapsedRealtimeMs, boolean doCalc) {
            long fgTimeUs = 0;
            StopwatchTimer fgTimer = this.mForegroundActivityTimer;
            if (fgTimer == null) goto L7;
            if (doCalc == false) goto L6;
            fgTimeUs = fgTimer.getTimeSinceMarkLocked(elapsedRealtimeMs * 1000);
        L6:
            fgTimer.setMark(elapsedRealtimeMs);
        L7:
            long topTimeUs = 0;
            StopwatchTimer topTimer = this.mProcessStateTimer[0];
            if (topTimer == null) goto L13;
            if (doCalc == false) goto L11;
            topTimeUs = topTimer.getTimeSinceMarkLocked(1000 * elapsedRealtimeMs);
        L11:
            topTimer.setMark(elapsedRealtimeMs);
        L13:
            if (topTimeUs >= fgTimeUs) goto L16;
            return topTimeUs;
        L16:
            return fgTimeUs;
        }

        private long markGnssTimeUs(long elapsedRealtimeMs) {
            Sensor sensor = this.mSensorStats.get(ProcessList.INVALID_ADJ);
            if (sensor != null) goto L5;
            return 0;
        L5:
            StopwatchTimer timer = sensor.mTimer;
            if (timer != null) goto L8;
            return 0;
        L8:
            long gnssTimeUs = timer.getTimeSinceMarkLocked(1000 * elapsedRealtimeMs);
            timer.setMark(elapsedRealtimeMs);
            return gnssTimeUs;
        }

        private long markCameraTimeUs(long elapsedRealtimeMs) {
            StopwatchTimer timer = this.mCameraTurnedOnTimer;
            if (timer != null) goto L6;
            return 0;
        L6:
            long cameraTimeUs = timer.getTimeSinceMarkLocked(1000 * elapsedRealtimeMs);
            timer.setMark(elapsedRealtimeMs);
            return cameraTimeUs;
        }

        public StopwatchTimer createAudioTurnedOnTimerLocked() {
            if (this.mAudioTurnedOnTimer != null) goto L5;
            Uid r3 = this;
            r3.mAudioTurnedOnTimer = new DualTimer(this.mBsi.mClock, r3, 15, BatteryStatsImpl.m7711$$Nest$fgetmAudioTurnedOnTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase, this.mOnBatteryBackgroundTimeBase);
        L7:
            return r3.mAudioTurnedOnTimer;
        L5:
            r3 = this;
            goto L7
        }

        public void noteAudioTurnedOnLocked(long elapsedRealtimeMs) {
            createAudioTurnedOnTimerLocked().startRunningLocked(elapsedRealtimeMs);
        }

        public void noteAudioTurnedOffLocked(long elapsedRealtimeMs) {
            if (this.mAudioTurnedOnTimer == null) goto L6;
            this.mAudioTurnedOnTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteResetAudioLocked(long elapsedRealtimeMs) {
            if (this.mAudioTurnedOnTimer == null) goto L6;
            this.mAudioTurnedOnTimer.stopAllRunningLocked(elapsedRealtimeMs);
            return;
        }

        public StopwatchTimer createVideoTurnedOnTimerLocked() {
            if (this.mVideoTurnedOnTimer != null) goto L5;
            Uid r3 = this;
            r3.mVideoTurnedOnTimer = new DualTimer(this.mBsi.mClock, r3, 8, BatteryStatsImpl.m7730$$Nest$fgetmVideoTurnedOnTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase, this.mOnBatteryBackgroundTimeBase);
        L7:
            return r3.mVideoTurnedOnTimer;
        L5:
            r3 = this;
            goto L7
        }

        public void noteVideoTurnedOnLocked(long elapsedRealtimeMs) {
            createVideoTurnedOnTimerLocked().startRunningLocked(elapsedRealtimeMs);
        }

        public void noteVideoTurnedOffLocked(long elapsedRealtimeMs) {
            if (this.mVideoTurnedOnTimer == null) goto L6;
            this.mVideoTurnedOnTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteResetVideoLocked(long elapsedRealtimeMs) {
            if (this.mVideoTurnedOnTimer == null) goto L6;
            this.mVideoTurnedOnTimer.stopAllRunningLocked(elapsedRealtimeMs);
            return;
        }

        public StopwatchTimer createFlashlightTurnedOnTimerLocked() {
            if (this.mFlashlightTurnedOnTimer != null) goto L5;
            Uid r3 = this;
            r3.mFlashlightTurnedOnTimer = new StopwatchTimer(this.mBsi.mClock, r3, 16, BatteryStatsImpl.m7720$$Nest$fgetmFlashlightTurnedOnTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase);
        L7:
            return r3.mFlashlightTurnedOnTimer;
        L5:
            r3 = this;
            goto L7
        }

        public void noteFlashlightTurnedOnLocked(long elapsedRealtimeMs) {
            createFlashlightTurnedOnTimerLocked().startRunningLocked(elapsedRealtimeMs);
        }

        public void noteFlashlightTurnedOffLocked(long elapsedRealtimeMs) {
            if (this.mFlashlightTurnedOnTimer == null) goto L6;
            this.mFlashlightTurnedOnTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteResetFlashlightLocked(long elapsedRealtimeMs) {
            if (this.mFlashlightTurnedOnTimer == null) goto L6;
            this.mFlashlightTurnedOnTimer.stopAllRunningLocked(elapsedRealtimeMs);
            return;
        }

        public StopwatchTimer createCameraTurnedOnTimerLocked() {
            if (this.mCameraTurnedOnTimer != null) goto L5;
            Uid r3 = this;
            r3.mCameraTurnedOnTimer = new DualTimer(this.mBsi.mClock, r3, 17, BatteryStatsImpl.m7716$$Nest$fgetmCameraTurnedOnTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase, this.mOnBatteryBackgroundTimeBase);
        L7:
            return r3.mCameraTurnedOnTimer;
        L5:
            r3 = this;
            goto L7
        }

        public void noteCameraTurnedOnLocked(long elapsedRealtimeMs) {
            createCameraTurnedOnTimerLocked().startRunningLocked(elapsedRealtimeMs);
        }

        public void noteCameraTurnedOffLocked(long elapsedRealtimeMs) {
            if (this.mCameraTurnedOnTimer == null) goto L6;
            this.mCameraTurnedOnTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteResetCameraLocked(long elapsedRealtimeMs) {
            if (this.mCameraTurnedOnTimer == null) goto L6;
            this.mCameraTurnedOnTimer.stopAllRunningLocked(elapsedRealtimeMs);
            return;
        }

        public StopwatchTimer createForegroundActivityTimerLocked() {
            if (this.mForegroundActivityTimer != null) goto L5;
            Uid r3 = this;
            r3.mForegroundActivityTimer = new StopwatchTimer(this.mBsi.mClock, r3, 10, null, this.mBsi.mOnBatteryTimeBase);
        L7:
            return r3.mForegroundActivityTimer;
        L5:
            r3 = this;
            goto L7
        }

        public StopwatchTimer createForegroundServiceTimerLocked() {
            if (this.mForegroundServiceTimer != null) goto L5;
            Uid r3 = this;
            r3.mForegroundServiceTimer = new StopwatchTimer(this.mBsi.mClock, r3, 22, null, this.mBsi.mOnBatteryTimeBase);
        L7:
            return r3.mForegroundServiceTimer;
        L5:
            r3 = this;
            goto L7
        }

        public DualTimer createAggregatedPartialWakelockTimerLocked() {
            if (this.mAggregatedPartialWakelockTimer != null) goto L5;
            Uid r3 = this;
            r3.mAggregatedPartialWakelockTimer = new DualTimer(this.mBsi.mClock, r3, 20, null, this.mBsi.mOnBatteryScreenOffTimeBase, this.mOnBatteryScreenOffBackgroundTimeBase);
        L7:
            return r3.mAggregatedPartialWakelockTimer;
        L5:
            r3 = this;
            goto L7
        }

        public DualTimer createBluetoothScanTimerLocked() {
            if (this.mBluetoothScanTimer != null) goto L5;
            Uid r3 = this;
            r3.mBluetoothScanTimer = new DualTimer(this.mBsi.mClock, r3, 19, BatteryStatsImpl.m7714$$Nest$fgetmBluetoothScanOnTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase, this.mOnBatteryBackgroundTimeBase);
        L7:
            return r3.mBluetoothScanTimer;
        L5:
            r3 = this;
            goto L7
        }

        public DualTimer createBluetoothUnoptimizedScanTimerLocked() {
            if (this.mBluetoothUnoptimizedScanTimer != null) goto L5;
            Uid r3 = this;
            r3.mBluetoothUnoptimizedScanTimer = new DualTimer(this.mBsi.mClock, r3, 21, null, this.mBsi.mOnBatteryTimeBase, this.mOnBatteryBackgroundTimeBase);
        L7:
            return r3.mBluetoothUnoptimizedScanTimer;
        L5:
            r3 = this;
            goto L7
        }

        public void noteBluetoothScanStartedLocked(long elapsedRealtimeMs, boolean isUnoptimized) {
            createBluetoothScanTimerLocked().startRunningLocked(elapsedRealtimeMs);
            if (isUnoptimized == false) goto L6;
            createBluetoothUnoptimizedScanTimerLocked().startRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteBluetoothScanStoppedLocked(long elapsedRealtimeMs, boolean isUnoptimized) {
            if (this.mBluetoothScanTimer == null) goto L5;
            this.mBluetoothScanTimer.stopRunningLocked(elapsedRealtimeMs);
        L5:
            if (isUnoptimized == true) goto L7;
            return;
        L7:
            if (this.mBluetoothUnoptimizedScanTimer == null) goto L11;
            this.mBluetoothUnoptimizedScanTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteResetBluetoothScanLocked(long elapsedRealtimeMs) {
            if (this.mBluetoothScanTimer == null) goto L6;
            this.mBluetoothScanTimer.stopAllRunningLocked(elapsedRealtimeMs);
        L6:
            if (this.mBluetoothUnoptimizedScanTimer == null) goto L9;
            this.mBluetoothUnoptimizedScanTimer.stopAllRunningLocked(elapsedRealtimeMs);
            return;
        }

        public Counter createBluetoothScanResultCounterLocked() {
            if (this.mBluetoothScanResultCounter != null) goto L6;
            this.mBluetoothScanResultCounter = new Counter(this.mBsi.mOnBatteryTimeBase);
        L6:
            return this.mBluetoothScanResultCounter;
        }

        public Counter createBluetoothScanResultBgCounterLocked() {
            if (this.mBluetoothScanResultBgCounter != null) goto L6;
            this.mBluetoothScanResultBgCounter = new Counter(this.mOnBatteryBackgroundTimeBase);
        L6:
            return this.mBluetoothScanResultBgCounter;
        }

        public void noteBluetoothScanResultsLocked(int numNewResults) {
            createBluetoothScanResultCounterLocked().addAtomic(numNewResults);
            createBluetoothScanResultBgCounterLocked().addAtomic(numNewResults);
        }

        public void noteActivityResumedLocked(long elapsedRealtimeMs) {
            createForegroundActivityTimerLocked().startRunningLocked(elapsedRealtimeMs);
        }

        public void noteActivityPausedLocked(long elapsedRealtimeMs) {
            if (this.mForegroundActivityTimer == null) goto L6;
            this.mForegroundActivityTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteForegroundServiceResumedLocked(long elapsedRealtimeMs) {
            createForegroundServiceTimerLocked().startRunningLocked(elapsedRealtimeMs);
        }

        public void noteForegroundServicePausedLocked(long elapsedRealtimeMs) {
            if (this.mForegroundServiceTimer == null) goto L6;
            this.mForegroundServiceTimer.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public BatchTimer createVibratorOnTimerLocked() {
            if (this.mVibratorOnTimer != null) goto L6;
            this.mVibratorOnTimer = new BatchTimer(this.mBsi.mClock, this, 9, this.mBsi.mOnBatteryTimeBase);
        L6:
            return this.mVibratorOnTimer;
        }

        public void noteVibratorOnLocked(long durationMillis, long elapsedRealtimeMs) {
            createVibratorOnTimerLocked().addDuration(durationMillis, elapsedRealtimeMs);
        }

        public void noteVibratorOffLocked(long elapsedRealtimeMs) {
            if (this.mVibratorOnTimer == null) goto L6;
            this.mVibratorOnTimer.abortLastDuration(elapsedRealtimeMs);
            return;
        }

        public long getWifiRunningTime(long elapsedRealtimeUs, int which) {
            if (this.mWifiRunningTimer != null) goto L7;
            return 0;
        L7:
            return this.mWifiRunningTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
        }

        public long getFullWifiLockTime(long elapsedRealtimeUs, int which) {
            if (this.mFullWifiLockTimer != null) goto L7;
            return 0;
        L7:
            return this.mFullWifiLockTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
        }

        public long getWifiScanTime(long elapsedRealtimeUs, int which) {
            if (this.mWifiScanTimer != null) goto L7;
            return 0;
        L7:
            return this.mWifiScanTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
        }

        public int getWifiScanCount(int which) {
            if (this.mWifiScanTimer != null) goto L7;
            return 0;
        L7:
            return this.mWifiScanTimer.getCountLocked(which);
        }

        /* JADX INFO: renamed from: getWifiScanTimer, reason: collision with other method in class */
        public Timer m7834getWifiScanTimer() {
            return this.mWifiScanTimer;
        }

        public int getWifiScanBackgroundCount(int which) {
            if (this.mWifiScanTimer != null) goto L5;
            return 0;
        L5:
            if (this.mWifiScanTimer.m7779getSubTimer() != null) goto L8;
            return 0;
        L8:
            return this.mWifiScanTimer.m7779getSubTimer().getCountLocked(which);
        }

        public long getWifiScanActualTime(long elapsedRealtimeUs) {
            if (this.mWifiScanTimer != null) goto L6;
            return 0;
        L6:
            long elapsedRealtimeMs = (500 + elapsedRealtimeUs) / 1000;
            return this.mWifiScanTimer.getTotalDurationMsLocked(elapsedRealtimeMs) * 1000;
        }

        public long getWifiScanBackgroundTime(long elapsedRealtimeUs) {
            if (this.mWifiScanTimer != null) goto L5;
            return 0;
        L5:
            if (this.mWifiScanTimer.m7779getSubTimer() == null) goto L11;
            long elapsedRealtimeMs = (500 + elapsedRealtimeUs) / 1000;
            return this.mWifiScanTimer.m7779getSubTimer().getTotalDurationMsLocked(elapsedRealtimeMs) * 1000;
        L11:
            return 0;
        }

        /* JADX INFO: renamed from: getWifiScanBackgroundTimer, reason: collision with other method in class */
        public Timer m7833getWifiScanBackgroundTimer() {
            if (this.mWifiScanTimer != null) goto L7;
            return null;
        L7:
            return this.mWifiScanTimer.m7779getSubTimer();
        }

        public long getWifiBatchedScanTime(int csphBin, long elapsedRealtimeUs, int which) {
            if (csphBin >= 0) goto L5;
        L12:
            return 0;
        L5:
            if (csphBin >= 5) goto L12;
            if (this.mWifiBatchedScanTimer[csphBin] != null) goto L11;
            return 0;
        L11:
            return this.mWifiBatchedScanTimer[csphBin].getTotalTimeLocked(elapsedRealtimeUs, which);
        }

        public int getWifiBatchedScanCount(int csphBin, int which) {
            if (csphBin >= 0) goto L5;
        L12:
            return 0;
        L5:
            if (csphBin >= 5) goto L12;
            if (this.mWifiBatchedScanTimer[csphBin] != null) goto L11;
            return 0;
        L11:
            return this.mWifiBatchedScanTimer[csphBin].getCountLocked(which);
        }

        public long getWifiMulticastTime(long elapsedRealtimeUs, int which) {
            if (this.mWifiMulticastTimer != null) goto L7;
            return 0;
        L7:
            return this.mWifiMulticastTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
        }

        /* JADX INFO: renamed from: getAudioTurnedOnTimer, reason: collision with other method in class */
        public Timer m7816getAudioTurnedOnTimer() {
            return this.mAudioTurnedOnTimer;
        }

        /* JADX INFO: renamed from: getVideoTurnedOnTimer, reason: collision with other method in class */
        public Timer m7831getVideoTurnedOnTimer() {
            return this.mVideoTurnedOnTimer;
        }

        /* JADX INFO: renamed from: getFlashlightTurnedOnTimer, reason: collision with other method in class */
        public Timer m7825getFlashlightTurnedOnTimer() {
            return this.mFlashlightTurnedOnTimer;
        }

        /* JADX INFO: renamed from: getCameraTurnedOnTimer, reason: collision with other method in class */
        public Timer m7824getCameraTurnedOnTimer() {
            return this.mCameraTurnedOnTimer;
        }

        /* JADX INFO: renamed from: getForegroundActivityTimer, reason: collision with other method in class */
        public Timer m7826getForegroundActivityTimer() {
            return this.mForegroundActivityTimer;
        }

        /* JADX INFO: renamed from: getForegroundServiceTimer, reason: collision with other method in class */
        public Timer m7827getForegroundServiceTimer() {
            return this.mForegroundServiceTimer;
        }

        /* JADX INFO: renamed from: getBluetoothScanTimer, reason: collision with other method in class */
        public Timer m7821getBluetoothScanTimer() {
            return this.mBluetoothScanTimer;
        }

        /* JADX INFO: renamed from: getBluetoothScanBackgroundTimer, reason: collision with other method in class */
        public Timer m7818getBluetoothScanBackgroundTimer() {
            if (this.mBluetoothScanTimer != null) goto L7;
            return null;
        L7:
            return this.mBluetoothScanTimer.m7779getSubTimer();
        }

        /* JADX INFO: renamed from: getBluetoothUnoptimizedScanTimer, reason: collision with other method in class */
        public Timer m7823getBluetoothUnoptimizedScanTimer() {
            return this.mBluetoothUnoptimizedScanTimer;
        }

        /* JADX INFO: renamed from: getBluetoothUnoptimizedScanBackgroundTimer, reason: collision with other method in class */
        public Timer m7822getBluetoothUnoptimizedScanBackgroundTimer() {
            if (this.mBluetoothUnoptimizedScanTimer != null) goto L7;
            return null;
        L7:
            return this.mBluetoothUnoptimizedScanTimer.m7779getSubTimer();
        }

        /* JADX INFO: renamed from: getBluetoothScanResultCounter, reason: collision with other method in class */
        public Counter m7820getBluetoothScanResultCounter() {
            return this.mBluetoothScanResultCounter;
        }

        /* JADX INFO: renamed from: getBluetoothScanResultBgCounter, reason: collision with other method in class */
        public Counter m7819getBluetoothScanResultBgCounter() {
            return this.mBluetoothScanResultBgCounter;
        }

        void makeProcessState(int i, Parcel in) {
            if (i >= 0) goto L4;
            return;
        L4:
            if (i >= 7) goto L13;
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mProcessStateTimer[i]);
            if (in != null) goto L9;
            this.mProcessStateTimer[i] = new StopwatchTimer(this.mBsi.mClock, this, 12, null, this.mBsi.mOnBatteryTimeBase);
            return;
        L9:
            this.mProcessStateTimer[i] = new StopwatchTimer(this.mBsi.mClock, this, 12, null, this.mBsi.mOnBatteryTimeBase, in);
            return;
        }

        public long getProcessStateTime(int state, long elapsedRealtimeUs, int which) {
            if (state >= 0) goto L5;
        L12:
            return 0;
        L5:
            if (state >= 7) goto L12;
            if (this.mProcessStateTimer[state] != null) goto L11;
            return 0;
        L11:
            return this.mProcessStateTimer[state].getTotalTimeLocked(elapsedRealtimeUs, which);
        }

        /* JADX INFO: renamed from: getProcessStateTimer, reason: collision with other method in class */
        public Timer m7829getProcessStateTimer(int state) {
            if (state >= 0) goto L4;
            return null;
        L4:
            if (state < 7) goto L7;
            return null;
        L7:
            return this.mProcessStateTimer[state];
        }

        /* JADX INFO: renamed from: getVibratorOnTimer, reason: collision with other method in class */
        public Timer m7830getVibratorOnTimer() {
            return this.mVibratorOnTimer;
        }

        public void noteUserActivityLocked(int event) {
            if (this.mUserActivityCounters != null) goto L5;
            initUserActivityLocked();
        L5:
            if (event >= 0) goto L7;
        L9:
            Slog.w(BatteryStatsImpl.TAG, "Unknown user activity type " + event + " was specified.", new Throwable());
            return;
        L7:
            if (event >= BatteryStats.Uid.NUM_USER_ACTIVITY_TYPES) goto L9;
            this.mUserActivityCounters[event].stepAtomic();
        }

        public boolean hasUserActivity() {
            if (this.mUserActivityCounters == null) goto L5;
            return true;
        L5:
            return false;
        }

        public int getUserActivityCount(int type, int which) {
            if (this.mUserActivityCounters != null) goto L7;
            return 0;
        L7:
            return this.mUserActivityCounters[type].getCountLocked(which);
        }

        void makeWifiBatchedScanBin(int i, Parcel in) {
            if (i < 0) goto L16;
            if (i >= 5) goto L18;
            ArrayList<StopwatchTimer> collected = (ArrayList) BatteryStatsImpl.m7732$$Nest$fgetmWifiBatchedScanTimers(this.mBsi).get(i);
            if (collected != null) goto L9;
            ArrayList<StopwatchTimer> collected2 = new ArrayList();
            BatteryStatsImpl.m7732$$Nest$fgetmWifiBatchedScanTimers(this.mBsi).put(i, collected2);
            ArrayList<StopwatchTimer> collected3 = collected2;
        L10:
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mWifiBatchedScanTimer[i]);
            if (in != null) goto L13;
            this.mWifiBatchedScanTimer[i] = new StopwatchTimer(this.mBsi.mClock, this, 11, collected3, this.mBsi.mOnBatteryTimeBase);
            return;
        L13:
            this.mWifiBatchedScanTimer[i] = new StopwatchTimer(this.mBsi.mClock, this, 11, collected3, this.mBsi.mOnBatteryTimeBase, in);
            return;
        L9:
            collected3 = collected;
            goto L10
        L18:
            return;
        }

        void initUserActivityLocked() {
            BatteryStatsImpl.m7752$$Nest$smdetachIfNotNull(this.mUserActivityCounters);
            int r0 = BatteryStats.Uid.NUM_USER_ACTIVITY_TYPES;
            this.mUserActivityCounters = new Counter[r0];
            int i = 0;
        L3:
            if (i >= r0) goto L6;
            this.mUserActivityCounters[i] = new Counter(this.mBsi.mOnBatteryTimeBase);
            i = i + 1;
            goto L3
        }

        void noteNetworkActivityLocked(int type, long deltaBytes, long deltaPackets) {
            ensureNetworkActivityLocked();
            if (type >= 0) goto L5;
        L7:
            Slog.w(BatteryStatsImpl.TAG, "Unknown network activity type " + type + " was specified.", new Throwable());
            return;
        L5:
            if (type >= 10) goto L7;
            this.mNetworkByteActivityCounters[type].addCountLocked(deltaBytes);
            this.mNetworkPacketActivityCounters[type].addCountLocked(deltaPackets);
        }

        void noteMobileRadioActiveTimeLocked(long batteryUptimeDeltaUs, long elapsedTimeMs) {
            ensureNetworkActivityLocked();
            TimeMultiStateCounter.m7791$$Nest$mincrement(getMobileRadioActiveTimeCounter(), batteryUptimeDeltaUs, elapsedTimeMs);
            this.mMobileRadioActiveCount.addCountLocked(1);
        }

        private TimeMultiStateCounter getMobileRadioActiveTimeCounter() {
            if (this.mMobileRadioActiveTime != null) goto L6;
            long timestampMs = this.mBsi.mClock.elapsedRealtime();
            this.mMobileRadioActiveTime = new TimeMultiStateCounter(this.mBsi.mOnBatteryTimeBase, 5, timestampMs, null);
            TimeMultiStateCounter.m7792$$Nest$msetState(this.mMobileRadioActiveTime, BatteryStats.mapUidProcessStateToBatteryConsumerProcessState(this.mProcessState), timestampMs);
            TimeMultiStateCounter.m7793$$Nest$mupdate(this.mMobileRadioActiveTime, 0, timestampMs);
        L6:
            return this.mMobileRadioActiveTime;
        }

        public boolean hasNetworkActivity() {
            if (this.mNetworkByteActivityCounters == null) goto L5;
            return true;
        L5:
            return false;
        }

        public long getNetworkActivityBytes(int type, int which) {
            if (this.mNetworkByteActivityCounters == null) goto L9;
            if (type >= 0) goto L6;
            return 0;
        L6:
            if (type < this.mNetworkByteActivityCounters.length) goto L8;
            return 0;
        L8:
            return this.mNetworkByteActivityCounters[type].getCountLocked(which);
        L9:
            return 0;
        }

        public long getNetworkActivityPackets(int type, int which) {
            if (this.mNetworkPacketActivityCounters == null) goto L9;
            if (type >= 0) goto L6;
            return 0;
        L6:
            if (type < this.mNetworkPacketActivityCounters.length) goto L8;
            return 0;
        L8:
            return this.mNetworkPacketActivityCounters[type].getCountLocked(which);
        L9:
            return 0;
        }

        public long getMobileRadioActiveTime(int which) {
            return getMobileRadioActiveTimeInProcessState(-1);
        }

        public long getMobileRadioActiveTimeInProcessState(int processState) {
            if (this.mMobileRadioActiveTime != null) goto L7;
            return 0;
        L7:
            if (processState != (-1)) goto L11;
            return this.mMobileRadioActiveTime.getTotalCountLocked();
        L11:
            return this.mMobileRadioActiveTime.getCountForProcessState(processState);
        }

        public int getMobileRadioActiveCount(int which) {
            if (this.mMobileRadioActiveCount != null) goto L7;
            return 0;
        L7:
            return (int) this.mMobileRadioActiveCount.getCountLocked(which);
        }

        public long getUserCpuTimeUs(int which) {
            return this.mUserCpuTime.getCountLocked(which);
        }

        public long getSystemCpuTimeUs(int which) {
            return this.mSystemCpuTime.getCountLocked(which);
        }

        @Deprecated
        public long getTimeAtCpuSpeed(int cluster, int step, int which) {
            if (this.mCpuClusterSpeedTimesUs == null) goto L16;
            if (cluster >= 0) goto L6;
            return 0;
        L6:
            if (cluster >= this.mCpuClusterSpeedTimesUs.length) goto L19;
            LongSamplingCounter[] cpuSpeedTimesUs = this.mCpuClusterSpeedTimesUs[cluster];
            if (cpuSpeedTimesUs == null) goto L20;
            if (step >= 0) goto L11;
            return 0;
        L11:
            if (step >= cpuSpeedTimesUs.length) goto L22;
            LongSamplingCounter c = cpuSpeedTimesUs[step];
            if (c != null) goto L15;
            return 0;
        L15:
            return c.getCountLocked(which);
        L22:
            return 0;
        L20:
            return 0;
        L19:
            return 0;
        L16:
            return 0;
        }

        public void noteMobileRadioApWakeupLocked() {
            if (this.mMobileRadioApWakeupCount != null) goto L5;
            this.mMobileRadioApWakeupCount = new LongSamplingCounter(this.mBsi.mOnBatteryTimeBase);
        L5:
            this.mMobileRadioApWakeupCount.addCountLocked(1);
        }

        public long getMobileRadioApWakeupCount(int which) {
            if (this.mMobileRadioApWakeupCount != null) goto L5;
            return 0;
        L5:
            return this.mMobileRadioApWakeupCount.getCountLocked(which);
        }

        public void noteWifiRadioApWakeupLocked() {
            if (this.mWifiRadioApWakeupCount != null) goto L5;
            this.mWifiRadioApWakeupCount = new LongSamplingCounter(this.mBsi.mOnBatteryTimeBase);
        L5:
            this.mWifiRadioApWakeupCount.addCountLocked(1);
        }

        public long getWifiRadioApWakeupCount(int which) {
            if (this.mWifiRadioApWakeupCount != null) goto L5;
            return 0;
        L5:
            return this.mWifiRadioApWakeupCount.getCountLocked(which);
        }

        public void getDeferredJobsCheckinLineLocked(StringBuilder sb, int which) {
            sb.setLength(0);
            int deferredEventCount = this.mJobsDeferredEventCount.getCountLocked(which);
            if (deferredEventCount != 0) goto L5;
            return;
        L5:
            int deferredCount = this.mJobsDeferredCount.getCountLocked(which);
            long totalLatency = this.mJobsFreshnessTimeMs.getCountLocked(which);
            sb.append(deferredEventCount);
            sb.append(',');
            sb.append(deferredCount);
            sb.append(',');
            sb.append(totalLatency);
            int i = 0;
        L7:
            if (i >= BatteryStats.JOB_FRESHNESS_BUCKETS.length) goto L14;
            if (this.mJobsFreshnessBuckets[i] != null) goto L11;
            sb.append(",0");
        L12:
            i = i + 1;
            goto L7
        L11:
            sb.append(",");
            sb.append(this.mJobsFreshnessBuckets[i].getCountLocked(which));
            goto L12
        }

        public void getDeferredJobsLineLocked(StringBuilder sb, int which) {
            sb.setLength(0);
            int deferredEventCount = this.mJobsDeferredEventCount.getCountLocked(which);
            if (deferredEventCount != 0) goto L5;
            return;
        L5:
            int deferredCount = this.mJobsDeferredCount.getCountLocked(which);
            long totalLatency = this.mJobsFreshnessTimeMs.getCountLocked(which);
            sb.append("times=");
            sb.append(deferredEventCount);
            sb.append(", ");
            sb.append("count=");
            sb.append(deferredCount);
            sb.append(", ");
            sb.append("totalLatencyMs=");
            sb.append(totalLatency);
            sb.append(", ");
            int i = 0;
        L7:
            if (i >= BatteryStats.JOB_FRESHNESS_BUCKETS.length) goto L14;
            sb.append("<");
            sb.append(BatteryStats.JOB_FRESHNESS_BUCKETS[i]);
            sb.append("ms=");
            if (this.mJobsFreshnessBuckets[i] != null) goto L11;
            sb.append("0");
        L12:
            sb.append(" ");
            i = i + 1;
            goto L7
        L11:
            sb.append(this.mJobsFreshnessBuckets[i].getCountLocked(which));
            goto L12
        }

        void ensureNetworkActivityLocked() {
            if (this.mNetworkByteActivityCounters == null) goto L5;
            return;
        L5:
            this.mNetworkByteActivityCounters = new LongSamplingCounter[10];
            this.mNetworkPacketActivityCounters = new LongSamplingCounter[10];
            int i = 0;
        L6:
            if (i >= 10) goto L8;
            this.mNetworkByteActivityCounters[i] = new LongSamplingCounter(this.mBsi.mOnBatteryTimeBase);
            this.mNetworkPacketActivityCounters[i] = new LongSamplingCounter(this.mBsi.mOnBatteryTimeBase);
            i = i + 1;
            goto L6
        L8:
            this.mMobileRadioActiveCount = new LongSamplingCounter(this.mBsi.mOnBatteryTimeBase);
        }

        public boolean reset(long uptimeUs, long realtimeUs, int resetReason) {
            boolean active = false;
            this.mOnBatteryBackgroundTimeBase.init(uptimeUs, realtimeUs);
            this.mOnBatteryScreenOffBackgroundTimeBase.init(uptimeUs, realtimeUs);
            if (this.mWifiRunningTimer == null) goto L6;
            boolean active2 = false | (!this.mWifiRunningTimer.reset(false, realtimeUs));
            active = active2 | this.mWifiRunning;
        L6:
            if (this.mFullWifiLockTimer == null) goto L9;
            active = (active | (!this.mFullWifiLockTimer.reset(false, realtimeUs))) | this.mFullWifiLockOut;
        L9:
            if (this.mWifiScanTimer == null) goto L12;
            active = (active | (!this.mWifiScanTimer.reset(false, realtimeUs))) | this.mWifiScanStarted;
        L12:
            if (this.mWifiBatchedScanTimer == null) goto L26;
            int i = 0;
        L15:
            if (i >= 5) goto L20;
            if (this.mWifiBatchedScanTimer[i] == null) goto L19;
            active = active | (!this.mWifiBatchedScanTimer[i].reset(false, realtimeUs));
        L19:
            i = i + 1;
            goto L15
        L20:
            int i2 = this.mWifiBatchedScanBinStarted;
            if (i2 == (-1)) goto L23;
            boolean r6 = true;
        L24:
            active = active | r6;
            goto L26
        L23:
            r6 = false;
        L26:
            if (this.mWifiMulticastTimer == null) goto L32;
            boolean active3 = active | (!this.mWifiMulticastTimer.reset(false, realtimeUs));
            if (this.mWifiMulticastWakelockCount <= 0) goto L30;
            boolean r7 = true;
        L31:
            active = active3 | r7;
            goto L32
        L30:
            r7 = false;
        L32:
            boolean active4 = ((((((((active | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mAudioTurnedOnTimer, false, realtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mVideoTurnedOnTimer, false, realtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mFlashlightTurnedOnTimer, false, realtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mCameraTurnedOnTimer, false, realtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mForegroundActivityTimer, false, realtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mForegroundServiceTimer, false, realtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mAggregatedPartialWakelockTimer, false, realtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mBluetoothScanTimer, false, realtimeUs))) | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mBluetoothUnoptimizedScanTimer, false, realtimeUs));
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mBluetoothScanResultCounter, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mBluetoothScanResultBgCounter, false, realtimeUs);
            if (this.mProcessStateTimer == null) goto L44;
            int i3 = 0;
        L36:
            if (i3 >= 7) goto L38;
            active4 = active4 | (!BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mProcessStateTimer[i3], false, realtimeUs));
            i3 = i3 + 1;
            goto L36
        L38:
            int i4 = this.mProcessState;
            if (i4 == 7) goto L41;
            boolean r8 = true;
        L42:
            active4 = active4 | r8;
            goto L44
        L41:
            r8 = false;
        L44:
            if (this.mVibratorOnTimer != null) goto L46;
        L49:
            BatteryStatsImpl.m7757$$Nest$smresetIfNotNull(this.mUserActivityCounters, false, realtimeUs);
            BatteryStatsImpl.m7757$$Nest$smresetIfNotNull(this.mNetworkByteActivityCounters, false, realtimeUs);
            BatteryStatsImpl.m7757$$Nest$smresetIfNotNull(this.mNetworkPacketActivityCounters, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mMobileRadioActiveTime, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mMobileRadioActiveCount, false, realtimeUs);
            BatteryStatsImpl.m7755$$Nest$smresetIfNotNull(this.mWifiControllerActivity, false, realtimeUs);
            BatteryStatsImpl.m7755$$Nest$smresetIfNotNull(this.mBluetoothControllerActivity, false, realtimeUs);
            BatteryStatsImpl.m7755$$Nest$smresetIfNotNull(this.mModemControllerActivity, false, realtimeUs);
            if (resetReason != 4) goto L52;
            this.mUidEnergyConsumerStats = null;
        L53:
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mUserCpuTime, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mSystemCpuTime, false, realtimeUs);
            BatteryStatsImpl.m7758$$Nest$smresetIfNotNull(this.mCpuClusterSpeedTimesUs, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mCpuFreqTimeMs, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mScreenOffCpuFreqTimeMs, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mCpuActiveTimeMs, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mCpuClusterTimesMs, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mProcStateTimeMs, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mProcStateScreenOffTimeMs, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mMobileRadioApWakeupCount, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mWifiRadioApWakeupCount, false, realtimeUs);
            ArrayMap<String, Wakelock> wakeStats = this.mWakelockStats.getMap();
            int iw = wakeStats.size() - 1;
        L54:
            if (iw < 0) goto L60;
            Wakelock wl = wakeStats.valueAt(iw);
            if (wl.reset(realtimeUs) == false) goto L58;
            wakeStats.removeAt(iw);
        L59:
            iw = iw - 1;
            goto L54
        L58:
            active4 = true;
            goto L59
        L60:
            long realtimeMs = realtimeUs / 1000;
            this.mWakelockStats.cleanup(realtimeMs);
            ArrayMap<String, DualTimer> syncStats = this.mSyncStats.getMap();
            int is = syncStats.size() - 1;
        L61:
            if (is < 0) goto L67;
            DualTimer timer = syncStats.valueAt(is);
            if (timer.reset(false, realtimeUs) == false) goto L65;
            syncStats.removeAt(is);
            timer.detach();
        L66:
            is = is - 1;
            goto L61
        L65:
            active4 = true;
            goto L66
        L67:
            this.mSyncStats.cleanup(realtimeMs);
            ArrayMap<String, DualTimer> jobStats = this.mJobStats.getMap();
            int ij = jobStats.size() - 1;
        L68:
            if (ij < 0) goto L74;
            DualTimer timer2 = jobStats.valueAt(ij);
            if (timer2.reset(false, realtimeUs) == false) goto L72;
            jobStats.removeAt(ij);
            timer2.detach();
        L73:
            ij = ij - 1;
            goto L68
        L72:
            active4 = true;
            goto L73
        L74:
            this.mJobStats.cleanup(realtimeMs);
            this.mJobCompletions.clear();
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mJobsDeferredEventCount, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mJobsDeferredCount, false, realtimeUs);
            BatteryStatsImpl.m7756$$Nest$smresetIfNotNull(this.mJobsFreshnessTimeMs, false, realtimeUs);
            BatteryStatsImpl.m7757$$Nest$smresetIfNotNull(this.mJobsFreshnessBuckets, false, realtimeUs);
            int ise = this.mSensorStats.size() - 1;
        L75:
            if (ise < 0) goto L81;
            Sensor s = this.mSensorStats.valueAt(ise);
            if (s.reset(realtimeUs) == false) goto L79;
            this.mSensorStats.removeAt(ise);
        L80:
            ise = ise - 1;
            goto L75
        L79:
            active4 = true;
            goto L80
        L81:
            int ip = this.mProcessStats.size() - 1;
        L82:
            if (ip < 0) goto L84;
            Proc proc = this.mProcessStats.valueAt(ip);
            proc.detach();
            ip = ip - 1;
            goto L82
        L84:
            this.mProcessStats.clear();
            int i5 = this.mPids.size() - 1;
        L85:
            if (i5 < 0) goto L91;
            BatteryStats.Uid.Pid pid = this.mPids.valueAt(i5);
            if (pid.mWakeNesting <= 0) goto L89;
            active4 = true;
        L90:
            i5 = i5 - 1;
            goto L85
        L89:
            this.mPids.removeAt(i5);
            goto L90
        L91:
            int i6 = this.mPackageStats.size() - 1;
        L92:
            if (i6 < 0) goto L94;
            Pkg p = this.mPackageStats.valueAt(i6);
            p.detach();
            i6 = i6 - 1;
            goto L92
        L94:
            this.mPackageStats.clear();
            this.mBinderCallCount = 0;
            this.mBinderCallStats.clear();
            this.mProportionalSystemServiceUsage = 0.0d;
            this.mLastStepSystemTimeMs = 0;
            this.mLastStepUserTimeMs = 0;
            this.mCurStepSystemTimeMs = 0;
            this.mCurStepUserTimeMs = 0;
            return !active4;
        L52:
            EnergyConsumerStats.resetIfNotNull(this.mUidEnergyConsumerStats);
            goto L53
        L46:
            if (this.mVibratorOnTimer.reset(false, realtimeUs) == false) goto L48;
            this.mVibratorOnTimer.detach();
            this.mVibratorOnTimer = null;
            goto L49
        L48:
            active4 = true;
            goto L49
        }

        void detachFromTimeBase() {
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mWifiRunningTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mFullWifiLockTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mWifiScanTimer);
            BatteryStatsImpl.m7752$$Nest$smdetachIfNotNull(this.mWifiBatchedScanTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mWifiMulticastTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mAudioTurnedOnTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mVideoTurnedOnTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mFlashlightTurnedOnTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mCameraTurnedOnTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mForegroundActivityTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mForegroundServiceTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mAggregatedPartialWakelockTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mBluetoothScanTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mBluetoothUnoptimizedScanTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mBluetoothScanResultCounter);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mBluetoothScanResultBgCounter);
            BatteryStatsImpl.m7752$$Nest$smdetachIfNotNull(this.mProcessStateTimer);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mVibratorOnTimer);
            BatteryStatsImpl.m7752$$Nest$smdetachIfNotNull(this.mUserActivityCounters);
            BatteryStatsImpl.m7752$$Nest$smdetachIfNotNull(this.mNetworkByteActivityCounters);
            BatteryStatsImpl.m7752$$Nest$smdetachIfNotNull(this.mNetworkPacketActivityCounters);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mMobileRadioActiveTime);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mMobileRadioActiveCount);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mMobileRadioApWakeupCount);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mWifiRadioApWakeupCount);
            BatteryStatsImpl.m7750$$Nest$smdetachIfNotNull(this.mWifiControllerActivity);
            BatteryStatsImpl.m7750$$Nest$smdetachIfNotNull(this.mBluetoothControllerActivity);
            BatteryStatsImpl.m7750$$Nest$smdetachIfNotNull(this.mModemControllerActivity);
            this.mPids.clear();
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mUserCpuTime);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mSystemCpuTime);
            BatteryStatsImpl.m7753$$Nest$smdetachIfNotNull(this.mCpuClusterSpeedTimesUs);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mCpuActiveTimeMs);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mCpuFreqTimeMs);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mScreenOffCpuFreqTimeMs);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mCpuClusterTimesMs);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mProcStateTimeMs);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mProcStateScreenOffTimeMs);
            ArrayMap<String, Wakelock> wakeStats = this.mWakelockStats.getMap();
            int iw = wakeStats.size() - 1;
        L3:
            if (iw < 0) goto L5;
            Wakelock wl = wakeStats.valueAt(iw);
            wl.detachFromTimeBase();
            iw = iw - 1;
            goto L3
        L5:
            ArrayMap<String, DualTimer> syncStats = this.mSyncStats.getMap();
            int is = syncStats.size() - 1;
        L6:
            if (is < 0) goto L8;
            DualTimer timer = syncStats.valueAt(is);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(timer);
            is = is - 1;
            goto L6
        L8:
            ArrayMap<String, DualTimer> jobStats = this.mJobStats.getMap();
            int ij = jobStats.size() - 1;
        L9:
            if (ij < 0) goto L11;
            DualTimer timer2 = jobStats.valueAt(ij);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(timer2);
            ij = ij - 1;
            goto L9
        L11:
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mJobsDeferredEventCount);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mJobsDeferredCount);
            BatteryStatsImpl.m7751$$Nest$smdetachIfNotNull(this.mJobsFreshnessTimeMs);
            BatteryStatsImpl.m7752$$Nest$smdetachIfNotNull(this.mJobsFreshnessBuckets);
            int ise = this.mSensorStats.size() - 1;
        L12:
            if (ise < 0) goto L14;
            Sensor s = this.mSensorStats.valueAt(ise);
            s.detachFromTimeBase();
            ise = ise - 1;
            goto L12
        L14:
            int ip = this.mProcessStats.size() - 1;
        L15:
            if (ip < 0) goto L17;
            Proc proc = this.mProcessStats.valueAt(ip);
            proc.detach();
            ip = ip - 1;
            goto L15
        L17:
            this.mProcessStats.clear();
            int i = this.mPackageStats.size() - 1;
        L18:
            if (i < 0) goto L20;
            Pkg p = this.mPackageStats.valueAt(i);
            p.detach();
            i = i - 1;
            goto L18
        L20:
            this.mPackageStats.clear();
        }

        void writeJobCompletionsToParcelLocked(Parcel out) {
            int NJC = this.mJobCompletions.size();
            out.writeInt(NJC);
            int ijc = 0;
        L3:
            if (ijc >= NJC) goto L9;
            out.writeString(this.mJobCompletions.keyAt(ijc));
            SparseIntArray types = this.mJobCompletions.valueAt(ijc);
            int NT = types.size();
            out.writeInt(NT);
            int it = 0;
        L5:
            if (it >= NT) goto L7;
            out.writeInt(types.keyAt(it));
            out.writeInt(types.valueAt(it));
            it = it + 1;
            goto L5
        L7:
            ijc = ijc + 1;
            goto L3
        }

        void readJobCompletionsFromParcelLocked(Parcel in) {
            int numJobCompletions = in.readInt();
            this.mJobCompletions.clear();
            int j = 0;
        L3:
            if (j >= numJobCompletions) goto L12;
            String jobName = in.readString();
            int numTypes = in.readInt();
            if (numTypes <= 0) goto L10;
            SparseIntArray types = new SparseIntArray();
            int k = 0;
        L7:
            if (k >= numTypes) goto L9;
            int type = in.readInt();
            int count = in.readInt();
            types.put(type, count);
            k = k + 1;
            goto L7
        L9:
            this.mJobCompletions.put(jobName, types);
        L10:
            j = j + 1;
            goto L3
        }

        public void noteJobsDeferredLocked(int numDeferred, long sinceLast) {
            this.mJobsDeferredEventCount.addAtomic(1);
            this.mJobsDeferredCount.addAtomic(numDeferred);
            if (sinceLast == 0) goto L14;
            this.mJobsFreshnessTimeMs.addCountLocked(sinceLast);
            int i = 0;
        L6:
            if (i >= BatteryStats.JOB_FRESHNESS_BUCKETS.length) goto L18;
            if (sinceLast < BatteryStats.JOB_FRESHNESS_BUCKETS[i]) goto L10;
            i = i + 1;
            goto L6
        L10:
            if (this.mJobsFreshnessBuckets[i] != null) goto L12;
            this.mJobsFreshnessBuckets[i] = new Counter(this.mBsi.mOnBatteryTimeBase);
        L12:
            this.mJobsFreshnessBuckets[i].addAtomic(1);
            return;
        L18:
            return;
        }

        static {
            sTempBinderCallStats = new BinderCallStats();
        }

        public void noteBinderCallStatsLocked(long incrementalCallCount, Collection<BinderCallsStats.CallStat> callStats) {
            this.mBinderCallCount += incrementalCallCount;
            Iterator<BinderCallsStats.CallStat> r0 = callStats.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            BinderCallsStats.CallStat stat = r0.next();
            sTempBinderCallStats.binderClass = stat.binderClass;
            sTempBinderCallStats.transactionCode = stat.transactionCode;
            int index = this.mBinderCallStats.indexOf(sTempBinderCallStats);
            if (index < 0) goto L8;
            BinderCallStats bcs = this.mBinderCallStats.valueAt(index);
        L9:
            bcs.callCount += stat.incrementalCallCount;
            bcs.recordedCallCount = stat.recordedCallCount;
            bcs.recordedCpuTimeMicros = stat.cpuTimeMicros;
            goto L4
        L8:
            bcs = new BinderCallStats();
            bcs.binderClass = stat.binderClass;
            bcs.transactionCode = stat.transactionCode;
            this.mBinderCallStats.add(bcs);
            goto L9
        }

        public Proc getProcessStatsLocked(String name) {
            Proc ps = this.mProcessStats.get(name);
            if (ps != null) goto L6;
            Proc ps2 = new Proc(this.mBsi, name);
            this.mProcessStats.put(name, ps2);
            return ps2;
        L6:
            return ps;
        }

        public void updateUidProcessStateLocked(int procState, long elapsedRealtimeMs, long uptimeMs) {
            boolean userAwareService = ActivityManager.isForegroundService(procState);
            int uidRunningState = BatteryStats.mapToInternalProcessState(procState);
            if (this.mProcessState != uidRunningState) goto L8;
            if (userAwareService != this.mInForegroundService) goto L8;
            return;
        L8:
            if (this.mProcessState == uidRunningState) goto L36;
            if (this.mProcessState == 7) goto L12;
            this.mProcessStateTimer[this.mProcessState].stopRunningLocked(elapsedRealtimeMs);
        L12:
            if (uidRunningState == 7) goto L18;
            if (this.mProcessStateTimer[uidRunningState] != null) goto L16;
            makeProcessState(uidRunningState, null);
        L16:
            this.mProcessStateTimer[uidRunningState].startRunningLocked(elapsedRealtimeMs);
        L18:
            if (BatteryStatsImpl.m7726$$Nest$fgetmPowerStatsCollectorEnabled(this.mBsi).get(1) == false) goto L20;
        L22:
            int prevBatteryConsumerProcessState = BatteryStats.mapUidProcessStateToBatteryConsumerProcessState(this.mProcessState);
            this.mProcessState = uidRunningState;
            updateOnBatteryBgTimeBase(uptimeMs * 1000, elapsedRealtimeMs * 1000);
            updateOnBatteryScreenOffBgTimeBase(uptimeMs * 1000, 1000 * elapsedRealtimeMs);
            int batteryConsumerProcessState = BatteryStats.mapUidProcessStateToBatteryConsumerProcessState(uidRunningState);
            if (BatteryStatsImpl.m7729$$Nest$fgetmSystemReady(this.mBsi) == false) goto L25;
            BatteryStatsImpl.m7724$$Nest$fgetmHistory(this.mBsi).recordProcessStateChange(elapsedRealtimeMs, uptimeMs, this.mUid, batteryConsumerProcessState);
        L25:
            TimeMultiStateCounter.m7792$$Nest$msetState(getCpuActiveTimeCounter(), batteryConsumerProcessState, elapsedRealtimeMs);
            TimeMultiStateCounter.m7792$$Nest$msetState(getMobileRadioActiveTimeCounter(), batteryConsumerProcessState, elapsedRealtimeMs);
            ControllerActivityCounterImpl wifiControllerActivity = m7832getWifiControllerActivity();
            if (wifiControllerActivity == null) goto L28;
            ControllerActivityCounterImpl.m7774$$Nest$msetState(wifiControllerActivity, batteryConsumerProcessState, elapsedRealtimeMs);
        L28:
            ControllerActivityCounterImpl bluetoothControllerActivity = m7817getBluetoothControllerActivity();
            if (bluetoothControllerActivity == null) goto L31;
            ControllerActivityCounterImpl.m7774$$Nest$msetState(bluetoothControllerActivity, batteryConsumerProcessState, elapsedRealtimeMs);
        L31:
            EnergyConsumerStats energyStats = getOrCreateEnergyConsumerStatsIfSupportedLocked();
            if (energyStats == null) goto L34;
            energyStats.setState(batteryConsumerProcessState, elapsedRealtimeMs);
        L34:
            maybeScheduleExternalStatsSync(prevBatteryConsumerProcessState, batteryConsumerProcessState);
            goto L36
        L20:
            if (BatteryStatsImpl.m7745$$Nest$mtrackPerProcStateCpuTimes(this.mBsi) == false) goto L22;
            this.mBsi.updateProcStateCpuTimesLocked(this.mUid, elapsedRealtimeMs, uptimeMs);
            LongArrayMultiStateCounter onBatteryCounter = getProcStateTimeCounter(elapsedRealtimeMs).getCounter();
            LongArrayMultiStateCounter onBatteryScreenOffCounter = getProcStateScreenOffTimeCounter(elapsedRealtimeMs).getCounter();
            onBatteryCounter.setState(uidRunningState, elapsedRealtimeMs);
            onBatteryScreenOffCounter.setState(uidRunningState, elapsedRealtimeMs);
        L36:
            if (userAwareService == this.mInForegroundService) goto L42;
            if (userAwareService == false) goto L39;
            noteForegroundServiceResumedLocked(elapsedRealtimeMs);
        L40:
            this.mInForegroundService = userAwareService;
            return;
        L39:
            noteForegroundServicePausedLocked(elapsedRealtimeMs);
            goto L40
        }

        private void maybeScheduleExternalStatsSync(int oldProcessState, int newProcessState) {
            if (oldProcessState != newProcessState) goto L5;
            return;
        L5:
            if (oldProcessState != 0) goto L7;
            if (newProcessState != 2) goto L7;
            return;
        L7:
            if (oldProcessState != 2) goto L10;
            if (newProcessState != 0) goto L10;
            return;
        L10:
            int flags = 14;
            if (BatteryStatsImpl.m7754$$Nest$smisActiveRadioPowerState(this.mBsi.mMobileRadioPowerState) == true) goto L13;
            flags = 14 & (-5);
        L13:
            BatteryStatsImpl.m7719$$Nest$fgetmExternalSync(this.mBsi).scheduleSyncDueToProcessStateChange(flags, this.mBsi.mConstants.PROC_STATE_CHANGE_COLLECTION_DELAY_MS);
        }

        public boolean isInBackground() {
            if (this.mProcessState < 3) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean updateOnBatteryBgTimeBase(long uptimeUs, long realtimeUs) {
            if (this.mBsi.mOnBatteryTimeBase.isRunning() == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            boolean on = r0;
            return this.mOnBatteryBackgroundTimeBase.setRunning(on, uptimeUs, realtimeUs);
        L5:
            if (isInBackground() == false) goto L7;
            r0 = true;
            goto L8
        }

        public boolean updateOnBatteryScreenOffBgTimeBase(long uptimeUs, long realtimeUs) {
            if (this.mBsi.mOnBatteryScreenOffTimeBase.isRunning() == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            boolean on = r0;
            return this.mOnBatteryScreenOffBackgroundTimeBase.setRunning(on, uptimeUs, realtimeUs);
        L5:
            if (isInBackground() == false) goto L7;
            r0 = true;
            goto L8
        }

        public SparseArray<? extends BatteryStats.Uid.Pid> getPidStats() {
            return this.mPids;
        }

        public BatteryStats.Uid.Pid getPidStatsLocked(int pid) {
            BatteryStats.Uid.Pid p = this.mPids.get(pid);
            if (p != null) goto L6;
            BatteryStats.Uid.Pid p2 = new BatteryStats.Uid.Pid(this);
            this.mPids.put(pid, p2);
            return p2;
        L6:
            return p;
        }

        public Pkg getPackageStatsLocked(String name) {
            Pkg ps = this.mPackageStats.get(name);
            if (ps != null) goto L6;
            Pkg ps2 = new Pkg(this.mBsi);
            this.mPackageStats.put(name, ps2);
            return ps2;
        L6:
            return ps;
        }

        public Pkg.Serv getServiceStatsLocked(String pkg, String serv) {
            Pkg ps = getPackageStatsLocked(pkg);
            Pkg.Serv ss = ps.mServiceStats.get(serv);
            if (ss != null) goto L6;
            Pkg.Serv ss2 = ps.newServiceStatsLocked();
            ps.mServiceStats.put(serv, ss2);
            return ss2;
        L6:
            return ss;
        }

        public void readSyncSummaryFromParcelLocked(String name, Parcel in) {
            DualTimer timer = this.mSyncStats.instantiateObject();
            timer.readSummaryFromParcelLocked(in);
            this.mSyncStats.add(name, timer);
        }

        public void readJobSummaryFromParcelLocked(String name, Parcel in) {
            DualTimer timer = this.mJobStats.instantiateObject();
            timer.readSummaryFromParcelLocked(in);
            this.mJobStats.add(name, timer);
        }

        public void readWakeSummaryFromParcelLocked(String wlName, Parcel in) {
            Wakelock wl = new Wakelock(this.mBsi, this);
            this.mWakelockStats.add(wlName, wl);
            if (in.readInt() == 0) goto L6;
            getWakelockTimerLocked(wl, 1).readSummaryFromParcelLocked(in);
        L6:
            if (in.readInt() == 0) goto L9;
            getWakelockTimerLocked(wl, 0).readSummaryFromParcelLocked(in);
        L9:
            if (in.readInt() == 0) goto L12;
            getWakelockTimerLocked(wl, 2).readSummaryFromParcelLocked(in);
        L12:
            if (in.readInt() == 0) goto L15;
            getWakelockTimerLocked(wl, 18).readSummaryFromParcelLocked(in);
            return;
        }

        public DualTimer getSensorTimerLocked(int sensor, boolean create) {
            Sensor se = this.mSensorStats.get(sensor);
            if (se != null) goto L8;
            if (create == true) goto L7;
            return null;
        L7:
            se = new Sensor(this.mBsi, this, sensor);
            this.mSensorStats.put(sensor, se);
        L8:
            DualTimer t = se.mTimer;
            if (t == null) goto L11;
            return t;
        L11:
            ArrayList<StopwatchTimer> timers = (ArrayList) BatteryStatsImpl.m7728$$Nest$fgetmSensorTimers(this.mBsi).get(sensor);
            if (timers != null) goto L14;
            ArrayList<StopwatchTimer> timers2 = new ArrayList();
            BatteryStatsImpl.m7728$$Nest$fgetmSensorTimers(this.mBsi).put(sensor, timers2);
            ArrayList<StopwatchTimer> timers3 = timers2;
        L15:
            DualTimer t2 = new DualTimer(this.mBsi.mClock, this, 3, timers3, this.mBsi.mOnBatteryTimeBase, this.mOnBatteryBackgroundTimeBase);
            se.mTimer = t2;
            return t2;
        L14:
            timers3 = timers;
            goto L15
        }

        public void noteStartSyncLocked(String name, long elapsedRealtimeMs) {
            DualTimer t = this.mSyncStats.startObject(name, elapsedRealtimeMs);
            if (t == null) goto L6;
            t.startRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteStopSyncLocked(String name, long elapsedRealtimeMs) {
            DualTimer t = this.mSyncStats.stopObject(name, elapsedRealtimeMs);
            if (t == null) goto L6;
            t.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteStartJobLocked(String name, long elapsedRealtimeMs) {
            DualTimer t = this.mJobStats.startObject(name, elapsedRealtimeMs);
            if (t == null) goto L6;
            t.startRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteStopJobLocked(String name, long elapsedRealtimeMs, int stopReason) {
            DualTimer t = this.mJobStats.stopObject(name, elapsedRealtimeMs);
            if (t == null) goto L6;
            t.stopRunningLocked(elapsedRealtimeMs);
        L6:
            if (this.mBsi.mOnBatteryTimeBase.isRunning() == false) goto L12;
            SparseIntArray types = this.mJobCompletions.get(name);
            if (types != null) goto L10;
            types = new SparseIntArray();
            this.mJobCompletions.put(name, types);
        L10:
            int last = types.get(stopReason, 0);
            types.put(stopReason, last + 1);
            return;
        }

        public StopwatchTimer getWakelockTimerLocked(Wakelock wl, int type) {
            if (wl != null) goto L5;
            return null;
        L5:
            switch(type) {
                case 0: goto L20;
                case 1: goto L16;
                case 2: goto L12;
                case 18: goto L8;
                default: goto L7;
            };
        L8:
            StopwatchTimer t = wl.mTimerDraw;
            if (t != null) goto L24;
            StopwatchTimer t2 = new StopwatchTimer(this.mBsi.mClock, this, 18, BatteryStatsImpl.m7718$$Nest$fgetmDrawTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase);
            wl.mTimerDraw = t2;
            return t2;
        L24:
            return t;
        L12:
            StopwatchTimer t3 = wl.mTimerWindow;
            if (t3 != null) goto L25;
            StopwatchTimer t4 = new StopwatchTimer(this.mBsi.mClock, this, 2, BatteryStatsImpl.m7737$$Nest$fgetmWindowTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase);
            wl.mTimerWindow = t4;
            return t4;
        L25:
            return t3;
        L16:
            StopwatchTimer t5 = wl.mTimerFull;
            if (t5 != null) goto L26;
            StopwatchTimer t6 = new StopwatchTimer(this.mBsi.mClock, this, 1, BatteryStatsImpl.m7722$$Nest$fgetmFullTimers(this.mBsi), this.mBsi.mOnBatteryTimeBase);
            wl.mTimerFull = t6;
            return t6;
        L26:
            return t5;
        L20:
            DualTimer t7 = wl.mTimerPartial;
            if (t7 != null) goto L27;
            DualTimer t8 = new DualTimer(this.mBsi.mClock, this, 0, this.mBsi.mPartialTimers, this.mBsi.mOnBatteryScreenOffTimeBase, this.mOnBatteryScreenOffBackgroundTimeBase);
            wl.mTimerPartial = t8;
            return t8;
        L27:
            return t7;
        L7:
            throw new IllegalArgumentException("type=" + type);
        }

        public void noteStartWakeLocked(int pid, String name, int type, long elapsedRealtimeMs) {
            Wakelock wl = this.mWakelockStats.startObject(name, elapsedRealtimeMs);
            if (wl == null) goto L5;
            getWakelockTimerLocked(wl, type).startRunningLocked(elapsedRealtimeMs);
        L5:
            if (type != 0) goto L12;
            createAggregatedPartialWakelockTimerLocked().startRunningLocked(elapsedRealtimeMs);
            if (pid < 0) goto L13;
            BatteryStats.Uid.Pid p = getPidStatsLocked(pid);
            int r2 = p.mWakeNesting;
            p.mWakeNesting = r2 + 1;
            if (r2 != 0) goto L14;
            p.mWakeStartMs = elapsedRealtimeMs;
            return;
        L14:
            return;
        L13:
            return;
        }

        public void noteStopWakeLocked(int pid, String name, int type, long elapsedRealtimeMs) {
            Wakelock wl = this.mWakelockStats.stopObject(name, elapsedRealtimeMs);
            if (wl == null) goto L5;
            StopwatchTimer wlt = getWakelockTimerLocked(wl, type);
            wlt.stopRunningLocked(elapsedRealtimeMs);
        L5:
            if (type == 0) goto L7;
            return;
        L7:
            if (this.mAggregatedPartialWakelockTimer == null) goto L9;
            this.mAggregatedPartialWakelockTimer.stopRunningLocked(elapsedRealtimeMs);
        L9:
            if (pid < 0) goto L19;
            BatteryStats.Uid.Pid p = this.mPids.get(pid);
            if (p != null) goto L13;
            return;
        L13:
            if (p.mWakeNesting <= 0) goto L21;
            int r2 = p.mWakeNesting;
            p.mWakeNesting = r2 - 1;
            if (r2 != 1) goto L22;
            p.mWakeSumMs += elapsedRealtimeMs - p.mWakeStartMs;
            p.mWakeStartMs = 0;
            return;
        L22:
            return;
        L21:
            return;
        }

        public void reportExcessiveCpuLocked(String proc, long overTimeMs, long usedTimeMs) {
            Proc p = getProcessStatsLocked(proc);
            if (p == null) goto L6;
            p.addExcessiveCpu(overTimeMs, usedTimeMs);
            return;
        }

        public void noteStartSensor(int sensor, long elapsedRealtimeMs) {
            DualTimer t = getSensorTimerLocked(sensor, true);
            t.startRunningLocked(elapsedRealtimeMs);
        }

        public void noteStopSensor(int sensor, long elapsedRealtimeMs) {
            DualTimer t = getSensorTimerLocked(sensor, false);
            if (t == null) goto L6;
            t.stopRunningLocked(elapsedRealtimeMs);
            return;
        }

        public void noteStartGps(long elapsedRealtimeMs) {
            noteStartSensor(ProcessList.INVALID_ADJ, elapsedRealtimeMs);
        }

        public void noteStopGps(long elapsedRealtimeMs) {
            noteStopSensor(ProcessList.INVALID_ADJ, elapsedRealtimeMs);
        }

        public Object getBatteryStatsImplUidSmtEx() {
            return this.mBatteryStatsImplUidSmtEx;
        }
    }

    public final class UidToRemove {
        private final int mEndUid;
        private final int mStartUid;
        private final long mUidRemovalTimestamp;
        final /* synthetic */ BatteryStatsImpl this$0;

        public UidToRemove(BatteryStatsImpl this$0, int uid, long timestamp) {
            this(this$0, uid, uid, timestamp);
        }

        public UidToRemove(BatteryStatsImpl this$0, int startUid, int endUid, long timestamp) {
            this.this$0 = this$0;
            this.mStartUid = startUid;
            this.mEndUid = endUid;
            this.mUidRemovalTimestamp = timestamp;
        }

        public long getUidRemovalTimestamp() {
            return this.mUidRemovalTimestamp;
        }

        void removeLocked() {
            BatteryStatsImpl.m7742$$Nest$mremoveCpuStatsForUidRangeLocked(this.this$0, this.mStartUid, this.mEndUid);
        }
    }

    public static abstract class UserInfoProvider {
        private int[] userIds;

        protected abstract int[] getUserIds();

        public UserInfoProvider() {
        }

        public final void refreshUserIds() {
            this.userIds = getUserIds();
        }

        public boolean exists(int userId) {
            if (this.userIds != null) goto L7;
            return true;
        L7:
            return ArrayUtils.contains(this.userIds, userId);
        }
    }

    public static /* synthetic */ void $r8$lambda$3Qe6wMF9IiItThe3WE3h7GJSQuU(BatteryStatsImpl r0) {
        r0.lambda$new$1();
    }

    public static /* synthetic */ void $r8$lambda$4oR0MyxxkPH0JSQXqVxAZgbHyhc(BatteryStatsImpl r0, PowerStats r1) {
        r0.recordPowerStats(r1);
    }

    public static /* synthetic */ void $r8$lambda$6fx51luiEf15bPcUvMh95iJTeEE(BatteryStatsImpl r0, WifiActivityEnergyInfo r1, NetworkStats r2, long r3, long r5) {
        r0.onWifiPowerStatsRetrieved(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$6yBcUDmGxMjHAVKJP_PZldZF_ok(BatteryStatsImpl r0, BluetoothActivityEnergyInfo r1, long r2, long r4) {
        r0.onBluetoothPowerStatsRetrieved(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$7aU19rBLU_V4yTnmihqQAygcE6k(BatteryStatsImpl r0) {
        r0.lambda$new$9();
    }

    /* JADX INFO: renamed from: $r8$lambda$HfIv5yfmrbErw-kEmGzxQ4gH5o8, reason: not valid java name */
    public static /* synthetic */ void m7708$r8$lambda$HfIv5yfmrbErwkEmGzxQ4gH5o8(BatteryStatsImpl r0, long r1, long r3, int r5, Long r6) {
        r0.lambda$readKernelUidCpuActiveTimesLocked$5(r1, r3, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$T0tDgfsn0lSDXAe2wAZfUdGKPVk(BatteryStatsImpl r0, ModemActivityInfo r1, NetworkStats r2, long r3, long r5) {
        r0.onMobileRadioPowerStatsRetrieved(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$aztDdIUJMiqPBARZsvibLcuiwR4(BatteryStatsImpl r0, AlarmManager r1, long r2) {
        r0.lambda$scheduleNextResetWhilePluggedInCheck$7(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$cOCAfGtgs9yT3JRQA8AkTmqbZRM(BatteryStatsImpl r0, int r1) {
        r0.lambda$startNewSession$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$daTKAIEwupQ-yt4BT--WYTVY2ww, reason: not valid java name */
    public static /* synthetic */ void m7709$r8$lambda$daTKAIEwupQyt4BTWYTVY2ww(BatteryStatsImpl r0, long r1, long r3, boolean r5, boolean r6, boolean r7, int r8, int r9, int[] r10, CpuDeltaPowerAccumulator r11, int r12, long[] r13) {
        r0.lambda$readKernelUidCpuFreqTimesLocked$4(r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ void $r8$lambda$fSAygqaH7iseBRJbO45y3pm4lFQ(BatteryStatsImpl r0, long r1, long r3, boolean r5, CpuDeltaPowerAccumulator r6, int r7, long[] r8) {
        r0.lambda$readKernelUidCpuClusterTimesLocked$6(r1, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ void $r8$lambda$foqL610yAiRU9tDyeLD_0NcucxU(BatteryStatsImpl r0, long r1, long r3, int r5, boolean r6, SparseLongArray r7, int r8, long[] r9) {
        r0.lambda$readKernelUidCpuTimesLocked$3(r1, r3, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void $r8$lambda$o6Ts4vpUJMeeVSjgKFfuJcrqGS8(BatteryStatsImpl r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$oFSwpeZ_DGzi-fezNRPZy9ildVo, reason: not valid java name */
    public static /* synthetic */ void m7710$r8$lambda$oFSwpeZ_DGzifezNRPZy9ildVo(BatteryStatsImpl r0, AlarmManager r1) {
        r0.lambda$setOnBatteryLocked$8(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioTurnedOnTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7711$$Nest$fgetmAudioTurnedOnTimers(BatteryStatsImpl r0) {
        return r0.mAudioTurnedOnTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryHistoryDirectory, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryHistoryDirectory m7712$$Nest$fgetmBatteryHistoryDirectory(BatteryStatsImpl r0) {
        return r0.mBatteryHistoryDirectory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryVoltageMv, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7713$$Nest$fgetmBatteryVoltageMv(BatteryStatsImpl r0) {
        return r0.mBatteryVoltageMv;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothScanOnTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7714$$Nest$fgetmBluetoothScanOnTimers(BatteryStatsImpl r0) {
        return r0.mBluetoothScanOnTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryCallback m7715$$Nest$fgetmCallback(BatteryStatsImpl r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraTurnedOnTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7716$$Nest$fgetmCameraTurnedOnTimers(BatteryStatsImpl r0) {
        return r0.mCameraTurnedOnTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeferSetCharging, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m7717$$Nest$fgetmDeferSetCharging(BatteryStatsImpl r0) {
        return r0.mDeferSetCharging;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDrawTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7718$$Nest$fgetmDrawTimers(BatteryStatsImpl r0) {
        return r0.mDrawTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExternalSync, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExternalStatsSync m7719$$Nest$fgetmExternalSync(BatteryStatsImpl r0) {
        return r0.mExternalSync;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlashlightTurnedOnTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7720$$Nest$fgetmFlashlightTurnedOnTimers(BatteryStatsImpl r0) {
        return r0.mFlashlightTurnedOnTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrameworkStatsLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ FrameworkStatsLogger m7721$$Nest$fgetmFrameworkStatsLogger(BatteryStatsImpl r0) {
        return r0.mFrameworkStatsLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFullTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7722$$Nest$fgetmFullTimers(BatteryStatsImpl r0) {
        return r0.mFullTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFullWifiLockTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7723$$Nest$fgetmFullWifiLockTimers(BatteryStatsImpl r0) {
        return r0.mFullWifiLockTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHistory, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryStatsHistory m7724$$Nest$fgetmHistory(BatteryStatsImpl r0) {
        return r0.mHistory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerProfile m7725$$Nest$fgetmPowerProfile(BatteryStatsImpl r0) {
        return r0.mPowerProfile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerStatsCollectorEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m7726$$Nest$fgetmPowerStatsCollectorEnabled(BatteryStatsImpl r0) {
        return r0.mPowerStatsCollectorEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScreenUsageTimeRetriever, reason: not valid java name */
    static /* bridge */ /* synthetic */ ScreenPowerStatsCollector.ScreenUsageTimeRetriever m7727$$Nest$fgetmScreenUsageTimeRetriever(BatteryStatsImpl r0) {
        return r0.mScreenUsageTimeRetriever;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m7728$$Nest$fgetmSensorTimers(BatteryStatsImpl r0) {
        return r0.mSensorTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7729$$Nest$fgetmSystemReady(BatteryStatsImpl r0) {
        return r0.mSystemReady;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVideoTurnedOnTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7730$$Nest$fgetmVideoTurnedOnTimers(BatteryStatsImpl r0) {
        return r0.mVideoTurnedOnTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWakelockDurationRetriever, reason: not valid java name */
    static /* bridge */ /* synthetic */ WakelockPowerStatsCollector.WakelockDurationRetriever m7731$$Nest$fgetmWakelockDurationRetriever(BatteryStatsImpl r0) {
        return r0.mWakelockDurationRetriever;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiBatchedScanTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m7732$$Nest$fgetmWifiBatchedScanTimers(BatteryStatsImpl r0) {
        return r0.mWifiBatchedScanTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiMulticastTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7733$$Nest$fgetmWifiMulticastTimers(BatteryStatsImpl r0) {
        return r0.mWifiMulticastTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiRunningTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7734$$Nest$fgetmWifiRunningTimers(BatteryStatsImpl r0) {
        return r0.mWifiRunningTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiScanTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7735$$Nest$fgetmWifiScanTimers(BatteryStatsImpl r0) {
        return r0.mWifiScanTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiStatsRetriever, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiPowerStatsCollector.WifiStatsRetriever m7736$$Nest$fgetmWifiStatsRetriever(BatteryStatsImpl r0) {
        return r0.mWifiStatsRetriever;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7737$$Nest$fgetmWindowTimers(BatteryStatsImpl r0) {
        return r0.mWindowTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$mnoteUsbConnectionStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7738$$Nest$mnoteUsbConnectionStateLocked(BatteryStatsImpl r0, boolean r1, long r2, long r4) {
        r0.noteUsbConnectionStateLocked(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monAfterIsolatedUidRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7739$$Nest$monAfterIsolatedUidRemoved(BatteryStatsImpl r0, int r1, int r2) {
        r0.onAfterIsolatedUidRemoved(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monBeforeIsolatedUidRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7740$$Nest$monBeforeIsolatedUidRemoved(BatteryStatsImpl r0, int r1, int r2) {
        r0.onBeforeIsolatedUidRemoved(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monIsolatedUidAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7741$$Nest$monIsolatedUidAdded(BatteryStatsImpl r0, int r1, int r2) {
        r0.onIsolatedUidAdded(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveCpuStatsForUidRangeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7742$$Nest$mremoveCpuStatsForUidRangeLocked(BatteryStatsImpl r0, int r1, int r2) {
        r0.removeCpuStatsForUidRangeLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mretrieveBluetoothScanTimesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7743$$Nest$mretrieveBluetoothScanTimesLocked(BatteryStatsImpl r0, BluetoothPowerStatsCollector.BluetoothStatsRetriever.Callback r1) {
        r0.retrieveBluetoothScanTimesLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mretrieveWifiScanTimesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7744$$Nest$mretrieveWifiScanTimesLocked(BatteryStatsImpl r0, WifiPowerStatsCollector.WifiStatsRetriever.Callback r1) {
        r0.retrieveWifiScanTimesLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtrackPerProcStateCpuTimes, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7745$$Nest$mtrackPerProcStateCpuTimes(BatteryStatsImpl r0) {
        return r0.trackPerProcStateCpuTimes();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetMAX_WAKELOCKS_PER_UID, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7746$$Nest$sfgetMAX_WAKELOCKS_PER_UID() {
        return MAX_WAKELOCKS_PER_UID;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetMODEM_TX_POWER_LEVEL_COUNT, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7747$$Nest$sfgetMODEM_TX_POWER_LEVEL_COUNT() {
        return MODEM_TX_POWER_LEVEL_COUNT;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetZERO_LONG_COUNTER, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryStats.LongCounter m7748$$Nest$sfgetZERO_LONG_COUNTER() {
        return ZERO_LONG_COUNTER;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetZERO_LONG_COUNTER_ARRAY, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryStats.LongCounter[] m7749$$Nest$sfgetZERO_LONG_COUNTER_ARRAY() {
        return ZERO_LONG_COUNTER_ARRAY;
    }

    /* JADX INFO: renamed from: -$$Nest$smdetachIfNotNull, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7750$$Nest$smdetachIfNotNull(ControllerActivityCounterImpl r0) {
        detachIfNotNull(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smdetachIfNotNull, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7751$$Nest$smdetachIfNotNull(TimeBaseObs r0) {
        detachIfNotNull(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smdetachIfNotNull, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7752$$Nest$smdetachIfNotNull(TimeBaseObs[] r0) {
        detachIfNotNull(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smdetachIfNotNull, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7753$$Nest$smdetachIfNotNull(TimeBaseObs[][] r0) {
        detachIfNotNull(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisActiveRadioPowerState, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7754$$Nest$smisActiveRadioPowerState(int r0) {
        return isActiveRadioPowerState(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smresetIfNotNull, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7755$$Nest$smresetIfNotNull(ControllerActivityCounterImpl r0, boolean r1, long r2) {
        return resetIfNotNull(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smresetIfNotNull, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7756$$Nest$smresetIfNotNull(TimeBaseObs r0, boolean r1, long r2) {
        return resetIfNotNull(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smresetIfNotNull, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7757$$Nest$smresetIfNotNull(TimeBaseObs[] r0, boolean r1, long r2) {
        return resetIfNotNull(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smresetIfNotNull, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7758$$Nest$smresetIfNotNull(TimeBaseObs[][] r0, boolean r1, long r2) {
        return resetIfNotNull(r0, r1, r2);
    }

    static /* synthetic */ boolean access$000() {
        return BatteryStats.isLowRamDevice();
    }

    static /* synthetic */ boolean access$100() {
        return BatteryStats.isLowRamDevice();
    }

    public /* bridge */ /* synthetic */ BatteryStats.Timer getPhoneDataConnectionTimer(int r1) {
        return m7759getPhoneDataConnectionTimer(r1);
    }

    public /* bridge */ /* synthetic */ BatteryStats.Timer getPhoneSignalScanningTimer() {
        return m7760getPhoneSignalScanningTimer();
    }

    public /* bridge */ /* synthetic */ BatteryStats.Timer getPhoneSignalStrengthTimer(int r1) {
        return m7761getPhoneSignalStrengthTimer(r1);
    }

    public /* bridge */ /* synthetic */ BatteryStats.Timer getScreenBrightnessTimer(int r1) {
        return m7762getScreenBrightnessTimer(r1);
    }

    public /* bridge */ /* synthetic */ BatteryStats.Timer getWifiSignalStrengthTimer(int r1) {
        return m7763getWifiSignalStrengthTimer(r1);
    }

    public /* bridge */ /* synthetic */ BatteryStats.Timer getWifiStateTimer(int r1) {
        return m7764getWifiStateTimer(r1);
    }

    public /* bridge */ /* synthetic */ BatteryStats.Timer getWifiSupplStateTimer(int r1) {
        return m7765getWifiSupplStateTimer(r1);
    }

    static {
        VERSION = FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__PLATFORM_ROLE_HOLDER_UPDATE_FAILED;
        if (BatteryStats.isLowRamDevice() == false) goto L5;
        int r0 = 40;
    L6:
        MAX_WAKELOCKS_PER_UID = r0;
        CELL_SIGNAL_STRENGTH_LEVEL_COUNT = BatteryStats.getCellSignalStrengthLevelCount();
        MODEM_TX_POWER_LEVEL_COUNT = BatteryStats.getModemTxPowerLevelCount();
        ZERO_LONG_COUNTER = new AnonymousClass1();
        ZERO_LONG_COUNTER_ARRAY = new BatteryStats.LongCounter[]{ZERO_LONG_COUNTER};
        SUPPORTED_PER_PROCESS_STATE_STANDARD_ENERGY_BUCKETS = new int[]{3, 7, 4, 5};
        return;
    L5:
        r0 = 200;
        goto L6
    }

    BatteryStatsSession getBatteryStatsSession() {
        monitor-enter(this);
        long elapsedTimeUs = this.mClock.elapsedRealtime() * 1000;     // Catch: Throwable -> L7
        long batteryTimeRemainingUs = computeBatteryTimeRemaining(elapsedTimeUs);     // Catch: Throwable -> L7
        long chargeTimeRemainingMs = -1;
        if (batteryTimeRemainingUs < 0) goto L9;
        long batteryTimeRemainingMs = batteryTimeRemainingUs / 1000;     // Catch: Throwable -> L7
    L10:
        long chargeTimeRemainingUs = computeChargeTimeRemaining(elapsedTimeUs);     // Catch: Throwable -> L7
        if (chargeTimeRemainingUs < 0) goto L13;
        chargeTimeRemainingMs = chargeTimeRemainingUs / 1000;     // Catch: Throwable -> L7
    L13:
        BatteryStatsSession r0 = new BatteryStatsSession(this.mHistory, getMonotonicStartTime(), getStartClockTime(), batteryTimeRemainingMs, chargeTimeRemainingMs, getEstimatedBatteryCapacity(), getCustomEnergyConsumerNames(), this);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r0;
    L9:
        batteryTimeRemainingMs = -1;
    L7:
        th = move-exception;
        throw th;
    }

    public LongSparseArray<SamplingTimer> getKernelMemoryStats() {
        return this.mKernelMemoryStats;
    }

    public BatteryStatsHistory getHistory() {
        return this.mHistory;
    }

    BatteryStatsHistory copyHistory() {
        return this.mHistory.copy();
    }

    public void postBatteryNeedsCpuUpdateMsg() {
        this.mHandler.sendEmptyMessage(1);
    }

    public void updateProcStateCpuTimesLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mPowerStatsCollectorEnabled.get(1) == false) goto L5;
        return;
    L5:
        ensureKernelSingleUidTimeReaderLocked();
        Uid u = getUidStatsLocked(uid);
        this.mNumSingleUidCpuTimeReads++;
        LongArrayMultiStateCounter onBatteryCounter = Uid.m7811$$Nest$mgetProcStateTimeCounter(u, elapsedRealtimeMs).getCounter();
        LongArrayMultiStateCounter onBatteryScreenOffCounter = Uid.m7810$$Nest$mgetProcStateScreenOffTimeCounter(u, elapsedRealtimeMs).getCounter();
        this.mKernelSingleUidTimeReader.addDelta(uid, onBatteryCounter, elapsedRealtimeMs);
        this.mKernelSingleUidTimeReader.addDelta(uid, onBatteryScreenOffCounter, elapsedRealtimeMs);
        if (u.mChildUids == null) goto L13;
        long[] delta = getCpuTimeInFreqContainer();
        int childUidCount = u.mChildUids.size();
        int j = childUidCount - 1;
    L8:
        if (j < 0) goto L17;
        LongArrayMultiStateCounter cpuTimeInFreqCounter = u.mChildUids.valueAt(j).cpuTimeInFreqCounter;
        if (cpuTimeInFreqCounter == null) goto L12;
        this.mKernelSingleUidTimeReader.addDelta(u.mChildUids.keyAt(j), cpuTimeInFreqCounter, elapsedRealtimeMs, delta);
        onBatteryCounter.addCounts(delta);
        onBatteryScreenOffCounter.addCounts(delta);
    L12:
        j = j - 1;
        goto L8
    L17:
        return;
    }

    public void clearPendingRemovedUidsLocked() {
        long cutOffTimeMs = this.mClock.elapsedRealtime() - this.mConstants.UID_REMOVE_DELAY_MS;
    L4:
        if (this.mPendingRemovedUids.isEmpty() == true) goto L8;
        if (this.mPendingRemovedUids.peek().getUidRemovalTimestamp() >= cutOffTimeMs) goto L11;
        this.mPendingRemovedUids.poll().removeLocked();
        goto L4
    L11:
        return;
    }

    public void updateCpuTimesForAllUids() {
        if (this.mPowerStatsCollectorEnabled.get(1) == false) goto L6;
        this.mCpuPowerStatsCollector.schedule();
        return;
    L6:
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (trackPerProcStateCpuTimes() == true) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L13:
        ensureKernelSingleUidTimeReaderLocked();     // Catch: Throwable -> L11
        SparseArray<long[]> allUidCpuFreqTimesMs = this.mCpuUidFreqTimeReader.getAllUidCpuFreqTimeMs();     // Catch: Throwable -> L11
        int i = allUidCpuFreqTimesMs.size() - 1;     // Catch: Throwable -> L11
    L14:
        if (i < 0) goto L36;
        int uid = allUidCpuFreqTimesMs.keyAt(i);     // Catch: Throwable -> L11
        int parentUid = mapUid(uid);     // Catch: Throwable -> L11
        Uid u = getAvailableUidStatsLocked(parentUid);     // Catch: Throwable -> L11
        if (u == null) goto L34;
        int procState = u.mProcessState;     // Catch: Throwable -> L11
        if (procState == 7) goto L34;
        long elapsedRealtimeMs = this.mClock.elapsedRealtime();     // Catch: Throwable -> L11
        this.mClock.uptimeMillis();     // Catch: Throwable -> L11
        LongArrayMultiStateCounter onBatteryCounter = Uid.m7811$$Nest$mgetProcStateTimeCounter(u, elapsedRealtimeMs).getCounter();     // Catch: Throwable -> L11
        LongArrayMultiStateCounter onBatteryScreenOffCounter = Uid.m7810$$Nest$mgetProcStateScreenOffTimeCounter(u, elapsedRealtimeMs).getCounter();     // Catch: Throwable -> L11
        if (uid == parentUid) goto L33;
        if (Process.isSdkSandboxUid(uid) == true) goto L33;
        Uid.ChildUid childUid = u.getChildUid(uid);     // Catch: Throwable -> L11
        if (childUid == null) goto L34;
        LongArrayMultiStateCounter counter = childUid.cpuTimeInFreqCounter;     // Catch: Throwable -> L11
        if (counter == null) goto L34;
        long[] deltaContainer = getCpuTimeInFreqContainer();     // Catch: Throwable -> L11
        this.mKernelSingleUidTimeReader.addDelta(uid, counter, elapsedRealtimeMs, deltaContainer);     // Catch: Throwable -> L11
        onBatteryCounter.addCounts(deltaContainer);     // Catch: Throwable -> L11
        onBatteryScreenOffCounter.addCounts(deltaContainer);     // Catch: Throwable -> L11
    L33:
        this.mKernelSingleUidTimeReader.addDelta(parentUid, onBatteryCounter, elapsedRealtimeMs);     // Catch: Throwable -> L11
        this.mKernelSingleUidTimeReader.addDelta(parentUid, onBatteryScreenOffCounter, elapsedRealtimeMs);     // Catch: Throwable -> L11
    L34:
        i = i - 1;     // Catch: Throwable -> L11
        goto L14
    L36:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    private void ensureKernelSingleUidTimeReaderLocked() {
        boolean r1 = true;
        if (this.mPowerStatsCollectorEnabled.get(1) == false) goto L5;
        return;
    L5:
        if (this.mKernelSingleUidTimeReader != null) goto L16;
        this.mKernelSingleUidTimeReader = new KernelSingleUidTimeReader(this.mCpuScalingPolicies.getScalingStepCount());
        if (this.mCpuUidFreqTimeReader.perClusterTimesAvailable() == true) goto L10;
    L12:
        r1 = false;
    L13:
        this.mPerProcStateCpuTimesAvailable = r1;
        return;
    L10:
        if (this.mKernelSingleUidTimeReader.singleUidCpuTimesAvailable() == false) goto L12;
    }

    private RadioAccessTechnologyBatteryStats getRatBatteryStatsLocked(int rat) {
        RadioAccessTechnologyBatteryStats stats = this.mPerRatBatteryStats[rat];
        if (stats == null) goto L5;
        return stats;
    L5:
        if (rat != 2) goto L7;
        int freqCount = 5;
    L8:
        RadioAccessTechnologyBatteryStats stats2 = new RadioAccessTechnologyBatteryStats(freqCount, this.mClock, this.mOnBatteryTimeBase);
        this.mPerRatBatteryStats[rat] = stats2;
        return stats2;
    L7:
        freqCount = 1;
        goto L8
    }

    private /* synthetic */ void lambda$new$1() {
        this.mHandler.post(new BatteryStatsImpl$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ void lambda$new$0() {
        monitor-enter(this);
        maybeResetWhilePluggedInLocked();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public Map<String, ? extends Timer> getRpmStats() {
        return this.mRpmStats;
    }

    public Map<String, ? extends Timer> getScreenOffRpmStats() {
        return this.mScreenOffRpmStats;
    }

    public Map<String, ? extends Timer> getKernelWakelockStats() {
        return this.mKernelWakelockStats;
    }

    public WakeLockStats getWakeLockStats() {
        long realtimeMs = this.mClock.elapsedRealtime();
        List<WakeLockStats.WakeLock> uidWakeLockStats = new ArrayList();
        List<WakeLockStats.WakeLock> uidAggregatedWakeLockStats = new ArrayList();
        int i = this.mUidStats.size() - 1;
    L3:
        if (i < 0) goto L15;
        Uid uid = this.mUidStats.valueAt(i);
        ArrayMap<String, Uid.Wakelock> r10 = uid.mWakelockStats.getMap();
        int j = r10.size() - 1;
    L5:
        if (j < 0) goto L10;
        String name = r10.keyAt(j);
        Uid.Wakelock wakelock = r10.valueAt(j);
        WakeLockStats.WakeLock wakeLockItem = createWakeLock(uid, name, false, wakelock.mTimerPartial, realtimeMs);
        if (wakeLockItem == null) goto L9;
        uidWakeLockStats.add(wakeLockItem);
    L9:
        j = j - 1;
        goto L5
    L10:
        WakeLockStats.WakeLock aggregatedWakeLockItem = createWakeLock(uid, "wakelockstats_aggregated", true, uid.mAggregatedPartialWakelockTimer, realtimeMs);
        if (aggregatedWakeLockItem == null) goto L13;
        uidAggregatedWakeLockStats.add(aggregatedWakeLockItem);
    L13:
        i = i - 1;
        goto L3
    L15:
        return new WakeLockStats(uidWakeLockStats, uidAggregatedWakeLockStats);
    }

    private WakeLockStats.WakeLock createWakeLock(Uid uid, String name, boolean isAggregated, DualTimer timer, long realtimeMs) {
        if (timer != null) goto L5;
        return null;
    L5:
        WakeLockStats.WakeLockData totalWakeLockData = createWakeLockData(timer, realtimeMs);
        WakeLockStats.WakeLockData backgroundWakeLockData = createWakeLockData(timer.m7779getSubTimer(), realtimeMs);
        if (WakeLockStats.WakeLock.isDataValid(totalWakeLockData, backgroundWakeLockData) == false) goto L9;
        return new WakeLockStats.WakeLock(uid.getUid(), name, isAggregated, totalWakeLockData, backgroundWakeLockData);
    L9:
        return null;
    }

    private WakeLockStats.WakeLockData createWakeLockData(DurationTimer timer, long realtimeMs) {
        if (timer == null) goto L4;
        long totalTimeLockHeldMs = timer.getTotalTimeLocked(realtimeMs * 1000, 0) / 1000;
        long r0 = 0;
        if (totalTimeLockHeldMs == 0) goto L8;
        int r6 = timer.getCountLocked(0);
        if (timer.isRunningLocked() == false) goto L13;
        r0 = timer.getCurrentDurationMsLocked(realtimeMs);
    L13:
        return new WakeLockStats.WakeLockData(r6, totalTimeLockHeldMs, r0);
    L8:
        return WakeLockStats.WakeLockData.EMPTY;
    L4:
        return WakeLockStats.WakeLockData.EMPTY;
    }

    public BluetoothBatteryStats getBluetoothBatteryStats() {
        long elapsedRealtimeUs = this.mClock.elapsedRealtime() * 1000;
        ArrayList<BluetoothBatteryStats.UidStats> uidStats = new ArrayList();
        int i = this.mUidStats.size() - 1;
    L3:
        if (i < 0) goto L36;
        Uid uid = this.mUidStats.valueAt(i);
        Timer scanTimer = uid.m7821getBluetoothScanTimer();
        if (scanTimer == null) goto L7;
        long r12 = scanTimer.getTotalTimeLocked(elapsedRealtimeUs, 0) / 1000;
    L8:
        long scanTimeMs = r12;
        Timer unoptimizedScanTimer = uid.m7823getBluetoothUnoptimizedScanTimer();
        if (unoptimizedScanTimer == null) goto L11;
        long unoptimizedScanTimeMs = unoptimizedScanTimer.getTotalTimeLocked(elapsedRealtimeUs, 0) / 1000;
    L12:
        Counter scanResultCounter = uid.m7820getBluetoothScanResultCounter();
        if (scanResultCounter == null) goto L15;
        int scanResultCount = scanResultCounter.getCountLocked(0);
    L16:
        BatteryStats.ControllerActivityCounter counter = uid.m7817getBluetoothControllerActivity();
        if (counter == null) goto L19;
        long rxTimeMs = counter.getRxTimeCounter().getCountLocked(0);
    L21:
        if (counter == null) goto L23;
        long txTimeMs = counter.getTxTimeCounters()[0].getCountLocked(0);
    L25:
        if (scanTimeMs == 0) goto L27;
    L33:
        uidStats.add(new BluetoothBatteryStats.UidStats(uid.getUid(), scanTimeMs, unoptimizedScanTimeMs, scanResultCount, rxTimeMs, txTimeMs));
    L34:
        i = i - 1;
        goto L3
    L27:
        if (unoptimizedScanTimeMs != 0) goto L33;
        if (scanResultCount != 0) goto L33;
        if (rxTimeMs != 0) goto L33;
        if (txTimeMs == 0) goto L34;
    L23:
        txTimeMs = 0;
        goto L25
    L19:
        rxTimeMs = 0;
        goto L21
    L15:
        scanResultCount = 0;
        goto L16
    L11:
        unoptimizedScanTimeMs = 0;
        goto L12
    L7:
        r12 = 0;
        goto L8
    L36:
        return new BluetoothBatteryStats(uidStats);
    }

    public Map<String, ? extends Timer> getWakeupReasonStats() {
        return this.mWakeupReasonStats;
    }

    public long getUahDischarge(int which) {
        return this.mDischargeCounter.getCountLocked(which);
    }

    public long getUahDischargeScreenOff(int which) {
        return this.mDischargeScreenOffCounter.getCountLocked(which);
    }

    public long getUahDischargeScreenDoze(int which) {
        return this.mDischargeScreenDozeCounter.getCountLocked(which);
    }

    public long getUahDischargeLightDoze(int which) {
        return this.mDischargeLightDozeCounter.getCountLocked(which);
    }

    public long getUahDischargeDeepDoze(int which) {
        return this.mDischargeDeepDozeCounter.getCountLocked(which);
    }

    public int getEstimatedBatteryCapacity() {
        return this.mEstimatedBatteryCapacityMah;
    }

    public int getLearnedBatteryCapacity() {
        return this.mLastLearnedBatteryCapacityUah;
    }

    public int getMinLearnedBatteryCapacity() {
        return this.mMinLearnedBatteryCapacityUah;
    }

    public int getMaxLearnedBatteryCapacity() {
        return this.mMaxLearnedBatteryCapacityUah;
    }

    private void initKernelStatsReaders() {
        if (BatteryStats.isKernelStatsAvailable() == true) goto L5;
        return;
    L5:
        this.mCpuUidUserSysTimeReader = new KernelCpuUidTimeReader.KernelCpuUidUserSysTimeReader(true, this.mClock);
        this.mCpuUidFreqTimeReader = new KernelCpuUidTimeReader.KernelCpuUidFreqTimeReader(true, this.mClock);
        this.mCpuUidActiveTimeReader = new KernelCpuUidTimeReader.KernelCpuUidActiveTimeReader(true, this.mClock);
        this.mCpuUidClusterTimeReader = new KernelCpuUidTimeReader.KernelCpuUidClusterTimeReader(true, this.mClock);
        this.mKernelWakelockReader = new KernelWakelockReader();
        this.mKernelMemoryBandwidthStats = new KernelMemoryBandwidthStats();
        this.mTmpRailStats = new RailStats();
    }

    public SamplingTimer getRpmTimerLocked(String name) {
        SamplingTimer rpmt = this.mRpmStats.get(name);
        if (rpmt != null) goto L6;
        SamplingTimer rpmt2 = new SamplingTimer(this.mClock, this.mOnBatteryTimeBase);
        this.mRpmStats.put(name, rpmt2);
        return rpmt2;
    L6:
        return rpmt;
    }

    public SamplingTimer getScreenOffRpmTimerLocked(String name) {
        SamplingTimer rpmt = this.mScreenOffRpmStats.get(name);
        if (rpmt != null) goto L6;
        SamplingTimer rpmt2 = new SamplingTimer(this.mClock, this.mOnBatteryScreenOffTimeBase);
        this.mScreenOffRpmStats.put(name, rpmt2);
        return rpmt2;
    L6:
        return rpmt;
    }

    public SamplingTimer getWakeupReasonTimerLocked(String name) {
        SamplingTimer timer = this.mWakeupReasonStats.get(name);
        if (timer != null) goto L6;
        SamplingTimer timer2 = new SamplingTimer(this.mClock, this.mOnBatteryTimeBase);
        this.mWakeupReasonStats.put(name, timer2);
        return timer2;
    L6:
        return timer;
    }

    public SamplingTimer getKernelWakelockTimerLocked(String name) {
        SamplingTimer kwlt = this.mKernelWakelockStats.get(name);
        if (kwlt != null) goto L6;
        SamplingTimer kwlt2 = new SamplingTimer(this.mClock, this.mOnBatteryScreenOffTimeBase);
        this.mKernelWakelockStats.put(name, kwlt2);
        return kwlt2;
    L6:
        return kwlt;
    }

    public SamplingTimer getKernelMemoryTimerLocked(long bucket) {
        SamplingTimer kmt = this.mKernelMemoryStats.get(bucket);
        if (kmt != null) goto L6;
        SamplingTimer kmt2 = new SamplingTimer(this.mClock, this.mOnBatteryTimeBase);
        this.mKernelMemoryStats.put(bucket, kmt2);
        return kmt2;
    L6:
        return kmt;
    }

    public void commitCurrentHistoryBatchLocked() {
        this.mHistory.commitCurrentHistoryBatchLocked();
    }

    public void createFakeHistoryEvents(long numEvents) {
        long elapsedRealtimeMs = this.mClock.elapsedRealtime();
        long uptimeMs = this.mClock.uptimeMillis();
        long i = 0;
    L4:
        if (i >= numEvents) goto L7;
        noteLongPartialWakelockStart("name1", "historyName1", 1000, elapsedRealtimeMs, uptimeMs);
        noteLongPartialWakelockFinish("name1", "historyName1", 1000, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L4
    }

    public void recordHistoryEventLocked(long elapsedRealtimeMs, long uptimeMs, int code, String name, int uid) {
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, code, name, uid);
    }

    public void updateTimeBasesLocked(boolean unplugged, int screenState, long uptimeUs, long realtimeUs) {
        boolean screenOff = !Display.isOnState(screenState);
        if (unplugged == this.mOnBatteryTimeBase.isRunning()) goto L5;
        boolean r0 = true;
    L6:
        boolean updateOnBatteryTimeBase = r0;
        if (unplugged == false) goto L10;
        if (screenOff == false) goto L10;
        boolean r1 = true;
    L12:
        if (r1 == this.mOnBatteryScreenOffTimeBase.isRunning()) goto L14;
        boolean r2 = true;
    L15:
        boolean updateOnBatteryScreenOffTimeBase = r2;
        if (updateOnBatteryScreenOffTimeBase == true) goto L18;
        if (updateOnBatteryTimeBase == true) goto L18;
        return;
    L18:
        if (updateOnBatteryScreenOffTimeBase == false) goto L20;
        updateKernelWakelocksLocked(realtimeUs);
        updateBatteryPropertiesLocked();
    L20:
        if (updateOnBatteryTimeBase == false) goto L22;
        updateRpmStatsLocked(realtimeUs);
    L22:
        this.mOnBatteryTimeBase.setRunning(unplugged, uptimeUs, realtimeUs);
        if (updateOnBatteryTimeBase == false) goto L27;
        int i = this.mUidStats.size() - 1;
    L25:
        if (i < 0) goto L27;
        this.mUidStats.valueAt(i).updateOnBatteryBgTimeBase(uptimeUs, realtimeUs);
        i = i - 1;
    L27:
        if (updateOnBatteryScreenOffTimeBase == false) goto L39;
        TimeBase r3 = this.mOnBatteryScreenOffTimeBase;
        if (unplugged == false) goto L32;
        if (screenOff == false) goto L32;
        boolean r4 = true;
    L33:
        r3.setRunning(r4, uptimeUs, realtimeUs);
        int i2 = this.mUidStats.size() - 1;
    L34:
        if (i2 < 0) goto L40;
        this.mUidStats.valueAt(i2).updateOnBatteryScreenOffBgTimeBase(uptimeUs, realtimeUs);
        i2 = i2 - 1;
        goto L34
    L40:
        return;
    L32:
        r4 = false;
        goto L33
    L39:
        return;
    L14:
        r2 = false;
    L10:
        r1 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    protected void updateBatteryPropertiesLocked() {
        IBatteryPropertiesRegistrar registrar = IBatteryPropertiesRegistrar.Stub.asInterface(ServiceManager.getService("batteryproperties"));     // Catch: RemoteException -> L6
        if (registrar == null) goto L12;
        registrar.scheduleUpdate();     // Catch: RemoteException -> L6
        return;
    L12:
        return;
    }

    private void onIsolatedUidAdded(int isolatedUid, int parentUid) {
        long realtime = this.mClock.elapsedRealtime();
        long uptime = this.mClock.uptimeMillis();
        monitor-enter(this);
        getUidStatsLocked(parentUid, realtime, uptime).addIsolatedUid(isolatedUid);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void onBeforeIsolatedUidRemoved(int isolatedUid, int parentUid) {
        long realtime = this.mClock.elapsedRealtime();
        this.mPowerStatsUidResolver.retainIsolatedUid(isolatedUid);
        monitor-enter(this);
        this.mPendingRemovedUids.add(new UidToRemove(this, isolatedUid, realtime));     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (this.mExternalSync == null) goto L15;
        this.mExternalSync.scheduleCpuSyncDueToRemovedUid(isolatedUid);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onAfterIsolatedUidRemoved(int isolatedUid, int parentUid) {
        long realtime = this.mClock.elapsedRealtime();
        long uptime = this.mClock.uptimeMillis();
        monitor-enter(this);
        getUidStatsLocked(parentUid, realtime, uptime).removeIsolatedUid(isolatedUid);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void releaseIsolatedUidLocked(int isolatedUid, long elapsedRealtimeMs, long uptimeMs) {
        this.mPowerStatsUidResolver.releaseIsolatedUid(isolatedUid);
    }

    private int mapUid(int uid) {
        if (Process.isSdkSandboxUid(uid) == false) goto L7;
        return Process.getAppUidForSdkSandboxUid(uid);
    L7:
        return this.mPowerStatsUidResolver.mapUid(uid);
    }

    private int mapIsolatedUid(int uid) {
        return this.mPowerStatsUidResolver.mapUid(uid);
    }

    public void noteEventLocked(int code, String name, int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        if (this.mActiveEvents.updateState(code, name, uid2, 0) == true) goto L5;
        return;
    L5:
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, code, name, uid2);
    }

    public void noteCurrentTimeChangedLocked(long currentTimeMs, long elapsedRealtimeMs, long uptimeMs) {
        this.mHistory.recordCurrentTimeChange(elapsedRealtimeMs, uptimeMs, currentTimeMs);
        adjustStartClockTime(currentTimeMs);
    }

    private void adjustStartClockTime(long currentTimeMs) {
        this.mStartClockTimeMs = currentTimeMs - (this.mClock.elapsedRealtime() - (this.mRealtimeStartUs / 1000));
    }

    public void noteProcessStartLocked(String name, int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        if (isOnBattery() == false) goto L5;
        Uid u = getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs);
        BatteryStatsImpl r11 = this;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        long uptimeMs2 = uptimeMs;
        u.getProcessStatsLocked(name).incStartsLocked();
    L7:
        if (r11.mActiveEvents.updateState(32769, name, uid2, 0) == true) goto L10;
        return;
    L10:
        if (r11.mRecordAllHistory == true) goto L12;
        return;
    L12:
        r11.mHistory.recordEvent(elapsedRealtimeMs2, uptimeMs2, 32769, name, uid2);
        return;
    L5:
        uptimeMs2 = uptimeMs;
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        r11 = this;
        goto L7
    }

    public void noteProcessCrashLocked(String name, int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        if (isOnBattery() == false) goto L6;
        Uid u = getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs);
        u.getProcessStatsLocked(name).incNumCrashesLocked();
        return;
    }

    public void noteProcessAnrLocked(String name, int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        if (isOnBattery() == false) goto L6;
        Uid u = getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs);
        u.getProcessStatsLocked(name).incNumAnrsLocked();
        return;
    }

    public void noteUidProcessStateLocked(int uid, int state) {
        noteUidProcessStateLocked(uid, state, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteUidProcessStateLocked(int uid, int state, long elapsedRealtimeMs, long uptimeMs) {
        int parentUid = mapUid(uid);
        if (uid != parentUid) goto L5;
    L7:
        this.mFrameworkStatsLogger.uidProcessStateChanged(uid, state);
        getUidStatsLocked(parentUid, elapsedRealtimeMs, uptimeMs).updateUidProcessStateLocked(state, elapsedRealtimeMs, uptimeMs);
        return;
    L5:
        if (Process.isIsolated(uid) == false) goto L7;
    }

    public void noteProcessFinishLocked(String name, int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        if (this.mActiveEvents.updateState(16385, name, uid2, 0) == true) goto L6;
        return;
    L6:
        if (this.mRecordAllHistory == true) goto L8;
        return;
    L8:
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 16385, name, uid2);
    }

    public void noteSyncStartLocked(String name, int uid) {
        noteSyncStartLocked(name, uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteSyncStartLocked(String name, int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).noteStartSyncLocked(name, elapsedRealtimeMs);
        if (this.mActiveEvents.updateState(32772, name, uid2, 0) == true) goto L5;
        return;
    L5:
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 32772, name, uid2);
    }

    public void noteSyncFinishLocked(String name, int uid) {
        noteSyncFinishLocked(name, uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteSyncFinishLocked(String name, int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).noteStopSyncLocked(name, elapsedRealtimeMs);
        if (this.mActiveEvents.updateState(16388, name, uid2, 0) == true) goto L5;
        return;
    L5:
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 16388, name, uid2);
    }

    public void noteJobStartLocked(String name, int uid) {
        noteJobStartLocked(name, uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteJobStartLocked(String name, int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).noteStartJobLocked(name, elapsedRealtimeMs);
        if (this.mActiveEvents.updateState(32774, name, uid2, 0) == true) goto L5;
        return;
    L5:
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 32774, name, uid2);
    }

    public void noteJobFinishLocked(String name, int uid, int stopReason) {
        noteJobFinishLocked(name, uid, stopReason, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteJobFinishLocked(String name, int uid, int stopReason, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).noteStopJobLocked(name, elapsedRealtimeMs, stopReason);
        if (this.mActiveEvents.updateState(16390, name, uid2, 0) == true) goto L5;
        return;
    L5:
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 16390, name, uid2);
    }

    public void noteJobsDeferredLocked(int uid, int numDeferred, long sinceLast, long elapsedRealtimeMs, long uptimeMs) {
        getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs).noteJobsDeferredLocked(numDeferred, sinceLast);
    }

    public void noteAlarmStartLocked(String name, WorkSource workSource, int uid) {
        noteAlarmStartLocked(name, workSource, uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteAlarmStartLocked(String name, WorkSource workSource, int uid, long elapsedRealtimeMs, long uptimeMs) {
        noteAlarmStartOrFinishLocked(32781, name, workSource, uid, elapsedRealtimeMs, uptimeMs);
    }

    public void noteAlarmFinishLocked(String name, WorkSource workSource, int uid) {
        noteAlarmFinishLocked(name, workSource, uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteAlarmFinishLocked(String name, WorkSource workSource, int uid, long elapsedRealtimeMs, long uptimeMs) {
        noteAlarmStartOrFinishLocked(16397, name, workSource, uid, elapsedRealtimeMs, uptimeMs);
    }

    private void noteAlarmStartOrFinishLocked(int historyItem, String name, WorkSource workSource, int uid, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mRecordAllHistory == true) goto L6;
        return;
    L6:
        if (workSource == null) goto L24;
        int i = 0;
    L9:
        if (i >= workSource.size()) goto L14;
        int uid2 = mapUid(workSource.getUid(i));
        if (this.mActiveEvents.updateState(historyItem, name, uid2, 0) == false) goto L13;
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, historyItem, name, uid2);
    L13:
        i = i + 1;
        goto L9
    L14:
        List<WorkSource.WorkChain> workChains = workSource.getWorkChains();
        if (workChains == null) goto L35;
        int i2 = 0;
    L18:
        if (i2 >= workChains.size()) goto L36;
        int uid3 = mapUid(workChains.get(i2).getAttributionUid());
        if (this.mActiveEvents.updateState(historyItem, name, uid3, 0) == false) goto L22;
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, historyItem, name, uid3);
    L22:
        i2 = i2 + 1;
        goto L18
    L36:
        return;
    L35:
        return;
    L24:
        int uid4 = mapUid(uid);
        if (this.mActiveEvents.updateState(historyItem, name, uid4, 0) == false) goto L28;
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, historyItem, name, uid4);
    }

    public void noteWakupAlarmLocked(String packageName, int uid, WorkSource workSource, String tag) {
        noteWakupAlarmLocked(packageName, uid, workSource, tag, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteWakupAlarmLocked(String packageName, int uid, WorkSource workSource, String tag, long elapsedRealtimeMs, long uptimeMs) {
        if (workSource == null) goto L25;
        int i = 0;
    L6:
        if (i >= workSource.size()) goto L14;
        int uid2 = workSource.getUid(i);
        String workSourceName = workSource.getPackageName(i);
        if (isOnBattery() == false) goto L13;
        if (workSourceName == null) goto L11;
        String r7 = workSourceName;
    L12:
        Uid.Pkg pkg = getPackageStatsLocked(uid2, r7, elapsedRealtimeMs, uptimeMs);
        pkg.noteWakeupAlarmLocked(tag);
        goto L13
    L11:
        r7 = packageName;
    L13:
        i = i + 1;
        goto L6
    L14:
        List<WorkSource.WorkChain> workChains = workSource.getWorkChains();
        if (workChains == null) goto L35;
        int i2 = 0;
    L18:
        if (i2 >= workChains.size()) goto L36;
        WorkSource.WorkChain wc = workChains.get(i2);
        int uid3 = wc.getAttributionUid();
        if (isOnBattery() == false) goto L22;
        Uid.Pkg pkg2 = getPackageStatsLocked(uid3, packageName, elapsedRealtimeMs, uptimeMs);
        pkg2.noteWakeupAlarmLocked(tag);
    L22:
        i2 = i2 + 1;
        goto L18
    L36:
        return;
    L35:
        return;
    L25:
        if (isOnBattery() == false) goto L28;
        Uid.Pkg pkg3 = getPackageStatsLocked(uid, packageName, elapsedRealtimeMs, uptimeMs);
        pkg3.noteWakeupAlarmLocked(tag);
    }

    private void requestWakelockCpuUpdate() {
        this.mExternalSync.scheduleCpuSyncDueToWakelockChange(60000);
    }

    private void requestImmediateCpuUpdate() {
        this.mExternalSync.scheduleCpuSyncDueToWakelockChange(0);
    }

    public void setRecordAllHistoryLocked(boolean enabled) {
        this.mRecordAllHistory = enabled;
        if (enabled == true) goto L15;
        this.mActiveEvents.removeEvents(5);
        this.mActiveEvents.removeEvents(13);
        HashMap<String, SparseIntArray> active = this.mActiveEvents.getStateForEvent(1);
        if (active == null) goto L30;
        long mSecRealtime = this.mClock.elapsedRealtime();
        long mSecUptime = this.mClock.uptimeMillis();
        Iterator<Map.Entry<String, SparseIntArray>> r1 = active.entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L31;
        Map.Entry<String, SparseIntArray> ent = r1.next();
        SparseIntArray uids = ent.getValue();
        int j = 0;
    L11:
        if (j >= uids.size()) goto L8;
        this.mHistory.recordEvent(mSecRealtime, mSecUptime, 16385, ent.getKey(), uids.keyAt(j));
        j = j + 1;
        goto L11
    L31:
        return;
    L30:
        return;
    L15:
        HashMap<String, SparseIntArray> active2 = this.mActiveEvents.getStateForEvent(1);
        if (active2 == null) goto L25;
        long mSecRealtime2 = this.mClock.elapsedRealtime();
        long mSecUptime2 = this.mClock.uptimeMillis();
        Iterator<Map.Entry<String, SparseIntArray>> r2 = active2.entrySet().iterator();
    L19:
        if (r2.hasNext() == false) goto L32;
        Map.Entry<String, SparseIntArray> ent2 = r2.next();
        SparseIntArray uids2 = ent2.getValue();
        int j2 = 0;
    L22:
        if (j2 >= uids2.size()) goto L19;
        this.mHistory.recordEvent(mSecRealtime2, mSecUptime2, 32769, ent2.getKey(), uids2.keyAt(j2));
        j2 = j2 + 1;
        goto L22
    L32:
        return;
    }

    public void setNoAutoReset(boolean enabled) {
        this.mNoAutoReset = enabled;
    }

    public void setPretendScreenOff(boolean pretendScreenOff) {
        if (this.mPretendScreenOff == pretendScreenOff) goto L6;
        this.mPretendScreenOff = pretendScreenOff;
        int primaryScreenState = this.mPerDisplayBatteryStats[0].screenState;
        noteScreenStateLocked(0, primaryScreenState);
        return;
    }

    public void noteStartWakeLocked(int uid, int pid, WorkSource.WorkChain wc, String name, String historyName, int type, boolean unimportantForLogging) {
        noteStartWakeLocked(uid, pid, wc, name, historyName, type, unimportantForLogging, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteStartWakeLocked(int uid, int pid, WorkSource.WorkChain wc, String name, String historyName, int type, boolean unimportantForLogging, long elapsedRealtimeMs, long uptimeMs) {
        int mappedUid = mapUid(uid);
        if (type != 0) goto L23;
        if (historyName != null) goto L6;
        String historyName2 = name;
    L8:
        if (this.mRecordAllHistory == false) goto L13;
        if (this.mActiveEvents.updateState(32773, historyName2, mappedUid, 0) == false) goto L13;
        String historyName3 = historyName2;
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 32773, historyName3, mappedUid);
        historyName2 = historyName3;
        mappedUid = mappedUid;
    L13:
        if (this.mWakeLockNesting != 0) goto L16;
        this.mWakeLockImportant = !unimportantForLogging;
        this.mHistory.recordWakelockStartEvent(elapsedRealtimeMs, uptimeMs, historyName2, mappedUid);
    L21:
        this.mWakeLockNesting++;
        goto L23
    L16:
        if (this.mWakeLockImportant == true) goto L21;
        if (unimportantForLogging == true) goto L21;
        if (this.mHistory.maybeUpdateWakelockTag(elapsedRealtimeMs, uptimeMs, historyName2, mappedUid) == false) goto L21;
        this.mWakeLockImportant = true;
        goto L21
    L6:
        historyName2 = historyName;
    L23:
        if (mappedUid < 0) goto L36;
        if (mappedUid == uid) goto L27;
        this.mPowerStatsUidResolver.retainIsolatedUid(uid);
    L27:
        if (this.mOnBatteryScreenOffTimeBase.isRunning() == false) goto L29;
        requestWakelockCpuUpdate();
    L29:
        Uid uidStats = getUidStatsLocked(mappedUid, elapsedRealtimeMs, uptimeMs);
        uidStats.noteStartWakeLocked(pid, name, type, elapsedRealtimeMs);
        if (this.mMoveWscLoggingToNotifierEnabled == true) goto L33;
        this.mFrameworkStatsLogger.wakelockStateChanged(mapIsolatedUid(uid), wc, name, uidStats.mProcessState, true, getPowerManagerWakeLockLevel(type));
    L33:
        if (this.mPowerManagerFlags.isFrameworkWakelockInfoEnabled() == false) goto L37;
        this.mFrameworkEvents.noteStartWakeLock(mapIsolatedUid(uid), name, getPowerManagerWakeLockLevel(type), uptimeMs);
        return;
    L37:
        return;
    }

    public void noteStopWakeLocked(int uid, int pid, WorkSource.WorkChain wc, String name, String historyName, int type) {
        noteStopWakeLocked(uid, pid, wc, name, historyName, type, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteStopWakeLocked(int uid, int pid, WorkSource.WorkChain wc, String name, String historyName, int type, long elapsedRealtimeMs, long uptimeMs) {
        int mappedUid = mapUid(uid);
        if (type != 0) goto L18;
        this.mWakeLockNesting--;
        if (historyName != null) goto L7;
        String historyName2 = name;
    L9:
        if (this.mRecordAllHistory == true) goto L11;
        int mappedUid2 = mappedUid;
        String historyName3 = historyName2;
    L16:
        if (this.mWakeLockNesting != 0) goto L19;
        this.mHistory.recordWakelockStopEvent(elapsedRealtimeMs, uptimeMs, historyName3, mappedUid2);
    L19:
        if (mappedUid2 < 0) goto L32;
        if (this.mOnBatteryScreenOffTimeBase.isRunning() == false) goto L23;
        requestWakelockCpuUpdate();
    L23:
        int mappedUid3 = mappedUid2;
        Uid uidStats = getUidStatsLocked(mappedUid3, elapsedRealtimeMs, uptimeMs);
        uidStats.noteStopWakeLocked(pid, name, type, elapsedRealtimeMs);
        if (this.mMoveWscLoggingToNotifierEnabled == true) goto L27;
        this.mFrameworkStatsLogger.wakelockStateChanged(mapIsolatedUid(uid), wc, name, uidStats.mProcessState, false, getPowerManagerWakeLockLevel(type));
    L27:
        if (this.mPowerManagerFlags.isFrameworkWakelockInfoEnabled() == false) goto L29;
        this.mFrameworkEvents.noteStopWakeLock(mapIsolatedUid(uid), name, getPowerManagerWakeLockLevel(type), uptimeMs);
    L29:
        if (mappedUid3 == uid) goto L33;
        releaseIsolatedUidLocked(uid, elapsedRealtimeMs, uptimeMs);
        return;
    L33:
        return;
    L32:
        return;
    L11:
        if (this.mActiveEvents.updateState(16389, historyName2, mappedUid, 0) == false) goto L13;
        mappedUid2 = mappedUid;
        historyName3 = historyName2;
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 16389, historyName3, mappedUid2);
        goto L16
    L13:
        mappedUid2 = mappedUid;
        historyName3 = historyName2;
        goto L16
    L7:
        historyName2 = historyName;
        goto L9
    L18:
        mappedUid2 = mappedUid;
        goto L19
    }

    private int getPowerManagerWakeLockLevel(int batteryStatsWakelockType) {
        switch(batteryStatsWakelockType) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 18: goto L6;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "Illegal wakelock type in batterystats: " + batteryStatsWakelockType);
        return -1;
    L6:
        return 128;
    L8:
        Slog.e(TAG, "Illegal window wakelock type observed in batterystats.");
        return -1;
    L10:
        return 26;
    L12:
        return 1;
    }

    public void noteStartWakeFromSourceLocked(WorkSource ws, int pid, String name, String historyName, int type, boolean unimportantForLogging, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        noteStartWakeLocked(ws.getUid(i), pid, null, name, historyName, type, unimportantForLogging, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> wcs = ws.getWorkChains();
        if (wcs == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= wcs.size()) goto L14;
        WorkSource.WorkChain wc = wcs.get(i2);
        noteStartWakeLocked(wc.getAttributionUid(), pid, wc, name, historyName, type, unimportantForLogging, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    public void noteChangeWakelockFromSourceLocked(WorkSource ws, int pid, String name, String historyName, int type, WorkSource newWs, int newPid, String newName, String newHistoryName, int newType, boolean newUnimportantForLogging, long elapsedRealtimeMs, long uptimeMs) {
        List<WorkSource.WorkChain>[] wcs = WorkSource.diffChains(ws, newWs);
        int NN = newWs.size();
        int i = 0;
    L3:
        if (i >= NN) goto L6;
        noteStartWakeLocked(newWs.getUid(i), newPid, null, newName, newHistoryName, newType, newUnimportantForLogging, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L6:
        if (wcs == null) goto L13;
        List<WorkSource.WorkChain> newChains = wcs[0];
        if (newChains == null) goto L13;
        int i2 = 0;
    L11:
        if (i2 >= newChains.size()) goto L13;
        WorkSource.WorkChain newChain = newChains.get(i2);
        noteStartWakeLocked(newChain.getAttributionUid(), newPid, newChain, newName, newHistoryName, newType, newUnimportantForLogging, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
    L13:
        int NO = ws.size();
        int i3 = 0;
    L14:
        if (i3 >= NO) goto L17;
        noteStopWakeLocked(ws.getUid(i3), pid, null, name, historyName, type, elapsedRealtimeMs, uptimeMs);
        i3 = i3 + 1;
        goto L14
    L17:
        if (wcs == null) goto L24;
        List<WorkSource.WorkChain> goneChains = wcs[1];
        if (goneChains == null) goto L29;
        int i4 = 0;
    L22:
        if (i4 >= goneChains.size()) goto L30;
        WorkSource.WorkChain goneChain = goneChains.get(i4);
        noteStopWakeLocked(goneChain.getAttributionUid(), pid, goneChain, name, historyName, type, elapsedRealtimeMs, uptimeMs);
        i4 = i4 + 1;
        goto L22
    L30:
        return;
    L29:
        return;
    }

    public void noteStopWakeFromSourceLocked(WorkSource ws, int pid, String name, String historyName, int type, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        noteStopWakeLocked(ws.getUid(i), pid, null, name, historyName, type, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> wcs = ws.getWorkChains();
        if (wcs == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= wcs.size()) goto L14;
        WorkSource.WorkChain wc = wcs.get(i2);
        noteStopWakeLocked(wc.getAttributionUid(), pid, wc, name, historyName, type, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    public void noteLongPartialWakelockStart(String name, String historyName, int uid) {
        noteLongPartialWakelockStart(name, historyName, uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteLongPartialWakelockStart(String name, String historyName, int uid, long elapsedRealtimeMs, long uptimeMs) {
        noteLongPartialWakeLockStartInternal(name, historyName, uid, elapsedRealtimeMs, uptimeMs);
    }

    public void noteLongPartialWakelockStartFromSource(String name, String historyName, WorkSource workSource, long elapsedRealtimeMs, long uptimeMs) {
        int N = workSource.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        int uid = mapUid(workSource.getUid(i));
        noteLongPartialWakeLockStartInternal(name, historyName, uid, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> workChains = workSource.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        WorkSource.WorkChain workChain = workChains.get(i2);
        int uid2 = workChain.getAttributionUid();
        noteLongPartialWakeLockStartInternal(name, historyName, uid2, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    private void noteLongPartialWakeLockStartInternal(String name, String historyName, int uid, long elapsedRealtimeMs, long uptimeMs) {
        int mappedUid = mapUid(uid);
        if (historyName != null) goto L5;
        String historyName2 = name;
    L7:
        if (this.mActiveEvents.updateState(32788, historyName2, mappedUid, 0) == true) goto L9;
        return;
    L9:
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 32788, historyName2, mappedUid);
        if (mappedUid == uid) goto L13;
        this.mPowerStatsUidResolver.retainIsolatedUid(uid);
        return;
    L13:
        return;
    L5:
        historyName2 = historyName;
        goto L7
    }

    public void noteLongPartialWakelockFinish(String name, String historyName, int uid) {
        noteLongPartialWakelockFinish(name, historyName, uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteLongPartialWakelockFinish(String name, String historyName, int uid, long elapsedRealtimeMs, long uptimeMs) {
        noteLongPartialWakeLockFinishInternal(name, historyName, uid, elapsedRealtimeMs, uptimeMs);
    }

    public void noteLongPartialWakelockFinishFromSource(String name, String historyName, WorkSource workSource, long elapsedRealtimeMs, long uptimeMs) {
        int N = workSource.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        int uid = mapUid(workSource.getUid(i));
        noteLongPartialWakeLockFinishInternal(name, historyName, uid, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> workChains = workSource.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        WorkSource.WorkChain workChain = workChains.get(i2);
        int uid2 = workChain.getAttributionUid();
        noteLongPartialWakeLockFinishInternal(name, historyName, uid2, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    private void noteLongPartialWakeLockFinishInternal(String name, String historyName, int uid, long elapsedRealtimeMs, long uptimeMs) {
        int mappedUid = mapUid(uid);
        if (historyName != null) goto L5;
        String historyName2 = name;
    L7:
        if (this.mActiveEvents.updateState(16404, historyName2, mappedUid, 0) == true) goto L9;
        return;
    L9:
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 16404, historyName2, mappedUid);
        if (mappedUid == uid) goto L13;
        releaseIsolatedUidLocked(uid, elapsedRealtimeMs, uptimeMs);
        return;
    L13:
        return;
    L5:
        historyName2 = historyName;
        goto L7
    }

    public void noteWakeupReasonLocked(String reason, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mLastWakeupReason == null) goto L5;
        long deltaUptimeMs = uptimeMs - this.mLastWakeupUptimeMs;
        SamplingTimer timer = getWakeupReasonTimerLocked(this.mLastWakeupReason);
        timer.add(deltaUptimeMs * 1000, 1, elapsedRealtimeMs);
        this.mFrameworkStatsLogger.kernelWakeupReported(deltaUptimeMs * 1000, this.mLastWakeupReason, this.mLastWakeupElapsedTimeMs);
    L5:
        this.mHistory.recordWakeupEvent(elapsedRealtimeMs, uptimeMs, reason);
        this.mLastWakeupReason = reason;
        this.mLastWakeupUptimeMs = uptimeMs;
        this.mLastWakeupElapsedTimeMs = elapsedRealtimeMs;
    }

    public boolean startAddingCpuStatsLocked() {
        this.mExternalSync.cancelCpuSyncDueToWakelockChange();
        return this.mOnBatteryInternal;
    }

    public void addCpuStatsLocked(int totalUTimeMs, int totalSTimeMs, int statUserTimeMs, int statSystemTimeMs, int statIOWaitTimeMs, int statIrqTimeMs, int statSoftIrqTimeMs, int statIdleTimeMs) {
        this.mStepDetailsProvider.addCpuStats(totalUTimeMs, totalSTimeMs, statUserTimeMs, statSystemTimeMs, statIOWaitTimeMs, statIrqTimeMs, statSoftIrqTimeMs, statIdleTimeMs);
    }

    public void finishAddingCpuStatsLocked() {
        this.mStepDetailsProvider.finishAddingCpuLocked();
    }

    public void noteProcessDiedLocked(int uid, int pid) {
        int uid2 = mapUid(uid);
        Uid u = this.mUidStats.get(uid2);
        if (u == null) goto L6;
        u.mPids.remove(pid);
        return;
    }

    public void reportExcessiveCpuLocked(int uid, String proc, long overTimeMs, long usedTimeMs) {
        int uid2 = mapUid(uid);
        Uid u = this.mUidStats.get(uid2);
        if (u == null) goto L6;
        u.reportExcessiveCpuLocked(proc, overTimeMs, usedTimeMs);
        return;
    }

    public void noteStartSensorLocked(int uid, int sensor) {
        noteStartSensorLocked(uid, sensor, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteStartSensorLocked(int uid, int sensor, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        this.mHistory.recordStateStartEvent(elapsedRealtimeMs, uptimeMs, 8388608, uid2, "sensor:0x" + Integer.toHexString(sensor));
        getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).noteStartSensor(sensor, elapsedRealtimeMs);
    }

    public void noteStopSensorLocked(int uid, int sensor) {
        noteStopSensorLocked(uid, sensor, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteStopSensorLocked(int uid, int sensor, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        this.mHistory.recordStateStopEvent(elapsedRealtimeMs, uptimeMs, 8388608, uid2, "sensor:0x" + Integer.toHexString(sensor));
        getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).noteStopSensor(sensor, elapsedRealtimeMs);
    }

    public void noteGpsChangedLocked(WorkSource oldWs, WorkSource newWs) {
        noteGpsChangedLocked(oldWs, newWs, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteGpsChangedLocked(WorkSource oldWs, WorkSource newWs, long elapsedRealtimeMs, long uptimeMs) {
        int i = 0;
    L4:
        if (i >= newWs.size()) goto L6;
        noteStartGpsLocked(newWs.getUid(i), null, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= oldWs.size()) goto L10;
        noteStopGpsLocked(oldWs.getUid(i2), null, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L8
    L10:
        List<WorkSource.WorkChain>[] wcs = WorkSource.diffChains(oldWs, newWs);
        if (wcs != null) goto L13;
        return;
    L13:
        if (wcs[0] == null) goto L19;
        List<WorkSource.WorkChain> newChains = wcs[0];
        int i3 = 0;
    L16:
        if (i3 >= newChains.size()) goto L19;
        noteStartGpsLocked(-1, newChains.get(i3), elapsedRealtimeMs, uptimeMs);
        i3 = i3 + 1;
    L19:
        if (wcs[1] == null) goto L29;
        List<WorkSource.WorkChain> goneChains = wcs[1];
        int i4 = 0;
    L22:
        if (i4 >= goneChains.size()) goto L30;
        noteStopGpsLocked(-1, goneChains.get(i4), elapsedRealtimeMs, uptimeMs);
        i4 = i4 + 1;
        goto L22
    L30:
        return;
    }

    private void noteStartGpsLocked(int uid, WorkSource.WorkChain workChain, long elapsedRealtimeMs, long uptimeMs) {
        if (workChain == null) goto L4;
        int uid2 = workChain.getAttributionUid();
        int uid3 = uid2;
    L5:
        int mappedUid = mapUid(uid3);
        if (this.mGpsNesting != 0) goto L10;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        long uptimeMs2 = uptimeMs;
        this.mHistory.recordStateStartEvent(elapsedRealtimeMs2, uptimeMs2, 536870912, uid3, LocationLogsRecorder.KEY_FILE_GNSS);
        if (this.mPowerStatsCollectorEnabled.get(10) == false) goto L11;
        this.mGnssPowerStatsCollector.schedule();
    L11:
        this.mGpsNesting++;
        this.mFrameworkStatsLogger.gpsScanStateChanged(mapIsolatedUid(uid3), workChain, true);
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        getUidStatsLocked(mappedUid, elapsedRealtimeMs3, uptimeMs2).noteStartGps(elapsedRealtimeMs3);
        InfoData data = new InfoData();
        data.putExtra("uid", mappedUid);
        data.putExtra("hold", true);
        AppRecordManager.reportDataInfo(FrameworkStatsLog.CPU_ACTIVE_TIME, data);
        return;
    L10:
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        uptimeMs2 = uptimeMs;
        goto L11
    L4:
        uid3 = uid;
        goto L5
    }

    private void noteStopGpsLocked(int uid, WorkSource.WorkChain workChain, long elapsedRealtimeMs, long uptimeMs) {
        if (workChain == null) goto L4;
        int uid2 = workChain.getAttributionUid();
    L5:
        int mappedUid = mapUid(uid2);
        this.mGpsNesting--;
        if (this.mGpsNesting != 0) goto L10;
        this.mHistory.recordStateStopEvent(elapsedRealtimeMs, uptimeMs, 536870912, uid2, LocationLogsRecorder.KEY_FILE_GNSS);
        this.mHistory.recordGpsSignalQualityEvent(elapsedRealtimeMs, uptimeMs, 2);
        stopAllGpsSignalQualityTimersLocked(-1, elapsedRealtimeMs);
        this.mGpsSignalQualityBin = -1;
        if (this.mPowerStatsCollectorEnabled.get(10) == false) goto L10;
        this.mGnssPowerStatsCollector.schedule();
    L10:
        this.mFrameworkStatsLogger.gpsScanStateChanged(mapIsolatedUid(uid2), workChain, false);
        getUidStatsLocked(mappedUid, elapsedRealtimeMs, uptimeMs).noteStopGps(elapsedRealtimeMs);
        InfoData data = new InfoData();
        data.putExtra("uid", mappedUid);
        data.putExtra("hold", false);
        AppRecordManager.reportDataInfo(FrameworkStatsLog.CPU_ACTIVE_TIME, data);
        return;
    L4:
        uid2 = uid;
        goto L5
    }

    public void noteGpsSignalQualityLocked(int signalLevel, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mGpsNesting != 0) goto L5;
        return;
    L5:
        if (signalLevel < 0) goto L21;
        if (signalLevel >= this.mGpsSignalQualityTimer.length) goto L21;
        if (this.mGpsSignalQualityBin == signalLevel) goto L19;
        if (this.mGpsSignalQualityBin < 0) goto L15;
        this.mGpsSignalQualityTimer[this.mGpsSignalQualityBin].stopRunningLocked(elapsedRealtimeMs);
    L15:
        if (this.mGpsSignalQualityTimer[signalLevel].isRunningLocked() == true) goto L17;
        this.mGpsSignalQualityTimer[signalLevel].startRunningLocked(elapsedRealtimeMs);
    L17:
        this.mHistory.recordGpsSignalQualityEvent(elapsedRealtimeMs, uptimeMs, signalLevel);
        this.mGpsSignalQualityBin = signalLevel;
        return;
    L19:
        return;
    L21:
        stopAllGpsSignalQualityTimersLocked(-1, elapsedRealtimeMs);
    }

    private static String getScreenStateTag(int display, int state, int reason) {
        return String.format("display=%d state=%s reason=%s", new Object[]{Integer.valueOf(display), Display.stateToString(state), Display.stateReasonToString(reason)});
    }

    public void noteScreenStateLocked(int display, int state) {
        noteScreenStateLocked(display, state, 0, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis(), this.mClock.currentTimeMillis());
    }

    public void noteScreenStateLocked(int display, int displayState, int displayStateReason, long elapsedRealtimeMs, long uptimeMs, long currentTimeMs) {
        BatteryStatsImpl r0 = this;
        r0.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 22, getScreenStateTag(display, displayState, displayStateReason), -1);
        if (displayState > 4) goto L5;
        int displayState2 = displayState;
    L18:
        int overallBin = r0.mScreenBrightnessBin;
        int externalUpdateFlag = 0;
        boolean shouldScheduleSync = false;
        int numDisplay = r0.mPerDisplayBatteryStats.length;
        if (display < 0) goto L148;
        if (display >= numDisplay) goto L148;
        DisplayBatteryStats displayStats = r0.mPerDisplayBatteryStats[display];
        int oldDisplayState = displayStats.screenState;
        if (oldDisplayState != displayState2) goto L25;
        int state = r0.mScreenState;
        int overallBin2 = overallBin;
        int state2 = 0;
        boolean shouldScheduleSync2 = false;
    L84:
        boolean batteryRunning = r0.mOnBatteryTimeBase.isRunning();
        boolean batteryScreenOffRunning = r0.mOnBatteryScreenOffTimeBase.isRunning();
        if (r0.mPretendScreenOff == false) goto L87;
        int r23 = 1;
    L88:
        int state3 = r23;
        if (r0.mScreenState == state3) goto L136;
        r0.recordDailyStatsIfNeededLocked(true, currentTimeMs);
        int oldState = r0.mScreenState;
        r0.mScreenState = state3;
        if (state3 == 0) goto L96;
        int stepState = state3 - 1;
        int oldState2 = oldState;
        if ((stepState & 3) != stepState) goto L95;
        r0.mModStepMode |= (r0.mCurStepMode & 3) ^ stepState;
        r0.mCurStepMode = (r0.mCurStepMode & (-4)) | stepState;
    L97:
        int startStates = 0;
        int stopStates = 0;
        if (Display.isDozeState(state3) == false) goto L103;
        if (Display.isDozeState(oldState2) == true) goto L103;
        startStates = 0 | 262144;
        r0.mScreenDozeTimer.startRunningLocked(elapsedRealtimeMs);
    L108:
        if (Display.isOnState(state3) == false) goto L114;
        startStates = startStates | 1048576;
        r0.mScreenOnTimer.startRunningLocked(elapsedRealtimeMs);
        if (r0.mScreenBrightnessBin < 0) goto L112;
        r0.mScreenBrightnessTimer[r0.mScreenBrightnessBin].startRunningLocked(elapsedRealtimeMs);
    L112:
        int startStates2 = startStates;
        int stopStates2 = stopStates;
    L119:
        if (startStates2 != 0) goto L123;
        if (stopStates2 != 0) goto L123;
    L124:
        int externalUpdateFlag2 = state2 | 1;
        if (Display.isOnState(state3) == false) goto L127;
        r0.updateTimeBasesLocked(r0.mOnBatteryTimeBase.isRunning(), state3, uptimeMs * 1000, elapsedRealtimeMs * 1000);
        r0 = this;
        int displayState3 = 0;
        r0.noteStartWakeLocked(-1, -1, null, EventTeardownResult.EVENT_SCREEN, null, 0, false, elapsedRealtimeMs, uptimeMs);
        int state4 = state3;
    L132:
        if (r0.mOnBatteryInternal == false) goto L135;
        r0.updateDischargeScreenLevelsLocked(oldState2, state4);
    L135:
        int stopStates3 = externalUpdateFlag2;
        shouldScheduleSync2 = true;
    L137:
        r0.maybeUpdateOverallScreenBrightness(overallBin2, elapsedRealtimeMs, uptimeMs);
        if (shouldScheduleSync2 == true) goto L140;
        return;
    L140:
        if (r0.mPowerStatsCollectorEnabled.get(displayState3) == false) goto L142;
        r0.mScreenPowerStatsCollector.onScreenStateChange();
        return;
    L142:
        int numDisplays = r0.mPerDisplayBatteryStats.length;
        int[] displayStates = new int[numDisplays];
        int i = 0;
    L143:
        if (i >= numDisplays) goto L145;
        displayStates[i] = r0.mPerDisplayBatteryStats[i].screenState;
        i = i + 1;
        goto L143
    L145:
        r0.mExternalSync.scheduleSyncDueToScreenStateChange(stopStates3, batteryRunning, batteryScreenOffRunning, state4, displayStates);
        return;
    L127:
        displayState3 = 0;
        if (Display.isOnState(oldState2) == false) goto L130;
        r0 = this;
        r0.noteStopWakeLocked(-1, -1, null, EventTeardownResult.EVENT_SCREEN, EventTeardownResult.EVENT_SCREEN, 0, elapsedRealtimeMs, uptimeMs);
        r0.updateTimeBasesLocked(r0.mOnBatteryTimeBase.isRunning(), state3, uptimeMs * 1000, elapsedRealtimeMs * 1000);
        state4 = state3;
        goto L132
    L130:
        r0 = this;
        state4 = state3;
    L123:
        r0.mHistory.recordStateChangeEvent(elapsedRealtimeMs, uptimeMs, startStates2, stopStates2);
        goto L124
    L114:
        if (Display.isOnState(oldState2) == false) goto L118;
        stopStates = stopStates | 1048576;
        r0.mScreenOnTimer.stopRunningLocked(elapsedRealtimeMs);
        if (r0.mScreenBrightnessBin < 0) goto L112;
        r0.mScreenBrightnessTimer[r0.mScreenBrightnessBin].stopRunningLocked(elapsedRealtimeMs);
        goto L112
    L118:
        startStates2 = startStates;
        stopStates2 = stopStates;
    L103:
        if (Display.isDozeState(oldState2) == false) goto L108;
        if (Display.isDozeState(state3) == true) goto L108;
        stopStates = 0 | 262144;
        r0.mScreenDozeTimer.stopRunningLocked(elapsedRealtimeMs);
        goto L108
    L95:
        Slog.wtf(TAG, "Unexpected screen state: " + state3);
        goto L97
    L96:
        oldState2 = oldState;
        goto L97
    L136:
        state4 = state3;
        displayState3 = 0;
        stopStates3 = state2;
        goto L137
    L87:
        r23 = state;
        goto L88
    L25:
        displayStats.screenState = displayState2;
        switch(oldDisplayState) {
            case 0: goto L40;
            case 1: goto L38;
            case 2: goto L34;
            case 3: goto L31;
            case 4: goto L28;
            default: goto L27;
        };
    L27:
        Slog.wtf(TAG, "Attempted to stop timer for unexpected display state " + display);
        goto L40
    L28:
        if (displayState2 == 3) goto L40;
        displayStats.screenDozeTimer.stopRunningLocked(elapsedRealtimeMs);
        shouldScheduleSync = true;
        goto L40
    L31:
        if (displayState2 == 4) goto L40;
        displayStats.screenDozeTimer.stopRunningLocked(elapsedRealtimeMs);
        shouldScheduleSync = true;
        goto L40
    L34:
        displayStats.screenOnTimer.stopRunningLocked(elapsedRealtimeMs);
        int bin = displayStats.screenBrightnessBin;
        if (bin < 0) goto L37;
        displayStats.screenBrightnessTimers[bin].stopRunningLocked(elapsedRealtimeMs);
    L37:
        overallBin = r0.evaluateOverallScreenBrightnessBinLocked();
        shouldScheduleSync = true;
        goto L40
    L38:
        shouldScheduleSync = true;
    L40:
        switch(displayState2) {
            case 0: goto L54;
            case 1: goto L52;
            case 2: goto L48;
            case 3: goto L45;
            case 4: goto L42;
            default: goto L41;
        };
    L41:
        Slog.wtf(TAG, "Attempted to start timer for unexpected display state " + displayState2 + " for display " + display);
        goto L54
    L42:
        if (oldDisplayState == 3) goto L54;
        displayStats.screenDozeTimer.startRunningLocked(elapsedRealtimeMs);
        shouldScheduleSync = true;
        goto L54
    L45:
        if (oldDisplayState == 4) goto L54;
        displayStats.screenDozeTimer.startRunningLocked(elapsedRealtimeMs);
        shouldScheduleSync = true;
        goto L54
    L48:
        displayStats.screenOnTimer.startRunningLocked(elapsedRealtimeMs);
        int bin2 = displayStats.screenBrightnessBin;
        if (bin2 < 0) goto L51;
        displayStats.screenBrightnessTimers[bin2].startRunningLocked(elapsedRealtimeMs);
    L51:
        overallBin = r0.evaluateOverallScreenBrightnessBinLocked();
        shouldScheduleSync = true;
        goto L54
    L52:
        shouldScheduleSync = true;
    L54:
        if (shouldScheduleSync == false) goto L61;
        if (r0.mGlobalEnergyConsumerStats == null) goto L61;
        if (r0.mGlobalEnergyConsumerStats.isStandardBucketSupported(0) == false) goto L61;
        externalUpdateFlag = 0 | 32;
    L61:
        int state5 = 0;
        int i2 = 0;
    L62:
        if (i2 >= numDisplay) goto L83;
        int tempState = r0.mPerDisplayBatteryStats[i2].screenState;
        if (tempState == 2) goto L81;
        if (state5 == 2) goto L81;
        if (tempState == 3) goto L80;
        if (state5 == 3) goto L80;
        if (tempState == 4) goto L79;
        if (state5 == 4) goto L79;
        if (tempState == 1) goto L78;
        if (state5 == 1) goto L78;
    L82:
        i2 = i2 + 1;
    L78:
        state5 = 1;
    L79:
        state5 = 4;
    L80:
        state5 = 3;
    L81:
        state5 = 2;
        goto L82
    L83:
        state = state5;
        overallBin2 = overallBin;
        shouldScheduleSync2 = shouldScheduleSync;
        state2 = externalUpdateFlag;
    L148:
        Slog.wtf(TAG, "Unexpected note screen state for display " + display + " (only " + r0.mPerDisplayBatteryStats.length + " displays exist...)");
        return;
    L5:
        if (Display.isOnState(displayState) == false) goto L8;
        displayState2 = 2;
        goto L18
    L8:
        if (Display.isDozeState(displayState) == false) goto L14;
        if (Display.isSuspendedState(displayState) == false) goto L12;
        displayState2 = 4;
        goto L18
    L12:
        displayState2 = 3;
        goto L18
    L14:
        if (Display.isOffState(displayState) == false) goto L16;
        displayState2 = 1;
        goto L18
    L16:
        Slog.wtf(TAG, "Unknown screen state (not mapped): " + displayState);
        displayState2 = 0;
        goto L18
    }

    public void noteScreenBrightnessLocked(int display, int brightness) {
        noteScreenBrightnessLocked(display, brightness, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteScreenBrightnessLocked(int display, int brightness, long elapsedRealtimeMs, long uptimeMs) {
        int bin = brightness / 51;
        if (bin >= 0) goto L6;
        int bin2 = 0;
    L9:
        int numDisplays = this.mPerDisplayBatteryStats.length;
        if (display < 0) goto L24;
        if (display >= numDisplays) goto L24;
        DisplayBatteryStats displayStats = this.mPerDisplayBatteryStats[display];
        int oldBin = displayStats.screenBrightnessBin;
        if (oldBin != bin2) goto L16;
        int overallBin = this.mScreenBrightnessBin;
    L22:
        maybeUpdateOverallScreenBrightness(overallBin, elapsedRealtimeMs, uptimeMs);
        return;
    L16:
        displayStats.screenBrightnessBin = bin2;
        if (displayStats.screenState != 2) goto L21;
        if (oldBin < 0) goto L20;
        displayStats.screenBrightnessTimers[oldBin].stopRunningLocked(elapsedRealtimeMs);
    L20:
        displayStats.screenBrightnessTimers[bin2].startRunningLocked(elapsedRealtimeMs);
    L21:
        overallBin = evaluateOverallScreenBrightnessBinLocked();
    L24:
        Slog.wtf(TAG, "Unexpected note screen brightness for display " + display + " (only " + this.mPerDisplayBatteryStats.length + " displays exist...)");
        return;
    L6:
        if (bin < 5) goto L8;
        bin = 4;
    L8:
        bin2 = bin;
        goto L9
    }

    private int evaluateOverallScreenBrightnessBinLocked() {
        int overallBin = -1;
        int numDisplays = getDisplayCount();
        int display = 0;
    L3:
        if (display >= numDisplays) goto L12;
        if (this.mPerDisplayBatteryStats[display].screenState != 2) goto L7;
        int displayBrightnessBin = this.mPerDisplayBatteryStats[display].screenBrightnessBin;
    L8:
        if (displayBrightnessBin <= overallBin) goto L10;
        overallBin = displayBrightnessBin;
    L10:
        display = display + 1;
        goto L3
    L7:
        displayBrightnessBin = -1;
        goto L8
    L12:
        return overallBin;
    }

    private void maybeUpdateOverallScreenBrightness(int overallBin, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mScreenBrightnessBin == overallBin) goto L16;
        if (overallBin < 0) goto L6;
        int overallBin2 = overallBin;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        this.mHistory.recordScreenBrightnessEvent(elapsedRealtimeMs2, uptimeMs, overallBin2);
    L8:
        if (this.mScreenState == 2) goto L10;
    L14:
        this.mScreenBrightnessBin = overallBin2;
        return;
    L10:
        if (this.mScreenBrightnessBin < 0) goto L12;
        this.mScreenBrightnessTimer[this.mScreenBrightnessBin].stopRunningLocked(elapsedRealtimeMs2);
    L12:
        if (overallBin2 < 0) goto L14;
        this.mScreenBrightnessTimer[overallBin2].startRunningLocked(elapsedRealtimeMs2);
        goto L14
    L6:
        overallBin2 = overallBin;
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        goto L8
    }

    public void noteUserActivityLocked(int uid, int event, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mOnBatteryInternal == false) goto L6;
        getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs).noteUserActivityLocked(event);
        return;
    }

    public void noteWakeUpLocked(String reason, int reasonUid, long elapsedRealtimeMs, long uptimeMs) {
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 18, reason, reasonUid);
    }

    public void noteInteractiveLocked(boolean interactive, long elapsedRealtimeMs) {
        if (this.mInteractive == interactive) goto L9;
        this.mInteractive = interactive;
        if (interactive == false) goto L7;
        this.mInteractiveTimer.startRunningLocked(elapsedRealtimeMs);
        return;
    L7:
        this.mInteractiveTimer.stopRunningLocked(elapsedRealtimeMs);
        return;
    }

    public void noteConnectivityChangedLocked(int type, String extra, long elapsedRealtimeMs, long uptimeMs) {
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 9, extra, type);
        this.mNumConnectivityChange++;
    }

    private void noteMobileRadioApWakeupLocked(long elapsedRealtimeMillis, long uptimeMillis, int uid) {
        int uid2 = mapUid(uid);
        this.mHistory.recordEvent(elapsedRealtimeMillis, uptimeMillis, 19, "", uid2);
        getUidStatsLocked(uid2, elapsedRealtimeMillis, uptimeMillis).noteMobileRadioApWakeupLocked();
    }

    public boolean noteMobileRadioPowerStateLocked(int powerState, long timestampNs, int uid) {
        return noteMobileRadioPowerStateLocked(powerState, timestampNs, uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public boolean noteMobileRadioPowerStateLocked(int powerState, long timestampNs, int uid, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mMobileRadioPowerState == powerState) goto L30;
        boolean active = isActiveRadioPowerState(powerState);
        if (active == false) goto L9;
        if (uid <= 0) goto L8;
        noteMobileRadioApWakeupLocked(elapsedRealtimeMs, uptimeMs, uid);
    L8:
        long r0 = timestampNs / 1000000;
        long lastUpdateTimeMs = r0;
        this.mMobileRadioActiveStartTimeMs = r0;
        long r1 = elapsedRealtimeMs;
        this.mHistory.recordStateStartEvent(r1, uptimeMs, 33554432);
    L17:
        this.mMobileRadioPowerState = powerState;
        getRatBatteryStatsLocked(this.mActiveRat).noteActive(active, r1);
        if (active == false) goto L20;
        this.mMobileRadioActiveTimer.startRunningLocked(r1);
        this.mMobileRadioActivePerAppTimer.startRunningLocked(r1);
        return false;
    L20:
        this.mMobileRadioActiveTimer.stopRunningLocked(lastUpdateTimeMs);
        this.mMobileRadioActivePerAppTimer.stopRunningLocked(lastUpdateTimeMs);
        if (this.mMobileRadioPowerStatsCollector.isEnabled() == false) goto L24;
        this.mMobileRadioPowerStatsCollector.schedule();
        return false;
    L24:
        if (this.mLastModemActivityInfo != null) goto L26;
    L27:
        this.mExternalSync.scheduleSync("modem-data", 4);
        return true;
    L26:
        if (r1 >= (this.mLastModemActivityInfo.getTimestampMillis() + 600000)) goto L27;
        return false;
    L9:
        long realElapsedRealtimeMs = timestampNs / 1000000;
        long lastUpdateTimeMs2 = this.mMobileRadioActiveStartTimeMs;
        if (realElapsedRealtimeMs >= lastUpdateTimeMs2) goto L13;
        Slog.wtf(TAG, "Data connection inactive timestamp " + realElapsedRealtimeMs + " is before start time " + lastUpdateTimeMs2);
        long realElapsedRealtimeMs2 = elapsedRealtimeMs;
    L16:
        r1 = elapsedRealtimeMs;
        this.mHistory.recordStateStopEvent(r1, uptimeMs, 33554432);
        lastUpdateTimeMs = realElapsedRealtimeMs2;
        goto L17
    L13:
        if (realElapsedRealtimeMs >= elapsedRealtimeMs) goto L15;
        this.mMobileRadioActiveAdjustedTime.addCountLocked(elapsedRealtimeMs - realElapsedRealtimeMs);
    L15:
        realElapsedRealtimeMs2 = realElapsedRealtimeMs;
        goto L16
    L30:
        return false;
    }

    private static boolean isActiveRadioPowerState(int powerState) {
        if (powerState != 2) goto L5;
    L8:
        return true;
    L5:
        if (powerState == 3) goto L8;
        return false;
    }

    public void notePowerSaveModeLockedInit(boolean enabled, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mPowerSaveModeEnabled == enabled) goto L5;
        notePowerSaveModeLocked(enabled, elapsedRealtimeMs, uptimeMs);
        return;
    L5:
        this.mFrameworkStatsLogger.batterySaverModeChanged(enabled);
    }

    public void notePowerSaveModeLocked(boolean enabled, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mPowerSaveModeEnabled != enabled) goto L5;
        return;
    L5:
        if (enabled == false) goto L7;
        int r1 = 4;
    L8:
        int stepState = r1;
        this.mModStepMode = ((4 & this.mCurStepMode) ^ stepState) | this.mModStepMode;
        this.mCurStepMode = (this.mCurStepMode & (-5)) | stepState;
        this.mPowerSaveModeEnabled = enabled;
        if (enabled == false) goto L11;
        this.mHistory.recordState2StartEvent(elapsedRealtimeMs, uptimeMs, Integer.MIN_VALUE);
        this.mPowerSaveModeEnabledTimer.startRunningLocked(elapsedRealtimeMs);
    L12:
        this.mFrameworkStatsLogger.batterySaverModeChanged(enabled);
        return;
    L11:
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs, uptimeMs, Integer.MIN_VALUE);
        this.mPowerSaveModeEnabledTimer.stopRunningLocked(elapsedRealtimeMs);
        goto L12
    L7:
        r1 = 0;
        goto L8
    }

    public void noteDeviceIdleModeLocked(int mode, String activeReason, int activeUid, long elapsedRealtimeMs, long uptimeMs) {
        int stepState = 0;
        if (mode != 2) goto L5;
        boolean nowIdling = true;
    L7:
        if (this.mDeviceIdling == false) goto L11;
        if (nowIdling == true) goto L11;
        if (activeReason != null) goto L11;
        nowIdling = true;
    L11:
        if (mode != 1) goto L13;
        boolean nowLightIdling = true;
    L15:
        if (this.mDeviceLightIdling == false) goto L20;
        if (nowLightIdling == true) goto L20;
        if (nowIdling == true) goto L20;
        if (activeReason != null) goto L20;
        nowLightIdling = true;
    L20:
        if (activeReason != null) goto L22;
        long r8 = elapsedRealtimeMs;
    L30:
        if (this.mDeviceIdling == nowIdling) goto L32;
    L33:
        if (nowIdling == false) goto L35;
        int statsmode = 2;
    L38:
        this.mFrameworkStatsLogger.deviceIdlingModeStateChanged(statsmode);
    L40:
        if (this.mDeviceIdling == nowIdling) goto L49;
        this.mDeviceIdling = nowIdling;
        if (nowIdling == false) goto L44;
        stepState = 8;
    L44:
        this.mModStepMode = ((8 & this.mCurStepMode) ^ stepState) | this.mModStepMode;
        this.mCurStepMode = (this.mCurStepMode & (-9)) | stepState;
        if (nowIdling == false) goto L47;
        this.mDeviceIdlingTimer.startRunningLocked(r8);
        goto L49
    L47:
        this.mDeviceIdlingTimer.stopRunningLocked(r8);
    L49:
        if (this.mDeviceLightIdling == nowLightIdling) goto L55;
        this.mDeviceLightIdling = nowLightIdling;
        if (nowLightIdling == false) goto L53;
        this.mDeviceLightIdlingTimer.startRunningLocked(r8);
        goto L55
    L53:
        this.mDeviceLightIdlingTimer.stopRunningLocked(r8);
    L55:
        if (this.mDeviceIdleMode == mode) goto L74;
        long r16 = r8;
        this.mHistory.recordDeviceIdleEvent(r16, uptimeMs, mode);
        long lastDuration = r16 - this.mLastIdleTimeStartMs;
        this.mLastIdleTimeStartMs = r16;
        if (this.mDeviceIdleMode != 1) goto L63;
        if (lastDuration <= this.mLongestLightIdleTimeMs) goto L61;
        this.mLongestLightIdleTimeMs = lastDuration;
    L61:
        this.mDeviceIdleModeLightTimer.stopRunningLocked(r16);
    L68:
        if (mode != 1) goto L70;
        this.mDeviceIdleModeLightTimer.startRunningLocked(r16);
    L72:
        this.mDeviceIdleMode = mode;
        this.mFrameworkStatsLogger.deviceIdleModeStateChanged(mode);
        return;
    L70:
        if (mode != 2) goto L72;
        this.mDeviceIdleModeFullTimer.startRunningLocked(r16);
        goto L72
    L63:
        if (this.mDeviceIdleMode != 2) goto L68;
        if (lastDuration <= this.mLongestFullIdleTimeMs) goto L67;
        this.mLongestFullIdleTimeMs = lastDuration;
    L67:
        this.mDeviceIdleModeFullTimer.stopRunningLocked(r16);
        goto L68
    L74:
        return;
    L35:
        if (nowLightIdling == false) goto L37;
        statsmode = 1;
        goto L38
    L37:
        statsmode = 0;
        goto L38
    L32:
        if (this.mDeviceLightIdling == nowLightIdling) goto L40;
    L22:
        if (this.mDeviceIdling == false) goto L24;
    L27:
        r8 = elapsedRealtimeMs;
        this.mHistory.recordEvent(r8, uptimeMs, 10, activeReason, activeUid);
        goto L30
    L24:
        if (this.mDeviceLightIdling == true) goto L27;
        r8 = elapsedRealtimeMs;
        goto L30
    L13:
        nowLightIdling = false;
        goto L15
    L5:
        nowIdling = false;
        goto L7
    }

    public void notePackageInstalledLocked(String pkgName, long versionCode, long elapsedRealtimeMs, long uptimeMs) {
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 11, pkgName, (int) versionCode);
        BatteryStats.PackageChange pc = new BatteryStats.PackageChange();
        pc.mPackageName = pkgName;
        pc.mUpdate = true;
        pc.mVersionCode = versionCode;
        addPackageChange(pc);
    }

    public void notePackageUninstalledLocked(String pkgName, long elapsedRealtimeMs, long uptimeMs) {
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, 12, pkgName, 0);
        BatteryStats.PackageChange pc = new BatteryStats.PackageChange();
        pc.mPackageName = pkgName;
        pc.mUpdate = true;
        addPackageChange(pc);
    }

    private void addPackageChange(BatteryStats.PackageChange pc) {
        if (this.mDailyPackageChanges != null) goto L5;
        this.mDailyPackageChanges = new ArrayList();
    L5:
        this.mDailyPackageChanges.add(pc);
    }

    void stopAllGpsSignalQualityTimersLocked(int except, long elapsedRealtimeMs) {
        int i = 0;
    L4:
        if (i >= this.mGpsSignalQualityTimer.length) goto L12;
        if (i == except) goto L10;
    L8:
        if (this.mGpsSignalQualityTimer[i].isRunningLocked() == false) goto L10;
        this.mGpsSignalQualityTimer[i].stopRunningLocked(elapsedRealtimeMs);
    L10:
        i = i + 1;
        goto L4
    }

    public void notePhoneOnLocked(long elapsedRealtimeMs, long uptimeMs) {
        if (this.mPhoneOn == true) goto L8;
        this.mHistory.recordState2StartEvent(elapsedRealtimeMs, uptimeMs, 8388608);
        this.mPhoneOn = true;
        this.mPhoneOnTimer.startRunningLocked(elapsedRealtimeMs);
        if (this.mConstants.PHONE_ON_EXTERNAL_STATS_COLLECTION == false) goto L9;
        scheduleSyncExternalStatsLocked("phone-on", 4);
        this.mMobileRadioPowerStatsCollector.schedule();
        return;
    L9:
        return;
    }

    public void notePhoneOffLocked(long elapsedRealtimeMs, long uptimeMs) {
        if (this.mPhoneOn == false) goto L6;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs, uptimeMs, 8388608);
        this.mPhoneOn = false;
        this.mPhoneOnTimer.stopRunningLocked(elapsedRealtimeMs);
        scheduleSyncExternalStatsLocked("phone-off", 4);
        this.mMobileRadioPowerStatsCollector.schedule();
        return;
    }

    private void registerUsbStateReceiver(Context context) {
        IntentFilter usbStateFilter = new IntentFilter();
        usbStateFilter.addAction("android.hardware.usb.action.USB_STATE");
        context.registerReceiver(new AnonymousClass6(this), usbStateFilter);
        monitor-enter(this);
    L11:
        th = th;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L16
        throw th;
    L5:
        if (this.mUsbDataState != 0) goto L19;
        Intent usbState = context.registerReceiver(null, usbStateFilter);     // Catch: Throwable -> L11
        boolean r2 = false;
        if (usbState != null) goto L9;
    L13:
        boolean initState = r2;
        noteUsbConnectionStateLocked(initState, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());     // Catch: Throwable -> L16
        goto L19
    L9:
        if (usbState.getBooleanExtra("connected", false) == false) goto L13;
        r2 = true;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = th;
        goto L21
    }

    private void noteUsbConnectionStateLocked(boolean connected, long elapsedRealtimeMs, long uptimeMs) {
        if (connected == false) goto L4;
        int newState = 2;
    L6:
        if (this.mUsbDataState == newState) goto L12;
        this.mUsbDataState = newState;
        if (connected == false) goto L10;
        this.mHistory.recordState2StartEvent(elapsedRealtimeMs, uptimeMs, 262144);
        return;
    L10:
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs, uptimeMs, 262144);
        return;
    L12:
        return;
    L4:
        newState = 1;
        goto L6
    }

    void stopAllPhoneSignalStrengthTimersLocked(int except, long elapsedRealtimeMs) {
        int i = 0;
    L4:
        if (i >= CELL_SIGNAL_STRENGTH_LEVEL_COUNT) goto L12;
        if (i == except) goto L10;
    L8:
        if (this.mPhoneSignalStrengthsTimer[i].isRunningLocked() == false) goto L10;
        this.mPhoneSignalStrengthsTimer[i].stopRunningLocked(elapsedRealtimeMs);
    L10:
        i = i + 1;
        goto L4
    }

    private void updateAllPhoneStateLocked(int state, int simState, int strengthBin, long elapsedRealtimeMs, long uptimeMs) {
        boolean newHistory = false;
        int addStateFlag = 0;
        int removeStateFlag = 0;
        int newState = -1;
        int newSignalStrength = -1;
        this.mPhoneServiceStateRaw = state;
        this.mPhoneSimStateRaw = simState;
        this.mPhoneSignalStrengthBinRaw = strengthBin;
        if (simState != 1) goto L8;
        if (state != 1) goto L8;
        if (strengthBin <= 0) goto L8;
        state = 0;
    L8:
        if (state != 3) goto L10;
        int strengthBin2 = -1;
        boolean scanning = false;
    L18:
        if (scanning == true) goto L23;
        if (this.mPhoneSignalScanningTimer.isRunningLocked() == false) goto L23;
        removeStateFlag = 2097152;
        newHistory = true;
        this.mPhoneSignalScanningTimer.stopRunningLocked(elapsedRealtimeMs);
        this.mFrameworkStatsLogger.phoneServiceStateChanged(state, simState, strengthBin2);
    L23:
        if (this.mPhoneServiceState == state) goto L26;
        newState = state;
        newHistory = true;
        this.mPhoneServiceState = state;
    L26:
        if (this.mPhoneSignalStrengthBin != strengthBin2) goto L28;
        boolean newHistory2 = newHistory;
    L38:
        if (newHistory2 == false) goto L41;
        this.mHistory.recordPhoneStateChangeEvent(elapsedRealtimeMs, uptimeMs, addStateFlag, removeStateFlag, newState, newSignalStrength);
        return;
    L41:
        return;
    L28:
        if (this.mPhoneSignalStrengthBin < 0) goto L30;
        this.mPhoneSignalStrengthsTimer[this.mPhoneSignalStrengthBin].stopRunningLocked(elapsedRealtimeMs);
    L30:
        if (strengthBin2 >= 0) goto L32;
        stopAllPhoneSignalStrengthTimersLocked(-1, elapsedRealtimeMs);
    L36:
        this.mPhoneSignalStrengthBin = strengthBin2;
        newHistory2 = newHistory;
        goto L38
    L32:
        if (this.mPhoneSignalStrengthsTimer[strengthBin2].isRunningLocked() == true) goto L34;
        this.mPhoneSignalStrengthsTimer[strengthBin2].startRunningLocked(elapsedRealtimeMs);
    L34:
        newSignalStrength = strengthBin2;
        newHistory = true;
        this.mFrameworkStatsLogger.phoneSignalStrengthChanged(strengthBin2);
        goto L36
    L10:
        if (state == 0) goto L17;
        if (state != 1) goto L17;
        if (this.mPhoneSignalScanningTimer.isRunningLocked() == true) goto L16;
        addStateFlag = 2097152;
        newHistory = true;
        this.mPhoneSignalScanningTimer.startRunningLocked(elapsedRealtimeMs);
        this.mFrameworkStatsLogger.phoneServiceStateChanged(state, simState, 0);
        strengthBin2 = 0;
        scanning = true;
        goto L18
    L16:
        strengthBin2 = 0;
        scanning = true;
    L17:
        strengthBin2 = strengthBin;
        scanning = false;
        goto L18
    }

    public void notePhoneStateLocked(int state, int simState, long elapsedRealtimeMs, long uptimeMs) {
        updateAllPhoneStateLocked(state, simState, this.mPhoneSignalStrengthBinRaw, elapsedRealtimeMs, uptimeMs);
    }

    public void notePhoneSignalStrengthLocked(SignalStrength signalStrength, long elapsedRealtimeMs, long uptimeMs) {
        int overallSignalStrength = signalStrength.getLevel();
        SparseIntArray perRatSignalStrength = new SparseIntArray(3);
        List<CellSignalStrength> cellSignalStrengths = signalStrength.getCellSignalStrengths();
        int size = cellSignalStrengths.size();
        int i = 0;
    L3:
        if (i >= size) goto L15;
        CellSignalStrength cellSignalStrength = cellSignalStrengths.get(i);
        if ((cellSignalStrength instanceof CellSignalStrengthNr) == false) goto L8;
        int ratType = 2;
        int level = cellSignalStrength.getLevel();
    L12:
        if (perRatSignalStrength.get(ratType, -1) >= level) goto L14;
        perRatSignalStrength.put(ratType, level);
    L14:
        i = i + 1;
        goto L3
    L8:
        if ((cellSignalStrength instanceof CellSignalStrengthLte) == false) goto L10;
        ratType = 1;
        level = cellSignalStrength.getLevel();
        goto L12
    L10:
        ratType = 0;
        level = cellSignalStrength.getLevel();
        goto L12
    L15:
        notePhoneSignalStrengthLocked(overallSignalStrength, perRatSignalStrength, elapsedRealtimeMs, uptimeMs);
    }

    public void notePhoneSignalStrengthLocked(int signalStrength, SparseIntArray perRatSignalStrength) {
        notePhoneSignalStrengthLocked(signalStrength, perRatSignalStrength, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void notePhoneSignalStrengthLocked(int signalStrength, SparseIntArray perRatSignalStrength, long elapsedRealtimeMs, long uptimeMs) {
        int size = perRatSignalStrength.size();
        int i = 0;
    L3:
        if (i >= size) goto L5;
        int rat = perRatSignalStrength.keyAt(i);
        int ratSignalStrength = perRatSignalStrength.valueAt(i);
        getRatBatteryStatsLocked(rat).noteSignalStrength(ratSignalStrength, elapsedRealtimeMs);
        i = i + 1;
        goto L3
    L5:
        int i2 = this.mPhoneServiceStateRaw;
        updateAllPhoneStateLocked(i2, this.mPhoneSimStateRaw, signalStrength, elapsedRealtimeMs, uptimeMs);
    }

    public void notePhoneDataConnectionStateLocked(int dataType, boolean hasData, int serviceType, int nrState, int nrFrequency) {
        notePhoneDataConnectionStateLocked(dataType, hasData, serviceType, nrState, nrFrequency, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void notePhoneDataConnectionStateLocked(int dataType, boolean hasData, int serviceType, int nrState, int nrFrequency, long elapsedRealtimeMs, long uptimeMs) {
        if (hasData == false) goto L12;
        if (dataType > 0) goto L6;
    L8:
        switch(serviceType) {
            case 1: goto L11;
            case 2: goto L10;
            default: goto L9;
        };
    L9:
        int bin = BatteryStats.DATA_CONNECTION_OTHER;
        int bin2 = bin;
    L13:
        int bin3 = this.mPhoneDataConnectionType;
        if (bin3 == bin2) goto L19;
        long r7 = elapsedRealtimeMs;
        this.mHistory.recordDataConnectionTypeChangeEvent(r7, uptimeMs, bin2);
        if (this.mPhoneDataConnectionType < 0) goto L18;
        this.mPhoneDataConnectionsTimer[this.mPhoneDataConnectionType].stopRunningLocked(r7);
    L18:
        this.mPhoneDataConnectionType = bin2;
        this.mPhoneDataConnectionsTimer[bin2].startRunningLocked(r7);
    L21:
        if (this.mNrState == nrState) goto L23;
        this.mHistory.recordNrStateChangeEvent(r7, uptimeMs, nrState);
        this.mNrState = nrState;
    L23:
        boolean newNrNsaActive = isNrNsa(bin2, nrState);
        boolean nrNsaActive = this.mNrNsaTimer.isRunningLocked();
        if (newNrNsaActive == nrNsaActive) goto L28;
        if (newNrNsaActive == false) goto L27;
        this.mNrNsaTimer.startRunningLocked(r7);
        goto L28
    L27:
        this.mNrNsaTimer.stopRunningLocked(r7);
    L28:
        int newRat = mapNetworkTypeToRadioAccessTechnology(bin2, nrState);
        if (newRat != 2) goto L33;
        getRatBatteryStatsLocked(newRat).noteFrequencyRange(nrFrequency, r7);
    L33:
        if (this.mActiveRat == newRat) goto L35;
        getRatBatteryStatsLocked(this.mActiveRat).noteActive(false, r7);
        this.mActiveRat = newRat;
    L35:
        boolean modemActive = this.mMobileRadioActiveTimer.isRunningLocked();
        getRatBatteryStatsLocked(newRat).noteActive(modemActive, r7);
        return;
    L19:
        r7 = elapsedRealtimeMs;
        goto L21
    L10:
        int bin4 = BatteryStats.DATA_CONNECTION_EMERGENCY_SERVICE;
        bin2 = bin4;
        goto L13
    L11:
        bin2 = 0;
        goto L13
    L6:
        if (dataType > BatteryStats.NUM_ALL_NETWORK_TYPES) goto L8;
        bin2 = dataType;
        goto L13
    L12:
        bin2 = 0;
        goto L13
    }

    private static boolean isNrNsa(int dataType, int nrState) {
        if (dataType == 13) goto L5;
    L7:
        return false;
    L5:
        if (nrState != 3) goto L7;
        return true;
    }

    private static int mapNetworkTypeToRadioAccessTechnology(int dataType, int nrState) {
        if (isNrNsa(dataType, nrState) == false) goto L6;
        return 2;
    L6:
        switch(dataType) {
            case 0: goto L12;
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L12;
            case 12: goto L12;
            case 13: goto L10;
            case 14: goto L12;
            case 15: goto L12;
            case 16: goto L12;
            case 17: goto L12;
            case 18: goto L12;
            case 19: goto L7;
            case 20: goto L9;
            default: goto L7;
        };
    L7:
        Slog.w(TAG, "Unhandled NetworkType (" + dataType + "), mapping to OTHER");
        return 0;
    L9:
        return 2;
    L10:
        return 1;
    L12:
        return 0;
    }

    public void noteWifiOnLocked(long elapsedRealtimeMs, long uptimeMs) {
        if (this.mWifiOn == true) goto L9;
        this.mHistory.recordState2StartEvent(elapsedRealtimeMs, uptimeMs, 268435456);
        this.mWifiOn = true;
        this.mWifiOnTimer.startRunningLocked(elapsedRealtimeMs);
        if (this.mWifiPowerStatsCollector.isEnabled() == false) goto L7;
        this.mWifiPowerStatsCollector.schedule();
        return;
    L7:
        scheduleSyncExternalStatsLocked("wifi-off", 2);
        return;
    }

    public void noteWifiOffLocked(long elapsedRealtimeMs, long uptimeMs) {
        if (this.mWifiOn == false) goto L9;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs, uptimeMs, 268435456);
        this.mWifiOn = false;
        this.mWifiOnTimer.stopRunningLocked(elapsedRealtimeMs);
        if (this.mWifiPowerStatsCollector.isEnabled() == false) goto L7;
        this.mWifiPowerStatsCollector.schedule();
        return;
    L7:
        scheduleSyncExternalStatsLocked("wifi-on", 2);
        return;
    }

    public void noteAudioOnLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        int uid3 = this.mAudioOnNesting;
        if (uid3 != 0) goto L5;
        long uptimeMs2 = uptimeMs;
        int uid4 = uid2;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        this.mHistory.recordStateStartEvent(elapsedRealtimeMs2, uptimeMs2, 4194304, uid4, "audio");
        this.mAudioOnTimer.startRunningLocked(elapsedRealtimeMs2);
    L6:
        this.mAudioOnNesting++;
        if (this.mPowerStatsCollectorEnabled.get(4) == true) goto L10;
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        getUidStatsLocked(uid4, elapsedRealtimeMs3, uptimeMs2).noteAudioTurnedOnLocked(elapsedRealtimeMs3);
        return;
    L10:
        return;
    L5:
        uptimeMs2 = uptimeMs;
        uid4 = uid2;
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        goto L6
    }

    public void noteAudioOffLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mAudioOnNesting != 0) goto L5;
        return;
    L5:
        int uid2 = mapUid(uid);
        int uid3 = this.mAudioOnNesting;
        int r10 = uid3 - 1;
        this.mAudioOnNesting = r10;
        if (r10 != 0) goto L8;
        long uptimeMs2 = uptimeMs;
        int uid4 = uid2;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        this.mHistory.recordStateStopEvent(elapsedRealtimeMs2, uptimeMs2, 4194304, uid4, "audio");
        this.mAudioOnTimer.stopRunningLocked(elapsedRealtimeMs2);
    L10:
        if (this.mPowerStatsCollectorEnabled.get(4) == true) goto L13;
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        getUidStatsLocked(uid4, elapsedRealtimeMs3, uptimeMs2).noteAudioTurnedOffLocked(elapsedRealtimeMs3);
        return;
    L13:
        return;
    L8:
        uptimeMs2 = uptimeMs;
        uid4 = uid2;
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        goto L10
    }

    public void noteVideoOnLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        int uid3 = this.mVideoOnNesting;
        if (uid3 != 0) goto L5;
        long uptimeMs2 = uptimeMs;
        int uid4 = uid2;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        this.mHistory.recordState2StartEvent(elapsedRealtimeMs2, uptimeMs2, 1073741824, uid4, "video");
        this.mVideoOnTimer.startRunningLocked(elapsedRealtimeMs2);
    L6:
        this.mVideoOnNesting++;
        if (this.mPowerStatsCollectorEnabled.get(5) == true) goto L10;
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        getUidStatsLocked(uid4, elapsedRealtimeMs3, uptimeMs2).noteVideoTurnedOnLocked(elapsedRealtimeMs3);
        return;
    L10:
        return;
    L5:
        uptimeMs2 = uptimeMs;
        uid4 = uid2;
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        goto L6
    }

    public void noteVideoOffLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mVideoOnNesting != 0) goto L5;
        return;
    L5:
        int uid2 = mapUid(uid);
        int uid3 = this.mVideoOnNesting;
        int r10 = uid3 - 1;
        this.mVideoOnNesting = r10;
        if (r10 != 0) goto L8;
        long uptimeMs2 = uptimeMs;
        int uid4 = uid2;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs2, uptimeMs2, 1073741824, uid4, "video");
        this.mVideoOnTimer.stopRunningLocked(elapsedRealtimeMs2);
    L10:
        if (this.mPowerStatsCollectorEnabled.get(5) == true) goto L13;
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        getUidStatsLocked(uid4, elapsedRealtimeMs3, uptimeMs2).noteVideoTurnedOffLocked(elapsedRealtimeMs3);
        return;
    L13:
        return;
    L8:
        uptimeMs2 = uptimeMs;
        uid4 = uid2;
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        goto L10
    }

    public void noteResetAudioLocked(long elapsedRealtimeMs, long uptimeMs) {
        if (this.mAudioOnNesting <= 0) goto L9;
        this.mAudioOnNesting = 0;
        this.mHistory.recordStateStopEvent(elapsedRealtimeMs, uptimeMs, 4194304);
        this.mAudioOnTimer.stopAllRunningLocked(elapsedRealtimeMs);
        int i = 0;
    L6:
        if (i >= this.mUidStats.size()) goto L11;
        Uid uid = this.mUidStats.valueAt(i);
        uid.noteResetAudioLocked(elapsedRealtimeMs);
        i = i + 1;
        goto L6
    L11:
        return;
    }

    public void noteResetVideoLocked(long elapsedRealtimeMs, long uptimeMs) {
        if (this.mVideoOnNesting <= 0) goto L9;
        this.mVideoOnNesting = 0;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs, uptimeMs, 1073741824);
        this.mVideoOnTimer.stopAllRunningLocked(elapsedRealtimeMs);
        int i = 0;
    L6:
        if (i >= this.mUidStats.size()) goto L11;
        Uid uid = this.mUidStats.valueAt(i);
        uid.noteResetVideoLocked(elapsedRealtimeMs);
        i = i + 1;
        goto L6
    L11:
        return;
    }

    public void noteActivityResumedLocked(int uid) {
        noteActivityResumedLocked(uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteActivityResumedLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs).noteActivityResumedLocked(elapsedRealtimeMs);
    }

    public void noteActivityPausedLocked(int uid) {
        noteActivityPausedLocked(uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteActivityPausedLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs).noteActivityPausedLocked(elapsedRealtimeMs);
    }

    public void noteVibratorOnLocked(int uid, long durationMillis, long elapsedRealtimeMs, long uptimeMs) {
        getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs).noteVibratorOnLocked(durationMillis, elapsedRealtimeMs);
    }

    public void noteVibratorOffLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs).noteVibratorOffLocked(elapsedRealtimeMs);
    }

    public void noteFlashlightOnLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        int uid3 = this.mFlashlightOnNesting;
        this.mFlashlightOnNesting = uid3 + 1;
        if (uid3 != 0) goto L5;
        long uptimeMs2 = uptimeMs;
        int uid4 = uid2;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        this.mHistory.recordState2StartEvent(elapsedRealtimeMs2, uptimeMs2, 134217728, uid4, "flashlight");
        this.mFlashlightOnTimer.startRunningLocked(elapsedRealtimeMs2);
    L7:
        if (this.mPowerStatsCollectorEnabled.get(6) == true) goto L10;
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        int uid5 = uid4;
        getUidStatsLocked(uid5, elapsedRealtimeMs3, uptimeMs2).noteFlashlightTurnedOnLocked(elapsedRealtimeMs3);
        return;
    L10:
        return;
    L5:
        uptimeMs2 = uptimeMs;
        uid4 = uid2;
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        goto L7
    }

    public void noteFlashlightOffLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mFlashlightOnNesting != 0) goto L5;
        return;
    L5:
        int uid2 = mapUid(uid);
        int uid3 = this.mFlashlightOnNesting;
        int r10 = uid3 - 1;
        this.mFlashlightOnNesting = r10;
        if (r10 != 0) goto L8;
        long uptimeMs2 = uptimeMs;
        int uid4 = uid2;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs2, uptimeMs2, 134217728, uid4, "flashlight");
        this.mFlashlightOnTimer.stopRunningLocked(elapsedRealtimeMs2);
    L10:
        if (this.mPowerStatsCollectorEnabled.get(6) == true) goto L13;
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        getUidStatsLocked(uid4, elapsedRealtimeMs3, uptimeMs2).noteFlashlightTurnedOffLocked(elapsedRealtimeMs3);
        return;
    L13:
        return;
    L8:
        uptimeMs2 = uptimeMs;
        uid4 = uid2;
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        goto L10
    }

    public void noteCameraOnLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        int uid3 = this.mCameraOnNesting;
        this.mCameraOnNesting = uid3 + 1;
        if (uid3 != 0) goto L5;
        long uptimeMs2 = uptimeMs;
        int uid4 = uid2;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        this.mHistory.recordState2StartEvent(elapsedRealtimeMs2, uptimeMs2, 2097152, uid4, "camera");
        this.mCameraOnTimer.startRunningLocked(elapsedRealtimeMs2);
    L6:
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        int uid5 = uid4;
        getUidStatsLocked(uid5, elapsedRealtimeMs3, uptimeMs2).noteCameraTurnedOnLocked(elapsedRealtimeMs3);
        if (this.mPowerStatsCollectorEnabled.get(3) == false) goto L9;
        this.mCameraPowerStatsCollector.schedule();
        return;
    L9:
        scheduleSyncExternalStatsLocked("camera-on", 64);
        return;
    L5:
        uptimeMs2 = uptimeMs;
        uid4 = uid2;
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        goto L6
    }

    public void noteCameraOffLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mCameraOnNesting != 0) goto L5;
        return;
    L5:
        int uid2 = mapUid(uid);
        int uid3 = this.mCameraOnNesting;
        int r10 = uid3 - 1;
        this.mCameraOnNesting = r10;
        if (r10 != 0) goto L8;
        long uptimeMs2 = uptimeMs;
        int uid4 = uid2;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs2, uptimeMs2, 2097152, uid4, "camera");
        this.mCameraOnTimer.stopRunningLocked(elapsedRealtimeMs2);
    L9:
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        getUidStatsLocked(uid4, elapsedRealtimeMs3, uptimeMs2).noteCameraTurnedOffLocked(elapsedRealtimeMs3);
        if (this.mPowerStatsCollectorEnabled.get(3) == false) goto L12;
        this.mCameraPowerStatsCollector.schedule();
        return;
    L12:
        scheduleSyncExternalStatsLocked("camera-off", 64);
        return;
    L8:
        uptimeMs2 = uptimeMs;
        uid4 = uid2;
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        goto L9
    }

    public void noteResetCameraLocked(long elapsedRealtimeMs, long uptimeMs) {
        if (this.mCameraOnNesting <= 0) goto L9;
        this.mCameraOnNesting = 0;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs, uptimeMs, 2097152);
        this.mCameraOnTimer.stopAllRunningLocked(elapsedRealtimeMs);
        int i = 0;
    L6:
        if (i >= this.mUidStats.size()) goto L9;
        Uid uid = this.mUidStats.valueAt(i);
        uid.noteResetCameraLocked(elapsedRealtimeMs);
        i = i + 1;
    L9:
        scheduleSyncExternalStatsLocked("camera-reset", 64);
    }

    public void noteResetFlashlightLocked(long elapsedRealtimeMs, long uptimeMs) {
        if (this.mFlashlightOnNesting <= 0) goto L9;
        this.mFlashlightOnNesting = 0;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs, uptimeMs, 134217728);
        this.mFlashlightOnTimer.stopAllRunningLocked(elapsedRealtimeMs);
        int i = 0;
    L6:
        if (i >= this.mUidStats.size()) goto L11;
        Uid uid = this.mUidStats.valueAt(i);
        uid.noteResetFlashlightLocked(elapsedRealtimeMs);
        i = i + 1;
        goto L6
    L11:
        return;
    }

    private void noteBluetoothScanStartedLocked(WorkSource.WorkChain workChain, int uid, boolean isUnoptimized, long elapsedRealtimeMs, long uptimeMs) {
        if (workChain == null) goto L4;
        uid = workChain.getAttributionUid();
    L4:
        int uid2 = mapUid(uid);
        int uid3 = this.mBluetoothScanNesting;
        if (uid3 != 0) goto L7;
        this.mHistory.recordState2StartEvent(elapsedRealtimeMs, uptimeMs, 1048576);
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        long uptimeMs2 = uptimeMs;
        this.mBluetoothScanTimer.startRunningLocked(elapsedRealtimeMs2);
    L8:
        this.mBluetoothScanNesting++;
        getUidStatsLocked(uid2, elapsedRealtimeMs2, uptimeMs2).noteBluetoothScanStartedLocked(elapsedRealtimeMs2, isUnoptimized);
        return;
    L7:
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        uptimeMs2 = uptimeMs;
        goto L8
    }

    public void noteBluetoothScanStartedFromSourceLocked(WorkSource ws, boolean isUnoptimized) {
        noteBluetoothScanStartedFromSourceLocked(ws, isUnoptimized, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteBluetoothScanStartedFromSourceLocked(WorkSource ws, boolean isUnoptimized, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        noteBluetoothScanStartedLocked(null, ws.getUid(i), isUnoptimized, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        noteBluetoothScanStartedLocked(workChains.get(i2), -1, isUnoptimized, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    private void noteBluetoothScanStoppedLocked(WorkSource.WorkChain workChain, int uid, boolean isUnoptimized, long elapsedRealtimeMs, long uptimeMs) {
        if (workChain == null) goto L4;
        uid = workChain.getAttributionUid();
    L4:
        int uid2 = mapUid(uid);
        int uid3 = this.mBluetoothScanNesting;
        this.mBluetoothScanNesting = uid3 - 1;
        if (this.mBluetoothScanNesting != 0) goto L7;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs, uptimeMs, 1048576);
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        long uptimeMs2 = uptimeMs;
        this.mBluetoothScanTimer.stopRunningLocked(elapsedRealtimeMs2);
    L8:
        getUidStatsLocked(uid2, elapsedRealtimeMs2, uptimeMs2).noteBluetoothScanStoppedLocked(elapsedRealtimeMs2, isUnoptimized);
        return;
    L7:
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        uptimeMs2 = uptimeMs;
        goto L8
    }

    public void noteBluetoothScanStoppedFromSourceLocked(WorkSource ws, boolean isUnoptimized) {
        noteBluetoothScanStoppedFromSourceLocked(ws, isUnoptimized, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteBluetoothScanStoppedFromSourceLocked(WorkSource ws, boolean isUnoptimized, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        noteBluetoothScanStoppedLocked(null, ws.getUid(i), isUnoptimized, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        noteBluetoothScanStoppedLocked(workChains.get(i2), -1, isUnoptimized, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    public void noteResetBluetoothScanLocked(long elapsedRealtimeMs, long uptimeMs) {
        if (this.mBluetoothScanNesting <= 0) goto L9;
        this.mBluetoothScanNesting = 0;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs, uptimeMs, 1048576);
        this.mBluetoothScanTimer.stopAllRunningLocked(elapsedRealtimeMs);
        int i = 0;
    L6:
        if (i >= this.mUidStats.size()) goto L11;
        Uid uid = this.mUidStats.valueAt(i);
        uid.noteResetBluetoothScanLocked(elapsedRealtimeMs);
        i = i + 1;
        goto L6
    L11:
        return;
    }

    public void noteBluetoothScanResultsFromSourceLocked(WorkSource ws, int numNewResults) {
        noteBluetoothScanResultsFromSourceLocked(ws, numNewResults, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteBluetoothScanResultsFromSourceLocked(WorkSource ws, int numNewResults, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        int uid = mapUid(ws.getUid(i));
        getUidStatsLocked(uid, elapsedRealtimeMs, uptimeMs).noteBluetoothScanResultsLocked(numNewResults);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        WorkSource.WorkChain wc = workChains.get(i2);
        int uid2 = mapUid(wc.getAttributionUid());
        getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).noteBluetoothScanResultsLocked(numNewResults);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    private void retrieveBluetoothScanTimesLocked(BluetoothPowerStatsCollector.BluetoothStatsRetriever.Callback callback) {
        long elapsedTimeUs = this.mClock.elapsedRealtime() * 1000;
        int i = this.mUidStats.size() - 1;
    L3:
        if (i < 0) goto L12;
        Uid uidStats = this.mUidStats.valueAt(i);
        if (uidStats.mBluetoothScanTimer == null) goto L10;
        long scanTimeUs = this.mBluetoothScanTimer.getTotalTimeLocked(elapsedTimeUs, 0);
        if (scanTimeUs == 0) goto L10;
        int uid = this.mUidStats.keyAt(i);
        callback.onBluetoothScanTime(uid, (500 + scanTimeUs) / 1000);
    L10:
        i = i - 1;
        goto L3
    }

    private void noteWifiRadioApWakeupLocked(long elapsedRealtimeMillis, long uptimeMillis, int uid) {
        int uid2 = mapUid(uid);
        this.mHistory.recordEvent(elapsedRealtimeMillis, uptimeMillis, 19, "", uid2);
        getUidStatsLocked(uid2, elapsedRealtimeMillis, uptimeMillis).noteWifiRadioApWakeupLocked();
    }

    public void noteWifiRadioPowerState(int powerState, long timestampNs, int uid, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mWifiRadioPowerState != powerState) goto L5;
        return;
    L5:
        if (powerState != 2) goto L7;
    L10:
        boolean active = true;
    L11:
        if (active == false) goto L15;
        if (uid <= 0) goto L14;
        noteWifiRadioApWakeupLocked(elapsedRealtimeMs, uptimeMs, uid);
    L14:
        this.mHistory.recordStateStartEvent(elapsedRealtimeMs, uptimeMs, 67108864);
        this.mWifiActiveTimer.startRunningLocked(elapsedRealtimeMs);
    L16:
        this.mWifiRadioPowerState = powerState;
        return;
    L15:
        this.mHistory.recordStateStopEvent(elapsedRealtimeMs, uptimeMs, 67108864);
        this.mWifiActiveTimer.stopRunningLocked(timestampNs / 1000000);
        goto L16
    L7:
        if (powerState == 3) goto L10;
        active = false;
        goto L11
    }

    public void noteWifiRunningLocked(WorkSource ws, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mGlobalWifiRunning == true) goto L18;
        this.mHistory.recordState2StartEvent(elapsedRealtimeMs, uptimeMs, 536870912);
        this.mGlobalWifiRunning = true;
        this.mGlobalWifiRunningTimer.startRunningLocked(elapsedRealtimeMs);
        int N = ws.size();
        int i = 0;
    L5:
        if (i >= N) goto L7;
        int uid = mapUid(ws.getUid(i));
        getUidStatsLocked(uid, elapsedRealtimeMs, uptimeMs).noteWifiRunningLocked(elapsedRealtimeMs);
        i = i + 1;
        goto L5
    L7:
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L14;
        int i2 = 0;
    L11:
        if (i2 >= workChains.size()) goto L14;
        int uid2 = mapUid(workChains.get(i2).getAttributionUid());
        getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).noteWifiRunningLocked(elapsedRealtimeMs);
        i2 = i2 + 1;
    L14:
        if (this.mWifiPowerStatsCollector.isEnabled() == false) goto L16;
        this.mWifiPowerStatsCollector.schedule();
        return;
    L16:
        scheduleSyncExternalStatsLocked("wifi-running", 2);
        return;
    L18:
        Log.w(TAG, "noteWifiRunningLocked -- called while WIFI running");
    }

    public void noteWifiRunningChangedLocked(WorkSource oldWs, WorkSource newWs, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mGlobalWifiRunning == false) goto L23;
        int N = oldWs.size();
        int i = 0;
    L5:
        if (i >= N) goto L7;
        int uid = mapUid(oldWs.getUid(i));
        getUidStatsLocked(uid, elapsedRealtimeMs, uptimeMs).noteWifiStoppedLocked(elapsedRealtimeMs);
        i = i + 1;
        goto L5
    L7:
        List<WorkSource.WorkChain> workChains = oldWs.getWorkChains();
        if (workChains == null) goto L13;
        int i2 = 0;
    L11:
        if (i2 >= workChains.size()) goto L13;
        int uid2 = mapUid(workChains.get(i2).getAttributionUid());
        getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).noteWifiStoppedLocked(elapsedRealtimeMs);
        i2 = i2 + 1;
    L13:
        int N2 = newWs.size();
        int i3 = 0;
    L14:
        if (i3 >= N2) goto L16;
        int uid3 = mapUid(newWs.getUid(i3));
        getUidStatsLocked(uid3, elapsedRealtimeMs, uptimeMs).noteWifiRunningLocked(elapsedRealtimeMs);
        i3 = i3 + 1;
        goto L14
    L16:
        List<WorkSource.WorkChain> workChains2 = newWs.getWorkChains();
        if (workChains2 == null) goto L29;
        int i4 = 0;
    L20:
        if (i4 >= workChains2.size()) goto L30;
        int uid4 = mapUid(workChains2.get(i4).getAttributionUid());
        getUidStatsLocked(uid4, elapsedRealtimeMs, uptimeMs).noteWifiRunningLocked(elapsedRealtimeMs);
        i4 = i4 + 1;
        goto L20
    L30:
        return;
    L29:
        return;
    L23:
        Log.w(TAG, "noteWifiRunningChangedLocked -- called while WIFI not running");
    }

    public void noteWifiStoppedLocked(WorkSource ws, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mGlobalWifiRunning == false) goto L18;
        this.mHistory.recordState2StopEvent(elapsedRealtimeMs, uptimeMs, 536870912);
        this.mGlobalWifiRunning = false;
        this.mGlobalWifiRunningTimer.stopRunningLocked(elapsedRealtimeMs);
        int N = ws.size();
        int i = 0;
    L5:
        if (i >= N) goto L7;
        int uid = mapUid(ws.getUid(i));
        getUidStatsLocked(uid, elapsedRealtimeMs, uptimeMs).noteWifiStoppedLocked(elapsedRealtimeMs);
        i = i + 1;
        goto L5
    L7:
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L14;
        int i2 = 0;
    L11:
        if (i2 >= workChains.size()) goto L14;
        int uid2 = mapUid(workChains.get(i2).getAttributionUid());
        getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).noteWifiStoppedLocked(elapsedRealtimeMs);
        i2 = i2 + 1;
    L14:
        if (this.mWifiPowerStatsCollector.isEnabled() == false) goto L16;
        this.mWifiPowerStatsCollector.schedule();
        return;
    L16:
        scheduleSyncExternalStatsLocked("wifi-stopped", 2);
        return;
    L18:
        Log.w(TAG, "noteWifiStoppedLocked -- called while WIFI not running");
    }

    public void noteWifiStateLocked(int wifiState, String accessPoint, long elapsedRealtimeMs) {
        if (this.mWifiState != wifiState) goto L5;
        return;
    L5:
        if (this.mWifiState < 0) goto L7;
        this.mWifiStateTimer[this.mWifiState].stopRunningLocked(elapsedRealtimeMs);
    L7:
        this.mWifiState = wifiState;
        this.mWifiStateTimer[wifiState].startRunningLocked(elapsedRealtimeMs);
        if (this.mWifiPowerStatsCollector.isEnabled() == false) goto L10;
        this.mWifiPowerStatsCollector.schedule();
        return;
    L10:
        scheduleSyncExternalStatsLocked("wifi-state", 2);
    }

    public void noteWifiSupplicantStateChangedLocked(int supplState, boolean failedAuth, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mWifiSupplState == supplState) goto L9;
        if (this.mWifiSupplState < 0) goto L7;
        this.mWifiSupplStateTimer[this.mWifiSupplState].stopRunningLocked(elapsedRealtimeMs);
    L7:
        this.mWifiSupplState = supplState;
        this.mWifiSupplStateTimer[supplState].startRunningLocked(elapsedRealtimeMs);
        this.mHistory.recordWifiSupplicantStateChangeEvent(elapsedRealtimeMs, uptimeMs, supplState);
        return;
    }

    void stopAllWifiSignalStrengthTimersLocked(int except, long elapsedRealtimeMs) {
        int i = 0;
    L4:
        if (i >= 5) goto L12;
        if (i == except) goto L10;
    L8:
        if (this.mWifiSignalStrengthsTimer[i].isRunningLocked() == false) goto L10;
        this.mWifiSignalStrengthsTimer[i].stopRunningLocked(elapsedRealtimeMs);
    L10:
        i = i + 1;
        goto L4
    }

    public void noteWifiRssiChangedLocked(int newRssi, long elapsedRealtimeMs, long uptimeMs) {
        int strengthBin = WifiManager.calculateSignalLevel(newRssi, 5);
        if (this.mWifiSignalStrengthBin == strengthBin) goto L15;
        if (this.mWifiSignalStrengthBin < 0) goto L7;
        this.mWifiSignalStrengthsTimer[this.mWifiSignalStrengthBin].stopRunningLocked(elapsedRealtimeMs);
    L7:
        if (strengthBin >= 0) goto L9;
        stopAllWifiSignalStrengthTimersLocked(-1, elapsedRealtimeMs);
    L13:
        this.mWifiSignalStrengthBin = strengthBin;
        return;
    L9:
        if (this.mWifiSignalStrengthsTimer[strengthBin].isRunningLocked() == true) goto L11;
        this.mWifiSignalStrengthsTimer[strengthBin].startRunningLocked(elapsedRealtimeMs);
    L11:
        this.mHistory.recordWifiSignalStrengthChangeEvent(elapsedRealtimeMs, uptimeMs, strengthBin);
        goto L13
    }

    public void noteFullWifiLockAcquiredLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mWifiFullLockNesting != 0) goto L5;
        this.mHistory.recordStateStartEvent(elapsedRealtimeMs, uptimeMs, 268435456);
    L5:
        this.mWifiFullLockNesting++;
        getUidStatsLocked(uid, elapsedRealtimeMs, uptimeMs).noteFullWifiLockAcquiredLocked(elapsedRealtimeMs);
    }

    public void noteFullWifiLockReleasedLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        this.mWifiFullLockNesting--;
        if (this.mWifiFullLockNesting != 0) goto L5;
        this.mHistory.recordStateStopEvent(elapsedRealtimeMs, uptimeMs, 268435456);
    L5:
        getUidStatsLocked(uid, elapsedRealtimeMs, uptimeMs).noteFullWifiLockReleasedLocked(elapsedRealtimeMs);
    }

    public void noteWifiScanStartedLocked(int uid) {
        noteWifiScanStartedLocked(uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteWifiScanStartedLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        if (this.mWifiScanNesting != 0) goto L5;
        this.mHistory.recordStateStartEvent(elapsedRealtimeMs, uptimeMs, 134217728);
    L5:
        this.mWifiScanNesting++;
        getUidStatsLocked(uid, elapsedRealtimeMs, uptimeMs).noteWifiScanStartedLocked(elapsedRealtimeMs);
    }

    public void noteWifiScanStoppedLocked(int uid) {
        noteWifiScanStoppedLocked(uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteWifiScanStoppedLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        this.mWifiScanNesting--;
        if (this.mWifiScanNesting != 0) goto L5;
        this.mHistory.recordStateStopEvent(elapsedRealtimeMs, uptimeMs, 134217728);
    L5:
        getUidStatsLocked(uid, elapsedRealtimeMs, uptimeMs).noteWifiScanStoppedLocked(elapsedRealtimeMs);
    }

    public void noteWifiBatchedScanStartedLocked(int uid, int csph, long elapsedRealtimeMs, long uptimeMs) {
        getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs).noteWifiBatchedScanStartedLocked(csph, elapsedRealtimeMs);
    }

    public void noteWifiBatchedScanStoppedLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs).noteWifiBatchedScanStoppedLocked(elapsedRealtimeMs);
    }

    private void retrieveWifiScanTimesLocked(WifiPowerStatsCollector.WifiStatsRetriever.Callback callback) {
        long elapsedTimeUs = this.mClock.elapsedRealtime() * 1000;
        int i = this.mUidStats.size() - 1;
    L3:
        if (i < 0) goto L15;
        int uid = this.mUidStats.keyAt(i);
        Uid uidStats = this.mUidStats.valueAt(i);
        long scanTimeUs = uidStats.getWifiScanTime(elapsedTimeUs, 0);
        int bucket = 0;
        long batchScanTimeUs = 0;
    L6:
        if (bucket >= 5) goto L9;
        batchScanTimeUs = batchScanTimeUs + uidStats.getWifiBatchedScanTime(bucket, elapsedTimeUs, 0);
        bucket = bucket + 1;
        goto L6
    L9:
        if (scanTimeUs == 0) goto L11;
    L12:
        callback.onWifiScanTime(uid, (scanTimeUs + 500) / 1000, (500 + batchScanTimeUs) / 1000);
    L13:
        i = i - 1;
        goto L3
    L11:
        if (batchScanTimeUs == 0) goto L13;
    }

    public void noteWifiMulticastEnabledLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        int uid3 = this.mWifiMulticastNesting;
        if (uid3 != 0) goto L7;
        this.mHistory.recordStateStartEvent(elapsedRealtimeMs, uptimeMs, 65536);
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        long uptimeMs2 = uptimeMs;
        if (this.mWifiMulticastWakelockTimer.isRunningLocked() == true) goto L8;
        this.mWifiMulticastWakelockTimer.startRunningLocked(elapsedRealtimeMs2);
    L8:
        this.mWifiMulticastNesting++;
        getUidStatsLocked(uid2, elapsedRealtimeMs2, uptimeMs2).noteWifiMulticastEnabledLocked(elapsedRealtimeMs2);
        return;
    L7:
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        uptimeMs2 = uptimeMs;
        goto L8
    }

    public void noteWifiMulticastDisabledLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        int uid2 = mapUid(uid);
        int uid3 = this.mWifiMulticastNesting;
        this.mWifiMulticastNesting = uid3 - 1;
        if (this.mWifiMulticastNesting != 0) goto L7;
        this.mHistory.recordStateStopEvent(elapsedRealtimeMs, uptimeMs, 65536);
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        long uptimeMs2 = uptimeMs;
        if (this.mWifiMulticastWakelockTimer.isRunningLocked() == false) goto L8;
        this.mWifiMulticastWakelockTimer.stopRunningLocked(elapsedRealtimeMs2);
    L8:
        getUidStatsLocked(uid2, elapsedRealtimeMs2, uptimeMs2).noteWifiMulticastDisabledLocked(elapsedRealtimeMs2);
        return;
    L7:
        elapsedRealtimeMs2 = elapsedRealtimeMs;
        uptimeMs2 = uptimeMs;
        goto L8
    }

    public void noteFullWifiLockAcquiredFromSourceLocked(WorkSource ws, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        int uid = mapUid(ws.getUid(i));
        noteFullWifiLockAcquiredLocked(uid, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        WorkSource.WorkChain workChain = workChains.get(i2);
        int uid2 = mapUid(workChain.getAttributionUid());
        noteFullWifiLockAcquiredLocked(uid2, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    public void noteFullWifiLockReleasedFromSourceLocked(WorkSource ws, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        int uid = mapUid(ws.getUid(i));
        noteFullWifiLockReleasedLocked(uid, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        WorkSource.WorkChain workChain = workChains.get(i2);
        int uid2 = mapUid(workChain.getAttributionUid());
        noteFullWifiLockReleasedLocked(uid2, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    public void noteWifiScanStartedFromSourceLocked(WorkSource ws, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        int uid = mapUid(ws.getUid(i));
        noteWifiScanStartedLocked(uid, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        WorkSource.WorkChain workChain = workChains.get(i2);
        int uid2 = mapUid(workChain.getAttributionUid());
        noteWifiScanStartedLocked(uid2, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    public void noteWifiScanStoppedFromSourceLocked(WorkSource ws, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        int uid = mapUid(ws.getUid(i));
        noteWifiScanStoppedLocked(uid, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        WorkSource.WorkChain workChain = workChains.get(i2);
        int uid2 = mapUid(workChain.getAttributionUid());
        noteWifiScanStoppedLocked(uid2, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    public void noteWifiBatchedScanStartedFromSourceLocked(WorkSource ws, int csph, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        noteWifiBatchedScanStartedLocked(ws.getUid(i), csph, elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        noteWifiBatchedScanStartedLocked(workChains.get(i2).getAttributionUid(), csph, elapsedRealtimeMs, uptimeMs);
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    public void noteWifiBatchedScanStoppedFromSourceLocked(WorkSource ws, long elapsedRealtimeMs, long uptimeMs) {
        int N = ws.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        noteWifiBatchedScanStoppedLocked(ws.getUid(i), elapsedRealtimeMs, uptimeMs);
        i = i + 1;
        goto L3
    L5:
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        long elapsedRealtimeMs3 = uptimeMs;
        List<WorkSource.WorkChain> workChains = ws.getWorkChains();
        if (workChains == null) goto L11;
        int i2 = 0;
    L9:
        if (i2 >= workChains.size()) goto L14;
        long uptimeMs2 = elapsedRealtimeMs3;
        long uptimeMs3 = elapsedRealtimeMs2;
        noteWifiBatchedScanStoppedLocked(workChains.get(i2).getAttributionUid(), uptimeMs3, uptimeMs2);
        elapsedRealtimeMs2 = uptimeMs3;
        elapsedRealtimeMs3 = uptimeMs2;
        i2 = i2 + 1;
        goto L9
    L14:
        return;
    }

    private static String[] includeInStringArray(String[] array, String str) {
        if (ArrayUtils.indexOf(array, str) < 0) goto L5;
        return array;
    L5:
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = str;
        return newArray;
    }

    private static String[] excludeFromStringArray(String[] array, String str) {
        int index = ArrayUtils.indexOf(array, str);
        if (index < 0) goto L11;
        String[] newArray = new String[array.length - 1];
        if (index <= 0) goto L8;
        System.arraycopy(array, 0, newArray, 0, index);
    L8:
        if (index >= (array.length - 1)) goto L10;
        System.arraycopy(array, index + 1, newArray, index, (array.length - index) - 1);
    L10:
        return newArray;
    L11:
        return array;
    }

    public void noteNetworkInterfaceForTransports(String iface, int[] transportTypes) {
        if (TextUtils.isEmpty(iface) == false) goto L5;
        return;
    L5:
        int displayTransport = BatteryStats.getDisplayTransport(transportTypes);
        Object r1 = this.mModemNetworkLock;
        monitor-enter(r1);
        if (displayTransport != 0) goto L11;
        this.mModemIfaces = includeInStringArray(this.mModemIfaces, iface);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L9
        Object r2 = this.mWifiNetworkLock;
        monitor-enter(r2);
        if (displayTransport != 1) goto L20;
        this.mWifiIfaces = includeInStringArray(this.mWifiIfaces, iface);     // Catch: Throwable -> L18
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L20:
        this.mWifiIfaces = excludeFromStringArray(this.mWifiIfaces, iface);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L11:
        this.mModemIfaces = excludeFromStringArray(this.mModemIfaces, iface);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void noteBinderCallStats(int workSourceUid, long incrementalCallCount, Collection<BinderCallsStats.CallStat> callStats) {
        noteBinderCallStats(workSourceUid, incrementalCallCount, callStats, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public void noteBinderCallStats(int workSourceUid, long incrementalCallCount, Collection<BinderCallsStats.CallStat> callStats, long elapsedRealtimeMs, long uptimeMs) {
        monitor-enter(this);
        getUidStatsLocked(workSourceUid, elapsedRealtimeMs, uptimeMs).noteBinderCallStatsLocked(incrementalCallCount, callStats);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteBinderThreadNativeIds(int[] binderThreadNativeTids) {
        this.mSystemServerCpuThreadReader.setBinderThreadNativeTids(binderThreadNativeTids);
    }

    public void updateSystemServiceCallStats() {
        int totalRecordedCallCount = 0;
        long totalRecordedCallTimeMicros = 0;
        int i = 0;
    L4:
        if (i >= this.mUidStats.size()) goto L9;
        ArraySet<BinderCallStats> binderCallStats = Uid.m7797$$Nest$fgetmBinderCallStats(this.mUidStats.valueAt(i));
        int j = binderCallStats.size() - 1;
    L6:
        if (j < 0) goto L8;
        BinderCallStats stats = binderCallStats.valueAt(j);
        totalRecordedCallCount = (int) (((long) totalRecordedCallCount) + stats.recordedCallCount);
        totalRecordedCallTimeMicros = totalRecordedCallTimeMicros + stats.recordedCpuTimeMicros;
        j = j - 1;
        goto L6
    L8:
        i = i + 1;
        goto L4
    L9:
        long totalSystemServiceTimeMicros = 0;
        int i2 = 0;
    L11:
        if (i2 >= this.mUidStats.size()) goto L25;
        Uid uid = this.mUidStats.valueAt(i2);
        long totalTimeForUidUs = 0;
        int totalCallCountForUid = 0;
        ArraySet<BinderCallStats> binderCallStats2 = Uid.m7797$$Nest$fgetmBinderCallStats(uid);
        int j2 = binderCallStats2.size() - 1;
    L13:
        if (j2 < 0) goto L20;
        BinderCallStats stats2 = binderCallStats2.valueAt(j2);
        long totalRecordedCallTimeMicros2 = totalRecordedCallTimeMicros;
        long totalRecordedCallTimeMicros3 = stats2.callCount;
        totalCallCountForUid = (int) (((long) totalCallCountForUid) + totalRecordedCallTimeMicros3);
        if (stats2.recordedCallCount <= 0) goto L17;
        totalTimeForUidUs = totalTimeForUidUs + ((stats2.callCount * stats2.recordedCpuTimeMicros) / stats2.recordedCallCount);
    L19:
        j2 = j2 - 1;
        totalRecordedCallTimeMicros = totalRecordedCallTimeMicros2;
        goto L13
    L17:
        if (totalRecordedCallCount <= 0) goto L19;
        totalTimeForUidUs = totalTimeForUidUs + ((stats2.callCount * totalRecordedCallTimeMicros2) / ((long) totalRecordedCallCount));
        goto L19
    L20:
        long totalRecordedCallTimeMicros4 = totalRecordedCallTimeMicros;
        long totalRecordedCallTimeMicros5 = totalCallCountForUid;
        if (totalRecordedCallTimeMicros5 >= Uid.m7796$$Nest$fgetmBinderCallCount(uid)) goto L24;
        if (totalRecordedCallCount <= 0) goto L24;
        totalTimeForUidUs = totalTimeForUidUs + (((Uid.m7796$$Nest$fgetmBinderCallCount(uid) - ((long) totalCallCountForUid)) * totalRecordedCallTimeMicros4) / ((long) totalRecordedCallCount));
    L24:
        Uid.m7804$$Nest$fputmSystemServiceTimeUs(uid, totalTimeForUidUs);
        totalSystemServiceTimeMicros = totalSystemServiceTimeMicros + totalTimeForUidUs;
        i2 = i2 + 1;
        totalRecordedCallTimeMicros = totalRecordedCallTimeMicros4;
        goto L11
    L25:
        int i3 = 0;
    L27:
        if (i3 >= this.mUidStats.size()) goto L34;
        Uid uid2 = this.mUidStats.valueAt(i3);
        if (totalSystemServiceTimeMicros <= 0) goto L31;
        Uid.m7803$$Nest$fputmProportionalSystemServiceUsage(uid2, Uid.m7799$$Nest$fgetmSystemServiceTimeUs(uid2) / totalSystemServiceTimeMicros);
    L32:
        i3 = i3 + 1;
        goto L27
    L31:
        Uid.m7803$$Nest$fputmProportionalSystemServiceUsage(uid2, 0.0d);
        goto L32
    }

    public String[] getWifiIfaces() {
        Object r0 = this.mWifiNetworkLock;
        monitor-enter(r0);
        String[] r1 = this.mWifiIfaces;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String[] getMobileIfaces() {
        Object r0 = this.mModemNetworkLock;
        monitor-enter(r0);
        String[] r1 = this.mModemIfaces;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long getScreenOnTime(long elapsedRealtimeUs, int which) {
        return this.mScreenOnTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getScreenOnCount(int which) {
        return this.mScreenOnTimer.getCountLocked(which);
    }

    public long getScreenDozeTime(long elapsedRealtimeUs, int which) {
        return this.mScreenDozeTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getScreenDozeCount(int which) {
        return this.mScreenDozeTimer.getCountLocked(which);
    }

    public long getScreenBrightnessTime(int brightnessBin, long elapsedRealtimeUs, int which) {
        return this.mScreenBrightnessTimer[brightnessBin].getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    /* JADX INFO: renamed from: getScreenBrightnessTimer, reason: collision with other method in class */
    public Timer m7762getScreenBrightnessTimer(int brightnessBin) {
        return this.mScreenBrightnessTimer[brightnessBin];
    }

    public int getDisplayCount() {
        return this.mPerDisplayBatteryStats.length;
    }

    public long getDisplayScreenOnTime(int display, long elapsedRealtimeUs) {
        return this.mPerDisplayBatteryStats[display].screenOnTimer.getTotalTimeLocked(elapsedRealtimeUs, 0);
    }

    public long getDisplayScreenDozeTime(int display, long elapsedRealtimeUs) {
        return this.mPerDisplayBatteryStats[display].screenDozeTimer.getTotalTimeLocked(elapsedRealtimeUs, 0);
    }

    public long getDisplayScreenBrightnessTime(int display, int brightnessBin, long elapsedRealtimeUs) {
        DisplayBatteryStats displayStats = this.mPerDisplayBatteryStats[display];
        return displayStats.screenBrightnessTimers[brightnessBin].getTotalTimeLocked(elapsedRealtimeUs, 0);
    }

    public long getInteractiveTime(long elapsedRealtimeUs, int which) {
        return this.mInteractiveTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public long getPowerSaveModeEnabledTime(long elapsedRealtimeUs, int which) {
        return this.mPowerSaveModeEnabledTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getPowerSaveModeEnabledCount(int which) {
        return this.mPowerSaveModeEnabledTimer.getCountLocked(which);
    }

    public long getDeviceIdleModeTime(int mode, long elapsedRealtimeUs, int which) {
        switch(mode) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L3;
        };
    L3:
        return 0;
    L6:
        return this.mDeviceIdleModeFullTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    L8:
        return this.mDeviceIdleModeLightTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getDeviceIdleModeCount(int mode, int which) {
        switch(mode) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L3;
        };
    L3:
        return 0;
    L6:
        return this.mDeviceIdleModeFullTimer.getCountLocked(which);
    L8:
        return this.mDeviceIdleModeLightTimer.getCountLocked(which);
    }

    public long getLongestDeviceIdleModeTime(int mode) {
        switch(mode) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L3;
        };
    L3:
        return 0;
    L6:
        return this.mLongestFullIdleTimeMs;
    L8:
        return this.mLongestLightIdleTimeMs;
    }

    public long getDeviceIdlingTime(int mode, long elapsedRealtimeUs, int which) {
        switch(mode) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L3;
        };
    L3:
        return 0;
    L6:
        return this.mDeviceIdlingTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    L8:
        return this.mDeviceLightIdlingTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getDeviceIdlingCount(int mode, int which) {
        switch(mode) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L3;
        };
    L3:
        return 0;
    L6:
        return this.mDeviceIdlingTimer.getCountLocked(which);
    L8:
        return this.mDeviceLightIdlingTimer.getCountLocked(which);
    }

    public int getNumConnectivityChange(int which) {
        return this.mNumConnectivityChange;
    }

    public long getGpsSignalQualityTime(int strengthBin, long elapsedRealtimeUs, int which) {
        if (strengthBin >= 0) goto L4;
        return 0;
    L4:
        if (strengthBin < this.mGpsSignalQualityTimer.length) goto L7;
        return 0;
    L7:
        return this.mGpsSignalQualityTimer[strengthBin].getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public long getGpsBatteryDrainMaMs() {
        double opVolt = this.mPowerProfile.getAveragePower("gps.voltage") / 1000.0d;
        if (opVolt != 0.0d) goto L6;
        return 0;
    L6:
        double energyUsedMaMs = 0.0d;
        long rawRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        int i = 0;
    L8:
        if (i >= this.mGpsSignalQualityTimer.length) goto L11;
        energyUsedMaMs = energyUsedMaMs + (this.mPowerProfile.getAveragePower("gps.signalqualitybased", i) * (getGpsSignalQualityTime(i, rawRealtimeUs, 0) / 1000));
        i = i + 1;
        goto L8
    L11:
        return (long) energyUsedMaMs;
    }

    public long getPhoneOnTime(long elapsedRealtimeUs, int which) {
        return this.mPhoneOnTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getPhoneOnCount(int which) {
        return this.mPhoneOnTimer.getCountLocked(which);
    }

    public long getPhoneSignalStrengthTime(int strengthBin, long elapsedRealtimeUs, int which) {
        return this.mPhoneSignalStrengthsTimer[strengthBin].getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public long getPhoneSignalScanningTime(long elapsedRealtimeUs, int which) {
        return this.mPhoneSignalScanningTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    /* JADX INFO: renamed from: getPhoneSignalScanningTimer, reason: collision with other method in class */
    public Timer m7760getPhoneSignalScanningTimer() {
        return this.mPhoneSignalScanningTimer;
    }

    public int getPhoneSignalStrengthCount(int strengthBin, int which) {
        return this.mPhoneSignalStrengthsTimer[strengthBin].getCountLocked(which);
    }

    /* JADX INFO: renamed from: getPhoneSignalStrengthTimer, reason: collision with other method in class */
    public Timer m7761getPhoneSignalStrengthTimer(int strengthBin) {
        return this.mPhoneSignalStrengthsTimer[strengthBin];
    }

    public long getPhoneDataConnectionTime(int dataType, long elapsedRealtimeUs, int which) {
        return this.mPhoneDataConnectionsTimer[dataType].getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getPhoneDataConnectionCount(int dataType, int which) {
        return this.mPhoneDataConnectionsTimer[dataType].getCountLocked(which);
    }

    /* JADX INFO: renamed from: getPhoneDataConnectionTimer, reason: collision with other method in class */
    public Timer m7759getPhoneDataConnectionTimer(int dataType) {
        return this.mPhoneDataConnectionsTimer[dataType];
    }

    public long getNrNsaTime(long elapsedRealtimeUs) {
        return this.mNrNsaTimer.getTotalTimeLocked(elapsedRealtimeUs, 0);
    }

    public long getActiveRadioDurationMs(int rat, int frequencyRange, int signalStrength, long elapsedRealtimeMs) {
        RadioAccessTechnologyBatteryStats stats = this.mPerRatBatteryStats[rat];
        if (stats != null) goto L5;
        return 0;
    L5:
        int freqCount = stats.perStateTimers.length;
        if (frequencyRange < 0) goto L16;
        if (frequencyRange >= freqCount) goto L16;
        StopwatchTimer[] strengthTimers = stats.perStateTimers[frequencyRange];
        int strengthCount = strengthTimers.length;
        if (signalStrength < 0) goto L15;
        if (signalStrength >= strengthCount) goto L15;
        return stats.perStateTimers[frequencyRange][signalStrength].getTotalTimeLocked(elapsedRealtimeMs * 1000, 0) / 1000;
    L15:
        return 0;
    L16:
        return 0;
    }

    public long getActiveTxRadioDurationMs(int rat, int frequencyRange, int signalStrength, long elapsedRealtimeMs) {
        RadioAccessTechnologyBatteryStats stats = this.mPerRatBatteryStats[rat];
        if (stats != null) goto L5;
        return -1;
    L5:
        LongSamplingCounter counter = RadioAccessTechnologyBatteryStats.m7787$$Nest$mgetTxDurationCounter(stats, frequencyRange, signalStrength, false);
        if (counter != null) goto L9;
        return -1;
    L9:
        return counter.getCountLocked(0);
    }

    public long getActiveRxRadioDurationMs(int rat, int frequencyRange, long elapsedRealtimeMs) {
        RadioAccessTechnologyBatteryStats stats = this.mPerRatBatteryStats[rat];
        if (stats != null) goto L5;
        return -1;
    L5:
        LongSamplingCounter counter = RadioAccessTechnologyBatteryStats.m7786$$Nest$mgetRxDurationCounter(stats, frequencyRange, false);
        if (counter != null) goto L9;
        return -1;
    L9:
        return counter.getCountLocked(0);
    }

    public long getMobileRadioActiveTime(long elapsedRealtimeUs, int which) {
        return this.mMobileRadioActiveTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getMobileRadioActiveCount(int which) {
        return this.mMobileRadioActiveTimer.getCountLocked(which);
    }

    public long getMobileRadioActiveAdjustedTime(int which) {
        return this.mMobileRadioActiveAdjustedTime.getCountLocked(which);
    }

    public long getMobileRadioActiveUnknownTime(int which) {
        return this.mMobileRadioActiveUnknownTime.getCountLocked(which);
    }

    public int getMobileRadioActiveUnknownCount(int which) {
        return (int) this.mMobileRadioActiveUnknownCount.getCountLocked(which);
    }

    public long getWifiMulticastWakelockTime(long elapsedRealtimeUs, int which) {
        return this.mWifiMulticastWakelockTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getWifiMulticastWakelockCount(int which) {
        return this.mWifiMulticastWakelockTimer.getCountLocked(which);
    }

    public long getWifiOnTime(long elapsedRealtimeUs, int which) {
        return this.mWifiOnTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public long getWifiActiveTime(long elapsedRealtimeUs, int which) {
        return this.mWifiActiveTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public long getGlobalWifiRunningTime(long elapsedRealtimeUs, int which) {
        return this.mGlobalWifiRunningTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public long getWifiStateTime(int wifiState, long elapsedRealtimeUs, int which) {
        return this.mWifiStateTimer[wifiState].getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getWifiStateCount(int wifiState, int which) {
        return this.mWifiStateTimer[wifiState].getCountLocked(which);
    }

    /* JADX INFO: renamed from: getWifiStateTimer, reason: collision with other method in class */
    public Timer m7764getWifiStateTimer(int wifiState) {
        return this.mWifiStateTimer[wifiState];
    }

    public long getWifiSupplStateTime(int state, long elapsedRealtimeUs, int which) {
        return this.mWifiSupplStateTimer[state].getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getWifiSupplStateCount(int state, int which) {
        return this.mWifiSupplStateTimer[state].getCountLocked(which);
    }

    /* JADX INFO: renamed from: getWifiSupplStateTimer, reason: collision with other method in class */
    public Timer m7765getWifiSupplStateTimer(int state) {
        return this.mWifiSupplStateTimer[state];
    }

    public long getWifiSignalStrengthTime(int strengthBin, long elapsedRealtimeUs, int which) {
        return this.mWifiSignalStrengthsTimer[strengthBin].getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public int getWifiSignalStrengthCount(int strengthBin, int which) {
        return this.mWifiSignalStrengthsTimer[strengthBin].getCountLocked(which);
    }

    /* JADX INFO: renamed from: getWifiSignalStrengthTimer, reason: collision with other method in class */
    public Timer m7763getWifiSignalStrengthTimer(int strengthBin) {
        return this.mWifiSignalStrengthsTimer[strengthBin];
    }

    public BatteryStats.ControllerActivityCounter getBluetoothControllerActivity() {
        return this.mBluetoothActivity;
    }

    public BatteryStats.ControllerActivityCounter getWifiControllerActivity() {
        return this.mWifiActivity;
    }

    public BatteryStats.ControllerActivityCounter getModemControllerActivity() {
        return this.mModemActivity;
    }

    public boolean hasBluetoothActivityReporting() {
        return this.mHasBluetoothReporting;
    }

    public boolean hasWifiActivityReporting() {
        return this.mHasWifiReporting;
    }

    public boolean hasModemActivityReporting() {
        return this.mHasModemReporting;
    }

    public long getFlashlightOnTime(long elapsedRealtimeUs, int which) {
        return this.mFlashlightOnTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public long getFlashlightOnCount(int which) {
        return this.mFlashlightOnTimer.getCountLocked(which);
    }

    public long getCameraOnTime(long elapsedRealtimeUs, int which) {
        return this.mCameraOnTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public long getBluetoothScanTime(long elapsedRealtimeUs, int which) {
        return this.mBluetoothScanTimer.getTotalTimeLocked(elapsedRealtimeUs, which);
    }

    public long getNetworkActivityBytes(int type, int which) {
        if (type >= 0) goto L4;
        return 0;
    L4:
        if (type < this.mNetworkByteActivityCounters.length) goto L6;
        return 0;
    L6:
        return this.mNetworkByteActivityCounters[type].getCountLocked(which);
    }

    public long getNetworkActivityPackets(int type, int which) {
        if (type >= 0) goto L4;
        return 0;
    L4:
        if (type < this.mNetworkPacketActivityCounters.length) goto L6;
        return 0;
    L6:
        return this.mNetworkPacketActivityCounters[type].getCountLocked(which);
    }

    public long getBluetoothEnergyConsumptionUC() {
        return getPowerBucketConsumptionUC(5);
    }

    public long getCpuEnergyConsumptionUC() {
        return getPowerBucketConsumptionUC(3);
    }

    public long getGnssEnergyConsumptionUC() {
        return getPowerBucketConsumptionUC(6);
    }

    public long getMobileRadioEnergyConsumptionUC() {
        return getPowerBucketConsumptionUC(7);
    }

    public long getPhoneEnergyConsumptionUC() {
        return getPowerBucketConsumptionUC(9);
    }

    public long getScreenOnEnergyConsumptionUC() {
        return getPowerBucketConsumptionUC(0);
    }

    public long getScreenDozeEnergyConsumptionUC() {
        return getPowerBucketConsumptionUC(1);
    }

    public long getWifiEnergyConsumptionUC() {
        return getPowerBucketConsumptionUC(4);
    }

    public long getCameraEnergyConsumptionUC() {
        return getPowerBucketConsumptionUC(8);
    }

    private long getPowerBucketConsumptionUC(int bucket) {
        if (this.mGlobalEnergyConsumerStats != null) goto L7;
        return -1;
    L7:
        return this.mGlobalEnergyConsumerStats.getAccumulatedStandardBucketCharge(bucket);
    }

    public long[] getCustomEnergyConsumerBatteryConsumptionUC() {
        if (this.mGlobalEnergyConsumerStats != null) goto L7;
        return null;
    L7:
        return this.mGlobalEnergyConsumerStats.getAccumulatedCustomBucketCharges();
    }

    public String[] getCustomEnergyConsumerNames() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mEnergyConsumerStatsConfig != null) goto L10;
        String[] r0 = new String[0];     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r0;
    L10:
        String[] names = this.mEnergyConsumerStatsConfig.getCustomBucketNames();     // Catch: Throwable -> L8
        int i = 0;
    L12:
        if (i >= names.length) goto L18;
        if (TextUtils.isEmpty(names[i]) == false) goto L16;
        names[i] = "CUSTOM_1000" + i;     // Catch: Throwable -> L8
    L16:
        i = i + 1;     // Catch: Throwable -> L8
        goto L12
    L18:
        monitor-exit(this);     // Catch: Throwable -> L8
        return names;
    }

    public long getStartClockTime() {
        monitor-enter(this);
        long currentTimeMs = this.mClock.currentTimeMillis();     // Catch: Throwable -> L8
        if (currentTimeMs <= 31536000000L) goto L11;
        if (this.mStartClockTimeMs >= (currentTimeMs - 31536000000L)) goto L11;
    L12:
        this.mHistory.recordCurrentTimeChange(this.mClock.elapsedRealtime(), this.mClock.uptimeMillis(), currentTimeMs);     // Catch: Throwable -> L8
        adjustStartClockTime(currentTimeMs);     // Catch: Throwable -> L8
    L13:
        long r0 = this.mStartClockTimeMs;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r0;
    L11:
        if (this.mStartClockTimeMs <= currentTimeMs) goto L13;
    L8:
        th = move-exception;
        throw th;
    }

    public long getMonotonicStartTime() {
        return this.mMonotonicStartTime;
    }

    public long getMonotonicEndTime() {
        return this.mMonotonicEndTime;
    }

    public String getStartPlatformVersion() {
        return this.mStartPlatformVersion;
    }

    public String getEndPlatformVersion() {
        return this.mEndPlatformVersion;
    }

    public int getParcelVersion() {
        return VERSION;
    }

    public boolean getIsOnBattery() {
        return this.mOnBattery;
    }

    public long getStatsStartRealtime() {
        return this.mRealtimeStartUs;
    }

    public SparseArray<? extends BatteryStats.Uid> getUidStats() {
        return this.mUidStats;
    }

    private static <T extends TimeBaseObs> boolean resetIfNotNull(T t, boolean detachIfReset, long elapsedRealtimeUs) {
        if (t != null) goto L4;
        return true;
    L4:
        return t.reset(detachIfReset, elapsedRealtimeUs);
    }

    private static <T extends TimeBaseObs> boolean resetIfNotNull(T[] t, boolean detachIfReset, long elapsedRealtimeUs) {
        if (t == null) goto L9;
        boolean ret = true;
        int i = 0;
    L5:
        if (i >= t.length) goto L8;
        ret = ret & resetIfNotNull(t[i], detachIfReset, elapsedRealtimeUs);
        i = i + 1;
        goto L5
    L8:
        return ret;
    L9:
        return true;
    }

    private static <T extends TimeBaseObs> boolean resetIfNotNull(T[][] t, boolean detachIfReset, long elapsedRealtimeUs) {
        if (t == null) goto L9;
        boolean ret = true;
        int i = 0;
    L5:
        if (i >= t.length) goto L8;
        ret = ret & resetIfNotNull(t[i], detachIfReset, elapsedRealtimeUs);
        i = i + 1;
        goto L5
    L8:
        return ret;
    L9:
        return true;
    }

    private static boolean resetIfNotNull(ControllerActivityCounterImpl counter, boolean detachIfReset, long elapsedRealtimeUs) {
        if (counter == null) goto L6;
        counter.reset(detachIfReset, elapsedRealtimeUs);
        return true;
    L6:
        return true;
    }

    private static <T extends TimeBaseObs> void detachIfNotNull(T t) {
        if (t == null) goto L5;
        t.detach();
        return;
    }

    private static <T extends TimeBaseObs> void detachIfNotNull(T[] t) {
        if (t == null) goto L7;
        int i = 0;
    L5:
        if (i >= t.length) goto L9;
        detachIfNotNull(t[i]);
        i = i + 1;
        goto L5
    L9:
        return;
    }

    private static <T extends TimeBaseObs> void detachIfNotNull(T[][] t) {
        if (t == null) goto L7;
        int i = 0;
    L5:
        if (i >= t.length) goto L9;
        detachIfNotNull(t[i]);
        i = i + 1;
        goto L5
    L9:
        return;
    }

    private static void detachIfNotNull(ControllerActivityCounterImpl counter) {
        if (counter == null) goto L5;
        counter.detach();
        return;
    }

    public CpuScalingPolicies getCpuScalingPolicies() {
        return this.mCpuScalingPolicies;
    }

    private long[] getCpuTimeInFreqContainer() {
        if (this.mTmpCpuTimeInFreq != null) goto L6;
        this.mTmpCpuTimeInFreq = new long[this.mCpuScalingPolicies.getScalingStepCount()];
    L6:
        return this.mTmpCpuTimeInFreq;
    }

    public BatteryStatsImpl(BatteryStatsConfig config, Clock clock, MonotonicClock monotonicClock, File systemDir, Handler handler, PlatformIdleStateCallback platformIdleStateCallback, EnergyStatsRetriever energyStatsRetriever, UserInfoProvider userInfoProvider, PowerProfile powerProfile, CpuScalingPolicies cpuScalingPolicies, PowerStatsUidResolver powerStatsUidResolver) {
        if (systemDir == null) goto L6;
        BatteryHistoryDirectory r0 = new BatteryHistoryDirectory(new File(systemDir, HISTORY_DIR), config.getMaxHistorySizeBytes());
    L5:
        BatteryHistoryDirectory r5 = r0;
        this(config, clock, monotonicClock, systemDir, r5, handler, platformIdleStateCallback, energyStatsRetriever, userInfoProvider, powerProfile, cpuScalingPolicies, powerStatsUidResolver, new FrameworkStatsLogger(), new BatteryStatsHistory.TraceDelegate(), new BatteryStatsHistory.EventLogger());
        return;
    L6:
        r0 = null;
        goto L5
    }

    public BatteryStatsImpl(BatteryStatsConfig config, Clock clock, MonotonicClock monotonicClock, File systemDir, BatteryHistoryDirectory batteryHistoryDirectory, Handler handler, PlatformIdleStateCallback platformIdleStateCallback, EnergyStatsRetriever energyStatsRetriever, UserInfoProvider userInfoProvider, PowerProfile powerProfile, CpuScalingPolicies cpuScalingPolicies, PowerStatsUidResolver powerStatsUidResolver, FrameworkStatsLogger frameworkStatsLogger, BatteryStatsHistory.TraceDelegate traceDelegate, BatteryStatsHistory.EventLogger eventLogger) {
        this.mTmpWakelockStats = new KernelWakelockStats();
        this.mKernelMemoryStats = new LongSparseArray();
        this.mPowerStatsCollectorEnabled = new SparseBooleanArray();
        this.mMoveWscLoggingToNotifierEnabled = false;
        this.mScreenUsageTimeRetriever = new AnonymousClass2(this);
        this.mWifiStatsRetriever = new AnonymousClass3(this);
        this.mWakelockDurationRetriever = new AnonymousClass4(this);
        this.mPerProcStateCpuTimesAvailable = true;
        this.mCpuTimeReadsTrackingStartTimeMs = SystemClock.uptimeMillis();
        BatteryStatsImplIA r4 = null;
        this.mTmpRpmStats = null;
        this.mLastRpmStatsUpdateTimeMs = -1000;
        this.mPendingRemovedUids = new LinkedList();
        this.mDeferSetCharging = new AnonymousClass5(this);
        this.mExternalSync = null;
        this.mUserInfoProvider = null;
        this.mUidStats = new SparseArray();
        this.mPartialTimers = new ArrayList();
        this.mFullTimers = new ArrayList();
        this.mWindowTimers = new ArrayList();
        this.mDrawTimers = new ArrayList();
        this.mSensorTimers = new SparseArray();
        this.mWifiRunningTimers = new ArrayList();
        this.mFullWifiLockTimers = new ArrayList();
        this.mWifiMulticastTimers = new ArrayList();
        this.mWifiScanTimers = new ArrayList();
        this.mWifiBatchedScanTimers = new SparseArray();
        this.mAudioTurnedOnTimers = new ArrayList();
        this.mVideoTurnedOnTimers = new ArrayList();
        this.mFlashlightTurnedOnTimers = new ArrayList();
        this.mCameraTurnedOnTimers = new ArrayList();
        this.mBluetoothScanOnTimers = new ArrayList();
        this.mLastPartialTimers = new ArrayList();
        this.mOnBatteryTimeBase = new TimeBase(true);
        this.mOnBatteryScreenOffTimeBase = new TimeBase(true);
        this.mActiveEvents = new BatteryStats.HistoryEventTracker();
        this.mStepDetailsProvider = new BatteryHistoryStepDetailsProvider(this);
        this.mHaveBatteryLevel = false;
        this.mBatteryPluggedInRealTimeMs = 0;
        this.mIgnoreNextExternalStats = false;
        this.mMonotonicEndTime = -1;
        this.mScreenState = 0;
        this.mScreenBrightnessBin = -1;
        this.mScreenBrightnessTimer = new StopwatchTimer[5];
        this.mDisplayMismatchWtfCount = 0;
        this.mUsbDataState = 0;
        this.mGpsSignalQualityBin = -1;
        this.mGpsSignalQualityTimer = new StopwatchTimer[2];
        this.mPhoneSignalStrengthBin = -1;
        this.mPhoneSignalStrengthBinRaw = -1;
        this.mPhoneSignalStrengthsTimer = new StopwatchTimer[CELL_SIGNAL_STRENGTH_LEVEL_COUNT];
        this.mPhoneDataConnectionType = -1;
        this.mPhoneDataConnectionsTimer = new StopwatchTimer[BatteryStats.NUM_DATA_CONNECTION_TYPES];
        this.mNrState = -1;
        this.mActiveRat = 0;
        this.mPerRatBatteryStats = new RadioAccessTechnologyBatteryStats[3];
        this.mNetworkByteActivityCounters = new LongSamplingCounter[10];
        this.mNetworkPacketActivityCounters = new LongSamplingCounter[10];
        this.mHasWifiReporting = false;
        this.mHasBluetoothReporting = false;
        this.mHasModemReporting = false;
        this.mWifiState = -1;
        this.mWifiStateTimer = new StopwatchTimer[8];
        this.mWifiSupplState = -1;
        this.mWifiSupplStateTimer = new StopwatchTimer[13];
        this.mWifiSignalStrengthBin = -1;
        this.mWifiSignalStrengthsTimer = new StopwatchTimer[5];
        this.mMobileRadioPowerState = 1;
        this.mWifiRadioPowerState = 1;
        this.mBluetoothPowerCalculator = null;
        this.mCpuPowerCalculator = null;
        this.mMobileRadioPowerCalculator = null;
        this.mWifiPowerCalculator = null;
        this.mCharging = true;
        this.mInitStepMode = 0;
        this.mCurStepMode = 0;
        this.mModStepMode = 0;
        this.mDischargeStepTracker = new BatteryStats.LevelStepTracker(200);
        this.mDailyDischargeStepTracker = new BatteryStats.LevelStepTracker(400);
        this.mChargeStepTracker = new BatteryStats.LevelStepTracker(200);
        this.mDailyChargeStepTracker = new BatteryStats.LevelStepTracker(400);
        this.mDailyStartTimeMs = 0;
        this.mNextMinDailyDeadlineMs = 0;
        this.mNextMaxDailyDeadlineMs = 0;
        this.mDailyItems = new ArrayList();
        this.mLastWriteTimeMs = 0;
        this.mPhoneServiceState = -1;
        this.mPhoneServiceStateRaw = -1;
        this.mPhoneSimStateRaw = -1;
        this.mEstimatedBatteryCapacityMah = -1;
        this.mLastLearnedBatteryCapacityUah = -1;
        this.mMinLearnedBatteryCapacityUah = -1;
        this.mMaxLearnedBatteryCapacityUah = -1;
        this.mBatteryTimeToFullSeconds = -1;
        this.mAlarmManager = null;
        this.mLongPlugInAlarmHandler = new BatteryStatsImpl$$ExternalSyntheticLambda9(this);
        this.mRpmStats = new HashMap();
        this.mScreenOffRpmStats = new HashMap();
        this.mKernelWakelockStats = new HashMap();
        this.mLastWakeupReason = null;
        this.mLastWakeupUptimeMs = 0;
        this.mLastWakeupElapsedTimeMs = 0;
        this.mWakeupReasonStats = new HashMap();
        this.mPowerStatsCollectorInjector = new PowerStatsCollectorInjector(this, r4);
        this.mWifiFullLockNesting = 0;
        this.mWifiScanNesting = 0;
        this.mWifiMulticastNesting = 0;
        this.mFrameworkEvents = new WakelockStatsFrameworkEvents();
        this.mPowerManagerFlags = new PowerManagerFlags();
        this.mWifiNetworkLock = new Object();
        this.mWifiIfaces = EmptyArray.STRING;
        this.mModemNetworkLock = new Object();
        this.mModemIfaces = EmptyArray.STRING;
        this.mLastModemActivityInfo = null;
        this.mLastBluetoothActivityInfo = new BluetoothActivityInfoCache(this, r4);
        this.mWriteAsyncRunnable = new BatteryStatsImpl$$ExternalSyntheticLambda11(this);
        this.mWriteLock = new ReentrantLock();
        this.mClock = clock;
        initKernelStatsReaders();
        this.mBatteryStatsConfig = config;
        this.mMonotonicClock = monotonicClock;
        this.mHandler = new MyHandler(this, handler.getLooper());
        this.mConstants = new Constants(this, this.mHandler);
        this.mPowerProfile = powerProfile;
        this.mCpuScalingPolicies = cpuScalingPolicies;
        this.mPowerStatsUidResolver = powerStatsUidResolver;
        this.mFrameworkStatsLogger = frameworkStatsLogger;
        initPowerProfile();
        getBSImplOptEx().init(this);
        if (systemDir == null) goto L5;
        this.mStatsFile = new AtomicFile(new File(systemDir, "batterystats.bin"));
        this.mCheckinFile = new AtomicFile(new File(systemDir, "batterystats-checkin.bin"));
        this.mDailyFile = new AtomicFile(new File(systemDir, "batterystats-daily.xml"));
    L6:
        this.mBatteryHistoryDirectory = batteryHistoryDirectory;
        this.mHistory = new BatteryStatsHistory(null, this.mConstants.MAX_HISTORY_BUFFER, this.mBatteryHistoryDirectory, this.mClock, this.mMonotonicClock, traceDelegate, eventLogger);
        this.mCpuPowerStatsCollector = new CpuPowerStatsCollector(this.mPowerStatsCollectorInjector);
        this.mCpuPowerStatsCollector.addConsumer(new BatteryStatsImpl$$ExternalSyntheticLambda10(this));
        this.mWakelockPowerStatsCollector = new WakelockPowerStatsCollector(this.mPowerStatsCollectorInjector);
        this.mWakelockPowerStatsCollector.addConsumer(new BatteryStatsImpl$$ExternalSyntheticLambda10(this));
        this.mScreenPowerStatsCollector = new ScreenPowerStatsCollector(this.mPowerStatsCollectorInjector);
        this.mScreenPowerStatsCollector.addConsumer(new BatteryStatsImpl$$ExternalSyntheticLambda10(this));
        this.mMobileRadioPowerStatsCollector = new MobileRadioPowerStatsCollector(this.mPowerStatsCollectorInjector, new BatteryStatsImpl$$ExternalSyntheticLambda12(this));
        this.mMobileRadioPowerStatsCollector.addConsumer(new BatteryStatsImpl$$ExternalSyntheticLambda10(this));
        this.mWifiPowerStatsCollector = new WifiPowerStatsCollector(this.mPowerStatsCollectorInjector, new BatteryStatsImpl$$ExternalSyntheticLambda13(this));
        this.mWifiPowerStatsCollector.addConsumer(new BatteryStatsImpl$$ExternalSyntheticLambda10(this));
        this.mBluetoothPowerStatsCollector = new BluetoothPowerStatsCollector(this.mPowerStatsCollectorInjector, new BatteryStatsImpl$$ExternalSyntheticLambda14(this));
        this.mBluetoothPowerStatsCollector.addConsumer(new BatteryStatsImpl$$ExternalSyntheticLambda10(this));
        this.mCameraPowerStatsCollector = new CameraPowerStatsCollector(this.mPowerStatsCollectorInjector);
        this.mCameraPowerStatsCollector.addConsumer(new BatteryStatsImpl$$ExternalSyntheticLambda10(this));
        this.mGnssPowerStatsCollector = new GnssPowerStatsCollector(this.mPowerStatsCollectorInjector);
        this.mGnssPowerStatsCollector.addConsumer(new BatteryStatsImpl$$ExternalSyntheticLambda10(this));
        this.mCustomEnergyConsumerPowerStatsCollector = new CustomEnergyConsumerPowerStatsCollector(this.mPowerStatsCollectorInjector);
        this.mCustomEnergyConsumerPowerStatsCollector.addConsumer(new BatteryStatsImpl$$ExternalSyntheticLambda10(this));
        this.mStartCount++;
        initTimersAndCounters();
        this.mOnBatteryInternal = false;
        this.mOnBattery = false;
        long uptimeUs = this.mClock.uptimeMillis() * 1000;
        long realtimeUs = 1000 * this.mClock.elapsedRealtime();
        initTimes(uptimeUs, realtimeUs);
        String r3 = Build.ID;
        this.mEndPlatformVersion = r3;
        this.mStartPlatformVersion = r3;
        initDischarge(realtimeUs);
        updateDailyDeadlineLocked();
        this.mPlatformIdleStateCallback = platformIdleStateCallback;
        this.mEnergyConsumerRetriever = energyStatsRetriever;
        this.mUserInfoProvider = userInfoProvider;
        this.mPowerStatsUidResolver.addListener(new AnonymousClass7(this));
        this.mDeviceIdleMode = 0;
        this.mFrameworkStatsLogger.deviceIdleModeStateChanged(this.mDeviceIdleMode);
        return;
    L5:
        this.mStatsFile = null;
        this.mCheckinFile = null;
        this.mDailyFile = null;
        goto L6
    }

    private void recordPowerStats(PowerStats stats) {
        if (stats.durationMs <= 0) goto L17;
        monitor-enter(this);
        this.mHistory.recordPowerStats(this.mClock.elapsedRealtime(), this.mClock.uptimeMillis(), stats);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        th = move-exception;
        Throwable r8 = th;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L10
        throw r8;
    L10:
        th = move-exception;
        r8 = th;
        goto L14
    }

    protected void initTimersAndCounters() {
        this.mScreenOnTimer = new StopwatchTimer(this.mClock, null, -1, null, this.mOnBatteryTimeBase);
        this.mScreenDozeTimer = new StopwatchTimer(this.mClock, null, -1, null, this.mOnBatteryTimeBase);
        int i = 0;
    L4:
        if (i >= 5) goto L6;
        this.mScreenBrightnessTimer[i] = new StopwatchTimer(this.mClock, null, (-100) - i, null, this.mOnBatteryTimeBase);
        i = i + 1;
        goto L4
    L6:
        this.mInteractiveTimer = new StopwatchTimer(this.mClock, null, -10, null, this.mOnBatteryTimeBase);
        this.mPowerSaveModeEnabledTimer = new StopwatchTimer(this.mClock, null, -2, null, this.mOnBatteryTimeBase);
        this.mDeviceIdleModeLightTimer = new StopwatchTimer(this.mClock, null, -11, null, this.mOnBatteryTimeBase);
        this.mDeviceIdleModeFullTimer = new StopwatchTimer(this.mClock, null, -14, null, this.mOnBatteryTimeBase);
        this.mDeviceLightIdlingTimer = new StopwatchTimer(this.mClock, null, -15, null, this.mOnBatteryTimeBase);
        this.mDeviceIdlingTimer = new StopwatchTimer(this.mClock, null, -12, null, this.mOnBatteryTimeBase);
        this.mPhoneOnTimer = new StopwatchTimer(this.mClock, null, -3, null, this.mOnBatteryTimeBase);
        int i2 = 0;
    L8:
        if (i2 >= CELL_SIGNAL_STRENGTH_LEVEL_COUNT) goto L10;
        this.mPhoneSignalStrengthsTimer[i2] = new StopwatchTimer(this.mClock, null, (-200) - i2, null, this.mOnBatteryTimeBase);
        i2 = i2 + 1;
        goto L8
    L10:
        this.mPhoneSignalScanningTimer = new StopwatchTimer(this.mClock, null, -199, null, this.mOnBatteryTimeBase);
        int i3 = 0;
    L12:
        if (i3 >= BatteryStats.NUM_DATA_CONNECTION_TYPES) goto L14;
        this.mPhoneDataConnectionsTimer[i3] = new StopwatchTimer(this.mClock, null, (-300) - i3, null, this.mOnBatteryTimeBase);
        i3 = i3 + 1;
        goto L12
    L14:
        this.mNrNsaTimer = new StopwatchTimer(this.mClock, null, -198, null, this.mOnBatteryTimeBase);
        int i4 = 0;
    L16:
        if (i4 >= 10) goto L18;
        this.mNetworkByteActivityCounters[i4] = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mNetworkPacketActivityCounters[i4] = new LongSamplingCounter(this.mOnBatteryTimeBase);
        i4 = i4 + 1;
        goto L16
    L18:
        this.mWifiActivity = new ControllerActivityCounterImpl(this.mClock, this.mOnBatteryTimeBase, 1);
        this.mBluetoothActivity = new ControllerActivityCounterImpl(this.mClock, this.mOnBatteryTimeBase, 1);
        this.mModemActivity = new ControllerActivityCounterImpl(this.mClock, this.mOnBatteryTimeBase, MODEM_TX_POWER_LEVEL_COUNT);
        this.mMobileRadioActiveTimer = new StopwatchTimer(this.mClock, null, -400, null, this.mOnBatteryTimeBase);
        this.mMobileRadioActivePerAppTimer = new StopwatchTimer(this.mClock, null, -401, null, this.mOnBatteryTimeBase);
        this.mMobileRadioActiveAdjustedTime = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mMobileRadioActiveUnknownTime = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mMobileRadioActiveUnknownCount = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mWifiMulticastWakelockTimer = new StopwatchTimer(this.mClock, null, 23, null, this.mOnBatteryTimeBase);
        this.mWifiOnTimer = new StopwatchTimer(this.mClock, null, -4, null, this.mOnBatteryTimeBase);
        this.mGlobalWifiRunningTimer = new StopwatchTimer(this.mClock, null, -5, null, this.mOnBatteryTimeBase);
        int i5 = 0;
    L20:
        if (i5 >= 8) goto L22;
        this.mWifiStateTimer[i5] = new StopwatchTimer(this.mClock, null, (-600) - i5, null, this.mOnBatteryTimeBase);
        i5 = i5 + 1;
        goto L20
    L22:
        int i6 = 0;
    L24:
        if (i6 >= 13) goto L26;
        this.mWifiSupplStateTimer[i6] = new StopwatchTimer(this.mClock, null, (-700) - i6, null, this.mOnBatteryTimeBase);
        i6 = i6 + 1;
        goto L24
    L26:
        int i7 = 0;
    L27:
        if (i7 >= 5) goto L29;
        this.mWifiSignalStrengthsTimer[i7] = new StopwatchTimer(this.mClock, null, (-800) - i7, null, this.mOnBatteryTimeBase);
        i7 = i7 + 1;
        goto L27
    L29:
        this.mWifiActiveTimer = new StopwatchTimer(this.mClock, null, ProcessList.SYSTEM_ADJ, null, this.mOnBatteryTimeBase);
        int i8 = 0;
    L31:
        if (i8 >= this.mGpsSignalQualityTimer.length) goto L33;
        this.mGpsSignalQualityTimer[i8] = new StopwatchTimer(this.mClock, null, (-1000) - i8, null, this.mOnBatteryTimeBase);
        i8 = i8 + 1;
        goto L31
    L33:
        this.mAudioOnTimer = new StopwatchTimer(this.mClock, null, -7, null, this.mOnBatteryTimeBase);
        this.mVideoOnTimer = new StopwatchTimer(this.mClock, null, -8, null, this.mOnBatteryTimeBase);
        this.mFlashlightOnTimer = new StopwatchTimer(this.mClock, null, -9, null, this.mOnBatteryTimeBase);
        this.mCameraOnTimer = new StopwatchTimer(this.mClock, null, -13, null, this.mOnBatteryTimeBase);
        this.mBluetoothScanTimer = new StopwatchTimer(this.mClock, null, -14, null, this.mOnBatteryTimeBase);
        this.mDischargeScreenOffCounter = new LongSamplingCounter(this.mOnBatteryScreenOffTimeBase);
        this.mDischargeScreenDozeCounter = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mDischargeLightDozeCounter = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mDischargeDeepDozeCounter = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mDischargeCounter = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mDischargeUnplugLevel = 0;
        this.mDischargePlugLevel = -1;
        this.mDischargeCurrentLevel = 0;
        this.mBatteryLevel = 0;
    }

    private void initPowerProfile() {
        int[] policies = this.mCpuScalingPolicies.getPolicies();
        this.mKernelCpuSpeedReaders = new KernelCpuSpeedReader[policies.length];
        int i = 0;
    L3:
        int r3 = 0;
        if (i >= policies.length) goto L6;
        int[] cpus = this.mCpuScalingPolicies.getRelatedCpus(policies[i]);
        int[] freqs = this.mCpuScalingPolicies.getFrequencies(policies[i]);
        this.mKernelCpuSpeedReaders[i] = new KernelCpuSpeedReader(cpus[0], freqs.length);
        i = i + 1;
        goto L3
    L6:
        this.mCpuPowerBracketMap = new int[this.mCpuScalingPolicies.getScalingStepCount()];
        int index = 0;
        int r2 = policies.length;
    L7:
        if (r3 >= r2) goto L13;
        int policy = policies[r3];
        int steps = this.mCpuScalingPolicies.getFrequencies(policy).length;
        int step = 0;
    L9:
        if (step >= steps) goto L11;
        this.mCpuPowerBracketMap[index] = this.mPowerProfile.getCpuPowerBracketForScalingStep(policy, step);
        step = step + 1;
        index = index + 1;
        goto L9
    L11:
        r3 = r3 + 1;
        goto L7
    L13:
        if (this.mEstimatedBatteryCapacityMah != (-1)) goto L15;
        this.mEstimatedBatteryCapacityMah = (int) this.mPowerProfile.getBatteryCapacity();
    L15:
        setDisplayCountLocked(this.mPowerProfile.getNumDisplays());
    }

    public void startTrackingSystemServerCpuTime() {
        this.mSystemServerCpuThreadReader.startTrackingThreadCpuTime();
    }

    public SystemServerCpuThreadReader.SystemServiceCpuThreadTimes getSystemServiceCpuThreadTimes() {
        return this.mSystemServerCpuThreadReader.readAbsolute();
    }

    public void setCallback(BatteryCallback cb) {
        this.mCallback = cb;
    }

    void updateCpuDetails() {
        if (this.mCallback == null) goto L6;
        this.mCallback.batteryNeedsCpuUpdate();
        return;
    }

    public void setRadioScanningTimeoutLocked(long timeoutUs) {
        if (this.mPhoneSignalScanningTimer == null) goto L6;
        this.mPhoneSignalScanningTimer.setTimeout(timeoutUs);
        return;
    }

    public void setExternalStatsSyncLocked(ExternalStatsSync sync) {
        this.mExternalSync = sync;
    }

    public void setDisplayCountLocked(int numDisplays) {
        this.mPerDisplayBatteryStats = new DisplayBatteryStats[numDisplays];
        int i = 0;
    L3:
        if (i >= numDisplays) goto L6;
        this.mPerDisplayBatteryStats[i] = new DisplayBatteryStats(this.mClock, this.mOnBatteryTimeBase);
        i = i + 1;
        goto L3
    }

    public void updateDailyDeadlineLocked() {
        long currentTimeMs = this.mClock.currentTimeMillis();
        this.mDailyStartTimeMs = currentTimeMs;
        Calendar calDeadline = Calendar.getInstance();
        calDeadline.setTimeInMillis(currentTimeMs);
        calDeadline.set(6, calDeadline.get(6) + 1);
        calDeadline.set(14, 0);
        calDeadline.set(13, 0);
        calDeadline.set(12, 0);
        calDeadline.set(11, 1);
        this.mNextMinDailyDeadlineMs = calDeadline.getTimeInMillis();
        calDeadline.set(11, 3);
        this.mNextMaxDailyDeadlineMs = calDeadline.getTimeInMillis();
    }

    public void recordDailyStatsIfNeededLocked(boolean settled, long currentTimeMs) {
        if (currentTimeMs < this.mNextMaxDailyDeadlineMs) goto L5;
        recordDailyStatsLocked();
        return;
    L5:
        if (settled == false) goto L10;
        if (currentTimeMs < this.mNextMinDailyDeadlineMs) goto L10;
        recordDailyStatsLocked();
        return;
    L10:
        if (currentTimeMs >= (this.mDailyStartTimeMs - 86400000)) goto L15;
        recordDailyStatsLocked();
        return;
    }

    public void recordDailyStatsLocked() {
        BatteryStats.DailyItem item = new BatteryStats.DailyItem();
        item.mStartTime = this.mDailyStartTimeMs;
        item.mEndTime = this.mClock.currentTimeMillis();
        boolean hasData = false;
        if (this.mDailyDischargeStepTracker.mNumStepDurations <= 0) goto L6;
        hasData = true;
        item.mDischargeSteps = new BatteryStats.LevelStepTracker(this.mDailyDischargeStepTracker.mNumStepDurations, this.mDailyDischargeStepTracker.mStepDurations);
    L6:
        if (this.mDailyChargeStepTracker.mNumStepDurations <= 0) goto L9;
        hasData = true;
        item.mChargeSteps = new BatteryStats.LevelStepTracker(this.mDailyChargeStepTracker.mNumStepDurations, this.mDailyChargeStepTracker.mStepDurations);
    L9:
        if (this.mDailyPackageChanges == null) goto L11;
        hasData = true;
        item.mPackageChanges = this.mDailyPackageChanges;
        this.mDailyPackageChanges = null;
    L11:
        this.mDailyDischargeStepTracker.init();
        this.mDailyChargeStepTracker.init();
        updateDailyDeadlineLocked();
        if (hasData == false) goto L25;
        long startTimeMs = SystemClock.uptimeMillis();
        this.mDailyItems.add(item);
    L15:
        if (this.mDailyItems.size() <= 10) goto L17;
        this.mDailyItems.remove(0);
        goto L15
    L17:
        final ByteArrayOutputStream memStream = new ByteArrayOutputStream();
        TypedXmlSerializer out = Xml.resolveSerializer(memStream);     // Catch: IOException -> L20
        writeDailyItemsLocked(out);     // Catch: IOException -> L20
        final long initialTimeMs = SystemClock.uptimeMillis() - startTimeMs;     // Catch: IOException -> L20
        BackgroundThread.getHandler().post(new AnonymousClass8(this, memStream, initialTimeMs));     // Catch: IOException -> L20
        return;
    L21:
        return;
    }

    private void writeDailyItemsLocked(TypedXmlSerializer out) throws IOException {
        StringBuilder sb = new StringBuilder(64);
        out.startDocument(null, true);
        out.startTag(null, "daily-items");
        int i = 0;
    L4:
        if (i >= this.mDailyItems.size()) goto L16;
        BatteryStats.DailyItem dit = this.mDailyItems.get(i);
        out.startTag(null, com.android.server.pm.Settings.TAG_ITEM);
        out.attributeLong(null, IMediaProjectionManagerServiceExt.NODE_START, dit.mStartTime);
        out.attributeLong(null, "end", dit.mEndTime);
        writeDailyLevelSteps(out, "dis", dit.mDischargeSteps, sb);
        writeDailyLevelSteps(out, "chg", dit.mChargeSteps, sb);
        if (dit.mPackageChanges == null) goto L15;
        int j = 0;
    L9:
        if (j >= dit.mPackageChanges.size()) goto L15;
        BatteryStats.PackageChange pc = (BatteryStats.PackageChange) dit.mPackageChanges.get(j);
        if (pc.mUpdate == false) goto L13;
        out.startTag(null, "upd");
        out.attribute(null, SceneUtils.KEY_PKG, pc.mPackageName);
        out.attributeLong(null, "ver", pc.mVersionCode);
        out.endTag(null, "upd");
    L14:
        j = j + 1;
        goto L9
    L13:
        out.startTag(null, "rem");
        out.attribute(null, SceneUtils.KEY_PKG, pc.mPackageName);
        out.endTag(null, "rem");
    L15:
        out.endTag(null, com.android.server.pm.Settings.TAG_ITEM);
        i = i + 1;
        goto L4
    L16:
        out.endTag(null, "daily-items");
        out.endDocument();
    }

    private void writeDailyLevelSteps(TypedXmlSerializer out, String tag, BatteryStats.LevelStepTracker steps, StringBuilder tmpBuilder) throws IOException {
        if (steps == null) goto L10;
        out.startTag(null, tag);
        out.attributeInt(null, "n", steps.mNumStepDurations);
        int i = 0;
    L5:
        if (i >= steps.mNumStepDurations) goto L7;
        out.startTag(null, "s");
        tmpBuilder.setLength(0);
        steps.encodeEntryAt(i, tmpBuilder);
        out.attribute(null, "v", tmpBuilder.toString());
        out.endTag(null, "s");
        i = i + 1;
        goto L5
    L7:
        out.endTag(null, tag);
        return;
    }

    public void readDailyStatsLocked() {
        Slog.d(TAG, "Reading daily items from " + this.mDailyFile.getBaseFile());
        this.mDailyItems.clear();
        FileInputStream stream = this.mDailyFile.openRead();     // Catch: FileNotFoundException -> L20
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L9 IOException -> L11
        readDailyItemsLocked(parser);     // Catch: Throwable -> L9 IOException -> L11
        stream.close();     // Catch: IOException -> L7
    L24:
        return;
    L9:
        th = move-exception;
        stream.close();     // Catch: IOException -> L15
    L16:
        throw th;
    L17:
        stream.close();     // Catch: IOException -> L7
    L21:
        return;
    }

    private void readDailyItemsLocked(TypedXmlPullParser parser) {
    L48:
        int type = parser.next();     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        if (type == 2) goto L7;
        if (type != 1) goto L48;
    L7:
        if (type != 2) goto L40;
        int outerDepth = parser.getDepth();     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
    L9:
        int type2 = parser.next();     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        if (type2 == 1) goto L47;
        if (type2 == 3) goto L14;
    L29:
        if (type2 == 3) goto L9;
        if (type2 == 4) goto L9;
        String tagName = parser.getName();     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        if (tagName.equals(com.android.server.pm.Settings.TAG_ITEM) == false) goto L36;
        readDailyItemTagLocked(parser);     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        goto L9
    L36:
        Slog.w(TAG, "Unknown element under <daily-items>: " + parser.getName());     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        XmlUtils.skipCurrentTag(parser);     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        goto L9
    L14:
        if (parser.getDepth() > outerDepth) goto L29;
    L47:
        return;
    L40:
        throw new IllegalStateException("no start tag found");     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
    L18:
        e = move-exception;
        Slog.w(TAG, "Failed parsing daily " + e);
    L26:
        e = move-exception;
        Slog.w(TAG, "Failed parsing daily " + e);
    L16:
        e = move-exception;
        Slog.w(TAG, "Failed parsing daily " + e);
        return;
    L24:
        e = move-exception;
        Slog.w(TAG, "Failed parsing daily " + e);
    L22:
        e = move-exception;
        Slog.w(TAG, "Failed parsing daily " + e);
    L20:
        e = move-exception;
        Slog.w(TAG, "Failed parsing daily " + e);
        goto L47
    }

    void readDailyItemTagLocked(TypedXmlPullParser parser) throws NumberFormatException, XmlPullParserException, IOException {
        BatteryStats.DailyItem dit = new BatteryStats.DailyItem();
        dit.mStartTime = parser.getAttributeLong(null, IMediaProjectionManagerServiceExt.NODE_START, 0);
        dit.mEndTime = parser.getAttributeLong(null, "end", 0);
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L34;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("dis") == true) goto L16;
        if (tagName.equals("chg") == true) goto L19;
        if (tagName.equals("upd") == true) goto L23;
        if (tagName.equals("rem") == true) goto L29;
        Slog.w(TAG, "Unknown element under <item>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L29:
        if (dit.mPackageChanges != null) goto L31;
        dit.mPackageChanges = new ArrayList();
    L31:
        BatteryStats.PackageChange pc = new BatteryStats.PackageChange();
        pc.mUpdate = false;
        pc.mPackageName = parser.getAttributeValue(null, SceneUtils.KEY_PKG);
        dit.mPackageChanges.add(pc);
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L23:
        if (dit.mPackageChanges != null) goto L25;
        dit.mPackageChanges = new ArrayList();
    L25:
        BatteryStats.PackageChange pc2 = new BatteryStats.PackageChange();
        pc2.mUpdate = true;
        pc2.mPackageName = parser.getAttributeValue(null, SceneUtils.KEY_PKG);
        pc2.mVersionCode = parser.getAttributeLong(null, "ver", 0);
        dit.mPackageChanges.add(pc2);
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L19:
        readDailyItemTagDetailsLocked(parser, dit, true, "chg");
        goto L3
    L16:
        readDailyItemTagDetailsLocked(parser, dit, false, "dis");
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L34:
        this.mDailyItems.add(dit);
    }

    void readDailyItemTagDetailsLocked(TypedXmlPullParser parser, BatteryStats.DailyItem dit, boolean isCharge, String tag) throws NumberFormatException, XmlPullParserException, IOException {
        int num = parser.getAttributeInt(null, "n", -1);
        if (num != (-1)) goto L6;
        Slog.w(TAG, "Missing 'n' attribute at " + parser.getPositionDescription());
        XmlUtils.skipCurrentTag(parser);
        return;
    L6:
        BatteryStats.LevelStepTracker steps = new BatteryStats.LevelStepTracker(num);
        if (isCharge == false) goto L9;
        dit.mChargeSteps = steps;
    L10:
        int i = 0;
        int outerDepth = parser.getDepth();
    L11:
        int type = parser.next();
        if (type == 1) goto L31;
        if (type == 3) goto L16;
    L18:
        if (type == 3) goto L11;
        if (type == 4) goto L11;
        String tagName = parser.getName();
        if ("s".equals(tagName) == true) goto L24;
        Slog.w(TAG, "Unknown element under <" + tag + ">: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L11
    L24:
        if (i >= num) goto L11;
        String valueAttr = parser.getAttributeValue(null, "v");
        if (valueAttr == null) goto L11;
        steps.decodeEntryAt(i, valueAttr);
        i = i + 1;
        goto L11
    L16:
        if (parser.getDepth() > outerDepth) goto L18;
    L31:
        steps.mNumStepDurations = i;
        return;
    L9:
        dit.mDischargeSteps = steps;
        goto L10
    }

    public BatteryStats.DailyItem getDailyItemLocked(int daysAgo) {
        int index = (this.mDailyItems.size() - 1) - daysAgo;
        if (index >= 0) goto L7;
        return null;
    L7:
        return this.mDailyItems.get(index);
    }

    public long getCurrentDailyStartTime() {
        return this.mDailyStartTimeMs;
    }

    public long getNextMinDailyDeadline() {
        return this.mNextMinDailyDeadlineMs;
    }

    public long getNextMaxDailyDeadline() {
        return this.mNextMaxDailyDeadlineMs;
    }

    public int getHistoryTotalSize() {
        return this.mBatteryHistoryDirectory.getMaxHistorySize();
    }

    public int getHistoryUsedSize() {
        return this.mHistory.getHistoryUsedSize();
    }

    public BatteryStatsHistoryIterator iterateBatteryStatsHistory(long startTimeMs, long endTimeMs) {
        return this.mHistory.iterate(startTimeMs, endTimeMs);
    }

    public int getHistoryStringPoolSize() {
        return this.mHistory.getHistoryStringPoolSize();
    }

    public int getHistoryStringPoolBytes() {
        return this.mHistory.getHistoryStringPoolBytes();
    }

    public String getHistoryTagPoolString(int index) {
        return this.mHistory.getHistoryTagPoolString(index);
    }

    public int getHistoryTagPoolUid(int index) {
        return this.mHistory.getHistoryTagPoolUid(index);
    }

    public int getStartCount() {
        return this.mStartCount;
    }

    public boolean isOnBattery() {
        return this.mOnBattery;
    }

    public boolean isCharging() {
        return this.mCharging;
    }

    public boolean isScreenOn() {
        if (this.mScreenState != 2) goto L5;
    L10:
        return true;
    L5:
        if (this.mScreenState == 5) goto L10;
        if (this.mScreenState == 6) goto L10;
        return false;
    }

    void initTimes(long uptimeUs, long realtimeUs) {
        this.mStartClockTimeMs = this.mClock.currentTimeMillis();
        this.mOnBatteryTimeBase.init(uptimeUs, realtimeUs);
        this.mOnBatteryScreenOffTimeBase.init(uptimeUs, realtimeUs);
        this.mRealtimeUs = 0;
        this.mUptimeUs = 0;
        this.mRealtimeStartUs = realtimeUs;
        this.mUptimeStartUs = uptimeUs;
        this.mMonotonicStartTime = this.mMonotonicClock.monotonicTime();
    }

    void initDischarge(long elapsedRealtimeUs) {
        this.mLowDischargeAmountSinceCharge = 0;
        this.mHighDischargeAmountSinceCharge = 0;
        this.mDischargeAmountScreenOn = 0;
        this.mDischargeAmountScreenOnSinceCharge = 0;
        this.mDischargeAmountScreenOff = 0;
        this.mDischargeAmountScreenOffSinceCharge = 0;
        this.mDischargeAmountScreenDoze = 0;
        this.mDischargeAmountScreenDozeSinceCharge = 0;
        this.mDischargeStepTracker.init();
        this.mChargeStepTracker.init();
        this.mDischargeScreenOffCounter.reset(false, elapsedRealtimeUs);
        this.mDischargeScreenDozeCounter.reset(false, elapsedRealtimeUs);
        this.mDischargeLightDozeCounter.reset(false, elapsedRealtimeUs);
        this.mDischargeDeepDozeCounter.reset(false, elapsedRealtimeUs);
        this.mDischargeCounter.reset(false, elapsedRealtimeUs);
    }

    public void saveBatteryUsageStatsOnReset(BatteryUsageStatsProvider batteryUsageStatsProvider, PowerStatsStore powerStatsStore, boolean accumulateBatteryUsageStats) {
        this.mSaveBatteryUsageStatsOnReset = true;
        this.mBatteryUsageStatsProvider = batteryUsageStatsProvider;
        this.mPowerStatsStore = powerStatsStore;
        this.mAccumulateBatteryUsageStats = accumulateBatteryUsageStats;
    }

    public void resetBatteryHistoryOnNewSession(boolean enabled) {
        this.mResetBatteryHistoryOnNewSession = enabled;
    }

    public void setBatteryHistoryCompressionEnabled(boolean enabled) {
        this.mBatteryHistoryDirectory.setFileCompressionEnabled(enabled);
    }

    public void resetAllStatsAndHistoryLocked(int reason) {
        long mSecUptime = this.mClock.uptimeMillis();
        long uptimeUs = mSecUptime * 1000;
        long mSecRealtime = this.mClock.elapsedRealtime();
        long realtimeUs = mSecRealtime * 1000;
        resetAllStatsLocked(mSecUptime, mSecRealtime, reason);
        pullPendingStateUpdatesLocked();
        this.mHistory.writeHistoryItem(mSecRealtime, mSecUptime);
        int r12 = this.mBatteryLevel;
        this.mDischargePlugLevel = r12;
        this.mDischargeUnplugLevel = r12;
        this.mDischargeCurrentLevel = r12;
        this.mOnBatteryTimeBase.reset(uptimeUs, realtimeUs);
        this.mOnBatteryScreenOffTimeBase.reset(uptimeUs, realtimeUs);
        if (this.mBatteryPluggedIn == false) goto L5;
    L12:
        initActiveHistoryEventsLocked(mSecRealtime, mSecUptime);
        return;
    L5:
        if (Display.isOnState(this.mScreenState) == false) goto L8;
        this.mDischargeScreenOnUnplugLevel = this.mBatteryLevel;
        this.mDischargeScreenDozeUnplugLevel = 0;
        this.mDischargeScreenOffUnplugLevel = 0;
    L11:
        this.mDischargeAmountScreenOn = 0;
        this.mDischargeAmountScreenOff = 0;
        this.mDischargeAmountScreenDoze = 0;
        goto L12
    L8:
        if (Display.isDozeState(this.mScreenState) == false) goto L10;
        this.mDischargeScreenOnUnplugLevel = 0;
        this.mDischargeScreenDozeUnplugLevel = this.mBatteryLevel;
        this.mDischargeScreenOffUnplugLevel = 0;
        goto L11
    L10:
        this.mDischargeScreenOnUnplugLevel = 0;
        this.mDischargeScreenDozeUnplugLevel = 0;
        this.mDischargeScreenOffUnplugLevel = this.mBatteryLevel;
        goto L11
    }

    public void startNewSession(final int reason) {
        if (this.mMonotonicClock.monotonicTime() >= (this.mMonotonicStartTime + 60000)) goto L6;
        Slog.i(TAG, "Battery session session duration is too short, ignoring reset request");
        return;
    L6:
        this.mHandler.post(new BatteryStatsImpl$$ExternalSyntheticLambda7(this, reason));
    }

    private /* synthetic */ void lambda$startNewSession$2(int reason) {
        saveBatteryUsageStatsOnReset();
        monitor-enter(this);
        resetAllStatsLocked(this.mClock.uptimeMillis(), this.mClock.elapsedRealtime(), reason);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r8 = th;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L9
        throw r8;
    L11:
        th = move-exception;
        r8 = th;
        goto L13
    }

    private void resetAllStatsLocked(long uptimeMillis, long elapsedRealtimeMillis, int resetReason) {
        long uptimeUs = uptimeMillis * 1000;
        long elapsedRealtimeUs = 1000 * elapsedRealtimeMillis;
        this.mStartCount = 0;
        initTimes(uptimeUs, elapsedRealtimeUs);
        this.mScreenOnTimer.reset(false, elapsedRealtimeUs);
        this.mScreenDozeTimer.reset(false, elapsedRealtimeUs);
        int i = 0;
    L4:
        if (i >= 5) goto L6;
        this.mScreenBrightnessTimer[i].reset(false, elapsedRealtimeUs);
        i = i + 1;
        goto L4
    L6:
        int numDisplays = this.mPerDisplayBatteryStats.length;
        int i2 = 0;
    L7:
        if (i2 >= numDisplays) goto L10;
        this.mPerDisplayBatteryStats[i2].reset(elapsedRealtimeUs);
        i2 = i2 + 1;
        goto L7
    L10:
        if (this.mPowerProfile == null) goto L12;
        this.mEstimatedBatteryCapacityMah = (int) this.mPowerProfile.getBatteryCapacity();
    L13:
        this.mLastLearnedBatteryCapacityUah = -1;
        this.mMinLearnedBatteryCapacityUah = -1;
        this.mMaxLearnedBatteryCapacityUah = -1;
        this.mInteractiveTimer.reset(false, elapsedRealtimeUs);
        this.mPowerSaveModeEnabledTimer.reset(false, elapsedRealtimeUs);
        this.mLastIdleTimeStartMs = elapsedRealtimeMillis;
        this.mLongestLightIdleTimeMs = 0;
        this.mLongestFullIdleTimeMs = 0;
        this.mDeviceIdleModeLightTimer.reset(false, elapsedRealtimeUs);
        this.mDeviceIdleModeFullTimer.reset(false, elapsedRealtimeUs);
        this.mDeviceLightIdlingTimer.reset(false, elapsedRealtimeUs);
        this.mDeviceIdlingTimer.reset(false, elapsedRealtimeUs);
        this.mPhoneOnTimer.reset(false, elapsedRealtimeUs);
        this.mAudioOnTimer.reset(false, elapsedRealtimeUs);
        this.mVideoOnTimer.reset(false, elapsedRealtimeUs);
        this.mFlashlightOnTimer.reset(false, elapsedRealtimeUs);
        this.mCameraOnTimer.reset(false, elapsedRealtimeUs);
        this.mBluetoothScanTimer.reset(false, elapsedRealtimeUs);
        int i3 = 0;
    L15:
        if (i3 >= CELL_SIGNAL_STRENGTH_LEVEL_COUNT) goto L17;
        this.mPhoneSignalStrengthsTimer[i3].reset(false, elapsedRealtimeUs);
        i3 = i3 + 1;
        goto L15
    L17:
        this.mPhoneSignalScanningTimer.reset(false, elapsedRealtimeUs);
        int i4 = 0;
    L19:
        if (i4 >= BatteryStats.NUM_DATA_CONNECTION_TYPES) goto L21;
        this.mPhoneDataConnectionsTimer[i4].reset(false, elapsedRealtimeUs);
        i4 = i4 + 1;
        goto L19
    L21:
        this.mNrNsaTimer.reset(false, elapsedRealtimeUs);
        int i5 = 0;
    L23:
        if (i5 >= 10) goto L25;
        this.mNetworkByteActivityCounters[i5].reset(false, elapsedRealtimeUs);
        this.mNetworkPacketActivityCounters[i5].reset(false, elapsedRealtimeUs);
        i5 = i5 + 1;
        goto L23
    L25:
        int i6 = 0;
    L27:
        if (i6 >= 3) goto L33;
        RadioAccessTechnologyBatteryStats stats = this.mPerRatBatteryStats[i6];
        if (stats == null) goto L32;
        stats.reset(elapsedRealtimeUs);
    L32:
        i6 = i6 + 1;
        goto L27
    L33:
        this.mMobileRadioActiveTimer.reset(false, elapsedRealtimeUs);
        this.mMobileRadioActivePerAppTimer.reset(false, elapsedRealtimeUs);
        this.mMobileRadioActiveAdjustedTime.reset(false, elapsedRealtimeUs);
        this.mMobileRadioActiveUnknownTime.reset(false, elapsedRealtimeUs);
        this.mMobileRadioActiveUnknownCount.reset(false, elapsedRealtimeUs);
        this.mWifiOnTimer.reset(false, elapsedRealtimeUs);
        this.mGlobalWifiRunningTimer.reset(false, elapsedRealtimeUs);
        int i7 = 0;
    L35:
        if (i7 >= 8) goto L37;
        this.mWifiStateTimer[i7].reset(false, elapsedRealtimeUs);
        i7 = i7 + 1;
        goto L35
    L37:
        int i8 = 0;
    L39:
        if (i8 >= 13) goto L41;
        this.mWifiSupplStateTimer[i8].reset(false, elapsedRealtimeUs);
        i8 = i8 + 1;
        goto L39
    L41:
        int i9 = 0;
    L42:
        if (i9 >= 5) goto L44;
        this.mWifiSignalStrengthsTimer[i9].reset(false, elapsedRealtimeUs);
        i9 = i9 + 1;
        goto L42
    L44:
        this.mWifiMulticastWakelockTimer.reset(false, elapsedRealtimeUs);
        this.mWifiActiveTimer.reset(false, elapsedRealtimeUs);
        this.mWifiActivity.reset(false, elapsedRealtimeUs);
        int i10 = 0;
    L46:
        if (i10 >= this.mGpsSignalQualityTimer.length) goto L48;
        this.mGpsSignalQualityTimer[i10].reset(false, elapsedRealtimeUs);
        i10 = i10 + 1;
        goto L46
    L48:
        this.mBluetoothActivity.reset(false, elapsedRealtimeUs);
        this.mModemActivity.reset(false, elapsedRealtimeUs);
        this.mNumConnectivityChange = 0;
        int i11 = 0;
    L50:
        if (i11 >= this.mUidStats.size()) goto L60;
        Uid uid = this.mUidStats.valueAt(i11);
        if (uid == null) goto L58;
        if (uid.reset(uptimeUs, elapsedRealtimeUs, resetReason) == false) goto L58;
        this.mUidStats.valueAt(i11).detachFromTimeBase();
        this.mUidStats.remove(this.mUidStats.keyAt(i11));
        i11 = i11 - 1;
    L58:
        i11 = i11 + 1;
        goto L50
    L60:
        if (this.mRpmStats.size() <= 0) goto L67;
        Iterator<SamplingTimer> r3 = this.mRpmStats.values().iterator();
    L63:
        if (r3.hasNext() == false) goto L65;
        SamplingTimer timer = r3.next();
        this.mOnBatteryTimeBase.remove(timer);
        goto L63
    L65:
        this.mRpmStats.clear();
    L67:
        if (this.mScreenOffRpmStats.size() <= 0) goto L74;
        Iterator<SamplingTimer> r4 = this.mScreenOffRpmStats.values().iterator();
    L70:
        if (r4.hasNext() == false) goto L72;
        SamplingTimer timer2 = r4.next();
        this.mOnBatteryScreenOffTimeBase.remove(timer2);
        goto L70
    L72:
        this.mScreenOffRpmStats.clear();
    L74:
        if (this.mKernelWakelockStats.size() <= 0) goto L81;
        Iterator<SamplingTimer> r5 = this.mKernelWakelockStats.values().iterator();
    L77:
        if (r5.hasNext() == false) goto L79;
        SamplingTimer timer3 = r5.next();
        this.mOnBatteryScreenOffTimeBase.remove(timer3);
        goto L77
    L79:
        this.mKernelWakelockStats.clear();
    L81:
        if (this.mKernelMemoryStats.size() <= 0) goto L88;
        int i12 = 0;
    L84:
        if (i12 >= this.mKernelMemoryStats.size()) goto L86;
        this.mOnBatteryTimeBase.remove(this.mKernelMemoryStats.valueAt(i12));
        i12 = i12 + 1;
        goto L84
    L86:
        this.mKernelMemoryStats.clear();
    L88:
        if (this.mWakeupReasonStats.size() <= 0) goto L94;
        Iterator<SamplingTimer> r6 = this.mWakeupReasonStats.values().iterator();
    L91:
        if (r6.hasNext() == false) goto L93;
        SamplingTimer timer4 = r6.next();
        this.mOnBatteryTimeBase.remove(timer4);
        goto L91
    L93:
        this.mWakeupReasonStats.clear();
    L94:
        this.mStepDetailsProvider.reset();
        if (this.mTmpRailStats == null) goto L97;
        this.mTmpRailStats.reset();
    L97:
        EnergyConsumerStats.resetIfNotNull(this.mGlobalEnergyConsumerStats);
        this.mNumAllUidCpuTimeReads = 0;
        this.mNumUidsRemoved = 0;
        initDischarge(elapsedRealtimeUs);
        if (resetReason == 3) goto L101;
        if (resetReason == 5) goto L101;
    L102:
        this.mHistory.reset();
    L103:
        writeSyncLocked();
        if (this.mPowerStatsCollectorEnabled.get(1) == false) goto L106;
        schedulePowerStatsSampleCollection();
    L106:
        this.mIgnoreNextExternalStats = true;
        this.mExternalSync.scheduleSync("reset", 255);
        this.mHandler.sendEmptyMessage(4);
        return;
    L101:
        if (this.mResetBatteryHistoryOnNewSession == false) goto L103;
    L12:
        this.mEstimatedBatteryCapacityMah = -1;
        goto L13
    }

    private void saveBatteryUsageStatsOnReset() {
        if (this.mSaveBatteryUsageStatsOnReset == true) goto L6;
        return;
    L6:
        if (this.mAccumulateBatteryUsageStats == false) goto L8;
        this.mBatteryUsageStatsProvider.accumulateBatteryUsageStats(getBatteryStatsSession(), this.mHandler);
        return;
    L8:
        monitor-enter(this);
        BatteryUsageStats batteryUsageStats = this.mBatteryUsageStatsProvider.getBatteryUsageStats(this, new BatteryUsageStatsQuery.Builder().setMaxStatsAgeMs(0).includePowerModels().includeProcessStateData().build());     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        long monotonicStartTime = this.mMonotonicClock.monotonicTime() - batteryUsageStats.getStatsDuration();
        commitMonotonicClock();
        this.mPowerStatsStore.storeBatteryUsageStatsAsync(monotonicStartTime, batteryUsageStats);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void initActiveHistoryEventsLocked(long elapsedRealtimeMs, long uptimeMs) {
        int i = 0;
    L4:
        if (i >= 23) goto L23;
        if (this.mRecordAllHistory == false) goto L8;
    L10:
        HashMap<String, SparseIntArray> active = this.mActiveEvents.getStateForEvent(i);
        if (active == null) goto L21;
        Iterator<Map.Entry<String, SparseIntArray>> r9 = active.entrySet().iterator();
    L15:
        if (r9.hasNext() == false) goto L21;
        Map.Entry<String, SparseIntArray> ent = r9.next();
        SparseIntArray uids = ent.getValue();
        int j = 0;
    L18:
        if (j >= uids.size()) goto L15;
        this.mHistory.recordEvent(elapsedRealtimeMs, uptimeMs, i, ent.getKey(), uids.keyAt(j));
        j = j + 1;
    L21:
        i = i + 1;
        goto L4
    L8:
        if (i != 1) goto L10;
    }

    void updateDischargeScreenLevelsLocked(int oldState, int newState) {
        updateOldDischargeScreenLevelLocked(oldState);
        updateNewDischargeScreenLevelLocked(newState);
    }

    private void updateOldDischargeScreenLevelLocked(int state) {
        if (Display.isOnState(state) == false) goto L9;
        int diff = this.mDischargeScreenOnUnplugLevel - this.mDischargeCurrentLevel;
        if (diff <= 0) goto L22;
        this.mDischargeAmountScreenOn += diff;
        this.mDischargeAmountScreenOnSinceCharge += diff;
        return;
    L22:
        return;
    L9:
        if (Display.isDozeState(state) == false) goto L15;
        int diff2 = this.mDischargeScreenDozeUnplugLevel - this.mDischargeCurrentLevel;
        if (diff2 <= 0) goto L24;
        this.mDischargeAmountScreenDoze += diff2;
        this.mDischargeAmountScreenDozeSinceCharge += diff2;
        return;
    L24:
        return;
    L15:
        if (Display.isOffState(state) == false) goto L25;
        int diff3 = this.mDischargeScreenOffUnplugLevel - this.mDischargeCurrentLevel;
        if (diff3 <= 0) goto L20;
        this.mDischargeAmountScreenOff += diff3;
        this.mDischargeAmountScreenOffSinceCharge += diff3;
        return;
    L20:
        return;
    }

    private void updateNewDischargeScreenLevelLocked(int state) {
        if (Display.isOnState(state) == false) goto L6;
        this.mDischargeScreenOnUnplugLevel = this.mDischargeCurrentLevel;
        this.mDischargeScreenOffUnplugLevel = 0;
        this.mDischargeScreenDozeUnplugLevel = 0;
        return;
    L6:
        if (Display.isDozeState(state) == false) goto L9;
        this.mDischargeScreenOnUnplugLevel = 0;
        this.mDischargeScreenDozeUnplugLevel = this.mDischargeCurrentLevel;
        this.mDischargeScreenOffUnplugLevel = 0;
        return;
    L9:
        if (Display.isOffState(state) == false) goto L14;
        this.mDischargeScreenOnUnplugLevel = 0;
        this.mDischargeScreenDozeUnplugLevel = 0;
        this.mDischargeScreenOffUnplugLevel = this.mDischargeCurrentLevel;
        return;
    }

    public void pullPendingStateUpdatesLocked() {
        if (this.mOnBatteryInternal == false) goto L6;
        updateDischargeScreenLevelsLocked(this.mScreenState, this.mScreenState);
        return;
    }

    protected NetworkStats readMobileNetworkStatsLocked(NetworkStatsManager networkStatsManager) {
        return networkStatsManager.getMobileUidStats();
    }

    protected NetworkStats readWifiNetworkStatsLocked(NetworkStatsManager networkStatsManager) {
        return networkStatsManager.getWifiUidStats();
    }

    protected NetworkStats networkStatsDelta(NetworkStats stats, NetworkStats oldStats) {
        if (oldStats != null) goto L5;
        return stats;
    L5:
        return stats.subtract(oldStats);
    }

    public void updateWifiState(WifiActivityEnergyInfo info, long consumedChargeUC, long elapsedRealtimeMs, long uptimeMs, NetworkStatsManager networkStatsManager) {
        Object r2 = this.mWifiNetworkLock;
        monitor-enter(r2);
        NetworkStats latestStats = readWifiNetworkStatsLocked(networkStatsManager);     // Catch: Throwable -> L8
        if (latestStats == null) goto L10;
        NetworkStats delta = networkStatsDelta(latestStats, this.mLastWifiNetworkStats);     // Catch: Throwable -> L8
        this.mLastWifiNetworkStats = latestStats;     // Catch: Throwable -> L8
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L8
        updateWifiBatteryStats(info, delta, consumedChargeUC, elapsedRealtimeMs, uptimeMs);
        return;
    L10:
        delta = null;
    L8:
        th = move-exception;
        throw th;
    }

    private void onWifiPowerStatsRetrieved(WifiActivityEnergyInfo wifiActivityEnergyInfo, NetworkStats networkStatsDelta, long elapsedRealtimeMs, long uptimeMs) {
        updateWifiBatteryStats(wifiActivityEnergyInfo, networkStatsDelta, -1, elapsedRealtimeMs, uptimeMs);
    }

    private void updateWifiBatteryStats(WifiActivityEnergyInfo info, NetworkStats delta, long consumedChargeUC, long elapsedRealtimeMs, long uptimeMs) {
        monitor-enter(this);
    L17:
        th = th;
    L185:
        monitor-exit(this);     // Catch: Throwable -> L86
        throw th;
    L5:
        if (this.mOnBatteryInternal == false) goto L183;
        if (this.mIgnoreNextExternalStats == true) goto L183;
        long r9 = 0;
        if (this.mGlobalEnergyConsumerStats != null) goto L12;
    L19:
        SparseDoubleArray r0 = null;
    L16:
        SparseDoubleArray uidEstimatedConsumptionMah = r0;
        double totalEstimatedConsumptionMah = 0.0d;
        SparseLongArray rxPackets = new SparseLongArray();     // Catch: Throwable -> L17
        SparseLongArray txPackets = new SparseLongArray();     // Catch: Throwable -> L17
        SparseLongArray rxTimesMs = new SparseLongArray();     // Catch: Throwable -> L17
        SparseLongArray txTimesMs = new SparseLongArray();     // Catch: Throwable -> L17
        if (delta != null) goto L199;
        long r24 = 0;
        long r8 = elapsedRealtimeMs;
        SparseLongArray txTimesMs2 = txTimesMs;
        long totalTxPackets = 0;
        long totalRxPackets = 0;
    L80:
        if (info != null) goto L197;
        BatteryStatsImpl r7 = this;
        long r3 = r8;
    L174:
        if (uidEstimatedConsumptionMah == null) goto L180;
        r7.mGlobalEnergyConsumerStats.updateStandardBucket(4, consumedChargeUC);     // Catch: Throwable -> L86
        if (r7.mHasWifiReporting == true) goto L178;
        long globalTimeMs = r7.mGlobalWifiRunningTimer.getTimeSinceMarkLocked(r3 * 1000) / 1000;     // Catch: Throwable -> L86
        r7.mGlobalWifiRunningTimer.setMark(r3);     // Catch: Throwable -> L86
        totalEstimatedConsumptionMah = r7.mWifiPowerCalculator.calcGlobalPowerWithoutControllerDataMah(globalTimeMs);     // Catch: Throwable -> L86
    L178:
        r7.distributeEnergyToUidsLocked(4, consumedChargeUC, uidEstimatedConsumptionMah, totalEstimatedConsumptionMah, r3);     // Catch: Throwable -> L86
    L180:
        monitor-exit(this);     // Catch: Throwable -> L86
        return;
    L197:
        this.mHasWifiReporting = true;     // Catch: Throwable -> L171
        long txTimeMs = info.getControllerTxDurationMillis();     // Catch: Throwable -> L171
        long rxTimeMs = info.getControllerRxDurationMillis();     // Catch: Throwable -> L171
        long r2 = info.getControllerScanDurationMillis();     // Catch: Throwable -> L171
        long idleTimeMs = info.getControllerIdleDurationMillis();     // Catch: Throwable -> L171
        long r35 = (txTimeMs + rxTimeMs) + idleTimeMs;     // Catch: Throwable -> L171
        long leftOverTxTimeMs = txTimeMs;
        long leftOverRxTimeMs = rxTimeMs;
        int uidStatsSize = this.mUidStats.size();     // Catch: Throwable -> L171
        int i = 0;
        long totalScanTimeMs = 0;
        long totalScanTimeMs2 = 0;
    L84:
        if (i >= uidStatsSize) goto L88;
        Uid uid = this.mUidStats.valueAt(i);     // Catch: Throwable -> L86
        totalScanTimeMs = totalScanTimeMs + (uid.mWifiScanTimer.getTimeSinceMarkLocked(r8 * 1000) / 1000);     // Catch: Throwable -> L86
        totalScanTimeMs2 = totalScanTimeMs2 + (uid.mFullWifiLockTimer.getTimeSinceMarkLocked(r8 * 1000) / 1000);     // Catch: Throwable -> L86
        i = i + 1;     // Catch: Throwable -> L86
        leftOverTxTimeMs = leftOverTxTimeMs;
    L86:
        th = th;
        goto L185
    L88:
        long leftOverTxTimeMs2 = leftOverTxTimeMs;
        int i2 = 0;
    L89:
        if (i2 >= uidStatsSize) goto L110;
        Uid uid2 = this.mUidStats.valueAt(i2);     // Catch: Throwable -> L86
        long scanTimeSinceMarkMs = uid2.mWifiScanTimer.getTimeSinceMarkLocked(r8 * 1000) / 1000;     // Catch: Throwable -> L86
        if (scanTimeSinceMarkMs <= r24) goto L101;
        uid2.mWifiScanTimer.setMark(r8);     // Catch: Throwable -> L86
        if (totalScanTimeMs <= rxTimeMs) goto L95;
        long scanRxTimeSinceMarkMs = (rxTimeMs * scanTimeSinceMarkMs) / totalScanTimeMs;     // Catch: Throwable -> L86
        long scanRxTimeSinceMarkMs2 = scanRxTimeSinceMarkMs;
    L97:
        if (totalScanTimeMs <= txTimeMs) goto L99;
        long scanTxTimeSinceMarkMs = (txTimeMs * scanTimeSinceMarkMs) / totalScanTimeMs;     // Catch: Throwable -> L86
        long scanTimeSinceMarkMs2 = scanTxTimeSinceMarkMs;
    L100:
        int i3 = uid2.getUid();     // Catch: Throwable -> L86
        rxTimesMs.incrementValue(i3, scanRxTimeSinceMarkMs2);     // Catch: Throwable -> L86
        txTimesMs2.incrementValue(uid2.getUid(), scanTimeSinceMarkMs2);     // Catch: Throwable -> L86
        leftOverRxTimeMs = leftOverRxTimeMs - scanRxTimeSinceMarkMs2;     // Catch: Throwable -> L86
        leftOverTxTimeMs2 = leftOverTxTimeMs2 - scanTimeSinceMarkMs2;     // Catch: Throwable -> L86
        long scanRxTimeSinceMarkMs3 = scanRxTimeSinceMarkMs2;
        long scanTxTimeSinceMarkMs2 = scanTimeSinceMarkMs2;
    L102:
        long wifiLockTimeSinceMarkMs = uid2.mFullWifiLockTimer.getTimeSinceMarkLocked(r8 * 1000) / 1000;     // Catch: Throwable -> L86
        if (wifiLockTimeSinceMarkMs <= r24) goto L105;
        uid2.mFullWifiLockTimer.setMark(r8);     // Catch: Throwable -> L86
        long myIdleTimeMs = (wifiLockTimeSinceMarkMs * idleTimeMs) / totalScanTimeMs2;     // Catch: Throwable -> L86
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7771$$Nest$mgetOrCreateIdleTimeCounter(uid2.getOrCreateWifiControllerActivityLocked()), myIdleTimeMs, r8);     // Catch: Throwable -> L86
        long myIdleTimeMs2 = myIdleTimeMs;
    L106:
        if (uidEstimatedConsumptionMah == null) goto L108;
        double uidEstMah = this.mWifiPowerCalculator.calcPowerFromControllerDataMah(scanRxTimeSinceMarkMs3, scanTxTimeSinceMarkMs2, myIdleTimeMs2);     // Catch: Throwable -> L86
        uidEstimatedConsumptionMah.incrementValue(uid2.getUid(), uidEstMah);     // Catch: Throwable -> L86
    L108:
        i2 = i2 + 1;     // Catch: Throwable -> L86
        uidStatsSize = uidStatsSize;
        goto L89
    L105:
        myIdleTimeMs2 = 0;
        goto L106
    L99:
        scanTimeSinceMarkMs2 = scanTimeSinceMarkMs;
        goto L100
    L95:
        scanRxTimeSinceMarkMs2 = scanTimeSinceMarkMs;
        goto L97
    L101:
        uidStatsSize = uidStatsSize;
        scanRxTimeSinceMarkMs3 = scanTimeSinceMarkMs;
        scanTxTimeSinceMarkMs2 = scanTimeSinceMarkMs;
        goto L102
    L110:
        if (totalTxPackets == r24) goto L118;
        if (leftOverTxTimeMs2 == r24) goto L118;
        int i4 = 0;
    L115:
        if (i4 >= txPackets.size()) goto L118;
        txTimesMs2.incrementValue(txPackets.keyAt(i4), (txPackets.valueAt(i4) * leftOverTxTimeMs2) / totalTxPackets);     // Catch: Throwable -> L86
        i4 = i4 + 1;     // Catch: Throwable -> L86
    L118:
        if (totalRxPackets != r24) goto L120;
    L126:
        int i5 = 0;
    L127:
        if (i5 >= txTimesMs2.size()) goto L138;
        int uid3 = txTimesMs2.keyAt(i5);     // Catch: Throwable -> L136
        long myTxTimeMs = txTimesMs2.valueAt(i5);     // Catch: Throwable -> L136
        long r4 = r8;
        int i6 = i5;
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7773$$Nest$mgetOrCreateTxTimeCounters(getUidStatsLocked(uid3, r4, uptimeMs).getOrCreateWifiControllerActivityLocked())[0], myTxTimeMs, r4);     // Catch: Throwable -> L86
        if (uidEstimatedConsumptionMah == null) goto L135;
        uidEstimatedConsumptionMah.incrementValue(uid3, this.mWifiPowerCalculator.calcPowerFromControllerDataMah(0, myTxTimeMs, 0));     // Catch: Throwable -> L86
    L135:
        i5 = i6 + 1;
        r8 = r4;
    L136:
        th = th;
        goto L185
    L138:
        long r5 = r8;
        int i7 = 0;
    L195:
    L169:
        th = th;
        goto L185
    L140:
        if (i7 >= rxTimesMs.size()) goto L146;
        int uid4 = rxTimesMs.keyAt(i7);     // Catch: Throwable -> L86
        long myRxTimeMs = rxTimesMs.valueAt(i7);     // Catch: Throwable -> L86
        SparseLongArray txTimesMs3 = txTimesMs2;
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7772$$Nest$mgetOrCreateRxTimeCounter(getUidStatsLocked(rxTimesMs.keyAt(i7), r5, uptimeMs).getOrCreateWifiControllerActivityLocked()), myRxTimeMs, r5);     // Catch: Throwable -> L86
        if (uidEstimatedConsumptionMah == null) goto L144;
        uidEstimatedConsumptionMah.incrementValue(uid4, this.mWifiPowerCalculator.calcPowerFromControllerDataMah(myRxTimeMs, 0, 0));     // Catch: Throwable -> L86
    L144:
        i7 = i7 + 1;
        txTimesMs2 = txTimesMs3;
        goto L195
    L146:
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7772$$Nest$mgetOrCreateRxTimeCounter(this.mWifiActivity), info.getControllerRxDurationMillis(), r5);     // Catch: Throwable -> L169
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7773$$Nest$mgetOrCreateTxTimeCounters(this.mWifiActivity)[0], info.getControllerTxDurationMillis(), r5);     // Catch: Throwable -> L169
        this.mWifiActivity.m7777getScanTimeCounter().addCountLocked(info.getControllerScanDurationMillis());     // Catch: Throwable -> L169
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7771$$Nest$mgetOrCreateIdleTimeCounter(this.mWifiActivity), info.getControllerIdleDurationMillis(), r5);     // Catch: Throwable -> L169
        double opVolt = this.mPowerProfile.getAveragePower("wifi.controller.voltage") / 1000.0d;
        if (opVolt == 0.0d) goto L151;
        double controllerMaMs = info.getControllerEnergyUsedMicroJoules() / opVolt;     // Catch: Throwable -> L86
        this.mWifiActivity.m7776getPowerCounter().addCountLocked((long) controllerMaMs);     // Catch: Throwable -> L86
        double controllerMaMs2 = controllerMaMs;
    L153:
        if (this.mTmpRailStats != null) goto L155;
    L157:
        long monitoredRailChargeConsumedMaMs = r24;
        this.mWifiActivity.m7775getMonitoredRailChargeConsumedMaMs().addCountLocked(monitoredRailChargeConsumedMaMs);     // Catch: Throwable -> L169
        r7 = this;
        this.mHistory.recordWifiConsumedCharge(r5, uptimeMs, monitoredRailChargeConsumedMaMs / MILLISECONDS_IN_HOUR);     // Catch: Throwable -> L167
        r3 = r5;
        if (r7.mTmpRailStats == null) goto L165;
        r7.mTmpRailStats.resetWifiTotalEnergyUsed();     // Catch: Throwable -> L86
    L165:
        if (uidEstimatedConsumptionMah == null) goto L174;
        totalEstimatedConsumptionMah = Math.max(controllerMaMs2 / MILLISECONDS_IN_HOUR, r7.mWifiPowerCalculator.calcPowerFromControllerDataMah(rxTimeMs, txTimeMs, idleTimeMs));     // Catch: Throwable -> L86
    L167:
        th = th;
        goto L185
    L155:
        r24 = (long) (this.mTmpRailStats.getWifiTotalEnergyUseduWs() / opVolt);
        goto L157
    L151:
        controllerMaMs2 = 0.0d;
        goto L153
    L120:
        if (leftOverRxTimeMs == r24) goto L126;
        int i8 = 0;
    L123:
        if (i8 >= rxPackets.size()) goto L126;
        rxTimesMs.incrementValue(rxPackets.keyAt(i8), (rxPackets.valueAt(i8) * leftOverRxTimeMs) / totalRxPackets);     // Catch: Throwable -> L86
        i8 = i8 + 1;
    L171:
        th = th;
        goto L185
    L199:
        Iterator r18 = delta.iterator();     // Catch: Throwable -> L76
        totalTxPackets = 0;
        totalRxPackets = 0;
    L25:
        if (r18.hasNext() == false) goto L78;
        NetworkStats.Entry entry = (NetworkStats.Entry) r18.next();     // Catch: Throwable -> L76
        if (entry.getRxBytes() != r9) goto L33;
        if (entry.getTxBytes() == r9) goto L25;
    L33:
        int uid5 = mapUid(entry.getUid());     // Catch: Throwable -> L76
        long r25 = r9;
        SparseLongArray txTimesMs4 = txTimesMs;
        Uid u = getUidStatsLocked(uid5, elapsedRealtimeMs, uptimeMs);     // Catch: Throwable -> L74
        if (entry.getRxBytes() == r25) goto L44;
        u.noteNetworkActivityLocked(2, entry.getRxBytes(), entry.getRxPackets());     // Catch: Throwable -> L17
        if (entry.getSet() != 0) goto L42;
        u.noteNetworkActivityLocked(8, entry.getRxBytes(), entry.getRxPackets());     // Catch: Throwable -> L17
    L42:
        this.mNetworkByteActivityCounters[2].addCountLocked(entry.getRxBytes());     // Catch: Throwable -> L17
        this.mNetworkPacketActivityCounters[2].addCountLocked(entry.getRxPackets());     // Catch: Throwable -> L17
        rxPackets.incrementValue(uid5, entry.getRxPackets());     // Catch: Throwable -> L17
        totalRxPackets = totalRxPackets + entry.getRxPackets();     // Catch: Throwable -> L17
    L44:
        if (entry.getTxBytes() == r25) goto L50;
        u.noteNetworkActivityLocked(3, entry.getTxBytes(), entry.getTxPackets());     // Catch: Throwable -> L17
        if (entry.getSet() != 0) goto L49;
        u.noteNetworkActivityLocked(9, entry.getTxBytes(), entry.getTxPackets());     // Catch: Throwable -> L17
    L49:
        this.mNetworkByteActivityCounters[3].addCountLocked(entry.getTxBytes());     // Catch: Throwable -> L17
        this.mNetworkPacketActivityCounters[3].addCountLocked(entry.getTxPackets());     // Catch: Throwable -> L17
        txPackets.incrementValue(uid5, entry.getTxPackets());     // Catch: Throwable -> L17
        totalTxPackets = totalTxPackets + entry.getTxPackets();     // Catch: Throwable -> L17
    L51:
        if (uidEstimatedConsumptionMah == null) goto L73;
        if (info != null) goto L73;
        if (this.mHasWifiReporting == true) goto L73;
        long uidRunningMs = u.mWifiRunningTimer.getTimeSinceMarkLocked(elapsedRealtimeMs * 1000) / 1000;     // Catch: Throwable -> L17
        if (uidRunningMs <= r25) goto L58;
        u.mWifiRunningTimer.setMark(elapsedRealtimeMs);     // Catch: Throwable -> L17
    L58:
        long uidScanMs = u.mWifiScanTimer.getTimeSinceMarkLocked(elapsedRealtimeMs * 1000) / 1000;     // Catch: Throwable -> L17
        if (uidScanMs <= r25) goto L61;
        u.mWifiScanTimer.setMark(elapsedRealtimeMs);     // Catch: Throwable -> L17
    L61:
        int bn = 0;
        long uidBatchScanMs = 0;
    L63:
        if (bn >= 5) goto L72;
        if (u.mWifiBatchedScanTimer[bn] == null) goto L70;
        int bn2 = bn;
        long bnMs = u.mWifiBatchedScanTimer[bn].getTimeSinceMarkLocked(elapsedRealtimeMs * 1000) / 1000;     // Catch: Throwable -> L17
        if (bnMs <= r25) goto L69;
        u.mWifiBatchedScanTimer[bn2].setMark(elapsedRealtimeMs);     // Catch: Throwable -> L17
    L69:
        uidBatchScanMs = uidBatchScanMs + bnMs;     // Catch: Throwable -> L17
    L71:
        bn = bn2 + 1;     // Catch: Throwable -> L17
        goto L63
    L70:
        bn2 = bn;
        goto L71
    L72:
        uidEstimatedConsumptionMah.incrementValue(u.getUid(), this.mWifiPowerCalculator.calcPowerWithoutControllerDataMah(entry.getRxPackets(), entry.getTxPackets(), uidRunningMs, uidScanMs, uidBatchScanMs));     // Catch: Throwable -> L17
    L73:
        txTimesMs = txTimesMs4;
        r9 = r25;
        goto L25
    L50:
        u = u;
    L74:
        th = th;
        goto L185
    L78:
        r24 = r9;
        txTimesMs2 = txTimesMs;
        r8 = elapsedRealtimeMs;
    L76:
        th = th;
        goto L185
    L12:
        if (this.mWifiPowerCalculator == null) goto L19;
        if (consumedChargeUC <= 0) goto L19;
        r0 = new SparseDoubleArray();     // Catch: Throwable -> L17
    L183:
        monitor-exit(this);     // Catch: Throwable -> L17
    }

    public void noteModemControllerActivity(ModemActivityInfo activityInfo, long consumedChargeUC, long elapsedRealtimeMs, long uptimeMs, NetworkStatsManager networkStatsManager) {
        if (this.mLastModemActivityInfo != null) goto L7;
        if (activityInfo != null) goto L6;
        ModemActivityInfo r0 = null;
    L8:
        ModemActivityInfo deltaInfo = r0;
        this.mLastModemActivityInfo = activityInfo;
        NetworkStats delta = null;
        Object r3 = this.mModemNetworkLock;
        monitor-enter(r3);
        NetworkStats latestStats = readMobileNetworkStatsLocked(networkStatsManager);     // Catch: Throwable -> L14
        if (latestStats == null) goto L16;
        delta = networkStatsDelta(latestStats, this.mLastModemNetworkStats);     // Catch: Throwable -> L14
        this.mLastModemNetworkStats = latestStats;     // Catch: Throwable -> L14
    L16:
        monitor-exit(r3);     // Catch: Throwable -> L14
        updateCellularBatteryStats(deltaInfo, delta, consumedChargeUC, elapsedRealtimeMs, uptimeMs);
        return;
    L14:
        th = move-exception;
        throw th;
    L6:
        r0 = activityInfo.getDelta(activityInfo);
        goto L8
    L7:
        r0 = this.mLastModemActivityInfo.getDelta(activityInfo);
        goto L8
    }

    private void onMobileRadioPowerStatsRetrieved(ModemActivityInfo modemActivityInfo, NetworkStats networkStatsDelta, long elapsedRealtimeMs, long uptimeMs) {
        updateCellularBatteryStats(modemActivityInfo, networkStatsDelta, -1, elapsedRealtimeMs, uptimeMs);
    }

    private void updateCellularBatteryStats(ModemActivityInfo deltaInfo, NetworkStats delta, long consumedChargeUC, long elapsedRealtimeMs, long uptimeMs) {
        long r3 = elapsedRealtimeMs;
        addModemTxPowerToHistory(deltaInfo, r3, uptimeMs);
        BatteryStatsImpl r7 = this;
        monitor-enter(this);
        long r12 = 1000;
        long totalRadioDurationMs = r7.mMobileRadioActiveTimer.getTimeSinceMarkLocked(r3 * 1000) / 1000;     // Catch: Throwable -> L18
        r7.mMobileRadioActiveTimer.setMark(r3);     // Catch: Throwable -> L18
        long phoneOnDurationMs = Math.min(totalRadioDurationMs, r7.mPhoneOnTimer.getTimeSinceMarkLocked(r3 * 1000) / 1000);     // Catch: Throwable -> L18
        r7.mPhoneOnTimer.setMark(r3);     // Catch: Throwable -> L18
        if (r7.mOnBatteryInternal == false) goto L138;
        if (r7.mIgnoreNextExternalStats == true) goto L138;
        if (consumedChargeUC > 0) goto L12;
    L20:
        SparseDoubleArray uidEstimatedConsumptionMah = null;
        long dataConsumedChargeUC = -1;
    L21:
        RxTxConsumption rxTxConsumption = null;
        if (deltaInfo == null) goto L47;
        r7.mHasModemReporting = true;     // Catch: Throwable -> L18
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7771$$Nest$mgetOrCreateIdleTimeCounter(r7.mModemActivity), deltaInfo.getIdleTimeMillis(), r3);     // Catch: Throwable -> L18
        r7.mModemActivity.m7778getSleepTimeCounter().addCountLocked(deltaInfo.getSleepTimeMillis());     // Catch: Throwable -> L18
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7772$$Nest$mgetOrCreateRxTimeCounter(r7.mModemActivity), deltaInfo.getReceiveTimeMillis(), r3);     // Catch: Throwable -> L18
        int lvl = 0;
    L25:
        if (lvl >= MODEM_TX_POWER_LEVEL_COUNT) goto L27;
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7773$$Nest$mgetOrCreateTxTimeCounters(r7.mModemActivity)[lvl], deltaInfo.getTransmitDurationMillisAtPowerLevel(lvl), r3);     // Catch: Throwable -> L18
        lvl = lvl + 1;     // Catch: Throwable -> L18
        goto L25
    L27:
        double opVolt = r7.mPowerProfile.getAveragePower("modem.controller.voltage") / 1000.0d;     // Catch: Throwable -> L18
        if (opVolt == 0.0d) goto L40;
        double energyUsed = ((deltaInfo.getSleepTimeMillis() * r7.mPowerProfile.getAveragePower("modem.controller.sleep")) + (deltaInfo.getIdleTimeMillis() * r7.mPowerProfile.getAveragePower("modem.controller.idle"))) + (deltaInfo.getReceiveTimeMillis() * r7.mPowerProfile.getAveragePower("modem.controller.rx"));     // Catch: Throwable -> L18
        int i = 0;
        double energyUsed2 = energyUsed;
    L31:
        if (i >= Math.min(MODEM_TX_POWER_LEVEL_COUNT, CELL_SIGNAL_STRENGTH_LEVEL_COUNT)) goto L33;
        energyUsed2 = energyUsed2 + (deltaInfo.getTransmitDurationMillisAtPowerLevel(i) * r7.mPowerProfile.getAveragePower("modem.controller.tx", i));     // Catch: Throwable -> L18
        i = i + 1;     // Catch: Throwable -> L18
        goto L31
    L33:
        r7.mModemActivity.m7776getPowerCounter().addCountLocked((long) energyUsed2);     // Catch: Throwable -> L18
        long monitoredRailChargeConsumedMaMs = (long) (r7.mTmpRailStats.getCellularTotalEnergyUseduWs() / opVolt);     // Catch: Throwable -> L18
        r7.mModemActivity.m7775getMonitoredRailChargeConsumedMaMs().addCountLocked(monitoredRailChargeConsumedMaMs);     // Catch: Throwable -> L18
        char r25 = 1;
        r7.mHistory.recordWifiConsumedCharge(r3, uptimeMs, monitoredRailChargeConsumedMaMs / MILLISECONDS_IN_HOUR);     // Catch: Throwable -> L38
        r3 = r3;
        r7.mTmpRailStats.resetCellularTotalEnergyUsed();     // Catch: Throwable -> L18
    L41:
        rxTxConsumption = r7.incrementPerRatDataLocked(deltaInfo, r3);     // Catch: Throwable -> L18
        if (r7.mConstants.PER_UID_MODEM_MODEL != 2) goto L45;
        if (rxTxConsumption == null) goto L45;
        char r0 = r25;
    L48:
        long totalAppRadioTimeUs = r7.mMobileRadioActivePerAppTimer.getTimeSinceMarkLocked(r3 * r12);     // Catch: Throwable -> L18
        r7.mMobileRadioActivePerAppTimer.setMark(r3);     // Catch: Throwable -> L18
        if (delta == null) goto L136;
        Iterator r10 = delta.iterator();     // Catch: Throwable -> L18
        long totalRxPackets = 0;
        RxTxConsumption rxTxConsumption2 = rxTxConsumption;
        long totalTxPackets = 0;
    L52:
        if (r10.hasNext() == false) goto L69;
        NetworkStats.Entry entry = (NetworkStats.Entry) r10.next();     // Catch: Throwable -> L67
        if (entry.getRxPackets() != 0) goto L60;
        if (entry.getTxPackets() == 0) goto L52;
    L60:
        totalRxPackets = totalRxPackets + entry.getRxPackets();     // Catch: Throwable -> L67
        totalTxPackets = totalTxPackets + entry.getTxPackets();     // Catch: Throwable -> L67
        int r2 = r7.mapUid(entry.getUid());     // Catch: Throwable -> L67
        BatteryStatsImpl r1 = r7;
        Uid u = r1.getUidStatsLocked(r2, r3, uptimeMs);     // Catch: Throwable -> L18
        u.noteNetworkActivityLocked(0, entry.getRxBytes(), entry.getRxPackets());     // Catch: Throwable -> L18
        u.noteNetworkActivityLocked(1, entry.getTxBytes(), entry.getTxPackets());     // Catch: Throwable -> L18
        if (entry.getSet() != 0) goto L65;
        u.noteNetworkActivityLocked(6, entry.getRxBytes(), entry.getRxPackets());     // Catch: Throwable -> L18
        u.noteNetworkActivityLocked(7, entry.getTxBytes(), entry.getTxPackets());     // Catch: Throwable -> L18
    L65:
        r1.mNetworkByteActivityCounters[0].addCountLocked(entry.getRxBytes());     // Catch: Throwable -> L18
        r1.mNetworkByteActivityCounters[r25].addCountLocked(entry.getTxBytes());     // Catch: Throwable -> L18
        r1.mNetworkPacketActivityCounters[0].addCountLocked(entry.getRxPackets());     // Catch: Throwable -> L18
        r1.mNetworkPacketActivityCounters[r25].addCountLocked(entry.getTxPackets());     // Catch: Throwable -> L18
        r3 = elapsedRealtimeMs;
        r7 = r1;
    L67:
        th = th;
    L140:
        monitor-exit(this);     // Catch: Throwable -> L18
        throw th;
    L69:
        BatteryStatsImpl r4 = r7;
        long totalPackets = totalRxPackets + totalTxPackets;
        if (totalPackets > 0) goto L151;
        RxTxConsumption rxTxConsumption3 = rxTxConsumption2;
        char r23 = r0;
        SparseDoubleArray uidEstimatedConsumptionMah2 = uidEstimatedConsumptionMah;
        long totalPackets2 = totalAppRadioTimeUs;
    L123:
        if (totalPackets2 <= 0) goto L125;
        r4.mMobileRadioActiveUnknownTime.addCountLocked(totalPackets2);     // Catch: Throwable -> L18
        r4.mMobileRadioActiveUnknownCount.addCountLocked(1);     // Catch: Throwable -> L18
    L125:
        if (uidEstimatedConsumptionMah2 == null) goto L136;
        if (r23 == 0) goto L129;
        long sleepTimeMs = deltaInfo.getSleepTimeMillis();     // Catch: Throwable -> L18
        long idleTimeMs = deltaInfo.getIdleTimeMillis();     // Catch: Throwable -> L18
        double inactiveConsumptionMah = r4.mMobileRadioPowerCalculator.calcInactiveStatePowerMah(sleepTimeMs, idleTimeMs);     // Catch: Throwable -> L18
        double totalEstimatedConsumptionMah = 0.0d + inactiveConsumptionMah;     // Catch: Throwable -> L18
        double totalEstimatedConsumptionMah2 = (totalEstimatedConsumptionMah + rxTxConsumption3.rxConsumptionMah) + rxTxConsumption3.txConsumptionMah;     // Catch: Throwable -> L18
    L133:
        r4.distributeEnergyToUidsLocked(7, dataConsumedChargeUC, uidEstimatedConsumptionMah2, totalEstimatedConsumptionMah2, elapsedRealtimeMs);     // Catch: Throwable -> L18
        goto L136
    L129:
        double totalEstimatedConsumptionMah3 = 0.0d + r4.mMobileRadioPowerCalculator.calcPowerFromRadioActiveDurationMah(totalRadioDurationMs);     // Catch: Throwable -> L18
        int numSignalStrengthLevels = r4.mPhoneSignalStrengthsTimer.length;     // Catch: Throwable -> L18
        int lvl2 = 0;
    L130:
        if (lvl2 >= numSignalStrengthLevels) goto L132;
        long strengthLevelDurationMs = r4.mPhoneSignalStrengthsTimer[lvl2].getTimeSinceMarkLocked(elapsedRealtimeMs * r12) / r12;     // Catch: Throwable -> L18
        r4.mPhoneSignalStrengthsTimer[lvl2].setMark(elapsedRealtimeMs);     // Catch: Throwable -> L18
        totalEstimatedConsumptionMah3 = totalEstimatedConsumptionMah3 + r4.mMobileRadioPowerCalculator.calcIdlePowerAtSignalStrengthMah(strengthLevelDurationMs, lvl2);     // Catch: Throwable -> L18
        lvl2 = lvl2 + 1;     // Catch: Throwable -> L18
        goto L130
    L132:
        long scanTimeMs = r4.mPhoneSignalScanningTimer.getTimeSinceMarkLocked(elapsedRealtimeMs * r12) / r12;     // Catch: Throwable -> L18
        r4.mPhoneSignalScanningTimer.setMark(elapsedRealtimeMs);     // Catch: Throwable -> L18
        totalEstimatedConsumptionMah2 = totalEstimatedConsumptionMah3 + r4.mMobileRadioPowerCalculator.calcScanTimePowerMah(scanTimeMs);     // Catch: Throwable -> L18
        goto L133
    L151:
        Iterator r22 = delta.iterator();     // Catch: Throwable -> L118
        long totalAppRadioTimeUs2 = totalAppRadioTimeUs;
        long totalAppRadioTimeUs3 = totalPackets;
    L73:
        if (r22.hasNext() == false) goto L120;
        NetworkStats.Entry entry2 = (NetworkStats.Entry) r22.next();     // Catch: Throwable -> L118
        if (entry2.getRxPackets() != 0) goto L81;
        if (entry2.getTxPackets() == 0) goto L73;
    L81:
        Uid u2 = r4.getUidStatsLocked(r4.mapUid(entry2.getUid()), elapsedRealtimeMs, uptimeMs);     // Catch: Throwable -> L116
        long appPackets = entry2.getRxPackets() + entry2.getTxPackets();     // Catch: Throwable -> L113
        long appRadioTimeUs = (totalAppRadioTimeUs2 * appPackets) / totalAppRadioTimeUs3;     // Catch: Throwable -> L113
        u2.noteMobileRadioActiveTimeLocked(appRadioTimeUs, elapsedRealtimeMs);     // Catch: Throwable -> L113
        if (uidEstimatedConsumptionMah == null) goto L96;
        if (r0 != 0) goto L149;
        long appRadioTimeUs2 = appRadioTimeUs;
        long totalRxPackets2 = totalRxPackets;
        RxTxConsumption rxTxConsumption4 = rxTxConsumption2;
        long totalPackets3 = elapsedRealtimeMs;
        r4 = this;
        double uidConsumptionMah = r4.mMobileRadioPowerCalculator.calcPowerFromRadioActiveDurationMah(appRadioTimeUs2 / r12);     // Catch: Throwable -> L18
    L95:
        uidEstimatedConsumptionMah.incrementValue(u2.getUid(), uidConsumptionMah);     // Catch: Throwable -> L18
    L97:
        totalAppRadioTimeUs2 = totalAppRadioTimeUs2 - appRadioTimeUs2;     // Catch: Throwable -> L18
        long totalPackets4 = totalAppRadioTimeUs3 - appPackets;     // Catch: Throwable -> L18
        if (deltaInfo == null) goto L112;
        ControllerActivityCounterImpl activityCounter = u2.getOrCreateModemControllerActivityLocked();     // Catch: Throwable -> L18
        if (totalRxPackets2 <= 0) goto L105;
        if (entry2.getRxPackets() <= 0) goto L105;
        long rxMs = (entry2.getRxPackets() * deltaInfo.getReceiveTimeMillis()) / totalRxPackets2;     // Catch: Throwable -> L18
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7772$$Nest$mgetOrCreateRxTimeCounter(activityCounter), rxMs, totalPackets3);     // Catch: Throwable -> L18
    L105:
        if (totalTxPackets <= 0) goto L112;
        if (entry2.getTxPackets() <= 0) goto L112;
        int lvl3 = 0;
    L110:
        if (lvl3 >= MODEM_TX_POWER_LEVEL_COUNT) goto L112;
        long txMs = entry2.getTxPackets() * deltaInfo.getTransmitDurationMillisAtPowerLevel(lvl3);     // Catch: Throwable -> L18
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7773$$Nest$mgetOrCreateTxTimeCounters(activityCounter)[lvl3], txMs / totalTxPackets, totalPackets3);     // Catch: Throwable -> L18
        lvl3 = lvl3 + 1;     // Catch: Throwable -> L18
    L112:
        uidEstimatedConsumptionMah = uidEstimatedConsumptionMah;
        totalAppRadioTimeUs3 = totalPackets4;
        rxTxConsumption2 = rxTxConsumption4;
        r0 = r0;
        totalRxPackets = totalRxPackets2;
        totalTxPackets = totalTxPackets;
        goto L73
    L149:
        long r5 = entry2.getRxPackets();     // Catch: Throwable -> L91
        appRadioTimeUs2 = appRadioTimeUs;
        long appRadioTimeUs3 = entry2.getTxPackets();     // Catch: Throwable -> L91
        long totalRxPackets3 = totalRxPackets;
        RxTxConsumption rxTxConsumption5 = rxTxConsumption2;
        r4 = this;
        totalPackets3 = elapsedRealtimeMs;
        uidConsumptionMah = r4.smearModemActivityInfoRxTxConsumptionMah(rxTxConsumption5, r5, appRadioTimeUs3, totalRxPackets3, totalTxPackets);     // Catch: Throwable -> L18
        totalRxPackets2 = totalRxPackets3;
        rxTxConsumption4 = rxTxConsumption5;
    L91:
        th = th;
        goto L140
    L96:
        appRadioTimeUs2 = appRadioTimeUs;
        totalTxPackets = totalTxPackets;
        totalAppRadioTimeUs3 = totalAppRadioTimeUs3;
        totalRxPackets2 = totalRxPackets;
        rxTxConsumption4 = rxTxConsumption2;
        r0 = r0;
        u2 = u2;
        totalPackets3 = elapsedRealtimeMs;
        uidEstimatedConsumptionMah = uidEstimatedConsumptionMah;
        r4 = this;
    L113:
        th = th;
    L116:
        th = th;
        goto L140
    L120:
        rxTxConsumption3 = rxTxConsumption2;
        r23 = r0;
        uidEstimatedConsumptionMah2 = uidEstimatedConsumptionMah;
        totalPackets2 = totalAppRadioTimeUs2;
    L118:
        th = th;
    L136:
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L45:
        r0 = 0;
    L38:
        th = th;
        goto L140
    L40:
        r25 = 1;
        goto L41
    L47:
        r25 = 1;
        r12 = 1000;
        r0 = 0;
        goto L48
    L12:
        if (r7.isMobileRadioEnergyConsumerSupportedLocked() == false) goto L20;
        if (totalRadioDurationMs != 0) goto L16;
        long phoneConsumedChargeUC = 0;
    L17:
        long dataConsumedChargeUC2 = consumedChargeUC - phoneConsumedChargeUC;     // Catch: Throwable -> L18
        r7.mGlobalEnergyConsumerStats.updateStandardBucket(9, phoneConsumedChargeUC);     // Catch: Throwable -> L18
        r7.mGlobalEnergyConsumerStats.updateStandardBucket(7, dataConsumedChargeUC2);     // Catch: Throwable -> L18
        SparseDoubleArray uidEstimatedConsumptionMah3 = new SparseDoubleArray();     // Catch: Throwable -> L18
        uidEstimatedConsumptionMah = uidEstimatedConsumptionMah3;
        dataConsumedChargeUC = dataConsumedChargeUC2;
        goto L21
    L16:
        long phoneConsumedChargeUC2 = consumedChargeUC * phoneOnDurationMs;     // Catch: Throwable -> L18
        phoneConsumedChargeUC = (phoneConsumedChargeUC2 + (totalRadioDurationMs / 2)) / totalRadioDurationMs;     // Catch: Throwable -> L18
    L138:
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L18:
        th = th;
        goto L140
    }

    private RxTxConsumption incrementPerRatDataLocked(ModemActivityInfo deltaInfo, long elapsedRealtimeMs) {
        ModemActivityInfo r1 = deltaInfo;
        double rxConsumptionMah = 0.0d;
        long rxDurationMs = 0;
        double txConsumptionMah = 0.0d;
        long txDurationMs = 0;
        int infoSize = r1.getSpecificInfoLength();
        int r14 = 3;
        if (infoSize != 1) goto L54;
        if (r1.getSpecificInfoRat(0) != 0) goto L54;
        if (r1.getSpecificInfoFrequencyRange(0) != 0) goto L54;
        int levelCount = CELL_SIGNAL_STRENGTH_LEVEL_COUNT;
        long[] perSignalStrengthActiveTimeMs = new long[levelCount];
        long totalActiveTimeMs = 0;
        int freq = 0;
        double rxConsumptionMah2 = 0.0d;
    L9:
        if (freq >= r14) goto L21;
        RadioAccessTechnologyBatteryStats ratStats = this.mPerRatBatteryStats[freq];
        if (ratStats == null) goto L20;
        int freqCount = ratStats.getFrequencyRangeCount();
        int rat = 0;
    L14:
        if (rat >= freqCount) goto L20;
        long rxDurationMs2 = rxDurationMs;
        int level = 0;
    L16:
        if (level >= levelCount) goto L18;
        long durationMs = ratStats.getTimeSinceMark(rat, level, elapsedRealtimeMs);
        perSignalStrengthActiveTimeMs[level] = perSignalStrengthActiveTimeMs[level] + durationMs;
        totalActiveTimeMs = totalActiveTimeMs + durationMs;
        level = level + 1;
        goto L16
    L18:
        rat = rat + 1;
        rxDurationMs = rxDurationMs2;
    L20:
        freq = freq + 1;
        rxDurationMs = rxDurationMs;
        r14 = 3;
        goto L9
    L21:
        long rxDurationMs3 = rxDurationMs;
        long r4 = 0;
        if (totalActiveTimeMs == 0) goto L50;
        int rat2 = 0;
    L25:
        if (rat2 >= 3) goto L49;
        RadioAccessTechnologyBatteryStats ratStats2 = this.mPerRatBatteryStats[rat2];
        if (ratStats2 != null) goto L29;
        long r23 = r4;
    L48:
        rat2 = rat2 + 1;
        r4 = r23;
        goto L25
    L29:
        int freq2 = ratStats2.getFrequencyRangeCount();
        r23 = r4;
        int freq3 = 0;
    L30:
        if (freq3 >= freq2) goto L48;
        long txDurationMs2 = txDurationMs;
        long txDurationMs3 = 0;
        double txConsumptionMah2 = txConsumptionMah;
        int level2 = 0;
    L33:
        if (level2 >= levelCount) goto L42;
        long durationMs2 = ratStats2.getTimeSinceMark(freq3, level2, elapsedRealtimeMs);
        long totalLvlDurationMs = perSignalStrengthActiveTimeMs[level2];
        if (totalLvlDurationMs != r23) goto L37;
        int freqCount2 = freq2;
        int freqCount3 = freq3;
    L41:
        level2 = level2 + 1;
        freq3 = freqCount3;
        freq2 = freqCount2;
        goto L33
    L37:
        long totalTxLvlDurations = r1.getTransmitDurationMillisAtPowerLevel(level2);
        freqCount2 = freq2;
        long proportionalTxDurationMs = ((durationMs2 * totalTxLvlDurations) + (totalLvlDurationMs / 2)) / totalLvlDurationMs;
        ratStats2.incrementTxDuration(freq3, level2, proportionalTxDurationMs);
        long frequencyDurationMs = txDurationMs3 + durationMs2;
        if (isMobileRadioEnergyConsumerSupportedLocked() == false) goto L40;
        int freq4 = freq3;
        double txStatePowerConsumptionMah = this.mMobileRadioPowerCalculator.calcTxStatePowerMah(rat2, freq4, level2, proportionalTxDurationMs);
        freqCount3 = freq4;
        txConsumptionMah2 = txConsumptionMah2 + txStatePowerConsumptionMah;
        txDurationMs2 = txDurationMs2 + proportionalTxDurationMs;
        txDurationMs3 = frequencyDurationMs;
        goto L41
    L40:
        freqCount3 = freq3;
        txDurationMs3 = frequencyDurationMs;
        goto L41
    L42:
        int freqCount4 = freq2;
        int freqCount5 = freq3;
        long totalRxDuration = r1.getReceiveTimeMillis();
        long proportionalRxDurationMs = ((txDurationMs3 * totalRxDuration) + (totalActiveTimeMs / 2)) / totalActiveTimeMs;
        ratStats2.incrementRxDuration(freqCount5, proportionalRxDurationMs);
        if (isMobileRadioEnergyConsumerSupportedLocked() == false) goto L46;
        double rxStatePowerConsumptionMah = this.mMobileRadioPowerCalculator.calcRxStatePowerMah(rat2, freqCount5, proportionalRxDurationMs);
        rxConsumptionMah2 = rxConsumptionMah2 + rxStatePowerConsumptionMah;
        rxDurationMs3 = rxDurationMs3 + proportionalRxDurationMs;
    L46:
        freq3 = freqCount5 + 1;
        freq2 = freqCount4;
        txConsumptionMah = txConsumptionMah2;
        txDurationMs = txDurationMs2;
        goto L30
    L49:
        double rxConsumptionMah3 = rxConsumptionMah2;
        long rxDurationMs4 = rxDurationMs3;
    L51:
        double rxConsumptionMah4 = rxConsumptionMah3;
        long rxDurationMs5 = rxDurationMs4;
        double txConsumptionMah3 = txConsumptionMah;
        long txDurationMs4 = txDurationMs;
    L68:
        int rat3 = 0;
    L70:
        if (rat3 >= 3) goto L77;
        RadioAccessTechnologyBatteryStats ratStats3 = this.mPerRatBatteryStats[rat3];
        if (ratStats3 == null) goto L75;
        ratStats3.setMark(elapsedRealtimeMs);
    L75:
        rat3 = rat3 + 1;
        goto L70
    L77:
        if (isMobileRadioEnergyConsumerSupportedLocked() == true) goto L79;
        return null;
    L79:
        return new RxTxConsumption(rxConsumptionMah4, rxDurationMs5, txConsumptionMah3, txDurationMs4);
    L50:
        rxConsumptionMah3 = 0.0d;
        rxDurationMs4 = rxDurationMs3;
    L54:
        int lvl = 0;
        long rxDurationMs6 = 0;
    L55:
        if (lvl >= infoSize) goto L67;
        int rat4 = r1.getSpecificInfoRat(lvl);
        int freq5 = r1.getSpecificInfoFrequencyRange(lvl);
        int ratBucket = MobileRadioPowerStatsLayout.mapRadioAccessNetworkTypeToRadioAccessTechnology(rat4);
        RadioAccessTechnologyBatteryStats ratStats4 = getRatBatteryStatsLocked(ratBucket);
        long rxDurationMs7 = rxDurationMs6;
        long rxTimeMs = r1.getReceiveTimeMillis(rat4, freq5);
        int index = lvl;
        int[] txTimesMs = r1.getTransmitTimeMillis(rat4, freq5);
        ratStats4.incrementRxDuration(freq5, rxTimeMs);
        if (isMobileRadioEnergyConsumerSupportedLocked() == false) goto L59;
        double rxStatePowerConsumptionMah2 = this.mMobileRadioPowerCalculator.calcRxStatePowerMah(ratBucket, freq5, rxTimeMs);
        rxConsumptionMah = rxConsumptionMah + rxStatePowerConsumptionMah2;
        rxDurationMs7 = rxDurationMs7 + rxTimeMs;
    L59:
        int numTxLvl = txTimesMs.length;
        int lvl2 = 0;
    L60:
        if (lvl2 >= numTxLvl) goto L66;
        int numTxLvl2 = numTxLvl;
        int numTxLvl3 = txTimesMs[lvl2];
        int rat5 = rat4;
        long rxTimeMs2 = rxTimeMs;
        long txTimeMs = numTxLvl3;
        ratStats4.incrementTxDuration(freq5, lvl2, txTimeMs);
        if (isMobileRadioEnergyConsumerSupportedLocked() == false) goto L64;
        int lvl3 = lvl2;
        int freq6 = freq5;
        int ratBucket2 = ratBucket;
        double txStatePowerConsumptionMah2 = this.mMobileRadioPowerCalculator.calcTxStatePowerMah(ratBucket2, freq6, lvl3, txTimeMs);
        txConsumptionMah = txConsumptionMah + txStatePowerConsumptionMah2;
        txDurationMs = txDurationMs + txTimeMs;
    L65:
        lvl2 = lvl3 + 1;
        ratBucket = ratBucket2;
        freq5 = freq6;
        numTxLvl = numTxLvl2;
        rat4 = rat5;
        rxTimeMs = rxTimeMs2;
        goto L60
    L64:
        lvl3 = lvl2;
        freq6 = freq5;
        ratBucket2 = ratBucket;
        goto L65
    L66:
        lvl = index + 1;
        r1 = deltaInfo;
        rxDurationMs6 = rxDurationMs7;
        goto L55
    L67:
        rxDurationMs5 = rxDurationMs6;
        rxConsumptionMah4 = rxConsumptionMah;
        txConsumptionMah3 = txConsumptionMah;
        txDurationMs4 = txDurationMs;
        goto L68
    }

    private double smearModemActivityInfoRxTxConsumptionMah(RxTxConsumption rxTxConsumption, long rxPackets, long txPackets, long totalRxPackets, long totalTxPackets) {
        double consumptionMah = 0.0d;
        if (totalRxPackets == 0) goto L6;
        consumptionMah = 0.0d + ((rxTxConsumption.rxConsumptionMah * rxPackets) / totalRxPackets);
    L6:
        if (totalTxPackets == 0) goto L8;
    L13:
        double totalPacketsDuringTxTime = totalTxPackets + (rxTxConsumption.txToTotalRatio * totalRxPackets);
        double packetsDuringTxTime = txPackets + (rxPackets * rxTxConsumption.txToTotalRatio);
        return consumptionMah + ((rxTxConsumption.txConsumptionMah * packetsDuringTxTime) / totalPacketsDuringTxTime);
    L8:
        if (totalRxPackets == 0) goto L15;
        if (rxTxConsumption.txToTotalRatio != 0.0d) goto L13;
    L15:
        return consumptionMah;
    }

    private synchronized void addModemTxPowerToHistory(ModemActivityInfo activityInfo, long elapsedRealtimeMs, long uptimeMs) {
        monitor-enter(this);
        if (activityInfo != null) goto L6;
        monitor-exit(this);
        return;
    L6:
        int levelMaxTimeSpent = 0;
        int i = 1;
    L24:
    L13:
        th = move-exception;
        throw th;
    L8:
        if (i >= MODEM_TX_POWER_LEVEL_COUNT) goto L15;
        if (activityInfo.getTransmitDurationMillisAtPowerLevel(i) <= activityInfo.getTransmitDurationMillisAtPowerLevel(levelMaxTimeSpent)) goto L12;
        levelMaxTimeSpent = i;
    L12:
        i = i + 1;     // Catch: Throwable -> L13
        goto L24
    L15:
        int i2 = MODEM_TX_POWER_LEVEL_COUNT;     // Catch: Throwable -> L13
        if (levelMaxTimeSpent != (i2 - 1)) goto L20;
        this.mHistory.recordState2StartEvent(elapsedRealtimeMs, uptimeMs, 524288);     // Catch: Throwable -> L13
    L20:
        monitor-exit(this);
    }

    private void onBluetoothPowerStatsRetrieved(BluetoothActivityEnergyInfo info, long elapsedRealtimeMs, long uptimeMs) {
        updateBluetoothStateLocked(info, -1, elapsedRealtimeMs, uptimeMs);
    }

    public void updateBluetoothStateLocked(BluetoothActivityEnergyInfo info, long consumedChargeUC, long elapsedRealtimeMs, long uptimeMs) {
        BatteryStatsImpl r0 = this;
        if (info != null) goto L6;
        return;
    L6:
        if (r0.mOnBatteryInternal == false) goto L116;
        if (r0.mIgnoreNextExternalStats == true) goto L116;
        r0.mHasBluetoothReporting = true;
        if (info.getControllerRxTimeMillis() >= r0.mLastBluetoothActivityInfo.rxTimeMs) goto L13;
    L18:
        r0.mLastBluetoothActivityInfo.reset();
    L19:
        long rxTimeMs = info.getControllerRxTimeMillis() - r0.mLastBluetoothActivityInfo.rxTimeMs;
        long txTimeMs = info.getControllerTxTimeMillis() - r0.mLastBluetoothActivityInfo.txTimeMs;
        long idleTimeMs = info.getControllerIdleTimeMillis() - r0.mLastBluetoothActivityInfo.idleTimeMs;
        if (r0.mGlobalEnergyConsumerStats != null) goto L22;
    L27:
        SparseDoubleArray r1 = null;
    L26:
        SparseDoubleArray uidEstimatedConsumptionMah = r1;
        int uidCount = r0.mUidStats.size();
        int i = 0;
        long totalScanTimeMs = 0;
    L29:
        if (i >= uidCount) goto L36;
        Uid u = r0.mUidStats.valueAt(i);
        if (u.mBluetoothScanTimer == null) goto L34;
        totalScanTimeMs = totalScanTimeMs + (u.mBluetoothScanTimer.getTimeSinceMarkLocked(elapsedRealtimeMs * 1000) / 1000);
    L34:
        i = i + 1;
        goto L29
    L36:
        if (totalScanTimeMs <= rxTimeMs) goto L38;
        boolean r2 = true;
    L39:
        boolean normalizeScanRxTime = r2;
        if (totalScanTimeMs <= txTimeMs) goto L42;
        boolean r3 = true;
    L43:
        boolean normalizeScanTxTime = r3;
        SparseLongArray rxTimesMs = new SparseLongArray(uidCount);
        SparseLongArray txTimesMs = new SparseLongArray(uidCount);
        long leftOverRxTimeMs = rxTimeMs;
        long leftOverTxTimeMs = txTimeMs;
        int i2 = 0;
    L44:
        if (i2 >= uidCount) goto L64;
        Uid u2 = r0.mUidStats.valueAt(i2);
        if (u2.mBluetoothScanTimer == null) goto L63;
        long scanTimeSinceMarkMs = u2.mBluetoothScanTimer.getTimeSinceMarkLocked(elapsedRealtimeMs * 1000) / 1000;
        if (scanTimeSinceMarkMs <= 0) goto L63;
        u2.mBluetoothScanTimer.setMark(elapsedRealtimeMs);
        if (normalizeScanRxTime == false) goto L53;
        long scanTimeRxSinceMarkMs = (rxTimeMs * scanTimeSinceMarkMs) / totalScanTimeMs;
        long scanTimeRxSinceMarkMs2 = scanTimeRxSinceMarkMs;
    L54:
        if (normalizeScanTxTime == false) goto L56;
        long scanTimeTxSinceMarkMs = (txTimeMs * scanTimeSinceMarkMs) / totalScanTimeMs;
        long scanTimeSinceMarkMs2 = scanTimeTxSinceMarkMs;
    L57:
        rxTimesMs.incrementValue(u2.getUid(), scanTimeRxSinceMarkMs2);
        txTimesMs.incrementValue(u2.getUid(), scanTimeSinceMarkMs2);
        if (uidEstimatedConsumptionMah == null) goto L60;
        long scanTimeRxSinceMarkMs3 = scanTimeRxSinceMarkMs2;
        long scanTimeTxSinceMarkMs2 = scanTimeSinceMarkMs2;
        uidEstimatedConsumptionMah.incrementValue(u2.getUid(), r0.mBluetoothPowerCalculator.calculatePowerMah(scanTimeRxSinceMarkMs3, scanTimeTxSinceMarkMs2, 0));
    L61:
        leftOverRxTimeMs = leftOverRxTimeMs - scanTimeRxSinceMarkMs3;
        leftOverTxTimeMs = leftOverTxTimeMs - scanTimeTxSinceMarkMs2;
        goto L63
    L60:
        scanTimeRxSinceMarkMs3 = scanTimeRxSinceMarkMs2;
        scanTimeTxSinceMarkMs2 = scanTimeSinceMarkMs2;
        goto L61
    L56:
        scanTimeSinceMarkMs2 = scanTimeSinceMarkMs;
        goto L57
    L53:
        scanTimeRxSinceMarkMs2 = scanTimeSinceMarkMs;
    L63:
        i2 = i2 + 1;
        goto L44
    L64:
        List<UidTraffic> uidTraffic = info.getUidTraffic();
        int numUids = uidTraffic.size();
        long totalTxBytes = 0;
        long totalRxBytes = 0;
        int i3 = 0;
    L65:
        if (i3 >= numUids) goto L67;
        UidTraffic traffic = uidTraffic.get(i3);
        long r4 = traffic.getRxBytes();
        SparseLongArray r5 = r0.mLastBluetoothActivityInfo.uidRxBytes;
        int i4 = i3;
        int i5 = traffic.getUid();
        long rxBytes = r4 - r5.get(i5);
        long txBytes = traffic.getTxBytes() - r0.mLastBluetoothActivityInfo.uidTxBytes.get(traffic.getUid());
        r0.mNetworkByteActivityCounters[4].addCountLocked(rxBytes);
        r0.mNetworkByteActivityCounters[5].addCountLocked(txBytes);
        Uid u3 = r0.getUidStatsLocked(r0.mapUid(traffic.getUid()), elapsedRealtimeMs, uptimeMs);
        u3.noteNetworkActivityLocked(4, rxBytes, 0);
        u3.noteNetworkActivityLocked(5, txBytes, 0);
        totalRxBytes = totalRxBytes + rxBytes;
        totalTxBytes = totalTxBytes + txBytes;
        i3 = i4 + 1;
        rxTimesMs = rxTimesMs;
        idleTimeMs = idleTimeMs;
        goto L65
    L67:
        SparseLongArray rxTimesMs2 = rxTimesMs;
        long idleTimeMs2 = idleTimeMs;
        if (totalTxBytes != 0) goto L74;
        if (totalRxBytes != 0) goto L74;
    L72:
        long r6 = elapsedRealtimeMs;
        long txTimeMs2 = txTimeMs;
    L106:
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7772$$Nest$mgetOrCreateRxTimeCounter(r0.mBluetoothActivity), rxTimeMs, r6);
        long txTimeMs3 = txTimeMs2;
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7773$$Nest$mgetOrCreateTxTimeCounters(r0.mBluetoothActivity)[0], txTimeMs3, r6);
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7771$$Nest$mgetOrCreateIdleTimeCounter(r0.mBluetoothActivity), idleTimeMs2, r6);
        double opVolt = r0.mPowerProfile.getAveragePower("bluetooth.controller.voltage") / 1000.0d;
        if (opVolt == 0.0d) goto L109;
        double controllerMaMs = (info.getControllerEnergyUsed() - r0.mLastBluetoothActivityInfo.energy) / opVolt;
        r0.mBluetoothActivity.m7776getPowerCounter().addCountLocked((long) controllerMaMs);
        double controllerMaMs2 = controllerMaMs;
    L110:
        if (uidEstimatedConsumptionMah == null) goto L113;
        r0.mGlobalEnergyConsumerStats.updateStandardBucket(5, consumedChargeUC);
        double totalEstimatedMah = r0.mBluetoothPowerCalculator.calculatePowerMah(rxTimeMs, txTimeMs3, idleTimeMs2);
        r0.distributeEnergyToUidsLocked(5, consumedChargeUC, uidEstimatedConsumptionMah, Math.max(totalEstimatedMah, controllerMaMs2 / MILLISECONDS_IN_HOUR), elapsedRealtimeMs);
    L113:
        r0.mLastBluetoothActivityInfo.set(info);
        return;
    L109:
        controllerMaMs2 = 0.0d;
    L74:
        if (leftOverRxTimeMs == 0) goto L76;
    L77:
        int i6 = 0;
    L78:
        if (i6 >= numUids) goto L90;
        UidTraffic traffic2 = uidTraffic.get(i6);
        int uid = traffic2.getUid();
        long rxBytes2 = traffic2.getRxBytes() - r0.mLastBluetoothActivityInfo.uidRxBytes.get(uid);
        long txBytes2 = traffic2.getTxBytes() - r0.mLastBluetoothActivityInfo.uidTxBytes.get(uid);
        int i7 = i6;
        int i8 = r0.mapUid(uid);
        List<UidTraffic> uidTraffic2 = uidTraffic;
        r0.getUidStatsLocked(i8, elapsedRealtimeMs, uptimeMs).getOrCreateBluetoothControllerActivityLocked();
        if (totalRxBytes <= 0) goto L85;
        if (rxBytes2 <= 0) goto L85;
        long timeRxMs = (leftOverRxTimeMs * rxBytes2) / totalRxBytes;
        rxTimesMs2.incrementValue(uid, timeRxMs);
    L85:
        if (totalTxBytes <= 0) goto L89;
        if (txBytes2 <= 0) goto L89;
        long timeTxMs = (leftOverTxTimeMs * txBytes2) / totalTxBytes;
        txTimesMs.incrementValue(uid, timeTxMs);
    L89:
        i6 = i7 + 1;
        r0 = this;
        uidTraffic = uidTraffic2;
        goto L78
    L90:
        int i9 = 0;
    L92:
        if (i9 >= txTimesMs.size()) goto L98;
        int uid2 = txTimesMs.keyAt(i9);
        long myTxTimeMs = txTimesMs.valueAt(i9);
        int i10 = i9;
        int numUids2 = numUids;
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7773$$Nest$mgetOrCreateTxTimeCounters(getUidStatsLocked(uid2, elapsedRealtimeMs, uptimeMs).getOrCreateBluetoothControllerActivityLocked())[0], myTxTimeMs, elapsedRealtimeMs);
        if (uidEstimatedConsumptionMah == null) goto L97;
        uidEstimatedConsumptionMah.incrementValue(uid2, this.mBluetoothPowerCalculator.calculatePowerMah(0, myTxTimeMs, 0));
    L97:
        i9 = i10 + 1;
        numUids = numUids2;
        goto L92
    L98:
        r0 = this;
        r6 = elapsedRealtimeMs;
        int i11 = 0;
    L100:
        if (i11 >= rxTimesMs2.size()) goto L105;
        int uid3 = rxTimesMs2.keyAt(i11);
        long myRxTimeMs = rxTimesMs2.valueAt(i11);
        SparseLongArray rxTimesMs3 = rxTimesMs2;
        long txTimeMs4 = txTimeMs;
        TimeMultiStateCounter.m7791$$Nest$mincrement(ControllerActivityCounterImpl.m7772$$Nest$mgetOrCreateRxTimeCounter(r0.getUidStatsLocked(rxTimesMs2.keyAt(i11), r6, uptimeMs).getOrCreateBluetoothControllerActivityLocked()), myRxTimeMs, r6);
        if (uidEstimatedConsumptionMah == null) goto L104;
        uidEstimatedConsumptionMah.incrementValue(uid3, r0.mBluetoothPowerCalculator.calculatePowerMah(myRxTimeMs, 0, 0));
    L104:
        i11 = i11 + 1;
        txTimeMs = txTimeMs4;
        rxTimesMs2 = rxTimesMs3;
        goto L100
    L105:
        txTimeMs2 = txTimeMs;
        goto L106
    L76:
        if (leftOverTxTimeMs == 0) goto L72;
    L42:
        r3 = false;
        goto L43
    L38:
        r2 = false;
        goto L39
    L22:
        if (r0.mBluetoothPowerCalculator == null) goto L27;
        if (consumedChargeUC <= 0) goto L27;
        r1 = new SparseDoubleArray();
        goto L26
    L13:
        if (info.getControllerTxTimeMillis() < r0.mLastBluetoothActivityInfo.txTimeMs) goto L18;
        if (info.getControllerIdleTimeMillis() < r0.mLastBluetoothActivityInfo.idleTimeMs) goto L18;
        if (info.getControllerEnergyUsed() >= r0.mLastBluetoothActivityInfo.energy) goto L19;
    L116:
        r0.mLastBluetoothActivityInfo.set(info);
    }

    public void fillLowPowerStats() {
        if (this.mPlatformIdleStateCallback != null) goto L5;
        return;
    L5:
        RpmStats rpmStats = new RpmStats();
        long now = SystemClock.elapsedRealtime();
        if ((now - this.mLastRpmStatsUpdateTimeMs) < 1000) goto L15;
        this.mPlatformIdleStateCallback.fillLowPowerStats(rpmStats);
        monitor-enter(this);
        this.mTmpRpmStats = rpmStats;     // Catch: Throwable -> L12
        this.mLastRpmStatsUpdateTimeMs = now;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void updateRpmStatsLocked(long elapsedRealtimeUs) {
        if (this.mTmpRpmStats != null) goto L5;
        return;
    L5:
        Iterator r1 = this.mTmpRpmStats.mPlatformLowPowerStats.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        Map.Entry<String, RpmStats.PowerStatePlatformSleepState> pstate = (Map.Entry) r1.next();
        String pName = pstate.getKey();
        long pTimeUs = pstate.getValue().mTimeMs * 1000;
        int pCount = pstate.getValue().mCount;
        getRpmTimerLocked(pName).update(pTimeUs, pCount, elapsedRealtimeUs);
        Iterator r7 = pstate.getValue().mVoters.entrySet().iterator();
    L10:
        if (r7.hasNext() == false) goto L7;
        Map.Entry<String, RpmStats.PowerStateElement> voter = (Map.Entry) r7.next();
        String vName = pName + "." + voter.getKey();
        long vTimeUs = voter.getValue().mTimeMs * 1000;
        int vCount = voter.getValue().mCount;
        getRpmTimerLocked(vName).update(vTimeUs, vCount, elapsedRealtimeUs);
        goto L10
    L13:
        Iterator r2 = this.mTmpRpmStats.mSubsystemLowPowerStats.entrySet().iterator();
    L15:
        if (r2.hasNext() == false) goto L21;
        Map.Entry<String, RpmStats.PowerStateSubsystem> subsys = (Map.Entry) r2.next();
        String subsysName = subsys.getKey();
        Iterator r8 = subsys.getValue().mStates.entrySet().iterator();
    L18:
        if (r8.hasNext() == false) goto L15;
        Map.Entry<String, RpmStats.PowerStateElement> sstate = (Map.Entry) r8.next();
        String name = subsysName + "." + sstate.getKey();
        long timeUs = sstate.getValue().mTimeMs * 1000;
        int count = sstate.getValue().mCount;
        getRpmTimerLocked(name).update(timeUs, count, elapsedRealtimeUs);
        goto L18
    }

    private void updateCpuEnergyConsumerStatsLocked(long[] clusterChargeUC, CpuDeltaPowerAccumulator accumulator) {
        if (this.mGlobalEnergyConsumerStats != null) goto L5;
        return;
    L5:
        int numClusters = clusterChargeUC.length;
        int i = 0;
        long totalCpuChargeUC = 0;
    L6:
        if (i >= numClusters) goto L8;
        totalCpuChargeUC = totalCpuChargeUC + clusterChargeUC[i];
        i = i + 1;
        goto L6
    L8:
        long r4 = 0;
        if (totalCpuChargeUC > 0) goto L11;
        return;
    L11:
        long timestampMs = this.mClock.elapsedRealtime();
        this.mGlobalEnergyConsumerStats.updateStandardBucket(3, totalCpuChargeUC, timestampMs);
        double[] clusterChargeRatio = new double[numClusters];
        int cluster = 0;
    L12:
        if (cluster >= numClusters) goto L18;
        double totalClusterChargeMah = accumulator.totalClusterChargesMah[cluster];
        if (totalClusterChargeMah > 0.0d) goto L16;
        clusterChargeRatio[cluster] = 0.0d;
    L17:
        cluster = cluster + 1;
        goto L12
    L16:
        clusterChargeRatio[cluster] = clusterChargeUC[cluster] / accumulator.totalClusterChargesMah[cluster];
        goto L17
    L18:
        long uidChargeArraySize = accumulator.perUidCpuClusterChargesMah.size();
        int i2 = 0;
    L20:
        if (i2 >= uidChargeArraySize) goto L30;
        Uid uid = accumulator.perUidCpuClusterChargesMah.keyAt(i2);
        double[] uidClusterChargesMah = accumulator.perUidCpuClusterChargesMah.valueAt(i2);
        long uidCpuChargeUC = 0;
        long r26 = r4;
        int cluster2 = 0;
    L22:
        if (cluster2 >= numClusters) goto L25;
        double uidClusterChargeMah = uidClusterChargesMah[cluster2];
        long uidClusterChargeUC = (long) ((clusterChargeRatio[cluster2] * uidClusterChargeMah) + 0.5d);
        uidCpuChargeUC = uidCpuChargeUC + uidClusterChargeUC;
        cluster2 = cluster2 + 1;
        goto L22
    L25:
        if (uidCpuChargeUC >= r26) goto L27;
        Slog.wtf(TAG, "Unexpected proportional EnergyConsumer charge (" + uidCpuChargeUC + ") for uid " + uid.mUid);
    L28:
        i2 = i2 + 1;
        r4 = r26;
        goto L20
    L27:
        Uid.m7808$$Nest$maddChargeToStandardBucketLocked(uid, uidCpuChargeUC, 3, timestampMs);
        goto L28
    }

    public void updateDisplayEnergyConsumerStatsLocked(long[] chargesUC, int[] screenStates, long elapsedRealtimeMs) {
        BatteryStatsImpl r0 = this;
        if (r0.mGlobalEnergyConsumerStats != null) goto L6;
        return;
    L6:
        if (r0.mPerDisplayBatteryStats.length != screenStates.length) goto L8;
        int numDisplays = screenStates.length;
    L16:
        int[] oldScreenStates = new int[numDisplays];
        int i = 0;
    L17:
        if (i >= numDisplays) goto L20;
        int screenState = screenStates[i];
        oldScreenStates[i] = r0.mPerDisplayBatteryStats[i].screenStateAtLastEnergyMeasurement;
        r0.mPerDisplayBatteryStats[i].screenStateAtLastEnergyMeasurement = screenState;
        i = i + 1;
        goto L17
    L20:
        if (r0.mOnBatteryInternal == true) goto L23;
        return;
    L23:
        if (r0.mIgnoreNextExternalStats == false) goto L29;
        int uidStatsSize = r0.mUidStats.size();
        int i2 = 0;
    L25:
        if (i2 >= uidStatsSize) goto L28;
        Uid.m7814$$Nest$mmarkProcessForegroundTimeUs(r0.mUidStats.valueAt(i2), elapsedRealtimeMs, false);
        i2 = i2 + 1;
        goto L25
    L28:
        return;
    L29:
        int i3 = 0;
        long totalScreenOnChargeUC = 0;
    L30:
        long r4 = 0;
        if (i3 >= numDisplays) goto L40;
        long chargeUC = chargesUC[i3];
        if (chargeUC <= 0) goto L38;
        int powerBucket = EnergyConsumerStats.getDisplayPowerBucket(oldScreenStates[i3]);
        r0.mGlobalEnergyConsumerStats.updateStandardBucket(powerBucket, chargeUC);
        if (powerBucket != 0) goto L38;
        totalScreenOnChargeUC = totalScreenOnChargeUC + chargeUC;
    L38:
        i3 = i3 + 1;
        goto L30
    L40:
        if (totalScreenOnChargeUC > 0) goto L42;
        return;
    L42:
        SparseDoubleArray fgTimeUsArray = new SparseDoubleArray();
        long r12 = 1000 * elapsedRealtimeMs;
        int uidStatsSize2 = r0.mUidStats.size();
        int i4 = 0;
    L43:
        if (i4 >= uidStatsSize2) goto L49;
        Uid uid = r0.mUidStats.valueAt(i4);
        long r16 = r4;
        long fgTimeUs = Uid.m7814$$Nest$mmarkProcessForegroundTimeUs(uid, elapsedRealtimeMs, true);
        if (fgTimeUs == r16) goto L48;
        fgTimeUsArray.put(uid.getUid(), fgTimeUs);
    L48:
        i4 = i4 + 1;
        r0 = this;
        r4 = r16;
        totalScreenOnChargeUC = totalScreenOnChargeUC;
        goto L43
    L49:
        distributeEnergyToUidsLocked(0, totalScreenOnChargeUC, fgTimeUsArray, 0.0d, elapsedRealtimeMs);
        return;
    L8:
        int numDisplays2 = r0.mDisplayMismatchWtfCount;
        r0.mDisplayMismatchWtfCount = numDisplays2 + 1;
        if ((numDisplays2 % 100) != 0) goto L12;
        Slog.wtf(TAG, "Mismatch between PowerProfile reported display count (" + r0.mPerDisplayBatteryStats.length + ") and PowerStatsHal reported display count (" + screenStates.length + ")");
    L12:
        if (r0.mPerDisplayBatteryStats.length >= screenStates.length) goto L14;
        int r1 = r0.mPerDisplayBatteryStats.length;
    L15:
        numDisplays = r1;
        goto L16
    L14:
        r1 = screenStates.length;
        goto L15
    }

    public void updateGnssEnergyConsumerStatsLocked(long chargeUC, long elapsedRealtimeMs) {
        if (this.mGlobalEnergyConsumerStats != null) goto L6;
        return;
    L6:
        if (this.mOnBatteryInternal == true) goto L8;
        return;
    L8:
        if (chargeUC > 0) goto L11;
        return;
    L11:
        if (this.mIgnoreNextExternalStats == false) goto L17;
        int uidStatsSize = this.mUidStats.size();
        int i = 0;
    L13:
        if (i >= uidStatsSize) goto L16;
        Uid.m7813$$Nest$mmarkGnssTimeUs(this.mUidStats.valueAt(i), elapsedRealtimeMs);
        i = i + 1;
        goto L13
    L16:
        return;
    L17:
        this.mGlobalEnergyConsumerStats.updateStandardBucket(6, chargeUC);
        SparseDoubleArray gnssTimeUsArray = new SparseDoubleArray();
        int uidStatsSize2 = this.mUidStats.size();
        int i2 = 0;
    L18:
        if (i2 >= uidStatsSize2) goto L24;
        Uid uid = this.mUidStats.valueAt(i2);
        long gnssTimeUs = Uid.m7813$$Nest$mmarkGnssTimeUs(uid, elapsedRealtimeMs);
        if (gnssTimeUs == 0) goto L23;
        gnssTimeUsArray.put(uid.getUid(), gnssTimeUs);
    L23:
        i2 = i2 + 1;
        goto L18
    L24:
        distributeEnergyToUidsLocked(6, chargeUC, gnssTimeUsArray, 0.0d, elapsedRealtimeMs);
    }

    public void updateCameraEnergyConsumerStatsLocked(long chargeUC, long elapsedRealtimeMs) {
        if (this.mGlobalEnergyConsumerStats != null) goto L6;
        return;
    L6:
        if (this.mOnBatteryInternal == true) goto L8;
        return;
    L8:
        if (chargeUC > 0) goto L11;
        return;
    L11:
        if (this.mIgnoreNextExternalStats == false) goto L17;
        int uidStatsSize = this.mUidStats.size();
        int i = 0;
    L13:
        if (i >= uidStatsSize) goto L16;
        Uid.m7812$$Nest$mmarkCameraTimeUs(this.mUidStats.valueAt(i), elapsedRealtimeMs);
        i = i + 1;
        goto L13
    L16:
        return;
    L17:
        this.mGlobalEnergyConsumerStats.updateStandardBucket(8, chargeUC);
        SparseDoubleArray cameraTimeUsArray = new SparseDoubleArray();
        int uidStatsSize2 = this.mUidStats.size();
        int i2 = 0;
    L18:
        if (i2 >= uidStatsSize2) goto L24;
        Uid uid = this.mUidStats.valueAt(i2);
        long cameraTimeUs = Uid.m7812$$Nest$mmarkCameraTimeUs(uid, elapsedRealtimeMs);
        if (cameraTimeUs == 0) goto L23;
        cameraTimeUsArray.put(uid.getUid(), cameraTimeUs);
    L23:
        i2 = i2 + 1;
        goto L18
    L24:
        distributeEnergyToUidsLocked(8, chargeUC, cameraTimeUsArray, 0.0d, elapsedRealtimeMs);
    }

    public void updateCustomEnergyConsumerStatsLocked(int customPowerBucket, long totalChargeUC, SparseLongArray uidCharges) {
        if (this.mGlobalEnergyConsumerStats != null) goto L6;
        return;
    L6:
        if (this.mOnBatteryInternal == false) goto L30;
        if (this.mIgnoreNextExternalStats == true) goto L30;
        if (totalChargeUC <= 0) goto L36;
        this.mGlobalEnergyConsumerStats.updateCustomBucket(customPowerBucket, totalChargeUC, this.mClock.elapsedRealtime());
        if (uidCharges != null) goto L15;
        return;
    L15:
        int numUids = uidCharges.size();
        int i = 0;
    L16:
        if (i >= numUids) goto L28;
        int uidInt = mapUid(uidCharges.keyAt(i));
        long uidChargeUC = uidCharges.valueAt(i);
        if (uidChargeUC == 0) goto L26;
        Uid uidObj = getAvailableUidStatsLocked(uidInt);
        if (uidObj == null) goto L24;
        Uid.m7807$$Nest$maddChargeToCustomBucketLocked(uidObj, uidChargeUC, customPowerBucket);
        goto L26
    L24:
        if (Process.isIsolated(uidInt) == true) goto L26;
        Slog.w(TAG, "Received EnergyConsumer charge " + totalChargeUC + " for custom bucket " + customPowerBucket + " for non-existent uid " + uidInt);
    L26:
        i = i + 1;
        goto L16
    L28:
        return;
    L36:
        return;
    }

    private void distributeEnergyToUidsLocked(int bucket, long totalConsumedChargeUC, SparseDoubleArray ratioNumerators, double minRatioDenominator, long timestampMs) {
        double sumRatioNumerators = 0.0d;
        int i = ratioNumerators.size() - 1;
    L3:
        if (i < 0) goto L5;
        sumRatioNumerators = sumRatioNumerators + ratioNumerators.valueAt(i);
        i = i - 1;
        goto L3
    L5:
        double ratioDenominator = Math.max(sumRatioNumerators, minRatioDenominator);
        if (ratioDenominator > 0.0d) goto L8;
        return;
    L8:
        int i2 = ratioNumerators.size() - 1;
    L9:
        if (i2 < 0) goto L12;
        Uid uid = getAvailableUidStatsLocked(ratioNumerators.keyAt(i2));
        double ratioNumerator = ratioNumerators.valueAt(i2);
        long uidActualUC = (long) (((totalConsumedChargeUC * ratioNumerator) / ratioDenominator) + 0.5d);
        Uid.m7808$$Nest$maddChargeToStandardBucketLocked(uid, uidActualUC, bucket, timestampMs);
        i2 = i2 - 1;
        goto L9
    }

    public void updateRailStatsLocked() {
        if (this.mCustomEnergyConsumerPowerStatsCollector.isEnabled() == false) goto L7;
        this.mCustomEnergyConsumerPowerStatsCollector.schedule();
        return;
    L7:
        if (this.mEnergyConsumerRetriever != null) goto L9;
        return;
    L9:
        if (this.mTmpRailStats.isRailStatsAvailable() == false) goto L14;
        this.mEnergyConsumerRetriever.fillRailDataStats(this.mTmpRailStats);
        return;
    }

    public void informThatAllExternalStatsAreFlushed() {
        monitor-enter(this);
        this.mIgnoreNextExternalStats = false;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateKernelWakelocksLocked(long elapsedRealtimeUs) {
        if (this.mKernelWakelockReader != null) goto L5;
        return;
    L5:
        KernelWakelockStats wakelockStats = this.mKernelWakelockReader.readKernelWakelockStats(this.mTmpWakelockStats);
        if (wakelockStats != null) goto L9;
        Slog.w(TAG, "Couldn't get kernel wake lock stats");
        return;
    L9:
        Iterator<Map.Entry<String, KernelWakelockStats.Entry>> r2 = wakelockStats.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        Map.Entry<String, KernelWakelockStats.Entry> ent = r2.next();
        String name = ent.getKey();
        KernelWakelockStats.Entry kws = ent.getValue();
        SamplingTimer kwlt = this.mKernelWakelockStats.get(name);
        if (kwlt != null) goto L16;
        kwlt = new SamplingTimer(this.mClock, this.mOnBatteryScreenOffTimeBase);
        this.mKernelWakelockStats.put(name, kwlt);
    L16:
        SamplingTimer kwlt2 = kwlt;
        kwlt2.update(kws.totalTimeUs, kws.activeTimeUs, kws.count, elapsedRealtimeUs);
        kwlt2.setUpdateVersion(kws.version);
        goto L11
    L17:
        int numWakelocksSetStale = 0;
        Iterator<Map.Entry<String, SamplingTimer>> r3 = this.mKernelWakelockStats.entrySet().iterator();
    L19:
        if (r3.hasNext() == false) goto L26;
        SamplingTimer st = r3.next().getValue();
        if (st.getUpdateVersion() == wakelockStats.kernelWakelockVersion) goto L19;
        st.endSample(elapsedRealtimeUs);
        numWakelocksSetStale = numWakelocksSetStale + 1;
        goto L19
    }

    public void updateKernelMemoryBandwidthLocked(long elapsedRealtimeUs) {
        this.mKernelMemoryBandwidthStats.updateStats();
        LongSparseLongArray bandwidthEntries = this.mKernelMemoryBandwidthStats.getBandwidthEntries();
        int bandwidthEntryCount = bandwidthEntries.size();
        int i = 0;
    L3:
        if (i >= bandwidthEntryCount) goto L10;
        int index = this.mKernelMemoryStats.indexOfKey(bandwidthEntries.keyAt(i));
        if (index < 0) goto L7;
        SamplingTimer timer = this.mKernelMemoryStats.valueAt(index);
    L8:
        timer.update(bandwidthEntries.valueAt(i), 1, elapsedRealtimeUs);
        i = i + 1;
        goto L3
    L7:
        timer = new SamplingTimer(this.mClock, this.mOnBatteryTimeBase);
        this.mKernelMemoryStats.put(bandwidthEntries.keyAt(i), timer);
        goto L8
    }

    public boolean isOnBatteryLocked() {
        return this.mOnBatteryTimeBase.isRunning();
    }

    public boolean isOnBatteryScreenOffLocked() {
        return this.mOnBatteryScreenOffTimeBase.isRunning();
    }

    public void updateCpuTimeLocked(boolean onBattery, boolean onBatteryScreenOff, long[] cpuClusterChargeUC) {
        ArrayList<StopwatchTimer> partialTimersToConsider = null;
        if (onBatteryScreenOff == false) goto L14;
        partialTimersToConsider = new ArrayList();
        int i = this.mPartialTimers.size() - 1;
    L5:
        if (i < 0) goto L14;
        StopwatchTimer timer = this.mPartialTimers.get(i);
        if (timer.mInList == false) goto L13;
        if (timer.mUid == null) goto L13;
        if (timer.mUid.mUid == 1000) goto L13;
        partialTimersToConsider.add(timer);
    L13:
        i = i - 1;
    L14:
        markPartialTimersAsEligible();
        SparseLongArray updatedUids = null;
        if (onBattery == true) goto L27;
        this.mCpuUidUserSysTimeReader.readDelta(false, null);
        this.mCpuUidFreqTimeReader.readDelta(false, null);
        this.mNumAllUidCpuTimeReads += 2;
        if (this.mConstants.TRACK_CPU_ACTIVE_CLUSTER_TIME == false) goto L19;
        this.mCpuUidActiveTimeReader.readDelta(false, null);
        this.mCpuUidClusterTimeReader.readDelta(false, null);
        this.mNumAllUidCpuTimeReads += 2;
    L19:
        int i2 = this.mKernelCpuSpeedReaders.length - 1;
    L20:
        if (i2 < 0) goto L26;
        if (this.mKernelCpuSpeedReaders[i2] == null) goto L24;
        this.mKernelCpuSpeedReaders[i2].readDelta();
    L24:
        i2 = i2 - 1;
        goto L20
    L26:
        return;
    L27:
        this.mUserInfoProvider.refreshUserIds();
        if (this.mCpuUidFreqTimeReader.allUidTimesAvailable() == true) goto L32;
        updatedUids = new SparseLongArray();
    L32:
        if (this.mGlobalEnergyConsumerStats != null) goto L34;
    L41:
        CpuDeltaPowerAccumulator powerAccumulator = null;
    L42:
        readKernelUidCpuTimesLocked(partialTimersToConsider, updatedUids, onBattery);
        if (updatedUids == null) goto L45;
        updateClusterSpeedTimes(updatedUids, onBattery, powerAccumulator);
    L45:
        readKernelUidCpuFreqTimesLocked(partialTimersToConsider, onBattery, onBatteryScreenOff, powerAccumulator);
        this.mNumAllUidCpuTimeReads += 2;
        if (this.mConstants.TRACK_CPU_ACTIVE_CLUSTER_TIME == false) goto L49;
        readKernelUidCpuActiveTimesLocked(onBattery);
        readKernelUidCpuClusterTimesLocked(onBattery, powerAccumulator);
        this.mNumAllUidCpuTimeReads += 2;
    L49:
        if (powerAccumulator == null) goto L60;
        updateCpuEnergyConsumerStatsLocked(cpuClusterChargeUC, powerAccumulator);
        return;
    L60:
        return;
    L34:
        if (this.mGlobalEnergyConsumerStats.isStandardBucketSupported(3) == false) goto L41;
        if (cpuClusterChargeUC != null) goto L38;
        Slog.wtf(TAG, "POWER_BUCKET_CPU supported but no EnergyConsumer Cpu Cluster charge reported on updateCpuTimeLocked!");
        powerAccumulator = null;
        goto L42
    L38:
        if (this.mCpuPowerCalculator != null) goto L40;
        this.mCpuPowerCalculator = new CpuPowerCalculator(this.mCpuScalingPolicies, this.mPowerProfile);
    L40:
        powerAccumulator = new CpuDeltaPowerAccumulator(this.mCpuPowerCalculator, this.mCpuScalingPolicies.getPolicies().length);
        goto L42
    }

    public void updateSystemServerThreadStats() {
        SystemServerCpuThreadReader.SystemServiceCpuThreadTimes systemServiceCpuThreadTimes = this.mSystemServerCpuThreadReader.readDelta();
        if (systemServiceCpuThreadTimes != null) goto L6;
        return;
    L6:
        if (this.mBinderThreadCpuTimesUs != null) goto L8;
        this.mBinderThreadCpuTimesUs = new LongSamplingCounterArray(this.mOnBatteryTimeBase);
    L8:
        this.mBinderThreadCpuTimesUs.addCountLocked(systemServiceCpuThreadTimes.binderThreadCpuTimesUs);
    }

    public void markPartialTimersAsEligible() {
        if (ArrayUtils.referenceEquals(this.mPartialTimers, this.mLastPartialTimers) == false) goto L8;
        int i = this.mPartialTimers.size() - 1;
    L5:
        if (i < 0) goto L14;
        this.mPartialTimers.get(i).mInList = true;
        i = i - 1;
        goto L5
    L14:
        return;
    L8:
        int i2 = this.mLastPartialTimers.size() - 1;
    L9:
        if (i2 < 0) goto L11;
        this.mLastPartialTimers.get(i2).mInList = false;
        i2 = i2 - 1;
        goto L9
    L11:
        this.mLastPartialTimers.clear();
        int numPartialTimers = this.mPartialTimers.size();
        int i3 = 0;
    L12:
        if (i3 >= numPartialTimers) goto L18;
        StopwatchTimer timer = this.mPartialTimers.get(i3);
        timer.mInList = true;
        this.mLastPartialTimers.add(timer);
        i3 = i3 + 1;
        goto L12
    }

    public void updateClusterSpeedTimes(SparseLongArray updatedUids, boolean onBattery, CpuDeltaPowerAccumulator powerAccumulator) {
        BatteryStatsImpl r0 = this;
        long[][] clusterSpeedTimesMs = new long[r0.mKernelCpuSpeedReaders.length][];
        int cluster = 0;
        long totalCpuClustersTimeMs = 0;
    L4:
        if (cluster >= r0.mKernelCpuSpeedReaders.length) goto L14;
        if (r0.mKernelCpuSpeedReaders[cluster] == null) goto L12;
        clusterSpeedTimesMs[cluster] = r0.mKernelCpuSpeedReaders[cluster].readDelta();
        if (clusterSpeedTimesMs[cluster] == null) goto L12;
        int speed = clusterSpeedTimesMs[cluster].length - 1;
    L10:
        if (speed < 0) goto L12;
        totalCpuClustersTimeMs = totalCpuClustersTimeMs + clusterSpeedTimesMs[cluster][speed];
        speed = speed - 1;
    L12:
        cluster = cluster + 1;
        goto L4
    L14:
        if (totalCpuClustersTimeMs == 0) goto L47;
        int updatedUidsCount = updatedUids.size();
        long elapsedRealtimeMs = r0.mClock.elapsedRealtime();
        long uptimeMs = r0.mClock.uptimeMillis();
        int i = 0;
    L16:
        if (i >= updatedUidsCount) goto L57;
        Uid u = r0.getUidStatsLocked(updatedUids.keyAt(i), elapsedRealtimeMs, uptimeMs);
        long appCpuTimeUs = updatedUids.valueAt(i);
        int[] policies = r0.mCpuScalingPolicies.getPolicies();
        if (u.mCpuClusterSpeedTimesUs != null) goto L20;
    L21:
        u.mCpuClusterSpeedTimesUs = new LongSamplingCounter[policies.length][];
    L22:
        int cluster2 = 0;
    L24:
        if (cluster2 >= policies.length) goto L44;
        int speedsInCluster = clusterSpeedTimesMs[cluster2].length;
        if (u.mCpuClusterSpeedTimesUs[cluster2] != null) goto L28;
    L31:
        u.mCpuClusterSpeedTimesUs[cluster2] = new LongSamplingCounter[speedsInCluster];
    L32:
        LongSamplingCounter[] cpuSpeeds = u.mCpuClusterSpeedTimesUs[cluster2];
        int speed2 = 0;
    L33:
        if (speed2 >= speedsInCluster) goto L43;
        if (cpuSpeeds[speed2] != null) goto L37;
        LongSamplingCounter[] cpuSpeeds2 = cpuSpeeds;
        cpuSpeeds2[speed2] = new LongSamplingCounter(r0.mOnBatteryTimeBase);
    L38:
        long deltaSpeedCount = (clusterSpeedTimesMs[cluster2][speed2] * appCpuTimeUs) / totalCpuClustersTimeMs;
        cpuSpeeds2[speed2].addCountLocked(deltaSpeedCount, onBattery);
        if (powerAccumulator == null) goto L42;
        powerAccumulator.addCpuClusterSpeedDurationsMs(u, cluster2, speed2, deltaSpeedCount);
    L42:
        speed2 = speed2 + 1;
        r0 = this;
        speedsInCluster = speedsInCluster;
        cpuSpeeds = cpuSpeeds2;
        elapsedRealtimeMs = elapsedRealtimeMs;
        goto L33
    L37:
        cpuSpeeds2 = cpuSpeeds;
        goto L38
    L43:
        cluster2 = cluster2 + 1;
        r0 = this;
        policies = policies;
        goto L24
    L28:
        if (speedsInCluster == u.mCpuClusterSpeedTimesUs[cluster2].length) goto L32;
    L44:
        i = i + 1;
        r0 = this;
        goto L16
    L20:
        if (u.mCpuClusterSpeedTimesUs.length == policies.length) goto L22;
    L57:
        return;
    }

    /* JADX WARN: Failed to calculate best type for var: r14v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: long
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
    /* JADX WARN: Failed to calculate best type for var: r14v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: long
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
    /* JADX WARN: Failed to calculate best type for var: r14v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v2 ??, new type: long
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
    /* JADX WARN: Failed to calculate best type for var: r14v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v3 ??, new type: long
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
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: long
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
    public void readKernelUidCpuTimesLocked(java.util.ArrayList<com.android.server.power.stats.BatteryStatsImpl.StopwatchTimer> r22, android.util.SparseLongArray r23, boolean r24) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005e: IGET (r14v1 ?? I:long) = (r21v0 'this' com.android.server.power.stats.BatteryStatsImpl A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] (LINE:14621) com.android.server.power.stats.BatteryStatsImpl.mTempTotalCpuUserTimeUs long in method: com.android.server.power.stats.BatteryStatsImpl.readKernelUidCpuTimesLocked(java.util.ArrayList<com.android.server.power.stats.BatteryStatsImpl$StopwatchTimer>, android.util.SparseLongArray, boolean):void, file: classes3.dex
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
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.power.stats.BatteryStatsImpl.readKernelUidCpuTimesLocked(java.util.ArrayList, android.util.SparseLongArray, boolean):void");
    }

    private /* synthetic */ void lambda$readKernelUidCpuTimesLocked$3(long elapsedRealtimeMs, long startTimeMs, int numWakelocks, boolean onBattery, SparseLongArray updatedUids, int uid, long[] timesUs) {
        long userTimeUs = timesUs[0];
        long systemTimeUs = timesUs[1];
        int uid2 = mapUid(uid);
        if (Process.isIsolated(uid2) == false) goto L6;
        return;
    L6:
        if (this.mUserInfoProvider.exists(UserHandle.getUserId(uid2)) == true) goto L8;
        return;
    L8:
        Uid u = getUidStatsLocked(uid2, elapsedRealtimeMs, startTimeMs);
        this.mTempTotalCpuUserTimeUs += userTimeUs;
        this.mTempTotalCpuSystemTimeUs += systemTimeUs;
        StringBuilder sb = null;
        if (numWakelocks <= 0) goto L11;
        userTimeUs = (userTimeUs * 50) / 100;
        systemTimeUs = (50 * systemTimeUs) / 100;
    L11:
        if (0 == 0) goto L13;
        sb.append("  adding to uid=");
        sb.append(u.mUid);
        sb.append(": u=");
        TimeUtils.formatDuration(userTimeUs / 1000, null);
        sb.append(" s=");
        TimeUtils.formatDuration(systemTimeUs / 1000, null);
        Slog.d(TAG, sb.toString());
    L13:
        u.mUserCpuTime.addCountLocked(userTimeUs, onBattery);
        u.mSystemCpuTime.addCountLocked(systemTimeUs, onBattery);
        if (updatedUids == null) goto L17;
        updatedUids.put(u.getUid(), userTimeUs + systemTimeUs);
        return;
    }

    public void readKernelUidCpuFreqTimesLocked(ArrayList<StopwatchTimer> partialTimers, final boolean onBattery, final boolean onBatteryScreenOff, final CpuDeltaPowerAccumulator powerAccumulator) {
        final boolean perClusterTimesAvailable = this.mCpuUidFreqTimeReader.perClusterTimesAvailable();
        boolean r0 = false;
        if (partialTimers != null) goto L5;
        final int numWakelocks = 0;
    L6:
        final int[] policies = this.mCpuScalingPolicies.getPolicies();
        final int numClusters = policies.length;
        this.mWakeLockAllocationsUs = null;
        final long startTimeMs = this.mClock.uptimeMillis();
        final long elapsedRealtimeMs = this.mClock.elapsedRealtime();
        if (powerAccumulator == null) goto L9;
        r0 = true;
    L9:
        boolean forceRead = r0;
        this.mCpuUidFreqTimeReader.readDelta(forceRead, new BatteryStatsImpl$$ExternalSyntheticLambda3(this, elapsedRealtimeMs, startTimeMs, onBattery, onBatteryScreenOff, perClusterTimesAvailable, numClusters, numWakelocks, policies, powerAccumulator));
        long elapsedTimeMs = this.mClock.uptimeMillis() - startTimeMs;
        if (elapsedTimeMs < 100) goto L13;
        Slog.d(TAG, "Reading cpu freq times took " + elapsedTimeMs + "ms");
    L13:
        if (this.mWakeLockAllocationsUs == null) goto L43;
        int i = 0;
    L15:
        if (i >= numWakelocks) goto L49;
        Uid u = partialTimers.get(i).mUid;
        if (u.mCpuClusterSpeedTimesUs != null) goto L19;
    L20:
        detachIfNotNull(u.mCpuClusterSpeedTimesUs);
        u.mCpuClusterSpeedTimesUs = new LongSamplingCounter[numClusters][];
    L21:
        int speed = 0;
    L22:
        if (speed >= numClusters) goto L40;
        int speedsInCluster = this.mCpuScalingPolicies.getFrequencies(policies[speed]).length;
        if (u.mCpuClusterSpeedTimesUs[speed] != null) goto L26;
    L27:
        detachIfNotNull(u.mCpuClusterSpeedTimesUs[speed]);
        u.mCpuClusterSpeedTimesUs[speed] = new LongSamplingCounter[speedsInCluster];
    L28:
        LongSamplingCounter[] cpuTimeUs = u.mCpuClusterSpeedTimesUs[speed];
        int speed2 = 0;
    L29:
        if (speed2 >= speedsInCluster) goto L39;
        if (cpuTimeUs[speed2] != null) goto L34;
        cpuTimeUs[speed2] = new LongSamplingCounter(this.mOnBatteryTimeBase);
    L34:
        long elapsedTimeMs2 = elapsedTimeMs;
        long allocationUs = this.mWakeLockAllocationsUs[speed][speed2] / ((long) (numWakelocks - i));
        cpuTimeUs[speed2].addCountLocked(allocationUs, onBattery);
        long[] r1 = this.mWakeLockAllocationsUs[speed];
        r1[speed2] = r1[speed2] - allocationUs;
        if (powerAccumulator == null) goto L37;
        Uid u2 = u;
        int cluster = speed;
        int cluster2 = speed2;
        powerAccumulator.addCpuClusterSpeedDurationsMs(u2, cluster, cluster2, allocationUs / 1000);
    L38:
        speed2 = cluster2 + 1;
        speed = cluster;
        i = i;
        u = u2;
        elapsedTimeMs = elapsedTimeMs2;
        goto L29
    L37:
        u2 = u;
        cluster = speed;
        cluster2 = speed2;
        goto L38
    L39:
        Uid u3 = u;
        int cluster3 = speed;
        speed = cluster3 + 1;
        u = u3;
        elapsedTimeMs = elapsedTimeMs;
        goto L22
    L26:
        if (u.mCpuClusterSpeedTimesUs[speed].length == speedsInCluster) goto L28;
    L40:
        i = i + 1;
        elapsedTimeMs = elapsedTimeMs;
        goto L15
    L19:
        if (u.mCpuClusterSpeedTimesUs.length == numClusters) goto L21;
    L49:
        return;
    L43:
        return;
    L5:
        numWakelocks = partialTimers.size();
        goto L6
    }

    private /* synthetic */ void lambda$readKernelUidCpuFreqTimesLocked$4(long elapsedRealtimeMs, long startTimeMs, boolean onBattery, boolean onBatteryScreenOff, boolean perClusterTimesAvailable, int numClusters, int numWakelocks, int[] policies, CpuDeltaPowerAccumulator powerAccumulator, int uid, long[] cpuFreqTimeMs) {
        BatteryStatsImpl r0 = this;
        int uid2 = r0.mapUid(uid);
        if (Process.isIsolated(uid2) == false) goto L6;
        return;
    L6:
        if (r0.mUserInfoProvider.exists(UserHandle.getUserId(uid2)) == true) goto L8;
        return;
    L8:
        Uid u = r0.getUidStatsLocked(uid2, elapsedRealtimeMs, startTimeMs);
        if (u.mCpuFreqTimeMs != null) goto L11;
    L12:
        detachIfNotNull(u.mCpuFreqTimeMs);
        u.mCpuFreqTimeMs = new LongSamplingCounterArray(r0.mOnBatteryTimeBase);
    L13:
        u.mCpuFreqTimeMs.addCountLocked(cpuFreqTimeMs, onBattery);
        if (u.mScreenOffCpuFreqTimeMs != null) goto L16;
    L17:
        detachIfNotNull(u.mScreenOffCpuFreqTimeMs);
        u.mScreenOffCpuFreqTimeMs = new LongSamplingCounterArray(r0.mOnBatteryScreenOffTimeBase);
    L18:
        u.mScreenOffCpuFreqTimeMs.addCountLocked(cpuFreqTimeMs, onBatteryScreenOff);
        if (perClusterTimesAvailable == false) goto L57;
        if (u.mCpuClusterSpeedTimesUs != null) goto L23;
    L24:
        detachIfNotNull(u.mCpuClusterSpeedTimesUs);
        u.mCpuClusterSpeedTimesUs = new LongSamplingCounter[numClusters][];
    L25:
        if (numWakelocks > 0) goto L27;
    L29:
        int freqIndex = 0;
        int cluster = 0;
    L30:
        if (cluster >= numClusters) goto L62;
        int[] freqs = r0.mCpuScalingPolicies.getFrequencies(policies[cluster]);
        if (u.mCpuClusterSpeedTimesUs[cluster] != null) goto L34;
    L35:
        detachIfNotNull(u.mCpuClusterSpeedTimesUs[cluster]);
        u.mCpuClusterSpeedTimesUs[cluster] = new LongSamplingCounter[freqs.length];
    L36:
        if (numWakelocks > 0) goto L38;
    L40:
        LongSamplingCounter[] cpuTimesUs = u.mCpuClusterSpeedTimesUs[cluster];
        int speed = 0;
    L42:
        if (speed >= freqs.length) goto L54;
        if (cpuTimesUs[speed] != null) goto L47;
        cpuTimesUs[speed] = new LongSamplingCounter(r0.mOnBatteryTimeBase);
    L47:
        if (r0.mWakeLockAllocationsUs == null) goto L49;
        long appAllocationUs = ((cpuFreqTimeMs[freqIndex] * 1000) * 50) / 100;
        long[] r9 = r0.mWakeLockAllocationsUs[cluster];
        r9[speed] = r9[speed] + ((cpuFreqTimeMs[freqIndex] * 1000) - appAllocationUs);
        long appAllocationUs2 = appAllocationUs;
    L50:
        cpuTimesUs[speed].addCountLocked(appAllocationUs2, onBattery);
        if (powerAccumulator == null) goto L53;
        powerAccumulator.addCpuClusterSpeedDurationsMs(u, cluster, speed, appAllocationUs2 / 1000);
    L53:
        freqIndex = freqIndex + 1;
        speed = speed + 1;
        r0 = this;
        uid2 = uid2;
        goto L42
    L49:
        long appAllocationUs3 = cpuFreqTimeMs[freqIndex];
        appAllocationUs2 = appAllocationUs3 * 1000;
        goto L50
    L54:
        cluster = cluster + 1;
        r0 = this;
        goto L30
    L38:
        if (r0.mWakeLockAllocationsUs[cluster] != null) goto L40;
        r0.mWakeLockAllocationsUs[cluster] = new long[freqs.length];
        goto L40
    L34:
        if (u.mCpuClusterSpeedTimesUs[cluster].length == freqs.length) goto L36;
    L62:
        return;
    L27:
        if (r0.mWakeLockAllocationsUs != null) goto L29;
        r0.mWakeLockAllocationsUs = new long[numClusters][];
        goto L29
    L23:
        if (u.mCpuClusterSpeedTimesUs.length == numClusters) goto L25;
    L57:
        return;
    L16:
        if (u.mScreenOffCpuFreqTimeMs.getSize() == cpuFreqTimeMs.length) goto L18;
    L11:
        if (u.mCpuFreqTimeMs.getSize() == cpuFreqTimeMs.length) goto L13;
        goto L12
    }

    public void readKernelUidCpuActiveTimesLocked(boolean onBattery) {
        final long startTimeMs = this.mClock.uptimeMillis();
        final long elapsedRealtimeMs = this.mClock.elapsedRealtime();
        this.mCpuUidActiveTimeReader.readAbsolute(new BatteryStatsImpl$$ExternalSyntheticLambda1(this, elapsedRealtimeMs, startTimeMs));
        long elapsedTimeMs = this.mClock.uptimeMillis() - startTimeMs;
        if (elapsedTimeMs < 100) goto L6;
        Slog.d(TAG, "Reading cpu active times took " + elapsedTimeMs + "ms");
        return;
    }

    private /* synthetic */ void lambda$readKernelUidCpuActiveTimesLocked$5(long elapsedRealtimeMs, long startTimeMs, int uid, Long cpuActiveTimesMs) {
        int parentUid = mapUid(uid);
        if (Process.isIsolated(parentUid) == false) goto L6;
        return;
    L6:
        if (this.mUserInfoProvider.exists(UserHandle.getUserId(uid)) == true) goto L8;
        return;
    L8:
        Uid u = getUidStatsLocked(parentUid, elapsedRealtimeMs, startTimeMs);
        if (parentUid != uid) goto L11;
        TimeMultiStateCounter.m7793$$Nest$mupdate(Uid.m7809$$Nest$mgetCpuActiveTimeCounter(u), cpuActiveTimesMs.longValue(), elapsedRealtimeMs);
        return;
    L11:
        SparseArray<Uid.ChildUid> childUids = u.mChildUids;
        if (childUids != null) goto L14;
        return;
    L14:
        Uid.ChildUid childUid = childUids.get(uid);
        if (childUid == null) goto L19;
        long delta = TimeMultiStateCounter.m7793$$Nest$mupdate(childUid.cpuActiveCounter, cpuActiveTimesMs.longValue(), elapsedRealtimeMs);
        TimeMultiStateCounter.m7791$$Nest$mincrement(Uid.m7809$$Nest$mgetCpuActiveTimeCounter(u), delta, elapsedRealtimeMs);
        return;
    }

    public void readKernelUidCpuClusterTimesLocked(final boolean onBattery, final CpuDeltaPowerAccumulator powerAccumulator) {
        final long startTimeMs = this.mClock.uptimeMillis();
        final long elapsedRealtimeMs = this.mClock.elapsedRealtime();
        if (powerAccumulator == null) goto L5;
        boolean forceRead = true;
    L6:
        this.mCpuUidClusterTimeReader.readDelta(forceRead, new BatteryStatsImpl$$ExternalSyntheticLambda4(this, elapsedRealtimeMs, startTimeMs, onBattery, powerAccumulator));
        long elapsedTimeMs = this.mClock.uptimeMillis() - startTimeMs;
        if (elapsedTimeMs < 100) goto L10;
        Slog.d(TAG, "Reading cpu cluster times took " + elapsedTimeMs + "ms");
        return;
    L10:
        return;
    L5:
        forceRead = false;
        goto L6
    }

    private /* synthetic */ void lambda$readKernelUidCpuClusterTimesLocked$6(long elapsedRealtimeMs, long startTimeMs, boolean onBattery, CpuDeltaPowerAccumulator powerAccumulator, int uid, long[] cpuClusterTimesMs) {
        int uid2 = mapUid(uid);
        if (Process.isIsolated(uid2) == false) goto L6;
        return;
    L6:
        if (this.mUserInfoProvider.exists(UserHandle.getUserId(uid2)) == true) goto L8;
        return;
    L8:
        Uid u = getUidStatsLocked(uid2, elapsedRealtimeMs, startTimeMs);
        u.mCpuClusterTimesMs.addCountLocked(cpuClusterTimesMs, onBattery);
        if (powerAccumulator == null) goto L12;
        powerAccumulator.addCpuClusterDurationsMs(u, cpuClusterTimesMs);
        return;
    }

    boolean setChargingLocked(boolean charging) {
        this.mHandler.removeCallbacks(this.mDeferSetCharging);
        if (this.mCharging == charging) goto L6;
        this.mCharging = charging;
        this.mHistory.setChargingState(charging);
        this.mHandler.sendEmptyMessage(3);
        return true;
    L6:
        return false;
    }

    public void onSystemReady(Context context) {
        if (this.mCpuUidFreqTimeReader == null) goto L5;
        this.mCpuUidFreqTimeReader.onSystemReady();
    L5:
        this.mStepDetailsProvider.onSystemReady();
        this.mPowerStatsCollectorInjector.setContext(context);
        this.mCpuPowerStatsCollector.setEnabled(this.mPowerStatsCollectorEnabled.get(1));
        this.mCpuPowerStatsCollector.schedule();
        this.mWakelockPowerStatsCollector.setEnabled(this.mPowerStatsCollectorEnabled.get(12));
        this.mWakelockPowerStatsCollector.schedule();
        this.mScreenPowerStatsCollector.setEnabled(this.mPowerStatsCollectorEnabled.get(0));
        this.mScreenPowerStatsCollector.schedule();
        this.mMobileRadioPowerStatsCollector.setEnabled(this.mPowerStatsCollectorEnabled.get(8));
        this.mMobileRadioPowerStatsCollector.schedule();
        this.mWifiPowerStatsCollector.setEnabled(this.mPowerStatsCollectorEnabled.get(11));
        this.mWifiPowerStatsCollector.schedule();
        this.mBluetoothPowerStatsCollector.setEnabled(this.mPowerStatsCollectorEnabled.get(2));
        this.mBluetoothPowerStatsCollector.schedule();
        this.mCameraPowerStatsCollector.setEnabled(this.mPowerStatsCollectorEnabled.get(3));
        this.mCameraPowerStatsCollector.schedule();
        this.mGnssPowerStatsCollector.setEnabled(this.mPowerStatsCollectorEnabled.get(10));
        this.mGnssPowerStatsCollector.schedule();
        this.mCustomEnergyConsumerPowerStatsCollector.setEnabled(this.mPowerStatsCollectorEnabled.get(-1));
        this.mCustomEnergyConsumerPowerStatsCollector.schedule();
        this.mSystemReady = true;
    }

    PowerStatsCollector getPowerStatsCollector(int powerComponent) {
        switch(powerComponent) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L3;
            case 5: goto L3;
            case 6: goto L3;
            case 7: goto L3;
            case 8: goto L12;
            case 9: goto L3;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return this.mWakelockPowerStatsCollector;
    L8:
        return this.mWifiPowerStatsCollector;
    L10:
        return this.mGnssPowerStatsCollector;
    L12:
        return this.mMobileRadioPowerStatsCollector;
    L14:
        return this.mCameraPowerStatsCollector;
    L16:
        return this.mBluetoothPowerStatsCollector;
    L18:
        return this.mCpuPowerStatsCollector;
    L20:
        return this.mScreenPowerStatsCollector;
    }

    public void forceRecordAllHistory() {
        this.mHistory.forceRecordAllHistory();
        this.mRecordAllHistory = true;
    }

    public void maybeResetWhilePluggedInLocked() {
        long elapsedRealtimeMs = this.mClock.elapsedRealtime();
        if (shouldResetWhilePluggedInLocked(elapsedRealtimeMs) == false) goto L5;
        Slog.i(TAG, "Resetting due to long plug in duration. elapsed time = " + elapsedRealtimeMs + " ms, last plug in time = " + this.mBatteryPluggedInRealTimeMs + " ms, last reset time = " + (this.mRealtimeStartUs / 1000));
        startNewSession(5);
    L5:
        scheduleNextResetWhilePluggedInCheck();
    }

    private void scheduleNextResetWhilePluggedInCheck() {
        if (this.mAlarmManager != null) goto L5;
        return;
    L5:
        long timeoutMs = this.mClock.currentTimeMillis() + (((long) this.mConstants.RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS) * 3600000);
        Calendar nextAlarm = Calendar.getInstance();
        nextAlarm.setTimeInMillis(timeoutMs);
        nextAlarm.set(14, 0);
        nextAlarm.set(13, 0);
        nextAlarm.set(12, 0);
        nextAlarm.set(11, 2);
        long possibleNextTimeMs = nextAlarm.getTimeInMillis();
        if (possibleNextTimeMs >= timeoutMs) goto L8;
        possibleNextTimeMs = possibleNextTimeMs + 86400000;
    L8:
        final long nextTimeMs = possibleNextTimeMs;
        final AlarmManager am = this.mAlarmManager;
        this.mHandler.post(new BatteryStatsImpl$$ExternalSyntheticLambda0(this, am, nextTimeMs));
    }

    private /* synthetic */ void lambda$scheduleNextResetWhilePluggedInCheck$7(AlarmManager am, long nextTimeMs) {
        am.setWindow(1, nextTimeMs, 3600000, TAG, this.mLongPlugInAlarmHandler, this.mHandler);
    }

    private boolean shouldResetWhilePluggedInLocked(long elapsedRealtimeMs) {
        if (this.mNoAutoReset == false) goto L6;
        return false;
    L6:
        if (this.mSystemReady == true) goto L9;
        return false;
    L9:
        if (this.mHistory.isResetEnabled() == true) goto L11;
        return false;
    L11:
        long pluggedInThresholdMs = this.mBatteryPluggedInRealTimeMs + (((long) this.mConstants.RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS) * 3600000);
        if (elapsedRealtimeMs < pluggedInThresholdMs) goto L17;
        long resetThresholdMs = (this.mRealtimeStartUs / 1000) + (((long) this.mConstants.RESET_WHILE_PLUGGED_IN_MINIMUM_DURATION_HOURS) * 3600000);
        if (elapsedRealtimeMs < resetThresholdMs) goto L17;
        return true;
    L17:
        return false;
    }

    private boolean shouldResetOnUnplugLocked(int batteryStatus, int batteryLevel) {
        if (this.mNoAutoReset == false) goto L6;
        return false;
    L6:
        if (this.mSystemReady == true) goto L9;
        return false;
    L9:
        if (this.mHistory.isResetEnabled() == true) goto L12;
        return false;
    L12:
        if (this.mBatteryStatsConfig.shouldResetOnUnplugHighBatteryLevel() == false) goto L20;
        if (batteryStatus != 5) goto L17;
        return true;
    L17:
        if (batteryLevel < 90) goto L20;
        return true;
    L20:
        if (this.mBatteryStatsConfig.shouldResetOnUnplugAfterSignificantCharge() == false) goto L27;
        if (this.mDischargePlugLevel >= 20) goto L27;
        if (batteryLevel < 80) goto L27;
        return true;
    L27:
        if (getHighDischargeAmountSinceCharge() < 200) goto L29;
        return true;
    L29:
        return false;
    }

    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v4 */
    protected void setOnBatteryLocked(long r26, long r28, boolean r30, int r31, int r32, int r33) {
        final BatteryStatsImpl r0 = this;
        boolean r11 = false;
        Message r12 = r0.mHandler.obtainMessage(2);
        r12.arg1 = r30 ? 1 : 0;
        r0.mHandler.sendMessage(r12);
        long r13 = r28 * 1000;
        long r15 = r26 * 1000;
        int r1 = r0.mScreenState;
        if (r30 == true) goto L5;
        r0.mOnBatteryInternal = false;
        r0.mOnBattery = false;
        r0.pullPendingStateUpdatesLocked();
        r0.mBatteryPluggedIn = true;
        r0.mBatteryPluggedInRealTimeMs = r26;
        r0.mHistory.recordBatteryState(r26, r28, r32, r0.mBatteryPluggedIn);
        r0.mDischargePlugLevel = r32;
        r0.mDischargeCurrentLevel = r32;
        if (r32 >= r0.mDischargeUnplugLevel) goto L37;
        r0.mLowDischargeAmountSinceCharge += (r0.mDischargeUnplugLevel - r32) - 1;
        r0.mHighDischargeAmountSinceCharge += r0.mDischargeUnplugLevel - r32;
    L37:
        r0.updateDischargeScreenLevelsLocked(r1, r1);
        r0 = r0;
        r0.updateTimeBasesLocked(false, r1, r13, r15);
        r0.mChargeStepTracker.init();
        r0.mLastChargeStepLevel = r32;
        r0.mMaxChargeStepLevel = r32;
        r0.mInitStepMode = r0.mCurStepMode;
        r0.mModStepMode = 0;
        r0.scheduleNextResetWhilePluggedInCheck();
    L38:
        if (r11 == true) goto L42;
        if ((r0.mLastWriteTimeMs + 60000) < r26) goto L42;
        return;
    L42:
        if (r0.mStatsFile != null) goto L44;
        return;
    L44:
        if (r0.mHistory.isReadOnly() == true) goto L49;
        r0.writeAsyncLocked();
        return;
    L49:
        return;
    L5:
        if (r0.shouldResetOnUnplugLocked(r31, r32) == false) goto L15;
        String r3 = r32 + "|" + r31 + "|" + r0.mDischargeCurrentLevel + "|" + r0.getHighDischargeAmountSinceCharge();
        Slog.i(TAG, "Resetting battery stats: level=" + r32 + " status=" + r31 + " dischargeLevel=" + r0.mDischargePlugLevel + " lowAmount=" + r0.getLowDischargeAmountSinceCharge() + " highAmount=" + r0.getHighDischargeAmountSinceCharge());
        if (r0.getLowDischargeAmountSinceCharge() < 20) goto L10;
        long r5 = SystemClock.uptimeMillis();
        final Parcel r2 = Parcel.obtain();
        r0.writeSummaryToParcel(r2, true);
        final long r4 = SystemClock.uptimeMillis() - r5;
        BackgroundThread.getHandler().post(new AnonymousClass9(r0, r2, r4));
    L10:
        r11 = true;
        r0.getBSImplOptEx().collectBeforeReset(r0, r3);
        r0.startNewSession(3);
        if (r33 <= 0) goto L14;
        if (r32 <= 0) goto L14;
        r0.mEstimatedBatteryCapacityMah = (int) (((double) (r33 / 1000)) / (((double) r32) / 100.0d));
    L14:
        r0.mDischargeStepTracker.init();
        boolean r6 = true;
    L17:
        if (r0.mCharging == false) goto L19;
        r0.setChargingLocked(false);
    L19:
        r0.mOnBatteryInternal = true;
        r0.mOnBattery = true;
        r0.mLastDischargeStepLevel = r32;
        r0.mMinDischargeStepLevel = r32;
        r0.mDischargeStepTracker.clearTime();
        r0.mDailyDischargeStepTracker.clearTime();
        r0.mInitStepMode = r0.mCurStepMode;
        r0.mModStepMode = 0;
        r0.pullPendingStateUpdatesLocked();
        if (r6 == false) goto L22;
        ?? r8 = 0;
        r0.mHistory.startRecordingHistory(r26, r28, r6);
        initActiveHistoryEventsLocked(r26, r28);
    L23:
        r0.mBatteryPluggedIn = r8;
        if (r0.mAlarmManager == null) goto L26;
        final AlarmManager r7 = r0.mAlarmManager;
        r0.mHandler.post(new BatteryStatsImpl$$ExternalSyntheticLambda6(r0, r7));
    L26:
        r0.mHistory.recordBatteryState(r26, r28, r32, r0.mBatteryPluggedIn);
        r0.mDischargeUnplugLevel = r32;
        r0.mDischargeCurrentLevel = r32;
        if (Display.isOnState(r1) == false) goto L30;
        r0.mDischargeScreenOnUnplugLevel = r32;
        r0.mDischargeScreenDozeUnplugLevel = r8;
        r0.mDischargeScreenOffUnplugLevel = r8;
    L33:
        r0.mDischargeAmountScreenOn = r8;
        r0.mDischargeAmountScreenDoze = r8;
        r0.mDischargeAmountScreenOff = r8;
        r0.updateTimeBasesLocked(true, r1, r13, r15);
        goto L38
    L30:
        if (Display.isDozeState(r1) == false) goto L32;
        r0.mDischargeScreenOnUnplugLevel = r8;
        r0.mDischargeScreenDozeUnplugLevel = r32;
        r0.mDischargeScreenOffUnplugLevel = r8;
        goto L33
    L32:
        r0.mDischargeScreenOnUnplugLevel = r8;
        r0.mDischargeScreenDozeUnplugLevel = r8;
        r0.mDischargeScreenOffUnplugLevel = r32;
        goto L33
    L22:
        r8 = 0;
        goto L23
    L15:
        r1 = r1;
        r6 = false;
        goto L17
    }

    private /* synthetic */ void lambda$setOnBatteryLocked$8(AlarmManager am) {
        am.cancel(this.mLongPlugInAlarmHandler);
    }

    private void scheduleSyncExternalStatsLocked(String reason, int updateFlags) {
        if (this.mExternalSync == null) goto L6;
        this.mExternalSync.scheduleSync(reason, updateFlags);
        return;
    }

    public void setBatteryStateLocked(int status, int health, int plugType, int level, int temp, int voltageMv, int chargeUah, int chargeFullUah, long chargeTimeToFullSeconds, long elapsedRealtimeMs, long uptimeMs, long currentTimeMs) {
        reportChangesToStatsLog(status, plugType, level);
        boolean onBattery = isOnBattery(plugType, status);
        if (this.mHaveBatteryLevel == true) goto L9;
        this.mHaveBatteryLevel = true;
        if (onBattery != this.mOnBattery) goto L7;
        this.mHistory.setPluggedInState(!onBattery);
    L7:
        this.mBatteryStatus = status;
        this.mBatteryLevel = level;
        this.mBatteryChargeUah = chargeUah;
        this.mHistory.setBatteryState(true, status, level, chargeUah);
        this.mLastDischargeStepLevel = level;
        this.mLastChargeStepLevel = level;
        this.mMinDischargeStepLevel = level;
        this.mMaxChargeStepLevel = level;
        boolean requestStepDetails = true;
    L21:
        int oldStatus = this.mBatteryStatus;
        if (onBattery == false) goto L27;
        this.mDischargeCurrentLevel = level;
        if (this.mHistory.isRecordingHistory() == true) goto L33;
        this.mHistory.startRecordingHistory(elapsedRealtimeMs, uptimeMs, true);
    L33:
        if (this.mDischargePlugLevel >= 0) goto L36;
        this.mDischargePlugLevel = level;
    L36:
        if (onBattery == this.mOnBattery) goto L49;
        this.mBatteryLevel = level;
        this.mBatteryStatus = status;
        this.mBatteryHealth = health;
        this.mBatteryPlugType = plugType;
        this.mBatteryTemperature = temp;
        this.mBatteryVoltageMv = voltageMv;
        this.mHistory.setBatteryState(status, level, health, plugType, temp, voltageMv, chargeUah);
        if (chargeUah >= this.mBatteryChargeUah) goto L48;
        long chargeDiff = ((long) this.mBatteryChargeUah) - ((long) chargeUah);
        this.mDischargeCounter.addCountLocked(chargeDiff);
        this.mDischargeScreenOffCounter.addCountLocked(chargeDiff);
        if (Display.isDozeState(this.mScreenState) == false) goto L43;
        this.mDischargeScreenDozeCounter.addCountLocked(chargeDiff);
    L43:
        if (this.mDeviceIdleMode != 1) goto L46;
        this.mDischargeLightDozeCounter.addCountLocked(chargeDiff);
        goto L48
    L46:
        if (this.mDeviceIdleMode != 2) goto L48;
        this.mDischargeDeepDozeCounter.addCountLocked(chargeDiff);
    L48:
        this.mBatteryChargeUah = chargeUah;
        setOnBatteryLocked(elapsedRealtimeMs, uptimeMs, onBattery, oldStatus, level, chargeUah);
        requestStepDetails = true;
    L123:
        this.mLastLearnedBatteryCapacityUah = chargeFullUah;
        if (this.mMinLearnedBatteryCapacityUah != (-1)) goto L126;
        this.mMinLearnedBatteryCapacityUah = chargeFullUah;
    L127:
        this.mMaxLearnedBatteryCapacityUah = Math.max(this.mMaxLearnedBatteryCapacityUah, chargeFullUah);
        this.mBatteryTimeToFullSeconds = chargeTimeToFullSeconds;
        if (this.mAccumulateBatteryUsageStats == false) goto L130;
        this.mBatteryUsageStatsProvider.accumulateBatteryUsageStatsAsync(this, this.mHandler);
    L130:
        if (requestStepDetails == false) goto L133;
        this.mStepDetailsProvider.requestUpdate();
        return;
    L133:
        return;
    L126:
        this.mMinLearnedBatteryCapacityUah = Math.min(this.mMinLearnedBatteryCapacityUah, chargeFullUah);
        goto L127
    L49:
        boolean changed = false;
        if (this.mBatteryLevel == level) goto L53;
        this.mBatteryLevel = level;
        changed = true;
        requestStepDetails = true;
    L53:
        if (this.mBatteryStatus == status) goto L56;
        this.mBatteryStatus = status;
        changed = true;
    L56:
        if (this.mBatteryHealth == health) goto L59;
        this.mBatteryHealth = health;
        changed = true;
    L59:
        if (this.mBatteryPlugType == plugType) goto L62;
        this.mBatteryPlugType = plugType;
        changed = true;
    L62:
        if (temp < (this.mBatteryTemperature + 10)) goto L64;
    L65:
        this.mBatteryTemperature = temp;
        changed = true;
    L67:
        if (voltageMv <= (this.mBatteryVoltageMv + 20)) goto L69;
    L70:
        this.mBatteryVoltageMv = voltageMv;
        changed = true;
    L72:
        if (chargeUah >= (this.mBatteryChargeUah + 10)) goto L76;
        if (chargeUah <= (this.mBatteryChargeUah - 10)) goto L76;
    L87:
        long modeBits = ((((long) this.mInitStepMode) << 48) | (((long) this.mModStepMode) << 56)) | (((long) (level & 255)) << 40);
        if (onBattery == false) goto L97;
        boolean changed2 = changed | setChargingLocked(false);
        if (this.mLastDischargeStepLevel != level) goto L92;
    L94:
        long modeBits2 = modeBits;
    L120:
        if (changed2 == false) goto L123;
        this.mHistory.setBatteryState(this.mBatteryStatus, this.mBatteryLevel, this.mBatteryHealth, this.mBatteryPlugType, this.mBatteryTemperature, this.mBatteryVoltageMv, this.mBatteryChargeUah);
        this.mHistory.writeHistoryItem(elapsedRealtimeMs, uptimeMs);
        goto L123
    L92:
        if (this.mMinDischargeStepLevel <= level) goto L94;
        this.mDischargeStepTracker.addLevelSteps(this.mLastDischargeStepLevel - level, modeBits, elapsedRealtimeMs);
        this.mDailyDischargeStepTracker.addLevelSteps(this.mLastDischargeStepLevel - level, modeBits, elapsedRealtimeMs);
        modeBits2 = modeBits;
        this.mLastDischargeStepLevel = level;
        this.mMinDischargeStepLevel = level;
        this.mInitStepMode = this.mCurStepMode;
        this.mModStepMode = 0;
        goto L120
    L97:
        if (level < this.mConstants.BATTERY_CHARGING_ENFORCE_LEVEL) goto L100;
        changed2 = changed | setChargingLocked(true);
    L114:
        if (this.mLastChargeStepLevel == level) goto L119;
        if (this.mMaxChargeStepLevel >= level) goto L119;
        this.mChargeStepTracker.addLevelSteps(level - this.mLastChargeStepLevel, modeBits, elapsedRealtimeMs);
        this.mDailyChargeStepTracker.addLevelSteps(level - this.mLastChargeStepLevel, modeBits, elapsedRealtimeMs);
        this.mMaxChargeStepLevel = level;
        this.mInitStepMode = this.mCurStepMode;
        this.mModStepMode = 0;
    L119:
        this.mLastChargeStepLevel = level;
        goto L120
    L100:
        if (this.mCharging == true) goto L110;
        if (this.mLastChargeStepLevel >= level) goto L107;
        if (this.mHandler.hasCallbacks(this.mDeferSetCharging) == true) goto L112;
        this.mHandler.postDelayed(this.mDeferSetCharging, this.mConstants.BATTERY_CHARGED_DELAY_MS);
    L112:
        changed2 = changed;
        goto L114
    L107:
        if (this.mLastChargeStepLevel <= level) goto L112;
        this.mHandler.removeCallbacks(this.mDeferSetCharging);
        goto L112
    L110:
        if (this.mLastChargeStepLevel <= level) goto L112;
        changed2 = changed | setChargingLocked(false);
    L76:
        if (chargeUah >= this.mBatteryChargeUah) goto L86;
        long chargeDiff2 = ((long) this.mBatteryChargeUah) - ((long) chargeUah);
        this.mDischargeCounter.addCountLocked(chargeDiff2);
        this.mDischargeScreenOffCounter.addCountLocked(chargeDiff2);
        if (Display.isDozeState(this.mScreenState) == false) goto L81;
        this.mDischargeScreenDozeCounter.addCountLocked(chargeDiff2);
    L81:
        if (this.mDeviceIdleMode != 1) goto L84;
        this.mDischargeLightDozeCounter.addCountLocked(chargeDiff2);
        goto L86
    L84:
        if (this.mDeviceIdleMode != 2) goto L86;
        this.mDischargeDeepDozeCounter.addCountLocked(chargeDiff2);
    L86:
        this.mBatteryChargeUah = chargeUah;
        changed = true;
        goto L87
    L69:
        if (voltageMv >= (this.mBatteryVoltageMv - 20)) goto L72;
    L64:
        if (temp > (this.mBatteryTemperature - 10)) goto L67;
    L27:
        if (level >= 96) goto L33;
        if (status == 1) goto L33;
        if (this.mHistory.isRecordingHistory() == true) goto L33;
        this.mHistory.startRecordingHistory(elapsedRealtimeMs, uptimeMs, true);
        goto L33
    L9:
        if (this.mBatteryLevel != level) goto L15;
        if (this.mOnBattery != onBattery) goto L15;
    L20:
        requestStepDetails = false;
    L15:
        if (level < 100) goto L18;
        if (onBattery == false) goto L18;
        boolean r11 = true;
    L19:
        recordDailyStatsIfNeededLocked(r11, currentTimeMs);
    L18:
        r11 = false;
        goto L19
    }

    public static boolean isOnBattery(int plugType, int status) {
        if (plugType == 0) goto L4;
    L6:
        return false;
    L4:
        if (status == 1) goto L6;
        return true;
    }

    private void reportChangesToStatsLog(int status, int plugType, int level) {
        if (this.mHaveBatteryLevel == true) goto L5;
    L6:
        this.mFrameworkStatsLogger.chargingStateChanged(status);
    L8:
        if (this.mHaveBatteryLevel == true) goto L10;
    L11:
        this.mFrameworkStatsLogger.pluggedStateChanged(plugType);
    L13:
        if (this.mHaveBatteryLevel == true) goto L15;
    L16:
        this.mFrameworkStatsLogger.batteryLevelChanged(level);
        return;
    L15:
        if (this.mBatteryLevel != level) goto L16;
        return;
    L10:
        if (this.mBatteryPlugType == plugType) goto L13;
    L5:
        if (this.mBatteryStatus == status) goto L8;
        goto L6
    }

    public long getAwakeTimeBattery() {
        return getBatteryUptimeLocked(this.mClock.uptimeMillis());
    }

    public long getAwakeTimePlugged() {
        return (this.mClock.uptimeMillis() * 1000) - getAwakeTimeBattery();
    }

    public long computeUptime(long curTimeUs, int which) {
        return this.mUptimeUs + (curTimeUs - this.mUptimeStartUs);
    }

    public long computeRealtime(long curTimeUs, int which) {
        return this.mRealtimeUs + (curTimeUs - this.mRealtimeStartUs);
    }

    public long computeBatteryUptime(long curTimeUs, int which) {
        return this.mOnBatteryTimeBase.computeUptime(curTimeUs, which);
    }

    public long computeBatteryRealtime(long curTimeUs, int which) {
        return this.mOnBatteryTimeBase.computeRealtime(curTimeUs, which);
    }

    public long computeBatteryScreenOffUptime(long curTimeUs, int which) {
        return this.mOnBatteryScreenOffTimeBase.computeUptime(curTimeUs, which);
    }

    public long computeBatteryScreenOffRealtime(long curTimeUs, int which) {
        return this.mOnBatteryScreenOffTimeBase.computeRealtime(curTimeUs, which);
    }

    public long computeBatteryTimeRemaining(long curTime) {
        if (this.mOnBattery == true) goto L6;
        return -1;
    L6:
        if (this.mDischargeStepTracker.mNumStepDurations >= 1) goto L8;
        return -1;
    L8:
        long msPerLevel = this.mDischargeStepTracker.computeTimePerLevel();
        if (msPerLevel > 0) goto L12;
        return -1;
    L12:
        return (((long) this.mBatteryLevel) * msPerLevel) * 1000;
    }

    public BatteryStats.LevelStepTracker getDischargeLevelStepTracker() {
        return this.mDischargeStepTracker;
    }

    public BatteryStats.LevelStepTracker getDailyDischargeLevelStepTracker() {
        return this.mDailyDischargeStepTracker;
    }

    public long computeChargeTimeRemaining(long curTime) {
        if (this.mOnBattery == false) goto L6;
        return -1;
    L6:
        if (this.mBatteryTimeToFullSeconds < 0) goto L10;
        return this.mBatteryTimeToFullSeconds * 1000000;
    L10:
        if (this.mChargeStepTracker.mNumStepDurations >= 1) goto L12;
        return -1;
    L12:
        long msPerLevel = this.mChargeStepTracker.computeTimePerLevel();
        if (msPerLevel > 0) goto L16;
        return -1;
    L16:
        return (((long) (100 - this.mBatteryLevel)) * msPerLevel) * 1000;
    }

    public CellularBatteryStats getCellularBatteryStats() {
        long rawRealTimeUs = SystemClock.elapsedRealtime() * 1000;
        BatteryStats.ControllerActivityCounter counter = getModemControllerActivity();
        long sleepTimeMs = counter.getSleepTimeCounter().getCountLocked(0);
        long idleTimeMs = counter.getIdleTimeCounter().getCountLocked(0);
        long rxTimeMs = counter.getRxTimeCounter().getCountLocked(0);
        long energyConsumedMaMs = counter.getPowerCounter().getCountLocked(0);
        long monitoredRailChargeConsumedMaMs = counter.getMonitoredRailChargeConsumedMaMs().getCountLocked(0);
        long[] timeInRatMs = new long[BatteryStats.NUM_DATA_CONNECTION_TYPES];
        int i = 0;
    L4:
        if (i >= timeInRatMs.length) goto L6;
        timeInRatMs[i] = getPhoneDataConnectionTime(i, rawRealTimeUs, 0) / 1000;
        i = i + 1;
        goto L4
    L6:
        int i2 = CELL_SIGNAL_STRENGTH_LEVEL_COUNT;
        long[] timeInRxSignalStrengthLevelMs = new long[i2];
        int i3 = 0;
    L8:
        if (i3 >= timeInRxSignalStrengthLevelMs.length) goto L10;
        timeInRxSignalStrengthLevelMs[i3] = getPhoneSignalStrengthTime(i3, rawRealTimeUs, 0) / 1000;
        i3 = i3 + 1;
        goto L8
    L10:
        int i4 = MODEM_TX_POWER_LEVEL_COUNT;
        long[] txTimeMs = new long[Math.min(i4, counter.getTxTimeCounters().length)];
        int i5 = 0;
        long totalTxTimeMs = 0;
    L12:
        if (i5 >= txTimeMs.length) goto L15;
        txTimeMs[i5] = counter.getTxTimeCounters()[i5].getCountLocked(0);
        totalTxTimeMs = totalTxTimeMs + txTimeMs[i5];
        i5 = i5 + 1;
        goto L12
    L15:
        return new CellularBatteryStats(computeBatteryRealtime(rawRealTimeUs, 0) / 1000, getMobileRadioActiveTime(rawRealTimeUs, 0) / 1000, getNetworkActivityPackets(1, 0), getNetworkActivityBytes(1, 0), getNetworkActivityPackets(0, 0), getNetworkActivityBytes(0, 0), sleepTimeMs, idleTimeMs, rxTimeMs, energyConsumedMaMs, timeInRatMs, timeInRxSignalStrengthLevelMs, txTimeMs, monitoredRailChargeConsumedMaMs);
    }

    public WifiBatteryStats getWifiBatteryStats() {
        long rawRealTimeUs = this.mClock.elapsedRealtime() * 1000;
        BatteryStats.ControllerActivityCounter counter = getWifiControllerActivity();
        long idleTimeMs = counter.getIdleTimeCounter().getCountLocked(0);
        long scanTimeMs = counter.getScanTimeCounter().getCountLocked(0);
        long rxTimeMs = counter.getRxTimeCounter().getCountLocked(0);
        long txTimeMs = counter.getTxTimeCounters()[0].getCountLocked(0);
        long totalControllerActivityTimeMs = computeBatteryRealtime(this.mClock.elapsedRealtime() * 1000, 0) / 1000;
        long sleepTimeMs = Math.max(0, totalControllerActivityTimeMs - ((idleTimeMs + rxTimeMs) + txTimeMs));
        long energyConsumedMaMs = counter.getPowerCounter().getCountLocked(0);
        long monitoredRailChargeConsumedMaMs = counter.getMonitoredRailChargeConsumedMaMs().getCountLocked(0);
        int i = 0;
        long numAppScanRequest = 0;
    L4:
        if (i >= this.mUidStats.size()) goto L6;
        numAppScanRequest = numAppScanRequest + ((long) this.mUidStats.valueAt(i).mWifiScanTimer.getCountLocked(0));
        i = i + 1;
        goto L4
    L6:
        long[] timeInStateMs = new long[8];
        int i2 = 0;
    L7:
        if (i2 >= 8) goto L9;
        timeInStateMs[i2] = getWifiStateTime(i2, rawRealTimeUs, 0) / 1000;
        i2 = i2 + 1;
        goto L7
    L9:
        long[] timeInSupplStateMs = new long[13];
        int i3 = 0;
    L10:
        if (i3 >= 13) goto L12;
        timeInSupplStateMs[i3] = getWifiSupplStateTime(i3, rawRealTimeUs, 0) / 1000;
        i3 = i3 + 1;
        goto L10
    L12:
        long[] timeSignalStrengthTimeMs = new long[5];
        int i4 = 0;
    L13:
        if (i4 >= 5) goto L16;
        timeSignalStrengthTimeMs[i4] = getWifiSignalStrengthTime(i4, rawRealTimeUs, 0) / 1000;
        i4 = i4 + 1;
        goto L13
    L16:
        return new WifiBatteryStats(computeBatteryRealtime(rawRealTimeUs, 0) / 1000, getWifiActiveTime(rawRealTimeUs, 0) / 1000, getNetworkActivityPackets(3, 0), getNetworkActivityBytes(3, 0), getNetworkActivityPackets(2, 0), getNetworkActivityBytes(2, 0), sleepTimeMs, scanTimeMs, idleTimeMs, rxTimeMs, txTimeMs, energyConsumedMaMs, numAppScanRequest, timeInStateMs, timeSignalStrengthTimeMs, timeInSupplStateMs, monitoredRailChargeConsumedMaMs);
    }

    public GpsBatteryStats getGpsBatteryStats() {
        GpsBatteryStats s = new GpsBatteryStats();
        long rawRealTimeUs = SystemClock.elapsedRealtime() * 1000;
        s.setLoggingDurationMs(computeBatteryRealtime(rawRealTimeUs, 0) / 1000);
        s.setEnergyConsumedMaMs(getGpsBatteryDrainMaMs());
        long[] time = new long[this.mGpsSignalQualityTimer.length];
        int i = 0;
    L4:
        if (i >= time.length) goto L6;
        time[i] = getGpsSignalQualityTime(i, rawRealTimeUs, 0) / 1000;
        i = i + 1;
        goto L4
    L6:
        s.setTimeInGpsSignalQualityLevel(time);
        return s;
    }

    public BatteryStats.LevelStepTracker getChargeLevelStepTracker() {
        return this.mChargeStepTracker;
    }

    public BatteryStats.LevelStepTracker getDailyChargeLevelStepTracker() {
        return this.mDailyChargeStepTracker;
    }

    public ArrayList<BatteryStats.PackageChange> getDailyPackageChanges() {
        return this.mDailyPackageChanges;
    }

    protected long getBatteryUptimeLocked(long uptimeMs) {
        return this.mOnBatteryTimeBase.getUptime(1000 * uptimeMs);
    }

    public long getBatteryUptime(long curTimeUs) {
        return this.mOnBatteryTimeBase.getUptime(curTimeUs);
    }

    public long getBatteryRealtime(long curTimeUs) {
        return this.mOnBatteryTimeBase.getRealtime(curTimeUs);
    }

    public int getDischargeStartLevel() {
        monitor-enter(this);
        int r0 = getDischargeStartLevelLocked();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int getDischargeStartLevelLocked() {
        return this.mDischargeUnplugLevel;
    }

    public int getDischargeCurrentLevel() {
        monitor-enter(this);
        int r0 = getDischargeCurrentLevelLocked();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int getDischargeCurrentLevelLocked() {
        return this.mDischargeCurrentLevel;
    }

    public int getLowDischargeAmountSinceCharge() {
        monitor-enter(this);
        int val = this.mLowDischargeAmountSinceCharge;     // Catch: Throwable -> L8
        if (this.mOnBattery == true) goto L6;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        return val;
    L6:
        if (this.mDischargeCurrentLevel >= this.mDischargeUnplugLevel) goto L10;
        val = val + ((this.mDischargeUnplugLevel - this.mDischargeCurrentLevel) - 1);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public int getHighDischargeAmountSinceCharge() {
        monitor-enter(this);
        int val = this.mHighDischargeAmountSinceCharge;     // Catch: Throwable -> L8
        if (this.mOnBattery == true) goto L6;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        return val;
    L6:
        if (this.mDischargeCurrentLevel >= this.mDischargeUnplugLevel) goto L10;
        val = val + (this.mDischargeUnplugLevel - this.mDischargeCurrentLevel);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public int getDischargeAmount(int which) {
        if (which != 0) goto L4;
        int dischargeAmount = getHighDischargeAmountSinceCharge();
    L6:
        if (dischargeAmount >= 0) goto L9;
        return 0;
    L9:
        return dischargeAmount;
    L4:
        dischargeAmount = getDischargeStartLevel() - getDischargeCurrentLevel();
        goto L6
    }

    public int getDischargeAmountScreenOn() {
        monitor-enter(this);
        int val = this.mDischargeAmountScreenOn;     // Catch: Throwable -> L10
        if (this.mOnBattery == true) goto L6;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L10
        return val;
    L6:
        if (Display.isOnState(this.mScreenState) == false) goto L12;
        if (this.mDischargeCurrentLevel >= this.mDischargeScreenOnUnplugLevel) goto L12;
        val = val + (this.mDischargeScreenOnUnplugLevel - this.mDischargeCurrentLevel);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public int getDischargeAmountScreenOnSinceCharge() {
        monitor-enter(this);
        int val = this.mDischargeAmountScreenOnSinceCharge;     // Catch: Throwable -> L10
        if (this.mOnBattery == true) goto L6;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L10
        return val;
    L6:
        if (Display.isOnState(this.mScreenState) == false) goto L12;
        if (this.mDischargeCurrentLevel >= this.mDischargeScreenOnUnplugLevel) goto L12;
        val = val + (this.mDischargeScreenOnUnplugLevel - this.mDischargeCurrentLevel);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public int getDischargeAmountScreenOff() {
        monitor-enter(this);
        int val = this.mDischargeAmountScreenOff;     // Catch: Throwable -> L10
        if (this.mOnBattery == true) goto L6;
    L12:
        int r1 = getDischargeAmountScreenDoze() + val;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r1;
    L6:
        if (Display.isOffState(this.mScreenState) == false) goto L12;
        if (this.mDischargeCurrentLevel >= this.mDischargeScreenOffUnplugLevel) goto L12;
        val = val + (this.mDischargeScreenOffUnplugLevel - this.mDischargeCurrentLevel);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public int getDischargeAmountScreenOffSinceCharge() {
        monitor-enter(this);
        int val = this.mDischargeAmountScreenOffSinceCharge;     // Catch: Throwable -> L10
        if (this.mOnBattery == true) goto L6;
    L12:
        int r1 = getDischargeAmountScreenDozeSinceCharge() + val;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r1;
    L6:
        if (Display.isOffState(this.mScreenState) == false) goto L12;
        if (this.mDischargeCurrentLevel >= this.mDischargeScreenOffUnplugLevel) goto L12;
        val = val + (this.mDischargeScreenOffUnplugLevel - this.mDischargeCurrentLevel);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public int getDischargeAmountScreenDoze() {
        monitor-enter(this);
        int val = this.mDischargeAmountScreenDoze;     // Catch: Throwable -> L10
        if (this.mOnBattery == true) goto L6;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L10
        return val;
    L6:
        if (Display.isDozeState(this.mScreenState) == false) goto L12;
        if (this.mDischargeCurrentLevel >= this.mDischargeScreenDozeUnplugLevel) goto L12;
        val = val + (this.mDischargeScreenDozeUnplugLevel - this.mDischargeCurrentLevel);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public int getDischargeAmountScreenDozeSinceCharge() {
        monitor-enter(this);
        int val = this.mDischargeAmountScreenDozeSinceCharge;     // Catch: Throwable -> L10
        if (this.mOnBattery == true) goto L6;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L10
        return val;
    L6:
        if (Display.isDozeState(this.mScreenState) == false) goto L12;
        if (this.mDischargeCurrentLevel >= this.mDischargeScreenDozeUnplugLevel) goto L12;
        val = val + (this.mDischargeScreenDozeUnplugLevel - this.mDischargeCurrentLevel);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public long[] getSystemServiceTimeAtCpuSpeeds() {
        if (this.mBinderThreadCpuTimesUs != null) goto L7;
        return null;
    L7:
        return this.mBinderThreadCpuTimesUs.getCountsLocked(0);
    }

    public Uid getUidStatsLocked(int uid) {
        return getUidStatsLocked(uid, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public Uid getUidStatsLocked(int uid, long elapsedRealtimeMs, long uptimeMs) {
        Uid u = this.mUidStats.get(uid);
        if (u != null) goto L9;
        if (Process.isSdkSandboxUid(uid) == false) goto L7;
        Log.wtf(TAG, "Tracking an SDK Sandbox UID");
    L7:
        Uid u2 = new Uid(this, uid, elapsedRealtimeMs, uptimeMs);
        this.mUidStats.put(uid, u2);
        return u2;
    L9:
        return u;
    }

    public Uid getAvailableUidStatsLocked(int uid) {
        Uid u = this.mUidStats.get(uid);
        return u;
    }

    public void onCleanupUserLocked(int userId, long elapsedRealtimeMs) {
        int firstUidForUser = UserHandle.getUid(userId, 0);
        int lastUidForUser = UserHandle.getUid(userId, 99999);
        this.mPendingRemovedUids.add(new UidToRemove(this, firstUidForUser, lastUidForUser, elapsedRealtimeMs));
    }

    public void onUserRemovedLocked(int userId) {
        if (this.mExternalSync == null) goto L6;
        this.mExternalSync.scheduleCleanupDueToRemovedUser(userId);
        return;
    }

    public void clearRemovedUserUidsLocked(int userId) {
        int firstUidForUser = UserHandle.getUid(userId, 0);
        int lastUidForUser = UserHandle.getUid(userId, 99999);
        this.mUidStats.put(firstUidForUser, null);
        this.mUidStats.put(lastUidForUser, null);
        int firstIndex = this.mUidStats.indexOfKey(firstUidForUser);
        int lastIndex = this.mUidStats.indexOfKey(lastUidForUser);
        int i = firstIndex;
    L3:
        if (i > lastIndex) goto L8;
        Uid uid = this.mUidStats.valueAt(i);
        if (uid == null) goto L7;
        uid.detachFromTimeBase();
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mUidStats.removeAtRange(firstIndex, (lastIndex - firstIndex) + 1);
        removeCpuStatsForUidRangeLocked(firstUidForUser, lastUidForUser);
    }

    public void removeUidStatsLocked(int uid, long elapsedRealtimeMs) {
        Uid u = this.mUidStats.get(uid);
        if (u == null) goto L5;
        u.detachFromTimeBase();
    L5:
        this.mUidStats.remove(uid);
        this.mPendingRemovedUids.add(new UidToRemove(this, uid, elapsedRealtimeMs));
    }

    private void removeCpuStatsForUidRangeLocked(int startUid, int endUid) {
        if (startUid != endUid) goto L10;
        this.mCpuUidUserSysTimeReader.removeUid(startUid);
        this.mCpuUidFreqTimeReader.removeUid(startUid);
        if (this.mConstants.TRACK_CPU_ACTIVE_CLUSTER_TIME == false) goto L7;
        this.mCpuUidActiveTimeReader.removeUid(startUid);
        this.mCpuUidClusterTimeReader.removeUid(startUid);
    L7:
        if (this.mKernelSingleUidTimeReader == null) goto L9;
        this.mKernelSingleUidTimeReader.removeUid(startUid);
    L9:
        this.mNumUidsRemoved++;
        return;
    L10:
        if (startUid >= endUid) goto L18;
        this.mCpuUidFreqTimeReader.removeUidsInRange(startUid, endUid);
        this.mCpuUidUserSysTimeReader.removeUidsInRange(startUid, endUid);
        if (this.mConstants.TRACK_CPU_ACTIVE_CLUSTER_TIME == false) goto L15;
        this.mCpuUidActiveTimeReader.removeUidsInRange(startUid, endUid);
        this.mCpuUidClusterTimeReader.removeUidsInRange(startUid, endUid);
    L15:
        if (this.mKernelSingleUidTimeReader == null) goto L17;
        this.mKernelSingleUidTimeReader.removeUidsInRange(startUid, endUid);
    L17:
        this.mPowerStatsUidResolver.releaseUidsInRange(startUid, endUid);
        this.mNumUidsRemoved++;
        return;
    L18:
        Slog.w(TAG, "End UID " + endUid + " is smaller than start UID " + startUid);
    }

    public Uid.Proc getProcessStatsLocked(int uid, String name, long elapsedRealtimeMs, long uptimeMs) {
        Uid u = getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs);
        return u.getProcessStatsLocked(name);
    }

    public Uid.Pkg getPackageStatsLocked(int uid, String pkg) {
        return getPackageStatsLocked(uid, pkg, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    }

    public Uid.Pkg getPackageStatsLocked(int uid, String pkg, long elapsedRealtimeMs, long uptimeMs) {
        Uid u = getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs);
        return u.getPackageStatsLocked(pkg);
    }

    public Uid.Pkg.Serv getServiceStatsLocked(int uid, String pkg, String name, long elapsedRealtimeMs, long uptimeMs) {
        Uid u = getUidStatsLocked(mapUid(uid), elapsedRealtimeMs, uptimeMs);
        return u.getServiceStatsLocked(pkg, name);
    }

    public void shutdownLocked() {
        this.mHistory.recordShutdownEvent(this.mClock.elapsedRealtime(), this.mClock.uptimeMillis(), this.mClock.currentTimeMillis());
        writeSyncLocked();
        this.mShuttingDown = true;
    }

    public boolean isProcessStateDataAvailable() {
        monitor-enter(this);
        boolean r0 = trackPerProcStateCpuTimes();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean trackPerProcStateCpuTimes() {
        return this.mCpuUidFreqTimeReader.isFastCpuTimesReader();
    }

    public void setPowerStatsCollectorEnabled(int powerComponent, boolean enabled) {
        monitor-enter(this);
        this.mPowerStatsCollectorEnabled.put(powerComponent, enabled);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setMoveWscLoggingToNotifierEnabled(boolean enabled) {
        monitor-enter(this);
        this.mMoveWscLoggingToNotifierEnabled = enabled;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void systemServicesReady(Context context) {
        this.mConstants.startObserving(context.getContentResolver());
        registerUsbStateReceiver(context);
        monitor-enter(this);
        this.mAlarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);     // Catch: Throwable -> L7
        if (this.mBatteryPluggedIn == false) goto L10;
        scheduleNextResetWhilePluggedInCheck();     // Catch: Throwable -> L7
    L10:
        if (this.mPowerManagerFlags.isFrameworkWakelockInfoEnabled() == false) goto L12;
        this.mFrameworkEvents.initialize(context);     // Catch: Throwable -> L7
    L12:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void initEnergyConsumerStatsLocked(boolean[] supportedStandardBuckets, String[] customBucketNames) {
        int numDisplays = this.mPerDisplayBatteryStats.length;
        int i = 0;
    L3:
        if (i >= numDisplays) goto L6;
        int screenState = this.mPerDisplayBatteryStats[i].screenState;
        this.mPerDisplayBatteryStats[i].screenStateAtLastEnergyMeasurement = screenState;
        i = i + 1;
        goto L3
    L6:
        if (supportedStandardBuckets == null) goto L23;
        EnergyConsumerStats.Config config = new EnergyConsumerStats.Config(supportedStandardBuckets, customBucketNames, SUPPORTED_PER_PROCESS_STATE_STANDARD_ENERGY_BUCKETS, getBatteryConsumerProcessStateNames());
        if (this.mEnergyConsumerStatsConfig != null) goto L10;
    L12:
        this.mEnergyConsumerStatsConfig = config;
        this.mGlobalEnergyConsumerStats = new EnergyConsumerStats(config);
        if (supportedStandardBuckets[5] == false) goto L16;
        this.mBluetoothPowerCalculator = new BluetoothPowerCalculator(this.mPowerProfile);
    L16:
        if (supportedStandardBuckets[7] == false) goto L19;
        this.mMobileRadioPowerCalculator = new MobileRadioPowerCalculator(this.mPowerProfile);
    L19:
        if (supportedStandardBuckets[4] == false) goto L29;
        this.mWifiPowerCalculator = new WifiPowerCalculator(this.mPowerProfile);
        return;
    L29:
        return;
    L10:
        if (this.mEnergyConsumerStatsConfig.isCompatible(config) == true) goto L12;
        saveBatteryUsageStatsOnReset();
        resetAllStatsLocked(SystemClock.uptimeMillis(), SystemClock.elapsedRealtime(), 4);
        goto L12
    L23:
        if (this.mEnergyConsumerStatsConfig == null) goto L25;
        saveBatteryUsageStatsOnReset();
        resetAllStatsLocked(SystemClock.uptimeMillis(), SystemClock.elapsedRealtime(), 4);
    L25:
        this.mEnergyConsumerStatsConfig = null;
        this.mGlobalEnergyConsumerStats = null;
    }

    private boolean isMobileRadioEnergyConsumerSupportedLocked() {
        if (this.mGlobalEnergyConsumerStats != null) goto L7;
        return false;
    L7:
        return this.mGlobalEnergyConsumerStats.isStandardBucketSupported(7);
    }

    private static String[] getBatteryConsumerProcessStateNames() {
        String[] procStateNames = new String[5];
        int procState = 0;
    L3:
        if (procState >= 5) goto L6;
        procStateNames[procState] = BatteryConsumer.processStateToString(procState);
        procState = procState + 1;
        goto L3
    L6:
        return procStateNames;
    }

    public int getBatteryVoltageMvLocked() {
        return this.mBatteryVoltageMv;
    }

    public long getExternalStatsCollectionRateLimitMs() {
        monitor-enter(this);
        long r0 = this.mConstants.EXTERNAL_STATS_COLLECTION_RATE_LIMIT_MS;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void dumpConstantsLocked(PrintWriter pw) {
        PrintWriter r0 = new IndentingPrintWriter(pw, "    ");
        r0.println("BatteryStats constants:");
        r0.increaseIndent();
        this.mConstants.dumpLocked(r0);
        r0.decreaseIndent();
    }

    public void dumpCpuStatsLocked(PrintWriter pw) {
        int size = this.mUidStats.size();
        pw.println("Per UID CPU user & system time in ms:");
        int i = 0;
    L4:
        if (i >= size) goto L6;
        int u = this.mUidStats.keyAt(i);
        Uid uid = this.mUidStats.get(u);
        pw.print("  ");
        pw.print(u);
        pw.print(": ");
        pw.print(uid.getUserCpuTimeUs(0) / 1000);
        pw.print(" ");
        pw.println(uid.getSystemCpuTimeUs(0) / 1000);
        i = i + 1;
        goto L4
    L6:
        pw.println("Per UID CPU active time in ms:");
        int i2 = 0;
    L7:
        if (i2 >= size) goto L12;
        int u2 = this.mUidStats.keyAt(i2);
        Uid uid2 = this.mUidStats.get(u2);
        if (uid2.getCpuActiveTime() <= 0) goto L11;
        pw.print("  ");
        pw.print(u2);
        pw.print(": ");
        pw.println(uid2.getCpuActiveTime());
    L11:
        i2 = i2 + 1;
        goto L7
    L12:
        pw.println("Per UID CPU cluster time in ms:");
        int i3 = 0;
    L13:
        if (i3 >= size) goto L18;
        int u3 = this.mUidStats.keyAt(i3);
        long[] times = this.mUidStats.get(u3).getCpuClusterTimes();
        if (times == null) goto L17;
        pw.print("  ");
        pw.print(u3);
        pw.print(": ");
        pw.println(Arrays.toString(times));
    L17:
        i3 = i3 + 1;
        goto L13
    L18:
        pw.println("Per UID CPU frequency time in ms:");
        int i4 = 0;
    L19:
        if (i4 >= size) goto L25;
        int u4 = this.mUidStats.keyAt(i4);
        long[] times2 = this.mUidStats.get(u4).getCpuFreqTimes(0);
        if (times2 == null) goto L23;
        pw.print("  ");
        pw.print(u4);
        pw.print(": ");
        pw.println(Arrays.toString(times2));
    L23:
        i4 = i4 + 1;
        goto L19
    }

    public void dumpEnergyConsumerStatsLocked(PrintWriter pw) {
        pw.printf("On-battery energy consumer stats (microcoulombs) \n", new Object[0]);
        if (this.mGlobalEnergyConsumerStats != null) goto L6;
        pw.printf("    Not supported on this device.\n", new Object[0]);
        return;
    L6:
        dumpEnergyConsumerStatsLocked(pw, "global usage", this.mGlobalEnergyConsumerStats);
        int size = this.mUidStats.size();
        int i = 0;
    L7:
        if (i >= size) goto L10;
        int u = this.mUidStats.keyAt(i);
        Uid uid = this.mUidStats.get(u);
        String name = "uid " + uid.mUid;
        dumpEnergyConsumerStatsLocked(pw, name, Uid.m7800$$Nest$fgetmUidEnergyConsumerStats(uid));
        i = i + 1;
        goto L7
    }

    private void dumpEnergyConsumerStatsLocked(PrintWriter pw, String name, EnergyConsumerStats stats) {
        if (stats != null) goto L4;
        return;
    L4:
        IndentingPrintWriter iPw = new IndentingPrintWriter(pw, "    ");
        iPw.increaseIndent();
        iPw.printf("%s:\n", new Object[]{name});
        iPw.increaseIndent();
        stats.dump(iPw);
        iPw.decreaseIndent();
    }

    public void dumpPowerProfileLocked(PrintWriter pw) {
        IndentingPrintWriter iPw = new IndentingPrintWriter(pw, "    ");
        iPw.printf("Power Profile: \n", new Object[0]);
        iPw.increaseIndent();
        this.mPowerProfile.dump(iPw);
        iPw.decreaseIndent();
    }

    public void schedulePowerStatsSampleCollection() {
        if (this.mSystemReady == true) goto L5;
        return;
    L5:
        this.mCpuPowerStatsCollector.forceSchedule();
        this.mWakelockPowerStatsCollector.forceSchedule();
        this.mScreenPowerStatsCollector.forceSchedule();
        this.mMobileRadioPowerStatsCollector.forceSchedule();
        this.mWifiPowerStatsCollector.forceSchedule();
        this.mBluetoothPowerStatsCollector.forceSchedule();
        this.mCameraPowerStatsCollector.forceSchedule();
        this.mGnssPowerStatsCollector.forceSchedule();
        this.mCustomEnergyConsumerPowerStatsCollector.forceSchedule();
    }

    public void collectPowerStatsSamples() {
        schedulePowerStatsSampleCollection();
        ConditionVariable done = new ConditionVariable();
        this.mHandler.post(new BatteryStatsImpl$$ExternalSyntheticLambda8(done));
        done.block();
    }

    public void dumpStatsSample(PrintWriter pw) {
        this.mCpuPowerStatsCollector.collectAndDump(pw);
        this.mWakelockPowerStatsCollector.collectAndDump(pw);
        this.mScreenPowerStatsCollector.collectAndDump(pw);
        this.mMobileRadioPowerStatsCollector.collectAndDump(pw);
        this.mWifiPowerStatsCollector.collectAndDump(pw);
        this.mBluetoothPowerStatsCollector.collectAndDump(pw);
        this.mCameraPowerStatsCollector.collectAndDump(pw);
        this.mGnssPowerStatsCollector.collectAndDump(pw);
        this.mCustomEnergyConsumerPowerStatsCollector.collectAndDump(pw);
    }

    private /* synthetic */ void lambda$new$9() {
        monitor-enter(this);
        writeSyncLocked();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void writeAsyncLocked() {
        BackgroundThread.getHandler().removeCallbacks(this.mWriteAsyncRunnable);
        BackgroundThread.getHandler().post(this.mWriteAsyncRunnable);
    }

    public void writeSyncLocked() {
        BackgroundThread.getHandler().removeCallbacks(this.mWriteAsyncRunnable);
        writeStatsLocked();
        writeHistoryLocked();
    }

    private void writeStatsLocked() {
        if (this.mStatsFile != null) goto L7;
        Slog.w(TAG, "writeStatsLocked: no file associated with this instance");
        return;
    L7:
        if (this.mShuttingDown == false) goto L9;
        return;
    L9:
        Parcel p = Parcel.obtain();
        SystemClock.uptimeMillis();     // Catch: Throwable -> L13
        writeSummaryToParcel(p, false);     // Catch: Throwable -> L13
        this.mLastWriteTimeMs = this.mClock.elapsedRealtime();     // Catch: Throwable -> L13
        writeParcelToFileLocked(p, this.mStatsFile);     // Catch: Throwable -> L13
        p.recycle();
        return;
    L13:
        th = move-exception;
        p.recycle();
        throw th;
    }

    private void writeHistoryLocked() {
        if (this.mShuttingDown == false) goto L5;
        return;
    L5:
        this.mHistory.writeHistory();
    }

    private void writeParcelToFileLocked(Parcel p, AtomicFile file) {
        this.mWriteLock.lock();
        FileOutputStream fos = null;
        long startTimeMs = SystemClock.uptimeMillis();     // Catch: Throwable -> L5 IOException -> L7
        fos = file.startWrite();     // Catch: Throwable -> L5 IOException -> L7
        fos.write(p.marshall());     // Catch: Throwable -> L5 IOException -> L7
        fos.flush();     // Catch: Throwable -> L5 IOException -> L7
        file.finishWrite(fos);     // Catch: Throwable -> L5 IOException -> L7
        this.mFrameworkStatsLogger.writeCommitSysConfigFile("batterystats", SystemClock.uptimeMillis() - startTimeMs);     // Catch: Throwable -> L5 IOException -> L7
    L4:
        this.mWriteLock.unlock();
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Error writing battery statistics", e);     // Catch: Throwable -> L5
        file.failWrite(fos);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void readLocked() {
        if (this.mDailyFile == null) goto L6;
        readDailyStatsLocked();
    L6:
        if (this.mStatsFile != null) goto L9;
        Slog.w(TAG, "readLocked: no file associated with this instance");
        return;
    L9:
        this.mUidStats.clear();
        Parcel stats = Parcel.obtain();
        SystemClock.uptimeMillis();     // Catch: Throwable -> L14 Exception -> L16
        if (this.mStatsFile.exists() == false) goto L18;
        byte[] raw = this.mStatsFile.readFully();     // Catch: Throwable -> L14 Exception -> L16
        stats.unmarshall(raw, 0, raw.length);     // Catch: Throwable -> L14 Exception -> L16
        stats.setDataPosition(0);     // Catch: Throwable -> L14 Exception -> L16
        readSummaryFromParcel(stats);     // Catch: Throwable -> L14 Exception -> L16
    L18:
        stats.recycle();
        if (this.mHistory.readSummary() == true) goto L25;
        resetAllStatsLocked(SystemClock.uptimeMillis(), SystemClock.elapsedRealtime(), 1);
    L25:
        this.mEndPlatformVersion = Build.ID;
        this.mMonotonicEndTime = -1;
        this.mHistory.continueRecordingHistory();
        recordDailyStatsIfNeededLocked(false, this.mClock.currentTimeMillis());
        return;
    L16:
        e = move-exception;
        Slog.e(TAG, "Error reading battery statistics", e);     // Catch: Throwable -> L14
        resetAllStatsLocked(SystemClock.uptimeMillis(), SystemClock.elapsedRealtime(), 1);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        stats.recycle();
        throw th;
    }

    public void readSummaryFromParcel(Parcel in) throws ParcelFormatException {
        BatteryStatsImpl r1 = this;
        Parcel r7 = in;
        int version = r7.readInt();
        if (version == VERSION) goto L6;
        Slog.w("BatteryStats", "readFromParcel: version got " + version + ", expected " + VERSION + "; erasing old stats");
        return;
    L6:
        r1.mHistory.readSummaryFromParcel(r7);
        r1.mStartCount = r7.readInt();
        r1.mUptimeUs = r7.readLong();
        r1.mRealtimeUs = r7.readLong();
        r1.mStartClockTimeMs = r7.readLong();
        r1.mMonotonicStartTime = r7.readLong();
        r1.mMonotonicEndTime = r7.readLong();
        r1.mStartPlatformVersion = r7.readString();
        r1.mEndPlatformVersion = r7.readString();
        r1.mOnBatteryTimeBase.readSummaryFromParcel(r7);
        r1.mOnBatteryScreenOffTimeBase.readSummaryFromParcel(r7);
        r1.mDischargeUnplugLevel = r7.readInt();
        r1.mDischargePlugLevel = r7.readInt();
        r1.mDischargeCurrentLevel = r7.readInt();
        r1.mBatteryLevel = r7.readInt();
        r1.mEstimatedBatteryCapacityMah = r7.readInt();
        r1.mLastLearnedBatteryCapacityUah = r7.readInt();
        r1.mMinLearnedBatteryCapacityUah = r7.readInt();
        r1.mMaxLearnedBatteryCapacityUah = r7.readInt();
        r1.mLowDischargeAmountSinceCharge = r7.readInt();
        r1.mHighDischargeAmountSinceCharge = r7.readInt();
        r1.mDischargeAmountScreenOnSinceCharge = r7.readInt();
        r1.mDischargeAmountScreenOffSinceCharge = r7.readInt();
        r1.mDischargeAmountScreenDozeSinceCharge = r7.readInt();
        r1.mDischargeStepTracker.readFromParcel(r7);
        r1.mChargeStepTracker.readFromParcel(r7);
        r1.mDailyDischargeStepTracker.readFromParcel(r7);
        r1.mDailyChargeStepTracker.readFromParcel(r7);
        r1.mDischargeCounter.readSummaryFromParcelLocked(r7);
        r1.mDischargeScreenOffCounter.readSummaryFromParcelLocked(r7);
        r1.mDischargeScreenDozeCounter.readSummaryFromParcelLocked(r7);
        r1.mDischargeLightDozeCounter.readSummaryFromParcelLocked(r7);
        r1.mDischargeDeepDozeCounter.readSummaryFromParcelLocked(r7);
        int NPKG = r7.readInt();
        boolean r11 = true;
        if (NPKG <= 0) goto L16;
        r1.mDailyPackageChanges = new ArrayList(NPKG);
    L9:
        if (NPKG <= 0) goto L15;
        NPKG = NPKG - 1;
        BatteryStats.PackageChange pc = new BatteryStats.PackageChange();
        pc.mPackageName = r7.readString();
        if (r7.readInt() == 0) goto L13;
        boolean r3 = true;
    L14:
        pc.mUpdate = r3;
        pc.mVersionCode = r7.readLong();
        r1.mDailyPackageChanges.add(pc);
        goto L9
    L13:
        r3 = false;
        goto L14
    L15:
        int NPKG2 = NPKG;
    L17:
        r1.mDailyStartTimeMs = r7.readLong();
        r1.mNextMinDailyDeadlineMs = r7.readLong();
        r1.mNextMaxDailyDeadlineMs = r7.readLong();
        r1.mBatteryTimeToFullSeconds = r7.readLong();
        EnergyConsumerStats.Config config = EnergyConsumerStats.Config.createFromParcel(r7);
        EnergyConsumerStats energyConsumerStats = EnergyConsumerStats.createAndReadSummaryFromParcel(r1.mEnergyConsumerStatsConfig, r7);
        if (config != null) goto L20;
    L22:
        r1.mStartCount++;
        r1.mScreenState = 0;
        r1.mScreenOnTimer.readSummaryFromParcelLocked(r7);
        r1.mScreenDozeTimer.readSummaryFromParcelLocked(r7);
        int i = 0;
    L24:
        if (i >= 5) goto L26;
        r1.mScreenBrightnessTimer[i].readSummaryFromParcelLocked(r7);
        i = i + 1;
        goto L24
    L26:
        int numDisplays = r7.readInt();
        int i2 = 0;
    L27:
        if (i2 >= numDisplays) goto L29;
        r1.mPerDisplayBatteryStats[i2].readSummaryFromParcel(r7);
        i2 = i2 + 1;
        goto L27
    L29:
        r1.mInteractive = false;
        r1.mInteractiveTimer.readSummaryFromParcelLocked(r7);
        r1.mPhoneOn = false;
        r1.mPowerSaveModeEnabledTimer.readSummaryFromParcelLocked(r7);
        r1.mLongestLightIdleTimeMs = r7.readLong();
        r1.mLongestFullIdleTimeMs = r7.readLong();
        r1.mDeviceIdleModeLightTimer.readSummaryFromParcelLocked(r7);
        r1.mDeviceIdleModeFullTimer.readSummaryFromParcelLocked(r7);
        r1.mDeviceLightIdlingTimer.readSummaryFromParcelLocked(r7);
        r1.mDeviceIdlingTimer.readSummaryFromParcelLocked(r7);
        r1.mPhoneOnTimer.readSummaryFromParcelLocked(r7);
        int i3 = 0;
    L31:
        if (i3 >= CELL_SIGNAL_STRENGTH_LEVEL_COUNT) goto L33;
        r1.mPhoneSignalStrengthsTimer[i3].readSummaryFromParcelLocked(r7);
        i3 = i3 + 1;
        goto L31
    L33:
        r1.mPhoneSignalScanningTimer.readSummaryFromParcelLocked(r7);
        int i4 = 0;
    L35:
        if (i4 >= BatteryStats.NUM_DATA_CONNECTION_TYPES) goto L37;
        r1.mPhoneDataConnectionsTimer[i4].readSummaryFromParcelLocked(r7);
        i4 = i4 + 1;
        goto L35
    L37:
        r1.mNrNsaTimer.readSummaryFromParcelLocked(r7);
        int i5 = 0;
    L39:
        if (i5 >= 10) goto L41;
        r1.mNetworkByteActivityCounters[i5].readSummaryFromParcelLocked(r7);
        r1.mNetworkPacketActivityCounters[i5].readSummaryFromParcelLocked(r7);
        i5 = i5 + 1;
        goto L39
    L41:
        int numRat = r7.readInt();
        int i6 = 0;
    L42:
        if (i6 >= numRat) goto L48;
        if (r7.readInt() == 0) goto L47;
        r1.getRatBatteryStatsLocked(i6).readSummaryFromParcel(r7);
    L47:
        i6 = i6 + 1;
        goto L42
    L48:
        r1.mMobileRadioPowerState = 1;
        r1.mMobileRadioActiveTimer.readSummaryFromParcelLocked(r7);
        r1.mMobileRadioActivePerAppTimer.readSummaryFromParcelLocked(r7);
        r1.mMobileRadioActiveAdjustedTime.readSummaryFromParcelLocked(r7);
        r1.mMobileRadioActiveUnknownTime.readSummaryFromParcelLocked(r7);
        r1.mMobileRadioActiveUnknownCount.readSummaryFromParcelLocked(r7);
        r1.mWifiMulticastWakelockTimer.readSummaryFromParcelLocked(r7);
        r1.mWifiRadioPowerState = 1;
        r1.mWifiOn = false;
        r1.mWifiOnTimer.readSummaryFromParcelLocked(r7);
        r1.mGlobalWifiRunning = false;
        r1.mGlobalWifiRunningTimer.readSummaryFromParcelLocked(r7);
        int i7 = 0;
    L50:
        if (i7 >= 8) goto L52;
        r1.mWifiStateTimer[i7].readSummaryFromParcelLocked(r7);
        i7 = i7 + 1;
        goto L50
    L52:
        int i8 = 0;
    L54:
        if (i8 >= 13) goto L56;
        r1.mWifiSupplStateTimer[i8].readSummaryFromParcelLocked(r7);
        i8 = i8 + 1;
        goto L54
    L56:
        int i9 = 0;
    L57:
        if (i9 >= 5) goto L59;
        r1.mWifiSignalStrengthsTimer[i9].readSummaryFromParcelLocked(r7);
        i9 = i9 + 1;
        goto L57
    L59:
        r1.mWifiActiveTimer.readSummaryFromParcelLocked(r7);
        r1.mWifiActivity.readSummaryFromParcel(r7);
        int i10 = 0;
    L61:
        if (i10 >= r1.mGpsSignalQualityTimer.length) goto L63;
        r1.mGpsSignalQualityTimer[i10].readSummaryFromParcelLocked(r7);
        i10 = i10 + 1;
        goto L61
    L63:
        r1.mBluetoothActivity.readSummaryFromParcel(r7);
        r1.mModemActivity.readSummaryFromParcel(r7);
        if (r7.readInt() == 0) goto L66;
        boolean r4 = true;
    L67:
        r1.mHasWifiReporting = r4;
        if (r7.readInt() == 0) goto L70;
        boolean r5 = true;
    L71:
        r1.mHasBluetoothReporting = r5;
        if (r7.readInt() == 0) goto L74;
        boolean r6 = true;
    L75:
        r1.mHasModemReporting = r6;
        r1.mNumConnectivityChange = r7.readInt();
        r1.mFlashlightOnNesting = 0;
        r1.mFlashlightOnTimer.readSummaryFromParcelLocked(r7);
        r1.mCameraOnNesting = 0;
        r1.mCameraOnTimer.readSummaryFromParcelLocked(r7);
        r1.mBluetoothScanNesting = 0;
        r1.mBluetoothScanTimer.readSummaryFromParcelLocked(r7);
        int NRPMS = r7.readInt();
        if (NRPMS > 10000) goto L335;
        int irpm = 0;
    L78:
        if (irpm >= NRPMS) goto L84;
        if (r7.readInt() == 0) goto L83;
        String rpmName = r7.readString();
        r1.getRpmTimerLocked(rpmName).readSummaryFromParcelLocked(r7);
    L83:
        irpm = irpm + 1;
        r11 = r11;
        goto L78
    L84:
        boolean r17 = r11;
        int NSORPMS = r7.readInt();
        if (NSORPMS > 10000) goto L333;
        int irpm2 = 0;
    L87:
        if (irpm2 >= NSORPMS) goto L92;
        if (r7.readInt() == 0) goto L91;
        String rpmName2 = r7.readString();
        r1.getScreenOffRpmTimerLocked(rpmName2).readSummaryFromParcelLocked(r7);
    L91:
        irpm2 = irpm2 + 1;
        goto L87
    L92:
        int NKW = r7.readInt();
        if (NKW > 10000) goto L331;
        int ikw = 0;
    L95:
        if (ikw >= NKW) goto L100;
        if (r7.readInt() == 0) goto L99;
        String kwltName = r7.readString();
        r1.getKernelWakelockTimerLocked(kwltName).readSummaryFromParcelLocked(r7);
    L99:
        ikw = ikw + 1;
        goto L95
    L100:
        int NWR = r7.readInt();
        if (NWR > 10000) goto L329;
        int iwr = 0;
    L103:
        if (iwr >= NWR) goto L108;
        if (r7.readInt() == 0) goto L107;
        String reasonName = r7.readString();
        r1.getWakeupReasonTimerLocked(reasonName).readSummaryFromParcelLocked(r7);
    L107:
        iwr = iwr + 1;
        goto L103
    L108:
        int NMS = r7.readInt();
        int ims = 0;
    L109:
        if (ims >= NMS) goto L115;
        if (r7.readInt() == 0) goto L114;
        long kmstName = r7.readLong();
        r1.getKernelMemoryTimerLocked(kmstName).readSummaryFromParcelLocked(r7);
    L114:
        ims = ims + 1;
        numDisplays = numDisplays;
        goto L109
    L115:
        int NU = r7.readInt();
        if (NU > 10000) goto L327;
        long elapsedRealtimeMs = r1.mClock.elapsedRealtime();
        long uptimeMs = r1.mClock.uptimeMillis();
        int NJ = 0;
    L118:
        if (NJ >= NU) goto L325;
        int numRat2 = numRat;
        int uid = r7.readInt();
        int NU2 = NU;
        int iu = NJ;
        int NRPMS2 = NRPMS;
        long elapsedRealtimeMs2 = elapsedRealtimeMs;
        int version2 = version;
        Uid u = new Uid(r1, uid, elapsedRealtimeMs2, uptimeMs);
        BatteryStatsImpl r8 = r1;
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        r8.mUidStats.put(uid, u);
        u.mOnBatteryBackgroundTimeBase.readSummaryFromParcel(r7);
        u.mOnBatteryScreenOffBackgroundTimeBase.readSummaryFromParcel(r7);
        u.mWifiRunning = false;
        if (r7.readInt() == 0) goto L122;
        u.mWifiRunningTimer.readSummaryFromParcelLocked(r7);
    L122:
        u.mFullWifiLockOut = false;
        if (r7.readInt() == 0) goto L125;
        u.mFullWifiLockTimer.readSummaryFromParcelLocked(r7);
    L125:
        u.mWifiScanStarted = false;
        if (r7.readInt() == 0) goto L128;
        u.mWifiScanTimer.readSummaryFromParcelLocked(r7);
    L128:
        u.mWifiBatchedScanBinStarted = -1;
        int i11 = 0;
    L130:
        if (i11 >= 5) goto L135;
        if (r7.readInt() == 0) goto L134;
        u.makeWifiBatchedScanBin(i11, null);
        u.mWifiBatchedScanTimer[i11].readSummaryFromParcelLocked(r7);
    L134:
        i11 = i11 + 1;
        goto L130
    L135:
        u.mWifiMulticastWakelockCount = 0;
        if (r7.readInt() == 0) goto L139;
        u.mWifiMulticastTimer.readSummaryFromParcelLocked(r7);
    L139:
        if (r7.readInt() == 0) goto L142;
        u.createAudioTurnedOnTimerLocked().readSummaryFromParcelLocked(r7);
    L142:
        if (r7.readInt() == 0) goto L145;
        u.createVideoTurnedOnTimerLocked().readSummaryFromParcelLocked(r7);
    L145:
        if (r7.readInt() == 0) goto L148;
        u.createFlashlightTurnedOnTimerLocked().readSummaryFromParcelLocked(r7);
    L148:
        if (r7.readInt() == 0) goto L151;
        u.createCameraTurnedOnTimerLocked().readSummaryFromParcelLocked(r7);
    L151:
        if (r7.readInt() == 0) goto L154;
        u.createForegroundActivityTimerLocked().readSummaryFromParcelLocked(r7);
    L154:
        if (r7.readInt() == 0) goto L157;
        u.createForegroundServiceTimerLocked().readSummaryFromParcelLocked(r7);
    L157:
        if (r7.readInt() == 0) goto L160;
        u.createAggregatedPartialWakelockTimerLocked().readSummaryFromParcelLocked(r7);
    L160:
        if (r7.readInt() == 0) goto L163;
        u.createBluetoothScanTimerLocked().readSummaryFromParcelLocked(r7);
    L163:
        if (r7.readInt() == 0) goto L166;
        u.createBluetoothUnoptimizedScanTimerLocked().readSummaryFromParcelLocked(r7);
    L166:
        if (r7.readInt() == 0) goto L169;
        u.createBluetoothScanResultCounterLocked().readSummaryFromParcelLocked(r7);
    L169:
        if (r7.readInt() == 0) goto L171;
        u.createBluetoothScanResultBgCounterLocked().readSummaryFromParcelLocked(r7);
    L171:
        int r9 = 7;
        u.mProcessState = 7;
        int i12 = 0;
    L172:
        if (i12 >= r9) goto L177;
        if (r7.readInt() == 0) goto L176;
        u.makeProcessState(i12, null);
        u.mProcessStateTimer[i12].readSummaryFromParcelLocked(r7);
    L176:
        i12 = i12 + 1;
        r9 = 7;
        goto L172
    L177:
        int i13 = r7.readInt();
        if (i13 == 0) goto L181;
        u.createVibratorOnTimerLocked().readSummaryFromParcelLocked(r7);
    L181:
        if (r7.readInt() != 0) goto L183;
    L189:
        int i14 = r7.readInt();
        if (i14 == 0) goto L198;
        u.ensureNetworkActivityLocked();
        int i15 = 0;
    L192:
        if (i15 >= 10) goto L195;
        u.mNetworkByteActivityCounters[i15].readSummaryFromParcelLocked(r7);
        u.mNetworkPacketActivityCounters[i15].readSummaryFromParcelLocked(r7);
        i15 = i15 + 1;
        goto L192
    L195:
        if (r7.readBoolean() == false) goto L197;
        u.mMobileRadioActiveTime = TimeMultiStateCounter.m7795$$Nest$smreadFromParcel(r7, r8.mOnBatteryTimeBase, 5, elapsedRealtimeMs3);
    L197:
        u.mMobileRadioActiveCount.readSummaryFromParcelLocked(r7);
    L198:
        u.mUserCpuTime.readSummaryFromParcelLocked(r7);
        u.mSystemCpuTime.readSummaryFromParcelLocked(r7);
        if (r7.readInt() == 0) goto L234;
        int numClusters = r7.readInt();
        if (r8.mCpuScalingPolicies == null) goto L203;
        int[] policies = r8.mCpuScalingPolicies.getPolicies();
    L204:
        if (policies == null) goto L211;
        if (policies.length == numClusters) goto L211;
        throw new ParcelFormatException("Incompatible cpu cluster arrangement");
    L211:
        detachIfNotNull(u.mCpuClusterSpeedTimesUs);
        u.mCpuClusterSpeedTimesUs = new LongSamplingCounter[numClusters][];
        int cluster = 0;
    L212:
        if (cluster >= numClusters) goto L235;
        if (r7.readInt() == 0) goto L231;
        int NSB = r7.readInt();
        if (policies == null) goto L222;
        int cluster2 = cluster;
        if (r8.mCpuScalingPolicies.getFrequencies(policies[cluster2]).length != NSB) goto L221;
    L223:
        u.mCpuClusterSpeedTimesUs[cluster2] = new LongSamplingCounter[NSB];
        int speed = 0;
    L224:
        if (speed >= NSB) goto L232;
        if (r7.readInt() == 0) goto L228;
        int speed2 = speed;
        u.mCpuClusterSpeedTimesUs[cluster2][speed2] = new LongSamplingCounter(r8.mOnBatteryTimeBase);
        u.mCpuClusterSpeedTimesUs[cluster2][speed2].readSummaryFromParcelLocked(r7);
    L229:
        speed = speed2 + 1;
        goto L224
    L228:
        speed2 = speed;
    L232:
        cluster = cluster2 + 1;
        uid = uid;
        goto L212
    L221:
        throw new ParcelFormatException("File corrupt: too many speed bins " + NSB);
    L222:
        cluster2 = cluster;
        goto L223
    L231:
        cluster2 = cluster;
        uid = uid;
        u.mCpuClusterSpeedTimesUs[cluster2] = null;
    L235:
        detachIfNotNull(u.mCpuFreqTimeMs);
        u.mCpuFreqTimeMs = LongSamplingCounterArray.readSummaryFromParcelLocked(r7, r8.mOnBatteryTimeBase);
        detachIfNotNull(u.mScreenOffCpuFreqTimeMs);
        u.mScreenOffCpuFreqTimeMs = LongSamplingCounterArray.readSummaryFromParcelLocked(r7, r8.mOnBatteryScreenOffTimeBase);
        int stateCount = r7.readInt();
        if (stateCount == 0) goto L239;
        u.mCpuActiveTimeMs = TimeMultiStateCounter.m7795$$Nest$smreadFromParcel(r7, r8.mOnBatteryTimeBase, 5, r8.mClock.elapsedRealtime());
    L239:
        LongSamplingCounterArray.m7780$$Nest$mreadSummaryFromParcelLocked(u.mCpuClusterTimesMs, r7);
        detachIfNotNull(u.mProcStateTimeMs);
        u.mProcStateTimeMs = null;
        int stateCount2 = r7.readInt();
        if (stateCount2 == 0) goto L242;
        detachIfNotNull(u.mProcStateTimeMs);
        Parcel r0 = r7;
        Uid u2 = u;
        u2.mProcStateTimeMs = TimeInFreqMultiStateCounter.m7790$$Nest$smreadFromParcel(r0, r8.mOnBatteryTimeBase, 8, r8.mCpuScalingPolicies.getScalingStepCount(), r8.mClock.elapsedRealtime());
    L243:
        detachIfNotNull(u2.mProcStateScreenOffTimeMs);
        u2.mProcStateScreenOffTimeMs = null;
        int stateCount3 = in.readInt();
        if (stateCount3 == 0) goto L246;
        detachIfNotNull(u2.mProcStateScreenOffTimeMs);
        Parcel r2 = in;
        u2.mProcStateScreenOffTimeMs = TimeInFreqMultiStateCounter.m7790$$Nest$smreadFromParcel(r2, r8.mOnBatteryScreenOffTimeBase, 8, r8.mCpuScalingPolicies.getScalingStepCount(), r8.mClock.elapsedRealtime());
    L248:
        if (r2.readInt() == 0) goto L250;
        detachIfNotNull(Uid.m7798$$Nest$fgetmMobileRadioApWakeupCount(u2));
        Uid.m7802$$Nest$fputmMobileRadioApWakeupCount(u2, new LongSamplingCounter(r8.mOnBatteryTimeBase));
        Uid.m7798$$Nest$fgetmMobileRadioApWakeupCount(u2).readSummaryFromParcelLocked(r2);
    L252:
        if (r2.readInt() == 0) goto L254;
        detachIfNotNull(Uid.m7801$$Nest$fgetmWifiRadioApWakeupCount(u2));
        Uid.m7806$$Nest$fputmWifiRadioApWakeupCount(u2, new LongSamplingCounter(r8.mOnBatteryTimeBase));
        Uid.m7801$$Nest$fgetmWifiRadioApWakeupCount(u2).readSummaryFromParcelLocked(r2);
    L255:
        Uid.m7805$$Nest$fputmUidEnergyConsumerStats(u2, EnergyConsumerStats.createAndReadSummaryFromParcel(r8.mEnergyConsumerStatsConfig, r2));
        int NW = r2.readInt();
        if (NW > (MAX_WAKELOCKS_PER_UID + 1)) goto L323;
        int iw = 0;
    L258:
        if (iw >= NW) goto L260;
        String wlName = r2.readString();
        u2.readWakeSummaryFromParcelLocked(wlName, r2);
        iw = iw + 1;
        goto L258
    L260:
        int NS = r2.readInt();
        if (NS > (MAX_WAKELOCKS_PER_UID + 1)) goto L321;
        int is = 0;
    L263:
        if (is >= NS) goto L265;
        String name = r2.readString();
        u2.readSyncSummaryFromParcelLocked(name, r2);
        is = is + 1;
        goto L263
    L265:
        int NJ2 = r2.readInt();
        if (NJ2 > (MAX_WAKELOCKS_PER_UID + 1)) goto L319;
        int ij = 0;
    L268:
        if (ij >= NJ2) goto L270;
        String name2 = r2.readString();
        u2.readJobSummaryFromParcelLocked(name2, r2);
        ij = ij + 1;
        goto L268
    L270:
        u2.readJobCompletionsFromParcelLocked(r2);
        u2.mJobsDeferredEventCount.readSummaryFromParcelLocked(r2);
        u2.mJobsDeferredCount.readSummaryFromParcelLocked(r2);
        u2.mJobsFreshnessTimeMs.readSummaryFromParcelLocked(r2);
        detachIfNotNull(u2.mJobsFreshnessBuckets);
        int i16 = 0;
    L272:
        if (i16 >= BatteryStats.JOB_FRESHNESS_BUCKETS.length) goto L278;
        if (r2.readInt() == 0) goto L276;
        int i17 = i16;
        u2.mJobsFreshnessBuckets[i17] = new Counter(u2.mBsi.mOnBatteryTimeBase);
        u2.mJobsFreshnessBuckets[i17].readSummaryFromParcelLocked(r2);
    L277:
        i16 = i17 + 1;
        goto L272
    L276:
        i17 = i16;
        goto L277
    L278:
        int NP = r2.readInt();
        if (NP > 1000) goto L317;
        int is2 = 0;
    L281:
        if (is2 >= NP) goto L287;
        int seNumber = r2.readInt();
        if (r2.readInt() == 0) goto L285;
        boolean r10 = r17;
        u2.getSensorTimerLocked(seNumber, r10).readSummaryFromParcelLocked(r2);
    L286:
        int seNumber2 = is2 + 1;
        NMS = NMS;
        r17 = r10;
        is2 = seNumber2;
        goto L281
    L285:
        r10 = r17;
        goto L286
    L287:
        int NMS2 = NMS;
        int NP2 = r2.readInt();
        if (NP2 > 10000) goto L315;
        int ip = 0;
    L290:
        if (ip >= NP2) goto L292;
        String procName = r2.readString();
        Uid.Proc p = u2.getProcessStatsLocked(procName);
        p.mUserTimeMs = r2.readLong();
        p.mSystemTimeMs = r2.readLong();
        p.mForegroundTimeMs = r2.readLong();
        p.mStarts = r2.readInt();
        p.mNumCrashes = r2.readInt();
        p.mNumAnrs = r2.readInt();
        p.readExcessivePowerFromParcelLocked(r2);
        ip = ip + 1;
        NPKG2 = NPKG2;
        config = config;
        goto L290
    L292:
        int NPKG3 = NPKG2;
        EnergyConsumerStats.Config config2 = config;
        int NP3 = r2.readInt();
        if (NP3 > 10000) goto L313;
        int ip2 = 0;
    L295:
        if (ip2 >= NP3) goto L311;
        String pkgName = r2.readString();
        detachIfNotNull(u2.mPackageStats.get(pkgName));
        Uid.Pkg p2 = u2.getPackageStatsLocked(pkgName);
        int NWA = r2.readInt();
        if (NWA > 10000) goto L310;
        p2.mWakeupAlarms.clear();
        int iwa = 0;
    L299:
        if (iwa >= NWA) goto L301;
        int NS2 = NS;
        String tag = r2.readString();
        int ip3 = ip2;
        Counter c = new Counter(r8.mOnBatteryScreenOffTimeBase);
        c.readSummaryFromParcelLocked(r2);
        p2.mWakeupAlarms.put(tag, c);
        iwa = iwa + 1;
        NS = NS2;
        ip2 = ip3;
        goto L299
    L301:
        int ip4 = ip2;
        NS = r2.readInt();
        if (NS > 10000) goto L308;
        int is3 = 0;
    L304:
        if (is3 >= NS) goto L306;
        String servName = r2.readString();
        Uid.Pkg.Serv s = u2.getServiceStatsLocked(pkgName, servName);
        s.mStartTimeMs = in.readLong();
        s.mStarts = in.readInt();
        s.mLaunches = in.readInt();
        is3 = is3 + 1;
        r2 = in;
        goto L304
    L306:
        ip2 = ip4 + 1;
        r8 = this;
        r2 = in;
        goto L295
    L308:
        throw new ParcelFormatException("File corrupt: too many services " + NS);
    L310:
        throw new ParcelFormatException("File corrupt: too many wakeup alarms " + NWA);
    L311:
        NJ = iu + 1;
        r1 = this;
        r7 = in;
        version = version2;
        NMS = NMS2;
        numRat = numRat2;
        NRPMS = NRPMS2;
        NU = NU2;
        elapsedRealtimeMs = elapsedRealtimeMs3;
        NPKG2 = NPKG3;
        config = config2;
        r17 = true;
        goto L118
    L313:
        throw new ParcelFormatException("File corrupt: too many packages " + NP3);
    L315:
        throw new ParcelFormatException("File corrupt: too many processes " + NP2);
    L317:
        throw new ParcelFormatException("File corrupt: too many sensors " + NP);
    L319:
        throw new ParcelFormatException("File corrupt: too many job timers " + NJ2);
    L321:
        throw new ParcelFormatException("File corrupt: too many syncs " + NS);
    L323:
        throw new ParcelFormatException("File corrupt: too many wake locks " + NW);
    L254:
        detachIfNotNull(Uid.m7801$$Nest$fgetmWifiRadioApWakeupCount(u2));
        Uid.m7806$$Nest$fputmWifiRadioApWakeupCount(u2, null);
        goto L255
    L250:
        detachIfNotNull(Uid.m7798$$Nest$fgetmMobileRadioApWakeupCount(u2));
        Uid.m7802$$Nest$fputmMobileRadioApWakeupCount(u2, null);
        goto L252
    L246:
        r2 = in;
        goto L248
    L242:
        u2 = u;
        goto L243
    L203:
        policies = null;
        goto L204
    L234:
        elapsedRealtimeMs3 = elapsedRealtimeMs3;
        detachIfNotNull(u.mCpuClusterSpeedTimesUs);
        u.mCpuClusterSpeedTimesUs = null;
        goto L235
    L183:
        if (u.mUserActivityCounters != null) goto L185;
        u.initUserActivityLocked();
    L185:
        int i18 = 0;
    L187:
        if (i18 >= BatteryStats.Uid.NUM_USER_ACTIVITY_TYPES) goto L189;
        u.mUserActivityCounters[i18].readSummaryFromParcelLocked(r7);
        i18 = i18 + 1;
        goto L187
    L325:
        return;
    L327:
        throw new ParcelFormatException("File corrupt: too many uids " + NU);
    L329:
        throw new ParcelFormatException("File corrupt: too many wakeup reasons " + NWR);
    L331:
        throw new ParcelFormatException("File corrupt: too many kernel wake locks " + NKW);
    L333:
        throw new ParcelFormatException("File corrupt: too many screen-off rpm stats " + NSORPMS);
    L335:
        throw new ParcelFormatException("File corrupt: too many rpm stats " + NRPMS);
    L74:
        r6 = false;
        goto L75
    L70:
        r5 = false;
        goto L71
    L66:
        r4 = false;
        goto L67
    L20:
        if (Arrays.equals(config.getStateNames(), getBatteryConsumerProcessStateNames()) == false) goto L22;
        r1.mEnergyConsumerStatsConfig = config;
        r1.mGlobalEnergyConsumerStats = energyConsumerStats;
        goto L22
    L16:
        r1.mDailyPackageChanges = null;
        NPKG2 = NPKG;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r7v55 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void writeSummaryToParcel(Parcel r33, boolean r34) {
        BatteryStatsImpl r0 = this;
        Parcel r2 = r33;
        r0.pullPendingStateUpdatesLocked();
        r0.getStartClockTime();
        long r7 = 1000;
        long r3 = r0.mClock.uptimeMillis() * 1000;
        long r5 = r0.mClock.elapsedRealtime() * 1000;
        r2.writeInt(VERSION);
        r0.mHistory.writeSummaryToParcel(r2, r34);
        r2.writeInt(r0.mStartCount);
        boolean r10 = false;
        r2.writeLong(r0.computeUptime(r3, 0));
        r2.writeLong(r0.computeRealtime(r5, 0));
        r2.writeLong(r0.mStartClockTimeMs);
        r2.writeLong(r0.mMonotonicStartTime);
        r2.writeLong(r0.mMonotonicClock.monotonicTime());
        r2.writeString(r0.mStartPlatformVersion);
        r2.writeString(r0.mEndPlatformVersion);
        r0.mOnBatteryTimeBase.writeSummaryToParcel(r2, r3, r5);
        r0.mOnBatteryScreenOffTimeBase.writeSummaryToParcel(r2, r3, r5);
        r2.writeInt(r0.mDischargeUnplugLevel);
        r2.writeInt(r0.mDischargePlugLevel);
        r2.writeInt(r0.mDischargeCurrentLevel);
        r2.writeInt(r0.mBatteryLevel);
        r2.writeInt(r0.mEstimatedBatteryCapacityMah);
        r2.writeInt(r0.mLastLearnedBatteryCapacityUah);
        r2.writeInt(r0.mMinLearnedBatteryCapacityUah);
        r2.writeInt(r0.mMaxLearnedBatteryCapacityUah);
        r2.writeInt(r0.getLowDischargeAmountSinceCharge());
        r2.writeInt(r0.getHighDischargeAmountSinceCharge());
        r2.writeInt(r0.getDischargeAmountScreenOnSinceCharge());
        r2.writeInt(r0.getDischargeAmountScreenOffSinceCharge());
        r2.writeInt(r0.getDischargeAmountScreenDozeSinceCharge());
        r0.mDischargeStepTracker.writeToParcel(r2);
        r0.mChargeStepTracker.writeToParcel(r2);
        r0.mDailyDischargeStepTracker.writeToParcel(r2);
        r0.mDailyChargeStepTracker.writeToParcel(r2);
        r0.mDischargeCounter.writeSummaryFromParcelLocked(r2);
        r0.mDischargeScreenOffCounter.writeSummaryFromParcelLocked(r2);
        r0.mDischargeScreenDozeCounter.writeSummaryFromParcelLocked(r2);
        r0.mDischargeLightDozeCounter.writeSummaryFromParcelLocked(r2);
        r0.mDischargeDeepDozeCounter.writeSummaryFromParcelLocked(r2);
        if (r0.mDailyPackageChanges == null) goto L8;
        int r1 = r0.mDailyPackageChanges.size();
        r2.writeInt(r1);
        int r11 = 0;
    L5:
        if (r11 >= r1) goto L9;
        BatteryStats.PackageChange r12 = r0.mDailyPackageChanges.get(r11);
        r2.writeString(r12.mPackageName);
        r2.writeInt(r12.mUpdate ? 1 : 0);
        r2.writeLong(r12.mVersionCode);
        r11 = r11 + 1;
    L9:
        r2.writeLong(r0.mDailyStartTimeMs);
        r2.writeLong(r0.mNextMinDailyDeadlineMs);
        r2.writeLong(r0.mNextMaxDailyDeadlineMs);
        r2.writeLong(r0.mBatteryTimeToFullSeconds);
        EnergyConsumerStats.Config.writeToParcel(r0.mEnergyConsumerStatsConfig, r2);
        EnergyConsumerStats.writeSummaryToParcel(r0.mGlobalEnergyConsumerStats, r2);
        r0.mScreenOnTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mScreenDozeTimer.writeSummaryFromParcelLocked(r2, r5);
        int r4 = 0;
    L11:
        if (r4 >= 5) goto L13;
        r0.mScreenBrightnessTimer[r4].writeSummaryFromParcelLocked(r2, r5);
        r4 = r4 + 1;
        goto L11
    L13:
        int r13 = r0.mPerDisplayBatteryStats.length;
        r2.writeInt(r13);
        int r6 = 0;
    L14:
        if (r6 >= r13) goto L16;
        r0.mPerDisplayBatteryStats[r6].writeSummaryToParcel(r2, r5);
        r6 = r6 + 1;
        goto L14
    L16:
        r0.mInteractiveTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mPowerSaveModeEnabledTimer.writeSummaryFromParcelLocked(r2, r5);
        r2.writeLong(r0.mLongestLightIdleTimeMs);
        r2.writeLong(r0.mLongestFullIdleTimeMs);
        r0.mDeviceIdleModeLightTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mDeviceIdleModeFullTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mDeviceLightIdlingTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mDeviceIdlingTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mPhoneOnTimer.writeSummaryFromParcelLocked(r2, r5);
        int r8 = 0;
    L18:
        if (r8 >= CELL_SIGNAL_STRENGTH_LEVEL_COUNT) goto L20;
        r0.mPhoneSignalStrengthsTimer[r8].writeSummaryFromParcelLocked(r2, r5);
        r8 = r8 + 1;
        goto L18
    L20:
        r0.mPhoneSignalScanningTimer.writeSummaryFromParcelLocked(r2, r5);
        int r9 = 0;
    L22:
        if (r9 >= BatteryStats.NUM_DATA_CONNECTION_TYPES) goto L24;
        r0.mPhoneDataConnectionsTimer[r9].writeSummaryFromParcelLocked(r2, r5);
        r9 = r9 + 1;
        goto L22
    L24:
        r0.mNrNsaTimer.writeSummaryFromParcelLocked(r2, r5);
        int r14 = 0;
    L26:
        if (r14 >= 10) goto L28;
        r0.mNetworkByteActivityCounters[r14].writeSummaryFromParcelLocked(r2);
        r0.mNetworkPacketActivityCounters[r14].writeSummaryFromParcelLocked(r2);
        r14 = r14 + 1;
        goto L26
    L28:
        int r15 = r0.mPerRatBatteryStats.length;
        r2.writeInt(r15);
        int r16 = 0;
    L29:
        boolean r17 = true;
        if (r16 >= r15) goto L36;
        long r18 = r7;
        RadioAccessTechnologyBatteryStats r19 = r0.mPerRatBatteryStats[r16];
        if (r19 != null) goto L34;
        r2.writeInt(0);
    L35:
        r16 = r16 + 1;
        r7 = r18;
        goto L29
    L34:
        r2.writeInt(1);
        r19.writeSummaryToParcel(r2, r5);
        goto L35
    L36:
        long r110 = r7;
        r0.mMobileRadioActiveTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mMobileRadioActivePerAppTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mMobileRadioActiveAdjustedTime.writeSummaryFromParcelLocked(r2);
        r0.mMobileRadioActiveUnknownTime.writeSummaryFromParcelLocked(r2);
        r0.mMobileRadioActiveUnknownCount.writeSummaryFromParcelLocked(r2);
        r0.mWifiMulticastWakelockTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mWifiOnTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mGlobalWifiRunningTimer.writeSummaryFromParcelLocked(r2, r5);
        int r20 = 0;
    L38:
        if (r20 >= 8) goto L40;
        r0.mWifiStateTimer[r20].writeSummaryFromParcelLocked(r2, r5);
        r20 = r20 + 1;
        goto L38
    L40:
        int r21 = 0;
    L42:
        if (r21 >= 13) goto L44;
        r0.mWifiSupplStateTimer[r21].writeSummaryFromParcelLocked(r2, r5);
        r21 = r21 + 1;
        goto L42
    L44:
        int r22 = 0;
    L45:
        if (r22 >= 5) goto L47;
        r0.mWifiSignalStrengthsTimer[r22].writeSummaryFromParcelLocked(r2, r5);
        r22 = r22 + 1;
        goto L45
    L47:
        r0.mWifiActiveTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mWifiActivity.writeSummaryToParcel(r2);
        int r23 = 0;
    L49:
        if (r23 >= r0.mGpsSignalQualityTimer.length) goto L51;
        r0.mGpsSignalQualityTimer[r23].writeSummaryFromParcelLocked(r2, r5);
        r23 = r23 + 1;
        goto L49
    L51:
        r0.mBluetoothActivity.writeSummaryToParcel(r2);
        r0.mModemActivity.writeSummaryToParcel(r2);
        r2.writeInt(r0.mHasWifiReporting ? 1 : 0);
        r2.writeInt(r0.mHasBluetoothReporting ? 1 : 0);
        r2.writeInt(r0.mHasModemReporting ? 1 : 0);
        r2.writeInt(r0.mNumConnectivityChange);
        r0.mFlashlightOnTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mCameraOnTimer.writeSummaryFromParcelLocked(r2, r5);
        r0.mBluetoothScanTimer.writeSummaryFromParcelLocked(r2, r5);
        r2.writeInt(r0.mRpmStats.size());
        Iterator<Map.Entry<String, SamplingTimer>> r24 = r0.mRpmStats.entrySet().iterator();
    L53:
        if (r24.hasNext() == false) goto L59;
        Map.Entry<String, SamplingTimer> r25 = r24.next();
        SamplingTimer r26 = r25.getValue();
        if (r26 == null) goto L57;
        r2.writeInt(1);
        r2.writeString(r25.getKey());
        r26.writeSummaryFromParcelLocked(r2, r5);
        goto L53
    L57:
        r2.writeInt(0);
        goto L53
    L59:
        r2.writeInt(r0.mScreenOffRpmStats.size());
        Iterator<Map.Entry<String, SamplingTimer>> r27 = r0.mScreenOffRpmStats.entrySet().iterator();
    L61:
        if (r27.hasNext() == false) goto L67;
        Map.Entry<String, SamplingTimer> r28 = r27.next();
        SamplingTimer r29 = r28.getValue();
        if (r29 != null) goto L64;
        r2.writeInt(0);
        goto L61
    L64:
        r2.writeInt(1);
        r2.writeString(r28.getKey());
        r29.writeSummaryFromParcelLocked(r2, r5);
        goto L61
    L67:
        r2.writeInt(r0.mKernelWakelockStats.size());
        Iterator<Map.Entry<String, SamplingTimer>> r30 = r0.mKernelWakelockStats.entrySet().iterator();
    L69:
        if (r30.hasNext() == false) goto L75;
        Map.Entry<String, SamplingTimer> r31 = r30.next();
        SamplingTimer r32 = r31.getValue();
        if (r32 != null) goto L72;
        r2.writeInt(0);
        goto L69
    L72:
        r2.writeInt(1);
        r2.writeString(r31.getKey());
        r32.writeSummaryFromParcelLocked(r2, r5);
        goto L69
    L75:
        r2.writeInt(r0.mWakeupReasonStats.size());
        Iterator<Map.Entry<String, SamplingTimer>> r35 = r0.mWakeupReasonStats.entrySet().iterator();
    L77:
        if (r35.hasNext() == false) goto L83;
        Map.Entry<String, SamplingTimer> r36 = r35.next();
        SamplingTimer r37 = r36.getValue();
        if (r37 != null) goto L80;
        r2.writeInt(0);
        goto L77
    L80:
        r2.writeInt(1);
        r2.writeString(r36.getKey());
        r37.writeSummaryFromParcelLocked(r2, r5);
        goto L77
    L83:
        r2.writeInt(r0.mKernelMemoryStats.size());
        int r38 = 0;
    L85:
        if (r38 >= r0.mKernelMemoryStats.size()) goto L91;
        SamplingTimer r39 = r0.mKernelMemoryStats.valueAt(r38);
        if (r39 == null) goto L89;
        r2.writeInt(1);
        r2.writeLong(r0.mKernelMemoryStats.keyAt(r38));
        r39.writeSummaryFromParcelLocked(r2, r5);
    L90:
        r38 = r38 + 1;
        r13 = r13;
        goto L85
    L89:
        r2.writeInt(0);
        goto L90
    L91:
        int r40 = r0.mUidStats.size();
        r2.writeInt(r40);
        int r41 = 0;
        Parcel r42 = r2;
    L92:
        if (r41 >= r40) goto L289;
        r42.writeInt(r0.mUidStats.keyAt(r41));
        Uid r111 = r0.mUidStats.valueAt(r41);
        r111.mOnBatteryBackgroundTimeBase.writeSummaryToParcel(r42, r3, r5);
        Parcel r43 = r33;
        r111.mOnBatteryScreenOffBackgroundTimeBase.writeSummaryToParcel(r43, r3, r5);
        if (r111.mWifiRunningTimer == null) goto L96;
        r43.writeInt(r17 ? 1 : 0);
        r111.mWifiRunningTimer.writeSummaryFromParcelLocked(r43, r5);
    L98:
        if (r111.mFullWifiLockTimer == null) goto L100;
        r43.writeInt(r17 ? 1 : 0);
        r111.mFullWifiLockTimer.writeSummaryFromParcelLocked(r43, r5);
    L102:
        if (r111.mWifiScanTimer == null) goto L104;
        r43.writeInt(r17 ? 1 : 0);
        r111.mWifiScanTimer.writeSummaryFromParcelLocked(r43, r5);
    L105:
        int r44 = 0;
    L107:
        if (r44 >= 5) goto L114;
        if (r111.mWifiBatchedScanTimer[r44] == null) goto L111;
        r43.writeInt(r17 ? 1 : 0);
        r111.mWifiBatchedScanTimer[r44].writeSummaryFromParcelLocked(r43, r5);
    L112:
        r44 = r44 + 1;
        goto L107
    L111:
        r43.writeInt(r10 ? 1 : 0);
        goto L112
    L114:
        if (r111.mWifiMulticastTimer == null) goto L116;
        r43.writeInt(r17 ? 1 : 0);
        r111.mWifiMulticastTimer.writeSummaryFromParcelLocked(r43, r5);
    L118:
        if (r111.mAudioTurnedOnTimer == null) goto L120;
        r43.writeInt(r17 ? 1 : 0);
        r111.mAudioTurnedOnTimer.writeSummaryFromParcelLocked(r43, r5);
    L122:
        if (r111.mVideoTurnedOnTimer == null) goto L124;
        r43.writeInt(r17 ? 1 : 0);
        r111.mVideoTurnedOnTimer.writeSummaryFromParcelLocked(r43, r5);
    L126:
        if (r111.mFlashlightTurnedOnTimer == null) goto L128;
        r43.writeInt(r17 ? 1 : 0);
        r111.mFlashlightTurnedOnTimer.writeSummaryFromParcelLocked(r43, r5);
    L130:
        if (r111.mCameraTurnedOnTimer == null) goto L132;
        r43.writeInt(r17 ? 1 : 0);
        r111.mCameraTurnedOnTimer.writeSummaryFromParcelLocked(r43, r5);
    L134:
        if (r111.mForegroundActivityTimer == null) goto L136;
        r43.writeInt(r17 ? 1 : 0);
        r111.mForegroundActivityTimer.writeSummaryFromParcelLocked(r43, r5);
    L138:
        if (r111.mForegroundServiceTimer == null) goto L140;
        r43.writeInt(r17 ? 1 : 0);
        r111.mForegroundServiceTimer.writeSummaryFromParcelLocked(r43, r5);
    L142:
        if (r111.mAggregatedPartialWakelockTimer == null) goto L144;
        r43.writeInt(r17 ? 1 : 0);
        r111.mAggregatedPartialWakelockTimer.writeSummaryFromParcelLocked(r43, r5);
    L146:
        if (r111.mBluetoothScanTimer == null) goto L148;
        r43.writeInt(r17 ? 1 : 0);
        r111.mBluetoothScanTimer.writeSummaryFromParcelLocked(r43, r5);
    L150:
        if (r111.mBluetoothUnoptimizedScanTimer == null) goto L152;
        r43.writeInt(r17 ? 1 : 0);
        r111.mBluetoothUnoptimizedScanTimer.writeSummaryFromParcelLocked(r43, r5);
    L154:
        if (r111.mBluetoothScanResultCounter == null) goto L156;
        r43.writeInt(r17 ? 1 : 0);
        r111.mBluetoothScanResultCounter.writeSummaryFromParcelLocked(r43);
    L158:
        if (r111.mBluetoothScanResultBgCounter == null) goto L160;
        r43.writeInt(r17 ? 1 : 0);
        r111.mBluetoothScanResultBgCounter.writeSummaryFromParcelLocked(r43);
    L161:
        int r45 = 0;
    L163:
        if (r45 >= 7) goto L170;
        if (r111.mProcessStateTimer[r45] == null) goto L167;
        r43.writeInt(r17 ? 1 : 0);
        r111.mProcessStateTimer[r45].writeSummaryFromParcelLocked(r43, r5);
    L168:
        r45 = r45 + 1;
        goto L163
    L167:
        r43.writeInt(r10 ? 1 : 0);
        goto L168
    L170:
        if (r111.mVibratorOnTimer == null) goto L172;
        r43.writeInt(r17 ? 1 : 0);
        r111.mVibratorOnTimer.writeSummaryFromParcelLocked(r43, r5);
    L174:
        if (r111.mUserActivityCounters != null) goto L176;
        r43.writeInt(r10 ? 1 : 0);
    L181:
        if (r111.mNetworkByteActivityCounters != null) goto L183;
        r43.writeInt(r10 ? 1 : 0);
    L192:
        r111.mUserCpuTime.writeSummaryFromParcelLocked(r43);
        r111.mSystemCpuTime.writeSummaryFromParcelLocked(r43);
        if (r111.mCpuClusterSpeedTimesUs == null) goto L209;
        r43.writeInt(r17 ? 1 : 0);
        r43.writeInt(r111.mCpuClusterSpeedTimesUs.length);
        LongSamplingCounter[][] r46 = r111.mCpuClusterSpeedTimesUs;
        int r112 = r46.length;
        int r113 = r10 ? 1 : 0;
        LongSamplingCounter[][] r47 = r46;
        ?? r114 = r10;
        int r115 = r17;
    L195:
        if (r113 >= r112) goto L208;
        LongSamplingCounter[] r116 = r47[r113];
        if (r116 == null) goto L206;
        r43.writeInt(r115);
        r43.writeInt(r116.length);
        int r117 = r116.length;
        int r48 = 0;
    L199:
        if (r48 >= r117) goto L205;
        int r210 = r48;
        LongSamplingCounter r49 = r116[r210];
        if (r49 == null) goto L203;
        r43.writeInt(1);
        r49.writeSummaryFromParcelLocked(r43);
    L204:
        r48 = r210 + 1;
        r40 = r40;
        goto L199
    L203:
        r43.writeInt(0);
        goto L204
    L205:
        int r211 = r40;
        int r50 = 0;
    L207:
        r113 = r113 + 1;
        r114 = r50;
        r47 = r47;
        r40 = r211;
        r115 = 1;
        goto L195
    L206:
        r211 = r40;
        r50 = 0;
        r43.writeInt(0);
        goto L207
    L208:
        int r212 = r40;
    L210:
        LongSamplingCounterArray.writeSummaryToParcelLocked(r43, r111.mCpuFreqTimeMs);
        LongSamplingCounterArray.writeSummaryToParcelLocked(r43, r111.mScreenOffCpuFreqTimeMs);
        if (r111.mCpuActiveTimeMs == null) goto L213;
        r43.writeInt(r111.mCpuActiveTimeMs.getStateCount());
        TimeMultiStateCounter.m7794$$Nest$mwriteToParcel(r111.mCpuActiveTimeMs, r43);
    L214:
        LongSamplingCounterArray.m7781$$Nest$mwriteSummaryToParcelLocked(r111.mCpuClusterTimesMs, r43);
        if (r111.mProcStateTimeMs == null) goto L217;
        r43.writeInt(r111.mProcStateTimeMs.getStateCount());
        TimeInFreqMultiStateCounter.m7789$$Nest$mwriteToParcel(r111.mProcStateTimeMs, r43);
    L219:
        if (r111.mProcStateScreenOffTimeMs == null) goto L221;
        r43.writeInt(r111.mProcStateScreenOffTimeMs.getStateCount());
        TimeInFreqMultiStateCounter.m7789$$Nest$mwriteToParcel(r111.mProcStateScreenOffTimeMs, r43);
    L223:
        if (Uid.m7798$$Nest$fgetmMobileRadioApWakeupCount(r111) == null) goto L225;
        r43.writeInt(1);
        Uid.m7798$$Nest$fgetmMobileRadioApWakeupCount(r111).writeSummaryFromParcelLocked(r43);
    L227:
        if (Uid.m7801$$Nest$fgetmWifiRadioApWakeupCount(r111) == null) goto L229;
        r43.writeInt(1);
        Uid.m7801$$Nest$fgetmWifiRadioApWakeupCount(r111).writeSummaryFromParcelLocked(r43);
    L230:
        EnergyConsumerStats.writeSummaryToParcel(Uid.m7800$$Nest$fgetmUidEnergyConsumerStats(r111), r43);
        ArrayMap<String, Uid.Wakelock> r51 = r111.mWakelockStats.getMap();
        int r52 = r51.size();
        r43.writeInt(r52);
        int r118 = 0;
    L231:
        if (r118 >= r52) goto L249;
        r43.writeString(r51.keyAt(r118));
        Uid.Wakelock r119 = r51.valueAt(r118);
        if (r119.mTimerFull == null) goto L235;
        r43.writeInt(1);
        r119.mTimerFull.writeSummaryFromParcelLocked(r43, r5);
    L237:
        if (r119.mTimerPartial == null) goto L239;
        r43.writeInt(1);
        r119.mTimerPartial.writeSummaryFromParcelLocked(r43, r5);
    L241:
        if (r119.mTimerWindow == null) goto L243;
        r43.writeInt(1);
        r119.mTimerWindow.writeSummaryFromParcelLocked(r43, r5);
    L245:
        if (r119.mTimerDraw == null) goto L247;
        r43.writeInt(1);
        r119.mTimerDraw.writeSummaryFromParcelLocked(r43, r5);
    L248:
        r118 = r118 + 1;
        goto L231
    L247:
        r43.writeInt(0);
        goto L248
    L243:
        r43.writeInt(0);
        goto L245
    L239:
        r43.writeInt(0);
        goto L241
    L235:
        r43.writeInt(0);
        goto L237
    L249:
        ArrayMap<String, DualTimer> r120 = r111.mSyncStats.getMap();
        int r121 = r120.size();
        r43.writeInt(r121);
        int r122 = 0;
    L250:
        if (r122 >= r121) goto L252;
        r43.writeString(r120.keyAt(r122));
        r120.valueAt(r122).writeSummaryFromParcelLocked(r43, r5);
        r122 = r122 + 1;
        goto L250
    L252:
        ArrayMap<String, DualTimer> r123 = r111.mJobStats.getMap();
        int r124 = r123.size();
        r43.writeInt(r124);
        int r53 = 0;
    L253:
        if (r53 >= r124) goto L255;
        r43.writeString(r123.keyAt(r53));
        r123.valueAt(r53).writeSummaryFromParcelLocked(r43, r5);
        r53 = r53 + 1;
        r52 = r52;
        goto L253
    L255:
        r111.writeJobCompletionsToParcelLocked(r43);
        r111.mJobsDeferredEventCount.writeSummaryFromParcelLocked(r43);
        r111.mJobsDeferredCount.writeSummaryFromParcelLocked(r43);
        r111.mJobsFreshnessTimeMs.writeSummaryFromParcelLocked(r43);
        int r54 = 0;
    L257:
        if (r54 >= BatteryStats.JOB_FRESHNESS_BUCKETS.length) goto L263;
        if (r111.mJobsFreshnessBuckets[r54] == null) goto L261;
        r43.writeInt(1);
        r111.mJobsFreshnessBuckets[r54].writeSummaryFromParcelLocked(r43);
    L262:
        r54 = r54 + 1;
        goto L257
    L261:
        r43.writeInt(0);
        goto L262
    L263:
        int r55 = r111.mSensorStats.size();
        r43.writeInt(r55);
        int r56 = 0;
    L264:
        if (r56 >= r55) goto L270;
        int r213 = r55;
        r43.writeInt(r111.mSensorStats.keyAt(r56));
        Uid.Sensor r57 = r111.mSensorStats.valueAt(r56);
        int r214 = r56;
        if (r57.mTimer == null) goto L268;
        r43.writeInt(1);
        r57.mTimer.writeSummaryFromParcelLocked(r43, r5);
    L269:
        r56 = r214 + 1;
        r55 = r213;
        goto L264
    L268:
        r43.writeInt(0);
        goto L269
    L270:
        int r58 = r111.mProcessStats.size();
        r43.writeInt(r58);
        int r59 = 0;
    L271:
        if (r59 >= r58) goto L273;
        int r125 = r58;
        r43.writeString(r111.mProcessStats.keyAt(r59));
        Uid.Proc r60 = r111.mProcessStats.valueAt(r59);
        r43.writeLong(r60.mUserTimeMs);
        r43.writeLong(r60.mSystemTimeMs);
        r43.writeLong(r60.mForegroundTimeMs);
        r43.writeInt(r60.mStarts);
        r43.writeInt(r60.mNumCrashes);
        r43.writeInt(r60.mNumAnrs);
        r60.writeExcessivePowerToParcelLocked(r43);
        r59 = r59 + 1;
        r58 = r125;
        r5 = r5;
        goto L271
    L273:
        long r215 = r5;
        int r61 = r111.mPackageStats.size();
        r43.writeInt(r61);
        if (r61 <= 0) goto L287;
        Iterator<Map.Entry<String, Uid.Pkg>> r62 = r111.mPackageStats.entrySet().iterator();
    L277:
        if (r62.hasNext() == false) goto L287;
        Map.Entry<String, Uid.Pkg> r63 = r62.next();
        r43.writeString(r63.getKey());
        Uid.Pkg r64 = r63.getValue();
        int r126 = r61;
        int r65 = r64.mWakeupAlarms.size();
        r43.writeInt(r65);
        Iterator<Map.Entry<String, Uid.Pkg>> r216 = r62;
        int r66 = 0;
    L279:
        if (r66 >= r65) goto L281;
        r43.writeString(r64.mWakeupAlarms.keyAt(r66));
        r64.mWakeupAlarms.valueAt(r66).writeSummaryFromParcelLocked(r43);
        r66 = r66 + 1;
        r65 = r65;
        goto L279
    L281:
        int r127 = r64.mServiceStats.size();
        r43.writeInt(r127);
        int r67 = 0;
    L282:
        if (r67 >= r127) goto L284;
        r43.writeString(r64.mServiceStats.keyAt(r67));
        Uid.Pkg.Serv r68 = r64.mServiceStats.valueAt(r67);
        r43.writeLong(r68.getStartTimeToNowLocked(r0.mOnBatteryTimeBase.getUptime(r3) / r110));
        r43.writeInt(r68.mStarts);
        r43.writeInt(r68.mLaunches);
        r67 = r67 + 1;
        r0 = this;
        goto L282
    L284:
        r0 = this;
        r61 = r126;
        r62 = r216;
    L287:
        r41 = r41 + 1;
        r0 = this;
        r40 = r212;
        r5 = r215;
        r10 = false;
        r17 = true;
        r42 = r43;
        goto L92
    L229:
        r43.writeInt(0);
        goto L230
    L225:
        r43.writeInt(0);
        goto L227
    L221:
        r43.writeInt(0);
        goto L223
    L217:
        r43.writeInt(0);
        goto L219
    L213:
        r43.writeInt(0);
        goto L214
    L209:
        r212 = r40;
        r43.writeInt(r10 ? 1 : 0 ? 1 : 0);
        goto L210
    L183:
        r43.writeInt(r17 ? 1 : 0);
        int r69 = 0;
    L185:
        if (r69 >= 10) goto L188;
        r111.mNetworkByteActivityCounters[r69].writeSummaryFromParcelLocked(r43);
        r111.mNetworkPacketActivityCounters[r69].writeSummaryFromParcelLocked(r43);
        r69 = r69 + 1;
        goto L185
    L188:
        if (r111.mMobileRadioActiveTime == null) goto L190;
        r43.writeBoolean(r17);
        TimeMultiStateCounter.m7794$$Nest$mwriteToParcel(r111.mMobileRadioActiveTime, r43);
    L191:
        r111.mMobileRadioActiveCount.writeSummaryFromParcelLocked(r43);
        goto L192
    L190:
        r43.writeBoolean(r10);
        goto L191
    L176:
        r43.writeInt(r17 ? 1 : 0);
        int r70 = 0;
    L178:
        if (r70 >= BatteryStats.Uid.NUM_USER_ACTIVITY_TYPES) goto L181;
        r111.mUserActivityCounters[r70].writeSummaryFromParcelLocked(r43);
        r70 = r70 + 1;
        goto L178
    L172:
        r43.writeInt(r10 ? 1 : 0);
        goto L174
    L160:
        r43.writeInt(r10 ? 1 : 0);
        goto L161
    L156:
        r43.writeInt(r10 ? 1 : 0);
        goto L158
    L152:
        r43.writeInt(r10 ? 1 : 0);
        goto L154
    L148:
        r43.writeInt(r10 ? 1 : 0);
        goto L150
    L144:
        r43.writeInt(r10 ? 1 : 0);
        goto L146
    L140:
        r43.writeInt(r10 ? 1 : 0);
        goto L142
    L136:
        r43.writeInt(r10 ? 1 : 0);
        goto L138
    L132:
        r43.writeInt(r10 ? 1 : 0);
        goto L134
    L128:
        r43.writeInt(r10 ? 1 : 0);
        goto L130
    L124:
        r43.writeInt(r10 ? 1 : 0);
        goto L126
    L120:
        r43.writeInt(r10 ? 1 : 0);
        goto L122
    L116:
        r43.writeInt(r10 ? 1 : 0);
        goto L118
    L104:
        r43.writeInt(r10 ? 1 : 0);
        goto L105
    L100:
        r43.writeInt(r10 ? 1 : 0);
        goto L102
    L96:
        r43.writeInt(r10 ? 1 : 0);
        goto L98
    L289:
        return;
    L8:
        r2.writeInt(0);
        goto L9
    }

    public void commitMonotonicClock() {
        this.mMonotonicClock.write();
    }

    public void prepareForDumpLocked() {
        pullPendingStateUpdatesLocked();
        getStartClockTime();
    }

    public void dump(Context context, PrintWriter pw, int flags, int reqUid, long histStart, BatteryStats.BatteryStatsDumpHelper dumpHelper) {
        super.dump(context, pw, flags, reqUid, histStart, dumpHelper);
        monitor-enter(this);
        pw.print("Per process state tracking available: ");     // Catch: Throwable -> L7
        pw.println(trackPerProcStateCpuTimes());     // Catch: Throwable -> L7
        pw.print("Total cpu time reads: ");     // Catch: Throwable -> L7
        pw.println(this.mNumSingleUidCpuTimeReads);     // Catch: Throwable -> L7
        pw.print("Batching Duration (min): ");     // Catch: Throwable -> L7
        pw.println((this.mClock.uptimeMillis() - this.mCpuTimeReadsTrackingStartTimeMs) / 60000);     // Catch: Throwable -> L7
        pw.print("All UID cpu time reads since the later of device start or stats reset: ");     // Catch: Throwable -> L7
        pw.println(this.mNumAllUidCpuTimeReads);     // Catch: Throwable -> L7
        pw.print("UIDs removed since the later of device start or stats reset: ");     // Catch: Throwable -> L7
        pw.println(this.mNumUidsRemoved);     // Catch: Throwable -> L7
        this.mPowerStatsUidResolver.dump(pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        dumpConstantsLocked(pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        this.mCpuPowerStatsCollector.dumpCpuPowerBracketsLocked(pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        dumpEnergyConsumerStatsLocked(pw);     // Catch: Throwable -> L7
        getBSImplOptEx().dumpPowerLog(pw);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private IBatteryStatsImplOptEx getBSImplOptEx() {
        return SysMonitorSvcBridge.getFactory().getBatteryStatsImpl();
    }
}
