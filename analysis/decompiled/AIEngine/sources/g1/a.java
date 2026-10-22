package g1;

import java.util.Map;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: g1.a$a, reason: collision with other inner class name */
    public static final class C0083a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f8947a;

        public C0083a(String name) {
            g.f(name, "name");
            this.f8947a = name;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C0083a)) {
                return false;
            }
            return g.b(this.f8947a, ((C0083a) obj).f8947a);
        }

        public final int hashCode() {
            return this.f8947a.hashCode();
        }

        public final String toString() {
            return this.f8947a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b<T> {
    }

    public abstract Map<C0083a<?>, Object> a();

    public abstract <T> T b(C0083a<T> c0083a);
}
