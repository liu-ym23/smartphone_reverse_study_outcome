package O;

import W3.E;
import com.stepos.minor.Minor;
import j4.k;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d {

    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f4285a;

        public a(String str) {
            k.g(str, Minor.COLUMN_NAME);
            this.f4285a = str;
        }

        public final String a() {
            return this.f4285a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return k.b(this.f4285a, ((a) obj).f4285a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4285a.hashCode();
        }

        public String toString() {
            return this.f4285a;
        }
    }

    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final a<T> f4286a;

        /* renamed from: b, reason: collision with root package name */
        private final T f4287b;

        public final a<T> a() {
            return this.f4286a;
        }

        public final T b() {
            return this.f4287b;
        }
    }

    public abstract Map<a<?>, Object> a();

    public abstract <T> T b(a<T> aVar);

    public final O.a c() {
        return new O.a(E.j(a()), false);
    }

    public final d d() {
        return new O.a(E.j(a()), true);
    }
}
