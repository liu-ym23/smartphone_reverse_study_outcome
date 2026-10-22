package z0;

import java.security.MessageDigest;

/* renamed from: z0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1341g<T> {

    /* renamed from: e, reason: collision with root package name */
    private static final b<Object> f24046e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final T f24047a;

    /* renamed from: b, reason: collision with root package name */
    private final b<T> f24048b;

    /* renamed from: c, reason: collision with root package name */
    private final String f24049c;

    /* renamed from: d, reason: collision with root package name */
    private volatile byte[] f24050d;

    /* renamed from: z0.g$a */
    class a implements b<Object> {
        a() {
        }

        @Override // z0.C1341g.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* renamed from: z0.g$b */
    public interface b<T> {
        void a(byte[] bArr, T t5, MessageDigest messageDigest);
    }

    private C1341g(String str, T t5, b<T> bVar) {
        this.f24049c = X0.j.b(str);
        this.f24047a = t5;
        this.f24048b = (b) X0.j.d(bVar);
    }

    public static <T> C1341g<T> a(String str, T t5, b<T> bVar) {
        return new C1341g<>(str, t5, bVar);
    }

    private static <T> b<T> b() {
        return (b<T>) f24046e;
    }

    private byte[] d() {
        if (this.f24050d == null) {
            this.f24050d = this.f24049c.getBytes(InterfaceC1340f.f24045a);
        }
        return this.f24050d;
    }

    public static <T> C1341g<T> e(String str) {
        return new C1341g<>(str, null, b());
    }

    public static <T> C1341g<T> f(String str, T t5) {
        return new C1341g<>(str, t5, b());
    }

    public T c() {
        return this.f24047a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1341g) {
            return this.f24049c.equals(((C1341g) obj).f24049c);
        }
        return false;
    }

    public void g(T t5, MessageDigest messageDigest) {
        this.f24048b.a(d(), t5, messageDigest);
    }

    public int hashCode() {
        return this.f24049c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f24049c + "'}";
    }
}
