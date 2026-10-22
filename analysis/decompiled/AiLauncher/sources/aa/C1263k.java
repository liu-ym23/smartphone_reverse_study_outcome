package aa;

import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* renamed from: aa.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1263k {

    /* renamed from: a, reason: collision with root package name */
    public final NullabilityQualifier f8151a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8152b;

    public C1263k(NullabilityQualifier qualifier, boolean z10) {
        kotlin.jvm.internal.p.i(qualifier, "qualifier");
        this.f8151a = qualifier;
        this.f8152b = z10;
    }

    public static /* synthetic */ C1263k b(C1263k c1263k, NullabilityQualifier nullabilityQualifier, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            nullabilityQualifier = c1263k.f8151a;
        }
        if ((i10 & 2) != 0) {
            z10 = c1263k.f8152b;
        }
        return c1263k.a(nullabilityQualifier, z10);
    }

    public final C1263k a(NullabilityQualifier qualifier, boolean z10) {
        kotlin.jvm.internal.p.i(qualifier, "qualifier");
        return new C1263k(qualifier, z10);
    }

    public final NullabilityQualifier c() {
        return this.f8151a;
    }

    public final boolean d() {
        return this.f8152b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1263k)) {
            return false;
        }
        C1263k c1263k = (C1263k) obj;
        return this.f8151a == c1263k.f8151a && this.f8152b == c1263k.f8152b;
    }

    public int hashCode() {
        return (this.f8151a.hashCode() * 31) + Boolean.hashCode(this.f8152b);
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f8151a + ", isForWarningOnly=" + this.f8152b + ')';
    }

    public /* synthetic */ C1263k(NullabilityQualifier nullabilityQualifier, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(nullabilityQualifier, (i10 & 2) != 0 ? false : z10);
    }
}
