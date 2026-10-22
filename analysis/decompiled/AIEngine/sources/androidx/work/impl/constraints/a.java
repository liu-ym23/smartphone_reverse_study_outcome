package androidx.work.impl.constraints;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.work.impl.constraints.a$a, reason: collision with other inner class name */
    public static final class C0024a extends a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0024a f2928a = new C0024a();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        public final int f2929a;

        public b(int i10) {
            this.f2929a = i10;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.f2929a == ((b) obj).f2929a;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f2929a);
        }

        public final String toString() {
            return a0.a.l(new StringBuilder("ConstraintsNotMet(reason="), this.f2929a, ')');
        }
    }
}
