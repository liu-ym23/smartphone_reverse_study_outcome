package s0;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import k0.s1;
import k0.u2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends AbstractMap implements Map, zb.c {

    /* renamed from: c, reason: collision with root package name */
    public r0.b f11176c = new r0.b();

    /* renamed from: f, reason: collision with root package name */
    public p0.j f11177f;

    /* renamed from: g, reason: collision with root package name */
    public Object f11178g;

    /* renamed from: h, reason: collision with root package name */
    public int f11179h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public g f11180j;

    public f(g gVar) {
        this.f11177f = gVar.f9658c;
        this.i = gVar.f9659f;
        this.f11180j = gVar;
    }

    public final g a() {
        p0.j jVar = this.f11177f;
        g gVar = this.f11180j;
        if (jVar != gVar.f9658c) {
            this.f11176c = new r0.b();
            gVar = new g(this.f11177f, this.i);
        }
        this.f11180j = gVar;
        return gVar;
    }

    public final boolean b(Object obj) {
        return this.f11177f.d(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    public final Object c(Object obj) {
        return this.f11177f.g(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f11177f = p0.j.f9671e;
        e(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof s1) {
            return b((s1) obj);
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof u2) {
            return super.containsValue((u2) obj);
        }
        return false;
    }

    public final Object d(Object obj) {
        this.f11178g = null;
        p0.j jVarN = this.f11177f.n(obj != null ? obj.hashCode() : 0, obj, 0, this);
        if (jVarN == null) {
            jVarN = p0.j.f9671e;
        }
        this.f11177f = jVarN;
        return this.f11178g;
    }

    public final void e(int i) {
        this.i = i;
        this.f11179h++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return new p0.e(0, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof s1) {
            return (u2) c((s1) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof s1) ? obj2 : (u2) super.getOrDefault((s1) obj, (u2) obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return new p0.e(1, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.f11178g = null;
        this.f11177f = this.f11177f.l(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        return this.f11178g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [p0.b] */
    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        g gVarA = null;
        g gVar = map instanceof p0.b ? (p0.b) map : null;
        if (gVar == null) {
            f fVar = map instanceof f ? (f) map : null;
            if (fVar != null) {
                gVarA = fVar.a();
            }
        } else {
            gVarA = gVar;
        }
        if (gVarA == null) {
            super.putAll(map);
            return;
        }
        r0.a aVar = new r0.a();
        aVar.f10362a = 0;
        int i = this.i;
        p0.j jVar = this.f11177f;
        p0.j jVar2 = gVarA.f9658c;
        jVar2.getClass();
        this.f11177f = jVar.m(jVar2, 0, aVar, this);
        int i3 = (gVarA.f9659f + i) - aVar.f10362a;
        if (i != i3) {
            e(i3);
        }
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int i = this.i;
        p0.j jVarO = this.f11177f.o(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (jVarO == null) {
            jVarO = p0.j.f9671e;
        }
        this.f11177f = jVarO;
        return i != this.i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        return new lb.h(this, 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof s1) {
            return (u2) d((s1) obj);
        }
        return null;
    }
}
