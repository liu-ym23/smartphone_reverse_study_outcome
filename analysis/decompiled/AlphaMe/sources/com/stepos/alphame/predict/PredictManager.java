package com.stepos.alphame.predict;

import B0.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.AbstractC0351g;
import com.alibaba.fastjson.JSONArray;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.EngineContract;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.awareness.AwarenessDataSource;
import com.stepos.alphame.awareness.AwarenessStorable;
import com.stepos.alphame.awareness.TimetableTracker;
import com.stepos.alphame.cutout.CutImageHelper;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.location.LocationEngine;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.persona.PersonaDataItem;
import com.stepos.alphame.power.PowerEngine;
import com.stepos.alphame.reflect.UserHandle;
import com.stepos.alphame.request.RequestManager;
import com.stepos.alphame.request.ResponseListener;
import com.stepos.alphame.request.UploadInfoBean;
import com.stepos.alphame.scene.AppInstallReceiver;
import com.stepos.alphame.scene.QuickAppHelper;
import com.stepos.alphame.scene.SceneDetectorEngine;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.AppUtils;
import com.stepos.alphame.utils.DeviceInfoKt;
import com.stepos.alphame.utils.FileUtil;
import com.stepos.alphame.utils.LargeBinderTransactionHelper;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.StringUtil;
import com.stepos.alphame.utils.UsageStatsUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class PredictManager {
    public static final String DATA_FORMAT = "%s,%d,%d,%s,%d,%s,%s,%d,%d,%d";
    private static final long DAY = 86400000;
    private static final long HOUR = 3600000;
    private static final String KEY = "predictRecord";
    private static final int LIMIT_RECENT = 1000;
    private static final int LIMIT_TRAIN_ALL = 40000;
    private static final String LOC_OTHER = "";
    private static final long MINUTE = 60000;
    private static final String PICKER_RESULT_CONFIRM_TIME = "stepos_picker_confirm_result_timeout";
    private static final int PICKER_WINDOW_DEFAULT = 0;
    private static final String PICKER_WINDOW_MODE_ENABLE = "stepos_picker_window_mode_enable";
    private static final long SECEND = 1000;
    private static final int SHORT_PRESS_TIME = 500;
    private static final int TRAIN_ALL_MIN_SIZE = 20;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private static final String[] sDefaultSuggestions = {EngineContract.NOTE_PAPER_PACKAGE_NAME, "com.stepos.scanner", "com.stepos.smarthome", "com.stepos.appstore", CutImageHelper.PACKAGE_NAME_GALLERY, EngineContract.VOICE_ASSISTANT_PACKAGE_NAME, EngineContract.SETTING_PACKAGE_NAME, "com.stepos.feedback", "com.stepos.todolist", "com.calculator.calculator", "com.stepos.media.camera", "com.android.browser", "com.android.dialer", "com.stepos.datamigration", "com.android.mms", "com.stepos.filemanager", "com.stepos.media.music", "com.stepos.customizecenter", "com.stepos.media.video", "com.stepos.media.life"};

    @SuppressLint({"StaticFieldLeak"})
    private static PredictManager sInstance;
    private AppRecord mLastRecord;
    private long mLastRecentTrainTime = 0;
    private PredictRecord mPredictRecord = null;

    @NonNull
    public List<String> mToTrainList = new ArrayList();
    private final AtomicReference<ArrayList<AppRecord>> mAppRecords = new AtomicReference<>(new ArrayList());
    private TrainingData mCurrAppEvent = null;
    private ArrayList<String> mLauncherApps = new ArrayList<>();
    private ArrayList<String> mUnAvailableApps = new ArrayList<>();
    private ArrayList<String> mHomeApps = new ArrayList<>();
    private List<String> mAppOnLauncher = new ArrayList();
    private String mUserIdPrefix = AwarenessDataItem.USERID_SPLITTER + (Process.myUid() / ComplexPt.TEN_THOUSAND);
    private PackageRecord mNewlyInstalledApp = null;
    private int mRemovedAppCount = 0;
    private boolean mAppRecordInitializing = false;
    private AppInstallReceiver.OnAppInsatllChangeListener mAppInstallListener = new AppInstallReceiver.OnAppInsatllChangeListener() { // from class: com.stepos.alphame.predict.PredictManager.1
        @Override // com.stepos.alphame.scene.AppInstallReceiver.OnAppInsatllChangeListener
        public void onChanged(String str, int i4, int i5) throws PackageManager.NameNotFoundException {
            AlphaMeLogger.dLog("mAppInstallListener  onChanged " + str + ", userId = " + i5);
            PredictManager.this.updateHomeApps(PredictManager.mContext);
            if (i5 != 0) {
                str = str + AwarenessDataItem.USERID_SPLITTER + i5;
            }
            if (i4 != 0) {
                if (i4 == 1 && PredictManager.this.mAppOnLauncher.contains(str)) {
                    PredictManager.this.mAppOnLauncher.remove(str);
                    if (PredictManager.this.mNewlyInstalledApp != null && PredictManager.this.mNewlyInstalledApp.pkgName.equals(str)) {
                        PredictManager.this.mNewlyInstalledApp = null;
                    }
                    PredictManager.this.mRemovedAppCount++;
                    return;
                }
                return;
            }
            PackageRecord packageRecord = PredictManager.this.getPackageRecord(PredictManager.mContext.getPackageManager(), str);
            if (packageRecord == null && i5 != 0) {
                packageRecord = PredictManager.this.new PackageRecord(str, System.currentTimeMillis(), System.currentTimeMillis());
            }
            if (packageRecord != null) {
                if (!PredictManager.this.mAppOnLauncher.contains(str)) {
                    PredictManager.this.mAppOnLauncher.add(str);
                }
                PredictManager.this.mNewlyInstalledApp = packageRecord;
            }
        }
    };

    public class AppRecord {
        int blueConnected;
        int dayOff;
        long end;
        int headSetPlugedIn;
        String location;
        String pkgName;
        int power;
        long start;
        String weather;
        int wifiIsOn;

        public AppRecord(String str, long j4, long j5) {
            this.pkgName = str;
            this.start = j4;
            this.end = j5;
        }

        public String getFormatPkgName() {
            return PredictManager.this.formatPkgName(this.pkgName);
        }

        public boolean isLauncher() {
            return PredictManager.this.isLauncherApp(this.pkgName);
        }

        public boolean isPredictable() {
            return (PredictManager.this.mUnAvailableApps.contains(PredictManager.this.formatPkgName(this.pkgName)) || PredictManager.isPayment(this.pkgName)) ? false : true;
        }

        public boolean isScreenOffOrLocked() {
            return SceneDetectorEngine.isScreenLocked(getFormatPkgName()) || SceneDetectorEngine.isScreenOff(getFormatPkgName());
        }

        public long length() {
            return Math.max(0L, this.end - this.start);
        }

        public String toString() {
            return this.pkgName + ", " + this.start + ", " + this.end;
        }
    }

    public class PackageRecord {
        private static final long NEW_APP_DURATION = 300000;
        long installTime;
        long lastUpdateTime;
        String pkgName;

        public PackageRecord(String str, long j4, long j5) {
            this.pkgName = str;
            this.installTime = j4;
            this.lastUpdateTime = j5;
        }

        public boolean isNewApp(long j4) {
            long j5 = this.installTime;
            return j4 - j5 > 0 && j4 - j5 < 300000;
        }

        public String toString() {
            return this.pkgName;
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    public class TrainAllTask extends AsyncTask<Void, String, Void> {
        private boolean writeToFile;

        public TrainAllTask(boolean z4) {
            this.writeToFile = z4;
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) throws Throwable {
            Process.setThreadPriority(19);
            PredictManager.this.initAppRecords(40000, this.writeToFile);
            List<String> list = PredictManager.this.mToTrainList;
            AlphaMeLogger.costLogAndRefresh("mToTrainList size " + list.size());
            if (list.size() <= 0) {
                AlphaMeLogger.dLog("mToTrainList empty");
                return null;
            }
            if (list.size() > 20) {
                PredictManager.this.train(list, true);
            }
            PredictManager.this.train(list, false);
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Void r12) {
            super.onPostExecute((TrainAllTask) r12);
            PredictManager.this.mRemovedAppCount = 0;
        }
    }

    public class TrainingData {
        int blueConnected;
        AppRecord currAppItem;
        long date;
        int dayOff;
        int headSetPlugedIn;
        String imei;
        AppRecord lastAppItem;
        String location;
        int power;
        String weather;
        int wifiIsOn;

        public TrainingData(String str) {
            this.imei = str;
        }

        public String toDetailString() {
            this.imei = DeviceInfoKt.getOaid();
            AppRecord appRecord = this.lastAppItem;
            String str = "null";
            String str2 = appRecord != null ? appRecord.pkgName : "null";
            int i4 = !TextUtils.isEmpty(this.weather) ? Integer.parseInt(this.weather) : 0;
            AppRecord appRecord2 = this.currAppItem;
            if (appRecord2 != null) {
                this.date = appRecord2.start;
                str = appRecord2.pkgName;
            }
            return "date: " + StringUtil.formatDateFull(this.date) + ", weather: " + i4 + ", wifiIsOn: " + this.wifiIsOn + ", location: " + this.location + ", power: " + this.power + ", lastAppPkg: " + str2 + ", currPkg: " + str + ", headSetPlugedIn: " + this.headSetPlugedIn + ", blueConnected: " + this.blueConnected + ", dayOff: " + this.dayOff;
        }

        public String toString() {
            this.imei = DeviceInfoKt.getOaid();
            AppRecord appRecord = this.lastAppItem;
            String str = "null";
            String str2 = appRecord != null ? appRecord.pkgName : "null";
            int i4 = !TextUtils.isEmpty(this.weather) ? Integer.parseInt(this.weather) : 0;
            AppRecord appRecord2 = this.currAppItem;
            if (appRecord2 != null) {
                this.date = appRecord2.start;
                str = appRecord2.pkgName;
            }
            return PredictManager.format(StringUtil.formatDateFull(this.date), i4, this.wifiIsOn, this.location, this.power, str2, str, this.headSetPlugedIn, this.blueConnected, this.dayOff);
        }
    }

    public PredictManager(Context context) {
        mContext = context;
        registerReceivers(context);
    }

    private TrainingData addAppRecord(String str, long j4, String str2, String str3, int i4, int i5, int i6, int i7, int i8) {
        AppRecord appRecord;
        AppRecord appRecord2 = new AppRecord(str, j4, 0L);
        appRecord2.weather = str2;
        appRecord2.location = str3;
        appRecord2.wifiIsOn = i4;
        appRecord2.power = i5;
        appRecord2.dayOff = i6;
        appRecord2.blueConnected = i7;
        appRecord2.headSetPlugedIn = i8;
        ArrayList<AppRecord> arrayList = this.mAppRecords.get();
        if (arrayList.size() > 0) {
            ((AppRecord) g.h(arrayList, 1)).end = j4;
        }
        arrayList.add(appRecord2);
        TrainingData trainingData = null;
        if (appRecord2.isScreenOffOrLocked()) {
            this.mLastRecord = appRecord2;
        } else if (appRecord2.isPredictable()) {
            if (arrayList.size() > 1 && (appRecord = this.mLastRecord) != null && ((appRecord.isLauncher() || this.mLastRecord.end != appRecord2.start) && appRecord2.isPredictable() && isAppOnLauncher(appRecord2.pkgName))) {
                if (!this.mLastRecord.isScreenOffOrLocked()) {
                    trainingData = new TrainingData(DeviceInfoKt.getOaid());
                    trainingData.wifiIsOn = appRecord2.wifiIsOn;
                    trainingData.weather = appRecord2.weather;
                    trainingData.location = appRecord2.location;
                    trainingData.power = appRecord2.power;
                    trainingData.dayOff = appRecord2.dayOff;
                    trainingData.blueConnected = appRecord2.blueConnected;
                    trainingData.headSetPlugedIn = appRecord2.headSetPlugedIn;
                    trainingData.currAppItem = appRecord2;
                    trainingData.lastAppItem = this.mLastRecord;
                } else if (((AppRecord) g.h(arrayList, 2)).isLauncher()) {
                    TrainingData trainingData2 = new TrainingData(DeviceInfoKt.getOaid());
                    trainingData2.wifiIsOn = appRecord2.wifiIsOn;
                    trainingData2.weather = appRecord2.weather;
                    trainingData2.location = appRecord2.location;
                    trainingData2.power = appRecord2.power;
                    trainingData2.dayOff = appRecord2.dayOff;
                    trainingData2.blueConnected = appRecord2.blueConnected;
                    trainingData2.headSetPlugedIn = appRecord2.headSetPlugedIn;
                    trainingData2.currAppItem = appRecord2;
                    trainingData2.lastAppItem = null;
                    trainingData = trainingData2;
                }
            }
            this.mLastRecord = appRecord2;
        }
        TrainingData trainingData3 = this.mCurrAppEvent;
        if (trainingData3 != null) {
            this.mToTrainList.add(trainingData3.toString());
        }
        this.mCurrAppEvent = trainingData;
        return trainingData;
    }

    @SuppressLint({"SdCardPath"})
    private void createModelDirAndCopyOldIfNeed() throws Throwable {
        String modelDir = getModelDir();
        File file = new File(modelDir);
        if (file.exists()) {
            return;
        }
        if (!file.mkdirs()) {
            AlphaMeLogger.iLog("Create predict output Failed");
            return;
        }
        FileUtil.copyDir("/data/data/com.stepos.alphame/cache/predictApp", modelDir);
        AlphaMeLogger.iLog("Create predict output Succeed. All files after copy: " + Arrays.toString(file.list()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    public void deleteOldAwarenessData(final int i4, final long j4) {
        new AsyncTask<Void, Void, Void>() { // from class: com.stepos.alphame.predict.PredictManager.4
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                AwarenessStorable.deleteBefore(j4 - (i4 * 86400000));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void fillDefaultApps(List<String> list, int i4) {
        for (String str : sDefaultSuggestions) {
            if (list.size() >= i4) {
                return;
            }
            if (!list.contains(str)) {
                String strP = AbstractC0351g.p(str, AwarenessDataItem.USERID_SPLITTER);
                Iterator<String> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        AlphaMeLogger.dLog("fillDefaultApps: " + str);
                        list.add(str);
                        break;
                    }
                    if (it.next().startsWith(strP)) {
                        break;
                    }
                }
            }
        }
    }

    public static final String format(String str, int i4, int i5, String str2, int i6, String str3, String str4, int i7, int i8, int i9) {
        return String.format(DATA_FORMAT, str, Integer.valueOf(i4), Integer.valueOf(i5), str2, Integer.valueOf(i6), str3, str4, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAwarenessInfo(String str, AwarenessDataItem awarenessDataItem) {
        return str + ",4," + awarenessDataItem;
    }

    public static PredictManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PredictManager(context);
        }
        return sInstance;
    }

    private String getModelPath() {
        return mContext.getFilesDir().getAbsolutePath() + "/predictApp/app_model";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageRecord getPackageRecord(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (this.mLauncherApps.contains(str)) {
                return null;
            }
            return new PackageRecord(str, packageInfo.firstInstallTime, packageInfo.lastUpdateTime);
        } catch (PackageManager.NameNotFoundException e4) {
            StringBuilder sbW = g.w("getPackageRecord failed for ", str, ", error=");
            sbW.append(e4.getMessage());
            AlphaMeLogger.wLog(sbW.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065 A[LOOP:0: B:7:0x0042->B:17:0x0065, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[EDGE_INSN: B:20:0x0068->B:18:0x0068 BREAK  A[LOOP:0: B:7:0x0042->B:17:0x0065], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.stepos.alphame.predict.PredictManager.TrainingData getPredictEvent() {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicReference<java.util.ArrayList<com.stepos.alphame.predict.PredictManager$AppRecord>> r0 = r8.mAppRecords
            java.lang.Object r0 = r0.get()
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            if (r1 != 0) goto L10
            r8 = 0
            return r8
        L10:
            com.stepos.alphame.predict.PredictManager$TrainingData r1 = new com.stepos.alphame.predict.PredictManager$TrainingData
            java.lang.String r2 = com.stepos.alphame.utils.DeviceInfoKt.getOaid()
            r1.<init>(r2)
            r2 = 1
            java.lang.Object r3 = B0.g.h(r0, r2)
            com.stepos.alphame.predict.PredictManager$AppRecord r3 = (com.stepos.alphame.predict.PredictManager.AppRecord) r3
            int r4 = r3.wifiIsOn
            r1.wifiIsOn = r4
            java.lang.String r4 = r3.weather
            r1.weather = r4
            java.lang.String r4 = r3.location
            r1.location = r4
            int r4 = r3.power
            r1.power = r4
            int r4 = r3.dayOff
            r1.dayOff = r4
            int r4 = r3.blueConnected
            r1.blueConnected = r4
            int r3 = r3.headSetPlugedIn
            r1.headSetPlugedIn = r3
            int r3 = r0.size()
            int r3 = r3 - r2
            r4 = 0
        L42:
            if (r3 < 0) goto L68
            java.lang.Object r5 = r0.get(r3)
            com.stepos.alphame.predict.PredictManager$AppRecord r5 = (com.stepos.alphame.predict.PredictManager.AppRecord) r5
            boolean r6 = r5.isScreenOffOrLocked()
            if (r6 == 0) goto L52
        L50:
            r4 = r2
            goto L62
        L52:
            java.util.ArrayList<java.lang.String> r6 = r8.mUnAvailableApps
            java.lang.String r7 = r5.getFormatPkgName()
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L5f
            goto L62
        L5f:
            r1.lastAppItem = r5
            goto L50
        L62:
            if (r4 == 0) goto L65
            goto L68
        L65:
            int r3 = r3 + (-1)
            goto L42
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.predict.PredictManager.getPredictEvent():com.stepos.alphame.predict.PredictManager$TrainingData");
    }

    private PredictRecord getPredictRecord() {
        if (this.mPredictRecord == null) {
            String strLoadPredictInfo = loadPredictInfo();
            if (TextUtils.isEmpty(strLoadPredictInfo)) {
                this.mPredictRecord = new PredictRecord();
            } else {
                this.mPredictRecord = PredictRecord.fromJsonString(strLoadPredictInfo);
            }
        }
        return this.mPredictRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f0 A[LOOP:0: B:14:0x008b->B:67:0x01f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0187 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initAppRecords(int r28, boolean r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.predict.PredictManager.initAppRecords(int, boolean):void");
    }

    private synchronized boolean isAppRecordInitializing() {
        return this.mAppRecordInitializing;
    }

    public static boolean isPayment(String str) {
        return str != null && str.startsWith("payment_");
    }

    private boolean isQuickApp(String str) {
        return QuickAppHelper.isQuickPrefix(str);
    }

    private synchronized void markAppRecordInitializing(boolean z4) {
        this.mAppRecordInitializing = z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    public void postAwarenessIfNeed(final int i4, final long j4) {
        new AsyncTask<PersonaDataItem, String, String>() { // from class: com.stepos.alphame.predict.PredictManager.3
            @Override // android.os.AsyncTask
            public String doInBackground(PersonaDataItem... personaDataItemArr) throws Throwable {
                Cursor cursor;
                String oaid = DeviceInfoKt.getOaid();
                ArrayList arrayList = new ArrayList();
                Cursor cursor2 = null;
                try {
                    try {
                        cursor = AwarenessStorable.getCursor("date > ? AND date < ?", new String[]{String.valueOf(Property.getLastUploadTime()), String.valueOf(j4)}, "date", null);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                try {
                    cursor.moveToFirst();
                    AwarenessStorable awarenessStorable = (AwarenessStorable) AwarenessDataSource.getInstance().getStorable();
                    while (cursor.moveToNext()) {
                        arrayList.add(PredictManager.this.getAwarenessInfo(oaid, awarenessStorable.fillItem(cursor, (DataItem) null)));
                    }
                    cursor.close();
                } catch (Exception e5) {
                    e = e5;
                    cursor2 = cursor;
                    e.printStackTrace();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return new JSONArray(arrayList).toString();
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
                return new JSONArray(arrayList).toString();
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(String str) {
                super.onPostExecute((AnonymousClass3) str);
                RequestManager.getInstance(PredictManager.mContext).uploadUserInfo(str, j4);
                PredictManager.this.deleteOldAwarenessData(i4, j4);
            }
        }.execute(new PersonaDataItem[0]);
    }

    private void registerReceivers(Context context) {
        AppInstallReceiver.addListener(this.mAppInstallListener);
    }

    private void sortPredictResult(List<String> list, int i4, long j4) {
        PackageRecord packageRecord = this.mNewlyInstalledApp;
        if (packageRecord != null) {
            if (!packageRecord.isNewApp(j4)) {
                this.mNewlyInstalledApp = null;
            } else if (list.contains(this.mNewlyInstalledApp.pkgName)) {
                list.remove(this.mNewlyInstalledApp.pkgName);
                list.add(0, this.mNewlyInstalledApp.pkgName);
            } else {
                if (list.size() >= i4) {
                    list.remove(list.size() - 1);
                }
                list.add(0, this.mNewlyInstalledApp.pkgName);
            }
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (!isAppOnLauncher(str)) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            list.remove((String) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void train(List<String> list, boolean z4) {
        try {
            StringBuilder sb = new StringBuilder("train start. rawDataList.size=");
            sb.append(list != null ? list.size() : 0);
            sb.append(", trainAll=");
            sb.append(z4);
            AlphaMeLogger.iLog(sb.toString());
            getModelPath();
            createModelDirAndCopyOldIfNeed();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void trainRecent(boolean z4) {
        ArrayList<AppRecord> arrayList = this.mAppRecords.get();
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<String> list = this.mToTrainList;
        if (z4 || jCurrentTimeMillis - this.mLastRecentTrainTime >= 60000) {
            AlphaMeLogger.dLog("trainRecent begin appRecords.size = " + arrayList.size() + ", toTrainList.size = " + list.size());
            if (z4 && list.size() > 0) {
                for (int iMax = Math.max(list.size() - 50, 0); iMax < list.size(); iMax++) {
                    AlphaMeLogger.dLog(list.get(iMax).toString());
                }
            }
            train(list, false);
            this.mLastRecentTrainTime = jCurrentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHomeApps(Context context) {
        this.mLauncherApps.clear();
        this.mUnAvailableApps.clear();
        PackageManager packageManager = context.getPackageManager();
        List arrayList = new ArrayList();
        this.mHomeApps.clear();
        try {
            arrayList = LargeBinderTransactionHelper.getHomeApplications(packageManager);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            String str = ((ResolveInfo) arrayList.get(i4)).activityInfo.packageName;
            if (!EngineContract.SETTING_PACKAGE_NAME.equals(str)) {
                this.mUnAvailableApps.add(str);
                this.mHomeApps.add(str);
            }
        }
        this.mUnAvailableApps.add("");
        this.mUnAvailableApps.add("android");
        this.mUnAvailableApps.add("com.android.systemui");
        this.mUnAvailableApps.add("com.stepos.net.search");
        this.mUnAvailableApps.add("com.android.incallui");
        this.mUnAvailableApps.add("com.android.packageinstaller");
        this.mUnAvailableApps.add("com.stepos.onemind");
        this.mUnAvailableApps.add("com.android.phone");
        this.mUnAvailableApps.add("com.android.stk");
        this.mUnAvailableApps.add("com.stepos.update");
        this.mLauncherApps.addAll(this.mUnAvailableApps);
        this.mLauncherApps.add("com.stepos.appstore");
    }

    public void checkUploadInfo() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - Property.getLastUploadTime() < 86400000) {
            return;
        }
        Property.setLastUploadTime(jCurrentTimeMillis);
        String str = Build.DISPLAY;
        RequestManager.getInstance(mContext).requestUploadInfo(AppUtils.getAppVersion(mContext), str, DeviceInfoKt.getOaid(), new ResponseListener<UploadInfoBean>() { // from class: com.stepos.alphame.predict.PredictManager.2
            @Override // com.stepos.alphame.request.ResponseListener
            public void onFailed(int i4, Exception exc) {
            }

            @Override // com.stepos.alphame.request.ResponseListener
            public void onSuccess(int i4, UploadInfoBean uploadInfoBean) {
                AlphaMeLogger.dLog("checkUploadInfo " + uploadInfoBean);
                if (uploadInfoBean.getUpload() == 1) {
                    PredictManager.this.postAwarenessIfNeed(uploadInfoBean.getRecord(), jCurrentTimeMillis);
                } else {
                    PredictManager.this.deleteOldAwarenessData(uploadInfoBean.getRecord(), jCurrentTimeMillis);
                }
            }
        });
    }

    public void clearPredeictInfo() {
        mContext.getSharedPreferences(TimetableTracker.PREF_NAME, 0).edit().putString("predictRecord", null).apply();
        this.mPredictRecord = null;
    }

    public String formatPkgName(String str) {
        return (str == null || !str.contains(AwarenessDataItem.USERID_SPLITTER)) ? str : str.split(AwarenessDataItem.USERID_SPLITTER)[0];
    }

    public String getChangeLog() {
        return "onemindml disabled";
    }

    public String getModelDir() {
        return mContext.getFilesDir().getAbsolutePath() + "/predictApp";
    }

    public String getPredictInfo() {
        return getPredictRecord().toString();
    }

    public void initRecentPredict() throws Throwable {
        AlphaMeLogger.iLog("initRecentPredict");
        this.mAppOnLauncher = queryOnLauncherApps();
        updateHomeApps(mContext);
        createModelDirAndCopyOldIfNeed();
        initAppRecords(1000, false);
        AlphaMeLogger.iLog("trainRecent end. onemindml disabled");
    }

    public boolean isAppOnLauncher(String str) {
        if (this.mAppOnLauncher.contains(str)) {
            return true;
        }
        if (str.endsWith(this.mUserIdPrefix) && this.mAppOnLauncher.contains(str.substring(0, str.length() - this.mUserIdPrefix.length()))) {
            return true;
        }
        if (!str.endsWith(this.mUserIdPrefix)) {
            List<String> list = this.mAppOnLauncher;
            StringBuilder sbS = g.s(str);
            sbS.append(this.mUserIdPrefix);
            if (list.contains(sbS.toString())) {
                return true;
            }
        }
        return isQuickApp(str);
    }

    public boolean isAvailable(String str) {
        return !this.mUnAvailableApps.contains(str);
    }

    public boolean isHome(String str) {
        return this.mHomeApps.contains(str);
    }

    public boolean isLauncherApp(String str) {
        return this.mLauncherApps.contains(formatPkgName(str));
    }

    public String loadPredictInfo() {
        return mContext.getSharedPreferences(TimetableTracker.PREF_NAME, 0).getString("predictRecord", null);
    }

    public void newRecordAndTest(int i4, int i5, String str, int i6, String str2, long j4) {
        if (isAppRecordInitializing() || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            addAppRecord(str2, j4, "-1", str, i5, TimetableTracker.getInstance().getPowerState(), TimetableTracker.getInstance().getDayOff(), TimetableTracker.getInstance().getBlueConnected(), TimetableTracker.getInstance().getHeadSetPlugedIn());
        } catch (Exception e4) {
            Log.d("AlphaMe", "", e4);
        }
    }

    public List<String> predictApp(int i4, boolean z4, long j4) {
        AlphaMeLogger.iLog("predictApp kbest=" + i4 + " (onemindml disabled, using defaults)");
        ArrayList arrayList = new ArrayList();
        fillDefaultApps(arrayList, i4);
        sortPredictResult(arrayList, i4, j4);
        if (z4) {
            arrayList.add("----------------------");
            arrayList.add("onemindml disabled");
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public List<String> queryOnLauncherApps() {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = mContext.getPackageManager();
        List<ResolveInfo> installedApps = AppUtils.getInstalledApps(mContext);
        for (int i4 = 0; i4 < installedApps.size(); i4++) {
            String str = installedApps.get(i4).activityInfo.packageName;
            if (getPackageRecord(packageManager, str) != null) {
                arrayList.add(str);
            }
        }
        try {
            Iterator<String> it = PerfBinderHelper.getInstalledPackagesAsUser(UserHandle.STEPOS_PARALLEL_SPACE_USER_ID, 1).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next() + AwarenessDataItem.USERID_SPLITTER + UserHandle.STEPOS_PARALLEL_SPACE_USER_ID);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return arrayList;
    }

    public String savePredictRecord(boolean z4) {
        PredictRecord predictRecord = this.mPredictRecord;
        return predictRecord != null ? predictRecord.savePredictRecord(mContext, z4) : "null";
    }

    public void trainAll(boolean z4) {
        AlphaMeLogger.iLog("trainAll force = " + z4);
        new TrainAllTask(z4).execute(new Void[0]);
    }

    public void trainIfNeed(PersonaDataItem personaDataItem, long j4, long j5) {
        AlphaMeLogger.dLog("trainIfNeed lastTrain = " + StringUtil.formatDateFull(Property.getLastFullTrainTime()) + ", now = " + StringUtil.formatDateFull(j5) + ", lastScreenOffTime = " + StringUtil.formatDateFull(j4) + ", isCharging = " + PowerEngine.getInstance(mContext).isCharging() + ", level = " + PowerEngine.getInstance(mContext).getPowerLevel());
    }

    public void uploadLocationRecord() {
        LocationEngine.getInstance(mContext).uploadLocationRecord();
    }

    public String uploadPickerSwitchState() {
        Intent intent = new Intent("com.stepos.picker.action.service.HANDLE_CONTENT");
        intent.setPackage(CutImageHelper.PACKAGE_NAME_PICKER);
        int i4 = ApplicationImpl.getApplication().getPackageManager().resolveService(intent, 0) != null ? 1 : 0;
        HashMap map = new HashMap();
        map.put(UsageStatsUtils.KEY_SWITCH, String.valueOf(i4));
        UsageStatsUtils.onEvent(UsageStatsUtils.EVENT_PICKER_SWITCH, null, map);
        int i5 = Settings.System.getInt(mContext.getContentResolver(), PICKER_RESULT_CONFIRM_TIME, 500);
        HashMap map2 = new HashMap();
        map2.put(UsageStatsUtils.KEY_WAY, String.valueOf(i5));
        UsageStatsUtils.onEvent(UsageStatsUtils.EVENT_PICKER_WAY, null, map2);
        int i6 = Settings.System.getInt(mContext.getContentResolver(), PICKER_WINDOW_MODE_ENABLE, 0);
        HashMap map3 = new HashMap();
        map3.put(UsageStatsUtils.KEY_SWITCH, String.valueOf(i6));
        UsageStatsUtils.onEvent(UsageStatsUtils.EVENT_PICKER_SMALL_WINDOW, null, map3);
        return "switch = " + i4 + ", way = " + i5 + ", smallWindow = " + i6;
    }

    public void uploadPredictRecord() {
        PredictRecord predictRecord = this.mPredictRecord;
        if (predictRecord != null) {
            predictRecord.uploadPredictRecord(mContext);
        }
    }
}
