package com.stepos.pps.data.stats.helper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.data.ouc.parsers.SystemTombstoneParser;
import com.stepos.pps.data.stats.helper.CrashInfo;
import com.stepos.pps.data.stats.utilities.ICollector;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.Utils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import stepos.com.android.internal.os.StatsdConfigProto;
import stepos.com.android.os.AtomsProto;
import stepos.com.android.os.StatsLog;

/* loaded from: classes.dex */
public class CrashStatsCollector implements ICollector<Integer> {
    public static final String CRASH_CONFIG_ID = "stepos_crash_metrics_config_id";
    private static final boolean ENABLE_LOG = false;
    public static final String LOG_TAG = "CrashStatsCollector";
    private static final String SYSTEM_PACKAGENAME = "android";
    private static final String SYSTEM_PROCESSNAME = "system_server";
    private Context mContext;
    private PackageManager mPackageManager;

    private static class ChangePackage {
        long mElapsedRealtime;
        long mNewVersion;
        String mPkgName;
        long mPreVersion;

        ChangePackage(long j, long j2, long j3, String str) {
            this.mPreVersion = j2;
            this.mNewVersion = j3;
            this.mElapsedRealtime = j;
            this.mPkgName = str;
        }
    }

    public CrashStatsCollector(Context context) {
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
    }

    @Override // com.stepos.pps.data.stats.utilities.ICollector
    public boolean startCollecting() {
        Log.i(LOG_TAG, String.format("Adding Crash config ( %d ) to statsd.", Integer.valueOf(CRASH_CONFIG_ID.hashCode())));
        ArrayList arrayList = new ArrayList();
        arrayList.add(78);
        arrayList.add(79);
        arrayList.add(Integer.valueOf(AtomsProto.Atom.SYSTEM_SERVER_WATCHDOG_OCCURRED_FIELD_NUMBER));
        arrayList.add(110001);
        arrayList.add(110000);
        StatsdHelper.addEventConfig(arrayList, CRASH_CONFIG_ID.hashCode());
        return true;
    }

    @Override // com.stepos.pps.data.stats.utilities.ICollector
    public Map<String, Integer> getMetrics() throws PackageManager.NameNotFoundException {
        Log.d(LOG_TAG, "crash stats getMetrics begin");
        List<CrashInfo> listBuildCrashDataFromMetric = buildCrashDataFromMetric();
        if (listBuildCrashDataFromMetric.isEmpty()) {
            Log.d(LOG_TAG, "get null crashInfo");
            return null;
        }
        Iterator<CrashInfo> it = listBuildCrashDataFromMetric.iterator();
        while (it.hasNext()) {
            onStepOSError(it.next());
        }
        Log.d(LOG_TAG, "crash stats getMetrics finish");
        return null;
    }

    @Override // com.stepos.pps.data.stats.utilities.ICollector
    public boolean stopCollecting() {
        return StatsdHelper.removeStatsConfig(CRASH_CONFIG_ID.hashCode());
    }

