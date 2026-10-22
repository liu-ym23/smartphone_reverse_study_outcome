package b7;

import android.content.Context;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface e {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f3072a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3073b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f3074c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f3075d;

        /* renamed from: e, reason: collision with root package name */
        public final String f3076e;

        public b(boolean z, boolean z3, boolean z10, boolean z11, String str) {
            this.f3072a = z;
            this.f3073b = z3;
            this.f3074c = z10;
            this.f3075d = z11;
            this.f3076e = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3072a == bVar.f3072a && this.f3073b == bVar.f3073b && this.f3074c == bVar.f3074c && this.f3075d == bVar.f3075d && kotlin.jvm.internal.g.b(this.f3076e, bVar.f3076e);
        }

        public final int hashCode() {
            int iF = ai.onnxruntime.a.f(ai.onnxruntime.a.f(ai.onnxruntime.a.f(Boolean.hashCode(this.f3072a) * 31, 31, this.f3073b), 31, this.f3074c), 31, this.f3075d);
            String str = this.f3076e;
            return iF + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("ValidationResult(isValid=");
            sb2.append(this.f3072a);
            sb2.append(", modelExists=");
            sb2.append(this.f3073b);
            sb2.append(", configExists=");
            sb2.append(this.f3074c);
            sb2.append(", checksumValid=");
            sb2.append(this.f3075d);
            sb2.append(", errorMessage=");
            return ai.onnxruntime.a.o(sb2, this.f3076e, ")");
        }
    }

    b7.a load(Context context, k kVar);
}
