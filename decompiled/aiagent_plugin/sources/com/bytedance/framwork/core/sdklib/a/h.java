package com.bytedance.framwork.core.sdklib.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: Monitor.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<Long, Long> f8632a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static j f8633c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8634b;

    /* JADX INFO: compiled from: Monitor.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f8635a = null;

        static /* synthetic */ h a() {
            return f8635a;
        }

        static {
            f8635a = new h();
        }
    }

    public h() {
        this.f8634b = false;
    }

    static {
        f8632a = new ConcurrentHashMap();
    }

    public static h a() {
        return a.a();
    }

    public void a(long r9, JSONObject r11) {
    L16:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "record", th);
        return;
    L4:
        if (f8632a.containsKey(Long.valueOf(r9)) == true) goto L6;
        f8632a.put(Long.valueOf(r9), Long.valueOf(com.bytedance.framwork.core.sdklib.a.a.a.a().a(r9, k.a(r9))));     // Catch: Throwable -> L16
    L6:
        b();     // Catch: Throwable -> L16
        if (r11.getJSONObject("_debug_self") != null) goto L10;
        r11.put("_debug_self", new JSONObject());     // Catch: Exception -> L19 Throwable -> L16
    L10:
        new JSONObject().put("sdk_report_from", "apm6");     // Catch: Exception -> L19 Throwable -> L16
    L12:
        if (k.d() == false) goto L14;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "record:" + r9 + " " + r11);     // Catch: Throwable -> L16
    L14:
        f8633c.a(r9, ((Long) ZeusTransformUtils.preCheckCast(f8632a.get(Long.valueOf(r9)), Long.class, "com.obric.aiagent.plugin")).longValue(), r11);     // Catch: Throwable -> L16
    }

    private synchronized void b() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f8634b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f8634b = true;     // Catch: Throwable -> L14
        if (k.d() == false) goto L11;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "Initializing SlardarHandler...");     // Catch: Throwable -> L14
    L11:
        f8633c = new j(com.bytedance.framwork.core.sdklib.a.a.d(), com.bytedance.framwork.core.sdklib.a.a.e());     // Catch: Throwable -> L14
        e.a().a(f8633c);     // Catch: Throwable -> L14
        e.a().b();     // Catch: Throwable -> L14
        f.a().b();     // Catch: Throwable -> L14
        monitor-exit(this);
    }
}
