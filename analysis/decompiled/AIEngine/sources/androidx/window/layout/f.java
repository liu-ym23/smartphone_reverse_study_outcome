package androidx.window.layout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface f extends androidx.window.layout.a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f2730b = new a("VERTICAL");

        /* renamed from: c, reason: collision with root package name */
        public static final a f2731c = new a("HORIZONTAL");

        /* renamed from: a, reason: collision with root package name */
        public final String f2732a;

        public a(String str) {
            this.f2732a = str;
        }

        public final String toString() {
            return this.f2732a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final b f2733b = new b("FLAT");

        /* renamed from: c, reason: collision with root package name */
        public static final b f2734c = new b("HALF_OPENED");

        /* renamed from: a, reason: collision with root package name */
        public final String f2735a;

        public b(String str) {
            this.f2735a = str;
        }

        public final String toString() {
            return this.f2735a;
        }
    }

    boolean a();

    a b();
}
