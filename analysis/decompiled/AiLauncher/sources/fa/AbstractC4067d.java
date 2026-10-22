package fa;

import kotlin.jvm.internal.p;

/* renamed from: fa.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4067d {

    /* renamed from: fa.d$a */
    public static final class a extends AbstractC4067d {

        /* renamed from: a, reason: collision with root package name */
        public final String f32581a;

        /* renamed from: b, reason: collision with root package name */
        public final String f32582b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String name, String desc) {
            super(null);
            p.i(name, "name");
            p.i(desc, "desc");
            this.f32581a = name;
            this.f32582b = desc;
        }

        @Override // fa.AbstractC4067d
        public String a() {
            return e() + ':' + d();
        }

        public final String b() {
            return this.f32581a;
        }

        public final String c() {
            return this.f32582b;
        }

        public String d() {
            return this.f32582b;
        }

        public String e() {
            return this.f32581a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return p.d(this.f32581a, aVar.f32581a) && p.d(this.f32582b, aVar.f32582b);
        }

        public int hashCode() {
            return (this.f32581a.hashCode() * 31) + this.f32582b.hashCode();
        }
    }

    /* renamed from: fa.d$b */
    public static final class b extends AbstractC4067d {

        /* renamed from: a, reason: collision with root package name */
        public final String f32583a;

        /* renamed from: b, reason: collision with root package name */
        public final String f32584b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String name, String desc) {
            super(null);
            p.i(name, "name");
            p.i(desc, "desc");
            this.f32583a = name;
            this.f32584b = desc;
        }

        public static /* synthetic */ b c(b bVar, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = bVar.f32583a;
            }
            if ((i10 & 2) != 0) {
                str2 = bVar.f32584b;
            }
            return bVar.b(str, str2);
        }

        @Override // fa.AbstractC4067d
        public String a() {
            return e() + d();
        }

        public final b b(String name, String desc) {
            p.i(name, "name");
            p.i(desc, "desc");
            return new b(name, desc);
        }

        public String d() {
            return this.f32584b;
        }

        public String e() {
            return this.f32583a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return p.d(this.f32583a, bVar.f32583a) && p.d(this.f32584b, bVar.f32584b);
        }

        public int hashCode() {
            return (this.f32583a.hashCode() * 31) + this.f32584b.hashCode();
        }
    }

    public /* synthetic */ AbstractC4067d(kotlin.jvm.internal.i iVar) {
        this();
    }

    public abstract String a();

    public final String toString() {
        return a();
    }

    public AbstractC4067d() {
    }
}
