package com.bytedance.framwork.core.sdklib.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.IHttpService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SDKContext.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f8646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, JSONObject> f8647b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, String> f8648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static FileLock f8649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f8650e;
    private static boolean f;

    static {
        f8647b = new ConcurrentHashMap();
        f8650e = false;
    }

    public static synchronized void a(Context r3) {
        monitor-enter(k.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (f8646a == null) goto L8;
        monitor-exit(k.class);
        return;
    L8:
        f8646a = r4;     // Catch: Throwable -> L11
        monitor-exit(k.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static Context getContext() {
        return f8646a;
    }

    public static synchronized JSONObject a(long r2) {
        monitor-enter(k.class);
        JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(f8647b.get(Long.valueOf(r2)), JSONObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        monitor-exit(k.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized JSONObject a() {
        monitor-enter(k.class);
        ConcurrentHashMap<Long, JSONObject> r1 = f8647b;     // Catch: Throwable -> L12
        Iterator<Long> r2 = r1.keySet().iterator();     // Catch: Throwable -> L12
        if (r2.hasNext() == false) goto L10;
        JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(r1.get((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.aiagent.plugin")), JSONObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        monitor-exit(k.class);
        return r3;
    L10:
        monitor-exit(k.class);
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(String r4, JSONObject r5) {
        monitor-enter(k.class);
        f8647b.put(Long.valueOf(Long.parseLong(r4)), r5);     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(k.class);
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "setHeader", e);     // Catch: Throwable -> L6
        goto L10
    }

    public static Map<String, String> b() {
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(f8648c.get("device_id"), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        Iterator<Long> r0 = f8647b.keySet().iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");
        JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(f8647b.get(r2), JSONObject.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        Long.parseLong(r3.optString("device_id"));     // Catch: Throwable -> L15
        f8648c.put("device_id", r3.optString("device_id"));     // Catch: Throwable -> L15
    L14:
        return f8648c;
    L5:
        return f8648c;
    }

    public static void a(Map<String, String> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == false) goto L8;
        return;
    L8:
        if (f8648c != null) goto L10;
        f8648c = new HashMap();
    L10:
        Map<? extends String, ? extends String> r4 = f8648c;
        r4.putAll(r4);
        f8648c.remove(WsConstants.KEY_APP_ID);
    }

    public static synchronized boolean c() {
        monitor-enter(k.class);
    L18:
        return false;
    L5:
        if (f8650e == true) goto L7;
        File r1 = a.h();     // Catch: Throwable -> L18
        if (r1.exists() == true) goto L12;
        r1.createNewFile();     // Catch: Throwable -> L18
    L12:
        FileChannel r2 = new RandomAccessFile(r1, "rw").getChannel();     // Catch: Throwable -> L18
        if (r2 == null) goto L15;
        FileLock r3 = r2.tryLock();     // Catch: Throwable -> L18
        f8649d = r3;     // Catch: Throwable -> L18
        f8650e = r3.isValid();     // Catch: Throwable -> L18
    L15:
        boolean r4 = f8650e;     // Catch: Throwable -> L18
        monitor-exit(k.class);
        return r4;
    L7:
        monitor-exit(k.class);
        return true;
    }

    public static boolean d() {
        return f;
    }

    public static com.bytedance.services.apm.api.c a(String r3, Map<String, String> r4, byte[] r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        IHttpService r0 = (IHttpService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IHttpService.class), IHttpService.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        return r0.doPost(r3, r5, r6);
    L7:
        return com.bytedance.framwork.core.sdklib.a.b.a.a(r3, r5, r6);
    }
}
