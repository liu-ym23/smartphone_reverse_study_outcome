package com.bytedance.crash.d;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.o;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventDeliverer.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<com.bytedance.crash.monitor.f, ConcurrentLinkedQueue<i>> f7374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<com.bytedance.crash.monitor.f, ConcurrentLinkedQueue<i>> f7375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static CopyOnWriteArrayList<h> f7376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static AtomicInteger f7377e;
    private static AtomicInteger f;
    private static volatile boolean g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f7378a;
    private ConcurrentLinkedQueue<i> h;
    private ConcurrentLinkedQueue<i> i;

    /* JADX INFO: compiled from: EventDeliverer.java */
    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f7379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile boolean f7380b;

        static /* synthetic */ void a(a r0) {
            r0.b();
        }

        static {
            f7379a = new a();
        }

        private a() {
        }

        public static a a() {
            return f7379a;
        }

        private void b() {
            if (this.f7380b == false) goto L5;
            return;
        L5:
            this.f7380b = true;
            h.a(true);
            DefaultWorkThread.removeCallbacks(this);
            DefaultWorkThread.postDelayed(this, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
            if (h.a().get() <= 0) goto L5;
        L8:
            DefaultWorkThread.postDelayed(this, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);
            h.a(true);
            return;
        L5:
            if (h.b().get() > 0) goto L8;
            h.a(false);
        }

        private void c() {
            JSONArray r1 = new JSONArray();     // Catch: Throwable -> L28
            int r2 = Process.myPid();     // Catch: Throwable -> L28
            long r3 = System.currentTimeMillis();     // Catch: Throwable -> L28
            Iterator r5 = h.c().keySet().iterator();     // Catch: Throwable -> L28
            int r6 = 0;
            boolean r8 = false;
            String r9 = "0";
        L7:
            if (r5.hasNext() == false) goto L25;
            com.bytedance.crash.monitor.f r10 = (com.bytedance.crash.monitor.f) ZeusTransformUtils.preCheckCast(r5.next(), com.bytedance.crash.monitor.f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
            ConcurrentLinkedQueue r13 = (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(h.c().get(r10), ConcurrentLinkedQueue.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
            if (r13 == null) goto L7;
            JSONArray r14 = new JSONArray();     // Catch: Throwable -> L28
        L13:
            if (r13.isEmpty() == true) goto L18;
            Iterator r16 = r5;
            r14.put(((i) ZeusTransformUtils.preCheckCast(r13.poll(), i.class, "com.obric.aiagent.plugin")).b());     // Catch: Throwable -> L28
            h.a().decrementAndGet();     // Catch: Throwable -> L28
            r6 = r6 + 1;     // Catch: Throwable -> L28
            if (r6 > 100) goto L16;
            r5 = r16;
            goto L13
        L16:
            r8 = true;
        L20:
            if (r14.length() != 0) goto L22;
        L21:
            r5 = r16;
            goto L7
        L22:
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L28
            r9 = r10.a("0");     // Catch: Throwable -> L28
            r7.put("data", r14);     // Catch: Throwable -> L28
            JSONObject r11 = Header.a(r10, r3, CrashType.ENSURE, r2).b();     // Catch: Throwable -> L28
            r11.put("from", "npth");     // Catch: Throwable -> L28
            r7.put("header", r11);     // Catch: Throwable -> L28
            r1.put(r7);     // Catch: Throwable -> L28
            if (r8 == false) goto L21;
        L18:
            r16 = r5;
        L25:
            if (l.a(r1) == true) goto L42;
            String r0 = com.bytedance.crash.config.f.i();     // Catch: Throwable -> L28
            HashMap r4 = new HashMap();     // Catch: Throwable -> L28
            r4.put("device_id", r9);     // Catch: Throwable -> L28
            r4.put(RomInfo.KEY_OS_TYPE, "Android");     // Catch: Throwable -> L28
            r4.put("sdk_version", com.bytedance.crash.config.g.f7298a);     // Catch: Throwable -> L28
            r4.put("from", "npth");     // Catch: Throwable -> L28
            String r12 = o.a(r0, r4);     // Catch: Throwable -> L28
            JSONObject r15 = new JSONObject();     // Catch: Throwable -> L28
            r15.put("list", r1);     // Catch: Throwable -> L28
            com.bytedance.crash.upload.b.a(r12, r15);     // Catch: Throwable -> L28
            return;
        L42:
            return;
        L28:
            th = move-exception;
            r.a(th);
        }
    }

    static /* synthetic */ AtomicInteger a() {
        return f7377e;
    }

    static /* synthetic */ boolean a(boolean r0) {
        g = r0;
        return r0;
    }

    static /* synthetic */ AtomicInteger b() {
        return f;
    }

    static /* synthetic */ ConcurrentHashMap c() {
        return f7374b;
    }

    static {
        f7374b = new ConcurrentHashMap();
        f7375c = new ConcurrentHashMap();
        f7376d = new CopyOnWriteArrayList();
        f7377e = new AtomicInteger(0);
        f = new AtomicInteger(0);
        g = false;
    }

    public h(com.bytedance.crash.monitor.f r3) {
        ConcurrentLinkedQueue<i> r0 = new ConcurrentLinkedQueue();
        this.h = r0;
        f7374b.put(r3, r0);
        this.i = new ConcurrentLinkedQueue();
        f7375c.put(r3, this.h);
        f7376d.add(this);
        a.a(a.a());
    }

    public void a(g r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.i.isEmpty() == true) goto L9;
        i r0 = (i) ZeusTransformUtils.preCheckCast(this.i.poll(), i.class, "com.obric.aiagent.plugin");
        f.decrementAndGet();
        if (r4.a(r0.a()) == false) goto L5;
        this.h.add(r0);
        f7377e.addAndGet(1);
        goto L5
    L9:
        d();
        this.f7378a = r4;
    }

    public void a(String r10, int r11, JSONObject r12, JSONObject r13) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return;
    L6:
        if (this.f7378a == null) goto L8;
    L10:
        g r0 = this.f7378a;
        if (r0 != null) goto L13;
    L15:
        i r1 = new i(Thread.currentThread().getName(), System.currentTimeMillis(), r10, r11, r12, r13);
        if (this.f7378a != null) goto L18;
        this.i.add(r1);
        f.addAndGet(1);
    L19:
        d();
        return;
    L18:
        this.h.add(r1);
        f7377e.addAndGet(1);
        goto L19
    L13:
        if (r0.a(r10) == true) goto L15;
        return;
    L8:
        if (f.get() <= 100) goto L10;
    }

    private void d() {
        if (g == true) goto L6;
        a.a(a.a());
        return;
    }
}
