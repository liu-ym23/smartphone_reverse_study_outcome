package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.math.BigInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class FftMultiplier {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FFT_THRESHOLD = 33220;
    private static final int MAX_MAG_LENGTH = 67108864;
    private static final int ROOTS3_CACHE_SIZE = 20;
    private static final int ROOTS_CACHE2_SIZE = 20;
    private static final int TOOM_COOK_THRESHOLD = 1920;
    public static final double COS_0_25 = Math.cos(0.7853981633974483d);
    public static final double SIN_0_25 = Math.sin(0.7853981633974483d);
    private static volatile ComplexVector[] ROOTS2_CACHE = new ComplexVector[20];
    private static volatile ComplexVector[] ROOTS3_CACHE = new ComplexVector[20];

    public static int bitsPerFftPoint(int i) {
        if (i <= 9728) {
            return 19;
        }
        if (i <= 18432) {
            return 18;
        }
        if (i <= 69632) {
            return 17;
        }
        if (i <= 262144) {
            return 16;
        }
        if (i <= 983040) {
            return 15;
        }
        if (i <= 3670016) {
            return 14;
        }
        if (i <= 13631488) {
            return 13;
        }
        if (i <= 25165824) {
            return 12;
        }
        if (i <= 92274688) {
            return 11;
        }
        if (i <= 335544320) {
            return 10;
        }
        return i <= 1207959552 ? 9 : 8;
    }

    private static ComplexVector calculateRootsOfUnity(int i) {
        if (i == 1) {
            ComplexVector complexVector = new ComplexVector(1);
            complexVector.real(0, 1.0d);
            complexVector.imag(0, 0.0d);
            return complexVector;
        }
        ComplexVector complexVector2 = new ComplexVector(i);
        complexVector2.set(0, 1.0d, 0.0d);
        int i3 = i / 2;
        complexVector2.set(i3, COS_0_25, SIN_0_25);
        double d7 = 1.5707963267948966d / i;
        int i10 = 1;
        while (i10 < i3) {
            double d10 = i10 * d7;
            double dCos = Math.cos(d10);
            double dSin = Math.sin(d10);
            complexVector2.set(i10, dCos, dSin);
            int i11 = i10;
            complexVector2.set(i - i11, dSin, dCos);
            i10 = i11 + 1;
        }
        return complexVector2;
    }

    private static void fft(ComplexVector complexVector, ComplexVector[] complexVectorArr) {
        int i = complexVector.length;
        int iNumberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i);
        MutableComplex mutableComplex = new MutableComplex();
        MutableComplex mutableComplex2 = new MutableComplex();
        MutableComplex mutableComplex3 = new MutableComplex();
        MutableComplex mutableComplex4 = new MutableComplex();
        MutableComplex mutableComplex5 = new MutableComplex();
        MutableComplex mutableComplex6 = new MutableComplex();
        while (iNumberOfLeadingZeros >= 2) {
            ComplexVector complexVector2 = complexVectorArr[iNumberOfLeadingZeros - 2];
            int i3 = 1 << iNumberOfLeadingZeros;
            for (int i10 = 0; i10 < i; i10 += i3) {
                int i11 = 0;
                while (true) {
                    int i12 = i3 / 4;
                    if (i11 < i12) {
                        mutableComplex5.set(complexVector2, i11);
                        mutableComplex5.squareInto(mutableComplex6);
                        int i13 = i10 + i11;
                        int i14 = i12 + i13;
                        int i15 = (i3 / 2) + i13;
                        int i16 = iNumberOfLeadingZeros;
                        int i17 = ((i3 * 3) / 4) + i13;
                        complexVector.addInto(i13, complexVector, i14, mutableComplex);
                        mutableComplex.add(complexVector, i15);
                        mutableComplex.add(complexVector, i17);
                        complexVector.subtractTimesIInto(i13, complexVector, i14, mutableComplex2);
                        mutableComplex2.subtract(complexVector, i15);
                        mutableComplex2.addTimesI(complexVector, i17);
                        mutableComplex2.multiplyConjugate(mutableComplex5);
                        complexVector.subtractInto(i13, complexVector, i14, mutableComplex3);
                        mutableComplex3.add(complexVector, i15);
                        mutableComplex3.subtract(complexVector, i17);
                        mutableComplex3.multiplyConjugate(mutableComplex6);
                        complexVector.addTimesIInto(i13, complexVector, i14, mutableComplex4);
                        mutableComplex4.subtract(complexVector, i15);
                        mutableComplex4.subtractTimesI(complexVector, i17);
                        mutableComplex4.multiply(mutableComplex5);
                        mutableComplex.copyInto(complexVector, i13);
                        mutableComplex2.copyInto(complexVector, i14);
                        mutableComplex3.copyInto(complexVector, i15);
                        mutableComplex4.copyInto(complexVector, i17);
                        i11++;
                        iNumberOfLeadingZeros = i16;
                    }
                }
            }
            iNumberOfLeadingZeros -= 2;
        }
        if (iNumberOfLeadingZeros > 0) {
            for (int i18 = 0; i18 < i; i18 += 2) {
                complexVector.copyInto(i18, mutableComplex);
                int i19 = i18 + 1;
                complexVector.copyInto(i19, mutableComplex2);
                complexVector.add(i18, mutableComplex2);
                mutableComplex.subtractInto(mutableComplex2, complexVector, i19);
            }
        }
    }

    private static void fft3(ComplexVector complexVector, ComplexVector complexVector2, ComplexVector complexVector3, int i, double d7) {
        double dSqrt = Math.sqrt(3.0d) * i * (-0.5d);
        for (int i3 = 0; i3 < complexVector.length; i3++) {
            double dReal = complexVector.real(i3) + complexVector2.real(i3) + complexVector3.real(i3);
            double dImag = complexVector.imag(i3) + complexVector2.imag(i3) + complexVector3.imag(i3);
            double dImag2 = (complexVector3.imag(i3) - complexVector2.imag(i3)) * dSqrt;
            double dReal2 = (complexVector2.real(i3) - complexVector3.real(i3)) * dSqrt;
            double dReal3 = (complexVector2.real(i3) + complexVector3.real(i3)) * 0.5d;
            double dImag3 = (complexVector2.imag(i3) + complexVector3.imag(i3)) * 0.5d;
            double dReal4 = (complexVector.real(i3) - dReal3) + dImag2;
            double dImag4 = (complexVector.imag(i3) + dReal2) - dImag3;
            double dReal5 = (complexVector.real(i3) - dReal3) - dImag2;
            double dImag5 = (complexVector.imag(i3) - dReal2) - dImag3;
            complexVector.real(i3, dReal * d7);
            complexVector.imag(i3, dImag * d7);
            complexVector2.real(i3, dReal4 * d7);
            complexVector2.imag(i3, dImag4 * d7);
            complexVector3.real(i3, dReal5 * d7);
            complexVector3.imag(i3, dImag5 * d7);
        }
    }

    private static void fftMixedRadix(ComplexVector complexVector, ComplexVector[] complexVectorArr, ComplexVector complexVector2) {
        int i = complexVector.length / 3;
        ComplexVector complexVector3 = new ComplexVector(complexVector, 0, i);
        int i3 = i * 2;
        ComplexVector complexVector4 = new ComplexVector(complexVector, i, i3);
        ComplexVector complexVector5 = new ComplexVector(complexVector, i3, complexVector.length);
        fft3(complexVector3, complexVector4, complexVector5, 1, 1.0d);
        MutableComplex mutableComplex = new MutableComplex();
        for (int i10 = 0; i10 < complexVector.length / 4; i10++) {
            mutableComplex.set(complexVector2, i10);
            complexVector4.multiplyConjugate(i10, mutableComplex);
            complexVector5.multiplyConjugate(i10, mutableComplex);
            complexVector5.multiplyConjugate(i10, mutableComplex);
        }
        for (int i11 = complexVector.length / 4; i11 < i; i11++) {
            mutableComplex.set(complexVector2, i11 - (complexVector.length / 4));
            complexVector4.multiplyConjugateTimesI(i11, mutableComplex);
            complexVector5.multiplyConjugateTimesI(i11, mutableComplex);
            complexVector5.multiplyConjugateTimesI(i11, mutableComplex);
        }
        fft(complexVector3, complexVectorArr);
        fft(complexVector4, complexVectorArr);
        fft(complexVector5, complexVectorArr);
    }

    public static BigInteger fromFftVector(ComplexVector complexVector, int i, int i3) {
        int i10 = i3;
        long j10 = i10;
        int iMin = (int) Math.min(complexVector.length, (2147483648L / j10) + 1);
        int i11 = (int) ((((iMin * j10) + 31) * 8) / 32);
        byte[] bArr = new byte[i11];
        int i12 = 1;
        int i13 = (1 << i10) - 1;
        int i14 = 32 - i10;
        int i15 = (i11 * 8) - i10;
        int i16 = 0;
        int i17 = i11 - 4;
        int iMin2 = Math.min(Math.max(0, i15 >> 3), i17);
        long j11 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i18 <= i12) {
            int i20 = i16;
            while (i20 < iMin) {
                long jRound = Math.round(complexVector.part(i20, i18)) + j11;
                long j12 = jRound >> i10;
                int iMin3 = Math.min(Math.max(i16, i15 >> 3), i17);
                i19 = (int) (((jRound & i13) << ((i14 - i15) + (iMin3 << 3))) | (i19 >>> ((iMin2 - iMin3) << 3)));
                FastDoubleSwar.writeIntBE(bArr, iMin3, i19);
                i15 -= i3;
                i20++;
                i10 = i3;
                iMin2 = iMin3;
                j11 = j12;
                iMin = iMin;
                i16 = 0;
            }
            i18++;
            i10 = i3;
            i12 = 1;
            i16 = 0;
        }
        return new BigInteger(i, bArr);
    }

    private static ComplexVector[] getRootsOfUnity2(int i) {
        ComplexVector[] complexVectorArr = new ComplexVector[i + 1];
        while (i >= 0) {
            if (i < 20) {
                if (ROOTS2_CACHE[i] == null) {
                    ROOTS2_CACHE[i] = calculateRootsOfUnity(1 << i);
                }
                complexVectorArr[i] = ROOTS2_CACHE[i];
            } else {
                complexVectorArr[i] = calculateRootsOfUnity(1 << i);
            }
            i -= 2;
        }
        return complexVectorArr;
    }

    private static ComplexVector getRootsOfUnity3(int i) {
        if (i >= 20) {
            return calculateRootsOfUnity(3 << i);
        }
        if (ROOTS3_CACHE[i] == null) {
            ROOTS3_CACHE[i] = calculateRootsOfUnity(3 << i);
        }
        return ROOTS3_CACHE[i];
    }

    private static void ifft(ComplexVector complexVector, ComplexVector[] complexVectorArr) {
        int i;
        int i3;
        int i10 = complexVector.length;
        int iNumberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i10);
        MutableComplex mutableComplex = new MutableComplex();
        MutableComplex mutableComplex2 = new MutableComplex();
        MutableComplex mutableComplex3 = new MutableComplex();
        MutableComplex mutableComplex4 = new MutableComplex();
        MutableComplex mutableComplex5 = new MutableComplex();
        MutableComplex mutableComplex6 = new MutableComplex();
        MutableComplex mutableComplex7 = new MutableComplex();
        MutableComplex mutableComplex8 = new MutableComplex();
        int i11 = 1;
        if (iNumberOfLeadingZeros % 2 != 0) {
            for (int i12 = 0; i12 < i10; i12 += 2) {
                int i13 = i12 + 1;
                complexVector.copyInto(i13, mutableComplex3);
                complexVector.copyInto(i12, mutableComplex);
                complexVector.add(i12, mutableComplex3);
                mutableComplex.subtractInto(mutableComplex3, complexVector, i13);
            }
            i = 2;
        } else {
            i = 1;
        }
        MutableComplex mutableComplex9 = new MutableComplex();
        MutableComplex mutableComplex10 = new MutableComplex();
        while (i <= iNumberOfLeadingZeros) {
            ComplexVector complexVector2 = complexVectorArr[i - 1];
            int i14 = i11 << (i + 1);
            int i15 = 0;
            while (i15 < i10) {
                int i16 = i;
                int i17 = 0;
                while (true) {
                    i3 = i15;
                    int i18 = i14 / 4;
                    if (i17 < i18) {
                        mutableComplex9.set(complexVector2, i17);
                        mutableComplex9.squareInto(mutableComplex10);
                        int i19 = i17;
                        int i20 = i3 + i19;
                        int i21 = i18 + i20;
                        ComplexVector complexVector3 = complexVector2;
                        int i22 = (i14 / 2) + i20;
                        int i23 = iNumberOfLeadingZeros;
                        int i24 = ((i14 * 3) / 4) + i20;
                        complexVector.copyInto(i20, mutableComplex);
                        complexVector.multiplyInto(i21, mutableComplex9, mutableComplex2);
                        complexVector.multiplyInto(i22, mutableComplex10, mutableComplex3);
                        complexVector.multiplyConjugateInto(i24, mutableComplex9, mutableComplex4);
                        mutableComplex.addInto(mutableComplex2, mutableComplex5);
                        mutableComplex5.add(mutableComplex3);
                        mutableComplex5.add(mutableComplex4);
                        mutableComplex.addTimesIInto(mutableComplex2, mutableComplex6);
                        mutableComplex6.subtract(mutableComplex3);
                        mutableComplex6.subtractTimesI(mutableComplex4);
                        mutableComplex.subtractInto(mutableComplex2, mutableComplex7);
                        mutableComplex7.add(mutableComplex3);
                        mutableComplex7.subtract(mutableComplex4);
                        mutableComplex.subtractTimesIInto(mutableComplex2, mutableComplex8);
                        mutableComplex8.subtract(mutableComplex3);
                        mutableComplex8.addTimesI(mutableComplex4);
                        mutableComplex5.copyInto(complexVector, i20);
                        mutableComplex6.copyInto(complexVector, i21);
                        mutableComplex7.copyInto(complexVector, i22);
                        mutableComplex8.copyInto(complexVector, i24);
                        i17 = i19 + 1;
                        i15 = i3;
                        complexVector2 = complexVector3;
                        iNumberOfLeadingZeros = i23;
                    }
                }
                i15 = i3 + i14;
                i = i16;
            }
            i += 2;
            i11 = 1;
        }
        int i25 = iNumberOfLeadingZeros;
        for (int i26 = 0; i26 < i10; i26++) {
            complexVector.timesTwoToThe(i26, -i25);
        }
    }

    private static void ifftMixedRadix(ComplexVector complexVector, ComplexVector[] complexVectorArr, ComplexVector complexVector2) {
        int i = complexVector.length / 3;
        ComplexVector complexVector3 = new ComplexVector(complexVector, 0, i);
        int i3 = i * 2;
        ComplexVector complexVector4 = new ComplexVector(complexVector, i, i3);
        ComplexVector complexVector5 = new ComplexVector(complexVector, i3, complexVector.length);
        ifft(complexVector3, complexVectorArr);
        ifft(complexVector4, complexVectorArr);
        ifft(complexVector5, complexVectorArr);
        MutableComplex mutableComplex = new MutableComplex();
        for (int i10 = 0; i10 < complexVector.length / 4; i10++) {
            mutableComplex.set(complexVector2, i10);
            complexVector4.multiply(i10, mutableComplex);
            complexVector5.multiply(i10, mutableComplex);
            complexVector5.multiply(i10, mutableComplex);
        }
        for (int i11 = complexVector.length / 4; i11 < i; i11++) {
            mutableComplex.set(complexVector2, i11 - (complexVector.length / 4));
            complexVector4.multiplyByIAnd(i11, mutableComplex);
            complexVector5.multiplyByIAnd(i11, mutableComplex);
            complexVector5.multiplyByIAnd(i11, mutableComplex);
        }
        fft3(complexVector3, complexVector4, complexVector5, -1, 0.3333333333333333d);
    }

    public static BigInteger multiply(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger2.signum() == 0 || bigInteger.signum() == 0) {
            return BigInteger.ZERO;
        }
        if (bigInteger2 == bigInteger) {
            return square(bigInteger2);
        }
        int iBitLength = bigInteger.bitLength();
        int iBitLength2 = bigInteger2.bitLength();
        if (iBitLength + iBitLength2 <= 2147483648L) {
            return (iBitLength <= TOOM_COOK_THRESHOLD || iBitLength2 <= TOOM_COOK_THRESHOLD || (iBitLength <= FFT_THRESHOLD && iBitLength2 <= FFT_THRESHOLD)) ? bigInteger.multiply(bigInteger2) : multiplyFft(bigInteger, bigInteger2);
        }
        throw new ArithmeticException("BigInteger would overflow supported range");
    }

    public static BigInteger multiplyFft(BigInteger bigInteger, BigInteger bigInteger2) {
        int iSignum = bigInteger2.signum() * bigInteger.signum();
        if (bigInteger.signum() < 0) {
            bigInteger = bigInteger.negate();
        }
        byte[] byteArray = bigInteger.toByteArray();
        if (bigInteger2.signum() < 0) {
            bigInteger2 = bigInteger2.negate();
        }
        byte[] byteArray2 = bigInteger2.toByteArray();
        int iMax = Math.max(byteArray.length, byteArray2.length) * 8;
        int iBitsPerFftPoint = bitsPerFftPoint(iMax);
        int i = ((iMax + iBitsPerFftPoint) - 1) / iBitsPerFftPoint;
        int i3 = i + 1;
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
        int i10 = 32 - iNumberOfLeadingZeros;
        int i11 = 1 << i10;
        int i12 = (i11 * 3) / 4;
        if (i3 >= i12 || i10 <= 3) {
            ComplexVector[] rootsOfUnity2 = getRootsOfUnity2(i10);
            ComplexVector fftVector = toFftVector(byteArray, i11, iBitsPerFftPoint);
            fftVector.applyWeights(rootsOfUnity2[i10]);
            fft(fftVector, rootsOfUnity2);
            ComplexVector fftVector2 = toFftVector(byteArray2, i11, iBitsPerFftPoint);
            fftVector2.applyWeights(rootsOfUnity2[i10]);
            fft(fftVector2, rootsOfUnity2);
            fftVector.multiplyPointwise(fftVector2);
            ifft(fftVector, rootsOfUnity2);
            fftVector.applyInverseWeights(rootsOfUnity2[i10]);
            return fromFftVector(fftVector, iSignum, iBitsPerFftPoint);
        }
        int i13 = 30 - iNumberOfLeadingZeros;
        ComplexVector[] rootsOfUnity22 = getRootsOfUnity2(i13);
        ComplexVector rootsOfUnity3 = getRootsOfUnity3(i13);
        ComplexVector rootsOfUnity32 = getRootsOfUnity3(28 - iNumberOfLeadingZeros);
        ComplexVector fftVector3 = toFftVector(byteArray, i12, iBitsPerFftPoint);
        fftVector3.applyWeights(rootsOfUnity3);
        fftMixedRadix(fftVector3, rootsOfUnity22, rootsOfUnity32);
        ComplexVector fftVector4 = toFftVector(byteArray2, i12, iBitsPerFftPoint);
        fftVector4.applyWeights(rootsOfUnity3);
        fftMixedRadix(fftVector4, rootsOfUnity22, rootsOfUnity32);
        fftVector3.multiplyPointwise(fftVector4);
        ifftMixedRadix(fftVector3, rootsOfUnity22, rootsOfUnity32);
        fftVector3.applyInverseWeights(rootsOfUnity3);
        return fromFftVector(fftVector3, iSignum, iBitsPerFftPoint);
    }

    public static BigInteger square(BigInteger bigInteger) {
        return bigInteger.signum() == 0 ? BigInteger.ZERO : bigInteger.bitLength() < FFT_THRESHOLD ? bigInteger.multiply(bigInteger) : squareFft(bigInteger);
    }

    public static BigInteger squareFft(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length * 8;
        int iBitsPerFftPoint = bitsPerFftPoint(length);
        int i = ((length + iBitsPerFftPoint) - 1) / iBitsPerFftPoint;
        int i3 = i + 1;
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
        int i10 = 32 - iNumberOfLeadingZeros;
        int i11 = 1 << i10;
        int i12 = (i11 * 3) / 4;
        if (i3 >= i12) {
            ComplexVector fftVector = toFftVector(byteArray, i11, iBitsPerFftPoint);
            ComplexVector[] rootsOfUnity2 = getRootsOfUnity2(i10);
            fftVector.applyWeights(rootsOfUnity2[i10]);
            fft(fftVector, rootsOfUnity2);
            fftVector.squarePointwise();
            ifft(fftVector, rootsOfUnity2);
            fftVector.applyInverseWeights(rootsOfUnity2[i10]);
            return fromFftVector(fftVector, 1, iBitsPerFftPoint);
        }
        ComplexVector fftVector2 = toFftVector(byteArray, i12, iBitsPerFftPoint);
        int i13 = 30 - iNumberOfLeadingZeros;
        ComplexVector[] rootsOfUnity22 = getRootsOfUnity2(i13);
        ComplexVector rootsOfUnity3 = getRootsOfUnity3(i13);
        ComplexVector rootsOfUnity32 = getRootsOfUnity3(28 - iNumberOfLeadingZeros);
        fftVector2.applyWeights(rootsOfUnity3);
        fftMixedRadix(fftVector2, rootsOfUnity22, rootsOfUnity32);
        fftVector2.squarePointwise();
        ifftMixedRadix(fftVector2, rootsOfUnity22, rootsOfUnity32);
        fftVector2.applyInverseWeights(rootsOfUnity3);
        return fromFftVector(fftVector2, 1, iBitsPerFftPoint);
    }

    public static ComplexVector toFftVector(byte[] bArr, int i, int i3) {
        ComplexVector complexVector = new ComplexVector(i);
        if (bArr.length < 4) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 4 - bArr.length, bArr.length);
            bArr = bArr2;
        }
        int i10 = 1 << i3;
        int i11 = i10 / 2;
        int i12 = i10 - 1;
        int i13 = 32 - i3;
        int length = (bArr.length * 8) - i3;
        int intBE = 0;
        int i14 = 0;
        while (length > (-i3)) {
            int iMin = Math.min(Math.max(0, length >> 3), bArr.length - 4);
            intBE = (i11 - (((FastDoubleSwar.readIntBE(bArr, iMin) >>> ((i13 - length) + (iMin << 3))) & i12) + intBE)) >>> 31;
            complexVector.real(i14, r9 - ((-intBE) & i10));
            i14++;
            length -= i3;
        }
        if (intBE > 0) {
            complexVector.real(i14, intBE);
        }
        return complexVector;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ComplexVector {
        private static final int COMPLEX_SIZE_SHIFT = 1;
        static final int IMAG = 1;
        static final int REAL = 0;

        /* renamed from: a, reason: collision with root package name */
        private final double[] f2291a;
        private final int length;
        private final int offset;

        public ComplexVector(int i) {
            this.f2291a = new double[i << 1];
            this.length = i;
            this.offset = 0;
        }

        private int imagIdx(int i) {
            return (i << 1) + this.offset + 1;
        }

        private int realIdx(int i) {
            return (i << 1) + this.offset;
        }

        public void add(int i, MutableComplex mutableComplex) {
            double[] dArr = this.f2291a;
            int iRealIdx = realIdx(i);
            dArr[iRealIdx] = dArr[iRealIdx] + mutableComplex.real;
            double[] dArr2 = this.f2291a;
            int iImagIdx = imagIdx(i);
            dArr2[iImagIdx] = dArr2[iImagIdx] + mutableComplex.imag;
        }

        public void addInto(int i, ComplexVector complexVector, int i3, MutableComplex mutableComplex) {
            mutableComplex.real = this.f2291a[realIdx(i)] + complexVector.real(i3);
            mutableComplex.imag = this.f2291a[imagIdx(i)] + complexVector.imag(i3);
        }

        public void addTimesIInto(int i, ComplexVector complexVector, int i3, MutableComplex mutableComplex) {
            mutableComplex.real = this.f2291a[realIdx(i)] - complexVector.imag(i3);
            mutableComplex.imag = this.f2291a[imagIdx(i)] + complexVector.real(i3);
        }

        public void applyInverseWeights(ComplexVector complexVector) {
            int i = complexVector.offset;
            double[] dArr = complexVector.f2291a;
            int i3 = this.offset;
            int i10 = (this.length + i3) << 1;
            while (i3 < i10) {
                double[] dArr2 = this.f2291a;
                double d7 = dArr2[i3];
                int i11 = i3 + 1;
                double d10 = dArr2[i11];
                int i12 = i + 1;
                dArr2[i3] = FastDoubleSwar.fma(d7, dArr[i], dArr[i12] * d10);
                this.f2291a[i11] = FastDoubleSwar.fma(-d7, dArr[i12], d10 * dArr[i]);
                i += 2;
                i3 += 2;
            }
        }

        public void applyWeights(ComplexVector complexVector) {
            int i = complexVector.offset;
            double[] dArr = complexVector.f2291a;
            int i3 = this.offset;
            int i10 = (this.length + i3) << 1;
            while (i3 < i10) {
                double[] dArr2 = this.f2291a;
                double d7 = dArr2[i3];
                dArr2[i3] = dArr[i] * d7;
                dArr2[i3 + 1] = d7 * dArr[i + 1];
                i += 2;
                i3 += 2;
            }
        }

        public void copyInto(int i, MutableComplex mutableComplex) {
            mutableComplex.real = this.f2291a[realIdx(i)];
            mutableComplex.imag = this.f2291a[imagIdx(i)];
        }

        public double imag(int i) {
            return this.f2291a[(i << 1) + this.offset + 1];
        }

        public void multiply(int i, MutableComplex mutableComplex) {
            int iRealIdx = realIdx(i);
            int iImagIdx = imagIdx(i);
            double[] dArr = this.f2291a;
            double d7 = dArr[iRealIdx];
            double d10 = dArr[iImagIdx];
            dArr[iRealIdx] = FastDoubleSwar.fma(d7, mutableComplex.real, (-d10) * mutableComplex.imag);
            this.f2291a[iImagIdx] = FastDoubleSwar.fma(d7, mutableComplex.imag, d10 * mutableComplex.real);
        }

        public void multiplyByIAnd(int i, MutableComplex mutableComplex) {
            int iRealIdx = realIdx(i);
            int iImagIdx = imagIdx(i);
            double[] dArr = this.f2291a;
            double d7 = dArr[iRealIdx];
            double d10 = -dArr[iImagIdx];
            dArr[iRealIdx] = FastDoubleSwar.fma(-d7, mutableComplex.imag, mutableComplex.real * d10);
            this.f2291a[iImagIdx] = FastDoubleSwar.fma(d7, mutableComplex.real, mutableComplex.imag * d10);
        }

        public void multiplyConjugate(int i, MutableComplex mutableComplex) {
            int iRealIdx = realIdx(i);
            int iImagIdx = imagIdx(i);
            double[] dArr = this.f2291a;
            double d7 = dArr[iRealIdx];
            double d10 = dArr[iImagIdx];
            dArr[iRealIdx] = FastDoubleSwar.fma(d7, mutableComplex.real, mutableComplex.imag * d10);
            this.f2291a[iImagIdx] = FastDoubleSwar.fma(-d7, mutableComplex.imag, d10 * mutableComplex.real);
        }

        public void multiplyConjugateInto(int i, MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            double d7 = this.f2291a[realIdx(i)];
            double d10 = this.f2291a[imagIdx(i)];
            mutableComplex2.real = FastDoubleSwar.fma(d7, mutableComplex.real, d10 * mutableComplex.imag);
            mutableComplex2.imag = FastDoubleSwar.fma(-d7, mutableComplex.imag, d10 * mutableComplex.real);
        }

        public void multiplyConjugateTimesI(int i, MutableComplex mutableComplex) {
            int iRealIdx = realIdx(i);
            int iImagIdx = imagIdx(i);
            double[] dArr = this.f2291a;
            double d7 = dArr[iRealIdx];
            double d10 = dArr[iImagIdx];
            double d11 = -d7;
            dArr[iRealIdx] = FastDoubleSwar.fma(d11, mutableComplex.imag, d10 * mutableComplex.real);
            this.f2291a[iImagIdx] = FastDoubleSwar.fma(d11, mutableComplex.real, (-d10) * mutableComplex.imag);
        }

        public void multiplyInto(int i, MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            double d7 = this.f2291a[realIdx(i)];
            double d10 = this.f2291a[imagIdx(i)];
            mutableComplex2.real = FastDoubleSwar.fma(d7, mutableComplex.real, mutableComplex.imag * (-d10));
            mutableComplex2.imag = FastDoubleSwar.fma(d7, mutableComplex.imag, d10 * mutableComplex.real);
        }

        public void multiplyPointwise(ComplexVector complexVector) {
            int i = complexVector.offset;
            double[] dArr = complexVector.f2291a;
            int i3 = this.offset;
            int i10 = (this.length + i3) << 1;
            while (i3 < i10) {
                double[] dArr2 = this.f2291a;
                double d7 = dArr2[i3];
                int i11 = i3 + 1;
                double d10 = dArr2[i11];
                double d11 = dArr[i];
                double d12 = dArr[i + 1];
                dArr2[i3] = FastDoubleSwar.fma(d7, d11, (-d10) * d12);
                this.f2291a[i11] = FastDoubleSwar.fma(d7, d12, d10 * d11);
                i += 2;
                i3 += 2;
            }
        }

        public double part(int i, int i3) {
            return this.f2291a[(i << 1) + i3];
        }

        public double real(int i) {
            return this.f2291a[(i << 1) + this.offset];
        }

        public void set(int i, double d7, double d10) {
            int iRealIdx = realIdx(i);
            double[] dArr = this.f2291a;
            dArr[iRealIdx] = d7;
            dArr[iRealIdx + 1] = d10;
        }

        public void squarePointwise() {
            int i = this.offset;
            int i3 = (this.length + i) << 1;
            while (i < i3) {
                double[] dArr = this.f2291a;
                double d7 = dArr[i];
                int i10 = i + 1;
                double d10 = dArr[i10];
                dArr[i] = FastDoubleSwar.fma(d7, d7, (-d10) * d10);
                this.f2291a[i10] = d7 * 2.0d * d10;
                i += 2;
            }
        }

        public void subtractInto(int i, ComplexVector complexVector, int i3, MutableComplex mutableComplex) {
            mutableComplex.real = this.f2291a[realIdx(i)] - complexVector.real(i3);
            mutableComplex.imag = this.f2291a[imagIdx(i)] - complexVector.imag(i3);
        }

        public void subtractTimesIInto(int i, ComplexVector complexVector, int i3, MutableComplex mutableComplex) {
            mutableComplex.real = this.f2291a[realIdx(i)] + complexVector.imag(i3);
            mutableComplex.imag = this.f2291a[imagIdx(i)] - complexVector.real(i3);
        }

        public void timesTwoToThe(int i, int i3) {
            int iRealIdx = realIdx(i);
            int iImagIdx = imagIdx(i);
            double[] dArr = this.f2291a;
            double d7 = dArr[iRealIdx];
            double d10 = dArr[iImagIdx];
            long j10 = i3;
            dArr[iRealIdx] = FastDoubleMath.fastScalb(d7, j10);
            this.f2291a[iImagIdx] = FastDoubleMath.fastScalb(d10, j10);
        }

        public void real(int i, double d7) {
            this.f2291a[(i << 1) + this.offset] = d7;
        }

        public void imag(int i, double d7) {
            this.f2291a[(i << 1) + this.offset + 1] = d7;
        }

        public ComplexVector(ComplexVector complexVector, int i, int i3) {
            this.length = i3 - i;
            this.f2291a = complexVector.f2291a;
            this.offset = i << 1;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MutableComplex {
        double imag;
        double real;

        public void add(ComplexVector complexVector, int i) {
            this.real += complexVector.real(i);
            this.imag += complexVector.imag(i);
        }

        public void addInto(MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            mutableComplex2.real = this.real + mutableComplex.real;
            mutableComplex2.imag = this.imag + mutableComplex.imag;
        }

        public void addTimesI(ComplexVector complexVector, int i) {
            this.real -= complexVector.imag(i);
            this.imag += complexVector.real(i);
        }

        public void addTimesIInto(MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            mutableComplex2.real = this.real - mutableComplex.imag;
            mutableComplex2.imag = this.imag + mutableComplex.real;
        }

        public void copyInto(ComplexVector complexVector, int i) {
            complexVector.real(i, this.real);
            complexVector.imag(i, this.imag);
        }

        public void multiply(MutableComplex mutableComplex) {
            double d7 = this.real;
            this.real = FastDoubleSwar.fma(d7, mutableComplex.real, (-this.imag) * mutableComplex.imag);
            this.imag = FastDoubleSwar.fma(d7, mutableComplex.imag, this.imag * mutableComplex.real);
        }

        public void multiplyConjugate(MutableComplex mutableComplex) {
            double d7 = this.real;
            this.real = FastDoubleSwar.fma(d7, mutableComplex.real, this.imag * mutableComplex.imag);
            this.imag = FastDoubleSwar.fma(-d7, mutableComplex.imag, this.imag * mutableComplex.real);
        }

        public void set(ComplexVector complexVector, int i) {
            this.real = complexVector.real(i);
            this.imag = complexVector.imag(i);
        }

        public void squareInto(MutableComplex mutableComplex) {
            double d7 = this.real;
            double d10 = this.imag;
            mutableComplex.real = FastDoubleSwar.fma(d7, d7, (-d10) * d10);
            mutableComplex.imag = this.real * 2.0d * this.imag;
        }

        public void subtract(ComplexVector complexVector, int i) {
            this.real -= complexVector.real(i);
            this.imag -= complexVector.imag(i);
        }

        public void subtractInto(MutableComplex mutableComplex, ComplexVector complexVector, int i) {
            complexVector.real(i, this.real - mutableComplex.real);
            complexVector.imag(i, this.imag - mutableComplex.imag);
        }

        public void subtractTimesI(ComplexVector complexVector, int i) {
            this.real += complexVector.imag(i);
            this.imag -= complexVector.real(i);
        }

        public void subtractTimesIInto(MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            mutableComplex2.real = this.real + mutableComplex.imag;
            mutableComplex2.imag = this.imag - mutableComplex.real;
        }

        public void subtractInto(MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            mutableComplex2.real = this.real - mutableComplex.real;
            mutableComplex2.imag = this.imag - mutableComplex.imag;
        }

        public void add(MutableComplex mutableComplex) {
            this.real += mutableComplex.real;
            this.imag += mutableComplex.imag;
        }

        public void addTimesI(MutableComplex mutableComplex) {
            this.real -= mutableComplex.imag;
            this.imag += mutableComplex.real;
        }

        public void subtract(MutableComplex mutableComplex) {
            this.real -= mutableComplex.real;
            this.imag -= mutableComplex.imag;
        }

        public void subtractTimesI(MutableComplex mutableComplex) {
            this.real += mutableComplex.imag;
            this.imag -= mutableComplex.real;
        }
    }
}
