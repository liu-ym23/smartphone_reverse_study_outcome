package com.apm.lite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.apm.lite.j.k;
import com.apm.lite.k.j;
import com.bytedance.crash.general.AppInfo;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MonitorCrash.Config f29903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f29904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f29905c;

    public b() {
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public final JSONObject c(HashMap<String, String> r100) {
        JSONObject r101 = new JSONObject();
        r101.put("magic_tag", "ss_app_log");
        if (this.f29905c != null) goto L32;
        Context r102 = e.f29909a;
        this.f29905c = new JSONObject();     // Catch: Exception -> L31
        if (this.f29904b == null) goto L12;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L31
        Iterator<Map.Entry<String, String>> r104 = this.f29904b.entrySet().iterator();     // Catch: Exception -> L31
    L9:
        if (r104.hasNext() == false) goto L11;
        Map.Entry<String, String> r105 = r104.next();     // Catch: Exception -> L31
        r103.put(r105.getKey(), r105.getValue());     // Catch: Exception -> L31
        goto L9
    L11:
        this.f29905c.put("custom", r103);     // Catch: Exception -> L31
    L12:
        this.f29905c.put("os", "Android");     // Catch: Exception -> L31
        this.f29905c.put("platform", "Android");     // Catch: Exception -> L31
        JSONObject r106 = this.f29905c;     // Catch: Exception -> L31
        String[] r107 = k1.c.f501333b;     // Catch: Exception -> L31
        String r108 = Build.VERSION.RELEASE;     // Catch: Exception -> L31
        if (r108.contains(".") == true) goto L16;
        r108 = r108.concat(".0");     // Catch: Exception -> L31
    L16:
        r106.put("os_version", r108);     // Catch: Exception -> L31
        this.f29905c.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L31
        this.f29905c.put("sdk_version", this.f29903a.f29885d);     // Catch: Exception -> L31
        this.f29905c.put("sdk_version_code", this.f29903a.f29885d);     // Catch: Exception -> L31
        this.f29905c.put(AppInfo.KEY_NPTH_VERSION_NAME, this.f29903a.f29886e);     // Catch: Exception -> L31
        this.f29905c.put("aid", this.f29903a.f29882a);     // Catch: Exception -> L31
        String r109 = Build.MODEL;     // Catch: Exception -> L31
        String r110 = Build.BRAND;     // Catch: Exception -> L31
        if (r109 != null) goto L19;
        r109 = r110;
    L23:
        this.f29905c.put("device_model", r109);     // Catch: Exception -> L31
        this.f29905c.put("device_brand", r110);     // Catch: Exception -> L31
        this.f29905c.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L31
        this.f29905c.put("channel", this.f29903a.f29884c);     // Catch: Exception -> L31
        this.f29905c.put("app_version", this.f29903a.f29886e);     // Catch: Exception -> L31
        this.f29905c.put("version_code", this.f29903a.f29885d);     // Catch: Exception -> L31
        this.f29905c.put("update_version_code", this.f29903a.f29885d);     // Catch: Exception -> L31
        this.f29905c.put("manifest_version_code", this.f29903a.f29885d);     // Catch: Exception -> L31
        this.f29905c.put("bd_did", this.f29903a.getDeviceId());     // Catch: Exception -> L31
        String r111 = r102.getPackageName();     // Catch: Exception -> L31
        this.f29905c.put("package", r111);     // Catch: Exception -> L31
        PackageInfo r112 = r102.getPackageManager().getPackageInfo(r111, 0);     // Catch: Exception -> L31
        ApplicationInfo r113 = r112.applicationInfo;     // Catch: Exception -> L31
        if (r113 == null) goto L32;
        int r114 = r113.labelRes;     // Catch: Exception -> L31
        if (r114 <= 0) goto L29;
        this.f29905c.put(IGoogleService.ResponseKey.DISPLAY_NAME, r102.getString(r114));     // Catch: Exception -> L31
        goto L32
    L29:
        this.f29905c.put(IGoogleService.ResponseKey.DISPLAY_NAME, r102.getPackageManager().getApplicationLabel(r112.applicationInfo));     // Catch: Exception -> L31
        goto L32
    L19:
        if (r110 == null) goto L23;
        if (r109.contains(r110) == true) goto L23;
        r109 = r110 + ' ' + r109;     // Catch: Exception -> L31
    L32:
        long r115 = System.currentTimeMillis() / 1000;
        r101.put("header", this.f29905c);
        r101.put("local_time", r115);
        JSONArray r116 = new JSONArray();
        JSONObject r117 = new JSONObject();
        long r118 = System.currentTimeMillis();
        r117.put("local_time_ms", r118);
        r117.put("tea_event_index", 10001);
        r117.put("session_id", UUID.randomUUID().toString());
        r117.put(SheetInputData.InputData.DateType.DATETIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(r118)));
        if (r100 == null) goto L39;
        JSONObject r119 = new JSONObject();
        Iterator<Map.Entry<String, String>> r120 = r100.entrySet().iterator();
    L36:
        if (r120.hasNext() == false) goto L38;
        Map.Entry<String, String> r121 = r120.next();
        r119.put(r121.getKey(), r121.getValue());
        goto L36
    L38:
        r117.put("pv_filters", r119);
    L39:
        r116.put(r117);
        r101.put(EventVerify.TYPE_LAUNCH, r116);
        return r101;
    }

    public static k b(String r100, byte[] r101, String r102, String r103) {
        HttpURLConnection r104 = null;
        DataOutputStream r105 = null;
        HttpURLConnection r106 = (HttpURLConnection) a(new URL(r100));     // Catch: Throwable -> L29
        o1.a.a(r106);     // Catch: Throwable -> L27
        r106.setDoOutput(true);     // Catch: Throwable -> L27
        r106.setRequestProperty("Content-Type", "application/json; charset=utf-8");     // Catch: Throwable -> L27
        r106.setRequestProperty("Content-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L27
        r106.setRequestProperty("Accept-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r106.setRequestProperty("aid", r102);     // Catch: Throwable -> L27
        r106.setRequestProperty("x-auth-token", r103);     // Catch: Throwable -> L27
    L7:
        r106.setRequestMethod("POST");     // Catch: Throwable -> L27
        if (r101 != null) goto L10;
    L19:
        int r107 = r106.getResponseCode();     // Catch: Throwable -> L27
        if (r107 != 200) goto L24;
        k r108 = new k(r107, 0);     // Catch: Throwable -> L27
        r106.disconnect();     // Catch: Exception -> L39
    L23:
        return r108;
    L24:
        k r109 = new k(206, 0);     // Catch: Throwable -> L27
        r106.disconnect();     // Catch: Exception -> L40
    L26:
        return r109;
    L10:
        if (r101.length <= 0) goto L19;
        DataOutputStream r110 = new DataOutputStream(r106.getOutputStream());     // Catch: Throwable -> L16
        r110.write(r101);     // Catch: Throwable -> L14
        r110.flush();     // Catch: Throwable -> L14
        j.a(r110);     // Catch: Throwable -> L27
    L14:
        th = th;
        r105 = r110;
    L17:
        j.a(r105);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L16:
        th = th;
    L27:
        Throwable th10 = th;
        r104 = r106;
    L47:
        e.f29913e.isDebugMode();     // Catch: Throwable -> L35
        k r111 = new k(207, th10);     // Catch: Throwable -> L35
        if (r104 != null) goto L57;
    L34:
        return r111;
    L57:
        r104.disconnect();     // Catch: Exception -> L41
    L35:
        th = move-exception;
        if (r104 != null) goto L53;
    L38:
        throw th;
    L53:
        r104.disconnect();     // Catch: Exception -> L42
    L29:
        th = move-exception;
        th10 = th;
        goto L47
    }
}
