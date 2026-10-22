package ia;

/* renamed from: ia.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1571a extends AbstractC1572b {
    public static final char[] c = "0123456789ABCDEF".toCharArray();
    public final boolean[] b;

    public C1571a() {
        if ("-_.!~*'()@:$&,;=[]/".matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        char[] charArray = "-_.!~*'()@:$&,;=[]/".toCharArray();
        int iMax = 122;
        for (char c2 : charArray) {
            iMax = Math.max((int) c2, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (int i = 48; i <= 57; i++) {
            zArr[i] = true;
        }
        for (int i6 = 65; i6 <= 90; i6++) {
            zArr[i6] = true;
        }
        for (int i10 = 97; i10 <= 122; i10++) {
            zArr[i10] = true;
        }
        for (char c5 : charArray) {
            zArr[c5] = true;
        }
        this.b = zArr;
    }
}
