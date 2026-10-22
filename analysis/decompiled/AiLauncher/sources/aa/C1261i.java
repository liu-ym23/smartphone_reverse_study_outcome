package aa;

import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* renamed from: aa.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1261i {

    /* renamed from: e, reason: collision with root package name */
    public static final a f8142e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final C1261i f8143f = new C1261i(null, null, false, false, 8, null);

    /* renamed from: a, reason: collision with root package name */
    public final NullabilityQualifier f8144a;

    /* renamed from: b, reason: collision with root package name */
    public final MutabilityQualifier f8145b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8146c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8147d;

    /* renamed from: aa.i$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C1261i a() {
            return C1261i.f8143f;
        }

        public a() {
        }
    }

    public C1261i(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z10, boolean z11) {
        this.f8144a = nullabilityQualifier;
        this.f8145b = mutabilityQualifier;
        this.f8146c = z10;
        this.f8147d = z11;
    }

    public static /* synthetic */ C1261i c(C1261i c1261i, NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            nullabilityQualifier = c1261i.f8144a;
        }
        if ((i10 & 2) != 0) {
            mutabilityQualifier = c1261i.f8145b;
        }
        if ((i10 & 4) != 0) {
            z10 = c1261i.f8146c;
        }
        if ((i10 & 8) != 0) {
            z11 = c1261i.f8147d;
        }
        return c1261i.b(nullabilityQualifier, mutabilityQualifier, z10, z11);
    }

    public final C1261i b(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z10, boolean z11) {
        return new C1261i(nullabilityQualifier, mutabilityQualifier, z10, z11);
    }

    public final boolean d() {
        return this.f8146c;
    }

    public final MutabilityQualifier e() {
        return this.f8145b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1261i)) {
            return false;
        }
        C1261i c1261i = (C1261i) obj;
        return this.f8144a == c1261i.f8144a && this.f8145b == c1261i.f8145b && this.f8146c == c1261i.f8146c && this.f8147d == c1261i.f8147d;
    }

    public final NullabilityQualifier f() {
        return this.f8144a;
    }

    public final boolean g() {
        return this.f8147d;
    }

    public int hashCode() {
        NullabilityQualifier nullabilityQualifier = this.f8144a;
        int iHashCode = (nullabilityQualifier == null ? 0 : nullabilityQualifier.hashCode()) * 31;
        MutabilityQualifier mutabilityQualifier = this.f8145b;
        return ((((iHashCode + (mutabilityQualifier != null ? mutabilityQualifier.hashCode() : 0)) * 31) + Boolean.hashCode(this.f8146c)) * 31) + Boolean.hashCode(this.f8147d);
    }

    public String toString() {
        return "JavaTypeQualifiers(nullability=" + this.f8144a + ", mutability=" + this.f8145b + ", definitelyNotNull=" + this.f8146c + ", isNullabilityQualifierForWarning=" + this.f8147d + ')';
    }

    public /* synthetic */ C1261i(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
        this(nullabilityQualifier, mutabilityQualifier, z10, (i10 & 8) != 0 ? false : z11);
    }
}
