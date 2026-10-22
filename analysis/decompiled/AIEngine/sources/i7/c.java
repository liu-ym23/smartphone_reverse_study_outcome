package i7;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f9553a = new a();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public final int hashCode() {
            return 1035590447;
        }

        public final String toString() {
            return "EndOfTurn";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public final int f9554a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9555b;

        public b(int i10, String message) {
            g.f(message, "message");
            this.f9554a = i10;
            this.f9555b = message;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9554a == bVar.f9554a && g.b(this.f9555b, bVar.f9555b);
        }

        public final int hashCode() {
            return this.f9555b.hashCode() + (Integer.hashCode(this.f9554a) * 31);
        }

        public final String toString() {
            return "Failed(code=" + this.f9554a + ", message=" + this.f9555b + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: i7.c$c, reason: collision with other inner class name */
    public static final class C0091c implements c {

        /* renamed from: a, reason: collision with root package name */
        public final String f9556a;

        /* renamed from: b, reason: collision with root package name */
        public final long f9557b;

        /* renamed from: c, reason: collision with root package name */
        public final long f9558c;

        public C0091c(String text, long j10, long j11) {
            g.f(text, "text");
            this.f9556a = text;
            this.f9557b = j10;
            this.f9558c = j11;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0091c)) {
                return false;
            }
            C0091c c0091c = (C0091c) obj;
            return g.b(this.f9556a, c0091c.f9556a) && this.f9557b == c0091c.f9557b && this.f9558c == c0091c.f9558c;
        }

        public final int hashCode() {
            return Long.hashCode(this.f9558c) + a0.a.c(this.f9556a.hashCode() * 31, this.f9557b, 31);
        }

        public final String toString() {
            return a0.a.d(this.f9558c, ", endMs=", ")", com.stepos.core.ota.d.l("Final(text=", this.f9557b, this.f9556a, ", startMs="));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        public final int f9559a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9560b;

        /* renamed from: c, reason: collision with root package name */
        public final String f9561c;

        /* renamed from: d, reason: collision with root package name */
        public final long f9562d;

        /* renamed from: e, reason: collision with root package name */
        public final long f9563e;

        public d(String message, String segmentText, int i10, long j10, long j11) {
            g.f(message, "message");
            g.f(segmentText, "segmentText");
            this.f9559a = i10;
            this.f9560b = message;
            this.f9561c = segmentText;
            this.f9562d = j10;
            this.f9563e = j11;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f9559a == dVar.f9559a && g.b(this.f9560b, dVar.f9560b) && g.b(this.f9561c, dVar.f9561c) && this.f9562d == dVar.f9562d && this.f9563e == dVar.f9563e;
        }

        public final int hashCode() {
            return Long.hashCode(this.f9563e) + a0.a.c(v1.d.a(v1.d.a(Integer.hashCode(this.f9559a) * 31, 31, this.f9560b), 31, this.f9561c), this.f9562d, 31);
        }

        public final String toString() {
            StringBuilder sbE = h0.e.e("Notice(code=", this.f9559a, ", message=", this.f9560b, ", segmentText=");
            com.stepos.core.ota.d.p(this.f9562d, this.f9561c, ", startMs=", sbE);
            return a0.a.d(this.f9563e, ", endMs=", ")", sbE);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e implements c {

        /* renamed from: a, reason: collision with root package name */
        public final String f9564a;

        /* renamed from: b, reason: collision with root package name */
        public final long f9565b;

        /* renamed from: c, reason: collision with root package name */
        public final long f9566c;

        /* renamed from: d, reason: collision with root package name */
        public final String f9567d;

        /* renamed from: e, reason: collision with root package name */
        public final String f9568e;

        public e(String text, String rawText, String stash, long j10, long j11) {
            g.f(text, "text");
            g.f(rawText, "rawText");
            g.f(stash, "stash");
            this.f9564a = text;
            this.f9565b = j10;
            this.f9566c = j11;
            this.f9567d = rawText;
            this.f9568e = stash;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return g.b(this.f9564a, eVar.f9564a) && this.f9565b == eVar.f9565b && this.f9566c == eVar.f9566c && g.b(this.f9567d, eVar.f9567d) && g.b(this.f9568e, eVar.f9568e);
        }

        public final int hashCode() {
            return this.f9568e.hashCode() + v1.d.a(a0.a.c(a0.a.c(this.f9564a.hashCode() * 31, this.f9565b, 31), this.f9566c, 31), 31, this.f9567d);
        }

        public final String toString() {
            StringBuilder sbL = com.stepos.core.ota.d.l("Partial(text=", this.f9565b, this.f9564a, ", startMs=");
            a0.a.s(this.f9566c, ", endMs=", ", rawText=", sbL);
            return com.stepos.core.ota.d.j(sbL, this.f9567d, ", stash=", this.f9568e, ")");
        }
    }
}
