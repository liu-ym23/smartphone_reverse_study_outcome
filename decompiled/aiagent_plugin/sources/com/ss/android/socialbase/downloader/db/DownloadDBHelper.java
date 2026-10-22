package com.ss.android.socialbase.downloader.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadDBHelper extends SQLiteOpenHelper {
    private static volatile DownloadDBHelper instance;
    private final String TAG;
    private boolean mIgnoreDuplicateColumn;
    private boolean tempDirSetted;

    public static DownloadDBHelper getInstance() {
        if (instance != null) goto L15;
        monitor-enter(DownloadDBHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DownloadDBHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadDBHelper.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private DownloadDBHelper() {
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), DBDefinition.DATABASE_NAME, null, 19);
        this.TAG = "DownloadDBHelper";
        this.tempDirSetted = false;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (this.tempDirSetted == true) goto L15;
        if (r0 == null) goto L15;
        File r1 = new File("/data/data/" + r0.getPackageName() + "/database/main/");     // Catch: Exception -> L10
        if (r1.exists() == true) goto L8;
        r1.mkdir();     // Catch: Exception -> L10
    L8:
        super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = tempDir");     // Catch: Exception -> L10
        this.tempDirSetted = true;     // Catch: Exception -> L10
    L13:
        return super.getReadableDatabase();
    L10:
        e = move-exception;
        e.printStackTrace();
        Logger.globalError("DownloadDBHelper", "getReadableDatabase", "Error:" + e);
    L15:
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r3) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug("DownloadDBHelper", "onCreate", "Run");
    L5:
        r3.execSQL(DBDefinition.CREATE_DOWNLOAD_TABLE);
        r3.execSQL(DBDefinition.CREATE_SEGMENT_TABLE);
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug("DownloadDBHelper", "onCreate", "Run End");
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase r2) {
        super.onConfigure(r2);
        if (Build.VERSION.SDK_INT != 28) goto L6;
        r2.disableWriteAheadLogging();
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r5, int r6, int r7) {
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug("DownloadDBHelper", "onUpgrade", "Run OldVersion: " + r6 + " newVersion: " + r7);
    L16:
        onUpgradeImpl(r5, r6, r7);     // Catch: Throwable -> L7
    L12:
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug("DownloadDBHelper", "onUpgrade", "Run End");
        return;
    L18:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError("DownloadDBHelper", "onUpgrade", "Error:" + th);
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SQLITE_UPGRADE_FAIL_DROP_TABLE) <= 0) goto L15;
        dropAndCreateDBTable(r5);
        goto L12
    L15:
        throw th;
    }

    private void onUpgradeImpl(SQLiteDatabase r3, int r4, int r5) {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SQLITE_UPGRADE_IGNORE_DUPLICATE_COLUMN) <= 0) goto L5;
        boolean r0 = true;
    L6:
        this.mIgnoreDuplicateColumn = r0;
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug("DownloadDBHelper", "onUpgradeImpl", "OldVersion: " + r4 + " newVersion: " + r5 + " ignoreDuplicateColumn:" + this.mIgnoreDuplicateColumn);
    L9:
        switch(r4) {
            case 1: goto L11;
            case 2: goto L12;
            case 3: goto L13;
            case 4: goto L14;
            case 5: goto L15;
            case 6: goto L16;
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L18;
            case 10: goto L19;
            case 11: goto L20;
            case 12: goto L21;
            case 13: goto L22;
            case 14: goto L23;
            case 15: goto L24;
            case 16: goto L25;
            case 17: goto L26;
            case 18: goto L27;
            default: goto L29;
        };
    L11:
        addItem(r3, "mimeType TEXT");
        addItem(r3, "title TEXT");
        addItem(r3, "notificationEnable INTEGER");
        addItem(r3, "notificationVisibility INTEGER");
    L12:
        addItem(r3, "isFirstDownload INTEGER");
    L13:
        addItem(r3, "isFirstSuccess INTEGER");
    L14:
        addItem(r3, "needHttpsToHttpRetry INTEGER");
        addItem(r3, "downloadTime INTEGER");
    L15:
        addItem(r3, "packageName TEXT");
        addItem(r3, "md5 TEXT");
    L16:
        addItem(r3, "retryDelay INTEGER");
        addItem(r3, "curRetryTime INTEGER");
        addItem(r3, "retryDelayStatus INTEGER");
        addItem(r3, "defaultHttpServiceBackUp INTEGER");
    L17:
        addItem(r3, "chunkRunnableReuse INTEGER");
    L18:
        addItem(r3, "retryDelayTimeArray TEXT");
    L19:
        addItem(r3, "chunkDowngradeRetry INTEGER");
        addItem(r3, "backUpUrlsStr TEXT");
        addItem(r3, "backUpUrlRetryCount INTEGER");
        addItem(r3, "realDownloadTime INTEGER");
        addItem(r3, "retryScheduleMinutes INTEGER");
        addItem(r3, "independentProcess INTEGER");
    L20:
        addItem(r3, "auxiliaryJsonobjectString TEXT");
    L21:
        addItem(r3, "iconUrl TEXT");
        addItem(r3, "appVersionCode INTEGER");
    L22:
        r3.execSQL(DBDefinition.CREATE_SEGMENT_TABLE);
    L23:
        addItem(r3, "taskId TEXT");
    L24:
        addItem(r3, "downloadStartTimeStamp INTEGER");
        addItem(r3, "downloadFinishTimeStamp INTEGER");
        addItem(r3, "installedTimeStamp INTEGER");
        addItem(r3, "hasDoInstallation INTEGER");
    L25:
        addItem(r3, "cacheLifeTimeMax INTEGER");
    L26:
        addItem(r3, "pcdnUrlsStr TEXT");
        addItem(r3, "cdnUrlsStr TEXT");
    L27:
        addItem(r3, "backCurBytes INTEGER");
        addItem(r3, "realBackDownloadTime INTEGER");
        return;
    L29:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void addItem(SQLiteDatabase r3, String r4) {
        r3.execSQL("ALTER TABLE downloader ADD " + r4);     // Catch: SQLException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        Logger.globalError("DownloadDBHelper", "addItem", "Error:" + e);
        if (this.mIgnoreDuplicateColumn == false) goto L14;
        String r2 = e.getMessage();
        if (TextUtils.isEmpty(r2) == false) goto L10;
    L13:
        throw e;
    L10:
        if (r2.contains("duplicate column") == false) goto L13;
        Logger.globalError("DownloadDBHelper", "addItem", "duplicate column");
        return;
    L14:
        throw e;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r3, int r4, int r5) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug("DownloadDBHelper", "onDowngrade", "OldVersion: " + r4 + " newVersion: " + r5);
    L6:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SUPPORT_SQLITE_DOWNGRADE) <= 0) goto L9;
        dropAndCreateDBTable(r3);
        return;
    }

    private void dropAndCreateDBTable(SQLiteDatabase r6) {
        if (Logger.debug() == false) goto L13;
        Logger.globalError("DownloadDBHelper", "dropAndCreateDBTable", "Run");
    L13:
        r6.execSQL(DBDefinition.DROP_DOWNLOAD_TABLE);     // Catch: Throwable -> L7
        r6.execSQL(DBDefinition.DROP_SEGMENT_TABLE);     // Catch: Throwable -> L7
    L9:
        onCreate(r6);
        if (Logger.debug() == false) goto L15;
        Logger.globalError("DownloadDBHelper", "dropAndCreateDBTable", "Run End");
        return;
    L15:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError("DownloadDBHelper", "dropAndCreateDBTable", "Error: " + th);
        goto L9
    }
}
