package L1;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class b<V> {

    /* renamed from: a, reason: collision with root package name */
    public final a<V>[] f4277a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4278b;

    public static final class a<V> {

        /* renamed from: a, reason: collision with root package name */
        public final int f4279a;

        /* renamed from: b, reason: collision with root package name */
        public final Type f4280b;

        /* renamed from: c, reason: collision with root package name */
        public V f4281c;

        /* renamed from: d, reason: collision with root package name */
        public final a<V> f4282d;

        public a(Type type, V v10, int i10, a<V> aVar) {
            this.f4280b = type;
            this.f4281c = v10;
            this.f4282d = aVar;
            this.f4279a = i10;
        }
    }

    public b(int i10) {
        this.f4278b = i10 - 1;
        this.f4277a = new a[i10];
    }

    public final V a(Type type) {
        for (a<V> aVar = this.f4277a[System.identityHashCode(type) & this.f4278b]; aVar != null; aVar = aVar.f4282d) {
            if (type == aVar.f4280b) {
                return aVar.f4281c;
            }
        }
        return null;
    }

    public boolean b(Type type, V v10) {
        int iIdentityHashCode = System.identityHashCode(type);
        int i10 = this.f4278b & iIdentityHashCode;
        for (a<V> aVar = this.f4277a[i10]; aVar != null; aVar = aVar.f4282d) {
            if (type == aVar.f4280b) {
                aVar.f4281c = v10;
                return true;
            }
        }
        this.f4277a[i10] = new a<>(type, v10, iIdentityHashCode, this.f4277a[i10]);
        return false;
    }
}
