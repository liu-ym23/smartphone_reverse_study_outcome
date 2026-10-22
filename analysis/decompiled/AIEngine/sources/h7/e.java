package h7;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class e {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends e {

        /* renamed from: a, reason: collision with root package name */
        public final int f9368a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9369b;

        public a(String reason, int i10) {
            reason = (i10 & 2) != 0 ? "" : reason;
            g.f(reason, "reason");
            this.f9368a = 1;
            this.f9369b = reason;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9368a == aVar.f9368a && g.b(this.f9369b, aVar.f9369b);
        }

        public final int hashCode() {
            return this.f9369b.hashCode() + (Integer.hashCode(this.f9368a) * 31);
        }

        public final String toString() {
            return "CloudExecute(type=" + this.f9368a + ", reason=" + this.f9369b + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends e {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends e {

        /* renamed from: a, reason: collision with root package name */
        public final String f9370a;

        public c(String reason, int i10) {
            reason = (i10 & 2) != 0 ? "" : reason;
            g.f(reason, "reason");
            this.f9370a = reason;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && g.b(this.f9370a, ((c) obj).f9370a);
        }

        public final int hashCode() {
            return this.f9370a.hashCode() + (Integer.hashCode(0) * 31);
        }

        public final String toString() {
            return a0.a.k("LocalExecute(type=0, reason=", this.f9370a, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d extends e {

        /* renamed from: a, reason: collision with root package name */
        public final String f9371a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9372b;

        public d(String reason, int i10) {
            g.f(reason, "reason");
            this.f9371a = reason;
            this.f9372b = i10;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return g.b(this.f9371a, dVar.f9371a) && this.f9372b == dVar.f9372b;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f9372b) + (this.f9371a.hashCode() * 31);
        }

        public final String toString() {
            return ai.onnxruntime.a.i("Reject(reason=", this.f9372b, this.f9371a, ", errorCode=", ")");
        }
    }
}
