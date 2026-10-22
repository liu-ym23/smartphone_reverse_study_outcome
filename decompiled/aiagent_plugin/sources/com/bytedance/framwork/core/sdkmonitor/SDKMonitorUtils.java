package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SDKMonitorUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, h> f8668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, List<String>> f8669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, List<String>> f8670c;

    public SDKMonitorUtils() {
    }

    static {
        f8668a = new ConcurrentHashMap();
        f8669b = new ConcurrentHashMap();
        f8670c = new ConcurrentHashMap();
    }

    public static synchronized void a(String r5, List<String> r6) {
        monitor-enter(SDKMonitorUtils.class);
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r5) == false) goto L7;
    L20:
        monitor-exit(SDKMonitorUtils.class);
        return;
    L7:
        if (com.bytedance.framwork.core.sdklib.b.d.a(r7) == true) goto L20;
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L22
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L22
    L11:
        if (r8.hasNext() == false) goto L17;
        r1.add(("https://" + new URL((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin")).getHost()) + "/monitor/appmonitor/v4/settings");     // Catch: MalformedURLException -> L15 Throwable -> L22
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L11
    L17:
        f8670c.put(r5, r1);     // Catch: Throwable -> L22
        monitor-exit(SDKMonitorUtils.class);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(String r3, List<String> r4) {
        monitor-enter(SDKMonitorUtils.class);
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r3) == false) goto L7;
    L12:
        monitor-exit(SDKMonitorUtils.class);
        return;
    L7:
        if (com.bytedance.framwork.core.sdklib.b.d.a(r5) == true) goto L12;
        f8669b.put(r3, a(r5));     // Catch: Throwable -> L14
        monitor-exit(SDKMonitorUtils.class);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static List<String> a(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        LinkedList r0 = new LinkedList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        r0.add(("https://" + new URL((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin")).getHost()) + "/monitor/collect/");     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r0;
    }

    public static synchronized void a(Context r5, String r6, JSONObject r7, h.a r8) {
        monitor-enter(SDKMonitorUtils.class);
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        h.a r10 = (h.a) ZeusTransformUtils.wrapperContextForParams(r8, h.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r9 != null) goto L9;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L9:
        if (TextUtils.isEmpty(r6) == true) goto L26;
        if (r7 == null) goto L24;
        if (f8668a.get(r6) != null) goto L14;
    L17:
        h r1 = (h) ZeusTransformUtils.preCheckCast(f8668a.get(r6), h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r1 != null) goto L20;
        r1 = new h(r6);     // Catch: Throwable -> L27
        f8668a.put(r6, r1);     // Catch: Throwable -> L27
    L20:
        r1.a((List) ZeusTransformUtils.preCheckCast(f8670c.remove(r6), List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
        r1.b((List) ZeusTransformUtils.preCheckCast(f8669b.remove(r6), List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
        r1.a(r9, r7, r10);     // Catch: Throwable -> L27
        monitor-exit(SDKMonitorUtils.class);
        return;
    L14:
        if (((h) ZeusTransformUtils.preCheckCast(f8668a.get(r6), h.class, "com.obric.aiagent.plugin")).a() == false) goto L17;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L24:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");     // Catch: Throwable -> L27
    L26:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public static h a(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L19;
        if (f8668a.get(r3) != null) goto L17;
        monitor-enter(SDKMonitorUtils.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f8668a.get(r3) != null) goto L11;
        h r1 = new h(r3);     // Catch: Throwable -> L13
        f8668a.put(r3, r1);     // Catch: Throwable -> L13
    L11:
        monitor-exit(SDKMonitorUtils.class);     // Catch: Throwable -> L13
    L17:
        return (h) ZeusTransformUtils.preCheckCast(f8668a.get(r3), h.class, "com.obric.aiagent.plugin");
    L19:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }
}
