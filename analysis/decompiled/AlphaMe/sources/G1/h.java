package G1;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final int f602a;

    static {
        int i4;
        String property = System.getProperty("java.version");
        try {
            String[] strArrSplit = property.split("[._]");
            i4 = Integer.parseInt(strArrSplit[0]);
            if (i4 == 1 && strArrSplit.length > 1) {
                i4 = Integer.parseInt(strArrSplit[1]);
            }
        } catch (NumberFormatException unused) {
            i4 = -1;
        }
        if (i4 == -1) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i5 = 0; i5 < property.length(); i5++) {
                    char cCharAt = property.charAt(i5);
                    if (!Character.isDigit(cCharAt)) {
                        break;
                    }
                    sb.append(cCharAt);
                }
                i4 = Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused2) {
                i4 = -1;
            }
        }
        if (i4 == -1) {
            i4 = 6;
        }
        f602a = i4;
    }
}
