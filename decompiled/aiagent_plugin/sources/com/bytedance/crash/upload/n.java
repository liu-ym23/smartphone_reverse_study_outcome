package com.bytedance.crash.upload;

import com.bytedance.crash.o.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: UploadLimits.java */
/* JADX INFO: loaded from: classes.dex */
public class n {
    private static final String TAG = "UploadLimits";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f7830a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f7831b;
    private static int f;
    private static int g;
    private static int h;
    private static int i;
    private static int j;
    private static boolean k;
    private static n l;
    private static volatile boolean m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, Long> f7833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f7834e;

    /* JADX INFO: compiled from: UploadLimits.java */
    public static class a {
        public void a() {
        }

        public a() {
        }

        static /* synthetic */ void a(a r0, String r1) {
            r0.a(r1);
        }

        private void a(String r1) {
            a();     // Catch: Throwable -> L4
            return;
        }
    }

    static {
        f7830a = new a();
        f = 50;
        g = 100;
        h = 100;
        i = 2;
        j = 5;
        k = false;
    }

    public static n a() {
        if (l != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (l != null) goto L9;
        l = new n();     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return l;
    }

    private n() {
        this.f7832c = 0;
        String r0 = com.bytedance.crash.o.b.a().replace(".", "_").replace(":", "-") + ".times";
        File r1 = new File(com.bytedance.crash.i.d(), "uploadLimits");
        com.bytedance.crash.o.i.b(r1);
        this.f7834e = new File(r1, r0);
        HashMap<String, Long> r2 = e();
        this.f7833d = r2;
        r.b(TAG, "upload_times:" + r2);
        m = true;
    }

    public static boolean b() {
        return m;
    }

    public static void a(m r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        f = r2.b();
        g = r2.c();
        h = r2.d();
        j = r2.e();
        i = r2.f();
        k = r2.a();
        r.b(TAG, "updateConfig:" + r2);
    }

    private HashMap<String, Long> e() {
        HashMap<String, Long> r0 = new HashMap();
        if (this.f7834e.exists() == true) goto L22;
        this.f7832c = System.currentTimeMillis();
        return r0;
    L22:
        JSONArray r1 = com.bytedance.crash.o.j.b(this.f7834e);     // Catch: Throwable -> L20
        if (com.bytedance.crash.o.l.a(r1) == false) goto L9;
        return r0;
    L9:
        Long r2 = a(r1.optString(0, null));     // Catch: Throwable -> L20
        if ((System.currentTimeMillis() - r2.longValue()) < 86400000) goto L13;
        r.b(TAG, "limit file exceed 1 day");     // Catch: Throwable -> L20
        this.f7832c = System.currentTimeMillis();     // Catch: Throwable -> L20
        com.bytedance.crash.o.j.a(this.f7834e);     // Catch: Throwable -> L20
        return r0;
    L13:
        this.f7832c = r2.longValue();     // Catch: Throwable -> L20
        int r4 = 1;
    L15:
        if (r4 >= r1.length()) goto L21;
        String[] r5 = r1.optString(r4, "").split(" ");     // Catch: Throwable -> L20
        if (r5.length != 2) goto L19;
        r0.put(r5[0], Long.decode(r5[1]));     // Catch: Throwable -> L20
    L19:
        r4 = r4 + 1;
    L21:
        return r0;
    L20:
        this.f7832c = System.currentTimeMillis();
        com.bytedance.crash.o.j.a(this.f7834e);
        goto L21
    }

    private static Long a(String r2) {
        return Long.decode(r2);
    L5:
        return 0L;
    }

    public void c() {
        StringBuilder r1 = new StringBuilder().append(this.f7832c).append('\n');     // Catch: Exception -> L9
        Iterator<Map.Entry<String, Long>> r3 = this.f7833d.entrySet().iterator();     // Catch: Exception -> L9
    L5:
        if (r3.hasNext() == false) goto L7;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        r1.append((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin")).append(' ').append(r4.getValue()).append('\n');     // Catch: Exception -> L9
        goto L5
    L7:
        r.b("CustomException", "writeUploadTimesFile:" + r1);     // Catch: Exception -> L9
        com.bytedance.crash.o.j.a(this.f7834e, r1.toString(), false);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.c.b.b("NPTH_ANR_ERROR_AppMonitor", e);
        r.b(e);
    }

    private static void f() {
        if (f7831b == true) goto L6;
        f7831b = true;
        a.a(f7830a, "ensure");
        return;
    }

    public boolean d() {
        return a("ensure_all", h);
    }

    public boolean a(String r7, String r8) {
        boolean r1 = false;
        if (k == false) goto L5;
        return false;
    L5:
        boolean r0 = a(r8, i);
        if (r7 == null) goto L8;
        boolean r2 = a(r7, j);
    L9:
        boolean r6 = a("ensure_all", h);
        r.b("CustomException", "checkEnsureLimit:" + r8 + " " + i + "=" + r0 + " " + r7 + " " + j + "=" + r2 + " totalExceed=" + r6);
        if (r0 == true) goto L13;
        if (r2 == true) goto L13;
        if (r6 == true) goto L13;
    L14:
        if (r1 == false) goto L16;
        f();
    L16:
        return r1;
    L13:
        r1 = true;
        goto L14
    L8:
        r2 = false;
        goto L9
    }

    public void b(String r1, String r2) {
        if (r1 == null) goto L4;
        b(r1);
    L4:
        if (r2 == null) goto L6;
        b(r2);
    L6:
        b("ensure_all");
    }

    public synchronized boolean a(String r4, long r5) {
        monitor-enter(this);
        boolean r0 = false;
        if (r4 != null) goto L19;
        monitor-exit(this);
        return false;
    L19:
        Long r6 = (Long) ZeusTransformUtils.preCheckCast(this.f7833d.get(r4), Long.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        r6 = 0L;     // Catch: Throwable -> L16
    L10:
        if (r6.longValue() < r5) goto L14;
        r0 = true;
    L14:
        monitor-exit(this);
        return r0;
    L16:
        th = move-exception;
        throw th;
    }

    private synchronized void b(String r6) {
        monitor-enter(this);
        r.b(TAG, "updateTimes:" + r6);     // Catch: Throwable -> L13
        if (r6 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f7833d.get(r6), Long.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        long r1 = 1;
        if (r0 == null) goto L10;
        r1 = 1 + r0.longValue();     // Catch: Throwable -> L13
    L10:
        this.f7833d.put(r6, Long.valueOf(r1));     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
