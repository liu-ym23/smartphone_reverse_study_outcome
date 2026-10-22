package j3;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: j3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4765c {

    /* renamed from: a, reason: collision with root package name */
    public final String f34515a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Object> f34516b;

    /* renamed from: j3.c$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f34517a;

        /* renamed from: b, reason: collision with root package name */
        public Map<Class<?>, Object> f34518b = null;

        public b(String str) {
            this.f34517a = str;
        }

        public C4765c a() {
            return new C4765c(this.f34517a, this.f34518b == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap(this.f34518b)));
        }

        public <T extends Annotation> b b(T t10) {
            if (this.f34518b == null) {
                this.f34518b = new HashMap();
            }
            this.f34518b.put(t10.annotationType(), t10);
            return this;
        }
    }

    public static b a(String str) {
        return new b(str);
    }

    public static C4765c d(String str) {
        return new C4765c(str, Collections.EMPTY_MAP);
    }

    public String b() {
        return this.f34515a;
    }

    public <T extends Annotation> T c(Class<T> cls) {
        return (T) this.f34516b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4765c)) {
            return false;
        }
        C4765c c4765c = (C4765c) obj;
        return this.f34515a.equals(c4765c.f34515a) && this.f34516b.equals(c4765c.f34516b);
    }

    public int hashCode() {
        return (this.f34515a.hashCode() * 31) + this.f34516b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f34515a + ", properties=" + this.f34516b.values() + "}";
    }

    public C4765c(String str, Map<Class<?>, Object> map) {
        this.f34515a = str;
        this.f34516b = map;
    }
}
