package w2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static androidx.fragment.app.d a(String str) {
        r1.a.c(str);
        return new androidx.fragment.app.d();
    }

    public static String b(String str, String str2) {
        return str + str2;
    }

    public static StringBuilder c(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        return sb2;
    }

    public static /* synthetic */ void d(Object obj) {
        if (obj == null) {
            return;
        }
        od.f.j();
    }

    public static /* synthetic */ String e(int i) {
        switch (i) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String f(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "null" : "IN_LINE" : "BLOCK" : "BLANK_LINE";
    }
}
