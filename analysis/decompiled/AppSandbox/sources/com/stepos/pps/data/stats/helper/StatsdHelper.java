package com.stepos.pps.data.stats.helper;

import android.app.PendingIntent;
import android.os.Handler;
import android.util.Log;
import com.stepos.pps.PPSApplication;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import stepos.com.android.internal.os.StatsdConfigProto;
import stepos.com.android.os.StatsLog;

/* loaded from: classes.dex */
public class StatsdHelper {
    public static final int BATTERY_TRIGGER_ID = 2;
    public static StatsdConfigProto.TimeUnit BUCKET_ONE_DAY = null;
    public static StatsdConfigProto.TimeUnit BUCKET_ONE_HOUR = null;
    public static final int GRAPHICS_TRIGGER_ID = 4;
    private static final Handler H;
    private static final long MAX_ATOMS = 2000;
    private static final long METRIC_DELAY_MS = 3000;
    public static final int MOBILE_TRIGGER_ID = 3;
    private static final String STATSEVENT_BUILDER_CLASS = "android.util.StatsEvent$Builder";
    private static final String STATSEVENT_CLASS = "android.util.StatsEvent";
    private static final String STATSLOG_CLASS = "android.util.StatsLog";
    private static final String STATSMANAGER_CLASS = "android.app.StatsManager";
    private static final String TAG = "StatsdHelper";
    public static final HashMap<String, StatsdConfigProto.TimeUnit> TIME_MAPS;
    private static Method sAddConfigFunc = null;
    private static Method sGetReportsFunc = null;
    private static Method sGetStatsMetadata = null;
    private static boolean sIsLoaded = false;
    private static Method sRemoveConfigFunc;
    private static Method sSetActiveConfigsChangedOperation;
    private static Method sSetBroadcastSubscriberFunc;
    private static Method sSetFetchReportsOperation;
    private static Class<?> sStatsClass;
    public static Method sStatsEventBuilderBuildFunc;
    public static Class<?> sStatsEventBuilderClass;
    public static Method sStatsEventBuilderSetAtomIdFunc;
    public static Method sStatsEventBuilderWriteIntFunc;
    public static Method sStatsEventBuilderWriteStingFunc;
    public static Class<?> sStatsEventCalss;
    public static Method sStatsEventNewBuilderFunc;
    public static Class<?> sStatsLogCalss;
    private static Object sStatsManager;
    public static Method sStatsWriteFunc;

