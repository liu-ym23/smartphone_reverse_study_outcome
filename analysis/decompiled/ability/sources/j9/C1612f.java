package j9;

/* renamed from: j9.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1612f {
    public static final C1612f b = new C1612f();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4783a = true;

    public C1612f() {
        if (com.stepos.ability.task.executor.e.k("")) {
            return;
        }
        com.stepos.ability.task.executor.e.k("");
    }

    public final void a(StringBuilder sb, String str) {
        androidx.constraintlayout.core.dsl.a.A(sb, str, "prefix = \"", "", "\",");
        sb.append('\n');
        sb.append(str);
        sb.append("suffix = \"");
        sb.append("");
        sb.append("\",");
        sb.append('\n');
        sb.append(str);
        sb.append("removeLeadingZeros = ");
        sb.append(false);
        sb.append(',');
        sb.append('\n');
        sb.append(str);
        sb.append("minLength = ");
        sb.append(1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NumberHexFormat(\n");
        a(sb, "    ");
        sb.append('\n');
        sb.append(")");
        return sb.toString();
    }
}
