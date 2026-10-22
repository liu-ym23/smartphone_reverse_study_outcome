package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap f7651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap f7652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ConcurrentHashMap f7653c;

    static {
        f7651a = new ConcurrentHashMap();
        f7652b = new ConcurrentHashMap();
        f7653c = new ConcurrentHashMap();
    }

    public static List a(List r10) {
        LinkedList r11 = new LinkedList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        r11.add(("https://" + new URL((String) r12.next()).getHost()) + "/monitor/collect/");     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r11;
    }

    public static SDKMonitor b(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L20;
        if (f7651a.get(r10) != null) goto L18;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (f7651a.get(r10) != null) goto L13;
        SDKMonitor r11 = new SDKMonitor(r10);     // Catch: Throwable -> L11
        f7651a.put(r10, r11);     // Catch: Throwable -> L11
    L13:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L18:
        return (SDKMonitor) f7651a.get(r10);
    L20:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }

    public static synchronized void c(Context r10, String r11, JSONObject r12, SDKMonitor.IGetExtendParams r13) {
        monitor-enter(i.class);
        if (r10 != null) goto L30;
        monitor-exit(i.class);
        return;
    L30:
    L16:
        th = move-exception;
        throw th;
    L8:
        if (TextUtils.isEmpty(r11) == true) goto L27;
        if (r12 == null) goto L25;
        if (f7651a.get(r11) != null) goto L13;
    L18:
        SDKMonitor r14 = (SDKMonitor) f7651a.get(r11);     // Catch: Throwable -> L16
        if (r14 != null) goto L21;
        r14 = new SDKMonitor(r11);     // Catch: Throwable -> L16
        f7651a.put(r11, r14);     // Catch: Throwable -> L16
    L21:
        r14.M((List) f7653c.remove(r11));     // Catch: Throwable -> L16
        r14.N((List) f7652b.remove(r11));     // Catch: Throwable -> L16
        r14.x(r10, r12, r13);     // Catch: Throwable -> L16
        monitor-exit(i.class);
        return;
    L13:
        if (((SDKMonitor) f7651a.get(r11)).B() == false) goto L18;
        monitor-exit(i.class);
        return;
    L25:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");     // Catch: Throwable -> L16
    L27:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L16
    }

    public static synchronized void d(String r10, List r11) {
        monitor-enter(i.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
    L22:
        monitor-exit(i.class);
        return;
    L7:
        if (f.a(r11) == true) goto L22;
        LinkedList r12 = new LinkedList();     // Catch: Throwable -> L15
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L15
    L11:
        if (r13.hasNext() == false) goto L19;
        r12.add(("https://" + new URL((String) r13.next()).getHost()) + "/monitor/appmonitor/v3/settings");     // Catch: Throwable -> L15 MalformedURLException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        goto L11
    L19:
        f7653c.put(r10, r12);     // Catch: Throwable -> L15
        monitor-exit(i.class);
    }

    public static synchronized void e(String r10, List r11) {
        monitor-enter(i.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
    L14:
        monitor-exit(i.class);
        return;
    L7:
        if (f.a(r11) == true) goto L14;
        f7652b.put(r10, a(r11));     // Catch: Throwable -> L12
        monitor-exit(i.class);
    }
}
