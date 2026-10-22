package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: HostResolveManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String TAG = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.frameworks.baselib.network.http.i.f<String, a> f8509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, a> f8510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentMap<String, Future<Void>> f8511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentMap<String, Future<Void>> f8512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConcurrentMap<String, ConcurrentSkipListSet<c>> f8513e;
    private ConcurrentMap<String, ConcurrentSkipListSet<c>> f;
    private ConcurrentSkipListSet<String> g;
    private AtomicInteger h;
    private AtomicInteger i;
    private com.bytedance.common.utility.i.b j;
    private final long k;
    private final int l;
    private final Handler m;

    static {
    }

    public d(Handler r3) {
        this.f8509a = new com.bytedance.frameworks.baselib.network.http.i.f(100);
        this.f8510b = new ConcurrentHashMap();
        this.f8511c = new ConcurrentHashMap();
        this.f8512d = new ConcurrentHashMap();
        this.f8513e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentSkipListSet();
        this.h = new AtomicInteger(0);
        this.i = new AtomicInteger(0);
        this.j = com.bytedance.common.utility.i.b.f6736b;
        this.k = 180000;
        this.l = 10;
        this.m = r3;
    }

    public void a(Context r6) {
        com.bytedance.common.utility.i.b r7 = com.bytedance.common.utility.i.e((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"));
        if (r7 != this.j) goto L5;
    L32:
        this.j = r7;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "network changed, clear cache and re-batch-preload preload hosts, current net type is " + r7);
    L7:
        Map<String, a> r0 = this.f8509a.c();
        monitor-enter(r0);
        Iterator<Map.Entry<String, a>> r1 = this.f8509a.c().entrySet().iterator();     // Catch: Throwable -> L29
    L11:
        if (r1.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (r2 == null) goto L11;
        if (e.getService().f().get() == true) goto L16;
        ((a) ZeusTransformUtils.preCheckCast(r2.getValue(), a.class, "com.obric.aiagent.plugin")).d();     // Catch: Throwable -> L29
        goto L11
    L16:
        ((a) ZeusTransformUtils.preCheckCast(r2.getValue(), a.class, "com.obric.aiagent.plugin")).c();     // Catch: Throwable -> L29
        goto L11
    L18:
        this.f8509a.a();     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, a>> r3 = this.f8510b.entrySet().iterator();
    L22:
        if (r3.hasNext() == false) goto L26;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L22;
        ((a) ZeusTransformUtils.preCheckCast(r4.getValue(), a.class, "com.obric.aiagent.plugin")).f();
        goto L22
    L26:
        this.f8510b.clear();
        if (r7 == com.bytedance.common.utility.i.b.f6736b) goto L32;
        e.getService().a(a.EnumC0192a.f8495d);
        e.getService().i();
    L29:
        th = move-exception;
        throw th;
    }

    public void a(String r3, a r4) {
        a r0 = b(r3);
        if (r0 == null) goto L9;
        if (e.getService().f().get() == false) goto L7;
        r0.c();
        goto L9
    L7:
        r0.d();
    L9:
        if (e.getService().f().get() == false) goto L11;
        r4.a();
    L12:
        Map<String, a> r1 = this.f8509a.c();
        monitor-enter(r1);
        this.f8509a.a(r3, r4);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L11:
        r4.b();
        goto L12
    }

    public void a(String r3) {
        a r0 = b(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        if (e.getService().f().get() == false) goto L7;
        r0.c();
    L8:
        Map<String, a> r1 = this.f8509a.c();
        monitor-enter(r1);
        this.f8509a.b(r3);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L7:
        r0.d();
        goto L8
    }

    public a b(String r3) {
        Map<String, a> r0 = this.f8509a.c();
        monitor-enter(r0);
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f8509a.a(r3), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public void b(String r2, a r3) {
        a r0 = d(r2);
        if (r0 == null) goto L5;
        r0.f();
    L5:
        r3.e();
        this.f8510b.put(r2, r3);
    }

    public void c(String r2) {
        a r0 = d(r2);
        if (r0 == null) goto L6;
        r0.f();
        this.f8510b.remove(r2);
        return;
    }

    public a d(String r2) {
        if (this.f8510b.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return (a) ZeusTransformUtils.preCheckCast(this.f8510b.get(r2), a.class, "com.obric.aiagent.plugin");
    }

    public boolean e(String r1) {
        return this.f8511c.containsKey(r1);
    }

    public void a(String r3, Future<Void> r4) {
        Future<Void> r5 = (Future) ZeusTransformUtils.wrapperContextForParams(r4, Future.class, "com.obric.aiagent.plugin");
        this.f8511c.put(r3, r5);
    }

    public void f(String r1) {
        this.f8511c.remove(r1);
    }

    public Future<Void> g(String r2) {
        if (this.f8511c.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return (Future) ZeusTransformUtils.preCheckCast(this.f8511c.get(r2), Future.class, "com.obric.aiagent.plugin");
    }

    public void h(String r1) {
        this.f8512d.remove(r1);
    }

    public synchronized void a(String r3, c r4) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f8513e.containsKey(r3) == false) goto L6;
        ((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f8513e.get(r3), ConcurrentSkipListSet.class, "com.obric.aiagent.plugin")).add(r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        ConcurrentSkipListSet<c> r0 = new ConcurrentSkipListSet();     // Catch: Throwable -> L9
        r0.add(r4);     // Catch: Throwable -> L9
        this.f8513e.put(r3, r0);     // Catch: Throwable -> L9
        goto L7
    }

    public ConcurrentSkipListSet<c> i(String r2) {
        return (ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f8513e.get(r2), ConcurrentSkipListSet.class, "com.obric.aiagent.plugin");
    }

    public boolean j(String r1) {
        return this.f8513e.containsKey(r1);
    }

    public boolean a(c r3) {
        if (this.f8513e.containsKey(r3.a()) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f8513e.get(r3.a()), ConcurrentSkipListSet.class, "com.obric.aiagent.plugin")).contains(r3) == false) goto L7;
        return true;
    }

    public void b(c r5) {
        String r0 = r5.a();
        if (this.f8513e.containsKey(r0) == false) goto L8;
        ((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f8513e.get(r0), ConcurrentSkipListSet.class, "com.obric.aiagent.plugin")).remove(r5);
        if (((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f8513e.get(r0), ConcurrentSkipListSet.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
        this.f8513e.remove(r0);
        return;
    L9:
        return;
    }

    public ConcurrentSkipListSet<c> k(String r2) {
        return (ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f.get(r2), ConcurrentSkipListSet.class, "com.obric.aiagent.plugin");
    }

    public boolean l(String r1) {
        return this.f.containsKey(r1);
    }

    public boolean c(c r3) {
        if (this.f.containsKey(r3.a()) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f.get(r3.a()), ConcurrentSkipListSet.class, "com.obric.aiagent.plugin")).contains(r3) == false) goto L7;
        return true;
    }

    public void d(c r5) {
        String r0 = r5.a();
        if (this.f.containsKey(r0) == false) goto L8;
        ((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f.get(r0), ConcurrentSkipListSet.class, "com.obric.aiagent.plugin")).remove(r5);
        if (((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f.get(r0), ConcurrentSkipListSet.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
        this.f.remove(r0);
        return;
    L9:
        return;
    }

    public void m(String r2) {
        this.g.add(r2);
        if (this.g.size() >= 10) goto L5;
        return;
    L5:
        ArrayList r3 = new ArrayList();
        r3.addAll(this.g);
        e.getService().a(r3);
    }

    public void n(String r2) {
        if (this.g.contains(r2) == false) goto L6;
        this.g.remove(r2);
        return;
    }

    AtomicInteger a() {
        return this.h;
    }

    void b() {
        this.h.getAndIncrement();
    }

    AtomicInteger c() {
        return this.i;
    }

    void d() {
        this.i.getAndIncrement();
        if (this.i.get() < 2) goto L6;
        Message r0 = Message.obtain();
        r0.what = 20;
        r0.obj = this;
        this.m.sendMessageDelayed(r0, 180000);
        return;
    }

    void e() {
        this.i.set(0);
    }
}
