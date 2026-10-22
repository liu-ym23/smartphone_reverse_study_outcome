package D0;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class i implements D0.b {

    /* renamed from: a, reason: collision with root package name */
    private final g<a, Object> f1011a = new g<>();

    /* renamed from: b, reason: collision with root package name */
    private final b f1012b = new b();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f1013c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, D0.a<?>> f1014d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final int f1015e;

    /* renamed from: f, reason: collision with root package name */
    private int f1016f;

    private static final class a implements l {

        /* renamed from: a, reason: collision with root package name */
        private final b f1017a;

        /* renamed from: b, reason: collision with root package name */
        int f1018b;

        /* renamed from: c, reason: collision with root package name */
        private Class<?> f1019c;

        a(b bVar) {
            this.f1017a = bVar;
        }

        @Override // D0.l
        public void a() {
            this.f1017a.c(this);
        }

        void b(int i5, Class<?> cls) {
            this.f1018b = i5;
            this.f1019c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f1018b == aVar.f1018b && this.f1019c == aVar.f1019c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i5 = this.f1018b * 31;
            Class<?> cls = this.f1019c;
            return i5 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f1018b + "array=" + this.f1019c + '}';
        }
    }

    private static final class b extends c<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // D0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a e(int i5, Class<?> cls) {
            a aVarB = b();
            aVarB.b(i5, cls);
            return aVarB;
        }
    }

    public i(int i5) {
        this.f1015e = i5;
    }

    private void e(int i5, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapL = l(cls);
        Integer num = navigableMapL.get(Integer.valueOf(i5));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapL.remove(Integer.valueOf(i5));
                return;
            } else {
                navigableMapL.put(Integer.valueOf(i5), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i5 + ", this: " + this);
    }

    private void f() {
        g(this.f1015e);
    }

    private void g(int i5) {
        while (this.f1016f > i5) {
            Object objF = this.f1011a.f();
            X0.j.d(objF);
            D0.a aVarH = h(objF);
            this.f1016f -= aVarH.c(objF) * aVarH.b();
            e(aVarH.c(objF), objF.getClass());
            if (Log.isLoggable(aVarH.a(), 2)) {
                Log.v(aVarH.a(), "evicted: " + aVarH.c(objF));
            }
        }
    }

    private <T> D0.a<T> h(T t5) {
        return i(t5.getClass());
    }

    private <T> D0.a<T> i(Class<T> cls) {
        D0.a<T> fVar;
        D0.a<T> aVar = (D0.a) this.f1014d.get(cls);
        if (aVar != null) {
            return aVar;
        }
        if (cls.equals(int[].class)) {
            fVar = new h();
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            fVar = new f();
        }
        this.f1014d.put(cls, fVar);
        return fVar;
    }

    private <T> T j(a aVar) {
        return (T) this.f1011a.a(aVar);
    }

    private <T> T k(a aVar, Class<T> cls) {
        D0.a<T> aVarI = i(cls);
        T t5 = (T) j(aVar);
        if (t5 != null) {
            this.f1016f -= aVarI.c(t5) * aVarI.b();
            e(aVarI.c(t5), cls);
        }
        if (t5 != null) {
            return t5;
        }
        if (Log.isLoggable(aVarI.a(), 2)) {
            Log.v(aVarI.a(), "Allocated " + aVar.f1018b + " bytes");
        }
        return aVarI.newArray(aVar.f1018b);
    }

    private NavigableMap<Integer, Integer> l(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f1013c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f1013c.put(cls, treeMap);
        return treeMap;
    }

    private boolean m() {
        int i5 = this.f1016f;
        return i5 == 0 || this.f1015e / i5 >= 2;
    }

    private boolean n(int i5) {
        return i5 <= this.f1015e / 2;
    }

    private boolean o(int i5, Integer num) {
        if (num != null) {
            return m() || num.intValue() <= i5 * 8;
        }
        return false;
    }

    @Override // D0.b
    public synchronized void a(int i5) {
        try {
            if (i5 >= 40) {
                b();
            } else if (i5 >= 20 || i5 == 15) {
                g(this.f1015e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // D0.b
    public synchronized void b() {
        g(0);
    }

    @Override // D0.b
    public synchronized <T> T c(int i5, Class<T> cls) {
        return (T) k(this.f1012b.e(i5, cls), cls);
    }

    @Override // D0.b
    public synchronized <T> T d(int i5, Class<T> cls) {
        Integer numCeilingKey;
        try {
            numCeilingKey = l(cls).ceilingKey(Integer.valueOf(i5));
        } catch (Throwable th) {
            throw th;
        }
        return (T) k(o(i5, numCeilingKey) ? this.f1012b.e(numCeilingKey.intValue(), cls) : this.f1012b.e(i5, cls), cls);
    }

    @Override // D0.b
    public synchronized <T> void put(T t5) {
        Class<?> cls = t5.getClass();
        D0.a<T> aVarI = i(cls);
        int iC = aVarI.c(t5);
        int iB = aVarI.b() * iC;
        if (n(iB)) {
            a aVarE = this.f1012b.e(iC, cls);
            this.f1011a.d(aVarE, t5);
            NavigableMap<Integer, Integer> navigableMapL = l(cls);
            Integer num = navigableMapL.get(Integer.valueOf(aVarE.f1018b));
            Integer numValueOf = Integer.valueOf(aVarE.f1018b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapL.put(numValueOf, Integer.valueOf(iIntValue));
            this.f1016f += iB;
            f();
        }
    }
}
