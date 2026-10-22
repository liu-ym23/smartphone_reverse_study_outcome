package q8;

/* loaded from: classes4.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final String f5619a;
    public final G8.f b;
    public final String c;
    public final String d;
    public final String e;

    public y(String classInternalName, G8.f fVar, String str, String str2) {
        kotlin.jvm.internal.k.f(classInternalName, "classInternalName");
        this.f5619a = classInternalName;
        this.b = fVar;
        this.c = str;
        this.d = str2;
        String jvmDescriptor = fVar + '(' + str + ')' + str2;
        kotlin.jvm.internal.k.f(jvmDescriptor, "jvmDescriptor");
        this.e = classInternalName + '.' + jvmDescriptor;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return kotlin.jvm.internal.k.b(this.f5619a, yVar.f5619a) && kotlin.jvm.internal.k.b(this.b, yVar.b) && kotlin.jvm.internal.k.b(this.c, yVar.c) && kotlin.jvm.internal.k.b(this.d, yVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + B7.a.c((this.b.hashCode() + (this.f5619a.hashCode() * 31)) * 31, 31, this.c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NameAndSignature(classInternalName=");
        sb.append(this.f5619a);
        sb.append(", name=");
        sb.append(this.b);
        sb.append(", parameters=");
        sb.append(this.c);
        sb.append(", returnType=");
        return B7.a.g(')', this.d, sb);
    }
}
