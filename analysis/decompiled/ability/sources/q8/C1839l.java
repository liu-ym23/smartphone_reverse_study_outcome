package q8;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import y8.C2143f;

/* renamed from: q8.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1839l {

    /* renamed from: a, reason: collision with root package name */
    public final C2143f f5603a;
    public final Collection b;
    public final boolean c;

    public C1839l(C2143f c2143f, Collection collection) {
        this(c2143f, collection, c2143f.f6913a == NullabilityQualifier.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1839l)) {
            return false;
        }
        C1839l c1839l = (C1839l) obj;
        return kotlin.jvm.internal.k.b(this.f5603a, c1839l.f5603a) && kotlin.jvm.internal.k.b(this.b, c1839l.b) && this.c == c1839l.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ((this.b.hashCode() + (this.f5603a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("JavaDefaultQualifiers(nullabilityQualifier=");
        sb.append(this.f5603a);
        sb.append(", qualifierApplicabilityTypes=");
        sb.append(this.b);
        sb.append(", definitelyNotNull=");
        return androidx.appfunctions.metadata.a.r(sb, this.c, ')');
    }

    public C1839l(C2143f c2143f, Collection qualifierApplicabilityTypes, boolean z10) {
        kotlin.jvm.internal.k.f(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.f5603a = c2143f;
        this.b = qualifierApplicabilityTypes;
        this.c = z10;
    }
}
