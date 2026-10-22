package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HttpDns.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8514a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f8515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f8516c;
    private static String f;
    private static HandlerThread u;
    private static WeakHandler v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f8517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f8518e;
    private volatile String g;
    private ConcurrentSkipListSet<String> h;
    private ConcurrentMap<String, CopyOnWriteArrayList<String>> i;
    private ConcurrentSkipListSet<String> j;
    private AtomicInteger k;
    private AtomicInteger l;
    private AtomicInteger m;
    private AtomicInteger n;
    private AtomicInteger o;
    private AtomicInteger p;
    private final d q;
    private final com.bytedance.frameworks.baselib.network.http.ok3.impl.h r;
    private volatile h s;
    private boolean t;
    private Handler w;

    static /* synthetic */ String k() {
        return f8514a;
    }

    static {
        f8515b = Executors.newFixedThreadPool(6);
    }

    public static e getService() {
        if (f8516c != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8516c != null) goto L9;
        f8516c = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f8516c;
    }

    private e() {
        this.f8517d = new AtomicBoolean(true);
        this.f8518e = new AtomicBoolean(false);
        this.h = new ConcurrentSkipListSet();
        this.i = new ConcurrentHashMap();
        this.j = new ConcurrentSkipListSet();
        this.k = new AtomicInteger(30);
        this.l = new AtomicInteger(DownloadErrorCode.ERROR_CRONET_ERROR_BASE);
        this.m = new AtomicInteger(60);
        this.n = new AtomicInteger(0);
        this.o = new AtomicInteger(5);
        this.p = new AtomicInteger(5);
        this.r = new com.bytedance.frameworks.baselib.network.http.ok3.impl.h();
        this.t = false;
        final Looper r1 = Looper.getMainLooper();
        this.w = new HttpDns$1(this, r1);
        if (Logger.debug() == false) goto L5;
        Logger.d(f8514a, "HttpDns constructor");
    L5:
        HandlerThread r0 = new HandlerThread("TTOK-HTTPDNS");
        u = r0;
        r0.start();
        v = new WeakHandler(u.getLooper(), this);
        f = "4.2.243.22-doubao";
        this.q = new d(v);
    }

    public void a(h r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.aiagent.plugin");
        if (this.t == true) goto L5;
        if (r6 != null) goto L10;
    L33:
        this.s = null;
        throw new IllegalArgumentException("you must set correct httpdns depend");
    L10:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L33;
        if (TextUtils.isEmpty(r6.c()) == true) goto L33;
        if (r6.b() == null) goto L33;
        this.s = r6;
        if (TextUtils.isEmpty(this.g) == false) goto L18;
        this.g = r6.c();
    L18:
        this.t = true;
        i();
        this.r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (this.j.size() < 1) goto L21;
        a(a.EnumC0192a.f);
    L31:
        Message r7 = Message.obtain();
        r7.what = 5;
        r7.obj = this;
        v.sendMessage(r7);
        return;
    L21:
        if (this.s.a() == null) goto L28;
        if (this.s.a().length <= 0) goto L28;
        if (this.s.a().length > 10) goto L28;
        this.j.addAll(Arrays.asList(this.s.a()));
        a(a.EnumC0192a.f);
    L28:
        if (Logger.debug() == false) goto L31;
        Logger.d(f8514a, "httpdns preload domains's number must less than 10, httpdns preload is skipped.");
        goto L31
    L5:
        if (Logger.debug() == false) goto L35;
        Logger.d(f8514a, "you have set httpdns depend before.");
        return;
    }

    synchronized void a(a.EnumC0192a r6) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (this.s != null) goto L6;
    L34:
        monitor-exit(this);
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.i.h.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L34;
        ConcurrentSkipListSet<String> r0 = this.j;     // Catch: Throwable -> L36
        if (r0 == null) goto L34;
        if (r0.size() == 0) goto L34;
        if (this.j.size() > 10) goto L34;
        if (Logger.debug() == false) goto L17;
        Logger.d(f8514a, "do httpdns preload");     // Catch: Throwable -> L36
    L17:
        Iterator<String> r1 = this.j.iterator();     // Catch: Throwable -> L36
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L36
    L19:
        if (r1.hasNext() == false) goto L25;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        if (this.q.e(r3) == true) goto L19;
        r2.add(r3);     // Catch: Throwable -> L36
        goto L19
    L25:
        if (r2.size() != 0) goto L29;
        monitor-exit(this);
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d(f8514a, "httpdns batch preload for : " + r2);     // Catch: Throwable -> L36
    L31:
        a(r2, r6, false);     // Catch: Throwable -> L36
        monitor-exit(this);
    }

    void a(String r3) {
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.a.a(r3) == true) goto L5;
        return;
    L5:
        if (this.q.e(r3) == false) goto L7;
        return;
    L7:
        if (this.f8518e.get() == false) goto L12;
        ArrayList r0 = new ArrayList();
        r0.add(r3);
        a(r0, a.EnumC0192a.f8496e, false);
        return;
    }

    void b(String r2) {
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.a.a(r2) == true) goto L5;
        return;
    L5:
        if (this.q.e(r2) == true) goto L9;
        this.q.a(r2);
        return;
    }

    void c(String r1) {
        this.q.m(r1);
    }

    void a(List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d(f8514a, "batchRefreshHttpDnsStaleCache for host " + r5);
    L5:
        a(r5, a.EnumC0192a.g, false);
    }

    void d(String r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f8514a, "removeLocalDnsStaleCache");
    L6:
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.a.a(r3) == false) goto L9;
        this.q.c(r3);
        return;
    }

    public void a(JSONObject r8) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f8514a, "onServerConfigChanged");
    L6:
        if (this.s == null) goto L65;
        if (r8 == null) goto L80;
        int r0 = r8.optInt("ttnet_http_dns_enabled", -1);
        boolean r2 = false;
        if (r0 < 0) goto L16;
        AtomicBoolean r4 = this.f8517d;
        if (r0 != 1) goto L14;
        boolean r1 = true;
    L15:
        r4.set(r1);
        goto L16
    L14:
        r1 = false;
    L16:
        String r3 = r8.optString("ttnet_tt_http_dns_domain");
        if (TextUtils.isEmpty(r3) == true) goto L19;
        this.g = r3;
    L19:
        JSONArray r5 = r8.optJSONArray("ttnet_tt_http_dns_preload_batch_host");
        if (r5 == null) goto L28;
        this.j.clear();
        int r6 = 0;
    L23:
        if (r6 >= r5.length()) goto L28;
        String r7 = r5.optString(r6);
        if (TextUtils.isEmpty(r7) == true) goto L27;
        this.j.add(r7);
    L27:
        r6 = r6 + 1;
    L28:
        int r9 = r8.optInt("localdns_cache_ttl", -1);
        if (r9 < 0) goto L31;
        this.k.set(r9);
    L31:
        int r10 = r8.optInt("httpdns_prefer_time_ms", -1);
        if (r10 < 0) goto L34;
        this.l.set(r10);
    L34:
        int r11 = r8.optInt("httpdns_stale_cache_interval", -1);
        if (r11 < 0) goto L37;
        this.m.set(r11);
    L37:
        int r12 = r8.optInt("enable_compare_localdns_httpdns", -1);
        if (r12 < 0) goto L40;
        this.n.set(r12);
    L40:
        int r13 = r8.optInt("ttnet_http_dns_prefer", -1);
        if (r13 < 0) goto L46;
        AtomicBoolean r14 = this.f8518e;
        if (r13 != 1) goto L45;
        r2 = true;
    L45:
        r14.set(r2);
    L46:
        int r15 = r8.optInt("ttnet_http_dns_timeout", -1);
        if (r15 < 0) goto L49;
        this.o.set(r15);
    L49:
        int r16 = r8.optInt("ttnet_local_dns_time_out", -1);
        if (r16 < 0) goto L52;
        this.p.set(r16);
    L52:
        JSONObject r17 = r8.optJSONObject("ttnet_http_dns_addr");
        if (r17 == null) goto L79;
        this.i.clear();
        Iterator<String> r18 = r17.keys();
    L56:
        if (r18.hasNext() == false) goto L81;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.aiagent.plugin");
        String r20 = r17.optString(r19);
        if (TextUtils.isEmpty(r19) == true) goto L56;
        if (TextUtils.isEmpty(r20) == true) goto L56;
        String[] r21 = r20.split(",");
        if (r19.equals(this.g) == true) goto L63;
        this.i.put(r19, new CopyOnWriteArrayList(Arrays.asList(r21)));
        goto L56
    L63:
        this.h.clear();
        this.h.addAll(Arrays.asList(r21));
        goto L56
    L81:
        return;
    L79:
        return;
    L80:
        return;
    }

    synchronized Future<Void> a(List<String> r9, a.EnumC0192a r10, boolean r11) {
        monitor-enter(this);
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        Future<Void> r0 = null;
        if (r12 == null) goto L43;
        if (r12.size() == 0) goto L43;
        int r1 = 0;
    L10:
        if (r1 >= r12.size()) goto L23;
        if (this.q.e((String) ZeusTransformUtils.preCheckCast(r12.get(r1), String.class, "com.obric.aiagent.plugin")) == false) goto L21;
        if (r11 == true) goto L15;
    L20:
        r12.remove(r12.get(r1));     // Catch: Throwable -> L47
        goto L21
    L15:
        if (r12.size() != 1) goto L20;
        if (r1 != 0) goto L20;
        r0 = this.q.g((String) ZeusTransformUtils.preCheckCast(r12.get(r1), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L20;
        Logger.d(f8514a, "sync block request for " + ((String) ZeusTransformUtils.preCheckCast(r12.get(r1), String.class, "com.obric.aiagent.plugin")) + " is resolving");     // Catch: Throwable -> L47
    L21:
        r1 = r1 + 1;     // Catch: Throwable -> L47
        goto L10
    L23:
        if (r12.size() != 0) goto L27;
        monitor-exit(this);
        return r0;
    L27:
        if (Logger.debug() == false) goto L50;
        Logger.d(f8514a, "submit httpdns resolve for host : " + r12);     // Catch: Throwable -> L47
    L50:
        r0 = f8515b.submit(new f(com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.a.a(r12), f, this.q, r10, v));     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        Iterator r13 = r12.iterator();     // Catch: RejectedExecutionException -> L36 Throwable -> L47
    L31:
        if (r13.hasNext() == false) goto L40;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        this.q.a(r14, r0);     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        if (this.f8518e.get() == false) goto L31;
        this.q.n(r14);     // Catch: RejectedExecutionException -> L36 Throwable -> L47
    L40:
        monitor-exit(this);
        return r0;
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L40;
        Logger.d(f8514a, "submit httpdns resolve for host : " + r12 + " was rejected");     // Catch: Throwable -> L47
    L43:
        if (Logger.debug() == false) goto L45;
        Logger.d(f8514a, "httpdns resolve hostlist is null.");     // Catch: Throwable -> L47
    L45:
        monitor-exit(this);
        return null;
    L47:
        th = move-exception;
        throw th;
    }

    private b a(String r4, boolean r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f8514a, "lookup localdns cache for host " + r4);
    L5:
        b r0 = new b();
        a r3 = this.q.d(r4);
        if (r3 != null) goto L9;
        return null;
    L9:
        r0.f8497a = r3.i();
        r0.f8498b = r3.j();
        if (r5 == false) goto L12;
        r0.f8499c = b.a.f8504e;
    L13:
        return r0;
    L12:
        r0.f8499c = b.a.f;
        goto L13
    }

    private b b(String r6, boolean r7) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f8514a, "look up httpdns cache for host " + r6);
    L5:
        a r5 = this.q.b(r6);
        if (r5 != null) goto L8;
        return null;
    L8:
        b r0 = new b();
        r0.f8497a = r5.i();
        r0.f8498b = r5.j();
        if (r7 == false) goto L16;
        if (((r5.h() * 1000) + r5.g()) <= System.currentTimeMillis()) goto L14;
        r0.f8499c = b.a.f8503d;
        return r0;
    L14:
        return null;
    L16:
        if (((r5.h() * 1000) + r5.g()) <= System.currentTimeMillis()) goto L18;
        r0.f8499c = b.a.f8501b;
    L19:
        return r0;
    L18:
        r0.f8499c = b.a.f8502c;
        goto L19
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f8514a, "httpdns handler handle msg in " + Thread.currentThread().getName());
    L5:
        if (r11 != null) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r11.obj, e.class) == false) goto L9;
    L230:
    L225:
        th = move-exception;
        th.printStackTrace();
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r11.obj, e.class) == false) goto L38;
        if (r11.what != 2) goto L38;
        if (Logger.debug() == false) goto L25;
        Logger.d(f8514a, "MSG_HTTPDNS_PREFER_TIMEOUT");     // Catch: Throwable -> L225
    L25:
        c r12 = (c) ZeusTransformUtils.preCheckCast(r11.getData().getSerializable("httpdns_timeout_job_key"), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L225
        if (r12 != null) goto L32;
        if (Logger.debug() == false) goto L246;
        Logger.d(f8514a, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L225
        return;
    L246:
        return;
    L32:
        if (this.q.a(r12) == true) goto L34;
        return;
    L34:
        if (Logger.debug() == false) goto L36;
        Logger.d(f8514a, "httpdns request not return in httpdns prefer time for host : " + r12.a());     // Catch: Throwable -> L225
    L36:
        a(r12, a(r12.a(), r12.b()));     // Catch: Throwable -> L225
        this.q.b(r12);     // Catch: Throwable -> L225
        return;
    L38:
        if (ZeusTransformUtils.instanceOf(r11.obj, f.class) == true) goto L40;
    L70:
        int r6 = 0;
        if (ZeusTransformUtils.instanceOf(r11.obj, j.class) == false) goto L104;
        if (r11.what != 1) goto L104;
        if (Logger.debug() == false) goto L77;
        Logger.d(f8514a, "MSG_LOCALDNS_COMPLETED");     // Catch: Throwable -> L225
    L77:
        String r13 = r11.getData().getString("localdns_completed_host");     // Catch: Throwable -> L225
        if (r13 != null) goto L84;
        if (Logger.debug() == false) goto L248;
        Logger.d(f8514a, "MSG_HTTPDNS_COMPLETED host is null");     // Catch: Throwable -> L225
        return;
    L248:
        return;
    L84:
        if (this.q.l(r13) == true) goto L86;
        return;
    L86:
        if (Logger.debug() == false) goto L88;
        Logger.d(f8514a, "localdns returned in localdns timeout for host : " + r13);     // Catch: Throwable -> L225
    L88:
        Iterator<c> r0 = this.q.k(r13).iterator();     // Catch: Throwable -> L225
    L90:
        if (r0.hasNext() == false) goto L277;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L225
        b r2 = a(r13, true);     // Catch: Throwable -> L225
        if (r2 != null) goto L98;
        b r3 = b(r13, false);     // Catch: Throwable -> L225
        if (r3 != null) goto L96;
        a(r1);     // Catch: Throwable -> L225
        this.q.a(r1.a(), r1);     // Catch: Throwable -> L225
    L101:
        this.q.d(r1);     // Catch: Throwable -> L225
        goto L90
    L96:
        a(r1, r3);     // Catch: Throwable -> L225
        goto L101
    L98:
        if (Logger.debug() == false) goto L100;
        Logger.d(f8514a, "localdns request is returned in timeout for " + r13);     // Catch: Throwable -> L225
    L100:
        a(r1, r2);     // Catch: Throwable -> L225
        goto L101
    L277:
        return;
    L104:
        if (ZeusTransformUtils.instanceOf(r11.obj, e.class) == false) goto L130;
        if (r11.what != 3) goto L130;
        if (Logger.debug() == false) goto L110;
        Logger.d(f8514a, "MSG_LOCALDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L225
    L110:
        c r14 = (c) ZeusTransformUtils.preCheckCast(r11.getData().getSerializable("dns_timeout_job_key"), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L225
        if (r14 != null) goto L117;
        if (Logger.debug() == false) goto L249;
        Logger.d(f8514a, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L225
        return;
    L249:
        return;
    L117:
        if (this.q.c(r14) == true) goto L119;
        return;
    L119:
        if (Logger.debug() == false) goto L121;
        Logger.d(f8514a, "local request not return in localdns timeout for host : " + r14.a());     // Catch: Throwable -> L225
    L121:
        b r4 = b(r14.a(), false);     // Catch: Throwable -> L225
        if (r4 == null) goto L125;
        a(r14, r4);     // Catch: Throwable -> L225
    L128:
        this.q.d(r14);     // Catch: Throwable -> L225
        return;
    L125:
        if (this.q.e(r14.a()) == true) goto L127;
        a(r14);     // Catch: Throwable -> L225
    L127:
        this.q.a(r14.a(), r14);     // Catch: Throwable -> L225
    L130:
        if (ZeusTransformUtils.instanceOf(r11.obj, e.class) == false) goto L146;
        if (r11.what != 4) goto L146;
        if (Logger.debug() == false) goto L136;
        Logger.d(f8514a, "MSG_HTTPDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L225
    L136:
        c r15 = (c) ZeusTransformUtils.preCheckCast(r11.getData().getSerializable("dns_timeout_job_key"), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L225
        if (r15 != null) goto L143;
        if (Logger.debug() == false) goto L250;
        Logger.d(f8514a, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L225
        return;
    L250:
        return;
    L143:
        if (this.q.a(r15) == false) goto L258;
        a(r15, null);     // Catch: Throwable -> L225
        this.q.b(r15);     // Catch: Throwable -> L225
        return;
    L258:
        return;
    L146:
        if (ZeusTransformUtils.instanceOf(r11.obj, e.class) == false) goto L171;
        if (r11.what != 5) goto L171;
        if (Logger.debug() == false) goto L152;
        Logger.d(f8514a, "MSG_LOAD_LOCAL_HARDCODEIPS");     // Catch: Throwable -> L225
    L152:
        String r16 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences("dispatchersdk_httpdns_hardcodeips", 0).getString("httpdns_hardcodeips", "");     // Catch: Throwable -> L225
        if (TextUtils.isEmpty(r16) == true) goto L166;
        this.h.clear();     // Catch: Throwable -> L225
        JSONArray r5 = new JSONArray(r16);     // Catch: JSONException -> L162 Throwable -> L225
    L157:
        if (r6 >= r5.length()) goto L278;
        String r17 = r5.optString(r6);     // Catch: JSONException -> L162 Throwable -> L225
        if (TextUtils.isEmpty(r17) == true) goto L161;
        this.h.add(r17);     // Catch: JSONException -> L162 Throwable -> L225
    L161:
        r6 = r6 + 1;
        goto L157
    L278:
        return;
    L163:
        if (Logger.debug() == false) goto L260;
        Logger.d(f8514a, "local httpdns hardcode ips not exists, use default");     // Catch: Throwable -> L225
        return;
    L260:
        return;
    L166:
        if (this.s.d() != null) goto L168;
        return;
    L168:
        if (this.h.size() != 0) goto L263;
        this.h.addAll(Arrays.asList(this.s.d()));     // Catch: Throwable -> L225
        return;
    L263:
        return;
    L171:
        if (ZeusTransformUtils.instanceOf(r11.obj, e.class) == false) goto L179;
        if (r11.what != 6) goto L179;
        if (Logger.debug() == false) goto L177;
        Logger.d(f8514a, "network changed");     // Catch: Throwable -> L225
    L177:
        this.q.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getService().c().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L225
        return;
    L179:
        if (ZeusTransformUtils.instanceOf(r11.obj, e.class) == false) goto L187;
        if (r11.what != 7) goto L187;
        if (Logger.debug() == false) goto L185;
        Logger.d(f8514a, "activity resume, detect ipv6 reachable");     // Catch: Throwable -> L225
    L185:
        i();     // Catch: Throwable -> L225
        return;
    L187:
        if (ZeusTransformUtils.instanceOf(r11.obj, a.class) == false) goto L214;
        String r10 = r11.getData().getString("dnsrecord_host");     // Catch: Throwable -> L225
        if (TextUtils.isEmpty(r10) == false) goto L195;
        if (Logger.debug() == false) goto L251;
        Logger.d(f8514a, "DnsRecord refresh host is null");     // Catch: Throwable -> L225
        return;
    L251:
        return;
    L195:
        switch(r11.what) {
            case 10: goto L210;
            case 11: goto L206;
            case 12: goto L202;
            case 13: goto L198;
            default: goto L267;
        };     // Catch: Throwable -> L225
    L267:
        return;
    L198:
        if (Logger.debug() == false) goto L200;
        Logger.d(f8514a, "remove httpdns cache for host : " + r10);     // Catch: Throwable -> L225
    L200:
        getService().b(r10);     // Catch: Throwable -> L225
        return;
    L202:
        if (Logger.debug() == false) goto L204;
        Logger.d(f8514a, "add host : " + r10 + " to stale cache host list");     // Catch: Throwable -> L225
    L204:
        getService().c(r10);     // Catch: Throwable -> L225
        return;
    L206:
        if (Logger.debug() == false) goto L208;
        Logger.d(f8514a, "remove localdns cache for host : " + r10);     // Catch: Throwable -> L225
    L208:
        getService().d(r10);     // Catch: Throwable -> L225
        return;
    L210:
        if (Logger.debug() == false) goto L212;
        Logger.d(f8514a, "refresh httpdns cache for host : " + r10);     // Catch: Throwable -> L225
    L212:
        getService().a(r10);     // Catch: Throwable -> L225
        return;
    L214:
        if (ZeusTransformUtils.instanceOf(r11.obj, d.class) == false) goto L222;
        if (r11.what != 20) goto L222;
        if (Logger.debug() == false) goto L220;
        Logger.d(f8514a, "reset httpdns domain failed count");     // Catch: Throwable -> L225
    L220:
        this.q.e();     // Catch: Throwable -> L225
        return;
    L222:
        if (Logger.debug() == false) goto L273;
        Logger.d(f8514a, "HTTPDNS-CollectResult handler thread receive a unknown message : " + r11);     // Catch: Throwable -> L225
        return;
    L273:
        return;
    L40:
        if (r11.what != 3) goto L70;
        if (Logger.debug() == false) goto L44;
        Logger.d(f8514a, "MSG_HTTPDNS_COMPLETED");     // Catch: Throwable -> L225
    L44:
        ArrayList<String> r18 = r11.getData().getStringArrayList("httpdns_completed_hosts");     // Catch: Throwable -> L225
        if (r18 == null) goto L47;
        Iterator<String> r7 = r18.iterator();     // Catch: Throwable -> L225
    L52:
        if (r7.hasNext() == false) goto L276;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L225
        if (this.q.j(r8) == false) goto L52;
        if (Logger.debug() == false) goto L59;
        Logger.d(f8514a, "httpdns returned in httpdns prefer time for host : " + r18);     // Catch: Throwable -> L225
    L59:
        Iterator<c> r9 = this.q.i(r8).iterator();     // Catch: Throwable -> L225
    L61:
        if (r9.hasNext() == false) goto L52;
        c r19 = (c) ZeusTransformUtils.preCheckCast(r9.next(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L225
        b r20 = b(r8, true);     // Catch: Throwable -> L225
        if (getService().f().get() == false) goto L67;
        if (r20 != null) goto L67;
        r20 = a(r8, r19.b());     // Catch: Throwable -> L225
    L67:
        if (Logger.debug() == false) goto L69;
        Logger.d(f8514a, "httpdns request is returned in prefer time for " + r8);     // Catch: Throwable -> L225
    L69:
        a(r19, r20);     // Catch: Throwable -> L225
        this.q.b(r19);     // Catch: Throwable -> L225
        goto L61
    L276:
        return;
    L47:
        if (Logger.debug() == false) goto L247;
        Logger.d(f8514a, "MSG_HTTPDNS_COMPLETED hostlist is null");     // Catch: Throwable -> L225
        return;
    L247:
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r11.obj, f.class) == true) goto L230;
        if (ZeusTransformUtils.instanceOf(r11.obj, j.class) == true) goto L230;
        if (ZeusTransformUtils.instanceOf(r11.obj, a.class) == true) goto L230;
        if (ZeusTransformUtils.instanceOf(r11.obj, d.class) == true) goto L230;
    }

    private void a(c r6) {
        ArrayList r0 = new ArrayList();
        r0.add(r6.a());
        a(r0, a.EnumC0192a.f8492a, false);
        Message r1 = Message.obtain();
        r1.what = 4;
        r1.obj = this;
        Bundle r2 = new Bundle();
        r2.putSerializable("dns_timeout_job_key", r6);
        r1.setData(r2);
        v.sendMessageDelayed(r1, ((long) this.o.get()) * 1000);
    }

    private void a(c r4, b r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f8514a, "doDnsResultCallback for host " + r4.a());
    L5:
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 1;
        Bundle r1 = new Bundle();
        r1.putSerializable("callback_dnsresult_job_key", r4);
        r1.putSerializable("callback_dnsresult_key", r5);
        r0.setData(r1);
        this.w.sendMessage(r0);
    }

    AtomicInteger a() {
        return this.k;
    }

    AtomicInteger b() {
        return this.m;
    }

    public h c() {
        return this.s;
    }

    String d() {
        return this.g;
    }

    ConcurrentSkipListSet<String> e() {
        return this.h;
    }

    void a(JSONArray r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() <= 0) goto L18;
        this.h.clear();
        int r1 = 0;
    L7:
        if (r1 >= r5.length()) goto L12;
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r2) == true) goto L11;
        this.h.add(r2);
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        SharedPreferences.Editor r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences("dispatchersdk_httpdns_hardcodeips", 0).edit();
        r4.putString("httpdns_hardcodeips", String.valueOf(r5));
        r4.apply();
        return;
    }

    public AtomicBoolean f() {
        return this.f8518e;
    }

    public void g() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 7;
        v.sendMessage(r0);
    }

    public void h() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 6;
        v.sendMessage(r0);
    }

    void i() {
        f8515b.submit(new i());     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public HandlerThread j() {
        return u;
    }
}
