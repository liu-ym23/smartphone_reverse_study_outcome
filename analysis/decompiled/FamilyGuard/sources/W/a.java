package W;

import j4.k;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<b<?>, Object> f5712a = new LinkedHashMap();

    /* renamed from: W.a$a, reason: collision with other inner class name */
    public static final class C0085a extends a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0085a f5713b = new C0085a();

        private C0085a() {
        }

        @Override // W.a
        public <T> T a(b<T> bVar) {
            k.g(bVar, "key");
            return null;
        }
    }

    public interface b<T> {
    }

    public abstract <T> T a(b<T> bVar);

    public final Map<b<?>, Object> b() {
        return this.f5712a;
    }
}
