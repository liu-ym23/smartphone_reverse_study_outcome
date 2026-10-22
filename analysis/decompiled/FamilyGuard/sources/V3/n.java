package V3;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class n<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5531a = new a(null);

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f5532a;

        public b(Throwable th) {
            j4.k.g(th, "exception");
            this.f5532a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && j4.k.b(this.f5532a, ((b) obj).f5532a);
        }

        public int hashCode() {
            return this.f5532a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f5532a + ')';
        }
    }

    public static <T> Object a(Object obj) {
        return obj;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f5532a;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }
}
