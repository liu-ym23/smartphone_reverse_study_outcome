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
public class ActivityInfoRuleUpdater {
    public static boolean doFullUpdate(String str) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        int i4;
        StringBuilder sb = new StringBuilder();
        String str2 = AppInfoDbHelper.DATABASE_PATH;
        String strR = g.r(sb, str2, "update/activityupdate.zip");
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
                FileInputStream fileInputStream2 = new FileInputStream(new File(str2 + "update/activityupdate.db"));
                try {
                    appInfoDbHelper.clearActivityInfo(writableDatabase);
                    inputStreamReader = new InputStreamReader(fileInputStream2);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            try {
                                AlphaMeLogger.iLog("#acitvity#update#begin ");
                                while (true) {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    JSONObject jSONObject = new JSONObject(line);
                                    String string = jSONObject.getString(AppInfoDbHelper.TAG_PACKAGE_NAME);
                                    String string2 = jSONObject.getString("activityName");
                                    try {
                                        i4 = Integer.parseInt(jSONObject.getString("permissionValue"));
                                    } catch (Exception e4) {
                                        AlphaMeLogger.exceptionLog("Exception", e4);
                                        i4 = -1;
                                    }
                                    appInfoDbHelper.insertActivity(writableDatabase, string, string2, jSONObject.getLong("permissionId"), i4, false);
                                }
                                z4 = true;
                                inputStreamReader.close();
                                bufferedReader.close();
                                writableDatabase.setTransactionSuccessful();
                                SceneDetectorEngine.getInstance().clearActivityCache();
                                AlphaMeLogger.iLog("#acitvity#update#end");
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
                                } catch (Throwable th) {
                                    th = th;
                                    Utils.closeSilently(fileInputStream);
                                    Utils.closeSilently(inputStreamReader);
                                    Utils.closeSilently(bufferedReader);
                                    writableDatabase.endTransaction();
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            Utils.closeSilently(fileInputStream);
                            Utils.closeSilently(inputStreamReader);
                            Utils.closeSilently(bufferedReader);
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (Exception e7) {
                    e = e7;
                    inputStreamReader = null;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                    bufferedReader = null;
                }
            } catch (Exception e8) {
                e = e8;
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
            AlphaMeLogger.wLog("activity update download failed");
        }
        return z4;
    }

    public void update(String str, String str2, boolean z4) {
        ApplicationImpl.getApplication();
        if (!z4) {
            AlphaMeLogger.dLog("ActivityInfoRuleUpdater not wifi env");
            return;
        }
        try {
            AlphaMeLogger.dLog("ActivityInfoRuleUpdater update szUrl = " + str2 + ", szVer = " + str + ", Property.getLastActivityUpdateVersion() = " + Property.getLastActivityUpdateVersion());
            boolean zEquals = TextUtils.equals(str, Property.getLastActivityUpdateVersion());
            if (TextUtils.isEmpty(str2) || zEquals || !doFullUpdate(str2)) {
                return;
            }
            Property.setLastActivityUpdateVersion(str);
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("ActivityInfoRuleUpdater update error", e4);
        }
    }
}
