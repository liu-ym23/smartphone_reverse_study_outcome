package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f7381r = "b";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static ExecutorService f7382s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile b f7383t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f7384u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static HandlerThread f7385v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static WeakHandler f7386w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f7387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f7388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f7389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConcurrentSkipListSet f7390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConcurrentMap f7391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConcurrentSkipListSet f7392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicInteger f7393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AtomicInteger f7394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtomicInteger f7395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AtomicInteger f7396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AtomicInteger f7397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AtomicInteger f7398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a f7399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.frameworks.baselib.network.http.ok3.impl.a f7400n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile IHttpDnsDepend f7401o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7402p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Handler f7403q;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f7404a;

        public a(b r10, Looper r11) {
            this.f7404a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            super.handleMessage(r10);
            if (r10 != null) goto L5;
            return;
        L5:
            if ((r10.obj instanceof b) == false) goto L17;
            Bundle r11 = r10.getData();
            DnsResult r12 = (DnsResult) r11.getSerializable("callback_dnsresult_key");
            HostResolveJob r13 = (HostResolveJob) r11.getSerializable("callback_dnsresult_job_key");
            if (r13 != null) goto L12;
            Logger.d(b.a(), "callback job is null");
            return;
        L12:
            if (r10.what != 1) goto L18;
            Logger.d(b.a(), "callback dns result for host " + r13.getHost() + " in thread " + Thread.currentThread().getName());
            r13.mHttpDnsCallback.onHttpDnsCompleted(r12);
            return;
        L18:
            return;
        }
    }

    static {
        f7382s = Executors.newFixedThreadPool(6);
    }

    public b() {
        this.f7387a = new AtomicBoolean(true);
        this.f7388b = new AtomicBoolean(false);
        this.f7390d = new ConcurrentSkipListSet();
        this.f7391e = new ConcurrentHashMap();
        this.f7392f = new ConcurrentSkipListSet();
        this.f7393g = new AtomicInteger(30);
        this.f7394h = new AtomicInteger(2000);
        this.f7395i = new AtomicInteger(60);
        this.f7396j = new AtomicInteger(0);
        this.f7397k = new AtomicInteger(5);
        this.f7398l = new AtomicInteger(5);
        this.f7400n = new com.bytedance.frameworks.baselib.network.http.ok3.impl.a();
        this.f7402p = false;
        this.f7403q = new a(this, Looper.getMainLooper());
        Logger.d(f7381r, "HttpDns constructor");
        HandlerThread r10 = new HandlerThread("TTOK-HTTPDNS");
        f7385v = r10;
        r10.start();
        f7386w = new WeakHandler(f7385v.getLooper(), this);
        f7384u = "4.1.79.42-pico";
        this.f7399m = new com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a(f7386w);
    }

    public static /* synthetic */ String a() {
        return f7381r;
    }

    public static b q() {
        if (f7383t != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f7383t != null) goto L11;
        f7383t = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f7383t;
    }

    public void A(String r10) {
        Logger.d(f7381r, "removeLocalDnsStaleCache");
        if (t4.a.a(r10) == false) goto L6;
        this.f7399m.w(r10);
        return;
    }

    public void B(IHttpDnsDepend r10) {
        if (this.f7402p == false) goto L6;
        Logger.d(f7381r, "you have set httpdns depend before.");
        return;
    L6:
        if (r10 != null) goto L8;
    L29:
        this.f7401o = null;
        throw new IllegalArgumentException("you must set correct httpdns depend");
    L8:
        if (r10.getContext() == null) goto L29;
        if (TextUtils.isEmpty(r10.getHttpDnsDomain()) == true) goto L29;
        if (r10.getAppId() == null) goto L29;
        this.f7401o = r10;
        if (TextUtils.isEmpty(this.f7389c) == false) goto L16;
        this.f7389c = r10.getHttpDnsDomain();
    L16:
        this.f7402p = true;
        G();
        this.f7400n.a(r10.getContext());
        if (this.f7392f.size() < 1) goto L19;
        e(DnsRecord.CacheStaleReason.PRELOAD_BATCH);
    L27:
        Message r11 = Message.obtain();
        r11.what = 5;
        r11.obj = this;
        f7386w.sendMessage(r11);
        return;
    L19:
        if (this.f7401o.getPreloadDomains() != null) goto L21;
    L25:
        Logger.d(f7381r, "httpdns preload domains's number must less than 10, httpdns preload is skipped.");
        goto L27
    L21:
        if (this.f7401o.getPreloadDomains().length <= 0) goto L25;
        if (this.f7401o.getPreloadDomains().length > 10) goto L25;
        this.f7392f.addAll(Arrays.asList(this.f7401o.getPreloadDomains()));
        e(DnsRecord.CacheStaleReason.PRELOAD_BATCH);
        goto L27
    }

    public void C(JSONArray r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() <= 0) goto L18;
        this.f7390d.clear();
        int r11 = 0;
    L7:
        if (r11 >= r10.length()) goto L12;
        String r12 = r10.optString(r11);
        if (TextUtils.isEmpty(r12) == true) goto L11;
        this.f7390d.add(r12);
    L11:
        r11 = r11 + 1;
        goto L7
    L12:
        SharedPreferences.Editor r13 = this.f7401o.getContext().getSharedPreferences("dispatchersdk_httpdns_hardcodeips", 0).edit();
        r13.putString("httpdns_hardcodeips", String.valueOf(r10));
        r13.apply();
        return;
    }

    public final Future D(String r10, List r11, boolean r12) {
        DnsRecord r13 = this.f7399m.m(r10);
        if (r13 != null) goto L5;
    L6:
        r11.set(0, Boolean.TRUE);
        if (this.f7399m.q(r10) == true) goto L10;
        H(r10);
    L10:
        if (this.f7399m.p(r10) == false) goto L12;
        Logger.d(f7381r, "httpdns is resolving for host " + r10);
        return this.f7399m.l(r10);
    L12:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (this.f7399m.p(r10) == false) goto L18;
        Future r14 = this.f7399m.l(r10);     // Catch: Throwable -> L16
    L19:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r14;
    L18:
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L16
        r15.add(r10);     // Catch: Throwable -> L16
        r14 = E(r15, DnsRecord.CacheStaleReason.CACHE_UNSET, r12);     // Catch: Throwable -> L16
        goto L19
    L5:
        if ((r13.d() + (r13.g() * 1000)) > (System.currentTimeMillis() + ((long) this.f7394h.get()))) goto L10;
        goto L6
    }

    public synchronized Future E(List r10, DnsRecord.CacheStaleReason r11, boolean r12) {
        monitor-enter(this);
        Future r13 = null;
        if (r10 != null) goto L45;
    L38:
        Logger.d(f7381r, "httpdns resolve hostlist is null.");     // Catch: Throwable -> L18
        monitor-exit(this);
        return null;
    L45:
    L18:
        th = move-exception;
        throw th;
    L6:
        if (r10.size() == 0) goto L38;
        int r14 = 0;
    L10:
        if (r14 >= r10.size()) goto L23;
        if (this.f7399m.p((String) r10.get(r14)) == false) goto L21;
        if (r12 == true) goto L15;
    L20:
        r10.remove(r10.get(r14));     // Catch: Throwable -> L18
        goto L21
    L15:
        if (r10.size() != 1) goto L20;
        if (r14 != 0) goto L20;
        r13 = this.f7399m.l((String) r10.get(r14));     // Catch: Throwable -> L18
        Logger.d(f7381r, "sync block request for " + ((String) r10.get(r14)) + " is resolving");     // Catch: Throwable -> L18
    L21:
        r14 = r14 + 1;     // Catch: Throwable -> L18
        goto L10
    L23:
        if (r10.size() != 0) goto L26;
        monitor-exit(this);
        return r13;
    L26:
        Logger.d(f7381r, "submit httpdns resolve for host : " + r10);     // Catch: Throwable -> L18
        r13 = f7382s.submit(new c(t4.a.b(r10), f7384u, this.f7399m, r11, f7386w));     // Catch: Throwable -> L18 RejectedExecutionException -> L34
        Iterator r15 = r10.iterator();     // Catch: Throwable -> L18 RejectedExecutionException -> L34
    L29:
        if (r15.hasNext() == false) goto L36;
        String r16 = (String) r15.next();     // Catch: Throwable -> L18 RejectedExecutionException -> L34
        this.f7399m.d(r16, r13);     // Catch: Throwable -> L18 RejectedExecutionException -> L34
        if (this.f7388b.get() == false) goto L29;
        this.f7399m.v(r16);     // Catch: Throwable -> L18 RejectedExecutionException -> L34
    L36:
        monitor-exit(this);
        return r13;
    L34:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        Logger.d(f7381r, "submit httpdns resolve for host : " + r10 + " was rejected");     // Catch: Throwable -> L18
        goto L36
    }

    public final void F(HostResolveJob r10) {
        ArrayList r11 = new ArrayList();
        r11.add(r10.getHost());
        E(r11, DnsRecord.CacheStaleReason.CACHE_UNSET, false);
        Message r12 = Message.obtain();
        r12.what = 4;
        r12.obj = this;
        Bundle r13 = new Bundle();
        r13.putSerializable("dns_timeout_job_key", r10);
        r12.setData(r13);
        f7386w.sendMessageDelayed(r12, ((long) this.f7397k.get()) * 1000);
    }

    public void G() {
        f7382s.submit(new s4.a());     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final synchronized Future H(String r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f7399m.q(r10) == false) goto L10;
        Logger.d(f7381r, "localdns is resolving for host : " + r10);     // Catch: Throwable -> L8
        Future r11 = this.f7399m.o(r10);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L10:
        Logger.d(f7381r, "submit localdns resolve host : " + r10);     // Catch: Throwable -> L8
        Future r12 = null;
        r12 = f7382s.submit(new s4.b(r10, this.f7399m, f7386w));     // Catch: Throwable -> L8 RejectedExecutionException -> L14
        this.f7399m.g(r10, r12);     // Catch: Throwable -> L8 RejectedExecutionException -> L14
    L16:
        monitor-exit(this);
        return r12;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L16
    }

    public void b(String r10) {
        this.f7399m.e(r10);
    }

    public void c(List r10) {
        Logger.d(f7381r, "batchRefreshHttpDnsStaleCache for host " + r10);
        E(r10, DnsRecord.CacheStaleReason.REFRESH_BATCH, false);
    }

    public final void d(HostResolveJob r10, DnsResult r11) {
        Logger.d(f7381r, "doDnsResultCallback for host " + r10.getHost());
        Message r12 = Message.obtain();
        r12.obj = this;
        r12.what = 1;
        Bundle r13 = new Bundle();
        r13.putSerializable("callback_dnsresult_job_key", r10);
        r13.putSerializable("callback_dnsresult_key", r11);
        r12.setData(r13);
        this.f7403q.sendMessage(r12);
    }

    public synchronized void e(DnsRecord.CacheStaleReason r10) {
        monitor-enter(this);
        ConcurrentSkipListSet r11 = this.f7392f;     // Catch: Throwable -> L17
        if (r11 != null) goto L6;
    L26:
        monitor-exit(this);
        return;
    L6:
        if (r11.size() == 0) goto L26;
        if (this.f7392f.size() > 10) goto L26;
        Logger.d(f7381r, "do httpdns preload");     // Catch: Throwable -> L17
        Iterator r12 = this.f7392f.iterator();     // Catch: Throwable -> L17
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L17
    L12:
        if (r12.hasNext() == false) goto L20;
        String r14 = (String) r12.next();     // Catch: Throwable -> L17
        if (this.f7399m.p(r14) == true) goto L12;
        r13.add(r14);     // Catch: Throwable -> L17
        goto L12
    L20:
        if (r13.size() != 0) goto L23;
        monitor-exit(this);
        return;
    L23:
        Logger.d(f7381r, "httpdns batch preload for : " + r13);     // Catch: Throwable -> L17
        E(r13, r10, false);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final DnsResult f(Future r10, String r11, boolean r12) {
        Logger.d(f7381r, "getDnsResultInHttpDnsPreferTime");
        if (r10 != null) goto L7;
        Logger.d(f7381r, "httpdns future is null");     // Catch: TimeoutException -> L15 ExecutionException -> L16 InterruptedException -> L17
        return u(r11, r12);
    L7:
        if (r10.isDone() == false) goto L11;
        Logger.d(f7381r, "httpdns future is done");     // Catch: TimeoutException -> L15 ExecutionException -> L16 InterruptedException -> L17
        DnsResult r13 = t(r11, true);     // Catch: TimeoutException -> L15 ExecutionException -> L16 InterruptedException -> L17
        if (r13 == null) goto L21;
        return r13;
    L21:
        return u(r11, r12);
    L11:
        r10.get(q().l().get(), TimeUnit.MILLISECONDS);     // Catch: TimeoutException -> L15 ExecutionException -> L16 InterruptedException -> L17
        DnsResult r14 = t(r11, true);     // Catch: TimeoutException -> L15 ExecutionException -> L16 InterruptedException -> L17
        if (r14 == null) goto L25;
        return r14;
    L25:
        return u(r11, r12);
    L17:
        Logger.d(f7381r, "httpdns InterruptedException, look up localdns");
        return u(r11, r12);
    L16:
        Logger.d(f7381r, "httpdns ExecutionException, look up localdns");
        return u(r11, r12);
    L15:
        Logger.d(f7381r, "httpdns timeout in httpdns prefer time, look up localdns");
        return u(r11, r12);
    }

    public final DnsResult g(String r10) {
        Logger.d(f7381r, "try to look up hardcode ips");
        if (this.f7391e.containsKey(r10) == false) goto L16;
        DnsResult r11 = new DnsResult();
        Iterator r12 = ((CopyOnWriteArrayList) this.f7391e.get(r10)).iterator();
    L6:
        if (r12.hasNext() == false) goto L14;
        String r13 = (String) r12.next();
        if (t4.c.d(r13) == true) goto L9;
        if (t4.c.c(r13) == true) goto L12;
        Logger.d(f7381r, "find a invalid hardcode ip: " + r13);
        goto L6
    L12:
        r11.ipv4List.add(r13);
        goto L6
    L9:
        r11.ipv6List.add(r13);
        goto L6
    L14:
        r11.source = DnsResult.Source.HARDCODE_IPS;
        return r11;
    L16:
        return null;
    }

    public IHttpDnsDepend h() {
        return this.f7401o;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        Logger.d(f7381r, "httpdns handler handle msg in " + Thread.currentThread().getName());
        if (r10 == null) goto L173;
        Object r11 = r10.obj;
        if ((r11 instanceof b) == false) goto L7;
    L156:
    L24:
        th = move-exception;
        th.printStackTrace();
        return;
    L17:
        if ((r11 instanceof b) == false) goto L30;
        if (r10.what != 2) goto L30;
        Logger.d(f7381r, "MSG_HTTPDNS_PREFER_TIMEOUT");     // Catch: Throwable -> L24
        HostResolveJob r12 = (HostResolveJob) r10.getData().getSerializable("httpdns_timeout_job_key");     // Catch: Throwable -> L24
        if (r12 != null) goto L27;
        Logger.d(f7381r, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L24
        return;
    L27:
        if (this.f7399m.C(r12) == false) goto L174;
        Logger.d(f7381r, "httpdns request not return in httpdns prefer time for host : " + r12.getHost());     // Catch: Throwable -> L24
        d(r12, u(r12.getHost(), r12.isLocalDnsExpired()));     // Catch: Throwable -> L24
        this.f7399m.t(r12);     // Catch: Throwable -> L24
        return;
    L174:
        return;
    L30:
        if ((r11 instanceof c) == true) goto L32;
    L51:
        int r13 = 0;
        if ((r11 instanceof s4.b) == false) goto L74;
        if (r10.what != 1) goto L74;
        Logger.d(f7381r, "MSG_LOCALDNS_COMPLETED");     // Catch: Throwable -> L24
        String r14 = r10.getData().getString("localdns_completed_host");     // Catch: Throwable -> L24
        if (r14 != null) goto L60;
        Logger.d(f7381r, "MSG_HTTPDNS_COMPLETED host is null");     // Catch: Throwable -> L24
        return;
    L60:
        if (this.f7399m.D(r14) == false) goto L176;
        Logger.d(f7381r, "localdns returned in localdns timeout for host : " + r14);     // Catch: Throwable -> L24
        Iterator r15 = this.f7399m.n(r14).iterator();     // Catch: Throwable -> L24
    L63:
        if (r15.hasNext() == false) goto L196;
        HostResolveJob r16 = (HostResolveJob) r15.next();     // Catch: Throwable -> L24
        DnsResult r17 = u(r14, true);     // Catch: Throwable -> L24
        if (r17 != null) goto L70;
        DnsResult r18 = t(r14, false);     // Catch: Throwable -> L24
        if (r18 != null) goto L69;
        F(r16);     // Catch: Throwable -> L24
        this.f7399m.c(r16.getHost(), r16);     // Catch: Throwable -> L24
    L71:
        this.f7399m.x(r16);     // Catch: Throwable -> L24
        goto L63
    L69:
        d(r16, r18);     // Catch: Throwable -> L24
        goto L71
    L70:
        Logger.d(f7381r, "localdns request is returned in timeout for " + r14);     // Catch: Throwable -> L24
        d(r16, r17);     // Catch: Throwable -> L24
        goto L71
    L196:
        return;
    L176:
        return;
    L74:
        if ((r11 instanceof b) == false) goto L92;
        if (r10.what != 3) goto L92;
        Logger.d(f7381r, "MSG_LOCALDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L24
        HostResolveJob r19 = (HostResolveJob) r10.getData().getSerializable("dns_timeout_job_key");     // Catch: Throwable -> L24
        if (r19 != null) goto L82;
        Logger.d(f7381r, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L24
        return;
    L82:
        if (this.f7399m.E(r19) == false) goto L177;
        Logger.d(f7381r, "local request not return in localdns timeout for host : " + r19.getHost());     // Catch: Throwable -> L24
        DnsResult r20 = t(r19.getHost(), false);     // Catch: Throwable -> L24
        if (r20 == null) goto L87;
        d(r19, r20);     // Catch: Throwable -> L24
    L90:
        this.f7399m.x(r19);     // Catch: Throwable -> L24
        return;
    L87:
        if (this.f7399m.p(r19.getHost()) == true) goto L89;
        F(r19);     // Catch: Throwable -> L24
    L89:
        this.f7399m.c(r19.getHost(), r19);     // Catch: Throwable -> L24
        goto L90
    L177:
        return;
    L92:
        if ((r11 instanceof b) == false) goto L103;
        if (r10.what != 4) goto L103;
        Logger.d(f7381r, "MSG_HTTPDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L24
        HostResolveJob r110 = (HostResolveJob) r10.getData().getSerializable("dns_timeout_job_key");     // Catch: Throwable -> L24
        if (r110 != null) goto L100;
        Logger.d(f7381r, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L24
        return;
    L100:
        if (this.f7399m.C(r110) == false) goto L179;
        d(r110, null);     // Catch: Throwable -> L24
        this.f7399m.t(r110);     // Catch: Throwable -> L24
        return;
    L179:
        return;
    L103:
        if ((r11 instanceof b) == false) goto L123;
        if (r10.what != 5) goto L123;
        Logger.d(f7381r, "MSG_LOAD_LOCAL_HARDCODEIPS");     // Catch: Throwable -> L24
        String r111 = this.f7401o.getContext().getSharedPreferences("dispatchersdk_httpdns_hardcodeips", 0).getString("httpdns_hardcodeips", "");     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r111) == true) goto L118;
        this.f7390d.clear();     // Catch: Throwable -> L24
        JSONArray r21 = new JSONArray(r111);     // Catch: Throwable -> L24 JSONException -> L116
    L111:
        if (r13 >= r21.length()) goto L197;
        String r112 = r21.optString(r13);     // Catch: Throwable -> L24 JSONException -> L116
        if (TextUtils.isEmpty(r112) == true) goto L115;
        this.f7390d.add(r112);     // Catch: Throwable -> L24 JSONException -> L116
    L115:
        r13 = r13 + 1;
        goto L111
    L197:
        return;
    L116:
        Logger.d(f7381r, "local httpdns hardcode ips not exists, use default");     // Catch: Throwable -> L24
        return;
    L118:
        if (this.f7401o.getHardCodeIps() != null) goto L120;
        return;
    L120:
        if (this.f7390d.size() != 0) goto L183;
        this.f7390d.addAll(Arrays.asList(this.f7401o.getHardCodeIps()));     // Catch: Throwable -> L24
        return;
    L183:
        return;
    L123:
        if ((r11 instanceof b) == false) goto L128;
        if (r10.what != 6) goto L128;
        Logger.d(f7381r, "network changed");     // Catch: Throwable -> L24
        this.f7399m.r(q().h().getContext());     // Catch: Throwable -> L24
        return;
    L128:
        if ((r11 instanceof b) == false) goto L133;
        if (r10.what != 7) goto L133;
        Logger.d(f7381r, "activity resume, detect ipv6 reachable");     // Catch: Throwable -> L24
        G();     // Catch: Throwable -> L24
        return;
    L133:
        if ((r11 instanceof DnsRecord) == false) goto L146;
        String r22 = r10.getData().getString("dnsrecord_host");     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r22) == false) goto L139;
        Logger.d(f7381r, "DnsRecord refresh host is null");     // Catch: Throwable -> L24
        return;
    L139:
        switch(r10.what) {
            case 10: goto L144;
            case 11: goto L143;
            case 12: goto L142;
            case 13: goto L141;
            default: goto L187;
        };     // Catch: Throwable -> L24
    L141:
        Logger.d(f7381r, "remove httpdns cache for host : " + r22);     // Catch: Throwable -> L24
        q().z(r22);     // Catch: Throwable -> L24
        return;
    L142:
        Logger.d(f7381r, "add host : " + r22 + " to stale cache host list");     // Catch: Throwable -> L24
        q().b(r22);     // Catch: Throwable -> L24
        return;
    L143:
        Logger.d(f7381r, "remove localdns cache for host : " + r22);     // Catch: Throwable -> L24
        q().A(r22);     // Catch: Throwable -> L24
        return;
    L144:
        Logger.d(f7381r, "refresh httpdns cache for host : " + r22);     // Catch: Throwable -> L24
        q().y(r22);     // Catch: Throwable -> L24
        return;
    L187:
        return;
    L146:
        if ((r11 instanceof com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a) == true) goto L148;
    L150:
        Logger.d(f7381r, "HTTPDNS-CollectResult handler thread receive a unknown message : " + r10);     // Catch: Throwable -> L24
        return;
    L148:
        if (r10.what != 20) goto L150;
        Logger.d(f7381r, "reset httpdns domain failed count");     // Catch: Throwable -> L24
        this.f7399m.z();     // Catch: Throwable -> L24
        return;
    L32:
        if (r10.what != 3) goto L51;
        Logger.d(f7381r, "MSG_HTTPDNS_COMPLETED");     // Catch: Throwable -> L24
        ArrayList<String> r113 = r10.getData().getStringArrayList("httpdns_completed_hosts");     // Catch: Throwable -> L24
        if (r113 != null) goto L37;
        Logger.d(f7381r, "MSG_HTTPDNS_COMPLETED hostlist is null");     // Catch: Throwable -> L24
        return;
    L37:
        Iterator<String> r23 = r113.iterator();     // Catch: Throwable -> L24
    L39:
        if (r23.hasNext() == false) goto L195;
        String r24 = r23.next();     // Catch: Throwable -> L24
        if (this.f7399m.B(r24) == false) goto L39;
        Logger.d(f7381r, "httpdns returned in httpdns prefer time for host : " + r113);     // Catch: Throwable -> L24
        Iterator r25 = this.f7399m.k(r24).iterator();     // Catch: Throwable -> L24
    L45:
        if (r25.hasNext() == false) goto L39;
        HostResolveJob r26 = (HostResolveJob) r25.next();     // Catch: Throwable -> L24
        DnsResult r27 = t(r24, true);     // Catch: Throwable -> L24
        if (q().s().get() == false) goto L50;
        if (r27 != null) goto L50;
        r27 = u(r24, r26.isLocalDnsExpired());     // Catch: Throwable -> L24
    L50:
        Logger.d(f7381r, "httpdns request is returned in prefer time for " + r24);     // Catch: Throwable -> L24
        d(r26, r27);     // Catch: Throwable -> L24
        this.f7399m.t(r26);     // Catch: Throwable -> L24
        goto L45
    L195:
        return;
    L7:
        if ((r11 instanceof c) == true) goto L156;
        if ((r11 instanceof s4.b) == true) goto L156;
        if ((r11 instanceof DnsRecord) == true) goto L156;
        if ((r11 instanceof com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a) == true) goto L156;
        return;
    }

    public String i() {
        return this.f7389c;
    }

    public ConcurrentSkipListSet j() {
        return this.f7390d;
    }

    public HandlerThread k() {
        return f7385v;
    }

    public AtomicInteger l() {
        return this.f7394h;
    }

    public AtomicInteger m() {
        return this.f7395i;
    }

    public DnsResult n(String r10) {
        Logger.d(f7381r, "getHttpDnsResultForHostSyncBlock for host : " + r10);
        if (r(r10) == false) goto L6;
        return null;
    L6:
        boolean r11 = r10.equals(this.f7389c);
        if (this.f7388b.get() == false) goto L13;
        if (r11 == true) goto L13;
        DnsResult r12 = t(r10, false);
        if (r12 == null) goto L12;
        return r12;
    L12:
        ArrayList r13 = new ArrayList();
        r13.add(0, Boolean.FALSE);
        DnsResult r14 = f(D(r10, r13, true), r10, ((Boolean) r13.get(0)).booleanValue());
    L36:
        if (r14 == null) goto L38;
        return r14;
    L38:
        return g(r10);
    L13:
        DnsResult r15 = u(r10, false);
        if (r15 == null) goto L17;
        return r15;
    L17:
        if (this.f7399m.q(r10) == false) goto L19;
        Future r16 = this.f7399m.o(r10);
    L20:
        if (r16 != null) goto L26;
        DnsResult r17 = o(r10, r11);
        if (r17 == null) goto L24;
        return r17;
    L24:
        return g(r10);
    L26:
        if (r16.isDone() == false) goto L39;
        DnsResult r18 = u(r10, true);
        if (r18 != null) goto L30;
        r14 = o(r10, r11);
    L30:
        r14 = r18;
        goto L36
    L39:
        r16.get(((long) this.f7398l.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L35
        r18 = u(r10, true);     // Catch: Exception -> L35
        if (r18 != null) goto L30;
        r14 = o(r10, r11);     // Catch: Exception -> L35
    L35:
        r14 = o(r10, r11);
        goto L36
    L19:
        r16 = H(r10);
        goto L20
    }

    public final DnsResult o(String r10, boolean r11) {
        if (r11 == false) goto L6;
        return null;
    L6:
        if (this.f7399m.p(r10) == false) goto L8;
        Future r12 = this.f7399m.l(r10);
    L9:
        if (r12 != null) goto L12;
        return null;
    L12:
        if (r12.isDone() == true) goto L19;
        r12.get(((long) this.f7397k.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16
        return t(r10, true);
    L20:
        return null;
    L19:
        return t(r10, true);
    L8:
        ArrayList r13 = new ArrayList();
        r13.add(r10);
        r12 = E(r13, DnsRecord.CacheStaleReason.CACHE_UNSET, true);
        goto L9
    }

    public AtomicInteger p() {
        return this.f7393g;
    }

    public final boolean r(String r10) {
        if (this.f7402p == true) goto L7;
        Logger.d(f7381r, "you have not set httpdns depend");
        return true;
    L7:
        if (this.f7387a.get() == true) goto L11;
        Logger.d(f7381r, "httpdns was unabled by tnc");
        return true;
    L11:
        if (t4.a.a(r10) == true) goto L15;
        Logger.d(f7381r, "illegal host");
        return true;
    L15:
        if (t4.c.c(r10) == false) goto L17;
    L21:
        Logger.d(f7381r, "host is ipaddress");
        return true;
    L17:
        if (t4.c.d(r10) == true) goto L21;
        return false;
    }

    public AtomicBoolean s() {
        return this.f7388b;
    }

    public final DnsResult t(String r10, boolean r11) {
        Logger.d(f7381r, "look up httpdns cache for host " + r10);
        DnsRecord r12 = this.f7399m.i(r10);
        if (r12 != null) goto L5;
        return null;
    L5:
        DnsResult r13 = new DnsResult();
        r13.ipv4List = r12.e();
        r13.ipv6List = r12.f();
        if (r11 == false) goto L13;
        if (((r12.g() * 1000) + r12.d()) <= System.currentTimeMillis()) goto L11;
        r13.source = DnsResult.Source.HTTPDNS_REQUEST;
        return r13;
    L11:
        return null;
    L13:
        if (((r12.g() * 1000) + r12.d()) <= System.currentTimeMillis()) goto L15;
        r13.source = DnsResult.Source.HTTPDNS_CACHE;
    L16:
        return r13;
    L15:
        r13.source = DnsResult.Source.HTTPDNS_STALE_CACHE;
        goto L16
    }

    public final DnsResult u(String r10, boolean r11) {
        Logger.d(f7381r, "lookup localdns cache for host " + r10);
        DnsResult r12 = new DnsResult();
        DnsRecord r13 = this.f7399m.m(r10);
        if (r13 != null) goto L6;
        return null;
    L6:
        r12.ipv4List = r13.e();
        r12.ipv6List = r13.f();
        if (r11 == false) goto L9;
        r12.source = DnsResult.Source.LOCALDNS_REQUEST;
    L10:
        return r12;
    L9:
        r12.source = DnsResult.Source.LOCALDNS_CACHE;
        goto L10
    }

    public void v() {
        Message r10 = Message.obtain();
        r10.obj = this;
        r10.what = 6;
        f7386w.sendMessage(r10);
    }

    public void w() {
        Message r10 = Message.obtain();
        r10.obj = this;
        r10.what = 7;
        f7386w.sendMessage(r10);
    }

    public void x(JSONObject r10) {
        Logger.d(f7381r, "onServerConfigChanged");
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = r10.optInt("ttnet_http_dns_enabled", -1);
        boolean r12 = false;
        if (r11 < 0) goto L12;
        AtomicBoolean r13 = this.f7387a;
        if (r11 != 1) goto L10;
        boolean r14 = true;
    L11:
        r13.set(r14);
        goto L12
    L10:
        r14 = false;
    L12:
        String r15 = r10.optString("ttnet_tt_http_dns_domain");
        if (TextUtils.isEmpty(r15) == true) goto L15;
        this.f7389c = r15;
    L15:
        JSONArray r16 = r10.optJSONArray("ttnet_tt_http_dns_preload_batch_host");
        if (r16 == null) goto L24;
        this.f7392f.clear();
        int r17 = 0;
    L19:
        if (r17 >= r16.length()) goto L24;
        String r18 = r16.optString(r17);
        if (TextUtils.isEmpty(r18) == true) goto L23;
        this.f7392f.add(r18);
    L23:
        r17 = r17 + 1;
    L24:
        int r19 = r10.optInt("localdns_cache_ttl", -1);
        if (r19 < 0) goto L27;
        this.f7393g.set(r19);
    L27:
        int r20 = r10.optInt("httpdns_prefer_time_ms", -1);
        if (r20 < 0) goto L30;
        this.f7394h.set(r20);
    L30:
        int r21 = r10.optInt("httpdns_stale_cache_interval", -1);
        if (r21 < 0) goto L33;
        this.f7395i.set(r21);
    L33:
        int r22 = r10.optInt("enable_compare_localdns_httpdns", -1);
        if (r22 < 0) goto L36;
        this.f7396j.set(r22);
    L36:
        int r23 = r10.optInt("ttnet_http_dns_prefer", -1);
        if (r23 < 0) goto L42;
        AtomicBoolean r24 = this.f7388b;
        if (r23 != 1) goto L41;
        r12 = true;
    L41:
        r24.set(r12);
    L42:
        int r25 = r10.optInt("ttnet_http_dns_timeout", -1);
        if (r25 < 0) goto L45;
        this.f7397k.set(r25);
    L45:
        int r26 = r10.optInt("ttnet_local_dns_time_out", -1);
        if (r26 < 0) goto L48;
        this.f7398l.set(r26);
    L48:
        JSONObject r27 = r10.optJSONObject("ttnet_http_dns_addr");
        if (r27 == null) goto L61;
        this.f7391e.clear();
        Iterator<String> r28 = r27.keys();
    L52:
        if (r28.hasNext() == false) goto L75;
        String r29 = r28.next();
        String r30 = r27.optString(r29);
        if (TextUtils.isEmpty(r29) == true) goto L52;
        if (TextUtils.isEmpty(r30) == true) goto L52;
        String[] r31 = r30.split(",");
        if (r29.equals(this.f7389c) == true) goto L59;
        this.f7391e.put(r29, new CopyOnWriteArrayList(Arrays.asList(r31)));
        goto L52
    L59:
        this.f7390d.clear();
        this.f7390d.addAll(Arrays.asList(r31));
        goto L52
    L75:
        return;
    }

    public void y(String r10) {
        if (t4.a.a(r10) == true) goto L5;
        return;
    L5:
        if (this.f7399m.p(r10) == false) goto L7;
        return;
    L7:
        if (this.f7388b.get() == false) goto L12;
        ArrayList r11 = new ArrayList();
        r11.add(r10);
        E(r11, DnsRecord.CacheStaleReason.CACHE_STALE_EXPIRED, false);
        return;
    }

    public void z(String r10) {
        if (t4.a.a(r10) == true) goto L5;
        return;
    L5:
        if (this.f7399m.p(r10) == true) goto L9;
        this.f7399m.s(r10);
        return;
    }
}