    static {
        HashMap<String, StatsdConfigProto.TimeUnit> map = new HashMap<>();
        TIME_MAPS = map;
        map.put("ONE_HOUR", StatsdConfigProto.TimeUnit.ONE_HOUR);
        map.put("ONE_MINUTE", StatsdConfigProto.TimeUnit.ONE_MINUTE);
        map.put("TEN_MINUTES", StatsdConfigProto.TimeUnit.TEN_MINUTES);
        map.put("FIVE_MINUTES", StatsdConfigProto.TimeUnit.FIVE_MINUTES);
        map.put("THREE_HOURS", StatsdConfigProto.TimeUnit.THREE_HOURS);
        map.put("SIX_HOURS", StatsdConfigProto.TimeUnit.SIX_HOURS);
        map.put("ONE_DAY", StatsdConfigProto.TimeUnit.ONE_DAY);
        BUCKET_ONE_DAY = map.get("FIVE_MINUTES");
        BUCKET_ONE_HOUR = map.get("FIVE_MINUTES");
        try {
            sStatsClass = Class.forName(STATSMANAGER_CLASS);
            sAddConfigFunc = sStatsClass.getMethod("addConfig", Long.TYPE, byte[].class);
            sRemoveConfigFunc = sStatsClass.getMethod("removeConfig", Long.TYPE);
            sSetBroadcastSubscriberFunc = sStatsClass.getMethod("setBroadcastSubscriber", PendingIntent.class, Long.TYPE, Long.TYPE);
            sSetFetchReportsOperation = sStatsClass.getMethod("setFetchReportsOperation", PendingIntent.class, Long.TYPE);
            sSetActiveConfigsChangedOperation = sStatsClass.getMethod("setActiveConfigsChangedOperation", PendingIntent.class);
            sGetReportsFunc = sStatsClass.getMethod("getReports", Long.TYPE);
            Class[] clsArr = new Class[0];
            sGetStatsMetadata = sStatsClass.getMethod("getStatsMetadata", null);
            Class<?> cls = Class.forName(STATSEVENT_CLASS);
            sStatsEventCalss = cls;
            Class[] clsArr2 = new Class[0];
            sStatsEventNewBuilderFunc = cls.getMethod("newBuilder", null);
            sStatsEventBuilderClass = Class.forName(STATSEVENT_BUILDER_CLASS);
            sStatsEventBuilderSetAtomIdFunc = sStatsEventBuilderClass.getMethod("setAtomId", Integer.TYPE);
            sStatsEventBuilderWriteIntFunc = sStatsEventBuilderClass.getMethod("writeInt", Integer.TYPE);
            sStatsEventBuilderWriteStingFunc = sStatsEventBuilderClass.getMethod("writeString", String.class);
            Class[] clsArr3 = new Class[0];
            sStatsEventBuilderBuildFunc = sStatsEventBuilderClass.getMethod("build", null);
            Class<?> cls2 = Class.forName(STATSLOG_CLASS);
            sStatsLogCalss = cls2;
            sStatsWriteFunc = cls2.getMethod("write", sStatsEventCalss);
            sIsLoaded = true;
        } catch (Exception e) {
            Log.e(TAG, "initFunctions() : Exception_1 = " + e);
        }
        H = new Handler();
    }

    public static boolean addEventConfig(List<Integer> list, long j) {
        StatsdConfigProto.StatsdConfig.Builder simpleSources = getSimpleSources(j);
        Log.d(CrashStatsCollector.LOG_TAG, "addEventConfig from : " + j);
        for (Integer num : list) {
            int iIntValue = num.intValue() + "atom".hashCode();
            simpleSources.addEventMetric(StatsdConfigProto.EventMetric.newBuilder().setId(num.intValue() + "event".hashCode()).setWhat(iIntValue)).addAtomMatcher(getSimpleAtomMatcher(iIntValue, num.intValue()));
        }
        simpleSources.setHashStringsInMetricReport(false);
        simpleSources.setVersionStringsInMetricReport(true);
        try {
            addConfig(j, simpleSources.build().toByteArray());
            Log.i(TAG, "Successfully added config with config-id:" + j);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Not able to setup the event config.", e);
            return false;
        }
    }

    public static StatsdConfigProto.AtomMatcher.Builder getSimpleAtomMatcher(int i, int i2) {
        return StatsdConfigProto.AtomMatcher.newBuilder().setId(i).setSimpleAtomMatcher(StatsdConfigProto.SimpleAtomMatcher.newBuilder().setAtomId(i2));
    }

    public static StatsdConfigProto.StatsdConfig.Builder getSimpleSources(long j) {
        return StatsdConfigProto.StatsdConfig.newBuilder().setId(j).addAllowedLogSource("AID_ROOT").addAllowedLogSource("AID_SYSTEM").addAllowedLogSource("AID_RADIO").addAllowedLogSource("AID_BLUETOOTH").addAllowedLogSource("AID_GRAPHICS").addAllowedLogSource("AID_STATSD").addAllowedLogSource("AID_INCIENTD").addAllowedLogSource("com.android.systemui").addAllowedLogSource("com.stepos.launcher").addAllowedLogSource("com.stepos.ems").addDefaultPullPackages("AID_RADIO").addDefaultPullPackages("AID_SYSTEM").addAllowedLogSource("com.stepos.pps");
    }

