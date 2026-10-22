package com.apm.lite.j;

import android.text.TextUtils;
import com.apm.lite.Npth;
import com.apm.lite.k.p;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f29956a;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f29957a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f29958b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f29959c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a[] f29960e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f29961d;

        static {
            a r100 = new a(UserProfileEvent.POSITION_NONE, 0, 0);
            f29957a = r100;
            a r101 = new a("GZIP", 1, 1);
            f29958b = r101;
            a r102 = new a("DEFLATER", 2, 2);
            f29959c = r102;
            f29960e = new a[]{r100, r101, r102};
        }

        public a(String r100, int r101, int r102) {
            super(r100, r101);
            this.f29961d = r102;
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        public static a[] values() {
            return (a[]) f29960e.clone();
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f29962a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f29963b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f29964c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f29965d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f29966e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f29967f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f29968g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f29969h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f29970i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f29971j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f29972k = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ b[] f29973m = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final int f29974l;

        static {
            b r100 = new b(UserProfileEvent.POSITION_NONE, 0, 0);
            f29962a = r100;
            b r101 = new b("MOBILE", 1, 1);
            f29963b = r101;
            b r102 = new b("MOBILE_2G", 2, 2);
            f29964c = r102;
            b r103 = new b("MOBILE_3G", 3, 3);
            f29965d = r103;
            b r104 = new b("WIFI", 4, 4);
            f29966e = r104;
            b r105 = new b("MOBILE_4G", 5, 5);
            f29967f = r105;
            b r110 = new b("MOBILE_5G", 6, 6);
            f29968g = r110;
            b r111 = new b("WIFI_24GHZ", 7, 7);
            f29969h = r111;
            b r112 = new b("WIFI_5GHZ", 8, 8);
            f29970i = r112;
            b r113 = new b("MOBILE_3G_H", 9, 9);
            f29971j = r113;
            b r114 = new b("MOBILE_3G_HP", 10, 10);
            f29972k = r114;
            f29973m = new b[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public b(String r100, int r101, int r102) {
            super(r100, r101);
            this.f29974l = r102;
        }

        public static b valueOf(String r100) {
            return (b) r27.a.a(b.class, r100);
        }

        public static b[] values() {
            return (b[]) f29973m.clone();
        }
    }

    public static String e(String r100, String r101) {
        if (TextUtils.isEmpty(new URL(r100).getQuery()) == false) goto L9;
        if (r100.endsWith("?") == true) goto L11;
        r100 = r100.concat("?");     // Catch: Throwable -> L13
    L11:
        return r100 + r101;
    L9:
        if (r100.endsWith("&") == true) goto L11;
        r100 = r100.concat("&");     // Catch: Throwable -> L13
    L16:
        return r100;
    }

    public static byte[] g(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[8192];
    L3:
        int r103 = r100.read(r102);
        if ((-1) == r103) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    L6:
        r100.close();
        byte[] r104 = r101.toByteArray();     // Catch: Throwable -> L10
        com.apm.lite.k.j.a(r101);
        return r104;
    L10:
        th = move-exception;
        com.apm.lite.k.j.a(r101);
        throw th;
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

    public static k b(String r100, String r101, File... r102) {
        if (Npth.isStopUpload() == true) goto L22;
    L15:
        e = move-exception;
        e.printStackTrace();
        return new k(207);
    L6:
        if (TextUtils.equals("sdk", "app") == false) goto L8;
        String r103 = "&encrypt=true";
    L9:
        h r104 = new h(e(r100, "have_dump=true".concat(r103)), null, true);     // Catch: IOException -> L15
        r104.c("json", r101, true);     // Catch: IOException -> L15
        r104.d(r102);     // Catch: IOException -> L15
        new JSONObject(r104.a());     // Catch: JSONException -> L12 IOException -> L15
    L24:
        return new k();
    L12:
        e = move-exception;
        return new k(0, e);
    L8:
        r103 = "";
        goto L9
    L22:
        return new k(201);
    }

    public static k c(String r100, byte[] r101, a r102, boolean r103) {
        if (Npth.isStopUpload() == true) goto L5;
        if (r100 != null) goto L10;
        return new k(201);
    L10:
        if (r101 != null) goto L12;
        r101 = new byte[0];
    L12:
        int r104 = r101.length;
        String r105 = null;
        if (a.f29958b != r102) goto L25;
        if (r104 <= 128) goto L25;
        ByteArrayOutputStream r106 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r107 = new GZIPOutputStream(r106);
        r107.write(r101);     // Catch: Throwable -> L18
        r107.close();
        r101 = r106.toByteArray();
    L20:
        r105 = DownloadHelper.GZIP;
    L32:
        if (r101 == null) goto L34;
        if (r103 == false) goto L47;
        if (TextUtils.isEmpty(new URL(r100).getQuery()) == false) goto L41;
        String r108 = "?";
        if (r100.endsWith("?") == true) goto L45;
    L43:
        r100 = r100.concat(r108);
    L45:
        return d(r100 + "tt_data=a", r101, DownloadNetworkFactory.ContentType.TT_DATA, r105);
    L41:
        r108 = "&";
        if (r100.endsWith("&") == true) goto L45;
    L47:
        return d(r100, r101, "application/json; charset=utf-8", r105);
    L34:
        return new k(202);
    L18:
        p.c();     // Catch: Throwable -> L21
        r107.close();
        r101 = null;
    L21:
        th = move-exception;
        r107.close();
        throw th;
    L25:
        if (a.f29959c != r102) goto L32;
        if (r104 <= 128) goto L32;
        ByteArrayOutputStream r109 = new ByteArrayOutputStream(8192);
        Deflater r110 = new Deflater();
        r110.setInput(r101);
        r110.finish();
        byte[] r111 = new byte[8192];
    L29:
        if (r110.finished() == true) goto L31;
        r109.write(r111, 0, r110.deflate(r111));
        goto L29
    L31:
        r110.end();
        r101 = r109.toByteArray();
        r105 = "deflate";
        goto L32
    L5:
        return new k(201);
    }

    public static k d(String r100, byte[] r101, String r102, String r103) {
        HttpURLConnection r104 = null;
        GZIPInputStream r105 = null;
        InputStream r106 = null;
        HttpURLConnection r107 = (HttpURLConnection) a(new URL(r100));     // Catch: Throwable -> L44
        o1.a.a(r107);     // Catch: Throwable -> L41
        r107.setDoOutput(true);     // Catch: Throwable -> L41
        r107.setRequestProperty("Content-Type", r102);     // Catch: Throwable -> L41
        if (r103 == null) goto L7;
        r107.setRequestProperty("Content-Encoding", r103);     // Catch: Throwable -> L41
    L7:
        r107.setRequestProperty("Accept-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L41
        r107.setRequestMethod("POST");     // Catch: Throwable -> L41
        if (r101.length <= 0) goto L19;
        DataOutputStream r108 = new DataOutputStream(r107.getOutputStream());     // Catch: Throwable -> L14
        r108.write(r101);     // Catch: Throwable -> L12
        r108.flush();     // Catch: Throwable -> L12
        com.apm.lite.k.j.a(r108);     // Catch: Throwable -> L41
    L12:
        th = th;
    L16:
        com.apm.lite.k.j.a(r108);     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L14:
        th = th;
        r108 = null;
    L19:
        if (r107.getResponseCode() != 200) goto L38;
        InputStream r109 = r107.getInputStream();     // Catch: Throwable -> L41
    L36:
        Throwable th10 = th;
        r106 = r109;
    L43:
        InputStream r110 = r106;
        r104 = r107;
        InputStream r111 = r110;
    L68:
        com.apm.lite.e.f29913e.isDebugMode();     // Catch: Throwable -> L51
        k r112 = new k(207, th10);     // Catch: Throwable -> L51
        if (r104 != null) goto L60;
    L49:
        com.apm.lite.k.j.a(r111);
        return r112;
    L60:
        r104.disconnect();     // Catch: Exception -> L58
    L51:
        th = move-exception;
        if (r104 != null) goto L66;
    L54:
        com.apm.lite.k.j.a(r111);
        throw th;
    L66:
        r104.disconnect();     // Catch: Exception -> L59
        goto L54
    L22:
        if (DownloadHelper.GZIP.equalsIgnoreCase(r107.getContentEncoding()) == true) goto L80;
        byte[] r113 = g(r109);     // Catch: Throwable -> L36
    L33:
        k r114 = new k(r113);     // Catch: Throwable -> L36
        r107.disconnect();     // Catch: Exception -> L56
    L35:
        com.apm.lite.k.j.a(r109);
        return r114;
    L80:
        GZIPInputStream r115 = new GZIPInputStream(r109);     // Catch: Throwable -> L28
        r113 = g(r115);     // Catch: Throwable -> L26
        com.apm.lite.k.j.a(r115);     // Catch: Throwable -> L36
    L26:
        Throwable th11 = th;
        r105 = r115;
    L30:
        com.apm.lite.k.j.a(r105);     // Catch: Throwable -> L36
        throw th11;     // Catch: Throwable -> L36
    L28:
        th = move-exception;
        th11 = th;
        goto L30
    L38:
        k r116 = new k(206, 0);     // Catch: Throwable -> L41
        r107.disconnect();     // Catch: Exception -> L57
        return r116;
    L84:
        return r116;
    L41:
        th = move-exception;
        th10 = th;
    L44:
        th = move-exception;
        th10 = th;
        r111 = null;
        goto L68
    }

    public static boolean f(String r100, String r101, String r102, String r103, List<String> r104) {
        if (Npth.isStopUpload() == false) goto L25;
        return false;
    L25:
        HashMap r105 = new HashMap();     // Catch: IOException -> L21
        r105.put("aid", r101);     // Catch: IOException -> L21
        String r106 = com.apm.lite.d.f(r101);     // Catch: IOException -> L21
        if (TextUtils.isEmpty(r106) == true) goto L8;
        r105.put("x-auth-token", r106);     // Catch: IOException -> L21
    L8:
        h r107 = new h(r100, r105, false);     // Catch: IOException -> L21
        r107.c("aid", r101, false);     // Catch: IOException -> L21
        r107.c("device_id", r102, false);     // Catch: IOException -> L21
        r107.c("os", "Android", false);     // Catch: IOException -> L21
        r107.c("process_name", r103, false);     // Catch: IOException -> L21
        Iterator<String> r108 = r104.iterator();     // Catch: IOException -> L21
    L10:
        if (r108.hasNext() == false) goto L27;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r108.next());     // Catch: IOException -> L21
        if (r109.exists() == false) goto L10;
        HashMap r110 = new HashMap();     // Catch: IOException -> L21
        r110.put("logtype", CloudControlInf.ALOG);     // Catch: IOException -> L21
        r110.put("scene", "crash");     // Catch: IOException -> L21
        r107.b(r109.getName(), r109, r110);     // Catch: IOException -> L21
        goto L10
    L27:
        goto L20
    L17:
        if (new JSONObject(r107.a()).optInt(LKBaseResponseModel.ERROR_NO_KEY, -1) != 200) goto L20;
        return true;
    L20:
        return false;
    L21:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
