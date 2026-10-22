package q;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class f extends l implements Map {

    /* renamed from: d, reason: collision with root package name */
    public C0817a f13948d;

    /* renamed from: e, reason: collision with root package name */
    public C0819c f13949e;

    /* renamed from: f, reason: collision with root package name */
    public C0821e f13950f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(f map) {
        super(0);
        if (map != null) {
            Intrinsics.checkNotNullParameter(map, "map");
            int i4 = map.f13970c;
            b(this.f13970c + i4);
            if (this.f13970c != 0) {
                for (int i5 = 0; i5 < i4; i5++) {
                    put(map.f(i5), map.i(i5));
                }
            } else if (i4 > 0) {
                ArraysKt___ArraysJvmKt.copyInto(map.f13968a, this.f13968a, 0, 0, i4);
                ArraysKt___ArraysJvmKt.copyInto(map.f13969b, this.f13969b, 0, 0, i4 << 1);
                this.f13970c = i4;
            }
        }
    }

    @Override // q.l, java.util.Map
    public final boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // q.l, java.util.Map
    public final boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        C0817a c0817a = this.f13948d;
        if (c0817a != null) {
            return c0817a;
        }
        C0817a c0817a2 = new C0817a(this, 0);
        this.f13948d = c0817a2;
        return c0817a2;
    }

    @Override // q.l, java.util.Map
    public final Object get(Object obj) {
        return super.get(obj);
    }

    public final boolean j(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(Collection collection) {
        int i4 = this.f13970c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i4 != this.f13970c;
    }

    @Override // java.util.Map
    public final Set keySet() {
        C0819c c0819c = this.f13949e;
        if (c0819c != null) {
            return c0819c;
        }
        C0819c c0819c2 = new C0819c(this);
        this.f13949e = c0819c2;
        return c0819c2;
    }

    public final boolean l(Collection collection) {
        int i4 = this.f13970c;
        for (int i5 = i4 - 1; i5 >= 0; i5--) {
            if (!collection.contains(f(i5))) {
                g(i5);
            }
        }
        return i4 != this.f13970c;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f13970c);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // q.l, java.util.Map
    public final Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // java.util.Map
    public final Collection values() {
        C0821e c0821e = this.f13950f;
        if (c0821e != null) {
            return c0821e;
        }
        C0821e c0821e2 = new C0821e(this);
        this.f13950f = c0821e2;
        return c0821e2;
    }
}