    public static List<StatsLog.EventMetricData> getEventMetrics(long j) {
        StatsLog.ConfigMetricsReportList from;
        ArrayList arrayList = new ArrayList();
        if (j != -1) {
            try {
                Log.d(CrashStatsCollector.LOG_TAG, "getEventMetric from : " + j);
                from = StatsLog.ConfigMetricsReportList.parser().parseFrom(getReports(j));
            } catch (Exception e) {
                Log.e(TAG, "Retreiving event metrics failed.", e);
                return arrayList;
            }
        } else {
            from = null;
        }
        if (from != null) {
            Iterator<StatsLog.StatsLogReport> it = from.getReports(0).getMetricsList().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getEventMetrics().getDataList());
            }
        }
        if (from != null) {
            for (StatsLog.ConfigMetricsReport configMetricsReport : from.getReportsList()) {
                for (String str : configMetricsReport.getStringsList()) {
                    Log.d(CrashStatsCollector.LOG_TAG, "pkgname is " + str + ", hashcode is " + str.hashCode());
                }
                if (configMetricsReport.hasUidMap()) {
                    StatsLog.UidMapping uidMap = configMetricsReport.getUidMap();
                    int changesCount = uidMap.getChangesCount();
                    int snapshotsCount = uidMap.getSnapshotsCount();
                    Log.i("CrashStatsReporter", "uidMapping：\u3000changeCount is " + changesCount + ",snapshotCount is " + snapshotsCount);
                    long j2 = 1000000;
                    if (snapshotsCount > 0) {
                        for (StatsLog.UidMapping.PackageInfoSnapshot packageInfoSnapshot : uidMap.getSnapshotsList()) {
                            long elapsedTimestampNanos = packageInfoSnapshot.getElapsedTimestampNanos() / j2;
                            if (packageInfoSnapshot.getPackageInfoCount() > 0) {
                                List<StatsLog.UidMapping.PackageInfoSnapshot.PackageInfo> packageInfoList = packageInfoSnapshot.getPackageInfoList();
                                Log.i("CrashStatsReporter", "packageinfoList has pkginfo count: " + packageInfoList.size());
                                for (StatsLog.UidMapping.PackageInfoSnapshot.PackageInfo packageInfo : packageInfoList) {
                                    Log.i("CrashStatsReporter", "packageInfo: " + packageInfo.getUid() + ", " + packageInfo.getVersion() + ",  name " + packageInfo.getName() + "  " + packageInfo.getNameHash() + ", time is " + elapsedTimestampNanos);
                                    j2 = j2;
                                }
                            }
                            j2 = j2;
                        }
                    }
                    long j3 = j2;
                    if (changesCount > 0) {
                        for (StatsLog.UidMapping.Change change : uidMap.getChangesList()) {
                            Log.d("CrashStatsReporter", "change: " + change.getPrevVersion() + ", " + change.getNewVersion() + ", " + change.getUid() + ", " + change.getApp() + (change.getElapsedTimestampNanos() / j3));
                        }
                    }
                }
            }
        }
        Log.i(CrashStatsCollector.LOG_TAG, "----Number of events: " + arrayList.size());
        return arrayList;
    }

    public static boolean removeStatsConfig(long j) {
        Log.i(TAG, "Removing statsd config-id: " + j);
        try {
            removeConfig(j);
            Log.i(TAG, "Successfully removed config-id: " + j);
            return true;
        } catch (Exception e) {
            Log.e(TAG, String.format("Not able to remove the config-id: %d due to %s ", Long.valueOf(j), e.getMessage()));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getStatsManager() {
        if (sStatsManager == null) {
            sStatsManager = PPSApplication.getInstance().getSystemService("stats");
        }
        return sStatsManager;
    }

    public static void addConfig(final long j, final byte[] bArr) {
        H.post(new Runnable() { // from class: com.stepos.pps.data.stats.helper.StatsdHelper.1
            int gapSec = 30;

            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                try {
                    if (StatsdHelper.sAddConfigFunc != null) {
                        StatsdHelper.sAddConfigFunc.invoke(StatsdHelper.getStatsManager(), Long.valueOf(j), bArr);
                    }
                } catch (Exception e) {
                    Log.e(StatsdHelper.TAG, "addConfig() : Exception = " + e);
                    if (this.gapSec < 300) {
                        StatsdHelper.H.postDelayed(this, this.gapSec * StatsdConfigProto.TimeUnit.CTS_VALUE);
                        int i = this.gapSec;
                        this.gapSec = i + i;
                    }
                }
            }
        });
    }

    public static void removeConfig(long j) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = sRemoveConfigFunc;
            if (method != null) {
                method.invoke(getStatsManager(), Long.valueOf(j));
            }
        } catch (Exception e) {
            Log.e(TAG, "removeConfig() : Exception = " + e);
        }
    }

    public static void setBroadcastSubscriber(PendingIntent pendingIntent, long j, long j2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = sSetBroadcastSubscriberFunc;
            if (method != null) {
                method.invoke(getStatsManager(), pendingIntent, Long.valueOf(j), Long.valueOf(j2));
            }
        } catch (Exception e) {
            Log.e(TAG, "setBroadcastSubscriber() : Exception = " + e);
        }
    }

    public static void setFetchReportsOperation(PendingIntent pendingIntent, long j) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = sSetFetchReportsOperation;
            if (method != null) {
                method.invoke(getStatsManager(), pendingIntent, Long.valueOf(j));
            }
        } catch (Exception e) {
            Log.e(TAG, "setFetchReportsOperation() : Exception = " + e);
        }
    }

    public static long[] setActiveConfigsChangedOperation(PendingIntent pendingIntent) {
        try {
            Method method = sSetActiveConfigsChangedOperation;
            if (method != null) {
                return (long[]) method.invoke(getStatsManager(), pendingIntent);
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "setActiveConfigsChangedOperation() : Exception = " + e);
            return null;
        }
    }

    public static byte[] getReports(long j) {
        try {
            Method method = sGetReportsFunc;
            if (method != null) {
                return (byte[]) method.invoke(getStatsManager(), Long.valueOf(j));
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "getReports() : Exception = " + e);
            return null;
        }
    }

    public static byte[] getStatsMetadata() {
        try {
            Method method = sGetStatsMetadata;
            if (method != null) {
                return (byte[]) method.invoke(getStatsManager(), null);
            }
        } catch (Exception e) {
            Log.e(TAG, "getStatsMetadata() : Exception = " + e);
        }
        return null;
    }

    public static String getPackageName(int i) {
        String nameForUid = PPSApplication.getInstance().getPackageManager().getNameForUid(i);
        return nameForUid != null ? nameForUid.split(String.format("\\:%d", Integer.valueOf(i)))[0] : nameForUid;
    }

    public static int getUniqueId() {
        return UUID.randomUUID().hashCode();
    }

    public static boolean verifyValidConfigExists(long j) {
        StatsLog.StatsdStatsReport from;
        try {
            from = StatsLog.StatsdStatsReport.parser().parseFrom(getStatsMetadata());
        } catch (Exception e) {
            Log.e(TAG, "getMetadata failed", e);
            from = null;
        }
        if (from == null) {
            return false;
        }
        for (StatsLog.StatsdStatsReport.ConfigStats configStats : from.getConfigStatsList()) {
            if (configStats.getId() == j && configStats.getIsValid() && configStats.getDeletionTimeSec() == 0) {
                return true;
            }
        }
        return false;
    }

    public static StatsLog.ConfigMetricsReportList getConfigMetricsReport(int i) {
        if (i == -1) {
            return null;
        }
        try {
            Log.d(CrashStatsCollector.LOG_TAG, "getEventMetric from : " + i);
            return StatsLog.ConfigMetricsReportList.parser().parseFrom(getReports(i));
        } catch (Exception e) {
            Log.e(TAG, "Retreiving event metrics failed.", e);
            return null;
        }
    }

    public static void printLongStr(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 2000;
        int i3 = 0;
        while (i < 100) {
            if (length > i2) {
                Log.e(TAG, str.substring(i3, i2));
                i++;
                i3 = i2;
                i2 += 2000;
            } else {
                Log.e(TAG, str.substring(i3, length));
                return;
            }
        }
    }
}
