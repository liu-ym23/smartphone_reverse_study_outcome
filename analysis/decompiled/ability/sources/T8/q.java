package T8;

/* loaded from: classes4.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1230a;
    public final Object b;
    public final Object c;
    public final F8.f d;
    public final String e;
    public final G8.b f;

    public q(Object obj, Object obj2, F8.f fVar, F8.f fVar2, String filePath, G8.b bVar) {
        kotlin.jvm.internal.k.f(filePath, "filePath");
        this.f1230a = obj;
        this.b = obj2;
        this.c = fVar;
        this.d = fVar2;
        this.e = filePath;
        this.f = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f1230a.equals(qVar.f1230a) && kotlin.jvm.internal.k.b(this.b, qVar.b) && kotlin.jvm.internal.k.b(this.c, qVar.c) && this.d.equals(qVar.d) && kotlin.jvm.internal.k.b(this.e, qVar.e) && this.f.equals(qVar.f);
    }

    public final int hashCode() {
        int iHashCode = this.f1230a.hashCode() * 31;
        Object obj = this.b;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.c;
        return this.f.hashCode() + B7.a.c((this.d.hashCode() + ((iHashCode2 + (obj2 != null ? obj2.hashCode() : 0)) * 31)) * 31, 31, this.e);
    }

    public final String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f1230a + ", compilerVersion=" + this.b + ", languageVersion=" + this.c + ", expectedVersion=" + this.d + ", filePath=" + this.e + ", classId=" + this.f + ')';
    }
}
