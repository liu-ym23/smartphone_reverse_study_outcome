package org.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: SubstituteLoggerFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public class k implements org.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f40292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map<String, j> f40293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final LinkedBlockingQueue<org.b.a.d> f40294c;

    public k() {
        this.f40292a = false;
        this.f40293b = new ConcurrentHashMap();
        this.f40294c = new LinkedBlockingQueue();
    }

    @Override // org.b.a
    public synchronized org.b.c a(String r4) {
        monitor-enter(this);
        j r0 = (j) ZeusTransformUtils.preCheckCast(this.f40293b.get(r4), j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = new j(r4, this.f40294c, this.f40292a);     // Catch: Throwable -> L8
        this.f40293b.put(r4, r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    public List<j> a() {
        return new ArrayList(this.f40293b.values());
    }

    public LinkedBlockingQueue<org.b.a.d> b() {
        return this.f40294c;
    }

    public void c() {
        this.f40292a = true;
    }

    public void d() {
        this.f40293b.clear();
        this.f40294c.clear();
    }
}
