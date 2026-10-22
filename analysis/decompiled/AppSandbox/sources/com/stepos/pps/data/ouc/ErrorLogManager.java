package com.stepos.pps.data.ouc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.stepos.pps.data.util.CRC64;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.FileUtils;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.data.util.Utils;
import com.stepos.pps.reflect.ReflectCache;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ErrorLogManager {
    private static final int CLEAN_LOG = 2;
    private static final int LOW_BATTERY_THRESHOLD = 50;
    private static final long SCREEN_OFF_DELAY_MILLIS = 120000;
    private static final int UPLOAD = 1;
    private static final int UPLOAD_COUNT_CHARGING = 10;
    private static final int UPLOAD_COUNT_NORMAL = 5;
    private static final int UPLOAD_SCREEN_OFF = 3;
    private static volatile ErrorLogManager sErrorLogManager;
    private Context mContext;
    private final ErrorDatabaseHelper mDatabaseHelper;
    private final File mErrorLogFileDir;
    private final File mErrorLogTempFileDir;
    private final ErrorLogUploader mErrorLogUploader;
    private final SharedPreferences mSharedPreferences;
    private final WorkHandler mWorkHandler;
    private static final Object sLock = new Object();
    private static final Set<String> DEDUP_SKIP_TYPES = new HashSet(Arrays.asList("EMS_CELLULAR"));
    private final String TAG = "PPS:ErrorLogManager";
    private HandlerThread mHandlerThread = new HandlerThread("ErrorLogManagerThread");
    private final BroadcastReceiver mScreenReceiver = new BroadcastReceiver() { // from class: com.stepos.pps.data.ouc.ErrorLogManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent != null ? intent.getAction() : null;
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                ErrorLogManager.this.mWorkHandler.removeMessages(3);
                ErrorLogManager.this.mWorkHandler.sendEmptyMessageDelayed(3, ErrorLogManager.SCREEN_OFF_DELAY_MILLIS);
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                ErrorLogManager.this.mWorkHandler.removeMessages(3);
            }
        }
    };

    private ErrorLogManager(Context context) throws IOException, SQLException {
        this.mContext = context.getApplicationContext();
        this.mErrorLogFileDir = new File(this.mContext.getFilesDir().getAbsolutePath() + File.separator + Constants.ERROR_LOG_FILE_DIR);
        this.mErrorLogTempFileDir = new File(this.mContext.getFilesDir().getAbsolutePath() + File.separator + "temp");
        this.mDatabaseHelper = ErrorDatabaseHelper.getInstance(this.mContext);
        this.mErrorLogUploader = new ErrorLogUploader(this.mContext);
        this.mHandlerThread.start();
        this.mWorkHandler = new WorkHandler(this.mHandlerThread.getLooper());
        this.mSharedPreferences = this.mContext.getSharedPreferences(Constants.PREFERENCES_NAME, 0);
        init();
        registerScreenReceiver();
        checkCleanLogDelay();
        checkUploadDelay();
    }

    public static ErrorLogManager getInstance(Context context) {
        if (sErrorLogManager == null) {
            synchronized (sLock) {
                if (sErrorLogManager == null) {
                    sErrorLogManager = new ErrorLogManager(context);
                }
            }
        }
        return sErrorLogManager;
    }

    private void init() throws IOException, SQLException {
        FileUtils.ensureDir(this.mErrorLogFileDir);
        this.mDatabaseHelper.clearOldData();
    }

    private void checkCleanLogDelay() {
        this.mWorkHandler.removeMessages(2);
        this.mWorkHandler.sendEmptyMessageDelayed(2, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCheckAndCleanErrorLog() {
        long j = this.mSharedPreferences.getLong(Constants.PREFERENCES_LAST_CLEAN_ERROR_LOG_TIME, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - j > Constants.CLEAN_CHECK_INTERVAL) {
            cleanOldDatabase();
            cleanExpireLogFile();
            setLastCleanLogTime(jCurrentTimeMillis);
        }
    }

    private void setLastCleanLogTime(long j) {
        LogUtil.d("PPS:ErrorLogManager", "setLastCleanLogTime = " + j);
        this.mSharedPreferences.edit().putLong(Constants.PREFERENCES_LAST_CLEAN_ERROR_LOG_TIME, j).commit();
    }

    private void cleanExpireLogFile() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        File[] fileArrListFiles = this.mErrorLogFileDir.listFiles();
        for (int i = 0; fileArrListFiles != null && i < fileArrListFiles.length; i++) {
            if (jCurrentTimeMillis - fileArrListFiles[i].lastModified() > 604800000 && fileArrListFiles[i].delete()) {
                LogUtil.i("PPS:ErrorLogManager", "cleanExpireLogFile : " + fileArrListFiles[i].getAbsolutePath());
            }
        }
    }

    private void cleanOldDatabase() {
        this.mDatabaseHelper.checkAndCleanOldDatabase();
    }

    public void checkUpload(boolean z) {
        if (!isLogCollectEnabled()) {
            LogUtil.w("PPS:ErrorLogManager", "Ignore checkUpload for user privacy!!!");
            return;
        }
        long j = this.mSharedPreferences.getLong(Constants.PREFERENCES_LAST_UPLOAD_TIME, 0L);
        if (Utils.sTestMode || isUploadIntervalElapsed(j)) {
            LogUtil.d("PPS:ErrorLogManager", "check upload. It has been 4 hours since the last upload.");
            this.mWorkHandler.removeMessages(1);
            this.mWorkHandler.sendEmptyMessage(1);
        }
    }

    private void checkUploadDelay() {
        if (!Utils.canLogCollect(this.mContext)) {
            LogUtil.w("PPS:ErrorLogManager", "Ignore checkUploadDelay for user privacy!!!");
            return;
        }
        long j = this.mSharedPreferences.getLong(Constants.PREFERENCES_LAST_UPLOAD_TIME, 0L);
        if (Utils.sTestMode || isUploadIntervalElapsed(j)) {
            LogUtil.d("PPS:ErrorLogManager", "check upload ==> It has been 4 hours since the last upload. ==>delay of 5 minute.");
            this.mWorkHandler.removeMessages(1);
            this.mWorkHandler.sendEmptyMessageDelayed(1, Constants.SYSTEM_SERVER_INTERVAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastUploadTime(long j) {
        LogUtil.d("PPS:ErrorLogManager", "setLastUploadTime = " + j);
        this.mSharedPreferences.edit().putLong(Constants.PREFERENCES_LAST_UPLOAD_TIME, j).commit();
    }

    private boolean isUploadIntervalElapsed(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > Constants.UPLOAD_INTERVAL;
    }

    public void scheduleStartUploaderJob() {
        LogUtil.d("PPS:ErrorLogManager", "scheduleErrorLogUploaderJob");
        Context context = this.mContext;
        if (context != null) {
            ErrorLogUploaderJobService.schedule(context);
        }
    }

    public void scheduleStoploaderJob() {
        LogUtil.d("PPS:ErrorLogManager", "scheduleErrorLogUploaderJob");
        Context context = this.mContext;
        if (context != null) {
            ErrorLogUploaderJobService.cancel(context);
        }
    }

    private boolean saveDumpFile(ErrorInfo errorInfo) throws Throwable {
        FileOutputStream fileOutputStream;
        GZIPOutputStream gZIPOutputStream;
        FileUtils.ensureDir(this.mErrorLogFileDir);
        File file = errorInfo.dumpFile;
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            file.delete();
        }
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
                try {
                    gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(fileOutputStream));
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            gZIPOutputStream.write(errorInfo.dump.getBytes());
            gZIPOutputStream.flush();
            Utils.closeQuietly(gZIPOutputStream);
            Utils.closeQuietly(fileOutputStream);
            return true;
        } catch (IOException e3) {
            e = e3;
            gZIPOutputStream2 = gZIPOutputStream;
            e.printStackTrace();
            Utils.closeQuietly(gZIPOutputStream2);
            Utils.closeQuietly(fileOutputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream2 = gZIPOutputStream;
            Utils.closeQuietly(gZIPOutputStream2);
            Utils.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    private boolean saveDumpFileFromFile(ErrorInfo errorInfo, File file) {
        int i;
        File file2 = errorInfo.dumpFile;
        if (file2 == null) {
            return false;
        }
        String path = file2.getPath();
        LogUtil.d("PPS:ErrorLogManager", "path=" + path);
        if (path == null) {
            return false;
        }
        int iLastIndexOf = path.lastIndexOf(".");
        String strSubstring = (-1 == iLastIndexOf || (i = iLastIndexOf + 1) >= path.length()) ? null : path.substring(i);
        if (strSubstring == null) {
            return false;
        }
        LogUtil.d("PPS:ErrorLogManager", "ext=" + strSubstring);
        if (strSubstring.equals("gz")) {
            try {
                ReflectCache.on("android.os.FileUtils", "copyFile", (Class<?>[]) new Class[]{File.class, File.class}).invoke(errorInfo.dumpFile, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            FileUtils.zipFile(errorInfo.dumpFile, file);
        }
        return true;
    }

    public boolean addErrorLogData(ErrorInfo errorInfo) {
        if (errorInfo == null) {
            LogUtil.d("PPS:ErrorLogManager", "addErrorLogData failed: errorInfo is null");
            return false;
        }
        if (Utils.isDataDirLowOnSpace()) {
            long dataDirAvailableSize = Utils.getDataDirAvailableSize();
            LogUtil.d("PPS:ErrorLogManager", "addErrorLogData failed: out of disk space, avail=" + dataDirAvailableSize);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("avail", dataDirAvailableSize);
                jSONObject.put("total", Utils.getDataDirTotalSize());
            } catch (Throwable unused) {
            }
            EmsLogDropReporter.report(this.mContext, 3, EmsLogDropReporter.R_SANDBOX_DISK_FULL, errorInfo, jSONObject);
            return false;
        }
        if (TextUtils.isEmpty(errorInfo.tag)) {
            LogUtil.d("PPS:ErrorLogManager", "addErrorLogData failed: tag is null");
            EmsLogDropReporter.report(this.mContext, 3, EmsLogDropReporter.R_SANDBOX_EMPTY_TAG, errorInfo, null);
            return false;
        }
        errorInfo.tagSign = String.valueOf(CRC64.fromBytes(FileUtils.gzip(errorInfo.tag.getBytes())).getValue());
        String strValueOf = String.valueOf(CRC64.fromBytes((errorInfo.tag + errorInfo.packageName + errorInfo.version).getBytes()).getValue());
        Set<String> set = DEDUP_SKIP_TYPES;
        if (set.contains(errorInfo.type)) {
            strValueOf = strValueOf + "_" + errorInfo.uuid;
        }
        if (!set.contains(errorInfo.type) && this.mDatabaseHelper.isErrorInfoExists(errorInfo.packageName, errorInfo.version, errorInfo.tagSign)) {
            LogUtil.d("PPS:ErrorLogManager", "Duplicate crash file,  type:" + errorInfo.type + " pkg:" + errorInfo.packageName + " tagSign:" + errorInfo.tagSign);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("tag_sign", errorInfo.tagSign);
            } catch (Throwable unused2) {
            }
            EmsLogDropReporter.report(this.mContext, 3, EmsLogDropReporter.R_SANDBOX_DUPLICATE, errorInfo, jSONObject2);
            return false;
        }
        if (errorInfo.dumpFile != null) {
            File file = new File(this.mErrorLogFileDir, strValueOf + "_dump.txt.gz");
            if (!saveDumpFileFromFile(errorInfo, file)) {
                errorInfo.dumpFile = null;
            } else {
                errorInfo.dumpFile = file;
            }
            if (errorInfo.dumpFile != null) {
                try {
                    errorInfo.dumpSign = String.valueOf(CRC64.fromFile(errorInfo.dumpFile).getValue());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (errorInfo.dumpFile == null && !TextUtils.isEmpty(errorInfo.dump)) {
            errorInfo.dumpFile = new File(this.mErrorLogFileDir, strValueOf + "_dump.txt.gz");
            if (!saveDumpFile(errorInfo)) {
                errorInfo.dumpFile = null;
            } else {
                try {
                    errorInfo.dumpSign = String.valueOf(CRC64.fromFile(errorInfo.dumpFile).getValue());
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (errorInfo.dumpFile != null && errorInfo.dumpFile.exists()) {
            errorInfo.size += errorInfo.dumpFile.length();
        }
        if (errorInfo.extFile != null && errorInfo.extFile.exists()) {
            LogUtil.d("PPS:ErrorLogManager", "extFile: " + errorInfo.extFile.getAbsolutePath());
            File file2 = new File(this.mErrorLogFileDir, strValueOf + "_ems.zip.gz");
            if (!FileUtils.zipFile(errorInfo.extFile, file2)) {
                file2.delete();
            }
            if (!file2.exists()) {
                LogUtil.d("PPS:ErrorLogManager", "addErrorLogData: extFile zip fail, do not upload it");
            } else {
                errorInfo.extFile = file2;
                LogUtil.d("PPS:ErrorLogManager", "extFile: " + errorInfo.extFile.getAbsolutePath());
                try {
                    errorInfo.extFileSign = String.valueOf(CRC64.fromFile(errorInfo.extFile).getValue());
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                errorInfo.size += errorInfo.extFile.length();
            }
        }
        LogUtil.d("PPS:ErrorLogManager", "addErrorLogData insertErrorInfo " + errorInfo);
        this.mDatabaseHelper.insertErrorInfo(errorInfo);
        errorInfo.tag = null;
        errorInfo.dump = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, ErrorInfo> prepareUpload() {
        return prepareUpload(200);
    }

    private boolean isLogCollectEnabled() {
        return Utils.canLogCollect(this.mContext);
    }

    private void registerScreenReceiver() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.mContext.registerReceiver(this.mScreenReceiver, intentFilter);
        } catch (Exception e) {
            LogUtil.e("PPS:ErrorLogManager", "registerScreenReceiver failed: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleScreenOffUpload() {
        int i;
        if (!isLogCollectEnabled()) {
            LogUtil.w("PPS:ErrorLogManager", "screen-off upload ignored for user privacy");
            return;
        }
        if (!Utils.isWiFiWorking(this.mContext)) {
            LogUtil.d("PPS:ErrorLogManager", "screen-off upload skip: no wifi");
            return;
        }
        Intent intentRegisterReceiver = this.mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean zIsCharging = isCharging(intentRegisterReceiver);
        int batteryPercent = getBatteryPercent(intentRegisterReceiver);
        long j = this.mSharedPreferences.getLong(Constants.PREFERENCES_LAST_UPLOAD_TIME, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (j != 0 && !isUploadIntervalElapsed(j)) {
            LogUtil.d("PPS:ErrorLogManager", "screen-off upload skip: last upload was " + jCurrentTimeMillis + "ms ago (< 4h)");
            return;
        }
        if (zIsCharging) {
            i = 10;
        } else {
            if (batteryPercent <= 50) {
                LogUtil.d("PPS:ErrorLogManager", "screen-off upload skip: not charging & low battery, percent=" + batteryPercent);
                return;
            }
            i = 5;
        }
        LogUtil.d("PPS:ErrorLogManager", "screen-off upload start, charging=" + zIsCharging + ", percent=" + batteryPercent + ", limit=" + i);
        if (this.mErrorLogUploader.upload(prepareUpload(i))) {
            setLastUploadTime(System.currentTimeMillis());
        }
    }

    private boolean isCharging(Intent intent) {
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5 || intent.getIntExtra("plugged", 0) != 0;
    }

    private int getBatteryPercent(Intent intent) {
        if (intent == null) {
            return 100;
        }
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            return 100;
        }
        return (intExtra * 100) / intExtra2;
    }

    private Map<String, ErrorInfo> prepareUpload(int i) throws IOException {
        HashMap map = new HashMap();
        Cursor errors = null;
        try {
            errors = this.mDatabaseHelper.getErrors(i);
            if (errors != null) {
                while (errors.moveToNext()) {
                    ErrorInfo errorInfoCreateErrorInfo = ErrorDatabaseHelper.createErrorInfo(errors);
                    map.put(errorInfoCreateErrorInfo.uuid, errorInfoCreateErrorInfo);
                }
            }
            return map;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return map;
            } finally {
                Utils.closeQuietly(errors);
            }
        }
    }

    private boolean isSystemErrorAndMissExtFile(ErrorInfo errorInfo) {
        long jCurrentTimeMillis = System.currentTimeMillis() - errorInfo.time;
        return errorInfo.packageName != null && errorInfo.packageName.equals(Constants.ANDROID_PACKAGE) && errorInfo.extFile == null && jCurrentTimeMillis > 0 && jCurrentTimeMillis < Constants.SYSTEM_SERVER_ERROR_INTERVAL;
    }

    private class WorkHandler extends Handler {
        WorkHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    ErrorLogManager.this.doCheckAndCleanErrorLog();
                    return;
                } else {
                    if (i != 3) {
                        return;
                    }
                    ErrorLogManager.this.handleScreenOffUpload();
                    return;
                }
            }
            if (Utils.canLogCollect(ErrorLogManager.this.mContext) && Utils.isWiFiWorking(ErrorLogManager.this.mContext)) {
                LogUtil.d("PPS:ErrorLogManager", "Connected to wifi , ready to upload.");
                if (ErrorLogManager.this.mErrorLogUploader.upload(ErrorLogManager.this.prepareUpload())) {
                    ErrorLogManager.this.setLastUploadTime(System.currentTimeMillis());
                    return;
                }
                return;
            }
            LogUtil.d("PPS:ErrorLogManager", "can't upload error logs. collection is disable or not wifi.");
        }
    }
}
