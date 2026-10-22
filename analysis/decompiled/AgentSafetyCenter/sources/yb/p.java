package yb;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class p extends c implements fc.c {

    /* renamed from: k, reason: collision with root package name */
    public final boolean f16093k;

    public p(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.f16093k = false;
    }

    public final fc.a e() {
        if (this.f16093k) {
            return this;
        }
        fc.a aVar = this.f16082c;
        if (aVar != null) {
            return aVar;
        }
        fc.a aVarA = a();
        this.f16082c = aVarA;
        return aVarA;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return d().equals(pVar.d()) && this.f16085h.equals(pVar.f16085h) && this.i.equals(pVar.i) && k.a(this.f16083f, pVar.f16083f);
        }
        if (obj instanceof fc.c) {
            return obj.equals(e());
        }
        return false;
    }

    public final int hashCode() {
        return this.i.hashCode() + androidx.activity.b.d(d().hashCode() * 31, 31, this.f16085h);
    }

    public final String toString() {
        fc.a aVarE = e();
        return aVarE != this ? aVarE.toString() : androidx.activity.b.n(new StringBuilder("property "), this.f16085h, " (Kotlin reflection is not available)");
    }
}
