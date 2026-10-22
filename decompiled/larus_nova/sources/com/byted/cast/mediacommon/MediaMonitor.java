package com.byted.cast.mediacommon;

import android.os.Build;
import com.byted.cast.common.CastMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class MediaMonitor {
    private static ArrayList<CastMonitor> CastMonitors;
    private static final Object mMonitorLock = null;

    public MediaMonitor() {
    }

    static {
        mMonitorLock = new Object();
        CastMonitors = new ArrayList();
    }

    public static void addMonitor(CastMonitor r100) {
        Object r101 = mMonitorLock;
        monitor-enter(r101);
        ArrayList<CastMonitor> r102 = CastMonitors;     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        Iterator<CastMonitor> r103 = r102.iterator();     // Catch: Throwable -> L16
    L8:
        if (r103.hasNext() == false) goto L13;
        if (r103.next() != r100) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L13:
        CastMonitors.add(r100);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static void removeMonitor(CastMonitor r100) {
        Object r101 = mMonitorLock;
        monitor-enter(r101);
        ArrayList<CastMonitor> r102 = CastMonitors;     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        Iterator<CastMonitor> r103 = r102.iterator();     // Catch: Throwable -> L16
    L8:
        if (r103.hasNext() == false) goto L14;
        CastMonitor r104 = r103.next();     // Catch: Throwable -> L16
        if (r104 != r100) goto L8;
        CastMonitors.remove(r104);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static void onMonitor(String r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        r102.put("finger", Build.FINGERPRINT);     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        r102.put("android", Build.VERSION.SDK_INT);     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        r102.put("content", r101);     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        Object r103 = mMonitorLock;     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        monitor-enter(r103);     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        ArrayList<CastMonitor> r104 = CastMonitors;     // Catch: Throwable -> L12
        if (r104 == null) goto L10;
        Iterator<CastMonitor> r105 = r104.iterator();     // Catch: Throwable -> L12
    L8:
        if (r105.hasNext() == false) goto L10;
        r105.next().sendSourceEvent(r100, r102.toString());     // Catch: Throwable -> L12
    L10:
        monitor-exit(r103);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void onSinkMonitor(String r100, String r101) {
        CastMonitor.getInstance().sendSinkEvent(r100, "FINGERPRINT:" + Build.FINGERPRINT + "\nandroid:" + Build.VERSION.SDK_INT + "\ncontent:" + r101);     // Catch: NoClassDefFoundError -> L5
        return;
    }

    public static void onMonitor(String r100, int r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        r104.put("finger", Build.FINGERPRINT);     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        r104.put("android", Build.VERSION.SDK_INT);     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        r104.put("type", r101);     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        r104.put("reason", r102);     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        r104.put("trace", r103);     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        Object r105 = mMonitorLock;     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        monitor-enter(r105);     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
        ArrayList<CastMonitor> r106 = CastMonitors;     // Catch: Throwable -> L12
        if (r106 == null) goto L10;
        Iterator<CastMonitor> r107 = r106.iterator();     // Catch: Throwable -> L12
    L8:
        if (r107.hasNext() == false) goto L10;
        r107.next().sendSourceEvent(r100, r104.toString());     // Catch: Throwable -> L12
    L10:
        monitor-exit(r105);     // Catch: Throwable -> L12
        goto L25
    L24:
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: JSONException -> L15 NoClassDefFoundError -> L18
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void onSinkMonitor(String r100, int r101, String r102, String r103) {
        CastMonitor.getInstance().sendSinkEvent(r100, "FINGERPRINT:" + Build.FINGERPRINT + "\nandroid:" + Build.VERSION.SDK_INT + "\ntype:" + r101 + "\nreason:" + r102 + "\ntrace:" + r103);     // Catch: NoClassDefFoundError -> L5
        return;
    }
}
