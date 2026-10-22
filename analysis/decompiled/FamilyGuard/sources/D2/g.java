package D2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
abstract class g<K, V> implements r<K, V>, u<K, V> {

    /* renamed from: b, reason: collision with root package name */
    private i<K, V> f1180b;

    /* renamed from: c, reason: collision with root package name */
    private t<V> f1181c;

    /* renamed from: a, reason: collision with root package name */
    private final Map<z<V>, A<K, V>> f1179a = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private boolean f1182d = false;

    public g(i<K, V> iVar) {
        h(iVar);
    }

    @Override // D2.r
    public void a() {
        this.f1182d = false;
        e();
    }

    @Override // D2.r
    public void b() {
        this.f1182d = false;
        for (A<K, V> a6 : this.f1179a.values()) {
            if (a6 != null) {
                a6.b();
            }
        }
    }

    @Override // D2.r
    public void c() {
        this.f1182d = true;
        for (A<K, V> a6 : this.f1179a.values()) {
            if (a6 != null) {
                a6.c();
            }
        }
    }

    @Override // D2.r
    public void d(v<K> vVar, z<V> zVar) {
        V v5;
        if (vVar == null || vVar.get() == null || zVar == null) {
            return;
        }
        i<K, V> iVar = this.f1180b;
        if (iVar != null && (v5 = iVar.get(vVar.get())) != null) {
            t<V> tVar = this.f1181c;
            if (tVar == null) {
                zVar.a(v5);
                return;
            } else {
                if (tVar.d(true, v5, zVar)) {
                    return;
                }
                zVar.a(v5);
                return;
            }
        }
        zVar.b();
        A<K, V> a6 = this.f1179a.get(zVar);
        if (a6 != null) {
            v<K> vVarD = a6.d();
            if (vVarD == vVar) {
                return;
            }
            if (vVarD != null && vVarD.get().equals(vVar.get())) {
                return;
            } else {
                a6.cancel();
            }
        }
        A<K, V> aI = i();
        aI.a(this, vVar, zVar, this);
        if (this.f1182d) {
            aI.c();
        }
        this.f1179a.put(zVar, aI);
    }

    @Override // D2.r
    public void e() {
        for (A<K, V> a6 : this.f1179a.values()) {
            if (a6 != null) {
                a6.cancel();
            }
        }
        this.f1179a.clear();
    }

    @Override // D2.r
    public void f(t<V> tVar) {
        this.f1181c = tVar;
    }

    public void g(A<K, V> a6, boolean z5, v<K> vVar, z<V> zVar, V v5) {
        if (this.f1180b != null && vVar != null && vVar.get() != null && v5 != null) {
            this.f1180b.put(vVar.get(), v5);
        }
        this.f1179a.remove(zVar);
        t<V> tVar = this.f1181c;
        if (tVar == null) {
            zVar.a(v5);
        } else {
            if (tVar.d(true, v5, zVar)) {
                return;
            }
            zVar.a(v5);
        }
    }

    protected final void h(i<K, V> iVar) {
        j(iVar);
    }

    protected abstract A<K, V> i();

    public final void j(i<K, V> iVar) {
        this.f1180b = iVar;
    }
}
