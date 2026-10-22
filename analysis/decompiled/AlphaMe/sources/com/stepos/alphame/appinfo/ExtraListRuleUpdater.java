package com.stepos.alphame.appinfo;

import B0.g;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.scene.SceneDetectorEngine;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.FileUtil;
import com.stepos.alphame.utils.HttpRequestHelper;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ExtraListRuleUpdater {
    public static boolean doFullUpdate(String str) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        String str2 = AppInfoDbHelper.DATABASE_PATH;
        String strR = g.r(sb, str2, "update/extralist.zip");
        File file = new File(AbstractC0351g.p(str2, "update/"));
        if (!file.exists()) {
            file.mkdir();
        }
        boolean z4 = false;
        if (HttpRequestHelper.downloadFile(str, strR)) {
            AppInfoDbHelper appInfoDbHelper = AppInfoDbHelper.getInstance();
            SQLiteDatabase writableDatabase = appInfoDbHelper.getWritableDatabase();
            writableDatabase.beginTransaction();
            FileInputStream fileInputStream = null;
            try {
                FileUtil.unzipFile(strR, str2 + "update/");
                FileInputStream fileInputStream2 = new FileInputStream(new File(str2 + "update/commonwhitelists.db"));
                try {
                    appInfoDbHelper.clearExtra(writableDatabase);
                    inputStreamReader = new InputStreamReader(fileInputStream2);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        try {
                            AlphaMeLogger.iLog("#extra#update#begin ");
                            while (true) {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                JSONObject jSONObject = new JSONObject(line);
                                sQLiteDatabase = writableDatabase;
                                bufferedReader = bufferedReader2;
                                try {
                                    appInfoDbHelper.insertExtra(writableDatabase, jSONObject.getString("fkey"), jSONObject.getString("fremark"), jSONObject.getInt("flevel1"), jSONObject.getInt("flevel2"), jSONObject.getLong("fctime"), jSONObject.getLong("futime"), false);
                                    writableDatabase = sQLiteDatabase;
                                    bufferedReader2 = bufferedReader;
                                } catch (Exception e4) {
                                    e = e4;
                                    fileInputStream = fileInputStream2;
                                    try {
                                        AlphaMeLogger.exceptionLog("UPDATEException", e);
                                        Utils.closeSilently(fileInputStream);
                                        Utils.closeSilently(inputStreamReader);
                                        Utils.closeSilently(bufferedReader);
                                        sQLiteDatabase.endTransaction();
                                        return z4;
                                    } catch (Throwable th) {
                                        th = th;
                                        Utils.closeSilently(fileInputStream);
                                        Utils.closeSilently(inputStreamReader);
                                        Utils.closeSilently(bufferedReader);
                                        sQLiteDatabase.endTransaction();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    Utils.closeSilently(fileInputStream);
                                    Utils.closeSilently(inputStreamReader);
                                    Utils.closeSilently(bufferedReader);
                                    sQLiteDatabase.endTransaction();
                                    throw th;
                                }
                            }
                            sQLiteDatabase = writableDatabase;
                            bufferedReader = bufferedReader2;
                            z4 = true;
                            sQLiteDatabase.setTransactionSuccessful();
                            SceneDetectorEngine.getInstance().clearExtraCache();
                            AlphaMeLogger.iLog("#extra#update#end");
                            Utils.closeSilently(fileInputStream2);
                        } catch (Exception e5) {
                            e = e5;
                            sQLiteDatabase = writableDatabase;
                            bufferedReader = bufferedReader2;
                        } catch (Throwable th3) {
                            th = th3;
                            sQLiteDatabase = writableDatabase;
                            bufferedReader = bufferedReader2;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        sQLiteDatabase = writableDatabase;
                        bufferedReader = null;
                    } catch (Throwable th4) {
                        th = th4;
                        sQLiteDatabase = writableDatabase;
                        bufferedReader = null;
                    }
                } catch (Exception e7) {
                    e = e7;
                    sQLiteDatabase = writableDatabase;
                    inputStreamReader = null;
                    bufferedReader = null;
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = writableDatabase;
                    inputStreamReader = null;
                    bufferedReader = null;
                }
            } catch (Exception e8) {
                e = e8;
                sQLiteDatabase = writableDatabase;
                inputStreamReader = null;
                bufferedReader = null;
            } catch (Throwable th6) {
                th = th6;
                sQLiteDatabase = writableDatabase;
                inputStreamReader = null;
                bufferedReader = null;
            }
            Utils.closeSilently(inputStreamReader);
            Utils.closeSilently(bufferedReader);
            sQLiteDatabase.endTransaction();
        } else {
            AlphaMeLogger.wLog("extra update download failed");
        }
        return z4;
    }

    public void update(String str, String str2, boolean z4) {
        ApplicationImpl.getApplication();
        if (!z4) {
            AlphaMeLogger.dLog("ExtraListRuleUpdater not wifi env");
            return;
        }
        try {
            AlphaMeLogger.dLog("ExtraListRuleUpdater update szUrl = " + str2 + ", szVer = " + str + ", Property.getLastExtraUpdateVersion() = " + Property.getLastExtraUpdateVersion());
            boolean zEquals = TextUtils.equals(str, Property.getLastExtraUpdateVersion());
            if (TextUtils.isEmpty(str2) || zEquals || !doFullUpdate(str2)) {
                return;
            }
            Property.setLastExtraUpdateVersion(str);
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("ExtraListRuleUpdater update error", e4);
        }
    }
}
