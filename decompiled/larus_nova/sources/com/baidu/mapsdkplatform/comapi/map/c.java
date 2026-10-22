package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f32128a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AsyncHttpClient f32129b;

    public class a extends HttpClient.ProtoResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f32130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC0646c f32132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f32133d;

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onFailed(HttpClient.HttpStateError r100) {
            String r101 = c.a(this.f32133d, this.f32130a, this.f32131b);
            if (c.a(this.f32133d, r101) == true) goto L6;
            r101 = null;
        L6:
            InterfaceC0646c r102 = this.f32132c;
            if (r102 == null) goto L10;
            r102.onCustomMapStyleLoadFailed(r100.ordinal(), r100.name(), r101);
        L10:
            if (OpenLogUtil.isMapLogEnable() == false) goto L13;
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap failed error = " + r100.ordinal());
            return;
        }

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onSuccess(String r100) {
            c.a(this.f32133d, this.f32130a, r100, this.f32131b, this.f32132c);
            if (OpenLogUtil.isMapLogEnable() == false) goto L6;
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap result = " + r100);
            return;
        }

        public a(c r100, Context r101, String r102, InterfaceC0646c r103) {
            this.f32133d = r100;
            this.f32130a = r101;
            this.f32131b = r102;
            this.f32132c = r103;
        }
    }

    public class b implements com.baidu.mapsdkplatform.comapi.commonutils.b.c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f32134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC0646c f32136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f32137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f32138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f32139f;

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.b.c.d
        public void a() {
            InterfaceC0646c r100 = this.f32136c;
            if (r100 == null) goto L6;
            r100.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "loadStyleFile onFailed", null);
        L6:
            if (OpenLogUtil.isMapLogEnable() == false) goto L9;
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap loadStyleFile failed");
            return;
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.b.c.d
        public void a(File r100) {
            boolean r101 = c.a(this.f32139f, this.f32134a, r100, this.f32135b);
            if (OpenLogUtil.isMapLogEnable() == false) goto L5;
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap loadStyleFile success ret = " + r101);
        L5:
            String r102 = null;
            if (r101 == true) goto L11;
            InterfaceC0646c r103 = this.f32136c;
            if (r103 == null) goto L18;
            r103.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "UnZipStyleFile onFailed", null);
            return;
        L18:
            return;
        L11:
            c.a(this.f32139f, this.f32134a, this.f32135b, this.f32137d);
            if (this.f32136c != null) goto L14;
            return;
        L14:
            if (c.a(this.f32139f, this.f32138e) == false) goto L16;
            r102 = this.f32138e;
        L16:
            this.f32136c.onCustomMapStyleLoadSuccess(true, r102);
        }

        public b(c r100, Context r101, String r102, InterfaceC0646c r103, String r104, String r105) {
            this.f32139f = r100;
            this.f32134a = r101;
            this.f32135b = r102;
            this.f32136c = r103;
            this.f32137d = r104;
            this.f32138e = r105;
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.map.c$c, reason: collision with other inner class name */
    public interface InterfaceC0646c {
        void onCustomMapStyleLoadFailed(int r100, String r101, String r102);

        void onCustomMapStyleLoadSuccess(boolean r100, String r101);

        void onPreLoadLastCustomMapStyle(String r100);
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f32140a = null;

        static {
            f32140a = new c(null);
        }

        public static /* synthetic */ c a() {
            return f32140a;
        }
    }

    private c() {
        this.f32129b = new AsyncHttpClient();
    }

    public static c a() {
        return d.a();
    }

    public /* synthetic */ c(a r100) {
        this();
    }

    private String a(Context r100) {
        BufferedReader r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getFilesDir().getAbsolutePath(), "ver.cfg");
        if (r102.exists() == true) goto L8;
        return "";
    L8:
        StringBuilder r103 = new StringBuilder();
        BufferedReader r104 = new BufferedReader(new PolarisFileReaderWrapper(r102));     // Catch: Throwable -> L24 IOException -> L26
    L50:
        String r105 = r104.readLine();     // Catch: Throwable -> L20 IOException -> L22
        if (r105 == null) goto L40;
        r103.append(r105);     // Catch: Throwable -> L20 IOException -> L22
    L40:
        r104.close();     // Catch: IOException -> L16
    L19:
        return r103.toString();
    L16:
        e = move-exception;
        e.printStackTrace();
    L22:
        e = e;
        r101 = r104;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r101 != null) goto L42;
    L33:
        return "";
    L42:
        r101.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L20:
        th = th;
        r101 = r104;
    L34:
        if (r101 != null) goto L47;
    L39:
        throw th;
    L47:
        r101.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L24:
        th = th;
    L26:
        e = e;
        goto L27
    }

    private boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return new PolarisFileWrapper(r100).exists();
    }

    private String a(Map<String, String> r100) {
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        StringBuilder r101 = new StringBuilder();
        Iterator<String> r102 = r100.keySet().iterator();
        int r103 = 0;
    L8:
        if (r102.hasNext() == false) goto L15;
        String r104 = r102.next();
        String r105 = AppMD5.encodeUrlParamsValue(r100.get(r104));
        if (r103 != 0) goto L12;
        r101.append(r104);
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(r105);
    L13:
        r103 = r103 + 1;
        goto L8
    L12:
        r101.append("&");
        r101.append(r104);
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(r105);
        goto L13
    L15:
        return r101.toString();
    }

    private String a(String r100) {
        if (HttpClient.isHttpsEnable == false) goto L7;
        return "https://" + r100;
    L7:
        return "http://" + r100;
    }

    private String a(Context r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getFilesDir().getAbsolutePath() + File.separator + "sc_sty_" + r101 + ".sty";
    }

    private String b(Context r100, String r101) {
        if (b(a(r100, r101)) == true) goto L14;
        return "";
    L14:
        JSONArray r102 = new JSONArray(a(r100));     // Catch: JSONException -> L13
        int r103 = r102.length();     // Catch: JSONException -> L13
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L19;
        String r105 = ((JSONObject) r102.opt(r104)).optString(r101);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r105) == false) goto L12;
        r104 = r104 + 1;
        goto L7
    L12:
        return r105;
    L19:
        return "";
    L18:
        return "";
    }

    private boolean a(InputStream r100, FileOutputStream r101) throws IOException, NullPointerException {
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        byte[] r102 = new byte[4096];
    L24:
        int r103 = r100.read(r102);     // Catch: Throwable -> L15
        if (r103 == (-1)) goto L10;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L15
        goto L24
    L10:
        r101.flush();     // Catch: Throwable -> L15
        r100.close();     // Catch: IOException -> L20
    L30:
        r101.close();     // Catch: IOException -> L21
        return true;
    L36:
        return true;
    L15:
        th = move-exception;
        r100.close();     // Catch: IOException -> L22
    L26:
        r101.close();     // Catch: IOException -> L23
        throw th;
    L35:
        throw th;
    L19:
        return false;
    }

    private boolean a(int r100, String r101) {
        if (103 == r100) goto L5;
        return true;
    L5:
        if (b(r101) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public static /* synthetic */ boolean a(c r100, String r101) {
        return r100.b(r101);
    }

    private void a(Context r100, String r101, String r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getFilesDir().getAbsolutePath(), "ver.cfg");
        String r103 = a(r100);
        PrintWriter r104 = null;
    L35:
        e = e;
    L36:
        e.printStackTrace();     // Catch: Throwable -> L33
        if (r104 == null) goto L53;
        r104.close();
        return;
    L53:
        return;
    L33:
        th = th;
    L40:
        if (r104 == null) goto L42;
        r104.close();
    L42:
        throw th;
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L8;
        JSONArray r105 = new JSONArray();     // Catch: Throwable -> L33 Exception -> L35
    L9:
        int r106 = r105.length();     // Catch: Throwable -> L33 Exception -> L35
        if (r106 != 0) goto L12;
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L33 Exception -> L35
        r107.put(r101, r110);     // Catch: Throwable -> L33 Exception -> L35
        r105.put(r107);     // Catch: Throwable -> L33 Exception -> L35
    L26:
        PrintWriter r111 = new PrintWriter(new PolarisFileWriterWrapper(r102.getAbsoluteFile()));     // Catch: Throwable -> L33 Exception -> L35
        r111.write(r105.toString());     // Catch: Throwable -> L29 Exception -> L31
        r111.close();
        return;
    L31:
        e = e;
        r104 = r111;
    L29:
        th = th;
        r104 = r111;
        goto L40
    L12:
        int r108 = 0;
        JSONObject r109 = null;
    L14:
        if (r108 >= r106) goto L21;
        r109 = (JSONObject) r105.opt(r108);     // Catch: Throwable -> L33 Exception -> L35
        if (r109 == null) goto L20;
        if (r109.has(r101) == false) goto L20;
    L22:
        if (r108 == (-1)) goto L25;
        if (r109 == null) goto L25;
        r109.put(r101, r110);     // Catch: Throwable -> L33 Exception -> L35
        r105.put(r108, r109);     // Catch: Throwable -> L33 Exception -> L35
    L25:
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L33 Exception -> L35
        r112.put(r101, r110);     // Catch: Throwable -> L33 Exception -> L35
        r105.put(r112);     // Catch: Throwable -> L33 Exception -> L35
    L20:
        r108 = r108 + 1;     // Catch: Throwable -> L33 Exception -> L35
        goto L14
    L21:
        r108 = -1;
        goto L22
    L8:
        r105 = new JSONArray(r103);     // Catch: Throwable -> L33 Exception -> L35
        goto L9
    }

    private boolean a(Context r100, File r101, String r102) {
        if (r101 == null) goto L43;
        if (r100 == null) goto L43;
        PolarisZipFileWrapper r103 = null;
        PolarisZipFileWrapper r104 = new PolarisZipFileWrapper(r101.getAbsoluteFile());     // Catch: Throwable -> L24 Exception -> L28 SecurityException -> L47 IllegalStateException -> L48 NullPointerException -> L49 IOException -> L50 ZipException -> L51 FileNotFoundException -> L52
    L64:
        ZipEntry r105 = r104.getEntry(r102 + ".sty");     // Catch: Throwable -> L15 Exception -> L17 SecurityException -> L18 IllegalStateException -> L19 NullPointerException -> L20 IOException -> L21 ZipException -> L22 FileNotFoundException -> L23
        if (r105 == null) goto L54;
        boolean r106 = a(r104.getInputStream(r105), new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(a(r100, r102))));     // Catch: Throwable -> L15 Exception -> L17 SecurityException -> L18 IllegalStateException -> L19 NullPointerException -> L20 IOException -> L21 ZipException -> L22 FileNotFoundException -> L23
        r101.delete();     // Catch: Throwable -> L15 Exception -> L17 SecurityException -> L18 IllegalStateException -> L19 NullPointerException -> L20 IOException -> L21 ZipException -> L22 FileNotFoundException -> L23
        r104.close();     // Catch: IOException -> L44
    L14:
        return r106;
    L54:
        r104.close();     // Catch: IOException -> L45
    L11:
        return false;
    L23:
        r103 = r104;
    L21:
        r103 = r104;
    L19:
        r103 = r104;
    L20:
        r103 = r104;
    L18:
        r103 = r104;
    L22:
        r103 = r104;
    L17:
        r103 = r104;
    L15:
        th = th;
        r103 = r104;
    L25:
        if (r103 != null) goto L61;
    L27:
        throw th;
    L61:
        r103.close();     // Catch: IOException -> L46
    L24:
        th = th;
    L41:
        if (r103 == null) goto L43;
        r103.close();     // Catch: IOException -> L53
    L56:
    L37:
        if (r103 == null) goto L43;
        r103.close();     // Catch: IOException -> L53
    L33:
        if (r103 == null) goto L43;
        r103.close();     // Catch: IOException -> L53
    L35:
        if (r103 == null) goto L43;
        r103.close();     // Catch: IOException -> L53
    L31:
        if (r103 == null) goto L43;
        r103.close();     // Catch: IOException -> L53
    L39:
        if (r103 == null) goto L43;
        r103.close();     // Catch: IOException -> L53
    L29:
        if (r103 == null) goto L43;
        r103.close();     // Catch: IOException -> L53
    L43:
        return false;
    }

    private String a(Context r100, String r101, boolean r102) {
        if (r100 != null) goto L5;
        return "";
    L5:
        String r103 = b(r100, r101);
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("style_id", r101);
        if (r102 == false) goto L8;
        r104.put("type", "publish");
    L9:
        r104.put("md5", r103);
        r104.put("token", SyncSysInfo.getAuthToken());
        String r105 = a(r104) + SyncSysInfo.getPhoneInfo();
        return a("api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle") + "?" + (r105 + "&sign=" + AppMD5.getSignMD5String(r105));
    L8:
        r104.put("type", "edit");
        goto L9
    }

    public static /* synthetic */ String a(c r100, Context r101, String r102) {
        return r100.a(r101, r102);
    }

    public void a(Context r100, String r101, InterfaceC0646c r102) {
        a(r100, r101, true, r102);
    }

    private void a(Context r100, String r110, String r111, InterfaceC0646c r112) {
        String r101 = a(r100, r111);
        if (b(r101) == false) goto L5;
        String r102 = r101;
    L7:
        if (TextUtils.isEmpty(r110) == false) goto L35;
        if (r112 == null) goto L37;
        HttpClient.HttpStateError r103 = HttpClient.HttpStateError.SERVER_ERROR;
        r112.onCustomMapStyleLoadFailed(r103.ordinal(), r103.name(), r102);
        return;
    L37:
        return;
    L35:
        JSONObject r104 = new JSONObject(r110);     // Catch: JSONException -> L31
        int r113 = r104.optInt("status");
        String r105 = r104.optString("message");
        if (a(r113, r101) == true) goto L17;
        if (r112 == null) goto L38;
        r112.onCustomMapStyleLoadSuccess(false, r102);
        return;
    L38:
        return;
    L17:
        if (r113 == 0) goto L21;
        if (r112 == null) goto L39;
        r112.onCustomMapStyleLoadFailed(r113, r105, r102);
        return;
    L39:
        return;
    L21:
        JSONObject r114 = r104.optJSONObject("data");
        if (r114 != null) goto L24;
    L28:
        if (r112 == null) goto L40;
        r112.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), "custom style data is null", r102);
        return;
    L40:
        return;
    L24:
        if (r114.length() == 0) goto L28;
        String r106 = r114.optString("md5", "");
        a(r100, r114.optString("pb_url", ""), r111, r106, r112);
        return;
    L32:
        if (r112 == null) goto L41;
        r112.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "parse response result failed", r102);
        return;
    L41:
        return;
    L5:
        r102 = null;
        goto L7
    }

    private void b(Context r100, String r101, String r102, InterfaceC0646c r103) {
        this.f32129b.get(r101, new a(this, r100, r102, r103));
    }

    private void a(Context r100, String r101, boolean r102, InterfaceC0646c r103) {
        String r104 = a(r100, r101);
        if (b(r104) == true) goto L6;
        r104 = null;
    L6:
        if (r103 == null) goto L9;
        r103.onPreLoadLastCustomMapStyle(r104);
    L9:
        if (NetworkUtil.isNetworkAvailable(r100) == true) goto L14;
        if (r103 == null) goto L21;
        HttpClient.HttpStateError r105 = HttpClient.HttpStateError.NETWORK_ERROR;
        r103.onCustomMapStyleLoadFailed(r105.ordinal(), r105.name(), r104);
        return;
    L21:
        return;
    L14:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        return;
    L16:
        String r106 = a(r100, r101, r102);
        if (TextUtils.isEmpty(r106) == false) goto L19;
        return;
    L19:
        b(r100, r106, r101, r103);
    }

    public static /* synthetic */ boolean a(c r100, Context r101, File r102, String r103) {
        return r100.a(r101, r102, r103);
    }

    public static /* synthetic */ void a(c r100, Context r101, String r102, String r103) {
        r100.a(r101, r102, r103);
    }

    private void a(Context r110, String r111, String r112, String r113, InterfaceC0646c r114) {
        if (TextUtils.isEmpty(r111) == true) goto L8;
        if (r110 == null) goto L9;
        String r100 = a(r111);
        String r101 = a(r110, r112);
        new com.baidu.mapsdkplatform.comapi.commonutils.b.c().a(r100, r110.getFilesDir().getAbsolutePath(), r112 + ".zip", 2, new b(this, r110, r112, r114, r113, r101));
        return;
    L9:
        return;
    }

    public static /* synthetic */ void a(c r100, Context r101, String r102, String r103, InterfaceC0646c r104) {
        r100.a(r101, r102, r103, r104);
    }
}
