package com.bytedance.applog.priority;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.bytedance.applog.log.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PriorityWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f5835a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f5836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f5837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f5838e;
    private static int f;
    private static int g;
    private static int h;
    private static int i;
    private static final com.bytedance.applog.log.a<Void> r = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f5839b;
    private final String j;
    private volatile String k;
    private final boolean l;
    private final SharedPreferences m;
    private final PriorityCallback n;
    private com.bytedance.applog.priority.a.d o;
    private String p;
    private String q;

    private static native int flush(String r0);

    private static native String getVersionConfig(String r0);

    private static native int init(String r0, String r1, String r2, String r3, PriorityCallback r4);

    private static native int onEvent(String r0, int r1, String r2);

    private static native int setConfig(String r0, String r1);

    private static native void setLogEnable(String r0, boolean r1);

    static {
        f5835a = Collections.singletonList("Priority3");
        f5836c = true;
        f5837d = 0;
        f5838e = 1;
        f = 2;
        g = 3;
        h = 4;
        i = 9;
        r = new AnonymousClass1();
    }

    public PriorityWrapper(Context r9, String r10, String r11, boolean r12, PriorityCallback r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        PriorityCallback r5 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r13, PriorityCallback.class, "com.obric.aiagent.plugin");
        this.f5839b = new AtomicBoolean(false);
        this.o = null;
        this.p = "";
        this.q = "/service/2/app_log/";
        r5.printLog(2, "create priority wrapper with native:" + f5836c + " ...");
        this.j = r10;
        this.m = r3.getSharedPreferences("applog_priority_wrapper@" + r10, 0);
        this.l = r12;
        this.k = a(r3.getFilesDir().getAbsolutePath());
        this.n = r5;
        b(r11);
        if (f5836c == true) goto L5;
        this.o = com.bytedance.applog.priority.a.d.f5853a.a(r3, r10, r5, this.p, this.q);
        return;
    L5:
        r.b(new Object[0]);
    }

    public synchronized void a() {
        monitor-enter(this);
        this.n.printLog(2, "start to init priority...");     // Catch: Throwable -> L18
        if (this.f5839b.get() == false) goto L22;
        monitor-exit(this);
        return;
    L22:
    L14:
        th = move-exception;
        m.a().a(f5835a, "init priority error!", th, new Object[0]);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L8:
        if (f5836c == true) goto L12;
        com.bytedance.applog.priority.a.d r0 = this.o;     // Catch: Throwable -> L14
        if (r0 == null) goto L12;
        r0.a();     // Catch: Throwable -> L14
        this.f5839b.set(true);     // Catch: Throwable -> L14
    L21:
    L12:
        c();     // Catch: Throwable -> L14
    L18:
        th = move-exception;
        throw th;
    }

    public boolean a(int r6, JSONObject r7) {
        if (f5836c == true) goto L10;
        com.bytedance.applog.priority.a.d r0 = this.o;
        if (r0 == null) goto L10;
        if (r0.a(r6, r7) == false) goto L9;
        int r8 = g;
    L11:
        PriorityCallback r5 = this.n;
        StringBuilder r1 = new StringBuilder().append("onPriorityEvent -> match: ");
        if (r8 != g) goto L14;
        boolean r2 = true;
    L15:
        r5.printLog(2, r1.append(r2).append(", e: ").append(r7).toString());
        if (r8 != i) goto L19;
        return false;
    L19:
        if (r8 != g) goto L22;
        return true;
    L22:
        return false;
    L14:
        r2 = false;
        goto L15
    L9:
        r8 = h;
    L10:
        r8 = onEvent(this.j, r6, r7.toString());
        goto L11
    }

    public void a(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        JSONObject r0 = null;
    L28:
        th = move-exception;
        m.a().a(f5835a, "addDefaultPriorityOptions for version config error!", th, new Object[0]);
        this.n.monitorError("priority addDefaultPriorityOptions error", th.toString());
        return;
    L6:
        if (f5836c == false) goto L12;
        String r2 = getVersionConfig(this.j);     // Catch: Throwable -> L28
        if (r2 == null) goto L14;
        if (r2.isEmpty() == true) goto L14;
        r0 = new JSONObject(r2);     // Catch: Throwable -> L28
    L14:
        if (r0 != null) goto L16;
    L23:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L28
        r1.put("version", 0);     // Catch: Throwable -> L28
        Iterator<String> r3 = d.f5951a.a().iterator();     // Catch: Throwable -> L28
    L25:
        if (r3.hasNext() == false) goto L39;
        r7.put((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin"), r1);     // Catch: Throwable -> L28
        goto L25
    L39:
        return;
    L16:
        if (r0.length() <= 0) goto L23;
        Iterator<String> r4 = d.f5951a.a().iterator();     // Catch: Throwable -> L28
    L19:
        if (r4.hasNext() == false) goto L38;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        Object r6 = r0.optJSONObject(r5);     // Catch: Throwable -> L28
        if (r6 == null) goto L19;
        r7.put(r5, r6);     // Catch: Throwable -> L28
        goto L19
    L38:
        return;
    L12:
        r0 = this.o.c();     // Catch: Throwable -> L28
        goto L14
    }

    public void b(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = d.f5951a.b().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        if (r7.has((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L6;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L22;
        m.a().a(f5835a, "start update priority config by default response: {}...", new Object[]{r7});
        if (f5836c == true) goto L17;
        com.bytedance.applog.priority.a.d r2 = this.o;
        if (r2 == null) goto L17;
        r2.b(r7);
        return;
    L17:
        setConfig(this.j, r7.toString());
        return;
    L22:
        return;
    L10:
        r1 = false;
        goto L11
    }

    public void b() {
        m.a().a(f5835a, "start flush priority {}...", new Object[]{this.j});
        if (f5836c == true) goto L7;
        com.bytedance.applog.priority.a.d r0 = this.o;
        if (r0 == null) goto L7;
        r0.b();
        return;
    L7:
        flush(this.j);
    }

    private void c() {
        m.a().a(f5835a, "start init native priority {}...", new Object[]{this.j});
        if (this.l == false) goto L6;
        setLogEnable(this.j, true);
    L6:
        if (init(this.j, this.k, this.p, this.q, this.n) != 0) goto L8;
        this.f5839b.set(true);
    L8:
        this.n.printLog(2, "init native priority completed.");
    }

    private String a(String r2) {
        File r1 = new File(r2 + "/applog_priority_db");
        if (r1.exists() == true) goto L6;
        r1.mkdirs();
    L6:
        return r1.getAbsolutePath();
    }

    private void b(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isEmpty() == true) goto L14;
        Uri r5 = Uri.parse(r4);     // Catch: Throwable -> L8
        this.p = r5.getScheme() + "://" + r5.getHost();     // Catch: Throwable -> L8
        this.q = r5.getPath();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        this.n.printLog(4, "parseDefaultReportUrl error: " + th);
        return;
    }
}
