package com.apm.lite.k;

import android.content.Context;
import android.text.TextUtils;
import com.apm.lite.CrashType;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class h {
    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return a(new PolarisFileWrapper(r100));
    }

    public static JSONArray d(PolarisFileWrapper r100, long r101) {
        JSONArray r102 = new JSONArray();
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L15
        if (r101 <= 0) goto L7;
        r103.skip(r101);     // Catch: Throwable -> L13
        r103.readLine();     // Catch: Throwable -> L13
    L13:
        th = th;
    L17:
        j.a(r103);
        throw th;
    L7:
        String r104 = r103.readLine();     // Catch: Throwable -> L13
        if (r104 == null) goto L11;
        r102.put(r104);     // Catch: Throwable -> L13
        goto L7
    L11:
        j.a(r103);
        return r102;
    L15:
        th = th;
        r103 = null;
        goto L17
    }

    public static void e(PolarisFileWrapper r100, PolarisFileWrapper r101) {
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileOutputStreamWrapper r104 = null;
        r102 = null;
        r101.getParentFile().mkdirs();     // Catch: Throwable -> L22 Exception -> L24
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L22 Exception -> L24
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L16 Exception -> L19
    L37:
        byte[] r107 = new byte[8192];     // Catch: Throwable -> L12 Exception -> L14
    L7:
        int r108 = r105.read(r107);     // Catch: Throwable -> L12 Exception -> L14
        if (r108 <= 0) goto L11;
        r106.write(r107, 0, r108);     // Catch: Throwable -> L12 Exception -> L14
    L11:
        j.a(r105);
    L28:
        j.a(r106);
        return;
    L14:
        Exception e100 = e;
        r103 = r106;
    L21:
        r106 = r103;
        r102 = r105;
    L33:
        e100.printStackTrace();     // Catch: Throwable -> L30
        j.a(r102);
    L30:
        Throwable th10 = th;
    L31:
        j.a(r102);
        j.a(r106);
        throw th10;
    L12:
        th10 = th;
        r104 = r106;
    L18:
        r106 = r104;
        r102 = r105;
    L19:
        e = move-exception;
        e100 = e;
    L16:
        th = move-exception;
        th10 = th;
        goto L18
    L24:
        e = move-exception;
        e100 = e;
        r106 = null;
    L22:
        th = move-exception;
        th10 = th;
        r106 = null;
        goto L31
    }

    public static void h(File r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        r100.getParentFile().mkdirs();
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r100, r102);     // Catch: Throwable -> L12
        r104.write(r101.getBytes());     // Catch: Throwable -> L10
        r104.flush();     // Catch: Throwable -> L10
        j.a(r104);
        return;
    L10:
        th = th;
        r103 = r104;
    L13:
        j.a(r103);
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static void i(File r100, Map<String, String> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.isEmpty() == true) goto L34;
        PolarisFileOutputStreamWrapper r102 = null;
        Properties r103 = new Properties();     // Catch: Throwable -> L17 IOException -> L26
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r100);     // Catch: Throwable -> L17 IOException -> L26
        Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();     // Catch: Throwable -> L14 IOException -> L16
    L10:
        if (r105.hasNext() == false) goto L12;
        Map.Entry<String, String> r106 = r105.next();     // Catch: Throwable -> L14 IOException -> L16
        r103.setProperty(r106.getKey(), r106.getValue());     // Catch: Throwable -> L14 IOException -> L16
        goto L10
    L12:
        r103.store(r104, BdpAppEventConstant.NO);     // Catch: Throwable -> L14 IOException -> L16
        j.a(r104);
        return;
    L16:
        r102 = r104;
    L14:
        th = th;
    L23:
        j.a(r104);
        throw th;
    L17:
        th = th;
        r104 = r102;
    L19:
        p.c();     // Catch: Throwable -> L17
        j.a(r102);
        return;
    }

    public static void j(ZipOutputStream r100, File r101, String r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.exists() == false) goto L44;
        int r103 = 0;
        if (r101.isDirectory() == false) goto L18;
        File[] r104 = r101.listFiles();
        if (r104 != null) goto L11;
        return;
    L11:
        r100.putNextEntry(new ZipEntry(r102 + HTTP.URL_DEFAULT));
        if (r102.length() != 0) goto L14;
        String r105 = "";
    L16:
        if (r103 >= r104.length) goto L43;
        j(r100, r104[r103], r105 + r104[r103].getName());
        r103 = r103 + 1;
        goto L16
    L43:
        return;
    L14:
        r105 = r102.concat(HTTP.URL_DEFAULT);
        goto L16
    L18:
        r100.putNextEntry(new ZipEntry(r102));
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L30
        byte[] r107 = new byte[4096];     // Catch: Throwable -> L28
    L22:
        int r108 = r106.read(r107);     // Catch: Throwable -> L28
        if ((-1) == r108) goto L26;
        r100.write(r107, 0, r108);     // Catch: Throwable -> L28
        goto L22
    L26:
        j.a(r106);
        return;
    L28:
        th = th;
    L32:
        j.a(r106);
        throw th;
    L30:
        th = th;
        r106 = null;
        goto L32
    }

    public static boolean k(File r100) {
        boolean r101 = true;
        if (r100.exists() == true) goto L6;
        return true;
    L6:
        if (r100.canWrite() == true) goto L9;
        return false;
    L9:
        if (r100.isFile() == false) goto L13;
        return r100.delete();
    L13:
        if (r100.isDirectory() == false) goto L33;
        File[] r102 = r100.listFiles();
        int r103 = 0;
    L15:
        if (r102 == null) goto L28;
        if (r103 >= r102.length) goto L28;
        if (r102[r103].isFile() == true) goto L21;
        boolean r104 = k(r102[r103]);
    L25:
        r101 = r101 & r104;
    L26:
        r103 = r103 + 1;
        goto L15
    L21:
        if (r102[r103].canWrite() == false) goto L23;
        r104 = r102[r103].delete();
        goto L25
    L23:
        r101 = false;
    L28:
        return r101 & r100.delete();
    L33:
        return true;
    }

    public static JSONArray l(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return d(new PolarisFileWrapper(r100), -1);
    }

    public static String n(String r100) {
        return b(r100);
    }

    public static Map<String, String> q(File r100) {
        PolarisFileInputStreamWrapper r101 = null;
        Properties r102 = new Properties();     // Catch: Throwable -> L11 IOException -> L13
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L11 IOException -> L13
        r102.load(r103);     // Catch: IOException -> L21 Throwable -> L17
        Set<String> r104 = r102.stringPropertyNames();     // Catch: IOException -> L21 Throwable -> L17
        HashMap r105 = new HashMap();     // Catch: IOException -> L21 Throwable -> L17
        Iterator<String> r106 = r104.iterator();     // Catch: IOException -> L21 Throwable -> L17
    L6:
        if (r106.hasNext() == false) goto L9;
        String r107 = r106.next();     // Catch: IOException -> L21 Throwable -> L17
        r105.put(r107, r102.getProperty(r107));     // Catch: IOException -> L21 Throwable -> L17
    L9:
        j.a(r103);
        return r105;
    L17:
        th = th;
        r101 = r103;
    L19:
        j.a(r101);
        throw th;
    L14:
        p.c();     // Catch: Throwable -> L17
        j.a(r103);
        return null;
    L13:
        r103 = null;
    L11:
        th = th;
        goto L19
    }

    public static String a(PolarisFileWrapper r100) {
        StringBuilder r101 = new StringBuilder();
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L15
    L19:
        String r103 = r102.readLine();     // Catch: Throwable -> L13
        if (r103 == null) goto L11;
        if (r101.length() == 0) goto L9;
        r101.append("\n");     // Catch: Throwable -> L13
    L9:
        r101.append(r103);     // Catch: Throwable -> L13
        goto L19
    L11:
        j.a(r102);
        return r101.toString();
    L13:
        th = th;
    L17:
        j.a(r102);
        throw th;
    L15:
        th = th;
        r102 = null;
        goto L17
    }

    public static k1.d p(String r100) {
        String r101 = n(r100);     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        return null;
    L6:
        JSONObject r102 = new JSONObject(r101);     // Catch: Throwable -> L8
        k1.d r103 = new k1.d();     // Catch: Throwable -> L8
        r103.f501338a = r102.optString("url");     // Catch: Throwable -> L8
        r103.f501339b = r102.optJSONObject(ContainerPosition.BODY);     // Catch: Throwable -> L8
        r103.f501340c = r102.optString("dump_file");     // Catch: Throwable -> L8
        r102.optBoolean(LBSLightLocationTraceLogger.ENCRYPT, false);     // Catch: Throwable -> L8
        return r103;
    L8:
        return null;
    }

    public static k1.d r(String r100) {
        JSONObject r101 = new JSONObject(n(r100));     // Catch: JSONException -> L10 IOException -> L12
        k1.d r102 = new k1.d();     // Catch: JSONException -> L10 IOException -> L12
        r102.f501342e = r101.optString("aid");     // Catch: JSONException -> L10 IOException -> L12
        r102.f501341d = r101.optString(com.bytedance.android.ec.core.event.a.KEY_DID);     // Catch: JSONException -> L10 IOException -> L12
        r102.f501343f = r101.optString("processName");     // Catch: JSONException -> L10 IOException -> L12
        ArrayList r103 = new ArrayList();     // Catch: JSONException -> L10 IOException -> L12
        JSONArray r104 = r101.optJSONArray("alogFiles");     // Catch: JSONException -> L10 IOException -> L12
        if (r104 == null) goto L9;
        int r105 = 0;
    L6:
        if (r105 >= r104.length()) goto L8;
        r103.add(JSONArrayProtectorUtils.getString(r104, r105));     // Catch: JSONException -> L10 IOException -> L12
        r105 = r105 + 1;     // Catch: JSONException -> L10 IOException -> L12
        goto L6
    L8:
        r102.f501344g = r103;     // Catch: JSONException -> L10 IOException -> L12
    L9:
        return r102;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static k1.d c(File r110, CrashType r111) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110, "logEventStack");
        boolean r101 = r110.getName().contains("oom");
        JSONObject r102 = new JSONObject();
        String r112 = "InvalidStack.NoStackAvailable: OOM.\n";
        if (r100.exists() == true) goto L139;
        if (r101 == true) goto L70;
    L69:
        r112 = "InvalidStack.NoStackAvailable: not OOM.\n";
    L70:
        String r103 = r112;
        String r104 = null;
        String r105 = null;
    L129:
        r102.put("data", r103);     // Catch: Exception -> L73
    L137:
        r102.put("process_name", r104);     // Catch: Exception -> L77
    L143:
        r102.put("crash_thread_name", r105);     // Catch: Exception -> L81
    L131:
        r102.put("isOOM", Boolean.valueOf(r101));     // Catch: Exception -> L85
    L86:
        int r106 = 0;
        boolean r107 = false;
    L88:
        if (r106 >= 6) goto L94;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r110, r110.getName() + ("." + r106));
        if (r108.exists() == false) goto L93;
        k1.a.m(r102, new JSONObject(b(r108.getAbsolutePath())));     // Catch: Throwable -> L126
        r107 = true;
    L93:
        r106 = r106 + 1;
        goto L88
    L94:
        if (r107 == false) goto L96;
        String r109 = "step";
    L97:
        Object r113 = r102.opt("data");
        if ((r113 instanceof JSONArray) == false) goto L100;
        JSONObject r114 = ((JSONArray) r113).optJSONObject(0);
    L101:
        k1.a.g(r114, "filters", "crash_type", r109);
        JSONObject r115 = r102.optJSONObject("header");
        Context r116 = com.apm.lite.e.f29909a;
        JSONObject r117 = k1.c.b(r102.optLong("crash_time", 0)).f501337a;
        if (r115 == null) goto L141;
        Iterator<String> r118 = r117.keys();
    L135:
        if (r118.hasNext() == false) goto L114;
        String r119 = r118.next();     // Catch: Throwable -> L113
        if (r115.has(r119) == true) goto L135;
        r115.put(r119, r117.opt(r119));     // Catch: Throwable -> L113
    L114:
        String r120 = r110.getName();
        String r121 = r120.substring(r120.lastIndexOf(95) + 1);
        JSONObject r122 = r102.optJSONObject("header");
        if (r122.optString("unique_key", null) == null) goto L127;
    L120:
        k1.d r123 = new k1.d();
        if (r111 != CrashType.LAUNCH) goto L123;
        String r124 = com.apm.lite.e.f29913e.getLaunchCrashUploadUrl();
    L124:
        r123.f501338a = r124;
        r123.f501339b = r102;
        TextUtils.equals("sdk", "app");
        return r123;
    L123:
        r124 = com.apm.lite.e.f29913e.getJavaCrashUploadUrl();
        goto L124
    L127:
        r122.put("unique_key", PerfLog.EVENT_PRE + com.apm.lite.e.d().a() + "_" + r121 + "_" + CrashType.LAUNCH);     // Catch: Throwable -> L118
    L118:
        th = move-exception;
        th.printStackTrace();
        goto L120
    L141:
        r102.put("header", r117);     // Catch: Exception -> L105
    L105:
        p.c();
        goto L114
    L100:
        r114 = r102;
        goto L101
    L96:
        r109 = "simple";
    L85:
        p.c();
    L81:
        p.c();
    L77:
        p.c();
    L73:
        p.c();
        goto L137
    L139:
        String r125 = b(r100.getAbsolutePath());     // Catch: IOException -> L6
    L8:
        if (TextUtils.isEmpty(r125) == false) goto L11;
        if (r101 == false) goto L69;
    L11:
        String[] r126 = r125.split("\n");
        ArrayList r127 = new ArrayList();
        StringBuilder r128 = new StringBuilder();
        StringBuilder r129 = new StringBuilder();
        int r130 = r126.length;
        int r131 = 0;
        boolean r132 = false;
        boolean r133 = false;
    L12:
        if (r131 >= r130) goto L29;
        String r134 = r126[r131];
        if (r132 == false) goto L16;
    L18:
        if (r133 == false) goto L20;
    L22:
        if (r133 == false) goto L24;
        r129.append(r134);
        r129.append("\n");
    L27:
        r131 = r131 + 1;
        goto L12
    L24:
        if (r132 == false) goto L26;
        r128.append(r134);
        r128.append("\n");
        goto L27
    L26:
        r127.add(r134);
        goto L27
    L20:
        if (r134.startsWith("err:") == false) goto L22;
        r133 = true;
        goto L27
    L16:
        if (r134.startsWith("stack:") == false) goto L18;
        r132 = true;
        goto L27
    L29:
        if (r127.size() < 1) goto L31;
        r104 = (String) ListProtector.get(r127, 0);
    L33:
        if (r127.size() < 2) goto L35;
        String r135 = (String) ListProtector.get(r127, 1);
    L37:
        if (r127.size() < 3) goto L39;
        String r136 = (String) ListProtector.get(r127, 2);
    L41:
        if (r127.size() < 4) goto L43;
        r105 = (String) ListProtector.get(r127, 3);
    L44:
        if (r132 == false) goto L49;
        if (r128.length() <= 0) goto L49;
        r103 = r128.toString();
    L63:
        if (r133 == false) goto L129;
        if (r129.length() <= 0) goto L129;
        r103 = r103 + "\nCaused by: InvalidStack.CrashWhenWriteStack: Npth ERROR:\n" + r129;
    L49:
        if (r136 == null) goto L53;
        StringBuilder r137 = new StringBuilder();
        r137.append(r136);
        r137.append("\nCaused by: ");
        if (r101 == true) goto L58;
    L57:
        r112 = "InvalidStack.NoStackAvailable: not OOM.\n";
    L58:
        r137.append(r112);
        r103 = r137.toString();
        goto L63
    L53:
        if (r135 == null) goto L59;
        StringBuilder r138 = new StringBuilder();
        r138.append(r135);
        r138.append("\nCaused by: ");
        r137 = r138;
        if (r101 == false) goto L57;
    L59:
        if (r101 == true) goto L62;
        r112 = "InvalidStack.NoStackAvailable: not OOM.\n";
    L62:
        r103 = r112;
        goto L63
    L43:
        r105 = null;
        goto L44
    L39:
        r136 = null;
        goto L41
    L35:
        r135 = null;
        goto L37
    L31:
        r104 = null;
    L6:
        r125 = null;
        goto L8
    }

    public static void f(PolarisFileWrapper r100, JSONArray r101) {
        r100.getParentFile().mkdirs();
        BufferedWriter r102 = new BufferedWriter(new PolarisFileWriterWrapper(r100));     // Catch: Throwable -> L6
        new m(r102).c(r101);     // Catch: Throwable -> L9
        r102.flush();     // Catch: Throwable -> L9
    L7:
        j.a(r102);
        return;
    L6:
        r102 = null;
        goto L7
    }

    public static void g(PolarisFileWrapper r100, JSONObject r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        r100.getParentFile().mkdirs();
        BufferedWriter r102 = new BufferedWriter(new PolarisFileWriterWrapper(r100));     // Catch: Throwable -> L8
        new m(r102).d(r101);     // Catch: Throwable -> L11
        r102.flush();     // Catch: Throwable -> L11
    L9:
        j.a(r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static void m(PolarisFileWrapper r100, JSONObject r101) {
        r100.getParentFile().mkdirs();
        BufferedWriter r102 = new BufferedWriter(new PolarisFileWriterWrapper(r100));     // Catch: Throwable -> L8
        new m(r102).d(r101);     // Catch: Throwable -> L6
        r102.flush();     // Catch: Throwable -> L6
    L5:
        j.a(r102);
        return;
    L6:
        th = th;
    L24:
        r101.put("err_write", th.toString());     // Catch: Throwable -> L12 JSONException -> L19
        k1.a.g(r101, "filters", "err_write", th.getLocalizedMessage());     // Catch: Throwable -> L12 JSONException -> L19
    L12:
        th = move-exception;
        j.a(r102);
        throw th;
    L14:
        com.apm.lite.c.a();     // Catch: Throwable -> L12
    L8:
        th = th;
        r102 = null;
        goto L24
    }

    public static void o(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        new PolarisFileWrapper(r101).getParentFile().mkdirs();     // Catch: Throwable -> L9
        ZipOutputStream r103 = new ZipOutputStream(new PolarisFileOutputStreamWrapper(r101));     // Catch: Throwable -> L9
        j(r103, r102, "");     // Catch: Throwable -> L7
        j.a(r103);
        return;
    L7:
        Throwable th10 = th;
    L11:
        j.a(r103);
        throw th10;
    L9:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L11
    }
}
