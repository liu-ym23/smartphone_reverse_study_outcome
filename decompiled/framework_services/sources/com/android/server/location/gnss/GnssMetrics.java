package com.android.server.location.gnss;

import android.app.StatsManager;
import android.content.Context;
import android.location.GnssStatus;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.connectivity.GpsBatteryStats;
import android.util.Base64;
import android.util.Log;
import android.util.StatsEvent;
import android.util.TimeUtils;
import com.android.internal.app.IBatteryStats;
import com.android.internal.location.nano.GnssLogsProto;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.location.LocationEventsTracker;
import com.android.server.location.gnss.hal.GnssNative;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GnssMetrics {
    private static final int CONVERT_MILLI_TO_MICRO = 1000;
    private static final int DEFAULT_TIME_BETWEEN_FIXES_MILLISECS = 1000;
    private static final double L5_CARRIER_FREQ_RANGE_HIGH_HZ = 1.189E9d;
    private static final double L5_CARRIER_FREQ_RANGE_LOW_HZ = 1.164E9d;
    private static final String TAG = "GnssMetrics";
    private static final int VENDOR_SPECIFIC_POWER_MODES_SIZE = 10;
    private boolean[] mConstellationTypes;
    private final GnssNative mGnssNative;
    GnssPowerMetrics mGnssPowerMetrics;
    long mL5SvStatusReports;
    long mL5SvStatusReportsUsedInFix;
    Statistics mL5TopFourAverageCn0DbmHzReportsStatistics;
    Statistics mLocationFailureReportsStatistics;
    private final Statistics mLocationFailureStatistics;
    private long mLogStartInElapsedRealtimeMs;
    private int mNumL5SvStatus;
    private int mNumL5SvStatusUsedInFix;
    private int mNumSvStatus;
    private int mNumSvStatusUsedInFix;
    private final Statistics mPositionAccuracyMeterStatistics;
    Statistics mPositionAccuracyMetersReportsStatistics;
    private final StatsManager mStatsManager;
    long mSvStatusReports;
    long mSvStatusReportsUsedInFix;
    Statistics mTimeToFirstFixMilliSReportsStatistics;
    private final Statistics mTimeToFirstFixSecStatistics;
    Statistics mTopFourAverageCn0DbmHzReportsStatistics;
    private final Statistics mTopFourAverageCn0Statistics;
    private final Statistics mTopFourAverageCn0StatisticsL5;

    private class GnssPowerMetrics {
        public static final double POOR_TOP_FOUR_AVG_CN0_THRESHOLD_DB_HZ = 20.0d;
        private static final double REPORTING_THRESHOLD_DB_HZ = 1.0d;
        private final IBatteryStats mBatteryStats;
        private double mLastAverageCn0;
        private int mLastSignalLevel;
        final /* synthetic */ GnssMetrics this$0;

        GnssPowerMetrics(GnssMetrics r3, IBatteryStats stats) {
            this.this$0 = r3;
            this.mBatteryStats = stats;
            this.mLastAverageCn0 = -100.0d;
            this.mLastSignalLevel = -1;
        }

        public GnssLogsProto.PowerMetrics buildProto() {
            GnssLogsProto.PowerMetrics p = new GnssLogsProto.PowerMetrics();
            GpsBatteryStats stats = this.this$0.mGnssPowerMetrics.getGpsBatteryStats();
            if (stats == null) goto L5;
            p.loggingDurationMs = stats.getLoggingDurationMs();
            p.energyConsumedMah = stats.getEnergyConsumedMaMs() / 3600000.0d;
            long[] t = stats.getTimeInGpsSignalQualityLevel();
            p.timeInSignalQualityLevelMs = new long[t.length];
            System.arraycopy(t, 0, p.timeInSignalQualityLevelMs, 0, t.length);
        L5:
            return p;
        }

        public GpsBatteryStats getGpsBatteryStats() {
            return this.mBatteryStats.getGpsBatteryStats();
        L4:
            e = move-exception;
            Log.w(GnssMetrics.TAG, e);
            return null;
        }

        public void reportSignalQuality(float[] sortedCn0DbHzs) {
            double avgCn0 = 0.0d;
            if (sortedCn0DbHzs == null) goto L12;
            if (sortedCn0DbHzs.length <= 0) goto L12;
            int i = Math.max(0, sortedCn0DbHzs.length - 4);
        L8:
            if (i >= sortedCn0DbHzs.length) goto L10;
            avgCn0 = avgCn0 + ((double) sortedCn0DbHzs[i]);
            i = i + 1;
            goto L8
        L10:
            int i2 = sortedCn0DbHzs.length;
            avgCn0 = avgCn0 / ((double) Math.min(i2, 4));
        L12:
            if (Math.abs(avgCn0 - this.mLastAverageCn0) >= REPORTING_THRESHOLD_DB_HZ) goto L14;
            return;
        L14:
            int signalLevel = getSignalLevel(avgCn0);
            if (signalLevel == this.mLastSignalLevel) goto L22;
            FrameworkStatsLog.write(69, signalLevel);
            this.mLastSignalLevel = signalLevel;
        L22:
            this.mBatteryStats.noteGpsSignalQuality(signalLevel);     // Catch: RemoteException -> L19
            SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteGpsSignalQuality(signalLevel, avgCn0);     // Catch: RemoteException -> L19
            this.mLastAverageCn0 = avgCn0;     // Catch: RemoteException -> L19
            return;
        L19:
            e = move-exception;
            Log.w(GnssMetrics.TAG, e);
        }

        private int getSignalLevel(double cn0) {
            if (cn0 <= 20.0d) goto L6;
            return 1;
        L6:
            return 0;
        }
    }

    private static class Statistics {
        private int mCount;
        private long mLongSum;
        private double mSum;
        private double mSumSquare;

        Statistics() {
        }

        public synchronized void reset() {
            monitor-enter(this);
            this.mCount = 0;     // Catch: Throwable -> L7
            this.mSum = 0.0d;     // Catch: Throwable -> L7
            this.mSumSquare = 0.0d;     // Catch: Throwable -> L7
            this.mLongSum = 0;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized void addItem(double item) {
            monitor-enter(this);
            this.mCount++;     // Catch: Throwable -> L6
            this.mSum += item;     // Catch: Throwable -> L6
            this.mSumSquare += item * item;     // Catch: Throwable -> L6
            this.mLongSum = (long) (this.mLongSum + item);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized int getCount() {
            monitor-enter(this);
            int r0 = this.mCount;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized double getMean() {
            monitor-enter(this);
            double r0 = this.mSum;     // Catch: Throwable -> L7
            double r1 = r0 / ((double) this.mCount);
            monitor-exit(this);
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized double getStandardDeviation() {
            monitor-enter(this);
            double m = this.mSum / ((double) this.mCount);     // Catch: Throwable -> L8
            double m2 = m * m;     // Catch: Throwable -> L8
            double v = this.mSumSquare / ((double) this.mCount);     // Catch: Throwable -> L8
            if (v <= m2) goto L10;
            double r4 = Math.sqrt(v - m2);     // Catch: Throwable -> L8
            monitor-exit(this);
            return r4;
        L10:
            monitor-exit(this);
            return 0.0d;
        L8:
            th = move-exception;
            throw th;
        }

        public synchronized long getLongSum() {
            monitor-enter(this);
            long r0 = this.mLongSum;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    private class StatsPullAtomCallbackImpl implements StatsManager.StatsPullAtomCallback {
        final /* synthetic */ GnssMetrics this$0;

        StatsPullAtomCallbackImpl(GnssMetrics r1) {
            this.this$0 = r1;
        }

        public int onPullAtom(int atomTag, List<StatsEvent> data) {
            switch(atomTag) {
                case 10074: goto L8;
                case 10101: goto L6;
                default: goto L4;
            };
        L4:
            throw new UnsupportedOperationException("Unknown tagId = " + atomTag);
        L6:
            return GnssMetrics.m5259$$Nest$mpullGnssPowerStats(this.this$0, atomTag, data);
        L8:
            return GnssMetrics.m5260$$Nest$mpullGnssStats(this.this$0, atomTag, data);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mpullGnssPowerStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5259$$Nest$mpullGnssPowerStats(GnssMetrics r0, int r1, List r2) {
        return r0.pullGnssPowerStats(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullGnssStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5260$$Nest$mpullGnssStats(GnssMetrics r0, int r1, List r2) {
        return r0.pullGnssStats(r1, r2);
    }

    public GnssMetrics(Context context, IBatteryStats stats, GnssNative gnssNative) {
        this.mGnssNative = gnssNative;
        this.mGnssPowerMetrics = new GnssPowerMetrics(this, stats);
        this.mLocationFailureStatistics = new Statistics();
        this.mTimeToFirstFixSecStatistics = new Statistics();
        this.mPositionAccuracyMeterStatistics = new Statistics();
        this.mTopFourAverageCn0Statistics = new Statistics();
        this.mTopFourAverageCn0StatisticsL5 = new Statistics();
        reset();
        this.mLocationFailureReportsStatistics = new Statistics();
        this.mTimeToFirstFixMilliSReportsStatistics = new Statistics();
        this.mPositionAccuracyMetersReportsStatistics = new Statistics();
        this.mTopFourAverageCn0DbmHzReportsStatistics = new Statistics();
        this.mL5TopFourAverageCn0DbmHzReportsStatistics = new Statistics();
        this.mStatsManager = (StatsManager) context.getSystemService("stats");
        registerGnssStats();
    }

    public void logReceivedLocationStatus(boolean isSuccessful) {
        if (isSuccessful == true) goto L5;
        this.mLocationFailureStatistics.addItem(1.0d);
        this.mLocationFailureReportsStatistics.addItem(1.0d);
        return;
    L5:
        this.mLocationFailureStatistics.addItem(0.0d);
        this.mLocationFailureReportsStatistics.addItem(0.0d);
    }

    public void logMissedReports(int desiredTimeBetweenFixesMilliSeconds, int actualTimeBetweenFixesMilliSeconds) {
        int numReportMissed = (actualTimeBetweenFixesMilliSeconds / Math.max(1000, desiredTimeBetweenFixesMilliSeconds)) - 1;
        if (numReportMissed <= 0) goto L7;
        LocationEventsTracker.getInstance().trackGnssPositioning(11, new long[]{System.currentTimeMillis()});
        int i = 0;
    L5:
        if (i >= numReportMissed) goto L9;
        this.mLocationFailureStatistics.addItem(1.0d);
        this.mLocationFailureReportsStatistics.addItem(1.0d);
        i = i + 1;
        goto L5
    L9:
        return;
    }

    public void logTimeToFirstFixMilliSecs(int timeToFirstFixMilliSeconds) {
        this.mTimeToFirstFixSecStatistics.addItem(((double) timeToFirstFixMilliSeconds) / 1000.0d);
        this.mTimeToFirstFixMilliSReportsStatistics.addItem(timeToFirstFixMilliSeconds);
    }

    public void logPositionAccuracyMeters(float positionAccuracyMeters) {
        this.mPositionAccuracyMeterStatistics.addItem(positionAccuracyMeters);
        this.mPositionAccuracyMetersReportsStatistics.addItem(positionAccuracyMeters);
    }

    public void logCn0(GnssStatus gnssStatus) {
        logCn0L5(gnssStatus);
        if (gnssStatus.getSatelliteCount() != 0) goto L6;
        this.mGnssPowerMetrics.reportSignalQuality(null);
        return;
    L6:
        float[] cn0DbHzs = new float[gnssStatus.getSatelliteCount()];
        int i = 0;
    L8:
        if (i >= gnssStatus.getSatelliteCount()) goto L10;
        cn0DbHzs[i] = gnssStatus.getCn0DbHz(i);
        i = i + 1;
        goto L8
    L10:
        Arrays.sort(cn0DbHzs);
        this.mGnssPowerMetrics.reportSignalQuality(cn0DbHzs);
        if (cn0DbHzs.length >= 4) goto L14;
        return;
    L14:
        if (cn0DbHzs[cn0DbHzs.length - 4] <= 0.0d) goto L23;
        double top4AvgCn0 = 0.0d;
        int i2 = cn0DbHzs.length - 4;
    L17:
        if (i2 >= cn0DbHzs.length) goto L19;
        top4AvgCn0 = top4AvgCn0 + ((double) cn0DbHzs[i2]);
        i2 = i2 + 1;
        goto L17
    L19:
        double top4AvgCn1 = top4AvgCn0 / 4.0d;
        this.mTopFourAverageCn0Statistics.addItem(top4AvgCn1);
        this.mTopFourAverageCn0DbmHzReportsStatistics.addItem(1000.0d * top4AvgCn1);
        return;
    }

    private static boolean isL5Sv(float carrierFreq) {
        if (carrierFreq >= L5_CARRIER_FREQ_RANGE_LOW_HZ) goto L5;
    L7:
        return false;
    L5:
        if (carrierFreq > L5_CARRIER_FREQ_RANGE_HIGH_HZ) goto L7;
        return true;
    }

    public void logSvStatus(GnssStatus status) {
        int i = 0;
    L4:
        if (i >= status.getSatelliteCount()) goto L17;
        if (status.hasCarrierFrequencyHz(i) == false) goto L15;
        this.mNumSvStatus++;
        this.mSvStatusReports++;
        boolean isL5 = isL5Sv(status.getCarrierFrequencyHz(i));
        if (isL5 == false) goto L11;
        this.mNumL5SvStatus++;
        this.mL5SvStatusReports++;
    L11:
        if (status.usedInFix(i) == false) goto L15;
        this.mNumSvStatusUsedInFix++;
        this.mSvStatusReportsUsedInFix++;
        if (isL5 == false) goto L15;
        this.mNumL5SvStatusUsedInFix++;
        this.mL5SvStatusReportsUsedInFix++;
    L15:
        i = i + 1;
        goto L4
    }

    private void logCn0L5(GnssStatus gnssStatus) {
        if (gnssStatus.getSatelliteCount() != 0) goto L5;
        return;
    L5:
        ArrayList<Float> l5Cn0DbHzs = new ArrayList(gnssStatus.getSatelliteCount());
        int i = 0;
    L7:
        if (i >= gnssStatus.getSatelliteCount()) goto L12;
        if (isL5Sv(gnssStatus.getCarrierFrequencyHz(i)) == false) goto L11;
        l5Cn0DbHzs.add(Float.valueOf(gnssStatus.getCn0DbHz(i)));
    L11:
        i = i + 1;
        goto L7
    L12:
        int i2 = l5Cn0DbHzs.size();
        if (i2 >= 4) goto L15;
        return;
    L15:
        Collections.sort(l5Cn0DbHzs);
        if (l5Cn0DbHzs.get(l5Cn0DbHzs.size() - 4).floatValue() <= 0.0d) goto L27;
        double top4AvgCn0 = 0.0d;
        int i3 = l5Cn0DbHzs.size() - 4;
    L19:
        if (i3 >= l5Cn0DbHzs.size()) goto L21;
        top4AvgCn0 = top4AvgCn0 + ((double) l5Cn0DbHzs.get(i3).floatValue());
        i3 = i3 + 1;
        goto L19
    L21:
        double top4AvgCn1 = top4AvgCn0 / 4.0d;
        this.mTopFourAverageCn0StatisticsL5.addItem(top4AvgCn1);
        this.mL5TopFourAverageCn0DbmHzReportsStatistics.addItem(1000.0d * top4AvgCn1);
        return;
    }

    public void logConstellationType(int constellationType) {
        if (constellationType < this.mConstellationTypes.length) goto L6;
        Log.e(TAG, "Constellation type " + constellationType + " is not valid.");
        return;
    L6:
        this.mConstellationTypes[constellationType] = true;
    }

    public String dumpGnssMetricsAsProtoString() {
        GnssLogsProto.GnssLog msg = new GnssLogsProto.GnssLog();
        if (this.mLocationFailureStatistics.getCount() <= 0) goto L6;
        msg.numLocationReportProcessed = this.mLocationFailureStatistics.getCount();
        msg.percentageLocationFailure = (int) (this.mLocationFailureStatistics.getMean() * 100.0d);
    L6:
        if (this.mTimeToFirstFixSecStatistics.getCount() <= 0) goto L9;
        msg.numTimeToFirstFixProcessed = this.mTimeToFirstFixSecStatistics.getCount();
        msg.meanTimeToFirstFixSecs = (int) this.mTimeToFirstFixSecStatistics.getMean();
        msg.standardDeviationTimeToFirstFixSecs = (int) this.mTimeToFirstFixSecStatistics.getStandardDeviation();
    L9:
        if (this.mPositionAccuracyMeterStatistics.getCount() <= 0) goto L12;
        msg.numPositionAccuracyProcessed = this.mPositionAccuracyMeterStatistics.getCount();
        msg.meanPositionAccuracyMeters = (int) this.mPositionAccuracyMeterStatistics.getMean();
        msg.standardDeviationPositionAccuracyMeters = (int) this.mPositionAccuracyMeterStatistics.getStandardDeviation();
    L12:
        if (this.mTopFourAverageCn0Statistics.getCount() <= 0) goto L15;
        msg.numTopFourAverageCn0Processed = this.mTopFourAverageCn0Statistics.getCount();
        msg.meanTopFourAverageCn0DbHz = this.mTopFourAverageCn0Statistics.getMean();
        msg.standardDeviationTopFourAverageCn0DbHz = this.mTopFourAverageCn0Statistics.getStandardDeviation();
    L15:
        if (this.mNumSvStatus <= 0) goto L18;
        msg.numSvStatusProcessed = this.mNumSvStatus;
    L18:
        if (this.mNumL5SvStatus <= 0) goto L21;
        msg.numL5SvStatusProcessed = this.mNumL5SvStatus;
    L21:
        if (this.mNumSvStatusUsedInFix <= 0) goto L24;
        msg.numSvStatusUsedInFix = this.mNumSvStatusUsedInFix;
    L24:
        if (this.mNumL5SvStatusUsedInFix <= 0) goto L27;
        msg.numL5SvStatusUsedInFix = this.mNumL5SvStatusUsedInFix;
    L27:
        if (this.mTopFourAverageCn0StatisticsL5.getCount() <= 0) goto L29;
        msg.numL5TopFourAverageCn0Processed = this.mTopFourAverageCn0StatisticsL5.getCount();
        msg.meanL5TopFourAverageCn0DbHz = this.mTopFourAverageCn0StatisticsL5.getMean();
        msg.standardDeviationL5TopFourAverageCn0DbHz = this.mTopFourAverageCn0StatisticsL5.getStandardDeviation();
    L29:
        msg.powerMetrics = this.mGnssPowerMetrics.buildProto();
        msg.hardwareRevision = SystemProperties.get("ro.boot.revision", "");
        String s = Base64.encodeToString(GnssLogsProto.GnssLog.toByteArray(msg), 0);
        reset();
        return s;
    }

    public String dumpGnssMetricsAsText() {
        StringBuilder s = new StringBuilder();
        s.append("GNSS_KPI_START");
        s.append('\n');
        s.append("  KPI logging start time: ");
        TimeUtils.formatDuration(this.mLogStartInElapsedRealtimeMs, s);
        s.append("\n");
        s.append("  KPI logging end time: ");
        TimeUtils.formatDuration(SystemClock.elapsedRealtime(), s);
        s.append("\n");
        s.append("  Number of location reports: ");
        s.append(this.mLocationFailureStatistics.getCount());
        s.append("\n");
        if (this.mLocationFailureStatistics.getCount() <= 0) goto L5;
        s.append("  Percentage location failure: ");
        s.append(this.mLocationFailureStatistics.getMean() * 100.0d);
        s.append("\n");
    L5:
        s.append("  Number of TTFF reports: ");
        s.append(this.mTimeToFirstFixSecStatistics.getCount());
        s.append("\n");
        if (this.mTimeToFirstFixSecStatistics.getCount() <= 0) goto L8;
        s.append("  TTFF mean (sec): ");
        s.append(this.mTimeToFirstFixSecStatistics.getMean());
        s.append("\n");
        s.append("  TTFF standard deviation (sec): ");
        s.append(this.mTimeToFirstFixSecStatistics.getStandardDeviation());
        s.append("\n");
    L8:
        s.append("  Number of position accuracy reports: ");
        s.append(this.mPositionAccuracyMeterStatistics.getCount());
        s.append("\n");
        if (this.mPositionAccuracyMeterStatistics.getCount() <= 0) goto L11;
        s.append("  Position accuracy mean (m): ");
        s.append(this.mPositionAccuracyMeterStatistics.getMean());
        s.append("\n");
        s.append("  Position accuracy standard deviation (m): ");
        s.append(this.mPositionAccuracyMeterStatistics.getStandardDeviation());
        s.append("\n");
    L11:
        s.append("  Number of CN0 reports: ");
        s.append(this.mTopFourAverageCn0Statistics.getCount());
        s.append("\n");
        if (this.mTopFourAverageCn0Statistics.getCount() <= 0) goto L14;
        s.append("  Top 4 Avg CN0 mean (dB-Hz): ");
        s.append(this.mTopFourAverageCn0Statistics.getMean());
        s.append("\n");
        s.append("  Top 4 Avg CN0 standard deviation (dB-Hz): ");
        s.append(this.mTopFourAverageCn0Statistics.getStandardDeviation());
        s.append("\n");
    L14:
        s.append("  Total number of sv status messages processed: ");
        s.append(this.mNumSvStatus);
        s.append("\n");
        s.append("  Total number of L5 sv status messages processed: ");
        s.append(this.mNumL5SvStatus);
        s.append("\n");
        s.append("  Total number of sv status messages processed, where sv is used in fix: ");
        s.append(this.mNumSvStatusUsedInFix);
        s.append("\n");
        s.append("  Total number of L5 sv status messages processed, where sv is used in fix: ");
        s.append(this.mNumL5SvStatusUsedInFix);
        s.append("\n");
        s.append("  Number of L5 CN0 reports: ");
        s.append(this.mTopFourAverageCn0StatisticsL5.getCount());
        s.append("\n");
        if (this.mTopFourAverageCn0StatisticsL5.getCount() <= 0) goto L17;
        s.append("  L5 Top 4 Avg CN0 mean (dB-Hz): ");
        s.append(this.mTopFourAverageCn0StatisticsL5.getMean());
        s.append("\n");
        s.append("  L5 Top 4 Avg CN0 standard deviation (dB-Hz): ");
        s.append(this.mTopFourAverageCn0StatisticsL5.getStandardDeviation());
        s.append("\n");
    L17:
        s.append("  Used-in-fix constellation types: ");
        int i = 0;
    L19:
        if (i >= this.mConstellationTypes.length) goto L24;
        if (this.mConstellationTypes[i] == false) goto L23;
        s.append(GnssStatus.constellationTypeToString(i));
        s.append(" ");
    L23:
        i = i + 1;
        goto L19
    L24:
        s.append("\n");
        s.append("GNSS_KPI_END");
        s.append("\n");
        GpsBatteryStats stats = this.mGnssPowerMetrics.getGpsBatteryStats();
        if (stats == null) goto L32;
        s.append("Power Metrics");
        s.append("\n");
        s.append("  Time on battery (min): ");
        s.append(stats.getLoggingDurationMs() / 60000.0d);
        s.append("\n");
        long[] t = stats.getTimeInGpsSignalQualityLevel();
        if (t != null) goto L29;
    L31:
        s.append("  Energy consumed while on battery (mAh): ");
        s.append(stats.getEnergyConsumedMaMs() / 3600000.0d);
        s.append("\n");
        goto L32
    L29:
        if (t.length != 2) goto L31;
        s.append("  Amount of time (while on battery) Top 4 Avg CN0 > 20.0 dB-Hz (min): ");
        s.append(t[1] / 60000.0d);
        s.append("\n");
        s.append("  Amount of time (while on battery) Top 4 Avg CN0 <= 20.0 dB-Hz (min): ");
        s.append(t[0] / 60000.0d);
        s.append("\n");
    L32:
        s.append("Hardware Version: ");
        s.append(SystemProperties.get("ro.boot.revision", ""));
        s.append("\n");
        return s.toString();
    }

    private void reset() {
        this.mLogStartInElapsedRealtimeMs = SystemClock.elapsedRealtime();
        this.mLocationFailureStatistics.reset();
        this.mTimeToFirstFixSecStatistics.reset();
        this.mPositionAccuracyMeterStatistics.reset();
        this.mTopFourAverageCn0Statistics.reset();
        resetConstellationTypes();
        this.mTopFourAverageCn0StatisticsL5.reset();
        this.mNumSvStatus = 0;
        this.mNumL5SvStatus = 0;
        this.mNumSvStatusUsedInFix = 0;
        this.mNumL5SvStatusUsedInFix = 0;
    }

    public void resetConstellationTypes() {
        this.mConstellationTypes = new boolean[8];
    }

    private void registerGnssStats() {
        StatsPullAtomCallbackImpl pullAtomCallback = new StatsPullAtomCallbackImpl(this);
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.GNSS_STATS, null, ConcurrentUtils.DIRECT_EXECUTOR, pullAtomCallback);
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.GNSS_POWER_STATS, null, ConcurrentUtils.DIRECT_EXECUTOR, pullAtomCallback);
    }

    private int pullGnssStats(int atomTag, List<StatsEvent> data) {
        data.add(FrameworkStatsLog.buildStatsEvent(atomTag, this.mLocationFailureReportsStatistics.getCount(), this.mLocationFailureReportsStatistics.getLongSum(), this.mTimeToFirstFixMilliSReportsStatistics.getCount(), this.mTimeToFirstFixMilliSReportsStatistics.getLongSum(), this.mPositionAccuracyMetersReportsStatistics.getCount(), this.mPositionAccuracyMetersReportsStatistics.getLongSum(), this.mTopFourAverageCn0DbmHzReportsStatistics.getCount(), this.mTopFourAverageCn0DbmHzReportsStatistics.getLongSum(), this.mL5TopFourAverageCn0DbmHzReportsStatistics.getCount(), this.mL5TopFourAverageCn0DbmHzReportsStatistics.getLongSum(), this.mSvStatusReports, this.mSvStatusReportsUsedInFix, this.mL5SvStatusReports, this.mL5SvStatusReportsUsedInFix));
        return 0;
    }

    private int pullGnssPowerStats(int atomTag, List<StatsEvent> data) {
        GnssPowerStats powerStats = this.mGnssNative.requestPowerStatsBlocking();
        if (powerStats != null) goto L6;
        return 1;
    L6:
        data.add(createPowerStatsEvent(atomTag, powerStats));
        return 0;
    }

    private static StatsEvent createPowerStatsEvent(int atomTag, GnssPowerStats powerStats) {
        double[] otherModesEnergyMilliJoule = new double[10];
        double[] tempGnssPowerStatsOtherModes = powerStats.getOtherModesEnergyMilliJoule();
        System.arraycopy(tempGnssPowerStatsOtherModes, 0, otherModesEnergyMilliJoule, 0, Math.min(tempGnssPowerStatsOtherModes.length, 10));
        return FrameworkStatsLog.buildStatsEvent(atomTag, (long) powerStats.getElapsedRealtimeUncertaintyNanos(), (long) (powerStats.getTotalEnergyMilliJoule() * 1000.0d), (long) (powerStats.getSinglebandTrackingModeEnergyMilliJoule() * 1000.0d), (long) (powerStats.getMultibandTrackingModeEnergyMilliJoule() * 1000.0d), (long) (powerStats.getSinglebandAcquisitionModeEnergyMilliJoule() * 1000.0d), (long) (powerStats.getMultibandAcquisitionModeEnergyMilliJoule() * 1000.0d), (long) (otherModesEnergyMilliJoule[0] * 1000.0d), (long) (otherModesEnergyMilliJoule[1] * 1000.0d), (long) (otherModesEnergyMilliJoule[2] * 1000.0d), (long) (otherModesEnergyMilliJoule[3] * 1000.0d), (long) (otherModesEnergyMilliJoule[4] * 1000.0d), (long) (otherModesEnergyMilliJoule[5] * 1000.0d), (long) (otherModesEnergyMilliJoule[6] * 1000.0d), (long) (otherModesEnergyMilliJoule[7] * 1000.0d), (long) (otherModesEnergyMilliJoule[8] * 1000.0d), (long) (otherModesEnergyMilliJoule[9] * 1000.0d));
    }
}
