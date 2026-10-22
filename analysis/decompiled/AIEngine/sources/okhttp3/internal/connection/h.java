package okhttp3.internal.connection;

import mb.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface h {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final b f11085a;

        /* renamed from: b, reason: collision with root package name */
        public final b f11086b;

        /* renamed from: c, reason: collision with root package name */
        public final Throwable f11087c;

        public /* synthetic */ a(b bVar, ConnectPlan connectPlan, Throwable th, int i10) {
            this(bVar, (i10 & 2) != 0 ? null : connectPlan, (i10 & 4) != 0 ? null : th);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.g.b(this.f11085a, aVar.f11085a) && kotlin.jvm.internal.g.b(this.f11086b, aVar.f11086b) && kotlin.jvm.internal.g.b(this.f11087c, aVar.f11087c);
        }

        public final int hashCode() {
            int iHashCode = this.f11085a.hashCode() * 31;
            b bVar = this.f11086b;
            int iHashCode2 = (iHashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
            Throwable th = this.f11087c;
            return iHashCode2 + (th != null ? th.hashCode() : 0);
        }

        public final String toString() {
            return "ConnectResult(plan=" + this.f11085a + ", nextPlan=" + this.f11086b + ", throwable=" + this.f11087c + ')';
        }

        public a(b bVar, b bVar2, Throwable th) {
            this.f11085a = bVar;
            this.f11086b = bVar2;
            this.f11087c = th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        ed.g a();

        a c();

        void cancel();

        b e();

        a g();

        boolean isReady();
    }

    okhttp3.a a();

    k<b> b();

    b c();

    boolean d(okhttp3.g gVar);

    boolean e(ed.g gVar);

    boolean isCanceled();
}
