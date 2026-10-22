package com.stepos.alphame.appinfo;

import B0.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.RuleUpdater;
import com.stepos.alphame.scene.AppInstallReceiver;
import com.stepos.alphame.scene.SceneDetectorEngine;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.AppUtils;
import com.stepos.alphame.utils.FileUtil;
import com.stepos.alphame.utils.HttpRequestHelper;
import com.stepos.alphame.utils.NetworkHelper;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.ReceiverUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.sourceforge.jeval.EvaluationConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppInfoRuleUpdater {
    private static final List<Integer> BUSY_HOURS = Arrays.asList(6, 7, 8, 9);
    private static final List<Integer> BUSY_MINUTES = Arrays.asList(0, 1, 2, 28, 29, 30, 31, 32, 58, 59);
    private static final int CODE_SUCCESS = 200;
    private static final boolean DEBUG = true;
    private static final long FAILED_RETRY_DELTA = 7200000;
    private static final int MSG_APP_INSTALLED = 0;
    private static final int MSG_NETWORK_ENABLED = 1;
    static String PARAM_APP_LIST = "apps";
    static String PARAM_IMEI = "imei";
    static String PARAM_SIGN = "sign";
    private static final int RETRY_MAX = 2;
    private static final String TAG_CODE = "code";
    private static final String TAG_MISMATCHES = "mismatches";
    private static final String TAG_PERMISSIONS = "permissions";
    private static final String TAG_VALUE = "value";
    private static AppInfoRuleUpdater _instance = null;
    private static final String appInfoByPkgUrl = "https://onemind.zyql.com/service/app/getByPkg";
    private static final String appInfoUrl = "https://onemind.zyql.com/service/app/get";
    UpdateNewlyHandler mUpdateNewlyHandler;
    private final AtomicBoolean isUpdating = new AtomicBoolean(false);
    private final AtomicInteger retryCnt = new AtomicInteger(0);
    private List<String> mNewInstalledApp = new ArrayList();
    private AppInstallReceiver.OnAppInsatllChangeListener mAppInstallListener = new AppInstallReceiver.OnAppInsatllChangeListener() { // from class: com.stepos.alphame.appinfo.AppInfoRuleUpdater.2
        @Override // com.stepos.alphame.scene.AppInstallReceiver.OnAppInsatllChangeListener
        public void onChanged(String str, int i4, int i5) {
            if (i4 == 0 && i5 == 0) {
                AlphaMeLogger.dLog("RuleUpdater AppInstallReceiver.ACTION_ADDED " + str);
                UpdateNewlyHandler updateNewlyHandler = AppInfoRuleUpdater.this.mUpdateNewlyHandler;
                updateNewlyHandler.sendMessage(updateNewlyHandler.obtainMessage(0, str));
            }
        }
    };
    private boolean mWaitingUpdateNewlyApp = false;
    BroadcastReceiver mNetWorkChangReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.appinfo.AppInfoRuleUpdater.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            UpdateNewlyHandler updateNewlyHandler = AppInfoRuleUpdater.this.mUpdateNewlyHandler;
            updateNewlyHandler.sendMessage(updateNewlyHandler.obtainMessage(1, null));
        }
    };

    public class UpdateNewlyHandler extends Handler {
        public UpdateNewlyHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            ApplicationImpl application = ApplicationImpl.getApplication();
            int i4 = message.what;
            if (i4 != 0) {
                if (i4 != 1) {
                    return;
                }
                AlphaMeLogger.dLog("UpdateNewlyHandler MSG_NETWORK_ENABLED");
                if (NetworkHelper.isConnectionAvailable(application)) {
                    AppInfoRuleUpdater.this.onAppInstalled(application);
                    return;
                }
                return;
            }
            AlphaMeLogger.dLog("UpdateNewlyHandler MSG_APP_INSTALLED");
            String str = (String) message.obj;
            if (SceneDetectorEngine.getInstance().isAppInDB(str)) {
                AlphaMeLogger.dLog("RuleUpdater " + str + " in db");
                return;
            }
            AlphaMeLogger.dLog("RuleUpdater AppInstallReceiver run not in db, app not cached");
            AppInfoRuleUpdater.this.mNewInstalledApp.add(str);
            if (!NetworkHelper.isConnectionAvailable(application)) {
                AppInfoRuleUpdater.this.waitNetwordEnabled(application);
            } else {
                AlphaMeLogger.dLog("RuleUpdater OnAppInsatllChangeListener onAppInstalled");
                AppInfoRuleUpdater.this.onAppInstalled(application);
            }
        }
    }

    private AppInfoRuleUpdater() {
        AlphaMeLogger.iLog("constructor : " + this);
        AppInstallReceiver.addListener(this.mAppInstallListener);
        this.mUpdateNewlyHandler = new UpdateNewlyHandler(ApplicationImpl.getAlphaMeLooper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String doApksQuery(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.appinfo.AppInfoRuleUpdater.doApksQuery(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean doFullUpdate(String str) throws Throwable {
        FileInputStream fileInputStream;
        int i4;
        StringBuilder sb = new StringBuilder();
        String str2 = AppInfoDbHelper.DATABASE_PATH;
        String strR = g.r(sb, str2, "update/newupdate.zip");
        File file = new File(AbstractC0351g.p(str2, "update/"));
        if (!file.exists()) {
            file.mkdir();
        }
        boolean z4 = false;
        if (HttpRequestHelper.downloadFile(str, strR)) {
            AppInfoDbHelper appInfoDbHelper = AppInfoDbHelper.getInstance();
            SQLiteDatabase writableDatabase = appInfoDbHelper.getWritableDatabase();
            writableDatabase.beginTransaction();
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    FileUtil.unzipFile(strR, str2 + "update/");
                    fileInputStream = new FileInputStream(new File(str2 + "update/newupdate.db"));
                    try {
                        try {
                            appInfoDbHelper.clearAppInfo(writableDatabase);
                            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            AlphaMeLogger.iLog("#app#update#begin ");
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                JSONObject jSONObject = new JSONObject(line);
                                String string = jSONObject.getString(AppInfoDbHelper.TAG_PACKAGE_NAME);
                                try {
                                    i4 = Integer.parseInt(jSONObject.getString("permissionValue"));
                                } catch (Exception e4) {
                                    AlphaMeLogger.exceptionLog("Exception", e4);
                                    i4 = -1;
                                }
                                appInfoDbHelper.insert(writableDatabase, string, jSONObject.getLong("permissionId"), i4, false);
                            }
                            z4 = true;
                            inputStreamReader.close();
                            bufferedReader.close();
                            writableDatabase.setTransactionSuccessful();
                            AlphaMeLogger.iLog("#app#update#end");
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e5) {
                                    AlphaMeLogger.exceptionLog("IOException", e5);
                                }
                            }
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        fileInputStream2 = fileInputStream;
                        AlphaMeLogger.exceptionLog("UPDATEException", e);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e7) {
                                e = e7;
                                AlphaMeLogger.exceptionLog("IOException", e);
                                writableDatabase.endTransaction();
                                return z4;
                            }
                        }
                        writableDatabase.endTransaction();
                        return z4;
                    }
                } catch (Exception e8) {
                    e = e8;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e9) {
                    e = e9;
                    AlphaMeLogger.exceptionLog("IOException", e);
                    writableDatabase.endTransaction();
                    return z4;
                }
                writableDatabase.endTransaction();
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            AlphaMeLogger.wLog("full update download failed");
        }
        return z4;
    }

    public static synchronized void freeInstance() {
        AlphaMeLogger.iLog("freeInstance : " + _instance);
        _instance = null;
    }

    public static void fullUpdate(Context context, String str, String str2) {
        if (!doFullUpdate(str2)) {
            AlphaMeLogger.wLog("fullUpdate fail");
        } else {
            Property.setLastFullUpdateTime(str, System.currentTimeMillis());
            AlphaMeLogger.iLog("fullUpdate success");
        }
    }

    public static synchronized AppInfoRuleUpdater getInstance() {
        try {
            if (_instance == null) {
                _instance = new AppInfoRuleUpdater();
            }
        } catch (Throwable th) {
            throw th;
        }
        return _instance;
    }

    @NonNull
    private static String getKey() {
        return new String(new char[]{'s', 'a', 'f', CoreConstants.DOT, 'C', 'T', 'R', EvaluationConstants.POUND_SIGN, '2', '1', '4', 'm', 'z'});
    }

    @NonNull
    private String getPkgsAndNameJsonArray(List<ResolveInfo> list, JSONArray jSONArray) {
        StringBuilder sb = new StringBuilder();
        if (list == null || jSONArray == null || jSONArray.length() == 0) {
            return sb.toString();
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                arrayList.add(jSONArray.getString(i4));
            } catch (JSONException e4) {
                AlphaMeLogger.exceptionLog("getPkgsAndNameJsonArray error!!", e4);
                return sb.toString();
            }
        }
        PackageManager packageManager = ApplicationImpl.getApplication().getPackageManager();
        sb.append("[");
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (list.get(i5) != null && list.get(i5).activityInfo != null && arrayList.contains(list.get(i5).activityInfo.packageName)) {
                sb.append("{\"name\":\"");
                sb.append(list.get(i5).loadLabel(packageManager));
                sb.append("\",\"pkg\":\"");
                sb.append(list.get(i5).activityInfo.packageName);
                sb.append("\"},");
            }
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "]");
        } else {
            sb.append("]");
        }
        return sb.toString();
    }

    @NonNull
    private String getPkgsJsonArray(List<ResolveInfo> list) {
        StringBuilder sb = new StringBuilder();
        if (list == null) {
            return sb.toString();
        }
        sb.append("[");
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4) != null && list.get(i4).activityInfo != null) {
                sb.append("\"");
                sb.append(list.get(i4).activityInfo.packageName);
                sb.append("\",");
            }
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "]");
        } else {
            sb.append("]");
        }
        return sb.toString();
    }

    private static int insertAppInfo(List<ResolveInfo> list, String str) {
        String str2;
        int i4;
        String str3 = "permissionValue";
        AlphaMeLogger.dLog("insertAppInfo ");
        AppInfoDbHelper appInfoDbHelper = AppInfoDbHelper.getInstance();
        SQLiteDatabase writableDatabase = appInfoDbHelper.getWritableDatabase();
        int i5 = 0;
        try {
            try {
                writableDatabase.beginTransaction();
                if (list != null) {
                    for (ResolveInfo resolveInfo : list) {
                        AlphaMeLogger.debugLog("delete " + resolveInfo.activityInfo.packageName);
                        appInfoDbHelper.delete(writableDatabase, resolveInfo.activityInfo.packageName);
                    }
                }
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                int i6 = 0;
                int i7 = 0;
                while (i6 < length) {
                    try {
                        JSONObject jSONObject = (JSONObject) jSONArray.opt(i6);
                        if (jSONObject.has(AppInfoDbHelper.TAG_PACKAGE_NAME) && jSONObject.has("permissionId") && jSONObject.has(str3)) {
                            String string = jSONObject.getString(AppInfoDbHelper.TAG_PACKAGE_NAME);
                            long j4 = jSONObject.getLong("permissionId");
                            Long lValueOf = Long.valueOf(j4);
                            int i8 = jSONObject.getInt(str3);
                            StringBuilder sb = new StringBuilder();
                            str2 = str3;
                            sb.append("insert ");
                            sb.append(string);
                            sb.append(", ");
                            sb.append(lValueOf);
                            sb.append(", ");
                            sb.append(i8);
                            AlphaMeLogger.debugLog(sb.toString());
                            i4 = i6;
                            appInfoDbHelper.insert(writableDatabase, string, j4, i8, false);
                            i7++;
                        } else {
                            str2 = str3;
                            i4 = i6;
                        }
                        i6 = i4 + 1;
                        str3 = str2;
                    } catch (JSONException e4) {
                        e = e4;
                        i5 = i7;
                        AlphaMeLogger.exceptionLog("JSONException", e);
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception e5) {
                            AlphaMeLogger.exceptionLog("endTransaction E:", e5);
                        }
                        return i5;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                try {
                    writableDatabase.endTransaction();
                    return i7;
                } catch (Exception e6) {
                    AlphaMeLogger.exceptionLog("endTransaction E:", e6);
                    return i7;
                }
            } catch (JSONException e7) {
                e = e7;
            }
        } finally {
        }
    }

    private boolean isBusyTime(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        return BUSY_HOURS.contains(Integer.valueOf(calendar.get(11))) && BUSY_MINUTES.contains(Integer.valueOf(calendar.get(12)));
    }

    private boolean isNeedDailyUpdate() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long lastDailyUpdateTime = Property.getLastDailyUpdateTime();
        long dailyUpdateTimeDelta = Property.getDailyUpdateTimeDelta();
        Calendar.getInstance().setTime(new Date(jCurrentTimeMillis));
        if (lastDailyUpdateTime == 0) {
            AlphaMeLogger.dLog("isNeedDailyUpdate first update");
            return true;
        }
        if (isBusyTime(jCurrentTimeMillis)) {
            AlphaMeLogger.dLog("isNeedDailyUpdate is busy time");
            return false;
        }
        if (this.retryCnt.get() == 2) {
            AlphaMeLogger.dLog("isNeedDailyUpdate retry max, set updatedelta to 2 hour");
            dailyUpdateTimeDelta = 7200000;
        } else if (dailyUpdateTimeDelta == 0 || dailyUpdateTimeDelta < FAILED_RETRY_DELTA) {
            dailyUpdateTimeDelta = 46800000;
            Property.putDailyUpdateTimeDelta(46800000L);
        }
        boolean z4 = Math.abs(jCurrentTimeMillis - lastDailyUpdateTime) > dailyUpdateTimeDelta;
        AlphaMeLogger.iLog("isNeedDailyUpdate() ret=" + z4 + " | (ct:" + jCurrentTimeMillis + "|lt:" + lastDailyUpdateTime + "|dt:" + dailyUpdateTimeDelta + ")");
        return z4;
    }

    public static boolean isNeedFullUpdate(String str, Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - Property.getlastFullUpdateTime();
        return activeNetworkInfo.isConnected() && ((jCurrentTimeMillis > 604800000L ? 1 : (jCurrentTimeMillis == 604800000L ? 0 : -1)) > 0 || (jCurrentTimeMillis > 0L ? 1 : (jCurrentTimeMillis == 0L ? 0 : -1)) < 0) && (TextUtils.equals(str, Property.getlastFullUpdateVersion()) ^ true) && activeNetworkInfo.getType() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppInstalled(Context context) {
        AlphaMeLogger.iLog("onAppInstalled " + this.mNewInstalledApp.toString());
        if (this.mNewInstalledApp.size() > 0) {
            RuleUpdater.getInstance().update(2);
            SceneDetectorEngine.getInstance().clearCache(this.mNewInstalledApp);
        }
        stopWaitingNetwork(context);
    }

    private void recordUpdateTime() {
        Property.putLastDailyUpdateTime(System.currentTimeMillis());
    }

    private void stopWaitingNetwork(Context context) {
        if (this.mWaitingUpdateNewlyApp) {
            AlphaMeLogger.dLog("stopWaitingNetwork");
            context.unregisterReceiver(this.mNetWorkChangReceiver);
            this.mWaitingUpdateNewlyApp = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryDailyUpdate(Context context, List<ResolveInfo> list) {
        AlphaMeLogger.iLog("tryDailyUpdate() retryCnt = " + this.retryCnt.get());
        this.retryCnt.incrementAndGet();
        int size = list != null ? list.size() : 0;
        AlphaMeLogger.iLog("tryDailyUpdate() syncUpdate start: cnt=" + size);
        int iDoDailyUpdate = doDailyUpdate(context, list);
        boolean z4 = iDoDailyUpdate >= 0;
        AlphaMeLogger.iLog(String.format("tryDailyUpdate() syncUpdate done: isOk:%s | %s->%s | retryCnt = %s", Boolean.valueOf(z4), Integer.valueOf(size), Integer.valueOf(iDoDailyUpdate), this.retryCnt));
        if (!z4 && this.retryCnt.get() < 2) {
            tryDailyUpdate(context, list);
            return;
        }
        this.mNewInstalledApp.clear();
        recordUpdateTime();
        this.isUpdating.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitNetwordEnabled(Context context) {
        AlphaMeLogger.dLog("waitNetwordEnabled mWaitingUpdateNewlyApp = " + this.mWaitingUpdateNewlyApp + ", mNewInstalledApp = " + this.mNewInstalledApp.toString());
        if (this.mWaitingUpdateNewlyApp) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ReceiverUtils.registerReceiverExported(context, this.mNetWorkChangReceiver, intentFilter);
        this.mWaitingUpdateNewlyApp = true;
    }

    public int doDailyUpdate(Context context, List<ResolveInfo> list) {
        AlphaMeLogger.iLog("doDailyUpdate disabled: app info rule update deprecated");
        return 0;
    }

    public boolean update(final String str, final String str2) {
        StringBuilder sbX = g.x("AppInfoRuleUpdater update ver = + ", str, ", url = ", str2, ", isUpdating = ");
        sbX.append(this.isUpdating);
        AlphaMeLogger.iLog(sbX.toString());
        if (this.isUpdating.get()) {
            return false;
        }
        this.isUpdating.set(true);
        final ApplicationImpl application = ApplicationImpl.getApplication();
        final boolean zIsNeedFullUpdate = isNeedFullUpdate(str, application);
        final boolean z4 = zIsNeedFullUpdate || isNeedDailyUpdate();
        final boolean z5 = this.mNewInstalledApp.size() > 0;
        AlphaMeLogger.iLog("update needFullUpdate = " + zIsNeedFullUpdate + ", needDailyUpdate = " + z4 + ", hasNewApp = " + z5);
        if (zIsNeedFullUpdate || z4 || z5) {
            new Thread("AppInfo-update") { // from class: com.stepos.alphame.appinfo.AppInfoRuleUpdater.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (zIsNeedFullUpdate) {
                        AppInfoRuleUpdater.fullUpdate(application, str, str2);
                    }
                    if (zIsNeedFullUpdate || z4) {
                        AppInfoRuleUpdater.this.retryCnt.set(0);
                        AppInfoRuleUpdater appInfoRuleUpdater = AppInfoRuleUpdater.this;
                        Context context = application;
                        appInfoRuleUpdater.tryDailyUpdate(context, AppUtils.getInstalledApps(context));
                    } else if (z5) {
                        AppInfoRuleUpdater.this.retryCnt.set(0);
                        AppInfoRuleUpdater.this.updateNewlyApp(application);
                    }
                    AppInfoRuleUpdater.this.isUpdating.set(false);
                    AlphaMeLogger.iLog("update finish; isFullUpdate =  " + zIsNeedFullUpdate);
                    SceneDetectorEngine.getInstance().clearCache();
                }
            }.start();
            return true;
        }
        this.isUpdating.set(false);
        return false;
    }

    public void updateNewlyApp(Context context) {
        tryDailyUpdate(context, AppUtils.getInstalledApps(context, this.mNewInstalledApp));
    }
}
