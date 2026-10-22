package q0;

/* loaded from: classes.dex */
public class Z {

    /* renamed from: a, reason: collision with root package name */
    public final Z f19723a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19724b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f19725c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19726d;

    public Z(Z z5, Object obj, Object obj2, int i5, int i6) {
        this.f19723a = z5;
        this.f19724b = obj;
        this.f19725c = obj2;
        this.f19726d = i5;
    }

    protected void a(StringBuilder sb) {
        Z z5 = this.f19723a;
        if (z5 == null) {
            sb.append('$');
            return;
        }
        z5.a(sb);
        Object obj = this.f19725c;
        if (obj == null) {
            sb.append(".null");
            return;
        }
        if (obj instanceof Integer) {
            sb.append('[');
            sb.append(((Integer) this.f19725c).intValue());
            sb.append(']');
            return;
        }
        sb.append('.');
        String string = this.f19725c.toString();
        for (int i5 = 0; i5 < string.length(); i5++) {
            char cCharAt = string.charAt(i5);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && cCharAt <= 128))) {
                for (int i6 = 0; i6 < string.length(); i6++) {
                    char cCharAt2 = string.charAt(i6);
                    if (cCharAt2 == '\\') {
                        sb.append('\\');
                        sb.append('\\');
                        sb.append('\\');
                    } else if ((cCharAt2 >= '0' && cCharAt2 <= '9') || ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || ((cCharAt2 >= 'a' && cCharAt2 <= 'z') || cCharAt2 > 128))) {
                        sb.append(cCharAt2);
                    } else if (cCharAt2 == '\"') {
                        sb.append('\\');
                        sb.append('\\');
                        sb.append('\\');
                    } else {
                        sb.append('\\');
                        sb.append('\\');
                    }
                    sb.append(cCharAt2);
                }
                return;
            }
        }
        sb.append(string);
    }

    public String toString() {
        if (this.f19723a == null) {
            return "$";
        }
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }
}
