package j9;

/* renamed from: j9.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1611e {

    /* renamed from: a, reason: collision with root package name */
    public static final C1611e f4782a;

    static {
        C1611e c1611e = new C1611e();
        if (!com.stepos.ability.task.executor.e.k("  ") && !com.stepos.ability.task.executor.e.k("") && !com.stepos.ability.task.executor.e.k("")) {
            com.stepos.ability.task.executor.e.k("");
        }
        f4782a = c1611e;
    }

    public final void a(StringBuilder sb, String str) {
        androidx.compose.foundation.b.B(sb, str, "bytesPerLine = ", Integer.MAX_VALUE, ",");
        sb.append('\n');
        sb.append(str);
        sb.append("bytesPerGroup = ");
        sb.append(Integer.MAX_VALUE);
        sb.append(",");
        sb.append('\n');
        sb.append(str);
        sb.append("groupSeparator = \"");
        sb.append("  ");
        sb.append("\",");
        sb.append('\n');
        sb.append(str);
        sb.append("byteSeparator = \"");
        sb.append("");
        sb.append("\",");
        sb.append('\n');
        androidx.constraintlayout.core.dsl.a.A(sb, str, "bytePrefix = \"", "", "\",");
        sb.append('\n');
        sb.append(str);
        sb.append("byteSuffix = \"");
        sb.append("");
        sb.append("\"");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BytesHexFormat(\n");
        a(sb, "    ");
        sb.append('\n');
        sb.append(")");
        return sb.toString();
    }
}
