package com.stepos.alphame.appinfo;

import B0.g;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.room.AbstractC0351g;
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
public class UnboundedListRuleUpdater {
    public static boolean doFullUpdate(String str) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        String str2 = AppInfoDbHelper.DATABASE_PATH;
        String strR = g.r(sb, str2, "update/unbounded_list.zip");
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
                FileInputStream fileInputStream2 = new FileInputStream(new File(str2 + "update/unbounded_list.db"));
                try {
                    appInfoDbHelper.clearUnboundedApps(writableDatabase);
                    inputStreamReader = new InputStreamReader(fileInputStream2);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (Exception e4) {
                        e = e4;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                    }
                    try {
                        AlphaMeLogger.iLog("#unbounded#update#begin ");
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(line);
                            appInfoDbHelper.insertOrUpdateUnboundedApp(writableDatabase, jSONObject.getString(AppInfoDbHelper.TAG_U_PACKAGE_NAME), jSONObject.getString("appName"), jSONObject.getString("category"), false);
                        }
                        z4 = true;
                        inputStreamReader.close();
                        bufferedReader.close();
                        writableDatabase.setTransactionSuccessful();
                        SceneDetectorEngine.getInstance().clearActivityCache();
                        AlphaMeLogger.iLog("#unbounded#update#end");
                        Utils.closeSilently(fileInputStream2);
                    } catch (Exception e5) {
                        e = e5;
                        fileInputStream = fileInputStream2;
                        try {
                            AlphaMeLogger.exceptionLog("UPDATEException", e);
                            Utils.closeSilently(fileInputStream);
                            Utils.closeSilently(inputStreamReader);
                            Utils.closeSilently(bufferedReader);
                            writableDatabase.endTransaction();
                            return z4;
                        } catch (Throwable th2) {
                            th = th2;
                            Utils.closeSilently(fileInputStream);
                            Utils.closeSilently(inputStreamReader);
                            Utils.closeSilently(bufferedReader);
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        Utils.closeSilently(fileInputStream);
                        Utils.closeSilently(inputStreamReader);
                        Utils.closeSilently(bufferedReader);
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                    inputStreamReader = null;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                    bufferedReader = null;
                }
            } catch (Exception e7) {
                e = e7;
                inputStreamReader = null;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
                bufferedReader = null;
            }
            Utils.closeSilently(inputStreamReader);
            Utils.closeSilently(bufferedReader);
            writableDatabase.endTransaction();
        } else {
            AlphaMeLogger.wLog("unbounded update download failed");
        }
        return z4;
    }

    public void update(String str, String str2, boolean z4) {
        if (!z4) {
            AlphaMeLogger.dLog("UnboundedListRuleUpdater not wifi env");
            return;
        }
        try {
            AlphaMeLogger.dLog("UnboundedListRuleUpdater update szUrl = " + str2 + ", szVer = " + str + ", Property.getLastUnboundedUpdateVersion() = " + Property.getLastUnboundedUpdateVersion());
            boolean zEquals = TextUtils.equals(str, Property.getLastUnboundedUpdateVersion());
            if (TextUtils.isEmpty(str2) || zEquals || !doFullUpdate(str2)) {
                return;
            }
            Property.setLastUnboundedUpdateVersion(str);
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("UnboundedListRuleUpdater update error", e4);
        }
    }
}
