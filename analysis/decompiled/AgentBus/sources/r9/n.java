package r9;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9080a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9081b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f9082c;

    /* renamed from: d, reason: collision with root package name */
    public final d9.f f9083d;

    /* renamed from: e, reason: collision with root package name */
    public final String f9084e;

    /* renamed from: f, reason: collision with root package name */
    public final e9.b f9085f;

    public n(Object obj, Object obj2, d9.f fVar, d9.f fVar2, String str, e9.b bVar) {
        q7.k.e(str, "filePath");
        this.f9080a = obj;
        this.f9081b = obj2;
        this.f9082c = fVar;
        this.f9083d = fVar2;
        this.f9084e = str;
        this.f9085f = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f9080a.equals(nVar.f9080a) && q7.k.a(this.f9081b, nVar.f9081b) && q7.k.a(this.f9082c, nVar.f9082c) && this.f9083d.equals(nVar.f9083d) && q7.k.a(this.f9084e, nVar.f9084e) && this.f9085f.equals(nVar.f9085f);
    }

    public final int hashCode() {
        int iHashCode = this.f9080a.hashCode() * 31;
        Object obj = this.f9081b;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.f9082c;
        return this.f9085f.hashCode() + m.x.g(this.f9084e, (this.f9083d.hashCode() + ((iHashCode2 + (obj2 != null ? obj2.hashCode() : 0)) * 31)) * 31, 31);
    }

    public final String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f9080a + ", compilerVersion=" + this.f9081b + ", languageVersion=" + this.f9082c + ", expectedVersion=" + this.f9083d + ", filePath=" + this.f9084e + ", classId=" + this.f9085f + ')';
    }
}
