package S9;

import aa.C1263k;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* loaded from: classes5.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final C1263k f5767a;

    /* renamed from: b, reason: collision with root package name */
    public final Collection<AnnotationQualifierApplicabilityType> f5768b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5769c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5770d;

    /* JADX WARN: Multi-variable type inference failed */
    public t(C1263k nullabilityQualifier, Collection<? extends AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z10, boolean z11) {
        kotlin.jvm.internal.p.i(nullabilityQualifier, "nullabilityQualifier");
        kotlin.jvm.internal.p.i(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.f5767a = nullabilityQualifier;
        this.f5768b = qualifierApplicabilityTypes;
        this.f5769c = z10;
        this.f5770d = z11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ t b(t tVar, C1263k c1263k, Collection collection, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            c1263k = tVar.f5767a;
        }
        if ((i10 & 2) != 0) {
            collection = tVar.f5768b;
        }
        if ((i10 & 4) != 0) {
            z10 = tVar.f5769c;
        }
        if ((i10 & 8) != 0) {
            z11 = tVar.f5770d;
        }
        return tVar.a(c1263k, collection, z10, z11);
    }

    public final t a(C1263k nullabilityQualifier, Collection<? extends AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z10, boolean z11) {
        kotlin.jvm.internal.p.i(nullabilityQualifier, "nullabilityQualifier");
        kotlin.jvm.internal.p.i(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        return new t(nullabilityQualifier, qualifierApplicabilityTypes, z10, z11);
    }

    public final boolean c() {
        return this.f5769c;
    }

    public final C1263k d() {
        return this.f5767a;
    }

    public final Collection<AnnotationQualifierApplicabilityType> e() {
        return this.f5768b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return kotlin.jvm.internal.p.d(this.f5767a, tVar.f5767a) && kotlin.jvm.internal.p.d(this.f5768b, tVar.f5768b) && this.f5769c == tVar.f5769c && this.f5770d == tVar.f5770d;
    }

    public int hashCode() {
        return (((((this.f5767a.hashCode() * 31) + this.f5768b.hashCode()) * 31) + Boolean.hashCode(this.f5769c)) * 31) + Boolean.hashCode(this.f5770d);
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f5767a + ", qualifierApplicabilityTypes=" + this.f5768b + ", definitelyNotNull=" + this.f5769c + ", preferQualifierOverBound=" + this.f5770d + ')';
    }

    public /* synthetic */ t(C1263k c1263k, Collection collection, boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
        this(c1263k, collection, (i10 & 4) != 0 ? c1263k.c() == NullabilityQualifier.NOT_NULL : z10, (i10 & 8) != 0 ? false : z11);
    }
}
