package com.baidu.bbalbscesium.i;

import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes39.dex */
class n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f30168g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f30169h = 13;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f30170i = -1640531535;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f30171j = -2048144777;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f30172k = -1028477379;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f30173l = 668265263;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f30174m = 374761393;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f30175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f30176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f30177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f30178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f30179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f30180f;

    public n() {
        this(0);
    }

    public n(int r100) {
        this.f30175a = new byte[1];
        this.f30176b = new int[4];
        this.f30177c = new byte[16];
        this.f30178d = r100;
        b();
    }

    private static int a(byte[] r100, int r101) {
        return (int) (b(r100, r101, 4) & BodyPartID.bodyIdMax);
    }

    private static long b(byte[] r100, int r101, int r102) {
        if (r102 > 8) goto L9;
        long r103 = 0;
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L7;
        r103 = r103 | ((((long) r100[r101 + r104]) & 255) << (r104 * 8));
        r104 = r104 + 1;
        goto L5
    L7:
        return r103;
    L9:
        throw new IllegalArgumentException("can't read more than eight bytes into a long value");
    }

    private void b() {
        int[] r100 = this.f30176b;
        int r101 = this.f30178d;
        r100[0] = (r101 + f30170i) + f30171j;
        r100[1] = f30171j + r101;
        r100[2] = r101;
        r100[3] = r101 - f30170i;
    }

    private void b(byte[] r110, int r111) {
        int[] r100 = this.f30176b;
        int r101 = r100[0];
        int r102 = r100[1];
        int r103 = r100[2];
        int r104 = r100[3];
        int r105 = Integer.rotateLeft(r101 + (a(r110, r111) * f30171j), 13) * f30170i;
        int r106 = Integer.rotateLeft(r102 + (a(r110, r111 + 4) * f30171j), 13) * f30170i;
        int r107 = Integer.rotateLeft(r103 + (a(r110, r111 + 8) * f30171j), 13) * f30170i;
        int r112 = Integer.rotateLeft(r104 + (a(r110, r111 + 12) * f30171j), 13) * f30170i;
        int[] r113 = this.f30176b;
        r113[0] = r105;
        r113[1] = r106;
        r113[2] = r107;
        r113[3] = r112;
        this.f30180f = 0;
    }

    public long a() {
        int r100 = 0;
        if (this.f30179e <= 16) goto L5;
        int r101 = ((Integer.rotateLeft(this.f30176b[0], 1) + Integer.rotateLeft(this.f30176b[1], 7)) + Integer.rotateLeft(this.f30176b[2], 12)) + Integer.rotateLeft(this.f30176b[3], 18);
    L6:
        int r102 = r101 + this.f30179e;
        int r103 = this.f30180f - 4;
    L8:
        if (r100 > r103) goto L11;
        r102 = Integer.rotateLeft(r102 + (a(this.f30177c, r100) * f30172k), 17) * f30173l;
        r100 = r100 + 4;
    L11:
        if (r100 >= this.f30180f) goto L13;
        r102 = Integer.rotateLeft(r102 + ((this.f30177c[r100] & UByte.MAX_VALUE) * f30174m), 11) * f30170i;
        r100 = r100 + 1;
        goto L11
    L13:
        int r104 = (r102 ^ (r102 >>> 15)) * f30171j;
        int r105 = (r104 ^ (r104 >>> 13)) * f30172k;
        return ((long) (r105 ^ (r105 >>> 16))) & BodyPartID.bodyIdMax;
    L5:
        r101 = this.f30176b[2] + f30174m;
        goto L6
    }

    public void a(int r100) {
        byte[] r101 = this.f30175a;
        r101[0] = (byte) (r100 & 255);
        a(r101, 0, 1);
    }

    public void a(byte[] r100, int r101, int r102) {
        if (r102 > 0) goto L4;
        return;
    L4:
        this.f30179e += r102;
        int r103 = r101 + r102;
        int r104 = this.f30180f;
        if ((r104 + r102) >= 16) goto L9;
        System.arraycopy(r100, r101, this.f30177c, r104, r102);
        this.f30180f += r102;
        return;
    L9:
        if (r104 <= 0) goto L11;
        int r105 = 16 - r104;
        System.arraycopy(r100, r101, this.f30177c, r104, r105);
        b(this.f30177c, 0);
        r101 = r101 + r105;
    L11:
        int r106 = r103 - 16;
    L12:
        if (r101 > r106) goto L14;
        b(r100, r101);
        r101 = r101 + 16;
        goto L12
    L14:
        if (r101 >= r103) goto L18;
        int r107 = r103 - r101;
        this.f30180f = r107;
        System.arraycopy(r100, r101, this.f30177c, 0, r107);
        return;
    }

    public void c() {
        b();
        this.f30179e = 0;
        this.f30180f = 0;
    }
}
