package O;

import O.d;
import W3.C0403n;
import i4.InterfaceC0772l;
import j4.k;
import j4.l;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    private final Map<d.a<?>, Object> f4276a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f4277b;

    /* renamed from: O.a$a, reason: collision with other inner class name */
    static final class C0067a extends l implements InterfaceC0772l<Map.Entry<d.a<?>, Object>, CharSequence> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0067a f4278a = new C0067a();

        C0067a() {
            super(1);
        }

        @Override // i4.InterfaceC0772l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Map.Entry<d.a<?>, Object> entry) {
            k.g(entry, "entry");
            return "  " + entry.getKey().a() + " = " + entry.getValue();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @Override // O.d
    public Map<d.a<?>, Object> a() {
        Map<d.a<?>, Object> mapUnmodifiableMap = Collections.unmodifiableMap(this.f4276a);
        k.f(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
        return mapUnmodifiableMap;
    }

    @Override // O.d
    public <T> T b(d.a<T> aVar) {
        k.g(aVar, "key");
        return (T) this.f4276a.get(aVar);
    }

    public final void e() {
        if (this.f4277b.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return k.b(this.f4276a, ((a) obj).f4276a);
        }
        return false;
    }

    public final void f() {
        this.f4277b.set(true);
    }

    public final void g(d.b<?>... bVarArr) {
        k.g(bVarArr, "pairs");
        e();
        for (d.b<?> bVar : bVarArr) {
            j(bVar.a(), bVar.b());
        }
    }

    public final <T> T h(d.a<T> aVar) {
        k.g(aVar, "key");
        e();
        return (T) this.f4276a.remove(aVar);
    }

    public int hashCode() {
        return this.f4276a.hashCode();
    }

    public final <T> void i(d.a<T> aVar, T t5) {
        k.g(aVar, "key");
        j(aVar, t5);
    }

    public final void j(d.a<?> aVar, Object obj) {
        k.g(aVar, "key");
        e();
        if (obj == null) {
            h(aVar);
            return;
        }
        if (!(obj instanceof Set)) {
            this.f4276a.put(aVar, obj);
            return;
        }
        Map<d.a<?>, Object> map = this.f4276a;
        Set setUnmodifiableSet = Collections.unmodifiableSet(C0403n.X((Iterable) obj));
        k.f(setUnmodifiableSet, "unmodifiableSet(value.toSet())");
        map.put(aVar, setUnmodifiableSet);
    }

    public String toString() {
        return C0403n.I(this.f4276a.entrySet(), ",\n", "{\n", "\n}", 0, null, C0067a.f4278a, 24, null);
    }

    public /* synthetic */ a(Map map, boolean z5, int i5, j4.g gVar) {
        this((i5 & 1) != 0 ? new LinkedHashMap() : map, (i5 & 2) != 0 ? true : z5);
    }

    public a(Map<d.a<?>, Object> map, boolean z5) {
        k.g(map, "preferencesMap");
        this.f4276a = map;
        this.f4277b = new AtomicBoolean(z5);
    }
}
