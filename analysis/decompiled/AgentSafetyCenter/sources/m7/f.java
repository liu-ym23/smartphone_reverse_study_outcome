package m7;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends g implements Iterable {

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f8264c = new ArrayList();

    @Override // m7.g
    public final g a() {
        ArrayList arrayList = this.f8264c;
        if (arrayList.isEmpty()) {
            return new f();
        }
        int size = arrayList.size();
        f fVar = new f();
        fVar.f8264c = new ArrayList(size);
        VarHandle.storeStoreFence();
        int size2 = arrayList.size();
        int i = 0;
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            fVar.k(((g) obj).a());
        }
        return fVar;
    }

    @Override // m7.g
    public final boolean b() {
        return m().b();
    }

    @Override // m7.g
    public final double c() {
        return m().c();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof f) && ((f) obj).f8264c.equals(this.f8264c);
        }
        return true;
    }

    @Override // m7.g
    public final long g() {
        return m().g();
    }

    @Override // m7.g
    public final Number h() {
        return m().h();
    }

    public final int hashCode() {
        return this.f8264c.hashCode();
    }

    @Override // m7.g
    public final String i() {
        return m().i();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f8264c.iterator();
    }

    public final void j(String str) {
        g gVar;
        ArrayList arrayList = this.f8264c;
        if (str == null) {
            gVar = i.f8265c;
        } else {
            l lVar = new l();
            lVar.f8267c = str;
            gVar = lVar;
        }
        arrayList.add(gVar);
    }

    public final void k(g gVar) {
        if (gVar == null) {
            gVar = i.f8265c;
        }
        this.f8264c.add(gVar);
    }

    public final g l(int i) {
        return (g) this.f8264c.get(i);
    }

    public final g m() {
        ArrayList arrayList = this.f8264c;
        int size = arrayList.size();
        if (size == 1) {
            return (g) arrayList.get(0);
        }
        od.f.e(k0.a.j(size, "Array must have size 1, but has size "));
        return null;
    }
}
