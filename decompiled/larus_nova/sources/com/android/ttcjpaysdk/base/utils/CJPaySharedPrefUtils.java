package com.android.ttcjpaysdk.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class CJPaySharedPrefUtils {
    public CJPaySharedPrefUtils() {
    }

    public static void clearMap(String r100) {
        Context r101 = CJPayHostInfo.applicationContext;
        if (r101 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r102 = PreferenceManager.getDefaultSharedPreferences(r101).edit();
        r102.remove(r100);
        r102.apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v4 */
    public static Map<String, String> getMap(String r100) {
        ?? r101 = "NO";
        Context r102 = CJPayHostInfo.applicationContext;
        ?? r103 = 0;
        ?? r104 = 0;
        if (r102 != null) goto L63;
        return null;
    L63:
        String r105 = PreferenceManager.getDefaultSharedPreferences(r102).getString(r100, "NO");     // Catch: Throwable -> L27 Exception -> L29
        if ("NO".equals(r105) == true) goto L17;
        r101 = new ByteArrayInputStream(Base64.decode(r105, 2));     // Catch: Throwable -> L27 Exception -> L29
        ObjectInputStream r106 = new ObjectInputStream(r101);     // Catch: Throwable -> L13 Exception -> L15
        Map<String, String> r107 = (Map) r106.readObject();     // Catch: Exception -> L11 Throwable -> L41
        r104 = r101;
    L18:
        if (r104 != 0) goto L56;
    L22:
        if (r106 == null) goto L65;
        r106.close();     // Catch: IOException -> L20
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySharedPrefUtils#singlePutMap", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySharedPrefUtils#singlePutMap", e);
        e.printStackTrace();
    L65:
        return r107;
    L56:
        r104.close();     // Catch: IOException -> L20
    L11:
        e = e;
    L31:
        CJBasicCommonUtils.reportCatchException("CJPaySharedPrefUtils#singlePutMap", e);     // Catch: Throwable -> L41
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySharedPrefUtils#singlePutMap", e);     // Catch: Throwable -> L41
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r101 != 0) goto L52;
    L36:
        if (r106 == null) goto L66;
        r106.close();     // Catch: IOException -> L34
        return null;
    L34:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySharedPrefUtils#singlePutMap", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySharedPrefUtils#singlePutMap", e);
        e.printStackTrace();
        return null;
    L66:
        return null;
    L52:
        r101.close();     // Catch: IOException -> L34
        goto L36
    L15:
        e = e;
        r106 = null;
    L13:
        th = th;
        r100 = null;
    L42:
        r103 = r101;
        ?? r108 = r100;
    L43:
        if (r103 != 0) goto L54;
    L47:
        if (r108 == 0) goto L51;
        r108.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySharedPrefUtils#singlePutMap", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySharedPrefUtils#singlePutMap", e);
        e.printStackTrace();
    L51:
        throw th;
    L54:
        r103.close();     // Catch: IOException -> L45
        goto L47
    L17:
        r106 = null;
        r107 = null;
    L29:
        e = e;
        r106 = null;
        r101 = 0;
    L27:
        th = th;
        r108 = 0;
    L41:
        th = th;
        goto L42
    }

    public static int getInt(String r100, int r101) {
        Context r102 = CJPayHostInfo.applicationContext;
        if (r102 != null) goto L6;
        return r101;
    L6:
        return PreferenceManager.getDefaultSharedPreferences(r102).getInt(r100, r101);
    }

    public static String getStr(String r100, String r101) {
        Context r102 = CJPayHostInfo.applicationContext;
        if (r102 != null) goto L6;
        return r101;
    L6:
        return PreferenceManager.getDefaultSharedPreferences(r102).getString(r100, r101);
    }

    public static void singlePutInt(String r100, int r101) {
        Context r102 = CJPayHostInfo.applicationContext;
        if (r102 == null) goto L6;
        PreferenceManager.getDefaultSharedPreferences(r102).edit().putInt(r100, r101).apply();
        return;
    }

    public static void singlePutMap(String r100, Map<String, String> r101) {
        Context r102 = CJPayHostInfo.applicationContext;
        if (r102 == null) goto L45;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.size() <= 0) goto L59;
        SharedPreferences.Editor r103 = PreferenceManager.getDefaultSharedPreferences(r102).edit();
        ObjectOutputStream r104 = null;
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L22 Exception -> L24
        ObjectOutputStream r106 = new ObjectOutputStream(r105);     // Catch: Throwable -> L18 Exception -> L20
        r106.writeObject(r101);     // Catch: Throwable -> L14 Exception -> L16
        r103.putString(r100, new String(Base64.encode(r105.toByteArray(), 2)));     // Catch: Throwable -> L14 Exception -> L16
        r103.apply();     // Catch: Throwable -> L14 Exception -> L16
        r106.close();     // Catch: IOException -> L29
        r105.close();     // Catch: IOException -> L29
        return;
    L16:
        e = e;
        r104 = r106;
    L26:
        CJBasicCommonUtils.reportCatchException("CJPaySharedPrefUtils#singlePutMap", e);     // Catch: Throwable -> L18
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySharedPrefUtils#singlePutMap", e);     // Catch: Throwable -> L18
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r104 == null) goto L31;
        r104.close();     // Catch: IOException -> L29
    L31:
        if (r105 == null) goto L55;
        r105.close();     // Catch: IOException -> L29
        return;
    L55:
        return;
    L14:
        th = th;
        r104 = r106;
    L36:
        if (r104 != null) goto L46;
    L40:
        if (r105 == null) goto L44;
        r105.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySharedPrefUtils#singlePutMap", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySharedPrefUtils#singlePutMap", e);
        e.printStackTrace();
    L44:
        throw th;
    L46:
        r104.close();     // Catch: IOException -> L38
    L20:
        e = e;
    L18:
        th = th;
        goto L36
    L29:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySharedPrefUtils#singlePutMap", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySharedPrefUtils#singlePutMap", e);
        e.printStackTrace();
        return;
    L24:
        e = e;
        r105 = null;
    L22:
        th = th;
        r105 = null;
        goto L36
    L59:
        return;
    }

    public static void singlePutStr(String r100, String r101) {
        Context r102 = CJPayHostInfo.applicationContext;
        if (r102 != null) goto L5;
        return;
    L5:
        PreferenceManager.getDefaultSharedPreferences(r102).edit().putString(r100, r101).apply();
    }
}
