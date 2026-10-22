package h2;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface m {

    /* renamed from: a, reason: collision with root package name */
    public static final a.c f9276a = new a.c();

    /* renamed from: b, reason: collision with root package name */
    public static final a.b f9277b = new a.b();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: h2.m$a$a, reason: collision with other inner class name */
        public static final class C0089a extends a {

            /* renamed from: a, reason: collision with root package name */
            public final Throwable f9278a;

            public C0089a(Throwable th) {
                this.f9278a = th;
            }

            public final String toString() {
                return "FAILURE (" + this.f9278a.getMessage() + ")";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class b extends a {
            public final String toString() {
                return "IN_PROGRESS";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class c extends a {
            public final String toString() {
                return "SUCCESS";
            }
        }
    }
}
