package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410ValidationParameters;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes.dex */
public class GOST3410ParametersGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private SecureRandom init_random;
    private int size;
    private int typeproc;

    private int procedure_A(int i8, int i9, BigInteger[] bigIntegerArr, int i10) {
        int i11;
        BigInteger bigInteger;
        BigInteger[] bigIntegerArr2;
        int i12;
        BigInteger[] bigIntegerArr3;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        int iNextInt = i8;
        while (true) {
            if (iNextInt >= 0 && iNextInt <= 65536) {
                break;
            }
            iNextInt = this.init_random.nextInt() / 32768;
        }
        int iNextInt2 = i9;
        while (true) {
            i11 = 1;
            if (iNextInt2 >= 0 && iNextInt2 <= 65536 && iNextInt2 / 2 != 0) {
                break;
            }
            iNextInt2 = (this.init_random.nextInt() / 32768) + 1;
        }
        BigInteger bigInteger4 = new BigInteger(Integer.toString(iNextInt2));
        BigInteger bigInteger5 = new BigInteger("19381");
        BigInteger bigInteger6 = new BigInteger(Integer.toString(iNextInt));
        int i13 = 0;
        BigInteger[] bigIntegerArr4 = {bigInteger6};
        int[] iArr = {i10};
        int i14 = 0;
        int i15 = 0;
        while (iArr[i14] >= 17) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            i15 = i14 + 1;
            iArr[i15] = iArr[i14] / 2;
            i14 = i15;
        }
        BigInteger[] bigIntegerArr5 = new BigInteger[i15 + 1];
        int i16 = 16;
        bigIntegerArr5[i15] = new BigInteger("8003", 16);
        int i17 = i15 - 1;
        int i18 = 0;
        while (true) {
            if (i18 >= i15) {
                bigInteger = bigIntegerArr4[i13];
                break;
            }
            int i19 = iArr[i17] / i16;
            while (true) {
                int length2 = bigIntegerArr4.length;
                BigInteger[] bigIntegerArr6 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr4, i13, bigIntegerArr6, i13, bigIntegerArr4.length);
                bigIntegerArr2 = new BigInteger[i19 + 1];
                System.arraycopy(bigIntegerArr6, i13, bigIntegerArr2, i13, length2);
                int i20 = i13;
                while (i20 < i19) {
                    int i21 = i20 + 1;
                    bigIntegerArr2[i21] = bigIntegerArr2[i20].multiply(bigInteger5).add(bigInteger4).mod(TWO.pow(i16));
                    i20 = i21;
                }
                BigInteger bigInteger7 = new BigInteger("0");
                int i22 = i13;
                while (i22 < i19) {
                    bigInteger7 = bigInteger7.add(bigIntegerArr2[i22].multiply(TWO.pow(i22 * 16)));
                    i22++;
                    i13 = i13;
                }
                i12 = i13;
                bigIntegerArr2[i12] = bigIntegerArr2[i19];
                BigInteger bigInteger8 = TWO;
                int i23 = i17 + 1;
                BigInteger bigIntegerAdd = bigInteger8.pow(iArr[i17] - i11).divide(bigIntegerArr5[i23]).add(bigInteger8.pow(iArr[i17] - i11).multiply(bigInteger7).divide(bigIntegerArr5[i23].multiply(bigInteger8.pow(i19 * 16))));
                BigInteger bigIntegerMod = bigIntegerAdd.mod(bigInteger8);
                BigInteger bigInteger9 = ONE;
                if (bigIntegerMod.compareTo(bigInteger9) == 0) {
                    bigIntegerAdd = bigIntegerAdd.add(bigInteger9);
                }
                BigInteger bigInteger10 = bigIntegerAdd;
                int i24 = i12;
                while (true) {
                    bigIntegerArr3 = bigIntegerArr5;
                    long j4 = i24;
                    BigInteger bigIntegerMultiply = bigIntegerArr5[i23].multiply(bigInteger10.add(BigInteger.valueOf(j4)));
                    BigInteger bigInteger11 = ONE;
                    BigInteger bigIntegerAdd2 = bigIntegerMultiply.add(bigInteger11);
                    bigIntegerArr3[i17] = bigIntegerAdd2;
                    bigInteger2 = bigInteger4;
                    BigInteger bigInteger12 = TWO;
                    bigInteger3 = bigInteger5;
                    if (bigIntegerAdd2.compareTo(bigInteger12.pow(iArr[i17])) != 1) {
                        if (bigInteger12.modPow(bigIntegerArr3[i23].multiply(bigInteger10.add(BigInteger.valueOf(j4))), bigIntegerArr3[i17]).compareTo(bigInteger11) == 0 && bigInteger12.modPow(bigInteger10.add(BigInteger.valueOf(j4)), bigIntegerArr3[i17]).compareTo(bigInteger11) != 0) {
                            break;
                        }
                        i24 += 2;
                        bigIntegerArr5 = bigIntegerArr3;
                        bigInteger4 = bigInteger2;
                        bigInteger5 = bigInteger3;
                    } else {
                        break;
                    }
                }
                i13 = i12;
                i11 = 1;
                bigIntegerArr5 = bigIntegerArr3;
                bigIntegerArr4 = bigIntegerArr2;
                bigInteger4 = bigInteger2;
                bigInteger5 = bigInteger3;
                i16 = 16;
            }
            i17--;
            if (i17 < 0) {
                bigIntegerArr[i12] = bigIntegerArr3[i12];
                bigIntegerArr[1] = bigIntegerArr3[1];
                bigInteger = bigIntegerArr2[i12];
                break;
            }
            i18++;
            i11 = 1;
            i16 = 16;
            i13 = i12;
            bigIntegerArr5 = bigIntegerArr3;
            bigIntegerArr4 = bigIntegerArr2;
            bigInteger4 = bigInteger2;
            bigInteger5 = bigInteger3;
        }
        return bigInteger.intValue();
    }

    private long procedure_Aa(long j4, long j8, BigInteger[] bigIntegerArr, int i8) {
        int i9;
        BigInteger bigInteger;
        BigInteger[] bigIntegerArr2;
        int i10;
        BigInteger bigInteger2;
        int[] iArr;
        long jNextInt = j4;
        while (true) {
            if (jNextInt >= 0 && jNextInt <= 4294967296L) {
                break;
            }
            jNextInt = this.init_random.nextInt() * 2;
        }
        long jNextInt2 = j8;
        while (true) {
            i9 = 1;
            if (jNextInt2 >= 0 && jNextInt2 <= 4294967296L && jNextInt2 / 2 != 0) {
                break;
            }
            jNextInt2 = (this.init_random.nextInt() * 2) + 1;
        }
        BigInteger bigInteger3 = new BigInteger(Long.toString(jNextInt2));
        BigInteger bigInteger4 = new BigInteger("97781173");
        BigInteger bigInteger5 = new BigInteger(Long.toString(jNextInt));
        int i11 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger5};
        int[] iArr2 = {i8};
        int i12 = 0;
        int i13 = 0;
        while (iArr2[i12] >= 33) {
            int length = iArr2.length + 1;
            int[] iArr3 = new int[length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = new int[length];
            System.arraycopy(iArr3, 0, iArr2, 0, length);
            i13 = i12 + 1;
            iArr2[i13] = iArr2[i12] / 2;
            i12 = i13;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[i13 + 1];
        bigIntegerArr4[i13] = new BigInteger("8000000B", 16);
        int i14 = i13 - 1;
        int i15 = 0;
        while (true) {
            if (i15 >= i13) {
                bigInteger = bigIntegerArr3[i11];
                break;
            }
            int i16 = 32;
            int i17 = iArr2[i14] / 32;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i11, bigIntegerArr5, i11, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[i17 + 1];
                System.arraycopy(bigIntegerArr5, i11, bigIntegerArr2, i11, length2);
                int i18 = i11;
                while (i18 < i17) {
                    int i19 = i18 + 1;
                    bigIntegerArr2[i19] = bigIntegerArr2[i18].multiply(bigInteger4).add(bigInteger3).mod(TWO.pow(i16));
                    i18 = i19;
                }
                BigInteger bigInteger6 = new BigInteger("0");
                int i20 = i11;
                while (i20 < i17) {
                    bigInteger6 = bigInteger6.add(bigIntegerArr2[i20].multiply(TWO.pow(i20 * 32)));
                    i20++;
                    i11 = i11;
                }
                i10 = i11;
                bigIntegerArr2[i10] = bigIntegerArr2[i17];
                BigInteger bigInteger7 = TWO;
                int i21 = i14 + 1;
                BigInteger bigIntegerAdd = bigInteger7.pow(iArr2[i14] - i9).divide(bigIntegerArr4[i21]).add(bigInteger7.pow(iArr2[i14] - i9).multiply(bigInteger6).divide(bigIntegerArr4[i21].multiply(bigInteger7.pow(i17 * 32))));
                BigInteger bigIntegerMod = bigIntegerAdd.mod(bigInteger7);
                BigInteger bigInteger8 = ONE;
                if (bigIntegerMod.compareTo(bigInteger8) == 0) {
                    bigIntegerAdd = bigIntegerAdd.add(bigInteger8);
                }
                BigInteger bigInteger9 = bigIntegerAdd;
                int i22 = i10;
                while (true) {
                    long j9 = i22;
                    BigInteger bigIntegerMultiply = bigIntegerArr4[i21].multiply(bigInteger9.add(BigInteger.valueOf(j9)));
                    BigInteger bigInteger10 = ONE;
                    BigInteger bigIntegerAdd2 = bigIntegerMultiply.add(bigInteger10);
                    bigIntegerArr4[i14] = bigIntegerAdd2;
                    bigInteger2 = bigInteger3;
                    BigInteger bigInteger11 = TWO;
                    iArr = iArr2;
                    if (bigIntegerAdd2.compareTo(bigInteger11.pow(iArr[i14])) != 1) {
                        if (bigInteger11.modPow(bigIntegerArr4[i21].multiply(bigInteger9.add(BigInteger.valueOf(j9))), bigIntegerArr4[i14]).compareTo(bigInteger10) == 0 && bigInteger11.modPow(bigInteger9.add(BigInteger.valueOf(j9)), bigIntegerArr4[i14]).compareTo(bigInteger10) != 0) {
                            break;
                        }
                        i22 += 2;
                        bigInteger3 = bigInteger2;
                        iArr2 = iArr;
                    } else {
                        break;
                    }
                }
                i11 = i10;
                bigInteger3 = bigInteger2;
                iArr2 = iArr;
                i9 = 1;
                bigIntegerArr3 = bigIntegerArr2;
                i16 = 32;
            }
            i14--;
            if (i14 < 0) {
                bigIntegerArr[i10] = bigIntegerArr4[i10];
                bigIntegerArr[1] = bigIntegerArr4[1];
                bigInteger = bigIntegerArr2[i10];
                break;
            }
            i15++;
            i9 = 1;
            i11 = i10;
            bigInteger3 = bigInteger2;
            iArr2 = iArr;
            bigIntegerArr3 = bigIntegerArr2;
        }
        return bigInteger.longValue();
    }

    private void procedure_B(int i8, int i9, BigInteger[] bigIntegerArr) {
        int i10;
        int iNextInt = i8;
        while (true) {
            if (iNextInt >= 0 && iNextInt <= 65536) {
                break;
            } else {
                iNextInt = this.init_random.nextInt() / 32768;
            }
        }
        int iNextInt2 = i9;
        while (true) {
            i10 = 1;
            if (iNextInt2 >= 0 && iNextInt2 <= 65536 && iNextInt2 / 2 != 0) {
                break;
            } else {
                iNextInt2 = (this.init_random.nextInt() / 32768) + 1;
            }
        }
        BigInteger[] bigIntegerArr2 = new BigInteger[2];
        BigInteger bigInteger = new BigInteger(Integer.toString(iNextInt2));
        BigInteger bigInteger2 = new BigInteger("19381");
        int iProcedure_A = procedure_A(iNextInt, iNextInt2, bigIntegerArr2, 256);
        BigInteger bigInteger3 = bigIntegerArr2[0];
        int iProcedure_A2 = procedure_A(iProcedure_A, iNextInt2, bigIntegerArr2, 512);
        BigInteger bigInteger4 = bigIntegerArr2[0];
        BigInteger[] bigIntegerArr3 = new BigInteger[65];
        bigIntegerArr3[0] = new BigInteger(Integer.toString(iProcedure_A2));
        while (true) {
            int i11 = 0;
            while (i11 < 64) {
                int i12 = i11 + 1;
                bigIntegerArr3[i12] = bigIntegerArr3[i11].multiply(bigInteger2).add(bigInteger).mod(TWO.pow(16));
                i11 = i12;
            }
            BigInteger bigInteger5 = new BigInteger("0");
            for (int i13 = 0; i13 < 64; i13++) {
                bigInteger5 = bigInteger5.add(bigIntegerArr3[i13].multiply(TWO.pow(i13 * 16)));
            }
            bigIntegerArr3[0] = bigIntegerArr3[64];
            BigInteger bigInteger6 = TWO;
            BigInteger bigIntegerAdd = bigInteger6.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(bigInteger6.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.pow(1024))));
            BigInteger bigIntegerMod = bigIntegerAdd.mod(bigInteger6);
            BigInteger bigInteger7 = ONE;
            if (bigIntegerMod.compareTo(bigInteger7) == 0) {
                bigIntegerAdd = bigIntegerAdd.add(bigInteger7);
            }
            BigInteger bigInteger8 = bigIntegerAdd;
            int i14 = 0;
            while (true) {
                long j4 = i14;
                BigInteger bigIntegerMultiply = bigInteger3.multiply(bigInteger4).multiply(bigInteger8.add(BigInteger.valueOf(j4)));
                BigInteger bigInteger9 = ONE;
                BigInteger bigIntegerAdd2 = bigIntegerMultiply.add(bigInteger9);
                BigInteger bigInteger10 = TWO;
                if (bigIntegerAdd2.compareTo(bigInteger10.pow(1024)) == i10) {
                    break;
                }
                int i15 = i10;
                if (bigInteger10.modPow(bigInteger3.multiply(bigInteger4).multiply(bigInteger8.add(BigInteger.valueOf(j4))), bigIntegerAdd2).compareTo(bigInteger9) == 0 && bigInteger10.modPow(bigInteger3.multiply(bigInteger8.add(BigInteger.valueOf(j4))), bigIntegerAdd2).compareTo(bigInteger9) != 0) {
                    bigIntegerArr[0] = bigIntegerAdd2;
                    bigIntegerArr[i15] = bigInteger3;
                    return;
                } else {
                    i14 += 2;
                    i10 = i15;
                }
            }
        }
    }

    private void procedure_Bb(long j4, long j8, BigInteger[] bigIntegerArr) {
        int i8;
        long jNextInt = j4;
        while (true) {
            if (jNextInt >= 0 && jNextInt <= 4294967296L) {
                break;
            } else {
                jNextInt = this.init_random.nextInt() * 2;
            }
        }
        long jNextInt2 = j8;
        while (true) {
            i8 = 1;
            if (jNextInt2 >= 0 && jNextInt2 <= 4294967296L && jNextInt2 / 2 != 0) {
                break;
            }
            long j9 = jNextInt;
            jNextInt2 = (this.init_random.nextInt() * 2) + 1;
            jNextInt = j9;
        }
        BigInteger[] bigIntegerArr2 = new BigInteger[2];
        BigInteger bigInteger = new BigInteger(Long.toString(jNextInt2));
        BigInteger bigInteger2 = new BigInteger("97781173");
        long jProcedure_Aa = procedure_Aa(jNextInt, jNextInt2, bigIntegerArr2, 256);
        BigInteger bigInteger3 = bigIntegerArr2[0];
        long jProcedure_Aa2 = procedure_Aa(jProcedure_Aa, jNextInt2, bigIntegerArr2, 512);
        BigInteger bigInteger4 = bigIntegerArr2[0];
        BigInteger[] bigIntegerArr3 = new BigInteger[33];
        bigIntegerArr3[0] = new BigInteger(Long.toString(jProcedure_Aa2));
        while (true) {
            int i9 = 0;
            while (i9 < 32) {
                int i10 = i9 + 1;
                bigIntegerArr3[i10] = bigIntegerArr3[i9].multiply(bigInteger2).add(bigInteger).mod(TWO.pow(32));
                i9 = i10;
            }
            BigInteger bigInteger5 = new BigInteger("0");
            for (int i11 = 0; i11 < 32; i11++) {
                bigInteger5 = bigInteger5.add(bigIntegerArr3[i11].multiply(TWO.pow(i11 * 32)));
            }
            bigIntegerArr3[0] = bigIntegerArr3[32];
            BigInteger bigInteger6 = TWO;
            BigInteger bigIntegerAdd = bigInteger6.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(bigInteger6.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.pow(1024))));
            BigInteger bigIntegerMod = bigIntegerAdd.mod(bigInteger6);
            BigInteger bigInteger7 = ONE;
            if (bigIntegerMod.compareTo(bigInteger7) == 0) {
                bigIntegerAdd = bigIntegerAdd.add(bigInteger7);
            }
            int i12 = 0;
            while (true) {
                long j10 = i12;
                BigInteger bigIntegerMultiply = bigInteger3.multiply(bigInteger4).multiply(bigIntegerAdd.add(BigInteger.valueOf(j10)));
                BigInteger bigInteger8 = ONE;
                BigInteger bigIntegerAdd2 = bigIntegerMultiply.add(bigInteger8);
                BigInteger bigInteger9 = TWO;
                if (bigIntegerAdd2.compareTo(bigInteger9.pow(1024)) == i8) {
                    break;
                }
                int i13 = i8;
                if (bigInteger9.modPow(bigInteger3.multiply(bigInteger4).multiply(bigIntegerAdd.add(BigInteger.valueOf(j10))), bigIntegerAdd2).compareTo(bigInteger8) == 0 && bigInteger9.modPow(bigInteger3.multiply(bigIntegerAdd.add(BigInteger.valueOf(j10))), bigIntegerAdd2).compareTo(bigInteger8) != 0) {
                    bigIntegerArr[0] = bigIntegerAdd2;
                    bigIntegerArr[i13] = bigInteger3;
                    return;
                } else {
                    i12 += 2;
                    i8 = i13;
                }
            }
        }
    }

    private BigInteger procedure_C(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerSubtract = bigInteger.subtract(ONE);
        BigInteger bigIntegerDivide = bigIntegerSubtract.divide(bigInteger2);
        int iBitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, this.init_random);
            BigInteger bigInteger3 = ONE;
            if (bigIntegerCreateRandomBigInteger.compareTo(bigInteger3) > 0 && bigIntegerCreateRandomBigInteger.compareTo(bigIntegerSubtract) < 0) {
                BigInteger bigIntegerModPow = bigIntegerCreateRandomBigInteger.modPow(bigIntegerDivide, bigInteger);
                if (bigIntegerModPow.compareTo(bigInteger3) != 0) {
                    return bigIntegerModPow;
                }
            }
        }
    }

    public GOST3410Parameters generateParameters() {
        GOST3410ParametersGenerator gOST3410ParametersGenerator;
        long j4;
        long j8;
        BigInteger[] bigIntegerArr = new BigInteger[2];
        if (this.typeproc == 1) {
            int iNextInt = this.init_random.nextInt();
            int iNextInt2 = this.init_random.nextInt();
            int i8 = this.size;
            if (i8 == 512) {
                procedure_A(iNextInt, iNextInt2, bigIntegerArr, 512);
            } else {
                if (i8 != 1024) {
                    throw new IllegalArgumentException("Ooops! key size 512 or 1024 bit.");
                }
                procedure_B(iNextInt, iNextInt2, bigIntegerArr);
            }
            BigInteger bigInteger = bigIntegerArr[0];
            BigInteger bigInteger2 = bigIntegerArr[1];
            return new GOST3410Parameters(bigInteger, bigInteger2, procedure_C(bigInteger, bigInteger2), new GOST3410ValidationParameters(iNextInt, iNextInt2));
        }
        long jNextLong = this.init_random.nextLong();
        long jNextLong2 = this.init_random.nextLong();
        int i9 = this.size;
        if (i9 == 512) {
            gOST3410ParametersGenerator = this;
            j4 = jNextLong;
            j8 = jNextLong2;
            gOST3410ParametersGenerator.procedure_Aa(j4, j8, bigIntegerArr, 512);
        } else {
            if (i9 != 1024) {
                throw new IllegalStateException("Ooops! key size 512 or 1024 bit.");
            }
            gOST3410ParametersGenerator = this;
            j4 = jNextLong;
            j8 = jNextLong2;
            gOST3410ParametersGenerator.procedure_Bb(j4, j8, bigIntegerArr);
        }
        BigInteger bigInteger3 = bigIntegerArr[0];
        BigInteger bigInteger4 = bigIntegerArr[1];
        return new GOST3410Parameters(bigInteger3, bigInteger4, gOST3410ParametersGenerator.procedure_C(bigInteger3, bigInteger4), new GOST3410ValidationParameters(j4, j8));
    }

    public void init(int i8, int i9, SecureRandom secureRandom) {
        this.size = i8;
        this.typeproc = i9;
        this.init_random = secureRandom;
    }
}
