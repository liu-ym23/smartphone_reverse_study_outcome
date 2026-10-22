package k0;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends v {

    /* renamed from: a, reason: collision with root package name */
    public long f6997a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6998b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6999c;

    /* renamed from: d, reason: collision with root package name */
    public HashSet f7000d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedHashSet f7001e;

    /* renamed from: f, reason: collision with root package name */
    public k1 f7002f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ s f7003g;

    @Override // k0.v
    public final void a(y yVar, xb.p pVar) {
        this.f7003g.f7034b.a(yVar, pVar);
    }

    @Override // k0.v
    public final void b() {
        s sVar = this.f7003g;
        sVar.A--;
    }

    @Override // k0.v
    public final boolean c() {
        return this.f7003g.f7034b.c();
    }

    @Override // k0.v
    public final boolean d() {
        return this.f6998b;
    }

    @Override // k0.v
    public final boolean e() {
        return this.f6999c;
    }

    @Override // k0.v
    public final long f() {
        return this.f6997a;
    }

    @Override // k0.v
    public final u g() {
        return this.f7003g.f7040h;
    }

    @Override // k0.v
    public final s0.g h() {
        return (s0.g) this.f7002f.getValue();
    }

    @Override // k0.v
    public final nb.g i() {
        return this.f7003g.f7034b.i();
    }

    @Override // k0.v
    public final void j(y yVar) {
        s sVar = this.f7003g;
        sVar.f7034b.j(sVar.f7040h);
        sVar.f7034b.j(yVar);
    }

    @Override // k0.v
    public final a1 k(b1 b1Var) {
        return this.f7003g.f7034b.k(b1Var);
    }

    @Override // k0.v
    public final void l(Set set) {
        HashSet hashSet = this.f7000d;
        if (hashSet == null) {
            hashSet = new HashSet();
            this.f7000d = hashSet;
        }
        hashSet.add(set);
    }

    @Override // k0.v
    public final void m(s sVar) {
        this.f7001e.add(sVar);
    }

    @Override // k0.v
    public final void n(y yVar) {
        this.f7003g.f7034b.n(yVar);
    }

    @Override // k0.v
    public final void o() {
        this.f7003g.A++;
    }

    @Override // k0.v
    public final void p(s sVar) {
        HashSet hashSet = this.f7000d;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Set set = (Set) it.next();
                sVar.getClass();
                set.remove(sVar.f7035c);
            }
        }
        LinkedHashSet linkedHashSet = this.f7001e;
        yb.x.a(linkedHashSet);
        linkedHashSet.remove(sVar);
    }

    @Override // k0.v
    public final void q(y yVar) {
        this.f7003g.f7034b.q(yVar);
    }

    public final void r() {
        LinkedHashSet<s> linkedHashSet = this.f7001e;
        if (linkedHashSet.isEmpty()) {
            return;
        }
        HashSet hashSet = this.f7000d;
        if (hashSet != null) {
            for (s sVar : linkedHashSet) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((Set) it.next()).remove(sVar.f7035c);
                }
            }
        }
        linkedHashSet.clear();
    }
}
