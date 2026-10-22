package C4;

import C4.v;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    final w f679a;

    /* renamed from: b, reason: collision with root package name */
    final String f680b;

    /* renamed from: c, reason: collision with root package name */
    final v f681c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    final E f682d;

    /* renamed from: e, reason: collision with root package name */
    final Map<Class<?>, Object> f683e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private volatile C0274d f684f;

    D(a aVar) {
        this.f679a = aVar.f685a;
        this.f680b = aVar.f686b;
        this.f681c = aVar.f687c.e();
        this.f682d = aVar.f688d;
        this.f683e = D4.e.v(aVar.f689e);
    }

    @Nullable
    public E a() {
        return this.f682d;
    }

    public C0274d b() {
        C0274d c0274d = this.f684f;
        if (c0274d != null) {
            return c0274d;
        }
        C0274d c0274dK = C0274d.k(this.f681c);
        this.f684f = c0274dK;
        return c0274dK;
    }

    @Nullable
    public String c(String str) {
        return this.f681c.c(str);
    }

    public v d() {
        return this.f681c;
    }

    public boolean e() {
        return this.f679a.n();
    }

    public String f() {
        return this.f680b;
    }

    public a g() {
        return new a(this);
    }

    @Nullable
    public <T> T h(Class<? extends T> cls) {
        return cls.cast(this.f683e.get(cls));
    }

    public w i() {
        return this.f679a;
    }

    public String toString() {
        return "Request{method=" + this.f680b + ", url=" + this.f679a + ", tags=" + this.f683e + '}';
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        w f685a;

        /* renamed from: b, reason: collision with root package name */
        String f686b;

        /* renamed from: c, reason: collision with root package name */
        v.a f687c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        E f688d;

        /* renamed from: e, reason: collision with root package name */
        Map<Class<?>, Object> f689e;

        public a() {
            this.f689e = Collections.EMPTY_MAP;
            this.f686b = "GET";
            this.f687c = new v.a();
        }

        public a a(String str, String str2) {
            this.f687c.a(str, str2);
            return this;
        }

        public D b() {
            if (this.f685a != null) {
                return new D(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a c(String str, String str2) {
            this.f687c.g(str, str2);
            return this;
        }

        public a d(v vVar) {
            this.f687c = vVar.f();
            return this;
        }

        public a e(String str, @Nullable E e6) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (e6 != null && !G4.f.a(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (e6 != null || !G4.f.d(str)) {
                this.f686b = str;
                this.f688d = e6;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a f(String str) {
            this.f687c.f(str);
            return this;
        }

        public <T> a g(Class<? super T> cls, @Nullable T t5) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t5 == null) {
                this.f689e.remove(cls);
                return this;
            }
            if (this.f689e.isEmpty()) {
                this.f689e = new LinkedHashMap();
            }
            this.f689e.put(cls, cls.cast(t5));
            return this;
        }

        public a h(w wVar) {
            if (wVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f685a = wVar;
            return this;
        }

        public a i(String str) {
            String str2;
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str2 = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str2 = "https:" + str.substring(4);
            } else {
                str2 = str;
            }
            return h(w.l(str2));
        }

        a(D d6) {
            Map<Class<?>, Object> map = Collections.EMPTY_MAP;
            this.f689e = map;
            this.f685a = d6.f679a;
            this.f686b = d6.f680b;
            this.f688d = d6.f682d;
            this.f689e = d6.f683e.isEmpty() ? map : new LinkedHashMap<>(d6.f683e);
            this.f687c = d6.f681c.f();
        }
    }
}
