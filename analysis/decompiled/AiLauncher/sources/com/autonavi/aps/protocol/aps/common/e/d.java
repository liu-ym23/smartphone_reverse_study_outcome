package com.autonavi.aps.protocol.aps.common.e;

import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.util.date.GMTDateParser;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d {

    public static class a {

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f18513c;

        /* renamed from: d, reason: collision with root package name */
        private static final int[] f18514d;

        /* renamed from: e, reason: collision with root package name */
        static final a f18515e;

        /* renamed from: a, reason: collision with root package name */
        private final boolean f18516a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f18517b;

        static {
            int[] iArr = new int[256];
            f18513c = iArr;
            Arrays.fill(iArr, -1);
            for (int i10 = 0; i10 < b.f18518e.length; i10++) {
                f18513c[b.f18518e[i10]] = i10;
            }
            f18513c[61] = -2;
            int[] iArr2 = new int[256];
            f18514d = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i11 = 0; i11 < b.f18519f.length; i11++) {
                f18514d[b.f18519f[i11]] = i11;
            }
            f18514d[61] = -2;
            f18515e = new a(false, false);
        }

        private a(boolean z10, boolean z11) {
            this.f18516a = z10;
            this.f18517b = z11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x0096, code lost:
        
            if (r11 != 18) goto L71;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public byte[] a(byte[] r18) {
            /*
                Method dump skipped, instructions count: 318
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.protocol.aps.common.e.d.a.a(byte[]):byte[]");
        }
    }

    public static class b {

        /* renamed from: e, reason: collision with root package name */
        private static final char[] f18518e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', GMTDateParser.MONTH, 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', GMTDateParser.YEAR, 'Z', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', 'u', 'v', 'w', 'x', 'y', GMTDateParser.ZONE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', JsonPointer.SEPARATOR};

        /* renamed from: f, reason: collision with root package name */
        private static final char[] f18519f = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', GMTDateParser.MONTH, 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', GMTDateParser.YEAR, 'Z', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', 'u', 'v', 'w', 'x', 'y', GMTDateParser.ZONE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};

        /* renamed from: g, reason: collision with root package name */
        private static final byte[] f18520g = {13, 10};

        /* renamed from: h, reason: collision with root package name */
        static final b f18521h = new b(false, null, -1, true);

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f18522a = null;

        /* renamed from: b, reason: collision with root package name */
        private final int f18523b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f18524c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f18525d;

        private b(boolean z10, byte[] bArr, int i10, boolean z11) {
            this.f18524c = z10;
            this.f18523b = i10;
            this.f18525d = z11;
        }

        public byte[] a(byte[] bArr) {
            int length;
            int i10;
            byte[] bArr2 = bArr;
            int length2 = bArr2.length;
            if (this.f18525d) {
                length = ((length2 + 2) / 3) * 4;
            } else {
                int i11 = length2 % 3;
                length = ((length2 / 3) * 4) + (i11 == 0 ? 0 : i11 + 1);
            }
            int i12 = this.f18523b;
            if (i12 > 0) {
                length += ((length - 1) / i12) * this.f18522a.length;
            }
            byte[] bArr3 = new byte[length];
            int length3 = bArr2.length;
            char[] cArr = this.f18524c ? f18519f : f18518e;
            int i13 = (length3 / 3) * 3;
            if (i12 <= 0 || i13 <= (i10 = (i12 / 4) * 3)) {
                i10 = i13;
            }
            int i14 = 0;
            int i15 = 0;
            while (i14 < i13) {
                int iMin = Math.min(i14 + i10, i13);
                int i16 = i14;
                int i17 = i15;
                while (i16 < iMin) {
                    int i18 = i16 + 2;
                    int i19 = ((bArr2[i16 + 1] & 255) << 8) | ((bArr2[i16] & 255) << 16);
                    i16 += 3;
                    int i20 = i19 | (bArr2[i18] & 255);
                    bArr3[i17] = (byte) cArr[(i20 >>> 18) & 63];
                    bArr3[i17 + 1] = (byte) cArr[(i20 >>> 12) & 63];
                    int i21 = i17 + 3;
                    bArr3[i17 + 2] = (byte) cArr[(i20 >>> 6) & 63];
                    i17 += 4;
                    bArr3[i21] = (byte) cArr[i20 & 63];
                    bArr2 = bArr;
                }
                int i22 = ((iMin - i14) / 3) * 4;
                i15 += i22;
                if (i22 == this.f18523b && iMin < length3) {
                    byte[] bArr4 = this.f18522a;
                    int length4 = bArr4.length;
                    int i23 = 0;
                    while (i23 < length4) {
                        bArr3[i15] = bArr4[i23];
                        i23++;
                        i15++;
                    }
                }
                bArr2 = bArr;
                i14 = iMin;
            }
            if (i14 < length3) {
                int i24 = i14 + 1;
                int i25 = bArr[i14] & 255;
                int i26 = i15 + 1;
                bArr3[i15] = (byte) cArr[i25 >> 2];
                if (i24 == length3) {
                    int i27 = i15 + 2;
                    bArr3[i26] = (byte) cArr[(i25 << 4) & 63];
                    if (this.f18525d) {
                        int i28 = i15 + 3;
                        bArr3[i27] = 61;
                        i15 += 4;
                        bArr3[i28] = 61;
                    } else {
                        i15 = i27;
                    }
                } else {
                    int i29 = bArr[i24] & 255;
                    bArr3[i26] = (byte) cArr[((i25 << 4) & 63) | (i29 >> 4)];
                    int i30 = i15 + 3;
                    bArr3[i15 + 2] = (byte) cArr[(i29 << 2) & 63];
                    if (this.f18525d) {
                        i15 += 4;
                        bArr3[i30] = 61;
                    } else {
                        i15 = i30;
                    }
                }
            }
            return i15 != length ? Arrays.copyOf(bArr3, i15) : bArr3;
        }

        public String b(byte[] bArr) {
            byte[] bArrA = a(bArr);
            return new String(bArrA, 0, 0, bArrA.length);
        }
    }

    public static b a() {
        return b.f18521h;
    }

    public static a b() {
        return a.f18515e;
    }
}
