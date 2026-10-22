package org.bouncycastle.crypto.engines;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class DSTU7624Engine implements BlockCipher {
    private static final int ROUNDS_128 = 10;
    private static final int ROUNDS_256 = 14;
    private static final int ROUNDS_512 = 18;
    private static final byte[] S0 = {-88, 67, 95, 6, 107, 117, 108, 89, 113, -33, -121, -107, 23, -16, -40, 9, 109, -13, 29, -53, -55, 77, 44, -81, 121, -32, -105, -3, 111, 75, 69, 57, 62, -35, -93, 79, -76, -74, -102, 14, 31, -65, 21, -31, 73, -46, -109, -58, -110, 114, -98, 97, -47, 99, -6, -18, -12, 25, -43, -83, 88, -92, -69, -95, -36, -14, -125, 55, 66, -28, 122, 50, -100, -52, -85, 74, -113, 110, 4, 39, 46, -25, -30, 90, -106, 22, 35, 43, -62, 101, 102, 15, PSSSigner.TRAILER_IMPLICIT, -87, 71, 65, 52, 72, -4, -73, 106, -120, -91, 83, -122, -7, 91, -37, 56, 123, -61, 30, 34, 51, 36, 40, 54, -57, -78, 59, -114, 119, -70, -11, 20, -97, 8, 85, -101, 76, -2, 96, 92, -38, 24, 70, -51, 125, 33, -80, 63, 27, -119, -1, -21, -124, 105, 58, -99, -41, -45, 112, 103, 64, -75, -34, 93, 48, -111, -79, 120, 17, 1, -27, 0, 104, -104, -96, -59, 2, -90, 116, 45, 11, -94, 118, -77, -66, -50, -67, -82, -23, -118, 49, 28, -20, -15, -103, -108, -86, -10, 38, 47, -17, -24, -116, 53, 3, -44, AbstractJsonLexerKt.TC_INVALID, -5, 5, -63, 94, -112, 32, 61, -126, -9, -22, 10, 13, 126, -8, 80, 26, -60, 7, 87, -72, 60, 98, -29, -56, -84, 82, 100, 16, -48, -39, 19, 12, 18, 41, 81, -71, -49, -42, 115, -115, -127, 84, -64, -19, 78, 68, -89, 42, -123, 37, -26, -54, 124, -117, 86, -128};
    private static final byte[] S1 = {-50, -69, -21, -110, -22, -53, 19, -63, -23, 58, -42, -78, -46, -112, 23, -8, 66, 21, 86, -76, 101, 28, -120, 67, -59, 92, 54, -70, -11, 87, 103, -115, 49, -10, 100, 88, -98, -12, 34, -86, 117, 15, 2, -79, -33, 109, 115, 77, 124, 38, 46, -9, 8, 93, 68, 62, -97, 20, -56, -82, 84, 16, -40, PSSSigner.TRAILER_IMPLICIT, 26, 107, 105, -13, -67, 51, -85, -6, -47, -101, 104, 78, 22, -107, -111, -18, 76, 99, -114, 91, -52, 60, 25, -95, -127, 73, 123, -39, 111, 55, 96, -54, -25, 43, 72, -3, -106, 69, -4, 65, 18, 13, 121, -27, -119, -116, -29, 32, 48, -36, -73, 108, 74, -75, 63, -105, -44, 98, 45, 6, -92, -91, -125, 95, 42, -38, -55, 0, 126, -94, 85, -65, 17, -43, -100, -49, 14, 10, 61, 81, 125, -109, 27, -2, -60, 71, 9, -122, 11, -113, -99, 106, 7, -71, -80, -104, 24, 50, 113, 75, -17, 59, 112, -96, -28, 64, -1, -61, -87, -26, 120, -7, -117, 70, -128, 30, 56, -31, -72, -88, -32, 12, 35, 118, 29, 37, 36, 5, -15, 110, -108, 40, -102, -124, -24, -93, 79, 119, -45, -123, -30, 82, -14, -126, 80, 122, 47, 116, 83, -77, 97, -81, 57, 53, -34, -51, 31, -103, -84, -83, 114, 44, -35, -48, -121, -66, 94, -90, -20, 4, -58, 3, 52, -5, -37, 89, -74, -62, 1, -16, 90, -19, -89, 102, 33, AbstractJsonLexerKt.TC_INVALID, -118, 39, -57, -64, 41, -41};
    private static final byte[] S2 = {-109, -39, -102, -75, -104, 34, 69, -4, -70, 106, -33, 2, -97, -36, 81, 89, 74, 23, 43, -62, -108, -12, -69, -93, 98, -28, 113, -44, -51, 112, 22, -31, 73, 60, -64, -40, 92, -101, -83, -123, 83, -95, 122, -56, 45, -32, -47, 114, -90, 44, -60, -29, 118, 120, -73, -76, 9, 59, 14, 65, 76, -34, -78, -112, 37, -91, -41, 3, 17, 0, -61, 46, -110, -17, 78, 18, -99, 125, -53, 53, 16, -43, 79, -98, 77, -87, 85, -58, -48, 123, 24, -105, -45, 54, -26, 72, 86, -127, -113, 119, -52, -100, -71, -30, -84, -72, 47, 21, -92, 124, -38, 56, 30, 11, 5, -42, 20, 110, 108, 126, 102, -3, -79, -27, 96, -81, 94, 51, -121, -55, -16, 93, 109, 63, -120, -115, -57, -9, 29, -23, -20, -19, -128, 41, 39, -49, -103, -88, 80, 15, 55, 36, 40, 48, -107, -46, 62, 91, 64, -125, -77, 105, 87, 31, 7, 28, -118, PSSSigner.TRAILER_IMPLICIT, 32, -21, -50, -114, -85, -18, 49, -94, 115, -7, -54, 58, 26, -5, 13, -63, -2, -6, -14, 111, -67, -106, -35, 67, 82, -74, 8, -13, -82, -66, 25, -119, 50, 38, -80, -22, 75, 100, -124, -126, 107, -11, 121, -65, 1, 95, 117, 99, 27, 35, 61, 104, 42, 101, -24, -111, -10, -1, 19, 88, -15, 71, 10, AbstractJsonLexerKt.TC_INVALID, -59, -89, -25, 97, 90, 6, 70, 68, 66, 4, -96, -37, 57, -122, 84, -86, -116, 52, 33, -117, -8, 12, 116, 103};
    private static final byte[] S3 = {104, -115, -54, 77, 115, 75, 78, 42, -44, 82, 38, -77, 84, 30, 25, 31, 34, 3, 70, 61, 45, 74, 83, -125, 19, -118, -73, -43, 37, 121, -11, -67, 88, 47, 13, 2, -19, 81, -98, 17, -14, 62, 85, 94, -47, 22, 60, 102, 112, 93, -13, 69, 64, -52, -24, -108, 86, 8, -50, 26, 58, -46, -31, -33, -75, 56, 110, 14, -27, -12, -7, -122, -23, 79, -42, -123, 35, -49, 50, -103, 49, 20, -82, -18, -56, 72, -45, 48, -95, -110, 65, -79, 24, -60, 44, 113, 114, 68, 21, -3, 55, -66, 95, -86, -101, -120, -40, -85, -119, -100, -6, 96, -22, PSSSigner.TRAILER_IMPLICIT, 98, 12, 36, -90, -88, -20, 103, 32, -37, 124, 40, -35, -84, 91, 52, 126, 16, -15, 123, -113, 99, -96, 5, -102, 67, 119, 33, -65, 39, 9, -61, -97, -74, -41, 41, -62, -21, -64, -92, -117, -116, 29, -5, -1, -63, -78, -105, 46, -8, 101, -10, 117, 7, 4, 73, 51, -28, -39, -71, -48, 66, -57, 108, -112, 0, -114, 111, 80, 1, -59, -38, 71, 63, -51, 105, -94, -30, 122, -89, -58, -109, 15, 10, 6, -26, 43, -106, -93, 28, -81, 106, 18, -124, 57, -25, -80, -126, -9, -2, -99, -121, 92, -127, 53, -34, -76, -91, -4, -128, -17, -53, -69, 107, 118, -70, 90, 125, 120, 11, -107, -29, -83, 116, -104, 59, 54, 100, 109, -36, -16, 89, -87, 76, 23, AbstractJsonLexerKt.TC_INVALID, -111, -72, -55, 87, 27, -32, 97};
    private static final byte[] T0 = {-92, -94, -87, -59, 78, -55, 3, -39, 126, 15, -46, -83, -25, -45, 39, 91, -29, -95, -24, -26, 124, 42, 85, 12, -122, 57, -41, -115, -72, 18, 111, 40, -51, -118, 112, 86, 114, -7, -65, 79, 115, -23, -9, 87, 22, -84, 80, -64, -99, -73, 71, 113, 96, -60, 116, 67, 108, 31, -109, 119, -36, -50, 32, -116, -103, 95, 68, 1, -11, 30, -121, 94, 97, 44, 75, 29, -127, 21, -12, 35, -42, -22, -31, 103, -15, AbstractJsonLexerKt.TC_INVALID, -2, -38, 60, 7, 83, 106, -124, -100, -53, 2, -125, 51, -35, 53, -30, 89, 90, -104, -91, -110, 100, 4, 6, 16, 77, 28, -105, 8, 49, -18, -85, 5, -81, 121, -96, 24, 70, 109, -4, -119, -44, -57, -1, -16, -49, 66, -111, -8, 104, 10, 101, -114, -74, -3, -61, -17, 120, 76, -52, -98, 48, 46, PSSSigner.TRAILER_IMPLICIT, 11, 84, 26, -90, -69, 38, -128, 72, -108, 50, 125, -89, 63, -82, 34, 61, 102, -86, -10, 0, 93, -67, 74, -32, 59, -76, 23, -117, -97, 118, -80, 36, -102, 37, 99, -37, -21, 122, 62, 92, -77, -79, 41, -14, -54, 88, 110, -40, -88, 47, 117, -33, 20, -5, 19, 73, -120, -78, -20, -28, 52, 45, -106, -58, 58, -19, -107, 14, -27, -123, 107, 64, 33, -101, 9, 25, 43, 82, -34, 69, -93, -6, 81, -62, -75, -47, -112, -71, -13, 55, -63, 13, -70, 65, 17, 56, 123, -66, -48, -43, 105, 54, -56, 98, 27, -126, -113};
    private static final byte[] T1 = {-125, -14, 42, -21, -23, -65, 123, -100, 52, -106, -115, -104, -71, 105, -116, 41, 61, -120, 104, 6, 57, 17, 76, 14, -96, 86, 64, -110, 21, PSSSigner.TRAILER_IMPLICIT, -77, -36, 111, -8, 38, -70, -66, -67, 49, -5, -61, -2, -128, 97, -31, 122, 50, -46, 112, 32, -95, 69, -20, -39, 26, 93, -76, -40, 9, -91, 85, -114, 55, 118, -87, 103, 16, 23, 54, 101, -79, -107, 98, 89, 116, -93, 80, 47, 75, -56, -48, -113, -51, -44, 60, -122, 18, 29, 35, -17, -12, 83, 25, 53, -26, AbstractJsonLexerKt.TC_INVALID, 94, -42, 121, 81, 34, 20, -9, 30, 74, 66, -101, 65, 115, 45, -63, 92, -90, -94, -32, 46, -45, 40, -69, -55, -82, 106, -47, 90, 48, -112, -124, -7, -78, 88, -49, 126, -59, -53, -105, -28, 22, 108, -6, -80, 109, 31, 82, -103, 13, 78, 3, -111, -62, 77, 100, 119, -97, -35, -60, 73, -118, -102, 36, 56, -89, 87, -123, -57, 124, 125, -25, -10, -73, -84, 39, 70, -34, -33, 59, -41, -98, 43, 11, -43, 19, 117, -16, 114, -74, -99, 27, 1, 63, 68, -27, -121, -3, 7, -15, -85, -108, 24, -22, -4, 58, -126, 95, 5, 84, -37, 0, -117, -29, 72, 12, -54, 120, -119, 10, -1, 62, 91, -127, -18, 113, -30, -38, 44, -72, -75, -52, 110, -88, 107, -83, 96, -58, 8, 4, 2, -24, -11, 79, -92, -13, -64, -50, 67, 37, 28, 33, 51, 15, -81, 71, -19, 102, 99, -109, -86};
    private static final byte[] T2 = {69, -44, 11, 67, -15, 114, -19, -92, -62, 56, -26, 113, -3, -74, 58, -107, 80, 68, 75, -30, 116, 107, 30, 17, 90, -58, -76, -40, -91, -118, 112, -93, -88, -6, 5, -39, -105, 64, -55, -112, -104, -113, -36, 18, 49, 44, 71, 106, -103, -82, -56, AbstractJsonLexerKt.TC_INVALID, -7, 79, 93, -106, 111, -12, -77, 57, 33, -38, -100, -123, -98, 59, -16, -65, -17, 6, -18, -27, 95, 32, 16, -52, 60, 84, 74, 82, -108, 14, -64, 40, -10, 86, 96, -94, -29, 15, -20, -99, 36, -125, 126, -43, 124, -21, 24, -41, -51, -35, 120, -1, -37, -95, 9, -48, 118, -124, 117, -69, 29, 26, 47, -80, -2, -42, 52, 99, 53, -46, 42, 89, 109, 77, 119, -25, -114, 97, -49, -97, -50, 39, -11, -128, -122, -57, -90, -5, -8, -121, -85, 98, 63, -33, 72, 0, 20, -102, -67, 91, 4, -110, 2, 37, 101, 76, 83, 12, -14, 41, -81, 23, 108, 65, 48, -23, -109, 85, -9, -84, 104, 38, -60, 125, -54, 122, 62, -96, 55, 3, -63, 54, 105, 102, 8, 22, -89, PSSSigner.TRAILER_IMPLICIT, -59, -45, 34, -73, 19, 70, 50, -24, 87, -120, 43, -127, -78, 78, 100, 28, -86, -111, 88, 46, -101, 92, 27, 81, 115, 66, 35, 1, 110, -13, 13, -66, 61, 10, 45, 31, 103, 51, 25, 123, 94, -22, -34, -117, -53, -87, -116, -115, -83, 73, -126, -28, -70, -61, 21, -47, -32, -119, -4, -79, -71, -75, 7, 121, -72, -31};
    private static final byte[] T3 = {-78, -74, 35, 17, -89, -120, -59, -90, 57, -113, -60, -24, 115, 34, 67, -61, -126, 39, -51, 24, 81, 98, 45, -9, 92, 14, 59, -3, -54, -101, 13, 15, 121, -116, 16, 76, 116, 28, 10, -114, 124, -108, 7, -57, 94, 20, -95, 33, 87, 80, 78, -87, -128, -39, -17, 100, 65, -49, 60, -18, 46, 19, 41, -70, 52, 90, -82, -118, 97, 51, 18, -71, 85, -88, 21, 5, -10, 3, 6, 73, -75, 37, 9, 22, 12, 42, 56, -4, 32, -12, -27, AbstractJsonLexerKt.TC_INVALID, -41, 49, 43, 102, 111, -1, 114, -122, -16, -93, 47, 120, 0, PSSSigner.TRAILER_IMPLICIT, -52, -30, -80, -15, 66, -76, 48, 95, 96, 4, -20, -91, -29, -117, -25, 29, -65, -124, 123, -26, -127, -8, -34, -40, -46, 23, -50, 75, 71, -42, 105, 108, 25, -103, -102, 1, -77, -123, -79, -7, 89, -62, 55, -23, -56, -96, -19, 79, -119, 104, 109, -43, 38, -111, -121, 88, -67, -55, -104, -36, 117, -64, 118, -11, 103, 107, 126, -21, 82, -53, -47, 91, -97, 11, -37, 64, -110, 26, -6, -84, -28, -31, 113, 31, 101, -115, -105, -98, -107, -112, 93, -73, -63, -81, 84, -5, 2, -32, 53, -69, 58, 77, -83, 44, 61, 86, 8, 27, 74, -109, 106, -85, -72, 122, -14, 125, -38, 63, -2, 62, -66, -22, -86, 68, -58, -48, 54, 72, 112, -106, 119, 36, 83, -33, -13, -125, 40, 50, 69, 30, -92, -45, -94, 70, 110, -100, -35, 99, -44, -99};
    private boolean forEncryption;
    private long[] internalState;
    private long[][] roundKeys;
    private int roundsAmount;
    private int wordsInBlock;
    private int wordsInKey;
    private long[] workingKey;

    public DSTU7624Engine(int i8) {
        if (i8 != 128 && i8 != 256 && i8 != 512) {
            throw new IllegalArgumentException("unsupported block length: only 128/256/512 are allowed");
        }
        int i9 = i8 >>> 6;
        this.wordsInBlock = i9;
        this.internalState = new long[i9];
    }

    private void addRoundKey(int i8) {
        long[] jArr = this.roundKeys[i8];
        for (int i9 = 0; i9 < this.wordsInBlock; i9++) {
            long[] jArr2 = this.internalState;
            jArr2[i9] = jArr2[i9] + jArr[i9];
        }
    }

    private void decryptBlock_128(byte[] bArr, int i8, byte[] bArr2, int i9) {
        long jLittleEndianToLong = Pack.littleEndianToLong(bArr, i8);
        long jLittleEndianToLong2 = Pack.littleEndianToLong(bArr, i8 + 8);
        long[][] jArr = this.roundKeys;
        int i10 = this.roundsAmount;
        long[] jArr2 = jArr[i10];
        boolean z = false;
        long j4 = jLittleEndianToLong - jArr2[0];
        boolean z2 = true;
        long j8 = jLittleEndianToLong2 - jArr2[1];
        while (true) {
            long jMixColumnInv = mixColumnInv(j4);
            long jMixColumnInv2 = mixColumnInv(j8);
            int i11 = (int) jMixColumnInv;
            int i12 = (int) (jMixColumnInv >>> 32);
            int i13 = (int) jMixColumnInv2;
            int i14 = (int) (jMixColumnInv2 >>> 32);
            byte[] bArr3 = T0;
            byte b9 = bArr3[i11 & 255];
            byte[] bArr4 = T1;
            byte b10 = bArr4[(i11 >>> 8) & 255];
            byte[] bArr5 = T2;
            boolean z8 = z;
            byte b11 = bArr5[(i11 >>> 16) & 255];
            byte[] bArr6 = T3;
            int i15 = (bArr6[i11 >>> 24] << 24) | ((b11 & 255) << 16) | (b9 & 255) | ((b10 & 255) << 8);
            byte b12 = bArr3[i14 & 255];
            byte b13 = bArr4[(i14 >>> 8) & 255];
            byte b14 = bArr5[(i14 >>> 16) & 255];
            boolean z9 = z2;
            long j9 = (i15 & 4294967295L) | (((bArr6[i14 >>> 24] << 24) | (((b12 & 255) | ((b13 & 255) << 8)) | ((b14 & 255) << 16))) << 32);
            int i16 = (bArr6[i13 >>> 24] << 24) | (bArr3[i13 & 255] & 255) | ((bArr4[(i13 >>> 8) & 255] & 255) << 8) | ((bArr5[(i13 >>> 16) & 255] & 255) << 16);
            byte b15 = bArr3[i12 & 255];
            byte b16 = bArr4[(i12 >>> 8) & 255];
            byte b17 = bArr5[(i12 >>> 16) & 255];
            long j10 = (i16 & 4294967295L) | (((bArr6[i12 >>> 24] << 24) | (((b15 & 255) | ((b16 & 255) << 8)) | ((b17 & 255) << 16))) << 32);
            i10--;
            if (i10 == 0) {
                long[] jArr3 = this.roundKeys[z8 ? 1 : 0];
                long j11 = j9 - jArr3[z8 ? 1 : 0];
                long j12 = j10 - jArr3[z9 ? 1 : 0];
                Pack.longToLittleEndian(j11, bArr2, i9);
                Pack.longToLittleEndian(j12, bArr2, i9 + 8);
                return;
            }
            long[] jArr4 = this.roundKeys[i10];
            long j13 = jArr4[z8 ? 1 : 0] ^ j9;
            j8 = j10 ^ jArr4[z9 ? 1 : 0];
            j4 = j13;
            z = z8 ? 1 : 0;
            z2 = z9 ? 1 : 0;
        }
    }

    private void encryptBlock_128(byte[] bArr, int i8, byte[] bArr2, int i9) {
        long jLittleEndianToLong = Pack.littleEndianToLong(bArr, i8);
        long jLittleEndianToLong2 = Pack.littleEndianToLong(bArr, i8 + 8);
        boolean z = false;
        long[] jArr = this.roundKeys[0];
        long j4 = jLittleEndianToLong + jArr[0];
        boolean z2 = true;
        long j8 = jLittleEndianToLong2 + jArr[1];
        int i10 = 0;
        while (true) {
            int i11 = (int) j4;
            int i12 = (int) (j4 >>> 32);
            int i13 = (int) j8;
            int i14 = (int) (j8 >>> 32);
            byte[] bArr3 = S0;
            byte b9 = bArr3[i11 & 255];
            byte[] bArr4 = S1;
            byte b10 = bArr4[(i11 >>> 8) & 255];
            byte[] bArr5 = S2;
            boolean z8 = z;
            byte b11 = bArr5[(i11 >>> 16) & 255];
            byte[] bArr6 = S3;
            int i15 = ((b11 & 255) << 16) | (b9 & 255) | ((b10 & 255) << 8) | (bArr6[i11 >>> 24] << 24);
            byte b12 = bArr3[i14 & 255];
            byte b13 = bArr4[(i14 >>> 8) & 255];
            byte b14 = bArr5[(i14 >>> 16) & 255];
            boolean z9 = z2;
            long j9 = (i15 & 4294967295L) | (((bArr6[i14 >>> 24] << 24) | (((b12 & 255) | ((b13 & 255) << 8)) | ((b14 & 255) << 16))) << 32);
            int i16 = (bArr6[i13 >>> 24] << 24) | (bArr3[i13 & 255] & 255) | ((bArr4[(i13 >>> 8) & 255] & 255) << 8) | ((bArr5[(i13 >>> 16) & 255] & 255) << 16);
            byte b15 = bArr3[i12 & 255];
            byte b16 = bArr4[(i12 >>> 8) & 255];
            byte b17 = bArr5[(i12 >>> 16) & 255];
            long j10 = (i16 & 4294967295L) | (((bArr6[i12 >>> 24] << 24) | (((b15 & 255) | ((b16 & 255) << 8)) | ((b17 & 255) << 16))) << 32);
            long jMixColumn = mixColumn(j9);
            long jMixColumn2 = mixColumn(j10);
            i10++;
            int i17 = this.roundsAmount;
            if (i10 == i17) {
                long[] jArr2 = this.roundKeys[i17];
                long j11 = jMixColumn + jArr2[z8 ? 1 : 0];
                long j12 = jMixColumn2 + jArr2[z9 ? 1 : 0];
                Pack.longToLittleEndian(j11, bArr2, i9);
                Pack.longToLittleEndian(j12, bArr2, i9 + 8);
                return;
            }
            long[] jArr3 = this.roundKeys[i10];
            long j13 = jMixColumn ^ jArr3[z8 ? 1 : 0];
            j8 = jMixColumn2 ^ jArr3[z9 ? 1 : 0];
            j4 = j13;
            z = z8 ? 1 : 0;
            z2 = z9 ? 1 : 0;
        }
    }

    private void invShiftRows() {
        int i8 = this.wordsInBlock;
        if (i8 == 2) {
            long[] jArr = this.internalState;
            long j4 = jArr[0];
            long j8 = jArr[1];
            long j9 = (j4 ^ j8) & (-4294967296L);
            jArr[0] = j4 ^ j9;
            jArr[1] = j9 ^ j8;
            return;
        }
        if (i8 == 4) {
            long[] jArr2 = this.internalState;
            long j10 = jArr2[0];
            long j11 = jArr2[1];
            long j12 = jArr2[2];
            long j13 = jArr2[3];
            long j14 = (j10 ^ j11) & (-281470681808896L);
            long j15 = j10 ^ j14;
            long j16 = j11 ^ j14;
            long j17 = (j12 ^ j13) & (-281470681808896L);
            long j18 = j12 ^ j17;
            long j19 = j13 ^ j17;
            long j20 = (j15 ^ j18) & (-4294967296L);
            long j21 = j15 ^ j20;
            long j22 = (j16 ^ j19) & 281474976645120L;
            jArr2[0] = j21;
            jArr2[1] = j16 ^ j22;
            jArr2[2] = j18 ^ j20;
            jArr2[3] = j22 ^ j19;
            return;
        }
        if (i8 != 8) {
            throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
        }
        long[] jArr3 = this.internalState;
        long j23 = jArr3[0];
        long j24 = jArr3[1];
        long j25 = jArr3[2];
        long j26 = jArr3[3];
        long j27 = jArr3[4];
        long j28 = jArr3[5];
        long j29 = jArr3[6];
        long j30 = jArr3[7];
        long j31 = (j23 ^ j24) & (-71777214294589696L);
        long j32 = j23 ^ j31;
        long j33 = j24 ^ j31;
        long j34 = (j25 ^ j26) & (-71777214294589696L);
        long j35 = j25 ^ j34;
        long j36 = j26 ^ j34;
        long j37 = (j27 ^ j28) & (-71777214294589696L);
        long j38 = j27 ^ j37;
        long j39 = j28 ^ j37;
        long j40 = (j29 ^ j30) & (-71777214294589696L);
        long j41 = j29 ^ j40;
        long j42 = j30 ^ j40;
        long j43 = (j32 ^ j35) & (-281470681808896L);
        long j44 = j32 ^ j43;
        long j45 = j35 ^ j43;
        long j46 = (j33 ^ j36) & 72056494543077120L;
        long j47 = j33 ^ j46;
        long j48 = j36 ^ j46;
        long j49 = (j38 ^ j41) & (-281470681808896L);
        long j50 = j38 ^ j49;
        long j51 = j41 ^ j49;
        long j52 = (j39 ^ j42) & 72056494543077120L;
        long j53 = j39 ^ j52;
        long j54 = j42 ^ j52;
        long j55 = (j44 ^ j50) & (-4294967296L);
        long j56 = j44 ^ j55;
        long j57 = j50 ^ j55;
        long j58 = (j47 ^ j53) & 72057594021150720L;
        long j59 = j47 ^ j58;
        long j60 = (j45 ^ j51) & 281474976645120L;
        long j61 = j45 ^ j60;
        long j62 = j60 ^ j51;
        long j63 = (j48 ^ j54) & 1099511627520L;
        jArr3[0] = j56;
        jArr3[1] = j59;
        jArr3[2] = j61;
        jArr3[3] = j48 ^ j63;
        jArr3[4] = j57;
        jArr3[5] = j53 ^ j58;
        jArr3[6] = j62;
        jArr3[7] = j54 ^ j63;
    }

    private void invSubBytes() {
        for (int i8 = 0; i8 < this.wordsInBlock; i8++) {
            long[] jArr = this.internalState;
            long j4 = jArr[i8];
            int i9 = (int) j4;
            int i10 = (int) (j4 >>> 32);
            byte[] bArr = T0;
            byte b9 = bArr[i9 & 255];
            byte[] bArr2 = T1;
            byte b10 = bArr2[(i9 >>> 8) & 255];
            byte[] bArr3 = T2;
            byte b11 = bArr3[(i9 >>> 16) & 255];
            int i11 = (T3[i9 >>> 24] << 24) | (b9 & 255) | ((b10 & 255) << 8) | ((b11 & 255) << 16);
            byte b12 = bArr[i10 & 255];
            byte b13 = bArr2[(i10 >>> 8) & 255];
            byte b14 = bArr3[(i10 >>> 16) & 255];
            jArr[i8] = (i11 & 4294967295L) | (((r11[i10 >>> 24] << 24) | (((b12 & 255) | ((b13 & 255) << 8)) | ((b14 & 255) << 16))) << 32);
        }
    }

    private static long mixColumn(long j4) {
        long jMulX = mulX(j4);
        long jRotate = rotate(8, j4) ^ j4;
        long jRotate2 = (jRotate ^ rotate(16, jRotate)) ^ rotate(48, j4);
        return ((rotate(32, mulX2((j4 ^ jRotate2) ^ jMulX)) ^ jRotate2) ^ rotate(40, jMulX)) ^ rotate(48, jMulX);
    }

    private static long mixColumnInv(long j4) {
        long jRotate = rotate(8, j4) ^ j4;
        long jRotate2 = (jRotate ^ rotate(32, jRotate)) ^ rotate(48, j4);
        long j8 = jRotate2 ^ j4;
        long jRotate3 = rotate(48, j4);
        long jRotate4 = rotate(56, j4);
        long jMulX = mulX(j8 ^ jRotate4) ^ rotate(56, j8);
        long jMulX2 = mulX(rotate(40, mulX(jMulX) ^ j4) ^ (rotate(16, j8) ^ j4)) ^ (j8 ^ jRotate3);
        return mulX(rotate(40, ((j4 ^ rotate(32, j8)) ^ jRotate4) ^ mulX(((jRotate3 ^ (rotate(24, j4) ^ j8)) ^ jRotate4) ^ mulX(mulX(jMulX2) ^ rotate(16, jRotate2))))) ^ jRotate2;
    }

    private void mixColumns() {
        for (int i8 = 0; i8 < this.wordsInBlock; i8++) {
            long[] jArr = this.internalState;
            jArr[i8] = mixColumn(jArr[i8]);
        }
    }

    private void mixColumnsInv() {
        for (int i8 = 0; i8 < this.wordsInBlock; i8++) {
            long[] jArr = this.internalState;
            jArr[i8] = mixColumnInv(jArr[i8]);
        }
    }

    private static long mulX(long j4) {
        return (((j4 & (-9187201950435737472L)) >>> 7) * 29) ^ ((9187201950435737471L & j4) << 1);
    }

    private static long mulX2(long j4) {
        return (((j4 & 4629771061636907072L) >>> 6) * 29) ^ (((4557430888798830399L & j4) << 2) ^ ((((-9187201950435737472L) & j4) >>> 6) * 29));
    }

    private static long rotate(int i8, long j4) {
        return (j4 << (-i8)) | (j4 >>> i8);
    }

    private void rotateLeft(long[] jArr, long[] jArr2) {
        int i8 = this.wordsInBlock;
        if (i8 == 2) {
            long j4 = jArr[0];
            long j8 = jArr[1];
            jArr2[0] = (j4 >>> 56) | (j8 << 8);
            jArr2[1] = (j4 << 8) | (j8 >>> 56);
            return;
        }
        if (i8 == 4) {
            long j9 = jArr[0];
            long j10 = jArr[1];
            long j11 = jArr[2];
            long j12 = jArr[3];
            jArr2[0] = (j10 >>> 24) | (j11 << 40);
            jArr2[1] = (j11 >>> 24) | (j12 << 40);
            jArr2[2] = (j12 >>> 24) | (j9 << 40);
            jArr2[3] = (j9 >>> 24) | (j10 << 40);
            return;
        }
        if (i8 != 8) {
            throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
        }
        long j13 = jArr[0];
        long j14 = jArr[1];
        long j15 = jArr[2];
        long j16 = jArr[3];
        long j17 = jArr[4];
        long j18 = jArr[5];
        long j19 = jArr[6];
        long j20 = jArr[7];
        jArr2[0] = (j15 >>> 24) | (j16 << 40);
        jArr2[1] = (j16 >>> 24) | (j17 << 40);
        jArr2[2] = (j17 >>> 24) | (j18 << 40);
        jArr2[3] = (j18 >>> 24) | (j19 << 40);
        jArr2[4] = (j19 >>> 24) | (j20 << 40);
        jArr2[5] = (j20 >>> 24) | (j13 << 40);
        jArr2[6] = (j13 >>> 24) | (j14 << 40);
        jArr2[7] = (j14 >>> 24) | (j15 << 40);
    }

    private void shiftRows() {
        int i8 = this.wordsInBlock;
        if (i8 == 2) {
            long[] jArr = this.internalState;
            long j4 = jArr[0];
            long j8 = jArr[1];
            long j9 = (j4 ^ j8) & (-4294967296L);
            jArr[0] = j4 ^ j9;
            jArr[1] = j9 ^ j8;
            return;
        }
        if (i8 == 4) {
            long[] jArr2 = this.internalState;
            long j10 = jArr2[0];
            long j11 = jArr2[1];
            long j12 = jArr2[2];
            long j13 = jArr2[3];
            long j14 = (j10 ^ j12) & (-4294967296L);
            long j15 = j10 ^ j14;
            long j16 = j12 ^ j14;
            long j17 = (j11 ^ j13) & 281474976645120L;
            long j18 = j11 ^ j17;
            long j19 = j13 ^ j17;
            long j20 = (j15 ^ j18) & (-281470681808896L);
            long j21 = (j16 ^ j19) & (-281470681808896L);
            jArr2[0] = j15 ^ j20;
            jArr2[1] = j18 ^ j20;
            jArr2[2] = j16 ^ j21;
            jArr2[3] = j19 ^ j21;
            return;
        }
        if (i8 != 8) {
            throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
        }
        long[] jArr3 = this.internalState;
        long j22 = jArr3[0];
        long j23 = jArr3[1];
        long j24 = jArr3[2];
        long j25 = jArr3[3];
        long j26 = jArr3[4];
        long j27 = jArr3[5];
        long j28 = jArr3[6];
        long j29 = jArr3[7];
        long j30 = (j22 ^ j26) & (-4294967296L);
        long j31 = j22 ^ j30;
        long j32 = j26 ^ j30;
        long j33 = (j23 ^ j27) & 72057594021150720L;
        long j34 = j23 ^ j33;
        long j35 = j27 ^ j33;
        long j36 = (j24 ^ j28) & 281474976645120L;
        long j37 = j24 ^ j36;
        long j38 = j28 ^ j36;
        long j39 = (j25 ^ j29) & 1099511627520L;
        long j40 = j25 ^ j39;
        long j41 = j29 ^ j39;
        long j42 = (j31 ^ j37) & (-281470681808896L);
        long j43 = j31 ^ j42;
        long j44 = j37 ^ j42;
        long j45 = (j34 ^ j40) & 72056494543077120L;
        long j46 = j34 ^ j45;
        long j47 = j40 ^ j45;
        long j48 = (j32 ^ j38) & (-281470681808896L);
        long j49 = j32 ^ j48;
        long j50 = j38 ^ j48;
        long j51 = (j35 ^ j41) & 72056494543077120L;
        long j52 = j35 ^ j51;
        long j53 = j41 ^ j51;
        long j54 = (j43 ^ j46) & (-71777214294589696L);
        long j55 = j43 ^ j54;
        long j56 = j46 ^ j54;
        long j57 = (j44 ^ j47) & (-71777214294589696L);
        long j58 = j44 ^ j57;
        long j59 = j47 ^ j57;
        long j60 = (j49 ^ j52) & (-71777214294589696L);
        long j61 = j49 ^ j60;
        long j62 = j52 ^ j60;
        long j63 = (j50 ^ j53) & (-71777214294589696L);
        jArr3[0] = j55;
        jArr3[1] = j56;
        jArr3[2] = j58;
        jArr3[3] = j59;
        jArr3[4] = j61;
        jArr3[5] = j62;
        jArr3[6] = j50 ^ j63;
        jArr3[7] = j53 ^ j63;
    }

    private void subBytes() {
        for (int i8 = 0; i8 < this.wordsInBlock; i8++) {
            long[] jArr = this.internalState;
            long j4 = jArr[i8];
            int i9 = (int) j4;
            int i10 = (int) (j4 >>> 32);
            byte[] bArr = S0;
            byte b9 = bArr[i9 & 255];
            byte[] bArr2 = S1;
            byte b10 = bArr2[(i9 >>> 8) & 255];
            byte[] bArr3 = S2;
            byte b11 = bArr3[(i9 >>> 16) & 255];
            int i11 = (S3[i9 >>> 24] << 24) | (b9 & 255) | ((b10 & 255) << 8) | ((b11 & 255) << 16);
            byte b12 = bArr[i10 & 255];
            byte b13 = bArr2[(i10 >>> 8) & 255];
            byte b14 = bArr3[(i10 >>> 16) & 255];
            jArr[i8] = (i11 & 4294967295L) | (((r11[i10 >>> 24] << 24) | (((b12 & 255) | ((b13 & 255) << 8)) | ((b14 & 255) << 16))) << 32);
        }
    }

    private void subRoundKey(int i8) {
        long[] jArr = this.roundKeys[i8];
        for (int i9 = 0; i9 < this.wordsInBlock; i9++) {
            long[] jArr2 = this.internalState;
            jArr2[i9] = jArr2[i9] - jArr[i9];
        }
    }

    private void workingKeyExpandEven(long[] jArr, long[] jArr2) {
        int i8;
        int i9;
        int i10 = this.wordsInKey;
        long[] jArr3 = new long[i10];
        long[] jArr4 = new long[this.wordsInBlock];
        System.arraycopy(jArr, 0, jArr3, 0, i10);
        long j4 = 281479271743489L;
        int i11 = 0;
        while (true) {
            for (int i12 = 0; i12 < this.wordsInBlock; i12++) {
                jArr4[i12] = jArr2[i12] + j4;
            }
            for (int i13 = 0; i13 < this.wordsInBlock; i13++) {
                this.internalState[i13] = jArr3[i13] + jArr4[i13];
            }
            subBytes();
            shiftRows();
            mixColumns();
            for (int i14 = 0; i14 < this.wordsInBlock; i14++) {
                long[] jArr5 = this.internalState;
                jArr5[i14] = jArr5[i14] ^ jArr4[i14];
            }
            subBytes();
            shiftRows();
            mixColumns();
            int i15 = 0;
            while (true) {
                i8 = this.wordsInBlock;
                if (i15 >= i8) {
                    break;
                }
                long[] jArr6 = this.internalState;
                jArr6[i15] = jArr6[i15] + jArr4[i15];
                i15++;
            }
            System.arraycopy(this.internalState, 0, this.roundKeys[i11], 0, i8);
            if (this.roundsAmount == i11) {
                return;
            }
            if (this.wordsInBlock != this.wordsInKey) {
                i11 += 2;
                j4 <<= 1;
                for (int i16 = 0; i16 < this.wordsInBlock; i16++) {
                    jArr4[i16] = jArr2[i16] + j4;
                }
                int i17 = 0;
                while (true) {
                    int i18 = this.wordsInBlock;
                    if (i17 >= i18) {
                        break;
                    }
                    this.internalState[i17] = jArr3[i18 + i17] + jArr4[i17];
                    i17++;
                }
                subBytes();
                shiftRows();
                mixColumns();
                for (int i19 = 0; i19 < this.wordsInBlock; i19++) {
                    long[] jArr7 = this.internalState;
                    jArr7[i19] = jArr7[i19] ^ jArr4[i19];
                }
                subBytes();
                shiftRows();
                mixColumns();
                int i20 = 0;
                while (true) {
                    i9 = this.wordsInBlock;
                    if (i20 >= i9) {
                        break;
                    }
                    long[] jArr8 = this.internalState;
                    jArr8[i20] = jArr8[i20] + jArr4[i20];
                    i20++;
                }
                System.arraycopy(this.internalState, 0, this.roundKeys[i11], 0, i9);
                if (this.roundsAmount == i11) {
                    return;
                }
            }
            i11 += 2;
            j4 <<= 1;
            long j8 = jArr3[0];
            for (int i21 = 1; i21 < i10; i21++) {
                jArr3[i21 - 1] = jArr3[i21];
            }
            jArr3[i10 - 1] = j8;
        }
    }

    private void workingKeyExpandKT(long[] jArr, long[] jArr2) {
        int i8 = this.wordsInBlock;
        long[] jArr3 = new long[i8];
        long[] jArr4 = new long[i8];
        long[] jArr5 = new long[i8];
        this.internalState = jArr5;
        long j4 = jArr5[0];
        int i9 = this.wordsInKey;
        jArr5[0] = j4 + i8 + i9 + 1;
        System.arraycopy(jArr, 0, jArr3, 0, i8);
        if (i8 == i9) {
            System.arraycopy(jArr, 0, jArr4, 0, i8);
        } else {
            int i10 = this.wordsInBlock;
            System.arraycopy(jArr, i10, jArr4, 0, i10);
        }
        int i11 = 0;
        while (true) {
            long[] jArr6 = this.internalState;
            if (i11 >= jArr6.length) {
                break;
            }
            jArr6[i11] = jArr6[i11] + jArr3[i11];
            i11++;
        }
        subBytes();
        shiftRows();
        mixColumns();
        int i12 = 0;
        while (true) {
            long[] jArr7 = this.internalState;
            if (i12 >= jArr7.length) {
                break;
            }
            jArr7[i12] = jArr7[i12] ^ jArr4[i12];
            i12++;
        }
        subBytes();
        shiftRows();
        mixColumns();
        int i13 = 0;
        while (true) {
            long[] jArr8 = this.internalState;
            if (i13 >= jArr8.length) {
                subBytes();
                shiftRows();
                mixColumns();
                System.arraycopy(this.internalState, 0, jArr2, 0, this.wordsInBlock);
                return;
            }
            jArr8[i13] = jArr8[i13] + jArr3[i13];
            i13++;
        }
    }

    private void workingKeyExpandOdd() {
        for (int i8 = 1; i8 < this.roundsAmount; i8 += 2) {
            long[][] jArr = this.roundKeys;
            rotateLeft(jArr[i8 - 1], jArr[i8]);
        }
    }

    private void xorRoundKey(int i8) {
        long[] jArr = this.roundKeys[i8];
        for (int i9 = 0; i9 < this.wordsInBlock; i9++) {
            long[] jArr2 = this.internalState;
            jArr2[i9] = jArr2[i9] ^ jArr[i9];
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "DSTU7624";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.wordsInBlock << 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008b A[LOOP:0: B:26:0x0086->B:28:0x008b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0094 A[EDGE_INSN: B:37:0x0094->B:29:0x0094 BREAK  A[LOOP:0: B:26:0x0086->B:28:0x008b], SYNTHETIC] */
    @Override // org.bouncycastle.crypto.BlockCipher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void init(boolean r7, org.bouncycastle.crypto.CipherParameters r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof org.bouncycastle.crypto.params.KeyParameter
            if (r0 == 0) goto Lbc
            r6.forEncryption = r7
            r0 = r8
            org.bouncycastle.crypto.params.KeyParameter r0 = (org.bouncycastle.crypto.params.KeyParameter) r0
            byte[] r0 = r0.getKey()
            int r1 = r0.length
            int r1 = r1 << 3
            int r2 = r6.wordsInBlock
            int r2 = r2 << 6
            r3 = 512(0x200, float:7.17E-43)
            r4 = 128(0x80, float:1.8E-43)
            r5 = 256(0x100, float:3.59E-43)
            if (r1 == r4) goto L29
            if (r1 == r5) goto L29
            if (r1 != r3) goto L21
            goto L29
        L21:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "unsupported key length: only 128/256/512 are allowed"
            r6.<init>(r7)
            throw r6
        L29:
            if (r1 == r2) goto L38
            int r2 = r2 * 2
            if (r1 != r2) goto L30
            goto L38
        L30:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Unsupported key length"
            r6.<init>(r7)
            throw r6
        L38:
            if (r1 == r4) goto L66
            if (r1 == r5) goto L54
            if (r1 == r3) goto L3f
            goto L78
        L3f:
            r2 = 18
            r6.roundsAmount = r2
            org.bouncycastle.crypto.constraints.DefaultServiceProperties r2 = new org.bouncycastle.crypto.constraints.DefaultServiceProperties
            java.lang.String r3 = r6.getAlgorithmName()
            org.bouncycastle.crypto.CryptoServicePurpose r7 = org.bouncycastle.crypto.engines.Utils.getPurpose(r7)
            r2.<init>(r3, r5, r8, r7)
        L50:
            org.bouncycastle.crypto.CryptoServicesRegistrar.checkConstraints(r2)
            goto L78
        L54:
            r2 = 14
            r6.roundsAmount = r2
            org.bouncycastle.crypto.constraints.DefaultServiceProperties r2 = new org.bouncycastle.crypto.constraints.DefaultServiceProperties
            java.lang.String r3 = r6.getAlgorithmName()
            org.bouncycastle.crypto.CryptoServicePurpose r7 = org.bouncycastle.crypto.engines.Utils.getPurpose(r7)
            r2.<init>(r3, r5, r8, r7)
            goto L50
        L66:
            r2 = 10
            r6.roundsAmount = r2
            org.bouncycastle.crypto.constraints.DefaultServiceProperties r2 = new org.bouncycastle.crypto.constraints.DefaultServiceProperties
            java.lang.String r3 = r6.getAlgorithmName()
            org.bouncycastle.crypto.CryptoServicePurpose r7 = org.bouncycastle.crypto.engines.Utils.getPurpose(r7)
            r2.<init>(r3, r4, r8, r7)
            goto L50
        L78:
            int r7 = r1 >>> 6
            r6.wordsInKey = r7
            int r7 = r6.roundsAmount
            int r7 = r7 + 1
            long[][] r7 = new long[r7][]
            r6.roundKeys = r7
            r7 = 0
            r8 = r7
        L86:
            long[][] r2 = r6.roundKeys
            int r3 = r2.length
            if (r8 >= r3) goto L94
            int r3 = r6.wordsInBlock
            long[] r3 = new long[r3]
            r2[r8] = r3
            int r8 = r8 + 1
            goto L86
        L94:
            int r8 = r6.wordsInKey
            long[] r8 = new long[r8]
            r6.workingKey = r8
            int r2 = r0.length
            int r1 = r1 >>> 3
            if (r2 != r1) goto Lb4
            org.bouncycastle.util.Pack.littleEndianToLong(r0, r7, r8)
            int r7 = r6.wordsInBlock
            long[] r7 = new long[r7]
            long[] r8 = r6.workingKey
            r6.workingKeyExpandKT(r8, r7)
            long[] r8 = r6.workingKey
            r6.workingKeyExpandEven(r8, r7)
            r6.workingKeyExpandOdd()
            return
        Lb4:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Invalid key parameter passed to DSTU7624Engine init"
            r6.<init>(r7)
            throw r6
        Lbc:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Invalid parameter passed to DSTU7624Engine init"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.DSTU7624Engine.init(boolean, org.bouncycastle.crypto.CipherParameters):void");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10;
        if (this.workingKey == null) {
            throw new IllegalStateException("DSTU7624Engine not initialised");
        }
        if (getBlockSize() + i8 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        }
        if (getBlockSize() + i9 > bArr2.length) {
            throw new OutputLengthException("Output buffer too short");
        }
        int i11 = 0;
        if (this.forEncryption) {
            if (this.wordsInBlock != 2) {
                Pack.littleEndianToLong(bArr, i8, this.internalState);
                addRoundKey(0);
                while (true) {
                    subBytes();
                    shiftRows();
                    mixColumns();
                    i11++;
                    i10 = this.roundsAmount;
                    if (i11 == i10) {
                        break;
                    }
                    xorRoundKey(i11);
                }
                addRoundKey(i10);
                Pack.longToLittleEndian(this.internalState, bArr2, i9);
            } else {
                encryptBlock_128(bArr, i8, bArr2, i9);
            }
        } else if (this.wordsInBlock != 2) {
            Pack.littleEndianToLong(bArr, i8, this.internalState);
            subRoundKey(this.roundsAmount);
            int i12 = this.roundsAmount;
            while (true) {
                mixColumnsInv();
                invShiftRows();
                invSubBytes();
                i12--;
                if (i12 == 0) {
                    break;
                }
                xorRoundKey(i12);
            }
            subRoundKey(0);
            Pack.longToLittleEndian(this.internalState, bArr2, i9);
        } else {
            decryptBlock_128(bArr, i8, bArr2, i9);
        }
        return getBlockSize();
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        Arrays.fill(this.internalState, 0L);
    }
}
