package u0;

/* loaded from: classes.dex */
public class h<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final a<K, V>[] f22770a;

    /* renamed from: b, reason: collision with root package name */
    private final int f22771b;

    protected static final class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final int f22772a;

        /* renamed from: b, reason: collision with root package name */
        public final K f22773b;

        /* renamed from: c, reason: collision with root package name */
        public V f22774c;

        /* renamed from: d, reason: collision with root package name */
        public final a<K, V> f22775d;

        public a(K k5, V v5, int i5, a<K, V> aVar) {
            this.f22773b = k5;
            this.f22774c = v5;
            this.f22775d = aVar;
            this.f22772a = i5;
        }
    }

    public h() {
        this(8192);
    }

    public Class a(String str) {
        int i5 = 0;
        while (true) {
            a<K, V>[] aVarArr = this.f22770a;
            if (i5 >= aVarArr.length) {
                return null;
            }
            a<K, V> aVar = aVarArr[i5];
            if (aVar != null) {
                for (a<K, V> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f22775d) {
                    K k5 = aVar.f22773b;
                    if (k5 instanceof Class) {
                        Class cls = (Class) k5;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i5++;
        }
    }

    public final V b(K k5) {
        for (a<K, V> aVar = this.f22770a[System.identityHashCode(k5) & this.f22771b]; aVar != null; aVar = aVar.f22775d) {
            if (k5 == aVar.f22773b) {
                return aVar.f22774c;
            }
        }
        return null;
    }

    public boolean c(K k5, V v5) {
        int iIdentityHashCode = System.identityHashCode(k5);
        int i5 = this.f22771b & iIdentityHashCode;
        for (a<K, V> aVar = this.f22770a[i5]; aVar != null; aVar = aVar.f22775d) {
            if (k5 == aVar.f22773b) {
                aVar.f22774c = v5;
                return true;
            }
        }
        this.f22770a[i5] = new a<>(k5, v5, iIdentityHashCode, this.f22770a[i5]);
        return false;
    }

    public h(int i5) {
        this.f22771b = i5 - 1;
        this.f22770a = new a[i5];
    }
}