    public List<CrashInfo> buildCrashDataFromMetric() throws PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        StatsLog.ConfigMetricsReportList configMetricsReport = StatsdHelper.getConfigMetricsReport(CRASH_CONFIG_ID.hashCode());
        if (configMetricsReport != null) {
            for (StatsLog.ConfigMetricsReport configMetricsReport2 : configMetricsReport.getReportsList()) {
                long jNanosToMillis = nanosToMillis(configMetricsReport2.getCurrentReportWallClockNanos() - configMetricsReport2.getCurrentReportElapsedNanos());
                ArrayList<StatsLog.EventMetricData> arrayList2 = new ArrayList();
                new ArrayList();
                Iterator<StatsLog.StatsLogReport> it = configMetricsReport2.getMetricsList().iterator();
                while (it.hasNext()) {
                    arrayList2.addAll(it.next().getEventMetrics().getDataList());
                }
                for (StatsLog.EventMetricData eventMetricData : arrayList2) {
                    CrashInfo crashInfo = new CrashInfo();
                    if (eventMetricData.getAggregatedAtomInfo().getAtom().hasAppCrashOccurred()) {
                        AtomsProto.AppCrashOccurred appCrashOccurred = eventMetricData.getAggregatedAtomInfo().getAtom().getAppCrashOccurred();
                        crashInfo.eventType = appCrashOccurred.getEventType();
                        crashInfo.processName = appCrashOccurred.getProcessName();
                        if ("system_server".equals(crashInfo.processName)) {
                            crashInfo.packageName = "android";
                        } else {
                            crashInfo.packageName = appCrashOccurred.getPackageName();
                        }
                        crashInfo.pid = appCrashOccurred.getPid();
                        crashInfo.uid = appCrashOccurred.getUid();
                        crashInfo.foregroundState = appCrashOccurred.getForegroundState().toString();
                        crashInfo.errorSource = appCrashOccurred.getErrorSource();
                    } else if (eventMetricData.getAggregatedAtomInfo().getAtom().hasAnrOccurred()) {
                        AtomsProto.ANROccurred anrOccurred = eventMetricData.getAggregatedAtomInfo().getAtom().getAnrOccurred();
                        crashInfo.eventType = CrashInfo.EventType.ANR.toString().toLowerCase();
                        crashInfo.packageName = anrOccurred.getPackageName();
                        crashInfo.processName = anrOccurred.getProcessName();
                        crashInfo.uid = anrOccurred.getUid();
                        crashInfo.foregroundState = anrOccurred.getForegroundState().toString();
                        crashInfo.errorSource = anrOccurred.getErrorSource();
                        crashInfo.desc = anrOccurred.getReason();
                    } else if (eventMetricData.getAggregatedAtomInfo().getAtom().hasSystemServerWatchdogOccurred()) {
                        crashInfo.desc = eventMetricData.getAggregatedAtomInfo().getAtom().getSystemServerWatchdogOccurred().getSubject();
                        crashInfo.eventType = CrashInfo.EventType.WATCHDOG.toString().toLowerCase();
                        crashInfo.packageName = "android";
                        crashInfo.processName = "system_server";
                        crashInfo.uid = StatsdConfigProto.TimeUnit.CTS_VALUE;
                    } else if (eventMetricData.getAggregatedAtomInfo().getAtom().hasSteposSystemTombstoneOccurred()) {
                        AtomsProto.StepOSSystemTombstoneOccurred steposSystemTombstoneOccurred = eventMetricData.getAggregatedAtomInfo().getAtom().getSteposSystemTombstoneOccurred();
                        crashInfo.eventType = CrashInfo.EventType.SYSTEM_TOMBSTONE.toString().toLowerCase();
                        crashInfo.processName = steposSystemTombstoneOccurred.getProcessName();
                        crashInfo.pid = steposSystemTombstoneOccurred.getPid();
                        if (SystemTombstoneParser.includedProcesses.contains(crashInfo.processName)) {
                            crashInfo.packageName = "android";
                        } else {
                            crashInfo.packageName = crashInfo.processName;
                        }
                    } else if (eventMetricData.getAggregatedAtomInfo().getAtom().hasSteposSystemRestartOccurred()) {
                        crashInfo.eventType = CrashInfo.EventType.SYSTEM_RESTART.toString().toLowerCase();
                    } else {
                        Log.e(LOG_TAG, "UNKNOWN DATA");
                    }
                    crashInfo.currentMillis = nanosToMillis(eventMetricData.getAggregatedAtomInfo().getElapsedTimestampNanos(0)) + jNanosToMillis;
                    if (!TextUtils.equals(crashInfo.packageName, "android")) {
                        String[] versionFromChangeList = getVersionFromChangeList(configMetricsReport2, crashInfo.packageName, crashInfo.currentMillis);
                        if (versionFromChangeList[1].equals(Constants.UNKNOWN)) {
                            String[] versionFromSnapshot = getVersionFromSnapshot(configMetricsReport2, crashInfo.packageName);
                            crashInfo.packageVer = versionFromSnapshot[0];
                            crashInfo.packageVerName = versionFromSnapshot[1];
                        } else {
                            crashInfo.packageVer = versionFromChangeList[0];
                            crashInfo.packageVerName = versionFromChangeList[1];
                        }
                    } else if (this.mPackageManager != null && !TextUtils.isEmpty(crashInfo.packageName)) {
                        try {
                            PackageInfo packageInfo = this.mPackageManager.getPackageInfo(crashInfo.packageName, 0);
                            if (packageInfo != null) {
                                crashInfo.packageVer = String.valueOf(packageInfo.getLongVersionCode());
                                crashInfo.packageVerName = packageInfo.versionName;
                            }
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    arrayList.add(crashInfo);
                }
            }
        }
        return arrayList;
    }

    public void onStepOSError(CrashInfo crashInfo) {
        HashMap map = new HashMap();
        map.put("stepos_uid", Utils.getStepOSUid(this.mContext));
        map.put("prob_type", crashInfo.eventType);
        map.put("prob_time", String.valueOf(crashInfo.currentMillis));
        map.put("package_name", crashInfo.packageName);
        map.put("package_ver", crashInfo.packageVer);
        map.put("package_ver_name", crashInfo.packageVerName);
        map.put("product_model", Utils.PRODUCT_MODEL);
        map.put("build_mask", Utils.BUILD_MASK);
        map.put("foreground", crashInfo.foregroundState);
    }

    private String[] getVersionFromSnapshot(StatsLog.ConfigMetricsReport configMetricsReport, String str) {
        new HashMap();
        StatsLog.UidMapping uidMap = configMetricsReport.getUidMap();
        String[] strArr = {"-1", Constants.UNKNOWN};
        if (uidMap.getSnapshotsCount() > 0) {
            Iterator<StatsLog.UidMapping.PackageInfoSnapshot.PackageInfo> it = uidMap.getSnapshots(0).getPackageInfoList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                StatsLog.UidMapping.PackageInfoSnapshot.PackageInfo next = it.next();
                if (next.getName().equals(str)) {
                    strArr[0] = String.valueOf(next.getVersion());
                    strArr[1] = next.getVersionString();
                    break;
                }
            }
        }
        return strArr;
    }

