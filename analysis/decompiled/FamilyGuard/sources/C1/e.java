package C1;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int f564a = a();

    private static int a() {
        return d(System.getProperty("java.version"));
    }

    private static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i5 = 0; i5 < str.length(); i5++) {
                char cCharAt = str.charAt(i5);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int c() {
        return f564a;
    }

    static int d(String str) throws NumberFormatException {
        int iF = f(str);
        if (iF == -1) {
            iF = b(str);
        }
        if (iF == -1) {
            return 6;
        }
        return iF;
    }

    public static boolean e() {
        return f564a >= 9;
    }

    private static int f(String str) throws NumberFormatException {
        try {
            String[] strArrSplit = str.split("[._]");
            int i5 = Integer.parseInt(strArrSplit[0]);
            return (i5 != 1 || strArrSplit.length <= 1) ? i5 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
