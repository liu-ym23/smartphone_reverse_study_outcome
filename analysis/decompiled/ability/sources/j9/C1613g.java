package j9;

/* renamed from: j9.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1613g {
    public static final C1613g d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4784a;
    public final C1611e b;
    public final C1612f c;

    static {
        C1611e c1611e = C1611e.f4782a;
        C1612f c1612f = C1612f.b;
        d = new C1613g(false, c1611e, c1612f);
        new C1613g(true, c1611e, c1612f);
    }

    public C1613g(boolean z10, C1611e bytes, C1612f number) {
        kotlin.jvm.internal.k.f(bytes, "bytes");
        kotlin.jvm.internal.k.f(number, "number");
        this.f4784a = z10;
        this.b = bytes;
        this.c = number;
    }

    public final String toString() {
        StringBuilder sbV = androidx.compose.foundation.b.v("HexFormat(\n    upperCase = ");
        sbV.append(this.f4784a);
        sbV.append(",\n    bytes = BytesHexFormat(\n");
        this.b.a(sbV, "        ");
        sbV.append('\n');
        sbV.append("    ),");
        sbV.append('\n');
        sbV.append("    number = NumberHexFormat(");
        sbV.append('\n');
        this.c.a(sbV, "        ");
        sbV.append('\n');
        sbV.append("    )");
        sbV.append('\n');
        sbV.append(")");
        return sbV.toString();
    }
}