    private String[] getVersionFromChangeList(StatsLog.ConfigMetricsReport configMetricsReport, String str, long j) {
        new HashMap();
        StatsLog.UidMapping uidMap = configMetricsReport.getUidMap();
        String[] strArr = new String[2];
        boolean z = false;
        strArr[0] = "-1";
        boolean z2 = true;
        String prevVersionString = Constants.UNKNOWN;
        strArr[1] = Constants.UNKNOWN;
        long jNanosToMillis = nanosToMillis(configMetricsReport.getCurrentReportWallClockNanos() - configMetricsReport.getCurrentReportElapsedNanos());
        long prevVersion = -1;
        long j2 = -1;
        for (StatsLog.UidMapping.Change change : uidMap.getChangesList()) {
            change.getPrevVersion();
            change.getNewVersion();
            String app = change.getApp();
            boolean z3 = z2;
            boolean z4 = z;
            long jNanosToMillis2 = nanosToMillis(change.getElapsedTimestampNanos()) + jNanosToMillis;
            if (app.equals(str)) {
                if (jNanosToMillis2 > j2 && j > jNanosToMillis2) {
                    long newVersion = change.getNewVersion();
                    prevVersionString = change.getNewVersionString();
                    j2 = jNanosToMillis2;
                    prevVersion = newVersion;
                }
                if (j2 == -1) {
                    prevVersion = change.getPrevVersion();
                    j2 = 0;
                    prevVersionString = change.getPrevVersionString();
                }
            }
            z = z4;
            z2 = z3;
        }
        strArr[z ? 1 : 0] = String.valueOf(prevVersion);
        strArr[z2 ? 1 : 0] = prevVersionString;
        return strArr;
    }

    private long nanosToMillis(long j) {
        return j / 1000000;
    }

    private String times(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }
}
