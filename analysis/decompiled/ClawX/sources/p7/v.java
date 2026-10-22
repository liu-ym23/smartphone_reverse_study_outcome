package p7;

import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public final class v implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static final short[] f4827b = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f4828c = {0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};

    /* renamed from: a, reason: collision with root package name */
    public long[] f4829a;

    public v(int i8) {
        this.f4829a = new long[i8];
    }

    public static void a(int i8, long[] jArr, int i9, long[] jArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i8 + i11;
            jArr[i12] = jArr[i12] ^ jArr2[i9 + i11];
        }
    }

    public static long d(long[] jArr, int i8, long[] jArr2, int i9, int i10, int i11) {
        int i12 = 64 - i11;
        long j4 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            long j8 = jArr2[i9 + i13];
            int i14 = i8 + i13;
            jArr[i14] = (j4 | (j8 << i11)) ^ jArr[i14];
            j4 = j8 >>> i12;
        }
        return j4;
    }

    public static int e(long j4) {
        int i8;
        int i9 = 32;
        int i10 = (int) (j4 >>> 32);
        if (i10 == 0) {
            i10 = (int) j4;
            i9 = 0;
        }
        int i11 = i10 >>> 16;
        byte[] bArr = f4828c;
        if (i11 == 0) {
            int i12 = i10 >>> 8;
            i8 = i12 == 0 ? bArr[i10] : bArr[i12] + 8;
        } else {
            int i13 = i10 >>> 24;
            i8 = i13 == 0 ? bArr[i11] + 16 : bArr[i13] + 24;
        }
        return i9 + i8;
    }

    public static void h(long[] jArr, int i8) {
        int i9 = i8 >>> 6;
        jArr[i9] = (1 << (i8 & 63)) ^ jArr[i9];
    }

    public static void i(int i8, long[] jArr, int i9, long[] jArr2, int i10) {
        int i11 = i10 >>> 6;
        int i12 = i10 & 63;
        int i13 = i9;
        if (i12 == 0) {
            a(i11, jArr, i8, jArr2, i13);
            return;
        }
        int i14 = i11 + 1;
        int i15 = 64 - i12;
        int i16 = 64 - i15;
        long j4 = 0;
        while (true) {
            i13--;
            if (i13 < 0) {
                jArr[i11] = jArr[i11] ^ j4;
                return;
            }
            long j8 = jArr2[i8 + i13];
            int i17 = i14 + i13;
            jArr[i17] = (j4 | (j8 >>> i15)) ^ jArr[i17];
            j4 = j8 << i16;
        }
    }

    public static void j(int i8, long j4, long[] jArr) {
        int i9 = i8 >>> 6;
        int i10 = i8 & 63;
        if (i10 == 0) {
            jArr[i9] = jArr[i9] ^ j4;
            return;
        }
        jArr[i9] = jArr[i9] ^ (j4 << i10);
        long j8 = j4 >>> (64 - i10);
        if (j8 != 0) {
            int i11 = i9 + 1;
            jArr[i11] = j8 ^ jArr[i11];
        }
    }

    public static long l(int i8) {
        short[] sArr = f4827b;
        return ((((sArr[i8 >>> 24] << 16) | sArr[(i8 >>> 16) & 255]) & 4294967295L) << 32) | (4294967295L & (sArr[i8 & 255] | (sArr[(i8 >>> 8) & 255] << 16)));
    }

    public static void o(long j4, long[] jArr, int i8, long[] jArr2) {
        int i9 = i8;
        long[] jArr3 = jArr2;
        if ((j4 & 1) != 0) {
            a(0, jArr3, 0, jArr, i9);
        }
        long j8 = j4;
        int i10 = 1;
        while (true) {
            j8 >>>= 1;
            if (j8 == 0) {
                return;
            }
            if ((j8 & 1) != 0) {
                long jD = d(jArr3, 0, jArr, 0, i9, i10);
                if (jD != 0) {
                    jArr2[i8] = jArr2[i8] ^ jD;
                }
            }
            i10++;
            i9 = i8;
            jArr3 = jArr2;
        }
    }

    public static int p(long[] jArr, int i8, int i9, int[] iArr) {
        int i10 = (i9 + 63) >>> 6;
        if (i8 < i10) {
            return i8;
        }
        int i11 = i8 << 6;
        int iMin = Math.min(i11, (i9 << 1) - 1);
        int i12 = i11 - iMin;
        while (i12 >= 64) {
            i8--;
            i12 -= 64;
        }
        int length = iArr.length;
        int i13 = iArr[length - 1];
        int i14 = length > 1 ? iArr[length - 2] : 0;
        int iMax = Math.max(i9, i13 + 64);
        int iMin2 = (Math.min(iMin - iMax, i9 - i14) + i12) >> 6;
        if (iMin2 > 1) {
            int i15 = i8 - iMin2;
            iMin = i15 << 6;
            int i16 = iMin - i9;
            int length2 = iArr.length;
            while (true) {
                length2--;
                if (length2 < 0) {
                    break;
                }
                i(i15, jArr, i8 - i15, jArr, iArr[length2] + i16);
            }
            i(i15, jArr, i8 - i15, jArr, i16);
            while (i8 > i15) {
                i8--;
                jArr[i8] = 0;
            }
        }
        if (iMin > iMax) {
            int i17 = iMax >>> 6;
            while (true) {
                i8--;
                if (i8 <= i17) {
                    break;
                }
                long j4 = jArr[i8];
                if (j4 != 0) {
                    jArr[i8] = 0;
                    int i18 = (i8 << 6) - i9;
                    int length3 = iArr.length;
                    while (true) {
                        length3--;
                        if (length3 < 0) {
                            break;
                        }
                        j(iArr[length3] + i18, j4, jArr);
                    }
                    j(i18, j4, jArr);
                }
            }
            int i19 = iMax & 63;
            long j8 = jArr[i17];
            long j9 = j8 >>> i19;
            if (j9 != 0) {
                jArr[i17] = j8 ^ (j9 << i19);
                int i20 = iMax - i9;
                int length4 = iArr.length;
                while (true) {
                    length4--;
                    if (length4 < 0) {
                        break;
                    }
                    j(iArr[length4] + i20, j9, jArr);
                }
                j(i20, j9, jArr);
            }
        } else {
            iMax = iMin;
        }
        if (iMax > i9) {
            while (true) {
                iMax--;
                if (iMax < i9) {
                    break;
                }
                if (((1 << (iMax & 63)) & jArr[iMax >>> 6]) != 0) {
                    h(jArr, iMax);
                    int i21 = iMax - i9;
                    int length5 = iArr.length;
                    while (true) {
                        length5--;
                        if (length5 < 0) {
                            break;
                        }
                        h(jArr, iArr[length5] + i21);
                    }
                    h(jArr, i21);
                }
            }
        }
        return i10;
    }

    public static void q(long[] jArr, int i8, long[] jArr2, int i9, int i10, int i11) {
        int i12 = 64 - i11;
        long j4 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            long j8 = jArr[i8 + i13];
            jArr2[i9 + i13] = j4 | (j8 << i11);
            j4 = j8 >>> i12;
        }
    }

    public final void b(v vVar, int i8, int i9) {
        int i10 = (i8 + 63) >>> 6;
        int i11 = i9 >>> 6;
        int i12 = i9 & 63;
        if (i12 == 0) {
            a(i11, this.f4829a, 0, vVar.f4829a, i10);
            return;
        }
        long jD = d(this.f4829a, i11, vVar.f4829a, 0, i10, i12);
        if (jD != 0) {
            long[] jArr = this.f4829a;
            int i13 = i10 + i11;
            jArr[i13] = jD ^ jArr[i13];
        }
    }

    public final void c(v vVar) {
        int iK = vVar.k();
        if (iK == 0) {
            return;
        }
        long[] jArr = this.f4829a;
        if (iK > jArr.length) {
            long[] jArr2 = new long[iK];
            System.arraycopy(jArr, 0, jArr2, 0, Math.min(jArr.length, iK));
            this.f4829a = jArr2;
        }
        a(0, this.f4829a, 0, vVar.f4829a, iK);
    }

    public final Object clone() {
        return new v(Arrays.clone(this.f4829a));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        int iK = k();
        if (vVar.k() != iK) {
            return false;
        }
        for (int i8 = 0; i8 < iK; i8++) {
            if (this.f4829a[i8] != vVar.f4829a[i8]) {
                return false;
            }
        }
        return true;
    }

    public final int f() {
        int length = this.f4829a.length;
        while (length != 0) {
            length--;
            long j4 = this.f4829a[length];
            if (j4 != 0) {
                return e(j4) + (length << 6);
            }
        }
        return 0;
    }

    public final int g(int i8) {
        int i9 = (i8 + 62) >>> 6;
        while (i9 != 0) {
            i9--;
            long j4 = this.f4829a[i9];
            if (j4 != 0) {
                return e(j4) + (i9 << 6);
            }
        }
        return 0;
    }

    public final int hashCode() {
        int iK = k();
        int i8 = 1;
        for (int i9 = 0; i9 < iK; i9++) {
            long j4 = this.f4829a[i9];
            i8 = (((i8 * 31) ^ ((int) j4)) * 31) ^ ((int) (j4 >>> 32));
        }
        return i8;
    }

    public final int k() {
        long[] jArr = this.f4829a;
        int iMin = Math.min(jArr.length, jArr.length);
        if (iMin >= 1) {
            if (jArr[0] != 0) {
                while (true) {
                    int i8 = iMin - 1;
                    if (jArr[i8] != 0) {
                        return iMin;
                    }
                    iMin = i8;
                }
            } else {
                while (true) {
                    int i9 = iMin - 1;
                    if (jArr[i9] != 0) {
                        return iMin;
                    }
                    if (i9 <= 0) {
                        break;
                    }
                    iMin = i9;
                }
            }
        }
        return 0;
    }

    public final boolean m() {
        long[] jArr = this.f4829a;
        if (jArr[0] != 1) {
            return false;
        }
        for (int i8 = 1; i8 < jArr.length; i8++) {
            if (jArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public final v n(v vVar) {
        int i8;
        int i9;
        v vVar2;
        v vVar3;
        long[] jArr;
        int iF = f();
        if (iF == 0) {
            return this;
        }
        int iF2 = vVar.f();
        if (iF2 == 0) {
            return vVar;
        }
        if (iF > iF2) {
            i9 = iF;
            i8 = iF2;
            vVar3 = this;
            vVar2 = vVar;
        } else {
            i8 = iF;
            i9 = iF2;
            vVar2 = this;
            vVar3 = vVar;
        }
        int i10 = (i8 + 63) >>> 6;
        int i11 = (i9 + 63) >>> 6;
        int i12 = ((i8 + i9) + 62) >>> 6;
        if (i10 == 1) {
            long j4 = vVar2.f4829a[0];
            if (j4 == 1) {
                return vVar3;
            }
            long[] jArr2 = new long[i12];
            o(j4, vVar3.f4829a, i11, jArr2);
            return new v(jArr2, i12);
        }
        int i13 = (i9 + 70) >>> 6;
        int[] iArr = new int[16];
        int i14 = i13 << 4;
        long[] jArr3 = new long[i14];
        iArr[1] = i13;
        System.arraycopy(vVar3.f4829a, 0, jArr3, i13, i11);
        int i15 = 2;
        int i16 = i13;
        while (i15 < 16) {
            int i17 = i16 + i13;
            iArr[i15] = i17;
            if ((i15 & 1) == 0) {
                q(jArr3, i17 >>> 1, jArr3, i17, i13, 1);
                jArr = jArr3;
            } else {
                jArr = jArr3;
                int i18 = i17 - i13;
                for (int i19 = 0; i19 < i13; i19++) {
                    jArr[i17 + i19] = jArr[i13 + i19] ^ jArr[i18 + i19];
                }
            }
            i15++;
            i16 = i17;
            jArr3 = jArr;
        }
        long[] jArr4 = jArr3;
        long[] jArr5 = new long[i14];
        q(jArr4, 0, jArr5, 0, i14, 4);
        long[] jArr6 = vVar2.f4829a;
        int i20 = i12 << 3;
        long[] jArr7 = new long[i20];
        for (int i21 = 0; i21 < i10; i21++) {
            long j8 = jArr6[i21];
            int i22 = i21;
            while (true) {
                int i23 = iArr[((int) j8) & 15];
                int i24 = iArr[((int) (j8 >>> 4)) & 15];
                for (int i25 = 0; i25 < i13; i25++) {
                    int i26 = i22 + i25;
                    jArr7[i26] = jArr7[i26] ^ (jArr4[i23 + i25] ^ jArr5[i24 + i25]);
                }
                j8 >>>= 8;
                if (j8 == 0) {
                    break;
                }
                i22 += i12;
            }
        }
        while (true) {
            int i27 = i20 - i12;
            if (i27 == 0) {
                return new v(jArr7, i12);
            }
            d(jArr7, i27 - i12, jArr7, i27, i12, 8);
            i20 = i27;
        }
    }

    public final String toString() {
        int iK = k();
        if (iK == 0) {
            return "0";
        }
        int i8 = iK - 1;
        StringBuffer stringBuffer = new StringBuffer(Long.toBinaryString(this.f4829a[i8]));
        while (true) {
            i8--;
            if (i8 < 0) {
                return stringBuffer.toString();
            }
            String binaryString = Long.toBinaryString(this.f4829a[i8]);
            int length = binaryString.length();
            if (length < 64) {
                stringBuffer.append("0000000000000000000000000000000000000000000000000000000000000000".substring(length));
            }
            stringBuffer.append(binaryString);
        }
    }

    public v(long[] jArr) {
        this.f4829a = jArr;
    }

    public v(long[] jArr, int i8) {
        if (i8 == jArr.length) {
            this.f4829a = jArr;
            return;
        }
        long[] jArr2 = new long[i8];
        this.f4829a = jArr2;
        System.arraycopy(jArr, 0, jArr2, 0, i8);
    }
}
