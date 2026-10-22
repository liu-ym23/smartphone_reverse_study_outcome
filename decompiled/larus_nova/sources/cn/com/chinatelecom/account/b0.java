package cn.com.chinatelecom.account;

/* JADX INFO: loaded from: classes28.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f24364a = null;

    static {
        f24364a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L15;
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L11;
        char[] r103 = f24364a;
        r101.append(r103[(r100[r102] >> 4) & 15]);
        r101.append(r103[r100[r102] & 15]);
        r102 = r102 + 1;
        goto L8
    L11:
        return r101.toString();
    L15:
        return "";
    }

    public static byte[] a(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        char[] r101 = r100.toCharArray();
        int r102 = r101.length / 2;
        byte[] r103 = new byte[r102];
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L11;
        int r105 = r104 * 2;
        int r106 = Character.digit(r101[r105 + 1], 16) | (Character.digit(r101[r105], 16) << 4);
        if (r106 <= 127) goto L10;
        r106 = r106 - 256;
    L10:
        r103[r104] = (byte) r106;
        r104 = r104 + 1;
        goto L6
    L11:
        return r103;
    }
}
