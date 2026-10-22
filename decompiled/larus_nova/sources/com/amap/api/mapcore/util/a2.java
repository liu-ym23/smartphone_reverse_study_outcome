package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class a2 {
    public static long a() {
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L6;
        StatFs r100 = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) r100.getFreeBlocks()) * r100.getBlockSize();
    L6:
        return 0;
    }

    public static OfflineMapCity a(JSONObject r100) throws JSONException {
        OfflineMapCity r101 = new OfflineMapCity();
        String r102 = a(r100, "adcode");
        if ("000001".equals(r102) == false) goto L5;
        r102 = "100000";
    L5:
        r101.setAdcode(r102);
        r101.setUrl(a(r100, "url"));
        r101.setCity(a(r100, "name"));
        r101.setCode(a(r100, "citycode"));
        r101.setPinyin(a(r100, "pinyin"));
        r101.setJianpin(a(r100, "jianpin"));
        r101.setVersion(a(r100, "version"));
        r101.setSize(CastLongProtector.parseLong(a(r100, "size")));
        return r101;
    }

    public static OfflineMapProvince b(JSONObject r100) throws JSONException {
        if (r100 != null) goto L5;
        return null;
    L5:
        OfflineMapProvince r101 = new OfflineMapProvince();
        r101.setUrl(a(r100, "url"));
        r101.setProvinceName(a(r100, "name"));
        r101.setJianpin(a(r100, "jianpin"));
        r101.setPinyin(a(r100, "pinyin"));
        String r102 = a(r100, "adcode");
        if ("000001".equals(r102) == false) goto L8;
        r102 = "100000";
    L8:
        r101.setProvinceCode(r102);
        r101.setVersion(a(r100, "version"));
        r101.setSize(CastLongProtector.parseLong(a(r100, "size")));
        JSONArray r103 = r100.optJSONArray("cities");
        ArrayList<OfflineMapCity> r104 = new ArrayList();
        if (r103 != null) goto L12;
    L22:
        r101.setCityList(r104);
        return r101;
    L12:
        if (r103.length() != 0) goto L14;
        r104.add(a(r100));
    L14:
        int r105 = 0;
    L16:
        if (r105 >= r103.length()) goto L22;
        JSONObject r106 = r103.optJSONObject(r105);
        if (r106 == null) goto L21;
        r104.add(a(r106));
    L21:
        r105 = r105 + 1;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static String c(File r100) {
        StringBuffer r101 = new StringBuffer();
        ?? r102 = 0;
        r102 = 0;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L28 IOException -> L30 FileNotFoundException -> L40
    L85:
        BufferedReader r104 = new BufferedReader(new InputStreamReader(r103, XML.CHARSET_UTF8));     // Catch: Throwable -> L22 IOException -> L24 FileNotFoundException -> L26
    L82:
        String r105 = r104.readLine();     // Catch: IOException -> L18 FileNotFoundException -> L20 Throwable -> L54
        if (r105 == null) goto L8;
        r101.append(r105);     // Catch: IOException -> L18 FileNotFoundException -> L20 Throwable -> L54
        goto L82
    L8:
        String r106 = r101.toString();     // Catch: IOException -> L18 FileNotFoundException -> L20 Throwable -> L54
        r104.close();     // Catch: IOException -> L11
    L72:
        r103.close();     // Catch: IOException -> L15
    L17:
        return r106;
    L15:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L72
    L20:
        FileNotFoundException e100 = e;
    L42:
        t6.a(e100, "MapDownloadManager", "readOfflineSD filenotfound");     // Catch: Throwable -> L54
        e100.printStackTrace();     // Catch: Throwable -> L54
        if (r104 != null) goto L69;
    L48:
        if (r103 != null) goto L78;
    L53:
        return null;
    L78:
        r103.close();     // Catch: IOException -> L51
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L53
    L69:
        r104.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
    L18:
        IOException e101 = e;
    L32:
        t6.a(e101, "MapDownloadManager", "readOfflineSD io");     // Catch: Throwable -> L54
        e101.printStackTrace();     // Catch: Throwable -> L54
        if (r104 != null) goto L80;
    L38:
        if (r103 == null) goto L53;
    L80:
        r104.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L26:
        e = move-exception;
        e100 = e;
        r104 = null;
    L24:
        e = move-exception;
        e101 = e;
        r104 = null;
    L22:
        th = th;
    L56:
        if (r102 != 0) goto L74;
    L61:
        if (r103 == null) goto L88;
        r103.close();     // Catch: IOException -> L64
        throw th;
    L64:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L88:
        throw th;
    L74:
        r102.close();     // Catch: IOException -> L59
    L59:
        e = move-exception;
        e.printStackTrace();
    L54:
        th = move-exception;
        r102 = r100;
        th = th;
    L40:
        e = move-exception;
        e100 = e;
        r104 = null;
        r103 = null;
    L30:
        e = move-exception;
        e101 = e;
        r104 = null;
        r103 = null;
    L28:
        th = th;
        r103 = null;
        goto L56
    }

    public static void a(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L5;
        return;
    L5:
        if (r101.isDirectory() == false) goto L29;
        File[] r102 = r101.listFiles();
        if (r102 != null) goto L9;
        return;
    L9:
        int r103 = r102.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L30;
        File r105 = r102[r104];
        if (r105.exists() == false) goto L21;
        if (r105.isDirectory() == false) goto L21;
        String[] r106 = r105.list();
        if (r106 != null) goto L19;
        r105.delete();
        goto L21
    L19:
        if (r106.length != 0) goto L21;
        r105.delete();
    L21:
        r104 = r104 + 1;
        goto L10
    L30:
        return;
    }

    public static long b(File r100) {
        if (r100.isDirectory() == false) goto L5;
        File[] r101 = r100.listFiles();
        long r102 = 0;
        if (r101 != null) goto L9;
        return 0;
    L9:
        int r103 = r101.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L16;
        File r105 = r101[r104];
        if (r105.isDirectory() == false) goto L14;
        long r106 = b(r105);
    L15:
        r102 = r102 + r106;
        r104 = r104 + 1;
        goto L10
    L14:
        r106 = r105.length();
        goto L15
    L16:
        return r102;
    L5:
        return r100.length();
    }

    public static boolean a(File r100) throws IOException, Exception {
        if (r100 != null) goto L5;
    L23:
        return false;
    L5:
        if (r100.exists() == false) goto L23;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L22;
        int r102 = 0;
    L11:
        if (r102 >= r101.length) goto L22;
        if (r101[r102].isFile() == false) goto L18;
        if (r101[r102].delete() == true) goto L20;
        return false;
    L20:
        r102 = r102 + 1;
        goto L11
    L18:
        if (a(r101[r102]) == true) goto L20;
        return false;
    L22:
        return r100.delete();
    }

    public static String b(String r100) {
    L6:
        th = move-exception;
        t6.a(th, "Utility", "getZipFileNameFromUrl");
        return null;
    L3:
        if (TextUtils.isEmpty(r100) == true) goto L12;
        return r100.substring(r100.lastIndexOf(HTTP.URL_DEFAULT) + 1, r100.indexOf(".zip"));
    L12:
        return null;
    }

    public static String a(Context r100, String r101) {
        InputStream r102 = p3.d(r100, r101);     // Catch: Throwable -> L16
        if (r102 != null) goto L6;
        return null;
    L6:
        GZIPInputStream r103 = new GZIPInputStream(r102);     // Catch: Throwable -> L16
        int r104 = w3.f28280b;     // Catch: Throwable -> L16
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L13
        byte[] r106 = new byte[2048];     // Catch: Throwable -> L13
    L8:
        int r107 = r103.read(r106, 0, 2048);     // Catch: Throwable -> L13
        if (r107 == (-1)) goto L11;
        r105.write(r106, 0, r107);     // Catch: Throwable -> L13
        goto L8
    L11:
    L24:
        return new String(r105.toByteArray(), XML.CHARSET_UTF8);
    L13:
        th = move-exception;
        t6.a(th, "Util", "decodeAssetResData");     // Catch: Throwable -> L16
        th.printStackTrace();     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        t6.a(th, "MapDownloadManager", "readOfflineAsset");
        th.printStackTrace();
        return null;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0098 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.OutputStream] */
    public static void b(String r100, Context r101) {
        if ("".equals(w3.a(r101)) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r102 = new PolarisFileWrapper(w3.a(r101) + "offlinemapv4.png");
        if (r102.exists() == true) goto L12;
        r102.createNewFile();     // Catch: IOException -> L9
    L9:
        e = move-exception;
        t6.a(e, "OfflineUpdateCityHandlerAbstract", "writeSD dirCreate");
        e.printStackTrace();
    L12:
        if (a() <= 1048576) goto L45;
        ?? r103 = 0;
        PolarisFileOutputStreamWrapper r104 = null;
        PolarisFileOutputStreamWrapper r105 = null;
        r103 = 0;
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L26 IOException -> L28 FileNotFoundException -> L33
    L57:
        String r107 = XML.CHARSET_UTF8;
        r106.write(r100.getBytes(XML.CHARSET_UTF8));     // Catch: Throwable -> L20 IOException -> L22 FileNotFoundException -> L24
        r106.close();     // Catch: IOException -> L18
        r103 = r107;
    L50:
        return;
    L24:
        e = e;
        r104 = r106;
    L34:
        t6.a(e, "OfflineUpdateCityHandlerAbstract", "writeSD filenotfound");     // Catch: Throwable -> L26
        e.printStackTrace();     // Catch: Throwable -> L26
        r103 = r104;
        if (r104 == null) goto L50;
        r104.close();     // Catch: IOException -> L18
        r103 = r104;
    L22:
        e = e;
        r105 = r106;
    L29:
        t6.a(e, "OfflineUpdateCityHandlerAbstract", "writeSD io");     // Catch: Throwable -> L26
        e.printStackTrace();     // Catch: Throwable -> L26
        r103 = r105;
        if (r105 == null) goto L50;
        r105.close();     // Catch: IOException -> L18
        r103 = r105;
    L20:
        th = th;
        r103 = r106;
    L39:
        if (r103 != 0) goto L46;
    L44:
        throw th;
    L46:
        r103.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
    L26:
        th = th;
    L33:
        e = e;
    L28:
        e = e;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L50
    }

    public static void a(String r100, Context r101) throws IOException, Exception {
        File[] r102 = new PolarisFileWrapper(w3.a(r101)).listFiles();
        if (r102 != null) goto L5;
        return;
    L5:
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L13;
        File r105 = r102[r104];
        if (r105.exists() == false) goto L12;
        if (r105.getName().contains(r100) == false) goto L12;
        a(r105);
    L12:
        r104 = r104 + 1;
        goto L6
    L13:
        a(w3.a(r101));
    }

    public static String a(JSONObject r100, String r101) throws JSONException {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.has(r101) == true) goto L8;
        return "";
    L8:
        if ("[]".equals(JSONObjectProtectorUtils.getString(r100, r101)) == false) goto L10;
        return "";
    L10:
        return r100.optString(r101).trim();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v5, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARN: Type inference failed for: r21v11 */
    /* JADX WARN: Type inference failed for: r21v2, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [org.json.JSONArray] */
    public static String a(String r310, String r311, Context r312) {
        String r100 = "mergeNetworkCityListToLocalJson";
        String r101 = "Utility";
        if (r310 != null) goto L5;
    L252:
        return r310;
    L5:
        if (r311.isEmpty() == true) goto L252;
        JSONObject r102 = new JSONObject(r311);     // Catch: Throwable -> L246 JSONException -> L249
        String r103 = r102.optString("version", "");     // Catch: Throwable -> L246 JSONException -> L249
        JSONArray r104 = r102.optJSONArray("offlineMapList");     // Catch: Throwable -> L246 JSONException -> L249
        if (r104 != null) goto L10;
    L245:
        return r310;
    L10:
        if (r104.length() == 0) goto L245;
        HashMap r105 = new HashMap();     // Catch: Throwable -> L246 JSONException -> L249
        HashMap r106 = new HashMap();     // Catch: Throwable -> L246 JSONException -> L249
        int r110 = 0;
    L14:
        String r111 = "districts";
        String r112 = "adcode";
        if (r110 >= r104.length()) goto L45;
        JSONObject r113 = r104.optJSONObject(r110);     // Catch: Throwable -> L246 JSONException -> L249
        if (r113 == null) goto L44;
        JSONArray r114 = r113.optJSONArray("districts");     // Catch: Throwable -> L246 JSONException -> L249
        if (r114 == null) goto L44;
        int r115 = 0;
    L24:
        if (r115 >= r114.length()) goto L44;
        JSONObject r116 = r114.optJSONObject(r115);     // Catch: Throwable -> L246 JSONException -> L249
        if (r116 == null) goto L43;
        String r107 = r116.optString("adcode", "");     // Catch: Throwable -> L246 JSONException -> L249
        if (r107.isEmpty() == true) goto L31;
        r105.put(r107, r116);     // Catch: Throwable -> L246 JSONException -> L249
    L31:
        JSONArray r108 = r116.optJSONArray("districts");     // Catch: Throwable -> L246 JSONException -> L249
        if (r108 == null) goto L43;
        int r117 = 0;
    L35:
        if (r117 >= r108.length()) goto L43;
        JSONObject r109 = r108.optJSONObject(r117);     // Catch: Throwable -> L246 JSONException -> L249
        JSONArray r118 = r108;
        if (r109 == null) goto L42;
        String r119 = r109.optString("adcode", "");     // Catch: Throwable -> L246 JSONException -> L249
        if (r119.isEmpty() == true) goto L42;
        r106.put(r119, r109);     // Catch: Throwable -> L246 JSONException -> L249
    L42:
        r117 = r117 + 1;     // Catch: Throwable -> L246 JSONException -> L249
        r108 = r118;
    L43:
        r115 = r115 + 1;     // Catch: Throwable -> L246 JSONException -> L249
        r104 = r104;
    L44:
        r110 = r110 + 1;     // Catch: Throwable -> L246 JSONException -> L249
        r104 = r104;
        goto L14
    L45:
        JSONObject r120 = new JSONObject(r310);     // Catch: Throwable -> L246 JSONException -> L249
        JSONObject r121 = r120.optJSONObject("result");     // Catch: Throwable -> L246 JSONException -> L249
        if (r121 != null) goto L48;
        return r310;
    L48:
        JSONObject r122 = r121.optJSONObject("offlinemap_with_province_vfour");     // Catch: Throwable -> L246 JSONException -> L249
        if (r122 != null) goto L51;
        return r310;
    L51:
        JSONObject r123 = r122.optJSONObject("offlinemapinfo_with_province");     // Catch: Throwable -> L246 JSONException -> L249
        if (r123 != null) goto L55;
        return r310;
    L55:
        if (r103.isEmpty() == true) goto L57;
        r123.put("version", r103);     // Catch: Throwable -> L246 JSONException -> L249
    L57:
        JSONArray r124 = r123.optJSONArray("provinces");     // Catch: Throwable -> L246 JSONException -> L249
        if (r124 != null) goto L60;
        return r310;
    L60:
        int r125 = 0;
    L61:
        String r126 = "cities";
        String r127 = r100;
        String r128 = "url";
        String r129 = r101;
        String r130 = "name";
        HashMap r131 = r106;
        JSONObject r132 = r123;
        if (r125 >= r124.length()) goto L104;
        JSONObject r133 = r124.optJSONObject(r125);     // Catch: Throwable -> L241 JSONException -> L243
        if (r133 != null) goto L68;
        r124 = r124;
        r125 = r125;
    L103:
        r125 = r125 + 1;     // Catch: Throwable -> L241 JSONException -> L243
        r124 = r124;
        r111 = r111;
        r106 = r131;
        r100 = r127;
        r101 = r129;
        r123 = r132;
        r112 = r112;
        goto L61
    L68:
        JSONObject r134 = (JSONObject) r105.get(r133.optString(r112, ""));     // Catch: Throwable -> L241 JSONException -> L243
        if (r134 == null) goto L81;
        String r135 = r134.optString("name", "");     // Catch: Throwable -> L241 JSONException -> L243
        if (r135.isEmpty() == true) goto L73;
        r133.put("name", r135);     // Catch: Throwable -> L241 JSONException -> L243
    L73:
        long r210 = r134.optLong("size", 0);     // Catch: Throwable -> L241 JSONException -> L243
        if (r210 <= 0) goto L77;
        r133.put("size", String.valueOf(r210));     // Catch: Throwable -> L241 JSONException -> L243
    L77:
        if (r103.isEmpty() == true) goto L79;
        r133.put("version", r103);     // Catch: Throwable -> L241 JSONException -> L243
    L79:
        r133.put("url", "");     // Catch: Throwable -> L241 JSONException -> L243
    L81:
        JSONArray r136 = r133.optJSONArray("cities");     // Catch: Throwable -> L241 JSONException -> L243
        if (r136 == null) goto L103;
        int r137 = 0;
    L85:
        if (r137 >= r136.length()) goto L103;
        JSONObject r138 = r136.optJSONObject(r137);     // Catch: Throwable -> L241 JSONException -> L243
        if (r138 != null) goto L89;
        HashMap r139 = r131;
        JSONArray r140 = r136;
    L102:
        r137 = r137 + 1;     // Catch: Throwable -> L241 JSONException -> L243
        r111 = r111;
        r136 = r140;
        r112 = r112;
        r131 = r139;
        goto L85
    L89:
        r139 = r131;
        JSONObject r141 = (JSONObject) r139.get(r138.optString(r112, ""));     // Catch: Throwable -> L241 JSONException -> L243
        r140 = r136;
        if (r141 == null) goto L102;
        String r142 = r141.optString("name", "");     // Catch: Throwable -> L241 JSONException -> L243
        if (r142.isEmpty() == true) goto L94;
        r138.put("name", r142);     // Catch: Throwable -> L241 JSONException -> L243
    L94:
        long r211 = r141.optLong("size", 0);     // Catch: Throwable -> L241 JSONException -> L243
        if (r211 <= 0) goto L98;
        r138.put("size", String.valueOf(r211));     // Catch: Throwable -> L241 JSONException -> L243
    L98:
        if (r103.isEmpty() == true) goto L100;
        r138.put("version", r103);     // Catch: Throwable -> L241 JSONException -> L243
    L100:
        r138.put("url", "");     // Catch: Throwable -> L241 JSONException -> L243
    L243:
        e = e;
        r100 = r127;
        String r143 = r129;
    L251:
        t6.a(e, r143, r100);
        e.printStackTrace();
    L241:
        th = th;
        r100 = r127;
        String r144 = r129;
    L248:
        t6.a(th, r144, r100);
        th.printStackTrace();
        goto L252
    L104:
        ?? r145 = r124;
        String r146 = r111;
        String r212 = r112;
        HashSet r147 = new HashSet(r105.keySet());     // Catch: Throwable -> L241 JSONException -> L243
        HashSet r148 = new HashSet(r131.keySet());     // Catch: Throwable -> L241 JSONException -> L243
        int r149 = r145.length() - 1;     // Catch: Throwable -> L241 JSONException -> L243
    L105:
        if (r149 < 0) goto L125;
        JSONObject r150 = r145.optJSONObject(r149);     // Catch: Throwable -> L241 JSONException -> L243
        JSONObject r151 = r120;
        if (r150 != null) goto L109;
        HashSet r213 = r147;
        String r152 = r212;
    L124:
        r149 = r149 - 1;     // Catch: Throwable -> L241 JSONException -> L243
        r212 = r152;
        r120 = r151;
        r147 = r213;
        goto L105
    L109:
        r152 = r212;
        if (r147.contains(r150.optString(r152, "")) == true) goto L113;
        r145.remove(r149);     // Catch: Throwable -> L241 JSONException -> L243
    L112:
        r213 = r147;
        goto L124
    L113:
        JSONArray r153 = r150.optJSONArray("cities");     // Catch: Throwable -> L241 JSONException -> L243
        if (r153 == null) goto L112;
        int r154 = r153.length() - 1;     // Catch: Throwable -> L241 JSONException -> L243
    L116:
        if (r154 < 0) goto L112;
        HashSet r214 = r147;
        JSONObject r155 = r153.optJSONObject(r154);     // Catch: Throwable -> L241 JSONException -> L243
        if (r155 != null) goto L121;
    L123:
        r154 = r154 - 1;     // Catch: Throwable -> L241 JSONException -> L243
        r147 = r214;
        goto L116
    L121:
        if (r148.contains(r155.optString(r152, "")) == true) goto L123;
        r153.remove(r154);     // Catch: Throwable -> L241 JSONException -> L243
        goto L123
    L125:
        JSONObject r156 = r120;
        String r157 = r212;
        HashSet r158 = new HashSet();     // Catch: Throwable -> L241 JSONException -> L243
        int r159 = 0;
    L127:
        if (r159 >= r145.length()) goto L134;
        JSONObject r160 = r145.optJSONObject(r159);     // Catch: Throwable -> L241 JSONException -> L243
        if (r160 == null) goto L133;
        String r161 = r160.optString(r157, "");     // Catch: Throwable -> L241 JSONException -> L243
        if (r161.isEmpty() == true) goto L133;
        r158.add(r161);     // Catch: Throwable -> L241 JSONException -> L243
    L133:
        r159 = r159 + 1;     // Catch: Throwable -> L241 JSONException -> L243
        goto L127
    L134:
        Iterator r162 = r105.entrySet().iterator();     // Catch: Throwable -> L241 JSONException -> L243
    L136:
        r105 = r105;
        String r163 = "jianpin";
        ?? r215 = r145;
        String r164 = "citycode";
        if (r162.hasNext() == false) goto L165;
        Map.Entry r165 = (Map.Entry) r162.next();     // Catch: Throwable -> L241 JSONException -> L243
        r162 = r162;
        String r166 = (String) r165.getKey();     // Catch: Throwable -> L241 JSONException -> L243
        if ("000000".equals(r166) == true) goto L140;
        if (r158.contains(r166) == true) goto L140;
        JSONObject r167 = (JSONObject) r165.getValue();     // Catch: Throwable -> L241 JSONException -> L243
        ?? r168 = new JSONObject();     // Catch: Throwable -> L241 JSONException -> L243
        r168.put("citycode", "");     // Catch: Throwable -> L241 JSONException -> L243
        r168.put("jianpin", "");     // Catch: Throwable -> L241 JSONException -> L243
        HashSet r216 = r158;
        r168.put(r130, r167.optString(r130, ""));     // Catch: Throwable -> L241 JSONException -> L243
        r168.put(r157, r166);     // Catch: Throwable -> L241 JSONException -> L243
        r168.put(r128, "");     // Catch: Throwable -> L241 JSONException -> L243
        r168.put("pinyin", "");     // Catch: Throwable -> L241 JSONException -> L243
        r168.put("version", r103);     // Catch: Throwable -> L241 JSONException -> L243
        String r169 = r103;
        long r217 = r167.optLong("size", 0);     // Catch: Throwable -> L241 JSONException -> L243
        if (r217 <= 0) goto L147;
        String r170 = String.valueOf(r217);     // Catch: Throwable -> L241 JSONException -> L243
    L148:
        r168.put("size", r170);     // Catch: Throwable -> L241 JSONException -> L243
        JSONArray r171 = new JSONArray();     // Catch: Throwable -> L241 JSONException -> L243
        JSONArray r172 = r167.optJSONArray(r146);     // Catch: Throwable -> L241 JSONException -> L243
        if (r172 == null) goto L163;
        int r173 = 0;
    L152:
        if (r173 >= r172.length()) goto L162;
        JSONObject r174 = r172.optJSONObject(r173);     // Catch: Throwable -> L241 JSONException -> L243
        if (r174 == null) goto L161;
        JSONObject r175 = new JSONObject();     // Catch: Throwable -> L241 JSONException -> L243
        r175.put("citycode", "");     // Catch: Throwable -> L241 JSONException -> L243
        r175.put(r163, "");     // Catch: Throwable -> L241 JSONException -> L243
        r175.put(r130, r174.optString(r130, ""));     // Catch: Throwable -> L241 JSONException -> L243
        r175.put(r157, r174.optString(r157, ""));     // Catch: Throwable -> L241 JSONException -> L243
        r175.put(r128, "");     // Catch: Throwable -> L241 JSONException -> L243
        r175.put("pinyin", "");     // Catch: Throwable -> L241 JSONException -> L243
        r175.put("version", r169);     // Catch: Throwable -> L241 JSONException -> L243
        long r218 = r174.optLong("size", 0);     // Catch: Throwable -> L241 JSONException -> L243
        if (r218 <= 0) goto L159;
        String r176 = String.valueOf(r218);     // Catch: Throwable -> L241 JSONException -> L243
    L160:
        r175.put("size", r176);     // Catch: Throwable -> L241 JSONException -> L243
        r171.put(r175);     // Catch: Throwable -> L241 JSONException -> L243
        goto L161
    L159:
        r176 = "";
    L161:
        r173 = r173 + 1;     // Catch: Throwable -> L241 JSONException -> L243
        r128 = r128;
        r172 = r172;
        r163 = r163;
        r130 = r130;
        goto L152
    L162:
        String r177 = r128;
        String r219 = r130;
    L164:
        r168.put("cities", r171);     // Catch: Throwable -> L241 JSONException -> L243
        r215.put(r168);     // Catch: Throwable -> L241 JSONException -> L243
        r145 = r215;
        r128 = r177;
        r103 = r169;
        r158 = r216;
        r146 = r146;
        r130 = r219;
        goto L136
    L163:
        r177 = r128;
        r219 = r130;
        goto L164
    L147:
        r170 = "";
    L140:
        r145 = r215;
        goto L136
    L165:
        String r220 = r130;
        String r178 = r103;
        String r221 = "jianpin";
        String r222 = r146;
        String r179 = r128;
        ?? r223 = r215;
        int r180 = 0;
    L167:
        if (r180 >= r223.length()) goto L216;
        JSONObject r181 = r223.optJSONObject(r180);     // Catch: Throwable -> L241 JSONException -> L243
        if (r181 != null) goto L171;
        r164 = r164;
        r223 = r223;
        String r182 = r179;
        String r183 = r220;
        HashMap r224 = r105;
        r126 = r126;
    L215:
        r180 = r180 + 1;     // Catch: Throwable -> L241 JSONException -> L243
        r179 = r182;
        r126 = r126;
        r223 = r223;
        r105 = r224;
        r220 = r183;
        r164 = r164;
        goto L167
    L171:
        HashMap r184 = r105;
        JSONObject r185 = (JSONObject) r184.get(r181.optString(r157, ""));     // Catch: Throwable -> L241 JSONException -> L243
        if (r185 == null) goto L175;
        String r186 = r222;
        JSONArray r187 = r185.optJSONArray(r186);     // Catch: Throwable -> L241 JSONException -> L243
        if (r187 != null) goto L179;
    L214:
        r222 = r186;
        goto L175
    L179:
        if (r187.length() == 0) goto L214;
        JSONArray r225 = r181.optJSONArray(r126);     // Catch: Throwable -> L241 JSONException -> L243
        if (r225 != null) goto L184;
        JSONArray r188 = new JSONArray();     // Catch: Throwable -> L241 JSONException -> L243
        r181.put(r126, r188);     // Catch: Throwable -> L241 JSONException -> L243
    L185:
        HashSet r189 = new HashSet();     // Catch: Throwable -> L241 JSONException -> L243
        r222 = r186;
        int r190 = 0;
    L187:
        if (r190 >= r188.length()) goto L194;
        JSONObject r191 = r188.optJSONObject(r190);     // Catch: Throwable -> L241 JSONException -> L243
        if (r191 == null) goto L193;
        String r192 = r191.optString(r157, "");     // Catch: Throwable -> L241 JSONException -> L243
        if (r192.isEmpty() == true) goto L193;
        r189.add(r192);     // Catch: Throwable -> L241 JSONException -> L243
    L193:
        r190 = r190 + 1;     // Catch: Throwable -> L241 JSONException -> L243
        goto L187
    L194:
        int r193 = 0;
    L196:
        if (r193 >= r187.length()) goto L213;
        JSONObject r194 = r187.optJSONObject(r193);     // Catch: Throwable -> L241 JSONException -> L243
        if (r194 != null) goto L201;
        JSONArray r226 = r187;
    L200:
        String r195 = r220;
    L212:
        r193 = r193 + 1;     // Catch: Throwable -> L241 JSONException -> L243
        r179 = r179;
        r187 = r226;
        r189 = r189;
        r184 = r184;
        r220 = r195;
        r164 = r164;
        goto L196
    L201:
        r226 = r187;
        String r196 = r194.optString(r157, "");     // Catch: Throwable -> L241 JSONException -> L243
        if (r196.isEmpty() == true) goto L200;
        if (r189.contains(r196) == true) goto L200;
        r189 = r189;
        JSONObject r197 = new JSONObject();     // Catch: Throwable -> L241 JSONException -> L243
        r197.put(r164, "");     // Catch: Throwable -> L241 JSONException -> L243
        r164 = r164;
        String r198 = r221;
        r197.put(r198, "");     // Catch: Throwable -> L241 JSONException -> L243
        r221 = r198;
        r195 = r220;
        r197.put(r195, r194.optString(r195, ""));     // Catch: Throwable -> L241 JSONException -> L243
        r197.put(r157, r196);     // Catch: Throwable -> L241 JSONException -> L243
        r197.put(r179, "");     // Catch: Throwable -> L241 JSONException -> L243
        r197.put("pinyin", "");     // Catch: Throwable -> L241 JSONException -> L243
        r197.put("version", r178);     // Catch: Throwable -> L241 JSONException -> L243
        long r227 = r194.optLong("size", 0);     // Catch: Throwable -> L241 JSONException -> L243
        if (r227 <= 0) goto L209;
        String r199 = String.valueOf(r227);     // Catch: Throwable -> L241 JSONException -> L243
    L210:
        r197.put("size", r199);     // Catch: Throwable -> L241 JSONException -> L243
        r188.put(r197);     // Catch: Throwable -> L241 JSONException -> L243
        goto L212
    L209:
        r199 = "";
        goto L210
    L213:
        r164 = r164;
        goto L175
    L184:
        r188 = r225;
    L175:
        r183 = r220;
        r224 = r184;
        r182 = r179;
        goto L215
    L216:
        String r200 = r179;
        HashMap r228 = r105;
        JSONArray r201 = r132.optJSONArray("others");     // Catch: Throwable -> L241 JSONException -> L243
        if (r201 == null) goto L239;
        JSONObject r202 = (JSONObject) r228.get("000000");     // Catch: Throwable -> L241 JSONException -> L243
        if (r202 == null) goto L239;
        int r203 = 0;
    L222:
        if (r203 >= r201.length()) goto L239;
        JSONObject r204 = r201.optJSONObject(r203);     // Catch: Throwable -> L241 JSONException -> L243
        if (r204 == null) goto L231;
        String r205 = r204.optString(r157, "");     // Catch: Throwable -> L241 JSONException -> L243
        if ("100000".equals(r205) == true) goto L232;
        if ("000001".equals(r205) == false) goto L231;
    L232:
        long r206 = r202.optLong("size", 0);     // Catch: Throwable -> L241 JSONException -> L243
        if (r206 <= 0) goto L236;
        r204.put("size", String.valueOf(r206));     // Catch: Throwable -> L241 JSONException -> L243
    L236:
        if (r178.isEmpty() == true) goto L238;
        r204.put("version", r178);     // Catch: Throwable -> L241 JSONException -> L243
    L238:
        r204.put(r200, "");     // Catch: Throwable -> L241 JSONException -> L243
    L231:
        r203 = r203 + 1;     // Catch: Throwable -> L241 JSONException -> L243
    L239:
        String r207 = r156.toString();     // Catch: Throwable -> L241 JSONException -> L243
        b(r207, r312);     // Catch: Throwable -> L241 JSONException -> L243
        return r207;
    L249:
        e = e;
        r143 = r101;
    L246:
        th = th;
        r144 = r101;
        goto L248
    }
}
