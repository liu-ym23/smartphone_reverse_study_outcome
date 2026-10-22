package com.stepos.alphame.notification;

import android.text.TextUtils;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.FileUtil;
import com.stepos.alphame.utils.HttpRequestHelper;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NotiRuleUpdater {
    public NotiRuleUpdater() throws Throwable {
        loadWhitelist();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    private void loadWhitelist() throws Throwable {
        FileInputStream fileInputStream;
        ?? line;
        NotiPredictManager notiPredictManager = NotiPredictManager.getInstance();
        if (notiPredictManager.isWhitelistEmpty()) {
            ?? file = new File(NotiPredictor.getWlUnzipFileFullPath());
            if (file.exists()) {
                BufferedReader bufferedReader = null;
                bufferedReader = null;
                bufferedReader = null;
                bufferedReader = null;
                BufferedReader bufferedReader2 = null;
                bufferedReader = null;
                try {
                    try {
                        fileInputStream = new FileInputStream((File) file);
                        try {
                            notiPredictManager.clearWhitelist();
                            file = new InputStreamReader(fileInputStream);
                            try {
                                BufferedReader bufferedReader3 = new BufferedReader(file);
                                while (true) {
                                    try {
                                        line = bufferedReader3.readLine();
                                        if (line == 0) {
                                            break;
                                        }
                                        JSONObject jSONObject = new JSONObject((String) line);
                                        String string = jSONObject.getString("tag");
                                        String[] strArrSplit = jSONObject.getString("words").split(AwarenessDataItem.PERMISSION_SPLITTER);
                                        notiPredictManager.addWhitelist(string, strArrSplit);
                                        AlphaMeLogger.dLog("addWhitelist " + string + AwarenessDataItem.PERMISSION_SPLITTER + Arrays.toString(strArrSplit));
                                    } catch (Exception e4) {
                                        e = e4;
                                        bufferedReader2 = bufferedReader3;
                                        AlphaMeLogger.exceptionLog("loadWhitelist", e);
                                        Utils.closeSilently(bufferedReader2);
                                        file = file;
                                        bufferedReader = bufferedReader2;
                                        Utils.closeSilently(file);
                                        Utils.closeSilently(fileInputStream);
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedReader = bufferedReader3;
                                        Utils.closeSilently(bufferedReader);
                                        Utils.closeSilently(file);
                                        Utils.closeSilently(fileInputStream);
                                        throw th;
                                    }
                                }
                                AlphaMeLogger.dLog("update whitelist end");
                                Utils.closeSilently(bufferedReader3);
                                file = file;
                                bufferedReader = line;
                            } catch (Exception e5) {
                                e = e5;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            file = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            file = 0;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    file = 0;
                    fileInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    file = 0;
                    fileInputStream = null;
                }
                Utils.closeSilently(file);
                Utils.closeSilently(fileInputStream);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:5:0x0014, B:7:0x0028, B:9:0x0038, B:18:0x004e, B:19:0x005a, B:14:0x0042, B:16:0x0048, B:20:0x005d, B:22:0x008b, B:24:0x0091, B:26:0x009b, B:28:0x00a5, B:30:0x00ba, B:31:0x00bd, B:32:0x00cc), top: B:36:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(org.json.JSONObject r9, boolean r10) throws org.json.JSONException {
        /*
            r8 = this;
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "NotiRuleUpdater update isWifi = "
            r8.<init>(r0)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            com.stepos.alphame.utils.AlphaMeLogger.dLog(r8)
            if (r10 != 0) goto L14
            return
        L14:
            java.lang.String r8 = "packs"
            org.json.JSONArray r8 = r9.getJSONArray(r8)     // Catch: java.lang.Exception -> L3f
            int r9 = r8.length()     // Catch: java.lang.Exception -> L3f
            java.lang.String r10 = android.os.Build.MODEL     // Catch: java.lang.Exception -> L3f
            java.lang.String r0 = "all"
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = r2
        L26:
            if (r4 >= r9) goto L5d
            org.json.JSONObject r5 = r8.getJSONObject(r1)     // Catch: java.lang.Exception -> L3f
            java.lang.String r6 = "type"
            java.lang.String r6 = r5.getString(r6)     // Catch: java.lang.Exception -> L3f
            boolean r7 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Exception -> L3f
            if (r7 != 0) goto L42
            boolean r7 = r10.equals(r6)     // Catch: java.lang.Exception -> L3f
            if (r7 != 0) goto L4e
            goto L42
        L3f:
            r8 = move-exception
            goto Ld2
        L42:
            boolean r6 = r0.equals(r6)     // Catch: java.lang.Exception -> L3f
            if (r6 == 0) goto L5a
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L3f
            if (r6 == 0) goto L5a
        L4e:
            java.lang.String r2 = "url"
            java.lang.String r2 = r5.getString(r2)     // Catch: java.lang.Exception -> L3f
            java.lang.String r3 = "ver"
            java.lang.String r3 = r5.getString(r3)     // Catch: java.lang.Exception -> L3f
        L5a:
            int r4 = r4 + 1
            goto L26
        L5d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3f
            r8.<init>()     // Catch: java.lang.Exception -> L3f
            java.lang.String r9 = "NotiRuleUpdater update szUrl = "
            r8.append(r9)     // Catch: java.lang.Exception -> L3f
            r8.append(r2)     // Catch: java.lang.Exception -> L3f
            java.lang.String r9 = ", szVer = "
            r8.append(r9)     // Catch: java.lang.Exception -> L3f
            r8.append(r3)     // Catch: java.lang.Exception -> L3f
            java.lang.String r9 = ", Property.getNotiVersion() = "
            r8.append(r9)     // Catch: java.lang.Exception -> L3f
            java.lang.String r9 = com.stepos.alphame.utils.Property.getNotiVersion()     // Catch: java.lang.Exception -> L3f
            r8.append(r9)     // Catch: java.lang.Exception -> L3f
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L3f
            com.stepos.alphame.utils.AlphaMeLogger.dLog(r8)     // Catch: java.lang.Exception -> L3f
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L3f
            if (r8 != 0) goto Ld5
            boolean r8 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L3f
            if (r8 != 0) goto Ld5
            java.lang.String r8 = com.stepos.alphame.utils.Property.getNotiVersion()     // Catch: java.lang.Exception -> L3f
            boolean r8 = r3.equals(r8)     // Catch: java.lang.Exception -> L3f
            if (r8 != 0) goto Ld5
            java.lang.String r8 = com.stepos.alphame.notification.NotiPredictor.getSzFileFullPath()     // Catch: java.lang.Exception -> L3f
            boolean r8 = com.stepos.alphame.utils.HttpRequestHelper.downloadFile(r2, r8)     // Catch: java.lang.Exception -> L3f
            if (r8 == 0) goto Lcc
            com.stepos.alphame.notification.NotiPredictManager r8 = com.stepos.alphame.notification.NotiPredictManager.getInstance()     // Catch: java.lang.Exception -> L3f
            r8.clearFiles()     // Catch: java.lang.Exception -> L3f
            java.lang.String r8 = com.stepos.alphame.notification.NotiPredictor.getSzFileFullPath()     // Catch: java.lang.Exception -> L3f
            java.lang.String r9 = com.stepos.alphame.notification.NotiPredictor.getSzPath()     // Catch: java.lang.Exception -> L3f
            boolean r8 = com.stepos.alphame.utils.FileUtil.unzipFile(r8, r9)     // Catch: java.lang.Exception -> L3f
            if (r8 == 0) goto Lbd
            com.stepos.alphame.utils.Property.setNotiVersion(r3)     // Catch: java.lang.Exception -> L3f
        Lbd:
            java.lang.String r8 = com.stepos.alphame.notification.NotiPredictor.getSzFileFullPath()     // Catch: java.lang.Exception -> L3f
            com.stepos.alphame.utils.FileUtil.deleteFile(r8)     // Catch: java.lang.Exception -> L3f
            com.stepos.alphame.notification.NotiPredictManager r8 = com.stepos.alphame.notification.NotiPredictManager.getInstance()     // Catch: java.lang.Exception -> L3f
            r8.init()     // Catch: java.lang.Exception -> L3f
            goto Ld5
        Lcc:
            java.lang.String r8 = "NotiRuleUpdater update download failed"
            com.stepos.alphame.utils.AlphaMeLogger.wLog(r8)     // Catch: java.lang.Exception -> L3f
            goto Ld5
        Ld2:
            r8.printStackTrace()
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.notification.NotiRuleUpdater.update(org.json.JSONObject, boolean):void");
    }

    public void updateWhitelist(String str, String str2) throws Throwable {
        AlphaMeLogger.dLog("NotiRuleUpdater updateWhitelist");
        try {
            AlphaMeLogger.dLog("NotiRuleUpdater updateWhitelist szUrl = " + str2 + ", szVer = " + str + ", Property.getNotiVersion() = " + Property.getNotiVersion());
            boolean zEquals = TextUtils.equals(str, Property.getNotiWhitelistVersion());
            if (!TextUtils.isEmpty(str2) && !zEquals) {
                AlphaMeLogger.dLog("NotiRuleUpdater updateWhitelist start download");
                if (HttpRequestHelper.downloadFile(str2, NotiPredictor.getWlZipFileFullPath())) {
                    AlphaMeLogger.dLog("NotiRuleUpdater updateWhitelist download successful");
                    FileUtil.unzipFile(NotiPredictor.getWlZipFileFullPath(), NotiPredictor.getSzPath());
                    NotiPredictManager.getInstance().clearWhitelist();
                    loadWhitelist();
                    Property.setNotiWhitelistVersion(str);
                } else {
                    AlphaMeLogger.wLog("NotiRuleUpdater updateWhitelist download failed");
                }
            }
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("updateWhitelist", e4);
        }
    }
}
