package v8;

import X8.A;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* renamed from: v8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2065a {

    /* renamed from: a, reason: collision with root package name */
    public final Set f6790a;
    public final TypeUsage b;
    public final JavaTypeFlexibility c;
    public final boolean d;
    public final boolean e;
    public final Set f;
    public final A g;

    public C2065a(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z10, boolean z11, Set set, A a3) {
        this.f6790a = set;
        this.b = typeUsage;
        this.c = javaTypeFlexibility;
        this.d = z10;
        this.e = z11;
        this.f = set;
        this.g = a3;
    }

    public static C2065a a(C2065a c2065a, JavaTypeFlexibility javaTypeFlexibility, boolean z10, Set set, A a3, int i) {
        TypeUsage howThisTypeIsUsed = c2065a.b;
        if ((i & 2) != 0) {
            javaTypeFlexibility = c2065a.c;
        }
        JavaTypeFlexibility flexibility = javaTypeFlexibility;
        if ((i & 4) != 0) {
            z10 = c2065a.d;
        }
        boolean z11 = z10;
        boolean z12 = c2065a.e;
        if ((i & 16) != 0) {
            set = c2065a.f;
        }
        Set set2 = set;
        if ((i & 32) != 0) {
            a3 = c2065a.g;
        }
        c2065a.getClass();
        k.f(howThisTypeIsUsed, "howThisTypeIsUsed");
        k.f(flexibility, "flexibility");
        return new C2065a(howThisTypeIsUsed, flexibility, z11, z12, set2, a3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C2065a)) {
            return false;
        }
        C2065a c2065a = (C2065a) obj;
        return k.b(c2065a.g, this.g) && c2065a.b == this.b && c2065a.c == this.c && c2065a.d == this.d && c2065a.e == this.e;
    }

    public final int hashCode() {
        A a3 = this.g;
        int iHashCode = a3 != null ? a3.hashCode() : 0;
        int iHashCode2 = this.b.hashCode() + (iHashCode * 31) + iHashCode;
        int iHashCode3 = this.c.hashCode() + (iHashCode2 * 31) + iHashCode2;
        int i = (iHashCode3 * 31) + (this.d ? 1 : 0) + iHashCode3;
        return (i * 31) + (this.e ? 1 : 0) + i;
    }

    public final String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.b + ", flexibility=" + this.c + ", isRaw=" + this.d + ", isForAnnotationParameter=" + this.e + ", visitedTypeParameters=" + this.f + ", defaultType=" + this.g + ')';
    }

    public /* synthetic */ C2065a(TypeUsage typeUsage, boolean z10, boolean z11, Set set, int i) {
        this(typeUsage, JavaTypeFlexibility.f5002a, (i & 4) != 0 ? false : z10, (i & 8) != 0 ? false : z11, (i & 16) != 0 ? null : set, null);
    }
}
