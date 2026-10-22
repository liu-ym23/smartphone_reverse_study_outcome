package N9;

/* loaded from: classes5.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public static final a f4957c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public q f4958a;

    /* renamed from: b, reason: collision with root package name */
    public String f4959b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public m(q type, String str) {
        kotlin.jvm.internal.p.i(type, "type");
        this.f4958a = type;
        this.f4959b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return kotlin.jvm.internal.p.d(this.f4958a, mVar.f4958a) && kotlin.jvm.internal.p.d(this.f4959b, mVar.f4959b);
    }

    public int hashCode() {
        int iHashCode = this.f4958a.hashCode() * 31;
        String str = this.f4959b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "KmFlexibleTypeUpperBound(type=" + this.f4958a + ", typeFlexibilityId=" + this.f4959b + ')';
    }
}
