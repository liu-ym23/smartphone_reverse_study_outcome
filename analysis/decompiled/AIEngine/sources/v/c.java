package v;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.g;
import mb.h;
import u.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c<E> extends h<E> implements Collection, ac.b {

    /* renamed from: a, reason: collision with root package name */
    public b<E> f13241a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13242b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13243c;

    /* renamed from: d, reason: collision with root package name */
    public final f<E, a> f13244d;

    public c(b<E> bVar) {
        this.f13241a = bVar;
        this.f13242b = bVar.f13238a;
        this.f13243c = bVar.f13239b;
        u.d<E, a> dVar = bVar.f13240c;
        dVar.getClass();
        f<E, a> fVar = new f<>();
        fVar.f13111a = dVar;
        fVar.f13112b = new w.b();
        fVar.f13113c = dVar.f13106a;
        fVar.h = dVar.f13107b;
        this.f13244d = fVar;
    }

    public final b a() {
        u.d<E, a> dVarA = this.f13244d.a();
        b<E> bVar = this.f13241a;
        if (dVarA != bVar.f13240c) {
            bVar = new b<>(this.f13242b, this.f13243c, dVarA);
        }
        this.f13241a = bVar;
        return bVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(E e10) {
        f<E, a> fVar = this.f13244d;
        if (fVar.containsKey(e10)) {
            return false;
        }
        if (isEmpty()) {
            this.f13242b = e10;
            this.f13243c = e10;
            fVar.put(e10, new a());
            return true;
        }
        Object obj = fVar.get(this.f13243c);
        g.c(obj);
        fVar.put(this.f13243c, new a(((a) obj).f13235a, e10));
        fVar.put(e10, new a(this.f13243c));
        this.f13243c = e10;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f13244d.clear();
        w.b bVar = w.b.f13528a;
        this.f13242b = bVar;
        this.f13243c = bVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f13244d.containsKey(obj);
    }

    @Override // mb.h
    public final int getSize() {
        return this.f13244d.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        return new e(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        f<E, a> fVar = this.f13244d;
        a aVar = (a) fVar.remove(obj);
        if (aVar == null) {
            return false;
        }
        Object obj2 = aVar.f13236b;
        Object obj3 = aVar.f13235a;
        w.b bVar = w.b.f13528a;
        if (obj3 != bVar) {
            Object obj4 = fVar.get(obj3);
            g.c(obj4);
            fVar.put(obj3, new a(((a) obj4).f13235a, obj2));
        } else {
            this.f13242b = obj2;
        }
        if (obj2 == bVar) {
            this.f13243c = obj3;
            return true;
        }
        Object obj5 = fVar.get(obj2);
        g.c(obj5);
        fVar.put(obj2, new a(obj3, ((a) obj5).f13236b));
        return true;
    }
}
