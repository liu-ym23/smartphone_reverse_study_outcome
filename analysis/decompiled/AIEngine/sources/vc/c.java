package vc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f13494a = new char[117];

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f13495b = new byte[126];

    static {
        for (int i10 = 0; i10 < 32; i10++) {
        }
        a('b', 8);
        a('t', 9);
        a('n', 10);
        a('f', 12);
        a('r', 13);
        a('/', 47);
        a('\"', 34);
        a('\\', 92);
        byte[] bArr = f13495b;
        for (int i11 = 0; i11 < 33; i11++) {
            bArr[i11] = 127;
        }
        bArr[9] = 3;
        bArr[10] = 3;
        bArr[13] = 3;
        bArr[32] = 3;
        bArr[44] = 4;
        bArr[58] = 5;
        bArr[123] = 6;
        bArr[125] = 7;
        bArr[91] = 8;
        bArr[93] = 9;
        bArr[34] = 1;
        bArr[92] = 2;
    }

    public static void a(char c9, int i10) {
        if (c9 != 'u') {
            f13494a[c9] = (char) i10;
        }
    }
}
