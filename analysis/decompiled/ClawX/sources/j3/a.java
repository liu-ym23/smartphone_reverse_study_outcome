package j3;

import s5.d;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f3508a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};

    public static String a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        s5.a aVar = d.f5240a;
        s5.a aVar2 = d.f5240a;
        aVar2.getClass();
        byte[] bArr = new byte[10];
        aVar2.a().nextBytes(bArr);
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 281474976710655L) {
            throw new IllegalArgumentException("Time is too long, or entropy is less than 10 bytes or null");
        }
        char[] cArr = f3508a;
        char c3 = cArr[((int) (jCurrentTimeMillis >>> 45)) & 31];
        char c8 = cArr[((int) (jCurrentTimeMillis >>> 40)) & 31];
        char c9 = cArr[((int) (jCurrentTimeMillis >>> 35)) & 31];
        char c10 = cArr[((int) (jCurrentTimeMillis >>> 30)) & 31];
        char c11 = cArr[((int) (jCurrentTimeMillis >>> 25)) & 31];
        char c12 = cArr[((int) (jCurrentTimeMillis >>> 20)) & 31];
        char c13 = cArr[((int) (jCurrentTimeMillis >>> 15)) & 31];
        char c14 = cArr[((int) (jCurrentTimeMillis >>> 10)) & 31];
        char c15 = cArr[((int) (jCurrentTimeMillis >>> 5)) & 31];
        char c16 = cArr[((int) jCurrentTimeMillis) & 31];
        byte b9 = bArr[0];
        char c17 = cArr[((short) (b9 & 255)) >>> 3];
        byte b10 = bArr[1];
        short s8 = (short) (b10 & 255);
        char c18 = cArr[((b9 << 2) | (s8 >>> 6)) & 31];
        char c19 = cArr[(s8 >>> 1) & 31];
        byte b11 = bArr[2];
        char c20 = cArr[((b10 << 4) | (((short) (b11 & 255)) >>> 4)) & 31];
        byte b12 = bArr[3];
        short s9 = (short) (b12 & 255);
        char c21 = cArr[((b11 << 5) | (s9 >>> 7)) & 31];
        char c22 = cArr[(s9 >>> 2) & 31];
        byte b13 = bArr[4];
        char c23 = cArr[((((short) (b13 & 255)) >>> 5) | (b12 << 3)) & 31];
        char c24 = cArr[b13 & 31];
        byte b14 = bArr[5];
        char c25 = cArr[((short) (b14 & 255)) >>> 3];
        byte b15 = bArr[6];
        short s10 = (short) (b15 & 255);
        char c26 = cArr[((b14 << 2) | (s10 >>> 6)) & 31];
        char c27 = cArr[(s10 >>> 1) & 31];
        int i8 = b15 << 4;
        byte b16 = bArr[7];
        char c28 = cArr[(i8 | (((short) (b16 & 255)) >>> 4)) & 31];
        int i9 = b16 << 5;
        byte b17 = bArr[8];
        short s11 = (short) (b17 & 255);
        char c29 = cArr[(i9 | (s11 >>> 7)) & 31];
        char c30 = cArr[(s11 >>> 2) & 31];
        int i10 = b17 << 3;
        byte b18 = bArr[9];
        return new String(new char[]{c3, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, cArr[(i10 | (((short) (b18 & 255)) >>> 5)) & 31], cArr[b18 & 31]});
    }
}
