package N9;

import com.fasterxml.jackson.core.JsonFactory;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class c {

    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final N9.b f4894a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(N9.b annotation) {
            super(null);
            kotlin.jvm.internal.p.i(annotation, "annotation");
            this.f4894a = annotation;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && kotlin.jvm.internal.p.d(this.f4894a, ((a) obj).f4894a);
        }

        public int hashCode() {
            return this.f4894a.hashCode();
        }

        public String toString() {
            return "AnnotationValue(" + this.f4894a + ')';
        }
    }

    public static final class b extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f4895a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4896b;

        /* renamed from: c, reason: collision with root package name */
        public final String f4897c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String className, int i10) {
            super(null);
            kotlin.jvm.internal.p.i(className, "className");
            this.f4895a = className;
            this.f4896b = i10;
            if (i10 <= 0) {
                throw new IllegalArgumentException("ArrayKClassValue must have at least one dimension. For regular X::class argument, use KClassValue.");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ArrayKClassValue(");
            for (int i11 = 0; i11 < i10; i11++) {
                sb2.append("kotlin/Array<");
            }
            sb2.append(this.f4895a);
            int i12 = this.f4896b;
            for (int i13 = 0; i13 < i12; i13++) {
                sb2.append(">");
            }
            sb2.append(")");
            this.f4897c = sb2.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return kotlin.jvm.internal.p.d(this.f4895a, bVar.f4895a) && this.f4896b == bVar.f4896b;
        }

        public int hashCode() {
            return (this.f4895a.hashCode() * 31) + Integer.hashCode(this.f4896b);
        }

        public String toString() {
            return this.f4897c;
        }
    }

    /* renamed from: N9.c$c, reason: collision with other inner class name */
    public static final class C0087c extends c {

        /* renamed from: a, reason: collision with root package name */
        public final List<c> f4898a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0087c(List<? extends c> elements) {
            super(null);
            kotlin.jvm.internal.p.i(elements, "elements");
            this.f4898a = elements;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0087c) && kotlin.jvm.internal.p.d(this.f4898a, ((C0087c) obj).f4898a);
        }

        public int hashCode() {
            return this.f4898a.hashCode();
        }

        public String toString() {
            return "ArrayValue(" + this.f4898a + ')';
        }
    }

    public static final class d extends l<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f4899a;

        public d(boolean z10) {
            super(null);
            this.f4899a = z10;
        }

        @Override // N9.c.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(this.f4899a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.f4899a == ((d) obj).f4899a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f4899a);
        }
    }

    public static final class e extends l<Byte> {

        /* renamed from: a, reason: collision with root package name */
        public final byte f4900a;

        public e(byte b10) {
            super(null);
            this.f4900a = b10;
        }

        @Override // N9.c.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte a() {
            return Byte.valueOf(this.f4900a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.f4900a == ((e) obj).f4900a;
        }

        public int hashCode() {
            return Byte.hashCode(this.f4900a);
        }
    }

    public static final class f extends l<Character> {

        /* renamed from: a, reason: collision with root package name */
        public final char f4901a;

        public f(char c10) {
            super(null);
            this.f4901a = c10;
        }

        @Override // N9.c.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Character a() {
            return Character.valueOf(this.f4901a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && this.f4901a == ((f) obj).f4901a;
        }

        public int hashCode() {
            return Character.hashCode(this.f4901a);
        }
    }

    public static final class g extends l<Double> {

        /* renamed from: a, reason: collision with root package name */
        public final double f4902a;

        public g(double d10) {
            super(null);
            this.f4902a = d10;
        }

        @Override // N9.c.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a() {
            return Double.valueOf(this.f4902a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && Double.compare(this.f4902a, ((g) obj).f4902a) == 0;
        }

        public int hashCode() {
            return Double.hashCode(this.f4902a);
        }
    }

    public static final class h extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f4903a;

        /* renamed from: b, reason: collision with root package name */
        public final String f4904b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String enumClassName, String enumEntryName) {
            super(null);
            kotlin.jvm.internal.p.i(enumClassName, "enumClassName");
            kotlin.jvm.internal.p.i(enumEntryName, "enumEntryName");
            this.f4903a = enumClassName;
            this.f4904b = enumEntryName;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return kotlin.jvm.internal.p.d(this.f4903a, hVar.f4903a) && kotlin.jvm.internal.p.d(this.f4904b, hVar.f4904b);
        }

        public int hashCode() {
            return (this.f4903a.hashCode() * 31) + this.f4904b.hashCode();
        }

        public String toString() {
            return "EnumValue(" + this.f4903a + '.' + this.f4904b + ')';
        }
    }

    public static final class i extends l<Float> {

        /* renamed from: a, reason: collision with root package name */
        public final float f4905a;

        public i(float f10) {
            super(null);
            this.f4905a = f10;
        }

        @Override // N9.c.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float a() {
            return Float.valueOf(this.f4905a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && Float.compare(this.f4905a, ((i) obj).f4905a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.f4905a);
        }
    }

    public static final class j extends l<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public final int f4906a;

        public j(int i10) {
            super(null);
            this.f4906a = i10;
        }

        @Override // N9.c.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a() {
            return Integer.valueOf(this.f4906a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && this.f4906a == ((j) obj).f4906a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f4906a);
        }
    }

    public static final class k extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f4907a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String className) {
            super(null);
            kotlin.jvm.internal.p.i(className, "className");
            this.f4907a = className;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && kotlin.jvm.internal.p.d(this.f4907a, ((k) obj).f4907a);
        }

        public int hashCode() {
            return this.f4907a.hashCode();
        }

        public String toString() {
            return "KClassValue(" + this.f4907a + ')';
        }
    }

    public static abstract class l<T> extends c {
        public /* synthetic */ l(kotlin.jvm.internal.i iVar) {
            this();
        }

        public abstract T a();

        public final String toString() {
            String string;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getClass().getSimpleName());
            sb2.append('(');
            if (this instanceof o) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                sb3.append((Object) ((o) this).a());
                sb3.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                string = sb3.toString();
            } else {
                string = a().toString();
            }
            sb2.append(string);
            sb2.append(')');
            return sb2.toString();
        }

        public l() {
            super(null);
        }
    }

    public static final class m extends l<Long> {

        /* renamed from: a, reason: collision with root package name */
        public final long f4908a;

        public m(long j10) {
            super(null);
            this.f4908a = j10;
        }

        @Override // N9.c.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a() {
            return Long.valueOf(this.f4908a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof m) && this.f4908a == ((m) obj).f4908a;
        }

        public int hashCode() {
            return Long.hashCode(this.f4908a);
        }
    }

    public static final class n extends l<Short> {

        /* renamed from: a, reason: collision with root package name */
        public final short f4909a;

        public n(short s10) {
            super(null);
            this.f4909a = s10;
        }

        @Override // N9.c.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short a() {
            return Short.valueOf(this.f4909a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof n) && this.f4909a == ((n) obj).f4909a;
        }

        public int hashCode() {
            return Short.hashCode(this.f4909a);
        }
    }

    public static final class o extends l<String> {

        /* renamed from: a, reason: collision with root package name */
        public final String f4910a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(String value) {
            super(null);
            kotlin.jvm.internal.p.i(value, "value");
            this.f4910a = value;
        }

        @Override // N9.c.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a() {
            return this.f4910a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof o) && kotlin.jvm.internal.p.d(this.f4910a, ((o) obj).f4910a);
        }

        public int hashCode() {
            return this.f4910a.hashCode();
        }
    }

    public static final class p extends l<Y8.k> {

        /* renamed from: a, reason: collision with root package name */
        public final byte f4911a;

        public /* synthetic */ p(byte b10, kotlin.jvm.internal.i iVar) {
            this(b10);
        }

        @Override // N9.c.l
        public /* bridge */ /* synthetic */ Y8.k a() {
            return Y8.k.a(b());
        }

        public byte b() {
            return this.f4911a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof p) && this.f4911a == ((p) obj).f4911a;
        }

        public int hashCode() {
            return Y8.k.i(this.f4911a);
        }

        public p(byte b10) {
            super(null);
            this.f4911a = b10;
        }
    }

    public static final class q extends l<Y8.m> {

        /* renamed from: a, reason: collision with root package name */
        public final int f4912a;

        public /* synthetic */ q(int i10, kotlin.jvm.internal.i iVar) {
            this(i10);
        }

        @Override // N9.c.l
        public /* bridge */ /* synthetic */ Y8.m a() {
            return Y8.m.a(b());
        }

        public int b() {
            return this.f4912a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof q) && this.f4912a == ((q) obj).f4912a;
        }

        public int hashCode() {
            return Y8.m.e(this.f4912a);
        }

        public q(int i10) {
            super(null);
            this.f4912a = i10;
        }
    }

    public static final class r extends l<Y8.o> {

        /* renamed from: a, reason: collision with root package name */
        public final long f4913a;

        public /* synthetic */ r(long j10, kotlin.jvm.internal.i iVar) {
            this(j10);
        }

        @Override // N9.c.l
        public /* bridge */ /* synthetic */ Y8.o a() {
            return Y8.o.a(b());
        }

        public long b() {
            return this.f4913a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && this.f4913a == ((r) obj).f4913a;
        }

        public int hashCode() {
            return Y8.o.e(this.f4913a);
        }

        public r(long j10) {
            super(null);
            this.f4913a = j10;
        }
    }

    public static final class s extends l<Y8.r> {

        /* renamed from: a, reason: collision with root package name */
        public final short f4914a;

        public /* synthetic */ s(short s10, kotlin.jvm.internal.i iVar) {
            this(s10);
        }

        @Override // N9.c.l
        public /* bridge */ /* synthetic */ Y8.r a() {
            return Y8.r.a(b());
        }

        public short b() {
            return this.f4914a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof s) && this.f4914a == ((s) obj).f4914a;
        }

        public int hashCode() {
            return Y8.r.e(this.f4914a);
        }

        public s(short s10) {
            super(null);
            this.f4914a = s10;
        }
    }

    public /* synthetic */ c(kotlin.jvm.internal.i iVar) {
        this();
    }

    public c() {
    }
}
