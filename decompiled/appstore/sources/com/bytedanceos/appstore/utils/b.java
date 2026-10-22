package com.bytedanceos.appstore.utils;

import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.appstore.model.Developer;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.model.AppComments;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.s;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends c9.a {
    public static Topic N(String r10) {
        Topic r11 = null;
        if (TextUtils.isEmpty(r10) == true) goto L39;
        JSONObject r12 = new JSONObject(r10).optJSONObject(ServerElements.BODY).optJSONObject("topic");     // Catch: Exception -> L32
        Topic r13 = new Topic();     // Catch: Exception -> L32
        String r14 = "";
        if (r12 != null) goto L37;
        String r15 = "";
    L11:
        r13.setId(r15);     // Catch: Exception -> L8
        if (r12 == null) goto L14;
        String r16 = r12.optString("type");     // Catch: Exception -> L8
    L15:
        r13.setType(r16);     // Catch: Exception -> L8
        if (r12 == null) goto L18;
        String r17 = r12.optString("name");     // Catch: Exception -> L8
    L19:
        r13.setTitle(r17);     // Catch: Exception -> L8
        if (r12 == null) goto L22;
        String r18 = r12.optString("package");     // Catch: Exception -> L8
    L23:
        r13.setPackageName(r18);     // Catch: Exception -> L8
        if (r12 == null) goto L26;
        String r19 = r12.optString(ServerElements.HEAD_BANNER);     // Catch: Exception -> L8
    L27:
        r13.setImageResUrl(r19);     // Catch: Exception -> L8
        if (r12 == null) goto L30;
        r14 = r12.optString(ServerElements.BRIEF);     // Catch: Exception -> L8
    L30:
        r13.setDescription(r14);     // Catch: Exception -> L8
        return r13;
    L8:
        e = e;
        r11 = r13;
    L33:
        e.printStackTrace();
        return r11;
    L26:
        r19 = "";
        goto L27
    L22:
        r18 = "";
        goto L23
    L18:
        r17 = "";
        goto L19
    L14:
        r16 = "";
        goto L15
    L37:
        r15 = r12.optString("id");     // Catch: Exception -> L8
    L32:
        e = e;
        goto L33
    L39:
        return null;
    }

    public static String Y(AppInfo r10) {
        if (r10 == null) goto L9;
        JSONObject r11 = new JSONObject();
        r11.put("id", r10.appId);     // Catch: JSONException -> L6
        r11.put("name", r10.appName);     // Catch: JSONException -> L6
        r11.put("package", r10.appPackageName);     // Catch: JSONException -> L6
        r11.put(ServerElements.IFCOLLECT, r10.isCollected ? 1 : 0);     // Catch: JSONException -> L6
        r11.put("version_code", r10.appVersionCode);     // Catch: JSONException -> L6
        r11.put(ServerElements.IFADD, r10.isNeededAdd);     // Catch: JSONException -> L6
        r11.put(ServerElements.IFDELETE, r10.isNeededDelete);     // Catch: JSONException -> L6
        r11.put("category", r10.appCategoryName);     // Catch: JSONException -> L6
        r11.put(ServerElements.LOGO, r10.appIcon);     // Catch: JSONException -> L6
        r11.put(ServerElements.SCORES, String.valueOf(r10.appScores));     // Catch: JSONException -> L6
        r11.put(ServerElements.DOWNLOAD_URL, r10.appDownloadUrl);     // Catch: JSONException -> L6
        r11.put(ServerElements.FILE_MD5, r10.fileMd5);     // Catch: JSONException -> L6
        r11.put(ServerElements.FILESIZE, r10.appBytes);     // Catch: JSONException -> L6
        r11.put("uid", AccountDataCache.b().k());     // Catch: JSONException -> L6
    L13:
        return r11.toString();
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L9:
        return null;
    }

    public static String Z(ArrayList r10) {
        JSONObject r11 = new JSONObject();
        JSONArray r12 = new JSONArray();
        r11.put("uid", AccountDataCache.b().k());     // Catch: JSONException -> L7
        Iterator r13 = r10.iterator();     // Catch: JSONException -> L7
    L5:
        if (r13.hasNext() == false) goto L9;
        AppInfo r14 = (AppInfo) r13.next();     // Catch: JSONException -> L7
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L7
        r15.put("id", r14.appId);     // Catch: JSONException -> L7
        r15.put("name", r14.appName);     // Catch: JSONException -> L7
        r15.put("package", r14.appPackageName);     // Catch: JSONException -> L7
        r15.put(ServerElements.IFCOLLECT, r14.isCollected ? 1 : 0);     // Catch: JSONException -> L7
        r15.put("version_code", r14.appVersionCode);     // Catch: JSONException -> L7
        r15.put(ServerElements.IFADD, r14.isNeededAdd);     // Catch: JSONException -> L7
        r15.put(ServerElements.IFDELETE, r14.isNeededDelete);     // Catch: JSONException -> L7
        r15.put("category", r14.appCategoryName);     // Catch: JSONException -> L7
        r15.put(ServerElements.LOGO, r14.appIcon);     // Catch: JSONException -> L7
        r15.put(ServerElements.SCORES, String.valueOf(r14.appScores));     // Catch: JSONException -> L7
        r15.put(ServerElements.DOWNLOAD_URL, r14.appDownloadUrl);     // Catch: JSONException -> L7
        r15.put(ServerElements.FILESIZE, r14.appBytes);     // Catch: JSONException -> L7
        r12.put(r15);     // Catch: JSONException -> L7
        goto L5
    L9:
        r11.put(ServerElements.BODY, r12);     // Catch: JSONException -> L7
        if (r12.length() != 0) goto L14;
        return "";
    L14:
        return r11.toString();
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Map a0(int r10, String r11, String r12) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return null;
    L6:
        LinkedHashMap r13 = new LinkedHashMap();
        JSONObject r14 = new JSONObject(r11);     // Catch: Exception -> L10
        JSONObject r15 = r14.optJSONObject(ServerElements.BODY);     // Catch: Exception -> L10
        JSONObject r16 = r14.optJSONObject(ServerElements.HEAD);     // Catch: Exception -> L10
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L10
        JSONArray r18 = r16.optJSONArray(ServerElements.CONTEXTDATA);     // Catch: Exception -> L10
        if (r18 == null) goto L12;
        r17.put(ServerElements.CONTEXTDATA, r18);     // Catch: Exception -> L10
    L12:
        JSONArray r19 = r15.optJSONArray("apps");     // Catch: Exception -> L10
        if (r19 != null) goto L15;
        return r13;
    L15:
        int r20 = 0;
    L16:
        if (r20 >= r19.length()) goto L27;
        JSONObject r21 = r19.optJSONObject(r20);     // Catch: Exception -> L10
        AppInfo r22 = d0(r10, r21);     // Catch: Exception -> L10
        if (com.bytedanceos.common.toolbox.e.E0(r22.appPackageName) == true) goto L21;
    L24:
        r22.mApiUrl = r12;     // Catch: Exception -> L10
        r13.put(r22.appPackageName, r22);     // Catch: Exception -> L10
    L25:
        r20 = r20 + 1;
        goto L16
    L21:
        if (s.b(r22.appPackageName) == true) goto L25;
        r22.appVersionCode = r21.optInt("version_code", 0) + 1;     // Catch: Exception -> L10
    L27:
        return r13;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }

    public static ArrayList b0(int r10, String r11, String r12) {
        ArrayList r13 = new ArrayList();
        if (d.b() == true) goto L25;
        j.n("[AutoUpdate] Not KSA Version, do not support SysApp auto update in appstore!!!");
        return r13;
    L25:
        JSONArray r14 = new JSONObject(r11).optJSONObject(ServerElements.BODY).optJSONArray(ServerElements.AUTO_UPDATE_APPS);     // Catch: Exception -> L15 JSONException -> L17
        if (r14 != null) goto L9;
        return r13;
    L9:
        int r15 = 0;
    L10:
        if (r15 >= r14.length()) goto L24;
        JSONObject r16 = r14.optJSONObject(r15);     // Catch: Exception -> L15 JSONException -> L17
        AppInfo r17 = d0(r10, r16);     // Catch: Exception -> L15 JSONException -> L17
        int r18 = r16.optInt("update_model", 3);     // Catch: Exception -> L15 JSONException -> L17
        j.a("update_model:" + r18);     // Catch: Exception -> L15 JSONException -> L17
        r17.mUpdateModel = r18;     // Catch: Exception -> L15 JSONException -> L17
        r17.mSysAppAutoUpdateTaskId = (long) r16.optInt("task_id", 0);     // Catch: Exception -> L15 JSONException -> L17
        r17.mSysAppAutoUpdateComplianceMode = r16.optInt("compliance_mode", 0);     // Catch: Exception -> L15 JSONException -> L17
        r17.appId = r16.optString("app_id", "");     // Catch: Exception -> L15 JSONException -> L17
        r17.appPackageName = r16.optString("package");     // Catch: Exception -> L15 JSONException -> L17
        r17.appVersionCode = r16.optInt("version_code", 0);     // Catch: Exception -> L15 JSONException -> L17
        r17.appVersionName = r16.optString(CommonKey.KEY_VERSION_NAME);     // Catch: Exception -> L15 JSONException -> L17
        r17.appDownloadUrl = r16.optString("url");     // Catch: Exception -> L15 JSONException -> L17
        r17.appState = 64;     // Catch: Exception -> L15 JSONException -> L17
        if (r18 != 4) goto L19;
        r17.appSource = "sys_app_silence_mobile";     // Catch: Exception -> L15 JSONException -> L17
    L20:
        r17.mApiUrl = r12;     // Catch: Exception -> L15 JSONException -> L17
        r17.trackerInfo = d9.a.a(d9.a.a(d9.a.a(d9.a.a(r17.trackerInfo, "Api-Url", r12), "Source-Pkg-Name", BaseApplication.c().getPackageName()), "Ifupdate", "1"), "Ifauto-Download", AdReportParam.ClickPosType.SKIP);     // Catch: Exception -> L15 JSONException -> L17
        r13.add(r17);     // Catch: Exception -> L15 JSONException -> L17
        r15 = r15 + 1;
        goto L10
    L19:
        r17.appSource = "sys_app_silence";     // Catch: Exception -> L15 JSONException -> L17
    L24:
        return r13;
    L17:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public static Developer c0(String r10) {
        Developer r11 = null;
        if (TextUtils.isEmpty(r10) == true) goto L19;
        JSONObject r12 = new JSONObject(r10).optJSONObject(ServerElements.BODY).optJSONObject(ServerElements.DEVELOPER);     // Catch: Exception -> L12
        if (r12 != null) goto L7;
        return null;
    L7:
        Developer r13 = new Developer();     // Catch: Exception -> L12
        r13.setDeverId(r12.optString(ServerElements.DEVER_ID));     // Catch: Exception -> L10
        r13.setDevName(r12.optString(ServerElements.DEV_NAME));     // Catch: Exception -> L10
        r13.setDevInfo(r12.optString(ServerElements.DEV_INFO));     // Catch: Exception -> L10
        r13.setDevBanner(r12.optString(ServerElements.DEV_BANNER));     // Catch: Exception -> L10
        return r13;
    L10:
        e = e;
        r11 = r13;
    L13:
        e.printStackTrace();
        return r11;
    L12:
        e = e;
        goto L13
    L19:
        return null;
    }

    public static AppInfo d0(int r10, JSONObject r11) {
        AppInfo r12 = new AppInfo();
        r12.appId = r11.optString("id");
        r12.appName = r11.optString("name");
        r12.appBytes = r11.optLong(ServerElements.FILESIZE);     // Catch: NumberFormatException -> L5
    L6:
        r12.appPackageName = r11.optString("package");
        r12.appCategoryName = r11.optString("category");
        r12.appVersionCode = r11.optInt("version_code", 0);
        r12.appVersionName = r11.optString("version");
        r12.appIcon = r11.optString(ServerElements.LOGO);
        r12.appDownloadUrl = r11.optString(ServerElements.DOWNLOAD_URL);
        r12.sha256 = r11.optString(ServerElements.SIGN);
        JSONArray r13 = r11.optJSONArray(ServerElements.DOWNLOAD_URL_BACKUPS);
        if (r13 != null) goto L9;
    L18:
        r12.mDmUrl = r11.optString(ServerElements.DM_URL);
        r12.mMemUrl = r11.optString(ServerElements.MEM_URL);
        if (r11.has(ServerElements.FILE_MD5) == false) goto L22;
        r12.fileMd5 = r11.optString(ServerElements.FILE_MD5);
    L26:
        if (r11.optString("from") == null) goto L29;
        r12.setFrom(r11.optString("from"));
    L29:
        if (TextUtils.isEmpty(r12.appDownloadUrl) == false) goto L53;
        r12.appDownloadUrl = r11.optString(ServerElements.APKFILE);
    L53:
        r12.appScores = Float.parseFloat(r11.optString(ServerElements.SCORES));     // Catch: NumberFormatException -> L33
    L35:
        if (r11.optInt(ServerElements.IFGMS, 0) != 1) goto L37;
        boolean r14 = true;
    L38:
        r12.mIsNeedGms = r14;
        if (TextUtils.equals(r11.optString("source", "local"), "local") == false) goto L41;
        r12.appSource = "local";
    L43:
        if (r10 != 600003) goto L46;
        r12.isCollected = true;
    L48:
        r12.mAppType = r11.optInt("soft_type", 0);
        if (r11.optString(ServerElements.OPERATIVE_TYPE) == null) goto L51;
        r12.setOperative(r11.optString(ServerElements.OPERATIVE_TYPE));
    L51:
        c9.a.T(r10, r12, r11.optJSONObject(ServerElements.DIFF_APK));
        return r12;
    L46:
        if (r10 != 600002) goto L48;
        r12.appState = 64;
        r12.mAppUpdateType = 2;
        goto L48
    L41:
        r12.appSource = AppInfo.SEARCH_SOURCE_EXTENAL;
        goto L43
    L37:
        r14 = false;
    L33:
        r12.appScores = 0.0f;
        goto L35
    L22:
        if (r11.has(ServerElements.MD5) == false) goto L24;
        r12.fileMd5 = r11.optString(ServerElements.MD5);
        goto L26
    L24:
        r12.fileMd5 = AppInfo.NO_MD5_KEY;
        goto L26
    L9:
        if (r13.length() <= 0) goto L18;
        ArrayList r15 = new ArrayList();
        int r16 = 0;
    L12:
        if (r16 >= r13.length()) goto L17;
        String r17 = r13.optString(r16, "");
        if (TextUtils.isEmpty(r17) == true) goto L16;
        r15.add(r17);
    L16:
        r16 = r16 + 1;
        goto L12
    L17:
        r12.appDownloadUrlBackups = r15;
    L5:
        r12.appBytes = 0;
        goto L6
    }

    public static Map e0(int r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return null;
    L6:
        LinkedHashMap r12 = new LinkedHashMap();
        JSONArray r13 = new JSONObject(r11).optJSONArray(ServerElements.BODY);     // Catch: Exception -> L18
        if (r13 != null) goto L10;
    L22:
        return r12;
    L10:
        if (r13.length() == 0) goto L22;
        int r14 = 0;
    L13:
        if (r14 >= r13.length()) goto L24;
        AppInfo r15 = d0(r10, r13.optJSONObject(r14));     // Catch: Exception -> L18
        if (TextUtils.equals(r15.appSource, "local") == true) goto L20;
        r15.appSource = "backup";     // Catch: Exception -> L18
    L20:
        r12.put(r15.appPackageName, r15);     // Catch: Exception -> L18
        r14 = r14 + 1;
    L24:
        return r12;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public static Topic f0(String r10) {
        Topic r11 = null;
        if (TextUtils.isEmpty(r10) == true) goto L35;
        JSONObject r12 = new JSONObject(r10).optJSONObject(ServerElements.BODY).optJSONObject("topic");     // Catch: Exception -> L28
        Topic r13 = new Topic();     // Catch: Exception -> L28
        String r14 = "";
        if (r12 != null) goto L31;
        String r15 = "";
    L11:
        r13.setId(r15);     // Catch: Exception -> L8
        if (r12 == null) goto L14;
        String r16 = r12.optString("type");     // Catch: Exception -> L8
    L15:
        r13.setType(r16);     // Catch: Exception -> L8
        if (r12 == null) goto L18;
        String r17 = r12.optString("name");     // Catch: Exception -> L8
    L19:
        r13.setTitle(r17);     // Catch: Exception -> L8
        if (r12 == null) goto L22;
        String r18 = r12.optString("package");     // Catch: Exception -> L8
    L23:
        r13.setPackageName(r18);     // Catch: Exception -> L8
        if (r12 == null) goto L26;
        r14 = r12.optString(ServerElements.HISTORY_BANNER);     // Catch: Exception -> L8
    L26:
        r13.setImageResUrl(r14);     // Catch: Exception -> L8
        return r13;
    L8:
        e = e;
        r11 = r13;
    L29:
        e.printStackTrace();
        return r11;
    L22:
        r18 = "";
        goto L23
    L18:
        r17 = "";
        goto L19
    L14:
        r16 = "";
        goto L15
    L31:
        r15 = r12.optString("id");     // Catch: Exception -> L8
    L28:
        e = e;
        goto L29
    L35:
        return null;
    }

    public static AppInfo g0(String r10) {
        AppInfo r11 = null;
        if (r10 == null) goto L31;
        AccountDataCache r12 = AccountDataCache.b();     // Catch: JSONException -> L24
        JSONObject r13 = new JSONObject(r10);     // Catch: JSONException -> L24
        if (r12.n() == true) goto L7;
        return null;
    L7:
        if (TextUtils.equals(r13.optString("uid"), r12.k()) == false) goto L33;
        AppInfo r14 = new AppInfo();     // Catch: JSONException -> L24
        r14.appId = r13.optString("id");     // Catch: JSONException -> L16
        r14.appName = r13.optString("name");     // Catch: JSONException -> L16
        r14.appPackageName = r13.optString("package");     // Catch: JSONException -> L16
        if (r13.optInt(ServerElements.IFCOLLECT, 0) != 1) goto L12;
        boolean r15 = true;
    L13:
        r14.isCollected = r15;     // Catch: JSONException -> L16
        r14.appVersionCode = r13.optInt("version_code", 0);     // Catch: JSONException -> L16
        r14.isNeededAdd = r13.optBoolean(ServerElements.IFADD, false);     // Catch: JSONException -> L16
        r14.isNeededDelete = r13.optBoolean(ServerElements.IFDELETE, false);     // Catch: JSONException -> L16
        String r16 = r13.optString("category");     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r16) == false) goto L18;
        r16 = BaseApplication.c().getString(R.string.other);     // Catch: JSONException -> L16
    L18:
        r14.appCategoryName = r16;     // Catch: JSONException -> L16
        r14.appIcon = r13.optString(ServerElements.LOGO);     // Catch: JSONException -> L16
        r14.appScores = Float.parseFloat(r13.optString(ServerElements.SCORES, "0.0f"));     // Catch: JSONException -> L16
        r14.appDownloadUrl = r13.optString(ServerElements.DOWNLOAD_URL);     // Catch: JSONException -> L16
        if (r13.has(ServerElements.FILE_MD5) == false) goto L21;
        r14.fileMd5 = r13.optString(ServerElements.FILE_MD5);     // Catch: JSONException -> L16
    L22:
        r14.appBytes = r13.optLong(ServerElements.FILESIZE);     // Catch: JSONException -> L16
        r14.isNeededSync = false;     // Catch: JSONException -> L16
        r14.mAppType = 1;     // Catch: JSONException -> L16
        r14.appSource = "local";     // Catch: JSONException -> L16
        return r14;
    L21:
        r14.fileMd5 = AppInfo.NO_MD5_KEY;     // Catch: JSONException -> L16
        goto L22
    L12:
        r15 = false;
    L16:
        e = e;
        r11 = r14;
    L25:
        e.printStackTrace();
        return r11;
    L33:
        return null;
    L24:
        e = e;
        goto L25
    L31:
        return null;
    }

    public static ArrayList h0(String r13) {
        AccountDataCache r10 = AccountDataCache.b();
        if (r10.n() == false) goto L46;
        if (r13 == null) goto L46;
        JSONObject r11 = new JSONObject(r13);     // Catch: JSONException -> L23
        if (TextUtils.equals(r11.optString("uid"), r10.k()) == true) goto L9;
        return null;
    L9:
        JSONArray r14 = r11.optJSONArray(ServerElements.BODY);     // Catch: JSONException -> L23
        if (r14 != null) goto L12;
    L44:
        return null;
    L12:
        if (r14.length() == 0) goto L44;
        ArrayList r12 = new ArrayList();     // Catch: JSONException -> L23
        int r15 = r14.length();     // Catch: JSONException -> L23
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L43;
        JSONObject r17 = r14.getJSONObject(r16);     // Catch: JSONException -> L23
        AppInfo r18 = new AppInfo();     // Catch: JSONException -> L23
        r18.appId = r17.optString("id");     // Catch: JSONException -> L23
        r18.appName = r17.optString("name");     // Catch: JSONException -> L23
        r18.appPackageName = r17.optString("package");     // Catch: JSONException -> L23
        boolean r19 = true;
        if (r17.optInt(ServerElements.IFCOLLECT, 0) == 1) goto L20;
        r19 = false;
    L20:
        r18.isCollected = r19;     // Catch: JSONException -> L23
        r18.appVersionCode = r17.optInt("version_code", 0);     // Catch: JSONException -> L23
        r18.isNeededAdd = r17.optBoolean(ServerElements.IFADD, false);     // Catch: JSONException -> L23
        r18.isNeededDelete = r17.optBoolean(ServerElements.IFDELETE, false);     // Catch: JSONException -> L23
        String r20 = r17.optString("category");     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(r20) == false) goto L25;
        r20 = BaseApplication.c().getString(R.string.other);     // Catch: JSONException -> L23
    L25:
        r18.appCategoryName = r20;     // Catch: JSONException -> L23
        r18.appIcon = r17.optString(ServerElements.LOGO);     // Catch: JSONException -> L23
        r18.appScores = Float.parseFloat(r17.optString(ServerElements.SCORES, "0.0f"));     // Catch: JSONException -> L23
        r18.appDownloadUrl = r17.optString(ServerElements.DOWNLOAD_URL);     // Catch: JSONException -> L23
        r18.sha256 = r17.optString(ServerElements.SIGN);     // Catch: JSONException -> L23
        JSONArray r21 = r17.optJSONArray(ServerElements.DOWNLOAD_URL_BACKUPS);     // Catch: JSONException -> L23
        if (r21 == null) goto L38;
        if (r21.length() <= 0) goto L38;
        ArrayList r22 = new ArrayList();     // Catch: JSONException -> L23
        int r110 = 0;
    L31:
        if (r110 >= r21.length()) goto L36;
        String r111 = r21.optString(r110, "");     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(r111) == true) goto L35;
        r22.add(r111);     // Catch: JSONException -> L23
    L35:
        r110 = r110 + 1;     // Catch: JSONException -> L23
        goto L31
    L36:
        r18.appDownloadUrlBackups = r22;     // Catch: JSONException -> L23
    L38:
        if (r17.has(ServerElements.FILE_MD5) == false) goto L40;
        r18.fileMd5 = r17.optString(ServerElements.FILE_MD5);     // Catch: JSONException -> L23
    L41:
        r18.isNeededSync = false;     // Catch: JSONException -> L23
        r18.appSource = "local";     // Catch: JSONException -> L23
        r12.add(r18);     // Catch: JSONException -> L23
        r16 = r16 + 1;
        goto L15
    L40:
        r18.fileMd5 = AppInfo.NO_MD5_KEY;     // Catch: JSONException -> L23
        goto L41
    L43:
        return r12;
    L23:
        e = move-exception;
        e.printStackTrace();
    L46:
        return null;
    }

    public static String[] i0(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == false) goto L26;
        return null;
    L26:
        JSONObject r12 = new JSONObject(r10).optJSONObject(ServerElements.BODY);     // Catch: JSONException -> L19
        if (r12 != null) goto L8;
        return null;
    L8:
        JSONArray r13 = r12.optJSONArray("apps");     // Catch: JSONException -> L19
        if (r13 != null) goto L11;
    L25:
        return null;
    L11:
        if (r13.length() == 0) goto L25;
        JSONObject r14 = r13.getJSONObject(0);     // Catch: JSONException -> L19
        String[] r15 = new String[r11];     // Catch: JSONException -> L19
        r15[0] = r14.optString(ServerElements.LOGO);     // Catch: JSONException -> L19
        r15[1] = r14.optString("name");     // Catch: JSONException -> L19
        r15[2] = r14.optString("package");     // Catch: JSONException -> L19
        r15[3] = r14.optString(ServerElements.DOWNLOAD_URL);     // Catch: JSONException -> L19
        StringBuilder r16 = new StringBuilder();     // Catch: JSONException -> L19
        r16.append(r14.optString("category"));     // Catch: JSONException -> L19
        r16.append("#");     // Catch: JSONException -> L19
        r16.append(r14.optString(ServerElements.SCORES, "0.0f"));     // Catch: JSONException -> L19
        r16.append("#");     // Catch: JSONException -> L19
        String r17 = r14.optString("source");     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r17) == false) goto L16;
    L21:
        r16.append("local");     // Catch: JSONException -> L19
    L22:
        r16.append("#");     // Catch: JSONException -> L19
        r16.append(r14.optString(ServerElements.IFGMS, AdReportParam.ClickPosType.SKIP));     // Catch: JSONException -> L19
        r16.append("#");     // Catch: JSONException -> L19
        r16.append(r15[0]);     // Catch: JSONException -> L19
        r16.append("#");     // Catch: JSONException -> L19
        r16.append(r14.optInt("soft_type", 0));     // Catch: JSONException -> L19
        r16.append("#");     // Catch: JSONException -> L19
        r16.append(r14.optString(ServerElements.FILESIZE));     // Catch: JSONException -> L19
        r16.append("#");     // Catch: JSONException -> L19
        r16.append(r14.optString(ServerElements.FILE_MD5));     // Catch: JSONException -> L19
        r15[4] = r16.toString();     // Catch: JSONException -> L19
        r15[5] = "market://details?id=" + r15[2];     // Catch: JSONException -> L19
        r15[6] = r14.optString("id");     // Catch: JSONException -> L19
        r15[9] = r14.optString("share_download_url");     // Catch: JSONException -> L19
        return r15;
    L16:
        if (TextUtils.equals(r17, "local") == true) goto L21;
        r16.append(AppInfo.SEARCH_SOURCE_EXTENAL);     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    public static AppComments k(String r10) {
        return c9.a.l(r10, null);
    }
}
