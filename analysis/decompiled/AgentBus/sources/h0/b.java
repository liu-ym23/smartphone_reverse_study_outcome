package h0;

import d7.k;
import fa.h;
import g0.c;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class b extends k implements e0.b {

    /* renamed from: i, reason: collision with root package name */
    public static final b f4061i;

    /* renamed from: f, reason: collision with root package name */
    public final Object f4062f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f4063g;

    /* renamed from: h, reason: collision with root package name */
    public final c f4064h;

    static {
        i0.b bVar = i0.b.f4394a;
        f4061i = new b(bVar, bVar, c.f3672h);
    }

    public b(Object obj, Object obj2, c cVar) {
        this.f4062f = obj;
        this.f4063g = obj2;
        this.f4064h = cVar;
    }

    @Override // d7.a
    public final int a() {
        c cVar = this.f4064h;
        cVar.getClass();
        return cVar.f3674g;
    }

    @Override // d7.a, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f4064h.containsKey(obj);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new h(this.f4062f, this.f4064h);
    }
}
