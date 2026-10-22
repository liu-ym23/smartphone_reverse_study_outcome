package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u0;

/* loaded from: classes.dex */
public class K<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final a<K, V> f9945a;

    /* renamed from: b, reason: collision with root package name */
    private final K f9946b;

    /* renamed from: c, reason: collision with root package name */
    private final V f9947c;

    static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final u0.b f9948a;

        /* renamed from: b, reason: collision with root package name */
        public final K f9949b;

        /* renamed from: c, reason: collision with root package name */
        public final u0.b f9950c;

        /* renamed from: d, reason: collision with root package name */
        public final V f9951d;

        public a(u0.b bVar, K k5, u0.b bVar2, V v5) {
            this.f9948a = bVar;
            this.f9949b = k5;
            this.f9950c = bVar2;
            this.f9951d = v5;
        }
    }

    private K(u0.b bVar, K k5, u0.b bVar2, V v5) {
        this.f9945a = new a<>(bVar, k5, bVar2, v5);
        this.f9946b = k5;
        this.f9947c = v5;
    }

    static <K, V> int b(a<K, V> aVar, K k5, V v5) {
        return C0500u.d(aVar.f9948a, 1, k5) + C0500u.d(aVar.f9950c, 2, v5);
    }

    public static <K, V> K<K, V> d(u0.b bVar, K k5, u0.b bVar2, V v5) {
        return new K<>(bVar, k5, bVar2, v5);
    }

    static <K, V> void e(AbstractC0491k abstractC0491k, a<K, V> aVar, K k5, V v5) {
        C0500u.z(abstractC0491k, aVar.f9948a, 1, k5);
        C0500u.z(abstractC0491k, aVar.f9950c, 2, v5);
    }

    public int a(int i5, K k5, V v5) {
        return AbstractC0491k.V(i5) + AbstractC0491k.C(b(this.f9945a, k5, v5));
    }

    a<K, V> c() {
        return this.f9945a;
    }
}
