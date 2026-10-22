package y8;

import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* renamed from: y8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2141d {
    public static final C2141d e = new C2141d(null, false);

    /* renamed from: a, reason: collision with root package name */
    public final NullabilityQualifier f6912a;
    public final MutabilityQualifier b;
    public final boolean c;
    public final boolean d;

    public C2141d(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z10, boolean z11) {
        this.f6912a = nullabilityQualifier;
        this.b = mutabilityQualifier;
        this.c = z10;
        this.d = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2141d)) {
            return false;
        }
        C2141d c2141d = (C2141d) obj;
        return this.f6912a == c2141d.f6912a && this.b == c2141d.b && this.c == c2141d.c && this.d == c2141d.d;
    }

    public final int hashCode() {
        NullabilityQualifier nullabilityQualifier = this.f6912a;
        int iHashCode = (nullabilityQualifier == null ? 0 : nullabilityQualifier.hashCode()) * 31;
        MutabilityQualifier mutabilityQualifier = this.b;
        return Boolean.hashCode(this.d) + androidx.appfunctions.metadata.a.d((iHashCode + (mutabilityQualifier != null ? mutabilityQualifier.hashCode() : 0)) * 31, 31, this.c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("JavaTypeQualifiers(nullability=");
        sb.append(this.f6912a);
        sb.append(", mutability=");
        sb.append(this.b);
        sb.append(", definitelyNotNull=");
        sb.append(this.c);
        sb.append(", isNullabilityQualifierForWarning=");
        return androidx.appfunctions.metadata.a.r(sb, this.d, ')');
    }

    public /* synthetic */ C2141d(NullabilityQualifier nullabilityQualifier, boolean z10) {
        this(nullabilityQualifier, null, z10, false);
    }
}
