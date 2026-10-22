package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class x6 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static x6 f28336a;

        static {
            f28336a = new x6();
        }
    }

    public x6() {
    }

    private static JSONObject a(Thread r100) {
        if (r100.getStackTrace() != null) goto L6;
        return null;
    L6:
        StackTraceElement[] r101 = r100.getStackTrace();
        JSONObject r102 = new JSONObject();
        r102.put("threadId", r100.getId());     // Catch: Throwable -> L18
        r102.put("threadName", r100.getName());     // Catch: Throwable -> L18
        r102.put("threadGroup", r100.getThreadGroup());     // Catch: Throwable -> L18
        StringBuffer r103 = new StringBuffer();     // Catch: Throwable -> L18
        int r104 = r101.length;     // Catch: Throwable -> L18
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L16;
        r103.append(r101[r105]);     // Catch: Throwable -> L18
        r103.append("<br />");     // Catch: Throwable -> L18
        r105 = r105 + 1;
        goto L12
    L16:
        r102.put("stacks", r103.toString());     // Catch: Throwable -> L18
    L17:
        return r102;
    }

    public boolean a(Context r110, String r111, String r112, List<w5> r113, boolean r210, w5 r211) {
        String r100 = r112;
        w5 r101 = null;
        if (r100 == null) goto L19;
        Iterator<Thread> r102 = Thread.getAllStackTraces().keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L24;
        Thread r103 = r102.next();
        if (r103 == null) goto L7;
        if (TextUtils.isEmpty(r103.getName()) == true) goto L7;
        if (r100.contains(r103.getName()) == true) goto L17;
        if (r103.getName().contains(r100) == false) goto L7;
    L17:
        StackTraceElement[] r104 = r103.getStackTrace();
        if (r104 == null) goto L19;
        StringBuffer r105 = new StringBuffer();
        int r106 = r104.length;
        int r107 = 0;
    L21:
        if (r107 >= r106) goto L23;
        StackTraceElement r108 = r104[r107];
        r105.append("at ");
        r105.append(r108);
        r105.append("<br />");
        r107 = r107 + 1;
        goto L21
    L23:
        String r109 = r105.toString();
    L26:
        if (TextUtils.isEmpty(r109) == true) goto L45;
        int r114 = 0;
    L30:
        if (r114 >= r113.size()) goto L45;
        w5 r115 = (w5) ListProtector.get(r113, r114);
        if (r115 == null) goto L44;
        String[] r116 = r115.c();
        int r117 = 0;
    L36:
        if (r117 >= r116.length) goto L44;
        if (TextUtils.isEmpty(r116[r114]) == true) goto L43;
        if (r109.contains(r116[r117]) == false) goto L43;
        r101 = r115;
    L43:
        r117 = r117 + 1;
    L44:
        r114 = r114 + 1;
    L45:
        if (r210 == false) goto L48;
        if (r101 != null) goto L48;
        return false;
    L48:
        String r118 = r111 + "<br />" + r109;
        if (r100 != null) goto L51;
        r100 = "";
    L51:
        Iterator<Thread> r119 = Thread.getAllStackTraces().keySet().iterator();
        String[] r120 = {"AMapPboRenderThread", "GLThread", "AMapGlRenderThread", "AMapThreadUtil", "GNaviMap", PullConfiguration.PROCESS_NAME_MAIN};
        JSONArray r121 = new JSONArray();
    L53:
        if (r119.hasNext() == false) goto L79;
        Thread r122 = r119.next();
        if (r122 == null) goto L53;
        if (r100.equals(r122.getName()) == true) goto L53;
        int r123 = 0;
    L62:
        if (r123 >= 6) goto L53;
        String r124 = r120[r123];
        String r125 = r122.getName();
        if (TextUtils.isEmpty(r124) == false) goto L66;
    L73:
        boolean r126 = false;
    L74:
        if (r126 == false) goto L78;
        if (a(r122) == null) goto L78;
        r121.put(a(r122));
    L78:
        r123 = r123 + 1;
        goto L62
    L66:
        if (TextUtils.isEmpty(r125) == true) goto L73;
        if (r124.contains(r125) == false) goto L71;
    L72:
        r126 = true;
        goto L74
    L71:
        if (r125.contains(r124) == false) goto L73;
    L79:
        JSONObject r127 = new JSONObject();
        r127.put("crashStack", r118);     // Catch: Throwable -> L82
        r127.put("backStacks", r121);     // Catch: Throwable -> L82
    L83:
        String r128 = r127.toString();
        if (TextUtils.isEmpty(r128) == false) goto L98;
        return false;
    L98:
        if (r210 == true) goto L93;
        if (r101 != null) goto L93;
        int r129 = t6.f28010i;     // Catch: Throwable -> L95
        u6.a(r110, r211, r128, 1, "NATIVE_APP_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");     // Catch: Throwable -> L95
        return true;
    L93:
        int r130 = t6.f28010i;     // Catch: Throwable -> L95
        u6.a(r110, r101, r128, 0, "NATIVE_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");     // Catch: Throwable -> L95
    L94:
        return true;
    L24:
        r109 = null;
    L19:
        r109 = "";
        goto L26
    }
}
