package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7367n = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f7368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentMap f7369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConcurrentMap f7370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConcurrentMap f7371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConcurrentMap f7372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConcurrentMap f7373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConcurrentSkipListSet f7374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AtomicInteger f7375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtomicInteger f7376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public NetworkUtils.NetworkType f7377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f7378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f7379l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f7380m;

    static {
    }

    public a(Handler r10) {
        this.f7368a = new d(100);
        this.f7369b = new ConcurrentHashMap();
        this.f7370c = new ConcurrentHashMap();
        this.f7371d = new ConcurrentHashMap();
        this.f7372e = new ConcurrentHashMap();
        this.f7373f = new ConcurrentHashMap();
        this.f7374g = new ConcurrentSkipListSet();
        this.f7375h = new AtomicInteger(0);
        this.f7376i = new AtomicInteger(0);
        this.f7377j = NetworkUtils.NetworkType.NONE;
        this.f7378k = 180000;
        this.f7379l = 10;
        this.f7380m = r10;
    }

    public void A() {
        this.f7375h.getAndIncrement();
    }

    public boolean B(String r10) {
        return this.f7372e.containsKey(r10);
    }

    public boolean C(HostResolveJob r10) {
        if (this.f7372e.containsKey(r10.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ConcurrentSkipListSet) this.f7372e.get(r10.getHost())).contains(r10) == false) goto L7;
        return true;
    }

    public boolean D(String r10) {
        return this.f7373f.containsKey(r10);
    }

    public boolean E(HostResolveJob r10) {
        if (this.f7373f.containsKey(r10.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ConcurrentSkipListSet) this.f7373f.get(r10.getHost())).contains(r10) == false) goto L7;
        return true;
    }

    public void a(String r10, DnsRecord r11) {
        DnsRecord r12 = i(r10);
        if (r12 == null) goto L9;
        if (b.q().s().get() == false) goto L7;
        r12.h();
        goto L9
    L7:
        r12.i();
    L9:
        if (b.q().s().get() == false) goto L11;
        r11.a();
    L12:
        Map r13 = this.f7368a.e();
        monitor-enter(r13);
        this.f7368a.f(r10, r11);     // Catch: Throwable -> L17
        monitor-exit(r13);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L11:
        r11.b();
        goto L12
    }

    public void b() {
        this.f7376i.getAndIncrement();
        if (this.f7376i.get() < 2) goto L6;
        Message r10 = Message.obtain();
        r10.what = 20;
        r10.obj = this;
        this.f7380m.sendMessageDelayed(r10, 180000);
        return;
    }

    public synchronized void c(String r10, HostResolveJob r11) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f7372e.containsKey(r10) == false) goto L8;
        ((ConcurrentSkipListSet) this.f7372e.get(r10)).add(r11);     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        ConcurrentSkipListSet r12 = new ConcurrentSkipListSet();     // Catch: Throwable -> L6
        r12.add(r11);     // Catch: Throwable -> L6
        this.f7372e.put(r10, r12);     // Catch: Throwable -> L6
        goto L9
    }

    public void d(String r10, Future r11) {
        this.f7370c.put(r10, r11);
    }

    public void e(String r10) {
        this.f7374g.add(r10);
        if (this.f7374g.size() >= 10) goto L5;
        return;
    L5:
        ArrayList r11 = new ArrayList();
        r11.addAll(this.f7374g);
        b.q().c(r11);
    }

    public void f(String r10, DnsRecord r11) {
        DnsRecord r12 = m(r10);
        if (r12 == null) goto L5;
        r12.j();
    L5:
        r11.c();
        this.f7369b.put(r10, r11);
    }

    public void g(String r10, Future r11) {
        this.f7371d.put(r10, r11);
    }

    public AtomicInteger h() {
        return this.f7375h;
    }

    public DnsRecord i(String r10) {
        Map r11 = this.f7368a.e();
        monitor-enter(r11);
        DnsRecord r12 = (DnsRecord) this.f7368a.d(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public AtomicInteger j() {
        return this.f7376i;
    }

    public ConcurrentSkipListSet k(String r10) {
        return (ConcurrentSkipListSet) this.f7372e.get(r10);
    }

    public Future l(String r10) {
        if (this.f7370c.containsKey(r10) == true) goto L5;
        return null;
    L5:
        return (Future) this.f7370c.get(r10);
    }

    public DnsRecord m(String r10) {
        if (this.f7369b.containsKey(r10) == true) goto L5;
        return null;
    L5:
        return (DnsRecord) this.f7369b.get(r10);
    }

    public ConcurrentSkipListSet n(String r10) {
        return (ConcurrentSkipListSet) this.f7373f.get(r10);
    }

    public Future o(String r10) {
        if (this.f7371d.containsKey(r10) == true) goto L5;
        return null;
    L5:
        return (Future) this.f7371d.get(r10);
    }

    public boolean p(String r10) {
        return this.f7370c.containsKey(r10);
    }

    public boolean q(String r10) {
        return this.f7371d.containsKey(r10);
    }

    public void r(Context r10) {
        NetworkUtils.NetworkType r11 = NetworkUtils.f(r10);
        if (r11 == this.f7377j) goto L30;
        Logger.d(f7367n, "network changed, clear cache and re-batch-preload preload hosts, current net type is " + r11);
        Map r12 = this.f7368a.e();
        monitor-enter(r12);
        Iterator r13 = this.f7368a.e().entrySet().iterator();     // Catch: Throwable -> L14
    L8:
        if (r13.hasNext() == false) goto L17;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L14
        if (r14 == null) goto L8;
        if (b.q().s().get() == true) goto L13;
        ((DnsRecord) r14.getValue()).i();     // Catch: Throwable -> L14
        goto L8
    L13:
        ((DnsRecord) r14.getValue()).h();     // Catch: Throwable -> L14
        goto L8
    L17:
        this.f7368a.c();     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        Iterator r15 = this.f7369b.entrySet().iterator();
    L21:
        if (r15.hasNext() == false) goto L25;
        Map.Entry r16 = (Map.Entry) r15.next();
        if (r16 == null) goto L21;
        ((DnsRecord) r16.getValue()).j();
        goto L21
    L25:
        this.f7369b.clear();
        if (r11 == NetworkUtils.NetworkType.NONE) goto L30;
        b.q().e(DnsRecord.CacheStaleReason.CACHE_STALE_NETCHANGED);
        b.q().G();
    L14:
        th = move-exception;
        throw th;
    L30:
        this.f7377j = r11;
    }

    public void s(String r10) {
        DnsRecord r11 = i(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (b.q().s().get() == false) goto L7;
        r11.h();
    L8:
        Map r12 = this.f7368a.e();
        monitor-enter(r12);
        this.f7368a.g(r10);     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L7:
        r11.i();
        goto L8
    }

    public void t(HostResolveJob r10) {
        String r11 = r10.getHost();
        if (this.f7372e.containsKey(r11) == false) goto L8;
        ((ConcurrentSkipListSet) this.f7372e.get(r11)).remove(r10);
        if (((ConcurrentSkipListSet) this.f7372e.get(r11)).isEmpty() == false) goto L9;
        this.f7372e.remove(r11);
        return;
    L9:
        return;
    }

    public void u(String r10) {
        this.f7370c.remove(r10);
    }

    public void v(String r10) {
        if (this.f7374g.contains(r10) == false) goto L6;
        this.f7374g.remove(r10);
        return;
    }

    public void w(String r10) {
        DnsRecord r11 = m(r10);
        if (r11 == null) goto L6;
        r11.j();
        this.f7369b.remove(r10);
        return;
    }

    public void x(HostResolveJob r10) {
        String r11 = r10.getHost();
        if (this.f7373f.containsKey(r11) == false) goto L8;
        ((ConcurrentSkipListSet) this.f7373f.get(r11)).remove(r10);
        if (((ConcurrentSkipListSet) this.f7373f.get(r11)).isEmpty() == false) goto L9;
        this.f7373f.remove(r11);
        return;
    L9:
        return;
    }

    public void y(String r10) {
        this.f7371d.remove(r10);
    }

    public void z() {
        this.f7376i.set(0);
    }
}
