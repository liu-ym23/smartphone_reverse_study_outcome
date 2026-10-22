package c0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2103a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f2104b;

    static {
        String str;
        int i = 1;
        int length = "H".length();
        if (length == 0) {
            str = "";
        } else if (length != 1) {
            StringBuilder sb2 = new StringBuilder("H".length() * 10);
            while (true) {
                sb2.append((CharSequence) "H");
                if (i == 10) {
                    break;
                } else {
                    i++;
                }
            }
            str = sb2.toString();
        } else {
            char cCharAt = "H".charAt(0);
            char[] cArr = new char[10];
            for (int i3 = 0; i3 < 10; i3++) {
                cArr[i3] = cCharAt;
            }
            str = new String(cArr);
        }
        f2103a = str;
        f2104b = str + '\n' + str;
    }
}
