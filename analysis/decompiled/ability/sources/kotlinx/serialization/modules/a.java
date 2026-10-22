package kotlinx.serialization.modules;

import B9.T;
import D7.v;
import E9.b;
import E9.c;
import E9.f;
import S7.k;
import Z7.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f5270a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public final HashMap e = new HashMap();
    public boolean f;

    @Override // E9.f
    public final void a(d kClass, k kVar) {
        kotlin.jvm.internal.k.f(kClass, "kClass");
        g(kClass, new b(kVar), false);
    }

    @Override // E9.f
    public final void b(d dVar, d dVar2, x9.b bVar) {
        f(dVar, dVar2, bVar, false);
    }

    public final E9.d c() {
        return new E9.d(this.f5270a, this.b, this.c, this.d, this.e, this.f);
    }

    public final void d(d dVar, k kVar, boolean z10) {
        HashMap map = this.e;
        k kVar2 = (k) map.get(dVar);
        if (kVar2 == null || kVar2.equals(kVar) || z10) {
            map.put(dVar, kVar);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + dVar + " is already registered: " + kVar2);
    }

    public final void e(d dVar, k kVar, boolean z10) {
        HashMap map = this.c;
        k kVar2 = (k) map.get(dVar);
        if (kVar2 == null || kVar2.equals(kVar) || z10) {
            map.put(dVar, kVar);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + dVar + " is already registered: " + kVar2);
    }

    public final void f(d dVar, d dVar2, x9.b bVar, boolean z10) {
        Object next;
        d dVar3;
        String strH = bVar.getDescriptor().h();
        HashMap map = this.b;
        Object map2 = map.get(dVar);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(dVar, map2);
        }
        Map map3 = (Map) map2;
        HashMap map4 = this.d;
        Object map5 = map4.get(dVar);
        if (map5 == null) {
            map5 = new HashMap();
            map4.put(dVar, map5);
        }
        Map map6 = (Map) map5;
        x9.b bVar2 = (x9.b) map3.get(dVar2);
        if (bVar2 != null && !bVar2.equals(bVar)) {
            if (!z10) {
                throw new SerializerAlreadyRegisteredException("Serializer for " + dVar2 + " already registered in the scope of " + dVar);
            }
        }
        x9.b bVar3 = (x9.b) map6.get(strH);
        if (bVar3 != null && !bVar3.equals(bVar)) {
            Iterator it = ((Iterable) v.s0(map3.entrySet()).b).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((Map.Entry) next).getValue() == bVar3) {
                        break;
                    }
                }
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry == null || (dVar3 = (d) entry.getKey()) == null) {
                throw new IllegalStateException(("Name " + strH + " is registered in the module but no Kotlin class is associated with it.").toString());
            }
            if (!z10) {
                throw new IllegalArgumentException("Multiple polymorphic serializers in a scope of '" + dVar + "' have the same serial name '" + strH + "': " + bVar + " for '" + dVar2 + "' and " + bVar3 + " for '" + dVar3 + '\'');
            }
        }
        map3.put(dVar2, bVar);
        map6.put(strH, bVar);
    }

    public final void g(d forClass, c cVar, boolean z10) {
        c cVar2;
        kotlin.jvm.internal.k.f(forClass, "forClass");
        HashMap map = this.f5270a;
        if (!z10 && (cVar2 = (c) map.get(forClass)) != null && !cVar2.equals(cVar)) {
            throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
        }
        map.put(forClass, cVar);
        if (T.f(forClass)) {
            this.f = true;
        }
    }

    @Override // E9.f
    public final void h(d dVar, k kVar) {
        e(dVar, kVar, false);
    }

    @Override // E9.f
    public final void i(d dVar, k kVar) {
        d(dVar, kVar, false);
    }

    @Override // E9.f
    public final void o(d kClass, x9.b serializer) {
        kotlin.jvm.internal.k.f(kClass, "kClass");
        kotlin.jvm.internal.k.f(serializer, "serializer");
        g(kClass, new E9.a(serializer), false);
    }
}
