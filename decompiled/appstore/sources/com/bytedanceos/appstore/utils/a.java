package com.bytedanceos.appstore.utils;

import android.app.job.JobInfo;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.appstore.PreloadInstall.UnzipFileCallback;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.CommonAppItem;
import com.bytedanceos.appstore.download.service.AutoUpdateService;
import com.bytedanceos.common.BackgroundWorkerService;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.BaseAPIHelper;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.s;
import com.bytedanceos.common.utils.r;
import com.obric.appstore.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppStoreCommonUtilKtx f9533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ArrayMap f9534b;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.utils.a$a, reason: collision with other inner class name */
    public class C0127a implements FetchDataCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f9535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f9536b;

        public C0127a(Context r10, ArrayList r11) {
            this.f9535a = r10;
            this.f9536b = r11;
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
            j.a("deleteHistoryAppsOnServerWhenNetworkAvailable Failed:" + r12);
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
            a.f(this.f9535a, this.f9536b);
        }
    }

    static {
        f9533a = new AppStoreCommonUtilKtx();
        f9534b = new ArrayMap();
    }

    public static void A() {
        Intent r10 = new Intent("com.bytedanceos.appstore.invalid.dialog");
        z.a.b(BaseApplication.c()).d(r10);
    }

    public static void B() {
        Intent r10 = new Intent();
        r10.setAction("update_notification");
        a8.b.e().h(r10);
    }

    public static void C(int r10) {
        if (s.g(BaseApplication.c()) == true) goto L6;
        j.n("[AutoUpdate] cancel auto download. setting off. " + r10);
        return;
    L6:
        Intent r11 = new Intent(BaseApplication.c(), AutoUpdateService.class);
        r11.setAction("com.bytedance.appstore.autoupdate.download");
        r11.putExtra("retry_time", r10);
        BaseApplication.c().startService(r11);
    }

    public static void D(int r10) {
        Intent r11 = new Intent(BaseApplication.c(), AutoUpdateService.class);
        r11.setAction("com.bytedance.appstore.autoupdate.download.reserve");
        r11.putExtra("retry_time", r10);
        BaseApplication.c().startService(r11);
    }

    public static void E(Context r10, int r11) {
        if (b0.n().k(r10, null, "back_info") == false) goto L5;
        F(r10, r11, null);
        return;
    L5:
        j.a("no restore apps:" + r11);
    }

    public static void F(Context r10, int r11, ArrayList r12) {
    }

    public static void G() {
        List r10 = com.bytedanceos.appstore.datacache.a.N0().v("WIFIAPPS");
        BaseApplication.c();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        AppInfo r12 = (AppInfo) r11.next();
        String r13 = r12.appPackageName;
        if (com.bytedanceos.appstore.datacache.a.N0().b0(r13) == true) goto L8;
        r12.appState = 32;
    L8:
        j.o("[AppStatus] startWifiDownload appInfo.appPackageName :" + r12.appPackageName + "isInstalled：  isDownloading：" + com.bytedanceos.appstore.datacache.a.N0().X(r13) + " getInstalledAppVersionCode :" + com.bytedanceos.appstore.datacache.a.N0().M0(r13) + " appVersionCode:" + r12.appVersionCode);
        f9533a.a(r12);
        com.bytedanceos.appstore.datacache.a.N0().t0(r12);
        goto L4
    }

    public static void H(Context r10, ArrayList r11) {
        if (r11 != null) goto L4;
    L8:
        j.e("no remote apps");
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        CommonAPIHelper.p(new C0127a(r10, r11), r11);
    }

    public static void I() {
        b0.n().H("GMS_DOWMLOAD", "GMS_DOWMLOAD_NOT_HANDLE", null, BaseApplication.c());
    }

    public static void J(String r10, UnzipFileCallback r11, List r12) {
        FileOutputStream r13 = null;
        ZipInputStream r14 = new ZipInputStream(new FileInputStream(new File(k(), r10)));     // Catch: Throwable -> L49 Exception -> L51
        File r15 = com.bytedanceos.common.toolbox.e.H();     // Catch: Throwable -> L7 Exception -> L9
        if (r15.exists() == true) goto L11;
        r15.mkdirs();     // Catch: Throwable -> L7 Exception -> L9
    L11:
        ZipEntry r16 = r14.getNextEntry();     // Catch: Throwable -> L7 Exception -> L9
        if (r16 == null) goto L45;
        if (r16.isDirectory() == true) goto L11;
        String r17 = r16.getName();     // Catch: Throwable -> L7 Exception -> L9
        if (TextUtils.isEmpty(r17) == true) goto L11;
        if (r12 == null) goto L22;
        if (r12.contains(r17) == false) goto L11;
    L22:
        File r18 = new File(r15, r17);     // Catch: Throwable -> L7 Exception -> L9
        if (r18.exists() == false) goto L74;
        r18.delete();     // Catch: Throwable -> L7 Exception -> L9
    L74:
        FileOutputStream r19 = new FileOutputStream(r18);     // Catch: Throwable -> L41
        byte[] r20 = new byte[1024];     // Catch: Throwable -> L31
    L28:
        int r21 = r14.read(r20);     // Catch: Throwable -> L31
        if (r21 <= 0) goto L33;
        r19.write(r20, 0, r21);     // Catch: Throwable -> L31
        goto L28
    L33:
        if (r11 == null) goto L87;
        r11.unzipFileFinished(r17, r18.getAbsolutePath());     // Catch: Throwable -> L31
    L87:
        r19.flush();     // Catch: Throwable -> L37 Exception -> L39
        r19.close();     // Catch: Throwable -> L37 Exception -> L39
        r13 = r19;
        goto L11
    L39:
        e = e;
        r13 = r19;
    L53:
        j.n(e.getMessage());     // Catch: Throwable -> L7
        if (r13 != null) goto L71;
    L56:
        if (r14 != null) goto L84;
        return;
    L84:
        r14.close();     // Catch: Exception -> L67
        return;
    L104:
        return;
    L71:
        r13.flush();     // Catch: Exception -> L66
        r13.close();     // Catch: Exception -> L66
    L37:
        th = th;
        r13 = r19;
    L59:
        if (r13 != null) goto L76;
    L61:
        if (r14 == null) goto L105;
        r14.close();     // Catch: Exception -> L65
        throw th;
    L106:
        throw th;
    L105:
        throw th;
    L76:
        r13.flush();     // Catch: Exception -> L64
        r13.close();     // Catch: Exception -> L64
    L31:
        th = th;
        r13 = r19;
    L42:
        if (r13 == null) goto L44;
        r13.flush();     // Catch: Throwable -> L7 Exception -> L9
        r13.close();     // Catch: Throwable -> L7 Exception -> L9
    L44:
        throw th;     // Catch: Throwable -> L7 Exception -> L9
    L41:
        th = th;
        goto L42
    L45:
        if (r13 == null) goto L84;
        r13.flush();     // Catch: Exception -> L68
        r13.close();     // Catch: Exception -> L68
    L9:
        e = e;
        goto L53
    L7:
        th = th;
    L51:
        e = e;
        r14 = null;
    L49:
        th = th;
        r14 = null;
        goto L59
    }

    public static void a() {
        if (com.bytedanceos.appstore.datacache.a.N0().H() == true) goto L7;
        j.n("[AutoUpdate] AppStoreCommonUtil checkAutoUpdate. no auto update data");
        return;
    L7:
        if (s.g(BaseApplication.c()) == false) goto L9;
        JobInfo r10 = c8.a.k(1);
        t8.a.b(r10, "[AutoUpdate][JOB] AppStoreCommonUtil checkAutoUpdate. schedule AutoUpdateDownloadJob, id=" + r10.getId());
        return;
    L9:
        j.n("[AutoUpdate] AppStoreCommonUtil checkAutoUpdate. stop auto update switch.");
    }

    public static boolean b(Context r10) {
        if (r10 != null) goto L6;
        return true;
    L6:
        if (r10.getPackageManager().isSafeMode() == false) goto L9;
        e0.e(R.string.alert_safe_mode);
        return true;
    L9:
        return false;
    }

    public static boolean c(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L16;
        return false;
    L16:
        String r11 = Uri.parse(r10).getScheme();     // Catch: Exception -> L15
        if (r11 == null) goto L14;
        if (r11.equals(HttpHost.DEFAULT_SCHEME_NAME) == true) goto L12;
        if (r11.equals("https") == false) goto L14;
        return true;
    L12:
        return true;
    L14:
        return false;
    }

    public static void d() {
        f9534b.clear();
    }

    public static CommonAppEntity e(AppInfo r10) {
        CommonAppEntity r11 = new CommonAppEntity();
        r11.setId(r10.appId);
        r11.setName(r10.appName);
        r11.setVersion_code(r10.appVersionCode);     // Catch: NumberFormatException -> L5
    L7:
        r11.setVersion(r10.appVersionName);
        r11.setPkg(r10.appPackageName);
        r11.setLogo(r10.appIcon);
        r11.setScores(r10.appScores);
        r11.setCategory(r10.appCategoryName);
        r11.setDownloadId(r10.downloadId);
        r11.setFilesize(r10.appBytes);     // Catch: NumberFormatException -> L10
    L30:
        r11.setStatus(String.valueOf(r10.mStatus));     // Catch: NumberFormatException -> L14
    L16:
        r11.setIfgms(r10.mIsNeedGms ? 1 : 0);
        AppInfo.From r12 = r10.appFrom;
        if (r12 == null) goto L19;
        r11.setFrom(r12.mark);
    L19:
        r11.setDownload_url(r10.appDownloadUrl);
        r11.setDefault_check(r10.default_check);
        r11.addItemPosition(r10.itemPosition);
        r11.setRecmd_brief(r10.recmd_brief);
        r11.setSoft_type(r10.mAppType);
        r11.setLabel(r10.mLabels);     // Catch: NumberFormatException -> L22
    L24:
        r11.setItem(new CommonAppItem(r11, r10));
        return r11;
    L22:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void f(Context r10, ArrayList r11) {
        e8.a.f(r10, r11, false, false);
    }

    public static List g(Map r10, boolean r11) {
        if (r10 == null) goto L15;
        if (r10.isEmpty() == true) goto L15;
        monitor-enter(r10);
        HashMap r12 = new HashMap(r10);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return new ArrayList(r12.values());
    L11:
        th = move-exception;
        throw th;
    L15:
        return new ArrayList();
    }

    public static ArrayList h(Map r10, String r11) {
        monitor-enter(r10);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r13 = r10.values().iterator();     // Catch: Throwable -> L11
    L5:
        if (r13.hasNext() == false) goto L33;
        AppInfo r14 = (AppInfo) r13.next();     // Catch: Throwable -> L11
        if (TextUtils.equals(r11, "UPDATE") == false) goto L14;
        if (r14.hideVersionCode >= r14.appVersionCode) goto L5;
    L14:
        if (TextUtils.equals(r11, "HIDE") == false) goto L18;
        if (r14.hideVersionCode < r14.appVersionCode) goto L5;
    L18:
        AppInfo r15 = com.bytedanceos.appstore.datacache.a.N0().u(r14.appPackageName);     // Catch: Throwable -> L11
        if (r15 == null) goto L23;
        if (r15.mTaskOwner == 1) goto L5;
    L23:
        AppInfo r16 = com.bytedanceos.appstore.datacache.a.N0().D(r14.appPackageName);     // Catch: Throwable -> L11
        if (r16 == null) goto L29;
        if (r16.appVersionCode >= r14.appVersionCode) goto L5;
    L29:
        if (r.c(r14.appPackageName) == false) goto L5;
        if (r.b(r14.appPackageName) == false) goto L5;
        com.bytedanceos.common.toolbox.e.e0(r14.appDownloadUrl, "position");     // Catch: Throwable -> L11
        r12.add(r14);     // Catch: Throwable -> L11
        goto L5
    L33:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0042: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:15:0x0042 */
    public static String i(String r10, boolean r11) {
        HttpURLConnection r12 = null;
        if (r10 != null) goto L54;
        j.a("url is null.");
        return null;
    L54:
        HttpURLConnection r13 = (HttpURLConnection) new URL(r10).openConnection();     // Catch: Throwable -> L36 IOException -> L38 MalformedURLException -> L40
    L53:
        r13.setReadTimeout(5000);     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
        r13.setConnectTimeout(5000);     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
        if (r11 == false) goto L20;
        Map r14 = BaseAPIHelper.b(0);     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
        Iterator r15 = r14.keySet().iterator();     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
    L12:
        if (r15.hasNext() == false) goto L21;
        String r16 = (String) r15.next();     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
        r13.addRequestProperty(r16, (String) r14.get(r16));     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
    L21:
        int r17 = r13.getResponseCode();     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
        if (r17 != 200) goto L24;
    L29:
        InputStream r18 = r13.getInputStream();     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
        ByteArrayOutputStream r19 = new ByteArrayOutputStream();     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
    L30:
        int r20 = r18.read();     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
        if (r20 == (-1)) goto L33;
        r19.write(r20);     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
        goto L30
    L33:
        String r21 = r19.toString(c0.e().name());     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
        r13.disconnect();
        return r21;
    L24:
        if (r17 == 206) goto L29;
        j.e("responseCode = " + r17 + "| url =" + r10);     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
        r13.disconnect();
        return null;
    L20:
        r13.addRequestProperty("store-source", "obric");     // Catch: Throwable -> L14 IOException -> L16 MalformedURLException -> L18
    L18:
        e = e;
    L45:
        e.printStackTrace();     // Catch: Throwable -> L14
        if (r13 != null) goto L44;
    L48:
        return null;
    L44:
        r13.disconnect();
    L16:
        e = e;
    L42:
        e.printStackTrace();     // Catch: Throwable -> L14
        if (r13 == null) goto L48;
    L40:
        e = e;
        r13 = null;
    L38:
        e = e;
        r13 = null;
    L36:
        th = th;
    L49:
        if (r12 == null) goto L51;
        r12.disconnect();
    L51:
        throw th;
    L14:
        th = th;
        r12 = r1;
        goto L49
    }

    public static String j() {
        return Settings.Global.getString(BaseApplication.c().getContentResolver(), "last_ota_os_version");
    }

    public static String k() {
        return "/system/media/app/";
    }

    public static void l() {
        b0.n().H("GMS_DOWMLOAD", "GMS_DOWMLOAD_HAS_HANDLE", null, BaseApplication.c());
    }

    public static void m() {
        Intent r10 = new Intent(BaseApplication.c(), AutoUpdateService.class);
        r10.setAction("com.bytedance.appstore.autoupdate.install");
        BaseApplication.c().startService(r10);
    }

    public static boolean n(Context r10, int r11) {
        if (r(r10) == false) goto L6;
        return true;
    L6:
        if (r11 == 134) goto L8;
        return false;
    L8:
        if (p(r10) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean o() {
        return TextUtils.equals("GMS_DOWMLOAD_NOT_HANDLE", b0.n().t("GMS_DOWMLOAD", null, BaseApplication.c(), null));
    }

    public static boolean p(Context r10) {
        if (com.bytedanceos.common.toolbox.e.A() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean q(Fragment r10) {
        if (r10 != null) goto L5;
    L16:
        return false;
    L5:
        if (r10.isAdded() == false) goto L16;
        if (r10.getActivity() == null) goto L16;
        if (r10.getActivity().isDestroyed() == true) goto L12;
        return true;
    L12:
        if (r10.getActivity().isFinishing() == true) goto L16;
        return true;
    }

    public static boolean r(Context r10) {
        if (2 != com.bytedanceos.common.toolbox.e.A()) goto L5;
        return true;
    L5:
        return false;
    }

    public static b7.a s() {
        String r10 = b0.n().s("back_info", null, BaseApplication.c());
        if (TextUtils.isEmpty(r10) == false) goto L22;
        return null;
    L22:
        JSONObject r11 = new JSONObject(r10);     // Catch: JSONException -> L14
        JSONArray r12 = r11.optJSONArray("package_list");     // Catch: JSONException -> L14
        if (r12 != null) goto L8;
    L18:
        j.a("package list is null;");     // Catch: JSONException -> L14
        return null;
    L8:
        if (r12.length() == 0) goto L18;
        ArrayList r13 = new ArrayList();     // Catch: JSONException -> L14
        int r14 = 0;
    L12:
        if (r14 >= r12.length()) goto L16;
        r13.add(r12.optString(r14));     // Catch: JSONException -> L14
        r14 = r14 + 1;     // Catch: JSONException -> L14
        goto L12
    L16:
        b7.a r15 = new b7.a();     // Catch: JSONException -> L14
        r15.f(r13);     // Catch: JSONException -> L14
        r15.h(r11.optLong("scheduler_time"));     // Catch: JSONException -> L14
        r15.g(r11.optInt("max_times"));     // Catch: JSONException -> L14
        r15.e(r11.optInt("network_type"));     // Catch: JSONException -> L14
        return r15;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean t() {
        return Settings.Global.putString(BaseApplication.c().getContentResolver(), "last_ota_os_version", com.bytedanceos.common.toolbox.e.U(false));
    }

    public static void u() {
        AppInfo r10 = com.bytedanceos.appstore.datacache.a.N0().E();
        if (r10 != null) goto L7;
        j.a("downloadTasks is empty.");
        return;
    L7:
        if (com.bytedanceos.appstore.datacache.a.N0().R(false, r10.isAutoDownload) == false) goto L9;
        com.bytedanceos.appstore.datacache.a.N0().l(0);
        return;
    L9:
        com.bytedanceos.appstore.datacache.a.N0().l(PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS);
    }

    public static void v(int r10, String r11, String r12) {
        Intent r13 = new Intent(BaseApplication.c(), BackgroundWorkerService.class);
        r13.putExtra("background_worker_type", r10);
        if (r11 == null) goto L5;
        r13.setAction(r11);
    L5:
        if (r12 == null) goto L7;
        r13.setType(r13.getType());
    L7:
        BaseApplication.c().startService(r13);
    }

    public static void w(b7.a r10) {
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L6
        r11.put("scheduler_time", r10.d());     // Catch: JSONException -> L6
        r11.put("max_times", r10.c());     // Catch: JSONException -> L6
        r11.put("network_type", r10.a());     // Catch: JSONException -> L6
        JSONArray r12 = new JSONArray();     // Catch: JSONException -> L6
        int r13 = 0;
    L4:
        if (r13 >= r10.b().size()) goto L8;
        r12.put(r10.b().get(r13));     // Catch: JSONException -> L6
        r13 = r13 + 1;     // Catch: JSONException -> L6
        goto L4
    L8:
        r11.put("package_list", r12);     // Catch: JSONException -> L6
        b0.n().H("back_info", r11.toString(), null, BaseApplication.c());     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static void x(String r10, String r11) {
        if (TextUtils.equals("com.bytedanceos.game.store.sync.collection.apps", r10) == false) goto L5;
    L8:
        Intent r12 = new Intent(r10);
        r12.putExtra("apps", r11);
        BaseApplication.c().sendBroadcast(r12);
        return;
    L5:
        if (TextUtils.equals("com.bytedanceos.game.store.sync.my.apps", r10) == true) goto L8;
        if (TextUtils.equals("com.bytedanceos.game.store.sync.last.day", r10) == true) goto L8;
    }

    public static void y(AppInfo r10, String r11, int r12) {
        if (TextUtils.equals("launcher", r10.appSource) == false) goto L5;
    L11:
        j.a("action:" + r11 + " / errorCode:" + r12);
        return;
    L5:
        if (TextUtils.equals("sys_app_silence", r10.appSource) == true) goto L11;
        if (TextUtils.equals("sys_app_silence_mobile", r10.appSource) == true) goto L11;
        Intent r13 = new Intent();
        r13.setAction(r11);
        r13.putExtra(DownloadInfoColumns.TABLE, r10);
        r13.putExtra(WsConstants.ERROR_CODE, r12);
        a8.b.e().h(r13);
    }

    public static void z(boolean r10, boolean r11) {
        long r12 = System.currentTimeMillis();
        StringBuffer r13 = new StringBuffer();
        r13.append(r12);
        r13.append(";");
        r13.append(r10);
        r13.append(";");
        r13.append(r11);
        String r14 = r13.toString();
        x("com.bytedanceos.game.store.sync.last.day", r14);
        b0.n().H("last_day", r14, null, BaseApplication.c());
        j.a("dateTime:" + r12 + "   isWifiDownload:" + r10 + "   isForbidDialogToday:" + r11);
    }
}
