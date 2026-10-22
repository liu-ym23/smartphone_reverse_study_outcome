package i5;

import com.stepos.agentbus.domain.queue.OfflineQueueDatabase;
import ia.d0;
import java.util.List;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final c5.c f4721a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4722b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4723c;

    /* renamed from: d, reason: collision with root package name */
    public final k5.a f4724d;

    /* renamed from: e, reason: collision with root package name */
    public final k5.t f4725e;

    /* renamed from: f, reason: collision with root package name */
    public final k5.q f4726f;

    /* renamed from: g, reason: collision with root package name */
    public final long f4727g;

    /* renamed from: h, reason: collision with root package name */
    public final f f4728h;

    /* renamed from: i, reason: collision with root package name */
    public final l f4729i;

    public u(OfflineQueueDatabase offlineQueueDatabase, c5.d dVar, int i2, long j2, k5.a aVar, k5.g gVar, a7.d dVar2, long j4) {
        q7.k.e(dVar, "codec");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        q7.k.e(dVar2, "internalBus");
        this.f4721a = dVar;
        this.f4722b = i2;
        this.f4723c = j2;
        this.f4724d = aVar;
        this.f4725e = gVar;
        this.f4726f = dVar2;
        this.f4727g = j4;
        this.f4728h = offlineQueueDatabase.f();
        this.f4729i = offlineQueueDatabase.o();
    }

    public final Object a(List list, p5.f fVar) throws Throwable {
        Object objB = d0.B(this.f4724d.f5619d, new a5.b(list, this, null, 8), fVar);
        return objB == h7.a.f4212f ? objB : c7.r.f1986a;
    }
}
