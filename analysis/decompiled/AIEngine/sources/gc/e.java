package gc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final e f9122d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9123a;

    /* renamed from: b, reason: collision with root package name */
    public final a f9124b;

    /* renamed from: c, reason: collision with root package name */
    public final b f9125c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f9126a;

        static {
            a aVar = new a();
            if (!a4.a.a("  ") && !a4.a.a("") && !a4.a.a("")) {
                a4.a.a("");
            }
            f9126a = aVar;
        }

        public final void a(StringBuilder sb2, String str) {
            com.stepos.core.ota.d.o(Integer.MAX_VALUE, str, "bytesPerLine = ", ",", sb2);
            sb2.append('\n');
            sb2.append(str);
            sb2.append("bytesPerGroup = ");
            sb2.append(Integer.MAX_VALUE);
            sb2.append(",");
            sb2.append('\n');
            sb2.append(str);
            sb2.append("groupSeparator = \"");
            sb2.append("  ");
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(str);
            sb2.append("byteSeparator = \"");
            sb2.append("");
            sb2.append("\",");
            sb2.append('\n');
            ai.onnxruntime.a.z(sb2, str, "bytePrefix = \"", "", "\",");
            sb2.append('\n');
            sb2.append(str);
            sb2.append("byteSuffix = \"");
            sb2.append("");
            sb2.append("\"");
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BytesHexFormat(\n");
            a(sb2, "    ");
            sb2.append('\n');
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final b f9127b = new b();

        /* renamed from: a, reason: collision with root package name */
        public final boolean f9128a = true;

        public b() {
            if (a4.a.a("")) {
                return;
            }
            a4.a.a("");
        }

        public final void a(StringBuilder sb2, String str) {
            ai.onnxruntime.a.z(sb2, str, "prefix = \"", "", "\",");
            sb2.append('\n');
            sb2.append(str);
            sb2.append("suffix = \"");
            sb2.append("");
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(str);
            sb2.append("removeLeadingZeros = ");
            sb2.append(false);
            sb2.append(',');
            sb2.append('\n');
            sb2.append(str);
            sb2.append("minLength = ");
            sb2.append(1);
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NumberHexFormat(\n");
            a(sb2, "    ");
            sb2.append('\n');
            sb2.append(")");
            return sb2.toString();
        }
    }

    static {
        a aVar = a.f9126a;
        b bVar = b.f9127b;
        f9122d = new e(false, aVar, bVar);
        new e(true, aVar, bVar);
    }

    public e(boolean z, a bytes, b number) {
        kotlin.jvm.internal.g.f(bytes, "bytes");
        kotlin.jvm.internal.g.f(number, "number");
        this.f9123a = z;
        this.f9124b = bytes;
        this.f9125c = number;
    }

    public final String toString() {
        StringBuilder sbB = v1.d.b("HexFormat(\n    upperCase = ");
        sbB.append(this.f9123a);
        sbB.append(",\n    bytes = BytesHexFormat(\n");
        this.f9124b.a(sbB, "        ");
        sbB.append('\n');
        sbB.append("    ),");
        sbB.append('\n');
        sbB.append("    number = NumberHexFormat(");
        sbB.append('\n');
        this.f9125c.a(sbB, "        ");
        sbB.append('\n');
        sbB.append("    )");
        sbB.append('\n');
        sbB.append(")");
        return sbB.toString();
    }
}
