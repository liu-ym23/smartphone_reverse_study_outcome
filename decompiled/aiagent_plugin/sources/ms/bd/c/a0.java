package ms.bd.c;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 {
    public static byte[] a(String r7) {
        int r0 = r7.length();
        byte[] r1 = new byte[r0 / 2];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        int r4 = Character.digit(r7.charAt(r2), 16) << 4;
        r1[r2 / 2] = (byte) (Character.digit(r7.charAt(r2 + 1), 16) + r4);
        r2 = r2 + 2;
        goto L3
    L5:
        return r1;
    }
}
