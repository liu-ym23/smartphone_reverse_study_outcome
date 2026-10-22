package com.bytedance.crash.upload;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.ad;
import com.bytedance.crash.af;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crash.o.r;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLContext;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashUploader.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "NPTH-CrashUpload";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f7785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f7786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.bytedance.crash.l.c f7787c;

    /* JADX INFO: compiled from: CrashUploader.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7788a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7789b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f7790c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f7791e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f7792d;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f7791e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("NONE", 0, 0);
            f7788a = r0;
            a r1 = new a("GZIP", 1, 1);
            f7789b = r1;
            a r3 = new a("DEFLATER", 2, 2);
            f7790c = r3;
            f7791e = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f7792d = r3;
        }
    }

    public static void a(com.bytedance.crash.l.c r2) {
        f7787c = (com.bytedance.crash.l.c) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.l.c.class, "com.obric.aiagent.plugin");
    }

    public static void a(f r2) {
        f7785a = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin");
    }

    public static void a(g r2) {
        f7786b = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
    }

    public static f a() {
        return f7785a;
    }

    public static l a(String r1, String r2) {
        return a(r1, r2, false);
    }

    public static l a(String r1, String r2, boolean r3) {
    L11:
        th = move-exception;
        r.a(th);
        return new l(207, th);
    L3:
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (TextUtils.isEmpty(r1) == true) goto L10;
        return a(r1, r2.getBytes(), a.f7789b, r3);
    L10:
        return new l(201);
    }

    public static byte[] a(String r6) {
        return a(r6, null, DownloadHelper.GZIP, "GET", false, false).b();
    }

    public static l a(String r10, byte[] r11, a r12, boolean r13) {
        if (r10 == null) goto L36;
        if (r11 == null) goto L36;
        if (ad.g() == true) goto L36;
        int r0 = r11.length;
        byte[] r3 = null;
        if (a.f7789b != r12) goto L13;
        if (r0 <= 128) goto L13;
        r11 = a(r11);
        String r14 = DownloadHelper.GZIP;
    L11:
        String r6 = r14;
    L17:
        if (r11 == null) goto L19;
        if (r13 == false) goto L22;
        r3 = com.bytedance.crash.config.h.c().a(r11);
    L22:
        if (r3 != null) goto L24;
        String r4 = r10;
        byte[] r5 = r11;
    L34:
        return a(r4, r5, r6, "POST", true, r13);
    L24:
        if (TextUtils.isEmpty(new URL(r10).getQuery()) == false) goto L29;
        if (r10.endsWith("?") == true) goto L31;
        r10 = r10 + "?";
    L31:
        r4 = r10 + "tt_data=a";
        r5 = r3;
        goto L34
    L29:
        if (r10.endsWith("&") == true) goto L31;
        r10 = r10 + "&";
        goto L31
    L19:
        return new l(202);
    L13:
        if (a.f7790c != r12) goto L16;
        if (r0 <= 128) goto L16;
        r11 = b(r11);
        r14 = "deflate";
    L16:
        r6 = null;
    L36:
        return new l(201);
    }

    private static l a(String r16, byte[] r17, String r18, String r19, boolean r20, boolean r21) {
        String r0 = r16;
        r.b("CustomException", "executeRequest:upload:" + r0);
        HttpURLConnection r7 = null;
        f r8 = a();     // Catch: Throwable -> L72
        if (r8 == null) goto L107;
        r0 = r8.a(r0, r17);     // Catch: Throwable -> L82
    L107:
        SSLContext.getInstance("TLS").init(null, null, null);     // Catch: Throwable -> L83
    L7:
        URL r9 = new URL(r0);     // Catch: Throwable -> L72
        long r10 = k.a(null, r9);     // Catch: Throwable -> L72
        if (r10 < 0) goto L11;
        if (r10 > 0) goto L16;
        com.bytedance.crash.l.b r11 = af.a();     // Catch: Throwable -> L72
        if (r11 != null) goto L106;
        com.bytedance.crash.l.e r1 = af.c();     // Catch: Throwable -> L84
        if (r1 == null) goto L40;
        r1.a("urlconnection");     // Catch: Throwable -> L84
    L40:
        HttpURLConnection r4 = a(r9);     // Catch: Throwable -> L72
        r4.setDoOutput(r20);     // Catch: Throwable -> L70
        if (r21 == false) goto L44;
        r4.setRequestProperty(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L70
    L45:
        if (r18 == null) goto L47;
        r4.setRequestProperty(DownloadHelper.CONTENT_ENCODING, r18);     // Catch: Throwable -> L70
    L47:
        r4.setRequestProperty(DownloadHelper.ACCEPT_ENCODING, DownloadHelper.GZIP);     // Catch: Throwable -> L70
        r4.setRequestMethod(r19);     // Catch: Throwable -> L70
        if (r17 != null) goto L50;
    L60:
        int r2 = r4.getResponseCode();     // Catch: Throwable -> L70
        l r3 = new l(0);     // Catch: Throwable -> L70
        r3.b(r2);     // Catch: Throwable -> L70
        r3.a(r4.getHeaderFields());     // Catch: Throwable -> L70
        if (r2 != 200) goto L66;
        byte[] r5 = a(r4);     // Catch: Throwable -> L70
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L70
        r6 = new JSONObject(new String(r5));     // Catch: Throwable -> L85
    L65:
        r.b("CustomException", "uploadEvent:upload:" + r6);     // Catch: Throwable -> L70
        r3.a(r6);     // Catch: Throwable -> L70
        r3.a(r5);     // Catch: Throwable -> L70
        k.a(r9, r3);     // Catch: Throwable -> L70
    L67:
        if (r4 != null) goto L97;
    L69:
        return r3;
    L97:
        r4.disconnect();     // Catch: Exception -> L86
        goto L69
    L66:
        k.a(r9, r3);     // Catch: Throwable -> L70
        r3.a(207);     // Catch: Throwable -> L70
        r3.a("http response code " + r2);     // Catch: Throwable -> L70
        goto L67
    L50:
        if (r17.length <= 0) goto L60;
        DataOutputStream r12 = new DataOutputStream(r4.getOutputStream());     // Catch: Throwable -> L56
        r12.write(r17);     // Catch: Throwable -> L54
        r12.flush();     // Catch: Throwable -> L54
        com.bytedance.crash.o.i.a(r12);     // Catch: Throwable -> L70
    L54:
        th = th;
        DataOutputStream r13 = r12;
    L58:
        com.bytedance.crash.o.i.a(r13);     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L56:
        th = th;
        r13 = null;
        goto L58
    L44:
        r4.setRequestProperty(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8");     // Catch: Throwable -> L70
    L70:
        th = th;
        r7 = r4;
    L93:
        r.b(th);     // Catch: Throwable -> L78
        l r14 = new l(207);     // Catch: Throwable -> L78
        if (r7 != null) goto L109;
    L77:
        return r14;
    L109:
        r7.disconnect();     // Catch: Exception -> L87
    L78:
        th = move-exception;
        if (r7 != null) goto L91;
    L81:
        throw th;
    L91:
        r7.disconnect();     // Catch: Exception -> L88
        goto L81
    L106:
        HashMap r15 = new HashMap();     // Catch: Throwable -> L35
        if (r21 == false) goto L23;
        r15.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L35
    L24:
        if (r18 == null) goto L26;
        r15.put(DownloadHelper.CONTENT_ENCODING, r18);     // Catch: Throwable -> L35
    L26:
        r15.put(DownloadHelper.ACCEPT_ENCODING, DownloadHelper.GZIP);     // Catch: Throwable -> L35
        if (r20 == false) goto L29;
        Pair<Integer, byte[]> r22 = r11.a(r0, r17, r15);     // Catch: Throwable -> L35
    L30:
        if (r22 != null) goto L34;
        return new l(207, "http response code ");
    L34:
        return new l(((Integer) ZeusTransformUtils.preCheckCast(r22.first, Integer.class, "com.obric.aiagent.plugin")).intValue(), (byte[]) ZeusTransformUtils.preCheckCast(r22.second, byte[].class, "com.obric.aiagent.plugin"));
    L29:
        r22 = r11.a(r0, r15);     // Catch: Throwable -> L35
        goto L30
    L23:
        r15.put(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8");     // Catch: Throwable -> L35
        goto L24
    L36:
        return new l(207, "http response code ");
    L16:
        return new l(214);
    L11:
        return new l(213);
    L12:
        th = th;
    L72:
        th = th;
        r7 = null;
        goto L93
    }

    private static byte[] a(HttpURLConnection r3) {
        InputStream r0 = null;
        InputStream r1 = r3.getInputStream();     // Catch: Throwable -> L20 Exception -> L23
    L33:
    L18:
        th = th;
        r0 = r1;
    L21:
        com.bytedance.crash.o.i.a(r0);
        throw th;
    L5:
        if (DownloadHelper.GZIP.equalsIgnoreCase(r3.getContentEncoding()) == true) goto L27;
        byte[] r2 = d.a(r1);     // Catch: Throwable -> L18 Exception -> L26
    L16:
        com.bytedance.crash.o.i.a(r1);
        return r2;
    L27:
        GZIPInputStream r4 = new GZIPInputStream(r1);     // Catch: Throwable -> L11
        r2 = d.a(r4);     // Catch: Throwable -> L9
        com.bytedance.crash.o.k.a(r4);     // Catch: Throwable -> L18 Exception -> L26
    L9:
        th = th;
    L13:
        com.bytedance.crash.o.k.a(r4);     // Catch: Throwable -> L18 Exception -> L26
        throw th;     // Catch: Throwable -> L18 Exception -> L26
    L11:
        th = th;
        r4 = null;
    L24:
        com.bytedance.crash.o.i.a(r1);
        return null;
    L23:
        r1 = null;
    L20:
        th = th;
        goto L21
    }

    public static l a(String r7, String r8, String r9, List<File> r10) {
        List<File> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        r.b("upload crashType " + r7);
        r.b("upload url " + r8);
        Iterator<File> r0 = r11.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        r.b("upload attachments " + ((File) ZeusTransformUtils.preCheckCast(r0.next(), File.class, "com.obric.aiagent.plugin")).getAbsolutePath());
        goto L4
    L7:
        if (ad.g() == false) goto L40;
        return new l(201);
    L40:
        long r3 = k.a(null, new URL(r8));     // Catch: IOException -> L35
        if (r3 < 0) goto L14;
        if (r3 > 0) goto L17;
        com.bytedance.crash.l.b r1 = af.a();     // Catch: IOException -> L35
        if (r1 != null) goto L45;
        com.bytedance.crash.l.e r2 = af.c();     // Catch: Throwable -> L39
        if (r2 == null) goto L33;
        r2.a("urlconnection");     // Catch: Throwable -> L39
    L33:
        c r4 = new c(o.a(r8, "have_dump=true&encrypt=true"), true);     // Catch: IOException -> L35
        r4.a("json", r9, true);     // Catch: IOException -> L35
        r4.a("file", r11);     // Catch: IOException -> L35
        r4.a(r7);     // Catch: IOException -> L35
        l r12 = r4.a();     // Catch: IOException -> L35
        r.b(TAG, "uploadCrashLogWithAttachment:" + r7 + " success");     // Catch: IOException -> L35
        return r12;
    L45:
        byte[] r13 = r9.getBytes();     // Catch: Exception -> L28 IOException -> L35
        com.bytedance.crash.o r14 = com.bytedance.crash.config.h.c();     // Catch: Exception -> L28 IOException -> L35
        if (r14 == null) goto L24;
        r13 = r14.a(r13);     // Catch: Exception -> L28 IOException -> L35
        String r15 = o.a(r8, "have_dump=true&encrypt=true");     // Catch: Exception -> L28 IOException -> L35
    L25:
        com.bytedance.crash.l.d r16 = r1.a(r15, "UTF-8", true);     // Catch: Exception -> L28 IOException -> L35
        r16.a("json", r13);     // Catch: Exception -> L28 IOException -> L35
        r16.a("file", r11);     // Catch: Exception -> L28 IOException -> L35
        Pair<Integer, String> r17 = r16.a();     // Catch: Exception -> L28 IOException -> L35
        l r18 = a(((Integer) ZeusTransformUtils.preCheckCast(r17.first, Integer.class, "com.obric.aiagent.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r17.second, String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L28 IOException -> L35
        k.a(new URL(r15), r18);     // Catch: Throwable -> L38
    L27:
        return r18;
        goto L29
    L24:
        r15 = o.a(r8, "have_dump=true");     // Catch: Exception -> L28 IOException -> L35
    L29:
        return new l(207);
    L17:
        return new l(214);
    L14:
        return new l(213);
    L35:
        e = move-exception;
        e.printStackTrace();
        r.a("err upload crash log " + e);
        return new l(207);
    }

    public static boolean a(String r7, String r8, String r9, String r10, File r11) {
        com.bytedance.crash.l.b r0 = af.a();
        if (r0 == null) goto L33;
        com.bytedance.crash.l.d r1 = r0.a(r8, "UTF-8", false);     // Catch: Throwable -> L8
        if (r1 == null) goto L33;
        r1.a("data", r10);     // Catch: Throwable -> L8
        r1.a("header", r9);     // Catch: Throwable -> L8
        r1.a("file", r11);     // Catch: Throwable -> L8
        r1.a();     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    L33:
        com.bytedance.crash.l.e r2 = af.c();     // Catch: Throwable -> L26
        if (r2 == null) goto L31;
        r2.a("urlconnection");     // Catch: Throwable -> L26
    L31:
        c r3 = new c(r8, false);     // Catch: IOException -> L23
        r3.a("data", r10);     // Catch: IOException -> L23
        r3.a("header", r9);     // Catch: IOException -> L23
        r3.a("file", r11);     // Catch: IOException -> L23
        r3.a(r7);     // Catch: IOException -> L23
        l r12 = r3.a();     // Catch: Exception -> L20
        JSONObject r13 = r12.c();     // Catch: Exception -> L20
        if (r13 != null) goto L17;
        return false;
    L17:
        if ("success".equals(r13.getString("message")) == true) goto L22;
        r.a("corefile upload err msg=" + r12);     // Catch: Exception -> L20
        return false;
    L22:
        return true;
    L20:
        e = move-exception;
        e.printStackTrace();
        r.a("corefile responses err" + e);
    L23:
        e = move-exception;
        e.printStackTrace();
        r.a("corefile upload err" + e);
        return false;
    }

    public static boolean a(String r3, JSONObject r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L11:
        return false;
    L5:
        if (com.bytedance.crash.o.l.a(r4) == true) goto L11;
        return a(r3, r4.toString().getBytes(), a.f7789b, true).a();
    L9:
        th = move-exception;
        r.a(th);
        goto L11
    }

    public static boolean a(String r18, int r19, String r20, String r21, List<String> r22) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        if (ad.g() == false) goto L5;
        return false;
    L5:
        com.bytedance.crash.l.b r5 = af.a();
        String r7 = "npth";
        if (r5 != null) goto L9;
        String r6 = "errno";
    L69:
        com.bytedance.crash.l.e r13 = af.c();     // Catch: Throwable -> L64
        if (r13 == null) goto L39;
        String r16 = r6;
        r13.a("urlconnection");     // Catch: Throwable -> L62
    L77:
        c r8 = new c(r18, false);     // Catch: IOException -> L59
        r8.a(WsConstants.KEY_APP_ID, String.valueOf(r19));     // Catch: IOException -> L59
        r8.a("device_id", r20);     // Catch: IOException -> L59
        r8.a(RomInfo.KEY_OS_TYPE, "Android");     // Catch: IOException -> L59
        r8.a("process_name", r21);     // Catch: IOException -> L59
        Iterator r0 = r3.iterator();     // Catch: IOException -> L59
    L42:
        if (r0.hasNext() == false) goto L46;
        File r2 = new File((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: IOException -> L59
        if (r2.exists() == false) goto L42;
        HashMap r1 = new HashMap();     // Catch: IOException -> L59
        r1.put("logtype", "alog");     // Catch: IOException -> L59
        r1.put(DBHelper.BATTERY_COL_SCENE, r7);     // Catch: IOException -> L59
        r8.a(r2, r1);     // Catch: IOException -> L59
        goto L42
    L46:
        r8.a("alog");     // Catch: IOException -> L59
        JSONObject r4 = r8.a().c();     // Catch: Exception -> L57
        if (r4 != null) goto L71;
        return false;
    L71:
        if (r4.optInt(r16, -1) != 200) goto L88;
        return true;
    L88:
        return false;
    L89:
        return false;
    L57:
        return false;
    L59:
        e = move-exception;
        e.printStackTrace();
        return false;
    L39:
        r16 = r6;
        goto L77
    L9:
        String r17 = "npth";
        com.bytedance.crash.l.d r9 = r5.a(r18, "UTF-8", false);     // Catch: Throwable -> L30
        if (r9 != null) goto L67;
        r6 = "errno";
        r7 = r17;
        goto L69
    L67:
        r9.a(WsConstants.KEY_APP_ID, String.valueOf(r19));     // Catch: Throwable -> L31
        r9.a("device_id", r20);     // Catch: Throwable -> L31
        r9.a(RomInfo.KEY_OS_TYPE, "Android");     // Catch: Throwable -> L31
        r9.a("process_name", r21);     // Catch: Throwable -> L31
        Iterator r10 = r3.iterator();     // Catch: Throwable -> L31
    L14:
        if (r10.hasNext() == false) goto L20;
        File r11 = new File((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L31
        if (r11.exists() == false) goto L18;
        HashMap r12 = new HashMap();     // Catch: Throwable -> L31
        r12.put("logtype", "alog");     // Catch: Throwable -> L31
        String r14 = r17;
        r12.put(DBHelper.BATTERY_COL_SCENE, r14);     // Catch: Throwable -> L31
        r9.a(r11, r12);     // Catch: Throwable -> L31
    L19:
        r17 = r14;
        goto L14
    L18:
        r14 = r17;
        goto L19
    L20:
        Pair<Integer, String> r15 = r9.a();     // Catch: Throwable -> L31
        if (r15 == null) goto L27;
        if (new JSONObject((String) ZeusTransformUtils.preCheckCast(r15.second, String.class, "com.obric.aiagent.plugin")).optInt("errno", -1) != 200) goto L90;
        return true;
    L90:
        return false;
    L27:
        return false;
    L31:
        return false;
    L87:
        return false;
    }

    public static boolean a(String r4, String r5, File... r6) {
        ArrayList r0 = new ArrayList();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(r6[r2]);
        r2 = r2 + 1;
        goto L3
    L6:
        return a("ensure_zip", r4, r5, r0).a();
    }

    private static byte[] a(byte[] r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L6
        r1.close();
        return r0.toByteArray();
    L6:
        th = move-exception;
        r.a(th);     // Catch: Throwable -> L10
        r1.close();
        return null;
    L10:
        th = move-exception;
        r1.close();
        throw th;
    }

    private static byte[] b(byte[] r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        Deflater r2 = new Deflater();
        r2.setInput(r4);
        r2.finish();
        byte[] r5 = new byte[8192];
    L4:
        if (r2.finished() == true) goto L6;
        r0.write(r5, 0, r2.deflate(r5));
        goto L4
    L6:
        r2.end();
        return r0.toByteArray();
    }

    public static HttpURLConnection a(URL r2) {
        com.bytedance.crash.l.c r0 = f7787c;
        if (r0 != null) goto L6;
        return (HttpURLConnection) ZeusTransformUtils.preCheckCast(b(r2), HttpURLConnection.class, "com.obric.aiagent.plugin");
    L6:
        return r0.a(r2);
    }

    private static l a(int r3, String r4) {
        l r0 = new l(r3);
        if (r3 == 200) goto L10;
        r0.a(207);
    L10:
        JSONObject r5 = new JSONObject(r4);     // Catch: JSONException -> L7
    L8:
        r0.a(r5);
        r0.a(r4.getBytes());
        return r0;
    L7:
        r5 = new JSONObject();
        r0.a(207);
        goto L8
    }

    @Skip({"com.obric.aiagent.okhttp"})
    public static URLConnection b(URL r4) {
        URL r0 = (URL) ZeusTransformUtils.preCheckCast(r4, URL.class, "com.obric.aiagent.plugin");
        String r1 = r0.getHost();
        String r2 = r0.getPath();
        if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L5;
        ILogDepend.Companion.i("AiAgentUrlConnLancet", "openConnection drop host=" + r1 + " path=" + r2);
        com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
        throw new IOException("[NetGuard] dropped ");
    L5:
        return r4.openConnection();
    }
}
