package com.bytedance.android.btm.impl.page;

import com.bytedance.android.btm.impl.util.f;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<f<Object>> f42255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f42256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f42257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f42258d;

    static {
        f42255a = new CopyOnWriteArrayList();
    }

    public final String toString() {
        JSONObject r100 = new JSONObject();
        Object r101 = f42256b;     // Catch: Throwable -> L18
        if (r101 == null) goto L6;
        String r102 = r101.getClass().getCanonicalName();     // Catch: Throwable -> L18
    L7:
        r100.put("resumedPage", r102);     // Catch: Throwable -> L18
        JSONArray r103 = new JSONArray();     // Catch: Throwable -> L18
        Iterator<f<Object>> r104 = f42255a.iterator();     // Catch: Throwable -> L18
    L9:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next().get();     // Catch: Throwable -> L18
        if (r105 == null) goto L13;
        String r106 = r105.getClass().getCanonicalName();     // Catch: Throwable -> L18
    L14:
        r103.put(r106);     // Catch: Throwable -> L18
        goto L9
    L13:
        r106 = null;
        goto L14
    L15:
        r100.put("stack", r103);     // Catch: Throwable -> L18
        goto L17
    L6:
        r102 = null;
    L17:
        return r100.toString();
    }
}
