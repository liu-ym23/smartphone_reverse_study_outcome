package v;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.g;
import mb.i;
import u.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b<E> extends i<E> implements s.c<E> {

    /* renamed from: d, reason: collision with root package name */
    public static final b f13237d;

    /* renamed from: a, reason: collision with root package name */
    public final Object f13238a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13239b;

    /* renamed from: c, reason: collision with root package name */
    public final u.d<E, a> f13240c;

    static {
        w.b bVar = w.b.f13528a;
        f13237d = new b(bVar, bVar, u.d.f13105c);
    }

    public b(Object obj, Object obj2, u.d<E, a> dVar) {
        this.f13238a = obj;
        this.f13239b = obj2;
        this.f13240c = dVar;
    }

    @Override // mb.a
    public final int a() {
        u.d<E, a> dVar = this.f13240c;
        dVar.getClass();
        return dVar.f13107b;
    }

    @Override // java.util.Collection, java.util.Set, s.c
    public final b add(Object obj) {
        u.d<E, a> dVar = this.f13240c;
        if (dVar.containsKey(obj)) {
            return this;
        }
        if (isEmpty()) {
            return new b(obj, obj, dVar.a(obj, new a()));
        }
        Object obj2 = this.f13239b;
        a aVar = dVar.get(obj2);
        g.c(aVar);
        return new b(this.f13238a, obj, dVar.a(obj2, new a(aVar.f13235a, obj)).a(obj, new a(obj2)));
    }

    @Override // java.util.Collection, java.util.Set, s.c
    public final s.c<E> addAll(Collection<? extends E> collection) {
        c cVar = new c(this);
        cVar.addAll(collection);
        return cVar.a();
    }

    @Override // s.c
    public final c builder() {
        return new c(this);
    }

    @Override // mb.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f13240c.containsKey(obj);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        return new d(this.f13238a, this.f13240c);
    }

    @Override // java.util.Collection, java.util.Set, s.c
    public final b remove(Object obj) {
        u.d<E, a> dVarA = this.f13240c;
        a aVar = dVarA.get(obj);
        if (aVar == null) {
            return this;
        }
        Object obj2 = aVar.f13235a;
        Object obj3 = aVar.f13236b;
        r<E, a> rVar = dVarA.f13106a;
        r<E, a> rVarV = rVar.v(obj != null ? obj.hashCode() : 0, 0, obj);
        if (rVar != rVarV) {
            dVarA = rVarV == null ? u.d.f13105c : new u.d<>(rVarV, dVarA.f13107b - 1);
        }
        w.b bVar = w.b.f13528a;
        if (obj2 != bVar) {
            a aVar2 = dVarA.get(obj2);
            g.c(aVar2);
            dVarA = dVarA.a(obj2, new a(aVar2.f13235a, obj3));
        }
        if (obj3 != bVar) {
            a aVar3 = dVarA.get(obj3);
            g.c(aVar3);
            dVarA = dVarA.a(obj3, new a(obj2, aVar3.f13236b));
        }
        Object obj4 = obj2 != bVar ? this.f13238a : obj3;
        if (obj3 != bVar) {
            obj2 = this.f13239b;
        }
        return new b(obj4, obj2, dVarA);
    }

    @Override // java.util.Collection, java.util.Set, s.c
    public final s.c<E> removeAll(Collection<? extends E> collection) {
        c cVar = new c(this);
        cVar.removeAll(collection);
        return cVar.a();
    }
}
