package com.stepos.alphame.userbehavior;

import B0.g;
import android.database.Cursor;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.http.HttpClient;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.awareness.AwarenessStorable;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.database.Database;
import com.stepos.alphame.predict.PredictManager;
import com.stepos.alphame.scene.QuickAppHelper;
import com.stepos.alphame.scene.SceneDetectorEngine;
import com.stepos.alphame.userbehavior.AppInfo;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.StringUtil;
import com.stepos.alphame.utils.Utils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public final class UserBehaviorDataSource extends DataSource {
    private static final byte[] ARGS_TYPE = {4, 5, 5, 5, 4, 4, 6, 6};
    private static final String DEFAULT_PKG_NAME = "unknown";
    private static final long DUPLICATE_RESUME_INTERVAL_MS = 300;
    private static final int HOURS_A_DAY = 24;
    private static final long MIN_SCREEN_OFF_TIME = 1000;
    private static final String SPLITTER_DETAIL = "|";
    private static final String SPLITTER_EQUAL = "=";
    private static final String SPLITTER_HOUR = ",";
    public static final String TAG = "userBehavior";
    private static final long TIME_JUMP_BACKWARD_TOLERANCE_MS = 60000;
    private static final long TIME_JUMP_RELOAD_THRESHOLD_MS = 300000;
    private static UserBehaviorDataSource sInstance;
    private final HashMap<String, AppInfo> mCache;
    private AppInfo mCurrApp;
    private UserBehaviorDataItem mCurrItem;
    private boolean mEnableDump;
    private final Object mInitLock;
    private boolean mInited;
    private long mLastTrustedElapsedRealtimeMs;
    private long mLastTrustedWallClockMs;
    private boolean mLoadingAll;
    private long mSaveTime;

    private UserBehaviorDataSource(String str) {
        super(str);
        this.mCache = new HashMap<>();
        this.mLoadingAll = false;
        this.mInited = false;
        this.mInitLock = new Object();
        this.mEnableDump = false;
        AlphaMeLogger.iLog(TAG, "UserBehaviorDataSource");
    }

    private long capWallClockForTrusted(long j4) {
        if (this.mLastTrustedWallClockMs <= 0) {
            return j4;
        }
        long jProjectedWallClock = projectedWallClock();
        return j4 > 300000 + jProjectedWallClock ? jProjectedWallClock : j4;
    }

    private void checkIsLastAppUsedInvalid(List<AwarenessDataItem> list, long j4) {
        AwarenessDataItem awarenessDataItem;
        boolean z4 = true;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                awarenessDataItem = null;
                break;
            }
            awarenessDataItem = list.get(size);
            if (awarenessDataItem.getScene() == 3) {
                break;
            } else {
                size--;
            }
        }
        if (awarenessDataItem != null && !TextUtils.isEmpty(awarenessDataItem.getData1()) && !SceneDetectorEngine.isScreenOff(awarenessDataItem.getData1()) && !SceneDetectorEngine.isScreenLocked(awarenessDataItem.getData1()) && j4 - awarenessDataItem.getDate() >= 60000) {
            z4 = false;
        }
        AlphaMeLogger.iLog(TAG, "last history record: " + awarenessDataItem + ", valid=" + z4);
        if (z4) {
            return;
        }
        awarenessDataItem.setData1("");
        awarenessDataItem.setData2("");
        AlphaMeLogger.iLog(TAG, "setEmpty id=" + awarenessDataItem.getId() + ", updateCount=" + AwarenessStorable.setEmpty(awarenessDataItem.getId()) + ", item=" + awarenessDataItem);
    }

    private void clampAndCoalesceAll(long j4) {
        for (AppInfo appInfo : this.mCache.values()) {
            appInfo.clampRecordsToWallClock(j4);
            appInfo.coalesceUseRecordsAfterClamp();
        }
    }

    private long computeCappedTopUsedTime(AppInfo appInfo, long j4, long j5) {
        if (SceneDetectorEngine.isScreenOff(appInfo.pkgName)) {
            return Math.min(appInfo.getTopUseTimeByScreenOff(j4, j5, new AppInfo.AppUsageInGap() { // from class: com.stepos.alphame.userbehavior.a
                @Override // com.stepos.alphame.userbehavior.AppInfo.AppUsageInGap
                public final long sumBetween(long j6, long j7) {
                    return this.f11214a.sumAppUsageBetween(j6, j7);
                }
            }), Math.max(0L, j5 - j4));
        }
        return 0L;
    }

    private synchronized AppInfo fromCache(String str) {
        AppInfo appInfo;
        if (str == null) {
            str = DEFAULT_PKG_NAME;
        }
        try {
            appInfo = this.mCache.get(str);
            if (appInfo == null) {
                appInfo = new AppInfo(str);
                this.mCache.put(str, appInfo);
            }
        } catch (Throwable th) {
            throw th;
        }
        return appInfo;
    }

    private long getBaseTimeMill(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long getDataSaveTimeMill() {
        if (Utils.DEBUG.get()) {
            return 60000L;
        }
        return VehicleBluetoothManager.FAIL_START_TIMEOUT;
    }

    public static Long getDigitalHealthClearDataTime() {
        return Long.valueOf(Property.getLong("KEY_DIGITAL_HEALTH_CLEAR_DATA_TIME", 0L));
    }

    public static UserBehaviorDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new UserBehaviorDataSource("UserBehavior");
        }
        return sInstance;
    }

    private synchronized Statistics getSimpleStatistics(boolean z4, boolean z5) {
        return getSimpleStatistics(z4, z5, false);
    }

    private long[] getTodayStatsRange(long j4) {
        long jCapWallClockForTrusted = capWallClockForTrusted(j4);
        long baseTimeMill = getBaseTimeMill(jCapWallClockForTrusted);
        long jLongValue = getDigitalHealthClearDataTime().longValue();
        if (baseTimeMill < jLongValue) {
            baseTimeMill = jLongValue;
        }
        long j5 = 86400000 + baseTimeMill;
        if (j5 <= jCapWallClockForTrusted) {
            jCapWallClockForTrusted = j5;
        }
        return new long[]{baseTimeMill, jCapWallClockForTrusted};
    }

    private synchronized boolean handleAppEventIfIsNextDay(long j4, boolean z4, boolean z5, boolean z6) {
        try {
            AlphaMeLogger.debugLog(TAG, "handleAppEventIfIsNextDay ");
            AppInfo appInfo = this.mCurrApp;
            boolean z7 = false;
            if (appInfo == null) {
                return false;
            }
            long baseTimeMill = getBaseTimeMill(appInfo.getLastStartTime());
            long baseTimeMill2 = getBaseTimeMill(j4);
            boolean z8 = baseTimeMill != baseTimeMill2;
            AlphaMeLogger.iLog(TAG, "handleAppEventIfIsNextDay curTime = " + j4 + AwarenessDataItem.PERMISSION_SPLITTER + StringUtil.formatDateFull(j4) + ", lastApp lastStartTime " + StringUtil.formatDateFull(appInfo.getLastStartTime()) + ", lastStartTimeInDate = " + StringUtil.formatDateFull(baseTimeMill) + ", curTimeInDate = " + StringUtil.formatDateFull(baseTimeMill2) + ", isNextDay=" + z8);
            if (!z8) {
                return false;
            }
            if (!SceneDetectorEngine.isScreenOff(appInfo.pkgName) && Math.abs(j4 - appInfo.getLastStartTime()) > 86400000) {
                z7 = true;
            }
            AlphaMeLogger.iLog(TAG, appInfo.pkgName + " isTimeModified=" + z7);
            long lastStartTime = (!z7 && baseTimeMill2 > baseTimeMill) ? 86400000 + baseTimeMill : appInfo.getLastStartTime();
            AlphaMeLogger.iLog(TAG, appInfo.pkgName + " endTime=" + StringUtil.formatDateFull(lastStartTime) + "save " + z4);
            appInfo.end(lastStartTime);
            if (z4) {
                saveToday(baseTimeMill, "isNextDay");
            }
            if (z7) {
                appInfo = new AppInfo("screen_off");
                this.mCurrApp = appInfo;
            }
            this.mCurrItem = new UserBehaviorDataItem();
            this.mCache.clear();
            AppInfo appInfoFromCache = fromCache(appInfo.pkgName);
            if (baseTimeMill2 >= baseTimeMill) {
                appInfoFromCache.use(baseTimeMill2);
                if (z6) {
                    appInfoFromCache.end(j4);
                }
                if (!z7 && z4) {
                    try {
                        appInfoFromCache.refresh(System.currentTimeMillis());
                        saveToday(getBaseTimeMill(j4), "isNextDay save again");
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } else {
                appInfoFromCache.use(j4);
            }
            this.mCurrApp = appInfoFromCache;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void handleAppEventInNextDay(long j4, long j5, long j6, boolean z4, boolean z5, boolean z6) {
        AppInfo appInfo = this.mCurrApp;
        if (appInfo == null) {
            return;
        }
        boolean z7 = !SceneDetectorEngine.isScreenOff(appInfo.pkgName) && Math.abs(j6 - appInfo.getLastStartTime()) > 86400000;
        AlphaMeLogger.iLog(TAG, appInfo.pkgName + " isTimeModified=" + z7);
        long lastStartTime = (!z7 && j5 > j4) ? 86400000 + j4 : appInfo.getLastStartTime();
        AlphaMeLogger.iLog(TAG, appInfo.pkgName + " endTime=" + StringUtil.formatDateFull(lastStartTime) + "save " + z4);
        appInfo.end(lastStartTime);
        if (z4) {
            saveToday(j4, "checkIsNextDay");
        }
        if (z7) {
            appInfo = new AppInfo("screen_off");
            this.mCurrApp = appInfo;
        }
        this.mCurrItem = new UserBehaviorDataItem();
        this.mCache.clear();
        AppInfo appInfoFromCache = fromCache(appInfo.pkgName);
        if (j5 >= j4) {
            appInfoFromCache.use(j5);
            if (z6) {
                appInfoFromCache.end(j6);
            }
            if (!z7 && z4) {
                try {
                    appInfoFromCache.refresh(System.currentTimeMillis());
                    saveToday(getBaseTimeMill(j6), "checkIsNextDay2");
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } else {
            appInfoFromCache.use(j6);
        }
        this.mCurrApp = appInfoFromCache;
    }

    private boolean isValidPkg(String str) {
        PredictManager predictManager = PredictManager.getInstance(ApplicationImpl.getApplication());
        return predictManager.isAppOnLauncher(str) && predictManager.isAvailable(str);
    }

    private boolean isWakeupApp(String str) {
        return SceneDetectorEngine.isScreenLocked(str) || SceneDetectorEngine.isScreenOff(str);
    }

    private void loadAllAppUsed(long j4) {
        this.mLoadingAll = true;
        this.mCurrItem = new UserBehaviorDataItem();
        this.mCurrApp = null;
        SQLiteDatabase db = Database.getInstance().getDb();
        if (db != null) {
            db.delete(UserBehaviorStorable.TABLE_NAME, (String) null, (String[]) null);
        }
        processRecord(loadAppUsed(getBaseTimeMill(j4) - 2592000000L, j4, new ArrayList(1024)), true, false);
        this.mLoadingAll = false;
        store(true);
    }

    @NonNull
    private List<AwarenessDataItem> loadAppUsed(long j4, long j5, List<AwarenessDataItem> list) {
        if (j4 >= j5) {
            return list;
        }
        int count = 0;
        try {
            Cursor cursor = AwarenessStorable.getCursor("date < ? and date > ? and scene in (?, ?)", new String[]{String.valueOf(j5), String.valueOf(j4), String.valueOf(3), String.valueOf(8)}, "date", null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        count = cursor.getCount();
                        cursor.moveToFirst();
                        do {
                            AwarenessDataItem awarenessDataItem = new AwarenessDataItem();
                            AwarenessStorable.fillItemByCursor(cursor, awarenessDataItem);
                            list.add(awarenessDataItem);
                        } while (cursor.moveToNext());
                    }
                } finally {
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("UserBehaviorDataSource init error!!", e4);
        }
        StringBuilder sbT = g.t("loadFrom count=", count, ". ");
        sbT.append(StringUtil.formatDateFull(j4));
        sbT.append("~");
        sbT.append(StringUtil.formatDateFull(j5));
        AlphaMeLogger.iLog(TAG, sbT.toString());
        return list;
    }

    private synchronized void loadTodayAppUsed(long j4, boolean z4) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long baseTimeMill = getBaseTimeMill(j4);
            this.mCurrItem = new UserBehaviorDataItem();
            this.mCache.clear();
            this.mCurrApp = null;
            ArrayList arrayList = new ArrayList(64);
            AwarenessDataItem awarenessDataItemLoadYesterdayLastAppUsed = loadYesterdayLastAppUsed(baseTimeMill);
            if (awarenessDataItemLoadYesterdayLastAppUsed != null) {
                arrayList.add(awarenessDataItemLoadYesterdayLastAppUsed);
            }
            loadAppUsed(baseTimeMill, j4, arrayList);
            if (z4) {
                checkIsLastAppUsedInvalid(arrayList, j4);
            }
            processRecord(arrayList, false, true);
            AlphaMeLogger.iLog(TAG, "loadToday complete. cost time=" + (SystemClock.uptimeMillis() - jUptimeMillis));
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.stepos.alphame.awareness.AwarenessDataItem loadYesterdayLastAppUsed(long r3) {
        /*
            r2 = this;
            r2 = 0
            java.lang.String r0 = "date < ? and scene = ?"
            r1 = 2
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Exception -> L43
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L43
            r4 = 0
            r1[r4] = r3     // Catch: java.lang.Exception -> L43
            r3 = 3
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L43
            r4 = 1
            r1[r4] = r3     // Catch: java.lang.Exception -> L43
            java.lang.String r3 = "date desc"
            java.lang.String r4 = "1"
            android.database.Cursor r3 = com.stepos.alphame.awareness.AwarenessStorable.getCursor(r0, r1, r3, r4)     // Catch: java.lang.Exception -> L43
            int r4 = r3.getCount()     // Catch: java.lang.Throwable -> L2f
            if (r4 <= 0) goto L31
            r3.moveToFirst()     // Catch: java.lang.Throwable -> L2f
            com.stepos.alphame.awareness.AwarenessDataItem r4 = new com.stepos.alphame.awareness.AwarenessDataItem     // Catch: java.lang.Throwable -> L2f
            r4.<init>()     // Catch: java.lang.Throwable -> L2f
            com.stepos.alphame.awareness.AwarenessStorable.fillItemByCursor(r3, r4)     // Catch: java.lang.Throwable -> L2f
            goto L32
        L2f:
            r4 = move-exception
            goto L38
        L31:
            r4 = r2
        L32:
            r3.close()     // Catch: java.lang.Exception -> L36
            goto L4c
        L36:
            r3 = move-exception
            goto L47
        L38:
            if (r3 == 0) goto L46
            r3.close()     // Catch: java.lang.Throwable -> L3e
            goto L46
        L3e:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch: java.lang.Exception -> L43
            goto L46
        L43:
            r3 = move-exception
            r4 = r2
            goto L47
        L46:
            throw r4     // Catch: java.lang.Exception -> L43
        L47:
            java.lang.String r0 = "loadYesterdayLastAppEvent error!!"
            com.stepos.alphame.utils.AlphaMeLogger.exceptionLog(r0, r3)
        L4c:
            if (r4 == 0) goto L56
            long r2 = r4.getDate()
            java.lang.String r2 = com.stepos.alphame.utils.StringUtil.formatDateFull(r2)
        L56:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "loadYesterdayLastAppEvent: "
            r3.<init>(r0)
            r3.append(r4)
            java.lang.String r0 = ". it last start from: "
            r3.append(r0)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "userBehavior"
            com.stepos.alphame.utils.AlphaMeLogger.iLog(r3, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.userbehavior.UserBehaviorDataSource.loadYesterdayLastAppUsed(long):com.stepos.alphame.awareness.AwarenessDataItem");
    }

    private void notifyTodayStatisticsChanged() {
        ApplicationImpl application = ApplicationImpl.getApplication();
        if (application != null) {
            UserBehaviorContentProvider.notifyTodayDataChanged(application);
        }
    }

    private void processRecord(List<AwarenessDataItem> list, boolean z4, boolean z5) {
        for (AwarenessDataItem awarenessDataItem : list) {
            if (awarenessDataItem.getScene() == 3) {
                AlphaMeLogger.iLog(TAG, "---------process record" + awarenessDataItem);
                onAppResumeEvent(awarenessDataItem.getData1(), awarenessDataItem.getDate(), z4, false, true);
            } else {
                onNotificationEvent(awarenessDataItem.getData1(), awarenessDataItem.getDate(), z4);
            }
        }
    }

    private long projectedWallClock() {
        if (this.mLastTrustedElapsedRealtimeMs <= 0) {
            return this.mLastTrustedWallClockMs;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.mLastTrustedElapsedRealtimeMs;
        return this.mLastTrustedWallClockMs + (jElapsedRealtime >= 0 ? jElapsedRealtime : 0L);
    }

    private synchronized void saveToday(long j4, String str) {
        UserBehaviorDataItem userBehaviorDataItem;
        String string;
        long j5;
        long j6;
        StringBuilder sb;
        long j7;
        int i4;
        AppInfo appInfo;
        long j8;
        long j9;
        long j10 = j4;
        synchronized (this) {
            try {
                long jUptimeMillis = SystemClock.uptimeMillis();
                AlphaMeLogger.iLog(TAG, "saveToday " + StringUtil.formatDateFull(j4) + ", for " + str);
                UserBehaviorDataItem userBehaviorDataItem2 = this.mCurrItem;
                HashMap<String, AppInfo> map = this.mCache;
                if (userBehaviorDataItem2 != null && map.size() > 0) {
                    long j11 = Property.getLong("KEY_DIGITAL_HEALTH_CLEAR_DATA_TIME", 0L);
                    AlphaMeLogger.iLog(TAG, "lastClearDigitalHealthDataTime " + j11 + AwarenessDataItem.PERMISSION_SPLITTER + StringUtil.formatDateFull(j11));
                    long j12 = 86400000 + j10;
                    userBehaviorDataItem2.date = j10;
                    userBehaviorDataItem2.totalUsedTime = 0L;
                    userBehaviorDataItem2.topUsedTime = 0L;
                    int i5 = 0;
                    userBehaviorDataItem2.notifications = 0;
                    if (j10 < j11) {
                        j10 = j11;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (j12 >= jCurrentTimeMillis) {
                        j12 = jCurrentTimeMillis;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (AppInfo appInfo2 : map.values()) {
                        userBehaviorDataItem2.notifications += appInfo2.getNotisIn(j10, j12);
                        if (SceneDetectorEngine.isScreenOff(appInfo2.pkgName)) {
                            userBehaviorDataItem2.screenOnCount = appInfo2.getValidRecordSize(new Pair<>(Long.valueOf(j10), Long.valueOf(j12)));
                            long j13 = j10;
                            sb = sb2;
                            long j14 = j12;
                            j7 = jUptimeMillis;
                            i4 = 0;
                            appInfo = appInfo2;
                            userBehaviorDataItem2.topUsedTime = Math.max(userBehaviorDataItem2.topUsedTime, computeCappedTopUsedTime(appInfo2, j13, j14));
                            j8 = j13;
                            j9 = j14;
                        } else {
                            long j15 = j10;
                            sb = sb2;
                            j7 = jUptimeMillis;
                            i4 = 0;
                            appInfo = appInfo2;
                            j8 = j15;
                            j9 = j12;
                            userBehaviorDataItem2.totalUsedTime += appInfo.getUsedTimeIn(j8, j9);
                        }
                        sb.append(appInfo.toString(j8, j9));
                        sb.append("|");
                        sb2 = sb;
                        j10 = j8;
                        j12 = j9;
                        i5 = i4;
                        jUptimeMillis = j7;
                    }
                    long j16 = jUptimeMillis;
                    int i6 = i5;
                    long j17 = j12;
                    long j18 = j10;
                    StringBuilder sb3 = sb2;
                    long j19 = userBehaviorDataItem2.topUsedTime;
                    long j20 = userBehaviorDataItem2.totalUsedTime;
                    if (j19 > j20) {
                        userBehaviorDataItem2.topUsedTime = j20;
                    }
                    if (sb3.length() > 0) {
                        sb3.deleteCharAt(sb3.length() - 1);
                    }
                    userBehaviorDataItem2.appDetails = sb3.length() > 0 ? sb3.toString() : null;
                    int i7 = 24;
                    ArrayList arrayList = new ArrayList(24);
                    int i8 = i6;
                    while (i8 < i7) {
                        HourDetail hourDetail = new HourDetail();
                        arrayList.add(hourDetail);
                        UserBehaviorDataItem userBehaviorDataItem3 = userBehaviorDataItem2;
                        long j21 = (i8 * 3600000) + j18;
                        long j22 = j21 + 3600000;
                        long j23 = j18;
                        long j24 = j22 > j17 ? j17 : j22;
                        if (j24 < j11) {
                            hourDetail.notifications = i6;
                            hourDetail.totalUsedTime = 0L;
                            hourDetail.screenOnTimes = i6;
                        } else {
                            if (j21 < j11) {
                                j21 = j11;
                            }
                            Iterator<AppInfo> it = this.mCache.values().iterator();
                            while (it.hasNext()) {
                                AppInfo next = it.next();
                                int notisIn = next.getNotisIn(j21, j24);
                                Iterator<AppInfo> it2 = it;
                                hourDetail.notifications += notisIn;
                                if (SceneDetectorEngine.isScreenOff(next.pkgName)) {
                                    j5 = j17;
                                    hourDetail.screenOnTimes = next.getValidRecordSize(new Pair<>(Long.valueOf(j21), Long.valueOf(j24)));
                                } else {
                                    j5 = j17;
                                    long usedTimeIn = next.getUsedTimeIn(j21, j24);
                                    if (usedTimeIn > 0 || notisIn > 0) {
                                        HashMap<String, HourAppInfo> map2 = hourDetail.appUseTime;
                                        String str2 = next.pkgName;
                                        j6 = j24;
                                        map2.put(str2, new HourAppInfo(str2, notisIn, usedTimeIn));
                                        hourDetail.totalUsedTime += usedTimeIn;
                                    }
                                    it = it2;
                                    j17 = j5;
                                    j24 = j6;
                                }
                                j6 = j24;
                                it = it2;
                                j17 = j5;
                                j24 = j6;
                            }
                        }
                        i8++;
                        userBehaviorDataItem2 = userBehaviorDataItem3;
                        j18 = j23;
                        j17 = j17;
                        i7 = 24;
                        i6 = 0;
                    }
                    UserBehaviorDataItem userBehaviorDataItem4 = userBehaviorDataItem2;
                    StringBuilder sb4 = new StringBuilder();
                    for (int i9 = 0; i9 < 24; i9++) {
                        sb4.append(((HourDetail) arrayList.get(i9)).toString(true));
                        sb4.append("|");
                    }
                    if (sb4.length() > 0) {
                        sb4.deleteCharAt(sb4.length() - 1);
                    }
                    if (sb4.length() > 0) {
                        string = sb4.toString();
                        userBehaviorDataItem = userBehaviorDataItem4;
                    } else {
                        userBehaviorDataItem = userBehaviorDataItem4;
                        string = null;
                    }
                    userBehaviorDataItem.hoursDetails = string;
                    if (userBehaviorDataItem.totalUsedTime <= 0 && !str.startsWith("time_changed")) {
                        AlphaMeLogger.iLog(TAG, "saveToday totalUsedTime is zero: " + userBehaviorDataItem.totalUsedTime);
                        return;
                    }
                    long j25 = this.mSaveTime;
                    this.mSaveTime = System.currentTimeMillis();
                    process(userBehaviorDataItem);
                    if (!this.mLoadingAll) {
                        store(true);
                    }
                    Log.i(TAG, "saveToday complete reason=" + str + " totalUsed=" + StringUtil.formatTimeMill(userBehaviorDataItem.totalUsedTime) + " topUsed=" + StringUtil.formatTimeMill(userBehaviorDataItem.topUsedTime));
                    AlphaMeLogger.iLog(TAG, "saveToday complete. cost time=" + (SystemClock.uptimeMillis() - j16) + ", mLoadingAll=" + this.mLoadingAll + ", sinceLastSave=" + StringUtil.formatTimeMill(this.mSaveTime - j25) + ". totalUsed=" + userBehaviorDataItem.totalUsedTime + "(" + StringUtil.formatTimeMill(userBehaviorDataItem.totalUsedTime) + "). topUsedTime=" + userBehaviorDataItem.topUsedTime + "(" + StringUtil.formatTimeMill(userBehaviorDataItem.topUsedTime) + "), screenOnCount=" + userBehaviorDataItem.screenOnCount + ", appDetail=" + userBehaviorDataItem.appDetails + ", hourDetails " + userBehaviorDataItem.hoursDetails);
                    notifyTodayStatisticsChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setDigitalHealthClearDataTime(long j4) {
        Property.setLong("KEY_DIGITAL_HEALTH_CLEAR_DATA_TIME", j4);
    }

    private void setTrustedWallClock(long j4) {
        this.mLastTrustedWallClockMs = j4;
        this.mLastTrustedElapsedRealtimeMs = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long sumAppUsageBetween(long j4, long j5) {
        long usedTimeIn = 0;
        if (j4 >= j5) {
            return 0L;
        }
        for (AppInfo appInfo : this.mCache.values()) {
            if (!SceneDetectorEngine.isScreenOff(appInfo.pkgName) && !SceneDetectorEngine.isScreenLocked(appInfo.pkgName)) {
                usedTimeIn += appInfo.getUsedTimeIn(j4, j5);
            }
        }
        return usedTimeIn;
    }

    private void updateTrustedWallClock(long j4) {
        long jCapWallClockForTrusted = capWallClockForTrusted(j4);
        if (jCapWallClockForTrusted >= this.mLastTrustedWallClockMs) {
            setTrustedWallClock(jCapWallClockForTrusted);
        }
    }

    @Override // com.stepos.alphame.data.DataSource
    public Storable createStorable() {
        AlphaMeLogger.iLog(TAG, "createUserBehaviorStorable");
        return new UserBehaviorStorable();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c5  */
    @Override // com.stepos.alphame.data.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void dump(java.io.FileDescriptor r20, java.io.PrintWriter r21, java.lang.String[] r22) {
        /*
            Method dump skipped, instructions count: 994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.userbehavior.UserBehaviorDataSource.dump(java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    public void enableDump() {
        this.mEnableDump = true;
    }

    public void ensureInitialized() {
        if (this.mInited) {
            return;
        }
        synchronized (this.mInitLock) {
            try {
                if (!this.mInited) {
                    AlphaMeLogger.iLog(TAG, "ensureInitialized: lazy init UserBehavior");
                    init(System.currentTimeMillis());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getCacheSize() {
        return this.mCache.size();
    }

    @Nullable
    public String getCurrentAppPkgName() {
        AppInfo appInfo = this.mCurrApp;
        if (appInfo != null) {
            return appInfo.pkgName;
        }
        return null;
    }

    @Override // com.stepos.alphame.data.DataSource
    public Class<? extends DataItem> getDataItemClass() {
        return UserBehaviorDataItem.class;
    }

    @Override // com.stepos.alphame.data.DataSource
    public byte[] getFillArgsType() {
        return ARGS_TYPE;
    }

    public synchronized Statistics getHoursStatistics(boolean z4) {
        long j4;
        long j5;
        long j6;
        long j7;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long[] todayStatsRange = getTodayStatsRange(jCurrentTimeMillis);
        long j8 = todayStatsRange[0];
        long j9 = todayStatsRange[1];
        Statistics simpleStatistics = getSimpleStatistics(false, false, true);
        if (simpleStatistics == null) {
            AlphaMeLogger.wLog("getHoursStatistics result is null!");
            return null;
        }
        long jLongValue = getDigitalHealthClearDataTime().longValue();
        AlphaMeLogger.iLog(TAG, "lastClearDigitalHealthDataTime " + jLongValue + AwarenessDataItem.PERMISSION_SPLITTER + StringUtil.formatDateFull(jLongValue) + " statsEnd=" + StringUtil.formatDateFull(j9));
        long baseTimeMill = getBaseTimeMill(jCurrentTimeMillis);
        ArrayList arrayList = new ArrayList(24);
        int i4 = 0;
        long j10 = 0;
        for (int i5 = 24; i4 < i5; i5 = 24) {
            HourDetail hourDetail = new HourDetail();
            arrayList.add(hourDetail);
            long j11 = (i4 * 3600000) + baseTimeMill;
            long j12 = j11 + 3600000;
            if (j11 >= j9) {
                j4 = j9;
            } else {
                if (j12 > j9) {
                    j4 = j9;
                    j5 = j4;
                } else {
                    j4 = j9;
                    j5 = j12;
                }
                if (j5 < jLongValue) {
                    hourDetail.notifications = 0;
                    hourDetail.totalUsedTime = 0L;
                    hourDetail.screenOnTimes = 0;
                } else {
                    if (j11 < jLongValue) {
                        j11 = jLongValue;
                    }
                    if (j5 > j11) {
                        Iterator<AppInfo> it = this.mCache.values().iterator();
                        while (it.hasNext()) {
                            long j13 = baseTimeMill;
                            AppInfo next = it.next();
                            int notisIn = next.getNotisIn(j11, j5);
                            Iterator<AppInfo> it2 = it;
                            hourDetail.notifications += notisIn;
                            if (SceneDetectorEngine.isScreenOff(next.pkgName)) {
                                j6 = jLongValue;
                                hourDetail.screenOnTimes = next.getValidRecordSize(new Pair<>(Long.valueOf(j11), Long.valueOf(j5)));
                            } else {
                                j6 = jLongValue;
                                long usedTimeIn = next.getUsedTimeIn(j11, j5);
                                if (usedTimeIn > 0 || notisIn > 0) {
                                    HashMap<String, HourAppInfo> map = hourDetail.appUseTime;
                                    String str = next.pkgName;
                                    j7 = j11;
                                    map.put(str, new HourAppInfo(str, notisIn, usedTimeIn));
                                    hourDetail.totalUsedTime += usedTimeIn;
                                    j10 += usedTimeIn;
                                }
                                it = it2;
                                baseTimeMill = j13;
                                jLongValue = j6;
                                j11 = j7;
                            }
                            j7 = j11;
                            it = it2;
                            baseTimeMill = j13;
                            jLongValue = j6;
                            j11 = j7;
                        }
                    }
                }
            }
            i4++;
            j9 = j4;
            baseTimeMill = baseTimeMill;
            jLongValue = jLongValue;
        }
        long j14 = j9;
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < 24; i6++) {
            sb.append(((HourDetail) arrayList.get(i6)).toString(z4));
            sb.append("|");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        simpleStatistics.appDetail = sb.length() > 0 ? sb.toString() : null;
        long j15 = j10;
        simpleStatistics.totalUsed = j15;
        if (simpleStatistics.topUseTime > j15) {
            simpleStatistics.topUseTime = j15;
        }
        Log.i(TAG, "getHoursStatistics totalUsed=" + StringUtil.formatTimeMill(simpleStatistics.totalUsed) + " topUsed=" + StringUtil.formatTimeMill(simpleStatistics.topUseTime) + " rangeStart=" + StringUtil.formatDateFull(j8) + " statsEnd=" + StringUtil.formatDateFull(j14));
        AlphaMeLogger.iLog(TAG, "getHoursStatistics. todayTotalUsed=" + simpleStatistics.totalUsed + "(" + StringUtil.formatTimeMill(simpleStatistics.totalUsed) + "), hoursTotalUsed=" + j15 + "(" + StringUtil.formatTimeMill(j15) + "), costTime=" + (SystemClock.uptimeMillis() - jUptimeMillis) + ", appDetail=" + simpleStatistics.appDetail);
        return simpleStatistics;
    }

    public synchronized Statistics getTodayStatistics(boolean z4) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        Statistics simpleStatistics = getSimpleStatistics(true, z4);
        if (simpleStatistics == null) {
            AlphaMeLogger.wLog("getTodayStatistics result is null!");
            return null;
        }
        AlphaMeLogger.iLog(TAG, "getTodayStatistics. todayTotalUsed=" + simpleStatistics.totalUsed + "(" + StringUtil.formatTimeMill(simpleStatistics.totalUsed) + "), costTime=" + (SystemClock.uptimeMillis() - jUptimeMillis) + ", appDetail=" + simpleStatistics.appDetail);
        return simpleStatistics;
    }

    public void init(long j4) {
        loadTodayAppUsed(j4, true);
        this.mInited = true;
        setTrustedWallClock(j4);
    }

    public boolean isInited() {
        return this.mInited;
    }

    public synchronized void onAppResumeEvent(String str, long j4, boolean z4, boolean z5, boolean z6) {
        String str2;
        AppInfo appInfoFromCache;
        AppInfo appInfo;
        Log.i(TAG, "onAppResumeEvent pkg=" + str + ", save=" + z4 + ", mInited=" + this.mInited);
        AlphaMeLogger.iLog(TAG, "userBehavior onAppResumeEvent. pkgName=" + str + ", save=" + z4 + ", mInited=" + this.mInited);
        if (z4 && !this.mInited) {
            AlphaMeLogger.iLog(TAG, "onAppResumeEvent ignore. pkgName=" + str + ", save=" + z4 + ", mInited=" + this.mInited);
            return;
        }
        if (!z6 && (appInfo = this.mCurrApp) != null && TextUtils.equals(str, appInfo.pkgName)) {
            long lastStartTime = j4 - this.mCurrApp.getLastStartTime();
            if (lastStartTime >= 0 && lastStartTime < DUPLICATE_RESUME_INTERVAL_MS) {
                Log.i(TAG, "onAppResumeEvent skip duplicate pkg=" + str + " sinceStart=" + lastStartTime + "ms");
                return;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCapWallClockForTrusted = capWallClockForTrusted(jCurrentTimeMillis);
        long j5 = j4 > jCurrentTimeMillis ? jCurrentTimeMillis : j4;
        long j6 = j5 > jCapWallClockForTrusted ? jCapWallClockForTrusted : j5;
        if (jCapWallClockForTrusted < jCurrentTimeMillis) {
            Log.i(TAG, "onAppResumeEvent cap event to trusted wall statsWall=" + StringUtil.formatDateFull(jCapWallClockForTrusted) + " wallNow=" + StringUtil.formatDateFull(jCurrentTimeMillis));
        }
        AlphaMeLogger.iLog(TAG, " wallNow " + jCurrentTimeMillis + " statsWall " + jCapWallClockForTrusted + " eventTime : " + j6 + " timeMill : " + j4);
        AppInfo appInfo2 = this.mCurrApp;
        if (appInfo2 != null && appInfo2.hasUseRecord()) {
            AlphaMeLogger.iLog(TAG, "save last app " + appInfo2.pkgName);
            boolean zHandleAppEventIfIsNextDay = handleAppEventIfIsNextDay(j6, z4, z5, z6);
            appInfo2.end(j6);
            Log.i(TAG, "UB_END last=" + appInfo2.pkgName + " duration=" + appInfo2.getUsedTime());
            long dataSaveTimeMill = getDataSaveTimeMill();
            AlphaMeLogger.iLog(TAG, "end last app " + appInfo2 + " isAnotherDay " + zHandleAppEventIfIsNextDay + " elapsed " + (jCurrentTimeMillis - this.mSaveTime) + " saveTime " + dataSaveTimeMill);
            if (z4 && !zHandleAppEventIfIsNextDay && Math.abs(jCurrentTimeMillis - this.mSaveTime) > dataSaveTimeMill) {
                saveToday(getBaseTimeMill(j6), "app_event");
            }
        }
        if (appInfo2 == null || !SceneDetectorEngine.isScreenOff(appInfo2.pkgName) || isWakeupApp(str)) {
            str2 = str;
        } else {
            str2 = str;
            if (!PredictManager.getInstance(ApplicationImpl.getApplication()).isHome(str2)) {
                AlphaMeLogger.iLog(TAG, "onAppResumeEvent resume when screen off : " + str2);
                return;
            }
        }
        if (TextUtils.isEmpty(str) || QuickAppHelper.isQuickApp(str) || PredictManager.isPayment(str)) {
            appInfoFromCache = null;
        } else {
            appInfoFromCache = fromCache(str);
            appInfoFromCache.use(j6);
            Log.i(TAG, "onAppResumeEvent cur app started pkg=" + str2);
            AlphaMeLogger.iLog(TAG, "onAppResumeEvent cur app " + str2 + " started");
        }
        this.mCurrApp = appInfoFromCache;
        StringBuilder sb = new StringBuilder("onAppResumeEvent mCurrApp=");
        AppInfo appInfo3 = this.mCurrApp;
        sb.append(appInfo3 != null ? appInfo3.pkgName : "null");
        sb.append(", cacheSize=");
        sb.append(this.mCache.size());
        Log.i(TAG, sb.toString());
        String timeMill = HttpClient.ENDFLAG;
        if (appInfo2 != null) {
            timeMill = StringUtil.formatTimeMill(appInfo2.getUsedTime());
        }
        String timeMill2 = HttpClient.ENDFLAG;
        if (appInfoFromCache != null) {
            timeMill2 = StringUtil.formatTimeMill(appInfoFromCache.getUsedTime());
        }
        AlphaMeLogger.iLog(TAG, "onAppResumeEvent lastApp " + appInfo2 + " useTime " + timeMill + "end , newApp " + appInfoFromCache + " start  useTime " + timeMill2);
        updateTrustedWallClock(jCurrentTimeMillis);
    }

    public void onNotificationEvent(String str, long j4, boolean z4) {
        if (!z4 || this.mInited) {
            if (z4 && this.mCurrApp != null) {
                handleAppEventIfIsNextDay(j4, z4, true, true);
            }
            fromCache(str).onNotification(j4);
        }
    }

    public void onShutdown(long j4) {
        AlphaMeLogger.debugLog(TAG, "onShutdown");
        saveToday(getBaseTimeMill(j4), "shutdown");
    }

    public void onSystemTimeChanged(long j4, String str) {
        long j5;
        ensureInitialized();
        if (!this.mInited) {
            Log.w(TAG, "onSystemTimeChanged skipped, init failed. action=" + str);
            return;
        }
        StringBuilder sbW = g.w("+++onSystemTimeChanged action=", str, " now=");
        sbW.append(StringUtil.formatDateFull(j4));
        Log.i(TAG, sbW.toString());
        AlphaMeLogger.iLog(TAG, "onSystemTimeChanged action=" + str + " now=" + StringUtil.formatDateFull(j4));
        long j6 = this.mLastTrustedWallClockMs;
        boolean z4 = j6 > 0 && j4 < j6 - 60000;
        boolean z5 = j6 > 0 && Math.abs(j4 - j6) > 300000;
        synchronized (this) {
            long j7 = (!z5 || z4 || j6 <= 0) ? j4 : j6;
            try {
                if (z4) {
                    if (z5) {
                        Log.i(TAG, "+++time_change+++ clamp backward jump=" + StringUtil.formatTimeMill(Math.abs(j4 - j6)) + " prev=" + StringUtil.formatDateFull(j6) + " now=" + StringUtil.formatDateFull(j4));
                    } else {
                        Log.i(TAG, "+++time_change+++ reload backward=true jump=" + StringUtil.formatTimeMill(Math.abs(j4 - j6)) + " prev=" + StringUtil.formatDateFull(j6));
                        loadTodayAppUsed(j4, false);
                    }
                } else if (z5) {
                    Log.i(TAG, "+++time_change+++ clamp forward jump=" + StringUtil.formatTimeMill(Math.abs(j4 - j6)) + " prev=" + StringUtil.formatDateFull(j6) + " effectiveNow=" + StringUtil.formatDateFull(j7));
                }
                clampAndCoalesceAll(j7);
                AppInfo appInfo = this.mCurrApp;
                if (appInfo == null || !appInfo.hasUseRecord()) {
                    j5 = j7;
                } else {
                    handleAppEventIfIsNextDay(j7, true, true, false);
                    j5 = j7;
                    appInfo.end(j5);
                }
                if (this.mCache.size() > 0) {
                    saveToday(getBaseTimeMill(j5), "time_changed_" + str);
                }
                if (z5 && !z4) {
                    this.mCurrApp = null;
                    AlphaMeLogger.iLog(TAG, "time_change rebase trustedWallClock to now, drop curApp. prev=" + StringUtil.formatDateFull(j6) + ", now=" + StringUtil.formatDateFull(j4));
                }
                setTrustedWallClock(j4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized Statistics getSimpleStatistics(boolean z4, boolean z5, boolean z6) {
        long j4;
        StringBuilder sb;
        long j5;
        StringBuilder sb2;
        try {
            if (!this.mInited) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jCapWallClockForTrusted = capWallClockForTrusted(jCurrentTimeMillis);
            long[] todayStatsRange = getTodayStatsRange(jCurrentTimeMillis);
            long j6 = todayStatsRange[0];
            long j7 = todayStatsRange[1];
            if (z6) {
                j4 = j7;
            } else {
                AppInfo appInfo = this.mCurrApp;
                if (appInfo == null || (SceneDetectorEngine.isScreenOff(appInfo.pkgName) && getBaseTimeMill(appInfo.getLastStartTime()) == getBaseTimeMill(jCurrentTimeMillis))) {
                    j4 = j7;
                } else {
                    j4 = j7;
                    handleAppEventIfIsNextDay(jCapWallClockForTrusted, true, true, false);
                    appInfo.refresh(jCapWallClockForTrusted);
                }
                updateTrustedWallClock(jCurrentTimeMillis);
            }
            Statistics statistics = new Statistics();
            statistics.totalUsed = 0L;
            statistics.topUseTime = 0L;
            StringBuilder sb3 = new StringBuilder();
            for (AppInfo appInfo2 : this.mCache.values()) {
                long j8 = j4;
                statistics.notifications += appInfo2.getNotisIn(j6, j8);
                if (SceneDetectorEngine.isScreenOff(appInfo2.pkgName)) {
                    statistics.screenOnTimes = appInfo2.getValidRecordSize(new Pair<>(Long.valueOf(j6), Long.valueOf(j8)));
                    sb = sb3;
                    statistics.topUseTime = Math.max(statistics.topUseTime, computeCappedTopUsedTime(appInfo2, j6, j8));
                    j5 = j8;
                } else {
                    sb = sb3;
                    j5 = j8;
                    statistics.totalUsed += appInfo2.getUsedTimeIn(j6, j5);
                }
                if (!z4 || (z5 && !isValidPkg(appInfo2.pkgName))) {
                    sb2 = sb;
                } else {
                    sb2 = sb;
                    sb2.append(appInfo2.toString(j6, j5));
                    sb2.append("|");
                }
                sb3 = sb2;
                j4 = j5;
            }
            StringBuilder sb4 = sb3;
            long j9 = statistics.topUseTime;
            long j10 = statistics.totalUsed;
            if (j9 > j10) {
                statistics.topUseTime = j10;
            }
            if (sb4.length() > 0) {
                sb4.deleteCharAt(sb4.length() - 1);
            }
            statistics.appDetail = sb4.length() > 0 ? sb4.toString() : null;
            return statistics;
        } catch (Throwable th) {
            throw th;
        }
    }
}
