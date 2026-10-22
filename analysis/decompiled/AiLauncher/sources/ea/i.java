package ea;

import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: f, reason: collision with root package name */
    public static final a f32412f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final b f32413a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtoBuf$VersionRequirement.VersionKind f32414b;

    /* renamed from: c, reason: collision with root package name */
    public final DeprecationLevel f32415c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f32416d;

    /* renamed from: e, reason: collision with root package name */
    public final String f32417e;

    public static final class a {

        /* renamed from: ea.i$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0397a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f32418a;

            static {
                int[] iArr = new int[ProtoBuf$VersionRequirement.Level.values().length];
                try {
                    iArr[ProtoBuf$VersionRequirement.Level.WARNING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ProtoBuf$VersionRequirement.Level.ERROR.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ProtoBuf$VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f32418a = iArr;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final i a(int i10, InterfaceC4020d nameResolver, j table) {
            DeprecationLevel deprecationLevel;
            p.i(nameResolver, "nameResolver");
            p.i(table, "table");
            ProtoBuf$VersionRequirement protoBuf$VersionRequirementB = table.b(i10);
            if (protoBuf$VersionRequirementB == null) {
                return null;
            }
            b bVarA = b.f32419d.a(protoBuf$VersionRequirementB.J() ? Integer.valueOf(protoBuf$VersionRequirementB.C()) : null, protoBuf$VersionRequirementB.K() ? Integer.valueOf(protoBuf$VersionRequirementB.D()) : null);
            ProtoBuf$VersionRequirement.Level levelZ = protoBuf$VersionRequirementB.z();
            p.f(levelZ);
            int i11 = C0397a.f32418a[levelZ.ordinal()];
            if (i11 == 1) {
                deprecationLevel = DeprecationLevel.WARNING;
            } else if (i11 == 2) {
                deprecationLevel = DeprecationLevel.ERROR;
            } else {
                if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                deprecationLevel = DeprecationLevel.HIDDEN;
            }
            DeprecationLevel deprecationLevel2 = deprecationLevel;
            Integer numValueOf = protoBuf$VersionRequirementB.F() ? Integer.valueOf(protoBuf$VersionRequirementB.y()) : null;
            String string = protoBuf$VersionRequirementB.H() ? nameResolver.getString(protoBuf$VersionRequirementB.A()) : null;
            ProtoBuf$VersionRequirement.VersionKind versionKindE = protoBuf$VersionRequirementB.E();
            p.h(versionKindE, "getVersionKind(...)");
            return new i(bVarA, versionKindE, deprecationLevel2, numValueOf, string);
        }

        public a() {
        }
    }

    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        public static final a f32419d = new a(null);

        /* renamed from: e, reason: collision with root package name */
        public static final b f32420e = new b(256, 256, 256);

        /* renamed from: a, reason: collision with root package name */
        public final int f32421a;

        /* renamed from: b, reason: collision with root package name */
        public final int f32422b;

        /* renamed from: c, reason: collision with root package name */
        public final int f32423c;

        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final b a(Integer num, Integer num2) {
                return num2 != null ? new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255) : num != null ? new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127) : b.f32420e;
            }

            public a() {
            }
        }

        public b(int i10, int i11, int i12) {
            this.f32421a = i10;
            this.f32422b = i11;
            this.f32423c = i12;
        }

        public final String a() {
            StringBuilder sb2;
            int i10;
            if (this.f32423c == 0) {
                sb2 = new StringBuilder();
                sb2.append(this.f32421a);
                sb2.append('.');
                i10 = this.f32422b;
            } else {
                sb2 = new StringBuilder();
                sb2.append(this.f32421a);
                sb2.append('.');
                sb2.append(this.f32422b);
                sb2.append('.');
                i10 = this.f32423c;
            }
            sb2.append(i10);
            return sb2.toString();
        }

        public final int b() {
            return this.f32421a;
        }

        public final int c() {
            return this.f32422b;
        }

        public final int d() {
            return this.f32423c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f32421a == bVar.f32421a && this.f32422b == bVar.f32422b && this.f32423c == bVar.f32423c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f32421a) * 31) + Integer.hashCode(this.f32422b)) * 31) + Integer.hashCode(this.f32423c);
        }

        public String toString() {
            return a();
        }
    }

    public i(b version, ProtoBuf$VersionRequirement.VersionKind kind, DeprecationLevel level, Integer num, String str) {
        p.i(version, "version");
        p.i(kind, "kind");
        p.i(level, "level");
        this.f32413a = version;
        this.f32414b = kind;
        this.f32415c = level;
        this.f32416d = num;
        this.f32417e = str;
    }

    public final Integer a() {
        return this.f32416d;
    }

    public final ProtoBuf$VersionRequirement.VersionKind b() {
        return this.f32414b;
    }

    public final DeprecationLevel c() {
        return this.f32415c;
    }

    public final String d() {
        return this.f32417e;
    }

    public final b e() {
        return this.f32413a;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("since ");
        sb2.append(this.f32413a);
        sb2.append(' ');
        sb2.append(this.f32415c);
        String str2 = "";
        if (this.f32416d != null) {
            str = " error " + this.f32416d.intValue();
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.f32417e != null) {
            str2 = ": " + this.f32417e;
        }
        sb2.append(str2);
        return sb2.toString();
    }
}
