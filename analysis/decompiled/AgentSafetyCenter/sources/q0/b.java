package q0;

import gc.j;
import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kb.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends h implements Set, Collection, zb.a {
    public static final b i;

    /* renamed from: f, reason: collision with root package name */
    public final Object f10069f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f10070g;

    /* renamed from: h, reason: collision with root package name */
    public final p0.b f10071h;

    static {
        r0.b bVar = r0.b.f10363a;
        i = new b(bVar, bVar, p0.b.f9657g);
    }

    public b(Object obj, Object obj2, p0.b bVar) {
        this.f10069f = obj;
        this.f10070g = obj2;
        this.f10071h = bVar;
    }

    @Override // jb.n
    public final int a() {
        return this.f10071h.f9659f;
    }

    @Override // jb.n, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f10071h.containsKey(obj);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        j jVar = new j(3);
        jVar.f4698g = this.f10069f;
        jVar.f4699h = this.f10071h;
        VarHandle.storeStoreFence();
        return jVar;
    }
}
