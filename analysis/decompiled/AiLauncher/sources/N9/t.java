package N9;

import kotlin.reflect.jvm.internal.impl.km.KmVariance;

/* loaded from: classes5.dex */
public final class t {

    /* renamed from: c, reason: collision with root package name */
    public static final a f5015c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final t f5016d = new t(null, null);

    /* renamed from: a, reason: collision with root package name */
    public KmVariance f5017a;

    /* renamed from: b, reason: collision with root package name */
    public q f5018b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public t(KmVariance kmVariance, q qVar) {
        this.f5017a = kmVariance;
        this.f5018b = qVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f5017a == tVar.f5017a && kotlin.jvm.internal.p.d(this.f5018b, tVar.f5018b);
    }

    public int hashCode() {
        KmVariance kmVariance = this.f5017a;
        int iHashCode = (kmVariance == null ? 0 : kmVariance.hashCode()) * 31;
        q qVar = this.f5018b;
        return iHashCode + (qVar != null ? qVar.hashCode() : 0);
    }

    public String toString() {
        return "KmTypeProjection(variance=" + this.f5017a + ", type=" + this.f5018b + ')';
    }
}
