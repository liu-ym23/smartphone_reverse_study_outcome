package u0;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f22800a = {new int[]{536870912, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{1000000000, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f22801b = {new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};

    public static int a(float f5, char[] cArr, int i5) {
        int i6;
        char c6;
        char c7;
        int i7;
        int i8;
        boolean z5;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z6;
        boolean z7;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        char c8;
        long j5;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        if (!Float.isNaN(f5)) {
            if (f5 == Float.POSITIVE_INFINITY) {
                cArr[i5] = 'I';
                cArr[i5 + 1] = 'n';
                cArr[i5 + 2] = 'f';
                cArr[i5 + 3] = 'i';
                cArr[i5 + 4] = 'n';
                cArr[i5 + 5] = 'i';
                cArr[i5 + 6] = 't';
                i22 = i5 + 8;
                cArr[i5 + 7] = 'y';
            } else if (f5 == Float.NEGATIVE_INFINITY) {
                cArr[i5] = '-';
                cArr[i5 + 1] = 'I';
                cArr[i5 + 2] = 'n';
                cArr[i5 + 3] = 'f';
                cArr[i5 + 4] = 'i';
                cArr[i5 + 5] = 'n';
                cArr[i5 + 6] = 'i';
                cArr[i5 + 7] = 't';
                i23 = i5 + 9;
                cArr[i5 + 8] = 'y';
            } else {
                int iFloatToIntBits = Float.floatToIntBits(f5);
                if (iFloatToIntBits == 0) {
                    cArr[i5] = '0';
                    cArr[i5 + 1] = '.';
                    i23 = i5 + 3;
                    cArr[i5 + 2] = '0';
                } else {
                    if (iFloatToIntBits != Integer.MIN_VALUE) {
                        int i24 = (iFloatToIntBits >> 23) & 255;
                        int i25 = 8388607 & iFloatToIntBits;
                        if (i24 == 0) {
                            i6 = -149;
                        } else {
                            i6 = i24 - 150;
                            i25 |= 8388608;
                        }
                        boolean z8 = iFloatToIntBits < 0;
                        boolean z9 = (i25 & 1) == 0;
                        int i26 = i25 * 4;
                        int i27 = i26 + 2;
                        int i28 = i26 - ((((long) i25) != 8388608 || i24 <= 1) ? 2 : 1);
                        int i29 = i6 - 2;
                        if (i29 >= 0) {
                            c7 = '-';
                            i12 = (int) ((i29 * 3010299) / 10000000);
                            if (i12 == 0) {
                                i18 = 1;
                                c8 = 2;
                                j5 = 9999999;
                            } else {
                                c8 = 2;
                                j5 = 9999999;
                                i18 = (int) (((i12 * 23219280) + 9999999) / 10000000);
                            }
                            int i30 = (-i29) + i12;
                            int[][] iArr = f22801b;
                            int[] iArr2 = iArr[i12];
                            c6 = '0';
                            long j6 = iArr2[0];
                            long j7 = iArr2[1];
                            i8 = 10;
                            long j8 = i26;
                            int i31 = ((i18 + 58) + i30) - 31;
                            i7 = 0;
                            int i32 = (int) (((j8 * j6) + ((j8 * j7) >> 31)) >> i31);
                            z5 = z8;
                            long j9 = i27;
                            int i33 = (int) (((j9 * j6) + ((j9 * j7) >> 31)) >> i31);
                            long j10 = i28;
                            int i34 = (int) (((j6 * j10) + ((j10 * j7) >> 31)) >> i31);
                            if (i12 == 0 || (i33 - 1) / 10 > i34 / 10) {
                                i19 = i33;
                                i20 = i34;
                                i21 = 0;
                            } else {
                                int i35 = i12 - 1;
                                int i36 = (i30 - 1) + (i35 == 0 ? 1 : (int) (((i35 * 23219280) + j5) / 10000000)) + 58;
                                int[] iArr3 = iArr[i35];
                                i19 = i33;
                                i20 = i34;
                                i21 = (int) ((((iArr3[0] * j8) + ((j8 * iArr3[1]) >> 31)) >> (i36 - 31)) % 10);
                            }
                            int i37 = 0;
                            while (i27 > 0 && i27 % 5 == 0) {
                                i27 /= 5;
                                i37++;
                            }
                            int i38 = 0;
                            while (i26 > 0 && i26 % 5 == 0) {
                                i26 /= 5;
                                i38++;
                            }
                            int i39 = 0;
                            while (i28 > 0 && i28 % 5 == 0) {
                                i28 /= 5;
                                i39++;
                            }
                            boolean z10 = i37 >= i12;
                            boolean z11 = i38 >= i12;
                            i13 = i39 >= i12 ? 1 : 0;
                            z7 = z11;
                            i10 = i20;
                            i9 = i32;
                            z6 = z10;
                            i14 = i21;
                            i15 = i19;
                        } else {
                            c6 = '0';
                            c7 = '-';
                            i7 = 0;
                            i8 = 10;
                            z5 = z8;
                            int i40 = -i29;
                            int i41 = (int) ((i40 * 6989700) / 10000000);
                            int i42 = i40 - i41;
                            int i43 = i42 == 0 ? 1 : (int) (((i42 * 23219280) + 9999999) / 10000000);
                            int[][] iArr4 = f22800a;
                            int[] iArr5 = iArr4[i42];
                            long j11 = iArr5[0];
                            long j12 = iArr5[1];
                            int i44 = (i41 - (i43 - 61)) - 31;
                            long j13 = i26;
                            i9 = (int) (((j13 * j11) + ((j13 * j12) >> 31)) >> i44);
                            long j14 = i27;
                            int i45 = (int) (((j14 * j11) + ((j14 * j12) >> 31)) >> i44);
                            long j15 = i28;
                            i10 = (int) (((j11 * j15) + ((j15 * j12) >> 31)) >> i44);
                            if (i41 == 0 || (i45 - 1) / 10 > i10 / 10) {
                                i11 = 0;
                            } else {
                                int i46 = i42 + 1;
                                int i47 = (i41 - 1) - ((i46 == 0 ? 1 : (int) (((i46 * 23219280) + 9999999) / 10000000)) - 61);
                                int[] iArr6 = iArr4[i46];
                                i11 = (int) ((((iArr6[0] * j13) + ((iArr6[1] * j13) >> 31)) >> (i47 - 31)) % 10);
                            }
                            i12 = i41 + i29;
                            z6 = 1 >= i41;
                            z7 = i41 < 23 && (((1 << (i41 + (-1))) - 1) & i26) == 0;
                            i13 = (i28 % 2 == 1 ? 0 : 1) >= i41 ? 1 : 0;
                            i14 = i11;
                            i15 = i45;
                        }
                        int i48 = 1000000000;
                        int i49 = i8;
                        while (i49 > 0 && i15 < i48) {
                            i48 /= 10;
                            i49--;
                        }
                        int i50 = i12 + i49;
                        int i51 = i50 - 1;
                        int i52 = (i51 < -3 || i51 >= 7) ? 1 : i7;
                        if (z6 && !z9) {
                            i15--;
                        }
                        int i53 = i7;
                        while (true) {
                            int i54 = i15 / 10;
                            int i55 = i10 / 10;
                            if (i54 <= i55 || (i15 < 100 && i52 != 0)) {
                                break;
                            }
                            i13 &= i10 % 10 == 0 ? 1 : i7;
                            i14 = i9 % 10;
                            i9 /= 10;
                            i53++;
                            i15 = i54;
                            i10 = i55;
                        }
                        if (i13 != 0 && z9) {
                            while (i10 % 10 == 0 && (i15 >= 100 || i52 == 0)) {
                                i15 /= 10;
                                i14 = i9 % 10;
                                i9 /= 10;
                                i10 /= 10;
                                i53++;
                            }
                        }
                        int i56 = i9;
                        if (z7 && i14 == 5 && i56 % 2 == 0) {
                            i14 = 4;
                        }
                        int i57 = i56 + (((i56 != i10 || (i13 != 0 && z9)) && i14 < 5) ? i7 : 1);
                        int i58 = i49 - i53;
                        if (z5) {
                            i16 = i5 + 1;
                            cArr[i5] = c7;
                        } else {
                            i16 = i5;
                        }
                        if (i52 != 0) {
                            for (int i59 = i7; i59 < i58 - 1; i59++) {
                                int i60 = i57 % 10;
                                i57 /= 10;
                                cArr[(i16 + i58) - i59] = (char) (i60 + 48);
                            }
                            cArr[i16] = (char) ((i57 % 10) + 48);
                            cArr[i16 + 1] = '.';
                            int i61 = i16 + i58 + 1;
                            if (i58 == 1) {
                                cArr[i61] = c6;
                                i61++;
                            }
                            int i62 = i61 + 1;
                            cArr[i61] = 'E';
                            if (i51 < 0) {
                                cArr[i62] = c7;
                                i51 = -i51;
                                i62 = i61 + 2;
                            }
                            if (i51 >= i8) {
                                cArr[i62] = (char) ((i51 / 10) + 48);
                                i62++;
                            }
                            i17 = i62 + 1;
                            cArr[i62] = (char) ((i51 % 10) + 48);
                        } else if (i51 < 0) {
                            int i63 = i16 + 1;
                            cArr[i16] = c6;
                            int i64 = i16 + 2;
                            cArr[i63] = '.';
                            int i65 = -1;
                            while (i65 > i51) {
                                cArr[i64] = c6;
                                i65--;
                                i64++;
                            }
                            int i66 = i64;
                            for (int i67 = i7; i67 < i58; i67++) {
                                cArr[((i64 + i58) - i67) - 1] = (char) ((i57 % 10) + 48);
                                i57 /= 10;
                                i66++;
                            }
                            i17 = i66;
                        } else if (i50 >= i58) {
                            for (int i68 = i7; i68 < i58; i68++) {
                                cArr[((i16 + i58) - i68) - 1] = (char) ((i57 % 10) + 48);
                                i57 /= 10;
                            }
                            int i69 = i16 + i58;
                            while (i58 < i50) {
                                cArr[i69] = c6;
                                i58++;
                                i69++;
                            }
                            cArr[i69] = '.';
                            i17 = i69 + 2;
                            cArr[i69 + 1] = c6;
                        } else {
                            int i70 = i16 + 1;
                            for (int i71 = i7; i71 < i58; i71++) {
                                if ((i58 - i71) - 1 == i51) {
                                    cArr[((i70 + i58) - i71) - 1] = '.';
                                    i70--;
                                }
                                cArr[((i70 + i58) - i71) - 1] = (char) ((i57 % 10) + 48);
                                i57 /= 10;
                            }
                            i17 = i58 + 1 + i16;
                        }
                        return i17 - i5;
                    }
                    cArr[i5] = '-';
                    cArr[i5 + 1] = '0';
                    cArr[i5 + 2] = '.';
                    i22 = i5 + 4;
                    cArr[i5 + 3] = '0';
                }
            }
            return i22 - i5;
        }
        cArr[i5] = 'N';
        cArr[i5 + 1] = 'a';
        i23 = i5 + 3;
        cArr[i5 + 2] = 'N';
        return i23 - i5;
    }

    public static String b(float f5) {
        char[] cArr = new char[15];
        return new String(cArr, 0, a(f5, cArr, 0));
    }
}
