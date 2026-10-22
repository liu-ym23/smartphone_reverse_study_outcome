package R3;

import java.io.Serializable;

/* loaded from: classes.dex */
public enum g {
    COMPLETE;

    static final class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        final Throwable f4986a;

        a(Throwable th) {
            this.f4986a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return F3.b.c(this.f4986a, ((a) obj).f4986a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4986a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f4986a + "]";
        }
    }

    static final class b implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        final Q4.c f4987a;

        public String toString() {
            return "NotificationLite.Subscription[" + this.f4987a + "]";
        }
    }

    public static <T> boolean b(Object obj, Q4.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.a();
            return true;
        }
        if (obj instanceof a) {
            bVar.onError(((a) obj).f4986a);
            return true;
        }
        if (obj instanceof b) {
            bVar.e(((b) obj).f4987a);
            return false;
        }
        bVar.d(obj);
        return false;
    }

    public static Object d() {
        return COMPLETE;
    }

    public static Object e(Throwable th) {
        return new a(th);
    }

    public static Throwable g(Object obj) {
        return ((a) obj).f4986a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T h(Object obj) {
        return obj;
    }

    public static boolean i(Object obj) {
        return obj == COMPLETE;
    }

    public static <T> Object j(T t5) {
        return t5;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
