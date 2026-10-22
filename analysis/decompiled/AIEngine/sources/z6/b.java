package z6;

import com.stepos.base.lease.LeaseState;
import h0.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import mb.m;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, z6.a> f14267a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, AtomicInteger> f14268b = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f14269a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14270b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14271c;

        /* renamed from: d, reason: collision with root package name */
        public final String f14272d;

        /* renamed from: e, reason: collision with root package name */
        public final LeaseState f14273e;

        /* renamed from: f, reason: collision with root package name */
        public final long f14274f;

        public a(String leaseId, int i10, int i11, String modelId, LeaseState state, long j10) {
            g.f(leaseId, "leaseId");
            g.f(modelId, "modelId");
            g.f(state, "state");
            this.f14269a = leaseId;
            this.f14270b = i10;
            this.f14271c = i11;
            this.f14272d = modelId;
            this.f14273e = state;
            this.f14274f = j10;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return g.b(this.f14269a, aVar.f14269a) && this.f14270b == aVar.f14270b && this.f14271c == aVar.f14271c && g.b(this.f14272d, aVar.f14272d) && this.f14273e == aVar.f14273e && this.f14274f == aVar.f14274f;
        }

        public final int hashCode() {
            return Long.hashCode(this.f14274f) + ((this.f14273e.hashCode() + d.a(ai.onnxruntime.a.d(this.f14271c, ai.onnxruntime.a.d(this.f14270b, this.f14269a.hashCode() * 31, 31), 31), 31, this.f14272d)) * 31);
        }

        public final String toString() {
            StringBuilder sbF = e.f("LeaseInfo(leaseId=", this.f14269a, ", uid=", this.f14270b, ", userId=");
            e.h(this.f14271c, ", modelId=", this.f14272d, ", state=", sbF);
            sbF.append(this.f14273e);
            sbF.append(", createdAtMonoNs=");
            sbF.append(this.f14274f);
            sbF.append(")");
            return sbF.toString();
        }
    }

    public static void a(int i10, int i11) {
        AtomicInteger atomicInteger;
        ConcurrentHashMap<String, z6.a> concurrentHashMap = f14267a;
        Collection<z6.a> collectionValues = concurrentHashMap.values();
        g.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            z6.a aVar = (z6.a) obj;
            if (aVar.q() == i10 && aVar.l0() == i11) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        int i12 = 0;
        int i13 = 0;
        while (i13 < size) {
            Object obj2 = arrayList.get(i13);
            i13++;
            try {
                ((z6.a) obj2).close();
                n nVar = n.f10413a;
            } catch (Throwable th) {
                c.a(th);
            }
        }
        int size2 = arrayList.size();
        while (i12 < size2) {
            Object obj3 = arrayList.get(i12);
            i12++;
            z6.a aVar2 = (z6.a) obj3;
            if (concurrentHashMap.remove(aVar2.u0()) != null && (atomicInteger = f14268b.get(aVar2.getModelId())) != null) {
                atomicInteger.decrementAndGet();
            }
        }
    }

    public static ArrayList b() {
        Collection<z6.a> collectionValues = f14267a.values();
        g.e(collectionValues, "<get-values>(...)");
        Collection<z6.a> collection = collectionValues;
        ArrayList arrayList = new ArrayList(m.Z(collection, 10));
        for (z6.a aVar : collection) {
            arrayList.add(new a(aVar.u0(), aVar.q(), aVar.l0(), aVar.getModelId(), aVar.getState(), aVar.J()));
        }
        return arrayList;
    }
}
