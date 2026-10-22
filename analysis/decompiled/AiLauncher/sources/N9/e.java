package N9;

/* loaded from: classes5.dex */
public abstract class e {

    public static final class a extends e {

        /* renamed from: a, reason: collision with root package name */
        public final String f4934a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String name) {
            super(null);
            kotlin.jvm.internal.p.i(name, "name");
            this.f4934a = name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && kotlin.jvm.internal.p.d(this.f4934a, ((a) obj).f4934a);
        }

        public int hashCode() {
            return this.f4934a.hashCode();
        }

        public String toString() {
            return "Class(name=" + this.f4934a + ')';
        }
    }

    public static final class b extends e {

        /* renamed from: a, reason: collision with root package name */
        public final String f4935a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String name) {
            super(null);
            kotlin.jvm.internal.p.i(name, "name");
            this.f4935a = name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && kotlin.jvm.internal.p.d(this.f4935a, ((b) obj).f4935a);
        }

        public int hashCode() {
            return this.f4935a.hashCode();
        }

        public String toString() {
            return "TypeAlias(name=" + this.f4935a + ')';
        }
    }

    public static final class c extends e {

        /* renamed from: a, reason: collision with root package name */
        public final int f4936a;

        public c(int i10) {
            super(null);
            this.f4936a = i10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.f4936a == ((c) obj).f4936a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f4936a);
        }

        public String toString() {
            return "TypeParameter(id=" + this.f4936a + ')';
        }
    }

    public /* synthetic */ e(kotlin.jvm.internal.i iVar) {
        this();
    }

    public e() {
    }
}
