package com.bytedance.ttnet.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.al;
import com.bytedance.ttnet.TTNetInit;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTHttpCallThrottleControl.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements com.bytedance.retrofit2.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f11292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f11293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, b> f11294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile b f11295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ReadWriteLock f11296e;
    private final Lock f;
    private final Lock g;
    private final Set<com.bytedance.retrofit2.b.c> h;
    private final Set<com.bytedance.retrofit2.b.c> i;
    private final AtomicLong j;
    private final Set<com.bytedance.retrofit2.b.c> k;
    private final Map<Runnable, Executor> l;
    private final ReadWriteLock m;
    private final Lock n;
    private final Lock o;
    private final Condition p;

    /* JADX INFO: compiled from: TTHttpCallThrottleControl.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11313a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11314b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f11315c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f11316d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f11317e = null;
        private static final /* synthetic */ a[] f = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("NO_DELAY", 0);
            f11313a = r0;
            a r1 = new a("BLACK_LIST", 1);
            f11314b = r1;
            a r3 = new a("WHITE_LIST", 2);
            f11315c = r3;
            a r5 = new a("RUNTIME", 3);
            f11316d = r5;
            a r7 = new a("NOT_REACHED", 4);
            f11317e = r7;
            f = new a[]{r0, r1, r3, r5, r7};
        }
    }

    /* JADX INFO: compiled from: TTHttpCallThrottleControl.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f11318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f11319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f11320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f11321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f11322e;
        int f;
        Set<String> g;
        Map<String, Integer> h;
        Set<String> i;
        int j;
        Set<String> k;
        Set<String> l;
        Set<String> m;
        int n;
        int o;
        int p;
        int q;

        private b() {
            this.f11318a = a.f11313a;
            this.f11319b = -1;
            this.f11320c = "";
            this.f11321d = 1000;
            this.f11322e = 5;
            this.f = 5;
            this.g = new CopyOnWriteArraySet();
            this.h = new ConcurrentHashMap();
            this.i = new CopyOnWriteArraySet();
            this.j = 100;
            this.k = new CopyOnWriteArraySet();
            this.l = new CopyOnWriteArraySet();
            this.m = new CopyOnWriteArraySet();
            this.n = DownloadSettingValues.SYNC_INTERVAL_MS_FG;
            this.o = DownloadSettingValues.SYNC_INTERVAL_MS_FG;
            this.p = 3000;
            this.q = 500;
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }
    }

    public j() {
        this.f11293b = new AtomicBoolean(false);
        this.f11294c = new ConcurrentHashMap();
        this.f11295d = new b(null);
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        this.f11296e = r0;
        this.f = r0.readLock();
        this.g = r0.writeLock();
        this.h = new CopyOnWriteArraySet();
        this.i = new CopyOnWriteArraySet();
        this.j = new AtomicLong(0);
        this.k = new CopyOnWriteArraySet();
        this.l = new ConcurrentHashMap();
        ReentrantReadWriteLock r1 = new ReentrantReadWriteLock();
        this.m = r1;
        this.n = r1.writeLock();
        ReentrantLock r2 = new ReentrantLock();
        this.o = r2;
        this.p = r2.newCondition();
    }

    static /* synthetic */ Lock a(j r0) {
        return r0.n;
    }

    static /* synthetic */ Map b(j r0) {
        return r0.l;
    }

    static /* synthetic */ Set c(j r0) {
        return r0.k;
    }

    static /* synthetic */ Set d(j r0) {
        return r0.h;
    }

    static /* synthetic */ Set e(j r0) {
        return r0.i;
    }

    static /* synthetic */ void f(j r0) {
        r0.c();
    }

    public static j a() {
        if (f11292a != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11292a != null) goto L9;
        f11292a = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f11292a;
    }

    public void a(JSONObject r14) {
        JSONArray r0 = r14.optJSONArray("tt_req_delay_config");
        boolean r3 = true;
        if (r14.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r14.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r15 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r15 == false) goto L14;
    L15:
        if (r1 == false) goto L89;
        if (r0 == null) goto L89;
        if (r3 == true) goto L89;
        ConcurrentHashMap r16 = new ConcurrentHashMap();
        int r4 = 0;
    L21:
        if (r4 >= r0.length()) goto L87;
        b r5 = new b(null);
        JSONObject r6 = r0.optJSONObject(r4);
        if (r6 == null) goto L86;
        r5.f11320c = r6.optString("state_name", "");
        if (r6.isNull("bl_with_delay_ms") == true) goto L34;
        r5.f11318a = a.f11314b;
        JSONObject r7 = r6.optJSONObject("bl_with_delay_ms");
        if (r7 == null) goto L66;
        Iterator<String> r8 = r7.keys();
    L31:
        if (r8.hasNext() == false) goto L66;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        r5.h.put(r10, Integer.valueOf(r7.optInt(r10)));
    L66:
        if (r5.h.size() > 0) goto L72;
        if (r5.i.size() > 0) goto L72;
        if (r5.k.size() <= 0) goto L86;
    L72:
        if (TextUtils.isEmpty(r5.f11320c) == true) goto L86;
        r5.f11321d = r6.optInt("delay_disable_time_ms", 1000);
        if (r5.f11321d > 0) goto L78;
        r5.f11321d = 1000;
    L78:
        if (r6.isNull("dl") == true) goto L85;
        JSONArray r9 = r6.optJSONArray("dl");
        if (r9 == null) goto L85;
        int r11 = 0;
    L83:
        if (r11 >= r9.length()) goto L85;
        r5.g.add((String) ZeusTransformUtils.preCheckCast(r9.opt(r11), String.class, "com.obric.aiagent.plugin"));
        r11 = r11 + 1;
    L85:
        r5.f11319b = r6.optInt("state", -1);
        r5.f11322e = r6.optInt("sync_req_delay_max_count", 10);
        r5.f = r6.optInt("async_req_delay_max_count", 10);
        r16.put(r5.f11320c, r5);
        goto L86
    L34:
        if (r6.isNull("wl") == true) goto L45;
        r5.f11318a = a.f11315c;
        JSONArray r12 = r6.optJSONArray("wl");
        if (r12 == null) goto L41;
        int r13 = 0;
    L39:
        if (r13 >= r12.length()) goto L41;
        r5.i.add((String) ZeusTransformUtils.preCheckCast(r12.opt(r13), String.class, "com.obric.aiagent.plugin"));
        r13 = r13 + 1;
    L41:
        r5.j = r6.optInt("delay_time_ms", 1000);
        if (r5.j > 0) goto L66;
        r5.j = 1000;
        goto L66
    L45:
        if (r6.isNull("p0") == true) goto L66;
        r5.f11318a = a.f11316d;
        JSONArray r17 = r6.optJSONArray("p0");
        if (r17 == null) goto L52;
        int r18 = 0;
    L50:
        if (r18 >= r17.length()) goto L52;
        r5.k.add((String) ZeusTransformUtils.preCheckCast(r17.opt(r18), String.class, "com.obric.aiagent.plugin"));
        r18 = r18 + 1;
    L52:
        JSONArray r19 = r6.optJSONArray("bl_for_runtime");
        if (r19 == null) goto L58;
        int r20 = 0;
    L56:
        if (r20 >= r19.length()) goto L58;
        r5.l.add((String) ZeusTransformUtils.preCheckCast(r19.opt(r20), String.class, "com.obric.aiagent.plugin"));
        r20 = r20 + 1;
    L58:
        JSONArray r21 = r6.optJSONArray("wl_for_runtime");
        if (r21 == null) goto L64;
        int r22 = 0;
    L62:
        if (r22 >= r21.length()) goto L64;
        r5.m.add((String) ZeusTransformUtils.preCheckCast(r21.opt(r22), String.class, "com.obric.aiagent.plugin"));
        r22 = r22 + 1;
    L64:
        r5.n = r6.optInt("p0_check_max_ms", DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        r5.o = r6.optInt("p1_wait_max_ms", DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        r5.p = r6.optInt("random_send_ubound_ms", 3000);
        r5.q = r6.optInt("random_send_lbound_ms", 500);
    L86:
        r4 = r4 + 1;
        goto L21
    L87:
        this.f11294c.clear();
        this.f11294c.putAll(r16);
        this.f11293b.set(r1);
        return;
    L89:
        this.f11294c.clear();
        this.f11293b.set(r1);
        return;
    L14:
        r3 = false;
        goto L15
    L9:
        r15 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    public void a(String r8) {
        c();
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.f11294c.get(r8), b.class, "com.obric.aiagent.plugin");
        this.g.lock();
    L17:
        th = move-exception;
        this.g.unlock();
        throw th;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d("delayrefine", "setAppState " + r8);     // Catch: Throwable -> L17
    L7:
        if (r0 != this.f11295d) goto L10;
        this.g.unlock();
        return;
    L10:
        if (r0 != null) goto L12;
        r0 = new b(null);     // Catch: Throwable -> L17
    L12:
        this.f11295d = r0;     // Catch: Throwable -> L17
        if (this.f11295d.f11318a == a.f11313a) goto L15;
        com.bytedance.frameworks.baselib.network.a.b r9 = com.bytedance.frameworks.baselib.network.a.b.a(com.bytedance.frameworks.baselib.network.a.c.f7963a);     // Catch: Throwable -> L17
        final long r2 = this.f11295d.f11321d;     // Catch: Throwable -> L17
        final long r4 = 0;
        r9.a(new AnonymousClass1(this, r2, r4));     // Catch: Throwable -> L17
    L15:
        this.g.unlock();
    }

    @Override // com.bytedance.retrofit2.f.a
    public void a(com.bytedance.retrofit2.b.c r9) {
        if (this.f11293b.get() == true) goto L5;
        return;
    L5:
        if (r9 != null) goto L7;
        return;
    L7:
        if (r9.o() != null) goto L9;
        return;
    L9:
        if (r9.p() == null) goto L73;
        this.f.lock();
        int r0 = a(false, this.f11295d, r9);     // Catch: Throwable -> L58 Exception -> L60
        if (Logger.debug() == false) goto L16;
        Logger.d("delayrefine", "get sleep time " + r0 + " path is " + r9.o());     // Catch: Throwable -> L58 Exception -> L60
    L16:
        this.f.unlock();
        if (r0 <= 0) goto L20;
        a(r0, r9);
        return;
    L20:
        if (r0 != 0) goto L22;
        return;
    L22:
        this.f.lock();
        int r1 = this.f11295d.q;
        int r2 = this.f11295d.p;
        int r4 = this.f11295d.o;
    L52:
        th = move-exception;
        this.f.unlock();
        throw th;
    L54:
        e = move-exception;
        throw e;     // Catch: Throwable -> L52
    L24:
        if (this.f11295d.f11318a == a.f11316d) goto L28;
    L25:
        this.f.unlock();
        return;
    L28:
        if (a(this.f11295d, r9) == false) goto L25;
        if (b() == true) goto L25;
        this.f.unlock();
        this.o.lock();
        r9.p().E = SystemClock.uptimeMillis();     // Catch: Throwable -> L45 Exception -> L47
        this.i.add(r9);     // Catch: Throwable -> L45 Exception -> L47
        if (Logger.debug() == false) goto L37;
        Logger.d("delayrefine", "execute p1 add request " + r9.o() + " after added me, sync size is " + this.i.size());     // Catch: Throwable -> L45 Exception -> L47
    L37:
        this.p.await(r4, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L45 Exception -> L47
        int r3 = a(false, r1, r2);     // Catch: Throwable -> L45 Exception -> L47
        long r5 = r3;
        r9.p().F = r5;     // Catch: Throwable -> L45 Exception -> L47
        if (r3 <= 0) goto L41;
        Thread.sleep(r5);     // Catch: Throwable -> L45 Exception -> L47
    L41:
        if (Logger.debug() == false) goto L43;
        Logger.d("delayrefine", "execute p1 release now " + r9.o() + " random is " + r3);     // Catch: Throwable -> L45 Exception -> L47
    L43:
        r9.p().B = SystemClock.uptimeMillis() - r9.p().E;     // Catch: Throwable -> L45 Exception -> L47
        r9.p().A = true;     // Catch: Throwable -> L45 Exception -> L47
    L48:
        this.o.unlock();
        return;
    L45:
        th = move-exception;
        this.o.unlock();
        throw th;
    L47:
        Logger.e("sleeping interrupted");     // Catch: Throwable -> L45
        goto L48
    L60:
        e = move-exception;
        throw e;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        this.f.unlock();
        throw th;
    }

    private void a(int r5, com.bytedance.retrofit2.b.c r6) {
        if (r5 > 0) goto L4;
        return;
    L4:
        this.i.add(r6);
        r6.p().E = System.currentTimeMillis();
        r6.p().A = true;
        Thread.sleep(r5);     // Catch: Throwable -> L8 InterruptedException -> L10
        r6.p().B = System.currentTimeMillis() - r6.p().E;
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r6.p().B = System.currentTimeMillis() - r6.p().E;
        throw th;
    }

    @Override // com.bytedance.retrofit2.f.a
    public boolean a(final com.bytedance.retrofit2.b.c r12, Executor r13, Runnable r14) {
        final Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r13, Executor.class, "com.obric.aiagent.plugin");
        final Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r14, Runnable.class, "com.obric.aiagent.plugin");
        if (this.f11293b.get() == true) goto L5;
        return false;
    L5:
        if (r12 != null) goto L7;
    L48:
        return false;
    L7:
        if (r12.o() == null) goto L48;
        if (r12.p() == null) goto L48;
        this.f.lock();
        int r15 = this.f11295d.o;
        int r0 = a(true, this.f11295d, r12);     // Catch: Throwable -> L42 Exception -> L44
        if (Logger.debug() == false) goto L16;
        Logger.d("delayrefine", "get sleep time " + r0 + " path is " + r12.o());     // Catch: Throwable -> L42 Exception -> L44
    L16:
        if (r0 <= 0) goto L20;
        a(r0, r10, r8, r12);     // Catch: Throwable -> L42 Exception -> L44
        this.f.unlock();
        return true;
    L20:
        if (r0 != 0) goto L24;
    L21:
        this.f.unlock();
        return false;
    L24:
        if (this.f11295d.f11318a != a.f11316d) goto L21;
        if (a(this.f11295d, r12) == false) goto L21;
        if (b() == true) goto L21;
        this.f.unlock();
        this.n.lock();
        this.h.add(r12);     // Catch: Throwable -> L39
        if (Logger.debug() == false) goto L36;
        Logger.d("delayrefine", "enqueue p1 add request " + r12.o() + " after added me, async size is " + this.h.size());     // Catch: Throwable -> L39
    L36:
        r12.p().E = System.currentTimeMillis();     // Catch: Throwable -> L39
        this.l.put(r8, r10);     // Catch: Throwable -> L39
        r12.p().A = true;     // Catch: Throwable -> L39
        final long r4 = r15;
        final long r6 = 0;
        com.bytedance.frameworks.baselib.network.a.b.a(com.bytedance.frameworks.baselib.network.a.c.f7963a).a(new AnonymousClass2(this, r4, r6, r8, r12, r10));     // Catch: Throwable -> L39
        this.n.unlock();
        return true;
    L39:
        th = move-exception;
        this.n.unlock();
        throw th;
    L44:
        e = move-exception;
        throw e;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.f.unlock();
        throw th;
    }

    private void a(final int r9, Executor r10, Runnable r11, final com.bytedance.retrofit2.b.c r12) {
        final Executor r13 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.aiagent.plugin");
        final Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.aiagent.plugin");
        if (r9 > 0) goto L5;
        return;
    L5:
        af r14 = r12.p();
        r14.E = System.currentTimeMillis();
        r12.p().A = true;
        al r15 = new AnonymousClass3(this, r12, r13, r6, r9);
        this.h.add(r12);
        r13.execute(r15);
    }

    private boolean b() {
        if ((System.currentTimeMillis() - this.j.get()) <= this.f11295d.n) goto L6;
        return true;
    L6:
        if (this.k.size() <= 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.retrofit2.f.a
    public void b(final com.bytedance.retrofit2.b.c r3) {
        if (this.f11293b.get() == false) goto L5;
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        com.bytedance.frameworks.baselib.network.a.b.a(com.bytedance.frameworks.baselib.network.a.c.f7963a).a(new AnonymousClass4(this, r3));
        return;
    L5:
        if (this.k.size() > 0) goto L7;
    }

    private void c() {
        if (Logger.debug() == false) goto L5;
        Logger.d("delayrefine", "releaseAllP1Request, " + this.i.size() + " " + this.h.size());
    L5:
        this.o.lock();
        this.p.signalAll();     // Catch: Throwable -> L23
        this.o.unlock();
        this.f.lock();
        int r1 = this.f11295d.q;     // Catch: Throwable -> L20
        int r2 = this.f11295d.p;     // Catch: Throwable -> L20
        this.f.unlock();
        this.n.lock();
        Iterator<Map.Entry<Runnable, Executor>> r3 = this.l.entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r3.hasNext() == false) goto L15;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        final Runnable r12 = (Runnable) ZeusTransformUtils.preCheckCast(r4.getKey(), Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        final Executor r14 = (Executor) ZeusTransformUtils.preCheckCast(r4.getValue(), Executor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        final int r13 = a(true, r1, r2);     // Catch: Throwable -> L17
        final long r8 = r13;
        final long r10 = 0;
        com.bytedance.frameworks.baselib.network.a.b.a(com.bytedance.frameworks.baselib.network.a.c.f7963a).a(new AnonymousClass5(this, r8, r10, r12, r13, r14));     // Catch: Throwable -> L17
        goto L12
    L15:
        this.n.unlock();
        this.h.clear();
        this.i.clear();
        return;
    L17:
        th = move-exception;
        this.n.unlock();
        throw th;
    L20:
        th = move-exception;
        this.f.unlock();
        throw th;
    L23:
        th = move-exception;
        this.o.unlock();
        throw th;
    }

    private int a(boolean r4, int r5, int r6) {
        if (r4 == true) goto L5;
    L7:
        if (r4 == true) goto L12;
        if (this.i.size() > 5) goto L12;
        return 0;
    L12:
        return new SecureRandom().nextInt((r6 - r5) + 1) + r5;
    L5:
        if (this.h.size() > 5) goto L7;
        return 0;
    }

    private Integer a(Map<String, Integer> r5, String r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return null;
    L5:
        Iterator r1 = r4.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (r6.startsWith(r2) == false) goto L7;
        return (Integer) ZeusTransformUtils.preCheckCast(r4.get(r2), Integer.class, "com.obric.aiagent.plugin");
    L12:
        return null;
    }

    private boolean a(Set<String> r4, String r5) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L12;
        if (r5.startsWith((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private int a(boolean r4, b r5, com.bytedance.retrofit2.b.c r6) {
        r6.p().y = r5.f11319b;
        r6.p().C = this.i.size();
        r6.p().D = this.h.size();
        if (a(r5.g, r6.o()) == true) goto L29;
        if (r4 == true) goto L7;
    L9:
        if (r4 == true) goto L14;
        if (this.i.size() < r5.f11322e) goto L14;
        return 0;
    L14:
        if (r5.f11318a != a.f11314b) goto L20;
        Integer r3 = a(r5.h, r6.o());
        if (r3 != null) goto L18;
        return 0;
    L18:
        return r3.intValue();
    L20:
        if (r5.f11318a == a.f11315c) goto L22;
        return -1;
    L22:
        if (a(r5.i, r6.o()) == false) goto L24;
        return 0;
    L24:
        return r5.j;
    L7:
        if (this.h.size() < r5.f) goto L9;
        return 0;
    L29:
        throw new com.bytedance.frameworks.baselib.network.http.c.c();
    }

    private boolean a(b r3, com.bytedance.retrofit2.b.c r4) {
        if (a(r3.k, r4.o()) == false) goto L10;
        this.j.set(System.currentTimeMillis());
        this.k.add(r4);
        if (Logger.debug() == false) goto L18;
        Logger.d("delayrefine", "p0 add request " + r4.o() + " size " + this.k.size());
        return false;
    L18:
        return false;
    L10:
        if (r3.l.size() <= 0) goto L14;
        return a(r3.l, r4.o());
    L14:
        if (r3.m.size() > 0) goto L16;
        return true;
    L16:
        return !a(r3.m, r4.o());
    }
}
