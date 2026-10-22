package l0;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final q7.m f5799a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5801c;

    /* renamed from: h, reason: collision with root package name */
    public c.m f5806h;

    /* renamed from: i, reason: collision with root package name */
    public s f5807i;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f5800b = new AtomicReference(null);

    /* renamed from: d, reason: collision with root package name */
    public final b0.r f5802d = new b0.r(5, this);

    /* renamed from: e, reason: collision with root package name */
    public final a5.a f5803e = new a5.a(12, this);

    /* renamed from: f, reason: collision with root package name */
    public final d0.e f5804f = new d0.e(new s[16]);

    /* renamed from: g, reason: collision with root package name */
    public final Object f5805g = new Object();

    /* renamed from: j, reason: collision with root package name */
    public long f5808j = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public t(p7.k kVar) {
        this.f5799a = (q7.m) kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a() {
        boolean z4;
        Set set;
        Set set2;
        synchronized (this.f5805g) {
            z4 = this.f5801c;
        }
        if (z4) {
            return false;
        }
        boolean z10 = false;
        while (true) {
            AtomicReference atomicReference = this.f5800b;
            while (true) {
                Object obj = atomicReference.get();
                set = null;
                List list = null;
                List listSubList = null;
                if (obj == null) {
                    break;
                }
                if (obj instanceof Set) {
                    set2 = (Set) obj;
                } else {
                    if (!(obj instanceof List)) {
                        b0.s.d("Unexpected notification");
                        throw new a4.u();
                    }
                    List list2 = (List) obj;
                    Set set3 = (Set) list2.get(0);
                    if (list2.size() == 2) {
                        listSubList = list2.get(1);
                    } else if (list2.size() > 2) {
                        listSubList = list2.subList(1, list2.size());
                    }
                    set2 = set3;
                    list = listSubList;
                }
                while (!atomicReference.compareAndSet(obj, list)) {
                    if (atomicReference.get() != obj) {
                        break;
                    }
                }
                set = set2;
                break;
            }
            if (set == null) {
                return z10;
            }
            synchronized (this.f5805g) {
                d0.e eVar = this.f5804f;
                Object[] objArr = eVar.f2749f;
                int i2 = eVar.f2751h;
                for (int i10 = 0; i10 < i2; i10++) {
                    z10 = ((s) objArr[i10]).b(set) || z10;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.Collection] */
    public final void b() {
        b0.r rVar = this.f5802d;
        m.f(m.f5772a);
        synchronized (m.f5774c) {
            m.f5779h = d7.r.d1(m.f5779h, rVar);
        }
        this.f5806h = new c.m(rVar);
    }
}
