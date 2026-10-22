package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes28.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f25088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f25089b = null;

    static {
        f25089b = new String[]{"AD1", "AD2", "AD3", "AD8", "AD9", "AD10", "AD11", "AD12", "AD14", "AD15", "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AC4", "AC10", "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", "AE11", "AE12", "AE13", "AE14", "AE15"};
    }

    public static String a(Map<String, String> r100) {
        StringBuffer r101 = new StringBuffer();
        ArrayList r102 = new ArrayList(r100.keySet());
        Collections.sort(r102);
        int r103 = 0;
    L4:
        if (r103 >= r102.size()) goto L14;
        String r104 = (String) ListProtector.get(r102, r103);
        String r105 = r100.get(r104);
        String r106 = "";
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        StringBuilder r107 = new StringBuilder();
        if (r103 == 0) goto L12;
        r106 = "&";
    L12:
        r107.append(r106);
        r107.append(r104);
        r107.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r107.append(r105);
        r101.append(r107.toString());
        r103 = r103 + 1;
        goto L4
    L14:
        return r101.toString();
    }

    public static synchronized Map<String, String> a(Context r100, Map<String, String> r101) {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f25088a != null) goto L7;
        c(r100, r101);     // Catch: Throwable -> L10
    L7:
        f25088a.putAll(d.a());     // Catch: Throwable -> L10
        Map<String, String> r102 = f25088a;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r102;
    }

    public static synchronized void a() {
        monitor-enter(e.class);
        f25088a = null;     // Catch: Throwable -> L8
        monitor-exit(e.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized String b(Context r100, Map<String, String> r101) {
        monitor-enter(e.class);
        a(r100, r101);     // Catch: Throwable -> L13
        TreeMap r102 = new TreeMap();     // Catch: Throwable -> L13
        String[] r103 = f25089b;     // Catch: Throwable -> L13
        int r104 = r103.length;     // Catch: Throwable -> L13
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        String r106 = r103[r105];     // Catch: Throwable -> L13
        if (f25088a.containsKey(r106) == false) goto L9;
        r102.put(r106, f25088a.get(r106));     // Catch: Throwable -> L13
    L9:
        r105 = r105 + 1;     // Catch: Throwable -> L13
        goto L5
    L10:
        String r107 = com.alipay.sdk.m.y.b.a(a(r102));     // Catch: Throwable -> L13
        monitor-exit(e.class);
        return r107;
    L13:
        th = move-exception;
        throw th;
    }

    public static synchronized void c(Context r100, Map<String, String> r101) {
        monitor-enter(e.class);
        TreeMap r102 = new TreeMap();     // Catch: Throwable -> L7
        f25088a = r102;     // Catch: Throwable -> L7
        r102.putAll(b.a(r100, r101));     // Catch: Throwable -> L7
        f25088a.putAll(d.a(r100));     // Catch: Throwable -> L7
        f25088a.putAll(c.a(r100));     // Catch: Throwable -> L7
        f25088a.putAll(a.a(r100, r101));     // Catch: Throwable -> L7
        monitor-exit(e.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
