package com.stepos.agentbus.domain.queue;

import android.database.Cursor;
import android.os.Looper;
import d7.a0;
import d7.b0;
import d7.z;
import f3.d;
import g3.e;
import g3.f;
import g3.k;
import g3.q;
import i5.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import m3.a;
import n3.c;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stepos/agentbus/domain/queue/OfflineQueueDatabase;", "<init>", "()V", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class OfflineQueueDatabase {

    /* renamed from: a, reason: collision with root package name */
    public volatile c f2666a;

    /* renamed from: b, reason: collision with root package name */
    public d f2667b;

    /* renamed from: c, reason: collision with root package name */
    public q f2668c;

    /* renamed from: d, reason: collision with root package name */
    public a f2669d;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f2671f;

    /* renamed from: j, reason: collision with root package name */
    public final Map f2675j;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f2676k;

    /* renamed from: e, reason: collision with root package name */
    public final k f2670e = d();

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f2672g = new LinkedHashMap();

    /* renamed from: h, reason: collision with root package name */
    public final ReentrantReadWriteLock f2673h = new ReentrantReadWriteLock();

    /* renamed from: i, reason: collision with root package name */
    public final ThreadLocal f2674i = new ThreadLocal();

    public OfflineQueueDatabase() {
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        q7.k.d(mapSynchronizedMap, "synchronizedMap(mutableMapOf())");
        this.f2675j = mapSynchronizedMap;
        this.f2676k = new LinkedHashMap();
    }

    public static Object p(Class cls, a aVar) {
        if (cls.isInstance(aVar)) {
            return aVar;
        }
        if (aVar instanceof f) {
            return p(cls, ((f) aVar).a());
        }
        return null;
    }

    public final void a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        a();
        a();
        c cVarN = h().N();
        this.f2670e.d(cVarN);
        if (cVarN.k()) {
            cVarN.b();
        } else {
            cVarN.a();
        }
    }

    public final void c() {
        c cVar = this.f2666a;
        if (q7.k.a(cVar != null ? Boolean.valueOf(cVar.f6817f.isOpen()) : null, Boolean.TRUE)) {
            ReentrantReadWriteLock.WriteLock writeLock = this.f2673h.writeLock();
            q7.k.d(writeLock, "readWriteLock.writeLock()");
            writeLock.lock();
            try {
                this.f2670e.getClass();
                h().close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public abstract k d();

    public abstract a e(e eVar);

    public abstract i5.f f();

    public List g(Map map) {
        q7.k.e(map, "autoMigrationSpecs");
        return z.f2978f;
    }

    public final a h() {
        a aVar = this.f2669d;
        if (aVar != null) {
            return aVar;
        }
        q7.k.j("internalOpenHelper");
        throw null;
    }

    public Set i() {
        return b0.f2947f;
    }

    public Map j() {
        return a0.f2944f;
    }

    public final void k() {
        h().N().e();
        if (h().N().i()) {
            return;
        }
        k kVar = this.f2670e;
        if (kVar.f3815e.compareAndSet(false, true)) {
            d dVar = kVar.f3811a.f2667b;
            if (dVar != null) {
                dVar.execute(kVar.f3822l);
            } else {
                q7.k.j("internalQueryExecutor");
                throw null;
            }
        }
    }

    public final boolean l() {
        c cVar = this.f2666a;
        return cVar != null && cVar.f6817f.isOpen();
    }

    public final Cursor m(m3.c cVar) {
        q7.k.e(cVar, "query");
        a();
        if (h().N().i() || this.f2674i.get() == null) {
            return h().N().o(cVar);
        }
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    public final void n() {
        h().N().q();
    }

    public abstract l o();
}
