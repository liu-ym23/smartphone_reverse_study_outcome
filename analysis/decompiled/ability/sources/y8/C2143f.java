package y8;

import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* renamed from: y8.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2143f {

    /* renamed from: a, reason: collision with root package name */
    public final NullabilityQualifier f6913a;
    public final boolean b;

    public C2143f(NullabilityQualifier nullabilityQualifier) {
        this.f6913a = nullabilityQualifier;
        this.b = false;
    }

    public static C2143f a(C2143f c2143f, NullabilityQualifier qualifier, boolean z10, int i) {
        if ((i & 1) != 0) {
            qualifier = c2143f.f6913a;
        }
        if ((i & 2) != 0) {
            z10 = c2143f.b;
        }
        c2143f.getClass();
        kotlin.jvm.internal.k.f(qualifier, "qualifier");
        return new C2143f(qualifier, z10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2143f)) {
            return false;
        }
        C2143f c2143f = (C2143f) obj;
        return this.f6913a == c2143f.f6913a && this.b == c2143f.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.f6913a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NullabilityQualifierWithMigrationStatus(qualifier=");
        sb.append(this.f6913a);
        sb.append(", isForWarningOnly=");
        return androidx.appfunctions.metadata.a.r(sb, this.b, ')');
    }

    public C2143f(NullabilityQualifier nullabilityQualifier, boolean z10) {
        this.f6913a = nullabilityQualifier;
        this.b = z10;
    }
}
