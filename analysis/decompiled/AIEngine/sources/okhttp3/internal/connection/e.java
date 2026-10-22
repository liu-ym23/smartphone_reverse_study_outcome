package okhttp3.internal.connection;

import bd.l;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import lb.n;
import okhttp3.internal.connection.d;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f11061a;

    /* renamed from: b, reason: collision with root package name */
    public final ad.e f11062b;

    /* renamed from: c, reason: collision with root package name */
    public final q<e, okhttp3.a, ed.c, ed.e> f11063c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11064d;

    /* renamed from: f, reason: collision with root package name */
    public final dd.d f11066f;

    /* renamed from: e, reason: collision with root package name */
    public volatile Map<okhttp3.a, a> f11065e = kotlin.collections.b.d0();

    /* renamed from: g, reason: collision with root package name */
    public final b f11067g = new b(ai.onnxruntime.a.o(new StringBuilder(), l.f3239c, " ConnectionPool connection closer"));
    public final ConcurrentLinkedQueue<ed.g> h = new ConcurrentLinkedQueue<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends dd.a {
        public b(String str) {
            super(str, true);
        }

        @Override // dd.a
        public final long a() {
            long j10;
            e eVar = e.this;
            long jNanoTime = System.nanoTime();
            Map<okhttp3.a, a> map = eVar.f11065e;
            Iterator<a> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
            Iterator<ed.g> it2 = eVar.h.iterator();
            while (it2.hasNext()) {
                ed.g next = it2.next();
                if (map.get(next.f8651d.f176a) != null) {
                    synchronized (next) {
                        n nVar = n.f10413a;
                    }
                }
            }
            long j11 = (jNanoTime - eVar.f11064d) + 1;
            Iterator<ed.g> it3 = eVar.h.iterator();
            int i10 = 0;
            long j12 = Long.MAX_VALUE;
            ed.g gVar = null;
            ed.g gVar2 = null;
            int i11 = 0;
            while (it3.hasNext()) {
                ed.g next2 = it3.next();
                kotlin.jvm.internal.g.c(next2);
                synchronized (next2) {
                    if (eVar.a(next2, jNanoTime) > 0) {
                        i11++;
                        j10 = jNanoTime;
                    } else {
                        int i12 = i11;
                        long j13 = next2.f8666u;
                        if (j13 < j11) {
                            j11 = j13;
                            gVar = next2;
                        }
                        j10 = jNanoTime;
                        if (map.get(next2.f8651d.f176a) != null) {
                            throw null;
                        }
                        i10++;
                        if (j13 < j12) {
                            j12 = j13;
                            gVar2 = next2;
                        }
                        i11 = i12;
                    }
                    n nVar2 = n.f10413a;
                }
                jNanoTime = j10;
            }
            long j14 = jNanoTime;
            int i13 = i11;
            if (gVar == null) {
                if (i10 > eVar.f11061a) {
                    j11 = j12;
                    gVar = gVar2;
                } else {
                    gVar = null;
                    j11 = -1;
                }
            }
            if (gVar == null) {
                if (gVar2 != null) {
                    return (j12 + eVar.f11064d) - j14;
                }
                if (i13 > 0) {
                    return eVar.f11064d;
                }
                return -1L;
            }
            synchronized (gVar) {
                if (!gVar.f8665t.isEmpty()) {
                    return 0L;
                }
                if (gVar.f8666u != j11) {
                    return 0L;
                }
                gVar.f8660n = true;
                eVar.h.remove(gVar);
                a aVar = map.get(gVar.f8651d.f176a);
                if (aVar != null) {
                    eVar.b(aVar);
                    throw null;
                }
                Socket socket = gVar.f8653f;
                kotlin.jvm.internal.g.c(socket);
                l.c(socket);
                if (eVar.h.isEmpty()) {
                    eVar.f11066f.a();
                }
                return 0L;
            }
        }
    }

    static {
        AtomicReferenceFieldUpdater.newUpdater(e.class, Map.class, "e");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(dd.e eVar, int i10, long j10, TimeUnit timeUnit, ad.e eVar2, q<? super e, ? super okhttp3.a, ? super ed.c, ? extends ed.e> qVar) {
        this.f11061a = i10;
        this.f11062b = eVar2;
        this.f11063c = qVar;
        this.f11064d = timeUnit.toNanos(j10);
        this.f11066f = eVar.e();
        if (j10 <= 0) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "keepAliveDuration <= 0: ").toString());
        }
    }

    public final int a(ed.g gVar, long j10) {
        okhttp3.f fVar = l.f3237a;
        ArrayList arrayList = gVar.f8665t;
        int i10 = 0;
        while (i10 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                String str = "A connection to " + gVar.f8651d.f176a.h + " was leaked. Did you forget to close a response body?";
                kd.h.Companion.getClass();
                kd.h.platform.logCloseableLeak(str, ((d.b) reference).f11059a);
                arrayList.remove(i10);
                if (arrayList.isEmpty()) {
                    gVar.f8666u = j10 - this.f11064d;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    public final void b(a aVar) {
        String name = l.f3239c + " ConnectionPool connection opener";
        kotlin.jvm.internal.g.f(name, "name");
        throw null;
    }
}
